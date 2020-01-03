package t2company.com.uy.teamis.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import t2company.com.uy.teamis.ForoProjectActivity;
import t2company.com.uy.teamis.Model.Comentario;

import t2company.com.uy.teamis.Model.Respuesta;
import t2company.com.uy.teamis.Model.User;
import t2company.com.uy.teamis.R;


public class ComentarioProAdapter extends RecyclerView.Adapter<ComentarioProAdapter.ViewHolder> {

    ArrayList<Comentario> nameList = new ArrayList<>();
    ArrayList<String> image = new ArrayList<String>();
    ArrayList<Integer> counter = new ArrayList<Integer>();
    ArrayList<ArrayList<Respuesta>> itemNameList = new ArrayList<ArrayList<Respuesta>>();
    Context context;
    Dialog dialog;
    FirebaseUser fuser;
    private DatabaseReference mDatabase;
    String autorA;
    DatabaseReference mRootReference;
    DatabaseReference referenceActualU;

    public ComentarioProAdapter(Context context, ArrayList<Comentario> nameList) {
        this.nameList = nameList;
        this.itemNameList = itemNameList;
        this.context = context;
        dialog=new Dialog(context);
        fuser = FirebaseAuth.getInstance().getCurrentUser();
        referenceActualU = FirebaseDatabase.getInstance().getReference("Users").child(fuser.getUid());
        referenceActualU.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user =dataSnapshot.getValue(User.class);
                autorA= user.getUsername();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
    private ArrayList<Respuesta> respuesta(String key, final ArrayList<Respuesta> res) {

        mDatabase = FirebaseDatabase.getInstance().getReference();
        Query q = mDatabase.child("Respuesta").orderByChild("id").equalTo(key);
        q.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot datasnapshot : dataSnapshot.getChildren()){
                    Respuesta respuesta = datasnapshot.getValue(Respuesta.class);
                    res.add(respuesta);

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
return  res;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,comentario;
        ImageButton dropBtn;
        RecyclerView cardRecyclerView;
        CardView cardView;
        Button buttonResp;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.autor_or);
            comentario= itemView.findViewById(R.id.comentario);
            dropBtn = itemView.findViewById(R.id.categoryExpandBtn);
            cardRecyclerView = itemView.findViewById(R.id.innerRecyclerView);
            cardView = itemView.findViewById(R.id.foro_card_view);
            buttonResp= itemView.findViewById(R.id.buttonResp);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comentario_item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(v);
        dialog.setContentView(R.layout.coment_popup);

        viewHolder.buttonResp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView autor_o=(TextView) dialog.findViewById(R.id.autor_o);
                TextView titulo_o=(TextView)dialog.findViewById(R.id.titulo_o);
                TextView txtclose =(TextView) dialog.findViewById(R.id.txtclose);
                ImageButton btnEnviar = (ImageButton) dialog.findViewById(R.id.btn_send);
                titulo_o.setText("Escribe una respuesta");
                autor_o.setText("De : "+ nameList.get(viewHolder.getAdapterPosition()).getUsuario());
                txtclose.setText("X");
                EditText descrip=(EditText)dialog.findViewById(R.id.text_send);
                descrip.setHint("Escriba una Respuesta");
                btnEnviar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EditText descrip=(EditText)dialog.findViewById(R.id.text_send);
                        descrip.setHint("Escriba una Respuesta");
                        String AutorOriginal = autorA;
                        String comentario= descrip.getText().toString();
                        if (!comentario.isEmpty()) {
                            cargarDatosFirebase(AutorOriginal, comentario,nameList.get(viewHolder.getAdapterPosition()).getKey());
                        }else {
                            Toast.makeText(context,"Escriba una respuesta" , Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                txtclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        ComentarioProAdapter.ViewHolder vh = new ComentarioProAdapter.ViewHolder(v);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Comentario com=nameList.get(position);
        holder.name.setText(com.getUsuario());
        holder.comentario.setText(com.getComentario());

        ArrayList<Respuesta> res=new ArrayList<>();
        ExpandableComentarioAdapter itemInnerRecyclerView = new ExpandableComentarioAdapter(respuesta(com.getKey(),res));
        holder.cardRecyclerView.setLayoutManager(new GridLayoutManager(context, 1));


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (holder.cardRecyclerView.getVisibility()==View.VISIBLE) {
                    holder.cardRecyclerView.setVisibility(View.GONE);
                } else {
                    holder.cardRecyclerView.setVisibility(View.VISIBLE);
                }
            }
        });
        holder.cardRecyclerView.setAdapter(itemInnerRecyclerView);

    }
    private void cargarDatosFirebase( String AutorOriginal,String comentario,String key) {
        mRootReference=FirebaseDatabase.getInstance().getReference();
        Map<String, Object> datosComentario = new HashMap<>();
        datosComentario.put("usuario",AutorOriginal);
        datosComentario.put("comentario",comentario);
        datosComentario.put("id",key);

        mRootReference.child("Respuesta").push().setValue(datosComentario);
        dialog.dismiss();
        EditText descrip=(EditText)dialog.findViewById(R.id.text_send);
        descrip.setText("");
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }


}






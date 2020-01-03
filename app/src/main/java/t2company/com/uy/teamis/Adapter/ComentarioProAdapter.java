package t2company.com.uy.teamis.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import t2company.com.uy.teamis.Model.Comentario;

import t2company.com.uy.teamis.Model.Respuesta;
import t2company.com.uy.teamis.R;


public class ComentarioProAdapter extends RecyclerView.Adapter<ComentarioProAdapter.ViewHolder> {

    ArrayList<Comentario> nameList = new ArrayList<>();
    ArrayList<String> image = new ArrayList<String>();
    ArrayList<Integer> counter = new ArrayList<Integer>();
    ArrayList<ArrayList<Respuesta>> itemNameList = new ArrayList<ArrayList<Respuesta>>();
    Context context;
    private DatabaseReference mDatabase;
    public ComentarioProAdapter(Context context, ArrayList<Comentario> nameList) {
        this.nameList = nameList;
        this.itemNameList = itemNameList;
        this.context = context;


        for (int i = 0; i < nameList.size(); i++) {
            counter.add(0);
        }


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

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.autor_or);
            comentario= itemView.findViewById(R.id.comentario);
            dropBtn = itemView.findViewById(R.id.categoryExpandBtn);
            cardRecyclerView = itemView.findViewById(R.id.innerRecyclerView);
            cardView = itemView.findViewById(R.id.foro_card_view);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comentario_item, parent, false);

        ComentarioProAdapter.ViewHolder vh = new ComentarioProAdapter.ViewHolder(v);

        return vh;

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

    @Override
    public int getItemCount() {
        return nameList.size();
    }


}






package t2company.com.uy.teamis;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import t2company.com.uy.teamis.Adapter.ComentarioProAdapter;
import t2company.com.uy.teamis.Model.Comentario;
import t2company.com.uy.teamis.Model.User;


public class ForoProjectActivity extends AppCompatActivity {

    RecyclerView expanderRecyclerView;
    Dialog myDialog;
    DatabaseReference mRootReference;
    ArrayList<Comentario> comentarioList;
    ComentarioProAdapter comentarioProAdapter;
    RecyclerView recyclerView;
    DatabaseReference reference;
    String id;
    String titulof ;
    String fechaf ;
    String autorf ;
    String categoriaf ;
    String key;
    String descripcionf;
    FirebaseUser fuser;
    private DatabaseReference mDatabase;
    String autorA;
    DatabaseReference referenceActualU;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foro);
        getIncomingIntent();
        comentarioList=new ArrayList<>();
        myDialog = new Dialog(this);
        recyclerView=findViewById(R.id.recycler_viewComent);
        recyclerView.setNestedScrollingEnabled(false);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setStackFromEnd(true);
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

        expanderRecyclerView = findViewById(R.id.recycler_viewComent);
        comentarioProAdapter =new ComentarioProAdapter(ForoProjectActivity.this, comentarioList);
        expanderRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mDatabase = FirebaseDatabase.getInstance().getReference();

        Query q = mDatabase.child("Comentario").orderByChild("id").equalTo(key);
        q.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                comentarioList.clear();
                for (DataSnapshot datasnapshot : dataSnapshot.getChildren()) {
                    Comentario comentario = datasnapshot.getValue(Comentario.class);
                    comentario.setKey(datasnapshot.getKey());
                    comentarioList.add(comentario);

                }

                comentarioProAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });

       expanderRecyclerView.setAdapter(comentarioProAdapter);
    }

    public void ShowPopup(View v) {
        TextView txtclose;
        ImageButton btnEnviar;
        final TextView autor_o;
        final TextView titulo_o;
        final EditText descrip;
        myDialog.setContentView(R.layout.coment_popup);
        autor_o=(TextView) myDialog.findViewById(R.id.autor_o);
        titulo_o=(TextView)myDialog.findViewById(R.id.titulo_o);
        descrip=(EditText)myDialog.findViewById(R.id.text_send);
        txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setText("X");
        autor_o.setText("De: " +autorA);
        titulo_o.setText("Titulo: "+titulof);
        btnEnviar = (ImageButton) myDialog.findViewById(R.id.btn_send);
        btnEnviar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String AutorOriginal = autorA;
                String comentario= descrip.getText().toString();
                if (!comentario.isEmpty()) {
                    cargarDatosFirebase(AutorOriginal, comentario);
                }else {
                    Toast.makeText(ForoProjectActivity.this,"Escriba un comentario" , Toast.LENGTH_SHORT).show();
                }
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    private void getIncomingIntent(){


        if(getIntent().hasExtra("titulo") && getIntent().hasExtra("descripcion")
                && getIntent().hasExtra("fecha") && getIntent().hasExtra("autor")
                && getIntent().hasExtra("key")&& getIntent().hasExtra("categoria")){

            titulof = getIntent().getStringExtra("titulo");
            descripcionf = getIntent().getStringExtra("descripcion");
            fechaf = getIntent().getStringExtra("fecha");
            autorf = getIntent().getStringExtra("autor");
            key = getIntent().getStringExtra("key");
            categoriaf = getIntent().getStringExtra("categoria");
            setForo(titulof,descripcionf,fechaf,autorf,categoriaf);
        }
    }
    private void setForo(String titulof, String descripcionf,String fechaf, String autorf, String categoriaf){

        TextView fecha = (TextView) findViewById(R.id.fecha);
        fecha.setText("Publicado :" +fechaf);
        TextView categoria = (TextView) findViewById(R.id.categoria);
        categoria.setText("Tematica: "+categoriaf);
        TextView autor = (TextView) findViewById(R.id.Autor);
        autor.setText("Autor: "+autorf);
        TextView titulo = (TextView) findViewById(R.id.tituloforo);
        titulo.setText("Titulo: "+titulof);
        TextView descripcion = (TextView) findViewById(R.id.descripcionforo);
        descripcion.setText("Descripción: "+descripcionf);

//        ImageView image = findViewById(R.id.image);
//        Glide.with(this)
//                .asBitmap()
//                .load(imageUrl)
//                .into(image);
    }
    private void cargarDatosFirebase( String AutorOriginal,String comentario) {
        mRootReference=FirebaseDatabase.getInstance().getReference();
        Map<String, Object> datosComentario = new HashMap<>();
        datosComentario.put("usuario",AutorOriginal);
        datosComentario.put("comentario",comentario);
        datosComentario.put("id",key);

        mRootReference.child("Comentario").push().setValue(datosComentario);
        myDialog.dismiss();
        EditText descrip=(EditText) myDialog.findViewById(R.id.text_send);
        descrip.setText("");
    }


}
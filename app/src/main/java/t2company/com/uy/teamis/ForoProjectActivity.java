package t2company.com.uy.teamis;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import t2company.com.uy.teamis.Adapter.ComentarioProAdapter;
import t2company.com.uy.teamis.Adapter.ExpandableComentarioAdapter;
import t2company.com.uy.teamis.Model.Comentario;
import t2company.com.uy.teamis.Model.User;

public class ForoProjectActivity extends AppCompatActivity {

    RecyclerView expanderRecyclerView;
    Dialog myDialog;
    DatabaseReference mRootReference;
    List<Comentario> comentarioList;
    ComentarioProAdapter comentarioProAdapter;
    RecyclerView recyclerView;
    DatabaseReference reference;
    String titulof ;
    String fechaf ;
    String autorf ;
    String categoriaf ;
    String descripcionf;
    FirebaseUser fuser;
    String autorA;
    DatabaseReference referenceActualU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_foro);

        expanderRecyclerView = findViewById(R.id.recycler_viewComent);

        initiateExpander();

    }


    private void initiateExpander() {

        ArrayList<String> parentList = new ArrayList<>();
        ArrayList<ArrayList> childListHolder = new ArrayList<>();

        parentList.add("Fruits & Vegetables");
        parentList.add("Beverages & Health");
        parentList.add("Home & Kitchen");
        parentList.add("saludos prueba");


        ArrayList<String> childList = new ArrayList<>();
        childList.add("Apple");
        childList.add("Mango");
        childList.add("Banana");

        childListHolder.add(childList);

        childList = new ArrayList<>();
        childList.add("Red bull");
        childList.add("Maa");
        childList.add("Horlicks");

        childListHolder.add(childList);

        childList = new ArrayList<>();
        childList.add("Knife");
        childList.add("Vessels");
        childList.add("Spoons");

        childListHolder.add(childList);

        childList = new ArrayList<>();
        childList.add("hola");


        childListHolder.add(childList);

        ComentarioProAdapter expandableCategoryRecyclerViewAdapter =
                new ComentarioProAdapter(getApplicationContext(), parentList,
                        childListHolder);

        expanderRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        expanderRecyclerView.setAdapter(expandableCategoryRecyclerViewAdapter);
    }
//    Dialog myDialog;
//    DatabaseReference mRootReference;
//    List<Comentario> comentarioList;
//    ComentarioProAdapter comentarioProAdapter;
//    RecyclerView recyclerView;
//    DatabaseReference reference;
//    String titulof ;
//    String fechaf ;
//    String autorf ;
//    String categoriaf ;
//    String descripcionf;
//    FirebaseUser fuser;
//    String autorA;
//    DatabaseReference referenceActualU;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_foro);
//        myDialog = new Dialog(this);
//        recyclerView=findViewById(R.id.recycler_viewComent);
//        recyclerView.setNestedScrollingEnabled(false);
//
//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
//        linearLayoutManager.setStackFromEnd(true);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        getIncomingIntent();
//        fuser = FirebaseAuth.getInstance().getCurrentUser();
//        referenceActualU = FirebaseDatabase.getInstance().getReference("Users").child(fuser.getUid());
//
//
//        comentarioList= new ArrayList<>();
////
//        mRootReference = FirebaseDatabase.getInstance().getReference();
//        comentarioProAdapter = new ComentarioProAdapter(comentarioList);
//        recyclerView=findViewById(R.id.recycler_viewComent);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(ForoProjectActivity.this));
//
//        comentarioList =new ArrayList<>();
//        initiateExpander();
//        referenceActualU.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                User user =dataSnapshot.getValue(User.class);
//                autorA= user.getUsername();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//
//
//
//
//    }
//    private void getIncomingIntent(){
//
//
//        if(getIntent().hasExtra("titulo") && getIntent().hasExtra("descripcion")
//        && getIntent().hasExtra("fecha") && getIntent().hasExtra("autor") &&
//                getIntent().hasExtra("categoria")){
//
//             titulof = getIntent().getStringExtra("titulo");
//            descripcionf = getIntent().getStringExtra("descripcion");
//            fechaf = getIntent().getStringExtra("fecha");
//            autorf = getIntent().getStringExtra("autor");
//            categoriaf = getIntent().getStringExtra("categoria");
//            setForo(titulof,descripcionf,fechaf,autorf,categoriaf);
//        }
//    }
//    private void setForo(String titulof, String descripcionf,String fechaf, String autorf, String categoriaf){
//
//        TextView fecha = (TextView) findViewById(R.id.fecha);
//        fecha.setText("Publicado :" +fechaf);
//        TextView categoria = (TextView) findViewById(R.id.categoria);
//        categoria.setText("Tematica: "+categoriaf);
//        TextView autor = (TextView) findViewById(R.id.Autor);
//        autor.setText("Autor: "+autorf);
//        TextView titulo = (TextView) findViewById(R.id.tituloforo);
//        titulo.setText(titulof);
//        TextView descripcion = (TextView) findViewById(R.id.descripcionforo);
//        descripcion.setMovementMethod(new ScrollingMovementMethod());
//        descripcion.setText(descripcionf);
//
////        ImageView image = findViewById(R.id.image);
////        Glide.with(this)
////                .asBitmap()
////                .load(imageUrl)
////                .into(image);
//    }
//
//    private void readComentario() {
//
//        final FirebaseUser firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Comentario");
//
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                comentarioList.clear();
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    Comentario comentario = snapshot.getValue(Comentario.class);
//                    assert comentario != null;
//                        comentarioList.add(comentario);
//                }
//               // comentarioProAdapter = new ComentarioProAdapter(ForoProjectActivity.this, comentarioList);
//                recyclerView.setAdapter(comentarioProAdapter);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }
//    private void initiateExpander() {
//
//        ArrayList<String> parentList = new ArrayList<>();
//        ArrayList<ArrayList> childListHolder = new ArrayList<>();
//
//        parentList.add("Fruits & Vegetables");
//        parentList.add("Beverages & Health");
//        parentList.add("Home & Kitchen");
//
//        ArrayList<String> childList = new ArrayList<>();
//        childList.add("Apple");
//        childList.add("Mango");
//        childList.add("Banana");
//
//        childListHolder.add(childList);
//
//        childList = new ArrayList<>();
//        childList.add("Red bull");
//
//


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
        autor_o.setText(autorf);
        titulo_o.setText(titulof);
        btnEnviar = (ImageButton) myDialog.findViewById(R.id.btn_send);
        btnEnviar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String titulo = titulo_o.getText().toString();
                String emisorComentario = autorA;
                String AutorOriginal =autor_o.getText().toString();
                String comentario= descrip.getText().toString();

                cargarDatosFirebase(titulo, AutorOriginal, comentario,emisorComentario);
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
    private void cargarDatosFirebase( String titulo,String AutorOriginal,String comentario, String emisorComentario) {
        Map<String, Object> datosComentario = new HashMap<>();
        datosComentario.put("titulo",titulo);
        datosComentario.put("autorOriginal",AutorOriginal);
        datosComentario.put("comentario",comentario);
        datosComentario.put("emisorComentario",emisorComentario);



        mRootReference.child("Comentario").push().setValue(datosComentario);
        startActivity(new Intent(getApplicationContext(), ForoProjectActivity.class));
    }


}
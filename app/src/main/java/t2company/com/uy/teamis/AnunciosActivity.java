package t2company.com.uy.teamis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import t2company.com.uy.teamis.Adapter.ForoAdapter;
import t2company.com.uy.teamis.modelos.Foro;

public class AnunciosActivity extends AppCompatActivity {
    FirebaseUser user;
    CardView web;
    CardView androidd;
    CardView bd;
    CardView desktop;
    CardView otro;
    TextView titulo;
    TextView fecha;
    TextView autor;
    TextView descripcion;
    ForoAdapter foroAdapter;
    List<Foro> foroList;
    RecyclerView recyclerView;

    private DatabaseReference nDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anuncios);
        web = findViewById(R.id.web_card_view);
        androidd = findViewById(R.id.android_card_view);
        bd = findViewById(R.id.bd_card_view);
        desktop = findViewById(R.id.desktop_card_view);
        otro = findViewById(R.id.otro_card_view);
        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(AnunciosActivity.this));
        foroList= new ArrayList<>();
        foroAdapter =new ForoAdapter(foroList);
        recyclerView.setAdapter(foroAdapter);

        nDatabase = FirebaseDatabase.getInstance().getReference();
        nDatabase.child("Foro").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                foroList.removeAll(foroList);
                for (DataSnapshot datasnapshot : dataSnapshot.getChildren()) {
                    Foro foro = datasnapshot.getValue(Foro.class);
                    foroList.add(foro);
                }
                foroAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    private void readForos() {

    }


//        web.setOnClickListener(new View.OnClickListener() {
//
//        });

        public void onClick(View v){
            if (v.getId() == web.getId()) {
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Web....", Toast.LENGTH_SHORT);

                toast1.show();
            }
            if (v.getId() == androidd.getId()) {
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Android", Toast.LENGTH_SHORT);

                toast1.show();
            }
        }



//

}

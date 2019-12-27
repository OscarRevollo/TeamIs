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

    CardView web;
    CardView movil;
    CardView bd;
    CardView redes;
    CardView ia;
    CardView gamers;
    CardView otro;
    ForoAdapter foroAdapter;
    List<Foro> foroList;
    RecyclerView recyclerView;
    FirebaseUser fuser;

    private DatabaseReference nDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anuncios);
        web = findViewById(R.id.web_card_view);
        movil = findViewById(R.id.movil_card_view);
        bd = findViewById(R.id.bd_card_view);
        redes = findViewById(R.id.redes_card_view);
        ia = findViewById(R.id.ia_card_view);
        gamers = findViewById(R.id.gamers_card_view);
        otro = findViewById(R.id.otro_card_view);
        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(AnunciosActivity.this));
        foroList= new ArrayList<>();
        foroAdapter =new ForoAdapter(foroList);
        recyclerView.setAdapter(foroAdapter);
        fuser = FirebaseAuth.getInstance().getCurrentUser();

        nDatabase = FirebaseDatabase.getInstance().getReference();
//        nDatabase.child("Foro").addValueEventListener(new ValueEventListener() {
        web.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       Query q = nDatabase.child("Foro").orderByChild("categoria").equalTo("Programacion Web");
                                       q.addValueEventListener(new ValueEventListener() {
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
                               });
        movil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Query q = nDatabase.child("Foro").orderByChild("categoria").equalTo("Programacion Movil");
                q.addValueEventListener(new ValueEventListener() {
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
        });
        bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Query q = nDatabase.child("Foro").orderByChild("categoria").equalTo("Bases de Datos");
                q.addValueEventListener(new ValueEventListener() {
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
        });
        redes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Query q = nDatabase.child("Foro").orderByChild("categoria").equalTo("Redes");
                q.addValueEventListener(new ValueEventListener() {
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
        });
        ia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Query q = nDatabase.child("Foro").orderByChild("categoria").equalTo("Inteligencia Artificial");
                q.addValueEventListener(new ValueEventListener() {
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
        });
        gamers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Query q = nDatabase.child("Foro").orderByChild("categoria").equalTo("Gamers");
                q.addValueEventListener(new ValueEventListener() {
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
        });
        otro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Query q = nDatabase.child("Foro").orderByChild("categoria").equalTo("Otros");
                q.addValueEventListener(new ValueEventListener() {
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
        });
    }
}


//        nDatabase.child("Foro").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                foroList.removeAll(foroList);
//                for (DataSnapshot datasnapshot : dataSnapshot.getChildren()) {
//                    Foro foro = datasnapshot.getValue(Foro.class);
//                    foroList.add(foro);
//                }
//                foroAdapter.notifyDataSetChanged();
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });





//            if (v.getId() == movil.getId()) {
//                Toast toast1 =
//                        Toast.makeText(getApplicationContext(),
//                                "Android", Toast.LENGTH_SHORT);
//
//                toast1.show();
//            }


//



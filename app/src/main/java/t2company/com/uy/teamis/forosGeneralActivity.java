package t2company.com.uy.teamis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import t2company.com.uy.teamis.Adapter.ForosAdapter;
import t2company.com.uy.teamis.Fragments.ActividadesFragment;
import t2company.com.uy.teamis.Fragments.GruposFragment;
import t2company.com.uy.teamis.Fragments.ProyectosFragment;
import t2company.com.uy.teamis.Model.Foro;

public class forosGeneralActivity extends AppCompatActivity {
//
//    CardView web;
//    CardView movil;
//    CardView bd;
//    CardView redes;
//    CardView ia;
//    CardView gamers;
//    CardView otro;
//    ForosAdapter forosProjectAdapter;
//    List<Foro> foroList;
//    RecyclerView recyclerView;
//    FirebaseUser fuser;
    BottomNavigationView bottomNav;
//    private DatabaseReference nDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foros_general);
//        web = findViewById(R.id.web_card_view);
//        movil = findViewById(R.id.movil_card_view);
//        bd = findViewById(R.id.bd_card_view);
//        redes = findViewById(R.id.redes_card_view);
//        ia = findViewById(R.id.ia_card_view);
//        gamers = findViewById(R.id.gamers_card_view);
//        otro = findViewById(R.id.otro_card_view);
//        recyclerView=findViewById(R.id.recycler_view);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(forosGeneralActivity.this));
//        foroList= new ArrayList<>();
//        forosProjectAdapter =new ForosAdapter(foroList);
//        recyclerView.setAdapter(forosProjectAdapter);
        bottomNav = (BottomNavigationView)findViewById(R.id.bottom_nav);
//        fuser = FirebaseAuth.getInstance().getCurrentUser();
//
//        nDatabase = FirebaseDatabase.getInstance().getReference();
        //BottomNav abajo
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                if (menuItem.getItemId()==R.id.proyecto_icon) {
                    showSelectedFragment(new ProyectosFragment());
                }
                if (menuItem.getItemId()==R.id.Actividad_icon) {
                    showSelectedFragment(new ActividadesFragment());
                }
                if (menuItem.getItemId()==R.id.Grupo_icon) {
                    showSelectedFragment(new GruposFragment());
                }




                return true;
            }
        });
        //BottomNav arriba

//
//        web.setOnClickListener(new View.OnClickListener() {
//                                   @Override
//                                   public void onClick(View view) {
//           Query q = nDatabase.child("Foro").orderByChild("categoria").equalTo("Programacion Web");
//           q.addValueEventListener(new ValueEventListener() {
//               @Override
//               public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                   foroList.removeAll(foroList);
//                   for (DataSnapshot datasnapshot : dataSnapshot.getChildren()) {
//                       Foro foro = datasnapshot.getValue(Foro.class);
//                       foroList.add(foro);
//                   }
//                   forosProjectAdapter.notifyDataSetChanged();
//               }
//
//               @Override
//               public void onCancelled(@NonNull DatabaseError databaseError) {
//
//               }
//
//           });
//       }
//   });
//        movil.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Query q = nDatabase.child("Foro").orderByChild("categoria").equalTo("Programacion Movil");
//                q.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        foroList.removeAll(foroList);
//                        for (DataSnapshot datasnapshot : dataSnapshot.getChildren()) {
//                            Foro foro = datasnapshot.getValue(Foro.class);
//                            foroList.add(foro);
//                        }
//                        forosProjectAdapter.notifyDataSetChanged();
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                    }
//
//                });
//            }
//        });
//        bd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Query q = nDatabase.child("Foro").orderByChild("categoria").equalTo("Bases de Datos");
//                q.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        foroList.removeAll(foroList);
//                        for (DataSnapshot datasnapshot : dataSnapshot.getChildren()) {
//                            Foro foro = datasnapshot.getValue(Foro.class);
//                            foroList.add(foro);
//                        }
//                        forosProjectAdapter.notifyDataSetChanged();
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                    }
//
//                });
//            }
//        });
//        redes.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Query q = nDatabase.child("Foro").orderByChild("categoria").equalTo("Redes");
//                q.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        foroList.removeAll(foroList);
//                        for (DataSnapshot datasnapshot : dataSnapshot.getChildren()) {
//                            Foro foro = datasnapshot.getValue(Foro.class);
//                            foroList.add(foro);
//                        }
//                        forosProjectAdapter.notifyDataSetChanged();
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                    }
//
//                });
//            }
//        });
//        ia.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Query q = nDatabase.child("Foro").orderByChild("categoria").equalTo("Inteligencia Artificial");
//                q.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        foroList.removeAll(foroList);
//                        for (DataSnapshot datasnapshot : dataSnapshot.getChildren()) {
//                            Foro foro = datasnapshot.getValue(Foro.class);
//                            foroList.add(foro);
//                        }
//                        forosProjectAdapter.notifyDataSetChanged();
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                    }
//
//                });
//            }
//        });
//        gamers.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Query q = nDatabase.child("Foro").orderByChild("categoria").equalTo("Gamers");
//                q.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        foroList.removeAll(foroList);
//                        for (DataSnapshot datasnapshot : dataSnapshot.getChildren()) {
//                            Foro foro = datasnapshot.getValue(Foro.class);
//                            foroList.add(foro);
//                        }
//                        forosProjectAdapter.notifyDataSetChanged();
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                    }
//
//                });
//            }
//        });
//        otro.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Query q = nDatabase.child("Foro").orderByChild("categoria").equalTo("Otros");
//                q.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        foroList.removeAll(foroList);
//                        for (DataSnapshot datasnapshot : dataSnapshot.getChildren()) {
//                            Foro foro = datasnapshot.getValue(Foro.class);
//                            foroList.add(foro);
//                        }
//                        forosProjectAdapter.notifyDataSetChanged();
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                    }
//
//                });
//            }
//        });
    }
    //Metodo para visualizar fragment
    void showSelectedFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}





package t2company.com.uy.teamis.Fragments;


import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

import t2company.com.uy.teamis.Adapter.ForosAdapter;
import t2company.com.uy.teamis.Model.Foro;
import t2company.com.uy.teamis.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MisProyectosFragment extends Fragment {

    CardView web;
    CardView movil;
    CardView bd;
    CardView redes;
    CardView ia;
    CardView gamers;
    CardView otro;
    View vista;
    Activity misProyectos_Act;
    ForosAdapter forosAdapter;
    List<Foro> foroList;
    RecyclerView recyclerView;
    FirebaseUser fuser;
    private DatabaseReference nDatabase;

    public MisProyectosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        vista = inflater.inflate(R.layout.fragment_proyectos, container, false);
        web = vista.findViewById(R.id.web_card_view);
        movil = vista.findViewById(R.id.movil_card_view);
        bd = vista.findViewById(R.id.bd_card_view);
        redes = vista.findViewById(R.id.redes_card_view);
        ia = vista.findViewById(R.id.ia_card_view);
        gamers = vista.findViewById(R.id.gamers_card_view);
        otro = vista.findViewById(R.id.otro_card_view);

        recyclerView= (RecyclerView) vista.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        foroList= new ArrayList<>();
        forosAdapter =new ForosAdapter(foroList);
        recyclerView.setAdapter(forosAdapter);
        nDatabase = FirebaseDatabase.getInstance().getReference();
        fuser = FirebaseAuth.getInstance().getCurrentUser();
        //si quieres obtener id del usuario es :  fuser = FirebaseAuth.getInstance().getCurrentUser().getUid();

        LlenarLista();


        return vista;

    }
    public void LlenarLista(){
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Query q = nDatabase.child("Foro").orderByChild("tematica").equalTo("Programacion Web");
                q.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        foroList.removeAll(foroList);
                        for (DataSnapshot datasnapshot : dataSnapshot.getChildren()) {
                            Foro foro = datasnapshot.getValue(Foro.class);
                            foroList.add(foro);
                        }
                        forosAdapter.notifyDataSetChanged();
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
                Query q = nDatabase.child("Foro").orderByChild("tematica").equalTo("Programacion Movil");
                q.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        foroList.removeAll(foroList);
                        for (DataSnapshot datasnapshot : dataSnapshot.getChildren()) {
                            Foro foro = datasnapshot.getValue(Foro.class);
                            foroList.add(foro);
                        }
                        forosAdapter.notifyDataSetChanged();
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
                Query q = nDatabase.child("Foro").orderByChild("tematica").equalTo("Bases de Datos");
                q.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        foroList.removeAll(foroList);
                        for (DataSnapshot datasnapshot : dataSnapshot.getChildren()) {
                            Foro foro = datasnapshot.getValue(Foro.class);
                            foroList.add(foro);
                        }
                        forosAdapter.notifyDataSetChanged();
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
                Query q = nDatabase.child("Foro").orderByChild("tematica").equalTo("Redes");
                q.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        foroList.removeAll(foroList);
                        for (DataSnapshot datasnapshot : dataSnapshot.getChildren()) {
                            Foro foro = datasnapshot.getValue(Foro.class);
                            foroList.add(foro);
                        }
                        forosAdapter.notifyDataSetChanged();
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
                Query q = nDatabase.child("Foro").orderByChild("tematica").equalTo("Inteligencia Artificial");
                q.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        foroList.removeAll(foroList);
                        for (DataSnapshot datasnapshot : dataSnapshot.getChildren()) {
                            Foro foro = datasnapshot.getValue(Foro.class);
                            foroList.add(foro);
                        }
                        forosAdapter.notifyDataSetChanged();
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
                Query q = nDatabase.child("Foro").orderByChild("tematica").equalTo("Gamers");
                q.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        foroList.removeAll(foroList);
                        for (DataSnapshot datasnapshot : dataSnapshot.getChildren()) {
                            Foro foro = datasnapshot.getValue(Foro.class);
                            foroList.add(foro);
                        }
                        forosAdapter.notifyDataSetChanged();
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
                Query q = nDatabase.child("Foro").orderByChild("tematica").equalTo("Otros");
                q.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        foroList.removeAll(foroList);
                        for (DataSnapshot datasnapshot : dataSnapshot.getChildren()) {
                            Foro foro = datasnapshot.getValue(Foro.class);
                            foroList.add(foro);
                        }
                        forosAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
            }
        });

    }


}

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
import android.widget.ImageView;

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
import t2company.com.uy.teamis.Adapter.MisForosAdapter;
import t2company.com.uy.teamis.MainActivity;
import t2company.com.uy.teamis.Model.Foro;
import t2company.com.uy.teamis.Model.User;
import t2company.com.uy.teamis.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MisProyectosFragment extends Fragment {
    String username;
    CardView web;
    CardView movil;
    CardView bd;
    CardView redes;
    CardView ia;
    CardView gamers;
    CardView otro;
    View vista;
    Activity misProyectos_Act;
    MisForosAdapter forosAdapter;
    List<Foro> foroList;
    RecyclerView recyclerView;
    FirebaseUser fuser;
    ImageView delete;
    private DatabaseReference nDatabase;
    DatabaseReference reference;

    public MisProyectosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        vista = inflater.inflate(R.layout.fragment_mis_proyectos, container, false);
        web = vista.findViewById(R.id.web_card_view);
        movil = vista.findViewById(R.id.movil_card_view);
        bd = vista.findViewById(R.id.bd_card_view);
        redes = vista.findViewById(R.id.redes_card_view);
        ia = vista.findViewById(R.id.ia_card_view);
        gamers = vista.findViewById(R.id.gamers_card_view);
        otro = vista.findViewById(R.id.otro_card_view);

        recyclerView= (RecyclerView) vista.findViewById(R.id.recycler_view1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        foroList= new ArrayList<>();
        forosAdapter =new MisForosAdapter(foroList);
        recyclerView.setAdapter(forosAdapter);
        nDatabase = FirebaseDatabase.getInstance().getReference();

        nDatabase = FirebaseDatabase.getInstance().getReference();
        fuser = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users").child(fuser.getUid());

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                User user =dataSnapshot.getValue(User.class);
                username= user.getUsername();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        LlenarLista();


        return vista;

    }
    //    public void removeItem(int position) {
//       foroList.remove(position);
//        MisForosAdapter.notifyItemRemoved(position);
//    }
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
                            foro.setKey (datasnapshot.getKey());
                            if(foro.getAutor().equals(username)){
                                foroList.add(foro);
                            }

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
                            foro.setKey (datasnapshot.getKey());
                            if(foro.getAutor().equals(username)){
                                foroList.add(foro);
                            }
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
                            foro.setKey (datasnapshot.getKey());
                            if(foro.getAutor().equals(username)){
                                foroList.add(foro);
                            }
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
                            foro.setKey (datasnapshot.getKey());
                            if(foro.getAutor().equals(username)){
                                foroList.add(foro);
                            }
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
                            foro.setKey (datasnapshot.getKey());
                            if(foro.getAutor().equals(username)){
                                foroList.add(foro);
                            }
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
                            foro.setKey (datasnapshot.getKey());
                            if(foro.getAutor().equals(username)){
                                foroList.add(foro);
                            }
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
                            foro.setKey (datasnapshot.getKey());
                            if(foro.getAutor().equals(username)){
                                foroList.add(foro);
                            }
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
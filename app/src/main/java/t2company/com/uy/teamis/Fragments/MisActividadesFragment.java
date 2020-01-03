package t2company.com.uy.teamis.Fragments;


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
import t2company.com.uy.teamis.Adapter.MisForosAdapter;
import t2company.com.uy.teamis.Model.Foro;
import t2company.com.uy.teamis.Model.User;
import t2company.com.uy.teamis.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MisActividadesFragment extends Fragment {
    String username;
    CardView juego;
    CardView academico;
    CardView deporte;
    CardView otro;
    View vista;
    MisForosAdapter forosAdapter;
    List<Foro> foroList;
    RecyclerView recyclerView;
    FirebaseUser fuser;
    private DatabaseReference nDatabase;
    DatabaseReference reference;

    public MisActividadesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_mis_actividades, container, false);
        juego = vista.findViewById(R.id.juego_card_view);
        deporte = vista.findViewById(R.id.deporte_card_view);
        academico=vista.findViewById(R.id.academico_card_view);
        otro = vista.findViewById(R.id.otro_card_view);
        recyclerView= (RecyclerView) vista.findViewById(R.id.recycler_view1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        foroList= new ArrayList<>();
        forosAdapter =new MisForosAdapter(foroList);
        recyclerView.setAdapter(forosAdapter);
        nDatabase = FirebaseDatabase.getInstance().getReference();



        fuser = FirebaseAuth.getInstance().getCurrentUser();
        //si quieres obtener id del usuario es :  fuser = FirebaseAuth.getInstance().getCurrentUser().getUid();
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
    public void LlenarLista(){

        juego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Query q = nDatabase.child("Foro").orderByChild("tematica").equalTo("Juego");
                q.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        foroList.removeAll(foroList);
                        for (DataSnapshot datasnapshot : dataSnapshot.getChildren()) {
                            Foro foro = datasnapshot.getValue(Foro.class);
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
        academico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Query q = nDatabase.child("Foro").orderByChild("tematica").equalTo("Academico");
                q.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        foroList.removeAll(foroList);
                        for (DataSnapshot datasnapshot : dataSnapshot.getChildren()) {
                            Foro foro = datasnapshot.getValue(Foro.class);
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
        deporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Query q = nDatabase.child("Foro").orderByChild("tematica").equalTo("Deporte");
                q.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        foroList.removeAll(foroList);
                        for (DataSnapshot datasnapshot : dataSnapshot.getChildren()) {
                            Foro foro = datasnapshot.getValue(Foro.class);
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

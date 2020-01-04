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
public class MisGruposFragment extends Fragment {
    String username;
    CardView materia;
    CardView area;
    CardView otro;
    View vista;
    MisForosAdapter forosAdapter;
    List<Foro> foroList;
    RecyclerView recyclerView;
    FirebaseUser fuser;
    private DatabaseReference nDatabase;
    DatabaseReference reference;

    public MisGruposFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        vista = inflater.inflate(R.layout.fragment_mis_grupos, container, false);
        materia = vista.findViewById(R.id.materia_card_view);
        area = vista.findViewById(R.id.area_card_view);
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


        materia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Query q = nDatabase.child("Foro").orderByChild("tematica").equalTo("Materia");
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
        area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Query q = nDatabase.child("Foro").orderByChild("tematica").equalTo("Area de Interes");
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
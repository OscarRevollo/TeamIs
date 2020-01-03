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
//    FirebaseUser fuser;
    BottomNavigationView bottomNav;
//    private DatabaseReference nDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foros_general);

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

    }
    //Metodo para visualizar fragment
    void showSelectedFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}





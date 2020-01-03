package t2company.com.uy.teamis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import t2company.com.uy.teamis.Fragments.ActividadesFragment;
import t2company.com.uy.teamis.Fragments.GruposFragment;
import t2company.com.uy.teamis.Fragments.MisActividadesFragment;
import t2company.com.uy.teamis.Fragments.MisGruposFragment;
import t2company.com.uy.teamis.Fragments.MisProyectosFragment;
import t2company.com.uy.teamis.Fragments.ProyectosFragment;

public class MisForosActivity extends AppCompatActivity {
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_foros);
        bottomNav = (BottomNavigationView)findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                if (menuItem.getItemId()==R.id.proyecto_icon) {
                    showSelectedFragment(new MisProyectosFragment());
                }
                if (menuItem.getItemId()==R.id.Actividad_icon) {
                    showSelectedFragment(new MisActividadesFragment());
                }
                if (menuItem.getItemId()==R.id.Grupo_icon) {
                    showSelectedFragment(new MisGruposFragment());
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

package t2company.com.uy.teamis;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.auth.FirebaseAuth;

public class ProjectActivity extends AppCompatActivity {
    CardView crear_anuncio;
    CardView mis_anuncios;
    CardView anuncios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        initViews();
    }
    private void initViews() {
        crear_anuncio = findViewById(R.id.Crear_anuncio_card_view);
        mis_anuncios = findViewById(R.id.Mis_anuncios_card_view);
        anuncios = findViewById(R.id.anuncios_card_view);

        crear_anuncio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),CrearAnuncioActivity.class));
            }
        });
        mis_anuncios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MisAnunciosActivity.class));
            }
        });
        anuncios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AnunciosActivity.class));
            }
        });

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(ProjectActivity.this,StartActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                return true;

        }
        return false;
    }
}

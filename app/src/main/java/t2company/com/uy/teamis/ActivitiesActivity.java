package t2company.com.uy.teamis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivitiesActivity extends AppCompatActivity {
    CardView mis_actividades;
    CardView actividades;
    CardView crear_actividad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);
       initViews();
    }

    private void initViews() {
        crear_actividad = findViewById(R.id.Crear_actividad_card_view);
        mis_actividades = findViewById(R.id.Mis_actividades_card_view);
        actividades = findViewById(R.id.actividades_card_view);

        crear_actividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Crear_ActividadActivity.class));
            }
        });
        mis_actividades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Mis_ActividadesActivity.class));
            }
        });
        actividades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ActividadesActivity.class));
            }
        });

    }
}

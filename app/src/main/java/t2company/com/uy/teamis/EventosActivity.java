package t2company.com.uy.teamis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EventosActivity extends AppCompatActivity {

    CardView crearEvento;
    CardView eventos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);
        initViews();
    }
    private void initViews() {
        crearEvento = findViewById(R.id.crear_evento);
        eventos= findViewById(R.id.Eventos);


        crearEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext() ,CrearEvento.class));
            }
        });
        eventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Evento.class));
            }
        });

    }
}

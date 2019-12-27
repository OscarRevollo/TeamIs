package t2company.com.uy.teamis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GroupActivity extends AppCompatActivity {
    CardView crear_grupo;
    CardView mis_grupos;
    CardView grupos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        initViews();
    }


    private void initViews() {
        crear_grupo = findViewById(R.id.Crear_grupo_card_view);
        mis_grupos = findViewById(R.id.Mis_grupos_card_view);
        grupos = findViewById(R.id.grupos_card_view);

        crear_grupo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),CrearGrupoActivity.class));
            }
        });
        mis_grupos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MisGruposActivity.class));
            }
        });
        grupos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),GruposActivity.class));
            }
        });

    }
}

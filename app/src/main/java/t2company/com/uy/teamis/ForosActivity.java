package t2company.com.uy.teamis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ForosActivity extends AppCompatActivity {
    Button crearForo;
    Button misForos;
    Button foros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vistaforos);
        crearForo =findViewById(R.id.crear_foro);
        misForos =findViewById(R.id.mis_foros);
        foros =findViewById(R.id.foros);
        crearForo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), CrearForoActivity.class);

                startActivity(i);
            }
        });
        misForos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),MisForosActivity.class);

                startActivity(i);
            }
        });
        foros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), forosGeneralActivity.class);

                startActivity(i);
            }
        });
    }
}

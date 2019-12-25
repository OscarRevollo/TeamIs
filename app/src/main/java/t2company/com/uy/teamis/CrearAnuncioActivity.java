package t2company.com.uy.teamis;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class CrearAnuncioActivity extends AppCompatActivity {
    DatabaseReference mRootReference;
    TextView estado;
    EditText tituloo;
    EditText descripcionn;
    Spinner categoriaa;
    Button btnRegistrar;
    Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_anuncio);
        mRootReference = FirebaseDatabase.getInstance().getReference();
        btnRegistrar= findViewById(R.id.buttonRegistrar);
        btnCancelar= findViewById(R.id.buttonCancelar);
        tituloo = findViewById(R.id.editTitulo);
        descripcionn = findViewById(R.id.editDescripcion);
        categoriaa=(Spinner) findViewById(R.id.spinnerCrear);

        mRootReference = FirebaseDatabase.getInstance().getReference();
        ArrayAdapter<CharSequence>
                adapter = ArrayAdapter.createFromResource(this, R.array.Categoria, android.R.layout.simple_spinner_item);
        categoriaa.setAdapter(adapter);

        categoriaa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(),
                        "seleccionaste:"+ parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });




    }

    public void onClick(View v){

        String titulo = tituloo.getText().toString();
        String descripcion = descripcionn.getText().toString();
        String categoria= categoriaa.getSelectedItem().toString();
        cargarDatosFirebase(titulo, descripcion, categoria);

    }

    private void cargarDatosFirebase(String titulo, String descripcion, String categoria) {
        Map<String, Object> datosForo = new HashMap<>();
        datosForo.put("titulo",titulo);
        datosForo.put("descripcion",descripcion);
        datosForo.put("categoria",categoria);


        mRootReference.child("Foro").push().setValue(datosForo);
//        startActivity(new Intent(getApplicationContext(), MisAnunciosActivity.class));
    }

    public void onClickCancelar(View view) {
        Toast toast1 =
                Toast.makeText(getApplicationContext(),
                        "Cancelado", Toast.LENGTH_SHORT);

        toast1.show();
    }
}
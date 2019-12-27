package t2company.com.uy.teamis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import t2company.com.uy.teamis.Model.User;

public class Crear_ActividadActivity extends AppCompatActivity {
    DatabaseReference mRootReference;
    TextView estado;
    EditText tituloo;
    EditText descripcionn;
    Spinner categoriaa;
    Button btnRegistrar;
    Button btnCancelar;
    FirebaseUser fuser;
    DatabaseReference referenceActualU;
    String autorA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear__actividad);
        mRootReference = FirebaseDatabase.getInstance().getReference();
        btnRegistrar= findViewById(R.id.buttonRegistrar);
        btnCancelar= findViewById(R.id.buttonCancelar);
        tituloo = findViewById(R.id.editTitulo);
        descripcionn = findViewById(R.id.editDescripcion);
        categoriaa=(Spinner) findViewById(R.id.spinnerCrear);
        fuser = FirebaseAuth.getInstance().getCurrentUser();
        referenceActualU = FirebaseDatabase.getInstance().getReference("Users").child(fuser.getUid());

        //Categoria
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
        //Actual usuario
        referenceActualU.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user =dataSnapshot.getValue(User.class);
                autorA= user.getUsername();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
    public void onClick(View v){

        String titulo = tituloo.getText().toString();
        String descripcion = descripcionn.getText().toString();
        String categoria= categoriaa.getSelectedItem().toString();
        Date fecha = new Date();
        String fechaformato = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(fecha);
        String autor= autorA;
        cargarDatosFirebase(titulo, descripcion, categoria,fechaformato,autor);

    }

    private void cargarDatosFirebase( String titulo, String descripcion, String categoria, String fecha,String autor) {
        Map<String, Object> datosForo = new HashMap<>();
        datosForo.put("titulo",titulo);
        datosForo.put("descripcion",descripcion);
        datosForo.put("categoria",categoria);
        datosForo.put("fecha",fecha);
        datosForo.put("autor",autor);


        mRootReference.child("ForoActividad").push().setValue(datosForo);
        startActivity(new Intent(getApplicationContext(), ActividadesActivity.class));
    }

    public void onClickCancelar(View view) {
        Toast toast1 =
                Toast.makeText(getApplicationContext(),
                        "Cancelado", Toast.LENGTH_SHORT);

        toast1.show();
    }
}

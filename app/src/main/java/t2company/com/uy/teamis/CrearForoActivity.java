package t2company.com.uy.teamis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.text.DateFormat;

import t2company.com.uy.teamis.Model.User;

public class CrearForoActivity extends AppCompatActivity {
    DatabaseReference mRootReference;
    TextView estado;
    EditText tituloo;
    EditText descripcionn;
    Spinner tematicaa;
    Button btnRegistrar;
    Button btnCancelar;
    FirebaseUser fuser;
    DatabaseReference referenceActualU;
    String autorA;
    RadioButton btnProyecto,btnActividad,btnGrupo;
    String categoria="Proyecto";
    RadioGroup grupoRadio ;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_foro);
        mRootReference = FirebaseDatabase.getInstance().getReference();
        btnRegistrar= findViewById(R.id.buttonRegistrar);
        btnCancelar= findViewById(R.id.buttonCancelar);
        tituloo = findViewById(R.id.editTitulo);
        descripcionn = findViewById(R.id.editDescripcion);
        tematicaa=(Spinner) findViewById(R.id.spinnertematica);
        btnProyecto = findViewById(R.id.btnProyecto);
        btnActividad =findViewById(R.id.btnActividad);
        btnGrupo = findViewById(R.id.btnGrupo);
        grupoRadio = (RadioGroup)findViewById(R.id.grupoRadio);
        fuser = FirebaseAuth.getInstance().getCurrentUser();
        referenceActualU = FirebaseDatabase.getInstance().getReference("Users").child(fuser.getUid());

        //tematica Proyecto
        grupoRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) 				{
                if(btnProyecto.isChecked()){
                    categoria = btnProyecto.getText().toString();
                    ArrayAdapter<CharSequence>
                            adapter;
                    adapter = ArrayAdapter.createFromResource(CrearForoActivity.this, R.array.tematicaProyecto, android.R.layout.simple_spinner_item);
                    tematicaa.setAdapter(adapter);

                    tematicaa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            Toast.makeText(parent.getContext(),
                                    "seleccionaste:"+ parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }


                    });

                }else if(btnActividad.isChecked()){
                    ArrayAdapter<CharSequence>
                            adapter = ArrayAdapter.createFromResource(CrearForoActivity.this, R.array.tematicaActividad, android.R.layout.simple_spinner_item);
                    tematicaa.setAdapter(adapter);

                    tematicaa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            Toast.makeText(parent.getContext(),
                                    "seleccionaste:"+ parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }


                    });
                    categoria = btnActividad.getText().toString();

                }else if (btnGrupo.isChecked()){
                    ArrayAdapter<CharSequence>
                            adapter = ArrayAdapter.createFromResource(CrearForoActivity.this, R.array.tematicaGrupo, android.R.layout.simple_spinner_item);
                    tematicaa.setAdapter(adapter);

                    tematicaa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            Toast.makeText(parent.getContext(),
                                    "seleccionaste:"+ parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }


                    });
                    categoria = btnGrupo.getText().toString();

                }

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
        String tematica= tematicaa.getSelectedItem().toString();
        Date fecha = new Date();
        String fechaformato = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(fecha);
        String autor= autorA;
        cargarDatosFirebase(titulo, descripcion, tematica,categoria,fechaformato,autor);

    }

    private void cargarDatosFirebase( String titulo, String descripcion,String tematica, String categoria, String fecha,String autor) {
        Map<String, Object> datosForo = new HashMap<>();
        datosForo.put("titulo",titulo);
        datosForo.put("descripcion",descripcion);
        datosForo.put("categoria",categoria);
        datosForo.put("tematica", tematica);
        datosForo.put("fecha",fecha);
        datosForo.put("autor",autor);


        mRootReference.child("Foro").push().setValue(datosForo);
      startActivity(new Intent(getApplicationContext(), forosGeneralActivity.class));
    }

    public void onClickCancelar(View view) {
        Toast toast1 =
                Toast.makeText(getApplicationContext(),
                        "Cancelado", Toast.LENGTH_SHORT);

        toast1.show();
       tituloo.setText("");
       descripcionn.setText("");
       btnProyecto.setChecked(true);
       btnActividad.setChecked(false);
       btnGrupo.setChecked(false);



    }
}
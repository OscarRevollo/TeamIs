package t2company.com.uy.teamis;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;

import java.sql.Time;
import java.util.Calendar;

public class CrearEvento extends AppCompatActivity implements View.OnClickListener {

    ImageButton btn_fecha,btn_hora;
    EditText thora;
    EditText tfecha;
    private  int dia, mes , ano, hora, minutos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_evento);
        btn_fecha =(ImageButton)findViewById(R.id.btn_fecha);
        btn_hora = (ImageButton)findViewById(R.id.btn_hora);
        thora = (EditText)findViewById(R.id.hora);
        tfecha = (EditText)findViewById(R.id.fecha);
        btn_fecha.setOnClickListener(this);
        btn_hora.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        if (v == btn_fecha){
            final Calendar  c =Calendar.getInstance();
            dia =c.get(Calendar.DAY_OF_MONTH);
            mes =c.get(Calendar.MONTH);
            ano = c.get(Calendar.YEAR);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYears, int dayOfMonth) {

                    tfecha.setText(dayOfMonth+"/"+(monthOfYears+1)+"/"+year);
                }
            }
            ,dia,mes,ano);
            datePickerDialog.show();
        }
        if (v == btn_hora){

            final Calendar  c =Calendar.getInstance();
            hora =c.get(Calendar.HOUR_OF_DAY);
            minutos =c.get(Calendar.MINUTE);
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    thora.setText(hourOfDay+":"+minute);

                }
            },hora,minutos,false);
            timePickerDialog.show();

        }

    }
}

package t2company.com.uy.teamis;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import t2company.com.uy.teamis.R;

public class ForoProjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foro);
        getIncomingIntent();
    }
    private void getIncomingIntent(){


        if(getIntent().hasExtra("titulo") && getIntent().hasExtra("descripcion")){

            String titulof = getIntent().getStringExtra("titulo");
            String descripcionf = getIntent().getStringExtra("descripcion");
            setForo(titulof,descripcionf);
        }
    }
    private void setForo(String titulof, String descripcionf){


        TextView titulo = (TextView) findViewById(R.id.tituloforo);
        titulo.setText(titulof);
        TextView descripcion = (TextView) findViewById(R.id.descripcionforo);
        descripcion.setMovementMethod(new ScrollingMovementMethod());
        descripcion.setText(descripcionf);

//        ImageView image = findViewById(R.id.image);
//        Glide.with(this)
//                .asBitmap()
//                .load(imageUrl)
//                .into(image);
    }


}

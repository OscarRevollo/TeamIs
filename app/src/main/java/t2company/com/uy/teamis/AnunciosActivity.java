package t2company.com.uy.teamis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
public class AnunciosActivity extends AppCompatActivity {
    FirebaseUser user;
    CardView web;
    CardView androidd;
    CardView bd;
    CardView desktop;
    CardView otro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anuncios);
        web = findViewById(R.id.web_card_view);
        androidd = findViewById(R.id.android_card_view);
        bd = findViewById(R.id.bd_card_view);
        desktop = findViewById(R.id.desktop_card_view);
        otro = findViewById(R.id.otro_card_view);
    }



//        web.setOnClickListener(new View.OnClickListener() {
//
//        });

        public void onClick(View v) {
        if(v.getId()==web.getId()){
            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            "Web....", Toast.LENGTH_SHORT);

            toast1.show();
        }
        if(v.getId()==androidd.getId()){
            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            "Android", Toast.LENGTH_SHORT);

            toast1.show();
        }
        if(v.getId()==bd.getId()){
            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            "Android", Toast.LENGTH_SHORT);

            toast1.show();
        }
        if(v.getId()==desktop.getId()){
            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            "Android", Toast.LENGTH_SHORT);

            toast1.show();
        }
        if(v.getId()==otro.getId()){
            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            "Android", Toast.LENGTH_SHORT);

            toast1.show();
        }
        }

//

}

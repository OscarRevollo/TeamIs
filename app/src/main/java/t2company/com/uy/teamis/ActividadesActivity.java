package t2company.com.uy.teamis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.auth.FirebaseUser;

import java.util.List;

import t2company.com.uy.teamis.Adapter.ForosProjectAdapter;
import t2company.com.uy.teamis.Model.Foro;
import t2company.com.uy.teamis.Model.ForoActividad;

public class ActividadesActivity extends AppCompatActivity {
    CardView Juegos;
    CardView Deportivos;
    CardView Academicas;
    CardView otro;
    ForosProjectAdapter forosProjectAdapter;
    List<ForoActividad> foroList;
    RecyclerView recyclerView;
    FirebaseUser fuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades);
        Juegos = findViewById(R.id.web_card_view);
        Deportivos = findViewById(R.id.movil_card_view);
        Academicas = findViewById(R.id.bd_card_view);
        otro = findViewById(R.id.redes_card_view);
    }
}

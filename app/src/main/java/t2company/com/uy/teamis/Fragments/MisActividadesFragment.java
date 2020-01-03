package t2company.com.uy.teamis.Fragments;


import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import t2company.com.uy.teamis.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MisActividadesFragment extends Fragment {

    CardView juego;
    CardView academico;
    CardView deporte;
    CardView otro;
    View vista;

    public MisActividadesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_mis_actividades, container, false);
        juego = vista.findViewById(R.id.juego_card_view);
        deporte = vista.findViewById(R.id.deporte_card_view);
        academico=vista.findViewById(R.id.academico_card_view);
        otro = vista.findViewById(R.id.otro_card_view);
        return vista;
    }

}

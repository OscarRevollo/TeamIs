package t2company.com.uy.teamis.Fragments;


import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import t2company.com.uy.teamis.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MisProyectosFragment extends Fragment {

    CardView web;
    CardView movil;
    CardView bd;
    CardView redes;
    CardView ia;
    CardView gamers;
    CardView otro;
    View vista;
    Activity misProyectos_Act;
    public MisProyectosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        vista = inflater.inflate(R.layout.fragment_mis_proyectos, container, false);
        web = vista.findViewById(R.id.web_card_view);
        movil = vista.findViewById(R.id.movil_card_view);
        bd = vista.findViewById(R.id.bd_card_view);
        redes = vista.findViewById(R.id.redes_card_view);
        ia = vista.findViewById(R.id.ia_card_view);
        gamers = vista.findViewById(R.id.gamers_card_view);
        otro = vista.findViewById(R.id.otro_card_view);
        return vista;

    }


}

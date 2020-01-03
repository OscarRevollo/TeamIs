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
public class GruposFragment extends Fragment {

    CardView materia;
    CardView area;
    CardView otro;
    View vista;
    public GruposFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        vista = inflater.inflate(R.layout.fragment_grupos, container, false);
        materia = vista.findViewById(R.id.materia_card_view);
        area = vista.findViewById(R.id.area_card_view);
        otro = vista.findViewById(R.id.otro_card_view);
        return vista;
    }

}

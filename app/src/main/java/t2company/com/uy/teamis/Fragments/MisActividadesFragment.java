package t2company.com.uy.teamis.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import t2company.com.uy.teamis.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MisActividadesFragment extends Fragment {


    public MisActividadesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mis_actividades, container, false);
    }

}

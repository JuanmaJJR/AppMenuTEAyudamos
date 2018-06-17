package com.example.juanjusue.appmenuteayudamos.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;

import com.example.juanjusue.appmenuteayudamos.MainActivity;
import com.example.juanjusue.appmenuteayudamos.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelecMeriendaFragment extends Fragment {

    SelecMeriendaFragmentEvents events;
    ImageButton imgEleccion11;
    ImageButton imgEleccion12;
    ImageButton imgEleccion21;
    ImageButton imgEleccion22;
    ImageButton imgEleccion23;
    ImageButton imgEleccion24;
    public CheckBox cbEleccion11;
    public CheckBox cbEleccion12;
    public CheckBox cbEleccion21;
    public CheckBox cbEleccion22;
    public CheckBox cbEleccion23;
    public CheckBox cbEleccion24;
    Button btnFin;

    public SelecMeriendaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_selec_merienda, container, false);
        MainActivity main = (MainActivity) getActivity();
        events = new SelecMeriendaFragmentEvents(this,main);



        cbEleccion11 = (CheckBox)v.findViewById(R.id.checkBoxMer1);
        cbEleccion12 = (CheckBox)v.findViewById(R.id.checkBoxMer2);
        cbEleccion21 = (CheckBox)v.findViewById(R.id.checkBoxMer3);
        cbEleccion22 = (CheckBox)v.findViewById(R.id.checkBoxMer4);
        cbEleccion23 = (CheckBox)v.findViewById(R.id.checkBoxMer5);
        cbEleccion24 = (CheckBox)v.findViewById(R.id.checkBoxMer6);

        imgEleccion11 = (ImageButton)v.findViewById(R.id.imageButtonMer1);
        imgEleccion11.setOnClickListener(events);
        imgEleccion12 = (ImageButton)v.findViewById(R.id.imageButtonMer2);
        imgEleccion12.setOnClickListener(events);
        imgEleccion21 = (ImageButton)v.findViewById(R.id.imageButtonMer3);
        imgEleccion21.setOnClickListener(events);
        imgEleccion22 = (ImageButton)v.findViewById(R.id.imageButtonMer4);
        imgEleccion22.setOnClickListener(events);
        imgEleccion23 = (ImageButton)v.findViewById(R.id.imageButtonMer5);
        imgEleccion23.setOnClickListener(events);
        imgEleccion24 = (ImageButton)v.findViewById(R.id.imageButtonMer6);
        imgEleccion24.setOnClickListener(events);
        btnFin = (Button) v.findViewById(R.id.btnFinalizarMer);
        return v;
    }

}


class SelecMeriendaFragmentEvents implements View.OnClickListener{
    SelecMeriendaFragment selecMeriendaFragment;
    MainActivity main;
    HashMap<String,ArrayList<String>> map;



    public SelecMeriendaFragmentEvents(SelecMeriendaFragment selecMeriendaFragment, MainActivity mainActivity) {
        this.selecMeriendaFragment = selecMeriendaFragment;
        this.main = main;
    }


    @Override
    public void onClick(View v) {

    }
}
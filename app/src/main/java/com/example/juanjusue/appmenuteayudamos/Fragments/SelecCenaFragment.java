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
public class SelecCenaFragment extends Fragment {

    SelecCenaFragmentEvents events;
    ImageButton imgEleccion11;
    ImageButton imgEleccion12;
    ImageButton imgEleccion13;
    ImageButton imgEleccion14;
    ImageButton imgEleccion21;
    ImageButton imgEleccion22;
    ImageButton imgEleccion23;
    ImageButton imgEleccion24;
    ImageButton imgEleccion31;
    ImageButton imgEleccion32;
    ImageButton imgEleccion33;
    ImageButton imgEleccion34;
    public CheckBox cbEleccion11;
    public CheckBox cbEleccion12;
    public CheckBox cbEleccion13;
    public CheckBox cbEleccion14;
    public CheckBox cbEleccion21;
    public CheckBox cbEleccion22;
    public CheckBox cbEleccion23;
    public CheckBox cbEleccion24;
    public CheckBox cbEleccion31;
    public CheckBox cbEleccion32;
    public CheckBox cbEleccion33;
    public CheckBox cbEleccion34;
    Button btnFin;



    public SelecCenaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_selec_cena, container, false);
        MainActivity main = (MainActivity) getActivity();
        events = new SelecCenaFragmentEvents(this,main);


        //CheckBox
        cbEleccion11 = (CheckBox)v.findViewById(R.id.checkBoxCen1);
        cbEleccion12 = (CheckBox)v.findViewById(R.id.checkBoxCen2);
        cbEleccion13 = (CheckBox)v.findViewById(R.id.checkBoxCen3);
        cbEleccion14 = (CheckBox)v.findViewById(R.id.checkBoxCen4);
        cbEleccion21 = (CheckBox)v.findViewById(R.id.checkBoxCen5);
        cbEleccion22 = (CheckBox)v.findViewById(R.id.checkBoxCen6);
        cbEleccion23 = (CheckBox)v.findViewById(R.id.checkBoxCen7);
        cbEleccion24 = (CheckBox)v.findViewById(R.id.checkBoxCen8);
        cbEleccion31 = (CheckBox)v.findViewById(R.id.checkBoxCen9);
        cbEleccion32 = (CheckBox)v.findViewById(R.id.checkBoxCen10);
        cbEleccion33 = (CheckBox)v.findViewById(R.id.checkBoxCen11);
        cbEleccion34 = (CheckBox)v.findViewById(R.id.checkBoxCen12);
        //Imagenes
        imgEleccion11 = (ImageButton)v.findViewById(R.id.imageButtonCen1);
        imgEleccion11.setOnClickListener(events);
        imgEleccion12 = (ImageButton)v.findViewById(R.id.imageButtonCen2);
        imgEleccion12.setOnClickListener(events);
        imgEleccion13 = (ImageButton)v.findViewById(R.id.imageButtonCen3);
        imgEleccion13.setOnClickListener(events);
        imgEleccion14 = (ImageButton)v.findViewById(R.id.imageButtonCen4);
        imgEleccion14.setOnClickListener(events);
        imgEleccion21 = (ImageButton)v.findViewById(R.id.imageButtonCen5);
        imgEleccion21.setOnClickListener(events);
        imgEleccion22 = (ImageButton)v.findViewById(R.id.imageButtonCen6);
        imgEleccion22.setOnClickListener(events);
        imgEleccion23 = (ImageButton)v.findViewById(R.id.imageButtonCen7);
        imgEleccion23.setOnClickListener(events);
        imgEleccion24 = (ImageButton)v.findViewById(R.id.imageButtonCen8);
        imgEleccion24.setOnClickListener(events);
        imgEleccion31 = (ImageButton)v.findViewById(R.id.imageButtonCen9);
        imgEleccion31.setOnClickListener(events);
        imgEleccion32 = (ImageButton)v.findViewById(R.id.imageButtonCen10);
        imgEleccion32.setOnClickListener(events);
        imgEleccion33 = (ImageButton)v.findViewById(R.id.imageButtonCen11);
        imgEleccion33.setOnClickListener(events);
        imgEleccion34 = (ImageButton)v.findViewById(R.id.imageButtonCen12);
        imgEleccion34.setOnClickListener(events);
        btnFin = (Button) v.findViewById(R.id.btnFinalizarCen);
        return v;

    }

}




class SelecCenaFragmentEvents implements View.OnClickListener{
    SelecCenaFragment selecCenaFragment;
    MainActivity main;
    HashMap<String,ArrayList<String>> map;



    public SelecCenaFragmentEvents(SelecCenaFragment selecCenaFragment, MainActivity mainActivity) {
        this.selecCenaFragment = selecCenaFragment;
        this.main = main;
    }


    @Override
    public void onClick(View v) {



    }


}
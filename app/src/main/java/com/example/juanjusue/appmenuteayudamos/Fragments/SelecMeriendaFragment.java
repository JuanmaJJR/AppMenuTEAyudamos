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
    CheckBox cbEleccion11;
    CheckBox cbEleccion12;
    CheckBox cbEleccion21;
    CheckBox cbEleccion22;
    CheckBox cbEleccion23;
    CheckBox cbEleccion24;
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
        if(v.getId()==R.id.btnFinalizarMer){
            if(main.menu.getDia().equals("hoy")){
                if(selecMeriendaFragment.cbEleccion11.isChecked()){
                    map = main.menu.getMenuDia1();
                    map.get("Merienda").add((String)selecMeriendaFragment.cbEleccion11.getText());
                    main.menu.setMenuDia1(map);
                }
                if(selecMeriendaFragment.cbEleccion12.isChecked()){
                    map = main.menu.getMenuDia1();
                    map.get("Merienda").add((String)selecMeriendaFragment.cbEleccion12.getText());
                    main.menu.setMenuDia1(map);
                }
                if(selecMeriendaFragment.cbEleccion21.isChecked()){
                    map = main.menu.getMenuDia1();
                    map.get("Merienda").add((String)selecMeriendaFragment.cbEleccion21.getText());
                    main.menu.setMenuDia1(map);
                }
                if(selecMeriendaFragment.cbEleccion22.isChecked()){
                    map = main.menu.getMenuDia1();
                    map.get("Merienda").add((String)selecMeriendaFragment.cbEleccion22.getText());
                    main.menu.setMenuDia1(map);
                }
                if(selecMeriendaFragment.cbEleccion23.isChecked()){
                    map = main.menu.getMenuDia1();
                    map.get("Merienda").add((String)selecMeriendaFragment.cbEleccion23.getText());
                    main.menu.setMenuDia1(map);
                }
                if(selecMeriendaFragment.cbEleccion24.isChecked()){
                    map = main.menu.getMenuDia1();
                    map.get("Merienda").add((String)selecMeriendaFragment.cbEleccion24.getText());
                    main.menu.setMenuDia1(map);
                }
            }
            if(main.menu.getDia().equals("manana")){
                if(selecMeriendaFragment.cbEleccion11.isChecked()){
                    map = main.menu.getMenuDia2();
                    map.get("Merienda").add((String)selecMeriendaFragment.cbEleccion11.getText());
                    main.menu.setMenuDia2(map);
                }
                if(selecMeriendaFragment.cbEleccion12.isChecked()){
                    map = main.menu.getMenuDia2();
                    map.get("Merienda").add((String)selecMeriendaFragment.cbEleccion12.getText());
                    main.menu.setMenuDia2(map);
                }
                if(selecMeriendaFragment.cbEleccion21.isChecked()){
                    map = main.menu.getMenuDia2();
                    map.get("Merienda").add((String)selecMeriendaFragment.cbEleccion21.getText());
                    main.menu.setMenuDia2(map);
                }
                if(selecMeriendaFragment.cbEleccion22.isChecked()){
                    map = main.menu.getMenuDia2();
                    map.get("Merienda").add((String)selecMeriendaFragment.cbEleccion22.getText());
                    main.menu.setMenuDia2(map);
                }
                if(selecMeriendaFragment.cbEleccion23.isChecked()){
                    map = main.menu.getMenuDia2();
                    map.get("Merienda").add((String)selecMeriendaFragment.cbEleccion23.getText());
                    main.menu.setMenuDia2(map);
                }
                if(selecMeriendaFragment.cbEleccion24.isChecked()){
                    map = main.menu.getMenuDia2();
                    map.get("Merienda").add((String)selecMeriendaFragment.cbEleccion24.getText());
                    main.menu.setMenuDia2(map);
                }
            }

        }
    }
}
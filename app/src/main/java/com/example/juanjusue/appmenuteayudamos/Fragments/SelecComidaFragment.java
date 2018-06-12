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
public class SelecComidaFragment extends Fragment {

    SelecComidaFragmentEvents events;
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
    CheckBox cbEleccion11;
    CheckBox cbEleccion12;
    CheckBox cbEleccion13;
    CheckBox cbEleccion14;
    CheckBox cbEleccion21;
    CheckBox cbEleccion22;
    CheckBox cbEleccion23;
    CheckBox cbEleccion24;
    CheckBox cbEleccion31;
    CheckBox cbEleccion32;
    CheckBox cbEleccion33;
    CheckBox cbEleccion34;
    Button btnFin;

    public SelecComidaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_selec_comida, container, false);
        MainActivity main = (MainActivity) getActivity();
        events = new SelecComidaFragmentEvents(this,main);

        ///_______ASIGNACION ELEMENTOS VISUALES_________________________________\\\

        //CheckBox
        cbEleccion11 = (CheckBox)v.findViewById(R.id.checkBoxCom1);
        cbEleccion12 = (CheckBox)v.findViewById(R.id.checkBoxCom2);
        cbEleccion13 = (CheckBox)v.findViewById(R.id.checkBoxCom3);
        cbEleccion14 = (CheckBox)v.findViewById(R.id.checkBoxCom4);
        cbEleccion21 = (CheckBox)v.findViewById(R.id.checkBoxCom5);
        cbEleccion22 = (CheckBox)v.findViewById(R.id.checkBoxCom6);
        cbEleccion23 = (CheckBox)v.findViewById(R.id.checkBoxCom7);
        cbEleccion24 = (CheckBox)v.findViewById(R.id.checkBoxCom8);
        cbEleccion31 = (CheckBox)v.findViewById(R.id.checkBoxCom9);
        cbEleccion32 = (CheckBox)v.findViewById(R.id.checkBoxCom10);
        cbEleccion33 = (CheckBox)v.findViewById(R.id.checkBoxCom11);
        cbEleccion34 = (CheckBox)v.findViewById(R.id.checkBoxCom12);
        //Imagenes
        imgEleccion11 = (ImageButton)v.findViewById(R.id.imageButtonCom1);
        imgEleccion11.setOnClickListener(events);
        imgEleccion12 = (ImageButton)v.findViewById(R.id.imageButtonCom2);
        imgEleccion12.setOnClickListener(events);
        imgEleccion13 = (ImageButton)v.findViewById(R.id.imageButtonCom3);
        imgEleccion13.setOnClickListener(events);
        imgEleccion14 = (ImageButton)v.findViewById(R.id.imageButtonCom4);
        imgEleccion14.setOnClickListener(events);
        imgEleccion21 = (ImageButton)v.findViewById(R.id.imageButtonCom5);
        imgEleccion21.setOnClickListener(events);
        imgEleccion22 = (ImageButton)v.findViewById(R.id.imageButtonCom6);
        imgEleccion22.setOnClickListener(events);
        imgEleccion23 = (ImageButton)v.findViewById(R.id.imageButtonCom7);
        imgEleccion23.setOnClickListener(events);
        imgEleccion24 = (ImageButton)v.findViewById(R.id.imageButtonCom8);
        imgEleccion24.setOnClickListener(events);
        imgEleccion31 = (ImageButton)v.findViewById(R.id.imageButtonCom9);
        imgEleccion31.setOnClickListener(events);
        imgEleccion32 = (ImageButton)v.findViewById(R.id.imageButtonCom10);
        imgEleccion32.setOnClickListener(events);
        imgEleccion33 = (ImageButton)v.findViewById(R.id.imageButtonCom11);
        imgEleccion33.setOnClickListener(events);
        imgEleccion34 = (ImageButton)v.findViewById(R.id.imageButtonCom12);
        imgEleccion34.setOnClickListener(events);

        btnFin = (Button) v.findViewById(R.id.btnFinalizarCom);

        return v;

    }

}



class SelecComidaFragmentEvents implements View.OnClickListener{
    MainActivity main;
    SelecComidaFragment selecComidaFragment;
    HashMap<String,ArrayList<String>> map;



    public SelecComidaFragmentEvents(SelecComidaFragment selecComidaFragment, MainActivity mainActivity) {
        this.selecComidaFragment = selecComidaFragment;
        this.main = main;
    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnFinalizarCom){
            if(main.menu.getDia().equals("hoy")){
                if(selecComidaFragment.cbEleccion11.isChecked()){
                    map = main.menu.getMenuDia1();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion11.getText());
                    main.menu.setMenuDia1(map);
                }
                if(selecComidaFragment.cbEleccion12.isChecked()){
                    map = main.menu.getMenuDia1();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion12.getText());
                    main.menu.setMenuDia1(map);
                }
                if(selecComidaFragment.cbEleccion13.isChecked()){
                    map = main.menu.getMenuDia1();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion13.getText());
                    main.menu.setMenuDia1(map);
                }
                if(selecComidaFragment.cbEleccion14.isChecked()){
                    map = main.menu.getMenuDia1();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion14.getText());
                    main.menu.setMenuDia1(map);
                }
                if(selecComidaFragment.cbEleccion21.isChecked()){
                    map = main.menu.getMenuDia1();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion21.getText());
                    main.menu.setMenuDia1(map);
                }
                if(selecComidaFragment.cbEleccion22.isChecked()){
                    map = main.menu.getMenuDia1();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion22.getText());
                    main.menu.setMenuDia1(map);
                }
                if(selecComidaFragment.cbEleccion23.isChecked()){
                    map = main.menu.getMenuDia1();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion23.getText());
                    main.menu.setMenuDia1(map);
                }
                if(selecComidaFragment.cbEleccion24.isChecked()){
                    map = main.menu.getMenuDia1();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion24.getText());
                    main.menu.setMenuDia1(map);
                }
                if(selecComidaFragment.cbEleccion31.isChecked()){
                    map = main.menu.getMenuDia1();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion31.getText());
                    main.menu.setMenuDia1(map);
                }
                if(selecComidaFragment.cbEleccion32.isChecked()){
                    map = main.menu.getMenuDia1();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion32.getText());
                    main.menu.setMenuDia1(map);
                }
                if(selecComidaFragment.cbEleccion33.isChecked()){
                    map = main.menu.getMenuDia1();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion33.getText());
                    main.menu.setMenuDia1(map);
                }
                if(selecComidaFragment.cbEleccion34.isChecked()){
                    map = main.menu.getMenuDia1();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion34.getText());
                    main.menu.setMenuDia1(map);
                }
            }
            if(main.menu.getDia().equals("manana")){
                if(selecComidaFragment.cbEleccion11.isChecked()){
                    map = main.menu.getMenuDia2();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion11.getText());
                    main.menu.setMenuDia2(map);
                }
                if(selecComidaFragment.cbEleccion12.isChecked()){
                    map = main.menu.getMenuDia2();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion12.getText());
                    main.menu.setMenuDia2(map);
                }
                if(selecComidaFragment.cbEleccion13.isChecked()){
                    map = main.menu.getMenuDia2();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion13.getText());
                    main.menu.setMenuDia2(map);
                }
                if(selecComidaFragment.cbEleccion14.isChecked()){
                    map = main.menu.getMenuDia2();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion14.getText());
                    main.menu.setMenuDia2(map);
                }
                if(selecComidaFragment.cbEleccion21.isChecked()){
                    map = main.menu.getMenuDia2();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion21.getText());
                    main.menu.setMenuDia2(map);
                }
                if(selecComidaFragment.cbEleccion22.isChecked()){
                    map = main.menu.getMenuDia2();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion22.getText());
                    main.menu.setMenuDia2(map);
                }
                if(selecComidaFragment.cbEleccion23.isChecked()){
                    map = main.menu.getMenuDia2();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion23.getText());
                    main.menu.setMenuDia2(map);
                }
                if(selecComidaFragment.cbEleccion24.isChecked()){
                    map = main.menu.getMenuDia2();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion24.getText());
                    main.menu.setMenuDia2(map);
                }
                if(selecComidaFragment.cbEleccion31.isChecked()){
                    map = main.menu.getMenuDia2();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion31.getText());
                    main.menu.setMenuDia2(map);
                }
                if(selecComidaFragment.cbEleccion32.isChecked()){
                    map = main.menu.getMenuDia2();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion32.getText());
                    main.menu.setMenuDia2(map);
                }
                if(selecComidaFragment.cbEleccion33.isChecked()){
                    map = main.menu.getMenuDia2();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion33.getText());
                    main.menu.setMenuDia2(map);
                }
                if(selecComidaFragment.cbEleccion34.isChecked()){
                    map = main.menu.getMenuDia2();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion34.getText());
                    main.menu.setMenuDia2(map);
                }
            }

        }


    }


}

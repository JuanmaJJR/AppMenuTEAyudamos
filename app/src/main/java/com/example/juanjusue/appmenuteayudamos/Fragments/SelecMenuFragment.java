package com.example.juanjusue.appmenuteayudamos.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;

import com.example.juanjusue.appmenuteayudamos.Asynctasks.HttpJsonAsyncTaskListener;
import com.example.juanjusue.appmenuteayudamos.MainActivity;
import com.example.juanjusue.appmenuteayudamos.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelecMenuFragment extends Fragment {

    public SelecMenuFragmentEvents events;
    public ImageButton imgEleccion11;
    public ImageButton imgEleccion12;
    public ImageButton imgEleccion21;
    public ImageButton imgEleccion22;
    public ImageButton imgEleccion23;
    public ImageButton imgEleccion31;
    public ImageButton imgEleccion32;
    public CheckBox cbEleccion11;
    public CheckBox cbEleccion12;
    public CheckBox cbEleccion21;
    public CheckBox cbEleccion22;
    public CheckBox cbEleccion23;
    public CheckBox cbEleccion31;
    public CheckBox cbEleccion32;
    Button btnFin;

    public SelecMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ///Asignaciones generales\\\
        View v = inflater.inflate(R.layout.fragment_selec_menu, container, false);
        MainActivity main = (MainActivity) getActivity();
        events = new SelecMenuFragmentEvents(this,main);

        ///_______________________\\\


        ///_______ASIGNACION ELEMENTOS VISUALES_________________________________\\\

        //CheckBox
        cbEleccion11 = (CheckBox) v.findViewById(R.id.checkBoxDes1);
        cbEleccion12 = (CheckBox)v.findViewById(R.id.checkBoxDes2);
        cbEleccion21 = (CheckBox)v.findViewById(R.id.checkBoxDes3);
        cbEleccion22 = (CheckBox)v.findViewById(R.id.checkBoxDes4);
        cbEleccion23 = (CheckBox)v.findViewById(R.id.checkBoxDes5);
        cbEleccion31 = (CheckBox)v.findViewById(R.id.checkBoxDes6);
        cbEleccion32 = (CheckBox)v.findViewById(R.id.checkBoxDes7);
        //Imagenes
        imgEleccion11 = (ImageButton)v.findViewById(R.id.imageButtonDes1);
        imgEleccion11.setOnClickListener(events);
        imgEleccion12 = (ImageButton)v.findViewById(R.id.imageButtonDes2);
        imgEleccion12.setOnClickListener(events);
        imgEleccion21 = (ImageButton)v.findViewById(R.id.imageButtonDes3);
        imgEleccion21.setOnClickListener(events);
        imgEleccion22 = (ImageButton)v.findViewById(R.id.imageButtonDes4);
        imgEleccion22.setOnClickListener(events);
        imgEleccion23 = (ImageButton)v.findViewById(R.id.imageButtonDes5);
        imgEleccion23.setOnClickListener(events);
        imgEleccion31 = (ImageButton)v.findViewById(R.id.imageButtonDes6);
        imgEleccion31.setOnClickListener(events);
        imgEleccion32 = (ImageButton)v.findViewById(R.id.imageButtonDes7);
        imgEleccion32.setOnClickListener(events);
        //Botones
        btnFin = (Button) v.findViewById(R.id.btnFinalizar);

        ///_______________________________________________________________________\\\



        return v;
    }

}
class SelecMenuFragmentEvents implements HttpJsonAsyncTaskListener, View.OnClickListener {
    SelecMenuFragment selecMenuFragment;
    MainActivity main;
    HashMap<String,ArrayList<String>> map;



    public SelecMenuFragmentEvents(SelecMenuFragment selecMenuFragment, MainActivity mainActivity) {
        this.selecMenuFragment = selecMenuFragment;
        this.main = main;
    }

    @Override
    public void JsonOk(String s) {
        //AQUI TRATAMOS CON EL JSON
      //  try {

//            JSONArray object = new JSONArray(s); //Creamos un objeto JSON a partir de la cadena

            //for (int i = 0; i < object.length(); i++) {
            //}

      //  } catch (JSONException e) {
       //     e.printStackTrace();
    //    }
    }

    @Override
    public void onClick(View v) {
        Log.v("DESY","SSSSSSSSSSSSSSSSSSSSSSSSSSSSIII--..");
        //Actualizamos el objeto menu, dependiendo del dia lo haremos de uno o de otro.
        if(v.getId()==R.id.btnFinalizar){

        }
    }
}
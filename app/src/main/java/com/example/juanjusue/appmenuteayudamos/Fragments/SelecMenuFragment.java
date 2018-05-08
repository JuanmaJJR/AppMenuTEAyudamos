package com.example.juanjusue.appmenuteayudamos.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;

import com.example.juanjusue.appmenuteayudamos.Asynctasks.HttpJsonAsyncTask;
import com.example.juanjusue.appmenuteayudamos.Asynctasks.HttpJsonAsyncTaskListener;
import com.example.juanjusue.appmenuteayudamos.MainActivity;
import com.example.juanjusue.appmenuteayudamos.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelecMenuFragment extends Fragment {

    SelecMenuFragmentEvents events;
    ImageButton imgEleccion11;
    ImageButton imgEleccion12;
    ImageButton imgEleccion21;
    ImageButton imgEleccion22;
    ImageButton imgEleccion23;
    ImageButton imgEleccion31;
    ImageButton imgEleccion32;
    CheckBox cbEleccion11;
    CheckBox cbEleccion12;
    CheckBox cbEleccion21;
    CheckBox cbEleccion22;
    CheckBox cbEleccion23;
    CheckBox cbEleccion31;
    CheckBox cbEleccion32;
    Button btnFin;

    public SelecMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ///Asignaciones generales\\\
        View v = inflater.inflate(R.layout.fragment_selec_menu, container, false);
        events = new SelecMenuFragmentEvents(this);
        MainActivity main = (MainActivity) getActivity();
        ///_______________________\\\


        ///_______ASIGNACION ELEMENTOS VISUALES_________________________________\\\

        //CheckBox
        cbEleccion11 = (CheckBox) getView().findViewById(R.id.checkBoxDes1);
        cbEleccion12 = (CheckBox)getView().findViewById(R.id.checkBoxDes2);
        cbEleccion21 = (CheckBox)getView().findViewById(R.id.checkBoxDes3);
        cbEleccion22 = (CheckBox)getView().findViewById(R.id.checkBoxDes4);
        cbEleccion23 = (CheckBox)getView().findViewById(R.id.checkBoxDes5);
        cbEleccion31 = (CheckBox)getView().findViewById(R.id.checkBoxDes6);
        cbEleccion32 = (CheckBox)getView().findViewById(R.id.checkBoxDes7);
        //Imagenes
        imgEleccion11 = (ImageButton)getView().findViewById(R.id.imageButtonDes1);
        imgEleccion11.setOnClickListener(events);
        imgEleccion12 = (ImageButton)getView().findViewById(R.id.imageButtonDes2);
        imgEleccion12.setOnClickListener(events);
        imgEleccion21 = (ImageButton)getView().findViewById(R.id.imageButtonDes3);
        imgEleccion21.setOnClickListener(events);
        imgEleccion22 = (ImageButton)getView().findViewById(R.id.imageButtonDes4);
        imgEleccion22.setOnClickListener(events);
        imgEleccion23 = (ImageButton)getView().findViewById(R.id.imageButtonDes5);
        imgEleccion23.setOnClickListener(events);
        imgEleccion31 = (ImageButton)getView().findViewById(R.id.imageButtonDes6);
        imgEleccion31.setOnClickListener(events);
        imgEleccion32 = (ImageButton)getView().findViewById(R.id.imageButtonDes7);
        imgEleccion32.setOnClickListener(events);
        //Botones
        btnFin = (Button) getView().findViewById(R.id.btnFinalizar);

        ///_______________________________________________________________________\\\


        ///_______DESCARGA DEL JSON_________\\\
        HttpJsonAsyncTask httpJsonAsyncTask1=new HttpJsonAsyncTask(main);
        httpJsonAsyncTask1.setListener(events);
        String url1 = String.format("http://10.0.2.2/pruebasJSON/leeJugadores.php");
        httpJsonAsyncTask1.execute(url1);
        ///___________________________________\\\


        return v;
    }

}
class SelecMenuFragmentEvents implements HttpJsonAsyncTaskListener, View.OnClickListener {
    SelecMenuFragment selecMenuFragment;


    public SelecMenuFragmentEvents(SelecMenuFragment selecMenuFragment) {
        this.selecMenuFragment = selecMenuFragment;
    }

    @Override
    public void JsonOk(String s) {
        //AQUI TRATAMOS CON EL JSON
        try {

            JSONArray object = new JSONArray(s); //Creamos un objeto JSON a partir de la cadena

            for (int i = 0; i < object.length(); i++) {
            }

        } catch (JSONException e) {
            //CRASH REPORT EXAMEN
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {

    }
}
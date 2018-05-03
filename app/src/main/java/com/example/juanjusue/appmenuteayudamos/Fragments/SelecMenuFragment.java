package com.example.juanjusue.appmenuteayudamos.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    public SelecMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_selec_menu, container, false);

        events = new SelecMenuFragmentEvents(this);
        MainActivity main = (MainActivity) getActivity();

        ///_______DESCARGA DEL JSON_________\\\
        HttpJsonAsyncTask httpJsonAsyncTask1=new HttpJsonAsyncTask(main);
        httpJsonAsyncTask1.setListener(events);
        String url1 = String.format("http://10.0.2.2/pruebasJSON/leeJugadores.php");
        httpJsonAsyncTask1.execute(url1);
        ///________DESCARGA DEL JSON_________\\\
        return v;
    }

}
class SelecMenuFragmentEvents implements HttpJsonAsyncTaskListener {
    SelecMenuFragment selecMenuFragment;


    public SelecMenuFragmentEvents(SelecMenuFragment selecMenuFragment) {
        this.selecMenuFragment = selecMenuFragment;
    }

    @Override
    public void JsonOk(String s) {
        //AQUI TRATAMOS CON EL JSON
        try {

            JSONObject object = new JSONObject(s); //Creamos un objeto JSON a partir de la cadena

            for (int i = 0; i < object.length(); i++) {

            }

        } catch (JSONException e) {
            //CRASH REPORT EXAMEN
            e.printStackTrace();
        }
    }
}
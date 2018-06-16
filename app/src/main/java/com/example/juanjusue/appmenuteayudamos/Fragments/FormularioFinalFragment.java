package com.example.juanjusue.appmenuteayudamos.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.juanjusue.appmenuteayudamos.MainActivity;
import com.example.juanjusue.appmenuteayudamos.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FormularioFinalFragment extends Fragment {
    EditText etxtDesayuno1;
    EditText etxtDesayuno2;
    EditText etxtDesayuno3;
    EditText etxtComida1;
    EditText etxtComida2;
    EditText etxtComida3;
    EditText etxtMerienda1;
    EditText etxtMerienda2;
    EditText etxtCena1;
    EditText etxtCena2;
    EditText etxtCena3;
    EditText etxtDesayuno1Ma;
    EditText etxtDesayuno2Ma;
    EditText etxtDesayuno3Ma;
    EditText etxtComida1Ma;
    EditText etxtComida2Ma;
    EditText etxtComida3Ma;
    EditText etxtMerienda1Ma;
    EditText etxtMerienda2Ma;
    EditText etxtCena1Ma;
    EditText etxtCena2Ma;
    EditText etxtCena3Ma;




    public FormularioFinalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_formulario_final, container, false);
        MainActivity main = (MainActivity) getActivity();


        etxtDesayuno1 = v.findViewById(R.id.etxtDesayuno1);
        etxtDesayuno2 = v.findViewById(R.id.etxtDesayuno2);
        etxtDesayuno3 = v.findViewById(R.id.etxtDesayuno3);
        etxtComida1 = v.findViewById(R.id.etxtComida1);
        etxtComida2 = v.findViewById(R.id.etxtComida2);
        etxtComida3 = v.findViewById(R.id.etxtComida3);
        etxtMerienda1 = v.findViewById(R.id.etxtMerienda1);
        etxtMerienda2 = v.findViewById(R.id.etxtMerienda2);
        etxtCena1 = v.findViewById(R.id.etxtCena1);
        etxtCena2 = v.findViewById(R.id.etxtCena2);
        etxtCena3 = v.findViewById(R.id.etxtCena3);


        etxtDesayuno1Ma = v.findViewById(R.id.etxtDesayuno1Ma);
        etxtDesayuno2Ma = v.findViewById(R.id.etxtDesayuno2Ma);
        etxtDesayuno3Ma = v.findViewById(R.id.etxtDesayuno3Ma);
        etxtComida1Ma = v.findViewById(R.id.etxtComida1Ma);
        etxtComida2Ma = v.findViewById(R.id.etxtComida2Ma);
        etxtComida3Ma = v.findViewById(R.id.etxtComida3Ma);
        etxtMerienda1Ma = v.findViewById(R.id.etxtMerienda1Ma);
        etxtMerienda2Ma = v.findViewById(R.id.etxtMerienda2Ma);
        etxtCena1Ma = v.findViewById(R.id.etxtCena1Ma);
        etxtCena2Ma = v.findViewById(R.id.etxtCena2Ma);
        etxtCena3Ma = v.findViewById(R.id.etxtCena3Ma);

        //SETERS
        etxtDesayuno1.setText(main.menu.getMenuDia1().get("desayuno").get(0));
        etxtDesayuno2.setText(main.menu.getMenuDia1().get("desayuno").get(1));
        etxtDesayuno3.setText(main.menu.getMenuDia1().get("desayuno").get(2));

        etxtComida1.setText(main.menu.getMenuDia1().get("comida").get(0));
        etxtComida2.setText(main.menu.getMenuDia1().get("comida").get(1));
        etxtComida3.setText(main.menu.getMenuDia1().get("comida").get(2));

        etxtMerienda1.setText(main.menu.getMenuDia1().get("merienda").get(0));
        etxtMerienda2.setText(main.menu.getMenuDia1().get("merienda").get(1));

        etxtCena1.setText(main.menu.getMenuDia1().get("cena").get(0));
        etxtCena2.setText(main.menu.getMenuDia1().get("cena").get(1));
        etxtCena3.setText(main.menu.getMenuDia1().get("cena").get(2));


        etxtDesayuno1Ma.setText(main.menu.getMenuDia2().get("desayuno").get(0));
        etxtDesayuno2Ma.setText(main.menu.getMenuDia2().get("desayuno").get(1));
        etxtDesayuno3Ma.setText(main.menu.getMenuDia2().get("desayuno").get(2));

        etxtComida1Ma.setText(main.menu.getMenuDia2().get("comida").get(0));
        etxtComida2Ma.setText(main.menu.getMenuDia2().get("comida").get(1));
        etxtComida3Ma.setText(main.menu.getMenuDia2().get("comida").get(2));

        etxtMerienda1Ma.setText(main.menu.getMenuDia2().get("merienda").get(0));
        etxtMerienda2Ma.setText(main.menu.getMenuDia2().get("merienda").get(1));

        etxtCena1Ma.setText(main.menu.getMenuDia2().get("cena").get(0));
        etxtCena2Ma.setText(main.menu.getMenuDia2().get("cena").get(1));
        etxtCena3Ma.setText(main.menu.getMenuDia2().get("cena").get(2));

        return v;
    }

}

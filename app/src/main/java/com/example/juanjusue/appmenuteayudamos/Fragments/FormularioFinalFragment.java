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
    public EditText etxtDesayuno1;
    public EditText etxtDesayuno2;
    public EditText etxtDesayuno3;
    public EditText etxtComida1;
    public EditText etxtComida2;
    public EditText etxtComida3;
    public EditText etxtMerienda1;
    public EditText etxtMerienda2;
    public EditText etxtCena1;
    public EditText etxtCena2;
    public EditText etxtCena3;
    public EditText etxtDesayuno1Ma;
    public EditText etxtDesayuno2Ma;
    public EditText etxtDesayuno3Ma;
    public EditText etxtComida1Ma;
    public EditText etxtComida2Ma;
    public EditText etxtComida3Ma;
    public EditText etxtMerienda1Ma;
    public EditText etxtMerienda2Ma;
    public EditText etxtCena1Ma;
    public EditText etxtCena2Ma;
    public EditText etxtCena3Ma;




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



        return v;
    }

}

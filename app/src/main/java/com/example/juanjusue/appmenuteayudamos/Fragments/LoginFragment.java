package com.example.juanjusue.appmenuteayudamos.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.juanjusue.appmenuteayudamos.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {



    EditText etUser;
    EditText etPass;
    Button btnLogin;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_login, container, false);
        etUser = v.findViewById(R.id.etUsuario);
        etPass = v.findViewById(R.id.etPass);
        btnLogin = v.findViewById(R.id.btnLogin);
        return v;
    }


    public EditText getEtUser() {
        return etUser;
    }

    public EditText getEtPass() {
        return etPass;
    }

    public Button getBtnLogin() {
        return btnLogin;
    }



}

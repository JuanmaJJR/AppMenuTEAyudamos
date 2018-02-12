package com.example.juanjusue.appmenuteayudamos;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.juanjusue.appmenuteayudamos.Fragments.LoginFragment;
import com.example.juanjusue.appmenuteayudamos.Fragments.PrimeraPantallaFragment;
import com.example.juanjusue.appmenuteayudamos.Fragments.SelecDiaFragment;
import com.example.juanjusue.appmenuteayudamos.Fragments.SelecHorarioFragment;
import com.example.juanjusue.appmenuteayudamos.Objetos.Usuarios;

public class MainActivity extends AppCompatActivity {
    LoginFragment loginFragment;
    PrimeraPantallaFragment primeraPantallaFragment;
    Usuarios user;
    Integer IDCama;
    SelecDiaFragment selecDiaFragment;
    SelecHorarioFragment selecHorarioFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginFragment = (LoginFragment)getSupportFragmentManager().findFragmentById(R.id.fragmentLogin);
        primeraPantallaFragment = (PrimeraPantallaFragment)getSupportFragmentManager().findFragmentById(R.id.fragmentPrimeraPantalla);
        selecDiaFragment = (SelecDiaFragment)getSupportFragmentManager().findFragmentById(R.id.fragmentSeleccionDia);
        selecHorarioFragment = (SelecHorarioFragment)getSupportFragmentManager().findFragmentById(R.id.fragmentSeleccionHorario);
        user = new Usuarios();
        FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
        transition.show(loginFragment);
        transition.hide(primeraPantallaFragment);
        transition.hide(selecDiaFragment);
        transition.hide(selecHorarioFragment);
        transition.commit();

    }
    public void comprobarUser(View v){
        if( user.esUser(loginFragment.getEtUser().getText().toString(),loginFragment.getEtPass().getText().toString())){
            Log.v("LoginFragment","siiii");
            FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
            transition.show(primeraPantallaFragment);
            transition.hide(loginFragment);
            transition.commit();
        }
        else{
            Log.v("LoginFragment","noo");
        }
    }
    public void pasarCama(View v){
        IDCama = v.getId();
        FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
        transition.show(selecDiaFragment);
        transition.hide(primeraPantallaFragment);
        transition.commit();

    }
    public void selecHorario(View v){
        IDCama = v.getId();
        FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
        transition.show(selecHorarioFragment);
        transition.hide(selecDiaFragment);
        transition.commit();

    }
    public void selecMenu(View v){
        FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
        transition.show(selecHorarioFragment);
        transition.hide(selecDiaFragment);
        transition.commit();
    }
}

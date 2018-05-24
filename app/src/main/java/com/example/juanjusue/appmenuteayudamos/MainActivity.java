package com.example.juanjusue.appmenuteayudamos;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.juanjusue.appmenuteayudamos.Asynctasks.HttpJsonAsyncTaskListener;
import com.example.juanjusue.appmenuteayudamos.Fragments.LoginFragment;
import com.example.juanjusue.appmenuteayudamos.Fragments.PrimeraPantallaFragment;
import com.example.juanjusue.appmenuteayudamos.Fragments.SelecCenaFragment;
import com.example.juanjusue.appmenuteayudamos.Fragments.SelecComidaFragment;
import com.example.juanjusue.appmenuteayudamos.Fragments.SelecDiaFragment;
import com.example.juanjusue.appmenuteayudamos.Fragments.SelecHorarioFragment;
import com.example.juanjusue.appmenuteayudamos.Fragments.SelecMenuFragment;
import com.example.juanjusue.appmenuteayudamos.Fragments.SelecMeriendaFragment;
import com.example.juanjusue.appmenuteayudamos.Objetos.JSON;
import com.example.juanjusue.appmenuteayudamos.Objetos.Menu;
import com.example.juanjusue.appmenuteayudamos.Objetos.Usuarios;

public class MainActivity extends AppCompatActivity {
    LoginFragment loginFragment;
    PrimeraPantallaFragment primeraPantallaFragment;
    Usuarios user;
    Integer IDCama;
    SelecDiaFragment selecDiaFragment;
    SelecHorarioFragment selecHorarioFragment;
    SelecMenuFragment selecMenuFragment;
    SelecComidaFragment selecComidaFragment;
    SelecMeriendaFragment selecMeriendaFragment;
    SelecCenaFragment selecCenaFragment;
    public Menu menu;
    public JSON json;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///___________________________Asignaciones Fragments_____________________________________\\\
        loginFragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentLogin);
        primeraPantallaFragment = (PrimeraPantallaFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentPrimeraPantalla);
        selecDiaFragment = (SelecDiaFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentSeleccionDia);
        selecMenuFragment = (SelecMenuFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentSeleccionDes);
        selecComidaFragment = (SelecComidaFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentSeleccionCom);
        selecMeriendaFragment = (SelecMeriendaFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentSeleccionMer);
        selecCenaFragment = (SelecCenaFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentSeleccionCen);
        selecHorarioFragment = (SelecHorarioFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentSeleccionHorario);
        ///______________________________________________________________________________________\\\

        ///___________Objetos____________\\\
        user = new Usuarios();
        menu = new Menu();
        json = new JSON(this);
        ///______________________________\\\

        ///___________Transicciones iniciales_________________________\\\
        FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
        transition.show(loginFragment);
        transition.hide(primeraPantallaFragment);
        transition.hide(selecDiaFragment);
        transition.hide(selecHorarioFragment);
        transition.commit();
        ///__________________________________________________________\\\
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
        menu.setDia("Manana");
        FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
        transition.show(selecHorarioFragment);
        transition.hide(selecDiaFragment);
        transition.commit();

    }
    public void selecHorarioHoy(View v){
        IDCama = v.getId();
        menu.setDia("Hoy");
        FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
        transition.show(selecHorarioFragment);
        transition.hide(selecDiaFragment);
        transition.commit();

    }
    public void selecMenuDes(View v){
        FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
        transition.show(selecMenuFragment);
        transition.hide(selecHorarioFragment);
        transition.commit();

    }
    public void selecMenuCom(View v){
        FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
        transition.show(selecComidaFragment);
        transition.hide(selecHorarioFragment);
        transition.commit();

    }
    public void selecMenuMer(View v){
        FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
        transition.show(selecMeriendaFragment);
        transition.hide(selecHorarioFragment);
        transition.commit();

    }
    public void selecMenuCena(View v){
        FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
        transition.show(selecCenaFragment);
        transition.hide(selecHorarioFragment);
        transition.commit();

    }
}

class MainActivityEvents implements HttpJsonAsyncTaskListener{
    MainActivity mainActivity;


    public MainActivityEvents(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void JsonOk(String s) {

    }
}

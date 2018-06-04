package com.example.juanjusue.appmenuteayudamos;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.juanjusue.appmenuteayudamos.Asynctasks.HttpJsonAsyncTaskListener;
import com.example.juanjusue.appmenuteayudamos.Fragments.FTPFragment;
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

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    FTPFragment ftpFragmetn;
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
    String server="ftp.hospitaldefuenlabrada.org";
    int portNumber= 21;
    String Usuario="seg4313";
    String password="TrieglebViO1";
    String filename="menus.json";
    File localFile = new File("************PONER RUTA*************");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ///___________Objetos____________\\\
        user = new Usuarios();
        menu = new Menu();
        json = new JSON(this);
        ftpFragmetn = new FTPFragment();
        ///______________________________\\\

        try {
            if(ftpFragmetn.downloadAndSaveFile(server,portNumber, Usuario, password, filename, localFile)){
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

                ///___________Transicciones iniciales_________________________\\\
                FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
                transition.show(loginFragment);
                transition.hide(primeraPantallaFragment);
                transition.hide(selecDiaFragment);
                transition.hide(selecHorarioFragment);
                transition.hide(selecMenuFragment);
                transition.hide(selecComidaFragment);
                transition.hide(selecMeriendaFragment);
                transition.hide(selecCenaFragment);
                transition.hide(selecHorarioFragment);

                transition.commit();
                ///__________________________________________________________\\\

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

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

    public void pasarCama(View v) {
        IDCama = v.getId();
        FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
        transition.show(selecDiaFragment);
        transition.hide(primeraPantallaFragment);
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

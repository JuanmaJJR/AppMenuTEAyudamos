package com.example.juanjusue.appmenuteayudamos;

import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;

import com.example.juanjusue.appmenuteayudamos.Asynctasks.HttpJsonAsyncTaskListener;
import com.example.juanjusue.appmenuteayudamos.Fragments.FTPFragment;
import com.example.juanjusue.appmenuteayudamos.Fragments.FormularioFinalFragment;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    FTPFragment ftpFragment;
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
    FormularioFinalFragment formularioFinalFragment;
    public Menu menu;
    public JSON json;
    String server="ftp.hospitaldefuenlabrada.org";
    int portNumber= 21;
    String Usuario="seg4313";
    String password="TrieglebViO1";
    String filename="menus.json";
    Boolean resp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        ///___________Objetos____________\\\
        Context context = this;
        File localFile = new File(context.getFilesDir(), filename);
        user = new Usuarios();
        menu = new Menu();
        json = new JSON(this);
        ftpFragment = new FTPFragment(json);
        ///______________________________\\\

        try {
            resp = ftpFragment.downloadAndSaveFile(server,portNumber, Usuario, password, filename, localFile);
            Log.v("FTPPP", String.valueOf(resp));
            if(ftpFragment.downloadAndSaveFile(server,portNumber, Usuario, password, filename, localFile)){
                ///___________________________Asignaciones Fragments_____________________________________\\\
                loginFragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentLogin);
                primeraPantallaFragment = (PrimeraPantallaFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentPrimeraPantalla);
                selecDiaFragment = (SelecDiaFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentSeleccionDia);
                selecMenuFragment = (SelecMenuFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentSeleccionDes);
                selecComidaFragment = (SelecComidaFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentSeleccionCom);
                selecMeriendaFragment = (SelecMeriendaFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentSeleccionMer);
                selecCenaFragment = (SelecCenaFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentSeleccionCen);
                selecHorarioFragment = (SelecHorarioFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentSeleccionHorario);
                formularioFinalFragment=(FormularioFinalFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentFormuFinal);
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

                //Log.v("FTPFINAL",loadJSONFromAsset(this,localFile));
                try {
                    String sJson = loadJSONFromAsset(this,localFile);
                    JSONObject obj = new JSONObject(sJson);
                } catch (Throwable t) {
                    Log.v("My App", "Could not parse malformed JSON: \"" + json + "\"");
                }



                ///__________________________________________________________\\\

            }
        } catch (IOException e) {
            Log.v("errorJ", String.valueOf(e));
            e.printStackTrace();
        }

    }
    public String loadJSONFromAsset(Context context,File localFile) {
        String json = null;
        try {

            InputStream is = new FileInputStream(localFile);

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");
            Log.v("sJson",json);


        } catch (IOException ex) {
            ex.printStackTrace();
            Log.v("MALJSON  ",ex.toString());
            return null;
        }
        return json;

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

    public void pasarFormuFinal(View v) {
        FragmentTransaction transition = getSupportFragmentManager().beginTransaction();


        transition.show(formularioFinalFragment);
        transition.hide(selecDiaFragment);
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

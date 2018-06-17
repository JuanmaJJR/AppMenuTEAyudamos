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
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
                transition.hide(formularioFinalFragment);

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

        selecMenuFragment.cbEleccion11.setChecked(false);
        selecMenuFragment.cbEleccion12.setChecked(false);
        selecMenuFragment.cbEleccion21.setChecked(false);
        selecMenuFragment.cbEleccion22.setChecked(false);
        selecMenuFragment.cbEleccion23.setChecked(false);
        selecMenuFragment.cbEleccion31.setChecked(false);
        selecMenuFragment.cbEleccion32.setChecked(false);

        selecComidaFragment.cbEleccion11.setChecked(false);
        selecComidaFragment.cbEleccion12.setChecked(false);
        selecComidaFragment.cbEleccion13.setChecked(false);
        selecComidaFragment.cbEleccion14.setChecked(false);
        selecComidaFragment.cbEleccion21.setChecked(false);
        selecComidaFragment.cbEleccion22.setChecked(false);
        selecComidaFragment.cbEleccion23.setChecked(false);
        selecComidaFragment.cbEleccion24.setChecked(false);
        selecComidaFragment.cbEleccion31.setChecked(false);
        selecComidaFragment.cbEleccion32.setChecked(false);
        selecComidaFragment.cbEleccion33.setChecked(false);
        selecComidaFragment.cbEleccion34.setChecked(false);

        selecMeriendaFragment.cbEleccion11.setChecked(false);
        selecMeriendaFragment.cbEleccion12.setChecked(false);
        selecMeriendaFragment.cbEleccion21.setChecked(false);
        selecMeriendaFragment.cbEleccion22.setChecked(false);
        selecMeriendaFragment.cbEleccion23.setChecked(false);
        selecMeriendaFragment.cbEleccion24.setChecked(false);

        selecCenaFragment.cbEleccion11.setChecked(false);
        selecCenaFragment.cbEleccion12.setChecked(false);
        selecCenaFragment.cbEleccion13.setChecked(false);
        selecCenaFragment.cbEleccion14.setChecked(false);
        selecCenaFragment.cbEleccion21.setChecked(false);
        selecCenaFragment.cbEleccion22.setChecked(false);
        selecCenaFragment.cbEleccion23.setChecked(false);
        selecCenaFragment.cbEleccion24.setChecked(false);
        selecCenaFragment.cbEleccion31.setChecked(false);
        selecCenaFragment.cbEleccion32.setChecked(false);
        selecCenaFragment.cbEleccion33.setChecked(false);
        selecCenaFragment.cbEleccion34.setChecked(false);


        FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
        transition.show(selecHorarioFragment);
        transition.hide(selecDiaFragment);
        transition.commit();

    }
    public void goToDia(View v){
        FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
        transition.show(selecDiaFragment);
        transition.hide(selecHorarioFragment);
        transition.commit();
    }
    public void selecHorarioHoy(View v){

        IDCama = v.getId();

        menu.setDia("Hoy");

        selecMenuFragment.cbEleccion11.setChecked(false);
        selecMenuFragment.cbEleccion12.setChecked(false);
        selecMenuFragment.cbEleccion21.setChecked(false);
        selecMenuFragment.cbEleccion22.setChecked(false);
        selecMenuFragment.cbEleccion23.setChecked(false);
        selecMenuFragment.cbEleccion31.setChecked(false);
        selecMenuFragment.cbEleccion32.setChecked(false);

        selecComidaFragment.cbEleccion11.setChecked(false);
        selecComidaFragment.cbEleccion12.setChecked(false);
        selecComidaFragment.cbEleccion13.setChecked(false);
        selecComidaFragment.cbEleccion14.setChecked(false);
        selecComidaFragment.cbEleccion21.setChecked(false);
        selecComidaFragment.cbEleccion22.setChecked(false);
        selecComidaFragment.cbEleccion23.setChecked(false);
        selecComidaFragment.cbEleccion24.setChecked(false);
        selecComidaFragment.cbEleccion31.setChecked(false);
        selecComidaFragment.cbEleccion32.setChecked(false);
        selecComidaFragment.cbEleccion33.setChecked(false);
        selecComidaFragment.cbEleccion34.setChecked(false);

        selecMeriendaFragment.cbEleccion11.setChecked(false);
        selecMeriendaFragment.cbEleccion12.setChecked(false);
        selecMeriendaFragment.cbEleccion21.setChecked(false);
        selecMeriendaFragment.cbEleccion22.setChecked(false);
        selecMeriendaFragment.cbEleccion23.setChecked(false);
        selecMeriendaFragment.cbEleccion24.setChecked(false);

        selecCenaFragment.cbEleccion11.setChecked(false);
        selecCenaFragment.cbEleccion12.setChecked(false);
        selecCenaFragment.cbEleccion13.setChecked(false);
        selecCenaFragment.cbEleccion14.setChecked(false);
        selecCenaFragment.cbEleccion21.setChecked(false);
        selecCenaFragment.cbEleccion22.setChecked(false);
        selecCenaFragment.cbEleccion23.setChecked(false);
        selecCenaFragment.cbEleccion24.setChecked(false);
        selecCenaFragment.cbEleccion31.setChecked(false);
        selecCenaFragment.cbEleccion32.setChecked(false);
        selecCenaFragment.cbEleccion33.setChecked(false);
        selecCenaFragment.cbEleccion34.setChecked(false);

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
    public void compDes(View v){
        HashMap<String,ArrayList<String>> map;
        map = new HashMap<>();
        if(menu.getDia().equals("Hoy")){
            if(selecMenuFragment.cbEleccion11.isChecked()){
                Log.v("DESY","SELECC");
                map = menu.getMenuDia1();
                ArrayList current = new ArrayList();
                current =  map.get("Desayuno");
                Log.v("DESY",current.toString());
                current.add((String)selecMenuFragment.cbEleccion11.getText());
                menu.setMenuDia1(map);
            }
            if(selecMenuFragment.cbEleccion12.isChecked()){
                map = menu.getMenuDia1();
                map.get("Desayuno").add((String)selecMenuFragment.cbEleccion12.getText());
                menu.setMenuDia1(map);
            }
            if(selecMenuFragment.cbEleccion21.isChecked()){
                map = menu.getMenuDia1();
                map.get("Desayuno").add((String)selecMenuFragment.cbEleccion21.getText());
                menu.setMenuDia1(map);
            }
            if(selecMenuFragment.cbEleccion22.isChecked()){
                map = menu.getMenuDia1();
                map.get("Desayuno").add((String)selecMenuFragment.cbEleccion22.getText());
                menu.setMenuDia1(map);
            }
            if(selecMenuFragment.cbEleccion23.isChecked()){
                map = menu.getMenuDia1();
                map.get("Desayuno").add((String)selecMenuFragment.cbEleccion23.getText());
                menu.setMenuDia1(map);
            }
            if(selecMenuFragment.cbEleccion31.isChecked()){
                map = menu.getMenuDia1();
                map.get("Desayuno").add((String)selecMenuFragment.cbEleccion31.getText());
                menu.setMenuDia1(map);
            }
            if(selecMenuFragment.cbEleccion32.isChecked()){
                map = menu.getMenuDia1();
                map.get("Desayuno").add((String)selecMenuFragment.cbEleccion32.getText());
                menu.setMenuDia1(map);
            }
        }
        if(menu.getDia().equals("Manana")){
            if(selecMenuFragment.cbEleccion11.isChecked()){
                map = menu.getMenuDia2();
                map.get("Desayuno").add((String)selecMenuFragment.cbEleccion11.getText());
                menu.setMenuDia2(map);
            }
            if(selecMenuFragment.cbEleccion12.isChecked()){
                map = menu.getMenuDia2();
                map.get("Desayuno").add((String)selecMenuFragment.cbEleccion12.getText());
                menu.setMenuDia2(map);
            }
            if(selecMenuFragment.cbEleccion21.isChecked()){
                map = menu.getMenuDia2();
                map.get("Desayuno").add((String)selecMenuFragment.cbEleccion21.getText());
                menu.setMenuDia2(map);
            }
            if(selecMenuFragment.cbEleccion22.isChecked()){
                map = menu.getMenuDia2();
                map.get("Desayuno").add((String)selecMenuFragment.cbEleccion22.getText());
                menu.setMenuDia2(map);
            }
            if(selecMenuFragment.cbEleccion23.isChecked()){
                map = menu.getMenuDia2();
                map.get("Desayuno").add((String)selecMenuFragment.cbEleccion23.getText());
                menu.setMenuDia2(map);
            }
            if(selecMenuFragment.cbEleccion31.isChecked()){
                map = menu.getMenuDia2();
                map.get("Desayuno").add((String)selecMenuFragment.cbEleccion31.getText());
                menu.setMenuDia2(map);
            }
            if(selecMenuFragment.cbEleccion32.isChecked()){
                map = menu.getMenuDia2();
                map.get("Desayuno").add((String)selecMenuFragment.cbEleccion32.getText());
                menu.setMenuDia2(map);
            }
        }

        FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
        transition.show(selecHorarioFragment);
        transition.hide(selecMenuFragment);
        transition.commit();
    }
    public void compCom(View v){
        HashMap<String,ArrayList<String>> map;
        map = new HashMap<>();
        if(v.getId()==R.id.btnFinalizarCom){
            if(menu.getDia().equals("Hoy")){
                if(selecComidaFragment.cbEleccion11.isChecked()){
                    map = menu.getMenuDia1();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion11.getText());
                    menu.setMenuDia1(map);
                }
                if(selecComidaFragment.cbEleccion12.isChecked()){
                    map = menu.getMenuDia1();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion12.getText());
                    menu.setMenuDia1(map);
                }
                if(selecComidaFragment.cbEleccion13.isChecked()){
                    map = menu.getMenuDia1();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion13.getText());
                    menu.setMenuDia1(map);
                }
                if(selecComidaFragment.cbEleccion14.isChecked()){
                    map = menu.getMenuDia1();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion14.getText());
                    menu.setMenuDia1(map);
                }
                if(selecComidaFragment.cbEleccion21.isChecked()){
                    map = menu.getMenuDia1();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion21.getText());
                    menu.setMenuDia1(map);
                }
                if(selecComidaFragment.cbEleccion22.isChecked()){
                    map = menu.getMenuDia1();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion22.getText());
                    menu.setMenuDia1(map);
                }
                if(selecComidaFragment.cbEleccion23.isChecked()){
                    map = menu.getMenuDia1();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion23.getText());
                    menu.setMenuDia1(map);
                }
                if(selecComidaFragment.cbEleccion24.isChecked()){
                    map = menu.getMenuDia1();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion24.getText());
                    menu.setMenuDia1(map);
                }
                if(selecComidaFragment.cbEleccion31.isChecked()){
                    map = menu.getMenuDia1();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion31.getText());
                    menu.setMenuDia1(map);
                }
                if(selecComidaFragment.cbEleccion32.isChecked()){
                    map = menu.getMenuDia1();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion32.getText());
                    menu.setMenuDia1(map);
                }
                if(selecComidaFragment.cbEleccion33.isChecked()){
                    map = menu.getMenuDia1();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion33.getText());
                    menu.setMenuDia1(map);
                }
                if(selecComidaFragment.cbEleccion34.isChecked()){
                    map = menu.getMenuDia1();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion34.getText());
                    menu.setMenuDia1(map);
                }
            }
            if(menu.getDia().equals("Manana")){
                if(selecComidaFragment.cbEleccion11.isChecked()){
                    map = menu.getMenuDia2();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion11.getText());
                    menu.setMenuDia2(map);
                }
                if(selecComidaFragment.cbEleccion12.isChecked()){
                    map = menu.getMenuDia2();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion12.getText());
                    menu.setMenuDia2(map);
                }
                if(selecComidaFragment.cbEleccion13.isChecked()){
                    map = menu.getMenuDia2();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion13.getText());
                    menu.setMenuDia2(map);
                }
                if(selecComidaFragment.cbEleccion14.isChecked()){
                    map = menu.getMenuDia2();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion14.getText());
                    menu.setMenuDia2(map);
                }
                if(selecComidaFragment.cbEleccion21.isChecked()){
                    map = menu.getMenuDia2();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion21.getText());
                    menu.setMenuDia2(map);
                }
                if(selecComidaFragment.cbEleccion22.isChecked()){
                    map = menu.getMenuDia2();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion22.getText());
                    menu.setMenuDia2(map);
                }
                if(selecComidaFragment.cbEleccion23.isChecked()){
                    map = menu.getMenuDia2();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion23.getText());
                    menu.setMenuDia2(map);
                }
                if(selecComidaFragment.cbEleccion24.isChecked()){
                    map = menu.getMenuDia2();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion24.getText());
                    menu.setMenuDia2(map);
                }
                if(selecComidaFragment.cbEleccion31.isChecked()){
                    map = menu.getMenuDia2();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion31.getText());
                    menu.setMenuDia2(map);
                }
                if(selecComidaFragment.cbEleccion32.isChecked()){
                    map = menu.getMenuDia2();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion32.getText());
                    menu.setMenuDia2(map);
                }
                if(selecComidaFragment.cbEleccion33.isChecked()){
                    map = menu.getMenuDia2();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion33.getText());
                    menu.setMenuDia2(map);
                }
                if(selecComidaFragment.cbEleccion34.isChecked()){
                    map = menu.getMenuDia2();
                    map.get("Comida").add((String)selecComidaFragment.cbEleccion34.getText());
                    menu.setMenuDia2(map);
                }
            }

            FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
            transition.show(selecHorarioFragment);
            transition.hide(selecComidaFragment);
            transition.commit();
        }
    }
    public void compMer(View v){
        HashMap<String,ArrayList<String>> map;
        map = new HashMap<>();
        if(v.getId()==R.id.btnFinalizarMer){
            if(menu.getDia().equals("Hoy")){
                if(selecMeriendaFragment.cbEleccion11.isChecked()){
                    map = menu.getMenuDia1();
                    map.get("Merienda").add((String)selecMeriendaFragment.cbEleccion11.getText());
                    menu.setMenuDia1(map);
                }
                if(selecMeriendaFragment.cbEleccion12.isChecked()){
                    map = menu.getMenuDia1();
                    map.get("Merienda").add((String)selecMeriendaFragment.cbEleccion12.getText());
                    menu.setMenuDia1(map);
                }
                if(selecMeriendaFragment.cbEleccion21.isChecked()){
                    map = menu.getMenuDia1();
                    map.get("Merienda").add((String)selecMeriendaFragment.cbEleccion21.getText());
                    menu.setMenuDia1(map);
                }
                if(selecMeriendaFragment.cbEleccion22.isChecked()){
                    map = menu.getMenuDia1();
                    map.get("Merienda").add((String)selecMeriendaFragment.cbEleccion22.getText());
                    menu.setMenuDia1(map);
                }
                if(selecMeriendaFragment.cbEleccion23.isChecked()){
                    map = menu.getMenuDia1();
                    map.get("Merienda").add((String)selecMeriendaFragment.cbEleccion23.getText());
                    menu.setMenuDia1(map);
                }
                if(selecMeriendaFragment.cbEleccion24.isChecked()){
                    map = menu.getMenuDia1();
                    map.get("Merienda").add((String)selecMeriendaFragment.cbEleccion24.getText());
                    menu.setMenuDia1(map);
                }
            }
            if(menu.getDia().equals("Manana")){
                if(selecMeriendaFragment.cbEleccion11.isChecked()){
                    map = menu.getMenuDia2();
                    map.get("Merienda").add((String)selecMeriendaFragment.cbEleccion11.getText());
                    menu.setMenuDia2(map);
                }
                if(selecMeriendaFragment.cbEleccion12.isChecked()){
                    map = menu.getMenuDia2();
                    map.get("Merienda").add((String)selecMeriendaFragment.cbEleccion12.getText());
                    menu.setMenuDia2(map);
                }
                if(selecMeriendaFragment.cbEleccion21.isChecked()){
                    map = menu.getMenuDia2();
                    map.get("Merienda").add((String)selecMeriendaFragment.cbEleccion21.getText());
                    menu.setMenuDia2(map);
                }
                if(selecMeriendaFragment.cbEleccion22.isChecked()){
                    map = menu.getMenuDia2();
                    map.get("Merienda").add((String)selecMeriendaFragment.cbEleccion22.getText());
                    menu.setMenuDia2(map);
                }
                if(selecMeriendaFragment.cbEleccion23.isChecked()){
                    map = menu.getMenuDia2();
                    map.get("Merienda").add((String)selecMeriendaFragment.cbEleccion23.getText());
                    menu.setMenuDia2(map);
                }
                if(selecMeriendaFragment.cbEleccion24.isChecked()){
                    map = menu.getMenuDia2();
                    map.get("Merienda").add((String)selecMeriendaFragment.cbEleccion24.getText());
                    menu.setMenuDia2(map);
                }
            }
            FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
            transition.show(selecHorarioFragment);
            transition.hide(selecMeriendaFragment);
            transition.commit();
        }

    }
    public void compCen(View v) {
        HashMap<String, ArrayList<String>> map;
        map = new HashMap<>();
        if(v.getId()==R.id.btnFinalizarCen){
            if(menu.getDia().equals("Hoy")){
                if(selecCenaFragment.cbEleccion11.isChecked()){
                    map = menu.getMenuDia1();
                    map.get("Cena").add((String)selecCenaFragment.cbEleccion11.getText());
                    menu.setMenuDia1(map);
                }
                if(selecCenaFragment.cbEleccion12.isChecked()){
                    map = menu.getMenuDia1();
                    map.get("Cena").add((String)selecCenaFragment.cbEleccion12.getText());
                    menu.setMenuDia1(map);
                }
                if(selecCenaFragment.cbEleccion13.isChecked()){
                    map = menu.getMenuDia1();
                    map.get("Cena").add((String)selecCenaFragment.cbEleccion13.getText());
                    menu.setMenuDia1(map);
                }
                if(selecCenaFragment.cbEleccion14.isChecked()){
                    map = menu.getMenuDia1();
                    map.get("Cena").add((String)selecCenaFragment.cbEleccion14.getText());
                    menu.setMenuDia1(map);
                }
                if(selecCenaFragment.cbEleccion21.isChecked()){
                    map = menu.getMenuDia1();
                    map.get("Cena").add((String)selecCenaFragment.cbEleccion21.getText());
                    menu.setMenuDia1(map);
                }
                if(selecCenaFragment.cbEleccion22.isChecked()){
                    map = menu.getMenuDia1();
                    map.get("Cena").add((String)selecCenaFragment.cbEleccion22.getText());
                    menu.setMenuDia1(map);
                }
                if(selecCenaFragment.cbEleccion23.isChecked()){
                    map = menu.getMenuDia1();
                    map.get("Cena").add((String)selecCenaFragment.cbEleccion23.getText());
                    menu.setMenuDia1(map);
                }
                if(selecCenaFragment.cbEleccion24.isChecked()){
                    map = menu.getMenuDia1();
                    map.get("Cena").add((String)selecCenaFragment.cbEleccion24.getText());
                    menu.setMenuDia1(map);
                }
                if(selecCenaFragment.cbEleccion31.isChecked()){
                    map = menu.getMenuDia1();
                    map.get("Cena").add((String)selecCenaFragment.cbEleccion31.getText());
                    menu.setMenuDia1(map);
                }
                if(selecCenaFragment.cbEleccion32.isChecked()){
                    map = menu.getMenuDia1();
                    map.get("Cena").add((String)selecCenaFragment.cbEleccion32.getText());
                    menu.setMenuDia1(map);
                }
                if(selecCenaFragment.cbEleccion33.isChecked()){
                    map = menu.getMenuDia1();
                    map.get("Cena").add((String)selecCenaFragment.cbEleccion33.getText());
                    menu.setMenuDia1(map);
                }
                if(selecCenaFragment.cbEleccion34.isChecked()){
                    map = menu.getMenuDia1();
                    map.get("Cena").add((String)selecCenaFragment.cbEleccion34.getText());
                    menu.setMenuDia1(map);
                }
            }
            if(menu.getDia().equals("Manana")){
                if(selecCenaFragment.cbEleccion11.isChecked()){
                    map = menu.getMenuDia2();
                    map.get("Cena").add((String)selecCenaFragment.cbEleccion11.getText());
                    menu.setMenuDia2(map);
                }
                if(selecCenaFragment.cbEleccion12.isChecked()){
                    map = menu.getMenuDia2();
                    map.get("Cena").add((String)selecCenaFragment.cbEleccion12.getText());
                    menu.setMenuDia2(map);
                }
                if(selecCenaFragment.cbEleccion13.isChecked()){
                    map = menu.getMenuDia2();
                    map.get("Cena").add((String)selecCenaFragment.cbEleccion13.getText());
                    menu.setMenuDia2(map);
                }
                if(selecCenaFragment.cbEleccion14.isChecked()){
                    map = menu.getMenuDia2();
                    map.get("Cena").add((String)selecCenaFragment.cbEleccion14.getText());
                    menu.setMenuDia2(map);
                }
                if(selecCenaFragment.cbEleccion21.isChecked()){
                    map = menu.getMenuDia2();
                    map.get("Cena").add((String)selecCenaFragment.cbEleccion21.getText());
                    menu.setMenuDia2(map);
                }
                if(selecCenaFragment.cbEleccion22.isChecked()){
                    map = menu.getMenuDia2();
                    map.get("Cena").add((String)selecCenaFragment.cbEleccion22.getText());
                    menu.setMenuDia2(map);
                }
                if(selecCenaFragment.cbEleccion23.isChecked()){
                    map = menu.getMenuDia2();
                    map.get("Cena").add((String)selecCenaFragment.cbEleccion23.getText());
                    menu.setMenuDia2(map);
                }
                if(selecCenaFragment.cbEleccion24.isChecked()){
                    map = menu.getMenuDia2();
                    map.get("Cena").add((String)selecCenaFragment.cbEleccion24.getText());
                    menu.setMenuDia2(map);
                }
                if(selecCenaFragment.cbEleccion31.isChecked()){
                    map = menu.getMenuDia2();
                    map.get("Cena").add((String)selecCenaFragment.cbEleccion31.getText());
                    menu.setMenuDia2(map);
                }
                if(selecCenaFragment.cbEleccion32.isChecked()){
                    map = menu.getMenuDia2();
                    map.get("Cena").add((String)selecCenaFragment.cbEleccion32.getText());
                    menu.setMenuDia2(map);
                }
                if(selecCenaFragment.cbEleccion33.isChecked()){
                    map = menu.getMenuDia2();
                    map.get("Cena").add((String)selecCenaFragment.cbEleccion33.getText());
                    menu.setMenuDia2(map);
                }
                if(selecCenaFragment.cbEleccion34.isChecked()){
                    map = menu.getMenuDia2();
                    map.get("Cena").add((String)selecCenaFragment.cbEleccion34.getText());
                    menu.setMenuDia2(map);
                }
            }
            FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
            transition.show(selecHorarioFragment);
            transition.hide(selecCenaFragment);
            transition.commit();
        }
    }
    public void FormuFinal(View v) throws UnsupportedEncodingException{
        PHPost phPost = new PHPost(menu);
        phPost.GetText();
    }
    public void pasarFormuFinal(View v)  {
        //SETERS
        formularioFinalFragment.etxtDesayuno1.setText(menu.getMenuDia1().get("Desayuno").get(0));
        formularioFinalFragment.etxtDesayuno2.setText(menu.getMenuDia1().get("Desayuno").get(1));
        formularioFinalFragment.etxtDesayuno3.setText(menu.getMenuDia1().get("Desayuno").get(2));

        formularioFinalFragment.etxtComida1.setText(menu.getMenuDia1().get("Comida").get(0));
        formularioFinalFragment.etxtComida2.setText(menu.getMenuDia1().get("Comida").get(1));
        formularioFinalFragment.etxtComida3.setText(menu.getMenuDia1().get("Comida").get(2));

        formularioFinalFragment.etxtMerienda1.setText(menu.getMenuDia1().get("Merienda").get(0));
        formularioFinalFragment.etxtMerienda2.setText(menu.getMenuDia1().get("Merienda").get(1));

        formularioFinalFragment.etxtCena1.setText(menu.getMenuDia1().get("Cena").get(0));
        formularioFinalFragment.etxtCena2.setText(menu.getMenuDia1().get("Cena").get(1));
        formularioFinalFragment.etxtCena3.setText(menu.getMenuDia1().get("Cena").get(2));


        formularioFinalFragment.etxtDesayuno1Ma.setText(menu.getMenuDia2().get("Desayuno").get(0));
        formularioFinalFragment.etxtDesayuno2Ma.setText(menu.getMenuDia2().get("Desayuno").get(1));
        formularioFinalFragment.etxtDesayuno3Ma.setText(menu.getMenuDia2().get("Desayuno").get(2));

        formularioFinalFragment.etxtComida1Ma.setText(menu.getMenuDia2().get("Comida").get(0));
        formularioFinalFragment.etxtComida2Ma.setText(menu.getMenuDia2().get("Comida").get(1));
        formularioFinalFragment.etxtComida3Ma.setText(menu.getMenuDia2().get("Comida").get(2));

        formularioFinalFragment.etxtMerienda1Ma.setText(menu.getMenuDia2().get("Merienda").get(0));
        formularioFinalFragment.etxtMerienda2Ma.setText(menu.getMenuDia2().get("Merienda").get(1));

        formularioFinalFragment.etxtCena1Ma.setText(menu.getMenuDia2().get("Cena").get(0));
        formularioFinalFragment.etxtCena2Ma.setText(menu.getMenuDia2().get("Cena").get(1));
        formularioFinalFragment.etxtCena3Ma.setText(menu.getMenuDia2().get("Cena").get(2));
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

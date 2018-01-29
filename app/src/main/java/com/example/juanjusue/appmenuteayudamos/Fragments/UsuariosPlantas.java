package com.example.juanjusue.appmenuteayudamos.Fragments;

import android.util.Log;

import com.example.juanjusue.appmenuteayudamos.Objetos.Usuarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by juan.jusue on 29/01/2018.
 */

public class UsuariosPlantas {

 //   public HashMap<String,String> usuario;
    public List<Usuarios> usuariosList =new ArrayList<Usuarios>();;

    public UsuariosPlantas(){
        Usuarios user1 = new Usuarios("Planta1","asdf1234");
        Usuarios user2 = new Usuarios("Planta2","asdf1234");
        Usuarios user3 = new Usuarios("Planta3","asdf1234");
        Usuarios user4 = new Usuarios("Planta4","asdf1234");

        usuariosList.add(user1);
        usuariosList.add(user2);
        usuariosList.add(user3);

    }
    public boolean esUser(String user, String pass){

        Usuarios usertemp = new Usuarios(user,pass);

        for (int i=0;i<usuariosList.size();i++){
            if(usuariosList.get(i).getUser().equals(user)&&usuariosList.get(i).getPass().equals(pass)){
                return true;
            }
        }
        return false;
    }

}

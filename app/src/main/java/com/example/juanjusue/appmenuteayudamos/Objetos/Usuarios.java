package com.example.juanjusue.appmenuteayudamos.Objetos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juan.jusue on 29/01/2018.
 */

public class Usuarios {
    public List<Usuarios> usuariosList =new ArrayList<Usuarios>();;
    String pass;
    String user;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Usuarios(String user, String pass){
        this.pass = pass;
        this.user = user;
    }
    public Usuarios(){

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

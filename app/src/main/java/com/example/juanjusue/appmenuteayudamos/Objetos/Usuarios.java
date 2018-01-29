package com.example.juanjusue.appmenuteayudamos.Objetos;

/**
 * Created by juan.jusue on 29/01/2018.
 */

public class Usuarios {
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

}

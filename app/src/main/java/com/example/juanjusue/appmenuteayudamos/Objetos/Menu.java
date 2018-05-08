package com.example.juanjusue.appmenuteayudamos.Objetos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jjr on 8/05/18.
 */

public class Menu {
    HashMap<String,ArrayList<String>>menuDia1;
    HashMap<String,ArrayList<String>>menuDia2;
    String dia;

    public void Menu(){

        //Menu 1
        menuDia1 = new HashMap<String,ArrayList<String>>();
        menuDia1.put("Desayuno", new ArrayList<String>());
        menuDia1.put("Comida", new ArrayList<String>());
        menuDia1.put("Merienda", new ArrayList<String>());
        menuDia1.put("Cena", new ArrayList<String>());
        //Menu 2
        menuDia2 = new HashMap<String,ArrayList<String>>();
        menuDia2.put("Desayuno", new ArrayList<String>());
        menuDia2.put("Comida", new ArrayList<String>());
        menuDia2.put("Merienda", new ArrayList<String>());
        menuDia2.put("Cena", new ArrayList<String>());

    }

    public HashMap<String, ArrayList<String>> getMenuDia1() {
        return menuDia1;
    }

    public void setMenuDia1(HashMap<String, ArrayList<String>> menuDia1) {
        this.menuDia1 = menuDia1;
    }

    public HashMap<String, ArrayList<String>> getMenuDia2() {
        return menuDia2;
    }

    public void setMenuDia2(HashMap<String, ArrayList<String>> menuDia2) {
        this.menuDia2 = menuDia2;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
}

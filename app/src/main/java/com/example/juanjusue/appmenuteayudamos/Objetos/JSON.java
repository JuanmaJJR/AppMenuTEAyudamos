package com.example.juanjusue.appmenuteayudamos.Objetos;

import com.example.juanjusue.appmenuteayudamos.MainActivity;

import java.io.OutputStream;

public class JSON {
    OutputStream outputStream;
    String sJSON;
    MainActivity main;
    JSONListener events;

    public JSON(MainActivity main){

        this.main = main;
        events = new JSONListener(this);
        sJSON = "no";

        ///_______DESCARGA DEL JSON_________\\\
        //HttpJsonAsyncTask httpJsonAsyncTask1=new HttpJsonAsyncTask(main);
        //httpJsonAsyncTask1.setListener(events);
        //String url1 = String.format("http://10.0.2.2/pruebasJSON/leeJugadores.php");
        //httpJsonAsyncTask1.execute(url1);
        ///___________________________________\\\

    }
    public String getJSON(){
        return this.sJSON;
    }
    public void setJSON(OutputStream outputStream){
        this.outputStream = outputStream;
    }

}

class JSONListener {

    JSON json;

    public JSONListener(JSON json){
        this.json = json;
    }


}

package com.example.juanjusue.appmenuteayudamos.Objetos;

import android.view.View;

import com.example.juanjusue.appmenuteayudamos.Asynctasks.HttpJsonAsyncTask;
import com.example.juanjusue.appmenuteayudamos.Asynctasks.HttpJsonAsyncTaskListener;
import com.example.juanjusue.appmenuteayudamos.MainActivity;

public class JSON {
    String sJSON;
    MainActivity main;
    JSONListener events;

    public JSON(MainActivity main){

        this.main = main;
        events = new JSONListener(this);
        sJSON = "no";

        ///_______DESCARGA DEL JSON_________\\\
        HttpJsonAsyncTask httpJsonAsyncTask1=new HttpJsonAsyncTask(main);
        httpJsonAsyncTask1.setListener(events);
        String url1 = String.format("http://10.0.2.2/pruebasJSON/leeJugadores.php");
        httpJsonAsyncTask1.execute(url1);
        ///___________________________________\\\

    }
    public String getJSON(){
        return this.sJSON;
    }
    public void setJSON(String sJSON){
        this.sJSON = sJSON;
    }
}

class JSONListener implements HttpJsonAsyncTaskListener {

    JSON json;

    public JSONListener(JSON json){
        this.json = json;
    }

    @Override
    public void JsonOk(String s) {
        json.setJSON(s);
    }
}

package com.example.juanjusue.appmenuteayudamos.Asynctasks;

/**
 * Created by jjr on 3/05/18.
 */

import android.os.AsyncTask;
import android.util.Log;

import com.example.juanjusue.appmenuteayudamos.MainActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpJsonAsyncTask extends AsyncTask<String,Integer,String> {

    public static final String REQUEST_METHOD = "GET";
    public static final int READ_TIMEOUT = 15000;
    public static final int CONNECTION_TIMEOUT = 15000;
    HttpJsonAsyncTaskListener httpJsonAsyncTaskListener;


    public HttpJsonAsyncTask(MainActivity mainActivity){

    }
    public void setListener(HttpJsonAsyncTaskListener listener) {
        this.httpJsonAsyncTaskListener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... urls) {

        String stringUrl = urls[0];
        String result;
        String inputLine;
        try {
            //Create a URL object holding our url
            URL myUrl = new URL(stringUrl);
            //Create a connection
            HttpURLConnection connection =(HttpURLConnection)
                    myUrl.openConnection();
            //Set methods and timeouts
            connection.setRequestMethod(REQUEST_METHOD);
            connection.setReadTimeout(READ_TIMEOUT);
            connection.setConnectTimeout(CONNECTION_TIMEOUT);

            //Connect to our url
            connection.connect();
            //Create a new InputStreamReader
            InputStreamReader streamReader = new
                    InputStreamReader(connection.getInputStream());
            //Create a new buffered reader and String Builder
            BufferedReader reader = new BufferedReader(streamReader);
            StringBuilder stringBuilder = new StringBuilder();
            //Check if the line we are reading is not null
            while((inputLine = reader.readLine()) != null){
                stringBuilder.append(inputLine);
            }
            //Close our InputStream and Buffered reader
            reader.close();
            streamReader.close();
            //Set our result equal to our stringBuilder
            result = stringBuilder.toString();
        }
        catch(IOException e){
            e.printStackTrace();
            result = null;
        }
        return result;


    }


    @Override
    protected void onProgressUpdate(Integer... values) {

    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.v("httpjson","JSON DESCARGADO"+s);
        httpJsonAsyncTaskListener.JsonOk(s);
    }
}
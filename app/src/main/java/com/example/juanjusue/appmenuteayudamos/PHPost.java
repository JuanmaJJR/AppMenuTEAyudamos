package com.example.juanjusue.appmenuteayudamos;

import android.os.Bundle;

import com.example.juanjusue.appmenuteayudamos.Objetos.Menu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by JuanmaJR on 17/06/2018.
 */

public class PHPost {
    Menu menu;

    String DesayHoy1;
    String DesayHoy2;
    String DesayHoy3;

    String ComHoy1;
    String ComHoy2;
    String ComHoy3;

    String MerHoy1;
    String MerHoy2;

    String CenaHoy1;
    String CenaHoy2;
    String CenaHoy3;


    String DesayMan1;
    String DesayMan2;
    String DesayMan3;

    String ComMan1;
    String ComMan2;
    String ComMan3;

    String MerMan1;
    String MerMan2;

    String CenaMan1;
    String CenaMan2;
    String CenaMan3;

    public PHPost(Menu menu) {
        this.menu = menu;

        DesayHoy1 = menu.getMenuDia1().get("desayuno").get(0);
        DesayHoy2 = menu.getMenuDia1().get("desayuno").get(1);
        DesayHoy3 = menu.getMenuDia1().get("desayuno").get(2);

        ComHoy1 = menu.getMenuDia1().get("comida").get(0);
        ComHoy2 = menu.getMenuDia1().get("comida").get(1);
        ComHoy3 = menu.getMenuDia1().get("comida").get(2);

        MerHoy1 = menu.getMenuDia1().get("merienda").get(0);
        MerHoy2 = menu.getMenuDia1().get("merienda").get(1);

        CenaHoy1 = menu.getMenuDia1().get("cena").get(0);
        CenaHoy2 = menu.getMenuDia1().get("cena").get(1);
        CenaHoy3 = menu.getMenuDia1().get("cena").get(2);


        DesayMan1 = menu.getMenuDia2().get("desayuno").get(0);
        DesayMan2 = menu.getMenuDia2().get("desayuno").get(1);
        DesayMan3 = menu.getMenuDia2().get("desayuno").get(2);

        ComMan1 = menu.getMenuDia2().get("comida").get(0);
        ComMan2 = menu.getMenuDia2().get("comida").get(1);
        ComMan3 = menu.getMenuDia2().get("comida").get(2);

        MerMan1 = menu.getMenuDia2().get("merienda").get(0);
        MerMan2 = menu.getMenuDia2().get("merienda").get(1);

        CenaMan1 = menu.getMenuDia2().get("cena").get(0);
        CenaMan2 = menu.getMenuDia2().get("cena").get(1);
        CenaMan3 = menu.getMenuDia2().get("cena").get(2);

    }

    // Create GetText Metod
    public  void  GetText()  throws UnsupportedEncodingException
    {
        // Get user defined values


        // Create data variable for sent values to server

        String data = URLEncoder.encode("DesayHoy1", "UTF-8")
                + "=" + URLEncoder.encode(DesayHoy1, "UTF-8");

        data += "&" + URLEncoder.encode("DesayHoy2", "UTF-8") + "="
                + URLEncoder.encode(DesayHoy2, "UTF-8");

        data += "&" + URLEncoder.encode("DesayHoy3", "UTF-8")
                + "=" + URLEncoder.encode(DesayHoy3, "UTF-8");

        data += "&" + URLEncoder.encode("ComHoy1", "UTF-8")
                + "=" + URLEncoder.encode(ComHoy1, "UTF-8");

        data += "&" + URLEncoder.encode("ComHoy2", "UTF-8")
                + "=" + URLEncoder.encode(ComHoy2, "UTF-8");

        data += "&" + URLEncoder.encode("ComHoy3", "UTF-8")
                + "=" + URLEncoder.encode(ComHoy3, "UTF-8");

        data += "&" + URLEncoder.encode("MerHoy1", "UTF-8")
                + "=" + URLEncoder.encode(MerHoy1, "UTF-8");

        data += "&" + URLEncoder.encode("MerHoy2", "UTF-8")
                + "=" + URLEncoder.encode(MerHoy2, "UTF-8");

        data += "&" + URLEncoder.encode("CenaHoy1", "UTF-8")
                + "=" + URLEncoder.encode(CenaHoy1, "UTF-8");

        data += "&" + URLEncoder.encode("CenaHoy2", "UTF-8")
                + "=" + URLEncoder.encode(CenaHoy2, "UTF-8");

        data += "&" + URLEncoder.encode("CenaHoy3", "UTF-8")
                + "=" + URLEncoder.encode(CenaHoy3, "UTF-8");

        data += "&" + URLEncoder.encode("DesayMan1", "UTF-8") + "="
                + URLEncoder.encode(DesayMan1, "UTF-8");

        data += "&" + URLEncoder.encode("DesayMan2", "UTF-8")
                + "=" + URLEncoder.encode(DesayMan2, "UTF-8");

        data += "&" + URLEncoder.encode("DesayMan3", "UTF-8")
                + "=" + URLEncoder.encode(DesayMan3, "UTF-8");

        data += "&" + URLEncoder.encode("ComMan1", "UTF-8")
                + "=" + URLEncoder.encode(ComMan1, "UTF-8");

        data += "&" + URLEncoder.encode("ComMan2", "UTF-8")
                + "=" + URLEncoder.encode(ComMan2, "UTF-8");

        data += "&" + URLEncoder.encode("ComMan3", "UTF-8")
                + "=" + URLEncoder.encode(ComMan3, "UTF-8");

        data += "&" + URLEncoder.encode("MerMan1", "UTF-8")
                + "=" + URLEncoder.encode(MerMan1, "UTF-8");

        data += "&" + URLEncoder.encode("MerMan2", "UTF-8")
                + "=" + URLEncoder.encode(MerMan2, "UTF-8");

        data += "&" + URLEncoder.encode("CenaMan1", "UTF-8")
                + "=" + URLEncoder.encode(CenaMan1, "UTF-8");

        data += "&" + URLEncoder.encode("CenaMan2", "UTF-8")
                + "=" + URLEncoder.encode(CenaMan2, "UTF-8");

        data += "&" + URLEncoder.encode("CenaMan3", "UTF-8")
                + "=" + URLEncoder.encode(CenaMan3, "UTF-8");

        String text = "";
        BufferedReader reader=null;

        // Send data
        try
        {

            // Defined URL  where to send data
            URL url = new URL("http://juanmajusue.com/phptea.php");

            // Send POST data request

            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write( data );
            wr.flush();

            // Get the server response

            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;

            // Read Server Response
            while((line = reader.readLine()) != null)
            {
                // Append server response in string
                sb.append(line + "\n");
            }


            text = sb.toString();
        }
        catch(Exception ex)
        {

        }
        finally
        {
            try
            {

                reader.close();
            }

            catch(Exception ex) {}
        }


    }

}
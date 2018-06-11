package com.example.juanjusue.appmenuteayudamos.Fragments;

import android.os.StrictMode;
import android.util.Log;

import com.example.juanjusue.appmenuteayudamos.Objetos.JSON;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class FTPFragment {
    JSON json;
    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

    public FTPFragment(JSON json) {
        this.json = json;
    }

    public Boolean downloadAndSaveFile(String server, int portNumber, String Usuario, String password, String filename, File localFile)
            throws IOException {
                FTPClient ftp = null;

        try {
            ftp = new FTPClient();
            ftp.connect(server, portNumber);
            Log.v("Connected. reply:", ftp.getReplyString());
            ftp.login(Usuario, password);
            Log.v("login","Logged In\"");
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            Log.v("download","Downloading");
            ftp.enterLocalPassiveMode();

            BufferedOutputStream  outputStream = null;
            boolean success = false;
            try {
                outputStream = new BufferedOutputStream(new FileOutputStream(
                        localFile));
                success = ftp.retrieveFile(filename, outputStream);
            } finally {
                if (outputStream != null) {
                    outputStream.close();
                }
            }
            json.setJSON(outputStream);
            return success;
        } finally {
            if (ftp != null) {
            }
        }
    }
}



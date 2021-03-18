package com.example.nearbyplaces;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnection {

    public String readUrl(String strUrl) throws IOException{
        String data = "";
        InputStream inputStream = null;
        HttpURLConnection urlConnection = null;

        try{
            URL url = new URL(strUrl);

            //creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();

            //connecting to url
            urlConnection.connect();

            //reading data from url
            inputStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            StringBuffer sb = new StringBuffer();

            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString();
            Log.d("downloadURL", data.toString());
            br.close();
        }
        catch (Exception e){
            Log.d("Exception",  e.toString());
        }
        finally {
            inputStream.close();
            urlConnection.disconnect();
        }
        return data;
    }
}

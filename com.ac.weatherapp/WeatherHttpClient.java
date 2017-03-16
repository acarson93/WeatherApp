package com.example.ac.weathera;

import android.net.Uri;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by AC on 1/24/2017.
 */
public class WeatherHttpClient {

    public String getWeatherData(String place){
        HttpURLConnection connection = null;
        InputStream input = null;
       // System.out.println("place is " + place);
        String yql = String.format("select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"%s\")",place);
        String endpoint = String.format("https://query.yahooapis.com/v1/public/yql?q=%s&format=json", Uri.encode(yql));


        try{

            URL url = new URL(endpoint);


           // connection = (HttpURLConnection) (new URL(Utilities.URL + place + "&appid=f8b925515d7e9f11e34b3f2b77af910b&units=imperial")).openConnection();
            URLConnection connect = url.openConnection();
           // System.out.println("made it past connect");
            //connection.setRequestMethod("GET");
            //connection.setDoInput(true);
           // connection.setDoInput(true);
           // connection.connect();

           // System.out.println("connected");



            StringBuffer strbuffer = new StringBuffer();
            input = connect.getInputStream();
            BufferedReader buffreader = new BufferedReader(new InputStreamReader(input));
            String line = buffreader.readLine();




            System.out.println("line is " + line);

            return line;

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}

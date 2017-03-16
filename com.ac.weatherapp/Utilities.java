package com.example.ac.weathera;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by AC on 1/24/2017.
 */
public class Utilities {

    public static String URL = "http://api.openweathermap.org/data/2.5/weather?q=";
    public static final String iconURL = "http://openweatherapp.org/img/w";




    public static JSONObject getObj(String name, JSONObject jsonObj) throws JSONException{


        //System.out.println("obj name is " + name);
        JSONObject jobj = jsonObj.getJSONObject(name);

        return jobj;


    }

    public static String getStr(String name, JSONObject jsonObj) throws JSONException{

        return jsonObj.getString(name);

    }

    public static float getFloat(String name, JSONObject jsonObj) throws JSONException{

        return (float)jsonObj.getDouble(name);

    }


    public static double getDouble(String name, JSONObject jsonObj) throws JSONException{

        return (double)jsonObj.getDouble(name);

    }

    public static float getInt(String name, JSONObject jsonObj) throws JSONException{

        return jsonObj.getInt(name);

    }




}

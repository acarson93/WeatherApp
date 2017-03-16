package com.example.ac.weathera;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by AC on 1/24/2017.
 */
public class JSONWeather {


    public static Weather getWeather(String data){

        Weather weather = new Weather();
        String city;
        String country;
        String region;
        double temperature;
        JSONArray array;
        double high;
        double low;


        try {

            JSONObject jobj = new JSONObject(data);


            JSONObject query = jobj.getJSONObject("query");
            JSONObject results = query.getJSONObject("results");
            JSONObject channel = results.getJSONObject("channel");
            JSONObject location = channel.getJSONObject("location");
            JSONObject item = channel.getJSONObject("item");
            JSONObject condition = item.getJSONObject("condition");
            array = item.getJSONArray("forecast");

            JSONObject forecast = array.getJSONObject(0);


            high = forecast.getDouble("high");
            low = forecast.getDouble("low");
            city = location.getString("city");
            country = location.getString("country");
            temperature = condition.getDouble("temp");
            region = location.getString("region");

            weather.setCity(city);
            weather.setCountry(country);
            weather.setTemp(temperature);
            weather.setRegion(region);
            weather.setLow(low);
            weather.setHigh(high);








        }catch(Exception e){
            e.printStackTrace();
        }

        return weather;

    }
}

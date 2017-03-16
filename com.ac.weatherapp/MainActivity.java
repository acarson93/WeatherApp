package com.example.ac.weathera;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONObject;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity  {


    private TextView cityname;
    private TextView temperature;
    private TextView country;
   // private TextView;
    private Button button;
    private EditText input;
    private ImageView image;
    private TextView desc;
    private TextView region;
    private TextView high;
    private TextView low;
    double farenheit;

    Weather weather = new Weather();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityname = (TextView)findViewById(R.id.city);
        temperature = (TextView)findViewById(R.id.temptext);
        country = (TextView)findViewById(R.id.country);
        button = (Button)findViewById(R.id.button);
        input = (EditText) findViewById(R.id.input);
        region = (TextView)findViewById(R.id.region);
        high = (TextView)findViewById(R.id.hightext);
        low = (TextView) findViewById(R.id.lowtext);


        input.getText().clear();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = input.getText().toString();
                render(text);
            }
        });
        //render("sandiego,US");

    }

    public void render(String city){


        WeatherTask w_task = new WeatherTask();

        w_task.execute(new String[]{city});

    }


    private class WeatherTask extends AsyncTask<String, Void, Weather>{


        @Override
        protected Weather doInBackground(String... params) {


            String data = ( (new WeatherHttpClient()).getWeatherData(params[0]));
            //System.out.println("DATA IS " + data);
            weather = JSONWeather.getWeather(data);



            return null;
        }

        @Override
        protected void onPostExecute(Weather wea) {
            super.onPostExecute(weather);

            DecimalFormat df2 = new DecimalFormat(".##");
            String hightext = String.valueOf(weather.getHigh());
            String lowtext = String.valueOf(weather.getLow());


                temperature.setText(df2.format(weather.getTemp()) + " °F");
                cityname.setText(weather.getCity() + ",");
                country.setText(weather.getCountry());
                region.setText(weather.getRegion());
                high.setText(hightext + " °F");
                low.setText(lowtext + " °F");





        }
    }
}

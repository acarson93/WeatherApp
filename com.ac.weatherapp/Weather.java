package com.example.ac.weathera;

/**
 * Created by AC on 1/24/2017.
 */
public class Weather {

   // public Place place;
    //public String iconDate;
    //public Condition condition = new Condition();
    public double temp;
    public String country;
    public String city;
    public String region;
    public double low;
    public double high;

    public double getTemp() {
        return temp;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public void setRegion (String region) {this.region = region;}

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {return region; }

    public void setCity(String city) {
        this.city = city;
    }
}

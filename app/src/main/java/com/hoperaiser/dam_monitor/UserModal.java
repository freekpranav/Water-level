package com.hoperaiser.dam_monitor;

public class UserModal {

    public UserModal(){

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWaterlevel() {
        return waterlevel;
    }

    public void setWaterlevel(String waterlevel) {
        this.waterlevel = waterlevel;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public UserModal(String date, String time, String waterlevel, String temperature, String humidity) {
        this.date = date;
        this.time = time;
        this.waterlevel = waterlevel;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    String date,time,waterlevel,temperature,humidity;
}

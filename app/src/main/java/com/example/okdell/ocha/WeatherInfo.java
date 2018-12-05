package com.example.okdell.ocha;

import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

//info.getMaxTemp();로 사용 가능
public class WeatherInfo {
   // String iconName;
    String[] nowTemp=new String[3];
    String[] weatherId = new String[3];
    String[] weatherMain=new String[3];


    String[] weatherDescription = new String[3];


    String maxTemp;
    String minTemp;
    String humidity;
    String speed;
    String main ;
    String description;

    public WeatherInfo(JSONObject object) {
        try {
            //JSONObject json_main = object.getJSONObject("main");
            for (int i=0;i<3;i++) {
                JSONArray getList = object.getJSONArray("list");
                JSONObject lOne = getList.getJSONObject(i);
                JSONObject getMain = lOne.getJSONObject("main");
                JSONArray getWeather=lOne.getJSONArray("weather");
                JSONObject get2 = getWeather.getJSONObject(0);
                weatherId[i]=get2.getString("id");
                weatherMain[i]=get2.getString("main");
                weatherDescription[i]=get2.getString("description");
                nowTemp[i] = getMain.getString("temp");
            }
            /*
            nowTemp = json_main.getString("temp");
            humidity = json_main.getString("humidity");
            minTemp = json_main.getString("temp_min");
            maxTemp = json_main.getString("temp_max");
           // main = json_main.getString("main");

            JSONArray json_weather = object.getJSONArray("weather");
            //iconName=json_weather.getJSONObject(0).getString("icon");

            JSONObject json_wind = object.getJSONObject("wind");
            speed = String.valueOf(json_wind.getDouble("speed"));
                    //.getString("speed");*/
            //description =json_weather.getJSONObject("description").getString("description");
        }catch (Exception e)
        {

        }
    }
    public String ToString(){
        String ToString ="nowTemp: "+ getNowTemp()[0]+"\n"
                        +"3hr later: " +getNowTemp()[1]+"\n"
                        +"6hr later: "+getNowTemp()[2]+"\n"
                        +"id: " +getWeatherId()[1]+"\n"
                        +"description: " +getWeatherDescription()[1]+"\n"
                        +"main: " +getWeatherMain()[1]+"\n";
                /*
                 "nowTemp : "+ getNowTemp()+"\n"
                +"humidity : "+ getHumidity()+"\n"
                +"speed : "+ getSpeed()+"\n" ;
               // +"description : "+ getDescription()+"\n";
               */
        return ToString;
    }

    public String[] getWeatherId() {
        return weatherId;
    }

    public String[] getWeatherMain() {
        return weatherMain;
    }

    public String[] getNowTemp() {
        return nowTemp;
    }
    public String[] getWeatherDescription() {
        return weatherDescription;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getSpeed() {
        return speed;
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }


    public void setWeatherId(String[] weatherId) {
        this.weatherId = weatherId;
    }

    public void setWeatherMain(String[] weatherMain) {
        this.weatherMain = weatherMain;
    }

    public void setNowTemp(String[] nowTemp) {
        this.nowTemp = nowTemp;
    }

    public void setWeatherDescription(String[] weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

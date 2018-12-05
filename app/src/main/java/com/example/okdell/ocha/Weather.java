package com.example.okdell.ocha;

import android.content.Intent;
import android.util.Log;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Weather extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getWeatherData(37.30,126.97);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void getWeatherData(double lat, double lng){
        String url = "http://api.openweathermap.org/data/2.5/forecast?lat="+lat+"&lon="+lng+"&appid=43735c18b195ded966ff4a6ed49f106e&units=metric";
        //String url = "http://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lng+"&units=metric&appid=43735c18b195ded966ff4a6ed49f106e";
        ReceiveWeatherTask receiveUseTask = new ReceiveWeatherTask();
        receiveUseTask.execute(url);
    }

    private class ReceiveWeatherTask extends AsyncTask<String,Void, JSONObject>{
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
        }

        @Override
        protected JSONObject doInBackground(String...datas){
            try{
                HttpURLConnection conn = (HttpURLConnection) new URL(datas[0]).openConnection();
                conn.setConnectTimeout(10000);
                conn.setReadTimeout(10000);
                conn.connect();

                if(conn.getResponseCode()==HttpURLConnection.HTTP_OK){
                    InputStream is = conn.getInputStream();
                    InputStreamReader reader = new InputStreamReader(is);
                    BufferedReader in = new BufferedReader(reader);

                    String readed;
                    while((readed = in.readLine()) !=null){
                        JSONObject jObject = new JSONObject(readed);
                        return jObject;
                    }
                }else{
                    return null;
                }
                return null;
            } catch(Exception e){
                e.printStackTrace();
            }
            return null;
        }
        private static final String TAG = "MainActivity";
        @Override
        protected void onPostExecute(JSONObject result){
            if(result==null) {
                Toast.makeText(getApplicationContext(),"JSONObject is null",Toast.LENGTH_LONG).show();
                return;
            }
            WeatherInfo info = new WeatherInfo(result);
            String getData = info.ToString();
            Toast.makeText(getApplicationContext(),getData,Toast.LENGTH_LONG).show();
            info.getMaxTemp();
        }

    }


}



package com.swufe.time;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

import java.text.ParseException;

import java.text.SimpleDateFormat;

import java.util.Calendar;

import java.util.Date;

import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
    EditText china;
    TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        china = (EditText) findViewById(R.id.china);
        show = (TextView) findViewById(R.id.show);
    }

    private final String TAG = "Time";
    private DateFormat americaTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    private DateFormat japanTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    private DateFormat EuropeTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");


    public void onClick(View v){
        Log.i(TAG, "onClick: ");
        String str = china.getText().toString();
        Log.i(TAG, "onClick: get str=" + str);

        float t = 0;
        if(str.length()>0){
            t = Float.parseFloat(str);
        }else {
            //用户没有输入内容
            Toast.makeText(this, "请输入内容", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.i(TAG, "onClick: t=" + t);
        long time = System.currentTimeMillis();

        if(v.getId()==R.id.ameri){
            Date date = new Date(time);
            TimeZone tz = TimeZone.getTimeZone("America/New_York");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            df.setTimeZone(tz);
            String nowAsIOS = df.format(date);
            show.setText(String.valueOf(nowAsIOS));
        }else if(v.getId()==R.id.jap){
            Date date = new Date(time);
            TimeZone tz = TimeZone.getTimeZone("Asia/Tokyo");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            df.setTimeZone(tz);
            String nowAsIOS = df.format(date);
            show.setText(String.valueOf(nowAsIOS));
        }else{
            Date date = new Date(time);
            TimeZone tz = TimeZone.getTimeZone("Europe/London");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            df.setTimeZone(tz);
            String nowAsIOS = df.format(date);
            show.setText(String.valueOf(nowAsIOS));
        }
        }}






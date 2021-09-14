package com.example.nowinning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.nowinning.BSOActivity.ascore;
import static com.example.nowinning.BSOActivity.ascore_1;
import static com.example.nowinning.BSOActivity.ascore_2;
import static com.example.nowinning.BSOActivity.ascore_3;
import static com.example.nowinning.BSOActivity.ascore_4;
import static com.example.nowinning.BSOActivity.ascore_5;
import static com.example.nowinning.BSOActivity.ascore_6;
import static com.example.nowinning.BSOActivity.ascore_7;
import static com.example.nowinning.BSOActivity.ascore_8;
import static com.example.nowinning.BSOActivity.ascore_9;
import static com.example.nowinning.BSOActivity.hscore_1;
import static com.example.nowinning.BSOActivity.hscore_2;
import static com.example.nowinning.BSOActivity.hscore_3;
import static com.example.nowinning.BSOActivity.hscore_4;
import static com.example.nowinning.BSOActivity.hscore_5;
import static com.example.nowinning.BSOActivity.hscore_6;
import static com.example.nowinning.BSOActivity.hscore_7;
import static com.example.nowinning.BSOActivity.hscore_8;
import static com.example.nowinning.BSOActivity.hscore_9;
import static com.example.nowinning.BSOActivity.iniCnt;
import static com.example.nowinning.BSOActivity.ini_num;


public class ReusltActivity extends AppCompatActivity {

    public static TextView home_ini1, home_ini2, home_ini3, home_ini4, home_ini5, home_ini6, home_ini7, home_ini8, home_ini9;
    public static TextView away_ini1, away_ini2, away_ini3, away_ini4, away_ini5, away_ini6, away_ini7, away_ini8, away_ini9;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        away_ini1 = (TextView) findViewById(R.id.away_ini_1);
        away_ini2 = (TextView) findViewById(R.id.away_ini_2);
        away_ini3 = (TextView) findViewById(R.id.away_ini_3);
        away_ini4 = (TextView) findViewById(R.id.away_ini_4);
        away_ini5 = (TextView) findViewById(R.id.away_ini_5);
        away_ini6 = (TextView) findViewById(R.id.away_ini_6);
        away_ini7 = (TextView) findViewById(R.id.away_ini_7);
        away_ini8 = (TextView) findViewById(R.id.away_ini_8);
        away_ini9 = (TextView) findViewById(R.id.away_ini_9);

        home_ini1 = (TextView) findViewById(R.id.home_ini_1);
        home_ini2 = (TextView) findViewById(R.id.home_ini_2);
        home_ini3 = (TextView) findViewById(R.id.home_ini_3);
        home_ini4 = (TextView) findViewById(R.id.home_ini_4);
        home_ini5 = (TextView) findViewById(R.id.home_ini_5);
        home_ini6 = (TextView) findViewById(R.id.home_ini_6);
        home_ini7 = (TextView) findViewById(R.id.home_ini_7);
        home_ini8 = (TextView) findViewById(R.id.home_ini_8);
        home_ini9 = (TextView) findViewById(R.id.home_ini_9);


        away_ini1.setText(String.valueOf(ascore_1));
        away_ini2.setText(String.valueOf(ascore_2));
        away_ini3.setText(String.valueOf(ascore_3));
        away_ini4.setText(String.valueOf(ascore_4));
        away_ini5.setText(String.valueOf(ascore_5));
        away_ini6.setText(String.valueOf(ascore_6));
        away_ini7.setText(String.valueOf(ascore_7));
        away_ini8.setText(String.valueOf(ascore_8));
        away_ini9.setText(String.valueOf(ascore_9));

        home_ini1.setText(String.valueOf(hscore_1));
        home_ini2.setText(String.valueOf(hscore_2));
        home_ini3.setText(String.valueOf(hscore_3));
        home_ini4.setText(String.valueOf(hscore_4));
        home_ini5.setText(String.valueOf(hscore_5));
        home_ini6.setText(String.valueOf(hscore_6));
        home_ini7.setText(String.valueOf(hscore_7));
        home_ini8.setText(String.valueOf(hscore_8));
        home_ini9.setText(String.valueOf(hscore_9));


    }
}
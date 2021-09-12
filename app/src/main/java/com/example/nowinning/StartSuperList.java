package com.example.nowinning;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.nowinning.LoginActivity.UserID;

public class StartSuperList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_superlinup);

        Button finish = (Button) findViewById(R.id.finish_button);
        Button home = (Button) findViewById(R.id.home_button);
        Button away = (Button) findViewById(R.id.away_button);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartSuperList.this, StarttSuperList_home.class);
                startActivity(intent); //계정 조건에 따라 분기점이 필요함(감독, 선수, 기록자)

            }
        });

        away.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartSuperList.this, StarttSuperList_away.class);
                startActivity(intent); //계정 조건에 따라 분기점이 필요함(감독, 선수, 기록자)

            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartSuperList.this, StartRecorder.class);
                startActivity(intent); //계정 조건에 따라 분기점이 필요함(감독, 선수, 기록자)
            }
        });
    }

}



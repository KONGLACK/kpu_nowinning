package com.example.nowinning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StartManager extends AppCompatActivity {
    Button lineup_button, record_button, community_button, vs_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        lineup_button = (Button) findViewById(R.id.lineup_button);
        record_button = (Button) findViewById(R.id.record_button);

        lineup_button.setOnClickListener(new View.OnClickListener() { // 라인업 등록
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(StartManager.this, StartList.class);
                startActivity(intent);

            }
        });

        record_button.setOnClickListener(new View.OnClickListener() { // 선수 기록
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(StartManager.this, BatRecord.class);
                startActivity(intent);

            }
        });



    }
}


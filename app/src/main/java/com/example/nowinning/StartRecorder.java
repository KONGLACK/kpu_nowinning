package com.example.nowinning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class StartRecorder extends AppCompatActivity {

    Button match_button, record_button, community_button, vs_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recorder);

        match_button = (Button) findViewById(R.id.match_button);
        record_button = (Button) findViewById(R.id.record_button);

        match_button.setOnClickListener(new View.OnClickListener() { // 경기기록
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(StartRecorder.this, start.class);
                startActivity(intent);

            }
        });

        record_button.setOnClickListener(new View.OnClickListener() { // 선수기록
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(StartRecorder.this, BatRecord.class);
                startActivity(intent);

            }
        });





        }
}
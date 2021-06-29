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
        community_button = (Button) findViewById(R.id.community_button);
        vs_button = (Button) findViewById(R.id.vs_button);

        match_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(StartRecorder.this, start.class);
                startActivity(intent);

            }
        });

        record_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(StartRecorder.this,"선수 기록을 확인할 수 있는 버튼입니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(StartRecorder.this, StartList.class);
                startActivity(intent);

            }
        });

        community_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(StartRecorder.this,"커뮤니티에 접근할 수 있는 버튼입니다.", Toast.LENGTH_SHORT).show();
                /*Intent intent = new Intent(StartRecorder.this, 여기에 클래스 입력.class);
                startActivity(intent);*/

            }
        });

        vs_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(StartRecorder.this,"선택한 선수의 역대 전적을 확인할 수 있는 버튼입니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(StartRecorder.this, StartVs.class);
                startActivity(intent);

            }
        });

        }
}
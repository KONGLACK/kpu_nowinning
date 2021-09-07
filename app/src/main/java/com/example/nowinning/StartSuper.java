package com.example.nowinning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StartSuper extends AppCompatActivity {
    Button lineup_button, record_button, community_button, vs_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super);

        lineup_button = (Button) findViewById(R.id.lineup_button);
        record_button = (Button) findViewById(R.id.record_button);
        community_button = (Button) findViewById(R.id.community_button);
        vs_button = (Button) findViewById(R.id.vs_button);

        lineup_button.setOnClickListener(new View.OnClickListener() { // 라인업 등록
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(StartSuper.this, StartSuperList.class);
                startActivity(intent);

            }
        });

        record_button.setOnClickListener(new View.OnClickListener() { // 선수 기록
            @Override
            public void onClick(View v) {

                Toast.makeText(StartSuper.this,"선수 기록을 확인할 수 있는 버튼입니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(StartSuper.this, StartRecorder.class);
                startActivity(intent);

            }
        });

        community_button.setOnClickListener(new View.OnClickListener() { // 커뮤니티
            @Override
            public void onClick(View v) {

                Toast.makeText(StartSuper.this,"커뮤니티에 접근할 수 있는 버튼입니다.", Toast.LENGTH_SHORT).show();
                /*Intent intent = new Intent(StartRecorder.this, 여기에 클래스 입력.class);
                startActivity(intent);*/

            }
        });

        vs_button.setOnClickListener(new View.OnClickListener() { // 상대 전적
            @Override
            public void onClick(View v) {

                //Toast.makeText(StartRecorder.this,"선택한 선수의 역대 전적을 확인할 수 있는 버튼입니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(StartSuper.this, StartVs.class);
                startActivity(intent);

            }
        });

    }
}


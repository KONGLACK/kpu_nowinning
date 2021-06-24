package com.example.nowinning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StartVs extends AppCompatActivity {

    Button vsSend_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vs);

        vsSend_button = (Button) findViewById(R.id.vsSend_button);


        vsSend_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(StartVs.this, "선택한 선수 정보를 요청하는 버튼입니다.", Toast.LENGTH_SHORT).show();
                /*Intent intent = new Intent(StartRecorder.this, 여기에 클래스 입력.class);
                startActivity(intent);*/

            }
        });

    }
}
package com.example.nowinning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GameSet extends AppCompatActivity {

    Button testbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameset);

        Button testbtn = (Button) findViewById(R.id.testbtn);

        testbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameSet.this, BSOActivity.class);
                startActivity(intent);
            }
        });
    }
}

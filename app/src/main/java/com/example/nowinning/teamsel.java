package com.example.nowinning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class teamsel extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teamsel);

        Button hanhwa_btn = findViewById(R.id.hanhwa_button);
        Button nexen_btn = findViewById(R.id.nexen_button);

        hanhwa_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), hanhwaplayersel.class);
                startActivity(intent);

                finish();
            }
        });
        nexen_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), nexenplayersel.class);
                startActivity(intent);

                finish();
            }
        });
    }
}


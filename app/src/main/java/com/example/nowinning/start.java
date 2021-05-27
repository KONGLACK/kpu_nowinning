package com.example.nowinning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.nowinning.BSOActivity.et_ascore;
import static com.example.nowinning.BSOActivity.et_hscore;

public class start extends AppCompatActivity {

    Button st_btn;
    public static String choice_home="";
    public static String choice_away="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ArrayAdapter<CharSequence> adhome, adaway;

        final Spinner hometeam = (Spinner)findViewById(R.id.hometeam);
        final Spinner awayteam = (Spinner)findViewById(R.id.awayteam);

        adhome = ArrayAdapter.createFromResource(this, R.array.team, android.R.layout.simple_spinner_dropdown_item);
        adaway = ArrayAdapter.createFromResource(this, R.array.team, android.R.layout.simple_spinner_dropdown_item);

        hometeam.setAdapter(adhome);
        awayteam.setAdapter(adaway);

        hometeam.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(adhome.getItem(i).equals("한화")) {
                    choice_home="한화";
                }
                if(adhome.getItem(i).equals("넥센")) {
                    choice_home="넥센";

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        awayteam.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(adaway.getItem(i).equals("한화")) {
                    choice_away="한화";
                }
                if(adaway.getItem(i).equals("넥센")) {
                    choice_away="넥센";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        st_btn = findViewById(R.id.st_button);

        st_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(start.this, BSOActivity.class);
                startActivity(intent);
                finish();





            }
        });
    }
}

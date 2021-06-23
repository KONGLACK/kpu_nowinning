package com.example.nowinning;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class nexenplayersel extends AppCompatActivity {

    ArrayAdapter<CharSequence> adspin1, adspin2, adspin3, adspin4, adspin5, adspin6, adspin7, adspin8, adspin9;
    public static String nexen_one="";
    public static String nexen_two="";
    public static String nexen_three="";
    public static String nexen_four="";
    public static String nexen_five="";
    public static String nexen_six="";
    public static String nexen_seven="";
    public static String nexen_eight="";
    public static String nexen_nine="";

    Button sel_btn;
    Button sel_btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playersel);
        Spinner n_spin1 = (Spinner)findViewById(R.id.playersel_1);
        Spinner n_spin2 = (Spinner)findViewById(R.id.playersel_2);
        Spinner n_spin3 = (Spinner)findViewById(R.id.playersel_3);
        Spinner n_spin4 = (Spinner)findViewById(R.id.playersel_4);
        Spinner n_spin5 = (Spinner)findViewById(R.id.playersel_5);
        Spinner n_spin6 = (Spinner)findViewById(R.id.playersel_6);
        Spinner n_spin7 = (Spinner)findViewById(R.id.playersel_7);
        Spinner n_spin8 = (Spinner)findViewById(R.id.playersel_8);
        Spinner n_spin9 = (Spinner)findViewById(R.id.playersel_9);


        adspin1 = ArrayAdapter.createFromResource(this, R.array.nexen_player, android.R.layout.simple_spinner_dropdown_item);
        adspin1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        n_spin1.setAdapter(adspin1);
        n_spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                nexen_one = n_spin1.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        adspin2 = ArrayAdapter.createFromResource(this, R.array.nexen_player, android.R.layout.simple_spinner_dropdown_item);
        adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        n_spin2.setAdapter(adspin2);
        n_spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                nexen_two = n_spin2.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        adspin3 = ArrayAdapter.createFromResource(this, R.array.nexen_player, android.R.layout.simple_spinner_dropdown_item);
        adspin3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        n_spin3.setAdapter(adspin3);
        n_spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                nexen_three = n_spin3.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        adspin4 = ArrayAdapter.createFromResource(this, R.array.nexen_player, android.R.layout.simple_spinner_dropdown_item);
        adspin4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        n_spin4.setAdapter(adspin4);
        n_spin4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                nexen_four = n_spin4.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        adspin5 = ArrayAdapter.createFromResource(this, R.array.nexen_player, android.R.layout.simple_spinner_dropdown_item);
        adspin5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        n_spin5.setAdapter(adspin5);
        n_spin5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                nexen_five = n_spin5.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        adspin6 = ArrayAdapter.createFromResource(this, R.array.nexen_player, android.R.layout.simple_spinner_dropdown_item);
        adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        n_spin6.setAdapter(adspin6);
        n_spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                nexen_six = n_spin6.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        adspin7 = ArrayAdapter.createFromResource(this, R.array.nexen_player, android.R.layout.simple_spinner_dropdown_item);
        adspin7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        n_spin7.setAdapter(adspin7);
        n_spin7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                nexen_seven = n_spin7.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        adspin8 = ArrayAdapter.createFromResource(this, R.array.nexen_player, android.R.layout.simple_spinner_dropdown_item);
        adspin8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        n_spin8.setAdapter(adspin8);
        n_spin8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                nexen_eight = n_spin8.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        adspin9 = ArrayAdapter.createFromResource(this, R.array.nexen_player, android.R.layout.simple_spinner_dropdown_item);
        adspin9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        n_spin9.setAdapter(adspin9);
        n_spin9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                nexen_nine = n_spin9.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sel_btn = findViewById(R.id.sel_button);
        sel_btn2 = findViewById(R.id.sel_button2);
        sel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),start.class);
                startActivity(intent);

                finish();
            }
        });
        sel_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),teamsel.class);
                startActivity(intent);

                finish();
            }
        });
    }
}

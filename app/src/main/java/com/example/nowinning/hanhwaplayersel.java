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

public class hanhwaplayersel extends AppCompatActivity {

    ArrayAdapter<CharSequence> adspin1, adspin2, adspin3, adspin4;
    public static String hanhwa_one="";
    public static String hanhwa_two="";
    public static String hanhwa_three="";
    public static String hanhwa_four="";


    Button sel_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playersel);
        Spinner h_spin1 = (Spinner)findViewById(R.id.playersel_1);
        Spinner h_spin2 = (Spinner)findViewById(R.id.playersel_2);
        Spinner h_spin3 = (Spinner)findViewById(R.id.playersel_3);
        Spinner h_spin4 = (Spinner)findViewById(R.id.playersel_4);



        adspin1 = ArrayAdapter.createFromResource(this, R.array.hanhwa_player, android.R.layout.simple_spinner_dropdown_item);
        adspin1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        h_spin1.setAdapter(adspin1);
        h_spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                hanhwa_one = h_spin1.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        adspin2 = ArrayAdapter.createFromResource(this, R.array.hanhwa_player, android.R.layout.simple_spinner_dropdown_item);
        adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        h_spin2.setAdapter(adspin2);
        h_spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                hanhwa_two = h_spin2.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        adspin3 = ArrayAdapter.createFromResource(this, R.array.hanhwa_player, android.R.layout.simple_spinner_dropdown_item);
        adspin3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        h_spin3.setAdapter(adspin3);
        h_spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                hanhwa_three = h_spin3.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        adspin4 = ArrayAdapter.createFromResource(hanhwaplayersel.this, R.array.hanhwa_player, android.R.layout.simple_spinner_dropdown_item);
        adspin4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        h_spin4.setAdapter(adspin4);
        h_spin4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                hanhwa_four = h_spin4.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sel_btn = findViewById(R.id.sel_button);

        sel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),start.class);
                startActivity(intent);

                finish();
            }
        });
    }
}

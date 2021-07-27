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

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.nowinning.BSOActivity.et_ascore;
import static com.example.nowinning.BSOActivity.et_hscore;
import static com.example.nowinning.BSOActivity.home_ball;
import static com.example.nowinning.BSOActivity.home_outout;
import static com.example.nowinning.BSOActivity.home_strike;
import static com.example.nowinning.BSOActivity.away_ball;
import static com.example.nowinning.BSOActivity.away_strike;
import static com.example.nowinning.BSOActivity.away_outout;
import static com.example.nowinning.StartList.hanhwa_eight;
import static com.example.nowinning.StartList.hanhwa_five;
import static com.example.nowinning.StartList.hanhwa_nine;
import static com.example.nowinning.StartList.hanhwa_seven;
import static com.example.nowinning.StartList.hanhwa_six;
import static com.example.nowinning.StartList.nexen_eight;
import static com.example.nowinning.StartList.nexen_five;
import static com.example.nowinning.StartList.nexen_nine;
import static com.example.nowinning.StartList.nexen_one;
import static com.example.nowinning.StartList.nexen_seven;
import static com.example.nowinning.StartList.nexen_six;
import static com.example.nowinning.StartList.nexen_two;
import static com.example.nowinning.StartList.nexen_three;
import static com.example.nowinning.StartList.nexen_four;
import static com.example.nowinning.StartList.hanhwa_one;
import static com.example.nowinning.StartList.hanhwa_two;
import static com.example.nowinning.StartList.hanhwa_three;
import static com.example.nowinning.StartList.hanhwa_four;
import static com.example.nowinning.BSOActivity.a;
import static com.example.nowinning.BSOActivity.h;


public class start extends AppCompatActivity {

    Button st_btn;
    public static String choice_home="";
    public static String choice_away="";
    public static String away_player1="";
    public static String away_player2="";
    public static String away_player3="";
    public static String away_player4="";
    public static String away_player5="";
    public static String away_player6="";
    public static String away_player7="";
    public static String away_player8="";
    public static String away_player9="";

    public static String home_player1="";
    public static String home_player2="";
    public static String home_player3="";
    public static String home_player4="";
    public static String home_player5="";
    public static String home_player6="";
    public static String home_player7="";
    public static String home_player8="";
    public static String home_player9="";

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
                choice_home = hometeam.getSelectedItem().toString();
                if(choice_home.equals("한화")) {
                    home_player1 = hanhwa_one;
                    home_player2 = hanhwa_two;
                    home_player3 = hanhwa_three;
                    home_player4 = hanhwa_four;
                    home_player5 = hanhwa_five;
                    home_player6 = hanhwa_six;
                    home_player7 = hanhwa_seven;
                    home_player8 = hanhwa_eight;
                    home_player9 = hanhwa_nine;


                }
                if(choice_home.equals("넥센")) {
                    home_player1 = nexen_one;
                    home_player2 = nexen_two;
                    home_player3 = nexen_three;
                    home_player4 = nexen_four;
                    home_player5 = nexen_five;
                    home_player6 = nexen_six;
                    home_player7 = nexen_seven;
                    home_player8 = nexen_eight;
                    home_player9 = nexen_nine;


                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        awayteam.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                choice_away = awayteam.getSelectedItem().toString();
                if(choice_away.equals("한화")) {
                    away_player1 = hanhwa_one;
                    away_player2 = hanhwa_two;
                    away_player3 = hanhwa_three;
                    away_player4 = hanhwa_four;
                    away_player5 = hanhwa_five;
                    away_player6 = hanhwa_six;
                    away_player7 = hanhwa_seven;
                    away_player8 = hanhwa_eight;
                    away_player9 = hanhwa_nine;

                }
                else if(choice_away.equals("넥센")) {
                    away_player1 = nexen_one;
                    away_player2 = nexen_two;
                    away_player3 = nexen_three;
                    away_player4 = nexen_four;
                    away_player5 = nexen_five;
                    away_player6 = nexen_six;
                    away_player7 = nexen_seven;
                    away_player8 = nexen_eight;
                    away_player9 = nexen_nine;


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


                away_ball = 0;
                away_outout = 0;
                away_strike = 0;
                home_ball = 0;
                home_strike = 0;
                home_outout =0;

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };
                TeamRequest teamRequest1 = new TeamRequest(choice_home, home_ball, home_strike, home_outout, responseListener);
                TeamRequest teamRequest2 = new TeamRequest(choice_away, away_ball, away_strike, away_outout, responseListener);

                RequestQueue queue = Volley.newRequestQueue(start.this);
                queue.add(teamRequest1);
                queue.add(teamRequest2);

                Intent intent = new Intent(start.this, BSOActivity.class);
                startActivity(intent);
                finish();



            }
        });
    }
}

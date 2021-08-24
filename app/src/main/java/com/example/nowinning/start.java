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
import static com.example.nowinning.StartList.dusan_eight;
import static com.example.nowinning.StartList.dusan_five;
import static com.example.nowinning.StartList.dusan_four;
import static com.example.nowinning.StartList.dusan_nine;
import static com.example.nowinning.StartList.dusan_one;
import static com.example.nowinning.StartList.dusan_seven;
import static com.example.nowinning.StartList.dusan_six;
import static com.example.nowinning.StartList.dusan_three;
import static com.example.nowinning.StartList.dusan_two;
import static com.example.nowinning.StartList.hanhwa_eight;
import static com.example.nowinning.StartList.hanhwa_five;
import static com.example.nowinning.StartList.hanhwa_nine;
import static com.example.nowinning.StartList.hanhwa_seven;
import static com.example.nowinning.StartList.hanhwa_six;
import static com.example.nowinning.StartList.kia_eight;
import static com.example.nowinning.StartList.kia_five;
import static com.example.nowinning.StartList.kia_four;
import static com.example.nowinning.StartList.kia_nine;
import static com.example.nowinning.StartList.kia_one;
import static com.example.nowinning.StartList.kia_seven;
import static com.example.nowinning.StartList.kia_six;
import static com.example.nowinning.StartList.kia_three;
import static com.example.nowinning.StartList.kia_two;
import static com.example.nowinning.StartList.kt_eight;
import static com.example.nowinning.StartList.kt_five;
import static com.example.nowinning.StartList.kt_four;
import static com.example.nowinning.StartList.kt_nine;
import static com.example.nowinning.StartList.kt_one;
import static com.example.nowinning.StartList.kt_seven;
import static com.example.nowinning.StartList.kt_six;
import static com.example.nowinning.StartList.kt_three;
import static com.example.nowinning.StartList.kt_two;
import static com.example.nowinning.StartList.lg_eight;
import static com.example.nowinning.StartList.lg_five;
import static com.example.nowinning.StartList.lg_four;
import static com.example.nowinning.StartList.lg_nine;
import static com.example.nowinning.StartList.lg_one;
import static com.example.nowinning.StartList.lg_seven;
import static com.example.nowinning.StartList.lg_six;
import static com.example.nowinning.StartList.lg_three;
import static com.example.nowinning.StartList.lg_two;
import static com.example.nowinning.StartList.lotte_eight;
import static com.example.nowinning.StartList.lotte_five;
import static com.example.nowinning.StartList.lotte_four;
import static com.example.nowinning.StartList.lotte_nine;
import static com.example.nowinning.StartList.lotte_one;
import static com.example.nowinning.StartList.lotte_seven;
import static com.example.nowinning.StartList.lotte_six;
import static com.example.nowinning.StartList.lotte_three;
import static com.example.nowinning.StartList.lotte_two;
import static com.example.nowinning.StartList.nc_eight;
import static com.example.nowinning.StartList.nc_five;
import static com.example.nowinning.StartList.nc_four;
import static com.example.nowinning.StartList.nc_nine;
import static com.example.nowinning.StartList.nc_one;
import static com.example.nowinning.StartList.nc_seven;
import static com.example.nowinning.StartList.nc_six;
import static com.example.nowinning.StartList.nc_three;
import static com.example.nowinning.StartList.nc_two;
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
import static com.example.nowinning.StartList.samsung_eight;
import static com.example.nowinning.StartList.samsung_five;
import static com.example.nowinning.StartList.samsung_four;
import static com.example.nowinning.StartList.samsung_nine;
import static com.example.nowinning.StartList.samsung_one;
import static com.example.nowinning.StartList.samsung_seven;
import static com.example.nowinning.StartList.samsung_six;
import static com.example.nowinning.StartList.samsung_three;
import static com.example.nowinning.StartList.samsung_two;
import static com.example.nowinning.StartList.ssg_eight;
import static com.example.nowinning.StartList.ssg_five;
import static com.example.nowinning.StartList.ssg_four;
import static com.example.nowinning.StartList.ssg_nine;
import static com.example.nowinning.StartList.ssg_one;
import static com.example.nowinning.StartList.ssg_seven;
import static com.example.nowinning.StartList.ssg_six;
import static com.example.nowinning.StartList.ssg_three;
import static com.example.nowinning.StartList.ssg_two;


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
                if(choice_home.equals("KT")) {
                    home_player1 = kt_one;
                    home_player2 = kt_two;
                    home_player3 = kt_three;
                    home_player4 = kt_four;
                    home_player5 = kt_five;
                    home_player6 = kt_six;
                    home_player7 = kt_seven;
                    home_player8 = kt_eight;
                    home_player9 = kt_nine;
                }
                if(choice_home.equals("삼성")) {
                    home_player1 = samsung_one;
                    home_player2 = samsung_two;
                    home_player3 = samsung_three;
                    home_player4 = samsung_four;
                    home_player5 = samsung_five;
                    home_player6 = samsung_six;
                    home_player7 = samsung_seven;
                    home_player8 = samsung_eight;
                    home_player9 = samsung_nine;
                }
                if(choice_home.equals("LG")) {
                    home_player1 = lg_one;
                    home_player2 = lg_two;
                    home_player3 = lg_three;
                    home_player4 = lg_four;
                    home_player5 = lg_five;
                    home_player6 = lg_six;
                    home_player7 = lg_seven;
                    home_player8 = lg_eight;
                    home_player9 = lg_nine;
                }
                if(choice_home.equals("NC")) {
                    home_player1 = nc_one;
                    home_player2 = nc_two;
                    home_player3 = nc_three;
                    home_player4 = nc_four;
                    home_player5 = nc_five;
                    home_player6 = nc_six;
                    home_player7 = nc_seven;
                    home_player8 = nc_eight;
                    home_player9 = nc_nine;
                }
                if(choice_home.equals("두산")) {
                    home_player1 = dusan_one;
                    home_player2 = dusan_two;
                    home_player3 = dusan_three;
                    home_player4 = dusan_four;
                    home_player5 = dusan_five;
                    home_player6 = dusan_six;
                    home_player7 = dusan_seven;
                    home_player8 = dusan_eight;
                    home_player9 = dusan_nine;
                }
                if(choice_home.equals("SSG")) {
                    home_player1 = ssg_one;
                    home_player2 = ssg_two;
                    home_player3 = ssg_three;
                    home_player4 = ssg_four;
                    home_player5 = ssg_five;
                    home_player6 = ssg_six;
                    home_player7 = ssg_seven;
                    home_player8 = ssg_eight;
                    home_player9 = ssg_nine;
                }
                if(choice_home.equals("롯데")) {
                    home_player1 = lotte_one;
                    home_player2 = lotte_two;
                    home_player3 = lotte_three;
                    home_player4 = lotte_four;
                    home_player5 = lotte_five;
                    home_player6 = lotte_six;
                    home_player7 = lotte_seven;
                    home_player8 = lotte_eight;
                    home_player9 = lotte_nine;
                }
                if(choice_home.equals("KIA")) {
                    home_player1 = kia_one;
                    home_player2 = kia_two;
                    home_player3 = kia_three;
                    home_player4 = kia_four;
                    home_player5 = kia_five;
                    home_player6 = kia_six;
                    home_player7 = kia_seven;
                    home_player8 = kia_eight;
                    home_player9 = kia_nine;
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

                if(choice_away.equals("넥센")) {
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
                if(choice_away.equals("KT")) {
                    away_player1 = kt_one;
                    away_player2 = kt_two;
                    away_player3 = kt_three;
                    away_player4 = kt_four;
                    away_player5 = kt_five;
                    away_player6 = kt_six;
                    away_player7 = kt_seven;
                    away_player8 = kt_eight;
                    away_player9 = kt_nine;
                }
                if(choice_away.equals("삼성")) {
                    away_player1 = samsung_one;
                    away_player2 = samsung_two;
                    away_player3 = samsung_three;
                    away_player4 = samsung_four;
                    away_player5 = samsung_five;
                    away_player6 = samsung_six;
                    away_player7 = samsung_seven;
                    away_player8 = samsung_eight;
                    away_player9 = samsung_nine;
                }
                if(choice_away.equals("LG")) {
                    away_player1 = lg_one;
                    away_player2 = lg_two;
                    away_player3 = lg_three;
                    away_player4 = lg_four;
                    away_player5 = lg_five;
                    away_player6 = lg_six;
                    away_player7 = lg_seven;
                    away_player8 = lg_eight;
                    away_player9 = lg_nine;
                }
                if(choice_away.equals("NC")) {
                    away_player1 = nc_one;
                    away_player2 = nc_two;
                    away_player3 = nc_three;
                    away_player4 = nc_four;
                    away_player5 = nc_five;
                    away_player6 = nc_six;
                    away_player7 = nc_seven;
                    away_player8 = nc_eight;
                    away_player9 = nc_nine;
                }
                if(choice_away.equals("두산")) {
                    away_player1 = dusan_one;
                    away_player2 = dusan_two;
                    away_player3 = dusan_three;
                    away_player4 = dusan_four;
                    away_player5 = dusan_five;
                    away_player6 = dusan_six;
                    away_player7 = dusan_seven;
                    away_player8 = dusan_eight;
                    away_player9 = dusan_nine;
                }
                if(choice_away.equals("SSG")) {
                    away_player1 = ssg_one;
                    away_player2 = ssg_two;
                    away_player3 = ssg_three;
                    away_player4 = ssg_four;
                    away_player5 = ssg_five;
                    away_player6 = ssg_six;
                    away_player7 = ssg_seven;
                    away_player8 = ssg_eight;
                    away_player9 = ssg_nine;
                }
                if(choice_away.equals("롯데")) {
                    away_player1 = lotte_one;
                    away_player2 = lotte_two;
                    away_player3 = lotte_three;
                    away_player4 = lotte_four;
                    away_player5 = lotte_five;
                    away_player6 = lotte_six;
                    away_player7 = lotte_seven;
                    away_player8 = lotte_eight;
                    away_player9 = lotte_nine;
                }
                if(choice_away.equals("KIA")) {
                    away_player1 = kia_one;
                    away_player2 = kia_two;
                    away_player3 = kia_three;
                    away_player4 = kia_four;
                    away_player5 = kia_five;
                    away_player6 = kia_six;
                    away_player7 = kia_seven;
                    away_player8 = kia_eight;
                    away_player9 = kia_nine;
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
                //

                CreateTable_Request CreateTable_Request = new CreateTable_Request(choice_away, choice_home, away_player1, away_player2, away_player3,
                        away_player4, away_player5, away_player6, away_player7, away_player8, away_player9, home_player1,
                        home_player2, home_player3, home_player4, home_player5, home_player6, home_player7, home_player8, home_player9,
                        responseListener);
                RequestQueue queue5 = Volley.newRequestQueue(start.this);
                queue5.add(CreateTable_Request);

                away_ball = 0;
                away_outout = 0;
                away_strike = 0;
                home_ball = 0;
                home_strike = 0;
                home_outout =0;


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

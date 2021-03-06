package com.example.nowinning;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
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
    public static String away_pitcher="";
    public static String away_catcher="";
    public static String away_firstbase="";
    public static String away_secondbase="";
    public static String away_thirdbase="";
    public static String away_shortstop="";
    public static String away_leftfielder="";
    public static String away_centerfielder="";
    public static String away_rightfielder="";



    public static String home_player1="";
    public static String home_player2="";
    public static String home_player3="";
    public static String home_player4="";
    public static String home_player5="";
    public static String home_player6="";
    public static String home_player7="";
    public static String home_player8="";
    public static String home_player9="";
    public static String home_pitcher="";
    public static String home_catcher="";
    public static String home_firstbase="";
    public static String home_secondbase="";
    public static String home_thirdbase="";
    public static String home_shortstop="";
    public static String home_leftfielder="";
    public static String home_centerfielder="";
    public static String home_rightfielder="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ArrayAdapter<CharSequence> adhome, adaway;



        SharedPreferences sharedPreferences = getSharedPreferences("save", MODE_PRIVATE);




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
                if(choice_home.equals("??????")) {
                    home_player1 = sharedPreferences.getString("hanhwa_one", "??????");
                    home_player2 = sharedPreferences.getString("hanhwa_two", "??????");
                    home_player3 = sharedPreferences.getString("hanhwa_three", "??????");
                    home_player4 = sharedPreferences.getString("hanhwa_four", "??????");
                    home_player5 = sharedPreferences.getString("hanhwa_five", "??????");
                    home_player6 = sharedPreferences.getString("hanhwa_six", "??????");
                    home_player7 = sharedPreferences.getString("hanhwa_seven", "??????");
                    home_player8 = sharedPreferences.getString("hanhwa_eight", "??????");
                    home_player9 = sharedPreferences.getString("hanhwa_nine", "??????");
                    home_pitcher = sharedPreferences.getString("hanhwa_one_pit", "??????");
                    home_catcher = sharedPreferences.getString("hanhwa_catcher", "??????");
                    home_firstbase = sharedPreferences.getString("hanhwa_firstbase", "??????");
                    home_secondbase = sharedPreferences.getString("hanhwa_secondbase", "??????");
                    home_thirdbase = sharedPreferences.getString("hanhwa_thirdbase", "??????");
                    home_shortstop = sharedPreferences.getString("hanhwa_shortstop", "??????");
                    home_leftfielder = sharedPreferences.getString("hanhwa_leftfielder", "??????");
                    home_centerfielder = sharedPreferences.getString("hanhwa_centerfielder", "??????");
                    home_rightfielder = sharedPreferences.getString("hanhwa_rightfielder", "??????");
                }

                if(choice_home.equals("??????")) {
                    home_player1 = sharedPreferences.getString("nexen_one", "??????");
                    home_player2 = sharedPreferences.getString("nexen_two", "??????");
                    home_player3 = sharedPreferences.getString("nexen_three", "??????");
                    home_player4 = sharedPreferences.getString("nexen_four", "??????");
                    home_player5 = sharedPreferences.getString("nexen_five", "??????");
                    home_player6 = sharedPreferences.getString("nexen_six", "??????");
                    home_player7 = sharedPreferences.getString("nexen_seven", "??????");
                    home_player8 = sharedPreferences.getString("nexen_eight", "??????");
                    home_player9 = sharedPreferences.getString("nexen_nine", "??????");
                    home_pitcher = sharedPreferences.getString("nexen_one_pit", "??????");
                    home_catcher = sharedPreferences.getString("nexen_catcher", "??????");
                    home_firstbase = sharedPreferences.getString("nexen_firstbase", "??????");
                    home_secondbase = sharedPreferences.getString("nexen_secondbase", "??????");
                    home_thirdbase = sharedPreferences.getString("nexen_thirdbase", "??????");
                    home_shortstop = sharedPreferences.getString("nexen_shortstop", "??????");
                    home_leftfielder = sharedPreferences.getString("nexen_leftfielder", "??????");
                    home_centerfielder = sharedPreferences.getString("nexen_centerfielder", "??????");
                    home_rightfielder = sharedPreferences.getString("nexen_rightfielder", "??????");

                }
                if(choice_home.equals("KT")) {
                    home_player1 = sharedPreferences.getString("kt_one", "??????");
                    home_player2 = sharedPreferences.getString("kt_two", "??????");
                    home_player3 = sharedPreferences.getString("kt_three", "??????");
                    home_player4 = sharedPreferences.getString("kt_four", "??????");
                    home_player5 = sharedPreferences.getString("kt_five", "??????");
                    home_player6 = sharedPreferences.getString("kt_six", "??????");
                    home_player7 = sharedPreferences.getString("kt_seven", "??????");
                    home_player8 = sharedPreferences.getString("kt_eight", "??????");
                    home_player9 = sharedPreferences.getString("kt_nine", "??????");
                    home_pitcher = sharedPreferences.getString("kt_one_pit", "??????");
                    home_catcher = sharedPreferences.getString("kt_catcher", "??????");
                    home_firstbase = sharedPreferences.getString("kt_firstbase", "??????");
                    home_secondbase = sharedPreferences.getString("kt_secondbase", "??????");
                    home_thirdbase = sharedPreferences.getString("kt_thirdbase", "??????");
                    home_shortstop = sharedPreferences.getString("kt_shortstop", "??????");
                    home_leftfielder = sharedPreferences.getString("kt_leftfielder", "??????");
                    home_centerfielder = sharedPreferences.getString("kt_centerfielder", "??????");
                    home_rightfielder = sharedPreferences.getString("kt_rightfielder", "??????");

                }
                if(choice_home.equals("??????")) {
                    home_player1 = sharedPreferences.getString("samsung_one", "??????");
                    home_player2 = sharedPreferences.getString("samsung_two", "??????");
                    home_player3 = sharedPreferences.getString("samsung_three", "??????");
                    home_player4 = sharedPreferences.getString("samsung_four", "??????");
                    home_player5 = sharedPreferences.getString("samsung_five", "??????");
                    home_player6 = sharedPreferences.getString("samsung_six", "??????");
                    home_player7 = sharedPreferences.getString("samsung_seven", "??????");
                    home_player8 = sharedPreferences.getString("samsung_eight", "??????");
                    home_player9 = sharedPreferences.getString("samsung_nine", "??????");
                    home_pitcher = sharedPreferences.getString("samsung_one_pit", "??????");
                    home_catcher = sharedPreferences.getString("samsung_catcher", "??????");
                    home_firstbase = sharedPreferences.getString("samsung_firstbase", "??????");
                    home_secondbase = sharedPreferences.getString("samsung_secondbase", "??????");
                    home_thirdbase = sharedPreferences.getString("samsung_thirdbase", "??????");
                    home_shortstop = sharedPreferences.getString("samsung_shortstop", "??????");
                    home_leftfielder = sharedPreferences.getString("samsung_leftfielder", "??????");
                    home_centerfielder = sharedPreferences.getString("samsung_centerfielder", "??????");
                    home_rightfielder = sharedPreferences.getString("samsung_rightfielder", "??????");

                }
                if(choice_home.equals("LG")) {
                    home_player1 = sharedPreferences.getString("lg_one", "??????");
                    home_player2 = sharedPreferences.getString("lg_two", "??????");
                    home_player3 = sharedPreferences.getString("lg_three", "??????");
                    home_player4 = sharedPreferences.getString("lg_four", "??????");
                    home_player5 = sharedPreferences.getString("lg_five", "??????");
                    home_player6 = sharedPreferences.getString("lg_six", "??????");
                    home_player7 = sharedPreferences.getString("lg_seven", "??????");
                    home_player8 = sharedPreferences.getString("lg_eight", "??????");
                    home_player9 = sharedPreferences.getString("lg_nine", "??????");
                    home_pitcher = sharedPreferences.getString("lg_one_pit", "??????");
                    home_catcher = sharedPreferences.getString("lg_catcher", "??????");
                    home_firstbase = sharedPreferences.getString("lg_firstbase", "??????");
                    home_secondbase = sharedPreferences.getString("lg_secondbase", "??????");
                    home_thirdbase = sharedPreferences.getString("lg_thirdbase", "??????");
                    home_shortstop = sharedPreferences.getString("lg_shortstop", "??????");
                    home_leftfielder = sharedPreferences.getString("lg_leftfielder", "??????");
                    home_centerfielder = sharedPreferences.getString("lg_centerfielder", "??????");
                    home_rightfielder = sharedPreferences.getString("lg_rightfielder", "??????");
                }
                if(choice_home.equals("NC")) {
                    home_player1 = sharedPreferences.getString("nc_one", "??????");
                    home_player2 = sharedPreferences.getString("nc_two", "??????");
                    home_player3 = sharedPreferences.getString("nc_three", "??????");
                    home_player4 = sharedPreferences.getString("nc_four", "??????");
                    home_player5 = sharedPreferences.getString("nc_five", "??????");
                    home_player6 = sharedPreferences.getString("nc_six", "??????");
                    home_player7 = sharedPreferences.getString("nc_seven", "??????");
                    home_player8 = sharedPreferences.getString("nc_eight", "??????");
                    home_player9 = sharedPreferences.getString("nc_nine", "??????");
                    home_pitcher = sharedPreferences.getString("nc_one_pit", "??????");
                    home_catcher = sharedPreferences.getString("nc_catcher", "??????");
                    home_firstbase = sharedPreferences.getString("nc_firstbase", "??????");
                    home_secondbase = sharedPreferences.getString("nc_secondbase", "??????");
                    home_thirdbase = sharedPreferences.getString("nc_thirdbase", "??????");
                    home_shortstop = sharedPreferences.getString("nc_shortstop", "??????");
                    home_leftfielder = sharedPreferences.getString("nc_leftfielder", "??????");
                    home_centerfielder = sharedPreferences.getString("nc_centerfielder", "??????");
                    home_rightfielder = sharedPreferences.getString("nc_rightfielder", "??????");
                }
                if(choice_home.equals("??????")) {
                    home_player1 = sharedPreferences.getString("dusan_one", "??????");
                    home_player2 = sharedPreferences.getString("dusan_two", "??????");
                    home_player3 = sharedPreferences.getString("dusan_three", "??????");
                    home_player4 = sharedPreferences.getString("dusan_four", "??????");
                    home_player5 = sharedPreferences.getString("dusan_five", "??????");
                    home_player6 = sharedPreferences.getString("dusan_six", "??????");
                    home_player7 = sharedPreferences.getString("dusan_seven", "??????");
                    home_player8 = sharedPreferences.getString("dusan_eight", "??????");
                    home_player9 = sharedPreferences.getString("dusan_nine", "??????");
                    home_pitcher = sharedPreferences.getString("dusan_one_pit", "??????");
                    home_catcher = sharedPreferences.getString("dusan_catcher", "??????");
                    home_firstbase = sharedPreferences.getString("dusan_firstbase", "??????");
                    home_secondbase = sharedPreferences.getString("dusan_secondbase", "??????");
                    home_thirdbase = sharedPreferences.getString("dusan_thirdbase", "??????");
                    home_shortstop = sharedPreferences.getString("dusan_shortstop", "??????");
                    home_leftfielder = sharedPreferences.getString("dusan_leftfielder", "??????");
                    home_centerfielder = sharedPreferences.getString("dusan_centerfielder", "??????");
                    home_rightfielder = sharedPreferences.getString("dusan_rightfielder", "??????");
                }
                if(choice_home.equals("SSG")) {
                    home_player1 = sharedPreferences.getString("ssg_one", "??????");
                    home_player2 = sharedPreferences.getString("ssg_two", "??????");
                    home_player3 = sharedPreferences.getString("ssg_three", "??????");
                    home_player4 = sharedPreferences.getString("ssg_four", "??????");
                    home_player5 = sharedPreferences.getString("ssg_five", "??????");
                    home_player6 = sharedPreferences.getString("ssg_six", "??????");
                    home_player7 = sharedPreferences.getString("ssg_seven", "??????");
                    home_player8 = sharedPreferences.getString("ssg_eight", "??????");
                    home_player9 = sharedPreferences.getString("ssg_nine", "??????");
                    home_pitcher = sharedPreferences.getString("ssg_one_pit", "??????");
                    home_catcher = sharedPreferences.getString("ssg_catcher", "??????");
                    home_firstbase = sharedPreferences.getString("ssg_firstbase", "??????");
                    home_secondbase = sharedPreferences.getString("ssg_secondbase", "??????");
                    home_thirdbase = sharedPreferences.getString("ssg_thirdbase", "??????");
                    home_shortstop = sharedPreferences.getString("ssg_shortstop", "??????");
                    home_leftfielder = sharedPreferences.getString("ssg_leftfielder", "??????");
                    home_centerfielder = sharedPreferences.getString("ssg_centerfielder", "??????");
                    home_rightfielder = sharedPreferences.getString("ssg_rightfielder", "??????");
                }
                if(choice_home.equals("??????")) {
                    home_player1 = sharedPreferences.getString("lotte_one", "??????");
                    home_player2 = sharedPreferences.getString("lotte_two", "??????");
                    home_player3 = sharedPreferences.getString("lotte_three", "??????");
                    home_player4 = sharedPreferences.getString("lotte_four", "??????");
                    home_player5 = sharedPreferences.getString("lotte_five", "??????");
                    home_player6 = sharedPreferences.getString("lotte_six", "??????");
                    home_player7 = sharedPreferences.getString("lotte_seven", "??????");
                    home_player8 = sharedPreferences.getString("lotte_eight", "??????");
                    home_player9 = sharedPreferences.getString("lotte_nine", "??????");
                    home_pitcher = sharedPreferences.getString("lotte_one_pit", "??????");
                    home_catcher = sharedPreferences.getString("lotte_catcher", "??????");
                    home_firstbase = sharedPreferences.getString("lotte_firstbase", "??????");
                    home_secondbase = sharedPreferences.getString("lotte_secondbase", "??????");
                    home_thirdbase = sharedPreferences.getString("lotte_thirdbase", "??????");
                    home_shortstop = sharedPreferences.getString("lotte_shortstop", "??????");
                    home_leftfielder = sharedPreferences.getString("lotte_leftfielder", "??????");
                    home_centerfielder = sharedPreferences.getString("lotte_centerfielder", "??????");
                    home_rightfielder = sharedPreferences.getString("lotte_rightfielder", "??????");

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
                if(choice_away.equals("??????")) {
                    away_player1 = sharedPreferences.getString("hanhwa_one", "??????");
                    away_player2 = sharedPreferences.getString("hanhwa_two", "??????");
                    away_player3 = sharedPreferences.getString("hanhwa_three", "??????");
                    away_player4 = sharedPreferences.getString("hanhwa_four", "??????");
                    away_player5 = sharedPreferences.getString("hanhwa_five", "??????");
                    away_player6 = sharedPreferences.getString("hanhwa_six", "??????");
                    away_player7 = sharedPreferences.getString("hanhwa_seven", "??????");
                    away_player8 = sharedPreferences.getString("hanhwa_eight", "??????");
                    away_player9 = sharedPreferences.getString("hanhwa_nine", "??????");
                    away_pitcher = sharedPreferences.getString("hanhwa_one_pit", "??????");
                    away_catcher = sharedPreferences.getString("hanhwa_catcher", "??????");
                    away_firstbase = sharedPreferences.getString("hanhwa_firstbase", "??????");
                    away_secondbase = sharedPreferences.getString("hanhwa_secondbase", "??????");
                    away_thirdbase = sharedPreferences.getString("hanhwa_thirdbase", "??????");
                    away_shortstop = sharedPreferences.getString("hanhwa_shortstop", "??????");
                    away_leftfielder = sharedPreferences.getString("hanhwa_leftfielder", "??????");
                    away_centerfielder = sharedPreferences.getString("hanhwa_centerfielder", "??????");
                    away_rightfielder = sharedPreferences.getString("hanhwa_rightfielder", "??????");
                }


                if(choice_away.equals("??????")) {
                    away_player1 = sharedPreferences.getString("nexen_one", "??????");
                    away_player2 = sharedPreferences.getString("nexen_two", "??????");
                    away_player3 = sharedPreferences.getString("nexen_three", "??????");
                    away_player4 = sharedPreferences.getString("nexen_four", "??????");
                    away_player5 = sharedPreferences.getString("nexen_five", "??????");
                    away_player6 = sharedPreferences.getString("nexen_six", "??????");
                    away_player7 = sharedPreferences.getString("nexen_seven", "??????");
                    away_player8 = sharedPreferences.getString("nexen_eight", "??????");
                    away_player9 = sharedPreferences.getString("nexen_nine", "??????");
                    away_pitcher = sharedPreferences.getString("nexen_one_pit", "??????");
                    away_catcher = sharedPreferences.getString("nexen_catcher", "??????");
                    away_firstbase = sharedPreferences.getString("nexen_firstbase", "??????");
                    away_secondbase = sharedPreferences.getString("nexen_secondbase", "??????");
                    away_thirdbase = sharedPreferences.getString("nexen_thirdbase", "??????");
                    away_shortstop = sharedPreferences.getString("nexen_shortstop", "??????");
                    away_leftfielder = sharedPreferences.getString("nexen_leftfielder", "??????");
                    away_centerfielder = sharedPreferences.getString("nexen_centerfielder", "??????");
                    away_rightfielder = sharedPreferences.getString("nexen_rightfielder", "??????");

                }
                if(choice_away.equals("KT")) {
                    away_player1 = sharedPreferences.getString("kt_one", "??????");
                    away_player2 = sharedPreferences.getString("kt_two", "??????");
                    away_player3 = sharedPreferences.getString("kt_three", "??????");
                    away_player4 = sharedPreferences.getString("kt_four", "??????");
                    away_player5 = sharedPreferences.getString("kt_five", "??????");
                    away_player6 = sharedPreferences.getString("kt_six", "??????");
                    away_player7 = sharedPreferences.getString("kt_seven", "??????");
                    away_player8 = sharedPreferences.getString("kt_eight", "??????");
                    away_player9 = sharedPreferences.getString("kt_nine", "??????");
                    away_pitcher = sharedPreferences.getString("kt_one_pit", "??????");
                    away_catcher = sharedPreferences.getString("kt_catcher", "??????");
                    away_firstbase = sharedPreferences.getString("kt_firstbase", "??????");
                    away_secondbase = sharedPreferences.getString("kt_secondbase", "??????");
                    away_thirdbase = sharedPreferences.getString("kt_thirdbase", "??????");
                    away_shortstop = sharedPreferences.getString("kt_shortstop", "??????");
                    away_leftfielder = sharedPreferences.getString("kt_leftfielder", "??????");
                    away_centerfielder = sharedPreferences.getString("kt_centerfielder", "??????");
                    away_rightfielder = sharedPreferences.getString("kt_rightfielder", "??????");
                }
                if(choice_away.equals("??????")) {
                    away_player1 = sharedPreferences.getString("samsung_one", "??????");
                    away_player2 = sharedPreferences.getString("samsung_two", "??????");
                    away_player3 = sharedPreferences.getString("samsung_three", "??????");
                    away_player4 = sharedPreferences.getString("samsung_four", "??????");
                    away_player5 = sharedPreferences.getString("samsung_five", "??????");
                    away_player6 = sharedPreferences.getString("samsung_six", "??????");
                    away_player7 = sharedPreferences.getString("samsung_seven", "??????");
                    away_player8 = sharedPreferences.getString("samsung_eight", "??????");
                    away_player9 = sharedPreferences.getString("samsung_nine", "??????");
                    away_pitcher = sharedPreferences.getString("samsung_one_pit", "??????");
                    away_catcher = sharedPreferences.getString("samsung_catcher", "??????");
                    away_firstbase = sharedPreferences.getString("samsugn_firstbase", "??????");
                    away_secondbase = sharedPreferences.getString("samsugn_secondbase", "??????");
                    away_thirdbase = sharedPreferences.getString("samsugn_thirdbase", "??????");
                    away_shortstop = sharedPreferences.getString("samsugn_shortstop", "??????");
                    away_leftfielder = sharedPreferences.getString("samsugn_leftfielder", "??????");
                    away_centerfielder = sharedPreferences.getString("samsugn_centerfielder", "??????");
                    away_rightfielder = sharedPreferences.getString("samsung_rightfielder", "??????");

                }
                if(choice_away.equals("LG")) {
                    away_player1 = sharedPreferences.getString("lg_one", "??????");
                    away_player2 = sharedPreferences.getString("lg_two", "??????");
                    away_player3 = sharedPreferences.getString("lg_three", "??????");
                    away_player4 = sharedPreferences.getString("lg_four", "??????");
                    away_player5 = sharedPreferences.getString("lg_five", "??????");
                    away_player6 = sharedPreferences.getString("lg_six", "??????");
                    away_player7 = sharedPreferences.getString("lg_seven", "??????");
                    away_player8 = sharedPreferences.getString("lg_eight", "??????");
                    away_player9 = sharedPreferences.getString("lg_nine", "??????");
                    away_pitcher = sharedPreferences.getString("lg_one_pit", "??????");
                    away_catcher = sharedPreferences.getString("lg_catcher", "??????");
                    away_firstbase = sharedPreferences.getString("lg_firstbase", "??????");
                    away_secondbase = sharedPreferences.getString("lg_secondbase", "??????");
                    away_thirdbase = sharedPreferences.getString("lg_thirdbase", "??????");
                    away_shortstop = sharedPreferences.getString("lg_shortstop", "??????");
                    away_leftfielder = sharedPreferences.getString("lg_leftfielder", "??????");
                    away_centerfielder = sharedPreferences.getString("lg_centerfielder", "??????");
                    away_rightfielder = sharedPreferences.getString("lg_rightfielder", "??????");

                }
                if(choice_away.equals("NC")) {
                    away_player1 = sharedPreferences.getString("nc_one", "??????");
                    away_player2 = sharedPreferences.getString("nc_two", "??????");
                    away_player3 = sharedPreferences.getString("nc_three", "??????");
                    away_player4 = sharedPreferences.getString("nc_four", "??????");
                    away_player5 = sharedPreferences.getString("nc_five", "??????");
                    away_player6 = sharedPreferences.getString("nc_six", "??????");
                    away_player7 = sharedPreferences.getString("nc_seven", "??????");
                    away_player8 = sharedPreferences.getString("nc_eight", "??????");
                    away_player9 = sharedPreferences.getString("nc_nine", "??????");
                    away_pitcher = sharedPreferences.getString("nc_one_pit", "??????");
                    away_catcher = sharedPreferences.getString("nc_catcher", "??????");
                    away_firstbase = sharedPreferences.getString("nc_firstbase", "??????");
                    away_secondbase = sharedPreferences.getString("nc_secondbase", "??????");
                    away_thirdbase = sharedPreferences.getString("nc_thirdbase", "??????");
                    away_shortstop = sharedPreferences.getString("nc_shortstop", "??????");
                    away_leftfielder = sharedPreferences.getString("nc_leftfielder", "??????");
                    away_centerfielder = sharedPreferences.getString("nc_centerfielder", "??????");
                    away_rightfielder = sharedPreferences.getString("nc_rightfielder", "??????");
                }
                if(choice_away.equals("??????")) {
                    away_player1 = sharedPreferences.getString("dusan_one", "??????");
                    away_player2 = sharedPreferences.getString("dusan_two", "??????");
                    away_player3 = sharedPreferences.getString("dusan_three", "??????");
                    away_player4 = sharedPreferences.getString("dusan_four", "??????");
                    away_player5 = sharedPreferences.getString("dusan_five", "??????");
                    away_player6 = sharedPreferences.getString("dusan_six", "??????");
                    away_player7 = sharedPreferences.getString("dusan_seven", "??????");
                    away_player8 = sharedPreferences.getString("dusan_eight", "??????");
                    away_player9 = sharedPreferences.getString("dusan_nine", "??????");
                    away_pitcher = sharedPreferences.getString("dusan_one_pit", "??????");
                    away_catcher = sharedPreferences.getString("dusan_catcher", "??????");
                    away_firstbase = sharedPreferences.getString("dusan_firstbase", "??????");
                    away_secondbase = sharedPreferences.getString("dusan_secondbase", "??????");
                    away_thirdbase = sharedPreferences.getString("dusan_thirdbase", "??????");
                    away_shortstop = sharedPreferences.getString("dusan_shortstop", "??????");
                    away_leftfielder = sharedPreferences.getString("dusan_leftfielder", "??????");
                    away_centerfielder = sharedPreferences.getString("dusan_centerfielder", "??????");
                    away_rightfielder = sharedPreferences.getString("dusan_rightfielder", "??????");
                }
                if(choice_away.equals("SSG")) {
                    away_player1 = sharedPreferences.getString("ssg_one", "??????");
                    away_player2 = sharedPreferences.getString("ssg_two", "??????");
                    away_player3 = sharedPreferences.getString("ssg_three", "??????");
                    away_player4 = sharedPreferences.getString("ssg_four", "??????");
                    away_player5 = sharedPreferences.getString("ssg_five", "??????");
                    away_player6 = sharedPreferences.getString("ssg_six", "??????");
                    away_player7 = sharedPreferences.getString("ssg_seven", "??????");
                    away_player8 = sharedPreferences.getString("ssg_eight", "??????");
                    away_player9 = sharedPreferences.getString("ssg_nine", "??????");
                    away_pitcher = sharedPreferences.getString("ssg_one_pit", "??????");
                    away_catcher = sharedPreferences.getString("ssg_catcher", "??????");
                    away_firstbase = sharedPreferences.getString("ssg_firstbase", "??????");
                    away_secondbase = sharedPreferences.getString("ssg_secondbase", "??????");
                    away_thirdbase = sharedPreferences.getString("ssg_thirdbase", "??????");
                    away_shortstop = sharedPreferences.getString("ssg_shortstop", "??????");
                    away_leftfielder = sharedPreferences.getString("ssg_leftfielder", "??????");
                    away_centerfielder = sharedPreferences.getString("ssg_centerfielder", "??????");
                    away_rightfielder = sharedPreferences.getString("ssg_rightfielder", "??????");
                }
                if(choice_away.equals("??????")) {
                    away_player1 = sharedPreferences.getString("lotte_one", "??????");
                    away_player2 = sharedPreferences.getString("lotte_two", "??????");
                    away_player3 = sharedPreferences.getString("lotte_three", "??????");
                    away_player4 = sharedPreferences.getString("lotte_four", "??????");
                    away_player5 = sharedPreferences.getString("lotte_five", "??????");
                    away_player6 = sharedPreferences.getString("lotte_six", "??????");
                    away_player7 = sharedPreferences.getString("lotte_seven", "??????");
                    away_player8 = sharedPreferences.getString("lotte_eight", "??????");
                    away_player9 = sharedPreferences.getString("lotte_nine", "??????");
                    away_pitcher = sharedPreferences.getString("lotte_one_pit", "??????");
                    away_catcher = sharedPreferences.getString("lotte_catcher", "??????");
                    away_firstbase = sharedPreferences.getString("lotte_firstbase", "??????");
                    away_secondbase = sharedPreferences.getString("lotte_secondbase", "??????");
                    away_thirdbase = sharedPreferences.getString("lotte_thirdbase", "??????");
                    away_shortstop = sharedPreferences.getString("lotte_shortstop", "??????");
                    away_leftfielder = sharedPreferences.getString("lotte_leftfielder", "??????");
                    away_centerfielder = sharedPreferences.getString("lotte_centerfielder", "??????");
                    away_rightfielder = sharedPreferences.getString("lotte_rightfielder", "??????");
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

                CreateTable_Request_pitcher CreateTable_Request_pitcher = new CreateTable_Request_pitcher(choice_away, choice_home,
                        away_pitcher, home_pitcher, responseListener);
                RequestQueue queue6 = Volley.newRequestQueue(start.this);
                queue6.add(CreateTable_Request_pitcher);


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

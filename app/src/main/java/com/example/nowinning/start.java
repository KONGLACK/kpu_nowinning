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
                if(choice_home.equals("한화")) {
                    home_player1 = sharedPreferences.getString("hanhwa_one", "오류");
                    home_player2 = sharedPreferences.getString("hanhwa_two", "오류");
                    home_player3 = sharedPreferences.getString("hanhwa_three", "오류");
                    home_player4 = sharedPreferences.getString("hanhwa_four", "오류");
                    home_player5 = sharedPreferences.getString("hanhwa_five", "오류");
                    home_player6 = sharedPreferences.getString("hanhwa_six", "오류");
                    home_player7 = sharedPreferences.getString("hanhwa_seven", "오류");
                    home_player8 = sharedPreferences.getString("hanhwa_eight", "오류");
                    home_player9 = sharedPreferences.getString("hanhwa_nine", "오류");
                    home_pitcher = sharedPreferences.getString("hanhwa_one_pit", "오류");
                    home_catcher = sharedPreferences.getString("hanhwa_catcher", "오류");
                    home_firstbase = sharedPreferences.getString("hanhwa_firstbase", "오류");
                    home_secondbase = sharedPreferences.getString("hanhwa_secondbase", "오류");
                    home_thirdbase = sharedPreferences.getString("hanhwa_thirdbase", "오류");
                    home_shortstop = sharedPreferences.getString("hanhwa_shortstop", "오류");
                    home_leftfielder = sharedPreferences.getString("hanhwa_leftfielder", "오류");
                    home_centerfielder = sharedPreferences.getString("hanhwa_centerfielder", "오류");
                    home_rightfielder = sharedPreferences.getString("hanhwa_rightfielder", "오류");
                }

                if(choice_home.equals("넥센")) {
                    home_player1 = sharedPreferences.getString("nexen_one", "오류");
                    home_player2 = sharedPreferences.getString("nexen_two", "오류");
                    home_player3 = sharedPreferences.getString("nexen_three", "오류");
                    home_player4 = sharedPreferences.getString("nexen_four", "오류");
                    home_player5 = sharedPreferences.getString("nexen_five", "오류");
                    home_player6 = sharedPreferences.getString("nexen_six", "오류");
                    home_player7 = sharedPreferences.getString("nexen_seven", "오류");
                    home_player8 = sharedPreferences.getString("nexen_eight", "오류");
                    home_player9 = sharedPreferences.getString("nexen_nine", "오류");
                    home_pitcher = sharedPreferences.getString("nexen_one_pit", "오류");
                    home_catcher = sharedPreferences.getString("nexen_catcher", "오류");
                    home_firstbase = sharedPreferences.getString("nexen_firstbase", "오류");
                    home_secondbase = sharedPreferences.getString("nexen_secondbase", "오류");
                    home_thirdbase = sharedPreferences.getString("nexen_thirdbase", "오류");
                    home_shortstop = sharedPreferences.getString("nexen_shortstop", "오류");
                    home_leftfielder = sharedPreferences.getString("nexen_leftfielder", "오류");
                    home_centerfielder = sharedPreferences.getString("nexen_centerfielder", "오류");
                    home_rightfielder = sharedPreferences.getString("nexen_rightfielder", "오류");

                }
                if(choice_home.equals("KT")) {
                    home_player1 = sharedPreferences.getString("kt_one", "오류");
                    home_player2 = sharedPreferences.getString("kt_two", "오류");
                    home_player3 = sharedPreferences.getString("kt_three", "오류");
                    home_player4 = sharedPreferences.getString("kt_four", "오류");
                    home_player5 = sharedPreferences.getString("kt_five", "오류");
                    home_player6 = sharedPreferences.getString("kt_six", "오류");
                    home_player7 = sharedPreferences.getString("kt_seven", "오류");
                    home_player8 = sharedPreferences.getString("kt_eight", "오류");
                    home_player9 = sharedPreferences.getString("kt_nine", "오류");
                    home_pitcher = sharedPreferences.getString("kt_one_pit", "오류");
                    home_catcher = sharedPreferences.getString("kt_catcher", "오류");
                    home_firstbase = sharedPreferences.getString("kt_firstbase", "오류");
                    home_secondbase = sharedPreferences.getString("kt_secondbase", "오류");
                    home_thirdbase = sharedPreferences.getString("kt_thirdbase", "오류");
                    home_shortstop = sharedPreferences.getString("kt_shortstop", "오류");
                    home_leftfielder = sharedPreferences.getString("kt_leftfielder", "오류");
                    home_centerfielder = sharedPreferences.getString("kt_centerfielder", "오류");
                    home_rightfielder = sharedPreferences.getString("kt_rightfielder", "오류");

                }
                if(choice_home.equals("삼성")) {
                    home_player1 = sharedPreferences.getString("samsung_one", "오류");
                    home_player2 = sharedPreferences.getString("samsung_two", "오류");
                    home_player3 = sharedPreferences.getString("samsung_three", "오류");
                    home_player4 = sharedPreferences.getString("samsung_four", "오류");
                    home_player5 = sharedPreferences.getString("samsung_five", "오류");
                    home_player6 = sharedPreferences.getString("samsung_six", "오류");
                    home_player7 = sharedPreferences.getString("samsung_seven", "오류");
                    home_player8 = sharedPreferences.getString("samsung_eight", "오류");
                    home_player9 = sharedPreferences.getString("samsung_nine", "오류");
                    home_pitcher = sharedPreferences.getString("samsung_one_pit", "오류");
                    home_catcher = sharedPreferences.getString("samsung_catcher", "오류");
                    home_firstbase = sharedPreferences.getString("samsung_firstbase", "오류");
                    home_secondbase = sharedPreferences.getString("samsung_secondbase", "오류");
                    home_thirdbase = sharedPreferences.getString("samsung_thirdbase", "오류");
                    home_shortstop = sharedPreferences.getString("samsung_shortstop", "오류");
                    home_leftfielder = sharedPreferences.getString("samsung_leftfielder", "오류");
                    home_centerfielder = sharedPreferences.getString("samsung_centerfielder", "오류");
                    home_rightfielder = sharedPreferences.getString("samsung_rightfielder", "오류");

                }
                if(choice_home.equals("LG")) {
                    home_player1 = sharedPreferences.getString("lg_one", "오류");
                    home_player2 = sharedPreferences.getString("lg_two", "오류");
                    home_player3 = sharedPreferences.getString("lg_three", "오류");
                    home_player4 = sharedPreferences.getString("lg_four", "오류");
                    home_player5 = sharedPreferences.getString("lg_five", "오류");
                    home_player6 = sharedPreferences.getString("lg_six", "오류");
                    home_player7 = sharedPreferences.getString("lg_seven", "오류");
                    home_player8 = sharedPreferences.getString("lg_eight", "오류");
                    home_player9 = sharedPreferences.getString("lg_nine", "오류");
                    home_pitcher = sharedPreferences.getString("lg_one_pit", "오류");
                    home_catcher = sharedPreferences.getString("lg_catcher", "오류");
                    home_firstbase = sharedPreferences.getString("lg_firstbase", "오류");
                    home_secondbase = sharedPreferences.getString("lg_secondbase", "오류");
                    home_thirdbase = sharedPreferences.getString("lg_thirdbase", "오류");
                    home_shortstop = sharedPreferences.getString("lg_shortstop", "오류");
                    home_leftfielder = sharedPreferences.getString("lg_leftfielder", "오류");
                    home_centerfielder = sharedPreferences.getString("lg_centerfielder", "오류");
                    home_rightfielder = sharedPreferences.getString("lg_rightfielder", "오류");
                }
                if(choice_home.equals("NC")) {
                    home_player1 = sharedPreferences.getString("nc_one", "오류");
                    home_player2 = sharedPreferences.getString("nc_two", "오류");
                    home_player3 = sharedPreferences.getString("nc_three", "오류");
                    home_player4 = sharedPreferences.getString("nc_four", "오류");
                    home_player5 = sharedPreferences.getString("nc_five", "오류");
                    home_player6 = sharedPreferences.getString("nc_six", "오류");
                    home_player7 = sharedPreferences.getString("nc_seven", "오류");
                    home_player8 = sharedPreferences.getString("nc_eight", "오류");
                    home_player9 = sharedPreferences.getString("nc_nine", "오류");
                    home_pitcher = sharedPreferences.getString("nc_one_pit", "오류");
                    home_catcher = sharedPreferences.getString("nc_catcher", "오류");
                    home_firstbase = sharedPreferences.getString("nc_firstbase", "오류");
                    home_secondbase = sharedPreferences.getString("nc_secondbase", "오류");
                    home_thirdbase = sharedPreferences.getString("nc_thirdbase", "오류");
                    home_shortstop = sharedPreferences.getString("nc_shortstop", "오류");
                    home_leftfielder = sharedPreferences.getString("nc_leftfielder", "오류");
                    home_centerfielder = sharedPreferences.getString("nc_centerfielder", "오류");
                    home_rightfielder = sharedPreferences.getString("nc_rightfielder", "오류");
                }
                if(choice_home.equals("두산")) {
                    home_player1 = sharedPreferences.getString("dusan_one", "오류");
                    home_player2 = sharedPreferences.getString("dusan_two", "오류");
                    home_player3 = sharedPreferences.getString("dusan_three", "오류");
                    home_player4 = sharedPreferences.getString("dusan_four", "오류");
                    home_player5 = sharedPreferences.getString("dusan_five", "오류");
                    home_player6 = sharedPreferences.getString("dusan_six", "오류");
                    home_player7 = sharedPreferences.getString("dusan_seven", "오류");
                    home_player8 = sharedPreferences.getString("dusan_eight", "오류");
                    home_player9 = sharedPreferences.getString("dusan_nine", "오류");
                    home_pitcher = sharedPreferences.getString("dusan_one_pit", "오류");
                    home_catcher = sharedPreferences.getString("dusan_catcher", "오류");
                    home_firstbase = sharedPreferences.getString("dusan_firstbase", "오류");
                    home_secondbase = sharedPreferences.getString("dusan_secondbase", "오류");
                    home_thirdbase = sharedPreferences.getString("dusan_thirdbase", "오류");
                    home_shortstop = sharedPreferences.getString("dusan_shortstop", "오류");
                    home_leftfielder = sharedPreferences.getString("dusan_leftfielder", "오류");
                    home_centerfielder = sharedPreferences.getString("dusan_centerfielder", "오류");
                    home_rightfielder = sharedPreferences.getString("dusan_rightfielder", "오류");
                }
                if(choice_home.equals("SSG")) {
                    home_player1 = sharedPreferences.getString("ssg_one", "오류");
                    home_player2 = sharedPreferences.getString("ssg_two", "오류");
                    home_player3 = sharedPreferences.getString("ssg_three", "오류");
                    home_player4 = sharedPreferences.getString("ssg_four", "오류");
                    home_player5 = sharedPreferences.getString("ssg_five", "오류");
                    home_player6 = sharedPreferences.getString("ssg_six", "오류");
                    home_player7 = sharedPreferences.getString("ssg_seven", "오류");
                    home_player8 = sharedPreferences.getString("ssg_eight", "오류");
                    home_player9 = sharedPreferences.getString("ssg_nine", "오류");
                    home_pitcher = sharedPreferences.getString("ssg_one_pit", "오류");
                    home_catcher = sharedPreferences.getString("ssg_catcher", "오류");
                    home_firstbase = sharedPreferences.getString("ssg_firstbase", "오류");
                    home_secondbase = sharedPreferences.getString("ssg_secondbase", "오류");
                    home_thirdbase = sharedPreferences.getString("ssg_thirdbase", "오류");
                    home_shortstop = sharedPreferences.getString("ssg_shortstop", "오류");
                    home_leftfielder = sharedPreferences.getString("ssg_leftfielder", "오류");
                    home_centerfielder = sharedPreferences.getString("ssg_centerfielder", "오류");
                    home_rightfielder = sharedPreferences.getString("ssg_rightfielder", "오류");
                }
                if(choice_home.equals("롯데")) {
                    home_player1 = sharedPreferences.getString("lotte_one", "오류");
                    home_player2 = sharedPreferences.getString("lotte_two", "오류");
                    home_player3 = sharedPreferences.getString("lotte_three", "오류");
                    home_player4 = sharedPreferences.getString("lotte_four", "오류");
                    home_player5 = sharedPreferences.getString("lotte_five", "오류");
                    home_player6 = sharedPreferences.getString("lotte_six", "오류");
                    home_player7 = sharedPreferences.getString("lotte_seven", "오류");
                    home_player8 = sharedPreferences.getString("lotte_eight", "오류");
                    home_player9 = sharedPreferences.getString("lotte_nine", "오류");
                    home_pitcher = sharedPreferences.getString("lotte_one_pit", "오류");
                    home_catcher = sharedPreferences.getString("lotte_catcher", "오류");
                    home_firstbase = sharedPreferences.getString("lotte_firstbase", "오류");
                    home_secondbase = sharedPreferences.getString("lotte_secondbase", "오류");
                    home_thirdbase = sharedPreferences.getString("lotte_thirdbase", "오류");
                    home_shortstop = sharedPreferences.getString("lotte_shortstop", "오류");
                    home_leftfielder = sharedPreferences.getString("lotte_leftfielder", "오류");
                    home_centerfielder = sharedPreferences.getString("lotte_centerfielder", "오류");
                    home_rightfielder = sharedPreferences.getString("lotte_rightfielder", "오류");

                }
                if(choice_home.equals("KIA")) {
                    home_player1 = sharedPreferences.getString("kia_one", "오류");
                    home_player2 = sharedPreferences.getString("kia_two", "오류");
                    home_player3 = sharedPreferences.getString("kia_three", "오류");
                    home_player4 = sharedPreferences.getString("kia_four", "오류");
                    home_player5 = sharedPreferences.getString("kia_five", "오류");
                    home_player6 = sharedPreferences.getString("kia_six", "오류");
                    home_player7 = sharedPreferences.getString("kia_seven", "오류");
                    home_player8 = sharedPreferences.getString("kia_eight", "오류");
                    home_player9 = sharedPreferences.getString("kia_nine", "오류");
                    home_pitcher = sharedPreferences.getString("kia_one_pit", "오류");
                    home_catcher = sharedPreferences.getString("kia_catcher", "오류");
                    home_firstbase = sharedPreferences.getString("kia_firstbase", "오류");
                    home_secondbase = sharedPreferences.getString("kia_secondbase", "오류");
                    home_thirdbase = sharedPreferences.getString("kia_thirdbase", "오류");
                    home_shortstop = sharedPreferences.getString("kia_shortstop", "오류");
                    home_leftfielder = sharedPreferences.getString("kia_leftfielder", "오류");
                    home_centerfielder = sharedPreferences.getString("kia_centerfielder", "오류");
                    home_rightfielder = sharedPreferences.getString("kia_rightfielder", "오류");
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
                    away_player1 = sharedPreferences.getString("hanhwa_one", "오류");
                    away_player2 = sharedPreferences.getString("hanhwa_two", "오류");
                    away_player3 = sharedPreferences.getString("hanhwa_three", "오류");
                    away_player4 = sharedPreferences.getString("hanhwa_four", "오류");
                    away_player5 = sharedPreferences.getString("hanhwa_five", "오류");
                    away_player6 = sharedPreferences.getString("hanhwa_six", "오류");
                    away_player7 = sharedPreferences.getString("hanhwa_seven", "오류");
                    away_player8 = sharedPreferences.getString("hanhwa_eight", "오류");
                    away_player9 = sharedPreferences.getString("hanhwa_nine", "오류");
                    away_pitcher = sharedPreferences.getString("hanhwa_one_pit", "오류");
                    away_catcher = sharedPreferences.getString("hanhwa_catcher", "오류");
                    away_firstbase = sharedPreferences.getString("hanhwa_firstbase", "오류");
                    away_secondbase = sharedPreferences.getString("hanhwa_secondbase", "오류");
                    away_thirdbase = sharedPreferences.getString("hanhwa_thirdbase", "오류");
                    away_shortstop = sharedPreferences.getString("hanhwa_shortstop", "오류");
                    away_leftfielder = sharedPreferences.getString("hanhwa_leftfielder", "오류");
                    away_centerfielder = sharedPreferences.getString("hanhwa_centerfielder", "오류");
                    away_rightfielder = sharedPreferences.getString("hanhwa_rightfielder", "오류");
                }


                if(choice_away.equals("넥센")) {
                    away_player1 = sharedPreferences.getString("nexen_one", "오류");
                    away_player2 = sharedPreferences.getString("nexen_two", "오류");
                    away_player3 = sharedPreferences.getString("nexen_three", "오류");
                    away_player4 = sharedPreferences.getString("nexen_four", "오류");
                    away_player5 = sharedPreferences.getString("nexen_five", "오류");
                    away_player6 = sharedPreferences.getString("nexen_six", "오류");
                    away_player7 = sharedPreferences.getString("nexen_seven", "오류");
                    away_player8 = sharedPreferences.getString("nexen_eight", "오류");
                    away_player9 = sharedPreferences.getString("nexen_nine", "오류");
                    away_pitcher = sharedPreferences.getString("nexen_one_pit", "오류");
                    away_catcher = sharedPreferences.getString("nexen_catcher", "오류");
                    away_firstbase = sharedPreferences.getString("nexen_firstbase", "오류");
                    away_secondbase = sharedPreferences.getString("nexen_secondbase", "오류");
                    away_thirdbase = sharedPreferences.getString("nexen_thirdbase", "오류");
                    away_shortstop = sharedPreferences.getString("nexen_shortstop", "오류");
                    away_leftfielder = sharedPreferences.getString("nexen_leftfielder", "오류");
                    away_centerfielder = sharedPreferences.getString("nexen_centerfielder", "오류");
                    away_rightfielder = sharedPreferences.getString("nexen_rightfielder", "오류");

                }
                if(choice_away.equals("KT")) {
                    away_player1 = sharedPreferences.getString("kt_one", "오류");
                    away_player2 = sharedPreferences.getString("kt_two", "오류");
                    away_player3 = sharedPreferences.getString("kt_three", "오류");
                    away_player4 = sharedPreferences.getString("kt_four", "오류");
                    away_player5 = sharedPreferences.getString("kt_five", "오류");
                    away_player6 = sharedPreferences.getString("kt_six", "오류");
                    away_player7 = sharedPreferences.getString("kt_seven", "오류");
                    away_player8 = sharedPreferences.getString("kt_eight", "오류");
                    away_player9 = sharedPreferences.getString("kt_nine", "오류");
                    away_pitcher = sharedPreferences.getString("kt_one_pit", "오류");
                    away_catcher = sharedPreferences.getString("kt_catcher", "오류");
                    away_firstbase = sharedPreferences.getString("kt_firstbase", "오류");
                    away_secondbase = sharedPreferences.getString("kt_secondbase", "오류");
                    away_thirdbase = sharedPreferences.getString("kt_thirdbase", "오류");
                    away_shortstop = sharedPreferences.getString("kt_shortstop", "오류");
                    away_leftfielder = sharedPreferences.getString("kt_leftfielder", "오류");
                    away_centerfielder = sharedPreferences.getString("kt_centerfielder", "오류");
                    away_rightfielder = sharedPreferences.getString("kt_rightfielder", "오류");
                }
                if(choice_away.equals("삼성")) {
                    away_player1 = sharedPreferences.getString("samsung_one", "오류");
                    away_player2 = sharedPreferences.getString("samsung_two", "오류");
                    away_player3 = sharedPreferences.getString("samsung_three", "오류");
                    away_player4 = sharedPreferences.getString("samsung_four", "오류");
                    away_player5 = sharedPreferences.getString("samsung_five", "오류");
                    away_player6 = sharedPreferences.getString("samsung_six", "오류");
                    away_player7 = sharedPreferences.getString("samsung_seven", "오류");
                    away_player8 = sharedPreferences.getString("samsung_eight", "오류");
                    away_player9 = sharedPreferences.getString("samsung_nine", "오류");
                    away_pitcher = sharedPreferences.getString("samsung_one_pit", "오류");
                    away_catcher = sharedPreferences.getString("samsung_catcher", "오류");
                    away_firstbase = sharedPreferences.getString("samsugn_firstbase", "오류");
                    away_secondbase = sharedPreferences.getString("samsugn_secondbase", "오류");
                    away_thirdbase = sharedPreferences.getString("samsugn_thirdbase", "오류");
                    away_shortstop = sharedPreferences.getString("samsugn_shortstop", "오류");
                    away_leftfielder = sharedPreferences.getString("samsugn_leftfielder", "오류");
                    away_centerfielder = sharedPreferences.getString("samsugn_centerfielder", "오류");
                    away_rightfielder = sharedPreferences.getString("samsung_rightfielder", "오류");

                }
                if(choice_away.equals("LG")) {
                    away_player1 = sharedPreferences.getString("lg_one", "오류");
                    away_player2 = sharedPreferences.getString("lg_two", "오류");
                    away_player3 = sharedPreferences.getString("lg_three", "오류");
                    away_player4 = sharedPreferences.getString("lg_four", "오류");
                    away_player5 = sharedPreferences.getString("lg_five", "오류");
                    away_player6 = sharedPreferences.getString("lg_six", "오류");
                    away_player7 = sharedPreferences.getString("lg_seven", "오류");
                    away_player8 = sharedPreferences.getString("lg_eight", "오류");
                    away_player9 = sharedPreferences.getString("lg_nine", "오류");
                    away_pitcher = sharedPreferences.getString("lg_one_pit", "오류");
                    away_catcher = sharedPreferences.getString("lg_catcher", "오류");
                    away_firstbase = sharedPreferences.getString("lg_firstbase", "오류");
                    away_secondbase = sharedPreferences.getString("lg_secondbase", "오류");
                    away_thirdbase = sharedPreferences.getString("lg_thirdbase", "오류");
                    away_shortstop = sharedPreferences.getString("lg_shortstop", "오류");
                    away_leftfielder = sharedPreferences.getString("lg_leftfielder", "오류");
                    away_centerfielder = sharedPreferences.getString("lg_centerfielder", "오류");
                    away_rightfielder = sharedPreferences.getString("lg_rightfielder", "오류");

                }
                if(choice_away.equals("NC")) {
                    away_player1 = sharedPreferences.getString("nc_one", "오류");
                    away_player2 = sharedPreferences.getString("nc_two", "오류");
                    away_player3 = sharedPreferences.getString("nc_three", "오류");
                    away_player4 = sharedPreferences.getString("nc_four", "오류");
                    away_player5 = sharedPreferences.getString("nc_five", "오류");
                    away_player6 = sharedPreferences.getString("nc_six", "오류");
                    away_player7 = sharedPreferences.getString("nc_seven", "오류");
                    away_player8 = sharedPreferences.getString("nc_eight", "오류");
                    away_player9 = sharedPreferences.getString("nc_nine", "오류");
                    away_pitcher = sharedPreferences.getString("nc_one_pit", "오류");
                    away_catcher = sharedPreferences.getString("nc_catcher", "오류");
                    away_firstbase = sharedPreferences.getString("nc_firstbase", "오류");
                    away_secondbase = sharedPreferences.getString("nc_secondbase", "오류");
                    away_thirdbase = sharedPreferences.getString("nc_thirdbase", "오류");
                    away_shortstop = sharedPreferences.getString("nc_shortstop", "오류");
                    away_leftfielder = sharedPreferences.getString("nc_leftfielder", "오류");
                    away_centerfielder = sharedPreferences.getString("nc_centerfielder", "오류");
                    away_rightfielder = sharedPreferences.getString("nc_rightfielder", "오류");
                }
                if(choice_away.equals("두산")) {
                    away_player1 = sharedPreferences.getString("dusan_one", "오류");
                    away_player2 = sharedPreferences.getString("dusan_two", "오류");
                    away_player3 = sharedPreferences.getString("dusan_three", "오류");
                    away_player4 = sharedPreferences.getString("dusan_four", "오류");
                    away_player5 = sharedPreferences.getString("dusan_five", "오류");
                    away_player6 = sharedPreferences.getString("dusan_six", "오류");
                    away_player7 = sharedPreferences.getString("dusan_seven", "오류");
                    away_player8 = sharedPreferences.getString("dusan_eight", "오류");
                    away_player9 = sharedPreferences.getString("dusan_nine", "오류");
                    away_pitcher = sharedPreferences.getString("dusan_one_pit", "오류");
                    away_catcher = sharedPreferences.getString("dusan_catcher", "오류");
                    away_firstbase = sharedPreferences.getString("dusan_firstbase", "오류");
                    away_secondbase = sharedPreferences.getString("dusan_secondbase", "오류");
                    away_thirdbase = sharedPreferences.getString("dusan_thirdbase", "오류");
                    away_shortstop = sharedPreferences.getString("dusan_shortstop", "오류");
                    away_leftfielder = sharedPreferences.getString("dusan_leftfielder", "오류");
                    away_centerfielder = sharedPreferences.getString("dusan_centerfielder", "오류");
                    away_rightfielder = sharedPreferences.getString("dusan_rightfielder", "오류");
                }
                if(choice_away.equals("SSG")) {
                    away_player1 = sharedPreferences.getString("ssg_one", "오류");
                    away_player2 = sharedPreferences.getString("ssg_two", "오류");
                    away_player3 = sharedPreferences.getString("ssg_three", "오류");
                    away_player4 = sharedPreferences.getString("ssg_four", "오류");
                    away_player5 = sharedPreferences.getString("ssg_five", "오류");
                    away_player6 = sharedPreferences.getString("ssg_six", "오류");
                    away_player7 = sharedPreferences.getString("ssg_seven", "오류");
                    away_player8 = sharedPreferences.getString("ssg_eight", "오류");
                    away_player9 = sharedPreferences.getString("ssg_nine", "오류");
                    away_pitcher = sharedPreferences.getString("ssg_one_pit", "오류");
                    away_catcher = sharedPreferences.getString("ssg_catcher", "오류");
                    away_firstbase = sharedPreferences.getString("ssg_firstbase", "오류");
                    away_secondbase = sharedPreferences.getString("ssg_secondbase", "오류");
                    away_thirdbase = sharedPreferences.getString("ssg_thirdbase", "오류");
                    away_shortstop = sharedPreferences.getString("ssg_shortstop", "오류");
                    away_leftfielder = sharedPreferences.getString("ssg_leftfielder", "오류");
                    away_centerfielder = sharedPreferences.getString("ssg_centerfielder", "오류");
                    away_rightfielder = sharedPreferences.getString("ssg_rightfielder", "오류");
                }
                if(choice_away.equals("롯데")) {
                    away_player1 = sharedPreferences.getString("lotte_one", "오류");
                    away_player2 = sharedPreferences.getString("lotte_two", "오류");
                    away_player3 = sharedPreferences.getString("lotte_three", "오류");
                    away_player4 = sharedPreferences.getString("lotte_four", "오류");
                    away_player5 = sharedPreferences.getString("lotte_five", "오류");
                    away_player6 = sharedPreferences.getString("lotte_six", "오류");
                    away_player7 = sharedPreferences.getString("lotte_seven", "오류");
                    away_player8 = sharedPreferences.getString("lotte_eight", "오류");
                    away_player9 = sharedPreferences.getString("lotte_nine", "오류");
                    away_pitcher = sharedPreferences.getString("lotte_one_pit", "오류");
                    away_catcher = sharedPreferences.getString("lotte_catcher", "오류");
                    away_firstbase = sharedPreferences.getString("lotte_firstbase", "오류");
                    away_secondbase = sharedPreferences.getString("lotte_secondbase", "오류");
                    away_thirdbase = sharedPreferences.getString("lotte_thirdbase", "오류");
                    away_shortstop = sharedPreferences.getString("lotte_shortstop", "오류");
                    away_leftfielder = sharedPreferences.getString("lotte_leftfielder", "오류");
                    away_centerfielder = sharedPreferences.getString("lotte_centerfielder", "오류");
                    away_rightfielder = sharedPreferences.getString("lotte_rightfielder", "오류");
                }
                if(choice_away.equals("KIA")) {
                    away_player1 = sharedPreferences.getString("kia_one", "오류");
                    away_player2 = sharedPreferences.getString("kia_two", "오류");
                    away_player3 = sharedPreferences.getString("kia_three", "오류");
                    away_player4 = sharedPreferences.getString("kia_four", "오류");
                    away_player5 = sharedPreferences.getString("kia_five", "오류");
                    away_player6 = sharedPreferences.getString("kia_six", "오류");
                    away_player7 = sharedPreferences.getString("kia_seven", "오류");
                    away_player8 = sharedPreferences.getString("kia_eight", "오류");
                    away_player9 = sharedPreferences.getString("kia_nine", "오류");
                    away_pitcher = sharedPreferences.getString("kia_one_pit", "오류");
                    away_catcher = sharedPreferences.getString("kia_catcher", "오류");
                    away_firstbase = sharedPreferences.getString("kia_firstbase", "오류");
                    away_secondbase = sharedPreferences.getString("kia_secondbase", "오류");
                    away_thirdbase = sharedPreferences.getString("kia_thirdbase", "오류");
                    away_shortstop = sharedPreferences.getString("kia_shortstop", "오류");
                    away_leftfielder = sharedPreferences.getString("kia_leftfielder", "오류");
                    away_centerfielder = sharedPreferences.getString("kia_centerfielder", "오류");
                    away_rightfielder = sharedPreferences.getString("kia_rightfielder", "오류");
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
                queue5.add(CreateTable_Request_pitcher);


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

package com.example.nowinning;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.nowinning.LoginActivity.UserID;

public class StartSuperList extends AppCompatActivity {
    ArrayAdapter<CharSequence> adteam, adhit1, adhit2, adhit3, adhit4, adhit5, adhit6, adhit7, adhit8, adhit9, adpit, addef0, addef1, addef4, addef3, addef2, addef5, addef6, addef7;

    public static String hanhwa_one = "";
    public static String hanhwa_two = "";
    public static String hanhwa_three = "";
    public static String hanhwa_four = "";
    public static String hanhwa_five = "";
    public static String hanhwa_six = "";
    public static String hanhwa_seven = "";
    public static String hanhwa_eight = "";
    public static String hanhwa_nine = "";

    public static String hanhwa_one_pit = "";
    public static String hanhwa_two_pit = "";
    public static String hanhwa_three_pit = "";

    public static String hanhwa_catcher ="";
    public static String hanhwa_firstbase ="";
    public static String hanhwa_secondbase ="";
    public static String hanhwa_thirdbase ="";
    public static String hanhwa_shortstop ="";
    public static String hanhwa_leftfielder ="";
    public static String hanhwa_centerfielder ="";
    public static String hanhwa_rightfielder ="";


    public static String nexen_one = "";
    public static String nexen_two = "";
    public static String nexen_three = "";
    public static String nexen_four = "";
    public static String nexen_five = "";
    public static String nexen_six = "";
    public static String nexen_seven = "";
    public static String nexen_eight = "";
    public static String nexen_nine = "";

    public static String nexen_one_pit = "";
    public static String nexen_two_pit = "";
    public static String nexen_three_pit = "";

    public static String nexen_catcher ="";
    public static String nexen_firstbase ="";
    public static String nexen_secondbase ="";
    public static String nexen_thirdbase ="";
    public static String nexen_shortstop ="";
    public static String nexen_leftfielder ="";
    public static String nexen_centerfielder ="";
    public static String nexen_rightfielder ="";

    public static String kt_one = "";
    public static String kt_two = "";
    public static String kt_three = "";
    public static String kt_four = "";
    public static String kt_five = "";
    public static String kt_six = "";
    public static String kt_seven = "";
    public static String kt_eight = "";
    public static String kt_nine = "";

    public static String kt_one_pit = "";
    public static String kt_two_pit = "";
    public static String kt_three_pit = "";

    public static String kt_catcher ="";
    public static String kt_firstbase ="";
    public static String kt_secondbase ="";
    public static String kt_thirdbase ="";
    public static String kt_shortstop ="";
    public static String kt_leftfielder ="";
    public static String kt_centerfielder ="";
    public static String kt_rightfielder ="";

    public static String samsung_one = "";
    public static String samsung_two = "";
    public static String samsung_three = "";
    public static String samsung_four = "";
    public static String samsung_five = "";
    public static String samsung_six = "";
    public static String samsung_seven = "";
    public static String samsung_eight = "";
    public static String samsung_nine = "";

    public static String samsung_one_pit = "";
    public static String samsung_two_pit = "";
    public static String samsung_three_pit = "";

    public static String samsung_catcher ="";
    public static String samsung_firstbase ="";
    public static String samsung_secondbase ="";
    public static String samsung_thirdbase ="";
    public static String samsung_shortstop ="";
    public static String samsung_leftfielder ="";
    public static String samsung_centerfielder ="";
    public static String samsung_rightfielder ="";

    public static String lg_one = "";
    public static String lg_two = "";
    public static String lg_three = "";
    public static String lg_four = "";
    public static String lg_five = "";
    public static String lg_six = "";
    public static String lg_seven = "";
    public static String lg_eight = "";
    public static String lg_nine = "";

    public static String lg_one_pit = "";
    public static String lg_two_pit = "";
    public static String lg_three_pit = "";

    public static String lg_catcher ="";
    public static String lg_firstbase ="";
    public static String lg_secondbase ="";
    public static String lg_thirdbase ="";
    public static String lg_shortstop ="";
    public static String lg_leftfielder ="";
    public static String lg_centerfielder ="";
    public static String lg_rightfielder ="";

    public static String nc_one = "";
    public static String nc_two = "";
    public static String nc_three = "";
    public static String nc_four = "";
    public static String nc_five = "";
    public static String nc_six = "";
    public static String nc_seven = "";
    public static String nc_eight = "";
    public static String nc_nine = "";

    public static String nc_one_pit = "";
    public static String nc_two_pit = "";
    public static String nc_three_pit = "";

    public static String nc_catcher ="";
    public static String nc_firstbase ="";
    public static String nc_secondbase ="";
    public static String nc_thirdbase ="";
    public static String nc_shortstop ="";
    public static String nc_leftfielder ="";
    public static String nc_centerfielder ="";
    public static String nc_rightfielder ="";

    public static String dusan_one = "";
    public static String dusan_two = "";
    public static String dusan_three = "";
    public static String dusan_four = "";
    public static String dusan_five = "";
    public static String dusan_six = "";
    public static String dusan_seven = "";
    public static String dusan_eight = "";
    public static String dusan_nine = "";

    public static String dusan_one_pit = "";
    public static String dusan_two_pit = "";
    public static String dusan_three_pit = "";

    public static String dusan_catcher ="";
    public static String dusan_firstbase ="";
    public static String dusan_secondbase ="";
    public static String dusan_thirdbase ="";
    public static String dusan_shortstop ="";
    public static String dusan_leftfielder ="";
    public static String dusan_centerfielder ="";
    public static String dusan_rightfielder ="";

    public static String ssg_one = "";
    public static String ssg_two = "";
    public static String ssg_three = "";
    public static String ssg_four = "";
    public static String ssg_five = "";
    public static String ssg_six = "";
    public static String ssg_seven = "";
    public static String ssg_eight = "";
    public static String ssg_nine = "";

    public static String ssg_one_pit = "";
    public static String ssg_two_pit = "";
    public static String ssg_three_pit = "";

    public static String ssg_catcher ="";
    public static String ssg_firstbase ="";
    public static String ssg_secondbase ="";
    public static String ssg_thirdbase ="";
    public static String ssg_shortstop ="";
    public static String ssg_leftfielder ="";
    public static String ssg_centerfielder ="";
    public static String ssg_rightfielder ="";

    public static String lotte_one = "";
    public static String lotte_two = "";
    public static String lotte_three = "";
    public static String lotte_four = "";
    public static String lotte_five = "";
    public static String lotte_six = "";
    public static String lotte_seven = "";
    public static String lotte_eight = "";
    public static String lotte_nine = "";

    public static String lotte_one_pit = "";
    public static String lotte_two_pit = "";
    public static String lotte_three_pit = "";

    public static String lotte_catcher ="";
    public static String lotte_firstbase ="";
    public static String lotte_secondbase ="";
    public static String lotte_thirdbase ="";
    public static String lotte_shortstop ="";
    public static String lotte_leftfielder ="";
    public static String lotte_centerfielder ="";
    public static String lotte_rightfielder ="";

    public static String kia_one = "";
    public static String kia_two = "";
    public static String kia_three = "";
    public static String kia_four = "";
    public static String kia_five = "";
    public static String kia_six = "";
    public static String kia_seven = "";
    public static String kia_eight = "";
    public static String kia_nine = "";

    public static String kia_one_pit = "";
    public static String kia_two_pit = "";
    public static String kia_three_pit = "";

    public static String kia_catcher ="";
    public static String kia_firstbase ="";
    public static String kia_secondbase ="";
    public static String kia_thirdbase ="";
    public static String kia_shortstop ="";
    public static String kia_leftfielder ="";
    public static String kia_centerfielder ="";
    public static String kia_rightfielder ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_superlinup);

        Button finish = (Button) findViewById(R.id.finish_button);
        Button home = (Button) findViewById(R.id.home_button);
        Button away = (Button) findViewById(R.id.away_button);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartSuperList.this, StarttSuperList_home.class);
                startActivity(intent); //계정 조건에 따라 분기점이 필요함(감독, 선수, 기록자)

            }
        });

        away.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartSuperList.this, StarttSuperList_away.class);
                startActivity(intent); //계정 조건에 따라 분기점이 필요함(감독, 선수, 기록자)

            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartSuperList.this, StartRecorder.class);
                startActivity(intent); //계정 조건에 따라 분기점이 필요함(감독, 선수, 기록자)
            }
        });
    }

}



package com.example.nowinning;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;

import static com.example.nowinning.LoginActivity.UserID;

public class StartList extends AppCompatActivity {
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
        setContentView(R.layout.activity_linup);

        Button finish = (Button) findViewById(R.id.finish_button);
        Button teamname = (Button)findViewById(R.id.team_button);
        final Spinner team_spin = (Spinner) findViewById(R.id.teamchoice_spinner);
        final Spinner hitter1 = (Spinner) findViewById(R.id.hitter_1_spinner);
        final Spinner hitter2 = (Spinner) findViewById(R.id.hitter_2_spinner);
        final Spinner hitter3 = (Spinner) findViewById(R.id.hitter_3_spinner);
        final Spinner hitter4 = (Spinner) findViewById(R.id.hitter_4_spinner);
        final Spinner hitter5 = (Spinner) findViewById(R.id.hitter_5_spinner);
        final Spinner hitter6 = (Spinner) findViewById(R.id.hitter_6_spinner);
        final Spinner hitter7 = (Spinner) findViewById(R.id.hitter_7_spinner);
        final Spinner hitter8 = (Spinner) findViewById(R.id.hitter_8_spinner);
        final Spinner hitter9 = (Spinner) findViewById(R.id.hitter_9_spinner);

        final Spinner pitcher = (Spinner) findViewById(R.id.pitcher_spinner);

        final Spinner def0 = (Spinner) findViewById(R.id.catcher_spinner);
        final Spinner def1 = (Spinner) findViewById(R.id.firstbaseman_spinner);
        final Spinner def4 = (Spinner) findViewById(R.id.secondbaseman_spinner);
        final Spinner def3 = (Spinner) findViewById(R.id.thirdbaseman_spinner);
        final Spinner def2 = (Spinner) findViewById(R.id.shortstop_spinner);
        final Spinner def5 = (Spinner) findViewById(R.id.leftfielder_spinner);
        final Spinner def6 = (Spinner) findViewById(R.id.centerfielder_spinner);
        final Spinner def7 = (Spinner) findViewById(R.id.rightfielder_spinner);



        SharedPreferences sharedPreferences = getSharedPreferences("save", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if (UserID.equals("direchan")) {
            teamname.setText("한화");
            adhit1 = ArrayAdapter.createFromResource(StartList.this, R.array.hanhwa_player, android.R.layout.simple_spinner_dropdown_item);
            adhit1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter1.setAdapter(adhit1);
            hitter1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    hanhwa_one = hitter1.getSelectedItem().toString();
                    editor.putString("hanhwa_one", hanhwa_one);
                    editor.commit();
                }


                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit2 = ArrayAdapter.createFromResource(StartList.this, R.array.hanhwa_player, android.R.layout.simple_spinner_dropdown_item);
            adhit2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter2.setAdapter(adhit2);
            hitter2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    hanhwa_two = hitter2.getSelectedItem().toString();
                    editor.putString("hanhwa_two", hanhwa_two);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit3 = ArrayAdapter.createFromResource(StartList.this, R.array.hanhwa_player, android.R.layout.simple_spinner_dropdown_item);
            adhit3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter3.setAdapter(adhit3);
            hitter3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    hanhwa_three = hitter3.getSelectedItem().toString();
                    editor.putString("hanhwa_three", hanhwa_three);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit4 = ArrayAdapter.createFromResource(StartList.this, R.array.hanhwa_player, android.R.layout.simple_spinner_dropdown_item);
            adhit4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter4.setAdapter(adhit4);
            hitter4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    hanhwa_four = hitter4.getSelectedItem().toString();
                    editor.putString("hanhwa_four", hanhwa_four);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit5 = ArrayAdapter.createFromResource(StartList.this, R.array.hanhwa_player, android.R.layout.simple_spinner_dropdown_item);
            adhit5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter5.setAdapter(adhit5);
            hitter5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    hanhwa_five = hitter5.getSelectedItem().toString();
                    editor.putString("hanhwa_five", hanhwa_five);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit6 = ArrayAdapter.createFromResource(StartList.this, R.array.hanhwa_player, android.R.layout.simple_spinner_dropdown_item);
            adhit6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter6.setAdapter(adhit6);
            hitter6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    hanhwa_six = hitter6.getSelectedItem().toString();
                    editor.putString("hanhwa_six", hanhwa_six);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit7 = ArrayAdapter.createFromResource(StartList.this, R.array.hanhwa_player, android.R.layout.simple_spinner_dropdown_item);
            adhit7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter7.setAdapter(adhit7);
            hitter7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    hanhwa_seven = hitter7.getSelectedItem().toString();
                    editor.putString("hanhwa_seven", hanhwa_seven);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit8 = ArrayAdapter.createFromResource(StartList.this, R.array.hanhwa_player, android.R.layout.simple_spinner_dropdown_item);
            adhit8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter8.setAdapter(adhit8);
            hitter8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    hanhwa_eight = hitter8.getSelectedItem().toString();
                    editor.putString("hanhwa_eight", hanhwa_eight);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit9 = ArrayAdapter.createFromResource(StartList.this, R.array.hanhwa_player, android.R.layout.simple_spinner_dropdown_item);
            adhit9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter9.setAdapter(adhit9);
            hitter9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    hanhwa_nine = hitter9.getSelectedItem().toString();
                    editor.putString("hanhwa_nine", hanhwa_nine);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            adpit = ArrayAdapter.createFromResource(StartList.this, R.array.hanhwa_player_pit, android.R.layout.simple_spinner_dropdown_item);
            adpit.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            pitcher.setAdapter(adpit);
            pitcher.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    hanhwa_one_pit = pitcher.getSelectedItem().toString();
                    editor.putString("hanhwa_one_pit", hanhwa_one_pit);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef0 = ArrayAdapter.createFromResource(StartList.this, R.array.hanhwa_player, android.R.layout.simple_spinner_dropdown_item);
            addef0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def0.setAdapter(addef0);
            def0.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    hanhwa_catcher = def0.getSelectedItem().toString();
                    editor.putString("hanhwa_catcher", hanhwa_catcher);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef1 = ArrayAdapter.createFromResource(StartList.this, R.array.hanhwa_player, android.R.layout.simple_spinner_dropdown_item);
            addef1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def1.setAdapter(addef1);
            def1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    hanhwa_firstbase = def1.getSelectedItem().toString();
                    editor.putString("hanhwa_firstbase", hanhwa_firstbase);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef4 = ArrayAdapter.createFromResource(StartList.this, R.array.hanhwa_player, android.R.layout.simple_spinner_dropdown_item);
            addef4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def4.setAdapter(addef4);
            def4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    hanhwa_secondbase = def4.getSelectedItem().toString();
                    editor.putString("hanhwa_secondbase", hanhwa_secondbase);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef3 = ArrayAdapter.createFromResource(StartList.this, R.array.hanhwa_player, android.R.layout.simple_spinner_dropdown_item);
            addef3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def3.setAdapter(addef3);
            def3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    hanhwa_thirdbase = def3.getSelectedItem().toString();
                    editor.putString("hanhwa_thirdbase", hanhwa_thirdbase);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef2 = ArrayAdapter.createFromResource(StartList.this, R.array.hanhwa_player, android.R.layout.simple_spinner_dropdown_item);
            addef2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def2.setAdapter(addef2);
            def2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    hanhwa_shortstop = def2.getSelectedItem().toString();
                    editor.putString("hanhwa_shortstop", hanhwa_shortstop);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef5 = ArrayAdapter.createFromResource(StartList.this, R.array.hanhwa_player, android.R.layout.simple_spinner_dropdown_item);
            addef5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def5.setAdapter(addef5);
            def5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    hanhwa_leftfielder = def5.getSelectedItem().toString();
                    editor.putString("hanhwa_leftfielder", hanhwa_leftfielder);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef6 = ArrayAdapter.createFromResource(StartList.this, R.array.hanhwa_player, android.R.layout.simple_spinner_dropdown_item);
            addef6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def6.setAdapter(addef6);
            def6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    hanhwa_centerfielder = def6.getSelectedItem().toString();
                    editor.putString("hanhwa_centerfielder", hanhwa_centerfielder);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef7 = ArrayAdapter.createFromResource(StartList.this, R.array.hanhwa_player, android.R.layout.simple_spinner_dropdown_item);
            addef7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def7.setAdapter(addef7);
            def7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    hanhwa_rightfielder = def7.getSelectedItem().toString();
                    editor.putString("hanhwa_rightfielder", hanhwa_rightfielder);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });






        }
        if (UserID.equals("direcnex")) {
            teamname.setText("넥센");
            adhit1 = ArrayAdapter.createFromResource(StartList.this, R.array.nexen_player, android.R.layout.simple_spinner_dropdown_item);
            adhit1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter1.setAdapter(adhit1);
            hitter1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    nexen_one = hitter1.getSelectedItem().toString();
                    editor.putString("nexen_one", nexen_one);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit2 = ArrayAdapter.createFromResource(StartList.this, R.array.nexen_player, android.R.layout.simple_spinner_dropdown_item);
            adhit2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter2.setAdapter(adhit2);
            hitter2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    nexen_two = hitter2.getSelectedItem().toString();
                    editor.putString("nexen_two", nexen_two);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit3 = ArrayAdapter.createFromResource(StartList.this, R.array.nexen_player, android.R.layout.simple_spinner_dropdown_item);
            adhit3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter3.setAdapter(adhit3);
            hitter3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    nexen_three = hitter3.getSelectedItem().toString();
                    editor.putString("nexen_three", nexen_three);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit4 = ArrayAdapter.createFromResource(StartList.this, R.array.nexen_player, android.R.layout.simple_spinner_dropdown_item);
            adhit4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter4.setAdapter(adhit4);
            hitter4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    nexen_four = hitter4.getSelectedItem().toString();
                    editor.putString("nexen_four", nexen_four);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit5 = ArrayAdapter.createFromResource(StartList.this, R.array.nexen_player, android.R.layout.simple_spinner_dropdown_item);
            adhit5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter5.setAdapter(adhit5);
            hitter5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    nexen_five = hitter5.getSelectedItem().toString();
                    editor.putString("nexen_five", nexen_five);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit6 = ArrayAdapter.createFromResource(StartList.this, R.array.nexen_player, android.R.layout.simple_spinner_dropdown_item);
            adhit6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter6.setAdapter(adhit6);
            hitter6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    nexen_six = hitter6.getSelectedItem().toString();
                    editor.putString("nexen_six", nexen_six);
                    editor.commit();

                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit7 = ArrayAdapter.createFromResource(StartList.this, R.array.nexen_player, android.R.layout.simple_spinner_dropdown_item);
            adhit7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter7.setAdapter(adhit7);
            hitter7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    nexen_seven = hitter7.getSelectedItem().toString();
                    editor.putString("nexen_seven", nexen_seven);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit8 = ArrayAdapter.createFromResource(StartList.this, R.array.nexen_player, android.R.layout.simple_spinner_dropdown_item);
            adhit8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter8.setAdapter(adhit8);
            hitter8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    nexen_eight = hitter8.getSelectedItem().toString();
                    editor.putString("nexen_eight", nexen_eight);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit9 = ArrayAdapter.createFromResource(StartList.this, R.array.nexen_player, android.R.layout.simple_spinner_dropdown_item);
            adhit9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter9.setAdapter(adhit9);
            hitter9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    nexen_nine = hitter9.getSelectedItem().toString();
                    editor.putString("nexen_nine", nexen_nine);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            adpit = ArrayAdapter.createFromResource(StartList.this, R.array.nexen_player_pit, android.R.layout.simple_spinner_dropdown_item);
            adpit.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            pitcher.setAdapter(adpit);
            pitcher.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    nexen_one_pit = pitcher.getSelectedItem().toString();
                    editor.putString("nexen_one_pit", nexen_one_pit);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef0 = ArrayAdapter.createFromResource(StartList.this, R.array.nexen_player, android.R.layout.simple_spinner_dropdown_item);
            addef0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def0.setAdapter(addef0);
            def0.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    nexen_catcher = def0.getSelectedItem().toString();
                    editor.putString("nexen_catcher", nexen_catcher);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef1 = ArrayAdapter.createFromResource(StartList.this, R.array.nexen_player, android.R.layout.simple_spinner_dropdown_item);
            addef1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def1.setAdapter(addef1);
            def1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    nexen_firstbase = def1.getSelectedItem().toString();
                    editor.putString("nexen_firstbase", nexen_firstbase);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef4 = ArrayAdapter.createFromResource(StartList.this, R.array.nexen_player, android.R.layout.simple_spinner_dropdown_item);
            addef4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def4.setAdapter(addef4);
            def4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    nexen_secondbase = def4.getSelectedItem().toString();
                    editor.putString("nexen_secondbase", nexen_secondbase);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef3 = ArrayAdapter.createFromResource(StartList.this, R.array.nexen_player, android.R.layout.simple_spinner_dropdown_item);
            addef3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def3.setAdapter(addef3);
            def3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    nexen_thirdbase = def3.getSelectedItem().toString();
                    editor.putString("nexen_thirdbase", nexen_thirdbase);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef2 = ArrayAdapter.createFromResource(StartList.this, R.array.nexen_player, android.R.layout.simple_spinner_dropdown_item);
            addef2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def2.setAdapter(addef2);
            def2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    nexen_shortstop = def2.getSelectedItem().toString();
                    editor.putString("nexen_shortstop", nexen_shortstop);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef5 = ArrayAdapter.createFromResource(StartList.this, R.array.nexen_player, android.R.layout.simple_spinner_dropdown_item);
            addef5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def5.setAdapter(addef5);
            def5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    nexen_leftfielder = def5.getSelectedItem().toString();
                    editor.putString("nexen_leftfielder", nexen_leftfielder);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef6 = ArrayAdapter.createFromResource(StartList.this, R.array.nexen_player, android.R.layout.simple_spinner_dropdown_item);
            addef6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def6.setAdapter(addef6);
            def6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    nexen_centerfielder = def6.getSelectedItem().toString();
                    editor.putString("nexen_centerfielder", nexen_centerfielder);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef7 = ArrayAdapter.createFromResource(StartList.this, R.array.nexen_player, android.R.layout.simple_spinner_dropdown_item);
            addef7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def7.setAdapter(addef7);
            def7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    nexen_rightfielder = def7.getSelectedItem().toString();
                    editor.putString("nexen_rightfielder", nexen_rightfielder);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

        }
        if (UserID.equals("direckt")) {
            teamname.setText("KT");
            adhit1 = ArrayAdapter.createFromResource(StartList.this, R.array.kt_player, android.R.layout.simple_spinner_dropdown_item);
            adhit1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter1.setAdapter(adhit1);
            hitter1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    kt_one = hitter1.getSelectedItem().toString();
                    editor.putString("kt_one", kt_one);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit2 = ArrayAdapter.createFromResource(StartList.this, R.array.kt_player, android.R.layout.simple_spinner_dropdown_item);
            adhit2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter2.setAdapter(adhit2);
            hitter2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    kt_two = hitter2.getSelectedItem().toString();
                    editor.putString("kt_two", kt_two);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit3 = ArrayAdapter.createFromResource(StartList.this, R.array.kt_player, android.R.layout.simple_spinner_dropdown_item);
            adhit3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter3.setAdapter(adhit3);
            hitter3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    kt_three = hitter3.getSelectedItem().toString();
                    editor.putString("kt_three", kt_three);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit4 = ArrayAdapter.createFromResource(StartList.this, R.array.kt_player, android.R.layout.simple_spinner_dropdown_item);
            adhit4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter4.setAdapter(adhit4);
            hitter4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    kt_four = hitter4.getSelectedItem().toString();
                    editor.putString("kt_four", kt_four);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit5 = ArrayAdapter.createFromResource(StartList.this, R.array.kt_player, android.R.layout.simple_spinner_dropdown_item);
            adhit5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter5.setAdapter(adhit5);
            hitter5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    kt_five = hitter5.getSelectedItem().toString();
                    editor.putString("kt_five", kt_five);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit6 = ArrayAdapter.createFromResource(StartList.this, R.array.kt_player, android.R.layout.simple_spinner_dropdown_item);
            adhit6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter6.setAdapter(adhit6);
            hitter6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    kt_six = hitter6.getSelectedItem().toString();
                    editor.putString("kt_six", kt_six);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit7 = ArrayAdapter.createFromResource(StartList.this, R.array.kt_player, android.R.layout.simple_spinner_dropdown_item);
            adhit7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter7.setAdapter(adhit7);
            hitter7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    kt_seven = hitter7.getSelectedItem().toString();
                    editor.putString("kt_seven", kt_seven);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit8 = ArrayAdapter.createFromResource(StartList.this, R.array.kt_player, android.R.layout.simple_spinner_dropdown_item);
            adhit8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter8.setAdapter(adhit8);
            hitter8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    kt_eight = hitter8.getSelectedItem().toString();
                    editor.putString("kt_eight", kt_eight);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit9 = ArrayAdapter.createFromResource(StartList.this, R.array.kt_player, android.R.layout.simple_spinner_dropdown_item);
            adhit9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter9.setAdapter(adhit9);
            hitter9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    kt_nine = hitter9.getSelectedItem().toString();
                    editor.putString("kt_nine", kt_nine);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            adpit = ArrayAdapter.createFromResource(StartList.this, R.array.kt_player_pit, android.R.layout.simple_spinner_dropdown_item);
            adpit.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            pitcher.setAdapter(adpit);
            pitcher.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    kt_one_pit = pitcher.getSelectedItem().toString();
                    editor.putString("kt_one_pit", kt_one_pit);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef0 = ArrayAdapter.createFromResource(StartList.this, R.array.kt_player, android.R.layout.simple_spinner_dropdown_item);
            addef0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def0.setAdapter(addef0);
            def0.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    kt_catcher = def0.getSelectedItem().toString();
                    editor.putString("kt_catcher", kt_catcher);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef1 = ArrayAdapter.createFromResource(StartList.this, R.array.kt_player, android.R.layout.simple_spinner_dropdown_item);
            addef1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def1.setAdapter(addef1);
            def1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    kt_firstbase = def1.getSelectedItem().toString();
                    editor.putString("kt_firstbase", kt_firstbase);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef4 = ArrayAdapter.createFromResource(StartList.this, R.array.kt_player, android.R.layout.simple_spinner_dropdown_item);
            addef4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def4.setAdapter(addef4);
            def4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    kt_secondbase = def4.getSelectedItem().toString();
                    editor.putString("kt_secondbase", kt_secondbase);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef3 = ArrayAdapter.createFromResource(StartList.this, R.array.kt_player, android.R.layout.simple_spinner_dropdown_item);
            addef3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def3.setAdapter(addef3);
            def3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    kt_thirdbase = def3.getSelectedItem().toString();
                    editor.putString("kt_thirdbase", kt_thirdbase);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef2 = ArrayAdapter.createFromResource(StartList.this, R.array.kt_player, android.R.layout.simple_spinner_dropdown_item);
            addef2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def2.setAdapter(addef2);
            def2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    kt_shortstop = def2.getSelectedItem().toString();
                    editor.putString("kt_shortstop", kt_shortstop);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef5 = ArrayAdapter.createFromResource(StartList.this, R.array.kt_player, android.R.layout.simple_spinner_dropdown_item);
            addef5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def5.setAdapter(addef5);
            def5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    kt_leftfielder = def5.getSelectedItem().toString();
                    editor.putString("kt_leftfielder", kt_leftfielder);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef6 = ArrayAdapter.createFromResource(StartList.this, R.array.kt_player, android.R.layout.simple_spinner_dropdown_item);
            addef6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def6.setAdapter(addef6);
            def6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    kt_centerfielder = def6.getSelectedItem().toString();
                    editor.putString("kt_centerfielder", kt_centerfielder);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef7 = ArrayAdapter.createFromResource(StartList.this, R.array.kt_player, android.R.layout.simple_spinner_dropdown_item);
            addef7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def7.setAdapter(addef7);
            def7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    kt_rightfielder = def7.getSelectedItem().toString();
                    editor.putString("kt_rightfielder", kt_rightfielder);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

        }
        if (UserID.equals("direcsam")) {
            teamname.setText("삼성");
            adhit1 = ArrayAdapter.createFromResource(StartList.this, R.array.samsung_player, android.R.layout.simple_spinner_dropdown_item);
            adhit1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter1.setAdapter(adhit1);
            hitter1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    samsung_one = hitter1.getSelectedItem().toString();
                    editor.putString("samsung_one", samsung_one);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit2 = ArrayAdapter.createFromResource(StartList.this, R.array.samsung_player, android.R.layout.simple_spinner_dropdown_item);
            adhit2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter2.setAdapter(adhit2);
            hitter2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    samsung_two = hitter2.getSelectedItem().toString();
                    editor.putString("samsung_two", samsung_two);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit3 = ArrayAdapter.createFromResource(StartList.this, R.array.samsung_player, android.R.layout.simple_spinner_dropdown_item);
            adhit3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter3.setAdapter(adhit3);
            hitter3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    samsung_three = hitter3.getSelectedItem().toString();
                    editor.putString("samsung_three", samsung_three);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit4 = ArrayAdapter.createFromResource(StartList.this, R.array.samsung_player, android.R.layout.simple_spinner_dropdown_item);
            adhit4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter4.setAdapter(adhit4);
            hitter4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    samsung_four = hitter4.getSelectedItem().toString();
                    editor.putString("samsung_four", samsung_four);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit5 = ArrayAdapter.createFromResource(StartList.this, R.array.samsung_player, android.R.layout.simple_spinner_dropdown_item);
            adhit5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter5.setAdapter(adhit5);
            hitter5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    samsung_five = hitter5.getSelectedItem().toString();
                    editor.putString("samsung_five", samsung_five);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit6 = ArrayAdapter.createFromResource(StartList.this, R.array.samsung_player, android.R.layout.simple_spinner_dropdown_item);
            adhit6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter6.setAdapter(adhit6);
            hitter6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    samsung_six = hitter6.getSelectedItem().toString();
                    editor.putString("samsung_six", samsung_six);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit7 = ArrayAdapter.createFromResource(StartList.this, R.array.samsung_player, android.R.layout.simple_spinner_dropdown_item);
            adhit7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter7.setAdapter(adhit7);
            hitter7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    samsung_seven = hitter7.getSelectedItem().toString();
                    editor.putString("samsung_seven", samsung_seven);
                    editor.commit();

                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit8 = ArrayAdapter.createFromResource(StartList.this, R.array.samsung_player, android.R.layout.simple_spinner_dropdown_item);
            adhit8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter8.setAdapter(adhit8);
            hitter8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    samsung_eight = hitter8.getSelectedItem().toString();
                    editor.putString("samsung_eight", samsung_eight);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit9 = ArrayAdapter.createFromResource(StartList.this, R.array.samsung_player, android.R.layout.simple_spinner_dropdown_item);
            adhit9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter9.setAdapter(adhit9);
            hitter9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    samsung_nine = hitter9.getSelectedItem().toString();
                    editor.putString("samsung_nine", samsung_nine);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            adpit = ArrayAdapter.createFromResource(StartList.this, R.array.samsung_player_pit, android.R.layout.simple_spinner_dropdown_item);
            adpit.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            pitcher.setAdapter(adpit);
            pitcher.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    samsung_one_pit = pitcher.getSelectedItem().toString();
                    editor.putString("samsung_one_pit", samsung_one_pit);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef0 = ArrayAdapter.createFromResource(StartList.this, R.array.samsung_player, android.R.layout.simple_spinner_dropdown_item);
            addef0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def0.setAdapter(addef0);
            def0.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    samsung_catcher = def0.getSelectedItem().toString();
                    editor.putString("samsung_catcher", samsung_catcher);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef1 = ArrayAdapter.createFromResource(StartList.this, R.array.samsung_player, android.R.layout.simple_spinner_dropdown_item);
            addef1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def1.setAdapter(addef1);
            def1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    samsung_firstbase = def1.getSelectedItem().toString();
                    editor.putString("samsung_firstbase", samsung_firstbase);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef4 = ArrayAdapter.createFromResource(StartList.this, R.array.samsung_player, android.R.layout.simple_spinner_dropdown_item);
            addef4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def4.setAdapter(addef4);
            def4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    samsung_secondbase = def4.getSelectedItem().toString();
                    editor.putString("samsung_secondbase", samsung_secondbase);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef3 = ArrayAdapter.createFromResource(StartList.this, R.array.samsung_player, android.R.layout.simple_spinner_dropdown_item);
            addef3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def3.setAdapter(addef3);
            def3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    samsung_thirdbase = def3.getSelectedItem().toString();
                    editor.putString("samsung_thirdbase", samsung_thirdbase);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef2 = ArrayAdapter.createFromResource(StartList.this, R.array.samsung_player, android.R.layout.simple_spinner_dropdown_item);
            addef2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def2.setAdapter(addef2);
            def2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    samsung_shortstop = def2.getSelectedItem().toString();
                    editor.putString("samsung_shortstop", samsung_shortstop);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef5 = ArrayAdapter.createFromResource(StartList.this, R.array.samsung_player, android.R.layout.simple_spinner_dropdown_item);
            addef5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def5.setAdapter(addef5);
            def5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    samsung_leftfielder = def5.getSelectedItem().toString();
                    editor.putString("samsung_leftfielder", samsung_leftfielder);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef6 = ArrayAdapter.createFromResource(StartList.this, R.array.samsung_player, android.R.layout.simple_spinner_dropdown_item);
            addef6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def6.setAdapter(addef6);
            def6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    samsung_centerfielder = def6.getSelectedItem().toString();
                    editor.putString("samsung_centerfielder", samsung_centerfielder);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef7 = ArrayAdapter.createFromResource(StartList.this, R.array.samsung_player, android.R.layout.simple_spinner_dropdown_item);
            addef7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def7.setAdapter(addef7);
            def7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    samsung_rightfielder = def7.getSelectedItem().toString();
                    editor.putString("samsung_rightfielder", samsung_rightfielder);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

        }
        if (UserID.equals("direclg")) {
            teamname.setText("엘지");
            adhit1 = ArrayAdapter.createFromResource(StartList.this, R.array.lg_player, android.R.layout.simple_spinner_dropdown_item);
            adhit1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter1.setAdapter(adhit1);
            hitter1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lg_one = hitter1.getSelectedItem().toString();
                    editor.putString("lg_one", lg_one);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit2 = ArrayAdapter.createFromResource(StartList.this, R.array.lg_player, android.R.layout.simple_spinner_dropdown_item);
            adhit2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter2.setAdapter(adhit2);
            hitter2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lg_two = hitter2.getSelectedItem().toString();
                    editor.putString("lg_two", lg_two);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit3 = ArrayAdapter.createFromResource(StartList.this, R.array.lg_player, android.R.layout.simple_spinner_dropdown_item);
            adhit3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter3.setAdapter(adhit3);
            hitter3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lg_three = hitter3.getSelectedItem().toString();
                    editor.putString("lg_three", lg_three);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit4 = ArrayAdapter.createFromResource(StartList.this, R.array.lg_player, android.R.layout.simple_spinner_dropdown_item);
            adhit4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter4.setAdapter(adhit4);
            hitter4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lg_four = hitter4.getSelectedItem().toString();
                    editor.putString("lg_four", lg_four);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit5 = ArrayAdapter.createFromResource(StartList.this, R.array.lg_player, android.R.layout.simple_spinner_dropdown_item);
            adhit5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter5.setAdapter(adhit5);
            hitter5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lg_five = hitter5.getSelectedItem().toString();
                    editor.putString("lg_five", lg_five);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit6 = ArrayAdapter.createFromResource(StartList.this, R.array.lg_player, android.R.layout.simple_spinner_dropdown_item);
            adhit6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter6.setAdapter(adhit6);
            hitter6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lg_six = hitter6.getSelectedItem().toString();
                    editor.putString("lg_six", lg_six);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit7 = ArrayAdapter.createFromResource(StartList.this, R.array.lg_player, android.R.layout.simple_spinner_dropdown_item);
            adhit7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter7.setAdapter(adhit7);
            hitter7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lg_seven = hitter7.getSelectedItem().toString();
                    editor.putString("lg_seven", lg_seven);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit8 = ArrayAdapter.createFromResource(StartList.this, R.array.lg_player, android.R.layout.simple_spinner_dropdown_item);
            adhit8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter8.setAdapter(adhit8);
            hitter8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lg_eight = hitter8.getSelectedItem().toString();
                    editor.putString("lg_eight", lg_eight);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit9 = ArrayAdapter.createFromResource(StartList.this, R.array.lg_player, android.R.layout.simple_spinner_dropdown_item);
            adhit9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter9.setAdapter(adhit9);
            hitter9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lg_nine = hitter9.getSelectedItem().toString();
                    editor.putString("lg_nine", lg_nine);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            adpit = ArrayAdapter.createFromResource(StartList.this, R.array.lg_player_pit, android.R.layout.simple_spinner_dropdown_item);
            adpit.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            pitcher.setAdapter(adpit);
            pitcher.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lg_one_pit = pitcher.getSelectedItem().toString();
                    editor.putString("lg_one_pit", lg_one_pit);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef0 = ArrayAdapter.createFromResource(StartList.this, R.array.lg_player, android.R.layout.simple_spinner_dropdown_item);
            addef0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def0.setAdapter(addef0);
            def0.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lg_catcher = def0.getSelectedItem().toString();
                    editor.putString("lg_catcher", lg_catcher);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef1 = ArrayAdapter.createFromResource(StartList.this, R.array.lg_player, android.R.layout.simple_spinner_dropdown_item);
            addef1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def1.setAdapter(addef1);
            def1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lg_firstbase = def1.getSelectedItem().toString();
                    editor.putString("lg_firstbase", lg_firstbase);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef4 = ArrayAdapter.createFromResource(StartList.this, R.array.lg_player, android.R.layout.simple_spinner_dropdown_item);
            addef4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def4.setAdapter(addef4);
            def4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lg_secondbase = def4.getSelectedItem().toString();
                    editor.putString("lg_secondbase", lg_secondbase);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef3 = ArrayAdapter.createFromResource(StartList.this, R.array.lg_player, android.R.layout.simple_spinner_dropdown_item);
            addef3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def3.setAdapter(addef3);
            def3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lg_thirdbase = def3.getSelectedItem().toString();
                    editor.putString("lg_thirdbase", lg_thirdbase);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef2 = ArrayAdapter.createFromResource(StartList.this, R.array.lg_player, android.R.layout.simple_spinner_dropdown_item);
            addef2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def2.setAdapter(addef2);
            def2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lg_shortstop = def2.getSelectedItem().toString();
                    editor.putString("lg_shortstop", lg_shortstop);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef5 = ArrayAdapter.createFromResource(StartList.this, R.array.lg_player, android.R.layout.simple_spinner_dropdown_item);
            addef5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def5.setAdapter(addef5);
            def5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lg_leftfielder = def5.getSelectedItem().toString();
                    editor.putString("lg_leftfielder", lg_leftfielder);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef6 = ArrayAdapter.createFromResource(StartList.this, R.array.lg_player, android.R.layout.simple_spinner_dropdown_item);
            addef6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def6.setAdapter(addef6);
            def6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lg_centerfielder = def6.getSelectedItem().toString();
                    editor.putString("lg_centerfielder", lg_centerfielder);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef7 = ArrayAdapter.createFromResource(StartList.this, R.array.lg_player, android.R.layout.simple_spinner_dropdown_item);
            addef7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def7.setAdapter(addef7);
            def7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lg_rightfielder = def7.getSelectedItem().toString();
                    editor.putString("lg_rightfielder", lg_rightfielder);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
        }
        if (UserID.equals("direcnc")) {
            teamname.setText("NC");
            adhit1 = ArrayAdapter.createFromResource(StartList.this, R.array.nc_player, android.R.layout.simple_spinner_dropdown_item);
            adhit1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter1.setAdapter(adhit1);
            hitter1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    nc_one = hitter1.getSelectedItem().toString();
                    editor.putString("nc_one", nc_one);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit2 = ArrayAdapter.createFromResource(StartList.this, R.array.nc_player, android.R.layout.simple_spinner_dropdown_item);
            adhit2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter2.setAdapter(adhit2);
            hitter2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    nc_two = hitter2.getSelectedItem().toString();
                    editor.putString("nc_two", nc_two);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit3 = ArrayAdapter.createFromResource(StartList.this, R.array.nc_player, android.R.layout.simple_spinner_dropdown_item);
            adhit3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter3.setAdapter(adhit3);
            hitter3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    nc_three = hitter3.getSelectedItem().toString();
                    editor.putString("nc_three", nc_three);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit4 = ArrayAdapter.createFromResource(StartList.this, R.array.nc_player, android.R.layout.simple_spinner_dropdown_item);
            adhit4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter4.setAdapter(adhit4);
            hitter4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    nc_four = hitter4.getSelectedItem().toString();
                    editor.putString("nc_four", nc_four);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit5 = ArrayAdapter.createFromResource(StartList.this, R.array.nc_player, android.R.layout.simple_spinner_dropdown_item);
            adhit5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter5.setAdapter(adhit5);
            hitter5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    nc_five = hitter5.getSelectedItem().toString();
                    editor.putString("nc_five", nc_five);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit6 = ArrayAdapter.createFromResource(StartList.this, R.array.nc_player, android.R.layout.simple_spinner_dropdown_item);
            adhit6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter6.setAdapter(adhit6);
            hitter6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    nc_six = hitter6.getSelectedItem().toString();
                    editor.putString("nc_six", nc_six);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit7 = ArrayAdapter.createFromResource(StartList.this, R.array.nc_player, android.R.layout.simple_spinner_dropdown_item);
            adhit7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter7.setAdapter(adhit7);
            hitter7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    nc_seven = hitter7.getSelectedItem().toString();
                    editor.putString("nc_seven", nc_seven);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit8 = ArrayAdapter.createFromResource(StartList.this, R.array.nc_player, android.R.layout.simple_spinner_dropdown_item);
            adhit8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter8.setAdapter(adhit8);
            hitter8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    nc_eight = hitter8.getSelectedItem().toString();
                    editor.putString("nc_eight", nc_eight);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit9 = ArrayAdapter.createFromResource(StartList.this, R.array.nc_player, android.R.layout.simple_spinner_dropdown_item);
            adhit9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter9.setAdapter(adhit9);
            hitter9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    nc_nine = hitter9.getSelectedItem().toString();
                    editor.putString("nc_nine", nc_nine);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            adpit = ArrayAdapter.createFromResource(StartList.this, R.array.nc_player_pit, android.R.layout.simple_spinner_dropdown_item);
            adpit.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            pitcher.setAdapter(adpit);
            pitcher.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    nc_one_pit = pitcher.getSelectedItem().toString();
                    editor.putString("nc_one_pit", nc_one_pit);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef0 = ArrayAdapter.createFromResource(StartList.this, R.array.nc_player, android.R.layout.simple_spinner_dropdown_item);
            addef0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def0.setAdapter(addef0);
            def0.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    nc_catcher = def0.getSelectedItem().toString();
                    editor.putString("nc_catcher", nc_catcher);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef1 = ArrayAdapter.createFromResource(StartList.this, R.array.nc_player, android.R.layout.simple_spinner_dropdown_item);
            addef1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def1.setAdapter(addef1);
            def1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    nc_firstbase = def1.getSelectedItem().toString();
                    editor.putString("nc_firstbase", nc_firstbase);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef4 = ArrayAdapter.createFromResource(StartList.this, R.array.nc_player, android.R.layout.simple_spinner_dropdown_item);
            addef4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def4.setAdapter(addef4);
            def4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    nc_secondbase = def4.getSelectedItem().toString();
                    editor.putString("nc_secondbase", nc_secondbase);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef3 = ArrayAdapter.createFromResource(StartList.this, R.array.nc_player, android.R.layout.simple_spinner_dropdown_item);
            addef3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def3.setAdapter(addef3);
            def3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    nc_thirdbase = def3.getSelectedItem().toString();
                    editor.putString("nc_thirdbase", nc_thirdbase);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef2 = ArrayAdapter.createFromResource(StartList.this, R.array.nc_player, android.R.layout.simple_spinner_dropdown_item);
            addef2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def2.setAdapter(addef2);
            def2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    nc_shortstop = def2.getSelectedItem().toString();
                    editor.putString("nc_shortstop", nc_shortstop);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef5 = ArrayAdapter.createFromResource(StartList.this, R.array.nc_player, android.R.layout.simple_spinner_dropdown_item);
            addef5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def5.setAdapter(addef5);
            def5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    nc_leftfielder = def5.getSelectedItem().toString();
                    editor.putString("nc_leftfielder", nc_leftfielder);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef6 = ArrayAdapter.createFromResource(StartList.this, R.array.nc_player, android.R.layout.simple_spinner_dropdown_item);
            addef6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def6.setAdapter(addef6);
            def6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    nc_centerfielder = def6.getSelectedItem().toString();
                    editor.putString("nc_centerfielder", nc_centerfielder);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef7 = ArrayAdapter.createFromResource(StartList.this, R.array.nc_player, android.R.layout.simple_spinner_dropdown_item);
            addef7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def7.setAdapter(addef7);
            def7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    nc_rightfielder = def7.getSelectedItem().toString();
                    editor.putString("nc_rightfielder", nc_rightfielder);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

        }
        if (UserID.equals("direcdu")) {
            teamname.setText("두산");
            adhit1 = ArrayAdapter.createFromResource(StartList.this, R.array.dusan_player, android.R.layout.simple_spinner_dropdown_item);
            adhit1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter1.setAdapter(adhit1);
            hitter1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    dusan_one = hitter1.getSelectedItem().toString();
                    editor.putString("dusan_one", dusan_one);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit2 = ArrayAdapter.createFromResource(StartList.this, R.array.dusan_player, android.R.layout.simple_spinner_dropdown_item);
            adhit2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter2.setAdapter(adhit2);
            hitter2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    dusan_two = hitter2.getSelectedItem().toString();
                    editor.putString("dusan_two", dusan_two);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit3 = ArrayAdapter.createFromResource(StartList.this, R.array.dusan_player, android.R.layout.simple_spinner_dropdown_item);
            adhit3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter3.setAdapter(adhit3);
            hitter3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    dusan_three = hitter3.getSelectedItem().toString();
                    editor.putString("dusan_three", dusan_three);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit4 = ArrayAdapter.createFromResource(StartList.this, R.array.dusan_player, android.R.layout.simple_spinner_dropdown_item);
            adhit4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter4.setAdapter(adhit4);
            hitter4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    dusan_four = hitter4.getSelectedItem().toString();
                    editor.putString("dusan_four", dusan_four);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit5 = ArrayAdapter.createFromResource(StartList.this, R.array.dusan_player, android.R.layout.simple_spinner_dropdown_item);
            adhit5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter5.setAdapter(adhit5);
            hitter5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    dusan_five = hitter5.getSelectedItem().toString();
                    editor.putString("dusan_five", dusan_five);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit6 = ArrayAdapter.createFromResource(StartList.this, R.array.dusan_player, android.R.layout.simple_spinner_dropdown_item);
            adhit6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter6.setAdapter(adhit6);
            hitter6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    dusan_six = hitter6.getSelectedItem().toString();
                    editor.putString("dusan_six", dusan_six);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit7 = ArrayAdapter.createFromResource(StartList.this, R.array.dusan_player, android.R.layout.simple_spinner_dropdown_item);
            adhit7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter7.setAdapter(adhit7);
            hitter7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    dusan_seven = hitter7.getSelectedItem().toString();
                    editor.putString("dusan_seven", dusan_seven);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit8 = ArrayAdapter.createFromResource(StartList.this, R.array.dusan_player, android.R.layout.simple_spinner_dropdown_item);
            adhit8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter8.setAdapter(adhit8);
            hitter8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    dusan_eight = hitter8.getSelectedItem().toString();
                    editor.putString("dusan_eight", dusan_eight);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit9 = ArrayAdapter.createFromResource(StartList.this, R.array.dusan_player, android.R.layout.simple_spinner_dropdown_item);
            adhit9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter9.setAdapter(adhit9);
            hitter9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    dusan_nine = hitter9.getSelectedItem().toString();
                    editor.putString("dusan_nine", dusan_nine);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            adpit = ArrayAdapter.createFromResource(StartList.this, R.array.dusan_player_pit, android.R.layout.simple_spinner_dropdown_item);
            adpit.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            pitcher.setAdapter(adpit);
            pitcher.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    dusan_one_pit = pitcher.getSelectedItem().toString();
                    editor.putString("dusan_one_pit", dusan_one_pit);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef0 = ArrayAdapter.createFromResource(StartList.this, R.array.dusan_player, android.R.layout.simple_spinner_dropdown_item);
            addef0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def0.setAdapter(addef0);
            def0.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    dusan_catcher = def0.getSelectedItem().toString();
                    editor.putString("dusan_catcher", dusan_catcher);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef1 = ArrayAdapter.createFromResource(StartList.this, R.array.dusan_player, android.R.layout.simple_spinner_dropdown_item);
            addef1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def1.setAdapter(addef1);
            def1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    dusan_firstbase = def1.getSelectedItem().toString();
                    editor.putString("dusan_firstbase", dusan_firstbase);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef4 = ArrayAdapter.createFromResource(StartList.this, R.array.dusan_player, android.R.layout.simple_spinner_dropdown_item);
            addef4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def4.setAdapter(addef4);
            def4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    dusan_secondbase = def4.getSelectedItem().toString();
                    editor.putString("dusan_secondbase", dusan_secondbase);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef3 = ArrayAdapter.createFromResource(StartList.this, R.array.dusan_player, android.R.layout.simple_spinner_dropdown_item);
            addef3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def3.setAdapter(addef3);
            def3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    dusan_thirdbase = def3.getSelectedItem().toString();
                    editor.putString("dusan_thirdbase", dusan_thirdbase);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef2 = ArrayAdapter.createFromResource(StartList.this, R.array.dusan_player, android.R.layout.simple_spinner_dropdown_item);
            addef2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def2.setAdapter(addef2);
            def2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    dusan_shortstop = def2.getSelectedItem().toString();
                    editor.putString("dusan_shortstop", dusan_shortstop);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef5 = ArrayAdapter.createFromResource(StartList.this, R.array.dusan_player, android.R.layout.simple_spinner_dropdown_item);
            addef5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def5.setAdapter(addef5);
            def5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    dusan_leftfielder = def5.getSelectedItem().toString();
                    editor.putString("dusan_leftfielder", dusan_leftfielder);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef6 = ArrayAdapter.createFromResource(StartList.this, R.array.dusan_player, android.R.layout.simple_spinner_dropdown_item);
            addef6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def6.setAdapter(addef6);
            def6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    dusan_centerfielder = def6.getSelectedItem().toString();
                    editor.putString("dusan_centerfielder", dusan_centerfielder);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef7 = ArrayAdapter.createFromResource(StartList.this, R.array.dusan_player, android.R.layout.simple_spinner_dropdown_item);
            addef7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def7.setAdapter(addef7);
            def7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    dusan_rightfielder = def7.getSelectedItem().toString();
                    editor.putString("dusan_rightfielder", dusan_rightfielder);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

        }
        if (UserID.equals("direcssg")) {
            teamname.setText("SSG");
            adhit1 = ArrayAdapter.createFromResource(StartList.this, R.array.ssg_player, android.R.layout.simple_spinner_dropdown_item);
            adhit1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter1.setAdapter(adhit1);
            hitter1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    ssg_one = hitter1.getSelectedItem().toString();
                    editor.putString("ssg_one", ssg_one);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit2 = ArrayAdapter.createFromResource(StartList.this, R.array.ssg_player, android.R.layout.simple_spinner_dropdown_item);
            adhit2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter2.setAdapter(adhit2);
            hitter2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    ssg_two = hitter2.getSelectedItem().toString();
                    editor.putString("ssg_two", ssg_two);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit3 = ArrayAdapter.createFromResource(StartList.this, R.array.ssg_player, android.R.layout.simple_spinner_dropdown_item);
            adhit3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter3.setAdapter(adhit3);
            hitter3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    ssg_three = hitter3.getSelectedItem().toString();
                    editor.putString("ssg_three", ssg_three);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit4 = ArrayAdapter.createFromResource(StartList.this, R.array.ssg_player, android.R.layout.simple_spinner_dropdown_item);
            adhit4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter4.setAdapter(adhit4);
            hitter4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    ssg_four = hitter4.getSelectedItem().toString();
                    editor.putString("ssg_four", ssg_four);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit5 = ArrayAdapter.createFromResource(StartList.this, R.array.ssg_player, android.R.layout.simple_spinner_dropdown_item);
            adhit5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter5.setAdapter(adhit5);
            hitter5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    ssg_five = hitter5.getSelectedItem().toString();
                    editor.putString("ssg_five", ssg_five);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit6 = ArrayAdapter.createFromResource(StartList.this, R.array.ssg_player, android.R.layout.simple_spinner_dropdown_item);
            adhit6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter6.setAdapter(adhit6);
            hitter6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    ssg_six = hitter6.getSelectedItem().toString();
                    editor.putString("ssg_six", ssg_six);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit7 = ArrayAdapter.createFromResource(StartList.this, R.array.ssg_player, android.R.layout.simple_spinner_dropdown_item);
            adhit7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter7.setAdapter(adhit7);
            hitter7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    ssg_seven = hitter7.getSelectedItem().toString();
                    editor.putString("ssg_seven", ssg_seven);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit8 = ArrayAdapter.createFromResource(StartList.this, R.array.ssg_player, android.R.layout.simple_spinner_dropdown_item);
            adhit8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter8.setAdapter(adhit8);
            hitter8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    ssg_eight = hitter8.getSelectedItem().toString();
                    editor.putString("ssg_eight", ssg_eight);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit9 = ArrayAdapter.createFromResource(StartList.this, R.array.ssg_player, android.R.layout.simple_spinner_dropdown_item);
            adhit9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter9.setAdapter(adhit9);
            hitter9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    ssg_nine = hitter9.getSelectedItem().toString();
                    editor.putString("ssg_nine", ssg_nine);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            adpit = ArrayAdapter.createFromResource(StartList.this, R.array.ssg_player_pit, android.R.layout.simple_spinner_dropdown_item);
            adpit.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            pitcher.setAdapter(adpit);
            pitcher.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    ssg_one_pit = pitcher.getSelectedItem().toString();
                    editor.putString("ssg_one_pit", ssg_one_pit);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef0 = ArrayAdapter.createFromResource(StartList.this, R.array.ssg_player, android.R.layout.simple_spinner_dropdown_item);
            addef0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def0.setAdapter(addef0);
            def0.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    ssg_catcher = def0.getSelectedItem().toString();
                    editor.putString("ssg_catcher", ssg_catcher);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef1 = ArrayAdapter.createFromResource(StartList.this, R.array.ssg_player, android.R.layout.simple_spinner_dropdown_item);
            addef1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def1.setAdapter(addef1);
            def1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    ssg_firstbase = def1.getSelectedItem().toString();
                    editor.putString("ssg_firstbase", ssg_firstbase);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef4 = ArrayAdapter.createFromResource(StartList.this, R.array.ssg_player, android.R.layout.simple_spinner_dropdown_item);
            addef4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def4.setAdapter(addef4);
            def4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    ssg_secondbase = def4.getSelectedItem().toString();
                    editor.putString("ssg_secondbase", ssg_secondbase);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef3 = ArrayAdapter.createFromResource(StartList.this, R.array.ssg_player, android.R.layout.simple_spinner_dropdown_item);
            addef3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def3.setAdapter(addef3);
            def3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    ssg_thirdbase = def3.getSelectedItem().toString();
                    editor.putString("ssg_thirdbase", ssg_thirdbase);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef2 = ArrayAdapter.createFromResource(StartList.this, R.array.ssg_player, android.R.layout.simple_spinner_dropdown_item);
            addef2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def2.setAdapter(addef2);
            def2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    ssg_shortstop = def2.getSelectedItem().toString();
                    editor.putString("ssg_shortstop", ssg_shortstop);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef5 = ArrayAdapter.createFromResource(StartList.this, R.array.ssg_player, android.R.layout.simple_spinner_dropdown_item);
            addef5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def5.setAdapter(addef5);
            def5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    ssg_leftfielder = def5.getSelectedItem().toString();
                    editor.putString("ssg_leftfielder", ssg_leftfielder);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef6 = ArrayAdapter.createFromResource(StartList.this, R.array.ssg_player, android.R.layout.simple_spinner_dropdown_item);
            addef6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def6.setAdapter(addef6);
            def6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    ssg_centerfielder = def6.getSelectedItem().toString();
                    editor.putString("ssg_centerfielder", ssg_centerfielder);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef7 = ArrayAdapter.createFromResource(StartList.this, R.array.ssg_player, android.R.layout.simple_spinner_dropdown_item);
            addef7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def7.setAdapter(addef7);
            def7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    ssg_rightfielder = def7.getSelectedItem().toString();
                    editor.putString("ssg_rightfielder", ssg_rightfielder);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
        }
        if (UserID.equals("direclot")) {
            teamname.setText("롯데");
            adhit1 = ArrayAdapter.createFromResource(StartList.this, R.array.lotte_player, android.R.layout.simple_spinner_dropdown_item);
            adhit1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter1.setAdapter(adhit1);
            hitter1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lotte_one = hitter1.getSelectedItem().toString();
                    editor.putString("lotte_one", lotte_one);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit2 = ArrayAdapter.createFromResource(StartList.this, R.array.lotte_player, android.R.layout.simple_spinner_dropdown_item);
            adhit2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter2.setAdapter(adhit2);
            hitter2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lotte_two = hitter2.getSelectedItem().toString();
                    editor.putString("lotte_two", lotte_two);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit3 = ArrayAdapter.createFromResource(StartList.this, R.array.lotte_player, android.R.layout.simple_spinner_dropdown_item);
            adhit3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter3.setAdapter(adhit3);
            hitter3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lotte_three = hitter3.getSelectedItem().toString();
                    editor.putString("lotte_three", lotte_three);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit4 = ArrayAdapter.createFromResource(StartList.this, R.array.lotte_player, android.R.layout.simple_spinner_dropdown_item);
            adhit4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter4.setAdapter(adhit4);
            hitter4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lotte_four = hitter4.getSelectedItem().toString();
                    editor.putString("lotte_four", lotte_four);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit5 = ArrayAdapter.createFromResource(StartList.this, R.array.lotte_player, android.R.layout.simple_spinner_dropdown_item);
            adhit5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter5.setAdapter(adhit5);
            hitter5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lotte_five = hitter5.getSelectedItem().toString();
                    editor.putString("lotte_five", lotte_five);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit6 = ArrayAdapter.createFromResource(StartList.this, R.array.lotte_player, android.R.layout.simple_spinner_dropdown_item);
            adhit6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter6.setAdapter(adhit6);
            hitter6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lotte_six = hitter6.getSelectedItem().toString();
                    editor.putString("lotte_six", lotte_six);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit7 = ArrayAdapter.createFromResource(StartList.this, R.array.lotte_player, android.R.layout.simple_spinner_dropdown_item);
            adhit7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter7.setAdapter(adhit7);
            hitter7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lotte_seven = hitter7.getSelectedItem().toString();
                    editor.putString("lotte_seven", lotte_seven);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit8 = ArrayAdapter.createFromResource(StartList.this, R.array.lotte_player, android.R.layout.simple_spinner_dropdown_item);
            adhit8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter8.setAdapter(adhit8);
            hitter8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lotte_eight = hitter8.getSelectedItem().toString();
                    editor.putString("lotte_eight", lotte_eight);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit9 = ArrayAdapter.createFromResource(StartList.this, R.array.lotte_player, android.R.layout.simple_spinner_dropdown_item);
            adhit9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter9.setAdapter(adhit9);
            hitter9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lotte_nine = hitter9.getSelectedItem().toString();
                    editor.putString("lotte_nine", lotte_nine);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            adpit = ArrayAdapter.createFromResource(StartList.this, R.array.lotte_player_pit, android.R.layout.simple_spinner_dropdown_item);
            adpit.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            pitcher.setAdapter(adpit);
            pitcher.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lotte_one_pit = pitcher.getSelectedItem().toString();
                    editor.putString("lotte_one_pit", lotte_one_pit);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef0 = ArrayAdapter.createFromResource(StartList.this, R.array.lotte_player, android.R.layout.simple_spinner_dropdown_item);
            addef0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def0.setAdapter(addef0);
            def0.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lotte_catcher = def0.getSelectedItem().toString();
                    editor.putString("lotte_catcher", lotte_catcher);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef1 = ArrayAdapter.createFromResource(StartList.this, R.array.lotte_player, android.R.layout.simple_spinner_dropdown_item);
            addef1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def1.setAdapter(addef1);
            def1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lotte_firstbase = def1.getSelectedItem().toString();
                    editor.putString("lotte_firstbase", lotte_firstbase);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef4 = ArrayAdapter.createFromResource(StartList.this, R.array.lotte_player, android.R.layout.simple_spinner_dropdown_item);
            addef4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def4.setAdapter(addef4);
            def4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lotte_secondbase = def4.getSelectedItem().toString();
                    editor.putString("lotte_secondbase", lotte_secondbase);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef3 = ArrayAdapter.createFromResource(StartList.this, R.array.lotte_player, android.R.layout.simple_spinner_dropdown_item);
            addef3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def3.setAdapter(addef3);
            def3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lotte_thirdbase = def3.getSelectedItem().toString();
                    editor.putString("lotte_thirdbase", lotte_thirdbase);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef2 = ArrayAdapter.createFromResource(StartList.this, R.array.lotte_player, android.R.layout.simple_spinner_dropdown_item);
            addef2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def2.setAdapter(addef2);
            def2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lotte_shortstop = def2.getSelectedItem().toString();
                    editor.putString("lotte_shortstop", lotte_shortstop);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef5 = ArrayAdapter.createFromResource(StartList.this, R.array.lotte_player, android.R.layout.simple_spinner_dropdown_item);
            addef5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def5.setAdapter(addef5);
            def5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lotte_leftfielder = def5.getSelectedItem().toString();
                    editor.putString("lotte_leftfielder", lotte_leftfielder);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef6 = ArrayAdapter.createFromResource(StartList.this, R.array.lotte_player, android.R.layout.simple_spinner_dropdown_item);
            addef6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def6.setAdapter(addef6);
            def6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lotte_centerfielder = def6.getSelectedItem().toString();
                    editor.putString("lotte_centerfielder", lotte_centerfielder);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef7 = ArrayAdapter.createFromResource(StartList.this, R.array.lotte_player, android.R.layout.simple_spinner_dropdown_item);
            addef7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def7.setAdapter(addef7);
            def7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lotte_rightfielder = def7.getSelectedItem().toString();
                    editor.putString("lotte_rightfielder", lotte_rightfielder);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

        }
        if (UserID.equals("direckia")) {
            teamname.setText("KIA");
            adhit1 = ArrayAdapter.createFromResource(StartList.this, R.array.kia_player, android.R.layout.simple_spinner_dropdown_item);
            adhit1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter1.setAdapter(adhit1);
            hitter1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    kia_one = hitter1.getSelectedItem().toString();
                    editor.putString("kia_one", kia_one);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit2 = ArrayAdapter.createFromResource(StartList.this, R.array.kia_player, android.R.layout.simple_spinner_dropdown_item);
            adhit2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter2.setAdapter(adhit2);
            hitter2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    kia_two = hitter2.getSelectedItem().toString();
                    editor.putString("kia_two", kia_two);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit3 = ArrayAdapter.createFromResource(StartList.this, R.array.kia_player, android.R.layout.simple_spinner_dropdown_item);
            adhit3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter3.setAdapter(adhit3);
            hitter3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    kia_three = hitter3.getSelectedItem().toString();
                    editor.putString("kia_three", kia_three);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit4 = ArrayAdapter.createFromResource(StartList.this, R.array.kia_player, android.R.layout.simple_spinner_dropdown_item);
            adhit4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter4.setAdapter(adhit4);
            hitter4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    kia_four = hitter4.getSelectedItem().toString();
                    editor.putString("kia_four", kia_four);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit5 = ArrayAdapter.createFromResource(StartList.this, R.array.kia_player, android.R.layout.simple_spinner_dropdown_item);
            adhit5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter5.setAdapter(adhit5);
            hitter5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    kia_five = hitter5.getSelectedItem().toString();
                    editor.putString("kia_five", kia_five);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit6 = ArrayAdapter.createFromResource(StartList.this, R.array.kia_player, android.R.layout.simple_spinner_dropdown_item);
            adhit6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter6.setAdapter(adhit6);
            hitter6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    kia_six = hitter6.getSelectedItem().toString();
                    editor.putString("kia_six", kia_six);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit7 = ArrayAdapter.createFromResource(StartList.this, R.array.kia_player, android.R.layout.simple_spinner_dropdown_item);
            adhit7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter7.setAdapter(adhit7);
            hitter7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    kia_seven = hitter7.getSelectedItem().toString();
                    editor.putString("kia_seven", kia_seven);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit8 = ArrayAdapter.createFromResource(StartList.this, R.array.kia_player, android.R.layout.simple_spinner_dropdown_item);
            adhit8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter8.setAdapter(adhit8);
            hitter8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    kia_eight = hitter8.getSelectedItem().toString();
                    editor.putString("kia_eight", kia_eight);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            adhit9 = ArrayAdapter.createFromResource(StartList.this, R.array.kia_player, android.R.layout.simple_spinner_dropdown_item);
            adhit9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hitter9.setAdapter(adhit9);
            hitter9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    kia_nine = hitter9.getSelectedItem().toString();
                    editor.putString("kia_nine", kia_nine);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            adpit = ArrayAdapter.createFromResource(StartList.this, R.array.kia_player_pit, android.R.layout.simple_spinner_dropdown_item);
            adpit.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            pitcher.setAdapter(adpit);
            pitcher.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    kia_one_pit = pitcher.getSelectedItem().toString();
                    editor.putString("kia_one_pit", kia_one_pit);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef0 = ArrayAdapter.createFromResource(StartList.this, R.array.kia_player, android.R.layout.simple_spinner_dropdown_item);
            addef0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def0.setAdapter(addef0);
            def0.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    kia_catcher = def0.getSelectedItem().toString();
                    editor.putString("kia_catcher", kia_catcher);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef1 = ArrayAdapter.createFromResource(StartList.this, R.array.kia_player, android.R.layout.simple_spinner_dropdown_item);
            addef1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def1.setAdapter(addef1);
            def1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    kia_firstbase = def1.getSelectedItem().toString();
                    editor.putString("kia_firstbase", kia_firstbase);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef4 = ArrayAdapter.createFromResource(StartList.this, R.array.kia_player, android.R.layout.simple_spinner_dropdown_item);
            addef4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def4.setAdapter(addef4);
            def4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    kia_secondbase = def4.getSelectedItem().toString();
                    editor.putString("kia_secondbase", kia_secondbase);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef3 = ArrayAdapter.createFromResource(StartList.this, R.array.kia_player, android.R.layout.simple_spinner_dropdown_item);
            addef3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def3.setAdapter(addef3);
            def3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    kia_thirdbase = def3.getSelectedItem().toString();
                    editor.putString("kia_thirdbase", kia_thirdbase);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef2 = ArrayAdapter.createFromResource(StartList.this, R.array.kia_player, android.R.layout.simple_spinner_dropdown_item);
            addef2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def2.setAdapter(addef2);
            def2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    kia_shortstop = def2.getSelectedItem().toString();
                    editor.putString("kia_shortstop", kia_shortstop);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef5 = ArrayAdapter.createFromResource(StartList.this, R.array.kia_player, android.R.layout.simple_spinner_dropdown_item);
            addef5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def5.setAdapter(addef5);
            def5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    kia_leftfielder = def5.getSelectedItem().toString();
                    editor.putString("kia_leftfielder", kia_leftfielder);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef6 = ArrayAdapter.createFromResource(StartList.this, R.array.kia_player, android.R.layout.simple_spinner_dropdown_item);
            addef6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def6.setAdapter(addef6);
            def6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    kia_centerfielder = def6.getSelectedItem().toString();
                    editor.putString("kia_centerfielder", kia_centerfielder);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            addef7 = ArrayAdapter.createFromResource(StartList.this, R.array.kia_player, android.R.layout.simple_spinner_dropdown_item);
            addef7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            def7.setAdapter(addef7);
            def7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    kia_rightfielder = def7.getSelectedItem().toString();
                    editor.putString("kia_rightfielder", kia_rightfielder);
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

        }

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartList.this, StartRecorder.class);
                startActivity(intent); //계정 조건에 따라 분기점이 필요함(감독, 선수, 기록자)
            }
        });
    }

}



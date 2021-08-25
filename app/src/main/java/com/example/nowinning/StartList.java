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
    ArrayAdapter<CharSequence> adteam, adhit1, adhit2, adhit3, adhit4, adhit5, adhit6, adhit7, adhit8, adhit9;

    public static String hanhwa_one = "";
    public static String hanhwa_two = "";
    public static String hanhwa_three = "";
    public static String hanhwa_four = "";
    public static String hanhwa_five = "";
    public static String hanhwa_six = "";
    public static String hanhwa_seven = "";
    public static String hanhwa_eight = "";
    public static String hanhwa_nine = "";

    public static String nexen_one = "";
    public static String nexen_two = "";
    public static String nexen_three = "";
    public static String nexen_four = "";
    public static String nexen_five = "";
    public static String nexen_six = "";
    public static String nexen_seven = "";
    public static String nexen_eight = "";
    public static String nexen_nine = "";

    public static String kt_one = "";
    public static String kt_two = "";
    public static String kt_three = "";
    public static String kt_four = "";
    public static String kt_five = "";
    public static String kt_six = "";
    public static String kt_seven = "";
    public static String kt_eight = "";
    public static String kt_nine = "";

    public static String samsung_one = "";
    public static String samsung_two = "";
    public static String samsung_three = "";
    public static String samsung_four = "";
    public static String samsung_five = "";
    public static String samsung_six = "";
    public static String samsung_seven = "";
    public static String samsung_eight = "";
    public static String samsung_nine = "";

    public static String lg_one = "";
    public static String lg_two = "";
    public static String lg_three = "";
    public static String lg_four = "";
    public static String lg_five = "";
    public static String lg_six = "";
    public static String lg_seven = "";
    public static String lg_eight = "";
    public static String lg_nine = "";

    public static String nc_one = "";
    public static String nc_two = "";
    public static String nc_three = "";
    public static String nc_four = "";
    public static String nc_five = "";
    public static String nc_six = "";
    public static String nc_seven = "";
    public static String nc_eight = "";
    public static String nc_nine = "";

    public static String dusan_one = "";
    public static String dusan_two = "";
    public static String dusan_three = "";
    public static String dusan_four = "";
    public static String dusan_five = "";
    public static String dusan_six = "";
    public static String dusan_seven = "";
    public static String dusan_eight = "";
    public static String dusan_nine = "";

    public static String ssg_one = "";
    public static String ssg_two = "";
    public static String ssg_three = "";
    public static String ssg_four = "";
    public static String ssg_five = "";
    public static String ssg_six = "";
    public static String ssg_seven = "";
    public static String ssg_eight = "";
    public static String ssg_nine = "";

    public static String lotte_one = "";
    public static String lotte_two = "";
    public static String lotte_three = "";
    public static String lotte_four = "";
    public static String lotte_five = "";
    public static String lotte_six = "";
    public static String lotte_seven = "";
    public static String lotte_eight = "";
    public static String lotte_nine = "";

    public static String kia_one = "";
    public static String kia_two = "";
    public static String kia_three = "";
    public static String kia_four = "";
    public static String kia_five = "";
    public static String kia_six = "";
    public static String kia_seven = "";
    public static String kia_eight = "";
    public static String kia_nine = "";

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



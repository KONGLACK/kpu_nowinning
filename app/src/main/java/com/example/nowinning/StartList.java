package com.example.nowinning;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;

public class StartList extends AppCompatActivity {
    ArrayAdapter<CharSequence> adteam, adhit1, adhit2, adhit3, adhit4, adhit5, adhit6, adhit7, adhit8, adhit9;

    public static String hanhwa_one="";
    public static String hanhwa_two="";
    public static String hanhwa_three="";
    public static String hanhwa_four="";
    public static String hanhwa_five="";
    public static String hanhwa_six="";
    public static String hanhwa_seven="";
    public static String hanhwa_eight="";
    public static String hanhwa_nine="";

    public static String nexen_one="";
    public static String nexen_two="";
    public static String nexen_three="";
    public static String nexen_four="";
    public static String nexen_five="";
    public static String nexen_six="";
    public static String nexen_seven="";
    public static String nexen_eight="";
    public static String nexen_nine="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linup);

        final Spinner team_spin = (Spinner)findViewById(R.id.team_choice_spinner);
        final Spinner hitter1 = (Spinner)findViewById(R.id.hitter_1_spinner);
        final Spinner hitter2 = (Spinner)findViewById(R.id.hitter_2_spinner);
        final Spinner hitter3 = (Spinner)findViewById(R.id.hitter_3_spinner);
        final Spinner hitter4 = (Spinner)findViewById(R.id.hitter_4_spinner);
        final Spinner hitter5 = (Spinner)findViewById(R.id.hitter_5_spinner);
        final Spinner hitter6 = (Spinner)findViewById(R.id.hitter_6_spinner);
        final Spinner hitter7 = (Spinner)findViewById(R.id.hitter_7_spinner);
        final Spinner hitter8 = (Spinner)findViewById(R.id.hitter_8_spinner);
        final Spinner hitter9 = (Spinner)findViewById(R.id.hitter_9_spinner);

        adteam = ArrayAdapter.createFromResource(this, R.array.team, android.R.layout.simple_spinner_dropdown_item);
        adteam.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        team_spin.setAdapter(adteam);
        team_spin.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(adteam.getItem(i).equals("한화")) {
                    adhit1 = ArrayAdapter.createFromResource(StartList.this, R.array.hanhwa_player, android.R.layout.simple_spinner_dropdown_item);
                    adhit1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    hitter1.setAdapter(adhit1);
                    hitter1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            hanhwa_one = hitter1.getSelectedItem().toString();
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
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });



                }
                if(adteam.getItem(i).equals("넥센")) {
                    adhit1 = ArrayAdapter.createFromResource(StartList.this, R.array.nexen_player, android.R.layout.simple_spinner_dropdown_item);
                    adhit1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    hitter1.setAdapter(adhit1);
                    hitter1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            nexen_one = hitter1.getSelectedItem().toString();
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
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });


                }
            }
        });





    }
}
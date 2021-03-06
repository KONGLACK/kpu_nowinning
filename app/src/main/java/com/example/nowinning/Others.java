package com.example.nowinning;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import static android.content.Context.MODE_PRIVATE;
import static com.example.nowinning.BSOActivity.a;
import static com.example.nowinning.BSOActivity.ahit_by_pitch;
import static com.example.nowinning.BSOActivity.ascore;
import static com.example.nowinning.BSOActivity.away_arr;
import static com.example.nowinning.BSOActivity.away_ball;
import static com.example.nowinning.BSOActivity.away_outout;
import static com.example.nowinning.BSOActivity.away_strike;
import static com.example.nowinning.BSOActivity.ballCnt;
import static com.example.nowinning.BSOActivity.btn_SBO;
import static com.example.nowinning.BSOActivity.btn_o;
import static com.example.nowinning.BSOActivity.et_ball;
import static com.example.nowinning.BSOActivity.et_hscore;
import static com.example.nowinning.BSOActivity.et_ini;
import static com.example.nowinning.BSOActivity.et_out;
import static com.example.nowinning.BSOActivity.et_strike;
import static com.example.nowinning.BSOActivity.h;
import static com.example.nowinning.BSOActivity.hhit_by_pitch;
import static com.example.nowinning.BSOActivity.home_arr;
import static com.example.nowinning.BSOActivity.home_ball;
import static com.example.nowinning.BSOActivity.home_ining;
import static com.example.nowinning.BSOActivity.hscore;
import static com.example.nowinning.BSOActivity.img0;
import static com.example.nowinning.BSOActivity.img1;
import static com.example.nowinning.BSOActivity.img2;
import static com.example.nowinning.BSOActivity.img3;
import static com.example.nowinning.BSOActivity.ini;
import static com.example.nowinning.BSOActivity.iniCnt;
import static com.example.nowinning.BSOActivity.ini_num;
import static com.example.nowinning.BSOActivity.outCnt;
import static com.example.nowinning.BSOActivity.runCnt;
import static com.example.nowinning.BSOActivity.stkCnt;
import static com.example.nowinning.start.away_catcher;
import static com.example.nowinning.start.away_centerfielder;
import static com.example.nowinning.start.away_firstbase;
import static com.example.nowinning.start.away_leftfielder;
import static com.example.nowinning.start.away_pitcher;
import static com.example.nowinning.start.away_player1;
import static com.example.nowinning.start.away_player2;
import static com.example.nowinning.start.away_player3;
import static com.example.nowinning.start.away_player4;
import static com.example.nowinning.start.away_player5;
import static com.example.nowinning.start.away_player6;
import static com.example.nowinning.start.away_player7;
import static com.example.nowinning.start.away_player8;
import static com.example.nowinning.start.away_player9;
import static com.example.nowinning.start.away_rightfielder;
import static com.example.nowinning.start.away_secondbase;
import static com.example.nowinning.start.away_shortstop;
import static com.example.nowinning.start.away_thirdbase;
import static com.example.nowinning.start.choice_away;
import static com.example.nowinning.start.choice_home;
import static com.example.nowinning.start.home_catcher;
import static com.example.nowinning.start.home_centerfielder;
import static com.example.nowinning.start.home_firstbase;
import static com.example.nowinning.start.home_leftfielder;
import static com.example.nowinning.start.home_pitcher;
import static com.example.nowinning.BSOActivity.ascore_1;
import static com.example.nowinning.BSOActivity.ascore_2;
import static com.example.nowinning.BSOActivity.ascore_3;
import static com.example.nowinning.BSOActivity.ascore_4;
import static com.example.nowinning.BSOActivity.ascore_5;
import static com.example.nowinning.BSOActivity.ascore_6;
import static com.example.nowinning.BSOActivity.ascore_7;
import static com.example.nowinning.BSOActivity.ascore_8;
import static com.example.nowinning.BSOActivity.ascore_9;
import static com.example.nowinning.BSOActivity.hscore_1;
import static com.example.nowinning.BSOActivity.hscore_2;
import static com.example.nowinning.BSOActivity.hscore_3;
import static com.example.nowinning.BSOActivity.hscore_4;
import static com.example.nowinning.BSOActivity.hscore_5;
import static com.example.nowinning.BSOActivity.hscore_6;
import static com.example.nowinning.BSOActivity.hscore_7;
import static com.example.nowinning.BSOActivity.hscore_8;
import static com.example.nowinning.BSOActivity.hscore_9;
import static com.example.nowinning.BSOActivity.et_ascore;
import static com.example.nowinning.BSOActivity.et_hscore;
import static com.example.nowinning.start.home_player1;
import static com.example.nowinning.start.home_player2;
import static com.example.nowinning.start.home_player3;
import static com.example.nowinning.start.home_player4;
import static com.example.nowinning.start.home_player5;
import static com.example.nowinning.start.home_player6;
import static com.example.nowinning.start.home_player7;
import static com.example.nowinning.start.home_player8;
import static com.example.nowinning.start.home_player9;
import static com.example.nowinning.start.home_rightfielder;
import static com.example.nowinning.start.home_secondbase;
import static com.example.nowinning.start.home_shortstop;
import static com.example.nowinning.start.home_thirdbase;


public class Others extends Fragment {

    public static Button btn_HBP, btn_Balk, btn_OutOthers, btn_PutonB, btn_test, btn_9ini, btn_save, btn_get;
    public static LinearLayout layout_Others;


    Handler handler = new Handler();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.others, container, false);

        btn_HBP = (Button) v.findViewById(R.id.btn_HBP);
        btn_Balk = (Button) v.findViewById(R.id.btn_Balk);
        btn_OutOthers = (Button) v.findViewById(R.id.btn_OutOthers);
        btn_PutonB = (Button) v.findViewById(R.id.btn_PutonB);
        btn_test = (Button) v.findViewById(R.id.btn_test);
        btn_9ini = (Button) v.findViewById(R.id.btn_9ini);
        btn_save = (Button) v.findViewById(R.id.btn_save);
        btn_get = (Button) v.findViewById(R.id.btn_get);

        layout_Others = (LinearLayout) v.findViewById(R.id.layout_Others);


        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("save_get", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        SharedPreferences.Editor editor1 = sharedPreferences.edit();

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


        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i =0; i<9; i++){
                    iniCnt++;
                    Toast.makeText(getActivity(),"?????? ???????????? 8 ???????????????", Toast.LENGTH_SHORT).show();
                }
                /*FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                TestBtn testbtn = new TestBtn();
                transaction.replace(R.id.frame, testbtn);
                transaction.commit(); // */ //????????? ????????? ???????????? ????????????
            }
        });

        btn_HBP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ini_num % 2 == 1) {

                    PithcerReqeust_HBP_Home PithcerReqeust_HBP_Home = new PithcerReqeust_HBP_Home(choice_away, choice_home, home_pitcher, responseListener);
                    RequestQueue queue4 = Volley.newRequestQueue(getContext());
                    queue4.add(PithcerReqeust_HBP_Home);

                    ahit_by_pitch++; //????????? ?????? ??????

                        if (runCnt == 0) { // ????????? ?????? ??????
                            a++;
                            if(a>8) {
                                a=0;
                            }
                            img1.setText(img0.getText());
                            img0.setText(away_arr[a]);
                            img0.setVisibility(View.VISIBLE);
                            img1.setVisibility(View.VISIBLE);
                            img2.setVisibility(View.INVISIBLE);
                            img3.setVisibility(View.INVISIBLE); // ?????? 1?????? ??????

                            runCnt = 1;

                            stkCnt = 0;
                            ballCnt = 0;
                        } else if (runCnt == 1) {// ????????? ?????? ??????
                            a++;
                            if(a>8) {
                                a=0;
                            }

                            img2.setText(img1.getText());
                            img1.setText(img0.getText());
                            img0.setText(away_arr[a]);
                            img0.setVisibility(View.VISIBLE);
                            img1.setVisibility(View.VISIBLE);
                            img2.setVisibility(View.VISIBLE);
                            img3.setVisibility(View.INVISIBLE);   // ?????? 2?????? ??????

                            runCnt = 4; // ?????? 1,2???

                            stkCnt = 0;
                            ballCnt = 0;


                        } else if (runCnt == 2) { // ????????? ?????? ??????
                            a++;
                            if(a>8) {
                                a=0;
                            }
                            img1.setText(img0.getText());
                            img0.setText(away_arr[a]);
                            img0.setVisibility(View.VISIBLE);
                            img1.setVisibility(View.VISIBLE);
                            img2.setVisibility(View.VISIBLE);
                            img3.setVisibility(View.INVISIBLE);  // ?????? 3?????? ??????

                            runCnt = 4; //?????? 2,3???
                            stkCnt = 0;
                            ballCnt = 0;


                        } else if (runCnt == 3) {// ????????? ?????? ??????
                            a++;
                            if(a>8) {
                                a=0;
                            }

                            img1.setText(img0.getText());
                            img0.setText(away_arr[a]);
                            img0.setVisibility(View.VISIBLE);
                            img1.setVisibility(View.VISIBLE);
                            img2.setVisibility(View.INVISIBLE);
                            img3.setVisibility(View.INVISIBLE); //?????? 1?????? ??????

                            runCnt = 6; //?????? 1???

                            stkCnt = 0;
                            ballCnt = 0;

                        } else if (runCnt == 4) {// ????????? ?????? ??????
                            a++;
                            if(a>8) {
                                a=0;
                            }

                            img3.setText(img2.getText());
                            img2.setText(img1.getText());
                            img1.setText(img0.getText());
                            img0.setText(away_arr[a]);
                            img0.setVisibility(View.VISIBLE);
                            img1.setVisibility(View.VISIBLE);
                            img2.setVisibility(View.VISIBLE);
                            img3.setVisibility(View.VISIBLE);// ?????? 1,2,3?????? ??????

                            runCnt = 7;

                            stkCnt = 0;
                            ballCnt = 0;


                        } else if (runCnt == 5) {// ????????? ?????? ??????
                            a++;
                            if(a>8) {
                                a=0;
                            }

                            img1.setText(img0.getText());
                            img0.setText(away_arr[a]);
                            img0.setVisibility(View.VISIBLE);
                            img1.setVisibility(View.VISIBLE);
                            img2.setVisibility(View.VISIBLE);
                            img3.setVisibility(View.VISIBLE);   // ?????? 1?????? ??????

                            runCnt = 7;

                            stkCnt = 0;
                            ballCnt = 0;

                        } else if (runCnt == 6) {// ????????? ?????? ??????
                            a++;
                            if(a>8) {
                                a=0;
                            }

                            img2.setText(img1.getText());
                            img1.setText(img0.getText());
                            img0.setText(away_arr[a]);
                            img0.setVisibility(View.VISIBLE);
                            img1.setVisibility(View.VISIBLE);
                            img2.setVisibility(View.VISIBLE);
                            img3.setVisibility(View.VISIBLE);   // ?????? 1?????? ??????

                            runCnt = 7;

                            stkCnt = 0;
                            ballCnt = 0;

                        } else if (runCnt == 7) {// ????????? ?????? ??????
                            a++;
                            if(a>8) {
                                a=0;
                            }

                            img3.setText(img2.getText());
                            img2.setText(img1.getText());
                            img1.setText(img0.getText());
                            img0.setText(away_arr[a]);
                            img0.setVisibility(View.VISIBLE);
                            img1.setVisibility(View.VISIBLE);
                            img2.setVisibility(View.VISIBLE);
                            img3.setVisibility(View.VISIBLE);   // ?????? 1?????? ??????

                            runCnt = 7;

                            handler.postDelayed(new Runnable() { // ?????? ?????? ???????????? ???????????? 0.5??? ?????????
                                @Override
                                public void run() {
                                    hscore++;
                                    et_hscore.setText("???      " + choice_away + Integer.toString(ascore));
                                }
                            }, 500);
                            stkCnt = 0;
                            ballCnt = 0;

                            PithcerReqeust_ER_Home PithcerReqeust_ER_Home = new PithcerReqeust_ER_Home(choice_away, choice_home, home_pitcher, responseListener);
                            RequestQueue queue5 = Volley.newRequestQueue(getContext());
                            queue5.add(PithcerReqeust_ER_Home);
                        }

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
                    TeamRequest teamRequest = new TeamRequest(choice_away, away_ball, away_strike, away_outout, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(getActivity());
                    queue.add(teamRequest);
                }
                if (ini_num % 2 == 0) {
                    hhit_by_pitch++; //??? ?????? ??????

                    PithcerReqeust_HBP_Away PithcerReqeust_HBP_Away = new PithcerReqeust_HBP_Away(choice_away, choice_home, away_pitcher, responseListener);
                    RequestQueue queue4 = Volley.newRequestQueue(getContext());
                    queue4.add(PithcerReqeust_HBP_Away);

                        if (runCnt == 0) { // ????????? ?????? ??????
                            h++;
                            if(h>8) {
                                h=0;
                            }
                            img1.setText(img0.getText());
                            img0.setText(home_arr[h]);
                            img0.setVisibility(View.VISIBLE);
                            img1.setVisibility(View.VISIBLE);
                            img2.setVisibility(View.INVISIBLE);
                            img3.setVisibility(View.INVISIBLE); // ?????? 1?????? ??????

                            runCnt = 1;

                            stkCnt = 0;
                            ballCnt = 0;

                        } else if (runCnt == 1) {// ????????? ?????? ??????
                            h++;
                            if(h>8) {
                                h=0;
                            }
                            img2.setText(img1.getText());
                            img1.setText(img0.getText());
                            img0.setText(home_arr[h]);
                            img0.setVisibility(View.VISIBLE);
                            img1.setVisibility(View.VISIBLE);
                            img2.setVisibility(View.VISIBLE);
                            img3.setVisibility(View.INVISIBLE);   // ?????? 2?????? ??????

                            runCnt = 4; // ?????? 1,2???

                            stkCnt = 0;
                            ballCnt = 0;


                        } else if (runCnt == 2) { // ????????? ?????? ??????
                            h++;
                            if(h>8) {
                                h=0;
                            }
                            img1.setText(img0.getText());
                            img0.setText(home_arr[h]);
                            img0.setVisibility(View.VISIBLE);
                            img1.setVisibility(View.VISIBLE);
                            img2.setVisibility(View.VISIBLE);
                            img3.setVisibility(View.INVISIBLE);  // ?????? 3?????? ??????

                            runCnt = 4; //?????? 2,3???

                            stkCnt = 0;
                            ballCnt = 0;


                        } else if (runCnt == 3) {// ????????? ?????? ??????
                            h++;
                            if(h>8) {
                                h=0;
                            }
                            img1.setText(img0.getText());
                            img0.setText(home_arr[h]);
                            img0.setVisibility(View.VISIBLE);
                            img1.setVisibility(View.VISIBLE);
                            img2.setVisibility(View.INVISIBLE);
                            img3.setVisibility(View.INVISIBLE); //?????? 1?????? ??????

                            runCnt = 6; //?????? 1???


                            stkCnt = 0;
                            ballCnt = 0;

                        } else if (runCnt == 4) {// ????????? ?????? ??????
                            h++;
                            if(h>8) {
                                h=0;
                            }
                            img3.setText(img2.getText());
                            img2.setText(img1.getText());
                            img1.setText(img0.getText());
                            img0.setText(home_arr[h]);
                            img0.setVisibility(View.VISIBLE);
                            img1.setVisibility(View.VISIBLE);
                            img2.setVisibility(View.VISIBLE);
                            img3.setVisibility(View.VISIBLE);// ?????? 1,2,3?????? ??????

                            runCnt = 7;

                            stkCnt = 0;
                            ballCnt = 0;


                        } else if (runCnt == 5) {// ????????? ?????? ??????
                            h++;
                            if(h>8) {
                                h=0;
                            }
                            img1.setText(img0.getText());
                            img0.setText(home_arr[h]);
                            img0.setVisibility(View.VISIBLE);
                            img1.setVisibility(View.VISIBLE);
                            img2.setVisibility(View.VISIBLE);
                            img3.setVisibility(View.VISIBLE);   // ?????? 1?????? ??????

                            runCnt = 7;

                            stkCnt = 0;
                            ballCnt = 0;

                        } else if (runCnt == 6) {// ????????? ?????? ??????
                            h++;
                            if(h>8) {
                                h=0;
                            }

                            img2.setText(img1.getText());
                            img1.setText(img0.getText());
                            img0.setText(home_arr[h]);
                            img0.setVisibility(View.VISIBLE);
                            img1.setVisibility(View.VISIBLE);
                            img2.setVisibility(View.VISIBLE);
                            img3.setVisibility(View.VISIBLE);   // ?????? 1?????? ??????

                            runCnt = 7;

                            stkCnt = 0;
                            ballCnt = 0;

                        } else if (runCnt == 7) {// ????????? ?????? ??????
                            h++;
                            if(h>8) {
                                h=0;
                            }

                            img3.setText(img2.getText());
                            img2.setText(img1.getText());
                            img1.setText(img0.getText());
                            img0.setText(home_arr[h]);
                            img0.setVisibility(View.VISIBLE);
                            img1.setVisibility(View.VISIBLE);
                            img2.setVisibility(View.VISIBLE);
                            img3.setVisibility(View.VISIBLE);   // ?????? 1?????? ??????

                            runCnt = 7;

                            handler.postDelayed(new Runnable() { // ?????? ?????? ???????????? ???????????? 0.5??? ?????????
                                @Override
                                public void run() {
                                    hscore++;
                                    et_hscore.setText("???      " + choice_home + Integer.toString(hscore));
                                    home_ining++;
                                }
                            }, 500);
                            stkCnt = 0;
                            ballCnt = 0;

                            PithcerReqeust_ER_Away PithcerReqeust_ER_Away = new PithcerReqeust_ER_Away(choice_away, choice_home, away_pitcher, responseListener);
                            RequestQueue queue5 = Volley.newRequestQueue(getContext());
                            queue5.add(PithcerReqeust_ER_Away);
                        }

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
                    TeamRequest teamRequest = new TeamRequest(choice_away, away_ball, away_strike, away_outout, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(getActivity());
                    queue.add(teamRequest);
                }

                btn_SBO.setVisibility(View.VISIBLE);
                layout_Others.setVisibility(View.INVISIBLE);
            }
        });

        btn_Balk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runCnt++;
                stkCnt = 0;
                ballCnt = 0;

                layout_Others.setVisibility(View.INVISIBLE);
                btn_SBO.setVisibility(View.VISIBLE);
            }
        });


        btn_OutOthers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_o.performClick();
                layout_Others.setVisibility(View.INVISIBLE);
                btn_SBO.setVisibility(View.VISIBLE);
            }
        });

        btn_PutonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runCnt++;
                //?????? ????????? ????????? ??? S/D/O ?????? ??? ????????? ??????
                //????????? ?????? ??? ???????????? ?????? ?????????
                layout_Others.setVisibility(View.INVISIBLE);
                btn_SBO.setVisibility(View.VISIBLE);
            }
        });

        btn_9ini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniCnt=9;
                ini_num=1;
                et_ini.setText(Integer.toString(iniCnt) + "??????    " + ini[ini_num]);

                ascore_1 = 1;
                ascore_2 = 1;
                ascore_3 = 3;
                ascore_4 = 0;
                ascore_5 = 2;
                ascore_6 = 1;
                ascore_7 = 0;
                ascore_8 = 0;
                ascore = 8;
                et_ascore.setText("??????      " + choice_away + Integer.toString(ascore));

                hscore_1 = 1;
                hscore_2 = 1;
                hscore_3 = 0;
                hscore_4 = 1;
                hscore_5 = 1;
                hscore_6 = 2;
                hscore_7 = 0;
                hscore_8 = 1;
                hscore = 7;
                et_hscore.setText("???      " + choice_home + Integer.toString(hscore));

                et_ball.setText(et_ball.getText().toString() + "**"); // ??? ??????
                ballCnt=2;

                et_strike.setText(et_strike.getText().toString() + "*"); // ??? ??????
                stkCnt=1;

                et_out.setText(et_out.getText().toString() + "*"); // ??? ??????
                outCnt=1;
                h=2;
                btn_SBO.setVisibility(View.VISIBLE);
                layout_Others.setVisibility(View.INVISIBLE);
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor1.clear();
                editor1.commit();
                editor.putString("ascore", String.valueOf(ascore));
                editor.putString("ascore_1", String.valueOf(ascore_1));
                editor.putString("ascore_2", String.valueOf(ascore_2));
                editor.putString("ascore_3", String.valueOf(ascore_3));
                editor.putString("ascore_4", String.valueOf(ascore_4));
                editor.putString("ascore_5", String.valueOf(ascore_5));
                editor.putString("ascore_6", String.valueOf(ascore_6));
                editor.putString("ascore_7", String.valueOf(ascore_7));
                editor.putString("ascore_8", String.valueOf(ascore_8));
                editor.putString("ascore_9", String.valueOf(ascore_9));

                editor.putString("hscore", String.valueOf(hscore));
                editor.putString("hscore_1", String.valueOf(hscore_1));
                editor.putString("hscore_2", String.valueOf(hscore_2));
                editor.putString("hscore_3", String.valueOf(hscore_3));
                editor.putString("hscore_4", String.valueOf(hscore_4));
                editor.putString("hscore_5", String.valueOf(hscore_5));
                editor.putString("hscore_6", String.valueOf(hscore_6));
                editor.putString("hscore_7", String.valueOf(hscore_7));
                editor.putString("hscore_8", String.valueOf(hscore_8));
                editor.putString("hscore_9", String.valueOf(hscore_9));

                editor.putString("ballCnt", String.valueOf(ballCnt));
                editor.putString("stkCnt", String.valueOf(stkCnt));
                editor.putString("outCnt", String.valueOf(outCnt));

                editor.putString("away_player1", away_player1);
                editor.putString("away_player2", away_player2);
                editor.putString("away_player3", away_player3);
                editor.putString("away_player4", away_player4);
                editor.putString("away_player5", away_player5);
                editor.putString("away_player6", away_player6);
                editor.putString("away_player7", away_player7);
                editor.putString("away_player8", away_player8);
                editor.putString("away_player9", away_player9);
                editor.putString("away_pitcher", away_pitcher);
                editor.putString("away_catcher", away_catcher);
                editor.putString("away_firstbase", away_firstbase);
                editor.putString("away_secondbase", away_secondbase);
                editor.putString("away_thirdbase", away_thirdbase);
                editor.putString("away_shortstop", away_shortstop);
                editor.putString("away_leftfielder", away_leftfielder);
                editor.putString("away_centerfielder", away_centerfielder);
                editor.putString("away_rightfielder", away_rightfielder);
                editor.putString("a", String.valueOf(a));


                editor.putString("home_player1", home_player1);
                editor.putString("home_player2", home_player2);
                editor.putString("home_player3", home_player3);
                editor.putString("home_player4", home_player4);
                editor.putString("home_player5", home_player5);
                editor.putString("home_player6", home_player6);
                editor.putString("home_player7", home_player7);
                editor.putString("home_player8", home_player8);
                editor.putString("home_player9", home_player9);
                editor.putString("home_pitcher", home_pitcher);
                editor.putString("home_catcher", home_catcher);
                editor.putString("home_firstbase", home_firstbase);
                editor.putString("home_secondbase", home_secondbase);
                editor.putString("home_thirdbase", home_thirdbase);
                editor.putString("home_shortstop", home_shortstop);
                editor.putString("home_leftfielder", home_leftfielder);
                editor.putString("home_centerfielder", home_centerfielder);
                editor.putString("home_rightfielder", home_rightfielder);
                editor.putString("h", String.valueOf(h));
                editor.putString("runCnt", String.valueOf(runCnt));

                editor.putString("img0text", (String) img0.getText());
                if(img1.getVisibility()==View.VISIBLE) {
                    editor.putString("img1text", (String) img1.getText());
                }
                else {
                    editor.putString("img1text", "??????");
                }
                if(img2.getVisibility()==View.VISIBLE) {
                    editor.putString("img2text", (String) img2.getText());
                }
                else
                {
                    editor.putString("img2text", "??????");
                }
                if(img3.getVisibility()==View.VISIBLE) {
                    editor.putString("img3text", (String) img3.getText());
                }
                else {
                    editor.putString("img3text", "??????");
                }



                editor.putString("iniCnt", String.valueOf(iniCnt));
                editor.putString("ininum", String.valueOf(ini_num));

                editor.putString("choicehome", choice_home);
                editor.putString("choiceaway", choice_away);
                editor.commit();



            }
        });

        btn_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ascore = Integer.parseInt(sharedPreferences.getString("ascore", "??????"));
                ascore_1 = Integer.parseInt(sharedPreferences.getString("ascore_1", "??????"));
                ascore_2 = Integer.parseInt(sharedPreferences.getString("ascore_1", "??????"));
                ascore_3 = Integer.parseInt(sharedPreferences.getString("ascore_1", "??????"));
                ascore_4 = Integer.parseInt(sharedPreferences.getString("ascore_1", "??????"));
                ascore_5 = Integer.parseInt(sharedPreferences.getString("ascore_1", "??????"));
                ascore_6 = Integer.parseInt(sharedPreferences.getString("ascore_1", "??????"));
                ascore_7 = Integer.parseInt(sharedPreferences.getString("ascore_1", "??????"));
                ascore_8 = Integer.parseInt(sharedPreferences.getString("ascore_1", "??????"));
                ascore_9 = Integer.parseInt(sharedPreferences.getString("ascore_1", "??????"));

                hscore = Integer.parseInt(sharedPreferences.getString("hscore", "??????"));
                hscore_1 = Integer.parseInt(sharedPreferences.getString("hscore_1", "??????"));
                hscore_2 = Integer.parseInt(sharedPreferences.getString("hscore_2", "??????"));
                hscore_3 = Integer.parseInt(sharedPreferences.getString("hscore_3", "??????"));
                hscore_4 = Integer.parseInt(sharedPreferences.getString("hscore_4", "??????"));
                hscore_5 = Integer.parseInt(sharedPreferences.getString("hscore_5", "??????"));
                hscore_6 = Integer.parseInt(sharedPreferences.getString("hscore_6", "??????"));
                hscore_8 = Integer.parseInt(sharedPreferences.getString("hscore_7", "??????"));
                hscore_8 = Integer.parseInt(sharedPreferences.getString("hscore_8", "??????"));
                hscore_9 = Integer.parseInt(sharedPreferences.getString("hscore_9", "??????"));

                away_player1 = sharedPreferences.getString("away_player1", "??????");
                away_player2 = sharedPreferences.getString("away_player2", "??????");
                away_player3 = sharedPreferences.getString("away_player3", "??????");
                away_player4 = sharedPreferences.getString("away_player4", "??????");
                away_player5 = sharedPreferences.getString("away_player5", "??????");
                away_player6 = sharedPreferences.getString("away_player6", "??????");
                away_player7 = sharedPreferences.getString("away_player7", "??????");
                away_player8 = sharedPreferences.getString("away_player8", "??????");
                away_player9 = sharedPreferences.getString("away_player9", "??????");
                away_pitcher = sharedPreferences.getString("away_pitcher", "??????");
                away_catcher = sharedPreferences.getString("away_catcher", "??????");
                away_firstbase = sharedPreferences.getString("away_firstbase", "??????");
                away_secondbase = sharedPreferences.getString("away_secondbase", "??????");
                away_thirdbase = sharedPreferences.getString("away_thirdbase", "??????");
                away_shortstop = sharedPreferences.getString("away_shortstop", "??????");
                away_leftfielder = sharedPreferences.getString("away_leftfielder", "??????");
                away_centerfielder = sharedPreferences.getString("away_centerfielder", "??????");
                away_rightfielder = sharedPreferences.getString("away_rightfielder", "??????");
                a = Integer.parseInt(sharedPreferences.getString("a", "??????"));

                home_player1 = sharedPreferences.getString("home_player1", "??????");
                home_player2 = sharedPreferences.getString("home_player2", "??????");
                home_player3 = sharedPreferences.getString("home_player3", "??????");
                home_player4 = sharedPreferences.getString("home_player4", "??????");
                home_player5 = sharedPreferences.getString("home_player5", "??????");
                home_player6 = sharedPreferences.getString("home_player6", "??????");
                home_player7 = sharedPreferences.getString("home_player7", "??????");
                home_player8 = sharedPreferences.getString("home_player8", "??????");
                home_player9 = sharedPreferences.getString("home_player9", "??????");
                home_pitcher = sharedPreferences.getString("home_pitcher", "??????");
                home_catcher = sharedPreferences.getString("home_catcher", "??????");
                home_firstbase = sharedPreferences.getString("home_firstbase", "??????");
                home_secondbase = sharedPreferences.getString("home_secondbase", "??????");
                home_thirdbase = sharedPreferences.getString("home_thirdbase", "??????");
                home_shortstop = sharedPreferences.getString("home_shortstop", "??????");
                home_leftfielder = sharedPreferences.getString("home_leftfielder", "??????");
                home_centerfielder = sharedPreferences.getString("home_centerfielder", "??????");
                home_rightfielder = sharedPreferences.getString("home_rightfielder", "??????");
                h = Integer.parseInt(sharedPreferences.getString("h", "??????"));
                runCnt = Integer.parseInt(sharedPreferences.getString("runCnt", "??????"));





                choice_away = sharedPreferences.getString("choiceaway", "??????");
                choice_home = sharedPreferences.getString("choicehome", "??????");

                ballCnt = Integer.parseInt(sharedPreferences.getString("ballCnt", "??????"));
                if(ballCnt==1) {
                    et_ball.setText(et_ball.getText().toString() + "*"); // ??? ??????
                }
                if(ballCnt==2) {
                    et_ball.setText(et_ball.getText().toString() + "**"); // ??? ??????
                }
                if(ballCnt==3) {
                    et_ball.setText(et_ball.getText().toString() + "***"); // ??? ??????
                }

                outCnt = Integer.parseInt(sharedPreferences.getString("outCnt", "??????"));
                if(outCnt==1) {
                    et_out.setText(et_out.getText().toString() + "*"); // ??? ??????
                }
                if(outCnt==2) {
                    et_out.setText(et_out.getText().toString() + "**"); // ??? ??????
                }

                stkCnt = Integer.parseInt(sharedPreferences.getString("stkCnt", "??????"));
                if(stkCnt==1) {
                    et_strike.setText(et_strike.getText().toString() + "*"); // ??? ??????

                }
                if(stkCnt==2) {
                    et_strike.setText(et_strike.getText().toString() + "**"); // ??? ??????
                }

                iniCnt = Integer.parseInt(sharedPreferences.getString("iniCnt", "??????"));
                ini_num = Integer.parseInt(sharedPreferences.getString("ininum", "??????"));

                et_ini.setText(Integer.toString(iniCnt) + "??????    " + ini[ini_num]);
                et_ascore.setText("??????      " + choice_away + Integer.toString(ascore));
                et_hscore.setText("???      " + choice_home + Integer.toString(hscore));


                String img1text = sharedPreferences.getString("img1text", "??????");
                String img2text = sharedPreferences.getString("img2text", "??????");
                String img3text = sharedPreferences.getString("img3text", "??????");

                if(ini_num%2==1) {
                    img0.setText(away_arr[a]);
                    img0.setVisibility(View.VISIBLE);

                    if(img1text=="??????") {
                        img1.setVisibility(View.INVISIBLE);
                    }
                    else {
                        img1.setText(img1text);
                        img1.setVisibility(View.VISIBLE);
                    }

                    if(img2text=="??????") {
                        img2.setVisibility(View.INVISIBLE);
                    }
                    else {
                        img2.setText(img2text);
                        img2.setVisibility(View.VISIBLE);
                    }
                    if(img3text=="??????") {
                        img3.setVisibility(View.INVISIBLE);
                    }
                    else {
                        img3.setText(img3text);
                        img3.setVisibility(View.VISIBLE);
                    }
                }

                if(ini_num%2==0) {
                    img0.setText(home_arr[h]);

                    if(img1text=="") {
                        img1.setVisibility(View.INVISIBLE);
                    }
                    else {
                        img1.setText(img1text);
                        img1.setVisibility(View.VISIBLE);
                    }

                    if(img2text=="") {
                        img2.setVisibility(View.INVISIBLE);
                    }
                    else {
                        img2.setText(img2text);
                        img2.setVisibility(View.VISIBLE);
                    }
                    if(img3text=="") {
                        img3.setVisibility(View.INVISIBLE);
                    }
                    else {
                        img3.setText(img3text);
                        img3.setVisibility(View.VISIBLE);
                    }
                }

                btn_SBO.setVisibility(View.VISIBLE);
                layout_Others.setVisibility(View.INVISIBLE);
            }
        });

        return v;
    }
}
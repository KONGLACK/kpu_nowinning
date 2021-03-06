package com.example.nowinning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.nowinning.start.away_catcher;
import static com.example.nowinning.start.away_centerfielder;
import static com.example.nowinning.start.away_firstbase;
import static com.example.nowinning.start.away_leftfielder;
import static com.example.nowinning.start.away_pitcher;
import static com.example.nowinning.start.away_rightfielder;
import static com.example.nowinning.start.away_secondbase;
import static com.example.nowinning.start.away_shortstop;
import static com.example.nowinning.start.away_thirdbase;
import static com.example.nowinning.start.choice_away;
import static com.example.nowinning.start.choice_home;
import static com.example.nowinning.start.away_player1;
import static com.example.nowinning.start.away_player2;
import static com.example.nowinning.start.away_player3;
import static com.example.nowinning.start.away_player4;
import static com.example.nowinning.start.away_player5;
import static com.example.nowinning.start.away_player6;
import static com.example.nowinning.start.away_player7;
import static com.example.nowinning.start.away_player8;
import static com.example.nowinning.start.away_player9;

import static com.example.nowinning.start.home_catcher;
import static com.example.nowinning.start.home_centerfielder;
import static com.example.nowinning.start.home_firstbase;
import static com.example.nowinning.start.home_leftfielder;
import static com.example.nowinning.start.home_pitcher;
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

public class BSOActivity extends AppCompatActivity {

    public static EditText et_strike, et_ball, et_out, et_hscore, et_ascore, et_ini;
    public static Button btn_s, btn_b, btn_other, btn_h , btn_o, btn_Undo,oCnt, btn_away, btn_home;
    public static Button img1, img2, img3, img0;
    public static Button img4, img5, img6, img7;
    public static String WINNER, LOSER;
    public static int ascore_1, ascore_2, ascore_3, ascore_4, ascore_5, ascore_6, ascore_7, ascore_8, ascore_9;
    public static int hscore_1, hscore_2, hscore_3, hscore_4, hscore_5, hscore_6, hscore_7, hscore_8, hscore_9;

    public static LinearLayout btn_SBO;
    public static ConstraintLayout layout_field;

    public int i,j;
    public static int hhit_by_pitch, ahit_by_pitch; //??? ??????, ????????? ??????
    public static int stkCnt, ballCnt, outCnt; //sCnt, bCnt, oCnt??? ?????? ???????????? ?????? ??? ????????? ?????????
    public static int hscore, ascore; // ?????? ????????? ????????? ??????
    public static int runCnt = 0; // ?????? ???????????? ?????? ?????? ?????????
    public static int iniCnt = 1; // ?????? ???????????? ?????? ?????? ?????? ??????
    public static int win_score = 0;
    public static int los_score = 0;

    public static int away_ball = 0;
    public static int away_strike = 0;
    public static int away_outout = 0;
    public static int away_ining = 0;
    public static int home_ining = 0;

    public static int home_ball = 0;
    public static int home_strike = 0;
    public static int home_outout = 0;
    public static int a=0;
    public static int h=0;
    public static String[] away_arr = {away_player1, away_player2, away_player3, away_player4, away_player5,
            away_player6, away_player7, away_player8, away_player9};
    public static String[] home_arr = {home_player1, home_player2, home_player3, home_player4, home_player5,
            home_player6, home_player7, home_player8, home_player9};
    public static int[] bat_select = new int[2];
    public static int[] away_hitCount = new int[9];
    public static int[] home_hitCount = new int[9];
    public static String[] ini = {"???", "???", "???", "???", "???", "???", "???", "???", "???", "???", "???", "???", "???", "???", "???", "???", "???",
            "???", "???", "???", "???", "???", "???", "???", "???", "???", "???"};
    public static int ini_num = 1;


    FrameLayout frame;
    FrameLayout frame2;



    private static final String TAG = "Main_Activity";

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart: ");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: ");


    }
    // ??????????????? ???????????? ?????? ??????



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ballstrike);

        Log.d(TAG,"onCreate:  ");


        img0 = (Button) findViewById(R.id.img0);
        img1 = (Button) findViewById(R.id.img1);
        img2 = (Button) findViewById(R.id.img2);
        img3 = (Button) findViewById(R.id.img3);


        et_strike = (EditText) findViewById(R.id.et_strike);
        et_ball = (EditText) findViewById(R.id.et_ball);
        et_out = (EditText) findViewById(R.id.et_out);
        et_hscore = (EditText) findViewById(R.id.et_hscore);
        et_ascore = (EditText) findViewById(R.id.et_ascore);
        et_ini = (EditText) findViewById(R.id.et_ini);

        btn_s = (Button) findViewById(R.id.strike_button);
        btn_b = (Button) findViewById(R.id.ball_button);
        btn_o = (Button) findViewById(R.id.out_button);
        btn_o.setVisibility(View.INVISIBLE);

        btn_other = (Button) findViewById(R.id.other_button);
        btn_h = (Button) findViewById(R.id.hit_button);

        btn_SBO = (LinearLayout) findViewById(R.id.btn_SBO);
        layout_field = (ConstraintLayout) findViewById(R.id.layout_field);
        //oCnt = (Button)findViewById(R.id.cnt_button);


        et_hscore.setText("???      " + choice_home + " 0");
        et_ascore.setText("??????   " + choice_away + " 0");
//        btn_away.setText(choice_away);
//        btn_home.setText(choice_home);

        runCnt = 0;
        img0.setText(away_arr[a]);
        img0.setVisibility(View.VISIBLE);
        img1.setVisibility(View.INVISIBLE);
        img2.setVisibility(View.INVISIBLE);
        img3.setVisibility(View.INVISIBLE);
        //hihi??????
        //okhihi
        // PHP ?????? ?????? ?????? (ONE+TWO+THREE)/Hit ??????

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


                Handler handler = new Handler();

                btn_s.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(ini_num%2==1) {
                            away_strike++;
                            Log.d("???????????????????????????", away_strike+"");


                            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                            Strike strike_fragment = new Strike();
                            transaction.replace(R.id.frame, strike_fragment);
                            transaction.commit();
                            btn_SBO.setVisibility(View.INVISIBLE);


                        }
                        if(ini_num%2==0) {
                            home_strike++;
                            Log.d("?????????????????????", home_strike+"");


                            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                            Strike strike_fragment = new Strike();
                            transaction.replace(R.id.frame, strike_fragment);
                            transaction.commit();
                            btn_SBO.setVisibility(View.INVISIBLE);


                        }

                    }
                });

                btn_b.setOnClickListener(new View.OnClickListener() {


                    @Override
                    public void onClick(View v) {
                        if (ini_num % 2 == 1) {
                            away_ball++;


                            et_ball.setText(et_ball.getText().toString() + "*"); // ??? ??????
                            ballCnt++; //??????????????? ????????? ?????? ??????
                            if (ballCnt == 4) {
                                handler.postDelayed(new Runnable() { // ?????? ?????? ???????????? ???????????? 0.5??? ?????????
                                    @Override
                                    public void run() {
                                        et_ball.setText("B ");
                                        ballCnt = 0;
                                    }
                                }, 500);

                                PithcerReqeust_BB_Home PithcerReqeust_BB_Home = new PithcerReqeust_BB_Home(choice_away, choice_home, home_pitcher, responseListener);
                                RequestQueue queue6 = Volley.newRequestQueue(BSOActivity.this);
                                queue6.add(PithcerReqeust_BB_Home);


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
                                    RBIRequest_away RBIRequest_away = new RBIRequest_away(choice_away, choice_home, away_arr[a], responseListener);
                                    RequestQueue queue = Volley.newRequestQueue(BSOActivity.this);
                                    queue.add(RBIRequest_away);

                                    ScoreRequest_away ScoreRequest_away = new ScoreRequest_away(choice_away, choice_home, (String) img3.getText(), responseListener);
                                    RequestQueue queue1 = Volley.newRequestQueue(BSOActivity.this);
                                    queue1.add(ScoreRequest_away);

                                    PithcerReqeust_ER_Home PithcerReqeust_ER_Home = new PithcerReqeust_ER_Home(choice_away, choice_home, home_pitcher, responseListener);
                                    RequestQueue queue2 = Volley.newRequestQueue(BSOActivity.this);
                                    queue2.add(PithcerReqeust_ER_Home);

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
                                            ascore++;
                                            et_ascore.setText("??????      " + choice_away + Integer.toString(ascore));
                                        }
                                    }, 500);
                                    stkCnt = 0;
                                    ballCnt = 0;
                                }
                            }

                        }
                        if (ini_num % 2 == 0) {
                            home_ball++;

                            et_ball.setText(et_ball.getText().toString() + "*"); // ??? ??????
                            ballCnt++; //??????????????? ????????? ?????? ??????
                            if (ballCnt == 4) {
                                handler.postDelayed(new Runnable() { // ?????? ?????? ???????????? ???????????? 0.5??? ?????????
                                    @Override
                                    public void run() {
                                        et_ball.setText("B ");
                                        ballCnt = 0;
                                    }
                                }, 500);

                                PithcerReqeust_BB_Away PithcerReqeust_BB_Away = new PithcerReqeust_BB_Away(choice_away, choice_home, away_pitcher, responseListener);
                                RequestQueue queue6 = Volley.newRequestQueue(BSOActivity.this);
                                queue6.add(PithcerReqeust_BB_Away);

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
                                    RBIRequest_home RBIRequest_home = new RBIRequest_home(choice_away, choice_home, home_arr[h], responseListener);
                                    RequestQueue queue = Volley.newRequestQueue(BSOActivity.this);
                                    queue.add(RBIRequest_home);

                                    ScoreRequest_home ScoreRequest_home = new ScoreRequest_home(choice_home, choice_home, (String) img3.getText(), responseListener);
                                    RequestQueue queue1 = Volley.newRequestQueue(BSOActivity.this);
                                    queue1.add(ScoreRequest_home);

                                    PithcerReqeust_ER_Away PithcerReqeust_ER_Away = new PithcerReqeust_ER_Away(choice_away, choice_home, away_pitcher, responseListener);
                                    RequestQueue queue2 = Volley.newRequestQueue(BSOActivity.this);
                                    queue2.add(PithcerReqeust_ER_Away);
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
                                        }
                                    }, 500);

                                stkCnt = 0;
                                ballCnt = 0;
                            }
                        }
                    }
                }
            });

                btn_o.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (ini_num%2==1) {
                            outCnt++;
                            a++;
                            if(a>8) {
                                a=0;
                            }
                            if(outCnt < 3) {
                                img0.setText(away_arr[a]);
                            }
                            away_outout++;
                            Log.d("??????????????????", away_outout+"");


                            et_out.setText(et_out.getText().toString() + "*"); // ??? ??????
                            et_strike.setText("S ");
                            stkCnt = 0;
                            et_ball.setText("B ");
                            ballCnt = 0;
                            if (outCnt == 3) {
                                PithcerReqeust_Ining_Home PithcerReqeust_Ining_Home = new PithcerReqeust_Ining_Home(choice_away, choice_home, home_pitcher, responseListener);
                                RequestQueue queue6 = Volley.newRequestQueue(BSOActivity.this);
                                queue6.add(PithcerReqeust_Ining_Home);

                                if(iniCnt==1 && ini_num%2==1) {
                                    ascore_1 = ascore;
                                }
                                if(iniCnt==2 && ini_num%2==1) {
                                    ascore_2 = ascore-ascore_1;
                                }
                                if(iniCnt==3 && ini_num%2==1) {
                                    ascore_3 = ascore-ascore_1-ascore_2;
                                }
                                if(iniCnt==4 && ini_num%2==1) {
                                    ascore_4 = ascore-ascore_1-ascore_2-ascore_3;
                                }
                                if(iniCnt==5 && ini_num%2==1) {
                                    ascore_5 = ascore-ascore_1-ascore_2-ascore_3-ascore_4;
                                }
                                if(iniCnt==6 && ini_num%2==1) {
                                    ascore_6 = ascore-ascore_1-ascore_2-ascore_3-ascore_4-ascore_5;
                                }
                                if(iniCnt==7 && ini_num%2==1) {
                                    ascore_7 = ascore-ascore_1-ascore_2-ascore_3-ascore_4-ascore_5-ascore_6;
                                }
                                if(iniCnt==8 && ini_num%2==1) {
                                    ascore_8 = ascore-ascore_1-ascore_2-ascore_3-ascore_4-ascore_5-ascore_6-ascore_7;
                                }
                                if(iniCnt==9 && ini_num%2==1) {
                                    ascore_9 = ascore-ascore_1-ascore_2-ascore_3-ascore_4-ascore_5-ascore_6-ascore_7-ascore_8;
                                }


                                a++;//away ??? ++
                                handler.postDelayed(new Runnable() { // ?????? ?????? ???????????? ???????????? 0.5??? ?????????
                                    @Override
                                    public void run() {
                                        if(iniCnt > 1) {
                                            h = h - 1;
                                        }
                                        et_out.setText("O ");
                                        outCnt = 0;
                                        img0.setText(home_arr[h]);

                                        img0.setVisibility(View.VISIBLE);
                                        img1.setVisibility(View.INVISIBLE);
                                        img2.setVisibility(View.INVISIBLE);
                                        img3.setVisibility(View.INVISIBLE);
                                        runCnt = 0;
                                        Toast.makeText(BSOActivity.this, choice_home + " ??????", Toast.LENGTH_SHORT).show();
                                    }
                                }, 500);

                                ini_num++;
                                et_ini.setText(Integer.toString(iniCnt) + "??????    " + ini[ini_num]);
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
                            TeamRequest teamRequest = new TeamRequest(choice_away, away_ball,away_strike, away_outout, responseListener);
                            RequestQueue queue = Volley.newRequestQueue(BSOActivity.this);
                            queue.add(teamRequest);
                        }

                        else if(ini_num%2==0) {
                            outCnt++;
                            h++;
                            if(h>8) {
                                h=0;
                            }
                            home_outout++;
                            if(outCnt < 3) {
                                img0.setText(home_arr[h]);
                            }

                            et_out.setText(et_out.getText().toString() + "*"); // ??? ??????
                            et_strike.setText("S ");
                            stkCnt = 0;
                            et_ball.setText("B ");
                            ballCnt = 0;
                            if (outCnt == 3) {
                                if (iniCnt>=9&&ascore!=hscore) {

                                    Intent intent = new Intent(BSOActivity.this, ReusltActivity.class);
                                    startActivity(intent);

                                    finish();

                                    Toast.makeText(BSOActivity.this,"?????? ??????", Toast.LENGTH_SHORT).show();
                                }
                                PithcerReqeust_Ining_Away PithcerReqeust_Ining_Away = new PithcerReqeust_Ining_Away(choice_away, choice_home, away_pitcher, responseListener);
                                RequestQueue queue6 = Volley.newRequestQueue(BSOActivity.this);
                                queue6.add(PithcerReqeust_Ining_Away);

                                if(iniCnt==1 && ini_num%2==0) {
                                    hscore_1 = hscore;
                                }
                                if(iniCnt==2 && ini_num%2==0) {
                                    hscore_2 = hscore-hscore_1;
                                }
                                if(iniCnt==3 && ini_num%2==0) {
                                    hscore_3 = hscore-hscore_1-hscore_2;
                                }
                                if(iniCnt==4 && ini_num%2==0) {
                                    hscore_4 = hscore-hscore_1-hscore_2-hscore_3;
                                }
                                if(iniCnt==5 && ini_num%2==0) {
                                    hscore_5 = hscore-hscore_1-hscore_2-hscore_3-hscore_4;
                                }
                                if(iniCnt==6 && ini_num%2==0) {
                                    hscore_6 = hscore-hscore_1-hscore_2-hscore_3-hscore_4-hscore_5;
                                }
                                if(iniCnt==7 && ini_num%2==0) {
                                    hscore_7 = hscore-hscore_1-hscore_2-hscore_3-hscore_4-hscore_5-hscore_6;
                                }
                                if(iniCnt==8 && ini_num%2==0) {
                                    hscore_8 = hscore-hscore_1-hscore_2-hscore_3-hscore_4-hscore_5-hscore_6-hscore_7;
                                }
                                if(iniCnt==9 && ini_num%2==0) {
                                    hscore_9 = hscore-hscore_1-hscore_2-hscore_3-hscore_4-hscore_5-hscore_6-hscore_7-hscore_8;
                                }

                                h++;//home ??? ++
                                handler.postDelayed(new Runnable() { // ?????? ?????? ???????????? ???????????? 0.5??? ?????????
                                    @Override
                                    public void run() {
                                        if(iniCnt > 1) {
                                            a = a - 1;
                                        }
                                        et_out.setText("O ");
                                        outCnt = 0;
                                        img0.setText(away_arr[a]);
                                        img0.setVisibility(View.VISIBLE);
                                        img1.setVisibility(View.INVISIBLE);
                                        img2.setVisibility(View.INVISIBLE);
                                        img3.setVisibility(View.INVISIBLE);
                                        runCnt=0;
                                        //Toast.makeText(BSOActivity.this, choice_away + " ??????", Toast.LENGTH_SHORT).show();
                                    }
                                }, 500);



                                iniCnt++; // ?????? ????????? ++

                                ini_num++;
                                et_ini.setText(Integer.toString(iniCnt) + "??????    " + ini[ini_num]);
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

                            TeamRequest teamRequest = new TeamRequest(choice_home, home_ball, home_strike, home_outout, responseListener);
                            RequestQueue queue = Volley.newRequestQueue(BSOActivity.this);
                            queue.add(teamRequest);
                        }
                    }
                });

                btn_other.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ini_num % 2 == 1) {
                            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                            Others others_fragment = new Others();
                            transaction.replace(R.id.frame, others_fragment);
                            transaction.commit();
                            btn_SBO.setVisibility(View.INVISIBLE);

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
                            TeamRequest teamRequest = new TeamRequest(choice_away, away_ball,away_strike, away_outout, responseListener);
                            RequestQueue queue = Volley.newRequestQueue(BSOActivity.this);
                            queue.add(teamRequest);
                        }
                        if(ini_num%2==0) {

                            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                            Others others_fragment = new Others();
                            transaction.replace(R.id.frame, others_fragment);
                            transaction.commit();
                            btn_SBO.setVisibility(View.INVISIBLE);

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
                            TeamRequest teamRequest = new TeamRequest(choice_home, home_ball, home_strike, home_outout, responseListener);
                            RequestQueue queue = Volley.newRequestQueue(BSOActivity.this);
                            queue.add(teamRequest);
                        }
                    }
                });

                btn_h.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(ini_num%2==1) {
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
                            HitRequest_away HitRequest_away = new HitRequest_away(choice_away, choice_home, away_arr[a], responseListener);
                            RequestQueue queue = Volley.newRequestQueue(BSOActivity.this);
                            queue.add(HitRequest_away);

                            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                            Inplay inplay_fragment = new Inplay();
                            transaction.replace(R.id.frame, inplay_fragment);
                            transaction.commit();
                            btn_SBO.setVisibility(View.INVISIBLE);

                        }
                        if(ini_num%2==0) {

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
                            HitRequest_home HitRequest_home = new HitRequest_home(choice_away, choice_home, home_arr[h], responseListener);
                            RequestQueue queue1 = Volley.newRequestQueue(BSOActivity.this);
                            queue1.add(HitRequest_home);

                            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                            Inplay inplay_fragment = new Inplay();
                            transaction.replace(R.id.frame, inplay_fragment);
                            transaction.commit();
                            btn_SBO.setVisibility(View.INVISIBLE);


                            TeamRequest teamRequest = new TeamRequest(choice_home, home_ball, home_strike, home_outout, responseListener);
                            RequestQueue queue = Volley.newRequestQueue(BSOActivity.this);
                            queue.add(teamRequest);
                        }
                    }
                });



                /*img0.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(ini_num%2==1) {
                            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                            Batplay batplay_fragment = new Batplay();
                            transaction.replace(R.id.frame, batplay_fragment);
                            transaction.commit();
                            btn_SBO.setVisibility(View.INVISIBLE);

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
                            TeamRequest teamRequest = new TeamRequest(choice_away, away_ball,away_strike, away_outout, responseListener);
                            RequestQueue queue = Volley.newRequestQueue(BSOActivity.this);
                            queue.add(teamRequest);
                            //hi
                        }
                        if(ini_num%2==0) {

                            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                            Strike strike_fragment = new Strike();
                            transaction.replace(R.id.frame, strike_fragment);
                            transaction.commit();
                            btn_SBO.setVisibility(View.INVISIBLE);
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
                            TeamRequest teamRequest = new TeamRequest(choice_home, home_ball, home_strike, home_outout, responseListener);
                            RequestQueue queue = Volley.newRequestQueue(BSOActivity.this);
                            queue.add(teamRequest);
                        }
                    }
                });*/

                img1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        HitActivity1 Hitter1_fragment = new HitActivity1();
                        transaction.replace(R.id.frame, Hitter1_fragment);
                        transaction.commit();
                        btn_SBO.setVisibility(View.INVISIBLE);
                    }
                });

                 img2.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                         HitActivity2 Hitter2_fragment = new HitActivity2();
                         transaction.replace(R.id.frame, Hitter2_fragment);
                         transaction.commit();
                         btn_SBO.setVisibility(View.INVISIBLE);
                     }
                 });

                img3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        HitActivity3 Hitter3_fragment = new HitActivity3();
                        transaction.replace(R.id.frame, Hitter3_fragment);
                        transaction.commit();
                        btn_SBO.setVisibility(View.INVISIBLE);
                    }
                });



            if(hscore > ascore) {
                WINNER = choice_home;
                LOSER = choice_away;
                win_score = hscore;
                los_score = ascore;
            }
            if(ascore > hscore) {
                WINNER = choice_away;
                LOSER = choice_home;
                win_score = ascore;
                los_score = hscore;
            }















       /* oCnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BSOActivity.this,Integer.toString(runCnt), Toast.LENGTH_SHORT).show();
                //replaceSDT();
            }
        });
    */

            }
        }

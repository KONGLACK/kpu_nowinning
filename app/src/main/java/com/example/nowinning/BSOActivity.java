package com.example.nowinning;

// 주석연습 qewrqwerqew
//
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

import static com.example.nowinning.start.home_player1;
import static com.example.nowinning.start.home_player2;
import static com.example.nowinning.start.home_player3;
import static com.example.nowinning.start.home_player4;
import static com.example.nowinning.start.home_player5;
import static com.example.nowinning.start.home_player6;
import static com.example.nowinning.start.home_player7;
import static com.example.nowinning.start.home_player8;
import static com.example.nowinning.start.home_player9;

public class BSOActivity extends AppCompatActivity {

    public static EditText et_strike, et_ball, et_out, et_hscore, et_ascore, et_ini;
    public static Button btn_s, btn_b, btn_other, btn_h , btn_o, btn_Undo,oCnt, btn_away, btn_home;
    public static Button img1, img2, img3, img0;
    public static Button img4, img5, img6, img7;
    public static String WINNER, LOSER;

    public static LinearLayout btn_SBO;
    public static ConstraintLayout layout_field;

    public int i,j;
    public static int hhit_by_pitch, ahit_by_pitch; //홈 사구, 어웨이 사구
    public static int stkCnt, ballCnt, outCnt; //sCnt, bCnt, oCnt은 다른 곳에서도 쓰일 거 같아서 퍼블릭
    public static int hscore, ascore; // 해당 이닝에 발생한 점수
    public static int runCnt = 0; // 진루 카운트를 통해 진루 컨트롤
    public static int iniCnt = 1; // 이닝 카운트를 통해 현재 이닝 표시
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
    public static int[] away_hitCount = new int[9];
    public static int[] home_hitCount = new int[9];
    public static String[] ini = {"말", "초", "말", "초", "말", "초", "말", "초", "말", "초", "말", "초", "말", "초", "말", "초", "말",
            "초", "말", "초", "말", "초", "말", "초", "말", "초", "말"};
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
    // 안드로이드 생명주기 확인 로그



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
        btn_Undo =(Button) findViewById(R.id.btn_Undo);
        layout_field = (ConstraintLayout) findViewById(R.id.layout_field);
        //oCnt = (Button)findViewById(R.id.cnt_button);

        et_hscore.setText("홈      " + choice_home + " 0");
        et_ascore.setText("원정   " + choice_away + " 0");
//        btn_away.setText(choice_away);
//        btn_home.setText(choice_home);

        runCnt = 0;
        img0.setText(away_arr[a]);
        img0.setVisibility(View.VISIBLE);
        img1.setVisibility(View.INVISIBLE);
        img2.setVisibility(View.INVISIBLE);
        img3.setVisibility(View.INVISIBLE);
        //hihiㄹㅇ
        //okhihi
        // PHP 타율 계산 처리 (ONE+TWO+THREE)/Hit 형태

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
                            Log.d("어웨이스트라이크값", away_strike+"");


                            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                            Strike strike_fragment = new Strike();
                            transaction.replace(R.id.frame, strike_fragment);
                            transaction.commit();
                            btn_SBO.setVisibility(View.INVISIBLE);


                        }
                        if(ini_num%2==0) {
                            home_strike++;
                            Log.d("홈스트라이크값", home_strike+"");


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

                            et_ball.setText(et_ball.getText().toString() + "*"); // 별 찍음
                            ballCnt++; //스트라이크 카운트 세기 위해
                            if (ballCnt == 4) {
                                handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                    @Override
                                    public void run() {
                                        et_ball.setText("B ");
                                        ballCnt = 0;
                                    }
                                }, 500);

                                if (runCnt == 0) { // 주자의 현재 위치
                                    a++;
                                    if(a>8) {
                                        a=0;
                                    }
                                    img1.setText(img0.getText());
                                    img0.setText(away_arr[a]);
                                    img0.setVisibility(View.VISIBLE);
                                    img1.setVisibility(View.VISIBLE);
                                    img2.setVisibility(View.INVISIBLE);
                                    img3.setVisibility(View.INVISIBLE); // 주자 1루로 이동

                                    runCnt = 1;

                                    stkCnt = 0;
                                    ballCnt = 0;
                                } else if (runCnt == 1) {// 주자의 현재 위치
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
                                    img3.setVisibility(View.INVISIBLE);   // 주자 2루로 이동

                                    runCnt = 4; // 주자 1,2루

                                    stkCnt = 0;
                                    ballCnt = 0;


                                } else if (runCnt == 2) { // 주자의 현재 위치
                                    a++;
                                    if(a>8) {
                                        a=0;
                                    }
                                    img1.setText(img0.getText());
                                    img0.setText(away_arr[a]);
                                    img0.setVisibility(View.VISIBLE);
                                    img1.setVisibility(View.VISIBLE);
                                    img2.setVisibility(View.VISIBLE);
                                    img3.setVisibility(View.INVISIBLE);  // 주자 3루로 이동

                                    runCnt = 4; //주자 2,3루
                                    stkCnt = 0;
                                    ballCnt = 0;


                                } else if (runCnt == 3) {// 주자의 현재 위치
                                    a++;
                                    if(a>8) {
                                        a=0;
                                    }

                                    img1.setText(img0.getText());
                                    img0.setText(away_arr[a]);
                                    img0.setVisibility(View.VISIBLE);
                                    img1.setVisibility(View.VISIBLE);
                                    img2.setVisibility(View.INVISIBLE);
                                    img3.setVisibility(View.INVISIBLE); //주자 1루로 이동

                                    runCnt = 6; //주자 1루



                                    stkCnt = 0;
                                    ballCnt = 0;

                                } else if (runCnt == 4) {// 주자의 현재 위치
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
                                    img3.setVisibility(View.VISIBLE);// 주자 1,2,3루로 이동

                                    runCnt = 7;

                                    stkCnt = 0;
                                    ballCnt = 0;


                                } else if (runCnt == 5) {// 주자의 현재 위치
                                    a++;
                                    if(a>8) {
                                        a=0;
                                    }

                                    img1.setText(img0.getText());
                                    img0.setText(away_arr[a]);
                                    img0.setVisibility(View.VISIBLE);
                                    img1.setVisibility(View.VISIBLE);
                                    img2.setVisibility(View.VISIBLE);
                                    img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                                    runCnt = 7;



                                    stkCnt = 0;
                                    ballCnt = 0;

                                } else if (runCnt == 6) {// 주자의 현재 위치
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
                                    img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                                    runCnt = 7;


                                    stkCnt = 0;
                                    ballCnt = 0;

                                } else if (runCnt == 7) {// 주자의 현재 위치
                                    RBIRequest RBIRequest = new RBIRequest(choice_away, away_arr[a], responseListener);
                                    RequestQueue queue = Volley.newRequestQueue(BSOActivity.this);
                                    queue.add(RBIRequest);

                                    ScoreRequest ScoreRequest = new ScoreRequest(choice_away, (String) img3.getText(), responseListener);
                                    RequestQueue queue1 = Volley.newRequestQueue(BSOActivity.this);
                                    queue1.add(ScoreRequest);
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
                                    img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                                    runCnt = 7;

                                    handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                        @Override
                                        public void run() {
                                            hscore++;
                                            et_hscore.setText("홈      " + choice_home + Integer.toString(hscore));
                                        }
                                    }, 500);
                                    stkCnt = 0;
                                    ballCnt = 0;
                                }
                            }

                        }
                        if (ini_num % 2 == 0) {
                            home_ball++;

                            et_ball.setText(et_ball.getText().toString() + "*"); // 별 찍음
                            ballCnt++; //스트라이크 카운트 세기 위해
                            if (ballCnt == 4) {
                                handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                    @Override
                                    public void run() {
                                        et_ball.setText("B ");
                                        ballCnt = 0;
                                    }
                                }, 500);

                                if (runCnt == 0) { // 주자의 현재 위치
                                    h++;
                                    if(h>8) {
                                        h=0;
                                    }
                                    img1.setText(img0.getText());
                                    img0.setText(home_arr[h]);
                                    img0.setVisibility(View.VISIBLE);
                                    img1.setVisibility(View.VISIBLE);
                                    img2.setVisibility(View.INVISIBLE);
                                    img3.setVisibility(View.INVISIBLE); // 주자 1루로 이동

                                    runCnt = 1;

                                    stkCnt = 0;
                                    ballCnt = 0;
                                } else if (runCnt == 1) {// 주자의 현재 위치
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
                                    img3.setVisibility(View.INVISIBLE);   // 주자 2루로 이동

                                    runCnt = 4; // 주자 1,2루

                                    stkCnt = 0;
                                    ballCnt = 0;


                                } else if (runCnt == 2) { // 주자의 현재 위치
                                    h++;
                                    if(h>8) {
                                        h=0;
                                    }
                                    img1.setText(img0.getText());
                                    img0.setText(home_arr[h]);
                                    img0.setVisibility(View.VISIBLE);
                                    img1.setVisibility(View.VISIBLE);
                                    img2.setVisibility(View.VISIBLE);
                                    img3.setVisibility(View.INVISIBLE);  // 주자 3루로 이동

                                    runCnt = 4; //주자 2,3루
                                    stkCnt = 0;
                                    ballCnt = 0;


                                } else if (runCnt == 3) {// 주자의 현재 위치
                                    h++;
                                    if(h>8) {
                                        h=0;
                                    }
                                    img1.setText(img0.getText());
                                    img0.setText(home_arr[h]);
                                    img0.setVisibility(View.VISIBLE);
                                    img1.setVisibility(View.VISIBLE);
                                    img2.setVisibility(View.INVISIBLE);
                                    img3.setVisibility(View.INVISIBLE); //주자 1루로 이동

                                    runCnt = 6; //주자 1루



                                    stkCnt = 0;
                                    ballCnt = 0;

                                } else if (runCnt == 4) {// 주자의 현재 위치
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
                                    img3.setVisibility(View.VISIBLE);// 주자 1,2,3루로 이동

                                    runCnt = 7;

                                    stkCnt = 0;
                                    ballCnt = 0;


                                } else if (runCnt == 5) {// 주자의 현재 위치
                                    h++;
                                    if(h>8) {
                                        h=0;
                                    }
                                    img1.setText(img0.getText());
                                    img0.setText(home_arr[h]);
                                    img0.setVisibility(View.VISIBLE);
                                    img1.setVisibility(View.VISIBLE);
                                    img2.setVisibility(View.VISIBLE);
                                    img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                                    runCnt = 7;



                                stkCnt = 0;
                                ballCnt = 0;

                            } else if (runCnt == 6) {// 주자의 현재 위치

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
                                img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                                    runCnt = 7;


                                stkCnt = 0;
                                ballCnt = 0;

                            } else if (runCnt == 7) {// 주자의 현재 위치
                                    RBIRequest RBIRequest = new RBIRequest(choice_home, home_arr[h], responseListener);
                                    RequestQueue queue = Volley.newRequestQueue(BSOActivity.this);
                                    queue.add(RBIRequest);

                                    ScoreRequest ScoreRequest = new ScoreRequest(choice_home, (String) img3.getText(), responseListener);
                                    RequestQueue queue1 = Volley.newRequestQueue(BSOActivity.this);
                                    queue1.add(ScoreRequest);
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
                                img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                                    runCnt = 7;

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
                            a++;
                            if(a>8) {
                                a=0;
                            }
                            img0.setText(away_arr[a]);
                            away_outout++;
                            Log.d("어웨이아웃값", away_outout+"");


                            et_out.setText(et_out.getText().toString() + "*"); // 별 찍음
                            outCnt++; //스트라이크 카운트 세기 위해
                            et_strike.setText("S ");
                            stkCnt = 0;
                            et_ball.setText("B ");
                            ballCnt = 0;
                            if (outCnt == 3) {
                                if (iniCnt>=9&&ascore!=hscore) {
                                    Intent intent = new Intent(BSOActivity.this, GameSet.class);
                                    startActivity(intent);

                                    Toast.makeText(BSOActivity.this,"게임 종료", Toast.LENGTH_SHORT).show();
                                }

                                a++;//away 값 ++
                                handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                    @Override
                                    public void run() {
                                        et_out.setText("O ");
                                        outCnt = 0;
                                        img0.setText(home_arr[h]);

                                        img0.setVisibility(View.VISIBLE);
                                        img1.setVisibility(View.INVISIBLE);
                                        img2.setVisibility(View.INVISIBLE);
                                        img3.setVisibility(View.INVISIBLE);
                                        runCnt = 0;
                                        Toast.makeText(BSOActivity.this, choice_home + " 공격", Toast.LENGTH_SHORT).show();
                                    }
                                }, 500);
                                if(ini_num%2==0) {
                                    iniCnt++; // 주루 카운트 ++
                                }
                                ini_num++;
                                et_ini.setText(Integer.toString(iniCnt) + "이닝    " + ini[ini_num]);
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
                            h++;
                            if(h>8) {
                                h=0;
                            }
                            home_outout++;
                            img0.setText(home_arr[h]);

                            et_out.setText(et_out.getText().toString() + "*"); // 별 찍음
                            outCnt++; //스트라이크 카운트 세기 위해
                            et_strike.setText("S ");
                            stkCnt = 0;
                            et_ball.setText("B ");
                            ballCnt = 0;
                            if (outCnt == 3) {
                                if (iniCnt>=9&&ascore!=hscore) {
                                    Intent intent = new Intent(BSOActivity.this, GameSet.class);
                                    startActivity(intent);

                                    Toast.makeText(BSOActivity.this,"게임 종료", Toast.LENGTH_SHORT).show();
                                }

                                h++;//home 값 ++
                                handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                    @Override
                                    public void run() {
                                        et_out.setText("O ");
                                        outCnt = 0;
                                        img0.setText(away_arr[a]);
                                        img0.setVisibility(View.VISIBLE);
                                        img1.setVisibility(View.INVISIBLE);
                                        img2.setVisibility(View.INVISIBLE);
                                        img3.setVisibility(View.INVISIBLE);
                                        runCnt=0;
                                        //Toast.makeText(BSOActivity.this, choice_away + " 공격", Toast.LENGTH_SHORT).show();
                                    }
                                }, 500);


                                if(ini_num%2==0) {
                                    iniCnt++; // 주루 카운트 ++
                                }
                                ini_num++;
                                et_ini.setText(Integer.toString(iniCnt) + "이닝    " + ini[ini_num]);
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
                            HitRequest HitRequest = new HitRequest(choice_away, away_arr[a], responseListener);
                            RequestQueue queue = Volley.newRequestQueue(BSOActivity.this);
                            queue.add(HitRequest);

                            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                            Inplay inplay_fragment = new Inplay();
                            transaction.replace(R.id.frame, inplay_fragment);
                            transaction.commit();
                            btn_SBO.setVisibility(View.INVISIBLE);

                        }
                        if(ini_num%2==0) {

                            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                            Inplay inplay_fragment = new Inplay();
                            transaction.replace(R.id.frame, inplay_fragment);
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


        btn_Undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction2= getSupportFragmentManager().beginTransaction();
                DefenceActivity Defence_fragment = new DefenceActivity();
                transaction2.replace(R.id.frame2, Defence_fragment);
                transaction2.commit();
                layout_field.setVisibility(View.INVISIBLE);
            }
        });






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

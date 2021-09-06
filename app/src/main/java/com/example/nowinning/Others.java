package com.example.nowinning;

import android.content.Intent;
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
import static com.example.nowinning.BSOActivity.et_hscore;
import static com.example.nowinning.BSOActivity.et_ini;
import static com.example.nowinning.BSOActivity.et_out;
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
import static com.example.nowinning.BSOActivity.iniCnt;
import static com.example.nowinning.BSOActivity.ini_num;
import static com.example.nowinning.BSOActivity.outCnt;
import static com.example.nowinning.BSOActivity.runCnt;
import static com.example.nowinning.BSOActivity.stkCnt;
import static com.example.nowinning.start.away_pitcher;
import static com.example.nowinning.start.choice_away;
import static com.example.nowinning.start.choice_home;
import static com.example.nowinning.start.home_pitcher;


public class Others extends Fragment {

    public static Button btn_HBP, btn_Balk, btn_OutOthers, btn_PutonB, btn_test;
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

        layout_Others = (LinearLayout) v.findViewById(R.id.layout_Others);


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
                    Toast.makeText(getActivity(),"이닝 카운트가 8 증가합니다", Toast.LENGTH_SHORT).show();
                }
                /*FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                TestBtn testbtn = new TestBtn();
                transaction.replace(R.id.frame, testbtn);
                transaction.commit(); // */ //테스트 페이지 만들려면 살리세요
            }
        });

        btn_HBP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ini_num % 2 == 1) {

                    PithcerReqeust_HBP_Home PithcerReqeust_HBP_Home = new PithcerReqeust_HBP_Home(choice_away, choice_home, home_pitcher, responseListener);
                    RequestQueue queue4 = Volley.newRequestQueue(getContext());
                    queue4.add(PithcerReqeust_HBP_Home);

                    ahit_by_pitch++; //어웨이 사구 증가

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
                                    et_hscore.setText("홈      " + choice_away + Integer.toString(ascore));
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
                    hhit_by_pitch++; //홈 사구 증가

                    PithcerReqeust_HBP_Away PithcerReqeust_HBP_Away = new PithcerReqeust_HBP_Away(choice_away, choice_home, away_pitcher, responseListener);
                    RequestQueue queue4 = Volley.newRequestQueue(getContext());
                    queue4.add(PithcerReqeust_HBP_Away);

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

                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    hscore++;
                                    et_hscore.setText("홈      " + choice_home + Integer.toString(hscore));
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
                //다른 사유로 진루할 때 S/D/O 선택 후 알맞은 진루
                //사유를 적을 수 있게하는 것도 좋을듯
                layout_Others.setVisibility(View.INVISIBLE);
                btn_SBO.setVisibility(View.VISIBLE);
            }
        });

        return v;
    }
}
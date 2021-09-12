package com.example.nowinning;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static com.example.nowinning.BSOActivity.bat_select;
import static com.example.nowinning.BSOActivity.btn_SBO;
import static com.example.nowinning.BSOActivity.img0;
import static com.example.nowinning.BSOActivity.img1;
import static com.example.nowinning.BSOActivity.img2;
import static com.example.nowinning.BSOActivity.img3;
import static com.example.nowinning.BSOActivity.runCnt;


public class HitActivity2_Run extends Fragment {

    public static Button btn_hit2_run1, btn_hit2_run2, btn_hit2_run3, btn_hit2_run4;// 도루, 태그업, 희생 번트, 수비 에러
    public static int hit1_run1, hit1_run2, hit1_run3, hit1_run4; // 도루, 태그업, 희생 번트, 수비 에러 각각 카운터
    public static LinearLayout layout_hit2_run; // 플라이아웃 프래그먼트

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.hitter2_run, container, false);

        btn_hit2_run1 = (Button) v.findViewById(R.id.btn_hit2_run1);
        btn_hit2_run2 = (Button) v.findViewById(R.id.btn_hit2_run2);
        btn_hit2_run3 = (Button) v.findViewById(R.id.btn_hit2_run3);
        btn_hit2_run4 = (Button) v.findViewById(R.id.btn_hit2_run4);

        layout_hit2_run = (LinearLayout) v.findViewById(R.id.layout_hit2_run);

        Handler handler = new Handler();

        if (bat_select[0] != 2) { //(ground:0/ hground:1/ bunt:2/ fly:3/ pop: 4)
            btn_hit2_run3.setVisibility(View.GONE);
        }

        if (bat_select[0] != 3) { //(ground:0/ hground:1/ bunt:2/ fly:3/ pop: 4)
            btn_hit2_run2.setVisibility(View.GONE);
        }


        btn_hit2_run1.setOnClickListener(new View.OnClickListener() {//도루
            @Override
            public void onClick(View v) {

                if (runCnt == 1) {// 주자의 현재 위치
                    img2.setText(img1.getText());
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.INVISIBLE);   // 주자 2루로 이동

                    runCnt = 2; // 주자 2루

                    hit1_run1++; //주자, 투수 도루++


                    layout_hit2_run.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 4) {// 주자의 현재 위치
                    Toast.makeText(getActivity(),"현재 상황에서 진루할 수 없습니다.", Toast.LENGTH_SHORT).show();

                }


                else if (runCnt == 6) {// 주자의 현재 위치
                    img2.setText(img1.getText());
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.VISIBLE);  // 주자 2,3루로 이동

                    runCnt = 5;
                    hit1_run1++; //주자, 투수 도루++

                    layout_hit2_run.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 7) {// 주자의 현재 위치
                    Toast.makeText(getActivity(),"others의 전체 진루버튼 활용", Toast.LENGTH_SHORT).show();

                }

            }
        });
        btn_hit2_run2.setOnClickListener(new View.OnClickListener() {//태그업 bat_select가 fly여야지 작동
            @Override
            public void onClick(View v) {

                if (runCnt == 1) {// 주자의 현재 위치
                    img2.setText(img1.getText());
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.INVISIBLE);   // 주자 2루로 이동

                    runCnt = 2; // 주자 2루
                    hit1_run2++; //주자, 투수 태그업++


                    layout_hit2_run.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 4) {// 주자의 현재 위치
                    Toast.makeText(getActivity(),"현재 상황에서 진루할 수 없습니다.", Toast.LENGTH_SHORT).show();

                }


                else if (runCnt == 6) {// 주자의 현재 위치
                    img2.setText(img1.getText());
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.VISIBLE);  // 주자 1루로 이동

                    runCnt = 5;
                    hit1_run2++; //주자, 투수 태그업++

                    layout_hit2_run.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 7) {// 주자의 현재 위치
                    Toast.makeText(getActivity(),"others의 전체 진루버튼 활용", Toast.LENGTH_SHORT).show();

                }

            }
        });
        btn_hit2_run3.setOnClickListener(new View.OnClickListener() {//희생 번트 bat_select가 bunt여야지 작동
            @Override
            public void onClick(View v) {

                if (runCnt == 1) {// 주자의 현재 위치
                    img2.setText(img1.getText());
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.INVISIBLE);   // 주자 2루로 이동

                    runCnt = 2; // 주자 2루

                    hit1_run3++; //타자, 투수 희생번트++


                    layout_hit2_run.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 4) {// 주자의 현재 위치
                    Toast.makeText(getActivity(),"현재 상황에서 진루할 수 없습니다.", Toast.LENGTH_SHORT).show();

                }


                else if (runCnt == 6) {// 주자의 현재 위치
                    img2.setText(img1.getText());
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.VISIBLE);  // 주자 1루로 이동

                    runCnt = 5;
                    hit1_run1++; //타자, 투수 도루++

                    layout_hit2_run.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 7) {// 주자의 현재 위치
                    Toast.makeText(getActivity(),"others의 전체 진루버튼 활용", Toast.LENGTH_SHORT).show();

                }

            }
        });
        btn_hit2_run4.setOnClickListener(new View.OnClickListener() {//에러
            @Override
            public void onClick(View v) {

                if (runCnt == 1) {// 주자의 현재 위치
                    img2.setText(img1.getText());
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.INVISIBLE);   // 주자 2루로 이동

                    runCnt = 2; // 주자 2루
                    hit1_run4++; //선택 수비수 에러++ -> 수비수 선택 프라그먼트 필요


                    layout_hit2_run.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 4) {// 주자의 현재 위치
                    Toast.makeText(getActivity(),"현재 상황에서 진루할 수 없습니다.", Toast.LENGTH_SHORT).show();

                }


                else if (runCnt == 6) {// 주자의 현재 위치
                    img2.setText(img1.getText());
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.VISIBLE);  // 주자 1루로 이동

                    runCnt = 5;
                    hit1_run4++; //선택 수비수 에러++ -> 수비수 선택 프라그먼트 필요

                    layout_hit2_run.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 7) {// 주자의 현재 위치
                    Toast.makeText(getActivity(),"others의 전체 진루버튼 활용", Toast.LENGTH_SHORT).show();

                }

            }
        });


       /* btn_buntout_sac.setOnClickListener(new View.OnClickListener() { // 타자는 아웃 됐지만 진루가 됨
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
                    outCnt++;   //아웃 카운트 세기 위해

                    //----------------------------------------------
                    buntout_sac_Cnt++; //여기가 희생 플라이 카운터

                    switch (runCnt){
                        case 1: runCnt = 3;
                            // runcnt가 3일때 1명이 진루하여 득점하는 상황을 넣어야함
                        case 2: runCnt = 5;
                            // runcnt가 5일때 1명이 진루하여 득점하는 상황을 넣어야함
                        case 3: runCnt = 6;
                            // runcnt가 6일때 1명이 진루하여 득점하는 상황을 넣어야함
                        case 4: runCnt = 7;
                            // runcnt가 7일때 1명이 진루하여 득점하는 상황을 넣어야함

                    }
                    //-----------------------------------------------

                    et_strike.setText("S "); //스트라이크 초기화
                    stkCnt = 0;
                    et_ball.setText("B "); //볼 값 초기화
                    ballCnt = 0;
                    if (outCnt == 3) {
                        if (iniCnt>=9&&ascore!=hscore) {
                            Intent intent = new Intent(getActivity(), GameSet.class);
                            startActivity(intent);

                            Toast.makeText(getActivity(),"게임 종료", Toast.LENGTH_SHORT).show();
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
                                Toast.makeText(getActivity(), choice_home + " 공격", Toast.LENGTH_SHORT).show();
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
                    RequestQueue queue = Volley.newRequestQueue(getActivity());
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

                    //----------------------------------------------
                    buntout_sac_Cnt++; //여기가 희생 플라이 카운터
                    //-----------------------------------------------

                    et_strike.setText("S ");
                    stkCnt = 0;
                    et_ball.setText("B ");
                    ballCnt = 0;
                    if (outCnt == 3) {
                        if (iniCnt>=9&&ascore!=hscore) {
                            Intent intent = new Intent(getActivity(), GameSet.class);
                            startActivity(intent);

                            Toast.makeText(getActivity(),"게임 종료", Toast.LENGTH_SHORT).show();
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
                    RequestQueue queue = Volley.newRequestQueue(getActivity());
                    queue.add(teamRequest);
                }

                btn_SBO.setVisibility(View.VISIBLE);
                layout_buntout.setVisibility(View.INVISIBLE);
            }
        });


        return v;
    }*/

        return v;
    }
}

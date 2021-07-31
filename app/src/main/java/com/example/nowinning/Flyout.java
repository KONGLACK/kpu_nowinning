package com.example.nowinning;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
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
import static com.example.nowinning.BSOActivity.ascore;
import static com.example.nowinning.BSOActivity.away_arr;
import static com.example.nowinning.BSOActivity.away_outout;
import static com.example.nowinning.BSOActivity.et_ball;
import static com.example.nowinning.BSOActivity.et_ini;
import static com.example.nowinning.BSOActivity.h;
import static com.example.nowinning.BSOActivity.home_arr;
import static com.example.nowinning.BSOActivity.hscore;
import static com.example.nowinning.BSOActivity.img0;
import static com.example.nowinning.BSOActivity.img1;
import static com.example.nowinning.BSOActivity.img2;
import static com.example.nowinning.BSOActivity.img3;
import static com.example.nowinning.BSOActivity.ini;
import static com.example.nowinning.BSOActivity.iniCnt;
import static com.example.nowinning.BSOActivity.ini_num;
import static com.example.nowinning.Others.btn_OutOthers;
import static com.example.nowinning.BSOActivity.btn_SBO;
import static com.example.nowinning.BSOActivity.btn_h;
import static com.example.nowinning.BSOActivity.btn_o;
import static com.example.nowinning.BSOActivity.btn_other;
import static com.example.nowinning.BSOActivity.et_out;
import static com.example.nowinning.BSOActivity.et_strike;
import static com.example.nowinning.BSOActivity.outCnt;
import static com.example.nowinning.BSOActivity.stkCnt;
import static com.example.nowinning.start.choice_away;
import static com.example.nowinning.start.choice_home;

public class Flyout extends Fragment {

    public static Button btn_flyout, btn_flyout_sac;
    public static int flyout, flyout_sac; // 희생 플라이 판별
    public static LinearLayout layout_flyout; // 플라이아웃 프래그먼트

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_flyout, container, false);

        btn_flyout = (Button) v.findViewById(R.id.btn_flyout);
        btn_flyout_sac = (Button) v.findViewById(R.id.btn_flyout_sac);

        layout_flyout=(LinearLayout) v.findViewById(R.id.layout_flyout);

        Handler handler = new Handler();


        flyout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_o.performClick();

                btn_SBO.setVisibility(View.VISIBLE);
                layout_flyout.setVisibility(View.INVISIBLE);

            }
        });

        flyout_sac.setOnClickListener(new View.OnClickListener() { // 타자가 스트라이크 존에 들어온 공에 타격을 시도하지 않은 경우
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

                btn_SBO.setVisibility(View.VISIBLE);
                layout_flyout.setVisibility(View.INVISIBLE);
            }
        });


        return v;
    }


}
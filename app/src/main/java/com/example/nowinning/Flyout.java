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
import static com.example.nowinning.BSOActivity.away_ball;
import static com.example.nowinning.BSOActivity.away_outout;
import static com.example.nowinning.BSOActivity.away_strike;
import static com.example.nowinning.BSOActivity.ballCnt;
import static com.example.nowinning.BSOActivity.et_ball;
import static com.example.nowinning.BSOActivity.et_ini;
import static com.example.nowinning.BSOActivity.bat_select;
import static com.example.nowinning.BSOActivity.h;
import static com.example.nowinning.BSOActivity.home_arr;
import static com.example.nowinning.BSOActivity.home_ball;
import static com.example.nowinning.BSOActivity.home_outout;
import static com.example.nowinning.BSOActivity.home_strike;
import static com.example.nowinning.BSOActivity.hscore;
import static com.example.nowinning.BSOActivity.img0;
import static com.example.nowinning.BSOActivity.img1;
import static com.example.nowinning.BSOActivity.img2;
import static com.example.nowinning.BSOActivity.img3;
import static com.example.nowinning.BSOActivity.ini;
import static com.example.nowinning.BSOActivity.iniCnt;
import static com.example.nowinning.BSOActivity.ini_num;
import static com.example.nowinning.BSOActivity.runCnt;
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
    public static int flyout_sac_Cnt; // ?????? ????????? ??????
    public static LinearLayout layout_flyout; // ??????????????? ???????????????

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_flyout, container, false);

        btn_flyout = (Button) v.findViewById(R.id.btn_flyout);
        btn_flyout_sac = (Button) v.findViewById(R.id.btn_flyout_sac);

        layout_flyout=(LinearLayout) v.findViewById(R.id.layout_flyout);

        Handler handler = new Handler();


        btn_flyout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_o.performClick();

                btn_SBO.setVisibility(View.VISIBLE);
                layout_flyout.setVisibility(View.INVISIBLE);

            }
        });

        if(runCnt<1){
            btn_flyout_sac.setVisibility(View.INVISIBLE);
        }

        btn_flyout_sac.setOnClickListener(new View.OnClickListener() { // ????????? ?????? ????????? ????????? ???
            @Override
            public void onClick(View v) {
                if (ini_num%2==1) {
                    a++;
                    if(a>8) {
                        a=0;
                    }
                    img0.setText(away_arr[a]);
                    away_outout++;
                    Log.d("??????????????????", away_outout+"");


                    et_out.setText(et_out.getText().toString() + "*"); // ??? ??????
                    outCnt++;   //?????? ????????? ?????? ??????

                    //----------------------------------------------
                    flyout_sac_Cnt++; //????????? ?????? ????????? ?????????

                    switch (runCnt){
                        case 1: runCnt = 3;
                            // runcnt??? 3?????? 1?????? ???????????? ???????????? ????????? ????????????
                        case 2: runCnt = 5;
                            // runcnt??? 5?????? 1?????? ???????????? ???????????? ????????? ????????????
                        case 3: runCnt = 6;
                            // runcnt??? 6?????? 1?????? ???????????? ???????????? ????????? ????????????
                        case 4: runCnt = 7;
                            // runcnt??? 7?????? 1?????? ???????????? ???????????? ????????? ????????????

                    }
                    //-----------------------------------------------

                    et_strike.setText("S "); //??????????????? ?????????
                    stkCnt = 0;
                    et_ball.setText("B "); //??? ??? ?????????
                    ballCnt = 0;
                    if (outCnt == 3) {
                        if (iniCnt>=9&&ascore!=hscore) {
                            Intent intent = new Intent(getActivity(), GameSet.class);
                            startActivity(intent);

                            Toast.makeText(getActivity(),"?????? ??????", Toast.LENGTH_SHORT).show();
                        }

                        a++;//away ??? ++
                        handler.postDelayed(new Runnable() { // ?????? ?????? ???????????? ???????????? 0.5??? ?????????
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
                                Toast.makeText(getActivity(), choice_home + " ??????", Toast.LENGTH_SHORT).show();
                            }
                        }, 500);
                        if(ini_num%2==0) {
                            iniCnt++; // ?????? ????????? ++
                        }
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

                    et_out.setText(et_out.getText().toString() + "*"); // ??? ??????
                    outCnt++; //??????????????? ????????? ?????? ??????

                    //----------------------------------------------
                    flyout_sac_Cnt++; //????????? ?????? ????????? ?????????
                    //-----------------------------------------------

                    et_strike.setText("S ");
                    stkCnt = 0;
                    et_ball.setText("B ");
                    ballCnt = 0;
                    if (outCnt == 3) {
                        if (iniCnt>=9&&ascore!=hscore) {
                            Intent intent = new Intent(getActivity(), GameSet.class);
                            startActivity(intent);

                            Toast.makeText(getActivity(),"?????? ??????", Toast.LENGTH_SHORT).show();
                        }

                        h++;//home ??? ++
                        handler.postDelayed(new Runnable() { // ?????? ?????? ???????????? ???????????? 0.5??? ?????????
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
                                //Toast.makeText(BSOActivity.this, choice_away + " ??????", Toast.LENGTH_SHORT).show();
                            }
                        }, 500);


                        if(ini_num%2==0) {
                            iniCnt++; // ?????? ????????? ++
                        }
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
                    RequestQueue queue = Volley.newRequestQueue(getActivity());
                    queue.add(teamRequest);
                }

                btn_SBO.setVisibility(View.VISIBLE);
                layout_flyout.setVisibility(View.INVISIBLE);
            }
        });


        return v;
    }


}
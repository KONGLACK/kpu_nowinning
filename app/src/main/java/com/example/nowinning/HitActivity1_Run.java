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

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.nowinning.BSOActivity.a;
import static com.example.nowinning.BSOActivity.ascore;
import static com.example.nowinning.BSOActivity.away_arr;
import static com.example.nowinning.BSOActivity.away_ball;
import static com.example.nowinning.BSOActivity.away_ining;
import static com.example.nowinning.BSOActivity.away_outout;
import static com.example.nowinning.BSOActivity.away_strike;
import static com.example.nowinning.BSOActivity.ballCnt;
import static com.example.nowinning.BSOActivity.bat_select;
import static com.example.nowinning.BSOActivity.btn_SBO;
import static com.example.nowinning.BSOActivity.btn_o;
import static com.example.nowinning.BSOActivity.et_ascore;
import static com.example.nowinning.BSOActivity.et_ball;
import static com.example.nowinning.BSOActivity.et_hscore;
import static com.example.nowinning.BSOActivity.et_ini;
import static com.example.nowinning.BSOActivity.et_out;
import static com.example.nowinning.BSOActivity.et_strike;
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
import static com.example.nowinning.BSOActivity.outCnt;
import static com.example.nowinning.BSOActivity.runCnt;
import static com.example.nowinning.BSOActivity.stkCnt;
import static com.example.nowinning.start.choice_away;
import static com.example.nowinning.start.choice_home;


public class HitActivity1_Run extends Fragment {

    public static Button btn_hit1_run1, btn_hit1_run2, btn_hit1_run3, btn_hit1_run4, btn_hit1_run5;// ??????, ?????????, ?????? ??????, ?????? ??????, ?????? ?????????
    public static int hit1_run1, hit1_run2, hit1_run3, hit1_run4, hit1_run5; // ??????, ?????????, ?????? ??????, ?????? ?????? ?????? ?????????
    public static LinearLayout layout_hit1_run; // ??????????????? ????????? ??????

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.hitter1_run, container, false);

        btn_hit1_run1 = (Button) v.findViewById(R.id.btn_hit1_run1);
        btn_hit1_run2 = (Button) v.findViewById(R.id.btn_hit1_run2);
        btn_hit1_run3 = (Button) v.findViewById(R.id.btn_hit1_run3);
        btn_hit1_run4 = (Button) v.findViewById(R.id.btn_hit1_run4);
        btn_hit1_run5 = (Button) v.findViewById(R.id.btn_hit1_run5);

        layout_hit1_run = (LinearLayout) v.findViewById(R.id.layout_hit1_run);

        Handler handler = new Handler();

        if (bat_select[0] != 2) { //(ground:0/ hground:1/ bunt:2/ fly:3/ pop: 4)
            btn_hit1_run3.setVisibility(View.GONE);
        }

        if (bat_select[0] != 3) { //(ground:0/ hground:1/ bunt:2/ fly:3/ pop: 4)
            btn_hit1_run2.setVisibility(View.GONE);
            btn_hit1_run5.setVisibility(View.GONE);
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

        btn_hit1_run1.setOnClickListener(new View.OnClickListener() {//??????
            @Override
            public void onClick(View v) {

                if (ini_num % 2 == 1) {

                    BatterRequest_sb_away BatterRequest_sb_away = new BatterRequest_sb_away(choice_away, choice_home, (String) img1.getText(), responseListener);
                    RequestQueue queue = Volley.newRequestQueue(getContext());
                    queue.add(BatterRequest_sb_away);

                    if (runCnt == 1) {// ????????? ?????? ??????
                        img2.setText(img1.getText());
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.INVISIBLE);   // ?????? 2?????? ??????

                        runCnt = 2; // ?????? 2???

                        hit1_run1++; //??????, ?????? ??????++


                        layout_hit1_run.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 4) {// ????????? ?????? ??????
                        Toast.makeText(getActivity(), "?????? ???????????? ????????? ??? ????????????.", Toast.LENGTH_SHORT).show();

                    } else if (runCnt == 6) {// ????????? ?????? ??????
                        img2.setText(img1.getText());
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.VISIBLE);  // ?????? 2,3?????? ??????

                        runCnt = 5;
                        hit1_run1++; //??????, ?????? ??????++

                        layout_hit1_run.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 7) {// ????????? ?????? ??????
                        Toast.makeText(getActivity(), "others??? ?????? ???????????? ??????", Toast.LENGTH_SHORT).show();

                    }

                }


                if (ini_num % 2 == 0) {

                    BatterRequest_sb_home BatterRequest_sb_home = new BatterRequest_sb_home(choice_away, choice_home, (String) img1.getText(), responseListener);
                    RequestQueue queue = Volley.newRequestQueue(getContext());
                    queue.add(BatterRequest_sb_home);

                    if (runCnt == 1) {// ????????? ?????? ??????
                        img2.setText(img1.getText());
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.INVISIBLE);   // ?????? 2?????? ??????

                        runCnt = 2; // ?????? 2???

                        hit1_run1++; //??????, ?????? ??????++


                        layout_hit1_run.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 4) {// ????????? ?????? ??????
                        Toast.makeText(getActivity(), "?????? ???????????? ????????? ??? ????????????.", Toast.LENGTH_SHORT).show();

                    } else if (runCnt == 6) {// ????????? ?????? ??????
                        img2.setText(img1.getText());
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.VISIBLE);  // ?????? 2,3?????? ??????

                        runCnt = 5;
                        hit1_run1++; //??????, ?????? ??????++

                        layout_hit1_run.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 7) {// ????????? ?????? ??????
                        Toast.makeText(getActivity(), "others??? ?????? ???????????? ??????", Toast.LENGTH_SHORT).show();

                    }

                }
            }
        });
        btn_hit1_run2.setOnClickListener(new View.OnClickListener() {//????????? bat_select??? fly????????? ??????
            @Override
            public void onClick(View v) {

                if (runCnt == 1) {// ????????? ?????? ??????
                    img2.setText(img1.getText());
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.INVISIBLE);   // ?????? 2?????? ??????

                    runCnt = 2; // ?????? 2???
                    hit1_run2++; //??????, ?????? ?????????++


                    layout_hit1_run.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 4) {// ????????? ?????? ??????
                    Toast.makeText(getActivity(),"?????? ???????????? ????????? ??? ????????????.", Toast.LENGTH_SHORT).show();

                }


                else if (runCnt == 6) {// ????????? ?????? ??????
                    img2.setText(img1.getText());
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.VISIBLE);  // ?????? 1?????? ??????

                    runCnt = 5;
                    hit1_run2++; //??????, ?????? ?????????++

                    layout_hit1_run.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 7) {// ????????? ?????? ??????
                    Toast.makeText(getActivity(),"others??? ?????? ???????????? ??????", Toast.LENGTH_SHORT).show();

                }

            }
        });
        btn_hit1_run3.setOnClickListener(new View.OnClickListener() {//?????? ?????? bat_select??? bunt????????? ??????
            @Override
            public void onClick(View v) {

                if(ini_num%2==1) {

                    BatterRequest_sh_away BatterRequest_sh_away = new BatterRequest_sh_away(choice_away, choice_home, away_arr[a-1], responseListener);
                    RequestQueue queue = Volley.newRequestQueue(getContext());
                    queue.add(BatterRequest_sh_away);

                    if (runCnt == 1) {// ????????? ?????? ??????
                        img2.setText(img1.getText());
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.INVISIBLE);   // ?????? 2?????? ??????

                        runCnt = 2; // ?????? 2???

                        hit1_run3++; //??????, ?????? ????????????++


                        layout_hit1_run.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 4) {// ????????? ?????? ??????
                        Toast.makeText(getActivity(), "?????? ???????????? ????????? ??? ????????????.", Toast.LENGTH_SHORT).show();

                    } else if (runCnt == 6) {// ????????? ?????? ??????
                        img2.setText(img1.getText());
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.VISIBLE);  // ?????? 1?????? ??????

                        runCnt = 5;
                        hit1_run3++; //??????, ?????? ??????++

                        layout_hit1_run.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 7) {// ????????? ?????? ??????
                        Toast.makeText(getActivity(), "others??? ?????? ???????????? ??????", Toast.LENGTH_SHORT).show();

                    }
                }

                if(ini_num%2==0) {
                    BatterRequest_sh_home BatterRequest_sh_home = new BatterRequest_sh_home(choice_away, choice_home, home_arr[h-1], responseListener);
                    RequestQueue queue = Volley.newRequestQueue(getContext());
                    queue.add(BatterRequest_sh_home);

                    if (runCnt == 1) {// ????????? ?????? ??????
                        img2.setText(img1.getText());
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.INVISIBLE);   // ?????? 2?????? ??????

                        runCnt = 2; // ?????? 2???

                        hit1_run3++; //??????, ?????? ????????????++


                        layout_hit1_run.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 4) {// ????????? ?????? ??????
                        Toast.makeText(getActivity(), "?????? ???????????? ????????? ??? ????????????.", Toast.LENGTH_SHORT).show();

                    } else if (runCnt == 6) {// ????????? ?????? ??????
                        img2.setText(img1.getText());
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.VISIBLE);  // ?????? 1?????? ??????

                        runCnt = 5;
                        hit1_run3++; //??????, ?????? ??????++

                        layout_hit1_run.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 7) {// ????????? ?????? ??????
                        Toast.makeText(getActivity(), "others??? ?????? ???????????? ??????", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
        btn_hit1_run4.setOnClickListener(new View.OnClickListener() {//??????
            @Override
            public void onClick(View v) {

                if (runCnt == 1) {// ????????? ?????? ??????
                    img2.setText(img1.getText());
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.INVISIBLE);   // ?????? 2?????? ??????

                    runCnt = 2; // ?????? 2???
                    hit1_run4++; //?????? ????????? ??????++ -> ????????? ?????? ??????????????? ??????


                    layout_hit1_run.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 4) {// ????????? ?????? ??????
                    Toast.makeText(getActivity(),"?????? ???????????? ????????? ??? ????????????.", Toast.LENGTH_SHORT).show();

                }


                else if (runCnt == 6) {// ????????? ?????? ??????
                    img2.setText(img1.getText());
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.VISIBLE);  // ?????? 1?????? ??????

                    runCnt = 5;
                    hit1_run4++; //?????? ????????? ??????++ -> ????????? ?????? ??????????????? ??????

                    layout_hit1_run.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 7) {// ????????? ?????? ??????
                    Toast.makeText(getActivity(),"others??? ?????? ???????????? ??????", Toast.LENGTH_SHORT).show();

                }

            }
        });

        btn_hit1_run5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ini_num%2==1) {

                    BatterRequest_sf_away BatterRequest_sf_away = new BatterRequest_sf_away(choice_away, choice_home, away_arr[a-1], responseListener);
                    RequestQueue queue = Volley.newRequestQueue(getContext());
                    queue.add(BatterRequest_sf_away);

                    if (runCnt == 1) {// ????????? ?????? ??????
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.INVISIBLE);   // ?????? 2?????? ??????

                        runCnt = 0; // ?????? 2???

                        hit1_run5++; //??????, ?????? ????????????++


                        handler.postDelayed(new Runnable() { // ?????? ?????? ???????????? ???????????? 0.5??? ?????????
                            @Override
                            public void run() {
                                ascore++;
                                et_ascore.setText("??????   " + choice_away + Integer.toString(ascore));
                                away_ining++;
                            }
                        }, 500);

                        ScoreRequest_away ScoreRequest_away = new ScoreRequest_away(choice_away, choice_home, (String) img1.getText(), responseListener);
                        RequestQueue queue1 = Volley.newRequestQueue(getContext());
                        queue1.add(ScoreRequest_away);

                        layout_hit1_run.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 4) {// ????????? ?????? ??????
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.INVISIBLE);   // ?????? 2?????? ??????

                        runCnt = 0; // ?????? 2???

                        hit1_run5++; //??????, ?????? ????????????++

                        for(int i=0; i<2; i++) {
                            handler.postDelayed(new Runnable() { // ?????? ?????? ???????????? ???????????? 0.5??? ?????????
                                @Override
                                public void run() {
                                    ascore++;
                                    et_ascore.setText("??????   " + choice_away + Integer.toString(ascore));
                                    away_ining++;
                                }
                            }, 500);
                        }

                        ScoreRequest_away ScoreRequest_away = new ScoreRequest_away(choice_away, choice_home, (String) img1.getText(), responseListener);
                        RequestQueue queue1 = Volley.newRequestQueue(getContext());
                        queue1.add(ScoreRequest_away);

                        ScoreRequest_away ScoreRequest_away1 = new ScoreRequest_away(choice_away, choice_home, (String) img2.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_away1);


                        layout_hit1_run.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    } else if (runCnt == 6) {// ????????? ?????? ??????
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.INVISIBLE);   // ?????? 2?????? ??????

                        runCnt = 0; // ?????? 2???

                        hit1_run5++; //??????, ?????? ????????????++

                        for(int i=0; i<2; i++) {
                            handler.postDelayed(new Runnable() { // ?????? ?????? ???????????? ???????????? 0.5??? ?????????
                                @Override
                                public void run() {
                                    ascore++;
                                    et_ascore.setText("??????   " + choice_away + Integer.toString(ascore));
                                    away_ining++;
                                }
                            }, 500);
                        }

                        ScoreRequest_away ScoreRequest_away = new ScoreRequest_away(choice_away, choice_home, (String) img1.getText(), responseListener);
                        RequestQueue queue1 = Volley.newRequestQueue(getContext());
                        queue1.add(ScoreRequest_away);

                        ScoreRequest_away ScoreRequest_away1 = new ScoreRequest_away(choice_away, choice_home, (String) img3.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_away1);


                        layout_hit1_run.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 7) {// ????????? ?????? ??????
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.INVISIBLE);   // ?????? 2?????? ??????

                        runCnt = 0; // ?????? 2???

                        hit1_run5++; //??????, ?????? ????????????++

                        for(int i=0; i<3; i++) {
                            handler.postDelayed(new Runnable() { // ?????? ?????? ???????????? ???????????? 0.5??? ?????????
                                @Override
                                public void run() {
                                    ascore++;
                                    et_ascore.setText("??????   " + choice_away + Integer.toString(ascore));
                                    away_ining++;
                                }
                            }, 500);
                        }

                        ScoreRequest_away ScoreRequest_away = new ScoreRequest_away(choice_away, choice_home, (String) img1.getText(), responseListener);
                        RequestQueue queue1 = Volley.newRequestQueue(getContext());
                        queue1.add(ScoreRequest_away);

                        ScoreRequest_away ScoreRequest_away1 = new ScoreRequest_away(choice_away, choice_home, (String) img2.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_away1);

                        ScoreRequest_away ScoreRequest_away2 = new ScoreRequest_away(choice_away, choice_home, (String) img3.getText(), responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(ScoreRequest_away2);


                        layout_hit1_run.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    }
                }

                if(ini_num%2==0) {
                    BatterRequest_sf_home BatterRequest_sf_home = new BatterRequest_sf_home(choice_away, choice_home, home_arr[h-1], responseListener);
                    RequestQueue queue = Volley.newRequestQueue(getContext());
                    queue.add(BatterRequest_sf_home);
                    if (runCnt == 1) {// ????????? ?????? ??????
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.INVISIBLE);   // ?????? 2?????? ??????

                        runCnt = 0; // ?????? 2???

                        hit1_run5++; //??????, ?????? ????????????++

                        handler.postDelayed(new Runnable() { // ?????? ?????? ???????????? ???????????? 0.5??? ?????????
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("???   " + choice_home + Integer.toString(hscore));
                                away_ining++;
                            }
                        }, 500);

                        ScoreRequest_away ScoreRequest_away = new ScoreRequest_away(choice_away, choice_home, (String) img1.getText(), responseListener);
                        RequestQueue queue1 = Volley.newRequestQueue(getContext());
                        queue1.add(ScoreRequest_away);


                        layout_hit1_run.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 4) {// ????????? ?????? ??????
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.INVISIBLE);   // ?????? 2?????? ??????

                        runCnt = 0; // ?????? 2???

                        hit1_run5++; //??????, ?????? ????????????++

                        for(int i=0; i<2; i++) {
                            handler.postDelayed(new Runnable() { // ?????? ?????? ???????????? ???????????? 0.5??? ?????????
                                @Override
                                public void run() {
                                    hscore++;
                                    et_hscore.setText("???   " + choice_home + Integer.toString(hscore));
                                    away_ining++;
                                }
                            }, 500);
                        }

                        ScoreRequest_away ScoreRequest_away = new ScoreRequest_away(choice_away, choice_home, (String) img1.getText(), responseListener);
                        RequestQueue queue1 = Volley.newRequestQueue(getContext());
                        queue1.add(ScoreRequest_away);

                        ScoreRequest_away ScoreRequest_away1 = new ScoreRequest_away(choice_away, choice_home, (String) img2.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_away1);


                        layout_hit1_run.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    } else if (runCnt == 6) {// ????????? ?????? ??????
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.INVISIBLE);   // ?????? 2?????? ??????

                        runCnt = 0; // ?????? 2???

                        hit1_run5++; //??????, ?????? ????????????++

                        for(int i=0; i<2; i++) {
                            handler.postDelayed(new Runnable() { // ?????? ?????? ???????????? ???????????? 0.5??? ?????????
                                @Override
                                public void run() {
                                    hscore++;
                                    et_hscore.setText("???   " + choice_home + Integer.toString(hscore));
                                    away_ining++;
                                }
                            }, 500);
                        }

                        ScoreRequest_away ScoreRequest_away = new ScoreRequest_away(choice_away, choice_home, (String) img1.getText(), responseListener);
                        RequestQueue queue1 = Volley.newRequestQueue(getContext());
                        queue1.add(ScoreRequest_away);

                        ScoreRequest_away ScoreRequest_away1 = new ScoreRequest_away(choice_away, choice_home, (String) img3.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_away1);


                        layout_hit1_run.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 7) {// ????????? ?????? ??????
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.INVISIBLE);   // ?????? 2?????? ??????

                        runCnt = 0; // ?????? 2???

                        hit1_run5++; //??????, ?????? ????????????++

                        for(int i=0; i<3; i++) {
                            handler.postDelayed(new Runnable() { // ?????? ?????? ???????????? ???????????? 0.5??? ?????????
                                @Override
                                public void run() {
                                    hscore++;
                                    et_hscore.setText("???   " + choice_home + Integer.toString(hscore));
                                    away_ining++;
                                }
                            }, 500);
                        }

                        ScoreRequest_away ScoreRequest_away = new ScoreRequest_away(choice_away, choice_home, (String) img1.getText(), responseListener);
                        RequestQueue queue1 = Volley.newRequestQueue(getContext());
                        queue1.add(ScoreRequest_away);

                        ScoreRequest_away ScoreRequest_away1 = new ScoreRequest_away(choice_away, choice_home, (String) img2.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_away1);

                        ScoreRequest_away ScoreRequest_away2 = new ScoreRequest_away(choice_away, choice_home, (String) img3.getText(), responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(ScoreRequest_away2);


                        layout_hit1_run.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    }
                }
            }
        });


       /* btn_buntout_sac.setOnClickListener(new View.OnClickListener() { // ????????? ?????? ????????? ????????? ???
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
                    buntout_sac_Cnt++; //????????? ?????? ????????? ?????????

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
                    buntout_sac_Cnt++; //????????? ?????? ????????? ?????????
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
                layout_buntout.setVisibility(View.INVISIBLE);
            }
        });


        return v;
    }*/

        return v;
    }
}

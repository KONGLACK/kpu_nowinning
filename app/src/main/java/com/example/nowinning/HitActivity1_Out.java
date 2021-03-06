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
import static com.example.nowinning.BSOActivity.away_outout;
import static com.example.nowinning.BSOActivity.away_strike;
import static com.example.nowinning.BSOActivity.ballCnt;
import static com.example.nowinning.BSOActivity.btn_SBO;
import static com.example.nowinning.BSOActivity.btn_o;
import static com.example.nowinning.BSOActivity.et_ball;
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


public class HitActivity1_Out extends Fragment {

    public static Button btn_hit1_out1, btn_hit1_out2;
    public static int hit1_out1; // ????????? ?????????

    public static LinearLayout layout_hit1_out; // ??????????????? ????????????

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.hitter1_out, container, false);

        btn_hit1_out1 = (Button) v.findViewById(R.id.btn_hit1_out1); //?????????
        btn_hit1_out2 = (Button) v.findViewById(R.id.btn_hit1_out2); //?????? ??????

        layout_hit1_out=(LinearLayout) v.findViewById(R.id.layout_hit1_out);

        Handler handler = new Handler();


        btn_hit1_out1.setOnClickListener(new View.OnClickListener() {//?????????
            @Override
            public void onClick(View v) {

                if (runCnt == 1) {// ????????? ?????? ??????
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.INVISIBLE);   // ?????? 2?????? ??????

                    runCnt = 0; // ?????? 1,2???
                    btn_o.performClick();

                    hit1_out1++;//?????? ???????????? ?????? ?????????++ ?????? ?????? ?????? ??????

                    layout_hit1_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }


                else if (runCnt == 4) {// ????????? ?????? ??????
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.INVISIBLE);// ?????? 1,2,3?????? ??????

                    runCnt = 2;
                    btn_o.performClick();

                    hit1_out1++;//?????? ???????????? ?????? ?????????++ ?????? ?????? ?????? ??????

                    layout_hit1_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }


                else if (runCnt == 6) {// ????????? ?????? ??????
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.VISIBLE);   // ?????? 1?????? ??????

                    runCnt = 3;
                    btn_o.performClick();

                    hit1_out1++;//?????? ???????????? ?????? ?????????++ ?????? ?????? ?????? ??????

                    layout_hit1_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 7) {// ????????? ?????? ??????
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.VISIBLE);   // ?????? 1?????? ??????

                    runCnt = 5;
                    btn_o.performClick();

                    hit1_out1++;//?????? ???????????? ?????? ?????????++ ?????? ?????? ?????? ??????

                    layout_hit1_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

            }
        });

        btn_hit1_out2.setOnClickListener(new View.OnClickListener() { //?????? ????????? ?????? ?????? ????????? ????????? ????????? ??? ????????? ?????????
            @Override
            public void onClick(View v) {

                if (runCnt == 1) {// ????????? ?????? ??????
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.INVISIBLE);   // ?????? 2?????? ??????

                    runCnt = 0; // ?????? 1,2???
                    btn_o.performClick();


                    layout_hit1_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }


                else if (runCnt == 4) {// ????????? ?????? ??????
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.INVISIBLE);// ?????? 1,2,3?????? ??????

                    runCnt = 2;
                    btn_o.performClick();


                    layout_hit1_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }


                else if (runCnt == 6) {// ????????? ?????? ??????
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.VISIBLE);   // ?????? 1?????? ??????

                    runCnt = 3;
                    btn_o.performClick();


                    layout_hit1_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 7) {// ????????? ?????? ??????
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.VISIBLE);   // ?????? 1?????? ??????

                    runCnt = 5;
                    btn_o.performClick();

                    layout_hit1_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

            }
        });

        return v;
    }


}
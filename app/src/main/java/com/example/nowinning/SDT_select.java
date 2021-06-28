package com.example.nowinning;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.nowinning.BSOActivity.ballCnt;
import static com.example.nowinning.BSOActivity.h;
import static com.example.nowinning.BSOActivity.home_arr;
import static com.example.nowinning.BSOActivity.img0;
import static com.example.nowinning.BSOActivity.img1;
import static com.example.nowinning.BSOActivity.img2;
import static com.example.nowinning.BSOActivity.img3;
import static com.example.nowinning.Others.btn_OutOthers;
import static com.example.nowinning.BSOActivity.btn_SBO;
import static com.example.nowinning.BSOActivity.et_ascore;
import static com.example.nowinning.BSOActivity.et_hscore;
import static com.example.nowinning.BSOActivity.et_strike;
import static com.example.nowinning.BSOActivity.iniCnt;
import static com.example.nowinning.BSOActivity.outCnt;
import static com.example.nowinning.BSOActivity.runCnt;
import static com.example.nowinning.BSOActivity.hscore;
import static com.example.nowinning.BSOActivity.ascore;
import static com.example.nowinning.BSOActivity.stkCnt;
import static com.example.nowinning.start.choice_home;
import static com.example.nowinning.start.choice_away;
import static com.example.nowinning.BSOActivity.a;
import static com.example.nowinning.BSOActivity.away_arr;

public class SDT_select extends Fragment{

    public static Button btn_Single, btn_Double, btn_Triple;
    public static int a_SingleCount=0, a_DoubleCount=0, a_TripleCount=0;
    public static int h_SingleCount=0, h_DoubleCount=0, h_TripleCount=0;
    private int i;
    public static LinearLayout layout_SDT;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.sdt, container, false);
        btn_Single = (Button) v.findViewById(R.id.btn_Single);
        btn_Double = (Button) v.findViewById(R.id.btn_Double);
        btn_Triple = (Button) v.findViewById(R.id.btn_Triple);

        layout_SDT = (LinearLayout) v.findViewById(R.id.layout_SDT);
        Handler handler = new Handler();

        btn_Single.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 추후 1루타 정보로 수정
                if (iniCnt % 2 == 1) {
                    a_SingleCount++;

                    if (runCnt == 0) { // 주자의 현재 위치





                        a++;

                        img1.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.VISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.INVISIBLE); // 주자 1루로 이동

                        runCnt = 1;

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    } else if (runCnt == 1) {// 주자의 현재 위치
                        a++;

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

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 2) { // 주자의 현재 위치
                        a++;

                        img3.setText(img2.getText());
                        img1.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.VISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE);  // 주자 3루로 이동

                        runCnt = 6; //주자 2,3루

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 3) {// 주자의 현재 위치
                        a++;

                        img1.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.VISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.INVISIBLE); //주자 1루로 이동

                        runCnt = 1; //주자 1루

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                ascore++;
                                et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    } else if (runCnt == 4) {// 주자의 현재 위치
                        a++;

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

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 5) {// 주자의 현재 위치
                        a++;

                        img3.setText(img2.getText());
                        img1.setText(img0.getText());
                        img0.setText(away_arr[0]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.VISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                        runCnt = 6;

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                ascore++;
                                et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 6) {// 주자의 현재 위치
                        a++;

                        img2.setText(img1.getText());
                        img1.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.VISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.INVISIBLE);   // 주자 1루로 이동

                        runCnt = 4;

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                ascore++;
                                et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 7) {// 주자의 현재 위치
                        a++;

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
                                ascore++;
                                et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    }

                }

                if(iniCnt%2==0) {
                    h_SingleCount++;
                    if (runCnt == 0) { // 주자의 현재 위치
                        h++;

                        img1.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.VISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.INVISIBLE); // 주자 1루로 이동

                        runCnt = 1;

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    } else if (runCnt == 1) {// 주자의 현재 위치
                        h++;

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

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 2) { // 주자의 현재 위치
                        h++;

                        img3.setText(img2.getText());
                        img1.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.VISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE);  // 주자 3루로 이동

                        runCnt = 6; //주자 2,3루

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 3) {// 주자의 현재 위치
                        h++;

                        img1.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.VISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.INVISIBLE); //주자 1루로 이동

                        runCnt = 1; //주자 1루

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    } else if (runCnt == 4) {// 주자의 현재 위치
                        h++;

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

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 5) {// 주자의 현재 위치
                        h++;

                        img3.setText(img2.getText());
                        img1.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.VISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                        runCnt = 6;

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 6) {// 주자의 현재 위치
                        h++;

                        img2.setText(img1.getText());
                        img1.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.VISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.INVISIBLE);   // 주자 1루로 이동

                        runCnt = 4;

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 7) {// 주자의 현재 위치
                        h++;

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
                                et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    }
                }
            }
        });


        btn_Double.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 추후 1루타 정보로 수정
                if (iniCnt % 2 == 1) {
                    a_DoubleCount++;


                    if (runCnt == 0) { // 주자의 현재 위치
                        a++;

                        img2.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.INVISIBLE); // 주자 2루로 이동

                        runCnt = 2;

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    } else if (runCnt == 1) {// 주자의 현재 위치
                        a++;

                        img3.setText(img1.getText());
                        img2.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.VISIBLE);   // 주자 2루로 이동

                        runCnt = 5; // 주자 1,2루

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 2) { // 주자의 현재 위치
                        a++;

                        img2.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.INVISIBLE);// 주자 1루로 이동

                        runCnt = 2; //주자 2,3루

                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    ascore++;
                                    et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                }
                            }, 500);


                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 3) {// 주자의 현재 위치
                        a++;

                        img2.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.INVISIBLE); //주자 1루로 이동

                        runCnt = 2; //주자 1루

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                ascore++;
                                et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    } else if (runCnt == 4) {// 주자의 현재 위치
                        a++;

                        img3.setText(img1.getText());
                        img2.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.VISIBLE);// 주자 1,2,3루로 이동

                        runCnt = 5;

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                ascore++;
                                et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 5) {// 주자의 현재 위치
                        a++;

                        img2.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.INVISIBLE);

                        runCnt = 2;

                        for (int i = 0; i < 2; i++) {
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    ascore++;
                                    et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                }
                            }, 500);
                        }

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 6) {// 주자의 현재 위치
                        a++;

                        img3.setText(img1.getText());
                        img2.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.VISIBLE);  // 주자 1루로 이동

                        runCnt = 5;

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                ascore++;
                                et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 7) {// 주자의 현재 위치
                        a++;

                        img3.setText(img1.getText());
                        img2.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.VISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                        runCnt = 7;

                        for (int i = 0; i < 2; i++) {
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    ascore++;
                                    et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                }
                            }, 500);
                        }

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    }
                }
                else if (iniCnt % 2 == 0) {
                    h_DoubleCount++;
                    if (runCnt == 0) { // 주자의 현재 위치
                        h++;

                        img2.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.INVISIBLE); // 주자 2루로 이동

                        runCnt = 2;

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    } else if (runCnt == 1) {// 주자의 현재 위치
                        h++;

                        img3.setText(img1.getText());
                        img2.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.VISIBLE);   // 주자 2루로 이동

                        runCnt = 5; // 주자 1,2루

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 2) { // 주자의 현재 위치
                        h++;

                        img2.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.INVISIBLE);// 주자 1루로 이동

                        runCnt = 2; //주자 2,3루

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                            }
                        }, 500);


                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 3) {// 주자의 현재 위치
                        h++;

                        img2.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.INVISIBLE); //주자 1루로 이동

                        runCnt = 2; //주자 1루

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    } else if (runCnt == 4) {// 주자의 현재 위치
                        h++;

                        img3.setText(img1.getText());
                        img2.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.VISIBLE);// 주자 1,2,3루로 이동

                        runCnt = 5;

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 5) {// 주자의 현재 위치
                        h++;

                        img2.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.INVISIBLE);

                        runCnt = 2;

                        for (int i = 0; i < 2; i++) {
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    hscore++;
                                    et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                                }
                            }, 500);
                        }

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 6) {// 주자의 현재 위치
                        h++;

                        img3.setText(img1.getText());
                        img2.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.VISIBLE);  // 주자 1루로 이동

                        runCnt = 5;

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 7) {// 주자의 현재 위치
                        h++;

                        img3.setText(img1.getText());
                        img2.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.VISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                        runCnt = 7;

                        for (int i = 0; i < 2; i++) {
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    hscore++;
                                    et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                                }
                            }, 500);
                        }

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        btn_Triple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (iniCnt % 2 == 1) {
                    a_TripleCount++;
                    if (runCnt == 0) { // 주자의 현재 위치
                        a++;

                        img3.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE); // 주자 3루로 이동

                        runCnt = 3;

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    } else if (runCnt == 1) {// 주자의 현재 위치
                        a++;

                        img3.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE);   // 주자 3루로 이동

                        runCnt = 3; // 주자 3루

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                ascore++;
                                et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 2) { // 주자의 현재 위치
                        a++;

                        img3.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE);// 주자 3루로 이동

                        runCnt = 3; //주자 2,3루

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                ascore++;
                                et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 3) {// 주자의 현재 위치
                        a++;

                        img3.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE); //주자 3루로 이동

                        runCnt = 3; //주자 1루


                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                ascore++;
                                et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                            }
                        }, 500);


                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    } else if (runCnt == 4) {// 주자의 현재 위치
                        a++;

                        img3.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE);// 주자 3루로 이동

                        runCnt = 3;
                        for (int i = 0; i < 2; i++) {
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    ascore++;
                                    et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                }
                            }, 500);
                        }
                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 5) {// 주자의 현재 위치
                        a++;

                        img3.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE);
                        runCnt = 3;

                        for (int i = 0; i < 2; i++) {
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    ascore++;
                                    et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                }
                            }, 500);
                        }

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 6) {// 주자의 현재 위치
                        a++;

                        img3.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE);  // 주자 1루로 이동

                        runCnt = 3;

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                ascore++;
                                et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 7) {// 주자의 현재 위치
                        a++;

                        img3.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                        runCnt = 3;

                        for (int i = 0; i < 3; i++) {
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    ascore++;
                                    et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                }
                            }, 500);
                        }

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    }
                } else if (iniCnt % 2 == 0) {
                    h_TripleCount++;
                    if (runCnt == 0) {
                        h++;

                        img3.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE); // 주자 3루로 이동

                        runCnt = 3;

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    } else if (runCnt == 1) {// 주자의 현재 위치
                        h++;

                        img3.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE);   // 주자 3루로 이동

                        runCnt = 3; // 주자 3루

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 2) { // 주자의 현재 위치
                        h++;

                        img3.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE);// 주자 3루로 이동

                        runCnt = 3; //주자 2,3루

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 3) {// 주자의 현재 위치
                        h++;

                        img3.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE); //주자 3루로 이동

                        runCnt = 3; //주자 1루


                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    } else if (runCnt == 4) {// 주자의 현재 위치
                        h++;

                        img3.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE);// 주자 3루로 이동

                        runCnt = 3;
                        for (int i = 0; i < 2; i++) {
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    hscore++;
                                    et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                                }
                            }, 500);
                        }
                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 5) {// 주자의 현재 위치
                        h++;

                        img3.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE);
                        runCnt = 3;

                        for (int i = 0; i < 2; i++) {
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    hscore++;
                                    et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                                }
                            }, 500);
                        }

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 6) {// 주자의 현재 위치
                        h++;

                        img3.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE);  // 주자 1루로 이동

                        runCnt = 3;

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 7) {// 주자의 현재 위치
                        h++;

                        img3.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                        runCnt = 3;

                        for (int i = 0; i < 3; i++) {
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    hscore++;
                                    et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                                }
                            }, 500);
                        }

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
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
        PlayerRequest playerRequest = new PlayerRequest(away_arr[a], a_SingleCount, a_DoubleCount, a_TripleCount, responseListener);


        PlayerRequest playerRequest1 = new PlayerRequest(home_arr[h], h_SingleCount, h_DoubleCount, h_TripleCount, responseListener);
        Log.d("값", home_arr[h]);

        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(playerRequest);
        queue.add(playerRequest1);



        return v;
    }
}

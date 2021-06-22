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

import static com.example.nowinning.BSOActivity.ballCnt;
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

public class SDT_select extends Fragment {

    public static Button btn_Single, btn_Double, btn_Triple;
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


                if (runCnt == 0) { // 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.INVISIBLE); // 주자 1루로 이동

                    runCnt = 1;
                    stkCnt = 0;
                    ballCnt = 0;

                    layout_SDT.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);
                }

                else if (runCnt == 1) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.INVISIBLE);   // 주자 2루로 이동

                    runCnt = 4; // 주자 1,2루
                    stkCnt = 0;
                    ballCnt = 0;

                    layout_SDT.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);
                }

                else if (runCnt == 2) { // 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.VISIBLE);  // 주자 3루로 이동

                    runCnt = 5; //주자 2,3루
                    stkCnt = 0;
                    ballCnt = 0;

                    layout_SDT.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);
                }

                else if (runCnt == 3) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.INVISIBLE); //주자 1루로 이동

                    runCnt = 1; //주자 1루

                    if (iniCnt % 2 == 0) { // 이닝이 짝수 = 말에 홈팀의 공격
                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈      " + choice_home + Integer.toString(hscore));
                            }
                        }, 500);
                    }

                    else if (iniCnt % 2 == 1) { // 이닝이 홀수 = 초에 어웨이 팀의 공격
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

                else if (runCnt == 4) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.VISIBLE);// 주자 1,2,3루로 이동

                    runCnt = 7;
                    stkCnt = 0;
                    ballCnt = 0;

                    layout_SDT.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);
                }

                else if (runCnt == 5) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                    runCnt = 6;

                    if (iniCnt % 2 == 0) { // 이닝이 짝수 = 말에 홈팀의 공격
                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈      " + choice_home + Integer.toString(hscore));
                            }
                        }, 500);
                    }

                    else if (iniCnt % 2 == 1) { // 이닝이 홀수 = 초에 어웨이 팀의 공격
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

                else if (runCnt == 6) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.INVISIBLE);   // 주자 1루로 이동

                    runCnt = 4;

                    if (iniCnt % 2 == 0) { // 이닝이 짝수 = 말에 홈팀의 공격
                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈      " + choice_home + Integer.toString(hscore));
                            }
                        }, 500);
                    }

                    else if (iniCnt % 2 == 1) { // 이닝이 홀수 = 초에 어웨이 팀의 공격
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

                else if (runCnt == 7) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                    runCnt = 7;

                    if (iniCnt % 2 == 0) { // 이닝이 짝수 = 말에 홈팀의 공격
                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈      " + choice_home + Integer.toString(hscore));
                            }
                        }, 500);
                    }

                    else if (iniCnt % 2 == 1) { // 이닝이 홀수 = 초에 어웨이 팀의 공격
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
        });

        btn_Double.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 추후 1루타 정보로 수정

                if (runCnt == 0) { // 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.INVISIBLE); // 주자 2루로 이동

                    runCnt = 2;
                    stkCnt = 0;
                    ballCnt = 0;

                    layout_SDT.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);
                }

                else if (runCnt == 1) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.VISIBLE);   // 주자 2루로 이동

                    runCnt = 5; // 주자 1,2루
                    stkCnt = 0;
                    ballCnt = 0;

                    layout_SDT.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);
                }

                else if (runCnt == 2) { // 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.INVISIBLE);// 주자 1루로 이동

                    runCnt = 2; //주자 2,3루

                    if (iniCnt % 2 == 0) { // 이닝이 짝수 = 말에 홈팀의 공격
                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈      " + choice_home + Integer.toString(hscore));
                            }
                        }, 500);
                    }

                    else if (iniCnt % 2 == 1) { // 이닝이 홀수 = 초에 어웨이 팀의 공격
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

                else if (runCnt == 3) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.INVISIBLE); //주자 1루로 이동

                    runCnt = 2; //주자 1루

                    if (iniCnt % 2 == 0) { // 이닝이 짝수 = 말에 홈팀의 공격
                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈      " + choice_home + Integer.toString(hscore));
                            }
                        }, 500);
                    }

                    else if (iniCnt % 2 == 1) { // 이닝이 홀수 = 초에 어웨이 팀의 공격
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

                else if (runCnt == 4) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.VISIBLE);// 주자 1,2,3루로 이동

                    runCnt = 5;

                    if (iniCnt % 2 == 0) { // 이닝이 짝수 = 말에 홈팀의 공격
                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈      " + choice_home + Integer.toString(hscore));
                            }
                        }, 500);
                    }

                    else if (iniCnt % 2 == 1) { // 이닝이 홀수 = 초에 어웨이 팀의 공격
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

                else if (runCnt == 5) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.INVISIBLE);

                    runCnt = 2;

                    for(int i = 0; i<3; i++) {
                        if (iniCnt % 2 == 0) { // 이닝이 짝수 = 말에 홈팀의 공격
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    hscore++;
                                    et_hscore.setText("홈      " + choice_home + Integer.toString(hscore));
                                }
                            }, 500);
                        } else if (iniCnt % 2 == 1) { // 이닝이 홀수 = 초에 어웨이 팀의 공격
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    ascore++;
                                    et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                }
                            }, 500);
                        }
                    }

                    stkCnt = 0;
                    ballCnt = 0;

                    layout_SDT.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);
                }

                else if (runCnt == 6) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.VISIBLE);  // 주자 1루로 이동

                    runCnt = 5;

                    if (iniCnt % 2 == 0) { // 이닝이 짝수 = 말에 홈팀의 공격
                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈      " + choice_home + Integer.toString(hscore));
                            }
                        }, 500);
                    }

                    else if (iniCnt % 2 == 1) { // 이닝이 홀수 = 초에 어웨이 팀의 공격
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

                else if (runCnt == 7) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                    runCnt = 7;

                    for(int i = 0; i<3; i++) {
                        if (iniCnt % 2 == 0) { // 이닝이 짝수 = 말에 홈팀의 공격
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    hscore++;
                                    et_hscore.setText("홈      " + choice_home + Integer.toString(hscore));
                                }
                            }, 500);
                        } else if (iniCnt % 2 == 1) { // 이닝이 홀수 = 초에 어웨이 팀의 공격
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    ascore++;
                                    et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                }
                            }, 500);
                        }
                    }

                    stkCnt = 0;
                    ballCnt = 0;

                    layout_SDT.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);
                }
            }
        });

        btn_Triple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (runCnt == 0) { // 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.VISIBLE); // 주자 2루로 이동

                    runCnt = 3;
                    stkCnt = 0;
                    ballCnt = 0;

                    layout_SDT.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);
                }

                else if (runCnt == 1) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.VISIBLE);   // 주자 2루로 이동

                    runCnt = 3; // 주자 1,2루
                    stkCnt = 0;
                    ballCnt = 0;

                    layout_SDT.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);
                }

                else if (runCnt == 2) { // 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.VISIBLE);// 주자 1루로 이동

                    runCnt = 3; //주자 2,3루

                    if (iniCnt % 2 == 0) { // 이닝이 짝수 = 말에 홈팀의 공격
                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈      " + choice_home + Integer.toString(hscore));
                            }
                        }, 500);
                    }

                    else if (iniCnt % 2 == 1) { // 이닝이 홀수 = 초에 어웨이 팀의 공격
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

                else if (runCnt == 3) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.VISIBLE); //주자 1루로 이동

                    runCnt = 3; //주자 1루


                        if (iniCnt % 2 == 0) { // 이닝이 짝수 = 말에 홈팀의 공격
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    hscore++;
                                    et_hscore.setText("홈      " + choice_home + Integer.toString(hscore));
                                }
                            }, 500);
                        } else if (iniCnt % 2 == 1) { // 이닝이 홀수 = 초에 어웨이 팀의 공격
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

                else if (runCnt == 4) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.VISIBLE);// 주자 1,2,3루로 이동

                    runCnt = 3;
                    for(int i = 0; i<3; i++) {
                        if (iniCnt % 2 == 0) { // 이닝이 짝수 = 말에 홈팀의 공격
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    hscore++;
                                    et_hscore.setText("홈      " + choice_home + Integer.toString(hscore));
                                }
                            }, 500);
                        } else if (iniCnt % 2 == 1) { // 이닝이 홀수 = 초에 어웨이 팀의 공격
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    ascore++;
                                    et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                }
                            }, 500);
                        }
                    }
                    stkCnt = 0;
                    ballCnt = 0;

                    layout_SDT.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);
                }

                else if (runCnt == 5) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.VISIBLE);

                    runCnt = 3;

                    for(int i = 0; i<3; i++) {
                        if (iniCnt % 2 == 0) { // 이닝이 짝수 = 말에 홈팀의 공격
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    hscore++;
                                    et_hscore.setText("홈      " + choice_home + Integer.toString(hscore));
                                }
                            }, 500);
                        } else if (iniCnt % 2 == 1) { // 이닝이 홀수 = 초에 어웨이 팀의 공격
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    ascore++;
                                    et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                }
                            }, 500);
                        }
                    }

                    stkCnt = 0;
                    ballCnt = 0;

                    layout_SDT.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);
                }

                else if (runCnt == 6) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.VISIBLE);  // 주자 1루로 이동

                    runCnt = 3;

                    if (iniCnt % 2 == 0) { // 이닝이 짝수 = 말에 홈팀의 공격
                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈      " + choice_home + Integer.toString(hscore));
                            }
                        }, 500);
                    }

                    else if (iniCnt % 2 == 1) { // 이닝이 홀수 = 초에 어웨이 팀의 공격
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

                else if (runCnt == 7) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                    runCnt = 3;

                    for(int i = 0; i<4; i++) {
                        if (iniCnt % 2 == 0) { // 이닝이 짝수 = 말에 홈팀의 공격
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    hscore++;
                                    et_hscore.setText("홈      " + choice_home + Integer.toString(hscore));
                                }
                            }, 500);
                        } else if (iniCnt % 2 == 1) { // 이닝이 홀수 = 초에 어웨이 팀의 공격
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    ascore++;
                                    et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                }
                            }, 500);
                        }
                    }

                    stkCnt = 0;
                    ballCnt = 0;

                    layout_SDT.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);
                }
            }
        });
        return v;
    }
}

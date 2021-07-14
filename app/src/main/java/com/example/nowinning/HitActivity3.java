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

import static com.example.nowinning.BSOActivity.ascore;
import static com.example.nowinning.BSOActivity.away_ining;
import static com.example.nowinning.BSOActivity.ballCnt;
import static com.example.nowinning.BSOActivity.btn_SBO;
import static com.example.nowinning.BSOActivity.btn_o;
import static com.example.nowinning.BSOActivity.et_ascore;
import static com.example.nowinning.BSOActivity.et_hscore;
import static com.example.nowinning.BSOActivity.home_ining;
import static com.example.nowinning.BSOActivity.hscore;
import static com.example.nowinning.BSOActivity.img0;
import static com.example.nowinning.BSOActivity.img1;
import static com.example.nowinning.BSOActivity.img2;
import static com.example.nowinning.BSOActivity.img3;
import static com.example.nowinning.BSOActivity.iniCnt;
import static com.example.nowinning.BSOActivity.runCnt;
import static com.example.nowinning.BSOActivity.stkCnt;
import static com.example.nowinning.start.choice_away;
import static com.example.nowinning.start.choice_home;

public class HitActivity3 extends Fragment {

    public static Button btn_HitOut3, btn_HitRun3, btn_HitBack3;
    private int i;
    public static LinearLayout layout_HIT3;





    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View hv3 = inflater.inflate(R.layout.hitter3, container, false);
        btn_HitOut3 = (Button) hv3.findViewById(R.id.btn_HitOut3);
        btn_HitRun3 = (Button) hv3.findViewById(R.id.btn_HitRun3);
        btn_HitBack3 = (Button) hv3.findViewById(R.id.btn_HitBack3);

        layout_HIT3 = (LinearLayout) hv3.findViewById(R.id.layout_HIT3);
        Handler handler = new Handler();

        btn_HitOut3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 추후 1루타 정보로 수정

                if (runCnt == 3) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.INVISIBLE); //주자 1루로 이동

                    runCnt = 0; //주자 1루
                    btn_o.performClick();


                    layout_HIT3.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);
                }

                else if (runCnt == 5) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.INVISIBLE);   // 주자 1루로 이동

                    runCnt = 2;
                    btn_o.performClick();


                    layout_HIT3.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 6) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.INVISIBLE);   // 주자 1루로 이동

                    runCnt = 1;
                    btn_o.performClick();


                    layout_HIT3.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 7) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.INVISIBLE);   // 주자 1루로 이동

                    runCnt = 4;
                    btn_o.performClick();


                    layout_HIT3.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }
            }
        });

        btn_HitRun3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 추후 1루타 정보로 수정

                if (runCnt == 3) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.INVISIBLE); //주자 1루로 이동

                    runCnt = 0; //주자 1루

                    if (iniCnt % 2 == 0) { // 이닝이 짝수 = 말에 홈팀의 공격
                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈      " + choice_home + Integer.toString(hscore));
                                home_ining++;
                            }
                        }, 500);
                    }

                    else if (iniCnt % 2 == 1) { // 이닝이 홀수 = 초에 어웨이 팀의 공격
                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                ascore++;
                                et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                away_ining++;
                            }
                        }, 500);
                    }

                    layout_HIT3.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);
                }

                else if (runCnt == 5) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.INVISIBLE);

                    runCnt = 2;

                    if (iniCnt % 2 == 0) { // 이닝이 짝수 = 말에 홈팀의 공격
                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈      " + choice_home + Integer.toString(hscore));
                                home_ining++;
                            }
                        }, 500);
                    } else if (iniCnt % 2 == 1) { // 이닝이 홀수 = 초에 어웨이 팀의 공격
                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                ascore++;
                                et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                away_ining++;
                            }
                        }, 500);
                    }


                    layout_HIT3.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 6) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.INVISIBLE);  // 주자 1루로 이동

                    runCnt = 1;

                    if (iniCnt % 2 == 0) { // 이닝이 짝수 = 말에 홈팀의 공격
                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈      " + choice_home + Integer.toString(hscore));
                                home_ining++;
                            }
                        }, 500);
                    }

                    else if (iniCnt % 2 == 1) { // 이닝이 홀수 = 초에 어웨이 팀의 공격
                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                ascore++;
                                et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                away_ining++;
                            }
                        }, 500);
                    }

                    layout_HIT3.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 7) {// 주자의 현재 위치
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
                                home_ining++;
                            }
                        }, 500);
                    } else if (iniCnt % 2 == 1) { // 이닝이 홀수 = 초에 어웨이 팀의 공격
                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                ascore++;
                                et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                away_ining++;
                            }
                        }, 500);
                    }


                    layout_HIT3.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }
            }
        });

        btn_HitBack3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (runCnt == 3) {// 주자의 현재 위치
                    img2.setText(img3.getText());
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.INVISIBLE); //주자 1루로 이동

                    runCnt = 2; //주자 1루

                    layout_HIT3.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);
                }

                else if (runCnt == 5) {// 주자의 현재 위치
                    Toast.makeText(getActivity(),"현재 상황에서 퇴루할 수 없습니다.", Toast.LENGTH_SHORT).show();

                    layout_HIT3.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 6) {// 주자의 현재 위치
                    img2.setText(img3.getText());
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.INVISIBLE);  // 주자 1루로 이동

                    runCnt = 4;

                    layout_HIT3.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 7) {// 주자의 현재 위치
                    Toast.makeText(getActivity(),"현재 상황에서 퇴루할 수 없습니다.", Toast.LENGTH_SHORT).show();

                    layout_HIT3.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }
            }
        });


        return hv3;
    }
}

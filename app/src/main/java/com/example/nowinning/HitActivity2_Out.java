package com.example.nowinning;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static com.example.nowinning.BSOActivity.bat_select;
import static com.example.nowinning.BSOActivity.btn_SBO;
import static com.example.nowinning.BSOActivity.btn_o;
import static com.example.nowinning.BSOActivity.img0;
import static com.example.nowinning.BSOActivity.img1;
import static com.example.nowinning.BSOActivity.img2;
import static com.example.nowinning.BSOActivity.img3;
import static com.example.nowinning.BSOActivity.runCnt;


public class HitActivity2_Out extends Fragment {

    public static Button btn_hit2_out1, btn_hit2_out2,btn_hit2_out3, btn_hit2_out4, btn_hit2_out5, btn_hit2_out6;
    public static int hit2_out1, hit2_out2, hit2_out3, hit2_out4, hit2_out5, hit2_out6; // 견제사 카운터

    public static LinearLayout layout_hit2_out; // 프래그먼트 레이아웃

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.hitter2_out, container, false);

        btn_hit2_out1 = (Button) v.findViewById(R.id.btn_hit2_out1); //견제사
        btn_hit2_out2 = (Button) v.findViewById(R.id.btn_hit2_out2); //수비 성공
        btn_hit2_out3 = (Button) v.findViewById(R.id.btn_hit2_out3); //병살
        btn_hit2_out4 = (Button) v.findViewById(R.id.btn_hit2_out4); //도루 실패
        btn_hit2_out5 = (Button) v.findViewById(R.id.btn_hit2_out5); //야수 선택
        btn_hit2_out6 = (Button) v.findViewById(R.id.btn_hit2_out6); //기타 사유

        layout_hit2_out=(LinearLayout) v.findViewById(R.id.layout_hit2_out);

        Handler handler = new Handler();

        if (bat_select[0] == 6) { //(ground:0/ hground:1/ bunt:2/ fly:3/ pop: 4)
            btn_hit2_out2.setVisibility(View.GONE);
            btn_hit2_out3.setVisibility(View.GONE);
            btn_hit2_out5.setVisibility(View.GONE);
        }


        btn_hit2_out1.setOnClickListener(new View.OnClickListener() {//견제사
            @Override
            public void onClick(View v) {

                if (runCnt == 2) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.INVISIBLE);   // 주자 2루로 이동

                    runCnt = 0; // 주자 1,2루
                    btn_o.performClick();

                    hit2_out1++;//투수 타자에게 각각 견제사++ 하는 코드 추가 요망
                    bat_select[0] = 6; // 타격 초기화

                    layout_hit2_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }


                else if (runCnt == 4) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.INVISIBLE);// 주자 1,2,3루로 이동

                    runCnt = 1;
                    btn_o.performClick();

                    hit2_out1++;//투수 타자에게 각각 견제사++ 하는 코드 추가 요망
                    bat_select[0] = 6; // 타격 초기화

                    layout_hit2_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }


                else if (runCnt == 5) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                    runCnt = 3;
                    btn_o.performClick();

                    hit2_out1++;//투수 타자에게 각각 견제사++ 하는 코드 추가 요망
                    bat_select[0] = 6; // 타격 초기화

                    layout_hit2_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 7) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                    runCnt = 6;
                    btn_o.performClick();

                    hit2_out1++;//투수 타자에게 각각 견제사++ 하는 코드 추가 요망
                    bat_select[0] = 6; // 타격 초기화

                    layout_hit2_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

            }
        });

        btn_hit2_out2.setOnClickListener(new View.OnClickListener() { //수비 성공으로 인한 아웃 나중에 텍스트 추가할 수 있으면 좋을듯
            @Override
            public void onClick(View v) {


                if (runCnt == 2) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.INVISIBLE);   // 주자 2루로 이동

                    runCnt = 0; // 주자 1,2루
                    btn_o.performClick();

                    hit2_out2++;//수비수와 타자에게 각각 수비 성공관련++ 하는 코드 추가 요망
                    bat_select[0] = 6; // 타격 초기화

                    layout_hit2_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }


                else if (runCnt == 4) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.INVISIBLE);// 주자 1,2,3루로 이동

                    runCnt = 1;
                    btn_o.performClick();

                    hit2_out2++;//투수 타자에게 각각 견제사++ 하는 코드 추가 요망
                    bat_select[0] = 6; // 타격 초기화

                    layout_hit2_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }


                else if (runCnt == 5) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                    runCnt = 3;
                    btn_o.performClick();

                    hit2_out2++;//투수 타자에게 각각 견제사++ 하는 코드 추가 요망
                    bat_select[0] = 6; // 타격 초기화

                    layout_hit2_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 7) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                    runCnt = 6;
                    btn_o.performClick();

                    hit2_out2++;//투수 타자에게 각각 견제사++ 하는 코드 추가 요망
                    bat_select[0] = 6; // 타격 초기화

                    layout_hit2_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

            }
        });

        btn_hit2_out3.setOnClickListener(new View.OnClickListener() { //병살로 인한 아웃 나중에 텍스트 추가할 수 있으면 좋을듯
            @Override
            public void onClick(View v) {


                if (runCnt == 2) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.INVISIBLE);   // 주자 2루로 이동

                    runCnt = 0; // 주자 1,2루
                    btn_o.performClick();

                    hit2_out3++;//수비수와 타자에게 각각 병살관련 카운트++ 하는 코드 추가 요망
                    bat_select[0] = 6; // 타격 초기화

                    layout_hit2_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }


                else if (runCnt == 4) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.INVISIBLE);// 주자 1,2,3루로 이동

                    runCnt = 1;
                    btn_o.performClick();

                    hit2_out3++;//투수 타자에게 각각 견제사++ 하는 코드 추가 요망
                    bat_select[0] = 6; // 타격 초기화

                    layout_hit2_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }


                else if (runCnt == 5) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                    runCnt = 3;
                    btn_o.performClick();

                    hit2_out3++;//투수 타자에게 각각 견제사++ 하는 코드 추가 요망
                    bat_select[0] = 6; // 타격 초기화

                    layout_hit2_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 7) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                    runCnt = 6;
                    btn_o.performClick();

                    hit2_out3++;//투수 타자에게 각각 견제사++ 하는 코드 추가 요망
                    bat_select[0] = 6; // 타격 초기화

                    layout_hit2_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

            }
        });

        btn_hit2_out4.setOnClickListener(new View.OnClickListener() { //도루 실패로 인한 아웃 나중에 텍스트 추가할 수 있으면 좋을듯
            @Override
            public void onClick(View v) {


                if (runCnt == 2) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.INVISIBLE);   // 주자 2루로 이동

                    runCnt = 0; // 주자 1,2루
                    btn_o.performClick();

                    hit2_out4++;//주자에게 각각 도루 실패로 인한 아웃++ 하는 코드 추가 요망
                    bat_select[0] = 6; // 타격 초기화

                    layout_hit2_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }


                else if (runCnt == 4) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.INVISIBLE);// 주자 1,2,3루로 이동

                    runCnt = 1;
                    btn_o.performClick();

                    hit2_out4++;//투수 타자에게 각각 견제사++ 하는 코드 추가 요망
                    bat_select[0] = 6; // 타격 초기화

                    layout_hit2_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }


                else if (runCnt == 5) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                    runCnt = 3;
                    btn_o.performClick();

                    hit2_out4++;//투수 타자에게 각각 견제사++ 하는 코드 추가 요망
                    bat_select[0] = 6; // 타격 초기화

                    layout_hit2_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 7) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                    runCnt = 6;
                    btn_o.performClick();

                    hit2_out4++;//투수 타자에게 각각 견제사++ 하는 코드 추가 요망
                    bat_select[0] = 6; // 타격 초기화

                    layout_hit2_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

            }
        });

        btn_hit2_out5.setOnClickListener(new View.OnClickListener() { //야수 선택으로 인한 아웃 나중에 텍스트 추가할 수 있으면 좋을듯
            @Override
            public void onClick(View v) {


                if (runCnt == 2) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.INVISIBLE);   // 주자 2루로 이동

                    runCnt = 0; // 주자 1,2루
                    btn_o.performClick();

                    hit2_out5++;//수비수와 주자에게 각각 야수선택으로 아웃카운트++ 하는 코드 추가 요망
                    bat_select[0] = 6; // 타격 초기화

                    layout_hit2_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }


                else if (runCnt == 4) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.INVISIBLE);// 주자 1,2,3루로 이동

                    runCnt = 1;
                    btn_o.performClick();

                    hit2_out5++;//투수 타자에게 각각 견제사++ 하는 코드 추가 요망
                    bat_select[0] = 6; // 타격 초기화

                    layout_hit2_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }


                else if (runCnt == 5) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                    runCnt = 3;
                    btn_o.performClick();

                    hit2_out5++;//투수 타자에게 각각 견제사++ 하는 코드 추가 요망
                    bat_select[0] = 6; // 타격 초기화

                    layout_hit2_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 7) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                    runCnt = 6;
                    btn_o.performClick();

                    hit2_out5++;//투수 타자에게 각각 견제사++ 하는 코드 추가 요망
                    bat_select[0] = 6; // 타격 초기화

                    layout_hit2_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

            }
        });

        btn_hit2_out6.setOnClickListener(new View.OnClickListener() { //기타 사유로 인한 아웃 나중에 텍스트 추가할 수 있으면 좋을듯
            @Override
            public void onClick(View v) {


                if (runCnt == 2) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.INVISIBLE);   // 주자 2루로 이동

                    runCnt = 0; // 주자 1,2루
                    btn_o.performClick();

                    hit2_out6++;//수비수와 타자에게 각각 아웃카운트++ 하는 코드 추가 요망
                    bat_select[0] = 6; // 타격 초기화

                    layout_hit2_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }


                else if (runCnt == 4) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.INVISIBLE);// 주자 1,2,3루로 이동

                    runCnt = 1;
                    btn_o.performClick();

                    hit2_out6++;//투수 타자에게 각각 견제사++ 하는 코드 추가 요망
                    bat_select[0] = 6; // 타격 초기화

                    layout_hit2_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }


                else if (runCnt == 5) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                    runCnt = 3;
                    btn_o.performClick();

                    hit2_out6++;//투수 타자에게 각각 견제사++ 하는 코드 추가 요망
                    bat_select[0] = 6; // 타격 초기화

                    layout_hit2_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 7) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                    runCnt = 6;
                    btn_o.performClick();

                    hit2_out6++;//투수 타자에게 각각 견제사++ 하는 코드 추가 요망
                    bat_select[0] = 6; // 타격 초기화

                    layout_hit2_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

            }
        });

        return v;
    }


}
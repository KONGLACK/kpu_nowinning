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

import static com.example.nowinning.BSOActivity.btn_SBO;
import static com.example.nowinning.BSOActivity.btn_o;
import static com.example.nowinning.BSOActivity.img0;
import static com.example.nowinning.BSOActivity.img1;
import static com.example.nowinning.BSOActivity.img2;
import static com.example.nowinning.BSOActivity.img3;
import static com.example.nowinning.BSOActivity.runCnt;


public class HitActivity3_Out extends Fragment {

    public static Button btn_hit1_out1, btn_hit1_out2;
    public static int hit1_out1; // 견제사 카운터

    public static LinearLayout layout_hit1_out; // 프래그먼트 레이아웃

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.hitter1_out, container, false);

        btn_hit1_out1 = (Button) v.findViewById(R.id.btn_hit1_out1); //견제사
        btn_hit1_out2 = (Button) v.findViewById(R.id.btn_hit1_out2); //기타 사유

        layout_hit1_out=(LinearLayout) v.findViewById(R.id.layout_hit1_out);

        Handler handler = new Handler();


        btn_hit1_out1.setOnClickListener(new View.OnClickListener() {//견제사
            @Override
            public void onClick(View v) {

                if (runCnt == 1) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.INVISIBLE);   // 주자 2루로 이동

                    runCnt = 0; // 주자 1,2루
                    btn_o.performClick();

                    hit1_out1++;//투수 타자에게 각각 견제사++ 하는 코드 추가 요망

                    layout_hit1_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }


                else if (runCnt == 4) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.INVISIBLE);// 주자 1,2,3루로 이동

                    runCnt = 2;
                    btn_o.performClick();

                    hit1_out1++;//투수 타자에게 각각 견제사++ 하는 코드 추가 요망

                    layout_hit1_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }


                else if (runCnt == 6) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                    runCnt = 3;
                    btn_o.performClick();

                    hit1_out1++;//투수 타자에게 각각 견제사++ 하는 코드 추가 요망

                    layout_hit1_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 7) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                    runCnt = 5;
                    btn_o.performClick();

                    hit1_out1++;//투수 타자에게 각각 견제사++ 하는 코드 추가 요망

                    layout_hit1_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

            }
        });

        btn_hit1_out2.setOnClickListener(new View.OnClickListener() { //기타 사유로 인한 아웃 나중에 텍스트 추가할 수 있으면 좋을듯
            @Override
            public void onClick(View v) {

                if (runCnt == 1) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.INVISIBLE);   // 주자 2루로 이동

                    runCnt = 0; // 주자 1,2루
                    btn_o.performClick();


                    layout_hit1_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }


                else if (runCnt == 4) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.INVISIBLE);// 주자 1,2,3루로 이동

                    runCnt = 2;
                    btn_o.performClick();


                    layout_hit1_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }


                else if (runCnt == 6) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                    runCnt = 3;
                    btn_o.performClick();


                    layout_hit1_out.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 7) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

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
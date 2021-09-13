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


public class HitActivity3_Back extends Fragment {

    public static Button btn_hit3_back1, btn_hit3_back2;// 진루x, 야수 선택
    public static int hit3_back1, hit3_back2; // 도루, 태그업, 희생 번트, 수비 에러 각각 카운터
    public static LinearLayout layout_hit3_back; // 플라이아웃 프래그먼트

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.hitter3_back, container, false);

        btn_hit3_back1 = (Button) v.findViewById(R.id.btn_hit3_back1);
        btn_hit3_back2 = (Button) v.findViewById(R.id.btn_hit3_back2);

        layout_hit3_back = (LinearLayout) v.findViewById(R.id.layout_hit3_back);

        Handler handler = new Handler();

        btn_hit3_back1.setOnClickListener(new View.OnClickListener() {//도루
            @Override
            public void onClick(View v) {

                if (runCnt == 3) {// 주자의 현재 위치
                    img2.setText(img3.getText());
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.INVISIBLE); //주자 1루로 이동

                    runCnt = 2; //주자 1루

                    layout_hit3_back.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);
                }

                else if (runCnt == 5) {// 주자의 현재 위치
                    Toast.makeText(getActivity(),"현재 상황에서 퇴루할 수 없습니다.", Toast.LENGTH_SHORT).show();

                    layout_hit3_back.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 6) {// 주자의 현재 위치
                    img2.setText(img3.getText());
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.INVISIBLE);  // 주자 1루로 이동

                    runCnt = 4;

                    layout_hit3_back.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 7) {// 주자의 현재 위치
                    Toast.makeText(getActivity(),"현재 상황에서 퇴루할 수 없습니다.", Toast.LENGTH_SHORT).show();

                    layout_hit3_back.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

            }
        });
        btn_hit3_back2.setOnClickListener(new View.OnClickListener() {//태그업 bat_select가 fly여야지 작동
            @Override
            public void onClick(View v) {

                if (runCnt == 3) {// 주자의 현재 위치
                    img2.setText(img3.getText());
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.INVISIBLE); //주자 1루로 이동

                    runCnt = 2; //주자 1루

                    layout_hit3_back.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);
                }

                else if (runCnt == 5) {// 주자의 현재 위치
                    Toast.makeText(getActivity(),"현재 상황에서 퇴루할 수 없습니다.", Toast.LENGTH_SHORT).show();

                    layout_hit3_back.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 6) {// 주자의 현재 위치
                    img2.setText(img3.getText());
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.INVISIBLE);  // 주자 1루로 이동

                    runCnt = 4;

                    layout_hit3_back.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 7) {// 주자의 현재 위치
                    Toast.makeText(getActivity(),"현재 상황에서 퇴루할 수 없습니다.", Toast.LENGTH_SHORT).show();

                    layout_hit3_back.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

            }
        });


        return v;
    }
}

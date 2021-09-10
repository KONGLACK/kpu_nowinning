package com.example.nowinning;

import android.os.Bundle;
import android.os.Handler;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import static com.example.nowinning.BSOActivity.ascore;
import static com.example.nowinning.BSOActivity.ballCnt;
import static com.example.nowinning.BSOActivity.btn_SBO;
import static com.example.nowinning.BSOActivity.btn_o;
import static com.example.nowinning.BSOActivity.et_ascore;
import static com.example.nowinning.BSOActivity.et_hscore;
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
import static com.example.nowinning.start.choice_home;
import static com.example.nowinning.start.choice_home;

public class HitActivity1 extends Fragment {

    public static Button btn_HitOut1, btn_HitRun1, btn_HitBack1;
    private int i;
    public static LinearLayout layout_HIT1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View hv1 = inflater.inflate(R.layout.hitter1, container, false);
        btn_HitOut1 = (Button) hv1.findViewById(R.id.btn_HitOut1);
        btn_HitRun1 = (Button) hv1.findViewById(R.id.btn_HitRun1);

        layout_HIT1 = (LinearLayout) hv1.findViewById(R.id.layout_HIT1);
        Handler handler = new Handler();



        btn_HitOut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 추후 1루타 정보로 수정


                if (runCnt == 1) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.INVISIBLE);   // 주자 2루로 이동

                    runCnt = 0; // 주자 1,2루
                    btn_o.performClick();

                    layout_HIT1.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }


                else if (runCnt == 4) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.INVISIBLE);// 주자 1,2,3루로 이동

                    runCnt = 2;
                    btn_o.performClick();


                    layout_HIT1.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }


                else if (runCnt == 6) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                    runCnt = 3;
                    btn_o.performClick();

                    layout_HIT1.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 7) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                    runCnt = 5;
                    btn_o.performClick();


                    layout_HIT1.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }
            }
        });

        btn_HitRun1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 추후 1루타 정보로 수정


                if (runCnt == 0) { // 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.VISIBLE); // 주자 2루로 이동

                    runCnt = 0;

                    layout_HIT1.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);
                }

                else if (runCnt == 1) {// 주자의 현재 위치
                    img2.setText(img1.getText());
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.INVISIBLE);   // 주자 2루로 이동

                    runCnt = 2; // 주자 1,2루


                    layout_HIT1.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 2) { // 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.INVISIBLE);// 주자 1루로 이동

                    runCnt = 2; //주자 2,3루



                    layout_HIT1.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 3) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.VISIBLE); //주자 1루로 이동

                    runCnt = 3; //주자 1루

                    layout_HIT1.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);
                }

                else if (runCnt == 4) {// 주자의 현재 위치
                    Toast.makeText(getActivity(),"현재 상황에서 진루할 수 없습니다.", Toast.LENGTH_SHORT).show();

                }

                else if (runCnt == 5) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.VISIBLE);

                    runCnt = 5;

                    layout_HIT1.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 6) {// 주자의 현재 위치
                    img2.setText(img1.getText());
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.VISIBLE);  // 주자 1루로 이동

                    runCnt = 5;

                    layout_HIT1.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 7) {// 주자의 현재 위치
                    Toast.makeText(getActivity(),"others의 전체 진루버튼 활용", Toast.LENGTH_SHORT).show();

                }
            }
        });



        return hv1;
    }
}

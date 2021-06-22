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

public class HitActivity2 extends Fragment {

    public static Button btn_HitOut2, btn_HitRun2, btn_HitBack2;
    private int i;
    public static LinearLayout layout_HIT2;





    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View hv2 = inflater.inflate(R.layout.hitter2, container, false);
        btn_HitOut2 = (Button) hv2.findViewById(R.id.btn_HitOut2);
        btn_HitRun2 = (Button) hv2.findViewById(R.id.btn_HitRun2);
        btn_HitBack2 = (Button) hv2.findViewById(R.id.btn_HitBack2);

        layout_HIT2 = (LinearLayout) hv2.findViewById(R.id.layout_HIT2);
        Handler handler = new Handler();

        btn_HitOut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 추후 1루타 정보로 수정


                if (runCnt == 2) { // 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.INVISIBLE);  // 주자 3루로 이동

                    runCnt = 0; //주자 2,3루
                    btn_o.performClick();


                    layout_HIT2.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }


                else if (runCnt == 4) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.INVISIBLE);// 주자 1,2,3루로 이동

                    runCnt = 1;
                    btn_o.performClick();


                    layout_HIT2.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 5) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                    runCnt = 3;
                    btn_o.performClick();


                    layout_HIT2.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 7) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                    runCnt = 6;
                    btn_o.performClick();


                    layout_HIT2.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }
            }
        });

        btn_HitRun2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 추후 1루타 정보로 수정

                if (runCnt == 2) { // 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.VISIBLE);// 주자 1루로 이동

                    runCnt = 3; //주자 2,3루

                    layout_HIT2.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }


                else if (runCnt == 4) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.VISIBLE);// 주자 1,2,3루로 이동

                    runCnt = 6;

                    layout_HIT2.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 5) {// 주자의 현재 위치
                    Toast.makeText(getActivity(),"현재 상황에서 진루할 수 없습니다.", Toast.LENGTH_SHORT).show();

                    layout_HIT2.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }


                else if (runCnt == 7) {// 주자의 현재 위치
                    Toast.makeText(getActivity(),"현재 상황에서 진루할 수 없습니다.", Toast.LENGTH_SHORT).show();

                    layout_HIT2.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);
                }
            }
        });

        btn_HitBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (runCnt == 2) { // 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.INVISIBLE);// 주자 1루로 이동

                    runCnt = 1; //주자 2,3루

                    layout_HIT2.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 4) {// 주자의 현재 위치
                    Toast.makeText(getActivity(),"현재 상황에서 퇴루할 수 없습니다.", Toast.LENGTH_SHORT).show();

                    layout_HIT2.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }

                else if (runCnt == 5) {// 주자의 현재 위치
                    img0.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.VISIBLE);

                    runCnt = 6;

                    layout_HIT2.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);

                }


                else if (runCnt == 7) {// 주자의 현재 위치
                    Toast.makeText(getActivity(), "현재 상황에서 퇴루할 수 없습니다.", Toast.LENGTH_SHORT).show();

                    layout_HIT2.setVisibility(View.INVISIBLE);
                    btn_SBO.setVisibility(View.VISIBLE);
                }
            }
        });


        return hv2;
    }
}

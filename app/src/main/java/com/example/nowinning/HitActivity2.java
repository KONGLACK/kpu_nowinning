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
import androidx.fragment.app.FragmentTransaction;

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

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                HitActivity2_Out hitActivity2_out = new HitActivity2_Out();
                transaction.replace(R.id.frame, hitActivity2_out);
                transaction.commit();

            }
        });

        btn_HitRun2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 추후 1루타 정보로 수정

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                HitActivity2_Run hitActivity2_run = new HitActivity2_Run();
                transaction.replace(R.id.frame, hitActivity2_run);
                transaction.commit();

            }
        });

        btn_HitBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                HitActivity2_Back hitActivity2_back = new HitActivity2_Back();
                transaction.replace(R.id.frame, hitActivity2_back);
                transaction.commit();

            }
        });


        return hv2;
    }
}

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

import static com.example.nowinning.BSOActivity.btn_SBO;
import static com.example.nowinning.BSOActivity.img0;
import static com.example.nowinning.BSOActivity.img1;
import static com.example.nowinning.BSOActivity.img2;
import static com.example.nowinning.BSOActivity.img3;
import static com.example.nowinning.BSOActivity.runCnt;

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

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                HitActivity1_Out hitActivity1_out = new HitActivity1_Out();
                transaction.replace(R.id.frame, hitActivity1_out);
                transaction.commit();

            }
        });

        btn_HitRun1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                HitActivity1_Run hitActivity1_run = new HitActivity1_Run();
                transaction.replace(R.id.frame, hitActivity1_run);
                transaction.commit();

            }
        });

        return hv1;
    }
}

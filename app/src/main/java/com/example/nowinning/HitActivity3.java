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

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

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

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                HitActivity3_Out hitActivity3_out = new HitActivity3_Out();
                transaction.replace(R.id.frame, hitActivity3_out);
                transaction.commit();


            }
        });

        btn_HitRun3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 추후 1루타 정보로 수정

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                HitActivity3_Run hitActivity3_run = new HitActivity3_Run();
                transaction.replace(R.id.frame, hitActivity3_run);
                transaction.commit();

            }

        });

        btn_HitBack3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                HitActivity3_Back hitActivity3_back = new HitActivity3_Back();
                transaction.replace(R.id.frame, hitActivity3_back);
                transaction.commit();

            }
        });


        return hv3;
    }
}

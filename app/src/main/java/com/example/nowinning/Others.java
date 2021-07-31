package com.example.nowinning;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Layout;
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

import static com.example.nowinning.BSOActivity.ballCnt;
import static com.example.nowinning.BSOActivity.btn_SBO;
import static com.example.nowinning.BSOActivity.btn_o;
import static com.example.nowinning.BSOActivity.et_ini;
import static com.example.nowinning.BSOActivity.et_out;
import static com.example.nowinning.BSOActivity.iniCnt;
import static com.example.nowinning.BSOActivity.outCnt;
import static com.example.nowinning.BSOActivity.runCnt;
import static com.example.nowinning.BSOActivity.stkCnt;


public class Others extends Fragment {

    public static Button btn_HBP, btn_Balk, btn_OutOthers, btn_PutonB, btn_test;
    public static LinearLayout layout_Others;


    Handler handler = new Handler();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.others, container, false);

        btn_HBP = (Button) v.findViewById(R.id.btn_HBP);
        btn_Balk = (Button) v.findViewById(R.id.btn_Balk);
        btn_OutOthers = (Button) v.findViewById(R.id.btn_OutOthers);
        btn_PutonB = (Button) v.findViewById(R.id.btn_PutonB);
        btn_test = (Button) v.findViewById(R.id.btn_test);

        layout_Others = (LinearLayout) v.findViewById(R.id.layout_Others);




        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i =0; i<9; i++){
                    iniCnt++;
                    Toast.makeText(getActivity(),"이닝 카운트가 8 증가합니다", Toast.LENGTH_SHORT).show();
                }
                /*FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                TestBtn testbtn = new TestBtn();
                transaction.replace(R.id.frame, testbtn);
                transaction.commit(); // */ //테스트 페이지 만들려면 살리세요
            }
        });

        btn_HBP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runCnt++;
                stkCnt = 0;
                ballCnt = 0;

                layout_Others.setVisibility(View.INVISIBLE);
                btn_SBO.setVisibility(View.VISIBLE);
            }
        });

        btn_Balk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runCnt++;
                stkCnt = 0;
                ballCnt = 0;

                layout_Others.setVisibility(View.INVISIBLE);
                btn_SBO.setVisibility(View.VISIBLE);
            }
        });


        btn_OutOthers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_o.performClick();
                layout_Others.setVisibility(View.INVISIBLE);
                btn_SBO.setVisibility(View.VISIBLE);
            }
        });

        btn_PutonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runCnt++;
                //다른 사유로 진루할 때 S/D/O 선택 후 알맞은 진루
                //사유를 적을 수 있게하는 것도 좋을듯
                layout_Others.setVisibility(View.INVISIBLE);
                btn_SBO.setVisibility(View.VISIBLE);
            }
        });

        return v;
    }
}
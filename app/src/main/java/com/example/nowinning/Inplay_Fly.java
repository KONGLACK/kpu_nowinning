package com.example.nowinning;

import android.os.Bundle;
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
import static com.example.nowinning.BSOActivity.btn_o;
import static com.example.nowinning.BSOActivity.outCnt;
import static com.example.nowinning.BSOActivity.runCnt;

public class Inplay_Fly extends Fragment {

    private Button btn_Out;
    public static Button btn_Hit, btn_Error, btn_Foul, btn_ItpHR, btn_Bfoul;
    private int i;
    public static LinearLayout layout_Fly;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.inplay_f, container, false);

        btn_Out = (Button) v.findViewById(R.id.btn_Out);
        btn_Hit = (Button) v.findViewById(R.id.btn_Hit);
        btn_Error = (Button) v.findViewById(R.id.btn_Error);
        btn_Foul = (Button) v.findViewById(R.id.btn_Foul);
        btn_ItpHR = (Button) v.findViewById(R.id.btn_ItpHR);
        //btn_Bfoul = (Button) v.findViewById(R.id.btn_Bfoul);

        layout_Fly = (LinearLayout) v.findViewById(R.id.layout_Fly);




        btn_Out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(outCnt<2) {
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    Flyout flyout = new Flyout();
                    transaction.replace(R.id.frame, flyout);
                    transaction.commit(); // 저장
                }
                else if(outCnt>=2){ // 2아웃 이상일 땐 바로 아웃
                    btn_o.performClick();

                    btn_SBO.setVisibility(View.VISIBLE);
                    layout_Fly.setVisibility(View.INVISIBLE);
                }
            }
        });

        btn_Hit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                SDT_select sdt_select = new SDT_select();
                transaction.replace(R.id.frame, sdt_select);
                transaction.commit(); // 저장
            }
        });

        btn_Error.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"추가 예정", Toast.LENGTH_SHORT).show();

            }
        });

        btn_Foul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"추가 예정", Toast.LENGTH_SHORT).show();

            }
        });

        btn_ItpHR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"추가 예정", Toast.LENGTH_SHORT).show();
            }
        });

        /*btn_Bfoul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"추가 예정", Toast.LENGTH_SHORT).show();

            }
        });*/


        return v;
    }
}

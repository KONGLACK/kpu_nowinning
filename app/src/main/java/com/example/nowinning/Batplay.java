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
import static com.example.nowinning.BSOActivity.img0;

public class Batplay extends Fragment {

    public static Button btn1, btn2, btn3, btn4, btn5, btn6;
    public static LinearLayout layout_batplay;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.inplay, container, false);

        btn1 = (Button) v.findViewById(R.id.btn1);
        btn2 = (Button) v.findViewById(R.id.btn2);
        btn3 = (Button) v.findViewById(R.id.btn3);
        btn4 = (Button) v.findViewById(R.id.btn4);
        btn5 = (Button) v.findViewById(R.id.btn5);

        layout_batplay = (LinearLayout)v.findViewById(R.id.layout_batplay);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"임시 페이지로 이동", Toast.LENGTH_SHORT).show();

                btn_SBO.setVisibility(View.INVISIBLE);
                layout_batplay.setVisibility(View.VISIBLE);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"임시 페이지로 이동", Toast.LENGTH_SHORT).show();

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Inplay_Bunt inplay_bunt = new Inplay_Bunt();
                transaction.replace(R.id.frame, inplay_bunt);
                transaction.commit(); // 저장
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Inplay_Bunt inplay_bunt = new Inplay_Bunt();
                transaction.replace(R.id.frame, inplay_bunt);
                transaction.commit(); // 저장
            }
        });

        /*btn_Line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //타격이 Line Drive일 때 프래그먼트로 이동
            }
        });*/

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Inplay_Fly inplay_fly = new Inplay_Fly();
                transaction.replace(R.id.frame, inplay_fly);
                transaction.commit(); // 저장
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Inplay_Pop inplay_pop = new Inplay_Pop();
                transaction.replace(R.id.frame, inplay_pop);
                transaction.commit(); // 저장
            }
        });
        return v;
    }
}


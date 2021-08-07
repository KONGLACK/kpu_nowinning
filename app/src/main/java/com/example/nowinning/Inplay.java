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

public class Inplay extends Fragment {

    public static Button btn_Ground, btn_Hground, btn_Bunt, btn_Line, btn_Fly, btn_Pop;
    public static LinearLayout layout_Inplay;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.inplay, container, false);

        btn_Ground = (Button) v.findViewById(R.id.btn_Ground);
        btn_Hground = (Button) v.findViewById(R.id.btn_Hground);
        btn_Bunt = (Button) v.findViewById(R.id.btn_Bunt);
        //btn_Line = (Button) v.findViewById(R.id.btn_Line);
        btn_Fly = (Button) v.findViewById(R.id.btn_Fly);
        btn_Pop = (Button) v.findViewById(R.id.btn_Pop);

        layout_Inplay = (LinearLayout)v.findViewById(R.id.layout_Inplay);


        btn_Ground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"임시 페이지로 이동", Toast.LENGTH_SHORT).show();

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Inplay_Bunt inplay_bunt = new Inplay_Bunt();
                transaction.replace(R.id.frame, inplay_bunt);
                transaction.commit(); // 저장

            }
        });

        btn_Hground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"임시 페이지로 이동", Toast.LENGTH_SHORT).show();

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Inplay_Bunt inplay_bunt = new Inplay_Bunt();
                transaction.replace(R.id.frame, inplay_bunt);
                transaction.commit(); // 저장
            }
        });

        btn_Bunt.setOnClickListener(new View.OnClickListener() {
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

        btn_Fly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Inplay_Fly inplay_fly = new Inplay_Fly();
                transaction.replace(R.id.frame, inplay_fly);
                transaction.commit(); // 저장
            }
        });

        btn_Pop.setOnClickListener(new View.OnClickListener() {
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


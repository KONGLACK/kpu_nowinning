package com.example.nowinning;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static com.example.nowinning.BSOActivity.ballCnt;
import static com.example.nowinning.BSOActivity.mImgView;
import static com.example.nowinning.Others.btn_OutOthers;
import static com.example.nowinning.BSOActivity.btn_SBO;
import static com.example.nowinning.BSOActivity.et_ascore;
import static com.example.nowinning.BSOActivity.et_hscore;
import static com.example.nowinning.BSOActivity.et_strike;
import static com.example.nowinning.BSOActivity.iniCnt;
import static com.example.nowinning.BSOActivity.outCnt;
import static com.example.nowinning.BSOActivity.runCnt;
import static com.example.nowinning.BSOActivity.hscore;
import static com.example.nowinning.BSOActivity.ascore;
import static com.example.nowinning.BSOActivity.stkCnt;
import static com.example.nowinning.start.choice_home;
import static com.example.nowinning.start.choice_away;

public class SDT_select extends Fragment {

    public static Button btn_Single, btn_Double, btn_Triple;
    private int i;
    public static LinearLayout layout_SDT;





    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.sdt, container, false);
        btn_Single = (Button) v.findViewById(R.id.btn_Single);
        btn_Double = (Button) v.findViewById(R.id.btn_Double);
        btn_Triple = (Button) v.findViewById(R.id.btn_Triple);

        layout_SDT = (LinearLayout) v.findViewById(R.id.layout_SDT);
        Handler handler = new Handler();

        final Animation translateHS = AnimationUtils.loadAnimation(getActivity(),R.anim.translate_h2s);
        final Animation translateHD = AnimationUtils.loadAnimation(getActivity(),R.anim.translate_h2d);
        final Animation translateHT = AnimationUtils.loadAnimation(getActivity(),R.anim.translate_h2t);

        final Animation translateSD = AnimationUtils.loadAnimation(getActivity(),R.anim.translate_s2d);
        final Animation translateST = AnimationUtils.loadAnimation(getActivity(),R.anim.translate_s2t);

        final Animation translateDS = AnimationUtils.loadAnimation(getActivity(),R.anim.translate_d2s);
        final Animation translateDT = AnimationUtils.loadAnimation(getActivity(),R.anim.translate_d2t);

        final Animation translateTD = AnimationUtils.loadAnimation(getActivity(),R.anim.translate_t2d);
        final Animation translateTH = AnimationUtils.loadAnimation(getActivity(),R.anim.translate_t2h);




        btn_Single.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 // 추후 1루타 정보로 수정

                mImgView.setVisibility(View.VISIBLE);

                if(runCnt==0){
                    mImgView.startAnimation(translateHS);
                }
                else if(runCnt==1){
                    mImgView.startAnimation(translateSD);
                }
                else if(runCnt==2){
                    mImgView.startAnimation(translateDT);
                }
                else if(runCnt==3){
                    mImgView.startAnimation(translateTH);
                }
                runCnt++;
                if(iniCnt%2 == 0){ // 이닝이 짝수 = 말에 홈팀의 공격
                    if(runCnt == 4){ // runcnt가 4가 될 경우 꼭 점수가 발생
                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈      "+choice_home+Integer.toString(hscore));
                                mImgView.setVisibility(View.INVISIBLE);
                            }
                        }, 500);
                        runCnt = 0; // 무조건 친 루타만 진루한다고 가정하고 임시로 설정(에러 등 변수 제외)
                    }
                }

                else if(iniCnt%2 == 1){ // 이닝이 홀수 = 초에 어웨이 팀의 공격
                    if(runCnt == 4){ // runcnt가 4가 될 경우 꼭 점수가 발생
                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                ascore++;
                                et_ascore.setText("원정   "+choice_away+Integer.toString(ascore));
                                mImgView.setVisibility(View.INVISIBLE);
                            }
                        }, 500);
                        runCnt = 0; // 주루 카운트 ++
                    }
                }

                stkCnt = 0;
                ballCnt = 0;

                layout_SDT.setVisibility(View.INVISIBLE);
                btn_SBO.setVisibility(View.VISIBLE);
            }

        });

        btn_Double.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(runCnt==0){
                    mImgView.startAnimation(translateHD);
                }
                else if(runCnt==1){
                    mImgView.startAnimation(translateST);

                }
                else if(runCnt==2){
                    mImgView.startAnimation(translateDT);
                }
                /*else if(runCnt==3){
                    mImgView.startAnimation(translateDH);
                }*/

                for(i = 0; i < 2; i++){
                    runCnt++; // 추후 2루타 정보로 수정
                }
                if(iniCnt%2 == 0){ // 이닝이 짝수 = 말에 홈팀의 공격
                    if(runCnt == 4){ // runcnt가 4가 될 경우 꼭 점수가 발생
                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈      "+choice_home + Integer.toString(hscore));
                                runCnt = 0; // 무조건 친 루타만 진루한다고 가정하고 임시로 설정(에러 등 변수 제외)
                            }
                        }, 500);
                        runCnt = 0; // 주루 카운트 ++
                    }
                }

                else if(iniCnt%2 == 1){ // 이닝이 홀수 = 초에 어웨이 팀의 공격
                    if(runCnt == 4){ // runcnt가 4가 될 경우 꼭 점수가 발생
                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                ascore++;
                                et_ascore.setText("원정   "+choice_away + Integer.toString(ascore));
                                runCnt = 0; // 무조건 친 루타만 진루한다고 가정하고 임시로 설정(에러 등 변수 제외)
                            }
                        }, 500);
                        runCnt = 0; // 주루 카운트 ++
                    }
                }

                stkCnt = 0;
                ballCnt = 0;

                layout_SDT.setVisibility(View.INVISIBLE);
                btn_SBO.setVisibility(View.VISIBLE);
            }
        });

        btn_Triple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(runCnt==0){
                    mImgView.startAnimation(translateHT);
                }
                /*else if(runCnt==1){
                    mImgView.startAnimation(translateST);
                }
                else if(runCnt==2){
                    mImgView.startAnimation(translateDT);
                }
                else if(runCnt==3){
                    mImgView.startAnimation(translateTH);
                }*/

                for(i = 0; i < 3; i++){
                    runCnt++; // 추후 3루타 정보로 수정
                }
                if(iniCnt%2 == 0){ // 이닝이 짝수 = 말에 홈팀의 공격
                    if(runCnt == 4){ // runcnt가 4가 될 경우 꼭 점수가 발생
                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("HOME "+Integer.toString(hscore));
                                runCnt = 0; // 무조건 친 루타만 진루한다고 가정하고 임시로 설정(에러 등 변수 제외)
                            }
                        }, 500);
                        runCnt = 0; // 주루 카운트 ++
                    }
                }

                else if(iniCnt%2 == 1){ // 이닝이 홀수 = 초에 어웨이 팀의 공격
                    if(runCnt == 4){ // runcnt가 4가 될 경우 꼭 점수가 발생
                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                ascore++;
                                et_ascore.setText("AWAY "+Integer.toString(ascore));
                                runCnt = 0; // 무조건 친 루타만 진루한다고 가정하고 임시로 설정(에러 등 변수 제외)
                            }
                        }, 500);
                        runCnt = 0; // 주루 카운트 ++
                    }
                }

                stkCnt = 0;
                ballCnt = 0;

                layout_SDT.setVisibility(View.INVISIBLE);
                btn_SBO.setVisibility(View.VISIBLE);
            }
        });


        return v;
    }
}

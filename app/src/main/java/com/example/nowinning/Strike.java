package com.example.nowinning;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.nowinning.BSOActivity.ini_num;
import static com.example.nowinning.Others.btn_OutOthers;
import static com.example.nowinning.BSOActivity.btn_SBO;
import static com.example.nowinning.BSOActivity.btn_h;
import static com.example.nowinning.BSOActivity.btn_o;
import static com.example.nowinning.BSOActivity.btn_other;
import static com.example.nowinning.BSOActivity.et_out;
import static com.example.nowinning.BSOActivity.et_strike;
import static com.example.nowinning.BSOActivity.outCnt;
import static com.example.nowinning.BSOActivity.stkCnt;
import static com.example.nowinning.start.away_pitcher;
import static com.example.nowinning.start.choice_away;
import static com.example.nowinning.start.choice_home;
import static com.example.nowinning.start.home_pitcher;

public class Strike extends Fragment {

    public static Button btn_Swing, btn_Miss;
    public static int sStrike, mStrike; // 스윙 미스 판별
    public static LinearLayout layout_Strike; // 스트라이크 프래그먼트

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.strike, container, false);

        btn_Swing = (Button) v.findViewById(R.id.btn_Swing);
        btn_Miss = (Button) v.findViewById(R.id.btn_Miss);

        layout_Strike=(LinearLayout) v.findViewById(R.id.layout_Strike);

        Handler handler = new Handler();

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };


        btn_Swing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_strike.setText(et_strike.getText().toString() + "*"); // 별 찍음
                stkCnt++; //스트라이크 카운트 세기 위해
                sStrike++;
                if (stkCnt == 3) {
                    handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                        @Override
                        public void run() {
                            et_strike.setText("S ");

                            stkCnt = 0;
                            sStrike = 0;

                            btn_o.performClick();
                        }
                    }, 500);

                    if(ini_num%2==1) {
                        PithcerReqeust_SO_Home PithcerReqeust_SO_Home = new PithcerReqeust_SO_Home(choice_away, choice_home, home_pitcher, responseListener);
                        RequestQueue queue6 = Volley.newRequestQueue(getContext());
                        queue6.add(PithcerReqeust_SO_Home);
                    }
                    if(ini_num%2==0) {
                        PithcerReqeust_SO_Away PithcerReqeust_SO_Away = new PithcerReqeust_SO_Away(choice_away, choice_home, away_pitcher, responseListener);
                        RequestQueue queue7 = Volley.newRequestQueue(getContext());
                        queue7.add(PithcerReqeust_SO_Away);
                    }
                }

                btn_SBO.setVisibility(View.VISIBLE);
                layout_Strike.setVisibility(View.INVISIBLE);

            }
        });

        btn_Miss.setOnClickListener(new View.OnClickListener() { // 타자가 스트라이크 존에 들어온 공에 타격을 시도하지 않은 경우
            @Override
            public void onClick(View v) {
                et_strike.setText(et_strike.getText().toString() + "*"); // 별 찍음
                stkCnt++; //스트라이크 카운트 세기 위해
                mStrike++;
                if (stkCnt == 3) {
                    handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                        @Override
                        public void run() {
                            et_strike.setText("S ");
                            stkCnt = 0;
                            mStrike = 0;

                            btn_o.performClick();
                        }
                    }, 500);
                    if(ini_num%2==1) {
                        PithcerReqeust_SO_Home PithcerReqeust_SO_Home = new PithcerReqeust_SO_Home(choice_away, choice_home, home_pitcher, responseListener);
                        RequestQueue queue6 = Volley.newRequestQueue(getContext());
                        queue6.add(PithcerReqeust_SO_Home);
                    }
                    if(ini_num%2==0) {
                        PithcerReqeust_SO_Away PithcerReqeust_SO_Away = new PithcerReqeust_SO_Away(choice_away, choice_home, away_pitcher, responseListener);
                        RequestQueue queue7 = Volley.newRequestQueue(getContext());
                        queue7.add(PithcerReqeust_SO_Away);
                    }
                }

                btn_SBO.setVisibility(View.VISIBLE);
                layout_Strike.setVisibility(View.INVISIBLE);
            }
        });


        return v;
    }


}
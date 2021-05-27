package com.example.nowinning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.nowinning.BallRequest;
import com.example.nowinning.Inplay;
import com.example.nowinning.Others;
import com.example.nowinning.OutRequest;
import com.example.nowinning.R;
import com.example.nowinning.Strike;
import com.example.nowinning.StrikeRequest;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.nowinning.SDT_select.layout_SDT;

public class BSOActivity extends AppCompatActivity {

    public static EditText et_strike, et_ball, et_out, et_hscore, et_ascore, et_ini;
    public static Button btn_s, btn_b, btn_other, btn_h , btn_o, oCnt;
    public static LinearLayout btn_SBO;

    public int i,j;
    public static int stkCnt, ballCnt, outCnt; //sCnt, bCnt, oCnt은 다른 곳에서도 쓰일 거 같아서 퍼블릭
    public static int hscore, ascore; // 해당 이닝에 발생한 점수
    public static int runCnt = 0; // 진루 카운트를 통해 진루 컨트롤
    public static int iniCnt = 1 ; // 이닝 카운트를 통해 현재 이닝 표시

    public static ImageView mImgView;

    FrameLayout frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ballstrike);

        mImgView = (ImageView) findViewById(R.id.img1);


        et_strike = (EditText)findViewById(R.id.et_strike);
        et_ball = (EditText)findViewById(R.id.et_ball);
        et_out = (EditText)findViewById(R.id.et_out);
        et_hscore = (EditText)findViewById(R.id.et_hscore);
        et_ascore = (EditText)findViewById(R.id.et_ascore);
        et_ini = (EditText)findViewById(R.id.et_ini);

        btn_s = (Button)findViewById(R.id.strike_button);
        btn_b = (Button)findViewById(R.id.ball_button);
        btn_o = (Button)findViewById(R.id.out_button);

        btn_other = (Button)findViewById(R.id.other_button);
        btn_h = (Button)findViewById(R.id.hit_button);

        btn_SBO = (LinearLayout)findViewById(R.id.btn_SBO);
        //oCnt = (Button)findViewById(R.id.cnt_button);

        final Animation translateHS = AnimationUtils.loadAnimation(this,R.anim.translate_h2s);
        final Animation translateHD = AnimationUtils.loadAnimation(this,R.anim.translate_h2d);
        final Animation translateHT = AnimationUtils.loadAnimation(this,R.anim.translate_h2t);

        final Animation translateSD = AnimationUtils.loadAnimation(this,R.anim.translate_s2d);
        final Animation translateST = AnimationUtils.loadAnimation(this,R.anim.translate_s2t);

        final Animation translateDS = AnimationUtils.loadAnimation(this,R.anim.translate_d2s);
        final Animation translateDT = AnimationUtils.loadAnimation(this,R.anim.translate_d2t);

        final Animation translateTD = AnimationUtils.loadAnimation(this,R.anim.translate_t2d);
        final Animation translateTH = AnimationUtils.loadAnimation(this,R.anim.translate_t2h);


        Handler handler = new Handler();


        btn_s.setOnClickListener(new View.OnClickListener() {
            int strike = 0;
            @Override
            public void onClick(View v) {
                strike++;
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
                StrikeRequest strikeRequest = new StrikeRequest(strike, responseListener);
                RequestQueue queue = Volley.newRequestQueue(BSOActivity.this);
                queue.add(strikeRequest);


                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Strike strike_fragment = new Strike();
                transaction.replace(R.id.frame, strike_fragment);
                transaction.commit();
                btn_SBO.setVisibility(View.INVISIBLE);

            }
        });

        btn_b.setOnClickListener(new View.OnClickListener() {
            int ball = 0;
            @Override
            public void onClick(View v) {
                ball++;
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
                BallRequest ballRequest = new BallRequest(ball, responseListener);
                RequestQueue queue = Volley.newRequestQueue(BSOActivity.this);
                queue.add(ballRequest);

                et_ball.setText(et_ball.getText().toString() +"*"); // 별 찍음
                ballCnt++; //스트라이크 카운트 세기 위해
                if (ballCnt == 4) {
                    handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                        @Override
                        public void run() {
                            et_ball.setText("B ");
                            ballCnt = 0;
                        }
                    }, 500);

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

                    runCnt++; // 주루 카운트 ++
                }
            }
        });

        btn_o.setOnClickListener(new View.OnClickListener() {
            int outout = 0;
            @Override
            public void onClick(View v) {
                outout++;

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
                OutRequest outRequest = new OutRequest(outout, responseListener);
                RequestQueue queue = Volley.newRequestQueue(BSOActivity.this);
                queue.add(outRequest);

                et_out.setText(et_out.getText().toString() + "*"); // 별 찍음
                outCnt++; //스트라이크 카운트 세기 위해
                et_strike.setText("S ");
                stkCnt = 0 ;
                et_ball.setText("B ");
                ballCnt = 0 ;
                if (outCnt == 3) {
                    handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                        @Override
                        public void run() {
                           et_out.setText("O ");
                            outCnt = 0;
                            Toast.makeText(BSOActivity.this,"이닝 변경", Toast.LENGTH_SHORT).show();
                        }
                    }, 500);

                    iniCnt++; // 주루 카운트 ++
                    et_ini.setText(Integer.toString(iniCnt)+ "이닝");
                }
            }
        });

        btn_other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Others others_fragment = new Others();
                transaction.replace(R.id.frame, others_fragment);
                transaction.commit();
                btn_SBO.setVisibility(View.INVISIBLE);
            }
        });

        btn_h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Inplay inplay_fragment = new Inplay();
                transaction.replace(R.id.frame, inplay_fragment);
                transaction.commit();
                btn_SBO.setVisibility(View.INVISIBLE);

            }
        });

        mImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Batplay batplay_fragment = new Batplay();
                transaction.replace(R.id.frame, batplay_fragment);
                transaction.commit();
                btn_SBO.setVisibility(View.INVISIBLE);
                //hi

            }
        });

       /* oCnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BSOActivity.this,Integer.toString(runCnt), Toast.LENGTH_SHORT).show();
                //replaceSDT();
            }
        });
    */


    }
}

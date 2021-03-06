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

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.nowinning.BSOActivity.away_ining;
import static com.example.nowinning.BSOActivity.ballCnt;
import static com.example.nowinning.BSOActivity.h;
import static com.example.nowinning.BSOActivity.home_arr;
import static com.example.nowinning.BSOActivity.home_ining;
import static com.example.nowinning.BSOActivity.img0;
import static com.example.nowinning.BSOActivity.img1;
import static com.example.nowinning.BSOActivity.img2;
import static com.example.nowinning.BSOActivity.img3;
import static com.example.nowinning.BSOActivity.ini_num;
import static com.example.nowinning.BSOActivity.btn_SBO;
import static com.example.nowinning.BSOActivity.et_ascore;
import static com.example.nowinning.BSOActivity.et_hscore;
import static com.example.nowinning.BSOActivity.runCnt;
import static com.example.nowinning.BSOActivity.hscore;
import static com.example.nowinning.BSOActivity.ascore;
import static com.example.nowinning.BSOActivity.stkCnt;
import static com.example.nowinning.start.away_pitcher;
import static com.example.nowinning.start.choice_home;
import static com.example.nowinning.start.choice_away;
import static com.example.nowinning.BSOActivity.a;
import static com.example.nowinning.BSOActivity.away_arr;
import static com.example.nowinning.start.home_pitcher;

public class SDT_select extends Fragment {

    public static Button btn_Single, btn_Double, btn_Triple, btn_Homerun;
    public static int a_SingleCount=0, a_DoubleCount=0, a_TripleCount=0;
    public static int h_SingleCount=0, h_DoubleCount=0, h_TripleCount=0;
    private int i;
    public static LinearLayout layout_SDT;
    public static int[] away_singleCount = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static int[] home_singleCount = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    public static int[] away_doubleCount = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static int[] home_doubleCount = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static int[] away_tripleCount = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static int[] home_tripleCount = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    //hi

    @Override
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.sdt, container, false);
        btn_Single = (Button) v.findViewById(R.id.btn_Single);
        btn_Double = (Button) v.findViewById(R.id.btn_Double);
        btn_Triple = (Button) v.findViewById(R.id.btn_Triple);
        btn_Homerun = (Button) v.findViewById(R.id.btn_Homerun);

        layout_SDT = (LinearLayout) v.findViewById(R.id.layout_SDT);
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

        btn_Single.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 추후 1루타 정보로 수정
                if (ini_num % 2 == 1) {
                    PithcerReqeust_Hits_Home PithcerReqeust_Hits_Home = new PithcerReqeust_Hits_Home(choice_away, choice_home, home_pitcher, responseListener);
                    RequestQueue queue6 = Volley.newRequestQueue(getContext());
                    queue6.add(PithcerReqeust_Hits_Home);

                    if (runCnt == 0) { // 주자의 현재 위치
                        BatterRequest_One_away batterRequestOne = new BatterRequest_One_away(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestOne);

                        a++;
                        if(a>8) {
                            a=0;
                        }

                        img1.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.VISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.INVISIBLE); // 주자 1루로 이동

                        runCnt = 1;

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    } else if (runCnt == 1) {// 주자의 현재 위치
                        BatterRequest_One_away batterRequestOne = new BatterRequest_One_away(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestOne);
                        a++;
                        if(a>8) {
                            a=0;
                        }
                        img2.setText(img1.getText());
                        img1.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.VISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.INVISIBLE);   // 주자 2루로 이동

                        runCnt = 4; // 주자 1,2루

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 2) { // 주자의 현재 위치
                        BatterRequest_One_away batterRequestOne = new BatterRequest_One_away(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestOne);
                        a++;
                        if(a>8) {
                            a=0;
                        }
                        img3.setText(img2.getText());
                        img1.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.VISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE);  // 주자 3루로 이동

                        runCnt = 6; //주자 2,3루

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 3) {// 주자의 현재 위치
                        BatterRequest_One_away batterRequestOne = new BatterRequest_One_away(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestOne);

                        RBIRequest_away RBIRequest_away = new RBIRequest_away(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue1 = Volley.newRequestQueue(getContext());
                        queue1.add(RBIRequest_away);

                        ScoreRequest_away ScoreRequest_away = new ScoreRequest_away(choice_away, choice_home, (String) img3.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_away);

                        PithcerReqeust_ER_Home PithcerReqeust_ER_Home = new PithcerReqeust_ER_Home(choice_away, choice_home, home_pitcher, responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(PithcerReqeust_ER_Home);

                        a++;
                        if(a>8) {
                            a=0;
                        }
                        img1.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.VISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.INVISIBLE); //주자 1루로 이동

                        runCnt = 1; //주자 1루

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                ascore++;
                                et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                away_ining++;
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    } else if (runCnt == 4) {// 주자의 현재 위치
                        BatterRequest_One_away batterRequestOne = new BatterRequest_One_away(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestOne);
                        a++;
                        if(a>8) {
                            a=0;
                        }
                        img3.setText(img2.getText());
                        img2.setText(img1.getText());
                        img1.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.VISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.VISIBLE);// 주자 1,2,3루로 이동

                        runCnt = 7;

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 5) {// 주자의 현재 위치
                        BatterRequest_One_away batterRequestOne = new BatterRequest_One_away(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestOne);

                        RBIRequest_away RBIRequest_away = new RBIRequest_away(choice_away,  choice_home, away_arr[a], responseListener);
                        RequestQueue queue1 = Volley.newRequestQueue(getContext());
                        queue1.add(RBIRequest_away);

                        ScoreRequest_away ScoreRequest_away = new ScoreRequest_away(choice_away, choice_home,  (String) img3.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_away);

                        PithcerReqeust_ER_Home PithcerReqeust_ER_Home = new PithcerReqeust_ER_Home(choice_away, choice_home, home_pitcher, responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(PithcerReqeust_ER_Home);
                        a++;
                        if(a>8) {
                            a=0;
                        }
                        img3.setText(img2.getText());
                        img1.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.VISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                        runCnt = 6;

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                ascore++;
                                et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                away_ining++;
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 6) {// 주자의 현재 위치
                        BatterRequest_One_away batterRequestOne = new BatterRequest_One_away(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestOne);

                        RBIRequest_away RBIRequest_away = new RBIRequest_away(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue1 = Volley.newRequestQueue(getContext());
                        queue1.add(RBIRequest_away);

                        ScoreRequest_away ScoreRequest_away = new ScoreRequest_away(choice_away, choice_home,  (String) img3.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_away);

                        PithcerReqeust_ER_Home PithcerReqeust_ER_Home = new PithcerReqeust_ER_Home(choice_away, choice_home, home_pitcher, responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(PithcerReqeust_ER_Home);
                        a++;
                        if(a>8) {
                            a=0;
                        }
                        img2.setText(img1.getText());
                        img1.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.VISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.INVISIBLE);   // 주자 1루로 이동

                        runCnt = 4;

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                ascore++;
                                et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                away_ining++;
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 7) {// 주자의 현재 위치
                        BatterRequest_One_away batterRequestOne = new BatterRequest_One_away(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestOne);

                        RBIRequest_away RBIRequest_away = new RBIRequest_away(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue1 = Volley.newRequestQueue(getContext());
                        queue1.add(RBIRequest_away);

                        ScoreRequest_away ScoreRequest_away = new ScoreRequest_away(choice_away, choice_home,  (String) img3.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_away);

                        PithcerReqeust_ER_Home PithcerReqeust_ER_Home = new PithcerReqeust_ER_Home(choice_away, choice_home, home_pitcher, responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(PithcerReqeust_ER_Home);
                        a++;
                        if(a>8) {
                            a=0;
                        }
                        img3.setText(img2.getText());
                        img2.setText(img1.getText());
                        img1.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.VISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                        runCnt = 7;

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                ascore++;
                                et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                away_ining++;
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    }
                }





                if(ini_num%2==0) {
                    PithcerReqeust_Hits_Away PithcerReqeust_Hits_Away = new PithcerReqeust_Hits_Away(choice_away, choice_home, away_pitcher, responseListener);
                    RequestQueue queue7 = Volley.newRequestQueue(getContext());
                    queue7.add(PithcerReqeust_Hits_Away);
                    if (runCnt == 0) { // 주자의 현재 위치
                        BatterRequest_One_home batterRequestOne = new BatterRequest_One_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestOne);
                        h++;
                        if(h>8) {
                            h=0;
                        }
                        img1.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.VISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.INVISIBLE); // 주자 1루로 이동

                        runCnt = 1;

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    } else if (runCnt == 1) {// 주자의 현재 위치
                        BatterRequest_One_home batterRequestOne = new BatterRequest_One_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestOne);
                        h++;
                        if(h>8) {
                            h=0;
                        }
                        img2.setText(img1.getText());
                        img1.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.VISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.INVISIBLE);   // 주자 2루로 이동

                        runCnt = 4; // 주자 1,2루

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 2) { // 주자의 현재 위치
                        BatterRequest_One_home batterRequestOne = new BatterRequest_One_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestOne);
                        h++;
                        if(h>8) {
                            h=0;
                        }
                        img3.setText(img2.getText());
                        img1.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.VISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE);  // 주자 3루로 이동

                        runCnt = 6; //주자 2,3루

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 3) {// 주자의 현재 위치
                        BatterRequest_One_home batterRequestOne = new BatterRequest_One_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestOne);

                        RBIRequest_home RBIRequest_home = new RBIRequest_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue1 = Volley.newRequestQueue(getContext());
                        queue1.add(RBIRequest_home);

                        ScoreRequest_home ScoreRequest_home = new ScoreRequest_home(choice_away, choice_home, (String) img3.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_home);

                        PithcerReqeust_ER_Away PithcerReqeust_ER_Away = new PithcerReqeust_ER_Away(choice_away, choice_home, away_pitcher, responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(PithcerReqeust_ER_Away);
                        h++;
                        if(h>8) {
                            h=0;
                        }
                        img1.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.VISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.INVISIBLE); //주자 1루로 이동

                        runCnt = 1; //주자 1루

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                                home_ining++;
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    } else if (runCnt == 4) {// 주자의 현재 위치
                        BatterRequest_One_home batterRequestOne = new BatterRequest_One_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestOne);


                        h++;
                        if(h>8) {
                            h=0;
                        }
                        img3.setText(img2.getText());
                        img2.setText(img1.getText());
                        img1.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.VISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.VISIBLE);// 주자 1,2,3루로 이동

                        runCnt = 7;

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 5) {// 주자의 현재 위치
                        BatterRequest_One_home batterRequestOne = new BatterRequest_One_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestOne);

                        RBIRequest_home RBIRequest_home = new RBIRequest_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue1 = Volley.newRequestQueue(getContext());
                        queue1.add(RBIRequest_home);

                        ScoreRequest_home ScoreRequest_home = new ScoreRequest_home(choice_away, choice_home,  (String) img3.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_home);

                        PithcerReqeust_ER_Away PithcerReqeust_ER_Away = new PithcerReqeust_ER_Away(choice_away, choice_home, away_pitcher, responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(PithcerReqeust_ER_Away);
                        h++;
                        if(h>8) {
                            h=0;
                        }
                        img3.setText(img2.getText());
                        img1.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.VISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                        runCnt = 6;

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                                home_ining++;
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 6) {// 주자의 현재 위치
                        BatterRequest_One_home batterRequestOne = new BatterRequest_One_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestOne);

                        RBIRequest_home RBIRequest_home = new RBIRequest_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue1 = Volley.newRequestQueue(getContext());
                        queue1.add(RBIRequest_home);

                        ScoreRequest_home ScoreRequest_home = new ScoreRequest_home(choice_away, choice_home, (String) img3.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_home);

                        PithcerReqeust_ER_Away PithcerReqeust_ER_Away = new PithcerReqeust_ER_Away(choice_away, choice_home, away_pitcher, responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(PithcerReqeust_ER_Away);
                        h++;
                        if(h>8) {
                            h=0;
                        }
                        img2.setText(img1.getText());
                        img1.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.VISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.INVISIBLE);   // 주자 1루로 이동

                        runCnt = 4;

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                                home_ining++;
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 7) {// 주자의 현재 위치
                        BatterRequest_One_home batterRequestOne = new BatterRequest_One_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestOne);

                        RBIRequest_home RBIRequest_home = new RBIRequest_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue1 = Volley.newRequestQueue(getContext());
                        queue1.add(RBIRequest_home);

                        ScoreRequest_home ScoreRequest_home = new ScoreRequest_home(choice_away, choice_home, (String) img3.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_home);

                        PithcerReqeust_ER_Away PithcerReqeust_ER_Away = new PithcerReqeust_ER_Away(choice_away, choice_home, away_pitcher, responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(PithcerReqeust_ER_Away);
                        h++;
                        if(h>8) {
                            h=0;
                        }
                        img3.setText(img2.getText());
                        img2.setText(img1.getText());
                        img1.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.VISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                        runCnt = 7;

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                                home_ining++;
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    }
                }
            }
        });



        btn_Double.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 추후 1루타 정보로 수정
                if (ini_num % 2 == 1) {
                    PithcerReqeust_Hits_Home PithcerReqeust_Hits_Home = new PithcerReqeust_Hits_Home(choice_away, choice_home, home_pitcher, responseListener);
                    RequestQueue queue6 = Volley.newRequestQueue(getContext());
                    queue6.add(PithcerReqeust_Hits_Home);

                    if (runCnt == 0) { // 주자의 현재 위치
                        BatterRequest_Two_away batterRequestTwo = new BatterRequest_Two_away(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestTwo);
                        a++;
                        if(a>8) {
                            a=0;
                        }

                        img2.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.INVISIBLE); // 주자 2루로 이동

                        runCnt = 2;

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    } else if (runCnt == 1) {// 주자의 현재 위치
                        BatterRequest_Two_away batterRequestTwo = new BatterRequest_Two_away(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestTwo);
                        a++;
                        if(a>8) {
                            a=0;
                        }
                        img3.setText(img1.getText());
                        img2.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.VISIBLE);   // 주자 2루로 이동

                        runCnt = 5; // 주자 1,2루

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 2) { // 주자의 현재 위치
                        BatterRequest_Two_away batterRequestTwo = new BatterRequest_Two_away(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestTwo);

                        RBIRequest_away RBIRequest_away = new RBIRequest_away(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue1 = Volley.newRequestQueue(getContext());
                        queue1.add(RBIRequest_away);

                        ScoreRequest_away ScoreRequest_away = new ScoreRequest_away(choice_away, choice_home,  (String) img2.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_away);

                        PithcerReqeust_ER_Home PithcerReqeust_ER_Home = new PithcerReqeust_ER_Home(choice_away, choice_home, home_pitcher, responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(PithcerReqeust_ER_Home);
                        a++;
                        if(a>8) {
                            a=0;
                        }
                        img2.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.INVISIBLE);// 주자 1루로 이동

                        runCnt = 2; //주자 2,3루

                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    ascore++;
                                    et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                    away_ining++;
                                }
                            }, 500);


                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 3) {// 주자의 현재 위치
                        BatterRequest_Two_away batterRequestTwo = new BatterRequest_Two_away(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestTwo);

                        RBIRequest_away RBIRequest_away = new RBIRequest_away(choice_away,  choice_home, away_arr[a], responseListener);
                        RequestQueue queue1 = Volley.newRequestQueue(getContext());
                        queue1.add(RBIRequest_away);

                        ScoreRequest_away ScoreRequest_away = new ScoreRequest_away(choice_away, choice_home,  (String) img3.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_away);

                        PithcerReqeust_ER_Home PithcerReqeust_ER_Home = new PithcerReqeust_ER_Home(choice_away, choice_home, home_pitcher, responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(PithcerReqeust_ER_Home);
                        a++;
                        if(a>8) {
                            a=0;
                        }
                        img2.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.INVISIBLE); //주자 1루로 이동

                        runCnt = 2; //주자 1루

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                ascore++;
                                et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                away_ining++;
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    } else if (runCnt == 4) {// 주자의 현재 위치
                        BatterRequest_Two_away batterRequestTwo = new BatterRequest_Two_away(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestTwo);

                        RBIRequest_away RBIRequest_away = new RBIRequest_away(choice_away,  choice_home, away_arr[a], responseListener);
                        RequestQueue queue1 = Volley.newRequestQueue(getContext());
                        queue1.add(RBIRequest_away);

                        ScoreRequest_away ScoreRequest_away = new ScoreRequest_away(choice_away, choice_home,  (String) img2.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_away);

                        PithcerReqeust_ER_Home PithcerReqeust_ER_Home = new PithcerReqeust_ER_Home(choice_away, choice_home, home_pitcher, responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(PithcerReqeust_ER_Home);
                        a++;
                        if(a>8) {
                            a=0;
                        }
                        img3.setText(img1.getText());
                        img2.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.VISIBLE);// 주자 1,2,3루로 이동

                        runCnt = 5;

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                ascore++;
                                et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                away_ining++;
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 5) {// 주자의 현재 위치
                        BatterRequest_Two_away batterRequestTwo = new BatterRequest_Two_away(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestTwo);

                        for(int i=0; i<2; i++) {
                            RBIRequest_away RBIRequest_away = new RBIRequest_away(choice_away,  choice_home, away_arr[a], responseListener);
                            RequestQueue queue1 = Volley.newRequestQueue(getContext());
                            queue1.add(RBIRequest_away);

                            PithcerReqeust_ER_Home PithcerReqeust_ER_Home = new PithcerReqeust_ER_Home(choice_away, choice_home, home_pitcher, responseListener);
                            RequestQueue queue4 = Volley.newRequestQueue(getContext());
                            queue4.add(PithcerReqeust_ER_Home);
                        }

                        ScoreRequest_away ScoreRequest_away = new ScoreRequest_away(choice_away, choice_home,  (String) img2.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_away);

                        ScoreRequest_away scoreRequestAway1 = new ScoreRequest_away(choice_away, choice_home,  (String) img3.getText(), responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(scoreRequestAway1);
                        a++;
                        if(a>8) {
                            a=0;
                        }
                        img2.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.INVISIBLE);

                        runCnt = 2;

                        for (int i = 0; i < 2; i++) {
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    ascore++;
                                    et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                    away_ining++;
                                }
                            }, 500);
                        }

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 6) {// 주자의 현재 위치
                        BatterRequest_Two_away batterRequestTwo = new BatterRequest_Two_away(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestTwo);

                        RBIRequest_away RBIRequest_away = new RBIRequest_away(choice_away,  choice_home, away_arr[a], responseListener);
                        RequestQueue queue1 = Volley.newRequestQueue(getContext());
                        queue1.add(RBIRequest_away);

                        ScoreRequest_away ScoreRequest_away = new ScoreRequest_away(choice_away, choice_home,  (String) img3.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_away);

                        PithcerReqeust_ER_Home PithcerReqeust_ER_Home = new PithcerReqeust_ER_Home(choice_away, choice_home, home_pitcher, responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(PithcerReqeust_ER_Home);
                        a++;
                        if(a>8) {
                            a=0;
                        }
                        img3.setText(img1.getText());
                        img2.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.VISIBLE);  // 주자 1루로 이동

                        runCnt = 5;

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                ascore++;
                                et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                away_ining++;
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 7) {// 주자의 현재 위치
                        BatterRequest_Two_away batterRequestTwo = new BatterRequest_Two_away(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestTwo);

                        for(int i=0; i<2; i++) {
                            RBIRequest_away RBIRequest_away = new RBIRequest_away(choice_away,  choice_home, away_arr[a], responseListener);
                            RequestQueue queue1 = Volley.newRequestQueue(getContext());
                            queue1.add(RBIRequest_away);

                            PithcerReqeust_ER_Home PithcerReqeust_ER_Home = new PithcerReqeust_ER_Home(choice_away, choice_home, home_pitcher, responseListener);
                            RequestQueue queue4 = Volley.newRequestQueue(getContext());
                            queue4.add(PithcerReqeust_ER_Home);
                        }
                        ScoreRequest_away ScoreRequest_away = new ScoreRequest_away(choice_away, choice_home,  (String) img2.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_away);

                        ScoreRequest_away scoreRequestAway1 = new ScoreRequest_away(choice_away, choice_home,  (String) img3.getText(), responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(scoreRequestAway1);

                        a++;
                        if(a>8) {
                            a=0;
                        }
                        img3.setText(img1.getText());
                        img2.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.VISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                        runCnt = 7;

                        for (int i = 0; i < 2; i++) {
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    ascore++;
                                    et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                    away_ining++;
                                }
                            }, 500);
                        }

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    }

                }
                else if (ini_num % 2 == 0) {
                    PithcerReqeust_Hits_Away PithcerReqeust_Hits_Away = new PithcerReqeust_Hits_Away(choice_away, choice_home, away_pitcher, responseListener);
                    RequestQueue queue7 = Volley.newRequestQueue(getContext());
                    queue7.add(PithcerReqeust_Hits_Away);
                    if (runCnt == 0) { // 주자의 현재 위치
                        BatterRequest_Two_home batterRequestTwo = new BatterRequest_Two_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestTwo);
                        h++;
                        if(h>8) {
                            h=0;
                        }
                        img2.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.INVISIBLE); // 주자 2루로 이동

                        runCnt = 2;

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    } else if (runCnt == 1) {// 주자의 현재 위치
                        BatterRequest_Two_home batterRequestTwo = new BatterRequest_Two_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestTwo);
                        h++;
                        if(h>8) {
                            h=0;
                        }

                        img3.setText(img1.getText());
                        img2.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.VISIBLE);   // 주자 2루로 이동

                        runCnt = 5; // 주자 1,2루

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 2) { // 주자의 현재 위치
                        BatterRequest_Two_home batterRequestTwo = new BatterRequest_Two_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestTwo);

                        RBIRequest_home RBIRequest_home = new RBIRequest_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue1 = Volley.newRequestQueue(getContext());
                        queue1.add(RBIRequest_home);

                        ScoreRequest_home ScoreRequest_home = new ScoreRequest_home(choice_away, choice_home, (String) img2.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_home);

                        PithcerReqeust_ER_Away PithcerReqeust_ER_Away = new PithcerReqeust_ER_Away(choice_away, choice_home, away_pitcher, responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(PithcerReqeust_ER_Away);
                        h++;
                        if(h>8) {
                            h=0;
                        }
                        img2.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.INVISIBLE);// 주자 1루로 이동

                        runCnt = 2; //주자 2,3루

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                                home_ining++;
                            }
                        }, 500);


                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 3) {// 주자의 현재 위치
                        BatterRequest_Two_home batterRequestTwo = new BatterRequest_Two_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestTwo);

                        RBIRequest_home RBIRequest_home = new RBIRequest_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue1 = Volley.newRequestQueue(getContext());
                        queue1.add(RBIRequest_home);

                        ScoreRequest_home ScoreRequest_home = new ScoreRequest_home(choice_away, choice_home, (String) img3.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_home);

                        PithcerReqeust_ER_Away PithcerReqeust_ER_Away = new PithcerReqeust_ER_Away(choice_away, choice_home, away_pitcher, responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(PithcerReqeust_ER_Away);
                        h++;
                        if(h>8) {
                            h=0;
                        }
                        img2.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.INVISIBLE); //주자 1루로 이동

                        runCnt = 2; //주자 1루

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                                home_ining++;
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    } else if (runCnt == 4) {// 주자의 현재 위치
                        BatterRequest_Two_home batterRequestTwo = new BatterRequest_Two_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestTwo);

                        RBIRequest_home RBIRequest_home = new RBIRequest_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue1 = Volley.newRequestQueue(getContext());
                        queue1.add(RBIRequest_home);

                        ScoreRequest_home ScoreRequest_home = new ScoreRequest_home(choice_away, choice_home, (String) img2.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_home);

                        PithcerReqeust_ER_Away PithcerReqeust_ER_Away = new PithcerReqeust_ER_Away(choice_away, choice_home, away_pitcher, responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(PithcerReqeust_ER_Away);
                        h++;
                        if(h>8) {
                            h=0;
                        }
                        img3.setText(img1.getText());
                        img2.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.VISIBLE);// 주자 1,2,3루로 이동

                        runCnt = 5;

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                                home_ining++;
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 5) {// 주자의 현재 위치
                        BatterRequest_Two_home batterRequestTwo = new BatterRequest_Two_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestTwo);

                        for(int i=0; i<2; i++) {
                            RBIRequest_home RBIRequest_home = new RBIRequest_home(choice_away, choice_home, home_arr[h], responseListener);
                            RequestQueue queue1 = Volley.newRequestQueue(getContext());
                            queue1.add(RBIRequest_home);

                            PithcerReqeust_ER_Away PithcerReqeust_ER_Away = new PithcerReqeust_ER_Away(choice_away, choice_home, away_pitcher, responseListener);
                            RequestQueue queue4 = Volley.newRequestQueue(getContext());
                            queue4.add(PithcerReqeust_ER_Away);
                        }
                        ScoreRequest_home ScoreRequest_home = new ScoreRequest_home(choice_away, choice_home, (String) img2.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_home);

                        ScoreRequest_home scoreRequesthome1 = new ScoreRequest_home(choice_away, choice_home, (String) img3.getText(), responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(scoreRequesthome1);

                        h++;
                        if(h>8) {
                            h=0;
                        }
                        img2.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.INVISIBLE);

                        runCnt = 2;

                        for (int i = 0; i < 2; i++) {
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    hscore++;
                                    et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                                    home_ining++;
                                }
                            }, 500);
                        }

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 6) {// 주자의 현재 위치
                        BatterRequest_Two_home batterRequestTwo = new BatterRequest_Two_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestTwo);

                        RBIRequest_home RBIRequest_home = new RBIRequest_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue1 = Volley.newRequestQueue(getContext());
                        queue1.add(RBIRequest_home);

                        ScoreRequest_home ScoreRequest_home = new ScoreRequest_home(choice_away, choice_home, (String) img3.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_home);

                        PithcerReqeust_ER_Away PithcerReqeust_ER_Away = new PithcerReqeust_ER_Away(choice_away, choice_home, away_pitcher, responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(PithcerReqeust_ER_Away);
                        h++;
                        if(h>8) {
                            h=0;
                        }
                        img3.setText(img1.getText());
                        img2.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.VISIBLE);  // 주자 1루로 이동

                        runCnt = 5;

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                                home_ining++;
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 7) {// 주자의 현재 위치
                        BatterRequest_Two_home batterRequestTwo = new BatterRequest_Two_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestTwo);

                        for(int i=0; i<2; i++) {
                            RBIRequest_home RBIRequest_home = new RBIRequest_home(choice_away, choice_home, home_arr[h], responseListener);
                            RequestQueue queue1 = Volley.newRequestQueue(getContext());
                            queue1.add(RBIRequest_home);

                            PithcerReqeust_ER_Away PithcerReqeust_ER_Away = new PithcerReqeust_ER_Away(choice_away, choice_home, away_pitcher, responseListener);
                            RequestQueue queue4 = Volley.newRequestQueue(getContext());
                            queue4.add(PithcerReqeust_ER_Away);
                        }

                        ScoreRequest_home ScoreRequest_home = new ScoreRequest_home(choice_away, choice_home, (String) img2.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_home);

                        ScoreRequest_home scoreRequesthome1 = new ScoreRequest_home(choice_away, choice_home, (String) img3.getText(), responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(scoreRequesthome1);
                        h++;
                        if(h>8) {
                            h=0;
                        }
                        img3.setText(img1.getText());
                        img2.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.VISIBLE);
                        img2.setVisibility(View.VISIBLE);
                        img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                        runCnt = 7;

                        for (int i = 0; i < 2; i++) {
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    hscore++;
                                    et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                                    home_ining++;
                                }
                            }, 500);
                        }

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        btn_Triple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ini_num % 2 == 1) {
                    PithcerReqeust_Hits_Home PithcerReqeust_Hits_Home = new PithcerReqeust_Hits_Home(choice_away, choice_home, home_pitcher, responseListener);
                    RequestQueue queue6 = Volley.newRequestQueue(getContext());
                    queue6.add(PithcerReqeust_Hits_Home);
                    if (runCnt == 0) { // 주자의 현재 위치
                        BatterRequest_Three_away batterRequestThree = new BatterRequest_Three_away(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestThree);
                        a++;
                        if(a>8) {
                            a=0;
                        }

                        img3.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE); // 주자 3루로 이동

                        runCnt = 3;

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    } else if (runCnt == 1) {// 주자의 현재 위치
                        BatterRequest_Three_away batterRequestThree = new BatterRequest_Three_away(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestThree);

                        RBIRequest_away RBIRequest_away = new RBIRequest_away(choice_away,  choice_home, away_arr[a], responseListener);
                        RequestQueue queue1 = Volley.newRequestQueue(getContext());
                        queue1.add(RBIRequest_away);

                        ScoreRequest_away ScoreRequest_away = new ScoreRequest_away(choice_away, choice_home,  (String) img1.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_away);

                        PithcerReqeust_ER_Home PithcerReqeust_ER_Home = new PithcerReqeust_ER_Home(choice_away, choice_home, home_pitcher, responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(PithcerReqeust_ER_Home);
                        a++;
                        if(a>8) {
                            a=0;
                        }

                        img3.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE);   // 주자 3루로 이동

                        runCnt = 3; // 주자 3루

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                ascore++;
                                et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                away_ining++;
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 2) { // 주자의 현재 위치
                        BatterRequest_Three_away batterRequestThree = new BatterRequest_Three_away(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestThree);

                        RBIRequest_away RBIRequest_away = new RBIRequest_away(choice_away,  choice_home, away_arr[a], responseListener);
                        RequestQueue queue1 = Volley.newRequestQueue(getContext());
                        queue1.add(RBIRequest_away);

                        ScoreRequest_away ScoreRequest_away = new ScoreRequest_away(choice_away, choice_home,  (String) img2.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_away);

                        PithcerReqeust_ER_Home PithcerReqeust_ER_Home = new PithcerReqeust_ER_Home(choice_away, choice_home, home_pitcher, responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(PithcerReqeust_ER_Home);
                        a++;
                        if(a>8) {
                            a=0;
                        }

                        img3.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE);// 주자 3루로 이동

                        runCnt = 3; //주자 2,3루

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                ascore++;
                                et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                away_ining++;
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 3) {// 주자의 현재 위치
                        BatterRequest_Three_away batterRequestThree = new BatterRequest_Three_away(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestThree);

                        RBIRequest_away RBIRequest_away = new RBIRequest_away(choice_away,  choice_home, away_arr[a], responseListener);
                        RequestQueue queue1 = Volley.newRequestQueue(getContext());
                        queue1.add(RBIRequest_away);

                        ScoreRequest_away ScoreRequest_away = new ScoreRequest_away(choice_away, choice_home,  (String) img3.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_away);

                        PithcerReqeust_ER_Home PithcerReqeust_ER_Home = new PithcerReqeust_ER_Home(choice_away, choice_home, home_pitcher, responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(PithcerReqeust_ER_Home);
                        a++;
                        if(a>8) {
                            a=0;
                        }

                        img3.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE); //주자 3루로 이동

                        runCnt = 3; //주자 1루


                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                ascore++;
                                et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                away_ining++;
                            }
                        }, 500);


                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    } else if (runCnt == 4) {// 주자의 현재 위치
                        BatterRequest_Three_away batterRequestThree = new BatterRequest_Three_away(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestThree);

                        for(int i=0; i<2; i++) {
                            RBIRequest_away RBIRequest_away = new RBIRequest_away(choice_away, choice_home, away_arr[a], responseListener);
                            RequestQueue queue1 = Volley.newRequestQueue(getContext());
                            queue1.add(RBIRequest_away);

                            PithcerReqeust_ER_Home PithcerReqeust_ER_Home = new PithcerReqeust_ER_Home(choice_away, choice_home, home_pitcher, responseListener);
                            RequestQueue queue4 = Volley.newRequestQueue(getContext());
                            queue4.add(PithcerReqeust_ER_Home);
                        }

                        ScoreRequest_away ScoreRequest_away = new ScoreRequest_away(choice_away, choice_home,  (String) img1.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_away);

                        ScoreRequest_away scoreRequestAway1 = new ScoreRequest_away(choice_away, choice_home,  (String) img2.getText(), responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(scoreRequestAway1);
                        a++;
                        if(a>8) {
                            a=0;
                        }

                        img3.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE);// 주자 3루로 이동

                        runCnt = 3;
                        for (int i = 0; i < 2; i++) {
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    ascore++;
                                    et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                    away_ining++;
                                }
                            }, 500);
                        }
                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 5) {// 주자의 현재 위치
                        BatterRequest_Three_away batterRequestThree = new BatterRequest_Three_away(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestThree);

                        for(int i=0; i<2; i++) {
                            RBIRequest_away RBIRequest_away = new RBIRequest_away(choice_away,  choice_home, away_arr[a], responseListener);
                            RequestQueue queue1 = Volley.newRequestQueue(getContext());
                            queue1.add(RBIRequest_away);

                            PithcerReqeust_ER_Home PithcerReqeust_ER_Home = new PithcerReqeust_ER_Home(choice_away, choice_home, home_pitcher, responseListener);
                            RequestQueue queue4 = Volley.newRequestQueue(getContext());
                            queue4.add(PithcerReqeust_ER_Home);
                        }

                        ScoreRequest_away ScoreRequest_away = new ScoreRequest_away(choice_away, choice_home,  (String) img2.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_away);

                        ScoreRequest_away scoreRequestAway1 = new ScoreRequest_away(choice_away, choice_home, (String) img3.getText(), responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(scoreRequestAway1);
                        a++;
                        if(a>8) {
                            a=0;
                        }

                        img3.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE);
                        runCnt = 3;

                        for (int i = 0; i < 2; i++) {
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    ascore++;
                                    et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                    away_ining++;
                                }
                            }, 500);
                        }

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 6) {// 주자의 현재 위치
                        BatterRequest_Three_away batterRequestThree = new BatterRequest_Three_away(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestThree);

                        for(int i=0; i<2; i++) {
                            RBIRequest_away RBIRequest_away = new RBIRequest_away(choice_away, choice_home, away_arr[a], responseListener);
                            RequestQueue queue1 = Volley.newRequestQueue(getContext());
                            queue1.add(RBIRequest_away);

                            PithcerReqeust_ER_Home PithcerReqeust_ER_Home = new PithcerReqeust_ER_Home(choice_away, choice_home, home_pitcher, responseListener);
                            RequestQueue queue4 = Volley.newRequestQueue(getContext());
                            queue4.add(PithcerReqeust_ER_Home);
                        }

                        ScoreRequest_away ScoreRequest_away = new ScoreRequest_away(choice_away, choice_home,  (String) img1.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_away);

                        ScoreRequest_away scoreRequestAway1 = new ScoreRequest_away(choice_away, choice_home, (String) img3.getText(), responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(scoreRequestAway1);

                        a++;
                        if(a>8) {
                            a=0;
                        }

                        img3.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE);  // 주자 1루로 이동

                        runCnt = 3;

                        for(int i=0; i<2; i++) {
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    ascore++;
                                    et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                    away_ining++;
                                }
                            }, 500);

                        }

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 7) {// 주자의 현재 위치
                        BatterRequest_Three_away batterRequestThree = new BatterRequest_Three_away(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestThree);

                        for(int i=0; i<3; i++) {
                            RBIRequest_away RBIRequest_away = new RBIRequest_away(choice_away,  choice_home, away_arr[a], responseListener);
                            RequestQueue queue1 = Volley.newRequestQueue(getContext());
                            queue1.add(RBIRequest_away);

                            PithcerReqeust_ER_Home PithcerReqeust_ER_Home = new PithcerReqeust_ER_Home(choice_away, choice_home, home_pitcher, responseListener);
                            RequestQueue queue5 = Volley.newRequestQueue(getContext());
                            queue5.add(PithcerReqeust_ER_Home);
                        }

                        ScoreRequest_away ScoreRequest_away = new ScoreRequest_away(choice_away, choice_home,  (String) img1.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_away);

                        ScoreRequest_away scoreRequestAway1 = new ScoreRequest_away(choice_away, choice_home,  (String) img2.getText(), responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(scoreRequestAway1);

                        ScoreRequest_away scoreRequestAway2 = new ScoreRequest_away(choice_away, choice_home, (String) img3.getText(), responseListener);
                        RequestQueue queue4 = Volley.newRequestQueue(getContext());
                        queue4.add(scoreRequestAway2);
                        a++;
                        if(a>8) {
                            a=0;
                        }

                        img3.setText(img0.getText());
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                        runCnt = 3;

                        for (int i = 0; i < 3; i++) {
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    ascore++;
                                    et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                    away_ining++;
                                }
                            }, 500);
                        }

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    }
                } else if (ini_num % 2 == 0) {
                    PithcerReqeust_Hits_Away PithcerReqeust_Hits_Away = new PithcerReqeust_Hits_Away(choice_away, choice_home, away_pitcher, responseListener);
                    RequestQueue queue7 = Volley.newRequestQueue(getContext());
                    queue7.add(PithcerReqeust_Hits_Away);
                    if (runCnt == 0) {
                        BatterRequest_Three_home batterRequestThree = new BatterRequest_Three_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestThree);
                        h++;
                        if(h>8) {
                            h=0;
                        }

                        img3.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE); // 주자 3루로 이동

                        runCnt = 3;

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    } else if (runCnt == 1) {// 주자의 현재 위치
                        BatterRequest_Three_home batterRequestThree = new BatterRequest_Three_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestThree);

                        RBIRequest_home RBIRequest_home = new RBIRequest_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue1 = Volley.newRequestQueue(getContext());
                        queue1.add(RBIRequest_home);

                        ScoreRequest_home ScoreRequest_home = new ScoreRequest_home(choice_away, choice_home, (String) img1.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_home);

                        PithcerReqeust_ER_Away PithcerReqeust_ER_Away = new PithcerReqeust_ER_Away(choice_away, choice_home, away_pitcher, responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(PithcerReqeust_ER_Away);

                        h++;
                        if(h>8) {
                            h=0;
                        }
                        img3.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE);   // 주자 3루로 이동

                        runCnt = 3; // 주자 3루

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                                home_ining++;
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 2) { // 주자의 현재 위치
                        BatterRequest_Three_home batterRequestThree = new BatterRequest_Three_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestThree);

                        RBIRequest_home RBIRequest_home = new RBIRequest_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue1 = Volley.newRequestQueue(getContext());
                        queue1.add(RBIRequest_home);

                        ScoreRequest_home ScoreRequest_home = new ScoreRequest_home(choice_away, choice_home, (String) img2.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_home);

                        PithcerReqeust_ER_Away PithcerReqeust_ER_Away = new PithcerReqeust_ER_Away(choice_away, choice_home, away_pitcher, responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(PithcerReqeust_ER_Away);
                        h++;
                        if(h>8) {
                            h=0;
                        }
                        img3.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE);// 주자 3루로 이동

                        runCnt = 3; //주자 2,3루

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                                home_ining++;
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 3) {// 주자의 현재 위치
                        BatterRequest_Three_home batterRequestThree = new BatterRequest_Three_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestThree);

                        RBIRequest_home RBIRequest_home = new RBIRequest_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue1 = Volley.newRequestQueue(getContext());
                        queue1.add(RBIRequest_home);

                        ScoreRequest_home ScoreRequest_home = new ScoreRequest_home(choice_away, choice_home, (String) img3.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_home);

                        PithcerReqeust_ER_Away PithcerReqeust_ER_Away = new PithcerReqeust_ER_Away(choice_away, choice_home, away_pitcher, responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(PithcerReqeust_ER_Away);
                        h++;
                        if(h>8) {
                            h=0;
                        }
                        img3.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE); //주자 3루로 이동

                        runCnt = 3; //주자 1루


                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                                home_ining++;
                            }
                        }, 500);

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    } else if (runCnt == 4) {// 주자의 현재 위치
                        BatterRequest_Three_home batterRequestThree = new BatterRequest_Three_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestThree);

                        for(int i=0; i<2; i++) {
                            RBIRequest_home RBIRequest_home = new RBIRequest_home(choice_away, choice_home, home_arr[h], responseListener);
                            RequestQueue queue1 = Volley.newRequestQueue(getContext());
                            queue1.add(RBIRequest_home);

                            PithcerReqeust_ER_Away PithcerReqeust_ER_Away = new PithcerReqeust_ER_Away(choice_away, choice_home, away_pitcher, responseListener);
                            RequestQueue queue4 = Volley.newRequestQueue(getContext());
                            queue4.add(PithcerReqeust_ER_Away);
                        }

                        ScoreRequest_home ScoreRequest_home = new ScoreRequest_home(choice_away, choice_home, (String) img1.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_home);

                        ScoreRequest_home scoreRequesthome1 = new ScoreRequest_home(choice_away, choice_home, (String) img2.getText(), responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(scoreRequesthome1);
                        h++;
                        if(h>8) {
                            h=0;
                        }
                        img3.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE);// 주자 3루로 이동

                        runCnt = 3;
                        for (int i = 0; i < 2; i++) {
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    hscore++;
                                    et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                                    home_ining++;
                                }
                            }, 500);
                        }
                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 5) {// 주자의 현재 위치
                        BatterRequest_Three_home batterRequestThree = new BatterRequest_Three_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestThree);

                        for(int i=0; i<2; i++) {
                            RBIRequest_home RBIRequest_home = new RBIRequest_home(choice_away, choice_home, home_arr[h], responseListener);
                            RequestQueue queue1 = Volley.newRequestQueue(getContext());
                            queue1.add(RBIRequest_home);

                            PithcerReqeust_ER_Away PithcerReqeust_ER_Away = new PithcerReqeust_ER_Away(choice_away, choice_home, away_pitcher, responseListener);
                            RequestQueue queue4 = Volley.newRequestQueue(getContext());
                            queue4.add(PithcerReqeust_ER_Away);
                        }

                        ScoreRequest_home ScoreRequest_home = new ScoreRequest_home(choice_away, choice_home, (String) img2.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_home);

                        ScoreRequest_home scoreRequesthome1 = new ScoreRequest_home(choice_away, choice_home, (String) img3.getText(), responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(scoreRequesthome1);
                        h++;
                        if(h>8) {
                            h=0;
                        }
                        img3.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE);
                        runCnt = 3;

                        for (int i = 0; i < 2; i++) {
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    hscore++;
                                    et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                                    home_ining++;
                                }
                            }, 500);
                        }

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 6) {// 주자의 현재 위치
                        BatterRequest_Three_home batterRequestThree = new BatterRequest_Three_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestThree);

                        for(int i=0; i<2; i++) {
                            RBIRequest_home RBIRequest_home = new RBIRequest_home(choice_away, choice_home, home_arr[i], responseListener);
                            RequestQueue queue1 = Volley.newRequestQueue(getContext());
                            queue1.add(RBIRequest_home);

                            PithcerReqeust_ER_Away PithcerReqeust_ER_Away = new PithcerReqeust_ER_Away(choice_away, choice_home, away_pitcher, responseListener);
                            RequestQueue queue4 = Volley.newRequestQueue(getContext());
                            queue4.add(PithcerReqeust_ER_Away);
                        }

                        ScoreRequest_home ScoreRequest_home = new ScoreRequest_home(choice_away, choice_home, (String) img1.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_home);

                        ScoreRequest_home scoreRequesthome1 = new ScoreRequest_home(choice_away, choice_home, (String) img3.getText(), responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(scoreRequesthome1);

                        h++;
                        if(h>8) {
                            h=0;
                        }
                        img3.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE);  // 주자 1루로 이동

                        runCnt = 3;

                        for(int i=0; i<2; i++) {
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    hscore++;
                                    et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                                    home_ining++;
                                }
                            }, 500);
                        }

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 7) {// 주자의 현재 위치
                        BatterRequest_Three_home batterRequestThree = new BatterRequest_Three_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(batterRequestThree);

                        for(int i=0; i<3; i++) {
                            RBIRequest_home RBIRequest_home = new RBIRequest_home(choice_away, choice_home,  home_arr[h], responseListener);
                            RequestQueue queue1 = Volley.newRequestQueue(getContext());
                            queue1.add(RBIRequest_home);

                            PithcerReqeust_ER_Away PithcerReqeust_ER_Away = new PithcerReqeust_ER_Away(choice_away, choice_home, away_pitcher, responseListener);
                            RequestQueue queue5 = Volley.newRequestQueue(getContext());
                            queue5.add(PithcerReqeust_ER_Away);
                        }

                        ScoreRequest_home ScoreRequest_home = new ScoreRequest_home(choice_away, choice_home, (String) img1.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_home);

                        ScoreRequest_home scoreRequesthome1 = new ScoreRequest_home(choice_away, choice_home, (String) img2.getText(), responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(scoreRequesthome1);

                        ScoreRequest_home scoreRequesthome2 = new ScoreRequest_home(choice_away, choice_home, (String) img3.getText(), responseListener);
                        RequestQueue queue4 = Volley.newRequestQueue(getContext());
                        queue4.add(scoreRequesthome2);
                        h++;
                        if(h>8) {
                            h=0;
                        }
                        img3.setText(img0.getText());
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.VISIBLE);   // 주자 1루로 이동

                        runCnt = 3;

                        for (int i = 0; i < 3; i++) {
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    hscore++;
                                    et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                                    home_ining++;
                                }
                            }, 500);
                        }

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    }
                }
            }

        });

        btn_Homerun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ini_num % 2 == 1) {
                    PithcerReqeust_Hits_Home PithcerReqeust_Hits_Home = new PithcerReqeust_Hits_Home(choice_away, choice_home, home_pitcher, responseListener);
                    RequestQueue queue8 = Volley.newRequestQueue(getContext());
                    queue8.add(PithcerReqeust_Hits_Home);

                    if (runCnt == 0) { // 주자의 현재 위치
                        BatterRequest_Homerun_away BatterRequest_Homerun_away = new BatterRequest_Homerun_away(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(BatterRequest_Homerun_away);

                        PitcherRequest_Homerun_home PitcherRequest_Homerun_home = new PitcherRequest_Homerun_home(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue9 = Volley.newRequestQueue(getContext());
                        queue9.add(PitcherRequest_Homerun_home);


                        RBIRequest_away RBIRequest_away = new RBIRequest_away(choice_away,  choice_home, away_arr[a], responseListener);
                        RequestQueue queue1 = Volley.newRequestQueue(getContext());
                        queue1.add(RBIRequest_away);

                        ScoreRequest_away ScoreRequest_away = new ScoreRequest_away(choice_away, choice_home,  (String) img0.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_away);

                        PithcerReqeust_ER_Home PithcerReqeust_ER_Home = new PithcerReqeust_ER_Home(choice_away, choice_home, home_pitcher, responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(PithcerReqeust_ER_Home);

                        a++;
                        if(a>8) {
                            a=0;
                        }
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.INVISIBLE); // 주자 3루로 이동

                          handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                ascore++;
                                et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                away_ining++;
                            }
                        }, 500);

                        runCnt = 0;

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    } else if (runCnt == 1) {// 주자의 현재 위치
                        BatterRequest_Homerun_away BatterRequest_Homerun_away = new BatterRequest_Homerun_away(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(BatterRequest_Homerun_away);

                        PitcherRequest_Homerun_home PitcherRequest_Homerun_home = new PitcherRequest_Homerun_home(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue9 = Volley.newRequestQueue(getContext());
                        queue9.add(PitcherRequest_Homerun_home);

                        for(i=0; i<2; i++) {
                            RBIRequest_away RBIRequest_away = new RBIRequest_away(choice_away, choice_home, away_arr[a], responseListener);
                            RequestQueue queue1 = Volley.newRequestQueue(getContext());
                            queue1.add(RBIRequest_away);

                            PithcerReqeust_ER_Home PithcerReqeust_ER_Home = new PithcerReqeust_ER_Home(choice_away, choice_home, home_pitcher, responseListener);
                            RequestQueue queue4 = Volley.newRequestQueue(getContext());
                            queue4.add(PithcerReqeust_ER_Home);
                        }

                        ScoreRequest_away ScoreRequest_away = new ScoreRequest_away(choice_away, choice_home,  (String) img0.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_away);

                        ScoreRequest_away ScoreRequest_away1 = new ScoreRequest_away(choice_away, choice_home,  (String) img1.getText(), responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(ScoreRequest_away1);


                        a++;
                        if(a>8) {
                            a=0;
                        }
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.INVISIBLE);   // 주자 3루로 이동

                        runCnt = 0; // 주자 3루

                        for(i=0; i<2; i++) {
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    ascore++;
                                    et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                    away_ining++;
                                }
                            }, 500);
                        }

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 2) { // 주자의 현재 위치
                        BatterRequest_Homerun_away BatterRequest_Homerun_away = new BatterRequest_Homerun_away(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(BatterRequest_Homerun_away);

                        PitcherRequest_Homerun_home PitcherRequest_Homerun_home = new PitcherRequest_Homerun_home(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue9 = Volley.newRequestQueue(getContext());
                        queue9.add(PitcherRequest_Homerun_home);

                        for(i=0; i<2; i++) {
                            RBIRequest_away RBIRequest_away = new RBIRequest_away(choice_away, choice_home, away_arr[a], responseListener);
                            RequestQueue queue1 = Volley.newRequestQueue(getContext());
                            queue1.add(RBIRequest_away);

                            PithcerReqeust_ER_Home PithcerReqeust_ER_Home = new PithcerReqeust_ER_Home(choice_away, choice_home, home_pitcher, responseListener);
                            RequestQueue queue4 = Volley.newRequestQueue(getContext());
                            queue4.add(PithcerReqeust_ER_Home);
                        }

                        ScoreRequest_away ScoreRequest_away = new ScoreRequest_away(choice_away, choice_home,  (String) img0.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_away);

                        ScoreRequest_away ScoreRequest_away1 = new ScoreRequest_away(choice_away, choice_home,  (String) img2.getText(), responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(ScoreRequest_away1);
                        a++;
                        if(a>8) {
                            a=0;
                        }
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.INVISIBLE);// 주자 3루로 이동

                        runCnt = 0; //주자 2,3루

                        for(i=0; i<2; i++) {
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    ascore++;
                                    et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                    away_ining++;
                                }
                            }, 500);
                        }

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 3) {// 주자의 현재 위치
                        BatterRequest_Homerun_away BatterRequest_Homerun_away = new BatterRequest_Homerun_away(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(BatterRequest_Homerun_away);

                        PitcherRequest_Homerun_home PitcherRequest_Homerun_home = new PitcherRequest_Homerun_home(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue9 = Volley.newRequestQueue(getContext());
                        queue9.add(PitcherRequest_Homerun_home);

                        for(i=0; i<2; i++) {
                            RBIRequest_away RBIRequest_away = new RBIRequest_away(choice_away, choice_home, away_arr[a], responseListener);
                            RequestQueue queue1 = Volley.newRequestQueue(getContext());
                            queue1.add(RBIRequest_away);

                            PithcerReqeust_ER_Home PithcerReqeust_ER_Home = new PithcerReqeust_ER_Home(choice_away, choice_home, home_pitcher, responseListener);
                            RequestQueue queue4 = Volley.newRequestQueue(getContext());
                            queue4.add(PithcerReqeust_ER_Home);
                        }

                        ScoreRequest_away ScoreRequest_away = new ScoreRequest_away(choice_away, choice_home,  (String) img0.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_away);

                        ScoreRequest_away ScoreRequest_away1 = new ScoreRequest_away(choice_away, choice_home,  (String) img3.getText(), responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(ScoreRequest_away1);
                        a++;
                        if(a>8) {
                            a=0;
                        }
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.INVISIBLE);// 주자 3루로 이동

                        runCnt = 0; //주자 2,3루


                        for(i=0; i<2; i++) {
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    ascore++;
                                    et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                    away_ining++;
                                }
                            }, 500);
                        }

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    } else if (runCnt == 4) {// 주자의 현재 위치
                        BatterRequest_Homerun_away BatterRequest_Homerun_away = new BatterRequest_Homerun_away(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(BatterRequest_Homerun_away);

                        PitcherRequest_Homerun_home PitcherRequest_Homerun_home = new PitcherRequest_Homerun_home(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue9 = Volley.newRequestQueue(getContext());
                        queue9.add(PitcherRequest_Homerun_home);

                        for(int i=0; i<3; i++) {
                            RBIRequest_away RBIRequest_away = new RBIRequest_away(choice_away, choice_home, away_arr[a], responseListener);
                            RequestQueue queue1 = Volley.newRequestQueue(getContext());
                            queue1.add(RBIRequest_away);

                            PithcerReqeust_ER_Home PithcerReqeust_ER_Home = new PithcerReqeust_ER_Home(choice_away, choice_home, home_pitcher, responseListener);
                            RequestQueue queue4 = Volley.newRequestQueue(getContext());
                            queue4.add(PithcerReqeust_ER_Home);
                        }

                        ScoreRequest_away ScoreRequest_away = new ScoreRequest_away(choice_away, choice_home,  (String) img1.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_away);

                        ScoreRequest_away scoreRequestAway1 = new ScoreRequest_away(choice_away, choice_home,  (String) img2.getText(), responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(scoreRequestAway1);

                        ScoreRequest_away scoreRequestAway2 = new ScoreRequest_away(choice_away, choice_home,  (String) img0.getText(), responseListener);
                        RequestQueue queue5 = Volley.newRequestQueue(getContext());
                        queue5.add(scoreRequestAway2);
                        a++;
                        if(a>8) {
                            a=0;
                        }
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.INVISIBLE);// 주자 3루로 이동

                        runCnt = 0; //주자 2,3루

                        for (int i = 0; i < 3; i++) {
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    ascore++;
                                    et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                    away_ining++;
                                }
                            }, 500);
                        }
                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 5) {// 주자의 현재 위치
                        BatterRequest_Homerun_away BatterRequest_Homerun_away = new BatterRequest_Homerun_away(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(BatterRequest_Homerun_away);

                        PitcherRequest_Homerun_home PitcherRequest_Homerun_home = new PitcherRequest_Homerun_home(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue9 = Volley.newRequestQueue(getContext());
                        queue9.add(PitcherRequest_Homerun_home);

                        for(int i=0; i<3; i++) {
                            RBIRequest_away RBIRequest_away = new RBIRequest_away(choice_away, choice_home, away_arr[a], responseListener);
                            RequestQueue queue1 = Volley.newRequestQueue(getContext());
                            queue1.add(RBIRequest_away);

                            PithcerReqeust_ER_Home PithcerReqeust_ER_Home = new PithcerReqeust_ER_Home(choice_away, choice_home, home_pitcher, responseListener);
                            RequestQueue queue4 = Volley.newRequestQueue(getContext());
                            queue4.add(PithcerReqeust_ER_Home);
                        }

                        ScoreRequest_away ScoreRequest_away = new ScoreRequest_away(choice_away, choice_home,  (String) img2.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_away);

                        ScoreRequest_away scoreRequestAway1 = new ScoreRequest_away(choice_away, choice_home,  (String) img3.getText(), responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(scoreRequestAway1);

                        ScoreRequest_away scoreRequestAway2 = new ScoreRequest_away(choice_away, choice_home,  (String) img0.getText(), responseListener);
                        RequestQueue queue5 = Volley.newRequestQueue(getContext());
                        queue5.add(scoreRequestAway2);
                        a++;
                        if(a>8) {
                            a=0;
                        }
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.INVISIBLE);// 주자 3루로 이동

                        runCnt = 0; //주자 2,3루

                        for (int i = 0; i < 3; i++) {
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    ascore++;
                                    et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                    away_ining++;
                                }
                            }, 500);
                        }

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 6) {// 주자의 현재 위치
                        BatterRequest_Homerun_away BatterRequest_Homerun_away = new BatterRequest_Homerun_away(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(BatterRequest_Homerun_away);

                        PitcherRequest_Homerun_home PitcherRequest_Homerun_home = new PitcherRequest_Homerun_home(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue9 = Volley.newRequestQueue(getContext());
                        queue9.add(PitcherRequest_Homerun_home);

                        for(int i=0; i<3; i++) {
                            RBIRequest_away RBIRequest_away = new RBIRequest_away(choice_away, choice_home, away_arr[a], responseListener);
                            RequestQueue queue1 = Volley.newRequestQueue(getContext());
                            queue1.add(RBIRequest_away);

                            PithcerReqeust_ER_Home PithcerReqeust_ER_Home = new PithcerReqeust_ER_Home(choice_away, choice_home, home_pitcher, responseListener);
                            RequestQueue queue4 = Volley.newRequestQueue(getContext());
                            queue4.add(PithcerReqeust_ER_Home);
                        }

                        ScoreRequest_away ScoreRequest_away = new ScoreRequest_away(choice_away, choice_home,  (String) img1.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_away);

                        ScoreRequest_away scoreRequestAway1 = new ScoreRequest_away(choice_away, choice_home,  (String) img3.getText(), responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(scoreRequestAway1);

                        ScoreRequest_away scoreRequestAway2 = new ScoreRequest_away(choice_away, choice_home,  (String) img0.getText(), responseListener);
                        RequestQueue queue5 = Volley.newRequestQueue(getContext());
                        queue5.add(scoreRequestAway2);
                        a++;
                        if(a>8) {
                            a=0;
                        }
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.INVISIBLE);// 주자 3루로 이동

                        runCnt = 0; //주자 2,3루

                        for (int i = 0; i < 3; i++) {
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    ascore++;
                                    et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                    away_ining++;
                                }
                            }, 500);
                        }

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 7) {// 주자의 현재 위치
                        BatterRequest_Homerun_away BatterRequest_Homerun_away = new BatterRequest_Homerun_away(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(BatterRequest_Homerun_away);

                        PitcherRequest_Homerun_home PitcherRequest_Homerun_home = new PitcherRequest_Homerun_home(choice_away, choice_home, away_arr[a], responseListener);
                        RequestQueue queue9 = Volley.newRequestQueue(getContext());
                        queue9.add(PitcherRequest_Homerun_home);

                        for(int i=0; i<4; i++) {
                            RBIRequest_away RBIRequest_away = new RBIRequest_away(choice_away, choice_home, away_arr[a], responseListener);
                            RequestQueue queue1 = Volley.newRequestQueue(getContext());
                            queue1.add(RBIRequest_away);

                            PithcerReqeust_ER_Home PithcerReqeust_ER_Home = new PithcerReqeust_ER_Home(choice_away, choice_home, home_pitcher, responseListener);
                            RequestQueue queue4 = Volley.newRequestQueue(getContext());
                            queue4.add(PithcerReqeust_ER_Home);
                        }

                        ScoreRequest_away ScoreRequest_away = new ScoreRequest_away(choice_away, choice_home,  (String) img1.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_away);

                        ScoreRequest_away scoreRequestAway1 = new ScoreRequest_away(choice_away, choice_home,  (String) img2.getText(), responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(scoreRequestAway1);

                        ScoreRequest_away scoreRequestAway2 = new ScoreRequest_away(choice_away, choice_home,  (String) img3.getText(), responseListener);
                        RequestQueue queue5 = Volley.newRequestQueue(getContext());
                        queue5.add(scoreRequestAway2);

                        ScoreRequest_away scoreRequestAway3 = new ScoreRequest_away(choice_away, choice_home,  (String) img0.getText(), responseListener);
                        RequestQueue queue6 = Volley.newRequestQueue(getContext());
                        queue6.add(scoreRequestAway3);

                        a++;
                        if(a>8) {
                            a=0;
                        }
                        img0.setText(away_arr[a]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.INVISIBLE);// 주자 3루로 이동

                        runCnt = 0; //주자 2,3루

                        for (int i = 0; i < 4; i++) {
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    ascore++;
                                    et_ascore.setText("원정   " + choice_away + Integer.toString(ascore));
                                    away_ining++;
                                }
                            }, 500);
                        }

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    }
                } else if (ini_num % 2 == 0) {
                    PithcerReqeust_Hits_Away PithcerReqeust_Hits_Away = new PithcerReqeust_Hits_Away(choice_away, choice_home, away_pitcher, responseListener);
                    RequestQueue queue8 = Volley.newRequestQueue(getContext());
                    queue8.add(PithcerReqeust_Hits_Away);

                    if (runCnt == 0) { // 주자의 현재 위치
                        BatterRequest_Homerun_home BatterRequest_Homerun_home = new BatterRequest_Homerun_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(BatterRequest_Homerun_home);

                        PitcherRequest_Homerun_away PitcherRequest_Homerun_away = new PitcherRequest_Homerun_away(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue9 = Volley.newRequestQueue(getContext());
                        queue.add(PitcherRequest_Homerun_away);

                        RBIRequest_home RBIRequest_home = new RBIRequest_home(choice_away,  choice_home, home_arr[h], responseListener);
                        RequestQueue queue1 = Volley.newRequestQueue(getContext());
                        queue1.add(RBIRequest_home);

                        ScoreRequest_home ScoreRequest_home = new ScoreRequest_home(choice_away, choice_home,  (String) img0.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_home);

                        PithcerReqeust_ER_Away PithcerReqeust_ER_Away = new PithcerReqeust_ER_Away(choice_away, choice_home, away_pitcher, responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(PithcerReqeust_ER_Away);

                        h++;
                        if(h>8) {
                            h=0;
                        }

                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.INVISIBLE); // 주자 3루로 이동

                        handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                            @Override
                            public void run() {
                                hscore++;
                                et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                                home_ining++;
                            }
                        }, 500);

                        runCnt = 0;

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    } else if (runCnt == 1) {// 주자의 현재 위치
                        BatterRequest_Homerun_home BatterRequest_Homerun_home = new BatterRequest_Homerun_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(BatterRequest_Homerun_home);

                        PitcherRequest_Homerun_away PitcherRequest_Homerun_away = new PitcherRequest_Homerun_away(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue9 = Volley.newRequestQueue(getContext());
                        queue.add(PitcherRequest_Homerun_away);

                        for(i=0; i<2; i++) {
                            RBIRequest_home RBIRequest_home = new RBIRequest_home(choice_away, choice_home, home_arr[h], responseListener);
                            RequestQueue queue1 = Volley.newRequestQueue(getContext());
                            queue1.add(RBIRequest_home);

                            PithcerReqeust_ER_Away PithcerReqeust_ER_Away = new PithcerReqeust_ER_Away(choice_away, choice_home, away_pitcher, responseListener);
                            RequestQueue queue4 = Volley.newRequestQueue(getContext());
                            queue4.add(PithcerReqeust_ER_Away);
                        }

                        ScoreRequest_home ScoreRequest_home = new ScoreRequest_home(choice_away, choice_home,  (String) img0.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_home);

                        ScoreRequest_home ScoreRequest_home1 = new ScoreRequest_home(choice_away, choice_home,  (String) img1.getText(), responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(ScoreRequest_home1);


                        h++;
                        if(h>8) {
                            h=0;
                        }
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.INVISIBLE);   // 주자 3루로 이동

                        runCnt = 0; // 주자 3루

                        for(i=0; i<2; i++) {
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    hscore++;
                                    et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                                    home_ining++;
                                }
                            }, 500);
                        }

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 2) { // 주자의 현재 위치
                        BatterRequest_Homerun_home BatterRequest_Homerun_home = new BatterRequest_Homerun_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(BatterRequest_Homerun_home);

                        PitcherRequest_Homerun_away PitcherRequest_Homerun_away = new PitcherRequest_Homerun_away(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue9 = Volley.newRequestQueue(getContext());
                        queue.add(PitcherRequest_Homerun_away);

                        for(i=0; i<2; i++) {
                            RBIRequest_home RBIRequest_home = new RBIRequest_home(choice_away, choice_home, home_arr[h], responseListener);
                            RequestQueue queue1 = Volley.newRequestQueue(getContext());
                            queue1.add(RBIRequest_home);

                            PithcerReqeust_ER_Away PithcerReqeust_ER_Away = new PithcerReqeust_ER_Away(choice_away, choice_home, away_pitcher, responseListener);
                            RequestQueue queue4 = Volley.newRequestQueue(getContext());
                            queue4.add(PithcerReqeust_ER_Away);
                        }

                        ScoreRequest_home ScoreRequest_home = new ScoreRequest_home(choice_away, choice_home,  (String) img0.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_home);

                        ScoreRequest_home ScoreRequest_home1 = new ScoreRequest_home(choice_away, choice_home,  (String) img2.getText(), responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(ScoreRequest_home1);
                        h++;
                        if(h>8) {
                            h=0;
                        }
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.INVISIBLE);// 주자 3루로 이동

                        runCnt = 0; //주자 2,3루

                        for(i=0; i<2; i++) {
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    hscore++;
                                    et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                                    home_ining++;
                                }
                            }, 500);
                        }

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 3) {// 주자의 현재 위치
                        BatterRequest_Homerun_home BatterRequest_Homerun_home = new BatterRequest_Homerun_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(BatterRequest_Homerun_home);

                        PitcherRequest_Homerun_away PitcherRequest_Homerun_away = new PitcherRequest_Homerun_away(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue9 = Volley.newRequestQueue(getContext());
                        queue.add(PitcherRequest_Homerun_away);

                        for(i=0; i<2; i++) {
                            RBIRequest_home RBIRequest_home = new RBIRequest_home(choice_away, choice_home, home_arr[h], responseListener);
                            RequestQueue queue1 = Volley.newRequestQueue(getContext());
                            queue1.add(RBIRequest_home);

                            PithcerReqeust_ER_Away PithcerReqeust_ER_Away = new PithcerReqeust_ER_Away(choice_away, choice_home, away_pitcher, responseListener);
                            RequestQueue queue4 = Volley.newRequestQueue(getContext());
                            queue4.add(PithcerReqeust_ER_Away);
                        }

                        ScoreRequest_home ScoreRequest_home = new ScoreRequest_home(choice_away, choice_home,  (String) img0.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_home);

                        ScoreRequest_home ScoreRequest_home1 = new ScoreRequest_home(choice_away, choice_home,  (String) img3.getText(), responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(ScoreRequest_home1);
                        h++;
                        if(h>8) {
                            h=0;
                        }
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.INVISIBLE);// 주자 3루로 이동

                        runCnt = 0; //주자 2,3루


                        for(i=0; i<2; i++) {
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    hscore++;
                                    et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                                    home_ining++;
                                }
                            }, 500);
                        }

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    } else if (runCnt == 4) {// 주자의 현재 위치
                        BatterRequest_Homerun_home BatterRequest_Homerun_home = new BatterRequest_Homerun_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(BatterRequest_Homerun_home);

                        PitcherRequest_Homerun_away PitcherRequest_Homerun_away = new PitcherRequest_Homerun_away(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue9 = Volley.newRequestQueue(getContext());
                        queue.add(PitcherRequest_Homerun_away);

                        for(int i=0; i<3; i++) {
                            RBIRequest_home RBIRequest_home = new RBIRequest_home(choice_away, choice_home, home_arr[h], responseListener);
                            RequestQueue queue1 = Volley.newRequestQueue(getContext());
                            queue1.add(RBIRequest_home);

                            PithcerReqeust_ER_Away PithcerReqeust_ER_Away = new PithcerReqeust_ER_Away(choice_away, choice_home, away_pitcher, responseListener);
                            RequestQueue queue4 = Volley.newRequestQueue(getContext());
                            queue4.add(PithcerReqeust_ER_Away);
                        }

                        ScoreRequest_home ScoreRequest_home = new ScoreRequest_home(choice_away, choice_home,  (String) img1.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_home);

                        ScoreRequest_home scoreRequesthome1 = new ScoreRequest_home(choice_away, choice_home,  (String) img2.getText(), responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(scoreRequesthome1);

                        ScoreRequest_home scoreRequesthome2 = new ScoreRequest_home(choice_away, choice_home,  (String) img0.getText(), responseListener);
                        RequestQueue queue5 = Volley.newRequestQueue(getContext());
                        queue5.add(scoreRequesthome2);
                        h++;
                        if(h>8) {
                            h=0;
                        }
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.INVISIBLE);// 주자 3루로 이동

                        runCnt = 0; //주자 2,3루

                        for (int i = 0; i < 3; i++) {
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    hscore++;
                                    et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                                    home_ining++;
                                }
                            }, 500);
                        }
                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 5) {// 주자의 현재 위치
                        BatterRequest_Homerun_home BatterRequest_Homerun_home = new BatterRequest_Homerun_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(BatterRequest_Homerun_home);

                        PitcherRequest_Homerun_away PitcherRequest_Homerun_away = new PitcherRequest_Homerun_away(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue9 = Volley.newRequestQueue(getContext());
                        queue.add(PitcherRequest_Homerun_away);

                        for(int i=0; i<3; i++) {
                            RBIRequest_home RBIRequest_home = new RBIRequest_home(choice_away, choice_home, home_arr[h], responseListener);
                            RequestQueue queue1 = Volley.newRequestQueue(getContext());
                            queue1.add(RBIRequest_home);

                            PithcerReqeust_ER_Away PithcerReqeust_ER_Away = new PithcerReqeust_ER_Away(choice_away, choice_home, away_pitcher, responseListener);
                            RequestQueue queue4 = Volley.newRequestQueue(getContext());
                            queue4.add(PithcerReqeust_ER_Away);
                        }

                        ScoreRequest_home ScoreRequest_home = new ScoreRequest_home(choice_away, choice_home,  (String) img2.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_home);

                        ScoreRequest_home scoreRequesthome1 = new ScoreRequest_home(choice_away, choice_home,  (String) img3.getText(), responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(scoreRequesthome1);

                        ScoreRequest_home scoreRequesthome2 = new ScoreRequest_home(choice_away, choice_home,  (String) img0.getText(), responseListener);
                        RequestQueue queue5 = Volley.newRequestQueue(getContext());
                        queue5.add(scoreRequesthome2);
                        h++;
                        if(h>8) {
                            h=0;
                        }
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.INVISIBLE);// 주자 3루로 이동

                        runCnt = 0; //주자 2,3루

                        for (int i = 0; i < 3; i++) {
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    hscore++;
                                    et_hscore.setText("홈   " + choice_home + Integer.toString(hscore));
                                    home_ining++;
                                }
                            }, 500);
                        }

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 6) {// 주자의 현재 위치
                        BatterRequest_Homerun_home BatterRequest_Homerun_home = new BatterRequest_Homerun_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(BatterRequest_Homerun_home);

                        PitcherRequest_Homerun_away PitcherRequest_Homerun_away = new PitcherRequest_Homerun_away(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue9 = Volley.newRequestQueue(getContext());
                        queue.add(PitcherRequest_Homerun_away);

                        for(int i=0; i<3; i++) {
                            RBIRequest_home RBIRequest_home = new RBIRequest_home(choice_away, choice_home, home_arr[h], responseListener);
                            RequestQueue queue1 = Volley.newRequestQueue(getContext());
                            queue1.add(RBIRequest_home);

                            PithcerReqeust_ER_Away PithcerReqeust_ER_Away = new PithcerReqeust_ER_Away(choice_away, choice_home, away_pitcher, responseListener);
                            RequestQueue queue4 = Volley.newRequestQueue(getContext());
                            queue4.add(PithcerReqeust_ER_Away);
                        }

                        ScoreRequest_home ScoreRequest_home = new ScoreRequest_home(choice_away, choice_home,  (String) img1.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_home);

                        ScoreRequest_home scoreRequesthome1 = new ScoreRequest_home(choice_away, choice_home,  (String) img3.getText(), responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(scoreRequesthome1);

                        ScoreRequest_home scoreRequesthome2 = new ScoreRequest_home(choice_away, choice_home,  (String) img0.getText(), responseListener);
                        RequestQueue queue5 = Volley.newRequestQueue(getContext());
                        queue5.add(scoreRequesthome2);
                        h++;
                        if(h>8) {
                            h=0;
                        }
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.INVISIBLE);// 주자 3루로 이동

                        runCnt = 0; //주자 2,3루

                        for (int i = 0; i < 3; i++) {
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    hscore++;
                                    et_hscore.setText("원정   " + choice_home + Integer.toString(hscore));
                                    home_ining++;
                                }
                            }, 500);
                        }

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);

                    } else if (runCnt == 7) {// 주자의 현재 위치
                        BatterRequest_Homerun_home BatterRequest_Homerun_home = new BatterRequest_Homerun_home(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getContext());
                        queue.add(BatterRequest_Homerun_home);

                        PitcherRequest_Homerun_away PitcherRequest_Homerun_away = new PitcherRequest_Homerun_away(choice_away, choice_home, home_arr[h], responseListener);
                        RequestQueue queue9 = Volley.newRequestQueue(getContext());
                        queue.add(PitcherRequest_Homerun_away);

                        for(int i=0; i<4; i++) {
                            RBIRequest_home RBIRequest_home = new RBIRequest_home(choice_away, choice_home, home_arr[h], responseListener);
                            RequestQueue queue1 = Volley.newRequestQueue(getContext());
                            queue1.add(RBIRequest_home);

                            PithcerReqeust_ER_Away PithcerReqeust_ER_Away = new PithcerReqeust_ER_Away(choice_away, choice_home, away_pitcher, responseListener);
                            RequestQueue queue4 = Volley.newRequestQueue(getContext());
                            queue4.add(PithcerReqeust_ER_Away);
                        }

                        ScoreRequest_home ScoreRequest_home = new ScoreRequest_home(choice_away, choice_home,  (String) img1.getText(), responseListener);
                        RequestQueue queue2 = Volley.newRequestQueue(getContext());
                        queue2.add(ScoreRequest_home);

                        ScoreRequest_home scoreRequesthome1 = new ScoreRequest_home(choice_away, choice_home,  (String) img2.getText(), responseListener);
                        RequestQueue queue3 = Volley.newRequestQueue(getContext());
                        queue3.add(scoreRequesthome1);

                        ScoreRequest_home scoreRequesthome2 = new ScoreRequest_home(choice_away, choice_home,  (String) img3.getText(), responseListener);
                        RequestQueue queue5 = Volley.newRequestQueue(getContext());
                        queue5.add(scoreRequesthome2);

                        ScoreRequest_home scoreRequesthome3 = new ScoreRequest_home(choice_away, choice_home,  (String) img0.getText(), responseListener);
                        RequestQueue queue6 = Volley.newRequestQueue(getContext());
                        queue6.add(scoreRequesthome3);

                        h++;
                        if(h>8) {
                            h=0;
                        }
                        img0.setText(home_arr[h]);
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.INVISIBLE);// 주자 3루로 이동

                        runCnt = 0; //주자 2,3루

                        for (int i = 0; i < 4; i++) {
                            handler.postDelayed(new Runnable() { // 별이 바로 없어지면 아쉬워서 0.5초 딜레이
                                @Override
                                public void run() {
                                    hscore++;
                                    et_hscore.setText("원정   " + choice_home + Integer.toString(hscore));
                                    home_ining++;
                                }
                            }, 500);
                        }

                        stkCnt = 0;
                        ballCnt = 0;

                        layout_SDT.setVisibility(View.INVISIBLE);
                        btn_SBO.setVisibility(View.VISIBLE);
                    }
                }
            }

        });


        return v;
    }
}

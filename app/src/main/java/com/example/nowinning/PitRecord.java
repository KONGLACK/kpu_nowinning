package com.example.nowinning;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class PitRecord extends AppCompatActivity {

    private static String IP_ADDRESS = "http://shun8800.dothome.co.kr";
    private static String TAG = "phppitcher";

    private EditText mEditTextName;
    private EditText mEditTextCountry;
    private TextView mTextViewResult;
    private ArrayList<PitcherData> mArrayList;
    private PitcherAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private EditText mEditTextSearchKeyword;
    private String mJsonString;
    public static int batpit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pitcher_record);

            /*mEditTextName = (EditText)findViewById(R.id.editText_main_name);
            mEditTextCountry = (EditText)findViewById(R.id.editText_main_country);
            mTextViewResult = (TextView)findViewById(R.id.textView_main_result);*/
        mRecyclerView = (RecyclerView) findViewById(R.id.listView_main_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mEditTextSearchKeyword = (EditText) findViewById(R.id.editText_main_searchKeyword);

        //mTextViewResult.setMovementMethod(new ScrollingMovementMethod());


        mArrayList = new ArrayList<>();

        mAdapter = new PitcherAdapter(this, mArrayList);
        mRecyclerView.setAdapter(mAdapter);


            /*Button buttonInsert = (Button)findViewById(R.id.button_main_insert);
            buttonInsert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String name = mEditTextName.getText().toString();
                    String country = mEditTextCountry.getText().toString();

                    InsertData task = new InsertData();
                    task.execute(IP_ADDRESS + "/insert.php", name,country);


                    mEditTextName.setText("");
                    mEditTextCountry.setText("");

                }
            });*/

        Button rec_bat2 = (Button) findViewById(R.id.rec_bat2);
        rec_bat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PitRecord.this, BatRecord.class);
                startActivity(intent);

                finish();

            }
        });

        Button rec_pit2 = (Button) findViewById(R.id.rec_pit2);
        rec_pit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(PitRecord.this,"현재 투수 페이지 입니다.", Toast.LENGTH_SHORT).show();

            }
        });


        Button button_search = (Button) findViewById(R.id.button_main_search);
        button_search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                mArrayList.clear();
                mAdapter.notifyDataSetChanged();


                String Keyword = mEditTextSearchKeyword.getText().toString();
                mEditTextSearchKeyword.setText("");

                GetData task = new GetData();
                task.execute(IP_ADDRESS + "/pitquery.php", Keyword);
            }
        });


        Button button_all = (Button) findViewById(R.id.button_main_all);

        button_all.setVisibility(View.GONE);
        button_all.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                mArrayList.clear();
                mAdapter.notifyDataSetChanged();

                GetData task = new GetData();
                task.execute(IP_ADDRESS + "/pitgetjson.php", "");
            }
        });

    }


    class InsertData extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(PitRecord.this,
                    "Please Wait", null, true, true);
        }


            /*@Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);

                progressDialog.dismiss();
                mTextViewResult.setText(result);
                Log.d(TAG, "POST response  - " + result);
            }*/


        @Override
        protected String doInBackground(String... params) {

            String pitcher_name = (String) params[1];
            String team_name = (String) params[2];
            String play_inning = (String) params[3];
            String HR = (String) params[4];
            String Hits = (String) params[5];
            String ER = (String) params[6];
            String SO = (String) params[7];
            String BB = (String) params[8];
            String RBI = (String) params[9];
            String OBP = (String) params[10];
            String SLG = (String) params[11];
            String OPS = (String) params[12];
            String SB = (String) params[13];
            String SH = (String) params[14];
            String SF = (String) params[15];

            String serverURL = (String) params[0];
            String postParameters = "pitcher_name=" + pitcher_name + "&team_name=" + team_name + "&play_inning=" + play_inning +
                    "&HR=" + HR + "&Hits=" + Hits + "&ER=" + ER + "&SO=" + SO + "&BB=" + BB /*+ "&RBI=" + RBI + "&OBP=" + OBP +
                "&SLG=" + SLG + "&OPS=" + OPS + "&SB=" + SB + "&SH=" + SH + "&SF=" + SF*/;


            try {

                URL url = new URL(serverURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.connect();


                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(postParameters.getBytes("UTF-8"));
                outputStream.flush();
                outputStream.close();


                int responseStatusCode = httpURLConnection.getResponseCode();
                Log.d(TAG, "POST response code - " + responseStatusCode);

                InputStream inputStream;
                if (responseStatusCode == HttpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                } else {
                    inputStream = httpURLConnection.getErrorStream();
                }


                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder sb = new StringBuilder();
                String line = null;

                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }


                bufferedReader.close();


                return sb.toString();


            } catch (Exception e) {

                Log.d(TAG, "InsertData: Error ", e);

                return new String("Error: " + e.getMessage());
            }

        }
    }


    private class GetData extends AsyncTask<String, Void, String>{

        ProgressDialog progressDialog;
        String errorString = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(PitRecord.this,
                    "Please Wait", null, true, true);
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            progressDialog.dismiss();
            //mTextViewResult.setText(result);
            Log.d(TAG, "response - " + result);

                /*if (result == null){

                    mTextViewResult.setText(errorString);
                }
                else {*/

            mJsonString = result;
            showResult();
            //}
        }


        @Override
        protected String doInBackground(String... params) {

            String serverURL = params[0];
            String postParameters = "pitcher_name=" + params[1];


            try {

                URL url = new URL(serverURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();


                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(postParameters.getBytes("UTF-8"));
                outputStream.flush();
                outputStream.close();


                int responseStatusCode = httpURLConnection.getResponseCode();
                Log.d(TAG, "response code - " + responseStatusCode);

                InputStream inputStream;
                if(responseStatusCode == HttpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                }
                else{
                    inputStream = httpURLConnection.getErrorStream();
                }


                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder sb = new StringBuilder();
                String line;

                while((line = bufferedReader.readLine()) != null){
                    sb.append(line);
                }

                bufferedReader.close();

                return sb.toString().trim();


            } catch (Exception e) {

                Log.d(TAG, "InsertData: Error ", e);
                errorString = e.toString();

                return null;
            }

        }
    }


    private void showResult(){

        String TAG_JSON="shun8800";
        String TAG_PITCHER = "pitcher_name";
        String TAG_TEAM ="team_name";
        String TAG_Play = "play_inning";
        String Tag_HR = "HR";
        String Tag_HITS = "Hits";
        String Tag_ER = "ER";
        String Tag_SO = "SO";
        String Tag_BB = "BB";
            /*String Tag_RBI = "RBI";
            String Tag_OBP = "OBP";
            String Tag_SLG = "SLG";
            String Tag_OPS = "OPS";
            String Tag_SB = "SB";
            String Tag_SH = "SH";
            String Tag_SF = "SF";*/


        try {
            JSONObject jsonObject = new JSONObject(mJsonString);
            JSONArray jsonArray = jsonObject.getJSONArray(TAG_JSON);

            for(int i=0;i<jsonArray.length();i++){

                JSONObject item = jsonArray.getJSONObject(i);

                String pitcher_name = item.getString(TAG_PITCHER);
                String team_name = item.getString(TAG_TEAM);
                String play_inning = item.getString(TAG_Play);
                String HR = item.getString(Tag_HR);
                String Hits = item.getString(Tag_HITS);
                String ER = item.getString(Tag_ER);
                String SO = item.getString(Tag_SO);
                String BB = item.getString(Tag_BB);
                    /*String RBI = item.getString(Tag_RBI);
                    String OBP = item.getString(Tag_OBP);
                    String SLG = item.getString(Tag_SLG);
                    String OPS = item.getString(Tag_OPS);
                    String SB = item.getString(Tag_SB);
                    String SH = item.getString(Tag_SH);
                    String SF = item.getString(Tag_SF);*/

                PitcherData pitcherData = new PitcherData();

                pitcherData.setMember_pitcher_name(pitcher_name);
                pitcherData.setMember_team_name(team_name);
                pitcherData.setMember_play_inning(play_inning);
                pitcherData.setMember_HR(HR);
                pitcherData.setMember_Hits(Hits);
                pitcherData.setMember_ER(ER);
                pitcherData.setMember_SO(SO);
                pitcherData.setMember_BB(BB);
                    /*personalData.setMember_RBI(RBI);
                    personalData.setMember_OBP(OBP);
                    personalData.setMember_SLG(SLG);
                    personalData.setMember_OPS(OPS);
                    personalData.setMember_SB(SB);
                    personalData.setMember_SH(SH);
                    personalData.setMember_SF(SF);*/


                mArrayList.add(pitcherData);
                mAdapter.notifyDataSetChanged();
            }



        } catch (JSONException e) {

            Log.d(TAG, "showResult : ", e);
        }

    }

}

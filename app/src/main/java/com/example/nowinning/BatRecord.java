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


public class BatRecord extends AppCompatActivity {

    private static String IP_ADDRESS = "http://shun8800.dothome.co.kr";
    private static String TAG = "phpbatter";

    private EditText mEditTextName;
    private EditText mEditTextCountry;
    private TextView mTextViewResult;
    private ArrayList<BatterData> mArrayList;
    private BatterAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private EditText mEditTextSearchKeyword;
    private String mJsonString;
    public static int batpit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batter_record);

            /*mEditTextName = (EditText)findViewById(R.id.editText_main_name);
            mEditTextCountry = (EditText)findViewById(R.id.editText_main_country);
            mTextViewResult = (TextView)findViewById(R.id.textView_main_result);*/
        mRecyclerView = (RecyclerView) findViewById(R.id.listView_main_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mEditTextSearchKeyword = (EditText) findViewById(R.id.editText_main_searchKeyword);

        //mTextViewResult.setMovementMethod(new ScrollingMovementMethod());


        mArrayList = new ArrayList<>();

        mAdapter = new BatterAdapter(this, mArrayList);
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

        Button rec_bat1 = (Button) findViewById(R.id.rec_bat1);
        rec_bat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(BatRecord.this,"현재 타자 페이지 입니다.", Toast.LENGTH_SHORT).show();

            }
        });

        Button rec_pit1 = (Button) findViewById(R.id.rec_pit1);
        rec_pit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                batpit = 2;
                Intent intent = new Intent(BatRecord.this, PitRecord.class);
                startActivity(intent);

                finish();

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
                task.execute(IP_ADDRESS + "/batquery.php", Keyword);
            }
        });


        Button button_all = (Button) findViewById(R.id.button_main_all);

        button_all.setVisibility(View.GONE);
        button_all.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                mArrayList.clear();
                mAdapter.notifyDataSetChanged();

                GetData task = new GetData();
                task.execute(IP_ADDRESS + "/batgetjson.php", "");
            }
        });


    }


    class InsertData extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(BatRecord.this,
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

            String batter_name = (String) params[1];
            String team_name = (String) params[2];
            String Hit = (String) params[3];
            String AVG = (String) params[4];
            String ONE = (String) params[5];
            String TWO = (String) params[6];
            String THREE = (String) params[7];
            String Score = (String) params[8];
            String RBI = (String) params[9];
            String OBP = (String) params[10];
            String SLG = (String) params[11];
            String OPS = (String) params[12];
            String SB = (String) params[13];
            String SH = (String) params[14];
            String SF = (String) params[15];

            String serverURL = (String) params[0];
            String postParameters = "batter_name=" + batter_name + "&team_name=" + team_name + "&Hit=" + Hit +
                    "&AVG=" + AVG + "&ONE=" + ONE + "&TWO=" + TWO + "&THREE=" + THREE + "&Score=" + Score /*+ "&RBI=" + RBI + "&OBP=" + OBP +
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

            progressDialog = ProgressDialog.show(BatRecord.this,
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
            String postParameters = "batter_name=" + params[1];


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
        String TAG_BATTER = "batter_name";
        String TAG_TEAM ="team_name";
        String TAG_Hit = "Hit";
        String Tag_AVG = "AVG";
        String Tag_ONE = "ONE";
        String Tag_TWO = "TWO";
        String Tag_THREE = "THREE";
        String Tag_Score = "Score";
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

                String batter_name = item.getString(TAG_BATTER);
                String team_name = item.getString(TAG_TEAM);
                String Hit = item.getString(TAG_Hit);
                String AVG = item.getString(Tag_AVG);
                String ONE = item.getString(Tag_ONE);
                String TWO = item.getString(Tag_TWO);
                String THREE = item.getString(Tag_THREE);
                String Score = item.getString(Tag_Score);
                    /*String RBI = item.getString(Tag_RBI);
                    String OBP = item.getString(Tag_OBP);
                    String SLG = item.getString(Tag_SLG);
                    String OPS = item.getString(Tag_OPS);
                    String SB = item.getString(Tag_SB);
                    String SH = item.getString(Tag_SH);
                    String SF = item.getString(Tag_SF);*/

                BatterData batterData = new BatterData();

                batterData.setMember_batter_name(batter_name);
                batterData.setMember_team_name(team_name);
                batterData.setMember_Hit(Hit);
                batterData.setMember_AVG(AVG);
                batterData.setMember_ONE(ONE);
                batterData.setMember_TWO(TWO);
                batterData.setMember_THREE(THREE);
                batterData.setMember_Score(Score);
                    /*personalData.setMember_RBI(RBI);
                    personalData.setMember_OBP(OBP);
                    personalData.setMember_SLG(SLG);
                    personalData.setMember_OPS(OPS);
                    personalData.setMember_SB(SB);
                    personalData.setMember_SH(SH);
                    personalData.setMember_SF(SF);*/


                mArrayList.add(batterData);
                mAdapter.notifyDataSetChanged();
            }



        } catch (JSONException e) {

            Log.d(TAG, "showResult : ", e);
        }

    }

}

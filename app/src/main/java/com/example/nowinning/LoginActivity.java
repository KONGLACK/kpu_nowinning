package com.example.nowinning;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class LoginActivity extends AppCompatActivity {

    private AlertDialog dialog;
    EditText idtext, pwdtext;
    Button login_btn, find_id_btn, find_pw_btn, signup_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        idtext = (EditText) findViewById(R.id.id_edittext);
        pwdtext = (EditText) findViewById(R.id.pw_edittext);

        login_btn = findViewById(R.id.login_button);
        find_id_btn = findViewById(R.id.findid_button);
        find_pw_btn = findViewById(R.id.findpw_button);
        signup_btn = findViewById(R.id.signup_button);


        // 로그인 동작
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String UserID = idtext.getText().toString();
                final String UserPwd = pwdtext.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");


                            if(success) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);

                                dialog = builder.setMessage("로그인에 성공했습니다")
                                        .setPositiveButton("확인", null)
                                        .create();

                                dialog.show();

                                Intent intent = new Intent(LoginActivity.this, teamsel.class);
                                startActivity(intent);
                            }
                            else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                dialog = builder.setMessage("계정을 다시 확인하세요")
                                        .setNegativeButton("다시시도", null)
                                        .create();
                                dialog.show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(UserID, UserPwd, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);

            }
        });


        // 회원가입 동작
        signup_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
            }
        });










    }
}

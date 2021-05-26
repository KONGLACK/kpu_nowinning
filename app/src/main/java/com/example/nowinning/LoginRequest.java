package com.example.nowinning;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {

    final static private String URL = "http://shun8800.dothome.co.kr/login.php";
    private Map<String, String> parameters;


    public LoginRequest(String UserID, String UserPwd, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        parameters = new HashMap<>();
        parameters.put("UserID", UserID);
        parameters.put("UserPwd", UserPwd);
    }

    protected Map<String, String> getParams() throws AuthFailureError {
        return parameters;
    }
}

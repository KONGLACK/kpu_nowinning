package com.example.nowinning;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class ValidateRequest extends StringRequest{
    final static private String URL = "http://shun8800.dothome.co.kr/UserValidate.php";
    private Map<String, String> parameters;

    public ValidateRequest(String UserID, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("UserID", UserID);
    }

    protected Map<String, String> getParams() throws AuthFailureError {
        return parameters;
    }


}

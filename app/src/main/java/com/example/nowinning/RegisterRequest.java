package com.example.nowinning;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;



public class RegisterRequest extends StringRequest{
    final static private String URL = "http://shun8800.dothome.co.kr/Register.php";
    private Map<String, String> parameters;

    public RegisterRequest(String UserID, String UserPwd, String UserNick, String UserEmail
    ,Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);//해당 URL에 POST방식으로 파마미터들을 전송함
        parameters = new HashMap<>();
        parameters.put("UserID", UserID);
        parameters.put("UserPwd", UserPwd);
        parameters.put("UserNick", UserNick);
        parameters.put("UserEmail", UserEmail);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return parameters;
    }


}
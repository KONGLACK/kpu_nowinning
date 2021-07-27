package com.example.nowinning;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class TeamRequest extends StringRequest {

    final static private String URL = "http://shun8800.dothome.co.kr/Team.php";
    private Map<String, String> parameters;

    public TeamRequest(String team, int ball, int strike, int outout, Response.Listener<String> listener) {
        super(Request.Method.POST, URL, listener, null);//해당 URL에 POST방식으로 파마미터들을 전송함
        parameters = new HashMap<>();
        parameters.put("team", team);
        parameters.put("ball", ball+"");
        parameters.put("strike", strike+"");
        parameters.put("outout", outout+"");


    }
    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return parameters;

    }
}

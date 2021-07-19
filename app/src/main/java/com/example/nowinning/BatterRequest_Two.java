package com.example.nowinning;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class BatterRequest_Two extends StringRequest {

    final static private String URL = "http://shun8800.dothome.co.kr/batter_two.php";
    private Map<String, String> parameters;

    public BatterRequest_Two(String Team, String Player, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);//해당 URL에 POST방식으로 파마미터들을 전송함
        parameters = new HashMap<>();
        parameters.put("Team", Team);
        parameters.put("Player", Player);



    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return parameters;

    }
}

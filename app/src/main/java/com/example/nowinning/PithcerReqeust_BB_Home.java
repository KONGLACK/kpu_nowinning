package com.example.nowinning;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class PithcerReqeust_BB_Home extends StringRequest {

    final static private String URL = "http://shun8800.dothome.co.kr/pitcher_bb_home.php";
    private Map<String, String> parameters;

    public PithcerReqeust_BB_Home(String Team1, String Team2, String Player, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);//해당 URL에 POST방식으로 파마미터들을 전송함
        parameters = new HashMap<>();
        parameters.put("Team1", Team1);
        parameters.put("Team2", Team2);
        parameters.put("Player", Player);



    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return parameters;

    }
}

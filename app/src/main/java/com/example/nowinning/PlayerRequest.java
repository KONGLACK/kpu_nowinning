package com.example.nowinning;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class PlayerRequest extends StringRequest {

    final static private String URL = "http://shun8800.dothome.co.kr/Player.php";
    private Map<String, String> parameters;

    public PlayerRequest(String Player, int SingleCount, int DoubleCount, int TripleCount, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);//해당 URL에 POST방식으로 파마미터들을 전송함
        parameters = new HashMap<>();
        parameters.put("Player", Player);
        parameters.put("SingleCount", SingleCount+"");
        parameters.put("DoubleCount", DoubleCount+"");
        parameters.put("TripleCount", TripleCount+"");


    }
    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return parameters;

    }
}

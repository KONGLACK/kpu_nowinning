package com.example.nowinning;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class BatterRequest extends StringRequest {

    final static private String URL = "http://shun8800.dothome.co.kr/batter.php";
    private Map<String, String> parameters;

    public BatterRequest (String Team, String Player, int SingleCount, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);//해당 URL에 POST방식으로 파마미터들을 전송함
        parameters = new HashMap<>();
        parameters.put("Team", Team);
        parameters.put("Player", Player);
        parameters.put("SingleCount", SingleCount+"");



    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return parameters;

    }
}

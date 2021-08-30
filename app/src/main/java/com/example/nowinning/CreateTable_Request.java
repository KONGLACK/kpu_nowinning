package com.example.nowinning;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class CreateTable_Request extends StringRequest {

    final static private String URL = "http://shun8800.dothome.co.kr/CreateTable_batter.php";
    private Map<String, String> parameters;

    public CreateTable_Request(String Team1, String Team2, String Player1, String Player2, String Player3, String Player4,
                               String Player5, String Player6, String Player7, String Player8,
                               String Player9, String Player10, String Player11, String Player12, String Player13,
                               String Player14, String Player15, String Player16, String Player17,
                               String Player18, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);//해당 URL에 POST방식으로 파마미터들을 전송함
        parameters = new HashMap<>();
        parameters.put("Team1", Team1);
        parameters.put("Team2", Team2);
        parameters.put("Player1", Player1);
        parameters.put("Player2", Player2);
        parameters.put("Player3", Player3);
        parameters.put("Player4", Player4);
        parameters.put("Player5", Player5);
        parameters.put("Player6", Player6);
        parameters.put("Player7", Player7);
        parameters.put("Player8", Player8);
        parameters.put("Player9", Player9);
        parameters.put("Player10", Player10);
        parameters.put("Player11", Player11);
        parameters.put("Player12", Player12);
        parameters.put("Player13", Player13);
        parameters.put("Player14", Player14);
        parameters.put("Player15", Player15);
        parameters.put("Player16", Player16);
        parameters.put("Player17", Player17);
        parameters.put("Player18", Player18);



    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return parameters;

    }
}

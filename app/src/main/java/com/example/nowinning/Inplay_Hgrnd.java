package com.example.nowinning;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import static com.example.nowinning.BSOActivity.btn_SBO;
import static com.example.nowinning.BSOActivity.btn_o;

public class Inplay_Hgrnd extends Fragment {

    public static Button btn_Out, btn_Hit, btn_Error, btn_Foul, btn_ItpHR, btn_Bfoul;
    public static LinearLayout layout_inplay2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.inplay2, container, false);

        btn_Out = (Button) v.findViewById(R.id.btn_Out);
        btn_Hit = (Button) v.findViewById(R.id.btn_Hit);
        btn_Error = (Button) v.findViewById(R.id.btn_Error);
        btn_Foul = (Button) v.findViewById(R.id.btn_Foul);
        btn_ItpHR = (Button) v.findViewById(R.id.btn_ItpHR);

        layout_inplay2 = (LinearLayout) v.findViewById(R.id.layout_inplay2);

        /*Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };*/

        btn_Out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_o.performClick();

                layout_inplay2.setVisibility(View.INVISIBLE);
                btn_SBO.setVisibility(View.VISIBLE);
            }
        });

        btn_Hit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                SDT_select sdt_select = new SDT_select();
                transaction.replace(R.id.frame, sdt_select);
                transaction.commit(); // ??????
            }
        });

        btn_Error.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"?????? ??????", Toast.LENGTH_SHORT).show();

            }
        });

        btn_Foul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"?????? ??????", Toast.LENGTH_SHORT).show();

            }
        });

        btn_ItpHR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"?????? ??????", Toast.LENGTH_SHORT).show();
            }
        });

        /*btn_Bfoul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"?????? ??????", Toast.LENGTH_SHORT).show();

            }
        });*/


        return v;
    }
}
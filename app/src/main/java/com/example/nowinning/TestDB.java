package com.example.nowinning;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class TestDB extends AppCompatActivity {

    private EditText et_test1, et_test2, et_test3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_db);

        et_test1.findViewById(R.id.et_test1);
        et_test2.findViewById(R.id.et_test2);
        et_test3.findViewById(R.id.et_test3);
    }
}

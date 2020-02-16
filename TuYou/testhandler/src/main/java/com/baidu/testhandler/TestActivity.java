package com.baidu.testhandler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class TestActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        Button button = findViewById(R.id.test);

//        Scanner.registerCallback(new Callback() {
//            @Override
//            public void onSuccess(List<String> data) {
//
//            }
//        });

        Scanner.waitUntilFinished();
    }
}

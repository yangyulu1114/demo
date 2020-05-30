package com.baidu.testservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mStartService;
    private Button mStopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStartService = findViewById(R.id.start);
        mStopService = findViewById(R.id.stop);
        setOnclickListener();
    }

    protected void setOnclickListener() {
        mStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(MainActivity.this, MyService.class);
                startService(startIntent);
            }
        });

        mStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stopIntent = new Intent(MainActivity.this, MyService.class);
                stopService(stopIntent);
            }
        });
    }
}

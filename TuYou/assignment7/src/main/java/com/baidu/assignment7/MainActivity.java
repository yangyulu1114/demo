package com.baidu.assignment7;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private int a = 10;

    ExecutorService executorService = Executors.newSingleThreadExecutor();

    HandlerThread mHandlerThread;
    Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
            }
        });

        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick2();
            }
        });

        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {

            }
        };
     //   handler.sendMessage(1);
        handler.sendEmptyMessage(1);
        handler.post(new Runnable() {
            @Override
            public void run() {

            }
        });


        mHandlerThread = new HandlerThread("fsd");
        mHandlerThread.start();

        mHandler = new Handler(mHandlerThread.getLooper());
        mHandler.post(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    private void doClick() {
        new Thread() {
            @Override
            public void run() {
                int b = 20;
                Log.v("bush", String.format("a=%d", a));
                a++;
            }
        }.start();


        executorService.execute(new Runnable() {
            @Override
            public void run() {
                Log.v("bush", "");
            }
        });


    }

    private void doClick2() {
        new Thread() {
            @Override
            public void run() {
                Log.v("bush", String.format("a=%d", a));
                a++;
            }
        }.start();
    }

    private void func() {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                func();
            }
        });
    }
}

package com.baidu.testhandler;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int mCount;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    break;
                case 2:
                    mHandler.sendEmptyMessageDelayed(2, 1000);
                    Log.v("bush", String.format("%d", mCount++));
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btn = findViewById(R.id.test);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mHandler.hasMessages(2)) {
                    mHandler.removeMessages(2);
                    return;
                }
                new Scanner().scan(new Callback() {
                    @Override
                    public void onSuccess(List<String> datas) {
                        Log.v("bush", String.format("thread: %s", Thread.currentThread().getName()));
                        for (String s : datas) {
                            Log.v("bush", s);
                        }
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                btn.setText("finish");
                            }
                        });
                        mHandler.sendEmptyMessage(2);
                    }
                });

            }
        });
    }
}

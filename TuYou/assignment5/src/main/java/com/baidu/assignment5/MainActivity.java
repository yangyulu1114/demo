package com.baidu.assignment5;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private MyView mButtonView;
    private int mCount;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    mButtonView.setStatus(2, 0);
                    mButtonView.invalidate();
                    break;
                case 2:
                    if (mCount > 100) {
                        removeMessages(2);
                        mHandler.sendEmptyMessage(1);

                    } else {
                        mButtonView.setStatus(1, mCount++);
                        mButtonView.invalidate();
                        mHandler.sendEmptyMessageDelayed(2, 100);
                        Log.v("bush", String.format("%d", mCount));
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCount = 0;
        mButtonView = findViewById(R.id.button);
        mButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("bush", "click");
                mHandler.sendEmptyMessage(2);
            }
        });
    }
}

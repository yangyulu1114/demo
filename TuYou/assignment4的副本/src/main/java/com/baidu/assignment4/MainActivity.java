package com.baidu.assignment4;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toolbar;

import java.util.List;

public class MainActivity extends Activity {

    private static final int REQUEST_CODE_FOR_STORAGE = 1;

    private ListView mListView;
    private MyAdapter mAdapter;
    private SystemMediaScanner mMediaScanner;
    private List<ImageBean> mImageBeanList;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    break;
                case 2:
                    Intent intent = new Intent(MainActivity.this, GroupActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.listview);
        mAdapter = new MyAdapter(this);
        mListView.setAdapter(mAdapter);
        mMediaScanner = new SystemMediaScanner(this);
        MyView view = findViewById(R.id.title_bar);
        view.setGestureListener(new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                Log.v("bush", "onDoubleTap");
                mListView.setSelection(0);
                return true;
            }

            @Override
            public boolean onDoubleTapEvent(MotionEvent e) {
                return true;
            }

            @Override
            public boolean onDown(MotionEvent e) {
                return true;
            }
        });
        mMediaScanner.registerCallback(new Callback() {
            @Override
            public void onSuccess(List<ImageBean> beanList) {
                mImageBeanList = beanList;
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        reFreshUi();
                    }
                });

            }
        });

        mHandler.sendEmptyMessageDelayed(2, 1000);


        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            startScan();
        }
        if (permissionCheck == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE_FOR_STORAGE);
        }

        setScrollListener();
    }

    protected void startScan() {
        mMediaScanner.scan();
//        mMediaScanner.registerCallback(new Callback() {
//            @Override
//            public void onSuccess(List<ImageBean> beanList) {
//                mImageBeanList = beanList;
//                mHandler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        reFreshUi();
//                    }
//                });
//                mHandler.sendEmptyMessageDelayed(2, 1000);
//            }
//        });

//        mMediaScanner.registerCallback(new Callback() {
//            @Override
//            public void onSuccess() {
//                Log.v("bush", String.format("thread: %s", Thread.currentThread().getName()));
//                mHandler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        reFreshUi();
//                    }
//                });
//                mHandler.sendEmptyMessage(2);
//            }
//        });

    }

    protected void reFreshUi() {
        Log.v("bush", "listsize" + mImageBeanList.size());
        mAdapter.setImageList(mImageBeanList);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case REQUEST_CODE_FOR_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startScan();
                } else {
                    finish();
                }
        }
    }

    protected void setScrollListener() {
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                Log.v("bush", String.format("firstVisibleItem=%d, visibleItemCount = %d, totalItemCount = %d",
                        firstVisibleItem, visibleItemCount, totalItemCount));
                if ((firstVisibleItem + visibleItemCount) == totalItemCount) {
                    View lastVisibleItemView = mListView.getChildAt(mListView.getChildCount() - 1);
                    if (lastVisibleItemView != null && lastVisibleItemView.getBottom() == mListView.getHeight()) {
                        Log.v("bush", "reach bottom");
                        startScan();
                    }
                }
            }
        });
    }
}

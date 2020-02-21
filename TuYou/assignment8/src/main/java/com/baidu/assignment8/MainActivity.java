package com.baidu.assignment8;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends Activity {

    private static final int REQUEST_CODE_FOR_STORAGE = 1;

    private SystemMediaScanner mMediaScanner;
    private List<ImageBean> mImageBeanList;
    private long mTimeStamp;
    private ListView mListView;
    private MyAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.listview);
        mAdapter = new MyAdapter(this);
        mListView.setAdapter(mAdapter);

        mMediaScanner = new SystemMediaScanner(this);

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            startScan();
        }
        if (permissionCheck == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE_FOR_STORAGE);
        }
        Log.v("bush", "main   " + Thread.currentThread().getName());
    }

    protected void startScan() {
        Configuration configuration = new Configuration.Builder()
                .requireDisplayName()
                .requireDateTaken()
                .requireFileSize()
                .requireHeight()
                .requireDateAdded()
                .requireFilePath()
                .requireWidth()

                .setSizeRange(new long[] {10240, -1})
                .setWidthRange(new long[] {100, -1})
                .setHeightRange(new long[] {100, -1})
                .orderByDateTaken(Configuration.Order.DESC)
                .addRequiredMimeType(Configuration.MimeType.JPG)
                .addRequiredMimeType(Configuration.MimeType.PNG)
                .build();

        mMediaScanner.scan(configuration, new Callback() {
            @Override
            public void onSuccess(List<ImageBean> beanList) {
                mImageBeanList = beanList;
                reFreshUi();
            }

        });
    }

    protected void reFreshUi() {
        mAdapter.setImageList(mImageBeanList);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
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

    public void test() {

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Looper.prepare();
//                Log.v("bush", "akhakfh   " +  Thread.currentThread().getName());
//                new SystemMediaScanner(MainActivity.this).test(new Callback() {
//                    @Override
//                    public void onSuccess(List<ImageBean> beanList) {
//                        Log.v("bush", Thread.currentThread().getName());
//                        TextView textView = findViewById(R.id.text);
//                        textView.setText("hello");
//                    }
//                });
//                Looper.loop();
//            }
//        }).start();
    }
}

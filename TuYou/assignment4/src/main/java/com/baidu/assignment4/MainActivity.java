package com.baidu.assignment4;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends Activity {

    private static final int REQUEST_CODE_FOR_STORAGE = 1;

    private ListView mListView;
    private MyAdapter mAdapter;
    private SystemMediaScanner mMediaScanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.listview);
        mAdapter = new MyAdapter(this);
        mListView.setAdapter(mAdapter);
        mMediaScanner = new SystemMediaScanner(this);

        getActionBar().hide();

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            reFreshUi();
        }
        if (permissionCheck == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE_FOR_STORAGE);
        }

        setScrollListener();
    }

    protected void reFreshUi() {
        mMediaScanner.scan();

        List<ImageBean> imageBeanList = mMediaScanner.getmImageList();
        mAdapter.setImageList(imageBeanList);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case REQUEST_CODE_FOR_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    reFreshUi();
                } else {
                    finish();
                }
        }
    }

    //    protected void setOnclickListener() {
//        mActionBar.
//    }
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
                        reFreshUi();
                    }
                }
            }
        });
    }
}

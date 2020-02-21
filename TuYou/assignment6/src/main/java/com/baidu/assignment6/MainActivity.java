package com.baidu.assignment6;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_FOR_STORAGE = 1;

    private SystemMediaScanner mMediaScanner;
    private List<ImageBean> mImageBeanList;
    private HashMap<Integer, List<ImageBean>> mImageMap;
    private long mTimeStamp;
    private TextView mTextView;
    private Button mRetartButton;
    private Button mCancelButton;
    private Button mPauseButton;
    private Button mResumeButton;
    private int mStatus;

    private int PAGE_SIZE = 5;
    private int KB_SIZE_LEVEL1 = 1;
    private int KB_SIZE_LEVEL2 = 2;
    private int KB_SIZE_LEVEL3 = 3;
    private int MB_SIZE_LEVEL1 = 4;
    private int MB_SIZE_LEVEL2 = 5;
    private int MB_SIZE_LEVEL3 = 6;
    private int MB_SIZE_LEVEL4 = 7;
    private int MB_SIZE_LEVEL5 = 8;

    private int RESTART = 1;
    private int CANCEL = 2;
    private int PAUSE = 3;
    private int RESUME = 4;


    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    setContenView();
                    break;
                case 2:
                    startScan();
                    break;
                case 3:
                    mImageBeanList.clear();
                    mImageMap.clear();
                    setContenView();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.text);

        mMediaScanner = new SystemMediaScanner(this);
        mTimeStamp = System.currentTimeMillis();
        mImageBeanList = new LinkedList<>();
        mImageMap = new HashMap<>();

        mRetartButton = findViewById(R.id.restart);
        mCancelButton = findViewById(R.id.cancel);
        mPauseButton = findViewById(R.id.pause);
        mResumeButton = findViewById(R.id.resume);

        mStatus = RESTART;
        setContenView();

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
//        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
//            startScan();
//        }
        if (permissionCheck == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE_FOR_STORAGE);
        }

        setOnClickListener();

    }

    protected void startScan() {
        Configuration configuration = new Configuration.Builder()
                .requireDisplayName()
//                .requireDateTaken()
                .requireFileSize()
//                .requireHeight()
                .requireDateAdded()
                .requireFilePath()
                .requireWidth()

                .setTimestampRange(new long[] {-1, mTimeStamp})
                .setSizeRange(new long[] {10240, -1})
                .setWidthRange(new long[] {100, -1})
                .setHeightRange(new long[] {100, -1})
                .orderByDateTaken(Configuration.Order.DESC)
                .setPageSize(5)
                .addRequiredMimeType(Configuration.MimeType.JPG)
                .addRequiredMimeType(Configuration.MimeType.PNG)
                .build();

        Builder builder = new Builder().
                requireDisplayName()
//                .requireDateTaken()
                .requireFileSize()
//                .requireHeight()
                .requireDateAdded()
                .requireFilePath()
                .requireWidth()

                .setTimestampRange(new long[] {-1, mTimeStamp})
                .setSizeRange(new long[] {10240, -1})
                .setWidthRange(new long[] {100, -1})
                .setHeightRange(new long[] {100, -1})
                .orderByDateTaken(Configuration.Order.DESC)
                .setPageSize(5)
                .addRequiredMimeType(Builder.MimeType.JPG)
                .addRequiredMimeType(Builder.MimeType.PNG);

        mMediaScanner.scan(configuration, new Callback() {
            @Override
            public void onSuccess(List<ImageBean> beanList) {
                mImageBeanList.addAll(beanList);
                mTimeStamp = mImageBeanList.get(mImageBeanList.size() - 1).getDateTaken();
                conStructImageGroup(beanList);
                Log.v("bush", "Status" + mStatus);
                Log.v("bush", "timestamp" + mTimeStamp);
//                if (beanList.size() == 5 && (mStatus != CANCEL && mStatus != PAUSE)) {
//                    mHandler.sendEmptyMessageDelayed(2, 100);
//                }
                    mHandler.sendEmptyMessageDelayed(1, 50);
            }

            @Override
            public void onFailure(Exception e) {
                Toast.makeText(MainActivity.this, "出错了, 正在扫描", Toast.LENGTH_SHORT).show();
            }
        });
//        mMediaScanner.scan(mTimeStamp, PAGE_SIZE, new Callback() {
//            @Override
//            public void onSuccess(List<ImageBean> beanList) {
//                mImageBeanList.addAll(beanList);
//                mTimeStamp = mImageBeanList.get(mImageBeanList.size() - 1).getDateTaken();
//                conStructImageGroup(beanList);
//                Log.v("bush", "Status" + mStatus);
//                if (beanList.size() == 5 && (mStatus != CANCEL && mStatus != PAUSE)) {
//                    mHandler.sendEmptyMessageDelayed(2, 100);
//                }
//                    mHandler.sendEmptyMessageDelayed(1, 50);
//            }
//
//            @Override
//            public void onFailure() {
//                mHandler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(MainActivity.this, "出错了, 正在扫描", Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//        });
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

    protected void setContenView() {
        int size1 = mImageMap.get(KB_SIZE_LEVEL1) != null ? mImageMap.get(KB_SIZE_LEVEL1).size() : 0 ;
        int size2 = mImageMap.get(KB_SIZE_LEVEL2) != null ? mImageMap.get(KB_SIZE_LEVEL2).size() : 0 ;
        int size3 = mImageMap.get(KB_SIZE_LEVEL3) != null ? mImageMap.get(KB_SIZE_LEVEL3).size() : 0 ;
        int size4 = mImageMap.get(MB_SIZE_LEVEL1) != null ? mImageMap.get(MB_SIZE_LEVEL1).size() : 0 ;
        int size5 = mImageMap.get(MB_SIZE_LEVEL2) != null ? mImageMap.get(MB_SIZE_LEVEL2).size() : 0 ;
        int size6 = mImageMap.get(MB_SIZE_LEVEL3) != null ? mImageMap.get(MB_SIZE_LEVEL3).size() : 0 ;
        int size7 = mImageMap.get(MB_SIZE_LEVEL4) != null ? mImageMap.get(MB_SIZE_LEVEL4).size() : 0 ;
        int size8 = mImageMap.get(MB_SIZE_LEVEL5) != null ? mImageMap.get(MB_SIZE_LEVEL5).size() : 0 ;


        String text = "1KB ~ 100KB大小照片数：" + "\n" + size1 + "\n\n" + "100KB ~ 500KB大小照片数" + "\n"
                + size2 + "\n\n" + "500KB ~ 1MB以上大小照片数" + "\n" + size3 + "\n\n" + "1MB ~ 2MB大小照片数" + "\n"
                + size4 + "\n\n" + "2MB ~ 3MB大小照片数" + "\n" + size5 + "\n\n" + "3MB ~ 4MB大小照片数" + "\n"
                + size6 + "\n\n" + "4MB ~ 5MB大小照片数" + "\n" + size7 + "\n\n" + "5MB以上大小照片数" + "\n"
                + size8;
        mTextView.setText(text);
    }

    protected void conStructImageGroup(List<ImageBean> beanList) {

        for(ImageBean bean : beanList) {
            List<ImageBean> list;
            if (mImageMap.containsKey(sizeScale(bean))){
                list = mImageMap.get(sizeScale(bean));
            } else {
                list = new LinkedList<>();
            }
            list.add(bean);
            mImageMap.put(sizeScale(bean), list);
        }
    }

    private int sizeScale(ImageBean bean) {
        int size = bean.getSize();

        if (size >= 1024 && size < (1024 * 100)) {
            return KB_SIZE_LEVEL1;
        } else if (size >= (1024 * 100) && size < (1024 * 500)) {
            return KB_SIZE_LEVEL2;
        } else if (size >= (1024 * 500) && size < (1024 * 1024)){
            return KB_SIZE_LEVEL3;
        } else if (size >= (1024 * 1024) && size < (1024 * 1024 * 2)) {
            return MB_SIZE_LEVEL1;
        } else if (size >= (1024 * 1024 * 2) && size < (1024 * 1024 * 3)) {
            return MB_SIZE_LEVEL2;
        } else if (size >= (1024 * 1024 * 3) && size < (1024 * 1024 * 4)) {
            return MB_SIZE_LEVEL3;
        } else if (size >= (1024 * 1024 * 4) && size < (1024 * 1024 * 5)) {
            return MB_SIZE_LEVEL4;
        } else {
            return MB_SIZE_LEVEL5;
        }
    }

    protected void setOnClickListener() {
        mRetartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImageBeanList.clear();
                mImageMap.clear();
                mStatus = RESTART;
                mTimeStamp = System.currentTimeMillis();
                startScan();
            }
        });

        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTimeStamp = System.currentTimeMillis();
                mStatus = CANCEL;
                mHandler.sendEmptyMessageDelayed(3, 200);
            }
        });

        mPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStatus = PAUSE;
            }
        });

        mResumeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStatus = RESUME;
                startScan();
            }
        });
    }

    private void test() {
        Configuration configuration = new Configuration.Builder()
                .requireFilePath()
                .requireWidth()
                .requireHeight()
                .requireDateAdded()
                .requireDateTaken()
                .requireDisplayName()
                .requireFileSize()
                .setTimestampRange(new long[] {-1, System.currentTimeMillis()})
                .setSizeRange(new long[] {10240, -1})
                .setWidthRange(new long[] {100, -1})
                .setHeightRange(new long[] {100, -1})
                .orderByDateTaken(Configuration.Order.ASC)
                .setPageSize(5)
                .addRequiredMimeType(Configuration.MimeType.JPG)
                .addRequiredMimeType(Configuration.MimeType.PNG)
                .build();
        mMediaScanner.scan(configuration, new Callback() {
            @Override
            public void onSuccess(List<ImageBean> beanList) {

            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}

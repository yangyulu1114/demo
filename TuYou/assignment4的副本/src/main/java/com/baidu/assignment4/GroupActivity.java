package com.baidu.assignment4;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GroupActivity extends Activity {
    private TextView mTextView;
    private List<ImageBean> mImageList;
    private HashMap<Integer, List<ImageBean>> mImageMap;
    private int B_SIZE = 1;
    private int KB_SIZE = 2;
    private int MB_SIZE = 3;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    break;
                case 2:

                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.groupactivity);
        mTextView = findViewById(R.id.text);
        SystemMediaScanner.registerCallback(new Callback() {
            @Override
            public void onSuccess(List<ImageBean> beanList) {
                mImageList = beanList;
                conStructImageGroup();
                setContenView();
            }
        });
    }

    protected void conStructImageGroup() {
        mImageMap = new HashMap();

        for(ImageBean bean : mImageList) {
            List<ImageBean> list;
            if (mImageMap.containsKey(sizeScale(bean))){
                list = mImageMap.get(sizeScale(bean));
            } else {
                list = new LinkedList<>();
            }
            list.add(bean);
            mImageMap.put(sizeScale(bean), list);
        }
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                setContenView();
            }
        });
    }

    protected void setContenView() {
        int size1 = mImageMap.get(B_SIZE) != null ? mImageMap.get(B_SIZE).size() : 0 ;
        int size2 = mImageMap.get(KB_SIZE) != null ? mImageMap.get(KB_SIZE).size() : 0 ;
        int size3 = mImageMap.get(MB_SIZE) != null ? mImageMap.get(MB_SIZE).size() : 0 ;

        String text = "1KB以下大小照片数：" + "\n" + size1 + "\n\n" + "1KB ~ 1MB大小照片数" + "\n"
                + size2 + "\n\n" + "1MB以上大小照片数" + "\n" + size3;
        mTextView.setText(text);
    }

    private int sizeScale(ImageBean bean) {
        int size = bean.getSize();
        if (size < 1024) {
            return B_SIZE;
        } else if (size < (1024 * 1024)) {
            return KB_SIZE;
        } else {
            return MB_SIZE;
        }
    }
}

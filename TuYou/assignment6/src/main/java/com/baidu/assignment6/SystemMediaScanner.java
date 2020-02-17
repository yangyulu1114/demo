package com.baidu.assignment6;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

public class SystemMediaScanner {

    private static List<ImageBean> mImageList;
    private Context mContext;
    //    private int PAGE_SIZE = 5;
//    private long mTimestamp = System.currentTimeMillis();
    private int mSIZE = 1024;
    private int mWIDTH = 100;
    private int mHEIGHT = 100;
    private volatile boolean scanning = false;


    public SystemMediaScanner(Context context) {
        mContext = context;
    }

    public static final String[] PROJECTION = {
            MediaStore.Images.Media._ID,
            MediaStore.Images.Media.DATA,
            MediaStore.Images.Media.SIZE,
            MediaStore.Images.Media.DISPLAY_NAME,
            MediaStore.Images.Media.DATE_ADDED,
            MediaStore.Images.Media.WIDTH,
            MediaStore.Images.Media.HEIGHT,
            MediaStore.Images.Media.DATE_TAKEN,
    };

    public static final int INDEX_ID = 0;
    public static final int INDEX_DATA = 1;
    public static final int INDEX_SIZE = 2;
    public static final int INDEX_NAME = 3;
    public static final int INDEX_DATE = 4;
    public static final int INDEX_WIDTH = 5;
    public static final int INDEX_HEIGHT = 6;
    public static final int INDEX_DATETAKEN = 7;

    public void scan(final long timestamp, final int page_size, final Callback callback) {
        new Thread("yulu") {
            @Override
            public void run() {
                doScan(timestamp, page_size, callback);
            }
        }.start();
    }

    public void doScan(long timestamp, int page_size, Callback callback) {
        if (scanning == true) {
            callback.onFailure();
            return;
        }

        scanning = true;
        mImageList = new LinkedList<>();
        Log.v("bush", "scan started");
        // TODO Auto-generated method stub
        Cursor cursor = null;
        Log.v("bush", "timestamp" + timestamp);

        try {
            ContentResolver mContentResolver = mContext.getContentResolver();

            cursor = mContentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    PROJECTION,
                    String.format("(%s=? or %s=?) and %s<? and %s>? and %s>? and %s>?",
                            MediaStore.Images.Media.MIME_TYPE,
                            MediaStore.Images.Media.MIME_TYPE,
                            MediaStore.Images.Media.DATE_TAKEN,
                            MediaStore.Images.Media.SIZE,
                            MediaStore.Images.Media.WIDTH,
                            MediaStore.Images.Media.HEIGHT),
                    new String[]{"image/jpeg", "image/png", String.valueOf(timestamp), String.valueOf(mSIZE),
                            String.valueOf(mWIDTH), String.valueOf(mHEIGHT)},
                    MediaStore.Images.Media.DATE_TAKEN + " DESC LIMIT " + page_size);

            if (cursor != null && cursor.moveToFirst()) {
                do {
                    ImageBean bean = new ImageBean(cursor);
                    Log.v("bush", bean.getId() + "");
                    mImageList.add(bean);

                } while (cursor != null && cursor.moveToNext());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        callback.onSuccess(mImageList);
        scanning = false;
    }

//    public List<ImageBean> getmImageList() {
//        return mImageList;
//    }

}


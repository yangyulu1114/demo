package com.baidu.assignment4;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class SystemMediaScanner {

    private List<ImageBean> mImageList = new ArrayList<>();
    private Context mContext;

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

    public void scan() {
        // TODO Auto-generated method stub
        Cursor cursor = null;
        mImageList = new ArrayList<ImageBean>();

        try {
            ContentResolver mContentResolver = mContext.getContentResolver();

            cursor = mContentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    PROJECTION, MediaStore.Images.Media.MIME_TYPE + "=? or " + MediaStore.Images.Media.MIME_TYPE + "=?",
                    new String[]{"image/jpeg", "image/png"},
                    MediaStore.Images.Media._ID + " DESC");

            if (cursor != null && cursor.moveToFirst()) {
                do {
                    ImageBean bean = new ImageBean(cursor);
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
    }

    public List<ImageBean> getmImageList() {
        return mImageList;
    }
}

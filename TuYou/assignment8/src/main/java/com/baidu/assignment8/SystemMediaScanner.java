package com.baidu.assignment8;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SystemMediaScanner {

    private static List<ImageBean> mImageList = new LinkedList<>();
    private Context mContext;
    HandlerThread mHandlerThread;
    private Handler mMainHandler = new Handler(Looper.getMainLooper()); // 确保一定是主线程，以免调用者是在子线程new的scanner
    private Handler mThreadHandler;


    public SystemMediaScanner(Context context) {
        mContext = context;
    }

    public void scan(final Configuration configuration, final Callback callback) {
       mHandlerThread = new HandlerThread("scanner");
       mHandlerThread.start();
       mThreadHandler = new Handler(mHandlerThread.getLooper());
       mThreadHandler.post(new Runnable() {
           @Override
           public void run() {
               doScan(configuration, callback);
           }
       });
    }

    public void doScan(Configuration configuration, final Callback callback) {
        Log.v("bush", "scan started");
        // TODO Auto-generated method stub
        Cursor cursor = null;
//        Log.v("bush", "timestamp" + timestamp);

        try {
            ContentResolver mContentResolver = mContext.getContentResolver();

            Log.v("bush", "projection : " + StringUtils.join(" ", Arrays.asList(getProjection(configuration))));
            Log.v("bush", "selectionString : " + getSelectionString(configuration));
            Log.v("bush", "selectionargs : " + StringUtils.join(" ", Arrays.asList(getSelectionArgs(configuration))));
            Log.v("bush", "orderandlimit : " + getOrderLimitString(configuration));

            cursor = mContentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    getProjection(configuration),
                    getSelectionString(configuration),
                    getSelectionArgs(configuration),
                    getOrderLimitString(configuration));

            List<Configuration.Resolver> resolvers = new ArrayList<>();
            resolvers.add(new Configuration.Resolver() {
                @Override
                public void resolve(ImageBean imageBean, Cursor cursor, int index) {
                    imageBean.setId(cursor.getInt(index));
                }
            });
            resolvers.addAll(configuration.getResolvers());
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    ImageBean bean = new ImageBean(cursor, resolvers);
                    Log.v("bush", bean.toString());
                    mImageList.add(bean);

                } while (cursor != null && cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.e("bush", " " , e);
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        mMainHandler.post(new Runnable() {
            @Override
            public void run() {
                callback.onSuccess(mImageList);
            }
        });
    }

    private String getOrderLimitString(Configuration configuration) {
        StringBuilder sb = new StringBuilder();
        if (configuration.getOrderField() != null) {
            String order = configuration.getOrder() != null ? configuration.getOrder().toString() : "";
            sb.append(String.format("%s %s", configuration.getOrderField(), order));
        }
        if (configuration.getPageSize() > 0) {
            sb.append(String.format(" LIMIT %d", configuration.getPageSize()));
        }
        return sb.toString();
    }

    private String[] getSelectionArgs(Configuration configuration) {
        List<String> args = new ArrayList<>();
        args.addAll(configuration.getRequiredMimeTypes());
        args.addAll(getRangeSelectionArgs(configuration.getSizeRange()));
        args.addAll(getRangeSelectionArgs(configuration.getWidthRange()));
        args.addAll(getRangeSelectionArgs(configuration.getHeightRange()));
        args.addAll(getRangeSelectionArgs(configuration.getTimestampRange()));
        return args.toArray(new String[0]);
    }

    private String[] getProjection(Configuration configuration) {
        List<String> projection = new ArrayList<>();
        projection.add(MediaStore.Images.Media._ID);
        projection.addAll(configuration.getRequiredFields());
        return projection.toArray(new String[0]);
    }

    private String getSelectionString(Configuration configuration) {
        List<String> selections = new ArrayList<>();
        String mimeTypeSelection = getMimeTypeSelection(configuration.getRequiredMimeTypes(),
                MediaStore.Images.Media.MIME_TYPE);
        if (!TextUtils.isEmpty(mimeTypeSelection)) {
            selections.add(mimeTypeSelection);
        }
        String sizeSelection = getRangeSelection(configuration.getSizeRange(),
                MediaStore.Images.Media.SIZE);
        if (!TextUtils.isEmpty(sizeSelection)) {
            selections.add(sizeSelection);
        }
        String widthSelection = getRangeSelection(configuration.getWidthRange(), MediaStore.Images.Media.WIDTH);
        if (!TextUtils.isEmpty(widthSelection)) {
            selections.add(widthSelection);
        }
        String heightSelection = getRangeSelection(configuration.getHeightRange(), MediaStore.Images.Media.HEIGHT);
        if (!TextUtils.isEmpty(heightSelection)) {
            selections.add(heightSelection);
        }
        String timeSelection = getRangeSelection(configuration.getTimestampRange(), MediaStore.Images.Media.DATE_TAKEN);
        if (!TextUtils.isEmpty(timeSelection)) {
            selections.add(timeSelection);
        }
        return StringUtils.join(" and ", selections);
    }

    private String getMimeTypeSelection(List<String> mimeTypes, String value) {
        StringBuilder sb = new StringBuilder();
        if (mimeTypes.isEmpty()) {
            return sb.toString();
        }
        List<String> ss = new ArrayList<>();
        for (String s : mimeTypes) {
            ss.add(String.format("%s=?", value));
        }
        return "(" + StringUtils.join(" or ", ss) + ")";
    }

    private List<String> getRangeSelectionArgs(long[] range) {
        List<String> args = new ArrayList<>();
        if (range == null) {
            return args;
        }
        if (range[0] >= 0) {
            args.add(Long.toString(range[0]));
        }
        if (range[1] >= 0) {
            args.add(Long.toString(range[1]));
        }
        return args;
    }

    private String getRangeSelection(long[] range, String value) {
        StringBuilder sb = new StringBuilder();
        if (range == null) {
            return sb.toString();
        }
        List<String> ss = new ArrayList<>();
        if (range[0] >= 0) {
            ss.add(String.format("%s>?", value));
        }
        if (range[1] >= 0) {
            ss.add(String.format("%s<?", value));
        }
        return StringUtils.join("and", ss);
    }

    public void test(final Callback callback) {
        mMainHandler.post(new Runnable() {
            @Override
            public void run() {
                callback.onSuccess(mImageList);
            }
        });
    }

}


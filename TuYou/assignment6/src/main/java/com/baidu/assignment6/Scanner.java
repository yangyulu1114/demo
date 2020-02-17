package com.baidu.assignment6;

import java.util.List;

public class Scanner {

    private boolean mScanning;

    public static interface Callback {
        void onSuccess(List<String> records);
    }

    public void scan(long timestamp, Callback callback) {
//        contentResolver.query();
//        callback.onca

    }
}

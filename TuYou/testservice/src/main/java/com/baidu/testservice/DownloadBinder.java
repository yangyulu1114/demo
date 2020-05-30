package com.baidu.testservice;

import android.os.Binder;
import android.util.Log;

public class DownloadBinder extends Binder {
    public void startDownload() {
        Log.d("bush", "startDownload executed");
    }

    public int getProgress() {
        Log.v("bush", "getProgress executed");
        return 0;
    }
}

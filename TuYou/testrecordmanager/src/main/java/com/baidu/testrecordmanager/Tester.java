package com.baidu.testrecordmanager;

import android.util.Log;

public class Tester {

    private static long startTime;

    public static synchronized void start() {
        startTime = System.currentTimeMillis();
    }

    public static synchronized void end(String tag) {
        Log.v("bush", String.format("%s takes %sms", tag, System.currentTimeMillis() - startTime));
        startTime = 0;
    }
}

package com.baidu.testhandler;

import java.util.Arrays;
import java.util.List;

public class Scanner {

    private static volatile boolean mFinished;
    private static List<Callback> sCallbacks;

    private static final Object mObject = new Object();

    public static void registerCallback(Callback callback) {
        sCallbacks.add(callback);
    }

    public static void waitUntilFinished() {
        synchronized (mObject) {
            while (!mFinished) {
                try {
                    mObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void scan() {
        new Thread("yulu") {
            @Override
            public void run() {
                doScan();
            }
        }.start();
    }

    private void doScan() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Callback callback : sCallbacks) {
            callback.onSuccess(Arrays.asList("one", "two"));
        }
        synchronized (mObject) {
            mObject.notifyAll();
        }
        mFinished = true;
    }
}

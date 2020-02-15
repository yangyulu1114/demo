package com.baidu.testhandler;

import java.util.Arrays;
import java.util.List;

public class Scanner {

    public void scan(final Callback callback) {
        new Thread("yulu") {
            @Override
            public void run() {
                doScan(callback);
            }
        }.start();
    }

    private void doScan(Callback callback) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        callback.onSuccess(Arrays.asList("one", "two"));
    }
}

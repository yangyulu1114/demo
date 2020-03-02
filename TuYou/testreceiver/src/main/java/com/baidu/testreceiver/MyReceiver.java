package com.baidu.testreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v("bush", "fuck " + intent.getAction());
        Log.v("bush", intent.getStringExtra("name"));
    }
}

package com.baidu.testsharepreference;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import java.util.Map;

public class SecondActivity extends Activity {
    private SharedPreferences mSharedPreference;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        mSharedPreference = getSharedPreferences("data", MODE_PRIVATE);
        show();
    }

    private void show() {
        Log.v("bush", "show preference");
        Map<String, ?> map = mSharedPreference.getAll();
        for(String key : map.keySet()) {
            Log.v("bush", String.format("Second Activity : %s is %s", key, map.get(key)));
        }
    }
}

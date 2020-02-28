package com.baidu.assignment10;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class BaseActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("bush", this.toString());
        Log.v("bush", "Task id is" + getTaskId());
    }
}

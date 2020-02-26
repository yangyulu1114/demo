package com.baidu.assignment9;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Intent intent = getIntent();
//        Log.v("bush", intent.getStringExtra("extra_string"));
//        Log.v("bush", "" + intent.getIntExtra("extra_int", 0));
//        Man man = (Man) intent.getSerializableExtra("extra_man");
//        Log.v("bush", man.toString());

        Student student = intent.getParcelableExtra("parcelable_test");
        Log.v("bush", student.toString());
    }
}

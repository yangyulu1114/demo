package com.baidu.testsharepreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.sql.Timestamp;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.OnSharedPreferenceChangeListener mListener;
    private int mCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button show = findViewById(R.id.show);
        Button add = findViewById(R.id.add);
        Button commit = findViewById(R.id.commit);
        Button apply = findViewById(R.id.apply);
        Button clear = findViewById(R.id.clear);
        Button unregister = findViewById(R.id.unregister);
        Button register = findViewById(R.id.register);
        Button delete = findViewById(R.id.delete);
        Button redirect = findViewById(R.id.redirect);

        mListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                Log.v("bush", String.format("onSharedPreferenceChanged key is %s, value is %s", key,
                        sharedPreferences.getString(key, "")));
            }
        };
        long start = System.currentTimeMillis();
        mSharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        Log.v("bush", "getSharedPreferences time : " + (System.currentTimeMillis() - start));

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 500; i++) {
                    mSharedPreferences.edit().putString(String.format("COUNT%d", i), String.format("%d", i)).commit();
                    //show();
                }
            }
        });
        commit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 1000000; i++) {
                    sb.append(i);
                }
                Long start = System.currentTimeMillis();
                mSharedPreferences.edit().putString("commit", sb.toString()).commit();
                Log.v("bush", "commit time : " + (System.currentTimeMillis() - start));
                android.os.Process.killProcess(android.os.Process.myPid());
                //show();
            }
        });

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 1000000; i++) {
                    sb.append(i);
                }
                Long start = System.currentTimeMillis();
                mSharedPreferences.edit().putString("apply", sb.toString()).apply();
                Log.v("bush", "apply time : " + (System.currentTimeMillis() - start));
                android.os.Process.killProcess(android.os.Process.myPid());
              //  show();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = mSharedPreferences.edit();
                editor.clear();
                editor.commit();
                show();
            }
        });

        unregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("bush", "unregister");
                mSharedPreferences.unregisterOnSharedPreferenceChangeListener(mListener);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("bush", "register");
                mSharedPreferences.registerOnSharedPreferenceChangeListener(mListener);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSharedPreferences.edit().remove("count").commit();
                show();
            }
        });

        redirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

    }

    private void show() {
        Log.v("bush", "show preference");
        Long start = System.currentTimeMillis();
        Map<String, ?> map = mSharedPreferences.getAll();
        Log.v("bush", "getall time : " + (System.currentTimeMillis() - start));
        for(String key : map.keySet()) {
            Log.v("bush", String.format("%s is %s", key, map.get(key)));
        }
    }

}

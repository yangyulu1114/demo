package com.baidu.testfile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputStream ins = getResources().openRawResource(R.raw.names);
        BufferedReader reader= null;
        List<String> list = new LinkedList<>();
        try {
            reader = new BufferedReader(new InputStreamReader(ins));
            String line = "";
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < list.size(); i++) {
            Log.v("bush", list.get(i));
        }
    }
}

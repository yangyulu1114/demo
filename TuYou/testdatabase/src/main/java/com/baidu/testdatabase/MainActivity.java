package com.baidu.testdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MyDataBaseHelper mDataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDataBaseHelper = new MyDataBaseHelper(this, "BookStore.db", null, 4);
        Button creatDatabase = findViewById(R.id.btn);
        creatDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDataBaseHelper.getWritableDatabase();
            }
        });
//        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mDataBaseHelper.getReadableDatabase();
//            }
//        });
    }
}

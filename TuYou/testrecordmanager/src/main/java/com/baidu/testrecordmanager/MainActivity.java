package com.baidu.testrecordmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecordManagerImplements mRecordManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            mRecordManager = new RecordManagerImplements(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        findViewById(R.id.refresh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRecordManager.loadAllRecords();
            }
        });
        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Record> list = new ArrayList<>();
                for(int i = 1; i <1000 ; i++) {
                    Record record = new Record();
                    record.setId(i + "");
                    record.setName("hello");
                    record.setType("jpg");
                    record.setAge(i);
                    list.add(record);
                }
                long timestamp1 = System.currentTimeMillis();
                Log.v("bush", "start time" + timestamp1);
                for (Record r : list) {
                    mRecordManager.offerRecord(r);
                }
                long timestamp2 = System.currentTimeMillis();
                Log.v("bush", "time taken for add" + (timestamp2 - timestamp1));
            }
        });

        findViewById(R.id.update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Record record4 = new Record();
                record4.setId("500");
                record4.setName("def");
                record4.setType("ppt");
                record4.setAge(18);
                long timestamp1 = System.currentTimeMillis();
                Log.v("bush", "start time" + timestamp1);
                mRecordManager.offerRecord(record4);
                long timestamp2 = System.currentTimeMillis();
                Log.v("bush", "time taken for update" + (timestamp2 - timestamp1));
            }
        });

        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Record record = new Record();
                record.setId("980");
                record.setName("hello");
                record.setType("jpg");
                record.setAge(12);
                long timestamp1 = System.currentTimeMillis();
                Log.v("bush", "start time" + timestamp1);
                mRecordManager.removeRecord(record);
                long timestamp2 = System.currentTimeMillis();
                Log.v("bush", "time taken for delete" + (timestamp2 - timestamp1));
            }
        });
    }
}

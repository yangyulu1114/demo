package com.baidu.testrecordmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecordManagerImplements mRecordManager;

    private int mID=10001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            mRecordManager = new RecordManagerImplements(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        findViewById(R.id.init).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 1; i <= 10000; i++) {
                    Record record = new Record();
                    record.setKey(i + "");
                    record.setName("hello");
                    record.setType("jpg");
                    record.setAge(i);
                    mID++;
                    mRecordManager.offerRecord(record);
                }
            }
        });

        findViewById(R.id.refresh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRecordManager.loadAllRecords(new CallBack<List<Record>>() {
                    @Override
                    public void getRecords(List<Record> records) {
                        Log.v("bush", String.format("record size = %s", records.size()));
                        for (Record record : records) {
                            Log.v("bush", String.format(">>> %s", record.toString()));
                        }
                    }
                });
            }
        });
        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Record record = new Record();
                int id = ++mID;
                record.setKey(id + "");
                record.setName("hello");
                record.setType("jpg");
                record.setAge(0);
                mRecordManager.offerRecord(record);
            }
        });

        findViewById(R.id.update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Record record4 = new Record();
                record4.setKey("500");
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
                record.setKey("980");
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

        findViewById(R.id.search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRecordManager.getRecord("1000", new CallBack<Record>() {
                    @Override
                    public void getRecords(Record records) {
                        Log.v("bush", String.format("id is %s, name is %s, type is %s, age is %d",
                                records.getKey(), records.getName(), records.getType(), records.getAge()));
                    }
                });
            }
        });

        findViewById(R.id.clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRecordManager.clearAll();
            }
        });
    }
}

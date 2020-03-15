package com.baidu.testdatabase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MyDataBaseHelper mDataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDataBaseHelper = new MyDataBaseHelper(this, "BookStore.db", null, 6);
        Button creatDatabase = findViewById(R.id.btn);
        creatDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDataBaseHelper.getWritableDatabase();
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = mDataBaseHelper.getReadableDatabase();
                ContentValues values = new ContentValues();

                values.put("name", "The Da Vinci Code");
                values.put("author", "Dan Brown");
                values.put("pages", 454);
                values.put("price", 16.96);
                long f = db.insert("BOOK", null, values);
                Log.v("bush", f + "");

                values.clear();

                values.put("name", "The Lost Symbol");
                values.put("author", "Dan Brown");
                values.put("pages", 510);
                values.put("price", 19.95);
                f = db.insert("BOOK", null, values);
                Log.v("bush", f + "");
            }
        });

        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = mDataBaseHelper.getReadableDatabase();
                ContentValues values = new ContentValues();

                values.put("price", 14.55);
                db.update("BOOK", values, "name = ?", new String[]{"The Da Vinci Code"});
            }
        });

        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = mDataBaseHelper.getReadableDatabase();
                db.delete("BOOK", "pages > ?", new String[]{"500"});
            }
        });

        findViewById(R.id.btn5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = mDataBaseHelper.getReadableDatabase();
                Cursor cursor = db.query("BOOK", null, null, null, null, null, null);
                if (cursor.moveToFirst()) {
                    do {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.v("bush", String.format("name is %s, author is %s, pages is %d, price is %f", name, author, pages, price));
                    }while (cursor.moveToNext());
                }
                cursor.close();
            }
        });
    }
}

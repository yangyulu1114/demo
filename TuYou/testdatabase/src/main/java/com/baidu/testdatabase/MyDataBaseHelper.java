package com.baidu.testdatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDataBaseHelper extends SQLiteOpenHelper {
    private Context mContext;

    private static final String CREATE_BOOK = "create table BOOK ("
            + "id integer primary key autoincrement, "
            + "author text, "
            + "price real, "
            + "pages integer, "
            + "name text)";
    private static final String CREATE_CATEGORY = "create table CATEGORY ("
            + "id integer primary key autoincrement, "
            + "category_name text, "
            + "category_code integer)";

    private static final String CREATE_LIBRARY = "create table LIBRARY ("
            + "id integer primary key autoincrement, "
            + "books real)";

    public MyDataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_CATEGORY);
        db.execSQL(CREATE_LIBRARY);
        Toast.makeText(mContext, "Create succeed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists BOOk");
        db.execSQL("drop table if exists CATEGORY");
        onCreate(db);
    }
}

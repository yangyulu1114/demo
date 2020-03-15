package com.baidu.testlitepal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connector.getDatabase();
            }
        });

        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setName("The Da Vinci Code");
                book.setAuthor("Dan Brown");
                book.setPages(454);
                book.setPrice(16.96);
                book.setPress("Unknown");
                book.save();
            }
        });

        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
//                book.setAuthor("Dan Brown");
//                book.setName("The Lost Symbol");
//                book.setPrice(19.95);
//                book.setPages(510);
//                book.setPress("Unknown");
//                book.save();
//                book.setPrice(10.99);
//                book.save();
//                book.setPrice(14.95);

//                book.setPress("Anchor");
//                book.updateAll("name = ? and author = ?", "The Da Vinci Code", "Dan Brown");

                book.setToDefault("pages");
                book.updateAll();
            }
        });

        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataSupport.deleteAll(Book.class, "price > ?", "14");
            }
        });

        findViewById(R.id.btn5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Book> list = DataSupport.findAll(Book.class);
                for (Book book : list) {
                    Log.v("bush", String.format("author is %s, name is %s, pages is %d, price is %f, press is %s",
                            book.getAuthor(), book.getName(), book.getPages(), book.getPrice(), book.getPress()));
                }
            }
        });
    }
}

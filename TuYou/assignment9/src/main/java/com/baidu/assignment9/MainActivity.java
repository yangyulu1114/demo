package com.baidu.assignment9;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity {

    private Button mButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton1 = findViewById(R.id.button1);
        setClickListener();
//        Intent intent = new Intent(this, SecondActivity.class);
//        intent.putExtra("extra_string", "hello");
//        intent.putExtra("extra_int", 1);
//        Man man = new Man();
//        man.setName("wentian");
//        man.setAge(31);
//        Woman woman = new Woman();
//        woman.setNike("yulu");
//        woman.setHeight(160);
//        man.setWoman(woman);
//        intent.putExtra("extra_man", man);
//        startActivity(intent);

//        File dir = getExternalFilesDir("test");
//        if (!dir.exists()) {
//            dir.mkdirs();
//        }
//        File file = new File(dir, "man.txt");
//        Log.v("bush", file.getAbsolutePath());
//        try {
//            ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(file));
//            ous.writeObject(man);
//            ous.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Man input_man = null;
//        try {
//            ObjectInputStream ins = new ObjectInputStream(new FileInputStream(file));
//            input_man = (Man) ins.readObject();
//            Log.v("bush", input_man.toString());
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        Log.v("bush", String.format("%b", man == input_man));
    }

    protected void setClickListener() {
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                Student student = new Student();
                student.setName("wentian");
                student.setScore(99);
                intent.putExtra("parcelable_test", student);
                startActivity(intent);
            }
        });
    }
}

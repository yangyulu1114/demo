package com.baidu.assignment10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }

    });
}

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("bush", " mainActivity onrestart");
    }
}

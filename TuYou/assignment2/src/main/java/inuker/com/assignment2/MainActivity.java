package inuker.com.assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.listviewlayout);
        ListView listView = findViewById(R.id.list_view);
        Button addButton = findViewById(R.id.add);
        Button deleteButton = findViewById(R.id.delete);

        final MyAdapter adapter = new MyAdapter(this);

        final List<Message> messages = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Message msg = new Message();
            msg.setMessage(String.format("message_%d", i));
            messages.add(msg);
        }
        adapter.setMessages(messages);

        listView.setAdapter(adapter);
        listView.setDividerHeight(0);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message msg = new Message();
                msg.setMessage(String.format("the new %d", count++));
                messages.add(0,msg);
                adapter.setMessages(messages);
                adapter.notifyDataSetChanged();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messages.remove(0);
                adapter.setMessages(messages);
                adapter.notifyDataSetChanged();
            }
        });

    }
}

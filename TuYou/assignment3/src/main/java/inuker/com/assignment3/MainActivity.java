package inuker.com.assignment3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridView mGridView;
    private String[] data = {"信用卡还款", "微粒贷借钱", "手机充值", "理财通", "生活缴费","Q币充值", "城市服务","腾讯公益","医疗健康"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();
    }

    protected void setContentView() {
        setContentView(R.layout.gridviewlayout);
        mGridView = findViewById(R.id.mgrid_view);
        MyItemAdapter adapter = new MyItemAdapter(this);
        List<Item> items = new LinkedList<>();
        for (int i = 0; i < data.length; i++) {
            Item item = new Item();
            item.setItem(data[i]);
            items.add(item);
        }
        adapter.setItems(items);
        mGridView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}

package inuker.com.assignment3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyItemAdapter extends BaseAdapter {

    private Context mContext;
    private List<Item> mItems;

    public MyItemAdapter(Context context) {
        mContext = context;
        mItems = new ArrayList<>();
    }

    public void setItems(List<Item> items) {
        mItems.clear();
        mItems.addAll(items);
    }
    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.gridviewitem, null);
        }
        TextView textView = convertView.findViewById(R.id.textitem);
        Item item = (Item) getItem(position);
        textView.setText(item.getItem());

        return convertView;
    }
}

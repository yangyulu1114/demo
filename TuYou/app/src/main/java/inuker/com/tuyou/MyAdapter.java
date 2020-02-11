package inuker.com.tuyou;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context mContext;
    private List<Message> mMessages;

    public MyAdapter(Context context) {
        mContext = context;
        mMessages = new ArrayList<>();
    }

    public void setMessages(List<Message> messages) {
        mMessages.clear();
        mMessages.addAll(messages);
    }

    @Override
    public int getCount() {
        return mMessages.size();
    }

    @Override
    public Object getItem(int position) {
        return mMessages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.message, null);
        }

        TextView textView = convertView.findViewById(R.id.text);

        Message message = mMessages.get(position);
        textView.setText(message.getMessage());
        return convertView;
    }
}

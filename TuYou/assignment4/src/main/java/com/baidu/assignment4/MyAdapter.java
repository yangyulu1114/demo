package com.baidu.assignment4;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class MyAdapter extends BaseAdapter {
    private List<ImageBean> mImageBeanList;
    private Context mContext;

    public MyAdapter(Context mContext) {
        mImageBeanList = new LinkedList<>();
        this.mContext = mContext;
    }

    public void setImageList (List<ImageBean> imageList) {
        mImageBeanList.clear();
        mImageBeanList.addAll(imageList);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mImageBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return mImageBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.listitem,null);
        }

        ImageBean image = (ImageBean) getItem(position);

        TextView textView = convertView.findViewById(R.id.textview);
        String text = "拍照时间：" + "\n" + image.getDateTakenString() + "\n\n" + "长 X 宽 ：" + "\n" + image.getWidth() + " X "
                +image.getHeight() + "\n\n" + "文件大小" + "\n" + image.getSizeString();
        textView.setText(text);

        SimpleDraweeView draweeView = (SimpleDraweeView) convertView.findViewById(R.id.my_image_view);
        Uri uri = Uri.fromFile(new File(image.getPath()));
        draweeView.setImageURI(uri);

//        TextView displayname = convertView.findViewById(R.id.displayname);
//        displayname.setText(image.getDisplayName());
//
//        TextView date = convertView.findViewById(R.id.dateadded);
//        date.setText(image.getDateAddedString());
//
//        TextView datetaken = convertView.findViewById(R.id.datetaken);
//        datetaken.setText(image.getDateTakenString());
//
//        TextView size = convertView.findViewById(R.id.size);
//        size.setText(image.getSizeString());
//
//        TextView width = convertView.findViewById(R.id.width);
//        width.setText(image.getWidth() + "");
//
//        TextView height = convertView.findViewById(R.id.height);
//        height.setText(image.getHeight() + "");
//
//        TextView path = convertView.findViewById(R.id.path);
//        path.setText(image.getPath());

        return convertView;
    }
}

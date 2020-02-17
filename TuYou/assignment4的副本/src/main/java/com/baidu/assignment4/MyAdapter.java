package com.baidu.assignment4;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class MyAdapter extends BaseAdapter {
    private List<ImageBean> mImageBeanList;
    private Context mContext;
//    private int mWidth;
//    private int mHeight;

    public MyAdapter(Context mContext) {
        mImageBeanList = new LinkedList<>();
        this.mContext = mContext;
//        mWidth = mContext.getResources().getDimensionPixelOffset(R.dimen.image_width);
//        mHeight = mContext.getResources().getDimensionPixelOffset(R.dimen.image_height);
    }

    public void setImageList(List<ImageBean> imageList) {
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.listitem, null);
        }

        MyListView listview_item = convertView.findViewById(R.id.my_listview_item);
        ImageBean image = (ImageBean) getItem(position);
        listview_item.setMyListView(image);


        return convertView;
    }

    private int dip2px(float dpValue) {

        final float scale = mContext.getResources().getDisplayMetrics().density;

        return (int) (dpValue * scale + 0.5f);

    }

}

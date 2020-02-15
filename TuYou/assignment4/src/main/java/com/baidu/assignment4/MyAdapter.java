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

//        TextView textView = convertView.findViewById(R.id.textview);
//        String text = "拍照时间：" + "\n" + image.getDateTakenString() + "\n\n" + "长 X 宽 ：" + "\n" + image.getWidth() + " X "
//                + image.getHeight() + "\n\n" + "文件大小" + "\n" + image.getSizeString();
//        textView.setText(text);
//
//        SimpleDraweeView draweeView = convertView.findViewById(R.id.my_image_view);
//        Uri uri = Uri.fromFile(new File(image.getPath()));
//
//        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri).setResizeOptions(new
//                ResizeOptions(mWidth, mHeight))
//                .build();
//
//        PipelineDraweeController controller = (PipelineDraweeController)
//                Fresco.newDraweeControllerBuilder()
//                        .setImageRequest(request)
//                        // other setters as you need
//                        .build();
//        draweeView.setController(controller);

//        draweeView.setImageURI(uri);

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

    private int dip2px(float dpValue) {

        final float scale = mContext.getResources().getDisplayMetrics().density;

        return (int) (dpValue * scale + 0.5f);

    }

}

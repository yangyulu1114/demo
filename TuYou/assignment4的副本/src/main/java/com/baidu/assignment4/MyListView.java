package com.baidu.assignment4;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.io.File;

public class MyListView extends LinearLayout {
    private int mWidth;
    private int mHeight;

    public MyListView(Context context) {
        this(context, null);
    }

    public MyListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.mylistview_item, this);
        mWidth = context.getResources().getDimensionPixelOffset(R.dimen.image_width);
        mHeight = context.getResources().getDimensionPixelOffset(R.dimen.image_height);
    }

    public void setMyListView(ImageBean bean) {
        TextView textView = findViewById(R.id.textview);
        String text = "拍照时间：" + "\n" + bean.getDateTakenString() + "\n\n" + "长 X 宽 ：" + "\n" + bean.getWidth() + " X "
                + bean.getHeight() + "\n\n" + "文件大小" + "\n" + bean.getSizeString();
        textView.setText(text);

        SimpleDraweeView draweeView = findViewById(R.id.my_image_view);
        Uri uri = Uri.fromFile(new File(bean.getPath()));

        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri).setResizeOptions(new
                ResizeOptions(mWidth, mHeight))
                .build();

        PipelineDraweeController controller = (PipelineDraweeController)
                Fresco.newDraweeControllerBuilder()
                        .setImageRequest(request)
                        // other setters as you need
                        .build();
        draweeView.setController(controller);
    }
}

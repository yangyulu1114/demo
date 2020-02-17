package com.baidu.assignment4;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class MyView extends FrameLayout {

    private GestureDetector mGestureDector;

    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        LayoutInflater.from(context).inflate(R.layout.custome_action_bar, this);

    }

    public void setGestureListener(GestureDetector.SimpleOnGestureListener listener) {
        mGestureDector = new GestureDetector(getContext(), listener);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mGestureDector.onTouchEvent(event);
    }
}

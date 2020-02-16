package com.baidu.assignment5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

public class MyView extends View {
    private int ORIGNAL = 0;
    private int START = 1;
    private int END = 2;

    private int mStatus;
    private int mCount;
    private Paint mPaint;

    public MyView(Context context) {
        this(context,null);
    }

    public MyView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mStatus == 0) {
            mPaint.setColor(Color.BLUE);
            mPaint.setStrokeWidth(dp2px(3));

            canvas.drawLine(0, 0, getWidth(), 0, mPaint);
            canvas.drawLine(0, 0, 0, getHeight(), mPaint);
            canvas.drawLine(getWidth(), 0, getWidth(), getHeight(), mPaint);
            canvas.drawLine(0, getHeight(), getWidth(), getHeight(), mPaint);

            int pixel = sp2px(15);
            mPaint.setTextSize(pixel);
            mPaint.setTextAlign(Paint.Align.CENTER);
            int xPos = (canvas.getWidth() / 2);
            int yPos = (int) ((canvas.getHeight() / 2) - ((mPaint.descent() + mPaint.ascent()) / 2));

            canvas.drawText("添加", xPos, yPos, mPaint);
        } else if (mStatus == START) {
            mPaint.setColor(Color.GREEN);
            mPaint.setStrokeWidth(dp2px(3));
            canvas.drawLine(0, 0, getWidth(), 0, mPaint);
            canvas.drawLine(0, 0, 0, getHeight(), mPaint);
            canvas.drawLine(getWidth(), 0, getWidth(), getHeight(), mPaint);
            canvas.drawLine(0, getHeight(), getWidth(), getHeight(), mPaint);
            canvas.drawRect(0, 0, (getWidth() * mCount / 100), getHeight(), mPaint);
            mPaint.setColor(Color.BLACK);
            int pixe2 = sp2px(15);
            mPaint.setTextSize(pixe2);
            mPaint.setTextAlign(Paint.Align.CENTER);
            int xPos = (canvas.getWidth() / 2);
            int yPos = (int) ((canvas.getHeight() / 2) - ((mPaint.descent() + mPaint.ascent()) / 2));

            String text = mCount + "%";
            canvas.drawText(text, xPos, yPos, mPaint);
        } else if (mStatus == END) {
            mPaint.setColor(Color.GRAY);
            mPaint.setStrokeWidth(dp2px(3));
            canvas.drawLine(0, 0, getWidth(), 0, mPaint);
            canvas.drawLine(0, 0, 0, getHeight(), mPaint);
            canvas.drawLine(getWidth(), 0, getWidth(), getHeight(), mPaint);
            canvas.drawLine(0, getHeight(), getWidth(), getHeight(), mPaint);
            int pixe3 = sp2px(15);
            mPaint.setTextSize(pixe3);
            mPaint.setTextAlign(Paint.Align.CENTER);
            int xPos = (canvas.getWidth() / 2);
            int yPos = (int) ((canvas.getHeight() / 2) - ((mPaint.descent() + mPaint.ascent()) / 2));
            canvas.drawText("已添加", xPos, yPos, mPaint);
        }

    }

    public void setStatus(int status, int count) {
        mStatus = status;
        mCount = count;
    }

    private int sp2px(int sp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                sp, getResources().getDisplayMetrics());
    }

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, getResources().getDisplayMetrics());
    }

}

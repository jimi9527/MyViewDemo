package com.example.myviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * author: daxiong9527
 * mail : 15570350453@163.com
 */
public class MyLoadingView extends View {

    Paint mPaint;
    long sTime;
    long oTime;
    boolean isDown;

    public MyLoadingView(Context context) {
        super(context);
    }

    public MyLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();

    }

    public MyLoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);
        Log.d("test", "isDown"+isDown);
        if (isDown) {
            mPaint.setColor(Color.RED);
            canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);
        }
        sTime = System.currentTimeMillis();
        mPaint.setTextSize(40);
        mPaint.setColor(Color.BLACK);
        canvas.drawText("loading...", getMeasuredWidth() / 2, getMeasuredHeight() / 2, mPaint);
    }

    //手指触摸屏幕
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("test", "i am down");
                 isDown = true ;
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("test", "i am move");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("test", "i am up");
                isDown = false ;
                invalidate();
                break;
        }
        return true;
    }

}

package com.example.myviewdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * author: daxiong9527
 * mail : 15570350453@163.com
 */
public class MyLoadingView extends View  {
    private static final int RECT_WIDTH = 60;    //每个矩形块的宽度
    private static final int RECT_DISTANCE = 40; //矩形块之间的间距
    private static final int TOTAL_PAINT_TIMES = 50; //控制绘制速度,分100次完成绘制


    Paint mPaint;
    private int mDownBackground;
    private int mUpBackground;
    private boolean isup;
    private boolean isdown ;

    //待绘制的矩形块矩阵，left为高度，right为颜色
    private static final int[][] RECT_ARRAY = {
            {180,Color.GRAY},
            {280,Color.YELLOW},
            {380,Color.GREEN},
            {480,Color.RED},
            {380,Color.BLUE},
            {280,Color.CYAN},
            {180,Color.BLACK}
    };
    private int mPaintComTimes = 0 ;
    private int mPaintTimes = 0;  //当前已经绘制的次数
    public MyLoadingView(Context context) {
        super(context);

    }

    public MyLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);


        TypedArray typedArray = context.getTheme().
                obtainStyledAttributes(attrs, R.styleable.MyLoadingView, 0, 0);
        try {
            mDownBackground = typedArray.getColor(R.styleable.MyLoadingView_down_background, mDownBackground);
            mUpBackground = typedArray.getColor(R.styleable.MyLoadingView_up_background, mUpBackground);
        } finally {
            typedArray.recycle();
        }

    }


    public MyLoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
       /*mPaint.setColor(Color.b);
       // canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);
       // Log.d("test", "isDown" + isDown);

        if (isDown) {
           // mPaint.setColor(mDownBackground);
            canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);
        }
        */

             mPaintTimes++;
             for (int i = 0; i < RECT_ARRAY.length; i++) {
                 mPaint.setColor(RECT_ARRAY[i][1]);
                 int paintXPos = i * (RECT_WIDTH + RECT_DISTANCE) + RECT_DISTANCE;
                 int paintYPos = RECT_ARRAY[i][0] / TOTAL_PAINT_TIMES;
                 Log.d("test", "getHeight() - paintYPos1:" + (getHeight() - paintYPos));
                 canvas.drawRect(paintXPos+getMeasuredWidth()/5, getMeasuredHeight() / 2- paintYPos, getMeasuredWidth()/5+paintXPos + RECT_WIDTH,getMeasuredHeight() / 2, mPaint);
             }
        mPaintComTimes  = mPaintTimes ;
        if( mPaintTimes < TOTAL_PAINT_TIMES ) {

            invalidate(); //实现动画的关键点
        }else{
            isup = true;
            Log.d("test1", "mPaintTimes:"+mPaintTimes);
            Log.d("test1", "mPaintComTimes1:"+mPaintComTimes);
            mPaintComTimes -- ;
            for( int i=0; i<RECT_ARRAY.length; i++ ) {

                mPaint.setColor(RECT_ARRAY[i][1]);
                int paintXPos = i*(RECT_WIDTH+RECT_DISTANCE) + RECT_DISTANCE;
                int paintYPos = RECT_ARRAY[i][0]/mPaintComTimes*TOTAL_PAINT_TIMES;
                Log.d("test", "getHeight() - paintYPos2:" + (getHeight() - paintYPos));
                canvas.drawRect(paintXPos+getMeasuredWidth()/5,getMeasuredHeight() / 2 - paintYPos, getMeasuredWidth()/5+paintXPos + RECT_WIDTH, getMeasuredHeight() / 2, mPaint);
            }
            Log.d("test1", "mPaintComTimes2:"+mPaintComTimes);
            if(mPaintComTimes < 100){
                invalidate();
            }else{
                mPaintTimes = 0 ;
                invalidate();
            }

        }


        mPaint.setTextSize(40);
        mPaint.setColor(Color.BLACK);
        canvas.drawText("loading...", getMeasuredWidth() / 2, getMeasuredHeight() / 2+30, mPaint);



    }

         /*
    //手指触摸屏幕
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("test", "i am down");
                isDown = true;
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("test", "i am move");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("test", "i am up");
                isDown = false;
                invalidate();
                break;
        }
        return true;
    }
    */

}

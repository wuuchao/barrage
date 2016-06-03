package com.swuuchao.www.barragewidget.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.swuuchao.www.barragewidget.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by swuuchao on 2016/6/1.
 */
public class Barrage extends View {

    private Paint mPaint;

    private List<BarrageItem> mBarrageItems = new ArrayList<>();

    public Barrage(Context context) {
        super(context);
        initPaint();
    }

    public Barrage(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public Barrage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    @TargetApi(21)
    public Barrage(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    int x = 100;

    /**
     * Implement this to do your drawing.
     *
     * @param canvas the canvas on which the background will be drawn
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (BarrageItem barrageItem : mBarrageItems) {
            mPaint.setColor(barrageItem.getColor());
            mPaint.setTextSize(barrageItem.getTextSize());
            canvas.drawText(barrageItem.getText(), barrageItem.getCurX(), barrageItem.getCurY(), mPaint);
            barrageItem.mCurX -= 1;
        }
        postInvalidateDelayed(10);
    }

    public void addBarrageItem(BarrageItem barrageItem) {
        mBarrageItems.add(barrageItem);
    }

    public static class BarrageItem {
        private int mCurX;
        private int mCurY;
        private String mText;
        private int mColor = 0xFFFFFFFF;
        private float mTextSize;

        public BarrageItem(Context context) {
            mTextSize = context.getResources().getDimension(R.dimen.barrage_item_size);
        }

        public int getCurX() {
            return mCurX;
        }

        public void setCurX(int curX) {
            mCurX = curX;
        }

        public int getCurY() {
            return mCurY;
        }

        public void setCurY(int curY) {
            mCurY = curY;
        }

        public String getText() {
            return mText;
        }

        public void setText(String text) {
            mText = text;
        }

        public int getColor() {
            return mColor;
        }

        public void setColor(int color) {
            mColor = color;
        }

        public float getTextSize() {
            return mTextSize;
        }

        public void setTextSize(float textSize) {
            mTextSize = textSize;
        }
    }
}

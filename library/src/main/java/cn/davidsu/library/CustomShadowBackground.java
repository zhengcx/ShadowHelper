package cn.davidsu.library;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;


/**
 * Created by cxzheng on 2018/4/29.
 * 自定义带阴影Drawable背景
 */

public class CustomShadowBackground extends Drawable {

    @ColorInt
    private int mColor;
    @ColorInt
    private int mShadowColor;
    @Nullable
    private int[] mGradientColorArray;
    @Nullable
    private float[] mGradientPositions;
    @Nullable
    private LinearGradient mLinearGradient;

    private int mRadius;
    private int mShadowRadius;

    private int mOffsetX;
    private int mOffsetY;

    @Nullable
    private RectF mRectF = new RectF();
    @Nullable
    private Paint mPaint;


    protected CustomShadowBackground(@ColorInt int color, @Nullable int[] colorArray, @Nullable float[] gradientPositions, @ColorInt int shadowColor, @Nullable LinearGradient linearGradient,
                                     int radius, int shadowRadius, int offsetX, int offsetY) {
        this.mColor = color;
        this.mGradientColorArray = colorArray;
        this.mGradientPositions = gradientPositions;
        this.mShadowColor = shadowColor;
        this.mLinearGradient = linearGradient;

        this.mRadius = radius;
        this.mShadowRadius = shadowRadius;

        this.mOffsetX = offsetX;
        this.mOffsetY = offsetY;

    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        mRectF.set(bounds.left + mShadowRadius - mOffsetX, bounds.top + mShadowRadius - mOffsetY, bounds.right - mShadowRadius - mOffsetX,
                bounds.bottom - mShadowRadius - mOffsetY);

        if (mPaint == null) {
            initPaint();
        }

        canvas.drawRoundRect(mRectF, mRadius, mRadius, mPaint);
    }

    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setShadowLayer(mShadowRadius, mOffsetX, mOffsetY, mShadowColor);

        if (mGradientColorArray != null && mGradientColorArray.length > 1) {
            boolean isGradientPositions = mGradientPositions != null && mGradientPositions.length > 0 && mGradientPositions.length == mGradientColorArray.length;

            mPaint.setShader(mLinearGradient == null ? new LinearGradient(mRectF.left, 0, mRectF.right, 0, mGradientColorArray,
                    isGradientPositions ? mGradientPositions : null, Shader.TileMode.CLAMP) : mLinearGradient);
        } else {

            mPaint.setColor(mColor);
        }
    }

}

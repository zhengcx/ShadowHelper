package cn.davidsu.library;

import android.graphics.LinearGradient;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;

/**
 * Created by cxzheng on 2018/4/29.
 * 阴影参数配置
 */

public class ShadowConfig {

    public static class Builder {
        //颜色
        @ColorInt
        private int mColor;
        //阴影颜色
        @ColorInt
        private int mShadowColor;
        //当需要渐变色时，可以传一个颜色数组进来，默认会从左到右渐进变色
        private int[] mGradientColorArray;
        //与上面的渐变色数组配合使用，指定每个颜色的位置（注意必须与上面的颜色数组length一样）
        @Nullable
        private float[] mGradientPositions;
        //如果从左到右渐进变色的需求无法满足你，可以自定义一个LinearGradient传进来
        private LinearGradient mLinearGradient;
        //圆角半径
        private int mRadius;
        private int mShadowRadius;
        //阴影偏移量
        private int mOffsetX = 0;
        private int mOffsetY = 0;


        public Builder() {
            //初始化默认值
            mColor = R.color.primary_material_dark;
            mShadowColor = R.color.primary_text_disabled_material_dark;
            mRadius = 10;
            mShadowRadius = 16;
            mOffsetX = 0;
            mOffsetY = 0;
        }


        public Builder setColor(@ColorInt int color) {
            this.mColor = color;
            return this;
        }

        public Builder setShadowColor(@ColorInt int shadowColor) {
            this.mShadowColor = shadowColor;
            return this;
        }

        public Builder setGradientColorArray(@Nullable int[] colorArray) {
            this.mGradientColorArray = colorArray;
            return this;
        }

        public Builder setGradientPositions(@Nullable float[] positions) {
            this.mGradientPositions = positions;
            return this;
        }

        public Builder setLinearGradient(@Nullable LinearGradient linearGradient) {
            this.mLinearGradient = linearGradient;
            return this;
        }

        public Builder setRadius(int radius) {
            this.mRadius = radius;
            return this;
        }

        public Builder setShadowRadius(int shadowRadius) {
            this.mShadowRadius = shadowRadius;
            return this;
        }

        public Builder setOffsetX(int offsetX) {
            this.mOffsetX = offsetX;
            return this;
        }

        public Builder setOffsetY(int offsetY) {
            this.mOffsetY = offsetY;
            return this;
        }


        public CustomShadowBackground builder() {
            return new CustomShadowBackground(mColor, mGradientColorArray, mGradientPositions, mShadowColor, mLinearGradient, mRadius, mShadowRadius, mOffsetX, mOffsetY);
        }
    }
}

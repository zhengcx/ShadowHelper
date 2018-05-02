package cn.davidsu.shadowhelper;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by cxzheng on 2018/4/29.
 */

public class Util {

    public static int dp2px(Context context, float dpValue) {
        return (int) getRawSize(context, 1, dpValue);
    }


    public static float getRawSize(Context context, int unit, float size) {
        return TypedValue.applyDimension(unit, size, context.getResources().getDisplayMetrics());
    }

    public static boolean emptyOrNull(String str) {
        return str == null || str.length() == 0;
    }
}

package cn.davidsu.library;

import android.support.v4.view.ViewCompat;
import android.view.View;


/**
 * Created by cxzheng on 2018/4/29.
 * 设置阴影入口工具方法
 */

public class ShadowHelper {

    public static void setShadowBgForView(View view, ShadowConfig.Builder config) {
        //关闭硬件加速
        view.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        ViewCompat.setBackground(view, config.builder());
    }
}

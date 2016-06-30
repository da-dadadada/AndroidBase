package com.lht.chuangyiyun.util;

import android.content.Context;
import android.util.TypedValue;

public class DisplayUtils {

    public static int convertDpToPx(Context context, float dp) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

}

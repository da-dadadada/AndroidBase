package com.lht.chuangyiyun.customview.zdepth.shadow;

import android.graphics.Canvas;

import com.lht.chuangyiyun.customview.zdepth.ZDepthParam;


public interface Shadow {
    public void setParameter(ZDepthParam parameter, int left, int top, int right, int bottom);
    public void onDraw(Canvas canvas);
}

package com.lht.androidbase.activity.asyncprotected;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;

import com.lht.androidbase.activity.BaseActivity;
import com.lht.androidbase.mvp.viewinterface.IActivityAsyncProtected;

public abstract class AsyncProtectedActivity extends BaseActivity implements IActivityAsyncProtected {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private boolean needDispatch = true;

    // 子类实现 public abstract ProgressBar getProgressBar();

    public void setActiveStateOfDispatchOnTouch(boolean b) {
        needDispatch = b;
    }

    public void showWaitView(boolean isProtectNeed) {
        getProgressBar().setVisibility(View.VISIBLE);
        getProgressBar().bringToFront();
        if (isProtectNeed)
            setActiveStateOfDispatchOnTouch(false);
    }

    /**
     * desc: TODO: 描述方法
     * 注意：如果仅progressBar显示需要拦截屏幕，可以这样做，否则需要进行判断或者设计多个flag共同作用
     */
    public void cancelWaitView() {
        getProgressBar().setVisibility(View.GONE);
        setActiveStateOfDispatchOnTouch(true);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (needDispatch)
            return super.dispatchTouchEvent(ev);
        else
            return false;
    }
}

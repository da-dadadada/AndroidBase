package com.lht.chuangyiyun.customview;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.lht.chuangyiyun.R;
import com.lht.chuangyiyun.interfaces.custompopupwins.IPopupHolder;
import com.lht.chuangyiyun.util.debug.DLog;

/**
 * @author leobert.lan
 * @version 1.0
 * @ClassName: CustomPopupWindow
 * @Description: TODO
 * @date 2016年3月1日 上午9:09:46
 */
public abstract class CustomPopupWindow extends PopupWindow {

    protected final Activity mActivity;

    protected final IPopupHolder iPopupHolder;

    public CustomPopupWindow(final IPopupHolder iPopupHolder) {
        this.iPopupHolder = iPopupHolder;
        mActivity = iPopupHolder.getHolderActivity();
        super.setOnDismissListener(new OnDismissListener() {

            @Override
            public void onDismiss() {
                if (iPopupHolder != null) {
                    iPopupHolder.setPenetrable(mActivity, false);
                }
            }
        });
        init();
    }

    public Activity getmActivity() {
        return mActivity;
    }


    abstract void init();

    protected void doDefaultSetting() {
        this.setHeight(LayoutParams.WRAP_CONTENT);
        this.setWidth(mActivity.getWindowManager().getDefaultDisplay()
                .getWidth() * 3 / 4 + 100);
        this.setFocusable(false);
        this.setOutsideTouchable(false);
        this.setAnimationStyle(R.style.AnimationPreview);
        this.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        ColorDrawable dw = new ColorDrawable(0xb0000000);
        this.setBackgroundDrawable(dw);
    }

    /**
     * @Title: setOutsideClickDismiss
     * @Description: 设置点击外部消失
     * @author: leobert.lan
     */
    public void setOutsideClickDismiss() {
        if (this.isShowing()) {
            DLog.e(getClass(), new DLog.LogLocation(), "该方法需要在显示前调用");
        } else {
            this.setFocusable(true);
            ColorDrawable dw = new ColorDrawable(0xb0000000);
            this.setBackgroundDrawable(dw);
        }
    }

    public IPopupHolder getiPopupHolder() {
        return iPopupHolder;
    }

    protected void backgroundAplha(float alpha) {
        WindowManager.LayoutParams lp = mActivity.getWindow().getAttributes();
        lp.alpha = alpha;
        mActivity.getWindow().setAttributes(lp);
    }

    public void show(View parent) {
        backgroundAplha(0.4f);
        if (!this.isShowing())
            this.showAtLocation(parent, defaultGravity, 0, 0);
        if (iPopupHolder != null) {
            iPopupHolder.setPenetrable(mActivity, true);
        }
    }

    private int defaultGravity = Gravity.CENTER;

    public void setGravity(int gravity) {
        this.defaultGravity = gravity;
    }

    @Override
    public void showAtLocation(View parent, int gravity, int x, int y) {
        iPopupHolder.setLatestPopupWindow(this);
        super.showAtLocation(parent, gravity, x, y);
    }

    @Override
    public void dismiss() {
        iPopupHolder.setLatestPopupWindow(null);
        backgroundAplha(1f);
        if (iPopupHolder != null) {
            iPopupHolder.setPenetrable(mActivity, false);
        }
        super.dismiss();
    }

    public void show() {
        show(mActivity.getWindow().getDecorView());
    }

    public interface OnPositiveClickListener {
        void onPositiveClick();
    }

    public interface OnNegativeClickListener {
        void onNegativeClick();
    }

}

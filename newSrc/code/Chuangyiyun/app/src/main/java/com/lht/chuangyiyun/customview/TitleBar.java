package com.lht.chuangyiyun.customview;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lht.chuangyiyun.R;
import com.lht.chuangyiyun.ThemeManager;
import com.lht.chuangyiyun.customview.zdepth.ZDepthShadowLayout;
import com.lht.chuangyiyun.util.DisplayUtils;

import java.lang.ref.WeakReference;


public class TitleBar extends ZDepthShadowLayout
        implements ThemeManager.IThemeListener {

    private Context context;
    private RelativeLayout mTitleBar;
    private ImageView mLeftView;
    private TextView mTitleText;

    public TitleBar(Context context) {
        super(context);
        this.context=context;
        init();
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        init();
    }

    private void init() {
        mTitleBar = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.topbar_layout, null);
        mLeftView = (ImageView) mTitleBar.findViewById(R.id.nav_back);
        mTitleText = (TextView) mTitleBar.findViewById(R.id.nav_title);
        float height = DisplayUtils.convertDpToPx(context, 56f);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int)height);
        addView(mTitleBar, params);

        mLeftView.setVisibility(INVISIBLE);
        mTitleBar.setBackgroundColor(ThemeManager.with(getContext()).getCurrentColor());

        ThemeManager.with(getContext()).registerListener(this);
    }

    public void setOnBackListener(final ITitleBackListener listener) {
        mLeftView.setVisibility(View.VISIBLE);
        if (listener != null) {
            mLeftView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onTitleBackClick();
                }
            });
        }
    }

    public void setDefaultOnBackListener(Activity activity) {
        setOnBackListener(new DefaultOnBackClickListener(activity));
    }

    public void setTitle(String text) {
        mTitleText.setText(text);
    }

    public void setTitle(int resId) {
        mTitleText.setText(getResources().getText(resId));
    }

    @Override
    public void onThemeChange(int color) {
        mTitleBar.setBackgroundColor(color);
    }

    public interface ITitleBackListener {
        void onTitleBackClick();
    }


    class DefaultOnBackClickListener implements  ITitleBackListener {
        private WeakReference<Activity> mActivity;
        DefaultOnBackClickListener(Activity activity) {
            mActivity = new WeakReference<Activity>(activity);
        }

        @Override
        public void onTitleBackClick() {
            if (mActivity.get() != null) {
                mActivity.get().finish();
            }
        }
    }
}

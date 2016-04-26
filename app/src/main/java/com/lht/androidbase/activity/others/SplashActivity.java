package com.lht.androidbase.activity.others;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.lht.androidbase.R;
import com.lht.androidbase.activity.UMengActivity;
import com.lht.androidbase.interfaces.keys.SPConstants;
import com.lht.androidbase.mvp.viewinterface.ISplashActivity;

public class SplashActivity extends UMengActivity implements ISplashActivity {

    private final static String PAGENAME = "SplashActivity";
    
    private SharedPreferences mPreferences = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected String getPageName() {
        return SplashActivity.PAGENAME;
    }

    @Override
    protected UMengActivity getActivity() {
        return SplashActivity.this;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initEvent() {

    }

    public SharedPreferences getPreferences() {
        if (mPreferences == null) {
            mPreferences = getSharedPreferences(SPConstants.Basic.SP_NAME, Activity.MODE_PRIVATE);
        }
        return mPreferences;
    }

    @Override
    public void jump2Main() {
        //TODO
    }

    @Override
    public void jump2Login() {
        //TODO
    }

    @Override
    public void jump2Guide() {
        //TODO
    }
}

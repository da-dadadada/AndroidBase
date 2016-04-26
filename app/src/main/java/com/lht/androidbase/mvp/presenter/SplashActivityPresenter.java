package com.lht.androidbase.mvp.presenter;

import android.os.Handler;

import com.lht.androidbase.interfaces.keys.SPConstants;
import com.lht.androidbase.mvp.viewinterface.ISplashActivity;
import com.lht.androidbase.util.SPUtil;


/**
 * @author
 * @version 1.0
 * @date 2016/4/25
 */
public class SplashActivityPresenter {

    private final ISplashActivity mSplashActivity;

    public SplashActivityPresenter(ISplashActivity iSplashActivity) {
        this.mSplashActivity = iSplashActivity;
    }

    public void startSplash(int duration) {
        int count = mSplashActivity.getPreferences().getInt(SPConstants.Basic.KEY_STARTCOUNT, 0);
        if (count == 0) {
            doGuide(duration);
        } else {
            doBackgroundLogin();
        }
        SPUtil.modifyInt(mSplashActivity.getPreferences(), SPConstants.Basic.KEY_STARTCOUNT, count++);
    }

    private void doBackgroundLogin() {
        //TODO
    }

    private void doGuide(int duration) {
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                mSplashActivity.jump2Guide();
            }
        }, duration);
    }
    

}

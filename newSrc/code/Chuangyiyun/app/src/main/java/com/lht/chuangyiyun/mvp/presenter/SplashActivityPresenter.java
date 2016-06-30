package com.lht.chuangyiyun.mvp.presenter;

import android.os.Handler;

import com.lht.chuangyiyun.interfaces.keys.SPConstants;
import com.lht.chuangyiyun.mvp.model.LoginModel;
import com.lht.chuangyiyun.mvp.model.bean.BaseBeanContainer;
import com.lht.chuangyiyun.mvp.viewinterface.ISplashActivity;
import com.lht.chuangyiyun.util.SPUtil;


/**
 * @author
 * @version 1.0
 * @date 2016/4/25
 */
public class SplashActivityPresenter {

    private final ISplashActivity mSplashActivity;

    private final LoginModel mLoginModel;

    public SplashActivityPresenter(ISplashActivity iSplashActivity) {
        this.mSplashActivity = iSplashActivity;
        mLoginModel = new LoginModel(new LoginCallbackImpl());
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

    class LoginCallbackImpl implements LoginModel.LoginModelCallback {

        @Override
        public void onSuccess(BaseBeanContainer beanContainer) {

        }

        @Override
        public void onHttpFailure(int httpStatus) {

        }
    }
    

}

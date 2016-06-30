package com.lht.chuangyiyun.mvp.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.lht.chuangyiyun.Event.AppEvent;
import com.lht.chuangyiyun.interfaces.IKeyManager;
import com.lht.chuangyiyun.interfaces.ITriggerCompare;
import com.lht.chuangyiyun.mvp.model.LoginModel;
import com.lht.chuangyiyun.mvp.model.bean.BaseBeanContainer;
import com.lht.chuangyiyun.mvp.model.pojo.VerifyInfo;
import com.lht.chuangyiyun.mvp.viewinterface.ILoginActivity;
import com.lht.chuangyiyun.test.TestLoginTrigger;
import com.lht.chuangyiyun.util.SPUtil;

import org.greenrobot.eventbus.EventBus;

/**
 * <p><b>Package</b> com.lht.chuangyiyun.mvp.presenter
 * <p><b>Project</b> Chuangyiyun
 * <p><b>Classname</b> LoginActivityPresenter
 * <p><b>Description</b>: TODO
 * Created by leobert on 2016/5/5.
 */
public class LoginActivityPresenter {

    private final ILoginActivity iLoginActivity;

    private final LoginModel mLoginModel;

    public LoginActivityPresenter(ILoginActivity iLoginActivity) {
        this.iLoginActivity = iLoginActivity;
        mLoginModel = new LoginModel(new LoginModelCallbackImpl());
    }

    public void callLogin(Context context,String usr,String pwd) {
        //TODO event key
        iLoginActivity.reportCountEvent("");
        mLoginModel.doLogin(context,usr,pwd);
    }

    class LoginModelCallbackImpl implements LoginModel.LoginModelCallback {

        @Override
        public void onSuccess(BaseBeanContainer beanContainer) {
            //TODO
            VerifyInfo info = new VerifyInfo();
            //TODO 对象转换
            info.setAccessId("test id");
            info.setAccessToken("test token");
            info.setUsername("test username");

            SharedPreferences sp = iLoginActivity.getTokenPreferences();
            SPUtil.modifyString(sp,IKeyManager.Token.KEY_ACCESS_ID,info.getAccessId());
            SPUtil.modifyString(sp,IKeyManager.Token.KEY_ACCESS_TOKEN,info.getAccessToken());
            SPUtil.modifyString(sp,IKeyManager.Token.KEY_USERNAME,info.getUsername());

            AppEvent.LoginSuccessEvent event = new AppEvent.LoginSuccessEvent(info);

            event.setTrigger((ITriggerCompare)iLoginActivity.getLoginTrigger());

            EventBus.getDefault().post(event);
            iLoginActivity.finishActivity();
        }

        @Override
        public void onHttpFailure(int httpStatus) {

        }
    }
}

package com.lht.chuangyiyun.mvp.presenter;

import android.content.SharedPreferences;

import com.lht.chuangyiyun.mvp.model.SendSmsModel;
import com.lht.chuangyiyun.mvp.model.TimerClockModel;
import com.lht.chuangyiyun.mvp.model.bean.BaseBeanContainer;

/**
 * <p><b>Package</b> com.lht.chuangyiyun.mvp.presenter
 * <p><b>Project</b> Chuangyiyun
 * <p><b>Classname</b> RegisterActivityPresenter
 * <p><b>Description</b>: TODO
 * Created by leobert on 2016/5/5.
 */
public class RegisterActivityPresenter implements TimerClockModel.ISharedPreferenceProvider {

    private final TimerClockModel mTimerClockModel;

    private final SendSmsModel<SendSmsModel.SmsRequestType> mSendSmsModel;

    public RegisterActivityPresenter() {
        mTimerClockModel = new TimerClockModel(this, new TimeLapseListenerImpl());
        mSendSmsModel = new SendSmsModel<>(SendSmsModel.SmsRequestType.Register, new SendSmsCallbackImpl());
    }

    public void callSendSmsVerifyCode(String targetPhone) {
        //TODO check phone num
    }

    public void resumeTimer() {
        mTimerClockModel.getTimeClock(1000).start();
    }

    @Override
    public SharedPreferences getSharedPreferences() {
        return null;
    }

    @Override
    public String getRecordTag() {
        return null;
    }

    private final static class TimeLapseListenerImpl implements TimerClockModel.OnTimeLapseListener {

        @Override
        public void onFinish() {

        }

        @Override
        public void onTick(long millisUntilFinished) {

        }
    }

    private final class SendSmsCallbackImpl implements SendSmsModel.SendSmsModelCallback {

        @Override
        public void onSuccess(BaseBeanContainer beanContainer) {
            //TODO
            mTimerClockModel.updateTimeStamp();
            mTimerClockModel.getTimeClock(1000).start();

        }

        @Override
        public void onHttpFailure(int httpStatus) {

        }
    }
}

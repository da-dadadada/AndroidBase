package com.lht.chuangyiyun.mvp.presenter;

import com.lht.chuangyiyun.mvp.viewinterface.ISettingActivity;

/**
 * <p><b>Package</b> com.lht.chuangyiyun.mvp.presenter
 * <p><b>Project</b> Chuangyiyun
 * <p><b>Classname</b> SettingActivityPresenter
 * <p><b>Description</b>: TODO
 * Created by leobert on 2016/5/11.
 */
public class SettingActivityPresenter {

    private final ISettingActivity iSettingActivity;

    public SettingActivityPresenter(ISettingActivity iSettingActivity) {
        this.iSettingActivity = iSettingActivity;
    }

    public void callBindPhone() {
        iSettingActivity.jump2BindPhone();
    }

    public void callCertify() {
        iSettingActivity.jump2Certification();
    }

    public void callResetPwd() {
        iSettingActivity.jump2ResetPwd();
    }

    public void callCheckUpdate() {

    }

    public void callCleanCache() {

    }

    public void callFeedback() {
        iSettingActivity.jump2Feedback();
    }

    public void callLogout() {

    }
}

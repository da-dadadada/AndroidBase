package com.lht.chuangyiyun.mvp.viewinterface;

import com.lht.chuangyiyun.interfaces.umeng.IUmengReport;

/**
 * <p><b>Package</b> com.lht.chuangyiyun.mvp.viewinterface
 * <p><b>Project</b> Chuangyiyun
 * <p><b>Classname</b> ISettingActivity
 * <p><b>Description</b>: TODO
 * Created by leobert on 2016/5/11.
 */
public interface ISettingActivity extends IActivityAsyncProtected {

    void jump2BindPhone();

    void jump2Certification();

    void jump2ResetPwd();

//    void jump2CheckUpdate(); //不一定使用

    void jump2Feedback();
}

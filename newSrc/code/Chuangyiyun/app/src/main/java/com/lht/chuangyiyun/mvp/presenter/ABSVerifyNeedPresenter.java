package com.lht.chuangyiyun.mvp.presenter;

import com.lht.chuangyiyun.interfaces.ITriggerCompare;

/**
 * <p><b>Package</b> com.lht.chuangyiyun.mvp.presenter
 * <p><b>Project</b> Chuangyiyun
 * <p><b>Classname</b> ABSVerifyNeedPresenter
 * <p><b>Description</b>: 该抽象类定义了登录相关的内容，为了简单起见，更新部分我原意是放在Activity、Fragment中
 * 直接做，若确实出现了设计上的需求，可以在此定义并进行继承
 * Created by leobert on 2016/5/5.
 */
public abstract class ABSVerifyNeedPresenter {

    /**
     * desc: 页面接收到订阅事件后，调用presenter#identifyTrigger，执行逻辑
     *
     * @param trigger an  interface to identify trigger,use equal(ITriggerCompare compare)
     */
    public abstract void identifyTrigger(ITriggerCompare trigger);

    /**
     * desc: check if login
     *
     * @return true while login,false otherwise
     */
    protected abstract boolean isLogin();

    /**
     * desc: update status,implement the method with an appropriate design
     *
     * @param isLogin
     */
    public abstract void setLoginStatus(boolean isLogin);
}

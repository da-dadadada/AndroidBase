package com.lht.chuangyiyun.mvp.viewinterface;

import android.content.SharedPreferences;

import com.lht.chuangyiyun.interfaces.umeng.IUmengReport;

/**
 * <p><b>Package</b> com.lht.chuangyiyun.mvp.viewinterface
 * <p><b>Project</b> Chuangyiyun
 * <p><b>Classname</b> ILoginActivity
 * <p><b>Description</b>: TODO
 * Created by leobert on 2016/5/5.
 */
public interface ILoginActivity extends IUmengReport{
    void jump2RegisterActivity();

    void jump2MainActivity();

    SharedPreferences getTokenPreferences();

    void finishActivity();

    Object getLoginTrigger();
}

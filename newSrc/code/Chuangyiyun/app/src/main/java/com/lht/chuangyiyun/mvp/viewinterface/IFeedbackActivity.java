package com.lht.chuangyiyun.mvp.viewinterface;

import android.net.Uri;

/**
 * <p><b>Package</b> com.lht.chuangyiyun.mvp.viewinterface
 * <p><b>Project</b> Chuangyiyun
 * <p><b>Classname</b> IFeedbackAcitivty
 * <p><b>Description</b>: TODO
 * Created by leobert on 2016/5/11.
 */
public interface IFeedbackActivity extends IActivityAsyncProtected{
    void notifyOverLength();
    void addFeedbackImage(String path);
}

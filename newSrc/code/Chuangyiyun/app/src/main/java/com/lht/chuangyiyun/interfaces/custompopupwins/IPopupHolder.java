package com.lht.chuangyiyun.interfaces.custompopupwins;

import com.lht.chuangyiyun.activity.UMengActivity;
import com.lht.chuangyiyun.customview.CustomPopupWindow;

/**
 * <p><b>Package</b> com.lht.chuangyiyun.interfaces.custompopupwins
 * <p><b>Project</b> Chuangyiyun
 * <p><b>Classname</b> IPopupHolder
 * <p><b>Description</b>: TODO
 * Created by leobert on 2016/5/11.
 */
public interface IPopupHolder extends IPenetrateController{
    UMengActivity getHolderActivity();

    void setLatestPopupWindow(CustomPopupWindow latestPopupWindow);
}

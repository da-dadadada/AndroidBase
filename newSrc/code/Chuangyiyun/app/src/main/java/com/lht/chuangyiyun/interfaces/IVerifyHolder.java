package com.lht.chuangyiyun.interfaces;

import com.lht.chuangyiyun.Event.AppEvent;
import com.lht.chuangyiyun.mvp.model.pojo.VerifyInfo;

import org.greenrobot.eventbus.Subscribe;

/**
 * <p><b>Package</b> com.lht.chuangyiyun.interfaces
 * <p><b>Project</b> Chuangyiyun
 * <p><b>Classname</b> IVerifyHolder
 * <p><b>Description</b>: 注册订阅者规范接口，注意：不要覆盖对象。
 * Created by leobert on 2016/5/5.
 */
public interface IVerifyHolder {
    VerifyInfo mVerifyInfo = new VerifyInfo();

    /**
     * desc: 主线程回调登录成功
     * 需要处理：成员对象的更新、界面的更新
     *
     * @param event 登录成功事件，包含信息
     */
    @Subscribe
    void onEventMainThread(AppEvent.LoginSuccessEvent event);

    VerifyInfo getVerifyInfo();

    void updateVerifyInfo(String username, String accessId, String accessToken);

}

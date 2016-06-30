package com.lht.chuangyiyun.Event;

import com.lht.chuangyiyun.interfaces.ITriggerCompare;
import com.lht.chuangyiyun.mvp.model.pojo.VerifyInfo;

/**
 * <p><b>Package</b> com.lht.chuangyiyun.Event
 * <p><b>Project</b> Chuangyiyun
 * <p><b>Classname</b> AppEvent
 * <p><b>Description</b>: 使用静态内部类管理所有的event事件
 * 本次项目中，eventbus仅用做回调的补充，在不便于使用回调的情况下使用eventbus
 * Created by leobert on 2016/5/5.
 */
public class AppEvent {

    public static class TriggerHolderEvent<T extends ITriggerCompare> {
        protected T trigger;

        public T getTrigger() {
            return trigger;
        }

        public void setTrigger(T trigger) {
            this.trigger = trigger;
        }
    }

    /**
     * 登录成功事件
     */
    public static class LoginSuccessEvent extends TriggerHolderEvent {
        private VerifyInfo verifyInfo;

        public LoginSuccessEvent(VerifyInfo verifyInfo) {
            this.verifyInfo = verifyInfo;
        }

        public VerifyInfo getVerifyInfo() {
            return verifyInfo;
        }
    }

    public static class CaptureSuccessEvent extends TriggerHolderEvent {
        private String path;

        private boolean isSuccess = false;

        public CaptureSuccessEvent(String path, boolean isSuccess) {
            this.path = path;
            this.isSuccess = isSuccess;
        }

        public String getPath() {
            return path;
        }

        public boolean isSuccess() {
            return isSuccess;
        }
    }


}

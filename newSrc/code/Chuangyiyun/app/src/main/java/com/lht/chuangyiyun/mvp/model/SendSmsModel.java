package com.lht.chuangyiyun.mvp.model;

import android.content.Context;

import com.lht.chuangyiyun.interfaces.net.ICancelRequest;
import com.lht.chuangyiyun.mvp.model.bean.BaseBeanContainer;
import com.lht.chuangyiyun.util.internet.HttpUtil;

/**
 * <p><b>Package</b> com.lht.chuangyiyun.mvp.model
 * <p><b>Project</b> Chuangyiyun
 * <p><b>Classname</b> SendSmsModel
 * <p><b>Description</b>: TODO 注意，可能有多种业务
 * Created by leobert on 2016/5/5.
 */
public class SendSmsModel<T extends SendSmsModel.SmsRequestType> implements ISendSms{

    private final T t;

    private final SendSmsModelCallback modelCallback;

    private final HttpUtil mHttpUtil;


    public SendSmsModel(T t,SendSmsModelCallback sendSmsModelCallback) {
        this.t = t;
        this.modelCallback = sendSmsModelCallback;
        mHttpUtil = HttpUtil.getInstance();
        if (t.getType() == SmsRequestType.Register.getType()) {
            //TODO 更新url
        }//...
    }

    @Override
    public void doSend(Context context, String target) {

        //TODO
    }

    @Override
    public void cancelRequestByContext(Context context) {

    }

    public enum SmsRequestType {
        Register(1), ResetPwd(2), BindPhone(3);
        private final int type;

        SmsRequestType(int type) {
            this.type = type;
        }

        public int getType() {
            return type;
        }
    }

    /**
     * 发送结果回调接口
     */
    public interface SendSmsModelCallback {
        void onSuccess(BaseBeanContainer beanContainer);

        void onHttpFailure(int httpStatus);
    }
}

/**
 *
 */
interface ISendSms extends ICancelRequest {
    //TODO 参数
    void doSend(Context context,String target);
}

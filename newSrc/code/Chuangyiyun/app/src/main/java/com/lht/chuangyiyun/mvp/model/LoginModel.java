package com.lht.chuangyiyun.mvp.model;

import android.content.Context;
import android.util.Log;

import com.lht.chuangyiyun.interfaces.net.ICancelRequest;
import com.lht.chuangyiyun.interfaces.net.IRestfulApi;
import com.lht.chuangyiyun.mvp.model.bean.BaseBeanContainer;
import com.lht.chuangyiyun.util.internet.HttpUtil;

/**
 * <p><b>Package</b> com.lht.chuangyiyun.mvp.model
 * <p><b>Project</b> Chuangyiyun
 * <p><b>Classname</b> LoginModel
 * <p><b>Description</b>: TODO
 * Created by leobert on 2016/5/4.
 */
public class LoginModel implements ILogin {

    private final LoginModelCallback modelCallback;

    private final HttpUtil mHttpUtil;

    public LoginModel(LoginModelCallback loginModelCallback) {
        this.modelCallback = loginModelCallback;
        mHttpUtil = HttpUtil.getInstance();
    }

    @Override
    public void doLogin(Context context,String usr,String pwd) {
        //TODO dummy
        IRestfulApi.LoginApi api = new IRestfulApi.LoginApi();
        String url = api.formatUrl(null);
        Log.e("lmsg",url);
        this.modelCallback.onSuccess(new BaseBeanContainer());
    }

    @Override
    public void cancelRequestByContext(Context context) {
        mHttpUtil.getClient().cancelRequests(context,true);
    }

    public interface LoginModelCallback {
        void onSuccess(BaseBeanContainer beanContainer);

        void onHttpFailure(int httpStatus);
    }
}

/**
 *
 */
interface ILogin extends ICancelRequest {
    //TODO 参数
    void doLogin(Context context,String usr,String pwd);
}

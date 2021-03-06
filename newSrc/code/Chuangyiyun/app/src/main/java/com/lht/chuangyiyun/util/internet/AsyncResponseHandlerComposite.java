package com.lht.chuangyiyun.util.internet;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;

import java.util.ArrayList;

/**
 * <p><b>Package</b> com.lht.chuangyiyun.util.internet
 * <p><b>Project</b> Chuangyiyun
 * <p><b>Classname</b> AsyncResponseHandlerComposite
 * <p><b>Description</b>: TODO
 * Created by leobert on 2016/6/20.
 */
public class AsyncResponseHandlerComposite extends AsyncHttpResponseHandler {

    private ArrayList<AsyncHttpResponseHandler> handlers = new ArrayList<>();

    private BasicApiResponseHandler basicApiResponseHandler;

    public AsyncResponseHandlerComposite(String url,RequestParams params) {
        basicApiResponseHandler = new BasicApiResponseHandler(url,params);
        addHandler(basicApiResponseHandler);
    }

    public void setBasicToastable(boolean toastable) {
        basicApiResponseHandler.setNeedToast(toastable);
    }

    public boolean addHandler(AsyncHttpResponseHandler handler) {
        return handlers.add(handler);
    }


    public boolean removeHanlder(AsyncHttpResponseHandler handler) {
        return handlers.remove(handler);
    }

    @Override
    public void onSuccess(int i, Header[] headers, byte[] bytes) {
        for (AsyncHttpResponseHandler handler :handlers) {
            if (handler == null)
                continue;
            handler.onSuccess(i,headers,bytes);
        }
    }

    @Override
    public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
        for (AsyncHttpResponseHandler handler :handlers) {
            if (handler == null)
                continue;
            handler.onFailure(i,headers,bytes,throwable);
        }
    }
}

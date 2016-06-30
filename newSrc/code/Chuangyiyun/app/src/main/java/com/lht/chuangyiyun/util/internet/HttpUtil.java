package com.lht.chuangyiyun.util.internet;

import android.content.Context;
import android.os.Looper;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.BinaryHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.SyncHttpClient;

import org.apache.http.HttpEntity;

public class HttpUtil {
    private AsyncHttpClient syncHttpClient = new SyncHttpClient();
    private AsyncHttpClient asyncHttpClient = new AsyncHttpClient();

    private static HttpUtil mHttpUtil;
    private HttpUtil() {
        this.getClient().setTimeout(10000);
    }

    public static HttpUtil getInstance() {
        if (mHttpUtil == null) {
            mHttpUtil = new HttpUtil();
        }
        return mHttpUtil;
    }

    public RequestHandle getWithoutParams(Context mContext, String urlString,
                                          AsyncHttpResponseHandler res) {

        return getClient().get(mContext, urlString, res);
    }

    public RequestHandle getWithParams(Context mContext, String urlString,
                                       RequestParams params, AsyncHttpResponseHandler res) {
        return getClient().get(mContext, urlString, params, res);
    }

    public RequestHandle getWithParams(String urlString, RequestParams params,
                                       AsyncHttpResponseHandler res) {
        return getClient().get(urlString, params, res);
    }

    public RequestHandle postWithEntity(Context context, String urlString,
                                        HttpEntity entity, String contentType, AsyncHttpResponseHandler res) {
        return getClient().post(context, urlString, entity, contentType, res);
    }

    public RequestHandle getWithParams(Context mContext, String tag, String urlString,
                              RequestParams params, AsyncHttpResponseHandler res) {
       return getClient().get(mContext, urlString, params, res).setTag(tag);
    }

    public RequestHandle get(String uString, BinaryHttpResponseHandler bHandler) {
       return  getClient().get(uString, bHandler);
    }

    public RequestHandle get(String url,
                    AsyncHttpResponseHandler asyncHttpResponseHandler) {
       return getClient().get(url, asyncHttpResponseHandler);

    }

    public RequestHandle postWithoutParams(String urlString, AsyncHttpResponseHandler res) {
       return getClient().post(urlString, res);
    }

    public RequestHandle postWithParams(Context mContext, String urlString,
                               RequestParams params, AsyncHttpResponseHandler res) {
       return getClient().post(mContext, urlString, params, res);
    }

    public RequestHandle postWithParams(Context mContext, String tag, String urlString,
                               RequestParams params, AsyncHttpResponseHandler res) {
       return getClient().post(mContext, urlString, params, res).setTag(tag);
    }

    public RequestHandle postWithParams(Context mContext, String url, HttpEntity entity,
                               String contentType, AsyncHttpResponseHandler res) {
       return  getClient().post(mContext, url, entity, contentType, res);
    }

    public AsyncHttpClient getClient() {
        if (Looper.myLooper() == null)
            return syncHttpClient;
        return asyncHttpClient;
    }


    public void delete(Context mContext, String url, HttpEntity entity,
                       String contentType, AsyncHttpResponseHandler res) {
        getClient().delete(mContext, url, entity, contentType, res);
    }

    public void onAppTerminate() {
       getClient().cancelAllRequests(true);
    }

}

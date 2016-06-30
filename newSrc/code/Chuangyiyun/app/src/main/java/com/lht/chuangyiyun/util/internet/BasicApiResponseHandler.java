package com.lht.chuangyiyun.util.internet;

import com.lht.chuangyiyun.MainApplication;
import com.lht.chuangyiyun.util.debug.DLog;
import com.lht.chuangyiyun.util.toast.ToastUtils;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;

import java.util.Locale;

/**
 * <p><b>Package</b> com.lht.chuangyiyun.util.internet
 * <p><b>Project</b> Chuangyiyun
 * <p><b>Classname</b> BasicApiResponseHandler
 * <p><b>Description</b>: TODO
 * Created by leobert on 2016/6/20.
 */
public class BasicApiResponseHandler extends AsyncHttpResponseHandler {

    private boolean needToast;

    private final String url;

    private final RequestParams params;


    public BasicApiResponseHandler(String url, RequestParams params) {
        this(url, params, false);
    }


    public BasicApiResponseHandler(String url, RequestParams params, boolean needToast) {
        this.url = url;
        this.params = params;
        this.needToast = needToast;
    }

    public void setNeedToast(boolean needToast) {
        this.needToast = needToast;
    }

    public boolean isNeedToast() {
        return needToast;
    }

    @Override
    public void onSuccess(int i, Header[] headers, byte[] bytes) {

    }

    @Override
    public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
        DLog.e(BasicApiResponseHandler.class, "api request failure:\r\n"
                + url + "\r\n status:" + i
                + "\r\ncheck params:\r\n" + getReqParamsString()
                + "\r\ncheck headers:\r\n" + debugHeaders(getRequestHeaders())
                + "\r\n check response header:\r\n" + debugHeaders(headers));

        if (needToast) {
            toastFailureByCode(i);
        }
    }

    private String getReqParamsString() {
        if (params == null)
            return "params is null";
        return params.getParamString();
    }

    /**
     * @param headers
     * @return
     */
    private String debugHeaders(Header[] headers) {
        if (headers != null) {
            StringBuilder builder = new StringBuilder();
            builder.append("[++++++++++\r\n");
            for (Header h : headers) {
                String _h = String.format(Locale.US, "%s : %s", h.getName(), h.getValue());
                builder.append(_h);
                builder.append("\n");
            }
            builder.append("++++++++++]\r\n");
            return builder.toString();
        }
        return "null header";
    }

    private void toastFailureByCode(int requestCode) {
        ToastUtils.show(MainApplication.getOurInstance(), getFailure(requestCode), ToastUtils.Duration.l);
    }

    private int getFailure(int requestCode) {
        // better modify a set of failure code named by its means instead of int
        int rid = -1;
        switch (requestCode) {
            case 0:
//			rid = R.string.no_internet;
                break;
            case 401:
//			rid = R.string.token_overtime;
                break;
            case 404:
//			rid = R.string.not_found;
                break;
            default:
//			rid = R.string.other_error;
                break;
        }
        return rid;

    }

}

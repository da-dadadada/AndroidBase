package com.lht.chuangyiyun;

import android.app.Application;
import android.os.Environment;
import android.util.Log;

import com.lht.chuangyiyun.util.AppPreference;
import com.lht.jsbridge_lib.BridgeWebView;
import com.squareup.picasso.Picasso;

import java.io.File;

/**
 * @package com.lht.chuangyiyun
 * @project AndroidBase
 * @classname MainApplication
 * @description: TODO
 * Created by leobert on 2016/4/7.
 */
public class MainApplication extends Application {
    private static MainApplication ourInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        if (ourInstance == null) {
            ourInstance = this;
        }
        Picasso.setExtendDiskCacheFile(Environment.getExternalStorageDirectory());

        Log.e("lmsg", "debug mode:" + BuildConfig.DEBUG);
        BridgeWebView.MY_DEBUG = BuildConfig.DEBUG;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public AppPreference getAppPreference() {
        return AppPreference.getInstance(this);
    }

    public static MainApplication getOurInstance() {
        return ourInstance;
    }

}

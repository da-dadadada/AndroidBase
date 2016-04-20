package com.lht.androidbase;

import android.app.Application;

import com.lht.androidbase.util.AppPreference;
import com.lht.androidbase.util.msg.MsgBus;

/**
 * @package com.lht.androidbase
 * @project AndroidBase
 * @classname MainApplication
 * @description: TODO
 * Created by leobert on 2016/4/7.
 */
public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //...
    }

    @Override
    public void onTerminate() {
        //...
        MsgBus.destroy();
        super.onTerminate();
    }

    public AppPreference getAppPreference() {
        return AppPreference.getInstance(this);
    }

}

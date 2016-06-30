package com.lht.chuangyiyun.mvp.viewinterface;

import android.content.SharedPreferences;

/**
 * @author leobert.lan
 * @version 1.0
 * @date 2016/4/25
 */
public interface ISplashActivity {
    
    SharedPreferences getPreferences();
   
    void jump2Main();
    
    void jump2Login();
    
    void jump2Guide();
}

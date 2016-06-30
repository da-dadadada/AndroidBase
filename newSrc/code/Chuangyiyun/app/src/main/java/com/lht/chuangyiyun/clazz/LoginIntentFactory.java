package com.lht.chuangyiyun.clazz;

import android.content.Context;
import android.content.Intent;
import android.telephony.IccOpenLogicalChannelResponse;

import com.lht.chuangyiyun.activity.asyncprotected.LoginActivity;
import com.lht.chuangyiyun.interfaces.ITriggerCompare;

/**
 * <p><b>Package</b> com.lht.chuangyiyun.clazz
 * <p><b>Project</b> Chuangyiyun
 * <p><b>Classname</b> LoginIntentFactory
 * <p><b>Description</b>: TODO
 * Created by leobert on 2016/5/6.
 */
public class LoginIntentFactory {

    public static Intent create(Context context, ITriggerCompare iTriggerCompare) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra(LoginActivity.TRIGGERKEY,iTriggerCompare.getSerializable());
        return intent;
    }
}

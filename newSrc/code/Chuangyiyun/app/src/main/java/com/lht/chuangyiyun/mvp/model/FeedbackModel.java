package com.lht.chuangyiyun.mvp.model;

import android.content.Context;


import com.lht.chuangyiyun.interfaces.net.ICancelRequest;

import java.util.ArrayList;

/**
 * <p><b>Package</b> com.lht.chuangyiyun.mvp.model
 * <p><b>Project</b> Chuangyiyun
 * <p><b>Classname</b> FeedbackModel
 * <p><b>Description</b>: TODO
 * Created by leobert on 2016/5/11.
 */
public class FeedbackModel implements IFeedback{
    //TODO
    @Override
    public void doFeedback(String contact, String content, ArrayList<String> imagePaths) {

    }

    @Override
    public void cancelRequestByContext(Context context) {

    }
}
interface IFeedback extends ICancelRequest {
    void doFeedback(String contact,String content,ArrayList<String> imagePaths);
}

package com.lht.chuangyiyun.mvp.presenter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.widget.EditText;

import com.lht.chuangyiyun.Event.AppEvent;
import com.lht.chuangyiyun.activity.BaseActivity;
import com.lht.chuangyiyun.interfaces.ITriggerCompare;
import com.lht.chuangyiyun.interfaces.net.ICancelRequest;
import com.lht.chuangyiyun.mvp.model.ImageCopyModel;
import com.lht.chuangyiyun.mvp.model.ImageGetterModel;
import com.lht.chuangyiyun.mvp.model.TextWatcherModel;
import com.lht.chuangyiyun.mvp.viewinterface.IFeedbackActivity;

import java.io.File;
import java.io.Serializable;

/**
 * <p><b>Package</b> com.lht.chuangyiyun.mvp.presenter
 * <p><b>Project</b> Chuangyiyun
 * <p><b>Classname</b> FeedbackActivityPresenter
 * <p><b>Description</b>: TODO
 * Created by leobert on 2016/5/1.
 */
public class FeedbackActivityPresenter implements ICancelRequest {
    private final TextWatcherModel textWatcherModel;

    private final IFeedbackActivity iFeedbackActivity;

    public static final int INTENT_CODE_CAPTURE = 1;

    public static final int INTENT_CODE_ALBUM = 2;

    private final ImageGetterModel imageGetterModel;

    private final ImageCopyModel imageCopyModel;

    public FeedbackActivityPresenter(IFeedbackActivity iFeedbackActivity) {
        this.iFeedbackActivity = iFeedbackActivity;
        textWatcherModel = new TextWatcherModel(new TextWatcherModelCallbackImpl());
        imageGetterModel = new ImageGetterModel();
        imageCopyModel = new ImageCopyModel();
    }

    public void watchInputLength(EditText editText, int maxLength) {
        textWatcherModel.doWatcher(editText, maxLength);
    }

    public void callCaptureForImage(Activity activity) {
        Uri mImageUri = getTempUri();
        imageGetterModel.startCapture(activity, INTENT_CODE_CAPTURE, mImageUri);
    }

    public void callAlbumForImage(Activity activity) {
        imageGetterModel.startSelect(activity, INTENT_CODE_ALBUM);
    }

    @Override
    public void cancelRequestByContext(Context context) {
        //TODO
    }

    public void callTransCapture() {
        File f1 = new File(getTempUri().getPath());
        String filename = ImageGetterModel.NameUtils.generateName("30259692","feedback").replaceAll("\r|\n","");
        File f2 = new File(BaseActivity.getLocalImageCachePath()+"/"+filename);
        imageCopyModel.doCopy(f1,f2,CaptureTrigger.Capture);
    }

    public void callResolveEvent(AppEvent.CaptureSuccessEvent event) {
        if (event.getTrigger().equals(CaptureTrigger.Capture)) {
            if(event.isSuccess()) {
                iFeedbackActivity.addFeedbackImage(event.getPath());
            } else {
                Log.d("lmsg","failure");
            }
        } else {
            Log.d("lmsg","not match");
        }
    }

    private class TextWatcherModelCallbackImpl implements TextWatcherModel.TextWatcherModelCallback {

        @Override
        public void onOverLength(int edittextId, int maxLength) {
            iFeedbackActivity.notifyOverLength();
        }

        @Override
        public void onChanged(int edittextId, int currentCount, int remains) {

        }
    }

    public Uri getTempUri() {
        return Uri.fromFile(new File(BaseActivity.getLocalImageCachePath(),"temp.jpg"));
    }

    public enum CaptureTrigger implements ITriggerCompare {
        Capture(1);
        private final int tag;
        CaptureTrigger(int i ) {
            tag= i;
        }

        @Override
        public boolean equals(ITriggerCompare compare) {
            boolean b1 = compare.getClass().getName().equals(getClass().getName());
            boolean b2 = compare.getTag().equals(getTag());
            return b1&b2;
        }

        @Override
        public Object getTag() {
            return tag;
        }

        @Override
        public Serializable getSerializable() {
            return this;
        }
    }

}

package com.lht.chuangyiyun.mvp.model;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;

import com.lht.chuangyiyun.util.Base64Utils;

/**
 * <p><b>Package</b> com.lht.chuangyiyun.mvp.model
 * <p><b>Project</b> Chuangyiyun
 * <p><b>Classname</b> ImageGetterModel
 * <p><b>Description</b>: TODO
 * Created by leobert on 2016/5/12.
 */
public class ImageGetterModel implements IImageGetter {
    @Override
    public void startSelect(Activity activity, int uniqueCode) {
        activity.startActivityForResult(newImgSelectIntent(),uniqueCode);
    }

    @Override
    public void startCapture(Activity activity, int uniqueCode, Uri destFileUri) {
        activity.startActivityForResult(newCaptureIntent(destFileUri), uniqueCode);
    }

    private Intent newCaptureIntent(Uri destFileUri) {
        Intent captureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        captureIntent.putExtra(MediaStore.EXTRA_OUTPUT, destFileUri);
        return captureIntent;
    }

    private Intent newImgSelectIntent() {
        Intent openAlbumIntent = new Intent(Intent.ACTION_GET_CONTENT);
        openAlbumIntent.setType("image/*");
        return openAlbumIntent;

    }

    /**
     * 生成一个规范的命名，base64[attempt_username_time].jpg
     */
    public static final class NameUtils{
        public static String generateName(String username,String attempt) {
            String temp = attempt+"_"+username+"_"+System.currentTimeMillis();
            String name = Base64Utils.GetBASE64(temp);
            return name+".jpg";
        }
    }

}

interface IImageGetter {
    void startSelect(Activity activity, int uniqueCode);

    void startCapture(Activity activity, int uniqueCode, Uri destFileUri);
}

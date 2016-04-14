package com.lht.androidbase.activity;

import java.io.File;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;

public abstract class BaseActivity extends UMengActivity {

    public static boolean onWifi = false;

    public static boolean isConnected = false;

    public static String thumbnailPath;

    public static String previewPath;

    public static boolean isOnlyOnWifi = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        createIndividualFolder();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


    @Override
    protected void onResume() {
        createIndividualFolder();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private String SDCARD_ROOT = null;

    static String localImageCache;

    private static File destDir = null;

    /**
     * @Title: createIndividualFolder
     * @Description: 创建个人文件夹
     * @author: leobert.lan
     */
    private void createIndividualFolder() {
        if (!isSdCardMounted()) {
//			ToastUtil.show(this, R.string.sdcard_not_mounted, Duration.l);
            return;
        }

//		SDCARD_ROOT = Environment.getExternalStorageDirectory().getPath();
//
//		String username = getSharedPreferences(IKeyManager.Token.SP_TOKEN,
//				MODE_PRIVATE).getString(IKeyManager.Token.KEY_USERNAME,
//				"default");
//
//		destDir = new File(SDCARD_ROOT + "/Vso/Pan/" + username + "/download");
//		if (!destDir.exists()) {
//			destDir.mkdirs();
//		}
//		thumbnailPath = SDCARD_ROOT + "/Vso/Pan/" + username + "/thumbnail";
//		previewPath = SDCARD_ROOT + "/Vso/Pan/" + username + "/preview";
//		localImageCache = SDCARD_ROOT + "/Vso/Pan/" + username
//				+ "/localImageCache";
//		File f = new File(thumbnailPath);
//		if (!f.exists()) {
//			f.mkdirs();
//		}
//		File f2 = new File(previewPath);
//		if (!f2.exists()) {
//			f2.mkdirs();
//		}
//		File f3 = new File(localImageCache);
//		if (!f3.exists()) {
//			f3.mkdirs();
//		}
    }

    /**
     * @return
     * @Title: getIndividualFolder
     * @Description: 获取用户目录
     * @author: leobert.lan
     */
    public static File getIndividualFolder() {
        return destDir;
    }

    /**
     * @return
     * @Title: isSdCardMounted
     * @Description: 检测外部存储是否加载
     * @author: leobert.lan
     */
    private boolean isSdCardMounted() {
        String status = Environment.getExternalStorageState();
        if (status.equals(Environment.MEDIA_MOUNTED))
            return true;
        else
            return false;
    }


    public static boolean isConnected() {
        return isConnected;
    }

    public static void setConnected(boolean isConnected) {
        BaseActivity.isConnected = isConnected;
    }

    public static boolean isOnWifi() {
        return onWifi;
    }

    public static void setOnWifi(boolean onWifi) {
        BaseActivity.onWifi = onWifi;
    }

    public static String getThumbnailPath() {
        return thumbnailPath;
    }

    public static String getLocalImageCachePath() {
        return localImageCache;
    }

    public static String getPreviewPath() {
        return previewPath;
    }

    public static boolean isOnlyOnWifi() {
        return isOnlyOnWifi;
    }

    /**
     * desc: TODO: 描述方法
     *
     * @param isOnlyOnWifi
     */
    public static void setOnlyOnWifi(boolean isOnlyOnWifi) {
        BaseActivity.isOnlyOnWifi = isOnlyOnWifi;

    }

}

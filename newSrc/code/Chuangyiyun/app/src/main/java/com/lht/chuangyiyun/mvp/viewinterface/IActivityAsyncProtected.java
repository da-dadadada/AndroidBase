package com.lht.chuangyiyun.mvp.viewinterface;

import android.widget.ProgressBar;

import com.lht.chuangyiyun.interfaces.umeng.IUmengReport;

/**
 * @package com.lht.chuangyiyun.mvp.viewinterface
 * @project AndroidBase
 * @classname IActivityAsyncProtected
 * @description: 同步等待窗，阻拦屏幕事件等
 * Created by leobert on 2016/4/1.
 */
public interface IActivityAsyncProtected extends IUmengReport{

    /**
     * desc: 提供等待窗
     *
     * @return 一个progressBar实例
     */
    ProgressBar getProgressBar();

    /**
     * desc: 修改屏幕事件消费能力
     *
     * @param ：是否激活
     */
    void setActiveStateOfDispatchOnTouch(boolean b);

    /**
     * desc: 显示等待窗
     *
     * @param isProtectNeed 是否需要屏幕防击穿保护
     */
    void showWaitView(boolean isProtectNeed);

    /**
     * desc: 取消等待窗
     */
    void cancelWaitView();
}

package com.lht.androidbase.activity;

import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;

import com.lht.androidbase.interfaces.umeng.IUmengReport;
import com.umeng.analytics.MobclickAgent;


/**
 *
 */
public abstract class UMengActivity extends AppCompatActivity implements IUmengReport {

//	protected CustomPopupWindow pw = null;

    public final static String tag = "umeng";

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//		CloudBoxApplication.addActivity(this);
        //如果要这么做的话 override setContentView
        // initView();
        // initVariable();
//         initEvent();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 友盟统计 页面统计-页面打开
        reportPageStart(getPageName());

//		MobclickAgent.onResume(getActivity());
//
//		DLog.d(getClass(), new LogLocation(), "onresume pagename:" + getPageName() + "; check:"
//				+ getActivity().getPageName());
    }


    @Override
    protected void onPause() {
        super.onPause();
        // 友盟统计 页面统计-页面关闭
        reportPageEnd(getPageName());

//		MobclickAgent.onPause(getActivity());
//
//		DLog.d(getClass(), new LogLocation(), "onpause pagename:" + getPageName() + "; check:"
//				+ getActivity().getPageName());
    }

    /**
     * @param pageName
     * @Title: reportPageStart
     * @Description: 报告页面打开
     * @author: leobert.lan
     */
    public void reportPageStart(String pageName) {
        MobclickAgent.onPageStart(pageName);
    }

    /**
     * @param pageName
     * @Title: reportPageEnd
     * @Description: 报告页面关闭
     * @author: leobert.lan
     */
    public void reportPageEnd(String pageName) {
//		MobclickAgent.onPageEnd(pageName);
    }

    /**
     * @return
     * @Title: getPageName
     * @Description: 获取页面名称
     * @author: leobert.lan
     */
    protected abstract String getPageName();

    /**
     * @return
     * @Title: getActivity
     * @Description: 获取activity
     * @author: leobert.lan
     */
    protected abstract UMengActivity getActivity();

    /**
     * @param eventKey 事件key
     * @Title: reportCountEvent
     * @Description: 友盟统计-报告计数事件
     * @author: leobert.lan
     */
    public void reportCountEvent(String eventKey) {
//		MobclickAgent.onEvent(getActivity(), eventKey);
    }

    /**
     * @param eventKey 事件key
     * @param attrMap  属性集<br>
     *                 <String Key,String Value>: key:属性key，value：属性集
     * @Title: reportCountEvent
     * @Description: 友盟统计-报告计数事件
     * @author: leobert.lan
     */
    public void reportCountEvent(String eventKey,
                                 HashMap<String, String> attrMap) {
//		MobclickAgent.onEvent(getActivity(), eventKey, attrMap);
    }

    /**
     * @param eventKey
     * @param attrMap
     * @param du
     * @Title: reportCalcEvent
     * @Description: TODO
     * @author: leobert.lan
     */
    protected void reportCalcEvent(String eventKey,
                                   HashMap<String, String> attrMap, int du) {
//		MobclickAgent.onEventValue(getActivity(), eventKey, attrMap, du);
    }

    protected void hideSoftInputPannel() {
        ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * desc: 实例化View
     */
    protected abstract void initView();

    /**
     * desc: 实例化必要的参数，以防止initEvent需要的参数空指针
     */
    protected abstract void initVariable();

    /**
     * desc: 监听器设置、adapter设置等
     */
    protected abstract void initEvent();

//	public void setLatestPopupWindow(CustomPopupWindow cpw) {
//		DLog.d(getClass(), "设置最终的弹出窗");
//		this.pw = cpw;
//	}

}

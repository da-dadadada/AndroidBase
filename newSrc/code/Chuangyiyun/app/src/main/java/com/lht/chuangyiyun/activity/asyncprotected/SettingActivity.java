package com.lht.chuangyiyun.activity.asyncprotected;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.lht.chuangyiyun.R;
import com.lht.chuangyiyun.activity.UMengActivity;
import com.lht.chuangyiyun.customview.TitleBar;
import com.lht.chuangyiyun.mvp.presenter.SettingActivityPresenter;
import com.lht.chuangyiyun.mvp.viewinterface.ISettingActivity;

public class SettingActivity extends AsyncProtectedActivity implements ISettingActivity, View.OnClickListener {

    private final static String PAGENAME = "SettingActivity";

    private TitleBar simpleBackTitleBar;

    private LinearLayout mBindPhone, mCertify, mResetPwd, mCheckUpdate, mCleanCache, mFeedback;

    private Button btnLogout;

    private SettingActivityPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();
        initVariable();
        initEvent();
    }

    @Override
    protected String getPageName() {
        return SettingActivity.PAGENAME;
    }

    @Override
    protected UMengActivity getActivity() {
        return SettingActivity.this;
    }

    @Override
    protected void initView() {
        mBindPhone = (LinearLayout) findViewById(R.id.setting_ll_bindphone);
        mCertify = (LinearLayout) findViewById(R.id.setting_ll_certify);
        mCheckUpdate = (LinearLayout) findViewById(R.id.setting_ll_checkupdate);
        mCleanCache = (LinearLayout) findViewById(R.id.setting_ll_cleancache);
        mResetPwd = (LinearLayout) findViewById(R.id.setting_ll_resetpwd);
        mFeedback = (LinearLayout) findViewById(R.id.setting_ll_feedback);

        btnLogout = (Button) findViewById(R.id.setting_btn_logout);
        simpleBackTitleBar = (TitleBar) findViewById(R.id.titlebar);
        //TODO
        simpleBackTitleBar.setTitle(R.string.app_name);
    }

    @Override
    protected void initVariable() {
        mPresenter = new SettingActivityPresenter(this);
    }

    @Override
    protected void initEvent() {
//        FragmentManager manager = getFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//
//        transaction.replace(R.id.bar_back_title, simpleBackTitleBar);
//        transaction.commit();

        simpleBackTitleBar.setDefaultOnBackListener(this);

        mFeedback.setOnClickListener(this);
        mResetPwd.setOnClickListener(this);
        mCleanCache.setOnClickListener(this);
        mCheckUpdate.setOnClickListener(this);
        mCertify.setOnClickListener(this);
        mBindPhone.setOnClickListener(this);
        btnLogout.setOnClickListener(this);


    }

    @Override
    public ProgressBar getProgressBar() {
        return null;
    }

    @Override
    public void jump2BindPhone() {
        start(BindPhoneActivity.class);
    }

    @Override
    public void jump2Certification() {
        start(CertifyActivity.class);
    }

    @Override
    public void jump2ResetPwd() {
        start(ResetPwdActivity.class);
    }

    @Override
    public void jump2Feedback() {
        start(FeedbackActivity.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.setting_btn_logout:
                mPresenter.callLogout();
                break;
            case R.id.setting_ll_bindphone:
                mPresenter.callBindPhone();
                break;
            case R.id.setting_ll_certify:
                mPresenter.callCertify();
                break;
            case R.id.setting_ll_checkupdate:
                mPresenter.callCheckUpdate();
                break;
            case R.id.setting_ll_cleancache:
                mPresenter.callCleanCache();
                break;
            case R.id.setting_ll_feedback:
                mPresenter.callFeedback();
                break;
            case R.id.setting_ll_resetpwd:
                mPresenter.callResetPwd();
                break;
            default:
                break;
        }
    }
}

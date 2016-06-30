package com.lht.chuangyiyun.activity.asyncprotected;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.lht.chuangyiyun.R;
import com.lht.chuangyiyun.activity.UMengActivity;
import com.lht.chuangyiyun.interfaces.IKeyManager;
import com.lht.chuangyiyun.mvp.presenter.LoginActivityPresenter;
import com.lht.chuangyiyun.mvp.viewinterface.ILoginActivity;

public class LoginActivity extends AsyncProtectedActivity implements ILoginActivity{

    private static final String PAGENAME = "LoginActivity";

    private LoginActivityPresenter presenter;

    public final static String TRIGGERKEY = "trigger";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginActivityPresenter(this);
        presenter.callLogin(this,"usr","pwd");
    }

    @Override
    protected String getPageName() {
        return LoginActivity.PAGENAME;
    }

    @Override
    protected UMengActivity getActivity() {
        return null;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    public ProgressBar getProgressBar() {
        //TODO
        return null;
    }

    @Override
    public void jump2RegisterActivity() {
        //TODO
    }

    @Override
    public void jump2MainActivity() {
        //TODO
    }

    @Override
    public SharedPreferences getTokenPreferences() {
        return getSharedPreferences(IKeyManager.Token.SP_TOKEN,MODE_PRIVATE);
    }

    @Override
    public void finishActivity() {
        finish();
    }

    @Override
    public Object getLoginTrigger() {
       return getIntent().getSerializableExtra(TRIGGERKEY);
    }
}

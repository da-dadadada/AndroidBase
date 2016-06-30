package com.lht.chuangyiyun.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lht.chuangyiyun.R;
import com.lht.chuangyiyun.activity.UMengActivity;
import com.lht.chuangyiyun.util.I18N;

public class TestI18NActivity extends UMengActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_i18_n);

        initEvent();
    }

    @Override
    protected String getPageName() {
        return "123";
    }

    @Override
    protected UMengActivity getActivity() {
        return TestI18NActivity.this;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initEvent() {
        findViewById(R.id.i18n_en).setOnClickListener(this);
        findViewById(R.id.i18n_zh).setOnClickListener(this);
        findViewById(R.id.i18n_tw).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        I18N.Language language = null;

        switch (v.getId()) {
            case R.id.i18n_en:
                language = I18N.Language.EN;
                break;
            case R.id.i18n_zh:
                language = I18N.Language.ZH_CN;
                break;
            case R.id.i18n_tw:
                language = I18N.Language.ZH_TW;
                break;
            default:
                break;
        }
        I18N.changeLanguage(getActivity(),language);
        finish();
        startActivity(new Intent(this,TestI18NActivity.class));
    }
}

package com.lht.chuangyiyun.test;

import android.os.Bundle;

import com.lht.chuangyiyun.R;
import com.lht.chuangyiyun.activity.UMengActivity;
import com.lht.chuangyiyun.customview.TitleBar;

public class TestBarActivity extends UMengActivity {

//    private SimpleBackTitleBar simpleBackTitleBar;

    private TitleBar titleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_bar);
//        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.bar_simple_title);
        initView();
        initEvent();
    }

    @Override
    protected String getPageName() {
        return "test bar";
    }

    @Override
    protected UMengActivity getActivity() {
        return TestBarActivity.this;
    }

    @Override
    protected void initView() {
        titleBar = (TitleBar) findViewById(R.id.titlebar);

        titleBar.setTitle("创意云");
//        simpleBackTitleBar = new SimpleBackTitleBar();
//        simpleBackTitleBar.setTitle(R.string.app_name);
    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initEvent() {

//        FragmentManager manager = getFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//
////        transaction.replace(R.id.testbar_titlebar, simpleBackTitleBar);
//        transaction.commit();

    }
}

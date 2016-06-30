package com.lht.chuangyiyun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.alibaba.fastjson.JSONObject;
import com.lht.chuangyiyun.activity.ExampleListActivity;
import com.lht.chuangyiyun.activity.asyncprotected.HomeActivity;
import com.lht.chuangyiyun.activity.asyncprotected.SettingActivity;
import com.lht.chuangyiyun.test.TestBarActivity;
import com.lht.chuangyiyun.test.TestBusActivity;
import com.lht.chuangyiyun.test.TestI18NActivity;
import com.lht.chuangyiyun.test.TestPtrListActivity;
import com.lht.chuangyiyun.test.TestVideoActivity;
import com.lht.chuangyiyun.test.anim.TestAnimActivity;
import com.lht.chuangyiyun.test.bridgewbv.TestBridgeWebviewActivity;
import com.lht.chuangyiyun.test.codescan.TestScanActivity;
import com.lht.chuangyiyun.test.testbanner.TestBannerActivity;
import com.lht.chuangyiyun.util.internet.AsyncResponseHandlerComposite;
import com.lht.chuangyiyun.util.internet.HttpUtil;
import com.loopj.android.http.RequestParams;


//import com.lht.chuangyiyun.test.TestBusActivity;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ll = (LinearLayout) findViewById(R.id.test_ll);

        setOnClick2Child(ll);
        JSONObject jobj = new JSONObject();
        jobj.put("test","test");

    }

    /**
     * @param viewGroup
     */
    private void setOnClick2Child(ViewGroup viewGroup) {
        int count = viewGroup.getChildCount();
        for (int i = 0; i < count; i++) {
            if (viewGroup.getChildAt(i) instanceof ViewGroup) {
                setOnClick2Child((ViewGroup) viewGroup.getChildAt(i));
            }
            //全部添加上
            viewGroup.getChildAt(i).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.test_main:
                start(HomeActivity.class);
                break;
            case R.id.test_bwv:
                start(TestBridgeWebviewActivity.class);
                break;
            case R.id.test_list:
                start(ExampleListActivity.class);
                break;
            case R.id.test_image:
                tempTestHttp();
                break;
            case R.id.test_bus:
                testBus();
                break;
            case R.id.test_ptr:
                start(TestPtrListActivity.class);
                break;
            case R.id.test_banner:
                start(TestBannerActivity.class);
                break;
            case R.id.test_i18n:
                start(TestI18NActivity.class);
                break;
            case R.id.test_anim:
                start(TestAnimActivity.class);
                break;
            case R.id.test_scan:
                start(TestScanActivity.class);
                break;
            case R.id.test_video:
                start(TestVideoActivity.class);
                break;
            case R.id.test_bar:
//                start(TestBarActivity.class);
                start(SettingActivity.class);
                break;
            default:
                break;
        }
    }

    private void tempTestHttp() {
        HttpUtil httpUtil = HttpUtil.getInstance();
        RequestParams params  = new RequestParams();
        params.add("appkey","YPMB");
        params.add("username","30259692");
        params.add("password", "121212");
        String url = "https://cbs.vsochina.com/v3/login";
        httpUtil.postWithParams(this,url,params,new AsyncResponseHandlerComposite(url,params));
    }

    private void testBus() {
        start(TestBusActivity.class);
    }

    private void start(Class<? extends Activity> clazz) {
        Intent intent = new Intent(TestActivity.this, clazz);
        startActivity(intent);
    }

}

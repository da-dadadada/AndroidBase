package com.lht.androidbase;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.lht.androidbase.activity.ExampleListActivity;
import com.lht.androidbase.activity.asyncprotected.MainActivity;
import com.lht.androidbase.test.TestBusActivity;
import com.lht.androidbase.test.TestI18NActivity;
import com.lht.androidbase.test.TestPtrListActivity;
import com.lht.androidbase.test.testbanner.TestBannerActivity;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ll = (LinearLayout) findViewById(R.id.test_ll);

        setOnClick2Child(ll);
    }

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
                start(MainActivity.class);
                break;
            case R.id.test_list:
                start(ExampleListActivity.class);
                break;
            case R.id.test_image:

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
            default:
                break;
        }
    }

    private void testBus() {
        start(TestBusActivity.class);
    }

    private void start(Class<? extends Activity> clazz) {
        Intent intent = new Intent(TestActivity.this, clazz);
        startActivity(intent);
    }

}

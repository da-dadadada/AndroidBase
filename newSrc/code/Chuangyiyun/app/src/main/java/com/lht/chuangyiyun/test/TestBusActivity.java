package com.lht.chuangyiyun.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lht.chuangyiyun.Event.AppEvent;
import com.lht.chuangyiyun.R;
import com.lht.chuangyiyun.clazz.LoginIntentFactory;
import com.lht.chuangyiyun.interfaces.IVerifyHolder;
import com.lht.chuangyiyun.mvp.model.pojo.VerifyInfo;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class TestBusActivity extends AppCompatActivity implements IVerifyHolder{

    private TextView tv1, tv2;

    private Button b1, b2;

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_bus);

        tv1 = (TextView) findViewById(R.id.testbus_tv_showonthread);
        tv2 = (TextView) findViewById(R.id.testbus_tv_otheractivity);
        b1 = (Button) findViewById(R.id.testbus_btn_thread);
        b2 = (Button) findViewById(R.id.testbus_btn_activity);

        EventBus eventBus = EventBus.getDefault();
        eventBus.register(this);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count == 0) {
//                    Intent i = new Intent(TestBusActivity.this, LoginActivity.class);
//                    i.putExtra("trigger",TestLoginTrigger.B);
                    Intent i = LoginIntentFactory.create(TestBusActivity.this,TestLoginTrigger.A);
                    startActivity(i);
                }  else {
                    Log.d("lmsg","it works");
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    @Subscribe
    public void onEventMainThread(AppEvent.LoginSuccessEvent event) {
        count++;
        VerifyInfo info  = event.getVerifyInfo();
        tv1.setText(info.toString());
        if (event.getTrigger().equals(TestLoginTrigger.A)) {
            b1.performClick();
        } else {
            Log.e("lmsg","it does not work");
        }
    }

    @Override
    public VerifyInfo getVerifyInfo() {
        return mVerifyInfo;
    }

    @Override
    public void updateVerifyInfo(String username, String accessId, String accessToken) {
        mVerifyInfo.setUsername(username);
        mVerifyInfo.setAccessId(accessId);
        mVerifyInfo.setAccessToken(accessToken);
    }
}

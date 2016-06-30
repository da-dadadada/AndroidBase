package com.lht.chuangyiyun.test;//package com.lht.chuangyiyun.test;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.TextView;
//
//import com.lht.chuangyiyun.R;
//import com.lht.chuangyiyun.util.msg.IMsgBusCallBackHandle;
//import com.lht.chuangyiyun.util.msg.MsgBus;
//import com.lht.chuangyiyun.util.msg.MsgBusHint;
//
//public class TestBusActivity2 extends AppCompatActivity implements IMsgBusCallBackHandle,MsgKey{
//
//    private TextView tv1;
//
//    @MsgBusHint
//    private String key4="key4";
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_test_bus);
//
//        tv1 = (TextView) findViewById(R.id.testbus_tv_showonthread);
//
//        findViewById(R.id.testbus_btn_thread).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Bundle b = new Bundle();
//                b.putString("data", "test data");
//                MsgBus.getInstance().post("KEY1", b);
//            }
//        });
//
//        findViewById(R.id.testbus_btn_activity).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Bundle b = new Bundle();
//                b.putString("data", "test data");
//                MsgBus.getInstance().post("KEY2", b);
//            }
//        });
//
////        MsgBus.getInstance().subscribe("key3", this);
////        MsgBus.getInstance().subscribe("key4",callback4);
//
//        MsgBus.getInstance().register(this);
//    }
//
//    @MsgBusHint(isKey = false,bindKey = {KEY1,KEY2})
//    private IMsgBusCallBackHandle callback4 = new IMsgBusCallBackHandle() {
//        @Override
//        public void onCallback(String key, Bundle data) {
//            Log.d("lmsg","receive "+key);
//            tv1.setText(key);
//        }
//    };
//
//    @Override
//    public void onCallback(String key, Bundle data) {
//        if (key.equals("key3")) {
//            Log.d("lmsg","receive key3");
//            tv1.setText(key);
//        }
//    }
//
//    @Override
//    protected void onStop() {
//        MsgBus.getInstance().deSubscribe(TestBusActivity2.this);
//        super.onStop();
//    }
//}

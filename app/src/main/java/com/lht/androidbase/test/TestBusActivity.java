//package com.lht.androidbase.test;
//
//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//import com.lht.androidbase.R;
//import com.lht.androidbase.util.msg.IMsgBusCallBackHandle;
//import com.lht.androidbase.util.msg.MsgBus;
//import com.lht.androidbase.util.msg.MsgBusHint;
//
//import org.greenrobot.eventbus.EventBus;
//
//public class TestBusActivity extends AppCompatActivity {
//
//    private TextView tv1, tv2;
//
//    private Button b1, b2;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_test_bus);
//
//        MsgBus bus = MsgBus.getInstance();
//
//        tv1 = (TextView) findViewById(R.id.testbus_tv_showonthread);
//        tv2 = (TextView) findViewById(R.id.testbus_tv_otheractivity);
//        b1 = (Button) findViewById(R.id.testbus_btn_thread);
//        b2 = (Button) findViewById(R.id.testbus_btn_activity);
//
//        EventBus eventBus = EventBus.getDefault();
//        eventBus.register(this);
//
//
//        bus.subscribe("key1", new IMsgBusCallBackHandle() {
//            @Override
//            public void onCallback(String key, Bundle data) {
//                tv1.setText(key+"  "+data.getString("data"));
//            }
//        });
//
//        bus.subscribe("key2", callback2);
//
//        b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new Test().start();
//
//                Bundle b = new Bundle();
//                b.putString("data","test data");
//                MsgBus.getInstance().post("key3", b);
//                MsgBus.getInstance().post("key4", b);
//            }
//        });
//
//        b2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(TestBusActivity.this,TestBusActivity2.class);
//                startActivity(i);
//            }
//        });
//    }
//
//    @MsgBusHint(isKey = false)
//    private IMsgBusCallBackHandle callback2 = new IMsgBusCallBackHandle() {
//        @Override
//        public void onCallback(String key, Bundle data) {
//            tv2.setText(key+"  "+data.getString("data"));
//        }
//    };
//
//    class Test extends Thread {
//        @Override
//        public void run() {
//            Bundle b = new Bundle();
//            b.putString("data","test data");
//            MsgBus.getInstance().post("key1",b);
//            super.run();
//        }
//    }
//
//}

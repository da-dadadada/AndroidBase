package com.lht.chuangyiyun.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lht.chuangyiyun.R;

public class MyFragment1 extends Fragment {

    public MyFragment1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content, container, false);
        TextView txt_content = (TextView) view.findViewById(R.id.txt_content);
        txt_content.setText("第一个Fragment");

        Log.e("lmsg","onCreate"+getClass().getName());
        return view;
    }

    @Override
    public void onResume() {
        Log.e("lmsg","onResume"+getClass().getName());
        super.onResume();
    }

    @Override
    public void onDestroy() {
        Log.e("lmsg","onDestroy"+getClass().getName());
        super.onDestroy();
    }


    @Override
    public void onPause() {
        Log.e("lmsg","onPause"+getClass().getName());
        super.onPause();
    }
}

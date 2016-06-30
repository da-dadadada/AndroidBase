//package com.lht.chuangyiyun.fragment.titlebars;
//
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.lht.chuangyiyun.R;
//
///**
// * <p><b>Package</b> com.lht.chuangyiyun.fragment.titlebars
// * <p><b>Project</b> Chuangyiyun
// * <p><b>Classname</b> SimpleBackTitleBar
// * <p><b>Description</b>: TODO
// * Created by leobert on 2016/5/9.
// */
//public class SimpleBackTitleBar extends SimpleTitleBar {
//    protected ImageView btnBack;
//
//    @Override
//    protected void initView(View contentView) {
//        txtTitle = (TextView) contentView.findViewById(R.id.bar_title);
//        btnBack = (ImageView) contentView.findViewById(R.id.bar_back);
//
//        btnBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getActivity().finish();
//            }
//        });
//    }
//
//    @Override
//    public int getDefaultLayoutRes() {
//        return R.layout.bar_simple_back_title;
//    }
//}

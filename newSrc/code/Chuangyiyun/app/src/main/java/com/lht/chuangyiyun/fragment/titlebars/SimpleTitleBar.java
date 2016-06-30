//package com.lht.chuangyiyun.fragment.titlebars;
//
//import android.view.View;
//import android.widget.TextView;
//
//import com.lht.chuangyiyun.R;
//
///**
// * <p><b>Package</b> com.lht.chuangyiyun.interfaces.bars
// * <p><b>Project</b> Chuangyiyun
// * <p><b>Classname</b> SimpleTitleBar
// * <p><b>Description</b>: TODO
// * Created by leobert on 2016/5/9.
// */
//public class SimpleTitleBar extends ABSBar {
//
//    protected TextView txtTitle;
//
//    @Override
//    protected void initView(View contentView) {
//        txtTitle = (TextView) contentView.findViewById(R.id.bar_title);
//    }
//
//    @Override
//    public int getDefaultLayoutRes() {
//        return R.layout.bar_simple_title;
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        txtTitle.setText(titleResId);
//    }
//
//    protected int titleResId;
//
//    public void setTitle(int resId) {
//        titleResId = resId;
//    }
//}

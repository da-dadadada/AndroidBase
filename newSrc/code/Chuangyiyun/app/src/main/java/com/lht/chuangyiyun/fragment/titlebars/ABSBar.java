//package com.lht.chuangyiyun.fragment.titlebars;
//
//import android.app.Fragment;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.lht.chuangyiyun.interfaces.bars.IBarBase;
//
///**
// * <p><b>Package</b> com.lht.chuangyiyun.fragment.titlebars
// * <p><b>Project</b> Chuangyiyun
// * <p><b>Classname</b> ABSBar
// * <p><b>Description</b>: TODO
// * Created by leobert on 2016/5/9.
// */
//public abstract class ABSBar extends Fragment implements IBarBase {
//
//    protected View contentView = null;
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        int layoutResId = getDefaultLayoutRes();
//        contentView = inflater.inflate(layoutResId, container, false);
//        initView(contentView);
//        return contentView;
//    }
//
//    protected abstract void initView(View contentView);
//
//    @Override
//    public View getContentView() {
//        return contentView;
//    }
//}

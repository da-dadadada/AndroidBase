package com.lht.androidbase.interfaces.adapter;

import android.view.View;

import com.lht.androidbase.clazz.ABSViewHolder;
import com.lht.androidbase.clazz.ViewHolderPkg;

/**
 * @package com.lht.androidbase.interfaces.adapter
 * @project AndroidBase
 * @classname ISetCallbackForListItem
 * @description: 设计目的：减少adapter和activity之间的依赖，为item中的内容设置回调
 * Created by leobert on 2016/4/5.
 */
public interface ISetCallbackForListItem {
    /**
     * desc: 为item设置各种回调，这里不传递ViewHolder是因为无法预知开发者会写出什么代码，我也不想限定的太死
     *
     * @param convertView
     */
    void setCallBack(View convertView,ViewHolderPkg<? extends ABSViewHolder> viewHolderPkg);
}

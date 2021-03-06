package com.lht.androidbase.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.lht.androidbase.interfaces.adapter.IListItemViewProvider;

/**
 * @package com.lht.androidbase.adapter
 * @project AndroidBase
 * @classname AbsListAdapter
 * @description: listview适配器抽象父类，抽象了getView，并用接口实现，减少getView中可能的依赖
 * 要区分一下adapter到底是V层的还是M层的真的很难。
 * Created by leobert on 2016/4/1.
 */
public abstract class AbsListAdapter extends BaseAdapter {

    private final IListItemViewProvider itemViewProvider;

    public AbsListAdapter(IListItemViewProvider itemViewProvider) {
        this.itemViewProvider = itemViewProvider;
    }

    @Override
    public abstract int getCount();

    @Override
    public abstract Object getItem(int position);

    @Override
    public abstract long getItemId(int position);

    /**
     * desc: TODO: 描述方法
     * <p/>
     * 这里我考虑过两种解耦方式：
     * 1高度复用adapter，使用接口完成getView回调。
     * 2定义click等相关接口
     * 当前，我选用第一种形式，不会让activity显得过于臃肿
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return itemViewProvider.getView(position, getItem(position), convertView, parent);
    }
}

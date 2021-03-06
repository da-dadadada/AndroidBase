package com.lht.chuangyiyun.adapter;

import com.lht.chuangyiyun.interfaces.adapter.IListItemViewProvider;

import java.util.ArrayList;

/**
 * @package com.lht.chuangyiyun.adapter
 * @project AndroidBase
 * @classname ExampleListAdapter
 * @description: TODO
 * Created by leobert on 2016/4/1.
 */
public class ExampleListAdapter extends AbsListAdapter {
    private ArrayList<? extends Object> liData;
    public ExampleListAdapter(ArrayList<? extends Object> liData,IListItemViewProvider itemViewProvider) {
        super(itemViewProvider);
        this.liData = liData;
    }

    @Override
    public int getCount() {
        return liData.size();
    }

    @Override
    public Object getItem(int position) {
        return liData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}

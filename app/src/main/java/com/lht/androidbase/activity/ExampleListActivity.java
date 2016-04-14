package com.lht.androidbase.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.lht.androidbase.R;
import com.lht.androidbase.adapter.ExampleListAdapter;
import com.lht.androidbase.adapter.viewprovider.ExampleViewProviderImpl;
import com.lht.androidbase.clazz.ABSViewHolder;
import com.lht.androidbase.clazz.ViewHolderPkg;
import com.lht.androidbase.interfaces.adapter.ISetCallbackForListItem;

import java.util.ArrayList;

public class ExampleListActivity extends UMengActivity implements ISetCallbackForListItem {

    private static final String PageName = "ExampleListActivity";

    private ListView mListView;

    private LayoutInflater layoutInflater;

    private ExampleListAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_list);

         initView();
         initVariable();
         initEvent();
    }

    @Override
    protected String getPageName() {
        return PageName;
    }

    @Override
    protected UMengActivity getActivity() {
        return ExampleListActivity.this;
    }

    @Override
    protected void initView() {
        mListView = (ListView) findViewById(R.id.ela_lv);
    }

    @Override
    protected void initVariable() {
        ArrayList<String> data = new ArrayList<>();
        for (int i=0;i<5;i++) {
            data.add("test:"+i);
        }
        layoutInflater = LayoutInflater.from(ExampleListActivity.this);
        mAdapter = new ExampleListAdapter(data,new ExampleViewProviderImpl(layoutInflater,this) );
    }

    @Override
    protected void initEvent() {
        mListView.setAdapter(mAdapter);
    }

    @Override
    public void setCallBack(View convertView, ViewHolderPkg<? extends ABSViewHolder> viewHolderPkg) {
        if (viewHolderPkg.getContainer() instanceof ExampleViewProviderImpl.ViewHolder) {
            ExampleViewProviderImpl.ViewHolder viewHolder = (ExampleViewProviderImpl.ViewHolder) viewHolderPkg.getContainer();
            viewHolder.tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(),((TextView)v).getText().toString(),Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


}

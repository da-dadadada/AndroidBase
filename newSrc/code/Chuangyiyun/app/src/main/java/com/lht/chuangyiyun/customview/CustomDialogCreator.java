package com.lht.chuangyiyun.customview;

import android.view.View;

import com.lht.chuangyiyun.interfaces.custompopupwins.IPopupHolder;

/**
 * @ClassName: CustomDialogCreator
 * @Description: TODO
 * @date 2016年3月30日 下午1:28:45
 * 
 * @author leobert.lan
 * @version 1.0
 */
public abstract class CustomDialogCreator {

	final Builder builder;

	CustomDialogCreator(IPopupHolder iPopupHolder) {
		builder = new Builder();
		builder.setiPopupHolder(iPopupHolder);
		setDefault();
	}
	
	abstract void setDefault();
	
	public Builder setContent(int rid) {
		String s = builder.getiPopupHolder().getHolderActivity().getResources().getString(rid);
		builder.setContent(s);
		return builder;
	}

	public Builder setPositiveButton(String text) {
		builder.setPositiveStr(text);
		return builder;
	}

	public Builder setPositiveButton(int rid) {
		String s = builder.getiPopupHolder().getHolderActivity().getResources().getString(rid);
		builder.setPositiveStr(s);
		return builder;
	}

	public Builder setNegativeButton(String text) {
		builder.setNegativeStr(text);
		return builder;
	}

	public Builder setNegativeButton(int rid) {
		String s = builder.getiPopupHolder().getHolderActivity().getResources().getString(rid);
		builder.setNegativeStr(s);
		return builder;
	}
	
	public Builder setPositiveClickListener(
			CustomPopupWindow.OnPositiveClickListener positiveClickListener) {
		builder.setPositiveClickListener(positiveClickListener);
		return builder;
	}

	public Builder setNegativeClickListener(
			CustomPopupWindow.OnNegativeClickListener negativeClickListener) {
		builder.setNegativeClickListener(negativeClickListener);
		return builder;
	}
	
	public Builder changeInnerContent(View v) {
		builder.setContentWaitChange(v);
		return builder;
	}
	
	public CustomDialog create() {
		return builder.create();
	}
	
	public void show() {
		builder.create().show();
	}

}

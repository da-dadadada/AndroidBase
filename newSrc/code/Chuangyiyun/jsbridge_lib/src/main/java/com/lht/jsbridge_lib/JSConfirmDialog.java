package com.lht.jsbridge_lib;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.JsResult;

import com.alibaba.fastjson.JSON;
import com.lht.jsbridge_lib.base.model.JSConfirmDataBean;

/**
 * @ClassName: JSConfirmDialog
 * @Description: TODO
 * @date 2016年2月23日 下午5:00:54
 * 
 * @author leobert.lan
 * @version 1.0
 */
public class JSConfirmDialog {

	private final AlertDialog.Builder builder;

	private final JsResult result;

	public JSConfirmDialog(Context ctx, JsResult r) {
		this.result = r;

		builder = new AlertDialog.Builder(ctx);
		// 不需要绑定按键事件
		// 屏蔽keycode等于84之类的按键
		builder.setOnKeyListener(new OnKeyListener() {
			@Override
			public boolean onKey(DialogInterface dialog, int keyCode,
					KeyEvent event) {
				Log.v("onJsAlert", "keyCode==" + keyCode + "event=" + event);
				return true;
			}
		});
		// 禁止响应按back键的事件
		builder.setCancelable(false);
		builder.setOnCancelListener(new OnCancelListener() {
			@Override
			public void onCancel(DialogInterface dialog) {
				result.cancel();
			}
		});
	}

	public void fixContent(String data) {
		if (data.contains("{") && data.contains("}")) {
			JSConfirmDataBean bean = JSON.parseObject(data,
					JSConfirmDataBean.class);
			// 检验是否有title
			if (!TextUtils.isEmpty(bean.getTitle()))
				builder.setTitle(bean.getTitle());
			// 检验是否有确认键文字
			if (!TextUtils.isEmpty(bean.getPositiveContent()))
				setPositive(bean.getPositiveContent());
			else
				setPositive("确定");

			if (!TextUtils.isEmpty(bean.getNegativeContent()))
				setNegative(bean.getNegativeContent());
			else
				setNegative("取消");

			builder.setMessage(bean.getMessage());
		} else {
			builder.setMessage(data);
			setPositive("确定");
			setNegative("取消");
		}

	}

	private void setPositive(String content) {
		builder.setPositiveButton(content, new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				result.confirm();
			}
		});
	}

	private void setNegative(String content) {
		builder.setNegativeButton(content, new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				result.cancel();
			}
		});
	}

	public void show() {
		AlertDialog dialog = builder.create();
		dialog.show();
	}

}

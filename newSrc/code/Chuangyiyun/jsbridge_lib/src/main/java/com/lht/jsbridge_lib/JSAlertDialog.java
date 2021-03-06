package com.lht.jsbridge_lib;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.JsResult;

import com.alibaba.fastjson.JSON;
import com.lht.jsbridge_lib.base.model.JSAlertDataBean;

/**
 * @ClassName: JSAlertDialog
 * @Description: TODO
 * @date 2016年2月23日 下午4:32:35
 * 
 * @author leobert.lan
 * @version 1.0
 */
public class JSAlertDialog {

	private final AlertDialog.Builder builder;

	private final JsResult result;

	private boolean debug = false;

	public JSAlertDialog(Context ctx, JsResult result) {
		this.result = result;

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
	}

	public void fixContent(String data) {
		if (data.contains("{") && data.contains("}")) {
			JSAlertDataBean bean = JSON
					.parseObject(data, JSAlertDataBean.class);
			// 检验是否有title
			if (!TextUtils.isEmpty(bean.getTitle()))
				builder.setTitle(bean.getTitle());
			// 检验是否有确认键文字
			if (!TextUtils.isEmpty(bean.getPositiveContent()))
				setPositive(bean.getPositiveContent());
			else
				setPositive("确定");
			builder.setMessage(bean.getMessage());
			if (bean.isDebug())
				debug = true;
		} else {
			builder.setMessage(data);
			setPositive("确定");
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

	public void show() {
		AlertDialog dialog = builder.create();
		if (!debug) {
			Log.e("lmsg","did not use debug to alert");
			dialog.show();
		} else {
			Log.e("lmsg","use debug to alert");
			if (BridgeWebView.MY_DEBUG) {
				Log.e("lmsg","on debug mode");
				dialog.show();
			} else {
				Log.e("lmsg","on release mode,without debug popup");
				result.confirm();
			}
		}
	}

}

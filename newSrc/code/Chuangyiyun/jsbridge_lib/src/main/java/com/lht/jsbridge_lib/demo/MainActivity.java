//package com.lht.jsbridge_lib.demo;
//
//import android.app.Activity;
//import android.content.Context;
//import android.os.Bundle;
//import android.os.Environment;
//import android.util.Log;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.FrameLayout;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.lht.jsbridge_lib.BridgeWebView;
//import com.lht.jsbridge_lib.DefaultHandler;
//import com.lht.jsbridge_lib.R;
//import com.lht.jsbridge_lib.base.IMediaTransImpl;
//import com.lht.jsbridge_lib.base.Interface.BridgeHandler;
//import com.lht.jsbridge_lib.base.Interface.CallBackFunction;
//import com.lht.jsbridge_lib.business.API.API.CallTelHandler;
//import com.lht.jsbridge_lib.business.API.API.Demo;
//import com.lht.jsbridge_lib.business.API.API.GetClipBoardContentHandler;
//import com.lht.jsbridge_lib.business.API.API.SendEmailHandler;
//import com.lht.jsbridge_lib.business.API.API.SendMessageHandler;
//import com.lht.jsbridge_lib.business.API.API.SendToClipBoardHandler;
//import com.lht.jsbridge_lib.business.API.API.TestLTRHandler;
//import com.lht.jsbridge_lib.business.API.NativeRet;
//import com.lht.jsbridge_lib.business.bean.BaseResponseBean;
//import com.lht.jsbridge_lib.business.impl.CallTelImpl;
//import com.lht.jsbridge_lib.business.impl.CopyToClipboardImpl;
//import com.lht.jsbridge_lib.business.impl.DemoImpl;
//import com.lht.jsbridge_lib.business.impl.SendEmailImpl;
//import com.lht.jsbridge_lib.business.impl.SendMessageImpl;
//import com.lht.jsbridge_lib.business.impl.TestLTRImpl;
//
////import com.lht.jsbridge_lib.business.impl.OpenGPSImpl;
////import com.lht.jsbridge_lib.business.impl.ScanCodeImpl;
////import com.lht.jsbridge_lib.business.impl.ThirdPartyLoginImpl;
//
//public class MainActivity extends Activity implements OnClickListener {
//
//		private final String TAG = "MainActivity";
//
//		BridgeWebView webView;
//
//		Button button;
//		Button btnMeida;
//		Button sinaLogin;
//
//		Context mContext;
//
////	private QQLogin mQQlogin;
//
//		private ViewGroup fullContainer;
//
//		private FrameLayout videoView;
//
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
//
//		Log.d(TAG, "onCreate");
//
//		mContext = this;
//		String abs = Environment.getExternalStorageDirectory()
//				.getAbsolutePath();
//		Log.d(TAG, abs);
////		mQQlogin = new QQLogin(mContext);
//
//		webView = (BridgeWebView) findViewById(R.id.webView);
//
//		fullContainer = (ViewGroup) findViewById(R.id.full_container);
//		videoView = (FrameLayout) findViewById(R.id.video_fullView);
//
//		button = (Button) findViewById(R.id.button);
//		btnMeida = (Button) findViewById(R.id.testMedia);
//		sinaLogin = (Button) findViewById(R.id.sinaLogin);
//
//		button.setOnClickListener(this);
//		btnMeida.setOnClickListener(this);
//		sinaLogin.setOnClickListener(this);
//		findViewById(R.id.testVirClose).setOnClickListener(this);
//		findViewById(R.id.testModeSwitch).setOnClickListener(this);
//
//		webView.setDefaultHandler(new DefaultHandler());
//
//		// Test TODO
//		webView.setIMediaTrans(new IMediaTransImpl(this, videoView,
//				fullContainer));
//
//		// ===================================
//
//		String localTestUri2 = "file:///android_asset/ExampleApp.html";
//
//		webView.loadUrl(localTestUri2);
//
//		webView.registerHandler("submitFromWeb", new BridgeHandler() {
//
//			@Override
//			public void handler(String data, CallBackFunction function) {
//				Log.i(TAG, "handler = submitFromWeb, data from web = " + data);
//				function.onCallBack("submitFromWeb exe, response data 中文 from Java");
//			}
//
//		});
//
//		// test screen temp
//		webView.registerHandler(Demo.API_NAME, new DemoImpl(MainActivity.this));
//
////		webView.registerHandler(GPSHandler.API_NAME, new OpenGPSImpl(
////				MainActivity.this));
//
//		webView.registerHandler(TestLTRHandler.API_NAME, new TestLTRImpl());
//
//		webView.registerHandler(CallTelHandler.API_NAME, new CallTelImpl(
//				MainActivity.this));
//
//		webView.registerHandler(SendToClipBoardHandler.API_NAME,
//				new CopyToClipboardImpl(MainActivity.this));
//
//		// TODO
//		webView.registerHandler(GetClipBoardContentHandler.API_NAME,
//				new CopyToClipboardImpl(MainActivity.this));
//
//		// TODO
//		webView.registerHandler(SendEmailHandler.API_NAME, new SendEmailImpl(
//				MainActivity.this));
//
//		// TODO
//		webView.registerHandler(SendMessageHandler.API_NAME,
//				new SendMessageImpl(MainActivity.this));
//
////		webView.registerHandler(ScanCodeHandler.API_NAME, new ScanCodeImpl(
////				MainActivity.this));
//
////		webView.registerHandler(ThirdPartyLoginHandler.API_Name,
////				new ThirdPartyLoginImpl(MainActivity.this));
//
//		testCallJs();
//
//	}
//
//	@Override
//	protected void onPause() {
//		// TODO Auto-generated method stub
//		super.onPause();
//		webView.onPause();
//	}
//
//	@Override
//	protected void onResume() {
//		// TODO Auto-generated method stub
//		super.onResume();
//		webView.onResume();
//	}
//
//
////	public void configPlatforms() {
////
////		// 设置新浪SSO handler
////		mController.getConfig().setSsoHandler(new SinaSsoHandler());
////	}
//
//	@Override
//	public void onClick(View v) {
//
//		switch (v.getId()) {
//		case R.id.button:
//			if (button.equals(v)) {
//				JSONObject jObj = new JSONObject();
//				jObj.put("Nkey1", "Nvalue1");
//				webView.callJsDemo(JSON.toJSONString(jObj),
//						new CallBackFunction() {
//							@Override
//							public void onCallBack(String data) {
//								Log.d(TAG, "receive from js:" + data);
//							}
//						});
//			}
//			break;
//		case R.id.testMedia:
//
//			webView.loadUrl("http://172.16.7.140/MediaTest/test/test.html");
//
//			// mQQlogin.setQQLogin();
//			// mQQlogin.setCallback(new QQUserInfoCallBack() {
//			// @Override
//			// public void onSuccess(String info) {
//			// Toast.makeText(mContext, info.toString(),
//			// Toast.LENGTH_SHORT).show();
//			// BaseResponseBean bean = new BaseResponseBean();
//			// bean.setRet(NativeRet.RET_SUCCESS);
//			// bean.setMsg("OK");
//			// bean.setData("");
//			// webView.callJsThirdLogin(JSON.toJSONString(bean), new
//			// CallBackFunction() {
//			// @Override
//			// public void onCallBack(String data) {
//			// Log.i(TAG, data);
//			// }
//			// });
//			// }
//			// });
//			break;
//		case R.id.sinaLogin:
//			BaseResponseBean bean = new BaseResponseBean();
//			bean.setRet(NativeRet.RET_SUCCESS);
//			bean.setMsg("OK");
//			bean.setData("deprecate");
//			webView.callJsThirdLogin(JSON.toJSONString(bean),
//					new CallBackFunction() {
//						@Override
//						public void onCallBack(String data) {
//							Log.i(TAG, data);
//						}
//					});
//			break;
//
//		case R.id.testVirClose:
//			webView.callJsCloseVirtualAppSession();
//			break;
//		case R.id.testModeSwitch:
//			Object obj = v.getTag();
//			boolean b = obj == null ? true : false;
//			webView.callJsSetVirturlAppTouchDragMode(b);
//			v.setTag(!b);
//			break;
//		default:
//			break;
//		}
//	}
//
////	private void setSinaLogin() {
////		mController.doOauthVerify(MainActivity.this, SHARE_MEDIA.SINA,
////				new UMAuthListener() {
////					@Override
////					public void onError(SocializeException e,
////							SHARE_MEDIA platform) {
////						Toast.makeText(MainActivity.this, "授权失败.",
////								Toast.LENGTH_SHORT).show();
////					}
////
////					@Override
////					public void onComplete(Bundle value, SHARE_MEDIA platform) {
////						mController.getPlatformInfo(MainActivity.this,
////								SHARE_MEDIA.SINA, new UMDataListener() {
////									@Override
////									public void onStart() {
////										Toast.makeText(MainActivity.this,
////												"获取平台数据开始...",
////												Toast.LENGTH_SHORT).show();
////									}
////
////									@Override
////									public void onComplete(int status,
////											Map<String, Object> info) {
////										if (status == 200 && info != null) {
////											Toast.makeText(MainActivity.this,
////													info.toString(),
////													Toast.LENGTH_SHORT).show();
////											StringBuilder sb = new StringBuilder();
////											Set<String> keys = info.keySet();
////											for (String key : keys) {
////												sb.append(key
////														+ "="
////														+ info.get(key)
////																.toString()
////														+ "\r\n");
////											}
////											Log.i("zhang",
////													JSON.toJSONString(info));
////											Log.d("TestData", sb.toString());
////										} else {
////											Log.d("TestData", "发生错误：" + status);
////										}
////									}
////								});
////						if (value != null
////								&& !TextUtils.isEmpty(value.getString("uid"))) {
////							Toast.makeText(MainActivity.this, "授权成功.",
////									Toast.LENGTH_SHORT).show();
////						} else {
////							Toast.makeText(MainActivity.this, "授权失败",
////									Toast.LENGTH_SHORT).show();
////						}
////					}
////
////					@Override
////					public void onCancel(SHARE_MEDIA platform) {
////						Toast.makeText(MainActivity.this, "授权取消.",
////								Toast.LENGTH_SHORT).show();
////					}
////
////					@Override
////					public void onStart(SHARE_MEDIA platform) {
////						Toast.makeText(MainActivity.this, "授权开始.",
////								Toast.LENGTH_SHORT).show();
////					}
////				});
////	}
//
////	@Override
////	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
////		super.onActivityResult(requestCode, resultCode, data);
////		UMSsoHandler ssoHandler = mController.getConfig().getSsoHandler(
////				requestCode);
////		if (ssoHandler != null) {
////			ssoHandler.authorizeCallBack(requestCode, resultCode, data);
////		}
////	}
//
//	private void testCallJs() {
//		// User user = new User();
//		// Location location = new Location();
//		// location.address = "SDU";
//		// user.location = location;
//		// user.name = "大头鬼";
//		// webView.callHandler("functionInJs", new Gson().toJson(user),
//		// new CallBackFunction() {
//		// @Override
//		// public void onCallBack(String data) {
//		//
//		// }
//		// });
//		//
//		// webView.send("hello");
//	}
//
//	static class Location {
//		String address;
//	}
//
//	static class User {
//		String name;
//		Location location;
//		String testStr;
//	}
//
//}

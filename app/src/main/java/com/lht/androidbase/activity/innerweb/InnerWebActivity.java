package com.lht.androidbase.activity.innerweb;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lht.androidbase.R;
import com.lht.androidbase.activity.UMengActivity;

public abstract class InnerWebActivity extends UMengActivity {

    private String url;

    private WebView mWebView;

    private TextView title;

    private ProgressBar progressbar;
    private ImageView back;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner_web);
        url = getUrl();
        mWebView.loadUrl(url);
    }

    @Override
    protected void initView() {
        WebView webview = provideWebView();
        mWebView = webview != null ? webview : (WebView) findViewById(R.id.protocol_webview);
        title = (TextView) findViewById(R.id.innerweb_title);
        ProgressBar pBar = provideProgressBar();
        progressbar = pBar != null ? pBar : (ProgressBar) findViewById(R.id.innerweb_pb);
        back = (ImageView) findViewById(R.id.activity_protocol_back);
    }

    @Override
    protected void initEvent() {
        WebSettings wSet = mWebView.getSettings();
        wSet.setJavaScriptEnabled(true);
        // 不使用cache
        wSet.setCacheMode(WebSettings.LOAD_NO_CACHE);
        mWebView.setWebViewClient(new webViewClient());
        mWebView.setWebChromeClient(new ChromeView());

        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        title.setText(getResources().getString(getMyTitle()));
    }

    protected abstract WebView provideWebView();

    protected abstract ProgressBar provideProgressBar();


    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else
            super.onBackPressed();
    }

    private class ChromeView extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            // TODO Auto-generated method stub
            super.onProgressChanged(view, newProgress);
            if (newProgress == 100) {
                progressbar.setVisibility(View.GONE);
            } else {
                if (progressbar.getVisibility() == View.GONE)
                    progressbar.setVisibility(View.VISIBLE);
                progressbar.setProgress(newProgress);
            }
        }
    }

    private class webViewClient extends WebViewClient {

        // 重写shouldOverrideUrlLoading方法，使点击链接后不使用其他的浏览器打开。
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//			if (url.equals("https://account.vsochina.com/user/login")) {
//				Intent i = new Intent(InnerWebActivity.this,
//						LoginActivity.class);
//				startActivity(i);
//				InnerWebActivity.this.finish();
//				return false;
//			}
            view.loadUrl(url);
            // 如果不需要其他对点击链接事件的处理返回true，否则返回false
            return true;
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected abstract String getUrl();

    protected abstract int getMyTitle();

}

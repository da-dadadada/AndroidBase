package com.lht.chuangyiyun.activity.asyncprotected;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.lht.chuangyiyun.Event.AppEvent;
import com.lht.chuangyiyun.R;
import com.lht.chuangyiyun.activity.UMengActivity;
import com.lht.chuangyiyun.mvp.presenter.FeedbackActivityPresenter;
import com.lht.chuangyiyun.mvp.viewinterface.IFeedbackActivity;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.File;

public class FeedbackActivity extends AsyncProtectedActivity implements IFeedbackActivity ,View.OnClickListener{

    private final static String PAGENAME = "FeedbackActivity";

    private EditText etContact, etContent;

    private FeedbackActivityPresenter mPresenter;

    //TODO temp
    private Button btnCapture,btnAlbumSelect;

    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        EventBus.getDefault().register(this);
        Log.e("lmsg","feedbck onCreate");
        initView();
        initVariable();
        initEvent();
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Override
    protected String getPageName() {
        return FeedbackActivity.PAGENAME;
    }

    @Override
    protected UMengActivity getActivity() {
        return FeedbackActivity.this;
    }

    @Override
    protected void initView() {
        etContact = (EditText) findViewById(R.id.feedback_et_contact);
        btnAlbumSelect = (Button) findViewById(R.id.feedback_btn_album);
        btnCapture = (Button) findViewById(R.id.feedback_btn_capture);
        image = (ImageView) findViewById(R.id.feedback_image_test);
    }

    @Override
    protected void initVariable() {
        mPresenter = new FeedbackActivityPresenter(this);
    }

    @Override
    protected void initEvent() {
        mPresenter.watchInputLength(etContact, 11);
        btnCapture.setOnClickListener(this);
        btnAlbumSelect.setOnClickListener(this);
    }

    @Override
    public ProgressBar getProgressBar() {
        return null;
    }

    @Override
    public void notifyOverLength() {
        Toast.makeText(FeedbackActivity.this,
                "你输入的字数已经超过了限制！", Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void addFeedbackImage(String path) {
        Log.e("lmsg", "add:path" + path);
        imagepath = path;
        Picasso.with(this).load(new File(path)).error(R.drawable.ic_launcher).placeholder(R.drawable.ic_test_0).fit().centerInside().into(image);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.feedback_btn_album:
                mPresenter.callAlbumForImage(getActivity());
                break;
            case R.id.feedback_btn_capture:
                mPresenter.callCaptureForImage(getActivity());
                break;
            default:
                break;
        }
    }

    @Subscribe
    public void onEventMainThread(AppEvent.CaptureSuccessEvent event) {
        mPresenter.callResolveEvent(event);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.e("lmsg", "save");
        outState.putString("image",imagepath);
    }

    private String imagepath = null;

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e("lmsg", "restore");
        addFeedbackImage(savedInstanceState.getString("image"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("lmsg","onResult");
        switch (requestCode) {
            case FeedbackActivityPresenter.INTENT_CODE_ALBUM:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = data.getData();
                    Log.d(getPageName(), "select:" + selectedImage);
                } else {
                    Log.d(getPageName(), "select: fail");
                }
                break;
            case FeedbackActivityPresenter.INTENT_CODE_CAPTURE:
                if (resultCode == RESULT_OK) {
                    Log.d(getPageName(), "capture: trans");
                    mPresenter.callTransCapture();
                } else {
                    Log.d(getPageName(), "capture: fail");
                }
                break;
            default:
                break;
        }
    }
}

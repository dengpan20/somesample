package com.lgw.ocrlibrary.ocr.camera;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.lgw.ocrlibrary.R;
import com.lgw.ocrlibrary.ocr.thrlib.RecognizeService;

public class CameraSearchActivity extends AppCompatActivity implements View.OnClickListener {


    ImageView cameraIv;
    TextView recognResultTv;
    ProgressBar mProgressBar;
    EditText questionEt;
    private String content;
    private String path;//上个页面传递的Path
    private String ui;

    /**
     * 入口函数
     * @param c
     * @param path 图片保存地址
     * @param ui 需要跳转的页面
     */
    public static void startAct(Context c, String path,String ui) {
        Intent intent = new Intent(c, CameraSearchActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, path);
        intent.putExtra(Intent.EXTRA_PACKAGE_NAME, ui);
        c.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_layout);
        initArgs();
        initView();

    }

    private void initArgs() {
        if(getIntent() == null) {
            throw new IllegalArgumentException("check your params path or activity names");
        }
        path = getIntent().getStringExtra(Intent.EXTRA_TEXT);
        ui = getIntent().getStringExtra(Intent.EXTRA_PACKAGE_NAME);
    }

    protected void initView() {
        cameraIv = findViewById(R.id.camera_crop_iv);
        recognResultTv = findViewById(R.id.camera_result_tv);
        mProgressBar = findViewById(R.id.recognize_camera_pb);
        questionEt = findViewById(R.id.question_search_input);
        cameraIv.setImageBitmap(BitmapFactory.decodeFile(path));
        cameraIv.setOnClickListener(this);
        findViewById(R.id.question_search_cancel_btn).setOnClickListener(this);
        findViewById(R.id.go_on_camera).setOnClickListener(this);
        initRecognizeResult();
        questionEt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    controlTvFocus(cameraIv);
                    //
//                    PicSearchActivity.startAct(mContext, content.trim());
                    goToNext(ui);
                }
            }
        });
        controlTvFocus(cameraIv);
    }

    private void initRecognizeResult() {

        RecognizeService.recGeneral(path,
                new RecognizeService.ServiceListener() {
                    @Override
                    public void onResult(String result) {
                        mProgressBar.setVisibility(View.GONE);
                        content = result;
                        recognResultTv.setText(content);
                        questionEt.setText(content);
                        //
                        if (!TextUtils.isEmpty(content) && !TextUtils.equals("[283504] Network error", content)) {
//                            PicSearchActivity.startAct(mContext, content.trim());
//                            goToNext(ui);
                        }
                    }
                });


    }

    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.camera_crop_iv) {
            mProgressBar.setVisibility(View.VISIBLE);
            initRecognizeResult();
        } else if (i == R.id.go_on_camera) {
            finish();
            // 点击“取消”按钮，及半透明背景，均退出页面
        } else if (i == R.id.question_search_cancel_btn) {//                forword(MainActivity.class);
            finish();
        }
    }
    public static void controlTvFocus(View view) {
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void goToNext(String uiname){
        ComponentName comp = new ComponentName(this, uiname);
        Intent intent = new Intent();
        intent.putExtra("content", questionEt.getText().toString().trim());
        intent.setComponent(comp);
        intent.setAction("android.intent.action.VIEW");
        startActivity(intent);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

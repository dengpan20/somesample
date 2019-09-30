package com.dengpan20.somesample.activity;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.webkit.*;
import android.widget.FrameLayout;
import com.dengpan20.somesample.R;
import com.dengpan20.somesample.base.BaseActivity;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Method;

public class VideoWebActivity extends BaseActivity {
    private WebView wvBookPlay;
//    private String tvUrl;
    private FrameLayout flVideoContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_web);

        wvBookPlay = (WebView)findViewById(R.id.webView);
        flVideoContainer = findViewById(R.id.flVideoContainer);

        wvBookPlay.getSettings().setJavaScriptEnabled(true);
        wvBookPlay.getSettings().setUseWideViewPort(true);
        wvBookPlay.getSettings().setLoadWithOverviewMode(true);
        wvBookPlay.getSettings().setAllowFileAccess(true);
        wvBookPlay.getSettings().setSupportZoom(true);
        wvBookPlay.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        try {
            if (Build.VERSION.SDK_INT >= 16) {
                Class<?> clazz = wvBookPlay.getSettings().getClass();
                Method method = clazz.getMethod("setAllowUniversalAccessFromFileURLs", boolean.class);
                if (method != null) {
                    method.invoke(wvBookPlay.getSettings(), true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        wvBookPlay.getSettings().setPluginState(WebSettings.PluginState.ON);
        wvBookPlay.getSettings().setDomStorageEnabled(true);// 必须保留，否则无法播放优酷视频，其他的OK
        wvBookPlay.setWebChromeClient(new MyWebChromeClient());// 重写一下，有的时候可能会出现问题

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            wvBookPlay.getSettings().setMixedContentMode(wvBookPlay.getSettings().MIXED_CONTENT_ALWAYS_ALLOW);
        }

        wvBookPlay.setWebViewClient(new WebViewClient(){

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                super.onReceivedSslError(view, handler, error);
                handler.proceed();
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    view.loadUrl(request.getUrl().toString());
                } else {
                    view.loadUrl(request.toString());
                }
                return true;
            }
        });
        String url = "https://www.cctalk.com/v/15574775126512?xh_preshareid=c57e1196-2200-4f17-9ea7-c1ce090681a9&xh_fshareuid=91446504&xh_preshareuid=91446504";

        CookieManager cookieManager = CookieManager.getInstance();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("android");

        cookieManager.setCookie(url, stringBuffer.toString());
        cookieManager.setAcceptCookie(true);

        wvBookPlay.loadUrl(url);
    }

    @Override
    public void onConfigurationChanged(Configuration config) {
        super.onConfigurationChanged(config);
        switch (config.orientation) {
            case Configuration.ORIENTATION_LANDSCAPE:
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                break;
            case Configuration.ORIENTATION_PORTRAIT:
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
                break;
        }
    }

    private class MyWebChromeClient extends WebChromeClient {
        WebChromeClient.CustomViewCallback mCallback;

        @Override
        public void onShowCustomView(View view, CustomViewCallback callback) {
            Log.i("ToVmp","onShowCustomView");
            fullScreen();

            wvBookPlay.setVisibility(View.GONE);
            flVideoContainer.setVisibility(View.VISIBLE);
            flVideoContainer.addView(view);
            mCallback = callback;
            super.onShowCustomView(view, callback);
        }

        @Override
        public void onHideCustomView() {
            Log.i("ToVmp","onHideCustomView");
            fullScreen();

            wvBookPlay.setVisibility(View.VISIBLE);
            flVideoContainer.setVisibility(View.GONE);
            flVideoContainer.removeAllViews();
            super.onHideCustomView();

        }
    }

    private void fullScreen() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            Log.i("ToVmp","横屏");
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            Log.i("ToVmp","竖屏");
        }
    }

    @Override
    protected void onDestroy() {
        if (wvBookPlay != null) {
            wvBookPlay.destroy();
        }
        super.onDestroy();
    }

    @NotNull
    @Override
    public String getLoggerTag() {
        return null;
    }
}

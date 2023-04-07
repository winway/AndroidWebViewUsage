package com.example.androidwebviewusage;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class LocalActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local);

        mWebView = findViewById(R.id.local_wv);

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowFileAccessFromFileURLs(true);

        mWebView.loadUrl("file:///android_asset/webview/myjs.html");

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl("file:///android_asset/webview/myjs.html");
                return false;
            }
        });

        mWebView.setWebChromeClient(new WebChromeClient());

        mWebView.addJavascriptInterface(new LocalJS(this), "winway");
    }

    public void onClick(View view) {
        mWebView.loadUrl("javascript:testAlert()");
    }
}
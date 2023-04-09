package com.example.androidwebviewusage;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class RemoteActivity extends AppCompatActivity {

    private static final String url = "https://www.smartcity.team/consultingskills/experience/shujukuyushujuhu/";

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote);

        mWebView = findViewById(R.id.remote_wv);

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowFileAccessFromFileURLs(true);

        mWebView.loadUrl(url);

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(url);
                return false;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                addImageClickListener(view);
            }
        });

        mWebView.setWebChromeClient(new WebChromeClient());

        mWebView.addJavascriptInterface(new CalledFromJSFunction(this), "winway");
    }

    private void addImageClickListener(WebView view) {
        mWebView.loadUrl("javascript:(function (){" +
                "           var imgObjs = document.getElementsByTagName(\"img\");" +
                "           var imgSrcs = [];" +
                "           for(var i=0; i<imgObjs.length; i++) {" +
                "               imgSrcs[i] = imgObjs[i].getAttribute('src');" +
                "           }" +
                "           for(var i=0; i<imgObjs.length; i++) {" +
                "               imgObjs[i].onclick = function() {" +
                "                   window.winway.clickImage(imgSrcs, this.getAttribute('src'));" +
                "               }" +
                "           }" +
                "       })()");
    }
}
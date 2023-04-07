package com.example.androidwebviewusage;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * @PackageName: com.example.androidwebviewusage
 * @ClassName: LocalJS
 * @Author: winwa
 * @Date: 2023/4/7 9:12
 * @Description:
 **/
public class LocalJS {

    Context mContext;

    public LocalJS(Context context) {
        mContext = context;
    }

    @JavascriptInterface
    public String hello(String str) {
        Toast.makeText(mContext, "Call hello() from js - " + str, Toast.LENGTH_SHORT).show();
        return str;
    }
}

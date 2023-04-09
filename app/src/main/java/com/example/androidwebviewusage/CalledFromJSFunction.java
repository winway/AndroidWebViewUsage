package com.example.androidwebviewusage;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * @PackageName: com.example.androidwebviewusage
 * @ClassName: LocalJS
 * @Author: winwa
 * @Date: 2023/4/7 9:12
 * @Description:
 **/
public class CalledFromJSFunction {
    private static final String TAG = "CalledFromJSFunction";

    Context mContext;

    public CalledFromJSFunction(Context context) {
        mContext = context;
    }

    @JavascriptInterface
    public String hello(String str) {
        Toast.makeText(mContext, "Call hello() from js - " + str, Toast.LENGTH_SHORT).show();
        return str;
    }

    @JavascriptInterface
    public void clickImage(String[] imgs, String imgUrl) {
        int position = 0;
        for (int i = 0; i < imgs.length; i++) {
            if (imgUrl.equals(imgs[i])) {
                position = i;
                break;
            }
        }

        Log.i(TAG, "clickImage: " + position + ", " + imgUrl);

        Intent intent = new Intent(mContext, ImageSlideActivity.class);
        intent.putExtra("position", position);
        intent.putExtra("imgs", imgs);
        mContext.startActivity(intent);
    }
}

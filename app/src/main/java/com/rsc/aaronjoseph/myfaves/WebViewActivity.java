package com.rsc.aaronjoseph.myfaves;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends Activity {


    String url;
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);


        url = getIntent().getStringExtra("urls");


        mWebView = (WebView) findViewById(R.id.webview);

        mWebView.loadUrl(url);

    }
}

package com.example.medicaresapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class HealthActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);
        webView=findViewById(R.id.web_view);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().getLoadsImagesAutomatically();
        webView.getSettings().getJavaScriptEnabled();
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl("http://www.gkfacts.in/search/label/Health%20Tips");
    }
}

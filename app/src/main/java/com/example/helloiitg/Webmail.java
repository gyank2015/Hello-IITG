package com.example.helloiitg;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.gt.helloiitg.R;

public class Webmail extends Activity {
    WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        getActionBar().setIcon(
                new ColorDrawable(getResources().getColor(
                        android.R.color.transparent)));

        setContentView(R.layout.webmail);

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        if (ni == null) {
            ScrollView ll = (ScrollView) findViewById(R.id.LLWebOff);
            ll.setVisibility(View.VISIBLE);
            Toast t = Toast.makeText(this, "No internet connectivity", Toast.LENGTH_SHORT);
            t.show();
            TextView tv = (TextView) findViewById(R.id.tvWebmailLink);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://webmail.iitg.ernet.in/"));
                    startActivity(i);
                }
            });
        } else {
            LinearLayout ll = (LinearLayout) findViewById(R.id.LLWebOn);
            ll.setVisibility(View.VISIBLE);
            wv = (WebView) findViewById(R.id.wvWemail);
            wv.setWebViewClient(new MyWebViewClient());
            wv.getSettings().setBuiltInZoomControls(true);
            wv.getSettings().setLoadWithOverviewMode(true);
            wv.getSettings().setUseWideViewPort(true);
            wv.loadUrl("https://webmail.iitg.ernet.in/");
        }
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (Uri.parse(url).getHost().contains("webmail")) {
                //My website so load in webview
                return false;
            }
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(i);
            return true;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //Checking if back button was pressed and history exists
        if ((keyCode == KeyEvent.KEYCODE_BACK) && wv.canGoBack()) {
            wv.goBack();
            return true;
        }
        //System general behaviour
        return super.onKeyDown(keyCode, event);
    }
}
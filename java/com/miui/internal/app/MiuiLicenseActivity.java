// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.miui.internal.app;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.webkit.*;
import com.android.internal.app.AlertActivity;
import com.android.internal.app.AlertController;

public class MiuiLicenseActivity extends AlertActivity
    implements android.content.DialogInterface.OnCancelListener, android.content.DialogInterface.OnClickListener {

    public MiuiLicenseActivity() {
    }

    private void showErrorAndFinish(String s) {
        mWebView.setVisibility(8);
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        Object aobj[] = new Object[1];
        aobj[0] = s;
        builder.setMessage(getString(0x60c002f, aobj)).setTitle(mTitle).setPositiveButton(0x104000a, this).setOnCancelListener(this).setCancelable(true).show();
    }

    public boolean isConnectivityActive() {
        ConnectivityManager connectivitymanager = (ConnectivityManager)getSystemService("connectivity");
        boolean flag;
        if(connectivitymanager != null && connectivitymanager.getActiveNetworkInfo() != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void onBackPressed() {
        if(mWebView.canGoBack())
            mWebView.goBack();
        else
            super.onBackPressed();
    }

    public void onCancel(DialogInterface dialoginterface) {
        finish();
    }

    public void onClick(DialogInterface dialoginterface, int i) {
        finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawableResource(0x106000d);
        mUrl = getIntent().getStringExtra(EXTRA_MIUI_DOC_URL);
        com.android.internal.app.AlertController.AlertParams alertparams;
        if(URL_MIUI_COPYRIGHT.equals(mUrl)) {
            mTitle = getString(0x60c0030);
            mCachePath = CACHE_URL_MIUI_COPYRIGHT;
        } else
        if(URL_MIUI_PRIVACY_POLICY.equals(mUrl)) {
            mTitle = getString(0x60c0032);
            mCachePath = CACHE_URL_MIUI_PRIVACY_POLICY;
        } else
        if(URL_MIUI_USER_AGREEMENT.equals(mUrl)) {
            mTitle = getString(0x60c0031);
            mCachePath = CACHE_URL_MIUI_USER_AGREEMENT;
        }
        mWebView = new WebView(this);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient() );
        if(isConnectivityActive())
            mWebView.loadUrl(mUrl);
        else
        if(TextUtils.isEmpty(mCachePath))
            showErrorAndFinish(mUrl);
        else
            mWebView.loadUrl(mCachePath);
        alertparams = super.mAlertParams;
        alertparams.mTitle = mTitle;
        alertparams.mView = mWebView;
        alertparams.mForceInverseBackground = true;
        setupAlert();
    }

    public static String CACHE_URL_MIUI_COPYRIGHT = "file:///system/etc/license/copyright.html";
    public static String CACHE_URL_MIUI_PRIVACY_POLICY = "file:///system/etc/license/privacy.html";
    public static String CACHE_URL_MIUI_USER_AGREEMENT = "file:///system/etc/license/eula.html";
    public static String EXTRA_MIUI_DOC_URL = "url";
    public static String URL_MIUI_COPYRIGHT = "http://www.miui.com/res/doc/copyright.html";
    public static String URL_MIUI_PRIVACY_POLICY = "http://product.xiaomi.com/policy/privacy.html";
    public static String URL_MIUI_USER_AGREEMENT = "http://product.xiaomi.com/policy/eula.html";
    private String mCachePath;
    private String mTitle;
    private String mUrl;
    private WebView mWebView;






}

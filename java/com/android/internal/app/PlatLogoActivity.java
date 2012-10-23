// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.app;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.*;
import android.widget.*;

public class PlatLogoActivity extends Activity {

    public PlatLogoActivity() {
    }

    private View makeView() {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        LinearLayout linearlayout = new LinearLayout(this);
        linearlayout.setOrientation(1);
        linearlayout.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -2));
        int i = (int)(8F * displaymetrics.density);
        linearlayout.setPadding(i, i, i, i);
        Typeface typeface = Typeface.create("sans-serif-light", 0);
        Typeface typeface1 = Typeface.create("sans-serif", 1);
        float f = 14F * displaymetrics.density;
        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-2, -2);
        layoutparams.gravity = 1;
        layoutparams.bottomMargin = (int)(-4F * displaymetrics.density);
        TextView textview = new TextView(this);
        if(typeface != null)
            textview.setTypeface(typeface);
        textview.setTextSize(1.25F * f);
        textview.setTextColor(-1);
        textview.setShadowLayer(4F * displaymetrics.density, 0.0F, 2.0F * displaymetrics.density, 0x66000000);
        textview.setText((new StringBuilder()).append("Android ").append(android.os.Build.VERSION.RELEASE).toString());
        linearlayout.addView(textview, layoutparams);
        TextView textview1 = new TextView(this);
        if(typeface1 != null)
            textview1.setTypeface(typeface1);
        textview1.setTextSize(f);
        textview1.setTextColor(-1);
        textview1.setShadowLayer(4F * displaymetrics.density, 0.0F, 2.0F * displaymetrics.density, 0x66000000);
        textview1.setText("JELLY BEAN");
        linearlayout.addView(textview1, layoutparams);
        return linearlayout;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mToast = Toast.makeText(this, "", 1);
        mToast.setView(makeView());
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        mContent = new ImageView(this);
        mContent.setImageResource(0x1080452);
        mContent.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
        int i = (int)(32F * displaymetrics.density);
        mContent.setPadding(i, i, i, i);
        mContent.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view) {
                mToast.show();
                mContent.setImageResource(0x1080451);
            }

            final PlatLogoActivity this$0;

             {
                this$0 = PlatLogoActivity.this;
                super();
            }
        });
        mContent.setOnLongClickListener(new android.view.View.OnLongClickListener() {

            public boolean onLongClick(View view) {
                try {
                    startActivity((new Intent("android.intent.action.MAIN")).setFlags(0x10808000).addCategory("com.android.internal.category.PLATLOGO"));
                }
                catch(ActivityNotFoundException activitynotfoundexception) {
                    Log.e("PlatLogoActivity", "Couldn't find a bag of beans.");
                }
                finish();
                return true;
            }

            final PlatLogoActivity this$0;

             {
                this$0 = PlatLogoActivity.this;
                super();
            }
        });
        setContentView(mContent);
    }

    ImageView mContent;
    int mCount;
    final Handler mHandler = new Handler();
    Toast mToast;
}

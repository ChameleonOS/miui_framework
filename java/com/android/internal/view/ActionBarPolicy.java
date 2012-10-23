// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.view;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;

public class ActionBarPolicy {

    private ActionBarPolicy(Context context) {
        mContext = context;
    }

    public static ActionBarPolicy get(Context context) {
        return new ActionBarPolicy(context);
    }

    public boolean enableHomeButtonByDefault() {
        boolean flag;
        if(mContext.getApplicationInfo().targetSdkVersion < 14)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public int getEmbeddedMenuWidthLimit() {
        return mContext.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int getMaxActionButtons() {
        return mContext.getResources().getInteger(0x10e0033);
    }

    public int getStackedTabMaxWidth() {
        return mContext.getResources().getDimensionPixelSize(0x1050051);
    }

    public int getTabContainerHeight() {
        TypedArray typedarray = mContext.obtainStyledAttributes(null, com.android.internal.R.styleable.ActionBar, 0x10102ce, 0);
        int i = typedarray.getLayoutDimension(4, 0);
        Resources resources = mContext.getResources();
        if(!hasEmbeddedTabs())
            i = Math.min(i, resources.getDimensionPixelSize(0x1050050));
        typedarray.recycle();
        return i;
    }

    public boolean hasEmbeddedTabs() {
        boolean flag;
        if(mContext.getApplicationInfo().targetSdkVersion >= 16)
            flag = mContext.getResources().getBoolean(0x1110000);
        else
            flag = mContext.getResources().getBoolean(0x1110001);
        return flag;
    }

    public boolean showsOverflowMenuButton() {
        boolean flag;
        if(!ViewConfiguration.get(mContext).hasPermanentMenuKey())
            flag = true;
        else
            flag = false;
        return flag;
    }

    private Context mContext;
}

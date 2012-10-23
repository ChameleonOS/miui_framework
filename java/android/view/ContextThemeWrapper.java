// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;

// Referenced classes of package android.view:
//            LayoutInflater

public class ContextThemeWrapper extends ContextWrapper {

    public ContextThemeWrapper() {
        super(null);
    }

    public ContextThemeWrapper(Context context, int i) {
        super(context);
        mBase = context;
        mThemeResource = i;
    }

    private void initializeTheme() {
        boolean flag;
        if(mTheme == null)
            flag = true;
        else
            flag = false;
        if(flag) {
            mTheme = getResources().newTheme();
            android.content.res.Resources.Theme theme = mBase.getTheme();
            if(theme != null)
                mTheme.setTo(theme);
        }
        onApplyThemeResource(mTheme, mThemeResource, flag);
    }

    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        mBase = context;
    }

    public Object getSystemService(String s) {
        Object obj;
        if("layout_inflater".equals(s)) {
            if(mInflater == null)
                mInflater = LayoutInflater.from(mBase).cloneInContext(this);
            obj = mInflater;
        } else {
            obj = mBase.getSystemService(s);
        }
        return obj;
    }

    public android.content.res.Resources.Theme getTheme() {
        android.content.res.Resources.Theme theme;
        if(mTheme != null) {
            theme = mTheme;
        } else {
            mThemeResource = Resources.selectDefaultTheme(mThemeResource, getApplicationInfo().targetSdkVersion);
            initializeTheme();
            theme = mTheme;
        }
        return theme;
    }

    public int getThemeResId() {
        return mThemeResource;
    }

    protected void onApplyThemeResource(android.content.res.Resources.Theme theme, int i, boolean flag) {
        theme.applyStyle(i, true);
    }

    public void setTheme(int i) {
        mThemeResource = i;
        initializeTheme();
    }

    private Context mBase;
    private LayoutInflater mInflater;
    private android.content.res.Resources.Theme mTheme;
    private int mThemeResource;
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.view;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.*;
import android.util.Log;
import android.view.IWindowManager;

public final class RotationPolicy {
    public static abstract class RotationPolicyListener {

        public abstract void onChange();

        final ContentObserver mObserver = new ContentObserver(new Handler()) {

            public void onChange(boolean flag, Uri uri) {
                RotationPolicyListener.this.onChange();
            }

            final RotationPolicyListener this$0;

                 {
                    this$0 = RotationPolicyListener.this;
                    super(handler);
                }
        };

        public RotationPolicyListener() {
        }
    }


    private RotationPolicy() {
    }

    public static boolean isRotationLockToggleSupported(Context context) {
        boolean flag;
        if(context.getResources().getConfiguration().smallestScreenWidthDp >= 600)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isRotationLockToggleVisible(Context context) {
        boolean flag = false;
        if(isRotationLockToggleSupported(context) && android.provider.Settings.System.getInt(context.getContentResolver(), "hide_rotation_lock_toggle_for_accessibility", 0) == 0)
            flag = true;
        return flag;
    }

    public static boolean isRotationLocked(Context context) {
        boolean flag = false;
        if(android.provider.Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation", 0) == 0)
            flag = true;
        return flag;
    }

    public static void registerRotationPolicyListener(Context context, RotationPolicyListener rotationpolicylistener) {
        context.getContentResolver().registerContentObserver(android.provider.Settings.System.getUriFor("accelerometer_rotation"), false, rotationpolicylistener.mObserver);
        context.getContentResolver().registerContentObserver(android.provider.Settings.System.getUriFor("hide_rotation_lock_toggle_for_accessibility"), false, rotationpolicylistener.mObserver);
    }

    public static void setRotationLock(Context context, final boolean enabled) {
        android.provider.Settings.System.putInt(context.getContentResolver(), "hide_rotation_lock_toggle_for_accessibility", 0);
        AsyncTask.execute(new Runnable() {

            public void run() {
                try {
                    IWindowManager iwindowmanager = android.view.IWindowManager.Stub.asInterface(ServiceManager.getService("window"));
                    if(enabled)
                        iwindowmanager.freezeRotation(-1);
                    else
                        iwindowmanager.thawRotation();
                }
                catch(RemoteException remoteexception) {
                    Log.w("RotationPolicy", "Unable to save auto-rotate setting");
                }
            }

            final boolean val$enabled;

             {
                enabled = flag;
                super();
            }
        });
    }

    public static void setRotationLockForAccessibility(Context context, final boolean enabled) {
        ContentResolver contentresolver = context.getContentResolver();
        int i;
        if(enabled)
            i = 1;
        else
            i = 0;
        android.provider.Settings.System.putInt(contentresolver, "hide_rotation_lock_toggle_for_accessibility", i);
        AsyncTask.execute(new Runnable() {

            public void run() {
                try {
                    IWindowManager iwindowmanager = android.view.IWindowManager.Stub.asInterface(ServiceManager.getService("window"));
                    if(enabled)
                        iwindowmanager.freezeRotation(0);
                    else
                        iwindowmanager.thawRotation();
                }
                catch(RemoteException remoteexception) {
                    Log.w("RotationPolicy", "Unable to save auto-rotate setting");
                }
            }

            final boolean val$enabled;

             {
                enabled = flag;
                super();
            }
        });
    }

    public static void unregisterRotationPolicyListener(Context context, RotationPolicyListener rotationpolicylistener) {
        context.getContentResolver().unregisterContentObserver(rotationpolicylistener.mObserver);
    }

    private static final String TAG = "RotationPolicy";
}

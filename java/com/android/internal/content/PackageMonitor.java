// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.content;

import android.content.*;
import android.net.Uri;
import android.os.*;
import java.util.HashSet;

public abstract class PackageMonitor extends BroadcastReceiver {

    public PackageMonitor() {
        mTempArray = new String[1];
    }

    public boolean anyPackagesAppearing() {
        boolean flag;
        if(mAppearingPackages != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean anyPackagesDisappearing() {
        boolean flag;
        if(mDisappearingPackages != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean didSomePackagesChange() {
        return mSomePackagesChanged;
    }

    String getPackageName(Intent intent) {
        Uri uri = intent.getData();
        String s;
        if(uri != null)
            s = uri.getSchemeSpecificPart();
        else
            s = null;
        return s;
    }

    public Handler getRegisteredHandler() {
        return mRegisteredHandler;
    }

    public int isPackageAppearing(String s) {
        int j;
        if(mAppearingPackages == null)
            break MISSING_BLOCK_LABEL_46;
        j = -1 + mAppearingPackages.length;
_L3:
        if(j < 0)
            break MISSING_BLOCK_LABEL_46;
        if(!s.equals(mAppearingPackages[j])) goto _L2; else goto _L1
_L1:
        int i = mChangeType;
_L4:
        return i;
_L2:
        j--;
          goto _L3
        i = 0;
          goto _L4
    }

    public int isPackageDisappearing(String s) {
        int j;
        if(mDisappearingPackages == null)
            break MISSING_BLOCK_LABEL_46;
        j = -1 + mDisappearingPackages.length;
_L3:
        if(j < 0)
            break MISSING_BLOCK_LABEL_46;
        if(!s.equals(mDisappearingPackages[j])) goto _L2; else goto _L1
_L1:
        int i = mChangeType;
_L4:
        return i;
_L2:
        j--;
          goto _L3
        i = 0;
          goto _L4
    }

    public boolean isPackageModified(String s) {
        int i;
        if(mModifiedPackages == null)
            break MISSING_BLOCK_LABEL_43;
        i = -1 + mModifiedPackages.length;
_L3:
        if(i < 0)
            break MISSING_BLOCK_LABEL_43;
        if(!s.equals(mModifiedPackages[i])) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        i--;
          goto _L3
        flag = false;
          goto _L4
    }

    boolean isPackageUpdating(String s) {
        HashSet hashset = mUpdatingPackages;
        hashset;
        JVM INSTR monitorenter ;
        boolean flag = mUpdatingPackages.contains(s);
        return flag;
    }

    public void onBeginPackageChanges() {
    }

    public void onFinishPackageChanges() {
    }

    public boolean onHandleForceStop(Intent intent, String as[], int i, boolean flag) {
        return false;
    }

    public void onPackageAdded(String s, int i) {
    }

    public void onPackageAppeared(String s, int i) {
    }

    public void onPackageChanged(String s, int i, String as[]) {
    }

    public void onPackageDisappeared(String s, int i) {
    }

    public void onPackageModified(String s) {
    }

    public void onPackageRemoved(String s, int i) {
    }

    public void onPackageUpdateFinished(String s, int i) {
    }

    public void onPackageUpdateStarted(String s, int i) {
    }

    public void onPackagesAvailable(String as[]) {
    }

    public void onPackagesUnavailable(String as[]) {
    }

    public void onReceive(Context context, Intent intent) {
        String s;
        onBeginPackageChanges();
        mAppearingPackages = null;
        mDisappearingPackages = null;
        mSomePackagesChanged = false;
        s = intent.getAction();
        if(!"android.intent.action.PACKAGE_ADDED".equals(s)) goto _L2; else goto _L1
_L1:
        String s3 = getPackageName(intent);
        int i1 = intent.getIntExtra("android.intent.extra.UID", 0);
        mSomePackagesChanged = true;
        if(s3 != null) {
            mAppearingPackages = mTempArray;
            mTempArray[0] = s3;
            if(intent.getBooleanExtra("android.intent.extra.REPLACING", false)) {
                mModifiedPackages = mTempArray;
                mChangeType = 1;
                onPackageUpdateFinished(s3, i1);
                onPackageModified(s3);
            } else {
                mChangeType = 3;
                onPackageAdded(s3, i1);
            }
            onPackageAppeared(s3, mChangeType);
            if(mChangeType == 1)
                synchronized(mUpdatingPackages) {
                    mUpdatingPackages.remove(s3);
                }
        }
_L4:
        if(mSomePackagesChanged)
            onSomePackagesChanged();
        onFinishPackageChanges();
        return;
        exception1;
        hashset1;
        JVM INSTR monitorexit ;
        throw exception1;
_L2:
        if("android.intent.action.PACKAGE_REMOVED".equals(s)) {
            String s2 = getPackageName(intent);
            int l = intent.getIntExtra("android.intent.extra.UID", 0);
            if(s2 != null) {
                mDisappearingPackages = mTempArray;
                mTempArray[0] = s2;
                if(intent.getBooleanExtra("android.intent.extra.REPLACING", false)) {
                    mChangeType = 1;
                    synchronized(mUpdatingPackages) { }
                    onPackageUpdateStarted(s2, l);
                } else {
                    mChangeType = 3;
                    mSomePackagesChanged = true;
                    onPackageRemoved(s2, l);
                }
                onPackageDisappeared(s2, mChangeType);
            }
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_315;
        exception;
        hashset;
        JVM INSTR monitorexit ;
        throw exception;
        if("android.intent.action.PACKAGE_CHANGED".equals(s)) {
            String s1 = getPackageName(intent);
            int k = intent.getIntExtra("android.intent.extra.UID", 0);
            String as3[] = intent.getStringArrayExtra("android.intent.extra.changed_component_name_list");
            if(s1 != null) {
                mModifiedPackages = mTempArray;
                mTempArray[0] = s1;
                onPackageChanged(s1, k, as3);
                onPackageModified(s1);
            }
            continue; /* Loop/switch isn't completed */
        }
        if("android.intent.action.QUERY_PACKAGE_RESTART".equals(s)) {
            mDisappearingPackages = intent.getStringArrayExtra("android.intent.extra.PACKAGES");
            mChangeType = 2;
            if(onHandleForceStop(intent, mDisappearingPackages, intent.getIntExtra("android.intent.extra.UID", 0), false))
                setResultCode(-1);
            continue; /* Loop/switch isn't completed */
        }
        if("android.intent.action.PACKAGE_RESTARTED".equals(s)) {
            String as2[] = new String[1];
            as2[0] = getPackageName(intent);
            mDisappearingPackages = as2;
            mChangeType = 2;
            onHandleForceStop(intent, mDisappearingPackages, intent.getIntExtra("android.intent.extra.UID", 0), true);
            continue; /* Loop/switch isn't completed */
        }
        if(!"android.intent.action.UID_REMOVED".equals(s))
            break; /* Loop/switch isn't completed */
        onUidRemoved(intent.getIntExtra("android.intent.extra.UID", 0));
        if(true) goto _L4; else goto _L3
_L3:
        if(!"android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE".equals(s))
            break; /* Loop/switch isn't completed */
        String as1[] = intent.getStringArrayExtra("android.intent.extra.changed_package_list");
        mAppearingPackages = as1;
        mChangeType = 2;
        mSomePackagesChanged = true;
        if(as1 != null) {
            onPackagesAvailable(as1);
            int j = 0;
            while(j < as1.length)  {
                onPackageAppeared(as1[j], 2);
                j++;
            }
        }
        if(true) goto _L4; else goto _L5
_L5:
        if("android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE".equals(s)) {
            String as[] = intent.getStringArrayExtra("android.intent.extra.changed_package_list");
            mDisappearingPackages = as;
            mChangeType = 2;
            mSomePackagesChanged = true;
            if(as != null) {
                onPackagesUnavailable(as);
                int i = 0;
                while(i < as.length)  {
                    onPackageDisappeared(as[i], 2);
                    i++;
                }
            }
        }
        if(true) goto _L4; else goto _L6
_L6:
    }

    public void onSomePackagesChanged() {
    }

    public void onUidRemoved(int i) {
    }

    public void register(Context context, Looper looper, boolean flag) {
        if(mRegisteredContext != null)
            throw new IllegalStateException("Already registered");
        mRegisteredContext = context;
        if(looper == null)
            synchronized(sLock) {
                if(sBackgroundThread == null) {
                    sBackgroundThread = new HandlerThread("PackageMonitor", 10);
                    sBackgroundThread.start();
                    sBackgroundHandler = new Handler(sBackgroundThread.getLooper());
                }
                mRegisteredHandler = sBackgroundHandler;
            }
        else
            mRegisteredHandler = new Handler(looper);
        context.registerReceiver(this, sPackageFilt, null, mRegisteredHandler);
        context.registerReceiver(this, sNonDataFilt, null, mRegisteredHandler);
        if(flag)
            context.registerReceiver(this, sExternalFilt, null, mRegisteredHandler);
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void register(Context context, boolean flag) {
        register(context, null, flag);
    }

    public void unregister() {
        if(mRegisteredContext == null) {
            throw new IllegalStateException("Not registered");
        } else {
            mRegisteredContext.unregisterReceiver(this);
            mRegisteredContext = null;
            return;
        }
    }

    public static final int PACKAGE_PERMANENT_CHANGE = 3;
    public static final int PACKAGE_TEMPORARY_CHANGE = 2;
    public static final int PACKAGE_UNCHANGED = 0;
    public static final int PACKAGE_UPDATING = 1;
    static Handler sBackgroundHandler;
    static HandlerThread sBackgroundThread;
    static final IntentFilter sExternalFilt;
    static final Object sLock = new Object();
    static final IntentFilter sNonDataFilt;
    static final IntentFilter sPackageFilt;
    String mAppearingPackages[];
    int mChangeType;
    String mDisappearingPackages[];
    String mModifiedPackages[];
    Context mRegisteredContext;
    Handler mRegisteredHandler;
    boolean mSomePackagesChanged;
    String mTempArray[];
    final HashSet mUpdatingPackages = new HashSet();

    static  {
        sPackageFilt = new IntentFilter();
        sNonDataFilt = new IntentFilter();
        sExternalFilt = new IntentFilter();
        sPackageFilt.addAction("android.intent.action.PACKAGE_ADDED");
        sPackageFilt.addAction("android.intent.action.PACKAGE_REMOVED");
        sPackageFilt.addAction("android.intent.action.PACKAGE_CHANGED");
        sPackageFilt.addAction("android.intent.action.QUERY_PACKAGE_RESTART");
        sPackageFilt.addAction("android.intent.action.PACKAGE_RESTARTED");
        sPackageFilt.addAction("android.intent.action.UID_REMOVED");
        sPackageFilt.addDataScheme("package");
        sNonDataFilt.addAction("android.intent.action.UID_REMOVED");
        sExternalFilt.addAction("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE");
        sExternalFilt.addAction("android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE");
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.google.android.mms.util;

import android.content.Context;
import android.drm.DrmManagerClient;
import android.util.Log;

public class DownloadDrmHelper {

    public DownloadDrmHelper() {
    }

    public static String getOriginalMimeType(Context context, String s, String s1) {
        String s2;
        DrmManagerClient drmmanagerclient;
        s2 = s1;
        drmmanagerclient = new DrmManagerClient(context);
        String s3;
        if(!drmmanagerclient.canHandle(s, null))
            break MISSING_BLOCK_LABEL_33;
        s3 = drmmanagerclient.getOriginalMimeType(s);
        s2 = s3;
_L2:
        return s2;
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        Log.w("DownloadDrmHelper", "Can't get original mime type since path is null or empty string.");
        continue; /* Loop/switch isn't completed */
        IllegalStateException illegalstateexception;
        illegalstateexception;
        Log.w("DownloadDrmHelper", "DrmManagerClient didn't initialize properly.");
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static boolean isDrmConvertNeeded(String s) {
        return "application/vnd.oma.drm.message".equals(s);
    }

    public static boolean isDrmMimeType(Context context, String s) {
        boolean flag;
        flag = false;
        if(context == null)
            break MISSING_BLOCK_LABEL_42;
        boolean flag1;
        DrmManagerClient drmmanagerclient = new DrmManagerClient(context);
        if(drmmanagerclient == null || s == null || s.length() <= 0)
            break MISSING_BLOCK_LABEL_42;
        flag1 = drmmanagerclient.canHandle("", s);
        flag = flag1;
_L2:
        return flag;
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        Log.w("DownloadDrmHelper", "DrmManagerClient instance could not be created, context is Illegal.");
        continue; /* Loop/switch isn't completed */
        IllegalStateException illegalstateexception;
        illegalstateexception;
        Log.w("DownloadDrmHelper", "DrmManagerClient didn't initialize properly.");
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static String modifyDrmFwLockFileExtension(String s) {
        if(s != null) {
            int i = s.lastIndexOf(".");
            if(i != -1)
                s = s.substring(0, i);
            s = s.concat(".fl");
        }
        return s;
    }

    public static final String EXTENSION_DRM_MESSAGE = ".dm";
    public static final String EXTENSION_INTERNAL_FWDL = ".fl";
    public static final String MIMETYPE_DRM_MESSAGE = "application/vnd.oma.drm.message";
    private static final String TAG = "DownloadDrmHelper";
}

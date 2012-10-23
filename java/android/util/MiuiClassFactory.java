// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;

import android.app.DownloadManager;
import android.app.MiuiDownloadManager;
import android.content.ContentResolver;

public class MiuiClassFactory {

    public MiuiClassFactory() {
    }

    public static DownloadManager newDownloadManager(ContentResolver contentresolver, String s) {
        return new MiuiDownloadManager(contentresolver, s);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.google.android.mms.util;

import android.content.Context;
import android.drm.DrmConvertedStatus;
import android.drm.DrmManagerClient;
import android.util.Log;
import java.io.*;

public class DrmConvertSession {

    private DrmConvertSession(DrmManagerClient drmmanagerclient, int i) {
        mDrmClient = drmmanagerclient;
        mConvertSessionId = i;
    }

    public static DrmConvertSession open(Context context, String s) {
        DrmManagerClient drmmanagerclient;
        int i;
        drmmanagerclient = null;
        i = -1;
        if(context == null || s == null || s.equals("")) goto _L2; else goto _L1
_L1:
        DrmManagerClient drmmanagerclient1 = new DrmManagerClient(context);
        int j = drmmanagerclient1.openConvertSession(s);
        i = j;
_L3:
        drmmanagerclient = drmmanagerclient1;
_L2:
        DrmConvertSession drmconvertsession;
        IllegalStateException illegalstateexception;
        IllegalStateException illegalstateexception1;
        IllegalArgumentException illegalargumentexception;
        IllegalArgumentException illegalargumentexception1;
        if(drmmanagerclient == null || i < 0)
            drmconvertsession = null;
        else
            drmconvertsession = new DrmConvertSession(drmmanagerclient, i);
        return drmconvertsession;
        illegalargumentexception1;
        Log.w("DrmConvertSession", (new StringBuilder()).append("Conversion of Mimetype: ").append(s).append(" is not supported.").toString(), illegalargumentexception1);
          goto _L3
        illegalargumentexception;
        drmmanagerclient = drmmanagerclient1;
_L5:
        Log.w("DrmConvertSession", "DrmManagerClient instance could not be created, context is Illegal.");
          goto _L2
        illegalstateexception;
        Log.w("DrmConvertSession", "Could not access Open DrmFramework.", illegalstateexception);
          goto _L3
        illegalstateexception1;
        drmmanagerclient = drmmanagerclient1;
_L4:
        Log.w("DrmConvertSession", "DrmManagerClient didn't initialize properly.");
          goto _L2
        IllegalStateException illegalstateexception2;
        illegalstateexception2;
          goto _L4
        IllegalArgumentException illegalargumentexception2;
        illegalargumentexception2;
          goto _L5
    }

    public int close(String s) {
        char c = '\u01EB';
        if(mDrmClient == null || mConvertSessionId < 0) goto _L2; else goto _L1
_L1:
        DrmConvertedStatus drmconvertedstatus = mDrmClient.closeConvertSession(mConvertSessionId);
        if(drmconvertedstatus == null || drmconvertedstatus.statusCode != 1) goto _L4; else goto _L3
_L3:
        byte abyte0[] = drmconvertedstatus.convertedData;
        if(abyte0 != null) goto _L5; else goto _L4
_L4:
        c = '\u0196';
_L2:
        return c;
_L5:
        RandomAccessFile randomaccessfile = null;
        RandomAccessFile randomaccessfile1 = new RandomAccessFile(s, "rw");
        randomaccessfile1.seek(drmconvertedstatus.offset);
        randomaccessfile1.write(drmconvertedstatus.convertedData);
        c = '\310';
        if(randomaccessfile1 == null) goto _L2; else goto _L6
_L6:
        randomaccessfile1.close();
          goto _L2
        IOException ioexception6;
        ioexception6;
        c = '\u01EC';
        try {
            Log.w("DrmConvertSession", (new StringBuilder()).append("Failed to close File:").append(s).append(".").toString(), ioexception6);
        }
        catch(IllegalStateException illegalstateexception) {
            Log.w("DrmConvertSession", (new StringBuilder()).append("Could not close convertsession. Convertsession: ").append(mConvertSessionId).toString(), illegalstateexception);
        }
          goto _L2
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
_L16:
        c = '\u01EC';
        Log.w("DrmConvertSession", (new StringBuilder()).append("File: ").append(s).append(" could not be found.").toString(), filenotfoundexception);
        if(randomaccessfile == null) goto _L2; else goto _L7
_L7:
        randomaccessfile.close();
          goto _L2
        IOException ioexception1;
        ioexception1;
        c = '\u01EC';
        Log.w("DrmConvertSession", (new StringBuilder()).append("Failed to close File:").append(s).append(".").toString(), ioexception1);
          goto _L2
        IOException ioexception2;
        ioexception2;
_L15:
        c = '\u01EC';
        Log.w("DrmConvertSession", (new StringBuilder()).append("Could not access File: ").append(s).append(" .").toString(), ioexception2);
        if(randomaccessfile == null) goto _L2; else goto _L8
_L8:
        randomaccessfile.close();
          goto _L2
        IOException ioexception3;
        ioexception3;
        c = '\u01EC';
        Log.w("DrmConvertSession", (new StringBuilder()).append("Failed to close File:").append(s).append(".").toString(), ioexception3);
          goto _L2
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
_L14:
        c = '\u01EC';
        Log.w("DrmConvertSession", "Could not open file in mode: rw", illegalargumentexception);
        if(randomaccessfile == null) goto _L2; else goto _L9
_L9:
        randomaccessfile.close();
          goto _L2
        IOException ioexception4;
        ioexception4;
        c = '\u01EC';
        Log.w("DrmConvertSession", (new StringBuilder()).append("Failed to close File:").append(s).append(".").toString(), ioexception4);
          goto _L2
        SecurityException securityexception;
        securityexception;
_L13:
        Log.w("DrmConvertSession", (new StringBuilder()).append("Access to File: ").append(s).append(" was denied denied by SecurityManager.").toString(), securityexception);
        if(randomaccessfile == null) goto _L2; else goto _L10
_L10:
        randomaccessfile.close();
          goto _L2
        IOException ioexception5;
        ioexception5;
        c = '\u01EC';
        Log.w("DrmConvertSession", (new StringBuilder()).append("Failed to close File:").append(s).append(".").toString(), ioexception5);
          goto _L2
        Exception exception;
        exception;
_L12:
        if(randomaccessfile == null)
            break MISSING_BLOCK_LABEL_544;
        try {
            randomaccessfile.close();
        }
        catch(IOException ioexception) {
            c = '\u01EC';
            Log.w("DrmConvertSession", (new StringBuilder()).append("Failed to close File:").append(s).append(".").toString(), ioexception);
        }
        throw exception;
        exception;
        randomaccessfile = randomaccessfile1;
        if(true) goto _L12; else goto _L11
_L11:
        securityexception;
        randomaccessfile = randomaccessfile1;
          goto _L13
        illegalargumentexception;
        randomaccessfile = randomaccessfile1;
          goto _L14
        ioexception2;
        randomaccessfile = randomaccessfile1;
          goto _L15
        filenotfoundexception;
        randomaccessfile = randomaccessfile1;
          goto _L16
    }

    public byte[] convert(byte abyte0[], int i) {
        byte abyte1[];
        abyte1 = null;
        if(abyte0 == null)
            break MISSING_BLOCK_LABEL_163;
        if(i == abyte0.length) goto _L2; else goto _L1
_L1:
        DrmConvertedStatus drmconvertedstatus1;
        byte abyte2[] = new byte[i];
        System.arraycopy(abyte0, 0, abyte2, 0, i);
        drmconvertedstatus1 = mDrmClient.convertData(mConvertSessionId, abyte2);
_L3:
        if(drmconvertedstatus1 != null && drmconvertedstatus1.statusCode == 1 && drmconvertedstatus1.convertedData != null)
            abyte1 = drmconvertedstatus1.convertedData;
        break MISSING_BLOCK_LABEL_173;
_L2:
        DrmConvertedStatus drmconvertedstatus = mDrmClient.convertData(mConvertSessionId, abyte0);
        drmconvertedstatus1 = drmconvertedstatus;
          goto _L3
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        Log.w("DrmConvertSession", (new StringBuilder()).append("Buffer with data to convert is illegal. Convertsession: ").append(mConvertSessionId).toString(), illegalargumentexception);
        break MISSING_BLOCK_LABEL_173;
        IllegalStateException illegalstateexception;
        illegalstateexception;
        Log.w("DrmConvertSession", (new StringBuilder()).append("Could not convert data. Convertsession: ").append(mConvertSessionId).toString(), illegalstateexception);
        break MISSING_BLOCK_LABEL_173;
        throw new IllegalArgumentException("Parameter inBuffer is null");
        return abyte1;
    }

    private static final String TAG = "DrmConvertSession";
    private int mConvertSessionId;
    private DrmManagerClient mDrmClient;
}

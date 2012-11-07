// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;

// Referenced classes of package com.android.internal.telephony:
//            IccProvider, IIccPhoneBook

public class MiuiIccProvider extends IccProvider {

    public MiuiIccProvider() {
    }

    private MatrixCursor getAdnCapacity() {
        int i;
        MatrixCursor matrixcursor;
        i = 0;
        String as[] = new String[1];
        as[0] = "count";
        matrixcursor = new MatrixCursor(as, 1);
        int j;
        IIccPhoneBook iiccphonebook = IIccPhoneBook.Stub.asInterface(ServiceManager.getService("simphonebook"));
        if(iiccphonebook == null)
            break MISSING_BLOCK_LABEL_49;
        j = iiccphonebook.getAdnCapacity();
        i = j;
_L2:
        Object aobj[] = new Object[1];
        aobj[0] = Integer.valueOf(i);
        matrixcursor.addRow(aobj);
        return matrixcursor;
        SecurityException securityexception;
        securityexception;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private MatrixCursor getFreeAdn() {
        int i;
        MatrixCursor matrixcursor;
        i = 0;
        String as[] = new String[1];
        as[0] = "count";
        matrixcursor = new MatrixCursor(as, 1);
        int j;
        IIccPhoneBook iiccphonebook = IIccPhoneBook.Stub.asInterface(ServiceManager.getService("simphonebook"));
        if(iiccphonebook == null)
            break MISSING_BLOCK_LABEL_49;
        j = iiccphonebook.getFreeAdn();
        i = j;
_L2:
        Object aobj[] = new Object[1];
        aobj[0] = Integer.valueOf(i);
        matrixcursor.addRow(aobj);
        return matrixcursor;
        SecurityException securityexception;
        securityexception;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private void log(String s) {
        Log.d("IccProvider", (new StringBuilder()).append("[IccProvider] ").append(s).toString());
    }

    public String getType(Uri uri) {
        getURL_MATCHER().match(uri);
        JVM INSTR tableswitch 4 5: default 28
    //                   4 36
    //                   5 36;
           goto _L1 _L2 _L2
_L1:
        String s = super.getType(uri);
_L4:
        return s;
_L2:
        s = "vnd.android.cursor.dir/sim-contact";
        if(true) goto _L4; else goto _L3
_L3:
    }

    public Cursor query(Uri uri, String as[], String s, String as1[], String s1) {
        getURL_MATCHER().match(uri);
        JVM INSTR tableswitch 4 5: default 28
    //                   4 44
    //                   5 53;
           goto _L1 _L2 _L3
_L1:
        Object obj = super.query(uri, as, s, as1, s1);
_L5:
        return ((Cursor) (obj));
_L2:
        obj = getFreeAdn();
        continue; /* Loop/switch isn't completed */
_L3:
        obj = getAdnCapacity();
        if(true) goto _L5; else goto _L4
_L4:
    }

    private static final int ADNCAPACITY = 5;
    private static final boolean DBG = false;
    private static final int FREEADN = 4;
    private static final String TAG = "IccProvider";

    static  {
        getURL_MATCHER().addURI("icc", "freeadn", 4);
        getURL_MATCHER().addURI("icc", "adncapacity", 5);
    }
}

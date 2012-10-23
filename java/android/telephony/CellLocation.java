// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.telephony;

import android.os.*;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.android.internal.telephony.ITelephony;

// Referenced classes of package android.telephony:
//            TelephonyManager

public abstract class CellLocation {

    public CellLocation() {
    }

    public static CellLocation getEmpty() {
        TelephonyManager.getDefault().getCurrentPhoneType();
        JVM INSTR tableswitch 1 2: default 28
    //                   1 43
    //                   2 32;
           goto _L1 _L2 _L3
_L1:
        Object obj = null;
_L5:
        return ((CellLocation) (obj));
_L3:
        obj = new CdmaCellLocation();
        continue; /* Loop/switch isn't completed */
_L2:
        obj = new GsmCellLocation();
        if(true) goto _L5; else goto _L4
_L4:
    }

    public static CellLocation newFromBundle(Bundle bundle) {
        TelephonyManager.getDefault().getCurrentPhoneType();
        JVM INSTR tableswitch 1 2: default 28
    //                   1 44
    //                   2 32;
           goto _L1 _L2 _L3
_L1:
        Object obj = null;
_L5:
        return ((CellLocation) (obj));
_L3:
        obj = new CdmaCellLocation(bundle);
        continue; /* Loop/switch isn't completed */
_L2:
        obj = new GsmCellLocation(bundle);
        if(true) goto _L5; else goto _L4
_L4:
    }

    public static void requestLocationUpdate() {
        ITelephony itelephony = com.android.internal.telephony.ITelephony.Stub.asInterface(ServiceManager.getService("phone"));
        if(itelephony != null)
            itelephony.updateServiceLocation();
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public abstract void fillInNotifierBundle(Bundle bundle);

    public abstract boolean isEmpty();
}

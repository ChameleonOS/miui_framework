// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.telephony.CellInfo;

// Referenced classes of package com.android.internal.telephony:
//            Phone

public interface PhoneNotifier {

    public abstract void notifyCallForwardingChanged(Phone phone);

    public abstract void notifyCellInfo(Phone phone, CellInfo cellinfo);

    public abstract void notifyCellLocation(Phone phone);

    public abstract void notifyDataActivity(Phone phone);

    public abstract void notifyDataConnection(Phone phone, String s, String s1, Phone.DataState datastate);

    public abstract void notifyDataConnectionFailed(Phone phone, String s, String s1);

    public abstract void notifyMessageWaitingChanged(Phone phone);

    public abstract void notifyOtaspChanged(Phone phone, int i);

    public abstract void notifyPhoneState(Phone phone);

    public abstract void notifyServiceState(Phone phone);

    public abstract void notifySignalStrength(Phone phone);
}

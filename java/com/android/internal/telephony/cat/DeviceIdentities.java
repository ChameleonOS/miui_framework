// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;


// Referenced classes of package com.android.internal.telephony.cat:
//            ValueObject, ComprehensionTlvTag

class DeviceIdentities extends ValueObject {

    DeviceIdentities() {
    }

    ComprehensionTlvTag getTag() {
        return ComprehensionTlvTag.DEVICE_IDENTITIES;
    }

    public int destinationId;
    public int sourceId;
}

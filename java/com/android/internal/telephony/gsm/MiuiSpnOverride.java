// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.gsm;


// Referenced classes of package com.android.internal.telephony.gsm:
//            MiuiSpnOverrideImpl

public class MiuiSpnOverride {

    public MiuiSpnOverride() {
    }

    public static MiuiSpnOverride getInstance() {
        return sInstance;
    }

    public boolean containsCarrier(String s) {
        return sImpl.containsCarrier(s);
    }

    public String getEquivalentOperatorNumeric(String s) {
        return sImpl.getEquivalentOperatorNumeric(s);
    }

    public String getSpn(String s) {
        return sImpl.getSpn(s);
    }

    public static final String EQ_OPERATOR_CM = "46000";
    public static final String EQ_OPERATOR_CT = "46003";
    public static final String EQ_OPERATOR_CU = "46001";
    private static final MiuiSpnOverrideImpl sImpl = new MiuiSpnOverrideImpl();
    static final MiuiSpnOverride sInstance = new MiuiSpnOverride();

}

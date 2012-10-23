// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.telephony;

import com.android.internal.telephony.gsm.MiuiSpnOverride;
import java.util.HashMap;
import java.util.Map;

public final class CarrierSelector {
    public static final class CARRIER extends Enum {

        public static CARRIER valueOf(String s) {
            return (CARRIER)Enum.valueOf(miui/telephony/CarrierSelector$CARRIER, s);
        }

        public static CARRIER[] values() {
            return (CARRIER[])$VALUES.clone();
        }

        private static final CARRIER $VALUES[];
        public static final CARRIER CHINA_MOBILE;
        public static final CARRIER CHINA_TELECOM;
        public static final CARRIER CHINA_UNICOM;

        static  {
            CHINA_MOBILE = new CARRIER("CHINA_MOBILE", 0);
            CHINA_UNICOM = new CARRIER("CHINA_UNICOM", 1);
            CHINA_TELECOM = new CARRIER("CHINA_TELECOM", 2);
            CARRIER acarrier[] = new CARRIER[3];
            acarrier[0] = CHINA_MOBILE;
            acarrier[1] = CHINA_UNICOM;
            acarrier[2] = CHINA_TELECOM;
            $VALUES = acarrier;
        }

        private CARRIER(String s, int i) {
            super(s, i);
        }
    }


    public CarrierSelector() {
        mCarrierMap = new HashMap();
    }

    public CarrierSelector(CARRIER carrier) {
        mCarrierMap = new HashMap();
        mDefaultCarrier = carrier;
    }

    private CARRIER internalSelectCarrier(String s, CARRIER carrier) {
        CARRIER carrier1;
        String s1;
        carrier1 = carrier;
        s1 = MiuiSpnOverride.getInstance().getEquivalentOperatorNumeric(s);
        if(!"46000".equals(s1)) goto _L2; else goto _L1
_L1:
        carrier1 = CARRIER.CHINA_MOBILE;
_L4:
        return carrier1;
_L2:
        if("46001".equals(s1))
            carrier1 = CARRIER.CHINA_UNICOM;
        else
        if("46003".equals(s1))
            carrier1 = CARRIER.CHINA_TELECOM;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void register(CARRIER carrier, Object obj) {
        if(carrier == null) {
            throw new IllegalArgumentException("carrier not nullable");
        } else {
            mCarrierMap.put(carrier, obj);
            return;
        }
    }

    public CARRIER selectCarrier(String s) {
        return internalSelectCarrier(s, null);
    }

    public Object selectValue(String s) {
        CARRIER carrier = internalSelectCarrier(s, mDefaultCarrier);
        return mCarrierMap.get(carrier);
    }

    public Object selectValue(String s, boolean flag) {
        CARRIER carrier;
        CARRIER carrier1;
        if(flag)
            carrier = mDefaultCarrier;
        else
            carrier = null;
        carrier1 = internalSelectCarrier(s, carrier);
        return mCarrierMap.get(carrier1);
    }

    private final Map mCarrierMap;
    private CARRIER mDefaultCarrier;
}

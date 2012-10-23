// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.telephony;

import com.android.internal.telephony.gsm.MiuiSpnOverride;
import com.google.android.collect.Maps;
import com.google.android.collect.Sets;
import java.util.*;

public final class CarrierSelector {
    public static final class STATE extends Enum {

        public static STATE valueOf(String s) {
            return (STATE)Enum.valueOf(miui/telephony/CarrierSelector$STATE, s);
        }

        public static STATE[] values() {
            return (STATE[])$VALUES.clone();
        }

        private static final STATE $VALUES[];
        public static final STATE TAIWAN;

        static  {
            TAIWAN = new STATE("TAIWAN", 0);
            STATE astate[] = new STATE[1];
            astate[0] = TAIWAN;
            $VALUES = astate;
        }

        private STATE(String s, int i) {
            super(s, i);
        }
    }

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
        public static final CARRIER DEFAULT;

        static  {
            CHINA_MOBILE = new CARRIER("CHINA_MOBILE", 0);
            CHINA_UNICOM = new CARRIER("CHINA_UNICOM", 1);
            CHINA_TELECOM = new CARRIER("CHINA_TELECOM", 2);
            DEFAULT = new CARRIER("DEFAULT", 3);
            CARRIER acarrier[] = new CARRIER[4];
            acarrier[0] = CHINA_MOBILE;
            acarrier[1] = CHINA_UNICOM;
            acarrier[2] = CHINA_TELECOM;
            acarrier[3] = DEFAULT;
            $VALUES = acarrier;
        }

        private CARRIER(String s, int i) {
            super(s, i);
        }
    }


    public CarrierSelector() {
        mDefaultCarrier = CARRIER.DEFAULT;
        mCarrierMap = new HashMap();
        mStateMap = new HashMap();
    }

    public CarrierSelector(CARRIER carrier) {
        mDefaultCarrier = CARRIER.DEFAULT;
        mCarrierMap = new HashMap();
        mStateMap = new HashMap();
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

    private STATE internalSelectState(String s) {
        STATE state;
        if("466".equals(s))
            state = STATE.TAIWAN;
        else
            state = null;
        return state;
    }

    public void register(CARRIER carrier, Object obj) {
        if(carrier == null)
            throw new IllegalArgumentException("carrier not nullable");
        String s = (String)mCarrier2MccMap.get(carrier);
        if(s == null) {
            throw new IllegalStateException((new StringBuilder()).append("mcc for the carrier is unknown, carrier: ").append(carrier).toString());
        } else {
            mMccHandled.add(s);
            mCarrierMap.put(carrier, obj);
            return;
        }
    }

    public void register(STATE state, Object obj) {
        if(state == null)
            throw new IllegalArgumentException("state not nullable");
        String s = (String)mState2MccMap.get(state);
        if(s == null) {
            throw new IllegalStateException((new StringBuilder()).append("mcc for the state is unknown, state: ").append(state).toString());
        } else {
            mMccHandled.add(s);
            mStateMap.put(state, obj);
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

    public Object selectValue(String s, String s1) {
        return selectValue(s, s1, false);
    }

    public Object selectValue(String s, String s1, boolean flag) {
        if(s == null)
            throw new IllegalArgumentException("mcc not nullable");
        CARRIER carrier = null;
        if(s1 != null)
            carrier = internalSelectCarrier((new StringBuilder()).append(s).append(s1).toString(), null);
        Object obj;
        if(carrier == null) {
            STATE state = internalSelectState(s);
            obj = mStateMap.get(state);
        } else {
            obj = mCarrierMap.get(carrier);
        }
        if(obj == null && flag && !mMccHandled.contains(s))
            obj = mCarrierMap.get(mDefaultCarrier);
        return obj;
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

    private static final Map mCarrier2MccMap;
    private static final Set mMccHandled = Sets.newHashSet();
    private static final Map mState2MccMap;
    private final Map mCarrierMap;
    private CARRIER mDefaultCarrier;
    private final Map mStateMap;

    static  {
        mCarrier2MccMap = Maps.newHashMap();
        mState2MccMap = Maps.newHashMap();
        mCarrier2MccMap.put(CARRIER.DEFAULT, "000");
        mCarrier2MccMap.put(CARRIER.CHINA_MOBILE, "460");
        mCarrier2MccMap.put(CARRIER.CHINA_UNICOM, "460");
        mCarrier2MccMap.put(CARRIER.CHINA_TELECOM, "460");
        mState2MccMap.put(STATE.TAIWAN, "466");
    }
}

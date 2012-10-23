// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import java.util.ArrayList;

// Referenced classes of package com.android.internal.telephony:
//            IccCardApplication

public class IccCardStatus {
    public static final class PinState extends Enum {

        public static PinState valueOf(String s) {
            return (PinState)Enum.valueOf(com/android/internal/telephony/IccCardStatus$PinState, s);
        }

        public static PinState[] values() {
            return (PinState[])$VALUES.clone();
        }

        boolean isPermBlocked() {
            boolean flag;
            if(this == PINSTATE_ENABLED_PERM_BLOCKED)
                flag = true;
            else
                flag = false;
            return flag;
        }

        boolean isPinRequired() {
            boolean flag;
            if(this == PINSTATE_ENABLED_NOT_VERIFIED)
                flag = true;
            else
                flag = false;
            return flag;
        }

        boolean isPukRequired() {
            boolean flag;
            if(this == PINSTATE_ENABLED_BLOCKED)
                flag = true;
            else
                flag = false;
            return flag;
        }

        private static final PinState $VALUES[];
        public static final PinState PINSTATE_DISABLED;
        public static final PinState PINSTATE_ENABLED_BLOCKED;
        public static final PinState PINSTATE_ENABLED_NOT_VERIFIED;
        public static final PinState PINSTATE_ENABLED_PERM_BLOCKED;
        public static final PinState PINSTATE_ENABLED_VERIFIED;
        public static final PinState PINSTATE_UNKNOWN;

        static  {
            PINSTATE_UNKNOWN = new PinState("PINSTATE_UNKNOWN", 0);
            PINSTATE_ENABLED_NOT_VERIFIED = new PinState("PINSTATE_ENABLED_NOT_VERIFIED", 1);
            PINSTATE_ENABLED_VERIFIED = new PinState("PINSTATE_ENABLED_VERIFIED", 2);
            PINSTATE_DISABLED = new PinState("PINSTATE_DISABLED", 3);
            PINSTATE_ENABLED_BLOCKED = new PinState("PINSTATE_ENABLED_BLOCKED", 4);
            PINSTATE_ENABLED_PERM_BLOCKED = new PinState("PINSTATE_ENABLED_PERM_BLOCKED", 5);
            PinState apinstate[] = new PinState[6];
            apinstate[0] = PINSTATE_UNKNOWN;
            apinstate[1] = PINSTATE_ENABLED_NOT_VERIFIED;
            apinstate[2] = PINSTATE_ENABLED_VERIFIED;
            apinstate[3] = PINSTATE_DISABLED;
            apinstate[4] = PINSTATE_ENABLED_BLOCKED;
            apinstate[5] = PINSTATE_ENABLED_PERM_BLOCKED;
            $VALUES = apinstate;
        }

        private PinState(String s, int i) {
            super(s, i);
        }
    }

    public static final class CardState extends Enum {

        public static CardState valueOf(String s) {
            return (CardState)Enum.valueOf(com/android/internal/telephony/IccCardStatus$CardState, s);
        }

        public static CardState[] values() {
            return (CardState[])$VALUES.clone();
        }

        boolean isCardPresent() {
            boolean flag;
            if(this == CARDSTATE_PRESENT)
                flag = true;
            else
                flag = false;
            return flag;
        }

        private static final CardState $VALUES[];
        public static final CardState CARDSTATE_ABSENT;
        public static final CardState CARDSTATE_ERROR;
        public static final CardState CARDSTATE_PRESENT;

        static  {
            CARDSTATE_ABSENT = new CardState("CARDSTATE_ABSENT", 0);
            CARDSTATE_PRESENT = new CardState("CARDSTATE_PRESENT", 1);
            CARDSTATE_ERROR = new CardState("CARDSTATE_ERROR", 2);
            CardState acardstate[] = new CardState[3];
            acardstate[0] = CARDSTATE_ABSENT;
            acardstate[1] = CARDSTATE_PRESENT;
            acardstate[2] = CARDSTATE_ERROR;
            $VALUES = acardstate;
        }

        private CardState(String s, int i) {
            super(s, i);
        }
    }


    public IccCardStatus() {
        mApplications = new ArrayList(8);
    }

    public void addApplication(IccCardApplication icccardapplication) {
        mApplications.add(icccardapplication);
    }

    public IccCardApplication getApplication(int i) {
        return (IccCardApplication)mApplications.get(i);
    }

    public CardState getCardState() {
        return mCardState;
    }

    public int getCdmaSubscriptionAppIndex() {
        return mCdmaSubscriptionAppIndex;
    }

    public int getGsmUmtsSubscriptionAppIndex() {
        return mGsmUmtsSubscriptionAppIndex;
    }

    public int getImsSubscriptionAppIndex() {
        return mImsSubscriptionAppIndex;
    }

    public int getNumApplications() {
        return mNumApplications;
    }

    public PinState getUniversalPinState() {
        return mUniversalPinState;
    }

    public void setCardState(int i) {
        i;
        JVM INSTR tableswitch 0 2: default 28
    //                   0 55
    //                   1 63
    //                   2 73;
           goto _L1 _L2 _L3 _L4
_L1:
        throw new RuntimeException((new StringBuilder()).append("Unrecognized RIL_CardState: ").append(i).toString());
_L2:
        mCardState = CardState.CARDSTATE_ABSENT;
_L6:
        return;
_L3:
        mCardState = CardState.CARDSTATE_PRESENT;
        continue; /* Loop/switch isn't completed */
_L4:
        mCardState = CardState.CARDSTATE_ERROR;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public void setCdmaSubscriptionAppIndex(int i) {
        mCdmaSubscriptionAppIndex = i;
    }

    public void setGsmUmtsSubscriptionAppIndex(int i) {
        mGsmUmtsSubscriptionAppIndex = i;
    }

    public void setImsSubscriptionAppIndex(int i) {
        mImsSubscriptionAppIndex = i;
    }

    public void setNumApplications(int i) {
        mNumApplications = i;
    }

    public void setUniversalPinState(int i) {
        i;
        JVM INSTR tableswitch 0 5: default 40
    //                   0 67
    //                   1 75
    //                   2 85
    //                   3 95
    //                   4 105
    //                   5 115;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        throw new RuntimeException((new StringBuilder()).append("Unrecognized RIL_PinState: ").append(i).toString());
_L2:
        mUniversalPinState = PinState.PINSTATE_UNKNOWN;
_L9:
        return;
_L3:
        mUniversalPinState = PinState.PINSTATE_ENABLED_NOT_VERIFIED;
        continue; /* Loop/switch isn't completed */
_L4:
        mUniversalPinState = PinState.PINSTATE_ENABLED_VERIFIED;
        continue; /* Loop/switch isn't completed */
_L5:
        mUniversalPinState = PinState.PINSTATE_DISABLED;
        continue; /* Loop/switch isn't completed */
_L6:
        mUniversalPinState = PinState.PINSTATE_ENABLED_BLOCKED;
        continue; /* Loop/switch isn't completed */
_L7:
        mUniversalPinState = PinState.PINSTATE_ENABLED_PERM_BLOCKED;
        if(true) goto _L9; else goto _L8
_L8:
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("IccCardState {").append(mCardState).append(",").append(mUniversalPinState).append(",num_apps=").append(mNumApplications).append(",gsm_id=").append(mGsmUmtsSubscriptionAppIndex);
        if(mGsmUmtsSubscriptionAppIndex >= 0 && mGsmUmtsSubscriptionAppIndex < 8) {
            Object obj1 = getApplication(mGsmUmtsSubscriptionAppIndex);
            if(obj1 == null)
                obj1 = "null";
            stringbuilder.append(obj1);
        }
        stringbuilder.append(",cmda_id=").append(mCdmaSubscriptionAppIndex);
        if(mCdmaSubscriptionAppIndex >= 0 && mCdmaSubscriptionAppIndex < 8) {
            Object obj = getApplication(mCdmaSubscriptionAppIndex);
            if(obj == null)
                obj = "null";
            stringbuilder.append(obj);
        }
        stringbuilder.append(",ism_id=").append(mImsSubscriptionAppIndex);
        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    public static final int CARD_MAX_APPS = 8;
    private ArrayList mApplications;
    private CardState mCardState;
    private int mCdmaSubscriptionAppIndex;
    private int mGsmUmtsSubscriptionAppIndex;
    private int mImsSubscriptionAppIndex;
    private int mNumApplications;
    private PinState mUniversalPinState;
}

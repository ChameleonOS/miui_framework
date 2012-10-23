// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.wifi;

import android.os.Parcel;
import android.os.Parcelable;

public final class SupplicantState extends Enum
    implements Parcelable {

    private SupplicantState(String s, int i) {
        super(s, i);
    }

    static boolean isConnecting(SupplicantState supplicantstate) {
        class _cls2 {

            static final int $SwitchMap$android$net$wifi$SupplicantState[];

            static  {
                $SwitchMap$android$net$wifi$SupplicantState = new int[SupplicantState.values().length];
                NoSuchFieldError nosuchfielderror12;
                try {
                    $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.AUTHENTICATING.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror) { }
                try {
                    $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.ASSOCIATING.ordinal()] = 2;
                }
                catch(NoSuchFieldError nosuchfielderror1) { }
                try {
                    $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.ASSOCIATED.ordinal()] = 3;
                }
                catch(NoSuchFieldError nosuchfielderror2) { }
                try {
                    $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.FOUR_WAY_HANDSHAKE.ordinal()] = 4;
                }
                catch(NoSuchFieldError nosuchfielderror3) { }
                try {
                    $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.GROUP_HANDSHAKE.ordinal()] = 5;
                }
                catch(NoSuchFieldError nosuchfielderror4) { }
                try {
                    $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.COMPLETED.ordinal()] = 6;
                }
                catch(NoSuchFieldError nosuchfielderror5) { }
                try {
                    $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.DISCONNECTED.ordinal()] = 7;
                }
                catch(NoSuchFieldError nosuchfielderror6) { }
                try {
                    $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.INTERFACE_DISABLED.ordinal()] = 8;
                }
                catch(NoSuchFieldError nosuchfielderror7) { }
                try {
                    $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.INACTIVE.ordinal()] = 9;
                }
                catch(NoSuchFieldError nosuchfielderror8) { }
                try {
                    $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.SCANNING.ordinal()] = 10;
                }
                catch(NoSuchFieldError nosuchfielderror9) { }
                try {
                    $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.DORMANT.ordinal()] = 11;
                }
                catch(NoSuchFieldError nosuchfielderror10) { }
                try {
                    $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.UNINITIALIZED.ordinal()] = 12;
                }
                catch(NoSuchFieldError nosuchfielderror11) { }
                $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.INVALID.ordinal()] = 13;
_L2:
                return;
                nosuchfielderror12;
                if(true) goto _L2; else goto _L1
_L1:
            }
        }

        _cls2..SwitchMap.android.net.wifi.SupplicantState[supplicantstate.ordinal()];
        JVM INSTR tableswitch 1 13: default 76
    //                   1 86
    //                   2 86
    //                   3 86
    //                   4 86
    //                   5 86
    //                   6 86
    //                   7 90
    //                   8 90
    //                   9 90
    //                   10 90
    //                   11 90
    //                   12 90
    //                   13 90;
           goto _L1 _L2 _L2 _L2 _L2 _L2 _L2 _L3 _L3 _L3 _L3 _L3 _L3 _L3
_L1:
        throw new IllegalArgumentException("Unknown supplicant state");
_L2:
        boolean flag = true;
_L5:
        return flag;
_L3:
        flag = false;
        if(true) goto _L5; else goto _L4
_L4:
    }

    static boolean isDriverActive(SupplicantState supplicantstate) {
        _cls2..SwitchMap.android.net.wifi.SupplicantState[supplicantstate.ordinal()];
        JVM INSTR tableswitch 1 13: default 76
    //                   1 86
    //                   2 86
    //                   3 86
    //                   4 86
    //                   5 86
    //                   6 86
    //                   7 86
    //                   8 90
    //                   9 86
    //                   10 86
    //                   11 86
    //                   12 90
    //                   13 90;
           goto _L1 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L3 _L2 _L2 _L2 _L3 _L3
_L1:
        throw new IllegalArgumentException("Unknown supplicant state");
_L2:
        boolean flag = true;
_L5:
        return flag;
_L3:
        flag = false;
        if(true) goto _L5; else goto _L4
_L4:
    }

    public static boolean isHandshakeState(SupplicantState supplicantstate) {
        _cls2..SwitchMap.android.net.wifi.SupplicantState[supplicantstate.ordinal()];
        JVM INSTR tableswitch 1 13: default 76
    //                   1 86
    //                   2 86
    //                   3 86
    //                   4 86
    //                   5 86
    //                   6 90
    //                   7 90
    //                   8 90
    //                   9 90
    //                   10 90
    //                   11 90
    //                   12 90
    //                   13 90;
           goto _L1 _L2 _L2 _L2 _L2 _L2 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3
_L1:
        throw new IllegalArgumentException("Unknown supplicant state");
_L2:
        boolean flag = true;
_L5:
        return flag;
_L3:
        flag = false;
        if(true) goto _L5; else goto _L4
_L4:
    }

    public static boolean isValidState(SupplicantState supplicantstate) {
        boolean flag;
        if(supplicantstate != UNINITIALIZED && supplicantstate != INVALID)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static SupplicantState valueOf(String s) {
        return (SupplicantState)Enum.valueOf(android/net/wifi/SupplicantState, s);
    }

    public static SupplicantState[] values() {
        return (SupplicantState[])$VALUES.clone();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name());
    }

    private static final SupplicantState $VALUES[];
    public static final SupplicantState ASSOCIATED;
    public static final SupplicantState ASSOCIATING;
    public static final SupplicantState AUTHENTICATING;
    public static final SupplicantState COMPLETED;
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public SupplicantState createFromParcel(Parcel parcel) {
            return SupplicantState.valueOf(parcel.readString());
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public SupplicantState[] newArray(int i) {
            return new SupplicantState[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final SupplicantState DISCONNECTED;
    public static final SupplicantState DORMANT;
    public static final SupplicantState FOUR_WAY_HANDSHAKE;
    public static final SupplicantState GROUP_HANDSHAKE;
    public static final SupplicantState INACTIVE;
    public static final SupplicantState INTERFACE_DISABLED;
    public static final SupplicantState INVALID;
    public static final SupplicantState SCANNING;
    public static final SupplicantState UNINITIALIZED;

    static  {
        DISCONNECTED = new SupplicantState("DISCONNECTED", 0);
        INTERFACE_DISABLED = new SupplicantState("INTERFACE_DISABLED", 1);
        INACTIVE = new SupplicantState("INACTIVE", 2);
        SCANNING = new SupplicantState("SCANNING", 3);
        AUTHENTICATING = new SupplicantState("AUTHENTICATING", 4);
        ASSOCIATING = new SupplicantState("ASSOCIATING", 5);
        ASSOCIATED = new SupplicantState("ASSOCIATED", 6);
        FOUR_WAY_HANDSHAKE = new SupplicantState("FOUR_WAY_HANDSHAKE", 7);
        GROUP_HANDSHAKE = new SupplicantState("GROUP_HANDSHAKE", 8);
        COMPLETED = new SupplicantState("COMPLETED", 9);
        DORMANT = new SupplicantState("DORMANT", 10);
        UNINITIALIZED = new SupplicantState("UNINITIALIZED", 11);
        INVALID = new SupplicantState("INVALID", 12);
        SupplicantState asupplicantstate[] = new SupplicantState[13];
        asupplicantstate[0] = DISCONNECTED;
        asupplicantstate[1] = INTERFACE_DISABLED;
        asupplicantstate[2] = INACTIVE;
        asupplicantstate[3] = SCANNING;
        asupplicantstate[4] = AUTHENTICATING;
        asupplicantstate[5] = ASSOCIATING;
        asupplicantstate[6] = ASSOCIATED;
        asupplicantstate[7] = FOUR_WAY_HANDSHAKE;
        asupplicantstate[8] = GROUP_HANDSHAKE;
        asupplicantstate[9] = COMPLETED;
        asupplicantstate[10] = DORMANT;
        asupplicantstate[11] = UNINITIALIZED;
        asupplicantstate[12] = INVALID;
        $VALUES = asupplicantstate;
    }
}

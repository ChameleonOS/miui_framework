// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;


public class IccCardApplication {
    public static final class PersoSubState extends Enum {

        public static PersoSubState valueOf(String s) {
            return (PersoSubState)Enum.valueOf(com/android/internal/telephony/IccCardApplication$PersoSubState, s);
        }

        public static PersoSubState[] values() {
            return (PersoSubState[])$VALUES.clone();
        }

        boolean isPersoSubStateUnknown() {
            boolean flag;
            if(this == PERSOSUBSTATE_UNKNOWN)
                flag = true;
            else
                flag = false;
            return flag;
        }

        private static final PersoSubState $VALUES[];
        public static final PersoSubState PERSOSUBSTATE_IN_PROGRESS;
        public static final PersoSubState PERSOSUBSTATE_READY;
        public static final PersoSubState PERSOSUBSTATE_RUIM_CORPORATE;
        public static final PersoSubState PERSOSUBSTATE_RUIM_CORPORATE_PUK;
        public static final PersoSubState PERSOSUBSTATE_RUIM_HRPD;
        public static final PersoSubState PERSOSUBSTATE_RUIM_HRPD_PUK;
        public static final PersoSubState PERSOSUBSTATE_RUIM_NETWORK1;
        public static final PersoSubState PERSOSUBSTATE_RUIM_NETWORK1_PUK;
        public static final PersoSubState PERSOSUBSTATE_RUIM_NETWORK2;
        public static final PersoSubState PERSOSUBSTATE_RUIM_NETWORK2_PUK;
        public static final PersoSubState PERSOSUBSTATE_RUIM_RUIM;
        public static final PersoSubState PERSOSUBSTATE_RUIM_RUIM_PUK;
        public static final PersoSubState PERSOSUBSTATE_RUIM_SERVICE_PROVIDER;
        public static final PersoSubState PERSOSUBSTATE_RUIM_SERVICE_PROVIDER_PUK;
        public static final PersoSubState PERSOSUBSTATE_SIM_CORPORATE;
        public static final PersoSubState PERSOSUBSTATE_SIM_CORPORATE_PUK;
        public static final PersoSubState PERSOSUBSTATE_SIM_NETWORK;
        public static final PersoSubState PERSOSUBSTATE_SIM_NETWORK_PUK;
        public static final PersoSubState PERSOSUBSTATE_SIM_NETWORK_SUBSET;
        public static final PersoSubState PERSOSUBSTATE_SIM_NETWORK_SUBSET_PUK;
        public static final PersoSubState PERSOSUBSTATE_SIM_SERVICE_PROVIDER;
        public static final PersoSubState PERSOSUBSTATE_SIM_SERVICE_PROVIDER_PUK;
        public static final PersoSubState PERSOSUBSTATE_SIM_SIM;
        public static final PersoSubState PERSOSUBSTATE_SIM_SIM_PUK;
        public static final PersoSubState PERSOSUBSTATE_UNKNOWN;

        static  {
            PERSOSUBSTATE_UNKNOWN = new PersoSubState("PERSOSUBSTATE_UNKNOWN", 0);
            PERSOSUBSTATE_IN_PROGRESS = new PersoSubState("PERSOSUBSTATE_IN_PROGRESS", 1);
            PERSOSUBSTATE_READY = new PersoSubState("PERSOSUBSTATE_READY", 2);
            PERSOSUBSTATE_SIM_NETWORK = new PersoSubState("PERSOSUBSTATE_SIM_NETWORK", 3);
            PERSOSUBSTATE_SIM_NETWORK_SUBSET = new PersoSubState("PERSOSUBSTATE_SIM_NETWORK_SUBSET", 4);
            PERSOSUBSTATE_SIM_CORPORATE = new PersoSubState("PERSOSUBSTATE_SIM_CORPORATE", 5);
            PERSOSUBSTATE_SIM_SERVICE_PROVIDER = new PersoSubState("PERSOSUBSTATE_SIM_SERVICE_PROVIDER", 6);
            PERSOSUBSTATE_SIM_SIM = new PersoSubState("PERSOSUBSTATE_SIM_SIM", 7);
            PERSOSUBSTATE_SIM_NETWORK_PUK = new PersoSubState("PERSOSUBSTATE_SIM_NETWORK_PUK", 8);
            PERSOSUBSTATE_SIM_NETWORK_SUBSET_PUK = new PersoSubState("PERSOSUBSTATE_SIM_NETWORK_SUBSET_PUK", 9);
            PERSOSUBSTATE_SIM_CORPORATE_PUK = new PersoSubState("PERSOSUBSTATE_SIM_CORPORATE_PUK", 10);
            PERSOSUBSTATE_SIM_SERVICE_PROVIDER_PUK = new PersoSubState("PERSOSUBSTATE_SIM_SERVICE_PROVIDER_PUK", 11);
            PERSOSUBSTATE_SIM_SIM_PUK = new PersoSubState("PERSOSUBSTATE_SIM_SIM_PUK", 12);
            PERSOSUBSTATE_RUIM_NETWORK1 = new PersoSubState("PERSOSUBSTATE_RUIM_NETWORK1", 13);
            PERSOSUBSTATE_RUIM_NETWORK2 = new PersoSubState("PERSOSUBSTATE_RUIM_NETWORK2", 14);
            PERSOSUBSTATE_RUIM_HRPD = new PersoSubState("PERSOSUBSTATE_RUIM_HRPD", 15);
            PERSOSUBSTATE_RUIM_CORPORATE = new PersoSubState("PERSOSUBSTATE_RUIM_CORPORATE", 16);
            PERSOSUBSTATE_RUIM_SERVICE_PROVIDER = new PersoSubState("PERSOSUBSTATE_RUIM_SERVICE_PROVIDER", 17);
            PERSOSUBSTATE_RUIM_RUIM = new PersoSubState("PERSOSUBSTATE_RUIM_RUIM", 18);
            PERSOSUBSTATE_RUIM_NETWORK1_PUK = new PersoSubState("PERSOSUBSTATE_RUIM_NETWORK1_PUK", 19);
            PERSOSUBSTATE_RUIM_NETWORK2_PUK = new PersoSubState("PERSOSUBSTATE_RUIM_NETWORK2_PUK", 20);
            PERSOSUBSTATE_RUIM_HRPD_PUK = new PersoSubState("PERSOSUBSTATE_RUIM_HRPD_PUK", 21);
            PERSOSUBSTATE_RUIM_CORPORATE_PUK = new PersoSubState("PERSOSUBSTATE_RUIM_CORPORATE_PUK", 22);
            PERSOSUBSTATE_RUIM_SERVICE_PROVIDER_PUK = new PersoSubState("PERSOSUBSTATE_RUIM_SERVICE_PROVIDER_PUK", 23);
            PERSOSUBSTATE_RUIM_RUIM_PUK = new PersoSubState("PERSOSUBSTATE_RUIM_RUIM_PUK", 24);
            PersoSubState apersosubstate[] = new PersoSubState[25];
            apersosubstate[0] = PERSOSUBSTATE_UNKNOWN;
            apersosubstate[1] = PERSOSUBSTATE_IN_PROGRESS;
            apersosubstate[2] = PERSOSUBSTATE_READY;
            apersosubstate[3] = PERSOSUBSTATE_SIM_NETWORK;
            apersosubstate[4] = PERSOSUBSTATE_SIM_NETWORK_SUBSET;
            apersosubstate[5] = PERSOSUBSTATE_SIM_CORPORATE;
            apersosubstate[6] = PERSOSUBSTATE_SIM_SERVICE_PROVIDER;
            apersosubstate[7] = PERSOSUBSTATE_SIM_SIM;
            apersosubstate[8] = PERSOSUBSTATE_SIM_NETWORK_PUK;
            apersosubstate[9] = PERSOSUBSTATE_SIM_NETWORK_SUBSET_PUK;
            apersosubstate[10] = PERSOSUBSTATE_SIM_CORPORATE_PUK;
            apersosubstate[11] = PERSOSUBSTATE_SIM_SERVICE_PROVIDER_PUK;
            apersosubstate[12] = PERSOSUBSTATE_SIM_SIM_PUK;
            apersosubstate[13] = PERSOSUBSTATE_RUIM_NETWORK1;
            apersosubstate[14] = PERSOSUBSTATE_RUIM_NETWORK2;
            apersosubstate[15] = PERSOSUBSTATE_RUIM_HRPD;
            apersosubstate[16] = PERSOSUBSTATE_RUIM_CORPORATE;
            apersosubstate[17] = PERSOSUBSTATE_RUIM_SERVICE_PROVIDER;
            apersosubstate[18] = PERSOSUBSTATE_RUIM_RUIM;
            apersosubstate[19] = PERSOSUBSTATE_RUIM_NETWORK1_PUK;
            apersosubstate[20] = PERSOSUBSTATE_RUIM_NETWORK2_PUK;
            apersosubstate[21] = PERSOSUBSTATE_RUIM_HRPD_PUK;
            apersosubstate[22] = PERSOSUBSTATE_RUIM_CORPORATE_PUK;
            apersosubstate[23] = PERSOSUBSTATE_RUIM_SERVICE_PROVIDER_PUK;
            apersosubstate[24] = PERSOSUBSTATE_RUIM_RUIM_PUK;
            $VALUES = apersosubstate;
        }

        private PersoSubState(String s, int i) {
            super(s, i);
        }
    }

    public static final class AppState extends Enum {

        public static AppState valueOf(String s) {
            return (AppState)Enum.valueOf(com/android/internal/telephony/IccCardApplication$AppState, s);
        }

        public static AppState[] values() {
            return (AppState[])$VALUES.clone();
        }

        boolean isAppNotReady() {
            boolean flag;
            if(this == APPSTATE_UNKNOWN || this == APPSTATE_DETECTED)
                flag = true;
            else
                flag = false;
            return flag;
        }

        boolean isAppReady() {
            boolean flag;
            if(this == APPSTATE_READY)
                flag = true;
            else
                flag = false;
            return flag;
        }

        boolean isPinRequired() {
            boolean flag;
            if(this == APPSTATE_PIN)
                flag = true;
            else
                flag = false;
            return flag;
        }

        boolean isPukRequired() {
            boolean flag;
            if(this == APPSTATE_PUK)
                flag = true;
            else
                flag = false;
            return flag;
        }

        boolean isSubscriptionPersoEnabled() {
            boolean flag;
            if(this == APPSTATE_SUBSCRIPTION_PERSO)
                flag = true;
            else
                flag = false;
            return flag;
        }

        private static final AppState $VALUES[];
        public static final AppState APPSTATE_DETECTED;
        public static final AppState APPSTATE_PIN;
        public static final AppState APPSTATE_PUK;
        public static final AppState APPSTATE_READY;
        public static final AppState APPSTATE_SUBSCRIPTION_PERSO;
        public static final AppState APPSTATE_UNKNOWN;

        static  {
            APPSTATE_UNKNOWN = new AppState("APPSTATE_UNKNOWN", 0);
            APPSTATE_DETECTED = new AppState("APPSTATE_DETECTED", 1);
            APPSTATE_PIN = new AppState("APPSTATE_PIN", 2);
            APPSTATE_PUK = new AppState("APPSTATE_PUK", 3);
            APPSTATE_SUBSCRIPTION_PERSO = new AppState("APPSTATE_SUBSCRIPTION_PERSO", 4);
            APPSTATE_READY = new AppState("APPSTATE_READY", 5);
            AppState aappstate[] = new AppState[6];
            aappstate[0] = APPSTATE_UNKNOWN;
            aappstate[1] = APPSTATE_DETECTED;
            aappstate[2] = APPSTATE_PIN;
            aappstate[3] = APPSTATE_PUK;
            aappstate[4] = APPSTATE_SUBSCRIPTION_PERSO;
            aappstate[5] = APPSTATE_READY;
            $VALUES = aappstate;
        }

        private AppState(String s, int i) {
            super(s, i);
        }
    }

    public static final class AppType extends Enum {

        public static AppType valueOf(String s) {
            return (AppType)Enum.valueOf(com/android/internal/telephony/IccCardApplication$AppType, s);
        }

        public static AppType[] values() {
            return (AppType[])$VALUES.clone();
        }

        private static final AppType $VALUES[];
        public static final AppType APPTYPE_CSIM;
        public static final AppType APPTYPE_ISIM;
        public static final AppType APPTYPE_RUIM;
        public static final AppType APPTYPE_SIM;
        public static final AppType APPTYPE_UNKNOWN;
        public static final AppType APPTYPE_USIM;

        static  {
            APPTYPE_UNKNOWN = new AppType("APPTYPE_UNKNOWN", 0);
            APPTYPE_SIM = new AppType("APPTYPE_SIM", 1);
            APPTYPE_USIM = new AppType("APPTYPE_USIM", 2);
            APPTYPE_RUIM = new AppType("APPTYPE_RUIM", 3);
            APPTYPE_CSIM = new AppType("APPTYPE_CSIM", 4);
            APPTYPE_ISIM = new AppType("APPTYPE_ISIM", 5);
            AppType aapptype[] = new AppType[6];
            aapptype[0] = APPTYPE_UNKNOWN;
            aapptype[1] = APPTYPE_SIM;
            aapptype[2] = APPTYPE_USIM;
            aapptype[3] = APPTYPE_RUIM;
            aapptype[4] = APPTYPE_CSIM;
            aapptype[5] = APPTYPE_ISIM;
            $VALUES = aapptype;
        }

        private AppType(String s, int i) {
            super(s, i);
        }
    }


    public IccCardApplication() {
    }

    AppState AppStateFromRILInt(int i) {
        i;
        JVM INSTR tableswitch 0 5: default 40
    //                   0 67
    //                   1 73
    //                   2 80
    //                   3 87
    //                   4 94
    //                   5 101;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        throw new RuntimeException((new StringBuilder()).append("Unrecognized RIL_AppState: ").append(i).toString());
_L2:
        AppState appstate = AppState.APPSTATE_UNKNOWN;
_L9:
        return appstate;
_L3:
        appstate = AppState.APPSTATE_DETECTED;
        continue; /* Loop/switch isn't completed */
_L4:
        appstate = AppState.APPSTATE_PIN;
        continue; /* Loop/switch isn't completed */
_L5:
        appstate = AppState.APPSTATE_PUK;
        continue; /* Loop/switch isn't completed */
_L6:
        appstate = AppState.APPSTATE_SUBSCRIPTION_PERSO;
        continue; /* Loop/switch isn't completed */
_L7:
        appstate = AppState.APPSTATE_READY;
        if(true) goto _L9; else goto _L8
_L8:
    }

    AppType AppTypeFromRILInt(int i) {
        i;
        JVM INSTR tableswitch 0 5: default 40
    //                   0 67
    //                   1 73
    //                   2 80
    //                   3 87
    //                   4 94
    //                   5 101;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        throw new RuntimeException((new StringBuilder()).append("Unrecognized RIL_AppType: ").append(i).toString());
_L2:
        AppType apptype = AppType.APPTYPE_UNKNOWN;
_L9:
        return apptype;
_L3:
        apptype = AppType.APPTYPE_SIM;
        continue; /* Loop/switch isn't completed */
_L4:
        apptype = AppType.APPTYPE_USIM;
        continue; /* Loop/switch isn't completed */
_L5:
        apptype = AppType.APPTYPE_RUIM;
        continue; /* Loop/switch isn't completed */
_L6:
        apptype = AppType.APPTYPE_CSIM;
        continue; /* Loop/switch isn't completed */
_L7:
        apptype = AppType.APPTYPE_ISIM;
        if(true) goto _L9; else goto _L8
_L8:
    }

    PersoSubState PersoSubstateFromRILInt(int i) {
        i;
        JVM INSTR tableswitch 0 24: default 116
    //                   0 143
    //                   1 149
    //                   2 156
    //                   3 163
    //                   4 170
    //                   5 177
    //                   6 184
    //                   7 191
    //                   8 198
    //                   9 205
    //                   10 212
    //                   11 219
    //                   12 226
    //                   13 233
    //                   14 240
    //                   15 247
    //                   16 254
    //                   17 261
    //                   18 268
    //                   19 275
    //                   20 282
    //                   21 289
    //                   22 296
    //                   23 303
    //                   24 310;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26
_L1:
        throw new RuntimeException((new StringBuilder()).append("Unrecognized RIL_PersoSubstate: ").append(i).toString());
_L2:
        PersoSubState persosubstate = PersoSubState.PERSOSUBSTATE_UNKNOWN;
_L28:
        return persosubstate;
_L3:
        persosubstate = PersoSubState.PERSOSUBSTATE_IN_PROGRESS;
        continue; /* Loop/switch isn't completed */
_L4:
        persosubstate = PersoSubState.PERSOSUBSTATE_READY;
        continue; /* Loop/switch isn't completed */
_L5:
        persosubstate = PersoSubState.PERSOSUBSTATE_SIM_NETWORK;
        continue; /* Loop/switch isn't completed */
_L6:
        persosubstate = PersoSubState.PERSOSUBSTATE_SIM_NETWORK_SUBSET;
        continue; /* Loop/switch isn't completed */
_L7:
        persosubstate = PersoSubState.PERSOSUBSTATE_SIM_CORPORATE;
        continue; /* Loop/switch isn't completed */
_L8:
        persosubstate = PersoSubState.PERSOSUBSTATE_SIM_SERVICE_PROVIDER;
        continue; /* Loop/switch isn't completed */
_L9:
        persosubstate = PersoSubState.PERSOSUBSTATE_SIM_SIM;
        continue; /* Loop/switch isn't completed */
_L10:
        persosubstate = PersoSubState.PERSOSUBSTATE_SIM_NETWORK_PUK;
        continue; /* Loop/switch isn't completed */
_L11:
        persosubstate = PersoSubState.PERSOSUBSTATE_SIM_NETWORK_SUBSET_PUK;
        continue; /* Loop/switch isn't completed */
_L12:
        persosubstate = PersoSubState.PERSOSUBSTATE_SIM_CORPORATE_PUK;
        continue; /* Loop/switch isn't completed */
_L13:
        persosubstate = PersoSubState.PERSOSUBSTATE_SIM_SERVICE_PROVIDER_PUK;
        continue; /* Loop/switch isn't completed */
_L14:
        persosubstate = PersoSubState.PERSOSUBSTATE_SIM_SIM_PUK;
        continue; /* Loop/switch isn't completed */
_L15:
        persosubstate = PersoSubState.PERSOSUBSTATE_RUIM_NETWORK1;
        continue; /* Loop/switch isn't completed */
_L16:
        persosubstate = PersoSubState.PERSOSUBSTATE_RUIM_NETWORK2;
        continue; /* Loop/switch isn't completed */
_L17:
        persosubstate = PersoSubState.PERSOSUBSTATE_RUIM_HRPD;
        continue; /* Loop/switch isn't completed */
_L18:
        persosubstate = PersoSubState.PERSOSUBSTATE_RUIM_CORPORATE;
        continue; /* Loop/switch isn't completed */
_L19:
        persosubstate = PersoSubState.PERSOSUBSTATE_RUIM_SERVICE_PROVIDER;
        continue; /* Loop/switch isn't completed */
_L20:
        persosubstate = PersoSubState.PERSOSUBSTATE_RUIM_RUIM;
        continue; /* Loop/switch isn't completed */
_L21:
        persosubstate = PersoSubState.PERSOSUBSTATE_RUIM_NETWORK1_PUK;
        continue; /* Loop/switch isn't completed */
_L22:
        persosubstate = PersoSubState.PERSOSUBSTATE_RUIM_NETWORK2_PUK;
        continue; /* Loop/switch isn't completed */
_L23:
        persosubstate = PersoSubState.PERSOSUBSTATE_RUIM_HRPD_PUK;
        continue; /* Loop/switch isn't completed */
_L24:
        persosubstate = PersoSubState.PERSOSUBSTATE_RUIM_CORPORATE_PUK;
        continue; /* Loop/switch isn't completed */
_L25:
        persosubstate = PersoSubState.PERSOSUBSTATE_RUIM_SERVICE_PROVIDER_PUK;
        continue; /* Loop/switch isn't completed */
_L26:
        persosubstate = PersoSubState.PERSOSUBSTATE_RUIM_RUIM_PUK;
        if(true) goto _L28; else goto _L27
_L27:
    }

    IccCardStatus.PinState PinStateFromRILInt(int i) {
        i;
        JVM INSTR tableswitch 0 5: default 40
    //                   0 67
    //                   1 73
    //                   2 80
    //                   3 87
    //                   4 94
    //                   5 101;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        throw new RuntimeException((new StringBuilder()).append("Unrecognized RIL_PinState: ").append(i).toString());
_L2:
        IccCardStatus.PinState pinstate = IccCardStatus.PinState.PINSTATE_UNKNOWN;
_L9:
        return pinstate;
_L3:
        pinstate = IccCardStatus.PinState.PINSTATE_ENABLED_NOT_VERIFIED;
        continue; /* Loop/switch isn't completed */
_L4:
        pinstate = IccCardStatus.PinState.PINSTATE_ENABLED_VERIFIED;
        continue; /* Loop/switch isn't completed */
_L5:
        pinstate = IccCardStatus.PinState.PINSTATE_DISABLED;
        continue; /* Loop/switch isn't completed */
_L6:
        pinstate = IccCardStatus.PinState.PINSTATE_ENABLED_BLOCKED;
        continue; /* Loop/switch isn't completed */
_L7:
        pinstate = IccCardStatus.PinState.PINSTATE_ENABLED_PERM_BLOCKED;
        if(true) goto _L9; else goto _L8
_L8:
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("{").append(app_type).append(",").append(app_state);
        if(app_state == AppState.APPSTATE_SUBSCRIPTION_PERSO)
            stringbuilder.append(",").append(perso_substate);
        if(app_type == AppType.APPTYPE_CSIM || app_type == AppType.APPTYPE_USIM || app_type == AppType.APPTYPE_ISIM) {
            stringbuilder.append(",pin1=").append(pin1);
            stringbuilder.append(",pin2=").append(pin2);
        }
        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    public String aid;
    public String app_label;
    public AppState app_state;
    public AppType app_type;
    public PersoSubState perso_substate;
    public IccCardStatus.PinState pin1;
    public int pin1_replaced;
    public IccCardStatus.PinState pin2;
}

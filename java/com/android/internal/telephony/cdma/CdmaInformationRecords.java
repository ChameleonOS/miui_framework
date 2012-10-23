// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cdma;

import android.os.Parcel;

public final class CdmaInformationRecords {
    public static class CdmaT53AudioControlInfoRec {

        public String toString() {
            return (new StringBuilder()).append("CdmaT53AudioControlInfoRec: { uplink: ").append(uplink).append(" downlink: ").append(downlink).append(" }").toString();
        }

        public byte downlink;
        public byte uplink;

        public CdmaT53AudioControlInfoRec(int i, int j) {
            uplink = (byte)i;
            downlink = (byte)j;
        }
    }

    public static class CdmaT53ClirInfoRec {

        public String toString() {
            return (new StringBuilder()).append("CdmaT53ClirInfoRec: { cause: ").append(cause).append(" }").toString();
        }

        public byte cause;

        public CdmaT53ClirInfoRec(int i) {
            cause = (byte)i;
        }
    }

    public static class CdmaLineControlInfoRec {

        public String toString() {
            return (new StringBuilder()).append("CdmaLineControlInfoRec: { lineCtrlPolarityIncluded: ").append(lineCtrlPolarityIncluded).append(" lineCtrlToggle: ").append(lineCtrlToggle).append(" lineCtrlReverse: ").append(lineCtrlReverse).append(" lineCtrlPowerDenial: ").append(lineCtrlPowerDenial).append(" }").toString();
        }

        public byte lineCtrlPolarityIncluded;
        public byte lineCtrlPowerDenial;
        public byte lineCtrlReverse;
        public byte lineCtrlToggle;

        public CdmaLineControlInfoRec(int i, int j, int k, int l) {
            lineCtrlPolarityIncluded = (byte)i;
            lineCtrlToggle = (byte)j;
            lineCtrlReverse = (byte)k;
            lineCtrlPowerDenial = (byte)l;
        }
    }

    public static class CdmaRedirectingNumberInfoRec {

        public String toString() {
            return (new StringBuilder()).append("CdmaNumberInfoRec: { numberInfoRec: ").append(numberInfoRec).append(", redirectingReason: ").append(redirectingReason).append(" }").toString();
        }

        public static final int REASON_CALLED_DTE_OUT_OF_ORDER = 9;
        public static final int REASON_CALL_FORWARDING_BUSY = 1;
        public static final int REASON_CALL_FORWARDING_BY_THE_CALLED_DTE = 10;
        public static final int REASON_CALL_FORWARDING_NO_REPLY = 2;
        public static final int REASON_CALL_FORWARDING_UNCONDITIONAL = 15;
        public static final int REASON_UNKNOWN;
        public CdmaNumberInfoRec numberInfoRec;
        public int redirectingReason;

        public CdmaRedirectingNumberInfoRec(String s, int i, int j, int k, int l, int i1) {
            numberInfoRec = new CdmaNumberInfoRec(5, s, i, j, k, l);
            redirectingReason = i1;
        }
    }

    public static class CdmaNumberInfoRec {

        public String toString() {
            return (new StringBuilder()).append("CdmaNumberInfoRec: { id: ").append(CdmaInformationRecords.idToString(id)).append(", number: ").append(number).append(", numberType: ").append(numberType).append(", numberPlan: ").append(numberPlan).append(", pi: ").append(pi).append(", si: ").append(si).append(" }").toString();
        }

        public int id;
        public String number;
        public byte numberPlan;
        public byte numberType;
        public byte pi;
        public byte si;

        public CdmaNumberInfoRec(int i, String s, int j, int k, int l, int i1) {
            number = s;
            numberType = (byte)j;
            numberPlan = (byte)k;
            pi = (byte)l;
            si = (byte)i1;
        }
    }

    public static class CdmaDisplayInfoRec {

        public String toString() {
            return (new StringBuilder()).append("CdmaDisplayInfoRec: { id: ").append(CdmaInformationRecords.idToString(id)).append(", alpha: ").append(alpha).append(" }").toString();
        }

        public String alpha;
        public int id;

        public CdmaDisplayInfoRec(int i, String s) {
            id = i;
            alpha = s;
        }
    }

    public static class CdmaSignalInfoRec {

        public String toString() {
            return (new StringBuilder()).append("CdmaSignalInfo: { isPresent: ").append(isPresent).append(", signalType: ").append(signalType).append(", alertPitch: ").append(alertPitch).append(", signal: ").append(signal).append(" }").toString();
        }

        public int alertPitch;
        public boolean isPresent;
        public int signal;
        public int signalType;

        public CdmaSignalInfoRec() {
        }

        public CdmaSignalInfoRec(int i, int j, int k, int l) {
            boolean flag;
            if(i != 0)
                flag = true;
            else
                flag = false;
            isPresent = flag;
            signalType = j;
            alertPitch = k;
            signal = l;
        }
    }


    public CdmaInformationRecords(Parcel parcel) {
        int i;
        i = parcel.readInt();
        i;
        JVM INSTR tableswitch 0 10: default 68
    //                   0 103
    //                   1 120
    //                   2 120
    //                   3 120
    //                   4 155
    //                   5 185
    //                   6 223
    //                   7 103
    //                   8 253
    //                   9 68
    //                   10 271;
           goto _L1 _L2 _L3 _L3 _L3 _L4 _L5 _L6 _L2 _L7 _L1 _L8
_L1:
        throw new RuntimeException((new StringBuilder()).append("RIL_UNSOL_CDMA_INFO_REC: unsupported record. Got ").append(idToString(i)).append(" ").toString());
_L2:
        record = new CdmaDisplayInfoRec(i, parcel.readString());
_L10:
        return;
_L3:
        record = new CdmaNumberInfoRec(i, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        continue; /* Loop/switch isn't completed */
_L4:
        record = new CdmaSignalInfoRec(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        continue; /* Loop/switch isn't completed */
_L5:
        record = new CdmaRedirectingNumberInfoRec(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        continue; /* Loop/switch isn't completed */
_L6:
        record = new CdmaLineControlInfoRec(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        continue; /* Loop/switch isn't completed */
_L7:
        record = new CdmaT53ClirInfoRec(parcel.readInt());
        continue; /* Loop/switch isn't completed */
_L8:
        record = new CdmaT53AudioControlInfoRec(parcel.readInt(), parcel.readInt());
        if(true) goto _L10; else goto _L9
_L9:
    }

    public static String idToString(int i) {
        i;
        JVM INSTR tableswitch 0 10: default 60
    //                   0 65
    //                   1 71
    //                   2 77
    //                   3 83
    //                   4 89
    //                   5 95
    //                   6 101
    //                   7 107
    //                   8 113
    //                   9 119
    //                   10 125;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L1:
        String s = "<unknown record>";
_L14:
        return s;
_L2:
        s = "RIL_CDMA_DISPLAY_INFO_REC";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "RIL_CDMA_CALLED_PARTY_NUMBER_INFO_REC";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "RIL_CDMA_CALLING_PARTY_NUMBER_INFO_REC";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "RIL_CDMA_CONNECTED_NUMBER_INFO_REC";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "RIL_CDMA_SIGNAL_INFO_REC";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "RIL_CDMA_REDIRECTING_NUMBER_INFO_REC";
        continue; /* Loop/switch isn't completed */
_L8:
        s = "RIL_CDMA_LINE_CONTROL_INFO_REC";
        continue; /* Loop/switch isn't completed */
_L9:
        s = "RIL_CDMA_EXTENDED_DISPLAY_INFO_REC";
        continue; /* Loop/switch isn't completed */
_L10:
        s = "RIL_CDMA_T53_CLIR_INFO_REC";
        continue; /* Loop/switch isn't completed */
_L11:
        s = "RIL_CDMA_T53_RELEASE_INFO_REC";
        continue; /* Loop/switch isn't completed */
_L12:
        s = "RIL_CDMA_T53_AUDIO_CONTROL_INFO_REC";
        if(true) goto _L14; else goto _L13
_L13:
    }

    public static final int RIL_CDMA_CALLED_PARTY_NUMBER_INFO_REC = 1;
    public static final int RIL_CDMA_CALLING_PARTY_NUMBER_INFO_REC = 2;
    public static final int RIL_CDMA_CONNECTED_NUMBER_INFO_REC = 3;
    public static final int RIL_CDMA_DISPLAY_INFO_REC = 0;
    public static final int RIL_CDMA_EXTENDED_DISPLAY_INFO_REC = 7;
    public static final int RIL_CDMA_LINE_CONTROL_INFO_REC = 6;
    public static final int RIL_CDMA_REDIRECTING_NUMBER_INFO_REC = 5;
    public static final int RIL_CDMA_SIGNAL_INFO_REC = 4;
    public static final int RIL_CDMA_T53_AUDIO_CONTROL_INFO_REC = 10;
    public static final int RIL_CDMA_T53_CLIR_INFO_REC = 8;
    public static final int RIL_CDMA_T53_RELEASE_INFO_REC = 9;
    public Object record;
}

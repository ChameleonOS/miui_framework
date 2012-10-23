// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;

import android.os.Parcel;
import android.os.Parcelable;

public final class Tone extends Enum
    implements Parcelable {

    private Tone(String s, int i, int j) {
        super(s, i);
        mValue = j;
    }

    private Tone(String s, int i, Parcel parcel) {
        super(s, i);
        mValue = parcel.readInt();
    }

    public static Tone fromInt(int i) {
        Tone atone[];
        int j;
        int k;
        atone = values();
        j = atone.length;
        k = 0;
_L3:
        Tone tone;
        if(k >= j)
            break MISSING_BLOCK_LABEL_37;
        tone = atone[k];
        if(tone.mValue != i) goto _L2; else goto _L1
_L1:
        return tone;
_L2:
        k++;
          goto _L3
        tone = null;
          goto _L1
    }

    public static Tone valueOf(String s) {
        return (Tone)Enum.valueOf(com/android/internal/telephony/cat/Tone, s);
    }

    public static Tone[] values() {
        return (Tone[])$VALUES.clone();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ordinal());
    }

    private static final Tone $VALUES[];
    public static final Tone BUSY;
    public static final Tone CALL_WAITING;
    public static final Tone CONGESTION;
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Tone createFromParcel(Parcel parcel) {
            return Tone.values()[parcel.readInt()];
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public Tone[] newArray(int i) {
            return new Tone[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final Tone CRITICAL_ALERT;
    public static final Tone DIAL;
    public static final Tone ERROR_SPECIAL_INFO;
    public static final Tone GENERAL_BEEP;
    public static final Tone HAPPY;
    public static final Tone INCOMING_SMS;
    public static final Tone INCOMING_SPEECH_CALL;
    public static final Tone MELODY_1;
    public static final Tone MELODY_2;
    public static final Tone MELODY_3;
    public static final Tone MELODY_4;
    public static final Tone MELODY_5;
    public static final Tone MELODY_6;
    public static final Tone MELODY_7;
    public static final Tone MELODY_8;
    public static final Tone MESSAGE_RECEIVED;
    public static final Tone NEGATIVE_ACK;
    public static final Tone POSITIVE_ACK;
    public static final Tone QUESTION;
    public static final Tone RADIO_PATH_ACK;
    public static final Tone RADIO_PATH_NOT_AVAILABLE;
    public static final Tone RINGING;
    public static final Tone SAD;
    public static final Tone URGENT;
    public static final Tone VIBRATE_ONLY;
    private int mValue;

    static  {
        DIAL = new Tone("DIAL", 0, 1);
        BUSY = new Tone("BUSY", 1, 2);
        CONGESTION = new Tone("CONGESTION", 2, 3);
        RADIO_PATH_ACK = new Tone("RADIO_PATH_ACK", 3, 4);
        RADIO_PATH_NOT_AVAILABLE = new Tone("RADIO_PATH_NOT_AVAILABLE", 4, 5);
        ERROR_SPECIAL_INFO = new Tone("ERROR_SPECIAL_INFO", 5, 6);
        CALL_WAITING = new Tone("CALL_WAITING", 6, 7);
        RINGING = new Tone("RINGING", 7, 8);
        GENERAL_BEEP = new Tone("GENERAL_BEEP", 8, 16);
        POSITIVE_ACK = new Tone("POSITIVE_ACK", 9, 17);
        NEGATIVE_ACK = new Tone("NEGATIVE_ACK", 10, 18);
        INCOMING_SPEECH_CALL = new Tone("INCOMING_SPEECH_CALL", 11, 19);
        INCOMING_SMS = new Tone("INCOMING_SMS", 12, 20);
        CRITICAL_ALERT = new Tone("CRITICAL_ALERT", 13, 21);
        VIBRATE_ONLY = new Tone("VIBRATE_ONLY", 14, 32);
        HAPPY = new Tone("HAPPY", 15, 48);
        SAD = new Tone("SAD", 16, 49);
        URGENT = new Tone("URGENT", 17, 50);
        QUESTION = new Tone("QUESTION", 18, 51);
        MESSAGE_RECEIVED = new Tone("MESSAGE_RECEIVED", 19, 52);
        MELODY_1 = new Tone("MELODY_1", 20, 64);
        MELODY_2 = new Tone("MELODY_2", 21, 65);
        MELODY_3 = new Tone("MELODY_3", 22, 66);
        MELODY_4 = new Tone("MELODY_4", 23, 67);
        MELODY_5 = new Tone("MELODY_5", 24, 68);
        MELODY_6 = new Tone("MELODY_6", 25, 69);
        MELODY_7 = new Tone("MELODY_7", 26, 70);
        MELODY_8 = new Tone("MELODY_8", 27, 71);
        Tone atone[] = new Tone[28];
        atone[0] = DIAL;
        atone[1] = BUSY;
        atone[2] = CONGESTION;
        atone[3] = RADIO_PATH_ACK;
        atone[4] = RADIO_PATH_NOT_AVAILABLE;
        atone[5] = ERROR_SPECIAL_INFO;
        atone[6] = CALL_WAITING;
        atone[7] = RINGING;
        atone[8] = GENERAL_BEEP;
        atone[9] = POSITIVE_ACK;
        atone[10] = NEGATIVE_ACK;
        atone[11] = INCOMING_SPEECH_CALL;
        atone[12] = INCOMING_SMS;
        atone[13] = CRITICAL_ALERT;
        atone[14] = VIBRATE_ONLY;
        atone[15] = HAPPY;
        atone[16] = SAD;
        atone[17] = URGENT;
        atone[18] = QUESTION;
        atone[19] = MESSAGE_RECEIVED;
        atone[20] = MELODY_1;
        atone[21] = MELODY_2;
        atone[22] = MELODY_3;
        atone[23] = MELODY_4;
        atone[24] = MELODY_5;
        atone[25] = MELODY_6;
        atone[26] = MELODY_7;
        atone[27] = MELODY_8;
        $VALUES = atone;
    }
}

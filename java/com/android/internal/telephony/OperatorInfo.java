// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.os.Parcel;
import android.os.Parcelable;

public class OperatorInfo
    implements Parcelable {
    public static final class State extends Enum {

        public static State valueOf(String s) {
            return (State)Enum.valueOf(com/android/internal/telephony/OperatorInfo$State, s);
        }

        public static State[] values() {
            return (State[])$VALUES.clone();
        }

        private static final State $VALUES[];
        public static final State AVAILABLE;
        public static final State CURRENT;
        public static final State FORBIDDEN;
        public static final State UNKNOWN;

        static  {
            UNKNOWN = new State("UNKNOWN", 0);
            AVAILABLE = new State("AVAILABLE", 1);
            CURRENT = new State("CURRENT", 2);
            FORBIDDEN = new State("FORBIDDEN", 3);
            State astate[] = new State[4];
            astate[0] = UNKNOWN;
            astate[1] = AVAILABLE;
            astate[2] = CURRENT;
            astate[3] = FORBIDDEN;
            $VALUES = astate;
        }

        private State(String s, int i) {
            super(s, i);
        }
    }


    OperatorInfo(String s, String s1, String s2, State state1) {
        state = State.UNKNOWN;
        operatorAlphaLong = s;
        operatorAlphaShort = s1;
        operatorNumeric = s2;
        state = state1;
    }

    public OperatorInfo(String s, String s1, String s2, String s3) {
        this(s, s1, s2, rilStateToState(s3));
    }

    private static State rilStateToState(String s) {
        State state1;
        if(s.equals("unknown"))
            state1 = State.UNKNOWN;
        else
        if(s.equals("available"))
            state1 = State.AVAILABLE;
        else
        if(s.equals("current"))
            state1 = State.CURRENT;
        else
        if(s.equals("forbidden"))
            state1 = State.FORBIDDEN;
        else
            throw new RuntimeException((new StringBuilder()).append("RIL impl error: Invalid network state '").append(s).append("'").toString());
        return state1;
    }

    public int describeContents() {
        return 0;
    }

    public String getOperatorAlphaLong() {
        return operatorAlphaLong;
    }

    public String getOperatorAlphaShort() {
        return operatorAlphaShort;
    }

    public String getOperatorNumeric() {
        return operatorNumeric;
    }

    public State getState() {
        return state;
    }

    public String toString() {
        return (new StringBuilder()).append("OperatorInfo ").append(operatorAlphaLong).append("/").append(operatorAlphaShort).append("/").append(operatorNumeric).append("/").append(state).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(operatorAlphaLong);
        parcel.writeString(operatorAlphaShort);
        parcel.writeString(operatorNumeric);
        parcel.writeSerializable(state);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public OperatorInfo createFromParcel(Parcel parcel) {
            return new OperatorInfo(parcel.readString(), parcel.readString(), parcel.readString(), (State)parcel.readSerializable());
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public OperatorInfo[] newArray(int i) {
            return new OperatorInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private String operatorAlphaLong;
    private String operatorAlphaShort;
    private String operatorNumeric;
    private State state;

}

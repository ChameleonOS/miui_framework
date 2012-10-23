// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;

import android.os.Parcel;
import android.os.Parcelable;

public class Duration
    implements Parcelable {
    public static final class TimeUnit extends Enum {

        public static TimeUnit valueOf(String s) {
            return (TimeUnit)Enum.valueOf(com/android/internal/telephony/cat/Duration$TimeUnit, s);
        }

        public static TimeUnit[] values() {
            return (TimeUnit[])$VALUES.clone();
        }

        public int value() {
            return mValue;
        }

        private static final TimeUnit $VALUES[];
        public static final TimeUnit MINUTE;
        public static final TimeUnit SECOND;
        public static final TimeUnit TENTH_SECOND;
        private int mValue;

        static  {
            MINUTE = new TimeUnit("MINUTE", 0, 0);
            SECOND = new TimeUnit("SECOND", 1, 1);
            TENTH_SECOND = new TimeUnit("TENTH_SECOND", 2, 2);
            TimeUnit atimeunit[] = new TimeUnit[3];
            atimeunit[0] = MINUTE;
            atimeunit[1] = SECOND;
            atimeunit[2] = TENTH_SECOND;
            $VALUES = atimeunit;
        }

        private TimeUnit(String s, int i, int j) {
            super(s, i);
            mValue = j;
        }
    }


    public Duration(int i, TimeUnit timeunit) {
        timeInterval = i;
        timeUnit = timeunit;
    }

    private Duration(Parcel parcel) {
        timeInterval = parcel.readInt();
        timeUnit = TimeUnit.values()[parcel.readInt()];
    }


    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(timeInterval);
        parcel.writeInt(timeUnit.ordinal());
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Duration createFromParcel(Parcel parcel) {
            return new Duration(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public Duration[] newArray(int i) {
            return new Duration[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public int timeInterval;
    public TimeUnit timeUnit;

}

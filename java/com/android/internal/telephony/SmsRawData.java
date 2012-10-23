// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.os.Parcel;
import android.os.Parcelable;

public class SmsRawData
    implements Parcelable {

    public SmsRawData(byte abyte0[]) {
        data = abyte0;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getBytes() {
        return data;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(data.length);
        parcel.writeByteArray(data);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public SmsRawData createFromParcel(Parcel parcel) {
            byte abyte0[] = new byte[parcel.readInt()];
            parcel.readByteArray(abyte0);
            return new SmsRawData(abyte0);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public SmsRawData[] newArray(int i) {
            return new SmsRawData[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    byte data[];

}

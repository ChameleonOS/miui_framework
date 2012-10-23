// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.net;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

public class LegacyVpnInfo
    implements Parcelable {

    public LegacyVpnInfo() {
        state = -1;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(key);
        parcel.writeInt(state);
        parcel.writeParcelable(intent, i);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public LegacyVpnInfo createFromParcel(Parcel parcel) {
            LegacyVpnInfo legacyvpninfo = new LegacyVpnInfo();
            legacyvpninfo.key = parcel.readString();
            legacyvpninfo.state = parcel.readInt();
            legacyvpninfo.intent = (PendingIntent)parcel.readParcelable(null);
            return legacyvpninfo;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public LegacyVpnInfo[] newArray(int i) {
            return new LegacyVpnInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int STATE_CONNECTED = 3;
    public static final int STATE_CONNECTING = 2;
    public static final int STATE_DISCONNECTED = 0;
    public static final int STATE_FAILED = 5;
    public static final int STATE_INITIALIZING = 1;
    public static final int STATE_TIMEOUT = 4;
    public PendingIntent intent;
    public String key;
    public int state;

}

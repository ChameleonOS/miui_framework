// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.statusbar;

import android.os.Parcel;
import android.os.Parcelable;

public class StatusBarIcon
    implements Parcelable {

    public StatusBarIcon(Parcel parcel) {
        visible = true;
        readFromParcel(parcel);
    }

    public StatusBarIcon(String s, int i, int j, int k, CharSequence charsequence) {
        visible = true;
        iconPackage = s;
        iconId = i;
        iconLevel = j;
        number = k;
        contentDescription = charsequence;
    }

    public StatusBarIcon clone() {
        StatusBarIcon statusbaricon = new StatusBarIcon(iconPackage, iconId, iconLevel, number, contentDescription);
        statusbaricon.visible = visible;
        return statusbaricon;
    }

    public volatile Object clone() throws CloneNotSupportedException {
        return clone();
    }

    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        iconPackage = parcel.readString();
        iconId = parcel.readInt();
        iconLevel = parcel.readInt();
        boolean flag;
        if(parcel.readInt() != 0)
            flag = true;
        else
            flag = false;
        visible = flag;
        number = parcel.readInt();
        contentDescription = parcel.readCharSequence();
    }

    public String toString() {
        return (new StringBuilder()).append("StatusBarIcon(pkg=").append(iconPackage).append(" id=0x").append(Integer.toHexString(iconId)).append(" level=").append(iconLevel).append(" visible=").append(visible).append(" num=").append(number).append(" )").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(iconPackage);
        parcel.writeInt(iconId);
        parcel.writeInt(iconLevel);
        int j;
        if(visible)
            j = 1;
        else
            j = 0;
        parcel.writeInt(j);
        parcel.writeInt(number);
        parcel.writeCharSequence(contentDescription);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public StatusBarIcon createFromParcel(Parcel parcel) {
            return new StatusBarIcon(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public StatusBarIcon[] newArray(int i) {
            return new StatusBarIcon[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public CharSequence contentDescription;
    public int iconId;
    public int iconLevel;
    public String iconPackage;
    public int number;
    public boolean visible;

}

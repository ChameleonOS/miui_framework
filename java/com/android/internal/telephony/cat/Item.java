// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class Item
    implements Parcelable {

    public Item(int i, String s) {
        id = i;
        text = s;
        icon = null;
    }

    public Item(Parcel parcel) {
        id = parcel.readInt();
        text = parcel.readString();
        icon = (Bitmap)parcel.readParcelable(null);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return text;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(text);
        parcel.writeParcelable(icon, i);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Item createFromParcel(Parcel parcel) {
            return new Item(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public Item[] newArray(int i) {
            return new Item[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public Bitmap icon;
    public int id;
    public String text;

}

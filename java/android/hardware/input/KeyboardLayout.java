// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.hardware.input;

import android.os.Parcel;
import android.os.Parcelable;

public final class KeyboardLayout
    implements Parcelable, Comparable {

    private KeyboardLayout(Parcel parcel) {
        mDescriptor = parcel.readString();
        mLabel = parcel.readString();
        mCollection = parcel.readString();
    }


    public KeyboardLayout(String s, String s1, String s2) {
        mDescriptor = s;
        mLabel = s1;
        mCollection = s2;
    }

    public int compareTo(KeyboardLayout keyboardlayout) {
        int i = mLabel.compareToIgnoreCase(keyboardlayout.mLabel);
        if(i == 0)
            i = mCollection.compareToIgnoreCase(keyboardlayout.mCollection);
        return i;
    }

    public volatile int compareTo(Object obj) {
        return compareTo((KeyboardLayout)obj);
    }

    public int describeContents() {
        return 0;
    }

    public String getCollection() {
        return mCollection;
    }

    public String getDescriptor() {
        return mDescriptor;
    }

    public String getLabel() {
        return mLabel;
    }

    public String toString() {
        String s;
        if(mCollection.isEmpty())
            s = mLabel;
        else
            s = (new StringBuilder()).append(mLabel).append(" - ").append(mCollection).toString();
        return s;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mDescriptor);
        parcel.writeString(mLabel);
        parcel.writeString(mCollection);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public KeyboardLayout createFromParcel(Parcel parcel) {
            return new KeyboardLayout(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public KeyboardLayout[] newArray(int i) {
            return new KeyboardLayout[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private final String mCollection;
    private final String mDescriptor;
    private final String mLabel;

}

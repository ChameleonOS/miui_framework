// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.android.internal.telephony.cat:
//            Duration

public class Input
    implements Parcelable {

    Input() {
        text = "";
        defaultText = null;
        icon = null;
        minLen = 0;
        maxLen = 1;
        ucs2 = false;
        packed = false;
        digitOnly = false;
        echo = false;
        yesNo = false;
        helpAvailable = false;
        duration = null;
    }

    private Input(Parcel parcel) {
        boolean flag = true;
        super();
        text = parcel.readString();
        defaultText = parcel.readString();
        icon = (Bitmap)parcel.readParcelable(null);
        minLen = parcel.readInt();
        maxLen = parcel.readInt();
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        if(parcel.readInt() == flag)
            flag1 = flag;
        else
            flag1 = false;
        ucs2 = flag1;
        if(parcel.readInt() == flag)
            flag2 = flag;
        else
            flag2 = false;
        packed = flag2;
        if(parcel.readInt() == flag)
            flag3 = flag;
        else
            flag3 = false;
        digitOnly = flag3;
        if(parcel.readInt() == flag)
            flag4 = flag;
        else
            flag4 = false;
        echo = flag4;
        if(parcel.readInt() == flag)
            flag5 = flag;
        else
            flag5 = false;
        yesNo = flag5;
        if(parcel.readInt() != flag)
            flag = false;
        helpAvailable = flag;
        duration = (Duration)parcel.readParcelable(null);
    }


    public int describeContents() {
        return 0;
    }

    boolean setIcon(Bitmap bitmap) {
        return true;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int j = 1;
        parcel.writeString(text);
        parcel.writeString(defaultText);
        parcel.writeParcelable(icon, 0);
        parcel.writeInt(minLen);
        parcel.writeInt(maxLen);
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        if(ucs2)
            k = j;
        else
            k = 0;
        parcel.writeInt(k);
        if(packed)
            l = j;
        else
            l = 0;
        parcel.writeInt(l);
        if(digitOnly)
            i1 = j;
        else
            i1 = 0;
        parcel.writeInt(i1);
        if(echo)
            j1 = j;
        else
            j1 = 0;
        parcel.writeInt(j1);
        if(yesNo)
            k1 = j;
        else
            k1 = 0;
        parcel.writeInt(k1);
        if(!helpAvailable)
            j = 0;
        parcel.writeInt(j);
        parcel.writeParcelable(duration, 0);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Input createFromParcel(Parcel parcel) {
            return new Input(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public Input[] newArray(int i) {
            return new Input[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public String defaultText;
    public boolean digitOnly;
    public Duration duration;
    public boolean echo;
    public boolean helpAvailable;
    public Bitmap icon;
    public int maxLen;
    public int minLen;
    public boolean packed;
    public String text;
    public boolean ucs2;
    public boolean yesNo;

}

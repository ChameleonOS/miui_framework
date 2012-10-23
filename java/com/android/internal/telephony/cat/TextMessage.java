// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.android.internal.telephony.cat:
//            Duration

public class TextMessage
    implements Parcelable {

    TextMessage() {
        title = "";
        text = null;
        icon = null;
        iconSelfExplanatory = false;
        isHighPriority = false;
        responseNeeded = true;
        userClear = false;
        duration = null;
    }

    private TextMessage(Parcel parcel) {
        boolean flag = true;
        super();
        title = "";
        text = null;
        icon = null;
        iconSelfExplanatory = false;
        isHighPriority = false;
        responseNeeded = flag;
        userClear = false;
        duration = null;
        title = parcel.readString();
        text = parcel.readString();
        icon = (Bitmap)parcel.readParcelable(null);
        boolean flag1;
        boolean flag2;
        boolean flag3;
        if(parcel.readInt() == flag)
            flag1 = flag;
        else
            flag1 = false;
        iconSelfExplanatory = flag1;
        if(parcel.readInt() == flag)
            flag2 = flag;
        else
            flag2 = false;
        isHighPriority = flag2;
        if(parcel.readInt() == flag)
            flag3 = flag;
        else
            flag3 = false;
        responseNeeded = flag3;
        if(parcel.readInt() != flag)
            flag = false;
        userClear = flag;
        duration = (Duration)parcel.readParcelable(null);
    }


    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int j = 1;
        parcel.writeString(title);
        parcel.writeString(text);
        parcel.writeParcelable(icon, 0);
        int k;
        int l;
        int i1;
        if(iconSelfExplanatory)
            k = j;
        else
            k = 0;
        parcel.writeInt(k);
        if(isHighPriority)
            l = j;
        else
            l = 0;
        parcel.writeInt(l);
        if(responseNeeded)
            i1 = j;
        else
            i1 = 0;
        parcel.writeInt(i1);
        if(!userClear)
            j = 0;
        parcel.writeInt(j);
        parcel.writeParcelable(duration, 0);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TextMessage createFromParcel(Parcel parcel) {
            return new TextMessage(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public TextMessage[] newArray(int i) {
            return new TextMessage[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public Duration duration;
    public Bitmap icon;
    public boolean iconSelfExplanatory;
    public boolean isHighPriority;
    public boolean responseNeeded;
    public String text;
    public String title;
    public boolean userClear;

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.android.internal.telephony.cat:
//            Duration, Tone

public class ToneSettings
    implements Parcelable {

    private ToneSettings(Parcel parcel) {
        duration = (Duration)parcel.readParcelable(null);
        tone = (Tone)parcel.readParcelable(null);
        boolean flag;
        if(parcel.readInt() == 1)
            flag = true;
        else
            flag = false;
        vibrate = flag;
    }


    public ToneSettings(Duration duration1, Tone tone1, boolean flag) {
        duration = duration1;
        tone = tone1;
        vibrate = flag;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int j = 0;
        parcel.writeParcelable(duration, 0);
        parcel.writeParcelable(tone, 0);
        if(vibrate)
            j = 1;
        parcel.writeInt(j);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ToneSettings createFromParcel(Parcel parcel) {
            return new ToneSettings(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public ToneSettings[] newArray(int i) {
            return new ToneSettings[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public Duration duration;
    public Tone tone;
    public boolean vibrate;

}

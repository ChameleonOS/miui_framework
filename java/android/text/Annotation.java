// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text;

import android.os.Parcel;

// Referenced classes of package android.text:
//            ParcelableSpan

public class Annotation
    implements ParcelableSpan {

    public Annotation(Parcel parcel) {
        mKey = parcel.readString();
        mValue = parcel.readString();
    }

    public Annotation(String s, String s1) {
        mKey = s;
        mValue = s1;
    }

    public int describeContents() {
        return 0;
    }

    public String getKey() {
        return mKey;
    }

    public int getSpanTypeId() {
        return 18;
    }

    public String getValue() {
        return mValue;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mKey);
        parcel.writeString(mValue);
    }

    private final String mKey;
    private final String mValue;
}

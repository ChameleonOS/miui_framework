// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.style;

import android.os.Parcel;
import android.text.ParcelableSpan;

public class EasyEditSpan
    implements ParcelableSpan {

    public EasyEditSpan() {
    }

    public int describeContents() {
        return 0;
    }

    public int getSpanTypeId() {
        return 22;
    }

    public void writeToParcel(Parcel parcel, int i) {
    }
}

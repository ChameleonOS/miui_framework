// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.style;

import android.os.Parcel;
import android.text.ParcelableSpan;

public class SpellCheckSpan
    implements ParcelableSpan {

    public SpellCheckSpan() {
        mSpellCheckInProgress = false;
    }

    public SpellCheckSpan(Parcel parcel) {
        boolean flag;
        if(parcel.readInt() != 0)
            flag = true;
        else
            flag = false;
        mSpellCheckInProgress = flag;
    }

    public int describeContents() {
        return 0;
    }

    public int getSpanTypeId() {
        return 20;
    }

    public boolean isSpellCheckInProgress() {
        return mSpellCheckInProgress;
    }

    public void setSpellCheckInProgress(boolean flag) {
        mSpellCheckInProgress = flag;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int j;
        if(mSpellCheckInProgress)
            j = 1;
        else
            j = 0;
        parcel.writeInt(j);
    }

    private boolean mSpellCheckInProgress;
}

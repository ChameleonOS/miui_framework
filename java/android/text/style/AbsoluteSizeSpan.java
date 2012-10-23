// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.style;

import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;

// Referenced classes of package android.text.style:
//            MetricAffectingSpan

public class AbsoluteSizeSpan extends MetricAffectingSpan
    implements ParcelableSpan {

    public AbsoluteSizeSpan(int i) {
        mSize = i;
    }

    public AbsoluteSizeSpan(int i, boolean flag) {
        mSize = i;
        mDip = flag;
    }

    public AbsoluteSizeSpan(Parcel parcel) {
        mSize = parcel.readInt();
        boolean flag;
        if(parcel.readInt() != 0)
            flag = true;
        else
            flag = false;
        mDip = flag;
    }

    public int describeContents() {
        return 0;
    }

    public boolean getDip() {
        return mDip;
    }

    public int getSize() {
        return mSize;
    }

    public int getSpanTypeId() {
        return 16;
    }

    public void updateDrawState(TextPaint textpaint) {
        if(mDip)
            textpaint.setTextSize((float)mSize * textpaint.density);
        else
            textpaint.setTextSize(mSize);
    }

    public void updateMeasureState(TextPaint textpaint) {
        if(mDip)
            textpaint.setTextSize((float)mSize * textpaint.density);
        else
            textpaint.setTextSize(mSize);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mSize);
        int j;
        if(mDip)
            j = 1;
        else
            j = 0;
        parcel.writeInt(j);
    }

    private boolean mDip;
    private final int mSize;
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.style;

import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;

// Referenced classes of package android.text.style:
//            MetricAffectingSpan

public class ScaleXSpan extends MetricAffectingSpan
    implements ParcelableSpan {

    public ScaleXSpan(float f) {
        mProportion = f;
    }

    public ScaleXSpan(Parcel parcel) {
        mProportion = parcel.readFloat();
    }

    public int describeContents() {
        return 0;
    }

    public float getScaleX() {
        return mProportion;
    }

    public int getSpanTypeId() {
        return 4;
    }

    public void updateDrawState(TextPaint textpaint) {
        textpaint.setTextScaleX(textpaint.getTextScaleX() * mProportion);
    }

    public void updateMeasureState(TextPaint textpaint) {
        textpaint.setTextScaleX(textpaint.getTextScaleX() * mProportion);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(mProportion);
    }

    private final float mProportion;
}

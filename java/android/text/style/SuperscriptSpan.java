// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.style;

import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;

// Referenced classes of package android.text.style:
//            MetricAffectingSpan

public class SuperscriptSpan extends MetricAffectingSpan
    implements ParcelableSpan {

    public SuperscriptSpan() {
    }

    public SuperscriptSpan(Parcel parcel) {
    }

    public int describeContents() {
        return 0;
    }

    public int getSpanTypeId() {
        return 14;
    }

    public void updateDrawState(TextPaint textpaint) {
        textpaint.baselineShift = textpaint.baselineShift + (int)(textpaint.ascent() / 2.0F);
    }

    public void updateMeasureState(TextPaint textpaint) {
        textpaint.baselineShift = textpaint.baselineShift + (int)(textpaint.ascent() / 2.0F);
    }

    public void writeToParcel(Parcel parcel, int i) {
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.style;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;

// Referenced classes of package android.text.style:
//            MetricAffectingSpan

public class StyleSpan extends MetricAffectingSpan
    implements ParcelableSpan {

    public StyleSpan(int i) {
        mStyle = i;
    }

    public StyleSpan(Parcel parcel) {
        mStyle = parcel.readInt();
    }

    private static void apply(Paint paint, int i) {
        Typeface typeface = paint.getTypeface();
        int j;
        int k;
        Typeface typeface1;
        int l;
        if(typeface == null)
            j = 0;
        else
            j = typeface.getStyle();
        k = j | i;
        if(typeface == null)
            typeface1 = Typeface.defaultFromStyle(k);
        else
            typeface1 = Typeface.create(typeface, k);
        l = k & (-1 ^ typeface1.getStyle());
        if((l & 1) != 0)
            paint.setFakeBoldText(true);
        if((l & 2) != 0)
            paint.setTextSkewX(-0.25F);
        paint.setTypeface(typeface1);
    }

    public int describeContents() {
        return 0;
    }

    public int getSpanTypeId() {
        return 7;
    }

    public int getStyle() {
        return mStyle;
    }

    public void updateDrawState(TextPaint textpaint) {
        apply(textpaint, mStyle);
    }

    public void updateMeasureState(TextPaint textpaint) {
        apply(textpaint, mStyle);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mStyle);
    }

    private final int mStyle;
}

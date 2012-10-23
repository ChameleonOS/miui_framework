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

public class TypefaceSpan extends MetricAffectingSpan
    implements ParcelableSpan {

    public TypefaceSpan(Parcel parcel) {
        mFamily = parcel.readString();
    }

    public TypefaceSpan(String s) {
        mFamily = s;
    }

    private static void apply(Paint paint, String s) {
        Typeface typeface = paint.getTypeface();
        int i;
        Typeface typeface1;
        int j;
        if(typeface == null)
            i = 0;
        else
            i = typeface.getStyle();
        typeface1 = Typeface.create(s, i);
        j = i & (-1 ^ typeface1.getStyle());
        if((j & 1) != 0)
            paint.setFakeBoldText(true);
        if((j & 2) != 0)
            paint.setTextSkewX(-0.25F);
        paint.setTypeface(typeface1);
    }

    public int describeContents() {
        return 0;
    }

    public String getFamily() {
        return mFamily;
    }

    public int getSpanTypeId() {
        return 13;
    }

    public void updateDrawState(TextPaint textpaint) {
        apply(textpaint, mFamily);
    }

    public void updateMeasureState(TextPaint textpaint) {
        apply(textpaint, mFamily);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mFamily);
    }

    private final String mFamily;
}

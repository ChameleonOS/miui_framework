// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.text.Layout;
import android.text.ParcelableSpan;

// Referenced classes of package android.text.style:
//            LeadingMarginSpan

public class QuoteSpan
    implements LeadingMarginSpan, ParcelableSpan {

    public QuoteSpan() {
        mColor = 0xff0000ff;
    }

    public QuoteSpan(int i) {
        mColor = i;
    }

    public QuoteSpan(Parcel parcel) {
        mColor = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int j, int k, int l, int i1, 
            CharSequence charsequence, int j1, int k1, boolean flag, Layout layout) {
        android.graphics.Paint.Style style = paint.getStyle();
        int l1 = paint.getColor();
        paint.setStyle(android.graphics.Paint.Style.FILL);
        paint.setColor(mColor);
        canvas.drawRect(i, k, i + j * 2, i1, paint);
        paint.setStyle(style);
        paint.setColor(l1);
    }

    public int getColor() {
        return mColor;
    }

    public int getLeadingMargin(boolean flag) {
        return 4;
    }

    public int getSpanTypeId() {
        return 9;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mColor);
    }

    private static final int GAP_WIDTH = 2;
    private static final int STRIPE_WIDTH = 2;
    private final int mColor;
}

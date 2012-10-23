// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.style;

import android.graphics.*;
import android.os.Parcel;
import android.text.*;

// Referenced classes of package android.text.style:
//            LeadingMarginSpan

public class BulletSpan
    implements LeadingMarginSpan, ParcelableSpan {

    public BulletSpan() {
        mGapWidth = 2;
        mWantColor = false;
        mColor = 0;
    }

    public BulletSpan(int i) {
        mGapWidth = i;
        mWantColor = false;
        mColor = 0;
    }

    public BulletSpan(int i, int j) {
        mGapWidth = i;
        mWantColor = true;
        mColor = j;
    }

    public BulletSpan(Parcel parcel) {
        mGapWidth = parcel.readInt();
        boolean flag;
        if(parcel.readInt() != 0)
            flag = true;
        else
            flag = false;
        mWantColor = flag;
        mColor = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int j, int k, int l, int i1, 
            CharSequence charsequence, int j1, int k1, boolean flag, Layout layout) {
        if(((Spanned)charsequence).getSpanStart(this) == j1) {
            android.graphics.Paint.Style style = paint.getStyle();
            int l1 = 0;
            if(mWantColor) {
                l1 = paint.getColor();
                paint.setColor(mColor);
            }
            paint.setStyle(android.graphics.Paint.Style.FILL);
            if(canvas.isHardwareAccelerated()) {
                if(sBulletPath == null) {
                    sBulletPath = new Path();
                    sBulletPath.addCircle(0.0F, 0.0F, 3.6F, android.graphics.Path.Direction.CW);
                }
                canvas.save();
                canvas.translate(i + j * 3, (float)(k + i1) / 2.0F);
                canvas.drawPath(sBulletPath, paint);
                canvas.restore();
            } else {
                canvas.drawCircle(i + j * 3, (float)(k + i1) / 2.0F, 3F, paint);
            }
            if(mWantColor)
                paint.setColor(l1);
            paint.setStyle(style);
        }
    }

    public int getLeadingMargin(boolean flag) {
        return 6 + mGapWidth;
    }

    public int getSpanTypeId() {
        return 8;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mGapWidth);
        int j;
        if(mWantColor)
            j = 1;
        else
            j = 0;
        parcel.writeInt(j);
        parcel.writeInt(mColor);
    }

    private static final int BULLET_RADIUS = 3;
    public static final int STANDARD_GAP_WIDTH = 2;
    private static Path sBulletPath = null;
    private final int mColor;
    private final int mGapWidth;
    private final boolean mWantColor;

}

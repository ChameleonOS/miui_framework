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
//            ParagraphStyle, WrapTogetherSpan

public interface LeadingMarginSpan
    extends ParagraphStyle {
    public static class Standard
        implements LeadingMarginSpan, ParcelableSpan {

        public int describeContents() {
            return 0;
        }

        public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int j, int k, int l, int i1, 
                CharSequence charsequence, int j1, int k1, boolean flag, Layout layout) {
        }

        public int getLeadingMargin(boolean flag) {
            int i;
            if(flag)
                i = mFirst;
            else
                i = mRest;
            return i;
        }

        public int getSpanTypeId() {
            return 10;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(mFirst);
            parcel.writeInt(mRest);
        }

        private final int mFirst;
        private final int mRest;

        public Standard(int i) {
            this(i, i);
        }

        public Standard(int i, int j) {
            mFirst = i;
            mRest = j;
        }

        public Standard(Parcel parcel) {
            mFirst = parcel.readInt();
            mRest = parcel.readInt();
        }
    }

    public static interface LeadingMarginSpan2
        extends LeadingMarginSpan, WrapTogetherSpan {

        public abstract int getLeadingMarginLineCount();
    }


    public abstract void drawLeadingMargin(Canvas canvas, Paint paint, int i, int j, int k, int l, int i1, 
            CharSequence charsequence, int j1, int k1, boolean flag, Layout layout);

    public abstract int getLeadingMargin(boolean flag);
}

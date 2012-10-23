// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.style;

import android.os.Parcel;
import android.text.ParcelableSpan;

// Referenced classes of package android.text.style:
//            ParagraphStyle

public interface AlignmentSpan
    extends ParagraphStyle {
    public static class Standard
        implements AlignmentSpan, ParcelableSpan {

        public int describeContents() {
            return 0;
        }

        public android.text.Layout.Alignment getAlignment() {
            return mAlignment;
        }

        public int getSpanTypeId() {
            return 1;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(mAlignment.name());
        }

        private final android.text.Layout.Alignment mAlignment;

        public Standard(Parcel parcel) {
            mAlignment = android.text.Layout.Alignment.valueOf(parcel.readString());
        }

        public Standard(android.text.Layout.Alignment alignment) {
            mAlignment = alignment;
        }
    }


    public abstract android.text.Layout.Alignment getAlignment();
}

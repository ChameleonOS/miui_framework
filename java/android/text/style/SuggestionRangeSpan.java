// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.style;

import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;

// Referenced classes of package android.text.style:
//            CharacterStyle

public class SuggestionRangeSpan extends CharacterStyle
    implements ParcelableSpan {

    public SuggestionRangeSpan() {
        mBackgroundColor = 0;
    }

    public SuggestionRangeSpan(Parcel parcel) {
        mBackgroundColor = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public int getSpanTypeId() {
        return 21;
    }

    public void setBackgroundColor(int i) {
        mBackgroundColor = i;
    }

    public void updateDrawState(TextPaint textpaint) {
        textpaint.bgColor = mBackgroundColor;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mBackgroundColor);
    }

    private int mBackgroundColor;
}

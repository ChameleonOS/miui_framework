// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.style;

import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;

// Referenced classes of package android.text.style:
//            CharacterStyle, UpdateAppearance

public class BackgroundColorSpan extends CharacterStyle
    implements UpdateAppearance, ParcelableSpan {

    public BackgroundColorSpan(int i) {
        mColor = i;
    }

    public BackgroundColorSpan(Parcel parcel) {
        mColor = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public int getBackgroundColor() {
        return mColor;
    }

    public int getSpanTypeId() {
        return 12;
    }

    public void updateDrawState(TextPaint textpaint) {
        textpaint.bgColor = mColor;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mColor);
    }

    private final int mColor;
}

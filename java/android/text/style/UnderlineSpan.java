// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.style;

import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;

// Referenced classes of package android.text.style:
//            CharacterStyle, UpdateAppearance

public class UnderlineSpan extends CharacterStyle
    implements UpdateAppearance, ParcelableSpan {

    public UnderlineSpan() {
    }

    public UnderlineSpan(Parcel parcel) {
    }

    public int describeContents() {
        return 0;
    }

    public int getSpanTypeId() {
        return 6;
    }

    public void updateDrawState(TextPaint textpaint) {
        textpaint.setUnderlineText(true);
    }

    public void writeToParcel(Parcel parcel, int i) {
    }
}

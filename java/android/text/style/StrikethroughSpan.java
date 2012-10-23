// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.style;

import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;

// Referenced classes of package android.text.style:
//            CharacterStyle, UpdateAppearance

public class StrikethroughSpan extends CharacterStyle
    implements UpdateAppearance, ParcelableSpan {

    public StrikethroughSpan() {
    }

    public StrikethroughSpan(Parcel parcel) {
    }

    public int describeContents() {
        return 0;
    }

    public int getSpanTypeId() {
        return 5;
    }

    public void updateDrawState(TextPaint textpaint) {
        textpaint.setStrikeThruText(true);
    }

    public void writeToParcel(Parcel parcel, int i) {
    }
}

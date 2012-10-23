// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.style;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;

// Referenced classes of package android.text.style:
//            MetricAffectingSpan

public class TextAppearanceSpan extends MetricAffectingSpan
    implements ParcelableSpan {

    public TextAppearanceSpan(Context context, int i) {
        this(context, i, -1);
    }

    public TextAppearanceSpan(Context context, int i, int j) {
        TypedArray typedarray;
        ColorStateList colorstatelist;
        String s;
        typedarray = context.obtainStyledAttributes(i, com.android.internal.R.styleable.TextAppearance);
        colorstatelist = typedarray.getColorStateList(3);
        mTextColorLink = typedarray.getColorStateList(6);
        mTextSize = typedarray.getDimensionPixelSize(0, -1);
        mStyle = typedarray.getInt(2, 0);
        s = typedarray.getString(8);
        if(s == null) goto _L2; else goto _L1
_L1:
        mTypeface = s;
_L4:
        typedarray.recycle();
        if(j >= 0) {
            TypedArray typedarray1 = context.obtainStyledAttributes(0x1030005, com.android.internal.R.styleable.Theme);
            colorstatelist = typedarray1.getColorStateList(j);
            typedarray1.recycle();
        }
        mTextColor = colorstatelist;
        return;
_L2:
        switch(typedarray.getInt(1, 0)) {
        default:
            mTypeface = null;
            break;

        case 1: // '\001'
            mTypeface = "sans";
            break;

        case 2: // '\002'
            mTypeface = "serif";
            break;

        case 3: // '\003'
            mTypeface = "monospace";
            break;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public TextAppearanceSpan(Parcel parcel) {
        mTypeface = parcel.readString();
        mStyle = parcel.readInt();
        mTextSize = parcel.readInt();
        if(parcel.readInt() != 0)
            mTextColor = (ColorStateList)ColorStateList.CREATOR.createFromParcel(parcel);
        else
            mTextColor = null;
        if(parcel.readInt() != 0)
            mTextColorLink = (ColorStateList)ColorStateList.CREATOR.createFromParcel(parcel);
        else
            mTextColorLink = null;
    }

    public TextAppearanceSpan(String s, int i, int j, ColorStateList colorstatelist, ColorStateList colorstatelist1) {
        mTypeface = s;
        mStyle = i;
        mTextSize = j;
        mTextColor = colorstatelist;
        mTextColorLink = colorstatelist1;
    }

    public int describeContents() {
        return 0;
    }

    public String getFamily() {
        return mTypeface;
    }

    public ColorStateList getLinkTextColor() {
        return mTextColorLink;
    }

    public int getSpanTypeId() {
        return 17;
    }

    public ColorStateList getTextColor() {
        return mTextColor;
    }

    public int getTextSize() {
        return mTextSize;
    }

    public int getTextStyle() {
        return mStyle;
    }

    public void updateDrawState(TextPaint textpaint) {
        updateMeasureState(textpaint);
        if(mTextColor != null)
            textpaint.setColor(mTextColor.getColorForState(textpaint.drawableState, 0));
        if(mTextColorLink != null)
            textpaint.linkColor = mTextColorLink.getColorForState(textpaint.drawableState, 0);
    }

    public void updateMeasureState(TextPaint textpaint) {
        if(mTypeface != null || mStyle != 0) {
            Typeface typeface = textpaint.getTypeface();
            int i = 0;
            if(typeface != null)
                i = typeface.getStyle();
            int j = i | mStyle;
            Typeface typeface1;
            int k;
            if(mTypeface != null)
                typeface1 = Typeface.create(mTypeface, j);
            else
            if(typeface == null)
                typeface1 = Typeface.defaultFromStyle(j);
            else
                typeface1 = Typeface.create(typeface, j);
            k = j & (-1 ^ typeface1.getStyle());
            if((k & 1) != 0)
                textpaint.setFakeBoldText(true);
            if((k & 2) != 0)
                textpaint.setTextSkewX(-0.25F);
            textpaint.setTypeface(typeface1);
        }
        if(mTextSize > 0)
            textpaint.setTextSize(mTextSize);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mTypeface);
        parcel.writeInt(mStyle);
        parcel.writeInt(mTextSize);
        if(mTextColor != null) {
            parcel.writeInt(1);
            mTextColor.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
        if(mTextColorLink != null) {
            parcel.writeInt(1);
            mTextColorLink.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
    }

    private final int mStyle;
    private final ColorStateList mTextColor;
    private final ColorStateList mTextColorLink;
    private final int mTextSize;
    private final String mTypeface;
}

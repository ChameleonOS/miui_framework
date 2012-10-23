// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.style;

import android.content.Context;
import android.content.res.*;
import android.os.Parcel;
import android.os.SystemClock;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.util.Log;
import java.util.Arrays;
import java.util.Locale;

// Referenced classes of package android.text.style:
//            CharacterStyle

public class SuggestionSpan extends CharacterStyle
    implements ParcelableSpan {

    public SuggestionSpan(Context context, Locale locale, String as[], int i, Class class1) {
        mSuggestions = (String[])Arrays.copyOf(as, Math.min(5, as.length));
        mFlags = i;
        if(locale != null)
            mLocaleString = locale.toString();
        else
        if(context != null) {
            mLocaleString = context.getResources().getConfiguration().locale.toString();
        } else {
            Log.e("SuggestionSpan", "No locale or context specified in SuggestionSpan constructor");
            mLocaleString = "";
        }
        if(class1 != null)
            mNotificationTargetClassName = class1.getCanonicalName();
        else
            mNotificationTargetClassName = "";
        mHashCode = hashCodeInternal(mSuggestions, mLocaleString, mNotificationTargetClassName);
        initStyle(context);
    }

    public SuggestionSpan(Context context, String as[], int i) {
        this(context, null, as, i, null);
    }

    public SuggestionSpan(Parcel parcel) {
        mSuggestions = parcel.readStringArray();
        mFlags = parcel.readInt();
        mLocaleString = parcel.readString();
        mNotificationTargetClassName = parcel.readString();
        mHashCode = parcel.readInt();
        mEasyCorrectUnderlineColor = parcel.readInt();
        mEasyCorrectUnderlineThickness = parcel.readFloat();
        mMisspelledUnderlineColor = parcel.readInt();
        mMisspelledUnderlineThickness = parcel.readFloat();
        mAutoCorrectionUnderlineColor = parcel.readInt();
        mAutoCorrectionUnderlineThickness = parcel.readFloat();
    }

    public SuggestionSpan(Locale locale, String as[], int i) {
        this(null, locale, as, i, null);
    }

    private static int hashCodeInternal(String as[], String s, String s1) {
        Object aobj[] = new Object[4];
        aobj[0] = Long.valueOf(SystemClock.uptimeMillis());
        aobj[1] = as;
        aobj[2] = s;
        aobj[3] = s1;
        return Arrays.hashCode(aobj);
    }

    private void initStyle(Context context) {
        if(context == null) {
            mMisspelledUnderlineThickness = 0.0F;
            mEasyCorrectUnderlineThickness = 0.0F;
            mAutoCorrectionUnderlineThickness = 0.0F;
            mMisspelledUnderlineColor = 0xff000000;
            mEasyCorrectUnderlineColor = 0xff000000;
            mAutoCorrectionUnderlineColor = 0xff000000;
        } else {
            TypedArray typedarray = context.obtainStyledAttributes(null, com.android.internal.R.styleable.SuggestionSpan, 0x10103b1, 0);
            mMisspelledUnderlineThickness = typedarray.getDimension(1, 0.0F);
            mMisspelledUnderlineColor = typedarray.getColor(0, 0xff000000);
            TypedArray typedarray1 = context.obtainStyledAttributes(null, com.android.internal.R.styleable.SuggestionSpan, 0x10103b0, 0);
            mEasyCorrectUnderlineThickness = typedarray1.getDimension(1, 0.0F);
            mEasyCorrectUnderlineColor = typedarray1.getColor(0, 0xff000000);
            TypedArray typedarray2 = context.obtainStyledAttributes(null, com.android.internal.R.styleable.SuggestionSpan, 0x10103b2, 0);
            mAutoCorrectionUnderlineThickness = typedarray2.getDimension(1, 0.0F);
            mAutoCorrectionUnderlineColor = typedarray2.getColor(0, 0xff000000);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean flag = false;
        if((obj instanceof SuggestionSpan) && ((SuggestionSpan)obj).hashCode() == mHashCode)
            flag = true;
        return flag;
    }

    public int getFlags() {
        return mFlags;
    }

    public String getLocale() {
        return mLocaleString;
    }

    public String getNotificationTargetClassName() {
        return mNotificationTargetClassName;
    }

    public int getSpanTypeId() {
        return 19;
    }

    public String[] getSuggestions() {
        return mSuggestions;
    }

    public int getUnderlineColor() {
        int i;
        boolean flag2;
        i = 0;
        boolean flag;
        boolean flag1;
        if((2 & mFlags) != 0)
            flag = true;
        else
            flag = false;
        if((1 & mFlags) != 0)
            flag1 = true;
        else
            flag1 = false;
        if((4 & mFlags) != 0)
            flag2 = true;
        else
            flag2 = false;
        if(!flag1) goto _L2; else goto _L1
_L1:
        if(!flag)
            i = mEasyCorrectUnderlineColor;
        else
            i = mMisspelledUnderlineColor;
_L4:
        return i;
_L2:
        if(flag2)
            i = mAutoCorrectionUnderlineColor;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int hashCode() {
        return mHashCode;
    }

    public void setFlags(int i) {
        mFlags = i;
    }

    public void updateDrawState(TextPaint textpaint) {
        boolean flag2;
        boolean flag;
        boolean flag1;
        if((2 & mFlags) != 0)
            flag = true;
        else
            flag = false;
        if((1 & mFlags) != 0)
            flag1 = true;
        else
            flag1 = false;
        if((4 & mFlags) != 0)
            flag2 = true;
        else
            flag2 = false;
        if(!flag1) goto _L2; else goto _L1
_L1:
        if(flag) goto _L4; else goto _L3
_L3:
        textpaint.setUnderlineText(mEasyCorrectUnderlineColor, mEasyCorrectUnderlineThickness);
_L6:
        return;
_L4:
        if(textpaint.underlineColor == 0)
            textpaint.setUnderlineText(mMisspelledUnderlineColor, mMisspelledUnderlineThickness);
        continue; /* Loop/switch isn't completed */
_L2:
        if(flag2)
            textpaint.setUnderlineText(mAutoCorrectionUnderlineColor, mAutoCorrectionUnderlineThickness);
        if(true) goto _L6; else goto _L5
_L5:
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(mSuggestions);
        parcel.writeInt(mFlags);
        parcel.writeString(mLocaleString);
        parcel.writeString(mNotificationTargetClassName);
        parcel.writeInt(mHashCode);
        parcel.writeInt(mEasyCorrectUnderlineColor);
        parcel.writeFloat(mEasyCorrectUnderlineThickness);
        parcel.writeInt(mMisspelledUnderlineColor);
        parcel.writeFloat(mMisspelledUnderlineThickness);
        parcel.writeInt(mAutoCorrectionUnderlineColor);
        parcel.writeFloat(mAutoCorrectionUnderlineThickness);
    }

    public static final String ACTION_SUGGESTION_PICKED = "android.text.style.SUGGESTION_PICKED";
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public SuggestionSpan createFromParcel(Parcel parcel) {
            return new SuggestionSpan(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public SuggestionSpan[] newArray(int i) {
            return new SuggestionSpan[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int FLAG_AUTO_CORRECTION = 4;
    public static final int FLAG_EASY_CORRECT = 1;
    public static final int FLAG_MISSPELLED = 2;
    public static final int SUGGESTIONS_MAX_SIZE = 5;
    public static final String SUGGESTION_SPAN_PICKED_AFTER = "after";
    public static final String SUGGESTION_SPAN_PICKED_BEFORE = "before";
    public static final String SUGGESTION_SPAN_PICKED_HASHCODE = "hashcode";
    private int mAutoCorrectionUnderlineColor;
    private float mAutoCorrectionUnderlineThickness;
    private int mEasyCorrectUnderlineColor;
    private float mEasyCorrectUnderlineThickness;
    private int mFlags;
    private final int mHashCode;
    private final String mLocaleString;
    private int mMisspelledUnderlineColor;
    private float mMisspelledUnderlineThickness;
    private final String mNotificationTargetClassName;
    private final String mSuggestions[];

}

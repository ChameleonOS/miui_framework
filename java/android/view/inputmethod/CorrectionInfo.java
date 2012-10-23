// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.inputmethod;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public final class CorrectionInfo
    implements Parcelable {

    public CorrectionInfo(int i, CharSequence charsequence, CharSequence charsequence1) {
        mOffset = i;
        mOldText = charsequence;
        mNewText = charsequence1;
    }

    private CorrectionInfo(Parcel parcel) {
        mOffset = parcel.readInt();
        mOldText = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        mNewText = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
    }


    public int describeContents() {
        return 0;
    }

    public CharSequence getNewText() {
        return mNewText;
    }

    public int getOffset() {
        return mOffset;
    }

    public CharSequence getOldText() {
        return mOldText;
    }

    public String toString() {
        return (new StringBuilder()).append("CorrectionInfo{#").append(mOffset).append(" \"").append(mOldText).append("\" -> \"").append(mNewText).append("\"}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mOffset);
        TextUtils.writeToParcel(mOldText, parcel, i);
        TextUtils.writeToParcel(mNewText, parcel, i);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public CorrectionInfo createFromParcel(Parcel parcel) {
            return new CorrectionInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public CorrectionInfo[] newArray(int i) {
            return new CorrectionInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private final CharSequence mNewText;
    private final int mOffset;
    private final CharSequence mOldText;

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.inputmethod;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public final class CompletionInfo
    implements Parcelable {

    public CompletionInfo(long l, int i, CharSequence charsequence) {
        mId = l;
        mPosition = i;
        mText = charsequence;
        mLabel = null;
    }

    public CompletionInfo(long l, int i, CharSequence charsequence, CharSequence charsequence1) {
        mId = l;
        mPosition = i;
        mText = charsequence;
        mLabel = charsequence1;
    }

    private CompletionInfo(Parcel parcel) {
        mId = parcel.readLong();
        mPosition = parcel.readInt();
        mText = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        mLabel = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
    }


    public int describeContents() {
        return 0;
    }

    public long getId() {
        return mId;
    }

    public CharSequence getLabel() {
        return mLabel;
    }

    public int getPosition() {
        return mPosition;
    }

    public CharSequence getText() {
        return mText;
    }

    public String toString() {
        return (new StringBuilder()).append("CompletionInfo{#").append(mPosition).append(" \"").append(mText).append("\" id=").append(mId).append(" label=").append(mLabel).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(mId);
        parcel.writeInt(mPosition);
        TextUtils.writeToParcel(mText, parcel, i);
        TextUtils.writeToParcel(mLabel, parcel, i);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public CompletionInfo createFromParcel(Parcel parcel) {
            return new CompletionInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public CompletionInfo[] newArray(int i) {
            return new CompletionInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private final long mId;
    private final CharSequence mLabel;
    private final int mPosition;
    private final CharSequence mText;

}

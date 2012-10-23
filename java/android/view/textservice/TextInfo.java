// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.textservice;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public final class TextInfo
    implements Parcelable {

    public TextInfo(Parcel parcel) {
        mText = parcel.readString();
        mCookie = parcel.readInt();
        mSequence = parcel.readInt();
    }

    public TextInfo(String s) {
        this(s, 0, 0);
    }

    public TextInfo(String s, int i, int j) {
        if(TextUtils.isEmpty(s)) {
            throw new IllegalArgumentException(s);
        } else {
            mText = s;
            mCookie = i;
            mSequence = j;
            return;
        }
    }

    public int describeContents() {
        return 0;
    }

    public int getCookie() {
        return mCookie;
    }

    public int getSequence() {
        return mSequence;
    }

    public String getText() {
        return mText;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mText);
        parcel.writeInt(mCookie);
        parcel.writeInt(mSequence);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TextInfo createFromParcel(Parcel parcel) {
            return new TextInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public TextInfo[] newArray(int i) {
            return new TextInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private final int mCookie;
    private final int mSequence;
    private final String mText;

}

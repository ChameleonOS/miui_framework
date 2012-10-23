// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.textservice;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

// Referenced classes of package android.view.textservice:
//            SuggestionsInfo

public final class SentenceSuggestionsInfo
    implements Parcelable {

    public SentenceSuggestionsInfo(Parcel parcel) {
        mSuggestionsInfos = new SuggestionsInfo[parcel.readInt()];
        parcel.readTypedArray(mSuggestionsInfos, SuggestionsInfo.CREATOR);
        mOffsets = new int[mSuggestionsInfos.length];
        parcel.readIntArray(mOffsets);
        mLengths = new int[mSuggestionsInfos.length];
        parcel.readIntArray(mLengths);
    }

    public SentenceSuggestionsInfo(SuggestionsInfo asuggestionsinfo[], int ai[], int ai1[]) {
        if(asuggestionsinfo == null || ai == null || ai1 == null)
            throw new NullPointerException();
        if(asuggestionsinfo.length != ai.length || ai.length != ai1.length) {
            throw new IllegalArgumentException();
        } else {
            int i = asuggestionsinfo.length;
            mSuggestionsInfos = (SuggestionsInfo[])Arrays.copyOf(asuggestionsinfo, i);
            mOffsets = Arrays.copyOf(ai, i);
            mLengths = Arrays.copyOf(ai1, i);
            return;
        }
    }

    public int describeContents() {
        return 0;
    }

    public int getLengthAt(int i) {
        int j;
        if(i >= 0 && i < mLengths.length)
            j = mLengths[i];
        else
            j = -1;
        return j;
    }

    public int getOffsetAt(int i) {
        int j;
        if(i >= 0 && i < mOffsets.length)
            j = mOffsets[i];
        else
            j = -1;
        return j;
    }

    public int getSuggestionsCount() {
        return mSuggestionsInfos.length;
    }

    public SuggestionsInfo getSuggestionsInfoAt(int i) {
        SuggestionsInfo suggestionsinfo;
        if(i >= 0 && i < mSuggestionsInfos.length)
            suggestionsinfo = mSuggestionsInfos[i];
        else
            suggestionsinfo = null;
        return suggestionsinfo;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mSuggestionsInfos.length);
        parcel.writeTypedArray(mSuggestionsInfos, 0);
        parcel.writeIntArray(mOffsets);
        parcel.writeIntArray(mLengths);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public SentenceSuggestionsInfo createFromParcel(Parcel parcel) {
            return new SentenceSuggestionsInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public SentenceSuggestionsInfo[] newArray(int i) {
            return new SentenceSuggestionsInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private final int mLengths[];
    private final int mOffsets[];
    private final SuggestionsInfo mSuggestionsInfos[];

}

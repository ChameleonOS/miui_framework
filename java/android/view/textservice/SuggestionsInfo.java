// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.textservice;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.internal.util.ArrayUtils;

public final class SuggestionsInfo
    implements Parcelable {

    public SuggestionsInfo(int i, String as[]) {
        this(i, as, 0, 0);
    }

    public SuggestionsInfo(int i, String as[], int j, int k) {
        if(as == null) {
            mSuggestions = EMPTY;
            mSuggestionsAvailable = false;
        } else {
            mSuggestions = as;
            mSuggestionsAvailable = true;
        }
        mSuggestionsAttributes = i;
        mCookie = j;
        mSequence = k;
    }

    public SuggestionsInfo(Parcel parcel) {
        boolean flag = true;
        super();
        mSuggestionsAttributes = parcel.readInt();
        mSuggestions = parcel.readStringArray();
        mCookie = parcel.readInt();
        mSequence = parcel.readInt();
        if(parcel.readInt() != flag)
            flag = false;
        mSuggestionsAvailable = flag;
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

    public String getSuggestionAt(int i) {
        return mSuggestions[i];
    }

    public int getSuggestionsAttributes() {
        return mSuggestionsAttributes;
    }

    public int getSuggestionsCount() {
        int i;
        if(!mSuggestionsAvailable)
            i = -1;
        else
            i = mSuggestions.length;
        return i;
    }

    public void setCookieAndSequence(int i, int j) {
        mCookie = i;
        mSequence = j;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mSuggestionsAttributes);
        parcel.writeStringArray(mSuggestions);
        parcel.writeInt(mCookie);
        parcel.writeInt(mSequence);
        int j;
        if(mSuggestionsAvailable)
            j = 1;
        else
            j = 0;
        parcel.writeInt(j);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public SuggestionsInfo createFromParcel(Parcel parcel) {
            return new SuggestionsInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public SuggestionsInfo[] newArray(int i) {
            return new SuggestionsInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private static final String EMPTY[] = (String[])ArrayUtils.emptyArray(java/lang/String);
    public static final int RESULT_ATTR_HAS_RECOMMENDED_SUGGESTIONS = 4;
    public static final int RESULT_ATTR_IN_THE_DICTIONARY = 1;
    public static final int RESULT_ATTR_LOOKS_LIKE_TYPO = 2;
    private int mCookie;
    private int mSequence;
    private final String mSuggestions[];
    private final int mSuggestionsAttributes;
    private final boolean mSuggestionsAvailable;

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.telephony.cdma;

import android.os.Parcel;
import android.os.Parcelable;

public class CdmaSmsCbProgramResults
    implements Parcelable {

    public CdmaSmsCbProgramResults(int i, int j, int k) {
        mCategory = i;
        mLanguage = j;
        mCategoryResult = k;
    }

    CdmaSmsCbProgramResults(Parcel parcel) {
        mCategory = parcel.readInt();
        mLanguage = parcel.readInt();
        mCategoryResult = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public int getCategory() {
        return mCategory;
    }

    public int getCategoryResult() {
        return mCategoryResult;
    }

    public int getLanguage() {
        return mLanguage;
    }

    public String toString() {
        return (new StringBuilder()).append("CdmaSmsCbProgramResults{category=").append(mCategory).append(", language=").append(mLanguage).append(", result=").append(mCategoryResult).append('}').toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mCategory);
        parcel.writeInt(mLanguage);
        parcel.writeInt(mCategoryResult);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public CdmaSmsCbProgramResults createFromParcel(Parcel parcel) {
            return new CdmaSmsCbProgramResults(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public CdmaSmsCbProgramResults[] newArray(int i) {
            return new CdmaSmsCbProgramResults[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int RESULT_CATEGORY_ALREADY_ADDED = 3;
    public static final int RESULT_CATEGORY_ALREADY_DELETED = 4;
    public static final int RESULT_CATEGORY_LIMIT_EXCEEDED = 2;
    public static final int RESULT_INVALID_ALERT_OPTION = 6;
    public static final int RESULT_INVALID_CATEGORY_NAME = 7;
    public static final int RESULT_INVALID_MAX_MESSAGES = 5;
    public static final int RESULT_MEMORY_LIMIT_EXCEEDED = 1;
    public static final int RESULT_SUCCESS = 0;
    public static final int RESULT_UNSPECIFIED_FAILURE = 8;
    private final int mCategory;
    private final int mCategoryResult;
    private final int mLanguage;

}

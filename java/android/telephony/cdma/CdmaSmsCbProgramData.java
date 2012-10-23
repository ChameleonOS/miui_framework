// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.telephony.cdma;

import android.os.Parcel;
import android.os.Parcelable;

public class CdmaSmsCbProgramData
    implements Parcelable {

    public CdmaSmsCbProgramData(int i, int j, int k, int l, int i1, String s) {
        mOperation = i;
        mCategory = j;
        mLanguage = k;
        mMaxMessages = l;
        mAlertOption = i1;
        mCategoryName = s;
    }

    CdmaSmsCbProgramData(Parcel parcel) {
        mOperation = parcel.readInt();
        mCategory = parcel.readInt();
        mLanguage = parcel.readInt();
        mMaxMessages = parcel.readInt();
        mAlertOption = parcel.readInt();
        mCategoryName = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public int getAlertOption() {
        return mAlertOption;
    }

    public int getCategory() {
        return mCategory;
    }

    public String getCategoryName() {
        return mCategoryName;
    }

    public int getLanguage() {
        return mLanguage;
    }

    public int getMaxMessages() {
        return mMaxMessages;
    }

    public int getOperation() {
        return mOperation;
    }

    public String toString() {
        return (new StringBuilder()).append("CdmaSmsCbProgramData{operation=").append(mOperation).append(", category=").append(mCategory).append(", language=").append(mLanguage).append(", max messages=").append(mMaxMessages).append(", alert option=").append(mAlertOption).append(", category name=").append(mCategoryName).append('}').toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mOperation);
        parcel.writeInt(mCategory);
        parcel.writeInt(mLanguage);
        parcel.writeInt(mMaxMessages);
        parcel.writeInt(mAlertOption);
        parcel.writeString(mCategoryName);
    }

    public static final int ALERT_OPTION_DEFAULT_ALERT = 1;
    public static final int ALERT_OPTION_HIGH_PRIORITY_ONCE = 10;
    public static final int ALERT_OPTION_HIGH_PRIORITY_REPEAT = 11;
    public static final int ALERT_OPTION_LOW_PRIORITY_ONCE = 6;
    public static final int ALERT_OPTION_LOW_PRIORITY_REPEAT = 7;
    public static final int ALERT_OPTION_MED_PRIORITY_ONCE = 8;
    public static final int ALERT_OPTION_MED_PRIORITY_REPEAT = 9;
    public static final int ALERT_OPTION_NO_ALERT = 0;
    public static final int ALERT_OPTION_VIBRATE_ONCE = 2;
    public static final int ALERT_OPTION_VIBRATE_REPEAT = 3;
    public static final int ALERT_OPTION_VISUAL_ONCE = 4;
    public static final int ALERT_OPTION_VISUAL_REPEAT = 5;
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public CdmaSmsCbProgramData createFromParcel(Parcel parcel) {
            return new CdmaSmsCbProgramData(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public CdmaSmsCbProgramData[] newArray(int i) {
            return new CdmaSmsCbProgramData[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int OPERATION_ADD_CATEGORY = 1;
    public static final int OPERATION_CLEAR_CATEGORIES = 2;
    public static final int OPERATION_DELETE_CATEGORY;
    private final int mAlertOption;
    private final int mCategory;
    private final String mCategoryName;
    private final int mLanguage;
    private final int mMaxMessages;
    private final int mOperation;

}

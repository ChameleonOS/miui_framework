// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.telephony;

import android.os.Parcel;
import android.os.Parcelable;

public class SmsCbCmasInfo
    implements Parcelable {

    public SmsCbCmasInfo(int i, int j, int k, int l, int i1, int j1) {
        mMessageClass = i;
        mCategory = j;
        mResponseType = k;
        mSeverity = l;
        mUrgency = i1;
        mCertainty = j1;
    }

    SmsCbCmasInfo(Parcel parcel) {
        mMessageClass = parcel.readInt();
        mCategory = parcel.readInt();
        mResponseType = parcel.readInt();
        mSeverity = parcel.readInt();
        mUrgency = parcel.readInt();
        mCertainty = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public int getCategory() {
        return mCategory;
    }

    public int getCertainty() {
        return mCertainty;
    }

    public int getMessageClass() {
        return mMessageClass;
    }

    public int getResponseType() {
        return mResponseType;
    }

    public int getSeverity() {
        return mSeverity;
    }

    public int getUrgency() {
        return mUrgency;
    }

    public String toString() {
        return (new StringBuilder()).append("SmsCbCmasInfo{messageClass=").append(mMessageClass).append(", category=").append(mCategory).append(", responseType=").append(mResponseType).append(", severity=").append(mSeverity).append(", urgency=").append(mUrgency).append(", certainty=").append(mCertainty).append('}').toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mMessageClass);
        parcel.writeInt(mCategory);
        parcel.writeInt(mResponseType);
        parcel.writeInt(mSeverity);
        parcel.writeInt(mUrgency);
        parcel.writeInt(mCertainty);
    }

    public static final int CMAS_CATEGORY_CBRNE = 10;
    public static final int CMAS_CATEGORY_ENV = 7;
    public static final int CMAS_CATEGORY_FIRE = 5;
    public static final int CMAS_CATEGORY_GEO = 0;
    public static final int CMAS_CATEGORY_HEALTH = 6;
    public static final int CMAS_CATEGORY_INFRA = 9;
    public static final int CMAS_CATEGORY_MET = 1;
    public static final int CMAS_CATEGORY_OTHER = 11;
    public static final int CMAS_CATEGORY_RESCUE = 4;
    public static final int CMAS_CATEGORY_SAFETY = 2;
    public static final int CMAS_CATEGORY_SECURITY = 3;
    public static final int CMAS_CATEGORY_TRANSPORT = 8;
    public static final int CMAS_CATEGORY_UNKNOWN = -1;
    public static final int CMAS_CERTAINTY_LIKELY = 1;
    public static final int CMAS_CERTAINTY_OBSERVED = 0;
    public static final int CMAS_CERTAINTY_UNKNOWN = -1;
    public static final int CMAS_CLASS_CHILD_ABDUCTION_EMERGENCY = 3;
    public static final int CMAS_CLASS_CMAS_EXERCISE = 5;
    public static final int CMAS_CLASS_EXTREME_THREAT = 1;
    public static final int CMAS_CLASS_OPERATOR_DEFINED_USE = 6;
    public static final int CMAS_CLASS_PRESIDENTIAL_LEVEL_ALERT = 0;
    public static final int CMAS_CLASS_REQUIRED_MONTHLY_TEST = 4;
    public static final int CMAS_CLASS_SEVERE_THREAT = 2;
    public static final int CMAS_CLASS_UNKNOWN = -1;
    public static final int CMAS_RESPONSE_TYPE_ASSESS = 6;
    public static final int CMAS_RESPONSE_TYPE_AVOID = 5;
    public static final int CMAS_RESPONSE_TYPE_EVACUATE = 1;
    public static final int CMAS_RESPONSE_TYPE_EXECUTE = 3;
    public static final int CMAS_RESPONSE_TYPE_MONITOR = 4;
    public static final int CMAS_RESPONSE_TYPE_NONE = 7;
    public static final int CMAS_RESPONSE_TYPE_PREPARE = 2;
    public static final int CMAS_RESPONSE_TYPE_SHELTER = 0;
    public static final int CMAS_RESPONSE_TYPE_UNKNOWN = -1;
    public static final int CMAS_SEVERITY_EXTREME = 0;
    public static final int CMAS_SEVERITY_SEVERE = 1;
    public static final int CMAS_SEVERITY_UNKNOWN = -1;
    public static final int CMAS_URGENCY_EXPECTED = 1;
    public static final int CMAS_URGENCY_IMMEDIATE = 0;
    public static final int CMAS_URGENCY_UNKNOWN = -1;
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public SmsCbCmasInfo createFromParcel(Parcel parcel) {
            return new SmsCbCmasInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public SmsCbCmasInfo[] newArray(int i) {
            return new SmsCbCmasInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private final int mCategory;
    private final int mCertainty;
    private final int mMessageClass;
    private final int mResponseType;
    private final int mSeverity;
    private final int mUrgency;

}

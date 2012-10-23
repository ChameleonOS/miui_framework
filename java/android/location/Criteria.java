// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.location;

import android.os.Parcel;
import android.os.Parcelable;

public class Criteria
    implements Parcelable {

    public Criteria() {
        mHorizontalAccuracy = 0;
        mVerticalAccuracy = 0;
        mSpeedAccuracy = 0;
        mBearingAccuracy = 0;
        mPowerRequirement = 0;
        mAltitudeRequired = false;
        mBearingRequired = false;
        mSpeedRequired = false;
        mCostAllowed = false;
    }

    public Criteria(Criteria criteria) {
        mHorizontalAccuracy = 0;
        mVerticalAccuracy = 0;
        mSpeedAccuracy = 0;
        mBearingAccuracy = 0;
        mPowerRequirement = 0;
        mAltitudeRequired = false;
        mBearingRequired = false;
        mSpeedRequired = false;
        mCostAllowed = false;
        mHorizontalAccuracy = criteria.mHorizontalAccuracy;
        mVerticalAccuracy = criteria.mVerticalAccuracy;
        mSpeedAccuracy = criteria.mSpeedAccuracy;
        mBearingAccuracy = criteria.mBearingAccuracy;
        mPowerRequirement = criteria.mPowerRequirement;
        mAltitudeRequired = criteria.mAltitudeRequired;
        mBearingRequired = criteria.mBearingRequired;
        mSpeedRequired = criteria.mSpeedRequired;
        mCostAllowed = criteria.mCostAllowed;
    }

    public int describeContents() {
        return 0;
    }

    public int getAccuracy() {
        int i;
        if(mHorizontalAccuracy >= 3)
            i = 1;
        else
            i = 2;
        return i;
    }

    public int getBearingAccuracy() {
        return mBearingAccuracy;
    }

    public int getHorizontalAccuracy() {
        return mHorizontalAccuracy;
    }

    public int getPowerRequirement() {
        return mPowerRequirement;
    }

    public int getSpeedAccuracy() {
        return mSpeedAccuracy;
    }

    public int getVerticalAccuracy() {
        return mVerticalAccuracy;
    }

    public boolean isAltitudeRequired() {
        return mAltitudeRequired;
    }

    public boolean isBearingRequired() {
        return mBearingRequired;
    }

    public boolean isCostAllowed() {
        return mCostAllowed;
    }

    public boolean isSpeedRequired() {
        return mSpeedRequired;
    }

    public void setAccuracy(int i) {
        if(i < 0 || i > 2)
            throw new IllegalArgumentException((new StringBuilder()).append("accuracy=").append(i).toString());
        if(i == 1)
            mHorizontalAccuracy = 3;
        else
            mHorizontalAccuracy = 1;
    }

    public void setAltitudeRequired(boolean flag) {
        mAltitudeRequired = flag;
    }

    public void setBearingAccuracy(int i) {
        if(i < 0 || i > 3) {
            throw new IllegalArgumentException((new StringBuilder()).append("accuracy=").append(i).toString());
        } else {
            mBearingAccuracy = i;
            return;
        }
    }

    public void setBearingRequired(boolean flag) {
        mBearingRequired = flag;
    }

    public void setCostAllowed(boolean flag) {
        mCostAllowed = flag;
    }

    public void setHorizontalAccuracy(int i) {
        if(i < 0 || i > 3) {
            throw new IllegalArgumentException((new StringBuilder()).append("accuracy=").append(i).toString());
        } else {
            mHorizontalAccuracy = i;
            return;
        }
    }

    public void setPowerRequirement(int i) {
        if(i < 0 || i > 3) {
            throw new IllegalArgumentException((new StringBuilder()).append("level=").append(i).toString());
        } else {
            mPowerRequirement = i;
            return;
        }
    }

    public void setSpeedAccuracy(int i) {
        if(i < 0 || i > 3) {
            throw new IllegalArgumentException((new StringBuilder()).append("accuracy=").append(i).toString());
        } else {
            mSpeedAccuracy = i;
            return;
        }
    }

    public void setSpeedRequired(boolean flag) {
        mSpeedRequired = flag;
    }

    public void setVerticalAccuracy(int i) {
        if(i < 0 || i > 3) {
            throw new IllegalArgumentException((new StringBuilder()).append("accuracy=").append(i).toString());
        } else {
            mVerticalAccuracy = i;
            return;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        int j = 1;
        parcel.writeInt(mHorizontalAccuracy);
        parcel.writeInt(mVerticalAccuracy);
        parcel.writeInt(mSpeedAccuracy);
        parcel.writeInt(mBearingAccuracy);
        parcel.writeInt(mPowerRequirement);
        int k;
        int l;
        int i1;
        if(mAltitudeRequired)
            k = j;
        else
            k = 0;
        parcel.writeInt(k);
        if(mBearingRequired)
            l = j;
        else
            l = 0;
        parcel.writeInt(l);
        if(mSpeedRequired)
            i1 = j;
        else
            i1 = 0;
        parcel.writeInt(i1);
        if(!mCostAllowed)
            j = 0;
        parcel.writeInt(j);
    }

    public static final int ACCURACY_COARSE = 2;
    public static final int ACCURACY_FINE = 1;
    public static final int ACCURACY_HIGH = 3;
    public static final int ACCURACY_LOW = 1;
    public static final int ACCURACY_MEDIUM = 2;
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Criteria createFromParcel(Parcel parcel) {
            boolean flag = true;
            Criteria criteria = new Criteria();
            criteria.mHorizontalAccuracy = parcel.readInt();
            criteria.mVerticalAccuracy = parcel.readInt();
            criteria.mSpeedAccuracy = parcel.readInt();
            criteria.mBearingAccuracy = parcel.readInt();
            criteria.mPowerRequirement = parcel.readInt();
            boolean flag1;
            boolean flag2;
            boolean flag3;
            if(parcel.readInt() != 0)
                flag1 = flag;
            else
                flag1 = false;
            criteria.mAltitudeRequired = flag1;
            if(parcel.readInt() != 0)
                flag2 = flag;
            else
                flag2 = false;
            criteria.mBearingRequired = flag2;
            if(parcel.readInt() != 0)
                flag3 = flag;
            else
                flag3 = false;
            criteria.mSpeedRequired = flag3;
            if(parcel.readInt() == 0)
                flag = false;
            criteria.mCostAllowed = flag;
            return criteria;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public Criteria[] newArray(int i) {
            return new Criteria[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int NO_REQUIREMENT = 0;
    public static final int POWER_HIGH = 3;
    public static final int POWER_LOW = 1;
    public static final int POWER_MEDIUM = 2;
    private boolean mAltitudeRequired;
    private int mBearingAccuracy;
    private boolean mBearingRequired;
    private boolean mCostAllowed;
    private int mHorizontalAccuracy;
    private int mPowerRequirement;
    private int mSpeedAccuracy;
    private boolean mSpeedRequired;
    private int mVerticalAccuracy;



/*
    static int access$002(Criteria criteria, int i) {
        criteria.mHorizontalAccuracy = i;
        return i;
    }

*/


/*
    static int access$102(Criteria criteria, int i) {
        criteria.mVerticalAccuracy = i;
        return i;
    }

*/


/*
    static int access$202(Criteria criteria, int i) {
        criteria.mSpeedAccuracy = i;
        return i;
    }

*/


/*
    static int access$302(Criteria criteria, int i) {
        criteria.mBearingAccuracy = i;
        return i;
    }

*/


/*
    static int access$402(Criteria criteria, int i) {
        criteria.mPowerRequirement = i;
        return i;
    }

*/


/*
    static boolean access$502(Criteria criteria, boolean flag) {
        criteria.mAltitudeRequired = flag;
        return flag;
    }

*/


/*
    static boolean access$602(Criteria criteria, boolean flag) {
        criteria.mBearingRequired = flag;
        return flag;
    }

*/


/*
    static boolean access$702(Criteria criteria, boolean flag) {
        criteria.mSpeedRequired = flag;
        return flag;
    }

*/


/*
    static boolean access$802(Criteria criteria, boolean flag) {
        criteria.mCostAllowed = flag;
        return flag;
    }

*/
}

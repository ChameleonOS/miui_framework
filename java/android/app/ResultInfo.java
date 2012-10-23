// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

public class ResultInfo
    implements Parcelable {

    public ResultInfo(Parcel parcel) {
        mResultWho = parcel.readString();
        mRequestCode = parcel.readInt();
        mResultCode = parcel.readInt();
        if(parcel.readInt() != 0)
            mData = (Intent)Intent.CREATOR.createFromParcel(parcel);
        else
            mData = null;
    }

    public ResultInfo(String s, int i, int j, Intent intent) {
        mResultWho = s;
        mRequestCode = i;
        mResultCode = j;
        mData = intent;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return (new StringBuilder()).append("ResultInfo{who=").append(mResultWho).append(", request=").append(mRequestCode).append(", result=").append(mResultCode).append(", data=").append(mData).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mResultWho);
        parcel.writeInt(mRequestCode);
        parcel.writeInt(mResultCode);
        if(mData != null) {
            parcel.writeInt(1);
            mData.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ResultInfo createFromParcel(Parcel parcel) {
            return new ResultInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public ResultInfo[] newArray(int i) {
            return new ResultInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public final Intent mData;
    public final int mRequestCode;
    public final int mResultCode;
    public final String mResultWho;

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.telephony;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package android.telephony:
//            SmsCbLocation, SmsCbEtwsInfo, SmsCbCmasInfo

public class SmsCbMessage
    implements Parcelable {

    public SmsCbMessage(int i, int j, int k, SmsCbLocation smscblocation, int l, String s, String s1, 
            int i1, SmsCbEtwsInfo smscbetwsinfo, SmsCbCmasInfo smscbcmasinfo) {
        mMessageFormat = i;
        mGeographicalScope = j;
        mSerialNumber = k;
        mLocation = smscblocation;
        mServiceCategory = l;
        mLanguage = s;
        mBody = s1;
        mPriority = i1;
        mEtwsWarningInfo = smscbetwsinfo;
        mCmasWarningInfo = smscbcmasinfo;
    }

    public SmsCbMessage(Parcel parcel) {
        mMessageFormat = parcel.readInt();
        mGeographicalScope = parcel.readInt();
        mSerialNumber = parcel.readInt();
        mLocation = new SmsCbLocation(parcel);
        mServiceCategory = parcel.readInt();
        mLanguage = parcel.readString();
        mBody = parcel.readString();
        mPriority = parcel.readInt();
        parcel.readInt();
        JVM INSTR tableswitch 67 69: default 104
    //                   67 135
    //                   68 104
    //                   69 115;
           goto _L1 _L2 _L1 _L3
_L1:
        mEtwsWarningInfo = null;
        mCmasWarningInfo = null;
_L5:
        return;
_L3:
        mEtwsWarningInfo = new SmsCbEtwsInfo(parcel);
        mCmasWarningInfo = null;
        continue; /* Loop/switch isn't completed */
_L2:
        mEtwsWarningInfo = null;
        mCmasWarningInfo = new SmsCbCmasInfo(parcel);
        if(true) goto _L5; else goto _L4
_L4:
    }

    public int describeContents() {
        return 0;
    }

    public SmsCbCmasInfo getCmasWarningInfo() {
        return mCmasWarningInfo;
    }

    public SmsCbEtwsInfo getEtwsWarningInfo() {
        return mEtwsWarningInfo;
    }

    public int getGeographicalScope() {
        return mGeographicalScope;
    }

    public String getLanguageCode() {
        return mLanguage;
    }

    public SmsCbLocation getLocation() {
        return mLocation;
    }

    public String getMessageBody() {
        return mBody;
    }

    public int getMessageFormat() {
        return mMessageFormat;
    }

    public int getMessagePriority() {
        return mPriority;
    }

    public int getSerialNumber() {
        return mSerialNumber;
    }

    public int getServiceCategory() {
        return mServiceCategory;
    }

    public boolean isCmasMessage() {
        boolean flag;
        if(mCmasWarningInfo != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isEmergencyMessage() {
        boolean flag;
        if(mPriority == 3)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isEtwsMessage() {
        boolean flag;
        if(mEtwsWarningInfo != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public String toString() {
        StringBuilder stringbuilder = (new StringBuilder()).append("SmsCbMessage{geographicalScope=").append(mGeographicalScope).append(", serialNumber=").append(mSerialNumber).append(", location=").append(mLocation).append(", serviceCategory=").append(mServiceCategory).append(", language=").append(mLanguage).append(", body=").append(mBody).append(", priority=").append(mPriority);
        String s;
        StringBuilder stringbuilder1;
        String s1;
        if(mEtwsWarningInfo != null)
            s = (new StringBuilder()).append(", ").append(mEtwsWarningInfo.toString()).toString();
        else
            s = "";
        stringbuilder1 = stringbuilder.append(s);
        if(mCmasWarningInfo != null)
            s1 = (new StringBuilder()).append(", ").append(mCmasWarningInfo.toString()).toString();
        else
            s1 = "";
        return stringbuilder1.append(s1).append('}').toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mMessageFormat);
        parcel.writeInt(mGeographicalScope);
        parcel.writeInt(mSerialNumber);
        mLocation.writeToParcel(parcel, i);
        parcel.writeInt(mServiceCategory);
        parcel.writeString(mLanguage);
        parcel.writeString(mBody);
        parcel.writeInt(mPriority);
        if(mEtwsWarningInfo != null) {
            parcel.writeInt(69);
            mEtwsWarningInfo.writeToParcel(parcel, i);
        } else
        if(mCmasWarningInfo != null) {
            parcel.writeInt(67);
            mCmasWarningInfo.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(48);
        }
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public SmsCbMessage createFromParcel(Parcel parcel) {
            return new SmsCbMessage(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public SmsCbMessage[] newArray(int i) {
            return new SmsCbMessage[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int GEOGRAPHICAL_SCOPE_CELL_WIDE = 3;
    public static final int GEOGRAPHICAL_SCOPE_CELL_WIDE_IMMEDIATE = 0;
    public static final int GEOGRAPHICAL_SCOPE_LA_WIDE = 2;
    public static final int GEOGRAPHICAL_SCOPE_PLMN_WIDE = 1;
    protected static final String LOG_TAG = "SMSCB";
    public static final int MESSAGE_FORMAT_3GPP = 1;
    public static final int MESSAGE_FORMAT_3GPP2 = 2;
    public static final int MESSAGE_PRIORITY_EMERGENCY = 3;
    public static final int MESSAGE_PRIORITY_INTERACTIVE = 1;
    public static final int MESSAGE_PRIORITY_NORMAL = 0;
    public static final int MESSAGE_PRIORITY_URGENT = 2;
    private final String mBody;
    private final SmsCbCmasInfo mCmasWarningInfo;
    private final SmsCbEtwsInfo mEtwsWarningInfo;
    private final int mGeographicalScope;
    private final String mLanguage;
    private final SmsCbLocation mLocation;
    private final int mMessageFormat;
    private final int mPriority;
    private final int mSerialNumber;
    private final int mServiceCategory;

}

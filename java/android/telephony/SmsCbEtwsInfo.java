// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.telephony;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.Time;
import com.android.internal.telephony.IccUtils;
import java.util.Arrays;

public class SmsCbEtwsInfo
    implements Parcelable {

    public SmsCbEtwsInfo(int i, boolean flag, boolean flag1, byte abyte0[]) {
        mWarningType = i;
        mEmergencyUserAlert = flag;
        mActivatePopup = flag1;
        mWarningSecurityInformation = abyte0;
    }

    SmsCbEtwsInfo(Parcel parcel) {
        boolean flag = true;
        super();
        mWarningType = parcel.readInt();
        boolean flag1;
        if(parcel.readInt() != 0)
            flag1 = flag;
        else
            flag1 = false;
        mEmergencyUserAlert = flag1;
        if(parcel.readInt() == 0)
            flag = false;
        mActivatePopup = flag;
        mWarningSecurityInformation = parcel.createByteArray();
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getPrimaryNotificationSignature() {
        byte abyte0[];
        if(mWarningSecurityInformation == null || mWarningSecurityInformation.length < 50)
            abyte0 = null;
        else
            abyte0 = Arrays.copyOfRange(mWarningSecurityInformation, 7, 50);
        return abyte0;
    }

    public long getPrimaryNotificationTimestamp() {
        long l;
        if(mWarningSecurityInformation == null || mWarningSecurityInformation.length < 7) {
            l = 0L;
        } else {
            int i = IccUtils.gsmBcdByteToInt(mWarningSecurityInformation[0]);
            int j = IccUtils.gsmBcdByteToInt(mWarningSecurityInformation[1]);
            int k = IccUtils.gsmBcdByteToInt(mWarningSecurityInformation[2]);
            int i1 = IccUtils.gsmBcdByteToInt(mWarningSecurityInformation[3]);
            int j1 = IccUtils.gsmBcdByteToInt(mWarningSecurityInformation[4]);
            int k1 = IccUtils.gsmBcdByteToInt(mWarningSecurityInformation[5]);
            byte byte0 = mWarningSecurityInformation[6];
            int l1 = IccUtils.gsmBcdByteToInt((byte)(byte0 & -9));
            Time time;
            if((byte0 & 8) != 0)
                l1 = -l1;
            time = new Time("UTC");
            time.year = i + 2000;
            time.month = j - 1;
            time.monthDay = k;
            time.hour = i1;
            time.minute = j1;
            time.second = k1;
            l = time.toMillis(true) - (long)(1000 * (60 * (l1 * 15)));
        }
        return l;
    }

    public int getWarningType() {
        return mWarningType;
    }

    public boolean isEmergencyUserAlert() {
        return mEmergencyUserAlert;
    }

    public boolean isPopupAlert() {
        return mActivatePopup;
    }

    public String toString() {
        return (new StringBuilder()).append("SmsCbEtwsInfo{warningType=").append(mWarningType).append(", emergencyUserAlert=").append(mEmergencyUserAlert).append(", activatePopup=").append(mActivatePopup).append('}').toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int j = 1;
        parcel.writeInt(mWarningType);
        int k;
        if(mEmergencyUserAlert)
            k = j;
        else
            k = 0;
        parcel.writeInt(k);
        if(!mActivatePopup)
            j = 0;
        parcel.writeInt(j);
        parcel.writeByteArray(mWarningSecurityInformation);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public SmsCbEtwsInfo createFromParcel(Parcel parcel) {
            return new SmsCbEtwsInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public SmsCbEtwsInfo[] newArray(int i) {
            return new SmsCbEtwsInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int ETWS_WARNING_TYPE_EARTHQUAKE = 0;
    public static final int ETWS_WARNING_TYPE_EARTHQUAKE_AND_TSUNAMI = 2;
    public static final int ETWS_WARNING_TYPE_OTHER_EMERGENCY = 4;
    public static final int ETWS_WARNING_TYPE_TEST_MESSAGE = 3;
    public static final int ETWS_WARNING_TYPE_TSUNAMI = 1;
    public static final int ETWS_WARNING_TYPE_UNKNOWN = -1;
    private final boolean mActivatePopup;
    private final boolean mEmergencyUserAlert;
    private final byte mWarningSecurityInformation[];
    private final int mWarningType;

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.telephony;

import android.os.*;
import android.util.Log;

public class ServiceState
    implements Parcelable {

    public ServiceState() {
        mState = 1;
    }

    public ServiceState(Parcel parcel) {
        boolean flag = true;
        super();
        mState = ((flag) ? 1 : 0);
        mState = parcel.readInt();
        boolean flag1;
        boolean flag2;
        boolean flag3;
        if(parcel.readInt() != 0)
            flag1 = flag;
        else
            flag1 = false;
        mRoaming = flag1;
        mOperatorAlphaLong = parcel.readString();
        mOperatorAlphaShort = parcel.readString();
        mOperatorNumeric = parcel.readString();
        if(parcel.readInt() != 0)
            flag2 = flag;
        else
            flag2 = false;
        mIsManualNetworkSelection = flag2;
        mRadioTechnology = parcel.readInt();
        if(parcel.readInt() != 0)
            flag3 = flag;
        else
            flag3 = false;
        mCssIndicator = flag3;
        mNetworkId = parcel.readInt();
        mSystemId = parcel.readInt();
        mCdmaRoamingIndicator = parcel.readInt();
        mCdmaDefaultRoamingIndicator = parcel.readInt();
        mCdmaEriIconIndex = parcel.readInt();
        mCdmaEriIconMode = parcel.readInt();
        if(parcel.readInt() == 0)
            flag = false;
        mIsEmergencyOnly = flag;
    }

    public ServiceState(ServiceState servicestate) {
        mState = 1;
        copyFrom(servicestate);
    }

    private static boolean equalsHandlesNulls(Object obj, Object obj1) {
        boolean flag;
        if(obj == null) {
            if(obj1 == null)
                flag = true;
            else
                flag = false;
        } else {
            flag = obj.equals(obj1);
        }
        return flag;
    }

    public static boolean isCdma(int i) {
        boolean flag;
        if(i == 4 || i == 5 || i == 6 || i == 7 || i == 8 || i == 12 || i == 13)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isGsm(int i) {
        boolean flag = true;
        if(i != flag && i != 2 && i != 3 && i != 9 && i != 10 && i != 11 && i != 14 && i != 15 && i != 16)
            flag = false;
        return flag;
    }

    public static ServiceState newFromBundle(Bundle bundle) {
        ServiceState servicestate = new ServiceState();
        servicestate.setFromNotifierBundle(bundle);
        return servicestate;
    }

    public static String rilRadioTechnologyToString(int i) {
        i;
        JVM INSTR tableswitch 0 16: default 84
    //                   0 114
    //                   1 120
    //                   2 126
    //                   3 132
    //                   4 138
    //                   5 144
    //                   6 150
    //                   7 156
    //                   8 162
    //                   9 168
    //                   10 174
    //                   11 180
    //                   12 186
    //                   13 192
    //                   14 198
    //                   15 204
    //                   16 210;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18
_L1:
        String s;
        s = "Unexpected";
        Log.w("PHONE", (new StringBuilder()).append("Unexpected radioTechnology=").append(i).toString());
_L20:
        return s;
_L2:
        s = "Unknown";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "GPRS";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "EDGE";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "UMTS";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "CDMA-IS95A";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "CDMA-IS95B";
        continue; /* Loop/switch isn't completed */
_L8:
        s = "1xRTT";
        continue; /* Loop/switch isn't completed */
_L9:
        s = "EvDo-rev.0";
        continue; /* Loop/switch isn't completed */
_L10:
        s = "EvDo-rev.A";
        continue; /* Loop/switch isn't completed */
_L11:
        s = "HSDPA";
        continue; /* Loop/switch isn't completed */
_L12:
        s = "HSUPA";
        continue; /* Loop/switch isn't completed */
_L13:
        s = "HSPA";
        continue; /* Loop/switch isn't completed */
_L14:
        s = "EvDo-rev.B";
        continue; /* Loop/switch isn't completed */
_L15:
        s = "eHRPD";
        continue; /* Loop/switch isn't completed */
_L16:
        s = "LTE";
        continue; /* Loop/switch isn't completed */
_L17:
        s = "HSPAP";
        continue; /* Loop/switch isn't completed */
_L18:
        s = "GSM";
        if(true) goto _L20; else goto _L19
_L19:
    }

    private void setFromNotifierBundle(Bundle bundle) {
        mState = bundle.getInt("state");
        mRoaming = bundle.getBoolean("roaming");
        mOperatorAlphaLong = bundle.getString("operator-alpha-long");
        mOperatorAlphaShort = bundle.getString("operator-alpha-short");
        mOperatorNumeric = bundle.getString("operator-numeric");
        mIsManualNetworkSelection = bundle.getBoolean("manual");
        mRadioTechnology = bundle.getInt("radioTechnology");
        mCssIndicator = bundle.getBoolean("cssIndicator");
        mNetworkId = bundle.getInt("networkId");
        mSystemId = bundle.getInt("systemId");
        mCdmaRoamingIndicator = bundle.getInt("cdmaRoamingIndicator");
        mCdmaDefaultRoamingIndicator = bundle.getInt("cdmaDefaultRoamingIndicator");
        mIsEmergencyOnly = bundle.getBoolean("emergencyOnly");
    }

    private void setNullState(int i) {
        mState = i;
        mRoaming = false;
        mOperatorAlphaLong = null;
        mOperatorAlphaShort = null;
        mOperatorNumeric = null;
        mIsManualNetworkSelection = false;
        mRadioTechnology = 0;
        mCssIndicator = false;
        mNetworkId = -1;
        mSystemId = -1;
        mCdmaRoamingIndicator = -1;
        mCdmaDefaultRoamingIndicator = -1;
        mCdmaEriIconIndex = -1;
        mCdmaEriIconMode = -1;
        mIsEmergencyOnly = false;
    }

    protected void copyFrom(ServiceState servicestate) {
        mState = servicestate.mState;
        mRoaming = servicestate.mRoaming;
        mOperatorAlphaLong = servicestate.mOperatorAlphaLong;
        mOperatorAlphaShort = servicestate.mOperatorAlphaShort;
        mOperatorNumeric = servicestate.mOperatorNumeric;
        mIsManualNetworkSelection = servicestate.mIsManualNetworkSelection;
        mRadioTechnology = servicestate.mRadioTechnology;
        mCssIndicator = servicestate.mCssIndicator;
        mNetworkId = servicestate.mNetworkId;
        mSystemId = servicestate.mSystemId;
        mCdmaRoamingIndicator = servicestate.mCdmaRoamingIndicator;
        mCdmaDefaultRoamingIndicator = servicestate.mCdmaDefaultRoamingIndicator;
        mCdmaEriIconIndex = servicestate.mCdmaEriIconIndex;
        mCdmaEriIconMode = servicestate.mCdmaEriIconMode;
        mIsEmergencyOnly = servicestate.mIsEmergencyOnly;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean flag = false;
        ServiceState servicestate = (ServiceState)obj;
          goto _L1
_L2:
        return flag;
        ClassCastException classcastexception;
        classcastexception;
          goto _L2
_L1:
        if(obj != null && mState == servicestate.mState && mRoaming == servicestate.mRoaming && mIsManualNetworkSelection == servicestate.mIsManualNetworkSelection && equalsHandlesNulls(mOperatorAlphaLong, servicestate.mOperatorAlphaLong) && equalsHandlesNulls(mOperatorAlphaShort, servicestate.mOperatorAlphaShort) && equalsHandlesNulls(mOperatorNumeric, servicestate.mOperatorNumeric) && equalsHandlesNulls(Integer.valueOf(mRadioTechnology), Integer.valueOf(servicestate.mRadioTechnology)) && equalsHandlesNulls(Boolean.valueOf(mCssIndicator), Boolean.valueOf(servicestate.mCssIndicator)) && equalsHandlesNulls(Integer.valueOf(mNetworkId), Integer.valueOf(servicestate.mNetworkId)) && equalsHandlesNulls(Integer.valueOf(mSystemId), Integer.valueOf(servicestate.mSystemId)) && equalsHandlesNulls(Integer.valueOf(mCdmaRoamingIndicator), Integer.valueOf(servicestate.mCdmaRoamingIndicator)) && equalsHandlesNulls(Integer.valueOf(mCdmaDefaultRoamingIndicator), Integer.valueOf(servicestate.mCdmaDefaultRoamingIndicator)) && mIsEmergencyOnly == servicestate.mIsEmergencyOnly)
            flag = true;
          goto _L2
    }

    public void fillInNotifierBundle(Bundle bundle) {
        bundle.putInt("state", mState);
        bundle.putBoolean("roaming", Boolean.valueOf(mRoaming).booleanValue());
        bundle.putString("operator-alpha-long", mOperatorAlphaLong);
        bundle.putString("operator-alpha-short", mOperatorAlphaShort);
        bundle.putString("operator-numeric", mOperatorNumeric);
        bundle.putBoolean("manual", Boolean.valueOf(mIsManualNetworkSelection).booleanValue());
        bundle.putInt("radioTechnology", mRadioTechnology);
        bundle.putBoolean("cssIndicator", mCssIndicator);
        bundle.putInt("networkId", mNetworkId);
        bundle.putInt("systemId", mSystemId);
        bundle.putInt("cdmaRoamingIndicator", mCdmaRoamingIndicator);
        bundle.putInt("cdmaDefaultRoamingIndicator", mCdmaDefaultRoamingIndicator);
        bundle.putBoolean("emergencyOnly", Boolean.valueOf(mIsEmergencyOnly).booleanValue());
    }

    public int getCdmaDefaultRoamingIndicator() {
        return mCdmaDefaultRoamingIndicator;
    }

    public int getCdmaEriIconIndex() {
        return mCdmaEriIconIndex;
    }

    public int getCdmaEriIconMode() {
        return mCdmaEriIconMode;
    }

    public int getCdmaRoamingIndicator() {
        return mCdmaRoamingIndicator;
    }

    public int getCssIndicator() {
        int i;
        if(mCssIndicator)
            i = 1;
        else
            i = 0;
        return i;
    }

    public boolean getIsManualSelection() {
        return mIsManualNetworkSelection;
    }

    public int getNetworkId() {
        return mNetworkId;
    }

    public int getNetworkType() {
        mRadioTechnology;
        JVM INSTR tableswitch 1 15: default 80
    //                   1 84
    //                   2 89
    //                   3 94
    //                   4 117
    //                   5 117
    //                   6 122
    //                   7 128
    //                   8 133
    //                   9 99
    //                   10 105
    //                   11 111
    //                   12 139
    //                   13 145
    //                   14 151
    //                   15 157;
           goto _L1 _L2 _L3 _L4 _L5 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L1:
        int i = 0;
_L17:
        return i;
_L2:
        i = 1;
        continue; /* Loop/switch isn't completed */
_L3:
        i = 2;
        continue; /* Loop/switch isn't completed */
_L4:
        i = 3;
        continue; /* Loop/switch isn't completed */
_L9:
        i = 8;
        continue; /* Loop/switch isn't completed */
_L10:
        i = 9;
        continue; /* Loop/switch isn't completed */
_L11:
        i = 10;
        continue; /* Loop/switch isn't completed */
_L5:
        i = 4;
        continue; /* Loop/switch isn't completed */
_L6:
        i = 7;
        continue; /* Loop/switch isn't completed */
_L7:
        i = 5;
        continue; /* Loop/switch isn't completed */
_L8:
        i = 6;
        continue; /* Loop/switch isn't completed */
_L12:
        i = 12;
        continue; /* Loop/switch isn't completed */
_L13:
        i = 14;
        continue; /* Loop/switch isn't completed */
_L14:
        i = 13;
        continue; /* Loop/switch isn't completed */
_L15:
        i = 15;
        if(true) goto _L17; else goto _L16
_L16:
    }

    public String getOperatorAlphaLong() {
        return mOperatorAlphaLong;
    }

    public String getOperatorAlphaShort() {
        return mOperatorAlphaShort;
    }

    public String getOperatorNumeric() {
        return mOperatorNumeric;
    }

    public int getRadioTechnology() {
        return getRilRadioTechnology();
    }

    public int getRilRadioTechnology() {
        return mRadioTechnology;
    }

    public boolean getRoaming() {
        return mRoaming;
    }

    public int getState() {
        return mState;
    }

    public int getSystemId() {
        return mSystemId;
    }

    public int hashCode() {
        int i = 1;
        int j = 4660 * mState;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        if(mRoaming)
            k = i;
        else
            k = 0;
        l = j + k;
        if(mIsManualNetworkSelection)
            i1 = i;
        else
            i1 = 0;
        j1 = l + i1;
        if(mOperatorAlphaLong == null)
            k1 = 0;
        else
            k1 = mOperatorAlphaLong.hashCode();
        l1 = j1 + k1;
        if(mOperatorAlphaShort == null)
            i2 = 0;
        else
            i2 = mOperatorAlphaShort.hashCode();
        j2 = l1 + i2;
        if(mOperatorNumeric == null)
            k2 = 0;
        else
            k2 = mOperatorNumeric.hashCode();
        l2 = k2 + j2 + mCdmaRoamingIndicator + mCdmaDefaultRoamingIndicator;
        if(!mIsEmergencyOnly)
            i = 0;
        return l2 + i;
    }

    public boolean isEmergencyOnly() {
        return mIsEmergencyOnly;
    }

    public void setCdmaDefaultRoamingIndicator(int i) {
        mCdmaDefaultRoamingIndicator = i;
    }

    public void setCdmaEriIconIndex(int i) {
        mCdmaEriIconIndex = i;
    }

    public void setCdmaEriIconMode(int i) {
        mCdmaEriIconMode = i;
    }

    public void setCdmaRoamingIndicator(int i) {
        mCdmaRoamingIndicator = i;
    }

    public void setCssIndicator(int i) {
        boolean flag;
        if(i != 0)
            flag = true;
        else
            flag = false;
        mCssIndicator = flag;
    }

    public void setEmergencyOnly(boolean flag) {
        mIsEmergencyOnly = flag;
    }

    public void setIsManualSelection(boolean flag) {
        mIsManualNetworkSelection = flag;
    }

    public void setOperatorAlphaLong(String s) {
        mOperatorAlphaLong = s;
    }

    public void setOperatorName(String s, String s1, String s2) {
        mOperatorAlphaLong = s;
        mOperatorAlphaShort = s1;
        mOperatorNumeric = s2;
    }

    public void setRadioTechnology(int i) {
        mRadioTechnology = i;
    }

    public void setRoaming(boolean flag) {
        mRoaming = flag;
    }

    public void setState(int i) {
        mState = i;
    }

    public void setStateOff() {
        setNullState(3);
    }

    public void setStateOutOfService() {
        setNullState(1);
    }

    public void setSystemAndNetworkId(int i, int j) {
        mSystemId = i;
        mNetworkId = j;
    }

    public String toString() {
        String s = rilRadioTechnologyToString(mRadioTechnology);
        StringBuilder stringbuilder = (new StringBuilder()).append(mState).append(" ");
        String s1;
        StringBuilder stringbuilder1;
        String s2;
        StringBuilder stringbuilder2;
        String s3;
        if(mRoaming)
            s1 = "roaming";
        else
            s1 = "home";
        stringbuilder1 = stringbuilder.append(s1).append(" ").append(mOperatorAlphaLong).append(" ").append(mOperatorAlphaShort).append(" ").append(mOperatorNumeric).append(" ");
        if(mIsManualNetworkSelection)
            s2 = "(manual)";
        else
            s2 = "";
        stringbuilder2 = stringbuilder1.append(s2).append(" ").append(s).append(" ");
        if(mCssIndicator)
            s3 = "CSS supported";
        else
            s3 = "CSS not supported";
        return stringbuilder2.append(s3).append(" ").append(mNetworkId).append(" ").append(mSystemId).append(" RoamInd=").append(mCdmaRoamingIndicator).append(" DefRoamInd=").append(mCdmaDefaultRoamingIndicator).append(" EmergOnly=").append(mIsEmergencyOnly).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int j = 1;
        parcel.writeInt(mState);
        int k;
        int l;
        int i1;
        if(mRoaming)
            k = j;
        else
            k = 0;
        parcel.writeInt(k);
        parcel.writeString(mOperatorAlphaLong);
        parcel.writeString(mOperatorAlphaShort);
        parcel.writeString(mOperatorNumeric);
        if(mIsManualNetworkSelection)
            l = j;
        else
            l = 0;
        parcel.writeInt(l);
        parcel.writeInt(mRadioTechnology);
        if(mCssIndicator)
            i1 = j;
        else
            i1 = 0;
        parcel.writeInt(i1);
        parcel.writeInt(mNetworkId);
        parcel.writeInt(mSystemId);
        parcel.writeInt(mCdmaRoamingIndicator);
        parcel.writeInt(mCdmaDefaultRoamingIndicator);
        parcel.writeInt(mCdmaEriIconIndex);
        parcel.writeInt(mCdmaEriIconMode);
        if(!mIsEmergencyOnly)
            j = 0;
        parcel.writeInt(j);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ServiceState createFromParcel(Parcel parcel) {
            return new ServiceState(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public ServiceState[] newArray(int i) {
            return new ServiceState[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    static final String LOG_TAG = "PHONE";
    public static final int REGISTRATION_STATE_HOME_NETWORK = 1;
    public static final int REGISTRATION_STATE_NOT_REGISTERED_AND_NOT_SEARCHING = 0;
    public static final int REGISTRATION_STATE_NOT_REGISTERED_AND_SEARCHING = 2;
    public static final int REGISTRATION_STATE_REGISTRATION_DENIED = 3;
    public static final int REGISTRATION_STATE_ROAMING = 5;
    public static final int REGISTRATION_STATE_UNKNOWN = 4;
    public static final int RIL_RADIO_TECHNOLOGY_1xRTT = 6;
    public static final int RIL_RADIO_TECHNOLOGY_EDGE = 2;
    public static final int RIL_RADIO_TECHNOLOGY_EHRPD = 13;
    public static final int RIL_RADIO_TECHNOLOGY_EVDO_0 = 7;
    public static final int RIL_RADIO_TECHNOLOGY_EVDO_A = 8;
    public static final int RIL_RADIO_TECHNOLOGY_EVDO_B = 12;
    public static final int RIL_RADIO_TECHNOLOGY_GPRS = 1;
    public static final int RIL_RADIO_TECHNOLOGY_GSM = 16;
    public static final int RIL_RADIO_TECHNOLOGY_HSDPA = 9;
    public static final int RIL_RADIO_TECHNOLOGY_HSPA = 11;
    public static final int RIL_RADIO_TECHNOLOGY_HSPAP = 15;
    public static final int RIL_RADIO_TECHNOLOGY_HSUPA = 10;
    public static final int RIL_RADIO_TECHNOLOGY_IS95A = 4;
    public static final int RIL_RADIO_TECHNOLOGY_IS95B = 5;
    public static final int RIL_RADIO_TECHNOLOGY_LTE = 14;
    public static final int RIL_RADIO_TECHNOLOGY_UMTS = 3;
    public static final int RIL_RADIO_TECHNOLOGY_UNKNOWN = 0;
    public static final int STATE_EMERGENCY_ONLY = 2;
    public static final int STATE_IN_SERVICE = 0;
    public static final int STATE_OUT_OF_SERVICE = 1;
    public static final int STATE_POWER_OFF = 3;
    private int mCdmaDefaultRoamingIndicator;
    private int mCdmaEriIconIndex;
    private int mCdmaEriIconMode;
    private int mCdmaRoamingIndicator;
    private boolean mCssIndicator;
    private boolean mIsEmergencyOnly;
    private boolean mIsManualNetworkSelection;
    private int mNetworkId;
    private String mOperatorAlphaLong;
    private String mOperatorAlphaShort;
    private String mOperatorNumeric;
    private int mRadioTechnology;
    private boolean mRoaming;
    private int mState;
    private int mSystemId;

}

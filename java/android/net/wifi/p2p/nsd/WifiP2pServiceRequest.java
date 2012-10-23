// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.wifi.p2p.nsd;

import android.os.Parcel;
import android.os.Parcelable;

public class WifiP2pServiceRequest
    implements Parcelable {

    private WifiP2pServiceRequest(int i, int j, int k, String s) {
        mProtocolType = i;
        mLength = j;
        mTransId = k;
        mQuery = s;
    }


    protected WifiP2pServiceRequest(int i, String s) {
        validateQuery(s);
        mProtocolType = i;
        mQuery = s;
        if(s != null)
            mLength = 2 + s.length() / 2;
        else
            mLength = 2;
    }

    public static WifiP2pServiceRequest newInstance(int i) {
        return new WifiP2pServiceRequest(i, null);
    }

    public static WifiP2pServiceRequest newInstance(int i, String s) {
        return new WifiP2pServiceRequest(i, s);
    }

    private void validateQuery(String s) {
        if(s != null) {
            if(s.length() % 2 == 1)
                throw new IllegalArgumentException((new StringBuilder()).append("query size is invalid. query=").append(s).toString());
            if(s.length() / 2 > 65535)
                throw new IllegalArgumentException((new StringBuilder()).append("query size is too large. len=").append(s.length()).toString());
            String s1 = s.toLowerCase();
            char ac[] = s1.toCharArray();
            int i = ac.length;
            int j = 0;
            while(j < i)  {
                char c = ac[j];
                if((c < '0' || c > '9') && (c < 'a' || c > 'f'))
                    throw new IllegalArgumentException((new StringBuilder()).append("query should be hex string. query=").append(s1).toString());
                j++;
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean flag = true;
        if(obj != this) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(!(obj instanceof WifiP2pServiceRequest)) {
            flag = false;
        } else {
            WifiP2pServiceRequest wifip2pservicerequest = (WifiP2pServiceRequest)obj;
            if(wifip2pservicerequest.mProtocolType != mProtocolType || wifip2pservicerequest.mLength != mLength)
                flag = false;
            else
            if(wifip2pservicerequest.mQuery != null || mQuery != null)
                if(wifip2pservicerequest.mQuery != null)
                    flag = wifip2pservicerequest.mQuery.equals(mQuery);
                else
                    flag = false;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public String getSupplicantQuery() {
        StringBuffer stringbuffer = new StringBuffer();
        Object aobj[] = new Object[1];
        aobj[0] = Integer.valueOf(0xff & mLength);
        stringbuffer.append(String.format("%02x", aobj));
        Object aobj1[] = new Object[1];
        aobj1[0] = Integer.valueOf(0xff & mLength >> 8);
        stringbuffer.append(String.format("%02x", aobj1));
        Object aobj2[] = new Object[1];
        aobj2[0] = Integer.valueOf(mProtocolType);
        stringbuffer.append(String.format("%02x", aobj2));
        Object aobj3[] = new Object[1];
        aobj3[0] = Integer.valueOf(mTransId);
        stringbuffer.append(String.format("%02x", aobj3));
        if(mQuery != null)
            stringbuffer.append(mQuery);
        return stringbuffer.toString();
    }

    public int getTransactionId() {
        return mTransId;
    }

    public int hashCode() {
        int i = 31 * (31 * (527 + mProtocolType) + mLength);
        int j;
        if(mQuery == null)
            j = 0;
        else
            j = mQuery.hashCode();
        return i + j;
    }

    public void setTransactionId(int i) {
        mTransId = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mProtocolType);
        parcel.writeInt(mLength);
        parcel.writeInt(mTransId);
        parcel.writeString(mQuery);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public WifiP2pServiceRequest createFromParcel(Parcel parcel) {
            return new WifiP2pServiceRequest(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString());
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public WifiP2pServiceRequest[] newArray(int i) {
            return new WifiP2pServiceRequest[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private int mLength;
    private int mProtocolType;
    private String mQuery;
    private int mTransId;

}

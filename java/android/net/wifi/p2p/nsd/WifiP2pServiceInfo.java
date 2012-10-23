// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.wifi.p2p.nsd;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class WifiP2pServiceInfo
    implements Parcelable {

    protected WifiP2pServiceInfo(List list) {
        if(list == null) {
            throw new IllegalArgumentException("query list cannot be null");
        } else {
            mQueryList = list;
            return;
        }
    }

    static String bin2HexStr(byte abyte0[]) {
        StringBuffer stringbuffer;
        int i;
        int j;
        stringbuffer = new StringBuffer();
        i = abyte0.length;
        j = 0;
_L2:
        int k;
        if(j >= i)
            break; /* Loop/switch isn't completed */
        k = 0xff & abyte0[j];
        String s1 = Integer.toHexString(k);
        if(s1.length() == 1)
            stringbuffer.append('0');
        stringbuffer.append(s1);
        j++;
        if(true) goto _L2; else goto _L1
        Exception exception;
        exception;
        String s;
        exception.printStackTrace();
        s = null;
_L4:
        return s;
_L1:
        s = stringbuffer.toString();
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean flag;
        if(obj == this)
            flag = true;
        else
        if(!(obj instanceof WifiP2pServiceInfo)) {
            flag = false;
        } else {
            WifiP2pServiceInfo wifip2pserviceinfo = (WifiP2pServiceInfo)obj;
            flag = mQueryList.equals(wifip2pserviceinfo.mQueryList);
        }
        return flag;
    }

    public List getSupplicantQueryList() {
        return mQueryList;
    }

    public int hashCode() {
        int i;
        if(mQueryList == null)
            i = 0;
        else
            i = mQueryList.hashCode();
        return i + 527;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(mQueryList);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public WifiP2pServiceInfo createFromParcel(Parcel parcel) {
            ArrayList arraylist = new ArrayList();
            parcel.readStringList(arraylist);
            return new WifiP2pServiceInfo(arraylist);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public WifiP2pServiceInfo[] newArray(int i) {
            return new WifiP2pServiceInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int SERVICE_TYPE_ALL = 0;
    public static final int SERVICE_TYPE_BONJOUR = 1;
    public static final int SERVICE_TYPE_UPNP = 2;
    public static final int SERVICE_TYPE_VENDOR_SPECIFIC = 255;
    public static final int SERVICE_TYPE_WS_DISCOVERY = 3;
    private List mQueryList;

}

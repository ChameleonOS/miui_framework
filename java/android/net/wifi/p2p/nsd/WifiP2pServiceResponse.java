// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.wifi.p2p.nsd;

import android.net.wifi.p2p.WifiP2pDevice;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.*;
import java.util.*;

// Referenced classes of package android.net.wifi.p2p.nsd:
//            WifiP2pDnsSdServiceResponse, WifiP2pUpnpServiceResponse

public class WifiP2pServiceResponse
    implements Parcelable {
    public static class Status {

        public static String toString(int i) {
            i;
            JVM INSTR tableswitch 0 3: default 32
        //                       0 37
        //                       1 43
        //                       2 49
        //                       3 55;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            String s = "UNKNOWN";
_L7:
            return s;
_L2:
            s = "SUCCESS";
            continue; /* Loop/switch isn't completed */
_L3:
            s = "SERVICE_PROTOCOL_NOT_AVAILABLE";
            continue; /* Loop/switch isn't completed */
_L4:
            s = "REQUESTED_INFORMATION_NOT_AVAILABLE";
            continue; /* Loop/switch isn't completed */
_L5:
            s = "BAD_REQUEST";
            if(true) goto _L7; else goto _L6
_L6:
        }

        public static final int BAD_REQUEST = 3;
        public static final int REQUESTED_INFORMATION_NOT_AVAILABLE = 2;
        public static final int SERVICE_PROTOCOL_NOT_AVAILABLE = 1;
        public static final int SUCCESS;

        private Status() {
        }
    }


    protected WifiP2pServiceResponse(int i, int j, int k, WifiP2pDevice wifip2pdevice, byte abyte0[]) {
        mServiceType = i;
        mStatus = j;
        mTransId = k;
        mDevice = wifip2pdevice;
        mData = abyte0;
    }

    private boolean equals(Object obj, Object obj1) {
        boolean flag;
        if(obj == null && obj1 == null)
            flag = true;
        else
        if(obj != null)
            flag = obj.equals(obj1);
        else
            flag = false;
        return flag;
    }

    private static byte[] hexStr2Bin(String s) {
        int i;
        byte abyte0[];
        int j;
        i = s.length() / 2;
        abyte0 = new byte[s.length() / 2];
        j = 0;
_L2:
        int k;
        int l;
        if(j >= i)
            break; /* Loop/switch isn't completed */
        k = j * 2;
        l = 2 + j * 2;
        abyte0[j] = (byte)Integer.parseInt(s.substring(k, l), 16);
        j++;
        if(true) goto _L2; else goto _L1
        Exception exception;
        exception;
        exception.printStackTrace();
        abyte0 = null;
_L1:
        return abyte0;
    }

    public static List newInstance(String s) {
        ArrayList arraylist;
        WifiP2pDevice wifip2pdevice;
        byte abyte0[];
        arraylist = new ArrayList();
        String as[] = s.split(" ");
        if(as.length != 4) {
            arraylist = null;
        } else {
label0:
            {
                wifip2pdevice = new WifiP2pDevice();
                wifip2pdevice.deviceAddress = as[1];
                abyte0 = hexStr2Bin(as[3]);
                if(abyte0 != null)
                    break label0;
                arraylist = null;
            }
        }
_L2:
        return arraylist;
        DataInputStream datainputstream = new DataInputStream(new ByteArrayInputStream(abyte0));
_L3:
        if(datainputstream.available() <= 0) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        byte byte0;
        int k;
        i = -3 + ((0xff & datainputstream.readByte()) + ((0xff & datainputstream.readByte()) << 8));
        j = datainputstream.readUnsignedByte();
        byte0 = datainputstream.readByte();
        k = datainputstream.readUnsignedByte();
        if(i >= 0)
            break MISSING_BLOCK_LABEL_142;
        arraylist = null;
          goto _L2
        if(i != 0)
            break MISSING_BLOCK_LABEL_198;
        if(k == 0)
            arraylist.add(new WifiP2pServiceResponse(j, k, byte0, wifip2pdevice, null));
          goto _L3
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
        if(arraylist.size() <= 0)
            arraylist = null;
          goto _L2
        if(i > MAX_BUF_SIZE) {
            datainputstream.skip(i);
        } else {
            byte abyte1[] = new byte[i];
            datainputstream.readFully(abyte1);
            Object obj;
            if(j == 1)
                obj = WifiP2pDnsSdServiceResponse.newInstance(k, byte0, wifip2pdevice, abyte1);
            else
            if(j == 2)
                obj = WifiP2pUpnpServiceResponse.newInstance(k, byte0, wifip2pdevice, abyte1);
            else
                obj = new WifiP2pServiceResponse(j, k, byte0, wifip2pdevice, abyte1);
            if(obj != null && ((WifiP2pServiceResponse) (obj)).getStatus() == 0)
                arraylist.add(obj);
        }
          goto _L3
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
        if(!(obj instanceof WifiP2pServiceResponse)) {
            flag = false;
        } else {
            WifiP2pServiceResponse wifip2pserviceresponse = (WifiP2pServiceResponse)obj;
            if(wifip2pserviceresponse.mServiceType != mServiceType || wifip2pserviceresponse.mStatus != mStatus || !equals(wifip2pserviceresponse.mDevice.deviceAddress, mDevice.deviceAddress) || !Arrays.equals(wifip2pserviceresponse.mData, mData))
                flag = false;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public byte[] getRawData() {
        return mData;
    }

    public int getServiceType() {
        return mServiceType;
    }

    public WifiP2pDevice getSrcDevice() {
        return mDevice;
    }

    public int getStatus() {
        return mStatus;
    }

    public int getTransactionId() {
        return mTransId;
    }

    public int hashCode() {
        int i = 0;
        int j = 31 * (31 * (31 * (527 + mServiceType) + mStatus) + mTransId);
        int k;
        int l;
        if(mDevice.deviceAddress == null)
            k = 0;
        else
            k = mDevice.deviceAddress.hashCode();
        l = 31 * (j + k);
        if(mData != null)
            i = mData.hashCode();
        return l + i;
    }

    public void setSrcDevice(WifiP2pDevice wifip2pdevice) {
        if(wifip2pdevice != null)
            mDevice = wifip2pdevice;
    }

    public String toString() {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("serviceType:").append(mServiceType);
        stringbuffer.append(" status:").append(Status.toString(mStatus));
        stringbuffer.append(" srcAddr:").append(mDevice.deviceAddress);
        stringbuffer.append(" data:").append(mData);
        return stringbuffer.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mServiceType);
        parcel.writeInt(mStatus);
        parcel.writeInt(mTransId);
        parcel.writeParcelable(mDevice, i);
        if(mData == null || mData.length == 0) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(mData.length);
            parcel.writeByteArray(mData);
        }
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public WifiP2pServiceResponse createFromParcel(Parcel parcel) {
            int i = parcel.readInt();
            int j = parcel.readInt();
            int k = parcel.readInt();
            WifiP2pDevice wifip2pdevice = (WifiP2pDevice)parcel.readParcelable(null);
            int l = parcel.readInt();
            byte abyte0[] = null;
            if(l > 0) {
                abyte0 = new byte[l];
                parcel.readByteArray(abyte0);
            }
            Object obj;
            if(i == 1)
                obj = WifiP2pDnsSdServiceResponse.newInstance(j, k, wifip2pdevice, abyte0);
            else
            if(i == 2)
                obj = WifiP2pUpnpServiceResponse.newInstance(j, k, wifip2pdevice, abyte0);
            else
                obj = new WifiP2pServiceResponse(i, j, k, wifip2pdevice, abyte0);
            return ((WifiP2pServiceResponse) (obj));
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public WifiP2pServiceResponse[] newArray(int i) {
            return new WifiP2pServiceResponse[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private static int MAX_BUF_SIZE = 1024;
    protected byte mData[];
    protected WifiP2pDevice mDevice;
    protected int mServiceType;
    protected int mStatus;
    protected int mTransId;

}

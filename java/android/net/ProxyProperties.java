// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.net.InetSocketAddress;
import java.net.Proxy;

// Referenced classes of package android.net:
//            Uri

public class ProxyProperties
    implements Parcelable {

    public ProxyProperties(ProxyProperties proxyproperties) {
        if(proxyproperties != null) {
            mHost = proxyproperties.getHost();
            mPort = proxyproperties.getPort();
            mExclusionList = proxyproperties.getExclusionList();
            mParsedExclusionList = proxyproperties.mParsedExclusionList;
        }
    }

    public ProxyProperties(String s, int i, String s1) {
        mHost = s;
        mPort = i;
        setExclusionList(s1);
    }

    private ProxyProperties(String s, int i, String s1, String as[]) {
        mHost = s;
        mPort = i;
        mExclusionList = s1;
        mParsedExclusionList = as;
    }


    private void setExclusionList(String s) {
        mExclusionList = s;
        if(mExclusionList == null) {
            mParsedExclusionList = new String[0];
        } else {
            String as[] = s.toLowerCase().split(",");
            mParsedExclusionList = new String[2 * as.length];
            int i = 0;
            while(i < as.length)  {
                String s1 = as[i].trim();
                if(s1.startsWith("."))
                    s1 = s1.substring(1);
                mParsedExclusionList[i * 2] = s1;
                mParsedExclusionList[1 + i * 2] = (new StringBuilder()).append(".").append(s1).toString();
                i++;
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean flag = false;
        if(obj instanceof ProxyProperties) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        ProxyProperties proxyproperties = (ProxyProperties)obj;
        if((mExclusionList == null || mExclusionList.equals(proxyproperties.getExclusionList())) && (mHost == null || proxyproperties.getHost() == null || mHost.equals(proxyproperties.getHost())) && (mHost == null || proxyproperties.mHost != null) && (mHost != null || proxyproperties.mHost == null) && mPort == proxyproperties.mPort)
            flag = true;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public String getExclusionList() {
        return mExclusionList;
    }

    public String getHost() {
        return mHost;
    }

    public int getPort() {
        return mPort;
    }

    public InetSocketAddress getSocketAddress() {
        InetSocketAddress inetsocketaddress = null;
        InetSocketAddress inetsocketaddress1 = new InetSocketAddress(mHost, mPort);
        inetsocketaddress = inetsocketaddress1;
_L2:
        return inetsocketaddress;
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int hashCode() {
        int i = 0;
        int j;
        if(mHost == null)
            j = 0;
        else
            j = mHost.hashCode();
        if(mExclusionList != null)
            i = mExclusionList.hashCode();
        return j + i + mPort;
    }

    public boolean isExcluded(String s) {
        boolean flag = false;
        if(!TextUtils.isEmpty(s) && mParsedExclusionList != null && mParsedExclusionList.length != 0) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        String s1;
        int i;
        s1 = Uri.parse(s).getHost();
        if(s1 == null)
            continue; /* Loop/switch isn't completed */
        i = 0;
_L4:
        if(i < mParsedExclusionList.length) {
label0:
            {
                if(!s1.equals(mParsedExclusionList[i]) && !s1.endsWith(mParsedExclusionList[i + 1]))
                    break label0;
                flag = true;
            }
        }
        if(true) goto _L1; else goto _L3
_L3:
        i += 2;
          goto _L4
        if(true) goto _L1; else goto _L5
_L5:
    }

    public Proxy makeProxy() {
        Proxy proxy;
        proxy = Proxy.NO_PROXY;
        if(mHost == null)
            break MISSING_BLOCK_LABEL_41;
        Proxy proxy1;
        InetSocketAddress inetsocketaddress = new InetSocketAddress(mHost, mPort);
        proxy1 = new Proxy(java.net.Proxy.Type.HTTP, inetsocketaddress);
        proxy = proxy1;
_L2:
        return proxy;
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();
        if(mHost != null) {
            stringbuilder.append("[");
            stringbuilder.append(mHost);
            stringbuilder.append("] ");
            stringbuilder.append(Integer.toString(mPort));
            if(mExclusionList != null)
                stringbuilder.append(" xl=").append(mExclusionList);
        } else {
            stringbuilder.append("[ProxyProperties.mHost == null]");
        }
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        if(mHost != null) {
            parcel.writeByte((byte)1);
            parcel.writeString(mHost);
            parcel.writeInt(mPort);
        } else {
            parcel.writeByte((byte)0);
        }
        parcel.writeString(mExclusionList);
        parcel.writeStringArray(mParsedExclusionList);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ProxyProperties createFromParcel(Parcel parcel) {
            String s = null;
            int i = 0;
            if(parcel.readByte() == 1) {
                s = parcel.readString();
                i = parcel.readInt();
            }
            return new ProxyProperties(s, i, parcel.readString(), parcel.readStringArray());
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public ProxyProperties[] newArray(int i) {
            return new ProxyProperties[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private String mExclusionList;
    private String mHost;
    private String mParsedExclusionList[];
    private int mPort;

}

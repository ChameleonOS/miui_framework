// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.collect.Sets;
import java.net.InetAddress;
import java.util.HashSet;
import java.util.Iterator;

// Referenced classes of package android.net:
//            LinkAddress

public class InterfaceConfiguration
    implements Parcelable {

    public InterfaceConfiguration() {
        mFlags = Sets.newHashSet();
    }

    private static void validateFlag(String s) {
        if(s.indexOf(' ') >= 0)
            throw new IllegalArgumentException((new StringBuilder()).append("flag contains space: ").append(s).toString());
        else
            return;
    }

    public void clearFlag(String s) {
        validateFlag(s);
        mFlags.remove(s);
    }

    public int describeContents() {
        return 0;
    }

    public Iterable getFlags() {
        return mFlags;
    }

    public String getHardwareAddress() {
        return mHwAddr;
    }

    public LinkAddress getLinkAddress() {
        return mAddr;
    }

    public boolean hasFlag(String s) {
        validateFlag(s);
        return mFlags.contains(s);
    }

    public boolean isActive() {
        boolean flag = false;
        if(!hasFlag("up")) goto _L2; else goto _L1
_L1:
        byte abyte0[];
        int i;
        int j;
        abyte0 = mAddr.getAddress().getAddress();
        i = abyte0.length;
        j = 0;
_L6:
        if(j >= i) goto _L2; else goto _L3
_L3:
        byte byte0 = abyte0[j];
        if(byte0 == 0) goto _L5; else goto _L4
_L4:
        flag = true;
_L2:
        return flag;
_L5:
        j++;
          goto _L6
        NullPointerException nullpointerexception;
        nullpointerexception;
          goto _L2
    }

    public void setFlag(String s) {
        validateFlag(s);
        mFlags.add(s);
    }

    public void setHardwareAddress(String s) {
        mHwAddr = s;
    }

    public void setInterfaceDown() {
        mFlags.remove("up");
        mFlags.add("down");
    }

    public void setInterfaceUp() {
        mFlags.remove("down");
        mFlags.add("up");
    }

    public void setLinkAddress(LinkAddress linkaddress) {
        mAddr = linkaddress;
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("mHwAddr=").append(mHwAddr);
        stringbuilder.append(" mAddr=").append(String.valueOf(mAddr));
        stringbuilder.append(" mFlags=").append(getFlags());
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mHwAddr);
        if(mAddr != null) {
            parcel.writeByte((byte)1);
            parcel.writeParcelable(mAddr, i);
        } else {
            parcel.writeByte((byte)0);
        }
        parcel.writeInt(mFlags.size());
        for(Iterator iterator = mFlags.iterator(); iterator.hasNext(); parcel.writeString((String)iterator.next()));
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public InterfaceConfiguration createFromParcel(Parcel parcel) {
            InterfaceConfiguration interfaceconfiguration = new InterfaceConfiguration();
            interfaceconfiguration.mHwAddr = parcel.readString();
            if(parcel.readByte() == 1)
                interfaceconfiguration.mAddr = (LinkAddress)parcel.readParcelable(null);
            int i = parcel.readInt();
            for(int j = 0; j < i; j++)
                interfaceconfiguration.mFlags.add(parcel.readString());

            return interfaceconfiguration;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public InterfaceConfiguration[] newArray(int i) {
            return new InterfaceConfiguration[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private static final String FLAG_DOWN = "down";
    private static final String FLAG_UP = "up";
    private LinkAddress mAddr;
    private HashSet mFlags;
    private String mHwAddr;



/*
    static String access$002(InterfaceConfiguration interfaceconfiguration, String s) {
        interfaceconfiguration.mHwAddr = s;
        return s;
    }

*/


/*
    static LinkAddress access$102(InterfaceConfiguration interfaceconfiguration, LinkAddress linkaddress) {
        interfaceconfiguration.mAddr = linkaddress;
        return linkaddress;
    }

*/

}

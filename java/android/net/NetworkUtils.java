// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.util.Log;
import java.net.*;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package android.net:
//            DhcpInfoInternal

public class NetworkUtils {

    public NetworkUtils() {
    }

    public static boolean addressTypeMatches(InetAddress inetaddress, InetAddress inetaddress1) {
        boolean flag;
        if((inetaddress instanceof Inet4Address) && (inetaddress1 instanceof Inet4Address) || (inetaddress instanceof Inet6Address) && (inetaddress1 instanceof Inet6Address))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static native int disableInterface(String s);

    public static native int enableInterface(String s);

    public static native String getDhcpError();

    public static InetAddress getNetworkPart(InetAddress inetaddress, int i) {
        if(inetaddress == null)
            throw new RuntimeException("getNetworkPart doesn't accept null address");
        byte abyte0[] = inetaddress.getAddress();
        if(i < 0 || i > 8 * abyte0.length)
            throw new RuntimeException("getNetworkPart - bad prefixLength");
        int j = i / 8;
        byte byte0 = (byte)(255 << 8 - i % 8);
        if(j < abyte0.length)
            abyte0[j] = byte0 & abyte0[j];
        for(int k = j + 1; k < abyte0.length; k++)
            abyte0[k] = 0;

        InetAddress inetaddress1;
        try {
            inetaddress1 = InetAddress.getByAddress(abyte0);
        }
        catch(UnknownHostException unknownhostexception) {
            throw new RuntimeException((new StringBuilder()).append("getNetworkPart error - ").append(unknownhostexception.toString()).toString());
        }
        return inetaddress1;
    }

    public static InetAddress hexToInet6Address(String s) throws IllegalArgumentException {
        InetAddress inetaddress;
        try {
            Object aobj[] = new Object[8];
            aobj[0] = s.substring(0, 4);
            aobj[1] = s.substring(4, 8);
            aobj[2] = s.substring(8, 12);
            aobj[3] = s.substring(12, 16);
            aobj[4] = s.substring(16, 20);
            aobj[5] = s.substring(20, 24);
            aobj[6] = s.substring(24, 28);
            aobj[7] = s.substring(28, 32);
            inetaddress = numericToInetAddress(String.format("%s:%s:%s:%s:%s:%s:%s:%s", aobj));
        }
        catch(Exception exception) {
            Log.e("NetworkUtils", (new StringBuilder()).append("error in hexToInet6Address(").append(s).append("): ").append(exception).toString());
            throw new IllegalArgumentException(exception);
        }
        return inetaddress;
    }

    public static int inetAddressToInt(InetAddress inetaddress) throws IllegalArgumentException {
        byte abyte0[] = inetaddress.getAddress();
        if(abyte0.length != 4)
            throw new IllegalArgumentException("Not an IPv4 address");
        else
            return (0xff & abyte0[3]) << 24 | (0xff & abyte0[2]) << 16 | (0xff & abyte0[1]) << 8 | 0xff & abyte0[0];
    }

    public static InetAddress intToInetAddress(int i) {
        byte abyte0[] = new byte[4];
        abyte0[0] = (byte)(i & 0xff);
        abyte0[1] = (byte)(0xff & i >> 8);
        abyte0[2] = (byte)(0xff & i >> 16);
        abyte0[3] = (byte)(0xff & i >> 24);
        InetAddress inetaddress;
        try {
            inetaddress = InetAddress.getByAddress(abyte0);
        }
        catch(UnknownHostException unknownhostexception) {
            throw new AssertionError();
        }
        return inetaddress;
    }

    public static String[] makeStrings(Collection collection) {
        String as[] = new String[collection.size()];
        int i = 0;
        for(Iterator iterator = collection.iterator(); iterator.hasNext();) {
            InetAddress inetaddress = (InetAddress)iterator.next();
            int j = i + 1;
            as[i] = inetaddress.getHostAddress();
            i = j;
        }

        return as;
    }

    public static int netmaskIntToPrefixLength(int i) {
        return Integer.bitCount(i);
    }

    public static InetAddress numericToInetAddress(String s) throws IllegalArgumentException {
        return InetAddress.parseNumericAddress(s);
    }

    public static int prefixLengthToNetmaskInt(int i) throws IllegalArgumentException {
        if(i < 0 || i > 32)
            throw new IllegalArgumentException("Invalid prefix length (0 <= prefix <= 32)");
        else
            return Integer.reverseBytes(-1 << 32 - i);
    }

    public static native boolean releaseDhcpLease(String s);

    public static native int resetConnections(String s, int i);

    public static native boolean runDhcp(String s, DhcpInfoInternal dhcpinfointernal);

    public static native boolean runDhcpRenew(String s, DhcpInfoInternal dhcpinfointernal);

    public static native boolean stopDhcp(String s);

    public static String trimV4AddrZeros(String s) {
        if(s != null) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        return s;
_L2:
        String as[] = s.split("\\.");
        if(as.length != 4)
            continue; /* Loop/switch isn't completed */
        StringBuilder stringbuilder = new StringBuilder(16);
        int i = 0;
        do {
            if(i >= 4)
                break;
            try {
                if(as[i].length() > 3)
                    continue; /* Loop/switch isn't completed */
                stringbuilder.append(Integer.parseInt(as[i]));
            }
            catch(NumberFormatException numberformatexception) {
                continue; /* Loop/switch isn't completed */
            }
            if(i < 3)
                stringbuilder.append('.');
            i++;
        } while(true);
        s = stringbuilder.toString();
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static final int RESET_ALL_ADDRESSES = 3;
    public static final int RESET_IPV4_ADDRESSES = 1;
    public static final int RESET_IPV6_ADDRESSES = 2;
    private static final String TAG = "NetworkUtils";
}

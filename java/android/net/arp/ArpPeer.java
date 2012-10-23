// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.arp;

import android.os.SystemClock;
import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import libcore.net.RawSocket;

public class ArpPeer {

    public ArpPeer(String s, InetAddress inetaddress, String s1, InetAddress inetaddress1) throws SocketException {
        mInterfaceName = s;
        mMyAddr = inetaddress;
        for(int i = 0; i < 6; i++)
            mMyMac[i] = (byte)Integer.parseInt(s1.substring(i * 3, 2 + i * 3), 16);

        if((inetaddress instanceof Inet6Address) || (inetaddress1 instanceof Inet6Address)) {
            throw new IllegalArgumentException("IPv6 unsupported");
        } else {
            mPeer = inetaddress1;
            L2_BROADCAST = new byte[6];
            Arrays.fill(L2_BROADCAST, (byte)-1);
            mSocket = new RawSocket(mInterfaceName, (short)2054);
            return;
        }
    }

    public void close() {
        mSocket.close();
_L2:
        return;
        IOException ioexception;
        ioexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public byte[] doArp(int i) {
        byte abyte0[];
        long l;
        byte abyte1[];
        ByteBuffer bytebuffer = ByteBuffer.allocate(1500);
        abyte0 = mPeer.getAddress();
        l = SystemClock.elapsedRealtime() + (long)i;
        bytebuffer.clear();
        bytebuffer.order(ByteOrder.BIG_ENDIAN);
        bytebuffer.putShort((short)1);
        bytebuffer.putShort((short)2048);
        bytebuffer.put((byte)6);
        bytebuffer.put((byte)4);
        bytebuffer.putShort((short)1);
        bytebuffer.put(mMyMac);
        bytebuffer.put(mMyAddr.getAddress());
        bytebuffer.put(new byte[6]);
        bytebuffer.put(abyte0);
        bytebuffer.flip();
        mSocket.write(L2_BROADCAST, bytebuffer.array(), 0, bytebuffer.limit());
        abyte1 = new byte[1500];
_L4:
        if(SystemClock.elapsedRealtime() >= l) goto _L2; else goto _L1
_L1:
        long l1 = l - SystemClock.elapsedRealtime();
        if(mSocket.read(abyte1, 0, abyte1.length, -1, (int)l1) < 28 || abyte1[0] != 0 || abyte1[1] != 1 || abyte1[2] != 8 || abyte1[3] != 0 || abyte1[4] != 6 || abyte1[5] != 4 || abyte1[6] != 0 || abyte1[7] != 2 || abyte1[14] != abyte0[0] || abyte1[15] != abyte0[1] || abyte1[16] != abyte0[2] || abyte1[17] != abyte0[3]) goto _L4; else goto _L3
_L3:
        byte abyte2[];
        abyte2 = new byte[6];
        System.arraycopy(abyte1, 8, abyte2, 0, 6);
_L6:
        return abyte2;
_L2:
        abyte2 = null;
        if(true) goto _L6; else goto _L5
_L5:
    }

    private static final int ARP_LENGTH = 28;
    private static final int ETHERNET_TYPE = 1;
    private static final int IPV4_LENGTH = 4;
    private static final int MAC_ADDR_LENGTH = 6;
    private static final int MAX_LENGTH = 1500;
    private static final String TAG = "ArpPeer";
    private final byte L2_BROADCAST[];
    private String mInterfaceName;
    private final InetAddress mMyAddr;
    private final byte mMyMac[] = new byte[6];
    private final InetAddress mPeer;
    private final RawSocket mSocket;
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.dhcp;

import java.net.Inet4Address;
import java.nio.ByteBuffer;

// Referenced classes of package android.net.dhcp:
//            DhcpPacket, DhcpStateMachine

class DhcpDiscoverPacket extends DhcpPacket {

    DhcpDiscoverPacket(int i, byte abyte0[], boolean flag) {
        super(i, Inet4Address.ANY, Inet4Address.ANY, Inet4Address.ANY, Inet4Address.ANY, abyte0, flag);
    }

    public ByteBuffer buildPacket(int i, short word0, short word1) {
        ByteBuffer bytebuffer = ByteBuffer.allocate(1500);
        java.net.InetAddress _tmp = Inet4Address.ALL;
        fillInPacket(i, Inet4Address.ALL, Inet4Address.ANY, word0, word1, bytebuffer, (byte)1, true);
        bytebuffer.flip();
        return bytebuffer;
    }

    public void doNextOp(DhcpStateMachine dhcpstatemachine) {
        dhcpstatemachine.onDiscoverReceived(super.mBroadcast, super.mTransId, super.mClientMac, super.mRequestedParams);
    }

    void finishPacket(ByteBuffer bytebuffer) {
        addTlv(bytebuffer, (byte)53, (byte)1);
        addTlv(bytebuffer, (byte)55, super.mRequestedParams);
        addTlvEnd(bytebuffer);
    }

    public String toString() {
        String s = super.toString();
        StringBuilder stringbuilder = (new StringBuilder()).append(s).append(" DISCOVER ");
        String s1;
        if(super.mBroadcast)
            s1 = "broadcast ";
        else
            s1 = "unicast ";
        return stringbuilder.append(s1).toString();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.dhcp;

import java.net.InetAddress;
import java.nio.ByteBuffer;

// Referenced classes of package android.net.dhcp:
//            DhcpPacket, DhcpStateMachine

class DhcpDeclinePacket extends DhcpPacket {

    DhcpDeclinePacket(int i, InetAddress inetaddress, InetAddress inetaddress1, InetAddress inetaddress2, InetAddress inetaddress3, byte abyte0[]) {
        super(i, inetaddress, inetaddress1, inetaddress2, inetaddress3, abyte0, false);
    }

    public ByteBuffer buildPacket(int i, short word0, short word1) {
        ByteBuffer bytebuffer = ByteBuffer.allocate(1500);
        fillInPacket(i, super.mClientIp, super.mYourIp, word0, word1, bytebuffer, (byte)1, false);
        bytebuffer.flip();
        return bytebuffer;
    }

    public void doNextOp(DhcpStateMachine dhcpstatemachine) {
        dhcpstatemachine.onDeclineReceived(super.mClientMac, super.mRequestedIp);
    }

    void finishPacket(ByteBuffer bytebuffer) {
    }

    public String toString() {
        String s = super.toString();
        return (new StringBuilder()).append(s).append(" DECLINE").toString();
    }
}

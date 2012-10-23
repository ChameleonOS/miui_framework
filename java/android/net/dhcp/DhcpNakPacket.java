// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.dhcp;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.nio.ByteBuffer;

// Referenced classes of package android.net.dhcp:
//            DhcpPacket, DhcpStateMachine

class DhcpNakPacket extends DhcpPacket {

    DhcpNakPacket(int i, InetAddress inetaddress, InetAddress inetaddress1, InetAddress inetaddress2, InetAddress inetaddress3, byte abyte0[]) {
        super(i, Inet4Address.ANY, Inet4Address.ANY, inetaddress2, inetaddress3, abyte0, false);
    }

    public ByteBuffer buildPacket(int i, short word0, short word1) {
        ByteBuffer bytebuffer = ByteBuffer.allocate(1500);
        fillInPacket(i, super.mClientIp, super.mYourIp, word0, word1, bytebuffer, (byte)2, super.mBroadcast);
        bytebuffer.flip();
        return bytebuffer;
    }

    public void doNextOp(DhcpStateMachine dhcpstatemachine) {
        dhcpstatemachine.onNakReceived();
    }

    void finishPacket(ByteBuffer bytebuffer) {
        addTlv(bytebuffer, (byte)53, (byte)6);
        addTlv(bytebuffer, (byte)54, super.mServerIdentifier);
        addTlv(bytebuffer, (byte)56, super.mMessage);
        addTlvEnd(bytebuffer);
    }

    public String toString() {
        String s = super.toString();
        StringBuilder stringbuilder = (new StringBuilder()).append(s).append(" NAK, reason ");
        String s1;
        if(super.mMessage == null)
            s1 = "(none)";
        else
            s1 = super.mMessage;
        return stringbuilder.append(s1).toString();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.dhcp;

import android.util.Log;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.nio.ByteBuffer;

// Referenced classes of package android.net.dhcp:
//            DhcpPacket, DhcpStateMachine

class DhcpRequestPacket extends DhcpPacket {

    DhcpRequestPacket(int i, InetAddress inetaddress, byte abyte0[], boolean flag) {
        super(i, inetaddress, Inet4Address.ANY, Inet4Address.ANY, Inet4Address.ANY, abyte0, flag);
    }

    public ByteBuffer buildPacket(int i, short word0, short word1) {
        ByteBuffer bytebuffer = ByteBuffer.allocate(1500);
        fillInPacket(i, Inet4Address.ALL, Inet4Address.ANY, word0, word1, bytebuffer, (byte)1, super.mBroadcast);
        bytebuffer.flip();
        return bytebuffer;
    }

    public void doNextOp(DhcpStateMachine dhcpstatemachine) {
        InetAddress inetaddress;
        if(super.mRequestedIp == null)
            inetaddress = super.mClientIp;
        else
            inetaddress = super.mRequestedIp;
        Log.v("DhcpPacket", (new StringBuilder()).append("requested IP is ").append(super.mRequestedIp).append(" and client IP is ").append(super.mClientIp).toString());
        dhcpstatemachine.onRequestReceived(super.mBroadcast, super.mTransId, super.mClientMac, inetaddress, super.mRequestedParams, super.mHostName);
    }

    void finishPacket(ByteBuffer bytebuffer) {
        byte abyte0[] = new byte[7];
        abyte0[0] = 1;
        System.arraycopy(super.mClientMac, 0, abyte0, 1, 6);
        addTlv(bytebuffer, (byte)53, (byte)3);
        addTlv(bytebuffer, (byte)55, super.mRequestedParams);
        addTlv(bytebuffer, (byte)50, super.mRequestedIp);
        addTlv(bytebuffer, (byte)54, super.mServerIdentifier);
        addTlv(bytebuffer, (byte)61, abyte0);
        addTlvEnd(bytebuffer);
    }

    public String toString() {
        String s = super.toString();
        StringBuilder stringbuilder = (new StringBuilder()).append(s).append(" REQUEST, desired IP ").append(super.mRequestedIp).append(" from host '").append(super.mHostName).append("', param list length ");
        int i;
        if(super.mRequestedParams == null)
            i = 0;
        else
            i = super.mRequestedParams.length;
        return stringbuilder.append(i).toString();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.dhcp;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package android.net.dhcp:
//            DhcpPacket, DhcpStateMachine

class DhcpAckPacket extends DhcpPacket {

    DhcpAckPacket(int i, boolean flag, InetAddress inetaddress, InetAddress inetaddress1, byte abyte0[]) {
        super(i, Inet4Address.ANY, inetaddress1, inetaddress, Inet4Address.ANY, abyte0, flag);
        super.mBroadcast = flag;
        mSrcIp = inetaddress;
    }

    private static final int getInt(Integer integer) {
        int i;
        if(integer == null)
            i = 0;
        else
            i = integer.intValue();
        return i;
    }

    public ByteBuffer buildPacket(int i, short word0, short word1) {
        ByteBuffer bytebuffer = ByteBuffer.allocate(1500);
        InetAddress inetaddress;
        InetAddress inetaddress1;
        if(super.mBroadcast)
            inetaddress = Inet4Address.ALL;
        else
            inetaddress = super.mYourIp;
        if(super.mBroadcast)
            inetaddress1 = Inet4Address.ANY;
        else
            inetaddress1 = mSrcIp;
        fillInPacket(i, inetaddress, inetaddress1, word0, word1, bytebuffer, (byte)2, super.mBroadcast);
        bytebuffer.flip();
        return bytebuffer;
    }

    public void doNextOp(DhcpStateMachine dhcpstatemachine) {
        dhcpstatemachine.onAckReceived(super.mYourIp, super.mSubnetMask, super.mGateway, super.mDnsServers, super.mServerIdentifier, getInt(super.mLeaseTime));
    }

    void finishPacket(ByteBuffer bytebuffer) {
        addTlv(bytebuffer, (byte)53, (byte)5);
        addTlv(bytebuffer, (byte)54, super.mServerIdentifier);
        addTlv(bytebuffer, (byte)51, super.mLeaseTime);
        if(super.mLeaseTime != null)
            addTlv(bytebuffer, (byte)58, Integer.valueOf(super.mLeaseTime.intValue() / 2));
        addTlv(bytebuffer, (byte)1, super.mSubnetMask);
        addTlv(bytebuffer, (byte)3, super.mGateway);
        addTlv(bytebuffer, (byte)15, super.mDomainName);
        addTlv(bytebuffer, (byte)28, super.mBroadcastAddress);
        addTlv(bytebuffer, (byte)6, super.mDnsServers);
        addTlvEnd(bytebuffer);
    }

    public String toString() {
        String s = super.toString();
        String s1 = " DNS servers: ";
        for(Iterator iterator = super.mDnsServers.iterator(); iterator.hasNext();) {
            InetAddress inetaddress = (InetAddress)iterator.next();
            s1 = (new StringBuilder()).append(s1).append(inetaddress.toString()).append(" ").toString();
        }

        return (new StringBuilder()).append(s).append(" ACK: your new IP ").append(super.mYourIp).append(", netmask ").append(super.mSubnetMask).append(", gateway ").append(super.mGateway).append(s1).append(", lease time ").append(super.mLeaseTime).toString();
    }

    private final InetAddress mSrcIp;
}

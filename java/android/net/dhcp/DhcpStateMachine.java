// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.dhcp;

import java.net.InetAddress;
import java.util.List;

interface DhcpStateMachine {

    public abstract void onAckReceived(InetAddress inetaddress, InetAddress inetaddress1, InetAddress inetaddress2, List list, InetAddress inetaddress3, int i);

    public abstract void onDeclineReceived(byte abyte0[], InetAddress inetaddress);

    public abstract void onDiscoverReceived(boolean flag, int i, byte abyte0[], byte abyte1[]);

    public abstract void onInformReceived(int i, byte abyte0[], InetAddress inetaddress, byte abyte1[]);

    public abstract void onNakReceived();

    public abstract void onOfferReceived(boolean flag, int i, byte abyte0[], InetAddress inetaddress, InetAddress inetaddress1);

    public abstract void onRequestReceived(boolean flag, int i, byte abyte0[], InetAddress inetaddress, byte abyte1[], String s);
}

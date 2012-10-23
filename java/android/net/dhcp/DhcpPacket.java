// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.dhcp;

import java.io.PrintStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.*;
import java.nio.charset.Charsets;
import java.util.*;

// Referenced classes of package android.net.dhcp:
//            DhcpAckPacket, DhcpDiscoverPacket, DhcpNakPacket, DhcpOfferPacket, 
//            DhcpRequestPacket, DhcpDeclinePacket, DhcpInformPacket, DhcpStateMachine

abstract class DhcpPacket {

    protected DhcpPacket(int i, InetAddress inetaddress, InetAddress inetaddress1, InetAddress inetaddress2, InetAddress inetaddress3, byte abyte0[], boolean flag) {
        mTransId = i;
        mClientIp = inetaddress;
        mYourIp = inetaddress1;
        mNextIp = inetaddress2;
        mRelayIp = inetaddress3;
        mClientMac = abyte0;
        mBroadcast = flag;
    }

    public static ByteBuffer buildAckPacket(int i, int j, boolean flag, InetAddress inetaddress, InetAddress inetaddress1, byte abyte0[], Integer integer, InetAddress inetaddress2, 
            InetAddress inetaddress3, InetAddress inetaddress4, List list, InetAddress inetaddress5, String s) {
        DhcpAckPacket dhcpackpacket = new DhcpAckPacket(j, flag, inetaddress, inetaddress1, abyte0);
        dhcpackpacket.mGateway = inetaddress4;
        dhcpackpacket.mDnsServers = list;
        dhcpackpacket.mLeaseTime = integer;
        dhcpackpacket.mDomainName = s;
        dhcpackpacket.mSubnetMask = inetaddress2;
        dhcpackpacket.mServerIdentifier = inetaddress5;
        dhcpackpacket.mBroadcastAddress = inetaddress3;
        return dhcpackpacket.buildPacket(i, (short)68, (short)67);
    }

    public static ByteBuffer buildDiscoverPacket(int i, int j, byte abyte0[], boolean flag, byte abyte1[]) {
        DhcpDiscoverPacket dhcpdiscoverpacket = new DhcpDiscoverPacket(j, abyte0, flag);
        dhcpdiscoverpacket.mRequestedParams = abyte1;
        return dhcpdiscoverpacket.buildPacket(i, (short)67, (short)68);
    }

    public static ByteBuffer buildNakPacket(int i, int j, InetAddress inetaddress, InetAddress inetaddress1, byte abyte0[]) {
        DhcpNakPacket dhcpnakpacket = new DhcpNakPacket(j, inetaddress1, inetaddress, inetaddress, inetaddress, abyte0);
        dhcpnakpacket.mMessage = "requested address not available";
        dhcpnakpacket.mRequestedIp = inetaddress1;
        return dhcpnakpacket.buildPacket(i, (short)68, (short)67);
    }

    public static ByteBuffer buildOfferPacket(int i, int j, boolean flag, InetAddress inetaddress, InetAddress inetaddress1, byte abyte0[], Integer integer, InetAddress inetaddress2, 
            InetAddress inetaddress3, InetAddress inetaddress4, List list, InetAddress inetaddress5, String s) {
        DhcpOfferPacket dhcpofferpacket = new DhcpOfferPacket(j, flag, inetaddress, inetaddress1, abyte0);
        dhcpofferpacket.mGateway = inetaddress4;
        dhcpofferpacket.mDnsServers = list;
        dhcpofferpacket.mLeaseTime = integer;
        dhcpofferpacket.mDomainName = s;
        dhcpofferpacket.mServerIdentifier = inetaddress5;
        dhcpofferpacket.mSubnetMask = inetaddress2;
        dhcpofferpacket.mBroadcastAddress = inetaddress3;
        return dhcpofferpacket.buildPacket(i, (short)68, (short)67);
    }

    public static ByteBuffer buildRequestPacket(int i, int j, InetAddress inetaddress, boolean flag, byte abyte0[], InetAddress inetaddress1, InetAddress inetaddress2, byte abyte1[], 
            String s) {
        DhcpRequestPacket dhcprequestpacket = new DhcpRequestPacket(j, inetaddress, abyte0, flag);
        dhcprequestpacket.mRequestedIp = inetaddress1;
        dhcprequestpacket.mServerIdentifier = inetaddress2;
        dhcprequestpacket.mHostName = s;
        dhcprequestpacket.mRequestedParams = abyte1;
        return dhcprequestpacket.buildPacket(i, (short)67, (short)68);
    }

    private int checksum(ByteBuffer bytebuffer, int i, int j, int k) {
        int l = i;
        int i1 = bytebuffer.position();
        bytebuffer.position(j);
        ShortBuffer shortbuffer = bytebuffer.asShortBuffer();
        bytebuffer.position(i1);
        short aword0[] = new short[(k - j) / 2];
        shortbuffer.get(aword0);
        int j1 = aword0.length;
        for(int k1 = 0; k1 < j1; k1++)
            l += intAbs(aword0[k1]);

        int l1 = j + 2 * aword0.length;
        if(k != l1) {
            short word0 = bytebuffer.get(l1);
            if(word0 < 0)
                word0 += 256;
            l += word0 * 256;
        }
        int i2 = (0xffff & l >> 16) + (0xffff & l);
        return intAbs((short)(-1 ^ 0xffff & i2 + (0xffff & i2 >> 16)));
    }

    public static DhcpPacket decodeFullPacket(ByteBuffer bytebuffer, int i) {
        ArrayList arraylist;
        InetAddress inetaddress;
        Integer integer;
        InetAddress inetaddress1;
        InetAddress inetaddress2;
        String s;
        byte abyte0[];
        String s1;
        String s2;
        InetAddress inetaddress3;
        InetAddress inetaddress4;
        InetAddress inetaddress5;
        byte byte0;
        arraylist = new ArrayList();
        inetaddress = null;
        integer = null;
        inetaddress1 = null;
        inetaddress2 = null;
        s = null;
        abyte0 = null;
        s1 = null;
        s2 = null;
        inetaddress3 = null;
        inetaddress4 = null;
        inetaddress5 = null;
        byte0 = -1;
        bytebuffer.order(ByteOrder.BIG_ENDIAN);
        if(i != 0) goto _L2; else goto _L1
_L1:
        byte abyte3[] = new byte[6];
        byte abyte4[] = new byte[6];
        bytebuffer.get(abyte3);
        bytebuffer.get(abyte4);
        if(bytebuffer.getShort() == 2048) goto _L2; else goto _L3
_L3:
        Object obj = null;
_L33:
        return ((DhcpPacket) (obj));
_L2:
        int j;
        boolean flag;
        InetAddress inetaddress6;
        InetAddress inetaddress7;
        InetAddress inetaddress8;
        InetAddress inetaddress9;
        byte abyte2[];
        boolean flag1;
        if(i == 0 || i == 1) {
            bytebuffer.get();
            bytebuffer.get();
            bytebuffer.getShort();
            bytebuffer.getShort();
            bytebuffer.get();
            bytebuffer.get();
            bytebuffer.get();
            byte byte1 = bytebuffer.get();
            bytebuffer.getShort();
            inetaddress3 = readIpAddress(bytebuffer);
            readIpAddress(bytebuffer);
            if(byte1 != 17) {
                obj = null;
                continue; /* Loop/switch isn't completed */
            }
            short word0 = bytebuffer.getShort();
            bytebuffer.getShort();
            bytebuffer.getShort();
            bytebuffer.getShort();
            if(word0 != 67 && word0 != 68) {
                obj = null;
                continue; /* Loop/switch isn't completed */
            }
        }
        bytebuffer.get();
        bytebuffer.get();
        byte byte2 = bytebuffer.get();
        bytebuffer.get();
        j = bytebuffer.getInt();
        bytebuffer.getShort();
        byte abyte1[];
        if((0x8000 & bytebuffer.getShort()) != 0)
            flag = true;
        else
            flag = false;
        abyte1 = new byte[4];
        try {
            bytebuffer.get(abyte1);
            inetaddress6 = InetAddress.getByAddress(abyte1);
            bytebuffer.get(abyte1);
            inetaddress7 = InetAddress.getByAddress(abyte1);
            bytebuffer.get(abyte1);
            inetaddress8 = InetAddress.getByAddress(abyte1);
            bytebuffer.get(abyte1);
            inetaddress9 = InetAddress.getByAddress(abyte1);
        }
        catch(UnknownHostException unknownhostexception) {
            obj = null;
            continue; /* Loop/switch isn't completed */
        }
        abyte2 = new byte[byte2];
        bytebuffer.get(abyte2);
        bytebuffer.position(128 + (64 + (bytebuffer.position() + (16 - byte2))));
        if(bytebuffer.getInt() != 0x63825363) {
            obj = null;
            continue; /* Loop/switch isn't completed */
        }
        flag1 = true;
_L22:
        byte byte3;
        byte byte4;
        int k;
        if(bytebuffer.position() >= bytebuffer.limit() || !flag1)
            break; /* Loop/switch isn't completed */
        byte3 = bytebuffer.get();
        if(byte3 == -1) {
            flag1 = false;
            continue; /* Loop/switch isn't completed */
        }
        byte4 = bytebuffer.get();
        k = 0;
        byte3;
        JVM INSTR lookupswitch 14: default 560
    //                   1: 590
    //                   3: 612
    //                   6: 623
    //                   12: 653
    //                   15: 668
    //                   28: 683
    //                   50: 695
    //                   51: 707
    //                   53: 722
    //                   54: 734
    //                   55: 746
    //                   56: 766
    //                   60: 781
    //                   61: 795;
           goto _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18
_L4:
        for(int l = 0; l < byte4; l++) {
            k++;
            bytebuffer.get();
        }

        break; /* Loop/switch isn't completed */
_L5:
        inetaddress2 = readIpAddress(bytebuffer);
        k = 4;
_L20:
        if(k != byte4) {
            obj = null;
            continue; /* Loop/switch isn't completed */
        }
        break; /* Loop/switch isn't completed */
_L6:
        inetaddress = readIpAddress(bytebuffer);
        k = 4;
        continue; /* Loop/switch isn't completed */
_L7:
        k = 0;
        while(k < byte4)  {
            arraylist.add(readIpAddress(bytebuffer));
            k += 4;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        k = byte4;
        s1 = readAsciiString(bytebuffer, byte4);
        continue; /* Loop/switch isn't completed */
_L9:
        k = byte4;
        s2 = readAsciiString(bytebuffer, byte4);
        continue; /* Loop/switch isn't completed */
_L10:
        inetaddress4 = readIpAddress(bytebuffer);
        k = 4;
        continue; /* Loop/switch isn't completed */
_L11:
        inetaddress5 = readIpAddress(bytebuffer);
        k = 4;
        continue; /* Loop/switch isn't completed */
_L12:
        integer = Integer.valueOf(bytebuffer.getInt());
        k = 4;
        continue; /* Loop/switch isn't completed */
_L13:
        byte0 = bytebuffer.get();
        k = 1;
        continue; /* Loop/switch isn't completed */
_L14:
        inetaddress1 = readIpAddress(bytebuffer);
        k = 4;
        continue; /* Loop/switch isn't completed */
_L15:
        abyte0 = new byte[byte4];
        bytebuffer.get(abyte0);
        k = byte4;
        continue; /* Loop/switch isn't completed */
_L16:
        k = byte4;
        s = readAsciiString(bytebuffer, byte4);
        continue; /* Loop/switch isn't completed */
_L17:
        k = byte4;
        readAsciiString(bytebuffer, byte4);
        continue; /* Loop/switch isn't completed */
_L18:
        bytebuffer.get(new byte[byte4]);
        k = byte4;
        if(true) goto _L20; else goto _L19
_L19:
        if(true) goto _L22; else goto _L21
_L21:
        byte0;
        JVM INSTR tableswitch -1 8: default 868
    //                   -1 901
    //                   0 868
    //                   1 907
    //                   2 1000
    //                   3 1022
    //                   4 1042
    //                   5 1066
    //                   6 1088
    //                   7 868
    //                   8 1112;
           goto _L23 _L24 _L23 _L25 _L26 _L27 _L28 _L29 _L30 _L23 _L31
_L31:
        break MISSING_BLOCK_LABEL_1112;
_L26:
        break; /* Loop/switch isn't completed */
_L23:
        System.out.println((new StringBuilder()).append("Unimplemented type: ").append(byte0).toString());
        obj = null;
        continue; /* Loop/switch isn't completed */
_L24:
        obj = null;
        continue; /* Loop/switch isn't completed */
_L25:
        obj = new DhcpDiscoverPacket(j, abyte2, flag);
_L34:
        obj.mBroadcastAddress = inetaddress4;
        obj.mDnsServers = arraylist;
        obj.mDomainName = s2;
        obj.mGateway = inetaddress;
        obj.mHostName = s1;
        obj.mLeaseTime = integer;
        obj.mMessage = s;
        obj.mRequestedIp = inetaddress5;
        obj.mRequestedParams = abyte0;
        obj.mServerIdentifier = inetaddress1;
        obj.mSubnetMask = inetaddress2;
        if(true) goto _L33; else goto _L32
_L32:
        obj = new DhcpOfferPacket(j, flag, inetaddress3, inetaddress7, abyte2);
          goto _L34
_L27:
        obj = new DhcpRequestPacket(j, inetaddress6, abyte2, flag);
          goto _L34
_L28:
        obj = new DhcpDeclinePacket(j, inetaddress6, inetaddress7, inetaddress8, inetaddress9, abyte2);
          goto _L34
_L29:
        obj = new DhcpAckPacket(j, flag, inetaddress3, inetaddress7, abyte2);
          goto _L34
_L30:
        obj = new DhcpNakPacket(j, inetaddress6, inetaddress7, inetaddress8, inetaddress9, abyte2);
          goto _L34
        obj = new DhcpInformPacket(j, inetaddress6, inetaddress7, inetaddress8, inetaddress9, abyte2);
          goto _L34
    }

    public static DhcpPacket decodeFullPacket(byte abyte0[], int i) {
        return decodeFullPacket(ByteBuffer.wrap(abyte0).order(ByteOrder.BIG_ENDIAN), i);
    }

    private int intAbs(short word0) {
        int i;
        if(word0 < 0)
            i = word0 + 0x10000;
        else
            i = word0;
        return i;
    }

    public static String macToString(byte abyte0[]) {
        String s = "";
        for(int i = 0; i < abyte0.length; i++) {
            String s1 = (new StringBuilder()).append("0").append(Integer.toHexString(abyte0[i])).toString();
            s = (new StringBuilder()).append(s).append(s1.substring(-2 + s1.length())).toString();
            if(i != -1 + abyte0.length)
                s = (new StringBuilder()).append(s).append(":").toString();
        }

        return s;
    }

    private static String readAsciiString(ByteBuffer bytebuffer, int i) {
        byte abyte0[] = new byte[i];
        bytebuffer.get(abyte0);
        return new String(abyte0, 0, abyte0.length, Charsets.US_ASCII);
    }

    private static InetAddress readIpAddress(ByteBuffer bytebuffer) {
        byte abyte0[];
        abyte0 = new byte[4];
        bytebuffer.get(abyte0);
        InetAddress inetaddress1 = InetAddress.getByAddress(abyte0);
        InetAddress inetaddress = inetaddress1;
_L2:
        return inetaddress;
        UnknownHostException unknownhostexception;
        unknownhostexception;
        inetaddress = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    protected void addTlv(ByteBuffer bytebuffer, byte byte0, byte byte1) {
        bytebuffer.put(byte0);
        bytebuffer.put((byte)1);
        bytebuffer.put(byte1);
    }

    protected void addTlv(ByteBuffer bytebuffer, byte byte0, Integer integer) {
        if(integer != null) {
            bytebuffer.put(byte0);
            bytebuffer.put((byte)4);
            bytebuffer.putInt(integer.intValue());
        }
    }

    protected void addTlv(ByteBuffer bytebuffer, byte byte0, String s) {
        if(s != null) {
            bytebuffer.put(byte0);
            bytebuffer.put((byte)s.length());
            for(int i = 0; i < s.length(); i++)
                bytebuffer.put((byte)s.charAt(i));

        }
    }

    protected void addTlv(ByteBuffer bytebuffer, byte byte0, InetAddress inetaddress) {
        if(inetaddress != null)
            addTlv(bytebuffer, byte0, inetaddress.getAddress());
    }

    protected void addTlv(ByteBuffer bytebuffer, byte byte0, List list) {
        if(list != null && list.size() > 0) {
            bytebuffer.put(byte0);
            bytebuffer.put((byte)(4 * list.size()));
            for(Iterator iterator = list.iterator(); iterator.hasNext(); bytebuffer.put(((InetAddress)iterator.next()).getAddress()));
        }
    }

    protected void addTlv(ByteBuffer bytebuffer, byte byte0, byte abyte0[]) {
        if(abyte0 != null) {
            bytebuffer.put(byte0);
            bytebuffer.put((byte)abyte0.length);
            bytebuffer.put(abyte0);
        }
    }

    protected void addTlvEnd(ByteBuffer bytebuffer) {
        bytebuffer.put((byte)-1);
    }

    public abstract ByteBuffer buildPacket(int i, short word0, short word1);

    public abstract void doNextOp(DhcpStateMachine dhcpstatemachine);

    protected void fillInPacket(int i, InetAddress inetaddress, InetAddress inetaddress1, short word0, short word1, ByteBuffer bytebuffer, byte byte0, 
            boolean flag) {
        byte abyte0[] = inetaddress.getAddress();
        byte abyte1[] = inetaddress1.getAddress();
        int j = 0;
        int k = 0;
        int l = 0;
        int i1 = 0;
        int j1 = 0;
        int k1 = 0;
        bytebuffer.clear();
        bytebuffer.order(ByteOrder.BIG_ENDIAN);
        if(i == 1) {
            bytebuffer.put((byte)69);
            bytebuffer.put((byte)16);
            j = bytebuffer.position();
            bytebuffer.putShort((short)0);
            bytebuffer.putShort((short)0);
            bytebuffer.putShort((short)16384);
            bytebuffer.put((byte)64);
            bytebuffer.put((byte)17);
            k = bytebuffer.position();
            bytebuffer.putShort((short)0);
            bytebuffer.put(abyte1);
            bytebuffer.put(abyte0);
            l = bytebuffer.position();
            i1 = bytebuffer.position();
            bytebuffer.putShort(word1);
            bytebuffer.putShort(word0);
            j1 = bytebuffer.position();
            bytebuffer.putShort((short)0);
            k1 = bytebuffer.position();
            bytebuffer.putShort((short)0);
        }
        bytebuffer.put(byte0);
        bytebuffer.put((byte)1);
        bytebuffer.put((byte)mClientMac.length);
        bytebuffer.put((byte)0);
        bytebuffer.putInt(mTransId);
        bytebuffer.putShort((short)0);
        if(flag)
            bytebuffer.putShort((short)-32768);
        else
            bytebuffer.putShort((short)0);
        bytebuffer.put(mClientIp.getAddress());
        bytebuffer.put(mYourIp.getAddress());
        bytebuffer.put(mNextIp.getAddress());
        bytebuffer.put(mRelayIp.getAddress());
        bytebuffer.put(mClientMac);
        bytebuffer.position(128 + (64 + (bytebuffer.position() + (16 - mClientMac.length))));
        bytebuffer.putInt(0x63825363);
        finishPacket(bytebuffer);
        if((1 & bytebuffer.position()) == 1)
            bytebuffer.put((byte)0);
        if(i == 1) {
            short word2 = (short)(bytebuffer.position() - i1);
            bytebuffer.putShort(j1, word2);
            bytebuffer.putShort(k1, (short)checksum(bytebuffer, word2 + (17 + (0 + intAbs(bytebuffer.getShort(k + 2)) + intAbs(bytebuffer.getShort(k + 4)) + intAbs(bytebuffer.getShort(k + 6)) + intAbs(bytebuffer.getShort(k + 8)))), i1, bytebuffer.position()));
            bytebuffer.putShort(j, (short)bytebuffer.position());
            bytebuffer.putShort(k, (short)checksum(bytebuffer, 0, 0, l));
        }
    }

    abstract void finishPacket(ByteBuffer bytebuffer);

    public int getTransactionId() {
        return mTransId;
    }

    public String toString() {
        return macToString(mClientMac);
    }

    protected static final byte CLIENT_ID_ETHER = 1;
    protected static final byte DHCP_BOOTREPLY = 2;
    protected static final byte DHCP_BOOTREQUEST = 1;
    protected static final byte DHCP_BROADCAST_ADDRESS = 28;
    static final short DHCP_CLIENT = 68;
    protected static final byte DHCP_CLIENT_IDENTIFIER = 61;
    protected static final byte DHCP_DNS_SERVER = 6;
    protected static final byte DHCP_DOMAIN_NAME = 15;
    protected static final byte DHCP_HOST_NAME = 12;
    protected static final byte DHCP_LEASE_TIME = 51;
    protected static final byte DHCP_MESSAGE = 56;
    protected static final byte DHCP_MESSAGE_TYPE = 53;
    protected static final byte DHCP_MESSAGE_TYPE_ACK = 5;
    protected static final byte DHCP_MESSAGE_TYPE_DECLINE = 4;
    protected static final byte DHCP_MESSAGE_TYPE_DISCOVER = 1;
    protected static final byte DHCP_MESSAGE_TYPE_INFORM = 8;
    protected static final byte DHCP_MESSAGE_TYPE_NAK = 6;
    protected static final byte DHCP_MESSAGE_TYPE_OFFER = 2;
    protected static final byte DHCP_MESSAGE_TYPE_REQUEST = 3;
    protected static final byte DHCP_PARAMETER_LIST = 55;
    protected static final byte DHCP_RENEWAL_TIME = 58;
    protected static final byte DHCP_REQUESTED_IP = 50;
    protected static final byte DHCP_ROUTER = 3;
    static final short DHCP_SERVER = 67;
    protected static final byte DHCP_SERVER_IDENTIFIER = 54;
    protected static final byte DHCP_SUBNET_MASK = 1;
    protected static final byte DHCP_VENDOR_CLASS_ID = 60;
    public static final int ENCAP_BOOTP = 2;
    public static final int ENCAP_L2 = 0;
    public static final int ENCAP_L3 = 1;
    private static final short IP_FLAGS_OFFSET = 16384;
    private static final byte IP_TOS_LOWDELAY = 16;
    private static final byte IP_TTL = 64;
    private static final byte IP_TYPE_UDP = 17;
    private static final byte IP_VERSION_HEADER_LEN = 69;
    protected static final int MAX_LENGTH = 1500;
    protected static final String TAG = "DhcpPacket";
    protected boolean mBroadcast;
    protected InetAddress mBroadcastAddress;
    protected final InetAddress mClientIp;
    protected final byte mClientMac[];
    protected List mDnsServers;
    protected String mDomainName;
    protected InetAddress mGateway;
    protected String mHostName;
    protected Integer mLeaseTime;
    protected String mMessage;
    private final InetAddress mNextIp;
    private final InetAddress mRelayIp;
    protected InetAddress mRequestedIp;
    protected byte mRequestedParams[];
    protected InetAddress mServerIdentifier;
    protected InetAddress mSubnetMask;
    protected final int mTransId;
    protected final InetAddress mYourIp;
}

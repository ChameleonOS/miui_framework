// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.content.Context;
import android.content.res.Resources;
import android.os.*;
import android.util.Log;
import java.io.IOException;
import java.net.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package android.net:
//            ConnectivityManager, NetworkUtils, LinkProperties

public final class DnsPinger extends Handler {
    private class DnsArg {

        InetAddress dns;
        int seq;
        final DnsPinger this$0;

        DnsArg(InetAddress inetaddress, int i) {
            this$0 = DnsPinger.this;
            super();
            dns = inetaddress;
            seq = i;
        }
    }

    private class ActivePing {

        int internalId;
        short packetId;
        Integer result;
        DatagramSocket socket;
        long start;
        final DnsPinger this$0;
        int timeout;

        private ActivePing() {
            this$0 = DnsPinger.this;
            super();
            start = SystemClock.elapsedRealtime();
        }

    }


    public DnsPinger(Context context, String s, Looper looper, Handler handler, int i) {
        super(looper);
        mConnectivityManager = null;
        mCurrentToken = new AtomicInteger();
        mActivePings = new ArrayList();
        TAG = s;
        mContext = context;
        mTarget = handler;
        mConnectionType = i;
        if(!ConnectivityManager.isNetworkTypeValid(i)) {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid connectionType in constructor: ").append(i).toString());
        } else {
            mDefaultDns = new ArrayList();
            mDefaultDns.add(getDefaultDns());
            mEventCounter = 0;
            return;
        }
    }

    private LinkProperties getCurrentLinkProperties() {
        if(mConnectivityManager == null)
            mConnectivityManager = (ConnectivityManager)mContext.getSystemService("connectivity");
        return mConnectivityManager.getLinkProperties(mConnectionType);
    }

    private InetAddress getDefaultDns() {
        String s;
        s = android.provider.Settings.Secure.getString(mContext.getContentResolver(), "default_dns_server");
        if(s == null || s.length() == 0)
            s = mContext.getResources().getString(0x104001f);
        InetAddress inetaddress1 = NetworkUtils.numericToInetAddress(s);
        InetAddress inetaddress = inetaddress1;
_L2:
        return inetaddress;
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        loge("getDefaultDns::malformed default dns address");
        inetaddress = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private void log(String s) {
        Log.d(TAG, s);
    }

    private void loge(String s) {
        Log.e(TAG, s);
    }

    private void sendResponse(int i, int j, int k) {
        mTarget.sendMessage(obtainMessage(0x50000, i, k));
    }

    public void cancelPings() {
        mCurrentToken.incrementAndGet();
        obtainMessage(0x50003).sendToTarget();
    }

    public List getDnsList() {
        LinkProperties linkproperties = getCurrentLinkProperties();
        ArrayList arraylist;
        if(linkproperties == null) {
            loge((new StringBuilder()).append("getCurLinkProperties:: LP for type").append(mConnectionType).append(" is null!").toString());
            arraylist = mDefaultDns;
        } else {
            Collection collection = linkproperties.getDnses();
            if(collection == null || collection.size() == 0) {
                loge("getDns::LinkProps has null dns - returning default");
                arraylist = mDefaultDns;
            } else {
                arraylist = new ArrayList(collection);
            }
        }
        return arraylist;
    }

    public void handleMessage(Message message) {
        message.what;
        JVM INSTR tableswitch 327681 327683: default 32
    //                   327681 33
    //                   327682 298
    //                   327683 604;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        DnsArg dnsarg;
        dnsarg = (DnsArg)message.obj;
        if(dnsarg.seq != mCurrentToken.get())
            continue; /* Loop/switch isn't completed */
        ActivePing activeping2;
        InetAddress inetaddress;
        activeping2 = new ActivePing();
        inetaddress = dnsarg.dns;
        activeping2.internalId = message.arg1;
        activeping2.timeout = message.arg2;
        activeping2.socket = new DatagramSocket();
        activeping2.socket.setSoTimeout(1);
        IOException ioexception;
        byte abyte1[];
        DatagramPacket datagrampacket1;
        try {
            activeping2.socket.setNetworkInterface(NetworkInterface.getByName(getCurrentLinkProperties().getInterfaceName()));
        }
        catch(Exception exception1) {
            try {
                loge((new StringBuilder()).append("sendDnsPing::Error binding to socket ").append(exception1).toString());
            }
            // Misplaced declaration of an exception variable
            catch(IOException ioexception) {
                sendResponse(message.arg1, -9999, -2);
                continue; /* Loop/switch isn't completed */
            }
        }
        activeping2.packetId = (short)sRandom.nextInt();
        abyte1 = (byte[])mDnsQuery.clone();
        abyte1[0] = (byte)(activeping2.packetId >> 8);
        abyte1[1] = (byte)activeping2.packetId;
        datagrampacket1 = new DatagramPacket(abyte1, abyte1.length, inetaddress, 53);
        activeping2.socket.send(datagrampacket1);
        mActivePings.add(activeping2);
        mEventCounter = 1 + mEventCounter;
        sendMessageDelayed(obtainMessage(0x50002, mEventCounter, 0), 200L);
        continue; /* Loop/switch isn't completed */
_L3:
        if(message.arg1 == mEventCounter) {
            Iterator iterator1 = mActivePings.iterator();
            do {
                if(!iterator1.hasNext())
                    break;
                ActivePing activeping1 = (ActivePing)iterator1.next();
                try {
                    byte abyte0[] = new byte[2];
                    DatagramPacket datagrampacket = new DatagramPacket(abyte0, 2);
                    activeping1.socket.receive(datagrampacket);
                    if(abyte0[0] == (byte)(activeping1.packetId >> 8) && abyte0[1] == (byte)activeping1.packetId)
                        activeping1.result = Integer.valueOf((int)(SystemClock.elapsedRealtime() - activeping1.start));
                }
                catch(SocketTimeoutException sockettimeoutexception) { }
                catch(Exception exception) {
                    activeping1.result = Integer.valueOf(-2);
                }
            } while(true);
            Iterator iterator2 = mActivePings.iterator();
            do {
                if(!iterator2.hasNext())
                    break;
                ActivePing activeping = (ActivePing)iterator2.next();
                if(activeping.result != null) {
                    sendResponse(activeping.internalId, activeping.packetId, activeping.result.intValue());
                    activeping.socket.close();
                    iterator2.remove();
                } else
                if(SystemClock.elapsedRealtime() > activeping.start + (long)activeping.timeout) {
                    sendResponse(activeping.internalId, activeping.packetId, -1);
                    activeping.socket.close();
                    iterator2.remove();
                }
            } while(true);
            if(!mActivePings.isEmpty())
                sendMessageDelayed(obtainMessage(0x50002, mEventCounter, 0), 200L);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        for(Iterator iterator = mActivePings.iterator(); iterator.hasNext(); ((ActivePing)iterator.next()).socket.close());
        mActivePings.clear();
        if(true) goto _L1; else goto _L5
_L5:
    }

    public int pingDnsAsync(InetAddress inetaddress, int i, int j) {
        int k = sCounter.incrementAndGet();
        sendMessageDelayed(obtainMessage(0x50001, k, i, new DnsArg(inetaddress, mCurrentToken.get())), j);
        return k;
    }

    private static final int ACTION_CANCEL_ALL_PINGS = 0x50003;
    private static final int ACTION_LISTEN_FOR_RESPONSE = 0x50002;
    private static final int ACTION_PING_DNS = 0x50001;
    private static final int BASE = 0x50000;
    private static final boolean DBG = false;
    public static final int DNS_PING_RESULT = 0x50000;
    private static final int DNS_PORT = 53;
    private static final int RECEIVE_POLL_INTERVAL_MS = 200;
    public static final int SOCKET_EXCEPTION = -2;
    private static final int SOCKET_TIMEOUT_MS = 1;
    public static final int TIMEOUT = -1;
    private static final byte mDnsQuery[];
    private static final AtomicInteger sCounter = new AtomicInteger();
    private static final Random sRandom = new Random();
    private String TAG;
    private List mActivePings;
    private final int mConnectionType;
    private ConnectivityManager mConnectivityManager;
    private final Context mContext;
    private AtomicInteger mCurrentToken;
    private final ArrayList mDefaultDns;
    private int mEventCounter;
    private final Handler mTarget;

    static  {
        byte abyte0[] = new byte[32];
        abyte0[0] = 0;
        abyte0[1] = 0;
        abyte0[2] = 1;
        abyte0[3] = 0;
        abyte0[4] = 0;
        abyte0[5] = 1;
        abyte0[6] = 0;
        abyte0[7] = 0;
        abyte0[8] = 0;
        abyte0[9] = 0;
        abyte0[10] = 0;
        abyte0[11] = 0;
        abyte0[12] = 3;
        abyte0[13] = 119;
        abyte0[14] = 119;
        abyte0[15] = 119;
        abyte0[16] = 6;
        abyte0[17] = 103;
        abyte0[18] = 111;
        abyte0[19] = 111;
        abyte0[20] = 103;
        abyte0[21] = 108;
        abyte0[22] = 101;
        abyte0[23] = 3;
        abyte0[24] = 99;
        abyte0[25] = 111;
        abyte0[26] = 109;
        abyte0[27] = 0;
        abyte0[28] = 0;
        abyte0[29] = 1;
        abyte0[30] = 0;
        abyte0[31] = 1;
        mDnsQuery = abyte0;
    }
}

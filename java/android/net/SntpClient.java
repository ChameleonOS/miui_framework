// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.os.SystemClock;
import java.net.*;

public class SntpClient {

    public SntpClient() {
    }

    private long read32(byte abyte0[], int i) {
        byte byte0 = abyte0[i];
        byte byte1 = abyte0[i + 1];
        byte byte2 = abyte0[i + 2];
        byte byte3 = abyte0[i + 3];
        int j;
        int k;
        int l;
        int i1;
        if((byte0 & 0x80) == 128)
            j = 128 + (byte0 & 0x7f);
        else
            j = byte0;
        if((byte1 & 0x80) == 128)
            k = 128 + (byte1 & 0x7f);
        else
            k = byte1;
        if((byte2 & 0x80) == 128)
            l = 128 + (byte2 & 0x7f);
        else
            l = byte2;
        if((byte3 & 0x80) == 128)
            i1 = 128 + (byte3 & 0x7f);
        else
            i1 = byte3;
        return ((long)j << 24) + ((long)k << 16) + ((long)l << 8) + (long)i1;
    }

    private long readTimeStamp(byte abyte0[], int i) {
        long l = read32(abyte0, i);
        long l1 = read32(abyte0, i + 4);
        return 1000L * (l - 0x83aa7e80L) + (1000L * l1) / 0x100000000L;
    }

    private void writeTimeStamp(byte abyte0[], int i, long l) {
        long l1 = l / 1000L;
        long l2 = l - 1000L * l1;
        long l3 = l1 + 0x83aa7e80L;
        int j = i + 1;
        abyte0[i] = (byte)(int)(l3 >> 24);
        int k = j + 1;
        abyte0[j] = (byte)(int)(l3 >> 16);
        int i1 = k + 1;
        abyte0[k] = (byte)(int)(l3 >> 8);
        int j1 = i1 + 1;
        abyte0[i1] = (byte)(int)(l3 >> 0);
        long l4 = (0x100000000L * l2) / 1000L;
        int k1 = j1 + 1;
        abyte0[j1] = (byte)(int)(l4 >> 24);
        int i2 = k1 + 1;
        abyte0[k1] = (byte)(int)(l4 >> 16);
        int j2 = i2 + 1;
        abyte0[i2] = (byte)(int)(l4 >> 8);
        int _tmp = j2 + 1;
        abyte0[j2] = (byte)(int)(255D * Math.random());
    }

    public long getNtpTime() {
        return mNtpTime;
    }

    public long getNtpTimeReference() {
        return mNtpTimeReference;
    }

    public long getRoundTripTime() {
        return mRoundTripTime;
    }

    public boolean requestTime(String s, int i) {
        DatagramSocket datagramsocket = null;
        DatagramSocket datagramsocket1 = new DatagramSocket();
        datagramsocket1.setSoTimeout(i);
        InetAddress inetaddress = InetAddress.getByName(s);
        byte abyte0[] = new byte[48];
        DatagramPacket datagrampacket = new DatagramPacket(abyte0, abyte0.length, inetaddress, 123);
        abyte0[0] = 27;
        long l = System.currentTimeMillis();
        long l1 = SystemClock.elapsedRealtime();
        writeTimeStamp(abyte0, 40, l);
        datagramsocket1.send(datagrampacket);
        DatagramPacket datagrampacket1 = new DatagramPacket(abyte0, abyte0.length);
        datagramsocket1.receive(datagrampacket1);
        long l2 = SystemClock.elapsedRealtime();
        long l3 = l + (l2 - l1);
        long l4 = readTimeStamp(abyte0, 24);
        long l5 = readTimeStamp(abyte0, 32);
        long l6 = readTimeStamp(abyte0, 40);
        long l7 = l2 - l1 - (l6 - l5);
        mNtpTime = l3 + ((l5 - l4) + (l6 - l3)) / 2L;
        mNtpTimeReference = l2;
        mRoundTripTime = l7;
        boolean flag;
        if(datagramsocket1 != null)
            datagramsocket1.close();
        flag = true;
_L2:
        return flag;
        Exception exception2;
        exception2;
_L5:
        flag = false;
        if(datagramsocket != null)
            datagramsocket.close();
        if(true) goto _L2; else goto _L1
_L1:
        Exception exception1;
        exception1;
_L4:
        if(datagramsocket != null)
            datagramsocket.close();
        throw exception1;
        exception1;
        datagramsocket = datagramsocket1;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        datagramsocket = datagramsocket1;
          goto _L5
    }

    private static final int NTP_MODE_CLIENT = 3;
    private static final int NTP_PACKET_SIZE = 48;
    private static final int NTP_PORT = 123;
    private static final int NTP_VERSION = 3;
    private static final long OFFSET_1900_TO_1970 = 0x83aa7e80L;
    private static final int ORIGINATE_TIME_OFFSET = 24;
    private static final int RECEIVE_TIME_OFFSET = 32;
    private static final int REFERENCE_TIME_OFFSET = 16;
    private static final String TAG = "SntpClient";
    private static final int TRANSMIT_TIME_OFFSET = 40;
    private long mNtpTime;
    private long mNtpTimeReference;
    private long mRoundTripTime;
}

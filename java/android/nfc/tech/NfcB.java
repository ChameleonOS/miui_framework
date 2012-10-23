// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.nfc.tech;

import android.nfc.Tag;
import android.os.Bundle;
import android.os.RemoteException;
import java.io.IOException;

// Referenced classes of package android.nfc.tech:
//            BasicTagTechnology

public final class NfcB extends BasicTagTechnology {

    public NfcB(Tag tag) throws RemoteException {
        super(tag, 2);
        Bundle bundle = tag.getTechExtras(2);
        mAppData = bundle.getByteArray("appdata");
        mProtInfo = bundle.getByteArray("protinfo");
    }

    public static NfcB get(Tag tag) {
        NfcB nfcb = null;
        if(tag.hasTech(2)) goto _L2; else goto _L1
_L1:
        return nfcb;
_L2:
        NfcB nfcb1 = new NfcB(tag);
        nfcb = nfcb1;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public volatile void close() throws IOException {
        super.close();
    }

    public volatile void connect() throws IOException {
        super.connect();
    }

    public byte[] getApplicationData() {
        return mAppData;
    }

    public int getMaxTransceiveLength() {
        return getMaxTransceiveLengthInternal();
    }

    public byte[] getProtocolInfo() {
        return mProtInfo;
    }

    public volatile Tag getTag() {
        return super.getTag();
    }

    public volatile boolean isConnected() {
        return super.isConnected();
    }

    public volatile void reconnect() throws IOException {
        super.reconnect();
    }

    public byte[] transceive(byte abyte0[]) throws IOException {
        return transceive(abyte0, true);
    }

    public static final String EXTRA_APPDATA = "appdata";
    public static final String EXTRA_PROTINFO = "protinfo";
    private byte mAppData[];
    private byte mProtInfo[];
}

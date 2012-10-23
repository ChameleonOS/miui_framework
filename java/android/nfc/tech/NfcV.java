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

public final class NfcV extends BasicTagTechnology {

    public NfcV(Tag tag) throws RemoteException {
        super(tag, 5);
        Bundle bundle = tag.getTechExtras(5);
        mRespFlags = bundle.getByte("respflags");
        mDsfId = bundle.getByte("dsfid");
    }

    public static NfcV get(Tag tag) {
        NfcV nfcv = null;
        if(tag.hasTech(5)) goto _L2; else goto _L1
_L1:
        return nfcv;
_L2:
        NfcV nfcv1 = new NfcV(tag);
        nfcv = nfcv1;
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

    public byte getDsfId() {
        return mDsfId;
    }

    public int getMaxTransceiveLength() {
        return getMaxTransceiveLengthInternal();
    }

    public byte getResponseFlags() {
        return mRespFlags;
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

    public static final String EXTRA_DSFID = "dsfid";
    public static final String EXTRA_RESP_FLAGS = "respflags";
    private byte mDsfId;
    private byte mRespFlags;
}

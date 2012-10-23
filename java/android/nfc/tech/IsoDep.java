// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.nfc.tech;

import android.nfc.INfcTag;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import java.io.IOException;

// Referenced classes of package android.nfc.tech:
//            BasicTagTechnology

public final class IsoDep extends BasicTagTechnology {

    public IsoDep(Tag tag) throws RemoteException {
        super(tag, 3);
        mHiLayerResponse = null;
        mHistBytes = null;
        Bundle bundle = tag.getTechExtras(3);
        if(bundle != null) {
            mHiLayerResponse = bundle.getByteArray("hiresp");
            mHistBytes = bundle.getByteArray("histbytes");
        }
    }

    public static IsoDep get(Tag tag) {
        IsoDep isodep = null;
        if(tag.hasTech(3)) goto _L2; else goto _L1
_L1:
        return isodep;
_L2:
        IsoDep isodep1 = new IsoDep(tag);
        isodep = isodep1;
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

    public byte[] getHiLayerResponse() {
        return mHiLayerResponse;
    }

    public byte[] getHistoricalBytes() {
        return mHistBytes;
    }

    public int getMaxTransceiveLength() {
        return getMaxTransceiveLengthInternal();
    }

    public volatile Tag getTag() {
        return super.getTag();
    }

    public int getTimeout() {
        int j = super.mTag.getTagService().getTimeout(3);
        int i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        Log.e("NFC", "NFC service dead", remoteexception);
        i = 0;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public volatile boolean isConnected() {
        return super.isConnected();
    }

    public boolean isExtendedLengthApduSupported() {
        boolean flag1 = super.mTag.getTagService().getExtendedLengthApdusSupported();
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("NFC", "NFC service dead", remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public volatile void reconnect() throws IOException {
        super.reconnect();
    }

    public void setTimeout(int i) {
        try {
            if(super.mTag.getTagService().setTimeout(3, i) != 0)
                throw new IllegalArgumentException("The supplied timeout is not valid");
        }
        catch(RemoteException remoteexception) {
            Log.e("NFC", "NFC service dead", remoteexception);
        }
    }

    public byte[] transceive(byte abyte0[]) throws IOException {
        return transceive(abyte0, true);
    }

    public static final String EXTRA_HIST_BYTES = "histbytes";
    public static final String EXTRA_HI_LAYER_RESP = "hiresp";
    private static final String TAG = "NFC";
    private byte mHiLayerResponse[];
    private byte mHistBytes[];
}

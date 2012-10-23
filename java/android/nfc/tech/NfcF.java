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

public final class NfcF extends BasicTagTechnology {

    public NfcF(Tag tag) throws RemoteException {
        super(tag, 4);
        mSystemCode = null;
        mManufacturer = null;
        Bundle bundle = tag.getTechExtras(4);
        if(bundle != null) {
            mSystemCode = bundle.getByteArray("systemcode");
            mManufacturer = bundle.getByteArray("pmm");
        }
    }

    public static NfcF get(Tag tag) {
        NfcF nfcf = null;
        if(tag.hasTech(4)) goto _L2; else goto _L1
_L1:
        return nfcf;
_L2:
        NfcF nfcf1 = new NfcF(tag);
        nfcf = nfcf1;
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

    public byte[] getManufacturer() {
        return mManufacturer;
    }

    public int getMaxTransceiveLength() {
        return getMaxTransceiveLengthInternal();
    }

    public byte[] getSystemCode() {
        return mSystemCode;
    }

    public volatile Tag getTag() {
        return super.getTag();
    }

    public int getTimeout() {
        int j = super.mTag.getTagService().getTimeout(4);
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

    public volatile void reconnect() throws IOException {
        super.reconnect();
    }

    public void setTimeout(int i) {
        try {
            if(super.mTag.getTagService().setTimeout(4, i) != 0)
                throw new IllegalArgumentException("The supplied timeout is not valid");
        }
        catch(RemoteException remoteexception) {
            Log.e("NFC", "NFC service dead", remoteexception);
        }
    }

    public byte[] transceive(byte abyte0[]) throws IOException {
        return transceive(abyte0, true);
    }

    public static final String EXTRA_PMM = "pmm";
    public static final String EXTRA_SC = "systemcode";
    private static final String TAG = "NFC";
    private byte mManufacturer[];
    private byte mSystemCode[];
}

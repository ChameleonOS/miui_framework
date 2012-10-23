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

public final class NfcA extends BasicTagTechnology {

    public NfcA(Tag tag) throws RemoteException {
        super(tag, 1);
        Bundle bundle = tag.getTechExtras(1);
        mSak = bundle.getShort("sak");
        mAtqa = bundle.getByteArray("atqa");
    }

    public static NfcA get(Tag tag) {
        NfcA nfca = null;
        if(tag.hasTech(1)) goto _L2; else goto _L1
_L1:
        return nfca;
_L2:
        NfcA nfca1 = new NfcA(tag);
        nfca = nfca1;
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

    public byte[] getAtqa() {
        return mAtqa;
    }

    public int getMaxTransceiveLength() {
        return getMaxTransceiveLengthInternal();
    }

    public short getSak() {
        return mSak;
    }

    public volatile Tag getTag() {
        return super.getTag();
    }

    public int getTimeout() {
        int j = super.mTag.getTagService().getTimeout(1);
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
            if(super.mTag.getTagService().setTimeout(1, i) != 0)
                throw new IllegalArgumentException("The supplied timeout is not valid");
        }
        catch(RemoteException remoteexception) {
            Log.e("NFC", "NFC service dead", remoteexception);
        }
    }

    public byte[] transceive(byte abyte0[]) throws IOException {
        return transceive(abyte0, true);
    }

    public static final String EXTRA_ATQA = "atqa";
    public static final String EXTRA_SAK = "sak";
    private static final String TAG = "NFC";
    private byte mAtqa[];
    private short mSak;
}

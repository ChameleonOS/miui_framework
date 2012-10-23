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
//            BasicTagTechnology, NfcA

public final class MifareUltralight extends BasicTagTechnology {

    public MifareUltralight(Tag tag) throws RemoteException {
        super(tag, 9);
        NfcA nfca = NfcA.get(tag);
        mType = -1;
        if(nfca.getSak() == 0 && tag.getId()[0] == 4)
            if(tag.getTechExtras(9).getBoolean("isulc"))
                mType = 2;
            else
                mType = 1;
    }

    public static MifareUltralight get(Tag tag) {
        MifareUltralight mifareultralight = null;
        if(tag.hasTech(9)) goto _L2; else goto _L1
_L1:
        return mifareultralight;
_L2:
        MifareUltralight mifareultralight1 = new MifareUltralight(tag);
        mifareultralight = mifareultralight1;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L1; else goto _L3
_L3:
    }

    private static void validatePageIndex(int i) {
        if(i < 0 || i >= 256)
            throw new IndexOutOfBoundsException((new StringBuilder()).append("page out of bounds: ").append(i).toString());
        else
            return;
    }

    public volatile void close() throws IOException {
        super.close();
    }

    public volatile void connect() throws IOException {
        super.connect();
    }

    public int getMaxTransceiveLength() {
        return getMaxTransceiveLengthInternal();
    }

    public volatile Tag getTag() {
        return super.getTag();
    }

    public int getTimeout() {
        int j = super.mTag.getTagService().getTimeout(9);
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

    public int getType() {
        return mType;
    }

    public volatile boolean isConnected() {
        return super.isConnected();
    }

    public byte[] readPages(int i) throws IOException {
        validatePageIndex(i);
        checkConnected();
        byte abyte0[] = new byte[2];
        abyte0[0] = 48;
        abyte0[1] = (byte)i;
        return transceive(abyte0, false);
    }

    public volatile void reconnect() throws IOException {
        super.reconnect();
    }

    public void setTimeout(int i) {
        try {
            if(super.mTag.getTagService().setTimeout(9, i) != 0)
                throw new IllegalArgumentException("The supplied timeout is not valid");
        }
        catch(RemoteException remoteexception) {
            Log.e("NFC", "NFC service dead", remoteexception);
        }
    }

    public byte[] transceive(byte abyte0[]) throws IOException {
        return transceive(abyte0, true);
    }

    public void writePage(int i, byte abyte0[]) throws IOException {
        validatePageIndex(i);
        checkConnected();
        byte abyte1[] = new byte[2 + abyte0.length];
        abyte1[0] = -94;
        abyte1[1] = (byte)i;
        System.arraycopy(abyte0, 0, abyte1, 2, abyte0.length);
        transceive(abyte1, false);
    }

    public static final String EXTRA_IS_UL_C = "isulc";
    private static final int MAX_PAGE_COUNT = 256;
    private static final int NXP_MANUFACTURER_ID = 4;
    public static final int PAGE_SIZE = 4;
    private static final String TAG = "NFC";
    public static final int TYPE_ULTRALIGHT = 1;
    public static final int TYPE_ULTRALIGHT_C = 2;
    public static final int TYPE_UNKNOWN = -1;
    private int mType;
}

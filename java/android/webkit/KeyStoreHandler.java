// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.content.Context;
import android.os.Handler;

// Referenced classes of package android.webkit:
//            ByteArrayBuilder, CertTool

class KeyStoreHandler extends Handler {

    public KeyStoreHandler(String s) {
        mMimeType = s;
    }

    public void didReceiveData(byte abyte0[], int i) {
        ByteArrayBuilder bytearraybuilder = mDataBuilder;
        bytearraybuilder;
        JVM INSTR monitorenter ;
        mDataBuilder.append(abyte0, 0, i);
        return;
    }

    public void installCert(Context context) {
        String s = CertTool.getCertType(mMimeType);
        if(s != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        ByteArrayBuilder bytearraybuilder = mDataBuilder;
        bytearraybuilder;
        JVM INSTR monitorenter ;
        byte abyte0[];
        int i;
        abyte0 = new byte[mDataBuilder.getByteSize()];
        i = 0;
_L4:
        ByteArrayBuilder.Chunk chunk;
        chunk = mDataBuilder.getFirstChunk();
        if(chunk != null)
            break MISSING_BLOCK_LABEL_67;
        CertTool.addCertificate(context, s, abyte0);
        if(true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
        if(chunk.mLength != 0) {
            System.arraycopy(chunk.mArray, 0, abyte0, i, chunk.mLength);
            i += chunk.mLength;
        }
        chunk.release();
          goto _L4
    }

    private static final String LOGTAG = "KeyStoreHandler";
    private final ByteArrayBuilder mDataBuilder = new ByteArrayBuilder();
    private String mMimeType;
}

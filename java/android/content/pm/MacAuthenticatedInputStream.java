// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.pm;

import java.io.*;
import javax.crypto.Mac;

public class MacAuthenticatedInputStream extends FilterInputStream {

    public MacAuthenticatedInputStream(InputStream inputstream, Mac mac) {
        super(inputstream);
        mMac = mac;
    }

    public boolean isTagEqual(byte abyte0[]) {
        boolean flag;
        byte abyte1[];
        flag = false;
        abyte1 = mMac.doFinal();
        if(abyte0 != null && abyte1 != null && abyte0.length == abyte1.length) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        int i = 0;
        for(int j = 0; j < abyte0.length; j++)
            i |= abyte0[j] ^ abyte1[j];

        if(i == 0)
            flag = true;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public int read() throws IOException {
        int i = super.read();
        if(i >= 0)
            mMac.update((byte)i);
        return i;
    }

    public int read(byte abyte0[], int i, int j) throws IOException {
        int k = super.read(abyte0, i, j);
        if(k > 0)
            mMac.update(abyte0, i, k);
        return k;
    }

    private final Mac mMac;
}

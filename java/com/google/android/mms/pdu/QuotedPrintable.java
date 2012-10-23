// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.google.android.mms.pdu;

import java.io.ByteArrayOutputStream;

public class QuotedPrintable {

    public QuotedPrintable() {
    }

    public static final byte[] decodeQuotedPrintable(byte abyte0[]) {
        byte abyte1[] = null;
        if(abyte0 != null) goto _L2; else goto _L1
_L1:
        return abyte1;
_L2:
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        int i = 0;
        do {
label0:
            {
                if(i < abyte0.length) {
                    byte byte0 = abyte0[i];
                    if(byte0 == ESCAPE_CHAR) {
                        int j = i + 1;
                        try {
                            if('\r' == (char)abyte0[j] && '\n' == (char)abyte0[i + 2]) {
                                i += 2;
                                break label0;
                            }
                            int k = i + 1;
                            int l = Character.digit((char)abyte0[k], 16);
                            i = k + 1;
                            int i1 = Character.digit((char)abyte0[i], 16);
                            if(l != -1 && i1 != -1) {
                                bytearrayoutputstream.write((char)(i1 + (l << 4)));
                                break label0;
                            }
                        }
                        catch(ArrayIndexOutOfBoundsException arrayindexoutofboundsexception) { }
                    } else {
                        bytearrayoutputstream.write(byte0);
                        break label0;
                    }
                } else {
                    abyte1 = bytearrayoutputstream.toByteArray();
                }
                if(true)
                    continue;
            }
            i++;
        } while(true);
        if(true) goto _L1; else goto _L3
_L3:
    }

    private static byte ESCAPE_CHAR = 61;

}

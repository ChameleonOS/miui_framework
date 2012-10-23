// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;

import com.android.internal.telephony.GsmAlphabet;
import java.io.ByteArrayOutputStream;

// Referenced classes of package com.android.internal.telephony.cat:
//            ResponseData, ComprehensionTlvTag

class LanguageResponseData extends ResponseData {

    public LanguageResponseData(String s) {
        lang = s;
    }

    public void format(ByteArrayOutputStream bytearrayoutputstream) {
        if(bytearrayoutputstream != null) {
            bytearrayoutputstream.write(0x80 | ComprehensionTlvTag.LANGUAGE.value());
            byte abyte0[];
            byte abyte1[];
            int i;
            int j;
            if(lang != null && lang.length() > 0)
                abyte0 = GsmAlphabet.stringToGsm8BitPacked(lang);
            else
                abyte0 = new byte[0];
            bytearrayoutputstream.write(abyte0.length);
            abyte1 = abyte0;
            i = abyte1.length;
            j = 0;
            while(j < i)  {
                bytearrayoutputstream.write(abyte1[j]);
                j++;
            }
        }
    }

    private String lang;
}

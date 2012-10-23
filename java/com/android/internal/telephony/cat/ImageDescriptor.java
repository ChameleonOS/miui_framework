// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;


// Referenced classes of package com.android.internal.telephony.cat:
//            CatLog

public class ImageDescriptor {

    ImageDescriptor() {
        width = 0;
        height = 0;
        codingScheme = 0;
        imageId = 0;
        highOffset = 0;
        lowOffset = 0;
        length = 0;
    }

    static ImageDescriptor parse(byte abyte0[], int i) {
        ImageDescriptor imagedescriptor;
        int j;
        imagedescriptor = new ImageDescriptor();
        j = i + 1;
        imagedescriptor.width = 0xff & abyte0[i];
        int k = j + 1;
        imagedescriptor.height = 0xff & abyte0[j];
        j = k + 1;
        imagedescriptor.codingScheme = 0xff & abyte0[k];
        int l = j + 1;
        int i1;
        imagedescriptor.imageId = (0xff & abyte0[j]) << 8;
        i1 = imagedescriptor.imageId;
        j = l + 1;
        imagedescriptor.imageId = i1 | 0xff & abyte0[l];
        int j1 = j + 1;
        imagedescriptor.highOffset = 0xff & abyte0[j];
        j = j1 + 1;
        imagedescriptor.lowOffset = 0xff & abyte0[j1];
        int k1 = j + 1;
        byte byte0 = abyte0[j];
        int l1;
        l1 = (byte0 & 0xff) << 8;
        j = k1 + 1;
        imagedescriptor.length = l1 | 0xff & abyte0[k1];
        j;
_L2:
        return imagedescriptor;
        IndexOutOfBoundsException indexoutofboundsexception;
        indexoutofboundsexception;
        j;
_L3:
        CatLog.d("ImageDescripter", "parse; failed parsing image descriptor");
        imagedescriptor = null;
        if(true) goto _L2; else goto _L1
_L1:
        IndexOutOfBoundsException indexoutofboundsexception1;
        indexoutofboundsexception1;
          goto _L3
    }

    static final int CODING_SCHEME_BASIC = 17;
    static final int CODING_SCHEME_COLOUR = 33;
    int codingScheme;
    int height;
    int highOffset;
    int imageId;
    int length;
    int lowOffset;
    int width;
}

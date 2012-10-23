// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;

import java.io.ByteArrayOutputStream;

// Referenced classes of package com.android.internal.telephony.cat:
//            ResponseData, ComprehensionTlvTag

class SelectItemResponseData extends ResponseData {

    public SelectItemResponseData(int i) {
        id = i;
    }

    public void format(ByteArrayOutputStream bytearrayoutputstream) {
        bytearrayoutputstream.write(0x80 | ComprehensionTlvTag.ITEM_ID.value());
        bytearrayoutputstream.write(1);
        bytearrayoutputstream.write(id);
    }

    private int id;
}

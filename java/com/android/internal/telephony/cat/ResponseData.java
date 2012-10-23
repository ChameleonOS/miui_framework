// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;

import java.io.ByteArrayOutputStream;

abstract class ResponseData {

    ResponseData() {
    }

    public static void writeLength(ByteArrayOutputStream bytearrayoutputstream, int i) {
        if(i > 127)
            bytearrayoutputstream.write(129);
        bytearrayoutputstream.write(i);
    }

    public abstract void format(ByteArrayOutputStream bytearrayoutputstream);
}

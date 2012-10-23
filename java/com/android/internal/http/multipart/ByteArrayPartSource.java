// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.http.multipart;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

// Referenced classes of package com.android.internal.http.multipart:
//            PartSource

public class ByteArrayPartSource
    implements PartSource {

    public ByteArrayPartSource(String s, byte abyte0[]) {
        fileName = s;
        bytes = abyte0;
    }

    public InputStream createInputStream() {
        return new ByteArrayInputStream(bytes);
    }

    public String getFileName() {
        return fileName;
    }

    public long getLength() {
        return (long)bytes.length;
    }

    private byte bytes[];
    private String fileName;
}

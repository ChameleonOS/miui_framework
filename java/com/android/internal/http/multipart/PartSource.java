// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.http.multipart;

import java.io.IOException;
import java.io.InputStream;

public interface PartSource {

    public abstract InputStream createInputStream() throws IOException;

    public abstract String getFileName();

    public abstract long getLength();
}

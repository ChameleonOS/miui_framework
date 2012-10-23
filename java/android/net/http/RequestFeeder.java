// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.http;

import org.apache.http.HttpHost;

// Referenced classes of package android.net.http:
//            Request

interface RequestFeeder {

    public abstract Request getRequest();

    public abstract Request getRequest(HttpHost httphost);

    public abstract boolean haveRequest(HttpHost httphost);

    public abstract void requeueRequest(Request request);
}

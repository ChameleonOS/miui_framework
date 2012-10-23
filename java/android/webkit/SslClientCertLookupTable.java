// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import java.security.PrivateKey;
import java.util.*;

final class SslClientCertLookupTable {

    private SslClientCertLookupTable() {
    }

    /**
     * @deprecated Method getInstance is deprecated
     */

    public static SslClientCertLookupTable getInstance() {
        android/webkit/SslClientCertLookupTable;
        JVM INSTR monitorenter ;
        SslClientCertLookupTable sslclientcertlookuptable;
        if(sTable == null)
            sTable = new SslClientCertLookupTable();
        sslclientcertlookuptable = sTable;
        android/webkit/SslClientCertLookupTable;
        JVM INSTR monitorexit ;
        return sslclientcertlookuptable;
        Exception exception;
        exception;
        throw exception;
    }

    public void Allow(String s, PrivateKey privatekey, byte abyte0[][]) {
        privateKeys.put(s, privatekey);
        certificateChains.put(s, abyte0);
        denied.remove(s);
    }

    public byte[][] CertificateChain(String s) {
        return (byte[][])certificateChains.get(s);
    }

    public void Deny(String s) {
        privateKeys.remove(s);
        certificateChains.remove(s);
        denied.add(s);
    }

    public boolean IsAllowed(String s) {
        return privateKeys.containsKey(s);
    }

    public boolean IsDenied(String s) {
        return denied.contains(s);
    }

    public PrivateKey PrivateKey(String s) {
        return (PrivateKey)privateKeys.get(s);
    }

    private static SslClientCertLookupTable sTable;
    private final Map certificateChains = new HashMap();
    private final Set denied = new HashSet();
    private final Map privateKeys = new HashMap();
}

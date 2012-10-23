// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.util.Log;
import java.io.IOException;
import java.net.*;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package android.net:
//            LinkCapabilities, LinkProperties, LinkSocketNotifier, Proxy

public class LinkSocket extends Socket {
    public static final class LinkRequestReason {

        public static final int LINK_PROBLEM_NONE = 0;
        public static final int LINK_PROBLEM_UNKNOWN = 1;

        private LinkRequestReason() {
        }
    }


    public LinkSocket() {
        log("LinkSocket() EX");
    }

    public LinkSocket(LinkSocketNotifier linksocketnotifier) {
        log("LinkSocket(notifier) EX");
    }

    public LinkSocket(LinkSocketNotifier linksocketnotifier, Proxy proxy) {
        log("LinkSocket(notifier, proxy) EX");
    }

    protected static void log(String s) {
        Log.d("LinkSocket", s);
    }

    public void bind(SocketAddress socketaddress) throws UnsupportedOperationException {
        log("bind(localAddr) EX throws IOException");
        throw new UnsupportedOperationException("bind is deprecated for LinkSocket");
    }

    /**
     * @deprecated Method close is deprecated
     */

    public void close() throws IOException {
        this;
        JVM INSTR monitorenter ;
        log("close() EX");
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void connect() throws IOException {
        log("connect() EX");
    }

    public void connect(int i) throws IOException {
        log("connect(timeout) EX");
    }

    public void connect(String s, int i) throws UnknownHostException, IOException {
        log("connect(dstName, dstPort, timeout) EX");
    }

    public void connect(String s, int i, int j) throws UnknownHostException, IOException, SocketTimeoutException {
        log("connect(dstName, dstPort, timeout) EX");
    }

    public void connect(SocketAddress socketaddress) throws IOException {
        log("connect(remoteAddr) EX DEPRECATED");
    }

    public void connect(SocketAddress socketaddress, int i) throws IOException, SocketTimeoutException {
        log("connect(remoteAddr, timeout) EX DEPRECATED");
    }

    public LinkCapabilities getCapabilities() {
        log("getCapabilities() EX");
        return null;
    }

    public LinkCapabilities getCapabilities(Set set) {
        log("getCapabilities(capabilities) EX");
        return new LinkCapabilities();
    }

    public LinkProperties getLinkProperties() {
        log("LinkProperties() EX");
        return new LinkProperties();
    }

    public LinkCapabilities getNeededCapabilities() {
        log("getNeeds() EX");
        return null;
    }

    public Set getTrackedCapabilities() {
        log("getTrackedCapabilities(capabilities) EX");
        return new HashSet();
    }

    public void requestNewLink(LinkRequestReason linkrequestreason) {
        log("requestNewLink(linkRequestReason) EX");
    }

    public boolean setNeededCapabilities(LinkCapabilities linkcapabilities) {
        log("setNeeds() EX");
        return false;
    }

    public void setTrackedCapabilities(Set set) {
        log("setTrackedCapabilities(capabilities) EX");
    }

    private static final boolean DBG = true;
    private static final String TAG = "LinkSocket";
}

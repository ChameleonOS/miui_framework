// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.http;

import android.content.*;
import android.net.*;
import android.util.Log;
import java.io.InputStream;
import java.util.*;
import org.apache.http.HttpHost;

// Referenced classes of package android.net.http:
//            RequestFeeder, Request, HttpLog, LoggingEventHandler, 
//            RequestHandle, Connection, EventHandler, IdleCache, 
//            ConnectionThread

public class RequestQueue
    implements RequestFeeder {
    static interface ConnectionManager {

        public abstract Connection getConnection(Context context, HttpHost httphost);

        public abstract HttpHost getProxyHost();

        public abstract boolean recycleConnection(Connection connection);
    }

    private static class SyncFeeder
        implements RequestFeeder {

        public Request getRequest() {
            Request request = mRequest;
            mRequest = null;
            return request;
        }

        public Request getRequest(HttpHost httphost) {
            return getRequest();
        }

        public boolean haveRequest(HttpHost httphost) {
            boolean flag;
            if(mRequest != null)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public void requeueRequest(Request request) {
            mRequest = request;
        }

        private Request mRequest;

        SyncFeeder() {
        }
    }

    class ActivePool
        implements ConnectionManager {

        void disablePersistence() {
            for(int i = 0; i < mConnectionCount; i++) {
                Connection connection = mThreads[i].mConnection;
                if(connection != null)
                    connection.setCanPersist(false);
            }

            mIdleCache.clear();
        }

        public Connection getConnection(Context context, HttpHost httphost) {
            HttpHost httphost1 = determineHost(httphost);
            Connection connection = mIdleCache.getConnection(httphost1);
            if(connection == null) {
                mTotalConnection = 1 + mTotalConnection;
                connection = Connection.getConnection(mContext, httphost1, mProxyHost, RequestQueue.this);
            }
            return connection;
        }

        public HttpHost getProxyHost() {
            return mProxyHost;
        }

        ConnectionThread getThread(HttpHost httphost) {
            RequestQueue requestqueue = RequestQueue.this;
            requestqueue;
            JVM INSTR monitorenter ;
            int i = 0;
            do {
label0:
                {
                    ConnectionThread connectionthread;
                    if(i < mThreads.length) {
                        connectionthread = mThreads[i];
                        Connection connection = connectionthread.mConnection;
                        if(connection == null || !connection.mHost.equals(httphost))
                            break label0;
                    } else {
                        connectionthread = null;
                    }
                    return connectionthread;
                }
                i++;
            } while(true);
        }

        void logState() {
            StringBuilder stringbuilder = new StringBuilder();
            for(int i = 0; i < mConnectionCount; i++)
                stringbuilder.append((new StringBuilder()).append(mThreads[i]).append("\n").toString());

            HttpLog.v(stringbuilder.toString());
        }

        public boolean recycleConnection(Connection connection) {
            return mIdleCache.cacheConnection(connection.getHost(), connection);
        }

        void shutdown() {
            for(int i = 0; i < mConnectionCount; i++)
                mThreads[i].requestStop();

        }

        void startConnectionThread() {
            RequestQueue requestqueue = RequestQueue.this;
            requestqueue;
            JVM INSTR monitorenter ;
            notify();
            return;
        }

        public void startTiming() {
            for(int i = 0; i < mConnectionCount; i++) {
                ConnectionThread connectionthread = mThreads[i];
                connectionthread.mCurrentThreadTime = -1L;
                connectionthread.mTotalThreadTime = 0L;
            }

            mTotalRequest = 0;
            mTotalConnection = 0;
        }

        void startup() {
            for(int i = 0; i < mConnectionCount; i++)
                mThreads[i].start();

        }

        public void stopTiming() {
            int i = 0;
            for(int j = 0; j < mConnectionCount; j++) {
                ConnectionThread connectionthread = mThreads[j];
                if(connectionthread.mCurrentThreadTime != -1L)
                    i = (int)((long)i + connectionthread.mTotalThreadTime);
                connectionthread.mCurrentThreadTime = 0L;
            }

            Log.d("Http", (new StringBuilder()).append("Http thread used ").append(i).append(" ms ").append(" for ").append(mTotalRequest).append(" requests and ").append(mTotalConnection).append(" new connections").toString());
        }

        private int mConnectionCount;
        IdleCache mIdleCache;
        ConnectionThread mThreads[];
        private int mTotalConnection;
        private int mTotalRequest;
        final RequestQueue this$0;


/*
        static int access$408(ActivePool activepool) {
            int i = activepool.mTotalRequest;
            activepool.mTotalRequest = i + 1;
            return i;
        }

*/

        ActivePool(int i) {
            this$0 = RequestQueue.this;
            super();
            mIdleCache = new IdleCache();
            mConnectionCount = i;
            mThreads = new ConnectionThread[mConnectionCount];
            for(int j = 0; j < mConnectionCount; j++)
                mThreads[j] = new ConnectionThread(mContext, j, this, RequestQueue.this);

        }
    }


    public RequestQueue(Context context) {
        this(context, 4);
    }

    public RequestQueue(Context context, int i) {
        mProxyHost = null;
        mContext = context;
        mPending = new LinkedHashMap(32);
        mActivePool = new ActivePool(i);
        mActivePool.startup();
        mConnectivityManager = (ConnectivityManager)context.getSystemService("connectivity");
    }

    private HttpHost determineHost(HttpHost httphost) {
        if(mProxyHost != null && !"https".equals(httphost.getSchemeName()))
            httphost = mProxyHost;
        return httphost;
    }

    private Request removeFirst(LinkedHashMap linkedhashmap) {
        Request request = null;
        Iterator iterator = linkedhashmap.entrySet().iterator();
        if(iterator.hasNext()) {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            LinkedList linkedlist = (LinkedList)entry.getValue();
            request = (Request)linkedlist.removeFirst();
            if(linkedlist.isEmpty())
                linkedhashmap.remove(entry.getKey());
        }
        return request;
    }

    /**
     * @deprecated Method setProxyConfig is deprecated
     */

    private void setProxyConfig() {
        this;
        JVM INSTR monitorenter ;
        NetworkInfo networkinfo = mConnectivityManager.getActiveNetworkInfo();
        if(networkinfo == null || networkinfo.getType() != 1) goto _L2; else goto _L1
_L1:
        mProxyHost = null;
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        String s;
        s = Proxy.getHost(mContext);
        if(s != null)
            break MISSING_BLOCK_LABEL_55;
        mProxyHost = null;
          goto _L3
        Exception exception;
        exception;
        throw exception;
        mActivePool.disablePersistence();
        mProxyHost = new HttpHost(s, Proxy.getPort(mContext), "http");
          goto _L3
    }

    /**
     * @deprecated Method disablePlatformNotifications is deprecated
     */

    public void disablePlatformNotifications() {
        this;
        JVM INSTR monitorenter ;
        if(mProxyChangeReceiver != null) {
            mContext.unregisterReceiver(mProxyChangeReceiver);
            mProxyChangeReceiver = null;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method dump is deprecated
     */

    void dump() {
        this;
        JVM INSTR monitorenter ;
        StringBuilder stringbuilder;
        Iterator iterator;
        int i;
        HttpLog.v("dump()");
        stringbuilder = new StringBuilder();
        if(mPending.isEmpty())
            break MISSING_BLOCK_LABEL_220;
        iterator = mPending.entrySet().iterator();
        i = 0;
_L1:
        int j;
        StringBuilder stringbuilder2;
        if(!iterator.hasNext())
            break MISSING_BLOCK_LABEL_230;
        java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
        String s = ((HttpHost)entry.getKey()).getHostName();
        StringBuilder stringbuilder1 = (new StringBuilder()).append("p");
        j = i + 1;
        stringbuilder2 = new StringBuilder(stringbuilder1.append(i).append(" ").append(s).append(" ").toString());
        ((LinkedList)entry.getValue()).listIterator(0);
        Request request;
        for(; iterator.hasNext(); stringbuilder2.append((new StringBuilder()).append(request).append(" ").toString()))
            request = (Request)iterator.next();

        break MISSING_BLOCK_LABEL_199;
        Exception exception;
        exception;
        throw exception;
        stringbuilder.append(stringbuilder2);
        stringbuilder.append("\n");
        i = j;
          goto _L1
_L2:
        HttpLog.v(stringbuilder.toString());
        this;
        JVM INSTR monitorexit ;
        return;
        i;
          goto _L2
    }

    /**
     * @deprecated Method enablePlatformNotifications is deprecated
     */

    public void enablePlatformNotifications() {
        this;
        JVM INSTR monitorenter ;
        if(mProxyChangeReceiver == null) {
            mProxyChangeReceiver = new BroadcastReceiver() {

                public void onReceive(Context context, Intent intent) {
                    setProxyConfig();
                }

                final RequestQueue this$0;

             {
                this$0 = RequestQueue.this;
                super();
            }
            };
            mContext.registerReceiver(mProxyChangeReceiver, new IntentFilter("android.intent.action.PROXY_CHANGE"));
        }
        setProxyConfig();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public HttpHost getProxyHost() {
        return mProxyHost;
    }

    /**
     * @deprecated Method getRequest is deprecated
     */

    public Request getRequest() {
        this;
        JVM INSTR monitorenter ;
        Request request = null;
        Request request1;
        if(mPending.isEmpty())
            break MISSING_BLOCK_LABEL_25;
        request1 = removeFirst(mPending);
        request = request1;
        this;
        JVM INSTR monitorexit ;
        return request;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getRequest is deprecated
     */

    public Request getRequest(HttpHost httphost) {
        this;
        JVM INSTR monitorenter ;
        Request request = null;
        if(mPending.containsKey(httphost)) {
            LinkedList linkedlist = (LinkedList)mPending.get(httphost);
            request = (Request)linkedlist.removeFirst();
            if(linkedlist.isEmpty())
                mPending.remove(httphost);
        }
        this;
        JVM INSTR monitorexit ;
        return request;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method haveRequest is deprecated
     */

    public boolean haveRequest(HttpHost httphost) {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mPending.containsKey(httphost);
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public RequestHandle queueRequest(String s, WebAddress webaddress, String s1, Map map, EventHandler eventhandler, InputStream inputstream, int i) {
        if(eventhandler == null)
            eventhandler = new LoggingEventHandler();
        Request request = new Request(s1, new HttpHost(webaddress.getHost(), webaddress.getPort(), webaddress.getScheme()), mProxyHost, webaddress.getPath(), inputstream, i, eventhandler, map);
        queueRequest(request, false);
        int i = 
// JavaClassFileOutputException: get_constant: invalid tag

    public RequestHandle queueRequest(String s, String s1, Map map, EventHandler eventhandler, InputStream inputstream, int i) {
        return queueRequest(s, new WebAddress(s), s1, map, eventhandler, inputstream, i);
    }

    /**
     * @deprecated Method queueRequest is deprecated
     */

    protected void queueRequest(Request request, boolean flag) {
        this;
        JVM INSTR monitorenter ;
        if(request.mProxyHost != null) goto _L2; else goto _L1
_L1:
        HttpHost httphost = request.mHost;
_L5:
        if(!mPending.containsKey(httphost)) goto _L4; else goto _L3
_L3:
        LinkedList linkedlist = (LinkedList)mPending.get(httphost);
_L6:
        if(!flag)
            break MISSING_BLOCK_LABEL_92;
        linkedlist.addFirst(request);
_L7:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        httphost = request.mProxyHost;
          goto _L5
_L4:
        linkedlist = new LinkedList();
        mPending.put(httphost, linkedlist);
          goto _L6
        Exception exception;
        exception;
        throw exception;
        linkedlist.add(request);
          goto _L7
    }

    public RequestHandle queueSynchronousRequest(String s, WebAddress webaddress, String s1, Map map, EventHandler eventhandler, InputStream inputstream, int i) {
        HttpHost httphost = new HttpHost(webaddress.getHost(), webaddress.getPort(), webaddress.getScheme());
        Request request = new Request(s1, httphost, mProxyHost, webaddress.getPath(), inputstream, i, eventhandler, map);
        HttpHost httphost1 = determineHost(httphost);
        return new RequestHandle(this, s, webaddress, s1, map, inputstream, i, request, Connection.getConnection(mContext, httphost1, mProxyHost, new SyncFeeder()));
    }

    /**
     * @deprecated Method requestsPending is deprecated
     */

    boolean requestsPending() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mPending.isEmpty();
        boolean flag1;
        if(!flag)
            flag1 = true;
        else
            flag1 = false;
        this;
        JVM INSTR monitorexit ;
        return flag1;
        Exception exception;
        exception;
        throw exception;
    }

    public void requeueRequest(Request request) {
        queueRequest(request, true);
    }

    public void shutdown() {
        mActivePool.shutdown();
    }

    public void startTiming() {
        mActivePool.startTiming();
    }

    public void stopTiming() {
        mActivePool.stopTiming();
    }

    private static final int CONNECTION_COUNT = 4;
    private final ActivePool mActivePool;
    private final ConnectivityManager mConnectivityManager;
    private final Context mContext;
    private final LinkedHashMap mPending;
    private BroadcastReceiver mProxyChangeReceiver;
    private HttpHost mProxyHost;




}

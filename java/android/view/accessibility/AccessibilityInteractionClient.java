// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.accessibility;

import android.accessibilityservice.IAccessibilityServiceConnection;
import android.graphics.Rect;
import android.os.*;
import android.util.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package android.view.accessibility:
//            AccessibilityNodeInfoCache, AccessibilityNodeInfo, AccessibilityEvent

public final class AccessibilityInteractionClient extends IAccessibilityInteractionConnectionCallback.Stub {

    private AccessibilityInteractionClient() {
        mInteractionId = -1;
    }

    private void applyCompatibilityScaleIfNeeded(AccessibilityNodeInfo accessibilitynodeinfo, float f) {
        if(f != 1.0F) {
            Rect rect = mTempBounds;
            accessibilitynodeinfo.getBoundsInParent(rect);
            rect.scale(f);
            accessibilitynodeinfo.setBoundsInParent(rect);
            accessibilitynodeinfo.getBoundsInScreen(rect);
            rect.scale(f);
            accessibilitynodeinfo.setBoundsInScreen(rect);
        }
    }

    private void checkFindAccessibilityNodeInfoResultIntegrity(List list) {
        if(list.size() != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        AccessibilityNodeInfo accessibilitynodeinfo;
        int i;
        accessibilitynodeinfo = (AccessibilityNodeInfo)list.get(0);
        i = list.size();
        int j = 1;
        do {
label0:
            {
                if(j >= i)
                    break label0;
                int k1 = j;
                do {
label1:
                    {
                        if(k1 < i) {
                            AccessibilityNodeInfo accessibilitynodeinfo3 = (AccessibilityNodeInfo)list.get(k1);
                            if(accessibilitynodeinfo.getParentNodeId() != accessibilitynodeinfo3.getSourceNodeId())
                                break label1;
                            accessibilitynodeinfo = accessibilitynodeinfo3;
                        }
                        j++;
                    }
                    if(true)
                        break;
                    k1++;
                } while(true);
            }
        } while(true);
        if(accessibilitynodeinfo == null)
            Log.e("AccessibilityInteractionClient", "No root.");
        HashSet hashset = new HashSet();
        LinkedList linkedlist = new LinkedList();
        linkedlist.add(accessibilitynodeinfo);
        do {
            if(linkedlist.isEmpty())
                break;
            AccessibilityNodeInfo accessibilitynodeinfo1 = (AccessibilityNodeInfo)linkedlist.poll();
            if(!hashset.add(accessibilitynodeinfo1)) {
                Log.e("AccessibilityInteractionClient", "Duplicate node.");
                continue; /* Loop/switch isn't completed */
            }
            SparseLongArray sparselongarray = accessibilitynodeinfo1.getChildNodeIds();
            int l = sparselongarray.size();
            int i1 = 0;
            while(i1 < l)  {
                long l1 = sparselongarray.valueAt(i1);
                for(int j1 = 0; j1 < i; j1++) {
                    AccessibilityNodeInfo accessibilitynodeinfo2 = (AccessibilityNodeInfo)list.get(j1);
                    if(accessibilitynodeinfo2.getSourceNodeId() == l1)
                        linkedlist.add(accessibilitynodeinfo2);
                }

                i1++;
            }
        } while(true);
        int k = list.size() - hashset.size();
        if(k > 0)
            Log.e("AccessibilityInteractionClient", (new StringBuilder()).append(k).append(" Disconnected nodes.").toString());
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void clearResultLocked() {
        mInteractionId = -1;
        mFindAccessibilityNodeInfoResult = null;
        mFindAccessibilityNodeInfosResult = null;
        mPerformAccessibilityActionResult = false;
    }

    private void finalizeAndCacheAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo, int i, float f) {
        if(accessibilitynodeinfo != null) {
            applyCompatibilityScaleIfNeeded(accessibilitynodeinfo, f);
            accessibilitynodeinfo.setConnectionId(i);
            accessibilitynodeinfo.setSealed(true);
            sAccessibilityNodeInfoCache.add(accessibilitynodeinfo);
        }
    }

    private void finalizeAndCacheAccessibilityNodeInfos(List list, int i, float f) {
        if(list != null) {
            int j = list.size();
            for(int k = 0; k < j; k++)
                finalizeAndCacheAccessibilityNodeInfo((AccessibilityNodeInfo)list.get(k), i, f);

        }
    }

    private AccessibilityNodeInfo getFindAccessibilityNodeInfoResultAndClear(int i) {
        Object obj = mInstanceLock;
        obj;
        JVM INSTR monitorenter ;
        AccessibilityNodeInfo accessibilitynodeinfo;
        if(waitForResultTimedLocked(i))
            accessibilitynodeinfo = mFindAccessibilityNodeInfoResult;
        else
            accessibilitynodeinfo = null;
        clearResultLocked();
        return accessibilitynodeinfo;
    }

    private List getFindAccessibilityNodeInfosResultAndClear(int i) {
        Object obj = mInstanceLock;
        obj;
        JVM INSTR monitorenter ;
        List list;
        if(waitForResultTimedLocked(i))
            list = mFindAccessibilityNodeInfosResult;
        else
            list = Collections.emptyList();
        clearResultLocked();
        if(Build.IS_DEBUGGABLE)
            checkFindAccessibilityNodeInfoResultIntegrity(list);
        return list;
    }

    public static AccessibilityInteractionClient getInstance() {
        return getInstanceForThread(Thread.currentThread().getId());
    }

    public static AccessibilityInteractionClient getInstanceForThread(long l) {
        Object obj = sStaticLock;
        obj;
        JVM INSTR monitorenter ;
        AccessibilityInteractionClient accessibilityinteractionclient = (AccessibilityInteractionClient)sClients.get(l);
        if(accessibilityinteractionclient == null) {
            accessibilityinteractionclient = new AccessibilityInteractionClient();
            sClients.put(l, accessibilityinteractionclient);
        }
        return accessibilityinteractionclient;
    }

    private boolean getPerformAccessibilityActionResultAndClear(int i) {
        Object obj = mInstanceLock;
        obj;
        JVM INSTR monitorenter ;
        boolean flag;
        if(waitForResultTimedLocked(i))
            flag = mPerformAccessibilityActionResult;
        else
            flag = false;
        clearResultLocked();
        return flag;
    }

    private Message getSameProcessMessageAndClear() {
        Object obj = mInstanceLock;
        obj;
        JVM INSTR monitorenter ;
        Message message = mSameThreadMessage;
        mSameThreadMessage = null;
        return message;
    }

    private boolean waitForResultTimedLocked(int i) {
        boolean flag = false;
        long l = SystemClock.uptimeMillis();
        do
            try {
                Message message = getSameProcessMessageAndClear();
                if(message != null)
                    message.getTarget().handleMessage(message);
                if(mInteractionId == i) {
                    flag = true;
                    break;
                }
                if(mInteractionId > i)
                    break;
                long l1 = 5000L - (SystemClock.uptimeMillis() - l);
                if(l1 <= 0L)
                    break;
                mInstanceLock.wait(l1);
            }
            catch(InterruptedException interruptedexception) { }
        while(true);
        return flag;
    }

    public void addConnection(int i, IAccessibilityServiceConnection iaccessibilityserviceconnection) {
        SparseArray sparsearray = sConnectionCache;
        sparsearray;
        JVM INSTR monitorenter ;
        sConnectionCache.put(i, iaccessibilityserviceconnection);
        return;
    }

    public void clearCache() {
        sAccessibilityNodeInfoCache.clear();
    }

    public AccessibilityNodeInfo findAccessibilityNodeInfoByAccessibilityId(int i, int j, long l, int k) {
        AccessibilityNodeInfo accessibilitynodeinfo;
        AccessibilityNodeInfo accessibilitynodeinfo1;
        IAccessibilityServiceConnection iaccessibilityserviceconnection = getConnection(i);
        if(iaccessibilityserviceconnection == null)
            break MISSING_BLOCK_LABEL_121;
        accessibilitynodeinfo = sAccessibilityNodeInfoCache.get(l);
        if(accessibilitynodeinfo != null)
            break MISSING_BLOCK_LABEL_124;
        int i1 = mInteractionIdCounter.getAndIncrement();
        float f = iaccessibilityserviceconnection.findAccessibilityNodeInfoByAccessibilityId(j, l, i1, this, k, Thread.currentThread().getId());
        if(f <= 0.0F)
            break MISSING_BLOCK_LABEL_121;
        List list = getFindAccessibilityNodeInfosResultAndClear(i1);
        finalizeAndCacheAccessibilityNodeInfos(list, i, f);
        if(list == null || list.isEmpty())
            break MISSING_BLOCK_LABEL_121;
        accessibilitynodeinfo1 = (AccessibilityNodeInfo)list.get(0);
        accessibilitynodeinfo = accessibilitynodeinfo1;
        break MISSING_BLOCK_LABEL_124;
        RemoteException remoteexception;
        remoteexception;
        accessibilitynodeinfo = null;
        return accessibilitynodeinfo;
    }

    public AccessibilityNodeInfo findAccessibilityNodeInfoByViewId(int i, int j, long l, int k) {
        IAccessibilityServiceConnection iaccessibilityserviceconnection = getConnection(i);
        if(iaccessibilityserviceconnection == null) goto _L2; else goto _L1
_L1:
        int i1;
        float f;
        i1 = mInteractionIdCounter.getAndIncrement();
        f = iaccessibilityserviceconnection.findAccessibilityNodeInfoByViewId(j, l, k, i1, this, Thread.currentThread().getId());
        if(f <= 0.0F) goto _L2; else goto _L3
_L3:
        AccessibilityNodeInfo accessibilitynodeinfo;
        accessibilitynodeinfo = getFindAccessibilityNodeInfoResultAndClear(i1);
        finalizeAndCacheAccessibilityNodeInfo(accessibilitynodeinfo, i, f);
_L5:
        return accessibilitynodeinfo;
        RemoteException remoteexception;
        remoteexception;
_L2:
        accessibilitynodeinfo = null;
        if(true) goto _L5; else goto _L4
_L4:
    }

    public List findAccessibilityNodeInfosByText(int i, int j, long l, String s) {
        IAccessibilityServiceConnection iaccessibilityserviceconnection = getConnection(i);
        if(iaccessibilityserviceconnection == null) goto _L2; else goto _L1
_L1:
        int k;
        float f;
        k = mInteractionIdCounter.getAndIncrement();
        f = iaccessibilityserviceconnection.findAccessibilityNodeInfosByText(j, l, s, k, this, Thread.currentThread().getId());
        if(f <= 0.0F) goto _L2; else goto _L3
_L3:
        List list;
        list = getFindAccessibilityNodeInfosResultAndClear(k);
        finalizeAndCacheAccessibilityNodeInfos(list, i, f);
_L5:
        return list;
        RemoteException remoteexception;
        remoteexception;
_L2:
        list = Collections.emptyList();
        if(true) goto _L5; else goto _L4
_L4:
    }

    public AccessibilityNodeInfo findFocus(int i, int j, long l, int k) {
        IAccessibilityServiceConnection iaccessibilityserviceconnection = getConnection(i);
        if(iaccessibilityserviceconnection == null) goto _L2; else goto _L1
_L1:
        int i1;
        float f;
        i1 = mInteractionIdCounter.getAndIncrement();
        f = iaccessibilityserviceconnection.findFocus(j, l, k, i1, this, Thread.currentThread().getId());
        if(f <= 0.0F) goto _L2; else goto _L3
_L3:
        AccessibilityNodeInfo accessibilitynodeinfo;
        accessibilitynodeinfo = getFindAccessibilityNodeInfoResultAndClear(i1);
        finalizeAndCacheAccessibilityNodeInfo(accessibilitynodeinfo, i, f);
_L5:
        return accessibilitynodeinfo;
        RemoteException remoteexception;
        remoteexception;
_L2:
        accessibilitynodeinfo = null;
        if(true) goto _L5; else goto _L4
_L4:
    }

    public AccessibilityNodeInfo focusSearch(int i, int j, long l, int k) {
        IAccessibilityServiceConnection iaccessibilityserviceconnection = getConnection(i);
        if(iaccessibilityserviceconnection == null) goto _L2; else goto _L1
_L1:
        int i1;
        float f;
        i1 = mInteractionIdCounter.getAndIncrement();
        f = iaccessibilityserviceconnection.focusSearch(j, l, k, i1, this, Thread.currentThread().getId());
        if(f <= 0.0F) goto _L2; else goto _L3
_L3:
        AccessibilityNodeInfo accessibilitynodeinfo;
        accessibilitynodeinfo = getFindAccessibilityNodeInfoResultAndClear(i1);
        finalizeAndCacheAccessibilityNodeInfo(accessibilitynodeinfo, i, f);
_L5:
        return accessibilitynodeinfo;
        RemoteException remoteexception;
        remoteexception;
_L2:
        accessibilitynodeinfo = null;
        if(true) goto _L5; else goto _L4
_L4:
    }

    public IAccessibilityServiceConnection getConnection(int i) {
        SparseArray sparsearray = sConnectionCache;
        sparsearray;
        JVM INSTR monitorenter ;
        IAccessibilityServiceConnection iaccessibilityserviceconnection = (IAccessibilityServiceConnection)sConnectionCache.get(i);
        return iaccessibilityserviceconnection;
    }

    public AccessibilityNodeInfo getRootInActiveWindow(int i) {
        return findAccessibilityNodeInfoByAccessibilityId(i, -1, AccessibilityNodeInfo.ROOT_NODE_ID, 4);
    }

    public void onAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        sAccessibilityNodeInfoCache.onAccessibilityEvent(accessibilityevent);
    }

    public boolean performAccessibilityAction(int i, int j, long l, int k, Bundle bundle) {
        IAccessibilityServiceConnection iaccessibilityserviceconnection = getConnection(i);
        if(iaccessibilityserviceconnection == null) goto _L2; else goto _L1
_L1:
        int i1 = mInteractionIdCounter.getAndIncrement();
        if(!iaccessibilityserviceconnection.performAccessibilityAction(j, l, k, bundle, i1, this, Thread.currentThread().getId())) goto _L2; else goto _L3
_L3:
        boolean flag1 = getPerformAccessibilityActionResultAndClear(i1);
        boolean flag = flag1;
_L5:
        return flag;
        RemoteException remoteexception;
        remoteexception;
_L2:
        flag = false;
        if(true) goto _L5; else goto _L4
_L4:
    }

    public void removeConnection(int i) {
        SparseArray sparsearray = sConnectionCache;
        sparsearray;
        JVM INSTR monitorenter ;
        sConnectionCache.remove(i);
        return;
    }

    public void setFindAccessibilityNodeInfoResult(AccessibilityNodeInfo accessibilitynodeinfo, int i) {
        Object obj = mInstanceLock;
        obj;
        JVM INSTR monitorenter ;
        if(i > mInteractionId) {
            mFindAccessibilityNodeInfoResult = accessibilitynodeinfo;
            mInteractionId = i;
        }
        mInstanceLock.notifyAll();
        return;
    }

    public void setFindAccessibilityNodeInfosResult(List list, int i) {
        Object obj = mInstanceLock;
        obj;
        JVM INSTR monitorenter ;
label0:
        {
            {
                if(i <= mInteractionId)
                    break label0;
                if(list == null)
                    break MISSING_BLOCK_LABEL_78;
                Exception exception;
                boolean flag;
                if(Binder.getCallingPid() != Process.myPid())
                    flag = true;
                else
                    flag = false;
                if(!flag)
                    mFindAccessibilityNodeInfosResult = new ArrayList(list);
                else
                    mFindAccessibilityNodeInfosResult = list;
            }
            mInteractionId = i;
        }
        mInstanceLock.notifyAll();
        return;
        exception;
        throw exception;
        mFindAccessibilityNodeInfosResult = Collections.emptyList();
        break MISSING_BLOCK_LABEL_48;
    }

    public void setPerformAccessibilityActionResult(boolean flag, int i) {
        Object obj = mInstanceLock;
        obj;
        JVM INSTR monitorenter ;
        if(i > mInteractionId) {
            mPerformAccessibilityActionResult = flag;
            mInteractionId = i;
        }
        mInstanceLock.notifyAll();
        return;
    }

    public void setSameThreadMessage(Message message) {
        Object obj = mInstanceLock;
        obj;
        JVM INSTR monitorenter ;
        mSameThreadMessage = message;
        mInstanceLock.notifyAll();
        return;
    }

    private static final boolean CHECK_INTEGRITY = true;
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = "AccessibilityInteractionClient";
    public static final int NO_ID = -1;
    private static final long TIMEOUT_INTERACTION_MILLIS = 5000L;
    private static final AccessibilityNodeInfoCache sAccessibilityNodeInfoCache = new AccessibilityNodeInfoCache();
    private static final LongSparseArray sClients = new LongSparseArray();
    private static final SparseArray sConnectionCache = new SparseArray();
    private static final Object sStaticLock = new Object();
    private AccessibilityNodeInfo mFindAccessibilityNodeInfoResult;
    private List mFindAccessibilityNodeInfosResult;
    private final Object mInstanceLock = new Object();
    private volatile int mInteractionId;
    private final AtomicInteger mInteractionIdCounter = new AtomicInteger();
    private boolean mPerformAccessibilityActionResult;
    private Message mSameThreadMessage;
    private final Rect mTempBounds = new Rect();

}

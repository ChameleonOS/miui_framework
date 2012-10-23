// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.accessibility;

import android.os.Build;
import android.util.*;
import java.util.*;

// Referenced classes of package android.view.accessibility:
//            AccessibilityNodeInfo, AccessibilityEvent

public class AccessibilityNodeInfoCache {

    public AccessibilityNodeInfoCache() {
    }

    private void checkIntegrity() {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        if(mCacheImpl.size() > 0) goto _L2; else goto _L1
_L2:
        int i;
        AccessibilityNodeInfo accessibilitynodeinfo2;
        AccessibilityNodeInfo accessibilitynodeinfo3;
        HashSet hashset;
        LinkedList linkedlist;
        AccessibilityNodeInfo accessibilitynodeinfo = (AccessibilityNodeInfo)mCacheImpl.valueAt(0);
        for(AccessibilityNodeInfo accessibilitynodeinfo1 = accessibilitynodeinfo; accessibilitynodeinfo1 != null; accessibilitynodeinfo1 = (AccessibilityNodeInfo)mCacheImpl.get(accessibilitynodeinfo1.getParentNodeId()))
            accessibilitynodeinfo = accessibilitynodeinfo1;

        i = accessibilitynodeinfo.getWindowId();
        accessibilitynodeinfo2 = null;
        accessibilitynodeinfo3 = null;
        hashset = new HashSet();
        linkedlist = new LinkedList();
        linkedlist.add(accessibilitynodeinfo);
_L12:
        if(linkedlist.isEmpty()) goto _L4; else goto _L3
_L3:
        AccessibilityNodeInfo accessibilitynodeinfo5 = (AccessibilityNodeInfo)linkedlist.poll();
        if(hashset.add(accessibilitynodeinfo5)) goto _L6; else goto _L5
_L5:
        Log.e(LOG_TAG, (new StringBuilder()).append("Duplicate node: ").append(accessibilitynodeinfo5).toString());
          goto _L1
        Exception exception;
        exception;
        throw exception;
_L6:
        if(!accessibilitynodeinfo5.isAccessibilityFocused()) goto _L8; else goto _L7
_L7:
        if(accessibilitynodeinfo2 == null) goto _L10; else goto _L9
_L9:
        Log.e(LOG_TAG, (new StringBuilder()).append("Duplicate accessibility focus:").append(accessibilitynodeinfo5).toString());
_L8:
        if(accessibilitynodeinfo5.isFocused()) {
            if(accessibilitynodeinfo3 == null)
                break MISSING_BLOCK_LABEL_452;
            Log.e(LOG_TAG, (new StringBuilder()).append("Duplicate input focus: ").append(accessibilitynodeinfo5).toString());
        }
_L16:
        SparseLongArray sparselongarray;
        int l;
        int i1;
        sparselongarray = accessibilitynodeinfo5.getChildNodeIds();
        l = sparselongarray.size();
        i1 = 0;
_L15:
        if(i1 >= l) goto _L12; else goto _L11
_L11:
        long l1 = sparselongarray.valueAt(i1);
        AccessibilityNodeInfo accessibilitynodeinfo6 = (AccessibilityNodeInfo)mCacheImpl.get(l1);
        if(accessibilitynodeinfo6 != null)
            linkedlist.add(accessibilitynodeinfo6);
          goto _L13
_L4:
        int j;
        j = mCacheImpl.size();
        for(int k = 0; k < j; k++) {
            AccessibilityNodeInfo accessibilitynodeinfo4 = (AccessibilityNodeInfo)mCacheImpl.valueAt(k);
            if(!hashset.contains(accessibilitynodeinfo4))
                if(accessibilitynodeinfo4.getWindowId() == i)
                    Log.e(LOG_TAG, "Disconneced node: ");
                else
                    Log.e(LOG_TAG, (new StringBuilder()).append("Node from: ").append(accessibilitynodeinfo4.getWindowId()).append(" not from:").append(i).append(" ").append(accessibilitynodeinfo4).toString());
            break MISSING_BLOCK_LABEL_459;
        }

        obj;
        JVM INSTR monitorexit ;
_L1:
        return;
_L13:
        i1++;
        if(true) goto _L15; else goto _L14
_L14:
          goto _L12
_L10:
        accessibilitynodeinfo2 = accessibilitynodeinfo5;
          goto _L8
        accessibilitynodeinfo3 = accessibilitynodeinfo5;
          goto _L16
    }

    private void clearSubTreeLocked(long l) {
        AccessibilityNodeInfo accessibilitynodeinfo = (AccessibilityNodeInfo)mCacheImpl.get(l);
        if(accessibilitynodeinfo != null) {
            mCacheImpl.remove(l);
            SparseLongArray sparselongarray = accessibilitynodeinfo.getChildNodeIds();
            int i = sparselongarray.size();
            int j = 0;
            while(j < i)  {
                clearSubTreeLocked(sparselongarray.valueAt(j));
                j++;
            }
        }
    }

    private void clearSubtreeWithOldAccessibilityFocusLocked(long l) {
        int i = mCacheImpl.size();
        int j = 0;
        do {
label0:
            {
                if(j < i) {
                    AccessibilityNodeInfo accessibilitynodeinfo = (AccessibilityNodeInfo)mCacheImpl.valueAt(j);
                    long l1 = accessibilitynodeinfo.getSourceNodeId();
                    if(l1 == l || !accessibilitynodeinfo.isAccessibilityFocused())
                        break label0;
                    clearSubTreeLocked(l1);
                }
                return;
            }
            j++;
        } while(true);
    }

    private void clearSubtreeWithOldInputFocusLocked(long l) {
        int i = mCacheImpl.size();
        int j = 0;
        do {
label0:
            {
                if(j < i) {
                    AccessibilityNodeInfo accessibilitynodeinfo = (AccessibilityNodeInfo)mCacheImpl.valueAt(j);
                    long l1 = accessibilitynodeinfo.getSourceNodeId();
                    if(l1 == l || !accessibilitynodeinfo.isFocused())
                        break label0;
                    clearSubTreeLocked(l1);
                }
                return;
            }
            j++;
        } while(true);
    }

    public void add(AccessibilityNodeInfo accessibilitynodeinfo) {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        long l;
        AccessibilityNodeInfo accessibilitynodeinfo1;
        l = accessibilitynodeinfo.getSourceNodeId();
        accessibilitynodeinfo1 = (AccessibilityNodeInfo)mCacheImpl.get(l);
        if(accessibilitynodeinfo1 == null) goto _L2; else goto _L1
_L1:
        SparseLongArray sparselongarray;
        SparseLongArray sparselongarray1;
        int i;
        int j;
        sparselongarray = accessibilitynodeinfo1.getChildNodeIds();
        sparselongarray1 = accessibilitynodeinfo.getChildNodeIds();
        i = sparselongarray.size();
        j = 0;
_L4:
        if(j < i) {
            long l2 = sparselongarray.valueAt(j);
            AccessibilityNodeInfo accessibilitynodeinfo2;
            long l1;
            if(sparselongarray1.indexOfValue(l2) < 0)
                clearSubTreeLocked(l2);
            j++;
            continue; /* Loop/switch isn't completed */
        }
        l1 = accessibilitynodeinfo1.getParentNodeId();
        if(accessibilitynodeinfo.getParentNodeId() != l1)
            clearSubTreeLocked(l1);
_L2:
        accessibilitynodeinfo2 = AccessibilityNodeInfo.obtain(accessibilitynodeinfo);
        mCacheImpl.put(l, accessibilitynodeinfo2);
        return;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void clear() {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        int i = mCacheImpl.size();
        for(int j = 0; j < i; j++)
            ((AccessibilityNodeInfo)mCacheImpl.valueAt(j)).recycle();

        mCacheImpl.clear();
        return;
    }

    public AccessibilityNodeInfo get(long l) {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        AccessibilityNodeInfo accessibilitynodeinfo = (AccessibilityNodeInfo)mCacheImpl.get(l);
        if(accessibilitynodeinfo != null)
            accessibilitynodeinfo = AccessibilityNodeInfo.obtain(accessibilitynodeinfo);
        return accessibilitynodeinfo;
    }

    public void onAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        int i = accessibilityevent.getEventType();
        i;
        JVM INSTR lookupswitch 10: default 96
    //                   4: 150
    //                   8: 150
    //                   16: 150
    //                   32: 107
    //                   128: 122
    //                   256: 122
    //                   2048: 209
    //                   4096: 209
    //                   8192: 150
    //                   32768: 150;
           goto _L1 _L2 _L2 _L2 _L3 _L4 _L4 _L5 _L5 _L2 _L2
_L1:
        if(Build.IS_DEBUGGABLE)
            checkIntegrity();
        return;
_L3:
        mWindowId = accessibilityevent.getWindowId();
        clear();
        continue; /* Loop/switch isn't completed */
_L4:
        int j = accessibilityevent.getWindowId();
        if(mWindowId != j) {
            mWindowId = j;
            clear();
        }
        continue; /* Loop/switch isn't completed */
_L2:
        Object obj1 = mLock;
        obj1;
        JVM INSTR monitorenter ;
        long l = accessibilityevent.getSourceNodeId();
        clearSubTreeLocked(l);
        if(i == 8)
            clearSubtreeWithOldInputFocusLocked(l);
        if(i == 32768)
            clearSubtreeWithOldAccessibilityFocusLocked(l);
        continue; /* Loop/switch isn't completed */
_L5:
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        clearSubTreeLocked(accessibilityevent.getSourceNodeId());
        if(true) goto _L1; else goto _L6
_L6:
    }

    private static final boolean CHECK_INTEGRITY = true;
    private static final boolean DEBUG = false;
    private static final boolean ENABLED = true;
    private static final String LOG_TAG = android/view/accessibility/AccessibilityNodeInfoCache.getSimpleName();
    private final LongSparseArray mCacheImpl = new LongSparseArray();
    private final Object mLock = new Object();
    private int mWindowId;

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.os.*;
import android.util.*;
import android.view.accessibility.AccessibilityInteractionClient;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.accessibility.IAccessibilityInteractionConnectionCallback;
import java.util.*;

// Referenced classes of package android.view:
//            ViewRootImpl, View, ViewGroup, ViewParent

final class AccessibilityInteractionController {
    private class PrivateHandler extends Handler {

        public String getMessageName(Message message) {
            int i = message.what;
            i;
            JVM INSTR tableswitch 1 6: default 44
        //                       1 71
        //                       2 76
        //                       3 82
        //                       4 88
        //                       5 94
        //                       6 100;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown message type: ").append(i).toString());
_L2:
            String s = "MSG_PERFORM_ACCESSIBILITY_ACTION";
_L9:
            return s;
_L3:
            s = "MSG_FIND_ACCESSIBLITY_NODE_INFO_BY_ACCESSIBILITY_ID";
            continue; /* Loop/switch isn't completed */
_L4:
            s = "MSG_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_ID";
            continue; /* Loop/switch isn't completed */
_L5:
            s = "MSG_FIND_ACCESSIBLITY_NODE_INFO_BY_TEXT";
            continue; /* Loop/switch isn't completed */
_L6:
            s = "MSG_FIND_FOCUS";
            continue; /* Loop/switch isn't completed */
_L7:
            s = "MSG_FOCUS_SEARCH";
            if(true) goto _L9; else goto _L8
_L8:
        }

        public void handleMessage(Message message) {
            int i = message.what;
            i;
            JVM INSTR tableswitch 1 6: default 44
        //                       1 80
        //                       2 71
        //                       3 91
        //                       4 102
        //                       5 113
        //                       6 124;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown message type: ").append(i).toString());
_L3:
            findAccessibilityNodeInfoByAccessibilityIdUiThread(message);
_L9:
            return;
_L2:
            perfromAccessibilityActionUiThread(message);
            continue; /* Loop/switch isn't completed */
_L4:
            findAccessibilityNodeInfoByViewIdUiThread(message);
            continue; /* Loop/switch isn't completed */
_L5:
            findAccessibilityNodeInfosByTextUiThread(message);
            continue; /* Loop/switch isn't completed */
_L6:
            findFocusUiThread(message);
            continue; /* Loop/switch isn't completed */
_L7:
            focusSearchUiThread(message);
            if(true) goto _L9; else goto _L8
_L8:
        }

        private static final int MSG_FIND_ACCESSIBLITY_NODE_INFO_BY_ACCESSIBILITY_ID = 2;
        private static final int MSG_FIND_ACCESSIBLITY_NODE_INFO_BY_TEXT = 4;
        private static final int MSG_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_ID = 3;
        private static final int MSG_FIND_FOCUS = 5;
        private static final int MSG_FOCUS_SEARCH = 6;
        private static final int MSG_PERFORM_ACCESSIBILITY_ACTION = 1;
        final AccessibilityInteractionController this$0;

        public PrivateHandler(Looper looper) {
            this$0 = AccessibilityInteractionController.this;
            super(looper);
        }
    }

    private class AccessibilityNodePrefetcher {

        private void prefetchDescendantsOfRealNode(View view, List list) {
            if(view instanceof ViewGroup) goto _L2; else goto _L1
_L1:
            return;
_L2:
            HashMap hashmap;
            ArrayList arraylist;
            hashmap = new HashMap();
            arraylist = mTempViewList;
            arraylist.clear();
            int i;
            int j;
            view.addChildrenForAccessibility(arraylist);
            i = arraylist.size();
            j = 0;
_L5:
            if(j >= i) goto _L4; else goto _L3
_L3:
            int k = list.size();
label0:
            {
                if(k < 50)
                    break label0;
                arraylist.clear();
            }
              goto _L1
            View view2 = (View)arraylist.get(j);
            if(isShown(view2)) {
                AccessibilityNodeProvider accessibilitynodeprovider = view2.getAccessibilityNodeProvider();
                if(accessibilitynodeprovider == null) {
                    AccessibilityNodeInfo accessibilitynodeinfo2 = view2.createAccessibilityNodeInfo();
                    if(accessibilitynodeinfo2 != null) {
                        list.add(accessibilitynodeinfo2);
                        hashmap.put(view2, null);
                    }
                } else {
                    AccessibilityNodeInfo accessibilitynodeinfo1 = accessibilitynodeprovider.createAccessibilityNodeInfo(-1);
                    if(accessibilitynodeinfo1 != null) {
                        list.add(accessibilitynodeinfo1);
                        hashmap.put(view2, accessibilitynodeinfo1);
                    }
                }
            }
            break MISSING_BLOCK_LABEL_289;
            Exception exception;
            exception;
            arraylist.clear();
            throw exception;
_L4:
            arraylist.clear();
            if(list.size() < 50) {
                Iterator iterator = hashmap.entrySet().iterator();
                while(iterator.hasNext())  {
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                    View view1 = (View)entry.getKey();
                    AccessibilityNodeInfo accessibilitynodeinfo = (AccessibilityNodeInfo)entry.getValue();
                    if(accessibilitynodeinfo == null)
                        prefetchDescendantsOfRealNode(view1, list);
                    else
                        prefetchDescendantsOfVirtualNode(accessibilitynodeinfo, view1.getAccessibilityNodeProvider(), list);
                }
            }
              goto _L1
            j++;
              goto _L5
        }

        private void prefetchDescendantsOfVirtualNode(AccessibilityNodeInfo accessibilitynodeinfo, AccessibilityNodeProvider accessibilitynodeprovider, List list) {
            SparseLongArray sparselongarray;
            int i;
            int j;
            int k;
            sparselongarray = accessibilitynodeinfo.getChildNodeIds();
            i = list.size();
            j = sparselongarray.size();
            k = 0;
_L5:
            if(k >= j) goto _L2; else goto _L1
_L1:
            if(list.size() < 50) goto _L4; else goto _L3
_L3:
            return;
_L4:
            AccessibilityNodeInfo accessibilitynodeinfo1 = accessibilitynodeprovider.createAccessibilityNodeInfo(AccessibilityNodeInfo.getVirtualDescendantId(sparselongarray.get(k)));
            if(accessibilitynodeinfo1 != null)
                list.add(accessibilitynodeinfo1);
            k++;
              goto _L5
_L2:
            if(list.size() < 50) {
                int l = list.size() - i;
                int i1 = 0;
                while(i1 < l)  {
                    prefetchDescendantsOfVirtualNode((AccessibilityNodeInfo)list.get(i + i1), accessibilitynodeprovider, list);
                    i1++;
                }
            }
              goto _L3
        }

        private void prefetchPredecessorsOfRealNode(View view, List list) {
            for(ViewParent viewparent = view.getParentForAccessibility(); (viewparent instanceof View) && list.size() < 50; viewparent = viewparent.getParentForAccessibility()) {
                AccessibilityNodeInfo accessibilitynodeinfo = ((View)viewparent).createAccessibilityNodeInfo();
                if(accessibilitynodeinfo != null)
                    list.add(accessibilitynodeinfo);
            }

        }

        private void prefetchPredecessorsOfVirtualNode(AccessibilityNodeInfo accessibilitynodeinfo, View view, AccessibilityNodeProvider accessibilitynodeprovider, List list) {
            long l;
            int i;
            l = accessibilitynodeinfo.getParentNodeId();
            i = AccessibilityNodeInfo.getAccessibilityViewId(l);
_L3:
            if(i != -1 && list.size() < 50) goto _L2; else goto _L1
_L1:
            return;
_L2:
label0:
            {
                int j = AccessibilityNodeInfo.getVirtualDescendantId(l);
                if(j == -1 && i != view.getAccessibilityViewId())
                    break label0;
                AccessibilityNodeInfo accessibilitynodeinfo1 = accessibilitynodeprovider.createAccessibilityNodeInfo(j);
                if(accessibilitynodeinfo1 != null)
                    list.add(accessibilitynodeinfo1);
                l = accessibilitynodeinfo1.getParentNodeId();
                i = AccessibilityNodeInfo.getAccessibilityViewId(l);
            }
              goto _L3
            prefetchPredecessorsOfRealNode(view, list);
              goto _L1
        }

        private void prefetchSiblingsOfRealNode(View view, List list) {
            ViewParent viewparent = view.getParentForAccessibility();
            if(!(viewparent instanceof ViewGroup)) goto _L2; else goto _L1
_L1:
            ViewGroup viewgroup;
            ArrayList arraylist;
            viewgroup = (ViewGroup)viewparent;
            arraylist = mTempViewList;
            arraylist.clear();
            int i;
            int j;
            viewgroup.addChildrenForAccessibility(arraylist);
            i = arraylist.size();
            j = 0;
_L9:
            if(j >= i) goto _L4; else goto _L3
_L3:
            int k = list.size();
            if(k < 50) goto _L5; else goto _L4
_L4:
            arraylist.clear();
_L2:
            return;
_L5:
            View view1;
            AccessibilityNodeProvider accessibilitynodeprovider;
            view1 = (View)arraylist.get(j);
            if(view1.getAccessibilityViewId() == view.getAccessibilityViewId() || !isShown(view1))
                break MISSING_BLOCK_LABEL_172;
            accessibilitynodeprovider = view1.getAccessibilityNodeProvider();
            if(accessibilitynodeprovider != null) goto _L7; else goto _L6
_L6:
            AccessibilityNodeInfo accessibilitynodeinfo1 = view1.createAccessibilityNodeInfo();
_L8:
            if(accessibilitynodeinfo1 != null)
                list.add(accessibilitynodeinfo1);
            break MISSING_BLOCK_LABEL_172;
_L7:
            AccessibilityNodeInfo accessibilitynodeinfo = accessibilitynodeprovider.createAccessibilityNodeInfo(-1);
            accessibilitynodeinfo1 = accessibilitynodeinfo;
              goto _L8
            Exception exception;
            exception;
            arraylist.clear();
            throw exception;
            j++;
              goto _L9
        }

        private void prefetchSiblingsOfVirtualNode(AccessibilityNodeInfo accessibilitynodeinfo, View view, AccessibilityNodeProvider accessibilitynodeprovider, List list) {
            AccessibilityNodeInfo accessibilitynodeinfo1;
            long l = accessibilitynodeinfo.getParentNodeId();
            int i = AccessibilityNodeInfo.getAccessibilityViewId(l);
            int j = AccessibilityNodeInfo.getVirtualDescendantId(l);
            if(j == -1 && i != view.getAccessibilityViewId())
                break MISSING_BLOCK_LABEL_137;
            accessibilitynodeinfo1 = accessibilitynodeprovider.createAccessibilityNodeInfo(j);
            if(accessibilitynodeinfo1 == null) goto _L2; else goto _L1
_L1:
            SparseLongArray sparselongarray;
            int k;
            int i1;
            sparselongarray = accessibilitynodeinfo1.getChildNodeIds();
            k = sparselongarray.size();
            i1 = 0;
_L4:
            if(i1 < k && list.size() < 50) goto _L3; else goto _L2
_L2:
            return;
_L3:
            long l1 = sparselongarray.get(i1);
            if(l1 != accessibilitynodeinfo.getSourceNodeId()) {
                AccessibilityNodeInfo accessibilitynodeinfo2 = accessibilitynodeprovider.createAccessibilityNodeInfo(AccessibilityNodeInfo.getVirtualDescendantId(l1));
                if(accessibilitynodeinfo2 != null)
                    list.add(accessibilitynodeinfo2);
            }
            i1++;
              goto _L4
            prefetchSiblingsOfRealNode(view, list);
              goto _L2
        }

        public void prefetchAccessibilityNodeInfos(View view, int i, int j, List list) {
            AccessibilityNodeProvider accessibilitynodeprovider = view.getAccessibilityNodeProvider();
            if(accessibilitynodeprovider != null) goto _L2; else goto _L1
_L1:
            AccessibilityNodeInfo accessibilitynodeinfo1 = view.createAccessibilityNodeInfo();
            if(accessibilitynodeinfo1 != null) {
                list.add(accessibilitynodeinfo1);
                if((j & 1) != 0)
                    prefetchPredecessorsOfRealNode(view, list);
                if((j & 2) != 0)
                    prefetchSiblingsOfRealNode(view, list);
                if((j & 4) != 0)
                    prefetchDescendantsOfRealNode(view, list);
            }
_L4:
            return;
_L2:
            AccessibilityNodeInfo accessibilitynodeinfo = accessibilitynodeprovider.createAccessibilityNodeInfo(i);
            if(accessibilitynodeinfo != null) {
                list.add(accessibilitynodeinfo);
                if((j & 1) != 0)
                    prefetchPredecessorsOfVirtualNode(accessibilitynodeinfo, view, accessibilitynodeprovider, list);
                if((j & 2) != 0)
                    prefetchSiblingsOfVirtualNode(accessibilitynodeinfo, view, accessibilitynodeprovider, list);
                if((j & 4) != 0)
                    prefetchDescendantsOfVirtualNode(accessibilitynodeinfo, accessibilitynodeprovider, list);
            }
            if(true) goto _L4; else goto _L3
_L3:
        }

        private static final int MAX_ACCESSIBILITY_NODE_INFO_BATCH_SIZE = 50;
        private final ArrayList mTempViewList;
        final AccessibilityInteractionController this$0;

        private AccessibilityNodePrefetcher() {
            this$0 = AccessibilityInteractionController.this;
            super();
            mTempViewList = new ArrayList();
        }

    }

    private class SomeArgs
        implements Poolable {

        private void clear() {
            arg1 = null;
            arg2 = null;
            argi1 = 0;
            argi2 = 0;
            argi3 = 0;
        }

        public SomeArgs getNextPoolable() {
            return mNext;
        }

        public volatile Object getNextPoolable() {
            return getNextPoolable();
        }

        public boolean isPooled() {
            return mIsPooled;
        }

        public void setNextPoolable(SomeArgs someargs) {
            mNext = someargs;
        }

        public volatile void setNextPoolable(Object obj) {
            setNextPoolable((SomeArgs)obj);
        }

        public void setPooled(boolean flag) {
            mIsPooled = flag;
        }

        public Object arg1;
        public Object arg2;
        public int argi1;
        public int argi2;
        public int argi3;
        private boolean mIsPooled;
        private SomeArgs mNext;
        final AccessibilityInteractionController this$0;


        private SomeArgs() {
            this$0 = AccessibilityInteractionController.this;
            super();
        }

    }


    public AccessibilityInteractionController(ViewRootImpl viewrootimpl) {
        mTempAccessibilityNodeInfoList = new ArrayList();
        Looper looper = viewrootimpl.mHandler.getLooper();
        mMyLooperThreadId = looper.getThread().getId();
        mHandler = new PrivateHandler(looper);
        mViewRootImpl = viewrootimpl;
    }

    private void findAccessibilityNodeInfoByAccessibilityIdUiThread(Message message) {
        boolean flag;
        int i;
        int j;
        int k;
        int l;
        IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback;
        ArrayList arraylist;
        flag = false;
        i = message.arg1;
        SomeArgs someargs = (SomeArgs)message.obj;
        j = someargs.argi1;
        k = someargs.argi2;
        l = someargs.argi3;
        iaccessibilityinteractionconnectioncallback = (IAccessibilityInteractionConnectionCallback)someargs.arg1;
        SomeArgs someargs1 = (SomeArgs)someargs.arg2;
        mViewRootImpl.mAttachInfo.mActualWindowLeft = someargs1.argi1;
        mViewRootImpl.mAttachInfo.mActualWindowTop = someargs1.argi2;
        mPool.release(someargs1);
        mPool.release(someargs);
        arraylist = mTempAccessibilityNodeInfoList;
        arraylist.clear();
        if(mViewRootImpl.mView == null) goto _L2; else goto _L1
_L1:
        View.AttachInfo attachinfo = mViewRootImpl.mAttachInfo;
        if(attachinfo != null) goto _L3; else goto _L2
_L2:
        mViewRootImpl.mAttachInfo.mIncludeNotImportantViews = false;
        iaccessibilityinteractionconnectioncallback.setFindAccessibilityNodeInfosResult(arraylist, l);
        arraylist.clear();
_L6:
        return;
_L3:
        View.AttachInfo attachinfo1 = mViewRootImpl.mAttachInfo;
        if((i & 8) != 0)
            flag = true;
        attachinfo1.mIncludeNotImportantViews = flag;
        if(j != -1) goto _L5; else goto _L4
_L4:
        View view1 = mViewRootImpl.mView;
_L7:
        if(view1 != null && isShown(view1))
            mPrefetcher.prefetchAccessibilityNodeInfos(view1, k, i, arraylist);
        try {
            mViewRootImpl.mAttachInfo.mIncludeNotImportantViews = false;
            iaccessibilityinteractionconnectioncallback.setFindAccessibilityNodeInfosResult(arraylist, l);
            arraylist.clear();
        }
        catch(RemoteException remoteexception1) { }
          goto _L6
_L5:
        View view = findViewByAccessibilityId(j);
        view1 = view;
          goto _L7
        Exception exception;
        exception;
        try {
            mViewRootImpl.mAttachInfo.mIncludeNotImportantViews = false;
            iaccessibilityinteractionconnectioncallback.setFindAccessibilityNodeInfosResult(arraylist, l);
            arraylist.clear();
        }
        catch(RemoteException remoteexception) { }
        throw exception;
          goto _L6
    }

    private void findAccessibilityNodeInfoByViewIdUiThread(Message message) {
        boolean flag;
        int i;
        int j;
        int k;
        int l;
        IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback;
        AccessibilityNodeInfo accessibilitynodeinfo;
        flag = false;
        i = message.arg1;
        j = message.arg2;
        SomeArgs someargs = (SomeArgs)message.obj;
        k = someargs.argi1;
        l = someargs.argi2;
        iaccessibilityinteractionconnectioncallback = (IAccessibilityInteractionConnectionCallback)someargs.arg1;
        SomeArgs someargs1 = (SomeArgs)someargs.arg2;
        mViewRootImpl.mAttachInfo.mActualWindowLeft = someargs1.argi1;
        mViewRootImpl.mAttachInfo.mActualWindowTop = someargs1.argi2;
        mPool.release(someargs1);
        mPool.release(someargs);
        accessibilitynodeinfo = null;
        if(mViewRootImpl.mView == null) goto _L2; else goto _L1
_L1:
        View.AttachInfo attachinfo = mViewRootImpl.mAttachInfo;
        if(attachinfo != null) goto _L3; else goto _L2
_L2:
        mViewRootImpl.mAttachInfo.mIncludeNotImportantViews = false;
        iaccessibilityinteractionconnectioncallback.setFindAccessibilityNodeInfoResult(null, l);
_L7:
        return;
_L3:
        View view;
        View.AttachInfo attachinfo1 = mViewRootImpl.mAttachInfo;
        if((i & 8) != 0)
            flag = true;
        attachinfo1.mIncludeNotImportantViews = flag;
        if(j == -1)
            break MISSING_BLOCK_LABEL_265;
        view = findViewByAccessibilityId(j);
_L8:
        if(view == null) goto _L5; else goto _L4
_L4:
        View view1 = view.findViewById(k);
        if(view1 == null || !isShown(view1)) goto _L5; else goto _L6
_L6:
        AccessibilityNodeInfo accessibilitynodeinfo1 = view1.createAccessibilityNodeInfo();
        accessibilitynodeinfo = accessibilitynodeinfo1;
_L5:
        try {
            mViewRootImpl.mAttachInfo.mIncludeNotImportantViews = false;
            iaccessibilityinteractionconnectioncallback.setFindAccessibilityNodeInfoResult(accessibilitynodeinfo, l);
        }
        catch(RemoteException remoteexception1) { }
          goto _L7
        view = mViewRootImpl.mView;
          goto _L8
        Exception exception;
        exception;
        try {
            mViewRootImpl.mAttachInfo.mIncludeNotImportantViews = false;
            iaccessibilityinteractionconnectioncallback.setFindAccessibilityNodeInfoResult(null, l);
        }
        catch(RemoteException remoteexception) { }
        throw exception;
          goto _L7
    }

    private void findAccessibilityNodeInfosByTextUiThread(Message message) {
        int i;
        String s;
        int j;
        int k;
        int l;
        IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback;
        Object obj;
        i = message.arg1;
        SomeArgs someargs = (SomeArgs)message.obj;
        s = (String)someargs.arg1;
        j = someargs.argi1;
        k = someargs.argi2;
        l = someargs.argi3;
        SomeArgs someargs1 = (SomeArgs)someargs.arg2;
        iaccessibilityinteractionconnectioncallback = (IAccessibilityInteractionConnectionCallback)someargs1.arg1;
        mViewRootImpl.mAttachInfo.mActualWindowLeft = someargs1.argi1;
        mViewRootImpl.mAttachInfo.mActualWindowTop = someargs1.argi2;
        mPool.release(someargs1);
        mPool.release(someargs);
        obj = null;
        if(mViewRootImpl.mView == null) goto _L2; else goto _L1
_L1:
        View.AttachInfo attachinfo = mViewRootImpl.mAttachInfo;
        if(attachinfo != null) goto _L3; else goto _L2
_L2:
        mViewRootImpl.mAttachInfo.mIncludeNotImportantViews = false;
        iaccessibilityinteractionconnectioncallback.setFindAccessibilityNodeInfosResult(null, l);
_L12:
        return;
_L3:
        View.AttachInfo attachinfo1 = mViewRootImpl.mAttachInfo;
        if((i & 8) == 0) goto _L5; else goto _L4
_L4:
        boolean flag = true;
_L13:
        attachinfo1.mIncludeNotImportantViews = flag;
        if(j == -1) goto _L7; else goto _L6
_L6:
        View view = findViewByAccessibilityId(j);
_L14:
        if(view == null || !isShown(view)) goto _L9; else goto _L8
_L8:
        AccessibilityNodeProvider accessibilitynodeprovider = view.getAccessibilityNodeProvider();
        if(accessibilitynodeprovider == null) goto _L11; else goto _L10
_L10:
        List list1 = accessibilitynodeprovider.findAccessibilityNodeInfosByText(s, k);
        obj = list1;
_L9:
        try {
            mViewRootImpl.mAttachInfo.mIncludeNotImportantViews = false;
            iaccessibilityinteractionconnectioncallback.setFindAccessibilityNodeInfosResult(((List) (obj)), l);
        }
        catch(RemoteException remoteexception1) { }
          goto _L12
_L5:
        flag = false;
          goto _L13
_L7:
        view = mViewRootImpl.mView;
          goto _L14
_L11:
        if(k != -1) goto _L9; else goto _L15
_L15:
        ArrayList arraylist;
        arraylist = mTempArrayList;
        arraylist.clear();
        view.findViewsWithText(arraylist, s, 7);
        if(arraylist.isEmpty()) goto _L9; else goto _L16
_L16:
        int i1;
        int j1;
        obj = mTempAccessibilityNodeInfoList;
        ((List) (obj)).clear();
        i1 = arraylist.size();
        j1 = 0;
_L19:
        if(j1 >= i1) goto _L9; else goto _L17
_L17:
        View view1 = (View)arraylist.get(j1);
        if(isShown(view1)) {
            AccessibilityNodeProvider accessibilitynodeprovider1 = view1.getAccessibilityNodeProvider();
            if(accessibilitynodeprovider1 != null) {
                List list = accessibilitynodeprovider1.findAccessibilityNodeInfosByText(s, -1);
                if(list != null)
                    ((List) (obj)).addAll(list);
            } else {
                ((List) (obj)).add(view1.createAccessibilityNodeInfo());
            }
        }
          goto _L18
        Exception exception;
        exception;
        try {
            mViewRootImpl.mAttachInfo.mIncludeNotImportantViews = false;
            iaccessibilityinteractionconnectioncallback.setFindAccessibilityNodeInfosResult(((List) (obj)), l);
        }
        catch(RemoteException remoteexception) { }
        throw exception;
_L18:
        j1++;
          goto _L19
    }

    private void findFocusUiThread(Message message) {
        int i;
        int j;
        int k;
        int l;
        int i1;
        IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback;
        AccessibilityNodeInfo accessibilitynodeinfo;
        i = message.arg1;
        j = message.arg2;
        SomeArgs someargs = (SomeArgs)message.obj;
        k = someargs.argi1;
        l = someargs.argi2;
        i1 = someargs.argi3;
        iaccessibilityinteractionconnectioncallback = (IAccessibilityInteractionConnectionCallback)someargs.arg1;
        SomeArgs someargs1 = (SomeArgs)someargs.arg2;
        mViewRootImpl.mAttachInfo.mActualWindowLeft = someargs1.argi1;
        mViewRootImpl.mAttachInfo.mActualWindowTop = someargs1.argi2;
        mPool.release(someargs1);
        mPool.release(someargs);
        accessibilitynodeinfo = null;
        if(mViewRootImpl.mView == null) goto _L2; else goto _L1
_L1:
        View.AttachInfo attachinfo = mViewRootImpl.mAttachInfo;
        if(attachinfo != null) goto _L3; else goto _L2
_L2:
        mViewRootImpl.mAttachInfo.mIncludeNotImportantViews = false;
        iaccessibilityinteractionconnectioncallback.setFindAccessibilityNodeInfoResult(null, k);
_L17:
        return;
_L3:
        View.AttachInfo attachinfo1 = mViewRootImpl.mAttachInfo;
        if((i & 8) == 0) goto _L5; else goto _L4
_L4:
        boolean flag = true;
_L13:
        attachinfo1.mIncludeNotImportantViews = flag;
        if(l == -1) goto _L7; else goto _L6
_L6:
        View view = findViewByAccessibilityId(l);
_L14:
        if(view == null || !isShown(view)) goto _L9; else goto _L8
_L8:
        j;
        JVM INSTR tableswitch 1 2: default 240
    //                   1 420
    //                   2 312;
           goto _L10 _L11 _L12
_L10:
        throw new IllegalArgumentException((new StringBuilder()).append("Unknown focus type: ").append(j).toString());
        Exception exception;
        exception;
        RemoteException remoteexception1;
        View view1;
        AccessibilityNodeInfo accessibilitynodeinfo1;
        View view2;
        boolean flag1;
        try {
            mViewRootImpl.mAttachInfo.mIncludeNotImportantViews = false;
            iaccessibilityinteractionconnectioncallback.setFindAccessibilityNodeInfoResult(null, k);
        }
        catch(RemoteException remoteexception) { }
        throw exception;
_L5:
        flag = false;
          goto _L13
_L7:
        view = mViewRootImpl.mView;
          goto _L14
_L12:
        view2 = mViewRootImpl.mAccessibilityFocusedHost;
        if(view2 == null) goto _L9; else goto _L15
_L15:
        flag1 = ViewRootImpl.isViewDescendantOf(view2, view);
        if(flag1) goto _L16; else goto _L9
_L9:
        try {
            mViewRootImpl.mAttachInfo.mIncludeNotImportantViews = false;
            iaccessibilityinteractionconnectioncallback.setFindAccessibilityNodeInfoResult(accessibilitynodeinfo, k);
        }
        // Misplaced declaration of an exception variable
        catch(RemoteException remoteexception1) { }
          goto _L17
_L16:
        if(view2.getAccessibilityNodeProvider() != null) {
            if(mViewRootImpl.mAccessibilityFocusedVirtualView != null)
                accessibilitynodeinfo = AccessibilityNodeInfo.obtain(mViewRootImpl.mAccessibilityFocusedVirtualView);
        } else
        if(i1 == -1)
            accessibilitynodeinfo = view2.createAccessibilityNodeInfo();
          goto _L9
_L11:
        view1 = view.findFocus();
        if(view1 == null || !isShown(view1)) goto _L9; else goto _L18
_L18:
        accessibilitynodeinfo1 = view1.createAccessibilityNodeInfo();
        accessibilitynodeinfo = accessibilitynodeinfo1;
          goto _L9
    }

    private View findViewByAccessibilityId(int i) {
        View view = mViewRootImpl.mView;
        if(view != null) goto _L2; else goto _L1
_L1:
        View view1 = null;
_L4:
        return view1;
_L2:
        view1 = view.findViewByAccessibilityId(i);
        if(view1 != null && !isShown(view1))
            view1 = null;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void focusSearchUiThread(Message message) {
        int i;
        int j;
        int k;
        int l;
        int i1;
        IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback;
        AccessibilityNodeInfo accessibilitynodeinfo;
        i = message.arg1;
        j = message.arg2;
        SomeArgs someargs = (SomeArgs)message.obj;
        k = someargs.argi1;
        l = someargs.argi2;
        i1 = someargs.argi3;
        iaccessibilityinteractionconnectioncallback = (IAccessibilityInteractionConnectionCallback)someargs.arg1;
        SomeArgs someargs1 = (SomeArgs)someargs.arg2;
        mViewRootImpl.mAttachInfo.mActualWindowLeft = someargs1.argi1;
        mViewRootImpl.mAttachInfo.mActualWindowTop = someargs1.argi2;
        mPool.release(someargs1);
        mPool.release(someargs);
        accessibilitynodeinfo = null;
        if(mViewRootImpl.mView == null) goto _L2; else goto _L1
_L1:
        View.AttachInfo attachinfo = mViewRootImpl.mAttachInfo;
        if(attachinfo != null) goto _L3; else goto _L2
_L2:
        mViewRootImpl.mAttachInfo.mIncludeNotImportantViews = false;
        iaccessibilityinteractionconnectioncallback.setFindAccessibilityNodeInfoResult(null, i1);
_L15:
        return;
_L3:
        View.AttachInfo attachinfo1 = mViewRootImpl.mAttachInfo;
        if((i & 8) == 0) goto _L5; else goto _L4
_L4:
        boolean flag = true;
_L16:
        attachinfo1.mIncludeNotImportantViews = flag;
        if(j == -1) goto _L7; else goto _L6
_L6:
        View view = findViewByAccessibilityId(j);
_L17:
        if(view == null || !isShown(view)) goto _L9; else goto _L8
_L8:
        if((l & 0x1000) != 4096) goto _L11; else goto _L10
_L10:
        AccessibilityNodeProvider accessibilitynodeprovider = view.getAccessibilityNodeProvider();
        if(accessibilitynodeprovider == null) goto _L13; else goto _L12
_L12:
        AccessibilityNodeInfo accessibilitynodeinfo3 = accessibilitynodeprovider.accessibilityFocusSearch(l, k);
        accessibilitynodeinfo = accessibilitynodeinfo3;
        if(accessibilitynodeinfo == null) goto _L13; else goto _L14
_L14:
        try {
            mViewRootImpl.mAttachInfo.mIncludeNotImportantViews = false;
            iaccessibilityinteractionconnectioncallback.setFindAccessibilityNodeInfoResult(accessibilitynodeinfo, i1);
        }
        catch(RemoteException remoteexception1) { }
          goto _L15
_L5:
        flag = false;
          goto _L16
_L7:
        view = mViewRootImpl.mView;
          goto _L17
_L13:
        View view2 = view.focusSearch(l);
_L22:
        if(view2 == null) goto _L9; else goto _L18
_L18:
        AccessibilityNodeProvider accessibilitynodeprovider1 = view2.getAccessibilityNodeProvider();
        if(accessibilitynodeprovider1 == null) goto _L20; else goto _L19
_L19:
        AccessibilityNodeInfo accessibilitynodeinfo2 = accessibilitynodeprovider1.accessibilityFocusSearch(l, -1);
        accessibilitynodeinfo = accessibilitynodeinfo2;
        if(accessibilitynodeinfo == null) goto _L21; else goto _L9
_L9:
        mViewRootImpl.mAttachInfo.mIncludeNotImportantViews = false;
        iaccessibilityinteractionconnectioncallback.setFindAccessibilityNodeInfoResult(accessibilitynodeinfo, i1);
          goto _L15
_L21:
        view2 = view2.focusSearch(l);
          goto _L22
_L20:
        accessibilitynodeinfo = view2.createAccessibilityNodeInfo();
          goto _L9
_L11:
        View view1 = view.focusSearch(l);
        if(view1 == null) goto _L9; else goto _L23
_L23:
        AccessibilityNodeInfo accessibilitynodeinfo1 = view1.createAccessibilityNodeInfo();
        accessibilitynodeinfo = accessibilitynodeinfo1;
          goto _L9
        Exception exception;
        exception;
        try {
            mViewRootImpl.mAttachInfo.mIncludeNotImportantViews = false;
            iaccessibilityinteractionconnectioncallback.setFindAccessibilityNodeInfoResult(accessibilitynodeinfo, i1);
        }
        catch(RemoteException remoteexception) { }
        throw exception;
          goto _L15
    }

    private boolean isShown(View view) {
        boolean flag;
        if(view.mAttachInfo != null && view.mAttachInfo.mWindowVisibility == 0 && view.isShown())
            flag = true;
        else
            flag = false;
        return flag;
    }

    private void perfromAccessibilityActionUiThread(Message message) {
        int i;
        int j;
        int k;
        int l;
        int i1;
        IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback;
        Bundle bundle;
        boolean flag;
        i = message.arg1;
        j = message.arg2;
        SomeArgs someargs = (SomeArgs)message.obj;
        k = someargs.argi1;
        l = someargs.argi2;
        i1 = someargs.argi3;
        iaccessibilityinteractionconnectioncallback = (IAccessibilityInteractionConnectionCallback)someargs.arg1;
        bundle = (Bundle)someargs.arg2;
        mPool.release(someargs);
        flag = false;
        if(mViewRootImpl.mView == null) goto _L2; else goto _L1
_L1:
        View.AttachInfo attachinfo = mViewRootImpl.mAttachInfo;
        if(attachinfo != null) goto _L3; else goto _L2
_L2:
        mViewRootImpl.mAttachInfo.mIncludeNotImportantViews = false;
        iaccessibilityinteractionconnectioncallback.setPerformAccessibilityActionResult(false, i1);
_L12:
        return;
_L3:
        View.AttachInfo attachinfo1 = mViewRootImpl.mAttachInfo;
        if((i & 8) == 0) goto _L5; else goto _L4
_L4:
        boolean flag1 = true;
_L13:
        attachinfo1.mIncludeNotImportantViews = flag1;
        if(j == -1) goto _L7; else goto _L6
_L6:
        View view = findViewByAccessibilityId(j);
_L14:
        if(view == null || !isShown(view)) goto _L9; else goto _L8
_L8:
        AccessibilityNodeProvider accessibilitynodeprovider = view.getAccessibilityNodeProvider();
        if(accessibilitynodeprovider == null) goto _L11; else goto _L10
_L10:
        boolean flag3 = accessibilitynodeprovider.performAction(k, l, bundle);
        flag = flag3;
_L9:
        try {
            mViewRootImpl.mAttachInfo.mIncludeNotImportantViews = false;
            iaccessibilityinteractionconnectioncallback.setPerformAccessibilityActionResult(flag, i1);
        }
        catch(RemoteException remoteexception1) { }
          goto _L12
_L5:
        flag1 = false;
          goto _L13
_L7:
        view = mViewRootImpl.mView;
          goto _L14
_L11:
        if(k != -1) goto _L9; else goto _L15
_L15:
        boolean flag2 = view.performAccessibilityAction(l, bundle);
        flag = flag2;
          goto _L9
        Exception exception;
        exception;
        try {
            mViewRootImpl.mAttachInfo.mIncludeNotImportantViews = false;
            iaccessibilityinteractionconnectioncallback.setPerformAccessibilityActionResult(false, i1);
        }
        catch(RemoteException remoteexception) { }
        throw exception;
          goto _L12
    }

    public void findAccessibilityNodeInfoByAccessibilityIdClientThread(long l, int i, int j, int k, IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback, int i1, 
            int j1, long l1) {
        Message message = mHandler.obtainMessage();
        message.what = 2;
        message.arg1 = i1;
        SomeArgs someargs = (SomeArgs)mPool.acquire();
        someargs.argi1 = AccessibilityNodeInfo.getAccessibilityViewId(l);
        someargs.argi2 = AccessibilityNodeInfo.getVirtualDescendantId(l);
        someargs.argi3 = k;
        someargs.arg1 = iaccessibilityinteractionconnectioncallback;
        SomeArgs someargs1 = (SomeArgs)mPool.acquire();
        someargs1.argi1 = i;
        someargs1.argi2 = j;
        someargs.arg2 = someargs1;
        message.obj = someargs;
        if(j1 == mMyProcessId && l1 == mMyLooperThreadId)
            AccessibilityInteractionClient.getInstanceForThread(l1).setSameThreadMessage(message);
        else
            mHandler.sendMessage(message);
    }

    public void findAccessibilityNodeInfoByViewIdClientThread(long l, int i, int j, int k, int i1, IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback, 
            int j1, int k1, long l1) {
        Message message = mHandler.obtainMessage();
        message.what = 3;
        message.arg1 = j1;
        message.arg2 = AccessibilityNodeInfo.getAccessibilityViewId(l);
        SomeArgs someargs = (SomeArgs)mPool.acquire();
        someargs.argi1 = i;
        someargs.argi2 = i1;
        someargs.arg1 = iaccessibilityinteractionconnectioncallback;
        SomeArgs someargs1 = (SomeArgs)mPool.acquire();
        someargs1.argi1 = j;
        someargs1.argi2 = k;
        someargs.arg2 = someargs1;
        message.obj = someargs;
        if(k1 == mMyProcessId && l1 == mMyLooperThreadId)
            AccessibilityInteractionClient.getInstanceForThread(l1).setSameThreadMessage(message);
        else
            mHandler.sendMessage(message);
    }

    public void findAccessibilityNodeInfosByTextClientThread(long l, String s, int i, int j, int k, IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback, 
            int i1, int j1, long l1) {
        Message message = mHandler.obtainMessage();
        message.what = 4;
        message.arg1 = i1;
        SomeArgs someargs = (SomeArgs)mPool.acquire();
        someargs.arg1 = s;
        someargs.argi1 = AccessibilityNodeInfo.getAccessibilityViewId(l);
        someargs.argi2 = AccessibilityNodeInfo.getVirtualDescendantId(l);
        someargs.argi3 = k;
        SomeArgs someargs1 = (SomeArgs)mPool.acquire();
        someargs1.arg1 = iaccessibilityinteractionconnectioncallback;
        someargs1.argi1 = i;
        someargs1.argi2 = j;
        someargs.arg2 = someargs1;
        message.obj = someargs;
        if(j1 == mMyProcessId && l1 == mMyLooperThreadId)
            AccessibilityInteractionClient.getInstanceForThread(l1).setSameThreadMessage(message);
        else
            mHandler.sendMessage(message);
    }

    public void findFocusClientThread(long l, int i, int j, int k, int i1, IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback, 
            int j1, int k1, long l1) {
        Message message = mHandler.obtainMessage();
        message.what = 5;
        message.arg1 = j1;
        message.arg2 = i;
        SomeArgs someargs = (SomeArgs)mPool.acquire();
        someargs.argi1 = i1;
        someargs.argi2 = AccessibilityNodeInfo.getAccessibilityViewId(l);
        someargs.argi3 = AccessibilityNodeInfo.getVirtualDescendantId(l);
        someargs.arg1 = iaccessibilityinteractionconnectioncallback;
        SomeArgs someargs1 = (SomeArgs)mPool.acquire();
        someargs1.argi1 = j;
        someargs1.argi2 = k;
        someargs.arg2 = someargs1;
        message.obj = someargs;
        if(k1 == mMyProcessId && l1 == mMyLooperThreadId)
            AccessibilityInteractionClient.getInstanceForThread(l1).setSameThreadMessage(message);
        else
            mHandler.sendMessage(message);
    }

    public void focusSearchClientThread(long l, int i, int j, int k, int i1, IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback, 
            int j1, int k1, long l1) {
        Message message = mHandler.obtainMessage();
        message.what = 6;
        message.arg1 = j1;
        message.arg2 = AccessibilityNodeInfo.getAccessibilityViewId(l);
        SomeArgs someargs = (SomeArgs)mPool.acquire();
        someargs.argi1 = AccessibilityNodeInfo.getVirtualDescendantId(l);
        someargs.argi2 = i;
        someargs.argi3 = i1;
        someargs.arg1 = iaccessibilityinteractionconnectioncallback;
        SomeArgs someargs1 = (SomeArgs)mPool.acquire();
        someargs1.argi1 = j;
        someargs1.argi2 = k;
        someargs.arg2 = someargs1;
        message.obj = someargs;
        if(k1 == mMyProcessId && l1 == mMyLooperThreadId)
            AccessibilityInteractionClient.getInstanceForThread(l1).setSameThreadMessage(message);
        else
            mHandler.sendMessage(message);
    }

    public void performAccessibilityActionClientThread(long l, int i, Bundle bundle, int j, IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback, int k, 
            int i1, long l1) {
        Message message = mHandler.obtainMessage();
        message.what = 1;
        message.arg1 = k;
        message.arg2 = AccessibilityNodeInfo.getAccessibilityViewId(l);
        SomeArgs someargs = (SomeArgs)mPool.acquire();
        someargs.argi1 = AccessibilityNodeInfo.getVirtualDescendantId(l);
        someargs.argi2 = i;
        someargs.argi3 = j;
        someargs.arg1 = iaccessibilityinteractionconnectioncallback;
        someargs.arg2 = bundle;
        message.obj = someargs;
        if(i1 == mMyProcessId && l1 == mMyLooperThreadId)
            AccessibilityInteractionClient.getInstanceForThread(l1).setSameThreadMessage(message);
        else
            mHandler.sendMessage(message);
    }

    private static final int POOL_SIZE = 5;
    private final Handler mHandler;
    private final long mMyLooperThreadId;
    private final int mMyProcessId = Process.myPid();
    private final Pool mPool = Pools.synchronizedPool(Pools.finitePool(new PoolableManager() {

        public volatile Poolable newInstance() {
            return newInstance();
        }

        public SomeArgs newInstance() {
            return new SomeArgs();
        }

        public volatile void onAcquired(Poolable poolable) {
            onAcquired((SomeArgs)poolable);
        }

        public void onAcquired(SomeArgs someargs) {
        }

        public volatile void onReleased(Poolable poolable) {
            onReleased((SomeArgs)poolable);
        }

        public void onReleased(SomeArgs someargs) {
            someargs.clear();
        }

        final AccessibilityInteractionController this$0;

             {
                this$0 = AccessibilityInteractionController.this;
                super();
            }
    }, 5));
    private final AccessibilityNodePrefetcher mPrefetcher = new AccessibilityNodePrefetcher();
    private ArrayList mTempAccessibilityNodeInfoList;
    private final ArrayList mTempArrayList = new ArrayList();
    private final ViewRootImpl mViewRootImpl;







}

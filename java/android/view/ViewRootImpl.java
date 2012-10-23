// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.animation.LayoutTransition;
import android.animation.ValueAnimator;
import android.app.ActivityManagerNative;
import android.app.IActivityManager;
import android.content.*;
import android.content.pm.ApplicationInfo;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.*;
import android.util.*;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.accessibility.IAccessibilityInteractionConnectionCallback;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.Scroller;
import com.android.internal.policy.PolicyManager;
import com.android.internal.view.*;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package android.view:
//            ViewParent, Surface, InputEventConsistencyVerifier, WindowLeaked, 
//            ViewConfiguration, Choreographer, KeyEvent, View, 
//            MotionEvent, InputEvent, FallbackEventHandler, ViewGroup, 
//            SoundEffectConstants, HardwareRenderer, ViewTreeObserver, IWindowSession, 
//            InputEventReceiver, DisplayList, Display, IWindowManager, 
//            DragEvent, CompatibilityInfoHolder, WindowManagerImpl, HardwareLayer, 
//            HardwareCanvas, InputChannel, KeyCharacterMap, FocusFinder, 
//            AccessibilityInteractionController, InputQueue, SurfaceHolder, ContextMenu, 
//            ActionMode, ViewDebug

public final class ViewRootImpl
    implements ViewParent, View.AttachInfo.Callbacks, HardwareRenderer.HardwareDrawCallbacks {
    private class SendWindowContentChangedAccessibilityEvent
        implements Runnable {

        public void run() {
            if(mSource != null) {
                mSource.sendAccessibilityEvent(2048);
                mSource.resetAccessibilityStateChanged();
                mSource = null;
            }
        }

        public View mSource;
        final ViewRootImpl this$0;

        private SendWindowContentChangedAccessibilityEvent() {
            this$0 = ViewRootImpl.this;
            super();
        }

    }

    static final class AccessibilityInteractionConnection extends android.view.accessibility.IAccessibilityInteractionConnection.Stub {

        public void findAccessibilityNodeInfoByAccessibilityId(long l, int i, int j, int k, IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback, int i1, 
                int j1, long l1) {
            ViewRootImpl viewrootimpl = (ViewRootImpl)mViewRootImpl.get();
            if(viewrootimpl != null && viewrootimpl.mView != null)
                viewrootimpl.getAccessibilityInteractionController().findAccessibilityNodeInfoByAccessibilityIdClientThread(l, i, j, k, iaccessibilityinteractionconnectioncallback, i1, j1, l1);
            else
                try {
                    iaccessibilityinteractionconnectioncallback.setFindAccessibilityNodeInfosResult(null, k);
                }
                catch(RemoteException remoteexception) { }
        }

        public void findAccessibilityNodeInfoByViewId(long l, int i, int j, int k, int i1, IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback, 
                int j1, int k1, long l1) {
            ViewRootImpl viewrootimpl = (ViewRootImpl)mViewRootImpl.get();
            if(viewrootimpl != null && viewrootimpl.mView != null)
                viewrootimpl.getAccessibilityInteractionController().findAccessibilityNodeInfoByViewIdClientThread(l, i, j, k, i1, iaccessibilityinteractionconnectioncallback, j1, k1, l1);
            else
                try {
                    iaccessibilityinteractionconnectioncallback.setFindAccessibilityNodeInfoResult(null, i1);
                }
                catch(RemoteException remoteexception) { }
        }

        public void findAccessibilityNodeInfosByText(long l, String s, int i, int j, int k, IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback, 
                int i1, int j1, long l1) {
            ViewRootImpl viewrootimpl = (ViewRootImpl)mViewRootImpl.get();
            if(viewrootimpl != null && viewrootimpl.mView != null)
                viewrootimpl.getAccessibilityInteractionController().findAccessibilityNodeInfosByTextClientThread(l, s, i, j, k, iaccessibilityinteractionconnectioncallback, i1, j1, l1);
            else
                try {
                    iaccessibilityinteractionconnectioncallback.setFindAccessibilityNodeInfosResult(null, k);
                }
                catch(RemoteException remoteexception) { }
        }

        public void findFocus(long l, int i, int j, int k, int i1, IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback, 
                int j1, int k1, long l1) {
            ViewRootImpl viewrootimpl = (ViewRootImpl)mViewRootImpl.get();
            if(viewrootimpl != null && viewrootimpl.mView != null)
                viewrootimpl.getAccessibilityInteractionController().findFocusClientThread(l, i, j, k, i1, iaccessibilityinteractionconnectioncallback, j1, k1, l1);
            else
                try {
                    iaccessibilityinteractionconnectioncallback.setFindAccessibilityNodeInfoResult(null, i1);
                }
                catch(RemoteException remoteexception) { }
        }

        public void focusSearch(long l, int i, int j, int k, int i1, IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback, 
                int j1, int k1, long l1) {
            ViewRootImpl viewrootimpl = (ViewRootImpl)mViewRootImpl.get();
            if(viewrootimpl != null && viewrootimpl.mView != null)
                viewrootimpl.getAccessibilityInteractionController().focusSearchClientThread(l, i, j, k, i1, iaccessibilityinteractionconnectioncallback, j1, k1, l1);
            else
                try {
                    iaccessibilityinteractionconnectioncallback.setFindAccessibilityNodeInfoResult(null, i1);
                }
                catch(RemoteException remoteexception) { }
        }

        public void performAccessibilityAction(long l, int i, Bundle bundle, int j, IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback, int k, 
                int i1, long l1) {
            ViewRootImpl viewrootimpl = (ViewRootImpl)mViewRootImpl.get();
            if(viewrootimpl != null && viewrootimpl.mView != null)
                viewrootimpl.getAccessibilityInteractionController().performAccessibilityActionClientThread(l, i, bundle, j, iaccessibilityinteractionconnectioncallback, k, i1, l1);
            else
                try {
                    iaccessibilityinteractionconnectioncallback.setPerformAccessibilityActionResult(false, j);
                }
                catch(RemoteException remoteexception) { }
        }

        private final WeakReference mViewRootImpl;

        AccessibilityInteractionConnection(ViewRootImpl viewrootimpl) {
            mViewRootImpl = new WeakReference(viewrootimpl);
        }
    }

    final class AccessibilityInteractionConnectionManager
        implements android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener {

        public void ensureConnection() {
            if(mAttachInfo != null) {
                boolean flag;
                if(mAttachInfo.mAccessibilityWindowId != -1)
                    flag = true;
                else
                    flag = false;
                if(!flag)
                    mAttachInfo.mAccessibilityWindowId = mAccessibilityManager.addAccessibilityInteractionConnection(mWindow, new AccessibilityInteractionConnection(ViewRootImpl.this));
            }
        }

        public void ensureNoConnection() {
            boolean flag;
            if(mAttachInfo.mAccessibilityWindowId != -1)
                flag = true;
            else
                flag = false;
            if(flag) {
                mAttachInfo.mAccessibilityWindowId = -1;
                mAccessibilityManager.removeAccessibilityInteractionConnection(mWindow);
            }
        }

        public void onAccessibilityStateChanged(boolean flag) {
            if(flag) {
                ensureConnection();
                if(mAttachInfo != null && mAttachInfo.mHasWindowFocus) {
                    mView.sendAccessibilityEvent(32);
                    View view = mView.findFocus();
                    if(view != null && view != mView)
                        view.sendAccessibilityEvent(8);
                }
            } else {
                ensureNoConnection();
                mHandler.obtainMessage(22).sendToTarget();
            }
        }

        final ViewRootImpl this$0;

        AccessibilityInteractionConnectionManager() {
            this$0 = ViewRootImpl.this;
            super();
        }
    }

    static final class RunQueue {
        private static class HandlerAction {

            public boolean equals(Object obj) {
                boolean flag = true;
                if(this != obj) goto _L2; else goto _L1
_L1:
                return flag;
_L2:
                if(obj == null || getClass() != obj.getClass()) {
                    flag = false;
                } else {
                    HandlerAction handleraction = (HandlerAction)obj;
                    if(action == null ? handleraction.action != null : !action.equals(handleraction.action))
                        flag = false;
                }
                if(true) goto _L1; else goto _L3
_L3:
            }

            public int hashCode() {
                int i;
                if(action != null)
                    i = action.hashCode();
                else
                    i = 0;
                return i * 31 + (int)(delay ^ delay >>> 32);
            }

            Runnable action;
            long delay;

            private HandlerAction() {
            }

        }


        void executeActions(Handler handler) {
            ArrayList arraylist = mActions;
            arraylist;
            JVM INSTR monitorenter ;
            ArrayList arraylist1 = mActions;
            int i = arraylist1.size();
            for(int j = 0; j < i; j++) {
                HandlerAction handleraction = (HandlerAction)arraylist1.get(j);
                handler.postDelayed(handleraction.action, handleraction.delay);
            }

            arraylist1.clear();
            return;
        }

        void post(Runnable runnable) {
            postDelayed(runnable, 0L);
        }

        void postDelayed(Runnable runnable, long l) {
            HandlerAction handleraction;
            handleraction = new HandlerAction();
            handleraction.action = runnable;
            handleraction.delay = l;
            ArrayList arraylist = mActions;
            arraylist;
            JVM INSTR monitorenter ;
            mActions.add(handleraction);
            return;
        }

        void removeCallbacks(Runnable runnable) {
            HandlerAction handleraction;
            handleraction = new HandlerAction();
            handleraction.action = runnable;
            ArrayList arraylist = mActions;
            arraylist;
            JVM INSTR monitorenter ;
            for(ArrayList arraylist1 = mActions; arraylist1.remove(handleraction););
            return;
        }

        private final ArrayList mActions = new ArrayList();

        RunQueue() {
        }
    }

    public static final class CalledFromWrongThreadException extends AndroidRuntimeException {

        public CalledFromWrongThreadException(String s) {
            super(s);
        }
    }

    static final class TrackballAxis {

        float collect(float f, long l, String s) {
            long l1;
            if(f > 0.0F) {
                l1 = (long)(150F * f);
                if(dir < 0) {
                    position = 0.0F;
                    step = 0;
                    acceleration = 1.0F;
                    lastMoveTime = 0L;
                }
                dir = 1;
            } else
            if(f < 0.0F) {
                l1 = (long)(150F * -f);
                if(dir > 0) {
                    position = 0.0F;
                    step = 0;
                    acceleration = 1.0F;
                    lastMoveTime = 0L;
                }
                dir = -1;
            } else {
                l1 = 0L;
            }
            if(l1 > 0L) {
                long l2 = l - lastMoveTime;
                lastMoveTime = l;
                float f2 = acceleration;
                if(l2 < l1) {
                    float f4 = 0.025F * (float)(l1 - l2);
                    if(f4 > 1.0F)
                        f2 *= f4;
                    float f1;
                    if(f2 >= 20F)
                        f2 = 20F;
                    acceleration = f2;
                } else {
                    float f3 = 0.025F * (float)(l2 - l1);
                    if(f3 > 1.0F)
                        f2 /= f3;
                    if(f2 <= 1.0F)
                        f2 = 1.0F;
                    acceleration = f2;
                }
            }
            position = f + position;
            f1 = Math.abs(position);
            absPosition = f1;
            return f1;
        }

        int generate(float f) {
            int i;
            i = 0;
            nonAccelMovement = 0;
_L7:
            byte byte0;
            if(position >= 0.0F)
                byte0 = 1;
            else
                byte0 = -1;
            step;
            JVM INSTR tableswitch 0 1: default 44
        //                       0 61
        //                       1 92;
               goto _L1 _L2 _L3
_L1:
            if(absPosition >= 1.0F) goto _L5; else goto _L4
_L4:
            return i;
_L2:
            if(absPosition >= f) {
                i += byte0;
                nonAccelMovement = byte0 + nonAccelMovement;
                step = 1;
                continue; /* Loop/switch isn't completed */
            }
            continue; /* Loop/switch isn't completed */
_L3:
            if(absPosition >= 2.0F) {
                i += byte0;
                nonAccelMovement = byte0 + nonAccelMovement;
                float f1 = position;
                float f2;
                if(byte0 > 0)
                    f2 = -2F;
                else
                    f2 = 2.0F;
                position = f2 + f1;
                absPosition = Math.abs(position);
                step = 2;
                continue; /* Loop/switch isn't completed */
            }
            if(true) goto _L4; else goto _L5
_L5:
            i += byte0;
            float f3 = position;
            float f4;
            float f5;
            if(byte0 >= 0)
                f4 = -1F;
            else
                f4 = 1.0F;
            position = f4 + f3;
            absPosition = Math.abs(position);
            f5 = 1.1F * acceleration;
            if(f5 >= 20F)
                f5 = acceleration;
            acceleration = f5;
            if(true) goto _L7; else goto _L6
_L6:
        }

        void reset(int i) {
            position = 0.0F;
            acceleration = 1.0F;
            lastMoveTime = 0L;
            step = i;
            dir = 0;
        }

        static final float ACCEL_MOVE_SCALING_FACTOR = 0.025F;
        static final long FAST_MOVE_TIME = 150L;
        static final float MAX_ACCELERATION = 20F;
        float absPosition;
        float acceleration;
        int dir;
        long lastMoveTime;
        int nonAccelMovement;
        float position;
        int step;

        TrackballAxis() {
            acceleration = 1.0F;
            lastMoveTime = 0L;
        }
    }

    static class W extends IWindow.Stub {

        private static int checkCallingPermission(String s) {
            int j = ActivityManagerNative.getDefault().checkPermission(s, Binder.getCallingPid(), Binder.getCallingUid());
            int i = j;
_L2:
            return i;
            RemoteException remoteexception;
            remoteexception;
            i = -1;
            if(true) goto _L2; else goto _L1
_L1:
        }

        public void closeSystemDialogs(String s) {
            ViewRootImpl viewrootimpl = (ViewRootImpl)mViewAncestor.get();
            if(viewrootimpl != null)
                viewrootimpl.dispatchCloseSystemDialogs(s);
        }

        public void dispatchAppVisibility(boolean flag) {
            ViewRootImpl viewrootimpl = (ViewRootImpl)mViewAncestor.get();
            if(viewrootimpl != null)
                viewrootimpl.dispatchAppVisibility(flag);
        }

        public void dispatchDragEvent(DragEvent dragevent) {
            ViewRootImpl viewrootimpl = (ViewRootImpl)mViewAncestor.get();
            if(viewrootimpl != null)
                viewrootimpl.dispatchDragEvent(dragevent);
        }

        public void dispatchGetNewSurface() {
            ViewRootImpl viewrootimpl = (ViewRootImpl)mViewAncestor.get();
            if(viewrootimpl != null)
                viewrootimpl.dispatchGetNewSurface();
        }

        public void dispatchScreenState(boolean flag) {
            ViewRootImpl viewrootimpl = (ViewRootImpl)mViewAncestor.get();
            if(viewrootimpl != null)
                viewrootimpl.dispatchScreenStateChange(flag);
        }

        public void dispatchSystemUiVisibilityChanged(int i, int j, int k, int l) {
            ViewRootImpl viewrootimpl = (ViewRootImpl)mViewAncestor.get();
            if(viewrootimpl != null)
                viewrootimpl.dispatchSystemUiVisibilityChanged(i, j, k, l);
        }

        public void dispatchWallpaperCommand(String s, int i, int j, int k, Bundle bundle, boolean flag) {
            if(!flag)
                break MISSING_BLOCK_LABEL_18;
            ViewRootImpl.sWindowSession.wallpaperCommandComplete(asBinder(), null);
_L2:
            return;
            RemoteException remoteexception;
            remoteexception;
            if(true) goto _L2; else goto _L1
_L1:
        }

        public void dispatchWallpaperOffsets(float f, float f1, float f2, float f3, boolean flag) {
            if(!flag)
                break MISSING_BLOCK_LABEL_17;
            ViewRootImpl.sWindowSession.wallpaperOffsetsComplete(asBinder());
_L2:
            return;
            RemoteException remoteexception;
            remoteexception;
            if(true) goto _L2; else goto _L1
_L1:
        }

        public void doneAnimating() {
            ViewRootImpl viewrootimpl = (ViewRootImpl)mViewAncestor.get();
            if(viewrootimpl != null)
                viewrootimpl.dispatchDoneAnimating();
        }

        public void executeCommand(String s, String s1, ParcelFileDescriptor parcelfiledescriptor) {
            View view;
            android.os.ParcelFileDescriptor.AutoCloseOutputStream autocloseoutputstream;
            ViewRootImpl viewrootimpl = (ViewRootImpl)mViewAncestor.get();
            if(viewrootimpl == null)
                break MISSING_BLOCK_LABEL_109;
            view = viewrootimpl.mView;
            if(view == null)
                break MISSING_BLOCK_LABEL_109;
            if(checkCallingPermission("android.permission.DUMP") != 0)
                throw new SecurityException((new StringBuilder()).append("Insufficient permissions to invoke executeCommand() from pid=").append(Binder.getCallingPid()).append(", uid=").append(Binder.getCallingUid()).toString());
            autocloseoutputstream = null;
            android.os.ParcelFileDescriptor.AutoCloseOutputStream autocloseoutputstream1 = new android.os.ParcelFileDescriptor.AutoCloseOutputStream(parcelfiledescriptor);
            ViewDebug.dispatchCommand(view, s, s1, autocloseoutputstream1);
            if(autocloseoutputstream1 == null)
                break MISSING_BLOCK_LABEL_109;
            autocloseoutputstream1.close();
_L2:
            return;
            IOException ioexception;
            ioexception;
_L5:
            ioexception.printStackTrace();
            if(autocloseoutputstream == null) goto _L2; else goto _L1
_L1:
            autocloseoutputstream.close();
              goto _L2
            IOException ioexception2;
            ioexception2;
_L3:
            ioexception2.printStackTrace();
              goto _L2
            Exception exception;
            exception;
_L4:
            if(autocloseoutputstream != null)
                try {
                    autocloseoutputstream.close();
                }
                catch(IOException ioexception1) {
                    ioexception1.printStackTrace();
                }
            throw exception;
            ioexception2;
              goto _L3
            exception;
            autocloseoutputstream = autocloseoutputstream1;
              goto _L4
            ioexception;
            autocloseoutputstream = autocloseoutputstream1;
              goto _L5
        }

        public void resized(int i, int j, Rect rect, Rect rect1, boolean flag, Configuration configuration) {
            ViewRootImpl viewrootimpl = (ViewRootImpl)mViewAncestor.get();
            if(viewrootimpl != null)
                viewrootimpl.dispatchResized(i, j, rect, rect1, flag, configuration);
        }

        public void windowFocusChanged(boolean flag, boolean flag1) {
            ViewRootImpl viewrootimpl = (ViewRootImpl)mViewAncestor.get();
            if(viewrootimpl != null)
                viewrootimpl.windowFocusChanged(flag, flag1);
        }

        private final WeakReference mViewAncestor;

        W(ViewRootImpl viewrootimpl) {
            mViewAncestor = new WeakReference(viewrootimpl);
        }
    }

    static class InputMethodCallback extends com.android.internal.view.IInputMethodCallback.Stub {

        public void finishedEvent(int i, boolean flag) {
            ViewRootImpl viewrootimpl = (ViewRootImpl)mViewAncestor.get();
            if(viewrootimpl != null)
                viewrootimpl.dispatchImeFinishedEvent(i, flag);
        }

        public void sessionCreated(IInputMethodSession iinputmethodsession) {
        }

        private WeakReference mViewAncestor;

        public InputMethodCallback(ViewRootImpl viewrootimpl) {
            mViewAncestor = new WeakReference(viewrootimpl);
        }
    }

    class TakenSurfaceHolder extends BaseSurfaceHolder {

        public boolean isCreating() {
            return mIsCreating;
        }

        public boolean onAllowLockCanvas() {
            return mDrawingAllowed;
        }

        public void onRelayoutContainer() {
        }

        public void onUpdateSurface() {
            throw new IllegalStateException("Shouldn't be here");
        }

        public void setFixedSize(int i, int j) {
            throw new UnsupportedOperationException("Currently only support sizing from layout");
        }

        public void setFormat(int i) {
            ((RootViewSurfaceTaker)mView).setSurfaceFormat(i);
        }

        public void setKeepScreenOn(boolean flag) {
            ((RootViewSurfaceTaker)mView).setSurfaceKeepScreenOn(flag);
        }

        public void setType(int i) {
            ((RootViewSurfaceTaker)mView).setSurfaceType(i);
        }

        final ViewRootImpl this$0;

        TakenSurfaceHolder() {
            this$0 = ViewRootImpl.this;
            super();
        }
    }

    final class InvalidateOnAnimationRunnable
        implements Runnable {

        private void postIfNeededLocked() {
            if(!mPosted) {
                mChoreographer.postCallback(1, this, null);
                mPosted = true;
            }
        }

        public void addView(View view) {
            this;
            JVM INSTR monitorenter ;
            mViews.add(view);
            postIfNeededLocked();
            return;
        }

        public void addViewRect(View.AttachInfo.InvalidateInfo invalidateinfo) {
            this;
            JVM INSTR monitorenter ;
            mViewRects.add(invalidateinfo);
            postIfNeededLocked();
            return;
        }

        public void removeView(View view) {
            this;
            JVM INSTR monitorenter ;
            mViews.remove(view);
            int i = mViewRects.size();
            do {
                int j = i - 1;
                if(i > 0) {
                    View.AttachInfo.InvalidateInfo invalidateinfo = (View.AttachInfo.InvalidateInfo)mViewRects.get(j);
                    if(invalidateinfo.target == view) {
                        mViewRects.remove(j);
                        invalidateinfo.release();
                    }
                } else {
                    if(mPosted && mViews.isEmpty() && mViewRects.isEmpty()) {
                        mChoreographer.removeCallbacks(1, this, null);
                        mPosted = false;
                    }
                    return;
                }
                i = j;
            } while(true);
        }

        public void run() {
            this;
            JVM INSTR monitorenter ;
            int i;
            mPosted = false;
            i = mViews.size();
            if(i == 0) goto _L2; else goto _L1
_L1:
            ArrayList arraylist1 = mViews;
            if(mTempViews == null) goto _L4; else goto _L3
_L3:
            View aview[] = mTempViews;
_L9:
            mTempViews = (View[])arraylist1.toArray(aview);
            mViews.clear();
_L2:
            int j = mViewRects.size();
            if(j == 0) goto _L6; else goto _L5
_L5:
            ArrayList arraylist = mViewRects;
            if(mTempViewRects == null) goto _L8; else goto _L7
_L7:
            View.AttachInfo.InvalidateInfo ainvalidateinfo[] = mTempViewRects;
_L10:
            mTempViewRects = (View.AttachInfo.InvalidateInfo[])arraylist.toArray(ainvalidateinfo);
            mViewRects.clear();
_L6:
            this;
            JVM INSTR monitorexit ;
            for(int k = 0; k < i; k++) {
                mTempViews[k].invalidate();
                mTempViews[k] = null;
            }

            break MISSING_BLOCK_LABEL_169;
_L4:
            aview = new View[i];
              goto _L9
_L8:
            ainvalidateinfo = new View.AttachInfo.InvalidateInfo[j];
              goto _L10
            Exception exception;
            exception;
            throw exception;
            for(int l = 0; l < j; l++) {
                View.AttachInfo.InvalidateInfo invalidateinfo = mTempViewRects[l];
                invalidateinfo.target.invalidate(invalidateinfo.left, invalidateinfo.top, invalidateinfo.right, invalidateinfo.bottom);
                invalidateinfo.release();
            }

            return;
              goto _L9
        }

        private boolean mPosted;
        private View.AttachInfo.InvalidateInfo mTempViewRects[];
        private View mTempViews[];
        private ArrayList mViewRects;
        private ArrayList mViews;
        final ViewRootImpl this$0;

        InvalidateOnAnimationRunnable() {
            this$0 = ViewRootImpl.this;
            super();
            mViews = new ArrayList();
            mViewRects = new ArrayList();
        }
    }

    final class ConsumeBatchedInputRunnable
        implements Runnable {

        public void run() {
            doConsumeBatchedInput(mChoreographer.getFrameTimeNanos());
        }

        final ViewRootImpl this$0;

        ConsumeBatchedInputRunnable() {
            this$0 = ViewRootImpl.this;
            super();
        }
    }

    final class WindowInputEventReceiver extends InputEventReceiver {

        public void dispose() {
            unscheduleConsumeBatchedInput();
            super.dispose();
        }

        public void onBatchedInputEventPending() {
            scheduleConsumeBatchedInput();
        }

        public void onInputEvent(InputEvent inputevent) {
            enqueueInputEvent(inputevent, this, 0, true);
        }

        final ViewRootImpl this$0;

        public WindowInputEventReceiver(InputChannel inputchannel, Looper looper) {
            this$0 = ViewRootImpl.this;
            super(inputchannel, looper);
        }
    }

    final class TraversalRunnable
        implements Runnable {

        public void run() {
            doTraversal();
        }

        final ViewRootImpl this$0;

        TraversalRunnable() {
            this$0 = ViewRootImpl.this;
            super();
        }
    }

    private static final class QueuedInputEvent {

        public static final int FLAG_DELIVER_POST_IME = 1;
        public InputEvent mEvent;
        public int mFlags;
        public QueuedInputEvent mNext;
        public InputEventReceiver mReceiver;

        private QueuedInputEvent() {
        }

    }

    final class ViewRootHandler extends Handler {

        public String getMessageName(Message message) {
            message.what;
            JVM INSTR tableswitch 1 23: default 112
        //                       1 120
        //                       2 126
        //                       3 132
        //                       4 138
        //                       5 144
        //                       6 150
        //                       7 156
        //                       8 162
        //                       9 168
        //                       10 174
        //                       11 180
        //                       12 186
        //                       13 192
        //                       14 198
        //                       15 204
        //                       16 210
        //                       17 216
        //                       18 222
        //                       19 228
        //                       20 234
        //                       21 240
        //                       22 246
        //                       23 252;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24
_L1:
            String s = super.getMessageName(message);
_L26:
            return s;
_L2:
            s = "MSG_INVALIDATE";
            continue; /* Loop/switch isn't completed */
_L3:
            s = "MSG_INVALIDATE_RECT";
            continue; /* Loop/switch isn't completed */
_L4:
            s = "MSG_DIE";
            continue; /* Loop/switch isn't completed */
_L5:
            s = "MSG_RESIZED";
            continue; /* Loop/switch isn't completed */
_L6:
            s = "MSG_RESIZED_REPORT";
            continue; /* Loop/switch isn't completed */
_L7:
            s = "MSG_WINDOW_FOCUS_CHANGED";
            continue; /* Loop/switch isn't completed */
_L8:
            s = "MSG_DISPATCH_KEY";
            continue; /* Loop/switch isn't completed */
_L9:
            s = "MSG_DISPATCH_APP_VISIBILITY";
            continue; /* Loop/switch isn't completed */
_L10:
            s = "MSG_DISPATCH_GET_NEW_SURFACE";
            continue; /* Loop/switch isn't completed */
_L11:
            s = "MSG_IME_FINISHED_EVENT";
            continue; /* Loop/switch isn't completed */
_L12:
            s = "MSG_DISPATCH_KEY_FROM_IME";
            continue; /* Loop/switch isn't completed */
_L13:
            s = "MSG_FINISH_INPUT_CONNECTION";
            continue; /* Loop/switch isn't completed */
_L14:
            s = "MSG_CHECK_FOCUS";
            continue; /* Loop/switch isn't completed */
_L15:
            s = "MSG_CLOSE_SYSTEM_DIALOGS";
            continue; /* Loop/switch isn't completed */
_L16:
            s = "MSG_DISPATCH_DRAG_EVENT";
            continue; /* Loop/switch isn't completed */
_L17:
            s = "MSG_DISPATCH_DRAG_LOCATION_EVENT";
            continue; /* Loop/switch isn't completed */
_L18:
            s = "MSG_DISPATCH_SYSTEM_UI_VISIBILITY";
            continue; /* Loop/switch isn't completed */
_L19:
            s = "MSG_UPDATE_CONFIGURATION";
            continue; /* Loop/switch isn't completed */
_L20:
            s = "MSG_PROCESS_INPUT_EVENTS";
            continue; /* Loop/switch isn't completed */
_L21:
            s = "MSG_DISPATCH_SCREEN_STATE";
            continue; /* Loop/switch isn't completed */
_L22:
            s = "MSG_INVALIDATE_DISPLAY_LIST";
            continue; /* Loop/switch isn't completed */
_L23:
            s = "MSG_CLEAR_ACCESSIBILITY_FOCUS_HOST";
            continue; /* Loop/switch isn't completed */
_L24:
            s = "MSG_DISPATCH_DONE_ANIMATING";
            if(true) goto _L26; else goto _L25
_L25:
        }

        public void handleMessage(Message message) {
            message.what;
            JVM INSTR tableswitch 1 24: default 116
        //                       1 117
        //                       2 130
        //                       3 1083
        //                       4 275
        //                       5 380
        //                       6 553
        //                       7 1093
        //                       8 233
        //                       9 265
        //                       10 175
        //                       11 1117
        //                       12 1167
        //                       13 1192
        //                       14 1210
        //                       15 1240
        //                       16 1240
        //                       17 1273
        //                       18 1290
        //                       19 215
        //                       20 1336
        //                       21 1374
        //                       22 1384
        //                       23 1396
        //                       24 1406;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24
_L1:
            return;
_L2:
            ((View)message.obj).invalidate();
            continue; /* Loop/switch isn't completed */
_L3:
            View.AttachInfo.InvalidateInfo invalidateinfo = (View.AttachInfo.InvalidateInfo)message.obj;
            invalidateinfo.target.invalidate(invalidateinfo.left, invalidateinfo.top, invalidateinfo.right, invalidateinfo.bottom);
            invalidateinfo.release();
            continue; /* Loop/switch isn't completed */
_L11:
            ViewRootImpl viewrootimpl2 = ViewRootImpl.this;
            int j = message.arg1;
            boolean flag5;
            if(message.arg2 != 0)
                flag5 = true;
            else
                flag5 = false;
            viewrootimpl2.handleImeFinishedEvent(j, flag5);
            continue; /* Loop/switch isn't completed */
_L19:
            mProcessInputEventsScheduled = false;
            doProcessInputEvents();
            continue; /* Loop/switch isn't completed */
_L9:
            ViewRootImpl viewrootimpl1 = ViewRootImpl.this;
            boolean flag4;
            if(message.arg1 != 0)
                flag4 = true;
            else
                flag4 = false;
            viewrootimpl1.handleAppVisibility(flag4);
            continue; /* Loop/switch isn't completed */
_L10:
            handleGetNewSurface();
            continue; /* Loop/switch isn't completed */
_L5:
            ResizedInfo resizedinfo = (ResizedInfo)message.obj;
            if(tryToSkipResizedMsg(resizedinfo, message) || mWinFrame.width() == message.arg1 && mWinFrame.height() == message.arg2 && mPendingContentInsets.equals(resizedinfo.contentInsets) && mPendingVisibleInsets.equals(resizedinfo.visibleInsets) && ((ResizedInfo)message.obj).newConfig == null)
                continue; /* Loop/switch isn't completed */
_L6:
            if(mAdded) {
                Configuration configuration1 = ((ResizedInfo)message.obj).newConfig;
                if(configuration1 != null)
                    updateConfiguration(configuration1, false);
                mWinFrame.left = 0;
                mWinFrame.right = message.arg1;
                mWinFrame.top = 0;
                mWinFrame.bottom = message.arg2;
                mPendingContentInsets.set(((ResizedInfo)message.obj).contentInsets);
                mPendingVisibleInsets.set(((ResizedInfo)message.obj).visibleInsets);
                if(message.what == 5)
                    mReportNextDraw = true;
                if(mView != null)
                    ViewRootImpl.forceLayout(mView);
                requestLayout();
            }
            continue; /* Loop/switch isn't completed */
_L7:
            if(!mAdded)
                continue; /* Loop/switch isn't completed */
            boolean flag1;
            if(message.arg1 != 0)
                flag1 = true;
            else
                flag1 = false;
            mAttachInfo.mHasWindowFocus = flag1;
            profileRendering(flag1);
            if(flag1) {
                boolean flag3;
                if(message.arg2 != 0)
                    flag3 = true;
                else
                    flag3 = false;
                ensureTouchModeLocally(flag3);
                if(mAttachInfo.mHardwareRenderer != null && mSurface != null && mSurface.isValid()) {
                    mFullRedrawNeeded = true;
                    InputMethodManager inputmethodmanager2;
                    WindowManager.LayoutParams layoutparams;
                    WindowManager.LayoutParams layoutparams1;
                    View view;
                    View view1;
                    int i;
                    boolean flag2;
                    try {
                        mAttachInfo.mHardwareRenderer.initializeIfNeeded(mWidth, mHeight, mHolder);
                    }
                    catch(Surface.OutOfResourcesException outofresourcesexception) {
                        Log.e("ViewRootImpl", "OutOfResourcesException locking surface", outofresourcesexception);
                        ViewRootImpl viewrootimpl;
                        boolean flag;
                        Configuration configuration;
                        DragEvent dragevent;
                        InputMethodManager inputmethodmanager;
                        InputMethodManager inputmethodmanager1;
                        KeyEvent keyevent;
                        KeyEvent keyevent1;
                        try {
                            if(!ViewRootImpl.sWindowSession.outOfMemory(mWindow)) {
                                Slog.w("ViewRootImpl", "No processes killed for memory; killing self");
                                Process.killProcess(Process.myPid());
                            }
                        }
                        catch(RemoteException remoteexception) { }
                        sendMessageDelayed(obtainMessage(message.what, message.arg1, message.arg2), 500L);
                        continue; /* Loop/switch isn't completed */
                    }
                }
            }
            mLastWasImTarget = WindowManager.LayoutParams.mayUseInputMethod(mWindowAttributes.flags);
            inputmethodmanager2 = InputMethodManager.peekInstance();
            if(mView != null) {
                if(flag1 && inputmethodmanager2 != null && mLastWasImTarget)
                    inputmethodmanager2.startGettingWindowFocus(mView);
                mAttachInfo.mKeyDispatchState.reset();
                mView.dispatchWindowFocusChanged(flag1);
            }
            if(flag1) {
                if(inputmethodmanager2 != null && mLastWasImTarget) {
                    view = mView;
                    view1 = mView.findFocus();
                    i = mWindowAttributes.softInputMode;
                    if(!mHasHadWindowFocus)
                        flag2 = true;
                    else
                        flag2 = false;
                    inputmethodmanager2.onWindowFocus(view, view1, i, flag2, mWindowAttributes.flags);
                }
                layoutparams = mWindowAttributes;
                layoutparams.softInputMode = 0xfffffeff & layoutparams.softInputMode;
                layoutparams1 = (WindowManager.LayoutParams)mView.getLayoutParams();
                layoutparams1.softInputMode = 0xfffffeff & layoutparams1.softInputMode;
                mHasHadWindowFocus = true;
            }
            setAccessibilityFocus(null, null);
            if(mView != null && mAccessibilityManager.isEnabled() && flag1)
                mView.sendAccessibilityEvent(32);
            continue; /* Loop/switch isn't completed */
_L4:
            doDie();
            continue; /* Loop/switch isn't completed */
_L8:
            keyevent1 = (KeyEvent)message.obj;
            enqueueInputEvent(keyevent1, null, 0, true);
            continue; /* Loop/switch isn't completed */
_L12:
            keyevent = (KeyEvent)message.obj;
            if((8 & keyevent.getFlags()) != 0)
                keyevent = KeyEvent.changeFlags(keyevent, -9 & keyevent.getFlags());
            enqueueInputEvent(keyevent, null, 1, true);
            continue; /* Loop/switch isn't completed */
_L13:
            inputmethodmanager1 = InputMethodManager.peekInstance();
            if(inputmethodmanager1 != null)
                inputmethodmanager1.reportFinishInputConnection((InputConnection)message.obj);
            continue; /* Loop/switch isn't completed */
_L14:
            inputmethodmanager = InputMethodManager.peekInstance();
            if(inputmethodmanager != null)
                inputmethodmanager.checkFocus();
            continue; /* Loop/switch isn't completed */
_L15:
            if(mView != null)
                mView.onCloseSystemDialogs((String)message.obj);
            continue; /* Loop/switch isn't completed */
_L16:
            dragevent = (DragEvent)message.obj;
            dragevent.mLocalState = mLocalDragState;
            handleDragEvent(dragevent);
            continue; /* Loop/switch isn't completed */
_L17:
            handleDispatchSystemUiVisibilityChanged((SystemUiVisibilityInfo)message.obj);
            continue; /* Loop/switch isn't completed */
_L18:
            configuration = (Configuration)message.obj;
            if(configuration.isOtherSeqNewer(mLastConfiguration))
                configuration = mLastConfiguration;
            updateConfiguration(configuration, false);
            continue; /* Loop/switch isn't completed */
_L20:
            if(mView != null) {
                viewrootimpl = ViewRootImpl.this;
                if(message.arg1 == 1)
                    flag = true;
                else
                    flag = false;
                viewrootimpl.handleScreenStateChange(flag);
            }
            continue; /* Loop/switch isn't completed */
_L21:
            invalidateDisplayLists();
            continue; /* Loop/switch isn't completed */
_L22:
            setAccessibilityFocus(null, null);
            continue; /* Loop/switch isn't completed */
_L23:
            handleDispatchDoneAnimating();
            continue; /* Loop/switch isn't completed */
_L24:
            invalidateWorld(mView);
            if(true) goto _L1; else goto _L25
_L25:
        }

        final ViewRootImpl this$0;

        ViewRootHandler() {
            this$0 = ViewRootImpl.this;
            super();
        }
    }

    static final class SystemUiVisibilityInfo {

        int globalVisibility;
        int localChanges;
        int localValue;
        int seq;

        SystemUiVisibilityInfo() {
        }
    }

    class ResizedInfo {

        Rect contentInsets;
        Configuration newConfig;
        final ViewRootImpl this$0;
        Rect visibleInsets;

        ResizedInfo() {
            this$0 = ViewRootImpl.this;
            super();
        }
    }


    public ViewRootImpl(Context context) {
        mLastTrackballTime = 0L;
        mAppVisible = true;
        mOrigWindowType = -1;
        mStopped = false;
        mLastInCompatMode = false;
        mWindowAttributesChanged = false;
        mWindowAttributesChangesFlag = 0;
        mFpsStartTime = -1L;
        mFpsPrevTime = -1L;
        mSkipResizedMsg = false;
        InputEventConsistencyVerifier inputeventconsistencyverifier;
        PowerManager powermanager;
        if(InputEventConsistencyVerifier.isInstrumentationEnabled())
            inputeventconsistencyverifier = new InputEventConsistencyVerifier(this, 0);
        else
            inputeventconsistencyverifier = null;
        mInputEventConsistencyVerifier = inputeventconsistencyverifier;
        mProfile = false;
        mHolder = new SurfaceHolder() {

            public void addCallback(SurfaceHolder.Callback callback) {
            }

            public Surface getSurface() {
                return mSurface;
            }

            public Rect getSurfaceFrame() {
                return null;
            }

            public boolean isCreating() {
                return false;
            }

            public Canvas lockCanvas() {
                return null;
            }

            public Canvas lockCanvas(Rect rect) {
                return null;
            }

            public void removeCallback(SurfaceHolder.Callback callback) {
            }

            public void setFixedSize(int i, int j) {
            }

            public void setFormat(int i) {
            }

            public void setKeepScreenOn(boolean flag) {
            }

            public void setSizeFromLayout() {
            }

            public void setType(int i) {
            }

            public void unlockCanvasAndPost(Canvas canvas) {
            }

            final ViewRootImpl this$0;

             {
                this$0 = ViewRootImpl.this;
                super();
            }
        };
        getWindowSession(context.getMainLooper());
        mLocation.fillInStackTrace();
        mWidth = -1;
        mHeight = -1;
        mDirty = new Rect();
        mTargetSdkVersion = context.getApplicationInfo().targetSdkVersion;
        mViewVisibility = 8;
        mFirst = true;
        mAdded = false;
        mAccessibilityManager = AccessibilityManager.getInstance(context);
        mAccessibilityInteractionConnectionManager = new AccessibilityInteractionConnectionManager();
        mAccessibilityManager.addAccessibilityStateChangeListener(mAccessibilityInteractionConnectionManager);
        mAttachInfo = new View.AttachInfo(sWindowSession, mWindow, this, mHandler, this);
        mViewConfiguration = ViewConfiguration.get(context);
        mDensity = context.getResources().getDisplayMetrics().densityDpi;
        mFallbackEventHandler = PolicyManager.makeNewFallbackEventHandler(context);
        mProfileRendering = Boolean.parseBoolean(SystemProperties.get("viewancestor.profile_rendering", "false"));
        mChoreographer = Choreographer.getInstance();
        powermanager = (PowerManager)context.getSystemService("power");
        mAttachInfo.mScreenOn = powermanager.isScreenOn();
        loadSystemProperties();
    }

    public static void addConfigCallback(ComponentCallbacks componentcallbacks) {
        ArrayList arraylist = sConfigCallbacks;
        arraylist;
        JVM INSTR monitorenter ;
        sConfigCallbacks.add(componentcallbacks);
        return;
    }

    public static void addFirstDrawHandler(Runnable runnable) {
        ArrayList arraylist = sFirstDrawHandlers;
        arraylist;
        JVM INSTR monitorenter ;
        if(!sFirstDrawComplete)
            sFirstDrawHandlers.add(runnable);
        return;
    }

    private void applyKeepScreenOnFlag(WindowManager.LayoutParams layoutparams) {
        if(mAttachInfo.mKeepScreenOn)
            layoutparams.flags = 0x80 | layoutparams.flags;
        else
            layoutparams.flags = 0xffffff7f & layoutparams.flags | 0x80 & mClientWindowLayoutFlags;
    }

    private boolean checkForLeavingTouchModeAndConsume(KeyEvent keyevent) {
        boolean flag = false;
        if(mAttachInfo.mInTouchMode) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        int i = keyevent.getAction();
        if((i == 0 || i == 2) && (4 & keyevent.getFlags()) == 0)
            if(isNavigationKey(keyevent))
                flag = ensureTouchMode(false);
            else
            if(isTypingKey(keyevent))
                ensureTouchMode(false);
        if(true) goto _L1; else goto _L3
_L3:
    }

    private boolean collectViewAttributes() {
        boolean flag = false;
        View.AttachInfo attachinfo = mAttachInfo;
        if(attachinfo.mRecomputeGlobalAttributes) {
            attachinfo.mRecomputeGlobalAttributes = false;
            boolean flag1 = attachinfo.mKeepScreenOn;
            int i = attachinfo.mSystemUiVisibility;
            boolean flag2 = attachinfo.mHasSystemUiListeners;
            attachinfo.mKeepScreenOn = false;
            attachinfo.mSystemUiVisibility = 0;
            attachinfo.mHasSystemUiListeners = false;
            mView.dispatchCollectViewAttributes(attachinfo, 0);
            attachinfo.mSystemUiVisibility = attachinfo.mSystemUiVisibility & (-1 ^ attachinfo.mDisabledSystemUiVisibility);
            if(attachinfo.mKeepScreenOn != flag1 || attachinfo.mSystemUiVisibility != i || attachinfo.mHasSystemUiListeners != flag2) {
                WindowManager.LayoutParams layoutparams = mWindowAttributes;
                applyKeepScreenOnFlag(layoutparams);
                layoutparams.subtreeSystemUiVisibility = attachinfo.mSystemUiVisibility;
                layoutparams.hasSystemUiListeners = attachinfo.mHasSystemUiListeners;
                mView.dispatchWindowSystemUiVisiblityChanged(attachinfo.mSystemUiVisibility);
                flag = true;
            }
        }
        return flag;
    }

    private void deliverGenericMotionEvent(QueuedInputEvent queuedinputevent) {
        MotionEvent motionevent = (MotionEvent)queuedinputevent.mEvent;
        if(mInputEventConsistencyVerifier != null)
            mInputEventConsistencyVerifier.onGenericMotionEvent(motionevent, 0);
        boolean flag;
        if((0x10 & motionevent.getSource()) != 0)
            flag = true;
        else
            flag = false;
        if(mView == null || !mAdded) {
            if(flag)
                updateJoystickDirection(motionevent, false);
            finishInputEvent(queuedinputevent, false);
        } else
        if(mView.dispatchGenericMotionEvent(motionevent)) {
            if(flag)
                updateJoystickDirection(motionevent, false);
            finishInputEvent(queuedinputevent, true);
        } else
        if(flag) {
            updateJoystickDirection(motionevent, true);
            finishInputEvent(queuedinputevent, true);
        } else {
            finishInputEvent(queuedinputevent, false);
        }
    }

    private void deliverInputEvent(QueuedInputEvent queuedinputevent) {
        Trace.traceBegin(8L, "deliverInputEvent");
        if(!(queuedinputevent.mEvent instanceof KeyEvent)) goto _L2; else goto _L1
_L1:
        deliverKeyEvent(queuedinputevent);
_L3:
        Trace.traceEnd(8L);
        return;
_L2:
        int i;
        i = queuedinputevent.mEvent.getSource();
        if((i & 2) == 0)
            break MISSING_BLOCK_LABEL_62;
        deliverPointerEvent(queuedinputevent);
          goto _L3
        Exception exception;
        exception;
        Trace.traceEnd(8L);
        throw exception;
        if((i & 4) == 0)
            break MISSING_BLOCK_LABEL_76;
        deliverTrackballEvent(queuedinputevent);
          goto _L3
        deliverGenericMotionEvent(queuedinputevent);
          goto _L3
    }

    private void deliverKeyEvent(QueuedInputEvent queuedinputevent) {
        KeyEvent keyevent;
        keyevent = (KeyEvent)queuedinputevent.mEvent;
        if(mInputEventConsistencyVerifier != null)
            mInputEventConsistencyVerifier.onKeyEvent(keyevent, 0);
        if((1 & queuedinputevent.mFlags) != 0) goto _L2; else goto _L1
_L1:
        if(mView != null && mAdded) goto _L4; else goto _L3
_L3:
        finishInputEvent(queuedinputevent, false);
_L6:
        return;
_L4:
        if(mView.dispatchKeyEventPreIme(keyevent)) {
            finishInputEvent(queuedinputevent, true);
            continue; /* Loop/switch isn't completed */
        }
        if(mLastWasImTarget) {
            InputMethodManager inputmethodmanager = InputMethodManager.peekInstance();
            if(inputmethodmanager != null) {
                int i = keyevent.getSequenceNumber();
                inputmethodmanager.dispatchKeyEvent(mView.getContext(), i, keyevent, mInputMethodCallback);
                continue; /* Loop/switch isn't completed */
            }
        }
_L2:
        deliverKeyEventPostIme(queuedinputevent);
        if(true) goto _L6; else goto _L5
_L5:
    }

    private void deliverKeyEventPostIme(QueuedInputEvent queuedinputevent) {
        KeyEvent keyevent = (KeyEvent)queuedinputevent.mEvent;
        if(mView != null && mAdded) goto _L2; else goto _L1
_L1:
        finishInputEvent(queuedinputevent, false);
_L11:
        return;
_L2:
        int i;
        if(checkForLeavingTouchModeAndConsume(keyevent)) {
            finishInputEvent(queuedinputevent, true);
            continue; /* Loop/switch isn't completed */
        }
        mFallbackEventHandler.preDispatchKeyEvent(keyevent);
        if(mView.dispatchKeyEvent(keyevent)) {
            finishInputEvent(queuedinputevent, true);
            continue; /* Loop/switch isn't completed */
        }
        if(keyevent.getAction() == 0 && keyevent.isCtrlPressed() && keyevent.getRepeatCount() == 0 && !KeyEvent.isModifierKey(keyevent.getKeyCode()) && mView.dispatchKeyShortcutEvent(keyevent)) {
            finishInputEvent(queuedinputevent, true);
            continue; /* Loop/switch isn't completed */
        }
        if(mFallbackEventHandler.dispatchKeyEvent(keyevent)) {
            finishInputEvent(queuedinputevent, true);
            continue; /* Loop/switch isn't completed */
        }
        if(keyevent.getAction() != 0)
            break MISSING_BLOCK_LABEL_431;
        i = 0;
        keyevent.getKeyCode();
        JVM INSTR lookupswitch 5: default 212
    //                   19: 357
    //                   20: 370
    //                   21: 331
    //                   22: 344
    //                   61: 384;
           goto _L3 _L4 _L5 _L6 _L7 _L8
_L3:
        View view;
        if(i == 0)
            break MISSING_BLOCK_LABEL_431;
        view = mView.findFocus();
        if(view == null)
            break MISSING_BLOCK_LABEL_431;
        View view1 = view.focusSearch(i);
        if(view1 != null && view1 != view) {
            view.getFocusedRect(mTempRect);
            if(mView instanceof ViewGroup) {
                ((ViewGroup)mView).offsetDescendantRectToMyCoords(view, mTempRect);
                ((ViewGroup)mView).offsetRectIntoDescendantCoords(view1, mTempRect);
            }
            if(view1.requestFocus(i, mTempRect)) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
                finishInputEvent(queuedinputevent, true);
                continue; /* Loop/switch isn't completed */
            }
        }
        break; /* Loop/switch isn't completed */
_L6:
        if(keyevent.hasNoModifiers())
            i = 17;
        continue; /* Loop/switch isn't completed */
_L7:
        if(keyevent.hasNoModifiers())
            i = 66;
        continue; /* Loop/switch isn't completed */
_L4:
        if(keyevent.hasNoModifiers())
            i = 33;
        continue; /* Loop/switch isn't completed */
_L5:
        if(keyevent.hasNoModifiers())
            i = 130;
        continue; /* Loop/switch isn't completed */
_L8:
        if(keyevent.hasNoModifiers())
            i = 2;
        else
        if(keyevent.hasModifiers(1))
            i = 1;
        if(true) goto _L3; else goto _L9
_L9:
        if(mView.dispatchUnhandledMove(view, i)) {
            finishInputEvent(queuedinputevent, true);
            continue; /* Loop/switch isn't completed */
        }
        finishInputEvent(queuedinputevent, false);
        if(true) goto _L11; else goto _L10
_L10:
    }

    private void deliverPointerEvent(QueuedInputEvent queuedinputevent) {
        MotionEvent motionevent = (MotionEvent)queuedinputevent.mEvent;
        boolean flag = motionevent.isTouchEvent();
        if(mInputEventConsistencyVerifier != null)
            if(flag)
                mInputEventConsistencyVerifier.onTouchEvent(motionevent, 0);
            else
                mInputEventConsistencyVerifier.onGenericMotionEvent(motionevent, 0);
        if(mView == null || !mAdded) {
            finishInputEvent(queuedinputevent, false);
        } else {
            if(mTranslator != null)
                mTranslator.translateEventInScreenToAppWindow(motionevent);
            int i = motionevent.getAction();
            if(i == 0 || i == 8)
                ensureTouchMode(true);
            if(mCurScrollY != 0)
                motionevent.offsetLocation(0.0F, mCurScrollY);
            if(flag) {
                mLastTouchPoint.x = motionevent.getRawX();
                mLastTouchPoint.y = motionevent.getRawY();
            }
            if(mView.dispatchPointerEvent(motionevent))
                finishInputEvent(queuedinputevent, true);
            else
                finishInputEvent(queuedinputevent, false);
        }
    }

    private void deliverTrackballEvent(QueuedInputEvent queuedinputevent) {
        MotionEvent motionevent;
        motionevent = (MotionEvent)queuedinputevent.mEvent;
        if(mInputEventConsistencyVerifier != null)
            mInputEventConsistencyVerifier.onTrackballEvent(motionevent, 0);
        if(mView != null && mAdded) goto _L2; else goto _L1
_L1:
        finishInputEvent(queuedinputevent, false);
_L8:
        return;
_L2:
        TrackballAxis trackballaxis;
        TrackballAxis trackballaxis1;
        long l;
        int i;
        int j;
        if(mView.dispatchTrackballEvent(motionevent)) {
            ensureTouchMode(false);
            finishInputEvent(queuedinputevent, true);
            mLastTrackballTime = 0xffffffff80000000L;
            continue; /* Loop/switch isn't completed */
        }
        trackballaxis = mTrackballAxisX;
        trackballaxis1 = mTrackballAxisY;
        l = SystemClock.uptimeMillis();
        if(250L + mLastTrackballTime < l) {
            trackballaxis.reset(0);
            trackballaxis1.reset(0);
            mLastTrackballTime = l;
        }
        i = motionevent.getAction();
        j = motionevent.getMetaState();
        i;
        JVM INSTR tableswitch 0 1: default 160
    //                   0 398
    //                   1 442;
           goto _L3 _L4 _L5
_L3:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_442;
_L6:
        float f = trackballaxis.collect(motionevent.getX(), motionevent.getEventTime(), "X");
        float f1 = trackballaxis1.collect(motionevent.getY(), motionevent.getEventTime(), "Y");
        byte byte0 = 0;
        int k = 0;
        float f2 = 1.0F;
        if(f > f1) {
            k = trackballaxis.generate(2.0F / motionevent.getXPrecision());
            if(k != 0) {
                int i1;
                int j1;
                if(k > 0)
                    byte0 = 22;
                else
                    byte0 = 21;
                f2 = trackballaxis.acceleration;
                trackballaxis1.reset(2);
            }
        } else
        if(f1 > 0.0F) {
            k = trackballaxis1.generate(2.0F / motionevent.getYPrecision());
            if(k != 0) {
                if(k > 0)
                    byte0 = 20;
                else
                    byte0 = 19;
                f2 = trackballaxis1.acceleration;
                trackballaxis.reset(2);
            }
        }
        if(byte0 == 0)
            break MISSING_BLOCK_LABEL_555;
        if(k < 0)
            k = -k;
        i1 = (int)(f2 * (float)k);
        if(i1 > k) {
            k--;
            j1 = i1 - k;
            enqueueInputEvent(new KeyEvent(l, l, 2, byte0, j1, j, -1, 0, 1024, 257));
        }
        while(k > 0)  {
            k--;
            l = SystemClock.uptimeMillis();
            enqueueInputEvent(new KeyEvent(l, l, 0, byte0, 0, j, -1, 0, 1024, 257));
            enqueueInputEvent(new KeyEvent(l, l, 1, byte0, 0, j, -1, 0, 1024, 257));
        }
        break MISSING_BLOCK_LABEL_549;
_L4:
        trackballaxis.reset(2);
        trackballaxis1.reset(2);
        enqueueInputEvent(new KeyEvent(l, l, 0, 23, 0, j, -1, 0, 1024, 257));
          goto _L6
        trackballaxis.reset(2);
        trackballaxis1.reset(2);
        enqueueInputEvent(new KeyEvent(l, l, 1, 23, 0, j, -1, 0, 1024, 257));
          goto _L6
        mLastTrackballTime = l;
        finishInputEvent(queuedinputevent, true);
        if(true) goto _L8; else goto _L7
_L7:
    }

    private void destroyHardwareRenderer() {
        View.AttachInfo attachinfo = mAttachInfo;
        HardwareRenderer hardwarerenderer = attachinfo.mHardwareRenderer;
        if(hardwarerenderer != null) {
            if(mView != null)
                hardwarerenderer.destroyHardwareResources(mView);
            hardwarerenderer.destroy(true);
            hardwarerenderer.setRequested(false);
            attachinfo.mHardwareRenderer = null;
            attachinfo.mHardwareAccelerated = false;
        }
    }

    private void draw(boolean flag) {
        Surface surface = mSurface;
        if(surface != null && surface.isValid()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        View.AttachInfo attachinfo;
        boolean flag1;
        int i;
        float f;
        boolean flag2;
        int j;
        Rect rect;
        if(!sFirstDrawComplete)
            synchronized(sFirstDrawHandlers) {
                sFirstDrawComplete = true;
                int k = sFirstDrawHandlers.size();
                for(int i1 = 0; i1 < k; i1++)
                    mHandler.post((Runnable)sFirstDrawHandlers.get(i1));

            }
        scrollToRectOrFocus(null, false);
        attachinfo = mAttachInfo;
        if(attachinfo.mViewScrollChanged) {
            attachinfo.mViewScrollChanged = false;
            attachinfo.mTreeObserver.dispatchOnScrollChanged();
        }
        if(mScroller != null && mScroller.computeScrollOffset())
            flag1 = true;
        else
            flag1 = false;
        if(flag1)
            i = mScroller.getCurrY();
        else
            i = mScrollY;
        if(mCurScrollY != i) {
            mCurScrollY = i;
            flag = true;
        }
        f = attachinfo.mApplicationScale;
        flag2 = attachinfo.mScalingRequired;
        j = 0;
        if(mResizeBuffer != null) {
            long l = SystemClock.uptimeMillis() - mResizeBufferStartTime;
            if(l < (long)mResizeBufferDuration) {
                float f1 = (float)l / (float)mResizeBufferDuration;
                float f2 = mResizeInterpolator.getInterpolation(f1);
                flag1 = true;
                j = 255 - (int)(255F * f2);
            } else {
                disposeResizeBuffer();
            }
        }
        rect = mDirty;
        if(mSurfaceHolder != null) {
            rect.setEmpty();
            if(flag1) {
                if(mScroller != null)
                    mScroller.abortAnimation();
                disposeResizeBuffer();
            }
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_325;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
        if(flag) {
            attachinfo.mIgnoreDirtyState = true;
            rect.set(0, 0, (int)(0.5F + f * (float)mWidth), (int)(0.5F + f * (float)mHeight));
        }
        attachinfo.mTreeObserver.dispatchOnDraw();
        if(!rect.isEmpty() || mIsAnimating) {
            if(attachinfo.mHardwareRenderer == null || !attachinfo.mHardwareRenderer.isEnabled())
                break; /* Loop/switch isn't completed */
            mIsAnimating = false;
            mHardwareYOffset = i;
            mResizeAlpha = j;
            mCurrentDirty.set(rect);
            mCurrentDirty.union(mPreviousDirty);
            mPreviousDirty.set(rect);
            rect.setEmpty();
            HardwareRenderer hardwarerenderer = attachinfo.mHardwareRenderer;
            View view = mView;
            Rect rect1;
            if(flag1)
                rect1 = null;
            else
                rect1 = mCurrentDirty;
            if(hardwarerenderer.draw(view, attachinfo, this, rect1))
                mPreviousDirty.set(0, 0, mWidth, mHeight);
        }
_L5:
        if(!flag1)
            break; /* Loop/switch isn't completed */
        mFullRedrawNeeded = true;
        scheduleTraversals();
        if(true) goto _L4; else goto _L3
_L4:
        break; /* Loop/switch isn't completed */
_L3:
        if(drawSoftware(surface, attachinfo, i, flag2, rect)) goto _L5; else goto _L1
    }

    private void drawAccessibilityFocusedDrawableIfNeeded(Canvas canvas) {
        AccessibilityManager accessibilitymanager;
        accessibilitymanager = AccessibilityManager.getInstance(mView.mContext);
        break MISSING_BLOCK_LABEL_11;
_L2:
        Drawable drawable;
        Rect rect;
        do
            return;
        while(!accessibilitymanager.isEnabled() || !accessibilitymanager.isTouchExplorationEnabled() || mAccessibilityFocusedHost == null || mAccessibilityFocusedHost.mAttachInfo == null);
        drawable = getAccessibilityFocusedDrawable();
        if(drawable == null)
            continue; /* Loop/switch isn't completed */
        AccessibilityNodeProvider accessibilitynodeprovider = mAccessibilityFocusedHost.getAccessibilityNodeProvider();
        rect = mView.mAttachInfo.mTmpInvalRect;
        if(accessibilitynodeprovider != null)
            break; /* Loop/switch isn't completed */
        mAccessibilityFocusedHost.getDrawingRect(rect);
        if(mView instanceof ViewGroup)
            ((ViewGroup)mView).offsetDescendantRectToMyCoords(mAccessibilityFocusedHost, rect);
_L4:
        drawable.setBounds(rect);
        drawable.draw(canvas);
        if(true) goto _L2; else goto _L1
_L1:
        if(mAccessibilityFocusedVirtualView == null) goto _L2; else goto _L3
_L3:
        mAccessibilityFocusedVirtualView.getBoundsInScreen(rect);
        rect.offset(-mAttachInfo.mWindowLeft, -mAttachInfo.mWindowTop);
          goto _L4
    }

    private boolean drawSoftware(Surface surface, View.AttachInfo attachinfo, int i, boolean flag, Rect rect) {
        boolean flag1 = false;
        if(attachinfo.mHardwareRenderer == null || attachinfo.mHardwareRenderer.isEnabled() || !attachinfo.mHardwareRenderer.isRequested()) goto _L2; else goto _L1
_L1:
        mFullRedrawNeeded = true;
        scheduleTraversals();
_L5:
        return flag1;
_L2:
        Canvas canvas;
        View view;
        float f;
        int j1;
        try {
            int j = rect.left;
            int k = rect.top;
            int l = rect.right;
            int i1 = rect.bottom;
            canvas = mSurface.lockCanvas(rect);
            if(j != rect.left || k != rect.top || l != rect.right || i1 != rect.bottom)
                attachinfo.mIgnoreDirtyState = true;
            canvas.setDensity(mDensity);
        }
        catch(Surface.OutOfResourcesException outofresourcesexception) {
            Log.e("ViewRootImpl", "OutOfResourcesException locking surface", outofresourcesexception);
            IllegalArgumentException illegalargumentexception;
            Exception exception;
            IllegalArgumentException illegalargumentexception1;
            Exception exception1;
            IllegalArgumentException illegalargumentexception2;
            try {
                if(!sWindowSession.outOfMemory(mWindow)) {
                    Slog.w("ViewRootImpl", "No processes killed for memory; killing self");
                    Process.killProcess(Process.myPid());
                }
            }
            catch(RemoteException remoteexception) { }
            mLayoutRequested = true;
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch(IllegalArgumentException illegalargumentexception) {
            Log.e("ViewRootImpl", "Could not lock surface", illegalargumentexception);
            mLayoutRequested = true;
            continue; /* Loop/switch isn't completed */
        }
        if(!canvas.isOpaque() || i != 0)
            canvas.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
        rect.setEmpty();
        mIsAnimating = false;
        attachinfo.mDrawingTime = SystemClock.uptimeMillis();
        view = mView;
        view.mPrivateFlags = 0x20 | view.mPrivateFlags;
        f = -i;
        canvas.translate(0.0F, f);
        if(mTranslator != null)
            mTranslator.translateCanvas(canvas);
        if(!flag)
            break MISSING_BLOCK_LABEL_354;
        j1 = DisplayMetrics.DENSITY_DEVICE;
_L3:
        canvas.setScreenDensity(j1);
        attachinfo.mSetIgnoreDirtyState = false;
        mView.draw(canvas);
        drawAccessibilityFocusedDrawableIfNeeded(canvas);
        if(!attachinfo.mSetIgnoreDirtyState)
            attachinfo.mIgnoreDirtyState = false;
        surface.unlockCanvasAndPost(canvas);
        flag1 = true;
        continue; /* Loop/switch isn't completed */
        j1 = 0;
          goto _L3
        exception1;
        if(!attachinfo.mSetIgnoreDirtyState)
            attachinfo.mIgnoreDirtyState = false;
        throw exception1;
        exception;
        surface.unlockCanvasAndPost(canvas);
        throw exception;
        illegalargumentexception1;
        Log.e("ViewRootImpl", "Could not unlock surface", illegalargumentexception1);
_L6:
        mLayoutRequested = true;
        if(true) goto _L5; else goto _L4
_L4:
        illegalargumentexception2;
        Log.e("ViewRootImpl", "Could not unlock surface", illegalargumentexception2);
          goto _L6
    }

    private void enableHardwareAcceleration(Context context, WindowManager.LayoutParams layoutparams) {
        boolean flag;
        flag = true;
        mAttachInfo.mHardwareAccelerated = false;
        mAttachInfo.mHardwareAccelerationRequested = false;
        if(mTranslator == null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        boolean flag1;
        if((0x1000000 & layoutparams.flags) != 0)
            flag1 = flag;
        else
            flag1 = false;
        if(flag1 && HardwareRenderer.isAvailable()) {
            boolean flag2;
            boolean flag3;
            if((1 & layoutparams.privateFlags) != 0)
                flag2 = flag;
            else
                flag2 = false;
            if((2 & layoutparams.privateFlags) != 0)
                flag3 = flag;
            else
                flag3 = false;
            if(!HardwareRenderer.sRendererDisabled || HardwareRenderer.sSystemRendererDisabled && flag3) {
                if(!HardwareRenderer.sSystemRendererDisabled && Looper.getMainLooper() != Looper.myLooper()) {
                    Log.w("HardwareRenderer", "Attempting to initialize hardware acceleration outside of the main thread, aborting");
                } else {
                    if(isRenderThreadRequested(context))
                        Log.i("HardwareRenderer", "Render threat initiated");
                    if(mAttachInfo.mHardwareRenderer != null)
                        mAttachInfo.mHardwareRenderer.destroy(flag);
                    boolean flag4;
                    View.AttachInfo attachinfo;
                    View.AttachInfo attachinfo1;
                    if(layoutparams.format != -1)
                        flag4 = flag;
                    else
                        flag4 = false;
                    mAttachInfo.mHardwareRenderer = HardwareRenderer.createGlRenderer(2, flag4);
                    attachinfo = mAttachInfo;
                    attachinfo1 = mAttachInfo;
                    if(mAttachInfo.mHardwareRenderer == null)
                        flag = false;
                    attachinfo1.mHardwareAccelerationRequested = flag;
                    attachinfo.mHardwareAccelerated = flag;
                }
            } else
            if(flag2)
                mAttachInfo.mHardwareAccelerationRequested = flag;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private boolean ensureTouchModeLocally(boolean flag) {
        boolean flag1;
        if(mAttachInfo.mInTouchMode == flag) {
            flag1 = false;
        } else {
            mAttachInfo.mInTouchMode = flag;
            mAttachInfo.mTreeObserver.dispatchOnTouchModeChanged(flag);
            if(flag)
                flag1 = enterTouchMode();
            else
                flag1 = leaveTouchMode();
        }
        return flag1;
    }

    private boolean enterTouchMode() {
        if(mView == null || !mView.hasFocus()) goto _L2; else goto _L1
_L1:
        View view = mView.findFocus();
        if(view == null || view.isFocusableInTouchMode()) goto _L2; else goto _L3
_L3:
        boolean flag;
        ViewGroup viewgroup = findAncestorToTakeFocusInTouchMode(view);
        if(viewgroup != null) {
            flag = viewgroup.requestFocus();
        } else {
            mView.unFocus();
            mAttachInfo.mTreeObserver.dispatchOnGlobalFocusChange(view, null);
            mFocusedView = null;
            mOldFocusedView = null;
            flag = true;
        }
_L5:
        return flag;
_L2:
        flag = false;
        if(true) goto _L5; else goto _L4
_L4:
    }

    private static ViewGroup findAncestorToTakeFocusInTouchMode(View view) {
        ViewParent viewparent = view.getParent();
_L1:
        ViewGroup viewgroup;
        if(!(viewparent instanceof ViewGroup))
            break MISSING_BLOCK_LABEL_56;
        viewgroup = (ViewGroup)viewparent;
        if(viewgroup.getDescendantFocusability() != 0x40000 || !viewgroup.isFocusableInTouchMode()) {
label0:
            {
                if(!viewgroup.isRootNamespace())
                    break label0;
                viewgroup = null;
            }
        }
_L2:
        return viewgroup;
        viewparent = viewgroup.getParent();
          goto _L1
        viewgroup = null;
          goto _L2
    }

    private void finishInputEvent(QueuedInputEvent queuedinputevent, boolean flag) {
        if(queuedinputevent != mCurrentInputEvent)
            throw new IllegalStateException("finished input event out of order");
        if(queuedinputevent.mReceiver != null)
            queuedinputevent.mReceiver.finishInputEvent(queuedinputevent.mEvent, flag);
        else
            queuedinputevent.mEvent.recycleIfNeededAfterDispatch();
        recycleQueuedInputEvent(queuedinputevent);
        mCurrentInputEvent = null;
        if(mFirstPendingInputEvent != null)
            scheduleProcessInputEvents();
    }

    private static void forceLayout(View view) {
        view.forceLayout();
        if(view instanceof ViewGroup) {
            ViewGroup viewgroup = (ViewGroup)view;
            int i = viewgroup.getChildCount();
            for(int j = 0; j < i; j++)
                forceLayout(viewgroup.getChildAt(j));

        }
    }

    private Drawable getAccessibilityFocusedDrawable() {
        Drawable drawable;
        if(mAttachInfo != null) {
            if(mAttachInfo.mAccessibilityFocusDrawable == null) {
                TypedValue typedvalue = new TypedValue();
                if(mView.mContext.getTheme().resolveAttribute(0x10103dc, typedvalue, true))
                    mAttachInfo.mAccessibilityFocusDrawable = mView.mContext.getResources().getDrawable(typedvalue.resourceId);
            }
            drawable = mAttachInfo.mAccessibilityFocusDrawable;
        } else {
            drawable = null;
        }
        return drawable;
    }

    private AudioManager getAudioManager() {
        if(mView == null)
            throw new IllegalStateException("getAudioManager called when there is no mView");
        if(mAudioManager == null)
            mAudioManager = (AudioManager)mView.getContext().getSystemService("audio");
        return mAudioManager;
    }

    private View getCommonPredecessor(View view, View view1) {
        View view2;
        HashSet hashset;
        if(mAttachInfo == null)
            break MISSING_BLOCK_LABEL_138;
        if(mTempHashSet == null)
            mTempHashSet = new HashSet();
        hashset = mTempHashSet;
        hashset.clear();
        for(View view3 = view; view3 != null;) {
            hashset.add(view3);
            ViewParent viewparent1 = view3.mParent;
            if(viewparent1 instanceof View)
                view3 = (View)viewparent1;
            else
                view3 = null;
        }

        view2 = view1;
_L5:
        if(view2 == null) goto _L2; else goto _L1
_L1:
        if(!hashset.contains(view2)) goto _L4; else goto _L3
_L3:
        hashset.clear();
_L6:
        return view2;
_L4:
        ViewParent viewparent = view2.mParent;
        if(viewparent instanceof View)
            view2 = (View)viewparent;
        else
            view2 = null;
          goto _L5
_L2:
        hashset.clear();
        view2 = null;
          goto _L6
    }

    private static void getGfxInfo(View view, int ai[]) {
        DisplayList displaylist = view.mDisplayList;
        ai[0] = 1 + ai[0];
        if(displaylist != null)
            ai[1] = ai[1] + displaylist.getSize();
        if(view instanceof ViewGroup) {
            ViewGroup viewgroup = (ViewGroup)view;
            int i = viewgroup.getChildCount();
            for(int j = 0; j < i; j++)
                getGfxInfo(viewgroup.getChildAt(j), ai);

        }
    }

    private static int getRootMeasureSpec(int i, int j) {
        j;
        JVM INSTR tableswitch -2 -1: default 24
    //                   -2 45
    //                   -1 34;
           goto _L1 _L2 _L3
_L1:
        int k = View.MeasureSpec.makeMeasureSpec(j, 0x40000000);
_L5:
        return k;
_L3:
        k = View.MeasureSpec.makeMeasureSpec(i, 0x40000000);
        continue; /* Loop/switch isn't completed */
_L2:
        k = View.MeasureSpec.makeMeasureSpec(i, 0x80000000);
        if(true) goto _L5; else goto _L4
_L4:
    }

    static RunQueue getRunQueue() {
        RunQueue runqueue = (RunQueue)sRunQueues.get();
        if(runqueue == null) {
            runqueue = new RunQueue();
            sRunQueues.set(runqueue);
        }
        return runqueue;
    }

    public static IWindowSession getWindowSession(Looper looper) {
        Object obj = mStaticInit;
        obj;
        JVM INSTR monitorenter ;
        boolean flag = mInitialized;
        Exception exception;
        IWindowSession iwindowsession;
        if(!flag)
            try {
                InputMethodManager inputmethodmanager = InputMethodManager.getInstance(looper);
                IWindowManager iwindowmanager = Display.getWindowManager();
                sWindowSession = iwindowmanager.openSession(inputmethodmanager.getClient(), inputmethodmanager.getInputContext());
                ValueAnimator.setDurationScale(iwindowmanager.getAnimationScale(2));
                mInitialized = true;
            }
            catch(RemoteException remoteexception) { }
            finally {
                obj;
            }
        iwindowsession = sWindowSession;
        obj;
        JVM INSTR monitorexit ;
        return iwindowsession;
        throw exception;
    }

    private void handleDragEvent(DragEvent dragevent) {
        if(mView == null || !mAdded) goto _L2; else goto _L1
_L1:
        int i = dragevent.mAction;
        if(i != 6) goto _L4; else goto _L3
_L3:
        mView.dispatchDragEvent(dragevent);
_L2:
        dragevent.recycle();
        return;
_L4:
        View view;
        boolean flag;
        if(i == 1) {
            mCurrentDragView = null;
            mDragDescription = dragevent.mClipDescription;
        } else {
            dragevent.mClipDescription = mDragDescription;
        }
        if(i == 2 || i == 3) {
            mDragPoint.set(dragevent.mX, dragevent.mY);
            if(mTranslator != null)
                mTranslator.translatePointInScreenToAppWindow(mDragPoint);
            if(mCurScrollY != 0)
                mDragPoint.offset(0.0F, mCurScrollY);
            dragevent.mX = mDragPoint.x;
            dragevent.mY = mDragPoint.y;
        }
        view = mCurrentDragView;
        flag = mView.dispatchDragEvent(dragevent);
        if(view == mCurrentDragView)
            break MISSING_BLOCK_LABEL_200;
        if(view == null)
            break MISSING_BLOCK_LABEL_181;
        sWindowSession.dragRecipientExited(mWindow);
        if(mCurrentDragView != null)
            sWindowSession.dragRecipientEntered(mWindow);
_L5:
        if(i == 3) {
            mDragDescription = null;
            RemoteException remoteexception1;
            try {
                Log.i("ViewRootImpl", (new StringBuilder()).append("Reporting drop result: ").append(flag).toString());
                sWindowSession.reportDropResult(mWindow, flag);
            }
            catch(RemoteException remoteexception) {
                Log.e("ViewRootImpl", "Unable to report drop result");
            }
        }
        if(i == 4)
            setLocalDragState(null);
          goto _L2
        remoteexception1;
        Slog.e("ViewRootImpl", "Unable to note drag target change");
          goto _L5
    }

    static boolean isInTouchMode() {
        if(!mInitialized) goto _L2; else goto _L1
_L1:
        boolean flag1 = sWindowSession.getInTouchMode();
        boolean flag = flag1;
_L4:
        return flag;
        RemoteException remoteexception;
        remoteexception;
_L2:
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static boolean isNavigationKey(KeyEvent keyevent) {
        keyevent.getKeyCode();
        JVM INSTR lookupswitch 12: default 112
    //                   19: 116
    //                   20: 116
    //                   21: 116
    //                   22: 116
    //                   23: 116
    //                   61: 116
    //                   62: 116
    //                   66: 116
    //                   92: 116
    //                   93: 116
    //                   122: 116
    //                   123: 116;
           goto _L1 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = true;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static boolean isRenderThreadRequested(Context context) {
        return false;
    }

    private static boolean isTypingKey(KeyEvent keyevent) {
        boolean flag;
        if(keyevent.getUnicodeChar() > 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isViewDescendantOf(View view, View view1) {
        boolean flag = true;
        if(view != view1) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        ViewParent viewparent = view.getParent();
        if(!(viewparent instanceof ViewGroup) || !isViewDescendantOf((View)viewparent, view1))
            flag = false;
        if(true) goto _L1; else goto _L3
_L3:
    }

    private static int joystickAxisValueToDirection(float f) {
        int i;
        if(f >= 0.5F)
            i = 1;
        else
        if(f <= -0.5F)
            i = -1;
        else
            i = 0;
        return i;
    }

    private boolean leaveTouchMode() {
        if(mView == null) goto _L2; else goto _L1
_L1:
        if(!mView.hasFocus()) goto _L4; else goto _L3
_L3:
        mFocusedView = mView.findFocus();
        if(mFocusedView instanceof ViewGroup) goto _L6; else goto _L5
_L5:
        boolean flag = false;
_L8:
        return flag;
_L6:
        if(((ViewGroup)mFocusedView).getDescendantFocusability() != 0x40000) {
            flag = false;
            continue; /* Loop/switch isn't completed */
        }
_L4:
        View view = focusSearch(null, 130);
        if(view != null) {
            flag = view.requestFocus(130);
            continue; /* Loop/switch isn't completed */
        }
_L2:
        flag = false;
        if(true) goto _L8; else goto _L7
_L7:
    }

    private boolean measureHierarchy(View view, WindowManager.LayoutParams layoutparams, Resources resources, int i, int j) {
        boolean flag;
        boolean flag1;
        flag = false;
        flag1 = false;
        if(((ViewGroup.LayoutParams) (layoutparams)).width != -2) goto _L2; else goto _L1
_L1:
        int k;
        DisplayMetrics displaymetrics = resources.getDisplayMetrics();
        resources.getValue(0x1050007, mTmpValue, true);
        k = 0;
        if(mTmpValue.type == 5)
            k = (int)mTmpValue.getDimension(displaymetrics);
        if(k == 0 || i <= k) goto _L2; else goto _L3
_L3:
        int i1;
        int l = getRootMeasureSpec(k, ((ViewGroup.LayoutParams) (layoutparams)).width);
        i1 = getRootMeasureSpec(j, ((ViewGroup.LayoutParams) (layoutparams)).height);
        performMeasure(l, i1);
        if((0x1000000 & view.getMeasuredWidthAndState()) != 0) goto _L5; else goto _L4
_L4:
        flag1 = true;
_L2:
        if(!flag1) {
            performMeasure(getRootMeasureSpec(i, ((ViewGroup.LayoutParams) (layoutparams)).width), getRootMeasureSpec(j, ((ViewGroup.LayoutParams) (layoutparams)).height));
            if(mWidth != view.getMeasuredWidth() || mHeight != view.getMeasuredHeight())
                flag = true;
        }
        return flag;
_L5:
        performMeasure(getRootMeasureSpec((k + i) / 2, ((ViewGroup.LayoutParams) (layoutparams)).width), i1);
        if((0x1000000 & view.getMeasuredWidthAndState()) == 0)
            flag1 = true;
        if(true) goto _L2; else goto _L6
_L6:
    }

    private QueuedInputEvent obtainQueuedInputEvent(InputEvent inputevent, InputEventReceiver inputeventreceiver, int i) {
        QueuedInputEvent queuedinputevent = mQueuedInputEventPool;
        if(queuedinputevent != null) {
            mQueuedInputEventPoolSize = -1 + mQueuedInputEventPoolSize;
            mQueuedInputEventPool = queuedinputevent.mNext;
            queuedinputevent.mNext = null;
        } else {
            queuedinputevent = new QueuedInputEvent();
        }
        queuedinputevent.mEvent = inputevent;
        queuedinputevent.mReceiver = inputeventreceiver;
        queuedinputevent.mFlags = i;
        return queuedinputevent;
    }

    private void performDraw() {
        if(mAttachInfo.mScreenOn || mReportNextDraw) goto _L2; else goto _L1
_L1:
        return;
_L2:
        boolean flag;
        flag = mFullRedrawNeeded;
        mFullRedrawNeeded = false;
        mIsDrawing = true;
        Trace.traceBegin(8L, "draw");
        draw(flag);
        mIsDrawing = false;
        Trace.traceEnd(8L);
        if(!mReportNextDraw)
            continue; /* Loop/switch isn't completed */
        mReportNextDraw = false;
        if(mSurfaceHolder != null && mSurface.isValid()) {
            mSurfaceHolderCallback.surfaceRedrawNeeded(mSurfaceHolder);
            SurfaceHolder.Callback acallback[] = mSurfaceHolder.getCallbacks();
            if(acallback != null) {
                int i = acallback.length;
                for(int j = 0; j < i; j++) {
                    SurfaceHolder.Callback callback = acallback[j];
                    if(callback instanceof SurfaceHolder.Callback2)
                        ((SurfaceHolder.Callback2)callback).surfaceRedrawNeeded(mSurfaceHolder);
                }

            }
        }
        break MISSING_BLOCK_LABEL_178;
        Exception exception;
        exception;
        mIsDrawing = false;
        Trace.traceEnd(8L);
        throw exception;
        try {
            sWindowSession.finishDrawing(mWindow);
        }
        catch(RemoteException remoteexception) { }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void performLayout() {
        View view;
        mLayoutRequested = false;
        mScrollMayChange = true;
        view = mView;
        Trace.traceBegin(8L, "layout");
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        Trace.traceEnd(8L);
        return;
        Exception exception;
        exception;
        Trace.traceEnd(8L);
        throw exception;
    }

    private void performMeasure(int i, int j) {
        Trace.traceBegin(8L, "measure");
        mView.measure(i, j);
        Trace.traceEnd(8L);
        return;
        Exception exception;
        exception;
        Trace.traceEnd(8L);
        throw exception;
    }

    private void performTraversals() {
        View view = mView;
        if(view != null && mAdded) goto _L2; else goto _L1
_L1:
        return;
_L2:
        boolean flag1;
        boolean flag2;
        WindowManager.LayoutParams layoutparams;
        View.AttachInfo attachinfo;
        int i;
        boolean flag5;
        boolean flag6;
        boolean flag7;
        boolean flag8;
        int i1;
        boolean flag9;
        boolean flag10;
        boolean flag11;
        int i5;
        boolean flag20;
        boolean flag22;
        HardwareCanvas hardwarecanvas;
        HardwareCanvas hardwarecanvas1;
        boolean flag23;
        int i6;
        boolean flag24;
        mWillDrawSoon = true;
        boolean flag = false;
        flag1 = false;
        flag2 = false;
        layoutparams = mWindowAttributes;
        attachinfo = mAttachInfo;
        i = getHostVisibility();
        boolean flag3;
        WindowManager.LayoutParams layoutparams1;
        Rect rect;
        int j;
        int k;
        boolean flag4;
        if(mViewVisibility != i || mNewSurfaceNeeded)
            flag3 = true;
        else
            flag3 = false;
        layoutparams1 = null;
        if(mWindowAttributesChanged) {
            mWindowAttributesChanged = false;
            flag2 = true;
            layoutparams1 = layoutparams;
        }
        if(mCompatibilityInfo.get().supportsScreen() == mLastInCompatMode) {
            layoutparams1 = layoutparams;
            mFullRedrawNeeded = true;
            mLayoutRequested = true;
            int j6;
            int k6;
            View.AttachInfo attachinfo1;
            Display display1;
            Point point1;
            if(mLastInCompatMode) {
                int i7 = 0xdfffffff & layoutparams1.flags;
                layoutparams1.flags = i7;
                mLastInCompatMode = false;
            } else {
                int l6 = 0x20000000 | layoutparams1.flags;
                layoutparams1.flags = l6;
                mLastInCompatMode = true;
            }
        }
        mWindowAttributesChangesFlag = 0;
        rect = mWinFrame;
        if(mFirst) {
            mFullRedrawNeeded = true;
            mLayoutRequested = true;
            if(layoutparams.type == 2014) {
                display1 = WindowManagerImpl.getDefault().getDefaultDisplay();
                point1 = new Point();
                display1.getRealSize(point1);
                j = point1.x;
                k = point1.y;
            } else {
                DisplayMetrics displaymetrics1 = mView.getContext().getResources().getDisplayMetrics();
                j = displaymetrics1.widthPixels;
                k = displaymetrics1.heightPixels;
            }
            attachinfo.mSurface = mSurface;
            attachinfo.mUse32BitDrawingCache = true;
            attachinfo.mHasWindowFocus = false;
            attachinfo.mWindowVisibility = i;
            attachinfo.mRecomputeGlobalAttributes = false;
            flag3 = false;
            mLastConfiguration.setTo(view.getResources().getConfiguration());
            mLastSystemUiVisibility = mAttachInfo.mSystemUiVisibility;
            view.dispatchAttachedToWindow(attachinfo, 0);
            mFitSystemWindowsInsets.set(mAttachInfo.mContentInsets);
            view.fitSystemWindows(mFitSystemWindowsInsets);
        } else {
            j = rect.width();
            k = rect.height();
            if(j != mWidth || k != mHeight) {
                mFullRedrawNeeded = true;
                mLayoutRequested = true;
                flag = true;
            }
        }
        if(flag3) {
            attachinfo.mWindowVisibility = i;
            view.dispatchWindowVisibilityChanged(i);
            if(i != 0 || mNewSurfaceNeeded)
                destroyHardwareResources();
            if(i == 8)
                mHasHadWindowFocus = false;
        }
        getRunQueue().executeActions(attachinfo.mHandler);
        flag4 = false;
        if(mLayoutRequested && !mStopped)
            flag5 = true;
        else
            flag5 = false;
        if(flag5) {
            Resources resources = mView.getContext().getResources();
            if(mFirst) {
                attachinfo1 = mAttachInfo;
                boolean flag25;
                if(!mAddedTouchMode)
                    flag25 = true;
                else
                    flag25 = false;
                attachinfo1.mInTouchMode = flag25;
                ensureTouchModeLocally(mAddedTouchMode);
            } else {
                if(!mPendingContentInsets.equals(mAttachInfo.mContentInsets))
                    flag4 = true;
                if(!mPendingVisibleInsets.equals(mAttachInfo.mVisibleInsets))
                    mAttachInfo.mVisibleInsets.set(mPendingVisibleInsets);
                if(((ViewGroup.LayoutParams) (layoutparams)).width == -2 || ((ViewGroup.LayoutParams) (layoutparams)).height == -2) {
                    flag = true;
                    if(layoutparams.type == 2014) {
                        Display display = WindowManagerImpl.getDefault().getDefaultDisplay();
                        Point point = new Point();
                        display.getRealSize(point);
                        j = point.x;
                        k = point.y;
                    } else {
                        DisplayMetrics displaymetrics = resources.getDisplayMetrics();
                        j = displaymetrics.widthPixels;
                        k = displaymetrics.heightPixels;
                    }
                }
            }
            flag |= measureHierarchy(view, layoutparams, resources, j, k);
        }
        if(collectViewAttributes())
            layoutparams1 = layoutparams;
        if(attachinfo.mForceReportNewAttributes) {
            attachinfo.mForceReportNewAttributes = false;
            layoutparams1 = layoutparams;
        }
        if(mFirst || attachinfo.mViewVisibilityChanged) {
            attachinfo.mViewVisibilityChanged = false;
            int l = 0xf0 & mSoftInputMode;
            if(l == 0) {
                j6 = attachinfo.mScrollContainers.size();
                for(k6 = 0; k6 < j6; k6++)
                    if(((View)attachinfo.mScrollContainers.get(k6)).isShown())
                        l = 16;

                if(l == 0)
                    l = 32;
                if((0xf0 & layoutparams.softInputMode) != l) {
                    layoutparams.softInputMode = l | 0xffffff0f & layoutparams.softInputMode;
                    layoutparams1 = layoutparams;
                }
            }
        }
        if(layoutparams1 != null && (0x200 & view.mPrivateFlags) != 0 && !PixelFormat.formatHasAlpha(layoutparams1.format))
            layoutparams1.format = -3;
        if(mFitSystemWindowsRequested) {
            mFitSystemWindowsRequested = false;
            mFitSystemWindowsInsets.set(mAttachInfo.mContentInsets);
            view.fitSystemWindows(mFitSystemWindowsInsets);
            if(mLayoutRequested)
                flag |= measureHierarchy(view, layoutparams, mView.getContext().getResources(), j, k);
        }
        if(flag5)
            mLayoutRequested = false;
        SurfaceHolder.Callback acallback2[];
        int k4;
        int l4;
        HardwareRenderer hardwarerenderer;
        boolean flag21;
        int j5;
        int k5;
        int l5;
        android.graphics.PorterDuff.Mode mode;
        float f;
        Configuration configuration;
        if(flag5 && flag && (mWidth != view.getMeasuredWidth() || mHeight != view.getMeasuredHeight() || ((ViewGroup.LayoutParams) (layoutparams)).width == -2 && rect.width() < j && rect.width() != mWidth || ((ViewGroup.LayoutParams) (layoutparams)).height == -2 && rect.height() < k && rect.height() != mHeight))
            flag6 = true;
        else
            flag6 = false;
        flag7 = attachinfo.mTreeObserver.hasComputeInternalInsetsListeners();
        flag8 = false;
        i1 = 0;
        if(!mFirst && !flag6 && !flag4 && !flag3 && layoutparams1 == null) goto _L4; else goto _L3
_L3:
        if(i == 0)
            if(flag7 && (mFirst || flag3))
                flag8 = true;
            else
                flag8 = false;
        if(mSurfaceHolder != null) {
            mSurfaceHolder.mSurfaceLock.lock();
            mDrawingAllowed = true;
        }
        flag9 = false;
        flag10 = false;
        flag11 = mSurface.isValid();
        i5 = mSurface.getGenerationId();
        i1 = relayoutWindow(layoutparams1, i, flag8);
        if(mPendingConfiguration.seq == 0) goto _L6; else goto _L5
_L5:
        configuration = mPendingConfiguration;
        if(mFirst) goto _L8; else goto _L7
_L7:
        flag24 = true;
_L32:
        updateConfiguration(configuration, flag24);
        mPendingConfiguration.seq = 0;
_L6:
        if(mPendingContentInsets.equals(mAttachInfo.mContentInsets)) goto _L10; else goto _L9
_L9:
        flag10 = true;
_L33:
        if(mPendingVisibleInsets.equals(mAttachInfo.mVisibleInsets)) goto _L12; else goto _L11
_L11:
        flag20 = true;
_L34:
        if(!flag10) goto _L14; else goto _L13
_L13:
        if(mWidth <= 0 || mHeight <= 0 || layoutparams == null || (0x600 & (layoutparams.systemUiVisibility | layoutparams.subtreeSystemUiVisibility)) != 0 || mSurface == null || !mSurface.isValid() || mAttachInfo.mTurnOffWindowResizeAnim || mAttachInfo.mHardwareRenderer == null || !mAttachInfo.mHardwareRenderer.isEnabled() || !mAttachInfo.mHardwareRenderer.validate() || layoutparams == null || PixelFormat.formatHasAlpha(layoutparams.format)) goto _L16; else goto _L15
_L15:
        disposeResizeBuffer();
        flag22 = false;
        hardwarecanvas = mAttachInfo.mHardwareRenderer.getCanvas();
        hardwarecanvas1 = null;
        if(mResizeBuffer != null) goto _L18; else goto _L17
_L17:
        mResizeBuffer = mAttachInfo.mHardwareRenderer.createHardwareLayer(mWidth, mHeight, false);
_L36:
        hardwarecanvas1 = mResizeBuffer.start(hardwarecanvas);
        j5 = mWidth;
        k5 = mHeight;
        hardwarecanvas1.setViewport(j5, k5);
        hardwarecanvas1.onPreDraw(null);
        l5 = hardwarecanvas1.save();
        mode = android.graphics.PorterDuff.Mode.SRC;
        hardwarecanvas1.drawColor(0xff000000, mode);
        if(mScroller == null || !mScroller.computeScrollOffset()) goto _L20; else goto _L19
_L19:
        flag23 = true;
_L37:
        if(!flag23) goto _L22; else goto _L21
_L21:
        i6 = mScroller.getCurrY();
        mScroller.abortAnimation();
_L38:
        f = -i6;
        hardwarecanvas1.translate(0.0F, f);
        if(mTranslator != null)
            mTranslator.translateCanvas(hardwarecanvas1);
        mView.draw(hardwarecanvas1);
        drawAccessibilityFocusedDrawableIfNeeded(hardwarecanvas1);
        mResizeBufferStartTime = SystemClock.uptimeMillis();
        mResizeBufferDuration = mView.getResources().getInteger(0x10e0001);
        flag22 = true;
        hardwarecanvas1.restoreToCount(l5);
        if(hardwarecanvas1 == null)
            break MISSING_BLOCK_LABEL_1677;
        hardwarecanvas1.onPostDraw();
        if(mResizeBuffer != null) {
            mResizeBuffer.end(hardwarecanvas);
            if(!flag22) {
                mResizeBuffer.destroy();
                mResizeBuffer = null;
            }
        }
_L16:
        mAttachInfo.mContentInsets.set(mPendingContentInsets);
_L14:
        if(flag10 || mLastSystemUiVisibility != mAttachInfo.mSystemUiVisibility || mFitSystemWindowsRequested) {
            mLastSystemUiVisibility = mAttachInfo.mSystemUiVisibility;
            mFitSystemWindowsRequested = false;
            mFitSystemWindowsInsets.set(mAttachInfo.mContentInsets);
            view.fitSystemWindows(mFitSystemWindowsInsets);
        }
        if(flag20)
            mAttachInfo.mVisibleInsets.set(mPendingVisibleInsets);
        if(flag11) goto _L24; else goto _L23
_L23:
        if(!mSurface.isValid()) goto _L26; else goto _L25
_L25:
        flag1 = true;
        mFullRedrawNeeded = true;
        mPreviousTransparentRegion.setEmpty();
        hardwarerenderer = mAttachInfo.mHardwareRenderer;
        if(hardwarerenderer == null) goto _L26; else goto _L27
_L27:
        flag21 = mAttachInfo.mHardwareRenderer.initialize(mHolder);
        flag9 = flag21;
_L26:
        attachinfo.mWindowLeft = rect.left;
        attachinfo.mWindowTop = rect.top;
        if(mWidth != rect.width() || mHeight != rect.height()) {
            mWidth = rect.width();
            mHeight = rect.height();
        }
        if(mSurfaceHolder == null) goto _L29; else goto _L28
_L28:
        if(mSurface.isValid())
            mSurfaceHolder.mSurface = mSurface;
        mSurfaceHolder.setSurfaceFrameSize(mWidth, mHeight);
        mSurfaceHolder.mSurfaceLock.unlock();
        if(!mSurface.isValid()) goto _L31; else goto _L30
_L8:
        flag24 = false;
          goto _L32
_L10:
        flag10 = false;
          goto _L33
_L12:
        flag20 = false;
          goto _L34
_L18:
        if(mResizeBuffer.getWidth() == mWidth && mResizeBuffer.getHeight() == mHeight) goto _L36; else goto _L35
_L35:
        mResizeBuffer.resize(mWidth, mHeight);
          goto _L36
        outofmemoryerror;
        Log.w("ViewRootImpl", "Not enough memory for content change anim buffer", outofmemoryerror);
        if(hardwarecanvas1 == null)
            break MISSING_BLOCK_LABEL_2174;
        hardwarecanvas1.onPostDraw();
        if(mResizeBuffer != null) {
            mResizeBuffer.end(hardwarecanvas);
            if(!flag22) {
                mResizeBuffer.destroy();
                mResizeBuffer = null;
            }
        }
          goto _L16
_L20:
        flag23 = false;
          goto _L37
_L22:
        i6 = mScrollY;
          goto _L38
        exception1;
        if(hardwarecanvas1 == null)
            break MISSING_BLOCK_LABEL_2242;
        hardwarecanvas1.onPostDraw();
        if(mResizeBuffer != null) {
            mResizeBuffer.end(hardwarecanvas);
            if(!flag22) {
                mResizeBuffer.destroy();
                mResizeBuffer = null;
            }
        }
        throw exception1;
        outofresourcesexception1;
        Log.e("ViewRootImpl", "OutOfResourcesException initializing HW surface", outofresourcesexception1);
        try {
            if(!sWindowSession.outOfMemory(mWindow)) {
                Slog.w("ViewRootImpl", "No processes killed for memory; killing self");
                Process.killProcess(Process.myPid());
            }
        }
        catch(RemoteException remoteexception4) { }
        mLayoutRequested = true;
        continue; /* Loop/switch isn't completed */
_L24:
        if(mSurface.isValid()) goto _L40; else goto _L39
_L39:
        mLastScrolledFocus = null;
        mCurScrollY = 0;
        mScrollY = 0;
        if(mScroller != null)
            mScroller.abortAnimation();
        disposeResizeBuffer();
        if(mAttachInfo.mHardwareRenderer != null && mAttachInfo.mHardwareRenderer.isEnabled())
            mAttachInfo.mHardwareRenderer.destroy(true);
          goto _L26
_L40:
        if(i5 == mSurface.getGenerationId() || mSurfaceHolder != null || mAttachInfo.mHardwareRenderer == null) goto _L26; else goto _L41
_L41:
        mFullRedrawNeeded = true;
        mAttachInfo.mHardwareRenderer.updateSurface(mHolder);
          goto _L26
        outofresourcesexception;
        Log.e("ViewRootImpl", "OutOfResourcesException updating HW surface", outofresourcesexception);
        boolean flag12;
        boolean flag13;
        boolean flag14;
        boolean flag15;
        int j1;
        int k1;
        int l1;
        int i2;
        boolean flag16;
        InputMethodManager inputmethodmanager;
        View view1;
        View view2;
        int j2;
        boolean flag17;
        View view3;
        ViewTreeObserver.InternalInsetsInfo internalinsetsinfo;
        Rect rect1;
        Rect rect2;
        Region region;
        RemoteException remoteexception1;
        RemoteException remoteexception2;
        boolean flag18;
        int k2;
        int l2;
        int i3;
        int j3;
        boolean flag19;
        SurfaceHolder.Callback acallback[];
        Exception exception;
        int k3;
        int l3;
        SurfaceHolder.Callback acallback1[];
        int i4;
        int j4;
        try {
            if(!sWindowSession.outOfMemory(mWindow)) {
                Slog.w("ViewRootImpl", "No processes killed for memory; killing self");
                Process.killProcess(Process.myPid());
            }
        }
        catch(RemoteException remoteexception3) { }
        try {
            mLayoutRequested = true;
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch(RemoteException remoteexception) { }
          goto _L26
_L30:
        if(!flag11) {
            mSurfaceHolder.ungetCallbacks();
            mIsCreating = true;
            mSurfaceHolderCallback.surfaceCreated(mSurfaceHolder);
            acallback2 = mSurfaceHolder.getCallbacks();
            RemoteException remoteexception;
            Surface.OutOfResourcesException outofresourcesexception;
            Surface.OutOfResourcesException outofresourcesexception1;
            Exception exception1;
            OutOfMemoryError outofmemoryerror;
            if(acallback2 != null) {
                k4 = acallback2.length;
                for(l4 = 0; l4 < k4; l4++)
                    acallback2[l4].surfaceCreated(mSurfaceHolder);

            }
            flag2 = true;
        }
        if(flag2) {
            mSurfaceHolderCallback.surfaceChanged(mSurfaceHolder, layoutparams.format, mWidth, mHeight);
            acallback1 = mSurfaceHolder.getCallbacks();
            if(acallback1 != null) {
                i4 = acallback1.length;
                for(j4 = 0; j4 < i4; j4++)
                    acallback1[j4].surfaceChanged(mSurfaceHolder, layoutparams.format, mWidth, mHeight);

            }
        }
        mIsCreating = false;
_L29:
        if(mAttachInfo.mHardwareRenderer != null && mAttachInfo.mHardwareRenderer.isEnabled() && (flag9 || flag6 || mWidth != mAttachInfo.mHardwareRenderer.getWidth() || mHeight != mAttachInfo.mHardwareRenderer.getHeight())) {
            mAttachInfo.mHardwareRenderer.setup(mWidth, mHeight);
            if(!flag9)
                mAttachInfo.mHardwareRenderer.invalidate(mHolder);
        }
        if(!mStopped) {
            if((i1 & 1) != 0)
                flag18 = true;
            else
                flag18 = false;
            if(ensureTouchModeLocally(flag18) || mWidth != view.getMeasuredWidth() || mHeight != view.getMeasuredHeight() || flag10) {
                k2 = getRootMeasureSpec(mWidth, ((ViewGroup.LayoutParams) (layoutparams)).width);
                l2 = getRootMeasureSpec(mHeight, ((ViewGroup.LayoutParams) (layoutparams)).height);
                performMeasure(k2, l2);
                i3 = view.getMeasuredWidth();
                j3 = view.getMeasuredHeight();
                flag19 = false;
                if(layoutparams.horizontalWeight > 0.0F) {
                    k2 = View.MeasureSpec.makeMeasureSpec(i3 + (int)((float)(mWidth - i3) * layoutparams.horizontalWeight), 0x40000000);
                    flag19 = true;
                }
                if(layoutparams.verticalWeight > 0.0F) {
                    l2 = View.MeasureSpec.makeMeasureSpec(j3 + (int)((float)(mHeight - j3) * layoutparams.verticalWeight), 0x40000000);
                    flag19 = true;
                }
                if(flag19)
                    performMeasure(k2, l2);
                flag5 = true;
            }
        }
_L4:
        if(flag5 && !mStopped)
            flag12 = true;
        else
            flag12 = false;
        if(flag12 || attachinfo.mRecomputeGlobalAttributes)
            flag13 = true;
        else
            flag13 = false;
        if(flag12) {
            performLayout();
            if((0x200 & view.mPrivateFlags) != 0) {
                view.getLocationInWindow(mTmpLocation);
                mTransparentRegion.set(mTmpLocation[0], mTmpLocation[1], (mTmpLocation[0] + view.mRight) - view.mLeft, (mTmpLocation[1] + view.mBottom) - view.mTop);
                view.gatherTransparentRegion(mTransparentRegion);
                if(mTranslator != null)
                    mTranslator.translateRegionInWindowToScreen(mTransparentRegion);
                if(!mTransparentRegion.equals(mPreviousTransparentRegion)) {
                    mPreviousTransparentRegion.set(mTransparentRegion);
                    try {
                        sWindowSession.setTransparentRegion(mWindow, mTransparentRegion);
                    }
                    // Misplaced declaration of an exception variable
                    catch(RemoteException remoteexception2) { }
                }
            }
        }
        if(flag13) {
            attachinfo.mRecomputeGlobalAttributes = false;
            attachinfo.mTreeObserver.dispatchOnGlobalLayout();
            if(AccessibilityManager.getInstance(view.mContext).isEnabled())
                postSendWindowContentChangedCallback(mView);
        }
        if(flag7) {
            internalinsetsinfo = attachinfo.mGivenInternalInsets;
            internalinsetsinfo.reset();
            attachinfo.mTreeObserver.dispatchOnComputeInternalInsets(internalinsetsinfo);
            if(flag8 || !mLastGivenInsets.equals(internalinsetsinfo)) {
                mLastGivenInsets.set(internalinsetsinfo);
                if(mTranslator != null) {
                    rect1 = mTranslator.getTranslatedContentInsets(internalinsetsinfo.contentInsets);
                    rect2 = mTranslator.getTranslatedVisibleInsets(internalinsetsinfo.visibleInsets);
                    region = mTranslator.getTranslatedTouchableArea(internalinsetsinfo.touchableRegion);
                } else {
                    rect1 = internalinsetsinfo.contentInsets;
                    rect2 = internalinsetsinfo.visibleInsets;
                    region = internalinsetsinfo.touchableRegion;
                }
                try {
                    sWindowSession.setInsets(mWindow, internalinsetsinfo.mTouchableInsets, rect1, rect2, region);
                }
                // Misplaced declaration of an exception variable
                catch(RemoteException remoteexception1) { }
            }
        }
        flag14 = false;
        if(mFirst) {
            if(mView != null)
                if(!mView.hasFocus()) {
                    mView.requestFocus(2);
                    view3 = mView.findFocus();
                    mRealFocusedView = view3;
                    mFocusedView = view3;
                } else {
                    mRealFocusedView = mView.findFocus();
                }
            if((i1 & 8) != 0)
                mWindowsAnimating = true;
        } else
        if(mWindowsAnimating)
            flag14 = true;
        mFirst = false;
        mWillDrawSoon = false;
        mNewSurfaceNeeded = false;
        mViewVisibility = i;
        if(mAttachInfo.mHasWindowFocus) {
            flag16 = WindowManager.LayoutParams.mayUseInputMethod(mWindowAttributes.flags);
            if(flag16 != mLastWasImTarget) {
                mLastWasImTarget = flag16;
                inputmethodmanager = InputMethodManager.peekInstance();
                if(inputmethodmanager != null && flag16) {
                    inputmethodmanager.startGettingWindowFocus(mView);
                    view1 = mView;
                    view2 = mView.findFocus();
                    j2 = mWindowAttributes.softInputMode;
                    if(!mHasHadWindowFocus)
                        flag17 = true;
                    else
                        flag17 = false;
                    inputmethodmanager.onWindowFocus(view1, view2, j2, flag17, mWindowAttributes.flags);
                }
            }
        }
        if((i1 & 2) != 0)
            mReportNextDraw = true;
        if(attachinfo.mTreeObserver.dispatchOnPreDraw() || i != 0)
            flag15 = true;
        else
            flag15 = false;
        if(flag15 || flag1)
            break MISSING_BLOCK_LABEL_3795;
        if(flag14 && !mReportNextDraw)
            continue; /* Loop/switch isn't completed */
        if(mPendingTransitions == null || mPendingTransitions.size() <= 0)
            break MISSING_BLOCK_LABEL_3788;
        l1 = 0;
        do {
            i2 = mPendingTransitions.size();
            if(l1 >= i2)
                break MISSING_BLOCK_LABEL_3781;
            ((LayoutTransition)mPendingTransitions.get(l1)).startChangingAnimations();
            l1++;
        } while(true);
_L31:
        if(!flag11) goto _L29; else goto _L42
_L42:
        mSurfaceHolder.ungetCallbacks();
        acallback = mSurfaceHolder.getCallbacks();
        mSurfaceHolderCallback.surfaceDestroyed(mSurfaceHolder);
        if(acallback != null) {
            k3 = acallback.length;
            for(l3 = 0; l3 < k3; l3++)
                acallback[l3].surfaceDestroyed(mSurfaceHolder);

        }
        mSurfaceHolder.mSurfaceLock.lock();
        mSurfaceHolder.mSurface = new Surface();
        mSurfaceHolder.mSurfaceLock.unlock();
          goto _L29
        exception;
        mSurfaceHolder.mSurfaceLock.unlock();
        throw exception;
        mPendingTransitions.clear();
        performDraw();
        continue; /* Loop/switch isn't completed */
        if(i == 0)
            scheduleTraversals();
        else
        if(mPendingTransitions != null && mPendingTransitions.size() > 0) {
            j1 = 0;
            do {
                k1 = mPendingTransitions.size();
                if(j1 >= k1)
                    break;
                ((LayoutTransition)mPendingTransitions.get(j1)).endChangingAnimations();
                j1++;
            } while(true);
            mPendingTransitions.clear();
        }
        if(true) goto _L1; else goto _L43
_L43:
    }

    private void postSendWindowContentChangedCallback(View view) {
        if(mSendWindowContentChangedAccessibilityEvent == null)
            mSendWindowContentChangedAccessibilityEvent = new SendWindowContentChangedAccessibilityEvent();
        View view1 = mSendWindowContentChangedAccessibilityEvent.mSource;
        if(view1 == null) {
            mSendWindowContentChangedAccessibilityEvent.mSource = view;
            mHandler.postDelayed(mSendWindowContentChangedAccessibilityEvent, ViewConfiguration.getSendRecurringAccessibilityEventsInterval());
        } else {
            mSendWindowContentChangedAccessibilityEvent.mSource = getCommonPredecessor(view1, view);
        }
    }

    private void profileRendering(boolean flag) {
        if(mProfileRendering) {
            mRenderProfilingEnabled = flag;
            if(mRenderProfiler == null) {
                mRenderProfiler = new Thread(new Runnable() {

                    public void run() {
                        Log.d("ViewRootImpl", "Starting profiling thread");
                        while(mRenderProfilingEnabled)  {
                            mAttachInfo.mHandler.post(new Runnable() {

                                public void run() {
                                    mDirty.set(0, 0, mWidth, mHeight);
                                    scheduleTraversals();
                                }

                                final _cls1 this$1;

                     {
                        this$1 = _cls1.this;
                        super();
                    }
                            });
                            try {
                                Thread.sleep(15L);
                            }
                            catch(InterruptedException interruptedexception) {
                                Log.d("ViewRootImpl", "Exiting profiling thread");
                            }
                        }
                    }

                    final ViewRootImpl this$0;

             {
                this$0 = ViewRootImpl.this;
                super();
            }
                }, "Rendering Profiler");
                mRenderProfiler.start();
            } else {
                mRenderProfiler.interrupt();
                mRenderProfiler = null;
            }
        }
    }

    private void recycleQueuedInputEvent(QueuedInputEvent queuedinputevent) {
        queuedinputevent.mEvent = null;
        queuedinputevent.mReceiver = null;
        if(mQueuedInputEventPoolSize < 10) {
            mQueuedInputEventPoolSize = 1 + mQueuedInputEventPoolSize;
            queuedinputevent.mNext = mQueuedInputEventPool;
            mQueuedInputEventPool = queuedinputevent;
        }
    }

    private int relayoutWindow(WindowManager.LayoutParams layoutparams, int i, boolean flag) throws RemoteException {
        float f = mAttachInfo.mApplicationScale;
        boolean flag1 = false;
        if(layoutparams != null && mTranslator != null) {
            flag1 = true;
            layoutparams.backup();
            mTranslator.translateWindowLayout(layoutparams);
        }
        if(layoutparams == null);
        mPendingConfiguration.seq = 0;
        if(layoutparams != null && mOrigWindowType != layoutparams.type && mTargetSdkVersion < 14) {
            Slog.w("ViewRootImpl", (new StringBuilder()).append("Window type can not be changed after the window is added; ignoring change of ").append(mView).toString());
            layoutparams.type = mOrigWindowType;
        }
        IWindowSession iwindowsession = sWindowSession;
        W w = mWindow;
        int j = mSeq;
        int k = (int)(0.5F + f * (float)mView.getMeasuredWidth());
        int l = (int)(0.5F + f * (float)mView.getMeasuredHeight());
        int i1;
        int j1;
        if(flag)
            i1 = 1;
        else
            i1 = 0;
        j1 = iwindowsession.relayout(w, j, layoutparams, k, l, i, i1, mWinFrame, mPendingContentInsets, mPendingVisibleInsets, mPendingConfiguration, mSurface);
        if(flag1)
            layoutparams.restore();
        if(mTranslator != null) {
            mTranslator.translateRectInScreenToAppWinFrame(mWinFrame);
            mTranslator.translateRectInScreenToAppWindow(mPendingContentInsets);
            mTranslator.translateRectInScreenToAppWindow(mPendingVisibleInsets);
        }
        return j1;
    }

    private void removeSendWindowContentChangedCallback() {
        if(mSendWindowContentChangedAccessibilityEvent != null)
            mHandler.removeCallbacks(mSendWindowContentChangedAccessibilityEvent);
    }

    private void scheduleProcessInputEvents() {
        if(!mProcessInputEventsScheduled) {
            mProcessInputEventsScheduled = true;
            Message message = mHandler.obtainMessage(19);
            message.setAsynchronous(true);
            mHandler.sendMessage(message);
        }
    }

    private void trackFPS() {
        long l = System.currentTimeMillis();
        if(mFpsStartTime >= 0L) goto _L2; else goto _L1
_L1:
        mFpsPrevTime = l;
        mFpsStartTime = l;
        mFpsNumFrames = 0;
_L4:
        return;
_L2:
        mFpsNumFrames = 1 + mFpsNumFrames;
        String s = Integer.toHexString(System.identityHashCode(this));
        long l1 = l - mFpsPrevTime;
        long l2 = l - mFpsStartTime;
        Log.v("ViewRootImpl", (new StringBuilder()).append("0x").append(s).append("\tFrame time:\t").append(l1).toString());
        mFpsPrevTime = l;
        if(l2 > 1000L) {
            float f = (1000F * (float)mFpsNumFrames) / (float)l2;
            Log.v("ViewRootImpl", (new StringBuilder()).append("0x").append(s).append("\tFPS:\t").append(f).toString());
            mFpsStartTime = l;
            mFpsNumFrames = 0;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private boolean tryToSkipResizedMsg(ResizedInfo resizedinfo, Message message) {
        boolean flag;
        if(mWinFrame.width() == message.arg1 && mWinFrame.height() == message.arg2 && mPendingContentInsets.equals(resizedinfo.contentInsets) && ((ResizedInfo)message.obj).newConfig == null && mSkipResizedMsg) {
            mSkipResizedMsg = false;
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    private void updateJoystickDirection(MotionEvent motionevent, boolean flag) {
        long l = motionevent.getEventTime();
        int i = motionevent.getMetaState();
        int j = motionevent.getDeviceId();
        int k = motionevent.getSource();
        int i1 = joystickAxisValueToDirection(motionevent.getAxisValue(15));
        if(i1 == 0)
            i1 = joystickAxisValueToDirection(motionevent.getX());
        int j1 = joystickAxisValueToDirection(motionevent.getAxisValue(16));
        if(j1 == 0)
            j1 = joystickAxisValueToDirection(motionevent.getY());
        if(i1 != mLastJoystickXDirection) {
            if(mLastJoystickXKeyCode != 0) {
                enqueueInputEvent(new KeyEvent(l, l, 1, mLastJoystickXKeyCode, 0, i, j, 0, 1024, k));
                mLastJoystickXKeyCode = 0;
            }
            mLastJoystickXDirection = i1;
            if(i1 != 0 && flag) {
                int l1;
                if(i1 > 0)
                    l1 = 22;
                else
                    l1 = 21;
                mLastJoystickXKeyCode = l1;
                enqueueInputEvent(new KeyEvent(l, l, 0, mLastJoystickXKeyCode, 0, i, j, 0, 1024, k));
            }
        }
        if(j1 != mLastJoystickYDirection) {
            if(mLastJoystickYKeyCode != 0) {
                enqueueInputEvent(new KeyEvent(l, l, 1, mLastJoystickYKeyCode, 0, i, j, 0, 1024, k));
                mLastJoystickYKeyCode = 0;
            }
            mLastJoystickYDirection = j1;
            if(j1 != 0 && flag) {
                int k1;
                if(j1 > 0)
                    k1 = 20;
                else
                    k1 = 19;
                mLastJoystickYKeyCode = k1;
                enqueueInputEvent(new KeyEvent(l, l, 0, mLastJoystickYKeyCode, 0, i, j, 0, 1024, k));
            }
        }
    }

    public boolean attachFunctor(int i) {
        boolean flag;
        if(mAttachInfo.mHardwareRenderer != null && mAttachInfo.mHardwareRenderer.isEnabled())
            flag = mAttachInfo.mHardwareRenderer.attachFunctor(mAttachInfo, i);
        else
            flag = false;
        return flag;
    }

    public void bringChildToFront(View view) {
    }

    public void cancelInvalidate(View view) {
        mHandler.removeMessages(1, view);
        mHandler.removeMessages(2, view);
        mInvalidateOnAnimationRunnable.removeView(view);
    }

    void checkThread() {
        if(mThread != Thread.currentThread())
            throw new CalledFromWrongThreadException("Only the original thread that created a view hierarchy can touch its views.");
        else
            return;
    }

    public void childAccessibilityStateChanged(View view) {
        postSendWindowContentChangedCallback(view);
    }

    public void childDrawableStateChanged(View view) {
    }

    public void childHasTransientStateChanged(View view, boolean flag) {
    }

    public void clearChildFocus(View view) {
        checkThread();
        mOldFocusedView = mFocusedView;
        if(focusSearch(null, 2) == null)
            mAttachInfo.mTreeObserver.dispatchOnGlobalFocusChange(mOldFocusedView, null);
        mRealFocusedView = null;
        mFocusedView = null;
    }

    public void createContextMenu(ContextMenu contextmenu) {
    }

    public void debug() {
        mView.debug();
    }

    public void dequeueDisplayList(DisplayList displaylist) {
        if(mDisplayLists.remove(displaylist)) {
            displaylist.invalidate();
            if(mDisplayLists.size() == 0)
                mHandler.removeMessages(21);
        }
    }

    void destroyHardwareLayers() {
        if(mThread == Thread.currentThread()) goto _L2; else goto _L1
_L1:
        if(mAttachInfo.mHardwareRenderer != null && mAttachInfo.mHardwareRenderer.isEnabled())
            HardwareRenderer.trimMemory(60);
_L4:
        return;
_L2:
        if(mAttachInfo.mHardwareRenderer != null && mAttachInfo.mHardwareRenderer.isEnabled())
            mAttachInfo.mHardwareRenderer.destroyLayers(mView);
        if(true) goto _L4; else goto _L3
_L3:
    }

    void destroyHardwareResources() {
        if(mAttachInfo.mHardwareRenderer != null) {
            if(mAttachInfo.mHardwareRenderer.isEnabled())
                mAttachInfo.mHardwareRenderer.destroyLayers(mView);
            mAttachInfo.mHardwareRenderer.destroy(false);
        }
    }

    public void detachFunctor(int i) {
        if(mAttachInfo.mHardwareRenderer != null)
            mAttachInfo.mHardwareRenderer.detachFunctor(i);
    }

    public void die(boolean flag) {
        if(flag) {
            doDie();
        } else {
            if(!mIsDrawing)
                destroyHardwareRenderer();
            else
                Log.e("ViewRootImpl", (new StringBuilder()).append("Attempting to destroy the window while drawing!\n  window=").append(this).append(", title=").append(mWindowAttributes.getTitle()).toString());
            mHandler.sendEmptyMessage(3);
        }
    }

    public void dispatchAppVisibility(boolean flag) {
        Message message = mHandler.obtainMessage(8);
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        message.arg1 = i;
        mHandler.sendMessage(message);
    }

    public void dispatchCheckFocus() {
        if(!mHandler.hasMessages(13))
            mHandler.sendEmptyMessage(13);
    }

    public void dispatchCloseSystemDialogs(String s) {
        Message message = Message.obtain();
        message.what = 14;
        message.obj = s;
        mHandler.sendMessage(message);
    }

    void dispatchDetachedFromWindow() {
        if(mView != null && mView.mAttachInfo != null) {
            if(mAttachInfo.mHardwareRenderer != null && mAttachInfo.mHardwareRenderer.isEnabled())
                mAttachInfo.mHardwareRenderer.validate();
            mView.dispatchDetachedFromWindow();
        }
        mAccessibilityInteractionConnectionManager.ensureNoConnection();
        mAccessibilityManager.removeAccessibilityStateChangeListener(mAccessibilityInteractionConnectionManager);
        removeSendWindowContentChangedCallback();
        destroyHardwareRenderer();
        setAccessibilityFocus(null, null);
        mView = null;
        mAttachInfo.mRootView = null;
        mAttachInfo.mSurface = null;
        mSurface.release();
        if(mInputQueueCallback != null && mInputQueue != null) {
            mInputQueueCallback.onInputQueueDestroyed(mInputQueue);
            mInputQueueCallback = null;
            mInputQueue = null;
        } else
        if(mInputEventReceiver != null) {
            mInputEventReceiver.dispose();
            mInputEventReceiver = null;
        }
        try {
            sWindowSession.remove(mWindow);
        }
        catch(RemoteException remoteexception) { }
        if(mInputChannel != null) {
            mInputChannel.dispose();
            mInputChannel = null;
        }
        unscheduleTraversals();
    }

    public void dispatchDoneAnimating() {
        mHandler.sendEmptyMessage(23);
    }

    public void dispatchDragEvent(DragEvent dragevent) {
        byte byte0;
        Message message;
        if(dragevent.getAction() == 2) {
            byte0 = 16;
            mHandler.removeMessages(byte0);
        } else {
            byte0 = 15;
        }
        message = mHandler.obtainMessage(byte0, dragevent);
        mHandler.sendMessage(message);
    }

    public void dispatchFinishInputConnection(InputConnection inputconnection) {
        Message message = mHandler.obtainMessage(12, inputconnection);
        mHandler.sendMessage(message);
    }

    public void dispatchGetNewSurface() {
        Message message = mHandler.obtainMessage(9);
        mHandler.sendMessage(message);
    }

    void dispatchImeFinishedEvent(int i, boolean flag) {
        Message message = mHandler.obtainMessage(10);
        message.arg1 = i;
        int j;
        if(flag)
            j = 1;
        else
            j = 0;
        message.arg2 = j;
        message.setAsynchronous(true);
        mHandler.sendMessage(message);
    }

    public void dispatchInvalidateDelayed(View view, long l) {
        Message message = mHandler.obtainMessage(1, view);
        mHandler.sendMessageDelayed(message, l);
    }

    public void dispatchInvalidateOnAnimation(View view) {
        mInvalidateOnAnimationRunnable.addView(view);
    }

    public void dispatchInvalidateRectDelayed(View.AttachInfo.InvalidateInfo invalidateinfo, long l) {
        Message message = mHandler.obtainMessage(2, invalidateinfo);
        mHandler.sendMessageDelayed(message, l);
    }

    public void dispatchInvalidateRectOnAnimation(View.AttachInfo.InvalidateInfo invalidateinfo) {
        mInvalidateOnAnimationRunnable.addViewRect(invalidateinfo);
    }

    public void dispatchKey(KeyEvent keyevent) {
        Message message = mHandler.obtainMessage(7, keyevent);
        message.setAsynchronous(true);
        mHandler.sendMessage(message);
    }

    public void dispatchKeyFromIme(KeyEvent keyevent) {
        Message message = mHandler.obtainMessage(11, keyevent);
        message.setAsynchronous(true);
        mHandler.sendMessage(message);
    }

    public void dispatchResized(int i, int j, Rect rect, Rect rect1, boolean flag, Configuration configuration) {
        ViewRootHandler viewroothandler = mHandler;
        byte byte0;
        Message message;
        ResizedInfo resizedinfo;
        if(flag)
            byte0 = 5;
        else
            byte0 = 4;
        message = viewroothandler.obtainMessage(byte0);
        if(mTranslator != null) {
            mTranslator.translateRectInScreenToAppWindow(rect);
            mTranslator.translateRectInScreenToAppWindow(rect1);
            i = (int)((float)i * mTranslator.applicationInvertedScale);
            j = (int)((float)j * mTranslator.applicationInvertedScale);
        }
        message.arg1 = i;
        message.arg2 = j;
        resizedinfo = new ResizedInfo();
        resizedinfo.contentInsets = new Rect(rect);
        resizedinfo.visibleInsets = new Rect(rect1);
        resizedinfo.newConfig = configuration;
        message.obj = resizedinfo;
        mHandler.sendMessage(message);
    }

    public void dispatchScreenStateChange(boolean flag) {
        Message message = mHandler.obtainMessage(20);
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        message.arg1 = i;
        mHandler.sendMessage(message);
    }

    public void dispatchSystemUiVisibilityChanged(int i, int j, int k, int l) {
        SystemUiVisibilityInfo systemuivisibilityinfo = new SystemUiVisibilityInfo();
        systemuivisibilityinfo.seq = i;
        systemuivisibilityinfo.globalVisibility = j;
        systemuivisibilityinfo.localValue = k;
        systemuivisibilityinfo.localChanges = l;
        mHandler.sendMessage(mHandler.obtainMessage(17, systemuivisibilityinfo));
    }

    public void dispatchUnhandledKey(KeyEvent keyevent) {
        if((0x400 & keyevent.getFlags()) == 0) {
            KeyCharacterMap.FallbackAction fallbackaction = keyevent.getKeyCharacterMap().getFallbackAction(keyevent.getKeyCode(), keyevent.getMetaState());
            if(fallbackaction != null) {
                int i = 0x400 | keyevent.getFlags();
                KeyEvent keyevent1 = KeyEvent.obtain(keyevent.getDownTime(), keyevent.getEventTime(), keyevent.getAction(), fallbackaction.keyCode, keyevent.getRepeatCount(), fallbackaction.metaState, keyevent.getDeviceId(), keyevent.getScanCode(), i, keyevent.getSource(), null);
                fallbackaction.recycle();
                dispatchKey(keyevent1);
            }
        }
    }

    void disposeResizeBuffer() {
        if(mResizeBuffer != null) {
            mResizeBuffer.destroy();
            mResizeBuffer = null;
        }
    }

    void doConsumeBatchedInput(long l) {
        if(mConsumeBatchedInputScheduled) {
            mConsumeBatchedInputScheduled = false;
            if(mInputEventReceiver != null)
                mInputEventReceiver.consumeBatchedInputEvents(l);
            doProcessInputEvents();
        }
    }

    void doDie() {
        boolean flag;
        flag = false;
        checkThread();
        this;
        JVM INSTR monitorenter ;
        int i;
        boolean flag1;
        if(mAdded)
            dispatchDetachedFromWindow();
        if(!mAdded || mFirst)
            break MISSING_BLOCK_LABEL_111;
        destroyHardwareRenderer();
        if(mView == null)
            break MISSING_BLOCK_LABEL_111;
        i = mView.getVisibility();
        if(mViewVisibility != i)
            flag = true;
        flag1 = mWindowAttributesChanged;
        Exception exception;
        if(flag1 || flag)
            try {
                if((2 & relayoutWindow(mWindowAttributes, i, false)) != 0)
                    sWindowSession.finishDrawing(mWindow);
            }
            catch(RemoteException remoteexception) { }
            finally {
                this;
            }
        mSurface.release();
        mAdded = false;
        return;
        throw exception;
    }

    void doProcessInputEvents() {
        while(mCurrentInputEvent == null && mFirstPendingInputEvent != null)  {
            QueuedInputEvent queuedinputevent = mFirstPendingInputEvent;
            mFirstPendingInputEvent = queuedinputevent.mNext;
            queuedinputevent.mNext = null;
            mCurrentInputEvent = queuedinputevent;
            deliverInputEvent(queuedinputevent);
        }
        if(mProcessInputEventsScheduled) {
            mProcessInputEventsScheduled = false;
            mHandler.removeMessages(19);
        }
    }

    void doTraversal() {
        if(!mTraversalScheduled)
            break MISSING_BLOCK_LABEL_73;
        mTraversalScheduled = false;
        mHandler.getLooper().removeSyncBarrier(mTraversalBarrier);
        if(mProfile)
            Debug.startMethodTracing("ViewAncestor");
        Trace.traceBegin(8L, "performTraversals");
        performTraversals();
        Trace.traceEnd(8L);
        if(mProfile) {
            Debug.stopMethodTracing();
            mProfile = false;
        }
        return;
        Exception exception;
        exception;
        Trace.traceEnd(8L);
        throw exception;
    }

    public void dumpGfxInfo(int ai[]) {
        ai[1] = 0;
        ai[0] = 0;
        if(mView != null)
            getGfxInfo(mView, ai);
    }

    public void enqueueDisplayList(DisplayList displaylist) {
        mDisplayLists.add(displaylist);
        mHandler.removeMessages(21);
        Message message = mHandler.obtainMessage(21);
        mHandler.sendMessage(message);
    }

    void enqueueInputEvent(InputEvent inputevent) {
        enqueueInputEvent(inputevent, null, 0, false);
    }

    void enqueueInputEvent(InputEvent inputevent, InputEventReceiver inputeventreceiver, int i, boolean flag) {
        QueuedInputEvent queuedinputevent = obtainQueuedInputEvent(inputevent, inputeventreceiver, i);
        QueuedInputEvent queuedinputevent1 = mFirstPendingInputEvent;
        if(queuedinputevent1 == null) {
            mFirstPendingInputEvent = queuedinputevent;
        } else {
            for(; queuedinputevent1.mNext != null; queuedinputevent1 = queuedinputevent1.mNext);
            queuedinputevent1.mNext = queuedinputevent;
        }
        if(flag)
            doProcessInputEvents();
        else
            scheduleProcessInputEvents();
    }

    boolean ensureTouchMode(boolean flag) {
        boolean flag1;
        if(mAttachInfo.mInTouchMode == flag) {
            flag1 = false;
        } else {
            try {
                sWindowSession.setInTouchMode(flag);
            }
            catch(RemoteException remoteexception) {
                throw new RuntimeException(remoteexception);
            }
            flag1 = ensureTouchModeLocally(flag);
        }
        return flag1;
    }

    public View findViewToTakeAccessibilityFocusFromHover(View view, View view1) {
        if(!view1.includeForAccessibility())
            view1 = null;
        return view1;
    }

    public View focusSearch(View view, int i) {
        checkThread();
        View view1;
        if(!(mView instanceof ViewGroup))
            view1 = null;
        else
            view1 = FocusFinder.getInstance().findNextFocus((ViewGroup)mView, view, i);
        return view1;
    }

    public void focusableViewAvailable(View view) {
        checkThread();
        if(mView == null) goto _L2; else goto _L1
_L1:
        if(mView.hasFocus()) goto _L4; else goto _L3
_L3:
        view.requestFocus();
_L2:
        return;
_L4:
        mFocusedView = mView.findFocus();
        boolean flag;
        if((mFocusedView instanceof ViewGroup) && ((ViewGroup)mFocusedView).getDescendantFocusability() == 0x40000)
            flag = true;
        else
            flag = false;
        if(flag && isViewDescendantOf(view, mFocusedView))
            view.requestFocus();
        if(true) goto _L2; else goto _L5
_L5:
    }

    public View getAccessibilityFocusedHost() {
        return mAccessibilityFocusedHost;
    }

    public AccessibilityNodeInfo getAccessibilityFocusedVirtualView() {
        return mAccessibilityFocusedVirtualView;
    }

    public AccessibilityInteractionController getAccessibilityInteractionController() {
        if(mView == null)
            throw new IllegalStateException("getAccessibilityInteractionController called when there is no mView");
        if(mAccessibilityInteractionController == null)
            mAccessibilityInteractionController = new AccessibilityInteractionController(this);
        return mAccessibilityInteractionController;
    }

    public boolean getChildVisibleRect(View view, Rect rect, Point point) {
        if(view != mView)
            throw new RuntimeException("child is not mine, honest!");
        else
            return rect.intersect(0, 0, mWidth, mHeight);
    }

    int getHostVisibility() {
        int i;
        if(mAppVisible)
            i = mView.getVisibility();
        else
            i = 8;
        return i;
    }

    public void getLastTouchPoint(Point point) {
        point.x = (int)mLastTouchPoint.x;
        point.y = (int)mLastTouchPoint.y;
    }

    final WindowLeaked getLocation() {
        return mLocation;
    }

    public ViewParent getParent() {
        return null;
    }

    public ViewParent getParentForAccessibility() {
        return null;
    }

    public View getView() {
        return mView;
    }

    void handleAppVisibility(boolean flag) {
        if(mAppVisible != flag) {
            mAppVisible = flag;
            scheduleTraversals();
        }
    }

    public void handleDispatchDoneAnimating() {
        if(mWindowsAnimating) {
            mWindowsAnimating = false;
            if(!mDirty.isEmpty() || mIsAnimating)
                scheduleTraversals();
        }
    }

    public void handleDispatchSystemUiVisibilityChanged(SystemUiVisibilityInfo systemuivisibilityinfo) {
        if(mSeq != systemuivisibilityinfo.seq) {
            mSeq = systemuivisibilityinfo.seq;
            mAttachInfo.mForceReportNewAttributes = true;
            scheduleTraversals();
        }
        if(mView != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(systemuivisibilityinfo.localChanges != 0)
            mView.updateLocalSystemUiVisibility(systemuivisibilityinfo.localValue, systemuivisibilityinfo.localChanges);
        if(mAttachInfo != null) {
            int i = 7 & systemuivisibilityinfo.globalVisibility;
            if(i != mAttachInfo.mGlobalSystemUiVisibility) {
                mAttachInfo.mGlobalSystemUiVisibility = i;
                mView.dispatchSystemUiVisibilityChanged(i);
            }
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    void handleGetNewSurface() {
        mNewSurfaceNeeded = true;
        mFullRedrawNeeded = true;
        scheduleTraversals();
    }

    void handleImeFinishedEvent(int i, boolean flag) {
        QueuedInputEvent queuedinputevent = mCurrentInputEvent;
        if(queuedinputevent != null && queuedinputevent.mEvent.getSequenceNumber() == i) {
            KeyEvent _tmp = (KeyEvent)queuedinputevent.mEvent;
            if(flag)
                finishInputEvent(queuedinputevent, true);
            else
                deliverKeyEventPostIme(queuedinputevent);
        }
    }

    void handleScreenStateChange(boolean flag) {
        if(flag != mAttachInfo.mScreenOn) {
            mAttachInfo.mScreenOn = flag;
            if(mView != null) {
                View view = mView;
                int i;
                if(flag)
                    i = 1;
                else
                    i = 0;
                view.dispatchScreenStateChanged(i);
            }
            if(flag) {
                mFullRedrawNeeded = true;
                scheduleTraversals();
            }
        }
    }

    void invalidate() {
        mDirty.set(0, 0, mWidth, mHeight);
        scheduleTraversals();
    }

    public void invalidateChild(View view, Rect rect) {
        invalidateChildInParent(null, rect);
    }

    public ViewParent invalidateChildInParent(int ai[], Rect rect) {
        checkThread();
        if(rect != null) goto _L2; else goto _L1
_L1:
        invalidate();
_L4:
        return null;
_L2:
        if(mCurScrollY != 0 || mTranslator != null) {
            mTempRect.set(rect);
            rect = mTempRect;
            if(mCurScrollY != 0)
                rect.offset(0, -mCurScrollY);
            if(mTranslator != null)
                mTranslator.translateRectInAppWindowToScreen(rect);
            if(mAttachInfo.mScalingRequired)
                rect.inset(-1, -1);
        }
        Rect rect1 = mDirty;
        if(!rect1.isEmpty() && !rect1.contains(rect)) {
            mAttachInfo.mSetIgnoreDirtyState = true;
            mAttachInfo.mIgnoreDirtyState = true;
        }
        rect1.union(rect.left, rect.top, rect.right, rect.bottom);
        float f = mAttachInfo.mApplicationScale;
        rect1.intersect(0, 0, (int)(0.5F + f * (float)mWidth), (int)(0.5F + f * (float)mHeight));
        if(!mWillDrawSoon)
            scheduleTraversals();
        if(true) goto _L4; else goto _L3
_L3:
    }

    void invalidateDisplayLists() {
        ArrayList arraylist = mDisplayLists;
        int i = arraylist.size();
        for(int j = 0; j < i; j++) {
            DisplayList displaylist = (DisplayList)arraylist.get(j);
            displaylist.invalidate();
            displaylist.clear();
        }

        arraylist.clear();
    }

    void invalidateWorld(View view) {
        view.invalidate();
        if(view instanceof ViewGroup) {
            ViewGroup viewgroup = (ViewGroup)view;
            for(int i = 0; i < viewgroup.getChildCount(); i++)
                invalidateWorld(viewgroup.getChildAt(i));

        }
    }

    public boolean isLayoutRequested() {
        return mLayoutRequested;
    }

    public void loadSystemProperties() {
        boolean flag = SystemProperties.getBoolean("debug.layout", false);
        if(flag != mAttachInfo.mDebugLayout) {
            mAttachInfo.mDebugLayout = flag;
            if(!mHandler.hasMessages(24))
                mHandler.sendEmptyMessageDelayed(24, 200L);
        }
    }

    public void onHardwarePostDraw(HardwareCanvas hardwarecanvas) {
        if(mResizeBuffer != null) {
            mResizePaint.setAlpha(mResizeAlpha);
            hardwarecanvas.drawHardwareLayer(mResizeBuffer, 0.0F, mHardwareYOffset, mResizePaint);
        }
        drawAccessibilityFocusedDrawableIfNeeded(hardwarecanvas);
    }

    public void onHardwarePreDraw(HardwareCanvas hardwarecanvas) {
        hardwarecanvas.translate(0.0F, -mHardwareYOffset);
    }

    void outputDisplayList(View view) {
        if(mAttachInfo != null && mAttachInfo.mHardwareCanvas != null) {
            DisplayList displaylist = view.getDisplayList();
            if(displaylist != null)
                mAttachInfo.mHardwareCanvas.outputDisplayList(displaylist);
        }
    }

    public boolean performHapticFeedback(int i, boolean flag) {
        boolean flag2 = sWindowSession.performHapticFeedback(mWindow, i, flag);
        boolean flag1 = flag2;
_L2:
        return flag1;
        RemoteException remoteexception;
        remoteexception;
        flag1 = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void playSoundEffect(int i) {
        checkThread();
        AudioManager audiomanager = getAudioManager();
        i;
        JVM INSTR tableswitch 0 4: default 44
    //                   0 119
    //                   1 137
    //                   2 155
    //                   3 146
    //                   4 128;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L4:
        break MISSING_BLOCK_LABEL_155;
_L1:
        throw new IllegalArgumentException((new StringBuilder()).append("unknown effect id ").append(i).append(" not defined in ").append(android/view/SoundEffectConstants.getCanonicalName()).toString());
        IllegalStateException illegalstateexception;
        illegalstateexception;
        Log.e("ViewRootImpl", (new StringBuilder()).append("FATAL EXCEPTION when attempting to play sound effect: ").append(illegalstateexception).toString());
        illegalstateexception.printStackTrace();
_L7:
        return;
_L2:
        audiomanager.playSoundEffect(0);
          goto _L7
_L6:
        audiomanager.playSoundEffect(2);
          goto _L7
_L3:
        audiomanager.playSoundEffect(3);
          goto _L7
_L5:
        audiomanager.playSoundEffect(4);
          goto _L7
        audiomanager.playSoundEffect(1);
          goto _L7
    }

    public void profile() {
        mProfile = true;
    }

    public void recomputeViewAttributes(View view) {
        checkThread();
        if(mView == view) {
            mAttachInfo.mRecomputeGlobalAttributes = true;
            if(!mWillDrawSoon)
                scheduleTraversals();
        }
    }

    public void requestChildFocus(View view, View view1) {
        checkThread();
        mAttachInfo.mTreeObserver.dispatchOnGlobalFocusChange(mOldFocusedView, view1);
        scheduleTraversals();
        mRealFocusedView = view1;
        mFocusedView = view1;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean flag) {
        return scrollToRectOrFocus(rect, flag);
    }

    public void requestDisallowInterceptTouchEvent(boolean flag) {
    }

    public void requestFitSystemWindows() {
        checkThread();
        mFitSystemWindowsRequested = true;
        scheduleTraversals();
    }

    public void requestLayout() {
        checkThread();
        mLayoutRequested = true;
        scheduleTraversals();
    }

    public boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityevent) {
        if(mView != null) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        switch(accessibilityevent.getEventType()) {
        default:
            break;

        case 32768: 
            break; /* Loop/switch isn't completed */

        case 65536: 
            break;
        }
        break MISSING_BLOCK_LABEL_118;
_L5:
        mAccessibilityManager.sendAccessibilityEvent(accessibilityevent);
        flag = true;
        if(true) goto _L4; else goto _L3
_L3:
        long l = accessibilityevent.getSourceNodeId();
        int j = AccessibilityNodeInfo.getAccessibilityViewId(l);
        View view2 = mView.findViewByAccessibilityId(j);
        if(view2 != null) {
            AccessibilityNodeProvider accessibilitynodeprovider = view2.getAccessibilityNodeProvider();
            if(accessibilitynodeprovider != null)
                setAccessibilityFocus(view2, accessibilitynodeprovider.createAccessibilityNodeInfo(AccessibilityNodeInfo.getVirtualDescendantId(l)));
        }
          goto _L5
        int i = AccessibilityNodeInfo.getAccessibilityViewId(accessibilityevent.getSourceNodeId());
        View view1 = mView.findViewByAccessibilityId(i);
        if(view1 != null && view1.getAccessibilityNodeProvider() != null)
            setAccessibilityFocus(null, null);
          goto _L5
    }

    public void requestTransitionStart(LayoutTransition layouttransition) {
        if(mPendingTransitions == null || !mPendingTransitions.contains(layouttransition)) {
            if(mPendingTransitions == null)
                mPendingTransitions = new ArrayList();
            mPendingTransitions.add(layouttransition);
        }
    }

    public void requestTransparentRegion(View view) {
        checkThread();
        if(mView == view) {
            View view1 = mView;
            view1.mPrivateFlags = 0x200 | view1.mPrivateFlags;
            mWindowAttributesChanged = true;
            mWindowAttributesChangesFlag = 0;
            requestLayout();
        }
    }

    public void requestUpdateConfiguration(Configuration configuration) {
        Message message = mHandler.obtainMessage(18, configuration);
        mHandler.sendMessage(message);
    }

    void scheduleConsumeBatchedInput() {
        if(!mConsumeBatchedInputScheduled) {
            mConsumeBatchedInputScheduled = true;
            mChoreographer.postCallback(0, mConsumedBatchedInputRunnable, null);
        }
    }

    void scheduleTraversals() {
        if(!mTraversalScheduled) {
            mTraversalScheduled = true;
            mTraversalBarrier = mHandler.getLooper().postSyncBarrier();
            mChoreographer.postCallback(2, mTraversalRunnable, null);
            scheduleConsumeBatchedInput();
        }
    }

    boolean scrollToRectOrFocus(Rect rect, boolean flag) {
        Rect rect1;
        Rect rect2;
        int i;
        boolean flag1;
        View.AttachInfo attachinfo = mAttachInfo;
        rect1 = attachinfo.mContentInsets;
        rect2 = attachinfo.mVisibleInsets;
        i = 0;
        flag1 = false;
        if(rect2.left <= rect1.left && rect2.top <= rect1.top && rect2.right <= rect1.right && rect2.bottom <= rect1.bottom) goto _L2; else goto _L1
_L1:
        View view;
        i = mScrollY;
        view = mRealFocusedView;
        if(view != null && view.mAttachInfo == mAttachInfo) goto _L4; else goto _L3
_L3:
        boolean flag2;
        mRealFocusedView = null;
        flag2 = false;
_L6:
        return flag2;
_L4:
        if(view != mLastScrolledFocus)
            rect = null;
          goto _L5
_L2:
        if(i != mScrollY) {
            if(!flag && mResizeBuffer == null) {
                if(mScroller == null)
                    mScroller = new Scroller(mView.getContext());
                mScroller.startScroll(0, mScrollY, 0, i - mScrollY);
            } else
            if(mScroller != null)
                mScroller.abortAnimation();
            mScrollY = i;
        }
        flag2 = flag1;
        if(true) goto _L6; else goto _L5
_L5:
        if((view != mLastScrolledFocus || mScrollMayChange || rect != null) && view != null) {
            mLastScrolledFocus = view;
            mScrollMayChange = false;
            if(view.getGlobalVisibleRect(mVisRect, null)) {
                if(rect == null) {
                    view.getFocusedRect(mTempRect);
                    if(mView instanceof ViewGroup)
                        ((ViewGroup)mView).offsetDescendantRectToMyCoords(view, mTempRect);
                } else {
                    mTempRect.set(rect);
                }
                if(mTempRect.intersect(mVisRect)) {
                    if(mTempRect.height() <= mView.getHeight() - rect2.top - rect2.bottom)
                        if(mTempRect.top - i < rect2.top)
                            i -= rect2.top - (mTempRect.top - i);
                        else
                        if(mTempRect.bottom - i > mView.getHeight() - rect2.bottom)
                            i += mTempRect.bottom - i - (mView.getHeight() - rect2.bottom);
                    flag1 = true;
                }
            }
        }
          goto _L2
    }

    void setAccessibilityFocus(View view, AccessibilityNodeInfo accessibilitynodeinfo) {
        if(mAccessibilityFocusedVirtualView != null) {
            AccessibilityNodeInfo accessibilitynodeinfo1 = mAccessibilityFocusedVirtualView;
            View view1 = mAccessibilityFocusedHost;
            view1.clearAccessibilityFocusNoCallbacks();
            mAccessibilityFocusedHost = null;
            mAccessibilityFocusedVirtualView = null;
            AccessibilityNodeProvider accessibilitynodeprovider = view1.getAccessibilityNodeProvider();
            if(accessibilitynodeprovider != null) {
                accessibilitynodeinfo1.getBoundsInParent(mTempRect);
                view1.invalidate(mTempRect);
                accessibilitynodeprovider.performAction(AccessibilityNodeInfo.getVirtualDescendantId(accessibilitynodeinfo1.getSourceNodeId()), 128, null);
            }
            accessibilitynodeinfo1.recycle();
        }
        if(mAccessibilityFocusedHost != null)
            mAccessibilityFocusedHost.clearAccessibilityFocusNoCallbacks();
        mAccessibilityFocusedHost = view;
        mAccessibilityFocusedVirtualView = accessibilitynodeinfo;
    }

    public void setDragFocus(View view) {
        if(mCurrentDragView != view)
            mCurrentDragView = view;
    }

    void setLayoutParams(WindowManager.LayoutParams layoutparams, boolean flag) {
        this;
        JVM INSTR monitorenter ;
        int i = mWindowAttributes.softInputMode;
        mClientWindowLayoutFlags = layoutparams.flags;
        int j = 0x20000000 & mWindowAttributes.flags;
        layoutparams.systemUiVisibility = mWindowAttributes.systemUiVisibility;
        layoutparams.subtreeSystemUiVisibility = mWindowAttributes.subtreeSystemUiVisibility;
        mWindowAttributesChangesFlag = mWindowAttributes.copyFrom(layoutparams);
        WindowManager.LayoutParams layoutparams1 = mWindowAttributes;
        layoutparams1.flags = j | layoutparams1.flags;
        applyKeepScreenOnFlag(mWindowAttributes);
        if(flag) {
            mSoftInputMode = layoutparams.softInputMode;
            requestLayout();
        }
        if((0xf0 & layoutparams.softInputMode) == 0)
            mWindowAttributes.softInputMode = 0xffffff0f & mWindowAttributes.softInputMode | i & 0xf0;
        mWindowAttributesChanged = true;
        scheduleTraversals();
        return;
    }

    void setLocalDragState(Object obj) {
        mLocalDragState = obj;
    }

    void setStopped(boolean flag) {
        if(mStopped != flag) {
            mStopped = flag;
            if(!flag)
                scheduleTraversals();
        }
    }

    public void setView(View view, WindowManager.LayoutParams layoutparams, View view1) {
        this;
        JVM INSTR monitorenter ;
        if(mView != null) goto _L2; else goto _L1
_L1:
        WindowManager.LayoutParams layoutparams1;
        boolean flag;
        View.AttachInfo attachinfo;
        mView = view;
        mFallbackEventHandler.setView(view);
        mWindowAttributes.copyFrom(layoutparams);
        layoutparams1 = mWindowAttributes;
        mClientWindowLayoutFlags = layoutparams1.flags;
        setAccessibilityFocus(null, null);
        if(view instanceof RootViewSurfaceTaker) {
            mSurfaceHolderCallback = ((RootViewSurfaceTaker)view).willYouTakeTheSurface();
            if(mSurfaceHolderCallback != null) {
                mSurfaceHolder = new TakenSurfaceHolder();
                mSurfaceHolder.setFormat(0);
            }
        }
        CompatibilityInfo compatibilityinfo = mCompatibilityInfo.get();
        mTranslator = compatibilityinfo.getTranslator();
        if(mSurfaceHolder == null)
            enableHardwareAcceleration(mView.getContext(), layoutparams1);
        flag = false;
        if(mTranslator != null) {
            mSurface.setCompatibilityTranslator(mTranslator);
            flag = true;
            layoutparams1.backup();
            mTranslator.translateWindowLayout(layoutparams1);
        }
        if(!compatibilityinfo.supportsScreen()) {
            layoutparams1.flags = 0x20000000 | layoutparams1.flags;
            mLastInCompatMode = true;
        }
        mSoftInputMode = layoutparams1.softInputMode;
        mWindowAttributesChanged = true;
        mWindowAttributesChangesFlag = -1;
        mAttachInfo.mRootView = view;
        attachinfo = mAttachInfo;
        if(mTranslator == null) goto _L4; else goto _L3
_L3:
        boolean flag1 = true;
_L18:
        View.AttachInfo attachinfo1;
        attachinfo.mScalingRequired = flag1;
        attachinfo1 = mAttachInfo;
        if(mTranslator != null) goto _L6; else goto _L5
_L5:
        float f = 1.0F;
_L10:
        attachinfo1.mApplicationScale = f;
        if(view1 != null)
            mAttachInfo.mPanelParentWindowToken = view1.getApplicationWindowToken();
        mAdded = true;
        requestLayout();
        if((2 & mWindowAttributes.inputFeatures) == 0)
            mInputChannel = new InputChannel();
        int i;
        mOrigWindowType = mWindowAttributes.type;
        mAttachInfo.mRecomputeGlobalAttributes = true;
        collectViewAttributes();
        i = sWindowSession.add(mWindow, mSeq, mWindowAttributes, getHostVisibility(), mAttachInfo.mContentInsets, mInputChannel);
        if(flag)
            layoutparams1.restore();
        if(mTranslator != null)
            mTranslator.translateRectInScreenToAppWindow(mAttachInfo.mContentInsets);
        mPendingContentInsets.set(mAttachInfo.mContentInsets);
        mPendingVisibleInsets.set(0, 0, 0, 0);
        if(i >= 0) goto _L8; else goto _L7
_L7:
        mView = null;
        mAttachInfo.mRootView = null;
        mAdded = false;
        mFallbackEventHandler.setView(null);
        unscheduleTraversals();
        setAccessibilityFocus(null, null);
        Exception exception;
        Exception exception1;
        RemoteException remoteexception;
        switch(i) {
        default:
            throw new RuntimeException((new StringBuilder()).append("Unable to add window -- unknown error code ").append(i).toString());

        case -2: 
        case -1: 
            throw new WindowManager.BadTokenException((new StringBuilder()).append("Unable to add window -- token ").append(layoutparams1.token).append(" is not valid; is your activity running?").toString());

        case -3: 
            throw new WindowManager.BadTokenException((new StringBuilder()).append("Unable to add window -- token ").append(layoutparams1.token).append(" is not for an application").toString());

        case -4: 
            throw new WindowManager.BadTokenException((new StringBuilder()).append("Unable to add window -- app for token ").append(layoutparams1.token).append(" is exiting").toString());

        case -5: 
            throw new WindowManager.BadTokenException((new StringBuilder()).append("Unable to add window -- window ").append(mWindow).append(" has already been added").toString());

        case -7: 
            throw new WindowManager.BadTokenException((new StringBuilder()).append("Unable to add window ").append(mWindow).append(" -- another window of this type already exists").toString());

        case -8: 
            throw new WindowManager.BadTokenException((new StringBuilder()).append("Unable to add window ").append(mWindow).append(" -- permission denied for this window type").toString());

        case -6: 
            break;
        }
          goto _L9
        exception;
        throw exception;
_L4:
        flag1 = false;
        continue; /* Loop/switch isn't completed */
_L6:
        f = mTranslator.applicationScale;
          goto _L10
        remoteexception;
        mAdded = false;
        mView = null;
        mAttachInfo.mRootView = null;
        mInputChannel = null;
        mFallbackEventHandler.setView(null);
        unscheduleTraversals();
        setAccessibilityFocus(null, null);
        throw new RuntimeException("Adding window failed", remoteexception);
        exception1;
        if(!flag)
            break MISSING_BLOCK_LABEL_656;
        layoutparams1.restore();
        throw exception1;
_L8:
        boolean flag2;
        boolean flag3;
        if(view instanceof RootViewSurfaceTaker)
            mInputQueueCallback = ((RootViewSurfaceTaker)view).willYouTakeTheInputQueue();
        if(mInputChannel != null)
            if(mInputQueueCallback != null) {
                mInputQueue = new InputQueue(mInputChannel);
                mInputQueueCallback.onInputQueueCreated(mInputQueue);
            } else {
                mInputEventReceiver = new WindowInputEventReceiver(mInputChannel, Looper.myLooper());
            }
        view.assignParent(this);
        if((i & 1) == 0) goto _L12; else goto _L11
_L11:
        flag2 = true;
_L15:
        mAddedTouchMode = flag2;
        if((i & 2) == 0) goto _L14; else goto _L13
_L13:
        flag3 = true;
_L16:
        mAppVisible = flag3;
        if(mAccessibilityManager.isEnabled())
            mAccessibilityInteractionConnectionManager.ensureConnection();
        if(view.getImportantForAccessibility() == 0)
            view.setImportantForAccessibility(1);
_L2:
        this;
        JVM INSTR monitorexit ;
          goto _L9
_L12:
        flag2 = false;
          goto _L15
_L14:
        flag3 = false;
          goto _L16
_L9:
        return;
        if(true) goto _L18; else goto _L17
_L17:
    }

    public boolean showContextMenuForChild(View view) {
        return false;
    }

    public void skipNextResizedMsg() {
        mSkipResizedMsg = true;
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    void terminateHardwareResources() {
        if(mAttachInfo.mHardwareRenderer != null) {
            mAttachInfo.mHardwareRenderer.destroyHardwareResources(mView);
            mAttachInfo.mHardwareRenderer.destroy(false);
        }
    }

    void unscheduleConsumeBatchedInput() {
        if(mConsumeBatchedInputScheduled) {
            mConsumeBatchedInputScheduled = false;
            mChoreographer.removeCallbacks(0, mConsumedBatchedInputRunnable, null);
        }
    }

    void unscheduleTraversals() {
        if(mTraversalScheduled) {
            mTraversalScheduled = false;
            mHandler.getLooper().removeSyncBarrier(mTraversalBarrier);
            mChoreographer.removeCallbacks(2, mTraversalRunnable, null);
        }
    }

    void updateConfiguration(Configuration configuration, boolean flag) {
        CompatibilityInfo compatibilityinfo = mCompatibilityInfo.getIfNeeded();
        if(compatibilityinfo != null) {
            Configuration configuration1 = new Configuration(configuration);
            compatibilityinfo.applyToConfiguration(configuration1);
            configuration = configuration1;
        }
        synchronized(sConfigCallbacks) {
            for(int i = -1 + sConfigCallbacks.size(); i >= 0; i--)
                ((ComponentCallbacks)sConfigCallbacks.get(i)).onConfigurationChanged(configuration);

        }
        if(mView != null) {
            Configuration configuration2 = mView.getResources().getConfiguration();
            if(flag || mLastConfiguration.diff(configuration2) != 0) {
                mLastConfiguration.setTo(configuration2);
                mView.dispatchConfigurationChanged(configuration2);
            }
        }
        return;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void windowFocusChanged(boolean flag, boolean flag1) {
        int i = 1;
        Message message = Message.obtain();
        message.what = 6;
        int j;
        if(flag)
            j = i;
        else
            j = 0;
        message.arg1 = j;
        if(!flag1)
            i = 0;
        message.arg2 = i;
        mHandler.sendMessage(message);
    }

    private static final boolean DBG = false;
    private static final boolean DEBUG_CONFIGURATION = false;
    private static final boolean DEBUG_DIALOG = false;
    private static final boolean DEBUG_DRAW = false;
    private static final boolean DEBUG_FPS = false;
    private static final boolean DEBUG_IMF = false;
    private static final boolean DEBUG_INPUT_RESIZE = false;
    private static final boolean DEBUG_LAYOUT = false;
    private static final boolean DEBUG_ORIENTATION = false;
    private static final boolean DEBUG_TRACKBALL = false;
    private static final boolean LOCAL_LOGV = false;
    private static final int MAX_QUEUED_INPUT_EVENT_POOL_SIZE = 10;
    static final int MAX_TRACKBALL_DELAY = 250;
    private static final boolean MEASURE_LATENCY = false;
    private static final int MSG_CHECK_FOCUS = 13;
    private static final int MSG_CLEAR_ACCESSIBILITY_FOCUS_HOST = 22;
    private static final int MSG_CLOSE_SYSTEM_DIALOGS = 14;
    private static final int MSG_DIE = 3;
    private static final int MSG_DISPATCH_APP_VISIBILITY = 8;
    private static final int MSG_DISPATCH_DONE_ANIMATING = 23;
    private static final int MSG_DISPATCH_DRAG_EVENT = 15;
    private static final int MSG_DISPATCH_DRAG_LOCATION_EVENT = 16;
    private static final int MSG_DISPATCH_GET_NEW_SURFACE = 9;
    private static final int MSG_DISPATCH_KEY = 7;
    private static final int MSG_DISPATCH_KEY_FROM_IME = 11;
    private static final int MSG_DISPATCH_SCREEN_STATE = 20;
    private static final int MSG_DISPATCH_SYSTEM_UI_VISIBILITY = 17;
    private static final int MSG_FINISH_INPUT_CONNECTION = 12;
    private static final int MSG_IME_FINISHED_EVENT = 10;
    private static final int MSG_INVALIDATE = 1;
    private static final int MSG_INVALIDATE_DISPLAY_LIST = 21;
    private static final int MSG_INVALIDATE_RECT = 2;
    private static final int MSG_INVALIDATE_WORLD = 24;
    private static final int MSG_PROCESS_INPUT_EVENTS = 19;
    private static final int MSG_RESIZED = 4;
    private static final int MSG_RESIZED_REPORT = 5;
    private static final int MSG_UPDATE_CONFIGURATION = 18;
    private static final int MSG_WINDOW_FOCUS_CHANGED = 6;
    private static final String PROPERTY_PROFILE_RENDERING = "viewancestor.profile_rendering";
    private static final String TAG = "ViewRootImpl";
    private static final boolean USE_RENDER_THREAD;
    private static LatencyTimer lt;
    static boolean mInitialized = false;
    static final Interpolator mResizeInterpolator = new AccelerateDecelerateInterpolator();
    static final Object mStaticInit = new Object();
    static final ArrayList sConfigCallbacks = new ArrayList();
    static boolean sFirstDrawComplete = false;
    static final ArrayList sFirstDrawHandlers = new ArrayList();
    private static boolean sRenderThreadQueried = false;
    private static final Object sRenderThreadQueryLock[] = new Object[0];
    static final ThreadLocal sRunQueues = new ThreadLocal();
    private static boolean sUseRenderThread = false;
    static IWindowSession sWindowSession;
    View mAccessibilityFocusedHost;
    AccessibilityNodeInfo mAccessibilityFocusedVirtualView;
    AccessibilityInteractionConnectionManager mAccessibilityInteractionConnectionManager;
    AccessibilityInteractionController mAccessibilityInteractionController;
    final AccessibilityManager mAccessibilityManager;
    int mAddNesting;
    boolean mAdded;
    boolean mAddedTouchMode;
    boolean mAppVisible;
    final View.AttachInfo mAttachInfo;
    AudioManager mAudioManager;
    Choreographer mChoreographer;
    int mClientWindowLayoutFlags;
    CompatibilityInfoHolder mCompatibilityInfo;
    boolean mConsumeBatchedInputScheduled;
    final ConsumeBatchedInputRunnable mConsumedBatchedInputRunnable = new ConsumeBatchedInputRunnable();
    int mCurScrollY;
    final Rect mCurrentDirty = new Rect();
    View mCurrentDragView;
    QueuedInputEvent mCurrentInputEvent;
    private final int mDensity;
    Rect mDirty;
    private final ArrayList mDisplayLists = new ArrayList(24);
    ClipDescription mDragDescription;
    final PointF mDragPoint = new PointF();
    boolean mDrawingAllowed;
    FallbackEventHandler mFallbackEventHandler;
    boolean mFirst;
    QueuedInputEvent mFirstPendingInputEvent;
    final Rect mFitSystemWindowsInsets = new Rect();
    boolean mFitSystemWindowsRequested;
    View mFocusedView;
    private int mFpsNumFrames;
    private long mFpsPrevTime;
    private long mFpsStartTime;
    boolean mFullRedrawNeeded;
    final ViewRootHandler mHandler = new ViewRootHandler();
    int mHardwareYOffset;
    boolean mHasHadWindowFocus;
    int mHeight;
    private SurfaceHolder mHolder;
    InputChannel mInputChannel;
    protected final InputEventConsistencyVerifier mInputEventConsistencyVerifier;
    WindowInputEventReceiver mInputEventReceiver;
    final InputMethodCallback mInputMethodCallback = new InputMethodCallback(this);
    InputQueue mInputQueue;
    InputQueue.Callback mInputQueueCallback;
    final InvalidateOnAnimationRunnable mInvalidateOnAnimationRunnable = new InvalidateOnAnimationRunnable();
    boolean mIsAnimating;
    boolean mIsCreating;
    boolean mIsDrawing;
    final Configuration mLastConfiguration = new Configuration();
    final ViewTreeObserver.InternalInsetsInfo mLastGivenInsets = new ViewTreeObserver.InternalInsetsInfo();
    boolean mLastInCompatMode;
    int mLastJoystickXDirection;
    int mLastJoystickXKeyCode;
    int mLastJoystickYDirection;
    int mLastJoystickYKeyCode;
    View mLastScrolledFocus;
    int mLastSystemUiVisibility;
    final PointF mLastTouchPoint = new PointF();
    long mLastTrackballTime;
    boolean mLastWasImTarget;
    boolean mLayoutRequested;
    volatile Object mLocalDragState;
    final WindowLeaked mLocation = new WindowLeaked(null);
    boolean mNewSurfaceNeeded;
    View mOldFocusedView;
    int mOrigWindowType;
    final Configuration mPendingConfiguration = new Configuration();
    final Rect mPendingContentInsets = new Rect();
    private ArrayList mPendingTransitions;
    final Rect mPendingVisibleInsets = new Rect();
    final Rect mPreviousDirty = new Rect();
    final Region mPreviousTransparentRegion = new Region();
    boolean mProcessInputEventsScheduled;
    private boolean mProfile;
    private boolean mProfileRendering;
    private QueuedInputEvent mQueuedInputEventPool;
    private int mQueuedInputEventPoolSize;
    View mRealFocusedView;
    private Thread mRenderProfiler;
    private volatile boolean mRenderProfilingEnabled;
    boolean mReportNextDraw;
    int mResizeAlpha;
    HardwareLayer mResizeBuffer;
    int mResizeBufferDuration;
    long mResizeBufferStartTime;
    final Paint mResizePaint = new Paint();
    boolean mScrollMayChange;
    int mScrollY;
    Scroller mScroller;
    SendWindowContentChangedAccessibilityEvent mSendWindowContentChangedAccessibilityEvent;
    int mSeq;
    private boolean mSkipResizedMsg;
    int mSoftInputMode;
    boolean mStopped;
    private final Surface mSurface = new Surface();
    BaseSurfaceHolder mSurfaceHolder;
    SurfaceHolder.Callback2 mSurfaceHolderCallback;
    final int mTargetSdkVersion;
    HashSet mTempHashSet;
    final Rect mTempRect = new Rect();
    final Thread mThread = Thread.currentThread();
    final int mTmpLocation[] = new int[2];
    final TypedValue mTmpValue = new TypedValue();
    final TrackballAxis mTrackballAxisX = new TrackballAxis();
    final TrackballAxis mTrackballAxisY = new TrackballAxis();
    android.content.res.CompatibilityInfo.Translator mTranslator;
    final Region mTransparentRegion = new Region();
    int mTraversalBarrier;
    final TraversalRunnable mTraversalRunnable = new TraversalRunnable();
    boolean mTraversalScheduled;
    View mView;
    final ViewConfiguration mViewConfiguration;
    int mViewVisibility;
    final Rect mVisRect = new Rect();
    int mWidth;
    boolean mWillDrawSoon;
    final Rect mWinFrame = new Rect();
    final W mWindow = new W(this);
    final WindowManager.LayoutParams mWindowAttributes = new WindowManager.LayoutParams();
    boolean mWindowAttributesChanged;
    int mWindowAttributesChangesFlag;
    boolean mWindowsAnimating;









}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.content.Context;
import android.content.res.*;
import android.graphics.*;
import android.os.*;
import android.util.AttributeSet;
import android.util.Log;
import com.android.internal.view.BaseIWindow;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package android.view:
//            View, Surface, ViewRootImpl, IWindowSession, 
//            ViewParent, ViewTreeObserver, SurfaceHolder

public class SurfaceView extends View {
    private static class MyWindow extends BaseIWindow {

        public void dispatchAppVisibility(boolean flag) {
        }

        public void dispatchGetNewSurface() {
            SurfaceView surfaceview = (SurfaceView)mSurfaceView.get();
            if(surfaceview != null) {
                Message message = surfaceview.mHandler.obtainMessage(2);
                surfaceview.mHandler.sendMessage(message);
            }
        }

        public void executeCommand(String s, String s1, ParcelFileDescriptor parcelfiledescriptor) {
        }

        public void resized(int i, int j, Rect rect, Rect rect1, boolean flag, Configuration configuration) {
            SurfaceView surfaceview = (SurfaceView)mSurfaceView.get();
            if(surfaceview == null) goto _L2; else goto _L1
_L1:
            surfaceview.mSurfaceLock.lock();
            if(!flag) goto _L4; else goto _L3
_L3:
            surfaceview.mUpdateWindowNeeded = true;
            surfaceview.mReportDrawNeeded = true;
            surfaceview.mHandler.sendEmptyMessage(3);
_L6:
            surfaceview.mSurfaceLock.unlock();
_L2:
            return;
_L4:
            if(surfaceview.mWinFrame.width() == i && surfaceview.mWinFrame.height() == j) goto _L6; else goto _L5
_L5:
            surfaceview.mUpdateWindowNeeded = true;
            surfaceview.mHandler.sendEmptyMessage(3);
              goto _L6
            Exception exception;
            exception;
            surfaceview.mSurfaceLock.unlock();
            throw exception;
        }

        public void windowFocusChanged(boolean flag, boolean flag1) {
            Log.w("SurfaceView", (new StringBuilder()).append("Unexpected focus in surface: focus=").append(flag).append(", touchEnabled=").append(flag1).toString());
        }

        int mCurHeight;
        int mCurWidth;
        private final WeakReference mSurfaceView;

        public MyWindow(SurfaceView surfaceview) {
            mCurWidth = -1;
            mCurHeight = -1;
            mSurfaceView = new WeakReference(surfaceview);
        }
    }


    public SurfaceView(Context context) {
        super(context);
        mCallbacks = new ArrayList();
        mLocation = new int[2];
        mSurfaceLock = new ReentrantLock();
        mSurface = new Surface();
        mNewSurface = new Surface();
        mDrawingStopped = true;
        mLayout = new WindowManager.LayoutParams();
        mVisibleInsets = new Rect();
        mWinFrame = new Rect();
        mContentInsets = new Rect();
        mConfiguration = new Configuration();
        mWindowType = 1001;
        mIsCreating = false;
        mHandler = new Handler() {

            public void handleMessage(Message message) {
                boolean flag = false;
                message.what;
                JVM INSTR tableswitch 1 3: default 32
            //                           1 33
            //                           2 55
            //                           3 65;
                   goto _L1 _L2 _L3 _L4
_L1:
                return;
_L2:
                SurfaceView surfaceview = SurfaceView.this;
                if(message.arg1 != 0)
                    flag = true;
                surfaceview.setKeepScreenOn(flag);
                continue; /* Loop/switch isn't completed */
_L3:
                handleGetNewSurface();
                continue; /* Loop/switch isn't completed */
_L4:
                updateWindow(false, false);
                if(true) goto _L1; else goto _L5
_L5:
            }

            final SurfaceView this$0;

             {
                this$0 = SurfaceView.this;
                super();
            }
        };
        mScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() {

            public void onScrollChanged() {
                updateWindow(false, false);
            }

            final SurfaceView this$0;

             {
                this$0 = SurfaceView.this;
                super();
            }
        };
        mRequestedVisible = false;
        mWindowVisibility = false;
        mViewVisibility = false;
        mRequestedWidth = -1;
        mRequestedHeight = -1;
        mRequestedFormat = 4;
        mHaveFrame = false;
        mSurfaceCreated = false;
        mLastLockTime = 0L;
        mVisible = false;
        mLeft = -1;
        mTop = -1;
        mWidth = -1;
        mHeight = -1;
        mFormat = -1;
        mSurfaceFrame = new Rect();
        mLastSurfaceWidth = -1;
        mLastSurfaceHeight = -1;
        mDrawListener = new ViewTreeObserver.OnPreDrawListener() {

            public boolean onPreDraw() {
                SurfaceView surfaceview = SurfaceView.this;
                boolean flag;
                if(getWidth() > 0 && getHeight() > 0)
                    flag = true;
                else
                    flag = false;
                surfaceview.mHaveFrame = flag;
                updateWindow(false, false);
                return true;
            }

            final SurfaceView this$0;

             {
                this$0 = SurfaceView.this;
                super();
            }
        };
        init();
    }

    public SurfaceView(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        mCallbacks = new ArrayList();
        mLocation = new int[2];
        mSurfaceLock = new ReentrantLock();
        mSurface = new Surface();
        mNewSurface = new Surface();
        mDrawingStopped = true;
        mLayout = new WindowManager.LayoutParams();
        mVisibleInsets = new Rect();
        mWinFrame = new Rect();
        mContentInsets = new Rect();
        mConfiguration = new Configuration();
        mWindowType = 1001;
        mIsCreating = false;
        mHandler = new _cls1();
        mScrollChangedListener = new _cls2();
        mRequestedVisible = false;
        mWindowVisibility = false;
        mViewVisibility = false;
        mRequestedWidth = -1;
        mRequestedHeight = -1;
        mRequestedFormat = 4;
        mHaveFrame = false;
        mSurfaceCreated = false;
        mLastLockTime = 0L;
        mVisible = false;
        mLeft = -1;
        mTop = -1;
        mWidth = -1;
        mHeight = -1;
        mFormat = -1;
        mSurfaceFrame = new Rect();
        mLastSurfaceWidth = -1;
        mLastSurfaceHeight = -1;
        mDrawListener = new _cls3();
        init();
    }

    public SurfaceView(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        mCallbacks = new ArrayList();
        mLocation = new int[2];
        mSurfaceLock = new ReentrantLock();
        mSurface = new Surface();
        mNewSurface = new Surface();
        mDrawingStopped = true;
        mLayout = new WindowManager.LayoutParams();
        mVisibleInsets = new Rect();
        mWinFrame = new Rect();
        mContentInsets = new Rect();
        mConfiguration = new Configuration();
        mWindowType = 1001;
        mIsCreating = false;
        mHandler = new _cls1();
        mScrollChangedListener = new _cls2();
        mRequestedVisible = false;
        mWindowVisibility = false;
        mViewVisibility = false;
        mRequestedWidth = -1;
        mRequestedHeight = -1;
        mRequestedFormat = 4;
        mHaveFrame = false;
        mSurfaceCreated = false;
        mLastLockTime = 0L;
        mVisible = false;
        mLeft = -1;
        mTop = -1;
        mWidth = -1;
        mHeight = -1;
        mFormat = -1;
        mSurfaceFrame = new Rect();
        mLastSurfaceWidth = -1;
        mLastSurfaceHeight = -1;
        mDrawListener = new _cls3();
        init();
    }

    private SurfaceHolder.Callback[] getSurfaceCallbacks() {
        ArrayList arraylist = mCallbacks;
        arraylist;
        JVM INSTR monitorenter ;
        SurfaceHolder.Callback acallback[] = new SurfaceHolder.Callback[mCallbacks.size()];
        mCallbacks.toArray(acallback);
        return acallback;
    }

    private void init() {
        setWillNotDraw(true);
    }

    private void updateWindow(boolean flag, boolean flag1) {
        if(mHaveFrame) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i;
        int j;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        boolean flag6;
        boolean flag8;
        int j1;
        boolean flag10;
        SurfaceHolder.Callback acallback[];
        boolean flag11;
        int k4;
        ViewRootImpl viewrootimpl = getViewRootImpl();
        if(viewrootimpl != null)
            mTranslator = viewrootimpl.mTranslator;
        if(mTranslator != null)
            mSurface.setCompatibilityTranslator(mTranslator);
        i = mRequestedWidth;
        if(i <= 0)
            i = getWidth();
        j = mRequestedHeight;
        if(j <= 0)
            j = getHeight();
        getLocationInWindow(mLocation);
        WindowManager.LayoutParams layoutparams;
        boolean flag7;
        IWindowSession iwindowsession;
        MyWindow mywindow;
        int k;
        WindowManager.LayoutParams layoutparams1;
        int l;
        int i1;
        int k1;
        int l1;
        int i2;
        SurfaceHolder.Callback acallback4[];
        int l3;
        int i4;
        IWindowSession iwindowsession1;
        MyWindow mywindow1;
        int j4;
        WindowManager.LayoutParams layoutparams2;
        WindowManager.LayoutParams layoutparams3;
        if(mWindow == null)
            flag2 = true;
        else
            flag2 = false;
        if(mFormat != mRequestedFormat)
            flag3 = true;
        else
            flag3 = false;
        if(mWidth != i || mHeight != j)
            flag4 = true;
        else
            flag4 = false;
        if(mVisible != mRequestedVisible)
            flag5 = true;
        else
            flag5 = false;
        if(!flag && !flag2 && !flag3 && !flag4 && !flag5 && mLeft == mLocation[0] && mTop == mLocation[1] && !mUpdateWindowNeeded && !mReportDrawNeeded && !flag1) goto _L1; else goto _L3
_L3:
        flag6 = mRequestedVisible;
        mVisible = flag6;
        mLeft = mLocation[0];
        mTop = mLocation[1];
        mWidth = i;
        mHeight = j;
        mFormat = mRequestedFormat;
        mLayout.x = mLeft;
        mLayout.y = mTop;
        mLayout.width = getWidth();
        mLayout.height = getHeight();
        if(mTranslator != null)
            mTranslator.translateLayoutParamsInAppWindowToScreen(mLayout);
        mLayout.format = mRequestedFormat;
        layoutparams = mLayout;
        layoutparams.flags = 0x4218 | layoutparams.flags;
        if(!getContext().getResources().getCompatibilityInfo().supportsScreen()) {
            layoutparams3 = mLayout;
            layoutparams3.flags = 0x20000000 | layoutparams3.flags;
        }
        if(mWindow != null) goto _L5; else goto _L4
_L4:
        mWindow = new MyWindow(this);
        mLayout.type = mWindowType;
        mLayout.gravity = 51;
        iwindowsession1 = mSession;
        mywindow1 = mWindow;
        j4 = ((BaseIWindow) (mWindow)).mSeq;
        layoutparams2 = mLayout;
        if(!mVisible) goto _L7; else goto _L6
_L6:
        k4 = 0;
_L13:
        iwindowsession1.addWithoutInputChannel(mywindow1, j4, layoutparams2, k4, mContentInsets);
_L5:
        mSurfaceLock.lock();
        mUpdateWindowNeeded = false;
        flag7 = mReportDrawNeeded;
        mReportDrawNeeded = false;
        if(flag6) goto _L9; else goto _L8
_L8:
        flag8 = true;
_L14:
        mDrawingStopped = flag8;
        iwindowsession = mSession;
        mywindow = mWindow;
        k = ((BaseIWindow) (mWindow)).mSeq;
        layoutparams1 = mLayout;
        l = mWidth;
        i1 = mHeight;
        if(!flag6) goto _L11; else goto _L10
_L10:
        j1 = 0;
_L15:
        k1 = iwindowsession.relayout(mywindow, k, layoutparams1, l, i1, j1, 2, mWinFrame, mContentInsets, mVisibleInsets, mConfiguration, mNewSurface);
        if((k1 & 2) != 0)
            mReportDrawNeeded = true;
        mSurfaceFrame.left = 0;
        mSurfaceFrame.top = 0;
        if(mTranslator != null)
            break MISSING_BLOCK_LABEL_884;
        mSurfaceFrame.right = mWinFrame.width();
        mSurfaceFrame.bottom = mWinFrame.height();
_L16:
        l1 = mSurfaceFrame.right;
        i2 = mSurfaceFrame.bottom;
        boolean flag9;
        Exception exception1;
        SurfaceHolder.Callback acallback2[];
        int l2;
        int i3;
        if(mLastSurfaceWidth == l1 && mLastSurfaceHeight == i2)
            flag9 = false;
        else
            flag9 = true;
        mLastSurfaceWidth = l1;
        mLastSurfaceHeight = i2;
        mSurfaceLock.unlock();
        flag10 = flag1 | (flag2 | flag7);
        acallback = null;
        RemoteException remoteexception;
        Exception exception;
        float f;
        if((k1 & 4) != 0)
            flag11 = true;
        else
            flag11 = false;
        if(!mSurfaceCreated || !flag11 && (flag6 || !flag5))
            break MISSING_BLOCK_LABEL_971;
        mSurfaceCreated = false;
        if(!mSurface.isValid())
            break MISSING_BLOCK_LABEL_971;
        acallback = getSurfaceCallbacks();
        acallback4 = acallback;
        l3 = acallback4.length;
        i4 = 0;
_L12:
        if(i4 >= l3)
            break MISSING_BLOCK_LABEL_971;
        acallback4[i4].surfaceDestroyed(mSurfaceHolder);
        i4++;
          goto _L12
_L7:
        k4 = 8;
          goto _L13
_L9:
        flag8 = false;
          goto _L14
_L11:
        j1 = 8;
          goto _L15
        f = mTranslator.applicationInvertedScale;
        mSurfaceFrame.right = (int)(0.5F + f * (float)mWinFrame.width());
        mSurfaceFrame.bottom = (int)(0.5F + f * (float)mWinFrame.height());
          goto _L16
        exception;
        try {
            mSurfaceLock.unlock();
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch(RemoteException remoteexception) { }
          goto _L1
        mSurface.transferFrom(mNewSurface);
        if(!flag6) goto _L18; else goto _L17
_L17:
        if(!mSurfaceCreated && (flag11 || flag5)) {
            mSurfaceCreated = true;
            mIsCreating = true;
            if(acallback == null)
                acallback = getSurfaceCallbacks();
            SurfaceHolder.Callback acallback3[] = acallback;
            int j3 = acallback3.length;
            for(int k3 = 0; k3 < j3; k3++)
                acallback3[k3].surfaceCreated(mSurfaceHolder);

        }
          goto _L19
_L23:
        if(acallback == null)
            acallback = getSurfaceCallbacks();
        SurfaceHolder.Callback acallback1[] = acallback;
        int j2 = acallback1.length;
        for(int k2 = 0; k2 < j2; k2++)
            acallback1[k2].surfaceChanged(mSurfaceHolder, mFormat, i, j);

_L24:
        if(!flag10) goto _L18; else goto _L20
_L20:
        if(acallback == null)
            acallback = getSurfaceCallbacks();
        acallback2 = acallback;
        l2 = acallback2.length;
        i3 = 0;
_L22:
        if(i3 >= l2) goto _L18; else goto _L21
_L21:
        SurfaceHolder.Callback callback = acallback2[i3];
        if(callback instanceof SurfaceHolder.Callback2)
            ((SurfaceHolder.Callback2)callback).surfaceRedrawNeeded(mSurfaceHolder);
        i3++;
          goto _L22
        exception1;
        mIsCreating = false;
        if(flag10)
            mSession.finishDrawing(mWindow);
        mSession.performDeferredDestroy(mWindow);
        throw exception1;
_L18:
        mIsCreating = false;
        if(flag10)
            mSession.finishDrawing(mWindow);
        mSession.performDeferredDestroy(mWindow);
          goto _L1
_L19:
        if(!flag2 && !flag3 && !flag4 && !flag5 && !flag9) goto _L24; else goto _L23
    }

    protected void dispatchDraw(Canvas canvas) {
        if(mWindowType != 1000 && (0x80 & super.mPrivateFlags) == 128)
            canvas.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
        super.dispatchDraw(canvas);
    }

    public void draw(Canvas canvas) {
        if(mWindowType != 1000 && (0x80 & super.mPrivateFlags) == 0)
            canvas.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
        super.draw(canvas);
    }

    public boolean gatherTransparentRegion(Region region) {
        if(mWindowType != 1000) goto _L2; else goto _L1
_L1:
        boolean flag = super.gatherTransparentRegion(region);
_L4:
        return flag;
_L2:
        flag = true;
        if((0x80 & super.mPrivateFlags) != 0)
            break; /* Loop/switch isn't completed */
        flag = super.gatherTransparentRegion(region);
_L6:
        if(PixelFormat.formatHasAlpha(mRequestedFormat))
            flag = false;
        if(true) goto _L4; else goto _L3
_L3:
        if(region == null) goto _L6; else goto _L5
_L5:
        int i = getWidth();
        int j = getHeight();
        if(i > 0 && j > 0) {
            getLocationInWindow(mLocation);
            int k = mLocation[0];
            int l = mLocation[1];
            region.op(k, l, k + i, l + j, android.graphics.Region.Op.UNION);
        }
          goto _L6
    }

    public SurfaceHolder getHolder() {
        return mSurfaceHolder;
    }

    void handleGetNewSurface() {
        updateWindow(false, false);
    }

    public boolean isFixedSize() {
        boolean flag;
        if(mRequestedWidth != -1 || mRequestedHeight != -1)
            flag = true;
        else
            flag = false;
        return flag;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        super.mParent.requestTransparentRegion(this);
        mSession = getWindowSession();
        mLayout.token = getWindowToken();
        mLayout.setTitle("SurfaceView");
        boolean flag;
        if(getVisibility() == 0)
            flag = true;
        else
            flag = false;
        mViewVisibility = flag;
        if(!mGlobalListenersAdded) {
            ViewTreeObserver viewtreeobserver = getViewTreeObserver();
            viewtreeobserver.addOnScrollChangedListener(mScrollChangedListener);
            viewtreeobserver.addOnPreDrawListener(mDrawListener);
            mGlobalListenersAdded = true;
        }
    }

    protected void onDetachedFromWindow() {
        if(mGlobalListenersAdded) {
            ViewTreeObserver viewtreeobserver = getViewTreeObserver();
            viewtreeobserver.removeOnScrollChangedListener(mScrollChangedListener);
            viewtreeobserver.removeOnPreDrawListener(mDrawListener);
            mGlobalListenersAdded = false;
        }
        mRequestedVisible = false;
        updateWindow(false, false);
        mHaveFrame = false;
        if(mWindow != null) {
            try {
                mSession.remove(mWindow);
            }
            catch(RemoteException remoteexception) { }
            mWindow = null;
        }
        mSession = null;
        mLayout.token = null;
        super.onDetachedFromWindow();
    }

    protected void onMeasure(int i, int j) {
        int k;
        int l;
        if(mRequestedWidth >= 0)
            k = resolveSizeAndState(mRequestedWidth, i, 0);
        else
            k = getDefaultSize(0, i);
        if(mRequestedHeight >= 0)
            l = resolveSizeAndState(mRequestedHeight, j, 0);
        else
            l = getDefaultSize(0, j);
        setMeasuredDimension(k, l);
    }

    protected void onWindowVisibilityChanged(int i) {
        boolean flag = true;
        super.onWindowVisibilityChanged(i);
        boolean flag1;
        if(i == 0)
            flag1 = flag;
        else
            flag1 = false;
        mWindowVisibility = flag1;
        if(!mWindowVisibility || !mViewVisibility)
            flag = false;
        mRequestedVisible = flag;
        updateWindow(false, false);
    }

    protected boolean setFrame(int i, int j, int k, int l) {
        boolean flag = super.setFrame(i, j, k, l);
        updateWindow(false, false);
        return flag;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean flag;
        boolean flag1;
        if(i == 0)
            flag = true;
        else
            flag = false;
        mViewVisibility = flag;
        if(mWindowVisibility && mViewVisibility)
            flag1 = true;
        else
            flag1 = false;
        if(flag1 != mRequestedVisible)
            requestLayout();
        mRequestedVisible = flag1;
        updateWindow(false, false);
    }

    public void setWindowType(int i) {
        mWindowType = i;
    }

    public void setZOrderMediaOverlay(boolean flag) {
        int i;
        if(flag)
            i = 1004;
        else
            i = 1001;
        mWindowType = i;
    }

    public void setZOrderOnTop(boolean flag) {
        if(flag) {
            mWindowType = 1000;
            WindowManager.LayoutParams layoutparams1 = mLayout;
            layoutparams1.flags = 0x20000 | layoutparams1.flags;
        } else {
            mWindowType = 1001;
            WindowManager.LayoutParams layoutparams = mLayout;
            layoutparams.flags = 0xfffdffff & layoutparams.flags;
        }
    }

    private static final boolean DEBUG = false;
    static final int GET_NEW_SURFACE_MSG = 2;
    static final int KEEP_SCREEN_ON_MSG = 1;
    private static final String TAG = "SurfaceView";
    static final int UPDATE_WINDOW_MSG = 3;
    final ArrayList mCallbacks;
    final Configuration mConfiguration;
    final Rect mContentInsets;
    private final ViewTreeObserver.OnPreDrawListener mDrawListener;
    boolean mDrawingStopped;
    int mFormat;
    private boolean mGlobalListenersAdded;
    final Handler mHandler;
    boolean mHaveFrame;
    int mHeight;
    boolean mIsCreating;
    long mLastLockTime;
    int mLastSurfaceHeight;
    int mLastSurfaceWidth;
    final WindowManager.LayoutParams mLayout;
    int mLeft;
    final int mLocation[];
    final Surface mNewSurface;
    boolean mReportDrawNeeded;
    int mRequestedFormat;
    int mRequestedHeight;
    boolean mRequestedVisible;
    int mRequestedWidth;
    final ViewTreeObserver.OnScrollChangedListener mScrollChangedListener;
    IWindowSession mSession;
    final Surface mSurface;
    boolean mSurfaceCreated;
    final Rect mSurfaceFrame;
    private SurfaceHolder mSurfaceHolder = new SurfaceHolder() {

        private final Canvas internalLockCanvas(Rect rect) {
            Canvas canvas;
            mSurfaceLock.lock();
            canvas = null;
            if(mDrawingStopped || mWindow == null)
                break MISSING_BLOCK_LABEL_101;
            if(rect == null) {
                if(mTmpDirty == null)
                    mTmpDirty = new Rect();
                mTmpDirty.set(mSurfaceFrame);
                rect = mTmpDirty;
            }
            Canvas canvas1 = mSurface.lockCanvas(rect);
            canvas = canvas1;
_L1:
            Exception exception;
            if(canvas != null) {
                mLastLockTime = SystemClock.uptimeMillis();
            } else {
                long l = SystemClock.uptimeMillis();
                long l1 = 100L + mLastLockTime;
                if(l1 > l) {
                    long l2 = l1 - l;
                    try {
                        Thread.sleep(l2);
                    }
                    catch(InterruptedException interruptedexception) { }
                    l = SystemClock.uptimeMillis();
                }
                mLastLockTime = l;
                mSurfaceLock.unlock();
                canvas = null;
            }
            return canvas;
            exception;
            Log.e("SurfaceHolder", "Exception locking surface", exception);
              goto _L1
        }

        public void addCallback(SurfaceHolder.Callback callback) {
            ArrayList arraylist = mCallbacks;
            arraylist;
            JVM INSTR monitorenter ;
            if(!mCallbacks.contains(callback))
                mCallbacks.add(callback);
            return;
        }

        public Surface getSurface() {
            return mSurface;
        }

        public Rect getSurfaceFrame() {
            return mSurfaceFrame;
        }

        public boolean isCreating() {
            return mIsCreating;
        }

        public Canvas lockCanvas() {
            return internalLockCanvas(null);
        }

        public Canvas lockCanvas(Rect rect) {
            return internalLockCanvas(rect);
        }

        public void removeCallback(SurfaceHolder.Callback callback) {
            ArrayList arraylist = mCallbacks;
            arraylist;
            JVM INSTR monitorenter ;
            mCallbacks.remove(callback);
            return;
        }

        public void setFixedSize(int i, int j) {
            if(mRequestedWidth != i || mRequestedHeight != j) {
                mRequestedWidth = i;
                mRequestedHeight = j;
                requestLayout();
            }
        }

        public void setFormat(int i) {
            if(i == -1)
                i = 4;
            mRequestedFormat = i;
            if(mWindow != null)
                updateWindow(false, false);
        }

        public void setKeepScreenOn(boolean flag) {
            int i = 1;
            Message message = mHandler.obtainMessage(i);
            if(!flag)
                i = 0;
            message.arg1 = i;
            mHandler.sendMessage(message);
        }

        public void setSizeFromLayout() {
            if(mRequestedWidth != -1 || mRequestedHeight != -1) {
                SurfaceView surfaceview = SurfaceView.this;
                mRequestedHeight = -1;
                surfaceview.mRequestedWidth = -1;
                requestLayout();
            }
        }

        public void setType(int i) {
        }

        public void unlockCanvasAndPost(Canvas canvas) {
            mSurface.unlockCanvasAndPost(canvas);
            mSurfaceLock.unlock();
        }

        private static final String LOG_TAG = "SurfaceHolder";
        final SurfaceView this$0;

             {
                this$0 = SurfaceView.this;
                super();
            }
    };
    final ReentrantLock mSurfaceLock;
    Rect mTmpDirty;
    int mTop;
    private android.content.res.CompatibilityInfo.Translator mTranslator;
    boolean mUpdateWindowNeeded;
    boolean mViewVisibility;
    boolean mVisible;
    final Rect mVisibleInsets;
    int mWidth;
    final Rect mWinFrame;
    MyWindow mWindow;
    int mWindowType;
    boolean mWindowVisibility;

}

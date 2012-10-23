// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.service.wallpaper;

import android.app.Service;
import android.content.*;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.*;
import android.util.Log;
import android.view.*;
import com.android.internal.os.HandlerCaller;
import com.android.internal.view.BaseIWindow;
import com.android.internal.view.BaseSurfaceHolder;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package android.service.wallpaper:
//            IWallpaperConnection

public abstract class WallpaperService extends Service {
    class IWallpaperServiceWrapper extends IWallpaperService.Stub {

        public void attach(IWallpaperConnection iwallpaperconnection, IBinder ibinder, int i, boolean flag, int j, int k) {
            new IWallpaperEngineWrapper(mTarget, iwallpaperconnection, ibinder, i, flag, j, k);
        }

        private final WallpaperService mTarget;
        final WallpaperService this$0;

        public IWallpaperServiceWrapper(WallpaperService wallpaperservice1) {
            this$0 = WallpaperService.this;
            super();
            mTarget = wallpaperservice1;
        }
    }

    class IWallpaperEngineWrapper extends IWallpaperEngine.Stub
        implements com.android.internal.os.HandlerCaller.Callback {

        public void destroy() {
            Message message = mCaller.obtainMessage(20);
            mCaller.sendMessage(message);
        }

        public void dispatchPointer(MotionEvent motionevent) {
            if(mEngine != null)
                mEngine.dispatchPointer(motionevent);
            else
                motionevent.recycle();
        }

        public void dispatchWallpaperCommand(String s, int i, int j, int k, Bundle bundle) {
            if(mEngine != null)
                mEngine.mWindow.dispatchWallpaperCommand(s, i, j, k, bundle, false);
        }

        public void executeMessage(Message message) {
            boolean flag = true;
            message.what;
            JVM INSTR lookupswitch 9: default 88
        //                       10: 117
        //                       20: 179
        //                       30: 204
        //                       10000: 222
        //                       10010: 235
        //                       10020: 262
        //                       10025: 273
        //                       10030: 294
        //                       10040: 332;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
            Log.w("WallpaperService", (new StringBuilder()).append("Unknown message type ").append(message.what).toString());
_L14:
            return;
_L2:
            Engine engine1;
            try {
                mConnection.attachEngine(this);
            }
            catch(RemoteException remoteexception) {
                Log.w("WallpaperService", "Wallpaper host disappeared", remoteexception);
                continue; /* Loop/switch isn't completed */
            }
            engine1 = onCreateEngine();
            mEngine = engine1;
            mActiveEngines.add(engine1);
            engine1.attach(this);
            continue; /* Loop/switch isn't completed */
_L3:
            mActiveEngines.remove(mEngine);
            mEngine.detach();
            continue; /* Loop/switch isn't completed */
_L4:
            mEngine.doDesiredSizeChanged(message.arg1, message.arg2);
            continue; /* Loop/switch isn't completed */
_L5:
            mEngine.updateSurface(flag, false, false);
            continue; /* Loop/switch isn't completed */
_L6:
            Engine engine = mEngine;
            if(message.arg1 == 0)
                flag = false;
            engine.doVisibilityChanged(flag);
            continue; /* Loop/switch isn't completed */
_L7:
            mEngine.doOffsetsChanged(flag);
            continue; /* Loop/switch isn't completed */
_L8:
            WallpaperCommand wallpapercommand = (WallpaperCommand)message.obj;
            mEngine.doCommand(wallpapercommand);
            continue; /* Loop/switch isn't completed */
_L9:
            boolean flag2;
            if(message.arg1 != 0)
                flag2 = flag;
            else
                flag2 = false;
            mEngine.updateSurface(flag, false, flag2);
            mEngine.doOffsetsChanged(flag);
            continue; /* Loop/switch isn't completed */
_L10:
            boolean flag1;
            MotionEvent motionevent;
            flag1 = false;
            motionevent = (MotionEvent)message.obj;
            if(motionevent.getAction() != 2)
                break MISSING_BLOCK_LABEL_386;
            Object obj = mEngine.mLock;
            obj;
            JVM INSTR monitorenter ;
            if(mEngine.mPendingMove != motionevent)
                break MISSING_BLOCK_LABEL_408;
            mEngine.mPendingMove = null;
_L12:
            if(!flag1)
                mEngine.onTouchEvent(motionevent);
            motionevent.recycle();
            continue; /* Loop/switch isn't completed */
            flag1 = true;
            if(true) goto _L12; else goto _L11
_L11:
            Exception exception;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
            if(true) goto _L14; else goto _L13
_L13:
        }

        public void setDesiredSize(int i, int j) {
            Message message = mCaller.obtainMessageII(30, i, j);
            mCaller.sendMessage(message);
        }

        public void setVisibility(boolean flag) {
            HandlerCaller handlercaller = mCaller;
            int i;
            Message message;
            if(flag)
                i = 1;
            else
                i = 0;
            message = handlercaller.obtainMessageI(10010, i);
            mCaller.sendMessage(message);
        }

        private final HandlerCaller mCaller;
        final IWallpaperConnection mConnection;
        Engine mEngine;
        final boolean mIsPreview;
        int mReqHeight;
        int mReqWidth;
        final IBinder mWindowToken;
        final int mWindowType;
        final WallpaperService this$0;


        IWallpaperEngineWrapper(WallpaperService wallpaperservice1, IWallpaperConnection iwallpaperconnection, IBinder ibinder, int i, boolean flag, int j, 
                int k) {
            this$0 = WallpaperService.this;
            super();
            Looper looper;
            Message message;
            if(mCallbackLooper != null)
                looper = mCallbackLooper;
            else
                looper = wallpaperservice1.getMainLooper();
            mCaller = new HandlerCaller(wallpaperservice1, looper, this);
            mConnection = iwallpaperconnection;
            mWindowToken = ibinder;
            mWindowType = i;
            mIsPreview = flag;
            mReqWidth = j;
            mReqHeight = k;
            message = mCaller.obtainMessage(10);
            mCaller.sendMessage(message);
        }
    }

    public class Engine {
        final class WallpaperInputEventReceiver extends InputEventReceiver {

            public void onInputEvent(InputEvent inputevent) {
                boolean flag = false;
                if(!(inputevent instanceof MotionEvent) || (2 & inputevent.getSource()) == 0)
                    break MISSING_BLOCK_LABEL_38;
                MotionEvent motionevent = MotionEvent.obtainNoHistory((MotionEvent)inputevent);
                dispatchPointer(motionevent);
                flag = true;
                finishInputEvent(inputevent, flag);
                return;
                Exception exception;
                exception;
                finishInputEvent(inputevent, false);
                throw exception;
            }

            final Engine this$1;

            public WallpaperInputEventReceiver(InputChannel inputchannel, Looper looper) {
                this$1 = Engine.this;
                super(inputchannel, looper);
            }
        }


        private void dispatchPointer(MotionEvent motionevent) {
            if(!motionevent.isTouchEvent())
                break MISSING_BLOCK_LABEL_65;
            Object obj = mLock;
            obj;
            JVM INSTR monitorenter ;
            if(motionevent.getAction() != 2) goto _L2; else goto _L1
_L1:
            mPendingMove = motionevent;
_L3:
            Message message = mCaller.obtainMessageO(10040, motionevent);
            mCaller.sendMessage(message);
_L4:
            return;
_L2:
            mPendingMove = null;
              goto _L3
            Exception exception;
            exception;
            throw exception;
            motionevent.recycle();
              goto _L4
        }

        void attach(IWallpaperEngineWrapper iwallpaperenginewrapper) {
            if(!mDestroyed) {
                mIWallpaperEngine = iwallpaperenginewrapper;
                mCaller = iwallpaperenginewrapper.mCaller;
                mConnection = iwallpaperenginewrapper.mConnection;
                mWindowToken = iwallpaperenginewrapper.mWindowToken;
                mSurfaceHolder.setSizeFromLayout();
                mInitializing = true;
                mSession = ViewRootImpl.getWindowSession(getMainLooper());
                mWindow.setSession(mSession);
                mScreenOn = ((PowerManager)getSystemService("power")).isScreenOn();
                IntentFilter intentfilter = new IntentFilter();
                intentfilter.addAction("android.intent.action.SCREEN_ON");
                intentfilter.addAction("android.intent.action.SCREEN_OFF");
                registerReceiver(mReceiver, intentfilter);
                onCreate(mSurfaceHolder);
                mInitializing = false;
                mReportedVisible = false;
                updateSurface(false, false, false);
            }
        }

        void detach() {
            if(!mDestroyed) goto _L2; else goto _L1
_L1:
            return;
_L2:
            mDestroyed = true;
            if(mVisible) {
                mVisible = false;
                onVisibilityChanged(false);
            }
            reportSurfaceDestroyed();
            onDestroy();
            unregisterReceiver(mReceiver);
            if(mCreated) {
                try {
                    if(mInputEventReceiver != null) {
                        mInputEventReceiver.dispose();
                        mInputEventReceiver = null;
                    }
                    mSession.remove(mWindow);
                }
                catch(RemoteException remoteexception) { }
                mSurfaceHolder.mSurface.release();
                mCreated = false;
                if(mInputChannel != null) {
                    mInputChannel.dispose();
                    mInputChannel = null;
                }
            }
            if(true) goto _L1; else goto _L3
_L3:
        }

        void doCommand(WallpaperCommand wallpapercommand) {
            Bundle bundle;
            if(!mDestroyed)
                bundle = onCommand(wallpapercommand.action, wallpapercommand.x, wallpapercommand.y, wallpapercommand.z, wallpapercommand.extras, wallpapercommand.sync);
            else
                bundle = null;
            if(!wallpapercommand.sync)
                break MISSING_BLOCK_LABEL_60;
            mSession.wallpaperCommandComplete(mWindow.asBinder(), bundle);
_L2:
            return;
            RemoteException remoteexception;
            remoteexception;
            if(true) goto _L2; else goto _L1
_L1:
        }

        void doDesiredSizeChanged(int i, int j) {
            if(!mDestroyed) {
                mIWallpaperEngine.mReqWidth = i;
                mIWallpaperEngine.mReqHeight = j;
                onDesiredSizeChanged(i, j);
                doOffsetsChanged(true);
            }
        }

        void doOffsetsChanged(boolean flag) {
_L2:
            return;
            if(mDestroyed || !flag && !mOffsetsChanged) goto _L2; else goto _L1
_L1:
            float f;
            float f1;
            float f2;
            float f3;
            boolean flag1;
            synchronized(mLock) {
                f = mPendingXOffset;
                f1 = mPendingYOffset;
                f2 = mPendingXOffsetStep;
                f3 = mPendingYOffsetStep;
                flag1 = mPendingSync;
                mPendingSync = false;
                mOffsetMessageEnqueued = false;
            }
            if(mSurfaceCreated)
                if(mReportedVisible) {
                    int i = mIWallpaperEngine.mReqWidth - mCurWidth;
                    RemoteException remoteexception;
                    int j;
                    int k;
                    int l;
                    if(i > 0)
                        j = -(int)(0.5F + f * (float)i);
                    else
                        j = 0;
                    k = mIWallpaperEngine.mReqHeight - mCurHeight;
                    if(k > 0)
                        l = -(int)(0.5F + f1 * (float)k);
                    else
                        l = 0;
                    onOffsetsChanged(f, f1, f2, f3, j, l);
                } else {
                    mOffsetsChanged = true;
                }
            if(flag1)
                try {
                    mSession.wallpaperOffsetsComplete(mWindow.asBinder());
                }
                // Misplaced declaration of an exception variable
                catch(RemoteException remoteexception) { }
            if(true) goto _L2; else goto _L3
_L3:
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        void doVisibilityChanged(boolean flag) {
            if(!mDestroyed) {
                mVisible = flag;
                reportVisibility();
            }
        }

        protected void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
            printwriter.print(s);
            printwriter.print("mInitializing=");
            printwriter.print(mInitializing);
            printwriter.print(" mDestroyed=");
            printwriter.println(mDestroyed);
            printwriter.print(s);
            printwriter.print("mVisible=");
            printwriter.print(mVisible);
            printwriter.print(" mScreenOn=");
            printwriter.print(mScreenOn);
            printwriter.print(" mReportedVisible=");
            printwriter.println(mReportedVisible);
            printwriter.print(s);
            printwriter.print("mCreated=");
            printwriter.print(mCreated);
            printwriter.print(" mSurfaceCreated=");
            printwriter.print(mSurfaceCreated);
            printwriter.print(" mIsCreating=");
            printwriter.print(mIsCreating);
            printwriter.print(" mDrawingAllowed=");
            printwriter.println(mDrawingAllowed);
            printwriter.print(s);
            printwriter.print("mWidth=");
            printwriter.print(mWidth);
            printwriter.print(" mCurWidth=");
            printwriter.print(mCurWidth);
            printwriter.print(" mHeight=");
            printwriter.print(mHeight);
            printwriter.print(" mCurHeight=");
            printwriter.println(mCurHeight);
            printwriter.print(s);
            printwriter.print("mType=");
            printwriter.print(mType);
            printwriter.print(" mWindowFlags=");
            printwriter.print(mWindowFlags);
            printwriter.print(" mCurWindowFlags=");
            printwriter.println(mCurWindowFlags);
            printwriter.print(" mWindowPrivateFlags=");
            printwriter.print(mWindowPrivateFlags);
            printwriter.print(" mCurWindowPrivateFlags=");
            printwriter.println(mCurWindowPrivateFlags);
            printwriter.print(s);
            printwriter.print("mVisibleInsets=");
            printwriter.print(mVisibleInsets.toShortString());
            printwriter.print(" mWinFrame=");
            printwriter.print(mWinFrame.toShortString());
            printwriter.print(" mContentInsets=");
            printwriter.println(mContentInsets.toShortString());
            printwriter.print(s);
            printwriter.print("mConfiguration=");
            printwriter.println(mConfiguration);
            printwriter.print(s);
            printwriter.print("mLayout=");
            printwriter.println(mLayout);
            Object obj = mLock;
            obj;
            JVM INSTR monitorenter ;
            printwriter.print(s);
            printwriter.print("mPendingXOffset=");
            printwriter.print(mPendingXOffset);
            printwriter.print(" mPendingXOffset=");
            printwriter.println(mPendingXOffset);
            printwriter.print(s);
            printwriter.print("mPendingXOffsetStep=");
            printwriter.print(mPendingXOffsetStep);
            printwriter.print(" mPendingXOffsetStep=");
            printwriter.println(mPendingXOffsetStep);
            printwriter.print(s);
            printwriter.print("mOffsetMessageEnqueued=");
            printwriter.print(mOffsetMessageEnqueued);
            printwriter.print(" mPendingSync=");
            printwriter.println(mPendingSync);
            if(mPendingMove != null) {
                printwriter.print(s);
                printwriter.print("mPendingMove=");
                printwriter.println(mPendingMove);
            }
            return;
        }

        public int getDesiredMinimumHeight() {
            return mIWallpaperEngine.mReqHeight;
        }

        public int getDesiredMinimumWidth() {
            return mIWallpaperEngine.mReqWidth;
        }

        public SurfaceHolder getSurfaceHolder() {
            return mSurfaceHolder;
        }

        public boolean isPreview() {
            return mIWallpaperEngine.mIsPreview;
        }

        public boolean isVisible() {
            return mReportedVisible;
        }

        public Bundle onCommand(String s, int i, int j, int k, Bundle bundle, boolean flag) {
            return null;
        }

        public void onCreate(SurfaceHolder surfaceholder) {
        }

        public void onDesiredSizeChanged(int i, int j) {
        }

        public void onDestroy() {
        }

        public void onOffsetsChanged(float f, float f1, float f2, float f3, int i, int j) {
        }

        public void onSurfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k) {
        }

        public void onSurfaceCreated(SurfaceHolder surfaceholder) {
        }

        public void onSurfaceDestroyed(SurfaceHolder surfaceholder) {
        }

        public void onSurfaceRedrawNeeded(SurfaceHolder surfaceholder) {
        }

        public void onTouchEvent(MotionEvent motionevent) {
        }

        public void onVisibilityChanged(boolean flag) {
        }

        void reportSurfaceDestroyed() {
            if(mSurfaceCreated) {
                mSurfaceCreated = false;
                mSurfaceHolder.ungetCallbacks();
                android.view.SurfaceHolder.Callback acallback[] = mSurfaceHolder.getCallbacks();
                if(acallback != null) {
                    int i = acallback.length;
                    for(int j = 0; j < i; j++)
                        acallback[j].surfaceDestroyed(mSurfaceHolder);

                }
                onSurfaceDestroyed(mSurfaceHolder);
            }
        }

        void reportVisibility() {
            if(!mDestroyed) {
                boolean flag;
                if(mVisible && mScreenOn)
                    flag = true;
                else
                    flag = false;
                if(mReportedVisible != flag) {
                    mReportedVisible = flag;
                    if(flag) {
                        doOffsetsChanged(false);
                        updateSurface(false, false, false);
                    }
                    onVisibilityChanged(flag);
                }
            }
        }

        public void setFixedSizeAllowed(boolean flag) {
            mFixedSizeAllowed = flag;
        }

        public void setOffsetNotificationsEnabled(boolean flag) {
            int i;
            if(flag)
                i = 4 | mWindowPrivateFlags;
            else
                i = -5 & mWindowPrivateFlags;
            mWindowPrivateFlags = i;
            if(mCreated)
                updateSurface(false, false, false);
        }

        public void setTouchEventsEnabled(boolean flag) {
            int i;
            if(flag)
                i = 0xffffffef & mWindowFlags;
            else
                i = 0x10 | mWindowFlags;
            mWindowFlags = i;
            if(mCreated)
                updateSurface(false, false, false);
        }

        void updateSurface(boolean flag, boolean flag1, boolean flag2) {
            boolean flag3;
            boolean flag4;
            boolean flag5;
            boolean flag6;
            int k;
            int k1;
            if(mDestroyed)
                Log.w("WallpaperService", "Ignoring updateSurface: destroyed");
            int i = mSurfaceHolder.getRequestedWidth();
            if(i <= 0)
                i = -1;
            int j = mSurfaceHolder.getRequestedHeight();
            if(j <= 0)
                j = -1;
            boolean flag7;
            boolean flag8;
            RemoteException remoteexception;
            int l;
            int i1;
            boolean flag9;
            Exception exception;
            android.view.SurfaceHolder.Callback acallback[];
            android.view.SurfaceHolder.Callback acallback1[];
            int j1;
            android.view.SurfaceHolder.Callback callback;
            int l1;
            int i2;
            android.view.SurfaceHolder.Callback acallback2[];
            int j2;
            int k2;
            if(!mCreated)
                flag3 = true;
            else
                flag3 = false;
            if(!mSurfaceCreated)
                flag4 = true;
            else
                flag4 = false;
            if(mFormat != mSurfaceHolder.getRequestedFormat())
                flag5 = true;
            else
                flag5 = false;
            if(mWidth != i || mHeight != j)
                flag6 = true;
            else
                flag6 = false;
            if(mType != mSurfaceHolder.getRequestedType())
                flag7 = true;
            else
                flag7 = false;
            if(mCurWindowFlags != mWindowFlags || mCurWindowPrivateFlags != mWindowPrivateFlags)
                flag8 = true;
            else
                flag8 = false;
            if(!flag && !flag3 && !flag4 && !flag5 && !flag6 && !flag7 && !flag8 && !flag2) goto _L2; else goto _L1
_L1:
            mWidth = i;
            mHeight = j;
            mFormat = mSurfaceHolder.getRequestedFormat();
            mType = mSurfaceHolder.getRequestedType();
            mLayout.x = 0;
            mLayout.y = 0;
            mLayout.width = i;
            mLayout.height = j;
            mLayout.format = mFormat;
            mCurWindowFlags = mWindowFlags;
            mLayout.flags = 8 | (0x100 | (0x200 | mWindowFlags));
            mCurWindowPrivateFlags = mWindowPrivateFlags;
            mLayout.privateFlags = mWindowPrivateFlags;
            mLayout.memoryType = mType;
            mLayout.token = mWindowToken;
            if(mCreated) goto _L4; else goto _L3
_L3:
            mLayout.type = mIWallpaperEngine.mWindowType;
            mLayout.gravity = 51;
            mLayout.setTitle(getClass().getName());
            mLayout.windowAnimations = 0x10301e8;
            mInputChannel = new InputChannel();
            if(mSession.add(mWindow, mWindow.mSeq, mLayout, 0, mContentInsets, mInputChannel) >= 0) goto _L6; else goto _L5
_L5:
            Log.w("WallpaperService", "Failed to add window while updating wallpaper surface.");
              goto _L2
_L6:
            mCreated = true;
            mInputEventReceiver = new WallpaperInputEventReceiver(mInputChannel, Looper.myLooper());
_L4:
            mSurfaceHolder.mSurfaceLock.lock();
            mDrawingAllowed = true;
            k = mSession.relayout(mWindow, mWindow.mSeq, mLayout, mWidth, mHeight, 0, 0, mWinFrame, mContentInsets, mVisibleInsets, mConfiguration, mSurfaceHolder.mSurface);
            l = mWinFrame.width();
            if(mCurWidth != l) {
                flag6 = true;
                mCurWidth = l;
            }
            i1 = mWinFrame.height();
            if(mCurHeight != i1) {
                flag6 = true;
                mCurHeight = i1;
            }
            mSurfaceHolder.setSurfaceFrameSize(l, i1);
            mSurfaceHolder.mSurfaceLock.unlock();
            if(mSurfaceHolder.mSurface.isValid()) goto _L8; else goto _L7
_L7:
            reportSurfaceDestroyed();
              goto _L2
            remoteexception;
              goto _L2
_L8:
            flag9 = false;
            mSurfaceHolder.ungetCallbacks();
            if(flag4) {
                mIsCreating = true;
                flag9 = true;
                onSurfaceCreated(mSurfaceHolder);
                acallback2 = mSurfaceHolder.getCallbacks();
                if(acallback2 != null) {
                    j2 = acallback2.length;
                    for(k2 = 0; k2 < j2; k2++)
                        acallback2[k2].surfaceCreated(mSurfaceHolder);

                }
            }
              goto _L9
_L15:
            flag9 = true;
            onSurfaceChanged(mSurfaceHolder, mFormat, mCurWidth, mCurHeight);
            acallback = mSurfaceHolder.getCallbacks();
            if(acallback != null) {
                l1 = acallback.length;
                for(i2 = 0; i2 < l1; i2++)
                    acallback[i2].surfaceChanged(mSurfaceHolder, mFormat, mCurWidth, mCurHeight);

            }
_L16:
            if(!flag2) goto _L11; else goto _L10
_L10:
            onSurfaceRedrawNeeded(mSurfaceHolder);
            acallback1 = mSurfaceHolder.getCallbacks();
            if(acallback1 == null) goto _L11; else goto _L12
_L12:
            j1 = acallback1.length;
            k1 = 0;
_L17:
            if(k1 >= j1) goto _L11; else goto _L13
_L13:
            callback = acallback1[k1];
            if(callback instanceof android.view.SurfaceHolder.Callback2)
                ((android.view.SurfaceHolder.Callback2)callback).surfaceRedrawNeeded(mSurfaceHolder);
              goto _L14
_L11:
            if(flag9 && !mReportedVisible) {
                if(mIsCreating)
                    onVisibilityChanged(true);
                onVisibilityChanged(false);
            }
            mIsCreating = false;
            mSurfaceCreated = true;
            if(flag2)
                mSession.finishDrawing(mWindow);
              goto _L2
            exception;
            mIsCreating = false;
            mSurfaceCreated = true;
            if(flag2)
                mSession.finishDrawing(mWindow);
            throw exception;
_L2:
            return;
_L9:
            boolean flag10;
            if(flag3 || (k & 2) != 0)
                flag10 = true;
            else
                flag10 = false;
            flag2 |= flag10;
            if(!flag1 && !flag3 && !flag4 && !flag5 && !flag6) goto _L16; else goto _L15
_L14:
            k1++;
              goto _L17
        }

        HandlerCaller mCaller;
        final Configuration mConfiguration = new Configuration();
        IWallpaperConnection mConnection;
        final Rect mContentInsets = new Rect();
        boolean mCreated;
        int mCurHeight;
        int mCurWidth;
        int mCurWindowFlags;
        int mCurWindowPrivateFlags;
        boolean mDestroyed;
        boolean mDrawingAllowed;
        boolean mFixedSizeAllowed;
        int mFormat;
        int mHeight;
        IWallpaperEngineWrapper mIWallpaperEngine;
        boolean mInitializing;
        InputChannel mInputChannel;
        WallpaperInputEventReceiver mInputEventReceiver;
        boolean mIsCreating;
        final android.view.WindowManager.LayoutParams mLayout = new android.view.WindowManager.LayoutParams();
        final Object mLock = new Object();
        boolean mOffsetMessageEnqueued;
        boolean mOffsetsChanged;
        MotionEvent mPendingMove;
        boolean mPendingSync;
        float mPendingXOffset;
        float mPendingXOffsetStep;
        float mPendingYOffset;
        float mPendingYOffsetStep;
        final BroadcastReceiver mReceiver = new BroadcastReceiver() {

            public void onReceive(Context context, Intent intent) {
                if(!"android.intent.action.SCREEN_ON".equals(intent.getAction())) goto _L2; else goto _L1
_L1:
                mScreenOn = true;
                reportVisibility();
_L4:
                return;
_L2:
                if("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                    mScreenOn = false;
                    reportVisibility();
                }
                if(true) goto _L4; else goto _L3
_L3:
            }

            final Engine this$1;

                 {
                    this$1 = Engine.this;
                    super();
                }
        };
        boolean mReportedVisible;
        boolean mScreenOn;
        IWindowSession mSession;
        boolean mSurfaceCreated;
        final BaseSurfaceHolder mSurfaceHolder = new BaseSurfaceHolder() {

            public boolean isCreating() {
                return mIsCreating;
            }

            public boolean onAllowLockCanvas() {
                return mDrawingAllowed;
            }

            public void onRelayoutContainer() {
                Message message = mCaller.obtainMessage(10000);
                mCaller.sendMessage(message);
            }

            public void onUpdateSurface() {
                Message message = mCaller.obtainMessage(10000);
                mCaller.sendMessage(message);
            }

            public void setFixedSize(int i, int j) {
                if(!mFixedSizeAllowed) {
                    throw new UnsupportedOperationException("Wallpapers currently only support sizing from layout");
                } else {
                    super.setFixedSize(i, j);
                    return;
                }
            }

            public void setKeepScreenOn(boolean flag) {
                throw new UnsupportedOperationException("Wallpapers do not support keep screen on");
            }

            final Engine this$1;

                 {
                    this$1 = Engine.this;
                    super();
                    super.mRequestedFormat = 2;
                }
        };
        int mType;
        boolean mVisible;
        final Rect mVisibleInsets = new Rect();
        int mWidth;
        final Rect mWinFrame = new Rect();
        final BaseIWindow mWindow = new BaseIWindow() {

            public void dispatchAppVisibility(boolean flag) {
                if(!mIWallpaperEngine.mIsPreview) {
                    HandlerCaller handlercaller = mCaller;
                    int i;
                    Message message;
                    if(flag)
                        i = 1;
                    else
                        i = 0;
                    message = handlercaller.obtainMessageI(10010, i);
                    mCaller.sendMessage(message);
                }
            }

            public void dispatchWallpaperCommand(String s, int i, int j, int k, Bundle bundle, boolean flag) {
                Object obj = mLock;
                obj;
                JVM INSTR monitorenter ;
                WallpaperCommand wallpapercommand = new WallpaperCommand();
                wallpapercommand.action = s;
                wallpapercommand.x = i;
                wallpapercommand.y = j;
                wallpapercommand.z = k;
                wallpapercommand.extras = bundle;
                wallpapercommand.sync = flag;
                Message message = mCaller.obtainMessage(10025);
                message.obj = wallpapercommand;
                mCaller.sendMessage(message);
                return;
            }

            public void dispatchWallpaperOffsets(float f, float f1, float f2, float f3, boolean flag) {
                Object obj = mLock;
                obj;
                JVM INSTR monitorenter ;
                mPendingXOffset = f;
                mPendingYOffset = f1;
                mPendingXOffsetStep = f2;
                mPendingYOffsetStep = f3;
                if(flag)
                    mPendingSync = true;
                if(!mOffsetMessageEnqueued) {
                    mOffsetMessageEnqueued = true;
                    Message message = mCaller.obtainMessage(10020);
                    mCaller.sendMessage(message);
                }
                return;
            }

            public void resized(int i, int j, Rect rect, Rect rect1, boolean flag, Configuration configuration) {
                HandlerCaller handlercaller = mCaller;
                int k;
                Message message;
                if(flag)
                    k = 1;
                else
                    k = 0;
                message = handlercaller.obtainMessageI(10030, k);
                mCaller.sendMessage(message);
            }

            final Engine this$1;

                 {
                    this$1 = Engine.this;
                    super();
                }
        };
        int mWindowFlags;
        int mWindowPrivateFlags;
        IBinder mWindowToken;
        final WallpaperService this$0;


        public Engine() {
            this$0 = WallpaperService.this;
            super();
            mInitializing = true;
            mScreenOn = true;
            mWindowFlags = 16;
            mWindowPrivateFlags = 4;
            mCurWindowFlags = mWindowFlags;
            mCurWindowPrivateFlags = mWindowPrivateFlags;
        }
    }

    static final class WallpaperCommand {

        String action;
        Bundle extras;
        boolean sync;
        int x;
        int y;
        int z;

        WallpaperCommand() {
        }
    }


    public WallpaperService() {
    }

    protected void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        printwriter.print("State of wallpaper ");
        printwriter.print(this);
        printwriter.println(":");
        for(int i = 0; i < mActiveEngines.size(); i++) {
            Engine engine = (Engine)mActiveEngines.get(i);
            printwriter.print("  Engine ");
            printwriter.print(engine);
            printwriter.println(":");
            engine.dump("    ", filedescriptor, printwriter, as);
        }

    }

    public final IBinder onBind(Intent intent) {
        return new IWallpaperServiceWrapper(this);
    }

    public void onCreate() {
        super.onCreate();
    }

    public abstract Engine onCreateEngine();

    public void onDestroy() {
        super.onDestroy();
        for(int i = 0; i < mActiveEngines.size(); i++)
            ((Engine)mActiveEngines.get(i)).detach();

        mActiveEngines.clear();
    }

    public void setCallbackLooper(Looper looper) {
        mCallbackLooper = looper;
    }

    static final boolean DEBUG = false;
    private static final int DO_ATTACH = 10;
    private static final int DO_DETACH = 20;
    private static final int DO_SET_DESIRED_SIZE = 30;
    private static final int MSG_TOUCH_EVENT = 10040;
    private static final int MSG_UPDATE_SURFACE = 10000;
    private static final int MSG_VISIBILITY_CHANGED = 10010;
    private static final int MSG_WALLPAPER_COMMAND = 10025;
    private static final int MSG_WALLPAPER_OFFSETS = 10020;
    private static final int MSG_WINDOW_RESIZED = 10030;
    public static final String SERVICE_INTERFACE = "android.service.wallpaper.WallpaperService";
    public static final String SERVICE_META_DATA = "android.service.wallpaper";
    static final String TAG = "WallpaperService";
    private final ArrayList mActiveEngines = new ArrayList();
    private Looper mCallbackLooper;


}

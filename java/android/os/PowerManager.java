// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import android.util.Log;

// Referenced classes of package android.os:
//            RemoteException, IPowerManager, Handler, Binder, 
//            WorkSource, IBinder

public class PowerManager {
    public class WakeLock {

        private void acquireLocked() {
label0:
            {
                if(mRefCounted) {
                    int i = mCount;
                    mCount = i + 1;
                    if(i != 0)
                        break label0;
                }
                mHandler.removeCallbacks(mReleaser);
                try {
                    mService.acquireWakeLock(mFlags, mToken, mTag, mWorkSource);
                }
                catch(RemoteException remoteexception) { }
                mHeld = true;
            }
        }

        public void acquire() {
            IBinder ibinder = mToken;
            ibinder;
            JVM INSTR monitorenter ;
            acquireLocked();
            return;
        }

        public void acquire(long l) {
            IBinder ibinder = mToken;
            ibinder;
            JVM INSTR monitorenter ;
            acquireLocked();
            mHandler.postDelayed(mReleaser, l);
            return;
        }

        protected void finalize() throws Throwable {
            IBinder ibinder = mToken;
            ibinder;
            JVM INSTR monitorenter ;
            if(!mHeld)
                break MISSING_BLOCK_LABEL_59;
            Log.wtf("PowerManager", (new StringBuilder()).append("WakeLock finalized while still held: ").append(mTag).toString());
            Exception exception;
            try {
                mService.releaseWakeLock(mToken, 0);
            }
            catch(RemoteException remoteexception) { }
            ibinder;
            JVM INSTR monitorexit ;
            return;
            exception;
            throw exception;
        }

        public boolean isHeld() {
            IBinder ibinder = mToken;
            ibinder;
            JVM INSTR monitorenter ;
            boolean flag = mHeld;
            return flag;
        }

        public void release() {
            release(0);
        }

        public void release(int i) {
            IBinder ibinder = mToken;
            ibinder;
            JVM INSTR monitorenter ;
            if(mRefCounted) {
                int j = -1 + mCount;
                mCount = j;
                if(j != 0)
                    break MISSING_BLOCK_LABEL_70;
            }
            mHandler.removeCallbacks(mReleaser);
            Exception exception;
            try {
                mService.releaseWakeLock(mToken, i);
            }
            catch(RemoteException remoteexception) { }
            mHeld = false;
            if(mCount < 0)
                throw new RuntimeException((new StringBuilder()).append("WakeLock under-locked ").append(mTag).toString());
            break MISSING_BLOCK_LABEL_112;
            exception;
            throw exception;
            ibinder;
            JVM INSTR monitorexit ;
        }

        public void setReferenceCounted(boolean flag) {
            mRefCounted = flag;
        }

        public void setWorkSource(WorkSource worksource) {
            IBinder ibinder = mToken;
            ibinder;
            JVM INSTR monitorenter ;
            if(worksource == null)
                break MISSING_BLOCK_LABEL_20;
            if(worksource.size() == 0)
                worksource = null;
            boolean flag = true;
            if(worksource != null) goto _L2; else goto _L1
_L1:
            mWorkSource = null;
_L6:
            if(!flag) goto _L4; else goto _L3
_L3:
            boolean flag1 = mHeld;
            if(flag1)
                try {
                    mService.updateWakeLockWorkSource(mToken, mWorkSource);
                }
                catch(RemoteException remoteexception) { }
                finally {
                    ibinder;
                }
_L4:
            ibinder;
            JVM INSTR monitorexit ;
            return;
_L2:
            if(mWorkSource != null)
                break MISSING_BLOCK_LABEL_112;
            Exception exception;
            if(mWorkSource != null)
                flag = true;
            else
                flag = false;
            mWorkSource = new WorkSource(worksource);
            if(true) goto _L6; else goto _L5
_L5:
            JVM INSTR monitorexit ;
            throw exception;
            flag = mWorkSource.diff(worksource);
            if(flag)
                mWorkSource.set(worksource);
              goto _L6
        }

        public String toString() {
            IBinder ibinder = mToken;
            ibinder;
            JVM INSTR monitorenter ;
            String s = (new StringBuilder()).append("WakeLock{").append(Integer.toHexString(System.identityHashCode(this))).append(" held=").append(mHeld).append(", refCount=").append(mCount).append("}").toString();
            return s;
        }

        static final int RELEASE_WAKE_LOCK = 1;
        int mCount;
        int mFlags;
        boolean mHeld;
        boolean mRefCounted;
        Runnable mReleaser;
        String mTag;
        IBinder mToken;
        WorkSource mWorkSource;
        final PowerManager this$0;

        WakeLock(int i, String s) {
            this$0 = PowerManager.this;
            super();
            mReleaser = new Runnable() {

                public void run() {
                    release();
                }

                final WakeLock this$1;

                 {
                    this$1 = WakeLock.this;
                    super();
                }
            };
            mCount = 0;
            mRefCounted = true;
            mHeld = false;
            switch(i & 0x3f) {
            default:
                throw new IllegalArgumentException();

            case 1: // '\001'
            case 6: // '\006'
            case 10: // '\n'
            case 26: // '\032'
            case 32: // ' '
                mFlags = i;
                break;
            }
            mTag = s;
            mToken = new Binder();
        }
    }


    private PowerManager() {
    }

    public PowerManager(IPowerManager ipowermanager, Handler handler) {
        mService = ipowermanager;
        mHandler = handler;
    }

    public int getSupportedWakeLockFlags() {
        int j = mService.getSupportedWakeLockFlags();
        int i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        i = 0;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void goToSleep(long l) {
        mService.goToSleep(l);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean isScreenOn() {
        boolean flag1 = mService.isScreenOn();
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public WakeLock newWakeLock(int i, String s) {
        if(s == null)
            throw new NullPointerException("tag is null in PowerManager.newWakeLock");
        else
            return new WakeLock(i, s);
    }

    public void reboot(String s) {
        mService.reboot(s);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void setBacklightBrightness(int i) {
        mService.setBacklightBrightness(i);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void userActivity(long l, boolean flag) {
        mService.userActivity(l, flag);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static final int ACQUIRE_CAUSES_WAKEUP = 0x10000000;
    public static final int BRIGHTNESS_DIM = 20;
    public static final int BRIGHTNESS_LOW_BATTERY = 10;
    public static final int BRIGHTNESS_OFF = 0;
    public static final int BRIGHTNESS_ON = 255;
    public static final int FULL_WAKE_LOCK = 26;
    private static final int LOCK_MASK = 63;
    public static final int ON_AFTER_RELEASE = 0x20000000;
    public static final int PARTIAL_WAKE_LOCK = 1;
    public static final int PROXIMITY_SCREEN_OFF_WAKE_LOCK = 32;
    public static final int SCREEN_BRIGHT_WAKE_LOCK = 10;
    public static final int SCREEN_DIM_WAKE_LOCK = 6;
    private static final String TAG = "PowerManager";
    public static final int WAIT_FOR_PROXIMITY_NEGATIVE = 1;
    private static final int WAKE_BIT_CPU_STRONG = 1;
    private static final int WAKE_BIT_CPU_WEAK = 2;
    private static final int WAKE_BIT_KEYBOARD_BRIGHT = 16;
    private static final int WAKE_BIT_PROXIMITY_SCREEN_OFF = 32;
    private static final int WAKE_BIT_SCREEN_BRIGHT = 8;
    private static final int WAKE_BIT_SCREEN_DIM = 4;
    Handler mHandler;
    IPowerManager mService;
}

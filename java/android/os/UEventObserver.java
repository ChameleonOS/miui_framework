// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class UEventObserver {
    private static class UEventThread extends Thread {

        public void addObserver(String s, UEventObserver ueventobserver) {
            ArrayList arraylist = mObservers;
            arraylist;
            JVM INSTR monitorenter ;
            mObservers.add(s);
            mObservers.add(ueventobserver);
            return;
        }

        public void removeObserver(UEventObserver ueventobserver) {
            ArrayList arraylist = mObservers;
            arraylist;
            JVM INSTR monitorenter ;
            boolean flag = true;
_L2:
            int i;
            if(!flag)
                break; /* Loop/switch isn't completed */
            flag = false;
            i = 0;
_L3:
            if(i < mObservers.size()) {
                if(mObservers.get(i + 1) != ueventobserver)
                    break MISSING_BLOCK_LABEL_82;
                mObservers.remove(i + 1);
                mObservers.remove(i);
                flag = true;
            }
            if(true) goto _L2; else goto _L1
_L1:
            return;
            i += 2;
              goto _L3
        }

        public void run() {
            byte abyte0[];
            UEventObserver.native_setup();
            abyte0 = new byte[1024];
_L2:
            String s;
            int i;
            do
                i = UEventObserver.next_event(abyte0);
            while(i <= 0);
            s = new String(abyte0, 0, i);
            ArrayList arraylist = mObservers;
            arraylist;
            JVM INSTR monitorenter ;
            int j = 0;
            while(j < mObservers.size())  {
                if(s.indexOf((String)mObservers.get(j)) != -1)
                    ((UEventObserver)mObservers.get(j + 1)).onUEvent(new UEvent(s));
                j += 2;
            }
            if(true) goto _L2; else goto _L1
_L1:
        }

        private ArrayList mObservers;

        UEventThread() {
            super("UEventObserver");
            mObservers = new ArrayList();
        }
    }

    public static class UEvent {

        public String get(String s) {
            return (String)mMap.get(s);
        }

        public String get(String s, String s1) {
            String s2 = (String)mMap.get(s);
            if(s2 != null)
                s1 = s2;
            return s1;
        }

        public String toString() {
            return mMap.toString();
        }

        public HashMap mMap;

        public UEvent(String s) {
            mMap = new HashMap();
            int i = 0;
            int j = s.length();
            do {
                int k;
                int l;
label0:
                {
                    if(i < j) {
                        k = s.indexOf('=', i);
                        l = s.indexOf('\0', i);
                        if(l >= 0)
                            break label0;
                    }
                    return;
                }
                if(k > i && k < l)
                    mMap.put(s.substring(i, k), s.substring(k + 1, l));
                i = l + 1;
            } while(true);
        }
    }


    public UEventObserver() {
    }

    /**
     * @deprecated Method ensureThreadStarted is deprecated
     */

    private static final void ensureThreadStarted() {
        android/os/UEventObserver;
        JVM INSTR monitorenter ;
        if(!sThreadStarted) {
            sThread = new UEventThread();
            sThread.start();
            sThreadStarted = true;
        }
        android/os/UEventObserver;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private static native void native_setup();

    private static native int next_event(byte abyte0[]);

    protected void finalize() throws Throwable {
        stopObserving();
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public abstract void onUEvent(UEvent uevent);

    /**
     * @deprecated Method startObserving is deprecated
     */

    public final void startObserving(String s) {
        this;
        JVM INSTR monitorenter ;
        ensureThreadStarted();
        sThread.addObserver(s, this);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method stopObserving is deprecated
     */

    public final void stopObserving() {
        this;
        JVM INSTR monitorenter ;
        sThread.removeObserver(this);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private static final String TAG = android/os/UEventObserver.getSimpleName();
    private static UEventThread sThread;
    private static boolean sThreadStarted = false;



}

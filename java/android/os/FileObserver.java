// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public abstract class FileObserver {
    private static class ObserverThread extends Thread {

        private native int init();

        private native void observe(int i);

        private native int startWatching(int i, String s, int j);

        private native void stopWatching(int i, int j);

        public void onEvent(int i, int j, String s) {
            FileObserver fileobserver;
            fileobserver = null;
            synchronized(m_observers) {
                WeakReference weakreference = (WeakReference)m_observers.get(Integer.valueOf(i));
                if(weakreference != null) {
                    fileobserver = (FileObserver)weakreference.get();
                    if(fileobserver == null)
                        m_observers.remove(Integer.valueOf(i));
                }
            }
            if(fileobserver == null)
                break MISSING_BLOCK_LABEL_75;
            fileobserver.onEvent(j, s);
_L1:
            return;
            exception;
            hashmap;
            JVM INSTR monitorexit ;
            throw exception;
            Throwable throwable;
            throwable;
            Log.wtf("FileObserver", (new StringBuilder()).append("Unhandled exception in FileObserver ").append(fileobserver).toString(), throwable);
              goto _L1
        }

        public void run() {
            observe(m_fd);
        }

        public int startWatching(String s, int i, FileObserver fileobserver) {
            int j = startWatching(m_fd, s, i);
            Integer integer = new Integer(j);
            if(j >= 0)
                synchronized(m_observers) {
                    m_observers.put(integer, new WeakReference(fileobserver));
                }
            return integer.intValue();
            exception;
            hashmap;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void stopWatching(int i) {
            stopWatching(m_fd, i);
        }

        private int m_fd;
        private HashMap m_observers;

        public ObserverThread() {
            super("FileObserver");
            m_observers = new HashMap();
            m_fd = init();
        }
    }


    public FileObserver(String s) {
        this(s, 4095);
    }

    public FileObserver(String s, int i) {
        m_path = s;
        m_mask = i;
        m_descriptor = Integer.valueOf(-1);
    }

    protected void finalize() {
        stopWatching();
    }

    public abstract void onEvent(int i, String s);

    public void startWatching() {
        if(m_descriptor.intValue() < 0)
            m_descriptor = Integer.valueOf(s_observerThread.startWatching(m_path, m_mask, this));
    }

    public void stopWatching() {
        if(m_descriptor.intValue() >= 0) {
            s_observerThread.stopWatching(m_descriptor.intValue());
            m_descriptor = Integer.valueOf(-1);
        }
    }

    public static final int ACCESS = 1;
    public static final int ALL_EVENTS = 4095;
    public static final int ATTRIB = 4;
    public static final int CLOSE_NOWRITE = 16;
    public static final int CLOSE_WRITE = 8;
    public static final int CREATE = 256;
    public static final int DELETE = 512;
    public static final int DELETE_SELF = 1024;
    private static final String LOG_TAG = "FileObserver";
    public static final int MODIFY = 2;
    public static final int MOVED_FROM = 64;
    public static final int MOVED_TO = 128;
    public static final int MOVE_SELF = 2048;
    public static final int OPEN = 32;
    private static ObserverThread s_observerThread;
    private Integer m_descriptor;
    private int m_mask;
    private String m_path;

    static  {
        s_observerThread = new ObserverThread();
        s_observerThread.start();
    }
}

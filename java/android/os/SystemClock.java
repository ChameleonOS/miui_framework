// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;


public final class SystemClock {

    private SystemClock() {
    }

    public static native long currentThreadTimeMicro();

    public static native long currentThreadTimeMillis();

    public static native long currentTimeMicro();

    public static native long elapsedRealtime();

    public static native boolean setCurrentTimeMillis(long l);

    public static void sleep(long l) {
        long l1 = uptimeMillis();
        long l2 = l;
        boolean flag = false;
        do {
            try {
                Thread.sleep(l2);
            }
            catch(InterruptedException interruptedexception) {
                flag = true;
            }
            l2 = (l1 + l) - uptimeMillis();
        } while(l2 > 0L);
        if(flag)
            Thread.currentThread().interrupt();
    }

    public static native long uptimeMillis();
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;


// Referenced classes of package android.os:
//            Vibrator

public class NullVibrator extends Vibrator {

    private NullVibrator() {
    }

    public static NullVibrator getInstance() {
        return sInstance;
    }

    public void cancel() {
    }

    public boolean hasVibrator() {
        return false;
    }

    public void vibrate(long l) {
    }

    public void vibrate(long al[], int i) {
        if(i >= al.length)
            throw new ArrayIndexOutOfBoundsException();
        else
            return;
    }

    private static final NullVibrator sInstance = new NullVibrator();

}

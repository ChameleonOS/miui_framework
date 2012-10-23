// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;

import android.os.SystemClock;

public class Interpolator {
    public static final class Result extends Enum {

        public static Result valueOf(String s) {
            return (Result)Enum.valueOf(android/graphics/Interpolator$Result, s);
        }

        public static Result[] values() {
            return (Result[])$VALUES.clone();
        }

        private static final Result $VALUES[];
        public static final Result FREEZE_END;
        public static final Result FREEZE_START;
        public static final Result NORMAL;

        static  {
            NORMAL = new Result("NORMAL", 0);
            FREEZE_START = new Result("FREEZE_START", 1);
            FREEZE_END = new Result("FREEZE_END", 2);
            Result aresult[] = new Result[3];
            aresult[0] = NORMAL;
            aresult[1] = FREEZE_START;
            aresult[2] = FREEZE_END;
            $VALUES = aresult;
        }

        private Result(String s, int i) {
            super(s, i);
        }
    }


    public Interpolator(int i) {
        mValueCount = i;
        mFrameCount = 2;
        native_instance = nativeConstructor(i, 2);
    }

    public Interpolator(int i, int j) {
        mValueCount = i;
        mFrameCount = j;
        native_instance = nativeConstructor(i, j);
    }

    private static native int nativeConstructor(int i, int j);

    private static native void nativeDestructor(int i);

    private static native void nativeReset(int i, int j, int k);

    private static native void nativeSetKeyFrame(int i, int j, int k, float af[], float af1[]);

    private static native void nativeSetRepeatMirror(int i, float f, boolean flag);

    private static native int nativeTimeToValues(int i, int j, float af[]);

    protected void finalize() throws Throwable {
        nativeDestructor(native_instance);
    }

    public final int getKeyFrameCount() {
        return mFrameCount;
    }

    public final int getValueCount() {
        return mValueCount;
    }

    public void reset(int i) {
        reset(i, 2);
    }

    public void reset(int i, int j) {
        mValueCount = i;
        mFrameCount = j;
        nativeReset(native_instance, i, j);
    }

    public void setKeyFrame(int i, int j, float af[]) {
        setKeyFrame(i, j, af, null);
    }

    public void setKeyFrame(int i, int j, float af[], float af1[]) {
        if(i < 0 || i >= mFrameCount)
            throw new IndexOutOfBoundsException();
        if(af.length < mValueCount)
            throw new ArrayStoreException();
        if(af1 != null && af1.length < 4) {
            throw new ArrayStoreException();
        } else {
            nativeSetKeyFrame(native_instance, i, j, af, af1);
            return;
        }
    }

    public void setRepeatMirror(float f, boolean flag) {
        if(f >= 0.0F)
            nativeSetRepeatMirror(native_instance, f, flag);
    }

    public Result timeToValues(int i, float af[]) {
        if(af != null && af.length < mValueCount)
            throw new ArrayStoreException();
        nativeTimeToValues(native_instance, i, af);
        JVM INSTR tableswitch 0 1: default 52
    //                   0 58
    //                   1 65;
           goto _L1 _L2 _L3
_L1:
        Result result = Result.FREEZE_END;
_L5:
        return result;
_L2:
        result = Result.NORMAL;
        continue; /* Loop/switch isn't completed */
_L3:
        result = Result.FREEZE_START;
        if(true) goto _L5; else goto _L4
_L4:
    }

    public Result timeToValues(float af[]) {
        return timeToValues((int)SystemClock.uptimeMillis(), af);
    }

    private int mFrameCount;
    private int mValueCount;
    private final int native_instance;
}

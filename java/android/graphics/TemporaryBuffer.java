// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;

import com.android.internal.util.ArrayUtils;

public class TemporaryBuffer {

    public TemporaryBuffer() {
    }

    public static char[] obtain(int i) {
        android/graphics/TemporaryBuffer;
        JVM INSTR monitorenter ;
        char ac[];
        ac = sTemp;
        sTemp = null;
        android/graphics/TemporaryBuffer;
        JVM INSTR monitorexit ;
        if(ac == null || ac.length < i)
            ac = new char[ArrayUtils.idealCharArraySize(i)];
        return ac;
        Exception exception;
        exception;
        android/graphics/TemporaryBuffer;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void recycle(char ac[]) {
        if(ac.length <= 1000) goto _L2; else goto _L1
_L1:
        return;
_L2:
        android/graphics/TemporaryBuffer;
        JVM INSTR monitorenter ;
        sTemp = ac;
        if(true) goto _L1; else goto _L3
_L3:
    }

    private static char sTemp[] = null;

}

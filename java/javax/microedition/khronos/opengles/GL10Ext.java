// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package javax.microedition.khronos.opengles;

import java.nio.IntBuffer;

// Referenced classes of package javax.microedition.khronos.opengles:
//            GL

public interface GL10Ext
    extends GL {

    public abstract int glQueryMatrixxOES(IntBuffer intbuffer, IntBuffer intbuffer1);

    public abstract int glQueryMatrixxOES(int ai[], int i, int ai1[], int j);
}

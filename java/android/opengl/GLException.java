// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.opengl;


// Referenced classes of package android.opengl:
//            GLU

public class GLException extends RuntimeException {

    public GLException(int i) {
        super(getErrorString(i));
        mError = i;
    }

    public GLException(int i, String s) {
        super(s);
        mError = i;
    }

    private static String getErrorString(int i) {
        String s = GLU.gluErrorString(i);
        if(s == null)
            s = (new StringBuilder()).append("Unknown error 0x").append(Integer.toHexString(i)).toString();
        return s;
    }

    int getError() {
        return mError;
    }

    private final int mError;
}

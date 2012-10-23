// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;

import java.io.*;

// Referenced classes of package android.graphics:
//            Canvas, Paint

public class Movie {

    private Movie(int i) {
        if(i == 0) {
            throw new RuntimeException("native movie creation failed");
        } else {
            mNativeMovie = i;
            return;
        }
    }

    public static native Movie decodeByteArray(byte abyte0[], int i, int j);

    public static Movie decodeFile(String s) {
        FileInputStream fileinputstream = new FileInputStream(s);
        Movie movie = decodeTempStream(fileinputstream);
_L2:
        return movie;
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        movie = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static native Movie decodeStream(InputStream inputstream);

    private static Movie decodeTempStream(InputStream inputstream) {
        Movie movie = null;
        try {
            movie = decodeStream(inputstream);
            inputstream.close();
        }
        catch(IOException ioexception) { }
        return movie;
    }

    private static native void nativeDestructor(int i);

    public void draw(Canvas canvas, float f, float f1) {
        draw(canvas, f, f1, null);
    }

    public native void draw(Canvas canvas, float f, float f1, Paint paint);

    public native int duration();

    protected void finalize() throws Throwable {
        nativeDestructor(mNativeMovie);
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public native int height();

    public native boolean isOpaque();

    public native boolean setTime(int i);

    public native int width();

    private final int mNativeMovie;
}

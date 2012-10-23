// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.opengl;

import android.graphics.Bitmap;

public final class GLUtils {

    private GLUtils() {
    }

    public static void enableTracing() {
        native_enableTracing();
    }

    public static String getEGLErrorString(int i) {
        i;
        JVM INSTR tableswitch 12288 12302: default 76
    //                   12288 101
    //                   12289 107
    //                   12290 113
    //                   12291 119
    //                   12292 125
    //                   12293 131
    //                   12294 137
    //                   12295 143
    //                   12296 149
    //                   12297 155
    //                   12298 161
    //                   12299 167
    //                   12300 173
    //                   12301 179
    //                   12302 185;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16
_L1:
        String s = (new StringBuilder()).append("0x").append(Integer.toHexString(i)).toString();
_L18:
        return s;
_L2:
        s = "EGL_SUCCESS";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "EGL_NOT_INITIALIZED";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "EGL_BAD_ACCESS";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "EGL_BAD_ALLOC";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "EGL_BAD_ATTRIBUTE";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "EGL_BAD_CONFIG";
        continue; /* Loop/switch isn't completed */
_L8:
        s = "EGL_BAD_CONTEXT";
        continue; /* Loop/switch isn't completed */
_L9:
        s = "EGL_BAD_CURRENT_SURFACE";
        continue; /* Loop/switch isn't completed */
_L10:
        s = "EGL_BAD_DISPLAY";
        continue; /* Loop/switch isn't completed */
_L11:
        s = "EGL_BAD_MATCH";
        continue; /* Loop/switch isn't completed */
_L12:
        s = "EGL_BAD_NATIVE_PIXMAP";
        continue; /* Loop/switch isn't completed */
_L13:
        s = "EGL_BAD_NATIVE_WINDOW";
        continue; /* Loop/switch isn't completed */
_L14:
        s = "EGL_BAD_PARAMETER";
        continue; /* Loop/switch isn't completed */
_L15:
        s = "EGL_BAD_SURFACE";
        continue; /* Loop/switch isn't completed */
_L16:
        s = "EGL_CONTEXT_LOST";
        if(true) goto _L18; else goto _L17
_L17:
    }

    public static int getInternalFormat(Bitmap bitmap) {
        if(bitmap == null)
            throw new NullPointerException("getInternalFormat can't be used with a null Bitmap");
        if(bitmap.isRecycled())
            throw new IllegalArgumentException("bitmap is recycled");
        int i = native_getInternalFormat(bitmap);
        if(i < 0)
            throw new IllegalArgumentException("Unknown internalformat");
        else
            return i;
    }

    public static int getType(Bitmap bitmap) {
        if(bitmap == null)
            throw new NullPointerException("getType can't be used with a null Bitmap");
        if(bitmap.isRecycled())
            throw new IllegalArgumentException("bitmap is recycled");
        int i = native_getType(bitmap);
        if(i < 0)
            throw new IllegalArgumentException("Unknown type");
        else
            return i;
    }

    private static native void nativeClassInit();

    private static native void native_enableTracing();

    private static native int native_getInternalFormat(Bitmap bitmap);

    private static native int native_getType(Bitmap bitmap);

    private static native int native_texImage2D(int i, int j, int k, Bitmap bitmap, int l, int i1);

    private static native int native_texSubImage2D(int i, int j, int k, int l, Bitmap bitmap, int i1, int j1);

    public static void texImage2D(int i, int j, int k, Bitmap bitmap, int l) {
        if(bitmap == null)
            throw new NullPointerException("texImage2D can't be used with a null Bitmap");
        if(bitmap.isRecycled())
            throw new IllegalArgumentException("bitmap is recycled");
        if(native_texImage2D(i, j, k, bitmap, -1, l) != 0)
            throw new IllegalArgumentException("invalid Bitmap format");
        else
            return;
    }

    public static void texImage2D(int i, int j, int k, Bitmap bitmap, int l, int i1) {
        if(bitmap == null)
            throw new NullPointerException("texImage2D can't be used with a null Bitmap");
        if(bitmap.isRecycled())
            throw new IllegalArgumentException("bitmap is recycled");
        if(native_texImage2D(i, j, k, bitmap, l, i1) != 0)
            throw new IllegalArgumentException("invalid Bitmap format");
        else
            return;
    }

    public static void texImage2D(int i, int j, Bitmap bitmap, int k) {
        if(bitmap == null)
            throw new NullPointerException("texImage2D can't be used with a null Bitmap");
        if(bitmap.isRecycled())
            throw new IllegalArgumentException("bitmap is recycled");
        if(native_texImage2D(i, j, -1, bitmap, -1, k) != 0)
            throw new IllegalArgumentException("invalid Bitmap format");
        else
            return;
    }

    public static void texSubImage2D(int i, int j, int k, int l, Bitmap bitmap) {
        if(bitmap == null)
            throw new NullPointerException("texSubImage2D can't be used with a null Bitmap");
        if(bitmap.isRecycled())
            throw new IllegalArgumentException("bitmap is recycled");
        if(native_texSubImage2D(i, j, k, l, bitmap, -1, getType(bitmap)) != 0)
            throw new IllegalArgumentException("invalid Bitmap format");
        else
            return;
    }

    public static void texSubImage2D(int i, int j, int k, int l, Bitmap bitmap, int i1, int j1) {
        if(bitmap == null)
            throw new NullPointerException("texSubImage2D can't be used with a null Bitmap");
        if(bitmap.isRecycled())
            throw new IllegalArgumentException("bitmap is recycled");
        if(native_texSubImage2D(i, j, k, l, bitmap, i1, j1) != 0)
            throw new IllegalArgumentException("invalid Bitmap format");
        else
            return;
    }

    static  {
        nativeClassInit();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package javax.microedition.khronos.opengles;

import java.nio.*;

// Referenced classes of package javax.microedition.khronos.opengles:
//            GL

public interface GL11Ext
    extends GL {

    public abstract void glCurrentPaletteMatrixOES(int i);

    public abstract void glDrawTexfOES(float f, float f1, float f2, float f3, float f4);

    public abstract void glDrawTexfvOES(FloatBuffer floatbuffer);

    public abstract void glDrawTexfvOES(float af[], int i);

    public abstract void glDrawTexiOES(int i, int j, int k, int l, int i1);

    public abstract void glDrawTexivOES(IntBuffer intbuffer);

    public abstract void glDrawTexivOES(int ai[], int i);

    public abstract void glDrawTexsOES(short word0, short word1, short word2, short word3, short word4);

    public abstract void glDrawTexsvOES(ShortBuffer shortbuffer);

    public abstract void glDrawTexsvOES(short aword0[], int i);

    public abstract void glDrawTexxOES(int i, int j, int k, int l, int i1);

    public abstract void glDrawTexxvOES(IntBuffer intbuffer);

    public abstract void glDrawTexxvOES(int ai[], int i);

    public abstract void glEnable(int i);

    public abstract void glEnableClientState(int i);

    public abstract void glLoadPaletteFromModelViewMatrixOES();

    public abstract void glMatrixIndexPointerOES(int i, int j, int k, int l);

    public abstract void glMatrixIndexPointerOES(int i, int j, int k, Buffer buffer);

    public abstract void glTexParameterfv(int i, int j, float af[], int k);

    public abstract void glWeightPointerOES(int i, int j, int k, int l);

    public abstract void glWeightPointerOES(int i, int j, int k, Buffer buffer);

    public static final int GL_MATRIX_INDEX_ARRAY_BUFFER_BINDING_OES = 35742;
    public static final int GL_MATRIX_INDEX_ARRAY_OES = 34884;
    public static final int GL_MATRIX_INDEX_ARRAY_POINTER_OES = 34889;
    public static final int GL_MATRIX_INDEX_ARRAY_SIZE_OES = 34886;
    public static final int GL_MATRIX_INDEX_ARRAY_STRIDE_OES = 34888;
    public static final int GL_MATRIX_INDEX_ARRAY_TYPE_OES = 34887;
    public static final int GL_MATRIX_PALETTE_OES = 34880;
    public static final int GL_MAX_PALETTE_MATRICES_OES = 34882;
    public static final int GL_MAX_VERTEX_UNITS_OES = 34468;
    public static final int GL_TEXTURE_CROP_RECT_OES = 35741;
    public static final int GL_WEIGHT_ARRAY_BUFFER_BINDING_OES = 34974;
    public static final int GL_WEIGHT_ARRAY_OES = 34477;
    public static final int GL_WEIGHT_ARRAY_POINTER_OES = 34476;
    public static final int GL_WEIGHT_ARRAY_SIZE_OES = 34475;
    public static final int GL_WEIGHT_ARRAY_STRIDE_OES = 34474;
    public static final int GL_WEIGHT_ARRAY_TYPE_OES = 34473;
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.opengl;

import java.nio.*;

public class GLES11Ext {

    public GLES11Ext() {
    }

    private static native void _nativeClassInit();

    public static native void glAlphaFuncxOES(int i, int j);

    public static native void glBindFramebufferOES(int i, int j);

    public static native void glBindRenderbufferOES(int i, int j);

    public static native void glBlendEquationOES(int i);

    public static native void glBlendEquationSeparateOES(int i, int j);

    public static native void glBlendFuncSeparateOES(int i, int j, int k, int l);

    public static native int glCheckFramebufferStatusOES(int i);

    public static native void glClearColorxOES(int i, int j, int k, int l);

    public static native void glClearDepthfOES(float f);

    public static native void glClearDepthxOES(int i);

    public static native void glClipPlanefOES(int i, FloatBuffer floatbuffer);

    public static native void glClipPlanefOES(int i, float af[], int j);

    public static native void glClipPlanexOES(int i, IntBuffer intbuffer);

    public static native void glClipPlanexOES(int i, int ai[], int j);

    public static native void glColor4xOES(int i, int j, int k, int l);

    public static native void glCurrentPaletteMatrixOES(int i);

    public static native void glDeleteFramebuffersOES(int i, IntBuffer intbuffer);

    public static native void glDeleteFramebuffersOES(int i, int ai[], int j);

    public static native void glDeleteRenderbuffersOES(int i, IntBuffer intbuffer);

    public static native void glDeleteRenderbuffersOES(int i, int ai[], int j);

    public static native void glDepthRangefOES(float f, float f1);

    public static native void glDepthRangexOES(int i, int j);

    public static native void glDrawTexfOES(float f, float f1, float f2, float f3, float f4);

    public static native void glDrawTexfvOES(FloatBuffer floatbuffer);

    public static native void glDrawTexfvOES(float af[], int i);

    public static native void glDrawTexiOES(int i, int j, int k, int l, int i1);

    public static native void glDrawTexivOES(IntBuffer intbuffer);

    public static native void glDrawTexivOES(int ai[], int i);

    public static native void glDrawTexsOES(short word0, short word1, short word2, short word3, short word4);

    public static native void glDrawTexsvOES(ShortBuffer shortbuffer);

    public static native void glDrawTexsvOES(short aword0[], int i);

    public static native void glDrawTexxOES(int i, int j, int k, int l, int i1);

    public static native void glDrawTexxvOES(IntBuffer intbuffer);

    public static native void glDrawTexxvOES(int ai[], int i);

    public static native void glEGLImageTargetRenderbufferStorageOES(int i, Buffer buffer);

    public static native void glEGLImageTargetTexture2DOES(int i, Buffer buffer);

    public static native void glFogxOES(int i, int j);

    public static native void glFogxvOES(int i, IntBuffer intbuffer);

    public static native void glFogxvOES(int i, int ai[], int j);

    public static native void glFramebufferRenderbufferOES(int i, int j, int k, int l);

    public static native void glFramebufferTexture2DOES(int i, int j, int k, int l, int i1);

    public static native void glFrustumfOES(float f, float f1, float f2, float f3, float f4, float f5);

    public static native void glFrustumxOES(int i, int j, int k, int l, int i1, int j1);

    public static native void glGenFramebuffersOES(int i, IntBuffer intbuffer);

    public static native void glGenFramebuffersOES(int i, int ai[], int j);

    public static native void glGenRenderbuffersOES(int i, IntBuffer intbuffer);

    public static native void glGenRenderbuffersOES(int i, int ai[], int j);

    public static native void glGenerateMipmapOES(int i);

    public static native void glGetClipPlanefOES(int i, FloatBuffer floatbuffer);

    public static native void glGetClipPlanefOES(int i, float af[], int j);

    public static native void glGetClipPlanexOES(int i, IntBuffer intbuffer);

    public static native void glGetClipPlanexOES(int i, int ai[], int j);

    public static native void glGetFixedvOES(int i, IntBuffer intbuffer);

    public static native void glGetFixedvOES(int i, int ai[], int j);

    public static native void glGetFramebufferAttachmentParameterivOES(int i, int j, int k, IntBuffer intbuffer);

    public static native void glGetFramebufferAttachmentParameterivOES(int i, int j, int k, int ai[], int l);

    public static native void glGetLightxvOES(int i, int j, IntBuffer intbuffer);

    public static native void glGetLightxvOES(int i, int j, int ai[], int k);

    public static native void glGetMaterialxvOES(int i, int j, IntBuffer intbuffer);

    public static native void glGetMaterialxvOES(int i, int j, int ai[], int k);

    public static native void glGetRenderbufferParameterivOES(int i, int j, IntBuffer intbuffer);

    public static native void glGetRenderbufferParameterivOES(int i, int j, int ai[], int k);

    public static native void glGetTexEnvxvOES(int i, int j, IntBuffer intbuffer);

    public static native void glGetTexEnvxvOES(int i, int j, int ai[], int k);

    public static native void glGetTexGenfvOES(int i, int j, FloatBuffer floatbuffer);

    public static native void glGetTexGenfvOES(int i, int j, float af[], int k);

    public static native void glGetTexGenivOES(int i, int j, IntBuffer intbuffer);

    public static native void glGetTexGenivOES(int i, int j, int ai[], int k);

    public static native void glGetTexGenxvOES(int i, int j, IntBuffer intbuffer);

    public static native void glGetTexGenxvOES(int i, int j, int ai[], int k);

    public static native void glGetTexParameterxvOES(int i, int j, IntBuffer intbuffer);

    public static native void glGetTexParameterxvOES(int i, int j, int ai[], int k);

    public static native boolean glIsFramebufferOES(int i);

    public static native boolean glIsRenderbufferOES(int i);

    public static native void glLightModelxOES(int i, int j);

    public static native void glLightModelxvOES(int i, IntBuffer intbuffer);

    public static native void glLightModelxvOES(int i, int ai[], int j);

    public static native void glLightxOES(int i, int j, int k);

    public static native void glLightxvOES(int i, int j, IntBuffer intbuffer);

    public static native void glLightxvOES(int i, int j, int ai[], int k);

    public static native void glLineWidthxOES(int i);

    public static native void glLoadMatrixxOES(IntBuffer intbuffer);

    public static native void glLoadMatrixxOES(int ai[], int i);

    public static native void glLoadPaletteFromModelViewMatrixOES();

    public static native void glMaterialxOES(int i, int j, int k);

    public static native void glMaterialxvOES(int i, int j, IntBuffer intbuffer);

    public static native void glMaterialxvOES(int i, int j, int ai[], int k);

    public static void glMatrixIndexPointerOES(int i, int j, int k, Buffer buffer) {
        glMatrixIndexPointerOESBounds(i, j, k, buffer, buffer.remaining());
        if((i == 2 || i == 3 || i == 4) && (j == 5126 || j == 5120 || j == 5122 || j == 5132) && k >= 0)
            _matrixIndexPointerOES = buffer;
    }

    private static native void glMatrixIndexPointerOESBounds(int i, int j, int k, Buffer buffer, int l);

    public static native void glMultMatrixxOES(IntBuffer intbuffer);

    public static native void glMultMatrixxOES(int ai[], int i);

    public static native void glMultiTexCoord4xOES(int i, int j, int k, int l, int i1);

    public static native void glNormal3xOES(int i, int j, int k);

    public static native void glOrthofOES(float f, float f1, float f2, float f3, float f4, float f5);

    public static native void glOrthoxOES(int i, int j, int k, int l, int i1, int j1);

    public static native void glPointParameterxOES(int i, int j);

    public static native void glPointParameterxvOES(int i, IntBuffer intbuffer);

    public static native void glPointParameterxvOES(int i, int ai[], int j);

    public static native void glPointSizexOES(int i);

    public static native void glPolygonOffsetxOES(int i, int j);

    public static native void glRenderbufferStorageOES(int i, int j, int k, int l);

    public static native void glRotatexOES(int i, int j, int k, int l);

    public static native void glSampleCoveragexOES(int i, boolean flag);

    public static native void glScalexOES(int i, int j, int k);

    public static native void glTexEnvxOES(int i, int j, int k);

    public static native void glTexEnvxvOES(int i, int j, IntBuffer intbuffer);

    public static native void glTexEnvxvOES(int i, int j, int ai[], int k);

    public static native void glTexGenfOES(int i, int j, float f);

    public static native void glTexGenfvOES(int i, int j, FloatBuffer floatbuffer);

    public static native void glTexGenfvOES(int i, int j, float af[], int k);

    public static native void glTexGeniOES(int i, int j, int k);

    public static native void glTexGenivOES(int i, int j, IntBuffer intbuffer);

    public static native void glTexGenivOES(int i, int j, int ai[], int k);

    public static native void glTexGenxOES(int i, int j, int k);

    public static native void glTexGenxvOES(int i, int j, IntBuffer intbuffer);

    public static native void glTexGenxvOES(int i, int j, int ai[], int k);

    public static native void glTexParameterxOES(int i, int j, int k);

    public static native void glTexParameterxvOES(int i, int j, IntBuffer intbuffer);

    public static native void glTexParameterxvOES(int i, int j, int ai[], int k);

    public static native void glTranslatexOES(int i, int j, int k);

    public static void glWeightPointerOES(int i, int j, int k, Buffer buffer) {
        glWeightPointerOESBounds(i, j, k, buffer, buffer.remaining());
    }

    private static native void glWeightPointerOESBounds(int i, int j, int k, Buffer buffer, int l);

    public static final int GL_3DC_XY_AMD = 34810;
    public static final int GL_3DC_X_AMD = 34809;
    public static final int GL_ATC_RGBA_EXPLICIT_ALPHA_AMD = 35987;
    public static final int GL_ATC_RGBA_INTERPOLATED_ALPHA_AMD = 34798;
    public static final int GL_ATC_RGB_AMD = 35986;
    public static final int GL_BGRA = 32993;
    public static final int GL_BLEND_DST_ALPHA_OES = 32970;
    public static final int GL_BLEND_DST_RGB_OES = 32968;
    public static final int GL_BLEND_EQUATION_ALPHA_OES = 34877;
    public static final int GL_BLEND_EQUATION_OES = 32777;
    public static final int GL_BLEND_EQUATION_RGB_OES = 32777;
    public static final int GL_BLEND_SRC_ALPHA_OES = 32971;
    public static final int GL_BLEND_SRC_RGB_OES = 32969;
    public static final int GL_BUFFER_ACCESS_OES = 35003;
    public static final int GL_BUFFER_MAPPED_OES = 35004;
    public static final int GL_BUFFER_MAP_POINTER_OES = 35005;
    private static final int GL_BYTE = 5120;
    public static final int GL_COLOR_ATTACHMENT0_OES = 36064;
    public static final int GL_CURRENT_PALETTE_MATRIX_OES = 34883;
    public static final int GL_DECR_WRAP_OES = 34056;
    public static final int GL_DEPTH24_STENCIL8_OES = 35056;
    public static final int GL_DEPTH_ATTACHMENT_OES = 36096;
    public static final int GL_DEPTH_COMPONENT16_OES = 33189;
    public static final int GL_DEPTH_COMPONENT24_OES = 33190;
    public static final int GL_DEPTH_COMPONENT32_OES = 33191;
    public static final int GL_DEPTH_STENCIL_OES = 34041;
    public static final int GL_ETC1_RGB8_OES = 36196;
    private static final int GL_FIXED = 5132;
    public static final int GL_FIXED_OES = 5132;
    private static final int GL_FLOAT = 5126;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME_OES = 36049;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE_OES = 36048;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE_OES = 36051;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL_OES = 36050;
    public static final int GL_FRAMEBUFFER_BINDING_OES = 36006;
    public static final int GL_FRAMEBUFFER_COMPLETE_OES = 36053;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT_OES = 36054;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS_OES = 36057;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_FORMATS_OES = 36058;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT_OES = 36055;
    public static final int GL_FRAMEBUFFER_OES = 36160;
    public static final int GL_FRAMEBUFFER_UNSUPPORTED_OES = 36061;
    public static final int GL_FUNC_ADD_OES = 32774;
    public static final int GL_FUNC_REVERSE_SUBTRACT_OES = 32779;
    public static final int GL_FUNC_SUBTRACT_OES = 32778;
    public static final int GL_INCR_WRAP_OES = 34055;
    public static final int GL_INVALID_FRAMEBUFFER_OPERATION_OES = 1286;
    public static final int GL_MATRIX_INDEX_ARRAY_BUFFER_BINDING_OES = 35742;
    public static final int GL_MATRIX_INDEX_ARRAY_OES = 34884;
    public static final int GL_MATRIX_INDEX_ARRAY_POINTER_OES = 34889;
    public static final int GL_MATRIX_INDEX_ARRAY_SIZE_OES = 34886;
    public static final int GL_MATRIX_INDEX_ARRAY_STRIDE_OES = 34888;
    public static final int GL_MATRIX_INDEX_ARRAY_TYPE_OES = 34887;
    public static final int GL_MATRIX_PALETTE_OES = 34880;
    public static final int GL_MAX_CUBE_MAP_TEXTURE_SIZE_OES = 34076;
    public static final int GL_MAX_PALETTE_MATRICES_OES = 34882;
    public static final int GL_MAX_RENDERBUFFER_SIZE_OES = 34024;
    public static final int GL_MAX_TEXTURE_MAX_ANISOTROPY_EXT = 34047;
    public static final int GL_MAX_VERTEX_UNITS_OES = 34468;
    public static final int GL_MIRRORED_REPEAT_OES = 33648;
    public static final int GL_MODELVIEW_MATRIX_FLOAT_AS_INT_BITS_OES = 35213;
    public static final int GL_NONE_OES = 0;
    public static final int GL_NORMAL_MAP_OES = 34065;
    public static final int GL_PROJECTION_MATRIX_FLOAT_AS_INT_BITS_OES = 35214;
    public static final int GL_REFLECTION_MAP_OES = 34066;
    public static final int GL_RENDERBUFFER_ALPHA_SIZE_OES = 36179;
    public static final int GL_RENDERBUFFER_BINDING_OES = 36007;
    public static final int GL_RENDERBUFFER_BLUE_SIZE_OES = 36178;
    public static final int GL_RENDERBUFFER_DEPTH_SIZE_OES = 36180;
    public static final int GL_RENDERBUFFER_GREEN_SIZE_OES = 36177;
    public static final int GL_RENDERBUFFER_HEIGHT_OES = 36163;
    public static final int GL_RENDERBUFFER_INTERNAL_FORMAT_OES = 36164;
    public static final int GL_RENDERBUFFER_OES = 36161;
    public static final int GL_RENDERBUFFER_RED_SIZE_OES = 36176;
    public static final int GL_RENDERBUFFER_STENCIL_SIZE_OES = 36181;
    public static final int GL_RENDERBUFFER_WIDTH_OES = 36162;
    public static final int GL_REQUIRED_TEXTURE_IMAGE_UNITS_OES = 36200;
    public static final int GL_RGB565_OES = 36194;
    public static final int GL_RGB5_A1_OES = 32855;
    public static final int GL_RGB8_OES = 32849;
    public static final int GL_RGBA4_OES = 32854;
    public static final int GL_RGBA8_OES = 32856;
    public static final int GL_SAMPLER_EXTERNAL_OES = 36198;
    private static final int GL_SHORT = 5122;
    public static final int GL_STENCIL_ATTACHMENT_OES = 36128;
    public static final int GL_STENCIL_INDEX1_OES = 36166;
    public static final int GL_STENCIL_INDEX4_OES = 36167;
    public static final int GL_STENCIL_INDEX8_OES = 36168;
    public static final int GL_TEXTURE_BINDING_CUBE_MAP_OES = 34068;
    public static final int GL_TEXTURE_BINDING_EXTERNAL_OES = 36199;
    public static final int GL_TEXTURE_CROP_RECT_OES = 35741;
    public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_X_OES = 34070;
    public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Y_OES = 34072;
    public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Z_OES = 34074;
    public static final int GL_TEXTURE_CUBE_MAP_OES = 34067;
    public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_X_OES = 34069;
    public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Y_OES = 34071;
    public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Z_OES = 34073;
    public static final int GL_TEXTURE_EXTERNAL_OES = 36197;
    public static final int GL_TEXTURE_GEN_MODE_OES = 9472;
    public static final int GL_TEXTURE_GEN_STR_OES = 36192;
    public static final int GL_TEXTURE_MATRIX_FLOAT_AS_INT_BITS_OES = 35215;
    public static final int GL_TEXTURE_MAX_ANISOTROPY_EXT = 34046;
    public static final int GL_UNSIGNED_INT_24_8_OES = 34042;
    public static final int GL_WEIGHT_ARRAY_BUFFER_BINDING_OES = 34974;
    public static final int GL_WEIGHT_ARRAY_OES = 34477;
    public static final int GL_WEIGHT_ARRAY_POINTER_OES = 34476;
    public static final int GL_WEIGHT_ARRAY_SIZE_OES = 34475;
    public static final int GL_WEIGHT_ARRAY_STRIDE_OES = 34474;
    public static final int GL_WEIGHT_ARRAY_TYPE_OES = 34473;
    public static final int GL_WRITE_ONLY_OES = 35001;
    private static Buffer _matrixIndexPointerOES;

    static  {
        _nativeClassInit();
    }
}

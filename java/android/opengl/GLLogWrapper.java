// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.opengl;

import java.io.IOException;
import java.io.Writer;
import java.nio.*;
import java.util.Arrays;
import javax.microedition.khronos.opengles.*;

// Referenced classes of package android.opengl:
//            GLWrapperBase

class GLLogWrapper extends GLWrapperBase {
    private class PointerInfo {

        public void bindByteBuffer() {
            ByteBuffer bytebuffer;
            if(mPointer == null)
                bytebuffer = null;
            else
                bytebuffer = toByteBuffer(-1, mPointer);
            mTempByteBuffer = bytebuffer;
        }

        public int getStride() {
            int i;
            if(mStride > 0)
                i = mStride;
            else
                i = sizeof(mType) * mSize;
            return i;
        }

        public int sizeof(int i) {
            int j = 1;
            i;
            JVM INSTR lookupswitch 5: default 52
        //                       5120: 54
        //                       5121: 54
        //                       5122: 56
        //                       5126: 66
        //                       5132: 61;
               goto _L1 _L2 _L2 _L3 _L4 _L5
_L2:
            break; /* Loop/switch isn't completed */
_L1:
            j = 0;
_L7:
            return j;
_L3:
            j = 2;
            continue; /* Loop/switch isn't completed */
_L5:
            j = 4;
            continue; /* Loop/switch isn't completed */
_L4:
            j = 4;
            if(true) goto _L7; else goto _L6
_L6:
        }

        public void unbindByteBuffer() {
            mTempByteBuffer = null;
        }

        public Buffer mPointer;
        public int mSize;
        public int mStride;
        public ByteBuffer mTempByteBuffer;
        public int mType;
        final GLLogWrapper this$0;

        public PointerInfo() {
            this$0 = GLLogWrapper.this;
            super();
        }

        public PointerInfo(int i, int j, int k, Buffer buffer) {
            this$0 = GLLogWrapper.this;
            super();
            mSize = i;
            mType = j;
            mStride = k;
            mPointer = buffer;
        }
    }


    public GLLogWrapper(GL gl, Writer writer, boolean flag) {
        super(gl);
        mColorPointer = new PointerInfo();
        mNormalPointer = new PointerInfo();
        mTexCoordPointer = new PointerInfo();
        mVertexPointer = new PointerInfo();
        mLog = writer;
        mLogArgumentNames = flag;
    }

    private void arg(String s, float f) {
        arg(s, Float.toString(f));
    }

    private void arg(String s, int i) {
        arg(s, Integer.toString(i));
    }

    private void arg(String s, int i, FloatBuffer floatbuffer) {
        arg(s, toString(i, floatbuffer));
    }

    private void arg(String s, int i, IntBuffer intbuffer) {
        arg(s, toString(i, 0, intbuffer));
    }

    private void arg(String s, int i, ShortBuffer shortbuffer) {
        arg(s, toString(i, shortbuffer));
    }

    private void arg(String s, int i, float af[], int j) {
        arg(s, toString(i, af, j));
    }

    private void arg(String s, int i, int ai[], int j) {
        arg(s, toString(i, 0, ai, j));
    }

    private void arg(String s, int i, short aword0[], int j) {
        arg(s, toString(i, aword0, j));
    }

    private void arg(String s, String s1) {
        int i = mArgCount;
        mArgCount = i + 1;
        if(i > 0)
            log(", ");
        if(mLogArgumentNames)
            log((new StringBuilder()).append(s).append("=").toString());
        log(s1);
    }

    private void arg(String s, boolean flag) {
        arg(s, Boolean.toString(flag));
    }

    private void argPointer(int i, int j, int k, Buffer buffer) {
        arg("size", i);
        arg("type", getPointerTypeName(j));
        arg("stride", k);
        arg("pointer", buffer.toString());
    }

    private void begin(String s) {
        log((new StringBuilder()).append(s).append('(').toString());
        mArgCount = 0;
    }

    private void bindArrays() {
        if(mColorArrayEnabled)
            mColorPointer.bindByteBuffer();
        if(mNormalArrayEnabled)
            mNormalPointer.bindByteBuffer();
        if(mTextureCoordArrayEnabled)
            mTexCoordPointer.bindByteBuffer();
        if(mVertexArrayEnabled)
            mVertexPointer.bindByteBuffer();
    }

    private void checkError() {
        int i = super.mgl.glGetError();
        if(i != 0)
            logLine((new StringBuilder()).append("glError: ").append(Integer.toString(i)).toString());
    }

    private void doArrayElement(StringBuilder stringbuilder, boolean flag, String s, PointerInfo pointerinfo, int i) {
        if(flag) goto _L2; else goto _L1
_L1:
        return;
_L2:
        ByteBuffer bytebuffer;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        stringbuilder.append(" ");
        stringbuilder.append((new StringBuilder()).append(s).append(":{").toString());
        if(pointerinfo == null || pointerinfo.mTempByteBuffer == null) {
            stringbuilder.append("undefined }");
            continue; /* Loop/switch isn't completed */
        }
        if(pointerinfo.mStride < 0) {
            stringbuilder.append("invalid stride");
            continue; /* Loop/switch isn't completed */
        }
        int j = pointerinfo.getStride();
        bytebuffer = pointerinfo.mTempByteBuffer;
        k = pointerinfo.mSize;
        l = pointerinfo.mType;
        i1 = pointerinfo.sizeof(l);
        j1 = j * i;
        k1 = 0;
_L10:
        if(k1 >= k)
            break MISSING_BLOCK_LABEL_325;
        if(k1 > 0)
            stringbuilder.append(", ");
        l;
        JVM INSTR lookupswitch 5: default 196
    //                   5120: 216
    //                   5121: 234
    //                   5122: 256
    //                   5126: 302
    //                   5132: 279;
           goto _L3 _L4 _L5 _L6 _L7 _L8
_L7:
        break MISSING_BLOCK_LABEL_302;
_L4:
        break; /* Loop/switch isn't completed */
_L3:
        stringbuilder.append("?");
_L11:
        j1 += i1;
        k1++;
        if(true) goto _L10; else goto _L9
_L9:
        stringbuilder.append(Integer.toString(bytebuffer.get(j1)));
          goto _L11
_L5:
        stringbuilder.append(Integer.toString(0xff & bytebuffer.get(j1)));
          goto _L11
_L6:
        stringbuilder.append(Integer.toString(bytebuffer.asShortBuffer().get(j1 / 2)));
          goto _L11
_L8:
        stringbuilder.append(Integer.toString(bytebuffer.asIntBuffer().get(j1 / 4)));
          goto _L11
        stringbuilder.append(Float.toString(bytebuffer.asFloatBuffer().get(j1 / 4)));
          goto _L11
        stringbuilder.append("}");
        if(true) goto _L1; else goto _L12
_L12:
    }

    private void doElement(StringBuilder stringbuilder, int i, int j) {
        stringbuilder.append((new StringBuilder()).append(" [").append(i).append(" : ").append(j).append("] =").toString());
        doArrayElement(stringbuilder, mVertexArrayEnabled, "v", mVertexPointer, j);
        doArrayElement(stringbuilder, mNormalArrayEnabled, "n", mNormalPointer, j);
        doArrayElement(stringbuilder, mColorArrayEnabled, "c", mColorPointer, j);
        doArrayElement(stringbuilder, mTextureCoordArrayEnabled, "t", mTexCoordPointer, j);
        stringbuilder.append("\n");
    }

    private void end() {
        log(");\n");
        flush();
    }

    private void endLogIndices() {
        log(mStringBuilder.toString());
        unbindArrays();
    }

    private void flush() {
        mLog.flush();
_L1:
        return;
        IOException ioexception;
        ioexception;
        mLog = null;
          goto _L1
    }

    private void formattedAppend(StringBuilder stringbuilder, int i, int j) {
        j;
        JVM INSTR tableswitch 0 2: default 28
    //                   0 29
    //                   1 38
    //                   2 50;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        stringbuilder.append(i);
        continue; /* Loop/switch isn't completed */
_L3:
        stringbuilder.append(Float.intBitsToFloat(i));
        continue; /* Loop/switch isn't completed */
_L4:
        stringbuilder.append((float)i / 65536F);
        if(true) goto _L1; else goto _L5
_L5:
    }

    private String getBeginMode(int i) {
        i;
        JVM INSTR tableswitch 0 6: default 44
    //                   0 51
    //                   1 58
    //                   2 65
    //                   3 72
    //                   4 79
    //                   5 86
    //                   6 93;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        String s = getHex(i);
_L10:
        return s;
_L2:
        s = "GL_POINTS";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "GL_LINES";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "GL_LINE_LOOP";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "GL_LINE_STRIP";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "GL_TRIANGLES";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "GL_TRIANGLE_STRIP";
        continue; /* Loop/switch isn't completed */
_L8:
        s = "GL_TRIANGLE_FAN";
        if(true) goto _L10; else goto _L9
_L9:
    }

    private String getCap(int i) {
        i;
        JVM INSTR lookupswitch 32: default 268
    //                   2832: 401
    //                   2848: 408
    //                   2884: 296
    //                   2896: 282
    //                   2903: 415
    //                   2912: 275
    //                   2929: 338
    //                   2960: 331
    //                   2977: 422
    //                   3008: 303
    //                   3024: 324
    //                   3042: 310
    //                   3058: 317
    //                   3089: 492
    //                   3553: 289
    //                   16384: 345
    //                   16385: 352
    //                   16386: 359
    //                   16387: 366
    //                   16388: 373
    //                   16389: 380
    //                   16390: 387
    //                   16391: 394
    //                   32826: 429
    //                   32884: 436
    //                   32885: 443
    //                   32886: 450
    //                   32888: 457
    //                   32925: 464
    //                   32926: 471
    //                   32927: 478
    //                   32928: 485;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33
_L1:
        String s = getHex(i);
_L35:
        return s;
_L7:
        s = "GL_FOG";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "GL_LIGHTING";
        continue; /* Loop/switch isn't completed */
_L16:
        s = "GL_TEXTURE_2D";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "GL_CULL_FACE";
        continue; /* Loop/switch isn't completed */
_L11:
        s = "GL_ALPHA_TEST";
        continue; /* Loop/switch isn't completed */
_L13:
        s = "GL_BLEND";
        continue; /* Loop/switch isn't completed */
_L14:
        s = "GL_COLOR_LOGIC_OP";
        continue; /* Loop/switch isn't completed */
_L12:
        s = "GL_DITHER";
        continue; /* Loop/switch isn't completed */
_L9:
        s = "GL_STENCIL_TEST";
        continue; /* Loop/switch isn't completed */
_L8:
        s = "GL_DEPTH_TEST";
        continue; /* Loop/switch isn't completed */
_L17:
        s = "GL_LIGHT0";
        continue; /* Loop/switch isn't completed */
_L18:
        s = "GL_LIGHT1";
        continue; /* Loop/switch isn't completed */
_L19:
        s = "GL_LIGHT2";
        continue; /* Loop/switch isn't completed */
_L20:
        s = "GL_LIGHT3";
        continue; /* Loop/switch isn't completed */
_L21:
        s = "GL_LIGHT4";
        continue; /* Loop/switch isn't completed */
_L22:
        s = "GL_LIGHT5";
        continue; /* Loop/switch isn't completed */
_L23:
        s = "GL_LIGHT6";
        continue; /* Loop/switch isn't completed */
_L24:
        s = "GL_LIGHT7";
        continue; /* Loop/switch isn't completed */
_L2:
        s = "GL_POINT_SMOOTH";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "GL_LINE_SMOOTH";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "GL_COLOR_MATERIAL";
        continue; /* Loop/switch isn't completed */
_L10:
        s = "GL_NORMALIZE";
        continue; /* Loop/switch isn't completed */
_L25:
        s = "GL_RESCALE_NORMAL";
        continue; /* Loop/switch isn't completed */
_L26:
        s = "GL_VERTEX_ARRAY";
        continue; /* Loop/switch isn't completed */
_L27:
        s = "GL_NORMAL_ARRAY";
        continue; /* Loop/switch isn't completed */
_L28:
        s = "GL_COLOR_ARRAY";
        continue; /* Loop/switch isn't completed */
_L29:
        s = "GL_TEXTURE_COORD_ARRAY";
        continue; /* Loop/switch isn't completed */
_L30:
        s = "GL_MULTISAMPLE";
        continue; /* Loop/switch isn't completed */
_L31:
        s = "GL_SAMPLE_ALPHA_TO_COVERAGE";
        continue; /* Loop/switch isn't completed */
_L32:
        s = "GL_SAMPLE_ALPHA_TO_ONE";
        continue; /* Loop/switch isn't completed */
_L33:
        s = "GL_SAMPLE_COVERAGE";
        continue; /* Loop/switch isn't completed */
_L15:
        s = "GL_SCISSOR_TEST";
        if(true) goto _L35; else goto _L34
_L34:
    }

    private String getClearBufferMask(int i) {
        StringBuilder stringbuilder = new StringBuilder();
        if((i & 0x100) != 0) {
            stringbuilder.append("GL_DEPTH_BUFFER_BIT");
            i &= 0xfffffeff;
        }
        if((i & 0x400) != 0) {
            if(stringbuilder.length() > 0)
                stringbuilder.append(" | ");
            stringbuilder.append("GL_STENCIL_BUFFER_BIT");
            i &= 0xfffffbff;
        }
        if((i & 0x4000) != 0) {
            if(stringbuilder.length() > 0)
                stringbuilder.append(" | ");
            stringbuilder.append("GL_COLOR_BUFFER_BIT");
            i &= 0xffffbfff;
        }
        if(i != 0) {
            if(stringbuilder.length() > 0)
                stringbuilder.append(" | ");
            stringbuilder.append(getHex(i));
        }
        return stringbuilder.toString();
    }

    private String getClientState(int i) {
        i;
        JVM INSTR tableswitch 32884 32888: default 36
    //                   32884 50
    //                   32885 57
    //                   32886 43
    //                   32887 36
    //                   32888 64;
           goto _L1 _L2 _L3 _L4 _L1 _L5
_L1:
        String s = getHex(i);
_L7:
        return s;
_L4:
        s = "GL_COLOR_ARRAY";
        continue; /* Loop/switch isn't completed */
_L2:
        s = "GL_VERTEX_ARRAY";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "GL_NORMAL_ARRAY";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "GL_TEXTURE_COORD_ARRAY";
        if(true) goto _L7; else goto _L6
_L6:
    }

    public static String getErrorString(int i) {
        i;
        JVM INSTR lookupswitch 7: default 68
    //                   0: 75
    //                   1280: 82
    //                   1281: 89
    //                   1282: 96
    //                   1283: 103
    //                   1284: 110
    //                   1285: 117;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        String s = getHex(i);
_L10:
        return s;
_L2:
        s = "GL_NO_ERROR";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "GL_INVALID_ENUM";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "GL_INVALID_VALUE";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "GL_INVALID_OPERATION";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "GL_STACK_OVERFLOW";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "GL_STACK_UNDERFLOW";
        continue; /* Loop/switch isn't completed */
_L8:
        s = "GL_OUT_OF_MEMORY";
        if(true) goto _L10; else goto _L9
_L9:
    }

    private String getFaceName(int i) {
        i;
        JVM INSTR tableswitch 1032 1032: default 20
    //                   1032 27;
           goto _L1 _L2
_L1:
        String s = getHex(i);
_L4:
        return s;
_L2:
        s = "GL_FRONT_AND_BACK";
        if(true) goto _L4; else goto _L3
_L3:
    }

    private String getFactor(int i) {
        i;
        JVM INSTR lookupswitch 11: default 100
    //                   0: 107
    //                   1: 114
    //                   768: 121
    //                   769: 128
    //                   770: 149
    //                   771: 156
    //                   772: 163
    //                   773: 170
    //                   774: 135
    //                   775: 142
    //                   776: 177;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L1:
        String s = getHex(i);
_L14:
        return s;
_L2:
        s = "GL_ZERO";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "GL_ONE";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "GL_SRC_COLOR";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "GL_ONE_MINUS_SRC_COLOR";
        continue; /* Loop/switch isn't completed */
_L10:
        s = "GL_DST_COLOR";
        continue; /* Loop/switch isn't completed */
_L11:
        s = "GL_ONE_MINUS_DST_COLOR";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "GL_SRC_ALPHA";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "GL_ONE_MINUS_SRC_ALPHA";
        continue; /* Loop/switch isn't completed */
_L8:
        s = "GL_DST_ALPHA";
        continue; /* Loop/switch isn't completed */
_L9:
        s = "GL_ONE_MINUS_DST_ALPHA";
        continue; /* Loop/switch isn't completed */
_L12:
        s = "GL_SRC_ALPHA_SATURATE";
        if(true) goto _L14; else goto _L13
_L13:
    }

    private String getFogPName(int i) {
        i;
        JVM INSTR tableswitch 2914 2918: default 36
    //                   2914 43
    //                   2915 50
    //                   2916 57
    //                   2917 64
    //                   2918 71;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        String s = getHex(i);
_L8:
        return s;
_L2:
        s = "GL_FOG_DENSITY";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "GL_FOG_START";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "GL_FOG_END";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "GL_FOG_MODE";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "GL_FOG_COLOR";
        if(true) goto _L8; else goto _L7
_L7:
    }

    private int getFogParamCount(int i) {
        int j = 1;
        i;
        JVM INSTR tableswitch 2914 2918: default 36
    //                   2914 38
    //                   2915 38
    //                   2916 38
    //                   2917 38
    //                   2918 40;
           goto _L1 _L2 _L2 _L2 _L2 _L3
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        j = 0;
_L5:
        return j;
_L3:
        j = 4;
        if(true) goto _L5; else goto _L4
_L4:
    }

    private static String getHex(int i) {
        return (new StringBuilder()).append("0x").append(Integer.toHexString(i)).toString();
    }

    private String getHintMode(int i) {
        i;
        JVM INSTR tableswitch 4352 4354: default 28
    //                   4352 49
    //                   4353 35
    //                   4354 42;
           goto _L1 _L2 _L3 _L4
_L1:
        String s = getHex(i);
_L6:
        return s;
_L3:
        s = "GL_FASTEST";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "GL_NICEST";
        continue; /* Loop/switch isn't completed */
_L2:
        s = "GL_DONT_CARE";
        if(true) goto _L6; else goto _L5
_L5:
    }

    private String getHintTarget(int i) {
        i;
        JVM INSTR lookupswitch 6: default 60
    //                   3152: 81
    //                   3153: 88
    //                   3154: 74
    //                   3155: 95
    //                   3156: 67
    //                   33170: 102;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        String s = getHex(i);
_L9:
        return s;
_L6:
        s = "GL_FOG_HINT";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "GL_LINE_SMOOTH_HINT";
        continue; /* Loop/switch isn't completed */
_L2:
        s = "GL_PERSPECTIVE_CORRECTION_HINT";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "GL_POINT_SMOOTH_HINT";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "GL_POLYGON_SMOOTH_HINT";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "GL_GENERATE_MIPMAP_HINT";
        if(true) goto _L9; else goto _L8
_L8:
    }

    private String getIndexType(int i) {
        i;
        JVM INSTR tableswitch 5121 5123: default 28
    //                   5121 42
    //                   5122 28
    //                   5123 35;
           goto _L1 _L2 _L1 _L3
_L1:
        String s = getHex(i);
_L5:
        return s;
_L3:
        s = "GL_UNSIGNED_SHORT";
        continue; /* Loop/switch isn't completed */
_L2:
        s = "GL_UNSIGNED_BYTE";
        if(true) goto _L5; else goto _L4
_L4:
    }

    private int getIntegerStateFormat(int i) {
        i;
        JVM INSTR tableswitch 35213 35215: default 28
    //                   35213 32
    //                   35214 32
    //                   35215 32;
           goto _L1 _L2 _L2 _L2
_L1:
        int j = 0;
_L4:
        return j;
_L2:
        j = 1;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private String getIntegerStateName(int i) {
        i;
        JVM INSTR lookupswitch 25: default 212
    //                   2834: 352
    //                   2850: 345
    //                   3377: 282
    //                   3379: 289
    //                   3382: 303
    //                   3384: 310
    //                   3385: 317
    //                   3386: 296
    //                   3408: 366
    //                   3410: 338
    //                   3411: 261
    //                   3412: 240
    //                   3413: 219
    //                   3414: 254
    //                   3415: 359
    //                   33000: 275
    //                   33001: 268
    //                   33901: 233
    //                   33902: 226
    //                   34018: 324
    //                   34466: 331
    //                   34467: 247
    //                   35213: 373
    //                   35214: 380
    //                   35215: 387;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26
_L1:
        String s = getHex(i);
_L28:
        return s;
_L14:
        s = "GL_ALPHA_BITS";
        continue; /* Loop/switch isn't completed */
_L20:
        s = "GL_ALIASED_LINE_WIDTH_RANGE";
        continue; /* Loop/switch isn't completed */
_L19:
        s = "GL_ALIASED_POINT_SIZE_RANGE";
        continue; /* Loop/switch isn't completed */
_L13:
        s = "GL_BLUE_BITS";
        continue; /* Loop/switch isn't completed */
_L23:
        s = "GL_COMPRESSED_TEXTURE_FORMATS";
        continue; /* Loop/switch isn't completed */
_L15:
        s = "GL_DEPTH_BITS";
        continue; /* Loop/switch isn't completed */
_L12:
        s = "GL_GREEN_BITS";
        continue; /* Loop/switch isn't completed */
_L18:
        s = "GL_MAX_ELEMENTS_INDICES";
        continue; /* Loop/switch isn't completed */
_L17:
        s = "GL_MAX_ELEMENTS_VERTICES";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "GL_MAX_LIGHTS";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "GL_MAX_TEXTURE_SIZE";
        continue; /* Loop/switch isn't completed */
_L9:
        s = "GL_MAX_VIEWPORT_DIMS";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "GL_MAX_MODELVIEW_STACK_DEPTH";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "GL_MAX_PROJECTION_STACK_DEPTH";
        continue; /* Loop/switch isn't completed */
_L8:
        s = "GL_MAX_TEXTURE_STACK_DEPTH";
        continue; /* Loop/switch isn't completed */
_L21:
        s = "GL_MAX_TEXTURE_UNITS";
        continue; /* Loop/switch isn't completed */
_L22:
        s = "GL_NUM_COMPRESSED_TEXTURE_FORMATS";
        continue; /* Loop/switch isn't completed */
_L11:
        s = "GL_RED_BITS";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "GL_SMOOTH_LINE_WIDTH_RANGE";
        continue; /* Loop/switch isn't completed */
_L2:
        s = "GL_SMOOTH_POINT_SIZE_RANGE";
        continue; /* Loop/switch isn't completed */
_L16:
        s = "GL_STENCIL_BITS";
        continue; /* Loop/switch isn't completed */
_L10:
        s = "GL_SUBPIXEL_BITS";
        continue; /* Loop/switch isn't completed */
_L24:
        s = "GL_MODELVIEW_MATRIX_FLOAT_AS_INT_BITS_OES";
        continue; /* Loop/switch isn't completed */
_L25:
        s = "GL_PROJECTION_MATRIX_FLOAT_AS_INT_BITS_OES";
        continue; /* Loop/switch isn't completed */
_L26:
        s = "GL_TEXTURE_MATRIX_FLOAT_AS_INT_BITS_OES";
        if(true) goto _L28; else goto _L27
_L27:
    }

    private int getIntegerStateSize(int i) {
        int j = 1;
        i;
        JVM INSTR lookupswitch 25: default 212
    //                   2834: 261
    //                   2850: 256
    //                   3377: 214
    //                   3379: 214
    //                   3382: 214
    //                   3384: 214
    //                   3385: 214
    //                   3386: 251
    //                   3408: 214
    //                   3410: 214
    //                   3411: 214
    //                   3412: 214
    //                   3413: 214
    //                   3414: 214
    //                   3415: 214
    //                   33000: 214
    //                   33001: 214
    //                   33901: 221
    //                   33902: 216
    //                   34018: 214
    //                   34466: 214
    //                   34467: 226
    //                   35213: 266
    //                   35214: 266
    //                   35215: 266;
           goto _L1 _L2 _L3 _L4 _L4 _L4 _L4 _L4 _L5 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L6 _L7 _L4 _L4 _L8 _L9 _L9 _L9
_L4:
        break; /* Loop/switch isn't completed */
_L1:
        j = 0;
_L11:
        return j;
_L7:
        j = 2;
        continue; /* Loop/switch isn't completed */
_L6:
        j = 2;
        continue; /* Loop/switch isn't completed */
_L8:
        int ai[] = new int[j];
        super.mgl.glGetIntegerv(34466, ai, 0);
        j = ai[0];
        continue; /* Loop/switch isn't completed */
_L5:
        j = 2;
        continue; /* Loop/switch isn't completed */
_L3:
        j = 2;
        continue; /* Loop/switch isn't completed */
_L2:
        j = 2;
        continue; /* Loop/switch isn't completed */
_L9:
        j = 16;
        if(true) goto _L11; else goto _L10
_L10:
    }

    private String getLightModelPName(int i) {
        i;
        JVM INSTR tableswitch 2898 2899: default 24
    //                   2898 38
    //                   2899 31;
           goto _L1 _L2 _L3
_L1:
        String s = getHex(i);
_L5:
        return s;
_L3:
        s = "GL_LIGHT_MODEL_AMBIENT";
        continue; /* Loop/switch isn't completed */
_L2:
        s = "GL_LIGHT_MODEL_TWO_SIDE";
        if(true) goto _L5; else goto _L4
_L4:
    }

    private int getLightModelParamCount(int i) {
        i;
        JVM INSTR tableswitch 2898 2899: default 24
    //                   2898 33
    //                   2899 28;
           goto _L1 _L2 _L3
_L1:
        int j = 0;
_L5:
        return j;
_L3:
        j = 4;
        continue; /* Loop/switch isn't completed */
_L2:
        j = 1;
        if(true) goto _L5; else goto _L4
_L4:
    }

    private String getLightName(int i) {
        String s;
        if(i >= 16384 && i <= 16391)
            s = (new StringBuilder()).append("GL_LIGHT").append(Integer.toString(i)).toString();
        else
            s = getHex(i);
        return s;
    }

    private String getLightPName(int i) {
        i;
        JVM INSTR tableswitch 4608 4617: default 56
    //                   4608 63
    //                   4609 70
    //                   4610 77
    //                   4611 84
    //                   4612 91
    //                   4613 98
    //                   4614 105
    //                   4615 112
    //                   4616 119
    //                   4617 126;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L1:
        String s = getHex(i);
_L13:
        return s;
_L2:
        s = "GL_AMBIENT";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "GL_DIFFUSE";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "GL_SPECULAR";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "GL_POSITION";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "GL_SPOT_DIRECTION";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "GL_SPOT_EXPONENT";
        continue; /* Loop/switch isn't completed */
_L8:
        s = "GL_SPOT_CUTOFF";
        continue; /* Loop/switch isn't completed */
_L9:
        s = "GL_CONSTANT_ATTENUATION";
        continue; /* Loop/switch isn't completed */
_L10:
        s = "GL_LINEAR_ATTENUATION";
        continue; /* Loop/switch isn't completed */
_L11:
        s = "GL_QUADRATIC_ATTENUATION";
        if(true) goto _L13; else goto _L12
_L12:
    }

    private int getLightParamCount(int i) {
        byte byte0 = 4;
        i;
        JVM INSTR tableswitch 4608 4617: default 56
    //                   4608 58
    //                   4609 58
    //                   4610 58
    //                   4611 58
    //                   4612 60
    //                   4613 65
    //                   4614 70
    //                   4615 75
    //                   4616 80
    //                   4617 85;
           goto _L1 _L2 _L2 _L2 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        byte0 = 0;
_L10:
        return byte0;
_L3:
        byte0 = 3;
        continue; /* Loop/switch isn't completed */
_L4:
        byte0 = 1;
        continue; /* Loop/switch isn't completed */
_L5:
        byte0 = 1;
        continue; /* Loop/switch isn't completed */
_L6:
        byte0 = 1;
        continue; /* Loop/switch isn't completed */
_L7:
        byte0 = 1;
        continue; /* Loop/switch isn't completed */
_L8:
        byte0 = 1;
        if(true) goto _L10; else goto _L9
_L9:
    }

    private String getMaterialPName(int i) {
        i;
        JVM INSTR lookupswitch 6: default 60
    //                   4608: 67
    //                   4609: 74
    //                   4610: 81
    //                   5632: 88
    //                   5633: 95
    //                   5634: 102;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        String s = getHex(i);
_L9:
        return s;
_L2:
        s = "GL_AMBIENT";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "GL_DIFFUSE";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "GL_SPECULAR";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "GL_EMISSION";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "GL_SHININESS";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "GL_AMBIENT_AND_DIFFUSE";
        if(true) goto _L9; else goto _L8
_L8:
    }

    private int getMaterialParamCount(int i) {
        byte byte0 = 4;
        i;
        JVM INSTR lookupswitch 6: default 60
    //                   4608: 62
    //                   4609: 62
    //                   4610: 62
    //                   5632: 62
    //                   5633: 64
    //                   5634: 62;
           goto _L1 _L2 _L2 _L2 _L2 _L3 _L2
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        byte0 = 0;
_L5:
        return byte0;
_L3:
        byte0 = 1;
        if(true) goto _L5; else goto _L4
_L4:
    }

    private String getMatrixMode(int i) {
        i;
        JVM INSTR tableswitch 5888 5890: default 28
    //                   5888 35
    //                   5889 42
    //                   5890 49;
           goto _L1 _L2 _L3 _L4
_L1:
        String s = getHex(i);
_L6:
        return s;
_L2:
        s = "GL_MODELVIEW";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "GL_PROJECTION";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "GL_TEXTURE";
        if(true) goto _L6; else goto _L5
_L5:
    }

    private String getPointerTypeName(int i) {
        i;
        JVM INSTR lookupswitch 5: default 52
    //                   5120: 59
    //                   5121: 66
    //                   5122: 73
    //                   5126: 87
    //                   5132: 80;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        String s = getHex(i);
_L8:
        return s;
_L2:
        s = "GL_BYTE";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "GL_UNSIGNED_BYTE";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "GL_SHORT";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "GL_FIXED";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "GL_FLOAT";
        if(true) goto _L8; else goto _L7
_L7:
    }

    private String getShadeModel(int i) {
        i;
        JVM INSTR tableswitch 7424 7425: default 24
    //                   7424 31
    //                   7425 38;
           goto _L1 _L2 _L3
_L1:
        String s = getHex(i);
_L5:
        return s;
_L2:
        s = "GL_FLAT";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "GL_SMOOTH";
        if(true) goto _L5; else goto _L4
_L4:
    }

    private String getTextureEnvPName(int i) {
        i;
        JVM INSTR tableswitch 8704 8705: default 24
    //                   8704 31
    //                   8705 38;
           goto _L1 _L2 _L3
_L1:
        String s = getHex(i);
_L5:
        return s;
_L2:
        s = "GL_TEXTURE_ENV_MODE";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "GL_TEXTURE_ENV_COLOR";
        if(true) goto _L5; else goto _L4
_L4:
    }

    private int getTextureEnvParamCount(int i) {
        i;
        JVM INSTR tableswitch 8704 8705: default 24
    //                   8704 28
    //                   8705 33;
           goto _L1 _L2 _L3
_L1:
        int j = 0;
_L5:
        return j;
_L2:
        j = 1;
        continue; /* Loop/switch isn't completed */
_L3:
        j = 4;
        if(true) goto _L5; else goto _L4
_L4:
    }

    private String getTextureEnvParamName(float f) {
        int i = (int)f;
        if(f != (float)i) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR lookupswitch 6: default 68
    //                   260: 103
    //                   3042: 96
    //                   7681: 75
    //                   8448: 82
    //                   8449: 89
    //                   34160: 110;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L3:
        String s = getHex(i);
_L11:
        return s;
_L6:
        s = "GL_REPLACE";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "GL_MODULATE";
        continue; /* Loop/switch isn't completed */
_L8:
        s = "GL_DECAL";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "GL_BLEND";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "GL_ADD";
        continue; /* Loop/switch isn't completed */
_L9:
        s = "GL_COMBINE";
        continue; /* Loop/switch isn't completed */
_L2:
        s = Float.toString(f);
        if(true) goto _L11; else goto _L10
_L10:
    }

    private String getTextureEnvTarget(int i) {
        i;
        JVM INSTR tableswitch 8960 8960: default 20
    //                   8960 27;
           goto _L1 _L2
_L1:
        String s = getHex(i);
_L4:
        return s;
_L2:
        s = "GL_TEXTURE_ENV";
        if(true) goto _L4; else goto _L3
_L3:
    }

    private String getTexturePName(int i) {
        i;
        JVM INSTR lookupswitch 6: default 60
    //                   10240: 67
    //                   10241: 74
    //                   10242: 81
    //                   10243: 88
    //                   33169: 95
    //                   35741: 102;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        String s = getHex(i);
_L9:
        return s;
_L2:
        s = "GL_TEXTURE_MAG_FILTER";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "GL_TEXTURE_MIN_FILTER";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "GL_TEXTURE_WRAP_S";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "GL_TEXTURE_WRAP_T";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "GL_GENERATE_MIPMAP";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "GL_TEXTURE_CROP_RECT_OES";
        if(true) goto _L9; else goto _L8
_L8:
    }

    private String getTextureParamName(float f) {
        int i = (int)f;
        if(f != (float)i) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR lookupswitch 8: default 84
    //                   9728: 105
    //                   9729: 112
    //                   9984: 119
    //                   9985: 126
    //                   9986: 133
    //                   9987: 140
    //                   10497: 98
    //                   33071: 91;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L3:
        String s = getHex(i);
_L13:
        return s;
_L11:
        s = "GL_CLAMP_TO_EDGE";
        continue; /* Loop/switch isn't completed */
_L10:
        s = "GL_REPEAT";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "GL_NEAREST";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "GL_LINEAR";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "GL_NEAREST_MIPMAP_NEAREST";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "GL_LINEAR_MIPMAP_NEAREST";
        continue; /* Loop/switch isn't completed */
_L8:
        s = "GL_NEAREST_MIPMAP_LINEAR";
        continue; /* Loop/switch isn't completed */
_L9:
        s = "GL_LINEAR_MIPMAP_LINEAR";
        continue; /* Loop/switch isn't completed */
_L2:
        s = Float.toString(f);
        if(true) goto _L13; else goto _L12
_L12:
    }

    private String getTextureTarget(int i) {
        i;
        JVM INSTR tableswitch 3553 3553: default 20
    //                   3553 27;
           goto _L1 _L2
_L1:
        String s = getHex(i);
_L4:
        return s;
_L2:
        s = "GL_TEXTURE_2D";
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void log(String s) {
        mLog.write(s);
_L2:
        return;
        IOException ioexception;
        ioexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private void logLine(String s) {
        log((new StringBuilder()).append(s).append('\n').toString());
    }

    private void returns(int i) {
        returns(Integer.toString(i));
    }

    private void returns(String s) {
        log((new StringBuilder()).append(") returns ").append(s).append(";\n").toString());
        flush();
    }

    private void startLogIndices() {
        mStringBuilder = new StringBuilder();
        mStringBuilder.append("\n");
        bindArrays();
    }

    private ByteBuffer toByteBuffer(int i, Buffer buffer) {
        boolean flag;
        ByteBuffer bytebuffer;
        if(i < 0)
            flag = true;
        else
            flag = false;
        if(buffer instanceof ByteBuffer) {
            ByteBuffer bytebuffer1 = (ByteBuffer)buffer;
            int j3 = bytebuffer1.position();
            if(flag)
                i = bytebuffer1.limit() - j3;
            bytebuffer = ByteBuffer.allocate(i).order(bytebuffer1.order());
            for(int k3 = 0; k3 < i; k3++)
                bytebuffer.put(bytebuffer1.get());

            bytebuffer1.position(j3);
        } else
        if(buffer instanceof CharBuffer) {
            CharBuffer charbuffer = (CharBuffer)buffer;
            int l2 = charbuffer.position();
            if(flag)
                i = 2 * (charbuffer.limit() - l2);
            bytebuffer = ByteBuffer.allocate(i).order(charbuffer.order());
            CharBuffer charbuffer1 = bytebuffer.asCharBuffer();
            for(int i3 = 0; i3 < i / 2; i3++)
                charbuffer1.put(charbuffer.get());

            charbuffer.position(l2);
        } else
        if(buffer instanceof ShortBuffer) {
            ShortBuffer shortbuffer = (ShortBuffer)buffer;
            int j2 = shortbuffer.position();
            if(flag)
                i = 2 * (shortbuffer.limit() - j2);
            bytebuffer = ByteBuffer.allocate(i).order(shortbuffer.order());
            ShortBuffer shortbuffer1 = bytebuffer.asShortBuffer();
            for(int k2 = 0; k2 < i / 2; k2++)
                shortbuffer1.put(shortbuffer.get());

            shortbuffer.position(j2);
        } else
        if(buffer instanceof IntBuffer) {
            IntBuffer intbuffer = (IntBuffer)buffer;
            int l1 = intbuffer.position();
            if(flag)
                i = 4 * (intbuffer.limit() - l1);
            bytebuffer = ByteBuffer.allocate(i).order(intbuffer.order());
            IntBuffer intbuffer1 = bytebuffer.asIntBuffer();
            for(int i2 = 0; i2 < i / 4; i2++)
                intbuffer1.put(intbuffer.get());

            intbuffer.position(l1);
        } else
        if(buffer instanceof FloatBuffer) {
            FloatBuffer floatbuffer = (FloatBuffer)buffer;
            int j1 = floatbuffer.position();
            if(flag)
                i = 4 * (floatbuffer.limit() - j1);
            bytebuffer = ByteBuffer.allocate(i).order(floatbuffer.order());
            FloatBuffer floatbuffer1 = bytebuffer.asFloatBuffer();
            for(int k1 = 0; k1 < i / 4; k1++)
                floatbuffer1.put(floatbuffer.get());

            floatbuffer.position(j1);
        } else
        if(buffer instanceof DoubleBuffer) {
            DoubleBuffer doublebuffer = (DoubleBuffer)buffer;
            int l = doublebuffer.position();
            if(flag)
                i = 8 * (doublebuffer.limit() - l);
            bytebuffer = ByteBuffer.allocate(i).order(doublebuffer.order());
            DoubleBuffer doublebuffer1 = bytebuffer.asDoubleBuffer();
            for(int i1 = 0; i1 < i / 8; i1++)
                doublebuffer1.put(doublebuffer.get());

            doublebuffer.position(l);
        } else
        if(buffer instanceof LongBuffer) {
            LongBuffer longbuffer = (LongBuffer)buffer;
            int j = longbuffer.position();
            if(flag)
                i = 8 * (longbuffer.limit() - j);
            bytebuffer = ByteBuffer.allocate(i).order(longbuffer.order());
            LongBuffer longbuffer1 = bytebuffer.asLongBuffer();
            for(int k = 0; k < i / 8; k++)
                longbuffer1.put(longbuffer.get());

            longbuffer.position(j);
        } else {
            throw new RuntimeException("Unimplemented Buffer subclass.");
        }
        bytebuffer.rewind();
        bytebuffer.order(ByteOrder.nativeOrder());
        return bytebuffer;
    }

    private char[] toCharIndices(int i, int j, Buffer buffer) {
        char ac[] = new char[i];
        j;
        JVM INSTR tableswitch 5121 5123: default 32
    //                   5121 35
    //                   5122 32
    //                   5123 90;
           goto _L1 _L2 _L1 _L3
_L1:
        return ac;
_L2:
        ByteBuffer bytebuffer = toByteBuffer(i, buffer);
        byte abyte0[] = bytebuffer.array();
        int l = bytebuffer.arrayOffset();
        int i1 = 0;
        while(i1 < i)  {
            ac[i1] = (char)(0xff & abyte0[l + i1]);
            i1++;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        CharBuffer charbuffer;
        int k;
        if(buffer instanceof CharBuffer)
            charbuffer = (CharBuffer)buffer;
        else
            charbuffer = toByteBuffer(i * 2, buffer).asCharBuffer();
        k = charbuffer.position();
        charbuffer.position(0);
        charbuffer.get(ac);
        charbuffer.position(k);
        if(true) goto _L1; else goto _L4
_L4:
    }

    private String toString(int i, int j, IntBuffer intbuffer) {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("{\n");
        for(int k = 0; k < i; k++) {
            stringbuilder.append((new StringBuilder()).append(" [").append(k).append("] = ").toString());
            formattedAppend(stringbuilder, intbuffer.get(k), j);
            stringbuilder.append('\n');
        }

        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    private String toString(int i, int j, int ai[], int k) {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("{\n");
        int l = ai.length;
        int i1 = 0;
        while(i1 < i)  {
            int j1 = k + i1;
            stringbuilder.append((new StringBuilder()).append(" [").append(j1).append("] = ").toString());
            if(j1 < 0 || j1 >= l)
                stringbuilder.append("out of bounds");
            else
                formattedAppend(stringbuilder, ai[j1], j);
            stringbuilder.append('\n');
            i1++;
        }
        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    private String toString(int i, FloatBuffer floatbuffer) {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("{\n");
        for(int j = 0; j < i; j++)
            stringbuilder.append((new StringBuilder()).append(" [").append(j).append("] = ").append(floatbuffer.get(j)).append('\n').toString());

        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    private String toString(int i, ShortBuffer shortbuffer) {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("{\n");
        for(int j = 0; j < i; j++)
            stringbuilder.append((new StringBuilder()).append(" [").append(j).append("] = ").append(shortbuffer.get(j)).append('\n').toString());

        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    private String toString(int i, float af[], int j) {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("{\n");
        int k = af.length;
        int l = 0;
        while(l < i)  {
            int i1 = j + l;
            stringbuilder.append((new StringBuilder()).append("[").append(i1).append("] = ").toString());
            if(i1 < 0 || i1 >= k)
                stringbuilder.append("out of bounds");
            else
                stringbuilder.append(af[i1]);
            stringbuilder.append('\n');
            l++;
        }
        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    private String toString(int i, short aword0[], int j) {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("{\n");
        int k = aword0.length;
        int l = 0;
        while(l < i)  {
            int i1 = j + l;
            stringbuilder.append((new StringBuilder()).append(" [").append(i1).append("] = ").toString());
            if(i1 < 0 || i1 >= k)
                stringbuilder.append("out of bounds");
            else
                stringbuilder.append(aword0[i1]);
            stringbuilder.append('\n');
            l++;
        }
        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    private void unbindArrays() {
        if(mColorArrayEnabled)
            mColorPointer.unbindByteBuffer();
        if(mNormalArrayEnabled)
            mNormalPointer.unbindByteBuffer();
        if(mTextureCoordArrayEnabled)
            mTexCoordPointer.unbindByteBuffer();
        if(mVertexArrayEnabled)
            mVertexPointer.unbindByteBuffer();
    }

    public void glActiveTexture(int i) {
        begin("glActiveTexture");
        arg("texture", i);
        end();
        super.mgl.glActiveTexture(i);
        checkError();
    }

    public void glAlphaFunc(int i, float f) {
        begin("glAlphaFunc");
        arg("func", i);
        arg("ref", f);
        end();
        super.mgl.glAlphaFunc(i, f);
        checkError();
    }

    public void glAlphaFuncx(int i, int j) {
        begin("glAlphaFuncx");
        arg("func", i);
        arg("ref", j);
        end();
        super.mgl.glAlphaFuncx(i, j);
        checkError();
    }

    public void glBindBuffer(int i, int j) {
        begin("glBindBuffer");
        arg("target", i);
        arg("buffer", j);
        end();
        super.mgl11.glBindBuffer(i, j);
        checkError();
    }

    public void glBindFramebufferOES(int i, int j) {
        begin("glBindFramebufferOES");
        arg("target", i);
        arg("framebuffer", j);
        end();
        super.mgl11ExtensionPack.glBindFramebufferOES(i, j);
        checkError();
    }

    public void glBindRenderbufferOES(int i, int j) {
        begin("glBindRenderbufferOES");
        arg("target", i);
        arg("renderbuffer", j);
        end();
        super.mgl11ExtensionPack.glBindRenderbufferOES(i, j);
        checkError();
    }

    public void glBindTexture(int i, int j) {
        begin("glBindTexture");
        arg("target", getTextureTarget(i));
        arg("texture", j);
        end();
        super.mgl.glBindTexture(i, j);
        checkError();
    }

    public void glBlendEquation(int i) {
        begin("glBlendEquation");
        arg("mode", i);
        end();
        super.mgl11ExtensionPack.glBlendEquation(i);
        checkError();
    }

    public void glBlendEquationSeparate(int i, int j) {
        begin("glBlendEquationSeparate");
        arg("modeRGB", i);
        arg("modeAlpha", j);
        end();
        super.mgl11ExtensionPack.glBlendEquationSeparate(i, j);
        checkError();
    }

    public void glBlendFunc(int i, int j) {
        begin("glBlendFunc");
        arg("sfactor", getFactor(i));
        arg("dfactor", getFactor(j));
        end();
        super.mgl.glBlendFunc(i, j);
        checkError();
    }

    public void glBlendFuncSeparate(int i, int j, int k, int l) {
        begin("glBlendFuncSeparate");
        arg("srcRGB", i);
        arg("dstRGB", j);
        arg("srcAlpha", k);
        arg("dstAlpha", l);
        end();
        super.mgl11ExtensionPack.glBlendFuncSeparate(i, j, k, l);
        checkError();
    }

    public void glBufferData(int i, int j, Buffer buffer, int k) {
        begin("glBufferData");
        arg("target", i);
        arg("size", j);
        arg("data", buffer.toString());
        arg("usage", k);
        end();
        super.mgl11.glBufferData(i, j, buffer, k);
        checkError();
    }

    public void glBufferSubData(int i, int j, int k, Buffer buffer) {
        begin("glBufferSubData");
        arg("target", i);
        arg("offset", j);
        arg("size", k);
        arg("data", buffer.toString());
        end();
        super.mgl11.glBufferSubData(i, j, k, buffer);
        checkError();
    }

    public int glCheckFramebufferStatusOES(int i) {
        begin("glCheckFramebufferStatusOES");
        arg("target", i);
        end();
        int j = super.mgl11ExtensionPack.glCheckFramebufferStatusOES(i);
        checkError();
        return j;
    }

    public void glClear(int i) {
        begin("glClear");
        arg("mask", getClearBufferMask(i));
        end();
        super.mgl.glClear(i);
        checkError();
    }

    public void glClearColor(float f, float f1, float f2, float f3) {
        begin("glClearColor");
        arg("red", f);
        arg("green", f1);
        arg("blue", f2);
        arg("alpha", f3);
        end();
        super.mgl.glClearColor(f, f1, f2, f3);
        checkError();
    }

    public void glClearColorx(int i, int j, int k, int l) {
        begin("glClearColor");
        arg("red", i);
        arg("green", j);
        arg("blue", k);
        arg("alpha", l);
        end();
        super.mgl.glClearColorx(i, j, k, l);
        checkError();
    }

    public void glClearDepthf(float f) {
        begin("glClearDepthf");
        arg("depth", f);
        end();
        super.mgl.glClearDepthf(f);
        checkError();
    }

    public void glClearDepthx(int i) {
        begin("glClearDepthx");
        arg("depth", i);
        end();
        super.mgl.glClearDepthx(i);
        checkError();
    }

    public void glClearStencil(int i) {
        begin("glClearStencil");
        arg("s", i);
        end();
        super.mgl.glClearStencil(i);
        checkError();
    }

    public void glClientActiveTexture(int i) {
        begin("glClientActiveTexture");
        arg("texture", i);
        end();
        super.mgl.glClientActiveTexture(i);
        checkError();
    }

    public void glClipPlanef(int i, FloatBuffer floatbuffer) {
        begin("glClipPlanef");
        arg("plane", i);
        arg("equation", 4, floatbuffer);
        end();
        super.mgl11.glClipPlanef(i, floatbuffer);
        checkError();
    }

    public void glClipPlanef(int i, float af[], int j) {
        begin("glClipPlanef");
        arg("plane", i);
        arg("equation", 4, af, j);
        arg("offset", j);
        end();
        super.mgl11.glClipPlanef(i, af, j);
        checkError();
    }

    public void glClipPlanex(int i, IntBuffer intbuffer) {
        begin("glClipPlanef");
        arg("plane", i);
        arg("equation", 4, intbuffer);
        end();
        super.mgl11.glClipPlanex(i, intbuffer);
        checkError();
    }

    public void glClipPlanex(int i, int ai[], int j) {
        begin("glClipPlanex");
        arg("plane", i);
        arg("equation", 4, ai, j);
        arg("offset", j);
        end();
        super.mgl11.glClipPlanex(i, ai, j);
        checkError();
    }

    public void glColor4f(float f, float f1, float f2, float f3) {
        begin("glColor4f");
        arg("red", f);
        arg("green", f1);
        arg("blue", f2);
        arg("alpha", f3);
        end();
        super.mgl.glColor4f(f, f1, f2, f3);
        checkError();
    }

    public void glColor4ub(byte byte0, byte byte1, byte byte2, byte byte3) {
        begin("glColor4ub");
        arg("red", byte0);
        arg("green", byte1);
        arg("blue", byte2);
        arg("alpha", byte3);
        end();
        super.mgl11.glColor4ub(byte0, byte1, byte2, byte3);
        checkError();
    }

    public void glColor4x(int i, int j, int k, int l) {
        begin("glColor4x");
        arg("red", i);
        arg("green", j);
        arg("blue", k);
        arg("alpha", l);
        end();
        super.mgl.glColor4x(i, j, k, l);
        checkError();
    }

    public void glColorMask(boolean flag, boolean flag1, boolean flag2, boolean flag3) {
        begin("glColorMask");
        arg("red", flag);
        arg("green", flag1);
        arg("blue", flag2);
        arg("alpha", flag3);
        end();
        super.mgl.glColorMask(flag, flag1, flag2, flag3);
        checkError();
    }

    public void glColorPointer(int i, int j, int k, int l) {
        begin("glColorPointer");
        arg("size", i);
        arg("type", j);
        arg("stride", k);
        arg("offset", l);
        end();
        super.mgl11.glColorPointer(i, j, k, l);
        checkError();
    }

    public void glColorPointer(int i, int j, int k, Buffer buffer) {
        begin("glColorPointer");
        argPointer(i, j, k, buffer);
        end();
        mColorPointer = new PointerInfo(i, j, k, buffer);
        super.mgl.glColorPointer(i, j, k, buffer);
        checkError();
    }

    public void glCompressedTexImage2D(int i, int j, int k, int l, int i1, int j1, int k1, 
            Buffer buffer) {
        begin("glCompressedTexImage2D");
        arg("target", getTextureTarget(i));
        arg("level", j);
        arg("internalformat", k);
        arg("width", l);
        arg("height", i1);
        arg("border", j1);
        arg("imageSize", k1);
        arg("data", buffer.toString());
        end();
        super.mgl.glCompressedTexImage2D(i, j, k, l, i1, j1, k1, buffer);
        checkError();
    }

    public void glCompressedTexSubImage2D(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, Buffer buffer) {
        begin("glCompressedTexSubImage2D");
        arg("target", getTextureTarget(i));
        arg("level", j);
        arg("xoffset", k);
        arg("yoffset", l);
        arg("width", i1);
        arg("height", j1);
        arg("format", k1);
        arg("imageSize", l1);
        arg("data", buffer.toString());
        end();
        super.mgl.glCompressedTexSubImage2D(i, j, k, l, i1, j1, k1, l1, buffer);
        checkError();
    }

    public void glCopyTexImage2D(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1) {
        begin("glCopyTexImage2D");
        arg("target", getTextureTarget(i));
        arg("level", j);
        arg("internalformat", k);
        arg("x", l);
        arg("y", i1);
        arg("width", j1);
        arg("height", k1);
        arg("border", l1);
        end();
        super.mgl.glCopyTexImage2D(i, j, k, l, i1, j1, k1, l1);
        checkError();
    }

    public void glCopyTexSubImage2D(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1) {
        begin("glCopyTexSubImage2D");
        arg("target", getTextureTarget(i));
        arg("level", j);
        arg("xoffset", k);
        arg("yoffset", l);
        arg("x", i1);
        arg("y", j1);
        arg("width", k1);
        arg("height", l1);
        end();
        super.mgl.glCopyTexSubImage2D(i, j, k, l, i1, j1, k1, l1);
        checkError();
    }

    public void glCullFace(int i) {
        begin("glCullFace");
        arg("mode", i);
        end();
        super.mgl.glCullFace(i);
        checkError();
    }

    public void glCurrentPaletteMatrixOES(int i) {
        begin("glCurrentPaletteMatrixOES");
        arg("matrixpaletteindex", i);
        end();
        super.mgl11Ext.glCurrentPaletteMatrixOES(i);
        checkError();
    }

    public void glDeleteBuffers(int i, IntBuffer intbuffer) {
        begin("glDeleteBuffers");
        arg("n", i);
        arg("buffers", intbuffer.toString());
        end();
        super.mgl11.glDeleteBuffers(i, intbuffer);
        checkError();
    }

    public void glDeleteBuffers(int i, int ai[], int j) {
        begin("glDeleteBuffers");
        arg("n", i);
        arg("buffers", ai.toString());
        arg("offset", j);
        end();
        super.mgl11.glDeleteBuffers(i, ai, j);
        checkError();
    }

    public void glDeleteFramebuffersOES(int i, IntBuffer intbuffer) {
        begin("glDeleteFramebuffersOES");
        arg("n", i);
        arg("framebuffers", intbuffer.toString());
        end();
        super.mgl11ExtensionPack.glDeleteFramebuffersOES(i, intbuffer);
        checkError();
    }

    public void glDeleteFramebuffersOES(int i, int ai[], int j) {
        begin("glDeleteFramebuffersOES");
        arg("n", i);
        arg("framebuffers", ai.toString());
        arg("offset", j);
        end();
        super.mgl11ExtensionPack.glDeleteFramebuffersOES(i, ai, j);
        checkError();
    }

    public void glDeleteRenderbuffersOES(int i, IntBuffer intbuffer) {
        begin("glDeleteRenderbuffersOES");
        arg("n", i);
        arg("renderbuffers", intbuffer.toString());
        end();
        super.mgl11ExtensionPack.glDeleteRenderbuffersOES(i, intbuffer);
        checkError();
    }

    public void glDeleteRenderbuffersOES(int i, int ai[], int j) {
        begin("glDeleteRenderbuffersOES");
        arg("n", i);
        arg("renderbuffers", ai.toString());
        arg("offset", j);
        end();
        super.mgl11ExtensionPack.glDeleteRenderbuffersOES(i, ai, j);
        checkError();
    }

    public void glDeleteTextures(int i, IntBuffer intbuffer) {
        begin("glDeleteTextures");
        arg("n", i);
        arg("textures", i, intbuffer);
        end();
        super.mgl.glDeleteTextures(i, intbuffer);
        checkError();
    }

    public void glDeleteTextures(int i, int ai[], int j) {
        begin("glDeleteTextures");
        arg("n", i);
        arg("textures", i, ai, j);
        arg("offset", j);
        end();
        super.mgl.glDeleteTextures(i, ai, j);
        checkError();
    }

    public void glDepthFunc(int i) {
        begin("glDepthFunc");
        arg("func", i);
        end();
        super.mgl.glDepthFunc(i);
        checkError();
    }

    public void glDepthMask(boolean flag) {
        begin("glDepthMask");
        arg("flag", flag);
        end();
        super.mgl.glDepthMask(flag);
        checkError();
    }

    public void glDepthRangef(float f, float f1) {
        begin("glDepthRangef");
        arg("near", f);
        arg("far", f1);
        end();
        super.mgl.glDepthRangef(f, f1);
        checkError();
    }

    public void glDepthRangex(int i, int j) {
        begin("glDepthRangex");
        arg("near", i);
        arg("far", j);
        end();
        super.mgl.glDepthRangex(i, j);
        checkError();
    }

    public void glDisable(int i) {
        begin("glDisable");
        arg("cap", getCap(i));
        end();
        super.mgl.glDisable(i);
        checkError();
    }

    public void glDisableClientState(int i) {
        begin("glDisableClientState");
        arg("array", getClientState(i));
        end();
        i;
        JVM INSTR tableswitch 32884 32888: default 60
    //                   32884 99
    //                   32885 83
    //                   32886 75
    //                   32887 60
    //                   32888 91;
           goto _L1 _L2 _L3 _L4 _L1 _L5
_L1:
        super.mgl.glDisableClientState(i);
        checkError();
        return;
_L4:
        mColorArrayEnabled = false;
        continue; /* Loop/switch isn't completed */
_L3:
        mNormalArrayEnabled = false;
        continue; /* Loop/switch isn't completed */
_L5:
        mTextureCoordArrayEnabled = false;
        continue; /* Loop/switch isn't completed */
_L2:
        mVertexArrayEnabled = false;
        if(true) goto _L1; else goto _L6
_L6:
    }

    public void glDrawArrays(int i, int j, int k) {
        begin("glDrawArrays");
        arg("mode", i);
        arg("first", j);
        arg("count", k);
        startLogIndices();
        for(int l = 0; l < k; l++)
            doElement(mStringBuilder, l, j + l);

        endLogIndices();
        end();
        super.mgl.glDrawArrays(i, j, k);
        checkError();
    }

    public void glDrawElements(int i, int j, int k, int l) {
        begin("glDrawElements");
        arg("mode", i);
        arg("count", j);
        arg("type", k);
        arg("offset", l);
        end();
        super.mgl11.glDrawElements(i, j, k, l);
        checkError();
    }

    public void glDrawElements(int i, int j, int k, Buffer buffer) {
        begin("glDrawElements");
        arg("mode", getBeginMode(i));
        arg("count", j);
        arg("type", getIndexType(k));
        char ac[] = toCharIndices(j, k, buffer);
        int l = ac.length;
        startLogIndices();
        for(int i1 = 0; i1 < l; i1++)
            doElement(mStringBuilder, i1, ac[i1]);

        endLogIndices();
        end();
        super.mgl.glDrawElements(i, j, k, buffer);
        checkError();
    }

    public void glDrawTexfOES(float f, float f1, float f2, float f3, float f4) {
        begin("glDrawTexfOES");
        arg("x", f);
        arg("y", f1);
        arg("z", f2);
        arg("width", f3);
        arg("height", f4);
        end();
        super.mgl11Ext.glDrawTexfOES(f, f1, f2, f3, f4);
        checkError();
    }

    public void glDrawTexfvOES(FloatBuffer floatbuffer) {
        begin("glDrawTexfvOES");
        arg("coords", 5, floatbuffer);
        end();
        super.mgl11Ext.glDrawTexfvOES(floatbuffer);
        checkError();
    }

    public void glDrawTexfvOES(float af[], int i) {
        begin("glDrawTexfvOES");
        arg("coords", 5, af, i);
        arg("offset", i);
        end();
        super.mgl11Ext.glDrawTexfvOES(af, i);
        checkError();
    }

    public void glDrawTexiOES(int i, int j, int k, int l, int i1) {
        begin("glDrawTexiOES");
        arg("x", i);
        arg("y", j);
        arg("z", k);
        arg("width", l);
        arg("height", i1);
        end();
        super.mgl11Ext.glDrawTexiOES(i, j, k, l, i1);
        checkError();
    }

    public void glDrawTexivOES(IntBuffer intbuffer) {
        begin("glDrawTexivOES");
        arg("coords", 5, intbuffer);
        end();
        super.mgl11Ext.glDrawTexivOES(intbuffer);
        checkError();
    }

    public void glDrawTexivOES(int ai[], int i) {
        begin("glDrawTexivOES");
        arg("coords", 5, ai, i);
        arg("offset", i);
        end();
        super.mgl11Ext.glDrawTexivOES(ai, i);
        checkError();
    }

    public void glDrawTexsOES(short word0, short word1, short word2, short word3, short word4) {
        begin("glDrawTexsOES");
        arg("x", word0);
        arg("y", word1);
        arg("z", word2);
        arg("width", word3);
        arg("height", word4);
        end();
        super.mgl11Ext.glDrawTexsOES(word0, word1, word2, word3, word4);
        checkError();
    }

    public void glDrawTexsvOES(ShortBuffer shortbuffer) {
        begin("glDrawTexsvOES");
        arg("coords", 5, shortbuffer);
        end();
        super.mgl11Ext.glDrawTexsvOES(shortbuffer);
        checkError();
    }

    public void glDrawTexsvOES(short aword0[], int i) {
        begin("glDrawTexsvOES");
        arg("coords", 5, aword0, i);
        arg("offset", i);
        end();
        super.mgl11Ext.glDrawTexsvOES(aword0, i);
        checkError();
    }

    public void glDrawTexxOES(int i, int j, int k, int l, int i1) {
        begin("glDrawTexxOES");
        arg("x", i);
        arg("y", j);
        arg("z", k);
        arg("width", l);
        arg("height", i1);
        end();
        super.mgl11Ext.glDrawTexxOES(i, j, k, l, i1);
        checkError();
    }

    public void glDrawTexxvOES(IntBuffer intbuffer) {
        begin("glDrawTexxvOES");
        arg("coords", 5, intbuffer);
        end();
        super.mgl11Ext.glDrawTexxvOES(intbuffer);
        checkError();
    }

    public void glDrawTexxvOES(int ai[], int i) {
        begin("glDrawTexxvOES");
        arg("coords", 5, ai, i);
        arg("offset", i);
        end();
        super.mgl11Ext.glDrawTexxvOES(ai, i);
        checkError();
    }

    public void glEnable(int i) {
        begin("glEnable");
        arg("cap", getCap(i));
        end();
        super.mgl.glEnable(i);
        checkError();
    }

    public void glEnableClientState(int i) {
        begin("glEnableClientState");
        arg("array", getClientState(i));
        end();
        i;
        JVM INSTR tableswitch 32884 32888: default 60
    //                   32884 99
    //                   32885 83
    //                   32886 75
    //                   32887 60
    //                   32888 91;
           goto _L1 _L2 _L3 _L4 _L1 _L5
_L1:
        super.mgl.glEnableClientState(i);
        checkError();
        return;
_L4:
        mColorArrayEnabled = true;
        continue; /* Loop/switch isn't completed */
_L3:
        mNormalArrayEnabled = true;
        continue; /* Loop/switch isn't completed */
_L5:
        mTextureCoordArrayEnabled = true;
        continue; /* Loop/switch isn't completed */
_L2:
        mVertexArrayEnabled = true;
        if(true) goto _L1; else goto _L6
_L6:
    }

    public void glFinish() {
        begin("glFinish");
        end();
        super.mgl.glFinish();
        checkError();
    }

    public void glFlush() {
        begin("glFlush");
        end();
        super.mgl.glFlush();
        checkError();
    }

    public void glFogf(int i, float f) {
        begin("glFogf");
        arg("pname", i);
        arg("param", f);
        end();
        super.mgl.glFogf(i, f);
        checkError();
    }

    public void glFogfv(int i, FloatBuffer floatbuffer) {
        begin("glFogfv");
        arg("pname", getFogPName(i));
        arg("params", getFogParamCount(i), floatbuffer);
        end();
        super.mgl.glFogfv(i, floatbuffer);
        checkError();
    }

    public void glFogfv(int i, float af[], int j) {
        begin("glFogfv");
        arg("pname", getFogPName(i));
        arg("params", getFogParamCount(i), af, j);
        arg("offset", j);
        end();
        super.mgl.glFogfv(i, af, j);
        checkError();
    }

    public void glFogx(int i, int j) {
        begin("glFogx");
        arg("pname", getFogPName(i));
        arg("param", j);
        end();
        super.mgl.glFogx(i, j);
        checkError();
    }

    public void glFogxv(int i, IntBuffer intbuffer) {
        begin("glFogxv");
        arg("pname", getFogPName(i));
        arg("params", getFogParamCount(i), intbuffer);
        end();
        super.mgl.glFogxv(i, intbuffer);
        checkError();
    }

    public void glFogxv(int i, int ai[], int j) {
        begin("glFogxv");
        arg("pname", getFogPName(i));
        arg("params", getFogParamCount(i), ai, j);
        arg("offset", j);
        end();
        super.mgl.glFogxv(i, ai, j);
        checkError();
    }

    public void glFramebufferRenderbufferOES(int i, int j, int k, int l) {
        begin("glFramebufferRenderbufferOES");
        arg("target", i);
        arg("attachment", j);
        arg("renderbuffertarget", k);
        arg("renderbuffer", l);
        end();
        super.mgl11ExtensionPack.glFramebufferRenderbufferOES(i, j, k, l);
        checkError();
    }

    public void glFramebufferTexture2DOES(int i, int j, int k, int l, int i1) {
        begin("glFramebufferTexture2DOES");
        arg("target", i);
        arg("attachment", j);
        arg("textarget", k);
        arg("texture", l);
        arg("level", i1);
        end();
        super.mgl11ExtensionPack.glFramebufferTexture2DOES(i, j, k, l, i1);
        checkError();
    }

    public void glFrontFace(int i) {
        begin("glFrontFace");
        arg("mode", i);
        end();
        super.mgl.glFrontFace(i);
        checkError();
    }

    public void glFrustumf(float f, float f1, float f2, float f3, float f4, float f5) {
        begin("glFrustumf");
        arg("left", f);
        arg("right", f1);
        arg("bottom", f2);
        arg("top", f3);
        arg("near", f4);
        arg("far", f5);
        end();
        super.mgl.glFrustumf(f, f1, f2, f3, f4, f5);
        checkError();
    }

    public void glFrustumx(int i, int j, int k, int l, int i1, int j1) {
        begin("glFrustumx");
        arg("left", i);
        arg("right", j);
        arg("bottom", k);
        arg("top", l);
        arg("near", i1);
        arg("far", j1);
        end();
        super.mgl.glFrustumx(i, j, k, l, i1, j1);
        checkError();
    }

    public void glGenBuffers(int i, IntBuffer intbuffer) {
        begin("glGenBuffers");
        arg("n", i);
        arg("buffers", intbuffer.toString());
        end();
        super.mgl11.glGenBuffers(i, intbuffer);
        checkError();
    }

    public void glGenBuffers(int i, int ai[], int j) {
        begin("glGenBuffers");
        arg("n", i);
        arg("buffers", ai.toString());
        arg("offset", j);
        end();
        super.mgl11.glGenBuffers(i, ai, j);
        checkError();
    }

    public void glGenFramebuffersOES(int i, IntBuffer intbuffer) {
        begin("glGenFramebuffersOES");
        arg("n", i);
        arg("framebuffers", intbuffer.toString());
        end();
        super.mgl11ExtensionPack.glGenFramebuffersOES(i, intbuffer);
        checkError();
    }

    public void glGenFramebuffersOES(int i, int ai[], int j) {
        begin("glGenFramebuffersOES");
        arg("n", i);
        arg("framebuffers", ai.toString());
        arg("offset", j);
        end();
        super.mgl11ExtensionPack.glGenFramebuffersOES(i, ai, j);
        checkError();
    }

    public void glGenRenderbuffersOES(int i, IntBuffer intbuffer) {
        begin("glGenRenderbuffersOES");
        arg("n", i);
        arg("renderbuffers", intbuffer.toString());
        end();
        super.mgl11ExtensionPack.glGenRenderbuffersOES(i, intbuffer);
        checkError();
    }

    public void glGenRenderbuffersOES(int i, int ai[], int j) {
        begin("glGenRenderbuffersOES");
        arg("n", i);
        arg("renderbuffers", ai.toString());
        arg("offset", j);
        end();
        super.mgl11ExtensionPack.glGenRenderbuffersOES(i, ai, j);
        checkError();
    }

    public void glGenTextures(int i, IntBuffer intbuffer) {
        begin("glGenTextures");
        arg("n", i);
        arg("textures", intbuffer.toString());
        super.mgl.glGenTextures(i, intbuffer);
        returns(toString(i, 0, intbuffer));
        checkError();
    }

    public void glGenTextures(int i, int ai[], int j) {
        begin("glGenTextures");
        arg("n", i);
        arg("textures", Arrays.toString(ai));
        arg("offset", j);
        super.mgl.glGenTextures(i, ai, j);
        returns(toString(i, 0, ai, j));
        checkError();
    }

    public void glGenerateMipmapOES(int i) {
        begin("glGenerateMipmapOES");
        arg("target", i);
        end();
        super.mgl11ExtensionPack.glGenerateMipmapOES(i);
        checkError();
    }

    public void glGetBooleanv(int i, IntBuffer intbuffer) {
        begin("glGetBooleanv");
        arg("pname", i);
        arg("params", intbuffer.toString());
        end();
        super.mgl11.glGetBooleanv(i, intbuffer);
        checkError();
    }

    public void glGetBooleanv(int i, boolean aflag[], int j) {
        begin("glGetBooleanv");
        arg("pname", i);
        arg("params", aflag.toString());
        arg("offset", j);
        end();
        super.mgl11.glGetBooleanv(i, aflag, j);
        checkError();
    }

    public void glGetBufferParameteriv(int i, int j, IntBuffer intbuffer) {
        begin("glGetBufferParameteriv");
        arg("target", i);
        arg("pname", j);
        arg("params", intbuffer.toString());
        end();
        super.mgl11.glGetBufferParameteriv(i, j, intbuffer);
        checkError();
    }

    public void glGetBufferParameteriv(int i, int j, int ai[], int k) {
        begin("glGetBufferParameteriv");
        arg("target", i);
        arg("pname", j);
        arg("params", ai.toString());
        arg("offset", k);
        end();
        super.mgl11.glGetBufferParameteriv(i, j, ai, k);
        checkError();
    }

    public void glGetClipPlanef(int i, FloatBuffer floatbuffer) {
        begin("glGetClipPlanef");
        arg("pname", i);
        arg("eqn", floatbuffer.toString());
        end();
        super.mgl11.glGetClipPlanef(i, floatbuffer);
        checkError();
    }

    public void glGetClipPlanef(int i, float af[], int j) {
        begin("glGetClipPlanef");
        arg("pname", i);
        arg("eqn", af.toString());
        arg("offset", j);
        end();
        super.mgl11.glGetClipPlanef(i, af, j);
        checkError();
    }

    public void glGetClipPlanex(int i, IntBuffer intbuffer) {
        begin("glGetClipPlanex");
        arg("pname", i);
        arg("eqn", intbuffer.toString());
        end();
        super.mgl11.glGetClipPlanex(i, intbuffer);
        checkError();
    }

    public void glGetClipPlanex(int i, int ai[], int j) {
        begin("glGetClipPlanex");
        arg("pname", i);
        arg("eqn", ai.toString());
        arg("offset", j);
        end();
        super.mgl11.glGetClipPlanex(i, ai, j);
    }

    public int glGetError() {
        begin("glGetError");
        int i = super.mgl.glGetError();
        returns(i);
        return i;
    }

    public void glGetFixedv(int i, IntBuffer intbuffer) {
        begin("glGetFixedv");
        arg("pname", i);
        arg("params", intbuffer.toString());
        end();
        super.mgl11.glGetFixedv(i, intbuffer);
        checkError();
    }

    public void glGetFixedv(int i, int ai[], int j) {
        begin("glGetFixedv");
        arg("pname", i);
        arg("params", ai.toString());
        arg("offset", j);
        end();
        super.mgl11.glGetFixedv(i, ai, j);
    }

    public void glGetFloatv(int i, FloatBuffer floatbuffer) {
        begin("glGetFloatv");
        arg("pname", i);
        arg("params", floatbuffer.toString());
        end();
        super.mgl11.glGetFloatv(i, floatbuffer);
        checkError();
    }

    public void glGetFloatv(int i, float af[], int j) {
        begin("glGetFloatv");
        arg("pname", i);
        arg("params", af.toString());
        arg("offset", j);
        end();
        super.mgl11.glGetFloatv(i, af, j);
    }

    public void glGetFramebufferAttachmentParameterivOES(int i, int j, int k, IntBuffer intbuffer) {
        begin("glGetFramebufferAttachmentParameterivOES");
        arg("target", i);
        arg("attachment", j);
        arg("pname", k);
        arg("params", intbuffer.toString());
        end();
        super.mgl11ExtensionPack.glGetFramebufferAttachmentParameterivOES(i, j, k, intbuffer);
        checkError();
    }

    public void glGetFramebufferAttachmentParameterivOES(int i, int j, int k, int ai[], int l) {
        begin("glGetFramebufferAttachmentParameterivOES");
        arg("target", i);
        arg("attachment", j);
        arg("pname", k);
        arg("params", ai.toString());
        arg("offset", l);
        end();
        super.mgl11ExtensionPack.glGetFramebufferAttachmentParameterivOES(i, j, k, ai, l);
        checkError();
    }

    public void glGetIntegerv(int i, IntBuffer intbuffer) {
        begin("glGetIntegerv");
        arg("pname", getIntegerStateName(i));
        arg("params", intbuffer.toString());
        super.mgl.glGetIntegerv(i, intbuffer);
        returns(toString(getIntegerStateSize(i), getIntegerStateFormat(i), intbuffer));
        checkError();
    }

    public void glGetIntegerv(int i, int ai[], int j) {
        begin("glGetIntegerv");
        arg("pname", getIntegerStateName(i));
        arg("params", Arrays.toString(ai));
        arg("offset", j);
        super.mgl.glGetIntegerv(i, ai, j);
        returns(toString(getIntegerStateSize(i), getIntegerStateFormat(i), ai, j));
        checkError();
    }

    public void glGetLightfv(int i, int j, FloatBuffer floatbuffer) {
        begin("glGetLightfv");
        arg("light", i);
        arg("pname", j);
        arg("params", floatbuffer.toString());
        end();
        super.mgl11.glGetLightfv(i, j, floatbuffer);
        checkError();
    }

    public void glGetLightfv(int i, int j, float af[], int k) {
        begin("glGetLightfv");
        arg("light", i);
        arg("pname", j);
        arg("params", af.toString());
        arg("offset", k);
        end();
        super.mgl11.glGetLightfv(i, j, af, k);
        checkError();
    }

    public void glGetLightxv(int i, int j, IntBuffer intbuffer) {
        begin("glGetLightxv");
        arg("light", i);
        arg("pname", j);
        arg("params", intbuffer.toString());
        end();
        super.mgl11.glGetLightxv(i, j, intbuffer);
        checkError();
    }

    public void glGetLightxv(int i, int j, int ai[], int k) {
        begin("glGetLightxv");
        arg("light", i);
        arg("pname", j);
        arg("params", ai.toString());
        arg("offset", k);
        end();
        super.mgl11.glGetLightxv(i, j, ai, k);
        checkError();
    }

    public void glGetMaterialfv(int i, int j, FloatBuffer floatbuffer) {
        begin("glGetMaterialfv");
        arg("face", i);
        arg("pname", j);
        arg("params", floatbuffer.toString());
        end();
        super.mgl11.glGetMaterialfv(i, j, floatbuffer);
        checkError();
    }

    public void glGetMaterialfv(int i, int j, float af[], int k) {
        begin("glGetMaterialfv");
        arg("face", i);
        arg("pname", j);
        arg("params", af.toString());
        arg("offset", k);
        end();
        super.mgl11.glGetMaterialfv(i, j, af, k);
        checkError();
    }

    public void glGetMaterialxv(int i, int j, IntBuffer intbuffer) {
        begin("glGetMaterialxv");
        arg("face", i);
        arg("pname", j);
        arg("params", intbuffer.toString());
        end();
        super.mgl11.glGetMaterialxv(i, j, intbuffer);
        checkError();
    }

    public void glGetMaterialxv(int i, int j, int ai[], int k) {
        begin("glGetMaterialxv");
        arg("face", i);
        arg("pname", j);
        arg("params", ai.toString());
        arg("offset", k);
        end();
        super.mgl11.glGetMaterialxv(i, j, ai, k);
        checkError();
    }

    public void glGetPointerv(int i, Buffer abuffer[]) {
        begin("glGetPointerv");
        arg("pname", i);
        arg("params", abuffer.toString());
        end();
        super.mgl11.glGetPointerv(i, abuffer);
        checkError();
    }

    public void glGetRenderbufferParameterivOES(int i, int j, IntBuffer intbuffer) {
        begin("glGetRenderbufferParameterivOES");
        arg("target", i);
        arg("pname", j);
        arg("params", intbuffer.toString());
        end();
        super.mgl11ExtensionPack.glGetRenderbufferParameterivOES(i, j, intbuffer);
        checkError();
    }

    public void glGetRenderbufferParameterivOES(int i, int j, int ai[], int k) {
        begin("glGetRenderbufferParameterivOES");
        arg("target", i);
        arg("pname", j);
        arg("params", ai.toString());
        arg("offset", k);
        end();
        super.mgl11ExtensionPack.glGetRenderbufferParameterivOES(i, j, ai, k);
        checkError();
    }

    public String glGetString(int i) {
        begin("glGetString");
        arg("name", i);
        String s = super.mgl.glGetString(i);
        returns(s);
        checkError();
        return s;
    }

    public void glGetTexEnviv(int i, int j, IntBuffer intbuffer) {
        begin("glGetTexEnviv");
        arg("env", i);
        arg("pname", j);
        arg("params", intbuffer.toString());
        end();
        super.mgl11.glGetTexEnviv(i, j, intbuffer);
        checkError();
    }

    public void glGetTexEnviv(int i, int j, int ai[], int k) {
        begin("glGetTexEnviv");
        arg("env", i);
        arg("pname", j);
        arg("params", ai.toString());
        arg("offset", k);
        end();
        super.mgl11.glGetTexEnviv(i, j, ai, k);
        checkError();
    }

    public void glGetTexEnvxv(int i, int j, IntBuffer intbuffer) {
        begin("glGetTexEnviv");
        arg("env", i);
        arg("pname", j);
        arg("params", intbuffer.toString());
        end();
        super.mgl11.glGetTexEnvxv(i, j, intbuffer);
        checkError();
    }

    public void glGetTexEnvxv(int i, int j, int ai[], int k) {
        begin("glGetTexEnviv");
        arg("env", i);
        arg("pname", j);
        arg("params", ai.toString());
        arg("offset", k);
        end();
        super.mgl11.glGetTexEnviv(i, j, ai, k);
        checkError();
    }

    public void glGetTexGenfv(int i, int j, FloatBuffer floatbuffer) {
        begin("glGetTexGenfv");
        arg("coord", i);
        arg("pname", j);
        arg("params", floatbuffer.toString());
        end();
        super.mgl11ExtensionPack.glGetTexGenfv(i, j, floatbuffer);
        checkError();
    }

    public void glGetTexGenfv(int i, int j, float af[], int k) {
        begin("glGetTexGenfv");
        arg("coord", i);
        arg("pname", j);
        arg("params", af.toString());
        arg("offset", k);
        end();
        super.mgl11ExtensionPack.glGetTexGenfv(i, j, af, k);
        checkError();
    }

    public void glGetTexGeniv(int i, int j, IntBuffer intbuffer) {
        begin("glGetTexGeniv");
        arg("coord", i);
        arg("pname", j);
        arg("params", intbuffer.toString());
        end();
        super.mgl11ExtensionPack.glGetTexGeniv(i, j, intbuffer);
        checkError();
    }

    public void glGetTexGeniv(int i, int j, int ai[], int k) {
        begin("glGetTexGeniv");
        arg("coord", i);
        arg("pname", j);
        arg("params", ai.toString());
        arg("offset", k);
        end();
        super.mgl11ExtensionPack.glGetTexGeniv(i, j, ai, k);
        checkError();
    }

    public void glGetTexGenxv(int i, int j, IntBuffer intbuffer) {
        begin("glGetTexGenxv");
        arg("coord", i);
        arg("pname", j);
        arg("params", intbuffer.toString());
        end();
        super.mgl11ExtensionPack.glGetTexGenxv(i, j, intbuffer);
        checkError();
    }

    public void glGetTexGenxv(int i, int j, int ai[], int k) {
        begin("glGetTexGenxv");
        arg("coord", i);
        arg("pname", j);
        arg("params", ai.toString());
        arg("offset", k);
        end();
        super.mgl11ExtensionPack.glGetTexGenxv(i, j, ai, k);
        checkError();
    }

    public void glGetTexParameterfv(int i, int j, FloatBuffer floatbuffer) {
        begin("glGetTexParameterfv");
        arg("target", i);
        arg("pname", j);
        arg("params", floatbuffer.toString());
        end();
        super.mgl11.glGetTexParameterfv(i, j, floatbuffer);
        checkError();
    }

    public void glGetTexParameterfv(int i, int j, float af[], int k) {
        begin("glGetTexParameterfv");
        arg("target", i);
        arg("pname", j);
        arg("params", af.toString());
        arg("offset", k);
        end();
        super.mgl11.glGetTexParameterfv(i, j, af, k);
        checkError();
    }

    public void glGetTexParameteriv(int i, int j, IntBuffer intbuffer) {
        begin("glGetTexParameteriv");
        arg("target", i);
        arg("pname", j);
        arg("params", intbuffer.toString());
        end();
        super.mgl11.glGetTexParameteriv(i, j, intbuffer);
        checkError();
    }

    public void glGetTexParameteriv(int i, int j, int ai[], int k) {
        begin("glGetTexParameteriv");
        arg("target", i);
        arg("pname", j);
        arg("params", ai.toString());
        arg("offset", k);
        end();
        super.mgl11.glGetTexEnviv(i, j, ai, k);
        checkError();
    }

    public void glGetTexParameterxv(int i, int j, IntBuffer intbuffer) {
        begin("glGetTexParameterxv");
        arg("target", i);
        arg("pname", j);
        arg("params", intbuffer.toString());
        end();
        super.mgl11.glGetTexParameterxv(i, j, intbuffer);
        checkError();
    }

    public void glGetTexParameterxv(int i, int j, int ai[], int k) {
        begin("glGetTexParameterxv");
        arg("target", i);
        arg("pname", j);
        arg("params", ai.toString());
        arg("offset", k);
        end();
        super.mgl11.glGetTexParameterxv(i, j, ai, k);
        checkError();
    }

    public void glHint(int i, int j) {
        begin("glHint");
        arg("target", getHintTarget(i));
        arg("mode", getHintMode(j));
        end();
        super.mgl.glHint(i, j);
        checkError();
    }

    public boolean glIsBuffer(int i) {
        begin("glIsBuffer");
        arg("buffer", i);
        end();
        boolean flag = super.mgl11.glIsBuffer(i);
        checkError();
        return flag;
    }

    public boolean glIsEnabled(int i) {
        begin("glIsEnabled");
        arg("cap", i);
        end();
        boolean flag = super.mgl11.glIsEnabled(i);
        checkError();
        return flag;
    }

    public boolean glIsFramebufferOES(int i) {
        begin("glIsFramebufferOES");
        arg("framebuffer", i);
        end();
        boolean flag = super.mgl11ExtensionPack.glIsFramebufferOES(i);
        checkError();
        return flag;
    }

    public boolean glIsRenderbufferOES(int i) {
        begin("glIsRenderbufferOES");
        arg("renderbuffer", i);
        end();
        super.mgl11ExtensionPack.glIsRenderbufferOES(i);
        checkError();
        return false;
    }

    public boolean glIsTexture(int i) {
        begin("glIsTexture");
        arg("texture", i);
        end();
        boolean flag = super.mgl11.glIsTexture(i);
        checkError();
        return flag;
    }

    public void glLightModelf(int i, float f) {
        begin("glLightModelf");
        arg("pname", getLightModelPName(i));
        arg("param", f);
        end();
        super.mgl.glLightModelf(i, f);
        checkError();
    }

    public void glLightModelfv(int i, FloatBuffer floatbuffer) {
        begin("glLightModelfv");
        arg("pname", getLightModelPName(i));
        arg("params", getLightModelParamCount(i), floatbuffer);
        end();
        super.mgl.glLightModelfv(i, floatbuffer);
        checkError();
    }

    public void glLightModelfv(int i, float af[], int j) {
        begin("glLightModelfv");
        arg("pname", getLightModelPName(i));
        arg("params", getLightModelParamCount(i), af, j);
        arg("offset", j);
        end();
        super.mgl.glLightModelfv(i, af, j);
        checkError();
    }

    public void glLightModelx(int i, int j) {
        begin("glLightModelx");
        arg("pname", getLightModelPName(i));
        arg("param", j);
        end();
        super.mgl.glLightModelx(i, j);
        checkError();
    }

    public void glLightModelxv(int i, IntBuffer intbuffer) {
        begin("glLightModelfv");
        arg("pname", getLightModelPName(i));
        arg("params", getLightModelParamCount(i), intbuffer);
        end();
        super.mgl.glLightModelxv(i, intbuffer);
        checkError();
    }

    public void glLightModelxv(int i, int ai[], int j) {
        begin("glLightModelxv");
        arg("pname", getLightModelPName(i));
        arg("params", getLightModelParamCount(i), ai, j);
        arg("offset", j);
        end();
        super.mgl.glLightModelxv(i, ai, j);
        checkError();
    }

    public void glLightf(int i, int j, float f) {
        begin("glLightf");
        arg("light", getLightName(i));
        arg("pname", getLightPName(j));
        arg("param", f);
        end();
        super.mgl.glLightf(i, j, f);
        checkError();
    }

    public void glLightfv(int i, int j, FloatBuffer floatbuffer) {
        begin("glLightfv");
        arg("light", getLightName(i));
        arg("pname", getLightPName(j));
        arg("params", getLightParamCount(j), floatbuffer);
        end();
        super.mgl.glLightfv(i, j, floatbuffer);
        checkError();
    }

    public void glLightfv(int i, int j, float af[], int k) {
        begin("glLightfv");
        arg("light", getLightName(i));
        arg("pname", getLightPName(j));
        arg("params", getLightParamCount(j), af, k);
        arg("offset", k);
        end();
        super.mgl.glLightfv(i, j, af, k);
        checkError();
    }

    public void glLightx(int i, int j, int k) {
        begin("glLightx");
        arg("light", getLightName(i));
        arg("pname", getLightPName(j));
        arg("param", k);
        end();
        super.mgl.glLightx(i, j, k);
        checkError();
    }

    public void glLightxv(int i, int j, IntBuffer intbuffer) {
        begin("glLightxv");
        arg("light", getLightName(i));
        arg("pname", getLightPName(j));
        arg("params", getLightParamCount(j), intbuffer);
        end();
        super.mgl.glLightxv(i, j, intbuffer);
        checkError();
    }

    public void glLightxv(int i, int j, int ai[], int k) {
        begin("glLightxv");
        arg("light", getLightName(i));
        arg("pname", getLightPName(j));
        arg("params", getLightParamCount(j), ai, k);
        arg("offset", k);
        end();
        super.mgl.glLightxv(i, j, ai, k);
        checkError();
    }

    public void glLineWidth(float f) {
        begin("glLineWidth");
        arg("width", f);
        end();
        super.mgl.glLineWidth(f);
        checkError();
    }

    public void glLineWidthx(int i) {
        begin("glLineWidthx");
        arg("width", i);
        end();
        super.mgl.glLineWidthx(i);
        checkError();
    }

    public void glLoadIdentity() {
        begin("glLoadIdentity");
        end();
        super.mgl.glLoadIdentity();
        checkError();
    }

    public void glLoadMatrixf(FloatBuffer floatbuffer) {
        begin("glLoadMatrixf");
        arg("m", 16, floatbuffer);
        end();
        super.mgl.glLoadMatrixf(floatbuffer);
        checkError();
    }

    public void glLoadMatrixf(float af[], int i) {
        begin("glLoadMatrixf");
        arg("m", 16, af, i);
        arg("offset", i);
        end();
        super.mgl.glLoadMatrixf(af, i);
        checkError();
    }

    public void glLoadMatrixx(IntBuffer intbuffer) {
        begin("glLoadMatrixx");
        arg("m", 16, intbuffer);
        end();
        super.mgl.glLoadMatrixx(intbuffer);
        checkError();
    }

    public void glLoadMatrixx(int ai[], int i) {
        begin("glLoadMatrixx");
        arg("m", 16, ai, i);
        arg("offset", i);
        end();
        super.mgl.glLoadMatrixx(ai, i);
        checkError();
    }

    public void glLoadPaletteFromModelViewMatrixOES() {
        begin("glLoadPaletteFromModelViewMatrixOES");
        end();
        super.mgl11Ext.glLoadPaletteFromModelViewMatrixOES();
        checkError();
    }

    public void glLogicOp(int i) {
        begin("glLogicOp");
        arg("opcode", i);
        end();
        super.mgl.glLogicOp(i);
        checkError();
    }

    public void glMaterialf(int i, int j, float f) {
        begin("glMaterialf");
        arg("face", getFaceName(i));
        arg("pname", getMaterialPName(j));
        arg("param", f);
        end();
        super.mgl.glMaterialf(i, j, f);
        checkError();
    }

    public void glMaterialfv(int i, int j, FloatBuffer floatbuffer) {
        begin("glMaterialfv");
        arg("face", getFaceName(i));
        arg("pname", getMaterialPName(j));
        arg("params", getMaterialParamCount(j), floatbuffer);
        end();
        super.mgl.glMaterialfv(i, j, floatbuffer);
        checkError();
    }

    public void glMaterialfv(int i, int j, float af[], int k) {
        begin("glMaterialfv");
        arg("face", getFaceName(i));
        arg("pname", getMaterialPName(j));
        arg("params", getMaterialParamCount(j), af, k);
        arg("offset", k);
        end();
        super.mgl.glMaterialfv(i, j, af, k);
        checkError();
    }

    public void glMaterialx(int i, int j, int k) {
        begin("glMaterialx");
        arg("face", getFaceName(i));
        arg("pname", getMaterialPName(j));
        arg("param", k);
        end();
        super.mgl.glMaterialx(i, j, k);
        checkError();
    }

    public void glMaterialxv(int i, int j, IntBuffer intbuffer) {
        begin("glMaterialxv");
        arg("face", getFaceName(i));
        arg("pname", getMaterialPName(j));
        arg("params", getMaterialParamCount(j), intbuffer);
        end();
        super.mgl.glMaterialxv(i, j, intbuffer);
        checkError();
    }

    public void glMaterialxv(int i, int j, int ai[], int k) {
        begin("glMaterialxv");
        arg("face", getFaceName(i));
        arg("pname", getMaterialPName(j));
        arg("params", getMaterialParamCount(j), ai, k);
        arg("offset", k);
        end();
        super.mgl.glMaterialxv(i, j, ai, k);
        checkError();
    }

    public void glMatrixIndexPointerOES(int i, int j, int k, int l) {
        begin("glMatrixIndexPointerOES");
        arg("size", i);
        arg("type", j);
        arg("stride", k);
        arg("offset", l);
        end();
        super.mgl11Ext.glMatrixIndexPointerOES(i, j, k, l);
        checkError();
    }

    public void glMatrixIndexPointerOES(int i, int j, int k, Buffer buffer) {
        begin("glMatrixIndexPointerOES");
        argPointer(i, j, k, buffer);
        end();
        super.mgl11Ext.glMatrixIndexPointerOES(i, j, k, buffer);
        checkError();
    }

    public void glMatrixMode(int i) {
        begin("glMatrixMode");
        arg("mode", getMatrixMode(i));
        end();
        super.mgl.glMatrixMode(i);
        checkError();
    }

    public void glMultMatrixf(FloatBuffer floatbuffer) {
        begin("glMultMatrixf");
        arg("m", 16, floatbuffer);
        end();
        super.mgl.glMultMatrixf(floatbuffer);
        checkError();
    }

    public void glMultMatrixf(float af[], int i) {
        begin("glMultMatrixf");
        arg("m", 16, af, i);
        arg("offset", i);
        end();
        super.mgl.glMultMatrixf(af, i);
        checkError();
    }

    public void glMultMatrixx(IntBuffer intbuffer) {
        begin("glMultMatrixx");
        arg("m", 16, intbuffer);
        end();
        super.mgl.glMultMatrixx(intbuffer);
        checkError();
    }

    public void glMultMatrixx(int ai[], int i) {
        begin("glMultMatrixx");
        arg("m", 16, ai, i);
        arg("offset", i);
        end();
        super.mgl.glMultMatrixx(ai, i);
        checkError();
    }

    public void glMultiTexCoord4f(int i, float f, float f1, float f2, float f3) {
        begin("glMultiTexCoord4f");
        arg("target", i);
        arg("s", f);
        arg("t", f1);
        arg("r", f2);
        arg("q", f3);
        end();
        super.mgl.glMultiTexCoord4f(i, f, f1, f2, f3);
        checkError();
    }

    public void glMultiTexCoord4x(int i, int j, int k, int l, int i1) {
        begin("glMultiTexCoord4x");
        arg("target", i);
        arg("s", j);
        arg("t", k);
        arg("r", l);
        arg("q", i1);
        end();
        super.mgl.glMultiTexCoord4x(i, j, k, l, i1);
        checkError();
    }

    public void glNormal3f(float f, float f1, float f2) {
        begin("glNormal3f");
        arg("nx", f);
        arg("ny", f1);
        arg("nz", f2);
        end();
        super.mgl.glNormal3f(f, f1, f2);
        checkError();
    }

    public void glNormal3x(int i, int j, int k) {
        begin("glNormal3x");
        arg("nx", i);
        arg("ny", j);
        arg("nz", k);
        end();
        super.mgl.glNormal3x(i, j, k);
        checkError();
    }

    public void glNormalPointer(int i, int j, int k) {
        begin("glNormalPointer");
        arg("type", i);
        arg("stride", j);
        arg("offset", k);
        end();
        super.mgl11.glNormalPointer(i, j, k);
    }

    public void glNormalPointer(int i, int j, Buffer buffer) {
        begin("glNormalPointer");
        arg("type", i);
        arg("stride", j);
        arg("pointer", buffer.toString());
        end();
        mNormalPointer = new PointerInfo(3, i, j, buffer);
        super.mgl.glNormalPointer(i, j, buffer);
        checkError();
    }

    public void glOrthof(float f, float f1, float f2, float f3, float f4, float f5) {
        begin("glOrthof");
        arg("left", f);
        arg("right", f1);
        arg("bottom", f2);
        arg("top", f3);
        arg("near", f4);
        arg("far", f5);
        end();
        super.mgl.glOrthof(f, f1, f2, f3, f4, f5);
        checkError();
    }

    public void glOrthox(int i, int j, int k, int l, int i1, int j1) {
        begin("glOrthox");
        arg("left", i);
        arg("right", j);
        arg("bottom", k);
        arg("top", l);
        arg("near", i1);
        arg("far", j1);
        end();
        super.mgl.glOrthox(i, j, k, l, i1, j1);
        checkError();
    }

    public void glPixelStorei(int i, int j) {
        begin("glPixelStorei");
        arg("pname", i);
        arg("param", j);
        end();
        super.mgl.glPixelStorei(i, j);
        checkError();
    }

    public void glPointParameterf(int i, float f) {
        begin("glPointParameterf");
        arg("pname", i);
        arg("param", f);
        end();
        super.mgl11.glPointParameterf(i, f);
        checkError();
    }

    public void glPointParameterfv(int i, FloatBuffer floatbuffer) {
        begin("glPointParameterfv");
        arg("pname", i);
        arg("params", floatbuffer.toString());
        end();
        super.mgl11.glPointParameterfv(i, floatbuffer);
        checkError();
    }

    public void glPointParameterfv(int i, float af[], int j) {
        begin("glPointParameterfv");
        arg("pname", i);
        arg("params", af.toString());
        arg("offset", j);
        end();
        super.mgl11.glPointParameterfv(i, af, j);
        checkError();
    }

    public void glPointParameterx(int i, int j) {
        begin("glPointParameterfv");
        arg("pname", i);
        arg("param", j);
        end();
        super.mgl11.glPointParameterx(i, j);
        checkError();
    }

    public void glPointParameterxv(int i, IntBuffer intbuffer) {
        begin("glPointParameterxv");
        arg("pname", i);
        arg("params", intbuffer.toString());
        end();
        super.mgl11.glPointParameterxv(i, intbuffer);
        checkError();
    }

    public void glPointParameterxv(int i, int ai[], int j) {
        begin("glPointParameterxv");
        arg("pname", i);
        arg("params", ai.toString());
        arg("offset", j);
        end();
        super.mgl11.glPointParameterxv(i, ai, j);
        checkError();
    }

    public void glPointSize(float f) {
        begin("glPointSize");
        arg("size", f);
        end();
        super.mgl.glPointSize(f);
        checkError();
    }

    public void glPointSizePointerOES(int i, int j, Buffer buffer) {
        begin("glPointSizePointerOES");
        arg("type", i);
        arg("stride", j);
        arg("params", buffer.toString());
        end();
        super.mgl11.glPointSizePointerOES(i, j, buffer);
        checkError();
    }

    public void glPointSizex(int i) {
        begin("glPointSizex");
        arg("size", i);
        end();
        super.mgl.glPointSizex(i);
        checkError();
    }

    public void glPolygonOffset(float f, float f1) {
        begin("glPolygonOffset");
        arg("factor", f);
        arg("units", f1);
        end();
        super.mgl.glPolygonOffset(f, f1);
        checkError();
    }

    public void glPolygonOffsetx(int i, int j) {
        begin("glPolygonOffsetx");
        arg("factor", i);
        arg("units", j);
        end();
        super.mgl.glPolygonOffsetx(i, j);
        checkError();
    }

    public void glPopMatrix() {
        begin("glPopMatrix");
        end();
        super.mgl.glPopMatrix();
        checkError();
    }

    public void glPushMatrix() {
        begin("glPushMatrix");
        end();
        super.mgl.glPushMatrix();
        checkError();
    }

    public int glQueryMatrixxOES(IntBuffer intbuffer, IntBuffer intbuffer1) {
        begin("glQueryMatrixxOES");
        arg("mantissa", intbuffer.toString());
        arg("exponent", intbuffer1.toString());
        end();
        int i = super.mgl10Ext.glQueryMatrixxOES(intbuffer, intbuffer1);
        returns(toString(16, 2, intbuffer));
        returns(toString(16, 0, intbuffer1));
        checkError();
        return i;
    }

    public int glQueryMatrixxOES(int ai[], int i, int ai1[], int j) {
        begin("glQueryMatrixxOES");
        arg("mantissa", Arrays.toString(ai));
        arg("exponent", Arrays.toString(ai1));
        end();
        int k = super.mgl10Ext.glQueryMatrixxOES(ai, i, ai1, j);
        returns(toString(16, 2, ai, i));
        returns(toString(16, 0, ai1, j));
        checkError();
        return k;
    }

    public void glReadPixels(int i, int j, int k, int l, int i1, int j1, Buffer buffer) {
        begin("glReadPixels");
        arg("x", i);
        arg("y", j);
        arg("width", k);
        arg("height", l);
        arg("format", i1);
        arg("type", j1);
        arg("pixels", buffer.toString());
        end();
        super.mgl.glReadPixels(i, j, k, l, i1, j1, buffer);
        checkError();
    }

    public void glRenderbufferStorageOES(int i, int j, int k, int l) {
        begin("glRenderbufferStorageOES");
        arg("target", i);
        arg("internalformat", j);
        arg("width", k);
        arg("height", l);
        end();
        super.mgl11ExtensionPack.glRenderbufferStorageOES(i, j, k, l);
        checkError();
    }

    public void glRotatef(float f, float f1, float f2, float f3) {
        begin("glRotatef");
        arg("angle", f);
        arg("x", f1);
        arg("y", f2);
        arg("z", f3);
        end();
        super.mgl.glRotatef(f, f1, f2, f3);
        checkError();
    }

    public void glRotatex(int i, int j, int k, int l) {
        begin("glRotatex");
        arg("angle", i);
        arg("x", j);
        arg("y", k);
        arg("z", l);
        end();
        super.mgl.glRotatex(i, j, k, l);
        checkError();
    }

    public void glSampleCoverage(float f, boolean flag) {
        begin("glSampleCoveragex");
        arg("value", f);
        arg("invert", flag);
        end();
        super.mgl.glSampleCoverage(f, flag);
        checkError();
    }

    public void glSampleCoveragex(int i, boolean flag) {
        begin("glSampleCoveragex");
        arg("value", i);
        arg("invert", flag);
        end();
        super.mgl.glSampleCoveragex(i, flag);
        checkError();
    }

    public void glScalef(float f, float f1, float f2) {
        begin("glScalef");
        arg("x", f);
        arg("y", f1);
        arg("z", f2);
        end();
        super.mgl.glScalef(f, f1, f2);
        checkError();
    }

    public void glScalex(int i, int j, int k) {
        begin("glScalex");
        arg("x", i);
        arg("y", j);
        arg("z", k);
        end();
        super.mgl.glScalex(i, j, k);
        checkError();
    }

    public void glScissor(int i, int j, int k, int l) {
        begin("glScissor");
        arg("x", i);
        arg("y", j);
        arg("width", k);
        arg("height", l);
        end();
        super.mgl.glScissor(i, j, k, l);
        checkError();
    }

    public void glShadeModel(int i) {
        begin("glShadeModel");
        arg("mode", getShadeModel(i));
        end();
        super.mgl.glShadeModel(i);
        checkError();
    }

    public void glStencilFunc(int i, int j, int k) {
        begin("glStencilFunc");
        arg("func", i);
        arg("ref", j);
        arg("mask", k);
        end();
        super.mgl.glStencilFunc(i, j, k);
        checkError();
    }

    public void glStencilMask(int i) {
        begin("glStencilMask");
        arg("mask", i);
        end();
        super.mgl.glStencilMask(i);
        checkError();
    }

    public void glStencilOp(int i, int j, int k) {
        begin("glStencilOp");
        arg("fail", i);
        arg("zfail", j);
        arg("zpass", k);
        end();
        super.mgl.glStencilOp(i, j, k);
        checkError();
    }

    public void glTexCoordPointer(int i, int j, int k, int l) {
        begin("glTexCoordPointer");
        arg("size", i);
        arg("type", j);
        arg("stride", k);
        arg("offset", l);
        end();
        super.mgl11.glTexCoordPointer(i, j, k, l);
    }

    public void glTexCoordPointer(int i, int j, int k, Buffer buffer) {
        begin("glTexCoordPointer");
        argPointer(i, j, k, buffer);
        end();
        mTexCoordPointer = new PointerInfo(i, j, k, buffer);
        super.mgl.glTexCoordPointer(i, j, k, buffer);
        checkError();
    }

    public void glTexEnvf(int i, int j, float f) {
        begin("glTexEnvf");
        arg("target", getTextureEnvTarget(i));
        arg("pname", getTextureEnvPName(j));
        arg("param", getTextureEnvParamName(f));
        end();
        super.mgl.glTexEnvf(i, j, f);
        checkError();
    }

    public void glTexEnvfv(int i, int j, FloatBuffer floatbuffer) {
        begin("glTexEnvfv");
        arg("target", getTextureEnvTarget(i));
        arg("pname", getTextureEnvPName(j));
        arg("params", getTextureEnvParamCount(j), floatbuffer);
        end();
        super.mgl.glTexEnvfv(i, j, floatbuffer);
        checkError();
    }

    public void glTexEnvfv(int i, int j, float af[], int k) {
        begin("glTexEnvfv");
        arg("target", getTextureEnvTarget(i));
        arg("pname", getTextureEnvPName(j));
        arg("params", getTextureEnvParamCount(j), af, k);
        arg("offset", k);
        end();
        super.mgl.glTexEnvfv(i, j, af, k);
        checkError();
    }

    public void glTexEnvi(int i, int j, int k) {
        begin("glTexEnvi");
        arg("target", i);
        arg("pname", j);
        arg("param", k);
        end();
        super.mgl11.glTexEnvi(i, j, k);
        checkError();
    }

    public void glTexEnviv(int i, int j, IntBuffer intbuffer) {
        begin("glTexEnviv");
        arg("target", i);
        arg("pname", j);
        arg("params", intbuffer.toString());
        end();
        super.mgl11.glTexEnviv(i, j, intbuffer);
        checkError();
    }

    public void glTexEnviv(int i, int j, int ai[], int k) {
        begin("glTexEnviv");
        arg("target", i);
        arg("pname", j);
        arg("params", ai.toString());
        arg("offset", k);
        end();
        super.mgl11.glTexEnviv(i, j, ai, k);
        checkError();
    }

    public void glTexEnvx(int i, int j, int k) {
        begin("glTexEnvx");
        arg("target", getTextureEnvTarget(i));
        arg("pname", getTextureEnvPName(j));
        arg("param", k);
        end();
        super.mgl.glTexEnvx(i, j, k);
        checkError();
    }

    public void glTexEnvxv(int i, int j, IntBuffer intbuffer) {
        begin("glTexEnvxv");
        arg("target", getTextureEnvTarget(i));
        arg("pname", getTextureEnvPName(j));
        arg("params", getTextureEnvParamCount(j), intbuffer);
        end();
        super.mgl.glTexEnvxv(i, j, intbuffer);
        checkError();
    }

    public void glTexEnvxv(int i, int j, int ai[], int k) {
        begin("glTexEnvxv");
        arg("target", getTextureEnvTarget(i));
        arg("pname", getTextureEnvPName(j));
        arg("params", getTextureEnvParamCount(j), ai, k);
        arg("offset", k);
        end();
        super.mgl.glTexEnvxv(i, j, ai, k);
        checkError();
    }

    public void glTexGenf(int i, int j, float f) {
        begin("glTexGenf");
        arg("coord", i);
        arg("pname", j);
        arg("param", f);
        end();
        super.mgl11ExtensionPack.glTexGenf(i, j, f);
        checkError();
    }

    public void glTexGenfv(int i, int j, FloatBuffer floatbuffer) {
        begin("glTexGenfv");
        arg("coord", i);
        arg("pname", j);
        arg("params", floatbuffer.toString());
        end();
        super.mgl11ExtensionPack.glTexGenfv(i, j, floatbuffer);
        checkError();
    }

    public void glTexGenfv(int i, int j, float af[], int k) {
        begin("glTexGenfv");
        arg("coord", i);
        arg("pname", j);
        arg("params", af.toString());
        arg("offset", k);
        end();
        super.mgl11ExtensionPack.glTexGenfv(i, j, af, k);
        checkError();
    }

    public void glTexGeni(int i, int j, int k) {
        begin("glTexGeni");
        arg("coord", i);
        arg("pname", j);
        arg("param", k);
        end();
        super.mgl11ExtensionPack.glTexGeni(i, j, k);
        checkError();
    }

    public void glTexGeniv(int i, int j, IntBuffer intbuffer) {
        begin("glTexGeniv");
        arg("coord", i);
        arg("pname", j);
        arg("params", intbuffer.toString());
        end();
        super.mgl11ExtensionPack.glTexGeniv(i, j, intbuffer);
        checkError();
    }

    public void glTexGeniv(int i, int j, int ai[], int k) {
        begin("glTexGeniv");
        arg("coord", i);
        arg("pname", j);
        arg("params", ai.toString());
        arg("offset", k);
        end();
        super.mgl11ExtensionPack.glTexGeniv(i, j, ai, k);
        checkError();
    }

    public void glTexGenx(int i, int j, int k) {
        begin("glTexGenx");
        arg("coord", i);
        arg("pname", j);
        arg("param", k);
        end();
        super.mgl11ExtensionPack.glTexGenx(i, j, k);
        checkError();
    }

    public void glTexGenxv(int i, int j, IntBuffer intbuffer) {
        begin("glTexGenxv");
        arg("coord", i);
        arg("pname", j);
        arg("params", intbuffer.toString());
        end();
        super.mgl11ExtensionPack.glTexGenxv(i, j, intbuffer);
        checkError();
    }

    public void glTexGenxv(int i, int j, int ai[], int k) {
        begin("glTexGenxv");
        arg("coord", i);
        arg("pname", j);
        arg("params", ai.toString());
        arg("offset", k);
        end();
        super.mgl11ExtensionPack.glTexGenxv(i, j, ai, k);
        checkError();
    }

    public void glTexImage2D(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, Buffer buffer) {
        begin("glTexImage2D");
        arg("target", i);
        arg("level", j);
        arg("internalformat", k);
        arg("width", l);
        arg("height", i1);
        arg("border", j1);
        arg("format", k1);
        arg("type", l1);
        arg("pixels", buffer.toString());
        end();
        super.mgl.glTexImage2D(i, j, k, l, i1, j1, k1, l1, buffer);
        checkError();
    }

    public void glTexParameterf(int i, int j, float f) {
        begin("glTexParameterf");
        arg("target", getTextureTarget(i));
        arg("pname", getTexturePName(j));
        arg("param", getTextureParamName(f));
        end();
        super.mgl.glTexParameterf(i, j, f);
        checkError();
    }

    public void glTexParameterfv(int i, int j, FloatBuffer floatbuffer) {
        begin("glTexParameterfv");
        arg("target", i);
        arg("pname", j);
        arg("params", floatbuffer.toString());
        end();
        super.mgl11.glTexParameterfv(i, j, floatbuffer);
        checkError();
    }

    public void glTexParameterfv(int i, int j, float af[], int k) {
        begin("glTexParameterfv");
        arg("target", i);
        arg("pname", j);
        arg("params", af.toString());
        arg("offset", k);
        end();
        super.mgl11.glTexParameterfv(i, j, af, k);
        checkError();
    }

    public void glTexParameteri(int i, int j, int k) {
        begin("glTexParameterxv");
        arg("target", i);
        arg("pname", j);
        arg("param", k);
        end();
        super.mgl11.glTexParameteri(i, j, k);
        checkError();
    }

    public void glTexParameteriv(int i, int j, IntBuffer intbuffer) {
        begin("glTexParameteriv");
        arg("target", getTextureTarget(i));
        arg("pname", getTexturePName(j));
        arg("params", 4, intbuffer);
        end();
        super.mgl11.glTexParameteriv(i, j, intbuffer);
        checkError();
    }

    public void glTexParameteriv(int i, int j, int ai[], int k) {
        begin("glTexParameteriv");
        arg("target", getTextureTarget(i));
        arg("pname", getTexturePName(j));
        arg("params", 4, ai, k);
        end();
        super.mgl11.glTexParameteriv(i, j, ai, k);
        checkError();
    }

    public void glTexParameterx(int i, int j, int k) {
        begin("glTexParameterx");
        arg("target", getTextureTarget(i));
        arg("pname", getTexturePName(j));
        arg("param", k);
        end();
        super.mgl.glTexParameterx(i, j, k);
        checkError();
    }

    public void glTexParameterxv(int i, int j, IntBuffer intbuffer) {
        begin("glTexParameterxv");
        arg("target", i);
        arg("pname", j);
        arg("params", intbuffer.toString());
        end();
        super.mgl11.glTexParameterxv(i, j, intbuffer);
        checkError();
    }

    public void glTexParameterxv(int i, int j, int ai[], int k) {
        begin("glTexParameterxv");
        arg("target", i);
        arg("pname", j);
        arg("params", ai.toString());
        arg("offset", k);
        end();
        super.mgl11.glTexParameterxv(i, j, ai, k);
        checkError();
    }

    public void glTexSubImage2D(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, Buffer buffer) {
        begin("glTexSubImage2D");
        arg("target", getTextureTarget(i));
        arg("level", j);
        arg("xoffset", k);
        arg("yoffset", l);
        arg("width", i1);
        arg("height", j1);
        arg("format", k1);
        arg("type", l1);
        arg("pixels", buffer.toString());
        end();
        super.mgl.glTexSubImage2D(i, j, k, l, i1, j1, k1, l1, buffer);
        checkError();
    }

    public void glTranslatef(float f, float f1, float f2) {
        begin("glTranslatef");
        arg("x", f);
        arg("y", f1);
        arg("z", f2);
        end();
        super.mgl.glTranslatef(f, f1, f2);
        checkError();
    }

    public void glTranslatex(int i, int j, int k) {
        begin("glTranslatex");
        arg("x", i);
        arg("y", j);
        arg("z", k);
        end();
        super.mgl.glTranslatex(i, j, k);
        checkError();
    }

    public void glVertexPointer(int i, int j, int k, int l) {
        begin("glVertexPointer");
        arg("size", i);
        arg("type", j);
        arg("stride", k);
        arg("offset", l);
        end();
        super.mgl11.glVertexPointer(i, j, k, l);
    }

    public void glVertexPointer(int i, int j, int k, Buffer buffer) {
        begin("glVertexPointer");
        argPointer(i, j, k, buffer);
        end();
        mVertexPointer = new PointerInfo(i, j, k, buffer);
        super.mgl.glVertexPointer(i, j, k, buffer);
        checkError();
    }

    public void glViewport(int i, int j, int k, int l) {
        begin("glViewport");
        arg("x", i);
        arg("y", j);
        arg("width", k);
        arg("height", l);
        end();
        super.mgl.glViewport(i, j, k, l);
        checkError();
    }

    public void glWeightPointerOES(int i, int j, int k, int l) {
        begin("glWeightPointerOES");
        arg("size", i);
        arg("type", j);
        arg("stride", k);
        arg("offset", l);
        end();
        super.mgl11Ext.glWeightPointerOES(i, j, k, l);
        checkError();
    }

    public void glWeightPointerOES(int i, int j, int k, Buffer buffer) {
        begin("glWeightPointerOES");
        argPointer(i, j, k, buffer);
        end();
        super.mgl11Ext.glWeightPointerOES(i, j, k, buffer);
        checkError();
    }

    private static final int FORMAT_FIXED = 2;
    private static final int FORMAT_FLOAT = 1;
    private static final int FORMAT_INT;
    private int mArgCount;
    boolean mColorArrayEnabled;
    private PointerInfo mColorPointer;
    private Writer mLog;
    private boolean mLogArgumentNames;
    boolean mNormalArrayEnabled;
    private PointerInfo mNormalPointer;
    StringBuilder mStringBuilder;
    private PointerInfo mTexCoordPointer;
    boolean mTextureCoordArrayEnabled;
    boolean mVertexArrayEnabled;
    private PointerInfo mVertexPointer;

}

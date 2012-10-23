// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.opengl;

import java.nio.Buffer;

public class ETC1 {

    public ETC1() {
    }

    public static native void decodeBlock(Buffer buffer, Buffer buffer1);

    public static native void decodeImage(Buffer buffer, Buffer buffer1, int i, int j, int k, int l);

    public static native void encodeBlock(Buffer buffer, int i, Buffer buffer1);

    public static native void encodeImage(Buffer buffer, int i, int j, int k, int l, Buffer buffer1);

    public static native void formatHeader(Buffer buffer, int i, int j);

    public static native int getEncodedDataSize(int i, int j);

    public static native int getHeight(Buffer buffer);

    public static native int getWidth(Buffer buffer);

    public static native boolean isValid(Buffer buffer);

    public static final int DECODED_BLOCK_SIZE = 48;
    public static final int ENCODED_BLOCK_SIZE = 8;
    public static final int ETC1_RGB8_OES = 36196;
    public static final int ETC_PKM_HEADER_SIZE = 16;
}

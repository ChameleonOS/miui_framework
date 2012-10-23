// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text;


public class AndroidCharacter {

    public AndroidCharacter() {
    }

    public static native void getDirectionalities(char ac[], byte abyte0[], int i);

    public static native int getEastAsianWidth(char c);

    public static native void getEastAsianWidths(char ac[], int i, int j, byte abyte0[]);

    public static native char getMirror(char c);

    public static native boolean mirror(char ac[], int i, int j);

    public static final int EAST_ASIAN_WIDTH_AMBIGUOUS = 1;
    public static final int EAST_ASIAN_WIDTH_FULL_WIDTH = 3;
    public static final int EAST_ASIAN_WIDTH_HALF_WIDTH = 2;
    public static final int EAST_ASIAN_WIDTH_NARROW = 4;
    public static final int EAST_ASIAN_WIDTH_NEUTRAL = 0;
    public static final int EAST_ASIAN_WIDTH_WIDE = 5;
}

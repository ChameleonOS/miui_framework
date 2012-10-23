// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.debug;

import java.io.PrintStream;

public class JNITest {

    public JNITest() {
    }

    private native int part1(int i, double d, String s, int ai[]);

    private int part2(double d, int i, String s) {
        System.out.println((new StringBuilder()).append(s).append(" : ").append((float)d).append(" : ").append(i).toString());
        return 6 + part3(s);
    }

    private static native int part3(String s);

    public int test(int i, double d, String s) {
        int ai[] = new int[4];
        ai[0] = 42;
        ai[1] = 53;
        ai[2] = 65;
        ai[3] = 127;
        return part1(i, d, s, ai);
    }
}

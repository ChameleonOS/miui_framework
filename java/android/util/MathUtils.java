// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;

import java.util.Random;

public final class MathUtils {

    private MathUtils() {
    }

    public static float abs(float f) {
        if(f <= 0.0F)
            f = -f;
        return f;
    }

    public static float acos(float f) {
        return (float)Math.acos(f);
    }

    public static float asin(float f) {
        return (float)Math.asin(f);
    }

    public static float atan(float f) {
        return (float)Math.atan(f);
    }

    public static float atan2(float f, float f1) {
        return (float)Math.atan2(f, f1);
    }

    public static float constrain(float f, float f1, float f2) {
        if(f >= f1)
            if(f > f2)
                f1 = f2;
            else
                f1 = f;
        return f1;
    }

    public static int constrain(int i, int j, int k) {
        if(i >= j)
            if(i > k)
                j = k;
            else
                j = i;
        return j;
    }

    public static long constrain(long l, long l1, long l2) {
        if(l >= l1)
            if(l > l2)
                l1 = l2;
            else
                l1 = l;
        return l1;
    }

    public static float degrees(float f) {
        return 57.29578F * f;
    }

    public static float dist(float f, float f1, float f2, float f3) {
        float f4 = f2 - f;
        float f5 = f3 - f1;
        return (float)Math.sqrt(f4 * f4 + f5 * f5);
    }

    public static float dist(float f, float f1, float f2, float f3, float f4, float f5) {
        float f6 = f3 - f;
        float f7 = f4 - f1;
        float f8 = f5 - f2;
        return (float)Math.sqrt(f6 * f6 + f7 * f7 + f8 * f8);
    }

    public static float exp(float f) {
        return (float)Math.exp(f);
    }

    public static float lerp(float f, float f1, float f2) {
        return f + f2 * (f1 - f);
    }

    public static float log(float f) {
        return (float)Math.log(f);
    }

    public static float mag(float f, float f1) {
        return (float)Math.sqrt(f * f + f1 * f1);
    }

    public static float mag(float f, float f1, float f2) {
        return (float)Math.sqrt(f * f + f1 * f1 + f2 * f2);
    }

    public static float map(float f, float f1, float f2, float f3, float f4) {
        return f2 + (f2 - f3) * ((f4 - f) / (f1 - f));
    }

    public static float max(float f, float f1) {
        if(f <= f1)
            f = f1;
        return f;
    }

    public static float max(float f, float f1, float f2) {
        if(f <= f1) goto _L2; else goto _L1
_L1:
        if(f > f2)
            f2 = f;
_L4:
        return f2;
_L2:
        if(f1 > f2)
            f2 = f1;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static float max(int i, int j) {
        float f;
        if(i > j)
            f = i;
        else
            f = j;
        return f;
    }

    public static float max(int i, int j, int k) {
        float f;
        if(i > j) {
            if(i <= k)
                i = k;
            f = i;
        } else {
            if(j <= k)
                j = k;
            f = j;
        }
        return f;
    }

    public static float min(float f, float f1) {
        if(f >= f1)
            f = f1;
        return f;
    }

    public static float min(float f, float f1, float f2) {
        if(f >= f1) goto _L2; else goto _L1
_L1:
        if(f < f2)
            f2 = f;
_L4:
        return f2;
_L2:
        if(f1 < f2)
            f2 = f1;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static float min(int i, int j) {
        float f;
        if(i < j)
            f = i;
        else
            f = j;
        return f;
    }

    public static float min(int i, int j, int k) {
        float f;
        if(i < j) {
            if(i >= k)
                i = k;
            f = i;
        } else {
            if(j >= k)
                j = k;
            f = j;
        }
        return f;
    }

    public static float norm(float f, float f1, float f2) {
        return (f2 - f) / (f1 - f);
    }

    public static float pow(float f, float f1) {
        return (float)Math.pow(f, f1);
    }

    public static float radians(float f) {
        return 0.01745329F * f;
    }

    public static float random(float f) {
        return f * sRandom.nextFloat();
    }

    public static float random(float f, float f1) {
        if(f < f1)
            f += sRandom.nextFloat() * (f1 - f);
        return f;
    }

    public static int random(int i) {
        return (int)(sRandom.nextFloat() * (float)i);
    }

    public static int random(int i, int j) {
        if(i < j)
            i = (int)(sRandom.nextFloat() * (float)(j - i) + (float)i);
        return i;
    }

    public static void randomSeed(long l) {
        sRandom.setSeed(l);
    }

    public static float sq(float f) {
        return f * f;
    }

    public static float tan(float f) {
        return (float)Math.tan(f);
    }

    private static final float DEG_TO_RAD = 0.01745329F;
    private static final float RAD_TO_DEG = 57.29578F;
    private static final Random sRandom = new Random();

}

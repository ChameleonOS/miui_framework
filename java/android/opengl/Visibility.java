// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.opengl;


public class Visibility {

    public Visibility() {
    }

    public static native void computeBoundingSphere(float af[], int i, int j, float af1[], int k);

    public static native int frustumCullSpheres(float af[], int i, float af1[], int j, int k, int ai[], int l, int i1);

    public static native int visibilityTest(float af[], int i, float af1[], int j, char ac[], int k, int l);
}

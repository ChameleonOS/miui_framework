// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.drm.mobile1;

import java.io.PrintStream;

// Referenced classes of package android.drm.mobile1:
//            DrmConstraintInfo

public class DrmRights {

    public DrmRights() {
        roId = "";
    }

    private native int nativeConsumeRights(int i);

    private native int nativeGetConstraintInfo(int i, DrmConstraintInfo drmconstraintinfo);

    public boolean consumeRights(int i) {
        boolean flag;
        if(-1 == nativeConsumeRights(i))
            flag = false;
        else
            flag = true;
        return flag;
    }

    public DrmConstraintInfo getConstraint(int i) {
        DrmConstraintInfo drmconstraintinfo = new DrmConstraintInfo();
        if(-1 == nativeGetConstraintInfo(i, drmconstraintinfo))
            drmconstraintinfo = null;
        return drmconstraintinfo;
    }

    public static final int DRM_PERMISSION_DISPLAY = 2;
    public static final int DRM_PERMISSION_EXECUTE = 3;
    public static final int DRM_PERMISSION_PLAY = 1;
    public static final int DRM_PERMISSION_PRINT = 4;
    private static final int JNI_DRM_FAILURE = -1;
    private static final int JNI_DRM_SUCCESS;
    private String roId;

    static  {
        System.loadLibrary("drm1_jni");
_L1:
        return;
        UnsatisfiedLinkError unsatisfiedlinkerror;
        unsatisfiedlinkerror;
        System.err.println("WARNING: Could not load libdrm1_jni.so");
          goto _L1
    }
}

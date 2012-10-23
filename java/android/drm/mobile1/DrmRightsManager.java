// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.drm.mobile1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.drm.mobile1:
//            DrmRights, DrmException, DrmRawContent

public class DrmRightsManager {

    protected DrmRightsManager() {
    }

    /**
     * @deprecated Method getInstance is deprecated
     */

    public static DrmRightsManager getInstance() {
        android/drm/mobile1/DrmRightsManager;
        JVM INSTR monitorenter ;
        DrmRightsManager drmrightsmanager;
        if(singleton == null)
            singleton = new DrmRightsManager();
        drmrightsmanager = singleton;
        android/drm/mobile1/DrmRightsManager;
        JVM INSTR monitorexit ;
        return drmrightsmanager;
        Exception exception;
        exception;
        throw exception;
    }

    private native int nativeDeleteRights(DrmRights drmrights);

    private native int nativeGetNumOfRights();

    private native int nativeGetRightsList(DrmRights adrmrights[], int i);

    private native int nativeInstallDrmRights(InputStream inputstream, int i, int j, DrmRights drmrights);

    private native int nativeQueryRights(DrmRawContent drmrawcontent, DrmRights drmrights);

    /**
     * @deprecated Method deleteRights is deprecated
     */

    public void deleteRights(DrmRights drmrights) {
        this;
        JVM INSTR monitorenter ;
        int i = nativeDeleteRights(drmrights);
        if(-1 != i);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getRightsList is deprecated
     */

    public List getRightsList() {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        int i;
        arraylist = new ArrayList();
        i = nativeGetNumOfRights();
        if(-1 != i) goto _L2; else goto _L1
_L1:
        arraylist = null;
_L6:
        this;
        JVM INSTR monitorexit ;
        return arraylist;
_L2:
        if(i <= 0)
            continue; /* Loop/switch isn't completed */
        DrmRights adrmrights[];
        int k;
        adrmrights = new DrmRights[i];
        for(int j = 0; j < i; j++)
            adrmrights[j] = new DrmRights();

        k = nativeGetRightsList(adrmrights, i);
        if(-1 != k)
            break MISSING_BLOCK_LABEL_115;
        arraylist = null;
        continue; /* Loop/switch isn't completed */
_L3:
        int l;
        if(l >= k)
            continue; /* Loop/switch isn't completed */
        arraylist.add(adrmrights[l]);
        l++;
          goto _L3
        Exception exception;
        exception;
        throw exception;
        l = 0;
        if(true) goto _L3; else goto _L4
_L4:
        if(true) goto _L6; else goto _L5
_L5:
    }

    /**
     * @deprecated Method installRights is deprecated
     */

    public DrmRights installRights(InputStream inputstream, int i, String s) throws DrmException, IOException {
        this;
        JVM INSTR monitorenter ;
        boolean flag = "application/vnd.oma.drm.rights+xml".equals(s);
        if(!flag) goto _L2; else goto _L1
_L1:
        byte byte0 = 3;
_L5:
        if(i > 0) goto _L4; else goto _L3
_L3:
        DrmRights drmrights = null;
_L7:
        this;
        JVM INSTR monitorexit ;
        return drmrights;
_L2:
        if("application/vnd.oma.drm.rights+wbxml".equals(s))
            byte0 = 4;
        else
        if("application/vnd.oma.drm.message".equals(s))
            byte0 = 1;
        else
            throw new IllegalArgumentException("mimeType must be DRM_MIMETYPE_RIGHTS_XML or DRM_MIMETYPE_RIGHTS_WBXML or DRM_MIMETYPE_MESSAGE");
          goto _L5
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L4:
        drmrights = new DrmRights();
        if(-1 != nativeInstallDrmRights(inputstream, i, byte0, drmrights)) goto _L7; else goto _L6
_L6:
        throw new DrmException("nativeInstallDrmRights() returned JNI_DRM_FAILURE");
          goto _L5
    }

    /**
     * @deprecated Method queryRights is deprecated
     */

    public DrmRights queryRights(DrmRawContent drmrawcontent) {
        this;
        JVM INSTR monitorenter ;
        DrmRights drmrights;
        int i;
        drmrights = new DrmRights();
        i = nativeQueryRights(drmrawcontent, drmrights);
        if(-1 == i)
            drmrights = null;
        this;
        JVM INSTR monitorexit ;
        return drmrights;
        Exception exception;
        exception;
        throw exception;
    }

    private static final int DRM_MIMETYPE_MESSAGE = 1;
    private static final int DRM_MIMETYPE_RIGHTS_WBXML = 4;
    public static final String DRM_MIMETYPE_RIGHTS_WBXML_STRING = "application/vnd.oma.drm.rights+wbxml";
    private static final int DRM_MIMETYPE_RIGHTS_XML = 3;
    public static final String DRM_MIMETYPE_RIGHTS_XML_STRING = "application/vnd.oma.drm.rights+xml";
    private static final int JNI_DRM_FAILURE = -1;
    private static final int JNI_DRM_SUCCESS;
    private static DrmRightsManager singleton = null;

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

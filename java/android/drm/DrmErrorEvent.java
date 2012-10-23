// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.drm;

import java.util.HashMap;

// Referenced classes of package android.drm:
//            DrmEvent

public class DrmErrorEvent extends DrmEvent {

    public DrmErrorEvent(int i, int j, String s) {
        super(i, j, s);
        checkTypeValidity(j);
    }

    public DrmErrorEvent(int i, int j, String s, HashMap hashmap) {
        super(i, j, s, hashmap);
        checkTypeValidity(j);
    }

    private void checkTypeValidity(int i) {
        if(i < 2001 || i > 2008)
            throw new IllegalArgumentException((new StringBuilder()).append("Unsupported type: ").append(i).toString());
        else
            return;
    }

    public static final int TYPE_ACQUIRE_DRM_INFO_FAILED = 2008;
    public static final int TYPE_NOT_SUPPORTED = 2003;
    public static final int TYPE_NO_INTERNET_CONNECTION = 2005;
    public static final int TYPE_OUT_OF_MEMORY = 2004;
    public static final int TYPE_PROCESS_DRM_INFO_FAILED = 2006;
    public static final int TYPE_REMOVE_ALL_RIGHTS_FAILED = 2007;
    public static final int TYPE_RIGHTS_NOT_INSTALLED = 2001;
    public static final int TYPE_RIGHTS_RENEWAL_NOT_ALLOWED = 2002;
}

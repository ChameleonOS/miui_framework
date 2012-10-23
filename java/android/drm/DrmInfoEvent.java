// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.drm;

import java.util.HashMap;

// Referenced classes of package android.drm:
//            DrmEvent

public class DrmInfoEvent extends DrmEvent {

    public DrmInfoEvent(int i, int j, String s) {
        super(i, j, s);
        checkTypeValidity(j);
    }

    public DrmInfoEvent(int i, int j, String s, HashMap hashmap) {
        super(i, j, s, hashmap);
        checkTypeValidity(j);
    }

    private void checkTypeValidity(int i) {
        if((i < 1 || i > 6) && i != 1001 && i != 1002)
            throw new IllegalArgumentException((new StringBuilder()).append("Unsupported type: ").append(i).toString());
        else
            return;
    }

    public static final int TYPE_ACCOUNT_ALREADY_REGISTERED = 5;
    public static final int TYPE_ALREADY_REGISTERED_BY_ANOTHER_ACCOUNT = 1;
    public static final int TYPE_REMOVE_RIGHTS = 2;
    public static final int TYPE_RIGHTS_INSTALLED = 3;
    public static final int TYPE_RIGHTS_REMOVED = 6;
    public static final int TYPE_WAIT_FOR_RIGHTS = 4;
}

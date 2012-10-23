// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.policy;

import android.content.Context;
import android.view.*;

// Referenced classes of package com.android.internal.policy:
//            IPolicy

public final class PolicyManager {

    private PolicyManager() {
    }

    public static FallbackEventHandler makeNewFallbackEventHandler(Context context) {
        return sPolicy.makeNewFallbackEventHandler(context);
    }

    public static LayoutInflater makeNewLayoutInflater(Context context) {
        return sPolicy.makeNewLayoutInflater(context);
    }

    public static Window makeNewWindow(Context context) {
        return sPolicy.makeNewWindow(context);
    }

    public static WindowManagerPolicy makeNewWindowManager() {
        return sPolicy.makeNewWindowManager();
    }

    private static final String POLICY_IMPL_CLASS_NAME = "com.android.internal.policy.impl.Policy";
    private static final IPolicy sPolicy;

    static  {
        try {
            sPolicy = (IPolicy)Class.forName("com.android.internal.policy.impl.Policy").newInstance();
        }
        catch(ClassNotFoundException classnotfoundexception) {
            throw new RuntimeException("com.android.internal.policy.impl.Policy could not be loaded", classnotfoundexception);
        }
        catch(InstantiationException instantiationexception) {
            throw new RuntimeException("com.android.internal.policy.impl.Policy could not be instantiated", instantiationexception);
        }
        catch(IllegalAccessException illegalaccessexception) {
            throw new RuntimeException("com.android.internal.policy.impl.Policy could not be instantiated", illegalaccessexception);
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.ddm;

import org.apache.harmony.dalvik.ddmc.DdmServer;

// Referenced classes of package android.ddm:
//            DdmHandleHello, DdmHandleThread, DdmHandleHeap, DdmHandleNativeHeap, 
//            DdmHandleProfiling, DdmHandleExit

public class DdmRegister {

    private DdmRegister() {
    }

    public static void registerHandlers() {
        DdmHandleHello.register();
        DdmHandleThread.register();
        DdmHandleHeap.register();
        DdmHandleNativeHeap.register();
        DdmHandleProfiling.register();
        DdmHandleExit.register();
        DdmServer.registrationComplete();
    }
}

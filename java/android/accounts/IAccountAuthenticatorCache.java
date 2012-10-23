// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.accounts;

import android.content.pm.RegisteredServicesCacheListener;
import android.os.Handler;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collection;

// Referenced classes of package android.accounts:
//            AuthenticatorDescription

public interface IAccountAuthenticatorCache {

    public abstract void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]);

    public abstract Collection getAllServices();

    public abstract android.content.pm.RegisteredServicesCache.ServiceInfo getServiceInfo(AuthenticatorDescription authenticatordescription);

    public abstract void setListener(RegisteredServicesCacheListener registeredservicescachelistener, Handler handler);
}

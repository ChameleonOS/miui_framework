// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import android.util.Log;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;

// Referenced classes of package android.os:
//            IBinder, RemoteException, Parcel, IInterface

final class BinderProxy
    implements IBinder {

    BinderProxy() {
    }

    private final native void destroy();

    private static final void sendDeathNotice(IBinder.DeathRecipient deathrecipient) {
        deathrecipient.binderDied();
_L1:
        return;
        RuntimeException runtimeexception;
        runtimeexception;
        Log.w("BinderNative", "Uncaught exception from death notification", runtimeexception);
          goto _L1
    }

    public void dump(FileDescriptor filedescriptor, String as[]) throws RemoteException {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeFileDescriptor(filedescriptor);
        parcel.writeStringArray(as);
        transact(0x5f444d50, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        parcel1.recycle();
        throw exception;
    }

    public void dumpAsync(FileDescriptor filedescriptor, String as[]) throws RemoteException {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeFileDescriptor(filedescriptor);
        parcel.writeStringArray(as);
        transact(0x5f444d50, parcel, parcel1, 1);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        parcel1.recycle();
        throw exception;
    }

    protected void finalize() throws Throwable {
        destroy();
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public native String getInterfaceDescriptor() throws RemoteException;

    public native boolean isBinderAlive();

    public native void linkToDeath(IBinder.DeathRecipient deathrecipient, int i) throws RemoteException;

    public native boolean pingBinder();

    public IInterface queryLocalInterface(String s) {
        return null;
    }

    public native boolean transact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException;

    public native boolean unlinkToDeath(IBinder.DeathRecipient deathrecipient, int i);

    private int mObject;
    private int mOrgue;
    private final WeakReference mSelf = new WeakReference(this);
}

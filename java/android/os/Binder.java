// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import java.io.*;

// Referenced classes of package android.os:
//            IBinder, RemoteException, Parcel, UserId, 
//            ParcelFileDescriptor, StrictMode, IInterface

public class Binder
    implements IBinder {

    public Binder() {
        init();
    }

    public static final native long clearCallingIdentity();

    private final native void destroy();

    private boolean execTransact(int i, int j, int k, int l) {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain(j);
        parcel1 = Parcel.obtain(k);
        boolean flag1 = onTransact(i, parcel, parcel1, l);
        boolean flag = flag1;
_L2:
        parcel1.recycle();
        parcel.recycle();
        return flag;
        RemoteException remoteexception;
        remoteexception;
        parcel1.setDataPosition(0);
        parcel1.writeException(remoteexception);
        flag = true;
        continue; /* Loop/switch isn't completed */
        RuntimeException runtimeexception1;
        runtimeexception1;
        parcel1.setDataPosition(0);
        parcel1.writeException(runtimeexception1);
        flag = true;
        continue; /* Loop/switch isn't completed */
        OutOfMemoryError outofmemoryerror;
        outofmemoryerror;
        RuntimeException runtimeexception = new RuntimeException("Out of memory", outofmemoryerror);
        parcel1.setDataPosition(0);
        parcel1.writeException(runtimeexception);
        flag = true;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static final native void flushPendingCommands();

    public static final native int getCallingPid();

    public static final native int getCallingUid();

    public static final int getOrigCallingUid() {
        return getOrigCallingUidNative();
    }

    private static final native int getOrigCallingUidNative();

    public static final int getOrigCallingUser() {
        return UserId.getUserId(getOrigCallingUid());
    }

    public static final native int getThreadStrictModePolicy();

    private final native void init();

    public static final native void joinThreadPool();

    public static final native void restoreCallingIdentity(long l);

    public static final native void setThreadStrictModePolicy(int i);

    public void attachInterface(IInterface iinterface, String s) {
        mOwner = iinterface;
        mDescriptor = s;
    }

    protected void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
    }

    public void dump(FileDescriptor filedescriptor, String as[]) {
        PrintWriter printwriter = new PrintWriter(new FileOutputStream(filedescriptor));
        dump(filedescriptor, printwriter, as);
        printwriter.flush();
        return;
        Exception exception;
        exception;
        printwriter.flush();
        throw exception;
    }

    public void dumpAsync(FileDescriptor filedescriptor, String as[]) {
        (new Thread(as) {

            public void run() {
                dump(fd, pw, args);
                pw.flush();
                return;
                Exception exception;
                exception;
                pw.flush();
                throw exception;
            }

            final Binder this$0;
            final String val$args[];
            final FileDescriptor val$fd;
            final PrintWriter val$pw;

             {
                this$0 = Binder.this;
                fd = filedescriptor;
                pw = printwriter;
                args = as;
                super(final_s);
            }
        }).start();
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

    public String getInterfaceDescriptor() {
        return mDescriptor;
    }

    public boolean isBinderAlive() {
        return true;
    }

    public void linkToDeath(IBinder.DeathRecipient deathrecipient, int i) {
    }

    protected boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
        boolean flag = true;
        if(i != 0x5f4e5446) goto _L2; else goto _L1
_L1:
        parcel1.writeString(getInterfaceDescriptor());
_L4:
        return flag;
_L2:
        ParcelFileDescriptor parcelfiledescriptor;
        String as[];
        if(i != 0x5f444d50)
            break MISSING_BLOCK_LABEL_86;
        parcelfiledescriptor = parcel.readFileDescriptor();
        as = parcel.readStringArray();
        if(parcelfiledescriptor == null)
            break MISSING_BLOCK_LABEL_59;
        dump(parcelfiledescriptor.getFileDescriptor(), as);
        Exception exception;
        try {
            parcelfiledescriptor.close();
        }
        catch(IOException ioexception1) { }
        if(parcel1 != null)
            parcel1.writeNoException();
        else
            StrictMode.clearGatheredViolations();
        continue; /* Loop/switch isn't completed */
        exception;
        try {
            parcelfiledescriptor.close();
        }
        catch(IOException ioexception) { }
        throw exception;
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean pingBinder() {
        return true;
    }

    public IInterface queryLocalInterface(String s) {
        IInterface iinterface;
        if(mDescriptor.equals(s))
            iinterface = mOwner;
        else
            iinterface = null;
        return iinterface;
    }

    public final boolean transact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
        if(parcel != null)
            parcel.setDataPosition(0);
        boolean flag = onTransact(i, parcel, parcel1, j);
        if(parcel1 != null)
            parcel1.setDataPosition(0);
        return flag;
    }

    public boolean unlinkToDeath(IBinder.DeathRecipient deathrecipient, int i) {
        return true;
    }

    private static final boolean FIND_POTENTIAL_LEAKS = false;
    private static final String TAG = "Binder";
    private String mDescriptor;
    private int mObject;
    private IInterface mOwner;
}

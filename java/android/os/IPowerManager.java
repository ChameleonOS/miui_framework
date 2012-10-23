// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;


// Referenced classes of package android.os:
//            IInterface, RemoteException, IBinder, WorkSource, 
//            Binder, Parcel

public interface IPowerManager
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IPowerManager {
        private static class Proxy
            implements IPowerManager {

            public void acquireWakeLock(int i, IBinder ibinder, String s, WorkSource worksource) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.IPowerManager");
                parcel.writeInt(i);
                parcel.writeStrongBinder(ibinder);
                parcel.writeString(s);
                if(worksource == null)
                    break MISSING_BLOCK_LABEL_86;
                parcel.writeInt(1);
                worksource.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public IBinder asBinder() {
                return mRemote;
            }

            public void clearUserActivityTimeout(long l, long l1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.IPowerManager");
                parcel.writeLong(l);
                parcel.writeLong(l1);
                mRemote.transact(8, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void crash(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.IPowerManager");
                parcel.writeString(s);
                mRemote.transact(16, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "android.os.IPowerManager";
            }

            public int getSupportedWakeLockFlags() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.os.IPowerManager");
                mRemote.transact(10, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void goToSleep(long l) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.IPowerManager");
                parcel.writeLong(l);
                mRemote.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void goToSleepWithReason(long l, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.IPowerManager");
                parcel.writeLong(l);
                parcel.writeInt(i);
                mRemote.transact(4, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean isScreenOn() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.os.IPowerManager");
                mRemote.transact(14, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                if(i != 0)
                    flag = true;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void preventScreenOn(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.IPowerManager");
                if(flag)
                    i = 1;
                parcel.writeInt(i);
                mRemote.transact(13, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void reboot(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.IPowerManager");
                parcel.writeString(s);
                mRemote.transact(15, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void releaseWakeLock(IBinder ibinder, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.IPowerManager");
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                mRemote.transact(5, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void setAttentionLight(boolean flag, int i) throws RemoteException {
                int j;
                Parcel parcel;
                Parcel parcel1;
                j = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.IPowerManager");
                if(flag)
                    j = 1;
                parcel.writeInt(j);
                parcel.writeInt(i);
                mRemote.transact(18, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void setAutoBrightnessAdjustment(float f) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.IPowerManager");
                parcel.writeFloat(f);
                mRemote.transact(19, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void setBacklightBrightness(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.IPowerManager");
                parcel.writeInt(i);
                mRemote.transact(17, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void setMaximumScreenOffTimeount(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.IPowerManager");
                parcel.writeInt(i);
                mRemote.transact(12, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void setPokeLock(int i, IBinder ibinder, String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.IPowerManager");
                parcel.writeInt(i);
                parcel.writeStrongBinder(ibinder);
                parcel.writeString(s);
                mRemote.transact(9, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void setStayOnSetting(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.IPowerManager");
                parcel.writeInt(i);
                mRemote.transact(11, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void updateWakeLockWorkSource(IBinder ibinder, WorkSource worksource) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.IPowerManager");
                parcel.writeStrongBinder(ibinder);
                if(worksource == null)
                    break MISSING_BLOCK_LABEL_65;
                parcel.writeInt(1);
                worksource.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void userActivity(long l, boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.IPowerManager");
                parcel.writeLong(l);
                if(flag)
                    i = 1;
                parcel.writeInt(i);
                mRemote.transact(6, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void userActivityWithForce(long l, boolean flag, boolean flag1) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.os.IPowerManager");
                parcel.writeLong(l);
                if(!flag)
                    break MISSING_BLOCK_LABEL_86;
                j = i;
_L1:
                parcel.writeInt(j);
                if(!flag1)
                    i = 0;
                parcel.writeInt(i);
                mRemote.transact(7, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                j = 0;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IPowerManager asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.os.IPowerManager");
                if(iinterface != null && (iinterface instanceof IPowerManager))
                    obj = (IPowerManager)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IPowerManager) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            int k;
            boolean flag;
            k = 0;
            flag = true;
            i;
            JVM INSTR lookupswitch 20: default 176
        //                       1: 199
        //                       2: 269
        //                       3: 323
        //                       4: 344
        //                       5: 369
        //                       6: 394
        //                       7: 438
        //                       8: 501
        //                       9: 526
        //                       10: 555
        //                       11: 580
        //                       12: 601
        //                       13: 622
        //                       14: 658
        //                       15: 692
        //                       16: 713
        //                       17: 734
        //                       18: 755
        //                       19: 795
        //                       1598968902: 190;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L23:
            return flag;
_L21:
            parcel1.writeString("android.os.IPowerManager");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.os.IPowerManager");
            int i1 = parcel.readInt();
            IBinder ibinder1 = parcel.readStrongBinder();
            String s = parcel.readString();
            WorkSource worksource1;
            if(parcel.readInt() != 0)
                worksource1 = (WorkSource)WorkSource.CREATOR.createFromParcel(parcel);
            else
                worksource1 = null;
            acquireWakeLock(i1, ibinder1, s, worksource1);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.os.IPowerManager");
            IBinder ibinder = parcel.readStrongBinder();
            WorkSource worksource;
            if(parcel.readInt() != 0)
                worksource = (WorkSource)WorkSource.CREATOR.createFromParcel(parcel);
            else
                worksource = null;
            updateWakeLockWorkSource(ibinder, worksource);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.os.IPowerManager");
            goToSleep(parcel.readLong());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.os.IPowerManager");
            goToSleepWithReason(parcel.readLong(), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.os.IPowerManager");
            releaseWakeLock(parcel.readStrongBinder(), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.os.IPowerManager");
            long l2 = parcel.readLong();
            boolean flag6;
            if(parcel.readInt() != 0)
                flag6 = flag;
            else
                flag6 = false;
            userActivity(l2, flag6);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.os.IPowerManager");
            long l1 = parcel.readLong();
            boolean flag4;
            boolean flag5;
            if(parcel.readInt() != 0)
                flag4 = flag;
            else
                flag4 = false;
            if(parcel.readInt() != 0)
                flag5 = flag;
            else
                flag5 = false;
            userActivityWithForce(l1, flag4, flag5);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("android.os.IPowerManager");
            clearUserActivityTimeout(parcel.readLong(), parcel.readLong());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("android.os.IPowerManager");
            setPokeLock(parcel.readInt(), parcel.readStrongBinder(), parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("android.os.IPowerManager");
            int l = getSupportedWakeLockFlags();
            parcel1.writeNoException();
            parcel1.writeInt(l);
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("android.os.IPowerManager");
            setStayOnSetting(parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("android.os.IPowerManager");
            setMaximumScreenOffTimeount(parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L14:
            parcel.enforceInterface("android.os.IPowerManager");
            boolean flag3;
            if(parcel.readInt() != 0)
                flag3 = flag;
            else
                flag3 = false;
            preventScreenOn(flag3);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L15:
            parcel.enforceInterface("android.os.IPowerManager");
            boolean flag2 = isScreenOn();
            parcel1.writeNoException();
            if(flag2)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L16:
            parcel.enforceInterface("android.os.IPowerManager");
            reboot(parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L17:
            parcel.enforceInterface("android.os.IPowerManager");
            crash(parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L18:
            parcel.enforceInterface("android.os.IPowerManager");
            setBacklightBrightness(parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L19:
            parcel.enforceInterface("android.os.IPowerManager");
            boolean flag1;
            if(parcel.readInt() != 0)
                flag1 = flag;
            else
                flag1 = false;
            setAttentionLight(flag1, parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L20:
            parcel.enforceInterface("android.os.IPowerManager");
            setAutoBrightnessAdjustment(parcel.readFloat());
            parcel1.writeNoException();
            if(true) goto _L23; else goto _L22
_L22:
        }

        private static final String DESCRIPTOR = "android.os.IPowerManager";
        static final int TRANSACTION_acquireWakeLock = 1;
        static final int TRANSACTION_clearUserActivityTimeout = 8;
        static final int TRANSACTION_crash = 16;
        static final int TRANSACTION_getSupportedWakeLockFlags = 10;
        static final int TRANSACTION_goToSleep = 3;
        static final int TRANSACTION_goToSleepWithReason = 4;
        static final int TRANSACTION_isScreenOn = 14;
        static final int TRANSACTION_preventScreenOn = 13;
        static final int TRANSACTION_reboot = 15;
        static final int TRANSACTION_releaseWakeLock = 5;
        static final int TRANSACTION_setAttentionLight = 18;
        static final int TRANSACTION_setAutoBrightnessAdjustment = 19;
        static final int TRANSACTION_setBacklightBrightness = 17;
        static final int TRANSACTION_setMaximumScreenOffTimeount = 12;
        static final int TRANSACTION_setPokeLock = 9;
        static final int TRANSACTION_setStayOnSetting = 11;
        static final int TRANSACTION_updateWakeLockWorkSource = 2;
        static final int TRANSACTION_userActivity = 6;
        static final int TRANSACTION_userActivityWithForce = 7;

        public Stub() {
            attachInterface(this, "android.os.IPowerManager");
        }
    }


    public abstract void acquireWakeLock(int i, IBinder ibinder, String s, WorkSource worksource) throws RemoteException;

    public abstract void clearUserActivityTimeout(long l, long l1) throws RemoteException;

    public abstract void crash(String s) throws RemoteException;

    public abstract int getSupportedWakeLockFlags() throws RemoteException;

    public abstract void goToSleep(long l) throws RemoteException;

    public abstract void goToSleepWithReason(long l, int i) throws RemoteException;

    public abstract boolean isScreenOn() throws RemoteException;

    public abstract void preventScreenOn(boolean flag) throws RemoteException;

    public abstract void reboot(String s) throws RemoteException;

    public abstract void releaseWakeLock(IBinder ibinder, int i) throws RemoteException;

    public abstract void setAttentionLight(boolean flag, int i) throws RemoteException;

    public abstract void setAutoBrightnessAdjustment(float f) throws RemoteException;

    public abstract void setBacklightBrightness(int i) throws RemoteException;

    public abstract void setMaximumScreenOffTimeount(int i) throws RemoteException;

    public abstract void setPokeLock(int i, IBinder ibinder, String s) throws RemoteException;

    public abstract void setStayOnSetting(int i) throws RemoteException;

    public abstract void updateWakeLockWorkSource(IBinder ibinder, WorkSource worksource) throws RemoteException;

    public abstract void userActivity(long l, boolean flag) throws RemoteException;

    public abstract void userActivityWithForce(long l, boolean flag, boolean flag1) throws RemoteException;
}

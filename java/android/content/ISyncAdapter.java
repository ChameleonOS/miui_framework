// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.accounts.Account;
import android.os.*;

// Referenced classes of package android.content:
//            ISyncContext

public interface ISyncAdapter
    extends IInterface {
    public static abstract class Stub extends Binder
        implements ISyncAdapter {
        private static class Proxy
            implements ISyncAdapter {

            public IBinder asBinder() {
                return mRemote;
            }

            public void cancelSync(ISyncContext isynccontext) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.ISyncAdapter");
                if(isynccontext != null)
                    ibinder = isynccontext.asBinder();
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(2, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "android.content.ISyncAdapter";
            }

            public void initialize(Account account, String s) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.ISyncAdapter");
                if(account == null)
                    break MISSING_BLOCK_LABEL_49;
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
_L1:
                parcel.writeString(s);
                mRemote.transact(3, parcel, null, 1);
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void startSync(ISyncContext isynccontext, String s, Account account, Bundle bundle) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.ISyncAdapter");
                if(isynccontext != null)
                    ibinder = isynccontext.asBinder();
                parcel.writeStrongBinder(ibinder);
                parcel.writeString(s);
                if(account == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
_L3:
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_116;
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L4:
                mRemote.transact(1, parcel, null, 1);
                parcel.recycle();
                return;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
                parcel.writeInt(0);
                  goto _L4
            }

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static ISyncAdapter asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.content.ISyncAdapter");
                if(iinterface != null && (iinterface instanceof ISyncAdapter))
                    obj = (ISyncAdapter)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((ISyncAdapter) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 4: default 48
        //                       1: 71
        //                       2: 161
        //                       3: 181
        //                       1598968902: 62;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L7:
            return flag;
_L5:
            parcel1.writeString("android.content.ISyncAdapter");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.content.ISyncAdapter");
            ISyncContext isynccontext = ISyncContext.Stub.asInterface(parcel.readStrongBinder());
            String s = parcel.readString();
            Account account1;
            Bundle bundle;
            if(parcel.readInt() != 0)
                account1 = (Account)Account.CREATOR.createFromParcel(parcel);
            else
                account1 = null;
            if(parcel.readInt() != 0)
                bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle = null;
            startSync(isynccontext, s, account1, bundle);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.content.ISyncAdapter");
            cancelSync(ISyncContext.Stub.asInterface(parcel.readStrongBinder()));
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.content.ISyncAdapter");
            Account account;
            if(parcel.readInt() != 0)
                account = (Account)Account.CREATOR.createFromParcel(parcel);
            else
                account = null;
            initialize(account, parcel.readString());
            if(true) goto _L7; else goto _L6
_L6:
        }

        private static final String DESCRIPTOR = "android.content.ISyncAdapter";
        static final int TRANSACTION_cancelSync = 2;
        static final int TRANSACTION_initialize = 3;
        static final int TRANSACTION_startSync = 1;

        public Stub() {
            attachInterface(this, "android.content.ISyncAdapter");
        }
    }


    public abstract void cancelSync(ISyncContext isynccontext) throws RemoteException;

    public abstract void initialize(Account account, String s) throws RemoteException;

    public abstract void startSync(ISyncContext isynccontext, String s, Account account, Bundle bundle) throws RemoteException;
}

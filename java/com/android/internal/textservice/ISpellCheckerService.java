// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.textservice;

import android.os.*;

// Referenced classes of package com.android.internal.textservice:
//            ISpellCheckerSessionListener, ISpellCheckerSession

public interface ISpellCheckerService
    extends IInterface {
    public static abstract class Stub extends Binder
        implements ISpellCheckerService {
        private static class Proxy
            implements ISpellCheckerService {

            public IBinder asBinder() {
                return mRemote;
            }

            public ISpellCheckerSession getISpellCheckerSession(String s, ISpellCheckerSessionListener ispellcheckersessionlistener, Bundle bundle) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.textservice.ISpellCheckerService");
                parcel.writeString(s);
                if(ispellcheckersessionlistener == null) goto _L2; else goto _L1
_L1:
                IBinder ibinder = ispellcheckersessionlistener.asBinder();
_L5:
                parcel.writeStrongBinder(ibinder);
                if(bundle == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L6:
                ISpellCheckerSession ispellcheckersession;
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                ispellcheckersession = ISpellCheckerSession.Stub.asInterface(parcel1.readStrongBinder());
                parcel1.recycle();
                parcel.recycle();
                return ispellcheckersession;
_L2:
                ibinder = null;
                  goto _L5
_L4:
                parcel.writeInt(0);
                  goto _L6
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                  goto _L5
            }

            public String getInterfaceDescriptor() {
                return "com.android.internal.textservice.ISpellCheckerService";
            }

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static ISpellCheckerService asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("com.android.internal.textservice.ISpellCheckerService");
                if(iinterface != null && (iinterface instanceof ISpellCheckerService))
                    obj = (ISpellCheckerService)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((ISpellCheckerService) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            i;
            JVM INSTR lookupswitch 2: default 28
        //                       1: 54
        //                       1598968902: 42;
               goto _L1 _L2 _L3
_L1:
            boolean flag = super.onTransact(i, parcel, parcel1, j);
_L5:
            return flag;
_L3:
            parcel1.writeString("com.android.internal.textservice.ISpellCheckerService");
            flag = true;
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("com.android.internal.textservice.ISpellCheckerService");
            String s = parcel.readString();
            ISpellCheckerSessionListener ispellcheckersessionlistener = ISpellCheckerSessionListener.Stub.asInterface(parcel.readStrongBinder());
            Bundle bundle;
            ISpellCheckerSession ispellcheckersession;
            IBinder ibinder;
            if(parcel.readInt() != 0)
                bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle = null;
            ispellcheckersession = getISpellCheckerSession(s, ispellcheckersessionlistener, bundle);
            parcel1.writeNoException();
            if(ispellcheckersession != null)
                ibinder = ispellcheckersession.asBinder();
            else
                ibinder = null;
            parcel1.writeStrongBinder(ibinder);
            flag = true;
            if(true) goto _L5; else goto _L4
_L4:
        }

        private static final String DESCRIPTOR = "com.android.internal.textservice.ISpellCheckerService";
        static final int TRANSACTION_getISpellCheckerSession = 1;

        public Stub() {
            attachInterface(this, "com.android.internal.textservice.ISpellCheckerService");
        }
    }


    public abstract ISpellCheckerSession getISpellCheckerSession(String s, ISpellCheckerSessionListener ispellcheckersessionlistener, Bundle bundle) throws RemoteException;
}

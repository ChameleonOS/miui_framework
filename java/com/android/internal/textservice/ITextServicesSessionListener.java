// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.textservice;

import android.os.*;

// Referenced classes of package com.android.internal.textservice:
//            ISpellCheckerSession

public interface ITextServicesSessionListener
    extends IInterface {
    public static abstract class Stub extends Binder
        implements ITextServicesSessionListener {
        private static class Proxy
            implements ITextServicesSessionListener {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.android.internal.textservice.ITextServicesSessionListener";
            }

            public void onServiceConnected(ISpellCheckerSession ispellcheckersession) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.textservice.ITextServicesSessionListener");
                if(ispellcheckersession != null)
                    ibinder = ispellcheckersession.asBinder();
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(1, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static ITextServicesSessionListener asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("com.android.internal.textservice.ITextServicesSessionListener");
                if(iinterface != null && (iinterface instanceof ITextServicesSessionListener))
                    obj = (ITextServicesSessionListener)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((ITextServicesSessionListener) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 2: default 32
        //                       1: 55
        //                       1598968902: 46;
               goto _L1 _L2 _L3
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L5:
            return flag;
_L3:
            parcel1.writeString("com.android.internal.textservice.ITextServicesSessionListener");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("com.android.internal.textservice.ITextServicesSessionListener");
            onServiceConnected(ISpellCheckerSession.Stub.asInterface(parcel.readStrongBinder()));
            if(true) goto _L5; else goto _L4
_L4:
        }

        private static final String DESCRIPTOR = "com.android.internal.textservice.ITextServicesSessionListener";
        static final int TRANSACTION_onServiceConnected = 1;

        public Stub() {
            attachInterface(this, "com.android.internal.textservice.ITextServicesSessionListener");
        }
    }


    public abstract void onServiceConnected(ISpellCheckerSession ispellcheckersession) throws RemoteException;
}

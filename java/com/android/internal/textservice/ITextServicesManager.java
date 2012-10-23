// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.textservice;

import android.os.*;
import android.view.textservice.SpellCheckerInfo;
import android.view.textservice.SpellCheckerSubtype;

// Referenced classes of package com.android.internal.textservice:
//            ISpellCheckerSessionListener, ITextServicesSessionListener

public interface ITextServicesManager
    extends IInterface {
    public static abstract class Stub extends Binder
        implements ITextServicesManager {
        private static class Proxy
            implements ITextServicesManager {

            public IBinder asBinder() {
                return mRemote;
            }

            public void finishSpellCheckerService(ISpellCheckerSessionListener ispellcheckersessionlistener) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.textservice.ITextServicesManager");
                if(ispellcheckersessionlistener != null)
                    ibinder = ispellcheckersessionlistener.asBinder();
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(4, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public SpellCheckerInfo getCurrentSpellChecker(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.textservice.ITextServicesManager");
                parcel.writeString(s);
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                SpellCheckerInfo spellcheckerinfo = (SpellCheckerInfo)SpellCheckerInfo.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return spellcheckerinfo;
_L2:
                spellcheckerinfo = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public SpellCheckerSubtype getCurrentSpellCheckerSubtype(String s, boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.textservice.ITextServicesManager");
                parcel.writeString(s);
                if(flag)
                    i = 1;
                parcel.writeInt(i);
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                SpellCheckerSubtype spellcheckersubtype = (SpellCheckerSubtype)SpellCheckerSubtype.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return spellcheckersubtype;
_L2:
                spellcheckersubtype = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public SpellCheckerInfo[] getEnabledSpellCheckers() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                SpellCheckerInfo aspellcheckerinfo[];
                parcel.writeInterfaceToken("com.android.internal.textservice.ITextServicesManager");
                mRemote.transact(9, parcel, parcel1, 0);
                parcel1.readException();
                aspellcheckerinfo = (SpellCheckerInfo[])parcel1.createTypedArray(SpellCheckerInfo.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return aspellcheckerinfo;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "com.android.internal.textservice.ITextServicesManager";
            }

            public void getSpellCheckerService(String s, String s1, ITextServicesSessionListener itextservicessessionlistener, ISpellCheckerSessionListener ispellcheckersessionlistener, Bundle bundle) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.textservice.ITextServicesManager");
                parcel.writeString(s);
                parcel.writeString(s1);
                if(itextservicessessionlistener == null) goto _L2; else goto _L1
_L1:
                IBinder ibinder1 = itextservicessessionlistener.asBinder();
_L5:
                parcel.writeStrongBinder(ibinder1);
                if(ispellcheckersessionlistener != null)
                    ibinder = ispellcheckersessionlistener.asBinder();
                parcel.writeStrongBinder(ibinder);
                if(bundle == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L6:
                mRemote.transact(3, parcel, null, 1);
                parcel.recycle();
                return;
_L2:
                ibinder1 = null;
                  goto _L5
_L4:
                parcel.writeInt(0);
                  goto _L6
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
                  goto _L5
            }

            public boolean isSpellCheckerEnabled() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.textservice.ITextServicesManager");
                mRemote.transact(8, parcel, parcel1, 0);
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

            public void setCurrentSpellChecker(String s, String s1) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.textservice.ITextServicesManager");
                parcel.writeString(s);
                parcel.writeString(s1);
                mRemote.transact(5, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void setCurrentSpellCheckerSubtype(String s, int i) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.textservice.ITextServicesManager");
                parcel.writeString(s);
                parcel.writeInt(i);
                mRemote.transact(6, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void setSpellCheckerEnabled(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                i = 1;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.textservice.ITextServicesManager");
                if(!flag)
                    i = 0;
                parcel.writeInt(i);
                mRemote.transact(7, parcel, null, 1);
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


        public static ITextServicesManager asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("com.android.internal.textservice.ITextServicesManager");
                if(iinterface != null && (iinterface instanceof ITextServicesManager))
                    obj = (ITextServicesManager)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((ITextServicesManager) (obj));
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
            JVM INSTR lookupswitch 10: default 96
        //                       1: 119
        //                       2: 169
        //                       3: 242
        //                       4: 322
        //                       5: 342
        //                       6: 363
        //                       7: 384
        //                       8: 416
        //                       9: 450
        //                       1598968902: 110;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L13:
            return flag;
_L11:
            parcel1.writeString("com.android.internal.textservice.ITextServicesManager");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("com.android.internal.textservice.ITextServicesManager");
            SpellCheckerInfo spellcheckerinfo = getCurrentSpellChecker(parcel.readString());
            parcel1.writeNoException();
            if(spellcheckerinfo != null) {
                parcel1.writeInt(flag);
                spellcheckerinfo.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("com.android.internal.textservice.ITextServicesManager");
            String s2 = parcel.readString();
            boolean flag3;
            SpellCheckerSubtype spellcheckersubtype;
            if(parcel.readInt() != 0)
                flag3 = flag;
            else
                flag3 = false;
            spellcheckersubtype = getCurrentSpellCheckerSubtype(s2, flag3);
            parcel1.writeNoException();
            if(spellcheckersubtype != null) {
                parcel1.writeInt(flag);
                spellcheckersubtype.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("com.android.internal.textservice.ITextServicesManager");
            String s = parcel.readString();
            String s1 = parcel.readString();
            ITextServicesSessionListener itextservicessessionlistener = ITextServicesSessionListener.Stub.asInterface(parcel.readStrongBinder());
            ISpellCheckerSessionListener ispellcheckersessionlistener = ISpellCheckerSessionListener.Stub.asInterface(parcel.readStrongBinder());
            Bundle bundle;
            if(parcel.readInt() != 0)
                bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle = null;
            getSpellCheckerService(s, s1, itextservicessessionlistener, ispellcheckersessionlistener, bundle);
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("com.android.internal.textservice.ITextServicesManager");
            finishSpellCheckerService(ISpellCheckerSessionListener.Stub.asInterface(parcel.readStrongBinder()));
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("com.android.internal.textservice.ITextServicesManager");
            setCurrentSpellChecker(parcel.readString(), parcel.readString());
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("com.android.internal.textservice.ITextServicesManager");
            setCurrentSpellCheckerSubtype(parcel.readString(), parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("com.android.internal.textservice.ITextServicesManager");
            boolean flag2;
            if(parcel.readInt() != 0)
                flag2 = flag;
            else
                flag2 = false;
            setSpellCheckerEnabled(flag2);
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("com.android.internal.textservice.ITextServicesManager");
            boolean flag1 = isSpellCheckerEnabled();
            parcel1.writeNoException();
            if(flag1)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("com.android.internal.textservice.ITextServicesManager");
            SpellCheckerInfo aspellcheckerinfo[] = getEnabledSpellCheckers();
            parcel1.writeNoException();
            parcel1.writeTypedArray(aspellcheckerinfo, flag);
            if(true) goto _L13; else goto _L12
_L12:
        }

        private static final String DESCRIPTOR = "com.android.internal.textservice.ITextServicesManager";
        static final int TRANSACTION_finishSpellCheckerService = 4;
        static final int TRANSACTION_getCurrentSpellChecker = 1;
        static final int TRANSACTION_getCurrentSpellCheckerSubtype = 2;
        static final int TRANSACTION_getEnabledSpellCheckers = 9;
        static final int TRANSACTION_getSpellCheckerService = 3;
        static final int TRANSACTION_isSpellCheckerEnabled = 8;
        static final int TRANSACTION_setCurrentSpellChecker = 5;
        static final int TRANSACTION_setCurrentSpellCheckerSubtype = 6;
        static final int TRANSACTION_setSpellCheckerEnabled = 7;

        public Stub() {
            attachInterface(this, "com.android.internal.textservice.ITextServicesManager");
        }
    }


    public abstract void finishSpellCheckerService(ISpellCheckerSessionListener ispellcheckersessionlistener) throws RemoteException;

    public abstract SpellCheckerInfo getCurrentSpellChecker(String s) throws RemoteException;

    public abstract SpellCheckerSubtype getCurrentSpellCheckerSubtype(String s, boolean flag) throws RemoteException;

    public abstract SpellCheckerInfo[] getEnabledSpellCheckers() throws RemoteException;

    public abstract void getSpellCheckerService(String s, String s1, ITextServicesSessionListener itextservicessessionlistener, ISpellCheckerSessionListener ispellcheckersessionlistener, Bundle bundle) throws RemoteException;

    public abstract boolean isSpellCheckerEnabled() throws RemoteException;

    public abstract void setCurrentSpellChecker(String s, String s1) throws RemoteException;

    public abstract void setCurrentSpellCheckerSubtype(String s, int i) throws RemoteException;

    public abstract void setSpellCheckerEnabled(boolean flag) throws RemoteException;
}

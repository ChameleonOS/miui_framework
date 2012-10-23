// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.os.*;

// Referenced classes of package android.content:
//            IOnPrimaryClipChangedListener, ClipData, ClipDescription

public interface IClipboard
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IClipboard {
        private static class Proxy
            implements IClipboard {

            public void addPrimaryClipChangedListener(IOnPrimaryClipChangedListener ionprimaryclipchangedlistener) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.content.IClipboard");
                if(ionprimaryclipchangedlistener == null)
                    break MISSING_BLOCK_LABEL_59;
                ibinder = ionprimaryclipchangedlistener.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(5, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                ibinder = null;
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

            public String getInterfaceDescriptor() {
                return "android.content.IClipboard";
            }

            public ClipData getPrimaryClip(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.IClipboard");
                parcel.writeString(s);
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                ClipData clipdata = (ClipData)ClipData.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return clipdata;
_L2:
                clipdata = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public ClipDescription getPrimaryClipDescription() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.IClipboard");
                mRemote.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                ClipDescription clipdescription = (ClipDescription)ClipDescription.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return clipdescription;
_L2:
                clipdescription = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean hasClipboardText() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.content.IClipboard");
                mRemote.transact(7, parcel, parcel1, 0);
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

            public boolean hasPrimaryClip() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.content.IClipboard");
                mRemote.transact(4, parcel, parcel1, 0);
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

            public void removePrimaryClipChangedListener(IOnPrimaryClipChangedListener ionprimaryclipchangedlistener) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.content.IClipboard");
                if(ionprimaryclipchangedlistener == null)
                    break MISSING_BLOCK_LABEL_60;
                ibinder = ionprimaryclipchangedlistener.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(6, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void setPrimaryClip(ClipData clipdata) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.IClipboard");
                if(clipdata == null)
                    break MISSING_BLOCK_LABEL_56;
                parcel.writeInt(1);
                clipdata.writeToParcel(parcel, 0);
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IClipboard asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.content.IClipboard");
                if(iinterface != null && (iinterface instanceof IClipboard))
                    obj = (IClipboard)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IClipboard) (obj));
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
            JVM INSTR lookupswitch 8: default 80
        //                       1: 103
        //                       2: 149
        //                       3: 199
        //                       4: 245
        //                       5: 279
        //                       6: 303
        //                       7: 327
        //                       1598968902: 94;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L11:
            return flag;
_L9:
            parcel1.writeString("android.content.IClipboard");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.content.IClipboard");
            ClipData clipdata1;
            if(parcel.readInt() != 0)
                clipdata1 = (ClipData)ClipData.CREATOR.createFromParcel(parcel);
            else
                clipdata1 = null;
            setPrimaryClip(clipdata1);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.content.IClipboard");
            ClipData clipdata = getPrimaryClip(parcel.readString());
            parcel1.writeNoException();
            if(clipdata != null) {
                parcel1.writeInt(flag);
                clipdata.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.content.IClipboard");
            ClipDescription clipdescription = getPrimaryClipDescription();
            parcel1.writeNoException();
            if(clipdescription != null) {
                parcel1.writeInt(flag);
                clipdescription.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.content.IClipboard");
            boolean flag2 = hasPrimaryClip();
            parcel1.writeNoException();
            if(flag2)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.content.IClipboard");
            addPrimaryClipChangedListener(IOnPrimaryClipChangedListener.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.content.IClipboard");
            removePrimaryClipChangedListener(IOnPrimaryClipChangedListener.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.content.IClipboard");
            boolean flag1 = hasClipboardText();
            parcel1.writeNoException();
            if(flag1)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            if(true) goto _L11; else goto _L10
_L10:
        }

        private static final String DESCRIPTOR = "android.content.IClipboard";
        static final int TRANSACTION_addPrimaryClipChangedListener = 5;
        static final int TRANSACTION_getPrimaryClip = 2;
        static final int TRANSACTION_getPrimaryClipDescription = 3;
        static final int TRANSACTION_hasClipboardText = 7;
        static final int TRANSACTION_hasPrimaryClip = 4;
        static final int TRANSACTION_removePrimaryClipChangedListener = 6;
        static final int TRANSACTION_setPrimaryClip = 1;

        public Stub() {
            attachInterface(this, "android.content.IClipboard");
        }
    }


    public abstract void addPrimaryClipChangedListener(IOnPrimaryClipChangedListener ionprimaryclipchangedlistener) throws RemoteException;

    public abstract ClipData getPrimaryClip(String s) throws RemoteException;

    public abstract ClipDescription getPrimaryClipDescription() throws RemoteException;

    public abstract boolean hasClipboardText() throws RemoteException;

    public abstract boolean hasPrimaryClip() throws RemoteException;

    public abstract void removePrimaryClipChangedListener(IOnPrimaryClipChangedListener ionprimaryclipchangedlistener) throws RemoteException;

    public abstract void setPrimaryClip(ClipData clipdata) throws RemoteException;
}

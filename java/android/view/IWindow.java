// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.*;

// Referenced classes of package android.view:
//            DragEvent

public interface IWindow
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IWindow {
        private static class Proxy
            implements IWindow {

            public IBinder asBinder() {
                return mRemote;
            }

            public void closeSystemDialogs(String s) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindow");
                parcel.writeString(s);
                mRemote.transact(7, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void dispatchAppVisibility(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                i = 1;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindow");
                if(!flag)
                    i = 0;
                parcel.writeInt(i);
                mRemote.transact(3, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void dispatchDragEvent(DragEvent dragevent) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindow");
                if(dragevent == null)
                    break MISSING_BLOCK_LABEL_45;
                parcel.writeInt(1);
                dragevent.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(10, parcel, null, 1);
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void dispatchGetNewSurface() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindow");
                mRemote.transact(4, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void dispatchScreenState(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                i = 1;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindow");
                if(!flag)
                    i = 0;
                parcel.writeInt(i);
                mRemote.transact(5, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void dispatchSystemUiVisibilityChanged(int i, int j, int k, int l) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindow");
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeInt(k);
                parcel.writeInt(l);
                mRemote.transact(11, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void dispatchWallpaperCommand(String s, int i, int j, int k, Bundle bundle, boolean flag) throws RemoteException {
                int l;
                Parcel parcel;
                l = 1;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindow");
                parcel.writeString(s);
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeInt(k);
                if(bundle != null) {
                    parcel.writeInt(1);
                    bundle.writeToParcel(parcel, 0);
                    break MISSING_BLOCK_LABEL_110;
                }
                  goto _L1
_L2:
                parcel.writeInt(l);
                mRemote.transact(9, parcel, null, 1);
                parcel.recycle();
                return;
_L1:
                parcel.writeInt(0);
                break MISSING_BLOCK_LABEL_110;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
                while(!flag)  {
                    l = 0;
                    break;
                }
                  goto _L2
            }

            public void dispatchWallpaperOffsets(float f, float f1, float f2, float f3, boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                i = 1;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindow");
                parcel.writeFloat(f);
                parcel.writeFloat(f1);
                parcel.writeFloat(f2);
                parcel.writeFloat(f3);
                if(!flag)
                    i = 0;
                parcel.writeInt(i);
                mRemote.transact(8, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void doneAnimating() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindow");
                mRemote.transact(12, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void executeCommand(String s, String s1, ParcelFileDescriptor parcelfiledescriptor) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindow");
                parcel.writeString(s);
                parcel.writeString(s1);
                if(parcelfiledescriptor == null)
                    break MISSING_BLOCK_LABEL_62;
                parcel.writeInt(1);
                parcelfiledescriptor.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(1, parcel, null, 1);
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "android.view.IWindow";
            }

            public void resized(int i, int j, Rect rect, Rect rect1, boolean flag, Configuration configuration) throws RemoteException {
                int k;
                Parcel parcel;
                k = 1;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindow");
                parcel.writeInt(i);
                parcel.writeInt(j);
                if(rect == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                rect.writeToParcel(parcel, 0);
_L8:
                if(rect1 == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                rect1.writeToParcel(parcel, 0);
                  goto _L5
_L10:
                parcel.writeInt(k);
                if(configuration == null) goto _L7; else goto _L6
_L6:
                parcel.writeInt(1);
                configuration.writeToParcel(parcel, 0);
_L9:
                mRemote.transact(2, parcel, null, 1);
                parcel.recycle();
                return;
_L2:
                parcel.writeInt(0);
                  goto _L8
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
_L4:
                parcel.writeInt(0);
                  goto _L5
_L7:
                parcel.writeInt(0);
                  goto _L9
_L5:
                if(!flag) goto _L11; else goto _L10
_L11:
                k = 0;
                  goto _L10
            }

            public void windowFocusChanged(boolean flag, boolean flag1) throws RemoteException {
                int i;
                Parcel parcel;
                i = 1;
                parcel = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.view.IWindow");
                if(!flag)
                    break MISSING_BLOCK_LABEL_60;
                j = i;
_L1:
                parcel.writeInt(j);
                if(!flag1)
                    i = 0;
                parcel.writeInt(i);
                mRemote.transact(6, parcel, null, 1);
                parcel.recycle();
                return;
                j = 0;
                  goto _L1
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


        public static IWindow asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.view.IWindow");
                if(iinterface != null && (iinterface instanceof IWindow))
                    obj = (IWindow)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IWindow) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 13: default 120
        //                       1: 143
        //                       2: 201
        //                       3: 336
        //                       4: 368
        //                       5: 381
        //                       6: 413
        //                       7: 464
        //                       8: 481
        //                       9: 545
        //                       10: 638
        //                       11: 680
        //                       12: 709
        //                       1598968902: 134;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L16:
            return flag;
_L14:
            parcel1.writeString("android.view.IWindow");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.view.IWindow");
            String s1 = parcel.readString();
            String s2 = parcel.readString();
            ParcelFileDescriptor parcelfiledescriptor;
            if(parcel.readInt() != 0)
                parcelfiledescriptor = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            else
                parcelfiledescriptor = null;
            executeCommand(s1, s2, parcelfiledescriptor);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.view.IWindow");
            int j1 = parcel.readInt();
            int k1 = parcel.readInt();
            Rect rect;
            Rect rect1;
            boolean flag7;
            Configuration configuration;
            if(parcel.readInt() != 0)
                rect = (Rect)Rect.CREATOR.createFromParcel(parcel);
            else
                rect = null;
            if(parcel.readInt() != 0)
                rect1 = (Rect)Rect.CREATOR.createFromParcel(parcel);
            else
                rect1 = null;
            if(parcel.readInt() != 0)
                flag7 = flag;
            else
                flag7 = false;
            if(parcel.readInt() != 0)
                configuration = (Configuration)Configuration.CREATOR.createFromParcel(parcel);
            else
                configuration = null;
            resized(j1, k1, rect, rect1, flag7, configuration);
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.view.IWindow");
            boolean flag6;
            if(parcel.readInt() != 0)
                flag6 = flag;
            else
                flag6 = false;
            dispatchAppVisibility(flag6);
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.view.IWindow");
            dispatchGetNewSurface();
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.view.IWindow");
            boolean flag5;
            if(parcel.readInt() != 0)
                flag5 = flag;
            else
                flag5 = false;
            dispatchScreenState(flag5);
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.view.IWindow");
            boolean flag3;
            boolean flag4;
            if(parcel.readInt() != 0)
                flag3 = flag;
            else
                flag3 = false;
            if(parcel.readInt() != 0)
                flag4 = flag;
            else
                flag4 = false;
            windowFocusChanged(flag3, flag4);
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.view.IWindow");
            closeSystemDialogs(parcel.readString());
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("android.view.IWindow");
            float f = parcel.readFloat();
            float f1 = parcel.readFloat();
            float f2 = parcel.readFloat();
            float f3 = parcel.readFloat();
            boolean flag2;
            if(parcel.readInt() != 0)
                flag2 = flag;
            else
                flag2 = false;
            dispatchWallpaperOffsets(f, f1, f2, f3, flag2);
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("android.view.IWindow");
            String s = parcel.readString();
            int k = parcel.readInt();
            int l = parcel.readInt();
            int i1 = parcel.readInt();
            Bundle bundle;
            boolean flag1;
            if(parcel.readInt() != 0)
                bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle = null;
            if(parcel.readInt() != 0)
                flag1 = flag;
            else
                flag1 = false;
            dispatchWallpaperCommand(s, k, l, i1, bundle, flag1);
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("android.view.IWindow");
            DragEvent dragevent;
            if(parcel.readInt() != 0)
                dragevent = (DragEvent)DragEvent.CREATOR.createFromParcel(parcel);
            else
                dragevent = null;
            dispatchDragEvent(dragevent);
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("android.view.IWindow");
            dispatchSystemUiVisibilityChanged(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("android.view.IWindow");
            doneAnimating();
            if(true) goto _L16; else goto _L15
_L15:
        }

        private static final String DESCRIPTOR = "android.view.IWindow";
        static final int TRANSACTION_closeSystemDialogs = 7;
        static final int TRANSACTION_dispatchAppVisibility = 3;
        static final int TRANSACTION_dispatchDragEvent = 10;
        static final int TRANSACTION_dispatchGetNewSurface = 4;
        static final int TRANSACTION_dispatchScreenState = 5;
        static final int TRANSACTION_dispatchSystemUiVisibilityChanged = 11;
        static final int TRANSACTION_dispatchWallpaperCommand = 9;
        static final int TRANSACTION_dispatchWallpaperOffsets = 8;
        static final int TRANSACTION_doneAnimating = 12;
        static final int TRANSACTION_executeCommand = 1;
        static final int TRANSACTION_resized = 2;
        static final int TRANSACTION_windowFocusChanged = 6;

        public Stub() {
            attachInterface(this, "android.view.IWindow");
        }
    }


    public abstract void closeSystemDialogs(String s) throws RemoteException;

    public abstract void dispatchAppVisibility(boolean flag) throws RemoteException;

    public abstract void dispatchDragEvent(DragEvent dragevent) throws RemoteException;

    public abstract void dispatchGetNewSurface() throws RemoteException;

    public abstract void dispatchScreenState(boolean flag) throws RemoteException;

    public abstract void dispatchSystemUiVisibilityChanged(int i, int j, int k, int l) throws RemoteException;

    public abstract void dispatchWallpaperCommand(String s, int i, int j, int k, Bundle bundle, boolean flag) throws RemoteException;

    public abstract void dispatchWallpaperOffsets(float f, float f1, float f2, float f3, boolean flag) throws RemoteException;

    public abstract void doneAnimating() throws RemoteException;

    public abstract void executeCommand(String s, String s1, ParcelFileDescriptor parcelfiledescriptor) throws RemoteException;

    public abstract void resized(int i, int j, Rect rect, Rect rect1, boolean flag, Configuration configuration) throws RemoteException;

    public abstract void windowFocusChanged(boolean flag, boolean flag1) throws RemoteException;
}

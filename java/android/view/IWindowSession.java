// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.content.ClipData;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.*;

// Referenced classes of package android.view:
//            IWindow, InputChannel, Surface

public interface IWindowSession
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IWindowSession {
        private static class Proxy
            implements IWindowSession {

            public int add(IWindow iwindow, int i, WindowManager.LayoutParams layoutparams, int j, Rect rect, InputChannel inputchannel) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowSession");
                if(iwindow == null) goto _L2; else goto _L1
_L1:
                IBinder ibinder = iwindow.asBinder();
_L5:
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                if(layoutparams == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                layoutparams.writeToParcel(parcel, 0);
_L6:
                int k;
                parcel.writeInt(j);
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                k = parcel1.readInt();
                if(parcel1.readInt() != 0)
                    rect.readFromParcel(parcel1);
                if(parcel1.readInt() != 0)
                    inputchannel.readFromParcel(parcel1);
                parcel1.recycle();
                parcel.recycle();
                return k;
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

            public int addWithoutInputChannel(IWindow iwindow, int i, WindowManager.LayoutParams layoutparams, int j, Rect rect) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowSession");
                if(iwindow == null) goto _L2; else goto _L1
_L1:
                IBinder ibinder = iwindow.asBinder();
_L5:
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                if(layoutparams == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                layoutparams.writeToParcel(parcel, 0);
_L6:
                int k;
                parcel.writeInt(j);
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                k = parcel1.readInt();
                if(parcel1.readInt() != 0)
                    rect.readFromParcel(parcel1);
                parcel1.recycle();
                parcel.recycle();
                return k;
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

            public IBinder asBinder() {
                return mRemote;
            }

            public void dragRecipientEntered(IWindow iwindow) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.view.IWindowSession");
                if(iwindow == null)
                    break MISSING_BLOCK_LABEL_60;
                ibinder = iwindow.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(17, parcel, parcel1, 0);
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

            public void dragRecipientExited(IWindow iwindow) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.view.IWindowSession");
                if(iwindow == null)
                    break MISSING_BLOCK_LABEL_60;
                ibinder = iwindow.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(18, parcel, parcel1, 0);
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

            public void finishDrawing(IWindow iwindow) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.view.IWindowSession");
                if(iwindow == null)
                    break MISSING_BLOCK_LABEL_60;
                ibinder = iwindow.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(10, parcel, parcel1, 0);
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

            public void getDisplayFrame(IWindow iwindow, Rect rect) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.view.IWindowSession");
                if(iwindow == null)
                    break MISSING_BLOCK_LABEL_78;
                ibinder = iwindow.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(9, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() != 0)
                    rect.readFromParcel(parcel1);
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

            public boolean getInTouchMode() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.view.IWindowSession");
                mRemote.transact(12, parcel, parcel1, 0);
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

            public String getInterfaceDescriptor() {
                return "android.view.IWindowSession";
            }

            public boolean outOfMemory(IWindow iwindow) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.view.IWindowSession");
                if(iwindow == null)
                    break MISSING_BLOCK_LABEL_81;
                ibinder = iwindow.asBinder();
_L1:
                int i;
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(6, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                if(i != 0)
                    flag = true;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void performDeferredDestroy(IWindow iwindow) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.view.IWindowSession");
                if(iwindow == null)
                    break MISSING_BLOCK_LABEL_59;
                ibinder = iwindow.asBinder();
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

            public boolean performDrag(IWindow iwindow, IBinder ibinder, float f, float f1, float f2, float f3, ClipData clipdata) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowSession");
                if(iwindow == null) goto _L2; else goto _L1
_L1:
                IBinder ibinder1 = iwindow.asBinder();
_L5:
                parcel.writeStrongBinder(ibinder1);
                parcel.writeStrongBinder(ibinder);
                parcel.writeFloat(f);
                parcel.writeFloat(f1);
                parcel.writeFloat(f2);
                parcel.writeFloat(f3);
                if(clipdata == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                clipdata.writeToParcel(parcel, 0);
_L6:
                int i;
                mRemote.transact(15, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                Exception exception;
                if(i == 0)
                    flag = false;
                parcel1.recycle();
                parcel.recycle();
                return flag;
_L2:
                ibinder1 = null;
                  goto _L5
_L4:
                parcel.writeInt(0);
                  goto _L6
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                  goto _L5
            }

            public boolean performHapticFeedback(IWindow iwindow, int i, boolean flag) throws RemoteException {
                boolean flag1;
                Parcel parcel;
                Parcel parcel1;
                flag1 = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowSession");
                if(iwindow == null) goto _L2; else goto _L1
_L1:
                IBinder ibinder = iwindow.asBinder();
_L5:
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                if(!flag) goto _L4; else goto _L3
_L3:
                int j = ((flag1) ? 1 : 0);
_L6:
                int k;
                parcel.writeInt(j);
                mRemote.transact(13, parcel, parcel1, 0);
                parcel1.readException();
                k = parcel1.readInt();
                if(k == 0)
                    flag1 = false;
                parcel1.recycle();
                parcel.recycle();
                return flag1;
_L2:
                ibinder = null;
                  goto _L5
_L4:
                j = 0;
                  goto _L6
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                  goto _L5
            }

            public IBinder prepareDrag(IWindow iwindow, int i, int j, int k, Surface surface) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.view.IWindowSession");
                if(iwindow == null)
                    break MISSING_BLOCK_LABEL_112;
                ibinder = iwindow.asBinder();
_L1:
                IBinder ibinder1;
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeInt(k);
                mRemote.transact(14, parcel, parcel1, 0);
                parcel1.readException();
                ibinder1 = parcel1.readStrongBinder();
                if(parcel1.readInt() != 0)
                    surface.readFromParcel(parcel1);
                parcel1.recycle();
                parcel.recycle();
                return ibinder1;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int relayout(IWindow iwindow, int i, WindowManager.LayoutParams layoutparams, int j, int k, int l, int i1, 
                    Rect rect, Rect rect1, Rect rect2, Configuration configuration, Surface surface) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowSession");
                if(iwindow == null) goto _L2; else goto _L1
_L1:
                IBinder ibinder = iwindow.asBinder();
_L5:
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                if(layoutparams == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                layoutparams.writeToParcel(parcel, 0);
_L6:
                int j1;
                parcel.writeInt(j);
                parcel.writeInt(k);
                parcel.writeInt(l);
                parcel.writeInt(i1);
                mRemote.transact(4, parcel, parcel1, 0);
                parcel1.readException();
                j1 = parcel1.readInt();
                if(parcel1.readInt() != 0)
                    rect.readFromParcel(parcel1);
                if(parcel1.readInt() != 0)
                    rect1.readFromParcel(parcel1);
                if(parcel1.readInt() != 0)
                    rect2.readFromParcel(parcel1);
                if(parcel1.readInt() != 0)
                    configuration.readFromParcel(parcel1);
                if(parcel1.readInt() != 0)
                    surface.readFromParcel(parcel1);
                parcel1.recycle();
                parcel.recycle();
                return j1;
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

            public void remove(IWindow iwindow) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.view.IWindowSession");
                if(iwindow == null)
                    break MISSING_BLOCK_LABEL_59;
                ibinder = iwindow.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(3, parcel, parcel1, 0);
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

            public void reportDropResult(IWindow iwindow, boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.view.IWindowSession");
                if(iwindow == null)
                    break MISSING_BLOCK_LABEL_83;
                ibinder = iwindow.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                if(flag)
                    i = 1;
                parcel.writeInt(i);
                mRemote.transact(16, parcel, parcel1, 0);
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

            public Bundle sendWallpaperCommand(IBinder ibinder, String s, int i, int j, int k, Bundle bundle, boolean flag) throws RemoteException {
                int l;
                Parcel parcel;
                Parcel parcel1;
                l = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowSession");
                parcel.writeStrongBinder(ibinder);
                parcel.writeString(s);
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeInt(k);
                if(bundle == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
                  goto _L3
_L7:
                parcel.writeInt(l);
                mRemote.transact(21, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L5; else goto _L4
_L4:
                Bundle bundle1 = (Bundle)Bundle.CREATOR.createFromParcel(parcel1);
_L6:
                parcel1.recycle();
                parcel.recycle();
                return bundle1;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
_L8:
                l = 0;
                break; /* Loop/switch isn't completed */
_L5:
                bundle1 = null;
                  goto _L6
_L3:
                if(!flag) goto _L8; else goto _L7
            }

            public void setInTouchMode(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowSession");
                if(flag)
                    i = 1;
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

            public void setInsets(IWindow iwindow, int i, Rect rect, Rect rect1, Region region) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowSession");
                if(iwindow == null) goto _L2; else goto _L1
_L1:
                IBinder ibinder = iwindow.asBinder();
_L7:
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                if(rect == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                rect.writeToParcel(parcel, 0);
_L8:
                if(rect1 == null) goto _L6; else goto _L5
_L5:
                parcel.writeInt(1);
                rect1.writeToParcel(parcel, 0);
_L9:
                if(region == null)
                    break MISSING_BLOCK_LABEL_169;
                parcel.writeInt(1);
                region.writeToParcel(parcel, 0);
_L10:
                mRemote.transact(8, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                ibinder = null;
                  goto _L7
_L4:
                parcel.writeInt(0);
                  goto _L8
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
_L6:
                parcel.writeInt(0);
                  goto _L9
                parcel.writeInt(0);
                  goto _L10
            }

            public void setTransparentRegion(IWindow iwindow, Region region) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowSession");
                if(iwindow == null) goto _L2; else goto _L1
_L1:
                IBinder ibinder = iwindow.asBinder();
_L5:
                parcel.writeStrongBinder(ibinder);
                if(region == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                region.writeToParcel(parcel, 0);
_L6:
                mRemote.transact(7, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
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

            public void setWallpaperPosition(IBinder ibinder, float f, float f1, float f2, float f3) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowSession");
                parcel.writeStrongBinder(ibinder);
                parcel.writeFloat(f);
                parcel.writeFloat(f1);
                parcel.writeFloat(f2);
                parcel.writeFloat(f3);
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

            public void wallpaperCommandComplete(IBinder ibinder, Bundle bundle) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowSession");
                parcel.writeStrongBinder(ibinder);
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_66;
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(22, parcel, parcel1, 0);
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

            public void wallpaperOffsetsComplete(IBinder ibinder) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowSession");
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(20, parcel, parcel1, 0);
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IWindowSession asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.view.IWindowSession");
                if(iinterface != null && (iinterface instanceof IWindowSession))
                    obj = (IWindowSession)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IWindowSession) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            i;
            JVM INSTR lookupswitch 23: default 196
        //                       1: 222
        //                       2: 378
        //                       3: 498
        //                       4: 525
        //                       5: 813
        //                       6: 840
        //                       7: 889
        //                       8: 949
        //                       9: 1075
        //                       10: 1142
        //                       11: 1169
        //                       12: 1207
        //                       13: 1249
        //                       14: 1328
        //                       15: 1427
        //                       16: 1549
        //                       17: 1598
        //                       18: 1625
        //                       19: 1652
        //                       20: 1692
        //                       21: 1716
        //                       22: 1850
        //                       1598968902: 210;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24
_L1:
            boolean flag = super.onTransact(i, parcel, parcel1, j);
_L26:
            return flag;
_L24:
            parcel1.writeString("android.view.IWindowSession");
            flag = true;
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.view.IWindowSession");
            IWindow iwindow9 = IWindow.Stub.asInterface(parcel.readStrongBinder());
            int l5 = parcel.readInt();
            WindowManager.LayoutParams layoutparams2;
            int i6;
            Rect rect7;
            InputChannel inputchannel;
            int j6;
            if(parcel.readInt() != 0)
                layoutparams2 = (WindowManager.LayoutParams)WindowManager.LayoutParams.CREATOR.createFromParcel(parcel);
            else
                layoutparams2 = null;
            i6 = parcel.readInt();
            rect7 = new Rect();
            inputchannel = new InputChannel();
            j6 = add(iwindow9, l5, layoutparams2, i6, rect7, inputchannel);
            parcel1.writeNoException();
            parcel1.writeInt(j6);
            if(rect7 != null) {
                parcel1.writeInt(1);
                rect7.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            if(inputchannel != null) {
                parcel1.writeInt(1);
                inputchannel.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag = true;
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.view.IWindowSession");
            IWindow iwindow8 = IWindow.Stub.asInterface(parcel.readStrongBinder());
            int i5 = parcel.readInt();
            WindowManager.LayoutParams layoutparams1;
            int j5;
            Rect rect6;
            int k5;
            if(parcel.readInt() != 0)
                layoutparams1 = (WindowManager.LayoutParams)WindowManager.LayoutParams.CREATOR.createFromParcel(parcel);
            else
                layoutparams1 = null;
            j5 = parcel.readInt();
            rect6 = new Rect();
            k5 = addWithoutInputChannel(iwindow8, i5, layoutparams1, j5, rect6);
            parcel1.writeNoException();
            parcel1.writeInt(k5);
            if(rect6 != null) {
                parcel1.writeInt(1);
                rect6.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag = true;
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.view.IWindowSession");
            remove(IWindow.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.view.IWindowSession");
            IWindow iwindow7 = IWindow.Stub.asInterface(parcel.readStrongBinder());
            int k3 = parcel.readInt();
            WindowManager.LayoutParams layoutparams;
            int l3;
            int i4;
            int j4;
            int k4;
            Rect rect3;
            Rect rect4;
            Rect rect5;
            Configuration configuration;
            Surface surface1;
            int l4;
            if(parcel.readInt() != 0)
                layoutparams = (WindowManager.LayoutParams)WindowManager.LayoutParams.CREATOR.createFromParcel(parcel);
            else
                layoutparams = null;
            l3 = parcel.readInt();
            i4 = parcel.readInt();
            j4 = parcel.readInt();
            k4 = parcel.readInt();
            rect3 = new Rect();
            rect4 = new Rect();
            rect5 = new Rect();
            configuration = new Configuration();
            surface1 = new Surface();
            l4 = relayout(iwindow7, k3, layoutparams, l3, i4, j4, k4, rect3, rect4, rect5, configuration, surface1);
            parcel1.writeNoException();
            parcel1.writeInt(l4);
            if(rect3 != null) {
                parcel1.writeInt(1);
                rect3.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            if(rect4 != null) {
                parcel1.writeInt(1);
                rect4.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            if(rect5 != null) {
                parcel1.writeInt(1);
                rect5.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            if(configuration != null) {
                parcel1.writeInt(1);
                configuration.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            if(surface1 != null) {
                parcel1.writeInt(1);
                surface1.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag = true;
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.view.IWindowSession");
            performDeferredDestroy(IWindow.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.view.IWindowSession");
            boolean flag8 = outOfMemory(IWindow.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            int j3;
            if(flag8)
                j3 = 1;
            else
                j3 = 0;
            parcel1.writeInt(j3);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.view.IWindowSession");
            IWindow iwindow6 = IWindow.Stub.asInterface(parcel.readStrongBinder());
            Region region1;
            if(parcel.readInt() != 0)
                region1 = (Region)Region.CREATOR.createFromParcel(parcel);
            else
                region1 = null;
            setTransparentRegion(iwindow6, region1);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("android.view.IWindowSession");
            IWindow iwindow5 = IWindow.Stub.asInterface(parcel.readStrongBinder());
            int i3 = parcel.readInt();
            Rect rect1;
            Rect rect2;
            Region region;
            if(parcel.readInt() != 0)
                rect1 = (Rect)Rect.CREATOR.createFromParcel(parcel);
            else
                rect1 = null;
            if(parcel.readInt() != 0)
                rect2 = (Rect)Rect.CREATOR.createFromParcel(parcel);
            else
                rect2 = null;
            if(parcel.readInt() != 0)
                region = (Region)Region.CREATOR.createFromParcel(parcel);
            else
                region = null;
            setInsets(iwindow5, i3, rect1, rect2, region);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("android.view.IWindowSession");
            IWindow iwindow4 = IWindow.Stub.asInterface(parcel.readStrongBinder());
            Rect rect = new Rect();
            getDisplayFrame(iwindow4, rect);
            parcel1.writeNoException();
            if(rect != null) {
                parcel1.writeInt(1);
                rect.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag = true;
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("android.view.IWindowSession");
            finishDrawing(IWindow.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("android.view.IWindowSession");
            boolean flag7;
            if(parcel.readInt() != 0)
                flag7 = true;
            else
                flag7 = false;
            setInTouchMode(flag7);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("android.view.IWindowSession");
            boolean flag6 = getInTouchMode();
            parcel1.writeNoException();
            int l2;
            if(flag6)
                l2 = 1;
            else
                l2 = 0;
            parcel1.writeInt(l2);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L14:
            parcel.enforceInterface("android.view.IWindowSession");
            IWindow iwindow3 = IWindow.Stub.asInterface(parcel.readStrongBinder());
            int j2 = parcel.readInt();
            boolean flag4;
            boolean flag5;
            int k2;
            if(parcel.readInt() != 0)
                flag4 = true;
            else
                flag4 = false;
            flag5 = performHapticFeedback(iwindow3, j2, flag4);
            parcel1.writeNoException();
            if(flag5)
                k2 = 1;
            else
                k2 = 0;
            parcel1.writeInt(k2);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L15:
            parcel.enforceInterface("android.view.IWindowSession");
            IWindow iwindow2 = IWindow.Stub.asInterface(parcel.readStrongBinder());
            int k1 = parcel.readInt();
            int l1 = parcel.readInt();
            int i2 = parcel.readInt();
            Surface surface = new Surface();
            IBinder ibinder3 = prepareDrag(iwindow2, k1, l1, i2, surface);
            parcel1.writeNoException();
            parcel1.writeStrongBinder(ibinder3);
            if(surface != null) {
                parcel1.writeInt(1);
                surface.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag = true;
            continue; /* Loop/switch isn't completed */
_L16:
            parcel.enforceInterface("android.view.IWindowSession");
            IWindow iwindow1 = IWindow.Stub.asInterface(parcel.readStrongBinder());
            IBinder ibinder2 = parcel.readStrongBinder();
            float f = parcel.readFloat();
            float f1 = parcel.readFloat();
            float f2 = parcel.readFloat();
            float f3 = parcel.readFloat();
            ClipData clipdata;
            boolean flag3;
            int j1;
            if(parcel.readInt() != 0)
                clipdata = (ClipData)ClipData.CREATOR.createFromParcel(parcel);
            else
                clipdata = null;
            flag3 = performDrag(iwindow1, ibinder2, f, f1, f2, f3, clipdata);
            parcel1.writeNoException();
            if(flag3)
                j1 = 1;
            else
                j1 = 0;
            parcel1.writeInt(j1);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L17:
            parcel.enforceInterface("android.view.IWindowSession");
            IWindow iwindow = IWindow.Stub.asInterface(parcel.readStrongBinder());
            boolean flag2;
            if(parcel.readInt() != 0)
                flag2 = true;
            else
                flag2 = false;
            reportDropResult(iwindow, flag2);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L18:
            parcel.enforceInterface("android.view.IWindowSession");
            dragRecipientEntered(IWindow.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L19:
            parcel.enforceInterface("android.view.IWindowSession");
            dragRecipientExited(IWindow.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L20:
            parcel.enforceInterface("android.view.IWindowSession");
            setWallpaperPosition(parcel.readStrongBinder(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L21:
            parcel.enforceInterface("android.view.IWindowSession");
            wallpaperOffsetsComplete(parcel.readStrongBinder());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L22:
            parcel.enforceInterface("android.view.IWindowSession");
            IBinder ibinder1 = parcel.readStrongBinder();
            String s = parcel.readString();
            int k = parcel.readInt();
            int l = parcel.readInt();
            int i1 = parcel.readInt();
            Bundle bundle1;
            boolean flag1;
            Bundle bundle2;
            if(parcel.readInt() != 0)
                bundle1 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle1 = null;
            if(parcel.readInt() != 0)
                flag1 = true;
            else
                flag1 = false;
            bundle2 = sendWallpaperCommand(ibinder1, s, k, l, i1, bundle1, flag1);
            parcel1.writeNoException();
            if(bundle2 != null) {
                parcel1.writeInt(1);
                bundle2.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag = true;
            continue; /* Loop/switch isn't completed */
_L23:
            parcel.enforceInterface("android.view.IWindowSession");
            IBinder ibinder = parcel.readStrongBinder();
            Bundle bundle;
            if(parcel.readInt() != 0)
                bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle = null;
            wallpaperCommandComplete(ibinder, bundle);
            parcel1.writeNoException();
            flag = true;
            if(true) goto _L26; else goto _L25
_L25:
        }

        private static final String DESCRIPTOR = "android.view.IWindowSession";
        static final int TRANSACTION_add = 1;
        static final int TRANSACTION_addWithoutInputChannel = 2;
        static final int TRANSACTION_dragRecipientEntered = 17;
        static final int TRANSACTION_dragRecipientExited = 18;
        static final int TRANSACTION_finishDrawing = 10;
        static final int TRANSACTION_getDisplayFrame = 9;
        static final int TRANSACTION_getInTouchMode = 12;
        static final int TRANSACTION_outOfMemory = 6;
        static final int TRANSACTION_performDeferredDestroy = 5;
        static final int TRANSACTION_performDrag = 15;
        static final int TRANSACTION_performHapticFeedback = 13;
        static final int TRANSACTION_prepareDrag = 14;
        static final int TRANSACTION_relayout = 4;
        static final int TRANSACTION_remove = 3;
        static final int TRANSACTION_reportDropResult = 16;
        static final int TRANSACTION_sendWallpaperCommand = 21;
        static final int TRANSACTION_setInTouchMode = 11;
        static final int TRANSACTION_setInsets = 8;
        static final int TRANSACTION_setTransparentRegion = 7;
        static final int TRANSACTION_setWallpaperPosition = 19;
        static final int TRANSACTION_wallpaperCommandComplete = 22;
        static final int TRANSACTION_wallpaperOffsetsComplete = 20;

        public Stub() {
            attachInterface(this, "android.view.IWindowSession");
        }
    }


    public abstract int add(IWindow iwindow, int i, WindowManager.LayoutParams layoutparams, int j, Rect rect, InputChannel inputchannel) throws RemoteException;

    public abstract int addWithoutInputChannel(IWindow iwindow, int i, WindowManager.LayoutParams layoutparams, int j, Rect rect) throws RemoteException;

    public abstract void dragRecipientEntered(IWindow iwindow) throws RemoteException;

    public abstract void dragRecipientExited(IWindow iwindow) throws RemoteException;

    public abstract void finishDrawing(IWindow iwindow) throws RemoteException;

    public abstract void getDisplayFrame(IWindow iwindow, Rect rect) throws RemoteException;

    public abstract boolean getInTouchMode() throws RemoteException;

    public abstract boolean outOfMemory(IWindow iwindow) throws RemoteException;

    public abstract void performDeferredDestroy(IWindow iwindow) throws RemoteException;

    public abstract boolean performDrag(IWindow iwindow, IBinder ibinder, float f, float f1, float f2, float f3, ClipData clipdata) throws RemoteException;

    public abstract boolean performHapticFeedback(IWindow iwindow, int i, boolean flag) throws RemoteException;

    public abstract IBinder prepareDrag(IWindow iwindow, int i, int j, int k, Surface surface) throws RemoteException;

    public abstract int relayout(IWindow iwindow, int i, WindowManager.LayoutParams layoutparams, int j, int k, int l, int i1, 
            Rect rect, Rect rect1, Rect rect2, Configuration configuration, Surface surface) throws RemoteException;

    public abstract void remove(IWindow iwindow) throws RemoteException;

    public abstract void reportDropResult(IWindow iwindow, boolean flag) throws RemoteException;

    public abstract Bundle sendWallpaperCommand(IBinder ibinder, String s, int i, int j, int k, Bundle bundle, boolean flag) throws RemoteException;

    public abstract void setInTouchMode(boolean flag) throws RemoteException;

    public abstract void setInsets(IWindow iwindow, int i, Rect rect, Rect rect1, Region region) throws RemoteException;

    public abstract void setTransparentRegion(IWindow iwindow, Region region) throws RemoteException;

    public abstract void setWallpaperPosition(IBinder ibinder, float f, float f1, float f2, float f3) throws RemoteException;

    public abstract void wallpaperCommandComplete(IBinder ibinder, Bundle bundle) throws RemoteException;

    public abstract void wallpaperOffsetsComplete(IBinder ibinder) throws RemoteException;
}

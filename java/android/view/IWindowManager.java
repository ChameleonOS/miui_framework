// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.*;
import android.text.TextUtils;
import com.android.internal.view.IInputContext;
import com.android.internal.view.IInputMethodClient;
import java.util.List;

// Referenced classes of package android.view:
//            IApplicationToken, IOnKeyguardExitResult, IWindowSession, IRotationWatcher

public interface IWindowManager
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IWindowManager {
        private static class Proxy
            implements IWindowManager {

            public void addAppToken(int i, IApplicationToken iapplicationtoken, int j, int k, boolean flag) throws RemoteException {
                int l;
                Parcel parcel;
                Parcel parcel1;
                l = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.view.IWindowManager");
                parcel.writeInt(i);
                if(iapplicationtoken == null)
                    break MISSING_BLOCK_LABEL_106;
                ibinder = iapplicationtoken.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(j);
                parcel.writeInt(k);
                if(flag)
                    l = 1;
                parcel.writeInt(l);
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

            public void addWindowToken(IBinder ibinder, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
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

            public IBinder asBinder() {
                return mRemote;
            }

            public void clearForcedDisplaySize() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
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

            public void closeSystemDialogs(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                parcel.writeString(s);
                mRemote.transact(47, parcel, parcel1, 0);
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

            public void disableKeyguard(IBinder ibinder, String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                parcel.writeStrongBinder(ibinder);
                parcel.writeString(s);
                mRemote.transact(40, parcel, parcel1, 0);
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

            public void dismissKeyguard() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                mRemote.transact(46, parcel, parcel1, 0);
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

            public void executeAppTransition() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                mRemote.transact(28, parcel, parcel1, 0);
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

            public void exitKeyguardSecurely(IOnKeyguardExitResult ionkeyguardexitresult) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.view.IWindowManager");
                if(ionkeyguardexitresult == null)
                    break MISSING_BLOCK_LABEL_60;
                ibinder = ionkeyguardexitresult.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(42, parcel, parcel1, 0);
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

            public void freezeRotation(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                parcel.writeInt(i);
                mRemote.transact(59, parcel, parcel1, 0);
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

            public float getAnimationScale(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                float f;
                parcel.writeInterfaceToken("android.view.IWindowManager");
                parcel.writeInt(i);
                mRemote.transact(48, parcel, parcel1, 0);
                parcel1.readException();
                f = parcel1.readFloat();
                parcel1.recycle();
                parcel.recycle();
                return f;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public float[] getAnimationScales() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                float af[];
                parcel.writeInterfaceToken("android.view.IWindowManager");
                mRemote.transact(49, parcel, parcel1, 0);
                parcel1.readException();
                af = parcel1.createFloatArray();
                parcel1.recycle();
                parcel.recycle();
                return af;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getAppOrientation(IApplicationToken iapplicationtoken) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.view.IWindowManager");
                if(iapplicationtoken == null)
                    break MISSING_BLOCK_LABEL_68;
                ibinder = iapplicationtoken.asBinder();
_L1:
                int i;
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(21, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void getCurrentSizeRange(Point point, Point point1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                mRemote.transact(9, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() != 0)
                    point.readFromParcel(parcel1);
                if(parcel1.readInt() != 0)
                    point1.readFromParcel(parcel1);
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void getDisplaySize(Point point) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                mRemote.transact(6, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() != 0)
                    point.readFromParcel(parcel1);
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
                return "android.view.IWindowManager";
            }

            public int getMaximumSizeDimension() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.view.IWindowManager");
                mRemote.transact(8, parcel, parcel1, 0);
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

            public int getPendingAppTransition() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.view.IWindowManager");
                mRemote.transact(24, parcel, parcel1, 0);
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

            public int getPreferredOptionsPanelGravity() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.view.IWindowManager");
                mRemote.transact(58, parcel, parcel1, 0);
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

            public void getRealDisplaySize(Point point) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                mRemote.transact(7, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() != 0)
                    point.readFromParcel(parcel1);
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getRotation() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.view.IWindowManager");
                mRemote.transact(56, parcel, parcel1, 0);
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

            public boolean hasNavigationBar() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.view.IWindowManager");
                mRemote.transact(64, parcel, parcel1, 0);
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

            public boolean hasSystemNavBar() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.view.IWindowManager");
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

            public boolean inKeyguardRestrictedInputMode() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.view.IWindowManager");
                mRemote.transact(45, parcel, parcel1, 0);
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

            public boolean inputMethodClientHasFocus(IInputMethodClient iinputmethodclient) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.view.IWindowManager");
                if(iinputmethodclient == null)
                    break MISSING_BLOCK_LABEL_80;
                ibinder = iinputmethodclient.asBinder();
_L1:
                int i;
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(5, parcel, parcel1, 0);
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

            public boolean isKeyguardLocked() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.view.IWindowManager");
                mRemote.transact(43, parcel, parcel1, 0);
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

            public boolean isKeyguardSecure() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.view.IWindowManager");
                mRemote.transact(44, parcel, parcel1, 0);
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

            public boolean isViewServerRunning() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.view.IWindowManager");
                mRemote.transact(3, parcel, parcel1, 0);
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

            public void lockNow() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                mRemote.transact(65, parcel, parcel1, 0);
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

            public void moveAppToken(int i, IBinder ibinder) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                parcel.writeInt(i);
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(35, parcel, parcel1, 0);
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

            public void moveAppTokensToBottom(List list) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                parcel.writeBinderList(list);
                mRemote.transact(37, parcel, parcel1, 0);
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

            public void moveAppTokensToTop(List list) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                parcel.writeBinderList(list);
                mRemote.transact(36, parcel, parcel1, 0);
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

            public IWindowSession openSession(IInputMethodClient iinputmethodclient, IInputContext iinputcontext) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                Parcel parcel1;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder1;
                parcel.writeInterfaceToken("android.view.IWindowManager");
                if(iinputmethodclient == null)
                    break MISSING_BLOCK_LABEL_99;
                ibinder1 = iinputmethodclient.asBinder();
_L1:
                IWindowSession iwindowsession;
                parcel.writeStrongBinder(ibinder1);
                if(iinputcontext != null)
                    ibinder = iinputcontext.asBinder();
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(4, parcel, parcel1, 0);
                parcel1.readException();
                iwindowsession = IWindowSession.Stub.asInterface(parcel1.readStrongBinder());
                parcel1.recycle();
                parcel.recycle();
                return iwindowsession;
                ibinder1 = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void overridePendingAppTransition(String s, int i, int j, IRemoteCallback iremotecallback) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.view.IWindowManager");
                parcel.writeString(s);
                parcel.writeInt(i);
                parcel.writeInt(j);
                if(iremotecallback == null)
                    break MISSING_BLOCK_LABEL_89;
                ibinder = iremotecallback.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(25, parcel, parcel1, 0);
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

            public void overridePendingAppTransitionScaleUp(int i, int j, int k, int l) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeInt(k);
                parcel.writeInt(l);
                mRemote.transact(26, parcel, parcel1, 0);
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

            public void overridePendingAppTransitionThumb(Bitmap bitmap, int i, int j, IRemoteCallback iremotecallback, boolean flag) throws RemoteException {
                int k;
                Parcel parcel;
                Parcel parcel1;
                k = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                if(bitmap == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                bitmap.writeToParcel(parcel, 0);
_L3:
                IBinder ibinder;
                parcel.writeInt(i);
                parcel.writeInt(j);
                if(iremotecallback == null)
                    break MISSING_BLOCK_LABEL_139;
                ibinder = iremotecallback.asBinder();
_L4:
                parcel.writeStrongBinder(ibinder);
                Exception exception;
                if(!flag)
                    k = 0;
                parcel.writeInt(k);
                mRemote.transact(27, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                parcel.writeInt(0);
                  goto _L3
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                ibinder = null;
                  goto _L4
            }

            public void pauseKeyDispatching(IBinder ibinder) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                parcel.writeStrongBinder(ibinder);
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

            public void prepareAppTransition(int i, boolean flag) throws RemoteException {
                int j;
                Parcel parcel;
                Parcel parcel1;
                j = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                parcel.writeInt(i);
                if(flag)
                    j = 1;
                parcel.writeInt(j);
                mRemote.transact(23, parcel, parcel1, 0);
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

            public void reenableKeyguard(IBinder ibinder) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(41, parcel, parcel1, 0);
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

            public void removeAppToken(IBinder ibinder) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(34, parcel, parcel1, 0);
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

            public void removeWindowToken(IBinder ibinder) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                parcel.writeStrongBinder(ibinder);
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

            public void resumeKeyDispatching(IBinder ibinder) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(14, parcel, parcel1, 0);
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

            public Bitmap screenshotApplications(IBinder ibinder, int i, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(61, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                Bitmap bitmap = (Bitmap)Bitmap.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return bitmap;
_L2:
                bitmap = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void setAnimationScale(int i, float f) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                parcel.writeInt(i);
                parcel.writeFloat(f);
                mRemote.transact(50, parcel, parcel1, 0);
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

            public void setAnimationScales(float af[]) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                parcel.writeFloatArray(af);
                mRemote.transact(51, parcel, parcel1, 0);
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

            public void setAppGroupId(IBinder ibinder, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
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

            public void setAppOrientation(IApplicationToken iapplicationtoken, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.view.IWindowManager");
                if(iapplicationtoken == null)
                    break MISSING_BLOCK_LABEL_69;
                ibinder = iapplicationtoken.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                mRemote.transact(20, parcel, parcel1, 0);
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

            public void setAppStartingWindow(IBinder ibinder, String s, int i, CompatibilityInfo compatibilityinfo, CharSequence charsequence, int j, int k, 
                    int l, IBinder ibinder1, boolean flag) throws RemoteException {
                int i1;
                Parcel parcel;
                Parcel parcel1;
                i1 = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                parcel.writeStrongBinder(ibinder);
                parcel.writeString(s);
                parcel.writeInt(i);
                if(compatibilityinfo == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                compatibilityinfo.writeToParcel(parcel, 0);
_L3:
                if(charsequence == null)
                    break MISSING_BLOCK_LABEL_173;
                parcel.writeInt(1);
                TextUtils.writeToParcel(charsequence, parcel, 0);
_L4:
                parcel.writeInt(j);
                parcel.writeInt(k);
                parcel.writeInt(l);
                parcel.writeStrongBinder(ibinder1);
                Exception exception;
                if(!flag)
                    i1 = 0;
                parcel.writeInt(i1);
                mRemote.transact(29, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                parcel.writeInt(0);
                  goto _L3
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                parcel.writeInt(0);
                  goto _L4
            }

            public void setAppVisibility(IBinder ibinder, boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                parcel.writeStrongBinder(ibinder);
                if(flag)
                    i = 1;
                parcel.writeInt(i);
                mRemote.transact(31, parcel, parcel1, 0);
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

            public void setAppWillBeHidden(IBinder ibinder) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(30, parcel, parcel1, 0);
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

            public void setEventDispatching(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                if(flag)
                    i = 1;
                parcel.writeInt(i);
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

            public void setFocusedApp(IBinder ibinder, boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                parcel.writeStrongBinder(ibinder);
                if(flag)
                    i = 1;
                parcel.writeInt(i);
                mRemote.transact(22, parcel, parcel1, 0);
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

            public void setForcedDisplaySize(int i, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(10, parcel, parcel1, 0);
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

            public void setInTouchMode(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                if(flag)
                    i = 1;
                parcel.writeInt(i);
                mRemote.transact(52, parcel, parcel1, 0);
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

            public void setNewConfiguration(Configuration configuration) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                if(configuration == null)
                    break MISSING_BLOCK_LABEL_57;
                parcel.writeInt(1);
                configuration.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(39, parcel, parcel1, 0);
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

            public void setStrictModeVisualIndicatorPreference(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                parcel.writeString(s);
                mRemote.transact(54, parcel, parcel1, 0);
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

            public void showStrictModeViolation(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                if(flag)
                    i = 1;
                parcel.writeInt(i);
                mRemote.transact(53, parcel, parcel1, 0);
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

            public void startAppFreezingScreen(IBinder ibinder, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                mRemote.transact(32, parcel, parcel1, 0);
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

            public boolean startViewServer(int i) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.view.IWindowManager");
                parcel.writeInt(i);
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                if(j == 0)
                    flag = false;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void statusBarVisibilityChanged(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                parcel.writeInt(i);
                mRemote.transact(62, parcel, parcel1, 0);
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

            public void stopAppFreezingScreen(IBinder ibinder, boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                parcel.writeStrongBinder(ibinder);
                if(flag)
                    i = 1;
                parcel.writeInt(i);
                mRemote.transact(33, parcel, parcel1, 0);
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

            public boolean stopViewServer() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.view.IWindowManager");
                mRemote.transact(2, parcel, parcel1, 0);
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

            public void thawRotation() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                mRemote.transact(60, parcel, parcel1, 0);
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

            public Configuration updateOrientationFromAppTokens(Configuration configuration, IBinder ibinder) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IWindowManager");
                if(configuration == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                configuration.writeToParcel(parcel, 0);
_L3:
                Configuration configuration1;
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(38, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0)
                    break MISSING_BLOCK_LABEL_113;
                configuration1 = (Configuration)Configuration.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return configuration1;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                configuration1 = null;
                  goto _L4
            }

            public void updateRotation(boolean flag, boolean flag1) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.view.IWindowManager");
                if(!flag)
                    break MISSING_BLOCK_LABEL_76;
                j = i;
_L1:
                parcel.writeInt(j);
                if(!flag1)
                    i = 0;
                parcel.writeInt(i);
                mRemote.transact(55, parcel, parcel1, 0);
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

            public void waitForWindowDrawn(IBinder ibinder, IRemoteCallback iremotecallback) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder1;
                parcel.writeInterfaceToken("android.view.IWindowManager");
                parcel.writeStrongBinder(ibinder);
                if(iremotecallback == null)
                    break MISSING_BLOCK_LABEL_69;
                ibinder1 = iremotecallback.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder1);
                mRemote.transact(63, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                ibinder1 = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int watchRotation(IRotationWatcher irotationwatcher) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.view.IWindowManager");
                if(irotationwatcher == null)
                    break MISSING_BLOCK_LABEL_68;
                ibinder = irotationwatcher.asBinder();
_L1:
                int i;
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(57, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                ibinder = null;
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


        public static IWindowManager asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.view.IWindowManager");
                if(iinterface != null && (iinterface instanceof IWindowManager))
                    obj = (IWindowManager)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IWindowManager) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            i;
            JVM INSTR lookupswitch 66: default 540
        //                       1: 566
        //                       2: 612
        //                       3: 654
        //                       4: 696
        //                       5: 758
        //                       6: 807
        //                       7: 863
        //                       8: 919
        //                       9: 947
        //                       10: 1039
        //                       11: 1067
        //                       12: 1087
        //                       13: 1129
        //                       14: 1153
        //                       15: 1177
        //                       16: 1215
        //                       17: 1243
        //                       18: 1267
        //                       19: 1340
        //                       20: 1368
        //                       21: 1399
        //                       22: 1434
        //                       23: 1480
        //                       24: 1526
        //                       25: 1554
        //                       26: 1593
        //                       27: 1629
        //                       28: 1723
        //                       29: 1743
        //                       30: 1895
        //                       31: 1919
        //                       32: 1965
        //                       33: 1993
        //                       34: 2039
        //                       35: 2063
        //                       36: 2091
        //                       37: 2115
        //                       38: 2139
        //                       39: 2219
        //                       40: 2268
        //                       41: 2296
        //                       42: 2320
        //                       43: 2347
        //                       44: 2389
        //                       45: 2431
        //                       46: 2473
        //                       47: 2493
        //                       48: 2517
        //                       49: 2549
        //                       50: 2577
        //                       51: 2605
        //                       52: 2629
        //                       53: 2667
        //                       54: 2705
        //                       55: 2729
        //                       56: 2785
        //                       57: 2813
        //                       58: 2848
        //                       59: 2876
        //                       60: 2900
        //                       61: 2920
        //                       62: 2979
        //                       63: 3003
        //                       64: 3034
        //                       65: 3076
        //                       1598968902: 554;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36 _L37 _L38 _L39 _L40 _L41 _L42 _L43 _L44 _L45 _L46 _L47 _L48 _L49 _L50 _L51 _L52 _L53 _L54 _L55 _L56 _L57 _L58 _L59 _L60 _L61 _L62 _L63 _L64 _L65 _L66 _L67
_L1:
            boolean flag = super.onTransact(i, parcel, parcel1, j);
_L69:
            return flag;
_L67:
            parcel1.writeString("android.view.IWindowManager");
            flag = true;
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.view.IWindowManager");
            boolean flag21 = startViewServer(parcel.readInt());
            parcel1.writeNoException();
            int k6;
            if(flag21)
                k6 = 1;
            else
                k6 = 0;
            parcel1.writeInt(k6);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.view.IWindowManager");
            boolean flag20 = stopViewServer();
            parcel1.writeNoException();
            int j6;
            if(flag20)
                j6 = 1;
            else
                j6 = 0;
            parcel1.writeInt(j6);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.view.IWindowManager");
            boolean flag19 = isViewServerRunning();
            parcel1.writeNoException();
            int i6;
            if(flag19)
                i6 = 1;
            else
                i6 = 0;
            parcel1.writeInt(i6);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.view.IWindowManager");
            IWindowSession iwindowsession = openSession(com.android.internal.view.IInputMethodClient.Stub.asInterface(parcel.readStrongBinder()), com.android.internal.view.IInputContext.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            IBinder ibinder5;
            if(iwindowsession != null)
                ibinder5 = iwindowsession.asBinder();
            else
                ibinder5 = null;
            parcel1.writeStrongBinder(ibinder5);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.view.IWindowManager");
            boolean flag18 = inputMethodClientHasFocus(com.android.internal.view.IInputMethodClient.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            int l5;
            if(flag18)
                l5 = 1;
            else
                l5 = 0;
            parcel1.writeInt(l5);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.view.IWindowManager");
            Point point3 = new Point();
            getDisplaySize(point3);
            parcel1.writeNoException();
            if(point3 != null) {
                parcel1.writeInt(1);
                point3.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag = true;
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.view.IWindowManager");
            Point point2 = new Point();
            getRealDisplaySize(point2);
            parcel1.writeNoException();
            if(point2 != null) {
                parcel1.writeInt(1);
                point2.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag = true;
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("android.view.IWindowManager");
            int k5 = getMaximumSizeDimension();
            parcel1.writeNoException();
            parcel1.writeInt(k5);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("android.view.IWindowManager");
            Point point = new Point();
            Point point1 = new Point();
            getCurrentSizeRange(point, point1);
            parcel1.writeNoException();
            if(point != null) {
                parcel1.writeInt(1);
                point.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            if(point1 != null) {
                parcel1.writeInt(1);
                point1.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag = true;
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("android.view.IWindowManager");
            setForcedDisplaySize(parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("android.view.IWindowManager");
            clearForcedDisplaySize();
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("android.view.IWindowManager");
            boolean flag17 = hasSystemNavBar();
            parcel1.writeNoException();
            int j5;
            if(flag17)
                j5 = 1;
            else
                j5 = 0;
            parcel1.writeInt(j5);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L14:
            parcel.enforceInterface("android.view.IWindowManager");
            pauseKeyDispatching(parcel.readStrongBinder());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L15:
            parcel.enforceInterface("android.view.IWindowManager");
            resumeKeyDispatching(parcel.readStrongBinder());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L16:
            parcel.enforceInterface("android.view.IWindowManager");
            boolean flag16;
            if(parcel.readInt() != 0)
                flag16 = true;
            else
                flag16 = false;
            setEventDispatching(flag16);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L17:
            parcel.enforceInterface("android.view.IWindowManager");
            addWindowToken(parcel.readStrongBinder(), parcel.readInt());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L18:
            parcel.enforceInterface("android.view.IWindowManager");
            removeWindowToken(parcel.readStrongBinder());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L19:
            parcel.enforceInterface("android.view.IWindowManager");
            int k4 = parcel.readInt();
            IApplicationToken iapplicationtoken = IApplicationToken.Stub.asInterface(parcel.readStrongBinder());
            int l4 = parcel.readInt();
            int i5 = parcel.readInt();
            boolean flag15;
            if(parcel.readInt() != 0)
                flag15 = true;
            else
                flag15 = false;
            addAppToken(k4, iapplicationtoken, l4, i5, flag15);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L20:
            parcel.enforceInterface("android.view.IWindowManager");
            setAppGroupId(parcel.readStrongBinder(), parcel.readInt());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L21:
            parcel.enforceInterface("android.view.IWindowManager");
            setAppOrientation(IApplicationToken.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L22:
            parcel.enforceInterface("android.view.IWindowManager");
            int j4 = getAppOrientation(IApplicationToken.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            parcel1.writeInt(j4);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L23:
            parcel.enforceInterface("android.view.IWindowManager");
            IBinder ibinder4 = parcel.readStrongBinder();
            boolean flag14;
            if(parcel.readInt() != 0)
                flag14 = true;
            else
                flag14 = false;
            setFocusedApp(ibinder4, flag14);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L24:
            parcel.enforceInterface("android.view.IWindowManager");
            int i4 = parcel.readInt();
            boolean flag13;
            if(parcel.readInt() != 0)
                flag13 = true;
            else
                flag13 = false;
            prepareAppTransition(i4, flag13);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L25:
            parcel.enforceInterface("android.view.IWindowManager");
            int l3 = getPendingAppTransition();
            parcel1.writeNoException();
            parcel1.writeInt(l3);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L26:
            parcel.enforceInterface("android.view.IWindowManager");
            overridePendingAppTransition(parcel.readString(), parcel.readInt(), parcel.readInt(), android.os.IRemoteCallback.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L27:
            parcel.enforceInterface("android.view.IWindowManager");
            overridePendingAppTransitionScaleUp(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L28:
            parcel.enforceInterface("android.view.IWindowManager");
            Bitmap bitmap1;
            int j3;
            int k3;
            IRemoteCallback iremotecallback;
            boolean flag12;
            if(parcel.readInt() != 0)
                bitmap1 = (Bitmap)Bitmap.CREATOR.createFromParcel(parcel);
            else
                bitmap1 = null;
            j3 = parcel.readInt();
            k3 = parcel.readInt();
            iremotecallback = android.os.IRemoteCallback.Stub.asInterface(parcel.readStrongBinder());
            if(parcel.readInt() != 0)
                flag12 = true;
            else
                flag12 = false;
            overridePendingAppTransitionThumb(bitmap1, j3, k3, iremotecallback, flag12);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L29:
            parcel.enforceInterface("android.view.IWindowManager");
            executeAppTransition();
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L30:
            parcel.enforceInterface("android.view.IWindowManager");
            IBinder ibinder2 = parcel.readStrongBinder();
            String s = parcel.readString();
            int j2 = parcel.readInt();
            CompatibilityInfo compatibilityinfo;
            CharSequence charsequence;
            int k2;
            int l2;
            int i3;
            IBinder ibinder3;
            boolean flag11;
            if(parcel.readInt() != 0)
                compatibilityinfo = (CompatibilityInfo)CompatibilityInfo.CREATOR.createFromParcel(parcel);
            else
                compatibilityinfo = null;
            if(parcel.readInt() != 0)
                charsequence = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            else
                charsequence = null;
            k2 = parcel.readInt();
            l2 = parcel.readInt();
            i3 = parcel.readInt();
            ibinder3 = parcel.readStrongBinder();
            if(parcel.readInt() != 0)
                flag11 = true;
            else
                flag11 = false;
            setAppStartingWindow(ibinder2, s, j2, compatibilityinfo, charsequence, k2, l2, i3, ibinder3, flag11);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L31:
            parcel.enforceInterface("android.view.IWindowManager");
            setAppWillBeHidden(parcel.readStrongBinder());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L32:
            parcel.enforceInterface("android.view.IWindowManager");
            IBinder ibinder1 = parcel.readStrongBinder();
            boolean flag10;
            if(parcel.readInt() != 0)
                flag10 = true;
            else
                flag10 = false;
            setAppVisibility(ibinder1, flag10);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L33:
            parcel.enforceInterface("android.view.IWindowManager");
            startAppFreezingScreen(parcel.readStrongBinder(), parcel.readInt());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L34:
            parcel.enforceInterface("android.view.IWindowManager");
            IBinder ibinder = parcel.readStrongBinder();
            boolean flag9;
            if(parcel.readInt() != 0)
                flag9 = true;
            else
                flag9 = false;
            stopAppFreezingScreen(ibinder, flag9);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L35:
            parcel.enforceInterface("android.view.IWindowManager");
            removeAppToken(parcel.readStrongBinder());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L36:
            parcel.enforceInterface("android.view.IWindowManager");
            moveAppToken(parcel.readInt(), parcel.readStrongBinder());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L37:
            parcel.enforceInterface("android.view.IWindowManager");
            moveAppTokensToTop(parcel.createBinderArrayList());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L38:
            parcel.enforceInterface("android.view.IWindowManager");
            moveAppTokensToBottom(parcel.createBinderArrayList());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L39:
            parcel.enforceInterface("android.view.IWindowManager");
            Configuration configuration1;
            Configuration configuration2;
            if(parcel.readInt() != 0)
                configuration1 = (Configuration)Configuration.CREATOR.createFromParcel(parcel);
            else
                configuration1 = null;
            configuration2 = updateOrientationFromAppTokens(configuration1, parcel.readStrongBinder());
            parcel1.writeNoException();
            if(configuration2 != null) {
                parcel1.writeInt(1);
                configuration2.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag = true;
            continue; /* Loop/switch isn't completed */
_L40:
            parcel.enforceInterface("android.view.IWindowManager");
            Configuration configuration;
            if(parcel.readInt() != 0)
                configuration = (Configuration)Configuration.CREATOR.createFromParcel(parcel);
            else
                configuration = null;
            setNewConfiguration(configuration);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L41:
            parcel.enforceInterface("android.view.IWindowManager");
            disableKeyguard(parcel.readStrongBinder(), parcel.readString());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L42:
            parcel.enforceInterface("android.view.IWindowManager");
            reenableKeyguard(parcel.readStrongBinder());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L43:
            parcel.enforceInterface("android.view.IWindowManager");
            exitKeyguardSecurely(IOnKeyguardExitResult.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L44:
            parcel.enforceInterface("android.view.IWindowManager");
            boolean flag8 = isKeyguardLocked();
            parcel1.writeNoException();
            int i2;
            if(flag8)
                i2 = 1;
            else
                i2 = 0;
            parcel1.writeInt(i2);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L45:
            parcel.enforceInterface("android.view.IWindowManager");
            boolean flag7 = isKeyguardSecure();
            parcel1.writeNoException();
            int l1;
            if(flag7)
                l1 = 1;
            else
                l1 = 0;
            parcel1.writeInt(l1);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L46:
            parcel.enforceInterface("android.view.IWindowManager");
            boolean flag6 = inKeyguardRestrictedInputMode();
            parcel1.writeNoException();
            int k1;
            if(flag6)
                k1 = 1;
            else
                k1 = 0;
            parcel1.writeInt(k1);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L47:
            parcel.enforceInterface("android.view.IWindowManager");
            dismissKeyguard();
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L48:
            parcel.enforceInterface("android.view.IWindowManager");
            closeSystemDialogs(parcel.readString());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L49:
            parcel.enforceInterface("android.view.IWindowManager");
            float f = getAnimationScale(parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeFloat(f);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L50:
            parcel.enforceInterface("android.view.IWindowManager");
            float af[] = getAnimationScales();
            parcel1.writeNoException();
            parcel1.writeFloatArray(af);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L51:
            parcel.enforceInterface("android.view.IWindowManager");
            setAnimationScale(parcel.readInt(), parcel.readFloat());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L52:
            parcel.enforceInterface("android.view.IWindowManager");
            setAnimationScales(parcel.createFloatArray());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L53:
            parcel.enforceInterface("android.view.IWindowManager");
            boolean flag5;
            if(parcel.readInt() != 0)
                flag5 = true;
            else
                flag5 = false;
            setInTouchMode(flag5);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L54:
            parcel.enforceInterface("android.view.IWindowManager");
            boolean flag4;
            if(parcel.readInt() != 0)
                flag4 = true;
            else
                flag4 = false;
            showStrictModeViolation(flag4);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L55:
            parcel.enforceInterface("android.view.IWindowManager");
            setStrictModeVisualIndicatorPreference(parcel.readString());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L56:
            parcel.enforceInterface("android.view.IWindowManager");
            boolean flag2;
            boolean flag3;
            if(parcel.readInt() != 0)
                flag2 = true;
            else
                flag2 = false;
            if(parcel.readInt() != 0)
                flag3 = true;
            else
                flag3 = false;
            updateRotation(flag2, flag3);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L57:
            parcel.enforceInterface("android.view.IWindowManager");
            int j1 = getRotation();
            parcel1.writeNoException();
            parcel1.writeInt(j1);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L58:
            parcel.enforceInterface("android.view.IWindowManager");
            int i1 = watchRotation(IRotationWatcher.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            parcel1.writeInt(i1);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L59:
            parcel.enforceInterface("android.view.IWindowManager");
            int l = getPreferredOptionsPanelGravity();
            parcel1.writeNoException();
            parcel1.writeInt(l);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L60:
            parcel.enforceInterface("android.view.IWindowManager");
            freezeRotation(parcel.readInt());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L61:
            parcel.enforceInterface("android.view.IWindowManager");
            thawRotation();
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L62:
            parcel.enforceInterface("android.view.IWindowManager");
            Bitmap bitmap = screenshotApplications(parcel.readStrongBinder(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            if(bitmap != null) {
                parcel1.writeInt(1);
                bitmap.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag = true;
            continue; /* Loop/switch isn't completed */
_L63:
            parcel.enforceInterface("android.view.IWindowManager");
            statusBarVisibilityChanged(parcel.readInt());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L64:
            parcel.enforceInterface("android.view.IWindowManager");
            waitForWindowDrawn(parcel.readStrongBinder(), android.os.IRemoteCallback.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L65:
            parcel.enforceInterface("android.view.IWindowManager");
            boolean flag1 = hasNavigationBar();
            parcel1.writeNoException();
            int k;
            if(flag1)
                k = 1;
            else
                k = 0;
            parcel1.writeInt(k);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L66:
            parcel.enforceInterface("android.view.IWindowManager");
            lockNow();
            parcel1.writeNoException();
            flag = true;
            if(true) goto _L69; else goto _L68
_L68:
        }

        private static final String DESCRIPTOR = "android.view.IWindowManager";
        static final int TRANSACTION_addAppToken = 18;
        static final int TRANSACTION_addWindowToken = 16;
        static final int TRANSACTION_clearForcedDisplaySize = 11;
        static final int TRANSACTION_closeSystemDialogs = 47;
        static final int TRANSACTION_disableKeyguard = 40;
        static final int TRANSACTION_dismissKeyguard = 46;
        static final int TRANSACTION_executeAppTransition = 28;
        static final int TRANSACTION_exitKeyguardSecurely = 42;
        static final int TRANSACTION_freezeRotation = 59;
        static final int TRANSACTION_getAnimationScale = 48;
        static final int TRANSACTION_getAnimationScales = 49;
        static final int TRANSACTION_getAppOrientation = 21;
        static final int TRANSACTION_getCurrentSizeRange = 9;
        static final int TRANSACTION_getDisplaySize = 6;
        static final int TRANSACTION_getMaximumSizeDimension = 8;
        static final int TRANSACTION_getPendingAppTransition = 24;
        static final int TRANSACTION_getPreferredOptionsPanelGravity = 58;
        static final int TRANSACTION_getRealDisplaySize = 7;
        static final int TRANSACTION_getRotation = 56;
        static final int TRANSACTION_hasNavigationBar = 64;
        static final int TRANSACTION_hasSystemNavBar = 12;
        static final int TRANSACTION_inKeyguardRestrictedInputMode = 45;
        static final int TRANSACTION_inputMethodClientHasFocus = 5;
        static final int TRANSACTION_isKeyguardLocked = 43;
        static final int TRANSACTION_isKeyguardSecure = 44;
        static final int TRANSACTION_isViewServerRunning = 3;
        static final int TRANSACTION_lockNow = 65;
        static final int TRANSACTION_moveAppToken = 35;
        static final int TRANSACTION_moveAppTokensToBottom = 37;
        static final int TRANSACTION_moveAppTokensToTop = 36;
        static final int TRANSACTION_openSession = 4;
        static final int TRANSACTION_overridePendingAppTransition = 25;
        static final int TRANSACTION_overridePendingAppTransitionScaleUp = 26;
        static final int TRANSACTION_overridePendingAppTransitionThumb = 27;
        static final int TRANSACTION_pauseKeyDispatching = 13;
        static final int TRANSACTION_prepareAppTransition = 23;
        static final int TRANSACTION_reenableKeyguard = 41;
        static final int TRANSACTION_removeAppToken = 34;
        static final int TRANSACTION_removeWindowToken = 17;
        static final int TRANSACTION_resumeKeyDispatching = 14;
        static final int TRANSACTION_screenshotApplications = 61;
        static final int TRANSACTION_setAnimationScale = 50;
        static final int TRANSACTION_setAnimationScales = 51;
        static final int TRANSACTION_setAppGroupId = 19;
        static final int TRANSACTION_setAppOrientation = 20;
        static final int TRANSACTION_setAppStartingWindow = 29;
        static final int TRANSACTION_setAppVisibility = 31;
        static final int TRANSACTION_setAppWillBeHidden = 30;
        static final int TRANSACTION_setEventDispatching = 15;
        static final int TRANSACTION_setFocusedApp = 22;
        static final int TRANSACTION_setForcedDisplaySize = 10;
        static final int TRANSACTION_setInTouchMode = 52;
        static final int TRANSACTION_setNewConfiguration = 39;
        static final int TRANSACTION_setStrictModeVisualIndicatorPreference = 54;
        static final int TRANSACTION_showStrictModeViolation = 53;
        static final int TRANSACTION_startAppFreezingScreen = 32;
        static final int TRANSACTION_startViewServer = 1;
        static final int TRANSACTION_statusBarVisibilityChanged = 62;
        static final int TRANSACTION_stopAppFreezingScreen = 33;
        static final int TRANSACTION_stopViewServer = 2;
        static final int TRANSACTION_thawRotation = 60;
        static final int TRANSACTION_updateOrientationFromAppTokens = 38;
        static final int TRANSACTION_updateRotation = 55;
        static final int TRANSACTION_waitForWindowDrawn = 63;
        static final int TRANSACTION_watchRotation = 57;

        public Stub() {
            attachInterface(this, "android.view.IWindowManager");
        }
    }


    public abstract void addAppToken(int i, IApplicationToken iapplicationtoken, int j, int k, boolean flag) throws RemoteException;

    public abstract void addWindowToken(IBinder ibinder, int i) throws RemoteException;

    public abstract void clearForcedDisplaySize() throws RemoteException;

    public abstract void closeSystemDialogs(String s) throws RemoteException;

    public abstract void disableKeyguard(IBinder ibinder, String s) throws RemoteException;

    public abstract void dismissKeyguard() throws RemoteException;

    public abstract void executeAppTransition() throws RemoteException;

    public abstract void exitKeyguardSecurely(IOnKeyguardExitResult ionkeyguardexitresult) throws RemoteException;

    public abstract void freezeRotation(int i) throws RemoteException;

    public abstract float getAnimationScale(int i) throws RemoteException;

    public abstract float[] getAnimationScales() throws RemoteException;

    public abstract int getAppOrientation(IApplicationToken iapplicationtoken) throws RemoteException;

    public abstract void getCurrentSizeRange(Point point, Point point1) throws RemoteException;

    public abstract void getDisplaySize(Point point) throws RemoteException;

    public abstract int getMaximumSizeDimension() throws RemoteException;

    public abstract int getPendingAppTransition() throws RemoteException;

    public abstract int getPreferredOptionsPanelGravity() throws RemoteException;

    public abstract void getRealDisplaySize(Point point) throws RemoteException;

    public abstract int getRotation() throws RemoteException;

    public abstract boolean hasNavigationBar() throws RemoteException;

    public abstract boolean hasSystemNavBar() throws RemoteException;

    public abstract boolean inKeyguardRestrictedInputMode() throws RemoteException;

    public abstract boolean inputMethodClientHasFocus(IInputMethodClient iinputmethodclient) throws RemoteException;

    public abstract boolean isKeyguardLocked() throws RemoteException;

    public abstract boolean isKeyguardSecure() throws RemoteException;

    public abstract boolean isViewServerRunning() throws RemoteException;

    public abstract void lockNow() throws RemoteException;

    public abstract void moveAppToken(int i, IBinder ibinder) throws RemoteException;

    public abstract void moveAppTokensToBottom(List list) throws RemoteException;

    public abstract void moveAppTokensToTop(List list) throws RemoteException;

    public abstract IWindowSession openSession(IInputMethodClient iinputmethodclient, IInputContext iinputcontext) throws RemoteException;

    public abstract void overridePendingAppTransition(String s, int i, int j, IRemoteCallback iremotecallback) throws RemoteException;

    public abstract void overridePendingAppTransitionScaleUp(int i, int j, int k, int l) throws RemoteException;

    public abstract void overridePendingAppTransitionThumb(Bitmap bitmap, int i, int j, IRemoteCallback iremotecallback, boolean flag) throws RemoteException;

    public abstract void pauseKeyDispatching(IBinder ibinder) throws RemoteException;

    public abstract void prepareAppTransition(int i, boolean flag) throws RemoteException;

    public abstract void reenableKeyguard(IBinder ibinder) throws RemoteException;

    public abstract void removeAppToken(IBinder ibinder) throws RemoteException;

    public abstract void removeWindowToken(IBinder ibinder) throws RemoteException;

    public abstract void resumeKeyDispatching(IBinder ibinder) throws RemoteException;

    public abstract Bitmap screenshotApplications(IBinder ibinder, int i, int j) throws RemoteException;

    public abstract void setAnimationScale(int i, float f) throws RemoteException;

    public abstract void setAnimationScales(float af[]) throws RemoteException;

    public abstract void setAppGroupId(IBinder ibinder, int i) throws RemoteException;

    public abstract void setAppOrientation(IApplicationToken iapplicationtoken, int i) throws RemoteException;

    public abstract void setAppStartingWindow(IBinder ibinder, String s, int i, CompatibilityInfo compatibilityinfo, CharSequence charsequence, int j, int k, 
            int l, IBinder ibinder1, boolean flag) throws RemoteException;

    public abstract void setAppVisibility(IBinder ibinder, boolean flag) throws RemoteException;

    public abstract void setAppWillBeHidden(IBinder ibinder) throws RemoteException;

    public abstract void setEventDispatching(boolean flag) throws RemoteException;

    public abstract void setFocusedApp(IBinder ibinder, boolean flag) throws RemoteException;

    public abstract void setForcedDisplaySize(int i, int j) throws RemoteException;

    public abstract void setInTouchMode(boolean flag) throws RemoteException;

    public abstract void setNewConfiguration(Configuration configuration) throws RemoteException;

    public abstract void setStrictModeVisualIndicatorPreference(String s) throws RemoteException;

    public abstract void showStrictModeViolation(boolean flag) throws RemoteException;

    public abstract void startAppFreezingScreen(IBinder ibinder, int i) throws RemoteException;

    public abstract boolean startViewServer(int i) throws RemoteException;

    public abstract void statusBarVisibilityChanged(int i) throws RemoteException;

    public abstract void stopAppFreezingScreen(IBinder ibinder, boolean flag) throws RemoteException;

    public abstract boolean stopViewServer() throws RemoteException;

    public abstract void thawRotation() throws RemoteException;

    public abstract Configuration updateOrientationFromAppTokens(Configuration configuration, IBinder ibinder) throws RemoteException;

    public abstract void updateRotation(boolean flag, boolean flag1) throws RemoteException;

    public abstract void waitForWindowDrawn(IBinder ibinder, IRemoteCallback iremotecallback) throws RemoteException;

    public abstract int watchRotation(IRotationWatcher irotationwatcher) throws RemoteException;
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.hardware.input;

import android.os.*;
import android.view.InputDevice;
import android.view.InputEvent;

// Referenced classes of package android.hardware.input:
//            KeyboardLayout, IInputDevicesChangedListener

public interface IInputManager
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IInputManager {
        private static class Proxy
            implements IInputManager {

            public void addKeyboardLayoutForInputDevice(String s, String s1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.hardware.input.IInputManager");
                parcel.writeString(s);
                parcel.writeString(s1);
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

            public IBinder asBinder() {
                return mRemote;
            }

            public void cancelVibrate(int i, IBinder ibinder) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.hardware.input.IInputManager");
                parcel.writeInt(i);
                parcel.writeStrongBinder(ibinder);
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

            public String getCurrentKeyboardLayoutForInputDevice(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s1;
                parcel.writeInterfaceToken("android.hardware.input.IInputManager");
                parcel.writeString(s);
                mRemote.transact(8, parcel, parcel1, 0);
                parcel1.readException();
                s1 = parcel1.readString();
                parcel1.recycle();
                parcel.recycle();
                return s1;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public InputDevice getInputDevice(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.hardware.input.IInputManager");
                parcel.writeInt(i);
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                InputDevice inputdevice = (InputDevice)InputDevice.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return inputdevice;
_L2:
                inputdevice = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int[] getInputDeviceIds() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int ai[];
                parcel.writeInterfaceToken("android.hardware.input.IInputManager");
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                ai = parcel1.createIntArray();
                parcel1.recycle();
                parcel.recycle();
                return ai;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "android.hardware.input.IInputManager";
            }

            public KeyboardLayout getKeyboardLayout(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.hardware.input.IInputManager");
                parcel.writeString(s);
                mRemote.transact(7, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                KeyboardLayout keyboardlayout = (KeyboardLayout)KeyboardLayout.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return keyboardlayout;
_L2:
                keyboardlayout = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public KeyboardLayout[] getKeyboardLayouts() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                KeyboardLayout akeyboardlayout[];
                parcel.writeInterfaceToken("android.hardware.input.IInputManager");
                mRemote.transact(6, parcel, parcel1, 0);
                parcel1.readException();
                akeyboardlayout = (KeyboardLayout[])parcel1.createTypedArray(KeyboardLayout.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return akeyboardlayout;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String[] getKeyboardLayoutsForInputDevice(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String as[];
                parcel.writeInterfaceToken("android.hardware.input.IInputManager");
                parcel.writeString(s);
                mRemote.transact(10, parcel, parcel1, 0);
                parcel1.readException();
                as = parcel1.createStringArray();
                parcel1.recycle();
                parcel.recycle();
                return as;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean hasKeys(int i, int j, int ai[], boolean aflag[]) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.hardware.input.IInputManager");
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeIntArray(ai);
                if(aflag != null)
                    break MISSING_BLOCK_LABEL_102;
                parcel.writeInt(-1);
_L1:
                mRemote.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() != 0)
                    flag = true;
                parcel1.readBooleanArray(aflag);
                parcel1.recycle();
                parcel.recycle();
                return flag;
                parcel.writeInt(aflag.length);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean injectInputEvent(InputEvent inputevent, int i) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.hardware.input.IInputManager");
                if(inputevent == null)
                    break MISSING_BLOCK_LABEL_87;
                parcel.writeInt(1);
                inputevent.writeToParcel(parcel, 0);
_L1:
                int j;
                parcel.writeInt(i);
                mRemote.transact(5, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                Exception exception;
                if(j == 0)
                    flag = false;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                parcel.writeInt(0);
                  goto _L1
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void registerInputDevicesChangedListener(IInputDevicesChangedListener iinputdeviceschangedlistener) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.hardware.input.IInputManager");
                if(iinputdeviceschangedlistener == null)
                    break MISSING_BLOCK_LABEL_60;
                ibinder = iinputdeviceschangedlistener.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(13, parcel, parcel1, 0);
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

            public void removeKeyboardLayoutForInputDevice(String s, String s1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.hardware.input.IInputManager");
                parcel.writeString(s);
                parcel.writeString(s1);
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

            public void setCurrentKeyboardLayoutForInputDevice(String s, String s1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.hardware.input.IInputManager");
                parcel.writeString(s);
                parcel.writeString(s1);
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

            public void tryPointerSpeed(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.hardware.input.IInputManager");
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

            public void vibrate(int i, long al[], int j, IBinder ibinder) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.hardware.input.IInputManager");
                parcel.writeInt(i);
                parcel.writeLongArray(al);
                parcel.writeInt(j);
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IInputManager asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.hardware.input.IInputManager");
                if(iinterface != null && (iinterface instanceof IInputManager))
                    obj = (IInputManager)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IInputManager) (obj));
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
            JVM INSTR lookupswitch 16: default 144
        //                       1: 167
        //                       2: 217
        //                       3: 242
        //                       4: 331
        //                       5: 352
        //                       6: 419
        //                       7: 446
        //                       8: 496
        //                       9: 525
        //                       10: 550
        //                       11: 579
        //                       12: 604
        //                       13: 629
        //                       14: 653
        //                       15: 686
        //                       1598968902: 158;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L19:
            return flag;
_L17:
            parcel1.writeString("android.hardware.input.IInputManager");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.hardware.input.IInputManager");
            InputDevice inputdevice = getInputDevice(parcel.readInt());
            parcel1.writeNoException();
            if(inputdevice != null) {
                parcel1.writeInt(flag);
                inputdevice.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.hardware.input.IInputManager");
            int ai1[] = getInputDeviceIds();
            parcel1.writeNoException();
            parcel1.writeIntArray(ai1);
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.hardware.input.IInputManager");
            int l = parcel.readInt();
            int i1 = parcel.readInt();
            int ai[] = parcel.createIntArray();
            int j1 = parcel.readInt();
            boolean aflag[];
            boolean flag2;
            if(j1 < 0)
                aflag = null;
            else
                aflag = new boolean[j1];
            flag2 = hasKeys(l, i1, ai, aflag);
            parcel1.writeNoException();
            if(flag2)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            parcel1.writeBooleanArray(aflag);
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.hardware.input.IInputManager");
            tryPointerSpeed(parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.hardware.input.IInputManager");
            InputEvent inputevent;
            boolean flag1;
            if(parcel.readInt() != 0)
                inputevent = (InputEvent)InputEvent.CREATOR.createFromParcel(parcel);
            else
                inputevent = null;
            flag1 = injectInputEvent(inputevent, parcel.readInt());
            parcel1.writeNoException();
            if(flag1)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.hardware.input.IInputManager");
            KeyboardLayout akeyboardlayout[] = getKeyboardLayouts();
            parcel1.writeNoException();
            parcel1.writeTypedArray(akeyboardlayout, flag);
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.hardware.input.IInputManager");
            KeyboardLayout keyboardlayout = getKeyboardLayout(parcel.readString());
            parcel1.writeNoException();
            if(keyboardlayout != null) {
                parcel1.writeInt(flag);
                keyboardlayout.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("android.hardware.input.IInputManager");
            String s = getCurrentKeyboardLayoutForInputDevice(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeString(s);
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("android.hardware.input.IInputManager");
            setCurrentKeyboardLayoutForInputDevice(parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("android.hardware.input.IInputManager");
            String as[] = getKeyboardLayoutsForInputDevice(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeStringArray(as);
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("android.hardware.input.IInputManager");
            addKeyboardLayoutForInputDevice(parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("android.hardware.input.IInputManager");
            removeKeyboardLayoutForInputDevice(parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L14:
            parcel.enforceInterface("android.hardware.input.IInputManager");
            registerInputDevicesChangedListener(IInputDevicesChangedListener.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L15:
            parcel.enforceInterface("android.hardware.input.IInputManager");
            vibrate(parcel.readInt(), parcel.createLongArray(), parcel.readInt(), parcel.readStrongBinder());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L16:
            parcel.enforceInterface("android.hardware.input.IInputManager");
            cancelVibrate(parcel.readInt(), parcel.readStrongBinder());
            parcel1.writeNoException();
            if(true) goto _L19; else goto _L18
_L18:
        }

        private static final String DESCRIPTOR = "android.hardware.input.IInputManager";
        static final int TRANSACTION_addKeyboardLayoutForInputDevice = 11;
        static final int TRANSACTION_cancelVibrate = 15;
        static final int TRANSACTION_getCurrentKeyboardLayoutForInputDevice = 8;
        static final int TRANSACTION_getInputDevice = 1;
        static final int TRANSACTION_getInputDeviceIds = 2;
        static final int TRANSACTION_getKeyboardLayout = 7;
        static final int TRANSACTION_getKeyboardLayouts = 6;
        static final int TRANSACTION_getKeyboardLayoutsForInputDevice = 10;
        static final int TRANSACTION_hasKeys = 3;
        static final int TRANSACTION_injectInputEvent = 5;
        static final int TRANSACTION_registerInputDevicesChangedListener = 13;
        static final int TRANSACTION_removeKeyboardLayoutForInputDevice = 12;
        static final int TRANSACTION_setCurrentKeyboardLayoutForInputDevice = 9;
        static final int TRANSACTION_tryPointerSpeed = 4;
        static final int TRANSACTION_vibrate = 14;

        public Stub() {
            attachInterface(this, "android.hardware.input.IInputManager");
        }
    }


    public abstract void addKeyboardLayoutForInputDevice(String s, String s1) throws RemoteException;

    public abstract void cancelVibrate(int i, IBinder ibinder) throws RemoteException;

    public abstract String getCurrentKeyboardLayoutForInputDevice(String s) throws RemoteException;

    public abstract InputDevice getInputDevice(int i) throws RemoteException;

    public abstract int[] getInputDeviceIds() throws RemoteException;

    public abstract KeyboardLayout getKeyboardLayout(String s) throws RemoteException;

    public abstract KeyboardLayout[] getKeyboardLayouts() throws RemoteException;

    public abstract String[] getKeyboardLayoutsForInputDevice(String s) throws RemoteException;

    public abstract boolean hasKeys(int i, int j, int ai[], boolean aflag[]) throws RemoteException;

    public abstract boolean injectInputEvent(InputEvent inputevent, int i) throws RemoteException;

    public abstract void registerInputDevicesChangedListener(IInputDevicesChangedListener iinputdeviceschangedlistener) throws RemoteException;

    public abstract void removeKeyboardLayoutForInputDevice(String s, String s1) throws RemoteException;

    public abstract void setCurrentKeyboardLayoutForInputDevice(String s, String s1) throws RemoteException;

    public abstract void tryPointerSpeed(int i) throws RemoteException;

    public abstract void vibrate(int i, long al[], int j, IBinder ibinder) throws RemoteException;
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.hardware.input;

import android.content.Context;
import android.os.*;
import android.util.Log;
import android.util.SparseArray;
import android.view.InputDevice;
import android.view.InputEvent;
import com.android.internal.util.ArrayUtils;
import java.util.ArrayList;

// Referenced classes of package android.hardware.input:
//            IInputManager, KeyboardLayout

public final class InputManager {
    private final class InputDeviceVibrator extends Vibrator {

        public void cancel() {
            mIm.cancelVibrate(mDeviceId, mToken);
_L1:
            return;
            RemoteException remoteexception;
            remoteexception;
            Log.w("InputManager", "Failed to cancel vibration.", remoteexception);
              goto _L1
        }

        public boolean hasVibrator() {
            return true;
        }

        public void vibrate(long l) {
            long al[] = new long[2];
            al[0] = 0L;
            al[1] = l;
            vibrate(al, -1);
        }

        public void vibrate(long al[], int i) {
            if(i >= al.length)
                throw new ArrayIndexOutOfBoundsException();
            mIm.vibrate(mDeviceId, al, i, mToken);
_L1:
            return;
            RemoteException remoteexception;
            remoteexception;
            Log.w("InputManager", "Failed to vibrate.", remoteexception);
              goto _L1
        }

        private final int mDeviceId;
        private final Binder mToken = new Binder();
        final InputManager this$0;

        public InputDeviceVibrator(int i) {
            this$0 = InputManager.this;
            super();
            mDeviceId = i;
        }
    }

    private static final class InputDeviceListenerDelegate extends Handler {

        public void handleMessage(Message message) {
            message.what;
            JVM INSTR tableswitch 1 3: default 32
        //                       1 33
        //                       2 49
        //                       3 65;
               goto _L1 _L2 _L3 _L4
_L1:
            return;
_L2:
            mListener.onInputDeviceAdded(message.arg1);
            continue; /* Loop/switch isn't completed */
_L3:
            mListener.onInputDeviceRemoved(message.arg1);
            continue; /* Loop/switch isn't completed */
_L4:
            mListener.onInputDeviceChanged(message.arg1);
            if(true) goto _L1; else goto _L5
_L5:
        }

        public final InputDeviceListener mListener;

        public InputDeviceListenerDelegate(InputDeviceListener inputdevicelistener, Handler handler) {
            Looper looper;
            if(handler != null)
                looper = handler.getLooper();
            else
                looper = Looper.myLooper();
            super(looper);
            mListener = inputdevicelistener;
        }
    }

    private final class InputDevicesChangedListener extends IInputDevicesChangedListener.Stub {

        public void onInputDevicesChanged(int ai[]) throws RemoteException {
            InputManager.this.onInputDevicesChanged(ai);
        }

        final InputManager this$0;

        private InputDevicesChangedListener() {
            this$0 = InputManager.this;
            super();
        }

    }

    public static interface InputDeviceListener {

        public abstract void onInputDeviceAdded(int i);

        public abstract void onInputDeviceChanged(int i);

        public abstract void onInputDeviceRemoved(int i);
    }


    private InputManager(IInputManager iinputmanager) {
        mIm = iinputmanager;
    }

    private static boolean containsDeviceId(int ai[], int i) {
        int j = 0;
_L3:
        if(j >= ai.length)
            break MISSING_BLOCK_LABEL_25;
        if(ai[j] != i) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        j += 2;
          goto _L3
        flag = false;
          goto _L4
    }

    private int findInputDeviceListenerLocked(InputDeviceListener inputdevicelistener) {
        int i;
        int j;
        i = mInputDeviceListeners.size();
        j = 0;
_L3:
        if(j >= i)
            break MISSING_BLOCK_LABEL_41;
        if(((InputDeviceListenerDelegate)mInputDeviceListeners.get(j)).mListener != inputdevicelistener) goto _L2; else goto _L1
_L1:
        return j;
_L2:
        j++;
          goto _L3
        j = -1;
          goto _L1
    }

    public static InputManager getInstance() {
        android/hardware/input/InputManager;
        JVM INSTR monitorenter ;
        if(sInstance == null)
            sInstance = new InputManager(IInputManager.Stub.asInterface(ServiceManager.getService("input")));
        InputManager inputmanager = sInstance;
        return inputmanager;
    }

    private void onInputDevicesChanged(int ai[]) {
        Object obj = mInputDevicesLock;
        obj;
        JVM INSTR monitorenter ;
        int i = mInputDevices.size();
        do {
            if(--i <= 0)
                break;
            int j1 = mInputDevices.keyAt(i);
            if(!containsDeviceId(ai, j1)) {
                mInputDevices.removeAt(i);
                sendMessageToInputDeviceListenersLocked(2, j1);
            }
        } while(true);
        break MISSING_BLOCK_LABEL_68;
        Exception exception;
        exception;
        throw exception;
        int j = 0;
_L2:
        if(j < ai.length) {
            int k = ai[j];
            int l = mInputDevices.indexOfKey(k);
            if(l >= 0) {
                InputDevice inputdevice = (InputDevice)mInputDevices.valueAt(l);
                if(inputdevice != null) {
                    int i1 = ai[j + 1];
                    if(inputdevice.getGeneration() != i1) {
                        mInputDevices.setValueAt(l, null);
                        sendMessageToInputDeviceListenersLocked(3, k);
                    }
                }
            } else {
                mInputDevices.put(k, null);
                sendMessageToInputDeviceListenersLocked(1, k);
            }
            break MISSING_BLOCK_LABEL_180;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        j += 2;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private void populateInputDevicesLocked() {
        if(mInputDevicesChangedListener == null) {
            InputDevicesChangedListener inputdeviceschangedlistener = new InputDevicesChangedListener();
            int ai[];
            int i;
            try {
                mIm.registerInputDevicesChangedListener(inputdeviceschangedlistener);
            }
            catch(RemoteException remoteexception) {
                throw new RuntimeException("Could not get register input device changed listener", remoteexception);
            }
            mInputDevicesChangedListener = inputdeviceschangedlistener;
        }
        if(mInputDevices == null) {
            try {
                ai = mIm.getInputDeviceIds();
            }
            catch(RemoteException remoteexception1) {
                throw new RuntimeException("Could not get input device ids.", remoteexception1);
            }
            mInputDevices = new SparseArray();
            for(i = 0; i < ai.length; i++)
                mInputDevices.put(ai[i], null);

        }
    }

    private void sendMessageToInputDeviceListenersLocked(int i, int j) {
        int k = mInputDeviceListeners.size();
        for(int l = 0; l < k; l++) {
            InputDeviceListenerDelegate inputdevicelistenerdelegate = (InputDeviceListenerDelegate)mInputDeviceListeners.get(l);
            inputdevicelistenerdelegate.sendMessage(inputdevicelistenerdelegate.obtainMessage(i, j, 0));
        }

    }

    public void addKeyboardLayoutForInputDevice(String s, String s1) {
        if(s == null)
            throw new IllegalArgumentException("inputDeviceDescriptor must not be null");
        if(s1 == null)
            throw new IllegalArgumentException("keyboardLayoutDescriptor must not be null");
        mIm.addKeyboardLayoutForInputDevice(s, s1);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.w("InputManager", "Could not add keyboard layout for input device.", remoteexception);
          goto _L1
    }

    public boolean[] deviceHasKeys(int ai[]) {
        boolean aflag[] = new boolean[ai.length];
        try {
            mIm.hasKeys(-1, -256, ai, aflag);
        }
        catch(RemoteException remoteexception) { }
        return aflag;
    }

    public String getCurrentKeyboardLayoutForInputDevice(String s) {
        if(s == null)
            throw new IllegalArgumentException("inputDeviceDescriptor must not be null");
        String s2 = mIm.getCurrentKeyboardLayoutForInputDevice(s);
        String s1 = s2;
_L2:
        return s1;
        RemoteException remoteexception;
        remoteexception;
        Log.w("InputManager", "Could not get current keyboard layout for input device.", remoteexception);
        s1 = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public InputDevice getInputDevice(int i) {
        Object obj = mInputDevicesLock;
        obj;
        JVM INSTR monitorenter ;
        int j;
        InputDevice inputdevice;
        populateInputDevicesLocked();
        j = mInputDevices.indexOfKey(i);
        if(j < 0) {
            inputdevice = null;
            break MISSING_BLOCK_LABEL_104;
        }
        inputdevice = (InputDevice)mInputDevices.valueAt(j);
        if(inputdevice != null)
            break MISSING_BLOCK_LABEL_69;
        InputDevice inputdevice1 = mIm.getInputDevice(i);
        inputdevice = inputdevice1;
        mInputDevices.setValueAt(j, inputdevice);
        break MISSING_BLOCK_LABEL_104;
        Exception exception;
        exception;
        throw exception;
        RemoteException remoteexception;
        remoteexception;
        throw new RuntimeException("Could not get input device information.", remoteexception);
        return inputdevice;
    }

    public InputDevice getInputDeviceByDescriptor(String s) {
        if(s == null)
            throw new IllegalArgumentException("descriptor must not be null.");
        Object obj = mInputDevicesLock;
        obj;
        JVM INSTR monitorenter ;
        int i;
        int j;
        populateInputDevicesLocked();
        i = mInputDevices.size();
        j = 0;
_L6:
        if(j >= i) goto _L2; else goto _L1
_L1:
        InputDevice inputdevice = (InputDevice)mInputDevices.valueAt(j);
        if(inputdevice != null) goto _L4; else goto _L3
_L3:
        int k = mInputDevices.keyAt(j);
        InputDevice inputdevice1 = mIm.getInputDevice(k);
        inputdevice = inputdevice1;
        mInputDevices.setValueAt(j, inputdevice);
_L4:
        if(!s.equals(inputdevice.getDescriptor()))
            break MISSING_BLOCK_LABEL_137;
          goto _L5
_L2:
        inputdevice = null;
          goto _L5
        Exception exception;
        exception;
        throw exception;
_L5:
        return inputdevice;
        RemoteException remoteexception;
        remoteexception;
        j++;
          goto _L6
    }

    public int[] getInputDeviceIds() {
        Object obj = mInputDevicesLock;
        obj;
        JVM INSTR monitorenter ;
        populateInputDevicesLocked();
        int i = mInputDevices.size();
        int ai[] = new int[i];
        for(int j = 0; j < i; j++)
            ai[j] = mInputDevices.keyAt(j);

        return ai;
    }

    public Vibrator getInputDeviceVibrator(int i) {
        return new InputDeviceVibrator(i);
    }

    public KeyboardLayout getKeyboardLayout(String s) {
        if(s == null)
            throw new IllegalArgumentException("keyboardLayoutDescriptor must not be null");
        KeyboardLayout keyboardlayout1 = mIm.getKeyboardLayout(s);
        KeyboardLayout keyboardlayout = keyboardlayout1;
_L2:
        return keyboardlayout;
        RemoteException remoteexception;
        remoteexception;
        Log.w("InputManager", "Could not get keyboard layout information.", remoteexception);
        keyboardlayout = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public KeyboardLayout[] getKeyboardLayouts() {
        KeyboardLayout akeyboardlayout1[] = mIm.getKeyboardLayouts();
        KeyboardLayout akeyboardlayout[] = akeyboardlayout1;
_L2:
        return akeyboardlayout;
        RemoteException remoteexception;
        remoteexception;
        Log.w("InputManager", "Could not get list of keyboard layout informations.", remoteexception);
        akeyboardlayout = new KeyboardLayout[0];
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String[] getKeyboardLayoutsForInputDevice(String s) {
        if(s == null)
            throw new IllegalArgumentException("inputDeviceDescriptor must not be null");
        String as1[] = mIm.getKeyboardLayoutsForInputDevice(s);
        String as[] = as1;
_L2:
        return as;
        RemoteException remoteexception;
        remoteexception;
        Log.w("InputManager", "Could not get keyboard layouts for input device.", remoteexception);
        as = (String[])ArrayUtils.emptyArray(java/lang/String);
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int getPointerSpeed(Context context) {
        int i = 0;
        int j = android.provider.Settings.System.getInt(context.getContentResolver(), "pointer_speed");
        i = j;
_L2:
        return i;
        android.provider.Settings.SettingNotFoundException settingnotfoundexception;
        settingnotfoundexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean injectInputEvent(InputEvent inputevent, int i) {
        if(inputevent == null)
            throw new IllegalArgumentException("event must not be null");
        if(i != 0 && i != 2 && i != 1)
            throw new IllegalArgumentException("mode is invalid");
        boolean flag1 = mIm.injectInputEvent(inputevent, i);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void registerInputDeviceListener(InputDeviceListener inputdevicelistener, Handler handler) {
        if(inputdevicelistener == null)
            throw new IllegalArgumentException("listener must not be null");
        Object obj = mInputDevicesLock;
        obj;
        JVM INSTR monitorenter ;
        if(findInputDeviceListenerLocked(inputdevicelistener) < 0)
            mInputDeviceListeners.add(new InputDeviceListenerDelegate(inputdevicelistener, handler));
        return;
    }

    public void removeKeyboardLayoutForInputDevice(String s, String s1) {
        if(s == null)
            throw new IllegalArgumentException("inputDeviceDescriptor must not be null");
        if(s1 == null)
            throw new IllegalArgumentException("keyboardLayoutDescriptor must not be null");
        mIm.removeKeyboardLayoutForInputDevice(s, s1);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.w("InputManager", "Could not remove keyboard layout for input device.", remoteexception);
          goto _L1
    }

    public void setCurrentKeyboardLayoutForInputDevice(String s, String s1) {
        if(s == null)
            throw new IllegalArgumentException("inputDeviceDescriptor must not be null");
        if(s1 == null)
            throw new IllegalArgumentException("keyboardLayoutDescriptor must not be null");
        mIm.setCurrentKeyboardLayoutForInputDevice(s, s1);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.w("InputManager", "Could not set current keyboard layout for input device.", remoteexception);
          goto _L1
    }

    public void setPointerSpeed(Context context, int i) {
        if(i < -7 || i > 7) {
            throw new IllegalArgumentException("speed out of range");
        } else {
            android.provider.Settings.System.putInt(context.getContentResolver(), "pointer_speed", i);
            return;
        }
    }

    public void tryPointerSpeed(int i) {
        if(i < -7 || i > 7)
            throw new IllegalArgumentException("speed out of range");
        mIm.tryPointerSpeed(i);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.w("InputManager", "Could not set temporary pointer speed.", remoteexception);
          goto _L1
    }

    public void unregisterInputDeviceListener(InputDeviceListener inputdevicelistener) {
        if(inputdevicelistener == null)
            throw new IllegalArgumentException("listener must not be null");
        Object obj = mInputDevicesLock;
        obj;
        JVM INSTR monitorenter ;
        int i = findInputDeviceListenerLocked(inputdevicelistener);
        if(i >= 0) {
            ((InputDeviceListenerDelegate)mInputDeviceListeners.get(i)).removeCallbacksAndMessages(null);
            mInputDeviceListeners.remove(i);
        }
        return;
    }

    public static final String ACTION_QUERY_KEYBOARD_LAYOUTS = "android.hardware.input.action.QUERY_KEYBOARD_LAYOUTS";
    private static final boolean DEBUG = false;
    public static final int DEFAULT_POINTER_SPEED = 0;
    public static final int INJECT_INPUT_EVENT_MODE_ASYNC = 0;
    public static final int INJECT_INPUT_EVENT_MODE_WAIT_FOR_FINISH = 2;
    public static final int INJECT_INPUT_EVENT_MODE_WAIT_FOR_RESULT = 1;
    public static final int MAX_POINTER_SPEED = 7;
    public static final String META_DATA_KEYBOARD_LAYOUTS = "android.hardware.input.metadata.KEYBOARD_LAYOUTS";
    public static final int MIN_POINTER_SPEED = -7;
    private static final int MSG_DEVICE_ADDED = 1;
    private static final int MSG_DEVICE_CHANGED = 3;
    private static final int MSG_DEVICE_REMOVED = 2;
    private static final String TAG = "InputManager";
    private static InputManager sInstance;
    private final IInputManager mIm;
    private final ArrayList mInputDeviceListeners = new ArrayList();
    private SparseArray mInputDevices;
    private InputDevicesChangedListener mInputDevicesChangedListener;
    private final Object mInputDevicesLock = new Object();


}

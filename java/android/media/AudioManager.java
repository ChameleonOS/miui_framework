// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import android.app.PendingIntent;
import android.bluetooth.BluetoothDevice;
import android.content.*;
import android.content.res.Resources;
import android.os.*;
import android.util.Log;
import android.view.KeyEvent;
import java.util.HashMap;

// Referenced classes of package android.media:
//            IAudioService, AudioSystem, RemoteControlClient, IAudioFocusDispatcher, 
//            IRingtonePlayer, IRemoteControlDisplay

public class AudioManager {
    private class FocusEventHandlerDelegate {

        Handler getHandler() {
            return mHandler;
        }

        private final Handler mHandler;
        final AudioManager this$0;

        FocusEventHandlerDelegate() {
            this$0 = AudioManager.this;
            super();
            final Looper final_looper = Looper.myLooper();
            if(final_looper == null)
                final_looper = Looper.getMainLooper();
            if(final_looper != null)
                mHandler = new Handler(AudioManager.this) {

                    public void handleMessage(Message message) {
                        OnAudioFocusChangeListener onaudiofocuschangelistener;
                        synchronized(mFocusListenerLock) {
                            onaudiofocuschangelistener = findFocusListener((String)message.obj);
                        }
                        if(onaudiofocuschangelistener != null)
                            onaudiofocuschangelistener.onAudioFocusChange(message.what);
                        return;
                        exception;
                        obj;
                        JVM INSTR monitorexit ;
                        throw exception;
                    }

                    final FocusEventHandlerDelegate this$1;
                    final AudioManager val$this$0;

                 {
                    this$1 = FocusEventHandlerDelegate.this;
                    this$0 = audiomanager;
                    super(final_looper);
                }
                };
            else
                mHandler = null;
        }
    }

    public static interface OnAudioFocusChangeListener {

        public abstract void onAudioFocusChange(int i);
    }


    public AudioManager(Context context) {
        mContext = context;
        mUseMasterVolume = mContext.getResources().getBoolean(0x111000a);
    }

    private OnAudioFocusChangeListener findFocusListener(String s) {
        return (OnAudioFocusChangeListener)mAudioFocusIdListenerMap.get(s);
    }

    private String getIdForAudioFocusListener(OnAudioFocusChangeListener onaudiofocuschangelistener) {
        String s;
        if(onaudiofocuschangelistener == null)
            s = new String(toString());
        else
            s = new String((new StringBuilder()).append(toString()).append(onaudiofocuschangelistener.toString()).toString());
        return s;
    }

    private static IAudioService getService() {
        IAudioService iaudioservice;
        if(sService != null) {
            iaudioservice = sService;
        } else {
            sService = IAudioService.Stub.asInterface(ServiceManager.getService("audio"));
            iaudioservice = sService;
        }
        return iaudioservice;
    }

    public static boolean isValidRingerMode(int i) {
        boolean flag;
        if(i < 0 || i > 2)
            flag = false;
        else
            flag = true;
        return flag;
    }

    private boolean querySoundEffectsEnabled() {
        boolean flag = false;
        if(android.provider.Settings.System.getInt(mContext.getContentResolver(), "sound_effects_enabled", 0) != 0)
            flag = true;
        return flag;
    }

    public int abandonAudioFocus(OnAudioFocusChangeListener onaudiofocuschangelistener) {
        int i;
        IAudioService iaudioservice;
        i = 0;
        unregisterAudioFocusListener(onaudiofocuschangelistener);
        iaudioservice = getService();
        int j = iaudioservice.abandonAudioFocus(mAudioFocusDispatcher, getIdForAudioFocusListener(onaudiofocuschangelistener));
        i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, (new StringBuilder()).append("Can't call abandonAudioFocus() on AudioService due to ").append(remoteexception).toString());
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void abandonAudioFocusForCall() {
        IAudioService iaudioservice = getService();
        iaudioservice.abandonAudioFocus(null, "AudioFocus_For_Phone_Ring_And_Calls");
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, (new StringBuilder()).append("Can't call abandonAudioFocusForCall() on AudioService due to ").append(remoteexception).toString());
          goto _L1
    }

    public void adjustLocalOrRemoteStreamVolume(int i, int j) {
        IAudioService iaudioservice;
        if(i != 3)
            Log.w(TAG, (new StringBuilder()).append("adjustLocalOrRemoteStreamVolume() doesn't support stream ").append(i).toString());
        iaudioservice = getService();
        iaudioservice.adjustLocalOrRemoteStreamVolume(i, j);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, "Dead object in adjustLocalOrRemoteStreamVolume", remoteexception);
          goto _L1
    }

    public void adjustMasterVolume(int i, int j) {
        IAudioService iaudioservice = getService();
        iaudioservice.adjustMasterVolume(i, j);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, "Dead object in adjustMasterVolume", remoteexception);
          goto _L1
    }

    public void adjustStreamVolume(int i, int j, int k) {
        IAudioService iaudioservice = getService();
        try {
            if(mUseMasterVolume)
                iaudioservice.adjustMasterVolume(j, k);
            else
                iaudioservice.adjustStreamVolume(i, j, k);
        }
        catch(RemoteException remoteexception) {
            Log.e(TAG, "Dead object in adjustStreamVolume", remoteexception);
        }
    }

    public void adjustSuggestedStreamVolume(int i, int j, int k) {
        IAudioService iaudioservice = getService();
        try {
            if(mUseMasterVolume)
                iaudioservice.adjustMasterVolume(i, k);
            else
                iaudioservice.adjustSuggestedStreamVolume(i, j, k);
        }
        catch(RemoteException remoteexception) {
            Log.e(TAG, "Dead object in adjustSuggestedStreamVolume", remoteexception);
        }
    }

    public void adjustVolume(int i, int j) {
        IAudioService iaudioservice = getService();
        try {
            if(mUseMasterVolume)
                iaudioservice.adjustMasterVolume(i, j);
            else
                iaudioservice.adjustVolume(i, j);
        }
        catch(RemoteException remoteexception) {
            Log.e(TAG, "Dead object in adjustVolume", remoteexception);
        }
    }

    public void forceVolumeControlStream(int i) {
        IAudioService iaudioservice = getService();
        iaudioservice.forceVolumeControlStream(i, mICallBack);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, "Dead object in forceVolumeControlStream", remoteexception);
          goto _L1
    }

    public int getDevicesForStream(int i) {
        i;
        JVM INSTR tableswitch 0 8: default 52
    //                   0 56
    //                   1 56
    //                   2 56
    //                   3 56
    //                   4 56
    //                   5 56
    //                   6 52
    //                   7 52
    //                   8 56;
           goto _L1 _L2 _L2 _L2 _L2 _L2 _L2 _L1 _L1 _L2
_L1:
        int j = 0;
_L4:
        return j;
_L2:
        j = AudioSystem.getDevicesForStream(i);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int getLastAudibleMasterVolume() {
        IAudioService iaudioservice = getService();
        int j = iaudioservice.getLastAudibleMasterVolume();
        int i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, "Dead object in getLastAudibleMasterVolume", remoteexception);
        i = 0;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int getLastAudibleStreamVolume(int i) {
        IAudioService iaudioservice = getService();
        int j;
        int k;
        if(mUseMasterVolume) {
            j = iaudioservice.getLastAudibleMasterVolume();
            break MISSING_BLOCK_LABEL_53;
        }
        k = iaudioservice.getLastAudibleStreamVolume(i);
        j = k;
        break MISSING_BLOCK_LABEL_53;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, "Dead object in getLastAudibleStreamVolume", remoteexception);
        j = 0;
        return j;
    }

    public int getMasterMaxVolume() {
        IAudioService iaudioservice = getService();
        int j = iaudioservice.getMasterMaxVolume();
        int i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, "Dead object in getMasterMaxVolume", remoteexception);
        i = 0;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int getMasterStreamType() {
        IAudioService iaudioservice = getService();
        int j = iaudioservice.getMasterStreamType();
        int i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, "Dead object in getMasterStreamType", remoteexception);
        i = 2;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int getMasterVolume() {
        IAudioService iaudioservice = getService();
        int j = iaudioservice.getMasterVolume();
        int i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, "Dead object in getMasterVolume", remoteexception);
        i = 0;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int getMode() {
        IAudioService iaudioservice = getService();
        int j = iaudioservice.getMode();
        int i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, "Dead object in getMode", remoteexception);
        i = -2;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String getParameters(String s) {
        return AudioSystem.getParameters(s);
    }

    public int getRingerMode() {
        IAudioService iaudioservice = getService();
        int j = iaudioservice.getRingerMode();
        int i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, "Dead object in getRingerMode", remoteexception);
        i = 2;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public IRingtonePlayer getRingtonePlayer() {
        IRingtonePlayer iringtoneplayer1 = getService().getRingtonePlayer();
        IRingtonePlayer iringtoneplayer = iringtoneplayer1;
_L2:
        return iringtoneplayer;
        RemoteException remoteexception;
        remoteexception;
        iringtoneplayer = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int getRouting(int i) {
        return -1;
    }

    public int getStreamMaxVolume(int i) {
        IAudioService iaudioservice = getService();
        int j;
        int k;
        if(mUseMasterVolume) {
            j = iaudioservice.getMasterMaxVolume();
            break MISSING_BLOCK_LABEL_53;
        }
        k = iaudioservice.getStreamMaxVolume(i);
        j = k;
        break MISSING_BLOCK_LABEL_53;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, "Dead object in getStreamMaxVolume", remoteexception);
        j = 0;
        return j;
    }

    public int getStreamVolume(int i) {
        IAudioService iaudioservice = getService();
        int j;
        int k;
        if(mUseMasterVolume) {
            j = iaudioservice.getMasterVolume();
            break MISSING_BLOCK_LABEL_53;
        }
        k = iaudioservice.getStreamVolume(i);
        j = k;
        break MISSING_BLOCK_LABEL_53;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, "Dead object in getStreamVolume", remoteexception);
        j = 0;
        return j;
    }

    public int getVibrateSetting(int i) {
        IAudioService iaudioservice = getService();
        int k = iaudioservice.getVibrateSetting(i);
        int j = k;
_L2:
        return j;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, "Dead object in getVibrateSetting", remoteexception);
        j = 0;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void handleKeyDown(KeyEvent keyevent, int i) {
        boolean flag;
        int j;
        flag = true;
        j = keyevent.getKeyCode();
        j;
        JVM INSTR lookupswitch 3: default 44
    //                   24: 45
    //                   25: 45
    //                   164: 99;
           goto _L1 _L2 _L2 _L3
_L1:
        return;
_L2:
        if(mUseMasterVolume) {
            if(j != 24)
                flag = -1;
            adjustMasterVolume(flag, 17);
        } else {
            if(j != 24)
                flag = -1;
            adjustSuggestedStreamVolume(flag, i, 17);
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if(keyevent.getRepeatCount() == 0 && mUseMasterVolume) {
            if(isMasterMute())
                flag = false;
            setMasterMute(flag);
        }
        if(true) goto _L1; else goto _L4
_L4:
    }

    public void handleKeyUp(KeyEvent keyevent, int i) {
        int j = keyevent.getKeyCode();
        j;
        JVM INSTR tableswitch 24 25: default 28
    //                   24 29
    //                   25 29;
           goto _L1 _L2 _L2
_L1:
        return;
_L2:
        if(mUseMasterVolume) {
            if(j == 25)
                adjustMasterVolume(0, 4);
        } else {
            adjustSuggestedStreamVolume(0, i, 4);
        }
        mVolumeKeyUpTime = SystemClock.uptimeMillis();
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean isBluetoothA2dpOn() {
        boolean flag;
        if(AudioSystem.getDeviceConnectionState(128, "") == 0)
            flag = false;
        else
            flag = true;
        return flag;
    }

    public boolean isBluetoothScoAvailableOffCall() {
        return mContext.getResources().getBoolean(0x1110025);
    }

    public boolean isBluetoothScoOn() {
        IAudioService iaudioservice = getService();
        boolean flag1 = iaudioservice.isBluetoothScoOn();
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, "Dead object in isBluetoothScoOn", remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean isMasterMute() {
        IAudioService iaudioservice = getService();
        boolean flag1 = iaudioservice.isMasterMute();
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, "Dead object in isMasterMute", remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean isMicrophoneMute() {
        return AudioSystem.isMicrophoneMuted();
    }

    public boolean isMusicActive() {
        return AudioSystem.isStreamActive(3, 0);
    }

    public boolean isSilentMode() {
        boolean flag = true;
        int i = getRingerMode();
        if(i != 0 && i != flag)
            flag = false;
        return flag;
    }

    public boolean isSpeakerphoneOn() {
        IAudioService iaudioservice = getService();
        boolean flag1 = iaudioservice.isSpeakerphoneOn();
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, "Dead object in isSpeakerphoneOn", remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean isStreamMute(int i) {
        IAudioService iaudioservice = getService();
        boolean flag1 = iaudioservice.isStreamMute(i);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, "Dead object in isStreamMute", remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean isWiredHeadsetOn() {
        boolean flag;
        if(AudioSystem.getDeviceConnectionState(4, "") == 0 && AudioSystem.getDeviceConnectionState(8, "") == 0)
            flag = false;
        else
            flag = true;
        return flag;
    }

    public void loadSoundEffects() {
        IAudioService iaudioservice = getService();
        iaudioservice.loadSoundEffects();
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, (new StringBuilder()).append("Dead object in loadSoundEffects").append(remoteexception).toString());
          goto _L1
    }

    public void playSoundEffect(int i) {
        if(i >= 0 && i < 9 && querySoundEffectsEnabled()) {
            IAudioService iaudioservice = getService();
            try {
                iaudioservice.playSoundEffect(i);
            }
            catch(RemoteException remoteexception) {
                Log.e(TAG, (new StringBuilder()).append("Dead object in playSoundEffect").append(remoteexception).toString());
            }
        }
    }

    public void playSoundEffect(int i, float f) {
        if(i >= 0 && i < 9) {
            IAudioService iaudioservice = getService();
            try {
                iaudioservice.playSoundEffectVolume(i, f);
            }
            catch(RemoteException remoteexception) {
                Log.e(TAG, (new StringBuilder()).append("Dead object in playSoundEffect").append(remoteexception).toString());
            }
        }
    }

    public void preDispatchKeyEvent(KeyEvent keyevent, int i) {
        int j = keyevent.getKeyCode();
        if(j != 25 && j != 24 && j != 164 && 300L + mVolumeKeyUpTime > SystemClock.uptimeMillis())
            if(mUseMasterVolume)
                adjustMasterVolume(0, 8);
            else
                adjustSuggestedStreamVolume(0, i, 8);
    }

    public void registerAudioFocusListener(OnAudioFocusChangeListener onaudiofocuschangelistener) {
        Object obj = mFocusListenerLock;
        obj;
        JVM INSTR monitorenter ;
        if(!mAudioFocusIdListenerMap.containsKey(getIdForAudioFocusListener(onaudiofocuschangelistener)))
            mAudioFocusIdListenerMap.put(getIdForAudioFocusListener(onaudiofocuschangelistener), onaudiofocuschangelistener);
        return;
    }

    public void registerMediaButtonEventReceiver(ComponentName componentname) {
        if(componentname != null)
            if(!componentname.getPackageName().equals(mContext.getPackageName())) {
                Log.e(TAG, "registerMediaButtonEventReceiver() error: receiver and context package names don't match");
            } else {
                Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                intent.setComponent(componentname);
                registerMediaButtonIntent(PendingIntent.getBroadcast(mContext, 0, intent, 0), componentname);
            }
    }

    public void registerMediaButtonEventReceiverForCalls(ComponentName componentname) {
        if(componentname != null) {
            IAudioService iaudioservice = getService();
            try {
                iaudioservice.registerMediaButtonEventReceiverForCalls(componentname);
            }
            catch(RemoteException remoteexception) {
                Log.e(TAG, "Dead object in registerMediaButtonEventReceiverForCalls", remoteexception);
            }
        }
    }

    public void registerMediaButtonIntent(PendingIntent pendingintent, ComponentName componentname) {
        if(pendingintent == null || componentname == null) {
            Log.e(TAG, "Cannot call registerMediaButtonIntent() with a null parameter");
        } else {
            IAudioService iaudioservice = getService();
            try {
                iaudioservice.registerMediaButtonIntent(pendingintent, componentname);
            }
            catch(RemoteException remoteexception) {
                Log.e(TAG, (new StringBuilder()).append("Dead object in registerMediaButtonIntent").append(remoteexception).toString());
            }
        }
    }

    public void registerRemoteControlClient(RemoteControlClient remotecontrolclient) {
        if(remotecontrolclient != null && remotecontrolclient.getRcMediaIntent() != null) {
            IAudioService iaudioservice = getService();
            try {
                remotecontrolclient.setRcseId(iaudioservice.registerRemoteControlClient(remotecontrolclient.getRcMediaIntent(), remotecontrolclient.getIRemoteControlClient(), mContext.getPackageName()));
            }
            catch(RemoteException remoteexception) {
                Log.e(TAG, (new StringBuilder()).append("Dead object in registerRemoteControlClient").append(remoteexception).toString());
            }
        }
    }

    public void registerRemoteControlDisplay(IRemoteControlDisplay iremotecontroldisplay) {
        if(iremotecontroldisplay != null) {
            IAudioService iaudioservice = getService();
            try {
                iaudioservice.registerRemoteControlDisplay(iremotecontroldisplay);
            }
            catch(RemoteException remoteexception) {
                Log.e(TAG, (new StringBuilder()).append("Dead object in registerRemoteControlDisplay ").append(remoteexception).toString());
            }
        }
    }

    public void reloadAudioSettings() {
        IAudioService iaudioservice = getService();
        iaudioservice.reloadAudioSettings();
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, (new StringBuilder()).append("Dead object in reloadAudioSettings").append(remoteexception).toString());
          goto _L1
    }

    public void remoteControlDisplayUsesBitmapSize(IRemoteControlDisplay iremotecontroldisplay, int i, int j) {
        if(iremotecontroldisplay != null) {
            IAudioService iaudioservice = getService();
            try {
                iaudioservice.remoteControlDisplayUsesBitmapSize(iremotecontroldisplay, i, j);
            }
            catch(RemoteException remoteexception) {
                Log.e(TAG, (new StringBuilder()).append("Dead object in remoteControlDisplayUsesBitmapSize ").append(remoteexception).toString());
            }
        }
    }

    public int requestAudioFocus(OnAudioFocusChangeListener onaudiofocuschangelistener, int i, int j) {
        int k = 0;
        if(j >= 1 && j <= 3) goto _L2; else goto _L1
_L1:
        int l;
        Log.e(TAG, "Invalid duration hint, audio focus request denied");
        l = 0;
_L4:
        return l;
_L2:
        IAudioService iaudioservice;
        registerAudioFocusListener(onaudiofocuschangelistener);
        iaudioservice = getService();
        int i1 = iaudioservice.requestAudioFocus(i, j, mICallBack, mAudioFocusDispatcher, getIdForAudioFocusListener(onaudiofocuschangelistener), mContext.getPackageName());
        k = i1;
_L5:
        l = k;
        if(true) goto _L4; else goto _L3
_L3:
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, (new StringBuilder()).append("Can't call requestAudioFocus() on AudioService due to ").append(remoteexception).toString());
          goto _L5
    }

    public void requestAudioFocusForCall(int i, int j) {
        IAudioService iaudioservice = getService();
        iaudioservice.requestAudioFocus(i, j, mICallBack, null, "AudioFocus_For_Phone_Ring_And_Calls", "system");
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, (new StringBuilder()).append("Can't call requestAudioFocusForCall() on AudioService due to ").append(remoteexception).toString());
          goto _L1
    }

    public int setBluetoothA2dpDeviceConnectionState(BluetoothDevice bluetoothdevice, int i) {
        IAudioService iaudioservice;
        int j;
        iaudioservice = getService();
        j = 0;
        int k = iaudioservice.setBluetoothA2dpDeviceConnectionState(bluetoothdevice, i);
        j = k;
_L2:
        return j;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, (new StringBuilder()).append("Dead object in setBluetoothA2dpDeviceConnectionState ").append(remoteexception).toString());
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void setBluetoothA2dpOn(boolean flag) {
    }

    public void setBluetoothScoOn(boolean flag) {
        IAudioService iaudioservice = getService();
        iaudioservice.setBluetoothScoOn(flag);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, "Dead object in setBluetoothScoOn", remoteexception);
          goto _L1
    }

    public void setMasterMute(boolean flag) {
        setMasterMute(flag, 1);
    }

    public void setMasterMute(boolean flag, int i) {
        IAudioService iaudioservice = getService();
        iaudioservice.setMasterMute(flag, i, mICallBack);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, "Dead object in setMasterMute", remoteexception);
          goto _L1
    }

    public void setMasterVolume(int i, int j) {
        IAudioService iaudioservice = getService();
        iaudioservice.setMasterVolume(i, j);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, "Dead object in setMasterVolume", remoteexception);
          goto _L1
    }

    public void setMicrophoneMute(boolean flag) {
        AudioSystem.muteMicrophone(flag);
    }

    public void setMode(int i) {
        IAudioService iaudioservice = getService();
        iaudioservice.setMode(i, mICallBack);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, "Dead object in setMode", remoteexception);
          goto _L1
    }

    public void setParameter(String s, String s1) {
        setParameters((new StringBuilder()).append(s).append("=").append(s1).toString());
    }

    public void setParameters(String s) {
        AudioSystem.setParameters(s);
    }

    public void setRingerMode(int i) {
        if(isValidRingerMode(i)) {
            IAudioService iaudioservice = getService();
            try {
                iaudioservice.setRingerMode(i);
            }
            catch(RemoteException remoteexception) {
                Log.e(TAG, "Dead object in setRingerMode", remoteexception);
            }
        }
    }

    public void setRouting(int i, int j, int k) {
    }

    public void setSpeakerphoneOn(boolean flag) {
        IAudioService iaudioservice = getService();
        iaudioservice.setSpeakerphoneOn(flag);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, "Dead object in setSpeakerphoneOn", remoteexception);
          goto _L1
    }

    public void setStreamMute(int i, boolean flag) {
        IAudioService iaudioservice = getService();
        iaudioservice.setStreamMute(i, flag, mICallBack);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, "Dead object in setStreamMute", remoteexception);
          goto _L1
    }

    public void setStreamSolo(int i, boolean flag) {
        IAudioService iaudioservice = getService();
        iaudioservice.setStreamSolo(i, flag, mICallBack);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, "Dead object in setStreamSolo", remoteexception);
          goto _L1
    }

    public void setStreamVolume(int i, int j, int k) {
        IAudioService iaudioservice = getService();
        try {
            if(mUseMasterVolume)
                iaudioservice.setMasterVolume(j, k);
            else
                iaudioservice.setStreamVolume(i, j, k);
        }
        catch(RemoteException remoteexception) {
            Log.e(TAG, "Dead object in setStreamVolume", remoteexception);
        }
    }

    public void setVibrateSetting(int i, int j) {
        IAudioService iaudioservice = getService();
        iaudioservice.setVibrateSetting(i, j);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, "Dead object in setVibrateSetting", remoteexception);
          goto _L1
    }

    public void setWiredDeviceConnectionState(int i, int j, String s) {
        IAudioService iaudioservice = getService();
        iaudioservice.setWiredDeviceConnectionState(i, j, s);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, (new StringBuilder()).append("Dead object in setWiredDeviceConnectionState ").append(remoteexception).toString());
          goto _L1
    }

    public void setWiredHeadsetOn(boolean flag) {
    }

    public boolean shouldVibrate(int i) {
        IAudioService iaudioservice = getService();
        boolean flag1 = iaudioservice.shouldVibrate(i);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, "Dead object in shouldVibrate", remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void startBluetoothSco() {
        IAudioService iaudioservice = getService();
        iaudioservice.startBluetoothSco(mICallBack);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, "Dead object in startBluetoothSco", remoteexception);
          goto _L1
    }

    public void stopBluetoothSco() {
        IAudioService iaudioservice = getService();
        iaudioservice.stopBluetoothSco(mICallBack);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, "Dead object in stopBluetoothSco", remoteexception);
          goto _L1
    }

    public void unloadSoundEffects() {
        IAudioService iaudioservice = getService();
        iaudioservice.unloadSoundEffects();
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, (new StringBuilder()).append("Dead object in unloadSoundEffects").append(remoteexception).toString());
          goto _L1
    }

    public void unregisterAudioFocusListener(OnAudioFocusChangeListener onaudiofocuschangelistener) {
        Object obj = mFocusListenerLock;
        obj;
        JVM INSTR monitorenter ;
        mAudioFocusIdListenerMap.remove(getIdForAudioFocusListener(onaudiofocuschangelistener));
        return;
    }

    public void unregisterMediaButtonEventReceiver(ComponentName componentname) {
        if(componentname != null) {
            Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
            intent.setComponent(componentname);
            unregisterMediaButtonIntent(PendingIntent.getBroadcast(mContext, 0, intent, 0), componentname);
        }
    }

    public void unregisterMediaButtonEventReceiverForCalls() {
        IAudioService iaudioservice = getService();
        iaudioservice.unregisterMediaButtonEventReceiverForCalls();
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, "Dead object in unregisterMediaButtonEventReceiverForCalls", remoteexception);
          goto _L1
    }

    public void unregisterMediaButtonIntent(PendingIntent pendingintent, ComponentName componentname) {
        IAudioService iaudioservice = getService();
        iaudioservice.unregisterMediaButtonIntent(pendingintent, componentname);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, (new StringBuilder()).append("Dead object in unregisterMediaButtonIntent").append(remoteexception).toString());
          goto _L1
    }

    public void unregisterRemoteControlClient(RemoteControlClient remotecontrolclient) {
        if(remotecontrolclient != null && remotecontrolclient.getRcMediaIntent() != null) {
            IAudioService iaudioservice = getService();
            try {
                iaudioservice.unregisterRemoteControlClient(remotecontrolclient.getRcMediaIntent(), remotecontrolclient.getIRemoteControlClient());
            }
            catch(RemoteException remoteexception) {
                Log.e(TAG, (new StringBuilder()).append("Dead object in unregisterRemoteControlClient").append(remoteexception).toString());
            }
        }
    }

    public void unregisterRemoteControlDisplay(IRemoteControlDisplay iremotecontroldisplay) {
        if(iremotecontroldisplay != null) {
            IAudioService iaudioservice = getService();
            try {
                iaudioservice.unregisterRemoteControlDisplay(iremotecontroldisplay);
            }
            catch(RemoteException remoteexception) {
                Log.e(TAG, (new StringBuilder()).append("Dead object in unregisterRemoteControlDisplay ").append(remoteexception).toString());
            }
        }
    }

    public static final String ACTION_AUDIO_BECOMING_NOISY = "android.media.AUDIO_BECOMING_NOISY";
    public static final String ACTION_SCO_AUDIO_STATE_CHANGED = "android.media.SCO_AUDIO_STATE_CHANGED";
    public static final String ACTION_SCO_AUDIO_STATE_UPDATED = "android.media.ACTION_SCO_AUDIO_STATE_UPDATED";
    public static final int ADJUST_LOWER = -1;
    public static final int ADJUST_RAISE = 1;
    public static final int ADJUST_SAME = 0;
    public static final int AUDIOFOCUS_GAIN = 1;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT = 2;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK = 3;
    public static final int AUDIOFOCUS_LOSS = -1;
    public static final int AUDIOFOCUS_LOSS_TRANSIENT = -2;
    public static final int AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK = -3;
    public static final int AUDIOFOCUS_REQUEST_FAILED = 0;
    public static final int AUDIOFOCUS_REQUEST_GRANTED = 1;
    public static final int DEFAULT_STREAM_VOLUME[];
    public static final int DEVICE_OUT_ANLG_DOCK_HEADSET = 2048;
    public static final int DEVICE_OUT_AUX_DIGITAL = 1024;
    public static final int DEVICE_OUT_BLUETOOTH_A2DP = 128;
    public static final int DEVICE_OUT_BLUETOOTH_A2DP_HEADPHONES = 256;
    public static final int DEVICE_OUT_BLUETOOTH_A2DP_SPEAKER = 512;
    public static final int DEVICE_OUT_BLUETOOTH_SCO = 16;
    public static final int DEVICE_OUT_BLUETOOTH_SCO_CARKIT = 64;
    public static final int DEVICE_OUT_BLUETOOTH_SCO_HEADSET = 32;
    public static final int DEVICE_OUT_DEFAULT = 32768;
    public static final int DEVICE_OUT_DGTL_DOCK_HEADSET = 4096;
    public static final int DEVICE_OUT_EARPIECE = 1;
    public static final int DEVICE_OUT_SPEAKER = 2;
    public static final int DEVICE_OUT_USB_ACCESSORY = 8192;
    public static final int DEVICE_OUT_USB_DEVICE = 16384;
    public static final int DEVICE_OUT_WIRED_HEADPHONE = 8;
    public static final int DEVICE_OUT_WIRED_HEADSET = 4;
    public static final String EXTRA_MASTER_VOLUME_MUTED = "android.media.EXTRA_MASTER_VOLUME_MUTED";
    public static final String EXTRA_MASTER_VOLUME_VALUE = "android.media.EXTRA_MASTER_VOLUME_VALUE";
    public static final String EXTRA_PREV_MASTER_VOLUME_VALUE = "android.media.EXTRA_PREV_MASTER_VOLUME_VALUE";
    public static final String EXTRA_PREV_VOLUME_STREAM_VALUE = "android.media.EXTRA_PREV_VOLUME_STREAM_VALUE";
    public static final String EXTRA_REMOTE_CONTROL_CLIENT_GENERATION = "android.media.EXTRA_REMOTE_CONTROL_CLIENT_GENERATION";
    public static final String EXTRA_REMOTE_CONTROL_CLIENT_INFO_CHANGED = "android.media.EXTRA_REMOTE_CONTROL_CLIENT_INFO_CHANGED";
    public static final String EXTRA_REMOTE_CONTROL_CLIENT_NAME = "android.media.EXTRA_REMOTE_CONTROL_CLIENT_NAME";
    public static final String EXTRA_REMOTE_CONTROL_EVENT_RECEIVER = "android.media.EXTRA_REMOTE_CONTROL_EVENT_RECEIVER";
    public static final String EXTRA_RINGER_MODE = "android.media.EXTRA_RINGER_MODE";
    public static final String EXTRA_SCO_AUDIO_PREVIOUS_STATE = "android.media.extra.SCO_AUDIO_PREVIOUS_STATE";
    public static final String EXTRA_SCO_AUDIO_STATE = "android.media.extra.SCO_AUDIO_STATE";
    public static final String EXTRA_VIBRATE_SETTING = "android.media.EXTRA_VIBRATE_SETTING";
    public static final String EXTRA_VIBRATE_TYPE = "android.media.EXTRA_VIBRATE_TYPE";
    public static final String EXTRA_VOLUME_STREAM_TYPE = "android.media.EXTRA_VOLUME_STREAM_TYPE";
    public static final String EXTRA_VOLUME_STREAM_VALUE = "android.media.EXTRA_VOLUME_STREAM_VALUE";
    public static final int FLAG_ALLOW_RINGER_MODES = 2;
    public static final int FLAG_PLAY_SOUND = 4;
    public static final int FLAG_REMOVE_SOUND_AND_VIBRATE = 8;
    public static final int FLAG_SHOW_UI = 1;
    public static final int FLAG_VIBRATE = 16;
    public static final int FX_FOCUS_NAVIGATION_DOWN = 2;
    public static final int FX_FOCUS_NAVIGATION_LEFT = 3;
    public static final int FX_FOCUS_NAVIGATION_RIGHT = 4;
    public static final int FX_FOCUS_NAVIGATION_UP = 1;
    public static final int FX_KEYPRESS_DELETE = 7;
    public static final int FX_KEYPRESS_RETURN = 8;
    public static final int FX_KEYPRESS_SPACEBAR = 6;
    public static final int FX_KEYPRESS_STANDARD = 5;
    public static final int FX_KEY_CLICK = 0;
    public static final String MASTER_MUTE_CHANGED_ACTION = "android.media.MASTER_MUTE_CHANGED_ACTION";
    public static final String MASTER_VOLUME_CHANGED_ACTION = "android.media.MASTER_VOLUME_CHANGED_ACTION";
    public static final int MODE_CURRENT = -1;
    public static final int MODE_INVALID = -2;
    public static final int MODE_IN_CALL = 2;
    public static final int MODE_IN_COMMUNICATION = 3;
    public static final int MODE_NORMAL = 0;
    public static final int MODE_RINGTONE = 1;
    public static final int NUM_SOUND_EFFECTS = 9;
    public static final int NUM_STREAMS = 5;
    public static final String REMOTE_CONTROL_CLIENT_CHANGED = "android.media.REMOTE_CONTROL_CLIENT_CHANGED";
    public static final String RINGER_MODE_CHANGED_ACTION = "android.media.RINGER_MODE_CHANGED";
    private static final int RINGER_MODE_MAX = 2;
    public static final int RINGER_MODE_NORMAL = 2;
    public static final int RINGER_MODE_SILENT = 0;
    public static final int RINGER_MODE_VIBRATE = 1;
    public static final int ROUTE_ALL = -1;
    public static final int ROUTE_BLUETOOTH = 4;
    public static final int ROUTE_BLUETOOTH_A2DP = 16;
    public static final int ROUTE_BLUETOOTH_SCO = 4;
    public static final int ROUTE_EARPIECE = 1;
    public static final int ROUTE_HEADSET = 8;
    public static final int ROUTE_SPEAKER = 2;
    public static final int SCO_AUDIO_STATE_CONNECTED = 1;
    public static final int SCO_AUDIO_STATE_CONNECTING = 2;
    public static final int SCO_AUDIO_STATE_DISCONNECTED = 0;
    public static final int SCO_AUDIO_STATE_ERROR = -1;
    public static final int STREAM_ALARM = 4;
    public static final int STREAM_BLUETOOTH_SCO = 6;
    public static final int STREAM_DTMF = 8;
    public static final int STREAM_MUSIC = 3;
    public static final int STREAM_NOTIFICATION = 5;
    public static final int STREAM_RING = 2;
    public static final int STREAM_SYSTEM = 1;
    public static final int STREAM_SYSTEM_ENFORCED = 7;
    public static final int STREAM_TTS = 9;
    public static final int STREAM_VOICE_CALL = 0;
    private static String TAG = "AudioManager";
    public static final int USE_DEFAULT_STREAM_TYPE = 0x80000000;
    public static final String VIBRATE_SETTING_CHANGED_ACTION = "android.media.VIBRATE_SETTING_CHANGED";
    public static final int VIBRATE_SETTING_OFF = 0;
    public static final int VIBRATE_SETTING_ON = 1;
    public static final int VIBRATE_SETTING_ONLY_SILENT = 2;
    public static final int VIBRATE_TYPE_NOTIFICATION = 1;
    public static final int VIBRATE_TYPE_RINGER = 0;
    public static final String VOLUME_CHANGED_ACTION = "android.media.VOLUME_CHANGED_ACTION";
    private static IAudioService sService;
    private final IAudioFocusDispatcher mAudioFocusDispatcher = new IAudioFocusDispatcher.Stub() {

        public void dispatchAudioFocusChange(int i, String s) {
            Message message = mAudioFocusEventHandlerDelegate.getHandler().obtainMessage(i, s);
            mAudioFocusEventHandlerDelegate.getHandler().sendMessage(message);
        }

        final AudioManager this$0;

             {
                this$0 = AudioManager.this;
                super();
            }
    };
    private final FocusEventHandlerDelegate mAudioFocusEventHandlerDelegate = new FocusEventHandlerDelegate();
    private final HashMap mAudioFocusIdListenerMap = new HashMap();
    private final Context mContext;
    private final Object mFocusListenerLock = new Object();
    private final IBinder mICallBack = new Binder();
    private final boolean mUseMasterVolume;
    private long mVolumeKeyUpTime;

    static  {
        int ai[] = new int[10];
        ai[0] = 4;
        ai[1] = 7;
        ai[2] = 5;
        ai[3] = 11;
        ai[4] = 6;
        ai[5] = 5;
        ai[6] = 7;
        ai[7] = 7;
        ai[8] = 11;
        ai[9] = 11;
        DEFAULT_STREAM_VOLUME = ai;
    }



}

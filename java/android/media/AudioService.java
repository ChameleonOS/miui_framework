// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import android.app.*;
import android.bluetooth.*;
import android.content.*;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.*;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import com.android.internal.telephony.ITelephony;
import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import miui.view.VolumePanel;

// Referenced classes of package android.media:
//            AudioRoutesInfo, AudioSystem, AudioManager, IAudioFocusDispatcher, 
//            IRemoteControlClient, IRemoteControlDisplay, IRemoteVolumeObserver, SoundPool, 
//            IRingtonePlayer, IAudioRoutesObserver, MediaPlayer

public class AudioService extends IAudioService.Stub
    implements android.app.PendingIntent.OnFinished {
    private class RcDisplayDeathHandler
        implements android.os.IBinder.DeathRecipient {

        public void binderDied() {
            Stack stack = mRCStack;
            stack;
            JVM INSTR monitorenter ;
            Log.w("AudioService", "RemoteControl: display died");
            mRcDisplay = null;
            return;
        }

        public void unlinkToRcDisplayDeath() {
            mCb.unlinkToDeath(this, 0);
_L1:
            return;
            NoSuchElementException nosuchelementexception;
            nosuchelementexception;
            Log.e("AudioService", (new StringBuilder()).append("Encountered ").append(nosuchelementexception).append(" in unlinkToRcDisplayDeath()").toString());
            nosuchelementexception.printStackTrace();
              goto _L1
        }

        private IBinder mCb;
        final AudioService this$0;

        public RcDisplayDeathHandler(IBinder ibinder) {
            this$0 = AudioService.this;
            super();
            mCb = ibinder;
        }
    }

    /* member class not found */
    class RemoteControlStackEntry {}

    private class RemotePlaybackState {

        int mRccId;
        int mVolume;
        int mVolumeHandling;
        int mVolumeMax;
        final AudioService this$0;

        private RemotePlaybackState(int i, int j, int k) {
            this$0 = AudioService.this;
            Object();
            mRccId = i;
            mVolume = j;
            mVolumeMax = k;
            mVolumeHandling = 1;
        }

    }

    private class RcClientDeathHandler
        implements android.os.IBinder.DeathRecipient {

        public void binderDied() {
            Log.w("AudioService", "  RemoteControlClient died");
            registerRemoteControlClient(mMediaIntent, null, null);
            postReevaluateRemote();
        }

        public IBinder getBinder() {
            return mCb;
        }

        private IBinder mCb;
        private PendingIntent mMediaIntent;
        final AudioService this$0;


        RcClientDeathHandler(IBinder ibinder, PendingIntent pendingintent) {
            this$0 = AudioService.this;
            Object();
            mCb = ibinder;
            mMediaIntent = pendingintent;
        }
    }

    private class AudioFocusDeathHandler
        implements android.os.IBinder.DeathRecipient {

        public void binderDied() {
            Object obj = AudioService.mAudioFocusLock;
            obj;
            JVM INSTR monitorenter ;
            Log.w("AudioService", "  AudioFocus   audio focus client died");
            removeFocusStackEntryForClient(mCb);
            return;
        }

        public IBinder getBinder() {
            return mCb;
        }

        private IBinder mCb;
        final AudioService this$0;

        AudioFocusDeathHandler(IBinder ibinder) {
            this$0 = AudioService.this;
            Object();
            mCb = ibinder;
        }
    }

    private static class FocusStackEntry {

        protected void finalize() throws Throwable {
            unlinkToDeath();
            super.finalize();
        }

        public void unlinkToDeath() {
            if(mSourceRef != null && mHandler != null) {
                mSourceRef.unlinkToDeath(mHandler, 0);
                mHandler = null;
            }
_L1:
            return;
            NoSuchElementException nosuchelementexception;
            nosuchelementexception;
            Log.e("AudioService", (new StringBuilder()).append("Encountered ").append(nosuchelementexception).append(" in FocusStackEntry.unlinkToDeath()").toString());
              goto _L1
        }

        public int mCallingUid;
        public String mClientId;
        public int mFocusChangeType;
        public IAudioFocusDispatcher mFocusDispatcher;
        public AudioFocusDeathHandler mHandler;
        public String mPackageName;
        public IBinder mSourceRef;
        public int mStreamType;

        public FocusStackEntry() {
            mStreamType = -1;
            mFocusDispatcher = null;
            mSourceRef = null;
        }

        public FocusStackEntry(int i, int j, IAudioFocusDispatcher iaudiofocusdispatcher, IBinder ibinder, String s, AudioFocusDeathHandler audiofocusdeathhandler, String s1, 
                int k) {
            mStreamType = -1;
            mFocusDispatcher = null;
            mSourceRef = null;
            mStreamType = i;
            mFocusDispatcher = iaudiofocusdispatcher;
            mSourceRef = ibinder;
            mClientId = s;
            mFocusChangeType = j;
            mHandler = audiofocusdeathhandler;
            mPackageName = s1;
            mCallingUid = k;
        }
    }

    private class AudioServiceBroadcastReceiver extends BroadcastReceiver {

        public void onReceive(Context context, Intent intent) {
            String s = intent.getAction();
            if(!s.equals("android.intent.action.DOCK_EVENT")) goto _L2; else goto _L1
_L1:
            intent.getIntExtra("android.intent.extra.DOCK_STATE", 0);
            JVM INSTR tableswitch 1 4: default 52
        //                       1 63
        //                       2 70
        //                       3 77
        //                       4 84;
               goto _L3 _L4 _L5 _L6 _L7
_L3:
            int j1 = 0;
_L8:
            AudioSystem.setForceUse(3, j1);
_L10:
            return;
_L4:
            j1 = 7;
              goto _L8
_L5:
            j1 = 6;
              goto _L8
_L6:
            j1 = 8;
              goto _L8
_L7:
            j1 = 9;
              goto _L8
_L2:
            int i1;
            byte byte1;
            BluetoothDevice bluetoothdevice;
            if(!s.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED"))
                break MISSING_BLOCK_LABEL_305;
            i1 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
            byte1 = 16;
            bluetoothdevice = (BluetoothDevice)intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if(bluetoothdevice == null) goto _L10; else goto _L9
_L9:
            String s4;
            BluetoothClass bluetoothclass;
            s4 = bluetoothdevice.getAddress();
            bluetoothclass = bluetoothdevice.getBluetoothClass();
            if(bluetoothclass == null) goto _L12; else goto _L11
_L11:
            bluetoothclass.getDeviceClass();
            JVM INSTR lookupswitch 3: default 188
        //                       1028: 266
        //                       1032: 266
        //                       1056: 273;
               goto _L12 _L13 _L13 _L14
_L12:
            if(!BluetoothAdapter.checkBluetoothAddress(s4))
                s4 = "";
            boolean flag2;
            ArrayList arraylist1;
            Exception exception1;
            if(i1 == 2)
                flag2 = true;
            else
                flag2 = false;
            if(!handleDeviceConnection(flag2, byte1, s4)) goto _L10; else goto _L15
_L15:
            arraylist1 = mScoClients;
            arraylist1;
            JVM INSTR monitorenter ;
            if(!flag2)
                break MISSING_BLOCK_LABEL_286;
            mBluetoothHeadsetDevice = bluetoothdevice;
_L16:
            arraylist1;
            JVM INSTR monitorexit ;
              goto _L10
            exception1;
            throw exception1;
_L13:
            byte1 = 32;
              goto _L12
_L14:
            byte1 = 64;
              goto _L12
            mBluetoothHeadsetDevice = null;
            resetBluetoothSco();
              goto _L16
label0:
            {
                if(!s.equals("android.intent.action.USB_AUDIO_ACCESSORY_PLUG") && !s.equals("android.intent.action.USB_AUDIO_DEVICE_PLUG"))
                    break label0;
                int i = intent.getIntExtra("state", 0);
                int j = intent.getIntExtra("card", -1);
                int k = intent.getIntExtra("device", -1);
                String s1;
                char c;
                StringBuilder stringbuilder;
                String s2;
                AudioService audioservice;
                boolean flag;
                if(j == -1 && k == -1)
                    s1 = "";
                else
                    s1 = (new StringBuilder()).append("card=").append(j).append(";device=").append(k).toString();
                if(s.equals("android.intent.action.USB_AUDIO_ACCESSORY_PLUG"))
                    c = '\u2000';
                else
                    c = '\u4000';
                stringbuilder = (new StringBuilder()).append("Broadcast Receiver: Got ");
                if(s.equals("android.intent.action.USB_AUDIO_ACCESSORY_PLUG"))
                    s2 = "ACTION_USB_AUDIO_ACCESSORY_PLUG";
                else
                    s2 = "ACTION_USB_AUDIO_DEVICE_PLUG";
                Log.v("AudioService", stringbuilder.append(s2).append(", state = ").append(i).append(", card: ").append(j).append(", device: ").append(k).toString());
                audioservice = AudioService.this;
                if(i == 1)
                    flag = true;
                else
                    flag = false;
                audioservice.handleDeviceConnection(flag, c, s1);
            }
            if(true) goto _L10; else goto _L17
_L17:
            if(!s.equals("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED")) goto _L19; else goto _L18
_L18:
            boolean flag1;
            byte byte0;
            flag1 = false;
            byte0 = -1;
            ArrayList arraylist = mScoClients;
            arraylist;
            JVM INSTR monitorenter ;
            int l = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
            Exception exception;
            if(!mScoClients.isEmpty() && (mScoAudioState == 3 || mScoAudioState == 1 || mScoAudioState == 5))
                flag1 = true;
              goto _L20
_L21:
            if(flag1) {
                broadcastScoConnectionState(byte0);
                Intent intent2 = new Intent("android.media.SCO_AUDIO_STATE_CHANGED");
                intent2.putExtra("android.media.extra.SCO_AUDIO_STATE", byte0);
                mContext.sendStickyBroadcast(intent2);
            }
              goto _L10
_L26:
            byte0 = 1;
            if(mScoAudioState != 3 && mScoAudioState != 5 && mScoAudioState != 4)
                mScoAudioState = 2;
              goto _L21
            exception;
            throw exception;
_L24:
            byte0 = 0;
            mScoAudioState = 0;
            clearAllScoClients(0, false);
              goto _L21
_L25:
            if(mScoAudioState != 3 && mScoAudioState != 5 && mScoAudioState != 4)
                mScoAudioState = 2;
              goto _L22
_L19:
            if(s.equals("android.intent.action.BOOT_COMPLETED")) {
                mBootCompleted = true;
                AudioService.sendMsg(mAudioHandler, 8, 1, 0, 0, null, 0);
                mKeyguardManager = (KeyguardManager)mContext.getSystemService("keyguard");
                mScoConnectionState = -1;
                resetBluetoothSco();
                getBluetoothHeadset();
                Intent intent1 = new Intent("android.media.SCO_AUDIO_STATE_CHANGED");
                intent1.putExtra("android.media.extra.SCO_AUDIO_STATE", 0);
                mContext.sendStickyBroadcast(intent1);
                BluetoothAdapter bluetoothadapter = BluetoothAdapter.getDefaultAdapter();
                if(bluetoothadapter != null)
                    bluetoothadapter.getProfileProxy(mContext, mBluetoothProfileServiceListener, 2);
            } else
            if(s.equals("android.intent.action.PACKAGE_REMOVED")) {
                if(!intent.getBooleanExtra("android.intent.extra.REPLACING", false)) {
                    String s3 = intent.getData().getSchemeSpecificPart();
                    if(s3 != null)
                        removeMediaButtonReceiverForPackage(s3);
                }
            } else
            if(s.equals("android.intent.action.SCREEN_ON"))
                AudioSystem.setParameters("screen_state=on");
            else
            if(s.equals("android.intent.action.SCREEN_OFF"))
                AudioSystem.setParameters("screen_state=off");
            else
            if(s.equalsIgnoreCase("android.intent.action.CONFIGURATION_CHANGED"))
                handleConfigurationChanged(context);
              goto _L10
_L20:
            l;
            JVM INSTR tableswitch 10 12: default 1092
        //                       10 739
        //                       11 763
        //                       12 683;
               goto _L23 _L24 _L25 _L26
_L23:
            if(false) goto _L27; else goto _L22
_L27:
            if(true) goto _L21; else goto _L28
_L28:
_L22:
            flag1 = false;
              goto _L21
        }

        final AudioService this$0;

        private AudioServiceBroadcastReceiver() {
            this$0 = AudioService.this;
            BroadcastReceiver();
        }

    }

    private class SettingsObserver extends ContentObserver {

        public void onChange(boolean flag) {
            super.onChange(flag);
            Object obj = mSettingsLock;
            obj;
            JVM INSTR monitorenter ;
            int i = android.provider.Settings.System.getInt(mContentResolver, "mode_ringer_streams_affected", 166);
            int j;
            if(mVoiceCapable)
                j = i & -9;
            else
                j = i | 8;
            if(j != mRingerModeAffectedStreams) {
                mRingerModeAffectedStreams = j;
                setRingerModeInt(getRingerMode(), false);
            }
            return;
        }

        final AudioService this$0;

        SettingsObserver() {
            this$0 = AudioService.this;
            ContentObserver(new Handler());
            mContentResolver.registerContentObserver(android.provider.Settings.System.getUriFor("mode_ringer_streams_affected"), false, this);
        }
    }

    private class AudioHandler extends Handler {

        private void cleanupPlayer(MediaPlayer mediaplayer) {
            if(mediaplayer == null)
                break MISSING_BLOCK_LABEL_12;
            mediaplayer.stop();
            mediaplayer.release();
_L1:
            return;
            IllegalStateException illegalstateexception;
            illegalstateexception;
            Log.w("AudioService", (new StringBuilder()).append("MediaPlayer IllegalStateException: ").append(illegalstateexception).toString());
              goto _L1
        }

        private void onHandlePersistMediaButtonReceiver(ComponentName componentname) {
            ContentResolver contentresolver = mContentResolver;
            String s;
            if(componentname == null)
                s = "";
            else
                s = componentname.flattenToString();
            android.provider.Settings.System.putString(contentresolver, "media_button_receiver", s);
        }

        private void persistRingerMode(int i) {
            android.provider.Settings.System.putInt(mContentResolver, "mode_ringer", i);
        }

        private void persistVolume(VolumeStreamState volumestreamstate, int i, int j) {
            if((i & 1) != 0)
                android.provider.Settings.System.putInt(mContentResolver, volumestreamstate.getSettingNameForDevice(false, j), (5 + volumestreamstate.getIndex(j, false)) / 10);
            if((i & 2) != 0)
                android.provider.Settings.System.putInt(mContentResolver, volumestreamstate.getSettingNameForDevice(true, j), (5 + volumestreamstate.getIndex(j, true)) / 10);
        }

        private void playSoundEffect(int i, int j) {
            Object obj = mSoundEffectsLock;
            obj;
            JVM INSTR monitorenter ;
            if(mSoundPool != null) goto _L2; else goto _L1
_L2:
            Exception exception;
            float f;
            if(j < 0)
                f = (float)Math.pow(10D, AudioService.SOUND_EFFECT_VOLUME_DB / 20);
            else
                f = (float)j / 1000F;
            if(SOUND_EFFECT_FILES_MAP[i][1] <= 0) goto _L4; else goto _L3
_L3:
            mSoundPool.play(SOUND_EFFECT_FILES_MAP[i][1], f, f, 0, 0, 1.0F);
_L5:
            obj;
            JVM INSTR monitorexit ;
            break; /* Loop/switch isn't completed */
            exception;
            throw exception;
_L4:
            MediaPlayer mediaplayer = new MediaPlayer();
            mediaplayer.setDataSource((new StringBuilder()).append(Environment.getRootDirectory()).append("/media/audio/ui/").append(AudioService.SOUND_EFFECT_FILES[SOUND_EFFECT_FILES_MAP[i][0]]).toString());
            mediaplayer.setAudioStreamType(1);
            mediaplayer.prepare();
            mediaplayer.setVolume(f, f);
            mediaplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                public void onCompletion(MediaPlayer mediaplayer1) {
                    cleanupPlayer(mediaplayer1);
                }

                final AudioHandler this$1;

                 {
                    this$1 = AudioHandler.this;
                    Object();
                }
            });
            mediaplayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {

                public boolean onError(MediaPlayer mediaplayer1, int k, int l) {
                    cleanupPlayer(mediaplayer1);
                    return true;
                }

                final AudioHandler this$1;

                 {
                    this$1 = AudioHandler.this;
                    Object();
                }
            });
            mediaplayer.start();
            continue; /* Loop/switch isn't completed */
            IOException ioexception;
            ioexception;
            Log.w("AudioService", (new StringBuilder()).append("MediaPlayer IOException: ").append(ioexception).toString());
            continue; /* Loop/switch isn't completed */
            IllegalArgumentException illegalargumentexception;
            illegalargumentexception;
            Log.w("AudioService", (new StringBuilder()).append("MediaPlayer IllegalArgumentException: ").append(illegalargumentexception).toString());
            continue; /* Loop/switch isn't completed */
            IllegalStateException illegalstateexception;
            illegalstateexception;
            Log.w("AudioService", (new StringBuilder()).append("MediaPlayer IllegalStateException: ").append(illegalstateexception).toString());
            if(true) goto _L5; else goto _L1
_L1:
        }

        private void setAllVolumes(VolumeStreamState volumestreamstate) {
            volumestreamstate.applyAllVolumes();
            for(int i = -1 + AudioSystem.getNumStreamTypes(); i >= 0; i--)
                if(i != volumestreamstate.mStreamType && mStreamVolumeAlias[i] == volumestreamstate.mStreamType)
                    mStreamStates[i].applyAllVolumes();

        }

        private void setDeviceVolume(VolumeStreamState volumestreamstate, int i) {
            volumestreamstate.applyDeviceVolume(i);
            for(int j = -1 + AudioSystem.getNumStreamTypes(); j >= 0; j--)
                if(j != volumestreamstate.mStreamType && mStreamVolumeAlias[j] == volumestreamstate.mStreamType)
                    mStreamStates[j].applyDeviceVolume(getDeviceForStream(j));

            AudioService.sendMsg(mAudioHandler, 1, 2, 3, i, volumestreamstate, 500);
        }

        private void setForceUse(int i, int j) {
            AudioSystem.setForceUse(i, j);
        }

        public void handleMessage(Message message) {
            message.what;
            JVM INSTR tableswitch 0 21: default 108
        //                       0 109
        //                       1 141
        //                       2 163
        //                       3 209
        //                       4 223
        //                       5 273
        //                       6 584
        //                       7 599
        //                       8 573
        //                       9 639
        //                       10 654
        //                       11 699
        //                       12 668
        //                       13 678
        //                       14 127
        //                       15 188
        //                       16 775
        //                       17 878
        //                       18 888
        //                       19 916
        //                       20 709
        //                       21 744;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23
_L1:
            return;
_L2:
            setDeviceVolume((VolumeStreamState)message.obj, message.arg1);
            continue; /* Loop/switch isn't completed */
_L16:
            setAllVolumes((VolumeStreamState)message.obj);
            continue; /* Loop/switch isn't completed */
_L3:
            persistVolume((VolumeStreamState)message.obj, message.arg1, message.arg2);
            continue; /* Loop/switch isn't completed */
_L4:
            android.provider.Settings.System.putFloat(mContentResolver, "volume_master", (float)message.arg1 / 1000F);
            continue; /* Loop/switch isn't completed */
_L17:
            android.provider.Settings.System.putInt(mContentResolver, "volume_master_mute", message.arg1);
            continue; /* Loop/switch isn't completed */
_L5:
            persistRingerMode(getRingerMode());
            continue; /* Loop/switch isn't completed */
_L6:
            if(!mMediaServerOk) {
                Log.e("AudioService", "Media server died.");
                AudioSystem.setErrorCallback(mAudioSystemCallback);
                AudioService.sendMsg(mAudioHandler, 4, 1, 0, 0, null, 500);
            }
            continue; /* Loop/switch isn't completed */
_L7:
            Log.e("AudioService", "Media server started.");
            AudioSystem.setParameters("restarting=true");
            HashMap hashmap1 = mConnectedDevices;
            hashmap1;
            JVM INSTR monitorenter ;
            java.util.Map.Entry entry;
            for(Iterator iterator = mConnectedDevices.entrySet().iterator(); iterator.hasNext(); AudioSystem.setDeviceConnectionState(((Integer)entry.getKey()).intValue(), 1, (String)entry.getValue()))
                entry = (java.util.Map.Entry)iterator.next();

            break MISSING_BLOCK_LABEL_379;
            Exception exception1;
            exception1;
            throw exception1;
            hashmap1;
            JVM INSTR monitorexit ;
            AudioSystem.setPhoneState(mMode);
            AudioSystem.setForceUse(0, mForcedUseForComm);
            AudioSystem.setForceUse(2, mForcedUseForComm);
            for(int j = -1 + AudioSystem.getNumStreamTypes(); j >= 0; j--) {
                VolumeStreamState volumestreamstate = mStreamStates[j];
                int l = (5 + volumestreamstate.mIndexMax) / 10;
                AudioSystem.initStreamVolume(j, 0, l);
                volumestreamstate.applyAllVolumes();
            }

            setRingerModeInt(getRingerMode(), false);
            restoreMasterVolume();
            if(SystemProperties.getBoolean("ro.audio.monitorOrientation", false))
                setOrientationForAudioSystem();
            Object obj = mBluetoothA2dpEnabledLock;
            obj;
            JVM INSTR monitorenter ;
            int k;
            if(!mBluetoothA2dpEnabled)
                break MISSING_BLOCK_LABEL_558;
            k = 0;
_L24:
            AudioSystem.setForceUse(1, k);
            AudioSystem.setParameters("restarting=false");
            continue; /* Loop/switch isn't completed */
            k = 10;
              goto _L24
            Exception exception2;
            exception2;
            obj;
            JVM INSTR monitorexit ;
            throw exception2;
_L10:
            loadSoundEffects();
            continue; /* Loop/switch isn't completed */
_L8:
            playSoundEffect(message.arg1, message.arg2);
            continue; /* Loop/switch isn't completed */
_L9:
            HashMap hashmap = mConnectedDevices;
            hashmap;
            JVM INSTR monitorenter ;
            makeA2dpDeviceUnavailableNow((String)message.obj);
            continue; /* Loop/switch isn't completed */
_L11:
            setForceUse(message.arg1, message.arg2);
            continue; /* Loop/switch isn't completed */
_L12:
            onHandlePersistMediaButtonReceiver((ComponentName)message.obj);
            continue; /* Loop/switch isn't completed */
_L14:
            onRcDisplayClear();
            continue; /* Loop/switch isn't completed */
_L15:
            onRcDisplayUpdate((RemoteControlStackEntry)message.obj, message.arg1);
            continue; /* Loop/switch isn't completed */
_L13:
            resetBluetoothSco();
            continue; /* Loop/switch isn't completed */
_L22:
            onSetWiredDeviceConnectionState(message.arg1, message.arg2, (String)message.obj);
            mMediaEventWakeLock.release();
            continue; /* Loop/switch isn't completed */
_L23:
            onSetA2dpConnectionState((BluetoothDevice)message.obj, message.arg1);
            mMediaEventWakeLock.release();
            continue; /* Loop/switch isn't completed */
_L18:
            int i = mRoutesObservers.beginBroadcast();
            if(i > 0) {
                AudioRoutesInfo audioroutesinfo1;
                synchronized(mCurAudioRoutes) {
                    audioroutesinfo1 = new AudioRoutesInfo(mCurAudioRoutes);
                }
                while(i > 0)  {
                    i--;
                    IAudioRoutesObserver iaudioroutesobserver = (IAudioRoutesObserver)mRoutesObservers.getBroadcastItem(i);
                    try {
                        iaudioroutesobserver.dispatchAudioRoutesChanged(audioroutesinfo1);
                    }
                    catch(RemoteException remoteexception) { }
                }
            }
            break MISSING_BLOCK_LABEL_865;
            exception;
            audioroutesinfo;
            JVM INSTR monitorexit ;
            throw exception;
            mRoutesObservers.finishBroadcast();
            continue; /* Loop/switch isn't completed */
_L19:
            onReevaluateRemote();
            continue; /* Loop/switch isn't completed */
_L20:
            onNewPlaybackInfoForRcc(message.arg1, message.arg2, ((Integer)message.obj).intValue());
            continue; /* Loop/switch isn't completed */
_L21:
            onRegisterVolumeObserverForRcc(message.arg1, (IRemoteVolumeObserver)message.obj);
            if(true) goto _L1; else goto _L25
_L25:
        }

        final AudioService this$0;


        private AudioHandler() {
            this$0 = AudioService.this;
            Handler();
        }

    }

    private class AudioSystemThread extends Thread {

        public void run() {
            Looper.prepare();
            synchronized(AudioService.this) {
                mAudioHandler = new AudioHandler();
                notify();
            }
            Looper.loop();
            return;
            exception;
            audioservice;
            JVM INSTR monitorexit ;
            throw exception;
        }

        final AudioService this$0;

        AudioSystemThread() {
            this$0 = AudioService.this;
            Thread("AudioService");
        }
    }

    public class VolumeStreamState {
        private class VolumeDeathHandler
            implements android.os.IBinder.DeathRecipient {

            public void binderDied() {
                Log.w("AudioService", (new StringBuilder()).append("Volume service client died for stream: ").append(mStreamType).toString());
                if(mMuteCount != 0) {
                    mMuteCount = 1;
                    mute(false);
                }
            }

            public void mute(boolean flag) {
                if(!flag) goto _L2; else goto _L1
_L1:
                if(mMuteCount != 0) goto _L4; else goto _L3
_L3:
                if(mICallback != null)
                    mICallback.linkToDeath(this, 0);
                mDeathHandlers.add(this);
                if(muteCount() != 0) goto _L6; else goto _L5
_L5:
                int j;
                for(Iterator iterator1 = mIndex.entrySet().iterator(); iterator1.hasNext(); setIndex(0, j, false))
                    j = ((Integer)((java.util.Map.Entry)iterator1.next()).getKey()).intValue();

                  goto _L7
                RemoteException remoteexception;
                remoteexception;
                binderDied();
_L9:
                return;
_L7:
                AudioService.sendMsg(mAudioHandler, 14, 2, 0, 0, VolumeStreamState.this, 0);
_L6:
                mMuteCount = 1 + mMuteCount;
                continue; /* Loop/switch isn't completed */
_L4:
                Log.w("AudioService", (new StringBuilder()).append("stream: ").append(mStreamType).append(" was already muted by this client").toString());
                if(true) goto _L6; else goto _L2
_L2:
                if(mMuteCount == 0) {
                    Log.e("AudioService", (new StringBuilder()).append("unexpected unmute for stream: ").append(mStreamType).toString());
                } else {
                    mMuteCount = -1 + mMuteCount;
                    if(mMuteCount == 0) {
                        mDeathHandlers.remove(this);
                        if(mICallback != null)
                            mICallback.unlinkToDeath(this, 0);
                        if(muteCount() == 0 && (!isStreamAffectedByRingerMode(mStreamType) || mRingerMode == 2)) {
                            int i;
                            for(Iterator iterator = mIndex.entrySet().iterator(); iterator.hasNext(); setIndex(getIndex(i, true), i, false))
                                i = ((Integer)((java.util.Map.Entry)iterator.next()).getKey()).intValue();

                            AudioService.sendMsg(mAudioHandler, 14, 2, 0, 0, VolumeStreamState.this, 0);
                        }
                    }
                }
                if(true) goto _L9; else goto _L8
_L8:
            }

            private IBinder mICallback;
            private int mMuteCount;
            final VolumeStreamState this$1;



/*
            static int access$2002(VolumeDeathHandler volumedeathhandler, int i) {
                volumedeathhandler.mMuteCount = i;
                return i;
            }

*/


            VolumeDeathHandler(IBinder ibinder) {
                this$1 = VolumeStreamState.this;
                Object();
                mICallback = ibinder;
            }
        }


        private void dump(PrintWriter printwriter) {
            printwriter.print("   Current: ");
            java.util.Map.Entry entry1;
            for(Iterator iterator = mIndex.entrySet().iterator(); iterator.hasNext(); printwriter.print((new StringBuilder()).append(Integer.toHexString(((Integer)entry1.getKey()).intValue())).append(": ").append((5 + ((Integer)entry1.getValue()).intValue()) / 10).append(", ").toString()))
                entry1 = (java.util.Map.Entry)iterator.next();

            printwriter.print("\n   Last audible: ");
            java.util.Map.Entry entry;
            for(Iterator iterator1 = mLastAudibleIndex.entrySet().iterator(); iterator1.hasNext(); printwriter.print((new StringBuilder()).append(Integer.toHexString(((Integer)entry.getKey()).intValue())).append(": ").append((5 + ((Integer)entry.getValue()).intValue()) / 10).append(", ").toString()))
                entry = (java.util.Map.Entry)iterator1.next();

        }

        private VolumeDeathHandler getDeathHandler(IBinder ibinder, boolean flag) {
            int i;
            int j;
            i = mDeathHandlers.size();
            j = 0;
_L3:
            VolumeDeathHandler volumedeathhandler2;
            if(j >= i)
                break MISSING_BLOCK_LABEL_53;
            volumedeathhandler2 = (VolumeDeathHandler)mDeathHandlers.get(j);
            if(ibinder != volumedeathhandler2.mICallback) goto _L2; else goto _L1
_L1:
            VolumeDeathHandler volumedeathhandler1 = volumedeathhandler2;
_L4:
            return volumedeathhandler1;
_L2:
            j++;
              goto _L3
            VolumeDeathHandler volumedeathhandler;
            if(flag) {
                volumedeathhandler = new VolumeDeathHandler(ibinder);
            } else {
                Log.w("AudioService", "stream was not muted by this client");
                volumedeathhandler = null;
            }
            volumedeathhandler1 = volumedeathhandler;
              goto _L4
        }

        private int getValidIndex(int i) {
            if(i >= 0) goto _L2; else goto _L1
_L1:
            i = 0;
_L4:
            return i;
_L2:
            if(i > mIndexMax)
                i = mIndexMax;
            if(true) goto _L4; else goto _L3
_L3:
        }

        /**
         * @deprecated Method muteCount is deprecated
         */

        private int muteCount() {
            this;
            JVM INSTR monitorenter ;
            int i = 0;
            int j;
            int k;
            j = mDeathHandlers.size();
            k = 0;
_L1:
            int l;
            if(k >= j)
                break MISSING_BLOCK_LABEL_49;
            l = ((VolumeDeathHandler)mDeathHandlers.get(k)).mMuteCount;
            i += l;
            k++;
              goto _L1
            this;
            JVM INSTR monitorexit ;
            return i;
            Exception exception;
            exception;
            throw exception;
        }

        public boolean adjustIndex(int i, int j) {
            return setIndex(i + getIndex(j, false), j, true);
        }

        /**
         * @deprecated Method adjustLastAudibleIndex is deprecated
         */

        public void adjustLastAudibleIndex(int i, int j) {
            this;
            JVM INSTR monitorenter ;
            setLastAudibleIndex(i + getIndex(j, true), j);
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        /**
         * @deprecated Method applyAllVolumes is deprecated
         */

        public void applyAllVolumes() {
            this;
            JVM INSTR monitorenter ;
            AudioSystem.setStreamVolumeIndex(mStreamType, (5 + getIndex(32768, false)) / 10, 32768);
            Iterator iterator = mIndex.entrySet().iterator();
            do {
                if(!iterator.hasNext())
                    break;
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                int i = ((Integer)entry.getKey()).intValue();
                if(i != 32768)
                    AudioSystem.setStreamVolumeIndex(mStreamType, (5 + ((Integer)entry.getValue()).intValue()) / 10, i);
            } while(true);
            break MISSING_BLOCK_LABEL_115;
            Exception exception;
            exception;
            throw exception;
            this;
            JVM INSTR monitorexit ;
        }

        public void applyDeviceVolume(int i) {
            AudioSystem.setStreamVolumeIndex(mStreamType, (5 + getIndex(i, false)) / 10, i);
        }

        public ConcurrentHashMap getAllIndexes(boolean flag) {
            ConcurrentHashMap concurrenthashmap;
            if(flag)
                concurrenthashmap = mLastAudibleIndex;
            else
                concurrenthashmap = mIndex;
            return concurrenthashmap;
        }

        /**
         * @deprecated Method getIndex is deprecated
         */

        public int getIndex(int i, boolean flag) {
            this;
            JVM INSTR monitorenter ;
            if(!flag)
                break MISSING_BLOCK_LABEL_58;
            ConcurrentHashMap concurrenthashmap = mLastAudibleIndex;
_L1:
            int j;
            Integer integer = (Integer)concurrenthashmap.get(Integer.valueOf(i));
            if(integer == null)
                integer = (Integer)concurrenthashmap.get(Integer.valueOf(32768));
            j = integer.intValue();
            this;
            JVM INSTR monitorexit ;
            return j;
            concurrenthashmap = mIndex;
              goto _L1
            Exception exception;
            exception;
            throw exception;
        }

        public int getMaxIndex() {
            return mIndexMax;
        }

        public String getSettingNameForDevice(boolean flag, int i) {
            String s;
            String s1;
            if(flag)
                s = mLastAudibleVolumeIndexSettingName;
            else
                s = mVolumeIndexSettingName;
            s1 = AudioSystem.getDeviceName(i);
            if(!s1.isEmpty())
                s = (new StringBuilder()).append(s).append("_").append(s1).toString();
            return s;
        }

        public int getStreamType() {
            return mStreamType;
        }

        /**
         * @deprecated Method mute is deprecated
         */

        public void mute(IBinder ibinder, boolean flag) {
            this;
            JVM INSTR monitorenter ;
            VolumeDeathHandler volumedeathhandler = getDeathHandler(ibinder, flag);
            if(volumedeathhandler != null) goto _L2; else goto _L1
_L1:
            Log.e("AudioService", (new StringBuilder()).append("Could not get client death handler for stream: ").append(mStreamType).toString());
_L4:
            this;
            JVM INSTR monitorexit ;
            return;
_L2:
            volumedeathhandler.mute(flag);
            if(true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            throw exception;
        }

        /**
         * @deprecated Method readSettings is deprecated
         */

        public void readSettings() {
            this;
            JVM INSTR monitorenter ;
            int i;
            int j;
            i = 65535;
            j = 0;
_L2:
            int k;
            if(i == 0)
                break MISSING_BLOCK_LABEL_348;
            k = 1 << j;
            if((k & i) != 0)
                break; /* Loop/switch isn't completed */
_L6:
            j++;
            if(true) goto _L2; else goto _L1
_L1:
            i &= ~k;
            String s = getSettingNameForDevice(false, k);
            if(k != 32768) goto _L4; else goto _L3
_L3:
            int l = AudioManager.DEFAULT_STREAM_VOLUME[mStreamType];
_L7:
            int i1 = android.provider.Settings.System.getInt(mContentResolver, s, l);
            if(i1 == -1) goto _L6; else goto _L5
_L5:
            String s1;
            int j1;
            s1 = getSettingNameForDevice(true, k);
            if(i1 <= 0)
                break MISSING_BLOCK_LABEL_334;
            j1 = i1;
_L8:
            int k1 = android.provider.Settings.System.getInt(mContentResolver, s1, j1);
            if(k1 == 0 && (mVoiceCapable && mStreamVolumeAlias[mStreamType] == 2 || mStreamVolumeAlias[mStreamType] == 1)) {
                k1 = AudioManager.DEFAULT_STREAM_VOLUME[mStreamType];
                AudioService.sendMsg(mAudioHandler, 1, 2, 2, k, this, 500);
            }
            mLastAudibleIndex.put(Integer.valueOf(k), Integer.valueOf(getValidIndex(k1 * 10)));
            if(i1 == 0 && mRingerMode == 2 && (mVoiceCapable && mStreamVolumeAlias[mStreamType] == 2 || mStreamVolumeAlias[mStreamType] == 1)) {
                i1 = k1;
                AudioService.sendMsg(mAudioHandler, 1, 2, 1, k, this, 500);
            }
            mIndex.put(Integer.valueOf(k), Integer.valueOf(getValidIndex(i1 * 10)));
              goto _L6
            Exception exception;
            exception;
            throw exception;
_L4:
            l = -1;
              goto _L7
            j1 = AudioManager.DEFAULT_STREAM_VOLUME[mStreamType];
              goto _L8
              goto _L6
        }

        /**
         * @deprecated Method setAllIndexes is deprecated
         */

        public void setAllIndexes(VolumeStreamState volumestreamstate, boolean flag) {
            this;
            JVM INSTR monitorenter ;
            int i;
            int j;
            for(Iterator iterator = volumestreamstate.getAllIndexes(flag).entrySet().iterator(); iterator.hasNext(); setIndex(rescaleIndex(j, volumestreamstate.getStreamType(), mStreamType), i, flag)) {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                i = ((Integer)entry.getKey()).intValue();
                j = ((Integer)entry.getValue()).intValue();
            }

            break MISSING_BLOCK_LABEL_102;
            Exception exception;
            exception;
            throw exception;
            this;
            JVM INSTR monitorexit ;
        }

        /**
         * @deprecated Method setIndex is deprecated
         */

        public boolean setIndex(int i, int j, boolean flag) {
            boolean flag1 = true;
            this;
            JVM INSTR monitorenter ;
            int l;
            boolean flag2;
            int k = getIndex(j, false);
            l = getValidIndex(i);
            mIndex.put(Integer.valueOf(j), Integer.valueOf(getValidIndex(l)));
            if(k == l)
                break MISSING_BLOCK_LABEL_205;
            if(flag)
                mLastAudibleIndex.put(Integer.valueOf(j), Integer.valueOf(l));
            if(j != getDeviceForStream(mStreamType))
                break MISSING_BLOCK_LABEL_199;
            flag2 = flag1;
_L2:
            int i1 = -1 + AudioSystem.getNumStreamTypes();
_L1:
            if(i1 < 0)
                break MISSING_BLOCK_LABEL_208;
            if(i1 != mStreamType && mStreamVolumeAlias[i1] == mStreamType) {
                int j1 = rescaleIndex(l, mStreamType, i1);
                mStreamStates[i1].setIndex(j1, j, flag);
                if(flag2)
                    mStreamStates[i1].setIndex(j1, getDeviceForStream(i1), flag);
            }
            i1--;
              goto _L1
            flag2 = false;
              goto _L2
            flag1 = false;
            return flag1;
            Exception exception;
            exception;
            throw exception;
        }

        /**
         * @deprecated Method setLastAudibleIndex is deprecated
         */

        public void setLastAudibleIndex(int i, int j) {
            this;
            JVM INSTR monitorenter ;
            boolean flag;
            if(j != getDeviceForStream(mStreamType))
                break MISSING_BLOCK_LABEL_157;
            flag = true;
_L5:
            int k = -1 + AudioSystem.getNumStreamTypes();
_L4:
            if(k < 0) goto _L2; else goto _L1
_L1:
            if(k != mStreamType && mStreamVolumeAlias[k] == mStreamType) {
                int l = rescaleIndex(i, mStreamType, k);
                mStreamStates[k].setLastAudibleIndex(l, j);
                if(flag)
                    mStreamStates[k].setLastAudibleIndex(l, getDeviceForStream(k));
            }
              goto _L3
_L2:
            mLastAudibleIndex.put(Integer.valueOf(j), Integer.valueOf(getValidIndex(i)));
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
_L3:
            k--;
              goto _L4
            flag = false;
              goto _L5
        }

        private ArrayList mDeathHandlers;
        private final ConcurrentHashMap mIndex;
        private int mIndexMax;
        private final ConcurrentHashMap mLastAudibleIndex;
        private String mLastAudibleVolumeIndexSettingName;
        private final int mStreamType;
        private String mVolumeIndexSettingName;
        final AudioService this$0;








        private VolumeStreamState(String s, int i) {
            this$0 = AudioService.this;
            Object();
            mIndex = new ConcurrentHashMap(8, 0.75F, 4);
            mLastAudibleIndex = new ConcurrentHashMap(8, 0.75F, 4);
            mVolumeIndexSettingName = s;
            mLastAudibleVolumeIndexSettingName = (new StringBuilder()).append(s).append("_last_audible").toString();
            mStreamType = i;
            mIndexMax = MAX_STREAM_VOLUME[i];
            AudioSystem.initStreamVolume(i, 0, mIndexMax);
            mIndexMax = 10 * mIndexMax;
            readSettings();
            mDeathHandlers = new ArrayList();
        }

    }

    private class ScoClient
        implements android.os.IBinder.DeathRecipient {

        private void requestScoState(int i) {
            checkScoAudioState();
            if(totalCount() != 0) goto _L2; else goto _L1
_L1:
            if(i != 12) goto _L4; else goto _L3
_L3:
            broadcastScoConnectionState(2);
            ArrayList arraylist = mSetModeDeathHandlers;
            arraylist;
            JVM INSTR monitorenter ;
            if(!mSetModeDeathHandlers.isEmpty() && ((SetModeDeathHandler)mSetModeDeathHandlers.get(0)).getPid() != mCreatorPid || mScoAudioState != 0 && mScoAudioState != 5) goto _L6; else goto _L5
_L5:
            if(mScoAudioState != 0) goto _L8; else goto _L7
_L7:
            if(mBluetoothHeadset == null || mBluetoothHeadsetDevice == null) goto _L10; else goto _L9
_L9:
            if(mBluetoothHeadset.startScoUsingVirtualVoiceCall(mBluetoothHeadsetDevice))
                mScoAudioState = 3;
            else
                broadcastScoConnectionState(0);
_L11:
            arraylist;
            JVM INSTR monitorexit ;
            break; /* Loop/switch isn't completed */
            Exception exception;
            exception;
            throw exception;
_L10:
            if(getBluetoothHeadset())
                mScoAudioState = 1;
            continue; /* Loop/switch isn't completed */
_L8:
            mScoAudioState = 3;
            broadcastScoConnectionState(1);
            continue; /* Loop/switch isn't completed */
_L6:
            broadcastScoConnectionState(0);
            if(true) goto _L11; else goto _L2
_L4:
            if(i == 10 && (mScoAudioState == 3 || mScoAudioState == 1))
                if(mScoAudioState == 3) {
                    if(mBluetoothHeadset != null && mBluetoothHeadsetDevice != null) {
                        if(!mBluetoothHeadset.stopScoUsingVirtualVoiceCall(mBluetoothHeadsetDevice)) {
                            mScoAudioState = 0;
                            broadcastScoConnectionState(0);
                        }
                    } else
                    if(getBluetoothHeadset())
                        mScoAudioState = 5;
                } else {
                    mScoAudioState = 0;
                    broadcastScoConnectionState(0);
                }
_L2:
        }

        public void binderDied() {
            ArrayList arraylist = mScoClients;
            arraylist;
            JVM INSTR monitorenter ;
            Log.w("AudioService", "SCO client died");
            if(mScoClients.indexOf(this) < 0) {
                Log.w("AudioService", "unregistered SCO client died");
            } else {
                clearCount(true);
                mScoClients.remove(this);
            }
            return;
        }

        public void clearCount(boolean flag) {
            ArrayList arraylist = mScoClients;
            arraylist;
            JVM INSTR monitorenter ;
            int i = mStartcount;
            Exception exception;
            if(i != 0)
                try {
                    mCb.unlinkToDeath(this, 0);
                }
                catch(NoSuchElementException nosuchelementexception) {
                    Log.w("AudioService", (new StringBuilder()).append("clearCount() mStartcount: ").append(mStartcount).append(" != 0 but not registered to binder").toString());
                }
                finally {
                    arraylist;
                }
            mStartcount = 0;
            if(flag)
                requestScoState(10);
            arraylist;
            JVM INSTR monitorexit ;
            return;
            throw exception;
        }

        public void decCount() {
            ArrayList arraylist = mScoClients;
            arraylist;
            JVM INSTR monitorenter ;
            if(mStartcount != 0) goto _L2; else goto _L1
_L1:
            Log.w("AudioService", "ScoClient.decCount() already 0");
_L3:
            return;
_L2:
            int i;
            mStartcount = -1 + mStartcount;
            i = mStartcount;
            if(i != 0)
                break MISSING_BLOCK_LABEL_60;
            mCb.unlinkToDeath(this, 0);
_L4:
            requestScoState(10);
              goto _L3
            Exception exception;
            exception;
            throw exception;
            NoSuchElementException nosuchelementexception;
            nosuchelementexception;
            Log.w("AudioService", "decCount() going to 0 but not registered to binder");
              goto _L4
        }

        public IBinder getBinder() {
            return mCb;
        }

        public int getCount() {
            return mStartcount;
        }

        public int getPid() {
            return mCreatorPid;
        }

        public void incCount() {
            ArrayList arraylist = mScoClients;
            arraylist;
            JVM INSTR monitorenter ;
            int i;
            requestScoState(12);
            i = mStartcount;
            Exception exception;
            if(i == 0)
                try {
                    mCb.linkToDeath(this, 0);
                }
                catch(RemoteException remoteexception) {
                    Log.w("AudioService", (new StringBuilder()).append("ScoClient  incCount() could not link to ").append(mCb).append(" binder death").toString());
                }
                finally {
                    arraylist;
                }
            mStartcount = 1 + mStartcount;
            arraylist;
            JVM INSTR monitorexit ;
            return;
            throw exception;
        }

        public int totalCount() {
            ArrayList arraylist = mScoClients;
            arraylist;
            JVM INSTR monitorenter ;
            int i = 0;
            int j = mScoClients.size();
            for(int k = 0; k < j; k++)
                i += ((ScoClient)mScoClients.get(k)).getCount();

            return i;
        }

        private IBinder mCb;
        private int mCreatorPid;
        private int mStartcount;
        final AudioService this$0;

        ScoClient(IBinder ibinder) {
            this$0 = AudioService.this;
            Object();
            mCb = ibinder;
            mCreatorPid = Binder.getCallingPid();
            mStartcount = 0;
        }
    }

    private final class SoundPoolCallback
        implements SoundPool.OnLoadCompleteListener {

        public void onLoadComplete(SoundPool soundpool, int i, int j) {
            Object obj = mSoundEffectsLock;
            obj;
            JVM INSTR monitorenter ;
            if(j != 0)
                mStatus = j;
            if(i == mLastSample)
                mSoundEffectsLock.notify();
            return;
        }

        public void setLastSample(int i) {
            mLastSample = i;
        }

        public int status() {
            return mStatus;
        }

        int mLastSample;
        int mStatus;
        final AudioService this$0;

        private SoundPoolCallback() {
            this$0 = AudioService.this;
            Object();
        }

    }

    class SoundPoolListenerThread extends Thread {

        public void run() {
            Looper.prepare();
            mSoundPoolLooper = Looper.myLooper();
            synchronized(mSoundEffectsLock) {
                if(mSoundPool != null) {
                    mSoundPoolCallBack = new SoundPoolCallback();
                    mSoundPool.setOnLoadCompleteListener(mSoundPoolCallBack);
                }
                mSoundEffectsLock.notify();
            }
            Looper.loop();
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        final AudioService this$0;

        public SoundPoolListenerThread() {
            this$0 = AudioService.this;
            Thread("SoundPoolListenerThread");
        }
    }

    private class SetModeDeathHandler
        implements android.os.IBinder.DeathRecipient {

        public void binderDied() {
            int i = 0;
            ArrayList arraylist = mSetModeDeathHandlers;
            arraylist;
            JVM INSTR monitorenter ;
            Log.w("AudioService", "setMode() client died");
            if(mSetModeDeathHandlers.indexOf(this) >= 0)
                break MISSING_BLOCK_LABEL_57;
            Log.w("AudioService", "unregistered setMode() client died");
_L2:
            if(i != 0)
                disconnectBluetoothSco(i);
            return;
            i = setModeInt(0, mCb, mPid);
            if(true) goto _L2; else goto _L1
_L1:
            Exception exception;
            exception;
            throw exception;
        }

        public IBinder getBinder() {
            return mCb;
        }

        public int getMode() {
            return mMode;
        }

        public int getPid() {
            return mPid;
        }

        public void setMode(int i) {
            mMode = i;
        }

        private IBinder mCb;
        private int mMode;
        private int mPid;
        final AudioService this$0;

        SetModeDeathHandler(IBinder ibinder, int i) {
            this$0 = AudioService.this;
            Object();
            mMode = 0;
            mCb = ibinder;
            mPid = i;
        }
    }

    private class ForceControlStreamClient
        implements android.os.IBinder.DeathRecipient {

        public void binderDied() {
            Object obj = mForceControlStreamLock;
            obj;
            JVM INSTR monitorenter ;
            Log.w("AudioService", "SCO client died");
            if(mForceControlStreamClient != this) {
                Log.w("AudioService", "unregistered control stream client died");
            } else {
                mForceControlStreamClient = null;
                mVolumeControlStream = -1;
            }
            return;
        }

        public void release() {
            if(mCb != null) {
                mCb.unlinkToDeath(this, 0);
                mCb = null;
            }
        }

        private IBinder mCb;
        final AudioService this$0;

        ForceControlStreamClient(IBinder ibinder) {
            this$0 = AudioService.this;
            Object();
            if(ibinder != null)
                try {
                    ibinder.linkToDeath(this, 0);
                }
                catch(RemoteException remoteexception) {
                    Log.w("AudioService", (new StringBuilder()).append("ForceControlStreamClient() could not link to ").append(ibinder).append(" binder death").toString());
                    ibinder = null;
                }
            mCb = ibinder;
        }
    }


    public AudioService(Context context) {
        int ai[][] = new int[9][];
        int ai1[] = new int[2];
        ai1[0] = 0;
        ai1[1] = -1;
        ai[0] = ai1;
        int ai2[] = new int[2];
        ai2[0] = 0;
        ai2[1] = -1;
        ai[1] = ai2;
        int ai3[] = new int[2];
        ai3[0] = 0;
        ai3[1] = -1;
        ai[2] = ai3;
        int ai4[] = new int[2];
        ai4[0] = 0;
        ai4[1] = -1;
        ai[3] = ai4;
        int ai5[] = new int[2];
        ai5[0] = 0;
        ai5[1] = -1;
        ai[4] = ai5;
        int ai6[] = new int[2];
        ai6[0] = 1;
        ai6[1] = -1;
        ai[5] = ai6;
        int ai7[] = new int[2];
        ai7[0] = 2;
        ai7[1] = -1;
        ai[6] = ai7;
        int ai8[] = new int[2];
        ai8[0] = 3;
        ai8[1] = -1;
        ai[7] = ai8;
        int ai9[] = new int[2];
        ai9[0] = 4;
        ai9[1] = -1;
        ai[8] = ai9;
        SOUND_EFFECT_FILES_MAP = ai;
        int ai10[] = new int[10];
        ai10[0] = 5;
        ai10[1] = 7;
        ai10[2] = 7;
        ai10[3] = 15;
        ai10[4] = 7;
        ai10[5] = 7;
        ai10[6] = 15;
        ai10[7] = 7;
        ai10[8] = 15;
        ai10[9] = 15;
        MAX_STREAM_VOLUME = ai10;
        int ai11[] = new int[10];
        ai11[0] = 0;
        ai11[1] = 2;
        ai11[2] = 2;
        ai11[3] = 3;
        ai11[4] = 4;
        ai11[5] = 2;
        ai11[6] = 6;
        ai11[7] = 2;
        ai11[8] = 2;
        ai11[9] = 3;
        STREAM_VOLUME_ALIAS = ai11;
        int ai12[] = new int[10];
        ai12[0] = 0;
        ai12[1] = 3;
        ai12[2] = 2;
        ai12[3] = 3;
        ai12[4] = 4;
        ai12[5] = 2;
        ai12[6] = 6;
        ai12[7] = 3;
        ai12[8] = 3;
        ai12[9] = 3;
        STREAM_VOLUME_ALIAS_NON_VOICE = ai12;
        String as[] = new String[10];
        as[0] = "STREAM_VOICE_CALL";
        as[1] = "STREAM_SYSTEM";
        as[2] = "STREAM_RING";
        as[3] = "STREAM_MUSIC";
        as[4] = "STREAM_ALARM";
        as[5] = "STREAM_NOTIFICATION";
        as[6] = "STREAM_BLUETOOTH_SCO";
        as[7] = "STREAM_SYSTEM_ENFORCED";
        as[8] = "STREAM_DTMF";
        as[9] = "STREAM_TTS";
        STREAM_NAMES = as;
        mIsRinging = false;
        mSoundPoolLooper = null;
        mPrevVolDirection = 0;
        mVolumeControlStream = -1;
        mForceControlStreamClient = null;
        mDeviceOrientation = 0;
        mBluetoothProfileServiceListener = new android.bluetooth.BluetoothProfile.ServiceListener() {

            public void onServiceConnected(int i, BluetoothProfile bluetoothprofile) {
                i;
                JVM INSTR tableswitch 1 2: default 24
            //                           1 152
            //                           2 25;
                   goto _L1 _L2 _L3
_L1:
                return;
_L3:
                BluetoothA2dp bluetootha2dp;
                List list1;
                bluetootha2dp = (BluetoothA2dp)bluetoothprofile;
                list1 = bluetootha2dp.getConnectedDevices();
                if(list1.size() <= 0) goto _L1; else goto _L4
_L4:
                BluetoothDevice bluetoothdevice = (BluetoothDevice)list1.get(0);
                HashMap hashmap = mConnectedDevices;
                hashmap;
                JVM INSTR monitorenter ;
                int j = bluetootha2dp.getConnectionState(bluetoothdevice);
                AudioService audioservice = AudioService.this;
                int k;
                int l;
                if(j == 2)
                    k = 1;
                else
                    k = 0;
                l = audioservice.checkSendBecomingNoisyIntent(128, k);
                queueMsgUnderWakeLock(mAudioHandler, 21, j, 0, bluetoothdevice, l);
                  goto _L1
_L2:
                ArrayList arraylist = mScoClients;
                arraylist;
                JVM INSTR monitorenter ;
                List list;
                mAudioHandler.removeMessages(11);
                mBluetoothHeadset = (BluetoothHeadset)bluetoothprofile;
                list = mBluetoothHeadset.getConnectedDevices();
                if(list.size() <= 0) goto _L6; else goto _L5
_L5:
                mBluetoothHeadsetDevice = (BluetoothDevice)list.get(0);
_L14:
                checkScoAudioState();
                if(mScoAudioState != 1 && mScoAudioState != 5 && mScoAudioState != 4) goto _L8; else goto _L7
_L7:
                boolean flag1 = false;
                if(mBluetoothHeadsetDevice == null) goto _L10; else goto _L9
_L9:
                mScoAudioState;
                JVM INSTR tableswitch 1 5: default 320
            //                           1 366
            //                           2 320
            //                           3 320
            //                           4 419
            //                           5 397;
                   goto _L10 _L11 _L10 _L10 _L12 _L13
_L10:
                if(!flag1)
                    AudioService.sendMsg(mAudioHandler, 11, 0, 0, 0, null, 0);
_L8:
                arraylist;
                JVM INSTR monitorexit ;
                  goto _L1
                Exception exception;
                exception;
                throw exception;
_L6:
                mBluetoothHeadsetDevice = null;
                  goto _L14
_L11:
                mScoAudioState = 3;
                flag1 = mBluetoothHeadset.startScoUsingVirtualVoiceCall(mBluetoothHeadsetDevice);
                  goto _L10
_L13:
                flag1 = mBluetoothHeadset.stopScoUsingVirtualVoiceCall(mBluetoothHeadsetDevice);
                  goto _L10
_L12:
                boolean flag2 = mBluetoothHeadset.stopVoiceRecognition(mBluetoothHeadsetDevice);
                flag1 = flag2;
                  goto _L10
            }

            public void onServiceDisconnected(int i) {
                i;
                JVM INSTR tableswitch 1 2: default 24
            //                           1 96
            //                           2 25;
                   goto _L1 _L2 _L3
_L1:
                return;
_L3:
                HashMap hashmap = mConnectedDevices;
                hashmap;
                JVM INSTR monitorenter ;
                if(mConnectedDevices.containsKey(Integer.valueOf(128)))
                    makeA2dpDeviceUnavailableNow((String)mConnectedDevices.get(Integer.valueOf(128)));
                continue; /* Loop/switch isn't completed */
_L2:
                ArrayList arraylist = mScoClients;
                arraylist;
                JVM INSTR monitorenter ;
                mBluetoothHeadset = null;
                if(true) goto _L1; else goto _L4
_L4:
            }

            final AudioService this$0;

             {
                this$0 = AudioService.this;
                Object();
            }
        };
        mBecomingNoisyIntentDevices = 908;
        mPhoneStateListener = new PhoneStateListener() {

            public void onCallStateChanged(int i, String s) {
                if(i != 1)
                    break MISSING_BLOCK_LABEL_36;
                Object obj1 = AudioService.mRingingLock;
                obj1;
                JVM INSTR monitorenter ;
                mIsRinging = true;
                break MISSING_BLOCK_LABEL_72;
                if(i != 2 && i != 0)
                    break MISSING_BLOCK_LABEL_72;
                Object obj = AudioService.mRingingLock;
                obj;
                JVM INSTR monitorenter ;
                mIsRinging = false;
            }

            final AudioService this$0;

             {
                this$0 = AudioService.this;
                PhoneStateListener();
            }
        };
        mKeyEventDone = new BroadcastReceiver() {

            public void onReceive(Context context1, Intent intent) {
                if(intent != null) goto _L2; else goto _L1
_L1:
                return;
_L2:
                Bundle bundle = intent.getExtras();
                if(bundle != null && bundle.containsKey("android.media.AudioService.WAKELOCK_ACQUIRED"))
                    mMediaEventWakeLock.release();
                if(true) goto _L1; else goto _L3
_L3:
            }

            final AudioService this$0;

             {
                this$0 = AudioService.this;
                BroadcastReceiver();
            }
        };
        mCurrentRcClient = null;
        mCurrentRcClientGen = 0;
        mMediaReceiverForCalls = null;
        mArtworkExpectedWidth = -1;
        mArtworkExpectedHeight = -1;
        mContext = context;
        mContentResolver = context.getContentResolver();
        mVoiceCapable = mContext.getResources().getBoolean(0x1110028);
        mMediaEventWakeLock = ((PowerManager)context.getSystemService("power")).newWakeLock(1, "handleMediaEvent");
        Vibrator vibrator = (Vibrator)context.getSystemService("vibrator");
        boolean flag;
        IntentFilter intentfilter;
        IntentFilter intentfilter1;
        if(vibrator == null)
            flag = false;
        else
            flag = vibrator.hasVibrator();
        mHasVibrator = flag;
        MAX_STREAM_VOLUME[0] = SystemProperties.getInt("ro.config.vc_call_vol_steps", MAX_STREAM_VOLUME[0]);
        SOUND_EFFECT_VOLUME_DB = context.getResources().getInteger(0x10e0004);
        mVolumePanel = new VolumePanel(context, this);
        mMode = 0;
        mForcedUseForComm = 0;
        createAudioSystemThread();
        readPersistedSettings();
        mSettingsObserver = new SettingsObserver();
        updateStreamVolumeAlias(false);
        createStreamStates();
        mMediaServerOk = true;
        mRingerModeMutedStreams = 0;
        setRingerModeInt(getRingerMode(), false);
        AudioSystem.setErrorCallback(mAudioSystemCallback);
        intentfilter = new IntentFilter("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
        intentfilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        intentfilter.addAction("android.intent.action.DOCK_EVENT");
        intentfilter.addAction("android.intent.action.USB_AUDIO_ACCESSORY_PLUG");
        intentfilter.addAction("android.intent.action.USB_AUDIO_DEVICE_PLUG");
        intentfilter.addAction("android.intent.action.BOOT_COMPLETED");
        intentfilter.addAction("android.intent.action.SCREEN_ON");
        intentfilter.addAction("android.intent.action.SCREEN_OFF");
        if(SystemProperties.getBoolean("ro.audio.monitorOrientation", false)) {
            Log.v("AudioService", "monitoring device orientation");
            intentfilter.addAction("android.intent.action.CONFIGURATION_CHANGED");
            setOrientationForAudioSystem();
        }
        context.registerReceiver(mReceiver, intentfilter);
        intentfilter1 = new IntentFilter();
        intentfilter1.addAction("android.intent.action.PACKAGE_REMOVED");
        intentfilter1.addDataScheme("package");
        context.registerReceiver(mReceiver, intentfilter1);
        ((TelephonyManager)context.getSystemService("phone")).listen(mPhoneStateListener, 32);
        mUseMasterVolume = context.getResources().getBoolean(0x111000a);
        restoreMasterVolume();
        mMasterVolumeRamp = context.getResources().getIntArray(0x1070012);
        mMainRemote = new RemotePlaybackState(-1, MAX_STREAM_VOLUME[3], MAX_STREAM_VOLUME[3]);
        mHasRemotePlayback = false;
        mMainRemoteIsActive = false;
        postReevaluateRemote();
    }

    private int adjustDirection(int i, int j) {
        if((i & 1) != 0 && !mVolumePanel.isVisible())
            j = 0;
        return j;
    }

    private void adjustRemoteVolume(int i, int j, int k) {
        RemotePlaybackState remoteplaybackstate = mMainRemote;
        remoteplaybackstate;
        JVM INSTR monitorenter ;
        int l;
        boolean flag;
        if(!mMainRemoteIsActive)
            break MISSING_BLOCK_LABEL_85;
        l = mMainRemote.mRccId;
        if(mMainRemote.mVolumeHandling != 0)
            break MISSING_BLOCK_LABEL_71;
        flag = true;
_L2:
        if(!flag)
            sendVolumeUpdateToRemote(l, j);
        mVolumePanel.postRemoteVolumeChanged(i, k);
        break MISSING_BLOCK_LABEL_85;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        remoteplaybackstate;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void broadcastMasterMuteStatus(boolean flag) {
        Intent intent = new Intent("android.media.MASTER_MUTE_CHANGED_ACTION");
        intent.putExtra("android.media.EXTRA_MASTER_VOLUME_MUTED", flag);
        intent.addFlags(0x28000000);
        long l = Binder.clearCallingIdentity();
        mContext.sendStickyBroadcast(intent);
        Binder.restoreCallingIdentity(l);
    }

    private void broadcastRingerMode(int i) {
        Intent intent = new Intent("android.media.RINGER_MODE_CHANGED");
        intent.putExtra("android.media.EXTRA_RINGER_MODE", i);
        intent.addFlags(0x28000000);
        long l = Binder.clearCallingIdentity();
        mContext.sendStickyBroadcast(intent);
        Binder.restoreCallingIdentity(l);
    }

    private void broadcastScoConnectionState(int i) {
        if(i != mScoConnectionState) {
            Intent intent = new Intent("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
            intent.putExtra("android.media.extra.SCO_AUDIO_STATE", i);
            intent.putExtra("android.media.extra.SCO_AUDIO_PREVIOUS_STATE", mScoConnectionState);
            mContext.sendStickyBroadcast(intent);
            mScoConnectionState = i;
        }
    }

    private void broadcastVibrateSetting(int i) {
        if(ActivityManagerNative.isSystemReady()) {
            Intent intent = new Intent("android.media.VIBRATE_SETTING_CHANGED");
            intent.putExtra("android.media.EXTRA_VIBRATE_TYPE", i);
            intent.putExtra("android.media.EXTRA_VIBRATE_SETTING", getVibrateSetting(i));
            mContext.sendBroadcast(intent);
        }
    }

    private boolean canReassignAudioFocus() {
        boolean flag;
        if(!mFocusStack.isEmpty() && "AudioFocus_For_Phone_Ring_And_Calls".equals(((FocusStackEntry)mFocusStack.peek()).mClientId))
            flag = false;
        else
            flag = true;
        return flag;
    }

    private void cancelA2dpDeviceTimeout() {
        mAudioHandler.removeMessages(7);
    }

    private void checkAllAliasStreamVolumes() {
        int i = AudioSystem.getNumStreamTypes();
        for(int j = 0; j < i; j++) {
            if(j != mStreamVolumeAlias[j]) {
                mStreamStates[j].setAllIndexes(mStreamStates[mStreamVolumeAlias[j]], false);
                mStreamStates[j].setAllIndexes(mStreamStates[mStreamVolumeAlias[j]], true);
            }
            if(mStreamStates[j].muteCount() == 0)
                mStreamStates[j].applyAllVolumes();
        }

    }

    private boolean checkForRingerModeChange(int i, int j, int k) {
        boolean flag;
        int l;
        flag = true;
        l = getRingerMode();
        l;
        JVM INSTR tableswitch 0 2: default 36
    //                   0 182
    //                   1 128
    //                   2 77;
           goto _L1 _L2 _L3 _L4
_L1:
        Log.e("AudioService", (new StringBuilder()).append("checkForRingerModeChange() wrong ringer mode: ").append(l).toString());
_L9:
        setRingerMode(l);
        mPrevVolDirection = j;
        return flag;
_L4:
        if(j == -1)
            if(mHasVibrator) {
                if(k <= i && i < k * 2)
                    l = 1;
            } else
            if(i < k && mPrevVolDirection != -1)
                l = 0;
        continue; /* Loop/switch isn't completed */
_L3:
        if(!mHasVibrator) {
            Log.e("AudioService", "checkForRingerModeChange() current ringer mode is vibratebut no vibrator is present");
            continue; /* Loop/switch isn't completed */
        }
        if(j != -1) goto _L6; else goto _L5
_L5:
        if(mPrevVolDirection != -1)
            l = 0;
_L7:
        flag = false;
        continue; /* Loop/switch isn't completed */
_L6:
        if(j == 1)
            l = 2;
        if(true) goto _L7; else goto _L2
_L2:
        if(j == 1)
            if(mHasVibrator)
                l = 1;
            else
                l = 2;
        flag = false;
        if(true) goto _L9; else goto _L8
_L8:
    }

    private void checkScoAudioState() {
        if(mBluetoothHeadset != null && mBluetoothHeadsetDevice != null && mScoAudioState == 0 && mBluetoothHeadset.getAudioState(mBluetoothHeadsetDevice) != 10)
            mScoAudioState = 2;
    }

    private int checkSendBecomingNoisyIntent(int i, int j) {
        char c = '\0';
        if(j == 0 && (i & mBecomingNoisyIntentDevices) != 0) {
            int k = 0;
            Iterator iterator = mConnectedDevices.keySet().iterator();
            do {
                if(!iterator.hasNext())
                    break;
                int l = ((Integer)iterator.next()).intValue();
                if((l & mBecomingNoisyIntentDevices) != 0)
                    k |= l;
            } while(true);
            if(k == i) {
                c = '\u03E8';
                sendBecomingNoisyIntent();
            }
        }
        if(mAudioHandler.hasMessages(21) || mAudioHandler.hasMessages(20))
            c = '\u03E8';
        return c;
    }

    private void checkUpdateRemoteControlDisplay_syncAfRcs(int i) {
        if(mRCStack.isEmpty() || mFocusStack.isEmpty())
            clearRemoteControlDisplay_syncAfRcs();
        else
        if(((RemoteControlStackEntry)mRCStack.peek()).mCallingPackageName != null && ((FocusStackEntry)mFocusStack.peek()).mPackageName != null && ((RemoteControlStackEntry)mRCStack.peek()).mCallingPackageName.compareTo(((FocusStackEntry)mFocusStack.peek()).mPackageName) != 0)
            clearRemoteControlDisplay_syncAfRcs();
        else
        if(((RemoteControlStackEntry)mRCStack.peek()).mCallingUid != ((FocusStackEntry)mFocusStack.peek()).mCallingUid)
            clearRemoteControlDisplay_syncAfRcs();
        else
            updateRemoteControlDisplay_syncAfRcs(i);
    }

    private boolean checkUpdateRemoteStateIfActive(int i) {
        boolean flag = true;
        Stack stack = mRCStack;
        stack;
        JVM INSTR monitorenter ;
        Iterator iterator = mRCStack.iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        RemoteControlStackEntry remotecontrolstackentry = (RemoteControlStackEntry)iterator.next();
        if(remotecontrolstackentry.mPlaybackType != flag || !isPlaystateActive(remotecontrolstackentry.mPlaybackState) || remotecontrolstackentry.mPlaybackStream != i) goto _L4; else goto _L3
_L3:
        synchronized(mMainRemote) {
            mMainRemote.mRccId = remotecontrolstackentry.mRccId;
            mMainRemote.mVolume = remotecontrolstackentry.mPlaybackVolume;
            mMainRemote.mVolumeMax = remotecontrolstackentry.mPlaybackVolumeMax;
            mMainRemote.mVolumeHandling = remotecontrolstackentry.mPlaybackVolumeHandling;
            mMainRemoteIsActive = true;
        }
        stack;
        JVM INSTR monitorexit ;
_L6:
        return flag;
        exception1;
        remoteplaybackstate1;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        throw exception;
_L2:
        stack;
        JVM INSTR monitorexit ;
        RemotePlaybackState remoteplaybackstate = mMainRemote;
        remoteplaybackstate;
        JVM INSTR monitorenter ;
        mMainRemoteIsActive = false;
        flag = false;
        if(true) goto _L6; else goto _L5
_L5:
    }

    private void clearRemoteControlDisplay_syncAfRcs() {
        synchronized(mCurrentRcLock) {
            mCurrentRcClient = null;
        }
        mAudioHandler.sendMessage(mAudioHandler.obtainMessage(12));
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void createAudioSystemThread() {
        mAudioSystemThread = new AudioSystemThread();
        mAudioSystemThread.start();
        waitForAudioHandlerCreation();
    }

    private void createStreamStates() {
        int i = AudioSystem.getNumStreamTypes();
        VolumeStreamState avolumestreamstate[] = new VolumeStreamState[i];
        mStreamStates = avolumestreamstate;
        for(int j = 0; j < i; j++)
            avolumestreamstate[j] = new VolumeStreamState(android.provider.Settings.System.VOLUME_SETTINGS[mStreamVolumeAlias[j]], j);

        checkAllAliasStreamVolumes();
    }

    private void disconnectBluetoothSco(int i) {
        ArrayList arraylist = mScoClients;
        arraylist;
        JVM INSTR monitorenter ;
        checkScoAudioState();
        if(mScoAudioState != 2 && mScoAudioState != 4)
            break MISSING_BLOCK_LABEL_100;
        if(mBluetoothHeadsetDevice != null)
            if(mBluetoothHeadset != null) {
                if(!mBluetoothHeadset.stopVoiceRecognition(mBluetoothHeadsetDevice))
                    sendMsg(mAudioHandler, 11, 0, 0, 0, null, 0);
            } else
            if(mScoAudioState == 2 && getBluetoothHeadset())
                mScoAudioState = 4;
_L1:
        arraylist;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
        clearAllScoClients(i, true);
          goto _L1
    }

    private void dispatchMediaKeyEvent(KeyEvent keyevent, boolean flag) {
        char c;
        Intent intent;
        c = '\u07BC';
        if(flag)
            mMediaEventWakeLock.acquire();
        intent = new Intent("android.intent.action.MEDIA_BUTTON", null);
        intent.putExtra("android.intent.extra.KEY_EVENT", keyevent);
        Stack stack = mRCStack;
        stack;
        JVM INSTR monitorenter ;
        boolean flag1 = mRCStack.empty();
        if(flag1) goto _L2; else goto _L1
_L1:
        PendingIntent pendingintent;
        Context context;
        pendingintent = ((RemoteControlStackEntry)mRCStack.peek()).mMediaIntent;
        context = mContext;
        Exception exception;
        android.app.PendingIntent.CanceledException canceledexception;
        if(!flag)
            c = '\0';
        pendingintent.send(context, c, intent, this, mAudioHandler);
_L3:
        stack;
        JVM INSTR monitorexit ;
        return;
        canceledexception;
        Log.e("AudioService", (new StringBuilder()).append("Error sending pending intent ").append(mRCStack.peek()).toString());
        canceledexception.printStackTrace();
          goto _L3
        exception;
        throw exception;
_L2:
        if(!flag)
            break MISSING_BLOCK_LABEL_170;
        intent.putExtra("android.media.AudioService.WAKELOCK_ACQUIRED", 1980);
        mContext.sendOrderedBroadcast(intent, null, mKeyEventDone, mAudioHandler, -1, null, null);
          goto _L3
    }

    private void dispatchMediaKeyEventForCalls(KeyEvent keyevent, boolean flag) {
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON", null);
        intent.putExtra("android.intent.extra.KEY_EVENT", keyevent);
        intent.setPackage(mMediaReceiverForCalls.getPackageName());
        if(flag) {
            mMediaEventWakeLock.acquire();
            intent.putExtra("android.media.AudioService.WAKELOCK_ACQUIRED", 1980);
        }
        mContext.sendOrderedBroadcast(intent, null, mKeyEventDone, mAudioHandler, -1, null, null);
    }

    private void doSetMasterVolume(float f, int i) {
        if(!AudioSystem.getMasterMute()) {
            int j = getMasterVolume();
            AudioSystem.setMasterVolume(f);
            int k = getMasterVolume();
            if(k != j)
                sendMsg(mAudioHandler, 2, 0, Math.round(1000F * f), 0, null, 500);
            sendMasterVolumeUpdate(i, j, k);
        }
    }

    private void dumpFocusStack(PrintWriter printwriter) {
        printwriter.println("\nAudio Focus stack entries:");
        Object obj = mAudioFocusLock;
        obj;
        JVM INSTR monitorenter ;
        FocusStackEntry focusstackentry;
        for(Iterator iterator = mFocusStack.iterator(); iterator.hasNext(); printwriter.println((new StringBuilder()).append("     source:").append(focusstackentry.mSourceRef).append(" -- client: ").append(focusstackentry.mClientId).append(" -- duration: ").append(focusstackentry.mFocusChangeType).append(" -- uid: ").append(focusstackentry.mCallingUid).toString()))
            focusstackentry = (FocusStackEntry)iterator.next();

        break MISSING_BLOCK_LABEL_122;
        Exception exception;
        exception;
        throw exception;
        obj;
        JVM INSTR monitorexit ;
    }

    private void dumpRCCStack(PrintWriter printwriter) {
        printwriter.println("\nRemote Control Client stack entries:");
        Stack stack = mRCStack;
        stack;
        JVM INSTR monitorenter ;
        RemoteControlStackEntry remotecontrolstackentry;
        for(Iterator iterator = mRCStack.iterator(); iterator.hasNext(); printwriter.println((new StringBuilder()).append("  uid: ").append(remotecontrolstackentry.mCallingUid).append("  -- id: ").append(remotecontrolstackentry.mRccId).append("  -- type: ").append(remotecontrolstackentry.mPlaybackType).append("  -- state: ").append(remotecontrolstackentry.mPlaybackState).append("  -- vol handling: ").append(remotecontrolstackentry.mPlaybackVolumeHandling).append("  -- vol: ").append(remotecontrolstackentry.mPlaybackVolume).append("  -- volMax: ").append(remotecontrolstackentry.mPlaybackVolumeMax).append("  -- volObs: ").append(remotecontrolstackentry.mRemoteVolumeObs).toString()))
            remotecontrolstackentry = (RemoteControlStackEntry)iterator.next();

        break MISSING_BLOCK_LABEL_179;
        Exception exception;
        exception;
        throw exception;
        stack;
        JVM INSTR monitorexit ;
        RemotePlaybackState remoteplaybackstate = mMainRemote;
        remoteplaybackstate;
        JVM INSTR monitorenter ;
        printwriter.println("\nRemote Volume State:");
        printwriter.println((new StringBuilder()).append("  has remote: ").append(mHasRemotePlayback).toString());
        printwriter.println((new StringBuilder()).append("  is remote active: ").append(mMainRemoteIsActive).toString());
        printwriter.println((new StringBuilder()).append("  rccId: ").append(mMainRemote.mRccId).toString());
        StringBuilder stringbuilder = (new StringBuilder()).append("  volume handling: ");
        String s;
        if(mMainRemote.mVolumeHandling == 0)
            s = "PLAYBACK_VOLUME_FIXED(0)";
        else
            s = "PLAYBACK_VOLUME_VARIABLE(1)";
        printwriter.println(stringbuilder.append(s).toString());
        printwriter.println((new StringBuilder()).append("  volume: ").append(mMainRemote.mVolume).toString());
        printwriter.println((new StringBuilder()).append("  volume steps: ").append(mMainRemote.mVolumeMax).toString());
        return;
    }

    private void dumpRCStack(PrintWriter printwriter) {
        printwriter.println("\nRemote Control stack entries:");
        Stack stack = mRCStack;
        stack;
        JVM INSTR monitorenter ;
        RemoteControlStackEntry remotecontrolstackentry;
        for(Iterator iterator = mRCStack.iterator(); iterator.hasNext(); printwriter.println((new StringBuilder()).append("  pi: ").append(remotecontrolstackentry.mMediaIntent).append("  -- ercvr: ").append(remotecontrolstackentry.mReceiverComponent).append("  -- client: ").append(remotecontrolstackentry.mRcClient).append("  -- uid: ").append(remotecontrolstackentry.mCallingUid).append("  -- type: ").append(remotecontrolstackentry.mPlaybackType).append("  state: ").append(remotecontrolstackentry.mPlaybackState).toString()))
            remotecontrolstackentry = (RemoteControlStackEntry)iterator.next();

        break MISSING_BLOCK_LABEL_151;
        Exception exception;
        exception;
        throw exception;
        stack;
        JVM INSTR monitorexit ;
    }

    private void dumpStreamStates(PrintWriter printwriter) {
        printwriter.println("\nStream volumes (device: index)");
        int i = AudioSystem.getNumStreamTypes();
        for(int j = 0; j < i; j++) {
            printwriter.println((new StringBuilder()).append("- ").append(STREAM_NAMES[j]).append(":").toString());
            mStreamStates[j].dump(printwriter);
            printwriter.println("");
        }

    }

    private void ensureValidDirection(int i) {
        if(i < -1 || i > 1)
            throw new IllegalArgumentException((new StringBuilder()).append("Bad direction ").append(i).toString());
        else
            return;
    }

    private void ensureValidRingerMode(int i) {
        if(!AudioManager.isValidRingerMode(i))
            throw new IllegalArgumentException((new StringBuilder()).append("Bad ringer mode ").append(i).toString());
        else
            return;
    }

    private void ensureValidSteps(int i) {
        if(Math.abs(i) > 4)
            throw new IllegalArgumentException((new StringBuilder()).append("Bad volume adjust steps ").append(i).toString());
        else
            return;
    }

    private void ensureValidStreamType(int i) {
        if(i < 0 || i >= mStreamStates.length)
            throw new IllegalArgumentException((new StringBuilder()).append("Bad stream type ").append(i).toString());
        else
            return;
    }

    private void filterMediaKeyEvent(KeyEvent keyevent, boolean flag) {
        if(isValidMediaKeyEvent(keyevent)) goto _L2; else goto _L1
_L1:
        Log.e("AudioService", (new StringBuilder()).append("not dispatching invalid media key event ").append(keyevent).toString());
_L4:
        return;
_L2:
        Object obj = mRingingLock;
        obj;
        JVM INSTR monitorenter ;
        synchronized(mRCStack) {
            if(mMediaReceiverForCalls == null || !mIsRinging && getMode() != 2)
                break MISSING_BLOCK_LABEL_92;
            dispatchMediaKeyEventForCalls(keyevent, flag);
        }
        obj;
        JVM INSTR monitorexit ;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        throw exception;
        stack;
        JVM INSTR monitorexit ;
        obj;
        JVM INSTR monitorexit ;
        if(isValidVoiceInputKeyCode(keyevent.getKeyCode()))
            filterVoiceInputKeyEvent(keyevent, flag);
        else
            dispatchMediaKeyEvent(keyevent, flag);
        if(true) goto _L4; else goto _L3
_L3:
        exception1;
        stack;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    private void filterVoiceInputKeyEvent(KeyEvent keyevent, boolean flag) {
        int i;
        int j;
        i = 1;
        j = keyevent.getAction();
        Object obj = mVoiceEventLock;
        obj;
        JVM INSTR monitorenter ;
        if(j != 0) goto _L2; else goto _L1
_L1:
        if(keyevent.getRepeatCount() != 0) goto _L4; else goto _L3
_L3:
        mVoiceButtonDown = true;
        mVoiceButtonHandled = false;
_L6:
        obj;
        JVM INSTR monitorexit ;
        switch(i) {
        case 2: // '\002'
            startVoiceBasedInteractions(flag);
            break;

        case 3: // '\003'
            sendSimulatedMediaButtonEvent(keyevent, flag);
            break;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if(mVoiceButtonDown && !mVoiceButtonHandled && (0x80 & keyevent.getFlags()) != 0) {
            mVoiceButtonHandled = true;
            i = 2;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if(j == 1 && mVoiceButtonDown) {
            mVoiceButtonDown = false;
            if(!mVoiceButtonHandled && !keyevent.isCanceled())
                i = 3;
        }
        if(true) goto _L6; else goto _L5
_L5:
    }

    private int findVolumeDelta(int i, int j) {
        int k;
        int l;
        k = 0;
        l = 0;
        if(i != 1) goto _L2; else goto _L1
_L1:
        if(j != 100) goto _L4; else goto _L3
_L3:
        return k;
_L4:
        int k1;
        l = mMasterVolumeRamp[1];
        k1 = -1 + mMasterVolumeRamp.length;
_L9:
        if(k1 <= 1) goto _L6; else goto _L5
_L5:
        if(j < mMasterVolumeRamp[k1 - 1]) goto _L8; else goto _L7
_L7:
        l = mMasterVolumeRamp[k1];
_L6:
        k = l;
          goto _L3
_L8:
        k1 -= 2;
          goto _L9
_L2:
        if(i != -1) goto _L6; else goto _L10
_L10:
        if(j == 0) goto _L3; else goto _L11
_L11:
        int i1;
        int j1;
        i1 = mMasterVolumeRamp.length;
        l = -mMasterVolumeRamp[i1 - 1];
        j1 = 2;
_L12:
        if(j1 < i1) {
label0:
            {
                if(j > mMasterVolumeRamp[j1])
                    break label0;
                l = -mMasterVolumeRamp[j1 - 1];
            }
        }
          goto _L6
        j1 += 2;
          goto _L12
    }

    private int getActiveStreamType(int i) {
        if(!mVoiceCapable) goto _L2; else goto _L1
_L1:
        if(!isInCommunication()) goto _L4; else goto _L3
_L3:
        if(AudioSystem.getForceUse(0) == 3)
            i = 6;
        else
            i = 0;
_L6:
        return i;
_L4:
        if(i == 0x80000000) {
            if(checkUpdateRemoteStateIfActive(3))
                i = -200;
            else
            if(AudioSystem.isStreamActive(3, 0))
                i = 3;
            else
                i = 2;
        } else
        if(AudioSystem.isStreamActive(3, 0))
            i = 3;
        continue; /* Loop/switch isn't completed */
_L2:
        if(isInCommunication()) {
            if(AudioSystem.getForceUse(0) == 3)
                i = 6;
            else
                i = 0;
        } else
        if(AudioSystem.isStreamActive(5, 5000) || AudioSystem.isStreamActive(2, 5000))
            i = 5;
        else
        if(i == 0x80000000)
            if(checkUpdateRemoteStateIfActive(3))
                i = -200;
            else
                i = 3;
        if(true) goto _L6; else goto _L5
_L5:
    }

    private boolean getBluetoothHeadset() {
        boolean flag = false;
        BluetoothAdapter bluetoothadapter = BluetoothAdapter.getDefaultAdapter();
        if(bluetoothadapter != null)
            flag = bluetoothadapter.getProfileProxy(mContext, mBluetoothProfileServiceListener, 1);
        AudioHandler audiohandler = mAudioHandler;
        char c;
        if(flag)
            c = '\u0BB8';
        else
            c = '\0';
        sendMsg(audiohandler, 11, 0, 0, 0, null, c);
        return flag;
    }

    private int getDeviceForStream(int i) {
        int j = AudioSystem.getDevicesForStream(i);
        if((j & j - 1) != 0)
            if((j & 2) != 0)
                j = 2;
            else
                j &= 0x380;
        return j;
    }

    private ScoClient getScoClient(IBinder ibinder, boolean flag) {
        ArrayList arraylist = mScoClients;
        arraylist;
        JVM INSTR monitorenter ;
        int i = mScoClients.size();
        int j;
        ScoClient scoclient;
        j = 0;
        scoclient = null;
_L5:
        if(j >= i) goto _L2; else goto _L1
_L1:
        ScoClient scoclient3 = (ScoClient)mScoClients.get(j);
        if(scoclient3.getBinder() != ibinder) goto _L4; else goto _L3
_L3:
        arraylist;
        JVM INSTR monitorexit ;
        ScoClient scoclient2 = scoclient3;
_L8:
        return scoclient2;
_L4:
        j++;
        scoclient = scoclient3;
          goto _L5
_L2:
        if(!flag) goto _L7; else goto _L6
_L6:
        ScoClient scoclient1 = new ScoClient(ibinder);
        mScoClients.add(scoclient1);
_L10:
        arraylist;
        JVM INSTR monitorexit ;
        scoclient2 = scoclient1;
          goto _L8
_L9:
        arraylist;
        JVM INSTR monitorexit ;
        Exception exception;
        throw exception;
        exception;
        scoclient;
          goto _L9
_L7:
        scoclient1 = scoclient;
          goto _L10
        exception;
          goto _L9
    }

    public static int getValueForVibrateSetting(int i, int j, int k) {
        return i & (-1 ^ 3 << j * 2) | (k & 3) << j * 2;
    }

    private void handleConfigurationChanged(Context context) {
        int i = context.getResources().getConfiguration().orientation;
        if(i != mDeviceOrientation) {
            mDeviceOrientation = i;
            setOrientationForAudioSystem();
        }
_L1:
        return;
        Exception exception;
        exception;
        Log.e("AudioService", (new StringBuilder()).append("Error retrieving device orientation: ").append(exception).toString());
          goto _L1
    }

    private boolean handleDeviceConnection(boolean flag, int i, String s) {
        HashMap hashmap = mConnectedDevices;
        hashmap;
        JVM INSTR monitorenter ;
        boolean flag1;
        boolean flag2;
        if(mConnectedDevices.containsKey(Integer.valueOf(i)) && (s.isEmpty() || ((String)mConnectedDevices.get(Integer.valueOf(i))).equals(s)))
            flag1 = true;
        else
            flag1 = false;
        if(flag1 && !flag) {
            AudioSystem.setDeviceConnectionState(i, 0, (String)mConnectedDevices.get(Integer.valueOf(i)));
            mConnectedDevices.remove(Integer.valueOf(i));
            flag2 = true;
        } else
        if(!flag1 && flag) {
            AudioSystem.setDeviceConnectionState(i, 1, s);
            mConnectedDevices.put(new Integer(i), s);
            flag2 = true;
        } else {
            flag2 = false;
        }
        return flag2;
    }

    private boolean hasScheduledA2dpDockTimeout() {
        return mAudioHandler.hasMessages(7);
    }

    private boolean isCurrentRcController(PendingIntent pendingintent) {
        boolean flag;
        if(!mRCStack.empty() && ((RemoteControlStackEntry)mRCStack.peek()).mMediaIntent.equals(pendingintent))
            flag = true;
        else
            flag = false;
        return flag;
    }

    private boolean isInCommunication() {
        boolean flag;
        flag = false;
        if(!mVoiceCapable)
            break MISSING_BLOCK_LABEL_37;
        boolean flag2;
        ITelephony itelephony = com.android.internal.telephony.ITelephony.Stub.asInterface(ServiceManager.checkService("phone"));
        if(itelephony == null)
            break MISSING_BLOCK_LABEL_37;
        flag2 = itelephony.isOffhook();
        flag = flag2;
_L1:
        boolean flag1;
        RemoteException remoteexception;
        if(flag || getMode() == 3)
            flag1 = true;
        else
            flag1 = false;
        return flag1;
        remoteexception;
        Log.w("AudioService", "Couldn't connect to phone service", remoteexception);
          goto _L1
    }

    private static boolean isPlaystateActive(int i) {
        i;
        JVM INSTR tableswitch 3 8: default 40
    //                   3 44
    //                   4 44
    //                   5 44
    //                   6 44
    //                   7 44
    //                   8 44;
           goto _L1 _L2 _L2 _L2 _L2 _L2 _L2
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = true;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private boolean isStreamMutedByRingerMode(int i) {
        boolean flag = true;
        if((mRingerModeMutedStreams & flag << i) == 0)
            flag = false;
        return flag;
    }

    private static boolean isValidMediaKeyEvent(KeyEvent keyevent) {
        boolean flag = false;
        if(keyevent != null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        switch(keyevent.getKeyCode()) {
        case 79: // 'O'
        case 85: // 'U'
        case 86: // 'V'
        case 87: // 'W'
        case 88: // 'X'
        case 89: // 'Y'
        case 90: // 'Z'
        case 91: // '['
        case 126: // '~'
        case 127: // '\177'
        case 128: 
        case 129: 
        case 130: 
            flag = true;
            break;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private static boolean isValidVoiceInputKeyCode(int i) {
        boolean flag;
        if(i == 79)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private void makeA2dpDeviceAvailable(String s) {
        setBluetoothA2dpOnInt(true);
        AudioSystem.setDeviceConnectionState(128, 1, s);
        AudioSystem.setParameters("A2dpSuspended=false");
        mConnectedDevices.put(new Integer(128), s);
    }

    private void makeA2dpDeviceUnavailableLater(String s) {
        AudioSystem.setParameters("A2dpSuspended=true");
        mConnectedDevices.remove(Integer.valueOf(128));
        Message message = mAudioHandler.obtainMessage(7, s);
        mAudioHandler.sendMessageDelayed(message, 8000L);
    }

    private void makeA2dpDeviceUnavailableNow(String s) {
        AudioSystem.setDeviceConnectionState(128, 0, s);
        mConnectedDevices.remove(Integer.valueOf(128));
    }

    private void notifyTopOfAudioFocusStack() {
        if(mFocusStack.empty() || ((FocusStackEntry)mFocusStack.peek()).mFocusDispatcher == null || !canReassignAudioFocus())
            break MISSING_BLOCK_LABEL_65;
        ((FocusStackEntry)mFocusStack.peek()).mFocusDispatcher.dispatchAudioFocusChange(1, ((FocusStackEntry)mFocusStack.peek()).mClientId);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("AudioService", (new StringBuilder()).append("Failure to signal gain of audio control focus due to ").append(remoteexception).toString());
        remoteexception.printStackTrace();
          goto _L1
    }

    private void onNewPlaybackInfoForRcc(int i, int j, int k) {
        Stack stack = mRCStack;
        stack;
        JVM INSTR monitorenter ;
        Iterator iterator = mRCStack.iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        RemoteControlStackEntry remotecontrolstackentry = (RemoteControlStackEntry)iterator.next();
        if(remotecontrolstackentry.mRccId != i) goto _L4; else goto _L3
_L3:
        j;
        JVM INSTR lookupswitch 6: default 108
    //                   1: 150
    //                   2: 171
    //                   3: 226
    //                   4: 281
    //                   5: 336
    //                   255: 345;
           goto _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L5:
        Log.e("AudioService", (new StringBuilder()).append("unhandled key ").append(j).append(" for RCC ").append(i).toString());
_L12:
        stack;
        JVM INSTR monitorexit ;
        break; /* Loop/switch isn't completed */
_L6:
        remotecontrolstackentry.mPlaybackType = k;
        postReevaluateRemote();
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        throw exception;
_L7:
        remotecontrolstackentry.mPlaybackVolume = k;
        RemotePlaybackState remoteplaybackstate3 = mMainRemote;
        remoteplaybackstate3;
        JVM INSTR monitorenter ;
        if(i == mMainRemote.mRccId) {
            mMainRemote.mVolume = k;
            mVolumePanel.postHasNewRemotePlaybackInfo();
        }
        remoteplaybackstate3;
        JVM INSTR monitorexit ;
        continue; /* Loop/switch isn't completed */
_L8:
        remotecontrolstackentry.mPlaybackVolumeMax = k;
        RemotePlaybackState remoteplaybackstate2 = mMainRemote;
        remoteplaybackstate2;
        JVM INSTR monitorenter ;
        if(i == mMainRemote.mRccId) {
            mMainRemote.mVolumeMax = k;
            mVolumePanel.postHasNewRemotePlaybackInfo();
        }
        remoteplaybackstate2;
        JVM INSTR monitorexit ;
        continue; /* Loop/switch isn't completed */
_L9:
        remotecontrolstackentry.mPlaybackVolumeHandling = k;
        RemotePlaybackState remoteplaybackstate1 = mMainRemote;
        remoteplaybackstate1;
        JVM INSTR monitorenter ;
        if(i == mMainRemote.mRccId) {
            mMainRemote.mVolumeHandling = k;
            mVolumePanel.postHasNewRemotePlaybackInfo();
        }
        remoteplaybackstate1;
        JVM INSTR monitorexit ;
        continue; /* Loop/switch isn't completed */
_L10:
        remotecontrolstackentry.mPlaybackStream = k;
        continue; /* Loop/switch isn't completed */
_L11:
        remotecontrolstackentry.mPlaybackState = k;
        RemotePlaybackState remoteplaybackstate = mMainRemote;
        remoteplaybackstate;
        JVM INSTR monitorenter ;
        if(i == mMainRemote.mRccId) {
            mMainRemoteIsActive = isPlaystateActive(k);
            postReevaluateRemote();
        }
        remoteplaybackstate;
        JVM INSTR monitorexit ;
        if(true) goto _L12; else goto _L2
_L2:
    }

    private void onRcDisplayClear() {
        Stack stack = mRCStack;
        stack;
        JVM INSTR monitorenter ;
        synchronized(mCurrentRcLock) {
            mCurrentRcClientGen = 1 + mCurrentRcClientGen;
            setNewRcClient_syncRcsCurrc(mCurrentRcClientGen, null, true);
        }
        stack;
        JVM INSTR monitorexit ;
        return;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        throw exception;
    }

    private void onRcDisplayUpdate(RemoteControlStackEntry remotecontrolstackentry, int i) {
        Stack stack = mRCStack;
        stack;
        JVM INSTR monitorenter ;
        Object obj = mCurrentRcLock;
        obj;
        JVM INSTR monitorenter ;
        if(mCurrentRcClient == null || !mCurrentRcClient.equals(remotecontrolstackentry.mRcClient))
            break MISSING_BLOCK_LABEL_82;
        mCurrentRcClientGen = 1 + mCurrentRcClientGen;
        setNewRcClient_syncRcsCurrc(mCurrentRcClientGen, remotecontrolstackentry.mMediaIntent, false);
        try {
            mCurrentRcClient.onInformationRequested(mCurrentRcClientGen, i, mArtworkExpectedWidth, mArtworkExpectedHeight);
        }
        catch(RemoteException remoteexception) {
            Log.e("AudioService", (new StringBuilder()).append("Current valid remote client is dead: ").append(remoteexception).toString());
            mCurrentRcClient = null;
        }
        stack;
        JVM INSTR monitorexit ;
        return;
        Exception exception1;
        exception1;
        throw exception1;
        Exception exception;
        exception;
        throw exception;
    }

    private void onReevaluateRemote() {
        boolean flag = false;
        synchronized(mRCStack) {
            Iterator iterator = mRCStack.iterator();
            do {
                if(!iterator.hasNext())
                    break;
                if(((RemoteControlStackEntry)iterator.next()).mPlaybackType != 1)
                    continue;
                flag = true;
                break;
            } while(true);
        }
        synchronized(mMainRemote) {
            if(mHasRemotePlayback != flag) {
                mHasRemotePlayback = flag;
                mVolumePanel.postRemoteSliderVisibility(flag);
            }
        }
        return;
        exception;
        stack;
        JVM INSTR monitorexit ;
        throw exception;
        exception1;
        remoteplaybackstate;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    private void onRegisterVolumeObserverForRcc(int i, IRemoteVolumeObserver iremotevolumeobserver) {
        Stack stack = mRCStack;
        stack;
        JVM INSTR monitorenter ;
        Iterator iterator = mRCStack.iterator();
        do {
            if(!iterator.hasNext())
                break;
            RemoteControlStackEntry remotecontrolstackentry = (RemoteControlStackEntry)iterator.next();
            if(remotecontrolstackentry.mRccId != i)
                continue;
            remotecontrolstackentry.mRemoteVolumeObs = iremotevolumeobserver;
            break;
        } while(true);
        return;
    }

    private void onSetA2dpConnectionState(BluetoothDevice bluetoothdevice, int i) {
        boolean flag = true;
        if(bluetoothdevice != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s;
        s = bluetoothdevice.getAddress();
        if(!BluetoothAdapter.checkBluetoothAddress(s))
            s = "";
        HashMap hashmap = mConnectedDevices;
        hashmap;
        JVM INSTR monitorenter ;
        Exception exception;
        if(!mConnectedDevices.containsKey(Integer.valueOf(128)) || !((String)mConnectedDevices.get(Integer.valueOf(128))).equals(s))
            flag = false;
        if(!flag || i == 2) goto _L4; else goto _L3
_L3:
        if(!bluetoothdevice.isBluetoothDock()) goto _L6; else goto _L5
_L5:
        if(i == 0)
            makeA2dpDeviceUnavailableLater(s);
_L7:
        synchronized(mCurAudioRoutes) {
            if(mCurAudioRoutes.mBluetoothName != null) {
                mCurAudioRoutes.mBluetoothName = null;
                sendMsg(mAudioHandler, 16, 1, 0, 0, null, 0);
            }
        }
_L9:
        hashmap;
        JVM INSTR monitorexit ;
          goto _L1
        exception;
        throw exception;
_L6:
        makeA2dpDeviceUnavailableNow(s);
          goto _L7
        exception1;
        audioroutesinfo1;
        JVM INSTR monitorexit ;
        throw exception1;
_L4:
        if(flag || i != 2) goto _L9; else goto _L8
_L8:
        if(!bluetoothdevice.isBluetoothDock()) goto _L11; else goto _L10
_L10:
        cancelA2dpDeviceTimeout();
        mDockAddress = s;
_L12:
        makeA2dpDeviceAvailable(s);
        AudioRoutesInfo audioroutesinfo = mCurAudioRoutes;
        audioroutesinfo;
        JVM INSTR monitorenter ;
        String s1 = bluetoothdevice.getAliasName();
        if(!TextUtils.equals(mCurAudioRoutes.mBluetoothName, s1)) {
            mCurAudioRoutes.mBluetoothName = s1;
            sendMsg(mAudioHandler, 16, 1, 0, 0, null, 0);
        }
        audioroutesinfo;
        JVM INSTR monitorexit ;
          goto _L9
_L11:
        if(hasScheduledA2dpDockTimeout()) {
            cancelA2dpDeviceTimeout();
            makeA2dpDeviceUnavailableNow(mDockAddress);
        }
          goto _L12
    }

    private void onSetWiredDeviceConnectionState(int i, int j, String s) {
        boolean flag = true;
        HashMap hashmap = mConnectedDevices;
        hashmap;
        JVM INSTR monitorenter ;
        if(j == 0 && (i == 4 || i == 8))
            setBluetoothA2dpOnInt(true);
        if(j != flag)
            flag = false;
        while(true)  {
            handleDeviceConnection(flag, i, "");
            if(j != 0 && (i == 4 || i == 8))
                setBluetoothA2dpOnInt(false);
            sendDeviceConnectionIntent(i, j, s);
            return;
        }
    }

    private void postReevaluateRemote() {
        sendMsg(mAudioHandler, 17, 2, 0, 0, null, 0);
    }

    private void pushMediaButtonReceiver(PendingIntent pendingintent, ComponentName componentname) {
        if(mRCStack.empty() || !((RemoteControlStackEntry)mRCStack.peek()).mMediaIntent.equals(pendingintent)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Iterator iterator = mRCStack.iterator();
        RemoteControlStackEntry remotecontrolstackentry = null;
        boolean flag = false;
        do {
            if(!iterator.hasNext())
                break;
            remotecontrolstackentry = (RemoteControlStackEntry)iterator.next();
            if(!remotecontrolstackentry.mMediaIntent.equals(pendingintent))
                continue;
            flag = true;
            iterator.remove();
            break;
        } while(true);
        if(!flag)
            remotecontrolstackentry = new RemoteControlStackEntry(pendingintent, componentname);
        mRCStack.push(remotecontrolstackentry);
        mAudioHandler.sendMessage(mAudioHandler.obtainMessage(10, 0, 0, componentname));
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void queueMsgUnderWakeLock(Handler handler, int i, int j, int k, Object obj, int l) {
        mMediaEventWakeLock.acquire();
        sendMsg(handler, i, 2, j, k, obj, l);
    }

    private void rcDisplay_startDeathMonitor_syncRcStack() {
        IBinder ibinder;
        if(mRcDisplay == null)
            break MISSING_BLOCK_LABEL_41;
        ibinder = mRcDisplay.asBinder();
        mRcDisplayDeathHandler = new RcDisplayDeathHandler(ibinder);
        ibinder.linkToDeath(mRcDisplayDeathHandler, 0);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.w("AudioService", (new StringBuilder()).append("registerRemoteControlDisplay() has a dead client ").append(ibinder).toString());
        mRcDisplay = null;
          goto _L1
    }

    private void rcDisplay_stopDeathMonitor_syncRcStack() {
        if(mRcDisplay != null)
            mRcDisplayDeathHandler.unlinkToRcDisplayDeath();
    }

    private void readPersistedSettings() {
        byte byte0 = 2;
        ContentResolver contentresolver = mContentResolver;
        int i = android.provider.Settings.System.getInt(contentresolver, "mode_ringer", byte0);
        int j = i;
        if(!AudioManager.isValidRingerMode(j))
            j = 2;
        if(j == 1 && !mHasVibrator)
            j = 0;
        if(j != i)
            android.provider.Settings.System.putInt(contentresolver, "mode_ringer", j);
        synchronized(mSettingsLock) {
            mRingerMode = j;
        }
        byte byte1;
        int k;
        boolean flag;
        if(mHasVibrator)
            byte1 = byte0;
        else
            byte1 = 0;
        mVibrateSetting = getValueForVibrateSetting(0, 1, byte1);
        k = mVibrateSetting;
        if(!mHasVibrator)
            byte0 = 0;
        mVibrateSetting = getValueForVibrateSetting(k, 0, byte0);
        mRingerModeAffectedStreams = android.provider.Settings.System.getInt(contentresolver, "mode_ringer_streams_affected", 166);
        if(mVoiceCapable)
            mRingerModeAffectedStreams = -9 & mRingerModeAffectedStreams;
        else
            mRingerModeAffectedStreams = 8 | mRingerModeAffectedStreams;
        android.provider.Settings.System.putInt(contentresolver, "mode_ringer_streams_affected", mRingerModeAffectedStreams);
        mMuteAffectedStreams = android.provider.Settings.System.getInt(contentresolver, "mute_streams_affected", 14);
        if(android.provider.Settings.System.getInt(contentresolver, "volume_master_mute", 0) == 1)
            flag = true;
        else
            flag = false;
        AudioSystem.setMasterMute(flag);
        broadcastMasterMuteStatus(flag);
        broadcastRingerMode(j);
        broadcastVibrateSetting(0);
        broadcastVibrateSetting(1);
        restoreMediaButtonReceiver();
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void removeFocusStackEntry(String s, boolean flag) {
        if(mFocusStack.empty() || !((FocusStackEntry)mFocusStack.peek()).mClientId.equals(s))
            break MISSING_BLOCK_LABEL_80;
        ((FocusStackEntry)mFocusStack.pop()).unlinkToDeath();
        if(!flag)
            break MISSING_BLOCK_LABEL_164;
        notifyTopOfAudioFocusStack();
        Stack stack = mRCStack;
        stack;
        JVM INSTR monitorenter ;
        checkUpdateRemoteControlDisplay_syncAfRcs(15);
        break MISSING_BLOCK_LABEL_164;
        Iterator iterator = mFocusStack.iterator();
        do {
            if(!iterator.hasNext())
                break;
            FocusStackEntry focusstackentry = (FocusStackEntry)iterator.next();
            if(focusstackentry.mClientId.equals(s)) {
                Log.i("AudioService", (new StringBuilder()).append(" AudioFocus  abandonAudioFocus(): removing entry for ").append(focusstackentry.mClientId).toString());
                iterator.remove();
                focusstackentry.unlinkToDeath();
            }
        } while(true);
    }

    private void removeFocusStackEntryForClient(IBinder ibinder) {
        boolean flag;
        Iterator iterator;
        if(!mFocusStack.isEmpty() && ((FocusStackEntry)mFocusStack.peek()).mSourceRef.equals(ibinder))
            flag = true;
        else
            flag = false;
        iterator = mFocusStack.iterator();
        do {
            if(!iterator.hasNext())
                break;
            FocusStackEntry focusstackentry = (FocusStackEntry)iterator.next();
            if(focusstackentry.mSourceRef.equals(ibinder)) {
                Log.i("AudioService", (new StringBuilder()).append(" AudioFocus  abandonAudioFocus(): removing entry for ").append(focusstackentry.mClientId).toString());
                iterator.remove();
            }
        } while(true);
        if(!flag)
            break MISSING_BLOCK_LABEL_153;
        notifyTopOfAudioFocusStack();
        Stack stack = mRCStack;
        stack;
        JVM INSTR monitorenter ;
        checkUpdateRemoteControlDisplay_syncAfRcs(15);
    }

    private void removeMediaButtonReceiver(PendingIntent pendingintent) {
        Iterator iterator = mRCStack.iterator();
        do {
            if(!iterator.hasNext())
                break;
            RemoteControlStackEntry remotecontrolstackentry = (RemoteControlStackEntry)iterator.next();
            if(!remotecontrolstackentry.mMediaIntent.equals(pendingintent))
                continue;
            iterator.remove();
            remotecontrolstackentry.unlinkToRcClientDeath();
            break;
        } while(true);
    }

    private void removeMediaButtonReceiverForPackage(String s) {
        Stack stack = mRCStack;
        stack;
        JVM INSTR monitorenter ;
        RemoteControlStackEntry remotecontrolstackentry;
        if(!mRCStack.empty()) {
            remotecontrolstackentry = (RemoteControlStackEntry)mRCStack.peek();
            Iterator iterator = mRCStack.iterator();
            do {
                if(!iterator.hasNext())
                    break;
                RemoteControlStackEntry remotecontrolstackentry1 = (RemoteControlStackEntry)iterator.next();
                if(s.equalsIgnoreCase(remotecontrolstackentry1.mReceiverComponent.getPackageName())) {
                    iterator.remove();
                    remotecontrolstackentry1.unlinkToRcClientDeath();
                }
            } while(true);
            break MISSING_BLOCK_LABEL_100;
        }
          goto _L1
        Exception exception;
        exception;
        throw exception;
        if(!mRCStack.empty()) goto _L3; else goto _L2
_L2:
        mAudioHandler.sendMessage(mAudioHandler.obtainMessage(10, 0, 0, null));
_L4:
        stack;
        JVM INSTR monitorexit ;
        break; /* Loop/switch isn't completed */
_L3:
        if(remotecontrolstackentry != mRCStack.peek())
            mAudioHandler.sendMessage(mAudioHandler.obtainMessage(10, 0, 0, ((RemoteControlStackEntry)mRCStack.peek()).mReceiverComponent));
        if(true) goto _L4; else goto _L1
_L1:
    }

    private int rescaleIndex(int i, int j, int k) {
        return (i * mStreamStates[k].getMaxIndex() + mStreamStates[j].getMaxIndex() / 2) / mStreamStates[j].getMaxIndex();
    }

    private void resetBluetoothSco() {
        ArrayList arraylist = mScoClients;
        arraylist;
        JVM INSTR monitorenter ;
        clearAllScoClients(0, false);
        mScoAudioState = 0;
        broadcastScoConnectionState(0);
        return;
    }

    private void restoreMasterVolume() {
        if(mUseMasterVolume) {
            float f = android.provider.Settings.System.getFloat(mContentResolver, "volume_master", -1F);
            if(f >= 0.0F)
                AudioSystem.setMasterVolume(f);
        }
    }

    private void restoreMediaButtonReceiver() {
        String s = android.provider.Settings.System.getString(mContentResolver, "media_button_receiver");
        if(s != null && !s.isEmpty()) {
            ComponentName componentname = ComponentName.unflattenFromString(s);
            Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
            intent.setComponent(componentname);
            registerMediaButtonIntent(PendingIntent.getBroadcast(mContext, 0, intent, 0), componentname);
        }
    }

    private void sendBecomingNoisyIntent() {
        mContext.sendBroadcast(new Intent("android.media.AUDIO_BECOMING_NOISY"));
    }

    private void sendDeviceConnectionIntent(int i, int j, String s) {
        Intent intent;
        byte byte0;
        intent = new Intent();
        intent.putExtra("state", j);
        intent.putExtra("name", s);
        intent.addFlags(0x40000000);
        byte0 = 0;
        if(i != 4) goto _L2; else goto _L1
_L1:
        byte0 = 1;
        intent.setAction("android.intent.action.HEADSET_PLUG");
        intent.putExtra("microphone", 1);
_L9:
        AudioRoutesInfo audioroutesinfo = mCurAudioRoutes;
        audioroutesinfo;
        JVM INSTR monitorenter ;
        if(byte0 == 0) goto _L4; else goto _L3
_L3:
        int k = mCurAudioRoutes.mMainType;
        if(j == 0) goto _L6; else goto _L5
_L5:
        int l = k | byte0;
_L7:
        if(l != mCurAudioRoutes.mMainType) {
            mCurAudioRoutes.mMainType = l;
            sendMsg(mAudioHandler, 16, 1, 0, 0, null, 0);
        }
_L4:
        audioroutesinfo;
        JVM INSTR monitorexit ;
        ActivityManagerNative.broadcastStickyIntent(intent, null);
        return;
_L2:
        if(i == 8) {
            byte0 = 2;
            intent.setAction("android.intent.action.HEADSET_PLUG");
            intent.putExtra("microphone", 0);
        } else
        if(i == 2048) {
            byte0 = 4;
            intent.setAction("android.intent.action.ANALOG_AUDIO_DOCK_PLUG");
        } else
        if(i == 4096) {
            byte0 = 4;
            intent.setAction("android.intent.action.DIGITAL_AUDIO_DOCK_PLUG");
        } else
        if(i == 1024) {
            byte0 = 8;
            intent.setAction("android.intent.action.HDMI_AUDIO_PLUG");
        }
        continue; /* Loop/switch isn't completed */
_L6:
        l = k & ~byte0;
          goto _L7
        Exception exception;
        exception;
        audioroutesinfo;
        JVM INSTR monitorexit ;
        throw exception;
        if(true) goto _L9; else goto _L8
_L8:
    }

    private void sendMasterMuteUpdate(boolean flag, int i) {
        mVolumePanel.postMasterMuteChanged(i);
        broadcastMasterMuteStatus(flag);
    }

    private void sendMasterVolumeUpdate(int i, int j, int k) {
        mVolumePanel.postMasterVolumeChanged(i);
        Intent intent = new Intent("android.media.MASTER_VOLUME_CHANGED_ACTION");
        intent.putExtra("android.media.EXTRA_PREV_MASTER_VOLUME_VALUE", j);
        intent.putExtra("android.media.EXTRA_MASTER_VOLUME_VALUE", k);
        mContext.sendBroadcast(intent);
    }

    private static void sendMsg(Handler handler, int i, int j, int k, int l, Object obj, int i1) {
        if(j != 0) goto _L2; else goto _L1
_L1:
        handler.removeMessages(i);
_L4:
        handler.sendMessageDelayed(handler.obtainMessage(i, k, l, obj), i1);
_L3:
        return;
_L2:
        if(j != 1 || !handler.hasMessages(i)) goto _L4; else goto _L3
    }

    private void sendSimulatedMediaButtonEvent(KeyEvent keyevent, boolean flag) {
        dispatchMediaKeyEvent(KeyEvent.changeAction(keyevent, 0), flag);
        dispatchMediaKeyEvent(KeyEvent.changeAction(keyevent, 1), flag);
    }

    private void sendVolumeUpdate(int i, int j, int k, int l) {
        if(!mVoiceCapable && i == 2)
            i = 5;
        mVolumePanel.postVolumeChanged(i, l);
        int i1 = (j + 5) / 10;
        int j1 = (k + 5) / 10;
        Intent intent = new Intent("android.media.VOLUME_CHANGED_ACTION");
        intent.putExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", i);
        intent.putExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", j1);
        intent.putExtra("android.media.EXTRA_PREV_VOLUME_STREAM_VALUE", i1);
        mContext.sendBroadcast(intent);
    }

    private void sendVolumeUpdateToRemote(int i, int j) {
        if(j != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        IRemoteVolumeObserver iremotevolumeobserver = null;
        synchronized(mRCStack) {
            Iterator iterator = mRCStack.iterator();
            do {
                if(!iterator.hasNext())
                    break;
                RemoteControlStackEntry remotecontrolstackentry = (RemoteControlStackEntry)iterator.next();
                if(remotecontrolstackentry.mRccId != i)
                    continue;
                iremotevolumeobserver = remotecontrolstackentry.mRemoteVolumeObs;
                break;
            } while(true);
        }
        if(iremotevolumeobserver != null)
            try {
                iremotevolumeobserver.dispatchRemoteVolumeUpdate(j, -1);
            }
            catch(RemoteException remoteexception) {
                Log.e("AudioService", "Error dispatching relative volume update", remoteexception);
            }
        if(true) goto _L1; else goto _L3
_L3:
        exception;
        stack;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void setNewRcClientGenerationOnClients_syncRcsCurrc(int i) {
        Iterator iterator = mRCStack.iterator();
        do {
            if(!iterator.hasNext())
                break;
            RemoteControlStackEntry remotecontrolstackentry = (RemoteControlStackEntry)iterator.next();
            if(remotecontrolstackentry != null && remotecontrolstackentry.mRcClient != null)
                try {
                    remotecontrolstackentry.mRcClient.setCurrentClientGenerationId(i);
                }
                catch(RemoteException remoteexception) {
                    Log.w("AudioService", (new StringBuilder()).append("Dead client in setNewRcClientGenerationOnClients_syncRcsCurrc()").append(remoteexception).toString());
                    iterator.remove();
                    remotecontrolstackentry.unlinkToRcClientDeath();
                }
        } while(true);
    }

    private void setNewRcClientOnDisplays_syncRcsCurrc(int i, PendingIntent pendingintent, boolean flag) {
        if(mRcDisplay == null)
            break MISSING_BLOCK_LABEL_19;
        mRcDisplay.setCurrentClientId(i, pendingintent, flag);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("AudioService", (new StringBuilder()).append("Dead display in setNewRcClientOnDisplays_syncRcsCurrc() ").append(remoteexception).toString());
        rcDisplay_stopDeathMonitor_syncRcStack();
        mRcDisplay = null;
          goto _L1
    }

    private void setNewRcClient_syncRcsCurrc(int i, PendingIntent pendingintent, boolean flag) {
        setNewRcClientOnDisplays_syncRcsCurrc(i, pendingintent, flag);
        setNewRcClientGenerationOnClients_syncRcsCurrc(i);
    }

    private void setOrientationForAudioSystem() {
        mDeviceOrientation;
        JVM INSTR tableswitch 0 3: default 36
    //                   0 76
    //                   1 56
    //                   2 46
    //                   3 66;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        Log.e("AudioService", "Unknown orientation");
_L7:
        return;
_L4:
        AudioSystem.setParameters("orientation=landscape");
        continue; /* Loop/switch isn't completed */
_L3:
        AudioSystem.setParameters("orientation=portrait");
        continue; /* Loop/switch isn't completed */
_L5:
        AudioSystem.setParameters("orientation=square");
        continue; /* Loop/switch isn't completed */
_L2:
        AudioSystem.setParameters("orientation=undefined");
        if(true) goto _L7; else goto _L6
_L6:
    }

    private void setRingerModeInt(int i, boolean flag) {
        int j;
        synchronized(mSettingsLock) {
            mRingerMode = i;
        }
        j = -1 + AudioSystem.getNumStreamTypes();
_L9:
        if(j < 0) goto _L2; else goto _L1
_L1:
        if(!isStreamMutedByRingerMode(j)) goto _L4; else goto _L3
_L3:
        if(isStreamAffectedByRingerMode(j) && i != 2)
            break MISSING_BLOCK_LABEL_200;
        if(!mVoiceCapable || mStreamVolumeAlias[j] != 2) goto _L6; else goto _L5
_L5:
        VolumeStreamState volumestreamstate = mStreamStates[j];
        volumestreamstate;
        JVM INSTR monitorenter ;
        Iterator iterator = mStreamStates[j].mLastAudibleIndex.entrySet().iterator();
        do {
            if(!iterator.hasNext())
                break;
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if(((Integer)entry.getValue()).intValue() == 0)
                entry.setValue(Integer.valueOf(10));
        } while(true);
        break MISSING_BLOCK_LABEL_169;
        Exception exception1;
        exception1;
        throw exception1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        volumestreamstate;
        JVM INSTR monitorexit ;
_L6:
        mStreamStates[j].mute(null, false);
        mRingerModeMutedStreams = mRingerModeMutedStreams & (-1 ^ 1 << j);
_L7:
        j--;
        continue; /* Loop/switch isn't completed */
_L4:
        if(isStreamAffectedByRingerMode(j) && i != 2) {
            mStreamStates[j].mute(null, true);
            mRingerModeMutedStreams = mRingerModeMutedStreams | 1 << j;
        }
        if(true) goto _L7; else goto _L2
_L2:
        if(flag)
            sendMsg(mAudioHandler, 3, 0, 0, 0, null, 500);
        return;
        if(true) goto _L9; else goto _L8
_L8:
    }

    private void setStreamVolumeInt(int i, int j, int k, boolean flag, boolean flag1) {
        VolumeStreamState volumestreamstate = mStreamStates[i];
        if(volumestreamstate.muteCount() == 0) goto _L2; else goto _L1
_L1:
        if(j != 0) {
            volumestreamstate.setLastAudibleIndex(j, k);
            sendMsg(mAudioHandler, 1, 2, 2, k, volumestreamstate, 500);
        }
_L4:
        return;
_L2:
        if(volumestreamstate.setIndex(j, k, flag1) || flag)
            sendMsg(mAudioHandler, 0, 2, k, 0, volumestreamstate, 0);
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void startVoiceBasedInteractions(boolean flag) {
        android.os.PowerManager.WakeLock wakelock;
        boolean flag1 = true;
        PowerManager powermanager = (PowerManager)mContext.getSystemService("power");
        boolean flag2;
        Intent intent;
        if(mKeyguardManager != null && mKeyguardManager.isKeyguardLocked())
            flag2 = flag1;
        else
            flag2 = false;
        if(!flag2 && powermanager.isScreenOn()) {
            intent = new Intent("android.speech.action.WEB_SEARCH");
        } else {
            intent = new Intent("android.speech.action.VOICE_SEARCH_HANDS_FREE");
            if(!flag2 || !mKeyguardManager.isKeyguardSecure())
                flag1 = false;
            intent.putExtra("android.speech.extras.EXTRA_SECURE", flag1);
        }
        if(flag)
            mMediaEventWakeLock.acquire();
        if(intent == null)
            break MISSING_BLOCK_LABEL_94;
        intent.setFlags(0x10800000);
        mContext.startActivity(intent);
        if(!flag) goto _L2; else goto _L1
_L1:
        wakelock = mMediaEventWakeLock;
_L5:
        wakelock.release();
_L2:
        return;
        ActivityNotFoundException activitynotfoundexception;
        activitynotfoundexception;
        Log.w("AudioService", (new StringBuilder()).append("No activity for search: ").append(activitynotfoundexception).toString());
        if(!flag) goto _L2; else goto _L3
_L3:
        wakelock = mMediaEventWakeLock;
        if(true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        if(flag)
            mMediaEventWakeLock.release();
        throw exception;
    }

    private void updateRemoteControlDisplay_syncAfRcs(int i) {
        RemoteControlStackEntry remotecontrolstackentry = (RemoteControlStackEntry)mRCStack.peek();
        int j = i;
        if(remotecontrolstackentry.mRcClient == null) {
            clearRemoteControlDisplay_syncAfRcs();
        } else {
            synchronized(mCurrentRcLock) {
                if(!remotecontrolstackentry.mRcClient.equals(mCurrentRcClient))
                    j = 15;
                mCurrentRcClient = remotecontrolstackentry.mRcClient;
            }
            mAudioHandler.sendMessage(mAudioHandler.obtainMessage(13, j, 0, remotecontrolstackentry));
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void updateStreamVolumeAlias(boolean flag) {
        byte byte0;
        if(mVoiceCapable) {
            mStreamVolumeAlias = STREAM_VOLUME_ALIAS;
            byte0 = 2;
        } else {
            mStreamVolumeAlias = STREAM_VOLUME_ALIAS_NON_VOICE;
            byte0 = 3;
        }
        if(isInCommunication())
            byte0 = 0;
        mStreamVolumeAlias[8] = byte0;
        if(flag) {
            mStreamStates[8].setAllIndexes(mStreamStates[byte0], false);
            mStreamStates[8].setAllIndexes(mStreamStates[byte0], true);
            sendMsg(mAudioHandler, 14, 2, 0, 0, mStreamStates[8], 0);
        }
    }

    private void waitForAudioHandlerCreation() {
        this;
        JVM INSTR monitorenter ;
_L2:
        AudioHandler audiohandler = mAudioHandler;
        Exception exception;
        if(audiohandler != null)
            break; /* Loop/switch isn't completed */
        try {
            wait();
        }
        catch(InterruptedException interruptedexception) {
            Log.e("AudioService", "Interrupted while waiting on volume handler.");
        }
        finally {
            this;
        }
        if(true) goto _L2; else goto _L1
_L1:
        if(false) goto _L4; else goto _L3
_L4:
        JVM INSTR monitorexit ;
        throw exception;
_L3:
        this;
        JVM INSTR monitorexit ;
    }

    public int abandonAudioFocus(IAudioFocusDispatcher iaudiofocusdispatcher, String s) {
        Log.i("AudioService", (new StringBuilder()).append(" AudioFocus  abandonAudioFocus() from ").append(s).toString());
        Object obj = mAudioFocusLock;
        obj;
        JVM INSTR monitorenter ;
        removeFocusStackEntry(s, true);
        break MISSING_BLOCK_LABEL_88;
        ConcurrentModificationException concurrentmodificationexception;
        concurrentmodificationexception;
        Log.e("AudioService", (new StringBuilder()).append("FATAL EXCEPTION AudioFocus  abandonAudioFocus() caused ").append(concurrentmodificationexception).toString());
        concurrentmodificationexception.printStackTrace();
        return 1;
    }

    public void adjustLocalOrRemoteStreamVolume(int i, int j) {
        if(!checkUpdateRemoteStateIfActive(3)) goto _L2; else goto _L1
_L1:
        adjustRemoteVolume(3, j, 0);
_L4:
        return;
_L2:
        if(AudioSystem.isStreamActive(3, 0))
            adjustStreamVolume(3, j, 0);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void adjustMasterVolume(int i, int j) {
        ensureValidSteps(i);
        int k = Math.round(100F * AudioSystem.getMasterVolume());
        int l = Math.abs(i);
        int i1;
        int j1;
        if(i > 0)
            i1 = 1;
        else
            i1 = -1;
        for(j1 = 0; j1 < l; j1++)
            k += findVolumeDelta(i1, k);

        setMasterVolume(k, j);
    }

    public void adjustStreamVolume(int i, int j, int k) {
        ensureValidDirection(j);
        ensureValidStreamType(i);
        int l = mStreamVolumeAlias[i];
        VolumeStreamState volumestreamstate = mStreamStates[l];
        int i1 = getDeviceForStream(l);
        boolean flag;
        int j1;
        boolean flag1;
        int k1;
        VolumeStreamState volumestreamstate1;
        boolean flag2;
        int l1;
        int i2;
        if(volumestreamstate.muteCount() != 0)
            flag = true;
        else
            flag = false;
        j1 = volumestreamstate.getIndex(i1, flag);
        flag1 = true;
        k1 = rescaleIndex(10, i, l);
        if((k & 2) != 0 || l == getMasterStreamType()) {
            if(getRingerMode() == 1)
                k &= 0xffffffef;
            flag1 = checkForRingerModeChange(j1, j, k1);
            if(l == getMasterStreamType() && mRingerMode == 0)
                volumestreamstate.setLastAudibleIndex(0, i1);
        }
        volumestreamstate1 = mStreamStates[i];
        if(mStreamStates[i].muteCount() != 0)
            flag2 = true;
        else
            flag2 = false;
        l1 = volumestreamstate1.getIndex(i1, flag2);
        if(volumestreamstate.muteCount() != 0) {
            if(flag1) {
                volumestreamstate.adjustLastAudibleIndex(j * k1, i1);
                sendMsg(mAudioHandler, 1, 2, 2, i1, volumestreamstate, 500);
            }
            i2 = mStreamStates[i].getIndex(i1, true);
        } else {
            if(flag1 && volumestreamstate.adjustIndex(j * k1, i1))
                sendMsg(mAudioHandler, 0, 2, i1, 0, volumestreamstate, 0);
            i2 = mStreamStates[i].getIndex(i1, false);
        }
        sendVolumeUpdate(i, l1, i2, k);
    }

    public void adjustSuggestedStreamVolume(int i, int j, int k) {
        int l;
        int i1;
        if(mVolumeControlStream != -1)
            l = mVolumeControlStream;
        else
            l = getActiveStreamType(j);
        if(l != -200 && (k & 4) != 0 && (mStreamVolumeAlias[l] != 2 || mKeyguardManager != null && mKeyguardManager.isKeyguardLocked()))
            k &= -5;
        i1 = adjustDirection(k, i);
        if(l == -200)
            adjustRemoteVolume(3, i1, k & -5);
        else
            adjustStreamVolume(l, i1, k);
    }

    public void adjustVolume(int i, int j) {
        adjustSuggestedStreamVolume(i, 0x80000000, j);
    }

    boolean checkAudioSettingsPermission(String s) {
        boolean flag;
        if(mContext.checkCallingOrSelfPermission("android.permission.MODIFY_AUDIO_SETTINGS") == 0) {
            flag = true;
        } else {
            Log.w("AudioService", (new StringBuilder()).append("Audio Settings Permission Denial: ").append(s).append(" from pid=").append(Binder.getCallingPid()).append(", uid=").append(Binder.getCallingUid()).toString());
            flag = false;
        }
        return flag;
    }

    public void clearAllScoClients(int i, boolean flag) {
        ArrayList arraylist = mScoClients;
        arraylist;
        JVM INSTR monitorenter ;
        ScoClient scoclient = null;
        int j = mScoClients.size();
        int k = 0;
        do {
            if(k < j) {
                ScoClient scoclient1 = (ScoClient)mScoClients.get(k);
                if(scoclient1.getPid() != i)
                    scoclient1.clearCount(flag);
                else
                    scoclient = scoclient1;
            } else {
                mScoClients.clear();
                if(scoclient != null)
                    mScoClients.add(scoclient);
                return;
            }
            k++;
        } while(true);
    }

    public void dispatchMediaKeyEvent(KeyEvent keyevent) {
        filterMediaKeyEvent(keyevent, false);
    }

    public void dispatchMediaKeyEventUnderWakelock(KeyEvent keyevent) {
        filterMediaKeyEvent(keyevent, true);
    }

    protected void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        mContext.enforceCallingOrSelfPermission("android.permission.DUMP", "AudioService");
        dumpFocusStack(printwriter);
        dumpRCStack(printwriter);
        dumpRCCStack(printwriter);
        dumpStreamStates(printwriter);
        printwriter.println("\nAudio routes:");
        printwriter.print("  mMainType=0x");
        printwriter.println(Integer.toHexString(mCurAudioRoutes.mMainType));
        printwriter.print("  mBluetoothName=");
        printwriter.println(mCurAudioRoutes.mBluetoothName);
    }

    public void forceVolumeControlStream(int i, IBinder ibinder) {
        Object obj = mForceControlStreamLock;
        obj;
        JVM INSTR monitorenter ;
        mVolumeControlStream = i;
        if(mVolumeControlStream == -1) {
            if(mForceControlStreamClient != null) {
                mForceControlStreamClient.release();
                mForceControlStreamClient = null;
            }
        } else {
            mForceControlStreamClient = new ForceControlStreamClient(ibinder);
        }
        return;
    }

    public int getLastAudibleMasterVolume() {
        return Math.round(100F * AudioSystem.getMasterVolume());
    }

    public int getLastAudibleStreamVolume(int i) {
        ensureValidStreamType(i);
        int j = getDeviceForStream(i);
        return (5 + mStreamStates[i].getIndex(j, true)) / 10;
    }

    public int getMasterMaxVolume() {
        return 100;
    }

    public int getMasterStreamType() {
        byte byte0;
        if(mVoiceCapable)
            byte0 = 2;
        else
            byte0 = 3;
        return byte0;
    }

    public int getMasterVolume() {
        int i;
        if(isMasterMute())
            i = 0;
        else
            i = getLastAudibleMasterVolume();
        return i;
    }

    public int getMode() {
        return mMode;
    }

    public int getRemoteStreamMaxVolume() {
        RemotePlaybackState remoteplaybackstate = mMainRemote;
        remoteplaybackstate;
        JVM INSTR monitorenter ;
        int i;
        if(mMainRemote.mRccId == -1)
            i = 0;
        else
            i = mMainRemote.mVolumeMax;
        return i;
    }

    public int getRemoteStreamVolume() {
        RemotePlaybackState remoteplaybackstate = mMainRemote;
        remoteplaybackstate;
        JVM INSTR monitorenter ;
        int i;
        if(mMainRemote.mRccId == -1)
            i = 0;
        else
            i = mMainRemote.mVolume;
        return i;
    }

    public int getRingerMode() {
        Object obj = mSettingsLock;
        obj;
        JVM INSTR monitorenter ;
        int i = mRingerMode;
        return i;
    }

    public IRingtonePlayer getRingtonePlayer() {
        return mRingtonePlayer;
    }

    public int getStreamMaxVolume(int i) {
        ensureValidStreamType(i);
        return (5 + mStreamStates[i].getMaxIndex()) / 10;
    }

    public int getStreamVolume(int i) {
        ensureValidStreamType(i);
        int j = getDeviceForStream(i);
        return (5 + mStreamStates[i].getIndex(j, false)) / 10;
    }

    public int getVibrateSetting(int i) {
        int j;
        if(!mHasVibrator)
            j = 0;
        else
            j = 3 & mVibrateSetting >> i * 2;
        return j;
    }

    public boolean isBluetoothA2dpOn() {
        Object obj = mBluetoothA2dpEnabledLock;
        obj;
        JVM INSTR monitorenter ;
        boolean flag = mBluetoothA2dpEnabled;
        return flag;
    }

    public boolean isBluetoothScoOn() {
        boolean flag;
        if(mForcedUseForComm == 3)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isMasterMute() {
        return AudioSystem.getMasterMute();
    }

    public boolean isSpeakerphoneOn() {
        boolean flag = true;
        if(mForcedUseForComm != flag)
            flag = false;
        return flag;
    }

    public boolean isStreamAffectedByMute(int i) {
        boolean flag = true;
        if((mMuteAffectedStreams & flag << i) == 0)
            flag = false;
        return flag;
    }

    public boolean isStreamAffectedByRingerMode(int i) {
        boolean flag = true;
        if((mRingerModeAffectedStreams & flag << i) == 0)
            flag = false;
        return flag;
    }

    public boolean isStreamMute(int i) {
        boolean flag;
        if(mStreamStates[i].muteCount() != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean loadSoundEffects() {
        Object obj = mSoundEffectsLock;
        obj;
        JVM INSTR monitorenter ;
        if(mBootCompleted) goto _L2; else goto _L1
_L1:
        boolean flag;
        Log.w("AudioService", "loadSoundEffects() called before boot complete");
        flag = false;
          goto _L3
_L2:
        if(mSoundPool == null) goto _L5; else goto _L4
_L4:
        flag = true;
          goto _L3
        Exception exception;
        exception;
        throw exception;
_L5:
        mSoundPool = new SoundPool(4, 1, 0);
        try {
            mSoundPoolCallBack = null;
            mSoundPoolListenerThread = new SoundPoolListenerThread();
            mSoundPoolListenerThread.start();
            mSoundEffectsLock.wait();
        }
        catch(InterruptedException interruptedexception) {
            Log.w("AudioService", "Interrupted while waiting sound pool listener thread.");
        }
        if(mSoundPoolCallBack != null) goto _L7; else goto _L6
_L6:
        Log.w("AudioService", "loadSoundEffects() could not create SoundPool listener or thread");
        if(mSoundPoolLooper != null) {
            mSoundPoolLooper.quit();
            mSoundPoolLooper = null;
        }
        mSoundPoolListenerThread = null;
        mSoundPool.release();
        mSoundPool = null;
        flag = false;
        obj;
        JVM INSTR monitorexit ;
          goto _L3
_L7:
        int ai[];
        ai = new int[SOUND_EFFECT_FILES.length];
        for(int i = 0; i < SOUND_EFFECT_FILES.length; i++)
            ai[i] = -1;

          goto _L8
_L20:
        int k;
        if(k >= 9) goto _L10; else goto _L9
_L9:
        int j;
        if(SOUND_EFFECT_FILES_MAP[k][1] != 0)
            if(ai[SOUND_EFFECT_FILES_MAP[k][0]] == -1) {
                String s = (new StringBuilder()).append(Environment.getRootDirectory()).append("/media/audio/ui/").append(SOUND_EFFECT_FILES[SOUND_EFFECT_FILES_MAP[k][0]]).toString();
                int l1 = mSoundPool.load(s, 0);
                if(l1 <= 0) {
                    Log.w("AudioService", (new StringBuilder()).append("Soundpool could not load file: ").append(s).toString());
                } else {
                    SOUND_EFFECT_FILES_MAP[k][1] = l1;
                    ai[SOUND_EFFECT_FILES_MAP[k][0]] = l1;
                    j = l1;
                }
            } else {
                SOUND_EFFECT_FILES_MAP[k][1] = ai[SOUND_EFFECT_FILES_MAP[k][0]];
            }
          goto _L11
_L10:
        if(j == 0) goto _L13; else goto _L12
_L12:
        mSoundPoolCallBack.setLastSample(j);
        int k1;
        mSoundEffectsLock.wait();
        k1 = mSoundPoolCallBack.status();
        int l = k1;
_L19:
        if(mSoundPoolLooper != null) {
            mSoundPoolLooper.quit();
            mSoundPoolLooper = null;
        }
        mSoundPoolListenerThread = null;
        if(l == 0) goto _L15; else goto _L14
_L14:
        StringBuilder stringbuilder;
        int i1;
        stringbuilder = (new StringBuilder()).append("loadSoundEffects(), Error ");
        if(j == 0)
            break MISSING_BLOCK_LABEL_610;
        i1 = mSoundPoolCallBack.status();
_L22:
        int j1;
        Log.w("AudioService", stringbuilder.append(i1).append(" while loading samples").toString());
        j1 = 0;
_L21:
        if(j1 >= 9) goto _L17; else goto _L16
_L16:
        if(SOUND_EFFECT_FILES_MAP[j1][1] > 0)
            SOUND_EFFECT_FILES_MAP[j1][1] = -1;
          goto _L18
        InterruptedException interruptedexception1;
        interruptedexception1;
        Log.w("AudioService", "Interrupted while waiting sound pool callback.");
        l = -1;
          goto _L19
_L17:
        mSoundPool.release();
        mSoundPool = null;
_L15:
        obj;
        JVM INSTR monitorexit ;
        if(l == 0)
            flag = true;
        else
            flag = false;
_L3:
        return flag;
_L8:
        j = 0;
        k = 0;
          goto _L20
_L11:
        k++;
          goto _L20
_L18:
        j1++;
          goto _L21
_L13:
        l = -1;
          goto _L19
        i1 = -1;
          goto _L22
    }

    public void onSendFinished(PendingIntent pendingintent, Intent intent, int i, String s, Bundle bundle) {
        if(i == 1980)
            mMediaEventWakeLock.release();
    }

    public void playSoundEffect(int i) {
        sendMsg(mAudioHandler, 6, 1, i, -1, null, 0);
    }

    public void playSoundEffectVolume(int i, float f) {
        loadSoundEffects();
        sendMsg(mAudioHandler, 6, 1, i, (int)(1000F * f), null, 0);
    }

    public void registerMediaButtonEventReceiverForCalls(ComponentName componentname) {
        if(mContext.checkCallingPermission("android.permission.MODIFY_PHONE_STATE") == 0) goto _L2; else goto _L1
_L1:
        Log.e("AudioService", "Invalid permissions to register media button receiver for calls");
_L4:
        return;
_L2:
        Stack stack = mRCStack;
        stack;
        JVM INSTR monitorenter ;
        mMediaReceiverForCalls = componentname;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void registerMediaButtonIntent(PendingIntent pendingintent, ComponentName componentname) {
        Log.i("AudioService", (new StringBuilder()).append("  Remote Control   registerMediaButtonIntent() for ").append(pendingintent).toString());
        Object obj = mAudioFocusLock;
        obj;
        JVM INSTR monitorenter ;
        synchronized(mRCStack) {
            pushMediaButtonReceiver(pendingintent, componentname);
            checkUpdateRemoteControlDisplay_syncAfRcs(15);
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        exception1;
        stack;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        throw exception;
    }

    public int registerRemoteControlClient(PendingIntent pendingintent, IRemoteControlClient iremotecontrolclient, String s) {
        int i = -1;
        Object obj = mAudioFocusLock;
        obj;
        JVM INSTR monitorenter ;
        Stack stack = mRCStack;
        stack;
        JVM INSTR monitorenter ;
        Iterator iterator = mRCStack.iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        RemoteControlStackEntry remotecontrolstackentry = (RemoteControlStackEntry)iterator.next();
        if(!remotecontrolstackentry.mMediaIntent.equals(pendingintent)) goto _L4; else goto _L3
_L3:
        if(remotecontrolstackentry.mRcClientDeathHandler != null)
            remotecontrolstackentry.unlinkToRcClientDeath();
        remotecontrolstackentry.mRcClient = iremotecontrolclient;
        remotecontrolstackentry.mCallingPackageName = s;
        remotecontrolstackentry.mCallingUid = Binder.getCallingUid();
        if(iremotecontrolclient != null) goto _L6; else goto _L5
_L5:
        remotecontrolstackentry.resetPlaybackInfo();
_L2:
        if(isCurrentRcController(pendingintent))
            checkUpdateRemoteControlDisplay_syncAfRcs(15);
        obj;
        JVM INSTR monitorexit ;
        return i;
_L6:
        IRemoteControlDisplay iremotecontroldisplay;
        i = remotecontrolstackentry.mRccId;
        iremotecontroldisplay = mRcDisplay;
        if(iremotecontroldisplay == null)
            break MISSING_BLOCK_LABEL_161;
        remotecontrolstackentry.mRcClient.plugRemoteControlDisplay(mRcDisplay);
_L7:
        IBinder ibinder;
        RcClientDeathHandler rcclientdeathhandler;
        ibinder = remotecontrolstackentry.mRcClient.asBinder();
        rcclientdeathhandler = new RcClientDeathHandler(ibinder, remotecontrolstackentry.mMediaIntent);
        Exception exception;
        Exception exception1;
        RemoteException remoteexception1;
        try {
            ibinder.linkToDeath(rcclientdeathhandler, 0);
        }
        catch(RemoteException remoteexception) {
            Log.w("AudioService", (new StringBuilder()).append("registerRemoteControlClient() has a dead client ").append(ibinder).toString());
            remotecontrolstackentry.mRcClient = null;
        }
        remotecontrolstackentry.mRcClientDeathHandler = rcclientdeathhandler;
          goto _L2
        exception1;
        throw exception1;
        exception;
        throw exception;
        remoteexception1;
        Log.e("AudioService", (new StringBuilder()).append("Error connecting remote control display to client: ").append(remoteexception1).toString());
        remoteexception1.printStackTrace();
          goto _L7
    }

    public void registerRemoteControlDisplay(IRemoteControlDisplay iremotecontroldisplay) {
        Object obj = mAudioFocusLock;
        obj;
        JVM INSTR monitorenter ;
        Stack stack = mRCStack;
        stack;
        JVM INSTR monitorenter ;
        if(mRcDisplay != iremotecontroldisplay && iremotecontroldisplay != null) goto _L2; else goto _L1
_L1:
        obj;
        JVM INSTR monitorexit ;
_L3:
        return;
_L2:
        Exception exception1;
        rcDisplay_stopDeathMonitor_syncRcStack();
        mRcDisplay = iremotecontroldisplay;
        rcDisplay_startDeathMonitor_syncRcStack();
        Iterator iterator = mRCStack.iterator();
        do {
            RemoteControlStackEntry remotecontrolstackentry;
            IRemoteControlClient iremotecontrolclient;
            do {
                if(!iterator.hasNext())
                    break MISSING_BLOCK_LABEL_156;
                remotecontrolstackentry = (RemoteControlStackEntry)iterator.next();
                iremotecontrolclient = remotecontrolstackentry.mRcClient;
            } while(iremotecontrolclient == null);
            try {
                remotecontrolstackentry.mRcClient.plugRemoteControlDisplay(mRcDisplay);
            }
            catch(RemoteException remoteexception) {
                Log.e("AudioService", (new StringBuilder()).append("Error connecting remote control display to client: ").append(remoteexception).toString());
                remoteexception.printStackTrace();
            }
            finally {
                stack;
            }
        } while(true);
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        throw exception;
        checkUpdateRemoteControlDisplay_syncAfRcs(15);
        stack;
        JVM INSTR monitorexit ;
        obj;
        JVM INSTR monitorexit ;
          goto _L3
    }

    public void registerRemoteVolumeObserverForRcc(int i, IRemoteVolumeObserver iremotevolumeobserver) {
        sendMsg(mAudioHandler, 19, 2, i, 0, iremotevolumeobserver, 0);
    }

    public void reloadAudioSettings() {
        int i;
        int j;
        readPersistedSettings();
        i = AudioSystem.getNumStreamTypes();
        j = 0;
_L2:
        if(j >= i)
            break; /* Loop/switch isn't completed */
        VolumeStreamState volumestreamstate = mStreamStates[j];
        volumestreamstate;
        JVM INSTR monitorenter ;
        volumestreamstate.readSettings();
        if(volumestreamstate.muteCount() != 0 && !isStreamAffectedByMute(j)) {
            int k = volumestreamstate.mDeathHandlers.size();
            for(int l = 0; l < k; l++) {
                ((VolumeStreamState.VolumeDeathHandler)volumestreamstate.mDeathHandlers.get(l)).mMuteCount = 1;
                ((VolumeStreamState.VolumeDeathHandler)volumestreamstate.mDeathHandlers.get(l)).mute(false);
            }

        }
        j++;
        if(true) goto _L2; else goto _L1
_L1:
        checkAllAliasStreamVolumes();
        setRingerModeInt(getRingerMode(), false);
        return;
    }

    public void remoteControlDisplayUsesBitmapSize(IRemoteControlDisplay iremotecontroldisplay, int i, int j) {
        Stack stack = mRCStack;
        stack;
        JVM INSTR monitorenter ;
        mArtworkExpectedWidth = i;
        mArtworkExpectedHeight = j;
        return;
    }

    public int requestAudioFocus(int i, int j, IBinder ibinder, IAudioFocusDispatcher iaudiofocusdispatcher, String s, String s1) {
        Log.i("AudioService", (new StringBuilder()).append(" AudioFocus  requestAudioFocus() from ").append(s).toString());
        if(ibinder.pingBinder()) goto _L2; else goto _L1
_L1:
        int k;
        Log.e("AudioService", " AudioFocus DOA client for requestAudioFocus(), aborting.");
        k = 0;
_L3:
        return k;
_L2:
        Object obj = mAudioFocusLock;
        obj;
        JVM INSTR monitorenter ;
        if(canReassignAudioFocus())
            break MISSING_BLOCK_LABEL_83;
        k = 0;
          goto _L3
        Exception exception;
        exception;
        throw exception;
        AudioFocusDeathHandler audiofocusdeathhandler = new AudioFocusDeathHandler(ibinder);
        ibinder.linkToDeath(audiofocusdeathhandler, 0);
        if(mFocusStack.empty() || !((FocusStackEntry)mFocusStack.peek()).mClientId.equals(s))
            break MISSING_BLOCK_LABEL_226;
        if(((FocusStackEntry)mFocusStack.peek()).mFocusChangeType != j) goto _L5; else goto _L4
_L4:
        ibinder.unlinkToDeath(audiofocusdeathhandler, 0);
        k = 1;
        obj;
        JVM INSTR monitorexit ;
          goto _L3
        RemoteException remoteexception;
        remoteexception;
        Log.w("AudioService", (new StringBuilder()).append("AudioFocus  requestAudioFocus() could not link to ").append(ibinder).append(" binder death").toString());
        k = 0;
        obj;
        JVM INSTR monitorexit ;
          goto _L3
_L5:
        ((FocusStackEntry)mFocusStack.pop()).unlinkToDeath();
        IAudioFocusDispatcher iaudiofocusdispatcher1;
        if(mFocusStack.empty())
            break MISSING_BLOCK_LABEL_291;
        iaudiofocusdispatcher1 = ((FocusStackEntry)mFocusStack.peek()).mFocusDispatcher;
        if(iaudiofocusdispatcher1 == null)
            break MISSING_BLOCK_LABEL_291;
        try {
            ((FocusStackEntry)mFocusStack.peek()).mFocusDispatcher.dispatchAudioFocusChange(j * -1, ((FocusStackEntry)mFocusStack.peek()).mClientId);
        }
        catch(RemoteException remoteexception1) {
            Log.e("AudioService", (new StringBuilder()).append(" Failure to signal loss of focus due to ").append(remoteexception1).toString());
            remoteexception1.printStackTrace();
        }
        removeFocusStackEntry(s, false);
        mFocusStack.push(new FocusStackEntry(i, j, iaudiofocusdispatcher, ibinder, s, audiofocusdeathhandler, s1, Binder.getCallingUid()));
        synchronized(mRCStack) {
            checkUpdateRemoteControlDisplay_syncAfRcs(15);
        }
        obj;
        JVM INSTR monitorexit ;
        k = 1;
          goto _L3
        exception1;
        stack;
        JVM INSTR monitorexit ;
        throw exception1;
          goto _L3
    }

    public int setBluetoothA2dpDeviceConnectionState(BluetoothDevice bluetoothdevice, int i) {
        int j = 0;
        HashMap hashmap = mConnectedDevices;
        hashmap;
        JVM INSTR monitorenter ;
        if(i == 2)
            j = 1;
        int k = checkSendBecomingNoisyIntent(128, j);
        queueMsgUnderWakeLock(mAudioHandler, 21, i, 0, bluetoothdevice, k);
        return k;
    }

    public void setBluetoothA2dpOn(boolean flag) {
        setBluetoothA2dpOnInt(flag);
    }

    public void setBluetoothA2dpOnInt(boolean flag) {
        int i = 0;
        Object obj = mBluetoothA2dpEnabledLock;
        obj;
        JVM INSTR monitorenter ;
        mBluetoothA2dpEnabled = flag;
        AudioHandler audiohandler = mAudioHandler;
        if(!mBluetoothA2dpEnabled)
            i = 10;
        sendMsg(audiohandler, 9, 2, 1, i, null, 0);
        return;
    }

    public void setBluetoothScoOn(boolean flag) {
        if(checkAudioSettingsPermission("setBluetoothScoOn()")) {
            int i;
            if(flag)
                i = 3;
            else
                i = 0;
            mForcedUseForComm = i;
            sendMsg(mAudioHandler, 9, 2, 0, mForcedUseForComm, null, 0);
            sendMsg(mAudioHandler, 9, 2, 2, mForcedUseForComm, null, 0);
        }
    }

    public void setMasterMute(boolean flag, int i, IBinder ibinder) {
        if(flag != AudioSystem.getMasterMute()) {
            AudioSystem.setMasterMute(flag);
            AudioHandler audiohandler = mAudioHandler;
            int j;
            if(flag)
                j = 1;
            else
                j = 0;
            sendMsg(audiohandler, 15, 0, j, 0, null, 500);
            sendMasterMuteUpdate(flag, i);
        }
    }

    public void setMasterVolume(int i, int j) {
        if(i >= 0) goto _L2; else goto _L1
_L1:
        i = 0;
_L4:
        doSetMasterVolume((float)i / 100F, j);
        return;
_L2:
        if(i > 100)
            i = 100;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void setMode(int i, IBinder ibinder) {
_L2:
        return;
        if(!checkAudioSettingsPermission("setMode()") || i < -1 || i >= 4) goto _L2; else goto _L1
_L1:
        ArrayList arraylist = mSetModeDeathHandlers;
        arraylist;
        JVM INSTR monitorenter ;
        if(i != -1)
            break MISSING_BLOCK_LABEL_40;
        i = mMode;
        int j = setModeInt(i, ibinder, Binder.getCallingPid());
        arraylist;
        JVM INSTR monitorexit ;
        if(j != 0)
            disconnectBluetoothSco(j);
        if(true) goto _L2; else goto _L3
_L3:
        Exception exception;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    int setModeInt(int i, IBinder ibinder, int j) {
        int k = 0;
        if(ibinder != null) goto _L2; else goto _L1
_L1:
        int j1;
        Log.e("AudioService", "setModeInt() called with null binder");
        j1 = 0;
_L4:
        return j1;
_L2:
        SetModeDeathHandler setmodedeathhandler = null;
        Iterator iterator = mSetModeDeathHandlers.iterator();
        do {
            if(!iterator.hasNext())
                break;
            SetModeDeathHandler setmodedeathhandler1 = (SetModeDeathHandler)iterator.next();
            if(setmodedeathhandler1.getPid() != j)
                continue;
            setmodedeathhandler = setmodedeathhandler1;
            iterator.remove();
            setmodedeathhandler.getBinder().unlinkToDeath(setmodedeathhandler, 0);
            break;
        } while(true);
        do {
            int l;
            int i1;
            if(i == 0) {
                if(!mSetModeDeathHandlers.isEmpty()) {
                    setmodedeathhandler = (SetModeDeathHandler)mSetModeDeathHandlers.get(0);
                    ibinder = setmodedeathhandler.getBinder();
                    i = setmodedeathhandler.getMode();
                }
            } else {
                if(setmodedeathhandler == null)
                    setmodedeathhandler = new SetModeDeathHandler(ibinder, j);
                try {
                    ibinder.linkToDeath(setmodedeathhandler, 0);
                }
                catch(RemoteException remoteexception) {
                    Log.w("AudioService", (new StringBuilder()).append("setMode() could not link to ").append(ibinder).append(" binder death").toString());
                }
                mSetModeDeathHandlers.add(0, setmodedeathhandler);
                setmodedeathhandler.setMode(i);
            }
            l = mMode;
            if(i != l) {
                i1 = AudioSystem.setPhoneState(i);
                int k1;
                int l1;
                int i2;
                if(i1 == 0) {
                    mMode = i;
                } else {
                    if(setmodedeathhandler != null) {
                        mSetModeDeathHandlers.remove(setmodedeathhandler);
                        ibinder.unlinkToDeath(setmodedeathhandler, 0);
                    }
                    i = 0;
                }
            } else {
                i1 = 0;
            }
        } while(i1 != 0 && !mSetModeDeathHandlers.isEmpty());
        if(i1 == 0) {
            if(i != 0)
                if(mSetModeDeathHandlers.isEmpty())
                    Log.e("AudioService", "setMode() different from MODE_NORMAL with empty mode client stack");
                else
                    k = ((SetModeDeathHandler)mSetModeDeathHandlers.get(0)).getPid();
            k1 = getActiveStreamType(0x80000000);
            if(k1 == -200)
                k1 = 3;
            l1 = getDeviceForStream(k1);
            i2 = mStreamStates[mStreamVolumeAlias[k1]].getIndex(l1, false);
            setStreamVolumeInt(mStreamVolumeAlias[k1], i2, l1, true, false);
            updateStreamVolumeAlias(true);
        }
        j1 = k;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void setPlaybackInfoForRcc(int i, int j, int k) {
        sendMsg(mAudioHandler, 18, 2, i, j, Integer.valueOf(k), 0);
    }

    public void setRemoteStreamVolume(int i) {
        int j;
        synchronized(mMainRemote) {
            if(mMainRemote.mRccId == -1)
                break MISSING_BLOCK_LABEL_144;
            j = mMainRemote.mRccId;
        }
        IRemoteVolumeObserver iremotevolumeobserver = null;
        synchronized(mRCStack) {
            Iterator iterator = mRCStack.iterator();
            do {
                if(!iterator.hasNext())
                    break;
                RemoteControlStackEntry remotecontrolstackentry = (RemoteControlStackEntry)iterator.next();
                if(remotecontrolstackentry.mRccId != j)
                    continue;
                iremotevolumeobserver = remotecontrolstackentry.mRemoteVolumeObs;
                break;
            } while(true);
        }
        if(iremotevolumeobserver != null)
            try {
                iremotevolumeobserver.dispatchRemoteVolumeUpdate(0, i);
            }
            catch(RemoteException remoteexception) {
                Log.e("AudioService", "Error dispatching absolute volume update", remoteexception);
            }
          goto _L1
        exception;
        remoteplaybackstate;
        JVM INSTR monitorexit ;
        throw exception;
        exception1;
        stack;
        JVM INSTR monitorexit ;
        throw exception1;
_L1:
    }

    public void setRingerMode(int i) {
        if(i == 1 && !mHasVibrator)
            i = 0;
        if(i != getRingerMode()) {
            setRingerModeInt(i, true);
            broadcastRingerMode(i);
        }
    }

    public void setRingtonePlayer(IRingtonePlayer iringtoneplayer) {
        mContext.enforceCallingOrSelfPermission("android.permission.REMOTE_AUDIO_PLAYBACK", null);
        mRingtonePlayer = iringtoneplayer;
    }

    public void setSpeakerphoneOn(boolean flag) {
        if(checkAudioSettingsPermission("setSpeakerphoneOn()")) {
            int i;
            if(flag)
                i = 1;
            else
                i = 0;
            mForcedUseForComm = i;
            sendMsg(mAudioHandler, 9, 2, 0, mForcedUseForComm, null, 0);
        }
    }

    public void setStreamMute(int i, boolean flag, IBinder ibinder) {
        if(isStreamAffectedByMute(i))
            mStreamStates[i].mute(ibinder, flag);
    }

    public void setStreamSolo(int i, boolean flag, IBinder ibinder) {
        int j = 0;
        while(j < mStreamStates.length)  {
            if(isStreamAffectedByMute(j) && j != i)
                mStreamStates[j].mute(ibinder, flag);
            j++;
        }
    }

    public void setStreamVolume(int i, int j, int k) {
        boolean flag = true;
        ensureValidStreamType(i);
        VolumeStreamState volumestreamstate = mStreamStates[mStreamVolumeAlias[i]];
        int l = getDeviceForStream(i);
        boolean flag1;
        int i1;
        int j1;
        if(volumestreamstate.muteCount() != 0)
            flag1 = flag;
        else
            flag1 = false;
        i1 = volumestreamstate.getIndex(l, flag1);
        j1 = rescaleIndex(j * 10, i, mStreamVolumeAlias[i]);
        if((k & 2) != 0 || mStreamVolumeAlias[i] == getMasterStreamType()) {
            int k1;
            if(j1 == 0) {
                VolumeStreamState volumestreamstate1;
                if(mHasVibrator)
                    k1 = ((flag) ? 1 : 0);
                else
                    k1 = 0;
                setStreamVolumeInt(mStreamVolumeAlias[i], j1, l, false, flag);
            } else {
                k1 = 2;
            }
            setRingerMode(k1);
        }
        setStreamVolumeInt(mStreamVolumeAlias[i], j1, l, false, flag);
        volumestreamstate1 = mStreamStates[i];
        if(mStreamStates[i].muteCount() == 0)
            flag = false;
        sendVolumeUpdate(i, i1, volumestreamstate1.getIndex(l, flag), k);
    }

    public void setVibrateSetting(int i, int j) {
        if(mHasVibrator) {
            mVibrateSetting = getValueForVibrateSetting(mVibrateSetting, i, j);
            broadcastVibrateSetting(i);
        }
    }

    public void setWiredDeviceConnectionState(int i, int j, String s) {
        HashMap hashmap = mConnectedDevices;
        hashmap;
        JVM INSTR monitorenter ;
        int k = checkSendBecomingNoisyIntent(i, j);
        queueMsgUnderWakeLock(mAudioHandler, 20, i, j, s, k);
        return;
    }

    public boolean shouldVibrate(int i) {
        int j;
        int k;
        j = 1;
        k = 0;
        if(mHasVibrator) goto _L2; else goto _L1
_L1:
        return k;
_L2:
        switch(getVibrateSetting(i)) {
        case 1: // '\001'
            if(getRingerMode() == 0)
                j = 0;
            k = j;
            break;

        case 2: // '\002'
            if(getRingerMode() != j)
                j = 0;
            k = j;
            break;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void startBluetoothSco(IBinder ibinder) {
        if(checkAudioSettingsPermission("startBluetoothSco()") && mBootCompleted)
            getScoClient(ibinder, true).incCount();
    }

    public AudioRoutesInfo startWatchingRoutes(IAudioRoutesObserver iaudioroutesobserver) {
        AudioRoutesInfo audioroutesinfo = mCurAudioRoutes;
        audioroutesinfo;
        JVM INSTR monitorenter ;
        AudioRoutesInfo audioroutesinfo1 = new AudioRoutesInfo(mCurAudioRoutes);
        mRoutesObservers.register(iaudioroutesobserver);
        return audioroutesinfo1;
    }

    public void stopBluetoothSco(IBinder ibinder) {
        if(checkAudioSettingsPermission("stopBluetoothSco()") && mBootCompleted) goto _L2; else goto _L1
_L1:
        return;
_L2:
        ScoClient scoclient = getScoClient(ibinder, false);
        if(scoclient != null)
            scoclient.decCount();
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void unloadSoundEffects() {
        Object obj = mSoundEffectsLock;
        obj;
        JVM INSTR monitorenter ;
        int j;
        if(mSoundPool != null) {
            mAudioHandler.removeMessages(8);
            mAudioHandler.removeMessages(6);
            int ai[] = new int[SOUND_EFFECT_FILES.length];
            Exception exception;
            for(int i = 0; i < SOUND_EFFECT_FILES.length; i++)
                ai[i] = 0;

            j = 0;
            continue; /* Loop/switch isn't completed */
        }
          goto _L1
_L3:
        if(j < 9) {
            if(SOUND_EFFECT_FILES_MAP[j][1] > 0 && ai[SOUND_EFFECT_FILES_MAP[j][0]] == 0) {
                mSoundPool.unload(SOUND_EFFECT_FILES_MAP[j][1]);
                SOUND_EFFECT_FILES_MAP[j][1] = -1;
                ai[SOUND_EFFECT_FILES_MAP[j][0]] = -1;
            }
            j++;
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_152;
        exception;
        throw exception;
        mSoundPool.release();
        mSoundPool = null;
        obj;
        JVM INSTR monitorexit ;
_L1:
        return;
        if(true) goto _L3; else goto _L2
_L2:
    }

    public void unregisterAudioFocusClient(String s) {
        Object obj = mAudioFocusLock;
        obj;
        JVM INSTR monitorenter ;
        removeFocusStackEntry(s, false);
        return;
    }

    public void unregisterMediaButtonEventReceiverForCalls() {
        if(mContext.checkCallingPermission("android.permission.MODIFY_PHONE_STATE") == 0) goto _L2; else goto _L1
_L1:
        Log.e("AudioService", "Invalid permissions to unregister media button receiver for calls");
_L4:
        return;
_L2:
        Stack stack = mRCStack;
        stack;
        JVM INSTR monitorenter ;
        mMediaReceiverForCalls = null;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void unregisterMediaButtonIntent(PendingIntent pendingintent, ComponentName componentname) {
        Log.i("AudioService", (new StringBuilder()).append("  Remote Control   unregisterMediaButtonIntent() for ").append(pendingintent).toString());
        Object obj = mAudioFocusLock;
        obj;
        JVM INSTR monitorenter ;
        synchronized(mRCStack) {
            boolean flag = isCurrentRcController(pendingintent);
            removeMediaButtonReceiver(pendingintent);
            if(flag)
                checkUpdateRemoteControlDisplay_syncAfRcs(15);
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        exception1;
        stack;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        throw exception;
    }

    public void unregisterRemoteControlClient(PendingIntent pendingintent, IRemoteControlClient iremotecontrolclient) {
        Object obj = mAudioFocusLock;
        obj;
        JVM INSTR monitorenter ;
        Stack stack = mRCStack;
        stack;
        JVM INSTR monitorenter ;
        Iterator iterator = mRCStack.iterator();
        do {
            if(!iterator.hasNext())
                break;
            RemoteControlStackEntry remotecontrolstackentry = (RemoteControlStackEntry)iterator.next();
            if(remotecontrolstackentry.mMediaIntent.equals(pendingintent) && iremotecontrolclient.equals(remotecontrolstackentry.mRcClient)) {
                remotecontrolstackentry.unlinkToRcClientDeath();
                remotecontrolstackentry.mRcClient = null;
                remotecontrolstackentry.mCallingPackageName = null;
            }
        } while(true);
        break MISSING_BLOCK_LABEL_105;
        Exception exception1;
        exception1;
        throw exception1;
        Exception exception;
        exception;
        throw exception;
        stack;
        JVM INSTR monitorexit ;
        obj;
        JVM INSTR monitorexit ;
    }

    public void unregisterRemoteControlDisplay(IRemoteControlDisplay iremotecontroldisplay) {
        Stack stack = mRCStack;
        stack;
        JVM INSTR monitorenter ;
        if(iremotecontroldisplay == null) goto _L2; else goto _L1
_L1:
        if(iremotecontroldisplay == mRcDisplay) goto _L3; else goto _L2
_L2:
        stack;
        JVM INSTR monitorexit ;
          goto _L4
_L3:
        Iterator iterator;
        rcDisplay_stopDeathMonitor_syncRcStack();
        mRcDisplay = null;
        iterator = mRCStack.iterator();
_L8:
        if(!iterator.hasNext()) goto _L6; else goto _L5
_L5:
        RemoteControlStackEntry remotecontrolstackentry;
        IRemoteControlClient iremotecontrolclient;
        remotecontrolstackentry = (RemoteControlStackEntry)iterator.next();
        iremotecontrolclient = remotecontrolstackentry.mRcClient;
        if(iremotecontrolclient == null) goto _L8; else goto _L7
_L7:
        Exception exception;
        try {
            remotecontrolstackentry.mRcClient.unplugRemoteControlDisplay(iremotecontroldisplay);
        }
        catch(RemoteException remoteexception) {
            Log.e("AudioService", (new StringBuilder()).append("Error disconnecting remote control display to client: ").append(remoteexception).toString());
            remoteexception.printStackTrace();
        }
        finally {
            stack;
        }
        if(true) goto _L8; else goto _L9
_L9:
        JVM INSTR monitorexit ;
        throw exception;
_L6:
        stack;
        JVM INSTR monitorexit ;
_L4:
    }

    private static final int BTA2DP_DOCK_TIMEOUT_MILLIS = 8000;
    private static final int BT_HEADSET_CNCT_TIMEOUT_MS = 3000;
    protected static final boolean DEBUG_RC = false;
    protected static final boolean DEBUG_VOL = false;
    private static final String EXTRA_WAKELOCK_ACQUIRED = "android.media.AudioService.WAKELOCK_ACQUIRED";
    public static final String IN_VOICE_COMM_FOCUS_ID = "AudioFocus_For_Phone_Ring_And_Calls";
    private static final int MAX_BATCH_VOLUME_ADJUST_STEPS = 4;
    private static final int MAX_MASTER_VOLUME = 100;
    private static final int MSG_BTA2DP_DOCK_TIMEOUT = 7;
    private static final int MSG_BT_HEADSET_CNCT_FAILED = 11;
    private static final int MSG_LOAD_SOUND_EFFECTS = 8;
    private static final int MSG_MEDIA_SERVER_DIED = 4;
    private static final int MSG_MEDIA_SERVER_STARTED = 5;
    private static final int MSG_PERSIST_MASTER_VOLUME = 2;
    private static final int MSG_PERSIST_MASTER_VOLUME_MUTE = 15;
    private static final int MSG_PERSIST_MEDIABUTTONRECEIVER = 10;
    private static final int MSG_PERSIST_RINGER_MODE = 3;
    private static final int MSG_PERSIST_VOLUME = 1;
    private static final int MSG_PLAY_SOUND_EFFECT = 6;
    private static final int MSG_RCC_NEW_PLAYBACK_INFO = 18;
    private static final int MSG_RCC_NEW_VOLUME_OBS = 19;
    private static final int MSG_RCDISPLAY_CLEAR = 12;
    private static final int MSG_RCDISPLAY_UPDATE = 13;
    private static final int MSG_REEVALUATE_REMOTE = 17;
    private static final int MSG_REPORT_NEW_ROUTES = 16;
    private static final int MSG_SET_A2DP_CONNECTION_STATE = 21;
    private static final int MSG_SET_ALL_VOLUMES = 14;
    private static final int MSG_SET_DEVICE_VOLUME = 0;
    private static final int MSG_SET_FORCE_USE = 9;
    private static final int MSG_SET_WIRED_DEVICE_CONNECTION_STATE = 20;
    private static final int NOTIFICATION_VOLUME_DELAY_MS = 5000;
    private static final int NUM_SOUNDPOOL_CHANNELS = 4;
    private static final int PERSIST_CURRENT = 1;
    private static final int PERSIST_DELAY = 500;
    private static final int PERSIST_LAST_AUDIBLE = 2;
    private static final int RC_INFO_ALL = 15;
    private static final int RC_INFO_NONE = 0;
    private static final int SCO_STATE_ACTIVATE_REQ = 1;
    private static final int SCO_STATE_ACTIVE_EXTERNAL = 2;
    private static final int SCO_STATE_ACTIVE_INTERNAL = 3;
    private static final int SCO_STATE_DEACTIVATE_EXT_REQ = 4;
    private static final int SCO_STATE_DEACTIVATE_REQ = 5;
    private static final int SCO_STATE_INACTIVE = 0;
    private static final int SENDMSG_NOOP = 1;
    private static final int SENDMSG_QUEUE = 2;
    private static final int SENDMSG_REPLACE = 0;
    private static final String SOUND_EFFECTS_PATH = "/media/audio/ui/";
    private static final String SOUND_EFFECT_FILES[];
    private static int SOUND_EFFECT_VOLUME_DB = 0;
    public static final int STREAM_REMOTE_MUSIC = -200;
    private static final String TAG = "AudioService";
    private static final int VOICEBUTTON_ACTION_DISCARD_CURRENT_KEY_PRESS = 1;
    private static final int VOICEBUTTON_ACTION_SIMULATE_KEY_PRESS = 3;
    private static final int VOICEBUTTON_ACTION_START_VOICE_INPUT = 2;
    private static final int WAKELOCK_RELEASE_ON_FINISHED = 1980;
    private static final Object mAudioFocusLock = new Object();
    private static final Object mRingingLock = new Object();
    private static int sLastRccId = 0;
    private final int MAX_STREAM_VOLUME[];
    private final int SOUND_EFFECT_FILES_MAP[][];
    private final String STREAM_NAMES[];
    private final int STREAM_VOLUME_ALIAS[];
    private final int STREAM_VOLUME_ALIAS_NON_VOICE[];
    private int mArtworkExpectedHeight;
    private int mArtworkExpectedWidth;
    private AudioHandler mAudioHandler;
    private final AudioSystem.ErrorCallback mAudioSystemCallback = new AudioSystem.ErrorCallback() {

        public void onError(int i) {
            i;
            JVM INSTR lookupswitch 2: default 28
        //                       0: 69
        //                       100: 29;
               goto _L1 _L2 _L3
_L1:
            return;
_L3:
            if(mMediaServerOk) {
                AudioService.sendMsg(mAudioHandler, 4, 1, 0, 0, null, 1500);
                mMediaServerOk = false;
            }
            continue; /* Loop/switch isn't completed */
_L2:
            if(!mMediaServerOk) {
                AudioService.sendMsg(mAudioHandler, 5, 1, 0, 0, null, 0);
                mMediaServerOk = true;
            }
            if(true) goto _L1; else goto _L4
_L4:
        }

        final AudioService this$0;

             {
                this$0 = AudioService.this;
                Object();
            }
    };
    private AudioSystemThread mAudioSystemThread;
    int mBecomingNoisyIntentDevices;
    private boolean mBluetoothA2dpEnabled;
    private final Object mBluetoothA2dpEnabledLock = new Object();
    private BluetoothHeadset mBluetoothHeadset;
    private BluetoothDevice mBluetoothHeadsetDevice;
    private android.bluetooth.BluetoothProfile.ServiceListener mBluetoothProfileServiceListener;
    private boolean mBootCompleted;
    private final HashMap mConnectedDevices = new HashMap();
    private ContentResolver mContentResolver;
    private Context mContext;
    final AudioRoutesInfo mCurAudioRoutes = new AudioRoutesInfo();
    private IRemoteControlClient mCurrentRcClient;
    private int mCurrentRcClientGen;
    private final Object mCurrentRcLock = new Object();
    private int mDeviceOrientation;
    private String mDockAddress;
    private final Stack mFocusStack = new Stack();
    private ForceControlStreamClient mForceControlStreamClient;
    private final Object mForceControlStreamLock = new Object();
    private int mForcedUseForComm;
    private boolean mHasRemotePlayback;
    private final boolean mHasVibrator;
    private boolean mIsRinging;
    BroadcastReceiver mKeyEventDone;
    private KeyguardManager mKeyguardManager;
    private RemotePlaybackState mMainRemote;
    private boolean mMainRemoteIsActive;
    private final int mMasterVolumeRamp[];
    private android.os.PowerManager.WakeLock mMediaEventWakeLock;
    private ComponentName mMediaReceiverForCalls;
    private boolean mMediaServerOk;
    private int mMode;
    private int mMuteAffectedStreams;
    private PhoneStateListener mPhoneStateListener;
    private int mPrevVolDirection;
    private final Stack mRCStack = new Stack();
    private IRemoteControlDisplay mRcDisplay;
    private RcDisplayDeathHandler mRcDisplayDeathHandler;
    private final BroadcastReceiver mReceiver = new AudioServiceBroadcastReceiver();
    private int mRingerMode;
    private int mRingerModeAffectedStreams;
    private int mRingerModeMutedStreams;
    private volatile IRingtonePlayer mRingtonePlayer;
    final RemoteCallbackList mRoutesObservers = new RemoteCallbackList();
    private int mScoAudioState;
    private final ArrayList mScoClients = new ArrayList();
    private int mScoConnectionState;
    private final ArrayList mSetModeDeathHandlers = new ArrayList();
    private final Object mSettingsLock = new Object();
    private SettingsObserver mSettingsObserver;
    private final Object mSoundEffectsLock = new Object();
    private SoundPool mSoundPool;
    private SoundPoolCallback mSoundPoolCallBack;
    private SoundPoolListenerThread mSoundPoolListenerThread;
    private Looper mSoundPoolLooper;
    private VolumeStreamState mStreamStates[];
    private int mStreamVolumeAlias[];
    private final boolean mUseMasterVolume;
    private int mVibrateSetting;
    private boolean mVoiceButtonDown;
    private boolean mVoiceButtonHandled;
    private boolean mVoiceCapable;
    private final Object mVoiceEventLock = new Object();
    private int mVolumeControlStream;
    private VolumePanel mVolumePanel;

    static  {
        String as[] = new String[5];
        as[0] = "Effect_Tick.ogg";
        as[1] = "KeypressStandard.ogg";
        as[2] = "KeypressSpacebar.ogg";
        as[3] = "KeypressDelete.ogg";
        as[4] = "KeypressReturn.ogg";
        SOUND_EFFECT_FILES = as;
    }



/*
    static boolean access$002(AudioService audioservice, boolean flag) {
        audioservice.mMediaServerOk = flag;
        return flag;
    }

*/



/*
    static int access$1002(AudioService audioservice, int i) {
        audioservice.mVolumeControlStream = i;
        return i;
    }

*/


/*
    static AudioHandler access$102(AudioService audioservice, AudioHandler audiohandler) {
        audioservice.mAudioHandler = audiohandler;
        return audiohandler;
    }

*/




/*
    static Looper access$1402(AudioService audioservice, Looper looper) {
        audioservice.mSoundPoolLooper = looper;
        return looper;
    }

*/





/*
    static SoundPoolCallback access$1702(AudioService audioservice, SoundPoolCallback soundpoolcallback) {
        audioservice.mSoundPoolCallBack = soundpoolcallback;
        return soundpoolcallback;
    }

*/







/*
    static int access$2402(AudioService audioservice, int i) {
        audioservice.mScoAudioState = i;
        return i;
    }

*/



/*
    static BluetoothHeadset access$2502(AudioService audioservice, BluetoothHeadset bluetoothheadset) {
        audioservice.mBluetoothHeadset = bluetoothheadset;
        return bluetoothheadset;
    }

*/



/*
    static BluetoothDevice access$2602(AudioService audioservice, BluetoothDevice bluetoothdevice) {
        audioservice.mBluetoothHeadsetDevice = bluetoothdevice;
        return bluetoothdevice;
    }

*/





































/*
    static int access$6702(AudioService audioservice, int i) {
        audioservice.mRingerModeAffectedStreams = i;
        return i;
    }

*/




/*
    static boolean access$7002(AudioService audioservice, boolean flag) {
        audioservice.mBootCompleted = flag;
        return flag;
    }

*/


/*
    static KeyguardManager access$7102(AudioService audioservice, KeyguardManager keyguardmanager) {
        audioservice.mKeyguardManager = keyguardmanager;
        return keyguardmanager;
    }

*/


/*
    static int access$7202(AudioService audioservice, int i) {
        audioservice.mScoConnectionState = i;
        return i;
    }

*/






/*
    static boolean access$7702(AudioService audioservice, boolean flag) {
        audioservice.mIsRinging = flag;
        return flag;
    }

*/






/*
    static int access$8104() {
        int i = 1 + sLastRccId;
        sLastRccId = i;
        return i;
    }

*/



/*
    static IRemoteControlDisplay access$8402(AudioService audioservice, IRemoteControlDisplay iremotecontroldisplay) {
        audioservice.mRcDisplay = iremotecontroldisplay;
        return iremotecontroldisplay;
    }

*/



/*
    static ForceControlStreamClient access$902(AudioService audioservice, ForceControlStreamClient forcecontrolstreamclient) {
        audioservice.mForceControlStreamClient = forcecontrolstreamclient;
        return forcecontrolstreamclient;
    }

*/
}

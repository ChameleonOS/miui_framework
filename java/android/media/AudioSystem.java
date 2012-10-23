// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;


public class AudioSystem {
    public static interface ErrorCallback {

        public abstract void onError(int i);
    }


    public AudioSystem() {
    }

    private static void errorCallbackFromNative(int i) {
        ErrorCallback errorcallback = null;
        android/media/AudioSystem;
        JVM INSTR monitorenter ;
        if(mErrorCallback != null)
            errorcallback = mErrorCallback;
        android/media/AudioSystem;
        JVM INSTR monitorexit ;
        if(errorcallback != null)
            errorcallback.onError(i);
        return;
        Exception exception;
        exception;
        android/media/AudioSystem;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static native int getDeviceConnectionState(int i, String s);

    public static String getDeviceName(int i) {
        i;
        JVM INSTR lookupswitch 15: default 132
    //                   1: 137
    //                   2: 143
    //                   4: 149
    //                   8: 155
    //                   16: 161
    //                   32: 167
    //                   64: 173
    //                   128: 179
    //                   256: 185
    //                   512: 191
    //                   1024: 197
    //                   2048: 203
    //                   4096: 209
    //                   8192: 215
    //                   16384: 221;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16
_L1:
        String s = "";
_L18:
        return s;
_L2:
        s = "earpiece";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "speaker";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "headset";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "headphone";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "bt_sco";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "bt_sco_hs";
        continue; /* Loop/switch isn't completed */
_L8:
        s = "bt_sco_carkit";
        continue; /* Loop/switch isn't completed */
_L9:
        s = "bt_a2dp";
        continue; /* Loop/switch isn't completed */
_L10:
        s = "bt_a2dp_hp";
        continue; /* Loop/switch isn't completed */
_L11:
        s = "bt_a2dp_spk";
        continue; /* Loop/switch isn't completed */
_L12:
        s = "aux_digital";
        continue; /* Loop/switch isn't completed */
_L13:
        s = "analog_dock";
        continue; /* Loop/switch isn't completed */
_L14:
        s = "digital_dock";
        continue; /* Loop/switch isn't completed */
_L15:
        s = "usb_accessory";
        continue; /* Loop/switch isn't completed */
_L16:
        s = "usb_device";
        if(true) goto _L18; else goto _L17
_L17:
    }

    public static native int getDevicesForStream(int i);

    public static native int getForceUse(int i);

    public static native boolean getMasterMute();

    public static native float getMasterVolume();

    public static final int getNumStreamTypes() {
        return 10;
    }

    public static native String getParameters(String s);

    public static native int getStreamVolumeIndex(int i, int j);

    public static native int initStreamVolume(int i, int j, int k);

    public static native boolean isMicrophoneMuted();

    public static native boolean isStreamActive(int i, int j);

    public static native int muteMicrophone(boolean flag);

    public static native int setDeviceConnectionState(int i, int j, String s);

    public static void setErrorCallback(ErrorCallback errorcallback) {
        android/media/AudioSystem;
        JVM INSTR monitorenter ;
        mErrorCallback = errorcallback;
        android/media/AudioSystem;
        JVM INSTR monitorexit ;
        isMicrophoneMuted();
        return;
        Exception exception;
        exception;
        android/media/AudioSystem;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static native int setForceUse(int i, int j);

    public static native int setMasterMute(boolean flag);

    public static native int setMasterVolume(float f);

    public static native int setParameters(String s);

    public static native int setPhoneState(int i);

    public static native int setStreamVolumeIndex(int i, int j, int k);

    public static final int AUDIO_STATUS_ERROR = 1;
    public static final int AUDIO_STATUS_OK = 0;
    public static final int AUDIO_STATUS_SERVER_DIED = 100;
    public static final int DEVICE_IN_AMBIENT = 0x20000;
    public static final int DEVICE_IN_AUX_DIGITAL = 0x800000;
    public static final int DEVICE_IN_BLUETOOTH_SCO_HEADSET = 0x200000;
    public static final int DEVICE_IN_BUILTIN_MIC1 = 0x40000;
    public static final int DEVICE_IN_BUILTIN_MIC2 = 0x80000;
    public static final int DEVICE_IN_COMMUNICATION = 0x10000;
    public static final int DEVICE_IN_DEFAULT = 0x80000000;
    public static final int DEVICE_IN_MIC_ARRAY = 0x100000;
    public static final int DEVICE_IN_WIRED_HEADSET = 0x400000;
    public static final int DEVICE_OUT_ALL = 65535;
    public static final int DEVICE_OUT_ALL_A2DP = 896;
    public static final int DEVICE_OUT_ALL_SCO = 112;
    public static final int DEVICE_OUT_ALL_USB = 24576;
    public static final int DEVICE_OUT_ANLG_DOCK_HEADSET = 2048;
    public static final String DEVICE_OUT_ANLG_DOCK_HEADSET_NAME = "analog_dock";
    public static final int DEVICE_OUT_AUX_DIGITAL = 1024;
    public static final String DEVICE_OUT_AUX_DIGITAL_NAME = "aux_digital";
    public static final int DEVICE_OUT_BLUETOOTH_A2DP = 128;
    public static final int DEVICE_OUT_BLUETOOTH_A2DP_HEADPHONES = 256;
    public static final String DEVICE_OUT_BLUETOOTH_A2DP_HEADPHONES_NAME = "bt_a2dp_hp";
    public static final String DEVICE_OUT_BLUETOOTH_A2DP_NAME = "bt_a2dp";
    public static final int DEVICE_OUT_BLUETOOTH_A2DP_SPEAKER = 512;
    public static final String DEVICE_OUT_BLUETOOTH_A2DP_SPEAKER_NAME = "bt_a2dp_spk";
    public static final int DEVICE_OUT_BLUETOOTH_SCO = 16;
    public static final int DEVICE_OUT_BLUETOOTH_SCO_CARKIT = 64;
    public static final String DEVICE_OUT_BLUETOOTH_SCO_CARKIT_NAME = "bt_sco_carkit";
    public static final int DEVICE_OUT_BLUETOOTH_SCO_HEADSET = 32;
    public static final String DEVICE_OUT_BLUETOOTH_SCO_HEADSET_NAME = "bt_sco_hs";
    public static final String DEVICE_OUT_BLUETOOTH_SCO_NAME = "bt_sco";
    public static final int DEVICE_OUT_DEFAULT = 32768;
    public static final int DEVICE_OUT_DGTL_DOCK_HEADSET = 4096;
    public static final String DEVICE_OUT_DGTL_DOCK_HEADSET_NAME = "digital_dock";
    public static final int DEVICE_OUT_EARPIECE = 1;
    public static final String DEVICE_OUT_EARPIECE_NAME = "earpiece";
    public static final int DEVICE_OUT_SPEAKER = 2;
    public static final String DEVICE_OUT_SPEAKER_NAME = "speaker";
    public static final int DEVICE_OUT_USB_ACCESSORY = 8192;
    public static final String DEVICE_OUT_USB_ACCESSORY_NAME = "usb_accessory";
    public static final int DEVICE_OUT_USB_DEVICE = 16384;
    public static final String DEVICE_OUT_USB_DEVICE_NAME = "usb_device";
    public static final int DEVICE_OUT_WIRED_HEADPHONE = 8;
    public static final String DEVICE_OUT_WIRED_HEADPHONE_NAME = "headphone";
    public static final int DEVICE_OUT_WIRED_HEADSET = 4;
    public static final String DEVICE_OUT_WIRED_HEADSET_NAME = "headset";
    public static final int DEVICE_STATE_AVAILABLE = 1;
    public static final int DEVICE_STATE_UNAVAILABLE = 0;
    public static final int FORCE_ANALOG_DOCK = 8;
    public static final int FORCE_BT_A2DP = 4;
    public static final int FORCE_BT_CAR_DOCK = 6;
    public static final int FORCE_BT_DESK_DOCK = 7;
    public static final int FORCE_BT_SCO = 3;
    public static final int FORCE_DEFAULT = 0;
    public static final int FORCE_DIGITAL_DOCK = 9;
    public static final int FORCE_HEADPHONES = 2;
    public static final int FORCE_NONE = 0;
    public static final int FORCE_NO_BT_A2DP = 10;
    public static final int FORCE_SPEAKER = 1;
    public static final int FORCE_WIRED_ACCESSORY = 5;
    public static final int FOR_COMMUNICATION = 0;
    public static final int FOR_DOCK = 3;
    public static final int FOR_MEDIA = 1;
    public static final int FOR_RECORD = 2;
    public static final int MODE_CURRENT = -1;
    public static final int MODE_INVALID = -2;
    public static final int MODE_IN_CALL = 2;
    public static final int MODE_IN_COMMUNICATION = 3;
    public static final int MODE_NORMAL = 0;
    public static final int MODE_RINGTONE = 1;
    private static final int NUM_DEVICE_STATES = 1;
    private static final int NUM_FORCE_CONFIG = 11;
    private static final int NUM_FORCE_USE = 4;
    public static final int NUM_MODES = 4;
    public static final int NUM_STREAMS = 5;
    private static final int NUM_STREAM_TYPES = 10;
    public static final int PHONE_STATE_INCALL = 2;
    public static final int PHONE_STATE_OFFCALL = 0;
    public static final int PHONE_STATE_RINGING = 1;
    public static final int ROUTE_ALL = -1;
    public static final int ROUTE_BLUETOOTH = 4;
    public static final int ROUTE_BLUETOOTH_A2DP = 16;
    public static final int ROUTE_BLUETOOTH_SCO = 4;
    public static final int ROUTE_EARPIECE = 1;
    public static final int ROUTE_HEADSET = 8;
    public static final int ROUTE_SPEAKER = 2;
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
    public static final int SYNC_EVENT_NONE = 0;
    public static final int SYNC_EVENT_PRESENTATION_COMPLETE = 1;
    private static ErrorCallback mErrorCallback;
}

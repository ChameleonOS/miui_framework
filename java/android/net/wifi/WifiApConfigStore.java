// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.wifi;

import android.content.Context;
import android.os.*;
import android.util.Log;
import com.android.internal.util.*;
import java.io.*;
import java.util.BitSet;
import java.util.UUID;

// Referenced classes of package android.net.wifi:
//            WifiConfiguration

class WifiApConfigStore extends StateMachine {
    class ActiveState extends State {

        public void enter() {
            (new Thread(new Runnable() {

                public void run() {
                    writeApConfiguration(mWifiApConfig);
                    sendMessage(0x2001a);
                }

                final ActiveState this$1;

                 {
                    this$1 = ActiveState.this;
                    super();
                }
            })).start();
        }

        public boolean processMessage(Message message) {
            message.what;
            JVM INSTR tableswitch 131097 131098: default 28
        //                       131097 32
        //                       131098 45;
               goto _L1 _L2 _L3
_L1:
            boolean flag = false;
_L4:
            return flag;
_L2:
            deferMessage(message);
_L5:
            flag = true;
            if(true) goto _L4; else goto _L3
_L3:
            transitionTo(mInactiveState);
              goto _L5
        }

        final WifiApConfigStore this$0;

        ActiveState() {
            this$0 = WifiApConfigStore.this;
            super();
        }
    }

    class InactiveState extends State {

        public boolean processMessage(Message message) {
            message.what;
            JVM INSTR tableswitch 131097 131097: default 24
        //                       131097 28;
               goto _L1 _L2
_L1:
            boolean flag = false;
_L4:
            return flag;
_L2:
            mWifiApConfig = (WifiConfiguration)message.obj;
            transitionTo(mActiveState);
            flag = true;
            if(true) goto _L4; else goto _L3
_L3:
        }

        final WifiApConfigStore this$0;

        InactiveState() {
            this$0 = WifiApConfigStore.this;
            super();
        }
    }

    class DefaultState extends State {

        public boolean processMessage(Message message) {
            message.what;
            JVM INSTR tableswitch 131097 131099: default 32
        //                       131097 59
        //                       131098 59
        //                       131099 87;
               goto _L1 _L2 _L2 _L3
_L1:
            Log.e("WifiApConfigStore", (new StringBuilder()).append("Failed to handle ").append(message).toString());
_L5:
            return true;
_L2:
            Log.e("WifiApConfigStore", (new StringBuilder()).append("Unexpected message: ").append(message).toString());
            continue; /* Loop/switch isn't completed */
_L3:
            mReplyChannel.replyToMessage(message, 0x2001c, mWifiApConfig);
            if(true) goto _L5; else goto _L4
_L4:
        }

        final WifiApConfigStore this$0;

        DefaultState() {
            this$0 = WifiApConfigStore.this;
            super();
        }
    }


    WifiApConfigStore(Context context, Handler handler) {
        super("WifiApConfigStore", handler.getLooper());
        mDefaultState = new DefaultState();
        mInactiveState = new InactiveState();
        mActiveState = new ActiveState();
        mWifiApConfig = null;
        mReplyChannel = new AsyncChannel();
        mContext = context;
        addState(mDefaultState);
        addState(mInactiveState, mDefaultState);
        addState(mActiveState, mDefaultState);
        setInitialState(mInactiveState);
    }

    public static WifiApConfigStore makeWifiApConfigStore(Context context, Handler handler) {
        WifiApConfigStore wifiapconfigstore = new WifiApConfigStore(context, handler);
        wifiapconfigstore.start();
        return wifiapconfigstore;
    }

    private void setDefaultApConfiguration() {
        WifiConfiguration wificonfiguration = new WifiConfiguration();
        wificonfiguration.SSID = mContext.getString(0x1040407);
        wificonfiguration.allowedKeyManagement.set(4);
        String s = UUID.randomUUID().toString();
        wificonfiguration.preSharedKey = (new StringBuilder()).append(s.substring(0, 8)).append(s.substring(9, 13)).toString();
        sendMessage(0x20019, wificonfiguration);
    }

    private void writeApConfiguration(WifiConfiguration wificonfiguration) {
        DataOutputStream dataoutputstream = null;
        DataOutputStream dataoutputstream1 = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(AP_CONFIG_FILE)));
        dataoutputstream1.writeInt(1);
        dataoutputstream1.writeUTF(wificonfiguration.SSID);
        int i = wificonfiguration.getAuthType();
        dataoutputstream1.writeInt(i);
        if(i != 0)
            dataoutputstream1.writeUTF(wificonfiguration.preSharedKey);
        if(dataoutputstream1 == null)
            break MISSING_BLOCK_LABEL_73;
        dataoutputstream1.close();
_L1:
        return;
        IOException ioexception;
        ioexception;
_L3:
        Log.e("WifiApConfigStore", (new StringBuilder()).append("Error writing hotspot configuration").append(ioexception).toString());
        if(dataoutputstream != null)
            try {
                dataoutputstream.close();
            }
            catch(IOException ioexception2) { }
          goto _L1
        Exception exception;
        exception;
_L2:
        if(dataoutputstream != null)
            try {
                dataoutputstream.close();
            }
            catch(IOException ioexception1) { }
        throw exception;
        IOException ioexception3;
        ioexception3;
          goto _L1
        exception;
        dataoutputstream = dataoutputstream1;
          goto _L2
        ioexception;
        dataoutputstream = dataoutputstream1;
          goto _L3
    }

    Messenger getMessenger() {
        return new Messenger(getHandler());
    }

    void loadApConfiguration() {
        DataInputStream datainputstream = null;
        WifiConfiguration wificonfiguration;
        DataInputStream datainputstream1;
        wificonfiguration = new WifiConfiguration();
        datainputstream1 = new DataInputStream(new BufferedInputStream(new FileInputStream(AP_CONFIG_FILE)));
        if(datainputstream1.readInt() == 1) goto _L2; else goto _L1
_L1:
        Log.e("WifiApConfigStore", "Bad version on hotspot configuration file, set defaults");
        setDefaultApConfiguration();
        if(datainputstream1 == null)
            break MISSING_BLOCK_LABEL_63;
        datainputstream1.close();
_L3:
        return;
_L2:
        wificonfiguration.SSID = datainputstream1.readUTF();
        int i = datainputstream1.readInt();
        wificonfiguration.allowedKeyManagement.set(i);
        if(i != 0)
            wificonfiguration.preSharedKey = datainputstream1.readUTF();
        mWifiApConfig = wificonfiguration;
        Exception exception;
        IOException ioexception4;
        IOException ioexception5;
        if(datainputstream1 != null)
            try {
                datainputstream1.close();
            }
            catch(IOException ioexception3) { }
          goto _L3
        ioexception5;
_L5:
        setDefaultApConfiguration();
        if(datainputstream != null)
            try {
                datainputstream.close();
            }
            catch(IOException ioexception2) { }
          goto _L3
        exception;
_L4:
        if(datainputstream != null)
            try {
                datainputstream.close();
            }
            catch(IOException ioexception1) { }
        throw exception;
        ioexception4;
          goto _L3
        exception;
        datainputstream = datainputstream1;
          goto _L4
        IOException ioexception;
        ioexception;
        datainputstream = datainputstream1;
          goto _L5
    }

    private static final String AP_CONFIG_FILE = (new StringBuilder()).append(Environment.getDataDirectory()).append("/misc/wifi/softap.conf").toString();
    private static final int AP_CONFIG_FILE_VERSION = 1;
    private static final String TAG = "WifiApConfigStore";
    private State mActiveState;
    private Context mContext;
    private State mDefaultState;
    private State mInactiveState;
    private AsyncChannel mReplyChannel;
    private WifiConfiguration mWifiApConfig;




/*
    static WifiConfiguration access$002(WifiApConfigStore wifiapconfigstore, WifiConfiguration wificonfiguration) {
        wifiapconfigstore.mWifiApConfig = wificonfiguration;
        return wificonfiguration;
    }

*/







}

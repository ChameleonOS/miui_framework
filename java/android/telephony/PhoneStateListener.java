// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.telephony;

import android.os.*;
import com.android.internal.telephony.IPhoneStateListener;

// Referenced classes of package android.telephony:
//            CellInfo, CellLocation, ServiceState, SignalStrength

public class PhoneStateListener {

    public PhoneStateListener() {
        callback = new com.android.internal.telephony.IPhoneStateListener.Stub() {

            public void onCallForwardingIndicatorChanged(boolean flag) {
                Handler handler = mHandler;
                int i;
                if(flag)
                    i = 1;
                else
                    i = 0;
                Message.obtain(handler, 8, i, 0, null).sendToTarget();
            }

            public void onCallStateChanged(int i, String s) {
                Message.obtain(mHandler, 32, i, 0, s).sendToTarget();
            }

            public void onCellInfoChanged(CellInfo cellinfo) {
                Message.obtain(mHandler, 1024, 0, 0).sendToTarget();
            }

            public void onCellLocationChanged(Bundle bundle) {
                CellLocation celllocation = CellLocation.newFromBundle(bundle);
                Message.obtain(mHandler, 16, 0, 0, celllocation).sendToTarget();
            }

            public void onDataActivity(int i) {
                Message.obtain(mHandler, 128, i, 0, null).sendToTarget();
            }

            public void onDataConnectionStateChanged(int i, int j) {
                Message.obtain(mHandler, 64, i, j).sendToTarget();
            }

            public void onMessageWaitingIndicatorChanged(boolean flag) {
                Handler handler = mHandler;
                int i;
                if(flag)
                    i = 1;
                else
                    i = 0;
                Message.obtain(handler, 4, i, 0, null).sendToTarget();
            }

            public void onOtaspChanged(int i) {
                Message.obtain(mHandler, 512, i, 0).sendToTarget();
            }

            public void onServiceStateChanged(ServiceState servicestate) {
                Message.obtain(mHandler, 1, 0, 0, servicestate).sendToTarget();
            }

            public void onSignalStrengthChanged(int i) {
                Message.obtain(mHandler, 2, i, 0, null).sendToTarget();
            }

            public void onSignalStrengthsChanged(SignalStrength signalstrength) {
                Message.obtain(mHandler, 256, 0, 0, signalstrength).sendToTarget();
            }

            final PhoneStateListener this$0;

             {
                this$0 = PhoneStateListener.this;
                super();
            }
        };
        mHandler = new Handler() {

            public void handleMessage(Message message) {
                boolean flag = true;
                message.what;
                JVM INSTR lookupswitch 11: default 104
            //                           1: 105
            //                           2: 122
            //                           4: 136
            //                           8: 163
            //                           16: 188
            //                           32: 205
            //                           64: 226
            //                           128: 255
            //                           256: 269
            //                           512: 286
            //                           1024: 300;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L1:
                return;
_L2:
                onServiceStateChanged((ServiceState)message.obj);
                continue; /* Loop/switch isn't completed */
_L3:
                onSignalStrengthChanged(message.arg1);
                continue; /* Loop/switch isn't completed */
_L4:
                PhoneStateListener phonestatelistener1 = PhoneStateListener.this;
                if(message.arg1 == 0)
                    flag = false;
                phonestatelistener1.onMessageWaitingIndicatorChanged(flag);
                continue; /* Loop/switch isn't completed */
_L5:
                PhoneStateListener phonestatelistener = PhoneStateListener.this;
                if(message.arg1 == 0)
                    flag = false;
                phonestatelistener.onCallForwardingIndicatorChanged(flag);
                continue; /* Loop/switch isn't completed */
_L6:
                onCellLocationChanged((CellLocation)message.obj);
                continue; /* Loop/switch isn't completed */
_L7:
                onCallStateChanged(message.arg1, (String)message.obj);
                continue; /* Loop/switch isn't completed */
_L8:
                onDataConnectionStateChanged(message.arg1, message.arg2);
                onDataConnectionStateChanged(message.arg1);
                continue; /* Loop/switch isn't completed */
_L9:
                onDataActivity(message.arg1);
                continue; /* Loop/switch isn't completed */
_L10:
                onSignalStrengthsChanged((SignalStrength)message.obj);
                continue; /* Loop/switch isn't completed */
_L11:
                onOtaspChanged(message.arg1);
                continue; /* Loop/switch isn't completed */
_L12:
                onCellInfoChanged((CellInfo)message.obj);
                if(true) goto _L1; else goto _L13
_L13:
            }

            final PhoneStateListener this$0;

             {
                this$0 = PhoneStateListener.this;
                super();
            }
        };
    }

    public void onCallForwardingIndicatorChanged(boolean flag) {
    }

    public void onCallStateChanged(int i, String s) {
    }

    public void onCellInfoChanged(CellInfo cellinfo) {
    }

    public void onCellLocationChanged(CellLocation celllocation) {
    }

    public void onDataActivity(int i) {
    }

    public void onDataConnectionStateChanged(int i) {
    }

    public void onDataConnectionStateChanged(int i, int j) {
    }

    public void onMessageWaitingIndicatorChanged(boolean flag) {
    }

    public void onOtaspChanged(int i) {
    }

    public void onServiceStateChanged(ServiceState servicestate) {
    }

    public void onSignalStrengthChanged(int i) {
    }

    public void onSignalStrengthsChanged(SignalStrength signalstrength) {
    }

    public static final int LISTEN_CALL_FORWARDING_INDICATOR = 8;
    public static final int LISTEN_CALL_STATE = 32;
    public static final int LISTEN_CELL_INFO = 1024;
    public static final int LISTEN_CELL_LOCATION = 16;
    public static final int LISTEN_DATA_ACTIVITY = 128;
    public static final int LISTEN_DATA_CONNECTION_STATE = 64;
    public static final int LISTEN_MESSAGE_WAITING_INDICATOR = 4;
    public static final int LISTEN_NONE = 0;
    public static final int LISTEN_OTASP_CHANGED = 512;
    public static final int LISTEN_SERVICE_STATE = 1;
    public static final int LISTEN_SIGNAL_STRENGTH = 2;
    public static final int LISTEN_SIGNAL_STRENGTHS = 256;
    IPhoneStateListener callback;
    Handler mHandler;
}

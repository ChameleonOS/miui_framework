// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.content.*;
import android.net.*;
import android.os.*;
import android.telephony.*;
import android.text.TextUtils;
import android.util.Log;
import com.android.internal.telephony.cdma.CdmaCallWaitingNotification;
import com.android.internal.telephony.cdma.CdmaInformationRecords;
import com.android.internal.telephony.gsm.SmsBroadcastConfigInfo;
import com.android.internal.telephony.gsm.SuppServiceNotification;
import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.android.internal.telephony:
//            BaseCommands, CommandsInterface, RILRequest, DataCallState, 
//            IccUtils, CallForwardInfo, DriverCall, UUSInfo, 
//            IccIoResult, IccCardStatus, IccCardApplication, OperatorInfo, 
//            SmsResponse, IccRefreshResponse

public final class RIL extends BaseCommands
    implements CommandsInterface {
    class RILReceiver
        implements Runnable {

        public void run() {
            int i = 0;
_L3:
            LocalSocket localsocket = null;
            LocalSocket localsocket1 = new LocalSocket();
            localsocket1.connect(new LocalSocketAddress("rild", android.net.LocalSocketAddress.Namespace.RESERVED));
            i = 0;
            mSocket = localsocket1;
            Log.i("RILJ", "Connected to 'rild' socket");
            int j = 0;
            InputStream inputstream = mSocket.getInputStream();
_L9:
            int k = RIL.readRilMessage(inputstream, buffer);
            j = k;
            if(j >= 0) goto _L2; else goto _L1
_L1:
            Log.i("RILJ", "Disconnected from 'rild' socket");
            setRadioState(CommandsInterface.RadioState.RADIO_UNAVAILABLE);
            Throwable throwable;
            IOException ioexception4;
            try {
                mSocket.close();
            }
            catch(IOException ioexception2) { }
            mSocket = null;
            RILRequest.resetSerial();
            clearRequestsList(1, false);
              goto _L3
            throwable;
_L8:
            Log.e("RILJ", "Uncaught exception", throwable);
            notifyRegistrantsRilConnectionChanged(-1);
            return;
            ioexception4;
_L11:
            if(localsocket == null)
                break MISSING_BLOCK_LABEL_164;
            localsocket.close();
_L10:
            if(i != 8) goto _L5; else goto _L4
_L4:
            Log.e("RILJ", (new StringBuilder()).append("Couldn't find 'rild' socket after ").append(i).append(" times, continuing to retry silently").toString());
_L7:
            IOException ioexception1;
            Throwable throwable1;
            IOException ioexception3;
            Parcel parcel;
            try {
                Thread.sleep(4000L);
            }
            catch(InterruptedException interruptedexception) { }
            i++;
              goto _L3
_L5:
            if(i <= 0 || i >= 8) goto _L7; else goto _L6
_L6:
            Log.i("RILJ", "Couldn't find 'rild' socket; retrying after timeout");
              goto _L7
            throwable;
              goto _L8
_L2:
            parcel = Parcel.obtain();
            parcel.unmarshall(buffer, 0, j);
            parcel.setDataPosition(0);
            processResponse(parcel);
            parcel.recycle();
              goto _L9
            ioexception3;
            Log.i("RILJ", "'rild' socket closed", ioexception3);
              goto _L1
            throwable1;
            Log.e("RILJ", (new StringBuilder()).append("Uncaught exception read length=").append(j).append("Exception:").append(throwable1.toString()).toString());
              goto _L1
            ioexception1;
              goto _L10
            IOException ioexception;
            ioexception;
            localsocket = localsocket1;
              goto _L11
        }

        byte buffer[];
        final RIL this$0;

        RILReceiver() {
            this$0 = RIL.this;
            super();
            buffer = new byte[8192];
        }
    }

    class RILSender extends Handler
        implements Runnable {

        public void handleMessage(Message message) {
            RILRequest rilrequest = (RILRequest)(RILRequest)message.obj;
            message.what;
            JVM INSTR tableswitch 1 2: default 36
        //                       1 37
        //                       2 478;
               goto _L1 _L2 _L3
_L1:
            return;
_L2:
            boolean flag = false;
            LocalSocket localsocket = mSocket;
            if(localsocket != null) goto _L5; else goto _L4
_L4:
            rilrequest.onError(1, null);
            rilrequest.release();
            if(mRequestMessagesPending > 0) {
                RIL ril4 = RIL.this;
                ril4.mRequestMessagesPending = -1 + ril4.mRequestMessagesPending;
            }
            releaseWakeLockIfDone();
            continue; /* Loop/switch isn't completed */
_L5:
            synchronized(mRequestsList) {
                mRequestsList.add(rilrequest);
                RIL ril2 = RIL.this;
                ril2.mRequestMessagesWaiting = 1 + ril2.mRequestMessagesWaiting;
            }
            byte abyte0[];
            if(mRequestMessagesPending > 0) {
                RIL ril3 = RIL.this;
                ril3.mRequestMessagesPending = -1 + ril3.mRequestMessagesPending;
            }
            flag = true;
            abyte0 = rilrequest.mp.marshall();
            rilrequest.mp.recycle();
            rilrequest.mp = null;
            if(abyte0.length > 8192)
                throw new RuntimeException((new StringBuilder()).append("Parcel larger than max bytes allowed! ").append(abyte0.length).toString());
              goto _L6
            IOException ioexception;
            ioexception;
            Log.e("RILJ", "IOException", ioexception);
            if(findAndRemoveRequestFromList(rilrequest.mSerial) != null || !flag) {
                rilrequest.onError(1, null);
                rilrequest.release();
            }
            RIL ril = RIL.this;
_L7:
            ril.releaseWakeLockIfDone();
            if(!flag && mRequestMessagesPending > 0) {
                RIL ril1 = RIL.this;
                ril1.mRequestMessagesPending = -1 + ril1.mRequestMessagesPending;
            }
            continue; /* Loop/switch isn't completed */
            exception3;
            arraylist1;
            JVM INSTR monitorexit ;
            throw exception3;
            RuntimeException runtimeexception;
            runtimeexception;
            Log.e("RILJ", "Uncaught exception ", runtimeexception);
            if(findAndRemoveRequestFromList(rilrequest.mSerial) != null || !flag) {
                rilrequest.onError(2, null);
                rilrequest.release();
            }
            ril = RIL.this;
              goto _L7
_L6:
            byte abyte1[] = dataLength;
            dataLength[1] = 0;
            abyte1[0] = 0;
            dataLength[2] = (byte)(0xff & abyte0.length >> 8);
            dataLength[3] = (byte)(0xff & abyte0.length);
            localsocket.getOutputStream().write(dataLength);
            localsocket.getOutputStream().write(abyte0);
            ril = RIL.this;
              goto _L7
            Exception exception2;
            exception2;
            releaseWakeLockIfDone();
            throw exception2;
_L3:
            android.os.PowerManager.WakeLock wakelock = mWakeLock;
            wakelock;
            JVM INSTR monitorenter ;
            if(!mWakeLock.isHeld()) goto _L9; else goto _L8
_L8:
            if(mRequestMessagesWaiting == 0) goto _L11; else goto _L10
_L10:
            Log.d("RILJ", (new StringBuilder()).append("NOTE: mReqWaiting is NOT 0 but").append(mRequestMessagesWaiting).append(" at TIMEOUT, reset!").append(" There still msg waitng for response").toString());
            mRequestMessagesWaiting = 0;
            synchronized(mRequestsList) {
                int i = mRequestsList.size();
                Log.d("RILJ", (new StringBuilder()).append("WAKE_LOCK_TIMEOUT  mRequestList=").append(i).toString());
                for(int j = 0; j < i; j++) {
                    RILRequest rilrequest1 = (RILRequest)mRequestsList.get(j);
                    Log.d("RILJ", (new StringBuilder()).append(j).append(": [").append(rilrequest1.mSerial).append("] ").append(RIL.requestToString(rilrequest1.mRequest)).toString());
                }

            }
_L11:
            if(mRequestMessagesPending != 0) {
                Log.e("RILJ", (new StringBuilder()).append("ERROR: mReqPending is NOT 0 but").append(mRequestMessagesPending).append(" at TIMEOUT, reset!").toString());
                mRequestMessagesPending = 0;
            }
            mWakeLock.release();
_L9:
            wakelock;
            JVM INSTR monitorexit ;
            if(true) goto _L1; else goto _L12
_L12:
            Exception exception;
            exception;
            throw exception;
            exception1;
            arraylist;
            JVM INSTR monitorexit ;
            throw exception1;
        }

        public void run() {
        }

        byte dataLength[];
        final RIL this$0;

        public RILSender(Looper looper) {
            this$0 = RIL.this;
            super(looper);
            dataLength = new byte[4];
        }
    }


    public RIL(Context context, int i, int j) {
        super(context);
        mRequestsList = new ArrayList();
        mTestingEmergencyCall = new AtomicBoolean(false);
        mIntentReceiver = new BroadcastReceiver() {

            public void onReceive(Context context1, Intent intent) {
                if(intent.getAction().equals("android.intent.action.SCREEN_ON"))
                    sendScreenState(true);
                else
                if(intent.getAction().equals("android.intent.action.SCREEN_OFF"))
                    sendScreenState(false);
                else
                    Log.w("RILJ", (new StringBuilder()).append("RIL received unexpected Intent: ").append(intent.getAction()).toString());
            }

            final RIL this$0;

             {
                this$0 = RIL.this;
                super();
            }
        };
        riljLog((new StringBuilder()).append("RIL(context, preferredNetworkType=").append(i).append(" cdmaSubscription=").append(j).append(")").toString());
        super.mCdmaSubscription = j;
        super.mPreferredNetworkType = i;
        super.mPhoneType = 0;
        mWakeLock = ((PowerManager)context.getSystemService("power")).newWakeLock(1, "RILJ");
        mWakeLock.setReferenceCounted(false);
        mWakeLockTimeout = SystemProperties.getInt("ro.ril.wake_lock_timeout", 60000);
        mRequestMessagesPending = 0;
        mRequestMessagesWaiting = 0;
        mSenderThread = new HandlerThread("RILSender");
        mSenderThread.start();
        mSender = new RILSender(mSenderThread.getLooper());
        if(!((ConnectivityManager)context.getSystemService("connectivity")).isNetworkSupported(0)) {
            riljLog("Not starting RILReceiver: wifi-only");
        } else {
            riljLog("Starting RILReceiver");
            mReceiver = new RILReceiver();
            mReceiverThread = new Thread(mReceiver, "RILReceiver");
            mReceiverThread.start();
            IntentFilter intentfilter = new IntentFilter();
            intentfilter.addAction("android.intent.action.SCREEN_ON");
            intentfilter.addAction("android.intent.action.SCREEN_OFF");
            context.registerReceiver(mIntentReceiver, intentfilter);
        }
    }

    private void acquireWakeLock() {
        android.os.PowerManager.WakeLock wakelock = mWakeLock;
        wakelock;
        JVM INSTR monitorenter ;
        mWakeLock.acquire();
        mRequestMessagesPending = 1 + mRequestMessagesPending;
        mSender.removeMessages(2);
        Message message = mSender.obtainMessage(2);
        mSender.sendMessageDelayed(message, mWakeLockTimeout);
        return;
    }

    private void clearRequestsList(int i, boolean flag) {
        ArrayList arraylist = mRequestsList;
        arraylist;
        JVM INSTR monitorenter ;
        int j = mRequestsList.size();
        int k;
        if(flag)
            Log.d("RILJ", (new StringBuilder()).append("WAKE_LOCK_TIMEOUT  mReqPending=").append(mRequestMessagesPending).append(" mRequestList=").append(j).toString());
        k = 0;
        while(true)  {
            for(; k < j; k++) {
                RILRequest rilrequest = (RILRequest)mRequestsList.get(k);
                if(flag)
                    Log.d("RILJ", (new StringBuilder()).append(k).append(": [").append(rilrequest.mSerial).append("] ").append(requestToString(rilrequest.mRequest)).toString());
                rilrequest.onError(i, null);
                rilrequest.release();
            }

            mRequestsList.clear();
            mRequestMessagesWaiting = 0;
            return;
        }
    }

    private RILRequest findAndRemoveRequestFromList(int i) {
        ArrayList arraylist = mRequestsList;
        arraylist;
        JVM INSTR monitorenter ;
        int j = 0;
        int k = mRequestsList.size();
        do {
label0:
            {
                RILRequest rilrequest;
                if(j < k) {
                    rilrequest = (RILRequest)mRequestsList.get(j);
                    if(rilrequest.mSerial != i)
                        break label0;
                    mRequestsList.remove(j);
                    if(mRequestMessagesWaiting > 0)
                        mRequestMessagesWaiting = -1 + mRequestMessagesWaiting;
                } else {
                    rilrequest = null;
                }
                return rilrequest;
            }
            j++;
        } while(true);
    }

    private DataCallState getDataCallState(Parcel parcel, int i) {
        DataCallState datacallstate;
        datacallstate = new DataCallState();
        datacallstate.version = i;
        if(i >= 5) goto _L2; else goto _L1
_L1:
        datacallstate.cid = parcel.readInt();
        datacallstate.active = parcel.readInt();
        datacallstate.type = parcel.readString();
        String s3 = parcel.readString();
        if(!TextUtils.isEmpty(s3))
            datacallstate.addresses = s3.split(" ");
_L4:
        return datacallstate;
_L2:
        datacallstate.status = parcel.readInt();
        datacallstate.suggestedRetryTime = parcel.readInt();
        datacallstate.cid = parcel.readInt();
        datacallstate.active = parcel.readInt();
        datacallstate.type = parcel.readString();
        datacallstate.ifname = parcel.readString();
        if(datacallstate.status == DataConnection.FailCause.NONE.getErrorCode() && TextUtils.isEmpty(datacallstate.ifname))
            throw new RuntimeException("getDataCallState, no ifname");
        String s = parcel.readString();
        if(!TextUtils.isEmpty(s))
            datacallstate.addresses = s.split(" ");
        String s1 = parcel.readString();
        if(!TextUtils.isEmpty(s1))
            datacallstate.dnses = s1.split(" ");
        String s2 = parcel.readString();
        if(!TextUtils.isEmpty(s2))
            datacallstate.gateways = s2.split(" ");
        if(true) goto _L4; else goto _L3
_L3:
    }

    private CommandsInterface.RadioState getRadioStateFromInt(int i) {
        i;
        JVM INSTR lookupswitch 3: default 36
    //                   0: 64
    //                   1: 70
    //                   10: 77;
           goto _L1 _L2 _L3 _L4
_L1:
        throw new RuntimeException((new StringBuilder()).append("Unrecognized RIL_RadioState: ").append(i).toString());
_L2:
        CommandsInterface.RadioState radiostate = CommandsInterface.RadioState.RADIO_OFF;
_L6:
        return radiostate;
_L3:
        radiostate = CommandsInterface.RadioState.RADIO_UNAVAILABLE;
        continue; /* Loop/switch isn't completed */
_L4:
        radiostate = CommandsInterface.RadioState.RADIO_ON;
        if(true) goto _L6; else goto _L5
_L5:
    }

    private void notifyRegistrantsCdmaInfoRec(CdmaInformationRecords cdmainformationrecords) {
        if(!(cdmainformationrecords.record instanceof com.android.internal.telephony.cdma.CdmaInformationRecords.CdmaDisplayInfoRec)) goto _L2; else goto _L1
_L1:
        if(super.mDisplayInfoRegistrants != null) {
            unsljLogRet(1027, cdmainformationrecords.record);
            super.mDisplayInfoRegistrants.notifyRegistrants(new AsyncResult(null, cdmainformationrecords.record, null));
        }
_L4:
        return;
_L2:
        if(cdmainformationrecords.record instanceof com.android.internal.telephony.cdma.CdmaInformationRecords.CdmaSignalInfoRec) {
            if(super.mSignalInfoRegistrants != null) {
                unsljLogRet(1027, cdmainformationrecords.record);
                super.mSignalInfoRegistrants.notifyRegistrants(new AsyncResult(null, cdmainformationrecords.record, null));
            }
        } else
        if(cdmainformationrecords.record instanceof com.android.internal.telephony.cdma.CdmaInformationRecords.CdmaNumberInfoRec) {
            if(super.mNumberInfoRegistrants != null) {
                unsljLogRet(1027, cdmainformationrecords.record);
                super.mNumberInfoRegistrants.notifyRegistrants(new AsyncResult(null, cdmainformationrecords.record, null));
            }
        } else
        if(cdmainformationrecords.record instanceof com.android.internal.telephony.cdma.CdmaInformationRecords.CdmaRedirectingNumberInfoRec) {
            if(super.mRedirNumInfoRegistrants != null) {
                unsljLogRet(1027, cdmainformationrecords.record);
                super.mRedirNumInfoRegistrants.notifyRegistrants(new AsyncResult(null, cdmainformationrecords.record, null));
            }
        } else
        if(cdmainformationrecords.record instanceof com.android.internal.telephony.cdma.CdmaInformationRecords.CdmaLineControlInfoRec) {
            if(super.mLineControlInfoRegistrants != null) {
                unsljLogRet(1027, cdmainformationrecords.record);
                super.mLineControlInfoRegistrants.notifyRegistrants(new AsyncResult(null, cdmainformationrecords.record, null));
            }
        } else
        if(cdmainformationrecords.record instanceof com.android.internal.telephony.cdma.CdmaInformationRecords.CdmaT53ClirInfoRec) {
            if(super.mT53ClirInfoRegistrants != null) {
                unsljLogRet(1027, cdmainformationrecords.record);
                super.mT53ClirInfoRegistrants.notifyRegistrants(new AsyncResult(null, cdmainformationrecords.record, null));
            }
        } else
        if((cdmainformationrecords.record instanceof com.android.internal.telephony.cdma.CdmaInformationRecords.CdmaT53AudioControlInfoRec) && super.mT53AudCntrlInfoRegistrants != null) {
            unsljLogRet(1027, cdmainformationrecords.record);
            super.mT53AudCntrlInfoRegistrants.notifyRegistrants(new AsyncResult(null, cdmainformationrecords.record, null));
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void notifyRegistrantsRilConnectionChanged(int i) {
        super.mRilVersion = i;
        if(super.mRilConnectedRegistrants != null)
            super.mRilConnectedRegistrants.notifyRegistrants(new AsyncResult(null, new Integer(i), null));
    }

    private void processResponse(Parcel parcel) {
        int i = parcel.readInt();
        if(i != 1) goto _L2; else goto _L1
_L1:
        processUnsolicited(parcel);
_L4:
        releaseWakeLockIfDone();
        return;
_L2:
        if(i == 0)
            processSolicited(parcel);
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void processSolicited(Parcel parcel) {
        int i;
        int j;
        RILRequest rilrequest;
        i = parcel.readInt();
        j = parcel.readInt();
        rilrequest = findAndRemoveRequestFromList(i);
        if(rilrequest != null) goto _L2; else goto _L1
_L1:
        Log.w("RILJ", (new StringBuilder()).append("Unexpected solicited response! sn: ").append(i).append(" error: ").append(j).toString());
_L115:
        return;
_L2:
        Object obj = null;
        if(j != 0 && parcel.dataAvail() <= 0) goto _L4; else goto _L3
_L3:
        rilrequest.mRequest;
        JVM INSTR tableswitch 1 108: default 524
    //                   1 643
    //                   2 674
    //                   3 684
    //                   4 694
    //                   5 704
    //                   6 714
    //                   7 724
    //                   8 734
    //                   9 744
    //                   10 754
    //                   11 764
    //                   12 774
    //                   13 784
    //                   14 794
    //                   15 836
    //                   16 846
    //                   17 856
    //                   18 866
    //                   19 876
    //                   20 886
    //                   21 896
    //                   22 906
    //                   23 916
    //                   24 926
    //                   25 936
    //                   26 946
    //                   27 956
    //                   28 966
    //                   29 976
    //                   30 986
    //                   31 996
    //                   32 1006
    //                   33 1016
    //                   34 1026
    //                   35 1036
    //                   36 1046
    //                   37 1056
    //                   38 1066
    //                   39 1076
    //                   40 1086
    //                   41 1096
    //                   42 1106
    //                   43 1116
    //                   44 1126
    //                   45 1136
    //                   46 1146
    //                   47 1156
    //                   48 1166
    //                   49 1176
    //                   50 1186
    //                   51 1196
    //                   52 1206
    //                   53 1216
    //                   54 1226
    //                   55 1236
    //                   56 1246
    //                   57 1256
    //                   58 1266
    //                   59 1276
    //                   60 1286
    //                   61 1296
    //                   62 1306
    //                   63 1316
    //                   64 1326
    //                   65 1336
    //                   66 1346
    //                   67 1356
    //                   68 1366
    //                   69 1376
    //                   70 1386
    //                   71 1396
    //                   72 1406
    //                   73 1416
    //                   74 1426
    //                   75 1436
    //                   76 1446
    //                   77 1456
    //                   78 1466
    //                   79 1476
    //                   80 1486
    //                   81 1496
    //                   82 1506
    //                   83 1516
    //                   84 1526
    //                   85 1536
    //                   86 1626
    //                   87 1546
    //                   88 1556
    //                   89 1566
    //                   90 1576
    //                   91 1586
    //                   92 1596
    //                   93 1606
    //                   94 1616
    //                   95 1636
    //                   96 1646
    //                   97 1656
    //                   98 1666
    //                   99 1696
    //                   100 1676
    //                   101 1686
    //                   102 1706
    //                   103 1716
    //                   104 1726
    //                   105 1736
    //                   106 1746
    //                   107 1756
    //                   108 1766;
           goto _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36 _L37 _L38 _L39 _L40 _L41 _L42 _L43 _L44 _L45 _L46 _L47 _L48 _L49 _L50 _L51 _L52 _L53 _L54 _L55 _L56 _L57 _L58 _L59 _L60 _L61 _L62 _L63 _L64 _L65 _L66 _L67 _L68 _L69 _L70 _L71 _L72 _L73 _L74 _L75 _L76 _L77 _L78 _L79 _L80 _L81 _L82 _L83 _L84 _L85 _L86 _L87 _L88 _L89 _L90 _L91 _L92 _L93 _L94 _L95 _L96 _L97 _L98 _L99 _L100 _L101 _L102 _L103 _L104 _L105 _L106 _L107 _L108 _L109 _L110 _L111 _L112 _L113
_L5:
        throw new RuntimeException((new StringBuilder()).append("Unrecognized solicited response: ").append(rilrequest.mRequest).toString());
        Throwable throwable;
        throwable;
        Log.w("RILJ", (new StringBuilder()).append(rilrequest.serialString()).append("< ").append(requestToString(rilrequest.mRequest)).append(" exception, possible invalid RIL response").toString(), throwable);
        if(rilrequest.mResult != null) {
            AsyncResult.forMessage(rilrequest.mResult, null, throwable);
            rilrequest.mResult.sendToTarget();
        }
        rilrequest.release();
          goto _L114
_L6:
        Object obj2 = responseIccCardStatus(parcel);
        obj = obj2;
_L4:
        Object obj1;
        if(j != 0) {
            rilrequest.onError(j, obj);
            rilrequest.release();
        } else {
            riljLog((new StringBuilder()).append(rilrequest.serialString()).append("< ").append(requestToString(rilrequest.mRequest)).append(" ").append(retToString(rilrequest.mRequest, obj)).toString());
            if(rilrequest.mResult != null) {
                AsyncResult.forMessage(rilrequest.mResult, obj, null);
                rilrequest.mResult.sendToTarget();
            }
            rilrequest.release();
        }
_L114:
        if(true) goto _L115; else goto _L7
_L7:
        obj = responseInts(parcel);
          goto _L4
_L8:
        obj = responseInts(parcel);
          goto _L4
_L9:
        obj = responseInts(parcel);
          goto _L4
_L10:
        obj = responseInts(parcel);
          goto _L4
_L11:
        obj = responseInts(parcel);
          goto _L4
_L12:
        obj = responseInts(parcel);
          goto _L4
_L13:
        obj = responseInts(parcel);
          goto _L4
_L14:
        obj = responseCallList(parcel);
          goto _L4
_L15:
        obj = responseVoid(parcel);
          goto _L4
_L16:
        obj = responseString(parcel);
          goto _L4
_L17:
        obj = responseVoid(parcel);
          goto _L4
_L18:
        obj = responseVoid(parcel);
          goto _L4
_L19:
        if(mTestingEmergencyCall.getAndSet(false) && super.mEmergencyCallbackModeRegistrant != null) {
            riljLog("testing emergency call, notify ECM Registrants");
            super.mEmergencyCallbackModeRegistrant.notifyRegistrant();
        }
        obj = responseVoid(parcel);
          goto _L4
_L20:
        obj = responseVoid(parcel);
          goto _L4
_L21:
        obj = responseVoid(parcel);
          goto _L4
_L22:
        obj = responseVoid(parcel);
          goto _L4
_L23:
        obj = responseInts(parcel);
          goto _L4
_L24:
        obj = responseSignalStrength(parcel);
          goto _L4
_L25:
        obj = responseStrings(parcel);
          goto _L4
_L26:
        obj = responseStrings(parcel);
          goto _L4
_L27:
        obj = responseStrings(parcel);
          goto _L4
_L28:
        obj = responseVoid(parcel);
          goto _L4
_L29:
        obj = responseVoid(parcel);
          goto _L4
_L30:
        obj = responseSMS(parcel);
          goto _L4
_L31:
        obj = responseSMS(parcel);
          goto _L4
_L32:
        obj = responseSetupDataCall(parcel);
          goto _L4
_L33:
        obj = responseICC_IO(parcel);
          goto _L4
_L34:
        obj = responseVoid(parcel);
          goto _L4
_L35:
        obj = responseVoid(parcel);
          goto _L4
_L36:
        obj = responseInts(parcel);
          goto _L4
_L37:
        obj = responseVoid(parcel);
          goto _L4
_L38:
        obj = responseCallForward(parcel);
          goto _L4
_L39:
        obj = responseVoid(parcel);
          goto _L4
_L40:
        obj = responseInts(parcel);
          goto _L4
_L41:
        obj = responseVoid(parcel);
          goto _L4
_L42:
        obj = responseVoid(parcel);
          goto _L4
_L43:
        obj = responseString(parcel);
          goto _L4
_L44:
        obj = responseString(parcel);
          goto _L4
_L45:
        obj = responseVoid(parcel);
          goto _L4
_L46:
        obj = responseVoid(parcel);
          goto _L4
_L47:
        obj = responseInts(parcel);
          goto _L4
_L48:
        obj = responseInts(parcel);
          goto _L4
_L49:
        obj = responseVoid(parcel);
          goto _L4
_L50:
        obj = responseInts(parcel);
          goto _L4
_L51:
        obj = responseVoid(parcel);
          goto _L4
_L52:
        obj = responseVoid(parcel);
          goto _L4
_L53:
        obj = responseOperatorInfos(parcel);
          goto _L4
_L54:
        obj = responseVoid(parcel);
          goto _L4
_L55:
        obj = responseVoid(parcel);
          goto _L4
_L56:
        obj = responseString(parcel);
          goto _L4
_L57:
        obj = responseVoid(parcel);
          goto _L4
_L58:
        obj = responseVoid(parcel);
          goto _L4
_L59:
        obj = responseInts(parcel);
          goto _L4
_L60:
        obj = responseInts(parcel);
          goto _L4
_L61:
        obj = responseInts(parcel);
          goto _L4
_L62:
        obj = responseDataCallList(parcel);
          goto _L4
_L63:
        obj = responseVoid(parcel);
          goto _L4
_L64:
        obj = responseRaw(parcel);
          goto _L4
_L65:
        obj = responseStrings(parcel);
          goto _L4
_L66:
        obj = responseVoid(parcel);
          goto _L4
_L67:
        obj = responseVoid(parcel);
          goto _L4
_L68:
        obj = responseInts(parcel);
          goto _L4
_L69:
        obj = responseVoid(parcel);
          goto _L4
_L70:
        obj = responseVoid(parcel);
          goto _L4
_L71:
        obj = responseInts(parcel);
          goto _L4
_L72:
        obj = responseString(parcel);
          goto _L4
_L73:
        obj = responseVoid(parcel);
          goto _L4
_L74:
        obj = responseString(parcel);
          goto _L4
_L75:
        obj = responseVoid(parcel);
          goto _L4
_L76:
        obj = responseInts(parcel);
          goto _L4
_L77:
        obj = responseVoid(parcel);
          goto _L4
_L78:
        obj = responseVoid(parcel);
          goto _L4
_L79:
        obj = responseGetPreferredNetworkType(parcel);
          goto _L4
_L80:
        obj = responseCellList(parcel);
          goto _L4
_L81:
        obj = responseVoid(parcel);
          goto _L4
_L82:
        obj = responseVoid(parcel);
          goto _L4
_L83:
        obj = responseVoid(parcel);
          goto _L4
_L84:
        obj = responseInts(parcel);
          goto _L4
_L85:
        obj = responseVoid(parcel);
          goto _L4
_L86:
        obj = responseInts(parcel);
          goto _L4
_L87:
        obj = responseVoid(parcel);
          goto _L4
_L88:
        obj = responseInts(parcel);
          goto _L4
_L89:
        obj = responseVoid(parcel);
          goto _L4
_L90:
        obj = responseVoid(parcel);
          goto _L4
_L92:
        obj = responseSMS(parcel);
          goto _L4
_L93:
        obj = responseVoid(parcel);
          goto _L4
_L94:
        obj = responseGmsBroadcastConfig(parcel);
          goto _L4
_L95:
        obj = responseVoid(parcel);
          goto _L4
_L96:
        obj = responseVoid(parcel);
          goto _L4
_L97:
        obj = responseCdmaBroadcastConfig(parcel);
          goto _L4
_L98:
        obj = responseVoid(parcel);
          goto _L4
_L99:
        obj = responseVoid(parcel);
          goto _L4
_L91:
        obj = responseVoid(parcel);
          goto _L4
_L100:
        obj = responseStrings(parcel);
          goto _L4
_L101:
        obj = responseInts(parcel);
          goto _L4
_L102:
        obj = responseVoid(parcel);
          goto _L4
_L103:
        obj = responseStrings(parcel);
          goto _L4
_L105:
        obj = responseString(parcel);
          goto _L4
_L106:
        obj = responseVoid(parcel);
          goto _L4
_L104:
        obj = responseVoid(parcel);
          goto _L4
_L107:
        obj = responseVoid(parcel);
          goto _L4
_L108:
        obj = responseVoid(parcel);
          goto _L4
_L109:
        obj = responseInts(parcel);
          goto _L4
_L110:
        obj = responseString(parcel);
          goto _L4
_L111:
        obj = responseVoid(parcel);
          goto _L4
_L112:
        obj = responseICC_IO(parcel);
          goto _L4
_L113:
        obj1 = responseInts(parcel);
        obj = obj1;
          goto _L4
    }

    private void processUnsolicited(Parcel parcel) {
        int i = parcel.readInt();
        i;
        JVM INSTR tableswitch 1000 1035: default 164
    //                   1000 235
    //                   1001 436
    //                   1002 446
    //                   1003 456
    //                   1004 466
    //                   1005 476
    //                   1006 486
    //                   1007 164
    //                   1008 496
    //                   1009 506
    //                   1010 516
    //                   1011 526
    //                   1012 536
    //                   1013 546
    //                   1014 556
    //                   1015 566
    //                   1016 576
    //                   1017 586
    //                   1018 596
    //                   1019 616
    //                   1020 626
    //                   1021 636
    //                   1022 646
    //                   1023 606
    //                   1024 656
    //                   1025 666
    //                   1026 676
    //                   1027 686
    //                   1028 696
    //                   1029 706
    //                   1030 716
    //                   1031 726
    //                   1032 736
    //                   1033 746
    //                   1034 756
    //                   1035 766;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L1 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36
_L1:
        try {
            throw new RuntimeException((new StringBuilder()).append("Unrecognized unsol response: ").append(i).toString());
        }
        catch(Throwable throwable) {
            Log.e("RILJ", (new StringBuilder()).append("Exception processing unsol response: ").append(i).append("Exception:").append(throwable.toString()).toString());
        }
_L39:
        return;
_L2:
        Object obj2 = responseVoid(parcel);
        Object obj1 = obj2;
_L37:
        Object obj;
        switch(i) {
        case 1007: 
        default:
            break;

        case 1000: 
            CommandsInterface.RadioState radiostate = getRadioStateFromInt(parcel.readInt());
            unsljLogMore(i, radiostate.toString());
            switchToRadioState(radiostate);
            continue; /* Loop/switch isn't completed */

        case 1001: 
            unsljLog(i);
            super.mCallStateRegistrants.notifyRegistrants(new AsyncResult(null, null, null));
            continue; /* Loop/switch isn't completed */

        case 1002: 
            unsljLog(i);
            super.mVoiceNetworkStateRegistrants.notifyRegistrants(new AsyncResult(null, null, null));
            continue; /* Loop/switch isn't completed */

        case 1003: 
            unsljLog(i);
            String as1[] = new String[2];
            as1[1] = (String)obj1;
            SmsMessage smsmessage1 = SmsMessage.newFromCMT(as1);
            if(super.mGsmSmsRegistrant != null) {
                Registrant registrant15 = super.mGsmSmsRegistrant;
                AsyncResult asyncresult23 = new AsyncResult(null, smsmessage1, null);
                registrant15.notifyRegistrant(asyncresult23);
            }
            continue; /* Loop/switch isn't completed */

        case 1004: 
            unsljLogRet(i, obj1);
            if(super.mSmsStatusRegistrant != null) {
                Registrant registrant14 = super.mSmsStatusRegistrant;
                AsyncResult asyncresult22 = new AsyncResult(null, obj1, null);
                registrant14.notifyRegistrant(asyncresult22);
            }
            continue; /* Loop/switch isn't completed */

        case 1005: 
            unsljLogRet(i, obj1);
            int ai[] = (int[])(int[])obj1;
            if(ai.length == 1) {
                if(super.mSmsOnSimRegistrant != null) {
                    Registrant registrant13 = super.mSmsOnSimRegistrant;
                    AsyncResult asyncresult21 = new AsyncResult(null, ai, null);
                    registrant13.notifyRegistrant(asyncresult21);
                }
            } else {
                riljLog((new StringBuilder()).append(" NEW_SMS_ON_SIM ERROR with wrong length ").append(ai.length).toString());
            }
            continue; /* Loop/switch isn't completed */

        case 1006: 
            String as[] = (String[])(String[])obj1;
            if(as.length < 2) {
                as = new String[2];
                as[0] = ((String[])(String[])obj1)[0];
                as[1] = null;
            }
            unsljLogMore(i, as[0]);
            if(super.mUSSDRegistrant != null) {
                Registrant registrant12 = super.mUSSDRegistrant;
                AsyncResult asyncresult20 = new AsyncResult(null, as, null);
                registrant12.notifyRegistrant(asyncresult20);
            }
            continue; /* Loop/switch isn't completed */

        case 1008: 
            unsljLogRet(i, obj1);
            long l = parcel.readLong();
            Object aobj[] = new Object[2];
            aobj[0] = obj1;
            aobj[1] = Long.valueOf(l);
            if(SystemProperties.getBoolean("telephony.test.ignore.nitz", false))
                riljLog("ignoring UNSOL_NITZ_TIME_RECEIVED");
            else
            if(super.mNITZTimeRegistrant != null) {
                Registrant registrant11 = super.mNITZTimeRegistrant;
                AsyncResult asyncresult19 = new AsyncResult(null, ((Object) (aobj)), null);
                registrant11.notifyRegistrant(asyncresult19);
            } else {
                mLastNITZTimeInfo = ((Object) (aobj));
            }
            continue; /* Loop/switch isn't completed */

        case 1009: 
            if(super.mSignalStrengthRegistrant != null) {
                Registrant registrant10 = super.mSignalStrengthRegistrant;
                AsyncResult asyncresult18 = new AsyncResult(null, obj1, null);
                registrant10.notifyRegistrant(asyncresult18);
            }
            continue; /* Loop/switch isn't completed */

        case 1010: 
            unsljLogRet(i, obj1);
            RegistrantList registrantlist7 = super.mDataNetworkStateRegistrants;
            AsyncResult asyncresult17 = new AsyncResult(null, obj1, null);
            registrantlist7.notifyRegistrants(asyncresult17);
            continue; /* Loop/switch isn't completed */

        case 1011: 
            unsljLogRet(i, obj1);
            if(super.mSsnRegistrant != null) {
                Registrant registrant9 = super.mSsnRegistrant;
                AsyncResult asyncresult16 = new AsyncResult(null, obj1, null);
                registrant9.notifyRegistrant(asyncresult16);
            }
            continue; /* Loop/switch isn't completed */

        case 1012: 
            unsljLog(i);
            if(super.mCatSessionEndRegistrant != null) {
                Registrant registrant8 = super.mCatSessionEndRegistrant;
                AsyncResult asyncresult15 = new AsyncResult(null, obj1, null);
                registrant8.notifyRegistrant(asyncresult15);
            }
            continue; /* Loop/switch isn't completed */

        case 1013: 
            unsljLogRet(i, obj1);
            if(super.mCatProCmdRegistrant != null) {
                Registrant registrant7 = super.mCatProCmdRegistrant;
                AsyncResult asyncresult14 = new AsyncResult(null, obj1, null);
                registrant7.notifyRegistrant(asyncresult14);
            }
            continue; /* Loop/switch isn't completed */

        case 1014: 
            unsljLogRet(i, obj1);
            if(super.mCatEventRegistrant != null) {
                Registrant registrant6 = super.mCatEventRegistrant;
                AsyncResult asyncresult13 = new AsyncResult(null, obj1, null);
                registrant6.notifyRegistrant(asyncresult13);
            }
            continue; /* Loop/switch isn't completed */

        case 1015: 
            unsljLogRet(i, obj1);
            if(super.mCatCallSetUpRegistrant != null) {
                Registrant registrant5 = super.mCatCallSetUpRegistrant;
                AsyncResult asyncresult12 = new AsyncResult(null, obj1, null);
                registrant5.notifyRegistrant(asyncresult12);
            }
            continue; /* Loop/switch isn't completed */

        case 1016: 
            unsljLog(i);
            if(super.mIccSmsFullRegistrant != null)
                super.mIccSmsFullRegistrant.notifyRegistrant();
            continue; /* Loop/switch isn't completed */

        case 1017: 
            unsljLogRet(i, obj1);
            if(super.mIccRefreshRegistrants != null) {
                RegistrantList registrantlist6 = super.mIccRefreshRegistrants;
                AsyncResult asyncresult11 = new AsyncResult(null, obj1, null);
                registrantlist6.notifyRegistrants(asyncresult11);
            }
            continue; /* Loop/switch isn't completed */

        case 1018: 
            unsljLogRet(i, obj1);
            if(super.mRingRegistrant != null) {
                Registrant registrant4 = super.mRingRegistrant;
                AsyncResult asyncresult10 = new AsyncResult(null, obj1, null);
                registrant4.notifyRegistrant(asyncresult10);
            }
            continue; /* Loop/switch isn't completed */

        case 1023: 
            unsljLogvRet(i, obj1);
            if(super.mRestrictedStateRegistrant != null) {
                Registrant registrant3 = super.mRestrictedStateRegistrant;
                AsyncResult asyncresult9 = new AsyncResult(null, obj1, null);
                registrant3.notifyRegistrant(asyncresult9);
            }
            continue; /* Loop/switch isn't completed */

        case 1019: 
            unsljLog(i);
            if(super.mIccStatusChangedRegistrants != null)
                super.mIccStatusChangedRegistrants.notifyRegistrants();
            continue; /* Loop/switch isn't completed */

        case 1020: 
            unsljLog(i);
            SmsMessage smsmessage = (SmsMessage)obj1;
            if(super.mCdmaSmsRegistrant != null) {
                Registrant registrant2 = super.mCdmaSmsRegistrant;
                AsyncResult asyncresult8 = new AsyncResult(null, smsmessage, null);
                registrant2.notifyRegistrant(asyncresult8);
            }
            continue; /* Loop/switch isn't completed */

        case 1021: 
            unsljLog(i);
            if(super.mGsmBroadcastSmsRegistrant != null) {
                Registrant registrant1 = super.mGsmBroadcastSmsRegistrant;
                AsyncResult asyncresult7 = new AsyncResult(null, obj1, null);
                registrant1.notifyRegistrant(asyncresult7);
            }
            continue; /* Loop/switch isn't completed */

        case 1022: 
            unsljLog(i);
            if(super.mIccSmsFullRegistrant != null)
                super.mIccSmsFullRegistrant.notifyRegistrant();
            continue; /* Loop/switch isn't completed */

        case 1024: 
            unsljLog(i);
            if(super.mEmergencyCallbackModeRegistrant != null)
                super.mEmergencyCallbackModeRegistrant.notifyRegistrant();
            continue; /* Loop/switch isn't completed */

        case 1025: 
            unsljLogRet(i, obj1);
            if(super.mCallWaitingInfoRegistrants != null) {
                RegistrantList registrantlist5 = super.mCallWaitingInfoRegistrants;
                AsyncResult asyncresult6 = new AsyncResult(null, obj1, null);
                registrantlist5.notifyRegistrants(asyncresult6);
            }
            continue; /* Loop/switch isn't completed */

        case 1026: 
            unsljLogRet(i, obj1);
            if(super.mOtaProvisionRegistrants != null) {
                RegistrantList registrantlist4 = super.mOtaProvisionRegistrants;
                AsyncResult asyncresult5 = new AsyncResult(null, obj1, null);
                registrantlist4.notifyRegistrants(asyncresult5);
            }
            continue; /* Loop/switch isn't completed */

        case 1027: 
            ArrayList arraylist;
            Iterator iterator;
            try {
                arraylist = (ArrayList)obj1;
            }
            catch(ClassCastException classcastexception) {
                Log.e("RILJ", "Unexpected exception casting to listInfoRecs", classcastexception);
                continue; /* Loop/switch isn't completed */
            }
            iterator = arraylist.iterator();
            while(iterator.hasNext())  {
                CdmaInformationRecords cdmainformationrecords = (CdmaInformationRecords)iterator.next();
                unsljLogRet(i, cdmainformationrecords);
                notifyRegistrantsCdmaInfoRec(cdmainformationrecords);
            }
            continue; /* Loop/switch isn't completed */

        case 1028: 
            unsljLogvRet(i, IccUtils.bytesToHexString((byte[])(byte[])obj1));
            if(super.mUnsolOemHookRawRegistrant != null) {
                Registrant registrant = super.mUnsolOemHookRawRegistrant;
                AsyncResult asyncresult4 = new AsyncResult(null, obj1, null);
                registrant.notifyRegistrant(asyncresult4);
            }
            break;

        case 1029: 
            unsljLogvRet(i, obj1);
            if(super.mRingbackToneRegistrants != null) {
                boolean flag;
                if(((int[])(int[])obj1)[0] == 1)
                    flag = true;
                else
                    flag = false;
                super.mRingbackToneRegistrants.notifyRegistrants(new AsyncResult(null, Boolean.valueOf(flag), null));
            }
            break;

        case 1030: 
            unsljLogRet(i, obj1);
            if(super.mResendIncallMuteRegistrants != null) {
                RegistrantList registrantlist3 = super.mResendIncallMuteRegistrants;
                AsyncResult asyncresult3 = new AsyncResult(null, obj1, null);
                registrantlist3.notifyRegistrants(asyncresult3);
            }
            break;

        case 1035: 
            unsljLogRet(i, obj1);
            if(super.mVoiceRadioTechChangedRegistrants != null) {
                RegistrantList registrantlist2 = super.mVoiceRadioTechChangedRegistrants;
                AsyncResult asyncresult2 = new AsyncResult(null, obj1, null);
                registrantlist2.notifyRegistrants(asyncresult2);
            }
            break;

        case 1031: 
            unsljLogRet(i, obj1);
            if(super.mCdmaSubscriptionChangedRegistrants != null) {
                RegistrantList registrantlist1 = super.mCdmaSubscriptionChangedRegistrants;
                AsyncResult asyncresult1 = new AsyncResult(null, obj1, null);
                registrantlist1.notifyRegistrants(asyncresult1);
            }
            break;

        case 1032: 
            unsljLogRet(i, obj1);
            if(super.mCdmaPrlChangedRegistrants != null) {
                RegistrantList registrantlist = super.mCdmaPrlChangedRegistrants;
                AsyncResult asyncresult = new AsyncResult(null, obj1, null);
                registrantlist.notifyRegistrants(asyncresult);
            }
            break;

        case 1033: 
            unsljLogRet(i, obj1);
            if(super.mExitEmergencyCallbackModeRegistrants != null)
                super.mExitEmergencyCallbackModeRegistrants.notifyRegistrants(new AsyncResult(null, null, null));
            break;

        case 1034: 
            unsljLogRet(i, obj1);
            setRadioPower(false, null);
            setPreferredNetworkType(super.mPreferredNetworkType, null);
            setCdmaSubscriptionSource(super.mCdmaSubscription, null);
            notifyRegistrantsRilConnectionChanged(((int[])(int[])obj1)[0]);
            break;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        obj1 = responseVoid(parcel);
          goto _L37
_L4:
        obj1 = responseVoid(parcel);
          goto _L37
_L5:
        obj1 = responseString(parcel);
          goto _L37
_L6:
        obj1 = responseString(parcel);
          goto _L37
_L7:
        obj1 = responseInts(parcel);
          goto _L37
_L8:
        obj1 = responseStrings(parcel);
          goto _L37
_L9:
        obj1 = responseString(parcel);
          goto _L37
_L10:
        obj1 = responseSignalStrength(parcel);
          goto _L37
_L11:
        obj1 = responseDataCallList(parcel);
          goto _L37
_L12:
        obj1 = responseSuppServiceNotification(parcel);
          goto _L37
_L13:
        obj1 = responseVoid(parcel);
          goto _L37
_L14:
        obj1 = responseString(parcel);
          goto _L37
_L15:
        obj1 = responseString(parcel);
          goto _L37
_L16:
        obj1 = responseInts(parcel);
          goto _L37
_L17:
        obj1 = responseVoid(parcel);
          goto _L37
_L18:
        obj1 = responseSimRefresh(parcel);
          goto _L37
_L19:
        obj1 = responseCallRing(parcel);
          goto _L37
_L24:
        obj1 = responseInts(parcel);
          goto _L37
_L20:
        obj1 = responseVoid(parcel);
          goto _L37
_L21:
        obj1 = responseCdmaSms(parcel);
          goto _L37
_L22:
        obj1 = responseRaw(parcel);
          goto _L37
_L23:
        obj1 = responseVoid(parcel);
          goto _L37
_L25:
        obj1 = responseVoid(parcel);
          goto _L37
_L26:
        obj1 = responseCdmaCallWaiting(parcel);
          goto _L37
_L27:
        obj1 = responseInts(parcel);
          goto _L37
_L28:
        obj1 = responseCdmaInformationRecord(parcel);
          goto _L37
_L29:
        obj1 = responseRaw(parcel);
          goto _L37
_L30:
        obj1 = responseInts(parcel);
          goto _L37
_L31:
        obj1 = responseVoid(parcel);
          goto _L37
_L32:
        obj1 = responseInts(parcel);
          goto _L37
_L33:
        obj1 = responseInts(parcel);
          goto _L37
_L34:
        obj1 = responseVoid(parcel);
          goto _L37
_L35:
        obj1 = responseInts(parcel);
          goto _L37
_L36:
        obj = responseInts(parcel);
        obj1 = obj;
          goto _L37
        if(true) goto _L39; else goto _L38
_L38:
    }

    private static int readRilMessage(InputStream inputstream, byte abyte0[]) throws IOException {
        int i;
        int j;
        i = 0;
        j = 4;
_L2:
        int k = inputstream.read(abyte0, i, j);
        int l;
        if(k < 0) {
            Log.e("RILJ", "Hit EOS reading message length");
            l = -1;
        } else {
            i += k;
            j -= k;
            if(j > 0)
                continue; /* Loop/switch isn't completed */
            l = (0xff & abyte0[0]) << 24 | (0xff & abyte0[1]) << 16 | (0xff & abyte0[2]) << 8 | 0xff & abyte0[3];
            int i1 = 0;
            int j1 = l;
            do {
                int k1 = inputstream.read(abyte0, i1, j1);
                if(k1 < 0) {
                    Log.e("RILJ", (new StringBuilder()).append("Hit EOS reading message.  messageLength=").append(l).append(" remaining=").append(j1).toString());
                    l = -1;
                    break;
                }
                i1 += k1;
                j1 -= k1;
            } while(j1 > 0);
        }
        return l;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private void releaseWakeLockIfDone() {
        android.os.PowerManager.WakeLock wakelock = mWakeLock;
        wakelock;
        JVM INSTR monitorenter ;
        if(mWakeLock.isHeld() && mRequestMessagesPending == 0 && mRequestMessagesWaiting == 0) {
            mSender.removeMessages(2);
            mWakeLock.release();
        }
        return;
    }

    static String requestToString(int i) {
        i;
        JVM INSTR tableswitch 1 108: default 448
    //                   1 454
    //                   2 461
    //                   3 468
    //                   4 475
    //                   5 482
    //                   6 489
    //                   7 496
    //                   8 503
    //                   9 510
    //                   10 517
    //                   11 524
    //                   12 531
    //                   13 538
    //                   14 545
    //                   15 552
    //                   16 559
    //                   17 566
    //                   18 573
    //                   19 580
    //                   20 587
    //                   21 594
    //                   22 601
    //                   23 608
    //                   24 615
    //                   25 622
    //                   26 629
    //                   27 636
    //                   28 643
    //                   29 650
    //                   30 657
    //                   31 664
    //                   32 671
    //                   33 678
    //                   34 685
    //                   35 692
    //                   36 699
    //                   37 706
    //                   38 713
    //                   39 720
    //                   40 727
    //                   41 734
    //                   42 741
    //                   43 748
    //                   44 755
    //                   45 762
    //                   46 769
    //                   47 776
    //                   48 783
    //                   49 790
    //                   50 797
    //                   51 804
    //                   52 811
    //                   53 818
    //                   54 825
    //                   55 832
    //                   56 839
    //                   57 846
    //                   58 853
    //                   59 860
    //                   60 867
    //                   61 874
    //                   62 881
    //                   63 888
    //                   64 895
    //                   65 902
    //                   66 909
    //                   67 916
    //                   68 923
    //                   69 930
    //                   70 937
    //                   71 944
    //                   72 951
    //                   73 958
    //                   74 965
    //                   75 972
    //                   76 979
    //                   77 986
    //                   78 993
    //                   79 1000
    //                   80 1007
    //                   81 1014
    //                   82 1021
    //                   83 1028
    //                   84 1035
    //                   85 1042
    //                   86 1098
    //                   87 1049
    //                   88 1056
    //                   89 1063
    //                   90 1070
    //                   91 1091
    //                   92 1077
    //                   93 1084
    //                   94 1105
    //                   95 1112
    //                   96 1119
    //                   97 1126
    //                   98 1133
    //                   99 1154
    //                   100 1140
    //                   101 1147
    //                   102 1161
    //                   103 1168
    //                   104 1175
    //                   105 1182
    //                   106 1189
    //                   107 1196
    //                   108 1203;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36 _L37 _L38 _L39 _L40 _L41 _L42 _L43 _L44 _L45 _L46 _L47 _L48 _L49 _L50 _L51 _L52 _L53 _L54 _L55 _L56 _L57 _L58 _L59 _L60 _L61 _L62 _L63 _L64 _L65 _L66 _L67 _L68 _L69 _L70 _L71 _L72 _L73 _L74 _L75 _L76 _L77 _L78 _L79 _L80 _L81 _L82 _L83 _L84 _L85 _L86 _L87 _L88 _L89 _L90 _L91 _L92 _L93 _L94 _L95 _L96 _L97 _L98 _L99 _L100 _L101 _L102 _L103 _L104 _L105 _L106 _L107 _L108 _L109
_L1:
        String s = "<unknown request>";
_L111:
        return s;
_L2:
        s = "GET_SIM_STATUS";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "ENTER_SIM_PIN";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "ENTER_SIM_PUK";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "ENTER_SIM_PIN2";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "ENTER_SIM_PUK2";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "CHANGE_SIM_PIN";
        continue; /* Loop/switch isn't completed */
_L8:
        s = "CHANGE_SIM_PIN2";
        continue; /* Loop/switch isn't completed */
_L9:
        s = "ENTER_NETWORK_DEPERSONALIZATION";
        continue; /* Loop/switch isn't completed */
_L10:
        s = "GET_CURRENT_CALLS";
        continue; /* Loop/switch isn't completed */
_L11:
        s = "DIAL";
        continue; /* Loop/switch isn't completed */
_L12:
        s = "GET_IMSI";
        continue; /* Loop/switch isn't completed */
_L13:
        s = "HANGUP";
        continue; /* Loop/switch isn't completed */
_L14:
        s = "HANGUP_WAITING_OR_BACKGROUND";
        continue; /* Loop/switch isn't completed */
_L15:
        s = "HANGUP_FOREGROUND_RESUME_BACKGROUND";
        continue; /* Loop/switch isn't completed */
_L16:
        s = "REQUEST_SWITCH_WAITING_OR_HOLDING_AND_ACTIVE";
        continue; /* Loop/switch isn't completed */
_L17:
        s = "CONFERENCE";
        continue; /* Loop/switch isn't completed */
_L18:
        s = "UDUB";
        continue; /* Loop/switch isn't completed */
_L19:
        s = "LAST_CALL_FAIL_CAUSE";
        continue; /* Loop/switch isn't completed */
_L20:
        s = "SIGNAL_STRENGTH";
        continue; /* Loop/switch isn't completed */
_L21:
        s = "VOICE_REGISTRATION_STATE";
        continue; /* Loop/switch isn't completed */
_L22:
        s = "DATA_REGISTRATION_STATE";
        continue; /* Loop/switch isn't completed */
_L23:
        s = "OPERATOR";
        continue; /* Loop/switch isn't completed */
_L24:
        s = "RADIO_POWER";
        continue; /* Loop/switch isn't completed */
_L25:
        s = "DTMF";
        continue; /* Loop/switch isn't completed */
_L26:
        s = "SEND_SMS";
        continue; /* Loop/switch isn't completed */
_L27:
        s = "SEND_SMS_EXPECT_MORE";
        continue; /* Loop/switch isn't completed */
_L28:
        s = "SETUP_DATA_CALL";
        continue; /* Loop/switch isn't completed */
_L29:
        s = "SIM_IO";
        continue; /* Loop/switch isn't completed */
_L30:
        s = "SEND_USSD";
        continue; /* Loop/switch isn't completed */
_L31:
        s = "CANCEL_USSD";
        continue; /* Loop/switch isn't completed */
_L32:
        s = "GET_CLIR";
        continue; /* Loop/switch isn't completed */
_L33:
        s = "SET_CLIR";
        continue; /* Loop/switch isn't completed */
_L34:
        s = "QUERY_CALL_FORWARD_STATUS";
        continue; /* Loop/switch isn't completed */
_L35:
        s = "SET_CALL_FORWARD";
        continue; /* Loop/switch isn't completed */
_L36:
        s = "QUERY_CALL_WAITING";
        continue; /* Loop/switch isn't completed */
_L37:
        s = "SET_CALL_WAITING";
        continue; /* Loop/switch isn't completed */
_L38:
        s = "SMS_ACKNOWLEDGE";
        continue; /* Loop/switch isn't completed */
_L39:
        s = "GET_IMEI";
        continue; /* Loop/switch isn't completed */
_L40:
        s = "GET_IMEISV";
        continue; /* Loop/switch isn't completed */
_L41:
        s = "ANSWER";
        continue; /* Loop/switch isn't completed */
_L42:
        s = "DEACTIVATE_DATA_CALL";
        continue; /* Loop/switch isn't completed */
_L43:
        s = "QUERY_FACILITY_LOCK";
        continue; /* Loop/switch isn't completed */
_L44:
        s = "SET_FACILITY_LOCK";
        continue; /* Loop/switch isn't completed */
_L45:
        s = "CHANGE_BARRING_PASSWORD";
        continue; /* Loop/switch isn't completed */
_L46:
        s = "QUERY_NETWORK_SELECTION_MODE";
        continue; /* Loop/switch isn't completed */
_L47:
        s = "SET_NETWORK_SELECTION_AUTOMATIC";
        continue; /* Loop/switch isn't completed */
_L48:
        s = "SET_NETWORK_SELECTION_MANUAL";
        continue; /* Loop/switch isn't completed */
_L49:
        s = "QUERY_AVAILABLE_NETWORKS ";
        continue; /* Loop/switch isn't completed */
_L50:
        s = "DTMF_START";
        continue; /* Loop/switch isn't completed */
_L51:
        s = "DTMF_STOP";
        continue; /* Loop/switch isn't completed */
_L52:
        s = "BASEBAND_VERSION";
        continue; /* Loop/switch isn't completed */
_L53:
        s = "SEPARATE_CONNECTION";
        continue; /* Loop/switch isn't completed */
_L54:
        s = "SET_MUTE";
        continue; /* Loop/switch isn't completed */
_L55:
        s = "GET_MUTE";
        continue; /* Loop/switch isn't completed */
_L56:
        s = "QUERY_CLIP";
        continue; /* Loop/switch isn't completed */
_L57:
        s = "LAST_DATA_CALL_FAIL_CAUSE";
        continue; /* Loop/switch isn't completed */
_L58:
        s = "DATA_CALL_LIST";
        continue; /* Loop/switch isn't completed */
_L59:
        s = "RESET_RADIO";
        continue; /* Loop/switch isn't completed */
_L60:
        s = "OEM_HOOK_RAW";
        continue; /* Loop/switch isn't completed */
_L61:
        s = "OEM_HOOK_STRINGS";
        continue; /* Loop/switch isn't completed */
_L62:
        s = "SCREEN_STATE";
        continue; /* Loop/switch isn't completed */
_L63:
        s = "SET_SUPP_SVC_NOTIFICATION";
        continue; /* Loop/switch isn't completed */
_L64:
        s = "WRITE_SMS_TO_SIM";
        continue; /* Loop/switch isn't completed */
_L65:
        s = "DELETE_SMS_ON_SIM";
        continue; /* Loop/switch isn't completed */
_L66:
        s = "SET_BAND_MODE";
        continue; /* Loop/switch isn't completed */
_L67:
        s = "QUERY_AVAILABLE_BAND_MODE";
        continue; /* Loop/switch isn't completed */
_L68:
        s = "REQUEST_STK_GET_PROFILE";
        continue; /* Loop/switch isn't completed */
_L69:
        s = "REQUEST_STK_SET_PROFILE";
        continue; /* Loop/switch isn't completed */
_L70:
        s = "REQUEST_STK_SEND_ENVELOPE_COMMAND";
        continue; /* Loop/switch isn't completed */
_L71:
        s = "REQUEST_STK_SEND_TERMINAL_RESPONSE";
        continue; /* Loop/switch isn't completed */
_L72:
        s = "REQUEST_STK_HANDLE_CALL_SETUP_REQUESTED_FROM_SIM";
        continue; /* Loop/switch isn't completed */
_L73:
        s = "REQUEST_EXPLICIT_CALL_TRANSFER";
        continue; /* Loop/switch isn't completed */
_L74:
        s = "REQUEST_SET_PREFERRED_NETWORK_TYPE";
        continue; /* Loop/switch isn't completed */
_L75:
        s = "REQUEST_GET_PREFERRED_NETWORK_TYPE";
        continue; /* Loop/switch isn't completed */
_L76:
        s = "REQUEST_GET_NEIGHBORING_CELL_IDS";
        continue; /* Loop/switch isn't completed */
_L77:
        s = "REQUEST_SET_LOCATION_UPDATES";
        continue; /* Loop/switch isn't completed */
_L78:
        s = "RIL_REQUEST_CDMA_SET_SUBSCRIPTION_SOURCE";
        continue; /* Loop/switch isn't completed */
_L79:
        s = "RIL_REQUEST_CDMA_SET_ROAMING_PREFERENCE";
        continue; /* Loop/switch isn't completed */
_L80:
        s = "RIL_REQUEST_CDMA_QUERY_ROAMING_PREFERENCE";
        continue; /* Loop/switch isn't completed */
_L81:
        s = "RIL_REQUEST_SET_TTY_MODE";
        continue; /* Loop/switch isn't completed */
_L82:
        s = "RIL_REQUEST_QUERY_TTY_MODE";
        continue; /* Loop/switch isn't completed */
_L83:
        s = "RIL_REQUEST_CDMA_SET_PREFERRED_VOICE_PRIVACY_MODE";
        continue; /* Loop/switch isn't completed */
_L84:
        s = "RIL_REQUEST_CDMA_QUERY_PREFERRED_VOICE_PRIVACY_MODE";
        continue; /* Loop/switch isn't completed */
_L85:
        s = "RIL_REQUEST_CDMA_FLASH";
        continue; /* Loop/switch isn't completed */
_L86:
        s = "RIL_REQUEST_CDMA_BURST_DTMF";
        continue; /* Loop/switch isn't completed */
_L88:
        s = "RIL_REQUEST_CDMA_SEND_SMS";
        continue; /* Loop/switch isn't completed */
_L89:
        s = "RIL_REQUEST_CDMA_SMS_ACKNOWLEDGE";
        continue; /* Loop/switch isn't completed */
_L90:
        s = "RIL_REQUEST_GSM_GET_BROADCAST_CONFIG";
        continue; /* Loop/switch isn't completed */
_L91:
        s = "RIL_REQUEST_GSM_SET_BROADCAST_CONFIG";
        continue; /* Loop/switch isn't completed */
_L93:
        s = "RIL_REQUEST_CDMA_GET_BROADCAST_CONFIG";
        continue; /* Loop/switch isn't completed */
_L94:
        s = "RIL_REQUEST_CDMA_SET_BROADCAST_CONFIG";
        continue; /* Loop/switch isn't completed */
_L92:
        s = "RIL_REQUEST_GSM_BROADCAST_ACTIVATION";
        continue; /* Loop/switch isn't completed */
_L87:
        s = "RIL_REQUEST_CDMA_VALIDATE_AND_WRITE_AKEY";
        continue; /* Loop/switch isn't completed */
_L95:
        s = "RIL_REQUEST_CDMA_BROADCAST_ACTIVATION";
        continue; /* Loop/switch isn't completed */
_L96:
        s = "RIL_REQUEST_CDMA_SUBSCRIPTION";
        continue; /* Loop/switch isn't completed */
_L97:
        s = "RIL_REQUEST_CDMA_WRITE_SMS_TO_RUIM";
        continue; /* Loop/switch isn't completed */
_L98:
        s = "RIL_REQUEST_CDMA_DELETE_SMS_ON_RUIM";
        continue; /* Loop/switch isn't completed */
_L99:
        s = "RIL_REQUEST_DEVICE_IDENTITY";
        continue; /* Loop/switch isn't completed */
_L101:
        s = "RIL_REQUEST_GET_SMSC_ADDRESS";
        continue; /* Loop/switch isn't completed */
_L102:
        s = "RIL_REQUEST_SET_SMSC_ADDRESS";
        continue; /* Loop/switch isn't completed */
_L100:
        s = "REQUEST_EXIT_EMERGENCY_CALLBACK_MODE";
        continue; /* Loop/switch isn't completed */
_L103:
        s = "RIL_REQUEST_REPORT_SMS_MEMORY_STATUS";
        continue; /* Loop/switch isn't completed */
_L104:
        s = "RIL_REQUEST_REPORT_STK_SERVICE_IS_RUNNING";
        continue; /* Loop/switch isn't completed */
_L105:
        s = "RIL_REQUEST_CDMA_GET_SUBSCRIPTION_SOURCE";
        continue; /* Loop/switch isn't completed */
_L106:
        s = "RIL_REQUEST_ISIM_AUTHENTICATION";
        continue; /* Loop/switch isn't completed */
_L107:
        s = "RIL_REQUEST_ACKNOWLEDGE_INCOMING_GSM_SMS_WITH_PDU";
        continue; /* Loop/switch isn't completed */
_L108:
        s = "RIL_REQUEST_STK_SEND_ENVELOPE_WITH_STATUS";
        continue; /* Loop/switch isn't completed */
_L109:
        s = "RIL_REQUEST_VOICE_RADIO_TECH";
        if(true) goto _L111; else goto _L110
_L110:
    }

    private Object responseCallForward(Parcel parcel) {
        int i = parcel.readInt();
        CallForwardInfo acallforwardinfo[] = new CallForwardInfo[i];
        for(int j = 0; j < i; j++) {
            acallforwardinfo[j] = new CallForwardInfo();
            acallforwardinfo[j].status = parcel.readInt();
            acallforwardinfo[j].reason = parcel.readInt();
            acallforwardinfo[j].serviceClass = parcel.readInt();
            acallforwardinfo[j].toa = parcel.readInt();
            acallforwardinfo[j].number = parcel.readString();
            acallforwardinfo[j].timeSeconds = parcel.readInt();
        }

        return acallforwardinfo;
    }

    private Object responseCallList(Parcel parcel) {
        int i = parcel.readInt();
        ArrayList arraylist = new ArrayList(i);
        int j = 0;
        while(j < i)  {
            DriverCall drivercall = new DriverCall();
            drivercall.state = DriverCall.stateFromCLCC(parcel.readInt());
            drivercall.index = parcel.readInt();
            drivercall.TOA = parcel.readInt();
            boolean flag;
            boolean flag1;
            boolean flag2;
            boolean flag3;
            if(parcel.readInt() != 0)
                flag = true;
            else
                flag = false;
            drivercall.isMpty = flag;
            if(parcel.readInt() != 0)
                flag1 = true;
            else
                flag1 = false;
            drivercall.isMT = flag1;
            drivercall.als = parcel.readInt();
            if(parcel.readInt() == 0)
                flag2 = false;
            else
                flag2 = true;
            drivercall.isVoice = flag2;
            if(parcel.readInt() != 0)
                flag3 = true;
            else
                flag3 = false;
            drivercall.isVoicePrivacy = flag3;
            drivercall.number = parcel.readString();
            drivercall.numberPresentation = DriverCall.presentationFromCLIP(parcel.readInt());
            drivercall.name = parcel.readString();
            drivercall.namePresentation = parcel.readInt();
            if(parcel.readInt() == 1) {
                drivercall.uusInfo = new UUSInfo();
                drivercall.uusInfo.setType(parcel.readInt());
                drivercall.uusInfo.setDcs(parcel.readInt());
                byte abyte0[] = parcel.createByteArray();
                drivercall.uusInfo.setUserData(abyte0);
                Object aobj[] = new Object[3];
                aobj[0] = Integer.valueOf(drivercall.uusInfo.getType());
                aobj[1] = Integer.valueOf(drivercall.uusInfo.getDcs());
                aobj[2] = Integer.valueOf(drivercall.uusInfo.getUserData().length);
                riljLogv(String.format("Incoming UUS : type=%d, dcs=%d, length=%d", aobj));
                riljLogv((new StringBuilder()).append("Incoming UUS : data (string)=").append(new String(drivercall.uusInfo.getUserData())).toString());
                riljLogv((new StringBuilder()).append("Incoming UUS : data (hex): ").append(IccUtils.bytesToHexString(drivercall.uusInfo.getUserData())).toString());
            } else {
                riljLogv("Incoming UUS : NOT present!");
            }
            drivercall.number = PhoneNumberUtils.stringFromStringAndTOA(drivercall.number, drivercall.TOA);
            arraylist.add(drivercall);
            if(drivercall.isVoicePrivacy) {
                super.mVoicePrivacyOnRegistrants.notifyRegistrants();
                riljLog("InCall VoicePrivacy is enabled");
            } else {
                super.mVoicePrivacyOffRegistrants.notifyRegistrants();
                riljLog("InCall VoicePrivacy is disabled");
            }
            j++;
        }
        Collections.sort(arraylist);
        if(i == 0 && mTestingEmergencyCall.getAndSet(false) && super.mEmergencyCallbackModeRegistrant != null) {
            riljLog("responseCallList: call ended, testing emergency call, notify ECM Registrants");
            super.mEmergencyCallbackModeRegistrant.notifyRegistrant();
        }
        return arraylist;
    }

    private Object responseCallRing(Parcel parcel) {
        char ac[] = new char[4];
        ac[0] = (char)parcel.readInt();
        ac[1] = (char)parcel.readInt();
        ac[2] = (char)parcel.readInt();
        ac[3] = (char)parcel.readInt();
        return ac;
    }

    private Object responseCdmaBroadcastConfig(Parcel parcel) {
        int i = parcel.readInt();
        int ai[];
        if(i == 0) {
            ai = new int[94];
            ai[0] = 31;
            for(int l = 1; l < 94; l += 3) {
                ai[l + 0] = l / 3;
                ai[l + 1] = 1;
                ai[l + 2] = 0;
            }

        } else {
            int j = 1 + i * 3;
            ai = new int[j];
            ai[0] = i;
            for(int k = 1; k < j; k++)
                ai[k] = parcel.readInt();

        }
        return ai;
    }

    private Object responseCdmaCallWaiting(Parcel parcel) {
        CdmaCallWaitingNotification cdmacallwaitingnotification = new CdmaCallWaitingNotification();
        cdmacallwaitingnotification.number = parcel.readString();
        cdmacallwaitingnotification.numberPresentation = CdmaCallWaitingNotification.presentationFromCLIP(parcel.readInt());
        cdmacallwaitingnotification.name = parcel.readString();
        cdmacallwaitingnotification.namePresentation = cdmacallwaitingnotification.numberPresentation;
        cdmacallwaitingnotification.isPresent = parcel.readInt();
        cdmacallwaitingnotification.signalType = parcel.readInt();
        cdmacallwaitingnotification.alertPitch = parcel.readInt();
        cdmacallwaitingnotification.signal = parcel.readInt();
        cdmacallwaitingnotification.numberType = parcel.readInt();
        cdmacallwaitingnotification.numberPlan = parcel.readInt();
        return cdmacallwaitingnotification;
    }

    private ArrayList responseCdmaInformationRecord(Parcel parcel) {
        int i = parcel.readInt();
        ArrayList arraylist = new ArrayList(i);
        for(int j = 0; j < i; j++)
            arraylist.add(new CdmaInformationRecords(parcel));

        return arraylist;
    }

    private Object responseCdmaSms(Parcel parcel) {
        return SmsMessage.newFromParcel(parcel);
    }

    private Object responseCellList(Parcel parcel) {
        int i = parcel.readInt();
        ArrayList arraylist = new ArrayList();
        String s = SystemProperties.get("gsm.network.type", "unknown");
        int j;
        if(s.equals("GPRS"))
            j = 1;
        else
        if(s.equals("EDGE"))
            j = 2;
        else
        if(s.equals("UMTS"))
            j = 3;
        else
        if(s.equals("HSDPA"))
            j = 8;
        else
        if(s.equals("HSUPA"))
            j = 9;
        else
        if(s.equals("HSPA"))
            j = 10;
        else
            j = 0;
        if(j != 0) {
            for(int k = 0; k < i; k++)
                arraylist.add(new NeighboringCellInfo(parcel.readInt(), parcel.readString(), j));

        }
        return arraylist;
    }

    private Object responseDataCallList(Parcel parcel) {
        int i = parcel.readInt();
        int j = parcel.readInt();
        riljLog((new StringBuilder()).append("responseDataCallList ver=").append(i).append(" num=").append(j).toString());
        ArrayList arraylist = new ArrayList(j);
        for(int k = 0; k < j; k++)
            arraylist.add(getDataCallState(parcel, i));

        return arraylist;
    }

    private Object responseGetPreferredNetworkType(Parcel parcel) {
        int ai[] = (int[])(int[])responseInts(parcel);
        if(ai.length >= 1)
            super.mPreferredNetworkType = ai[0];
        return ai;
    }

    private Object responseGmsBroadcastConfig(Parcel parcel) {
        int i = parcel.readInt();
        ArrayList arraylist = new ArrayList(i);
        int j = 0;
        while(j < i)  {
            int k = parcel.readInt();
            int l = parcel.readInt();
            int i1 = parcel.readInt();
            int j1 = parcel.readInt();
            boolean flag;
            if(parcel.readInt() == 1)
                flag = true;
            else
                flag = false;
            arraylist.add(new SmsBroadcastConfigInfo(k, l, i1, j1, flag));
            j++;
        }
        return arraylist;
    }

    private Object responseICC_IO(Parcel parcel) {
        return new IccIoResult(parcel.readInt(), parcel.readInt(), parcel.readString());
    }

    private Object responseIccCardStatus(Parcel parcel) {
        IccCardStatus icccardstatus = new IccCardStatus();
        icccardstatus.setCardState(parcel.readInt());
        icccardstatus.setUniversalPinState(parcel.readInt());
        icccardstatus.setGsmUmtsSubscriptionAppIndex(parcel.readInt());
        icccardstatus.setCdmaSubscriptionAppIndex(parcel.readInt());
        icccardstatus.setImsSubscriptionAppIndex(parcel.readInt());
        int i = parcel.readInt();
        if(i > 8)
            i = 8;
        icccardstatus.setNumApplications(i);
        for(int j = 0; j < i; j++) {
            IccCardApplication icccardapplication = new IccCardApplication();
            icccardapplication.app_type = icccardapplication.AppTypeFromRILInt(parcel.readInt());
            icccardapplication.app_state = icccardapplication.AppStateFromRILInt(parcel.readInt());
            icccardapplication.perso_substate = icccardapplication.PersoSubstateFromRILInt(parcel.readInt());
            icccardapplication.aid = parcel.readString();
            icccardapplication.app_label = parcel.readString();
            icccardapplication.pin1_replaced = parcel.readInt();
            icccardapplication.pin1 = icccardapplication.PinStateFromRILInt(parcel.readInt());
            icccardapplication.pin2 = icccardapplication.PinStateFromRILInt(parcel.readInt());
            icccardstatus.addApplication(icccardapplication);
        }

        return icccardstatus;
    }

    private Object responseInts(Parcel parcel) {
        int i = parcel.readInt();
        int ai[] = new int[i];
        for(int j = 0; j < i; j++)
            ai[j] = parcel.readInt();

        return ai;
    }

    private Object responseOperatorInfos(Parcel parcel) {
        String as[] = (String[])(String[])responseStrings(parcel);
        if(as.length % 4 != 0)
            throw new RuntimeException((new StringBuilder()).append("RIL_REQUEST_QUERY_AVAILABLE_NETWORKS: invalid response. Got ").append(as.length).append(" strings, expected multible of 4").toString());
        ArrayList arraylist = new ArrayList(as.length / 4);
        for(int i = 0; i < as.length; i += 4)
            arraylist.add(new OperatorInfo(as[i + 0], as[i + 1], as[i + 2], as[i + 3]));

        return arraylist;
    }

    private Object responseRaw(Parcel parcel) {
        return parcel.createByteArray();
    }

    private Object responseSMS(Parcel parcel) {
        return new SmsResponse(parcel.readInt(), parcel.readString(), parcel.readInt());
    }

    private Object responseSetupDataCall(Parcel parcel) {
        int i = parcel.readInt();
        int j = parcel.readInt();
        DataCallState datacallstate;
        if(i < 5) {
            datacallstate = new DataCallState();
            datacallstate.version = i;
            datacallstate.cid = Integer.parseInt(parcel.readString());
            datacallstate.ifname = parcel.readString();
            if(TextUtils.isEmpty(datacallstate.ifname))
                throw new RuntimeException("RIL_REQUEST_SETUP_DATA_CALL response, no ifname");
            String s = parcel.readString();
            if(!TextUtils.isEmpty(s))
                datacallstate.addresses = s.split(" ");
            if(j >= 4) {
                String s2 = parcel.readString();
                riljLog((new StringBuilder()).append("responseSetupDataCall got dnses=").append(s2).toString());
                if(!TextUtils.isEmpty(s2))
                    datacallstate.dnses = s2.split(" ");
            }
            if(j >= 5) {
                String s1 = parcel.readString();
                riljLog((new StringBuilder()).append("responseSetupDataCall got gateways=").append(s1).toString());
                if(!TextUtils.isEmpty(s1))
                    datacallstate.gateways = s1.split(" ");
            }
        } else {
            if(j != 1)
                throw new RuntimeException((new StringBuilder()).append("RIL_REQUEST_SETUP_DATA_CALL response expecting 1 RIL_Data_Call_response_v5 got ").append(j).toString());
            datacallstate = getDataCallState(parcel, i);
        }
        return datacallstate;
    }

    private Object responseSignalStrength(Parcel parcel) {
        int ai[] = new int[12];
        for(int i = 0; i < 12; i++)
            ai[i] = parcel.readInt();

        return ai;
    }

    private Object responseSimRefresh(Parcel parcel) {
        IccRefreshResponse iccrefreshresponse = new IccRefreshResponse();
        iccrefreshresponse.refreshResult = parcel.readInt();
        iccrefreshresponse.efId = parcel.readInt();
        iccrefreshresponse.aid = parcel.readString();
        return iccrefreshresponse;
    }

    private Object responseString(Parcel parcel) {
        return parcel.readString();
    }

    private Object responseStrings(Parcel parcel) {
        return parcel.readStringArray();
    }

    private Object responseSuppServiceNotification(Parcel parcel) {
        SuppServiceNotification suppservicenotification = new SuppServiceNotification();
        suppservicenotification.notificationType = parcel.readInt();
        suppservicenotification.code = parcel.readInt();
        suppservicenotification.index = parcel.readInt();
        suppservicenotification.type = parcel.readInt();
        suppservicenotification.number = parcel.readString();
        return suppservicenotification;
    }

    static String responseToString(int i) {
        i;
        JVM INSTR tableswitch 1000 1035: default 160
    //                   1000 166
    //                   1001 173
    //                   1002 180
    //                   1003 187
    //                   1004 194
    //                   1005 201
    //                   1006 208
    //                   1007 215
    //                   1008 222
    //                   1009 229
    //                   1010 236
    //                   1011 243
    //                   1012 250
    //                   1013 257
    //                   1014 264
    //                   1015 271
    //                   1016 278
    //                   1017 285
    //                   1018 292
    //                   1019 299
    //                   1020 306
    //                   1021 313
    //                   1022 320
    //                   1023 327
    //                   1024 334
    //                   1025 341
    //                   1026 348
    //                   1027 355
    //                   1028 362
    //                   1029 369
    //                   1030 376
    //                   1031 383
    //                   1032 390
    //                   1033 397
    //                   1034 404
    //                   1035 411;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36 _L37
_L1:
        String s = "<unknown reponse>";
_L39:
        return s;
_L2:
        s = "UNSOL_RESPONSE_RADIO_STATE_CHANGED";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "UNSOL_RESPONSE_CALL_STATE_CHANGED";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "UNSOL_RESPONSE_VOICE_NETWORK_STATE_CHANGED";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "UNSOL_RESPONSE_NEW_SMS";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "UNSOL_RESPONSE_NEW_SMS_STATUS_REPORT";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "UNSOL_RESPONSE_NEW_SMS_ON_SIM";
        continue; /* Loop/switch isn't completed */
_L8:
        s = "UNSOL_ON_USSD";
        continue; /* Loop/switch isn't completed */
_L9:
        s = "UNSOL_ON_USSD_REQUEST";
        continue; /* Loop/switch isn't completed */
_L10:
        s = "UNSOL_NITZ_TIME_RECEIVED";
        continue; /* Loop/switch isn't completed */
_L11:
        s = "UNSOL_SIGNAL_STRENGTH";
        continue; /* Loop/switch isn't completed */
_L12:
        s = "UNSOL_DATA_CALL_LIST_CHANGED";
        continue; /* Loop/switch isn't completed */
_L13:
        s = "UNSOL_SUPP_SVC_NOTIFICATION";
        continue; /* Loop/switch isn't completed */
_L14:
        s = "UNSOL_STK_SESSION_END";
        continue; /* Loop/switch isn't completed */
_L15:
        s = "UNSOL_STK_PROACTIVE_COMMAND";
        continue; /* Loop/switch isn't completed */
_L16:
        s = "UNSOL_STK_EVENT_NOTIFY";
        continue; /* Loop/switch isn't completed */
_L17:
        s = "UNSOL_STK_CALL_SETUP";
        continue; /* Loop/switch isn't completed */
_L18:
        s = "UNSOL_SIM_SMS_STORAGE_FULL";
        continue; /* Loop/switch isn't completed */
_L19:
        s = "UNSOL_SIM_REFRESH";
        continue; /* Loop/switch isn't completed */
_L20:
        s = "UNSOL_CALL_RING";
        continue; /* Loop/switch isn't completed */
_L21:
        s = "UNSOL_RESPONSE_SIM_STATUS_CHANGED";
        continue; /* Loop/switch isn't completed */
_L22:
        s = "UNSOL_RESPONSE_CDMA_NEW_SMS";
        continue; /* Loop/switch isn't completed */
_L23:
        s = "UNSOL_RESPONSE_NEW_BROADCAST_SMS";
        continue; /* Loop/switch isn't completed */
_L24:
        s = "UNSOL_CDMA_RUIM_SMS_STORAGE_FULL";
        continue; /* Loop/switch isn't completed */
_L25:
        s = "UNSOL_RESTRICTED_STATE_CHANGED";
        continue; /* Loop/switch isn't completed */
_L26:
        s = "UNSOL_ENTER_EMERGENCY_CALLBACK_MODE";
        continue; /* Loop/switch isn't completed */
_L27:
        s = "UNSOL_CDMA_CALL_WAITING";
        continue; /* Loop/switch isn't completed */
_L28:
        s = "UNSOL_CDMA_OTA_PROVISION_STATUS";
        continue; /* Loop/switch isn't completed */
_L29:
        s = "UNSOL_CDMA_INFO_REC";
        continue; /* Loop/switch isn't completed */
_L30:
        s = "UNSOL_OEM_HOOK_RAW";
        continue; /* Loop/switch isn't completed */
_L31:
        s = "UNSOL_RINGBACK_TONG";
        continue; /* Loop/switch isn't completed */
_L32:
        s = "UNSOL_RESEND_INCALL_MUTE";
        continue; /* Loop/switch isn't completed */
_L33:
        s = "CDMA_SUBSCRIPTION_SOURCE_CHANGED";
        continue; /* Loop/switch isn't completed */
_L34:
        s = "UNSOL_CDMA_PRL_CHANGED";
        continue; /* Loop/switch isn't completed */
_L35:
        s = "UNSOL_EXIT_EMERGENCY_CALLBACK_MODE";
        continue; /* Loop/switch isn't completed */
_L36:
        s = "UNSOL_RIL_CONNECTED";
        continue; /* Loop/switch isn't completed */
_L37:
        s = "UNSOL_VOICE_RADIO_TECH_CHANGED";
        if(true) goto _L39; else goto _L38
_L38:
    }

    private Object responseVoid(Parcel parcel) {
        return null;
    }

    private String retToString(int i, Object obj) {
        if(obj != null) goto _L2; else goto _L1
_L1:
        String s = "";
_L4:
        return s;
_L2:
label0:
        {
            StringBuilder stringbuilder4;
            switch(i) {
            default:
                if(obj instanceof int[]) {
                    int ai[] = (int[])(int[])obj;
                    int i1 = ai.length;
                    stringbuilder4 = new StringBuilder("{");
                    if(i1 > 0) {
                        int j1 = 0 + 1;
                        stringbuilder4.append(ai[0]);
                        int k1;
                        for(; j1 < i1; j1 = k1) {
                            StringBuilder stringbuilder5 = stringbuilder4.append(", ");
                            k1 = j1 + 1;
                            stringbuilder5.append(ai[j1]);
                        }

                    }
                    break;
                }
                break label0;

            case 11: // '\013'
            case 38: // '&'
            case 39: // '\''
                s = "";
                continue; /* Loop/switch isn't completed */
            }
            stringbuilder4.append("}");
            s = stringbuilder4.toString();
            continue; /* Loop/switch isn't completed */
        }
        if(obj instanceof String[]) {
            String as[] = (String[])(String[])obj;
            int j = as.length;
            StringBuilder stringbuilder2 = new StringBuilder("{");
            if(j > 0) {
                int k = 0 + 1;
                stringbuilder2.append(as[0]);
                int l;
                for(; k < j; k = l) {
                    StringBuilder stringbuilder3 = stringbuilder2.append(", ");
                    l = k + 1;
                    stringbuilder3.append(as[k]);
                }

            }
            stringbuilder2.append("}");
            s = stringbuilder2.toString();
        } else
        if(i == 9) {
            ArrayList arraylist1 = (ArrayList)obj;
            StringBuilder stringbuilder1 = new StringBuilder(" ");
            DriverCall drivercall;
            for(Iterator iterator1 = arraylist1.iterator(); iterator1.hasNext(); stringbuilder1.append("[").append(drivercall).append("] "))
                drivercall = (DriverCall)iterator1.next();

            s = stringbuilder1.toString();
        } else
        if(i == 75) {
            ArrayList arraylist = (ArrayList)obj;
            StringBuilder stringbuilder = new StringBuilder(" ");
            for(Iterator iterator = arraylist.iterator(); iterator.hasNext(); stringbuilder.append((NeighboringCellInfo)iterator.next()).append(" "));
            s = stringbuilder.toString();
        } else {
            s = obj.toString();
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void riljLog(String s) {
        Log.d("RILJ", s);
    }

    private void riljLogv(String s) {
        Log.v("RILJ", s);
    }

    private void send(RILRequest rilrequest) {
        if(mSocket == null) {
            rilrequest.onError(1, null);
            rilrequest.release();
        } else {
            Message message = mSender.obtainMessage(1, rilrequest);
            acquireWakeLock();
            message.sendToTarget();
        }
    }

    private void sendScreenState(boolean flag) {
        int i = 1;
        RILRequest rilrequest = RILRequest.obtain(61, null);
        rilrequest.mp.writeInt(i);
        Parcel parcel = rilrequest.mp;
        if(!flag)
            i = 0;
        parcel.writeInt(i);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).append(": ").append(flag).toString());
        send(rilrequest);
    }

    private void switchToRadioState(CommandsInterface.RadioState radiostate) {
        setRadioState(radiostate);
    }

    private int translateStatus(int i) {
        int j = 1;
        i & 7;
        JVM INSTR tableswitch 1 7: default 48
    //                   1 48
    //                   2 48
    //                   3 50
    //                   4 48
    //                   5 55
    //                   6 48
    //                   7 60;
           goto _L1 _L1 _L1 _L2 _L1 _L3 _L1 _L4
_L1:
        return j;
_L2:
        j = 0;
        continue; /* Loop/switch isn't completed */
_L3:
        j = 3;
        continue; /* Loop/switch isn't completed */
_L4:
        j = 2;
        if(true) goto _L1; else goto _L5
_L5:
    }

    private void unsljLog(int i) {
        riljLog((new StringBuilder()).append("[UNSL]< ").append(responseToString(i)).toString());
    }

    private void unsljLogMore(int i, String s) {
        riljLog((new StringBuilder()).append("[UNSL]< ").append(responseToString(i)).append(" ").append(s).toString());
    }

    private void unsljLogRet(int i, Object obj) {
        riljLog((new StringBuilder()).append("[UNSL]< ").append(responseToString(i)).append(" ").append(retToString(i, obj)).toString());
    }

    private void unsljLogvRet(int i, Object obj) {
        riljLogv((new StringBuilder()).append("[UNSL]< ").append(responseToString(i)).append(" ").append(retToString(i, obj)).toString());
    }

    public void acceptCall(Message message) {
        RILRequest rilrequest = RILRequest.obtain(40, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void acknowledgeIncomingGsmSmsWithPdu(boolean flag, String s, Message message) {
        RILRequest rilrequest = RILRequest.obtain(106, message);
        rilrequest.mp.writeInt(2);
        Parcel parcel = rilrequest.mp;
        String s1;
        if(flag)
            s1 = "1";
        else
            s1 = "0";
        parcel.writeString(s1);
        rilrequest.mp.writeString(s);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).append(' ').append(flag).append(" [").append(s).append(']').toString());
        send(rilrequest);
    }

    public void acknowledgeLastIncomingCdmaSms(boolean flag, int i, Message message) {
        RILRequest rilrequest = RILRequest.obtain(88, message);
        Parcel parcel = rilrequest.mp;
        int j;
        if(flag)
            j = 0;
        else
            j = 1;
        parcel.writeInt(j);
        rilrequest.mp.writeInt(i);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).append(" ").append(flag).append(" ").append(i).toString());
        send(rilrequest);
    }

    public void acknowledgeLastIncomingGsmSms(boolean flag, int i, Message message) {
        RILRequest rilrequest = RILRequest.obtain(37, message);
        rilrequest.mp.writeInt(2);
        Parcel parcel = rilrequest.mp;
        int j;
        if(flag)
            j = 1;
        else
            j = 0;
        parcel.writeInt(j);
        rilrequest.mp.writeInt(i);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).append(" ").append(flag).append(" ").append(i).toString());
        send(rilrequest);
    }

    public void cancelPendingUssd(Message message) {
        RILRequest rilrequest = RILRequest.obtain(30, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void changeBarringPassword(String s, String s1, String s2, Message message) {
        RILRequest rilrequest = RILRequest.obtain(44, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        rilrequest.mp.writeInt(3);
        rilrequest.mp.writeString(s);
        rilrequest.mp.writeString(s1);
        rilrequest.mp.writeString(s2);
        send(rilrequest);
    }

    public void changeIccPin(String s, String s1, Message message) {
        changeIccPinForApp(s, s1, null, message);
    }

    public void changeIccPin2(String s, String s1, Message message) {
        changeIccPin2ForApp(s, s1, null, message);
    }

    public void changeIccPin2ForApp(String s, String s1, String s2, Message message) {
        RILRequest rilrequest = RILRequest.obtain(7, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        rilrequest.mp.writeInt(3);
        rilrequest.mp.writeString(s);
        rilrequest.mp.writeString(s1);
        rilrequest.mp.writeString(s2);
        send(rilrequest);
    }

    public void changeIccPinForApp(String s, String s1, String s2, Message message) {
        RILRequest rilrequest = RILRequest.obtain(6, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        rilrequest.mp.writeInt(3);
        rilrequest.mp.writeString(s);
        rilrequest.mp.writeString(s1);
        rilrequest.mp.writeString(s2);
        send(rilrequest);
    }

    public void conference(Message message) {
        RILRequest rilrequest = RILRequest.obtain(16, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void deactivateDataCall(int i, int j, Message message) {
        RILRequest rilrequest = RILRequest.obtain(41, message);
        rilrequest.mp.writeInt(2);
        rilrequest.mp.writeString(Integer.toString(i));
        rilrequest.mp.writeString(Integer.toString(j));
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).append(" ").append(i).append(" ").append(j).toString());
        send(rilrequest);
    }

    public void deleteSmsOnRuim(int i, Message message) {
        RILRequest rilrequest = RILRequest.obtain(97, message);
        rilrequest.mp.writeInt(1);
        rilrequest.mp.writeInt(i);
        send(rilrequest);
    }

    public void deleteSmsOnSim(int i, Message message) {
        RILRequest rilrequest = RILRequest.obtain(64, message);
        rilrequest.mp.writeInt(1);
        rilrequest.mp.writeInt(i);
        send(rilrequest);
    }

    public void dial(String s, int i, Message message) {
        dial(s, i, null, message);
    }

    public void dial(String s, int i, UUSInfo uusinfo, Message message) {
        RILRequest rilrequest = RILRequest.obtain(10, message);
        rilrequest.mp.writeString(s);
        rilrequest.mp.writeInt(i);
        rilrequest.mp.writeInt(0);
        if(uusinfo == null) {
            rilrequest.mp.writeInt(0);
        } else {
            rilrequest.mp.writeInt(1);
            rilrequest.mp.writeInt(uusinfo.getType());
            rilrequest.mp.writeInt(uusinfo.getDcs());
            rilrequest.mp.writeByteArray(uusinfo.getUserData());
        }
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        printwriter.println("RIL:");
        printwriter.println((new StringBuilder()).append(" mSocket=").append(mSocket).toString());
        printwriter.println((new StringBuilder()).append(" mSenderThread=").append(mSenderThread).toString());
        printwriter.println((new StringBuilder()).append(" mSender=").append(mSender).toString());
        printwriter.println((new StringBuilder()).append(" mReceiverThread=").append(mReceiverThread).toString());
        printwriter.println((new StringBuilder()).append(" mReceiver=").append(mReceiver).toString());
        printwriter.println((new StringBuilder()).append(" mWakeLock=").append(mWakeLock).toString());
        printwriter.println((new StringBuilder()).append(" mWakeLockTimeout=").append(mWakeLockTimeout).toString());
        synchronized(mRequestsList) {
            printwriter.println((new StringBuilder()).append(" mRequestMessagesPending=").append(mRequestMessagesPending).toString());
            printwriter.println((new StringBuilder()).append(" mRequestMessagesWaiting=").append(mRequestMessagesWaiting).toString());
            int i = mRequestsList.size();
            printwriter.println((new StringBuilder()).append(" mRequestList count=").append(i).toString());
            for(int j = 0; j < i; j++) {
                RILRequest rilrequest = (RILRequest)mRequestsList.get(j);
                printwriter.println((new StringBuilder()).append("  [").append(rilrequest.mSerial).append("] ").append(requestToString(rilrequest.mRequest)).toString());
            }

        }
        printwriter.println((new StringBuilder()).append(" mLastNITZTimeInfo=").append(mLastNITZTimeInfo).toString());
        printwriter.println((new StringBuilder()).append(" mTestingEmergencyCall=").append(mTestingEmergencyCall.get()).toString());
        return;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void exitEmergencyCallbackMode(Message message) {
        RILRequest rilrequest = RILRequest.obtain(99, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void explicitCallTransfer(Message message) {
        RILRequest rilrequest = RILRequest.obtain(72, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void getAvailableNetworks(Message message) {
        RILRequest rilrequest = RILRequest.obtain(48, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void getBasebandVersion(Message message) {
        RILRequest rilrequest = RILRequest.obtain(51, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void getCDMASubscription(Message message) {
        RILRequest rilrequest = RILRequest.obtain(95, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void getCLIR(Message message) {
        RILRequest rilrequest = RILRequest.obtain(31, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void getCdmaBroadcastConfig(Message message) {
        send(RILRequest.obtain(92, message));
    }

    public void getCdmaSubscriptionSource(Message message) {
        RILRequest rilrequest = RILRequest.obtain(104, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void getCurrentCalls(Message message) {
        RILRequest rilrequest = RILRequest.obtain(9, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void getDataCallList(Message message) {
        RILRequest rilrequest = RILRequest.obtain(57, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void getDataRegistrationState(Message message) {
        RILRequest rilrequest = RILRequest.obtain(21, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void getDeviceIdentity(Message message) {
        RILRequest rilrequest = RILRequest.obtain(98, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void getGsmBroadcastConfig(Message message) {
        RILRequest rilrequest = RILRequest.obtain(89, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void getIMEI(Message message) {
        RILRequest rilrequest = RILRequest.obtain(38, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void getIMEISV(Message message) {
        RILRequest rilrequest = RILRequest.obtain(39, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void getIMSI(Message message) {
        getIMSIForApp(null, message);
    }

    public void getIMSIForApp(String s, Message message) {
        RILRequest rilrequest = RILRequest.obtain(11, message);
        rilrequest.mp.writeInt(1);
        rilrequest.mp.writeString(s);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> getIMSI: ").append(requestToString(rilrequest.mRequest)).append(" aid: ").append(s).toString());
        send(rilrequest);
    }

    public void getIccCardStatus(Message message) {
        RILRequest rilrequest = RILRequest.obtain(1, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void getLastCallFailCause(Message message) {
        RILRequest rilrequest = RILRequest.obtain(18, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void getLastDataCallFailCause(Message message) {
        RILRequest rilrequest = RILRequest.obtain(56, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void getLastPdpFailCause(Message message) {
        getLastDataCallFailCause(message);
    }

    public void getMute(Message message) {
        RILRequest rilrequest = RILRequest.obtain(54, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void getNeighboringCids(Message message) {
        RILRequest rilrequest = RILRequest.obtain(75, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void getNetworkSelectionMode(Message message) {
        RILRequest rilrequest = RILRequest.obtain(45, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void getOperator(Message message) {
        RILRequest rilrequest = RILRequest.obtain(22, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void getPDPContextList(Message message) {
        getDataCallList(message);
    }

    public void getPreferredNetworkType(Message message) {
        RILRequest rilrequest = RILRequest.obtain(74, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void getPreferredVoicePrivacy(Message message) {
        send(RILRequest.obtain(83, message));
    }

    public void getSignalStrength(Message message) {
        RILRequest rilrequest = RILRequest.obtain(19, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void getSmscAddress(Message message) {
        RILRequest rilrequest = RILRequest.obtain(100, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void getVoiceRadioTechnology(Message message) {
        RILRequest rilrequest = RILRequest.obtain(108, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void getVoiceRegistrationState(Message message) {
        RILRequest rilrequest = RILRequest.obtain(20, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void handleCallSetupRequestFromSim(boolean flag, Message message) {
        int i = 1;
        RILRequest rilrequest = RILRequest.obtain(71, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        int ai[] = new int[i];
        if(!flag)
            i = 0;
        ai[0] = i;
        rilrequest.mp.writeIntArray(ai);
        send(rilrequest);
    }

    public void hangupConnection(int i, Message message) {
        riljLog((new StringBuilder()).append("hangupConnection: gsmIndex=").append(i).toString());
        RILRequest rilrequest = RILRequest.obtain(12, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).append(" ").append(i).toString());
        rilrequest.mp.writeInt(1);
        rilrequest.mp.writeInt(i);
        send(rilrequest);
    }

    public void hangupForegroundResumeBackground(Message message) {
        RILRequest rilrequest = RILRequest.obtain(14, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void hangupWaitingOrBackground(Message message) {
        RILRequest rilrequest = RILRequest.obtain(13, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void iccIO(int i, int j, String s, int k, int l, int i1, String s1, 
            String s2, Message message) {
        iccIOForApp(i, j, s, k, l, i1, s1, s2, null, message);
    }

    public void iccIOForApp(int i, int j, String s, int k, int l, int i1, String s1, 
            String s2, String s3, Message message) {
        RILRequest rilrequest = RILRequest.obtain(28, message);
        rilrequest.mp.writeInt(i);
        rilrequest.mp.writeInt(j);
        rilrequest.mp.writeString(s);
        rilrequest.mp.writeInt(k);
        rilrequest.mp.writeInt(l);
        rilrequest.mp.writeInt(i1);
        rilrequest.mp.writeString(s1);
        rilrequest.mp.writeString(s2);
        rilrequest.mp.writeString(s3);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> iccIO: ").append(requestToString(rilrequest.mRequest)).append(" 0x").append(Integer.toHexString(i)).append(" 0x").append(Integer.toHexString(j)).append(" ").append(" path: ").append(s).append(",").append(k).append(",").append(l).append(",").append(i1).append(" aid: ").append(s3).toString());
        send(rilrequest);
    }

    public void invokeOemRilRequestRaw(byte abyte0[], Message message) {
        RILRequest rilrequest = RILRequest.obtain(59, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).append("[").append(IccUtils.bytesToHexString(abyte0)).append("]").toString());
        rilrequest.mp.writeByteArray(abyte0);
        send(rilrequest);
    }

    public void invokeOemRilRequestStrings(String as[], Message message) {
        RILRequest rilrequest = RILRequest.obtain(60, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        rilrequest.mp.writeStringArray(as);
        send(rilrequest);
    }

    protected void onRadioAvailable() {
        sendScreenState(true);
    }

    public void queryAvailableBandMode(Message message) {
        RILRequest rilrequest = RILRequest.obtain(66, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void queryCLIP(Message message) {
        RILRequest rilrequest = RILRequest.obtain(55, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void queryCallForwardStatus(int i, int j, String s, Message message) {
        RILRequest rilrequest = RILRequest.obtain(33, message);
        rilrequest.mp.writeInt(2);
        rilrequest.mp.writeInt(i);
        rilrequest.mp.writeInt(j);
        rilrequest.mp.writeInt(PhoneNumberUtils.toaFromString(s));
        rilrequest.mp.writeString(s);
        rilrequest.mp.writeInt(0);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).append(" ").append(i).append(" ").append(j).toString());
        send(rilrequest);
    }

    public void queryCallWaiting(int i, Message message) {
        RILRequest rilrequest = RILRequest.obtain(35, message);
        rilrequest.mp.writeInt(1);
        rilrequest.mp.writeInt(i);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).append(" ").append(i).toString());
        send(rilrequest);
    }

    public void queryCdmaRoamingPreference(Message message) {
        RILRequest rilrequest = RILRequest.obtain(79, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void queryFacilityLock(String s, String s1, int i, Message message) {
        queryFacilityLockForApp(s, s1, i, null, message);
    }

    public void queryFacilityLockForApp(String s, String s1, int i, String s2, Message message) {
        RILRequest rilrequest = RILRequest.obtain(42, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        rilrequest.mp.writeInt(4);
        rilrequest.mp.writeString(s);
        rilrequest.mp.writeString(s1);
        rilrequest.mp.writeString(Integer.toString(i));
        rilrequest.mp.writeString(s2);
        send(rilrequest);
    }

    public void queryTTYMode(Message message) {
        RILRequest rilrequest = RILRequest.obtain(81, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void rejectCall(Message message) {
        RILRequest rilrequest = RILRequest.obtain(17, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void reportSmsMemoryStatus(boolean flag, Message message) {
        int i = 1;
        RILRequest rilrequest = RILRequest.obtain(102, message);
        rilrequest.mp.writeInt(i);
        Parcel parcel = rilrequest.mp;
        if(!flag)
            i = 0;
        parcel.writeInt(i);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).append(": ").append(flag).toString());
        send(rilrequest);
    }

    public void reportStkServiceIsRunning(Message message) {
        RILRequest rilrequest = RILRequest.obtain(103, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void requestIsimAuthentication(String s, Message message) {
        RILRequest rilrequest = RILRequest.obtain(105, message);
        rilrequest.mp.writeString(s);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void resetRadio(Message message) {
        RILRequest rilrequest = RILRequest.obtain(58, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void sendBurstDtmf(String s, int i, int j, Message message) {
        RILRequest rilrequest = RILRequest.obtain(85, message);
        rilrequest.mp.writeInt(3);
        rilrequest.mp.writeString(s);
        rilrequest.mp.writeString(Integer.toString(i));
        rilrequest.mp.writeString(Integer.toString(j));
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).append(" : ").append(s).toString());
        send(rilrequest);
    }

    public void sendCDMAFeatureCode(String s, Message message) {
        RILRequest rilrequest = RILRequest.obtain(84, message);
        rilrequest.mp.writeString(s);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).append(" : ").append(s).toString());
        send(rilrequest);
    }

    public void sendCdmaSms(byte abyte0[], Message message) {
        DataInputStream datainputstream;
        RILRequest rilrequest;
        datainputstream = new DataInputStream(new ByteArrayInputStream(abyte0));
        rilrequest = RILRequest.obtain(87, message);
        int k;
        int l;
        rilrequest.mp.writeInt(datainputstream.readInt());
        rilrequest.mp.writeByte((byte)datainputstream.readInt());
        rilrequest.mp.writeInt(datainputstream.readInt());
        rilrequest.mp.writeInt(datainputstream.read());
        rilrequest.mp.writeInt(datainputstream.read());
        rilrequest.mp.writeInt(datainputstream.read());
        rilrequest.mp.writeInt(datainputstream.read());
        byte byte0 = (byte)datainputstream.read();
        rilrequest.mp.writeByte(byte0);
        for(int i = 0; i < byte0; i++)
            rilrequest.mp.writeByte(datainputstream.readByte());

        rilrequest.mp.writeInt(datainputstream.read());
        rilrequest.mp.writeByte((byte)datainputstream.read());
        byte byte1 = (byte)datainputstream.read();
        rilrequest.mp.writeByte(byte1);
        for(int j = 0; j < byte1; j++)
            rilrequest.mp.writeByte(datainputstream.readByte());

        k = datainputstream.read();
        rilrequest.mp.writeInt(k);
        l = 0;
_L1:
        if(l >= k)
            break MISSING_BLOCK_LABEL_301;
        rilrequest.mp.writeByte(datainputstream.readByte());
        l++;
          goto _L1
        IOException ioexception;
        ioexception;
        riljLog((new StringBuilder()).append("sendSmsCdma: conversion from input stream to object failed: ").append(ioexception).toString());
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
        return;
    }

    public void sendDtmf(char c, Message message) {
        RILRequest rilrequest = RILRequest.obtain(24, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        rilrequest.mp.writeString(Character.toString(c));
        send(rilrequest);
    }

    public void sendEnvelope(String s, Message message) {
        RILRequest rilrequest = RILRequest.obtain(69, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        rilrequest.mp.writeString(s);
        send(rilrequest);
    }

    public void sendEnvelopeWithStatus(String s, Message message) {
        RILRequest rilrequest = RILRequest.obtain(107, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).append('[').append(s).append(']').toString());
        rilrequest.mp.writeString(s);
        send(rilrequest);
    }

    public void sendSMS(String s, String s1, Message message) {
        RILRequest rilrequest = RILRequest.obtain(25, message);
        rilrequest.mp.writeInt(2);
        rilrequest.mp.writeString(s);
        rilrequest.mp.writeString(s1);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void sendTerminalResponse(String s, Message message) {
        RILRequest rilrequest = RILRequest.obtain(70, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        rilrequest.mp.writeString(s);
        send(rilrequest);
    }

    public void sendUSSD(String s, Message message) {
        RILRequest rilrequest = RILRequest.obtain(29, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).append(" ").append(s).toString());
        rilrequest.mp.writeString(s);
        send(rilrequest);
    }

    public void separateConnection(int i, Message message) {
        RILRequest rilrequest = RILRequest.obtain(52, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).append(" ").append(i).toString());
        rilrequest.mp.writeInt(1);
        rilrequest.mp.writeInt(i);
        send(rilrequest);
    }

    public void setBandMode(int i, Message message) {
        RILRequest rilrequest = RILRequest.obtain(65, message);
        rilrequest.mp.writeInt(1);
        rilrequest.mp.writeInt(i);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).append(" ").append(i).toString());
        send(rilrequest);
    }

    public void setCLIR(int i, Message message) {
        RILRequest rilrequest = RILRequest.obtain(32, message);
        rilrequest.mp.writeInt(1);
        rilrequest.mp.writeInt(i);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).append(" ").append(i).toString());
        send(rilrequest);
    }

    public void setCallForward(int i, int j, int k, String s, int l, Message message) {
        RILRequest rilrequest = RILRequest.obtain(34, message);
        rilrequest.mp.writeInt(i);
        rilrequest.mp.writeInt(j);
        rilrequest.mp.writeInt(k);
        rilrequest.mp.writeInt(PhoneNumberUtils.toaFromString(s));
        rilrequest.mp.writeString(s);
        rilrequest.mp.writeInt(l);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).append(" ").append(i).append(" ").append(j).append(" ").append(k).append(l).toString());
        send(rilrequest);
    }

    public void setCallWaiting(boolean flag, int i, Message message) {
        RILRequest rilrequest = RILRequest.obtain(36, message);
        rilrequest.mp.writeInt(2);
        Parcel parcel = rilrequest.mp;
        int j;
        if(flag)
            j = 1;
        else
            j = 0;
        parcel.writeInt(j);
        rilrequest.mp.writeInt(i);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).append(" ").append(flag).append(", ").append(i).toString());
        send(rilrequest);
    }

    public void setCdmaBroadcastActivation(boolean flag, Message message) {
        int i = 1;
        RILRequest rilrequest = RILRequest.obtain(94, message);
        rilrequest.mp.writeInt(i);
        Parcel parcel = rilrequest.mp;
        if(flag)
            i = 0;
        parcel.writeInt(i);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void setCdmaBroadcastConfig(int ai[], Message message) {
        RILRequest rilrequest = RILRequest.obtain(93, message);
        for(int i = 0; i < ai.length; i++)
            rilrequest.mp.writeInt(ai[i]);

        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void setCdmaRoamingPreference(int i, Message message) {
        RILRequest rilrequest = RILRequest.obtain(78, message);
        rilrequest.mp.writeInt(1);
        rilrequest.mp.writeInt(i);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).append(" : ").append(i).toString());
        send(rilrequest);
    }

    public void setCdmaSubscriptionSource(int i, Message message) {
        RILRequest rilrequest = RILRequest.obtain(77, message);
        rilrequest.mp.writeInt(1);
        rilrequest.mp.writeInt(i);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).append(" : ").append(i).toString());
        send(rilrequest);
    }

    public void setCurrentPreferredNetworkType() {
        riljLog((new StringBuilder()).append("setCurrentPreferredNetworkType: ").append(mSetPreferredNetworkType).toString());
        setPreferredNetworkType(mSetPreferredNetworkType, null);
    }

    public void setFacilityLock(String s, boolean flag, String s1, int i, Message message) {
        setFacilityLockForApp(s, flag, s1, i, null, message);
    }

    public void setFacilityLockForApp(String s, boolean flag, String s1, int i, String s2, Message message) {
        RILRequest rilrequest = RILRequest.obtain(43, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        rilrequest.mp.writeInt(5);
        rilrequest.mp.writeString(s);
        String s3;
        if(flag)
            s3 = "1";
        else
            s3 = "0";
        rilrequest.mp.writeString(s3);
        rilrequest.mp.writeString(s1);
        rilrequest.mp.writeString(Integer.toString(i));
        rilrequest.mp.writeString(s2);
        send(rilrequest);
    }

    public void setGsmBroadcastActivation(boolean flag, Message message) {
        int i = 1;
        RILRequest rilrequest = RILRequest.obtain(91, message);
        rilrequest.mp.writeInt(i);
        Parcel parcel = rilrequest.mp;
        if(flag)
            i = 0;
        parcel.writeInt(i);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void setGsmBroadcastConfig(SmsBroadcastConfigInfo asmsbroadcastconfiginfo[], Message message) {
        RILRequest rilrequest = RILRequest.obtain(90, message);
        int i = asmsbroadcastconfiginfo.length;
        rilrequest.mp.writeInt(i);
        int j = 0;
        while(j < i)  {
            rilrequest.mp.writeInt(asmsbroadcastconfiginfo[j].getFromServiceId());
            rilrequest.mp.writeInt(asmsbroadcastconfiginfo[j].getToServiceId());
            rilrequest.mp.writeInt(asmsbroadcastconfiginfo[j].getFromCodeScheme());
            rilrequest.mp.writeInt(asmsbroadcastconfiginfo[j].getToCodeScheme());
            Parcel parcel = rilrequest.mp;
            int l;
            if(asmsbroadcastconfiginfo[j].isSelected())
                l = 1;
            else
                l = 0;
            parcel.writeInt(l);
            j++;
        }
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).append(" with ").append(i).append(" configs : ").toString());
        for(int k = 0; k < i; k++)
            riljLog(asmsbroadcastconfiginfo[k].toString());

        send(rilrequest);
    }

    public void setLocationUpdates(boolean flag, Message message) {
        int i = 1;
        RILRequest rilrequest = RILRequest.obtain(76, message);
        rilrequest.mp.writeInt(i);
        Parcel parcel = rilrequest.mp;
        if(!flag)
            i = 0;
        parcel.writeInt(i);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).append(": ").append(flag).toString());
        send(rilrequest);
    }

    public void setMute(boolean flag, Message message) {
        int i = 1;
        RILRequest rilrequest = RILRequest.obtain(53, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).append(" ").append(flag).toString());
        rilrequest.mp.writeInt(i);
        Parcel parcel = rilrequest.mp;
        if(!flag)
            i = 0;
        parcel.writeInt(i);
        send(rilrequest);
    }

    public void setNetworkSelectionModeAutomatic(Message message) {
        RILRequest rilrequest = RILRequest.obtain(46, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void setNetworkSelectionModeManual(String s, Message message) {
        RILRequest rilrequest = RILRequest.obtain(47, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).append(" ").append(s).toString());
        rilrequest.mp.writeString(s);
        send(rilrequest);
    }

    public void setOnNITZTime(Handler handler, int i, Object obj) {
        super.setOnNITZTime(handler, i, obj);
        if(mLastNITZTimeInfo != null) {
            super.mNITZTimeRegistrant.notifyRegistrant(new AsyncResult(null, mLastNITZTimeInfo, null));
            mLastNITZTimeInfo = null;
        }
    }

    public void setPhoneType(int i) {
        riljLog((new StringBuilder()).append("setPhoneType=").append(i).append(" old value=").append(super.mPhoneType).toString());
        super.mPhoneType = i;
    }

    public void setPreferredNetworkType(int i, Message message) {
        RILRequest rilrequest = RILRequest.obtain(73, message);
        rilrequest.mp.writeInt(1);
        rilrequest.mp.writeInt(i);
        mSetPreferredNetworkType = i;
        super.mPreferredNetworkType = i;
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).append(" : ").append(i).toString());
        send(rilrequest);
    }

    public void setPreferredVoicePrivacy(boolean flag, Message message) {
        int i = 1;
        RILRequest rilrequest = RILRequest.obtain(82, message);
        rilrequest.mp.writeInt(i);
        Parcel parcel = rilrequest.mp;
        if(!flag)
            i = 0;
        parcel.writeInt(i);
        send(rilrequest);
    }

    public void setRadioPower(boolean flag, Message message) {
        int i = 1;
        RILRequest rilrequest = RILRequest.obtain(23, message);
        rilrequest.mp.writeInt(i);
        Parcel parcel = rilrequest.mp;
        StringBuilder stringbuilder;
        String s;
        if(!flag)
            i = 0;
        parcel.writeInt(i);
        stringbuilder = (new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest));
        if(flag)
            s = " on";
        else
            s = " off";
        riljLog(stringbuilder.append(s).toString());
        send(rilrequest);
    }

    public void setSmscAddress(String s, Message message) {
        RILRequest rilrequest = RILRequest.obtain(101, message);
        rilrequest.mp.writeString(s);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).append(" : ").append(s).toString());
        send(rilrequest);
    }

    public void setSuppServiceNotifications(boolean flag, Message message) {
        int i = 1;
        RILRequest rilrequest = RILRequest.obtain(62, message);
        rilrequest.mp.writeInt(i);
        Parcel parcel = rilrequest.mp;
        if(!flag)
            i = 0;
        parcel.writeInt(i);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void setTTYMode(int i, Message message) {
        RILRequest rilrequest = RILRequest.obtain(80, message);
        rilrequest.mp.writeInt(1);
        rilrequest.mp.writeInt(i);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).append(" : ").append(i).toString());
        send(rilrequest);
    }

    public void setupDataCall(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            Message message) {
        RILRequest rilrequest = RILRequest.obtain(27, message);
        rilrequest.mp.writeInt(7);
        rilrequest.mp.writeString(s);
        rilrequest.mp.writeString(s1);
        rilrequest.mp.writeString(s2);
        rilrequest.mp.writeString(s3);
        rilrequest.mp.writeString(s4);
        rilrequest.mp.writeString(s5);
        rilrequest.mp.writeString(s6);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).append(" ").append(s).append(" ").append(s1).append(" ").append(s2).append(" ").append(s3).append(" ").append(s4).append(" ").append(s5).append(" ").append(s6).toString());
        send(rilrequest);
    }

    public void startDtmf(char c, Message message) {
        RILRequest rilrequest = RILRequest.obtain(49, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        rilrequest.mp.writeString(Character.toString(c));
        send(rilrequest);
    }

    public void stopDtmf(Message message) {
        RILRequest rilrequest = RILRequest.obtain(50, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void supplyIccPin(String s, Message message) {
        supplyIccPinForApp(s, null, message);
    }

    public void supplyIccPin2(String s, Message message) {
        supplyIccPin2ForApp(s, null, message);
    }

    public void supplyIccPin2ForApp(String s, String s1, Message message) {
        RILRequest rilrequest = RILRequest.obtain(4, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        rilrequest.mp.writeInt(2);
        rilrequest.mp.writeString(s);
        rilrequest.mp.writeString(s1);
        send(rilrequest);
    }

    public void supplyIccPinForApp(String s, String s1, Message message) {
        RILRequest rilrequest = RILRequest.obtain(2, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        rilrequest.mp.writeInt(2);
        rilrequest.mp.writeString(s);
        rilrequest.mp.writeString(s1);
        send(rilrequest);
    }

    public void supplyIccPuk(String s, String s1, Message message) {
        supplyIccPukForApp(s, s1, null, message);
    }

    public void supplyIccPuk2(String s, String s1, Message message) {
        supplyIccPuk2ForApp(s, s1, null, message);
    }

    public void supplyIccPuk2ForApp(String s, String s1, String s2, Message message) {
        RILRequest rilrequest = RILRequest.obtain(5, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        rilrequest.mp.writeInt(3);
        rilrequest.mp.writeString(s);
        rilrequest.mp.writeString(s1);
        rilrequest.mp.writeString(s2);
        send(rilrequest);
    }

    public void supplyIccPukForApp(String s, String s1, String s2, Message message) {
        RILRequest rilrequest = RILRequest.obtain(3, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        rilrequest.mp.writeInt(3);
        rilrequest.mp.writeString(s);
        rilrequest.mp.writeString(s1);
        rilrequest.mp.writeString(s2);
        send(rilrequest);
    }

    public void supplyNetworkDepersonalization(String s, Message message) {
        RILRequest rilrequest = RILRequest.obtain(8, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        rilrequest.mp.writeInt(1);
        rilrequest.mp.writeString(s);
        send(rilrequest);
    }

    public void switchWaitingOrHoldingAndActive(Message message) {
        RILRequest rilrequest = RILRequest.obtain(15, message);
        riljLog((new StringBuilder()).append(rilrequest.serialString()).append("> ").append(requestToString(rilrequest.mRequest)).toString());
        send(rilrequest);
    }

    public void testingEmergencyCall() {
        riljLog("testingEmergencyCall");
        mTestingEmergencyCall.set(true);
    }

    public void writeSmsToRuim(int i, String s, Message message) {
        int j = translateStatus(i);
        RILRequest rilrequest = RILRequest.obtain(96, message);
        rilrequest.mp.writeInt(j);
        rilrequest.mp.writeString(s);
        send(rilrequest);
    }

    public void writeSmsToSim(int i, String s, String s1, Message message) {
        int j = translateStatus(i);
        RILRequest rilrequest = RILRequest.obtain(63, message);
        rilrequest.mp.writeInt(j);
        rilrequest.mp.writeString(s1);
        rilrequest.mp.writeString(s);
        send(rilrequest);
    }

    private static final int CDMA_BROADCAST_SMS_NO_OF_SERVICE_CATEGORIES = 31;
    private static final int CDMA_BSI_NO_OF_INTS_STRUCT = 3;
    private static final int DEFAULT_WAKE_LOCK_TIMEOUT = 60000;
    static final int EVENT_SEND = 1;
    static final int EVENT_WAKE_LOCK_TIMEOUT = 2;
    static final String LOG_TAG = "RILJ";
    static final int RESPONSE_SOLICITED = 0;
    static final int RESPONSE_UNSOLICITED = 1;
    static final boolean RILJ_LOGD = true;
    static final boolean RILJ_LOGV = false;
    static final int RIL_MAX_COMMAND_BYTES = 8192;
    static final String SOCKET_NAME_RIL = "rild";
    static final int SOCKET_OPEN_RETRY_MILLIS = 4000;
    BroadcastReceiver mIntentReceiver;
    Object mLastNITZTimeInfo;
    RILReceiver mReceiver;
    Thread mReceiverThread;
    int mRequestMessagesPending;
    int mRequestMessagesWaiting;
    ArrayList mRequestsList;
    RILSender mSender;
    HandlerThread mSenderThread;
    private int mSetPreferredNetworkType;
    LocalSocket mSocket;
    AtomicBoolean mTestingEmergencyCall;
    android.os.PowerManager.WakeLock mWakeLock;
    int mWakeLockTimeout;







}

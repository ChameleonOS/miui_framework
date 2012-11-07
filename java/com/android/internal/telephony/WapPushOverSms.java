// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.content.*;
import android.os.IBinder;
import android.os.RemoteException;
import miui.provider.ExtraTelephony;

// Referenced classes of package com.android.internal.telephony:
//            Phone, WspTypeDecoder, IWapPushManager, SMSDispatcher

public class WapPushOverSms {
    private class WapPushConnection
        implements ServiceConnection {

        private void rebindWapPushManager() {
            if(mWapPushMan == null)
                (new Thread() {

                    public void run() {
                        while(mWapPushMan == null)  {
                            mOwner.bindService(new Intent(com/android/internal/telephony/IWapPushManager.getName()), wapPushConnection, 1);
                            try {
                                Thread.sleep(1000L);
                            }
                            catch(InterruptedException interruptedexception) { }
                        }
                    }

                    final WapPushConnection this$1;
                    final ServiceConnection val$wapPushConnection;

                 {
                    this$1 = WapPushConnection.this;
                    wapPushConnection = serviceconnection;
                    super();
                }
                }).start();
        }

        public void bindWapPushManager() {
            if(mWapPushMan == null)
                mOwner.bindService(new Intent(com/android/internal/telephony/IWapPushManager.getName()), this, 1);
        }

        public IWapPushManager getWapPushManager() {
            return mWapPushMan;
        }

        public void onServiceConnected(ComponentName componentname, IBinder ibinder) {
            mWapPushMan = IWapPushManager.Stub.asInterface(ibinder);
        }

        public void onServiceDisconnected(ComponentName componentname) {
            mWapPushMan = null;
            rebindWapPushManager();
        }

        private Context mOwner;
        private IWapPushManager mWapPushMan;
        final WapPushOverSms this$0;



        public WapPushConnection(Context context) {
            this$0 = WapPushOverSms.this;
            super();
            mOwner = context;
        }
    }

    static class Injector {

        static boolean checkFirewallForWapPush(WapPushOverSms wappushoversms, byte abyte0[]) {
            boolean flag = true;
            if(ExtraTelephony.checkFirewallForWapPush(wappushoversms.getContext(), abyte0))
                wappushoversms.getSmsDispatcher().acknowledgeLastIncomingSms(flag, -1, null);
            else
                flag = false;
            return flag;
        }

        Injector() {
        }
    }


    public WapPushOverSms(Phone phone, SMSDispatcher smsdispatcher) {
        mWapConn = null;
        mSmsDispatcher = smsdispatcher;
        mContext = phone.getContext();
        mWapConn = new WapPushConnection(mContext);
        mWapConn.bindWapPushManager();
    }

    public int dispatchWapPdu(byte abyte0[]) {
        int j;
        int k;
        int l;
        int i = 0 + 1;
        j = 0xff & abyte0[0];
        k = i + 1;
        l = 0xff & abyte0[i];
        if(l == 6 || l == 7) goto _L2; else goto _L1
_L1:
        int j2 = 1;
_L10:
        return j2;
_L2:
        int i1;
        int j1;
        String s;
        long l1;
        int k1;
        byte abyte1[];
        WspTypeDecoder wsptypedecoder = new WspTypeDecoder(abyte0);
        pduDecoder = wsptypedecoder;
        if(!pduDecoder.decodeUintvarInteger(k)) {
            j2 = 2;
            continue; /* Loop/switch isn't completed */
        }
        i1 = (int)pduDecoder.getValue32();
        j1 = 2 + pduDecoder.getDecodedDataLength();
        if(!pduDecoder.decodeContentType(j1)) {
            j2 = 2;
            continue; /* Loop/switch isn't completed */
        }
        s = pduDecoder.getValueString();
        l1 = pduDecoder.getValue32();
        k1 = j1 + pduDecoder.getDecodedDataLength();
        abyte1 = new byte[i1];
        System.arraycopy(abyte0, j1, abyte1, 0, abyte1.length);
        if(s == null || !s.equals("application/vnd.wap.coc")) goto _L4; else goto _L3
_L3:
        byte abyte2[] = abyte0;
_L8:
        String s2;
        String s3;
        boolean flag;
        IWapPushManager iwappushmanager;
        if(!pduDecoder.seekXWapApplicationId(k1, -1 + (k1 + i1)))
            break MISSING_BLOCK_LABEL_444;
        int k2 = (int)pduDecoder.getValue32();
        pduDecoder.decodeXWapApplicationId(k2);
        s2 = pduDecoder.getValueString();
        if(s2 == null)
            s2 = Integer.toString((int)pduDecoder.getValue32());
        int i2;
        if(s == null)
            s3 = Long.toString(l1);
        else
            s3 = s;
        flag = true;
        iwappushmanager = mWapConn.getWapPushManager();
        if(iwappushmanager != null) goto _L6; else goto _L5
_L5:
        if(!flag) {
            j2 = 1;
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_444;
_L4:
        i2 = j1 + i1;
        abyte2 = new byte[abyte0.length - i2];
        System.arraycopy(abyte0, i2, abyte2, 0, abyte2.length);
        if(!Injector.checkFirewallForWapPush(this, abyte2)) goto _L8; else goto _L7
_L7:
        j2 = -1;
        continue; /* Loop/switch isn't completed */
_L6:
        int l2;
        Intent intent1 = new Intent();
        intent1.putExtra("transactionId", j);
        intent1.putExtra("pduType", l);
        intent1.putExtra("header", abyte1);
        intent1.putExtra("data", abyte2);
        intent1.putExtra("contentTypeParameters", pduDecoder.getContentParameters());
        l2 = iwappushmanager.processMessage(s2, s3, intent1);
        if((l2 & 1) > 0 && (0x8000 & l2) == 0)
            flag = false;
          goto _L5
        RemoteException remoteexception;
        remoteexception;
        if(s == null) {
            j2 = 2;
        } else {
            String s1;
            Intent intent;
            if(s.equals("application/vnd.wap.mms-message"))
                s1 = "android.permission.RECEIVE_MMS";
            else
                s1 = "android.permission.RECEIVE_WAP_PUSH";
            intent = new Intent("android.provider.Telephony.WAP_PUSH_RECEIVED");
            intent.setType(s);
            intent.putExtra("transactionId", j);
            intent.putExtra("pduType", l);
            intent.putExtra("header", abyte1);
            intent.putExtra("data", abyte2);
            intent.putExtra("contentTypeParameters", pduDecoder.getContentParameters());
            intent.putExtra("address", mAddress);
            mSmsDispatcher.dispatch(intent, s1);
            j2 = -1;
        }
        if(true) goto _L10; else goto _L9
_L9:
    }

    public int dispatchWapPdu(byte abyte0[], String s) {
        mAddress = s;
        return dispatchWapPdu(abyte0);
    }

    Context getContext() {
        return mContext;
    }

    SMSDispatcher getSmsDispatcher() {
        return mSmsDispatcher;
    }

    private static final String LOG_TAG = "WAP PUSH";
    private final int BIND_RETRY_INTERVAL = 1000;
    private final int WAKE_LOCK_TIMEOUT = 5000;
    String mAddress;
    private final Context mContext;
    private SMSDispatcher mSmsDispatcher;
    private WapPushConnection mWapConn;
    private WspTypeDecoder pduDecoder;
}

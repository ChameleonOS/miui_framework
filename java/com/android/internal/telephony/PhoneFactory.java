// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.content.Context;
import android.net.LocalServerSocket;
import android.os.Looper;
import android.util.Log;
import com.android.internal.telephony.cdma.CDMALTEPhone;
import com.android.internal.telephony.cdma.CDMAPhone;
import com.android.internal.telephony.gsm.GSMPhone;
import com.android.internal.telephony.sip.SipPhone;
import com.android.internal.telephony.sip.SipPhoneFactory;
import java.io.IOException;

// Referenced classes of package com.android.internal.telephony:
//            PhoneProxy, BaseCommands, Phone, DefaultPhoneNotifier, 
//            RIL, CommandsInterface, PhoneNotifier

public class PhoneFactory {

    public PhoneFactory() {
    }

    public static Phone getCdmaPhone() {
        Object obj = PhoneProxy.lockForRadioTechnologyChange;
        obj;
        JVM INSTR monitorenter ;
        BaseCommands.getLteOnCdmaModeStatic();
        JVM INSTR tableswitch 1 1: default 28
    //                   1 49;
           goto _L1 _L2
_L1:
        Object obj1 = new CDMAPhone(sContext, sCommandsInterface, sPhoneNotifier);
_L4:
        obj;
        JVM INSTR monitorexit ;
        return ((Phone) (obj1));
_L2:
        obj1 = new CDMALTEPhone(sContext, sCommandsInterface, sPhoneNotifier);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static Phone getDefaultPhone() {
        if(sLooper != Looper.myLooper())
            throw new RuntimeException("PhoneFactory.getDefaultPhone must be called from Looper thread");
        if(!sMadeDefaults)
            throw new IllegalStateException("Default phones haven't been made yet!");
        else
            return sProxyPhone;
    }

    public static Phone getGsmPhone() {
        Object obj = PhoneProxy.lockForRadioTechnologyChange;
        obj;
        JVM INSTR monitorenter ;
        GSMPhone gsmphone = new GSMPhone(sContext, sCommandsInterface, sPhoneNotifier);
        return gsmphone;
    }

    public static int getPhoneType(int i) {
        byte byte0 = 2;
        i;
        JVM INSTR tableswitch 0 11: default 64
    //                   0 68
    //                   1 68
    //                   2 68
    //                   3 68
    //                   4 66
    //                   5 66
    //                   6 66
    //                   7 66
    //                   8 66
    //                   9 64
    //                   10 66
    //                   11 73;
           goto _L1 _L2 _L2 _L2 _L2 _L3 _L3 _L3 _L3 _L3 _L1 _L3 _L4
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        byte0 = 1;
_L6:
        return byte0;
_L2:
        byte0 = 1;
        continue; /* Loop/switch isn't completed */
_L4:
        if(BaseCommands.getLteOnCdmaModeStatic() != 1)
            byte0 = 1;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public static void makeDefaultPhone(Context context) {
        com/android/internal/telephony/Phone;
        JVM INSTR monitorenter ;
        if(sMadeDefaults) goto _L2; else goto _L1
_L1:
        Exception exception;
        sLooper = Looper.myLooper();
        sContext = context;
        if(sLooper == null)
            throw new RuntimeException("PhoneFactory.makeDefaultPhone must be called from Looper thread");
        if(true)
            break MISSING_BLOCK_LABEL_41;
        JVM INSTR monitorexit ;
        throw exception;
        int i = 0;
_L10:
        boolean flag = false;
        i++;
        InterruptedException interruptedexception;
        byte byte0;
        int j;
        int k;
        int l;
        try {
            new LocalServerSocket("com.android.internal.telephony");
        }
        catch(IOException ioexception) {
            flag = true;
        }
        finally {
            com/android/internal/telephony/Phone;
        }
        if(flag) goto _L4; else goto _L3
_L3:
        sPhoneNotifier = new DefaultPhoneNotifier();
        byte0 = 0;
        if(BaseCommands.getLteOnCdmaModeStatic() == 1)
            byte0 = 7;
        j = android.provider.Settings.Secure.getInt(context.getContentResolver(), "preferred_network_mode", byte0);
        Log.i("PHONE", (new StringBuilder()).append("Network Mode set to ").append(Integer.toString(j)).toString());
        BaseCommands.getLteOnCdmaModeStatic();
        JVM INSTR tableswitch 0 1: default 152
    //                   0 295
    //                   1 309;
           goto _L5 _L6 _L7
_L5:
        k = android.provider.Settings.Secure.getInt(context.getContentResolver(), "preferred_cdma_subscription", 1);
        Log.i("PHONE", "lteOnCdma not set, using PREFERRED_CDMA_SUBSCRIPTION");
_L11:
        Log.i("PHONE", (new StringBuilder()).append("Cdma Subscription set to ").append(k).toString());
        sCommandsInterface = new RIL(context, j, k);
        l = getPhoneType(j);
        if(l != 1) goto _L9; else goto _L8
_L8:
        Log.i("PHONE", "Creating GSMPhone");
        sProxyPhone = new PhoneProxy(new GSMPhone(context, sCommandsInterface, sPhoneNotifier));
_L13:
        sMadeDefaults = true;
_L2:
        com/android/internal/telephony/Phone;
        JVM INSTR monitorexit ;
        return;
_L4:
        if(i > 3)
            throw new RuntimeException("PhoneFactory probably already running");
        try {
            Thread.sleep(2000L);
        }
        // Misplaced declaration of an exception variable
        catch(InterruptedException interruptedexception) { }
          goto _L10
_L6:
        k = 1;
        Log.i("PHONE", "lteOnCdma is 0 use SUBSCRIPTION_FROM_NV");
          goto _L11
_L7:
        k = 0;
        Log.i("PHONE", "lteOnCdma is 1 use SUBSCRIPTION_FROM_RUIM");
          goto _L11
_L9:
        if(l != 2) goto _L13; else goto _L12
_L12:
        BaseCommands.getLteOnCdmaModeStatic();
        JVM INSTR tableswitch 1 1: default 352
    //                   1 387;
           goto _L14 _L15
_L18:
        if(true) goto _L13; else goto _L16
_L16:
_L20:
        if(true) goto _L18; else goto _L17
_L17:
_L22:
        if(true) goto _L20; else goto _L19
_L19:
_L24:
        if(true) goto _L22; else goto _L21
_L21:
_L26:
        if(true) goto _L24; else goto _L23
_L23:
_L28:
        if(true) goto _L26; else goto _L25
_L25:
_L30:
        if(true) goto _L28; else goto _L27
_L27:
_L32:
        if(true) goto _L30; else goto _L29
_L29:
_L34:
        if(true) goto _L32; else goto _L31
_L31:
_L33:
_L14:
        Log.i("PHONE", "Creating CDMAPhone");
        sProxyPhone = new PhoneProxy(new CDMAPhone(context, sCommandsInterface, sPhoneNotifier));
          goto _L13
_L15:
        Log.i("PHONE", "Creating CDMALTEPhone");
        sProxyPhone = new PhoneProxy(new CDMALTEPhone(context, sCommandsInterface, sPhoneNotifier));
          goto _L13
    }

    public static void makeDefaultPhones(Context context) {
        makeDefaultPhone(context);
    }

    public static SipPhone makeSipPhone(String s) {
        return SipPhoneFactory.makePhone(s, sContext, sPhoneNotifier);
    }

    static final String LOG_TAG = "PHONE";
    static final int SOCKET_OPEN_MAX_RETRY = 3;
    static final int SOCKET_OPEN_RETRY_MILLIS = 2000;
    static final int preferredCdmaSubscription = 1;
    private static CommandsInterface sCommandsInterface = null;
    private static Context sContext;
    private static Looper sLooper;
    private static boolean sMadeDefaults = false;
    private static PhoneNotifier sPhoneNotifier;
    private static Phone sProxyPhone = null;

}

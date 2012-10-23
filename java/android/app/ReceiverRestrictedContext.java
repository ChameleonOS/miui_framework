// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.*;
import android.os.Handler;

class ReceiverRestrictedContext extends ContextWrapper {

    ReceiverRestrictedContext(Context context) {
        super(context);
    }

    public boolean bindService(Intent intent, ServiceConnection serviceconnection, int i) {
        throw new ReceiverCallNotAllowedException("IntentReceiver components are not allowed to bind to services");
    }

    public Intent registerReceiver(BroadcastReceiver broadcastreceiver, IntentFilter intentfilter) {
        return registerReceiver(broadcastreceiver, intentfilter, null, null);
    }

    public Intent registerReceiver(BroadcastReceiver broadcastreceiver, IntentFilter intentfilter, String s, Handler handler) {
        throw new ReceiverCallNotAllowedException("IntentReceiver components are not allowed to register to receive intents");
    }
}

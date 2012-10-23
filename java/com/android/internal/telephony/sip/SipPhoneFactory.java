// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.sip;

import android.content.Context;
import android.util.Log;
import com.android.internal.telephony.PhoneNotifier;
import java.text.ParseException;

// Referenced classes of package com.android.internal.telephony.sip:
//            SipPhone

public class SipPhoneFactory {

    public SipPhoneFactory() {
    }

    public static SipPhone makePhone(String s, Context context, PhoneNotifier phonenotifier) {
        SipPhone sipphone;
        try {
            sipphone = new SipPhone(context, phonenotifier, (new android.net.sip.SipProfile.Builder(s)).build());
        }
        catch(ParseException parseexception) {
            Log.w("SipPhoneFactory", "makePhone", parseexception);
            sipphone = null;
        }
        return sipphone;
    }
}

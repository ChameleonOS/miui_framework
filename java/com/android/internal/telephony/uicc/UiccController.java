// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.uicc;

import android.util.Log;
import com.android.internal.telephony.IccCard;
import com.android.internal.telephony.PhoneBase;
import com.android.internal.telephony.cdma.CDMALTEPhone;
import com.android.internal.telephony.cdma.CDMAPhone;
import com.android.internal.telephony.gsm.GSMPhone;

public class UiccController {

    private UiccController(PhoneBase phonebase) {
        log("Creating UiccController");
        setNewPhone(phonebase);
    }

    /**
     * @deprecated Method getInstance is deprecated
     */

    public static UiccController getInstance(PhoneBase phonebase) {
        com/android/internal/telephony/uicc/UiccController;
        JVM INSTR monitorenter ;
        if(mInstance != null)
            break MISSING_BLOCK_LABEL_29;
        mInstance = new UiccController(phonebase);
_L1:
        UiccController uicccontroller = mInstance;
        com/android/internal/telephony/uicc/UiccController;
        JVM INSTR monitorexit ;
        return uicccontroller;
        mInstance.setNewPhone(phonebase);
          goto _L1
        Exception exception;
        exception;
        throw exception;
    }

    private void log(String s) {
        Log.d("RIL_UiccController", s);
    }

    private void setNewPhone(PhoneBase phonebase) {
        mCurrentPhone = phonebase;
        if(phonebase instanceof GSMPhone) {
            log("New phone is GSMPhone");
            updateCurrentCard(true);
        } else
        if(phonebase instanceof CDMALTEPhone) {
            log("New phone type is CDMALTEPhone");
            updateCurrentCard(true);
        } else
        if(phonebase instanceof CDMAPhone) {
            log("New phone type is CDMAPhone");
            updateCurrentCard(false);
        } else {
            Log.e("RIL_UiccController", "Unhandled phone type. Critical error!");
        }
    }

    private void updateCurrentCard(boolean flag) {
        if(mIsCurrentCard3gpp != flag || mIccCard == null) {
            if(mIccCard != null) {
                mIccCard.dispose();
                mIccCard = null;
            }
            mIsCurrentCard3gpp = flag;
            mIccCard = new IccCard(mCurrentPhone, mCurrentPhone.getPhoneName(), Boolean.valueOf(flag), Boolean.valueOf(true));
        }
    }

    public IccCard getIccCard() {
        return mIccCard;
    }

    private static final boolean DBG = true;
    private static final String LOG_TAG = "RIL_UiccController";
    private static UiccController mInstance;
    private PhoneBase mCurrentPhone;
    private IccCard mIccCard;
    private boolean mIsCurrentCard3gpp;
}

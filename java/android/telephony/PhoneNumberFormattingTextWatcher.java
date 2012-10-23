// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.telephony;

import android.text.*;
import com.android.i18n.phonenumbers.AsYouTypeFormatter;
import com.android.i18n.phonenumbers.PhoneNumberUtil;
import java.util.Locale;

// Referenced classes of package android.telephony:
//            PhoneNumberUtils

public class PhoneNumberFormattingTextWatcher
    implements TextWatcher {

    public PhoneNumberFormattingTextWatcher() {
        this(Locale.getDefault().getCountry());
    }

    public PhoneNumberFormattingTextWatcher(String s) {
        mSelfChange = false;
        if(s == null) {
            throw new IllegalArgumentException();
        } else {
            mFormatter = PhoneNumberUtil.getInstance().getAsYouTypeFormatter(s);
            return;
        }
    }

    private String getFormattedNumber(char c, boolean flag) {
        String s;
        if(flag)
            s = mFormatter.inputDigitAndRememberPosition(c);
        else
            s = mFormatter.inputDigit(c);
        return s;
    }

    private boolean hasSeparator(CharSequence charsequence, int i, int j) {
        int k = i;
_L3:
        if(k >= i + j)
            break MISSING_BLOCK_LABEL_37;
        if(PhoneNumberUtils.isNonSeparator(charsequence.charAt(k))) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        k++;
          goto _L3
        flag = false;
          goto _L4
    }

    private String reformat(CharSequence charsequence, int i) {
        int j = i - 1;
        String s = null;
        mFormatter.clear();
        char c = '\0';
        boolean flag = false;
        int k = charsequence.length();
        for(int l = 0; l < k; l++) {
            char c1 = charsequence.charAt(l);
            if(PhoneNumberUtils.isNonSeparator(c1)) {
                if(c != 0) {
                    s = getFormattedNumber(c, flag);
                    flag = false;
                }
                c = c1;
            }
            if(l == j)
                flag = true;
        }

        if(c != 0)
            s = getFormattedNumber(c, flag);
        return s;
    }

    private void stopFormatting() {
        mStopFormatting = true;
        mFormatter.clear();
    }

    /**
     * @deprecated Method afterTextChanged is deprecated
     */

    public void afterTextChanged(Editable editable) {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        if(!mStopFormatting) goto _L2; else goto _L1
_L1:
        if(editable.length() == 0)
            flag = false;
        mStopFormatting = flag;
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if(!mSelfChange) {
            String s = reformat(editable, Selection.getSelectionEnd(editable));
            if(s != null) {
                int i = mFormatter.getRememberedPosition();
                mSelfChange = true;
                editable.replace(0, editable.length(), s, 0, s.length());
                if(s.equals(editable.toString()))
                    Selection.setSelection(editable, i);
                mSelfChange = false;
            }
        }
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k) {
        if(!mSelfChange && !mStopFormatting && j > 0 && hasSeparator(charsequence, i, j))
            stopFormatting();
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k) {
        if(!mSelfChange && !mStopFormatting && k > 0 && hasSeparator(charsequence, i, k))
            stopFormatting();
    }

    private AsYouTypeFormatter mFormatter;
    private boolean mSelfChange;
    private boolean mStopFormatting;
}

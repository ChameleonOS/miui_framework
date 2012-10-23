// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.method;

import android.text.SpannableStringBuilder;
import android.text.Spanned;

// Referenced classes of package android.text.method:
//            NumberKeyListener

public class DigitsKeyListener extends NumberKeyListener {

    public DigitsKeyListener() {
        this(false, false);
    }

    public DigitsKeyListener(boolean flag, boolean flag1) {
        byte byte0 = 0;
        super();
        mSign = flag;
        mDecimal = flag1;
        boolean flag2;
        int i;
        if(flag)
            flag2 = true;
        else
            flag2 = false;
        if(flag1)
            byte0 = 2;
        i = flag2 | byte0;
        mAccepted = CHARACTERS[i];
    }

    public static DigitsKeyListener getInstance() {
        return getInstance(false, false);
    }

    public static DigitsKeyListener getInstance(String s) {
        DigitsKeyListener digitskeylistener = new DigitsKeyListener();
        digitskeylistener.mAccepted = new char[s.length()];
        s.getChars(0, s.length(), digitskeylistener.mAccepted, 0);
        return digitskeylistener;
    }

    public static DigitsKeyListener getInstance(boolean flag, boolean flag1) {
        byte byte0 = 0;
        boolean flag2;
        int i;
        DigitsKeyListener digitskeylistener;
        if(flag)
            flag2 = true;
        else
            flag2 = false;
        if(flag1)
            byte0 = 2;
        i = flag2 | byte0;
        if(sInstance[i] != null) {
            digitskeylistener = sInstance[i];
        } else {
            sInstance[i] = new DigitsKeyListener(flag, flag1);
            digitskeylistener = sInstance[i];
        }
        return digitskeylistener;
    }

    public CharSequence filter(CharSequence charsequence, int i, int j, Spanned spanned, int k, int l) {
        Object obj = super.filter(charsequence, i, j, spanned, k, l);
        if(mSign || mDecimal) goto _L2; else goto _L1
_L1:
        return ((CharSequence) (obj));
_L2:
        int i1;
        int j1;
        SpannableStringBuilder spannablestringbuilder;
        int j2;
        if(obj != null) {
            charsequence = ((CharSequence) (obj));
            i = 0;
            j = ((CharSequence) (obj)).length();
        }
        i1 = -1;
        j1 = -1;
        int k1 = spanned.length();
        int l1 = 0;
        while(l1 < k)  {
            char c2 = spanned.charAt(l1);
            if(c2 == '-')
                i1 = l1;
            else
            if(c2 == '.')
                j1 = l1;
            l1++;
        }
        for(int i2 = l; i2 < k1; i2++) {
            char c1 = spanned.charAt(i2);
            if(c1 == '-') {
                obj = "";
                continue; /* Loop/switch isn't completed */
            }
            if(c1 == '.')
                j1 = i2;
        }

        spannablestringbuilder = null;
        j2 = j - 1;
_L9:
        if(j2 < i) goto _L4; else goto _L3
_L3:
        char c;
        boolean flag;
        c = charsequence.charAt(j2);
        flag = false;
        if(c != '-') goto _L6; else goto _L5
_L5:
        if(j2 != i || k != 0)
            flag = true;
        else
        if(i1 >= 0)
            flag = true;
        else
            i1 = j2;
_L8:
        if(!flag)
            continue; /* Loop/switch isn't completed */
        if(j != i + 1)
            break; /* Loop/switch isn't completed */
        obj = "";
        continue; /* Loop/switch isn't completed */
_L6:
        if(c == '.')
            if(j1 >= 0)
                flag = true;
            else
                j1 = j2;
        if(true) goto _L8; else goto _L7
_L7:
        if(spannablestringbuilder == null)
            spannablestringbuilder = new SpannableStringBuilder(charsequence, i, j);
        spannablestringbuilder.delete(j2 - i, (j2 + 1) - i);
        j2--;
          goto _L9
_L4:
        if(spannablestringbuilder != null)
            obj = spannablestringbuilder;
        else
        if(obj == null)
            obj = null;
        if(true) goto _L1; else goto _L10
_L10:
    }

    protected char[] getAcceptedChars() {
        return mAccepted;
    }

    public int getInputType() {
        int i = 2;
        if(mSign)
            i |= 0x1000;
        if(mDecimal)
            i |= 0x2000;
        return i;
    }

    private static final char CHARACTERS[][];
    private static final int DECIMAL = 2;
    private static final int SIGN = 1;
    private static DigitsKeyListener sInstance[] = new DigitsKeyListener[4];
    private char mAccepted[];
    private boolean mDecimal;
    private boolean mSign;

    static  {
        char ac[][] = new char[4][];
        char ac1[] = new char[10];
        ac1[0] = '0';
        ac1[1] = '1';
        ac1[2] = '2';
        ac1[3] = '3';
        ac1[4] = '4';
        ac1[5] = '5';
        ac1[6] = '6';
        ac1[7] = '7';
        ac1[8] = '8';
        ac1[9] = '9';
        ac[0] = ac1;
        char ac2[] = new char[11];
        ac2[0] = '0';
        ac2[1] = '1';
        ac2[2] = '2';
        ac2[3] = '3';
        ac2[4] = '4';
        ac2[5] = '5';
        ac2[6] = '6';
        ac2[7] = '7';
        ac2[8] = '8';
        ac2[9] = '9';
        ac2[10] = '-';
        ac[1] = ac2;
        char ac3[] = new char[11];
        ac3[0] = '0';
        ac3[1] = '1';
        ac3[2] = '2';
        ac3[3] = '3';
        ac3[4] = '4';
        ac3[5] = '5';
        ac3[6] = '6';
        ac3[7] = '7';
        ac3[8] = '8';
        ac3[9] = '9';
        ac3[10] = '.';
        ac[2] = ac3;
        char ac4[] = new char[12];
        ac4[0] = '0';
        ac4[1] = '1';
        ac4[2] = '2';
        ac4[3] = '3';
        ac4[4] = '4';
        ac4[5] = '5';
        ac4[6] = '6';
        ac4[7] = '7';
        ac4[8] = '8';
        ac4[9] = '9';
        ac4[10] = '-';
        ac4[11] = '.';
        ac[3] = ac4;
        CHARACTERS = ac;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.method;

import android.text.Spannable;
import android.view.KeyEvent;

// Referenced classes of package android.text.method:
//            NumberKeyListener

public class DialerKeyListener extends NumberKeyListener {

    public DialerKeyListener() {
    }

    public static DialerKeyListener getInstance() {
        DialerKeyListener dialerkeylistener;
        if(sInstance != null) {
            dialerkeylistener = sInstance;
        } else {
            sInstance = new DialerKeyListener();
            dialerkeylistener = sInstance;
        }
        return dialerkeylistener;
    }

    protected char[] getAcceptedChars() {
        return CHARACTERS;
    }

    public int getInputType() {
        return 3;
    }

    protected int lookup(KeyEvent keyevent, Spannable spannable) {
        int i;
        int j;
        i = keyevent.getMetaState() | getMetaState(spannable);
        j = keyevent.getNumber();
        if((i & 3) != 0 || j == 0) goto _L2; else goto _L1
_L1:
        return j;
_L2:
        android.view.KeyCharacterMap.KeyData keydata;
        char ac[];
        int l;
        int k = super.lookup(keyevent, spannable);
        if(k != 0) {
            j = k;
            continue; /* Loop/switch isn't completed */
        }
        if(i == 0)
            continue; /* Loop/switch isn't completed */
        keydata = new android.view.KeyCharacterMap.KeyData();
        ac = getAcceptedChars();
        if(!keyevent.getKeyData(keydata))
            continue; /* Loop/switch isn't completed */
        l = 1;
_L4:
        if(l < keydata.meta.length) {
label0:
            {
                if(!ok(ac, keydata.meta[l]))
                    break label0;
                j = keydata.meta[l];
            }
        }
        if(true) goto _L1; else goto _L3
_L3:
        l++;
          goto _L4
        if(true) goto _L1; else goto _L5
_L5:
    }

    public static final char CHARACTERS[];
    private static DialerKeyListener sInstance;

    static  {
        char ac[] = new char[22];
        ac[0] = '0';
        ac[1] = '1';
        ac[2] = '2';
        ac[3] = '3';
        ac[4] = '4';
        ac[5] = '5';
        ac[6] = '6';
        ac[7] = '7';
        ac[8] = '8';
        ac[9] = '9';
        ac[10] = '#';
        ac[11] = '*';
        ac[12] = '+';
        ac[13] = '-';
        ac[14] = '(';
        ac[15] = ')';
        ac[16] = ',';
        ac[17] = '/';
        ac[18] = 'N';
        ac[19] = '.';
        ac[20] = ' ';
        ac[21] = ';';
        CHARACTERS = ac;
    }
}

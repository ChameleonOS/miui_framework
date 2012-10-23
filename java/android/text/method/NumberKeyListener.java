// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.method;

import android.text.*;
import android.view.KeyEvent;
import android.view.View;

// Referenced classes of package android.text.method:
//            BaseKeyListener

public abstract class NumberKeyListener extends BaseKeyListener
    implements InputFilter {

    public NumberKeyListener() {
    }

    protected static boolean ok(char ac[], char c) {
        int i = -1 + ac.length;
_L3:
        if(i < 0)
            break MISSING_BLOCK_LABEL_27;
        if(ac[i] != c) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        i--;
          goto _L3
        flag = false;
          goto _L4
    }

    public CharSequence filter(CharSequence charsequence, int i, int j, Spanned spanned, int k, int l) {
        char ac[] = getAcceptedChars();
        int i1 = i;
        do {
            if(i1 >= j || !ok(ac, charsequence.charAt(i1))) {
                Object obj;
                if(i1 == j)
                    obj = null;
                else
                if(j - i == 1) {
                    obj = "";
                } else {
                    obj = new SpannableStringBuilder(charsequence, i, j);
                    int j1 = i1 - i;
                    int k1 = j - i;
                    int _tmp = k1 - i;
                    int l1 = k1 - 1;
                    while(l1 >= j1)  {
                        if(!ok(ac, charsequence.charAt(l1)))
                            ((SpannableStringBuilder) (obj)).delete(l1, l1 + 1);
                        l1--;
                    }
                }
                return ((CharSequence) (obj));
            }
            i1++;
        } while(true);
    }

    protected abstract char[] getAcceptedChars();

    protected int lookup(KeyEvent keyevent, Spannable spannable) {
        return keyevent.getMatch(getAcceptedChars(), keyevent.getMetaState() | getMetaState(spannable));
    }

    public boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyevent) {
        boolean flag;
        int j;
        int i1;
        int j1;
        int k1;
        flag = true;
        j = 0;
        int k = Selection.getSelectionStart(editable);
        int l = Selection.getSelectionEnd(editable);
        i1 = Math.min(k, l);
        j1 = Math.max(k, l);
        if(i1 < 0 || j1 < 0) {
            j1 = 0;
            i1 = 0;
            Selection.setSelection(editable, 0);
        }
        if(keyevent != null)
            k1 = lookup(keyevent, editable);
        else
            k1 = 0;
        if(keyevent != null)
            j = keyevent.getRepeatCount();
        if(j != 0) goto _L2; else goto _L1
_L1:
        if(k1 == 0) goto _L4; else goto _L3
_L3:
        if(i1 != j1)
            Selection.setSelection(editable, j1);
        editable.replace(i1, j1, String.valueOf(k1));
        adjustMetaAfterKeypress(editable);
_L6:
        return flag;
_L2:
        if(k1 == 48 && j == flag && i1 == j1 && j1 > 0 && editable.charAt(i1 - 1) == '0') {
            editable.replace(i1 - 1, j1, String.valueOf('+'));
            adjustMetaAfterKeypress(editable);
            continue; /* Loop/switch isn't completed */
        }
_L4:
        adjustMetaAfterKeypress(editable);
        flag = super.onKeyDown(view, editable, i, keyevent);
        if(true) goto _L6; else goto _L5
_L5:
    }
}

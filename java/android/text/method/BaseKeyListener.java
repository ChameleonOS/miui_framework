// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.method;

import android.text.*;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

// Referenced classes of package android.text.method:
//            MetaKeyKeyListener, KeyListener

public abstract class BaseKeyListener extends MetaKeyKeyListener
    implements KeyListener {

    public BaseKeyListener() {
    }

    private boolean backspaceOrForwardDelete(View view, Editable editable, int i, KeyEvent keyevent, boolean flag) {
        boolean flag1 = false;
        if(KeyEvent.metaStateHasNoModifiers(0xffffff0c & keyevent.getMetaState())) goto _L2; else goto _L1
_L1:
        return flag1;
_L2:
        if(deleteSelection(view, editable))
            flag1 = true;
        else
        if((keyevent.isAltPressed() || getMetaState(editable, 2) == 1) && deleteLine(view, editable)) {
            flag1 = true;
        } else {
            int j = Selection.getSelectionEnd(editable);
            int k;
            if(flag || keyevent.isShiftPressed() || getMetaState(editable, 1) == 1)
                k = TextUtils.getOffsetAfter(editable, j);
            else
                k = TextUtils.getOffsetBefore(editable, j);
            if(j != k) {
                editable.delete(Math.min(j, k), Math.max(j, k));
                flag1 = true;
            }
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private boolean deleteLine(View view, Editable editable) {
        if(!(view instanceof TextView)) goto _L2; else goto _L1
_L1:
        Layout layout = ((TextView)view).getLayout();
        if(layout == null) goto _L2; else goto _L3
_L3:
        int j;
        int k;
        int i = layout.getLineForOffset(Selection.getSelectionStart(editable));
        j = layout.getLineStart(i);
        k = layout.getLineEnd(i);
        if(k == j) goto _L2; else goto _L4
_L4:
        boolean flag;
        editable.delete(j, k);
        flag = true;
_L6:
        return flag;
_L2:
        flag = false;
        if(true) goto _L6; else goto _L5
_L5:
    }

    private boolean deleteSelection(View view, Editable editable) {
        int i = Selection.getSelectionStart(editable);
        int j = Selection.getSelectionEnd(editable);
        if(j < i) {
            int k = j;
            j = i;
            i = k;
        }
        boolean flag;
        if(i != j) {
            editable.delete(i, j);
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    static int makeTextContentType(TextKeyListener.Capitalize capitalize, boolean flag) {
        int i = 1;
        class _cls1 {

            static final int $SwitchMap$android$text$method$TextKeyListener$Capitalize[];

            static  {
                $SwitchMap$android$text$method$TextKeyListener$Capitalize = new int[TextKeyListener.Capitalize.values().length];
                NoSuchFieldError nosuchfielderror2;
                try {
                    $SwitchMap$android$text$method$TextKeyListener$Capitalize[TextKeyListener.Capitalize.CHARACTERS.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror) { }
                try {
                    $SwitchMap$android$text$method$TextKeyListener$Capitalize[TextKeyListener.Capitalize.WORDS.ordinal()] = 2;
                }
                catch(NoSuchFieldError nosuchfielderror1) { }
                $SwitchMap$android$text$method$TextKeyListener$Capitalize[TextKeyListener.Capitalize.SENTENCES.ordinal()] = 3;
_L2:
                return;
                nosuchfielderror2;
                if(true) goto _L2; else goto _L1
_L1:
            }
        }

        _cls1..SwitchMap.android.text.method.TextKeyListener.Capitalize[capitalize.ordinal()];
        JVM INSTR tableswitch 1 3: default 36
    //                   1 47
    //                   2 56
    //                   3 65;
           goto _L1 _L2 _L3 _L4
_L1:
        if(flag)
            i |= 0x8000;
        return i;
_L2:
        i |= 0x1000;
        continue; /* Loop/switch isn't completed */
_L3:
        i |= 0x2000;
        continue; /* Loop/switch isn't completed */
_L4:
        i |= 0x4000;
        if(true) goto _L1; else goto _L5
_L5:
    }

    public boolean backspace(View view, Editable editable, int i, KeyEvent keyevent) {
        return backspaceOrForwardDelete(view, editable, i, keyevent, false);
    }

    public boolean forwardDelete(View view, Editable editable, int i, KeyEvent keyevent) {
        return backspaceOrForwardDelete(view, editable, i, keyevent, true);
    }

    public boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyevent) {
        i;
        JVM INSTR lookupswitch 2: default 28
    //                   67: 50
    //                   112: 64;
           goto _L1 _L2 _L3
_L1:
        boolean flag = false;
_L5:
        if(flag)
            adjustMetaAfterKeypress(editable);
        return super.onKeyDown(view, editable, i, keyevent);
_L2:
        flag = backspace(view, editable, i, keyevent);
        continue; /* Loop/switch isn't completed */
_L3:
        flag = forwardDelete(view, editable, i, keyevent);
        if(true) goto _L5; else goto _L4
_L4:
    }

    public boolean onKeyOther(View view, Editable editable, KeyEvent keyevent) {
        boolean flag = false;
        if(keyevent.getAction() == 2 && keyevent.getKeyCode() == 0) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        int i = Selection.getSelectionStart(editable);
        int j = Selection.getSelectionEnd(editable);
        if(j < i) {
            int k = j;
            j = i;
            i = k;
        }
        String s = keyevent.getCharacters();
        if(s != null) {
            editable.replace(i, j, s);
            flag = true;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    static final Object OLD_SEL_START = new android.text.NoCopySpan.Concrete();

}

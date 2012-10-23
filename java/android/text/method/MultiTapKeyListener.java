// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.method;

import android.os.Handler;
import android.os.SystemClock;
import android.text.*;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;

// Referenced classes of package android.text.method:
//            BaseKeyListener, TextKeyListener, KeyListener

public class MultiTapKeyListener extends BaseKeyListener
    implements SpanWatcher {
    private class Timeout extends Handler
        implements Runnable {

        public void run() {
            Editable editable = mBuffer;
            if(editable != null) {
                int i = Selection.getSelectionStart(editable);
                int j = Selection.getSelectionEnd(editable);
                int k = editable.getSpanStart(TextKeyListener.ACTIVE);
                int l = editable.getSpanEnd(TextKeyListener.ACTIVE);
                if(i == k && j == l)
                    Selection.setSelection(editable, Selection.getSelectionEnd(editable));
                editable.removeSpan(this);
            }
        }

        private Editable mBuffer;
        final MultiTapKeyListener this$0;


/*
        static Editable access$002(Timeout timeout, Editable editable) {
            timeout.mBuffer = editable;
            return editable;
        }

*/

        public Timeout(Editable editable) {
            this$0 = MultiTapKeyListener.this;
            super();
            mBuffer = editable;
            mBuffer.setSpan(this, 0, mBuffer.length(), 18);
            postAtTime(this, 2000L + SystemClock.uptimeMillis());
        }
    }


    public MultiTapKeyListener(TextKeyListener.Capitalize capitalize, boolean flag) {
        mCapitalize = capitalize;
        mAutoText = flag;
    }

    public static MultiTapKeyListener getInstance(boolean flag, TextKeyListener.Capitalize capitalize) {
        int i = 2 * capitalize.ordinal();
        int j;
        int k;
        if(flag)
            j = 1;
        else
            j = 0;
        k = i + j;
        if(sInstance[k] == null)
            sInstance[k] = new MultiTapKeyListener(capitalize, flag);
        return sInstance[k];
    }

    private static void removeTimeouts(Spannable spannable) {
        Timeout atimeout[] = (Timeout[])spannable.getSpans(0, spannable.length(), android/text/method/MultiTapKeyListener$Timeout);
        for(int i = 0; i < atimeout.length; i++) {
            Timeout timeout = atimeout[i];
            timeout.removeCallbacks(timeout);
            timeout.mBuffer = null;
            spannable.removeSpan(timeout);
        }

    }

    public int getInputType() {
        return makeTextContentType(mCapitalize, mAutoText);
    }

    public boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyevent) {
        int j;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        j = 0;
        if(view != null)
            j = TextKeyListener.getInstance().getPrefs(view.getContext());
        int k = Selection.getSelectionStart(editable);
        int l = Selection.getSelectionEnd(editable);
        i1 = Math.min(k, l);
        j1 = Math.max(k, l);
        k1 = editable.getSpanStart(TextKeyListener.ACTIVE);
        l1 = editable.getSpanEnd(TextKeyListener.ACTIVE);
        i2 = (0xff000000 & editable.getSpanFlags(TextKeyListener.ACTIVE)) >>> 24;
        if(k1 != i1 || l1 != j1 || j1 - i1 != 1 || i2 < 0 || i2 >= sRecs.size()) goto _L2; else goto _L1
_L1:
        if(i != 17) goto _L4; else goto _L3
_L3:
        char c = editable.charAt(i1);
        if(!Character.isLowerCase(c)) goto _L6; else goto _L5
_L5:
        boolean flag;
        editable.replace(i1, j1, String.valueOf(c).toUpperCase());
        removeTimeouts(editable);
        new Timeout(editable);
        flag = true;
_L16:
        return flag;
_L6:
        if(Character.isUpperCase(c)) {
            editable.replace(i1, j1, String.valueOf(c).toLowerCase());
            removeTimeouts(editable);
            new Timeout(editable);
            flag = true;
            continue; /* Loop/switch isn't completed */
        }
_L4:
        int j2;
        if(sRecs.indexOfKey(i) == i2) {
            String s1 = (String)sRecs.valueAt(i2);
            int k4 = s1.indexOf(editable.charAt(i1));
            if(k4 >= 0) {
                int l4 = (k4 + 1) % s1.length();
                editable.replace(i1, j1, s1, l4, l4 + 1);
                removeTimeouts(editable);
                new Timeout(editable);
                flag = true;
                continue; /* Loop/switch isn't completed */
            }
        }
        j2 = sRecs.indexOfKey(i);
        if(j2 >= 0) {
            Selection.setSelection(editable, j1, j1);
            i1 = j1;
        }
_L14:
        String s;
        int k2;
        if(j2 < 0)
            break; /* Loop/switch isn't completed */
        s = (String)sRecs.valueAt(j2);
        k2 = 0;
        if((j & 1) == 0 || !TextKeyListener.shouldCap(mCapitalize, editable, i1)) goto _L8; else goto _L7
_L7:
        int i4 = 0;
_L12:
        int j4 = s.length();
        if(i4 >= j4) goto _L8; else goto _L9
_L9:
        if(!Character.isUpperCase(s.charAt(i4))) goto _L11; else goto _L10
_L10:
        k2 = i4;
          goto _L8
_L2:
        j2 = sRecs.indexOfKey(i);
        continue; /* Loop/switch isn't completed */
_L11:
        i4++;
          goto _L12
_L8:
        if(i1 != j1)
            Selection.setSelection(editable, j1);
        editable.setSpan(OLD_SEL_START, i1, i1, 17);
        int l2 = k2 + 1;
        editable.replace(i1, j1, s, k2, l2);
        int i3 = editable.getSpanStart(OLD_SEL_START);
        int j3 = Selection.getSelectionEnd(editable);
        if(j3 != i3) {
            Selection.setSelection(editable, i3, j3);
            editable.setSpan(TextKeyListener.LAST_TYPED, i3, j3, 33);
            editable.setSpan(TextKeyListener.ACTIVE, i3, j3, 0x21 | j2 << 24);
        }
        removeTimeouts(editable);
        new Timeout(editable);
        if(editable.getSpanStart(this) < 0) {
            KeyListener akeylistener[] = (KeyListener[])editable.getSpans(0, editable.length(), android/text/method/KeyListener);
            int k3 = akeylistener.length;
            for(int l3 = 0; l3 < k3; l3++)
                editable.removeSpan(akeylistener[l3]);

            editable.setSpan(this, 0, editable.length(), 18);
        }
        flag = true;
        continue; /* Loop/switch isn't completed */
        if(true) goto _L14; else goto _L13
_L13:
        flag = super.onKeyDown(view, editable, i, keyevent);
        if(true) goto _L16; else goto _L15
_L15:
    }

    public void onSpanAdded(Spannable spannable, Object obj, int i, int j) {
    }

    public void onSpanChanged(Spannable spannable, Object obj, int i, int j, int k, int l) {
        if(obj == Selection.SELECTION_END) {
            spannable.removeSpan(TextKeyListener.ACTIVE);
            removeTimeouts(spannable);
        }
    }

    public void onSpanRemoved(Spannable spannable, Object obj, int i, int j) {
    }

    private static MultiTapKeyListener sInstance[] = new MultiTapKeyListener[2 * TextKeyListener.Capitalize.values().length];
    private static final SparseArray sRecs;
    private boolean mAutoText;
    private TextKeyListener.Capitalize mCapitalize;

    static  {
        sRecs = new SparseArray();
        sRecs.put(8, ".,1!@#$%^&*:/?'=()");
        sRecs.put(9, "abc2ABC");
        sRecs.put(10, "def3DEF");
        sRecs.put(11, "ghi4GHI");
        sRecs.put(12, "jkl5JKL");
        sRecs.put(13, "mno6MNO");
        sRecs.put(14, "pqrs7PQRS");
        sRecs.put(15, "tuv8TUV");
        sRecs.put(16, "wxyz9WXYZ");
        sRecs.put(7, "0+");
        sRecs.put(18, " ");
    }
}

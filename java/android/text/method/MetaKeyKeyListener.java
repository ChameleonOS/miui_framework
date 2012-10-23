// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.method;

import android.text.*;
import android.view.*;

public abstract class MetaKeyKeyListener {

    public MetaKeyKeyListener() {
    }

    private static void adjust(Spannable spannable, Object obj) {
        int i = spannable.getSpanFlags(obj);
        if(i != 0x1000011) goto _L2; else goto _L1
_L1:
        spannable.setSpan(obj, 0, 0, 0x3000011);
_L4:
        return;
_L2:
        if(i == 0x2000011)
            spannable.removeSpan(obj);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static long adjustMetaAfterKeypress(long l) {
        if((0x10000000000L & l) != 0L)
            l = 0x100000000L | (1L | l & 0xfffefefefffffefeL);
        else
        if((0x1000000000000L & l) != 0L)
            l &= 0xfffefefefffffefeL;
        if((0x20000000000L & l) != 0L)
            l = 0x200000000L | (2L | l & 0xfffdfdfdfffffdfdL);
        else
        if((0x2000000000000L & l) != 0L)
            l &= 0xfffdfdfdfffffdfdL;
        if((0x40000000000L & l) != 0L)
            l = 0x400000000L | (4L | l & 0xfffbfbfbfffffbfbL);
        else
        if((0x4000000000000L & l) != 0L)
            l &= 0xfffbfbfbfffffbfbL;
        return l;
    }

    public static void adjustMetaAfterKeypress(Spannable spannable) {
        adjust(spannable, CAP);
        adjust(spannable, ALT);
        adjust(spannable, SYM);
    }

    public static void clearMetaKeyState(Editable editable, int i) {
        if((i & 1) != 0)
            editable.removeSpan(CAP);
        if((i & 2) != 0)
            editable.removeSpan(ALT);
        if((i & 4) != 0)
            editable.removeSpan(SYM);
        if((i & 0x800) != 0)
            editable.removeSpan(SELECTING);
    }

    private static int getActive(CharSequence charsequence, Object obj, int i, int j) {
        if(charsequence instanceof Spanned) goto _L2; else goto _L1
_L1:
        j = 0;
_L4:
        return j;
_L2:
        int k = ((Spanned)charsequence).getSpanFlags(obj);
        if(k != 0x4000011)
            if(k != 0)
                j = i;
            else
                j = 0;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static final int getMetaState(long l) {
        int i = 0;
        if((256L & l) != 0L)
            i = 0 | 0x100;
        else
        if((1L & l) != 0L)
            i = false | true;
        if((512L & l) != 0L)
            i |= 0x200;
        else
        if((2L & l) != 0L)
            i |= 2;
        if((1024L & l) != 0L)
            i |= 0x400;
        else
        if((4L & l) != 0L)
            i |= 4;
        return i;
    }

    public static final int getMetaState(long l, int i) {
        byte byte0 = 2;
        i;
        JVM INSTR tableswitch 1 4: default 32
    //                   1 36
    //                   2 64
    //                   3 32
    //                   4 94;
           goto _L1 _L2 _L3 _L1 _L4
_L1:
        byte0 = 0;
_L6:
        return byte0;
_L2:
        if((256L & l) == 0L)
            if((1L & l) != 0L)
                byte0 = 1;
            else
                byte0 = 0;
        continue; /* Loop/switch isn't completed */
_L3:
        if((512L & l) == 0L)
            if((2L & l) != 0L)
                byte0 = 1;
            else
                byte0 = 0;
        continue; /* Loop/switch isn't completed */
_L4:
        if((1024L & l) == 0L)
            if((4L & l) != 0L)
                byte0 = 1;
            else
                byte0 = 0;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public static final int getMetaState(CharSequence charsequence) {
        return getActive(charsequence, CAP, 1, 256) | getActive(charsequence, ALT, 2, 512) | getActive(charsequence, SYM, 4, 1024) | getActive(charsequence, SELECTING, 2048, 2048);
    }

    public static final int getMetaState(CharSequence charsequence, int i) {
        i;
        JVM INSTR lookupswitch 4: default 44
    //                   1: 48
    //                   2: 61
    //                   4: 74
    //                   2048: 87;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        int j = 0;
_L7:
        return j;
_L2:
        j = getActive(charsequence, CAP, 1, 2);
        continue; /* Loop/switch isn't completed */
_L3:
        j = getActive(charsequence, ALT, 1, 2);
        continue; /* Loop/switch isn't completed */
_L4:
        j = getActive(charsequence, SYM, 1, 2);
        continue; /* Loop/switch isn't completed */
_L5:
        j = getActive(charsequence, SELECTING, 1, 2);
        if(true) goto _L7; else goto _L6
_L6:
    }

    public static long handleKeyDown(long l, int i, KeyEvent keyevent) {
        if(i != 59 && i != 60) goto _L2; else goto _L1
_L1:
        l = press(l, 1, 0x1010100000101L, 256L, 0x10000000000L, 0x1000000000000L, 0x100000000L);
_L4:
        return l;
_L2:
        if(i == 57 || i == 58 || i == 78)
            l = press(l, 2, 0x2020200000202L, 512L, 0x20000000000L, 0x2000000000000L, 0x200000000L);
        else
        if(i == 63)
            l = press(l, 4, 0x4040400000404L, 1024L, 0x40000000000L, 0x4000000000000L, 0x400000000L);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static long handleKeyUp(long l, int i, KeyEvent keyevent) {
        if(i != 59 && i != 60) goto _L2; else goto _L1
_L1:
        l = release(l, 1, 0x1010100000101L, 0x10000000000L, 0x1000000000000L, 0x100000000L, keyevent);
_L4:
        return l;
_L2:
        if(i == 57 || i == 58 || i == 78)
            l = release(l, 2, 0x2020200000202L, 0x20000000000L, 0x2000000000000L, 0x200000000L, keyevent);
        else
        if(i == 63)
            l = release(l, 4, 0x4040400000404L, 0x40000000000L, 0x4000000000000L, 0x400000000L, keyevent);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static boolean isMetaTracker(CharSequence charsequence, Object obj) {
        boolean flag;
        if(obj == CAP || obj == ALT || obj == SYM || obj == SELECTING)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isSelectingMetaTracker(CharSequence charsequence, Object obj) {
        boolean flag;
        if(obj == SELECTING)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static long press(long l, int i, long l1, long l2, long l3, long l4, long l5) {
        if((l & l3) == 0L) goto _L2; else goto _L1
_L1:
        return l;
_L2:
        if((l & l4) != 0L)
            l = l2 | (l & (-1L ^ l1) | (long)i);
        else
        if((l & l5) == 0L)
            if((l & l2) != 0L)
                l &= -1L ^ l1;
            else
                l |= l3 | (long)i;
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void press(Editable editable, Object obj) {
        int i = editable.getSpanFlags(obj);
        if(i != 0x1000011) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(i == 0x2000011)
            editable.setSpan(obj, 0, 0, 0x4000011);
        else
        if(i != 0x3000011)
            if(i == 0x4000011)
                editable.removeSpan(obj);
            else
                editable.setSpan(obj, 0, 0, 0x1000011);
        if(true) goto _L1; else goto _L3
_L3:
    }

    private static long release(long l, int i, long l1, long l2, long l3, long l4, KeyEvent keyevent) {
        keyevent.getKeyCharacterMap().getModifierBehavior();
        JVM INSTR tableswitch 1 1: default 28
    //                   1 38;
           goto _L1 _L2
_L1:
        l &= -1L ^ l1;
_L4:
        return l;
_L2:
        if((l & l4) != 0L)
            l &= -1L ^ l1;
        else
        if((l & l2) != 0L)
            l |= l3 | (long)i;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void release(Editable editable, Object obj, KeyEvent keyevent) {
        int i = editable.getSpanFlags(obj);
        keyevent.getKeyCharacterMap().getModifierBehavior();
        JVM INSTR tableswitch 1 1: default 36
    //                   1 44;
           goto _L1 _L2
_L1:
        editable.removeSpan(obj);
_L4:
        return;
_L2:
        if(i == 0x3000011)
            editable.removeSpan(obj);
        else
        if(i == 0x1000011)
            editable.setSpan(obj, 0, 0, 0x2000011);
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static void resetLock(Spannable spannable, Object obj) {
        if(spannable.getSpanFlags(obj) == 0x4000011)
            spannable.removeSpan(obj);
    }

    public static long resetLockedMeta(long l) {
        if((256L & l) != 0L)
            l &= 0xfffefefefffffefeL;
        if((512L & l) != 0L)
            l &= 0xfffdfdfdfffffdfdL;
        if((1024L & l) != 0L)
            l &= 0xfffbfbfbfffffbfbL;
        return l;
    }

    protected static void resetLockedMeta(Spannable spannable) {
        resetLock(spannable, CAP);
        resetLock(spannable, ALT);
        resetLock(spannable, SYM);
        resetLock(spannable, SELECTING);
    }

    public static void resetMetaState(Spannable spannable) {
        spannable.removeSpan(CAP);
        spannable.removeSpan(ALT);
        spannable.removeSpan(SYM);
        spannable.removeSpan(SELECTING);
    }

    public static void startSelecting(View view, Spannable spannable) {
        spannable.setSpan(SELECTING, 0, 0, 0x1000011);
    }

    public static void stopSelecting(View view, Spannable spannable) {
        spannable.removeSpan(SELECTING);
    }

    public long clearMetaKeyState(long l, int i) {
        if((i & 1) != 0 && (256L & l) != 0L)
            l &= 0xfffefefefffffefeL;
        if((i & 2) != 0 && (512L & l) != 0L)
            l &= 0xfffdfdfdfffffdfdL;
        if((i & 4) != 0 && (1024L & l) != 0L)
            l &= 0xfffbfbfbfffffbfbL;
        return l;
    }

    public void clearMetaKeyState(View view, Editable editable, int i) {
        clearMetaKeyState(editable, i);
    }

    public boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyevent) {
        boolean flag = true;
        if(i == 59 || i == 60)
            press(editable, CAP);
        else
        if(i == 57 || i == 58 || i == 78)
            press(editable, ALT);
        else
        if(i == 63)
            press(editable, SYM);
        else
            flag = false;
        return flag;
    }

    public boolean onKeyUp(View view, Editable editable, int i, KeyEvent keyevent) {
        boolean flag = true;
        if(i == 59 || i == 60)
            release(editable, CAP, keyevent);
        else
        if(i == 57 || i == 58 || i == 78)
            release(editable, ALT, keyevent);
        else
        if(i == 63)
            release(editable, SYM, keyevent);
        else
            flag = false;
        return flag;
    }

    private static final Object ALT = new android.text.NoCopySpan.Concrete();
    private static final Object CAP = new android.text.NoCopySpan.Concrete();
    private static final int LOCKED = 0x4000011;
    public static final int META_ALT_LOCKED = 512;
    private static final long META_ALT_MASK = 0x2020200000202L;
    public static final int META_ALT_ON = 2;
    private static final long META_ALT_PRESSED = 0x20000000000L;
    private static final long META_ALT_RELEASED = 0x2000000000000L;
    private static final long META_ALT_USED = 0x200000000L;
    public static final int META_CAP_LOCKED = 256;
    private static final long META_CAP_PRESSED = 0x10000000000L;
    private static final long META_CAP_RELEASED = 0x1000000000000L;
    private static final long META_CAP_USED = 0x100000000L;
    public static final int META_SELECTING = 2048;
    private static final long META_SHIFT_MASK = 0x1010100000101L;
    public static final int META_SHIFT_ON = 1;
    public static final int META_SYM_LOCKED = 1024;
    private static final long META_SYM_MASK = 0x4040400000404L;
    public static final int META_SYM_ON = 4;
    private static final long META_SYM_PRESSED = 0x40000000000L;
    private static final long META_SYM_RELEASED = 0x4000000000000L;
    private static final long META_SYM_USED = 0x400000000L;
    private static final int PRESSED = 0x1000011;
    private static final int RELEASED = 0x2000011;
    private static final Object SELECTING = new android.text.NoCopySpan.Concrete();
    private static final Object SYM = new android.text.NoCopySpan.Concrete();
    private static final int USED = 0x3000011;

}

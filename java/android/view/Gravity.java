// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.graphics.Rect;

public class Gravity {

    public Gravity() {
    }

    public static void apply(int i, int j, int k, Rect rect, int l, int i1, Rect rect1) {
        i & 6;
        JVM INSTR tableswitch 0 4: default 40
    //                   0 129
    //                   1 40
    //                   2 221
    //                   3 40
    //                   4 278;
           goto _L1 _L2 _L1 _L3 _L1 _L4
_L1:
        rect1.left = l + rect.left;
        rect1.right = l + rect.right;
_L9:
        i & 0x60;
        JVM INSTR lookupswitch 3: default 104
    //                   0: 335
    //                   32: 429
    //                   64: 488;
           goto _L5 _L6 _L7 _L8
_L5:
        rect1.top = i1 + rect.top;
        rect1.bottom = i1 + rect.bottom;
_L10:
        return;
_L2:
        rect1.left = l + (rect.left + (rect.right - rect.left - j) / 2);
        rect1.right = j + rect1.left;
        if((i & 8) == 8) {
            if(rect1.left < rect.left)
                rect1.left = rect.left;
            if(rect1.right > rect.right)
                rect1.right = rect.right;
        }
          goto _L9
_L3:
        rect1.left = l + rect.left;
        rect1.right = j + rect1.left;
        if((i & 8) == 8 && rect1.right > rect.right)
            rect1.right = rect.right;
          goto _L9
_L4:
        rect1.right = rect.right - l;
        rect1.left = rect1.right - j;
        if((i & 8) == 8 && rect1.left < rect.left)
            rect1.left = rect.left;
          goto _L9
_L6:
        rect1.top = i1 + (rect.top + (rect.bottom - rect.top - k) / 2);
        rect1.bottom = k + rect1.top;
        if((i & 0x80) == 128) {
            if(rect1.top < rect.top)
                rect1.top = rect.top;
            if(rect1.bottom > rect.bottom)
                rect1.bottom = rect.bottom;
        }
          goto _L10
_L7:
        rect1.top = i1 + rect.top;
        rect1.bottom = k + rect1.top;
        if((i & 0x80) == 128 && rect1.bottom > rect.bottom)
            rect1.bottom = rect.bottom;
          goto _L10
_L8:
        rect1.bottom = rect.bottom - i1;
        rect1.top = rect1.bottom - k;
        if((i & 0x80) == 128 && rect1.top < rect.top)
            rect1.top = rect.top;
          goto _L10
    }

    public static void apply(int i, int j, int k, Rect rect, int l, int i1, Rect rect1, int j1) {
        apply(getAbsoluteGravity(i, j1), j, k, rect, l, i1, rect1);
    }

    public static void apply(int i, int j, int k, Rect rect, Rect rect1) {
        apply(i, j, k, rect, 0, 0, rect1);
    }

    public static void apply(int i, int j, int k, Rect rect, Rect rect1, int l) {
        apply(getAbsoluteGravity(i, l), j, k, rect, 0, 0, rect1);
    }

    public static void applyDisplay(int i, Rect rect, Rect rect1) {
        if((0x10000000 & i) != 0) {
            if(rect1.top < rect.top)
                rect1.top = rect.top;
            if(rect1.bottom > rect.bottom)
                rect1.bottom = rect.bottom;
        } else {
            int j = 0;
            if(rect1.top < rect.top)
                j = rect.top - rect1.top;
            else
            if(rect1.bottom > rect.bottom)
                j = rect.bottom - rect1.bottom;
            if(j != 0)
                if(rect1.height() > rect.bottom - rect.top) {
                    rect1.top = rect.top;
                    rect1.bottom = rect.bottom;
                } else {
                    rect1.top = j + rect1.top;
                    rect1.bottom = j + rect1.bottom;
                }
        }
        if((0x1000000 & i) == 0) goto _L2; else goto _L1
_L1:
        if(rect1.left < rect.left)
            rect1.left = rect.left;
        if(rect1.right > rect.right)
            rect1.right = rect.right;
_L5:
        return;
_L2:
        int k = 0;
        if(rect1.left >= rect.left) goto _L4; else goto _L3
_L3:
        k = rect.left - rect1.left;
_L6:
        if(k != 0)
            if(rect1.width() > rect.right - rect.left) {
                rect1.left = rect.left;
                rect1.right = rect.right;
            } else {
                rect1.left = k + rect1.left;
                rect1.right = k + rect1.right;
            }
        if(true) goto _L5; else goto _L4
_L4:
        if(rect1.right > rect.right)
            k = rect.right - rect1.right;
          goto _L6
    }

    public static void applyDisplay(int i, Rect rect, Rect rect1, int j) {
        applyDisplay(getAbsoluteGravity(i, j), rect, rect1);
    }

    public static int getAbsoluteGravity(int i, int j) {
        int k = i;
        if((0x800000 & k) <= 0) goto _L2; else goto _L1
_L1:
        if((k & 0x800003) != 0x800003) goto _L4; else goto _L3
_L3:
        int i1 = k & 0xff7ffffc;
        if(j == 1)
            k = i1 | 5;
        else
            k = i1 | 3;
_L6:
        k &= 0xff7fffff;
_L2:
        return k;
_L4:
        if((k & 0x800005) == 0x800005) {
            int l = k & 0xff7ffffa;
            if(j == 1)
                k = l | 3;
            else
                k = l | 5;
        }
        if(true) goto _L6; else goto _L5
_L5:
    }

    public static boolean isHorizontal(int i) {
        boolean flag;
        if(i > 0 && (0x800007 & i) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isVertical(int i) {
        boolean flag;
        if(i > 0 && (i & 0x70) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static final int AXIS_CLIP = 8;
    public static final int AXIS_PULL_AFTER = 4;
    public static final int AXIS_PULL_BEFORE = 2;
    public static final int AXIS_SPECIFIED = 1;
    public static final int AXIS_X_SHIFT = 0;
    public static final int AXIS_Y_SHIFT = 4;
    public static final int BOTTOM = 80;
    public static final int CENTER = 17;
    public static final int CENTER_HORIZONTAL = 1;
    public static final int CENTER_VERTICAL = 16;
    public static final int CLIP_HORIZONTAL = 8;
    public static final int CLIP_VERTICAL = 128;
    public static final int DISPLAY_CLIP_HORIZONTAL = 0x1000000;
    public static final int DISPLAY_CLIP_VERTICAL = 0x10000000;
    public static final int END = 0x800005;
    public static final int FILL = 119;
    public static final int FILL_HORIZONTAL = 7;
    public static final int FILL_VERTICAL = 112;
    public static final int HORIZONTAL_GRAVITY_MASK = 7;
    public static final int LEFT = 3;
    public static final int NO_GRAVITY = 0;
    public static final int RELATIVE_HORIZONTAL_GRAVITY_MASK = 0x800007;
    public static final int RELATIVE_LAYOUT_DIRECTION = 0x800000;
    public static final int RIGHT = 5;
    public static final int START = 0x800003;
    public static final int TOP = 48;
    public static final int VERTICAL_GRAVITY_MASK = 112;
}

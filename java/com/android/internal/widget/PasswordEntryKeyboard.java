// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.Keyboard;
import java.util.List;

public class PasswordEntryKeyboard extends Keyboard {
    static class LatinKey extends android.inputmethodservice.Keyboard.Key {

        void enableShiftLock() {
            mShiftLockEnabled = true;
        }

        public boolean isInside(int i, int j) {
            boolean flag = false;
            if(mEnabled) goto _L2; else goto _L1
_L1:
            return flag;
_L2:
            int k;
            k = super.codes[0];
            if(k != -1 && k != -5)
                break; /* Loop/switch isn't completed */
            j -= super.height / 10;
            if(k == -1)
                i += super.width / 6;
            if(k == -5)
                i -= super.width / 6;
_L5:
            flag = super.isInside(i, j);
            if(true) goto _L1; else goto _L3
_L3:
            if(k != 32) goto _L5; else goto _L4
_L4:
            j += PasswordEntryKeyboard.sSpacebarVerticalCorrection;
              goto _L5
        }

        public void onReleased(boolean flag) {
            if(!mShiftLockEnabled) {
                super.onReleased(flag);
            } else {
                boolean flag1;
                if(!super.pressed)
                    flag1 = true;
                else
                    flag1 = false;
                super.pressed = flag1;
            }
        }

        void setEnabled(boolean flag) {
            mEnabled = flag;
        }

        private boolean mEnabled;
        private boolean mShiftLockEnabled;

        public LatinKey(Resources resources, android.inputmethodservice.Keyboard.Row row, int i, int j, XmlResourceParser xmlresourceparser) {
            super(resources, row, i, j, xmlresourceparser);
            mEnabled = true;
            if(super.popupCharacters != null && super.popupCharacters.length() == 0)
                super.popupResId = 0;
        }
    }


    public PasswordEntryKeyboard(Context context, int i) {
        this(context, i, 0);
    }

    public PasswordEntryKeyboard(Context context, int i, int j) {
        super(context, i, j);
        Drawable adrawable[] = new Drawable[2];
        adrawable[0] = null;
        adrawable[1] = null;
        mOldShiftIcons = adrawable;
        android.inputmethodservice.Keyboard.Key akey[] = new android.inputmethodservice.Keyboard.Key[2];
        akey[0] = null;
        akey[1] = null;
        mShiftKeys = akey;
        mShiftState = 0;
        init(context);
    }

    public PasswordEntryKeyboard(Context context, int i, int j, int k) {
        this(context, i, 0, j, k);
    }

    public PasswordEntryKeyboard(Context context, int i, int j, int k, int l) {
        super(context, i, j, k, l);
        Drawable adrawable[] = new Drawable[2];
        adrawable[0] = null;
        adrawable[1] = null;
        mOldShiftIcons = adrawable;
        android.inputmethodservice.Keyboard.Key akey[] = new android.inputmethodservice.Keyboard.Key[2];
        akey[0] = null;
        akey[1] = null;
        mShiftKeys = akey;
        mShiftState = 0;
        init(context);
    }

    public PasswordEntryKeyboard(Context context, int i, CharSequence charsequence, int j, int k) {
        super(context, i, charsequence, j, k);
        Drawable adrawable[] = new Drawable[2];
        adrawable[0] = null;
        adrawable[1] = null;
        mOldShiftIcons = adrawable;
        android.inputmethodservice.Keyboard.Key akey[] = new android.inputmethodservice.Keyboard.Key[2];
        akey[0] = null;
        akey[1] = null;
        mShiftKeys = akey;
        mShiftState = 0;
    }

    private void init(Context context) {
        Resources resources = context.getResources();
        mShiftIcon = resources.getDrawable(0x1080593);
        mShiftLockIcon = resources.getDrawable(0x1080594);
        sSpacebarVerticalCorrection = resources.getDimensionPixelOffset(0x1050019);
    }

    protected android.inputmethodservice.Keyboard.Key createKeyFromXml(Resources resources, android.inputmethodservice.Keyboard.Row row, int i, int j, XmlResourceParser xmlresourceparser) {
        LatinKey latinkey;
        latinkey = new LatinKey(resources, row, i, j, xmlresourceparser);
        int k = ((android.inputmethodservice.Keyboard.Key) (latinkey)).codes[0];
        if(k >= 0 && k != 10 && (k < 32 || k > 127)) {
            latinkey.label = " ";
            latinkey.setEnabled(false);
        }
        ((android.inputmethodservice.Keyboard.Key) (latinkey)).codes[0];
        JVM INSTR lookupswitch 3: default 104
    //                   -103: 116
    //                   10: 107
    //                   32: 125;
           goto _L1 _L2 _L3 _L4
_L1:
        return latinkey;
_L3:
        mEnterKey = latinkey;
        continue; /* Loop/switch isn't completed */
_L2:
        mF1Key = latinkey;
        continue; /* Loop/switch isn't completed */
_L4:
        mSpaceKey = latinkey;
        if(true) goto _L1; else goto _L5
_L5:
    }

    void enableShiftLock() {
        int i = 0;
        int ai[] = getShiftKeyIndices();
        int j = ai.length;
        for(int k = 0; k < j; k++) {
            int l = ai[k];
            if(l < 0 || i >= mShiftKeys.length)
                continue;
            mShiftKeys[i] = (android.inputmethodservice.Keyboard.Key)getKeys().get(l);
            if(mShiftKeys[i] instanceof LatinKey)
                ((LatinKey)mShiftKeys[i]).enableShiftLock();
            mOldShiftIcons[i] = mShiftKeys[i].icon;
            i++;
        }

    }

    public boolean isShifted() {
        boolean flag = false;
        if(mShiftKeys[0] != null) {
            if(mShiftState != 0)
                flag = true;
        } else {
            flag = super.isShifted();
        }
        return flag;
    }

    void setEnterKeyResources(Resources resources, int i, int j, int k) {
        if(mEnterKey != null) {
            mEnterKey.popupCharacters = null;
            mEnterKey.popupResId = 0;
            mEnterKey.text = null;
            mEnterKey.iconPreview = resources.getDrawable(i);
            mEnterKey.icon = resources.getDrawable(j);
            mEnterKey.label = resources.getText(k);
            if(mEnterKey.iconPreview != null)
                mEnterKey.iconPreview.setBounds(0, 0, mEnterKey.iconPreview.getIntrinsicWidth(), mEnterKey.iconPreview.getIntrinsicHeight());
        }
    }

    void setShiftLocked(boolean flag) {
        android.inputmethodservice.Keyboard.Key akey[] = mShiftKeys;
        int i = akey.length;
        for(int j = 0; j < i; j++) {
            android.inputmethodservice.Keyboard.Key key = akey[j];
            if(key != null) {
                key.on = flag;
                key.icon = mShiftLockIcon;
            }
        }

        int k;
        if(flag)
            k = 2;
        else
            k = 1;
        mShiftState = k;
    }

    public boolean setShifted(boolean flag) {
        boolean flag1;
        flag1 = false;
        if(!flag) {
            if(mShiftState != 0)
                flag1 = true;
            else
                flag1 = false;
            mShiftState = 0;
            break MISSING_BLOCK_LABEL_20;
        } else {
            if(mShiftState == 0) {
                if(mShiftState == 0)
                    flag1 = true;
                else
                    flag1 = false;
                mShiftState = 1;
            }
            continue;
        }
        do {
            int i = 0;
            do {
                if(i >= mShiftKeys.length)
                    break;
                if(mShiftKeys[i] != null)
                    if(!flag) {
                        mShiftKeys[i].on = false;
                        mShiftKeys[i].icon = mOldShiftIcons[i];
                    } else
                    if(mShiftState == 0) {
                        mShiftKeys[i].on = false;
                        mShiftKeys[i].icon = mShiftIcon;
                    }
                i++;
            } while(true);
            return flag1;
        } while(true);
    }

    public static final int KEYCODE_SPACE = 32;
    private static final int SHIFT_LOCKED = 2;
    private static final int SHIFT_OFF = 0;
    private static final int SHIFT_ON = 1;
    static int sSpacebarVerticalCorrection;
    private android.inputmethodservice.Keyboard.Key mEnterKey;
    private android.inputmethodservice.Keyboard.Key mF1Key;
    private Drawable mOldShiftIcons[];
    private Drawable mShiftIcon;
    private android.inputmethodservice.Keyboard.Key mShiftKeys[];
    private Drawable mShiftLockIcon;
    private int mShiftState;
    private android.inputmethodservice.Keyboard.Key mSpaceKey;
}

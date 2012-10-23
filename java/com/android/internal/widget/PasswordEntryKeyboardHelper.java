// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.inputmethodservice.KeyboardView;
import android.os.SystemClock;
import android.util.Log;
import android.view.*;

// Referenced classes of package com.android.internal.widget:
//            PasswordEntryKeyboard

public class PasswordEntryKeyboardHelper
    implements android.inputmethodservice.KeyboardView.OnKeyboardActionListener {

    public PasswordEntryKeyboardHelper(Context context, KeyboardView keyboardview, View view) {
        this(context, keyboardview, view, true);
    }

    public PasswordEntryKeyboardHelper(Context context, KeyboardView keyboardview, View view, boolean flag) {
        mKeyboardMode = 0;
        mKeyboardState = 0;
        mEnableHaptics = false;
        mContext = context;
        mTargetView = view;
        mKeyboardView = keyboardview;
        if(flag || mKeyboardView.getLayoutParams().width == -1)
            createKeyboards();
        else
            createKeyboardsWithSpecificSize(mKeyboardView.getLayoutParams().width, mKeyboardView.getLayoutParams().height);
        mKeyboardView.setOnKeyboardActionListener(this);
    }

    private void createKeyboards() {
        mNumericKeyboard = new PasswordEntryKeyboard(mContext, 0x10f0004);
        mQwertyKeyboard = new PasswordEntryKeyboard(mContext, 0x10f0006, 0x102036c);
        mQwertyKeyboard.enableShiftLock();
        mQwertyKeyboardShifted = new PasswordEntryKeyboard(mContext, 0x10f0007, 0x102036c);
        mQwertyKeyboardShifted.enableShiftLock();
        mQwertyKeyboardShifted.setShifted(true);
        mSymbolsKeyboard = new PasswordEntryKeyboard(mContext, 0x10f0008);
        mSymbolsKeyboard.enableShiftLock();
        mSymbolsKeyboardShifted = new PasswordEntryKeyboard(mContext, 0x10f0009);
        mSymbolsKeyboardShifted.enableShiftLock();
        mSymbolsKeyboardShifted.setShifted(true);
    }

    private void createKeyboardsWithSpecificSize(int i, int j) {
        mNumericKeyboard = new PasswordEntryKeyboard(mContext, 0x10f0004, i, j);
        mQwertyKeyboard = new PasswordEntryKeyboard(mContext, 0x10f0006, 0x102036c, i, j);
        mQwertyKeyboard.enableShiftLock();
        mQwertyKeyboardShifted = new PasswordEntryKeyboard(mContext, 0x10f0007, 0x102036c, i, j);
        mQwertyKeyboardShifted.enableShiftLock();
        mQwertyKeyboardShifted.setShifted(true);
        mSymbolsKeyboard = new PasswordEntryKeyboard(mContext, 0x10f0008, i, j);
        mSymbolsKeyboard.enableShiftLock();
        mSymbolsKeyboardShifted = new PasswordEntryKeyboard(mContext, 0x10f0009, i, j);
        mSymbolsKeyboardShifted.enableShiftLock();
        mSymbolsKeyboardShifted.setShifted(true);
    }

    private void handleCharacter(int i, int ai[]) {
        if(mKeyboardView.isShifted() && i != 32 && i != 10)
            i = Character.toUpperCase(i);
        sendKeyEventsToTarget(i);
    }

    private void handleClose() {
    }

    private void handleModeChange() {
        android.inputmethodservice.Keyboard keyboard;
        PasswordEntryKeyboard passwordentrykeyboard;
        keyboard = mKeyboardView.getKeyboard();
        passwordentrykeyboard = null;
        if(keyboard != mQwertyKeyboard && keyboard != mQwertyKeyboardShifted) goto _L2; else goto _L1
_L1:
        passwordentrykeyboard = mSymbolsKeyboard;
_L4:
        if(passwordentrykeyboard != null) {
            mKeyboardView.setKeyboard(passwordentrykeyboard);
            mKeyboardState = 0;
        }
        return;
_L2:
        if(keyboard == mSymbolsKeyboard || keyboard == mSymbolsKeyboardShifted)
            passwordentrykeyboard = mQwertyKeyboard;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void handleShift() {
        boolean flag = true;
        if(mKeyboardView != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        PasswordEntryKeyboard passwordentrykeyboard;
        int i;
        android.inputmethodservice.Keyboard keyboard = mKeyboardView.getKeyboard();
        passwordentrykeyboard = null;
        KeyboardView keyboardview;
        if(keyboard == mQwertyKeyboard || keyboard == mQwertyKeyboardShifted)
            i = ((flag) ? 1 : 0);
        else
            i = 0;
        if(mKeyboardState != 0) goto _L4; else goto _L3
_L3:
        int j;
        if(i != 0)
            j = ((flag) ? 1 : 0);
        else
            j = 2;
        mKeyboardState = j;
        if(i != 0)
            passwordentrykeyboard = mQwertyKeyboardShifted;
        else
            passwordentrykeyboard = mSymbolsKeyboardShifted;
_L5:
        if(passwordentrykeyboard != null) {
            if(passwordentrykeyboard != keyboard)
                mKeyboardView.setKeyboard(passwordentrykeyboard);
            boolean flag1;
            if(mKeyboardState == 2)
                flag1 = flag;
            else
                flag1 = false;
            passwordentrykeyboard.setShiftLocked(flag1);
            keyboardview = mKeyboardView;
            if(mKeyboardState == 0)
                flag = false;
            keyboardview.setShifted(flag);
        }
        if(true) goto _L1; else goto _L4
_L4:
        if(mKeyboardState == flag) {
            mKeyboardState = 2;
            if(i != 0)
                passwordentrykeyboard = mQwertyKeyboardShifted;
            else
                passwordentrykeyboard = mSymbolsKeyboardShifted;
        } else
        if(mKeyboardState == 2) {
            mKeyboardState = 0;
            if(i != 0)
                passwordentrykeyboard = mQwertyKeyboard;
            else
                passwordentrykeyboard = mSymbolsKeyboard;
        }
          goto _L5
    }

    private void performHapticFeedback() {
        if(mEnableHaptics)
            mKeyboardView.performHapticFeedback(1, 3);
    }

    private void sendKeyEventsToTarget(int i) {
        ViewRootImpl viewrootimpl = mTargetView.getViewRootImpl();
        KeyCharacterMap keycharactermap = KeyCharacterMap.load(-1);
        char ac[] = new char[1];
        ac[0] = (char)i;
        KeyEvent akeyevent[] = keycharactermap.getEvents(ac);
        if(akeyevent != null) {
            int j = akeyevent.length;
            for(int k = 0; k < j; k++) {
                KeyEvent keyevent = akeyevent[k];
                viewrootimpl.dispatchKey(KeyEvent.changeFlags(keyevent, 4 | (2 | keyevent.getFlags())));
            }

        }
    }

    public void handleBackspace() {
        sendDownUpKeyEvents(67);
        performHapticFeedback();
    }

    public boolean isAlpha() {
        boolean flag;
        if(mKeyboardMode == 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void onKey(int i, int ai[]) {
        if(i != -5) goto _L2; else goto _L1
_L1:
        handleBackspace();
_L4:
        return;
_L2:
        if(i == -1)
            handleShift();
        else
        if(i == -3)
            handleClose();
        else
        if(i == -2 && mKeyboardView != null) {
            handleModeChange();
        } else {
            handleCharacter(i, ai);
            if(mKeyboardState == 1) {
                mKeyboardState = 2;
                handleShift();
            }
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void onPress(int i) {
        performHapticFeedback();
    }

    public void onRelease(int i) {
    }

    public void onText(CharSequence charsequence) {
    }

    public void sendDownUpKeyEvents(int i) {
        long l = SystemClock.uptimeMillis();
        ViewRootImpl viewrootimpl = mTargetView.getViewRootImpl();
        viewrootimpl.dispatchKeyFromIme(new KeyEvent(l, l, 0, i, 0, 0, -1, 0, 6));
        viewrootimpl.dispatchKeyFromIme(new KeyEvent(l, l, 1, i, 0, 0, -1, 0, 6));
    }

    public void setEnableHaptics(boolean flag) {
        mEnableHaptics = flag;
    }

    public void setKeyboardMode(int i) {
        int j = 1;
        i;
        JVM INSTR tableswitch 0 1: default 24
    //                   0 30
    //                   1 84;
           goto _L1 _L2 _L3
_L1:
        mKeyboardMode = i;
        return;
_L2:
        mKeyboardView.setKeyboard(mQwertyKeyboard);
        mKeyboardState = 0;
        KeyboardView keyboardview;
        if(android.provider.Settings.System.getInt(mContext.getContentResolver(), "show_password", j) == 0)
            j = 0;
        keyboardview = mKeyboardView;
        if(j == 0);
        keyboardview.setPreviewEnabled(false);
        continue; /* Loop/switch isn't completed */
_L3:
        mKeyboardView.setKeyboard(mNumericKeyboard);
        mKeyboardState = 0;
        mKeyboardView.setPreviewEnabled(false);
        if(true) goto _L1; else goto _L4
_L4:
    }

    public void setVibratePattern(int i) {
        int ai[] = null;
        int ai1[] = mContext.getResources().getIntArray(i);
        ai = ai1;
_L1:
        android.content.res.Resources.NotFoundException notfoundexception;
        if(ai == null) {
            mVibratePattern = null;
        } else {
            mVibratePattern = new long[ai.length];
            int j = 0;
            while(j < ai.length)  {
                mVibratePattern[j] = ai[j];
                j++;
            }
        }
        return;
        notfoundexception;
        if(i != 0)
            Log.e("PasswordEntryKeyboardHelper", "Vibrate pattern missing", notfoundexception);
          goto _L1
    }

    public void swipeDown() {
    }

    public void swipeLeft() {
    }

    public void swipeRight() {
    }

    public void swipeUp() {
    }

    public static final int KEYBOARD_MODE_ALPHA = 0;
    public static final int KEYBOARD_MODE_NUMERIC = 1;
    private static final int KEYBOARD_STATE_CAPSLOCK = 2;
    private static final int KEYBOARD_STATE_NORMAL = 0;
    private static final int KEYBOARD_STATE_SHIFTED = 1;
    private static final String TAG = "PasswordEntryKeyboardHelper";
    private final Context mContext;
    private boolean mEnableHaptics;
    private int mKeyboardMode;
    private int mKeyboardState;
    private final KeyboardView mKeyboardView;
    private PasswordEntryKeyboard mNumericKeyboard;
    private PasswordEntryKeyboard mQwertyKeyboard;
    private PasswordEntryKeyboard mQwertyKeyboardShifted;
    private PasswordEntryKeyboard mSymbolsKeyboard;
    private PasswordEntryKeyboard mSymbolsKeyboardShifted;
    private final View mTargetView;
    private long mVibratePattern[];
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.view;

import android.os.*;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.*;

// Referenced classes of package com.android.internal.view:
//            IInputContext

public class InputConnectionWrapper
    implements InputConnection {
    static class InputContextCallback extends IInputContextCallback.Stub {

        private void dispose() {
            com/android/internal/view/InputConnectionWrapper$InputContextCallback;
            JVM INSTR monitorenter ;
            if(sInstance == null) {
                mTextAfterCursor = null;
                mTextBeforeCursor = null;
                mExtractedText = null;
                sInstance = this;
            }
            return;
        }

        private static InputContextCallback getInstance() {
            com/android/internal/view/InputConnectionWrapper$InputContextCallback;
            JVM INSTR monitorenter ;
            InputContextCallback inputcontextcallback;
            int i;
            if(sInstance != null) {
                inputcontextcallback = sInstance;
                sInstance = null;
                inputcontextcallback.mHaveValue = false;
            } else {
                inputcontextcallback = new InputContextCallback();
            }
            i = sSequenceNumber;
            sSequenceNumber = i + 1;
            inputcontextcallback.mSeq = i;
            return inputcontextcallback;
        }

        public void setCursorCapsMode(int i, int j) {
            this;
            JVM INSTR monitorenter ;
            if(j == mSeq) {
                mCursorCapsMode = i;
                mHaveValue = true;
                notifyAll();
            } else {
                Log.i("InputConnectionWrapper.ICC", (new StringBuilder()).append("Got out-of-sequence callback ").append(j).append(" (expected ").append(mSeq).append(") in setCursorCapsMode, ignoring.").toString());
            }
            return;
        }

        public void setExtractedText(ExtractedText extractedtext, int i) {
            this;
            JVM INSTR monitorenter ;
            if(i == mSeq) {
                mExtractedText = extractedtext;
                mHaveValue = true;
                notifyAll();
            } else {
                Log.i("InputConnectionWrapper.ICC", (new StringBuilder()).append("Got out-of-sequence callback ").append(i).append(" (expected ").append(mSeq).append(") in setExtractedText, ignoring.").toString());
            }
            return;
        }

        public void setSelectedText(CharSequence charsequence, int i) {
            this;
            JVM INSTR monitorenter ;
            if(i == mSeq) {
                mSelectedText = charsequence;
                mHaveValue = true;
                notifyAll();
            } else {
                Log.i("InputConnectionWrapper.ICC", (new StringBuilder()).append("Got out-of-sequence callback ").append(i).append(" (expected ").append(mSeq).append(") in setSelectedText, ignoring.").toString());
            }
            return;
        }

        public void setTextAfterCursor(CharSequence charsequence, int i) {
            this;
            JVM INSTR monitorenter ;
            if(i == mSeq) {
                mTextAfterCursor = charsequence;
                mHaveValue = true;
                notifyAll();
            } else {
                Log.i("InputConnectionWrapper.ICC", (new StringBuilder()).append("Got out-of-sequence callback ").append(i).append(" (expected ").append(mSeq).append(") in setTextAfterCursor, ignoring.").toString());
            }
            return;
        }

        public void setTextBeforeCursor(CharSequence charsequence, int i) {
            this;
            JVM INSTR monitorenter ;
            if(i == mSeq) {
                mTextBeforeCursor = charsequence;
                mHaveValue = true;
                notifyAll();
            } else {
                Log.i("InputConnectionWrapper.ICC", (new StringBuilder()).append("Got out-of-sequence callback ").append(i).append(" (expected ").append(mSeq).append(") in setTextBeforeCursor, ignoring.").toString());
            }
            return;
        }

        void waitForResultLocked() {
            long l = 2000L + SystemClock.uptimeMillis();
            do {
                long l1;
label0:
                {
                    if(!mHaveValue) {
                        l1 = l - SystemClock.uptimeMillis();
                        if(l1 > 0L)
                            break label0;
                        Log.w("InputConnectionWrapper.ICC", "Timed out waiting on IInputContextCallback");
                    }
                    return;
                }
                try {
                    wait(l1);
                }
                catch(InterruptedException interruptedexception) { }
            } while(true);
        }

        private static final String TAG = "InputConnectionWrapper.ICC";
        private static InputContextCallback sInstance = new InputContextCallback();
        private static int sSequenceNumber = 1;
        public int mCursorCapsMode;
        public ExtractedText mExtractedText;
        public boolean mHaveValue;
        public CharSequence mSelectedText;
        public int mSeq;
        public CharSequence mTextAfterCursor;
        public CharSequence mTextBeforeCursor;




        InputContextCallback() {
        }
    }


    public InputConnectionWrapper(IInputContext iinputcontext) {
        mIInputContext = iinputcontext;
    }

    public boolean beginBatchEdit() {
        mIInputContext.beginBatchEdit();
        boolean flag = true;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean clearMetaKeyStates(int i) {
        mIInputContext.clearMetaKeyStates(i);
        boolean flag = true;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean commitCompletion(CompletionInfo completioninfo) {
        mIInputContext.commitCompletion(completioninfo);
        boolean flag = true;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean commitCorrection(CorrectionInfo correctioninfo) {
        mIInputContext.commitCorrection(correctioninfo);
        boolean flag = true;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean commitText(CharSequence charsequence, int i) {
        mIInputContext.commitText(charsequence, i);
        boolean flag = true;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean deleteSurroundingText(int i, int j) {
        mIInputContext.deleteSurroundingText(i, j);
        boolean flag = true;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean endBatchEdit() {
        mIInputContext.endBatchEdit();
        boolean flag = true;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean finishComposingText() {
        mIInputContext.finishComposingText();
        boolean flag = true;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int getCursorCapsMode(int i) {
        int j = 0;
        InputContextCallback inputcontextcallback;
        inputcontextcallback = InputContextCallback.getInstance();
        mIInputContext.getCursorCapsMode(i, inputcontextcallback.mSeq, inputcontextcallback);
        inputcontextcallback;
        JVM INSTR monitorenter ;
        inputcontextcallback.waitForResultLocked();
        if(inputcontextcallback.mHaveValue)
            j = inputcontextcallback.mCursorCapsMode;
        inputcontextcallback;
        JVM INSTR monitorexit ;
        inputcontextcallback.dispose();
        int k = j;
_L2:
        return k;
        Exception exception;
        exception;
        inputcontextcallback;
        JVM INSTR monitorexit ;
        try {
            throw exception;
        }
        catch(RemoteException remoteexception) {
            k = 0;
        }
        if(true) goto _L2; else goto _L1
_L1:
    }

    public ExtractedText getExtractedText(ExtractedTextRequest extractedtextrequest, int i) {
        ExtractedText extractedtext = null;
        InputContextCallback inputcontextcallback;
        inputcontextcallback = InputContextCallback.getInstance();
        mIInputContext.getExtractedText(extractedtextrequest, i, inputcontextcallback.mSeq, inputcontextcallback);
        inputcontextcallback;
        JVM INSTR monitorenter ;
        inputcontextcallback.waitForResultLocked();
        if(inputcontextcallback.mHaveValue)
            extractedtext = inputcontextcallback.mExtractedText;
        inputcontextcallback;
        JVM INSTR monitorexit ;
        inputcontextcallback.dispose();
        ExtractedText extractedtext1 = extractedtext;
_L2:
        return extractedtext1;
        Exception exception;
        exception;
        inputcontextcallback;
        JVM INSTR monitorexit ;
        try {
            throw exception;
        }
        catch(RemoteException remoteexception) {
            extractedtext1 = null;
        }
        if(true) goto _L2; else goto _L1
_L1:
    }

    public CharSequence getSelectedText(int i) {
        CharSequence charsequence = null;
        InputContextCallback inputcontextcallback;
        inputcontextcallback = InputContextCallback.getInstance();
        mIInputContext.getSelectedText(i, inputcontextcallback.mSeq, inputcontextcallback);
        inputcontextcallback;
        JVM INSTR monitorenter ;
        inputcontextcallback.waitForResultLocked();
        if(inputcontextcallback.mHaveValue)
            charsequence = inputcontextcallback.mSelectedText;
        inputcontextcallback;
        JVM INSTR monitorexit ;
        inputcontextcallback.dispose();
        CharSequence charsequence1 = charsequence;
_L2:
        return charsequence1;
        Exception exception;
        exception;
        inputcontextcallback;
        JVM INSTR monitorexit ;
        try {
            throw exception;
        }
        catch(RemoteException remoteexception) {
            charsequence1 = null;
        }
        if(true) goto _L2; else goto _L1
_L1:
    }

    public CharSequence getTextAfterCursor(int i, int j) {
        CharSequence charsequence = null;
        InputContextCallback inputcontextcallback;
        inputcontextcallback = InputContextCallback.getInstance();
        mIInputContext.getTextAfterCursor(i, j, inputcontextcallback.mSeq, inputcontextcallback);
        inputcontextcallback;
        JVM INSTR monitorenter ;
        inputcontextcallback.waitForResultLocked();
        if(inputcontextcallback.mHaveValue)
            charsequence = inputcontextcallback.mTextAfterCursor;
        inputcontextcallback;
        JVM INSTR monitorexit ;
        inputcontextcallback.dispose();
        CharSequence charsequence1 = charsequence;
_L2:
        return charsequence1;
        Exception exception;
        exception;
        inputcontextcallback;
        JVM INSTR monitorexit ;
        try {
            throw exception;
        }
        catch(RemoteException remoteexception) {
            charsequence1 = null;
        }
        if(true) goto _L2; else goto _L1
_L1:
    }

    public CharSequence getTextBeforeCursor(int i, int j) {
        CharSequence charsequence = null;
        InputContextCallback inputcontextcallback;
        inputcontextcallback = InputContextCallback.getInstance();
        mIInputContext.getTextBeforeCursor(i, j, inputcontextcallback.mSeq, inputcontextcallback);
        inputcontextcallback;
        JVM INSTR monitorenter ;
        inputcontextcallback.waitForResultLocked();
        if(inputcontextcallback.mHaveValue)
            charsequence = inputcontextcallback.mTextBeforeCursor;
        inputcontextcallback;
        JVM INSTR monitorexit ;
        inputcontextcallback.dispose();
        CharSequence charsequence1 = charsequence;
_L2:
        return charsequence1;
        Exception exception;
        exception;
        inputcontextcallback;
        JVM INSTR monitorexit ;
        try {
            throw exception;
        }
        catch(RemoteException remoteexception) {
            charsequence1 = null;
        }
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean performContextMenuAction(int i) {
        mIInputContext.performContextMenuAction(i);
        boolean flag = true;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean performEditorAction(int i) {
        mIInputContext.performEditorAction(i);
        boolean flag = true;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean performPrivateCommand(String s, Bundle bundle) {
        mIInputContext.performPrivateCommand(s, bundle);
        boolean flag = true;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean reportFullscreenMode(boolean flag) {
        mIInputContext.reportFullscreenMode(flag);
        boolean flag1 = true;
_L2:
        return flag1;
        RemoteException remoteexception;
        remoteexception;
        flag1 = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean sendKeyEvent(KeyEvent keyevent) {
        mIInputContext.sendKeyEvent(keyevent);
        boolean flag = true;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean setComposingRegion(int i, int j) {
        mIInputContext.setComposingRegion(i, j);
        boolean flag = true;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean setComposingText(CharSequence charsequence, int i) {
        mIInputContext.setComposingText(charsequence, i);
        boolean flag = true;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean setSelection(int i, int j) {
        mIInputContext.setSelection(i, j);
        boolean flag = true;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private static final int MAX_WAIT_TIME_MILLIS = 2000;
    private final IInputContext mIInputContext;
}

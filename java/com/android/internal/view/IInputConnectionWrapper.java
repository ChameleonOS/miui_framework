// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.view;

import android.os.*;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.*;
import java.lang.ref.WeakReference;

// Referenced classes of package com.android.internal.view:
//            IInputContextCallback

public class IInputConnectionWrapper extends IInputContext.Stub {
    class MyHandler extends Handler {

        public void handleMessage(Message message) {
            executeMessage(message);
        }

        final IInputConnectionWrapper this$0;

        MyHandler(Looper looper) {
            this$0 = IInputConnectionWrapper.this;
            super(looper);
        }
    }

    static class SomeArgs {

        Object arg1;
        Object arg2;
        IInputContextCallback callback;
        int seq;

        SomeArgs() {
        }
    }


    public IInputConnectionWrapper(Looper looper, InputConnection inputconnection) {
        mInputConnection = new WeakReference(inputconnection);
        mMainLooper = looper;
        mH = new MyHandler(mMainLooper);
    }

    public void beginBatchEdit() {
        dispatchMessage(obtainMessage(90));
    }

    public void clearMetaKeyStates(int i) {
        dispatchMessage(obtainMessageII(130, i, 0));
    }

    public void commitCompletion(CompletionInfo completioninfo) {
        dispatchMessage(obtainMessageO(55, completioninfo));
    }

    public void commitCorrection(CorrectionInfo correctioninfo) {
        dispatchMessage(obtainMessageO(56, correctioninfo));
    }

    public void commitText(CharSequence charsequence, int i) {
        dispatchMessage(obtainMessageIO(50, i, charsequence));
    }

    public void deleteSurroundingText(int i, int j) {
        dispatchMessage(obtainMessageII(80, i, j));
    }

    void dispatchMessage(Message message) {
        if(Looper.myLooper() == mMainLooper) {
            executeMessage(message);
            message.recycle();
        } else {
            mH.sendMessage(message);
        }
    }

    public void endBatchEdit() {
        dispatchMessage(obtainMessage(95));
    }

    void executeMessage(Message message) {
        boolean flag = true;
        message.what;
        JVM INSTR lookupswitch 21: default 184
    //                   10: 213
    //                   20: 321
    //                   25: 429
    //                   30: 533
    //                   40: 637
    //                   50: 749
    //                   55: 963
    //                   56: 1017
    //                   57: 806
    //                   58: 861
    //                   59: 912
    //                   60: 1071
    //                   63: 1129
    //                   65: 1184
    //                   70: 1224
    //                   80: 1329
    //                   90: 1384
    //                   95: 1431
    //                   100: 1478
    //                   120: 1539
    //                   130: 1278;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22
_L1:
        Log.w("IInputConnectionWrapper", (new StringBuilder()).append("Unhandled message code: ").append(message.what).toString());
_L24:
        return;
_L2:
        SomeArgs someargs5 = (SomeArgs)message.obj;
        InputConnection inputconnection20 = (InputConnection)mInputConnection.get();
        RemoteException remoteexception4;
        if(inputconnection20 == null || !isActive()) {
            Log.w("IInputConnectionWrapper", "getTextAfterCursor on inactive InputConnection");
            someargs5.callback.setTextAfterCursor(null, someargs5.seq);
            continue; /* Loop/switch isn't completed */
        }
        try {
            someargs5.callback.setTextAfterCursor(inputconnection20.getTextAfterCursor(message.arg1, message.arg2), someargs5.seq);
        }
        // Misplaced declaration of an exception variable
        catch(RemoteException remoteexception4) {
            Log.w("IInputConnectionWrapper", "Got RemoteException calling setTextAfterCursor", remoteexception4);
        }
        continue; /* Loop/switch isn't completed */
_L3:
        SomeArgs someargs4 = (SomeArgs)message.obj;
        InputConnection inputconnection19 = (InputConnection)mInputConnection.get();
        RemoteException remoteexception3;
        if(inputconnection19 == null || !isActive()) {
            Log.w("IInputConnectionWrapper", "getTextBeforeCursor on inactive InputConnection");
            someargs4.callback.setTextBeforeCursor(null, someargs4.seq);
            continue; /* Loop/switch isn't completed */
        }
        try {
            someargs4.callback.setTextBeforeCursor(inputconnection19.getTextBeforeCursor(message.arg1, message.arg2), someargs4.seq);
        }
        // Misplaced declaration of an exception variable
        catch(RemoteException remoteexception3) {
            Log.w("IInputConnectionWrapper", "Got RemoteException calling setTextBeforeCursor", remoteexception3);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        SomeArgs someargs3 = (SomeArgs)message.obj;
        InputConnection inputconnection18 = (InputConnection)mInputConnection.get();
        RemoteException remoteexception2;
        if(inputconnection18 == null || !isActive()) {
            Log.w("IInputConnectionWrapper", "getSelectedText on inactive InputConnection");
            someargs3.callback.setSelectedText(null, someargs3.seq);
            continue; /* Loop/switch isn't completed */
        }
        try {
            someargs3.callback.setSelectedText(inputconnection18.getSelectedText(message.arg1), someargs3.seq);
        }
        // Misplaced declaration of an exception variable
        catch(RemoteException remoteexception2) {
            Log.w("IInputConnectionWrapper", "Got RemoteException calling setSelectedText", remoteexception2);
        }
        continue; /* Loop/switch isn't completed */
_L5:
        SomeArgs someargs2 = (SomeArgs)message.obj;
        InputConnection inputconnection17 = (InputConnection)mInputConnection.get();
        RemoteException remoteexception1;
        if(inputconnection17 == null || !isActive()) {
            Log.w("IInputConnectionWrapper", "getCursorCapsMode on inactive InputConnection");
            someargs2.callback.setCursorCapsMode(0, someargs2.seq);
            continue; /* Loop/switch isn't completed */
        }
        try {
            someargs2.callback.setCursorCapsMode(inputconnection17.getCursorCapsMode(message.arg1), someargs2.seq);
        }
        // Misplaced declaration of an exception variable
        catch(RemoteException remoteexception1) {
            Log.w("IInputConnectionWrapper", "Got RemoteException calling setCursorCapsMode", remoteexception1);
        }
        continue; /* Loop/switch isn't completed */
_L6:
        SomeArgs someargs1 = (SomeArgs)message.obj;
        InputConnection inputconnection16 = (InputConnection)mInputConnection.get();
        RemoteException remoteexception;
        if(inputconnection16 == null || !isActive()) {
            Log.w("IInputConnectionWrapper", "getExtractedText on inactive InputConnection");
            someargs1.callback.setExtractedText(null, someargs1.seq);
            continue; /* Loop/switch isn't completed */
        }
        try {
            someargs1.callback.setExtractedText(inputconnection16.getExtractedText((ExtractedTextRequest)someargs1.arg1, message.arg1), someargs1.seq);
        }
        // Misplaced declaration of an exception variable
        catch(RemoteException remoteexception) {
            Log.w("IInputConnectionWrapper", "Got RemoteException calling setExtractedText", remoteexception);
        }
        continue; /* Loop/switch isn't completed */
_L7:
        InputConnection inputconnection15 = (InputConnection)mInputConnection.get();
        if(inputconnection15 == null || !isActive())
            Log.w("IInputConnectionWrapper", "commitText on inactive InputConnection");
        else
            inputconnection15.commitText((CharSequence)message.obj, message.arg1);
        continue; /* Loop/switch isn't completed */
_L10:
        InputConnection inputconnection14 = (InputConnection)mInputConnection.get();
        if(inputconnection14 == null || !isActive())
            Log.w("IInputConnectionWrapper", "setSelection on inactive InputConnection");
        else
            inputconnection14.setSelection(message.arg1, message.arg2);
        continue; /* Loop/switch isn't completed */
_L11:
        InputConnection inputconnection13 = (InputConnection)mInputConnection.get();
        if(inputconnection13 == null || !isActive())
            Log.w("IInputConnectionWrapper", "performEditorAction on inactive InputConnection");
        else
            inputconnection13.performEditorAction(message.arg1);
        continue; /* Loop/switch isn't completed */
_L12:
        InputConnection inputconnection12 = (InputConnection)mInputConnection.get();
        if(inputconnection12 == null || !isActive())
            Log.w("IInputConnectionWrapper", "performContextMenuAction on inactive InputConnection");
        else
            inputconnection12.performContextMenuAction(message.arg1);
        continue; /* Loop/switch isn't completed */
_L8:
        InputConnection inputconnection11 = (InputConnection)mInputConnection.get();
        if(inputconnection11 == null || !isActive())
            Log.w("IInputConnectionWrapper", "commitCompletion on inactive InputConnection");
        else
            inputconnection11.commitCompletion((CompletionInfo)message.obj);
        continue; /* Loop/switch isn't completed */
_L9:
        InputConnection inputconnection10 = (InputConnection)mInputConnection.get();
        if(inputconnection10 == null || !isActive())
            Log.w("IInputConnectionWrapper", "commitCorrection on inactive InputConnection");
        else
            inputconnection10.commitCorrection((CorrectionInfo)message.obj);
        continue; /* Loop/switch isn't completed */
_L13:
        InputConnection inputconnection9 = (InputConnection)mInputConnection.get();
        if(inputconnection9 == null || !isActive())
            Log.w("IInputConnectionWrapper", "setComposingText on inactive InputConnection");
        else
            inputconnection9.setComposingText((CharSequence)message.obj, message.arg1);
        continue; /* Loop/switch isn't completed */
_L14:
        InputConnection inputconnection8 = (InputConnection)mInputConnection.get();
        if(inputconnection8 == null || !isActive())
            Log.w("IInputConnectionWrapper", "setComposingRegion on inactive InputConnection");
        else
            inputconnection8.setComposingRegion(message.arg1, message.arg2);
        continue; /* Loop/switch isn't completed */
_L15:
        InputConnection inputconnection7 = (InputConnection)mInputConnection.get();
        if(inputconnection7 == null)
            Log.w("IInputConnectionWrapper", "finishComposingText on inactive InputConnection");
        else
            inputconnection7.finishComposingText();
        continue; /* Loop/switch isn't completed */
_L16:
        InputConnection inputconnection6 = (InputConnection)mInputConnection.get();
        if(inputconnection6 == null || !isActive())
            Log.w("IInputConnectionWrapper", "sendKeyEvent on inactive InputConnection");
        else
            inputconnection6.sendKeyEvent((KeyEvent)message.obj);
        continue; /* Loop/switch isn't completed */
_L22:
        InputConnection inputconnection5 = (InputConnection)mInputConnection.get();
        if(inputconnection5 == null || !isActive())
            Log.w("IInputConnectionWrapper", "clearMetaKeyStates on inactive InputConnection");
        else
            inputconnection5.clearMetaKeyStates(message.arg1);
        continue; /* Loop/switch isn't completed */
_L17:
        InputConnection inputconnection4 = (InputConnection)mInputConnection.get();
        if(inputconnection4 == null || !isActive())
            Log.w("IInputConnectionWrapper", "deleteSurroundingText on inactive InputConnection");
        else
            inputconnection4.deleteSurroundingText(message.arg1, message.arg2);
        continue; /* Loop/switch isn't completed */
_L18:
        InputConnection inputconnection3 = (InputConnection)mInputConnection.get();
        if(inputconnection3 == null || !isActive())
            Log.w("IInputConnectionWrapper", "beginBatchEdit on inactive InputConnection");
        else
            inputconnection3.beginBatchEdit();
        continue; /* Loop/switch isn't completed */
_L19:
        InputConnection inputconnection2 = (InputConnection)mInputConnection.get();
        if(inputconnection2 == null || !isActive())
            Log.w("IInputConnectionWrapper", "endBatchEdit on inactive InputConnection");
        else
            inputconnection2.endBatchEdit();
        continue; /* Loop/switch isn't completed */
_L20:
        InputConnection inputconnection1 = (InputConnection)mInputConnection.get();
        if(inputconnection1 == null || !isActive()) {
            Log.w("IInputConnectionWrapper", "showStatusIcon on inactive InputConnection");
        } else {
            if(message.arg1 != flag)
                flag = false;
            inputconnection1.reportFullscreenMode(flag);
        }
        continue; /* Loop/switch isn't completed */
_L21:
        InputConnection inputconnection = (InputConnection)mInputConnection.get();
        if(inputconnection == null || !isActive()) {
            Log.w("IInputConnectionWrapper", "performPrivateCommand on inactive InputConnection");
        } else {
            SomeArgs someargs = (SomeArgs)message.obj;
            inputconnection.performPrivateCommand((String)someargs.arg1, (Bundle)someargs.arg2);
        }
        if(true) goto _L24; else goto _L23
_L23:
    }

    public void finishComposingText() {
        dispatchMessage(obtainMessage(65));
    }

    public void getCursorCapsMode(int i, int j, IInputContextCallback iinputcontextcallback) {
        dispatchMessage(obtainMessageISC(30, i, j, iinputcontextcallback));
    }

    public void getExtractedText(ExtractedTextRequest extractedtextrequest, int i, int j, IInputContextCallback iinputcontextcallback) {
        dispatchMessage(obtainMessageIOSC(40, i, extractedtextrequest, j, iinputcontextcallback));
    }

    public void getSelectedText(int i, int j, IInputContextCallback iinputcontextcallback) {
        dispatchMessage(obtainMessageISC(25, i, j, iinputcontextcallback));
    }

    public void getTextAfterCursor(int i, int j, int k, IInputContextCallback iinputcontextcallback) {
        dispatchMessage(obtainMessageIISC(10, i, j, k, iinputcontextcallback));
    }

    public void getTextBeforeCursor(int i, int j, int k, IInputContextCallback iinputcontextcallback) {
        dispatchMessage(obtainMessageIISC(20, i, j, k, iinputcontextcallback));
    }

    public boolean isActive() {
        return true;
    }

    Message obtainMessage(int i) {
        return mH.obtainMessage(i);
    }

    Message obtainMessageII(int i, int j, int k) {
        return mH.obtainMessage(i, j, k);
    }

    Message obtainMessageIISC(int i, int j, int k, int l, IInputContextCallback iinputcontextcallback) {
        SomeArgs someargs = new SomeArgs();
        someargs.callback = iinputcontextcallback;
        someargs.seq = l;
        return mH.obtainMessage(i, j, k, someargs);
    }

    Message obtainMessageIO(int i, int j, Object obj) {
        return mH.obtainMessage(i, j, 0, obj);
    }

    Message obtainMessageIOSC(int i, int j, Object obj, int k, IInputContextCallback iinputcontextcallback) {
        SomeArgs someargs = new SomeArgs();
        someargs.arg1 = obj;
        someargs.callback = iinputcontextcallback;
        someargs.seq = k;
        return mH.obtainMessage(i, j, 0, someargs);
    }

    Message obtainMessageISC(int i, int j, int k, IInputContextCallback iinputcontextcallback) {
        SomeArgs someargs = new SomeArgs();
        someargs.callback = iinputcontextcallback;
        someargs.seq = k;
        return mH.obtainMessage(i, j, 0, someargs);
    }

    Message obtainMessageO(int i, Object obj) {
        return mH.obtainMessage(i, 0, 0, obj);
    }

    Message obtainMessageOO(int i, Object obj, Object obj1) {
        SomeArgs someargs = new SomeArgs();
        someargs.arg1 = obj;
        someargs.arg2 = obj1;
        return mH.obtainMessage(i, 0, 0, someargs);
    }

    public void performContextMenuAction(int i) {
        dispatchMessage(obtainMessageII(59, i, 0));
    }

    public void performEditorAction(int i) {
        dispatchMessage(obtainMessageII(58, i, 0));
    }

    public void performPrivateCommand(String s, Bundle bundle) {
        dispatchMessage(obtainMessageOO(120, s, bundle));
    }

    public void reportFullscreenMode(boolean flag) {
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        dispatchMessage(obtainMessageII(100, i, 0));
    }

    public void sendKeyEvent(KeyEvent keyevent) {
        dispatchMessage(obtainMessageO(70, keyevent));
    }

    public void setComposingRegion(int i, int j) {
        dispatchMessage(obtainMessageII(63, i, j));
    }

    public void setComposingText(CharSequence charsequence, int i) {
        dispatchMessage(obtainMessageIO(60, i, charsequence));
    }

    public void setSelection(int i, int j) {
        dispatchMessage(obtainMessageII(57, i, j));
    }

    private static final int DO_BEGIN_BATCH_EDIT = 90;
    private static final int DO_CLEAR_META_KEY_STATES = 130;
    private static final int DO_COMMIT_COMPLETION = 55;
    private static final int DO_COMMIT_CORRECTION = 56;
    private static final int DO_COMMIT_TEXT = 50;
    private static final int DO_DELETE_SURROUNDING_TEXT = 80;
    private static final int DO_END_BATCH_EDIT = 95;
    private static final int DO_FINISH_COMPOSING_TEXT = 65;
    private static final int DO_GET_CURSOR_CAPS_MODE = 30;
    private static final int DO_GET_EXTRACTED_TEXT = 40;
    private static final int DO_GET_SELECTED_TEXT = 25;
    private static final int DO_GET_TEXT_AFTER_CURSOR = 10;
    private static final int DO_GET_TEXT_BEFORE_CURSOR = 20;
    private static final int DO_PERFORM_CONTEXT_MENU_ACTION = 59;
    private static final int DO_PERFORM_EDITOR_ACTION = 58;
    private static final int DO_PERFORM_PRIVATE_COMMAND = 120;
    private static final int DO_REPORT_FULLSCREEN_MODE = 100;
    private static final int DO_SEND_KEY_EVENT = 70;
    private static final int DO_SET_COMPOSING_REGION = 63;
    private static final int DO_SET_COMPOSING_TEXT = 60;
    private static final int DO_SET_SELECTION = 57;
    static final String TAG = "IInputConnectionWrapper";
    private Handler mH;
    private WeakReference mInputConnection;
    private Looper mMainLooper;
}

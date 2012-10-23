// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.inputmethodservice;

import android.content.Context;
import android.graphics.Rect;
import android.os.*;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.inputmethod.*;
import com.android.internal.os.HandlerCaller;
import com.android.internal.view.IInputMethodCallback;

class IInputMethodSessionWrapper extends com.android.internal.view.IInputMethodSession.Stub
    implements com.android.internal.os.HandlerCaller.Callback {
    static class InputMethodEventCallbackWrapper
        implements android.view.inputmethod.InputMethodSession.EventCallback {

        public void finishedEvent(int i, boolean flag) {
            mCb.finishedEvent(i, flag);
_L2:
            return;
            RemoteException remoteexception;
            remoteexception;
            if(true) goto _L2; else goto _L1
_L1:
        }

        final IInputMethodCallback mCb;

        InputMethodEventCallbackWrapper(IInputMethodCallback iinputmethodcallback) {
            mCb = iinputmethodcallback;
        }
    }


    public IInputMethodSessionWrapper(Context context, InputMethodSession inputmethodsession) {
        mCaller = new HandlerCaller(context, this);
        mInputMethodSession = inputmethodsession;
    }

    public void appPrivateCommand(String s, Bundle bundle) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageOO(100, s, bundle));
    }

    public void dispatchKeyEvent(int i, KeyEvent keyevent, IInputMethodCallback iinputmethodcallback) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageIOO(70, i, keyevent, iinputmethodcallback));
    }

    public void dispatchTrackballEvent(int i, MotionEvent motionevent, IInputMethodCallback iinputmethodcallback) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageIOO(80, i, motionevent, iinputmethodcallback));
    }

    public void displayCompletions(CompletionInfo acompletioninfo[]) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageO(65, acompletioninfo));
    }

    public void executeMessage(Message message) {
        boolean flag = true;
        if(mInputMethodSession != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        switch(message.what) {
        default:
            Log.w("InputMethodWrapper", (new StringBuilder()).append("Unhandled message code: ").append(message.what).toString());
            break;

        case 60: // '<'
            mInputMethodSession.finishInput();
            break;

        case 65: // 'A'
            mInputMethodSession.displayCompletions((CompletionInfo[])(CompletionInfo[])message.obj);
            break;

        case 67: // 'C'
            mInputMethodSession.updateExtractedText(message.arg1, (ExtractedText)message.obj);
            break;

        case 70: // 'F'
            com.android.internal.os.HandlerCaller.SomeArgs someargs3 = (com.android.internal.os.HandlerCaller.SomeArgs)message.obj;
            mInputMethodSession.dispatchKeyEvent(message.arg1, (KeyEvent)someargs3.arg1, new InputMethodEventCallbackWrapper((IInputMethodCallback)someargs3.arg2));
            mCaller.recycleArgs(someargs3);
            break;

        case 80: // 'P'
            com.android.internal.os.HandlerCaller.SomeArgs someargs2 = (com.android.internal.os.HandlerCaller.SomeArgs)message.obj;
            mInputMethodSession.dispatchTrackballEvent(message.arg1, (MotionEvent)someargs2.arg1, new InputMethodEventCallbackWrapper((IInputMethodCallback)someargs2.arg2));
            mCaller.recycleArgs(someargs2);
            break;

        case 90: // 'Z'
            com.android.internal.os.HandlerCaller.SomeArgs someargs1 = (com.android.internal.os.HandlerCaller.SomeArgs)message.obj;
            mInputMethodSession.updateSelection(someargs1.argi1, someargs1.argi2, someargs1.argi3, someargs1.argi4, someargs1.argi5, someargs1.argi6);
            mCaller.recycleArgs(someargs1);
            break;

        case 95: // '_'
            mInputMethodSession.updateCursor((Rect)message.obj);
            break;

        case 100: // 'd'
            com.android.internal.os.HandlerCaller.SomeArgs someargs = (com.android.internal.os.HandlerCaller.SomeArgs)message.obj;
            mInputMethodSession.appPrivateCommand((String)someargs.arg1, (Bundle)someargs.arg2);
            mCaller.recycleArgs(someargs);
            break;

        case 105: // 'i'
            mInputMethodSession.toggleSoftInput(message.arg1, message.arg2);
            break;

        case 110: // 'n'
            mInputMethodSession = null;
            break;

        case 115: // 's'
            InputMethodSession inputmethodsession = mInputMethodSession;
            if(message.arg1 != flag)
                flag = false;
            inputmethodsession.viewClicked(flag);
            break;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void finishInput() {
        mCaller.executeOrSendMessage(mCaller.obtainMessage(60));
    }

    public void finishSession() {
        mCaller.executeOrSendMessage(mCaller.obtainMessage(110));
    }

    public InputMethodSession getInternalInputMethodSession() {
        return mInputMethodSession;
    }

    public void toggleSoftInput(int i, int j) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageII(105, i, j));
    }

    public void updateCursor(Rect rect) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageO(95, rect));
    }

    public void updateExtractedText(int i, ExtractedText extractedtext) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageIO(67, i, extractedtext));
    }

    public void updateSelection(int i, int j, int k, int l, int i1, int j1) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageIIIIII(90, i, j, k, l, i1, j1));
    }

    public void viewClicked(boolean flag) {
        HandlerCaller handlercaller = mCaller;
        HandlerCaller handlercaller1 = mCaller;
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        handlercaller.executeOrSendMessage(handlercaller1.obtainMessageI(115, i));
    }

    private static final boolean DEBUG = false;
    private static final int DO_APP_PRIVATE_COMMAND = 100;
    private static final int DO_DISPATCH_KEY_EVENT = 70;
    private static final int DO_DISPATCH_TRACKBALL_EVENT = 80;
    private static final int DO_DISPLAY_COMPLETIONS = 65;
    private static final int DO_FINISH_INPUT = 60;
    private static final int DO_FINISH_SESSION = 110;
    private static final int DO_TOGGLE_SOFT_INPUT = 105;
    private static final int DO_UPDATE_CURSOR = 95;
    private static final int DO_UPDATE_EXTRACTED_TEXT = 67;
    private static final int DO_UPDATE_SELECTION = 90;
    private static final int DO_VIEW_CLICKED = 115;
    private static final String TAG = "InputMethodWrapper";
    HandlerCaller mCaller;
    InputMethodSession mInputMethodSession;
}

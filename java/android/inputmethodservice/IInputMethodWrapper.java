// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.inputmethodservice;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.*;
import android.util.Log;
import android.view.inputmethod.*;
import com.android.internal.os.HandlerCaller;
import com.android.internal.view.*;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

// Referenced classes of package android.inputmethodservice:
//            AbstractInputMethodService, IInputMethodSessionWrapper

class IInputMethodWrapper extends com.android.internal.view.IInputMethod.Stub
    implements com.android.internal.os.HandlerCaller.Callback {
    static class InputMethodSessionCallbackWrapper
        implements android.view.inputmethod.InputMethod.SessionCallback {

        public void sessionCreated(InputMethodSession inputmethodsession) {
            if(inputmethodsession == null)
                break MISSING_BLOCK_LABEL_30;
            IInputMethodSessionWrapper iinputmethodsessionwrapper = new IInputMethodSessionWrapper(mContext, inputmethodsession);
            mCb.sessionCreated(iinputmethodsessionwrapper);
            break MISSING_BLOCK_LABEL_44;
            mCb.sessionCreated(null);
            break MISSING_BLOCK_LABEL_44;
            RemoteException remoteexception;
            remoteexception;
        }

        final IInputMethodCallback mCb;
        final Context mContext;

        InputMethodSessionCallbackWrapper(Context context, IInputMethodCallback iinputmethodcallback) {
            mContext = context;
            mCb = iinputmethodcallback;
        }
    }

    static class Notifier {

        boolean notified;

        Notifier() {
        }
    }


    public IInputMethodWrapper(AbstractInputMethodService abstractinputmethodservice, InputMethod inputmethod) {
        mTarget = new WeakReference(abstractinputmethodservice);
        mCaller = new HandlerCaller(abstractinputmethodservice.getApplicationContext(), this);
        mInputMethod = new WeakReference(inputmethod);
        mTargetSdkVersion = abstractinputmethodservice.getApplicationInfo().targetSdkVersion;
    }

    public void attachToken(IBinder ibinder) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageO(10, ibinder));
    }

    public void bindInput(InputBinding inputbinding) {
        InputBinding inputbinding1 = new InputBinding(new InputConnectionWrapper(com.android.internal.view.IInputContext.Stub.asInterface(inputbinding.getConnectionToken())), inputbinding);
        mCaller.executeOrSendMessage(mCaller.obtainMessageO(20, inputbinding1));
    }

    public void changeInputMethodSubtype(InputMethodSubtype inputmethodsubtype) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageO(80, inputmethodsubtype));
    }

    public void createSession(IInputMethodCallback iinputmethodcallback) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageO(40, iinputmethodcallback));
    }

    protected void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        AbstractInputMethodService abstractinputmethodservice = (AbstractInputMethodService)mTarget.get();
        if(abstractinputmethodservice != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(abstractinputmethodservice.checkCallingOrSelfPermission("android.permission.DUMP") != 0) {
            printwriter.println((new StringBuilder()).append("Permission Denial: can't dump InputMethodManager from from pid=").append(Binder.getCallingPid()).append(", uid=").append(Binder.getCallingUid()).toString());
        } else {
            CountDownLatch countdownlatch = new CountDownLatch(1);
            mCaller.executeOrSendMessage(mCaller.obtainMessageOOOO(1, filedescriptor, printwriter, as, countdownlatch));
            try {
                if(!countdownlatch.await(5L, TimeUnit.SECONDS))
                    printwriter.println("Timeout waiting for dump");
            }
            catch(InterruptedException interruptedexception) {
                printwriter.println("Interrupted waiting for dump");
            }
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void executeMessage(Message message) {
        InputConnectionWrapper inputconnectionwrapper;
        boolean flag;
        InputMethod inputmethod;
        inputconnectionwrapper = null;
        flag = true;
        inputmethod = (InputMethod)mInputMethod.get();
        if(inputmethod != null || message.what == flag) goto _L2; else goto _L1
_L1:
        Log.w("InputMethodWrapper", (new StringBuilder()).append("Input method reference was null, ignoring message: ").append(message.what).toString());
_L17:
        return;
_L2:
        message.what;
        JVM INSTR lookupswitch 12: default 168
    //                   1: 199
    //                   10: 328
    //                   20: 345
    //                   30: 362
    //                   32: 372
    //                   34: 438
    //                   40: 504
    //                   45: 535
    //                   50: 569
    //                   60: 586
    //                   70: 607
    //                   80: 628;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L3:
        Log.w("InputMethodWrapper", (new StringBuilder()).append("Unhandled message code: ").append(message.what).toString());
        continue; /* Loop/switch isn't completed */
_L4:
        AbstractInputMethodService abstractinputmethodservice = (AbstractInputMethodService)mTarget.get();
        if(abstractinputmethodservice == null)
            continue; /* Loop/switch isn't completed */
        com.android.internal.os.HandlerCaller.SomeArgs someargs2 = (com.android.internal.os.HandlerCaller.SomeArgs)message.obj;
        Object obj;
        try {
            abstractinputmethodservice.dump((FileDescriptor)someargs2.arg1, (PrintWriter)someargs2.arg2, (String[])(String[])someargs2.arg3);
        }
        catch(RuntimeException runtimeexception) {
            ((PrintWriter)someargs2.arg2).println((new StringBuilder()).append("Exception: ").append(runtimeexception).toString());
        }
        obj = someargs2.arg4;
        obj;
        JVM INSTR monitorenter ;
        ((CountDownLatch)someargs2.arg4).countDown();
        continue; /* Loop/switch isn't completed */
_L5:
        inputmethod.attachToken((IBinder)message.obj);
        continue; /* Loop/switch isn't completed */
_L6:
        inputmethod.bindInput((InputBinding)message.obj);
        continue; /* Loop/switch isn't completed */
_L7:
        inputmethod.unbindInput();
        continue; /* Loop/switch isn't completed */
_L8:
        com.android.internal.os.HandlerCaller.SomeArgs someargs1 = (com.android.internal.os.HandlerCaller.SomeArgs)message.obj;
        IInputContext iinputcontext1 = (IInputContext)someargs1.arg1;
        if(iinputcontext1 != null)
            inputconnectionwrapper = new InputConnectionWrapper(iinputcontext1);
        EditorInfo editorinfo1 = (EditorInfo)someargs1.arg2;
        editorinfo1.makeCompatible(mTargetSdkVersion);
        inputmethod.startInput(inputconnectionwrapper, editorinfo1);
        continue; /* Loop/switch isn't completed */
_L9:
        com.android.internal.os.HandlerCaller.SomeArgs someargs = (com.android.internal.os.HandlerCaller.SomeArgs)message.obj;
        IInputContext iinputcontext = (IInputContext)someargs.arg1;
        if(iinputcontext != null)
            inputconnectionwrapper = new InputConnectionWrapper(iinputcontext);
        EditorInfo editorinfo = (EditorInfo)someargs.arg2;
        editorinfo.makeCompatible(mTargetSdkVersion);
        inputmethod.restartInput(inputconnectionwrapper, editorinfo);
        continue; /* Loop/switch isn't completed */
_L10:
        inputmethod.createSession(new InputMethodSessionCallbackWrapper(mCaller.mContext, (IInputMethodCallback)message.obj));
        continue; /* Loop/switch isn't completed */
_L11:
        InputMethodSession inputmethodsession = (InputMethodSession)message.obj;
        if(message.arg1 == 0)
            flag = false;
        inputmethod.setSessionEnabled(inputmethodsession, flag);
        continue; /* Loop/switch isn't completed */
_L12:
        inputmethod.revokeSession((InputMethodSession)message.obj);
        continue; /* Loop/switch isn't completed */
_L13:
        inputmethod.showSoftInput(message.arg1, (ResultReceiver)message.obj);
        continue; /* Loop/switch isn't completed */
_L14:
        inputmethod.hideSoftInput(message.arg1, (ResultReceiver)message.obj);
        continue; /* Loop/switch isn't completed */
_L15:
        inputmethod.changeInputMethodSubtype((InputMethodSubtype)message.obj);
        if(true) goto _L17; else goto _L16
_L16:
    }

    public InputMethod getInternalInputMethod() {
        return (InputMethod)mInputMethod.get();
    }

    public void hideSoftInput(int i, ResultReceiver resultreceiver) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageIO(70, i, resultreceiver));
    }

    public void restartInput(IInputContext iinputcontext, EditorInfo editorinfo) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageOO(34, iinputcontext, editorinfo));
    }

    public void revokeSession(IInputMethodSession iinputmethodsession) {
        InputMethodSession inputmethodsession = ((IInputMethodSessionWrapper)iinputmethodsession).getInternalInputMethodSession();
        mCaller.executeOrSendMessage(mCaller.obtainMessageO(50, inputmethodsession));
_L1:
        return;
        ClassCastException classcastexception;
        classcastexception;
        Log.w("InputMethodWrapper", (new StringBuilder()).append("Incoming session not of correct type: ").append(iinputmethodsession).toString(), classcastexception);
          goto _L1
    }

    public void setSessionEnabled(IInputMethodSession iinputmethodsession, boolean flag) {
        InputMethodSession inputmethodsession;
        HandlerCaller handlercaller;
        HandlerCaller handlercaller1;
        inputmethodsession = ((IInputMethodSessionWrapper)iinputmethodsession).getInternalInputMethodSession();
        handlercaller = mCaller;
        handlercaller1 = mCaller;
        if(!flag) goto _L2; else goto _L1
_L1:
        int i = 1;
_L3:
        handlercaller.executeOrSendMessage(handlercaller1.obtainMessageIO(45, i, inputmethodsession));
_L4:
        return;
_L2:
        i = 0;
          goto _L3
        ClassCastException classcastexception;
        classcastexception;
        Log.w("InputMethodWrapper", (new StringBuilder()).append("Incoming session not of correct type: ").append(iinputmethodsession).toString(), classcastexception);
          goto _L4
    }

    public void showSoftInput(int i, ResultReceiver resultreceiver) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageIO(60, i, resultreceiver));
    }

    public void startInput(IInputContext iinputcontext, EditorInfo editorinfo) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageOO(32, iinputcontext, editorinfo));
    }

    public void unbindInput() {
        mCaller.executeOrSendMessage(mCaller.obtainMessage(30));
    }

    private static final boolean DEBUG = false;
    private static final int DO_ATTACH_TOKEN = 10;
    private static final int DO_CHANGE_INPUTMETHOD_SUBTYPE = 80;
    private static final int DO_CREATE_SESSION = 40;
    private static final int DO_DUMP = 1;
    private static final int DO_HIDE_SOFT_INPUT = 70;
    private static final int DO_RESTART_INPUT = 34;
    private static final int DO_REVOKE_SESSION = 50;
    private static final int DO_SET_INPUT_CONTEXT = 20;
    private static final int DO_SET_SESSION_ENABLED = 45;
    private static final int DO_SHOW_SOFT_INPUT = 60;
    private static final int DO_START_INPUT = 32;
    private static final int DO_UNSET_INPUT_CONTEXT = 30;
    private static final String TAG = "InputMethodWrapper";
    final HandlerCaller mCaller;
    final WeakReference mInputMethod;
    final WeakReference mTarget;
    final int mTargetSdkVersion;
}

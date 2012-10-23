// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.inputmethod;

import android.content.Context;
import android.graphics.Rect;
import android.os.*;
import android.text.style.SuggestionSpan;
import android.util.*;
import android.view.*;
import com.android.internal.view.*;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

// Referenced classes of package android.view.inputmethod:
//            BaseInputConnection, InputConnection, EditorInfo, InputMethodInfo, 
//            InputMethodSubtype, CompletionInfo, ExtractedText

public final class InputMethodManager {
    private static class ControlledInputConnectionWrapper extends IInputConnectionWrapper {

        void deactivate() {
            mActive = false;
        }

        public boolean isActive() {
            boolean flag;
            if(mParentInputMethodManager.mActive && mActive)
                flag = true;
            else
                flag = false;
            return flag;
        }

        private boolean mActive;
        private final InputMethodManager mParentInputMethodManager;

        public ControlledInputConnectionWrapper(Looper looper, InputConnection inputconnection, InputMethodManager inputmethodmanager) {
            super(looper, inputconnection);
            mParentInputMethodManager = inputmethodmanager;
            mActive = true;
        }
    }

    class H extends Handler {

        public void handleMessage(Message message) {
            boolean flag = true;
            message.what;
            JVM INSTR tableswitch 1 4: default 36
        //                       1 37
        //                       2 151
        //                       3 309
        //                       4 424;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            return;
_L2:
            com.android.internal.os.HandlerCaller.SomeArgs someargs = (com.android.internal.os.HandlerCaller.SomeArgs)message.obj;
            Object obj;
            try {
                doDump((FileDescriptor)someargs.arg1, (PrintWriter)someargs.arg2, (String[])(String[])someargs.arg3);
            }
            catch(RuntimeException runtimeexception) {
                ((PrintWriter)someargs.arg2).println((new StringBuilder()).append("Exception: ").append(runtimeexception).toString());
            }
            obj = someargs.arg4;
            obj;
            JVM INSTR monitorenter ;
            ((CountDownLatch)someargs.arg4).countDown();
            continue; /* Loop/switch isn't completed */
_L3:
            InputBindResult inputbindresult = (InputBindResult)message.obj;
            H h2 = mH;
            h2;
            JVM INSTR monitorenter ;
            if(mBindSequence < 0 || mBindSequence != inputbindresult.sequence) {
                Log.w("InputMethodManager", (new StringBuilder()).append("Ignoring onBind: cur seq=").append(mBindSequence).append(", given seq=").append(inputbindresult.sequence).toString());
                continue; /* Loop/switch isn't completed */
            }
              goto _L6
            Exception exception2;
            exception2;
            throw exception2;
_L6:
            mCurMethod = inputbindresult.method;
            mCurId = inputbindresult.id;
            mBindSequence = inputbindresult.sequence;
            h2;
            JVM INSTR monitorexit ;
            startInputInner(null, 0, 0, 0);
            continue; /* Loop/switch isn't completed */
_L4:
            int i = message.arg1;
            boolean flag1 = false;
            synchronized(mH) {
                if(mBindSequence == i) {
                    clearBindingLocked();
                    if(mServedView != null && mServedView.isFocused())
                        mServedConnecting = true;
                    if(mActive)
                        flag1 = true;
                }
            }
            if(flag1)
                startInputInner(null, 0, 0, 0);
            continue; /* Loop/switch isn't completed */
            exception1;
            h1;
            JVM INSTR monitorexit ;
            throw exception1;
_L5:
            H h;
            if(message.arg1 == 0)
                flag = false;
            h = mH;
            h;
            JVM INSTR monitorenter ;
            mActive = flag;
            mFullscreenMode = false;
            if(flag) goto _L8; else goto _L7
_L7:
            mHasBeenInactive = true;
            Exception exception;
            try {
                mIInputContext.finishComposingText();
            }
            catch(RemoteException remoteexception) { }
            if(mServedView != null && mServedView.hasWindowFocus())
                checkFocus(mHasBeenInactive);
_L8:
            h;
            JVM INSTR monitorexit ;
            if(true) goto _L1; else goto _L9
_L9:
            exception;
            throw exception;
        }

        final InputMethodManager this$0;

        H(Looper looper) {
            this$0 = InputMethodManager.this;
            super(looper);
        }
    }


    InputMethodManager(IInputMethodManager iinputmethodmanager, Looper looper) {
        mActive = false;
        mHasBeenInactive = true;
        mTmpCursorRect = new Rect();
        mCursorRect = new Rect();
        mBindSequence = -1;
        mService = iinputmethodmanager;
        mMainLooper = looper;
        mH = new H(looper);
        mIInputContext = new ControlledInputConnectionWrapper(looper, mDummyInputConnection, this);
        if(mInstance == null)
            mInstance = this;
    }

    private void checkFocus(boolean flag) {
        if(checkFocusNoStartInput(flag))
            startInputInner(null, 0, 0, 0);
    }

    private boolean checkFocusNoStartInput(boolean flag) {
        boolean flag1 = false;
        if(mServedView != mNextServedView || flag) goto _L2; else goto _L1
_L1:
        return flag1;
_L2:
        H h = mH;
        h;
        JVM INSTR monitorenter ;
        if(mServedView == mNextServedView && !flag)
            continue; /* Loop/switch isn't completed */
        break MISSING_BLOCK_LABEL_53;
        Exception exception;
        exception;
        throw exception;
        if(mNextServedView != null)
            break MISSING_BLOCK_LABEL_73;
        finishInputLocked();
        closeCurrentInput();
        h;
        JVM INSTR monitorexit ;
        continue; /* Loop/switch isn't completed */
        InputConnection inputconnection;
        inputconnection = mServedInputConnection;
        mServedView = mNextServedView;
        mCurrentTextBoxAttribute = null;
        mCompletions = null;
        mServedConnecting = true;
        h;
        JVM INSTR monitorexit ;
        if(inputconnection != null)
            inputconnection.finishComposingText();
        flag1 = true;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static InputMethodManager getInstance(Context context) {
        return getInstance(context.getMainLooper());
    }

    public static InputMethodManager getInstance(Looper looper) {
        InputMethodManager inputmethodmanager;
        synchronized(mInstanceSync) {
            if(mInstance != null) {
                inputmethodmanager = mInstance;
                break MISSING_BLOCK_LABEL_54;
            }
            mInstance = new InputMethodManager(com.android.internal.view.IInputMethodManager.Stub.asInterface(ServiceManager.getService("input_method")), looper);
        }
        inputmethodmanager = mInstance;
          goto _L1
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L1:
        return inputmethodmanager;
    }

    private void notifyInputConnectionFinished() {
        if(mServedView != null && mServedInputConnection != null) {
            ViewRootImpl viewrootimpl = mServedView.getViewRootImpl();
            if(viewrootimpl != null)
                viewrootimpl.dispatchFinishInputConnection(mServedInputConnection);
        }
    }

    public static InputMethodManager peekInstance() {
        return mInstance;
    }

    static void scheduleCheckFocusLocked(View view) {
        ViewRootImpl viewrootimpl = view.getViewRootImpl();
        if(viewrootimpl != null)
            viewrootimpl.dispatchCheckFocus();
    }

    public void checkFocus() {
        checkFocus(false);
    }

    void clearBindingLocked() {
        clearConnectionLocked();
        mBindSequence = -1;
        mCurId = null;
        mCurMethod = null;
    }

    void clearConnectionLocked() {
        mCurrentTextBoxAttribute = null;
        mServedInputConnection = null;
        if(mServedInputConnectionWrapper != null) {
            mServedInputConnectionWrapper.deactivate();
            mServedInputConnectionWrapper = null;
        }
    }

    void closeCurrentInput() {
        mService.hideSoftInput(mClient, 2, null);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void dispatchKeyEvent(Context context, int i, KeyEvent keyevent, IInputMethodCallback iinputmethodcallback) {
        H h = mH;
        h;
        JVM INSTR monitorenter ;
        IInputMethodSession iinputmethodsession = mCurMethod;
        if(iinputmethodsession != null)
            break MISSING_BLOCK_LABEL_35;
        Exception exception;
        RemoteException remoteexception;
        try {
            iinputmethodcallback.finishedEvent(i, false);
        }
        catch(RemoteException remoteexception3) { }
        h;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_167;
        if(keyevent.getAction() != 0 || keyevent.getKeyCode() != 63)
            break MISSING_BLOCK_LABEL_78;
        showInputMethodPicker();
        try {
            iinputmethodcallback.finishedEvent(i, true);
        }
        catch(RemoteException remoteexception2) { }
        h;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_167;
        exception;
        throw exception;
        mCurMethod.dispatchKeyEvent(i, keyevent, iinputmethodcallback);
_L1:
        h;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_167;
        remoteexception;
        Log.w("InputMethodManager", (new StringBuilder()).append("IME died: ").append(mCurId).append(" dropping: ").append(keyevent).toString(), remoteexception);
        try {
            iinputmethodcallback.finishedEvent(i, false);
        }
        catch(RemoteException remoteexception1) { }
          goto _L1
    }

    void dispatchTrackballEvent(Context context, int i, MotionEvent motionevent, IInputMethodCallback iinputmethodcallback) {
        H h = mH;
        h;
        JVM INSTR monitorenter ;
        if(mCurMethod == null) goto _L2; else goto _L1
_L1:
        EditorInfo editorinfo = mCurrentTextBoxAttribute;
        if(editorinfo != null) goto _L3; else goto _L2
_L2:
        Exception exception;
        RemoteException remoteexception1;
        try {
            iinputmethodcallback.finishedEvent(i, false);
        }
        catch(RemoteException remoteexception) { }
        h;
        JVM INSTR monitorexit ;
_L4:
        return;
_L3:
        mCurMethod.dispatchTrackballEvent(i, motionevent, iinputmethodcallback);
_L5:
        h;
        JVM INSTR monitorexit ;
          goto _L4
        exception;
        throw exception;
        remoteexception1;
        Log.w("InputMethodManager", (new StringBuilder()).append("IME died: ").append(mCurId).append(" dropping trackball: ").append(motionevent).toString(), remoteexception1);
        try {
            iinputmethodcallback.finishedEvent(i, false);
        }
        catch(RemoteException remoteexception2) { }
          goto _L5
    }

    public void displayCompletions(View view, CompletionInfo acompletioninfo[]) {
        checkFocus();
        H h = mH;
        h;
        JVM INSTR monitorenter ;
        IInputMethodSession iinputmethodsession;
        if(mServedView != view && (mServedView == null || !mServedView.checkInputConnectionProxy(view)))
            break MISSING_BLOCK_LABEL_88;
        mCompletions = acompletioninfo;
        iinputmethodsession = mCurMethod;
        Exception exception;
        if(iinputmethodsession != null)
            try {
                mCurMethod.displayCompletions(mCompletions);
            }
            catch(RemoteException remoteexception) { }
            finally {
                h;
            }
        h;
        JVM INSTR monitorexit ;
        if(true)
            break MISSING_BLOCK_LABEL_88;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void doDump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        PrintWriterPrinter printwriterprinter = new PrintWriterPrinter(printwriter);
        printwriterprinter.println((new StringBuilder()).append("Input method client state for ").append(this).append(":").toString());
        printwriterprinter.println((new StringBuilder()).append("  mService=").append(mService).toString());
        printwriterprinter.println((new StringBuilder()).append("  mMainLooper=").append(mMainLooper).toString());
        printwriterprinter.println((new StringBuilder()).append("  mIInputContext=").append(mIInputContext).toString());
        printwriterprinter.println((new StringBuilder()).append("  mActive=").append(mActive).append(" mHasBeenInactive=").append(mHasBeenInactive).append(" mBindSequence=").append(mBindSequence).append(" mCurId=").append(mCurId).toString());
        printwriterprinter.println((new StringBuilder()).append("  mCurMethod=").append(mCurMethod).toString());
        printwriterprinter.println((new StringBuilder()).append("  mCurRootView=").append(mCurRootView).toString());
        printwriterprinter.println((new StringBuilder()).append("  mServedView=").append(mServedView).toString());
        printwriterprinter.println((new StringBuilder()).append("  mNextServedView=").append(mNextServedView).toString());
        printwriterprinter.println((new StringBuilder()).append("  mServedConnecting=").append(mServedConnecting).toString());
        if(mCurrentTextBoxAttribute != null) {
            printwriterprinter.println("  mCurrentTextBoxAttribute:");
            mCurrentTextBoxAttribute.dump(printwriterprinter, "    ");
        } else {
            printwriterprinter.println("  mCurrentTextBoxAttribute: null");
        }
        printwriterprinter.println((new StringBuilder()).append("  mServedInputConnection=").append(mServedInputConnection).toString());
        printwriterprinter.println((new StringBuilder()).append("  mCompletions=").append(mCompletions).toString());
        printwriterprinter.println((new StringBuilder()).append("  mCursorRect=").append(mCursorRect).toString());
        printwriterprinter.println((new StringBuilder()).append("  mCursorSelStart=").append(mCursorSelStart).append(" mCursorSelEnd=").append(mCursorSelEnd).append(" mCursorCandStart=").append(mCursorCandStart).append(" mCursorCandEnd=").append(mCursorCandEnd).toString());
    }

    void finishInputLocked() {
        mCurRootView = null;
        mNextServedView = null;
        if(mServedView != null) {
            if(mCurrentTextBoxAttribute != null)
                try {
                    mService.finishInput(mClient);
                }
                catch(RemoteException remoteexception) { }
            notifyInputConnectionFinished();
            mServedView = null;
            mCompletions = null;
            mServedConnecting = false;
            clearConnectionLocked();
        }
    }

    public void focusIn(View view) {
        H h = mH;
        h;
        JVM INSTR monitorenter ;
        focusInLocked(view);
        return;
    }

    void focusInLocked(View view) {
        if(mCurRootView == view.getRootView()) {
            mNextServedView = view;
            scheduleCheckFocusLocked(view);
        }
    }

    public void focusOut(View view) {
        H h = mH;
        h;
        JVM INSTR monitorenter ;
        if(mServedView == view);
        return;
    }

    public IInputMethodClient getClient() {
        return mClient;
    }

    public InputMethodSubtype getCurrentInputMethodSubtype() {
        H h = mH;
        h;
        JVM INSTR monitorenter ;
        InputMethodSubtype inputmethodsubtype;
label0:
        {
            InputMethodSubtype inputmethodsubtype1;
            try {
                inputmethodsubtype1 = mService.getCurrentInputMethodSubtype();
            }
            catch(RemoteException remoteexception) {
                Log.w("InputMethodManager", (new StringBuilder()).append("IME died: ").append(mCurId).toString(), remoteexception);
                inputmethodsubtype = null;
                break label0;
            }
            finally {
                throw exception;
            }
            inputmethodsubtype = inputmethodsubtype1;
            break label0;
        }
        return inputmethodsubtype;
    }

    public List getEnabledInputMethodList() {
        List list;
        try {
            list = mService.getEnabledInputMethodList();
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException(remoteexception);
        }
        return list;
    }

    public List getEnabledInputMethodSubtypeList(InputMethodInfo inputmethodinfo, boolean flag) {
        List list;
        try {
            list = mService.getEnabledInputMethodSubtypeList(inputmethodinfo, flag);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException(remoteexception);
        }
        return list;
    }

    public IInputContext getInputContext() {
        return mIInputContext;
    }

    public List getInputMethodList() {
        List list;
        try {
            list = mService.getInputMethodList();
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException(remoteexception);
        }
        return list;
    }

    public InputMethodSubtype getLastInputMethodSubtype() {
        H h = mH;
        h;
        JVM INSTR monitorenter ;
        InputMethodSubtype inputmethodsubtype;
label0:
        {
            InputMethodSubtype inputmethodsubtype1;
            try {
                inputmethodsubtype1 = mService.getLastInputMethodSubtype();
            }
            catch(RemoteException remoteexception) {
                Log.w("InputMethodManager", (new StringBuilder()).append("IME died: ").append(mCurId).toString(), remoteexception);
                inputmethodsubtype = null;
                break label0;
            }
            finally {
                throw exception;
            }
            inputmethodsubtype = inputmethodsubtype1;
            break label0;
        }
        return inputmethodsubtype;
    }

    public Map getShortcutInputMethodsAndSubtypes() {
        H h = mH;
        h;
        JVM INSTR monitorenter ;
        HashMap hashmap = new HashMap();
        List list;
        ArrayList arraylist;
        int i;
        list = mService.getShortcutInputMethodsAndSubtypes();
        arraylist = null;
        i = list.size();
        if(list == null || i <= 0) goto _L2; else goto _L1
_L1:
        int j = 0;
_L9:
        if(j >= i) goto _L2; else goto _L3
_L3:
        Object obj = list.get(j);
        if(!(obj instanceof InputMethodInfo)) goto _L5; else goto _L4
_L4:
        if(!hashmap.containsKey(obj)) goto _L7; else goto _L6
_L6:
        Log.e("InputMethodManager", "IMI list already contains the same InputMethod.");
_L2:
        return hashmap;
_L7:
        arraylist = new ArrayList();
        hashmap.put((InputMethodInfo)obj, arraylist);
        break MISSING_BLOCK_LABEL_191;
_L5:
        if(arraylist != null && (obj instanceof InputMethodSubtype))
            arraylist.add((InputMethodSubtype)obj);
        break MISSING_BLOCK_LABEL_191;
        RemoteException remoteexception;
        remoteexception;
        Log.w("InputMethodManager", (new StringBuilder()).append("IME died: ").append(mCurId).toString(), remoteexception);
        if(true) goto _L2; else goto _L8
_L8:
        Exception exception;
        exception;
        throw exception;
        j++;
          goto _L9
    }

    public void hideSoftInputFromInputMethod(IBinder ibinder, int i) {
        try {
            mService.hideMySoftInput(ibinder, i);
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException(remoteexception);
        }
    }

    public boolean hideSoftInputFromWindow(IBinder ibinder, int i) {
        return hideSoftInputFromWindow(ibinder, i, null);
    }

    public boolean hideSoftInputFromWindow(IBinder ibinder, int i, ResultReceiver resultreceiver) {
        boolean flag;
        flag = false;
        checkFocus();
        H h = mH;
        h;
        JVM INSTR monitorenter ;
        if(mServedView != null && mServedView.getWindowToken() == ibinder) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        boolean flag1 = mService.hideSoftInput(mClient, i, resultreceiver);
        flag = flag1;
        h;
        JVM INSTR monitorexit ;
          goto _L1
        Exception exception;
        exception;
        throw exception;
        RemoteException remoteexception;
        remoteexception;
        h;
        JVM INSTR monitorexit ;
          goto _L1
    }

    public void hideStatusIcon(IBinder ibinder) {
        try {
            mService.updateStatusIcon(ibinder, null, 0);
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException(remoteexception);
        }
    }

    public boolean isAcceptingText() {
        checkFocus();
        boolean flag;
        if(mServedInputConnection != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isActive() {
        checkFocus();
        H h = mH;
        h;
        JVM INSTR monitorenter ;
        boolean flag;
        if(mServedView != null && mCurrentTextBoxAttribute != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isActive(View view) {
        checkFocus();
        H h = mH;
        h;
        JVM INSTR monitorenter ;
        boolean flag;
        if((mServedView == view || mServedView != null && mServedView.checkInputConnectionProxy(view)) && mCurrentTextBoxAttribute != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isFullscreenMode() {
        return mFullscreenMode;
    }

    public boolean isWatchingCursor(View view) {
        return false;
    }

    public void notifySuggestionPicked(SuggestionSpan suggestionspan, String s, int i) {
        try {
            mService.notifySuggestionPicked(suggestionspan, s, i);
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException(remoteexception);
        }
    }

    public void onWindowFocus(View view, View view1, int i, boolean flag, int j) {
        boolean flag1 = false;
        H h = mH;
        h;
        JVM INSTR monitorenter ;
        if(mHasBeenInactive) {
            mHasBeenInactive = false;
            flag1 = true;
        }
          goto _L1
_L4:
        View view2;
        focusInLocked(view2);
        int k;
        k = 0;
        if(view1 != null) {
            k = false | true;
            if(view1.onCheckIsTextEditor())
                k |= 2;
        }
        if(flag)
            k |= 4;
        if(!checkFocusNoStartInput(flag1) || !startInputInner(view.getWindowToken(), k, i, j)) goto _L3; else goto _L2
_L2:
        return;
_L7:
        view2 = view;
          goto _L4
        Exception exception;
        exception;
        h;
        JVM INSTR monitorexit ;
        throw exception;
_L3:
        H h1 = mH;
        h1;
        JVM INSTR monitorenter ;
        Exception exception1;
        try {
            mService.windowGainedFocus(mClient, view.getWindowToken(), k, i, j, null, null);
        }
        catch(RemoteException remoteexception) { }
        finally {
            h1;
        }
        if(true) goto _L2; else goto _L5
_L5:
        JVM INSTR monitorexit ;
        throw exception1;
_L1:
        if(view1 == null) goto _L7; else goto _L6
_L6:
        view2 = view1;
          goto _L4
    }

    public void registerSuggestionSpansForNotification(SuggestionSpan asuggestionspan[]) {
        try {
            mService.registerSuggestionSpansForNotification(asuggestionspan);
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException(remoteexception);
        }
    }

    public void reportFinishInputConnection(InputConnection inputconnection) {
        if(mServedInputConnection != inputconnection) {
            inputconnection.finishComposingText();
            if(inputconnection instanceof BaseInputConnection)
                ((BaseInputConnection)inputconnection).reportFinish();
        }
    }

    public void restartInput(View view) {
        checkFocus();
        synchronized(mH) {
            if(mServedView != view && (mServedView == null || !mServedView.checkInputConnectionProxy(view)))
                break MISSING_BLOCK_LABEL_66;
            mServedConnecting = true;
        }
        startInputInner(null, 0, 0, 0);
          goto _L1
        exception;
        h;
        JVM INSTR monitorexit ;
        throw exception;
_L1:
    }

    public void sendAppPrivateCommand(View view, String s, Bundle bundle) {
        checkFocus();
        H h = mH;
        h;
        JVM INSTR monitorenter ;
        if((mServedView == view || mServedView != null && mServedView.checkInputConnectionProxy(view)) && mCurrentTextBoxAttribute != null && mCurMethod != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        mCurMethod.appPrivateCommand(s, bundle);
_L3:
        h;
        JVM INSTR monitorexit ;
          goto _L1
        Exception exception;
        exception;
        throw exception;
        RemoteException remoteexception;
        remoteexception;
        Log.w("InputMethodManager", (new StringBuilder()).append("IME died: ").append(mCurId).toString(), remoteexception);
          goto _L3
    }

    public void setAdditionalInputMethodSubtypes(String s, InputMethodSubtype ainputmethodsubtype[]) {
        H h = mH;
        h;
        JVM INSTR monitorenter ;
        Exception exception;
        try {
            mService.setAdditionalInputMethodSubtypes(s, ainputmethodsubtype);
        }
        catch(RemoteException remoteexception) {
            Log.w("InputMethodManager", (new StringBuilder()).append("IME died: ").append(mCurId).toString(), remoteexception);
        }
        finally {
            h;
        }
        return;
        throw exception;
    }

    public boolean setCurrentInputMethodSubtype(InputMethodSubtype inputmethodsubtype) {
        H h = mH;
        h;
        JVM INSTR monitorenter ;
        boolean flag;
label0:
        {
            boolean flag1;
            try {
                flag1 = mService.setCurrentInputMethodSubtype(inputmethodsubtype);
            }
            catch(RemoteException remoteexception) {
                Log.w("InputMethodManager", (new StringBuilder()).append("IME died: ").append(mCurId).toString(), remoteexception);
                flag = false;
                break label0;
            }
            finally {
                throw exception;
            }
            flag = flag1;
            break label0;
        }
        return flag;
    }

    public void setFullscreenMode(boolean flag) {
        mFullscreenMode = flag;
    }

    public void setImeWindowStatus(IBinder ibinder, int i, int j) {
        try {
            mService.setImeWindowStatus(ibinder, i, j);
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException(remoteexception);
        }
    }

    public void setInputMethod(IBinder ibinder, String s) {
        try {
            mService.setInputMethod(ibinder, s);
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException(remoteexception);
        }
    }

    public void setInputMethodAndSubtype(IBinder ibinder, String s, InputMethodSubtype inputmethodsubtype) {
        try {
            mService.setInputMethodAndSubtype(ibinder, s, inputmethodsubtype);
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException(remoteexception);
        }
    }

    public void showInputMethodAndSubtypeEnabler(String s) {
        H h = mH;
        h;
        JVM INSTR monitorenter ;
        Exception exception;
        try {
            mService.showInputMethodAndSubtypeEnablerFromClient(mClient, s);
        }
        catch(RemoteException remoteexception) {
            Log.w("InputMethodManager", (new StringBuilder()).append("IME died: ").append(mCurId).toString(), remoteexception);
        }
        finally {
            h;
        }
        return;
        throw exception;
    }

    public void showInputMethodPicker() {
        H h = mH;
        h;
        JVM INSTR monitorenter ;
        Exception exception;
        try {
            mService.showInputMethodPickerFromClient(mClient);
        }
        catch(RemoteException remoteexception) {
            Log.w("InputMethodManager", (new StringBuilder()).append("IME died: ").append(mCurId).toString(), remoteexception);
        }
        finally {
            h;
        }
        return;
        throw exception;
    }

    public boolean showSoftInput(View view, int i) {
        return showSoftInput(view, i, null);
    }

    public boolean showSoftInput(View view, int i, ResultReceiver resultreceiver) {
        boolean flag;
        flag = false;
        checkFocus();
        H h = mH;
        h;
        JVM INSTR monitorenter ;
        if(mServedView == view || mServedView != null && mServedView.checkInputConnectionProxy(view)) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        boolean flag1 = mService.showSoftInput(mClient, i, resultreceiver);
        flag = flag1;
        h;
        JVM INSTR monitorexit ;
          goto _L1
        Exception exception;
        exception;
        throw exception;
        RemoteException remoteexception;
        remoteexception;
        h;
        JVM INSTR monitorexit ;
          goto _L1
    }

    public void showSoftInputFromInputMethod(IBinder ibinder, int i) {
        try {
            mService.showMySoftInput(ibinder, i);
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException(remoteexception);
        }
    }

    public void showSoftInputUnchecked(int i, ResultReceiver resultreceiver) {
        mService.showSoftInput(mClient, i, resultreceiver);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void showStatusIcon(IBinder ibinder, String s, int i) {
        try {
            mService.updateStatusIcon(ibinder, s, i);
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException(remoteexception);
        }
    }

    public void startGettingWindowFocus(View view) {
        H h = mH;
        h;
        JVM INSTR monitorenter ;
        mCurRootView = view;
        return;
    }

    boolean startInputInner(IBinder ibinder, int i, int j, int k) {
        H h = mH;
        h;
        JVM INSTR monitorenter ;
        View view = mServedView;
        if(view != null) goto _L2; else goto _L1
_L1:
        boolean flag = false;
          goto _L3
_L2:
        Handler handler = view.getHandler();
        if(handler != null) goto _L5; else goto _L4
_L4:
        flag = false;
          goto _L3
        Exception exception;
        exception;
        h;
        JVM INSTR monitorexit ;
        throw exception;
_L5:
        if(handler.getLooper() == Looper.myLooper()) goto _L7; else goto _L6
_L6:
        handler.post(new Runnable() {

            public void run() {
                startInputInner(null, 0, 0, 0);
            }

            final InputMethodManager this$0;

             {
                this$0 = InputMethodManager.this;
                super();
            }
        });
        flag = false;
          goto _L3
_L7:
        EditorInfo editorinfo;
        InputConnection inputconnection;
        editorinfo = new EditorInfo();
        editorinfo.packageName = view.getContext().getPackageName();
        editorinfo.fieldId = view.getId();
        inputconnection = view.onCreateInputConnection(editorinfo);
        H h1 = mH;
        h1;
        JVM INSTR monitorenter ;
        if(mServedView == view && mServedConnecting) goto _L9; else goto _L8
_L8:
        flag = false;
          goto _L3
        Exception exception1;
        exception1;
        throw exception1;
_L9:
        if(mCurrentTextBoxAttribute == null)
            i = 0x100 | i;
        mCurrentTextBoxAttribute = editorinfo;
        mServedConnecting = false;
        notifyInputConnectionFinished();
        mServedInputConnection = inputconnection;
        if(inputconnection == null) goto _L11; else goto _L10
_L10:
        ControlledInputConnectionWrapper controlledinputconnectionwrapper;
        mCursorSelStart = editorinfo.initialSelStart;
        mCursorSelEnd = editorinfo.initialSelEnd;
        mCursorCandStart = -1;
        mCursorCandEnd = -1;
        mCursorRect.setEmpty();
        controlledinputconnectionwrapper = new ControlledInputConnectionWrapper(handler.getLooper(), inputconnection, this);
_L24:
        if(mServedInputConnectionWrapper != null)
            mServedInputConnectionWrapper.deactivate();
        mServedInputConnectionWrapper = controlledinputconnectionwrapper;
        if(ibinder == null) goto _L13; else goto _L12
_L12:
        InputBindResult inputbindresult = mService.windowGainedFocus(mClient, ibinder, i, j, k, editorinfo, controlledinputconnectionwrapper);
_L21:
        if(inputbindresult == null) goto _L15; else goto _L14
_L14:
        if(inputbindresult.id == null) goto _L17; else goto _L16
_L16:
        mBindSequence = inputbindresult.sequence;
        mCurMethod = inputbindresult.method;
_L15:
        if(mCurMethod == null) goto _L19; else goto _L18
_L18:
        CompletionInfo acompletioninfo[] = mCompletions;
        if(acompletioninfo == null) goto _L19; else goto _L20
_L20:
        RemoteException remoteexception;
        IInputMethodSession iinputmethodsession;
        try {
            mCurMethod.displayCompletions(mCompletions);
        }
        catch(RemoteException remoteexception1) { }
_L19:
        h1;
        JVM INSTR monitorexit ;
        flag = true;
          goto _L3
_L11:
        controlledinputconnectionwrapper = null;
        continue; /* Loop/switch isn't completed */
_L13:
        inputbindresult = mService.startInput(mClient, controlledinputconnectionwrapper, editorinfo, i);
          goto _L21
_L17:
        iinputmethodsession = mCurMethod;
        if(iinputmethodsession != null) goto _L15; else goto _L22
_L22:
        flag = true;
        h1;
        JVM INSTR monitorexit ;
          goto _L3
        remoteexception;
        Log.w("InputMethodManager", (new StringBuilder()).append("IME died: ").append(mCurId).toString(), remoteexception);
          goto _L19
_L3:
        return flag;
        if(true) goto _L24; else goto _L23
_L23:
    }

    public boolean switchToLastInputMethod(IBinder ibinder) {
        H h = mH;
        h;
        JVM INSTR monitorenter ;
        boolean flag;
label0:
        {
            boolean flag1;
            try {
                flag1 = mService.switchToLastInputMethod(ibinder);
            }
            catch(RemoteException remoteexception) {
                Log.w("InputMethodManager", (new StringBuilder()).append("IME died: ").append(mCurId).toString(), remoteexception);
                flag = false;
                break label0;
            }
            finally {
                throw exception;
            }
            flag = flag1;
            break label0;
        }
        return flag;
    }

    public boolean switchToNextInputMethod(IBinder ibinder, boolean flag) {
        H h = mH;
        h;
        JVM INSTR monitorenter ;
        boolean flag1;
label0:
        {
            boolean flag2;
            try {
                flag2 = mService.switchToNextInputMethod(ibinder, flag);
            }
            catch(RemoteException remoteexception) {
                Log.w("InputMethodManager", (new StringBuilder()).append("IME died: ").append(mCurId).toString(), remoteexception);
                flag1 = false;
                break label0;
            }
            finally {
                throw exception;
            }
            flag1 = flag2;
            break label0;
        }
        return flag1;
    }

    public void toggleSoftInput(int i, int j) {
        if(mCurMethod == null)
            break MISSING_BLOCK_LABEL_18;
        mCurMethod.toggleSoftInput(i, j);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void toggleSoftInputFromWindow(IBinder ibinder, int i, int j) {
        H h = mH;
        h;
        JVM INSTR monitorenter ;
        IInputMethodSession iinputmethodsession;
        if(mServedView == null || mServedView.getWindowToken() != ibinder)
            break MISSING_BLOCK_LABEL_74;
        iinputmethodsession = mCurMethod;
        Exception exception;
        if(iinputmethodsession != null)
            try {
                mCurMethod.toggleSoftInput(i, j);
            }
            catch(RemoteException remoteexception) { }
            finally {
                h;
            }
        h;
        JVM INSTR monitorexit ;
        if(true)
            break MISSING_BLOCK_LABEL_74;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void updateCursor(View view, int i, int j, int k, int l) {
        checkFocus();
        H h = mH;
        h;
        JVM INSTR monitorenter ;
        if((mServedView == view || mServedView != null && mServedView.checkInputConnectionProxy(view)) && mCurrentTextBoxAttribute != null && mCurMethod != null) goto _L2; else goto _L1
_L2:
        boolean flag;
        mTmpCursorRect.set(i, j, k, l);
        flag = mCursorRect.equals(mTmpCursorRect);
        if(flag)
            break MISSING_BLOCK_LABEL_114;
        mCurMethod.updateCursor(mTmpCursorRect);
        mCursorRect.set(mTmpCursorRect);
_L3:
        h;
        JVM INSTR monitorexit ;
        break; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        throw exception;
        RemoteException remoteexception;
        remoteexception;
        Log.w("InputMethodManager", (new StringBuilder()).append("IME died: ").append(mCurId).toString(), remoteexception);
        if(true) goto _L3; else goto _L1
_L1:
    }

    public void updateExtractedText(View view, int i, ExtractedText extractedtext) {
        checkFocus();
        H h = mH;
        h;
        JVM INSTR monitorenter ;
        IInputMethodSession iinputmethodsession;
        if(mServedView != view && (mServedView == null || !mServedView.checkInputConnectionProxy(view)))
            break MISSING_BLOCK_LABEL_86;
        iinputmethodsession = mCurMethod;
        Exception exception;
        if(iinputmethodsession != null)
            try {
                mCurMethod.updateExtractedText(i, extractedtext);
            }
            catch(RemoteException remoteexception) { }
            finally {
                h;
            }
        h;
        JVM INSTR monitorexit ;
        if(true)
            break MISSING_BLOCK_LABEL_86;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void updateSelection(View view, int i, int j, int k, int l) {
        checkFocus();
        H h = mH;
        h;
        JVM INSTR monitorenter ;
        if((mServedView == view || mServedView != null && mServedView.checkInputConnectionProxy(view)) && mCurrentTextBoxAttribute != null && mCurMethod != null) goto _L2; else goto _L1
_L2:
        int i1;
        if(mCursorSelStart != i || mCursorSelEnd != j || mCursorCandStart != k)
            break MISSING_BLOCK_LABEL_97;
        i1 = mCursorCandEnd;
        if(i1 == l)
            break MISSING_BLOCK_LABEL_142;
        mCurMethod.updateSelection(mCursorSelStart, mCursorSelEnd, i, j, k, l);
        mCursorSelStart = i;
        mCursorSelEnd = j;
        mCursorCandStart = k;
        mCursorCandEnd = l;
_L3:
        h;
        JVM INSTR monitorexit ;
        break; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        throw exception;
        RemoteException remoteexception;
        remoteexception;
        Log.w("InputMethodManager", (new StringBuilder()).append("IME died: ").append(mCurId).toString(), remoteexception);
        if(true) goto _L3; else goto _L1
_L1:
    }

    public void viewClicked(View view) {
        boolean flag;
        H h;
        if(mServedView != mNextServedView)
            flag = true;
        else
            flag = false;
        checkFocus();
        h = mH;
        h;
        JVM INSTR monitorenter ;
        if((mServedView == view || mServedView != null && mServedView.checkInputConnectionProxy(view)) && mCurrentTextBoxAttribute != null && mCurMethod != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        mCurMethod.viewClicked(flag);
_L3:
        h;
        JVM INSTR monitorexit ;
          goto _L1
        Exception exception;
        exception;
        throw exception;
        RemoteException remoteexception;
        remoteexception;
        Log.w("InputMethodManager", (new StringBuilder()).append("IME died: ").append(mCurId).toString(), remoteexception);
          goto _L3
    }

    public void windowDismissed(IBinder ibinder) {
        checkFocus();
        H h = mH;
        h;
        JVM INSTR monitorenter ;
        if(mServedView != null && mServedView.getWindowToken() == ibinder)
            finishInputLocked();
        return;
    }

    public static final int CONTROL_START_INITIAL = 256;
    public static final int CONTROL_WINDOW_FIRST = 4;
    public static final int CONTROL_WINDOW_IS_TEXT_EDITOR = 2;
    public static final int CONTROL_WINDOW_VIEW_HAS_FOCUS = 1;
    static final boolean DEBUG = false;
    public static final int HIDE_IMPLICIT_ONLY = 1;
    public static final int HIDE_NOT_ALWAYS = 2;
    static final int MSG_BIND = 2;
    static final int MSG_DUMP = 1;
    static final int MSG_SET_ACTIVE = 4;
    static final int MSG_UNBIND = 3;
    public static final int RESULT_HIDDEN = 3;
    public static final int RESULT_SHOWN = 2;
    public static final int RESULT_UNCHANGED_HIDDEN = 1;
    public static final int RESULT_UNCHANGED_SHOWN = 0;
    public static final int SHOW_FORCED = 2;
    public static final int SHOW_IMPLICIT = 1;
    static final String TAG = "InputMethodManager";
    static InputMethodManager mInstance;
    static final Object mInstanceSync = new Object();
    boolean mActive;
    int mBindSequence;
    final com.android.internal.view.IInputMethodClient.Stub mClient = new com.android.internal.view.IInputMethodClient.Stub() {

        protected void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
            CountDownLatch countdownlatch;
            countdownlatch = new CountDownLatch(1);
            com.android.internal.os.HandlerCaller.SomeArgs someargs = new com.android.internal.os.HandlerCaller.SomeArgs();
            someargs.arg1 = filedescriptor;
            someargs.arg2 = printwriter;
            someargs.arg3 = as;
            someargs.arg4 = countdownlatch;
            mH.sendMessage(mH.obtainMessage(1, someargs));
            if(!countdownlatch.await(5L, TimeUnit.SECONDS))
                printwriter.println("Timeout waiting for dump");
_L1:
            return;
            InterruptedException interruptedexception;
            interruptedexception;
            printwriter.println("Interrupted waiting for dump");
              goto _L1
        }

        public void onBindMethod(InputBindResult inputbindresult) {
            mH.sendMessage(mH.obtainMessage(2, inputbindresult));
        }

        public void onUnbindMethod(int i) {
            mH.sendMessage(mH.obtainMessage(3, i, 0));
        }

        public void setActive(boolean flag) {
            H h = mH;
            H h1 = mH;
            int i;
            if(flag)
                i = 1;
            else
                i = 0;
            h.sendMessage(h1.obtainMessage(4, i, 0));
        }

        public void setUsingInputMethod(boolean flag) {
        }

        final InputMethodManager this$0;

             {
                this$0 = InputMethodManager.this;
                super();
            }
    };
    CompletionInfo mCompletions[];
    String mCurId;
    IInputMethodSession mCurMethod;
    View mCurRootView;
    EditorInfo mCurrentTextBoxAttribute;
    int mCursorCandEnd;
    int mCursorCandStart;
    Rect mCursorRect;
    int mCursorSelEnd;
    int mCursorSelStart;
    final InputConnection mDummyInputConnection = new BaseInputConnection(this, false);
    boolean mFullscreenMode;
    final H mH;
    boolean mHasBeenInactive;
    final IInputContext mIInputContext;
    final Looper mMainLooper;
    View mNextServedView;
    boolean mServedConnecting;
    InputConnection mServedInputConnection;
    ControlledInputConnectionWrapper mServedInputConnectionWrapper;
    View mServedView;
    final IInputMethodManager mService;
    Rect mTmpCursorRect;


}

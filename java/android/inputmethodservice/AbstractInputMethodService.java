// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.inputmethodservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodSession;
import java.io.FileDescriptor;
import java.io.PrintWriter;

// Referenced classes of package android.inputmethodservice:
//            IInputMethodWrapper

public abstract class AbstractInputMethodService extends Service
    implements android.view.KeyEvent.Callback {
    public abstract class AbstractInputMethodSessionImpl
        implements InputMethodSession {

        public void dispatchKeyEvent(int i, KeyEvent keyevent, android.view.inputmethod.InputMethodSession.EventCallback eventcallback) {
            boolean flag = keyevent.dispatch(AbstractInputMethodService.this, mDispatcherState, this);
            if(eventcallback != null)
                eventcallback.finishedEvent(i, flag);
        }

        public void dispatchTrackballEvent(int i, MotionEvent motionevent, android.view.inputmethod.InputMethodSession.EventCallback eventcallback) {
            boolean flag = onTrackballEvent(motionevent);
            if(eventcallback != null)
                eventcallback.finishedEvent(i, flag);
        }

        public boolean isEnabled() {
            return mEnabled;
        }

        public boolean isRevoked() {
            return mRevoked;
        }

        public void revokeSelf() {
            mRevoked = true;
            mEnabled = false;
        }

        public void setEnabled(boolean flag) {
            if(!mRevoked)
                mEnabled = flag;
        }

        boolean mEnabled;
        boolean mRevoked;
        final AbstractInputMethodService this$0;

        public AbstractInputMethodSessionImpl() {
            this$0 = AbstractInputMethodService.this;
            super();
            mEnabled = true;
        }
    }

    public abstract class AbstractInputMethodImpl
        implements InputMethod {

        public void createSession(android.view.inputmethod.InputMethod.SessionCallback sessioncallback) {
            sessioncallback.sessionCreated(onCreateInputMethodSessionInterface());
        }

        public void revokeSession(InputMethodSession inputmethodsession) {
            ((AbstractInputMethodSessionImpl)inputmethodsession).revokeSelf();
        }

        public void setSessionEnabled(InputMethodSession inputmethodsession, boolean flag) {
            ((AbstractInputMethodSessionImpl)inputmethodsession).setEnabled(flag);
        }

        final AbstractInputMethodService this$0;

        public AbstractInputMethodImpl() {
            this$0 = AbstractInputMethodService.this;
            super();
        }
    }


    public AbstractInputMethodService() {
    }

    protected void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
    }

    public android.view.KeyEvent.DispatcherState getKeyDispatcherState() {
        return mDispatcherState;
    }

    public final IBinder onBind(Intent intent) {
        if(mInputMethod == null)
            mInputMethod = onCreateInputMethodInterface();
        return new IInputMethodWrapper(this, mInputMethod);
    }

    public abstract AbstractInputMethodImpl onCreateInputMethodInterface();

    public abstract AbstractInputMethodSessionImpl onCreateInputMethodSessionInterface();

    public boolean onTrackballEvent(MotionEvent motionevent) {
        return false;
    }

    final android.view.KeyEvent.DispatcherState mDispatcherState = new android.view.KeyEvent.DispatcherState();
    private InputMethod mInputMethod;
}

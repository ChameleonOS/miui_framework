// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.inputmethod;

import android.os.IBinder;
import android.os.ResultReceiver;

// Referenced classes of package android.view.inputmethod:
//            InputBinding, InputMethodSubtype, InputConnection, EditorInfo, 
//            InputMethodSession

public interface InputMethod {
    public static interface SessionCallback {

        public abstract void sessionCreated(InputMethodSession inputmethodsession);
    }


    public abstract void attachToken(IBinder ibinder);

    public abstract void bindInput(InputBinding inputbinding);

    public abstract void changeInputMethodSubtype(InputMethodSubtype inputmethodsubtype);

    public abstract void createSession(SessionCallback sessioncallback);

    public abstract void hideSoftInput(int i, ResultReceiver resultreceiver);

    public abstract void restartInput(InputConnection inputconnection, EditorInfo editorinfo);

    public abstract void revokeSession(InputMethodSession inputmethodsession);

    public abstract void setSessionEnabled(InputMethodSession inputmethodsession, boolean flag);

    public abstract void showSoftInput(int i, ResultReceiver resultreceiver);

    public abstract void startInput(InputConnection inputconnection, EditorInfo editorinfo);

    public abstract void unbindInput();

    public static final String SERVICE_INTERFACE = "android.view.InputMethod";
    public static final String SERVICE_META_DATA = "android.view.im";
    public static final int SHOW_EXPLICIT = 1;
    public static final int SHOW_FORCED = 2;
}

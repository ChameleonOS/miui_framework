// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.service.dreams;

import android.app.Service;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.*;
import android.util.Slog;
import android.view.*;
import android.view.accessibility.AccessibilityEvent;
import com.android.internal.policy.PolicyManager;

// Referenced classes of package android.service.dreams:
//            IDreamManager

public class Dream extends Service
    implements android.view.Window.Callback {
    class IDreamServiceWrapper extends IDreamService.Stub {

        public void attach(IBinder ibinder) {
            Dream.this.attach(ibinder);
        }

        final Dream this$0;

        public IDreamServiceWrapper() {
            this$0 = Dream.this;
            super();
        }
    }


    public Dream() {
        mFinished = false;
    }

    public void addContentView(View view, android.view.ViewGroup.LayoutParams layoutparams) {
        getWindow().addContentView(view, layoutparams);
    }

    final void attach(IBinder ibinder) {
        Slog.v("Dream", (new StringBuilder()).append("Dream attached on thread ").append(Thread.currentThread().getId()).toString());
        mWindow = PolicyManager.makeNewWindow(this);
        mWindow.setCallback(this);
        mWindow.requestFeature(1);
        mWindow.setBackgroundDrawable(new ColorDrawable(0xff000000));
        Slog.v("Dream", (new StringBuilder()).append("attaching window token: ").append(ibinder).append(" to window of type ").append(2023).toString());
        android.view.WindowManager.LayoutParams layoutparams = mWindow.getAttributes();
        layoutparams.type = 2023;
        layoutparams.token = ibinder;
        layoutparams.windowAnimations = 0x10301ed;
        Slog.v("Dream", (new StringBuilder()).append("created and attached window: ").append(mWindow).toString());
        mWindow.setWindowManager(null, ibinder, "dream", true);
        mWindowManager = mWindow.getWindowManager();
        mHandler.post(new Runnable() {

            public void run() {
                Slog.v("Dream", (new StringBuilder()).append("Dream window added on thread ").append(Thread.currentThread().getId()).toString());
                getWindowManager().addView(mWindow.getDecorView(), mWindow.getAttributes());
            }

            final Dream this$0;

             {
                this$0 = Dream.this;
                super();
            }
        });
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionevent) {
        boolean flag;
        if(!mInteractive) {
            finish();
            flag = true;
        } else {
            flag = mWindow.superDispatchGenericMotionEvent(motionevent);
        }
        return flag;
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent) {
        boolean flag;
        if(!mInteractive) {
            finish();
            flag = true;
        } else {
            flag = mWindow.superDispatchKeyEvent(keyevent);
        }
        return flag;
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyevent) {
        boolean flag;
        if(!mInteractive) {
            finish();
            flag = true;
        } else {
            flag = mWindow.superDispatchKeyShortcutEvent(keyevent);
        }
        return flag;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent) {
        boolean flag;
        if(!mInteractive) {
            finish();
            flag = true;
        } else {
            flag = mWindow.superDispatchTouchEvent(motionevent);
        }
        return flag;
    }

    public boolean dispatchTrackballEvent(MotionEvent motionevent) {
        boolean flag;
        if(!mInteractive) {
            finish();
            flag = true;
        } else {
            flag = mWindow.superDispatchTrackballEvent(motionevent);
        }
        return flag;
    }

    public View findViewById(int i) {
        return getWindow().findViewById(i);
    }

    public void finish() {
        if(!mFinished)
            try {
                mSandman.awaken();
                stopSelf();
                mFinished = true;
            }
            catch(RemoteException remoteexception) { }
    }

    public Window getWindow() {
        return mWindow;
    }

    public WindowManager getWindowManager() {
        return mWindowManager;
    }

    public boolean isInteractive() {
        return mInteractive;
    }

    protected void lightsOut() {
        View view = mWindow.getDecorView();
        if(view != null)
            view.setSystemUiVisibility(1);
    }

    public void onActionModeFinished(ActionMode actionmode) {
    }

    public void onActionModeStarted(ActionMode actionmode) {
    }

    public void onAttachedToWindow() {
        mWindow.addFlags(0x80001);
        lightsOut();
    }

    public final IBinder onBind(Intent intent) {
        return new IDreamServiceWrapper();
    }

    public void onContentChanged() {
    }

    public void onCreate() {
        super.onCreate();
        Slog.v("Dream", (new StringBuilder()).append("Dream created on thread ").append(Thread.currentThread().getId()).toString());
        mSandman = IDreamManager.Stub.asInterface(ServiceManager.getService("dreams"));
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return false;
    }

    public View onCreatePanelView(int i) {
        return null;
    }

    public void onDestroy() {
        super.onDestroy();
        mWindowManager.removeView(mWindow.getDecorView());
    }

    public void onDetachedFromWindow() {
    }

    public boolean onMenuItemSelected(int i, MenuItem menuitem) {
        return false;
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return false;
    }

    public void onPanelClosed(int i, Menu menu) {
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        return false;
    }

    public boolean onSearchRequested() {
        return false;
    }

    public int onStartCommand(Intent intent, int i, int j) {
        return super.onStartCommand(intent, i, j);
    }

    public void onWindowAttributesChanged(android.view.WindowManager.LayoutParams layoutparams) {
    }

    public void onWindowFocusChanged(boolean flag) {
    }

    public ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback) {
        return null;
    }

    public void setContentView(int i) {
        getWindow().setContentView(i);
    }

    public void setContentView(View view) {
        getWindow().setContentView(view);
    }

    public void setContentView(View view, android.view.ViewGroup.LayoutParams layoutparams) {
        getWindow().setContentView(view, layoutparams);
    }

    public void setInteractive(boolean flag) {
        mInteractive = flag;
    }

    private static final boolean DEBUG = true;
    public static final String SERVICE_INTERFACE = "android.service.dreams.Dream";
    private static final String TAG = "Dream";
    boolean mFinished;
    final Handler mHandler = new Handler();
    private boolean mInteractive;
    private IDreamManager mSandman;
    private Window mWindow;
    private WindowManager mWindowManager;

}

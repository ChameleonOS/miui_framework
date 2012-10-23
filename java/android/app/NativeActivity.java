// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.Context;
import android.content.Intent;
import android.content.pm.*;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.os.*;
import android.util.AttributeSet;
import android.view.*;
import android.view.inputmethod.InputMethodManager;
import com.android.internal.view.IInputMethodSession;
import java.io.File;
import java.lang.ref.WeakReference;

// Referenced classes of package android.app:
//            Activity

public class NativeActivity extends Activity
    implements android.view.SurfaceHolder.Callback2, android.view.InputQueue.Callback, android.view.ViewTreeObserver.OnGlobalLayoutListener {
    static class InputMethodCallback extends com.android.internal.view.IInputMethodCallback.Stub {

        public void finishedEvent(int i, boolean flag) {
            NativeActivity nativeactivity = (NativeActivity)mNa.get();
            if(nativeactivity != null)
                nativeactivity.finishPreDispatchKeyEventNative(nativeactivity.mNativeHandle, i, flag);
        }

        public void sessionCreated(IInputMethodSession iinputmethodsession) {
        }

        WeakReference mNa;

        InputMethodCallback(NativeActivity nativeactivity) {
            mNa = new WeakReference(nativeactivity);
        }
    }

    static class NativeContentView extends View {

        NativeActivity mActivity;

        public NativeContentView(Context context) {
            super(context);
        }

        public NativeContentView(Context context, AttributeSet attributeset) {
            super(context, attributeset);
        }
    }


    public NativeActivity() {
    }

    private native void dispatchKeyEventNative(int i, KeyEvent keyevent);

    private native void finishPreDispatchKeyEventNative(int i, int j, boolean flag);

    private native int loadNativeCode(String s, String s1, MessageQueue messagequeue, String s2, String s3, String s4, int i, 
            AssetManager assetmanager, byte abyte0[]);

    private native void onConfigurationChangedNative(int i);

    private native void onContentRectChangedNative(int i, int j, int k, int l, int i1);

    private native void onInputChannelCreatedNative(int i, InputChannel inputchannel);

    private native void onInputChannelDestroyedNative(int i, InputChannel inputchannel);

    private native void onLowMemoryNative(int i);

    private native void onPauseNative(int i);

    private native void onResumeNative(int i);

    private native byte[] onSaveInstanceStateNative(int i);

    private native void onStartNative(int i);

    private native void onStopNative(int i);

    private native void onSurfaceChangedNative(int i, Surface surface, int j, int k, int l);

    private native void onSurfaceCreatedNative(int i, Surface surface);

    private native void onSurfaceDestroyedNative(int i);

    private native void onSurfaceRedrawNeededNative(int i, Surface surface);

    private native void onWindowFocusChangedNative(int i, boolean flag);

    private native void unloadNativeCode(int i);

    public boolean dispatchKeyEvent(KeyEvent keyevent) {
        boolean flag;
        if(mDispatchingUnhandledKey) {
            flag = super.dispatchKeyEvent(keyevent);
        } else {
            dispatchKeyEventNative(mNativeHandle, keyevent);
            flag = true;
        }
        return flag;
    }

    boolean dispatchUnhandledKeyEvent(KeyEvent keyevent) {
        View view;
        mDispatchingUnhandledKey = true;
        view = getWindow().getDecorView();
        if(view == null) goto _L2; else goto _L1
_L1:
        boolean flag1 = view.dispatchKeyEvent(keyevent);
        boolean flag;
        flag = flag1;
        mDispatchingUnhandledKey = false;
_L4:
        return flag;
_L2:
        mDispatchingUnhandledKey = false;
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        mDispatchingUnhandledKey = false;
        throw exception;
    }

    void hideIme(int i) {
        mIMM.hideSoftInputFromWindow(mNativeContentView.getWindowToken(), i);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if(!mDestroyed)
            onConfigurationChangedNative(mNativeHandle);
    }

    protected void onCreate(Bundle bundle) {
        String s1;
        android.content.pm.ActivityInfo activityinfo;
        String s2;
label0:
        {
            String s = "main";
            s1 = "ANativeActivity_onCreate";
            mIMM = (InputMethodManager)getSystemService("input_method");
            mInputMethodCallback = new InputMethodCallback(this);
            getWindow().takeSurface(this);
            getWindow().takeInputQueue(this);
            getWindow().setFormat(4);
            getWindow().setSoftInputMode(16);
            mNativeContentView = new NativeContentView(this);
            mNativeContentView.mActivity = this;
            setContentView(mNativeContentView);
            mNativeContentView.requestFocus();
            mNativeContentView.getViewTreeObserver().addOnGlobalLayoutListener(this);
            File file;
            String s4;
            try {
                activityinfo = getPackageManager().getActivityInfo(getIntent().getComponent(), 128);
                if(((PackageItemInfo) (activityinfo)).metaData == null)
                    break label0;
                String s3 = ((PackageItemInfo) (activityinfo)).metaData.getString("android.app.lib_name");
                if(s3 != null)
                    s = s3;
                s4 = ((PackageItemInfo) (activityinfo)).metaData.getString("android.app.func_name");
            }
            catch(android.content.pm.PackageManager.NameNotFoundException namenotfoundexception) {
                throw new RuntimeException("Error getting activity info", namenotfoundexception);
            }
            if(s4 != null)
                s1 = s4;
        }
        s2 = null;
        file = new File(((ComponentInfo) (activityinfo)).applicationInfo.nativeLibraryDir, System.mapLibraryName(s));
        if(file.exists())
            s2 = file.getPath();
        if(s2 == null)
            throw new IllegalArgumentException((new StringBuilder()).append("Unable to find native library: ").append(s).toString());
        break MISSING_BLOCK_LABEL_265;
        byte abyte0[];
        if(bundle != null)
            abyte0 = bundle.getByteArray("android:native_state");
        else
            abyte0 = null;
        mNativeHandle = loadNativeCode(s2, s1, Looper.myQueue(), getFilesDir().toString(), getObbDir().toString(), Environment.getExternalStorageAppFilesDirectory(((PackageItemInfo) (activityinfo)).packageName).toString(), android.os.Build.VERSION.SDK_INT, getAssets(), abyte0);
        if(mNativeHandle == 0) {
            throw new IllegalArgumentException((new StringBuilder()).append("Unable to load native library: ").append(s2).toString());
        } else {
            super.onCreate(bundle);
            return;
        }
    }

    protected void onDestroy() {
        mDestroyed = true;
        if(mCurSurfaceHolder != null) {
            onSurfaceDestroyedNative(mNativeHandle);
            mCurSurfaceHolder = null;
        }
        if(mCurInputQueue != null) {
            onInputChannelDestroyedNative(mNativeHandle, mCurInputQueue.getInputChannel());
            mCurInputQueue = null;
        }
        unloadNativeCode(mNativeHandle);
        super.onDestroy();
    }

    public void onGlobalLayout() {
        mNativeContentView.getLocationInWindow(mLocation);
        int i = mNativeContentView.getWidth();
        int j = mNativeContentView.getHeight();
        if(mLocation[0] != mLastContentX || mLocation[1] != mLastContentY || i != mLastContentWidth || j != mLastContentHeight) {
            mLastContentX = mLocation[0];
            mLastContentY = mLocation[1];
            mLastContentWidth = i;
            mLastContentHeight = j;
            if(!mDestroyed)
                onContentRectChangedNative(mNativeHandle, mLastContentX, mLastContentY, mLastContentWidth, mLastContentHeight);
        }
    }

    public void onInputQueueCreated(InputQueue inputqueue) {
        if(!mDestroyed) {
            mCurInputQueue = inputqueue;
            onInputChannelCreatedNative(mNativeHandle, inputqueue.getInputChannel());
        }
    }

    public void onInputQueueDestroyed(InputQueue inputqueue) {
        mCurInputQueue = null;
        if(!mDestroyed)
            onInputChannelDestroyedNative(mNativeHandle, inputqueue.getInputChannel());
    }

    public void onLowMemory() {
        super.onLowMemory();
        if(!mDestroyed)
            onLowMemoryNative(mNativeHandle);
    }

    protected void onPause() {
        super.onPause();
        onPauseNative(mNativeHandle);
    }

    protected void onResume() {
        super.onResume();
        onResumeNative(mNativeHandle);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        byte abyte0[] = onSaveInstanceStateNative(mNativeHandle);
        if(abyte0 != null)
            bundle.putByteArray("android:native_state", abyte0);
    }

    protected void onStart() {
        super.onStart();
        onStartNative(mNativeHandle);
    }

    protected void onStop() {
        super.onStop();
        onStopNative(mNativeHandle);
    }

    public void onWindowFocusChanged(boolean flag) {
        super.onWindowFocusChanged(flag);
        if(!mDestroyed)
            onWindowFocusChangedNative(mNativeHandle, flag);
    }

    void preDispatchKeyEvent(KeyEvent keyevent, int i) {
        mIMM.dispatchKeyEvent(this, i, keyevent, mInputMethodCallback);
    }

    void setWindowFlags(int i, int j) {
        getWindow().setFlags(i, j);
    }

    void setWindowFormat(int i) {
        getWindow().setFormat(i);
    }

    void showIme(int i) {
        mIMM.showSoftInput(mNativeContentView, i);
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k) {
        if(!mDestroyed) {
            mCurSurfaceHolder = surfaceholder;
            onSurfaceChangedNative(mNativeHandle, surfaceholder.getSurface(), i, j, k);
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceholder) {
        if(!mDestroyed) {
            mCurSurfaceHolder = surfaceholder;
            onSurfaceCreatedNative(mNativeHandle, surfaceholder.getSurface());
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder) {
        mCurSurfaceHolder = null;
        if(!mDestroyed)
            onSurfaceDestroyedNative(mNativeHandle);
    }

    public void surfaceRedrawNeeded(SurfaceHolder surfaceholder) {
        if(!mDestroyed) {
            mCurSurfaceHolder = surfaceholder;
            onSurfaceRedrawNeededNative(mNativeHandle, surfaceholder.getSurface());
        }
    }

    private static final String KEY_NATIVE_SAVED_STATE = "android:native_state";
    public static final String META_DATA_FUNC_NAME = "android.app.func_name";
    public static final String META_DATA_LIB_NAME = "android.app.lib_name";
    private InputQueue mCurInputQueue;
    private SurfaceHolder mCurSurfaceHolder;
    private boolean mDestroyed;
    private boolean mDispatchingUnhandledKey;
    private InputMethodManager mIMM;
    private InputMethodCallback mInputMethodCallback;
    int mLastContentHeight;
    int mLastContentWidth;
    int mLastContentX;
    int mLastContentY;
    final int mLocation[] = new int[2];
    private NativeContentView mNativeContentView;
    private int mNativeHandle;


}

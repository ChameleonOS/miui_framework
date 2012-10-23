// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.app.Application;
import android.app.LoadedApk;
import android.content.Context;
import android.content.res.*;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.*;
import android.view.accessibility.AccessibilityEvent;

// Referenced classes of package android.view:
//            CompatibilityInfoHolder, MotionEvent, ViewConfiguration, View, 
//            WindowManagerImpl, WindowManager, LayoutInflater, KeyEvent, 
//            ActionMode, Menu, MenuItem

public abstract class Window {
    private class LocalWindowManager extends WindowManagerImpl.CompatModeWrapper {

        public final void addView(View view, ViewGroup.LayoutParams layoutparams) {
            WindowManager.LayoutParams layoutparams1;
            CharSequence charsequence;
            layoutparams1 = (WindowManager.LayoutParams)layoutparams;
            charsequence = layoutparams1.getTitle();
            if(layoutparams1.type < 1000 || layoutparams1.type > 1999) goto _L2; else goto _L1
_L1:
            if(layoutparams1.token == null) {
                View view1 = peekDecorView();
                if(view1 != null)
                    layoutparams1.token = view1.getWindowToken();
            }
            if(charsequence == null || charsequence.length() == 0) {
                String s;
                if(layoutparams1.type == 1001)
                    s = "Media";
                else
                if(layoutparams1.type == 1004)
                    s = "MediaOvr";
                else
                if(layoutparams1.type == 1000)
                    s = "Panel";
                else
                if(layoutparams1.type == 1002)
                    s = "SubPanel";
                else
                if(layoutparams1.type == 1003)
                    s = "AtchDlg";
                else
                    s = Integer.toString(layoutparams1.type);
                if(mAppName != null)
                    s = (new StringBuilder()).append(s).append(":").append(mAppName).toString();
                layoutparams1.setTitle(s);
            }
_L4:
            if(layoutparams1.packageName == null)
                layoutparams1.packageName = mContext.getPackageName();
            if(mHardwareAccelerated)
                layoutparams1.flags = 0x1000000 | layoutparams1.flags;
            super.addView(view, layoutparams);
            return;
_L2:
            if(layoutparams1.token == null) {
                IBinder ibinder;
                if(mContainer == null)
                    ibinder = mAppToken;
                else
                    ibinder = mContainer.mAppToken;
                layoutparams1.token = ibinder;
            }
            if((charsequence == null || charsequence.length() == 0) && mAppName != null)
                layoutparams1.setTitle(mAppName);
            if(true) goto _L4; else goto _L3
_L3:
        }

        public boolean isHardwareAccelerated() {
            return mHardwareAccelerated;
        }

        private static final String PROPERTY_HARDWARE_UI = "persist.sys.ui.hw";
        private final boolean mHardwareAccelerated;
        final Window this$0;

        LocalWindowManager(WindowManager windowmanager, boolean flag) {
            boolean flag1 = false;
            this$0 = Window.this;
            super(windowmanager, Window.getCompatInfo(mContext));
            if(flag || SystemProperties.getBoolean("persist.sys.ui.hw", false))
                flag1 = true;
            mHardwareAccelerated = flag1;
        }
    }

    public static interface Callback {

        public abstract boolean dispatchGenericMotionEvent(MotionEvent motionevent);

        public abstract boolean dispatchKeyEvent(KeyEvent keyevent);

        public abstract boolean dispatchKeyShortcutEvent(KeyEvent keyevent);

        public abstract boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent);

        public abstract boolean dispatchTouchEvent(MotionEvent motionevent);

        public abstract boolean dispatchTrackballEvent(MotionEvent motionevent);

        public abstract void onActionModeFinished(ActionMode actionmode);

        public abstract void onActionModeStarted(ActionMode actionmode);

        public abstract void onAttachedToWindow();

        public abstract void onContentChanged();

        public abstract boolean onCreatePanelMenu(int i, Menu menu);

        public abstract View onCreatePanelView(int i);

        public abstract void onDetachedFromWindow();

        public abstract boolean onMenuItemSelected(int i, MenuItem menuitem);

        public abstract boolean onMenuOpened(int i, Menu menu);

        public abstract void onPanelClosed(int i, Menu menu);

        public abstract boolean onPreparePanel(int i, View view, Menu menu);

        public abstract boolean onSearchRequested();

        public abstract void onWindowAttributesChanged(WindowManager.LayoutParams layoutparams);

        public abstract void onWindowFocusChanged(boolean flag);

        public abstract ActionMode onWindowStartingActionMode(ActionMode.Callback callback);
    }


    public Window(Context context) {
        mIsActive = false;
        mHasChildren = false;
        mCloseOnTouchOutside = false;
        mSetCloseOnTouchOutside = false;
        mForcedWindowFlags = 0;
        mFeatures = 65;
        mLocalFeatures = 65;
        mHaveWindowFormat = false;
        mHaveDimAmount = false;
        mDefaultWindowFormat = -1;
        mHasSoftInputMode = false;
        mContext = context;
    }

    static CompatibilityInfoHolder getCompatInfo(Context context) {
        Application application = (Application)context.getApplicationContext();
        CompatibilityInfoHolder compatibilityinfoholder;
        if(application != null)
            compatibilityinfoholder = application.mLoadedApk.mCompatibilityInfo;
        else
            compatibilityinfoholder = new CompatibilityInfoHolder();
        return compatibilityinfoholder;
    }

    private boolean isOutOfBounds(Context context, MotionEvent motionevent) {
        int i = (int)motionevent.getX();
        int j = (int)motionevent.getY();
        int k = ViewConfiguration.get(context).getScaledWindowTouchSlop();
        View view = getDecorView();
        boolean flag;
        if(i < -k || j < -k || i > k + view.getWidth() || j > k + view.getHeight())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public abstract void addContentView(View view, ViewGroup.LayoutParams layoutparams);

    public void addFlags(int i) {
        setFlags(i, i);
    }

    public abstract void alwaysReadCloseOnTouchAttr();

    public void clearFlags(int i) {
        setFlags(0, i);
    }

    public abstract void closeAllPanels();

    public abstract void closePanel(int i);

    public final void destroy() {
        mDestroyed = true;
    }

    public View findViewById(int i) {
        return getDecorView().findViewById(i);
    }

    public final WindowManager.LayoutParams getAttributes() {
        return mWindowAttributes;
    }

    public final Callback getCallback() {
        return mCallback;
    }

    public final Window getContainer() {
        return mContainer;
    }

    public final Context getContext() {
        return mContext;
    }

    public abstract View getCurrentFocus();

    public abstract View getDecorView();

    protected final int getFeatures() {
        return mFeatures;
    }

    protected final int getForcedWindowFlags() {
        return mForcedWindowFlags;
    }

    public abstract LayoutInflater getLayoutInflater();

    protected final int getLocalFeatures() {
        return mLocalFeatures;
    }

    public abstract int getVolumeControlStream();

    public WindowManager getWindowManager() {
        return mWindowManager;
    }

    public final TypedArray getWindowStyle() {
        this;
        JVM INSTR monitorenter ;
        if(mWindowStyle == null)
            mWindowStyle = mContext.obtainStyledAttributes(com.android.internal.R.styleable.Window);
        TypedArray typedarray = mWindowStyle;
        return typedarray;
    }

    public final boolean hasChildren() {
        return mHasChildren;
    }

    public boolean hasFeature(int i) {
        boolean flag = true;
        if((getFeatures() & flag << i) == 0)
            flag = false;
        return flag;
    }

    protected final boolean hasSoftInputMode() {
        return mHasSoftInputMode;
    }

    protected boolean haveDimAmount() {
        return mHaveDimAmount;
    }

    public abstract void invalidatePanelMenu(int i);

    public final boolean isActive() {
        return mIsActive;
    }

    public final boolean isDestroyed() {
        return mDestroyed;
    }

    public abstract boolean isFloating();

    public abstract boolean isShortcutKey(int i, KeyEvent keyevent);

    public final void makeActive() {
        if(mContainer != null) {
            if(mContainer.mActiveChild != null)
                mContainer.mActiveChild.mIsActive = false;
            mContainer.mActiveChild = this;
        }
        mIsActive = true;
        onActive();
    }

    protected abstract void onActive();

    public abstract void onConfigurationChanged(Configuration configuration);

    public abstract void openPanel(int i, KeyEvent keyevent);

    public abstract View peekDecorView();

    public abstract boolean performContextMenuIdentifierAction(int i, int j);

    public abstract boolean performPanelIdentifierAction(int i, int j, int k);

    public abstract boolean performPanelShortcut(int i, int j, KeyEvent keyevent, int k);

    protected void removeFeature(int i) {
        int j = 1 << i;
        mFeatures = mFeatures & ~j;
        int k = mLocalFeatures;
        if(mContainer != null)
            j &= -1 ^ mContainer.mFeatures;
        mLocalFeatures = k & ~j;
    }

    public boolean requestFeature(int i) {
        int j = 1 << i;
        mFeatures = j | mFeatures;
        int k = mLocalFeatures;
        int l;
        boolean flag;
        if(mContainer != null)
            l = j & (-1 ^ mContainer.mFeatures);
        else
            l = j;
        mLocalFeatures = l | k;
        if((j & mFeatures) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public abstract void restoreHierarchyState(Bundle bundle);

    public abstract Bundle saveHierarchyState();

    public void setAttributes(WindowManager.LayoutParams layoutparams) {
        mWindowAttributes.copyFrom(layoutparams);
        if(mCallback != null)
            mCallback.onWindowAttributesChanged(mWindowAttributes);
    }

    public abstract void setBackgroundDrawable(Drawable drawable);

    public void setBackgroundDrawableResource(int i) {
        setBackgroundDrawable(mContext.getResources().getDrawable(i));
    }

    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    public abstract void setChildDrawable(int i, Drawable drawable);

    public abstract void setChildInt(int i, int j);

    public void setCloseOnTouchOutside(boolean flag) {
        mCloseOnTouchOutside = flag;
        mSetCloseOnTouchOutside = true;
    }

    public void setCloseOnTouchOutsideIfNotSet(boolean flag) {
        if(!mSetCloseOnTouchOutside) {
            mCloseOnTouchOutside = flag;
            mSetCloseOnTouchOutside = true;
        }
    }

    public void setContainer(Window window) {
        mContainer = window;
        if(window != null) {
            mFeatures = 2 | mFeatures;
            mLocalFeatures = 2 | mLocalFeatures;
            window.mHasChildren = true;
        }
    }

    public abstract void setContentView(int i);

    public abstract void setContentView(View view);

    public abstract void setContentView(View view, ViewGroup.LayoutParams layoutparams);

    protected void setDefaultWindowFormat(int i) {
        mDefaultWindowFormat = i;
        if(!mHaveWindowFormat) {
            WindowManager.LayoutParams layoutparams = getAttributes();
            layoutparams.format = i;
            if(mCallback != null)
                mCallback.onWindowAttributesChanged(layoutparams);
        }
    }

    public void setDimAmount(float f) {
        WindowManager.LayoutParams layoutparams = getAttributes();
        layoutparams.dimAmount = f;
        mHaveDimAmount = true;
        if(mCallback != null)
            mCallback.onWindowAttributesChanged(layoutparams);
    }

    public abstract void setFeatureDrawable(int i, Drawable drawable);

    public abstract void setFeatureDrawableAlpha(int i, int j);

    public abstract void setFeatureDrawableResource(int i, int j);

    public abstract void setFeatureDrawableUri(int i, Uri uri);

    public abstract void setFeatureInt(int i, int j);

    public void setFlags(int i, int j) {
        WindowManager.LayoutParams layoutparams = getAttributes();
        layoutparams.flags = layoutparams.flags & ~j | i & j;
        if((0x8000000 & j) != 0)
            layoutparams.privateFlags = 8 | layoutparams.privateFlags;
        mForcedWindowFlags = j | mForcedWindowFlags;
        if(mCallback != null)
            mCallback.onWindowAttributesChanged(layoutparams);
    }

    public void setFormat(int i) {
        WindowManager.LayoutParams layoutparams = getAttributes();
        if(i != 0) {
            layoutparams.format = i;
            mHaveWindowFormat = true;
        } else {
            layoutparams.format = mDefaultWindowFormat;
            mHaveWindowFormat = false;
        }
        if(mCallback != null)
            mCallback.onWindowAttributesChanged(layoutparams);
    }

    public void setGravity(int i) {
        WindowManager.LayoutParams layoutparams = getAttributes();
        layoutparams.gravity = i;
        if(mCallback != null)
            mCallback.onWindowAttributesChanged(layoutparams);
    }

    public void setLayout(int i, int j) {
        WindowManager.LayoutParams layoutparams = getAttributes();
        layoutparams.width = i;
        layoutparams.height = j;
        if(mCallback != null)
            mCallback.onWindowAttributesChanged(layoutparams);
    }

    public void setSoftInputMode(int i) {
        WindowManager.LayoutParams layoutparams = getAttributes();
        if(i != 0) {
            layoutparams.softInputMode = i;
            mHasSoftInputMode = true;
        } else {
            mHasSoftInputMode = false;
        }
        if(mCallback != null)
            mCallback.onWindowAttributesChanged(layoutparams);
    }

    public abstract void setTitle(CharSequence charsequence);

    public abstract void setTitleColor(int i);

    public void setType(int i) {
        WindowManager.LayoutParams layoutparams = getAttributes();
        layoutparams.type = i;
        if(mCallback != null)
            mCallback.onWindowAttributesChanged(layoutparams);
    }

    public void setUiOptions(int i) {
    }

    public void setUiOptions(int i, int j) {
    }

    public abstract void setVolumeControlStream(int i);

    public void setWindowAnimations(int i) {
        WindowManager.LayoutParams layoutparams = getAttributes();
        layoutparams.windowAnimations = i;
        if(mCallback != null)
            mCallback.onWindowAttributesChanged(layoutparams);
    }

    public void setWindowManager(WindowManager windowmanager, IBinder ibinder, String s) {
        setWindowManager(windowmanager, ibinder, s, false);
    }

    public void setWindowManager(WindowManager windowmanager, IBinder ibinder, String s, boolean flag) {
        mAppToken = ibinder;
        mAppName = s;
        if(windowmanager == null)
            windowmanager = WindowManagerImpl.getDefault();
        mWindowManager = new LocalWindowManager(windowmanager, flag);
    }

    public boolean shouldCloseOnTouch(Context context, MotionEvent motionevent) {
        boolean flag;
        if(mCloseOnTouchOutside && motionevent.getAction() == 0 && isOutOfBounds(context, motionevent) && peekDecorView() != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public abstract boolean superDispatchGenericMotionEvent(MotionEvent motionevent);

    public abstract boolean superDispatchKeyEvent(KeyEvent keyevent);

    public abstract boolean superDispatchKeyShortcutEvent(KeyEvent keyevent);

    public abstract boolean superDispatchTouchEvent(MotionEvent motionevent);

    public abstract boolean superDispatchTrackballEvent(MotionEvent motionevent);

    public abstract void takeInputQueue(InputQueue.Callback callback);

    public abstract void takeKeyEvents(boolean flag);

    public abstract void takeSurface(SurfaceHolder.Callback2 callback2);

    public abstract void togglePanel(int i, KeyEvent keyevent);

    protected static final int DEFAULT_FEATURES = 65;
    public static final int FEATURE_ACTION_BAR = 8;
    public static final int FEATURE_ACTION_BAR_OVERLAY = 9;
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;
    public static final int FEATURE_CONTEXT_MENU = 6;
    public static final int FEATURE_CUSTOM_TITLE = 7;
    public static final int FEATURE_INDETERMINATE_PROGRESS = 5;
    public static final int FEATURE_LEFT_ICON = 3;
    public static final int FEATURE_NO_TITLE = 1;
    public static final int FEATURE_OPTIONS_PANEL = 0;
    public static final int FEATURE_PROGRESS = 2;
    public static final int FEATURE_RIGHT_ICON = 4;
    public static final int ID_ANDROID_CONTENT = 0x1020002;
    public static final int PROGRESS_END = 10000;
    public static final int PROGRESS_INDETERMINATE_OFF = -4;
    public static final int PROGRESS_INDETERMINATE_ON = -3;
    public static final int PROGRESS_SECONDARY_END = 30000;
    public static final int PROGRESS_SECONDARY_START = 20000;
    public static final int PROGRESS_START = 0;
    public static final int PROGRESS_VISIBILITY_OFF = -2;
    public static final int PROGRESS_VISIBILITY_ON = -1;
    private Window mActiveChild;
    private String mAppName;
    private IBinder mAppToken;
    private Callback mCallback;
    private boolean mCloseOnTouchOutside;
    private Window mContainer;
    private final Context mContext;
    private int mDefaultWindowFormat;
    private boolean mDestroyed;
    private int mFeatures;
    private int mForcedWindowFlags;
    private boolean mHasChildren;
    private boolean mHasSoftInputMode;
    private boolean mHaveDimAmount;
    private boolean mHaveWindowFormat;
    private boolean mIsActive;
    private int mLocalFeatures;
    private boolean mSetCloseOnTouchOutside;
    private final WindowManager.LayoutParams mWindowAttributes = new WindowManager.LayoutParams();
    private WindowManager mWindowManager;
    private TypedArray mWindowStyle;




}

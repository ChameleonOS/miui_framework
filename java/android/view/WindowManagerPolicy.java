// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.content.Context;
import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.*;
import android.view.animation.Animation;
import java.io.PrintWriter;

// Referenced classes of package android.view:
//            View, KeyEvent, IWindowManager, Display, 
//            InputChannel, IApplicationToken

public interface WindowManagerPolicy {
    public static interface OnKeyguardExitResult {

        public abstract void onKeyguardExitResult(boolean flag);
    }

    public static interface ScreenOnListener {

        public abstract void onScreenOn();
    }

    public static interface WindowManagerFuncs {

        public abstract FakeWindow addFakeWindow(Looper looper, InputEventReceiver.Factory factory, String s, int i, int j, boolean flag, boolean flag1, 
                boolean flag2);

        public abstract int getLidState();

        public abstract InputChannel monitorInput(String s);

        public abstract void rebootSafeMode();

        public abstract void reevaluateStatusBarVisibility();

        public abstract void shutdown();

        public abstract void switchKeyboardLayout(int i, int j);

        public static final int LID_ABSENT = -1;
        public static final int LID_CLOSED = 0;
        public static final int LID_OPEN = 1;
    }

    public static interface FakeWindow {

        public abstract void dismiss();
    }

    public static interface WindowState {

        public abstract void computeFrameLw(Rect rect, Rect rect1, Rect rect2, Rect rect3);

        public abstract IApplicationToken getAppToken();

        public abstract WindowManager.LayoutParams getAttrs();

        public abstract Rect getContentFrameLw();

        public abstract Rect getDisplayFrameLw();

        public abstract Rect getFrameLw();

        public abstract Rect getGivenContentInsetsLw();

        public abstract boolean getGivenInsetsPendingLw();

        public abstract Rect getGivenVisibleInsetsLw();

        public abstract boolean getNeedsMenuLw(WindowState windowstate);

        public abstract RectF getShownFrameLw();

        public abstract int getSurfaceLayer();

        public abstract int getSystemUiVisibility();

        public abstract Rect getVisibleFrameLw();

        public abstract boolean hasAppShownWindows();

        public abstract boolean hasDrawnLw();

        public abstract boolean hideLw(boolean flag);

        public abstract boolean isAlive();

        public abstract boolean isAnimatingLw();

        public abstract boolean isDisplayedLw();

        public abstract boolean isGoneForLayoutLw();

        public abstract boolean isVisibleLw();

        public abstract boolean isVisibleOrBehindKeyguardLw();

        public abstract boolean showLw(boolean flag);
    }


    public abstract View addStartingWindow(IBinder ibinder, String s, int i, CompatibilityInfo compatibilityinfo, CharSequence charsequence, int j, int k, 
            int l);

    public abstract void adjustConfigurationLw(Configuration configuration, int i, int j);

    public abstract int adjustSystemUiVisibilityLw(int i);

    public abstract void adjustWindowParamsLw(WindowManager.LayoutParams layoutparams);

    public abstract boolean allowAppAnimationsLw();

    public abstract boolean allowKeyRepeat();

    public abstract void animatingWindowLw(WindowState windowstate, WindowManager.LayoutParams layoutparams);

    public abstract void beginAnimationLw(int i, int j);

    public abstract void beginLayoutLw(int i, int j, int k);

    public abstract boolean canBeForceHidden(WindowState windowstate, WindowManager.LayoutParams layoutparams);

    public abstract int checkAddPermission(WindowManager.LayoutParams layoutparams);

    public abstract Animation createForceHideEnterAnimation(boolean flag);

    public abstract void dismissKeyguardLw();

    public abstract KeyEvent dispatchUnhandledKey(WindowState windowstate, KeyEvent keyevent, int i);

    public abstract boolean doesForceHide(WindowState windowstate, WindowManager.LayoutParams layoutparams);

    public abstract void dump(String s, PrintWriter printwriter, String as[]);

    public abstract void enableKeyguard(boolean flag);

    public abstract void enableScreenAfterBoot();

    public abstract void exitKeyguardSecurely(OnKeyguardExitResult onkeyguardexitresult);

    public abstract int finishAnimationLw();

    public abstract void finishLayoutLw();

    public abstract int focusChangedLw(WindowState windowstate, WindowState windowstate1);

    public abstract int getConfigDisplayHeight(int i, int j, int k);

    public abstract int getConfigDisplayWidth(int i, int j, int k);

    public abstract void getContentInsetHintLw(WindowManager.LayoutParams layoutparams, Rect rect);

    public abstract int getMaxWallpaperLayer();

    public abstract int getNonDecorDisplayHeight(int i, int j, int k);

    public abstract int getNonDecorDisplayWidth(int i, int j, int k);

    public abstract int getSystemDecorRectLw(Rect rect);

    public abstract boolean hasNavigationBar();

    public abstract boolean hasSystemNavBar();

    public abstract void hideBootMessages();

    public abstract boolean inKeyguardRestrictedKeyInputMode();

    public abstract void init(Context context, IWindowManager iwindowmanager, WindowManagerFuncs windowmanagerfuncs, LocalPowerManager localpowermanager);

    public abstract long interceptKeyBeforeDispatching(WindowState windowstate, KeyEvent keyevent, int i);

    public abstract int interceptKeyBeforeQueueing(KeyEvent keyevent, int i, boolean flag);

    public abstract int interceptMotionBeforeQueueingWhenScreenOff(int i);

    public abstract boolean isKeyguardLocked();

    public abstract boolean isKeyguardSecure();

    public abstract boolean isScreenOnEarly();

    public abstract boolean isScreenOnFully();

    public abstract boolean isScreenSaverEnabled();

    public abstract void layoutWindowLw(WindowState windowstate, WindowManager.LayoutParams layoutparams, WindowState windowstate1);

    public abstract void lockNow();

    public abstract void notifyLidSwitchChanged(long l, boolean flag);

    public abstract boolean performHapticFeedbackLw(WindowState windowstate, int i, boolean flag);

    public abstract int prepareAddWindowLw(WindowState windowstate, WindowManager.LayoutParams layoutparams);

    public abstract void removeStartingWindow(IBinder ibinder, View view);

    public abstract void removeWindowLw(WindowState windowstate);

    public abstract int rotationForOrientationLw(int i, int j);

    public abstract boolean rotationHasCompatibleMetricsLw(int i, int j);

    public abstract void screenOnStartedLw();

    public abstract void screenOnStoppedLw();

    public abstract void screenTurnedOff(int i);

    public abstract void screenTurningOn(ScreenOnListener screenonlistener);

    public abstract int selectAnimationLw(WindowState windowstate, int i);

    public abstract void setCurrentOrientationLw(int i);

    public abstract void setInitialDisplaySize(Display display, int i, int j);

    public abstract void setLastInputMethodWindowLw(WindowState windowstate, WindowState windowstate1);

    public abstract void setRotationLw(int i);

    public abstract void setSafeMode(boolean flag);

    public abstract void setUserRotationMode(int i, int j);

    public abstract void showBootMessage(CharSequence charsequence, boolean flag);

    public abstract boolean startScreenSaver();

    public abstract void stopScreenSaver();

    public abstract int subWindowTypeToLayerLw(int i);

    public abstract void systemBooted();

    public abstract void systemReady();

    public abstract void userActivity();

    public abstract int windowTypeToLayerLw(int i);

    public static final int ACTION_GO_TO_SLEEP = 4;
    public static final String ACTION_HDMI_PLUGGED = "android.intent.action.HDMI_PLUGGED";
    public static final int ACTION_PASS_TO_USER = 1;
    public static final int ACTION_POKE_USER_ACTIVITY = 2;
    public static final String EXTRA_HDMI_PLUGGED_STATE = "state";
    public static final int FINISH_LAYOUT_REDO_ANIM = 8;
    public static final int FINISH_LAYOUT_REDO_CONFIG = 2;
    public static final int FINISH_LAYOUT_REDO_LAYOUT = 1;
    public static final int FINISH_LAYOUT_REDO_WALLPAPER = 4;
    public static final int FLAG_ALT = 16;
    public static final int FLAG_ALT_GR = 32;
    public static final int FLAG_BRIGHT_HERE = 0x20000000;
    public static final int FLAG_CAPS_LOCK = 8;
    public static final int FLAG_DISABLE_KEY_REPEAT = 0x8000000;
    public static final int FLAG_FILTERED = 0x4000000;
    public static final int FLAG_INJECTED = 0x1000000;
    public static final int FLAG_LAUNCHER = 128;
    public static final int FLAG_MENU = 64;
    public static final int FLAG_PASS_TO_USER = 0x40000000;
    public static final int FLAG_SHIFT = 4;
    public static final int FLAG_TRUSTED = 0x2000000;
    public static final int FLAG_VIRTUAL = 256;
    public static final int FLAG_WAKE = 1;
    public static final int FLAG_WAKE_DROPPED = 2;
    public static final int FLAG_WOKE_HERE = 0x10000000;
    public static final int OFF_BECAUSE_OF_ADMIN = 1;
    public static final int OFF_BECAUSE_OF_PROX_SENSOR = 4;
    public static final int OFF_BECAUSE_OF_TIMEOUT = 3;
    public static final int OFF_BECAUSE_OF_USER = 2;
    public static final int PRESENCE_EXTERNAL = 2;
    public static final int PRESENCE_INTERNAL = 1;
    public static final int TRANSIT_ACTIVITY_CLOSE = 8199;
    public static final int TRANSIT_ACTIVITY_OPEN = 4102;
    public static final int TRANSIT_ENTER = 4097;
    public static final int TRANSIT_ENTER_MASK = 4096;
    public static final int TRANSIT_EXIT = 8194;
    public static final int TRANSIT_EXIT_MASK = 8192;
    public static final int TRANSIT_HIDE = 8196;
    public static final int TRANSIT_NONE = 0;
    public static final int TRANSIT_PREVIEW_DONE = 5;
    public static final int TRANSIT_SHOW = 4099;
    public static final int TRANSIT_TASK_CLOSE = 8201;
    public static final int TRANSIT_TASK_OPEN = 4104;
    public static final int TRANSIT_TASK_TO_BACK = 8203;
    public static final int TRANSIT_TASK_TO_FRONT = 4106;
    public static final int TRANSIT_UNSET = -1;
    public static final int TRANSIT_WALLPAPER_CLOSE = 8204;
    public static final int TRANSIT_WALLPAPER_INTRA_CLOSE = 8207;
    public static final int TRANSIT_WALLPAPER_INTRA_OPEN = 4110;
    public static final int TRANSIT_WALLPAPER_OPEN = 4109;
    public static final int USER_ROTATION_FREE = 0;
    public static final int USER_ROTATION_LOCKED = 1;
    public static final boolean WATCH_POINTER;
}

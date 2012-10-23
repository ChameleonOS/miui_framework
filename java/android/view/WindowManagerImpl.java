// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.app.ActivityManager;
import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.opengl.ManagedEGLContext;
import android.os.IBinder;
import android.os.SystemProperties;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import java.io.*;
import java.util.HashMap;

// Referenced classes of package android.view:
//            WindowManager, ViewRootImpl, View, CompatibilityInfoHolder, 
//            WindowLeaked, HardwareRenderer, Display, ViewParent

public class WindowManagerImpl
    implements WindowManager {
    static class CompatModeWrapper
        implements WindowManager {

        public void addView(View view, ViewGroup.LayoutParams layoutparams) {
            mWindowManager.addView(view, layoutparams, mCompatibilityInfo);
        }

        public Display getDefaultDisplay() {
            return mDefaultDisplay;
        }

        public boolean isHardwareAccelerated() {
            return mWindowManager.isHardwareAccelerated();
        }

        public void removeView(View view) {
            mWindowManager.removeView(view);
        }

        public void removeViewImmediate(View view) {
            mWindowManager.removeViewImmediate(view);
        }

        public void updateViewLayout(View view, ViewGroup.LayoutParams layoutparams) {
            mWindowManager.updateViewLayout(view, layoutparams);
        }

        private final CompatibilityInfoHolder mCompatibilityInfo;
        private final Display mDefaultDisplay;
        private final WindowManagerImpl mWindowManager;

        CompatModeWrapper(WindowManager windowmanager, CompatibilityInfoHolder compatibilityinfoholder) {
            WindowManagerImpl windowmanagerimpl;
            if(windowmanager instanceof CompatModeWrapper)
                windowmanagerimpl = ((CompatModeWrapper)windowmanager).mWindowManager;
            else
                windowmanagerimpl = (WindowManagerImpl)windowmanager;
            mWindowManager = windowmanagerimpl;
            if(compatibilityinfoholder == null)
                mDefaultDisplay = mWindowManager.getDefaultDisplay();
            else
                mDefaultDisplay = Display.createCompatibleDisplay(mWindowManager.getDefaultDisplay().getDisplayId(), compatibilityinfoholder);
            mCompatibilityInfo = compatibilityinfoholder;
        }
    }


    public WindowManagerImpl() {
        mSystemPropertyUpdater = null;
    }

    private void addView(View view, ViewGroup.LayoutParams layoutparams, CompatibilityInfoHolder compatibilityinfoholder, boolean flag) {
        int i;
        WindowManager.LayoutParams layoutparams1;
        i = 0;
        if(!(layoutparams instanceof WindowManager.LayoutParams))
            throw new IllegalArgumentException("Params must be WindowManager.LayoutParams");
        layoutparams1 = (WindowManager.LayoutParams)layoutparams;
        View view1 = null;
        this;
        JVM INSTR monitorenter ;
        int j;
        if(mSystemPropertyUpdater == null) {
            mSystemPropertyUpdater = new Runnable() {

                public void run() {
                    this;
                    JVM INSTR monitorenter ;
                    this;
                    JVM INSTR monitorenter ;
                    ViewRootImpl aviewrootimpl1[] = mRoots;
                    int j1 = aviewrootimpl1.length;
                    for(int k1 = 0; k1 < j1; k1++)
                        aviewrootimpl1[k1].loadSystemProperties();

                    this;
                    JVM INSTR monitorexit ;
                    this;
                    JVM INSTR monitorexit ;
                    return;
                    Exception exception2;
                    exception2;
                    this;
                    JVM INSTR monitorexit ;
                    throw exception2;
                    Exception exception1;
                    exception1;
                    throw exception1;
                }

                final WindowManagerImpl this$0;

             {
                this$0 = WindowManagerImpl.this;
                super();
            }
            };
            SystemProperties.addChangeCallback(mSystemPropertyUpdater);
        }
        j = findViewLocked(view, false);
        if(j >= 0) {
            if(!flag)
                throw new IllegalStateException((new StringBuilder()).append("View ").append(view).append(" has already been added to the window manager.").toString());
            break MISSING_BLOCK_LABEL_114;
        }
          goto _L1
        Exception exception;
        exception;
        throw exception;
        ViewRootImpl viewrootimpl1 = mRoots[j];
        viewrootimpl1.mAddNesting = 1 + viewrootimpl1.mAddNesting;
        view.setLayoutParams(layoutparams1);
        viewrootimpl1.setLayoutParams(layoutparams1, true);
        this;
        JVM INSTR monitorexit ;
          goto _L2
_L1:
        if(layoutparams1.type < 1000 || layoutparams1.type > 1999) goto _L4; else goto _L3
_L3:
        if(mViews != null)
            i = mViews.length;
_L10:
        i1 = 0;
        ViewRootImpl viewrootimpl;
        int k;
        View aview[];
        ViewRootImpl aviewrootimpl[];
        WindowManager.LayoutParams alayoutparams[];
        int l;
        int i1;
        for(; i1 < i; i1++) {
            if(mRoots[i1].mWindow.asBinder() == layoutparams1.token)
                view1 = mViews[i1];
            break MISSING_BLOCK_LABEL_473;
        }

_L4:
        viewrootimpl = new ViewRootImpl(view.getContext());
        viewrootimpl.mAddNesting = 1;
        if(compatibilityinfoholder != null) goto _L6; else goto _L5
_L5:
        viewrootimpl.mCompatibilityInfo = new CompatibilityInfoHolder();
_L11:
        view.setLayoutParams(layoutparams1);
        if(mViews != null) goto _L8; else goto _L7
_L7:
        k = 1;
        mViews = new View[1];
        mRoots = new ViewRootImpl[1];
        mParams = new WindowManager.LayoutParams[1];
_L9:
        l = k - 1;
        mViews[l] = view;
        mRoots[l] = viewrootimpl;
        mParams[l] = layoutparams1;
        this;
        JVM INSTR monitorexit ;
        viewrootimpl.setView(view, layoutparams1, view1);
          goto _L2
_L6:
        viewrootimpl.mCompatibilityInfo = compatibilityinfoholder;
        continue; /* Loop/switch isn't completed */
_L8:
        k = 1 + mViews.length;
        aview = mViews;
        mViews = new View[k];
        System.arraycopy(aview, 0, mViews, 0, k - 1);
        aviewrootimpl = mRoots;
        mRoots = new ViewRootImpl[k];
        System.arraycopy(aviewrootimpl, 0, mRoots, 0, k - 1);
        alayoutparams = mParams;
        mParams = new WindowManager.LayoutParams[k];
        System.arraycopy(alayoutparams, 0, mParams, 0, k - 1);
          goto _L9
_L2:
        return;
        if(true) goto _L11; else goto _L10
    }

    private int findViewLocked(View view, boolean flag) {
        this;
        JVM INSTR monitorenter ;
          goto _L1
_L4:
        int j;
        if(j < i) {
            if(mViews[j] != view)
                break MISSING_BLOCK_LABEL_85;
        } else {
            if(flag)
                throw new IllegalArgumentException("View not attached to window manager");
            break MISSING_BLOCK_LABEL_61;
        }
          goto _L2
        exception;
        throw exception;
        j = -1;
        this;
        JVM INSTR monitorexit ;
          goto _L2
_L1:
        Exception exception;
        int i;
        if(mViews != null)
            i = mViews.length;
        else
            i = 0;
        j = 0;
        continue; /* Loop/switch isn't completed */
_L2:
        return j;
        j++;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static WindowManager getDefault(CompatibilityInfo compatibilityinfo) {
        CompatibilityInfoHolder compatibilityinfoholder;
        compatibilityinfoholder = new CompatibilityInfoHolder();
        compatibilityinfoholder.set(compatibilityinfo);
        if(compatibilityinfoholder.getIfNeeded() != null) goto _L2; else goto _L1
_L1:
        Object obj1 = sWindowManager;
_L4:
        return ((WindowManager) (obj1));
_L2:
        Object obj = sLock;
        obj;
        JVM INSTR monitorenter ;
        obj1 = (WindowManager)sCompatWindowManagers.get(compatibilityinfo);
        if(obj1 == null) {
            obj1 = new CompatModeWrapper(sWindowManager, compatibilityinfoholder);
            sCompatWindowManagers.put(compatibilityinfo, obj1);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static WindowManager getDefault(CompatibilityInfoHolder compatibilityinfoholder) {
        return new CompatModeWrapper(sWindowManager, compatibilityinfoholder);
    }

    public static WindowManagerImpl getDefault() {
        return sWindowManager;
    }

    private static String getWindowName(ViewRootImpl viewrootimpl) {
        return (new StringBuilder()).append(viewrootimpl.mWindowAttributes.getTitle()).append("/").append(viewrootimpl.getClass().getName()).append('@').append(Integer.toHexString(viewrootimpl.hashCode())).toString();
    }

    private static void removeItem(Object aobj[], Object aobj1[], int i) {
        if(aobj.length > 0) {
            if(i > 0)
                System.arraycopy(((Object) (aobj1)), 0, ((Object) (aobj)), 0, i);
            if(i < aobj.length)
                System.arraycopy(((Object) (aobj1)), i + 1, ((Object) (aobj)), i, -1 + (aobj1.length - i));
        }
    }

    public void addView(View view) {
        addView(view, ((ViewGroup.LayoutParams) (new WindowManager.LayoutParams(2, 0, -1))));
    }

    public void addView(View view, ViewGroup.LayoutParams layoutparams) {
        addView(view, layoutparams, null, false);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutparams, CompatibilityInfoHolder compatibilityinfoholder) {
        addView(view, layoutparams, compatibilityinfoholder, false);
    }

    public void closeAll() {
        closeAll(null, null, null);
    }

    public void closeAll(IBinder ibinder, String s, String s1) {
        this;
        JVM INSTR monitorenter ;
        if(mViews != null) goto _L2; else goto _L1
_L2:
        int i;
        int j;
        i = mViews.length;
        j = 0;
_L4:
        if(j < i) {
            if(ibinder == null || mParams[j].token == ibinder) {
                ViewRootImpl viewrootimpl = mRoots[j];
                viewrootimpl.mAddNesting = 1;
                if(s != null) {
                    WindowLeaked windowleaked = new WindowLeaked((new StringBuilder()).append(s1).append(" ").append(s).append(" has leaked window ").append(viewrootimpl.getView()).append(" that was originally added here").toString());
                    windowleaked.setStackTrace(viewrootimpl.getLocation().getStackTrace());
                    Log.e("WindowManager", windowleaked.getMessage(), windowleaked);
                }
                removeViewLocked(j);
                j--;
                i--;
            }
            j++;
            continue; /* Loop/switch isn't completed */
        }
_L1:
        return;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void dumpGfxInfo(FileDescriptor filedescriptor) {
        PrintWriter printwriter = new PrintWriter(new FileOutputStream(filedescriptor));
        this;
        JVM INSTR monitorenter ;
        int i;
        if(mViews == null)
            break MISSING_BLOCK_LABEL_376;
        i = mViews.length;
        printwriter.println("Profile data in ms:");
        Exception exception;
        Exception exception1;
        int k;
        int l;
        int ai[];
        int i1;
        Object aobj[];
        Object aobj1[];
        Object aobj2[];
        ViewRootImpl viewrootimpl;
        String s;
        Object aobj3[];
        HardwareRenderer hardwarerenderer;
        Object aobj4[];
        for(int j = 0; j < i; j++) {
            ViewRootImpl viewrootimpl1 = mRoots[j];
            String s1 = getWindowName(viewrootimpl1);
            Object aobj5[] = new Object[1];
            aobj5[0] = s1;
            printwriter.printf("\n\t%s", aobj5);
            HardwareRenderer hardwarerenderer1 = viewrootimpl1.getView().mAttachInfo.mHardwareRenderer;
            if(hardwarerenderer1 != null)
                hardwarerenderer1.dumpGfxInfo(printwriter);
            break MISSING_BLOCK_LABEL_397;
        }

        printwriter.println("\nView hierarchy:\n");
        k = 0;
        l = 0;
        ai = new int[2];
        for(i1 = 0; i1 < i; i1++) {
            viewrootimpl = mRoots[i1];
            viewrootimpl.dumpGfxInfo(ai);
            s = getWindowName(viewrootimpl);
            aobj3 = new Object[3];
            aobj3[0] = s;
            aobj3[1] = Integer.valueOf(ai[0]);
            aobj3[2] = Float.valueOf((float)ai[1] / 1024F);
            printwriter.printf("  %s\n  %d views, %.2f kB of display lists", aobj3);
            hardwarerenderer = viewrootimpl.getView().mAttachInfo.mHardwareRenderer;
            if(hardwarerenderer != null) {
                aobj4 = new Object[1];
                aobj4[0] = Long.valueOf(hardwarerenderer.getFrameCount());
                printwriter.printf(", %d frames rendered", aobj4);
            }
            printwriter.printf("\n\n", new Object[0]);
            k += ai[0];
            l += ai[1];
        }

        aobj = new Object[1];
        aobj[0] = Integer.valueOf(i);
        printwriter.printf("\nTotal ViewRootImpl: %d\n", aobj);
        aobj1 = new Object[1];
        aobj1[0] = Integer.valueOf(k);
        printwriter.printf("Total Views:        %d\n", aobj1);
        aobj2 = new Object[1];
        aobj2[0] = Float.valueOf((float)l / 1024F);
        printwriter.printf("Total DisplayList:  %.2f kB\n\n", aobj2);
        this;
        JVM INSTR monitorexit ;
        printwriter.flush();
        return;
        exception1;
        this;
        JVM INSTR monitorexit ;
        throw exception1;
        exception;
        printwriter.flush();
        throw exception;
    }

    public void endTrimMemory() {
        HardwareRenderer.endTrimMemory();
        if(mNeedsEglTerminate) {
            ManagedEGLContext.doTerminate();
            mNeedsEglTerminate = false;
        }
    }

    void finishRemoveViewLocked(View view, int i) {
        int j = mViews.length;
        View aview[] = new View[j - 1];
        removeItem(aview, mViews, i);
        mViews = aview;
        ViewRootImpl aviewrootimpl[] = new ViewRootImpl[j - 1];
        removeItem(aviewrootimpl, mRoots, i);
        mRoots = aviewrootimpl;
        WindowManager.LayoutParams alayoutparams[] = new WindowManager.LayoutParams[j - 1];
        removeItem(alayoutparams, mParams, i);
        mParams = alayoutparams;
        if(view != null)
            view.assignParent(null);
    }

    public Display getDefaultDisplay() {
        return new Display(0, null);
    }

    public WindowManager.LayoutParams getRootViewLayoutParameter(View view) {
        WindowManager.LayoutParams layoutparams;
        ViewParent viewparent;
        layoutparams = null;
        for(viewparent = view.getParent(); viewparent != null && !(viewparent instanceof ViewRootImpl); viewparent = viewparent.getParent());
        if(viewparent != null) goto _L2; else goto _L1
_L1:
        return layoutparams;
_L2:
        ViewRootImpl viewrootimpl = (ViewRootImpl)viewparent;
        int i = mRoots.length;
        int j = 0;
        do {
            if(j < i) {
label0:
                {
                    if(mRoots[j] != viewrootimpl)
                        break label0;
                    layoutparams = mParams[j];
                }
            }
            if(true)
                continue;
            j++;
        } while(true);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean isHardwareAccelerated() {
        return false;
    }

    public void removeView(View view) {
        this;
        JVM INSTR monitorenter ;
        View view1 = removeViewLocked(findViewLocked(view, true));
        if(view1 == view)
            return;
        else
            throw new IllegalStateException((new StringBuilder()).append("Calling with view ").append(view).append(" but the ViewAncestor is attached to ").append(view1).toString());
    }

    public void removeViewImmediate(View view) {
        this;
        JVM INSTR monitorenter ;
        int i = findViewLocked(view, true);
        ViewRootImpl viewrootimpl = mRoots[i];
        View view1 = viewrootimpl.getView();
        viewrootimpl.mAddNesting = 0;
        if(view != null) {
            InputMethodManager inputmethodmanager = InputMethodManager.getInstance(view.getContext());
            if(inputmethodmanager != null)
                inputmethodmanager.windowDismissed(mViews[i].getWindowToken());
        }
        viewrootimpl.die(true);
        finishRemoveViewLocked(view1, i);
        if(view1 == view)
            return;
        else
            throw new IllegalStateException((new StringBuilder()).append("Calling with view ").append(view).append(" but the ViewAncestor is attached to ").append(view1).toString());
    }

    View removeViewLocked(int i) {
        ViewRootImpl viewrootimpl = mRoots[i];
        View view = viewrootimpl.getView();
        viewrootimpl.mAddNesting = -1 + viewrootimpl.mAddNesting;
        if(viewrootimpl.mAddNesting <= 0) {
            if(view != null) {
                InputMethodManager inputmethodmanager = InputMethodManager.getInstance(view.getContext());
                if(inputmethodmanager != null)
                    inputmethodmanager.windowDismissed(mViews[i].getWindowToken());
            }
            viewrootimpl.die(false);
            finishRemoveViewLocked(view, i);
        }
        return view;
    }

    public void reportNewConfiguration(Configuration configuration) {
        this;
        JVM INSTR monitorenter ;
        int i;
        Configuration configuration1;
        i = mViews.length;
        configuration1 = new Configuration(configuration);
        int j = 0;
_L1:
        if(j >= i)
            break MISSING_BLOCK_LABEL_46;
        mRoots[j].requestUpdateConfiguration(configuration1);
        j++;
          goto _L1
        return;
        Exception exception;
        exception;
_L3:
        this;
        JVM INSTR monitorexit ;
        throw exception;
        exception;
        if(true) goto _L3; else goto _L2
_L2:
    }

    public void setStoppedState(IBinder ibinder, boolean flag) {
        this;
        JVM INSTR monitorenter ;
        if(mViews != null) goto _L2; else goto _L1
_L2:
        int i;
        int j;
        i = mViews.length;
        j = 0;
_L4:
        if(j < i) {
            if(ibinder == null || mParams[j].token == ibinder)
                mRoots[j].setStopped(flag);
            j++;
            continue; /* Loop/switch isn't completed */
        }
_L1:
        return;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void startTrimMemory(int i) {
        if(!HardwareRenderer.isAvailable())
            break MISSING_BLOCK_LABEL_97;
        if(i < 80 && (i < 60 || ActivityManager.isHighEndGfx(getDefaultDisplay())))
            break MISSING_BLOCK_LABEL_93;
        this;
        JVM INSTR monitorenter ;
        if(mViews != null)
            break MISSING_BLOCK_LABEL_42;
        this;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_97;
        int j = mViews.length;
        for(int k = 0; k < j; k++)
            mRoots[k].terminateHardwareResources();

        this;
        JVM INSTR monitorexit ;
        mNeedsEglTerminate = true;
        HardwareRenderer.startTrimMemory(80);
        break MISSING_BLOCK_LABEL_97;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        HardwareRenderer.startTrimMemory(i);
    }

    public void trimLocalMemory() {
        this;
        JVM INSTR monitorenter ;
        if(mViews != null) {
            int i = mViews.length;
            for(int j = 0; j < i; j++)
                mRoots[j].destroyHardwareLayers();

        }
        return;
    }

    public void updateViewLayout(View view, ViewGroup.LayoutParams layoutparams) {
        WindowManager.LayoutParams layoutparams1;
        if(!(layoutparams instanceof WindowManager.LayoutParams))
            throw new IllegalArgumentException("Params must be WindowManager.LayoutParams");
        layoutparams1 = (WindowManager.LayoutParams)layoutparams;
        view.setLayoutParams(layoutparams1);
        this;
        JVM INSTR monitorenter ;
        int i = findViewLocked(view, true);
        ViewRootImpl viewrootimpl = mRoots[i];
        mParams[i] = layoutparams1;
        viewrootimpl.setLayoutParams(layoutparams1, false);
        return;
    }

    public static final int ADD_APP_EXITING = -4;
    public static final int ADD_BAD_APP_TOKEN = -1;
    public static final int ADD_BAD_SUBWINDOW_TOKEN = -2;
    public static final int ADD_DUPLICATE_ADD = -5;
    public static final int ADD_FLAG_APP_VISIBLE = 2;
    public static final int ADD_FLAG_IN_TOUCH_MODE = 1;
    public static final int ADD_MULTIPLE_SINGLETON = -7;
    public static final int ADD_NOT_APP_TOKEN = -3;
    public static final int ADD_OKAY = 0;
    public static final int ADD_PERMISSION_DENIED = -8;
    public static final int ADD_STARTING_NOT_NEEDED = -6;
    public static final int RELAYOUT_DEFER_SURFACE_DESTROY = 2;
    public static final int RELAYOUT_INSETS_PENDING = 1;
    public static final int RELAYOUT_RES_ANIMATING = 8;
    public static final int RELAYOUT_RES_FIRST_TIME = 2;
    public static final int RELAYOUT_RES_IN_TOUCH_MODE = 1;
    public static final int RELAYOUT_RES_SURFACE_CHANGED = 4;
    private static final HashMap sCompatWindowManagers = new HashMap();
    private static final Object sLock = new Object();
    private static final WindowManagerImpl sWindowManager = new WindowManagerImpl();
    private boolean mNeedsEglTerminate;
    private WindowManager.LayoutParams mParams[];
    private ViewRootImpl mRoots[];
    private Runnable mSystemPropertyUpdater;
    private View mViews[];


}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.*;
import android.content.pm.*;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.method.TextKeyListener;
import android.util.*;
import android.view.*;
import android.view.accessibility.AccessibilityEvent;
import com.android.internal.app.ActionBarImpl;
import com.android.internal.policy.PolicyManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.*;
import miui.net.FirewallManager;
import miui.util.UiUtils;

// Referenced classes of package android.app:
//            FragmentManagerImpl, Dialog, SearchManager, ActivityManagerNative, 
//            ActivityThread, IActivityManager, Instrumentation, PendingIntent, 
//            Fragment, LoaderManagerImpl, Application, TaskStackBuilder, 
//            SuperNotCalledException, ActionBar, FragmentManager, LoaderManager

public class Activity extends ContextThemeWrapper
    implements android.view.LayoutInflater.Factory2, android.view.Window.Callback, android.view.KeyEvent.Callback, android.view.View.OnCreateContextMenuListener, ComponentCallbacks2 {
    private static final class ManagedCursor {

        private final Cursor mCursor;
        private boolean mReleased;
        private boolean mUpdated;




/*
        static boolean access$302(ManagedCursor managedcursor, boolean flag) {
            managedcursor.mReleased = flag;
            return flag;
        }

*/



/*
        static boolean access$402(ManagedCursor managedcursor, boolean flag) {
            managedcursor.mUpdated = flag;
            return flag;
        }

*/

        ManagedCursor(Cursor cursor) {
            mCursor = cursor;
            mReleased = false;
            mUpdated = false;
        }
    }

    static final class NonConfigurationInstances {

        Object activity;
        HashMap children;
        ArrayList fragments;
        SparseArray loaders;

        NonConfigurationInstances() {
        }
    }

    private static class ManagedDialog {

        Bundle mArgs;
        Dialog mDialog;

        private ManagedDialog() {
        }

    }

    static class Injector {

        static void checkAccessControl(Activity activity) {
            FirewallManager.checkAccessControl(activity.mParent, activity.getContentResolver(), activity.getPackageName(), activity.getPackageManager(), activity.mMainThread.getApplicationThread(), activity.getToken(), activity.mEmbeddedID);
        }

        static void setActivityGravity(Activity activity) {
            if(UiUtils.resolveAttribute(activity, 0x10100ae) == 0x60d008f)
                activity.mWindow.setGravity(80);
        }

        Injector() {
        }
    }


    public Activity() {
        mTemporaryPause = false;
        mChangingConfigurations = false;
        mDecor = null;
        mWindowAdded = false;
        mVisibleFromServer = false;
        mVisibleFromClient = true;
        mActionBar = null;
        mTitleColor = 0;
        mResultCode = 0;
        mResultData = null;
        mTitleReady = false;
        mDefaultKeyMode = 0;
        mDefaultKeySsb = null;
    }

    private Dialog createDialog(Integer integer, Bundle bundle, Bundle bundle1) {
        Dialog dialog = onCreateDialog(integer.intValue(), bundle1);
        if(dialog == null)
            dialog = null;
        else
            dialog.dispatchOnCreate(bundle);
        return dialog;
    }

    private void ensureSearchManager() {
        if(mSearchManager == null)
            mSearchManager = new SearchManager(this, null);
    }

    private void initActionBar() {
        Window window = getWindow();
        window.getDecorView();
        if(!isChild() && window.hasFeature(8) && mActionBar == null) {
            mActionBar = new ActionBarImpl(this);
            mActionBar.setDefaultDisplayHomeAsUpEnabled(mEnableDefaultActionBarUp);
        }
    }

    private IllegalArgumentException missingDialog(int i) {
        return new IllegalArgumentException((new StringBuilder()).append("no dialog with id ").append(i).append(" was ever ").append("shown via Activity#showDialog").toString());
    }

    private void restoreManagedDialogs(Bundle bundle) {
        Bundle bundle1 = bundle.getBundle("android:savedDialogs");
        if(bundle1 != null) {
            int ai[] = bundle1.getIntArray("android:savedDialogIds");
            int i = ai.length;
            mManagedDialogs = new SparseArray(i);
            int j = 0;
            while(j < i)  {
                Integer integer = Integer.valueOf(ai[j]);
                Bundle bundle2 = bundle1.getBundle(savedDialogKeyFor(integer.intValue()));
                if(bundle2 != null) {
                    ManagedDialog manageddialog = new ManagedDialog();
                    manageddialog.mArgs = bundle1.getBundle(savedDialogArgsKeyFor(integer.intValue()));
                    manageddialog.mDialog = createDialog(integer, bundle2, manageddialog.mArgs);
                    if(manageddialog.mDialog != null) {
                        mManagedDialogs.put(integer.intValue(), manageddialog);
                        onPrepareDialog(integer.intValue(), manageddialog.mDialog, manageddialog.mArgs);
                        manageddialog.mDialog.onRestoreInstanceState(bundle2);
                    }
                }
                j++;
            }
        }
    }

    private void saveManagedDialogs(Bundle bundle) {
        if(mManagedDialogs != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i = mManagedDialogs.size();
        if(i != 0) {
            Bundle bundle1 = new Bundle();
            int ai[] = new int[mManagedDialogs.size()];
            for(int j = 0; j < i; j++) {
                int k = mManagedDialogs.keyAt(j);
                ai[j] = k;
                ManagedDialog manageddialog = (ManagedDialog)mManagedDialogs.valueAt(j);
                bundle1.putBundle(savedDialogKeyFor(k), manageddialog.mDialog.onSaveInstanceState());
                if(manageddialog.mArgs != null)
                    bundle1.putBundle(savedDialogArgsKeyFor(k), manageddialog.mArgs);
            }

            bundle1.putIntArray("android:savedDialogIds", ai);
            bundle.putBundle("android:savedDialogs", bundle1);
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private static String savedDialogArgsKeyFor(int i) {
        return (new StringBuilder()).append("android:dialog_args_").append(i).toString();
    }

    private static String savedDialogKeyFor(int i) {
        return (new StringBuilder()).append("android:dialog_").append(i).toString();
    }

    private void startIntentSenderForResultInner(IntentSender intentsender, int i, Intent intent, int j, int k, Activity activity, Bundle bundle) throws android.content.IntentSender.SendIntentException {
        String s;
        s = null;
        if(intent == null)
            break MISSING_BLOCK_LABEL_22;
        intent.setAllowFds(false);
        s = intent.resolveTypeIfNeeded(getContentResolver());
        RemoteException remoteexception;
        int l;
        l = ActivityManagerNative.getDefault().startActivityIntentSender(mMainThread.getApplicationThread(), intentsender, intent, s, mToken, activity.mEmbeddedID, i, j, k, bundle);
        if(l == -6)
            throw new android.content.IntentSender.SendIntentException();
          goto _L1
_L3:
        if(i >= 0)
            mStartedActivity = true;
        return;
_L1:
        try {
            Instrumentation.checkStartActivityResult(l, null);
        }
        // Misplaced declaration of an exception variable
        catch(RemoteException remoteexception) { }
        if(true) goto _L3; else goto _L2
_L2:
    }

    public void addContentView(View view, android.view.ViewGroup.LayoutParams layoutparams) {
        getWindow().addContentView(view, layoutparams);
        initActionBar();
    }

    final void attach(Context context, ActivityThread activitythread, Instrumentation instrumentation, IBinder ibinder, int i, Application application, Intent intent, 
            ActivityInfo activityinfo, CharSequence charsequence, Activity activity, String s, NonConfigurationInstances nonconfigurationinstances, Configuration configuration) {
        attachBaseContext(context);
        mFragments.attachActivity(this);
        mWindow = PolicyManager.makeNewWindow(this);
        mWindow.setCallback(this);
        mWindow.getLayoutInflater().setPrivateFactory(this);
        if(activityinfo.softInputMode != 0)
            mWindow.setSoftInputMode(activityinfo.softInputMode);
        if(activityinfo.uiOptions != 0)
            mWindow.setUiOptions(activityinfo.uiOptions);
        mUiThread = Thread.currentThread();
        mMainThread = activitythread;
        mInstrumentation = instrumentation;
        mToken = ibinder;
        mIdent = i;
        mApplication = application;
        mIntent = intent;
        mComponent = intent.getComponent();
        mActivityInfo = activityinfo;
        mTitle = charsequence;
        mParent = activity;
        mEmbeddedID = s;
        mLastNonConfigurationInstances = nonconfigurationinstances;
        Window window = mWindow;
        IBinder ibinder1 = mToken;
        String s1 = mComponent.flattenToString();
        boolean flag;
        if((0x200 & activityinfo.flags) != 0)
            flag = true;
        else
            flag = false;
        window.setWindowManager(null, ibinder1, s1, flag);
        if(mParent != null)
            mWindow.setContainer(mParent.getWindow());
        mWindowManager = mWindow.getWindowManager();
        mCurrentConfig = configuration;
    }

    final void attach(Context context, ActivityThread activitythread, Instrumentation instrumentation, IBinder ibinder, Application application, Intent intent, ActivityInfo activityinfo, 
            CharSequence charsequence, Activity activity, String s, NonConfigurationInstances nonconfigurationinstances, Configuration configuration) {
        attach(context, activitythread, instrumentation, ibinder, 0, application, intent, activityinfo, charsequence, activity, s, nonconfigurationinstances, configuration);
    }

    public void closeContextMenu() {
        mWindow.closePanel(6);
    }

    public void closeOptionsMenu() {
        mWindow.closePanel(0);
    }

    public PendingIntent createPendingResult(int i, Intent intent, int j) {
        String s = getPackageName();
        PendingIntent pendingintent;
        intent.setAllowFds(false);
        IActivityManager iactivitymanager = ActivityManagerNative.getDefault();
        IBinder ibinder;
        String s1;
        Intent aintent[];
        android.content.IIntentSender iintentsender;
        if(mParent == null)
            ibinder = mToken;
        else
            ibinder = mParent.mToken;
        s1 = mEmbeddedID;
        aintent = new Intent[1];
        aintent[0] = intent;
        iintentsender = iactivitymanager.getIntentSender(3, s, ibinder, s1, i, aintent, null, j, null);
        if(iintentsender != null) {
            pendingintent = new PendingIntent(iintentsender);
            break MISSING_BLOCK_LABEL_110;
        }
        pendingintent = null;
        break MISSING_BLOCK_LABEL_110;
        RemoteException remoteexception;
        remoteexception;
        pendingintent = null;
        return pendingintent;
    }

    public final void dismissDialog(int i) {
        if(mManagedDialogs == null)
            throw missingDialog(i);
        ManagedDialog manageddialog = (ManagedDialog)mManagedDialogs.get(i);
        if(manageddialog == null) {
            throw missingDialog(i);
        } else {
            manageddialog.mDialog.dismiss();
            return;
        }
    }

    void dispatchActivityResult(String s, int i, int j, Intent intent) {
        mFragments.noteStateNotSaved();
        if(s != null) goto _L2; else goto _L1
_L1:
        onActivityResult(i, j, intent);
_L4:
        return;
_L2:
        Fragment fragment = mFragments.findFragmentByWho(s);
        if(fragment != null)
            fragment.onActivityResult(i, j, intent);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionevent) {
        onUserInteraction();
        boolean flag;
        if(getWindow().superDispatchGenericMotionEvent(motionevent))
            flag = true;
        else
            flag = onGenericMotionEvent(motionevent);
        return flag;
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent) {
        onUserInteraction();
        Window window = getWindow();
        boolean flag;
        if(window.superDispatchKeyEvent(keyevent)) {
            flag = true;
        } else {
            View view = mDecor;
            if(view == null)
                view = window.getDecorView();
            android.view.KeyEvent.DispatcherState dispatcherstate;
            if(view != null)
                dispatcherstate = view.getKeyDispatcherState();
            else
                dispatcherstate = null;
            flag = keyevent.dispatch(this, dispatcherstate, this);
        }
        return flag;
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyevent) {
        onUserInteraction();
        boolean flag;
        if(getWindow().superDispatchKeyShortcutEvent(keyevent))
            flag = true;
        else
            flag = onKeyShortcut(keyevent.getKeyCode(), keyevent);
        return flag;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        accessibilityevent.setClassName(getClass().getName());
        accessibilityevent.setPackageName(getPackageName());
        android.view.WindowManager.LayoutParams layoutparams = getWindow().getAttributes();
        boolean flag;
        CharSequence charsequence;
        if(((android.view.ViewGroup.LayoutParams) (layoutparams)).width == -1 && ((android.view.ViewGroup.LayoutParams) (layoutparams)).height == -1)
            flag = true;
        else
            flag = false;
        accessibilityevent.setFullScreen(flag);
        charsequence = getTitle();
        if(!TextUtils.isEmpty(charsequence))
            accessibilityevent.getText().add(charsequence);
        return true;
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent) {
        if(motionevent.getAction() == 0)
            onUserInteraction();
        boolean flag;
        if(getWindow().superDispatchTouchEvent(motionevent))
            flag = true;
        else
            flag = onTouchEvent(motionevent);
        return flag;
    }

    public boolean dispatchTrackballEvent(MotionEvent motionevent) {
        onUserInteraction();
        boolean flag;
        if(getWindow().superDispatchTrackballEvent(motionevent))
            flag = true;
        else
            flag = onTrackballEvent(motionevent);
        return flag;
    }

    public void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        printwriter.print(s);
        printwriter.print("Local Activity ");
        printwriter.print(Integer.toHexString(System.identityHashCode(this)));
        printwriter.println(" State:");
        String s1 = (new StringBuilder()).append(s).append("  ").toString();
        printwriter.print(s1);
        printwriter.print("mResumed=");
        printwriter.print(mResumed);
        printwriter.print(" mStopped=");
        printwriter.print(mStopped);
        printwriter.print(" mFinished=");
        printwriter.println(mFinished);
        printwriter.print(s1);
        printwriter.print("mLoadersStarted=");
        printwriter.println(mLoadersStarted);
        printwriter.print(s1);
        printwriter.print("mChangingConfigurations=");
        printwriter.println(mChangingConfigurations);
        printwriter.print(s1);
        printwriter.print("mCurrentConfig=");
        printwriter.println(mCurrentConfig);
        if(mLoaderManager != null) {
            printwriter.print(s);
            printwriter.print("Loader Manager ");
            printwriter.print(Integer.toHexString(System.identityHashCode(mLoaderManager)));
            printwriter.println(":");
            mLoaderManager.dump((new StringBuilder()).append(s).append("  ").toString(), filedescriptor, printwriter, as);
        }
        mFragments.dump(s, filedescriptor, printwriter, as);
    }

    public View findViewById(int i) {
        return getWindow().findViewById(i);
    }

    public void finish() {
        if(mParent != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        int i;
        Intent intent;
        i = mResultCode;
        intent = mResultData;
        this;
        JVM INSTR monitorexit ;
        if(intent == null)
            break MISSING_BLOCK_LABEL_30;
        intent.setAllowFds(false);
        if(ActivityManagerNative.getDefault().finishActivity(mToken, i, intent))
            mFinished = true;
_L4:
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        mParent.finishFromChild(this);
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void finishActivity(int i) {
        if(mParent != null) goto _L2; else goto _L1
_L1:
        ActivityManagerNative.getDefault().finishSubActivity(mToken, mEmbeddedID, i);
_L4:
        return;
_L2:
        mParent.finishActivityFromChild(this, i);
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void finishActivityFromChild(Activity activity, int i) {
        ActivityManagerNative.getDefault().finishSubActivity(mToken, activity.mEmbeddedID, i);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void finishAffinity() {
        if(mParent != null)
            throw new IllegalStateException("Can not be called from an embedded activity");
        if(mResultCode != 0 || mResultData != null)
            throw new IllegalStateException("Can not be called to deliver a result");
        if(ActivityManagerNative.getDefault().finishActivityAffinity(mToken))
            mFinished = true;
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void finishFromChild(Activity activity) {
        finish();
    }

    public ActionBar getActionBar() {
        initActionBar();
        return mActionBar;
    }

    public final IBinder getActivityToken() {
        IBinder ibinder;
        if(mParent != null)
            ibinder = mParent.getActivityToken();
        else
            ibinder = mToken;
        return ibinder;
    }

    public final Application getApplication() {
        return mApplication;
    }

    public ComponentName getCallingActivity() {
        ComponentName componentname1 = ActivityManagerNative.getDefault().getCallingActivity(mToken);
        ComponentName componentname = componentname1;
_L2:
        return componentname;
        RemoteException remoteexception;
        remoteexception;
        componentname = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String getCallingPackage() {
        String s1 = ActivityManagerNative.getDefault().getCallingPackage(mToken);
        String s = s1;
_L2:
        return s;
        RemoteException remoteexception;
        remoteexception;
        s = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int getChangingConfigurations() {
        return mConfigChangeFlags;
    }

    public ComponentName getComponentName() {
        return mComponent;
    }

    public View getCurrentFocus() {
        View view;
        if(mWindow != null)
            view = mWindow.getCurrentFocus();
        else
            view = null;
        return view;
    }

    public FragmentManager getFragmentManager() {
        return mFragments;
    }

    public Intent getIntent() {
        return mIntent;
    }

    HashMap getLastNonConfigurationChildInstances() {
        HashMap hashmap;
        if(mLastNonConfigurationInstances != null)
            hashmap = mLastNonConfigurationInstances.children;
        else
            hashmap = null;
        return hashmap;
    }

    public Object getLastNonConfigurationInstance() {
        Object obj;
        if(mLastNonConfigurationInstances != null)
            obj = mLastNonConfigurationInstances.activity;
        else
            obj = null;
        return obj;
    }

    public LayoutInflater getLayoutInflater() {
        return getWindow().getLayoutInflater();
    }

    public LoaderManager getLoaderManager() {
        LoaderManagerImpl loadermanagerimpl;
        if(mLoaderManager != null) {
            loadermanagerimpl = mLoaderManager;
        } else {
            mCheckedForLoaderManager = true;
            mLoaderManager = getLoaderManager(-1, mLoadersStarted, true);
            loadermanagerimpl = mLoaderManager;
        }
        return loadermanagerimpl;
    }

    LoaderManagerImpl getLoaderManager(int i, boolean flag, boolean flag1) {
        if(mAllLoaderManagers == null)
            mAllLoaderManagers = new SparseArray();
        LoaderManagerImpl loadermanagerimpl = (LoaderManagerImpl)mAllLoaderManagers.get(i);
        if(loadermanagerimpl == null) {
            if(flag1) {
                loadermanagerimpl = new LoaderManagerImpl(this, flag);
                mAllLoaderManagers.put(i, loadermanagerimpl);
            }
        } else {
            loadermanagerimpl.updateActivity(this);
        }
        return loadermanagerimpl;
    }

    public String getLocalClassName() {
        String s = getPackageName();
        String s1 = mComponent.getClassName();
        int i = s.length();
        if(s1.startsWith(s) && s1.length() > i && s1.charAt(i) == '.')
            s1 = s1.substring(i + 1);
        return s1;
    }

    public MenuInflater getMenuInflater() {
        if(mMenuInflater == null) {
            initActionBar();
            if(mActionBar != null)
                mMenuInflater = new MenuInflater(mActionBar.getThemedContext(), this);
            else
                mMenuInflater = new MenuInflater(this);
        }
        return mMenuInflater;
    }

    public final Activity getParent() {
        return mParent;
    }

    public Intent getParentActivityIntent() {
        String s = mActivityInfo.parentActivityName;
        Intent intent;
        if(TextUtils.isEmpty(s))
            intent = null;
        else
            intent = (new Intent()).setClassName(this, s);
        return intent;
    }

    public SharedPreferences getPreferences(int i) {
        return getSharedPreferences(getLocalClassName(), i);
    }

    public int getRequestedOrientation() {
        if(mParent != null) goto _L2; else goto _L1
_L1:
        int j = ActivityManagerNative.getDefault().getRequestedOrientation(mToken);
        int i = j;
_L4:
        return i;
_L2:
        i = mParent.getRequestedOrientation();
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        i = -1;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public Object getSystemService(String s) {
        if(getBaseContext() == null)
            throw new IllegalStateException("System services not available to Activities before onCreate()");
        Object obj;
        if("window".equals(s))
            obj = mWindowManager;
        else
        if("search".equals(s)) {
            ensureSearchManager();
            obj = mSearchManager;
        } else {
            obj = super.getSystemService(s);
        }
        return obj;
    }

    public int getTaskId() {
        int j = ActivityManagerNative.getDefault().getTaskForActivity(mToken, false);
        int i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        i = -1;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public final CharSequence getTitle() {
        return mTitle;
    }

    public final int getTitleColor() {
        return mTitleColor;
    }

    IBinder getToken() {
        return mToken;
    }

    public final int getVolumeControlStream() {
        return getWindow().getVolumeControlStream();
    }

    public Window getWindow() {
        return mWindow;
    }

    public WindowManager getWindowManager() {
        return mWindowManager;
    }

    public boolean hasWindowFocus() {
        Window window = getWindow();
        if(window == null) goto _L2; else goto _L1
_L1:
        View view = window.getDecorView();
        if(view == null) goto _L2; else goto _L3
_L3:
        boolean flag = view.hasWindowFocus();
_L5:
        return flag;
_L2:
        flag = false;
        if(true) goto _L5; else goto _L4
_L4:
    }

    void invalidateFragmentIndex(int i) {
        if(mAllLoaderManagers != null) {
            LoaderManagerImpl loadermanagerimpl = (LoaderManagerImpl)mAllLoaderManagers.get(i);
            if(loadermanagerimpl != null && !loadermanagerimpl.mRetaining) {
                loadermanagerimpl.doDestroy();
                mAllLoaderManagers.remove(i);
            }
        }
    }

    public void invalidateOptionsMenu() {
        mWindow.invalidatePanelMenu(0);
    }

    public boolean isChangingConfigurations() {
        return mChangingConfigurations;
    }

    public final boolean isChild() {
        boolean flag;
        if(mParent != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isFinishing() {
        return mFinished;
    }

    public boolean isImmersive() {
        boolean flag1 = ActivityManagerNative.getDefault().isImmersive(mToken);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public final boolean isResumed() {
        return mResumed;
    }

    public boolean isTaskRoot() {
        boolean flag = true;
        int i = ActivityManagerNative.getDefault().getTaskForActivity(mToken, true);
        if(i < 0)
            flag = false;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    void makeVisible() {
        if(!mWindowAdded) {
            getWindowManager().addView(mDecor, getWindow().getAttributes());
            mWindowAdded = true;
        }
        mDecor.setVisibility(0);
    }

    public final Cursor managedQuery(Uri uri, String as[], String s, String s1) {
        Cursor cursor = getContentResolver().query(uri, as, s, null, s1);
        if(cursor != null)
            startManagingCursor(cursor);
        return cursor;
    }

    public final Cursor managedQuery(Uri uri, String as[], String s, String as1[], String s1) {
        Cursor cursor = getContentResolver().query(uri, as, s, as1, s1);
        if(cursor != null)
            startManagingCursor(cursor);
        return cursor;
    }

    public boolean moveTaskToBack(boolean flag) {
        boolean flag2 = ActivityManagerNative.getDefault().moveActivityTaskToBack(mToken, flag);
        boolean flag1 = flag2;
_L2:
        return flag1;
        RemoteException remoteexception;
        remoteexception;
        flag1 = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean navigateUpTo(Intent intent) {
        boolean flag = false;
        if(mParent != null) goto _L2; else goto _L1
_L1:
        if(intent.getComponent() != null) goto _L4; else goto _L3
_L3:
        ComponentName componentname = intent.resolveActivity(getPackageManager());
        if(componentname != null) goto _L6; else goto _L5
_L5:
        return flag;
_L6:
        Intent intent2;
        intent2 = new Intent(intent);
        intent2.setComponent(componentname);
        intent = intent2;
_L4:
        this;
        JVM INSTR monitorenter ;
        int i;
        Intent intent1;
        i = mResultCode;
        intent1 = mResultData;
        this;
        JVM INSTR monitorexit ;
        if(intent1 != null)
            intent1.setAllowFds(false);
        Exception exception;
        boolean flag1;
        try {
            flag1 = ActivityManagerNative.getDefault().navigateUpTo(mToken, intent, i, intent1);
        }
        catch(RemoteException remoteexception) {
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        flag = mParent.navigateUpToFromChild(this, intent);
        if(true) goto _L5; else goto _L7
_L7:
    }

    public boolean navigateUpToFromChild(Activity activity, Intent intent) {
        return navigateUpTo(intent);
    }

    public void onActionModeFinished(ActionMode actionmode) {
    }

    public void onActionModeStarted(ActionMode actionmode) {
    }

    protected void onActivityResult(int i, int j, Intent intent) {
    }

    protected void onApplyThemeResource(android.content.res.Resources.Theme theme, int i, boolean flag) {
        if(mParent == null) {
            super.onApplyThemeResource(theme, i, flag);
        } else {
            try {
                theme.setTo(mParent.getTheme());
            }
            catch(Exception exception) { }
            theme.applyStyle(i, false);
        }
    }

    public void onAttachFragment(Fragment fragment) {
    }

    public void onAttachedToWindow() {
    }

    public void onBackPressed() {
        if(!mFragments.popBackStackImmediate())
            finish();
    }

    protected void onChildTitleChanged(Activity activity, CharSequence charsequence) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        mCalled = true;
        mFragments.dispatchConfigurationChanged(configuration);
        if(mWindow != null)
            mWindow.onConfigurationChanged(configuration);
        if(mActionBar != null)
            mActionBar.onConfigurationChanged(configuration);
    }

    public void onContentChanged() {
    }

    public boolean onContextItemSelected(MenuItem menuitem) {
        boolean flag;
        if(mParent != null)
            flag = mParent.onContextItemSelected(menuitem);
        else
            flag = false;
        return flag;
    }

    public void onContextMenuClosed(Menu menu) {
        if(mParent != null)
            mParent.onContextMenuClosed(menu);
    }

    protected void onCreate(Bundle bundle) {
        if(mLastNonConfigurationInstances != null)
            mAllLoaderManagers = mLastNonConfigurationInstances.loaders;
        if(mActivityInfo.parentActivityName != null)
            if(mActionBar == null)
                mEnableDefaultActionBarUp = true;
            else
                mActionBar.setDefaultDisplayHomeAsUpEnabled(true);
        if(bundle != null) {
            android.os.Parcelable parcelable = bundle.getParcelable("android:fragments");
            FragmentManagerImpl fragmentmanagerimpl = mFragments;
            ArrayList arraylist;
            if(mLastNonConfigurationInstances != null)
                arraylist = mLastNonConfigurationInstances.fragments;
            else
                arraylist = null;
            fragmentmanagerimpl.restoreAllState(parcelable, arraylist);
        }
        mFragments.dispatchCreate();
        getApplication().dispatchActivityCreated(this, bundle);
        mCalled = true;
        Injector.setActivityGravity(this);
    }

    public void onCreateContextMenu(ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo) {
    }

    public CharSequence onCreateDescription() {
        return null;
    }

    protected Dialog onCreateDialog(int i) {
        return null;
    }

    protected Dialog onCreateDialog(int i, Bundle bundle) {
        return onCreateDialog(i);
    }

    public void onCreateNavigateUpTaskStack(TaskStackBuilder taskstackbuilder) {
        taskstackbuilder.addParentStack(this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        boolean flag;
        if(mParent != null)
            flag = mParent.onCreateOptionsMenu(menu);
        else
            flag = true;
        return flag;
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        boolean flag;
        if(i == 0)
            flag = onCreateOptionsMenu(menu) | mFragments.dispatchCreateOptionsMenu(menu, getMenuInflater());
        else
            flag = false;
        return flag;
    }

    public View onCreatePanelView(int i) {
        return null;
    }

    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        return false;
    }

    public View onCreateView(View view, String s, Context context, AttributeSet attributeset) {
        Fragment fragment = null;
        int i = 0;
        View view1;
        if(!"fragment".equals(s)) {
            view1 = onCreateView(s, context, attributeset);
        } else {
            String s1 = attributeset.getAttributeValue(null, "class");
            TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.Fragment);
            if(s1 == null)
                s1 = typedarray.getString(0);
            int j = typedarray.getResourceId(1, -1);
            String s2 = typedarray.getString(2);
            typedarray.recycle();
            if(view != null)
                i = view.getId();
            if(i == -1 && j == -1 && s2 == null)
                throw new IllegalArgumentException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Must specify unique android:id, android:tag, or have a parent with an id for ").append(s1).toString());
            if(j != -1)
                fragment = mFragments.findFragmentById(j);
            if(fragment == null && s2 != null)
                fragment = mFragments.findFragmentByTag(s2);
            if(fragment == null && i != -1)
                fragment = mFragments.findFragmentById(i);
            if(FragmentManagerImpl.DEBUG)
                Log.v("Activity", (new StringBuilder()).append("onCreateView: id=0x").append(Integer.toHexString(j)).append(" fname=").append(s1).append(" existing=").append(fragment).toString());
            if(fragment == null) {
                fragment = Fragment.instantiate(this, s1);
                fragment.mFromLayout = true;
                int k;
                if(j != 0)
                    k = j;
                else
                    k = i;
                fragment.mFragmentId = k;
                fragment.mContainerId = i;
                fragment.mTag = s2;
                fragment.mInLayout = true;
                fragment.mFragmentManager = mFragments;
                fragment.onInflate(this, attributeset, fragment.mSavedFragmentState);
                mFragments.addFragment(fragment, true);
            } else {
                if(fragment.mInLayout)
                    throw new IllegalArgumentException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Duplicate id 0x").append(Integer.toHexString(j)).append(", tag ").append(s2).append(", or parent id 0x").append(Integer.toHexString(i)).append(" with another fragment for ").append(s1).toString());
                fragment.mInLayout = true;
                if(!fragment.mRetaining)
                    fragment.onInflate(this, attributeset, fragment.mSavedFragmentState);
                mFragments.moveToState(fragment);
            }
            if(fragment.mView == null)
                throw new IllegalStateException((new StringBuilder()).append("Fragment ").append(s1).append(" did not create a view.").toString());
            if(j != 0)
                fragment.mView.setId(j);
            if(fragment.mView.getTag() == null)
                fragment.mView.setTag(s2);
            view1 = fragment.mView;
        }
        return view1;
    }

    public View onCreateView(String s, Context context, AttributeSet attributeset) {
        return null;
    }

    protected void onDestroy() {
        mCalled = true;
        if(mManagedDialogs != null) {
            int k = mManagedDialogs.size();
            for(int l = 0; l < k; l++) {
                ManagedDialog manageddialog = (ManagedDialog)mManagedDialogs.valueAt(l);
                if(manageddialog.mDialog.isShowing())
                    manageddialog.mDialog.dismiss();
            }

            mManagedDialogs = null;
        }
        ArrayList arraylist = mManagedCursors;
        arraylist;
        JVM INSTR monitorenter ;
        int i;
        i = mManagedCursors.size();
        Exception exception;
        for(int j = 0; j < i; j++) {
            ManagedCursor managedcursor = (ManagedCursor)mManagedCursors.get(j);
            if(managedcursor != null)
                managedcursor.mCursor.close();
            break MISSING_BLOCK_LABEL_168;
        }

        mManagedCursors.clear();
        if(mSearchManager != null)
            mSearchManager.stopSearch();
        getApplication().dispatchActivityDestroyed(this);
        return;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onDetachedFromWindow() {
    }

    public boolean onGenericMotionEvent(MotionEvent motionevent) {
        return false;
    }

    public boolean onKeyDown(int i, KeyEvent keyevent) {
        if(i != 4) goto _L2; else goto _L1
_L1:
        boolean flag1;
        if(getApplicationInfo().targetSdkVersion >= 5)
            keyevent.startTracking();
        else
            onBackPressed();
        flag1 = true;
_L9:
        return flag1;
_L2:
        boolean flag;
        if(mDefaultKeyMode == 0) {
            flag1 = false;
            continue; /* Loop/switch isn't completed */
        }
        if(mDefaultKeyMode == 2) {
            if(getWindow().performPanelShortcut(0, i, keyevent, 2))
                flag1 = true;
            else
                flag1 = false;
            continue; /* Loop/switch isn't completed */
        }
        flag = false;
        if(keyevent.getRepeatCount() == 0 && !keyevent.isSystem()) goto _L4; else goto _L3
_L3:
        flag = true;
        flag1 = false;
_L6:
        if(flag) {
            mDefaultKeySsb.clear();
            mDefaultKeySsb.clearSpans();
            Selection.setSelection(mDefaultKeySsb, 0);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        flag1 = TextKeyListener.getInstance().onKeyDown(null, mDefaultKeySsb, i, keyevent);
        if(!flag1 || mDefaultKeySsb.length() <= 0) goto _L6; else goto _L5
_L5:
        String s = mDefaultKeySsb.toString();
        flag = true;
        switch(mDefaultKeyMode) {
        case 1: // '\001'
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse((new StringBuilder()).append("tel:").append(s).toString()));
            intent.addFlags(0x10000000);
            startActivity(intent);
            break;

        case 3: // '\003'
            startSearch(s, false, null, false);
            break;

        case 4: // '\004'
            startSearch(s, false, null, true);
            break;
        }
        if(true) goto _L6; else goto _L7
_L7:
        if(true) goto _L9; else goto _L8
_L8:
    }

    public boolean onKeyLongPress(int i, KeyEvent keyevent) {
        return false;
    }

    public boolean onKeyMultiple(int i, int j, KeyEvent keyevent) {
        return false;
    }

    public boolean onKeyShortcut(int i, KeyEvent keyevent) {
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyevent) {
        boolean flag;
        if(getApplicationInfo().targetSdkVersion >= 5 && i == 4 && keyevent.isTracking() && !keyevent.isCanceled()) {
            onBackPressed();
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public void onLowMemory() {
        mCalled = true;
        mFragments.dispatchLowMemory();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuitem) {
        boolean flag = true;
        i;
        JVM INSTR lookupswitch 2: default 28
    //                   0: 32
    //                   6: 147;
           goto _L1 _L2 _L3
_L1:
        flag = false;
_L5:
        return flag;
_L2:
        Object aobj1[] = new Object[2];
        aobj1[0] = Integer.valueOf(0);
        aobj1[flag] = menuitem.getTitleCondensed();
        EventLog.writeEvent(50000, aobj1);
        if(!onOptionsItemSelected(menuitem) && !mFragments.dispatchOptionsItemSelected(menuitem))
            if(menuitem.getItemId() == 0x102002c && mActionBar != null && (4 & mActionBar.getDisplayOptions()) != 0) {
                if(mParent == null)
                    flag = onNavigateUp();
                else
                    flag = mParent.onNavigateUpFromChild(this);
            } else {
                flag = false;
            }
        continue; /* Loop/switch isn't completed */
_L3:
        Object aobj[] = new Object[2];
        aobj[0] = Integer.valueOf(flag);
        aobj[flag] = menuitem.getTitleCondensed();
        EventLog.writeEvent(50000, aobj);
        if(!onContextItemSelected(menuitem))
            flag = mFragments.dispatchContextItemSelected(menuitem);
        if(true) goto _L5; else goto _L4
_L4:
    }

    public boolean onMenuOpened(int i, Menu menu) {
        if(i == 8) {
            initActionBar();
            if(mActionBar != null)
                mActionBar.dispatchMenuVisibilityChanged(true);
            else
                Log.e("Activity", "Tried to open action bar menu with no action bar");
        }
        return true;
    }

    public boolean onNavigateUp() {
        Intent intent = getParentActivityIntent();
        boolean flag;
        if(intent != null) {
            if(shouldUpRecreateTask(intent)) {
                TaskStackBuilder taskstackbuilder = TaskStackBuilder.create(this);
                onCreateNavigateUpTaskStack(taskstackbuilder);
                onPrepareNavigateUpTaskStack(taskstackbuilder);
                taskstackbuilder.startActivities();
                if(mResultCode != 0 || mResultData != null) {
                    Log.i("Activity", "onNavigateUp only finishing topmost activity to return a result");
                    finish();
                } else {
                    finishAffinity();
                }
            } else {
                navigateUpTo(intent);
            }
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public boolean onNavigateUpFromChild(Activity activity) {
        return onNavigateUp();
    }

    protected void onNewIntent(Intent intent) {
    }

    public boolean onOptionsItemSelected(MenuItem menuitem) {
        boolean flag;
        if(mParent != null)
            flag = mParent.onOptionsItemSelected(menuitem);
        else
            flag = false;
        return flag;
    }

    public void onOptionsMenuClosed(Menu menu) {
        if(mParent != null)
            mParent.onOptionsMenuClosed(menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        i;
        JVM INSTR lookupswitch 3: default 36
    //                   0: 37
    //                   6: 53
    //                   8: 61;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        mFragments.dispatchOptionsMenuClosed(menu);
        onOptionsMenuClosed(menu);
        continue; /* Loop/switch isn't completed */
_L3:
        onContextMenuClosed(menu);
        continue; /* Loop/switch isn't completed */
_L4:
        initActionBar();
        mActionBar.dispatchMenuVisibilityChanged(false);
        if(true) goto _L1; else goto _L5
_L5:
    }

    protected void onPause() {
        getApplication().dispatchActivityPaused(this);
        mCalled = true;
    }

    protected void onPostCreate(Bundle bundle) {
        if(!isChild()) {
            mTitleReady = true;
            onTitleChanged(getTitle(), getTitleColor());
        }
        mCalled = true;
    }

    protected void onPostResume() {
        Window window = getWindow();
        if(window != null)
            window.makeActive();
        if(mActionBar != null)
            mActionBar.setShowHideAnimationEnabled(true);
        mCalled = true;
    }

    protected void onPrepareDialog(int i, Dialog dialog) {
        dialog.setOwnerActivity(this);
    }

    protected void onPrepareDialog(int i, Dialog dialog, Bundle bundle) {
        onPrepareDialog(i, dialog);
    }

    public void onPrepareNavigateUpTaskStack(TaskStackBuilder taskstackbuilder) {
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean flag;
        if(mParent != null)
            flag = mParent.onPrepareOptionsMenu(menu);
        else
            flag = true;
        return flag;
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        boolean flag;
        if(i == 0 && menu != null)
            flag = onPrepareOptionsMenu(menu) | mFragments.dispatchPrepareOptionsMenu(menu);
        else
            flag = true;
        return flag;
    }

    protected void onRestart() {
        mCalled = true;
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        if(mWindow != null) {
            Bundle bundle1 = bundle.getBundle("android:viewHierarchyState");
            if(bundle1 != null)
                mWindow.restoreHierarchyState(bundle1);
        }
    }

    protected void onResume() {
        getApplication().dispatchActivityResumed(this);
        mCalled = true;
        Injector.checkAccessControl(this);
    }

    HashMap onRetainNonConfigurationChildInstances() {
        return null;
    }

    public Object onRetainNonConfigurationInstance() {
        return null;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBundle("android:viewHierarchyState", mWindow.saveHierarchyState());
        android.os.Parcelable parcelable = mFragments.saveAllState();
        if(parcelable != null)
            bundle.putParcelable("android:fragments", parcelable);
        getApplication().dispatchActivitySaveInstanceState(this, bundle);
    }

    public boolean onSearchRequested() {
        startSearch(null, false, null, false);
        return true;
    }

    protected void onStart() {
        mCalled = true;
        if(mLoadersStarted) goto _L2; else goto _L1
_L1:
        mLoadersStarted = true;
        if(mLoaderManager == null) goto _L4; else goto _L3
_L3:
        mLoaderManager.doStart();
_L6:
        mCheckedForLoaderManager = true;
_L2:
        getApplication().dispatchActivityStarted(this);
        return;
_L4:
        if(!mCheckedForLoaderManager)
            mLoaderManager = getLoaderManager(-1, mLoadersStarted, false);
        if(true) goto _L6; else goto _L5
_L5:
    }

    protected void onStop() {
        if(mActionBar != null)
            mActionBar.setShowHideAnimationEnabled(false);
        getApplication().dispatchActivityStopped(this);
        mCalled = true;
    }

    protected void onTitleChanged(CharSequence charsequence, int i) {
        if(mTitleReady) {
            Window window = getWindow();
            if(window != null) {
                window.setTitle(charsequence);
                if(i != 0)
                    window.setTitleColor(i);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent) {
        boolean flag;
        if(mWindow.shouldCloseOnTouch(this, motionevent)) {
            finish();
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public boolean onTrackballEvent(MotionEvent motionevent) {
        return false;
    }

    public void onTrimMemory(int i) {
        mCalled = true;
        mFragments.dispatchTrimMemory(i);
    }

    public void onUserInteraction() {
    }

    protected void onUserLeaveHint() {
    }

    public void onWindowAttributesChanged(android.view.WindowManager.LayoutParams layoutparams) {
        if(mParent == null) {
            View view = mDecor;
            if(view != null && view.getParent() != null)
                getWindowManager().updateViewLayout(view, layoutparams);
        }
    }

    public void onWindowFocusChanged(boolean flag) {
    }

    public ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback) {
        initActionBar();
        ActionMode actionmode;
        if(mActionBar != null)
            actionmode = mActionBar.startActionMode(callback);
        else
            actionmode = null;
        return actionmode;
    }

    public void openContextMenu(View view) {
        view.showContextMenu();
    }

    public void openOptionsMenu() {
        mWindow.openPanel(0, null);
    }

    public void overridePendingTransition(int i, int j) {
        ActivityManagerNative.getDefault().overridePendingTransition(mToken, getPackageName(), i, j);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    final void performCreate(Bundle bundle) {
        boolean flag = false;
        onCreate(bundle);
        if(!mWindow.getWindowStyle().getBoolean(10, false))
            flag = true;
        mVisibleFromClient = flag;
        mFragments.dispatchActivityCreated();
    }

    final void performDestroy() {
        mWindow.destroy();
        mFragments.dispatchDestroy();
        onDestroy();
        if(mLoaderManager != null)
            mLoaderManager.doDestroy();
    }

    final void performPause() {
        mFragments.dispatchPause();
        mCalled = false;
        onPause();
        mResumed = false;
        if(!mCalled && getApplicationInfo().targetSdkVersion >= 9) {
            throw new SuperNotCalledException((new StringBuilder()).append("Activity ").append(mComponent.toShortString()).append(" did not call through to super.onPause()").toString());
        } else {
            mResumed = false;
            return;
        }
    }

    final void performRestart() {
        mFragments.noteStateNotSaved();
        if(!mStopped) goto _L2; else goto _L1
_L1:
        mStopped = false;
        if(mToken != null && mParent == null)
            WindowManagerImpl.getDefault().setStoppedState(mToken, false);
        ArrayList arraylist = mManagedCursors;
        arraylist;
        JVM INSTR monitorenter ;
        int i;
        int j;
        i = mManagedCursors.size();
        j = 0;
_L7:
        if(j >= i) goto _L4; else goto _L3
_L3:
        ManagedCursor managedcursor;
        managedcursor = (ManagedCursor)mManagedCursors.get(j);
        if(managedcursor.mReleased || managedcursor.mUpdated) {
            if(!managedcursor.mCursor.requery() && getApplicationInfo().targetSdkVersion >= 14)
                throw new IllegalStateException((new StringBuilder()).append("trying to requery an already closed cursor  ").append(managedcursor.mCursor).toString());
            break MISSING_BLOCK_LABEL_160;
        }
          goto _L5
        Exception exception;
        exception;
        throw exception;
        managedcursor.mReleased = false;
        managedcursor.mUpdated = false;
          goto _L5
_L4:
        mCalled = false;
        mInstrumentation.callActivityOnRestart(this);
        if(!mCalled)
            throw new SuperNotCalledException((new StringBuilder()).append("Activity ").append(mComponent.toShortString()).append(" did not call through to super.onRestart()").toString());
        performStart();
_L2:
        return;
_L5:
        j++;
        if(true) goto _L7; else goto _L6
_L6:
    }

    final void performRestoreInstanceState(Bundle bundle) {
        onRestoreInstanceState(bundle);
        restoreManagedDialogs(bundle);
    }

    final void performResume() {
        performRestart();
        mFragments.execPendingActions();
        mLastNonConfigurationInstances = null;
        mCalled = false;
        mInstrumentation.callActivityOnResume(this);
        if(!mCalled)
            throw new SuperNotCalledException((new StringBuilder()).append("Activity ").append(mComponent.toShortString()).append(" did not call through to super.onResume()").toString());
        mCalled = false;
        mFragments.dispatchResume();
        mFragments.execPendingActions();
        onPostResume();
        if(!mCalled)
            throw new SuperNotCalledException((new StringBuilder()).append("Activity ").append(mComponent.toShortString()).append(" did not call through to super.onPostResume()").toString());
        else
            return;
    }

    final void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        saveManagedDialogs(bundle);
    }

    final void performStart() {
        mFragments.noteStateNotSaved();
        mCalled = false;
        mFragments.execPendingActions();
        mInstrumentation.callActivityOnStart(this);
        if(!mCalled)
            throw new SuperNotCalledException((new StringBuilder()).append("Activity ").append(mComponent.toShortString()).append(" did not call through to super.onStart()").toString());
        mFragments.dispatchStart();
        if(mAllLoaderManagers != null) {
            for(int i = -1 + mAllLoaderManagers.size(); i >= 0; i--) {
                LoaderManagerImpl loadermanagerimpl = (LoaderManagerImpl)mAllLoaderManagers.valueAt(i);
                loadermanagerimpl.finishRetain();
                loadermanagerimpl.doReportStart();
            }

        }
    }

    final void performStop() {
        if(mLoadersStarted) {
            mLoadersStarted = false;
            if(mLoaderManager != null)
                if(!mChangingConfigurations)
                    mLoaderManager.doStop();
                else
                    mLoaderManager.doRetain();
        }
        if(mStopped)
            break MISSING_BLOCK_LABEL_229;
        if(mWindow != null)
            mWindow.closeAllPanels();
        if(mToken != null && mParent == null)
            WindowManagerImpl.getDefault().setStoppedState(mToken, true);
        mFragments.dispatchStop();
        mCalled = false;
        mInstrumentation.callActivityOnStop(this);
        if(!mCalled)
            throw new SuperNotCalledException((new StringBuilder()).append("Activity ").append(mComponent.toShortString()).append(" did not call through to super.onStop()").toString());
        ArrayList arraylist = mManagedCursors;
        arraylist;
        JVM INSTR monitorenter ;
        int i;
        i = mManagedCursors.size();
        Exception exception;
        for(int j = 0; j < i; j++) {
            ManagedCursor managedcursor = (ManagedCursor)mManagedCursors.get(j);
            if(!managedcursor.mReleased) {
                managedcursor.mCursor.deactivate();
                managedcursor.mReleased = true;
            }
            break MISSING_BLOCK_LABEL_240;
        }

        mStopped = true;
        mResumed = false;
        return;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    final void performUserLeaving() {
        onUserInteraction();
        onUserLeaveHint();
    }

    public void recreate() {
        if(mParent != null)
            throw new IllegalStateException("Can only be called on top-level activity");
        if(Looper.myLooper() != mMainThread.getLooper()) {
            throw new IllegalStateException("Must be called from main thread");
        } else {
            mMainThread.requestRelaunchActivity(mToken, null, null, 0, false, null, false);
            return;
        }
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    public final void removeDialog(int i) {
        if(mManagedDialogs != null) {
            ManagedDialog manageddialog = (ManagedDialog)mManagedDialogs.get(i);
            if(manageddialog != null) {
                manageddialog.mDialog.dismiss();
                mManagedDialogs.remove(i);
            }
        }
    }

    public final boolean requestWindowFeature(int i) {
        return getWindow().requestFeature(i);
    }

    NonConfigurationInstances retainNonConfigurationInstances() {
        Object obj = onRetainNonConfigurationInstance();
        HashMap hashmap = onRetainNonConfigurationChildInstances();
        ArrayList arraylist = mFragments.retainNonConfig();
        boolean flag = false;
        if(mAllLoaderManagers != null) {
            int i = -1 + mAllLoaderManagers.size();
            while(i >= 0)  {
                LoaderManagerImpl loadermanagerimpl = (LoaderManagerImpl)mAllLoaderManagers.valueAt(i);
                if(loadermanagerimpl.mRetaining) {
                    flag = true;
                } else {
                    loadermanagerimpl.doDestroy();
                    mAllLoaderManagers.removeAt(i);
                }
                i--;
            }
        }
        NonConfigurationInstances nonconfigurationinstances;
        if(obj == null && hashmap == null && arraylist == null && !flag) {
            nonconfigurationinstances = null;
        } else {
            nonconfigurationinstances = new NonConfigurationInstances();
            nonconfigurationinstances.activity = obj;
            nonconfigurationinstances.children = hashmap;
            nonconfigurationinstances.fragments = arraylist;
            nonconfigurationinstances.loaders = mAllLoaderManagers;
        }
        return nonconfigurationinstances;
    }

    public final void runOnUiThread(Runnable runnable) {
        if(Thread.currentThread() != mUiThread)
            mHandler.post(runnable);
        else
            runnable.run();
    }

    public void setContentView(int i) {
        getWindow().setContentView(i);
        initActionBar();
    }

    public void setContentView(View view) {
        getWindow().setContentView(view);
        initActionBar();
    }

    public void setContentView(View view, android.view.ViewGroup.LayoutParams layoutparams) {
        getWindow().setContentView(view, layoutparams);
        initActionBar();
    }

    public final void setDefaultKeyMode(int i) {
        mDefaultKeyMode = i;
        i;
        JVM INSTR tableswitch 0 4: default 40
    //                   0 48
    //                   1 54
    //                   2 48
    //                   3 54
    //                   4 54;
           goto _L1 _L2 _L3 _L2 _L3 _L3
_L1:
        throw new IllegalArgumentException();
_L2:
        mDefaultKeySsb = null;
_L5:
        return;
_L3:
        mDefaultKeySsb = new SpannableStringBuilder();
        Selection.setSelection(mDefaultKeySsb, 0);
        if(true) goto _L5; else goto _L4
_L4:
    }

    public final void setFeatureDrawable(int i, Drawable drawable) {
        getWindow().setFeatureDrawable(i, drawable);
    }

    public final void setFeatureDrawableAlpha(int i, int j) {
        getWindow().setFeatureDrawableAlpha(i, j);
    }

    public final void setFeatureDrawableResource(int i, int j) {
        getWindow().setFeatureDrawableResource(i, j);
    }

    public final void setFeatureDrawableUri(int i, Uri uri) {
        getWindow().setFeatureDrawableUri(i, uri);
    }

    public void setFinishOnTouchOutside(boolean flag) {
        mWindow.setCloseOnTouchOutside(flag);
    }

    public void setImmersive(boolean flag) {
        ActivityManagerNative.getDefault().setImmersive(mToken, flag);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void setIntent(Intent intent) {
        mIntent = intent;
    }

    final void setParent(Activity activity) {
        mParent = activity;
    }

    public void setPersistent(boolean flag) {
    }

    public final void setProgress(int i) {
        getWindow().setFeatureInt(2, i + 0);
    }

    public final void setProgressBarIndeterminate(boolean flag) {
        Window window = getWindow();
        byte byte0;
        if(flag)
            byte0 = -3;
        else
            byte0 = -4;
        window.setFeatureInt(2, byte0);
    }

    public final void setProgressBarIndeterminateVisibility(boolean flag) {
        Window window = getWindow();
        byte byte0;
        if(flag)
            byte0 = -1;
        else
            byte0 = -2;
        window.setFeatureInt(5, byte0);
    }

    public final void setProgressBarVisibility(boolean flag) {
        Window window = getWindow();
        byte byte0;
        if(flag)
            byte0 = -1;
        else
            byte0 = -2;
        window.setFeatureInt(2, byte0);
    }

    public void setRequestedOrientation(int i) {
        if(mParent != null) goto _L2; else goto _L1
_L1:
        ActivityManagerNative.getDefault().setRequestedOrientation(mToken, i);
_L4:
        return;
_L2:
        mParent.setRequestedOrientation(i);
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public final void setResult(int i) {
        this;
        JVM INSTR monitorenter ;
        mResultCode = i;
        mResultData = null;
        return;
    }

    public final void setResult(int i, Intent intent) {
        this;
        JVM INSTR monitorenter ;
        mResultCode = i;
        mResultData = intent;
        return;
    }

    public final void setSecondaryProgress(int i) {
        getWindow().setFeatureInt(2, i + 20000);
    }

    public void setTitle(int i) {
        setTitle(getText(i));
    }

    public void setTitle(CharSequence charsequence) {
        mTitle = charsequence;
        onTitleChanged(charsequence, mTitleColor);
        if(mParent != null)
            mParent.onChildTitleChanged(this, charsequence);
    }

    public void setTitleColor(int i) {
        mTitleColor = i;
        onTitleChanged(mTitle, i);
    }

    public void setVisible(boolean flag) {
        if(mVisibleFromClient != flag) {
            mVisibleFromClient = flag;
            if(mVisibleFromServer)
                if(flag)
                    makeVisible();
                else
                    mDecor.setVisibility(4);
        }
    }

    public final void setVolumeControlStream(int i) {
        getWindow().setVolumeControlStream(i);
    }

    public boolean shouldUpRecreateTask(Intent intent) {
        boolean flag = false;
        boolean flag1;
        PackageManager packagemanager = getPackageManager();
        ComponentName componentname = intent.getComponent();
        if(componentname == null)
            componentname = intent.resolveActivity(packagemanager);
        ActivityInfo activityinfo = packagemanager.getActivityInfo(componentname, 0);
        if(activityinfo.taskAffinity == null)
            break MISSING_BLOCK_LABEL_83;
        flag1 = ActivityManagerNative.getDefault().targetTaskAffinityMatchesActivity(mToken, activityinfo.taskAffinity);
        if(!flag1)
            flag = true;
        break MISSING_BLOCK_LABEL_83;
        RemoteException remoteexception;
        remoteexception;
        break MISSING_BLOCK_LABEL_83;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        return flag;
    }

    public final void showDialog(int i) {
        showDialog(i, null);
    }

    public final boolean showDialog(int i, Bundle bundle) {
        ManagedDialog manageddialog;
        if(mManagedDialogs == null)
            mManagedDialogs = new SparseArray();
        manageddialog = (ManagedDialog)mManagedDialogs.get(i);
        if(manageddialog != null) goto _L2; else goto _L1
_L1:
        manageddialog = new ManagedDialog();
        manageddialog.mDialog = createDialog(Integer.valueOf(i), null, bundle);
        if(manageddialog.mDialog != null) goto _L4; else goto _L3
_L3:
        boolean flag = false;
_L6:
        return flag;
_L4:
        mManagedDialogs.put(i, manageddialog);
_L2:
        manageddialog.mArgs = bundle;
        onPrepareDialog(i, manageddialog.mDialog, bundle);
        manageddialog.mDialog.show();
        flag = true;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public ActionMode startActionMode(android.view.ActionMode.Callback callback) {
        return mWindow.getDecorView().startActionMode(callback);
    }

    public void startActivities(Intent aintent[]) {
        startActivities(aintent, null);
    }

    public void startActivities(Intent aintent[], Bundle bundle) {
        mInstrumentation.execStartActivities(this, mMainThread.getApplicationThread(), mToken, this, aintent, bundle);
    }

    public void startActivity(Intent intent) {
        startActivity(intent, null);
    }

    public void startActivity(Intent intent, Bundle bundle) {
        if(bundle != null)
            startActivityForResult(intent, -1, bundle);
        else
            startActivityForResult(intent, -1);
    }

    public void startActivityForResult(Intent intent, int i) {
        startActivityForResult(intent, i, null);
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if(mParent == null) {
            Instrumentation.ActivityResult activityresult = mInstrumentation.execStartActivity(this, mMainThread.getApplicationThread(), mToken, this, intent, i, bundle);
            if(activityresult != null)
                mMainThread.sendActivityResult(mToken, mEmbeddedID, i, activityresult.getResultCode(), activityresult.getResultData());
            if(i >= 0)
                mStartedActivity = true;
        } else
        if(bundle != null)
            mParent.startActivityFromChild(this, intent, i, bundle);
        else
            mParent.startActivityFromChild(this, intent, i);
    }

    public void startActivityFromChild(Activity activity, Intent intent, int i) {
        startActivityFromChild(activity, intent, i, null);
    }

    public void startActivityFromChild(Activity activity, Intent intent, int i, Bundle bundle) {
        Instrumentation.ActivityResult activityresult = mInstrumentation.execStartActivity(this, mMainThread.getApplicationThread(), mToken, activity, intent, i, bundle);
        if(activityresult != null)
            mMainThread.sendActivityResult(mToken, activity.mEmbeddedID, i, activityresult.getResultCode(), activityresult.getResultData());
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i) {
        startActivityFromFragment(fragment, intent, i, null);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i, Bundle bundle) {
        Instrumentation.ActivityResult activityresult = mInstrumentation.execStartActivity(this, mMainThread.getApplicationThread(), mToken, fragment, intent, i, bundle);
        if(activityresult != null)
            mMainThread.sendActivityResult(mToken, fragment.mWho, i, activityresult.getResultCode(), activityresult.getResultData());
    }

    public boolean startActivityIfNeeded(Intent intent, int i) {
        return startActivityIfNeeded(intent, i, null);
    }

    public boolean startActivityIfNeeded(Intent intent, int i, Bundle bundle) {
        if(mParent != null) goto _L2; else goto _L1
_L1:
        int j = 1;
        int k;
        intent.setAllowFds(false);
        k = ActivityManagerNative.getDefault().startActivity(mMainThread.getApplicationThread(), intent, intent.resolveTypeIfNeeded(getContentResolver()), mToken, mEmbeddedID, i, 1, null, null, bundle);
        j = k;
_L4:
        Instrumentation.checkStartActivityResult(j, intent);
        if(i >= 0)
            mStartedActivity = true;
        boolean flag;
        if(j != 1)
            flag = true;
        else
            flag = false;
        return flag;
_L2:
        throw new UnsupportedOperationException("startActivityIfNeeded can only be called from a top-level activity");
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void startIntentSender(IntentSender intentsender, Intent intent, int i, int j, int k) throws android.content.IntentSender.SendIntentException {
        startIntentSender(intentsender, intent, i, j, k, null);
    }

    public void startIntentSender(IntentSender intentsender, Intent intent, int i, int j, int k, Bundle bundle) throws android.content.IntentSender.SendIntentException {
        if(bundle != null)
            startIntentSenderForResult(intentsender, -1, intent, i, j, k, bundle);
        else
            startIntentSenderForResult(intentsender, -1, intent, i, j, k);
    }

    public void startIntentSenderForResult(IntentSender intentsender, int i, Intent intent, int j, int k, int l) throws android.content.IntentSender.SendIntentException {
        startIntentSenderForResult(intentsender, i, intent, j, k, l, null);
    }

    public void startIntentSenderForResult(IntentSender intentsender, int i, Intent intent, int j, int k, int l, Bundle bundle) throws android.content.IntentSender.SendIntentException {
        if(mParent == null)
            startIntentSenderForResultInner(intentsender, i, intent, j, k, this, bundle);
        else
        if(bundle != null)
            mParent.startIntentSenderFromChild(this, intentsender, i, intent, j, k, l, bundle);
        else
            mParent.startIntentSenderFromChild(this, intentsender, i, intent, j, k, l);
    }

    public void startIntentSenderFromChild(Activity activity, IntentSender intentsender, int i, Intent intent, int j, int k, int l) throws android.content.IntentSender.SendIntentException {
        startIntentSenderFromChild(activity, intentsender, i, intent, j, k, l, null);
    }

    public void startIntentSenderFromChild(Activity activity, IntentSender intentsender, int i, Intent intent, int j, int k, int l, 
            Bundle bundle) throws android.content.IntentSender.SendIntentException {
        startIntentSenderForResultInner(intentsender, i, intent, j, k, activity, bundle);
    }

    public void startManagingCursor(Cursor cursor) {
        ArrayList arraylist = mManagedCursors;
        arraylist;
        JVM INSTR monitorenter ;
        mManagedCursors.add(new ManagedCursor(cursor));
        return;
    }

    public boolean startNextMatchingActivity(Intent intent) {
        return startNextMatchingActivity(intent, null);
    }

    public boolean startNextMatchingActivity(Intent intent, Bundle bundle) {
        boolean flag = false;
        if(mParent != null) goto _L2; else goto _L1
_L1:
        boolean flag1;
        intent.setAllowFds(false);
        flag1 = ActivityManagerNative.getDefault().startNextMatchingActivity(mToken, intent, bundle);
        flag = flag1;
_L4:
        return flag;
_L2:
        throw new UnsupportedOperationException("startNextMatchingActivity can only be called from a top-level activity");
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void startSearch(String s, boolean flag, Bundle bundle, boolean flag1) {
        ensureSearchManager();
        mSearchManager.startSearch(s, flag, getComponentName(), bundle, flag1);
    }

    public void stopManagingCursor(Cursor cursor) {
        ArrayList arraylist = mManagedCursors;
        arraylist;
        JVM INSTR monitorenter ;
        int i = mManagedCursors.size();
        int j = 0;
        do {
label0:
            {
                if(j < i) {
                    if(((ManagedCursor)mManagedCursors.get(j)).mCursor != cursor)
                        break label0;
                    mManagedCursors.remove(j);
                }
                return;
            }
            j++;
        } while(true);
    }

    public void takeKeyEvents(boolean flag) {
        getWindow().takeKeyEvents(flag);
    }

    public void triggerSearch(String s, Bundle bundle) {
        ensureSearchManager();
        mSearchManager.triggerSearch(s, getComponentName(), bundle);
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }

    private static final boolean DEBUG_LIFECYCLE = false;
    public static final int DEFAULT_KEYS_DIALER = 1;
    public static final int DEFAULT_KEYS_DISABLE = 0;
    public static final int DEFAULT_KEYS_SEARCH_GLOBAL = 4;
    public static final int DEFAULT_KEYS_SEARCH_LOCAL = 3;
    public static final int DEFAULT_KEYS_SHORTCUT = 2;
    protected static final int FOCUSED_STATE_SET[];
    private static final String FRAGMENTS_TAG = "android:fragments";
    public static final int RESULT_CANCELED = 0;
    public static final int RESULT_FIRST_USER = 1;
    public static final int RESULT_OK = -1;
    private static final String SAVED_DIALOGS_TAG = "android:savedDialogs";
    private static final String SAVED_DIALOG_ARGS_KEY_PREFIX = "android:dialog_args_";
    private static final String SAVED_DIALOG_IDS_KEY = "android:savedDialogIds";
    private static final String SAVED_DIALOG_KEY_PREFIX = "android:dialog_";
    private static final String TAG = "Activity";
    private static final String WINDOW_HIERARCHY_TAG = "android:viewHierarchyState";
    ActionBarImpl mActionBar;
    ActivityInfo mActivityInfo;
    SparseArray mAllLoaderManagers;
    private Application mApplication;
    boolean mCalled;
    boolean mChangingConfigurations;
    boolean mCheckedForLoaderManager;
    private ComponentName mComponent;
    int mConfigChangeFlags;
    Configuration mCurrentConfig;
    View mDecor;
    private int mDefaultKeyMode;
    private SpannableStringBuilder mDefaultKeySsb;
    String mEmbeddedID;
    private boolean mEnableDefaultActionBarUp;
    boolean mFinished;
    final FragmentManagerImpl mFragments = new FragmentManagerImpl();
    final Handler mHandler = new Handler();
    private int mIdent;
    private final Object mInstanceTracker = StrictMode.trackActivity(this);
    private Instrumentation mInstrumentation;
    Intent mIntent;
    NonConfigurationInstances mLastNonConfigurationInstances;
    LoaderManagerImpl mLoaderManager;
    boolean mLoadersStarted;
    ActivityThread mMainThread;
    private final ArrayList mManagedCursors = new ArrayList();
    private SparseArray mManagedDialogs;
    private MenuInflater mMenuInflater;
    Activity mParent;
    int mResultCode;
    Intent mResultData;
    boolean mResumed;
    private SearchManager mSearchManager;
    boolean mStartedActivity;
    private boolean mStopped;
    boolean mTemporaryPause;
    private CharSequence mTitle;
    private int mTitleColor;
    private boolean mTitleReady;
    private IBinder mToken;
    private Thread mUiThread;
    boolean mVisibleFromClient;
    boolean mVisibleFromServer;
    private Window mWindow;
    boolean mWindowAdded;
    private WindowManager mWindowManager;

    static  {
        int ai[] = new int[1];
        ai[0] = 0x101009c;
        FOCUSED_STATE_SET = ai;
    }

}

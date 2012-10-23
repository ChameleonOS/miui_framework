// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageItemInfo;
import android.os.Binder;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import java.util.*;

// Referenced classes of package android.app:
//            ActivityThread, Activity

public class LocalActivityManager {
    private static class LocalActivityRecord extends Binder {

        Activity activity;
        ActivityInfo activityInfo;
        int curState;
        final String id;
        Bundle instanceState;
        Intent intent;
        Window window;

        LocalActivityRecord(String s, Intent intent1) {
            curState = 0;
            id = s;
            intent = intent1;
        }
    }


    public LocalActivityManager(Activity activity, boolean flag) {
        mCurState = 1;
        mParent = activity;
        mSingleMode = flag;
    }

    private void moveToState(LocalActivityRecord localactivityrecord, int i) {
        if(localactivityrecord.curState != 0 && localactivityrecord.curState != 5) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(localactivityrecord.curState == 1) {
            HashMap hashmap = mParent.getLastNonConfigurationChildInstances();
            Object obj = null;
            if(hashmap != null)
                obj = hashmap.get(localactivityrecord.id);
            Activity.NonConfigurationInstances nonconfigurationinstances = null;
            if(obj != null) {
                nonconfigurationinstances = new Activity.NonConfigurationInstances();
                nonconfigurationinstances.activity = obj;
            }
            if(localactivityrecord.activityInfo == null)
                localactivityrecord.activityInfo = mActivityThread.resolveActivityInfo(localactivityrecord.intent);
            localactivityrecord.activity = mActivityThread.startActivityNow(mParent, localactivityrecord.id, localactivityrecord.intent, localactivityrecord.activityInfo, localactivityrecord, localactivityrecord.instanceState, nonconfigurationinstances);
            if(localactivityrecord.activity != null) {
                localactivityrecord.window = localactivityrecord.activity.getWindow();
                localactivityrecord.instanceState = null;
                localactivityrecord.curState = 3;
                if(i == 4) {
                    mActivityThread.performResumeActivity(localactivityrecord, true);
                    localactivityrecord.curState = 4;
                }
            }
        } else {
            switch(localactivityrecord.curState) {
            default:
                break;

            case 2: // '\002'
                if(i == 3) {
                    mActivityThread.performRestartActivity(localactivityrecord);
                    localactivityrecord.curState = 3;
                }
                if(i == 4) {
                    mActivityThread.performRestartActivity(localactivityrecord);
                    mActivityThread.performResumeActivity(localactivityrecord, true);
                    localactivityrecord.curState = 4;
                }
                break;

            case 3: // '\003'
                if(i == 4) {
                    mActivityThread.performResumeActivity(localactivityrecord, true);
                    localactivityrecord.instanceState = null;
                    localactivityrecord.curState = 4;
                }
                if(i == 2) {
                    mActivityThread.performStopActivity(localactivityrecord, false);
                    localactivityrecord.curState = 2;
                }
                break;

            case 4: // '\004'
                if(i == 3) {
                    performPause(localactivityrecord, mFinishing);
                    localactivityrecord.curState = 3;
                }
                if(i == 2) {
                    performPause(localactivityrecord, mFinishing);
                    mActivityThread.performStopActivity(localactivityrecord, false);
                    localactivityrecord.curState = 2;
                }
                break;
            }
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private Window performDestroy(LocalActivityRecord localactivityrecord, boolean flag) {
        Window window = localactivityrecord.window;
        if(localactivityrecord.curState == 4 && !flag)
            performPause(localactivityrecord, flag);
        mActivityThread.performDestroyActivity(localactivityrecord, flag);
        localactivityrecord.activity = null;
        localactivityrecord.window = null;
        if(flag)
            localactivityrecord.instanceState = null;
        localactivityrecord.curState = 5;
        return window;
    }

    private void performPause(LocalActivityRecord localactivityrecord, boolean flag) {
        boolean flag1;
        Bundle bundle;
        if(localactivityrecord.instanceState == null)
            flag1 = true;
        else
            flag1 = false;
        bundle = mActivityThread.performPauseActivity(localactivityrecord, flag, flag1);
        if(flag1)
            localactivityrecord.instanceState = bundle;
    }

    public Window destroyActivity(String s, boolean flag) {
        LocalActivityRecord localactivityrecord = (LocalActivityRecord)mActivities.get(s);
        Window window = null;
        if(localactivityrecord != null) {
            window = performDestroy(localactivityrecord, flag);
            if(flag) {
                mActivities.remove(s);
                mActivityArray.remove(localactivityrecord);
            }
        }
        return window;
    }

    public void dispatchCreate(Bundle bundle) {
        if(bundle == null) goto _L2; else goto _L1
_L1:
        Iterator iterator = bundle.keySet().iterator();
_L3:
        String s;
        if(!iterator.hasNext())
            break; /* Loop/switch isn't completed */
        s = (String)iterator.next();
        Bundle bundle1 = bundle.getBundle(s);
        LocalActivityRecord localactivityrecord = (LocalActivityRecord)mActivities.get(s);
        Exception exception;
        if(localactivityrecord != null) {
            localactivityrecord.instanceState = bundle1;
            continue; /* Loop/switch isn't completed */
        }
        try {
            LocalActivityRecord localactivityrecord1 = new LocalActivityRecord(s, null);
            localactivityrecord1.instanceState = bundle1;
            mActivities.put(s, localactivityrecord1);
            mActivityArray.add(localactivityrecord1);
        }
        // Misplaced declaration of an exception variable
        catch(Exception exception) {
            Log.e("LocalActivityManager", "Exception thrown when restoring LocalActivityManager state", exception);
        }
        if(true) goto _L3; else goto _L2
_L2:
        mCurState = 2;
        return;
    }

    public void dispatchDestroy(boolean flag) {
        int i = mActivityArray.size();
        for(int j = 0; j < i; j++) {
            LocalActivityRecord localactivityrecord = (LocalActivityRecord)mActivityArray.get(j);
            mActivityThread.performDestroyActivity(localactivityrecord, flag);
        }

        mActivities.clear();
        mActivityArray.clear();
    }

    public void dispatchPause(boolean flag) {
        if(flag)
            mFinishing = true;
        mCurState = 3;
        if(mSingleMode) {
            if(mResumed != null)
                moveToState(mResumed, 3);
        } else {
            int i = mActivityArray.size();
            int j = 0;
            while(j < i)  {
                LocalActivityRecord localactivityrecord = (LocalActivityRecord)mActivityArray.get(j);
                if(localactivityrecord.curState == 4)
                    moveToState(localactivityrecord, 3);
                j++;
            }
        }
    }

    public void dispatchResume() {
        mCurState = 4;
        if(mSingleMode) {
            if(mResumed != null)
                moveToState(mResumed, 4);
        } else {
            int i = mActivityArray.size();
            int j = 0;
            while(j < i)  {
                moveToState((LocalActivityRecord)mActivityArray.get(j), 4);
                j++;
            }
        }
    }

    public HashMap dispatchRetainNonConfigurationInstance() {
        HashMap hashmap = null;
        int i = mActivityArray.size();
        for(int j = 0; j < i; j++) {
            LocalActivityRecord localactivityrecord = (LocalActivityRecord)mActivityArray.get(j);
            if(localactivityrecord == null || localactivityrecord.activity == null)
                continue;
            Object obj = localactivityrecord.activity.onRetainNonConfigurationInstance();
            if(obj == null)
                continue;
            if(hashmap == null)
                hashmap = new HashMap();
            hashmap.put(localactivityrecord.id, obj);
        }

        return hashmap;
    }

    public void dispatchStop() {
        mCurState = 2;
        int i = mActivityArray.size();
        for(int j = 0; j < i; j++)
            moveToState((LocalActivityRecord)mActivityArray.get(j), 2);

    }

    public Activity getActivity(String s) {
        LocalActivityRecord localactivityrecord = (LocalActivityRecord)mActivities.get(s);
        Activity activity;
        if(localactivityrecord != null)
            activity = localactivityrecord.activity;
        else
            activity = null;
        return activity;
    }

    public Activity getCurrentActivity() {
        Activity activity;
        if(mResumed != null)
            activity = mResumed.activity;
        else
            activity = null;
        return activity;
    }

    public String getCurrentId() {
        String s;
        if(mResumed != null)
            s = mResumed.id;
        else
            s = null;
        return s;
    }

    public void removeAllActivities() {
        dispatchDestroy(true);
    }

    public Bundle saveInstanceState() {
        Bundle bundle = null;
        int i = mActivityArray.size();
        for(int j = 0; j < i; j++) {
            LocalActivityRecord localactivityrecord = (LocalActivityRecord)mActivityArray.get(j);
            if(bundle == null)
                bundle = new Bundle();
            if((localactivityrecord.instanceState != null || localactivityrecord.curState == 4) && localactivityrecord.activity != null) {
                Bundle bundle1 = new Bundle();
                localactivityrecord.activity.performSaveInstanceState(bundle1);
                localactivityrecord.instanceState = bundle1;
            }
            if(localactivityrecord.instanceState != null)
                bundle.putBundle(localactivityrecord.id, localactivityrecord.instanceState);
        }

        return bundle;
    }

    public Window startActivity(String s, Intent intent) {
        boolean flag1;
        ActivityInfo activityinfo;
        LocalActivityRecord localactivityrecord;
        Window window;
        if(mCurState == 1)
            throw new IllegalStateException("Activities can't be added until the containing group has been created.");
        boolean flag = false;
        flag1 = false;
        activityinfo = null;
        localactivityrecord = (LocalActivityRecord)mActivities.get(s);
        if(localactivityrecord == null) {
            localactivityrecord = new LocalActivityRecord(s, intent);
            flag = true;
        } else
        if(localactivityrecord.intent != null) {
            flag1 = localactivityrecord.intent.filterEquals(intent);
            if(flag1)
                activityinfo = localactivityrecord.activityInfo;
        }
        if(activityinfo == null)
            activityinfo = mActivityThread.resolveActivityInfo(intent);
        if(mSingleMode) {
            LocalActivityRecord localactivityrecord1 = mResumed;
            if(localactivityrecord1 != null && localactivityrecord1 != localactivityrecord && mCurState == 4)
                moveToState(localactivityrecord1, 3);
        }
        if(!flag) goto _L2; else goto _L1
_L1:
        mActivities.put(s, localactivityrecord);
        mActivityArray.add(localactivityrecord);
_L6:
        localactivityrecord.intent = intent;
        localactivityrecord.curState = 1;
        localactivityrecord.activityInfo = activityinfo;
        moveToState(localactivityrecord, mCurState);
        if(mSingleMode)
            mResumed = localactivityrecord;
        window = localactivityrecord.window;
_L4:
        return window;
_L2:
        if(localactivityrecord.activityInfo == null)
            continue; /* Loop/switch isn't completed */
        if(activityinfo != localactivityrecord.activityInfo && (!((PackageItemInfo) (activityinfo)).name.equals(((PackageItemInfo) (localactivityrecord.activityInfo)).name) || !((PackageItemInfo) (activityinfo)).packageName.equals(((PackageItemInfo) (localactivityrecord.activityInfo)).packageName)))
            break; /* Loop/switch isn't completed */
        if(activityinfo.launchMode != 0 || (0x20000000 & intent.getFlags()) != 0) {
            ArrayList arraylist = new ArrayList(1);
            arraylist.add(intent);
            mActivityThread.performNewIntents(localactivityrecord, arraylist);
            localactivityrecord.intent = intent;
            moveToState(localactivityrecord, mCurState);
            if(mSingleMode)
                mResumed = localactivityrecord;
            window = localactivityrecord.window;
            continue; /* Loop/switch isn't completed */
        }
        if(!flag1 || (0x4000000 & intent.getFlags()) != 0)
            break; /* Loop/switch isn't completed */
        localactivityrecord.intent = intent;
        moveToState(localactivityrecord, mCurState);
        if(mSingleMode)
            mResumed = localactivityrecord;
        window = localactivityrecord.window;
        if(true) goto _L4; else goto _L3
_L3:
        performDestroy(localactivityrecord, true);
        if(true) goto _L6; else goto _L5
_L5:
    }

    static final int CREATED = 2;
    static final int DESTROYED = 5;
    static final int INITIALIZING = 1;
    static final int RESTORED = 0;
    static final int RESUMED = 4;
    static final int STARTED = 3;
    private static final String TAG = "LocalActivityManager";
    private static final boolean localLOGV;
    private final Map mActivities = new HashMap();
    private final ArrayList mActivityArray = new ArrayList();
    private final ActivityThread mActivityThread = ActivityThread.currentActivityThread();
    private int mCurState;
    private boolean mFinishing;
    private final Activity mParent;
    private LocalActivityRecord mResumed;
    private boolean mSingleMode;
}

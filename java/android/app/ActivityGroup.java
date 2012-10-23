// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.Intent;
import android.os.Bundle;
import java.util.HashMap;

// Referenced classes of package android.app:
//            Activity, LocalActivityManager

public class ActivityGroup extends Activity {

    public ActivityGroup() {
        this(true);
    }

    public ActivityGroup(boolean flag) {
        mLocalActivityManager = new LocalActivityManager(this, flag);
    }

    void dispatchActivityResult(String s, int i, int j, Intent intent) {
        if(s == null) goto _L2; else goto _L1
_L1:
        Activity activity = mLocalActivityManager.getActivity(s);
        if(activity == null) goto _L2; else goto _L3
_L3:
        activity.onActivityResult(i, j, intent);
_L5:
        return;
_L2:
        super.dispatchActivityResult(s, i, j, intent);
        if(true) goto _L5; else goto _L4
_L4:
    }

    public Activity getCurrentActivity() {
        return mLocalActivityManager.getCurrentActivity();
    }

    public final LocalActivityManager getLocalActivityManager() {
        return mLocalActivityManager;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle bundle1;
        if(bundle != null)
            bundle1 = bundle.getBundle("android:states");
        else
            bundle1 = null;
        mLocalActivityManager.dispatchCreate(bundle1);
    }

    protected void onDestroy() {
        super.onDestroy();
        mLocalActivityManager.dispatchDestroy(isFinishing());
    }

    protected void onPause() {
        super.onPause();
        mLocalActivityManager.dispatchPause(isFinishing());
    }

    protected void onResume() {
        super.onResume();
        mLocalActivityManager.dispatchResume();
    }

    public HashMap onRetainNonConfigurationChildInstances() {
        return mLocalActivityManager.dispatchRetainNonConfigurationInstance();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Bundle bundle1 = mLocalActivityManager.saveInstanceState();
        if(bundle1 != null)
            bundle.putBundle("android:states", bundle1);
    }

    protected void onStop() {
        super.onStop();
        mLocalActivityManager.dispatchStop();
    }

    static final String PARENT_NON_CONFIG_INSTANCE_KEY = "android:parent_non_config_instance";
    private static final String STATES_KEY = "android:states";
    protected LocalActivityManager mLocalActivityManager;
}

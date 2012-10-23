// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.*;
import android.content.pm.*;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;

// Referenced classes of package android.app:
//            Activity, PendingIntent

public class TaskStackBuilder {

    private TaskStackBuilder(Context context) {
        mSourceContext = context;
    }

    public static TaskStackBuilder create(Context context) {
        return new TaskStackBuilder(context);
    }

    public TaskStackBuilder addNextIntent(Intent intent) {
        mIntents.add(intent);
        return this;
    }

    public TaskStackBuilder addNextIntentWithParentStack(Intent intent) {
        ComponentName componentname = intent.getComponent();
        if(componentname == null)
            componentname = intent.resolveActivity(mSourceContext.getPackageManager());
        if(componentname != null)
            addParentStack(componentname);
        addNextIntent(intent);
        return this;
    }

    public TaskStackBuilder addParentStack(Activity activity) {
        int i = mIntents.size();
        Intent intent = activity.getParentActivityIntent();
        PackageManager packagemanager = activity.getPackageManager();
label0:
        do {
label1:
            {
                if(intent == null)
                    break label0;
                mIntents.add(i, intent);
                Intent intent1;
                try {
                    String s = packagemanager.getActivityInfo(intent.getComponent(), 0).parentActivityName;
                    if(s == null)
                        break label1;
                    intent1 = (new Intent()).setComponent(new ComponentName(mSourceContext, s));
                }
                catch(android.content.pm.PackageManager.NameNotFoundException namenotfoundexception) {
                    Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                    throw new IllegalArgumentException(namenotfoundexception);
                }
                intent = intent1;
                continue;
            }
            intent = null;
        } while(true);
        return this;
    }

    public TaskStackBuilder addParentStack(ComponentName componentname) {
        int i = mIntents.size();
        PackageManager packagemanager = mSourceContext.getPackageManager();
        try {
            ActivityInfo activityinfo = packagemanager.getActivityInfo(componentname, 0);
            for(String s = activityinfo.parentActivityName; s != null; s = activityinfo.parentActivityName) {
                Intent intent = (new Intent()).setComponent(new ComponentName(((PackageItemInfo) (activityinfo)).packageName, s));
                mIntents.add(i, intent);
                activityinfo = packagemanager.getActivityInfo(intent.getComponent(), 0);
            }

        }
        catch(android.content.pm.PackageManager.NameNotFoundException namenotfoundexception) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(namenotfoundexception);
        }
        return this;
    }

    public TaskStackBuilder addParentStack(Class class1) {
        int i = mIntents.size();
        PackageManager packagemanager = mSourceContext.getPackageManager();
        try {
            Intent intent;
            for(String s = packagemanager.getActivityInfo(new ComponentName(mSourceContext, class1), 0).parentActivityName; s != null; s = packagemanager.getActivityInfo(intent.getComponent(), 0).parentActivityName) {
                intent = (new Intent()).setComponent(new ComponentName(mSourceContext, s));
                mIntents.add(i, intent);
            }

        }
        catch(android.content.pm.PackageManager.NameNotFoundException namenotfoundexception) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(namenotfoundexception);
        }
        return this;
    }

    public Intent editIntentAt(int i) {
        return (Intent)mIntents.get(i);
    }

    public int getIntentCount() {
        return mIntents.size();
    }

    public Intent[] getIntents() {
        return (Intent[])mIntents.toArray(new Intent[mIntents.size()]);
    }

    public PendingIntent getPendingIntent(int i, int j) {
        return getPendingIntent(i, j, null);
    }

    public PendingIntent getPendingIntent(int i, int j, Bundle bundle) {
        if(mIntents.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
        } else {
            Intent aintent[] = (Intent[])mIntents.toArray(new Intent[mIntents.size()]);
            aintent[0].addFlags(0x1000c000);
            return PendingIntent.getActivities(mSourceContext, i, aintent, j, bundle);
        }
    }

    public void startActivities() {
        startActivities(null);
    }

    public void startActivities(Bundle bundle) {
        if(mIntents.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        } else {
            Intent aintent[] = (Intent[])mIntents.toArray(new Intent[mIntents.size()]);
            aintent[0].addFlags(0x1000c000);
            mSourceContext.startActivities(aintent, bundle);
            return;
        }
    }

    private static final String TAG = "TaskStackBuilder";
    private final ArrayList mIntents = new ArrayList();
    private final Context mSourceContext;
}

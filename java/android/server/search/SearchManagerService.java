// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.server.search;

import android.app.SearchableInfo;
import android.content.*;
import android.database.ContentObserver;
import android.os.Process;
import android.util.Log;
import com.android.internal.content.PackageMonitor;
import java.util.List;

// Referenced classes of package android.server.search:
//            Searchables

public class SearchManagerService extends android.app.ISearchManager.Stub {
    class GlobalSearchProviderObserver extends ContentObserver {

        public void onChange(boolean flag) {
            getSearchables().buildSearchableList();
            Intent intent = new Intent("android.search.action.GLOBAL_SEARCH_ACTIVITY_CHANGED");
            intent.addFlags(0x20000000);
            mContext.sendBroadcast(intent);
        }

        private final ContentResolver mResolver;
        final SearchManagerService this$0;

        public GlobalSearchProviderObserver(ContentResolver contentresolver) {
            this$0 = SearchManagerService.this;
            super(null);
            mResolver = contentresolver;
            mResolver.registerContentObserver(android.provider.Settings.Secure.getUriFor("search_global_search_activity"), false, this);
        }
    }

    class MyPackageMonitor extends PackageMonitor {

        private void updateSearchables() {
            getSearchables().buildSearchableList();
            Intent intent = new Intent("android.search.action.SEARCHABLES_CHANGED");
            intent.addFlags(0x20000000);
            mContext.sendBroadcast(intent);
        }

        public void onPackageModified(String s) {
            updateSearchables();
        }

        public void onSomePackagesChanged() {
            updateSearchables();
        }

        final SearchManagerService this$0;

        MyPackageMonitor() {
            this$0 = SearchManagerService.this;
            super();
        }
    }

    private final class BootCompletedReceiver extends BroadcastReceiver {

        public void onReceive(Context context, Intent intent) {
            (new Thread() {

                public void run() {
                    Process.setThreadPriority(10);
                    mContext.unregisterReceiver(BootCompletedReceiver.this);
                    getSearchables();
                }

                final BootCompletedReceiver this$1;

                 {
                    this$1 = BootCompletedReceiver.this;
                    super();
                }
            }).start();
        }

        final SearchManagerService this$0;

        private BootCompletedReceiver() {
            this$0 = SearchManagerService.this;
            super();
        }

    }


    public SearchManagerService(Context context) {
        mContext = context;
        mContext.registerReceiver(new BootCompletedReceiver(), new IntentFilter("android.intent.action.BOOT_COMPLETED"));
        mGlobalSearchObserver = new GlobalSearchProviderObserver(mContext.getContentResolver());
    }

    /**
     * @deprecated Method getSearchables is deprecated
     */

    private Searchables getSearchables() {
        this;
        JVM INSTR monitorenter ;
        Searchables searchables;
        if(mSearchables == null) {
            Log.i("SearchManagerService", "Building list of searchable activities");
            (new MyPackageMonitor()).register(mContext, null, true);
            mSearchables = new Searchables(mContext);
            mSearchables.buildSearchableList();
        }
        searchables = mSearchables;
        this;
        JVM INSTR monitorexit ;
        return searchables;
        Exception exception;
        exception;
        throw exception;
    }

    public List getGlobalSearchActivities() {
        return getSearchables().getGlobalSearchActivities();
    }

    public ComponentName getGlobalSearchActivity() {
        return getSearchables().getGlobalSearchActivity();
    }

    public SearchableInfo getSearchableInfo(ComponentName componentname) {
        SearchableInfo searchableinfo;
        if(componentname == null) {
            Log.e("SearchManagerService", "getSearchableInfo(), activity == null");
            searchableinfo = null;
        } else {
            searchableinfo = getSearchables().getSearchableInfo(componentname);
        }
        return searchableinfo;
    }

    public List getSearchablesInGlobalSearch() {
        return getSearchables().getSearchablesInGlobalSearchList();
    }

    public ComponentName getWebSearchActivity() {
        return getSearchables().getWebSearchActivity();
    }

    private static final String TAG = "SearchManagerService";
    private final Context mContext;
    private ContentObserver mGlobalSearchObserver;
    private Searchables mSearchables;


}

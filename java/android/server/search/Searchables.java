// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.server.search;

import android.app.SearchableInfo;
import android.content.*;
import android.content.pm.*;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.*;

public class Searchables {

    public Searchables(Context context) {
        mSearchablesMap = null;
        mSearchablesList = null;
        mSearchablesInGlobalSearchList = null;
        mCurrentGlobalSearchActivity = null;
        mWebSearchActivity = null;
        mContext = context;
    }

    private List findGlobalSearchActivities() {
        Intent intent = new Intent("android.search.action.GLOBAL_SEARCH");
        List list = mContext.getPackageManager().queryIntentActivities(intent, 0x10000);
        if(list != null && !list.isEmpty())
            Collections.sort(list, GLOBAL_SEARCH_RANKER);
        return list;
    }

    private ComponentName findGlobalSearchActivity(List list) {
        String s = getGlobalSearchProviderSetting();
        if(TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        ComponentName componentname = ComponentName.unflattenFromString(s);
        if(componentname == null || !isInstalled(componentname)) goto _L2; else goto _L3
_L3:
        return componentname;
_L2:
        componentname = getDefaultGlobalSearchProvider(list);
        if(true) goto _L3; else goto _L4
_L4:
    }

    private ComponentName findWebSearchActivity(ComponentName componentname) {
        ComponentName componentname1 = null;
        if(componentname != null) {
            Intent intent = new Intent("android.intent.action.WEB_SEARCH");
            intent.setPackage(componentname.getPackageName());
            List list = mContext.getPackageManager().queryIntentActivities(intent, 0x10000);
            if(list != null && !list.isEmpty()) {
                android.content.pm.ActivityInfo activityinfo = ((ResolveInfo)list.get(0)).activityInfo;
                componentname1 = new ComponentName(((PackageItemInfo) (activityinfo)).packageName, ((PackageItemInfo) (activityinfo)).name);
            } else {
                Log.w("Searchables", "No web search activity found");
            }
        }
        return componentname1;
    }

    private ComponentName getDefaultGlobalSearchProvider(List list) {
        ComponentName componentname;
        if(list != null && !list.isEmpty()) {
            android.content.pm.ActivityInfo activityinfo = ((ResolveInfo)list.get(0)).activityInfo;
            componentname = new ComponentName(((PackageItemInfo) (activityinfo)).packageName, ((PackageItemInfo) (activityinfo)).name);
        } else {
            Log.w("Searchables", "No global search activity found");
            componentname = null;
        }
        return componentname;
    }

    private String getGlobalSearchProviderSetting() {
        return android.provider.Settings.Secure.getString(mContext.getContentResolver(), "search_global_search_activity");
    }

    private boolean isInstalled(ComponentName componentname) {
        Intent intent = new Intent("android.search.action.GLOBAL_SEARCH");
        intent.setComponent(componentname);
        List list = mContext.getPackageManager().queryIntentActivities(intent, 0x10000);
        boolean flag;
        if(list != null && !list.isEmpty())
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static final boolean isSystemApp(ResolveInfo resolveinfo) {
        boolean flag;
        if((1 & ((ComponentInfo) (resolveinfo.activityInfo)).applicationInfo.flags) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void buildSearchableList() {
        HashMap hashmap;
        ArrayList arraylist;
        ArrayList arraylist1;
        List list2;
        ComponentName componentname;
        hashmap = new HashMap();
        arraylist = new ArrayList();
        arraylist1 = new ArrayList();
        PackageManager packagemanager = mContext.getPackageManager();
        List list = packagemanager.queryIntentActivities(new Intent("android.intent.action.SEARCH"), 128);
        Intent intent = new Intent("android.intent.action.WEB_SEARCH");
        List list1 = packagemanager.queryIntentActivities(intent, 128);
        if(list != null || list1 != null) {
            int i;
            int j;
            int k;
            int l;
            if(list == null)
                i = 0;
            else
                i = list.size();
            if(list1 == null)
                j = 0;
            else
                j = list1.size();
            k = i + j;
            l = 0;
            while(l < k)  {
                ResolveInfo resolveinfo;
                android.content.pm.ActivityInfo activityinfo;
                SearchableInfo searchableinfo;
                if(l < i)
                    resolveinfo = (ResolveInfo)list.get(l);
                else
                    resolveinfo = (ResolveInfo)list1.get(l - i);
                activityinfo = resolveinfo.activityInfo;
                if(hashmap.get(new ComponentName(((PackageItemInfo) (activityinfo)).packageName, ((PackageItemInfo) (activityinfo)).name)) != null)
                    continue;
                searchableinfo = SearchableInfo.getActivityMetaData(mContext, activityinfo);
                if(searchableinfo == null)
                    continue;
                arraylist.add(searchableinfo);
                hashmap.put(searchableinfo.getSearchActivity(), searchableinfo);
                if(searchableinfo.shouldIncludeInGlobalSearch())
                    arraylist1.add(searchableinfo);
                l++;
            }
        }
        list2 = findGlobalSearchActivities();
        componentname = findGlobalSearchActivity(list2);
        ComponentName componentname1 = findWebSearchActivity(componentname);
        this;
        JVM INSTR monitorenter ;
        mSearchablesMap = hashmap;
        mSearchablesList = arraylist;
        mSearchablesInGlobalSearchList = arraylist1;
        mGlobalSearchActivities = list2;
        mCurrentGlobalSearchActivity = componentname;
        mWebSearchActivity = componentname1;
        return;
    }

    /**
     * @deprecated Method getGlobalSearchActivities is deprecated
     */

    public ArrayList getGlobalSearchActivities() {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist = new ArrayList(mGlobalSearchActivities);
        this;
        JVM INSTR monitorexit ;
        return arraylist;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getGlobalSearchActivity is deprecated
     */

    public ComponentName getGlobalSearchActivity() {
        this;
        JVM INSTR monitorenter ;
        ComponentName componentname = mCurrentGlobalSearchActivity;
        this;
        JVM INSTR monitorexit ;
        return componentname;
        Exception exception;
        exception;
        throw exception;
    }

    public SearchableInfo getSearchableInfo(ComponentName componentname) {
        this;
        JVM INSTR monitorenter ;
        SearchableInfo searchableinfo = (SearchableInfo)mSearchablesMap.get(componentname);
        if(searchableinfo == null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        SearchableInfo searchableinfo1 = searchableinfo;
          goto _L3
_L2:
        this;
        JVM INSTR monitorexit ;
        String s;
        android.content.pm.ActivityInfo activityinfo = mContext.getPackageManager().getActivityInfo(componentname, 128);
        s = null;
        Bundle bundle = ((PackageItemInfo) (activityinfo)).metaData;
        if(bundle != null)
            s = bundle.getString("android.app.default_searchable");
        if(s == null) {
            Bundle bundle1 = ((PackageItemInfo) (((ComponentInfo) (activityinfo)).applicationInfo)).metaData;
            if(bundle1 != null)
                s = bundle1.getString("android.app.default_searchable");
        }
        if(s == null) goto _L5; else goto _L4
_L4:
        boolean flag = s.equals("*");
        if(!flag) goto _L7; else goto _L6
_L6:
        searchableinfo1 = null;
          goto _L3
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L7:
        String s1 = componentname.getPackageName();
        if(s.charAt(0) != '.') goto _L9; else goto _L8
_L8:
        ComponentName componentname1 = new ComponentName(s1, (new StringBuilder()).append(s1).append(s).toString());
_L12:
        this;
        JVM INSTR monitorenter ;
        SearchableInfo searchableinfo2 = (SearchableInfo)mSearchablesMap.get(componentname1);
        if(searchableinfo2 == null) goto _L11; else goto _L10
_L10:
        mSearchablesMap.put(componentname, searchableinfo2);
        this;
        JVM INSTR monitorexit ;
        searchableinfo1 = searchableinfo2;
          goto _L3
_L9:
        componentname1 = new ComponentName(s1, s);
          goto _L12
_L11:
        this;
        JVM INSTR monitorexit ;
          goto _L5
        Exception exception1;
        exception1;
        try {
            throw exception1;
        }
        catch(android.content.pm.PackageManager.NameNotFoundException namenotfoundexception) { }
          goto _L5
_L3:
        return searchableinfo1;
_L5:
        searchableinfo1 = null;
        if(true) goto _L3; else goto _L13
_L13:
    }

    /**
     * @deprecated Method getSearchablesInGlobalSearchList is deprecated
     */

    public ArrayList getSearchablesInGlobalSearchList() {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist = new ArrayList(mSearchablesInGlobalSearchList);
        this;
        JVM INSTR monitorexit ;
        return arraylist;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getSearchablesList is deprecated
     */

    public ArrayList getSearchablesList() {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist = new ArrayList(mSearchablesList);
        this;
        JVM INSTR monitorexit ;
        return arraylist;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getWebSearchActivity is deprecated
     */

    public ComponentName getWebSearchActivity() {
        this;
        JVM INSTR monitorenter ;
        ComponentName componentname = mWebSearchActivity;
        this;
        JVM INSTR monitorexit ;
        return componentname;
        Exception exception;
        exception;
        throw exception;
    }

    public static String ENHANCED_GOOGLE_SEARCH_COMPONENT_NAME = "com.google.android.providers.enhancedgooglesearch/.Launcher";
    private static final Comparator GLOBAL_SEARCH_RANKER = new Comparator() {

        public int compare(ResolveInfo resolveinfo, ResolveInfo resolveinfo1) {
            int i;
            if(resolveinfo == resolveinfo1) {
                i = 0;
            } else {
                boolean flag = Searchables.isSystemApp(resolveinfo);
                boolean flag1 = Searchables.isSystemApp(resolveinfo1);
                if(flag && !flag1)
                    i = -1;
                else
                if(flag1 && !flag)
                    i = 1;
                else
                    i = resolveinfo1.priority - resolveinfo.priority;
            }
            return i;
        }

        public volatile int compare(Object obj, Object obj1) {
            return compare((ResolveInfo)obj, (ResolveInfo)obj1);
        }

    };
    public static String GOOGLE_SEARCH_COMPONENT_NAME = "com.android.googlesearch/.GoogleSearch";
    private static final String LOG_TAG = "Searchables";
    private static final String MD_LABEL_DEFAULT_SEARCHABLE = "android.app.default_searchable";
    private static final String MD_SEARCHABLE_SYSTEM_SEARCH = "*";
    private Context mContext;
    private ComponentName mCurrentGlobalSearchActivity;
    private List mGlobalSearchActivities;
    private ArrayList mSearchablesInGlobalSearchList;
    private ArrayList mSearchablesList;
    private HashMap mSearchablesMap;
    private ComponentName mWebSearchActivity;


}

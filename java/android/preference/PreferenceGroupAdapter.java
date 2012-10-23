// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.preference;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.*;

// Referenced classes of package android.preference:
//            PreferenceGroup, Preference

class PreferenceGroupAdapter extends BaseAdapter
    implements Preference.OnPreferenceChangeInternalListener {
    private static class PreferenceLayout
        implements Comparable {

        public int compareTo(PreferenceLayout preferencelayout) {
            int i = name.compareTo(preferencelayout.name);
            if(i == 0)
                if(resId == preferencelayout.resId) {
                    if(widgetResId == preferencelayout.widgetResId)
                        i = 0;
                    else
                        i = widgetResId - preferencelayout.widgetResId;
                } else {
                    i = resId - preferencelayout.resId;
                }
            return i;
        }

        public volatile int compareTo(Object obj) {
            return compareTo((PreferenceLayout)obj);
        }

        private String name;
        private int resId;
        private int widgetResId;


/*
        static String access$202(PreferenceLayout preferencelayout, String s) {
            preferencelayout.name = s;
            return s;
        }

*/


/*
        static int access$302(PreferenceLayout preferencelayout, int i) {
            preferencelayout.resId = i;
            return i;
        }

*/


/*
        static int access$402(PreferenceLayout preferencelayout, int i) {
            preferencelayout.widgetResId = i;
            return i;
        }

*/

        private PreferenceLayout() {
        }

    }


    public PreferenceGroupAdapter(PreferenceGroup preferencegroup) {
        mTempPreferenceLayout = new PreferenceLayout();
        mHasReturnedViewTypeCount = false;
        mIsSyncing = false;
        mHandler = new Handler();
        mSyncRunnable = new Runnable() {

            public void run() {
                syncMyPreferences();
            }

            final PreferenceGroupAdapter this$0;

             {
                this$0 = PreferenceGroupAdapter.this;
                super();
            }
        };
        mPreferenceGroup = preferencegroup;
        mPreferenceGroup.setOnPreferenceChangeInternalListener(this);
        mPreferenceList = new ArrayList();
        mPreferenceLayouts = new ArrayList();
        syncMyPreferences();
    }

    private void addPreferenceClassName(Preference preference) {
        PreferenceLayout preferencelayout = createPreferenceLayout(preference, null);
        int i = Collections.binarySearch(mPreferenceLayouts, preferencelayout);
        if(i < 0) {
            int j = -1 + i * -1;
            mPreferenceLayouts.add(j, preferencelayout);
        }
    }

    private PreferenceLayout createPreferenceLayout(Preference preference, PreferenceLayout preferencelayout) {
        PreferenceLayout preferencelayout1;
        if(preferencelayout != null)
            preferencelayout1 = preferencelayout;
        else
            preferencelayout1 = new PreferenceLayout();
        preferencelayout1.name = preference.getClass().getName();
        preferencelayout1.resId = preference.getLayoutResource();
        preferencelayout1.widgetResId = preference.getWidgetLayoutResource();
        return preferencelayout1;
    }

    private void flattenPreferenceGroup(List list, PreferenceGroup preferencegroup) {
        preferencegroup.sortPreferences();
        int i = preferencegroup.getPreferenceCount();
        for(int j = 0; j < i; j++) {
            Preference preference = preferencegroup.getPreference(j);
            list.add(preference);
            if(!mHasReturnedViewTypeCount && !preference.hasSpecifiedLayout())
                addPreferenceClassName(preference);
            if(preference instanceof PreferenceGroup) {
                PreferenceGroup preferencegroup1 = (PreferenceGroup)preference;
                if(preferencegroup1.isOnSameScreenAsChildren())
                    flattenPreferenceGroup(list, preferencegroup1);
            }
            preference.setOnPreferenceChangeInternalListener(this);
        }

    }

    private void syncMyPreferences() {
        this;
        JVM INSTR monitorenter ;
        if(!mIsSyncing)
            break MISSING_BLOCK_LABEL_14;
        this;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_82;
        mIsSyncing = true;
        this;
        JVM INSTR monitorexit ;
        ArrayList arraylist = new ArrayList(mPreferenceList.size());
        flattenPreferenceGroup(arraylist, mPreferenceGroup);
        mPreferenceList = arraylist;
        notifyDataSetChanged();
        this;
        JVM INSTR monitorenter ;
        mIsSyncing = false;
        notifyAll();
        break MISSING_BLOCK_LABEL_82;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean areAllItemsEnabled() {
        return false;
    }

    public int getCount() {
        return mPreferenceList.size();
    }

    public Preference getItem(int i) {
        Preference preference;
        if(i < 0 || i >= getCount())
            preference = null;
        else
            preference = (Preference)mPreferenceList.get(i);
        return preference;
    }

    public volatile Object getItem(int i) {
        return getItem(i);
    }

    public long getItemId(int i) {
        long l;
        if(i < 0 || i >= getCount())
            l = 0x8000000000000000L;
        else
            l = getItem(i).getId();
        return l;
    }

    public int getItemViewType(int i) {
        Preference preference;
        if(!mHasReturnedViewTypeCount)
            mHasReturnedViewTypeCount = true;
        preference = getItem(i);
        if(!preference.hasSpecifiedLayout()) goto _L2; else goto _L1
_L1:
        int j = -1;
_L4:
        return j;
_L2:
        mTempPreferenceLayout = createPreferenceLayout(preference, mTempPreferenceLayout);
        j = Collections.binarySearch(mPreferenceLayouts, mTempPreferenceLayout);
        if(j < 0)
            j = -1;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public View getView(int i, View view, ViewGroup viewgroup) {
        Preference preference = getItem(i);
        mTempPreferenceLayout = createPreferenceLayout(preference, mTempPreferenceLayout);
        if(Collections.binarySearch(mPreferenceLayouts, mTempPreferenceLayout) < 0)
            view = null;
        return preference.getView(view, viewgroup);
    }

    public int getViewTypeCount() {
        if(!mHasReturnedViewTypeCount)
            mHasReturnedViewTypeCount = true;
        return Math.max(1, mPreferenceLayouts.size());
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isEnabled(int i) {
        boolean flag;
        if(i < 0 || i >= getCount())
            flag = true;
        else
            flag = getItem(i).isSelectable();
        return flag;
    }

    public void onPreferenceChange(Preference preference) {
        notifyDataSetChanged();
    }

    public void onPreferenceHierarchyChange(Preference preference) {
        mHandler.removeCallbacks(mSyncRunnable);
        mHandler.post(mSyncRunnable);
    }

    private static final String TAG = "PreferenceGroupAdapter";
    private Handler mHandler;
    private boolean mHasReturnedViewTypeCount;
    private volatile boolean mIsSyncing;
    private PreferenceGroup mPreferenceGroup;
    private ArrayList mPreferenceLayouts;
    private List mPreferenceList;
    private Runnable mSyncRunnable;
    private PreferenceLayout mTempPreferenceLayout;

}

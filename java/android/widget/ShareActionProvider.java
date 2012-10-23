// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.*;

// Referenced classes of package android.widget:
//            ActivityChooserModel, ActivityChooserView

public class ShareActionProvider extends ActionProvider {
    private class ShareAcitivityChooserModelPolicy
        implements ActivityChooserModel.OnChooseActivityListener {

        public boolean onChooseActivity(ActivityChooserModel activitychoosermodel, Intent intent) {
            if(mOnShareTargetSelectedListener != null)
                mOnShareTargetSelectedListener.onShareTargetSelected(ShareActionProvider.this, intent);
            return false;
        }

        final ShareActionProvider this$0;

        private ShareAcitivityChooserModelPolicy() {
            this$0 = ShareActionProvider.this;
            super();
        }

    }

    private class ShareMenuItemOnMenuItemClickListener
        implements android.view.MenuItem.OnMenuItemClickListener {

        public boolean onMenuItemClick(MenuItem menuitem) {
            Intent intent = ActivityChooserModel.get(mContext, mShareHistoryFileName).chooseActivity(menuitem.getItemId());
            if(intent != null) {
                intent.addFlags(0x80000);
                mContext.startActivity(intent);
            }
            return true;
        }

        final ShareActionProvider this$0;

        private ShareMenuItemOnMenuItemClickListener() {
            this$0 = ShareActionProvider.this;
            super();
        }

    }

    public static interface OnShareTargetSelectedListener {

        public abstract boolean onShareTargetSelected(ShareActionProvider shareactionprovider, Intent intent);
    }


    public ShareActionProvider(Context context) {
        super(context);
        mMaxShownActivityCount = 4;
        mShareHistoryFileName = "share_history.xml";
        mContext = context;
    }

    private void setActivityChooserPolicyIfNeeded() {
        if(mOnShareTargetSelectedListener != null) {
            if(mOnChooseActivityListener == null)
                mOnChooseActivityListener = new ShareAcitivityChooserModelPolicy();
            ActivityChooserModel.get(mContext, mShareHistoryFileName).setOnChooseActivityListener(mOnChooseActivityListener);
        }
    }

    public boolean hasSubMenu() {
        return true;
    }

    public View onCreateActionView() {
        ActivityChooserModel activitychoosermodel = ActivityChooserModel.get(mContext, mShareHistoryFileName);
        ActivityChooserView activitychooserview = new ActivityChooserView(mContext);
        activitychooserview.setActivityChooserModel(activitychoosermodel);
        TypedValue typedvalue = new TypedValue();
        mContext.getTheme().resolveAttribute(0x10103c5, typedvalue, true);
        activitychooserview.setExpandActivityOverflowButtonDrawable(mContext.getResources().getDrawable(typedvalue.resourceId));
        activitychooserview.setProvider(this);
        activitychooserview.setDefaultActionButtonContentDescription(0x10404c2);
        activitychooserview.setExpandActivityOverflowButtonContentDescription(0x10404c1);
        return activitychooserview;
    }

    public void onPrepareSubMenu(SubMenu submenu) {
        submenu.clear();
        ActivityChooserModel activitychoosermodel = ActivityChooserModel.get(mContext, mShareHistoryFileName);
        android.content.pm.PackageManager packagemanager = mContext.getPackageManager();
        int i = activitychoosermodel.getActivityCount();
        int j = Math.min(i, mMaxShownActivityCount);
        for(int k = 0; k < j; k++) {
            ResolveInfo resolveinfo1 = activitychoosermodel.getActivity(k);
            submenu.add(0, k, k, resolveinfo1.loadLabel(packagemanager)).setIcon(resolveinfo1.loadIcon(packagemanager)).setOnMenuItemClickListener(mOnMenuItemClickListener);
        }

        if(j < i) {
            SubMenu submenu1 = submenu.addSubMenu(0, j, j, mContext.getString(0x10404f3));
            for(int l = 0; l < i; l++) {
                ResolveInfo resolveinfo = activitychoosermodel.getActivity(l);
                submenu1.add(0, l, l, resolveinfo.loadLabel(packagemanager)).setIcon(resolveinfo.loadIcon(packagemanager)).setOnMenuItemClickListener(mOnMenuItemClickListener);
            }

        }
    }

    public void setOnShareTargetSelectedListener(OnShareTargetSelectedListener onsharetargetselectedlistener) {
        mOnShareTargetSelectedListener = onsharetargetselectedlistener;
        setActivityChooserPolicyIfNeeded();
    }

    public void setShareHistoryFileName(String s) {
        mShareHistoryFileName = s;
        setActivityChooserPolicyIfNeeded();
    }

    public void setShareIntent(Intent intent) {
        ActivityChooserModel.get(mContext, mShareHistoryFileName).setIntent(intent);
    }

    private static final int DEFAULT_INITIAL_ACTIVITY_COUNT = 4;
    public static final String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";
    private final Context mContext;
    private int mMaxShownActivityCount;
    private ActivityChooserModel.OnChooseActivityListener mOnChooseActivityListener;
    private final ShareMenuItemOnMenuItemClickListener mOnMenuItemClickListener = new ShareMenuItemOnMenuItemClickListener();
    private OnShareTargetSelectedListener mOnShareTargetSelectedListener;
    private String mShareHistoryFileName;



}

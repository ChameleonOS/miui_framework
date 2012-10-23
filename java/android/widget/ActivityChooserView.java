// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.*;

// Referenced classes of package android.widget:
//            LinearLayout, FrameLayout, ImageView, ListPopupWindow, 
//            ListView, ActivityChooserModel, BaseAdapter, TextView, 
//            AdapterView

public class ActivityChooserView extends ViewGroup
    implements ActivityChooserModel.ActivityChooserModelClient {
    private class ActivityChooserViewAdapter extends BaseAdapter {

        public int getActivityCount() {
            return mDataModel.getActivityCount();
        }

        public int getCount() {
            int i = mDataModel.getActivityCount();
            if(!mShowDefaultActivity && mDataModel.getDefaultActivity() != null)
                i--;
            int j = Math.min(i, mMaxActivityCount);
            if(mShowFooterView)
                j++;
            return j;
        }

        public ActivityChooserModel getDataModel() {
            return mDataModel;
        }

        public ResolveInfo getDefaultActivity() {
            return mDataModel.getDefaultActivity();
        }

        public int getHistorySize() {
            return mDataModel.getHistorySize();
        }

        public Object getItem(int i) {
            getItemViewType(i);
            JVM INSTR tableswitch 0 1: default 28
        //                       0 40
        //                       1 36;
               goto _L1 _L2 _L3
_L1:
            throw new IllegalArgumentException();
_L3:
            ResolveInfo resolveinfo = null;
_L5:
            return resolveinfo;
_L2:
            if(!mShowDefaultActivity && mDataModel.getDefaultActivity() != null)
                i++;
            resolveinfo = mDataModel.getActivity(i);
            if(true) goto _L5; else goto _L4
_L4:
        }

        public long getItemId(int i) {
            return (long)i;
        }

        public int getItemViewType(int i) {
            int j;
            if(mShowFooterView && i == -1 + getCount())
                j = 1;
            else
                j = 0;
            return j;
        }

        public int getMaxActivityCount() {
            return mMaxActivityCount;
        }

        public boolean getShowDefaultActivity() {
            return mShowDefaultActivity;
        }

        public View getView(int i, View view, ViewGroup viewgroup) {
            getItemViewType(i);
            JVM INSTR tableswitch 0 1: default 28
        //                       0 101
        //                       1 36;
               goto _L1 _L2 _L3
_L1:
            throw new IllegalArgumentException();
_L3:
            View view1;
            if(view == null || view.getId() != 1) {
                view = LayoutInflater.from(getContext()).inflate(0x109001f, viewgroup, false);
                view.setId(1);
                ((TextView)view.findViewById(0x1020016)).setText(.getString(0x10404f3));
            }
            view1 = view;
_L5:
            return view1;
_L2:
            if(view == null || view.getId() != 0x1020249)
                view = LayoutInflater.from(getContext()).inflate(0x109001f, viewgroup, false);
            android.content.pm.PackageManager packagemanager = .getPackageManager();
            ImageView imageview = (ImageView)view.findViewById(0x1020006);
            ResolveInfo resolveinfo = (ResolveInfo)getItem(i);
            imageview.setImageDrawable(resolveinfo.loadIcon(packagemanager));
            ((TextView)view.findViewById(0x1020016)).setText(resolveinfo.loadLabel(packagemanager));
            if(mShowDefaultActivity && i == 0 && mHighlightDefaultActivity)
                view.setActivated(true);
            else
                view.setActivated(false);
            view1 = view;
            if(true) goto _L5; else goto _L4
_L4:
        }

        public int getViewTypeCount() {
            return 3;
        }

        public int measureContentWidth() {
            int i = mMaxActivityCount;
            mMaxActivityCount = 0x7fffffff;
            int j = 0;
            View view = null;
            int k = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
            int l = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
            int i1 = getCount();
            for(int j1 = 0; j1 < i1; j1++) {
                view = getView(j1, view, null);
                view.measure(k, l);
                j = Math.max(j, view.getMeasuredWidth());
            }

            mMaxActivityCount = i;
            return j;
        }

        public void setDataModel(ActivityChooserModel activitychoosermodel) {
            ActivityChooserModel activitychoosermodel1 = mAdapter.getDataModel();
            if(activitychoosermodel1 != null && isShown())
                activitychoosermodel1.unregisterObserver(mModelDataSetOberver);
            mDataModel = activitychoosermodel;
            if(activitychoosermodel != null && isShown())
                activitychoosermodel.registerObserver(mModelDataSetOberver);
            notifyDataSetChanged();
        }

        public void setMaxActivityCount(int i) {
            if(mMaxActivityCount != i) {
                mMaxActivityCount = i;
                notifyDataSetChanged();
            }
        }

        public void setShowDefaultActivity(boolean flag, boolean flag1) {
            if(mShowDefaultActivity != flag || mHighlightDefaultActivity != flag1) {
                mShowDefaultActivity = flag;
                mHighlightDefaultActivity = flag1;
                notifyDataSetChanged();
            }
        }

        public void setShowFooterView(boolean flag) {
            if(mShowFooterView != flag) {
                mShowFooterView = flag;
                notifyDataSetChanged();
            }
        }

        private static final int ITEM_VIEW_TYPE_ACTIVITY = 0;
        private static final int ITEM_VIEW_TYPE_COUNT = 3;
        private static final int ITEM_VIEW_TYPE_FOOTER = 1;
        public static final int MAX_ACTIVITY_COUNT_DEFAULT = 4;
        public static final int MAX_ACTIVITY_COUNT_UNLIMITED = 0x7fffffff;
        private ActivityChooserModel mDataModel;
        private boolean mHighlightDefaultActivity;
        private int mMaxActivityCount;
        private boolean mShowDefaultActivity;
        private boolean mShowFooterView;
        final ActivityChooserView this$0;

        private ActivityChooserViewAdapter() {
            this$0 = ActivityChooserView.this;
            super();
            mMaxActivityCount = 4;
        }

    }

    private class Callbacks
        implements AdapterView.OnItemClickListener, android.view.View.OnClickListener, android.view.View.OnLongClickListener, PopupWindow.OnDismissListener {

        private void notifyOnDismissListener() {
            if(mOnDismissListener != null)
                mOnDismissListener.onDismiss();
        }

        public void onClick(View view) {
            if(view == mDefaultActivityButton) {
                dismissPopup();
                ResolveInfo resolveinfo = mAdapter.getDefaultActivity();
                int i = mAdapter.getDataModel().getActivityIndex(resolveinfo);
                Intent intent = mAdapter.getDataModel().chooseActivity(i);
                if(intent != null) {
                    intent.addFlags(0x80000);
                    access$500.startActivity(intent);
                }
            } else
            if(view == mExpandActivityOverflowButton) {
                mIsSelectingDefaultActivity = false;
                showPopupUnchecked(mInitialActivityCount);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public void onDismiss() {
            notifyOnDismissListener();
            if(mProvider != null)
                mProvider.subUiVisibilityChanged(false);
        }

        public void onItemClick(AdapterView adapterview, View view, int i, long l) {
            ((ActivityChooserViewAdapter)adapterview.getAdapter()).getItemViewType(i);
            JVM INSTR tableswitch 0 1: default 32
        //                       0 50
        //                       1 40;
               goto _L1 _L2 _L3
_L1:
            throw new IllegalArgumentException();
_L3:
            showPopupUnchecked(0x7fffffff);
_L5:
            return;
_L2:
            dismissPopup();
            if(mIsSelectingDefaultActivity) {
                if(i > 0)
                    mAdapter.getDataModel().setDefaultActivity(i);
            } else {
                Intent intent;
                if(!mAdapter.getShowDefaultActivity())
                    i++;
                intent = mAdapter.getDataModel().chooseActivity(i);
                if(intent != null) {
                    intent.addFlags(0x80000);
                    access$500.startActivity(intent);
                }
            }
            if(true) goto _L5; else goto _L4
_L4:
        }

        public boolean onLongClick(View view) {
            if(view == mDefaultActivityButton) {
                if(mAdapter.getCount() > 0) {
                    mIsSelectingDefaultActivity = true;
                    showPopupUnchecked(mInitialActivityCount);
                }
                return true;
            } else {
                throw new IllegalArgumentException();
            }
        }

        final ActivityChooserView this$0;

        private Callbacks() {
            this$0 = ActivityChooserView.this;
            super();
        }

    }


    public ActivityChooserView(Context context) {
        this(context, null);
    }

    public ActivityChooserView(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        mModelDataSetOberver = new DataSetObserver() {

            public void onChanged() {
                super.onChanged();
                mAdapter.notifyDataSetChanged();
            }

            public void onInvalidated() {
                super.onInvalidated();
                mAdapter.notifyDataSetInvalidated();
            }

            final ActivityChooserView this$0;

             {
                this$0 = ActivityChooserView.this;
                super();
            }
        };
        mOnGlobalLayoutListener = new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            public void onGlobalLayout() {
                if(!isShowingPopup()) goto _L2; else goto _L1
_L1:
                if(isShown()) goto _L4; else goto _L3
_L3:
                getListPopupWindow().dismiss();
_L2:
                return;
_L4:
                getListPopupWindow().show();
                if(mProvider != null)
                    mProvider.subUiVisibilityChanged(true);
                if(true) goto _L2; else goto _L5
_L5:
            }

            final ActivityChooserView this$0;

             {
                this$0 = ActivityChooserView.this;
                super();
            }
        };
        mInitialActivityCount = 4;
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.ActivityChooserView, i, 0);
        mInitialActivityCount = typedarray.getInt(0, 4);
        Drawable drawable = typedarray.getDrawable(1);
        typedarray.recycle();
        LayoutInflater.from(super.mContext).inflate(0x109001e, this, true);
        mCallbacks = new Callbacks();
        mActivityChooserContent = (LinearLayout)findViewById(0x1020245);
        mActivityChooserContentBackground = mActivityChooserContent.getBackground();
        mDefaultActivityButton = (FrameLayout)findViewById(0x1020248);
        mDefaultActivityButton.setOnClickListener(mCallbacks);
        mDefaultActivityButton.setOnLongClickListener(mCallbacks);
        mDefaultActivityButtonImage = (ImageView)mDefaultActivityButton.findViewById(0x1020247);
        mExpandActivityOverflowButton = (FrameLayout)findViewById(0x1020246);
        mExpandActivityOverflowButton.setOnClickListener(mCallbacks);
        mExpandActivityOverflowButtonImage = (ImageView)mExpandActivityOverflowButton.findViewById(0x1020247);
        mExpandActivityOverflowButtonImage.setImageDrawable(drawable);
        mAdapter = new ActivityChooserViewAdapter();
        mAdapter.registerDataSetObserver(new DataSetObserver() {

            public void onChanged() {
                super.onChanged();
                updateAppearance();
            }

            final ActivityChooserView this$0;

             {
                this$0 = ActivityChooserView.this;
                super();
            }
        });
        Resources resources = context.getResources();
        mListPopupMaxWidth = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(0x1050007));
    }

    private ListPopupWindow getListPopupWindow() {
        if(mListPopupWindow == null) {
            mListPopupWindow = new ListPopupWindow(getContext());
            mListPopupWindow.setAdapter(mAdapter);
            mListPopupWindow.setAnchorView(this);
            mListPopupWindow.setModal(true);
            mListPopupWindow.setOnItemClickListener(mCallbacks);
            mListPopupWindow.setOnDismissListener(mCallbacks);
        }
        return mListPopupWindow;
    }

    private void showPopupUnchecked(int i) {
        if(mAdapter.getDataModel() == null)
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        getViewTreeObserver().addOnGlobalLayoutListener(mOnGlobalLayoutListener);
        boolean flag;
        int j;
        int k;
        ListPopupWindow listpopupwindow;
        if(mDefaultActivityButton.getVisibility() == 0)
            flag = true;
        else
            flag = false;
        j = mAdapter.getActivityCount();
        if(flag)
            k = 1;
        else
            k = 0;
        if(i != 0x7fffffff && j > i + k) {
            mAdapter.setShowFooterView(true);
            mAdapter.setMaxActivityCount(i - 1);
        } else {
            mAdapter.setShowFooterView(false);
            mAdapter.setMaxActivityCount(i);
        }
        listpopupwindow = getListPopupWindow();
        if(!listpopupwindow.isShowing()) {
            if(mIsSelectingDefaultActivity || !flag)
                mAdapter.setShowDefaultActivity(true, flag);
            else
                mAdapter.setShowDefaultActivity(false, false);
            listpopupwindow.setContentWidth(Math.min(mAdapter.measureContentWidth(), mListPopupMaxWidth));
            listpopupwindow.show();
            if(mProvider != null)
                mProvider.subUiVisibilityChanged(true);
            listpopupwindow.getListView().setContentDescription(super.mContext.getString(0x10404c0));
        }
    }

    private void updateAppearance() {
        int i;
        int j;
        if(mAdapter.getCount() > 0)
            mExpandActivityOverflowButton.setEnabled(true);
        else
            mExpandActivityOverflowButton.setEnabled(false);
        i = mAdapter.getActivityCount();
        j = mAdapter.getHistorySize();
        if(i > 0 && j > 0) {
            mDefaultActivityButton.setVisibility(0);
            ResolveInfo resolveinfo = mAdapter.getDefaultActivity();
            android.content.pm.PackageManager packagemanager = super.mContext.getPackageManager();
            mDefaultActivityButtonImage.setImageDrawable(resolveinfo.loadIcon(packagemanager));
            if(mDefaultActionButtonContentDescription != 0) {
                CharSequence charsequence = resolveinfo.loadLabel(packagemanager);
                Context context = super.mContext;
                int k = mDefaultActionButtonContentDescription;
                Object aobj[] = new Object[1];
                aobj[0] = charsequence;
                String s = context.getString(k, aobj);
                mDefaultActivityButton.setContentDescription(s);
            }
        } else {
            mDefaultActivityButton.setVisibility(8);
        }
        if(mDefaultActivityButton.getVisibility() == 0)
            mActivityChooserContent.setBackgroundDrawable(mActivityChooserContentBackground);
        else
            mActivityChooserContent.setBackgroundDrawable(null);
    }

    public boolean dismissPopup() {
        if(isShowingPopup()) {
            getListPopupWindow().dismiss();
            ViewTreeObserver viewtreeobserver = getViewTreeObserver();
            if(viewtreeobserver.isAlive())
                viewtreeobserver.removeOnGlobalLayoutListener(mOnGlobalLayoutListener);
        }
        return true;
    }

    public ActivityChooserModel getDataModel() {
        return mAdapter.getDataModel();
    }

    public boolean isShowingPopup() {
        return getListPopupWindow().isShowing();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ActivityChooserModel activitychoosermodel = mAdapter.getDataModel();
        if(activitychoosermodel != null)
            activitychoosermodel.registerObserver(mModelDataSetOberver);
        mIsAttachedToWindow = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActivityChooserModel activitychoosermodel = mAdapter.getDataModel();
        if(activitychoosermodel != null)
            activitychoosermodel.unregisterObserver(mModelDataSetOberver);
        ViewTreeObserver viewtreeobserver = getViewTreeObserver();
        if(viewtreeobserver.isAlive())
            viewtreeobserver.removeOnGlobalLayoutListener(mOnGlobalLayoutListener);
        if(isShowingPopup())
            dismissPopup();
        mIsAttachedToWindow = false;
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l) {
        mActivityChooserContent.layout(0, 0, k - i, l - j);
        if(!isShowingPopup())
            dismissPopup();
    }

    protected void onMeasure(int i, int j) {
        LinearLayout linearlayout = mActivityChooserContent;
        if(mDefaultActivityButton.getVisibility() != 0)
            j = android.view.View.MeasureSpec.makeMeasureSpec(android.view.View.MeasureSpec.getSize(j), 0x40000000);
        measureChild(linearlayout, i, j);
        setMeasuredDimension(linearlayout.getMeasuredWidth(), linearlayout.getMeasuredHeight());
    }

    public void setActivityChooserModel(ActivityChooserModel activitychoosermodel) {
        mAdapter.setDataModel(activitychoosermodel);
        if(isShowingPopup()) {
            dismissPopup();
            showPopup();
        }
    }

    public void setDefaultActionButtonContentDescription(int i) {
        mDefaultActionButtonContentDescription = i;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        String s = super.mContext.getString(i);
        mExpandActivityOverflowButtonImage.setContentDescription(s);
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        mExpandActivityOverflowButtonImage.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i) {
        mInitialActivityCount = i;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener ondismisslistener) {
        mOnDismissListener = ondismisslistener;
    }

    public void setProvider(ActionProvider actionprovider) {
        mProvider = actionprovider;
    }

    public boolean showPopup() {
        boolean flag = false;
        if(!isShowingPopup() && mIsAttachedToWindow) {
            mIsSelectingDefaultActivity = false;
            showPopupUnchecked(mInitialActivityCount);
            flag = true;
        }
        return flag;
    }

    private final LinearLayout mActivityChooserContent;
    private final Drawable mActivityChooserContentBackground;
    private final ActivityChooserViewAdapter mAdapter;
    private final Callbacks mCallbacks;
    private int mDefaultActionButtonContentDescription;
    private final FrameLayout mDefaultActivityButton;
    private final ImageView mDefaultActivityButtonImage;
    private final FrameLayout mExpandActivityOverflowButton;
    private final ImageView mExpandActivityOverflowButtonImage;
    private int mInitialActivityCount;
    private boolean mIsAttachedToWindow;
    private boolean mIsSelectingDefaultActivity;
    private final int mListPopupMaxWidth;
    private ListPopupWindow mListPopupWindow;
    private final DataSetObserver mModelDataSetOberver;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private final android.view.ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    ActionProvider mProvider;













/*
    static boolean access$602(ActivityChooserView activitychooserview, boolean flag) {
        activitychooserview.mIsSelectingDefaultActivity = flag;
        return flag;
    }

*/



}

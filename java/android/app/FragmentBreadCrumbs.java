// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.util.AttributeSet;
import android.view.*;
import android.widget.LinearLayout;
import android.widget.TextView;

// Referenced classes of package android.app:
//            BackStackRecord, Activity, FragmentManagerImpl, FragmentManager

public class FragmentBreadCrumbs extends ViewGroup
    implements FragmentManager.OnBackStackChangedListener {
    public static interface OnBreadCrumbClickListener {

        public abstract boolean onBreadCrumbClick(FragmentManager.BackStackEntry backstackentry, int i);
    }


    public FragmentBreadCrumbs(Context context) {
        this(context, null);
    }

    public FragmentBreadCrumbs(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0x1030089);
    }

    public FragmentBreadCrumbs(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        mMaxVisible = -1;
    }

    private BackStackRecord createBackStackEntry(CharSequence charsequence, CharSequence charsequence1) {
        BackStackRecord backstackrecord;
        if(charsequence == null) {
            backstackrecord = null;
        } else {
            backstackrecord = new BackStackRecord((FragmentManagerImpl)mActivity.getFragmentManager());
            backstackrecord.setBreadCrumbTitle(charsequence);
            backstackrecord.setBreadCrumbShortTitle(charsequence1);
        }
        return backstackrecord;
    }

    private FragmentManager.BackStackEntry getPreEntry(int i) {
        BackStackRecord backstackrecord;
        if(mParentEntry != null) {
            if(i == 0)
                backstackrecord = mParentEntry;
            else
                backstackrecord = mTopEntry;
        } else {
            backstackrecord = mTopEntry;
        }
        return backstackrecord;
    }

    private int getPreEntryCount() {
        int i = 1;
        int j;
        if(mTopEntry != null)
            j = i;
        else
            j = 0;
        if(mParentEntry == null)
            i = 0;
        return j + i;
    }

    public void onBackStackChanged() {
        updateCrumbs();
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l) {
        int i1 = getChildCount();
        for(int j1 = 0; j1 < i1; j1++) {
            View view = getChildAt(j1);
            int k1 = (super.mPaddingLeft + view.getMeasuredWidth()) - super.mPaddingRight;
            int l1 = (super.mPaddingTop + view.getMeasuredHeight()) - super.mPaddingBottom;
            view.layout(super.mPaddingLeft, super.mPaddingTop, k1, l1);
        }

    }

    protected void onMeasure(int i, int j) {
        int k = getChildCount();
        int l = 0;
        int i1 = 0;
        int j1 = 0;
        for(int k1 = 0; k1 < k; k1++) {
            View view = getChildAt(k1);
            if(view.getVisibility() != 8) {
                measureChild(view, i, j);
                i1 = Math.max(i1, view.getMeasuredWidth());
                l = Math.max(l, view.getMeasuredHeight());
                j1 = combineMeasuredStates(j1, view.getMeasuredState());
            }
        }

        int l1 = i1 + (super.mPaddingLeft + super.mPaddingRight);
        int i2 = Math.max(l + (super.mPaddingTop + super.mPaddingBottom), getSuggestedMinimumHeight());
        setMeasuredDimension(resolveSizeAndState(Math.max(l1, getSuggestedMinimumWidth()), i, j1), resolveSizeAndState(i2, j, j1 << 16));
    }

    public void setActivity(Activity activity) {
        mActivity = activity;
        mInflater = (LayoutInflater)activity.getSystemService("layout_inflater");
        mContainer = (LinearLayout)mInflater.inflate(0x1090040, this, false);
        addView(mContainer);
        activity.getFragmentManager().addOnBackStackChangedListener(this);
        updateCrumbs();
        setLayoutTransition(new LayoutTransition());
    }

    public void setMaxVisible(int i) {
        if(i < 1) {
            throw new IllegalArgumentException("visibleCrumbs must be greater than zero");
        } else {
            mMaxVisible = i;
            return;
        }
    }

    public void setOnBreadCrumbClickListener(OnBreadCrumbClickListener onbreadcrumbclicklistener) {
        mOnBreadCrumbClickListener = onbreadcrumbclicklistener;
    }

    public void setParentTitle(CharSequence charsequence, CharSequence charsequence1, android.view.View.OnClickListener onclicklistener) {
        mParentEntry = createBackStackEntry(charsequence, charsequence1);
        mParentClickListener = onclicklistener;
        updateCrumbs();
    }

    public void setTitle(CharSequence charsequence, CharSequence charsequence1) {
        mTopEntry = createBackStackEntry(charsequence, charsequence1);
        updateCrumbs();
    }

    void updateCrumbs() {
        FragmentManager fragmentmanager = mActivity.getFragmentManager();
        int i = fragmentmanager.getBackStackEntryCount();
        int j = getPreEntryCount();
        int k = mContainer.getChildCount();
        for(int l = 0; l < i + j; l++) {
            FragmentManager.BackStackEntry backstackentry;
            if(l < j)
                backstackentry = getPreEntry(l);
            else
                backstackentry = fragmentmanager.getBackStackEntryAt(l - j);
            if(l < k && mContainer.getChildAt(l).getTag() != backstackentry) {
                for(int i2 = l; i2 < k; i2++)
                    mContainer.removeViewAt(l);

                k = l;
            }
            if(l < k)
                continue;
            View view3 = mInflater.inflate(0x109003f, this, false);
            TextView textview = (TextView)view3.findViewById(0x1020016);
            textview.setText(backstackentry.getBreadCrumbTitle());
            textview.setTag(backstackentry);
            if(l == 0)
                view3.findViewById(0x1020232).setVisibility(8);
            mContainer.addView(view3);
            textview.setOnClickListener(mOnClickListener);
        }

        int i1 = i + j;
        int j1;
        for(j1 = mContainer.getChildCount(); j1 > i1; j1--)
            mContainer.removeViewAt(j1 - 1);

        int k1 = 0;
        while(k1 < j1)  {
            View view = mContainer.getChildAt(k1);
            View view1 = view.findViewById(0x1020016);
            boolean flag;
            if(k1 < j1 - 1)
                flag = true;
            else
                flag = false;
            view1.setEnabled(flag);
            if(mMaxVisible > 0) {
                byte byte0;
                View view2;
                int l1;
                if(k1 < j1 - mMaxVisible)
                    byte0 = 8;
                else
                    byte0 = 0;
                view.setVisibility(byte0);
                view2 = view.findViewById(0x1020232);
                if(k1 > j1 - mMaxVisible && k1 != 0)
                    l1 = 0;
                else
                    l1 = 8;
                view2.setVisibility(l1);
            }
            k1++;
        }
    }

    Activity mActivity;
    LinearLayout mContainer;
    LayoutInflater mInflater;
    int mMaxVisible;
    private OnBreadCrumbClickListener mOnBreadCrumbClickListener;
    private android.view.View.OnClickListener mOnClickListener = new android.view.View.OnClickListener() {

        public void onClick(View view) {
            if(!(view.getTag() instanceof FragmentManager.BackStackEntry)) goto _L2; else goto _L1
_L1:
            FragmentManager.BackStackEntry backstackentry = (FragmentManager.BackStackEntry)view.getTag();
            if(backstackentry != mParentEntry) goto _L4; else goto _L3
_L3:
            if(mParentClickListener != null)
                mParentClickListener.onClick(view);
_L2:
            return;
_L4:
            if(mOnBreadCrumbClickListener != null) {
                OnBreadCrumbClickListener onbreadcrumbclicklistener = mOnBreadCrumbClickListener;
                FragmentManager.BackStackEntry backstackentry1;
                if(backstackentry == mTopEntry)
                    backstackentry1 = null;
                else
                    backstackentry1 = backstackentry;
                if(onbreadcrumbclicklistener.onBreadCrumbClick(backstackentry1, 0))
                    continue; /* Loop/switch isn't completed */
            }
            if(backstackentry == mTopEntry)
                mActivity.getFragmentManager().popBackStack();
            else
                mActivity.getFragmentManager().popBackStack(backstackentry.getId(), 0);
            if(true) goto _L2; else goto _L5
_L5:
        }

        final FragmentBreadCrumbs this$0;

             {
                this$0 = FragmentBreadCrumbs.this;
                super();
            }
    };
    private android.view.View.OnClickListener mParentClickListener;
    BackStackRecord mParentEntry;
    BackStackRecord mTopEntry;


}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.os.Bundle;
import android.os.Handler;
import android.view.*;
import android.view.animation.AnimationUtils;
import android.widget.*;

// Referenced classes of package android.app:
//            Fragment

public class ListFragment extends Fragment {

    public ListFragment() {
    }

    private void ensureList() {
        if(mList == null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        View view = getView();
        if(view == null)
            throw new IllegalStateException("Content view not yet created");
        ListAdapter listadapter;
        if(view instanceof ListView) {
            mList = (ListView)view;
        } else {
            mStandardEmptyView = (TextView)view.findViewById(0x10202d1);
            View view1;
            if(mStandardEmptyView == null)
                mEmptyView = view.findViewById(0x1020004);
            else
                mStandardEmptyView.setVisibility(8);
            mProgressContainer = view.findViewById(0x10202cf);
            mListContainer = view.findViewById(0x10202d0);
            view1 = view.findViewById(0x102000a);
            if(!(view1 instanceof ListView))
                throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
            mList = (ListView)view1;
            if(mList == null)
                throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
            if(mEmptyView != null)
                mList.setEmptyView(mEmptyView);
            else
            if(mEmptyText != null) {
                mStandardEmptyView.setText(mEmptyText);
                mList.setEmptyView(mStandardEmptyView);
            }
        }
        mListShown = true;
        mList.setOnItemClickListener(mOnClickListener);
        if(mAdapter == null)
            break; /* Loop/switch isn't completed */
        listadapter = mAdapter;
        mAdapter = null;
        setListAdapter(listadapter);
_L5:
        mHandler.post(mRequestFocus);
        if(true) goto _L1; else goto _L3
_L3:
        if(mProgressContainer == null) goto _L5; else goto _L4
_L4:
        setListShown(false, false);
          goto _L5
    }

    private void setListShown(boolean flag, boolean flag1) {
        ensureList();
        if(mProgressContainer == null)
            throw new IllegalStateException("Can't be used with a custom content view");
        if(mListShown != flag) {
            mListShown = flag;
            if(flag) {
                if(flag1) {
                    mProgressContainer.startAnimation(AnimationUtils.loadAnimation(getActivity(), 0x10a0001));
                    mListContainer.startAnimation(AnimationUtils.loadAnimation(getActivity(), 0x10a0000));
                } else {
                    mProgressContainer.clearAnimation();
                    mListContainer.clearAnimation();
                }
                mProgressContainer.setVisibility(8);
                mListContainer.setVisibility(0);
            } else {
                if(flag1) {
                    mProgressContainer.startAnimation(AnimationUtils.loadAnimation(getActivity(), 0x10a0000));
                    mListContainer.startAnimation(AnimationUtils.loadAnimation(getActivity(), 0x10a0001));
                } else {
                    mProgressContainer.clearAnimation();
                    mListContainer.clearAnimation();
                }
                mProgressContainer.setVisibility(0);
                mListContainer.setVisibility(8);
            }
        }
    }

    public ListAdapter getListAdapter() {
        return mAdapter;
    }

    public ListView getListView() {
        ensureList();
        return mList;
    }

    public long getSelectedItemId() {
        ensureList();
        return mList.getSelectedItemId();
    }

    public int getSelectedItemPosition() {
        ensureList();
        return mList.getSelectedItemPosition();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle) {
        return layoutinflater.inflate(0x1090014, viewgroup, false);
    }

    public void onDestroyView() {
        mHandler.removeCallbacks(mRequestFocus);
        mList = null;
        mListShown = false;
        mListContainer = null;
        mProgressContainer = null;
        mEmptyView = null;
        mStandardEmptyView = null;
        super.onDestroyView();
    }

    public void onListItemClick(ListView listview, View view, int i, long l) {
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ensureList();
    }

    public void setEmptyText(CharSequence charsequence) {
        ensureList();
        if(mStandardEmptyView == null)
            throw new IllegalStateException("Can't be used with a custom content view");
        mStandardEmptyView.setText(charsequence);
        if(mEmptyText == null)
            mList.setEmptyView(mStandardEmptyView);
        mEmptyText = charsequence;
    }

    public void setListAdapter(ListAdapter listadapter) {
        boolean flag = false;
        boolean flag1;
        if(mAdapter != null)
            flag1 = true;
        else
            flag1 = false;
        mAdapter = listadapter;
        if(mList != null) {
            mList.setAdapter(listadapter);
            if(!mListShown && !flag1) {
                if(getView().getWindowToken() != null)
                    flag = true;
                setListShown(true, flag);
            }
        }
    }

    public void setListShown(boolean flag) {
        setListShown(flag, true);
    }

    public void setListShownNoAnimation(boolean flag) {
        setListShown(flag, false);
    }

    public void setSelection(int i) {
        ensureList();
        mList.setSelection(i);
    }

    ListAdapter mAdapter;
    CharSequence mEmptyText;
    View mEmptyView;
    private final Handler mHandler = new Handler();
    ListView mList;
    View mListContainer;
    boolean mListShown;
    private final android.widget.AdapterView.OnItemClickListener mOnClickListener = new android.widget.AdapterView.OnItemClickListener() {

        public void onItemClick(AdapterView adapterview, View view, int i, long l) {
            onListItemClick((ListView)adapterview, view, i, l);
        }

        final ListFragment this$0;

             {
                this$0 = ListFragment.this;
                super();
            }
    };
    View mProgressContainer;
    private final Runnable mRequestFocus = new Runnable() {

        public void run() {
            mList.focusableViewAvailable(mList);
        }

        final ListFragment this$0;

             {
                this$0 = ListFragment.this;
                super();
            }
    };
    TextView mStandardEmptyView;
}

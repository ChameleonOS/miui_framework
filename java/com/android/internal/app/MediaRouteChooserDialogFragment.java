// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.app;

import android.app.*;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.MediaRouter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.*;
import android.widget.*;
import java.util.*;

public class MediaRouteChooserDialogFragment extends DialogFragment {
    class VolumeSliderChangeListener
        implements android.widget.SeekBar.OnSeekBarChangeListener {

        public void onProgressChanged(SeekBar seekbar, int i, boolean flag) {
            changeVolume(i);
        }

        public void onStartTrackingTouch(SeekBar seekbar) {
            mIgnoreCallbackVolumeChanges = true;
        }

        public void onStopTrackingTouch(SeekBar seekbar) {
            mIgnoreCallbackVolumeChanges = false;
            updateVolume();
        }

        final MediaRouteChooserDialogFragment this$0;

        VolumeSliderChangeListener() {
            this$0 = MediaRouteChooserDialogFragment.this;
            super();
        }
    }

    public static interface LauncherListener {

        public abstract void onDetached(MediaRouteChooserDialogFragment mediaroutechooserdialogfragment);
    }

    class RouteChooserDialog extends Dialog {

        public void onBackPressed() {
            if(mAdapter != null && mAdapter.isGrouping())
                mAdapter.finishGrouping();
            else
                super.onBackPressed();
        }

        public boolean onKeyDown(int i, KeyEvent keyevent) {
            boolean flag = true;
            if(i == 25 && mVolumeSlider.isEnabled())
                mRouter.getSelectedRoute(mRouteTypes).requestUpdateVolume(-1);
            else
            if(i == 24 && mVolumeSlider.isEnabled())
                mRouter.getSelectedRoute(mRouteTypes).requestUpdateVolume(flag);
            else
                flag = super.onKeyDown(i, keyevent);
            return flag;
        }

        public boolean onKeyUp(int i, KeyEvent keyevent) {
            boolean flag;
            flag = true;
            break MISSING_BLOCK_LABEL_2;
            if((i != 25 || !mVolumeSlider.isEnabled()) && (i != 24 || !mVolumeSlider.isEnabled()))
                flag = super.onKeyUp(i, keyevent);
            return flag;
        }

        final MediaRouteChooserDialogFragment this$0;

        public RouteChooserDialog(Context context, int i) {
            this$0 = MediaRouteChooserDialogFragment.this;
            super(context, i);
        }
    }

    class RouteComparator
        implements Comparator {

        public int compare(android.media.MediaRouter.RouteInfo routeinfo, android.media.MediaRouter.RouteInfo routeinfo1) {
            return routeinfo.getName(getActivity()).toString().compareTo(routeinfo1.getName(getActivity()).toString());
        }

        public volatile int compare(Object obj, Object obj1) {
            return compare((android.media.MediaRouter.RouteInfo)obj, (android.media.MediaRouter.RouteInfo)obj1);
        }

        final MediaRouteChooserDialogFragment this$0;

        RouteComparator() {
            this$0 = MediaRouteChooserDialogFragment.this;
            super();
        }
    }

    class MediaRouterCallback extends android.media.MediaRouter.Callback {

        public void onRouteAdded(MediaRouter mediarouter, android.media.MediaRouter.RouteInfo routeinfo) {
            mAdapter.update();
        }

        public void onRouteChanged(MediaRouter mediarouter, android.media.MediaRouter.RouteInfo routeinfo) {
            mAdapter.notifyDataSetChanged();
        }

        public void onRouteGrouped(MediaRouter mediarouter, android.media.MediaRouter.RouteInfo routeinfo, android.media.MediaRouter.RouteGroup routegroup, int i) {
            mAdapter.update();
        }

        public void onRouteRemoved(MediaRouter mediarouter, android.media.MediaRouter.RouteInfo routeinfo) {
            if(routeinfo == mAdapter.mEditingGroup)
                mAdapter.finishGrouping();
            mAdapter.update();
        }

        public void onRouteSelected(MediaRouter mediarouter, int i, android.media.MediaRouter.RouteInfo routeinfo) {
            mAdapter.update();
            updateVolume();
        }

        public void onRouteUngrouped(MediaRouter mediarouter, android.media.MediaRouter.RouteInfo routeinfo, android.media.MediaRouter.RouteGroup routegroup) {
            mAdapter.update();
        }

        public void onRouteUnselected(MediaRouter mediarouter, int i, android.media.MediaRouter.RouteInfo routeinfo) {
            mAdapter.update();
        }

        public void onRouteVolumeChanged(MediaRouter mediarouter, android.media.MediaRouter.RouteInfo routeinfo) {
            if(!mIgnoreCallbackVolumeChanges)
                updateVolume();
        }

        final MediaRouteChooserDialogFragment this$0;

        MediaRouterCallback() {
            this$0 = MediaRouteChooserDialogFragment.this;
            super();
        }
    }

    private class RouteAdapter extends BaseAdapter
        implements android.widget.AdapterView.OnItemClickListener {
        class ExpandGroupListener
            implements android.view.View.OnClickListener {

            public void onClick(View view) {
                android.media.MediaRouter.RouteGroup routegroup = (android.media.MediaRouter.RouteGroup)getItem(position);
                mEditingGroup = routegroup;
                mCategoryEditingGroups = routegroup.getCategory();
                getDialog().setCanceledOnTouchOutside(false);
                mRouter.selectRouteInt(mRouteTypes, mEditingGroup);
                update();
                scrollToEditingGroup();
            }

            int position;
            final RouteAdapter this$1;

            ExpandGroupListener() {
                this$1 = RouteAdapter.this;
                super();
            }
        }


        void addGroupEditingCategoryRoutes(List list) {
            int i = list.size();
            for(int j = 0; j < i; j++) {
                android.media.MediaRouter.RouteInfo routeinfo = (android.media.MediaRouter.RouteInfo)list.get(j);
                android.media.MediaRouter.RouteGroup routegroup = routeinfo.getGroup();
                if(routegroup == routeinfo) {
                    int k = routegroup.getRouteCount();
                    for(int l = 0; l < k; l++) {
                        android.media.MediaRouter.RouteInfo routeinfo1 = routegroup.getRouteAt(l);
                        mSortRouteList.add(routeinfo1);
                    }

                } else {
                    mSortRouteList.add(routeinfo);
                }
            }

            Collections.sort(mSortRouteList, mComparator);
            mItems.addAll(mSortRouteList);
            mSortRouteList.clear();
            mItems.add(null);
        }

        void addSelectableRoutes(android.media.MediaRouter.RouteInfo routeinfo, List list) {
            int i = list.size();
            for(int j = 0; j < i; j++) {
                android.media.MediaRouter.RouteInfo routeinfo1 = (android.media.MediaRouter.RouteInfo)list.get(j);
                if(routeinfo1 == routeinfo)
                    mSelectedItemPosition = mItems.size();
                mItems.add(routeinfo1);
            }

        }

        public boolean areAllItemsEnabled() {
            return false;
        }

        void bindHeaderView(int i, ViewHolder viewholder) {
            android.media.MediaRouter.RouteCategory routecategory = (android.media.MediaRouter.RouteCategory)mItems.get(i);
            viewholder.text1.setText(routecategory.getName(getActivity()));
        }

        void bindItemView(int i, ViewHolder viewholder) {
            boolean flag = true;
            int j = 0;
            android.media.MediaRouter.RouteInfo routeinfo = (android.media.MediaRouter.RouteInfo)mItems.get(i);
            viewholder.text1.setText(routeinfo.getName(getActivity()));
            CharSequence charsequence = routeinfo.getStatus();
            Drawable drawable;
            ImageView imageview;
            int k;
            android.media.MediaRouter.RouteCategory routecategory;
            int l;
            if(TextUtils.isEmpty(charsequence)) {
                viewholder.text2.setVisibility(8);
            } else {
                viewholder.text2.setVisibility(0);
                viewholder.text2.setText(charsequence);
            }
            drawable = routeinfo.getIconDrawable();
            if(drawable != null)
                drawable = drawable.getConstantState().newDrawable(getResources());
            viewholder.icon.setImageDrawable(drawable);
            imageview = viewholder.icon;
            if(drawable != null)
                k = 0;
            else
                k = 8;
            imageview.setVisibility(k);
            routecategory = routeinfo.getCategory();
            l = 0;
            if(routecategory == mCategoryEditingGroups) {
                android.media.MediaRouter.RouteGroup routegroup = routeinfo.getGroup();
                CheckBox checkbox = viewholder.check;
                ImageButton imagebutton;
                boolean flag1;
                CheckBox checkbox1;
                if(routegroup.getRouteCount() > flag)
                    flag1 = flag;
                else
                    flag1 = false;
                checkbox.setEnabled(flag1);
                checkbox1 = viewholder.check;
                if(routegroup != mEditingGroup)
                    flag = false;
                checkbox1.setChecked(flag);
            } else
            if(routecategory.isGroupable())
                if(((android.media.MediaRouter.RouteGroup)routeinfo).getRouteCount() > flag || getItemViewType(i - 1) == 2 || i < -1 + getCount() && getItemViewType(i + 1) == 2)
                    l = ((flag) ? 1 : 0);
                else
                    l = 0;
            if(viewholder.expandGroupButton != null) {
                imagebutton = viewholder.expandGroupButton;
                if(l == 0)
                    j = 8;
                imagebutton.setVisibility(j);
                viewholder.expandGroupListener.position = i;
            }
        }

        void finishGrouping() {
            mCategoryEditingGroups = null;
            mEditingGroup = null;
            getDialog().setCanceledOnTouchOutside(true);
            update();
            scrollToSelectedItem();
        }

        public int getCount() {
            return mItems.size();
        }

        public Object getItem(int i) {
            return mItems.get(i);
        }

        public long getItemId(int i) {
            return (long)i;
        }

        public int getItemViewType(int i) {
            Object obj = getItem(i);
            int j;
            if(obj instanceof android.media.MediaRouter.RouteCategory) {
                if(i == 0)
                    j = 0;
                else
                    j = 1;
            } else
            if(obj == null)
                j = 4;
            else
            if(((android.media.MediaRouter.RouteInfo)obj).getCategory() == mCategoryEditingGroups)
                j = 3;
            else
                j = 2;
            return j;
        }

        public View getView(int i, View view, ViewGroup viewgroup) {
            ViewHolder viewholder;
            int j = getItemViewType(i);
            if(view == null) {
                view = mInflater.inflate(MediaRouteChooserDialogFragment.ITEM_LAYOUTS[j], viewgroup, false);
                viewholder = new ViewHolder();
                viewholder.position = i;
                viewholder.text1 = (TextView)view.findViewById(0x1020014);
                viewholder.text2 = (TextView)view.findViewById(0x1020015);
                viewholder.icon = (ImageView)view.findViewById(0x1020006);
                viewholder.check = (CheckBox)view.findViewById(0x10202df);
                viewholder.expandGroupButton = (ImageButton)view.findViewById(0x10202de);
                if(viewholder.expandGroupButton != null) {
                    viewholder.expandGroupListener = new ExpandGroupListener();
                    viewholder.expandGroupButton.setOnClickListener(viewholder.expandGroupListener);
                }
                View view1 = view;
                view.setOnClickListener(new android.view.View.OnClickListener() {

                    public void onClick(View view2) {
                        list.performItemClick(fview, fholder.position, 0L);
                    }

                    final RouteAdapter this$1;
                    final ViewHolder val$fholder;
                    final View val$fview;
                    final ListView val$list;

                 {
                    this$1 = RouteAdapter.this;
                    list = listview;
                    fview = view;
                    fholder = viewholder;
                    super();
                }
                });
                view.setTag(viewholder);
            } else {
                viewholder = (ViewHolder)view.getTag();
                viewholder.position = i;
            }
            j;
            JVM INSTR tableswitch 0 3: default 216
        //                       0 263
        //                       1 263
        //                       2 253
        //                       3 253;
               goto _L1 _L2 _L2 _L3 _L3
_L1:
            break; /* Loop/switch isn't completed */
_L2:
            break MISSING_BLOCK_LABEL_263;
_L4:
            boolean flag;
            if(i == mSelectedItemPosition)
                flag = true;
            else
                flag = false;
            view.setActivated(flag);
            return view;
_L3:
            bindItemView(i, viewholder);
              goto _L4
            bindHeaderView(i, viewholder);
              goto _L4
        }

        public int getViewTypeCount() {
            return 5;
        }

        public boolean isEnabled(int i) {
            getItemViewType(i);
            JVM INSTR tableswitch 2 4: default 32
        //                       2 36
        //                       3 36
        //                       4 36;
               goto _L1 _L2 _L2 _L2
_L1:
            boolean flag = false;
_L4:
            return flag;
_L2:
            flag = true;
            if(true) goto _L4; else goto _L3
_L3:
        }

        boolean isGrouping() {
            boolean flag;
            if(mCategoryEditingGroups != null)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public void onItemClick(AdapterView adapterview, View view, int i, long l) {
            int j = getItemViewType(i);
            if(j != 1 && j != 0) goto _L2; else goto _L1
_L1:
            return;
_L2:
            android.media.MediaRouter.RouteInfo routeinfo;
            boolean flag;
            if(j == 4) {
                finishGrouping();
                continue; /* Loop/switch isn't completed */
            }
            Object obj = getItem(i);
            if(!(obj instanceof android.media.MediaRouter.RouteInfo))
                continue; /* Loop/switch isn't completed */
            routeinfo = (android.media.MediaRouter.RouteInfo)obj;
            if(j == 2) {
                mRouter.selectRouteInt(mRouteTypes, routeinfo);
                dismiss();
                continue; /* Loop/switch isn't completed */
            }
            if(j != 3)
                continue; /* Loop/switch isn't completed */
            Checkable checkable = (Checkable)view;
            flag = checkable.isChecked();
            mIgnoreUpdates = true;
            android.media.MediaRouter.RouteGroup routegroup = routeinfo.getGroup();
            if(flag || routegroup == mEditingGroup)
                break; /* Loop/switch isn't completed */
            if(mRouter.getSelectedRoute(mRouteTypes) == routegroup)
                mRouter.selectRouteInt(mRouteTypes, mEditingGroup);
            routegroup.removeRoute(routeinfo);
            mEditingGroup.addRoute(routeinfo);
            checkable.setChecked(true);
_L5:
            mIgnoreUpdates = false;
            update();
            if(true) goto _L1; else goto _L3
_L3:
            if(!flag || mEditingGroup.getRouteCount() <= 1) goto _L5; else goto _L4
_L4:
            mEditingGroup.removeRoute(routeinfo);
            mRouter.addRouteInt(routeinfo);
              goto _L5
        }

        void scrollToEditingGroup() {
            if(mCategoryEditingGroups != null && mListView != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            int i = 0;
            int j = 0;
            int k = mItems.size();
            int l = 0;
            do {
label0:
                {
                    if(l < k) {
                        Object obj = mItems.get(l);
                        if(obj != null && obj == mCategoryEditingGroups)
                            j = l;
                        if(obj != null)
                            break label0;
                        i = l;
                    }
                    mListView.smoothScrollToPosition(i, j);
                }
                if(true)
                    continue;
                l++;
            } while(true);
            if(true) goto _L1; else goto _L3
_L3:
        }

        void scrollToSelectedItem() {
            if(mListView != null && mSelectedItemPosition >= 0)
                mListView.smoothScrollToPosition(mSelectedItemPosition);
        }

        void update() {
            if(!mIgnoreUpdates) goto _L2; else goto _L1
_L1:
            return;
_L2:
            mItems.clear();
            android.media.MediaRouter.RouteInfo routeinfo = mRouter.getSelectedRoute(mRouteTypes);
            mSelectedItemPosition = -1;
            int i = mRouter.getCategoryCount();
            int j = 0;
            while(j < i)  {
                android.media.MediaRouter.RouteCategory routecategory = mRouter.getCategoryAt(j);
                List list = routecategory.getRoutes(mCatRouteList);
                mItems.add(routecategory);
                if(routecategory == mCategoryEditingGroups)
                    addGroupEditingCategoryRoutes(list);
                else
                    addSelectableRoutes(routeinfo, list);
                list.clear();
                j++;
            }
            notifyDataSetChanged();
            if(mListView != null && mSelectedItemPosition >= 0)
                mListView.setItemChecked(mSelectedItemPosition, true);
            if(true) goto _L1; else goto _L3
_L3:
        }

        private static final int VIEW_GROUPING_DONE = 4;
        private static final int VIEW_GROUPING_ROUTE = 3;
        private static final int VIEW_ROUTE = 2;
        private static final int VIEW_SECTION_HEADER = 1;
        private static final int VIEW_TOP_HEADER;
        private final ArrayList mCatRouteList = new ArrayList();
        private android.media.MediaRouter.RouteCategory mCategoryEditingGroups;
        private android.media.MediaRouter.RouteGroup mEditingGroup;
        private boolean mIgnoreUpdates;
        private final ArrayList mItems = new ArrayList();
        private int mSelectedItemPosition;
        private final ArrayList mSortRouteList = new ArrayList();
        final MediaRouteChooserDialogFragment this$0;



/*
        static android.media.MediaRouter.RouteGroup access$502(RouteAdapter routeadapter, android.media.MediaRouter.RouteGroup routegroup) {
            routeadapter.mEditingGroup = routegroup;
            return routegroup;
        }

*/


/*
        static android.media.MediaRouter.RouteCategory access$602(RouteAdapter routeadapter, android.media.MediaRouter.RouteCategory routecategory) {
            routeadapter.mCategoryEditingGroups = routecategory;
            return routecategory;
        }

*/

        RouteAdapter() {
            this$0 = MediaRouteChooserDialogFragment.this;
            super();
            mSelectedItemPosition = -1;
            update();
        }
    }

    private static class ViewHolder {

        public CheckBox check;
        public ImageButton expandGroupButton;
        public RouteAdapter.ExpandGroupListener expandGroupListener;
        public ImageView icon;
        public int position;
        public TextView text1;
        public TextView text2;

        private ViewHolder() {
        }

    }


    public MediaRouteChooserDialogFragment() {
        setStyle(1, 0x103012e);
    }

    void changeVolume(int i) {
        if(!mIgnoreSliderVolumeChanges) goto _L2; else goto _L1
_L1:
        return;
_L2:
        android.media.MediaRouter.RouteInfo routeinfo = mRouter.getSelectedRoute(mRouteTypes);
        if(routeinfo.getVolumeHandling() == 1)
            routeinfo.requestSetVolume(Math.max(0, Math.min(i, routeinfo.getVolumeMax())));
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mRouter = (MediaRouter)activity.getSystemService("media_router");
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return new RouteChooserDialog(getActivity(), getTheme());
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle) {
        mInflater = layoutinflater;
        View view = layoutinflater.inflate(0x1090066, viewgroup, false);
        mVolumeIcon = (ImageView)view.findViewById(0x10202db);
        mVolumeSlider = (SeekBar)view.findViewById(0x10202dc);
        updateVolume();
        mVolumeSlider.setOnSeekBarChangeListener(new VolumeSliderChangeListener());
        if(mExtendedSettingsListener != null) {
            View view1 = view.findViewById(0x10202dd);
            view1.setVisibility(0);
            view1.setOnClickListener(mExtendedSettingsListener);
        }
        ListView listview = (ListView)view.findViewById(0x102000a);
        listview.setItemsCanFocus(true);
        RouteAdapter routeadapter = new RouteAdapter();
        mAdapter = routeadapter;
        listview.setAdapter(routeadapter);
        listview.setOnItemClickListener(mAdapter);
        mListView = listview;
        mRouter.addCallback(mRouteTypes, mCallback);
        mAdapter.scrollToSelectedItem();
        return view;
    }

    public void onDetach() {
        super.onDetach();
        if(mLauncherListener != null)
            mLauncherListener.onDetached(this);
        if(mAdapter != null)
            mAdapter = null;
        mInflater = null;
        mRouter.removeCallback(mCallback);
        mRouter = null;
    }

    public void onResume() {
        super.onResume();
    }

    public void setExtendedSettingsClickListener(android.view.View.OnClickListener onclicklistener) {
        mExtendedSettingsListener = onclicklistener;
    }

    public void setLauncherListener(LauncherListener launcherlistener) {
        mLauncherListener = launcherlistener;
    }

    public void setRouteTypes(int i) {
        mRouteTypes = i;
    }

    void updateVolume() {
        if(mRouter != null) {
            android.media.MediaRouter.RouteInfo routeinfo = mRouter.getSelectedRoute(mRouteTypes);
            ImageView imageview = mVolumeIcon;
            int i;
            if(routeinfo.getPlaybackType() == 0)
                i = 0x10802a6;
            else
                i = 0x1080315;
            imageview.setImageResource(i);
            mIgnoreSliderVolumeChanges = true;
            if(routeinfo.getVolumeHandling() == 0) {
                mVolumeSlider.setMax(1);
                mVolumeSlider.setProgress(1);
                mVolumeSlider.setEnabled(false);
            } else {
                mVolumeSlider.setEnabled(true);
                mVolumeSlider.setMax(routeinfo.getVolumeMax());
                mVolumeSlider.setProgress(routeinfo.getVolume());
            }
            mIgnoreSliderVolumeChanges = false;
        }
    }

    public static final String FRAGMENT_TAG = "android:MediaRouteChooserDialogFragment";
    private static final int ITEM_LAYOUTS[];
    private static final String TAG = "MediaRouteChooserDialogFragment";
    private RouteAdapter mAdapter;
    final MediaRouterCallback mCallback = new MediaRouterCallback();
    final RouteComparator mComparator = new RouteComparator();
    private android.view.View.OnClickListener mExtendedSettingsListener;
    private boolean mIgnoreCallbackVolumeChanges;
    private boolean mIgnoreSliderVolumeChanges;
    private LayoutInflater mInflater;
    private LauncherListener mLauncherListener;
    private ListView mListView;
    private int mRouteTypes;
    MediaRouter mRouter;
    private ImageView mVolumeIcon;
    private SeekBar mVolumeSlider;

    static  {
        int ai[] = new int[5];
        ai[0] = 0x109006b;
        ai[1] = 0x109006a;
        ai[2] = 0x1090067;
        ai[3] = 0x1090068;
        ai[4] = 0x1090069;
        ITEM_LAYOUTS = ai;
    }








/*
    static boolean access$802(MediaRouteChooserDialogFragment mediaroutechooserdialogfragment, boolean flag) {
        mediaroutechooserdialogfragment.mIgnoreCallbackVolumeChanges = flag;
        return flag;
    }

*/

}

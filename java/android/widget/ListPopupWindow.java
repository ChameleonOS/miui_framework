// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.*;
import android.view.*;

// Referenced classes of package android.widget:
//            PopupWindow, LinearLayout, ListAdapter, ListView, 
//            AbsListView, TextView, AdapterView

public class ListPopupWindow {
    private class PopupScrollListener
        implements AbsListView.OnScrollListener {

        public void onScroll(AbsListView abslistview, int i, int j, int k) {
        }

        public void onScrollStateChanged(AbsListView abslistview, int i) {
            if(i == 1 && !isInputMethodNotNeeded() && mPopup.getContentView() != null) {
                mHandler.removeCallbacks(mResizePopupRunnable);
                mResizePopupRunnable.run();
            }
        }

        final ListPopupWindow this$0;

        private PopupScrollListener() {
            this$0 = ListPopupWindow.this;
            super();
        }

    }

    private class PopupTouchInterceptor
        implements android.view.View.OnTouchListener {

        public boolean onTouch(View view, MotionEvent motionevent) {
            int i;
            int j;
            int k;
            i = motionevent.getAction();
            j = (int)motionevent.getX();
            k = (int)motionevent.getY();
            if(i != 0 || mPopup == null || !mPopup.isShowing() || j < 0 || j >= mPopup.getWidth() || k < 0 || k >= mPopup.getHeight()) goto _L2; else goto _L1
_L1:
            mHandler.postDelayed(mResizePopupRunnable, 250L);
_L4:
            return false;
_L2:
            if(i == 1)
                mHandler.removeCallbacks(mResizePopupRunnable);
            if(true) goto _L4; else goto _L3
_L3:
        }

        final ListPopupWindow this$0;

        private PopupTouchInterceptor() {
            this$0 = ListPopupWindow.this;
            super();
        }

    }

    private class ResizePopupRunnable
        implements Runnable {

        public void run() {
            if(mDropDownList != null && mDropDownList.getCount() > mDropDownList.getChildCount() && mDropDownList.getChildCount() <= mListItemExpandMaximum) {
                mPopup.setInputMethodMode(2);
                show();
            }
        }

        final ListPopupWindow this$0;

        private ResizePopupRunnable() {
            this$0 = ListPopupWindow.this;
            super();
        }

    }

    private class ListSelectorHider
        implements Runnable {

        public void run() {
            clearListSelection();
        }

        final ListPopupWindow this$0;

        private ListSelectorHider() {
            this$0 = ListPopupWindow.this;
            super();
        }

    }

    private class PopupDataSetObserver extends DataSetObserver {

        public void onChanged() {
            if(isShowing())
                show();
        }

        public void onInvalidated() {
            dismiss();
        }

        final ListPopupWindow this$0;

        private PopupDataSetObserver() {
            this$0 = ListPopupWindow.this;
            super();
        }

    }

    private static class DropDownListView extends ListView {

        public boolean hasFocus() {
            boolean flag;
            if(mHijackFocus || super.hasFocus())
                flag = true;
            else
                flag = false;
            return flag;
        }

        public boolean hasWindowFocus() {
            boolean flag;
            if(mHijackFocus || super.hasWindowFocus())
                flag = true;
            else
                flag = false;
            return flag;
        }

        public boolean isFocused() {
            boolean flag;
            if(mHijackFocus || super.isFocused())
                flag = true;
            else
                flag = false;
            return flag;
        }

        public boolean isInTouchMode() {
            boolean flag;
            if(mHijackFocus && mListSelectionHidden || super.isInTouchMode())
                flag = true;
            else
                flag = false;
            return flag;
        }

        View obtainView(int i, boolean aflag[]) {
            View view = super.obtainView(i, aflag);
            if(view instanceof TextView)
                ((TextView)view).setHorizontallyScrolling(true);
            return view;
        }

        private static final String TAG = "ListPopupWindow.DropDownListView";
        private boolean mHijackFocus;
        private boolean mListSelectionHidden;


/*
        static boolean access$502(DropDownListView dropdownlistview, boolean flag) {
            dropdownlistview.mListSelectionHidden = flag;
            return flag;
        }

*/

        public DropDownListView(Context context, boolean flag) {
            super(context, null, 0x101006d);
            mHijackFocus = flag;
            setCacheColorHint(0);
        }
    }


    public ListPopupWindow(Context context) {
        this(context, null, 0x10102ff, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0x10102ff, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeset, int i) {
        this(context, attributeset, i, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeset, int i, int j) {
        mDropDownHeight = -2;
        mDropDownWidth = -2;
        mDropDownAlwaysVisible = false;
        mForceIgnoreOutsideTouch = false;
        mListItemExpandMaximum = 0x7fffffff;
        mPromptPosition = 0;
        mResizePopupRunnable = new ResizePopupRunnable();
        mTouchInterceptor = new PopupTouchInterceptor();
        mScrollListener = new PopupScrollListener();
        mHideSelector = new ListSelectorHider();
        mHandler = new Handler();
        mTempRect = new Rect();
        mContext = context;
        mPopup = new PopupWindow(context, attributeset, i, j);
        mPopup.setInputMethodMode(1);
    }

    private int buildDropDown() {
        int i = 0;
        if(mDropDownList != null) goto _L2; else goto _L1
_L1:
        int j;
        int k;
        int l;
        Object obj;
        View view1;
        LinearLayout linearlayout;
        LinearLayout.LayoutParams layoutparams1;
        Context context = mContext;
        mShowDropDownRunnable = new Runnable() {

            public void run() {
                View view2 = getAnchorView();
                if(view2 != null && view2.getWindowToken() != null)
                    show();
            }

            final ListPopupWindow this$0;

             {
                this$0 = ListPopupWindow.this;
                super();
            }
        };
        Drawable drawable;
        boolean flag1;
        LinearLayout.LayoutParams layoutparams2;
        if(!mModal)
            flag1 = true;
        else
            flag1 = false;
        mDropDownList = new DropDownListView(context, flag1);
        if(mDropDownListHighlight != null)
            mDropDownList.setSelector(mDropDownListHighlight);
        mDropDownList.setAdapter(mAdapter);
        mDropDownList.setOnItemClickListener(mItemClickListener);
        mDropDownList.setFocusable(true);
        mDropDownList.setFocusableInTouchMode(true);
        mDropDownList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView adapterview, View view2, int k1, long l1) {
                if(k1 != -1) {
                    DropDownListView dropdownlistview = mDropDownList;
                    if(dropdownlistview != null)
                        dropdownlistview.mListSelectionHidden = false;
                }
            }

            public void onNothingSelected(AdapterView adapterview) {
            }

            final ListPopupWindow this$0;

             {
                this$0 = ListPopupWindow.this;
                super();
            }
        });
        mDropDownList.setOnScrollListener(mScrollListener);
        if(mItemSelectedListener != null)
            mDropDownList.setOnItemSelectedListener(mItemSelectedListener);
        obj = mDropDownList;
        view1 = mPromptView;
        if(view1 == null) goto _L4; else goto _L3
_L3:
        linearlayout = new LinearLayout(context);
        linearlayout.setOrientation(1);
        layoutparams1 = new LinearLayout.LayoutParams(-1, 0, 1.0F);
        mPromptPosition;
        JVM INSTR tableswitch 0 1: default 224
    //                   0 455
    //                   1 436;
           goto _L5 _L6 _L7
_L5:
        Log.e("ListPopupWindow", (new StringBuilder()).append("Invalid hint position ").append(mPromptPosition).toString());
_L10:
        view1.measure(android.view.View.MeasureSpec.makeMeasureSpec(mDropDownWidth, 0x80000000), 0);
        layoutparams2 = (LinearLayout.LayoutParams)view1.getLayoutParams();
        i = view1.getMeasuredHeight() + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams2)).topMargin + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams2)).bottomMargin;
        obj = linearlayout;
_L4:
        mPopup.setContentView(((View) (obj)));
_L11:
        j = 0;
        drawable = mPopup.getBackground();
        View view;
        LinearLayout.LayoutParams layoutparams;
        boolean flag;
        if(drawable != null) {
            drawable.getPadding(mTempRect);
            j = mTempRect.top + mTempRect.bottom;
            if(!mDropDownVerticalOffsetSet)
                mDropDownVerticalOffset = -mTempRect.top;
        } else {
            mTempRect.setEmpty();
        }
        if(mPopup.getInputMethodMode() == 2)
            flag = true;
        else
            flag = false;
        k = mPopup.getMaxAvailableHeight(getAnchorView(), mDropDownVerticalOffset, flag);
        if(!mDropDownAlwaysVisible && mDropDownHeight != -1) goto _L9; else goto _L8
_L8:
        l = k + j;
_L15:
        return l;
_L7:
        linearlayout.addView(((View) (obj)), layoutparams1);
        linearlayout.addView(view1);
          goto _L10
_L6:
        linearlayout.addView(view1);
        linearlayout.addView(((View) (obj)), layoutparams1);
          goto _L10
_L2:
        (ViewGroup)mPopup.getContentView();
        view = mPromptView;
        if(view != null) {
            layoutparams = (LinearLayout.LayoutParams)view.getLayoutParams();
            i = view.getMeasuredHeight() + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).topMargin + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).bottomMargin;
        }
          goto _L11
_L9:
        mDropDownWidth;
        JVM INSTR tableswitch -2 -1: default 564
    //                   -2 615
    //                   -1 654;
           goto _L12 _L13 _L14
_L14:
        break MISSING_BLOCK_LABEL_654;
_L12:
        int i1 = android.view.View.MeasureSpec.makeMeasureSpec(mDropDownWidth, 0x40000000);
_L16:
        int j1 = mDropDownList.measureHeightOfChildren(i1, 0, -1, k - i, -1);
        if(j1 > 0)
            i += j;
        l = j1 + i;
          goto _L15
_L13:
        i1 = android.view.View.MeasureSpec.makeMeasureSpec(mContext.getResources().getDisplayMetrics().widthPixels - (mTempRect.left + mTempRect.right), 0x80000000);
          goto _L16
        i1 = android.view.View.MeasureSpec.makeMeasureSpec(mContext.getResources().getDisplayMetrics().widthPixels - (mTempRect.left + mTempRect.right), 0x40000000);
          goto _L16
    }

    private void removePromptView() {
        if(mPromptView != null) {
            android.view.ViewParent viewparent = mPromptView.getParent();
            if(viewparent instanceof ViewGroup)
                ((ViewGroup)viewparent).removeView(mPromptView);
        }
    }

    public void clearListSelection() {
        DropDownListView dropdownlistview = mDropDownList;
        if(dropdownlistview != null) {
            dropdownlistview.mListSelectionHidden = true;
            dropdownlistview.hideSelector();
            dropdownlistview.requestLayout();
        }
    }

    public void dismiss() {
        mPopup.dismiss();
        removePromptView();
        mPopup.setContentView(null);
        mDropDownList = null;
        mHandler.removeCallbacks(mResizePopupRunnable);
    }

    public View getAnchorView() {
        return mDropDownAnchorView;
    }

    public int getAnimationStyle() {
        return mPopup.getAnimationStyle();
    }

    public Drawable getBackground() {
        return mPopup.getBackground();
    }

    public int getHeight() {
        return mDropDownHeight;
    }

    public int getHorizontalOffset() {
        return mDropDownHorizontalOffset;
    }

    public int getInputMethodMode() {
        return mPopup.getInputMethodMode();
    }

    public ListView getListView() {
        return mDropDownList;
    }

    public int getPromptPosition() {
        return mPromptPosition;
    }

    public Object getSelectedItem() {
        Object obj;
        if(!isShowing())
            obj = null;
        else
            obj = mDropDownList.getSelectedItem();
        return obj;
    }

    public long getSelectedItemId() {
        long l;
        if(!isShowing())
            l = 0x8000000000000000L;
        else
            l = mDropDownList.getSelectedItemId();
        return l;
    }

    public int getSelectedItemPosition() {
        int i;
        if(!isShowing())
            i = -1;
        else
            i = mDropDownList.getSelectedItemPosition();
        return i;
    }

    public View getSelectedView() {
        View view;
        if(!isShowing())
            view = null;
        else
            view = mDropDownList.getSelectedView();
        return view;
    }

    public int getSoftInputMode() {
        return mPopup.getSoftInputMode();
    }

    public int getVerticalOffset() {
        int i;
        if(!mDropDownVerticalOffsetSet)
            i = 0;
        else
            i = mDropDownVerticalOffset;
        return i;
    }

    public int getWidth() {
        return mDropDownWidth;
    }

    public boolean isDropDownAlwaysVisible() {
        return mDropDownAlwaysVisible;
    }

    public boolean isInputMethodNotNeeded() {
        boolean flag;
        if(mPopup.getInputMethodMode() == 2)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isModal() {
        return mModal;
    }

    public boolean isShowing() {
        return mPopup.isShowing();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent) {
        boolean flag = true;
        if(!isShowing() || i == 62 || mDropDownList.getSelectedItemPosition() < 0 && (i == 66 || i == 23)) goto _L2; else goto _L1
_L1:
        int j;
        boolean flag1;
        int k;
        int l;
        j = mDropDownList.getSelectedItemPosition();
        ListAdapter listadapter;
        if(!mPopup.isAboveAnchor())
            flag1 = flag;
        else
            flag1 = false;
        listadapter = mAdapter;
        k = 0x7fffffff;
        l = 0x80000000;
        if(listadapter != null) {
            boolean flag2 = listadapter.areAllItemsEnabled();
            if(flag2)
                k = 0;
            else
                k = mDropDownList.lookForSelectablePosition(0, flag);
            if(flag2)
                l = -1 + listadapter.getCount();
            else
                l = mDropDownList.lookForSelectablePosition(-1 + listadapter.getCount(), false);
        }
        if((!flag1 || i != 19 || j > k) && (flag1 || i != 20 || j < l)) goto _L4; else goto _L3
_L3:
        clearListSelection();
        mPopup.setInputMethodMode(flag);
        show();
_L7:
        return flag;
_L4:
        mDropDownList.mListSelectionHidden = false;
        if(!mDropDownList.onKeyDown(i, keyevent))
            break; /* Loop/switch isn't completed */
        mPopup.setInputMethodMode(2);
        mDropDownList.requestFocusFromTouch();
        show();
        switch(i) {
        case 19: // '\023'
        case 20: // '\024'
        case 23: // '\027'
        case 66: // 'B'
            continue; /* Loop/switch isn't completed */
        }
_L2:
        flag = false;
        if(true) goto _L6; else goto _L5
_L5:
        continue; /* Loop/switch isn't completed */
_L6:
        break; /* Loop/switch isn't completed */
        if(!flag1 || i != 20 ? flag1 || i != 19 || j != k : j != l) goto _L2; else goto _L7
    }

    public boolean onKeyPreIme(int i, KeyEvent keyevent) {
        boolean flag = true;
        if(i != 4 || !isShowing()) goto _L2; else goto _L1
_L1:
        View view = mDropDownAnchorView;
        if(keyevent.getAction() != 0 || keyevent.getRepeatCount() != 0) goto _L4; else goto _L3
_L3:
        android.view.KeyEvent.DispatcherState dispatcherstate1 = view.getKeyDispatcherState();
        if(dispatcherstate1 != null)
            dispatcherstate1.startTracking(keyevent, this);
_L6:
        return flag;
_L4:
        if(keyevent.getAction() == flag) {
            android.view.KeyEvent.DispatcherState dispatcherstate = view.getKeyDispatcherState();
            if(dispatcherstate != null)
                dispatcherstate.handleUpEvent(keyevent);
            if(keyevent.isTracking() && !keyevent.isCanceled()) {
                dismiss();
                continue; /* Loop/switch isn't completed */
            }
        }
_L2:
        flag = false;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public boolean onKeyUp(int i, KeyEvent keyevent) {
        if(!isShowing() || mDropDownList.getSelectedItemPosition() < 0) goto _L2; else goto _L1
_L1:
        boolean flag = mDropDownList.onKeyUp(i, keyevent);
        if(!flag) goto _L4; else goto _L3
_L3:
        i;
        JVM INSTR lookupswitch 2: default 60
    //                   23: 62
    //                   66: 62;
           goto _L4 _L5 _L5
_L4:
        return flag;
_L5:
        dismiss();
        continue; /* Loop/switch isn't completed */
_L2:
        flag = false;
        if(true) goto _L4; else goto _L6
_L6:
    }

    public boolean performItemClick(int i) {
        boolean flag;
        if(isShowing()) {
            if(mItemClickListener != null) {
                DropDownListView dropdownlistview = mDropDownList;
                View view = dropdownlistview.getChildAt(i - dropdownlistview.getFirstVisiblePosition());
                ListAdapter listadapter = dropdownlistview.getAdapter();
                mItemClickListener.onItemClick(dropdownlistview, view, i, listadapter.getItemId(i));
            }
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public void postShow() {
        mHandler.post(mShowDropDownRunnable);
    }

    public void setAdapter(ListAdapter listadapter) {
        if(mObserver != null) goto _L2; else goto _L1
_L1:
        mObserver = new PopupDataSetObserver();
_L4:
        mAdapter = listadapter;
        if(mAdapter != null)
            listadapter.registerDataSetObserver(mObserver);
        if(mDropDownList != null)
            mDropDownList.setAdapter(mAdapter);
        return;
_L2:
        if(mAdapter != null)
            mAdapter.unregisterDataSetObserver(mObserver);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void setAnchorView(View view) {
        mDropDownAnchorView = view;
    }

    public void setAnimationStyle(int i) {
        mPopup.setAnimationStyle(i);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        mPopup.setBackgroundDrawable(drawable);
    }

    public void setContentWidth(int i) {
        Drawable drawable = mPopup.getBackground();
        if(drawable != null) {
            drawable.getPadding(mTempRect);
            mDropDownWidth = i + (mTempRect.left + mTempRect.right);
        } else {
            setWidth(i);
        }
    }

    public void setDropDownAlwaysVisible(boolean flag) {
        mDropDownAlwaysVisible = flag;
    }

    public void setForceIgnoreOutsideTouch(boolean flag) {
        mForceIgnoreOutsideTouch = flag;
    }

    public void setHeight(int i) {
        mDropDownHeight = i;
    }

    public void setHorizontalOffset(int i) {
        mDropDownHorizontalOffset = i;
    }

    public void setInputMethodMode(int i) {
        mPopup.setInputMethodMode(i);
    }

    void setListItemExpandMax(int i) {
        mListItemExpandMaximum = i;
    }

    public void setListSelector(Drawable drawable) {
        mDropDownListHighlight = drawable;
    }

    public void setModal(boolean flag) {
        mModal = true;
        mPopup.setFocusable(flag);
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener ondismisslistener) {
        mPopup.setOnDismissListener(ondismisslistener);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onitemclicklistener) {
        mItemClickListener = onitemclicklistener;
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onitemselectedlistener) {
        mItemSelectedListener = onitemselectedlistener;
    }

    public void setPromptPosition(int i) {
        mPromptPosition = i;
    }

    public void setPromptView(View view) {
        boolean flag = isShowing();
        if(flag)
            removePromptView();
        mPromptView = view;
        if(flag)
            show();
    }

    public void setSelection(int i) {
        DropDownListView dropdownlistview = mDropDownList;
        if(isShowing() && dropdownlistview != null) {
            dropdownlistview.mListSelectionHidden = false;
            dropdownlistview.setSelection(i);
            if(dropdownlistview.getChoiceMode() != 0)
                dropdownlistview.setItemChecked(i, true);
        }
    }

    public void setSoftInputMode(int i) {
        mPopup.setSoftInputMode(i);
    }

    public void setVerticalOffset(int i) {
        mDropDownVerticalOffset = i;
        mDropDownVerticalOffsetSet = true;
    }

    public void setWidth(int i) {
        mDropDownWidth = i;
    }

    public void show() {
        boolean flag;
        int i;
        byte byte0;
        byte byte1;
        flag = true;
        i = buildDropDown();
        byte0 = 0;
        byte1 = 0;
        boolean flag1 = isInputMethodNotNeeded();
        PopupWindow popupwindow = mPopup;
        boolean flag2;
        PopupWindow popupwindow2;
        PopupWindow popupwindow4;
        if(!flag1)
            flag2 = flag;
        else
            flag2 = false;
        popupwindow.setAllowScrollingAnchorParent(flag2);
        if(!mPopup.isShowing()) goto _L2; else goto _L1
_L1:
        int j;
        int k;
        if(mDropDownWidth == -1)
            j = -1;
        else
        if(mDropDownWidth == -2)
            j = getAnchorView().getWidth();
        else
            j = mDropDownWidth;
        if(mDropDownHeight == -1) {
            if(flag1)
                k = i;
            else
                k = -1;
            if(flag1) {
                popupwindow4 = mPopup;
                byte byte3;
                if(mDropDownWidth == -1)
                    byte3 = -1;
                else
                    byte3 = 0;
                popupwindow4.setWindowLayoutMode(byte3, 0);
            } else {
                PopupWindow popupwindow3 = mPopup;
                byte byte2;
                if(mDropDownWidth == -1)
                    byte2 = -1;
                else
                    byte2 = 0;
                popupwindow3.setWindowLayoutMode(byte2, -1);
            }
        } else
        if(mDropDownHeight == -2)
            k = i;
        else
            k = mDropDownHeight;
        popupwindow2 = mPopup;
        if(mForceIgnoreOutsideTouch || mDropDownAlwaysVisible)
            flag = false;
        popupwindow2.setOutsideTouchable(flag);
        mPopup.update(getAnchorView(), mDropDownHorizontalOffset, mDropDownVerticalOffset, j, k);
_L4:
        return;
_L2:
        PopupWindow popupwindow1;
        if(mDropDownWidth == -1)
            byte0 = -1;
        else
        if(mDropDownWidth == -2)
            mPopup.setWidth(getAnchorView().getWidth());
        else
            mPopup.setWidth(mDropDownWidth);
        if(mDropDownHeight == -1)
            byte1 = -1;
        else
        if(mDropDownHeight == -2)
            mPopup.setHeight(i);
        else
            mPopup.setHeight(mDropDownHeight);
        mPopup.setWindowLayoutMode(byte0, byte1);
        mPopup.setClipToScreenEnabled(flag);
        popupwindow1 = mPopup;
        if(mForceIgnoreOutsideTouch || mDropDownAlwaysVisible)
            flag = false;
        popupwindow1.setOutsideTouchable(flag);
        mPopup.setTouchInterceptor(mTouchInterceptor);
        mPopup.showAsDropDown(getAnchorView(), mDropDownHorizontalOffset, mDropDownVerticalOffset);
        mDropDownList.setSelection(-1);
        if(!mModal || mDropDownList.isInTouchMode())
            clearListSelection();
        if(!mModal)
            mHandler.post(mHideSelector);
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static final boolean DEBUG = false;
    private static final int EXPAND_LIST_TIMEOUT = 250;
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    public static final int MATCH_PARENT = -1;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    private static final String TAG = "ListPopupWindow";
    public static final int WRAP_CONTENT = -2;
    private ListAdapter mAdapter;
    private Context mContext;
    private boolean mDropDownAlwaysVisible;
    private View mDropDownAnchorView;
    private int mDropDownHeight;
    private int mDropDownHorizontalOffset;
    private DropDownListView mDropDownList;
    private Drawable mDropDownListHighlight;
    private int mDropDownVerticalOffset;
    private boolean mDropDownVerticalOffsetSet;
    private int mDropDownWidth;
    private boolean mForceIgnoreOutsideTouch;
    private Handler mHandler;
    private final ListSelectorHider mHideSelector;
    private AdapterView.OnItemClickListener mItemClickListener;
    private AdapterView.OnItemSelectedListener mItemSelectedListener;
    int mListItemExpandMaximum;
    private boolean mModal;
    private DataSetObserver mObserver;
    private PopupWindow mPopup;
    private int mPromptPosition;
    private View mPromptView;
    private final ResizePopupRunnable mResizePopupRunnable;
    private final PopupScrollListener mScrollListener;
    private Runnable mShowDropDownRunnable;
    private Rect mTempRect;
    private final PopupTouchInterceptor mTouchInterceptor;




}

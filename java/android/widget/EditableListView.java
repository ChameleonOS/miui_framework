// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.app.Activity;
import android.content.Context;
import android.util.*;
import android.view.*;

// Referenced classes of package android.widget:
//            ListView, AbsListView, ListAdapter, CheckBox, 
//            AdapterView, Button, PopupMenu

public class EditableListView extends ListView {
    public static class DropDownMenu {

        public MenuItem findItem(int i) {
            return mMenu.findItem(i);
        }

        public void setTitle(CharSequence charsequence) {
            mButton.setText(charsequence);
        }

        private Button mButton;
        private Menu mMenu;
        private PopupMenu mPopupMenu;


        public DropDownMenu(Context context, Button button, int i, PopupMenu.OnMenuItemClickListener onmenuitemclicklistener) {
            mButton = button;
            mButton.setBackgroundResource(0x602016b);
            mPopupMenu = new PopupMenu(context, mButton);
            mMenu = mPopupMenu.getMenu();
            mPopupMenu.getMenuInflater().inflate(i, mMenu);
            mPopupMenu.setOnMenuItemClickListener(onmenuitemclicklistener);
            mButton.setOnClickListener(new android.view.View.OnClickListener() {

                public void onClick(View view) {
                    mPopupMenu.show();
                }

                final DropDownMenu this$0;

                 {
                    this$0 = DropDownMenu.this;
                    super();
                }
            });
        }
    }

    public static class EditableModeCallback
        implements EditableListViewListener, PopupMenu.OnMenuItemClickListener {

        private void updateSelectionMenu() {
            String s = getTitle(mEditableListView.getCheckedItemCount());
            mSelectionMenu.setTitle(s);
            MenuItem menuitem = mSelectionMenu.findItem(0x60b0025);
            if(menuitem != null)
                if(mEditableListView.isAllChecked())
                    menuitem.setTitle(0x60c0178);
                else
                    menuitem.setTitle(0x60c0177);
        }

        public String getTitle(int i) {
            Activity activity = mActivity;
            Object aobj[] = new Object[1];
            aobj[0] = Integer.valueOf(i);
            return activity.getString(0x60c0179, aobj);
        }

        public boolean onActionItemClicked(ActionMode actionmode, MenuItem menuitem) {
            menuitem.getItemId();
            JVM INSTR tableswitch 101384228 101384228: default 24
        //                       101384228 26;
               goto _L1 _L2
_L1:
            return true;
_L2:
            actionmode.finish();
            if(true) goto _L1; else goto _L3
_L3:
        }

        public void onBatchCheckedStateChanged(ActionMode actionmode, boolean flag) {
            updateSelectionMenu();
        }

        public boolean onCreateActionMode(ActionMode actionmode, Menu menu) {
            View view = LayoutInflater.from(mActivity).inflate(0x603001e, null);
            actionmode.setCustomView(view);
            mSelectionMenu = new DropDownMenu(mActivity, (Button)view.findViewById(0x60b0002), mActionBarMenuId, this);
            mActivity.getMenuInflater().inflate(mSplitActionBarMenuId, menu);
            return true;
        }

        public void onDestroyActionMode(ActionMode actionmode) {
            if(mSelectionMenu.mPopupMenu != null)
                mSelectionMenu.mPopupMenu.dismiss();
        }

        public void onItemCheckedStateChanged(ActionMode actionmode, int i, long l, boolean flag) {
            updateSelectionMenu();
        }

        public boolean onMenuItemClick(MenuItem menuitem) {
            menuitem.getItemId();
            JVM INSTR tableswitch 101384229 101384229: default 24
        //                       101384229 26;
               goto _L1 _L2
_L1:
            return true;
_L2:
            if(mEditableListView.isAllChecked())
                mEditableListView.checkNothing();
            else
                mEditableListView.checkAll();
            if(true) goto _L1; else goto _L3
_L3:
        }

        public boolean onPrepareActionMode(ActionMode actionmode, Menu menu) {
            return false;
        }

        public void setActionBarMenuId(int i) {
            mActionBarMenuId = i;
        }

        public void setSplitActionBarMenuId(int i) {
            mSplitActionBarMenuId = i;
        }

        private int mActionBarMenuId;
        private Activity mActivity;
        private EditableListView mEditableListView;
        private DropDownMenu mSelectionMenu;
        private int mSplitActionBarMenuId;

        public EditableModeCallback(Activity activity, EditableListView editablelistview) {
            mActionBarMenuId = 0x60e0000;
            mSplitActionBarMenuId = 0x60e0001;
            mActivity = activity;
            mEditableListView = editablelistview;
        }
    }

    class EditableModeWrapper extends AbsListView.MultiChoiceModeWrapper
        implements EditableListViewListener {

        private void handleCheckedStateChanged(ActionMode actionmode) {
            if(!mIsUpdateBatchChecked && !mKeepEditModeIfNoItemChecked && getCheckedItemCount() == 0)
                actionmode.finish();
        }

        public void onBatchCheckedStateChanged(ActionMode actionmode, boolean flag) {
            mMultiChoiceModeListener.onBatchCheckedStateChanged(actionmode, flag);
            handleCheckedStateChanged(actionmode);
        }

        public void onItemCheckedStateChanged(ActionMode actionmode, int i, long l, boolean flag) {
            if(isValidPos(i)) {
                mMultiChoiceModeListener.onItemCheckedStateChanged(actionmode, i, l, flag);
                handleCheckedStateChanged(actionmode);
                updateOnScreenCheckedViews();
            }
        }

        final EditableListView this$0;

        EditableModeWrapper() {
            this$0 = EditableListView.this;
            super(EditableListView.this);
        }
    }

    public static interface EditableListViewListener
        extends AbsListView.MultiChoiceModeListener {

        public abstract void onBatchCheckedStateChanged(ActionMode actionmode, boolean flag);
    }


    public EditableListView(Context context) {
        super(context);
    }

    public EditableListView(Context context, AttributeSet attributeset) {
        super(context, attributeset);
    }

    private void enterEditModeInner() {
        if(super.mMultiChoiceModeCallback != null)
            startActionMode(super.mMultiChoiceModeCallback);
    }

    private int getEnabledCount() {
        int i = getHeaderViewsCount();
        int j = super.mAdapter.getCount() - getFooterViewsCount();
        int k = 0;
        for(int l = i; l < j; l++)
            if(super.mAdapter.isEnabled(l))
                k++;

        return k;
    }

    private boolean isValidPos(int i) {
        int j = getHeaderViewsCount();
        int k = super.mAdapter.getCount() - getFooterViewsCount();
        boolean flag;
        if(i >= j && i < k)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private void updateBatchChecked(boolean flag) {
        boolean flag1 = true;
        if(super.mChoiceActionMode != null && super.mAdapter != null && super.mChoiceMode == 3) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int k;
        mIsUpdateBatchChecked = flag1;
        int i = getHeaderViewsCount();
        int j = super.mAdapter.getCount() - getFooterViewsCount();
        if(super.mCheckedIdStates == null || !super.mAdapter.hasStableIds())
            flag1 = false;
        k = i;
        if(k >= j)
            break MISSING_BLOCK_LABEL_222;
        if(super.mAdapter.isEnabled(k))
            break; /* Loop/switch isn't completed */
_L8:
        k++;
        if(true) goto _L4; else goto _L3
_L4:
        break MISSING_BLOCK_LABEL_73;
_L3:
        if(!flag)
            continue; /* Loop/switch isn't completed */
        if(super.mCheckStates.get(k)) goto _L6; else goto _L5
_L5:
        super.mCheckedItemCount = 1 + super.mCheckedItemCount;
_L11:
        super.mCheckStates.put(k, flag);
        if(flag1)
            if(flag)
                super.mCheckedIdStates.put(super.mAdapter.getItemId(k), Integer.valueOf(k));
            else
                super.mCheckedIdStates.delete(super.mAdapter.getItemId(k));
_L6:
        if(true) goto _L8; else goto _L7
_L7:
        if(!super.mCheckStates.get(k)) goto _L10; else goto _L9
_L9:
        break MISSING_BLOCK_LABEL_187;
_L10:
        break; /* Loop/switch isn't completed */
        super.mCheckedItemCount = -1 + super.mCheckedItemCount;
          goto _L11
        ((EditableModeWrapper)super.mMultiChoiceModeCallback).onBatchCheckedStateChanged(super.mChoiceActionMode, flag);
        updateOnScreenCheckedViews();
        mIsUpdateBatchChecked = false;
        if(true) goto _L1; else goto _L12
_L12:
    }

    private void updateCheckBoxState(CheckBox checkbox, int i) {
        if(checkbox != null && isValidPos(i)) {
            int j;
            if(isEditMode() || mShowCheckBoxInNoneEditMode)
                j = 0;
            else
                j = 8;
            checkbox.setVisibility(j);
            checkbox.setChecked(super.mCheckStates.get(i));
        }
    }

    private void updateOnScreenCheckedViews() {
        int i = super.mFirstPosition;
        int j = getChildCount();
        for(int k = 0; k < j; k++) {
            View view = getChildAt(k);
            int l = i + k;
            updateCheckBoxState((CheckBox)view.findViewById(0x1020001), l);
        }

    }

    public void checkAll() {
        updateBatchChecked(true);
    }

    public void checkNothing() {
        updateBatchChecked(false);
    }

    public void enterEditMode() {
        if(super.mMultiChoiceModeCallback != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        super.mChoiceActionMode = startActionMode(super.mMultiChoiceModeCallback);
        mMultiChoiceModeListener.onItemCheckedStateChanged(super.mChoiceActionMode, -1, -1L, false);
        if(!super.mInLayout && !super.mBlockLayoutRequests) {
            super.mDataChanged = true;
            rememberSyncState();
            requestLayout();
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void exitEditMode() {
        if(super.mChoiceActionMode != null)
            super.mChoiceActionMode.finish();
    }

    public boolean isAllChecked() {
        boolean flag = false;
        if(super.mAdapter != null && getEnabledCount() == getCheckedItemCount())
            flag = true;
        return flag;
    }

    public boolean isEditMode() {
        boolean flag;
        if(super.mChoiceActionMode != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isItemCheckedById(long l) {
        Integer integer = (Integer)super.mCheckedIdStates.get(l);
        boolean flag;
        if(integer != null)
            flag = isItemChecked(integer.intValue());
        else
            flag = false;
        return flag;
    }

    View obtainView(int i, boolean aflag[]) {
        View view = super.obtainView(i, aflag);
        updateCheckBoxState((CheckBox)view.findViewById(0x1020001), i);
        return view;
    }

    public void setCheckBoxVisiableInNoneEditMode(boolean flag) {
        mShowCheckBoxInNoneEditMode = flag;
    }

    public void setItemChecked(int i, boolean flag) {
        if(isValidPos(i))
            super.setItemChecked(i, flag);
    }

    public void setKeepExitModeIfNoItemChecked(boolean flag) {
        mKeepEditModeIfNoItemChecked = flag;
    }

    public void setMultiChoiceModeListener(AbsListView.MultiChoiceModeListener multichoicemodelistener) {
        Log.e("EditableListView", "should use setMultiChoiceModeListener(final EditableListViewListener listener)");
    }

    public void setMultiChoiceModeListener(EditableListViewListener editablelistviewlistener) {
        if(super.mMultiChoiceModeCallback == null)
            super.mMultiChoiceModeCallback = new EditableModeWrapper();
        mMultiChoiceModeListener = editablelistviewlistener;
        super.mMultiChoiceModeCallback.setWrapped(editablelistviewlistener);
        setChoiceMode(3);
        AdapterView.OnItemLongClickListener onitemlongclicklistener;
        if(editablelistviewlistener == null)
            onitemlongclicklistener = null;
        else
            onitemlongclicklistener = mOnItemLongClickListener;
        setOnItemLongClickListener(onitemlongclicklistener);
    }

    private static final String TAG = "EditableListView";
    private boolean mIsUpdateBatchChecked;
    private boolean mKeepEditModeIfNoItemChecked;
    private EditableListViewListener mMultiChoiceModeListener;
    private AdapterView.OnItemLongClickListener mOnItemLongClickListener = new AdapterView.OnItemLongClickListener() {

        public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l) {
            enterEditModeInner();
            return true;
        }

        final EditableListView this$0;

             {
                this$0 = EditableListView.this;
                super();
            }
    };
    private boolean mShowCheckBoxInNoneEditMode;






}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.*;
import android.util.AttributeSet;
import android.util.Log;
import android.view.*;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.InputMethodManager;

// Referenced classes of package android.widget:
//            EditText, ListPopupWindow, ListAdapter, Filter, 
//            Filterable, Adapter, TextView, ListView, 
//            AdapterView

public class AutoCompleteTextView extends EditText
    implements Filter.FilterListener {
    private class PopupDataSetObserver extends DataSetObserver {

        public void onChanged() {
            if(mAdapter != null)
                post(new Runnable() {

                    public void run() {
                        ListAdapter listadapter = mAdapter;
                        if(listadapter != null)
                            updateDropDownForFilter(listadapter.getCount());
                    }

                    final PopupDataSetObserver this$1;

                 {
                    this$1 = PopupDataSetObserver.this;
                    super();
                }
                });
        }

        final AutoCompleteTextView this$0;

        private PopupDataSetObserver() {
            this$0 = AutoCompleteTextView.this;
            super();
        }

    }

    private class PassThroughClickListener
        implements android.view.View.OnClickListener {

        public void onClick(View view) {
            onClickImpl();
            if(mWrapped != null)
                mWrapped.onClick(view);
        }

        private android.view.View.OnClickListener mWrapped;
        final AutoCompleteTextView this$0;


/*
        static android.view.View.OnClickListener access$302(PassThroughClickListener passthroughclicklistener, android.view.View.OnClickListener onclicklistener) {
            passthroughclicklistener.mWrapped = onclicklistener;
            return onclicklistener;
        }

*/

        private PassThroughClickListener() {
            this$0 = AutoCompleteTextView.this;
            super();
        }

    }

    public static interface Validator {

        public abstract CharSequence fixText(CharSequence charsequence);

        public abstract boolean isValid(CharSequence charsequence);
    }

    private class DropDownItemClickListener
        implements AdapterView.OnItemClickListener {

        public void onItemClick(AdapterView adapterview, View view, int i, long l) {
            performCompletion(view, i, l);
        }

        final AutoCompleteTextView this$0;

        private DropDownItemClickListener() {
            this$0 = AutoCompleteTextView.this;
            super();
        }

    }

    private class MyWatcher
        implements TextWatcher {

        public void afterTextChanged(Editable editable) {
            doAfterTextChanged();
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k) {
            doBeforeTextChanged();
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k) {
        }

        final AutoCompleteTextView this$0;

        private MyWatcher() {
            this$0 = AutoCompleteTextView.this;
            super();
        }

    }


    public AutoCompleteTextView(Context context) {
        this(context, null);
    }

    public AutoCompleteTextView(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0x101006b);
    }

    public AutoCompleteTextView(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        mDropDownDismissedOnCompletion = true;
        mLastKeyCode = 0;
        mValidator = null;
        mPopupCanBeUpdated = true;
        mPopup = new ListPopupWindow(context, attributeset, 0x101006b);
        mPopup.setSoftInputMode(16);
        mPopup.setPromptPosition(1);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.AutoCompleteTextView, i, 0);
        mThreshold = typedarray.getInt(2, 2);
        mPopup.setListSelector(typedarray.getDrawable(3));
        mPopup.setVerticalOffset((int)typedarray.getDimension(9, 0.0F));
        mPopup.setHorizontalOffset((int)typedarray.getDimension(8, 0.0F));
        mDropDownAnchorId = typedarray.getResourceId(6, -1);
        mPopup.setWidth(typedarray.getLayoutDimension(5, -2));
        mPopup.setHeight(typedarray.getLayoutDimension(7, -2));
        mHintResource = typedarray.getResourceId(1, 0x10900a9);
        mPopup.setOnItemClickListener(new DropDownItemClickListener());
        setCompletionHint(typedarray.getText(0));
        int j = getInputType();
        if((j & 0xf) == 1)
            setRawInputType(j | 0x10000);
        typedarray.recycle();
        setFocusable(true);
        addTextChangedListener(new MyWatcher());
        mPassThroughClickListener = new PassThroughClickListener();
        super.setOnClickListener(mPassThroughClickListener);
    }

    private void buildImeCompletions() {
        ListAdapter listadapter = mAdapter;
        if(listadapter != null) {
            InputMethodManager inputmethodmanager = InputMethodManager.peekInstance();
            if(inputmethodmanager != null) {
                int i = Math.min(listadapter.getCount(), 20);
                CompletionInfo acompletioninfo[] = new CompletionInfo[i];
                int j = 0;
                for(int k = 0; k < i; k++)
                    if(listadapter.isEnabled(k)) {
                        Object obj = listadapter.getItem(k);
                        acompletioninfo[j] = new CompletionInfo(listadapter.getItemId(k), j, convertSelectionToString(obj));
                        j++;
                    }

                if(j != i) {
                    CompletionInfo acompletioninfo1[] = new CompletionInfo[j];
                    System.arraycopy(acompletioninfo, 0, acompletioninfo1, 0, j);
                    acompletioninfo = acompletioninfo1;
                }
                inputmethodmanager.displayCompletions(this, acompletioninfo);
            }
        }
    }

    private void onClickImpl() {
        if(isPopupShowing())
            ensureImeVisible(true);
    }

    private void performCompletion(View view, int i, long l) {
        if(!isPopupShowing()) goto _L2; else goto _L1
_L1:
        Object obj;
        if(i < 0)
            obj = mPopup.getSelectedItem();
        else
            obj = mAdapter.getItem(i);
        if(obj != null) goto _L4; else goto _L3
_L3:
        Log.w("AutoCompleteTextView", "performCompletion: no selected item");
_L6:
        return;
_L4:
        mBlockCompletion = true;
        replaceText(convertSelectionToString(obj));
        mBlockCompletion = false;
        if(mItemClickListener != null) {
            ListPopupWindow listpopupwindow = mPopup;
            if(view == null || i < 0) {
                view = listpopupwindow.getSelectedView();
                i = listpopupwindow.getSelectedItemPosition();
                l = listpopupwindow.getSelectedItemId();
            }
            mItemClickListener.onItemClick(listpopupwindow.getListView(), view, i, l);
        }
_L2:
        if(mDropDownDismissedOnCompletion && !mPopup.isDropDownAlwaysVisible())
            dismissDropDown();
        if(true) goto _L6; else goto _L5
_L5:
    }

    private void updateDropDownForFilter(int i) {
        if(getWindowVisibility() != 8) goto _L2; else goto _L1
_L1:
        return;
_L2:
        boolean flag = mPopup.isDropDownAlwaysVisible();
        boolean flag1 = enoughToFilter();
        if((i > 0 || flag) && flag1) {
            if(hasFocus() && hasWindowFocus() && mPopupCanBeUpdated)
                showDropDown();
        } else
        if(!flag && isPopupShowing()) {
            dismissDropDown();
            mPopupCanBeUpdated = true;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void clearListSelection() {
        mPopup.clearListSelection();
    }

    protected CharSequence convertSelectionToString(Object obj) {
        return mFilter.convertResultToString(obj);
    }

    public void dismissDropDown() {
        InputMethodManager inputmethodmanager = InputMethodManager.peekInstance();
        if(inputmethodmanager != null)
            inputmethodmanager.displayCompletions(this, null);
        mPopup.dismiss();
        mPopupCanBeUpdated = false;
    }

    void doAfterTextChanged() {
_L2:
        return;
        if(mBlockCompletion || mOpenBefore && !isPopupShowing()) goto _L2; else goto _L1
_L1:
        if(enoughToFilter()) {
            if(mFilter != null) {
                mPopupCanBeUpdated = true;
                performFiltering(getText(), mLastKeyCode);
            }
        } else {
            if(!mPopup.isDropDownAlwaysVisible())
                dismissDropDown();
            if(mFilter != null)
                mFilter.filter(null);
        }
        if(true) goto _L2; else goto _L3
_L3:
    }

    void doBeforeTextChanged() {
        if(!mBlockCompletion)
            mOpenBefore = isPopupShowing();
    }

    public boolean enoughToFilter() {
        boolean flag;
        if(getText().length() >= mThreshold)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void ensureImeVisible(boolean flag) {
        ListPopupWindow listpopupwindow = mPopup;
        int i;
        if(flag)
            i = 1;
        else
            i = 2;
        listpopupwindow.setInputMethodMode(i);
        if(mPopup.isDropDownAlwaysVisible() || mFilter != null && enoughToFilter())
            showDropDown();
    }

    public ListAdapter getAdapter() {
        return mAdapter;
    }

    public CharSequence getCompletionHint() {
        return mHintText;
    }

    public int getDropDownAnchor() {
        return mDropDownAnchorId;
    }

    public int getDropDownAnimationStyle() {
        return mPopup.getAnimationStyle();
    }

    public Drawable getDropDownBackground() {
        return mPopup.getBackground();
    }

    public int getDropDownHeight() {
        return mPopup.getHeight();
    }

    public int getDropDownHorizontalOffset() {
        return mPopup.getHorizontalOffset();
    }

    public int getDropDownVerticalOffset() {
        return mPopup.getVerticalOffset();
    }

    public int getDropDownWidth() {
        return mPopup.getWidth();
    }

    protected Filter getFilter() {
        return mFilter;
    }

    public AdapterView.OnItemClickListener getItemClickListener() {
        return mItemClickListener;
    }

    public AdapterView.OnItemSelectedListener getItemSelectedListener() {
        return mItemSelectedListener;
    }

    public int getListSelection() {
        return mPopup.getSelectedItemPosition();
    }

    public AdapterView.OnItemClickListener getOnItemClickListener() {
        return mItemClickListener;
    }

    public AdapterView.OnItemSelectedListener getOnItemSelectedListener() {
        return mItemSelectedListener;
    }

    public int getThreshold() {
        return mThreshold;
    }

    public Validator getValidator() {
        return mValidator;
    }

    public boolean isDropDownAlwaysVisible() {
        return mPopup.isDropDownAlwaysVisible();
    }

    public boolean isDropDownDismissedOnCompletion() {
        return mDropDownDismissedOnCompletion;
    }

    public boolean isInputMethodNotNeeded() {
        boolean flag;
        if(mPopup.getInputMethodMode() == 2)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isPerformingCompletion() {
        return mBlockCompletion;
    }

    public boolean isPopupShowing() {
        return mPopup.isShowing();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void onCommitCompletion(CompletionInfo completioninfo) {
        if(isPopupShowing())
            mPopup.performItemClick(completioninfo.getPosition());
    }

    protected void onDetachedFromWindow() {
        dismissDropDown();
        super.onDetachedFromWindow();
    }

    protected void onDisplayHint(int i) {
        super.onDisplayHint(i);
        i;
        JVM INSTR tableswitch 4 4: default 24
    //                   4 25;
           goto _L1 _L2
_L1:
        return;
_L2:
        if(!mPopup.isDropDownAlwaysVisible())
            dismissDropDown();
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void onFilterComplete(int i) {
        updateDropDownForFilter(i);
    }

    protected void onFocusChanged(boolean flag, int i, Rect rect) {
        super.onFocusChanged(flag, i, rect);
        if(!flag)
            performValidation();
        if(!flag && !mPopup.isDropDownAlwaysVisible())
            dismissDropDown();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent) {
        boolean flag = true;
        if(!mPopup.onKeyDown(i, keyevent)) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(!isPopupShowing())
            switch(i) {
            case 20: // '\024'
                break; /* Loop/switch isn't completed */
            }
_L4:
        if(!isPopupShowing() || i != 61 || !keyevent.hasNoModifiers()) {
            mLastKeyCode = i;
            flag = super.onKeyDown(i, keyevent);
            mLastKeyCode = 0;
            if(flag && isPopupShowing())
                clearListSelection();
        }
        if(true) goto _L1; else goto _L3
_L3:
        if(keyevent.hasNoModifiers())
            performValidation();
          goto _L4
        if(true) goto _L1; else goto _L5
_L5:
    }

    public boolean onKeyPreIme(int i, KeyEvent keyevent) {
        boolean flag = true;
        if(i != 4 || !isPopupShowing() || mPopup.isDropDownAlwaysVisible()) goto _L2; else goto _L1
_L1:
        if(keyevent.getAction() != 0 || keyevent.getRepeatCount() != 0) goto _L4; else goto _L3
_L3:
        android.view.KeyEvent.DispatcherState dispatcherstate1 = getKeyDispatcherState();
        if(dispatcherstate1 != null)
            dispatcherstate1.startTracking(keyevent, this);
_L6:
        return flag;
_L4:
        if(keyevent.getAction() == flag) {
            android.view.KeyEvent.DispatcherState dispatcherstate = getKeyDispatcherState();
            if(dispatcherstate != null)
                dispatcherstate.handleUpEvent(keyevent);
            if(keyevent.isTracking() && !keyevent.isCanceled()) {
                dismissDropDown();
                continue; /* Loop/switch isn't completed */
            }
        }
_L2:
        flag = super.onKeyPreIme(i, keyevent);
        if(true) goto _L6; else goto _L5
_L5:
    }

    public boolean onKeyUp(int i, KeyEvent keyevent) {
        boolean flag = true;
        if(!mPopup.onKeyUp(i, keyevent)) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR lookupswitch 3: default 48
    //                   23: 74
    //                   61: 74
    //                   66: 74;
           goto _L2 _L3 _L3 _L3
_L2:
        if(isPopupShowing() && i == 61 && keyevent.hasNoModifiers())
            performCompletion();
        else
            flag = super.onKeyUp(i, keyevent);
_L5:
        return flag;
_L3:
        if(keyevent.hasNoModifiers())
            performCompletion();
        if(true) goto _L5; else goto _L4
_L4:
    }

    public void onWindowFocusChanged(boolean flag) {
        super.onWindowFocusChanged(flag);
        if(!flag && !mPopup.isDropDownAlwaysVisible())
            dismissDropDown();
    }

    public void performCompletion() {
        performCompletion(null, -1, -1L);
    }

    protected void performFiltering(CharSequence charsequence, int i) {
        mFilter.filter(charsequence, this);
    }

    public void performValidation() {
        if(mValidator != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Editable editable = getText();
        if(!TextUtils.isEmpty(editable) && !mValidator.isValid(editable))
            setText(mValidator.fixText(editable));
        if(true) goto _L1; else goto _L3
_L3:
    }

    protected void replaceText(CharSequence charsequence) {
        clearComposingText();
        setText(charsequence);
        Editable editable = getText();
        Selection.setSelection(editable, editable.length());
    }

    public void setAdapter(ListAdapter listadapter) {
        if(mObserver == null)
            mObserver = new PopupDataSetObserver();
        else
        if(mAdapter != null)
            mAdapter.unregisterDataSetObserver(mObserver);
        mAdapter = listadapter;
        if(mAdapter != null) {
            mFilter = ((Filterable)mAdapter).getFilter();
            listadapter.registerDataSetObserver(mObserver);
        } else {
            mFilter = null;
        }
        mPopup.setAdapter(mAdapter);
    }

    public void setCompletionHint(CharSequence charsequence) {
        mHintText = charsequence;
        if(charsequence != null) {
            if(mHintView == null) {
                TextView textview = (TextView)LayoutInflater.from(getContext()).inflate(mHintResource, null).findViewById(0x1020014);
                textview.setText(mHintText);
                mHintView = textview;
                mPopup.setPromptView(textview);
            } else {
                mHintView.setText(charsequence);
            }
        } else {
            mPopup.setPromptView(null);
            mHintView = null;
        }
    }

    public void setDropDownAlwaysVisible(boolean flag) {
        mPopup.setDropDownAlwaysVisible(flag);
    }

    public void setDropDownAnchor(int i) {
        mDropDownAnchorId = i;
        mPopup.setAnchorView(null);
    }

    public void setDropDownAnimationStyle(int i) {
        mPopup.setAnimationStyle(i);
    }

    public void setDropDownBackgroundDrawable(Drawable drawable) {
        mPopup.setBackgroundDrawable(drawable);
    }

    public void setDropDownBackgroundResource(int i) {
        mPopup.setBackgroundDrawable(getResources().getDrawable(i));
    }

    public void setDropDownDismissedOnCompletion(boolean flag) {
        mDropDownDismissedOnCompletion = flag;
    }

    public void setDropDownHeight(int i) {
        mPopup.setHeight(i);
    }

    public void setDropDownHorizontalOffset(int i) {
        mPopup.setHorizontalOffset(i);
    }

    public void setDropDownVerticalOffset(int i) {
        mPopup.setVerticalOffset(i);
    }

    public void setDropDownWidth(int i) {
        mPopup.setWidth(i);
    }

    public void setForceIgnoreOutsideTouch(boolean flag) {
        mPopup.setForceIgnoreOutsideTouch(flag);
    }

    protected boolean setFrame(int i, int j, int k, int l) {
        boolean flag = super.setFrame(i, j, k, l);
        if(isPopupShowing())
            showDropDown();
        return flag;
    }

    public void setListSelection(int i) {
        mPopup.setSelection(i);
    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener) {
        mPassThroughClickListener.mWrapped = onclicklistener;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onitemclicklistener) {
        mItemClickListener = onitemclicklistener;
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onitemselectedlistener) {
        mItemSelectedListener = onitemselectedlistener;
    }

    public void setText(CharSequence charsequence, boolean flag) {
        if(flag) {
            setText(charsequence);
        } else {
            mBlockCompletion = true;
            setText(charsequence);
            mBlockCompletion = false;
        }
    }

    public void setThreshold(int i) {
        if(i <= 0)
            i = 1;
        mThreshold = i;
    }

    public void setValidator(Validator validator) {
        mValidator = validator;
    }

    public void showDropDown() {
        buildImeCompletions();
        if(mPopup.getAnchorView() == null)
            if(mDropDownAnchorId != -1)
                mPopup.setAnchorView(getRootView().findViewById(mDropDownAnchorId));
            else
                mPopup.setAnchorView(this);
        if(!isPopupShowing()) {
            mPopup.setInputMethodMode(1);
            mPopup.setListItemExpandMax(3);
        }
        mPopup.show();
        mPopup.getListView().setOverScrollMode(0);
    }

    public void showDropDownAfterLayout() {
        mPopup.postShow();
    }

    static final boolean DEBUG = false;
    static final int EXPAND_MAX = 3;
    static final String TAG = "AutoCompleteTextView";
    private ListAdapter mAdapter;
    private boolean mBlockCompletion;
    private int mDropDownAnchorId;
    private boolean mDropDownDismissedOnCompletion;
    private Filter mFilter;
    private int mHintResource;
    private CharSequence mHintText;
    private TextView mHintView;
    private AdapterView.OnItemClickListener mItemClickListener;
    private AdapterView.OnItemSelectedListener mItemSelectedListener;
    private int mLastKeyCode;
    private PopupDataSetObserver mObserver;
    private boolean mOpenBefore;
    private PassThroughClickListener mPassThroughClickListener;
    private ListPopupWindow mPopup;
    private boolean mPopupCanBeUpdated;
    private int mThreshold;
    private Validator mValidator;




}

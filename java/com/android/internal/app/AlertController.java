// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.*;
import android.widget.*;
import java.lang.ref.WeakReference;

public class AlertController {
    public static class AlertParams {
        public static interface OnPrepareListViewListener {

            public abstract void onPrepareListView(ListView listview);
        }


        private void createListView(final AlertController dialog) {
            final RecycleListView listView = (RecycleListView)mInflater.inflate(dialog.mListLayout, null);
            Object obj;
            if(mIsMultiChoice) {
                if(mCursor == null) {
                    obj = new ArrayAdapter(dialog.mMultiChoiceItemLayout, 0x1020014, mItems, listView) {

                        public View getView(int j, View view, ViewGroup viewgroup) {
                            View view1 = super.getView(j, view, viewgroup);
                            if(mCheckedItems != null && mCheckedItems[j])
                                listView.setItemChecked(j, true);
                            return view1;
                        }

                        final AlertParams this$0;
                        final RecycleListView val$listView;

                 {
                    this$0 = AlertParams.this;
                    listView = recyclelistview;
                    super(final_context, i, j, acharsequence);
                }
                    };
                } else {
                    final Context final_context = mContext;
                    final Cursor final_cursor = mCursor;
                    obj = new CursorAdapter(false, listView, dialog) {

                        public void bindView(View view, Context context1, Cursor cursor1) {
                            boolean flag = true;
                            ((CheckedTextView)view.findViewById(0x1020014)).setText(cursor1.getString(mLabelIndex));
                            RecycleListView recyclelistview = listView;
                            int j = cursor1.getPosition();
                            if(cursor1.getInt(mIsCheckedIndex) != flag)
                                flag = false;
                            recyclelistview.setItemChecked(j, flag);
                        }

                        public View newView(Context context1, Cursor cursor1, ViewGroup viewgroup) {
                            return mInflater.inflate(dialog.mMultiChoiceItemLayout, viewgroup, false);
                        }

                        private final int mIsCheckedIndex;
                        private final int mLabelIndex;
                        final AlertParams this$0;
                        final AlertController val$dialog;
                        final RecycleListView val$listView;

                 {
                    this$0 = AlertParams.this;
                    listView = recyclelistview;
                    dialog = alertcontroller;
                    super(final_context, final_cursor, flag);
                    Cursor cursor1 = getCursor();
                    mLabelIndex = cursor1.getColumnIndexOrThrow(mLabelColumn);
                    mIsCheckedIndex = cursor1.getColumnIndexOrThrow(mIsCheckedColumn);
                }
                    };
                }
            } else {
                int i;
                if(mIsSingleChoice)
                    i = dialog.mSingleChoiceItemLayout;
                else
                    i = dialog.mListItemLayout;
                if(mCursor == null) {
                    if(mAdapter != null)
                        obj = mAdapter;
                    else
                        obj = new ArrayAdapter(mContext, i, 0x1020014, mItems);
                } else {
                    Context context = mContext;
                    Cursor cursor = mCursor;
                    String as[] = new String[1];
                    as[0] = mLabelColumn;
                    int ai[] = new int[1];
                    ai[0] = 0x1020014;
                    obj = new SimpleCursorAdapter(context, i, cursor, as, ai);
                }
            }
            if(mOnPrepareListViewListener != null)
                mOnPrepareListViewListener.onPrepareListView(listView);
            dialog.mAdapter = ((ListAdapter) (obj));
            dialog.mCheckedItem = mCheckedItem;
            if(mOnClickListener != null)
                listView.setOnItemClickListener(dialog. new android.widget.AdapterView.OnItemClickListener() {

                    public void onItemClick(AdapterView adapterview, View view, int j, long l) {
                        mOnClickListener.onClick(dialog.mDialogInterface, j);
                        if(!mIsSingleChoice)
                            dialog.mDialogInterface.dismiss();
                    }

                    final AlertParams this$0;
                    final AlertController val$dialog;


// JavaClassFileOutputException: Invalid index accessing method local variables table of <init>
                });
            else
            if(mOnCheckboxClickListener != null)
                listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                    public void onItemClick(AdapterView adapterview, View view, int j, long l) {
                        if(mCheckedItems != null)
                            mCheckedItems[j] = listView.isItemChecked(j);
                        mOnCheckboxClickListener.onClick(dialog.mDialogInterface, j, listView.isItemChecked(j));
                    }

                    final AlertParams this$0;
                    final AlertController val$dialog;
                    final RecycleListView val$listView;

                 {
                    this$0 = AlertParams.this;
                    listView = recyclelistview;
                    dialog = alertcontroller;
                    super();
                }
                });
            if(mOnItemSelectedListener != null)
                listView.setOnItemSelectedListener(mOnItemSelectedListener);
            if(mIsSingleChoice)
                listView.setChoiceMode(1);
            else
            if(mIsMultiChoice)
                listView.setChoiceMode(2);
            listView.mRecycleOnMeasure = mRecycleOnMeasure;
            dialog.mListView = listView;
        }

        public void apply(AlertController alertcontroller) {
            if(mCustomTitleView != null) {
                alertcontroller.setCustomTitle(mCustomTitleView);
            } else {
                if(mTitle != null)
                    alertcontroller.setTitle(mTitle);
                if(mIcon != null)
                    alertcontroller.setIcon(mIcon);
                if(mIconId >= 0)
                    alertcontroller.setIcon(mIconId);
            }
            if(mMessage != null)
                alertcontroller.setMessage(mMessage);
            if(mPositiveButtonText != null)
                alertcontroller.setButton(-1, mPositiveButtonText, mPositiveButtonListener, null);
            if(mNegativeButtonText != null)
                alertcontroller.setButton(-2, mNegativeButtonText, mNegativeButtonListener, null);
            if(mNeutralButtonText != null)
                alertcontroller.setButton(-3, mNeutralButtonText, mNeutralButtonListener, null);
            if(mForceInverseBackground)
                alertcontroller.setInverseBackgroundForced(true);
            if(mItems != null || mCursor != null || mAdapter != null)
                createListView(alertcontroller);
            if(mView != null)
                if(mViewSpacingSpecified)
                    alertcontroller.setView(mView, mViewSpacingLeft, mViewSpacingTop, mViewSpacingRight, mViewSpacingBottom);
                else
                    alertcontroller.setView(mView);
        }

        public ListAdapter mAdapter;
        public boolean mCancelable;
        public int mCheckedItem;
        public boolean mCheckedItems[];
        public final Context mContext;
        public Cursor mCursor;
        public View mCustomTitleView;
        public boolean mForceInverseBackground;
        public Drawable mIcon;
        public int mIconId;
        public final LayoutInflater mInflater;
        public String mIsCheckedColumn;
        public boolean mIsMultiChoice;
        public boolean mIsSingleChoice;
        public CharSequence mItems[];
        public String mLabelColumn;
        public CharSequence mMessage;
        public android.content.DialogInterface.OnClickListener mNegativeButtonListener;
        public CharSequence mNegativeButtonText;
        public android.content.DialogInterface.OnClickListener mNeutralButtonListener;
        public CharSequence mNeutralButtonText;
        public android.content.DialogInterface.OnCancelListener mOnCancelListener;
        public android.content.DialogInterface.OnMultiChoiceClickListener mOnCheckboxClickListener;
        public android.content.DialogInterface.OnClickListener mOnClickListener;
        public android.widget.AdapterView.OnItemSelectedListener mOnItemSelectedListener;
        public android.content.DialogInterface.OnKeyListener mOnKeyListener;
        public OnPrepareListViewListener mOnPrepareListViewListener;
        public android.content.DialogInterface.OnClickListener mPositiveButtonListener;
        public CharSequence mPositiveButtonText;
        public boolean mRecycleOnMeasure;
        public CharSequence mTitle;
        public View mView;
        public int mViewSpacingBottom;
        public int mViewSpacingLeft;
        public int mViewSpacingRight;
        public boolean mViewSpacingSpecified;
        public int mViewSpacingTop;

        public AlertParams(Context context) {
            mIconId = 0;
            mViewSpacingSpecified = false;
            mCheckedItem = -1;
            mRecycleOnMeasure = true;
            mContext = context;
            mCancelable = true;
            mInflater = (LayoutInflater)context.getSystemService("layout_inflater");
        }
    }

    public static class RecycleListView extends ListView {

        protected boolean recycleOnMeasure() {
            return mRecycleOnMeasure;
        }

        boolean mRecycleOnMeasure;

        public RecycleListView(Context context) {
            super(context);
            mRecycleOnMeasure = true;
        }

        public RecycleListView(Context context, AttributeSet attributeset) {
            super(context, attributeset);
            mRecycleOnMeasure = true;
        }

        public RecycleListView(Context context, AttributeSet attributeset, int i) {
            super(context, attributeset, i);
            mRecycleOnMeasure = true;
        }
    }

    private static final class ButtonHandler extends Handler {

        public void handleMessage(Message message) {
            message.what;
            JVM INSTR tableswitch -3 1: default 40
        //                       -3 41
        //                       -2 41
        //                       -1 41
        //                       0 40
        //                       1 70;
               goto _L1 _L2 _L2 _L2 _L1 _L3
_L1:
            return;
_L2:
            ((android.content.DialogInterface.OnClickListener)message.obj).onClick((DialogInterface)mDialog.get(), message.what);
            continue; /* Loop/switch isn't completed */
_L3:
            ((DialogInterface)message.obj).dismiss();
            if(true) goto _L1; else goto _L4
_L4:
        }

        private static final int MSG_DISMISS_DIALOG = 1;
        private WeakReference mDialog;

        public ButtonHandler(DialogInterface dialoginterface) {
            mDialog = new WeakReference(dialoginterface);
        }
    }


    public AlertController(Context context, DialogInterface dialoginterface, Window window) {
        mViewSpacingSpecified = false;
        mIconId = -1;
        mCheckedItem = -1;
        mButtonHandler = new android.view.View.OnClickListener() {

            public void onClick(View view) {
                Message message = null;
                if(view != mButtonPositive || mButtonPositiveMessage == null) goto _L2; else goto _L1
_L1:
                message = Message.obtain(mButtonPositiveMessage);
_L4:
                if(message != null)
                    message.sendToTarget();
                mHandler.obtainMessage(1, mDialogInterface).sendToTarget();
                return;
_L2:
                if(view == mButtonNegative && mButtonNegativeMessage != null)
                    message = Message.obtain(mButtonNegativeMessage);
                else
                if(view == mButtonNeutral && mButtonNeutralMessage != null)
                    message = Message.obtain(mButtonNeutralMessage);
                if(true) goto _L4; else goto _L3
_L3:
            }

            final AlertController this$0;

             {
                this$0 = AlertController.this;
                super();
            }
        };
        mContext = context;
        mDialogInterface = dialoginterface;
        mWindow = window;
        mHandler = new ButtonHandler(dialoginterface);
        TypedArray typedarray = context.obtainStyledAttributes(null, com.android.internal.R.styleable.AlertDialog, 0x101005d, 0);
        mAlertDialogLayout = typedarray.getResourceId(10, 0x1090023);
        mListLayout = typedarray.getResourceId(11, 0x10900a4);
        mMultiChoiceItemLayout = typedarray.getResourceId(12, 0x1090013);
        mSingleChoiceItemLayout = typedarray.getResourceId(13, 0x1090012);
        mListItemLayout = typedarray.getResourceId(14, 0x1090011);
        typedarray.recycle();
    }

    static boolean canTextInput(View view) {
        boolean flag = true;
        if(!view.onCheckIsTextEditor()) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(!(view instanceof ViewGroup)) {
            flag = false;
            continue; /* Loop/switch isn't completed */
        }
        ViewGroup viewgroup = (ViewGroup)view;
        for(int i = viewgroup.getChildCount(); i > 0;) {
            i--;
            if(canTextInput(viewgroup.getChildAt(i)))
                continue; /* Loop/switch isn't completed */
        }

        flag = false;
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void centerButton(Button button) {
        android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)button.getLayoutParams();
        layoutparams.gravity = 1;
        layoutparams.weight = 0.5F;
        button.setLayoutParams(layoutparams);
        View view = mWindow.findViewById(0x1020250);
        if(view != null)
            view.setVisibility(0);
        View view1 = mWindow.findViewById(0x1020251);
        if(view1 != null)
            view1.setVisibility(0);
    }

    private void setBackground(LinearLayout linearlayout, LinearLayout linearlayout1, View view, boolean flag, TypedArray typedarray, boolean flag1, View view1) {
        int i = typedarray.getResourceId(0, 0x1080463);
        int j = typedarray.getResourceId(1, 0x108046b);
        int k = typedarray.getResourceId(2, 0x1080460);
        int l = typedarray.getResourceId(3, 0x108045d);
        int i1 = typedarray.getResourceId(4, 0x1080462);
        int j1 = typedarray.getResourceId(5, 0x108046a);
        int k1 = typedarray.getResourceId(6, 0x108045f);
        int l1 = typedarray.getResourceId(7, 0x108045c);
        int i2 = typedarray.getResourceId(8, 0x108045e);
        View aview[] = new View[4];
        boolean aflag[] = new boolean[4];
        View view2 = null;
        boolean flag2 = false;
        int j2 = 0;
        if(flag1) {
            aview[j2] = linearlayout;
            aflag[j2] = false;
            j2 = 0 + 1;
        }
        if(linearlayout1.getVisibility() == 8)
            linearlayout1 = null;
        aview[j2] = linearlayout1;
        boolean flag3;
        int k2;
        boolean flag4;
        int l2;
        if(mListView != null)
            flag3 = true;
        else
            flag3 = false;
        aflag[j2] = flag3;
        k2 = j2 + 1;
        if(view != null) {
            aview[k2] = view;
            aflag[k2] = mForceInverseBackground;
            k2++;
        }
        if(flag) {
            aview[k2] = view1;
            aflag[k2] = true;
        }
        flag4 = false;
        l2 = 0;
        while(l2 < aview.length)  {
            View view3 = aview[l2];
            if(view3 != null) {
                if(view2 != null) {
                    if(!flag4) {
                        int j3;
                        if(flag2)
                            j3 = j1;
                        else
                            j3 = j;
                        view2.setBackgroundResource(j3);
                    } else {
                        int i3;
                        if(flag2)
                            i3 = k1;
                        else
                            i3 = k;
                        view2.setBackgroundResource(i3);
                    }
                    flag4 = true;
                }
                view2 = view3;
                flag2 = aflag[l2];
            }
            l2++;
        }
        if(view2 != null)
            if(flag4) {
                if(flag2) {
                    if(!flag)
                        i2 = l1;
                } else {
                    i2 = l;
                }
                view2.setBackgroundResource(i2);
            } else {
                if(!flag2)
                    i1 = i;
                view2.setBackgroundResource(i1);
            }
        if(mListView != null && mAdapter != null) {
            mListView.setAdapter(mAdapter);
            if(mCheckedItem > -1) {
                mListView.setItemChecked(mCheckedItem, true);
                mListView.setSelection(mCheckedItem);
            }
        }
    }

    private boolean setupButtons() {
        int i = 0;
        mButtonPositive = (Button)mWindow.findViewById(0x1020019);
        mButtonPositive.setOnClickListener(mButtonHandler);
        boolean flag;
        if(TextUtils.isEmpty(mButtonPositiveText)) {
            mButtonPositive.setVisibility(8);
        } else {
            mButtonPositive.setText(mButtonPositiveText);
            mButtonPositive.setVisibility(0);
            i = false | true;
        }
        mButtonNegative = (Button)mWindow.findViewById(0x102001a);
        mButtonNegative.setOnClickListener(mButtonHandler);
        if(TextUtils.isEmpty(mButtonNegativeText)) {
            mButtonNegative.setVisibility(8);
        } else {
            mButtonNegative.setText(mButtonNegativeText);
            mButtonNegative.setVisibility(0);
            i |= 2;
        }
        mButtonNeutral = (Button)mWindow.findViewById(0x102001b);
        mButtonNeutral.setOnClickListener(mButtonHandler);
        if(TextUtils.isEmpty(mButtonNeutralText)) {
            mButtonNeutral.setVisibility(8);
        } else {
            mButtonNeutral.setText(mButtonNeutralText);
            mButtonNeutral.setVisibility(0);
            i |= 4;
        }
        if(shouldCenterSingleButton(mContext))
            if(i == 1)
                centerButton(mButtonPositive);
            else
            if(i == 2)
                centerButton(mButtonNeutral);
            else
            if(i == 4)
                centerButton(mButtonNeutral);
        if(i != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private void setupContent(LinearLayout linearlayout) {
        mScrollView = (ScrollView)mWindow.findViewById(0x1020253);
        mScrollView.setFocusable(false);
        mMessageView = (TextView)mWindow.findViewById(0x102000b);
        if(mMessageView != null)
            if(mMessage != null) {
                mMessageView.setText(mMessage);
            } else {
                mMessageView.setVisibility(8);
                mScrollView.removeView(mMessageView);
                if(mListView != null) {
                    linearlayout.removeView(mWindow.findViewById(0x1020253));
                    linearlayout.addView(mListView, new android.widget.LinearLayout.LayoutParams(-1, -1));
                    linearlayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, 0, 1.0F));
                } else {
                    linearlayout.setVisibility(8);
                }
            }
    }

    private boolean setupTitle(LinearLayout linearlayout) {
        boolean flag;
        boolean flag1;
        flag = false;
        flag1 = true;
        if(mCustomTitleView == null) goto _L2; else goto _L1
_L1:
        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-1, -2);
        linearlayout.addView(mCustomTitleView, 0, layoutparams);
        mWindow.findViewById(0x102024c).setVisibility(8);
_L4:
        return flag1;
_L2:
        if(!TextUtils.isEmpty(mTitle))
            flag = true;
        mIconView = (ImageView)mWindow.findViewById(0x1020006);
        if(flag) {
            mTitleView = (TextView)mWindow.findViewById(0x102024d);
            mTitleView.setText(mTitle);
            if(mIconId > 0)
                mIconView.setImageResource(mIconId);
            else
            if(mIcon != null)
                mIconView.setImageDrawable(mIcon);
            else
            if(mIconId == 0) {
                mTitleView.setPadding(mIconView.getPaddingLeft(), mIconView.getPaddingTop(), mIconView.getPaddingRight(), mIconView.getPaddingBottom());
                mIconView.setVisibility(8);
            }
        } else {
            mWindow.findViewById(0x102024c).setVisibility(8);
            mIconView.setVisibility(8);
            linearlayout.setVisibility(8);
            flag1 = false;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void setupView() {
        LinearLayout linearlayout = (LinearLayout)mWindow.findViewById(0x1020252);
        setupContent(linearlayout);
        boolean flag = setupButtons();
        LinearLayout linearlayout1 = (LinearLayout)mWindow.findViewById(0x102024b);
        TypedArray typedarray = mContext.obtainStyledAttributes(null, com.android.internal.R.styleable.AlertDialog, 0x101005d, 0);
        boolean flag1 = setupTitle(linearlayout1);
        View view = mWindow.findViewById(0x102024f);
        if(!flag) {
            view.setVisibility(8);
            mWindow.setCloseOnTouchOutsideIfNotSet(true);
        }
        FrameLayout framelayout = null;
        if(mView != null) {
            framelayout = (FrameLayout)mWindow.findViewById(0x1020254);
            FrameLayout framelayout1 = (FrameLayout)mWindow.findViewById(0x102002b);
            framelayout1.addView(mView, new android.view.ViewGroup.LayoutParams(-1, -1));
            if(mViewSpacingSpecified)
                framelayout1.setPadding(mViewSpacingLeft, mViewSpacingTop, mViewSpacingRight, mViewSpacingBottom);
            if(mListView != null)
                ((android.widget.LinearLayout.LayoutParams)framelayout.getLayoutParams()).weight = 0.0F;
        } else {
            mWindow.findViewById(0x1020254).setVisibility(8);
        }
        if(flag1) {
            View view1;
            if(mMessage != null || mView != null || mListView != null)
                view1 = mWindow.findViewById(0x102024e);
            else
                view1 = mWindow.findViewById(0x1020255);
            if(view1 != null)
                view1.setVisibility(0);
        }
        setBackground(linearlayout1, linearlayout, framelayout, flag, typedarray, flag1, view);
        typedarray.recycle();
    }

    private static boolean shouldCenterSingleButton(Context context) {
        boolean flag = true;
        TypedValue typedvalue = new TypedValue();
        context.getTheme().resolveAttribute(0x10103bb, typedvalue, flag);
        if(typedvalue.data == 0)
            flag = false;
        return flag;
    }

    public Button getButton(int i) {
        i;
        JVM INSTR tableswitch -3 -1: default 28
    //                   -3 48
    //                   -2 40
    //                   -1 32;
           goto _L1 _L2 _L3 _L4
_L1:
        Button button = null;
_L6:
        return button;
_L4:
        button = mButtonPositive;
        continue; /* Loop/switch isn't completed */
_L3:
        button = mButtonNegative;
        continue; /* Loop/switch isn't completed */
_L2:
        button = mButtonNeutral;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public ListView getListView() {
        return mListView;
    }

    public void installContent() {
        mWindow.requestFeature(1);
        if(mView == null || !canTextInput(mView))
            mWindow.setFlags(0x20000, 0x20000);
        mWindow.setContentView(mAlertDialogLayout);
        setupView();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent) {
        boolean flag;
        if(mScrollView != null && mScrollView.executeKeyEvent(keyevent))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean onKeyUp(int i, KeyEvent keyevent) {
        boolean flag;
        if(mScrollView != null && mScrollView.executeKeyEvent(keyevent))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void setButton(int i, CharSequence charsequence, android.content.DialogInterface.OnClickListener onclicklistener, Message message) {
        if(message == null && onclicklistener != null)
            message = mHandler.obtainMessage(i, onclicklistener);
        i;
        JVM INSTR tableswitch -3 -1: default 48
    //                   -3 85
    //                   -2 71
    //                   -1 59;
           goto _L1 _L2 _L3 _L4
_L1:
        throw new IllegalArgumentException("Button does not exist");
_L4:
        mButtonPositiveText = charsequence;
        mButtonPositiveMessage = message;
_L6:
        return;
_L3:
        mButtonNegativeText = charsequence;
        mButtonNegativeMessage = message;
        continue; /* Loop/switch isn't completed */
_L2:
        mButtonNeutralText = charsequence;
        mButtonNeutralMessage = message;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public void setCustomTitle(View view) {
        mCustomTitleView = view;
    }

    public void setIcon(int i) {
        mIconId = i;
        if(mIconView == null) goto _L2; else goto _L1
_L1:
        if(i <= 0) goto _L4; else goto _L3
_L3:
        mIconView.setImageResource(mIconId);
_L2:
        return;
_L4:
        if(i == 0)
            mIconView.setVisibility(8);
        if(true) goto _L2; else goto _L5
_L5:
    }

    public void setIcon(Drawable drawable) {
        mIcon = drawable;
        if(mIconView != null && mIcon != null)
            mIconView.setImageDrawable(drawable);
    }

    public void setInverseBackgroundForced(boolean flag) {
        mForceInverseBackground = flag;
    }

    public void setMessage(CharSequence charsequence) {
        mMessage = charsequence;
        if(mMessageView != null)
            mMessageView.setText(charsequence);
    }

    public void setTitle(CharSequence charsequence) {
        mTitle = charsequence;
        if(mTitleView != null)
            mTitleView.setText(charsequence);
    }

    public void setView(View view) {
        mView = view;
        mViewSpacingSpecified = false;
    }

    public void setView(View view, int i, int j, int k, int l) {
        mView = view;
        mViewSpacingSpecified = true;
        mViewSpacingLeft = i;
        mViewSpacingTop = j;
        mViewSpacingRight = k;
        mViewSpacingBottom = l;
    }

    private ListAdapter mAdapter;
    private int mAlertDialogLayout;
    android.view.View.OnClickListener mButtonHandler;
    private Button mButtonNegative;
    private Message mButtonNegativeMessage;
    private CharSequence mButtonNegativeText;
    private Button mButtonNeutral;
    private Message mButtonNeutralMessage;
    private CharSequence mButtonNeutralText;
    private Button mButtonPositive;
    private Message mButtonPositiveMessage;
    private CharSequence mButtonPositiveText;
    private int mCheckedItem;
    private final Context mContext;
    private View mCustomTitleView;
    private final DialogInterface mDialogInterface;
    private boolean mForceInverseBackground;
    private Handler mHandler;
    private Drawable mIcon;
    private int mIconId;
    private ImageView mIconView;
    private int mListItemLayout;
    private int mListLayout;
    private ListView mListView;
    private CharSequence mMessage;
    private TextView mMessageView;
    private int mMultiChoiceItemLayout;
    private ScrollView mScrollView;
    private int mSingleChoiceItemLayout;
    private CharSequence mTitle;
    private TextView mTitleView;
    private View mView;
    private int mViewSpacingBottom;
    private int mViewSpacingLeft;
    private int mViewSpacingRight;
    private boolean mViewSpacingSpecified;
    private int mViewSpacingTop;
    private final Window mWindow;






/*
    static ListAdapter access$1202(AlertController alertcontroller, ListAdapter listadapter) {
        alertcontroller.mAdapter = listadapter;
        return listadapter;
    }

*/


/*
    static int access$1302(AlertController alertcontroller, int i) {
        alertcontroller.mCheckedItem = i;
        return i;
    }

*/


/*
    static ListView access$1402(AlertController alertcontroller, ListView listview) {
        alertcontroller.mListView = listview;
        return listview;
    }

*/








}

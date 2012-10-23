// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.preference;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.*;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.*;
import android.widget.TextView;

// Referenced classes of package android.preference:
//            Preference, PreferenceManager

public abstract class DialogPreference extends Preference
    implements android.content.DialogInterface.OnClickListener, android.content.DialogInterface.OnDismissListener, PreferenceManager.OnActivityDestroyListener {
    private static class SavedState extends Preference.BaseSavedState {

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            int j;
            if(isDialogShowing)
                j = 1;
            else
                j = 0;
            parcel.writeInt(j);
            parcel.writeBundle(dialogBundle);
        }

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            public volatile Object[] newArray(int i) {
                return newArray(i);
            }

        };
        Bundle dialogBundle;
        boolean isDialogShowing;


        public SavedState(Parcel parcel) {
            boolean flag = true;
            super(parcel);
            if(parcel.readInt() != flag)
                flag = false;
            isDialogShowing = flag;
            dialogBundle = parcel.readBundle();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }


    public DialogPreference(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0x1010091);
    }

    public DialogPreference(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.DialogPreference, i, 0);
        mDialogTitle = typedarray.getString(0);
        if(mDialogTitle == null)
            mDialogTitle = getTitle();
        mDialogMessage = typedarray.getString(1);
        mDialogIcon = typedarray.getDrawable(2);
        mPositiveButtonText = typedarray.getString(3);
        mNegativeButtonText = typedarray.getString(4);
        mDialogLayoutResId = typedarray.getResourceId(5, mDialogLayoutResId);
        typedarray.recycle();
    }

    private void requestInputMethod(Dialog dialog) {
        dialog.getWindow().setSoftInputMode(5);
    }

    public Dialog getDialog() {
        return mDialog;
    }

    public Drawable getDialogIcon() {
        return mDialogIcon;
    }

    public int getDialogLayoutResource() {
        return mDialogLayoutResId;
    }

    public CharSequence getDialogMessage() {
        return mDialogMessage;
    }

    public CharSequence getDialogTitle() {
        return mDialogTitle;
    }

    public CharSequence getNegativeButtonText() {
        return mNegativeButtonText;
    }

    public CharSequence getPositiveButtonText() {
        return mPositiveButtonText;
    }

    protected boolean needInputMethod() {
        return false;
    }

    public void onActivityDestroy() {
        if(mDialog != null && mDialog.isShowing())
            mDialog.dismiss();
    }

    protected void onBindDialogView(View view) {
        View view1 = view.findViewById(0x102000b);
        if(view1 != null) {
            CharSequence charsequence = getDialogMessage();
            byte byte0 = 8;
            if(!TextUtils.isEmpty(charsequence)) {
                if(view1 instanceof TextView)
                    ((TextView)view1).setText(charsequence);
                byte0 = 0;
            }
            if(view1.getVisibility() != byte0)
                view1.setVisibility(byte0);
        }
    }

    protected void onClick() {
        if(mDialog == null || !mDialog.isShowing())
            showDialog(null);
    }

    public void onClick(DialogInterface dialoginterface, int i) {
        mWhichButtonClicked = i;
    }

    protected View onCreateDialogView() {
        View view = null;
        if(mDialogLayoutResId != 0)
            view = LayoutInflater.from(mBuilder.getContext()).inflate(mDialogLayoutResId, null);
        return view;
    }

    protected void onDialogClosed(boolean flag) {
    }

    public void onDismiss(DialogInterface dialoginterface) {
        getPreferenceManager().unregisterOnActivityDestroyListener(this);
        mDialog = null;
        boolean flag;
        if(mWhichButtonClicked == -1)
            flag = true;
        else
            flag = false;
        onDialogClosed(flag);
    }

    protected void onPrepareDialogBuilder(android.app.AlertDialog.Builder builder) {
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if(parcelable != null && parcelable.getClass().equals(android/preference/DialogPreference$SavedState)) goto _L2; else goto _L1
_L1:
        super.onRestoreInstanceState(parcelable);
_L4:
        return;
_L2:
        SavedState savedstate = (SavedState)parcelable;
        super.onRestoreInstanceState(savedstate.getSuperState());
        if(savedstate.isDialogShowing)
            showDialog(savedstate.dialogBundle);
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable parcelable = super.onSaveInstanceState();
        Object obj;
        if(mDialog == null || !mDialog.isShowing()) {
            obj = parcelable;
        } else {
            obj = new SavedState(parcelable);
            obj.isDialogShowing = true;
            obj.dialogBundle = mDialog.onSaveInstanceState();
        }
        return ((Parcelable) (obj));
    }

    public void setDialogIcon(int i) {
        mDialogIcon = getContext().getResources().getDrawable(i);
    }

    public void setDialogIcon(Drawable drawable) {
        mDialogIcon = drawable;
    }

    public void setDialogLayoutResource(int i) {
        mDialogLayoutResId = i;
    }

    public void setDialogMessage(int i) {
        setDialogMessage(((CharSequence) (getContext().getString(i))));
    }

    public void setDialogMessage(CharSequence charsequence) {
        mDialogMessage = charsequence;
    }

    public void setDialogTitle(int i) {
        setDialogTitle(((CharSequence) (getContext().getString(i))));
    }

    public void setDialogTitle(CharSequence charsequence) {
        mDialogTitle = charsequence;
    }

    public void setNegativeButtonText(int i) {
        setNegativeButtonText(((CharSequence) (getContext().getString(i))));
    }

    public void setNegativeButtonText(CharSequence charsequence) {
        mNegativeButtonText = charsequence;
    }

    public void setPositiveButtonText(int i) {
        setPositiveButtonText(((CharSequence) (getContext().getString(i))));
    }

    public void setPositiveButtonText(CharSequence charsequence) {
        mPositiveButtonText = charsequence;
    }

    protected void showDialog(Bundle bundle) {
        Context context = getContext();
        mWhichButtonClicked = -2;
        mBuilder = (new android.app.AlertDialog.Builder(context)).setTitle(mDialogTitle).setIcon(mDialogIcon).setPositiveButton(mPositiveButtonText, this).setNegativeButton(mNegativeButtonText, this);
        View view = onCreateDialogView();
        AlertDialog alertdialog;
        if(view != null) {
            onBindDialogView(view);
            mBuilder.setView(view);
        } else {
            mBuilder.setMessage(mDialogMessage);
        }
        onPrepareDialogBuilder(mBuilder);
        getPreferenceManager().registerOnActivityDestroyListener(this);
        alertdialog = mBuilder.create();
        mDialog = alertdialog;
        if(bundle != null)
            alertdialog.onRestoreInstanceState(bundle);
        if(needInputMethod())
            requestInputMethod(alertdialog);
        alertdialog.setOnDismissListener(this);
        alertdialog.show();
    }

    private android.app.AlertDialog.Builder mBuilder;
    private Dialog mDialog;
    private Drawable mDialogIcon;
    private int mDialogLayoutResId;
    private CharSequence mDialogMessage;
    private CharSequence mDialogTitle;
    private CharSequence mNegativeButtonText;
    private CharSequence mPositiveButtonText;
    private int mWhichButtonClicked;
}

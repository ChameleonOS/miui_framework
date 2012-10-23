// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.preference;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.*;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.*;
import android.widget.*;

// Referenced classes of package android.preference:
//            PreferenceGroup, PreferenceManager, PreferenceGroupAdapter, Preference

public final class PreferenceScreen extends PreferenceGroup
    implements android.widget.AdapterView.OnItemClickListener, android.content.DialogInterface.OnDismissListener {
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


    public PreferenceScreen(Context context, AttributeSet attributeset) {
        super(context, attributeset, 0x101008b);
    }

    private void showDialog(Bundle bundle) {
        Context context = getContext();
        if(mListView != null)
            mListView.setAdapter(null);
        View view = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x1090089, null);
        mListView = (ListView)view.findViewById(0x102000a);
        bind(mListView);
        CharSequence charsequence = getTitle();
        Dialog dialog = new Dialog(context, context.getThemeResId());
        mDialog = dialog;
        if(TextUtils.isEmpty(charsequence))
            dialog.getWindow().requestFeature(1);
        else
            dialog.setTitle(charsequence);
        dialog.setContentView(view);
        dialog.setOnDismissListener(this);
        if(bundle != null)
            dialog.onRestoreInstanceState(bundle);
        getPreferenceManager().addPreferencesScreen(dialog);
        dialog.show();
    }

    public void bind(ListView listview) {
        listview.setOnItemClickListener(this);
        listview.setAdapter(getRootAdapter());
        onAttachedToActivity();
    }

    public Dialog getDialog() {
        return mDialog;
    }

    public ListAdapter getRootAdapter() {
        if(mRootAdapter == null)
            mRootAdapter = onCreateRootAdapter();
        return mRootAdapter;
    }

    protected boolean isOnSameScreenAsChildren() {
        return false;
    }

    protected void onClick() {
        if(getIntent() == null && getFragment() == null && getPreferenceCount() != 0)
            showDialog(null);
    }

    protected ListAdapter onCreateRootAdapter() {
        return new PreferenceGroupAdapter(this);
    }

    public void onDismiss(DialogInterface dialoginterface) {
        mDialog = null;
        getPreferenceManager().removePreferencesScreen(dialoginterface);
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l) {
        if(adapterview instanceof ListView)
            i -= ((ListView)adapterview).getHeaderViewsCount();
        Object obj = getRootAdapter().getItem(i);
        if(obj instanceof Preference)
            ((Preference)obj).performClick(this);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if(parcelable != null && parcelable.getClass().equals(android/preference/PreferenceScreen$SavedState)) goto _L2; else goto _L1
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
        Dialog dialog = mDialog;
        Object obj;
        if(dialog == null || !dialog.isShowing()) {
            obj = parcelable;
        } else {
            obj = new SavedState(parcelable);
            obj.isDialogShowing = true;
            obj.dialogBundle = dialog.onSaveInstanceState();
        }
        return ((Parcelable) (obj));
    }

    private Dialog mDialog;
    private ListView mListView;
    private ListAdapter mRootAdapter;
}

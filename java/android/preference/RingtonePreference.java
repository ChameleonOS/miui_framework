// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.preference;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.media.RingtoneManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;

// Referenced classes of package android.preference:
//            Preference, PreferenceManager, PreferenceFragment

public class RingtonePreference extends Preference
    implements PreferenceManager.OnActivityResultListener {

    public RingtonePreference(Context context) {
        this(context, null);
    }

    public RingtonePreference(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0x1010093);
    }

    public RingtonePreference(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.RingtonePreference, i, 0);
        mRingtoneType = typedarray.getInt(0, 1);
        mShowDefault = typedarray.getBoolean(1, true);
        mShowSilent = typedarray.getBoolean(2, true);
        typedarray.recycle();
    }

    public int getRingtoneType() {
        return mRingtoneType;
    }

    public boolean getShowDefault() {
        return mShowDefault;
    }

    public boolean getShowSilent() {
        return mShowSilent;
    }

    public boolean onActivityResult(int i, int j, Intent intent) {
        boolean flag;
        if(i == mRequestCode) {
            if(intent != null) {
                Uri uri = (Uri)intent.getParcelableExtra("android.intent.extra.ringtone.PICKED_URI");
                String s;
                if(uri != null)
                    s = uri.toString();
                else
                    s = "";
                if(callChangeListener(s))
                    onSaveRingtone(uri);
            }
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    protected void onAttachedToHierarchy(PreferenceManager preferencemanager) {
        super.onAttachedToHierarchy(preferencemanager);
        preferencemanager.registerOnActivityResultListener(this);
        mRequestCode = preferencemanager.getNextRequestCode();
    }

    protected void onClick() {
        Intent intent = new Intent("android.intent.action.RINGTONE_PICKER");
        onPrepareRingtonePickerIntent(intent);
        PreferenceFragment preferencefragment = getPreferenceManager().getFragment();
        if(preferencefragment != null)
            preferencefragment.startActivityForResult(intent, mRequestCode);
        else
            getPreferenceManager().getActivity().startActivityForResult(intent, mRequestCode);
    }

    protected Object onGetDefaultValue(TypedArray typedarray, int i) {
        return typedarray.getString(i);
    }

    protected void onPrepareRingtonePickerIntent(Intent intent) {
        intent.putExtra("android.intent.extra.ringtone.EXISTING_URI", onRestoreRingtone());
        intent.putExtra("android.intent.extra.ringtone.SHOW_DEFAULT", mShowDefault);
        if(mShowDefault)
            intent.putExtra("android.intent.extra.ringtone.DEFAULT_URI", RingtoneManager.getDefaultUri(getRingtoneType()));
        intent.putExtra("android.intent.extra.ringtone.SHOW_SILENT", mShowSilent);
        intent.putExtra("android.intent.extra.ringtone.TYPE", mRingtoneType);
        intent.putExtra("android.intent.extra.ringtone.TITLE", getTitle());
        intent.setClassName("com.android.thememanager", "com.android.thememanager.activity.ThemeTabActivity");
    }

    protected Uri onRestoreRingtone() {
        Uri uri = null;
        String s = getPersistedString(null);
        if(!TextUtils.isEmpty(s))
            uri = Uri.parse(s);
        return uri;
    }

    protected void onSaveRingtone(Uri uri) {
        String s;
        if(uri != null)
            s = uri.toString();
        else
            s = "";
        persistString(s);
    }

    protected void onSetInitialValue(boolean flag, Object obj) {
        String s;
        s = (String)obj;
        break MISSING_BLOCK_LABEL_5;
        if(!flag && !TextUtils.isEmpty(s))
            onSaveRingtone(Uri.parse(s));
        return;
    }

    public void setRingtoneType(int i) {
        mRingtoneType = i;
    }

    public void setShowDefault(boolean flag) {
        mShowDefault = flag;
    }

    public void setShowSilent(boolean flag) {
        mShowSilent = flag;
    }

    private static final String TAG = "RingtonePreference";
    private int mRequestCode;
    private int mRingtoneType;
    private boolean mShowDefault;
    private boolean mShowSilent;
}

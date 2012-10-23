// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.preference;

import android.content.*;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.*;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.*;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.internal.util.CharSequences;
import java.util.*;

// Referenced classes of package android.preference:
//            OnDependencyChangeListener, PreferenceManager, PreferenceScreen

public class Preference
    implements Comparable, OnDependencyChangeListener {
    public static class BaseSavedState extends AbsSavedState {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public BaseSavedState createFromParcel(Parcel parcel) {
                return new BaseSavedState(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            public BaseSavedState[] newArray(int i) {
                return new BaseSavedState[i];
            }

            public volatile Object[] newArray(int i) {
                return newArray(i);
            }

        };


        public BaseSavedState(Parcel parcel) {
            super(parcel);
        }

        public BaseSavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    static interface OnPreferenceChangeInternalListener {

        public abstract void onPreferenceChange(Preference preference);

        public abstract void onPreferenceHierarchyChange(Preference preference);
    }

    public static interface OnPreferenceClickListener {

        public abstract boolean onPreferenceClick(Preference preference);
    }

    public static interface OnPreferenceChangeListener {

        public abstract boolean onPreferenceChange(Preference preference, Object obj);
    }


    public Preference(Context context) {
        this(context, null);
    }

    public Preference(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0x101008e);
    }

    public Preference(Context context, AttributeSet attributeset, int i) {
        TypedArray typedarray;
        int j;
        mOrder = 0x7fffffff;
        mEnabled = true;
        mSelectable = true;
        mPersistent = true;
        mDependencyMet = true;
        mShouldDisableView = true;
        mLayoutResId = 0x109007e;
        mHasSpecifiedLayout = false;
        mContext = context;
        typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.Preference, i, 0);
        j = typedarray.getIndexCount();
_L17:
        int k;
        if(j < 0)
            break MISSING_BLOCK_LABEL_394;
        k = typedarray.getIndex(j);
        k;
        JVM INSTR tableswitch 0 13: default 156
    //                   0 162
    //                   1 329
    //                   2 299
    //                   3 263
    //                   4 191
    //                   5 314
    //                   6 177
    //                   7 217
    //                   8 231
    //                   9 281
    //                   10 347
    //                   11 361
    //                   12 376
    //                   13 249;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L14:
        break MISSING_BLOCK_LABEL_376;
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break; /* Loop/switch isn't completed */
_L18:
        j--;
        if(true) goto _L17; else goto _L16
_L16:
        mIconResId = typedarray.getResourceId(k, 0);
          goto _L18
_L8:
        mKey = typedarray.getString(k);
          goto _L18
_L6:
        mTitleRes = typedarray.getResourceId(k, 0);
        mTitle = typedarray.getString(k);
          goto _L18
_L9:
        mSummary = typedarray.getString(k);
          goto _L18
_L10:
        mOrder = typedarray.getInt(k, mOrder);
          goto _L18
_L15:
        mFragment = typedarray.getString(k);
          goto _L18
_L5:
        mLayoutResId = typedarray.getResourceId(k, mLayoutResId);
          goto _L18
_L11:
        mWidgetLayoutResId = typedarray.getResourceId(k, mWidgetLayoutResId);
          goto _L18
_L4:
        mEnabled = typedarray.getBoolean(k, true);
          goto _L18
_L7:
        mSelectable = typedarray.getBoolean(k, true);
          goto _L18
_L3:
        mPersistent = typedarray.getBoolean(k, mPersistent);
          goto _L18
_L12:
        mDependencyKey = typedarray.getString(k);
          goto _L18
_L13:
        mDefaultValue = onGetDefaultValue(typedarray, k);
          goto _L18
        mShouldDisableView = typedarray.getBoolean(k, mShouldDisableView);
          goto _L18
        typedarray.recycle();
        if(!getClass().getName().startsWith("android.preference"))
            mHasSpecifiedLayout = true;
        return;
    }

    private void dispatchSetInitialValue() {
        if(!shouldPersist() || !getSharedPreferences().contains(mKey)) {
            if(mDefaultValue != null)
                onSetInitialValue(false, mDefaultValue);
        } else {
            onSetInitialValue(true, null);
        }
    }

    private void registerDependency() {
        if(!TextUtils.isEmpty(mDependencyKey)) {
            Preference preference = findPreferenceInHierarchy(mDependencyKey);
            if(preference != null)
                preference.registerDependent(this);
            else
                throw new IllegalStateException((new StringBuilder()).append("Dependency \"").append(mDependencyKey).append("\" not found for preference \"").append(mKey).append("\" (title: \"").append(mTitle).append("\"").toString());
        }
    }

    private void registerDependent(Preference preference) {
        if(mDependents == null)
            mDependents = new ArrayList();
        mDependents.add(preference);
        preference.onDependencyChanged(this, shouldDisableDependents());
    }

    private void setEnabledStateOnViews(View view, boolean flag) {
        view.setEnabled(flag);
        if(view instanceof ViewGroup) {
            ViewGroup viewgroup = (ViewGroup)view;
            for(int i = -1 + viewgroup.getChildCount(); i >= 0; i--)
                setEnabledStateOnViews(viewgroup.getChildAt(i), flag);

        }
    }

    private void tryCommit(android.content.SharedPreferences.Editor editor) {
        if(!mPreferenceManager.shouldCommit())
            break MISSING_BLOCK_LABEL_16;
        editor.apply();
_L1:
        return;
        AbstractMethodError abstractmethoderror;
        abstractmethoderror;
        editor.commit();
          goto _L1
    }

    private void unregisterDependency() {
        if(mDependencyKey != null) {
            Preference preference = findPreferenceInHierarchy(mDependencyKey);
            if(preference != null)
                preference.unregisterDependent(this);
        }
    }

    private void unregisterDependent(Preference preference) {
        if(mDependents != null)
            mDependents.remove(preference);
    }

    protected boolean callChangeListener(Object obj) {
        boolean flag;
        if(mOnChangeListener == null)
            flag = true;
        else
            flag = mOnChangeListener.onPreferenceChange(this, obj);
        return flag;
    }

    public int compareTo(Preference preference) {
        int i;
        if(mOrder != 0x7fffffff || mOrder == 0x7fffffff && preference.mOrder != 0x7fffffff)
            i = mOrder - preference.mOrder;
        else
        if(mTitle == null)
            i = 1;
        else
        if(preference.mTitle == null)
            i = -1;
        else
            i = CharSequences.compareToIgnoreCase(mTitle, preference.mTitle);
        return i;
    }

    public volatile int compareTo(Object obj) {
        return compareTo((Preference)obj);
    }

    void dispatchRestoreInstanceState(Bundle bundle) {
        if(hasKey()) {
            Parcelable parcelable = bundle.getParcelable(mKey);
            if(parcelable != null) {
                mBaseMethodCalled = false;
                onRestoreInstanceState(parcelable);
                if(!mBaseMethodCalled)
                    throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
            }
        }
    }

    void dispatchSaveInstanceState(Bundle bundle) {
        if(hasKey()) {
            mBaseMethodCalled = false;
            Parcelable parcelable = onSaveInstanceState();
            if(!mBaseMethodCalled)
                throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
            if(parcelable != null)
                bundle.putParcelable(mKey, parcelable);
        }
    }

    protected Preference findPreferenceInHierarchy(String s) {
        Preference preference;
        if(TextUtils.isEmpty(s) || mPreferenceManager == null)
            preference = null;
        else
            preference = mPreferenceManager.findPreference(s);
        return preference;
    }

    public Context getContext() {
        return mContext;
    }

    public String getDependency() {
        return mDependencyKey;
    }

    public android.content.SharedPreferences.Editor getEditor() {
        android.content.SharedPreferences.Editor editor;
        if(mPreferenceManager == null)
            editor = null;
        else
            editor = mPreferenceManager.getEditor();
        return editor;
    }

    public Bundle getExtras() {
        if(mExtras == null)
            mExtras = new Bundle();
        return mExtras;
    }

    StringBuilder getFilterableStringBuilder() {
        StringBuilder stringbuilder = new StringBuilder();
        CharSequence charsequence = getTitle();
        if(!TextUtils.isEmpty(charsequence))
            stringbuilder.append(charsequence).append(' ');
        CharSequence charsequence1 = getSummary();
        if(!TextUtils.isEmpty(charsequence1))
            stringbuilder.append(charsequence1).append(' ');
        if(stringbuilder.length() > 0)
            stringbuilder.setLength(-1 + stringbuilder.length());
        return stringbuilder;
    }

    public String getFragment() {
        return mFragment;
    }

    public Drawable getIcon() {
        return mIcon;
    }

    long getId() {
        return mId;
    }

    public Intent getIntent() {
        return mIntent;
    }

    public String getKey() {
        return mKey;
    }

    public int getLayoutResource() {
        return mLayoutResId;
    }

    public OnPreferenceChangeListener getOnPreferenceChangeListener() {
        return mOnChangeListener;
    }

    public OnPreferenceClickListener getOnPreferenceClickListener() {
        return mOnClickListener;
    }

    public int getOrder() {
        return mOrder;
    }

    protected boolean getPersistedBoolean(boolean flag) {
        if(shouldPersist())
            flag = mPreferenceManager.getSharedPreferences().getBoolean(mKey, flag);
        return flag;
    }

    protected float getPersistedFloat(float f) {
        if(shouldPersist())
            f = mPreferenceManager.getSharedPreferences().getFloat(mKey, f);
        return f;
    }

    protected int getPersistedInt(int i) {
        if(shouldPersist())
            i = mPreferenceManager.getSharedPreferences().getInt(mKey, i);
        return i;
    }

    protected long getPersistedLong(long l) {
        if(shouldPersist())
            l = mPreferenceManager.getSharedPreferences().getLong(mKey, l);
        return l;
    }

    protected String getPersistedString(String s) {
        if(shouldPersist())
            s = mPreferenceManager.getSharedPreferences().getString(mKey, s);
        return s;
    }

    protected Set getPersistedStringSet(Set set) {
        if(shouldPersist())
            set = mPreferenceManager.getSharedPreferences().getStringSet(mKey, set);
        return set;
    }

    public PreferenceManager getPreferenceManager() {
        return mPreferenceManager;
    }

    public SharedPreferences getSharedPreferences() {
        SharedPreferences sharedpreferences;
        if(mPreferenceManager == null)
            sharedpreferences = null;
        else
            sharedpreferences = mPreferenceManager.getSharedPreferences();
        return sharedpreferences;
    }

    public boolean getShouldDisableView() {
        return mShouldDisableView;
    }

    public CharSequence getSummary() {
        return mSummary;
    }

    public CharSequence getTitle() {
        return mTitle;
    }

    public int getTitleRes() {
        return mTitleRes;
    }

    public View getView(View view, ViewGroup viewgroup) {
        if(view == null)
            view = onCreateView(viewgroup);
        onBindView(view);
        return view;
    }

    public int getWidgetLayoutResource() {
        return mWidgetLayoutResId;
    }

    public boolean hasKey() {
        boolean flag;
        if(!TextUtils.isEmpty(mKey))
            flag = true;
        else
            flag = false;
        return flag;
    }

    boolean hasSpecifiedLayout() {
        return mHasSpecifiedLayout;
    }

    public boolean isEnabled() {
        boolean flag;
        if(mEnabled && mDependencyMet)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isPersistent() {
        return mPersistent;
    }

    public boolean isSelectable() {
        return mSelectable;
    }

    protected void notifyChanged() {
        if(mListener != null)
            mListener.onPreferenceChange(this);
    }

    public void notifyDependencyChange(boolean flag) {
        List list = mDependents;
        if(list != null) {
            int i = list.size();
            int j = 0;
            while(j < i)  {
                ((Preference)list.get(j)).onDependencyChanged(this, flag);
                j++;
            }
        }
    }

    protected void notifyHierarchyChanged() {
        if(mListener != null)
            mListener.onPreferenceHierarchyChange(this);
    }

    protected void onAttachedToActivity() {
        registerDependency();
    }

    protected void onAttachedToHierarchy(PreferenceManager preferencemanager) {
        mPreferenceManager = preferencemanager;
        mId = preferencemanager.getNextId();
        dispatchSetInitialValue();
    }

    protected void onBindView(View view) {
        int i = 0;
        TextView textview = (TextView)view.findViewById(0x1020016);
        TextView textview1;
        if(textview != null) {
            CharSequence charsequence1 = getTitle();
            ImageView imageview;
            CharSequence charsequence;
            if(!TextUtils.isEmpty(charsequence1)) {
                textview.setText(charsequence1);
                textview.setVisibility(0);
            } else {
                textview.setVisibility(8);
            }
        }
        textview1 = (TextView)view.findViewById(0x1020010);
        if(textview1 != null) {
            charsequence = getSummary();
            if(!TextUtils.isEmpty(charsequence)) {
                textview1.setText(charsequence);
                textview1.setVisibility(0);
            } else {
                textview1.setVisibility(8);
            }
        }
        imageview = (ImageView)view.findViewById(0x1020006);
        if(imageview != null) {
            if(mIconResId != 0 || mIcon != null) {
                if(mIcon == null)
                    mIcon = getContext().getResources().getDrawable(mIconResId);
                if(mIcon != null)
                    imageview.setImageDrawable(mIcon);
            }
            if(mIcon == null)
                i = 8;
            imageview.setVisibility(i);
        }
        if(mShouldDisableView)
            setEnabledStateOnViews(view, isEnabled());
    }

    protected void onClick() {
    }

    protected View onCreateView(ViewGroup viewgroup) {
        LayoutInflater layoutinflater = (LayoutInflater)mContext.getSystemService("layout_inflater");
        View view = layoutinflater.inflate(mLayoutResId, viewgroup, false);
        ViewGroup viewgroup1 = (ViewGroup)view.findViewById(0x1020018);
        if(viewgroup1 != null)
            if(mWidgetLayoutResId != 0)
                layoutinflater.inflate(mWidgetLayoutResId, viewgroup1);
            else
                viewgroup1.setVisibility(8);
        return view;
    }

    public void onDependencyChanged(Preference preference, boolean flag) {
        if(mDependencyMet == flag) {
            boolean flag1;
            if(!flag)
                flag1 = true;
            else
                flag1 = false;
            mDependencyMet = flag1;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
    }

    protected Object onGetDefaultValue(TypedArray typedarray, int i) {
        return null;
    }

    public boolean onKey(View view, int i, KeyEvent keyevent) {
        return false;
    }

    protected void onPrepareForRemoval() {
        unregisterDependency();
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        mBaseMethodCalled = true;
        if(parcelable != BaseSavedState.EMPTY_STATE && parcelable != null)
            throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        else
            return;
    }

    protected Parcelable onSaveInstanceState() {
        mBaseMethodCalled = true;
        return BaseSavedState.EMPTY_STATE;
    }

    protected void onSetInitialValue(boolean flag, Object obj) {
    }

    public Bundle peekExtras() {
        return mExtras;
    }

    void performClick(PreferenceScreen preferencescreen) {
        if(isEnabled()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        onClick();
        if(mOnClickListener != null && mOnClickListener.onPreferenceClick(this))
            continue; /* Loop/switch isn't completed */
        PreferenceManager preferencemanager = getPreferenceManager();
        if(preferencemanager != null) {
            PreferenceManager.OnPreferenceTreeClickListener onpreferencetreeclicklistener = preferencemanager.getOnPreferenceTreeClickListener();
            if(preferencescreen != null && onpreferencetreeclicklistener != null && onpreferencetreeclicklistener.onPreferenceTreeClick(preferencescreen, this))
                continue; /* Loop/switch isn't completed */
        }
        if(mIntent != null)
            getContext().startActivity(mIntent);
        if(true) goto _L1; else goto _L3
_L3:
    }

    protected boolean persistBoolean(boolean flag) {
        boolean flag1 = false;
        boolean flag2 = true;
        if(shouldPersist()) {
            if(!flag)
                flag1 = flag2;
            if(flag != getPersistedBoolean(flag1)) {
                android.content.SharedPreferences.Editor editor = mPreferenceManager.getEditor();
                editor.putBoolean(mKey, flag);
                tryCommit(editor);
            }
        } else {
            flag2 = false;
        }
        return flag2;
    }

    protected boolean persistFloat(float f) {
        boolean flag = true;
        if(shouldPersist()) {
            if(f != getPersistedFloat((0.0F / 0.0F))) {
                android.content.SharedPreferences.Editor editor = mPreferenceManager.getEditor();
                editor.putFloat(mKey, f);
                tryCommit(editor);
            }
        } else {
            flag = false;
        }
        return flag;
    }

    protected boolean persistInt(int i) {
        boolean flag = true;
        if(shouldPersist()) {
            if(i != getPersistedInt(~i)) {
                android.content.SharedPreferences.Editor editor = mPreferenceManager.getEditor();
                editor.putInt(mKey, i);
                tryCommit(editor);
            }
        } else {
            flag = false;
        }
        return flag;
    }

    protected boolean persistLong(long l) {
        boolean flag = true;
        if(shouldPersist()) {
            if(l != getPersistedLong(-1L ^ l)) {
                android.content.SharedPreferences.Editor editor = mPreferenceManager.getEditor();
                editor.putLong(mKey, l);
                tryCommit(editor);
            }
        } else {
            flag = false;
        }
        return flag;
    }

    protected boolean persistString(String s) {
        boolean flag = true;
        if(shouldPersist()) {
            if(s != getPersistedString(null)) {
                android.content.SharedPreferences.Editor editor = mPreferenceManager.getEditor();
                editor.putString(mKey, s);
                tryCommit(editor);
            }
        } else {
            flag = false;
        }
        return flag;
    }

    protected boolean persistStringSet(Set set) {
        boolean flag = true;
        if(shouldPersist()) {
            if(!set.equals(getPersistedStringSet(null))) {
                android.content.SharedPreferences.Editor editor = mPreferenceManager.getEditor();
                editor.putStringSet(mKey, set);
                tryCommit(editor);
            }
        } else {
            flag = false;
        }
        return flag;
    }

    void requireKey() {
        if(mKey == null) {
            throw new IllegalStateException("Preference does not have a key assigned.");
        } else {
            mRequiresKey = true;
            return;
        }
    }

    public void restoreHierarchyState(Bundle bundle) {
        dispatchRestoreInstanceState(bundle);
    }

    public void saveHierarchyState(Bundle bundle) {
        dispatchSaveInstanceState(bundle);
    }

    public void setDefaultValue(Object obj) {
        mDefaultValue = obj;
    }

    public void setDependency(String s) {
        unregisterDependency();
        mDependencyKey = s;
        registerDependency();
    }

    public void setEnabled(boolean flag) {
        if(mEnabled != flag) {
            mEnabled = flag;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
    }

    public void setFragment(String s) {
        mFragment = s;
    }

    public void setIcon(int i) {
        mIconResId = i;
        setIcon(mContext.getResources().getDrawable(i));
    }

    public void setIcon(Drawable drawable) {
        if(drawable == null && mIcon != null || drawable != null && mIcon != drawable) {
            mIcon = drawable;
            notifyChanged();
        }
    }

    public void setIntent(Intent intent) {
        mIntent = intent;
    }

    public void setKey(String s) {
        mKey = s;
        if(mRequiresKey && !hasKey())
            requireKey();
    }

    public void setLayoutResource(int i) {
        if(i != mLayoutResId)
            mHasSpecifiedLayout = true;
        mLayoutResId = i;
    }

    final void setOnPreferenceChangeInternalListener(OnPreferenceChangeInternalListener onpreferencechangeinternallistener) {
        mListener = onpreferencechangeinternallistener;
    }

    public void setOnPreferenceChangeListener(OnPreferenceChangeListener onpreferencechangelistener) {
        mOnChangeListener = onpreferencechangelistener;
    }

    public void setOnPreferenceClickListener(OnPreferenceClickListener onpreferenceclicklistener) {
        mOnClickListener = onpreferenceclicklistener;
    }

    public void setOrder(int i) {
        if(i != mOrder) {
            mOrder = i;
            notifyHierarchyChanged();
        }
    }

    public void setPersistent(boolean flag) {
        mPersistent = flag;
    }

    public void setSelectable(boolean flag) {
        if(mSelectable != flag) {
            mSelectable = flag;
            notifyChanged();
        }
    }

    public void setShouldDisableView(boolean flag) {
        mShouldDisableView = flag;
        notifyChanged();
    }

    public void setSummary(int i) {
        setSummary(((CharSequence) (mContext.getString(i))));
    }

    public void setSummary(CharSequence charsequence) {
        if(charsequence == null && mSummary != null || charsequence != null && !charsequence.equals(mSummary)) {
            mSummary = charsequence;
            notifyChanged();
        }
    }

    public void setTitle(int i) {
        setTitle(((CharSequence) (mContext.getString(i))));
        mTitleRes = i;
    }

    public void setTitle(CharSequence charsequence) {
        if(charsequence == null && mTitle != null || charsequence != null && !charsequence.equals(mTitle)) {
            mTitleRes = 0;
            mTitle = charsequence;
            notifyChanged();
        }
    }

    public void setWidgetLayoutResource(int i) {
        if(i != mWidgetLayoutResId)
            mHasSpecifiedLayout = true;
        mWidgetLayoutResId = i;
    }

    public boolean shouldCommit() {
        boolean flag;
        if(mPreferenceManager == null)
            flag = false;
        else
            flag = mPreferenceManager.shouldCommit();
        return flag;
    }

    public boolean shouldDisableDependents() {
        boolean flag;
        if(!isEnabled())
            flag = true;
        else
            flag = false;
        return flag;
    }

    protected boolean shouldPersist() {
        boolean flag;
        if(mPreferenceManager != null && isPersistent() && hasKey())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public String toString() {
        return getFilterableStringBuilder().toString();
    }

    public static final int DEFAULT_ORDER = 0x7fffffff;
    private boolean mBaseMethodCalled;
    private Context mContext;
    private Object mDefaultValue;
    private String mDependencyKey;
    private boolean mDependencyMet;
    private List mDependents;
    private boolean mEnabled;
    private Bundle mExtras;
    private String mFragment;
    private boolean mHasSpecifiedLayout;
    private Drawable mIcon;
    private int mIconResId;
    private long mId;
    private Intent mIntent;
    private String mKey;
    private int mLayoutResId;
    private OnPreferenceChangeInternalListener mListener;
    private OnPreferenceChangeListener mOnChangeListener;
    private OnPreferenceClickListener mOnClickListener;
    private int mOrder;
    private boolean mPersistent;
    private PreferenceManager mPreferenceManager;
    private boolean mRequiresKey;
    private boolean mSelectable;
    private boolean mShouldDisableView;
    private CharSequence mSummary;
    private CharSequence mTitle;
    private int mTitleRes;
    private int mWidgetLayoutResId;
}

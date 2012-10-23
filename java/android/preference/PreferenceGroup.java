// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import java.util.*;

// Referenced classes of package android.preference:
//            Preference

public abstract class PreferenceGroup extends Preference
    implements GenericInflater.Parent {

    public PreferenceGroup(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        mOrderingAsAdded = true;
        mCurrentPreferenceOrder = 0;
        mAttachedToActivity = false;
        mPreferenceList = new ArrayList();
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.PreferenceGroup, i, 0);
        mOrderingAsAdded = typedarray.getBoolean(0, mOrderingAsAdded);
        typedarray.recycle();
    }

    private boolean removePreferenceInt(Preference preference) {
        this;
        JVM INSTR monitorenter ;
        preference.onPrepareForRemoval();
        boolean flag = mPreferenceList.remove(preference);
        return flag;
    }

    public void addItemFromInflater(Preference preference) {
        addPreference(preference);
    }

    public volatile void addItemFromInflater(Object obj) {
        addItemFromInflater((Preference)obj);
    }

    public boolean addPreference(Preference preference) {
        if(!mPreferenceList.contains(preference)) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        int i;
        if(preference.getOrder() == 0x7fffffff) {
            if(mOrderingAsAdded) {
                int j = mCurrentPreferenceOrder;
                mCurrentPreferenceOrder = j + 1;
                preference.setOrder(j);
            }
            if(preference instanceof PreferenceGroup)
                ((PreferenceGroup)preference).setOrderingAsAdded(mOrderingAsAdded);
        }
        i = Collections.binarySearch(mPreferenceList, preference);
        if(i < 0)
            i = -1 + i * -1;
        if(!onPrepareAddPreference(preference)) {
            flag = false;
            continue; /* Loop/switch isn't completed */
        }
        this;
        JVM INSTR monitorenter ;
        mPreferenceList.add(i, preference);
        this;
        JVM INSTR monitorexit ;
        preference.onAttachedToHierarchy(getPreferenceManager());
        if(mAttachedToActivity)
            preference.onAttachedToActivity();
        notifyHierarchyChanged();
        flag = true;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void dispatchRestoreInstanceState(Bundle bundle) {
        super.dispatchRestoreInstanceState(bundle);
        int i = getPreferenceCount();
        for(int j = 0; j < i; j++)
            getPreference(j).dispatchRestoreInstanceState(bundle);

    }

    protected void dispatchSaveInstanceState(Bundle bundle) {
        super.dispatchSaveInstanceState(bundle);
        int i = getPreferenceCount();
        for(int j = 0; j < i; j++)
            getPreference(j).dispatchSaveInstanceState(bundle);

    }

    public Preference findPreference(CharSequence charsequence) {
        if(!TextUtils.equals(getKey(), charsequence)) goto _L2; else goto _L1
_L1:
        return this;
_L2:
        int i = getPreferenceCount();
        for(int j = 0; j < i; j++) {
            Preference preference = getPreference(j);
            String s = preference.getKey();
            if(s != null && s.equals(charsequence)) {
                this = preference;
            } else {
                if(!(preference instanceof PreferenceGroup))
                    continue;
                Preference preference1 = ((PreferenceGroup)preference).findPreference(charsequence);
                if(preference1 == null)
                    continue;
                this = preference1;
            }
            continue; /* Loop/switch isn't completed */
        }

        this = null;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public Preference getPreference(int i) {
        return (Preference)mPreferenceList.get(i);
    }

    public int getPreferenceCount() {
        return mPreferenceList.size();
    }

    protected boolean isOnSameScreenAsChildren() {
        return true;
    }

    public boolean isOrderingAsAdded() {
        return mOrderingAsAdded;
    }

    protected void onAttachedToActivity() {
        super.onAttachedToActivity();
        mAttachedToActivity = true;
        int i = getPreferenceCount();
        for(int j = 0; j < i; j++)
            getPreference(j).onAttachedToActivity();

    }

    protected boolean onPrepareAddPreference(Preference preference) {
        if(!super.isEnabled())
            preference.setEnabled(false);
        return true;
    }

    protected void onPrepareForRemoval() {
        super.onPrepareForRemoval();
        mAttachedToActivity = false;
    }

    public void removeAll() {
        this;
        JVM INSTR monitorenter ;
        List list = mPreferenceList;
        for(int i = -1 + list.size(); i >= 0; i--)
            removePreferenceInt((Preference)list.get(0));

        this;
        JVM INSTR monitorexit ;
        notifyHierarchyChanged();
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean removePreference(Preference preference) {
        boolean flag = removePreferenceInt(preference);
        notifyHierarchyChanged();
        return flag;
    }

    public void setEnabled(boolean flag) {
        super.setEnabled(flag);
        int i = getPreferenceCount();
        for(int j = 0; j < i; j++)
            getPreference(j).setEnabled(flag);

    }

    public void setOrderingAsAdded(boolean flag) {
        mOrderingAsAdded = flag;
    }

    void sortPreferences() {
        this;
        JVM INSTR monitorenter ;
        Collections.sort(mPreferenceList);
        return;
    }

    private boolean mAttachedToActivity;
    private int mCurrentPreferenceOrder;
    private boolean mOrderingAsAdded;
    private List mPreferenceList;
}

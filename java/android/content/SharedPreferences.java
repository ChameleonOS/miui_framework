// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import java.util.Map;
import java.util.Set;

public interface SharedPreferences {
    public static interface Editor {

        public abstract void apply();

        public abstract Editor clear();

        public abstract boolean commit();

        public abstract Editor putBoolean(String s, boolean flag);

        public abstract Editor putFloat(String s, float f);

        public abstract Editor putInt(String s, int i);

        public abstract Editor putLong(String s, long l);

        public abstract Editor putString(String s, String s1);

        public abstract Editor putStringSet(String s, Set set);

        public abstract Editor remove(String s);
    }

    public static interface OnSharedPreferenceChangeListener {

        public abstract void onSharedPreferenceChanged(SharedPreferences sharedpreferences, String s);
    }


    public abstract boolean contains(String s);

    public abstract Editor edit();

    public abstract Map getAll();

    public abstract boolean getBoolean(String s, boolean flag);

    public abstract float getFloat(String s, float f);

    public abstract int getInt(String s, int i);

    public abstract long getLong(String s, long l);

    public abstract String getString(String s, String s1);

    public abstract Set getStringSet(String s, Set set);

    public abstract void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onsharedpreferencechangelistener);

    public abstract void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onsharedpreferencechangelistener);
}

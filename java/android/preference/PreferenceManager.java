// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.preference;

import android.app.Activity;
import android.content.*;
import android.content.pm.*;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;
import java.util.*;

// Referenced classes of package android.preference:
//            PreferenceScreen, PreferenceInflater, PreferenceFragment, Preference

public class PreferenceManager {
    public static interface OnActivityDestroyListener {

        public abstract void onActivityDestroy();
    }

    public static interface OnActivityStopListener {

        public abstract void onActivityStop();
    }

    public static interface OnActivityResultListener {

        public abstract boolean onActivityResult(int i, int j, Intent intent);
    }

    static interface OnPreferenceTreeClickListener {

        public abstract boolean onPreferenceTreeClick(PreferenceScreen preferencescreen, Preference preference);
    }


    PreferenceManager(Activity activity, int i) {
        mNextId = 0L;
        mActivity = activity;
        mNextRequestCode = i;
        init(activity);
    }

    private PreferenceManager(Context context) {
        mNextId = 0L;
        init(context);
    }

    private void dismissAllScreens() {
        this;
        JVM INSTR monitorenter ;
        if(mPreferencesScreens != null)
            break MISSING_BLOCK_LABEL_14;
        this;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_73;
        ArrayList arraylist;
        arraylist = new ArrayList(mPreferencesScreens);
        mPreferencesScreens.clear();
        this;
        JVM INSTR monitorexit ;
        for(int i = -1 + arraylist.size(); i >= 0; i--)
            ((DialogInterface)arraylist.get(i)).dismiss();

        break MISSING_BLOCK_LABEL_73;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static SharedPreferences getDefaultSharedPreferences(Context context) {
        return context.getSharedPreferences(getDefaultSharedPreferencesName(context), getDefaultSharedPreferencesMode());
    }

    private static int getDefaultSharedPreferencesMode() {
        return 0;
    }

    private static String getDefaultSharedPreferencesName(Context context) {
        return (new StringBuilder()).append(context.getPackageName()).append("_preferences").toString();
    }

    private void init(Context context) {
        mContext = context;
        setSharedPreferencesName(getDefaultSharedPreferencesName(context));
    }

    private List queryIntentActivities(Intent intent) {
        return mContext.getPackageManager().queryIntentActivities(intent, 128);
    }

    public static void setDefaultValues(Context context, int i, boolean flag) {
        setDefaultValues(context, getDefaultSharedPreferencesName(context), getDefaultSharedPreferencesMode(), i, flag);
    }

    public static void setDefaultValues(Context context, String s, int i, int j, boolean flag) {
        android.content.SharedPreferences.Editor editor;
        SharedPreferences sharedpreferences = context.getSharedPreferences("_has_set_default_values", 0);
        if(!flag && sharedpreferences.getBoolean("_has_set_default_values", false))
            break MISSING_BLOCK_LABEL_82;
        PreferenceManager preferencemanager = new PreferenceManager(context);
        preferencemanager.setSharedPreferencesName(s);
        preferencemanager.setSharedPreferencesMode(i);
        preferencemanager.inflateFromResource(context, j, null);
        editor = sharedpreferences.edit().putBoolean("_has_set_default_values", true);
        editor.apply();
_L1:
        return;
        AbstractMethodError abstractmethoderror;
        abstractmethoderror;
        editor.commit();
          goto _L1
    }

    private void setNoCommit(boolean flag) {
        if(!flag && mEditor != null)
            try {
                mEditor.apply();
            }
            catch(AbstractMethodError abstractmethoderror) {
                mEditor.commit();
            }
        mNoCommit = flag;
    }

    void addPreferencesScreen(DialogInterface dialoginterface) {
        this;
        JVM INSTR monitorenter ;
        if(mPreferencesScreens == null)
            mPreferencesScreens = new ArrayList();
        mPreferencesScreens.add(dialoginterface);
        return;
    }

    public PreferenceScreen createPreferenceScreen(Context context) {
        PreferenceScreen preferencescreen = new PreferenceScreen(context, null);
        preferencescreen.onAttachedToHierarchy(this);
        return preferencescreen;
    }

    void dispatchActivityDestroy() {
        ArrayList arraylist = null;
        this;
        JVM INSTR monitorenter ;
        if(mActivityDestroyListeners != null)
            arraylist = new ArrayList(mActivityDestroyListeners);
        this;
        JVM INSTR monitorexit ;
        if(arraylist != null) {
            int i = arraylist.size();
            for(int j = 0; j < i; j++)
                ((OnActivityDestroyListener)arraylist.get(j)).onActivityDestroy();

        }
        break MISSING_BLOCK_LABEL_72;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        dismissAllScreens();
        return;
    }

    void dispatchActivityResult(int i, int j, Intent intent) {
        this;
        JVM INSTR monitorenter ;
        if(mActivityResultListeners != null)
            break MISSING_BLOCK_LABEL_14;
        this;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_84;
        ArrayList arraylist = new ArrayList(mActivityResultListeners);
        this;
        JVM INSTR monitorexit ;
        int k = arraylist.size();
        for(int l = 0; l < k && !((OnActivityResultListener)arraylist.get(l)).onActivityResult(i, j, intent); l++);
        break MISSING_BLOCK_LABEL_84;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void dispatchActivityStop() {
        this;
        JVM INSTR monitorenter ;
        if(mActivityStopListeners != null)
            break MISSING_BLOCK_LABEL_14;
        this;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_71;
        ArrayList arraylist = new ArrayList(mActivityStopListeners);
        this;
        JVM INSTR monitorexit ;
        int i = arraylist.size();
        for(int j = 0; j < i; j++)
            ((OnActivityStopListener)arraylist.get(j)).onActivityStop();

        break MISSING_BLOCK_LABEL_71;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void dispatchNewIntent(Intent intent) {
        dismissAllScreens();
    }

    public Preference findPreference(CharSequence charsequence) {
        Preference preference;
        if(mPreferenceScreen == null)
            preference = null;
        else
            preference = mPreferenceScreen.findPreference(charsequence);
        return preference;
    }

    Activity getActivity() {
        return mActivity;
    }

    Context getContext() {
        return mContext;
    }

    android.content.SharedPreferences.Editor getEditor() {
        android.content.SharedPreferences.Editor editor;
        if(mNoCommit) {
            if(mEditor == null)
                mEditor = getSharedPreferences().edit();
            editor = mEditor;
        } else {
            editor = getSharedPreferences().edit();
        }
        return editor;
    }

    PreferenceFragment getFragment() {
        return mFragment;
    }

    long getNextId() {
        this;
        JVM INSTR monitorenter ;
        long l = mNextId;
        mNextId = 1L + l;
        return l;
    }

    int getNextRequestCode() {
        this;
        JVM INSTR monitorenter ;
        int i = mNextRequestCode;
        mNextRequestCode = i + 1;
        return i;
    }

    OnPreferenceTreeClickListener getOnPreferenceTreeClickListener() {
        return mOnPreferenceTreeClickListener;
    }

    PreferenceScreen getPreferenceScreen() {
        return mPreferenceScreen;
    }

    public SharedPreferences getSharedPreferences() {
        if(mSharedPreferences == null)
            mSharedPreferences = mContext.getSharedPreferences(mSharedPreferencesName, mSharedPreferencesMode);
        return mSharedPreferences;
    }

    public int getSharedPreferencesMode() {
        return mSharedPreferencesMode;
    }

    public String getSharedPreferencesName() {
        return mSharedPreferencesName;
    }

    PreferenceScreen inflateFromIntent(Intent intent, PreferenceScreen preferencescreen) {
        List list;
        HashSet hashset;
        int i;
        list = queryIntentActivities(intent);
        hashset = new HashSet();
        i = -1 + list.size();
_L2:
        ActivityInfo activityinfo;
        if(i < 0)
            break MISSING_BLOCK_LABEL_245;
        activityinfo = ((ResolveInfo)list.get(i)).activityInfo;
        Bundle bundle = ((PackageItemInfo) (activityinfo)).metaData;
        if(bundle != null && bundle.containsKey("android.preference"))
            break; /* Loop/switch isn't completed */
_L4:
        i--;
        if(true) goto _L2; else goto _L1
_L1:
        String s = (new StringBuilder()).append(((PackageItemInfo) (activityinfo)).packageName).append(":").append(((PackageItemInfo) (activityinfo)).metaData.getInt("android.preference")).toString();
        if(hashset.contains(s)) goto _L4; else goto _L3
_L3:
        hashset.add(s);
        Context context = mContext.createPackageContext(((PackageItemInfo) (activityinfo)).packageName, 0);
        PreferenceInflater preferenceinflater = new PreferenceInflater(context, this);
        XmlResourceParser xmlresourceparser = activityinfo.loadXmlMetaData(context.getPackageManager(), "android.preference");
        preferencescreen = (PreferenceScreen)preferenceinflater.inflate(xmlresourceparser, preferencescreen, true);
        xmlresourceparser.close();
          goto _L4
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        Log.w("PreferenceManager", (new StringBuilder()).append("Could not create context for ").append(((PackageItemInfo) (activityinfo)).packageName).append(": ").append(Log.getStackTraceString(namenotfoundexception)).toString());
          goto _L4
        preferencescreen.onAttachedToHierarchy(this);
        return preferencescreen;
    }

    public PreferenceScreen inflateFromResource(Context context, int i, PreferenceScreen preferencescreen) {
        setNoCommit(true);
        PreferenceScreen preferencescreen1 = (PreferenceScreen)(new PreferenceInflater(context, this)).inflate(i, preferencescreen, true);
        preferencescreen1.onAttachedToHierarchy(this);
        setNoCommit(false);
        return preferencescreen1;
    }

    void registerOnActivityDestroyListener(OnActivityDestroyListener onactivitydestroylistener) {
        this;
        JVM INSTR monitorenter ;
        if(mActivityDestroyListeners == null)
            mActivityDestroyListeners = new ArrayList();
        if(!mActivityDestroyListeners.contains(onactivitydestroylistener))
            mActivityDestroyListeners.add(onactivitydestroylistener);
        return;
    }

    void registerOnActivityResultListener(OnActivityResultListener onactivityresultlistener) {
        this;
        JVM INSTR monitorenter ;
        if(mActivityResultListeners == null)
            mActivityResultListeners = new ArrayList();
        if(!mActivityResultListeners.contains(onactivityresultlistener))
            mActivityResultListeners.add(onactivityresultlistener);
        return;
    }

    void registerOnActivityStopListener(OnActivityStopListener onactivitystoplistener) {
        this;
        JVM INSTR monitorenter ;
        if(mActivityStopListeners == null)
            mActivityStopListeners = new ArrayList();
        if(!mActivityStopListeners.contains(onactivitystoplistener))
            mActivityStopListeners.add(onactivitystoplistener);
        return;
    }

    void removePreferencesScreen(DialogInterface dialoginterface) {
        this;
        JVM INSTR monitorenter ;
        if(mPreferencesScreens != null)
            mPreferencesScreens.remove(dialoginterface);
        return;
    }

    void setFragment(PreferenceFragment preferencefragment) {
        mFragment = preferencefragment;
    }

    void setOnPreferenceTreeClickListener(OnPreferenceTreeClickListener onpreferencetreeclicklistener) {
        mOnPreferenceTreeClickListener = onpreferencetreeclicklistener;
    }

    boolean setPreferences(PreferenceScreen preferencescreen) {
        boolean flag;
        if(preferencescreen != mPreferenceScreen) {
            mPreferenceScreen = preferencescreen;
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public void setSharedPreferencesMode(int i) {
        mSharedPreferencesMode = i;
        mSharedPreferences = null;
    }

    public void setSharedPreferencesName(String s) {
        mSharedPreferencesName = s;
        mSharedPreferences = null;
    }

    boolean shouldCommit() {
        boolean flag;
        if(!mNoCommit)
            flag = true;
        else
            flag = false;
        return flag;
    }

    void unregisterOnActivityDestroyListener(OnActivityDestroyListener onactivitydestroylistener) {
        this;
        JVM INSTR monitorenter ;
        if(mActivityDestroyListeners != null)
            mActivityDestroyListeners.remove(onactivitydestroylistener);
        return;
    }

    void unregisterOnActivityResultListener(OnActivityResultListener onactivityresultlistener) {
        this;
        JVM INSTR monitorenter ;
        if(mActivityResultListeners != null)
            mActivityResultListeners.remove(onactivityresultlistener);
        return;
    }

    void unregisterOnActivityStopListener(OnActivityStopListener onactivitystoplistener) {
        this;
        JVM INSTR monitorenter ;
        if(mActivityStopListeners != null)
            mActivityStopListeners.remove(onactivitystoplistener);
        return;
    }

    public static final String KEY_HAS_SET_DEFAULT_VALUES = "_has_set_default_values";
    public static final String METADATA_KEY_PREFERENCES = "android.preference";
    private static final String TAG = "PreferenceManager";
    private Activity mActivity;
    private List mActivityDestroyListeners;
    private List mActivityResultListeners;
    private List mActivityStopListeners;
    private Context mContext;
    private android.content.SharedPreferences.Editor mEditor;
    private PreferenceFragment mFragment;
    private long mNextId;
    private int mNextRequestCode;
    private boolean mNoCommit;
    private OnPreferenceTreeClickListener mOnPreferenceTreeClickListener;
    private PreferenceScreen mPreferenceScreen;
    private List mPreferencesScreens;
    private SharedPreferences mSharedPreferences;
    private int mSharedPreferencesMode;
    private String mSharedPreferencesName;
}

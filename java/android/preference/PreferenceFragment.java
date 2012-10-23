// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.preference;

import android.app.Fragment;
import android.content.Intent;
import android.os.*;
import android.view.*;
import android.widget.ListView;

// Referenced classes of package android.preference:
//            PreferenceScreen, PreferenceManager, Preference

public abstract class PreferenceFragment extends Fragment
    implements PreferenceManager.OnPreferenceTreeClickListener {
    public static interface OnPreferenceStartFragmentCallback {

        public abstract boolean onPreferenceStartFragment(PreferenceFragment preferencefragment, Preference preference);
    }


    public PreferenceFragment() {
        mHandler = new Handler() {

            public void handleMessage(Message message) {
                message.what;
                JVM INSTR tableswitch 1 1: default 24
            //                           1 25;
                   goto _L1 _L2
_L1:
                return;
_L2:
                bindPreferences();
                if(true) goto _L1; else goto _L3
_L3:
            }

            final PreferenceFragment this$0;

             {
                this$0 = PreferenceFragment.this;
                super();
            }
        };
        mListOnKeyListener = new android.view.View.OnKeyListener() {

            public boolean onKey(View view, int i, KeyEvent keyevent) {
                Object obj = mList.getSelectedItem();
                boolean flag;
                if(obj instanceof Preference) {
                    View view1 = mList.getSelectedView();
                    flag = ((Preference)obj).onKey(view1, i, keyevent);
                } else {
                    flag = false;
                }
                return flag;
            }

            final PreferenceFragment this$0;

             {
                this$0 = PreferenceFragment.this;
                super();
            }
        };
    }

    private void bindPreferences() {
        PreferenceScreen preferencescreen = getPreferenceScreen();
        if(preferencescreen != null)
            preferencescreen.bind(getListView());
    }

    private void ensureList() {
        if(mList == null) {
            View view = getView();
            if(view == null)
                throw new IllegalStateException("Content view not yet created");
            View view1 = view.findViewById(0x102000a);
            if(!(view1 instanceof ListView))
                throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
            mList = (ListView)view1;
            if(mList == null)
                throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
            mList.setOnKeyListener(mListOnKeyListener);
            mHandler.post(mRequestFocus);
        }
    }

    private void postBindPreferences() {
        if(!mHandler.hasMessages(1))
            mHandler.obtainMessage(1).sendToTarget();
    }

    private void requirePreferenceManager() {
        if(mPreferenceManager == null)
            throw new RuntimeException("This should be called after super.onCreate.");
        else
            return;
    }

    public void addPreferencesFromIntent(Intent intent) {
        requirePreferenceManager();
        setPreferenceScreen(mPreferenceManager.inflateFromIntent(intent, getPreferenceScreen()));
    }

    public void addPreferencesFromResource(int i) {
        requirePreferenceManager();
        setPreferenceScreen(mPreferenceManager.inflateFromResource(getActivity(), i, getPreferenceScreen()));
    }

    public Preference findPreference(CharSequence charsequence) {
        Preference preference;
        if(mPreferenceManager == null)
            preference = null;
        else
            preference = mPreferenceManager.findPreference(charsequence);
        return preference;
    }

    public ListView getListView() {
        ensureList();
        return mList;
    }

    public PreferenceManager getPreferenceManager() {
        return mPreferenceManager;
    }

    public PreferenceScreen getPreferenceScreen() {
        return mPreferenceManager.getPreferenceScreen();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if(mHavePrefs)
            bindPreferences();
        mInitDone = true;
        if(bundle != null) {
            Bundle bundle1 = bundle.getBundle("android:preferences");
            if(bundle1 != null) {
                PreferenceScreen preferencescreen = getPreferenceScreen();
                if(preferencescreen != null)
                    preferencescreen.restoreHierarchyState(bundle1);
            }
        }
    }

    public void onActivityResult(int i, int j, Intent intent) {
        super.onActivityResult(i, j, intent);
        mPreferenceManager.dispatchActivityResult(i, j, intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mPreferenceManager = new PreferenceManager(getActivity(), 100);
        mPreferenceManager.setFragment(this);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle) {
        return layoutinflater.inflate(0x1090089, viewgroup, false);
    }

    public void onDestroy() {
        super.onDestroy();
        mPreferenceManager.dispatchActivityDestroy();
    }

    public void onDestroyView() {
        mList = null;
        mHandler.removeCallbacks(mRequestFocus);
        mHandler.removeMessages(1);
        super.onDestroyView();
    }

    public boolean onPreferenceTreeClick(PreferenceScreen preferencescreen, Preference preference) {
        boolean flag;
        if(preference.getFragment() != null && (getActivity() instanceof OnPreferenceStartFragmentCallback))
            flag = ((OnPreferenceStartFragmentCallback)getActivity()).onPreferenceStartFragment(this, preference);
        else
            flag = false;
        return flag;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        PreferenceScreen preferencescreen = getPreferenceScreen();
        if(preferencescreen != null) {
            Bundle bundle1 = new Bundle();
            preferencescreen.saveHierarchyState(bundle1);
            bundle.putBundle("android:preferences", bundle1);
        }
    }

    public void onStart() {
        super.onStart();
        mPreferenceManager.setOnPreferenceTreeClickListener(this);
    }

    public void onStop() {
        super.onStop();
        mPreferenceManager.dispatchActivityStop();
        mPreferenceManager.setOnPreferenceTreeClickListener(null);
    }

    public void setPreferenceScreen(PreferenceScreen preferencescreen) {
        if(mPreferenceManager.setPreferences(preferencescreen) && preferencescreen != null) {
            mHavePrefs = true;
            if(mInitDone)
                postBindPreferences();
        }
    }

    private static final int FIRST_REQUEST_CODE = 100;
    private static final int MSG_BIND_PREFERENCES = 1;
    private static final String PREFERENCES_TAG = "android:preferences";
    private Handler mHandler;
    private boolean mHavePrefs;
    private boolean mInitDone;
    private ListView mList;
    private android.view.View.OnKeyListener mListOnKeyListener;
    private PreferenceManager mPreferenceManager;
    private final Runnable mRequestFocus = new Runnable() {

        public void run() {
            mList.focusableViewAvailable(mList);
        }

        final PreferenceFragment this$0;

             {
                this$0 = PreferenceFragment.this;
                super();
            }
    };


}

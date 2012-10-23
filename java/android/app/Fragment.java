// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.animation.Animator;
import android.content.*;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.*;
import android.util.*;
import android.view.*;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.HashMap;

// Referenced classes of package android.app:
//            LoaderManagerImpl, Activity, FragmentManagerImpl, FragmentManager, 
//            LoaderManager

public class Fragment
    implements ComponentCallbacks2, android.view.View.OnCreateContextMenuListener {
    public static class InstantiationException extends AndroidRuntimeException {

        public InstantiationException(String s, Exception exception) {
            super(s, exception);
        }
    }

    public static class SavedState
        implements Parcelable {

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(mState);
        }

        public static final android.os.Parcelable.ClassLoaderCreator CREATOR = new android.os.Parcelable.ClassLoaderCreator() {

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            public SavedState createFromParcel(Parcel parcel, ClassLoader classloader) {
                return new SavedState(parcel, classloader);
            }

            public volatile Object createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel, ClassLoader classloader) {
                return createFromParcel(parcel, classloader);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            public volatile Object[] newArray(int i) {
                return newArray(i);
            }

        };
        final Bundle mState;


        SavedState(Bundle bundle) {
            mState = bundle;
        }

        SavedState(Parcel parcel, ClassLoader classloader) {
            mState = parcel.readBundle();
            if(classloader != null && mState != null)
                mState.setClassLoader(classloader);
        }
    }


    public Fragment() {
        mState = 0;
        mIndex = -1;
        mTargetIndex = -1;
        mMenuVisible = true;
        mUserVisibleHint = true;
    }

    public static Fragment instantiate(Context context, String s) {
        return instantiate(context, s, null);
    }

    public static Fragment instantiate(Context context, String s, Bundle bundle) {
        Fragment fragment;
        try {
            Class class1 = (Class)sClassMap.get(s);
            if(class1 == null) {
                class1 = context.getClassLoader().loadClass(s);
                sClassMap.put(s, class1);
            }
            fragment = (Fragment)class1.newInstance();
            if(bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.mArguments = bundle;
            }
        }
        catch(ClassNotFoundException classnotfoundexception) {
            throw new InstantiationException((new StringBuilder()).append("Unable to instantiate fragment ").append(s).append(": make sure class name exists, is public, and has an").append(" empty constructor that is public").toString(), classnotfoundexception);
        }
        catch(java.lang.InstantiationException instantiationexception) {
            throw new InstantiationException((new StringBuilder()).append("Unable to instantiate fragment ").append(s).append(": make sure class name exists, is public, and has an").append(" empty constructor that is public").toString(), instantiationexception);
        }
        catch(IllegalAccessException illegalaccessexception) {
            throw new InstantiationException((new StringBuilder()).append("Unable to instantiate fragment ").append(s).append(": make sure class name exists, is public, and has an").append(" empty constructor that is public").toString(), illegalaccessexception);
        }
        return fragment;
    }

    public void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        printwriter.print(s);
        printwriter.print("mFragmentId=#");
        printwriter.print(Integer.toHexString(mFragmentId));
        printwriter.print(" mContainerId=#");
        printwriter.print(Integer.toHexString(mContainerId));
        printwriter.print(" mTag=");
        printwriter.println(mTag);
        printwriter.print(s);
        printwriter.print("mState=");
        printwriter.print(mState);
        printwriter.print(" mIndex=");
        printwriter.print(mIndex);
        printwriter.print(" mWho=");
        printwriter.print(mWho);
        printwriter.print(" mBackStackNesting=");
        printwriter.println(mBackStackNesting);
        printwriter.print(s);
        printwriter.print("mAdded=");
        printwriter.print(mAdded);
        printwriter.print(" mRemoving=");
        printwriter.print(mRemoving);
        printwriter.print(" mResumed=");
        printwriter.print(mResumed);
        printwriter.print(" mFromLayout=");
        printwriter.print(mFromLayout);
        printwriter.print(" mInLayout=");
        printwriter.println(mInLayout);
        printwriter.print(s);
        printwriter.print("mHidden=");
        printwriter.print(mHidden);
        printwriter.print(" mDetached=");
        printwriter.print(mDetached);
        printwriter.print(" mMenuVisible=");
        printwriter.print(mMenuVisible);
        printwriter.print(" mHasMenu=");
        printwriter.println(mHasMenu);
        printwriter.print(s);
        printwriter.print("mRetainInstance=");
        printwriter.print(mRetainInstance);
        printwriter.print(" mRetaining=");
        printwriter.print(mRetaining);
        printwriter.print(" mUserVisibleHint=");
        printwriter.println(mUserVisibleHint);
        if(mFragmentManager != null) {
            printwriter.print(s);
            printwriter.print("mFragmentManager=");
            printwriter.println(mFragmentManager);
        }
        if(mActivity != null) {
            printwriter.print(s);
            printwriter.print("mActivity=");
            printwriter.println(mActivity);
        }
        if(mArguments != null) {
            printwriter.print(s);
            printwriter.print("mArguments=");
            printwriter.println(mArguments);
        }
        if(mSavedFragmentState != null) {
            printwriter.print(s);
            printwriter.print("mSavedFragmentState=");
            printwriter.println(mSavedFragmentState);
        }
        if(mSavedViewState != null) {
            printwriter.print(s);
            printwriter.print("mSavedViewState=");
            printwriter.println(mSavedViewState);
        }
        if(mTarget != null) {
            printwriter.print(s);
            printwriter.print("mTarget=");
            printwriter.print(mTarget);
            printwriter.print(" mTargetRequestCode=");
            printwriter.println(mTargetRequestCode);
        }
        if(mNextAnim != 0) {
            printwriter.print(s);
            printwriter.print("mNextAnim=");
            printwriter.println(mNextAnim);
        }
        if(mContainer != null) {
            printwriter.print(s);
            printwriter.print("mContainer=");
            printwriter.println(mContainer);
        }
        if(mView != null) {
            printwriter.print(s);
            printwriter.print("mView=");
            printwriter.println(mView);
        }
        if(mAnimatingAway != null) {
            printwriter.print(s);
            printwriter.print("mAnimatingAway=");
            printwriter.println(mAnimatingAway);
            printwriter.print(s);
            printwriter.print("mStateAfterAnimating=");
            printwriter.println(mStateAfterAnimating);
        }
        if(mLoaderManager != null) {
            printwriter.print(s);
            printwriter.println("Loader Manager:");
            mLoaderManager.dump((new StringBuilder()).append(s).append("  ").toString(), filedescriptor, printwriter, as);
        }
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final Activity getActivity() {
        return mActivity;
    }

    public final Bundle getArguments() {
        return mArguments;
    }

    public final FragmentManager getFragmentManager() {
        return mFragmentManager;
    }

    public final int getId() {
        return mFragmentId;
    }

    public LayoutInflater getLayoutInflater(Bundle bundle) {
        return mActivity.getLayoutInflater();
    }

    public LoaderManager getLoaderManager() {
        LoaderManagerImpl loadermanagerimpl;
        if(mLoaderManager != null) {
            loadermanagerimpl = mLoaderManager;
        } else {
            if(mActivity == null)
                throw new IllegalStateException((new StringBuilder()).append("Fragment ").append(this).append(" not attached to Activity").toString());
            mCheckedForLoaderManager = true;
            mLoaderManager = mActivity.getLoaderManager(mIndex, mLoadersStarted, true);
            loadermanagerimpl = mLoaderManager;
        }
        return loadermanagerimpl;
    }

    public final Resources getResources() {
        if(mActivity == null)
            throw new IllegalStateException((new StringBuilder()).append("Fragment ").append(this).append(" not attached to Activity").toString());
        else
            return mActivity.getResources();
    }

    public final boolean getRetainInstance() {
        return mRetainInstance;
    }

    public final String getString(int i) {
        return getResources().getString(i);
    }

    public final transient String getString(int i, Object aobj[]) {
        return getResources().getString(i, aobj);
    }

    public final String getTag() {
        return mTag;
    }

    public final Fragment getTargetFragment() {
        return mTarget;
    }

    public final int getTargetRequestCode() {
        return mTargetRequestCode;
    }

    public final CharSequence getText(int i) {
        return getResources().getText(i);
    }

    public boolean getUserVisibleHint() {
        return mUserVisibleHint;
    }

    public View getView() {
        return mView;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    void initState() {
        mIndex = -1;
        mWho = null;
        mAdded = false;
        mRemoving = false;
        mResumed = false;
        mFromLayout = false;
        mInLayout = false;
        mRestored = false;
        mBackStackNesting = 0;
        mFragmentManager = null;
        mActivity = null;
        mFragmentId = 0;
        mContainerId = 0;
        mTag = null;
        mHidden = false;
        mDetached = false;
        mRetaining = false;
        mLoaderManager = null;
        mLoadersStarted = false;
        mCheckedForLoaderManager = false;
    }

    public final boolean isAdded() {
        boolean flag;
        if(mActivity != null && mAdded)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public final boolean isDetached() {
        return mDetached;
    }

    public final boolean isHidden() {
        return mHidden;
    }

    final boolean isInBackStack() {
        boolean flag;
        if(mBackStackNesting > 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public final boolean isInLayout() {
        return mInLayout;
    }

    public final boolean isRemoving() {
        return mRemoving;
    }

    public final boolean isResumed() {
        return mResumed;
    }

    public final boolean isVisible() {
        boolean flag;
        if(isAdded() && !isHidden() && mView != null && mView.getWindowToken() != null && mView.getVisibility() == 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void onActivityCreated(Bundle bundle) {
        mCalled = true;
    }

    public void onActivityResult(int i, int j, Intent intent) {
    }

    public void onAttach(Activity activity) {
        mCalled = true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuitem) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        mCalled = true;
    }

    public Animator onCreateAnimator(int i, boolean flag, int j) {
        return null;
    }

    public void onCreateContextMenu(ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo) {
        getActivity().onCreateContextMenu(contextmenu, view, contextmenuinfo);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater) {
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle) {
        return null;
    }

    public void onDestroy() {
        mCalled = true;
        if(!mCheckedForLoaderManager) {
            mCheckedForLoaderManager = true;
            mLoaderManager = mActivity.getLoaderManager(mIndex, mLoadersStarted, false);
        }
        if(mLoaderManager != null)
            mLoaderManager.doDestroy();
    }

    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        mCalled = true;
    }

    public void onDetach() {
        mCalled = true;
    }

    public void onHiddenChanged(boolean flag) {
    }

    public void onInflate(Activity activity, AttributeSet attributeset, Bundle bundle) {
        onInflate(attributeset, bundle);
        mCalled = true;
    }

    public void onInflate(AttributeSet attributeset, Bundle bundle) {
        mCalled = true;
    }

    public void onLowMemory() {
        mCalled = true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem) {
        return false;
    }

    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPause() {
        mCalled = true;
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onResume() {
        mCalled = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
        mCalled = true;
        if(!mLoadersStarted) {
            mLoadersStarted = true;
            if(!mCheckedForLoaderManager) {
                mCheckedForLoaderManager = true;
                mLoaderManager = mActivity.getLoaderManager(mIndex, mLoadersStarted, false);
            }
            if(mLoaderManager != null)
                mLoaderManager.doStart();
        }
    }

    public void onStop() {
        mCalled = true;
    }

    public void onTrimMemory(int i) {
        mCalled = true;
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    void performDestroyView() {
        onDestroyView();
        if(mLoaderManager != null)
            mLoaderManager.doReportNextStart();
    }

    void performStart() {
        onStart();
        if(mLoaderManager != null)
            mLoaderManager.doReportStart();
    }

    void performStop() {
        onStop();
        if(mLoadersStarted) {
            mLoadersStarted = false;
            if(!mCheckedForLoaderManager) {
                mCheckedForLoaderManager = true;
                mLoaderManager = mActivity.getLoaderManager(mIndex, mLoadersStarted, false);
            }
            if(mLoaderManager != null)
                if(mActivity == null || !mActivity.mChangingConfigurations)
                    mLoaderManager.doStop();
                else
                    mLoaderManager.doRetain();
        }
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    final void restoreViewState() {
        if(mSavedViewState != null) {
            mView.restoreHierarchyState(mSavedViewState);
            mSavedViewState = null;
        }
    }

    public void setArguments(Bundle bundle) {
        if(mIndex >= 0) {
            throw new IllegalStateException("Fragment already active");
        } else {
            mArguments = bundle;
            return;
        }
    }

    public void setHasOptionsMenu(boolean flag) {
        if(mHasMenu != flag) {
            mHasMenu = flag;
            if(isAdded() && !isHidden())
                mFragmentManager.invalidateOptionsMenu();
        }
    }

    final void setIndex(int i) {
        mIndex = i;
        mWho = (new StringBuilder()).append("android:fragment:").append(mIndex).toString();
    }

    public void setInitialSavedState(SavedState savedstate) {
        if(mIndex >= 0)
            throw new IllegalStateException("Fragment already active");
        Bundle bundle;
        if(savedstate != null && savedstate.mState != null)
            bundle = savedstate.mState;
        else
            bundle = null;
        mSavedFragmentState = bundle;
    }

    public void setMenuVisibility(boolean flag) {
        if(mMenuVisible != flag) {
            mMenuVisible = flag;
            if(mHasMenu && isAdded() && !isHidden())
                mFragmentManager.invalidateOptionsMenu();
        }
    }

    public void setRetainInstance(boolean flag) {
        mRetainInstance = flag;
    }

    public void setTargetFragment(Fragment fragment, int i) {
        mTarget = fragment;
        mTargetRequestCode = i;
    }

    public void setUserVisibleHint(boolean flag) {
        if(!mUserVisibleHint && flag && mState < 4)
            mFragmentManager.performPendingDeferredStart(this);
        mUserVisibleHint = flag;
        boolean flag1;
        if(!flag)
            flag1 = true;
        else
            flag1 = false;
        mDeferStart = flag1;
    }

    public void startActivity(Intent intent) {
        startActivity(intent, null);
    }

    public void startActivity(Intent intent, Bundle bundle) {
        if(mActivity == null)
            throw new IllegalStateException((new StringBuilder()).append("Fragment ").append(this).append(" not attached to Activity").toString());
        if(bundle != null)
            mActivity.startActivityFromFragment(this, intent, -1, bundle);
        else
            mActivity.startActivityFromFragment(this, intent, -1);
    }

    public void startActivityForResult(Intent intent, int i) {
        startActivityForResult(intent, i, null);
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if(mActivity == null)
            throw new IllegalStateException((new StringBuilder()).append("Fragment ").append(this).append(" not attached to Activity").toString());
        if(bundle != null)
            mActivity.startActivityFromFragment(this, intent, i, bundle);
        else
            mActivity.startActivityFromFragment(this, intent, i, bundle);
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder(128);
        DebugUtils.buildShortClassTag(this, stringbuilder);
        if(mIndex >= 0) {
            stringbuilder.append(" #");
            stringbuilder.append(mIndex);
        }
        if(mFragmentId != 0) {
            stringbuilder.append(" id=0x");
            stringbuilder.append(Integer.toHexString(mFragmentId));
        }
        if(mTag != null) {
            stringbuilder.append(" ");
            stringbuilder.append(mTag);
        }
        stringbuilder.append('}');
        return stringbuilder.toString();
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }

    static final int ACTIVITY_CREATED = 2;
    static final int CREATED = 1;
    static final int INITIALIZING = 0;
    static final int INVALID_STATE = -1;
    static final int RESUMED = 5;
    static final int STARTED = 4;
    static final int STOPPED = 3;
    private static final HashMap sClassMap = new HashMap();
    Activity mActivity;
    boolean mAdded;
    Animator mAnimatingAway;
    Bundle mArguments;
    int mBackStackNesting;
    boolean mCalled;
    boolean mCheckedForLoaderManager;
    ViewGroup mContainer;
    int mContainerId;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    FragmentManagerImpl mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mInLayout;
    int mIndex;
    LoaderManagerImpl mLoaderManager;
    boolean mLoadersStarted;
    boolean mMenuVisible;
    int mNextAnim;
    boolean mRemoving;
    boolean mRestored;
    boolean mResumed;
    boolean mRetainInstance;
    boolean mRetaining;
    Bundle mSavedFragmentState;
    SparseArray mSavedViewState;
    int mState;
    int mStateAfterAnimating;
    String mTag;
    Fragment mTarget;
    int mTargetIndex;
    int mTargetRequestCode;
    boolean mUserVisibleHint;
    View mView;
    String mWho;

}

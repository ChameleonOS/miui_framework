// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.animation.*;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.*;
import android.util.*;
import android.view.*;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

// Referenced classes of package android.app:
//            FragmentManager, Fragment, BackStackRecord, Activity, 
//            LoaderManagerImpl, SuperNotCalledException, FragmentManagerState, FragmentState, 
//            BackStackState, FragmentTransaction

final class FragmentManagerImpl extends FragmentManager {

    FragmentManagerImpl() {
        mCurState = 0;
        mStateBundle = null;
        mStateArray = null;
        mExecCommit = new Runnable() {

            public void run() {
                execPendingActions();
            }

            final FragmentManagerImpl this$0;

             {
                this$0 = FragmentManagerImpl.this;
                super();
            }
        };
    }

    private void checkStateLoss() {
        if(mStateSaved)
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        if(mNoTransactionsBecause != null)
            throw new IllegalStateException((new StringBuilder()).append("Can not perform this action inside of ").append(mNoTransactionsBecause).toString());
        else
            return;
    }

    public static int reverseTransit(int i) {
        int j = 0;
        i;
        JVM INSTR lookupswitch 3: default 36
    //                   4097: 38
    //                   4099: 52
    //                   8194: 45;
           goto _L1 _L2 _L3 _L4
_L1:
        return j;
_L2:
        j = 8194;
        continue; /* Loop/switch isn't completed */
_L4:
        j = 4097;
        continue; /* Loop/switch isn't completed */
_L3:
        j = 4099;
        if(true) goto _L1; else goto _L5
_L5:
    }

    public static int transitToStyleIndex(int i, boolean flag) {
        byte byte0 = -1;
        i;
        JVM INSTR lookupswitch 3: default 40
    //                   4097: 42
    //                   4099: 70
    //                   8194: 56;
           goto _L1 _L2 _L3 _L4
_L1:
        return byte0;
_L2:
        if(flag)
            byte0 = 0;
        else
            byte0 = 1;
        continue; /* Loop/switch isn't completed */
_L4:
        if(flag)
            byte0 = 2;
        else
            byte0 = 3;
        continue; /* Loop/switch isn't completed */
_L3:
        if(flag)
            byte0 = 4;
        else
            byte0 = 5;
        if(true) goto _L1; else goto _L5
_L5:
    }

    void addBackStackState(BackStackRecord backstackrecord) {
        if(mBackStack == null)
            mBackStack = new ArrayList();
        mBackStack.add(backstackrecord);
        reportBackStackChanged();
    }

    public void addFragment(Fragment fragment, boolean flag) {
        if(mAdded == null)
            mAdded = new ArrayList();
        if(DEBUG)
            Log.v("FragmentManager", (new StringBuilder()).append("add: ").append(fragment).toString());
        makeActive(fragment);
        if(!fragment.mDetached) {
            mAdded.add(fragment);
            fragment.mAdded = true;
            fragment.mRemoving = false;
            if(fragment.mHasMenu && fragment.mMenuVisible)
                mNeedMenuInvalidate = true;
            if(flag)
                moveToState(fragment);
        }
    }

    public void addOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener onbackstackchangedlistener) {
        if(mBackStackChangeListeners == null)
            mBackStackChangeListeners = new ArrayList();
        mBackStackChangeListeners.add(onbackstackchangedlistener);
    }

    public int allocBackStackIndex(BackStackRecord backstackrecord) {
        this;
        JVM INSTR monitorenter ;
        int j;
        if(mAvailBackStackIndices == null || mAvailBackStackIndices.size() <= 0) {
            if(mBackStackIndices == null)
                mBackStackIndices = new ArrayList();
            int i = mBackStackIndices.size();
            if(DEBUG)
                Log.v("FragmentManager", (new StringBuilder()).append("Setting back stack index ").append(i).append(" to ").append(backstackrecord).toString());
            mBackStackIndices.add(backstackrecord);
            j = i;
        } else {
            int k = ((Integer)mAvailBackStackIndices.remove(-1 + mAvailBackStackIndices.size())).intValue();
            if(DEBUG)
                Log.v("FragmentManager", (new StringBuilder()).append("Adding back stack index ").append(k).append(" with ").append(backstackrecord).toString());
            mBackStackIndices.set(k, backstackrecord);
            j = k;
        }
        return j;
    }

    public void attachActivity(Activity activity) {
        if(mActivity != null) {
            throw new IllegalStateException();
        } else {
            mActivity = activity;
            return;
        }
    }

    public void attachFragment(Fragment fragment, int i, int j) {
        if(DEBUG)
            Log.v("FragmentManager", (new StringBuilder()).append("attach: ").append(fragment).toString());
        if(fragment.mDetached) {
            fragment.mDetached = false;
            if(!fragment.mAdded) {
                if(mAdded == null)
                    mAdded = new ArrayList();
                mAdded.add(fragment);
                fragment.mAdded = true;
                if(fragment.mHasMenu && fragment.mMenuVisible)
                    mNeedMenuInvalidate = true;
                moveToState(fragment, mCurState, i, j, false);
            }
        }
    }

    public FragmentTransaction beginTransaction() {
        return new BackStackRecord(this);
    }

    public void detachFragment(Fragment fragment, int i, int j) {
        if(DEBUG)
            Log.v("FragmentManager", (new StringBuilder()).append("detach: ").append(fragment).toString());
        if(!fragment.mDetached) {
            fragment.mDetached = true;
            if(fragment.mAdded) {
                if(mAdded != null)
                    mAdded.remove(fragment);
                if(fragment.mHasMenu && fragment.mMenuVisible)
                    mNeedMenuInvalidate = true;
                fragment.mAdded = false;
                moveToState(fragment, 1, i, j, false);
            }
        }
    }

    public void dispatchActivityCreated() {
        mStateSaved = false;
        moveToState(2, false);
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        if(mAdded != null) {
            for(int i = 0; i < mAdded.size(); i++) {
                Fragment fragment = (Fragment)mAdded.get(i);
                if(fragment != null)
                    fragment.onConfigurationChanged(configuration);
            }

        }
    }

    public boolean dispatchContextItemSelected(MenuItem menuitem) {
        int i;
        if(mAdded == null)
            break MISSING_BLOCK_LABEL_73;
        i = 0;
_L3:
        Fragment fragment;
        if(i >= mAdded.size())
            break MISSING_BLOCK_LABEL_73;
        fragment = (Fragment)mAdded.get(i);
        if(fragment == null || fragment.mHidden || !fragment.mUserVisibleHint || !fragment.onContextItemSelected(menuitem)) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        i++;
          goto _L3
        flag = false;
          goto _L4
    }

    public void dispatchCreate() {
        mStateSaved = false;
        moveToState(1, false);
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuinflater) {
        boolean flag = false;
        ArrayList arraylist = null;
        if(mAdded != null) {
            for(int j = 0; j < mAdded.size(); j++) {
                Fragment fragment1 = (Fragment)mAdded.get(j);
                if(fragment1 == null || fragment1.mHidden || !fragment1.mHasMenu || !fragment1.mMenuVisible)
                    continue;
                flag = true;
                fragment1.onCreateOptionsMenu(menu, menuinflater);
                if(arraylist == null)
                    arraylist = new ArrayList();
                arraylist.add(fragment1);
            }

        }
        if(mCreatedMenus != null) {
            for(int i = 0; i < mCreatedMenus.size(); i++) {
                Fragment fragment = (Fragment)mCreatedMenus.get(i);
                if(arraylist == null || !arraylist.contains(fragment))
                    fragment.onDestroyOptionsMenu();
            }

        }
        mCreatedMenus = arraylist;
        return flag;
    }

    public void dispatchDestroy() {
        mDestroyed = true;
        execPendingActions();
        moveToState(0, false);
        mActivity = null;
    }

    public void dispatchLowMemory() {
        if(mAdded != null) {
            for(int i = 0; i < mAdded.size(); i++) {
                Fragment fragment = (Fragment)mAdded.get(i);
                if(fragment != null)
                    fragment.onLowMemory();
            }

        }
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuitem) {
        int i;
        if(mAdded == null)
            break MISSING_BLOCK_LABEL_81;
        i = 0;
_L3:
        Fragment fragment;
        if(i >= mAdded.size())
            break MISSING_BLOCK_LABEL_81;
        fragment = (Fragment)mAdded.get(i);
        if(fragment == null || fragment.mHidden || !fragment.mHasMenu || !fragment.mMenuVisible || !fragment.onOptionsItemSelected(menuitem)) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        i++;
          goto _L3
        flag = false;
          goto _L4
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        if(mAdded != null) {
            for(int i = 0; i < mAdded.size(); i++) {
                Fragment fragment = (Fragment)mAdded.get(i);
                if(fragment != null && !fragment.mHidden && fragment.mHasMenu && fragment.mMenuVisible)
                    fragment.onOptionsMenuClosed(menu);
            }

        }
    }

    public void dispatchPause() {
        moveToState(4, false);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        boolean flag = false;
        if(mAdded != null) {
            for(int i = 0; i < mAdded.size(); i++) {
                Fragment fragment = (Fragment)mAdded.get(i);
                if(fragment != null && !fragment.mHidden && fragment.mHasMenu && fragment.mMenuVisible) {
                    flag = true;
                    fragment.onPrepareOptionsMenu(menu);
                }
            }

        }
        return flag;
    }

    public void dispatchResume() {
        mStateSaved = false;
        moveToState(5, false);
    }

    public void dispatchStart() {
        mStateSaved = false;
        moveToState(4, false);
    }

    public void dispatchStop() {
        moveToState(3, false);
    }

    public void dispatchTrimMemory(int i) {
        if(mAdded != null) {
            for(int j = 0; j < mAdded.size(); j++) {
                Fragment fragment = (Fragment)mAdded.get(j);
                if(fragment != null)
                    fragment.onTrimMemory(i);
            }

        }
    }

    public void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        String s1 = (new StringBuilder()).append(s).append("    ").toString();
        if(mActive != null) {
            int k2 = mActive.size();
            if(k2 > 0) {
                printwriter.print(s);
                printwriter.print("Active Fragments in ");
                printwriter.print(Integer.toHexString(System.identityHashCode(this)));
                printwriter.println(":");
                for(int l2 = 0; l2 < k2; l2++) {
                    Fragment fragment2 = (Fragment)mActive.get(l2);
                    printwriter.print(s);
                    printwriter.print("  #");
                    printwriter.print(l2);
                    printwriter.print(": ");
                    printwriter.println(fragment2);
                    if(fragment2 != null)
                        fragment2.dump(s1, filedescriptor, printwriter, as);
                }

            }
        }
        if(mAdded != null) {
            int i2 = mAdded.size();
            if(i2 > 0) {
                printwriter.print(s);
                printwriter.println("Added Fragments:");
                for(int j2 = 0; j2 < i2; j2++) {
                    Fragment fragment1 = (Fragment)mAdded.get(j2);
                    printwriter.print(s);
                    printwriter.print("  #");
                    printwriter.print(j2);
                    printwriter.print(": ");
                    printwriter.println(fragment1.toString());
                }

            }
        }
        if(mCreatedMenus != null) {
            int k1 = mCreatedMenus.size();
            if(k1 > 0) {
                printwriter.print(s);
                printwriter.println("Fragments Created Menus:");
                for(int l1 = 0; l1 < k1; l1++) {
                    Fragment fragment = (Fragment)mCreatedMenus.get(l1);
                    printwriter.print(s);
                    printwriter.print("  #");
                    printwriter.print(l1);
                    printwriter.print(": ");
                    printwriter.println(fragment.toString());
                }

            }
        }
        if(mBackStack != null) {
            int i1 = mBackStack.size();
            if(i1 > 0) {
                printwriter.print(s);
                printwriter.println("Back Stack:");
                for(int j1 = 0; j1 < i1; j1++) {
                    BackStackRecord backstackrecord1 = (BackStackRecord)mBackStack.get(j1);
                    printwriter.print(s);
                    printwriter.print("  #");
                    printwriter.print(j1);
                    printwriter.print(": ");
                    printwriter.println(backstackrecord1.toString());
                    backstackrecord1.dump(s1, filedescriptor, printwriter, as);
                }

            }
        }
        this;
        JVM INSTR monitorenter ;
        if(mBackStackIndices != null) {
            int k = mBackStackIndices.size();
            if(k > 0) {
                printwriter.print(s);
                printwriter.println("Back Stack Indices:");
                for(int l = 0; l < k; l++) {
                    BackStackRecord backstackrecord = (BackStackRecord)mBackStackIndices.get(l);
                    printwriter.print(s);
                    printwriter.print("  #");
                    printwriter.print(l);
                    printwriter.print(": ");
                    printwriter.println(backstackrecord);
                }

            }
        }
        if(mAvailBackStackIndices != null && mAvailBackStackIndices.size() > 0) {
            printwriter.print(s);
            printwriter.print("mAvailBackStackIndices: ");
            printwriter.println(Arrays.toString(mAvailBackStackIndices.toArray()));
        }
        this;
        JVM INSTR monitorexit ;
        if(mPendingActions != null) {
            int i = mPendingActions.size();
            if(i > 0) {
                printwriter.print(s);
                printwriter.println("Pending Actions:");
                for(int j = 0; j < i; j++) {
                    Runnable runnable = (Runnable)mPendingActions.get(j);
                    printwriter.print(s);
                    printwriter.print("  #");
                    printwriter.print(j);
                    printwriter.print(": ");
                    printwriter.println(runnable);
                }

            }
        }
        break MISSING_BLOCK_LABEL_694;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        printwriter.print(s);
        printwriter.println("FragmentManager misc state:");
        printwriter.print(s);
        printwriter.print("  mCurState=");
        printwriter.print(mCurState);
        printwriter.print(" mStateSaved=");
        printwriter.print(mStateSaved);
        printwriter.print(" mDestroyed=");
        printwriter.println(mDestroyed);
        if(mNeedMenuInvalidate) {
            printwriter.print(s);
            printwriter.print("  mNeedMenuInvalidate=");
            printwriter.println(mNeedMenuInvalidate);
        }
        if(mNoTransactionsBecause != null) {
            printwriter.print(s);
            printwriter.print("  mNoTransactionsBecause=");
            printwriter.println(mNoTransactionsBecause);
        }
        if(mAvailIndices != null && mAvailIndices.size() > 0) {
            printwriter.print(s);
            printwriter.print("  mAvailIndices: ");
            printwriter.println(Arrays.toString(mAvailIndices.toArray()));
        }
        return;
    }

    public void enqueueAction(Runnable runnable, boolean flag) {
        if(!flag)
            checkStateLoss();
        this;
        JVM INSTR monitorenter ;
        if(mActivity == null)
            throw new IllegalStateException("Activity has been destroyed");
        break MISSING_BLOCK_LABEL_33;
        Exception exception;
        exception;
        throw exception;
        if(mPendingActions == null)
            mPendingActions = new ArrayList();
        mPendingActions.add(runnable);
        if(mPendingActions.size() == 1) {
            mActivity.mHandler.removeCallbacks(mExecCommit);
            mActivity.mHandler.post(mExecCommit);
        }
        this;
        JVM INSTR monitorexit ;
    }

    public boolean execPendingActions() {
        if(mExecutingActions)
            throw new IllegalStateException("Recursive entry to executePendingTransactions");
        if(Looper.myLooper() != mActivity.mHandler.getLooper())
            throw new IllegalStateException("Must be called from main thread of process");
        boolean flag = false;
_L2:
        this;
        JVM INSTR monitorenter ;
        if(mPendingActions != null && mPendingActions.size() != 0)
            break MISSING_BLOCK_LABEL_136;
        this;
        JVM INSTR monitorexit ;
        boolean flag1;
        if(!mHavePendingDeferredStart)
            break MISSING_BLOCK_LABEL_275;
        flag1 = false;
        for(int i = 0; i < mActive.size(); i++) {
            Fragment fragment = (Fragment)mActive.get(i);
            if(fragment != null && fragment.mLoaderManager != null)
                flag1 |= fragment.mLoaderManager.hasRunningLoaders();
        }

        break; /* Loop/switch isn't completed */
        int j;
        j = mPendingActions.size();
        if(mTmpActions == null || mTmpActions.length < j)
            mTmpActions = new Runnable[j];
        mPendingActions.toArray(mTmpActions);
        mPendingActions.clear();
        mActivity.mHandler.removeCallbacks(mExecCommit);
        this;
        JVM INSTR monitorexit ;
        mExecutingActions = true;
        for(int k = 0; k < j; k++) {
            mTmpActions[k].run();
            mTmpActions[k] = null;
        }

        break MISSING_BLOCK_LABEL_252;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        mExecutingActions = false;
        flag = true;
        if(true) goto _L2; else goto _L1
_L1:
        if(!flag1) {
            mHavePendingDeferredStart = false;
            startPendingDeferredFragments();
        }
        return flag;
    }

    public boolean executePendingTransactions() {
        return execPendingActions();
    }

    public Fragment findFragmentById(int i) {
        if(mAdded == null) goto _L2; else goto _L1
_L1:
        int k = -1 + mAdded.size();
_L6:
        if(k < 0) goto _L2; else goto _L3
_L3:
        Fragment fragment = (Fragment)mAdded.get(k);
        if(fragment == null || fragment.mFragmentId != i) goto _L5; else goto _L4
_L4:
        return fragment;
_L5:
        k--;
          goto _L6
_L2:
        int j;
        if(mActive == null)
            break MISSING_BLOCK_LABEL_109;
        j = -1 + mActive.size();
_L8:
        if(j < 0)
            break MISSING_BLOCK_LABEL_109;
        fragment = (Fragment)mActive.get(j);
        if(fragment != null && fragment.mFragmentId == i) goto _L4; else goto _L7
_L7:
        j--;
          goto _L8
        fragment = null;
          goto _L4
    }

    public Fragment findFragmentByTag(String s) {
        if(mAdded == null || s == null) goto _L2; else goto _L1
_L1:
        int j = -1 + mAdded.size();
_L6:
        if(j < 0) goto _L2; else goto _L3
_L3:
        Fragment fragment = (Fragment)mAdded.get(j);
        if(fragment == null || !s.equals(fragment.mTag)) goto _L5; else goto _L4
_L4:
        return fragment;
_L5:
        j--;
          goto _L6
_L2:
        int i;
        if(mActive == null || s == null)
            break MISSING_BLOCK_LABEL_123;
        i = -1 + mActive.size();
_L8:
        if(i < 0)
            break MISSING_BLOCK_LABEL_123;
        fragment = (Fragment)mActive.get(i);
        if(fragment != null && s.equals(fragment.mTag)) goto _L4; else goto _L7
_L7:
        i--;
          goto _L8
        fragment = null;
          goto _L4
    }

    public Fragment findFragmentByWho(String s) {
        int i;
        if(mActive == null || s == null)
            break MISSING_BLOCK_LABEL_61;
        i = -1 + mActive.size();
_L3:
        Fragment fragment;
        if(i < 0)
            break MISSING_BLOCK_LABEL_61;
        fragment = (Fragment)mActive.get(i);
        if(fragment == null || !s.equals(fragment.mWho)) goto _L2; else goto _L1
_L1:
        return fragment;
_L2:
        i--;
          goto _L3
        fragment = null;
          goto _L1
    }

    public void freeBackStackIndex(int i) {
        this;
        JVM INSTR monitorenter ;
        mBackStackIndices.set(i, null);
        if(mAvailBackStackIndices == null)
            mAvailBackStackIndices = new ArrayList();
        if(DEBUG)
            Log.v("FragmentManager", (new StringBuilder()).append("Freeing back stack index ").append(i).toString());
        mAvailBackStackIndices.add(Integer.valueOf(i));
        return;
    }

    public FragmentManager.BackStackEntry getBackStackEntryAt(int i) {
        return (FragmentManager.BackStackEntry)mBackStack.get(i);
    }

    public int getBackStackEntryCount() {
        int i;
        if(mBackStack != null)
            i = mBackStack.size();
        else
            i = 0;
        return i;
    }

    public Fragment getFragment(Bundle bundle, String s) {
        int i = bundle.getInt(s, -1);
        Fragment fragment;
        if(i == -1) {
            fragment = null;
        } else {
            if(i >= mActive.size())
                throw new IllegalStateException((new StringBuilder()).append("Fragement no longer exists for key ").append(s).append(": index ").append(i).toString());
            fragment = (Fragment)mActive.get(i);
            if(fragment == null)
                throw new IllegalStateException((new StringBuilder()).append("Fragement no longer exists for key ").append(s).append(": index ").append(i).toString());
        }
        return fragment;
    }

    public void hideFragment(final Fragment finalFragment, int i, int j) {
        if(DEBUG)
            Log.v("FragmentManager", (new StringBuilder()).append("hide: ").append(finalFragment).toString());
        if(!finalFragment.mHidden) {
            finalFragment.mHidden = true;
            if(finalFragment.mView != null) {
                Animator animator = loadAnimator(finalFragment, i, true, j);
                if(animator != null) {
                    animator.setTarget(finalFragment.mView);
                    animator.addListener(new AnimatorListenerAdapter() {

                        public void onAnimationEnd(Animator animator1) {
                            if(finalFragment.mView != null)
                                finalFragment.mView.setVisibility(8);
                        }

                        final FragmentManagerImpl this$0;
                        final Fragment val$finalFragment;

             {
                this$0 = FragmentManagerImpl.this;
                finalFragment = fragment;
                super();
            }
                    });
                    animator.start();
                } else {
                    finalFragment.mView.setVisibility(8);
                }
            }
            if(finalFragment.mAdded && finalFragment.mHasMenu && finalFragment.mMenuVisible)
                mNeedMenuInvalidate = true;
            finalFragment.onHiddenChanged(true);
        }
    }

    public void invalidateOptionsMenu() {
        if(mActivity != null && mCurState == 5)
            mActivity.invalidateOptionsMenu();
        else
            mNeedMenuInvalidate = true;
    }

    Animator loadAnimator(Fragment fragment, int i, boolean flag, int j) {
        Animator animator = fragment.onCreateAnimator(i, flag, fragment.mNextAnim);
        if(animator == null) goto _L2; else goto _L1
_L1:
        return animator;
_L2:
        if(fragment.mNextAnim != 0) {
            Animator animator1 = AnimatorInflater.loadAnimator(mActivity, fragment.mNextAnim);
            if(animator1 != null) {
                animator = animator1;
                continue; /* Loop/switch isn't completed */
            }
        }
        if(i == 0) {
            animator = null;
        } else {
            int k = transitToStyleIndex(i, flag);
            if(k < 0) {
                animator = null;
            } else {
                if(j == 0 && mActivity.getWindow() != null)
                    j = mActivity.getWindow().getAttributes().windowAnimations;
                if(j == 0) {
                    animator = null;
                } else {
                    TypedArray typedarray = mActivity.obtainStyledAttributes(j, com.android.internal.R.styleable.FragmentAnimation);
                    int l = typedarray.getResourceId(k, 0);
                    typedarray.recycle();
                    if(l == 0)
                        animator = null;
                    else
                        animator = AnimatorInflater.loadAnimator(mActivity, l);
                }
            }
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    void makeActive(Fragment fragment) {
        if(fragment.mIndex < 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(mAvailIndices == null || mAvailIndices.size() <= 0) {
            if(mActive == null)
                mActive = new ArrayList();
            fragment.setIndex(mActive.size());
            mActive.add(fragment);
        } else {
            fragment.setIndex(((Integer)mAvailIndices.remove(-1 + mAvailIndices.size())).intValue());
            mActive.set(fragment.mIndex, fragment);
        }
        if(DEBUG)
            Log.v("FragmentManager", (new StringBuilder()).append("Allocated fragment index ").append(fragment).toString());
        if(true) goto _L1; else goto _L3
_L3:
    }

    void makeInactive(Fragment fragment) {
        if(fragment.mIndex >= 0) {
            if(DEBUG)
                Log.v("FragmentManager", (new StringBuilder()).append("Freeing fragment index ").append(fragment).toString());
            mActive.set(fragment.mIndex, null);
            if(mAvailIndices == null)
                mAvailIndices = new ArrayList();
            mAvailIndices.add(Integer.valueOf(fragment.mIndex));
            mActivity.invalidateFragmentIndex(fragment.mIndex);
            fragment.initState();
        }
    }

    void moveToState(int i, int j, int k, boolean flag) {
        if(mActivity == null && i != 0)
            throw new IllegalStateException("No activity");
        if(flag || mCurState != i) goto _L2; else goto _L1
_L1:
        return;
_L2:
        mCurState = i;
        if(mActive != null) {
            boolean flag1 = false;
            for(int l = 0; l < mActive.size(); l++) {
                Fragment fragment = (Fragment)mActive.get(l);
                if(fragment == null)
                    continue;
                moveToState(fragment, i, j, k, false);
                if(fragment.mLoaderManager != null)
                    flag1 |= fragment.mLoaderManager.hasRunningLoaders();
            }

            if(!flag1)
                startPendingDeferredFragments();
            if(mNeedMenuInvalidate && mActivity != null && mCurState == 5) {
                mActivity.invalidateOptionsMenu();
                mNeedMenuInvalidate = false;
            }
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    void moveToState(int i, boolean flag) {
        moveToState(i, 0, 0, flag);
    }

    void moveToState(Fragment fragment) {
        moveToState(fragment, mCurState, 0, 0, false);
    }

    void moveToState(final Fragment fragment, int i, int j, int k, boolean flag) {
        if(!fragment.mAdded && i > 1)
            i = 1;
        if(fragment.mRemoving && i > fragment.mState)
            i = fragment.mState;
        if(fragment.mDeferStart && fragment.mState < 4 && i > 3)
            i = 3;
        if(fragment.mState >= i) goto _L2; else goto _L1
_L1:
        if(!fragment.mFromLayout || fragment.mInLayout) goto _L4; else goto _L3
_L3:
        return;
_L4:
        if(fragment.mAnimatingAway != null) {
            fragment.mAnimatingAway = null;
            moveToState(fragment, fragment.mStateAfterAnimating, 0, 0, true);
        }
        fragment.mState;
        JVM INSTR tableswitch 0 4: default 140
    //                   0 148
    //                   1 486
    //                   2 797
    //                   3 797
    //                   4 884;
           goto _L5 _L6 _L7 _L8 _L8 _L9
_L5:
        fragment.mState = i;
          goto _L3
_L6:
        if(DEBUG)
            Log.v("FragmentManager", (new StringBuilder()).append("moveto CREATED: ").append(fragment).toString());
        if(fragment.mSavedFragmentState != null) {
            fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
            fragment.mTarget = getFragment(fragment.mSavedFragmentState, "android:target_state");
            if(fragment.mTarget != null)
                fragment.mTargetRequestCode = fragment.mSavedFragmentState.getInt("android:target_req_state", 0);
            fragment.mUserVisibleHint = fragment.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
            if(!fragment.mUserVisibleHint) {
                fragment.mDeferStart = true;
                if(i > 3)
                    i = 3;
            }
        }
        fragment.mActivity = mActivity;
        fragment.mFragmentManager = mActivity.mFragments;
        fragment.mCalled = false;
        fragment.onAttach(mActivity);
        if(!fragment.mCalled)
            throw new SuperNotCalledException((new StringBuilder()).append("Fragment ").append(fragment).append(" did not call through to super.onAttach()").toString());
        mActivity.onAttachFragment(fragment);
        if(!fragment.mRetaining) {
            fragment.mCalled = false;
            fragment.onCreate(fragment.mSavedFragmentState);
            if(!fragment.mCalled)
                throw new SuperNotCalledException((new StringBuilder()).append("Fragment ").append(fragment).append(" did not call through to super.onCreate()").toString());
        }
        fragment.mRetaining = false;
        if(fragment.mFromLayout) {
            fragment.mView = fragment.onCreateView(fragment.getLayoutInflater(fragment.mSavedFragmentState), null, fragment.mSavedFragmentState);
            if(fragment.mView != null) {
                fragment.mView.setSaveFromParentEnabled(false);
                if(fragment.mHidden)
                    fragment.mView.setVisibility(8);
                fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
            }
        }
_L7:
        if(i > 1) {
            if(DEBUG)
                Log.v("FragmentManager", (new StringBuilder()).append("moveto ACTIVITY_CREATED: ").append(fragment).toString());
            if(!fragment.mFromLayout) {
                ViewGroup viewgroup = null;
                if(fragment.mContainerId != 0) {
                    viewgroup = (ViewGroup)mActivity.findViewById(fragment.mContainerId);
                    if(viewgroup == null && !fragment.mRestored)
                        throw new IllegalArgumentException((new StringBuilder()).append("No view found for id 0x").append(Integer.toHexString(fragment.mContainerId)).append(" for fragment ").append(fragment).toString());
                }
                fragment.mContainer = viewgroup;
                fragment.mView = fragment.onCreateView(fragment.getLayoutInflater(fragment.mSavedFragmentState), viewgroup, fragment.mSavedFragmentState);
                if(fragment.mView != null) {
                    fragment.mView.setSaveFromParentEnabled(false);
                    if(viewgroup != null) {
                        Animator animator2 = loadAnimator(fragment, j, true, k);
                        if(animator2 != null) {
                            animator2.setTarget(fragment.mView);
                            animator2.start();
                        }
                        viewgroup.addView(fragment.mView);
                    }
                    if(fragment.mHidden)
                        fragment.mView.setVisibility(8);
                    fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
                }
            }
            fragment.mCalled = false;
            fragment.onActivityCreated(fragment.mSavedFragmentState);
            if(!fragment.mCalled)
                throw new SuperNotCalledException((new StringBuilder()).append("Fragment ").append(fragment).append(" did not call through to super.onActivityCreated()").toString());
            if(fragment.mView != null)
                fragment.restoreViewState();
            fragment.mSavedFragmentState = null;
        }
_L8:
        if(i > 3) {
            if(DEBUG)
                Log.v("FragmentManager", (new StringBuilder()).append("moveto STARTED: ").append(fragment).toString());
            fragment.mCalled = false;
            fragment.performStart();
            if(!fragment.mCalled)
                throw new SuperNotCalledException((new StringBuilder()).append("Fragment ").append(fragment).append(" did not call through to super.onStart()").toString());
        }
_L9:
        if(i <= 4) goto _L5; else goto _L10
_L10:
        if(DEBUG)
            Log.v("FragmentManager", (new StringBuilder()).append("moveto RESUMED: ").append(fragment).toString());
        fragment.mCalled = false;
        fragment.mResumed = true;
        fragment.onResume();
        if(!fragment.mCalled)
            throw new SuperNotCalledException((new StringBuilder()).append("Fragment ").append(fragment).append(" did not call through to super.onResume()").toString());
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
          goto _L5
_L2:
        if(fragment.mState <= i) goto _L5; else goto _L11
_L11:
        fragment.mState;
        JVM INSTR tableswitch 1 5: default 1036
    //                   1 1039
    //                   2 1270
    //                   3 1270
    //                   4 1183
    //                   5 1091;
           goto _L5 _L12 _L13 _L13 _L14 _L15
_L12:
        if(i < 1) {
            if(mDestroyed && fragment.mAnimatingAway != null) {
                Animator animator = fragment.mAnimatingAway;
                fragment.mAnimatingAway = null;
                animator.cancel();
            }
            Animator animator1;
            final ViewGroup container;
            final View view;
            if(fragment.mAnimatingAway != null) {
                fragment.mStateAfterAnimating = i;
                i = 1;
            } else {
                if(DEBUG)
                    Log.v("FragmentManager", (new StringBuilder()).append("movefrom CREATED: ").append(fragment).toString());
                if(!fragment.mRetaining) {
                    fragment.mCalled = false;
                    fragment.onDestroy();
                    if(!fragment.mCalled)
                        throw new SuperNotCalledException((new StringBuilder()).append("Fragment ").append(fragment).append(" did not call through to super.onDestroy()").toString());
                }
                fragment.mCalled = false;
                fragment.onDetach();
                if(!fragment.mCalled)
                    throw new SuperNotCalledException((new StringBuilder()).append("Fragment ").append(fragment).append(" did not call through to super.onDetach()").toString());
                if(!flag)
                    if(!fragment.mRetaining) {
                        makeInactive(fragment);
                    } else {
                        fragment.mActivity = null;
                        fragment.mFragmentManager = null;
                    }
            }
        }
          goto _L5
_L15:
        if(i < 5) {
            if(DEBUG)
                Log.v("FragmentManager", (new StringBuilder()).append("movefrom RESUMED: ").append(fragment).toString());
            fragment.mCalled = false;
            fragment.onPause();
            if(!fragment.mCalled)
                throw new SuperNotCalledException((new StringBuilder()).append("Fragment ").append(fragment).append(" did not call through to super.onPause()").toString());
            fragment.mResumed = false;
        }
_L14:
        if(i < 4) {
            if(DEBUG)
                Log.v("FragmentManager", (new StringBuilder()).append("movefrom STARTED: ").append(fragment).toString());
            fragment.mCalled = false;
            fragment.performStop();
            if(!fragment.mCalled)
                throw new SuperNotCalledException((new StringBuilder()).append("Fragment ").append(fragment).append(" did not call through to super.onStop()").toString());
        }
_L13:
        if(i >= 2) goto _L12; else goto _L16
_L16:
        if(DEBUG)
            Log.v("FragmentManager", (new StringBuilder()).append("movefrom ACTIVITY_CREATED: ").append(fragment).toString());
        if(fragment.mView != null && !mActivity.isFinishing() && fragment.mSavedViewState == null)
            saveFragmentViewState(fragment);
        fragment.mCalled = false;
        fragment.performDestroyView();
        if(!fragment.mCalled)
            throw new SuperNotCalledException((new StringBuilder()).append("Fragment ").append(fragment).append(" did not call through to super.onDestroyView()").toString());
        if(fragment.mView != null && fragment.mContainer != null) {
            animator1 = null;
            if(mCurState > 0 && !mDestroyed)
                animator1 = loadAnimator(fragment, j, false, k);
            if(animator1 != null) {
                container = fragment.mContainer;
                view = fragment.mView;
                container.startViewTransition(view);
                fragment.mAnimatingAway = animator1;
                fragment.mStateAfterAnimating = i;
                animator1.addListener(new AnimatorListenerAdapter() {

                    public void onAnimationEnd(Animator animator3) {
                        container.endViewTransition(view);
                        if(fragment.mAnimatingAway != null) {
                            fragment.mAnimatingAway = null;
                            moveToState(fragment, fragment.mStateAfterAnimating, 0, 0, false);
                        }
                    }

                    final FragmentManagerImpl this$0;
                    final ViewGroup val$container;
                    final Fragment val$fragment;
                    final View val$view;

             {
                this$0 = FragmentManagerImpl.this;
                container = viewgroup;
                view = view1;
                fragment = fragment1;
                super();
            }
                });
                animator1.setTarget(fragment.mView);
                animator1.start();
            }
            fragment.mContainer.removeView(fragment.mView);
        }
        fragment.mContainer = null;
        fragment.mView = null;
          goto _L12
    }

    public void noteStateNotSaved() {
        mStateSaved = false;
    }

    public void performPendingDeferredStart(Fragment fragment) {
        if(fragment.mDeferStart)
            if(mExecutingActions) {
                mHavePendingDeferredStart = true;
            } else {
                fragment.mDeferStart = false;
                moveToState(fragment, mCurState, 0, 0, false);
            }
    }

    public void popBackStack() {
        enqueueAction(new Runnable() {

            public void run() {
                popBackStackState(mActivity.mHandler, null, -1, 0);
            }

            final FragmentManagerImpl this$0;

             {
                this$0 = FragmentManagerImpl.this;
                super();
            }
        }, false);
    }

    public void popBackStack(final int id, final int flags) {
        if(id < 0) {
            throw new IllegalArgumentException((new StringBuilder()).append("Bad id: ").append(id).toString());
        } else {
            enqueueAction(new Runnable() {

                public void run() {
                    popBackStackState(mActivity.mHandler, null, id, flags);
                }

                final FragmentManagerImpl this$0;
                final int val$flags;
                final int val$id;

             {
                this$0 = FragmentManagerImpl.this;
                id = i;
                flags = j;
                super();
            }
            }, false);
            return;
        }
    }

    public void popBackStack(final String name, final int flags) {
        enqueueAction(new Runnable() {

            public void run() {
                popBackStackState(mActivity.mHandler, name, -1, flags);
            }

            final FragmentManagerImpl this$0;
            final int val$flags;
            final String val$name;

             {
                this$0 = FragmentManagerImpl.this;
                name = s;
                flags = i;
                super();
            }
        }, false);
    }

    public boolean popBackStackImmediate() {
        checkStateLoss();
        executePendingTransactions();
        return popBackStackState(mActivity.mHandler, null, -1, 0);
    }

    public boolean popBackStackImmediate(int i, int j) {
        checkStateLoss();
        executePendingTransactions();
        if(i < 0)
            throw new IllegalArgumentException((new StringBuilder()).append("Bad id: ").append(i).toString());
        else
            return popBackStackState(mActivity.mHandler, null, i, j);
    }

    public boolean popBackStackImmediate(String s, int i) {
        checkStateLoss();
        executePendingTransactions();
        return popBackStackState(mActivity.mHandler, s, -1, i);
    }

    boolean popBackStackState(Handler handler, String s, int i, int j) {
        boolean flag = false;
        if(mBackStack != null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(s != null || i >= 0 || (j & 1) != 0)
            break; /* Loop/switch isn't completed */
        int k1 = -1 + mBackStack.size();
        if(k1 < 0)
            continue; /* Loop/switch isn't completed */
        ((BackStackRecord)mBackStack.remove(k1)).popFromBackStack(true);
        reportBackStackChanged();
_L6:
        flag = true;
        if(true) goto _L1; else goto _L3
_L3:
        int k;
        k = -1;
        if(s == null && i < 0)
            continue; /* Loop/switch isn't completed */
        k = -1 + mBackStack.size();
        break MISSING_BLOCK_LABEL_95;
        if(k < 0) goto _L1; else goto _L4
_L4:
        if((j & 1) == 0)
            continue; /* Loop/switch isn't completed */
        k--;
        do {
            if(k < 0)
                continue; /* Loop/switch isn't completed */
            BackStackRecord backstackrecord1 = (BackStackRecord)mBackStack.get(k);
            if((s == null || !s.equals(backstackrecord1.getName())) && (i < 0 || i != backstackrecord1.mIndex))
                continue; /* Loop/switch isn't completed */
            k--;
        } while(true);
        do {
            if(k < 0)
                continue; /* Loop/switch isn't completed */
            BackStackRecord backstackrecord2 = (BackStackRecord)mBackStack.get(k);
            if(s != null && s.equals(backstackrecord2.getName()) || i >= 0 && i == backstackrecord2.mIndex)
                continue; /* Loop/switch isn't completed */
            k--;
        } while(true);
        if(k == -1 + mBackStack.size()) goto _L1; else goto _L5
_L5:
        ArrayList arraylist = new ArrayList();
        for(int l = -1 + mBackStack.size(); l > k; l--)
            arraylist.add(mBackStack.remove(l));

        int i1 = -1 + arraylist.size();
        int j1 = 0;
        while(j1 <= i1)  {
            if(DEBUG)
                Log.v("FragmentManager", (new StringBuilder()).append("Popping back stack state: ").append(arraylist.get(j1)).toString());
            BackStackRecord backstackrecord = (BackStackRecord)arraylist.get(j1);
            boolean flag1;
            if(j1 == i1)
                flag1 = true;
            else
                flag1 = false;
            backstackrecord.popFromBackStack(flag1);
            j1++;
        }
        reportBackStackChanged();
          goto _L6
    }

    public void putFragment(Bundle bundle, String s, Fragment fragment) {
        if(fragment.mIndex < 0) {
            throw new IllegalStateException((new StringBuilder()).append("Fragment ").append(fragment).append(" is not currently in the FragmentManager").toString());
        } else {
            bundle.putInt(s, fragment.mIndex);
            return;
        }
    }

    public void removeFragment(Fragment fragment, int i, int j) {
        if(DEBUG)
            Log.v("FragmentManager", (new StringBuilder()).append("remove: ").append(fragment).append(" nesting=").append(fragment.mBackStackNesting).toString());
        boolean flag;
        if(!fragment.isInBackStack())
            flag = true;
        else
            flag = false;
        if(!fragment.mDetached || flag) {
            if(mAdded != null)
                mAdded.remove(fragment);
            if(fragment.mHasMenu && fragment.mMenuVisible)
                mNeedMenuInvalidate = true;
            fragment.mAdded = false;
            fragment.mRemoving = true;
            int k;
            if(flag)
                k = 0;
            else
                k = 1;
            moveToState(fragment, k, i, j, false);
        }
    }

    public void removeOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener onbackstackchangedlistener) {
        if(mBackStackChangeListeners != null)
            mBackStackChangeListeners.remove(onbackstackchangedlistener);
    }

    void reportBackStackChanged() {
        if(mBackStackChangeListeners != null) {
            for(int i = 0; i < mBackStackChangeListeners.size(); i++)
                ((FragmentManager.OnBackStackChangedListener)mBackStackChangeListeners.get(i)).onBackStackChanged();

        }
    }

    void restoreAllState(Parcelable parcelable, ArrayList arraylist) {
        if(parcelable != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        FragmentManagerState fragmentmanagerstate = (FragmentManagerState)parcelable;
        if(fragmentmanagerstate.mActive != null) {
            if(arraylist != null) {
                for(int i1 = 0; i1 < arraylist.size(); i1++) {
                    Fragment fragment3 = (Fragment)arraylist.get(i1);
                    if(DEBUG)
                        Log.v("FragmentManager", (new StringBuilder()).append("restoreAllState: re-attaching retained ").append(fragment3).toString());
                    FragmentState fragmentstate1 = fragmentmanagerstate.mActive[fragment3.mIndex];
                    fragmentstate1.mInstance = fragment3;
                    fragment3.mSavedViewState = null;
                    fragment3.mBackStackNesting = 0;
                    fragment3.mInLayout = false;
                    fragment3.mAdded = false;
                    fragment3.mTarget = null;
                    if(fragmentstate1.mSavedFragmentState != null) {
                        fragmentstate1.mSavedFragmentState.setClassLoader(mActivity.getClassLoader());
                        fragment3.mSavedViewState = fragmentstate1.mSavedFragmentState.getSparseParcelableArray("android:view_state");
                    }
                }

            }
            mActive = new ArrayList(fragmentmanagerstate.mActive.length);
            if(mAvailIndices != null)
                mAvailIndices.clear();
            int i = 0;
            while(i < fragmentmanagerstate.mActive.length)  {
                FragmentState fragmentstate = fragmentmanagerstate.mActive[i];
                if(fragmentstate != null) {
                    Fragment fragment2 = fragmentstate.instantiate(mActivity);
                    if(DEBUG)
                        Log.v("FragmentManager", (new StringBuilder()).append("restoreAllState: adding #").append(i).append(": ").append(fragment2).toString());
                    mActive.add(fragment2);
                    fragmentstate.mInstance = null;
                } else {
                    if(DEBUG)
                        Log.v("FragmentManager", (new StringBuilder()).append("restoreAllState: adding #").append(i).append(": (null)").toString());
                    mActive.add(null);
                    if(mAvailIndices == null)
                        mAvailIndices = new ArrayList();
                    if(DEBUG)
                        Log.v("FragmentManager", (new StringBuilder()).append("restoreAllState: adding avail #").append(i).toString());
                    mAvailIndices.add(Integer.valueOf(i));
                }
                i++;
            }
            if(arraylist != null) {
                int l = 0;
                while(l < arraylist.size())  {
                    Fragment fragment1 = (Fragment)arraylist.get(l);
                    if(fragment1.mTargetIndex >= 0)
                        if(fragment1.mTargetIndex < mActive.size()) {
                            fragment1.mTarget = (Fragment)mActive.get(fragment1.mTargetIndex);
                        } else {
                            Log.w("FragmentManager", (new StringBuilder()).append("Re-attaching retained fragment ").append(fragment1).append(" target no longer exists: ").append(fragment1.mTargetIndex).toString());
                            fragment1.mTarget = null;
                        }
                    l++;
                }
            }
            if(fragmentmanagerstate.mAdded != null) {
                mAdded = new ArrayList(fragmentmanagerstate.mAdded.length);
                for(int k = 0; k < fragmentmanagerstate.mAdded.length; k++) {
                    Fragment fragment = (Fragment)mActive.get(fragmentmanagerstate.mAdded[k]);
                    if(fragment == null)
                        throw new IllegalStateException((new StringBuilder()).append("No instantiated fragment for index #").append(fragmentmanagerstate.mAdded[k]).toString());
                    fragment.mAdded = true;
                    if(DEBUG)
                        Log.v("FragmentManager", (new StringBuilder()).append("restoreAllState: making added #").append(k).append(": ").append(fragment).toString());
                    mAdded.add(fragment);
                }

            } else {
                mAdded = null;
            }
            if(fragmentmanagerstate.mBackStack != null) {
                mBackStack = new ArrayList(fragmentmanagerstate.mBackStack.length);
                int j = 0;
                while(j < fragmentmanagerstate.mBackStack.length)  {
                    BackStackRecord backstackrecord = fragmentmanagerstate.mBackStack[j].instantiate(this);
                    if(DEBUG)
                        Log.v("FragmentManager", (new StringBuilder()).append("restoreAllState: adding bse #").append(j).append(" (index ").append(backstackrecord.mIndex).append("): ").append(backstackrecord).toString());
                    mBackStack.add(backstackrecord);
                    if(backstackrecord.mIndex >= 0)
                        setBackStackIndex(backstackrecord.mIndex, backstackrecord);
                    j++;
                }
            } else {
                mBackStack = null;
            }
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    ArrayList retainNonConfig() {
        ArrayList arraylist = null;
        if(mActive != null) {
            int i = 0;
            while(i < mActive.size())  {
                Fragment fragment = (Fragment)mActive.get(i);
                if(fragment == null || !fragment.mRetainInstance)
                    continue;
                if(arraylist == null)
                    arraylist = new ArrayList();
                arraylist.add(fragment);
                fragment.mRetaining = true;
                int j;
                if(fragment.mTarget != null)
                    j = fragment.mTarget.mIndex;
                else
                    j = -1;
                fragment.mTargetIndex = j;
                if(DEBUG)
                    Log.v("FragmentManager", (new StringBuilder()).append("retainNonConfig: keeping retained ").append(fragment).toString());
                i++;
            }
        }
        return arraylist;
    }

    Parcelable saveAllState() {
        execPendingActions();
        mStateSaved = true;
        Object obj;
        if(mActive == null || mActive.size() <= 0) {
            obj = null;
        } else {
            int i = mActive.size();
            FragmentState afragmentstate[] = new FragmentState[i];
            boolean flag = false;
            int j = 0;
            while(j < i)  {
                Fragment fragment = (Fragment)mActive.get(j);
                if(fragment == null)
                    continue;
                if(fragment.mIndex < 0) {
                    String s2 = (new StringBuilder()).append("Failure saving state: active ").append(fragment).append(" has cleared index: ").append(fragment.mIndex).toString();
                    Slog.e("FragmentManager", s2);
                    dump("  ", null, new PrintWriter(new LogWriter(6, "FragmentManager", 3)), new String[0]);
                    throw new IllegalStateException(s2);
                }
                flag = true;
                FragmentState fragmentstate = new FragmentState(fragment);
                afragmentstate[j] = fragmentstate;
                if(fragment.mState > 0 && fragmentstate.mSavedFragmentState == null) {
                    fragmentstate.mSavedFragmentState = saveFragmentBasicState(fragment);
                    if(fragment.mTarget != null) {
                        if(fragment.mTarget.mIndex < 0) {
                            String s1 = (new StringBuilder()).append("Failure saving state: ").append(fragment).append(" has target not in fragment manager: ").append(fragment.mTarget).toString();
                            Slog.e("FragmentManager", s1);
                            dump("  ", null, new PrintWriter(new LogWriter(6, "FragmentManager", 3)), new String[0]);
                            throw new IllegalStateException(s1);
                        }
                        if(fragmentstate.mSavedFragmentState == null)
                            fragmentstate.mSavedFragmentState = new Bundle();
                        putFragment(fragmentstate.mSavedFragmentState, "android:target_state", fragment.mTarget);
                        if(fragment.mTargetRequestCode != 0)
                            fragmentstate.mSavedFragmentState.putInt("android:target_req_state", fragment.mTargetRequestCode);
                    }
                } else {
                    fragmentstate.mSavedFragmentState = fragment.mSavedFragmentState;
                }
                if(DEBUG)
                    Log.v("FragmentManager", (new StringBuilder()).append("Saved state of ").append(fragment).append(": ").append(fragmentstate.mSavedFragmentState).toString());
                j++;
            }
            if(!flag) {
                if(DEBUG)
                    Log.v("FragmentManager", "saveAllState: no fragments!");
                obj = null;
            } else {
                int ai[] = null;
                BackStackState abackstackstate[] = null;
                if(mAdded != null) {
                    int i1 = mAdded.size();
                    if(i1 > 0) {
                        ai = new int[i1];
                        for(int j1 = 0; j1 < i1; j1++) {
                            ai[j1] = ((Fragment)mAdded.get(j1)).mIndex;
                            if(ai[j1] < 0) {
                                String s = (new StringBuilder()).append("Failure saving state: active ").append(mAdded.get(j1)).append(" has cleared index: ").append(ai[j1]).toString();
                                Slog.e("FragmentManager", s);
                                dump("  ", null, new PrintWriter(new LogWriter(6, "FragmentManager", 3)), new String[0]);
                                throw new IllegalStateException(s);
                            }
                            if(DEBUG)
                                Log.v("FragmentManager", (new StringBuilder()).append("saveAllState: adding fragment #").append(j1).append(": ").append(mAdded.get(j1)).toString());
                        }

                    }
                }
                if(mBackStack != null) {
                    int k = mBackStack.size();
                    if(k > 0) {
                        abackstackstate = new BackStackState[k];
                        for(int l = 0; l < k; l++) {
                            abackstackstate[l] = new BackStackState(this, (BackStackRecord)mBackStack.get(l));
                            if(DEBUG)
                                Log.v("FragmentManager", (new StringBuilder()).append("saveAllState: adding back stack #").append(l).append(": ").append(mBackStack.get(l)).toString());
                        }

                    }
                }
                obj = new FragmentManagerState();
                obj.mActive = afragmentstate;
                obj.mAdded = ai;
                obj.mBackStack = abackstackstate;
            }
        }
        return ((Parcelable) (obj));
    }

    Bundle saveFragmentBasicState(Fragment fragment) {
        Bundle bundle = null;
        if(mStateBundle == null)
            mStateBundle = new Bundle();
        fragment.onSaveInstanceState(mStateBundle);
        if(!mStateBundle.isEmpty()) {
            bundle = mStateBundle;
            mStateBundle = null;
        }
        if(fragment.mView != null)
            saveFragmentViewState(fragment);
        if(fragment.mSavedViewState != null) {
            if(bundle == null)
                bundle = new Bundle();
            bundle.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
        }
        if(!fragment.mUserVisibleHint) {
            if(bundle == null)
                bundle = new Bundle();
            bundle.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
        }
        return bundle;
    }

    public Fragment.SavedState saveFragmentInstanceState(Fragment fragment) {
        Fragment.SavedState savedstate = null;
        if(fragment.mIndex < 0)
            throw new IllegalStateException((new StringBuilder()).append("Fragment ").append(fragment).append(" is not currently in the FragmentManager").toString());
        if(fragment.mState > 0) {
            Bundle bundle = saveFragmentBasicState(fragment);
            if(bundle != null)
                savedstate = new Fragment.SavedState(bundle);
        }
        return savedstate;
    }

    void saveFragmentViewState(Fragment fragment) {
        if(fragment.mView != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(mStateArray == null)
            mStateArray = new SparseArray();
        else
            mStateArray.clear();
        fragment.mView.saveHierarchyState(mStateArray);
        if(mStateArray.size() > 0) {
            fragment.mSavedViewState = mStateArray;
            mStateArray = null;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void setBackStackIndex(int i, BackStackRecord backstackrecord) {
        this;
        JVM INSTR monitorenter ;
        if(mBackStackIndices == null)
            mBackStackIndices = new ArrayList();
        int j = mBackStackIndices.size();
        if(i < j) {
            if(DEBUG)
                Log.v("FragmentManager", (new StringBuilder()).append("Setting back stack index ").append(i).append(" to ").append(backstackrecord).toString());
            mBackStackIndices.set(i, backstackrecord);
        } else {
            for(; j < i; j++) {
                mBackStackIndices.add(null);
                if(mAvailBackStackIndices == null)
                    mAvailBackStackIndices = new ArrayList();
                if(DEBUG)
                    Log.v("FragmentManager", (new StringBuilder()).append("Adding available back stack index ").append(j).toString());
                mAvailBackStackIndices.add(Integer.valueOf(j));
            }

            if(DEBUG)
                Log.v("FragmentManager", (new StringBuilder()).append("Adding back stack index ").append(i).append(" with ").append(backstackrecord).toString());
            mBackStackIndices.add(backstackrecord);
        }
        return;
    }

    public void showFragment(Fragment fragment, int i, int j) {
        if(DEBUG)
            Log.v("FragmentManager", (new StringBuilder()).append("show: ").append(fragment).toString());
        if(fragment.mHidden) {
            fragment.mHidden = false;
            if(fragment.mView != null) {
                Animator animator = loadAnimator(fragment, i, true, j);
                if(animator != null) {
                    animator.setTarget(fragment.mView);
                    animator.start();
                }
                fragment.mView.setVisibility(0);
            }
            if(fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible)
                mNeedMenuInvalidate = true;
            fragment.onHiddenChanged(false);
        }
    }

    void startPendingDeferredFragments() {
        if(mActive != null) {
            int i = 0;
            while(i < mActive.size())  {
                Fragment fragment = (Fragment)mActive.get(i);
                if(fragment != null)
                    performPendingDeferredStart(fragment);
                i++;
            }
        }
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append("FragmentManager{");
        stringbuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringbuilder.append(" in ");
        DebugUtils.buildShortClassTag(mActivity, stringbuilder);
        stringbuilder.append("}}");
        return stringbuilder.toString();
    }

    static boolean DEBUG = false;
    static final String TAG = "FragmentManager";
    static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    static final String TARGET_STATE_TAG = "android:target_state";
    static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
    static final String VIEW_STATE_TAG = "android:view_state";
    ArrayList mActive;
    Activity mActivity;
    ArrayList mAdded;
    ArrayList mAvailBackStackIndices;
    ArrayList mAvailIndices;
    ArrayList mBackStack;
    ArrayList mBackStackChangeListeners;
    ArrayList mBackStackIndices;
    ArrayList mCreatedMenus;
    int mCurState;
    boolean mDestroyed;
    Runnable mExecCommit;
    boolean mExecutingActions;
    boolean mHavePendingDeferredStart;
    boolean mNeedMenuInvalidate;
    String mNoTransactionsBecause;
    ArrayList mPendingActions;
    SparseArray mStateArray;
    Bundle mStateBundle;
    boolean mStateSaved;
    Runnable mTmpActions[];

    static  {
        DEBUG = false;
    }
}

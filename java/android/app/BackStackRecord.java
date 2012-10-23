// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

// Referenced classes of package android.app:
//            FragmentTransaction, Fragment, FragmentManagerImpl, Activity

final class BackStackRecord extends FragmentTransaction
    implements FragmentManager.BackStackEntry, Runnable {
    static final class Op {

        int cmd;
        int enterAnim;
        int exitAnim;
        Fragment fragment;
        Op next;
        int popEnterAnim;
        int popExitAnim;
        Op prev;
        ArrayList removed;

        Op() {
        }
    }


    public BackStackRecord(FragmentManagerImpl fragmentmanagerimpl) {
        mAllowAddToBackStack = true;
        mManager = fragmentmanagerimpl;
    }

    private void doAddOp(int i, Fragment fragment, String s, int j) {
        fragment.mFragmentManager = mManager;
        if(s != null) {
            if(fragment.mTag != null && !s.equals(fragment.mTag))
                throw new IllegalStateException((new StringBuilder()).append("Can't change tag of fragment ").append(fragment).append(": was ").append(fragment.mTag).append(" now ").append(s).toString());
            fragment.mTag = s;
        }
        if(i != 0) {
            if(fragment.mFragmentId != 0 && fragment.mFragmentId != i)
                throw new IllegalStateException((new StringBuilder()).append("Can't change container ID of fragment ").append(fragment).append(": was ").append(fragment.mFragmentId).append(" now ").append(i).toString());
            fragment.mFragmentId = i;
            fragment.mContainerId = i;
        }
        Op op = new Op();
        op.cmd = j;
        op.fragment = fragment;
        addOp(op);
    }

    public FragmentTransaction add(int i, Fragment fragment) {
        doAddOp(i, fragment, null, 1);
        return this;
    }

    public FragmentTransaction add(int i, Fragment fragment, String s) {
        doAddOp(i, fragment, s, 1);
        return this;
    }

    public FragmentTransaction add(Fragment fragment, String s) {
        doAddOp(0, fragment, s, 1);
        return this;
    }

    void addOp(Op op) {
        if(mHead == null) {
            mTail = op;
            mHead = op;
        } else {
            op.prev = mTail;
            mTail.next = op;
            mTail = op;
        }
        op.enterAnim = mEnterAnim;
        op.exitAnim = mExitAnim;
        op.popEnterAnim = mPopEnterAnim;
        op.popExitAnim = mPopExitAnim;
        mNumOp = 1 + mNumOp;
    }

    public FragmentTransaction addToBackStack(String s) {
        if(!mAllowAddToBackStack) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        } else {
            mAddToBackStack = true;
            mName = s;
            return this;
        }
    }

    public FragmentTransaction attach(Fragment fragment) {
        Op op = new Op();
        op.cmd = 7;
        op.fragment = fragment;
        addOp(op);
        return this;
    }

    void bumpBackStackNesting(int i) {
        if(mAddToBackStack) {
            if(FragmentManagerImpl.DEBUG)
                Log.v("BackStackEntry", (new StringBuilder()).append("Bump nesting in ").append(this).append(" by ").append(i).toString());
            Op op = mHead;
            while(op != null)  {
                if(op.fragment != null) {
                    Fragment fragment1 = op.fragment;
                    fragment1.mBackStackNesting = i + fragment1.mBackStackNesting;
                    if(FragmentManagerImpl.DEBUG)
                        Log.v("BackStackEntry", (new StringBuilder()).append("Bump nesting of ").append(op.fragment).append(" to ").append(op.fragment.mBackStackNesting).toString());
                }
                if(op.removed != null) {
                    for(int j = -1 + op.removed.size(); j >= 0; j--) {
                        Fragment fragment = (Fragment)op.removed.get(j);
                        fragment.mBackStackNesting = i + fragment.mBackStackNesting;
                        if(FragmentManagerImpl.DEBUG)
                            Log.v("BackStackEntry", (new StringBuilder()).append("Bump nesting of ").append(fragment).append(" to ").append(fragment.mBackStackNesting).toString());
                    }

                }
                op = op.next;
            }
        }
    }

    public int commit() {
        return commitInternal(false);
    }

    public int commitAllowingStateLoss() {
        return commitInternal(true);
    }

    int commitInternal(boolean flag) {
        if(mCommitted)
            throw new IllegalStateException("commit already called");
        if(FragmentManagerImpl.DEBUG)
            Log.v("BackStackEntry", (new StringBuilder()).append("Commit: ").append(this).toString());
        mCommitted = true;
        if(mAddToBackStack)
            mIndex = mManager.allocBackStackIndex(this);
        else
            mIndex = -1;
        mManager.enqueueAction(this, flag);
        return mIndex;
    }

    public FragmentTransaction detach(Fragment fragment) {
        Op op = new Op();
        op.cmd = 6;
        op.fragment = fragment;
        addOp(op);
        return this;
    }

    public FragmentTransaction disallowAddToBackStack() {
        if(mAddToBackStack) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        } else {
            mAllowAddToBackStack = false;
            return this;
        }
    }

    public void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        printwriter.print(s);
        printwriter.print("mName=");
        printwriter.print(mName);
        printwriter.print(" mIndex=");
        printwriter.print(mIndex);
        printwriter.print(" mCommitted=");
        printwriter.println(mCommitted);
        if(mTransition != 0) {
            printwriter.print(s);
            printwriter.print("mTransition=#");
            printwriter.print(Integer.toHexString(mTransition));
            printwriter.print(" mTransitionStyle=#");
            printwriter.println(Integer.toHexString(mTransitionStyle));
        }
        if(mEnterAnim != 0 || mExitAnim != 0) {
            printwriter.print(s);
            printwriter.print("mEnterAnim=#");
            printwriter.print(Integer.toHexString(mEnterAnim));
            printwriter.print(" mExitAnim=#");
            printwriter.println(Integer.toHexString(mExitAnim));
        }
        if(mPopEnterAnim != 0 || mPopExitAnim != 0) {
            printwriter.print(s);
            printwriter.print("mPopEnterAnim=#");
            printwriter.print(Integer.toHexString(mPopEnterAnim));
            printwriter.print(" mPopExitAnim=#");
            printwriter.println(Integer.toHexString(mPopExitAnim));
        }
        if(mBreadCrumbTitleRes != 0 || mBreadCrumbTitleText != null) {
            printwriter.print(s);
            printwriter.print("mBreadCrumbTitleRes=#");
            printwriter.print(Integer.toHexString(mBreadCrumbTitleRes));
            printwriter.print(" mBreadCrumbTitleText=");
            printwriter.println(mBreadCrumbTitleText);
        }
        if(mBreadCrumbShortTitleRes != 0 || mBreadCrumbShortTitleText != null) {
            printwriter.print(s);
            printwriter.print("mBreadCrumbShortTitleRes=#");
            printwriter.print(Integer.toHexString(mBreadCrumbShortTitleRes));
            printwriter.print(" mBreadCrumbShortTitleText=");
            printwriter.println(mBreadCrumbShortTitleText);
        }
        if(mHead != null) {
            printwriter.print(s);
            printwriter.println("Operations:");
            String s1 = (new StringBuilder()).append(s).append("    ").toString();
label0:
            for(Op op = mHead; op != null; op = op.next) {
                printwriter.print(s);
                printwriter.print("  Op #");
                printwriter.print(0);
                printwriter.println(":");
                printwriter.print(s1);
                printwriter.print("cmd=");
                printwriter.print(op.cmd);
                printwriter.print(" fragment=");
                printwriter.println(op.fragment);
                if(op.enterAnim != 0 || op.exitAnim != 0) {
                    printwriter.print(s);
                    printwriter.print("enterAnim=#");
                    printwriter.print(Integer.toHexString(op.enterAnim));
                    printwriter.print(" exitAnim=#");
                    printwriter.println(Integer.toHexString(op.exitAnim));
                }
                if(op.popEnterAnim != 0 || op.popExitAnim != 0) {
                    printwriter.print(s);
                    printwriter.print("popEnterAnim=#");
                    printwriter.print(Integer.toHexString(op.popEnterAnim));
                    printwriter.print(" popExitAnim=#");
                    printwriter.println(Integer.toHexString(op.popExitAnim));
                }
                if(op.removed == null || op.removed.size() <= 0)
                    continue;
                int i = 0;
                do {
                    if(i >= op.removed.size())
                        continue label0;
                    printwriter.print(s1);
                    if(op.removed.size() == 1) {
                        printwriter.print("Removed: ");
                    } else {
                        printwriter.println("Removed:");
                        printwriter.print(s1);
                        printwriter.print("  #");
                        printwriter.print(0);
                        printwriter.print(": ");
                    }
                    printwriter.println(op.removed.get(i));
                    i++;
                } while(true);
            }

        }
    }

    public CharSequence getBreadCrumbShortTitle() {
        CharSequence charsequence;
        if(mBreadCrumbShortTitleRes != 0)
            charsequence = mManager.mActivity.getText(mBreadCrumbShortTitleRes);
        else
            charsequence = mBreadCrumbShortTitleText;
        return charsequence;
    }

    public int getBreadCrumbShortTitleRes() {
        return mBreadCrumbShortTitleRes;
    }

    public CharSequence getBreadCrumbTitle() {
        CharSequence charsequence;
        if(mBreadCrumbTitleRes != 0)
            charsequence = mManager.mActivity.getText(mBreadCrumbTitleRes);
        else
            charsequence = mBreadCrumbTitleText;
        return charsequence;
    }

    public int getBreadCrumbTitleRes() {
        return mBreadCrumbTitleRes;
    }

    public int getId() {
        return mIndex;
    }

    public String getName() {
        return mName;
    }

    public int getTransition() {
        return mTransition;
    }

    public int getTransitionStyle() {
        return mTransitionStyle;
    }

    public FragmentTransaction hide(Fragment fragment) {
        Op op = new Op();
        op.cmd = 4;
        op.fragment = fragment;
        addOp(op);
        return this;
    }

    public boolean isAddToBackStackAllowed() {
        return mAllowAddToBackStack;
    }

    public boolean isEmpty() {
        boolean flag;
        if(mNumOp == 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void popFromBackStack(boolean flag) {
        Op op;
        if(FragmentManagerImpl.DEBUG)
            Log.v("BackStackEntry", (new StringBuilder()).append("popFromBackStack: ").append(this).toString());
        bumpBackStackNesting(-1);
        op = mTail;
_L10:
        if(op == null)
            break MISSING_BLOCK_LABEL_444;
        op.cmd;
        JVM INSTR tableswitch 1 7: default 92
    //                   1 123
    //                   2 166
    //                   3 267
    //                   4 295
    //                   5 333
    //                   6 371
    //                   7 409;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_409;
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        throw new IllegalArgumentException((new StringBuilder()).append("Unknown cmd: ").append(op.cmd).toString());
_L2:
        Fragment fragment7 = op.fragment;
        fragment7.mNextAnim = op.popExitAnim;
        mManager.removeFragment(fragment7, FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle);
_L11:
        op = op.prev;
        if(true) goto _L10; else goto _L9
_L9:
        Fragment fragment5 = op.fragment;
        if(fragment5 != null) {
            fragment5.mNextAnim = op.popExitAnim;
            mManager.removeFragment(fragment5, FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle);
        }
        if(op.removed != null) {
            int i = 0;
            while(i < op.removed.size())  {
                Fragment fragment6 = (Fragment)op.removed.get(i);
                fragment6.mNextAnim = op.popEnterAnim;
                mManager.addFragment(fragment6, false);
                i++;
            }
        }
          goto _L11
_L4:
        Fragment fragment4 = op.fragment;
        fragment4.mNextAnim = op.popEnterAnim;
        mManager.addFragment(fragment4, false);
          goto _L11
_L5:
        Fragment fragment3 = op.fragment;
        fragment3.mNextAnim = op.popEnterAnim;
        mManager.showFragment(fragment3, FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle);
          goto _L11
_L6:
        Fragment fragment2 = op.fragment;
        fragment2.mNextAnim = op.popExitAnim;
        mManager.hideFragment(fragment2, FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle);
          goto _L11
_L7:
        Fragment fragment1 = op.fragment;
        fragment1.mNextAnim = op.popEnterAnim;
        mManager.attachFragment(fragment1, FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle);
          goto _L11
        Fragment fragment = op.fragment;
        fragment.mNextAnim = op.popExitAnim;
        mManager.detachFragment(fragment, FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle);
          goto _L11
        if(flag)
            mManager.moveToState(mManager.mCurState, FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle, true);
        if(mIndex >= 0) {
            mManager.freeBackStackIndex(mIndex);
            mIndex = -1;
        }
        return;
    }

    public FragmentTransaction remove(Fragment fragment) {
        Op op = new Op();
        op.cmd = 3;
        op.fragment = fragment;
        addOp(op);
        return this;
    }

    public FragmentTransaction replace(int i, Fragment fragment) {
        return replace(i, fragment, null);
    }

    public FragmentTransaction replace(int i, Fragment fragment, String s) {
        if(i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        } else {
            doAddOp(i, fragment, s, 2);
            return this;
        }
    }

    public void run() {
        Op op;
        if(FragmentManagerImpl.DEBUG)
            Log.v("BackStackEntry", (new StringBuilder()).append("Run: ").append(this).toString());
        if(mAddToBackStack && mIndex < 0)
            throw new IllegalStateException("addToBackStack() called after commit()");
        bumpBackStackNesting(1);
        op = mHead;
_L10:
        if(op == null)
            break MISSING_BLOCK_LABEL_631;
        op.cmd;
        JVM INSTR tableswitch 1 7: default 116
    //                   1 147
    //                   2 180
    //                   3 462
    //                   4 497
    //                   5 532
    //                   6 567
    //                   7 599;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_599;
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        throw new IllegalArgumentException((new StringBuilder()).append("Unknown cmd: ").append(op.cmd).toString());
_L2:
        Fragment fragment7 = op.fragment;
        fragment7.mNextAnim = op.enterAnim;
        mManager.addFragment(fragment7, false);
_L11:
        op = op.next;
        if(true) goto _L10; else goto _L9
_L9:
        Fragment fragment5 = op.fragment;
        if(mManager.mAdded != null) {
            int i = 0;
            while(i < mManager.mAdded.size())  {
                Fragment fragment6 = (Fragment)mManager.mAdded.get(i);
                if(FragmentManagerImpl.DEBUG)
                    Log.v("BackStackEntry", (new StringBuilder()).append("OP_REPLACE: adding=").append(fragment5).append(" old=").append(fragment6).toString());
                if(fragment5 == null || fragment6.mContainerId == fragment5.mContainerId)
                    if(fragment6 == fragment5) {
                        fragment5 = null;
                        op.fragment = null;
                    } else {
                        if(op.removed == null)
                            op.removed = new ArrayList();
                        op.removed.add(fragment6);
                        fragment6.mNextAnim = op.exitAnim;
                        if(mAddToBackStack) {
                            fragment6.mBackStackNesting = 1 + fragment6.mBackStackNesting;
                            if(FragmentManagerImpl.DEBUG)
                                Log.v("BackStackEntry", (new StringBuilder()).append("Bump nesting of ").append(fragment6).append(" to ").append(fragment6.mBackStackNesting).toString());
                        }
                        mManager.removeFragment(fragment6, mTransition, mTransitionStyle);
                    }
                i++;
            }
        }
        if(fragment5 != null) {
            fragment5.mNextAnim = op.enterAnim;
            mManager.addFragment(fragment5, false);
        }
          goto _L11
_L4:
        Fragment fragment4 = op.fragment;
        fragment4.mNextAnim = op.exitAnim;
        mManager.removeFragment(fragment4, mTransition, mTransitionStyle);
          goto _L11
_L5:
        Fragment fragment3 = op.fragment;
        fragment3.mNextAnim = op.exitAnim;
        mManager.hideFragment(fragment3, mTransition, mTransitionStyle);
          goto _L11
_L6:
        Fragment fragment2 = op.fragment;
        fragment2.mNextAnim = op.enterAnim;
        mManager.showFragment(fragment2, mTransition, mTransitionStyle);
          goto _L11
_L7:
        Fragment fragment1 = op.fragment;
        fragment1.mNextAnim = op.exitAnim;
        mManager.detachFragment(fragment1, mTransition, mTransitionStyle);
          goto _L11
        Fragment fragment = op.fragment;
        fragment.mNextAnim = op.enterAnim;
        mManager.attachFragment(fragment, mTransition, mTransitionStyle);
          goto _L11
        mManager.moveToState(mManager.mCurState, mTransition, mTransitionStyle, true);
        if(mAddToBackStack)
            mManager.addBackStackState(this);
        return;
    }

    public FragmentTransaction setBreadCrumbShortTitle(int i) {
        mBreadCrumbShortTitleRes = i;
        mBreadCrumbShortTitleText = null;
        return this;
    }

    public FragmentTransaction setBreadCrumbShortTitle(CharSequence charsequence) {
        mBreadCrumbShortTitleRes = 0;
        mBreadCrumbShortTitleText = charsequence;
        return this;
    }

    public FragmentTransaction setBreadCrumbTitle(int i) {
        mBreadCrumbTitleRes = i;
        mBreadCrumbTitleText = null;
        return this;
    }

    public FragmentTransaction setBreadCrumbTitle(CharSequence charsequence) {
        mBreadCrumbTitleRes = 0;
        mBreadCrumbTitleText = charsequence;
        return this;
    }

    public FragmentTransaction setCustomAnimations(int i, int j) {
        return setCustomAnimations(i, j, 0, 0);
    }

    public FragmentTransaction setCustomAnimations(int i, int j, int k, int l) {
        mEnterAnim = i;
        mExitAnim = j;
        mPopEnterAnim = k;
        mPopExitAnim = l;
        return this;
    }

    public FragmentTransaction setTransition(int i) {
        mTransition = i;
        return this;
    }

    public FragmentTransaction setTransitionStyle(int i) {
        mTransitionStyle = i;
        return this;
    }

    public FragmentTransaction show(Fragment fragment) {
        Op op = new Op();
        op.cmd = 5;
        op.fragment = fragment;
        addOp(op);
        return this;
    }

    static final int OP_ADD = 1;
    static final int OP_ATTACH = 7;
    static final int OP_DETACH = 6;
    static final int OP_HIDE = 4;
    static final int OP_NULL = 0;
    static final int OP_REMOVE = 3;
    static final int OP_REPLACE = 2;
    static final int OP_SHOW = 5;
    static final String TAG = "BackStackEntry";
    boolean mAddToBackStack;
    boolean mAllowAddToBackStack;
    int mBreadCrumbShortTitleRes;
    CharSequence mBreadCrumbShortTitleText;
    int mBreadCrumbTitleRes;
    CharSequence mBreadCrumbTitleText;
    boolean mCommitted;
    int mEnterAnim;
    int mExitAnim;
    Op mHead;
    int mIndex;
    final FragmentManagerImpl mManager;
    String mName;
    int mNumOp;
    int mPopEnterAnim;
    int mPopExitAnim;
    Op mTail;
    int mTransition;
    int mTransitionStyle;
}

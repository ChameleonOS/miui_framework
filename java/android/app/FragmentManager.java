// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;

// Referenced classes of package android.app:
//            FragmentManagerImpl, FragmentTransaction, Fragment

public abstract class FragmentManager {
    public static interface OnBackStackChangedListener {

        public abstract void onBackStackChanged();
    }

    public static interface BackStackEntry {

        public abstract CharSequence getBreadCrumbShortTitle();

        public abstract int getBreadCrumbShortTitleRes();

        public abstract CharSequence getBreadCrumbTitle();

        public abstract int getBreadCrumbTitleRes();

        public abstract int getId();

        public abstract String getName();
    }


    public FragmentManager() {
    }

    public static void enableDebugLogging(boolean flag) {
        FragmentManagerImpl.DEBUG = flag;
    }

    public abstract void addOnBackStackChangedListener(OnBackStackChangedListener onbackstackchangedlistener);

    public abstract FragmentTransaction beginTransaction();

    public abstract void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[]);

    public abstract boolean executePendingTransactions();

    public abstract Fragment findFragmentById(int i);

    public abstract Fragment findFragmentByTag(String s);

    public abstract BackStackEntry getBackStackEntryAt(int i);

    public abstract int getBackStackEntryCount();

    public abstract Fragment getFragment(Bundle bundle, String s);

    public void invalidateOptionsMenu() {
    }

    public FragmentTransaction openTransaction() {
        return beginTransaction();
    }

    public abstract void popBackStack();

    public abstract void popBackStack(int i, int j);

    public abstract void popBackStack(String s, int i);

    public abstract boolean popBackStackImmediate();

    public abstract boolean popBackStackImmediate(int i, int j);

    public abstract boolean popBackStackImmediate(String s, int i);

    public abstract void putFragment(Bundle bundle, String s, Fragment fragment);

    public abstract void removeOnBackStackChangedListener(OnBackStackChangedListener onbackstackchangedlistener);

    public abstract Fragment.SavedState saveFragmentInstanceState(Fragment fragment);

    public static final int POP_BACK_STACK_INCLUSIVE = 1;
}

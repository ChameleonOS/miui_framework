// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SpinnerAdapter;

// Referenced classes of package android.app:
//            FragmentTransaction

public abstract class ActionBar {
    public static class LayoutParams extends android.view.ViewGroup.MarginLayoutParams {

        public int gravity;

        public LayoutParams(int i) {
            this(-2, -1, i);
        }

        public LayoutParams(int i, int j) {
            super(i, j);
            gravity = -1;
            gravity = 19;
        }

        public LayoutParams(int i, int j, int k) {
            super(i, j);
            gravity = -1;
            gravity = k;
        }

        public LayoutParams(LayoutParams layoutparams) {
            super(layoutparams);
            gravity = -1;
            gravity = layoutparams.gravity;
        }

        public LayoutParams(Context context, AttributeSet attributeset) {
            super(context, attributeset);
            gravity = -1;
            TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.ActionBar_LayoutParams);
            gravity = typedarray.getInt(0, -1);
            typedarray.recycle();
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutparams) {
            super(layoutparams);
            gravity = -1;
        }
    }

    public static interface TabListener {

        public abstract void onTabReselected(Tab tab, FragmentTransaction fragmenttransaction);

        public abstract void onTabSelected(Tab tab, FragmentTransaction fragmenttransaction);

        public abstract void onTabUnselected(Tab tab, FragmentTransaction fragmenttransaction);
    }

    public static abstract class Tab {

        public abstract CharSequence getContentDescription();

        public abstract View getCustomView();

        public abstract Drawable getIcon();

        public abstract int getPosition();

        public abstract Object getTag();

        public abstract CharSequence getText();

        public abstract void select();

        public abstract Tab setContentDescription(int i);

        public abstract Tab setContentDescription(CharSequence charsequence);

        public abstract Tab setCustomView(int i);

        public abstract Tab setCustomView(View view);

        public abstract Tab setIcon(int i);

        public abstract Tab setIcon(Drawable drawable);

        public abstract Tab setTabListener(TabListener tablistener);

        public abstract Tab setTag(Object obj);

        public abstract Tab setText(int i);

        public abstract Tab setText(CharSequence charsequence);

        public static final int INVALID_POSITION = -1;

        public Tab() {
        }
    }

    public static interface OnMenuVisibilityListener {

        public abstract void onMenuVisibilityChanged(boolean flag);
    }

    public static interface OnNavigationListener {

        public abstract boolean onNavigationItemSelected(int i, long l);
    }


    public ActionBar() {
    }

    public abstract void addOnMenuVisibilityListener(OnMenuVisibilityListener onmenuvisibilitylistener);

    public abstract void addTab(Tab tab);

    public abstract void addTab(Tab tab, int i);

    public abstract void addTab(Tab tab, int i, boolean flag);

    public abstract void addTab(Tab tab, boolean flag);

    public abstract View getCustomView();

    public abstract int getDisplayOptions();

    public abstract int getHeight();

    public abstract int getNavigationItemCount();

    public abstract int getNavigationMode();

    public abstract int getSelectedNavigationIndex();

    public abstract Tab getSelectedTab();

    public abstract CharSequence getSubtitle();

    public abstract Tab getTabAt(int i);

    public abstract int getTabCount();

    public Context getThemedContext() {
        return null;
    }

    public abstract CharSequence getTitle();

    public abstract void hide();

    public abstract boolean isShowing();

    public abstract Tab newTab();

    public abstract void removeAllTabs();

    public abstract void removeOnMenuVisibilityListener(OnMenuVisibilityListener onmenuvisibilitylistener);

    public abstract void removeTab(Tab tab);

    public abstract void removeTabAt(int i);

    public abstract void selectTab(Tab tab);

    public abstract void setBackgroundDrawable(Drawable drawable);

    public abstract void setCustomView(int i);

    public abstract void setCustomView(View view);

    public abstract void setCustomView(View view, LayoutParams layoutparams);

    public abstract void setDisplayHomeAsUpEnabled(boolean flag);

    public abstract void setDisplayOptions(int i);

    public abstract void setDisplayOptions(int i, int j);

    public abstract void setDisplayShowCustomEnabled(boolean flag);

    public abstract void setDisplayShowHomeEnabled(boolean flag);

    public abstract void setDisplayShowTitleEnabled(boolean flag);

    public abstract void setDisplayUseLogoEnabled(boolean flag);

    public void setHomeButtonEnabled(boolean flag) {
    }

    public abstract void setIcon(int i);

    public abstract void setIcon(Drawable drawable);

    public abstract void setListNavigationCallbacks(SpinnerAdapter spinneradapter, OnNavigationListener onnavigationlistener);

    public abstract void setLogo(int i);

    public abstract void setLogo(Drawable drawable);

    public abstract void setNavigationMode(int i);

    public abstract void setSelectedNavigationItem(int i);

    public void setSplitBackgroundDrawable(Drawable drawable) {
    }

    public void setStackedBackgroundDrawable(Drawable drawable) {
    }

    public abstract void setSubtitle(int i);

    public abstract void setSubtitle(CharSequence charsequence);

    public abstract void setTitle(int i);

    public abstract void setTitle(CharSequence charsequence);

    public abstract void show();

    public static final int DISPLAY_HOME_AS_UP = 4;
    public static final int DISPLAY_SHOW_CUSTOM = 16;
    public static final int DISPLAY_SHOW_HOME = 2;
    public static final int DISPLAY_SHOW_TITLE = 8;
    public static final int DISPLAY_USE_LOGO = 1;
    public static final int NAVIGATION_MODE_LIST = 1;
    public static final int NAVIGATION_MODE_STANDARD = 0;
    public static final int NAVIGATION_MODE_TABS = 2;
}

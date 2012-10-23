// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.inputmethodservice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.*;
import android.widget.Button;
import android.widget.LinearLayout;
import com.android.internal.view.menu.MenuBuilder;
import com.android.internal.view.menu.MenuPopupHelper;

public class ExtractEditLayout extends LinearLayout {
    private class ExtractActionMode extends ActionMode
        implements com.android.internal.view.menu.MenuBuilder.Callback {

        public boolean dispatchOnCreate() {
            mMenu.stopDispatchingItemsChanged();
            boolean flag = mCallback.onCreateActionMode(this, mMenu);
            mMenu.startDispatchingItemsChanged();
            return flag;
            Exception exception;
            exception;
            mMenu.startDispatchingItemsChanged();
            throw exception;
        }

        public void finish() {
            if(mActionMode == this) {
                mCallback.onDestroyActionMode(this);
                mCallback = null;
                mExtractActionButton.setVisibility(0);
                mEditButton.setVisibility(4);
                sendAccessibilityEvent(32);
                mActionMode = null;
            }
        }

        public View getCustomView() {
            return null;
        }

        public Menu getMenu() {
            return mMenu;
        }

        public MenuInflater getMenuInflater() {
            return new MenuInflater(getContext());
        }

        public CharSequence getSubtitle() {
            return null;
        }

        public CharSequence getTitle() {
            return null;
        }

        public void invalidate() {
            mMenu.stopDispatchingItemsChanged();
            mCallback.onPrepareActionMode(this, mMenu);
            mMenu.startDispatchingItemsChanged();
            return;
            Exception exception;
            exception;
            mMenu.startDispatchingItemsChanged();
            throw exception;
        }

        public boolean isTitleOptional() {
            return true;
        }

        public boolean onMenuItemSelected(MenuBuilder menubuilder, MenuItem menuitem) {
            boolean flag;
            if(mCallback != null)
                flag = mCallback.onActionItemClicked(this, menuitem);
            else
                flag = false;
            return flag;
        }

        public void onMenuModeChange(MenuBuilder menubuilder) {
        }

        public void setCustomView(View view) {
        }

        public void setSubtitle(int i) {
        }

        public void setSubtitle(CharSequence charsequence) {
        }

        public void setTitle(int i) {
        }

        public void setTitle(CharSequence charsequence) {
        }

        private android.view.ActionMode.Callback mCallback;
        MenuBuilder mMenu;
        final ExtractEditLayout this$0;

        public ExtractActionMode(android.view.ActionMode.Callback callback) {
            this$0 = ExtractEditLayout.this;
            super();
            mMenu = new MenuBuilder(getContext());
            mMenu.setCallback(this);
            mCallback = callback;
        }
    }


    public ExtractEditLayout(Context context) {
        super(context);
    }

    public ExtractEditLayout(Context context, AttributeSet attributeset) {
        super(context, attributeset);
    }

    public void finishActionMode() {
        if(mActionMode != null)
            mActionMode.finish();
    }

    public boolean isActionModeStarted() {
        boolean flag;
        if(mActionMode != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        mExtractActionButton = (Button)findViewById(0x102028e);
        mEditButton = (Button)findViewById(0x102028f);
        mEditButton.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view) {
                if(mActionMode != null)
                    (new MenuPopupHelper(getContext(), mActionMode.mMenu, view)).show();
            }

            final ExtractEditLayout this$0;

             {
                this$0 = ExtractEditLayout.this;
                super();
            }
        });
    }

    public ActionMode startActionModeForChild(View view, android.view.ActionMode.Callback callback) {
        ExtractActionMode extractactionmode = new ExtractActionMode(callback);
        if(extractactionmode.dispatchOnCreate()) {
            extractactionmode.invalidate();
            mExtractActionButton.setVisibility(4);
            mEditButton.setVisibility(0);
            mActionMode = extractactionmode;
            sendAccessibilityEvent(32);
        } else {
            extractactionmode = null;
        }
        return extractactionmode;
    }

    ExtractActionMode mActionMode;
    Button mEditButton;
    Button mExtractActionButton;
}

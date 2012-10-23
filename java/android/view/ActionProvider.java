// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.content.Context;
import android.util.Log;

// Referenced classes of package android.view:
//            View, MenuItem, SubMenu

public abstract class ActionProvider {
    public static interface VisibilityListener {

        public abstract void onActionProviderVisibilityChanged(boolean flag);
    }

    public static interface SubUiVisibilityListener {

        public abstract void onSubUiVisibilityChanged(boolean flag);
    }


    public ActionProvider(Context context) {
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isVisible() {
        return true;
    }

    public abstract View onCreateActionView();

    public View onCreateActionView(MenuItem menuitem) {
        return onCreateActionView();
    }

    public boolean onPerformDefaultAction() {
        return false;
    }

    public void onPrepareSubMenu(SubMenu submenu) {
    }

    public boolean overridesItemVisibility() {
        return false;
    }

    public void refreshVisibility() {
        if(mVisibilityListener != null && overridesItemVisibility())
            mVisibilityListener.onActionProviderVisibilityChanged(isVisible());
    }

    public void setSubUiVisibilityListener(SubUiVisibilityListener subuivisibilitylistener) {
        mSubUiVisibilityListener = subuivisibilitylistener;
    }

    public void setVisibilityListener(VisibilityListener visibilitylistener) {
        if(mVisibilityListener != null)
            Log.w("ActionProvider", (new StringBuilder()).append("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ").append(getClass().getSimpleName()).append(" instance while it is still in use somewhere else?").toString());
        mVisibilityListener = visibilitylistener;
    }

    public void subUiVisibilityChanged(boolean flag) {
        if(mSubUiVisibilityListener != null)
            mSubUiVisibilityListener.onSubUiVisibilityChanged(flag);
    }

    private static final String TAG = "ActionProvider";
    private SubUiVisibilityListener mSubUiVisibilityListener;
    private VisibilityListener mVisibilityListener;
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.util;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.IBinder;
import android.view.*;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.android.internal.view.menu.*;

public class MenuDialogHelper
    implements android.content.DialogInterface.OnKeyListener, android.content.DialogInterface.OnClickListener, android.content.DialogInterface.OnDismissListener, com.android.internal.view.menu.MenuPresenter.Callback {

    public MenuDialogHelper(MenuBuilder menubuilder) {
        mMenu = menubuilder;
    }

    public void dismiss() {
        if(mDialog != null)
            mDialog.dismiss();
    }

    public void onClick(DialogInterface dialoginterface, int i) {
        mMenu.performItemAction((MenuItemImpl)mPresenter.getAdapter().getItem(i), 0);
    }

    public void onCloseMenu(MenuBuilder menubuilder, boolean flag) {
        if(flag || menubuilder == mMenu)
            dismiss();
        if(mPresenterCallback != null)
            mPresenterCallback.onCloseMenu(menubuilder, flag);
    }

    public void onDismiss(DialogInterface dialoginterface) {
        mPresenter.onCloseMenu(mMenu, true);
    }

    public boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent) {
        boolean flag = true;
        if(i != 82 && i != 4) goto _L2; else goto _L1
_L1:
        if(keyevent.getAction() != 0 || keyevent.getRepeatCount() != 0) goto _L4; else goto _L3
_L3:
        Window window1 = mDialog.getWindow();
        if(window1 == null) goto _L2; else goto _L5
_L5:
        View view1 = window1.getDecorView();
        if(view1 == null) goto _L2; else goto _L6
_L6:
        android.view.KeyEvent.DispatcherState dispatcherstate1 = view1.getKeyDispatcherState();
        if(dispatcherstate1 == null) goto _L2; else goto _L7
_L7:
        dispatcherstate1.startTracking(keyevent, this);
_L9:
        return flag;
_L4:
        if(keyevent.getAction() == flag && !keyevent.isCanceled()) {
            Window window = mDialog.getWindow();
            if(window != null) {
                View view = window.getDecorView();
                if(view != null) {
                    android.view.KeyEvent.DispatcherState dispatcherstate = view.getKeyDispatcherState();
                    if(dispatcherstate != null && dispatcherstate.isTracking(keyevent)) {
                        mMenu.close();
                        dialoginterface.dismiss();
                        continue; /* Loop/switch isn't completed */
                    }
                }
            }
        }
_L2:
        flag = mMenu.performShortcut(i, keyevent, 0);
        if(true) goto _L9; else goto _L8
_L8:
    }

    public boolean onOpenSubMenu(MenuBuilder menubuilder) {
        boolean flag;
        if(mPresenterCallback != null)
            flag = mPresenterCallback.onOpenSubMenu(menubuilder);
        else
            flag = false;
        return flag;
    }

    public void setPresenterCallback(com.android.internal.view.menu.MenuPresenter.Callback callback) {
        mPresenterCallback = callback;
    }

    public void show(IBinder ibinder) {
        MenuBuilder menubuilder = mMenu;
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(menubuilder.getContext());
        mPresenter = new ListMenuPresenter(builder.getContext(), 0x603002b);
        mPresenter.setCallback(this);
        mMenu.addMenuPresenter(mPresenter);
        builder.setAdapter(mPresenter.getAdapter(), this);
        View view = menubuilder.getHeaderView();
        android.view.WindowManager.LayoutParams layoutparams;
        if(view != null)
            builder.setCustomTitle(view);
        else
            builder.setIcon(menubuilder.getHeaderIcon()).setTitle(menubuilder.getHeaderTitle());
        builder.setOnKeyListener(this);
        mDialog = builder.create();
        mDialog.setOnDismissListener(this);
        layoutparams = mDialog.getWindow().getAttributes();
        layoutparams.type = 1003;
        if(ibinder != null)
            layoutparams.token = ibinder;
        layoutparams.flags = 0x20000 | layoutparams.flags;
        layoutparams.gravity = 80;
        mDialog.show();
        ((ViewGroup)mDialog.getListView().getParent()).setBackgroundResource(0x6020170);
    }

    private AlertDialog mDialog;
    private MenuBuilder mMenu;
    ListMenuPresenter mPresenter;
    private com.android.internal.view.menu.MenuPresenter.Callback mPresenterCallback;
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.util.EventLog;
import android.view.ContextMenu;
import android.view.View;
import java.util.ArrayList;

// Referenced classes of package com.android.internal.view.menu:
//            MenuBuilder, MenuDialogHelper

public class ContextMenuBuilder extends MenuBuilder
    implements ContextMenu {

    public ContextMenuBuilder(Context context) {
        super(context);
    }

    public ContextMenu setHeaderIcon(int i) {
        return (ContextMenu)super.setHeaderIconInt(i);
    }

    public ContextMenu setHeaderIcon(Drawable drawable) {
        return (ContextMenu)super.setHeaderIconInt(drawable);
    }

    public ContextMenu setHeaderTitle(int i) {
        return (ContextMenu)super.setHeaderTitleInt(i);
    }

    public ContextMenu setHeaderTitle(CharSequence charsequence) {
        return (ContextMenu)super.setHeaderTitleInt(charsequence);
    }

    public ContextMenu setHeaderView(View view) {
        return (ContextMenu)super.setHeaderViewInt(view);
    }

    public MenuDialogHelper show(View view, IBinder ibinder) {
        if(view != null)
            view.createContextMenu(this);
        MenuDialogHelper menudialoghelper;
        if(getVisibleItems().size() > 0) {
            EventLog.writeEvent(50001, 1);
            menudialoghelper = new MenuDialogHelper(this);
            menudialoghelper.show(ibinder);
        } else {
            menudialoghelper = null;
        }
        return menudialoghelper;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.Context;
import android.view.MenuItem;

// Referenced classes of package android.app:
//            Dialog

public class PreferenceDialog extends Dialog {

    public PreferenceDialog(Context context, int i) {
        super(context, i);
    }

    public boolean onMenuItemSelected(int i, MenuItem menuitem) {
        menuitem.getItemId();
        JVM INSTR tableswitch 16908332 16908332: default 24
    //                   16908332 33;
           goto _L1 _L2
_L1:
        boolean flag = super.onMenuItemSelected(i, menuitem);
_L4:
        return flag;
_L2:
        dismiss();
        flag = true;
        if(true) goto _L4; else goto _L3
_L3:
    }
}

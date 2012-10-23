// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.preference;

import android.app.ActionBar;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.MenuItem;

public class BasePreferenceActivity extends PreferenceActivity {

    public BasePreferenceActivity() {
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActionBar actionbar = getActionBar();
        if(actionbar != null)
            actionbar.setHomeButtonEnabled(true);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem) {
        menuitem.getItemId();
        JVM INSTR tableswitch 16908332 16908332: default 24
    //                   16908332 32;
           goto _L1 _L2
_L1:
        boolean flag = super.onOptionsItemSelected(menuitem);
_L4:
        return flag;
_L2:
        finish();
        flag = true;
        if(true) goto _L4; else goto _L3
_L3:
    }
}

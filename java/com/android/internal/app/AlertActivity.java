// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.app;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;

// Referenced classes of package com.android.internal.app:
//            AlertController

public abstract class AlertActivity extends Activity
    implements DialogInterface {

    public AlertActivity() {
    }

    public void cancel() {
        finish();
    }

    public void dismiss() {
        if(!isFinishing())
            finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mAlert = new AlertController(this, this, getWindow());
        mAlertParams = new AlertController.AlertParams(this);
    }

    public boolean onKeyDown(int i, KeyEvent keyevent) {
        boolean flag;
        if(mAlert.onKeyDown(i, keyevent))
            flag = true;
        else
            flag = super.onKeyDown(i, keyevent);
        return flag;
    }

    public boolean onKeyUp(int i, KeyEvent keyevent) {
        boolean flag;
        if(mAlert.onKeyUp(i, keyevent))
            flag = true;
        else
            flag = super.onKeyUp(i, keyevent);
        return flag;
    }

    protected void setupAlert() {
        mAlertParams.apply(mAlert);
        mAlert.installContent();
    }

    protected AlertController mAlert;
    protected AlertController.AlertParams mAlertParams;
}

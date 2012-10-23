// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.os;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.view.Window;

public abstract class AsyncTaskWithProgress extends AsyncTask {

    public AsyncTaskWithProgress(ProgressDialog progressdialog) {
        init(progressdialog);
    }

    public AsyncTaskWithProgress(Context context, int i, int j, int k, boolean flag) {
        ProgressDialog progressdialog = new ProgressDialog(context, j);
        Object obj;
        Object obj1;
        if(i == 0)
            obj = null;
        else
            obj = context.getResources().getString(i);
        progressdialog.setTitle(((CharSequence) (obj)));
        if(k == 0)
            obj1 = null;
        else
            obj1 = context.getResources().getString(k);
        progressdialog.setMessage(((CharSequence) (obj1)));
        progressdialog.setIndeterminate(true);
        progressdialog.setCancelable(flag);
        progressdialog.setOnCancelListener(null);
        init(progressdialog);
    }

    public AsyncTaskWithProgress(Context context, int i, int j, boolean flag) {
        this(context, i, 3, j, flag);
    }

    private void dismissDialog() {
        if(mDialog != null && mDialog.isShowing())
            mDialog.dismiss();
_L2:
        return;
        Exception exception;
        exception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private void init(ProgressDialog progressdialog) {
        mDialog = progressdialog;
        if(mDialog != null)
            mDialog.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                public void onCancel(DialogInterface dialoginterface) {
                    cancel(true);
                }

                final AsyncTaskWithProgress this$0;

             {
                this$0 = AsyncTaskWithProgress.this;
                super();
            }
            });
    }

    public void onCancelled() {
        dismissDialog();
    }

    protected void onPostExecute(Object obj) {
        dismissDialog();
    }

    protected void onPreExecute() {
        if(mDialog != null)
            mDialog.show();
    }

    public void setDialogType(int i) {
        if(mDialog != null)
            mDialog.getWindow().setType(i);
    }

    protected ProgressDialog mDialog;
}

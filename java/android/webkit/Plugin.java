// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class Plugin {
    private class DefaultClickHandler
        implements PreferencesClickHandler, android.content.DialogInterface.OnClickListener {

        public void handleClickEvent(Context context) {
            if(mDialog == null)
                mDialog = (new android.app.AlertDialog.Builder(context)).setTitle(mName).setMessage(mDescription).setPositiveButton(0x104000a, this).setCancelable(false).show();
        }

        public void onClick(DialogInterface dialoginterface, int i) {
            mDialog.dismiss();
            mDialog = null;
        }

        private AlertDialog mDialog;
        final Plugin this$0;

        private DefaultClickHandler() {
            this$0 = Plugin.this;
            super();
        }

    }

    public static interface PreferencesClickHandler {

        public abstract void handleClickEvent(Context context);
    }


    public Plugin(String s, String s1, String s2, String s3) {
        mName = s;
        mPath = s1;
        mFileName = s2;
        mDescription = s3;
        mHandler = new DefaultClickHandler();
    }

    public void dispatchClickEvent(Context context) {
        if(mHandler != null)
            mHandler.handleClickEvent(context);
    }

    public String getDescription() {
        return mDescription;
    }

    public String getFileName() {
        return mFileName;
    }

    public String getName() {
        return mName;
    }

    public String getPath() {
        return mPath;
    }

    public void setClickHandler(PreferencesClickHandler preferencesclickhandler) {
        mHandler = preferencesclickhandler;
    }

    public void setDescription(String s) {
        mDescription = s;
    }

    public void setFileName(String s) {
        mFileName = s;
    }

    public void setName(String s) {
        mName = s;
    }

    public void setPath(String s) {
        mPath = s;
    }

    public String toString() {
        return mName;
    }

    private String mDescription;
    private String mFileName;
    private PreferencesClickHandler mHandler;
    private String mName;
    private String mPath;


}

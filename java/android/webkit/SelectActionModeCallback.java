// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.app.Activity;
import android.content.*;
import android.provider.Browser;
import android.view.*;

// Referenced classes of package android.webkit:
//            WebViewClassic

class SelectActionModeCallback
    implements android.view.ActionMode.Callback {

    SelectActionModeCallback() {
        mIsTextSelected = true;
    }

    private void setMenuVisibility(Menu menu, boolean flag, int i) {
        MenuItem menuitem = menu.findItem(i);
        if(menuitem != null)
            menuitem.setVisible(flag);
    }

    void finish() {
        if(mActionMode != null)
            mActionMode.finish();
    }

    public boolean onActionItemClicked(ActionMode actionmode, MenuItem menuitem) {
        boolean flag = false;
        menuitem.getItemId();
        JVM INSTR lookupswitch 7: default 76
    //                   16908320: 78
    //                   16908321: 94
    //                   16908322: 109
    //                   16909165: 151
    //                   16909166: 123
    //                   16909167: 161
    //                   16909168: 188;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_188;
_L1:
        return flag;
_L2:
        mWebView.cutSelection();
        actionmode.finish();
_L9:
        flag = true;
        if(true) goto _L1; else goto _L3
_L3:
        mWebView.copySelection();
        actionmode.finish();
          goto _L9
_L4:
        mWebView.pasteFromClipboard();
        actionmode.finish();
          goto _L9
_L6:
        String s1 = mWebView.getSelection();
        Browser.sendString(mWebView.getContext(), s1);
        actionmode.finish();
          goto _L9
_L5:
        mWebView.selectAll();
          goto _L9
_L7:
        String s = mWebView.getSelection();
        actionmode.finish();
        mWebView.showFindDialog(s, false);
          goto _L9
        actionmode.finish();
        Intent intent = new Intent("android.intent.action.WEB_SEARCH");
        intent.putExtra("new_search", true);
        intent.putExtra("query", mWebView.getSelection());
        if(!(mWebView.getContext() instanceof Activity))
            intent.addFlags(0x10000000);
        mWebView.getContext().startActivity(intent);
          goto _L9
    }

    public boolean onCreateActionMode(ActionMode actionmode, Menu menu) {
        boolean flag = false;
        actionmode.getMenuInflater().inflate(0x1140000, menu);
        Context context = mWebView.getContext();
        actionmode.setTitle(context.getString(0x10403bf));
        actionmode.setTitleOptionalHint(true);
        ClipboardManager clipboardmanager = (ClipboardManager)(ClipboardManager)context.getSystemService("clipboard");
        boolean flag1 = actionmode.isUiFocusable();
        boolean flag2 = mWebView.focusCandidateIsEditableText();
        boolean flag3;
        boolean flag4;
        boolean flag5;
        boolean flag6;
        if(flag2 && clipboardmanager.hasPrimaryClip() && flag1)
            flag3 = true;
        else
            flag3 = false;
        if(!flag2 && flag1)
            flag4 = true;
        else
            flag4 = false;
        if(flag2 && mIsTextSelected && flag1)
            flag = true;
        flag5 = mIsTextSelected;
        flag6 = mIsTextSelected;
        setMenuVisibility(menu, flag4, 0x102036f);
        setMenuVisibility(menu, flag3, 0x1020022);
        setMenuVisibility(menu, flag, 0x1020020);
        setMenuVisibility(menu, flag5, 0x1020021);
        setMenuVisibility(menu, flag6, 0x1020370);
        mActionMode = actionmode;
        return true;
    }

    public void onDestroyActionMode(ActionMode actionmode) {
        mWebView.selectionDone();
    }

    public boolean onPrepareActionMode(ActionMode actionmode, Menu menu) {
        return true;
    }

    void setTextSelected(boolean flag) {
        mIsTextSelected = flag;
    }

    void setWebView(WebViewClassic webviewclassic) {
        mWebView = webviewclassic;
    }

    private ActionMode mActionMode;
    private boolean mIsTextSelected;
    private WebViewClassic mWebView;
}

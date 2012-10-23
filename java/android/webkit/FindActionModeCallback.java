// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.*;
import android.view.*;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

// Referenced classes of package android.webkit:
//            WebViewClassic, WebView

class FindActionModeCallback
    implements android.view.ActionMode.Callback, TextWatcher, android.view.View.OnClickListener {
    public static class NoAction
        implements android.view.ActionMode.Callback {

        public boolean onActionItemClicked(ActionMode actionmode, MenuItem menuitem) {
            return false;
        }

        public boolean onCreateActionMode(ActionMode actionmode, Menu menu) {
            return false;
        }

        public void onDestroyActionMode(ActionMode actionmode) {
        }

        public boolean onPrepareActionMode(ActionMode actionmode, Menu menu) {
            return false;
        }

        public NoAction() {
        }
    }


    FindActionModeCallback(Context context) {
        mGlobalVisibleRect = new Rect();
        mGlobalVisibleOffset = new Point();
        mCustomView = LayoutInflater.from(context).inflate(0x10900c7, null);
        mEditText = (EditText)mCustomView.findViewById(0x1020003);
        mEditText.setCustomSelectionActionModeCallback(new NoAction());
        mEditText.setOnClickListener(this);
        setText("");
        mMatches = (TextView)mCustomView.findViewById(0x1020362);
        mInput = (InputMethodManager)context.getSystemService("input_method");
        mResources = context.getResources();
    }

    private void findNext(boolean flag) {
        if(mWebView == null)
            throw new AssertionError("No WebView for FindActionModeCallback::findNext");
        if(mMatchesFound) goto _L2; else goto _L1
_L1:
        findAll();
_L4:
        return;
_L2:
        if(mNumberOfMatches != 0) {
            mWebView.findNext(flag);
            updateMatchesString();
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void updateMatchesString() {
        if(mNumberOfMatches == 0) {
            mMatches.setText(0x104048e);
        } else {
            TextView textview = mMatches;
            Resources resources = mResources;
            int i = mNumberOfMatches;
            Object aobj[] = new Object[2];
            aobj[0] = Integer.valueOf(1 + mActiveMatchIndex);
            aobj[1] = Integer.valueOf(mNumberOfMatches);
            textview.setText(resources.getQuantityString(0x1130013, i, aobj));
        }
        mMatches.setVisibility(0);
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k) {
    }

    void findAll() {
        if(mWebView == null)
            throw new AssertionError("No WebView for FindActionModeCallback::findAll");
        Editable editable = mEditText.getText();
        if(editable.length() == 0) {
            mWebView.clearMatches();
            mMatches.setVisibility(8);
            mMatchesFound = false;
            mWebView.findAll(null);
        } else {
            mMatchesFound = true;
            mMatches.setVisibility(4);
            mNumberOfMatches = 0;
            mWebView.findAllAsync(editable.toString());
        }
    }

    void finish() {
        mActionMode.finish();
    }

    public int getActionModeGlobalBottom() {
        int i;
        if(mActionMode == null) {
            i = 0;
        } else {
            View view = (View)mCustomView.getParent();
            if(view == null)
                view = mCustomView;
            view.getGlobalVisibleRect(mGlobalVisibleRect, mGlobalVisibleOffset);
            i = mGlobalVisibleRect.bottom;
        }
        return i;
    }

    public boolean onActionItemClicked(ActionMode actionmode, MenuItem menuitem) {
        boolean flag;
        flag = false;
        if(mWebView == null)
            throw new AssertionError("No WebView for FindActionModeCallback::onActionItemClicked");
        mInput.hideSoftInputFromWindow(mWebView.getWebView().getWindowToken(), 0);
        menuitem.getItemId();
        JVM INSTR tableswitch 16909169 16909170: default 68
    //                   16909169 70
    //                   16909170 80;
           goto _L1 _L2 _L3
_L1:
        return flag;
_L2:
        findNext(false);
_L4:
        flag = true;
        if(true) goto _L1; else goto _L3
_L3:
        findNext(true);
          goto _L4
    }

    public void onClick(View view) {
        findNext(true);
    }

    public boolean onCreateActionMode(ActionMode actionmode, Menu menu) {
        boolean flag = false;
        if(actionmode.isUiFocusable()) {
            actionmode.setCustomView(mCustomView);
            actionmode.getMenuInflater().inflate(0x1140001, menu);
            mActionMode = actionmode;
            Editable editable = mEditText.getText();
            Selection.setSelection(editable, editable.length());
            mMatches.setVisibility(8);
            mMatchesFound = false;
            mMatches.setText("0");
            mEditText.requestFocus();
            flag = true;
        }
        return flag;
    }

    public void onDestroyActionMode(ActionMode actionmode) {
        mActionMode = null;
        mWebView.notifyFindDialogDismissed();
        mInput.hideSoftInputFromWindow(mWebView.getWebView().getWindowToken(), 0);
    }

    public boolean onPrepareActionMode(ActionMode actionmode, Menu menu) {
        return false;
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k) {
        findAll();
    }

    void setText(String s) {
        mEditText.setText(s);
        Editable editable = mEditText.getText();
        int i = editable.length();
        Selection.setSelection(editable, i, i);
        editable.setSpan(this, 0, i, 18);
        mMatchesFound = false;
    }

    void setWebView(WebViewClassic webviewclassic) {
        if(webviewclassic == null) {
            throw new AssertionError("WebView supplied to FindActionModeCallback cannot be null");
        } else {
            mWebView = webviewclassic;
            return;
        }
    }

    public void showSoftInput() {
        mInput.startGettingWindowFocus(mEditText.getRootView());
        mInput.focusIn(mEditText);
        mInput.showSoftInput(mEditText, 0);
    }

    public void updateMatchCount(int i, int j, boolean flag) {
        if(!flag) {
            mNumberOfMatches = j;
            mActiveMatchIndex = i;
            updateMatchesString();
        } else {
            mMatches.setVisibility(4);
            mNumberOfMatches = 0;
        }
    }

    private ActionMode mActionMode;
    private int mActiveMatchIndex;
    private View mCustomView;
    private EditText mEditText;
    private Point mGlobalVisibleOffset;
    private Rect mGlobalVisibleRect;
    private InputMethodManager mInput;
    private TextView mMatches;
    private boolean mMatchesFound;
    private int mNumberOfMatches;
    private Resources mResources;
    private WebViewClassic mWebView;
}

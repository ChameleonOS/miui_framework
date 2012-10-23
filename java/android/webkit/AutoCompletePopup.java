// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.*;

// Referenced classes of package android.webkit:
//            WebViewClassic, WebView, WebChromeClient

class AutoCompletePopup
    implements android.widget.AdapterView.OnItemClickListener, android.widget.Filter.FilterListener, android.widget.PopupWindow.OnDismissListener {
    private static class AnchorView extends View {

        AnchorView(Context context) {
            super(context);
            setFocusable(false);
            setVisibility(4);
        }
    }


    public AutoCompletePopup(WebViewClassic webviewclassic, WebViewClassic.WebViewInputConnection webviewinputconnection) {
        mInputConnection = webviewinputconnection;
        mWebView = webviewclassic;
        mHandler = new Handler() {

            public void handleMessage(Message message) {
                message.what;
                JVM INSTR tableswitch 100 100: default 24
            //                           100 25;
                   goto _L1 _L2
_L1:
                return;
_L2:
                mWebView.autoFillForm(mQueryId);
                if(true) goto _L1; else goto _L3
_L3:
            }

            final AutoCompletePopup this$0;

             {
                this$0 = AutoCompletePopup.this;
                super();
            }
        };
    }

    private void ensurePopup() {
        if(mPopup != null) goto _L2; else goto _L1
_L1:
        mPopup = new ListPopupWindow(mWebView.getContext());
        mAnchor = new AnchorView(mWebView.getContext());
        mWebView.getWebView().addView(mAnchor);
        mPopup.setOnItemClickListener(this);
        mPopup.setAnchorView(mAnchor);
        mPopup.setPromptPosition(1);
_L4:
        return;
_L2:
        if(mWebView.getWebView().indexOfChild(mAnchor) < 0)
            mWebView.getWebView().addView(mAnchor);
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void pushTextToInputConnection() {
        Editable editable = mInputConnection.getEditable();
        mInputConnection.setSelection(0, editable.length());
        mInputConnection.replaceSelection(mText);
        mInputConnection.setSelection(mText.length(), mText.length());
    }

    public void clearAdapter() {
        mAdapter = null;
        mFilter = null;
        if(mPopup != null) {
            mPopup.dismiss();
            mPopup.setAdapter(null);
        }
    }

    public void onDismiss() {
        mWebView.getWebView().removeView(mAnchor);
    }

    public void onFilterComplete(int i) {
        ensurePopup();
        boolean flag;
        if(i > 0 && (mInputConnection.getIsAutoFillable() || mText.length() > 0))
            flag = true;
        else
            flag = false;
        if(flag) {
            if(!mPopup.isShowing())
                mPopup.setInputMethodMode(1);
            mPopup.show();
            mPopup.getListView().setOverScrollMode(0);
        } else {
            mPopup.dismiss();
        }
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l) {
        if(mPopup != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(l != 0L || i != 0 || !mInputConnection.getIsAutoFillable())
            break; /* Loop/switch isn't completed */
        mText = "";
        pushTextToInputConnection();
        if(mIsAutoFillProfileSet) {
            mWebView.autoFillForm(mQueryId);
        } else {
            WebChromeClient webchromeclient = mWebView.getWebChromeClient();
            if(webchromeclient != null)
                webchromeclient.setupAutoFill(mHandler.obtainMessage(100));
        }
_L4:
        mPopup.dismiss();
        if(true) goto _L1; else goto _L3
_L3:
        Object obj;
        if(i < 0)
            obj = mPopup.getSelectedItem();
        else
            obj = mAdapter.getItem(i);
        if(obj != null) {
            setText(mFilter.convertResultToString(obj));
            pushTextToInputConnection();
        }
          goto _L4
        if(true) goto _L1; else goto _L5
_L5:
    }

    public boolean onKeyPreIme(int i, KeyEvent keyevent) {
        boolean flag = false;
        if(mPopup != null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(i == 4 && mPopup.isShowing()) {
            if(keyevent.getAction() == 0 && keyevent.getRepeatCount() == 0) {
                android.view.KeyEvent.DispatcherState dispatcherstate1 = mAnchor.getKeyDispatcherState();
                if(dispatcherstate1 != null)
                    dispatcherstate1.startTracking(keyevent, this);
                flag = true;
                continue; /* Loop/switch isn't completed */
            }
            if(keyevent.getAction() == 1) {
                android.view.KeyEvent.DispatcherState dispatcherstate = mAnchor.getKeyDispatcherState();
                if(dispatcherstate != null)
                    dispatcherstate.handleUpEvent(keyevent);
                if(keyevent.isTracking() && !keyevent.isCanceled()) {
                    mPopup.dismiss();
                    flag = true;
                    continue; /* Loop/switch isn't completed */
                }
            }
        }
        if(mPopup.isShowing())
            flag = mPopup.onKeyPreIme(i, keyevent);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void resetRect() {
        int i;
        int j;
        int l;
        int i1;
        android.widget.AbsoluteLayout.LayoutParams layoutparams;
        boolean flag;
        ensurePopup();
        i = mWebView.contentToViewX(mWebView.mEditTextContentBounds.left);
        j = mWebView.contentToViewX(mWebView.mEditTextContentBounds.right) - i;
        mPopup.setWidth(j);
        int k = mWebView.contentToViewY(mWebView.mEditTextContentBounds.bottom);
        l = mWebView.contentToViewY(mWebView.mEditTextContentBounds.top);
        i1 = k - l;
        layoutparams = (android.widget.AbsoluteLayout.LayoutParams)mAnchor.getLayoutParams();
        flag = false;
        if(layoutparams != null) goto _L2; else goto _L1
_L1:
        layoutparams = new android.widget.AbsoluteLayout.LayoutParams(j, i1, i, l);
_L4:
        if(flag)
            mAnchor.setLayoutParams(layoutparams);
        if(mPopup.isShowing())
            mPopup.show();
        return;
_L2:
        if(layoutparams.x != i || layoutparams.y != l || ((android.view.ViewGroup.LayoutParams) (layoutparams)).width != j || ((android.view.ViewGroup.LayoutParams) (layoutparams)).height != i1) {
            flag = true;
            layoutparams.x = i;
            layoutparams.y = l;
            layoutparams.width = j;
            layoutparams.height = i1;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void setAdapter(ListAdapter listadapter) {
        ensurePopup();
        mPopup.setAdapter(listadapter);
        mAdapter = listadapter;
        if(listadapter != null) {
            mFilter = ((Filterable)listadapter).getFilter();
            mFilter.filter(mText, this);
        } else {
            mFilter = null;
        }
        resetRect();
    }

    public void setAutoFillQueryId(int i) {
        mQueryId = i;
    }

    public void setIsAutoFillProfileSet(boolean flag) {
        mIsAutoFillProfileSet = flag;
    }

    public void setText(CharSequence charsequence) {
        mText = charsequence;
        if(mFilter != null)
            mFilter.filter(charsequence, this);
    }

    private static final int AUTOFILL_FORM = 100;
    private ListAdapter mAdapter;
    private View mAnchor;
    private Filter mFilter;
    private Handler mHandler;
    private WebViewClassic.WebViewInputConnection mInputConnection;
    private boolean mIsAutoFillProfileSet;
    private ListPopupWindow mPopup;
    private int mQueryId;
    private CharSequence mText;
    private WebViewClassic mWebView;


}

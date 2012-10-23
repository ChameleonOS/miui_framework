// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.*;
import android.widget.FrameLayout;

// Referenced classes of package android.webkit:
//            WebViewClassic, WebChromeClient, ViewManager, WebViewCore

class PluginFullScreenHolder {
    private class CustomFrameLayout extends FrameLayout {

        public boolean onKeyDown(int i, KeyEvent keyevent) {
            boolean flag;
            if(keyevent.isSystem()) {
                flag = super.onKeyDown(i, keyevent);
            } else {
                mWebView.onKeyDown(i, keyevent);
                flag = true;
            }
            return flag;
        }

        public boolean onKeyUp(int i, KeyEvent keyevent) {
            boolean flag;
            if(keyevent.isSystem()) {
                flag = super.onKeyUp(i, keyevent);
            } else {
                mWebView.onKeyUp(i, keyevent);
                flag = true;
            }
            return flag;
        }

        public boolean onTouchEvent(MotionEvent motionevent) {
            return true;
        }

        public boolean onTrackballEvent(MotionEvent motionevent) {
            mWebView.onTrackballEvent(motionevent);
            return true;
        }

        final PluginFullScreenHolder this$0;

        CustomFrameLayout(Context context) {
            this$0 = PluginFullScreenHolder.this;
            super(context);
        }
    }


    PluginFullScreenHolder(WebViewClassic webviewclassic, int i, int j) {
        mWebView = webviewclassic;
        mNpp = j;
        mOrientation = i;
    }

    public void hide() {
        mWebView.getWebChromeClient().onHideCustomView();
    }

    public void setContentView(View view) {
        mLayout = new CustomFrameLayout(mWebView.getContext());
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1, 17);
        mLayout.addView(view, layoutparams);
        mLayout.setVisibility(0);
        if(view instanceof SurfaceView) {
            SurfaceView surfaceview = (SurfaceView)view;
            if(surfaceview.isFixedSize())
                surfaceview.getHolder().setSizeFromLayout();
        }
        mContentView = view;
    }

    public void show() {
        if(mWebView.getViewManager() != null)
            mWebView.getViewManager().hideAll();
        mWebView.getWebChromeClient().onShowCustomView(mLayout, mOrientation, mCallback);
    }

    private static CustomFrameLayout mLayout;
    private final WebChromeClient.CustomViewCallback mCallback = new WebChromeClient.CustomViewCallback() {

        public void onCustomViewHidden() {
            mWebView.mPrivateHandler.obtainMessage(121).sendToTarget();
            mWebView.getWebViewCore().sendMessage(182, mNpp, 0);
            PluginFullScreenHolder.mLayout.removeView(mContentView);
            PluginFullScreenHolder.mLayout = null;
            mWebView.getViewManager().showAll();
        }

        final PluginFullScreenHolder this$0;

             {
                this$0 = PluginFullScreenHolder.this;
                super();
            }
    };
    private View mContentView;
    private final int mNpp;
    private final int mOrientation;
    private final WebViewClassic mWebView;






/*
    static CustomFrameLayout access$302(CustomFrameLayout customframelayout) {
        mLayout = customframelayout;
        return customframelayout;
    }

*/
}

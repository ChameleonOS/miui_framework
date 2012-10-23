// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.content.res.Resources;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.*;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package android.webkit:
//            WebViewClassic, WebView

class ViewManager {
    class ChildView {

        private void attachViewOnUIThread() {
            mWebView.getWebView().addView(mView);
            mChildren.add(this);
            if(!mReadyToDraw)
                mView.setVisibility(8);
        }

        private void removeViewOnUIThread() {
            mWebView.getWebView().removeView(mView);
            mChildren.remove(this);
        }

        void attachView(int i, int j, int k, int l) {
            if(mView != null) {
                setBounds(i, j, k, l);
                mWebView.mPrivateHandler.post(new Runnable() {

                    public void run() {
                        requestLayout(ChildView.this);
                        if(mView.getParent() == null)
                            attachViewOnUIThread();
                    }

                    final ChildView this$1;

                 {
                    this$1 = ChildView.this;
                    super();
                }
                });
            }
        }

        void removeView() {
            if(mView != null)
                mWebView.mPrivateHandler.post(new Runnable() {

                    public void run() {
                        removeViewOnUIThread();
                    }

                    final ChildView this$1;

                 {
                    this$1 = ChildView.this;
                    super();
                }
                });
        }

        void setBounds(int i, int j, int k, int l) {
            x = i;
            y = j;
            width = k;
            height = l;
        }

        int height;
        View mView;
        final ViewManager this$0;
        int width;
        int x;
        int y;



        ChildView() {
            this$0 = ViewManager.this;
            super();
        }
    }


    ViewManager(WebViewClassic webviewclassic) {
        mZoomInProgress = false;
        mWebView = webviewclassic;
        DisplayMetrics displaymetrics = webviewclassic.getWebView().getResources().getDisplayMetrics();
        MAX_SURFACE_AREA = (int)(2.75D * (double)(displaymetrics.widthPixels * displaymetrics.heightPixels));
    }

    private void requestLayout(ChildView childview) {
        int i;
        int j;
        final SurfaceView sView;
        i = mWebView.contentToViewDimension(childview.width);
        j = mWebView.contentToViewDimension(childview.height);
        int k = mWebView.contentToViewX(childview.x);
        int l = mWebView.contentToViewY(childview.y);
        android.view.ViewGroup.LayoutParams layoutparams = childview.mView.getLayoutParams();
        android.widget.AbsoluteLayout.LayoutParams layoutparams1;
        if(layoutparams instanceof android.widget.AbsoluteLayout.LayoutParams) {
            layoutparams1 = (android.widget.AbsoluteLayout.LayoutParams)layoutparams;
            layoutparams1.width = i;
            layoutparams1.height = j;
            layoutparams1.x = k;
            layoutparams1.y = l;
        } else {
            layoutparams1 = new android.widget.AbsoluteLayout.LayoutParams(i, j, k, l);
        }
        childview.mView.setLayoutParams(layoutparams1);
        if(!(childview.mView instanceof SurfaceView)) goto _L2; else goto _L1
_L1:
        sView = (SurfaceView)childview.mView;
        if(!sView.isFixedSize() || !mZoomInProgress) goto _L3; else goto _L2
_L2:
        return;
_L3:
        int i1 = i;
        int j1 = j;
        if(i1 > 2048 || j1 > 2048)
            if(childview.width > childview.height) {
                i1 = 2048;
                j1 = (2048 * childview.height) / childview.width;
            } else {
                j1 = 2048;
                i1 = (2048 * childview.width) / childview.height;
            }
        if(i1 * j1 > MAX_SURFACE_AREA) {
            float f = MAX_SURFACE_AREA;
            if(childview.width > childview.height) {
                i1 = (int)Math.sqrt((f * (float)childview.width) / (float)childview.height);
                j1 = (i1 * childview.height) / childview.width;
            } else {
                j1 = (int)Math.sqrt((f * (float)childview.height) / (float)childview.width);
                i1 = (j1 * childview.width) / childview.height;
            }
        }
        if(i1 != i || j1 != j)
            sView.getHolder().setFixedSize(i1, j1);
        else
        if(!sView.isFixedSize() && mZoomInProgress)
            sView.getHolder().setFixedSize(sView.getWidth(), sView.getHeight());
        else
        if(sView.isFixedSize() && !mZoomInProgress)
            if(sView.getVisibility() == 0) {
                sView.setVisibility(4);
                sView.getHolder().setSizeFromLayout();
                mWebView.mPrivateHandler.post(new Runnable() {

                    public void run() {
                        sView.setVisibility(0);
                    }

                    final ViewManager this$0;
                    final SurfaceView val$sView;

             {
                this$0 = ViewManager.this;
                sView = surfaceview;
                super();
            }
                });
            } else {
                sView.getHolder().setSizeFromLayout();
            }
        if(true) goto _L2; else goto _L4
_L4:
    }

    ChildView createView() {
        return new ChildView();
    }

    void endZoom() {
        mZoomInProgress = false;
        for(Iterator iterator = mChildren.iterator(); iterator.hasNext(); requestLayout((ChildView)iterator.next()));
    }

    void hideAll() {
        if(!mHidden) {
            for(Iterator iterator = mChildren.iterator(); iterator.hasNext(); ((ChildView)iterator.next()).mView.setVisibility(8));
            mHidden = true;
        }
    }

    ChildView hitTest(int i, int j) {
        if(!mHidden) goto _L2; else goto _L1
_L1:
        ChildView childview = null;
_L4:
        return childview;
_L2:
        for(Iterator iterator = mChildren.iterator(); iterator.hasNext();) {
            childview = (ChildView)iterator.next();
            if(childview.mView.getVisibility() == 0 && i >= childview.x && i < childview.x + childview.width && j >= childview.y && j < childview.y + childview.height)
                continue; /* Loop/switch isn't completed */
        }

        childview = null;
        if(true) goto _L4; else goto _L3
_L3:
    }

    void postReadyToDrawAll() {
        mWebView.mPrivateHandler.post(new Runnable() {

            public void run() {
                mReadyToDraw = true;
                for(Iterator iterator = mChildren.iterator(); iterator.hasNext(); ((ChildView)iterator.next()).mView.setVisibility(0));
            }

            final ViewManager this$0;

             {
                this$0 = ViewManager.this;
                super();
            }
        });
    }

    void postResetStateAll() {
        mWebView.mPrivateHandler.post(new Runnable() {

            public void run() {
                mReadyToDraw = false;
            }

            final ViewManager this$0;

             {
                this$0 = ViewManager.this;
                super();
            }
        });
    }

    void scaleAll() {
        for(Iterator iterator = mChildren.iterator(); iterator.hasNext(); requestLayout((ChildView)iterator.next()));
    }

    void showAll() {
        if(mHidden) {
            for(Iterator iterator = mChildren.iterator(); iterator.hasNext(); ((ChildView)iterator.next()).mView.setVisibility(0));
            mHidden = false;
        }
    }

    void startZoom() {
        mZoomInProgress = true;
        for(Iterator iterator = mChildren.iterator(); iterator.hasNext(); requestLayout((ChildView)iterator.next()));
    }

    private static final int MAX_SURFACE_DIMENSION = 2048;
    private final int MAX_SURFACE_AREA;
    private final ArrayList mChildren = new ArrayList();
    private boolean mHidden;
    private boolean mReadyToDraw;
    private final WebViewClassic mWebView;
    private boolean mZoomInProgress;






/*
    static boolean access$402(ViewManager viewmanager, boolean flag) {
        viewmanager.mReadyToDraw = flag;
        return flag;
    }

*/
}

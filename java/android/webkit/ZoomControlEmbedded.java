// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.view.View;
import android.widget.Toast;
import android.widget.ZoomButtonsController;

// Referenced classes of package android.webkit:
//            ZoomControlBase, WebViewClassic, ZoomManager, WebSettingsClassic

class ZoomControlEmbedded
    implements ZoomControlBase {
    private class ZoomListener
        implements android.widget.ZoomButtonsController.OnZoomListener {

        public void onVisibilityChanged(boolean flag) {
            if(flag) {
                mWebView.switchOutDrawHistory();
                mZoomButtonsController.getZoomControls().setVisibility(0);
                update();
            }
        }

        public void onZoom(boolean flag) {
            if(flag)
                mWebView.zoomIn();
            else
                mWebView.zoomOut();
            update();
        }

        final ZoomControlEmbedded this$0;

        private ZoomListener() {
            this$0 = ZoomControlEmbedded.this;
            super();
        }

    }


    public ZoomControlEmbedded(ZoomManager zoommanager, WebViewClassic webviewclassic) {
        mZoomManager = zoommanager;
        mWebView = webviewclassic;
    }

    private ZoomButtonsController getControls() {
        if(mZoomButtonsController == null) {
            mZoomButtonsController = new ZoomButtonsController(mWebView.getWebView());
            mZoomButtonsController.setOnZoomListener(new ZoomListener());
            android.view.ViewGroup.LayoutParams layoutparams = mZoomButtonsController.getZoomControls().getLayoutParams();
            if(layoutparams instanceof android.widget.FrameLayout.LayoutParams)
                ((android.widget.FrameLayout.LayoutParams)layoutparams).gravity = 5;
        }
        return mZoomButtonsController;
    }

    public void hide() {
        if(mZoomButtonsController != null)
            mZoomButtonsController.setVisible(false);
    }

    public boolean isVisible() {
        boolean flag;
        if(mZoomButtonsController != null && mZoomButtonsController.isVisible())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void show() {
        if(!getControls().isVisible() && !mZoomManager.isZoomScaleFixed()) {
            mZoomButtonsController.setVisible(true);
            if(mZoomManager.isDoubleTapEnabled()) {
                WebSettingsClassic websettingsclassic = mWebView.getSettings();
                int i = websettingsclassic.getDoubleTapToastCount();
                if(mZoomManager.isInZoomOverview() && i > 0) {
                    websettingsclassic.setDoubleTapToastCount(i - 1);
                    Toast.makeText(mWebView.getContext(), 0x1040341, 1).show();
                }
            }
        }
    }

    public void update() {
        if(mZoomButtonsController != null) {
            boolean flag = mZoomManager.canZoomIn();
            boolean flag1;
            if(mZoomManager.canZoomOut() && !mZoomManager.isInZoomOverview())
                flag1 = true;
            else
                flag1 = false;
            if(!flag && !flag1) {
                mZoomButtonsController.getZoomControls().setVisibility(8);
            } else {
                mZoomButtonsController.setZoomInEnabled(flag);
                mZoomButtonsController.setZoomOutEnabled(flag1);
            }
        }
    }

    private final WebViewClassic mWebView;
    private ZoomButtonsController mZoomButtonsController;
    private final ZoomManager mZoomManager;


}

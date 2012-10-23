// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.content.Context;
import android.os.Handler;
import android.view.*;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ZoomControls;

// Referenced classes of package android.webkit:
//            ZoomControlBase, WebViewClassic

class ZoomControlExternal
    implements ZoomControlBase {
    private static class ExtendedZoomControls extends FrameLayout {

        private void fade(int i, float f, float f1) {
            AlphaAnimation alphaanimation = new AlphaAnimation(f, f1);
            alphaanimation.setDuration(500L);
            startAnimation(alphaanimation);
            setVisibility(i);
        }

        public boolean hasFocus() {
            return mPlusMinusZoomControls.hasFocus();
        }

        public void hide() {
            fade(8, 1.0F, 0.0F);
        }

        public void setOnZoomInClickListener(android.view.View.OnClickListener onclicklistener) {
            mPlusMinusZoomControls.setOnZoomInClickListener(onclicklistener);
        }

        public void setOnZoomOutClickListener(android.view.View.OnClickListener onclicklistener) {
            mPlusMinusZoomControls.setOnZoomOutClickListener(onclicklistener);
        }

        public void show(boolean flag) {
            ZoomControls zoomcontrols = mPlusMinusZoomControls;
            int i;
            if(flag)
                i = 0;
            else
                i = 8;
            zoomcontrols.setVisibility(i);
            fade(0, 0.0F, 1.0F);
        }

        private ZoomControls mPlusMinusZoomControls;

        public ExtendedZoomControls(Context context) {
            super(context, null);
            ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x10900ce, this, true);
            mPlusMinusZoomControls = (ZoomControls)findViewById(0x1020368);
            findViewById(0x102036b).setVisibility(8);
        }
    }


    public ZoomControlExternal(WebViewClassic webviewclassic) {
        mWebView = webviewclassic;
    }

    private ExtendedZoomControls createZoomControls() {
        ExtendedZoomControls extendedzoomcontrols = new ExtendedZoomControls(mWebView.getContext());
        extendedzoomcontrols.setOnZoomInClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view) {
                mPrivateHandler.removeCallbacks(mZoomControlRunnable);
                mPrivateHandler.postDelayed(mZoomControlRunnable, ZoomControlExternal.ZOOM_CONTROLS_TIMEOUT);
                mWebView.zoomIn();
            }

            final ZoomControlExternal this$0;

             {
                this$0 = ZoomControlExternal.this;
                super();
            }
        });
        extendedzoomcontrols.setOnZoomOutClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view) {
                mPrivateHandler.removeCallbacks(mZoomControlRunnable);
                mPrivateHandler.postDelayed(mZoomControlRunnable, ZoomControlExternal.ZOOM_CONTROLS_TIMEOUT);
                mWebView.zoomOut();
            }

            final ZoomControlExternal this$0;

             {
                this$0 = ZoomControlExternal.this;
                super();
            }
        });
        return extendedzoomcontrols;
    }

    public ExtendedZoomControls getControls() {
        if(mZoomControls == null) {
            mZoomControls = createZoomControls();
            mZoomControls.setVisibility(0);
            mZoomControlRunnable = new Runnable() {

                public void run() {
                    if(!mZoomControls.hasFocus()) {
                        mZoomControls.hide();
                    } else {
                        mPrivateHandler.removeCallbacks(mZoomControlRunnable);
                        mPrivateHandler.postDelayed(mZoomControlRunnable, ZoomControlExternal.ZOOM_CONTROLS_TIMEOUT);
                    }
                }

                final ZoomControlExternal this$0;

             {
                this$0 = ZoomControlExternal.this;
                super();
            }
            };
        }
        return mZoomControls;
    }

    public void hide() {
        if(mZoomControlRunnable != null)
            mPrivateHandler.removeCallbacks(mZoomControlRunnable);
        if(mZoomControls != null)
            mZoomControls.hide();
    }

    public boolean isVisible() {
        boolean flag;
        if(mZoomControls != null && mZoomControls.isShown())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void show() {
        if(mZoomControlRunnable != null)
            mPrivateHandler.removeCallbacks(mZoomControlRunnable);
        getControls().show(true);
        mPrivateHandler.postDelayed(mZoomControlRunnable, ZOOM_CONTROLS_TIMEOUT);
    }

    public void update() {
    }

    private static final long ZOOM_CONTROLS_TIMEOUT = ViewConfiguration.getZoomControlsTimeout();
    private final Handler mPrivateHandler = new Handler();
    private final WebViewClassic mWebView;
    private Runnable mZoomControlRunnable;
    private ExtendedZoomControls mZoomControls;






}

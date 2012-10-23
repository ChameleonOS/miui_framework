// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.*;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.*;

// Referenced classes of package android.widget:
//            FrameLayout, ZoomControls

public class ZoomButtonsController
    implements android.view.View.OnTouchListener {
    private class Container extends FrameLayout {

        public boolean dispatchKeyEvent(KeyEvent keyevent) {
            boolean flag;
            if(onContainerKey(keyevent))
                flag = true;
            else
                flag = super.dispatchKeyEvent(keyevent);
            return flag;
        }

        final ZoomButtonsController this$0;

        public Container(Context context) {
            this$0 = ZoomButtonsController.this;
            super(context);
        }
    }

    public static interface OnZoomListener {

        public abstract void onVisibilityChanged(boolean flag);

        public abstract void onZoom(boolean flag);
    }


    public ZoomButtonsController(View view) {
        mAutoDismissControls = true;
        mContext = view.getContext();
        mWindowManager = (WindowManager)mContext.getSystemService("window");
        mOwnerView = view;
        mTouchPaddingScaledSq = (int)(20F * mContext.getResources().getDisplayMetrics().density);
        mTouchPaddingScaledSq = mTouchPaddingScaledSq * mTouchPaddingScaledSq;
    }

    private FrameLayout createContainer() {
        android.view.WindowManager.LayoutParams layoutparams = new android.view.WindowManager.LayoutParams(-2, -2);
        layoutparams.gravity = 51;
        layoutparams.flags = 0x20218;
        layoutparams.height = -2;
        layoutparams.width = -1;
        layoutparams.type = 1000;
        layoutparams.format = -3;
        layoutparams.windowAnimations = 0x10301e7;
        mContainerLayoutParams = layoutparams;
        Container container = new Container(mContext);
        container.setLayoutParams(layoutparams);
        container.setMeasureAllChildren(true);
        ((LayoutInflater)mContext.getSystemService("layout_inflater")).inflate(0x10900cc, container);
        mControls = (ZoomControls)container.findViewById(0x102036d);
        mControls.setOnZoomInClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view) {
                dismissControlsDelayed(ZoomButtonsController.ZOOM_CONTROLS_TIMEOUT);
                if(mCallback != null)
                    mCallback.onZoom(true);
            }

            final ZoomButtonsController this$0;

             {
                this$0 = ZoomButtonsController.this;
                super();
            }
        });
        mControls.setOnZoomOutClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view) {
                dismissControlsDelayed(ZoomButtonsController.ZOOM_CONTROLS_TIMEOUT);
                if(mCallback != null)
                    mCallback.onZoom(false);
            }

            final ZoomButtonsController this$0;

             {
                this$0 = ZoomButtonsController.this;
                super();
            }
        });
        return container;
    }

    private void dismissControlsDelayed(int i) {
        if(mAutoDismissControls) {
            mHandler.removeMessages(3);
            mHandler.sendEmptyMessageDelayed(3, i);
        }
    }

    private View findViewForTouch(int i, int j) {
        int k;
        int l;
        Rect rect;
        View view;
        int i1;
        int j1;
        k = i - mContainerRawLocation[0];
        l = j - mContainerRawLocation[1];
        rect = mTempRect;
        view = null;
        i1 = 0x7fffffff;
        j1 = -1 + mContainer.getChildCount();
_L2:
        View view1;
        if(j1 < 0)
            break MISSING_BLOCK_LABEL_238;
        view1 = mContainer.getChildAt(j1);
        if(view1.getVisibility() == 0)
            break; /* Loop/switch isn't completed */
_L5:
        j1--;
        if(true) goto _L2; else goto _L1
_L1:
        view1.getHitRect(rect);
        if(!rect.contains(k, l)) goto _L4; else goto _L3
_L3:
        return view1;
_L4:
        int k1;
        int l1;
        int i2;
        if(k >= rect.left && k <= rect.right)
            k1 = 0;
        else
            k1 = Math.min(Math.abs(rect.left - k), Math.abs(k - rect.right));
        if(l >= rect.top && l <= rect.bottom)
            l1 = 0;
        else
            l1 = Math.min(Math.abs(rect.top - l), Math.abs(l - rect.bottom));
        i2 = k1 * k1 + l1 * l1;
        if(i2 < mTouchPaddingScaledSq && i2 < i1) {
            view = view1;
            i1 = i2;
        }
          goto _L5
        view1 = view;
          goto _L3
    }

    private boolean isInterestingKey(int i) {
        i;
        JVM INSTR lookupswitch 7: default 68
    //                   4: 72
    //                   19: 72
    //                   20: 72
    //                   21: 72
    //                   22: 72
    //                   23: 72
    //                   66: 72;
           goto _L1 _L2 _L2 _L2 _L2 _L2 _L2 _L2
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = true;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private boolean onContainerKey(KeyEvent keyevent) {
        boolean flag;
        int i;
        flag = true;
        i = keyevent.getKeyCode();
        if(!isInterestingKey(i)) goto _L2; else goto _L1
_L1:
        if(i != 4) goto _L4; else goto _L3
_L3:
        if(keyevent.getAction() != 0 || keyevent.getRepeatCount() != 0) goto _L6; else goto _L5
_L5:
        if(mOwnerView != null) {
            android.view.KeyEvent.DispatcherState dispatcherstate = mOwnerView.getKeyDispatcherState();
            if(dispatcherstate != null)
                dispatcherstate.startTracking(keyevent, this);
        }
_L9:
        return flag;
_L6:
        if(keyevent.getAction() == flag && keyevent.isTracking() && !keyevent.isCanceled()) {
            setVisible(false);
            continue; /* Loop/switch isn't completed */
        }
          goto _L7
_L4:
        dismissControlsDelayed(ZOOM_CONTROLS_TIMEOUT);
_L7:
        flag = false;
        continue; /* Loop/switch isn't completed */
_L2:
        ViewRootImpl viewrootimpl = mOwnerView.getViewRootImpl();
        if(viewrootimpl != null)
            viewrootimpl.dispatchKey(keyevent);
        if(true) goto _L9; else goto _L8
_L8:
    }

    private void onPostConfigurationChanged() {
        dismissControlsDelayed(ZOOM_CONTROLS_TIMEOUT);
        refreshPositioningVariables();
    }

    private void refreshPositioningVariables() {
        if(mOwnerView.getWindowToken() != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i = mOwnerView.getHeight();
        int j = mOwnerView.getWidth();
        int k = i - mContainer.getHeight();
        mOwnerView.getLocationOnScreen(mOwnerViewRawLocation);
        mContainerRawLocation[0] = mOwnerViewRawLocation[0];
        mContainerRawLocation[1] = k + mOwnerViewRawLocation[1];
        int ai[] = mTempIntArray;
        mOwnerView.getLocationInWindow(ai);
        mContainerLayoutParams.x = ai[0];
        mContainerLayoutParams.width = j;
        mContainerLayoutParams.y = k + ai[1];
        if(mIsVisible)
            mWindowManager.updateViewLayout(mContainer, mContainerLayoutParams);
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void setTouchTargetView(View view) {
        mTouchTargetView = view;
        if(view != null)
            view.getLocationInWindow(mTouchTargetWindowLocation);
    }

    public ViewGroup getContainer() {
        return mContainer;
    }

    public View getZoomControls() {
        return mControls;
    }

    public boolean isAutoDismissed() {
        return mAutoDismissControls;
    }

    public boolean isVisible() {
        return mIsVisible;
    }

    public boolean onTouch(View view, MotionEvent motionevent) {
        boolean flag;
        int i;
        flag = false;
        i = motionevent.getAction();
        if(motionevent.getPointerCount() <= 1) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        View view1;
        if(mReleaseTouchListenerOnUp) {
            if(i == 1 || i == 3) {
                mOwnerView.setOnTouchListener(null);
                setTouchTargetView(null);
                mReleaseTouchListenerOnUp = false;
            }
            flag = true;
            continue; /* Loop/switch isn't completed */
        }
        dismissControlsDelayed(ZOOM_CONTROLS_TIMEOUT);
        view1 = mTouchTargetView;
        switch(i) {
        case 2: // '\002'
        default:
            break;

        case 0: // '\0'
            break; /* Loop/switch isn't completed */

        case 1: // '\001'
        case 3: // '\003'
            break;
        }
        break MISSING_BLOCK_LABEL_275;
_L4:
        if(view1 != null) {
            int j = mContainerRawLocation[0] + mTouchTargetWindowLocation[0];
            int k = mContainerRawLocation[1] + mTouchTargetWindowLocation[1];
            MotionEvent motionevent1 = MotionEvent.obtain(motionevent);
            motionevent1.offsetLocation(mOwnerViewRawLocation[0] - j, mOwnerViewRawLocation[1] - k);
            float f = motionevent1.getX();
            float f1 = motionevent1.getY();
            if(f < 0.0F && f > -20F)
                motionevent1.offsetLocation(-f, 0.0F);
            if(f1 < 0.0F && f1 > -20F)
                motionevent1.offsetLocation(0.0F, -f1);
            flag = view1.dispatchTouchEvent(motionevent1);
            motionevent1.recycle();
        }
        if(true) goto _L1; else goto _L3
_L3:
        view1 = findViewForTouch((int)motionevent.getRawX(), (int)motionevent.getRawY());
        setTouchTargetView(view1);
          goto _L4
        setTouchTargetView(null);
          goto _L4
    }

    public void setAutoDismissed(boolean flag) {
        if(mAutoDismissControls != flag)
            mAutoDismissControls = flag;
    }

    public void setFocusable(boolean flag) {
        int i = mContainerLayoutParams.flags;
        if(flag) {
            android.view.WindowManager.LayoutParams layoutparams1 = mContainerLayoutParams;
            layoutparams1.flags = -9 & layoutparams1.flags;
        } else {
            android.view.WindowManager.LayoutParams layoutparams = mContainerLayoutParams;
            layoutparams.flags = 8 | layoutparams.flags;
        }
        if(mContainerLayoutParams.flags != i && mIsVisible)
            mWindowManager.updateViewLayout(mContainer, mContainerLayoutParams);
    }

    public void setOnZoomListener(OnZoomListener onzoomlistener) {
        mCallback = onzoomlistener;
    }

    public void setVisible(boolean flag) {
        if(!flag) goto _L2; else goto _L1
_L1:
        if(mOwnerView.getWindowToken() != null) goto _L4; else goto _L3
_L3:
        if(!mHandler.hasMessages(4))
            mHandler.sendEmptyMessage(4);
_L6:
        return;
_L4:
        dismissControlsDelayed(ZOOM_CONTROLS_TIMEOUT);
_L2:
        if(mIsVisible != flag) {
            mIsVisible = flag;
            if(flag) {
                if(mContainerLayoutParams.token == null)
                    mContainerLayoutParams.token = mOwnerView.getWindowToken();
                mWindowManager.addView(mContainer, mContainerLayoutParams);
                if(mPostedVisibleInitializer == null)
                    mPostedVisibleInitializer = new Runnable() {

                        public void run() {
                            refreshPositioningVariables();
                            if(mCallback != null)
                                mCallback.onVisibilityChanged(true);
                        }

                        final ZoomButtonsController this$0;

             {
                this$0 = ZoomButtonsController.this;
                super();
            }
                    };
                mHandler.post(mPostedVisibleInitializer);
                mContext.registerReceiver(mConfigurationChangedReceiver, mConfigurationChangedFilter);
                mOwnerView.setOnTouchListener(this);
                mReleaseTouchListenerOnUp = false;
            } else {
                if(mTouchTargetView != null)
                    mReleaseTouchListenerOnUp = true;
                else
                    mOwnerView.setOnTouchListener(null);
                mContext.unregisterReceiver(mConfigurationChangedReceiver);
                mWindowManager.removeView(mContainer);
                mHandler.removeCallbacks(mPostedVisibleInitializer);
                if(mCallback != null)
                    mCallback.onVisibilityChanged(false);
            }
        }
        if(true) goto _L6; else goto _L5
_L5:
    }

    public void setZoomInEnabled(boolean flag) {
        mControls.setIsZoomInEnabled(flag);
    }

    public void setZoomOutEnabled(boolean flag) {
        mControls.setIsZoomOutEnabled(flag);
    }

    public void setZoomSpeed(long l) {
        mControls.setZoomSpeed(l);
    }

    private static final int MSG_DISMISS_ZOOM_CONTROLS = 3;
    private static final int MSG_POST_CONFIGURATION_CHANGED = 2;
    private static final int MSG_POST_SET_VISIBLE = 4;
    private static final String TAG = "ZoomButtonsController";
    private static final int ZOOM_CONTROLS_TIMEOUT = 0;
    private static final int ZOOM_CONTROLS_TOUCH_PADDING = 20;
    private boolean mAutoDismissControls;
    private OnZoomListener mCallback;
    private final IntentFilter mConfigurationChangedFilter = new IntentFilter("android.intent.action.CONFIGURATION_CHANGED");
    private final BroadcastReceiver mConfigurationChangedReceiver = new BroadcastReceiver() {

        public void onReceive(Context context, Intent intent) {
            if(mIsVisible) {
                mHandler.removeMessages(2);
                mHandler.sendEmptyMessage(2);
            }
        }

        final ZoomButtonsController this$0;

             {
                this$0 = ZoomButtonsController.this;
                super();
            }
    };
    private final FrameLayout mContainer = createContainer();
    private android.view.WindowManager.LayoutParams mContainerLayoutParams;
    private final int mContainerRawLocation[] = new int[2];
    private final Context mContext;
    private ZoomControls mControls;
    private final Handler mHandler = new Handler() {

        public void handleMessage(Message message) {
            message.what;
            JVM INSTR tableswitch 2 4: default 32
        //                       2 33
        //                       3 43
        //                       4 54;
               goto _L1 _L2 _L3 _L4
_L1:
            return;
_L2:
            onPostConfigurationChanged();
            continue; /* Loop/switch isn't completed */
_L3:
            setVisible(false);
            continue; /* Loop/switch isn't completed */
_L4:
            if(mOwnerView.getWindowToken() == null)
                Log.e("ZoomButtonsController", "Cannot make the zoom controller visible if the owner view is not attached to a window.");
            else
                setVisible(true);
            if(true) goto _L1; else goto _L5
_L5:
        }

        final ZoomButtonsController this$0;

             {
                this$0 = ZoomButtonsController.this;
                super();
            }
    };
    private boolean mIsVisible;
    private final View mOwnerView;
    private final int mOwnerViewRawLocation[] = new int[2];
    private Runnable mPostedVisibleInitializer;
    private boolean mReleaseTouchListenerOnUp;
    private final int mTempIntArray[] = new int[2];
    private final Rect mTempRect = new Rect();
    private int mTouchPaddingScaledSq;
    private View mTouchTargetView;
    private final int mTouchTargetWindowLocation[] = new int[2];
    private final WindowManager mWindowManager;

    static  {
        ZOOM_CONTROLS_TIMEOUT = (int)ViewConfiguration.getZoomControlsTimeout();
    }









}

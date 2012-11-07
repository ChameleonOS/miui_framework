// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.app.INotificationManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.*;
import android.view.*;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;

// Referenced classes of package android.widget:
//            TextView

public class Toast {
    private static class TN extends android.app.ITransientNotification.Stub {

        private void trySendAccessibilityEvent() {
            AccessibilityManager accessibilitymanager = AccessibilityManager.getInstance(mView.getContext());
            if(accessibilitymanager.isEnabled()) {
                AccessibilityEvent accessibilityevent = AccessibilityEvent.obtain(64);
                accessibilityevent.setClassName(getClass().getName());
                accessibilityevent.setPackageName(mView.getContext().getPackageName());
                mView.dispatchPopulateAccessibilityEvent(accessibilityevent);
                accessibilitymanager.sendAccessibilityEvent(accessibilityevent);
            }
        }

        android.view.WindowManager.LayoutParams getParams() {
            return mParams;
        }

        public void handleHide() {
            if(mView != null) {
                if(mView.getParent() != null)
                    mWM.removeView(mView);
                mView = null;
            }
        }

        public void handleShow() {
            if(mView != mNextView) {
                handleHide();
                mView = mNextView;
                mWM = WindowManagerImpl.getDefault();
                int i = mGravity;
                mParams.gravity = i;
                if((i & 7) == 7)
                    mParams.horizontalWeight = 1.0F;
                if((i & 0x70) == 112)
                    mParams.verticalWeight = 1.0F;
                mParams.x = mX;
                mParams.y = mY;
                mParams.verticalMargin = mVerticalMargin;
                mParams.horizontalMargin = mHorizontalMargin;
                if(mView.getParent() != null)
                    mWM.removeView(mView);
                mWM.addView(mView, mParams);
                trySendAccessibilityEvent();
            }
        }

        public void hide() {
            mHandler.post(mHide);
        }

        public void show() {
            mHandler.post(mShow);
        }

        int mGravity;
        final Handler mHandler = new Handler();
        final Runnable mHide = new Runnable() {

            public void run() {
                handleHide();
                mNextView = null;
            }

            final TN this$0;

                 {
                    this$0 = TN.this;
                    super();
                }
        };
        float mHorizontalMargin;
        View mNextView;
        private final android.view.WindowManager.LayoutParams mParams = new android.view.WindowManager.LayoutParams();
        final Runnable mShow = new Runnable() {

            public void run() {
                handleShow();
            }

            final TN this$0;

                 {
                    this$0 = TN.this;
                    super();
                }
        };
        float mVerticalMargin;
        View mView;
        WindowManagerImpl mWM;
        int mX;
        int mY;

        TN() {
            mGravity = 81;
            android.view.WindowManager.LayoutParams layoutparams = mParams;
            layoutparams.height = -2;
            layoutparams.width = -2;
            layoutparams.flags = 152;
            layoutparams.format = -3;
            layoutparams.windowAnimations = 0x1030004;
            layoutparams.type = 2005;
            layoutparams.setTitle("Toast");
        }
    }


    public Toast(Context context) {
        mContext = context;
        mTN.mY = context.getResources().getDimensionPixelSize(0x1050009);
    }

    private static INotificationManager getService() {
        INotificationManager inotificationmanager;
        if(sService != null) {
            inotificationmanager = sService;
        } else {
            sService = android.app.INotificationManager.Stub.asInterface(ServiceManager.getService("notification"));
            inotificationmanager = sService;
        }
        return inotificationmanager;
    }

    public static Toast makeText(Context context, int i, int j) throws android.content.res.Resources.NotFoundException {
        return makeText(context, context.getResources().getText(i), j);
    }

    public static Toast makeText(Context context, CharSequence charsequence, int i) {
        Toast toast = new Toast(context);
        View view = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x10900bf, null);
        ((TextView)view.findViewById(0x102000b)).setText(charsequence);
        toast.mNextView = view;
        toast.mDuration = i;
        return toast;
    }

    public void cancel() {
        mTN.hide();
        getService().cancelToast(mContext.getPackageName(), mTN);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int getDuration() {
        return mDuration;
    }

    public int getGravity() {
        return mTN.mGravity;
    }

    public float getHorizontalMargin() {
        return mTN.mHorizontalMargin;
    }

    public float getVerticalMargin() {
        return mTN.mVerticalMargin;
    }

    public View getView() {
        return mNextView;
    }

    public int getXOffset() {
        return mTN.mX;
    }

    public int getYOffset() {
        return mTN.mY;
    }

    public void setDuration(int i) {
        mDuration = i;
    }

    public void setGravity(int i, int j, int k) {
        mTN.mGravity = i;
        mTN.mX = j;
        mTN.mY = k;
    }

    public void setMargin(float f, float f1) {
        mTN.mHorizontalMargin = f;
        mTN.mVerticalMargin = f1;
    }

    public void setText(int i) {
        setText(mContext.getText(i));
    }

    public void setText(CharSequence charsequence) {
        if(mNextView == null)
            throw new RuntimeException("This Toast was not created with Toast.makeText()");
        TextView textview = (TextView)mNextView.findViewById(0x102000b);
        if(textview == null) {
            throw new RuntimeException("This Toast was not created with Toast.makeText()");
        } else {
            textview.setText(charsequence);
            return;
        }
    }

    public void setType(int i) {
        mTN.getParams().type = i;
    }

    public void setView(View view) {
        mNextView = view;
    }

    public void show() {
        INotificationManager inotificationmanager;
        String s;
        TN tn;
        if(mNextView == null)
            throw new RuntimeException("setView must have been called");
        inotificationmanager = getService();
        s = mContext.getPackageName();
        tn = mTN;
        tn.mNextView = mNextView;
        inotificationmanager.enqueueToast(s, tn, mDuration);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static final int LENGTH_LONG = 1;
    public static final int LENGTH_SHORT = 0;
    static final String TAG = "Toast";
    static final boolean localLOGV;
    private static INotificationManager sService;
    final Context mContext;
    int mDuration;
    View mNextView;
    final TN mTN = new TN();
}

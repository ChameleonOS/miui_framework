// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.*;
import android.view.View;

public class ActivityOptions {
    public static interface OnAnimationStartedListener {

        public abstract void onAnimationStarted();
    }


    private ActivityOptions() {
        mAnimationType = 0;
    }

    public ActivityOptions(Bundle bundle) {
        mAnimationType = 0;
        mPackageName = bundle.getString("android:packageName");
        mAnimationType = bundle.getInt("android:animType");
        if(mAnimationType != 1) goto _L2; else goto _L1
_L1:
        mCustomEnterResId = bundle.getInt("android:animEnterRes", 0);
        mCustomExitResId = bundle.getInt("android:animExitRes", 0);
        mAnimationStartedListener = android.os.IRemoteCallback.Stub.asInterface(bundle.getIBinder("android:animStartListener"));
_L4:
        return;
_L2:
        if(mAnimationType == 2) {
            mStartX = bundle.getInt("android:animStartX", 0);
            mStartY = bundle.getInt("android:animStartY", 0);
            mStartWidth = bundle.getInt("android:animStartWidth", 0);
            mStartHeight = bundle.getInt("android:animStartHeight", 0);
        } else
        if(mAnimationType == 3 || mAnimationType == 4) {
            mThumbnail = (Bitmap)bundle.getParcelable("android:animThumbnail");
            mStartX = bundle.getInt("android:animStartX", 0);
            mStartY = bundle.getInt("android:animStartY", 0);
            mAnimationStartedListener = android.os.IRemoteCallback.Stub.asInterface(bundle.getIBinder("android:animStartListener"));
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static void abort(Bundle bundle) {
        if(bundle != null)
            (new ActivityOptions(bundle)).abort();
    }

    public static ActivityOptions makeCustomAnimation(Context context, int i, int j) {
        return makeCustomAnimation(context, i, j, null, null);
    }

    public static ActivityOptions makeCustomAnimation(Context context, int i, int j, Handler handler, OnAnimationStartedListener onanimationstartedlistener) {
        ActivityOptions activityoptions = new ActivityOptions();
        activityoptions.mPackageName = context.getPackageName();
        activityoptions.mAnimationType = 1;
        activityoptions.mCustomEnterResId = i;
        activityoptions.mCustomExitResId = j;
        activityoptions.setListener(handler, onanimationstartedlistener);
        return activityoptions;
    }

    public static ActivityOptions makeDelayedThumbnailScaleUpAnimation(View view, Bitmap bitmap, int i, int j, OnAnimationStartedListener onanimationstartedlistener) {
        return makeThumbnailScaleUpAnimation(view, bitmap, i, j, onanimationstartedlistener, true);
    }

    public static ActivityOptions makeScaleUpAnimation(View view, int i, int j, int k, int l) {
        ActivityOptions activityoptions = new ActivityOptions();
        activityoptions.mPackageName = view.getContext().getPackageName();
        activityoptions.mAnimationType = 2;
        int ai[] = new int[2];
        view.getLocationOnScreen(ai);
        activityoptions.mStartX = i + ai[0];
        activityoptions.mStartY = j + ai[1];
        activityoptions.mStartWidth = k;
        activityoptions.mStartHeight = l;
        return activityoptions;
    }

    public static ActivityOptions makeThumbnailScaleUpAnimation(View view, Bitmap bitmap, int i, int j) {
        return makeThumbnailScaleUpAnimation(view, bitmap, i, j, null);
    }

    public static ActivityOptions makeThumbnailScaleUpAnimation(View view, Bitmap bitmap, int i, int j, OnAnimationStartedListener onanimationstartedlistener) {
        return makeThumbnailScaleUpAnimation(view, bitmap, i, j, onanimationstartedlistener, false);
    }

    private static ActivityOptions makeThumbnailScaleUpAnimation(View view, Bitmap bitmap, int i, int j, OnAnimationStartedListener onanimationstartedlistener, boolean flag) {
        ActivityOptions activityoptions = new ActivityOptions();
        activityoptions.mPackageName = view.getContext().getPackageName();
        int k;
        int ai[];
        if(flag)
            k = 4;
        else
            k = 3;
        activityoptions.mAnimationType = k;
        activityoptions.mThumbnail = bitmap;
        ai = new int[2];
        view.getLocationOnScreen(ai);
        activityoptions.mStartX = i + ai[0];
        activityoptions.mStartY = j + ai[1];
        activityoptions.setListener(view.getHandler(), onanimationstartedlistener);
        return activityoptions;
    }

    private void setListener(final Handler h, final OnAnimationStartedListener finalListener) {
        if(finalListener != null)
            mAnimationStartedListener = new android.os.IRemoteCallback.Stub() {

                public void sendResult(Bundle bundle) throws RemoteException {
                    h.post(new Runnable() {

                        public void run() {
                            finalListener.onAnimationStarted();
                        }

                        final _cls1 this$1;

                     {
                        this$1 = _cls1.this;
                        super();
                    }
                    });
                }

                final ActivityOptions this$0;
                final OnAnimationStartedListener val$finalListener;
                final Handler val$h;

             {
                this$0 = ActivityOptions.this;
                h = handler;
                finalListener = onanimationstartedlistener;
                super();
            }
            };
    }

    public void abort() {
        if(mAnimationStartedListener == null)
            break MISSING_BLOCK_LABEL_17;
        mAnimationStartedListener.sendResult(null);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int getAnimationType() {
        return mAnimationType;
    }

    public int getCustomEnterResId() {
        return mCustomEnterResId;
    }

    public int getCustomExitResId() {
        return mCustomExitResId;
    }

    public IRemoteCallback getOnAnimationStartListener() {
        return mAnimationStartedListener;
    }

    public String getPackageName() {
        return mPackageName;
    }

    public int getStartHeight() {
        return mStartHeight;
    }

    public int getStartWidth() {
        return mStartWidth;
    }

    public int getStartX() {
        return mStartX;
    }

    public int getStartY() {
        return mStartY;
    }

    public Bitmap getThumbnail() {
        return mThumbnail;
    }

    public Bundle toBundle() {
        android.os.IBinder ibinder;
        Bundle bundle;
        ibinder = null;
        bundle = new Bundle();
        if(mPackageName != null)
            bundle.putString("android:packageName", mPackageName);
        mAnimationType;
        JVM INSTR tableswitch 1 4: default 60
    //                   1 62
    //                   2 119
    //                   3 172
    //                   4 172;
           goto _L1 _L2 _L3 _L4 _L4
_L1:
        return bundle;
_L2:
        bundle.putInt("android:animType", mAnimationType);
        bundle.putInt("android:animEnterRes", mCustomEnterResId);
        bundle.putInt("android:animExitRes", mCustomExitResId);
        if(mAnimationStartedListener != null)
            ibinder = mAnimationStartedListener.asBinder();
        bundle.putIBinder("android:animStartListener", ibinder);
        continue; /* Loop/switch isn't completed */
_L3:
        bundle.putInt("android:animType", mAnimationType);
        bundle.putInt("android:animStartX", mStartX);
        bundle.putInt("android:animStartY", mStartY);
        bundle.putInt("android:animStartWidth", mStartWidth);
        bundle.putInt("android:animStartHeight", mStartHeight);
        continue; /* Loop/switch isn't completed */
_L4:
        bundle.putInt("android:animType", mAnimationType);
        bundle.putParcelable("android:animThumbnail", mThumbnail);
        bundle.putInt("android:animStartX", mStartX);
        bundle.putInt("android:animStartY", mStartY);
        if(mAnimationStartedListener != null)
            ibinder = mAnimationStartedListener.asBinder();
        bundle.putIBinder("android:animStartListener", ibinder);
        if(true) goto _L1; else goto _L5
_L5:
    }

    public void update(ActivityOptions activityoptions) {
        if(activityoptions.mPackageName != null)
            mPackageName = activityoptions.mPackageName;
        activityoptions.mAnimationType;
        JVM INSTR tableswitch 1 4: default 48
    //                   1 49
    //                   2 106
    //                   3 171
    //                   4 171;
           goto _L1 _L2 _L3 _L4 _L4
_L1:
        return;
_L2:
        mAnimationType = activityoptions.mAnimationType;
        mCustomEnterResId = activityoptions.mCustomEnterResId;
        mCustomExitResId = activityoptions.mCustomExitResId;
        mThumbnail = null;
        RemoteException remoteexception;
        RemoteException remoteexception1;
        if(activityoptions.mAnimationStartedListener != null)
            try {
                activityoptions.mAnimationStartedListener.sendResult(null);
            }
            catch(RemoteException remoteexception2) { }
        mAnimationStartedListener = activityoptions.mAnimationStartedListener;
        continue; /* Loop/switch isn't completed */
_L3:
        mAnimationType = activityoptions.mAnimationType;
        mStartX = activityoptions.mStartX;
        mStartY = activityoptions.mStartY;
        mStartWidth = activityoptions.mStartWidth;
        mStartHeight = activityoptions.mStartHeight;
        if(activityoptions.mAnimationStartedListener != null)
            try {
                activityoptions.mAnimationStartedListener.sendResult(null);
            }
            // Misplaced declaration of an exception variable
            catch(RemoteException remoteexception1) { }
        mAnimationStartedListener = null;
        continue; /* Loop/switch isn't completed */
_L4:
        mAnimationType = activityoptions.mAnimationType;
        mThumbnail = activityoptions.mThumbnail;
        mStartX = activityoptions.mStartX;
        mStartY = activityoptions.mStartY;
        if(activityoptions.mAnimationStartedListener != null)
            try {
                activityoptions.mAnimationStartedListener.sendResult(null);
            }
            // Misplaced declaration of an exception variable
            catch(RemoteException remoteexception) { }
        mAnimationStartedListener = activityoptions.mAnimationStartedListener;
        if(true) goto _L1; else goto _L5
_L5:
    }

    public static final int ANIM_CUSTOM = 1;
    public static final int ANIM_NONE = 0;
    public static final int ANIM_SCALE_UP = 2;
    public static final int ANIM_THUMBNAIL = 3;
    public static final int ANIM_THUMBNAIL_DELAYED = 4;
    public static final String KEY_ANIM_ENTER_RES_ID = "android:animEnterRes";
    public static final String KEY_ANIM_EXIT_RES_ID = "android:animExitRes";
    public static final String KEY_ANIM_START_HEIGHT = "android:animStartHeight";
    public static final String KEY_ANIM_START_LISTENER = "android:animStartListener";
    public static final String KEY_ANIM_START_WIDTH = "android:animStartWidth";
    public static final String KEY_ANIM_START_X = "android:animStartX";
    public static final String KEY_ANIM_START_Y = "android:animStartY";
    public static final String KEY_ANIM_THUMBNAIL = "android:animThumbnail";
    public static final String KEY_ANIM_TYPE = "android:animType";
    public static final String KEY_PACKAGE_NAME = "android:packageName";
    private IRemoteCallback mAnimationStartedListener;
    private int mAnimationType;
    private int mCustomEnterResId;
    private int mCustomExitResId;
    private String mPackageName;
    private int mStartHeight;
    private int mStartWidth;
    private int mStartX;
    private int mStartY;
    private Bitmap mThumbnail;
}

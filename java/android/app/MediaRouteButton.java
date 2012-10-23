// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.media.MediaRouter;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.android.internal.app.MediaRouteChooserDialogFragment;

// Referenced classes of package android.app:
//            Activity, FragmentManager

public class MediaRouteButton extends View {
    private class MediaRouteCallback extends android.media.MediaRouter.SimpleCallback {

        public void onRouteAdded(MediaRouter mediarouter, android.media.MediaRouter.RouteInfo routeinfo) {
            updateRouteCount();
        }

        public void onRouteGrouped(MediaRouter mediarouter, android.media.MediaRouter.RouteInfo routeinfo, android.media.MediaRouter.RouteGroup routegroup, int i) {
            updateRouteCount();
        }

        public void onRouteRemoved(MediaRouter mediarouter, android.media.MediaRouter.RouteInfo routeinfo) {
            updateRouteCount();
        }

        public void onRouteSelected(MediaRouter mediarouter, int i, android.media.MediaRouter.RouteInfo routeinfo) {
            updateRemoteIndicator();
        }

        public void onRouteUngrouped(MediaRouter mediarouter, android.media.MediaRouter.RouteInfo routeinfo, android.media.MediaRouter.RouteGroup routegroup) {
            updateRouteCount();
        }

        public void onRouteUnselected(MediaRouter mediarouter, int i, android.media.MediaRouter.RouteInfo routeinfo) {
            updateRemoteIndicator();
        }

        final MediaRouteButton this$0;

        private MediaRouteCallback() {
            this$0 = MediaRouteButton.this;
            super();
        }

    }


    public MediaRouteButton(Context context) {
        this(context, null);
    }

    public MediaRouteButton(Context context, AttributeSet attributeset) {
        this(context, null, 0x10103ad);
    }

    public MediaRouteButton(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        mRouterCallback = new MediaRouteCallback();
        mRouter = (MediaRouter)context.getSystemService("media_router");
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.MediaRouteButton, i, 0);
        setRemoteIndicatorDrawable(typedarray.getDrawable(3));
        mMinWidth = typedarray.getDimensionPixelSize(0, 0);
        mMinHeight = typedarray.getDimensionPixelSize(1, 0);
        int j = typedarray.getInteger(2, 1);
        typedarray.recycle();
        setClickable(true);
        setRouteTypes(j);
    }

    private Activity getActivity() {
        Context context;
        for(context = getContext(); (context instanceof ContextWrapper) && !(context instanceof Activity); context = ((ContextWrapper)context).getBaseContext());
        if(!(context instanceof Activity))
            throw new IllegalStateException("The MediaRouteButton's Context is not an Activity.");
        else
            return (Activity)context;
    }

    private void setRemoteIndicatorDrawable(Drawable drawable) {
        if(mRemoteIndicator != null) {
            mRemoteIndicator.setCallback(null);
            unscheduleDrawable(mRemoteIndicator);
        }
        mRemoteIndicator = drawable;
        if(drawable != null) {
            drawable.setCallback(this);
            drawable.setState(getDrawableState());
            boolean flag;
            if(getVisibility() == 0)
                flag = true;
            else
                flag = false;
            drawable.setVisible(flag, false);
        }
        refreshDrawableState();
    }

    private void updateRouteInfo() {
        updateRemoteIndicator();
        updateRouteCount();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if(mRemoteIndicator != null) {
            int ai[] = getDrawableState();
            mRemoteIndicator.setState(ai);
            invalidate();
        }
    }

    public int getRouteTypes() {
        return mRouteTypes;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if(mRemoteIndicator != null)
            mRemoteIndicator.jumpToCurrentState();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        mAttachedToWindow = true;
        if(mRouteTypes != 0) {
            mRouter.addCallback(mRouteTypes, mRouterCallback);
            updateRouteInfo();
        }
    }

    protected int[] onCreateDrawableState(int i) {
        int ai[] = super.onCreateDrawableState(i + 1);
        if(mRemoteActive)
            mergeDrawableStates(ai, ACTIVATED_STATE_SET);
        return ai;
    }

    public void onDetachedFromWindow() {
        if(mRouteTypes != 0)
            mRouter.removeCallback(mRouterCallback);
        mAttachedToWindow = false;
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(mRemoteIndicator != null) {
            int i = getPaddingLeft();
            int j = getWidth() - getPaddingRight();
            int k = getPaddingTop();
            int l = getHeight() - getPaddingBottom();
            int i1 = mRemoteIndicator.getIntrinsicWidth();
            int j1 = mRemoteIndicator.getIntrinsicHeight();
            int k1 = i + (j - i - i1) / 2;
            int l1 = k + (l - k - j1) / 2;
            mRemoteIndicator.setBounds(k1, l1, k1 + i1, l1 + j1);
            mRemoteIndicator.draw(canvas);
        }
    }

    protected void onMeasure(int i, int j) {
        int l;
        int i1;
        int j2;
        int l2;
        int i3;
        int j3;
        int k = 0;
        l = android.view.View.MeasureSpec.getSize(i);
        i1 = android.view.View.MeasureSpec.getSize(j);
        int j1 = android.view.View.MeasureSpec.getMode(i);
        int k1 = android.view.View.MeasureSpec.getMode(j);
        int l1 = mMinWidth;
        int i2;
        int k2;
        if(mRemoteIndicator != null)
            i2 = mRemoteIndicator.getIntrinsicWidth();
        else
            i2 = 0;
        j2 = Math.max(l1, i2);
        k2 = mMinHeight;
        if(mRemoteIndicator != null)
            k = mRemoteIndicator.getIntrinsicHeight();
        l2 = Math.max(k2, k);
        j1;
        JVM INSTR lookupswitch 2: default 116
    //                   -2147483648: 196
    //                   1073741824: 189;
           goto _L1 _L2 _L3
_L1:
        i3 = j2 + getPaddingLeft() + getPaddingRight();
_L7:
        k1;
        JVM INSTR lookupswitch 2: default 160
    //                   -2147483648: 225
    //                   1073741824: 218;
           goto _L4 _L5 _L6
_L4:
        j3 = l2 + getPaddingTop() + getPaddingBottom();
_L8:
        setMeasuredDimension(i3, j3);
        return;
_L3:
        i3 = l;
          goto _L7
_L2:
        i3 = Math.min(l, j2 + getPaddingLeft() + getPaddingRight());
          goto _L7
_L6:
        j3 = i1;
          goto _L8
_L5:
        j3 = Math.min(i1, l2 + getPaddingTop() + getPaddingBottom());
          goto _L8
    }

    public boolean performClick() {
        boolean flag = super.performClick();
        if(!flag)
            playSoundEffect(0);
        if(mToggleMode) {
            if(mRemoteActive) {
                mRouter.selectRouteInt(mRouteTypes, mRouter.getSystemAudioRoute());
            } else {
                int i = mRouter.getRouteCount();
                int j = 0;
                while(j < i)  {
                    android.media.MediaRouter.RouteInfo routeinfo = mRouter.getRouteAt(j);
                    if((routeinfo.getSupportedTypes() & mRouteTypes) != 0 && routeinfo != mRouter.getSystemAudioRoute())
                        mRouter.selectRouteInt(mRouteTypes, routeinfo);
                    j++;
                }
            }
        } else {
            showDialog();
        }
        return flag;
    }

    public void setExtendedSettingsClickListener(android.view.View.OnClickListener onclicklistener) {
        mExtendedSettingsClickListener = onclicklistener;
        if(mDialogFragment != null)
            mDialogFragment.setExtendedSettingsClickListener(onclicklistener);
    }

    public void setRouteTypes(int i) {
        if(i != mRouteTypes) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(mAttachedToWindow && mRouteTypes != 0)
            mRouter.removeCallback(mRouterCallback);
        mRouteTypes = i;
        if(mAttachedToWindow) {
            updateRouteInfo();
            mRouter.addCallback(i, mRouterCallback);
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if(mRemoteIndicator != null) {
            Drawable drawable = mRemoteIndicator;
            boolean flag;
            if(getVisibility() == 0)
                flag = true;
            else
                flag = false;
            drawable.setVisible(flag, false);
        }
    }

    public void showDialog() {
        FragmentManager fragmentmanager = getActivity().getFragmentManager();
        if(mDialogFragment == null)
            mDialogFragment = (MediaRouteChooserDialogFragment)fragmentmanager.findFragmentByTag("android:MediaRouteChooserDialogFragment");
        if(mDialogFragment != null) {
            Log.w("MediaRouteButton", "showDialog(): Already showing!");
        } else {
            mDialogFragment = new MediaRouteChooserDialogFragment();
            mDialogFragment.setExtendedSettingsClickListener(mExtendedSettingsClickListener);
            mDialogFragment.setLauncherListener(new com.android.internal.app.MediaRouteChooserDialogFragment.LauncherListener() {

                public void onDetached(MediaRouteChooserDialogFragment mediaroutechooserdialogfragment) {
                    mDialogFragment = null;
                }

                final MediaRouteButton this$0;

             {
                this$0 = MediaRouteButton.this;
                super();
            }
            });
            mDialogFragment.setRouteTypes(mRouteTypes);
            mDialogFragment.show(fragmentmanager, "android:MediaRouteChooserDialogFragment");
        }
    }

    void updateRemoteIndicator() {
        boolean flag;
        if(mRouter.getSelectedRoute(mRouteTypes) != mRouter.getSystemAudioRoute())
            flag = true;
        else
            flag = false;
        if(mRemoteActive != flag) {
            mRemoteActive = flag;
            refreshDrawableState();
        }
    }

    void updateRouteCount() {
        boolean flag = true;
        int i = mRouter.getRouteCount();
        int j = 0;
        int k = 0;
        while(k < i)  {
            android.media.MediaRouter.RouteInfo routeinfo = mRouter.getRouteAt(k);
            if((routeinfo.getSupportedTypes() & mRouteTypes) != 0)
                if(routeinfo instanceof android.media.MediaRouter.RouteGroup)
                    j += ((android.media.MediaRouter.RouteGroup)routeinfo).getRouteCount();
                else
                    j++;
            k++;
        }
        boolean flag1;
        if(j != 0)
            flag1 = flag;
        else
            flag1 = false;
        setEnabled(flag1);
        if(j != 2 || (1 & mRouteTypes) == 0)
            flag = false;
        mToggleMode = flag;
    }

    protected boolean verifyDrawable(Drawable drawable) {
        boolean flag;
        if(super.verifyDrawable(drawable) || drawable == mRemoteIndicator)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static final int ACTIVATED_STATE_SET[];
    private static final String TAG = "MediaRouteButton";
    private boolean mAttachedToWindow;
    private MediaRouteChooserDialogFragment mDialogFragment;
    private android.view.View.OnClickListener mExtendedSettingsClickListener;
    private int mMinHeight;
    private int mMinWidth;
    private boolean mRemoteActive;
    private Drawable mRemoteIndicator;
    private int mRouteTypes;
    private MediaRouter mRouter;
    private final MediaRouteCallback mRouterCallback;
    private boolean mToggleMode;

    static  {
        int ai[] = new int[1];
        ai[0] = 0x10102fe;
        ACTIVATED_STATE_SET = ai;
    }


/*
    static MediaRouteChooserDialogFragment access$102(MediaRouteButton mediaroutebutton, MediaRouteChooserDialogFragment mediaroutechooserdialogfragment) {
        mediaroutebutton.mDialogFragment = mediaroutechooserdialogfragment;
        return mediaroutechooserdialogfragment;
    }

*/
}

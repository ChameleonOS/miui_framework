// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.media.MediaRouter;
import android.util.Log;
import android.view.*;
import com.android.internal.app.MediaRouteChooserDialogFragment;
import java.lang.ref.WeakReference;

// Referenced classes of package android.app:
//            Activity, MediaRouteButton, FragmentManager

public class MediaRouteActionProvider extends ActionProvider {
    private static class RouterCallback extends android.media.MediaRouter.SimpleCallback {

        public void onRouteAdded(MediaRouter mediarouter, android.media.MediaRouter.RouteInfo routeinfo) {
            MediaRouteActionProvider mediarouteactionprovider = (MediaRouteActionProvider)mAp.get();
            if(mediarouteactionprovider == null)
                mediarouter.removeCallback(this);
            else
                mediarouteactionprovider.refreshVisibility();
        }

        public void onRouteRemoved(MediaRouter mediarouter, android.media.MediaRouter.RouteInfo routeinfo) {
            MediaRouteActionProvider mediarouteactionprovider = (MediaRouteActionProvider)mAp.get();
            if(mediarouteactionprovider == null)
                mediarouter.removeCallback(this);
            else
                mediarouteactionprovider.refreshVisibility();
        }

        private WeakReference mAp;

        RouterCallback(MediaRouteActionProvider mediarouteactionprovider) {
            mAp = new WeakReference(mediarouteactionprovider);
        }
    }


    public MediaRouteActionProvider(Context context) {
        super(context);
        mContext = context;
        mRouter = (MediaRouter)context.getSystemService("media_router");
        mCallback = new RouterCallback(this);
        setRouteTypes(1);
    }

    private Activity getActivity() {
        Context context;
        for(context = mContext; (context instanceof ContextWrapper) && !(context instanceof Activity); context = ((ContextWrapper)context).getBaseContext());
        if(!(context instanceof Activity))
            throw new IllegalStateException("The MediaRouteActionProvider's Context is not an Activity.");
        else
            return (Activity)context;
    }

    public boolean isVisible() {
        boolean flag = true;
        if(mRouter.getRouteCount() <= flag)
            flag = false;
        return flag;
    }

    public View onCreateActionView() {
        throw new UnsupportedOperationException("Use onCreateActionView(MenuItem) instead.");
    }

    public View onCreateActionView(MenuItem menuitem) {
        if(mMenuItem != null || mView != null)
            Log.e("MediaRouteActionProvider", "onCreateActionView: this ActionProvider is already associated with a menu item. Don't reuse MediaRouteActionProvider instances! Abandoning the old one...");
        mMenuItem = menuitem;
        mView = new MediaRouteButton(mContext);
        mView.setRouteTypes(mRouteTypes);
        mView.setExtendedSettingsClickListener(mExtendedSettingsListener);
        return mView;
    }

    public boolean onPerformDefaultAction() {
        FragmentManager fragmentmanager = getActivity().getFragmentManager();
        boolean flag;
        if((MediaRouteChooserDialogFragment)fragmentmanager.findFragmentByTag("android:MediaRouteChooserDialogFragment") != null) {
            Log.w("MediaRouteActionProvider", "onPerformDefaultAction(): Chooser dialog already showing!");
            flag = false;
        } else {
            MediaRouteChooserDialogFragment mediaroutechooserdialogfragment = new MediaRouteChooserDialogFragment();
            mediaroutechooserdialogfragment.setExtendedSettingsClickListener(mExtendedSettingsListener);
            mediaroutechooserdialogfragment.setRouteTypes(mRouteTypes);
            mediaroutechooserdialogfragment.show(fragmentmanager, "android:MediaRouteChooserDialogFragment");
            flag = true;
        }
        return flag;
    }

    public boolean overridesItemVisibility() {
        return true;
    }

    public void setExtendedSettingsClickListener(android.view.View.OnClickListener onclicklistener) {
        mExtendedSettingsListener = onclicklistener;
        if(mView != null)
            mView.setExtendedSettingsClickListener(onclicklistener);
    }

    public void setRouteTypes(int i) {
        if(mRouteTypes != i) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(mRouteTypes != 0)
            mRouter.removeCallback(mCallback);
        mRouteTypes = i;
        if(i != 0)
            mRouter.addCallback(i, mCallback);
        if(mView != null)
            mView.setRouteTypes(mRouteTypes);
        if(true) goto _L1; else goto _L3
_L3:
    }

    private static final String TAG = "MediaRouteActionProvider";
    private RouterCallback mCallback;
    private Context mContext;
    private android.view.View.OnClickListener mExtendedSettingsListener;
    private MenuItem mMenuItem;
    private int mRouteTypes;
    private MediaRouter mRouter;
    private MediaRouteButton mView;
}

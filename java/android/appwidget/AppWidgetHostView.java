// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.appwidget;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.*;
import android.os.*;
import android.util.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.*;

// Referenced classes of package android.appwidget:
//            AppWidgetProviderInfo, AppWidgetManager

public class AppWidgetHostView extends FrameLayout {
    private static class ParcelableSparseArray extends SparseArray
        implements Parcelable {

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int j = size();
            parcel.writeInt(j);
            for(int k = 0; k < j; k++) {
                parcel.writeInt(keyAt(k));
                parcel.writeParcelable((Parcelable)valueAt(k), 0);
            }

        }

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public ParcelableSparseArray createFromParcel(Parcel parcel) {
                ParcelableSparseArray parcelablesparsearray = new ParcelableSparseArray();
                ClassLoader classloader = parcelablesparsearray.getClass().getClassLoader();
                int i = parcel.readInt();
                for(int j = 0; j < i; j++)
                    parcelablesparsearray.put(parcel.readInt(), parcel.readParcelable(classloader));

                return parcelablesparsearray;
            }

            public volatile Object createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            public ParcelableSparseArray[] newArray(int i) {
                return new ParcelableSparseArray[i];
            }

            public volatile Object[] newArray(int i) {
                return newArray(i);
            }

        };


        private ParcelableSparseArray() {
        }

    }


    public AppWidgetHostView(Context context) {
        this(context, 0x10a0000, 0x10a0001);
    }

    public AppWidgetHostView(Context context, int i, int j) {
        super(context);
        mViewMode = 0;
        mLayoutId = -1;
        mFadeStartTime = -1L;
        mOldPaint = new Paint();
        mContext = context;
        setIsRootNamespace(true);
    }

    private int generateId() {
        int i = getId();
        if(i == -1)
            i = mAppWidgetId;
        return i;
    }

    public static Rect getDefaultPaddingForWidget(Context context, ComponentName componentname, Rect rect) {
        PackageManager packagemanager = context.getPackageManager();
        ApplicationInfo applicationinfo;
        Resources resources;
        if(rect == null)
            rect = new Rect(0, 0, 0, 0);
        else
            rect.set(0, 0, 0, 0);
        applicationinfo = packagemanager.getApplicationInfo(componentname.getPackageName(), 0);
        if(applicationinfo.targetSdkVersion >= 14) {
            resources = context.getResources();
            rect.left = resources.getDimensionPixelSize(0x105004b);
            rect.right = resources.getDimensionPixelSize(0x105004d);
            rect.top = resources.getDimensionPixelSize(0x105004c);
            rect.bottom = resources.getDimensionPixelSize(0x105004e);
        }
_L2:
        return rect;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private Context getRemoteContext(RemoteViews remoteviews) {
        String s = remoteviews.getPackage();
        if(s != null) goto _L2; else goto _L1
_L1:
        Context context = mContext;
_L4:
        return context;
_L2:
        Context context1 = mContext.createPackageContext(s, 4);
        context = context1;
        continue; /* Loop/switch isn't completed */
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        Log.e("AppWidgetHostView", (new StringBuilder()).append("Package name ").append(s).append(" not found").toString());
        context = mContext;
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected void dispatchRestoreInstanceState(SparseArray sparsearray) {
        Parcelable parcelable = (Parcelable)sparsearray.get(generateId());
        ParcelableSparseArray parcelablesparsearray = null;
        if(parcelable != null && (parcelable instanceof ParcelableSparseArray))
            parcelablesparsearray = (ParcelableSparseArray)parcelable;
        if(parcelablesparsearray == null)
            parcelablesparsearray = new ParcelableSparseArray();
        super.dispatchRestoreInstanceState(parcelablesparsearray);
    }

    protected void dispatchSaveInstanceState(SparseArray sparsearray) {
        ParcelableSparseArray parcelablesparsearray = new ParcelableSparseArray();
        super.dispatchSaveInstanceState(parcelablesparsearray);
        sparsearray.put(generateId(), parcelablesparsearray);
    }

    protected boolean drawChild(Canvas canvas, View view, long l) {
        return super.drawChild(canvas, view, l);
    }

    public volatile android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset) {
        return generateLayoutParams(attributeset);
    }

    public android.widget.FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeset) {
        Context context;
        if(mRemoteContext != null)
            context = mRemoteContext;
        else
            context = mContext;
        return new android.widget.FrameLayout.LayoutParams(context, attributeset);
    }

    public int getAppWidgetId() {
        return mAppWidgetId;
    }

    public AppWidgetProviderInfo getAppWidgetInfo() {
        return mInfo;
    }

    protected View getDefaultView() {
        View view;
        Object obj;
        view = null;
        obj = null;
        if(mInfo == null) goto _L2; else goto _L1
_L1:
        View view1;
        Context context = mContext.createPackageContext(mInfo.provider.getPackageName(), 4);
        mRemoteContext = context;
        LayoutInflater layoutinflater = ((LayoutInflater)context.getSystemService("layout_inflater")).cloneInContext(context);
        layoutinflater.setFilter(sInflaterFilter);
        view1 = layoutinflater.inflate(mInfo.initialLayout, this, false);
        view = view1;
_L4:
        if(obj != null)
            Log.w("AppWidgetHostView", (new StringBuilder()).append("Error inflating AppWidget ").append(mInfo).append(": ").append(((Exception) (obj)).toString()).toString());
        if(view == null)
            view = getErrorView();
        return view;
_L2:
        try {
            Log.w("AppWidgetHostView", "can't inflate defaultView because mInfo is missing");
        }
        catch(android.content.pm.PackageManager.NameNotFoundException namenotfoundexception) {
            obj = namenotfoundexception;
        }
        catch(RuntimeException runtimeexception) {
            obj = runtimeexception;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected View getErrorView() {
        TextView textview = new TextView(mContext);
        textview.setText(0x1040464);
        textview.setBackgroundColor(Color.argb(127, 0, 0, 0));
        return textview;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/appwidget/AppWidgetHostView.getName());
    }

    protected void prepareView(View view) {
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)view.getLayoutParams();
        if(layoutparams == null)
            layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        layoutparams.gravity = 17;
        view.setLayoutParams(layoutparams);
    }

    void resetAppWidget(AppWidgetProviderInfo appwidgetproviderinfo) {
        mInfo = appwidgetproviderinfo;
        mViewMode = 0;
        updateAppWidget(null);
    }

    public void setAppWidget(int i, AppWidgetProviderInfo appwidgetproviderinfo) {
        mAppWidgetId = i;
        mInfo = appwidgetproviderinfo;
        if(appwidgetproviderinfo != null) {
            Rect rect = getDefaultPaddingForWidget(mContext, appwidgetproviderinfo.provider, null);
            setPadding(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    public void updateAppWidget(RemoteViews remoteviews) {
        boolean flag;
        View view;
        Object obj;
        flag = false;
        view = null;
        obj = null;
        if(remoteviews != null) goto _L2; else goto _L1
_L1:
        if(mViewMode != 3) goto _L4; else goto _L3
_L3:
        return;
_L4:
        view = getDefaultView();
        mLayoutId = -1;
        mViewMode = 3;
_L6:
        if(view != null)
            break MISSING_BLOCK_LABEL_69;
        if(mViewMode == 2) goto _L3; else goto _L5
_L5:
        Log.w("AppWidgetHostView", "updateAppWidget couldn't find any view, using error view", ((Throwable) (obj)));
        view = getErrorView();
        mViewMode = 2;
        if(!flag) {
            prepareView(view);
            addView(view);
        }
        if(mView != view) {
            removeView(mView);
            mView = view;
        }
          goto _L3
_L2:
        int i;
        mRemoteContext = getRemoteContext(remoteviews);
        i = remoteviews.getLayoutId();
        if(false || i != mLayoutId)
            break MISSING_BLOCK_LABEL_154;
        remoteviews.reapply(mContext, mView);
        view = mView;
        flag = true;
_L7:
        if(view != null)
            break MISSING_BLOCK_LABEL_172;
        View view1 = remoteviews.apply(mContext, this);
        view = view1;
_L8:
        mLayoutId = i;
        mViewMode = 1;
          goto _L6
        RuntimeException runtimeexception1;
        runtimeexception1;
        obj = runtimeexception1;
          goto _L7
        RuntimeException runtimeexception;
        runtimeexception;
        obj = runtimeexception;
          goto _L8
    }

    public void updateAppWidgetOptions(Bundle bundle) {
        AppWidgetManager.getInstance(mContext).updateAppWidgetOptions(mAppWidgetId, bundle);
    }

    public void updateAppWidgetSize(Bundle bundle, int i, int j, int k, int l) {
        if(bundle == null)
            bundle = new Bundle();
        Rect rect = new Rect();
        if(mInfo != null)
            rect = getDefaultPaddingForWidget(mContext, mInfo.provider, rect);
        float f = getResources().getDisplayMetrics().density;
        int i1 = (int)((float)(rect.left + rect.right) / f);
        int j1 = (int)((float)(rect.top + rect.bottom) / f);
        bundle.putInt("appWidgetMinWidth", i - i1);
        bundle.putInt("appWidgetMinHeight", j - j1);
        bundle.putInt("appWidgetMaxWidth", k - i1);
        bundle.putInt("appWidgetMaxHeight", l - j1);
        updateAppWidgetOptions(bundle);
    }

    void viewDataChanged(int i) {
        View view = findViewById(i);
        if(view == null || !(view instanceof AdapterView)) goto _L2; else goto _L1
_L1:
        AdapterView adapterview;
        android.widget.Adapter adapter;
        adapterview = (AdapterView)view;
        adapter = adapterview.getAdapter();
        if(!(adapter instanceof BaseAdapter)) goto _L4; else goto _L3
_L3:
        ((BaseAdapter)adapter).notifyDataSetChanged();
_L2:
        return;
_L4:
        if(adapter == null && (adapterview instanceof android.widget.RemoteViewsAdapter.RemoteAdapterConnectionCallback))
            ((android.widget.RemoteViewsAdapter.RemoteAdapterConnectionCallback)adapterview).deferNotifyDataSetChanged();
        if(true) goto _L2; else goto _L5
_L5:
    }

    static final boolean CROSSFADE = false;
    static final int FADE_DURATION = 1000;
    static final boolean LOGD = false;
    static final String TAG = "AppWidgetHostView";
    static final int VIEW_MODE_CONTENT = 1;
    static final int VIEW_MODE_DEFAULT = 3;
    static final int VIEW_MODE_ERROR = 2;
    static final int VIEW_MODE_NOINIT;
    static final android.view.LayoutInflater.Filter sInflaterFilter = new android.view.LayoutInflater.Filter() {

        public boolean onLoadClass(Class class1) {
            return class1.isAnnotationPresent(android/widget/RemoteViews$RemoteView);
        }

    };
    int mAppWidgetId;
    Context mContext;
    long mFadeStartTime;
    AppWidgetProviderInfo mInfo;
    int mLayoutId;
    Bitmap mOld;
    Paint mOldPaint;
    Context mRemoteContext;
    View mView;
    int mViewMode;

}

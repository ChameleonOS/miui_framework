// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.*;
import android.util.*;
import android.view.*;
import com.android.internal.widget.IRemoteViewsFactory;
import java.lang.ref.WeakReference;
import java.util.*;

// Referenced classes of package android.widget:
//            BaseAdapter, RemoteViews, TextView, FrameLayout

public class RemoteViewsAdapter extends BaseAdapter
    implements android.os.Handler.Callback {
    private static class FixedSizeRemoteViewsCache {

        private int getFarthestPositionFrom(int i, ArrayList arraylist) {
            int j = 0;
            int k = -1;
            int l = 0;
            int i1 = -1;
            Iterator iterator = mIndexRemoteViews.keySet().iterator();
            do {
                if(!iterator.hasNext())
                    break;
                int j1 = ((Integer)iterator.next()).intValue();
                int k1 = Math.abs(j1 - i);
                if(k1 > l && !arraylist.contains(Integer.valueOf(j1))) {
                    i1 = j1;
                    l = k1;
                }
                if(k1 >= j) {
                    k = j1;
                    j = k1;
                }
            } while(true);
            if(i1 <= -1)
                i1 = k;
            return i1;
        }

        private int getRemoteViewsBitmapMemoryUsage() {
            int i = 0;
            Iterator iterator = mIndexRemoteViews.keySet().iterator();
            do {
                if(!iterator.hasNext())
                    break;
                Integer integer = (Integer)iterator.next();
                RemoteViews remoteviews = (RemoteViews)mIndexRemoteViews.get(integer);
                if(remoteviews != null)
                    i += remoteviews.estimateMemoryUsage();
            } while(true);
            return i;
        }

        public void commitTemporaryMetaData() {
            RemoteViewsMetaData remoteviewsmetadata = mTemporaryMetaData;
            remoteviewsmetadata;
            JVM INSTR monitorenter ;
            synchronized(mMetaData) {
                mMetaData.set(mTemporaryMetaData);
            }
            remoteviewsmetadata;
            JVM INSTR monitorexit ;
            return;
            exception1;
            remoteviewsmetadata1;
            JVM INSTR monitorexit ;
            throw exception1;
            Exception exception;
            exception;
            throw exception;
        }

        public boolean containsMetaDataAt(int i) {
            return mIndexMetaData.containsKey(Integer.valueOf(i));
        }

        public boolean containsRemoteViewAt(int i) {
            return mIndexRemoteViews.containsKey(Integer.valueOf(i));
        }

        public RemoteViewsMetaData getMetaData() {
            return mMetaData;
        }

        public RemoteViewsIndexMetaData getMetaDataAt(int i) {
            RemoteViewsIndexMetaData remoteviewsindexmetadata;
            if(mIndexMetaData.containsKey(Integer.valueOf(i)))
                remoteviewsindexmetadata = (RemoteViewsIndexMetaData)mIndexMetaData.get(Integer.valueOf(i));
            else
                remoteviewsindexmetadata = null;
            return remoteviewsindexmetadata;
        }

        public int[] getNextIndexToLoad() {
            HashSet hashset = mLoadIndices;
            hashset;
            JVM INSTR monitorenter ;
            if(mRequestedIndices.isEmpty()) goto _L2; else goto _L1
_L1:
            int ai[];
            Integer integer1 = (Integer)mRequestedIndices.iterator().next();
            mRequestedIndices.remove(integer1);
            mLoadIndices.remove(integer1);
            ai = new int[2];
            ai[0] = integer1.intValue();
            ai[1] = 1;
              goto _L3
_L2:
            if(mLoadIndices.isEmpty()) goto _L5; else goto _L4
_L4:
            Integer integer = (Integer)mLoadIndices.iterator().next();
            mLoadIndices.remove(integer);
            ai = new int[2];
            ai[0] = integer.intValue();
            ai[1] = 0;
              goto _L3
            Exception exception;
            exception;
            throw exception;
_L5:
            ai = new int[2];
            ai[0] = -1;
            ai[1] = 0;
            hashset;
            JVM INSTR monitorexit ;
_L3:
            return ai;
        }

        public RemoteViews getRemoteViewsAt(int i) {
            RemoteViews remoteviews;
            if(mIndexRemoteViews.containsKey(Integer.valueOf(i)))
                remoteviews = (RemoteViews)mIndexRemoteViews.get(Integer.valueOf(i));
            else
                remoteviews = null;
            return remoteviews;
        }

        public RemoteViewsMetaData getTemporaryMetaData() {
            return mTemporaryMetaData;
        }

        public void insert(int i, RemoteViews remoteviews, long l, ArrayList arraylist) {
            if(mIndexRemoteViews.size() >= mMaxCount)
                mIndexRemoteViews.remove(Integer.valueOf(getFarthestPositionFrom(i, arraylist)));
            int j;
            if(mLastRequestedIndex > -1)
                j = mLastRequestedIndex;
            else
                j = i;
            for(; getRemoteViewsBitmapMemoryUsage() >= 0x200000; mIndexRemoteViews.remove(Integer.valueOf(getFarthestPositionFrom(j, arraylist))));
            if(mIndexMetaData.containsKey(Integer.valueOf(i)))
                ((RemoteViewsIndexMetaData)mIndexMetaData.get(Integer.valueOf(i))).set(remoteviews, l);
            else
                mIndexMetaData.put(Integer.valueOf(i), new RemoteViewsIndexMetaData(remoteviews, l));
            mIndexRemoteViews.put(Integer.valueOf(i), remoteviews);
        }

        public boolean queuePositionsToBePreloadedFromRequestedPosition(int i) {
            boolean flag = false;
            if(mPreloadLowerBound > i || i > mPreloadUpperBound || Math.abs(i - (mPreloadUpperBound + mPreloadLowerBound) / 2) >= mMaxCountSlack) goto _L2; else goto _L1
_L1:
            return flag;
_L2:
            int j;
            synchronized(mMetaData) {
                j = mMetaData.count;
            }
            HashSet hashset = mLoadIndices;
            hashset;
            JVM INSTR monitorenter ;
            int i1;
            int j1;
            mLoadIndices.clear();
            mLoadIndices.addAll(mRequestedIndices);
            int k = mMaxCount / 2;
            mPreloadLowerBound = i - k;
            mPreloadUpperBound = i + k;
            int l = Math.max(0, mPreloadLowerBound);
            i1 = Math.min(mPreloadUpperBound, j - 1);
            j1 = l;
_L3:
            if(j1 > i1)
                break MISSING_BLOCK_LABEL_173;
            mLoadIndices.add(Integer.valueOf(j1));
            j1++;
              goto _L3
            exception;
            remoteviewsmetadata;
            JVM INSTR monitorexit ;
            throw exception;
            mLoadIndices.removeAll(mIndexRemoteViews.keySet());
            flag = true;
            if(true) goto _L1; else goto _L4
_L4:
            Exception exception1;
            exception1;
            throw exception1;
        }

        public void queueRequestedPositionToLoad(int i) {
            mLastRequestedIndex = i;
            HashSet hashset = mLoadIndices;
            hashset;
            JVM INSTR monitorenter ;
            mRequestedIndices.add(Integer.valueOf(i));
            mLoadIndices.add(Integer.valueOf(i));
            return;
        }

        public void reset() {
            mPreloadLowerBound = 0;
            mPreloadUpperBound = -1;
            mLastRequestedIndex = -1;
            mIndexRemoteViews.clear();
            mIndexMetaData.clear();
            HashSet hashset = mLoadIndices;
            hashset;
            JVM INSTR monitorenter ;
            mRequestedIndices.clear();
            mLoadIndices.clear();
            return;
        }

        private static final String TAG = "FixedSizeRemoteViewsCache";
        private static final float sMaxCountSlackPercent = 0.75F;
        private static final int sMaxMemoryLimitInBytes = 0x200000;
        private HashMap mIndexMetaData;
        private HashMap mIndexRemoteViews;
        private int mLastRequestedIndex;
        private HashSet mLoadIndices;
        private int mMaxCount;
        private int mMaxCountSlack;
        private final RemoteViewsMetaData mMetaData = new RemoteViewsMetaData();
        private int mPreloadLowerBound;
        private int mPreloadUpperBound;
        private HashSet mRequestedIndices;
        private final RemoteViewsMetaData mTemporaryMetaData = new RemoteViewsMetaData();



        public FixedSizeRemoteViewsCache(int i) {
            mMaxCount = i;
            mMaxCountSlack = Math.round(0.75F * (float)(mMaxCount / 2));
            mPreloadLowerBound = 0;
            mPreloadUpperBound = -1;
            mIndexMetaData = new HashMap();
            mIndexRemoteViews = new HashMap();
            mRequestedIndices = new HashSet();
            mLastRequestedIndex = -1;
            mLoadIndices = new HashSet();
        }
    }

    private static class RemoteViewsIndexMetaData {

        public void set(RemoteViews remoteviews, long l) {
            itemId = l;
            if(remoteviews != null)
                typeId = remoteviews.getLayoutId();
            else
                typeId = 0;
        }

        long itemId;
        int typeId;

        public RemoteViewsIndexMetaData(RemoteViews remoteviews, long l) {
            set(remoteviews, l);
        }
    }

    private static class RemoteViewsMetaData {

        private RemoteViewsFrameLayout createLoadingView(int i, View view, ViewGroup viewgroup, Object obj, LayoutInflater layoutinflater) {
            Context context = viewgroup.getContext();
            RemoteViewsFrameLayout remoteviewsframelayout = new RemoteViewsFrameLayout(context);
            obj;
            JVM INSTR monitorenter ;
            boolean flag = false;
            RemoteViews remoteviews = mUserLoadingView;
            if(remoteviews == null)
                break MISSING_BLOCK_LABEL_73;
            View view2 = mUserLoadingView.apply(viewgroup.getContext(), viewgroup);
            view2.setTagInternal(0x102023a, new Integer(0));
            remoteviewsframelayout.addView(view2);
            flag = true;
_L3:
            if(flag) goto _L2; else goto _L1
_L1:
            int j = mFirstViewHeight;
            if(j >= 0)
                break MISSING_BLOCK_LABEL_132;
            View view1 = mFirstView.apply(viewgroup.getContext(), viewgroup);
            view1.measure(android.view.View.MeasureSpec.makeMeasureSpec(0, 0), android.view.View.MeasureSpec.makeMeasureSpec(0, 0));
            mFirstViewHeight = view1.getMeasuredHeight();
            mFirstView = null;
_L4:
            TextView textview = (TextView)layoutinflater.inflate(0x1090092, remoteviewsframelayout, false);
            textview.setHeight(mFirstViewHeight);
            textview.setTag(new Integer(0));
            remoteviewsframelayout.addView(textview);
_L2:
            obj;
            JVM INSTR monitorexit ;
            return remoteviewsframelayout;
            Exception exception2;
            exception2;
            Log.w("RemoteViewsAdapter", "Error inflating custom loading view, using default loadingview instead", exception2);
              goto _L3
            Exception exception;
            exception;
            throw exception;
            Exception exception1;
            exception1;
            mFirstViewHeight = Math.round(50F * context.getResources().getDisplayMetrics().density);
            mFirstView = null;
            Log.w("RemoteViewsAdapter", (new StringBuilder()).append("Error inflating first RemoteViews").append(exception1).toString());
              goto _L4
        }

        public int getMappedViewType(int i) {
            int j;
            if(mTypeIdIndexMap.containsKey(Integer.valueOf(i))) {
                j = ((Integer)mTypeIdIndexMap.get(Integer.valueOf(i))).intValue();
            } else {
                j = 1 + mTypeIdIndexMap.size();
                mTypeIdIndexMap.put(Integer.valueOf(i), Integer.valueOf(j));
            }
            return j;
        }

        public boolean isViewTypeInRange(int i) {
            boolean flag;
            if(getMappedViewType(i) >= viewTypeCount)
                flag = false;
            else
                flag = true;
            return flag;
        }

        public void reset() {
            count = 0;
            viewTypeCount = 1;
            hasStableIds = true;
            mUserLoadingView = null;
            mFirstView = null;
            mFirstViewHeight = 0;
            mTypeIdIndexMap.clear();
        }

        public void set(RemoteViewsMetaData remoteviewsmetadata) {
            remoteviewsmetadata;
            JVM INSTR monitorenter ;
            count = remoteviewsmetadata.count;
            viewTypeCount = remoteviewsmetadata.viewTypeCount;
            hasStableIds = remoteviewsmetadata.hasStableIds;
            setLoadingViewTemplates(remoteviewsmetadata.mUserLoadingView, remoteviewsmetadata.mFirstView);
            return;
        }

        public void setLoadingViewTemplates(RemoteViews remoteviews, RemoteViews remoteviews1) {
            mUserLoadingView = remoteviews;
            if(remoteviews1 != null) {
                mFirstView = remoteviews1;
                mFirstViewHeight = -1;
            }
        }

        int count;
        boolean hasStableIds;
        RemoteViews mFirstView;
        int mFirstViewHeight;
        private final HashMap mTypeIdIndexMap = new HashMap();
        RemoteViews mUserLoadingView;
        int viewTypeCount;


        public RemoteViewsMetaData() {
            reset();
        }
    }

    private class RemoteViewsFrameLayoutRefSet {

        public void add(int i, RemoteViewsFrameLayout remoteviewsframelayout) {
            Integer integer = Integer.valueOf(i);
            LinkedList linkedlist;
            if(mReferences.containsKey(integer)) {
                linkedlist = (LinkedList)mReferences.get(integer);
            } else {
                linkedlist = new LinkedList();
                mReferences.put(integer, linkedlist);
            }
            linkedlist.add(remoteviewsframelayout);
        }

        public void clear() {
            mReferences.clear();
        }

        public void notifyOnRemoteViewsLoaded(int i, RemoteViews remoteviews) {
            if(remoteviews != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            Integer integer = Integer.valueOf(i);
            if(mReferences.containsKey(integer)) {
                LinkedList linkedlist = (LinkedList)mReferences.get(integer);
                for(Iterator iterator = linkedlist.iterator(); iterator.hasNext(); ((RemoteViewsFrameLayout)iterator.next()).onRemoteViewsLoaded(remoteviews));
                linkedlist.clear();
                mReferences.remove(integer);
            }
            if(true) goto _L1; else goto _L3
_L3:
        }

        private HashMap mReferences;
        final RemoteViewsAdapter this$0;

        public RemoteViewsFrameLayoutRefSet() {
            this$0 = RemoteViewsAdapter.this;
            super();
            mReferences = new HashMap();
        }
    }

    private static class RemoteViewsFrameLayout extends FrameLayout {

        public void onRemoteViewsLoaded(RemoteViews remoteviews) {
            removeAllViews();
            addView(remoteviews.apply(getContext(), this));
_L1:
            return;
            Exception exception;
            exception;
            Log.e("RemoteViewsAdapter", "Failed to apply RemoteViews.");
              goto _L1
        }

        public RemoteViewsFrameLayout(Context context) {
            super(context);
        }
    }

    private static class RemoteViewsAdapterServiceConnection extends com.android.internal.widget.IRemoteViewsAdapterConnection.Stub {

        /**
         * @deprecated Method bind is deprecated
         */

        public void bind(Context context, int i, Intent intent) {
            this;
            JVM INSTR monitorenter ;
            boolean flag = mIsConnecting;
            if(flag)
                break MISSING_BLOCK_LABEL_31;
            AppWidgetManager.getInstance(context).bindRemoteViewsService(i, intent, asBinder());
            mIsConnecting = true;
_L2:
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception1;
            exception1;
            Log.e("RemoteViewsAdapterServiceConnection", (new StringBuilder()).append("bind(): ").append(exception1.getMessage()).toString());
            mIsConnecting = false;
            mIsConnected = false;
            if(true) goto _L2; else goto _L1
_L1:
            Exception exception;
            exception;
            throw exception;
        }

        /**
         * @deprecated Method getRemoteViewsFactory is deprecated
         */

        public IRemoteViewsFactory getRemoteViewsFactory() {
            this;
            JVM INSTR monitorenter ;
            IRemoteViewsFactory iremoteviewsfactory = mRemoteViewsFactory;
            this;
            JVM INSTR monitorexit ;
            return iremoteviewsfactory;
            Exception exception;
            exception;
            throw exception;
        }

        /**
         * @deprecated Method isConnected is deprecated
         */

        public boolean isConnected() {
            this;
            JVM INSTR monitorenter ;
            boolean flag = mIsConnected;
            this;
            JVM INSTR monitorexit ;
            return flag;
            Exception exception;
            exception;
            throw exception;
        }

        /**
         * @deprecated Method onServiceConnected is deprecated
         */

        public void onServiceConnected(IBinder ibinder) {
            this;
            JVM INSTR monitorenter ;
            RemoteViewsAdapter remoteviewsadapter;
            mRemoteViewsFactory = com.android.internal.widget.IRemoteViewsFactory.Stub.asInterface(ibinder);
            remoteviewsadapter = (RemoteViewsAdapter)mAdapter.get();
            if(remoteviewsadapter != null) goto _L2; else goto _L1
_L1:
            this;
            JVM INSTR monitorexit ;
            return;
_L2:
            remoteviewsadapter.mWorkerQueue.post(remoteviewsadapter. new Runnable() {

                public void run() {
                    if(!adapter.mNotifyDataSetChangedAfterOnServiceConnected) goto _L2; else goto _L1
_L1:
                    adapter.onNotifyDataSetChanged();
_L3:
                    adapter.enqueueDeferredUnbindServiceMessage();
                    mIsConnected = true;
                    mIsConnecting = false;
_L4:
                    return;
_L2:
                    IRemoteViewsFactory iremoteviewsfactory = adapter.mServiceConnection.getRemoteViewsFactory();
                    if(!iremoteviewsfactory.isCreated())
                        iremoteviewsfactory.onDataSetChanged();
_L5:
                    adapter.updateTemporaryMetaData();
                    adapter.mMainQueue.post(new Runnable() {

                        public void run() {
                            synchronized(adapter.mCache) {
                                adapter.mCache.commitTemporaryMetaData();
                            }
                            RemoteAdapterConnectionCallback remoteadapterconnectioncallback = (RemoteAdapterConnectionCallback)adapter.mCallback.get();
                            if(remoteadapterconnectioncallback != null)
                                remoteadapterconnectioncallback.onRemoteAdapterConnected();
                            return;
                            exception1;
                            fixedsizeremoteviewscache;
                            JVM INSTR monitorexit ;
                            throw exception1;
                        }

                        final _cls1 this$1;

                         {
                            this$1 = _cls1.this;
                            super();
                        }
                    });
                      goto _L3
                    RemoteException remoteexception;
                    remoteexception;
                    Log.e("RemoteViewsAdapter", (new StringBuilder()).append("Error notifying factory of data set changed in onServiceConnected(): ").append(remoteexception.getMessage()).toString());
                      goto _L4
                    RuntimeException runtimeexception;
                    runtimeexception;
                    Log.e("RemoteViewsAdapter", (new StringBuilder()).append("Error notifying factory of data set changed in onServiceConnected(): ").append(runtimeexception.getMessage()).toString());
                      goto _L5
                }

                final RemoteViewsAdapterServiceConnection this$0;
                final RemoteViewsAdapter val$adapter;


// JavaClassFileOutputException: Invalid index accessing method local variables table of <init>
            });
            if(true) goto _L1; else goto _L3
_L3:
            Exception exception;
            exception;
            throw exception;
        }

        /**
         * @deprecated Method onServiceDisconnected is deprecated
         */

        public void onServiceDisconnected() {
            this;
            JVM INSTR monitorenter ;
            RemoteViewsAdapter remoteviewsadapter;
            mIsConnected = false;
            mIsConnecting = false;
            mRemoteViewsFactory = null;
            remoteviewsadapter = (RemoteViewsAdapter)mAdapter.get();
            if(remoteviewsadapter != null) goto _L2; else goto _L1
_L1:
            this;
            JVM INSTR monitorexit ;
            return;
_L2:
            remoteviewsadapter.mMainQueue.post(remoteviewsadapter. new Runnable() {

                public void run() {
                    adapter.mMainQueue.removeMessages(1);
                    RemoteAdapterConnectionCallback remoteadapterconnectioncallback = (RemoteAdapterConnectionCallback)adapter.mCallback.get();
                    if(remoteadapterconnectioncallback != null)
                        remoteadapterconnectioncallback.onRemoteAdapterDisconnected();
                }

                final RemoteViewsAdapterServiceConnection this$0;
                final RemoteViewsAdapter val$adapter;


// JavaClassFileOutputException: Invalid index accessing method local variables table of <init>
            });
            if(true) goto _L1; else goto _L3
_L3:
            Exception exception;
            exception;
            throw exception;
        }

        /**
         * @deprecated Method unbind is deprecated
         */

        public void unbind(Context context, int i, Intent intent) {
            this;
            JVM INSTR monitorenter ;
            AppWidgetManager.getInstance(context).unbindRemoteViewsService(i, intent);
            mIsConnecting = false;
_L2:
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception1;
            exception1;
            Log.e("RemoteViewsAdapterServiceConnection", (new StringBuilder()).append("unbind(): ").append(exception1.getMessage()).toString());
            mIsConnecting = false;
            mIsConnected = false;
            if(true) goto _L2; else goto _L1
_L1:
            Exception exception;
            exception;
            throw exception;
        }

        private WeakReference mAdapter;
        private boolean mIsConnected;
        private boolean mIsConnecting;
        private IRemoteViewsFactory mRemoteViewsFactory;


/*
        static boolean access$802(RemoteViewsAdapterServiceConnection remoteviewsadapterserviceconnection, boolean flag) {
            remoteviewsadapterserviceconnection.mIsConnected = flag;
            return flag;
        }

*/


/*
        static boolean access$902(RemoteViewsAdapterServiceConnection remoteviewsadapterserviceconnection, boolean flag) {
            remoteviewsadapterserviceconnection.mIsConnecting = flag;
            return flag;
        }

*/

        public RemoteViewsAdapterServiceConnection(RemoteViewsAdapter remoteviewsadapter) {
            mAdapter = new WeakReference(remoteviewsadapter);
        }
    }

    public static interface RemoteAdapterConnectionCallback {

        public abstract void deferNotifyDataSetChanged();

        public abstract boolean onRemoteAdapterConnected();

        public abstract void onRemoteAdapterDisconnected();
    }


    public RemoteViewsAdapter(Context context, Intent intent, RemoteAdapterConnectionCallback remoteadapterconnectioncallback) {
        Pair pair;
        mNotifyDataSetChangedAfterOnServiceConnected = false;
        mDataReady = false;
        mContext = context;
        mIntent = intent;
        mAppWidgetId = intent.getIntExtra("remoteAdapterAppWidgetId", -1);
        mLayoutInflater = LayoutInflater.from(context);
        if(mIntent == null)
            throw new IllegalArgumentException("Non-null Intent must be specified.");
        mRequestedViews = new RemoteViewsFrameLayoutRefSet();
        if(intent.hasExtra("remoteAdapterAppWidgetId"))
            intent.removeExtra("remoteAdapterAppWidgetId");
        mWorkerThread = new HandlerThread("RemoteViewsCache-loader");
        mWorkerThread.start();
        mWorkerQueue = new Handler(mWorkerThread.getLooper());
        mMainQueue = new Handler(Looper.myLooper(), this);
        if(sCacheRemovalThread == null) {
            sCacheRemovalThread = new HandlerThread("RemoteViewsAdapter-cachePruner");
            sCacheRemovalThread.start();
            sCacheRemovalQueue = new Handler(sCacheRemovalThread.getLooper());
        }
        mCallback = new WeakReference(remoteadapterconnectioncallback);
        mServiceConnection = new RemoteViewsAdapterServiceConnection(this);
        pair = new Pair(new android.content.Intent.FilterComparison(mIntent), Integer.valueOf(mAppWidgetId));
        HashMap hashmap = sCachedRemoteViewsCaches;
        hashmap;
        JVM INSTR monitorenter ;
        if(!sCachedRemoteViewsCaches.containsKey(pair))
            break MISSING_BLOCK_LABEL_331;
        mCache = (FixedSizeRemoteViewsCache)sCachedRemoteViewsCaches.get(pair);
        synchronized(mCache.mMetaData) {
            if(mCache.mMetaData.count > 0)
                mDataReady = true;
        }
_L1:
        if(!mDataReady)
            requestBindService();
        hashmap;
        JVM INSTR monitorexit ;
        return;
        exception1;
        remoteviewsmetadata;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        throw exception;
        mCache = new FixedSizeRemoteViewsCache(40);
          goto _L1
    }

    private void enqueueDeferredUnbindServiceMessage() {
        mMainQueue.removeMessages(1);
        mMainQueue.sendEmptyMessageDelayed(1, 5000L);
    }

    private int getConvertViewTypeId(View view) {
        int i = -1;
        if(view != null) {
            Object obj = view.getTag(0x102023a);
            if(obj != null)
                i = ((Integer)obj).intValue();
        }
        return i;
    }

    private ArrayList getVisibleWindow(int i, int j, int k) {
        ArrayList arraylist = new ArrayList();
        if((i != 0 || j != 0) && i >= 0 && j >= 0) goto _L2; else goto _L1
_L1:
        return arraylist;
_L2:
        if(i > j)
            break; /* Loop/switch isn't completed */
        int j1 = i;
        while(j1 <= j)  {
            arraylist.add(Integer.valueOf(j1));
            j1++;
        }
        if(true) goto _L1; else goto _L3
_L3:
        for(int l = i; l < k; l++)
            arraylist.add(Integer.valueOf(l));

        int i1 = 0;
        while(i1 <= j)  {
            arraylist.add(Integer.valueOf(i1));
            i1++;
        }
        if(true) goto _L1; else goto _L4
_L4:
    }

    private void loadNextIndexInBackground() {
        mWorkerQueue.post(new Runnable() {

            public void run() {
                if(mServiceConnection.isConnected()) {
                    int i;
                    synchronized(mCache) {
                        i = mCache.getNextIndexToLoad()[0];
                    }
                    if(i > -1) {
                        updateRemoteViews(i, true);
                        loadNextIndexInBackground();
                    } else {
                        enqueueDeferredUnbindServiceMessage();
                    }
                }
                return;
                exception;
                fixedsizeremoteviewscache;
                JVM INSTR monitorexit ;
                throw exception;
            }

            final RemoteViewsAdapter this$0;

             {
                this$0 = RemoteViewsAdapter.this;
                super();
            }
        });
    }

    private void onNotifyDataSetChanged() {
        IRemoteViewsFactory iremoteviewsfactory = mServiceConnection.getRemoteViewsFactory();
        iremoteviewsfactory.onDataSetChanged();
        synchronized(mCache) {
            mCache.reset();
        }
        updateTemporaryMetaData();
        int i;
        ArrayList arraylist;
        synchronized(mCache.getTemporaryMetaData()) {
            i = mCache.getTemporaryMetaData().count;
            arraylist = getVisibleWindow(mVisibleWindowLowerBound, mVisibleWindowUpperBound, i);
        }
        Iterator iterator = arraylist.iterator();
        RuntimeException runtimeexception;
        RemoteException remoteexception;
        do {
            if(!iterator.hasNext())
                break;
            int j = ((Integer)iterator.next()).intValue();
            if(j < i)
                updateRemoteViews(j, false);
        } while(true);
        mMainQueue.post(new Runnable() {

            public void run() {
                synchronized(mCache) {
                    mCache.commitTemporaryMetaData();
                }
                superNotifyDataSetChanged();
                enqueueDeferredUnbindServiceMessage();
                return;
                exception2;
                fixedsizeremoteviewscache1;
                JVM INSTR monitorexit ;
                throw exception2;
            }

            final RemoteViewsAdapter this$0;

             {
                this$0 = RemoteViewsAdapter.this;
                super();
            }
        });
        mNotifyDataSetChangedAfterOnServiceConnected = false;
          goto _L1
        remoteexception;
        Log.e("RemoteViewsAdapter", (new StringBuilder()).append("Error in updateNotifyDataSetChanged(): ").append(remoteexception.getMessage()).toString());
_L3:
        return;
        runtimeexception;
        Log.e("RemoteViewsAdapter", (new StringBuilder()).append("Error in updateNotifyDataSetChanged(): ").append(runtimeexception.getMessage()).toString());
        continue; /* Loop/switch isn't completed */
        exception;
        fixedsizeremoteviewscache;
        JVM INSTR monitorexit ;
        throw exception;
        exception1;
        remoteviewsmetadata;
        JVM INSTR monitorexit ;
        throw exception1;
_L1:
        if(true) goto _L3; else goto _L2
_L2:
    }

    private void processException(String s, Exception exception) {
        Log.e("RemoteViewsAdapter", (new StringBuilder()).append("Error in ").append(s).append(": ").append(exception.getMessage()).toString());
        synchronized(mCache.getMetaData()) {
            remoteviewsmetadata.reset();
        }
        synchronized(mCache) {
            mCache.reset();
        }
        mMainQueue.post(new Runnable() {

            public void run() {
                superNotifyDataSetChanged();
            }

            final RemoteViewsAdapter this$0;

             {
                this$0 = RemoteViewsAdapter.this;
                super();
            }
        });
        return;
        exception1;
        remoteviewsmetadata;
        JVM INSTR monitorexit ;
        throw exception1;
        exception2;
        fixedsizeremoteviewscache;
        JVM INSTR monitorexit ;
        throw exception2;
    }

    private boolean requestBindService() {
        if(!mServiceConnection.isConnected())
            mServiceConnection.bind(mContext, mAppWidgetId, mIntent);
        mMainQueue.removeMessages(1);
        return mServiceConnection.isConnected();
    }

    private void updateRemoteViews(final int position, boolean flag) {
        IRemoteViewsFactory iremoteviewsfactory = mServiceConnection.getRemoteViewsFactory();
        final RemoteViews rv;
        long l;
        rv = iremoteviewsfactory.getViewAt(position);
        l = iremoteviewsfactory.getItemId(position);
        if(rv != null) goto _L2; else goto _L1
_L1:
        Log.e("RemoteViewsAdapter", (new StringBuilder()).append("Error in updateRemoteViews(").append(position).append("): ").append(" null RemoteViews ").append("returned from RemoteViewsFactory.").toString());
_L3:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("RemoteViewsAdapter", (new StringBuilder()).append("Error in updateRemoteViews(").append(position).append("): ").append(remoteexception.getMessage()).toString());
          goto _L3
        RuntimeException runtimeexception;
        runtimeexception;
        Log.e("RemoteViewsAdapter", (new StringBuilder()).append("Error in updateRemoteViews(").append(position).append("): ").append(runtimeexception.getMessage()).toString());
          goto _L3
_L2:
        boolean flag1;
        int j;
        int i = rv.getLayoutId();
        synchronized(mCache.getMetaData()) {
            flag1 = remoteviewsmetadata.isViewTypeInRange(i);
            j = mCache.mMetaData.count;
        }
        FixedSizeRemoteViewsCache fixedsizeremoteviewscache = mCache;
        fixedsizeremoteviewscache;
        JVM INSTR monitorenter ;
        if(!flag1)
            break MISSING_BLOCK_LABEL_298;
        ArrayList arraylist = getVisibleWindow(mVisibleWindowLowerBound, mVisibleWindowUpperBound, j);
        mCache.insert(position, rv, l, arraylist);
        if(flag)
            mMainQueue.post(new Runnable() {

                public void run() {
                    mRequestedViews.notifyOnRemoteViewsLoaded(position, rv);
                }

                final RemoteViewsAdapter this$0;
                final int val$position;
                final RemoteViews val$rv;

             {
                this$0 = RemoteViewsAdapter.this;
                position = i;
                rv = remoteviews;
                super();
            }
            });
_L4:
        fixedsizeremoteviewscache;
        JVM INSTR monitorexit ;
          goto _L3
        Exception exception1;
        exception1;
        throw exception1;
        exception;
        remoteviewsmetadata;
        JVM INSTR monitorexit ;
        throw exception;
        Log.e("RemoteViewsAdapter", "Error: widget's RemoteViewsFactory returns more view types than  indicated by getViewTypeCount() ");
          goto _L4
    }

    private void updateTemporaryMetaData() {
        IRemoteViewsFactory iremoteviewsfactory = mServiceConnection.getRemoteViewsFactory();
        boolean flag;
        int i;
        int j;
        RemoteViews remoteviews;
        RemoteViews remoteviews1;
        flag = iremoteviewsfactory.hasStableIds();
        i = iremoteviewsfactory.getViewTypeCount();
        j = iremoteviewsfactory.getCount();
        remoteviews = iremoteviewsfactory.getLoadingView();
        remoteviews1 = null;
        if(j > 0 && remoteviews == null)
            remoteviews1 = iremoteviewsfactory.getViewAt(0);
        RemoteViewsMetaData remoteviewsmetadata = mCache.getTemporaryMetaData();
        remoteviewsmetadata;
        JVM INSTR monitorenter ;
        remoteviewsmetadata.hasStableIds = flag;
        remoteviewsmetadata.viewTypeCount = i + 1;
        remoteviewsmetadata.count = j;
        remoteviewsmetadata.setLoadingViewTemplates(remoteviews, remoteviews1);
        break MISSING_BLOCK_LABEL_141;
        RemoteException remoteexception;
        remoteexception;
        processException("updateMetaData", remoteexception);
        break MISSING_BLOCK_LABEL_141;
        RuntimeException runtimeexception;
        runtimeexception;
        processException("updateMetaData", runtimeexception);
    }

    protected void finalize() throws Throwable {
        if(mWorkerThread != null)
            mWorkerThread.quit();
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public int getCount() {
        RemoteViewsMetaData remoteviewsmetadata = mCache.getMetaData();
        remoteviewsmetadata;
        JVM INSTR monitorenter ;
        int i = remoteviewsmetadata.count;
        return i;
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        FixedSizeRemoteViewsCache fixedsizeremoteviewscache = mCache;
        fixedsizeremoteviewscache;
        JVM INSTR monitorenter ;
        long l;
        if(mCache.containsMetaDataAt(i))
            l = mCache.getMetaDataAt(i).itemId;
        else
            l = 0L;
        return l;
    }

    public int getItemViewType(int i) {
        FixedSizeRemoteViewsCache fixedsizeremoteviewscache = mCache;
        fixedsizeremoteviewscache;
        JVM INSTR monitorenter ;
        if(!mCache.containsMetaDataAt(i)) goto _L2; else goto _L1
_L1:
        int k = mCache.getMetaDataAt(i).typeId;
        int j;
        synchronized(mCache.getMetaData()) {
            j = remoteviewsmetadata.getMappedViewType(k);
        }
_L4:
        return j;
_L2:
        j = 0;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
        exception1;
        remoteviewsmetadata;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    public Intent getRemoteViewsServiceIntent() {
        return mIntent;
    }

    public View getView(int i, View view, ViewGroup viewgroup) {
        FixedSizeRemoteViewsCache fixedsizeremoteviewscache = mCache;
        fixedsizeremoteviewscache;
        JVM INSTR monitorenter ;
        boolean flag;
        boolean flag1;
        boolean flag2;
        flag = mCache.containsRemoteViewAt(i);
        flag1 = mServiceConnection.isConnected();
        flag2 = false;
        if(flag || flag1) goto _L2; else goto _L1
_L1:
        requestBindService();
_L18:
        if(!flag) goto _L4; else goto _L3
_L3:
        View view1;
        int j;
        view1 = null;
        j = 0;
        if(!(view instanceof RemoteViewsFrameLayout)) goto _L6; else goto _L5
_L5:
        RemoteViewsFrameLayout remoteviewsframelayout1;
        RemoteViewsFrameLayout remoteviewsframelayout3 = (RemoteViewsFrameLayout)view;
        view1 = remoteviewsframelayout3.getChildAt(0);
        j = getConvertViewTypeId(view1);
        remoteviewsframelayout1 = remoteviewsframelayout3;
_L16:
        Context context;
        RemoteViews remoteviews;
        int k;
        context = viewgroup.getContext();
        remoteviews = mCache.getRemoteViewsAt(i);
        k = mCache.getMetaDataAt(i).typeId;
        if(remoteviewsframelayout1 == null) goto _L8; else goto _L7
_L7:
        if(j != k) goto _L10; else goto _L9
_L9:
        remoteviews.reapply(context, view1);
        if(!flag2)
            break MISSING_BLOCK_LABEL_149;
        loadNextIndexInBackground();
        fixedsizeremoteviewscache;
        JVM INSTR monitorexit ;
        RemoteViewsFrameLayout remoteviewsframelayout = remoteviewsframelayout1;
          goto _L11
_L2:
        boolean flag3 = mCache.queuePositionsToBePreloadedFromRequestedPosition(i);
        flag2 = flag3;
        continue; /* Loop/switch isn't completed */
_L10:
        remoteviewsframelayout1.removeAllViews();
        RemoteViewsFrameLayout remoteviewsframelayout2 = remoteviewsframelayout1;
_L12:
        View view2 = remoteviews.apply(context, viewgroup);
        view2.setTagInternal(0x102023a, new Integer(k));
        remoteviewsframelayout2.addView(view2);
        if(!flag2)
            break MISSING_BLOCK_LABEL_228;
        loadNextIndexInBackground();
        fixedsizeremoteviewscache;
        JVM INSTR monitorexit ;
        remoteviewsframelayout = remoteviewsframelayout2;
          goto _L11
_L8:
        remoteviewsframelayout2 = new RemoteViewsFrameLayout(context);
          goto _L12
        Exception exception2;
        exception2;
        remoteviewsframelayout1;
_L15:
        Log.w("RemoteViewsAdapter", (new StringBuilder()).append("Error inflating RemoteViews at position: ").append(i).append(", using").append("loading view instead").append(exception2).toString());
        synchronized(mCache.getMetaData()) {
            remoteviewsframelayout = remoteviewsmetadata1.createLoadingView(i, view, viewgroup, mCache, mLayoutInflater);
        }
        if(flag2)
            loadNextIndexInBackground();
        fixedsizeremoteviewscache;
        JVM INSTR monitorexit ;
        break; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        throw exception;
        exception4;
        remoteviewsmetadata1;
        JVM INSTR monitorexit ;
        throw exception4;
        Exception exception3;
        exception3;
_L14:
        if(!flag2)
            break MISSING_BLOCK_LABEL_375;
        loadNextIndexInBackground();
        throw exception3;
_L4:
        synchronized(mCache.getMetaData()) {
            remoteviewsframelayout = remoteviewsmetadata.createLoadingView(i, view, viewgroup, mCache, mLayoutInflater);
        }
        mRequestedViews.add(i, remoteviewsframelayout);
        mCache.queueRequestedPositionToLoad(i);
        loadNextIndexInBackground();
        fixedsizeremoteviewscache;
        JVM INSTR monitorexit ;
        break; /* Loop/switch isn't completed */
        exception1;
        remoteviewsmetadata;
        JVM INSTR monitorexit ;
        throw exception1;
        exception3;
        remoteviewsframelayout1;
        if(true) goto _L14; else goto _L13
_L13:
        break; /* Loop/switch isn't completed */
        exception2;
        if(true) goto _L15; else goto _L11
_L6:
        remoteviewsframelayout1 = null;
          goto _L16
_L11:
        return remoteviewsframelayout;
        if(true) goto _L18; else goto _L17
_L17:
    }

    public int getViewTypeCount() {
        RemoteViewsMetaData remoteviewsmetadata = mCache.getMetaData();
        remoteviewsmetadata;
        JVM INSTR monitorenter ;
        int i = remoteviewsmetadata.viewTypeCount;
        return i;
    }

    public boolean handleMessage(Message message) {
        boolean flag = false;
        message.what;
        JVM INSTR tableswitch 1 1: default 24
    //                   1 26;
           goto _L1 _L2
_L1:
        return flag;
_L2:
        if(mServiceConnection.isConnected())
            mServiceConnection.unbind(mContext, mAppWidgetId, mIntent);
        flag = true;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean hasStableIds() {
        RemoteViewsMetaData remoteviewsmetadata = mCache.getMetaData();
        remoteviewsmetadata;
        JVM INSTR monitorenter ;
        boolean flag = remoteviewsmetadata.hasStableIds;
        return flag;
    }

    public boolean isDataReady() {
        return mDataReady;
    }

    public boolean isEmpty() {
        boolean flag;
        if(getCount() <= 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void notifyDataSetChanged() {
        mMainQueue.removeMessages(1);
        if(!mServiceConnection.isConnected()) {
            if(!mNotifyDataSetChangedAfterOnServiceConnected) {
                mNotifyDataSetChangedAfterOnServiceConnected = true;
                requestBindService();
            }
        } else {
            mWorkerQueue.post(new Runnable() {

                public void run() {
                    onNotifyDataSetChanged();
                }

                final RemoteViewsAdapter this$0;

             {
                this$0 = RemoteViewsAdapter.this;
                super();
            }
            });
        }
    }

    public void saveRemoteViewsCache() {
        final Pair key = new Pair(new android.content.Intent.FilterComparison(mIntent), Integer.valueOf(mAppWidgetId));
        HashMap hashmap = sCachedRemoteViewsCaches;
        hashmap;
        JVM INSTR monitorenter ;
        if(sRemoteViewsCacheRemoveRunnables.containsKey(key)) {
            sCacheRemovalQueue.removeCallbacks((Runnable)sRemoteViewsCacheRemoveRunnables.get(key));
            sRemoteViewsCacheRemoveRunnables.remove(key);
        }
        int i;
        synchronized(mCache.mMetaData) {
            i = mCache.mMetaData.count;
        }
        int j;
        synchronized(mCache) {
            j = mCache.mIndexRemoteViews.size();
        }
        if(i <= 0 || j <= 0)
            break MISSING_BLOCK_LABEL_139;
        sCachedRemoteViewsCaches.put(key, mCache);
        Runnable runnable = new Runnable() {

            public void run() {
                HashMap hashmap1 = RemoteViewsAdapter.sCachedRemoteViewsCaches;
                hashmap1;
                JVM INSTR monitorenter ;
                if(RemoteViewsAdapter.sCachedRemoteViewsCaches.containsKey(key))
                    RemoteViewsAdapter.sCachedRemoteViewsCaches.remove(key);
                if(RemoteViewsAdapter.sRemoteViewsCacheRemoveRunnables.containsKey(key))
                    RemoteViewsAdapter.sRemoteViewsCacheRemoveRunnables.remove(key);
                return;
            }

            final RemoteViewsAdapter this$0;
            final Pair val$key;

             {
                this$0 = RemoteViewsAdapter.this;
                key = pair;
                super();
            }
        };
        sRemoteViewsCacheRemoveRunnables.put(key, runnable);
        sCacheRemovalQueue.postDelayed(runnable, 5000L);
        hashmap;
        JVM INSTR monitorexit ;
        return;
        exception1;
        remoteviewsmetadata;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        throw exception;
        exception2;
        fixedsizeremoteviewscache;
        JVM INSTR monitorexit ;
        throw exception2;
    }

    public void setVisibleRangeHint(int i, int j) {
        mVisibleWindowLowerBound = i;
        mVisibleWindowUpperBound = j;
    }

    void superNotifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    private static final int REMOTE_VIEWS_CACHE_DURATION = 5000;
    private static final String TAG = "RemoteViewsAdapter";
    private static Handler sCacheRemovalQueue;
    private static HandlerThread sCacheRemovalThread;
    private static final HashMap sCachedRemoteViewsCaches = new HashMap();
    private static final int sDefaultCacheSize = 40;
    private static final int sDefaultLoadingViewHeight = 50;
    private static final int sDefaultMessageType = 0;
    private static final HashMap sRemoteViewsCacheRemoveRunnables = new HashMap();
    private static final int sUnbindServiceDelay = 5000;
    private static final int sUnbindServiceMessageType = 1;
    private final int mAppWidgetId;
    private FixedSizeRemoteViewsCache mCache;
    private WeakReference mCallback;
    private final Context mContext;
    private boolean mDataReady;
    private final Intent mIntent;
    private LayoutInflater mLayoutInflater;
    private Handler mMainQueue;
    private boolean mNotifyDataSetChangedAfterOnServiceConnected;
    private RemoteViewsFrameLayoutRefSet mRequestedViews;
    private RemoteViewsAdapterServiceConnection mServiceConnection;
    private int mVisibleWindowLowerBound;
    private int mVisibleWindowUpperBound;
    private Handler mWorkerQueue;
    private HandlerThread mWorkerThread;















}

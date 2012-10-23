// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.util.HashMap;

// Referenced classes of package android.widget:
//            RemoteViews

public abstract class RemoteViewsService extends Service {
    private static class RemoteViewsFactoryAdapter extends com.android.internal.widget.IRemoteViewsFactory.Stub {

        /**
         * @deprecated Method getCount is deprecated
         */

        public int getCount() {
            this;
            JVM INSTR monitorenter ;
            int i = 0;
            int j = mFactory.getCount();
            i = j;
_L2:
            this;
            JVM INSTR monitorexit ;
            return i;
            Exception exception1;
            exception1;
            Thread thread = Thread.currentThread();
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(thread, exception1);
            if(true) goto _L2; else goto _L1
_L1:
            Exception exception;
            exception;
            throw exception;
        }

        /**
         * @deprecated Method getItemId is deprecated
         */

        public long getItemId(int i) {
            this;
            JVM INSTR monitorenter ;
            long l = 0L;
            long l1 = mFactory.getItemId(i);
            l = l1;
_L2:
            this;
            JVM INSTR monitorexit ;
            return l;
            Exception exception1;
            exception1;
            Thread thread = Thread.currentThread();
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(thread, exception1);
            if(true) goto _L2; else goto _L1
_L1:
            Exception exception;
            exception;
            throw exception;
        }

        /**
         * @deprecated Method getLoadingView is deprecated
         */

        public RemoteViews getLoadingView() {
            this;
            JVM INSTR monitorenter ;
            RemoteViews remoteviews = null;
            RemoteViews remoteviews1 = mFactory.getLoadingView();
            remoteviews = remoteviews1;
_L2:
            this;
            JVM INSTR monitorexit ;
            return remoteviews;
            Exception exception1;
            exception1;
            Thread thread = Thread.currentThread();
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(thread, exception1);
            if(true) goto _L2; else goto _L1
_L1:
            Exception exception;
            exception;
            throw exception;
        }

        /**
         * @deprecated Method getViewAt is deprecated
         */

        public RemoteViews getViewAt(int i) {
            this;
            JVM INSTR monitorenter ;
            RemoteViews remoteviews = null;
            remoteviews = mFactory.getViewAt(i);
            if(remoteviews != null)
                remoteviews.setIsWidgetCollectionChild(true);
_L2:
            this;
            JVM INSTR monitorexit ;
            return remoteviews;
            Exception exception1;
            exception1;
            Thread thread = Thread.currentThread();
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(thread, exception1);
            if(true) goto _L2; else goto _L1
_L1:
            Exception exception;
            exception;
            throw exception;
        }

        /**
         * @deprecated Method getViewTypeCount is deprecated
         */

        public int getViewTypeCount() {
            this;
            JVM INSTR monitorenter ;
            int i = 0;
            int j = mFactory.getViewTypeCount();
            i = j;
_L2:
            this;
            JVM INSTR monitorexit ;
            return i;
            Exception exception1;
            exception1;
            Thread thread = Thread.currentThread();
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(thread, exception1);
            if(true) goto _L2; else goto _L1
_L1:
            Exception exception;
            exception;
            throw exception;
        }

        /**
         * @deprecated Method hasStableIds is deprecated
         */

        public boolean hasStableIds() {
            this;
            JVM INSTR monitorenter ;
            boolean flag = false;
            boolean flag1 = mFactory.hasStableIds();
            flag = flag1;
_L2:
            this;
            JVM INSTR monitorexit ;
            return flag;
            Exception exception1;
            exception1;
            Thread thread = Thread.currentThread();
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(thread, exception1);
            if(true) goto _L2; else goto _L1
_L1:
            Exception exception;
            exception;
            throw exception;
        }

        /**
         * @deprecated Method isCreated is deprecated
         */

        public boolean isCreated() {
            this;
            JVM INSTR monitorenter ;
            boolean flag = mIsCreated;
            this;
            JVM INSTR monitorexit ;
            return flag;
            Exception exception;
            exception;
            throw exception;
        }

        /**
         * @deprecated Method onDataSetChanged is deprecated
         */

        public void onDataSetChanged() {
            this;
            JVM INSTR monitorenter ;
            mFactory.onDataSetChanged();
_L2:
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception1;
            exception1;
            Thread thread = Thread.currentThread();
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(thread, exception1);
            if(true) goto _L2; else goto _L1
_L1:
            Exception exception;
            exception;
            throw exception;
        }

        /**
         * @deprecated Method onDataSetChangedAsync is deprecated
         */

        public void onDataSetChangedAsync() {
            this;
            JVM INSTR monitorenter ;
            onDataSetChanged();
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public void onDestroy(Intent intent) {
            Object obj = RemoteViewsService.sLock;
            obj;
            JVM INSTR monitorenter ;
            android.content.Intent.FilterComparison filtercomparison;
            RemoteViewsFactory remoteviewsfactory;
            filtercomparison = new android.content.Intent.FilterComparison(intent);
            if(!RemoteViewsService.sRemoteViewFactories.containsKey(filtercomparison))
                break MISSING_BLOCK_LABEL_52;
            remoteviewsfactory = (RemoteViewsFactory)RemoteViewsService.sRemoteViewFactories.get(filtercomparison);
            try {
                remoteviewsfactory.onDestroy();
            }
            catch(Exception exception1) {
                Thread thread = Thread.currentThread();
                Thread.getDefaultUncaughtExceptionHandler().uncaughtException(thread, exception1);
            }
            RemoteViewsService.sRemoteViewFactories.remove(filtercomparison);
            obj;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        private RemoteViewsFactory mFactory;
        private boolean mIsCreated;

        public RemoteViewsFactoryAdapter(RemoteViewsFactory remoteviewsfactory, boolean flag) {
            mFactory = remoteviewsfactory;
            mIsCreated = flag;
        }
    }

    public static interface RemoteViewsFactory {

        public abstract int getCount();

        public abstract long getItemId(int i);

        public abstract RemoteViews getLoadingView();

        public abstract RemoteViews getViewAt(int i);

        public abstract int getViewTypeCount();

        public abstract boolean hasStableIds();

        public abstract void onCreate();

        public abstract void onDataSetChanged();

        public abstract void onDestroy();
    }


    public RemoteViewsService() {
    }

    public IBinder onBind(Intent intent) {
        Object obj = sLock;
        obj;
        JVM INSTR monitorenter ;
        android.content.Intent.FilterComparison filtercomparison = new android.content.Intent.FilterComparison(intent);
        RemoteViewsFactory remoteviewsfactory;
        boolean flag;
        RemoteViewsFactoryAdapter remoteviewsfactoryadapter;
        if(!sRemoteViewFactories.containsKey(filtercomparison)) {
            remoteviewsfactory = onGetViewFactory(intent);
            sRemoteViewFactories.put(filtercomparison, remoteviewsfactory);
            remoteviewsfactory.onCreate();
            flag = false;
        } else {
            remoteviewsfactory = (RemoteViewsFactory)sRemoteViewFactories.get(filtercomparison);
            flag = true;
        }
        remoteviewsfactoryadapter = new RemoteViewsFactoryAdapter(remoteviewsfactory, flag);
        return remoteviewsfactoryadapter;
    }

    public abstract RemoteViewsFactory onGetViewFactory(Intent intent);

    private static final String LOG_TAG = "RemoteViewsService";
    private static final Object sLock = new Object();
    private static final HashMap sRemoteViewFactories = new HashMap();



}

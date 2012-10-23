// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.Loader;
import android.os.Bundle;
import android.util.*;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

// Referenced classes of package android.app:
//            LoaderManager, Activity, FragmentManagerImpl

class LoaderManagerImpl extends LoaderManager {
    final class LoaderInfo
        implements android.content.Loader.OnLoadCompleteListener, android.content.Loader.OnLoadCanceledListener {

        void callOnLoadFinished(Loader loader, Object obj) {
            String s;
            if(mCallbacks == null)
                break MISSING_BLOCK_LABEL_132;
            s = null;
            if(mActivity != null) {
                s = mActivity.mFragments.mNoTransactionsBecause;
                mActivity.mFragments.mNoTransactionsBecause = "onLoadFinished";
            }
            if(LoaderManagerImpl.DEBUG)
                Log.v("LoaderManager", (new StringBuilder()).append("  onLoadFinished in ").append(loader).append(": ").append(loader.dataToString(obj)).toString());
            mCallbacks.onLoadFinished(loader, obj);
            if(mActivity != null)
                mActivity.mFragments.mNoTransactionsBecause = s;
            mDeliveredData = true;
            return;
            Exception exception;
            exception;
            if(mActivity != null)
                mActivity.mFragments.mNoTransactionsBecause = s;
            throw exception;
        }

        void cancel() {
            if(LoaderManagerImpl.DEBUG)
                Log.v("LoaderManager", (new StringBuilder()).append("  Canceling: ").append(this).toString());
            if(mStarted && mLoader != null && mListenerRegistered && !mLoader.cancelLoad())
                onLoadCanceled(mLoader);
        }

        void destroy() {
            String s;
            if(LoaderManagerImpl.DEBUG)
                Log.v("LoaderManager", (new StringBuilder()).append("  Destroying: ").append(this).toString());
            mDestroyed = true;
            boolean flag = mDeliveredData;
            mDeliveredData = false;
            if(mCallbacks == null || mLoader == null || !mHaveData || !flag)
                break MISSING_BLOCK_LABEL_180;
            if(LoaderManagerImpl.DEBUG)
                Log.v("LoaderManager", (new StringBuilder()).append("  Reseting: ").append(this).toString());
            s = null;
            if(mActivity != null) {
                s = mActivity.mFragments.mNoTransactionsBecause;
                mActivity.mFragments.mNoTransactionsBecause = "onLoaderReset";
            }
            mCallbacks.onLoaderReset(mLoader);
            if(mActivity != null)
                mActivity.mFragments.mNoTransactionsBecause = s;
            mCallbacks = null;
            mData = null;
            mHaveData = false;
            if(mLoader != null) {
                if(mListenerRegistered) {
                    mListenerRegistered = false;
                    mLoader.unregisterListener(this);
                    mLoader.unregisterOnLoadCanceledListener(this);
                }
                mLoader.reset();
            }
            if(mPendingLoader != null)
                mPendingLoader.destroy();
            return;
            Exception exception;
            exception;
            if(mActivity != null)
                mActivity.mFragments.mNoTransactionsBecause = s;
            throw exception;
        }

        public void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
            printwriter.print(s);
            printwriter.print("mId=");
            printwriter.print(mId);
            printwriter.print(" mArgs=");
            printwriter.println(mArgs);
            printwriter.print(s);
            printwriter.print("mCallbacks=");
            printwriter.println(mCallbacks);
            printwriter.print(s);
            printwriter.print("mLoader=");
            printwriter.println(mLoader);
            if(mLoader != null)
                mLoader.dump((new StringBuilder()).append(s).append("  ").toString(), filedescriptor, printwriter, as);
            if(mHaveData || mDeliveredData) {
                printwriter.print(s);
                printwriter.print("mHaveData=");
                printwriter.print(mHaveData);
                printwriter.print("  mDeliveredData=");
                printwriter.println(mDeliveredData);
                printwriter.print(s);
                printwriter.print("mData=");
                printwriter.println(mData);
            }
            printwriter.print(s);
            printwriter.print("mStarted=");
            printwriter.print(mStarted);
            printwriter.print(" mReportNextStart=");
            printwriter.print(mReportNextStart);
            printwriter.print(" mDestroyed=");
            printwriter.println(mDestroyed);
            printwriter.print(s);
            printwriter.print("mRetaining=");
            printwriter.print(mRetaining);
            printwriter.print(" mRetainingStarted=");
            printwriter.print(mRetainingStarted);
            printwriter.print(" mListenerRegistered=");
            printwriter.println(mListenerRegistered);
            if(mPendingLoader != null) {
                printwriter.print(s);
                printwriter.println("Pending Loader ");
                printwriter.print(mPendingLoader);
                printwriter.println(":");
                mPendingLoader.dump((new StringBuilder()).append(s).append("  ").toString(), filedescriptor, printwriter, as);
            }
        }

        void finishRetain() {
            if(mRetaining) {
                if(LoaderManagerImpl.DEBUG)
                    Log.v("LoaderManager", (new StringBuilder()).append("  Finished Retaining: ").append(this).toString());
                mRetaining = false;
                if(mStarted != mRetainingStarted && !mStarted)
                    stop();
            }
            if(mStarted && mHaveData && !mReportNextStart)
                callOnLoadFinished(mLoader, mData);
        }

        public void onLoadCanceled(Loader loader) {
            if(LoaderManagerImpl.DEBUG)
                Log.v("LoaderManager", (new StringBuilder()).append("onLoadCanceled: ").append(this).toString());
            if(!mDestroyed) goto _L2; else goto _L1
_L1:
            if(LoaderManagerImpl.DEBUG)
                Log.v("LoaderManager", "  Ignoring load canceled -- destroyed");
_L4:
            return;
_L2:
            if(mLoaders.get(mId) != this) {
                if(LoaderManagerImpl.DEBUG)
                    Log.v("LoaderManager", "  Ignoring load canceled -- not active");
            } else {
                LoaderInfo loaderinfo = mPendingLoader;
                if(loaderinfo != null) {
                    if(LoaderManagerImpl.DEBUG)
                        Log.v("LoaderManager", (new StringBuilder()).append("  Switching to pending loader: ").append(loaderinfo).toString());
                    mPendingLoader = null;
                    mLoaders.put(mId, null);
                    destroy();
                    installLoader(loaderinfo);
                }
            }
            if(true) goto _L4; else goto _L3
_L3:
        }

        public void onLoadComplete(Loader loader, Object obj) {
            if(LoaderManagerImpl.DEBUG)
                Log.v("LoaderManager", (new StringBuilder()).append("onLoadComplete: ").append(this).toString());
            if(!mDestroyed) goto _L2; else goto _L1
_L1:
            if(LoaderManagerImpl.DEBUG)
                Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
_L4:
            return;
_L2:
            if(mLoaders.get(mId) != this) {
                if(LoaderManagerImpl.DEBUG)
                    Log.v("LoaderManager", "  Ignoring load complete -- not active");
            } else {
                LoaderInfo loaderinfo = mPendingLoader;
                if(loaderinfo != null) {
                    if(LoaderManagerImpl.DEBUG)
                        Log.v("LoaderManager", (new StringBuilder()).append("  Switching to pending loader: ").append(loaderinfo).toString());
                    mPendingLoader = null;
                    mLoaders.put(mId, null);
                    destroy();
                    installLoader(loaderinfo);
                } else {
                    if(mData != obj || !mHaveData) {
                        mData = obj;
                        mHaveData = true;
                        if(mStarted)
                            callOnLoadFinished(loader, obj);
                    }
                    LoaderInfo loaderinfo1 = (LoaderInfo)mInactiveLoaders.get(mId);
                    if(loaderinfo1 != null && loaderinfo1 != this) {
                        loaderinfo1.mDeliveredData = false;
                        loaderinfo1.destroy();
                        mInactiveLoaders.remove(mId);
                    }
                    if(mActivity != null && !hasRunningLoaders())
                        mActivity.mFragments.startPendingDeferredFragments();
                }
            }
            if(true) goto _L4; else goto _L3
_L3:
        }

        void reportStart() {
            if(mStarted && mReportNextStart) {
                mReportNextStart = false;
                if(mHaveData)
                    callOnLoadFinished(mLoader, mData);
            }
        }

        void retain() {
            if(LoaderManagerImpl.DEBUG)
                Log.v("LoaderManager", (new StringBuilder()).append("  Retaining: ").append(this).toString());
            mRetaining = true;
            mRetainingStarted = mStarted;
            mStarted = false;
            mCallbacks = null;
        }

        void start() {
            if(!mRetaining || !mRetainingStarted) goto _L2; else goto _L1
_L1:
            mStarted = true;
_L4:
            return;
_L2:
            if(!mStarted) {
                mStarted = true;
                if(LoaderManagerImpl.DEBUG)
                    Log.v("LoaderManager", (new StringBuilder()).append("  Starting: ").append(this).toString());
                if(mLoader == null && mCallbacks != null)
                    mLoader = mCallbacks.onCreateLoader(mId, mArgs);
                if(mLoader != null) {
                    if(mLoader.getClass().isMemberClass() && !Modifier.isStatic(mLoader.getClass().getModifiers()))
                        throw new IllegalArgumentException((new StringBuilder()).append("Object returned from onCreateLoader must not be a non-static inner member class: ").append(mLoader).toString());
                    if(!mListenerRegistered) {
                        mLoader.registerListener(mId, this);
                        mLoader.registerOnLoadCanceledListener(this);
                        mListenerRegistered = true;
                    }
                    mLoader.startLoading();
                }
            }
            if(true) goto _L4; else goto _L3
_L3:
        }

        void stop() {
            if(LoaderManagerImpl.DEBUG)
                Log.v("LoaderManager", (new StringBuilder()).append("  Stopping: ").append(this).toString());
            mStarted = false;
            if(!mRetaining && mLoader != null && mListenerRegistered) {
                mListenerRegistered = false;
                mLoader.unregisterListener(this);
                mLoader.unregisterOnLoadCanceledListener(this);
                mLoader.stopLoading();
            }
        }

        public String toString() {
            StringBuilder stringbuilder = new StringBuilder(64);
            stringbuilder.append("LoaderInfo{");
            stringbuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringbuilder.append(" #");
            stringbuilder.append(mId);
            stringbuilder.append(" : ");
            DebugUtils.buildShortClassTag(mLoader, stringbuilder);
            stringbuilder.append("}}");
            return stringbuilder.toString();
        }

        final Bundle mArgs;
        LoaderManager.LoaderCallbacks mCallbacks;
        Object mData;
        boolean mDeliveredData;
        boolean mDestroyed;
        boolean mHaveData;
        final int mId;
        boolean mListenerRegistered;
        Loader mLoader;
        LoaderInfo mPendingLoader;
        boolean mReportNextStart;
        boolean mRetaining;
        boolean mRetainingStarted;
        boolean mStarted;
        final LoaderManagerImpl this$0;

        public LoaderInfo(int i, Bundle bundle, LoaderManager.LoaderCallbacks loadercallbacks) {
            this$0 = LoaderManagerImpl.this;
            super();
            mId = i;
            mArgs = bundle;
            mCallbacks = loadercallbacks;
        }
    }


    LoaderManagerImpl(Activity activity, boolean flag) {
        mActivity = activity;
        mStarted = flag;
    }

    private LoaderInfo createAndInstallLoader(int i, Bundle bundle, LoaderManager.LoaderCallbacks loadercallbacks) {
        LoaderInfo loaderinfo;
        mCreatingLoader = true;
        loaderinfo = createLoader(i, bundle, loadercallbacks);
        installLoader(loaderinfo);
        mCreatingLoader = false;
        return loaderinfo;
        Exception exception;
        exception;
        mCreatingLoader = false;
        throw exception;
    }

    private LoaderInfo createLoader(int i, Bundle bundle, LoaderManager.LoaderCallbacks loadercallbacks) {
        LoaderInfo loaderinfo = new LoaderInfo(i, bundle, loadercallbacks);
        loaderinfo.mLoader = loadercallbacks.onCreateLoader(i, bundle);
        return loaderinfo;
    }

    public void destroyLoader(int i) {
        if(mCreatingLoader)
            throw new IllegalStateException("Called while creating a loader");
        if(DEBUG)
            Log.v("LoaderManager", (new StringBuilder()).append("destroyLoader in ").append(this).append(" of ").append(i).toString());
        int j = mLoaders.indexOfKey(i);
        if(j >= 0) {
            LoaderInfo loaderinfo1 = (LoaderInfo)mLoaders.valueAt(j);
            mLoaders.removeAt(j);
            loaderinfo1.destroy();
        }
        int k = mInactiveLoaders.indexOfKey(i);
        if(k >= 0) {
            LoaderInfo loaderinfo = (LoaderInfo)mInactiveLoaders.valueAt(k);
            mInactiveLoaders.removeAt(k);
            loaderinfo.destroy();
        }
        if(mActivity != null && !hasRunningLoaders())
            mActivity.mFragments.startPendingDeferredFragments();
    }

    void doDestroy() {
        if(!mRetaining) {
            if(DEBUG)
                Log.v("LoaderManager", (new StringBuilder()).append("Destroying Active in ").append(this).toString());
            for(int j = -1 + mLoaders.size(); j >= 0; j--)
                ((LoaderInfo)mLoaders.valueAt(j)).destroy();

        }
        if(DEBUG)
            Log.v("LoaderManager", (new StringBuilder()).append("Destroying Inactive in ").append(this).toString());
        for(int i = -1 + mInactiveLoaders.size(); i >= 0; i--)
            ((LoaderInfo)mInactiveLoaders.valueAt(i)).destroy();

        mInactiveLoaders.clear();
    }

    void doReportNextStart() {
        for(int i = -1 + mLoaders.size(); i >= 0; i--)
            ((LoaderInfo)mLoaders.valueAt(i)).mReportNextStart = true;

    }

    void doReportStart() {
        for(int i = -1 + mLoaders.size(); i >= 0; i--)
            ((LoaderInfo)mLoaders.valueAt(i)).reportStart();

    }

    void doRetain() {
        if(DEBUG)
            Log.v("LoaderManager", (new StringBuilder()).append("Retaining in ").append(this).toString());
        if(!mStarted) {
            RuntimeException runtimeexception = new RuntimeException("here");
            runtimeexception.fillInStackTrace();
            Log.w("LoaderManager", (new StringBuilder()).append("Called doRetain when not started: ").append(this).toString(), runtimeexception);
        } else {
            mRetaining = true;
            mStarted = false;
            int i = -1 + mLoaders.size();
            while(i >= 0)  {
                ((LoaderInfo)mLoaders.valueAt(i)).retain();
                i--;
            }
        }
    }

    void doStart() {
        if(DEBUG)
            Log.v("LoaderManager", (new StringBuilder()).append("Starting in ").append(this).toString());
        if(mStarted) {
            RuntimeException runtimeexception = new RuntimeException("here");
            runtimeexception.fillInStackTrace();
            Log.w("LoaderManager", (new StringBuilder()).append("Called doStart when already started: ").append(this).toString(), runtimeexception);
        } else {
            mStarted = true;
            int i = -1 + mLoaders.size();
            while(i >= 0)  {
                ((LoaderInfo)mLoaders.valueAt(i)).start();
                i--;
            }
        }
    }

    void doStop() {
        if(DEBUG)
            Log.v("LoaderManager", (new StringBuilder()).append("Stopping in ").append(this).toString());
        if(!mStarted) {
            RuntimeException runtimeexception = new RuntimeException("here");
            runtimeexception.fillInStackTrace();
            Log.w("LoaderManager", (new StringBuilder()).append("Called doStop when not started: ").append(this).toString(), runtimeexception);
        } else {
            for(int i = -1 + mLoaders.size(); i >= 0; i--)
                ((LoaderInfo)mLoaders.valueAt(i)).stop();

            mStarted = false;
        }
    }

    public void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        if(mLoaders.size() > 0) {
            printwriter.print(s);
            printwriter.println("Active Loaders:");
            String s2 = (new StringBuilder()).append(s).append("    ").toString();
            for(int j = 0; j < mLoaders.size(); j++) {
                LoaderInfo loaderinfo1 = (LoaderInfo)mLoaders.valueAt(j);
                printwriter.print(s);
                printwriter.print("  #");
                printwriter.print(mLoaders.keyAt(j));
                printwriter.print(": ");
                printwriter.println(loaderinfo1.toString());
                loaderinfo1.dump(s2, filedescriptor, printwriter, as);
            }

        }
        if(mInactiveLoaders.size() > 0) {
            printwriter.print(s);
            printwriter.println("Inactive Loaders:");
            String s1 = (new StringBuilder()).append(s).append("    ").toString();
            for(int i = 0; i < mInactiveLoaders.size(); i++) {
                LoaderInfo loaderinfo = (LoaderInfo)mInactiveLoaders.valueAt(i);
                printwriter.print(s);
                printwriter.print("  #");
                printwriter.print(mInactiveLoaders.keyAt(i));
                printwriter.print(": ");
                printwriter.println(loaderinfo.toString());
                loaderinfo.dump(s1, filedescriptor, printwriter, as);
            }

        }
    }

    void finishRetain() {
        if(mRetaining) {
            if(DEBUG)
                Log.v("LoaderManager", (new StringBuilder()).append("Finished Retaining in ").append(this).toString());
            mRetaining = false;
            for(int i = -1 + mLoaders.size(); i >= 0; i--)
                ((LoaderInfo)mLoaders.valueAt(i)).finishRetain();

        }
    }

    public Loader getLoader(int i) {
        if(mCreatingLoader)
            throw new IllegalStateException("Called while creating a loader");
        LoaderInfo loaderinfo = (LoaderInfo)mLoaders.get(i);
        Loader loader;
        if(loaderinfo != null) {
            if(loaderinfo.mPendingLoader != null)
                loader = loaderinfo.mPendingLoader.mLoader;
            else
                loader = loaderinfo.mLoader;
        } else {
            loader = null;
        }
        return loader;
    }

    public boolean hasRunningLoaders() {
        boolean flag = false;
        int i = mLoaders.size();
        int j = 0;
        while(j < i)  {
            LoaderInfo loaderinfo = (LoaderInfo)mLoaders.valueAt(j);
            boolean flag1;
            if(loaderinfo.mStarted && !loaderinfo.mDeliveredData)
                flag1 = true;
            else
                flag1 = false;
            flag |= flag1;
            j++;
        }
        return flag;
    }

    public Loader initLoader(int i, Bundle bundle, LoaderManager.LoaderCallbacks loadercallbacks) {
        if(mCreatingLoader)
            throw new IllegalStateException("Called while creating a loader");
        LoaderInfo loaderinfo = (LoaderInfo)mLoaders.get(i);
        if(DEBUG)
            Log.v("LoaderManager", (new StringBuilder()).append("initLoader in ").append(this).append(": args=").append(bundle).toString());
        if(loaderinfo == null) {
            loaderinfo = createAndInstallLoader(i, bundle, loadercallbacks);
            if(DEBUG)
                Log.v("LoaderManager", (new StringBuilder()).append("  Created new loader ").append(loaderinfo).toString());
        } else {
            if(DEBUG)
                Log.v("LoaderManager", (new StringBuilder()).append("  Re-using existing loader ").append(loaderinfo).toString());
            loaderinfo.mCallbacks = loadercallbacks;
        }
        if(loaderinfo.mHaveData && mStarted)
            loaderinfo.callOnLoadFinished(loaderinfo.mLoader, loaderinfo.mData);
        return loaderinfo.mLoader;
    }

    void installLoader(LoaderInfo loaderinfo) {
        mLoaders.put(loaderinfo.mId, loaderinfo);
        if(mStarted)
            loaderinfo.start();
    }

    public Loader restartLoader(int i, Bundle bundle, LoaderManager.LoaderCallbacks loadercallbacks) {
        LoaderInfo loaderinfo;
        if(mCreatingLoader)
            throw new IllegalStateException("Called while creating a loader");
        loaderinfo = (LoaderInfo)mLoaders.get(i);
        if(DEBUG)
            Log.v("LoaderManager", (new StringBuilder()).append("restartLoader in ").append(this).append(": args=").append(bundle).toString());
        if(loaderinfo == null) goto _L2; else goto _L1
_L1:
        LoaderInfo loaderinfo1 = (LoaderInfo)mInactiveLoaders.get(i);
        if(loaderinfo1 == null) goto _L4; else goto _L3
_L3:
        if(!loaderinfo.mHaveData) goto _L6; else goto _L5
_L5:
        if(DEBUG)
            Log.v("LoaderManager", (new StringBuilder()).append("  Removing last inactive loader: ").append(loaderinfo).toString());
        loaderinfo1.mDeliveredData = false;
        loaderinfo1.destroy();
        loaderinfo.mLoader.abandon();
        mInactiveLoaders.put(i, loaderinfo);
_L2:
        Loader loader = createAndInstallLoader(i, bundle, loadercallbacks).mLoader;
_L7:
        return loader;
_L6:
        if(!loaderinfo.mStarted) {
            if(DEBUG)
                Log.v("LoaderManager", "  Current loader is stopped; replacing");
            mLoaders.put(i, null);
            loaderinfo.destroy();
            continue; /* Loop/switch isn't completed */
        }
        if(DEBUG)
            Log.v("LoaderManager", "  Current loader is running; attempting to cancel");
        loaderinfo.cancel();
        if(loaderinfo.mPendingLoader != null) {
            if(DEBUG)
                Log.v("LoaderManager", (new StringBuilder()).append("  Removing pending loader: ").append(loaderinfo.mPendingLoader).toString());
            loaderinfo.mPendingLoader.destroy();
            loaderinfo.mPendingLoader = null;
        }
        if(DEBUG)
            Log.v("LoaderManager", "  Enqueuing as new pending loader");
        loaderinfo.mPendingLoader = createLoader(i, bundle, loadercallbacks);
        loader = loaderinfo.mPendingLoader.mLoader;
        if(true) goto _L7; else goto _L4
_L4:
        if(DEBUG)
            Log.v("LoaderManager", (new StringBuilder()).append("  Making last loader inactive: ").append(loaderinfo).toString());
        loaderinfo.mLoader.abandon();
        mInactiveLoaders.put(i, loaderinfo);
        if(true) goto _L2; else goto _L8
_L8:
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append("LoaderManager{");
        stringbuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringbuilder.append(" in ");
        DebugUtils.buildShortClassTag(mActivity, stringbuilder);
        stringbuilder.append("}}");
        return stringbuilder.toString();
    }

    void updateActivity(Activity activity) {
        mActivity = activity;
    }

    static boolean DEBUG = false;
    static final String TAG = "LoaderManager";
    Activity mActivity;
    boolean mCreatingLoader;
    final SparseArray mInactiveLoaders = new SparseArray();
    final SparseArray mLoaders = new SparseArray();
    boolean mRetaining;
    boolean mRetainingStarted;
    boolean mStarted;

    static  {
        DEBUG = false;
    }
}

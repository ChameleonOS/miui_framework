// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.Loader;
import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;

// Referenced classes of package android.app:
//            LoaderManagerImpl

public abstract class LoaderManager {
    public static interface LoaderCallbacks {

        public abstract Loader onCreateLoader(int i, Bundle bundle);

        public abstract void onLoadFinished(Loader loader, Object obj);

        public abstract void onLoaderReset(Loader loader);
    }


    public LoaderManager() {
    }

    public static void enableDebugLogging(boolean flag) {
        LoaderManagerImpl.DEBUG = flag;
    }

    public abstract void destroyLoader(int i);

    public abstract void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[]);

    public abstract Loader getLoader(int i);

    public abstract Loader initLoader(int i, Bundle bundle, LoaderCallbacks loadercallbacks);

    public abstract Loader restartLoader(int i, Bundle bundle, LoaderCallbacks loadercallbacks);
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.*;
import android.content.pm.*;
import android.content.res.*;
import android.os.*;
import android.util.Slog;
import android.view.CompatibilityInfoHolder;
import com.android.internal.util.ArrayUtils;
import java.io.*;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.*;

// Referenced classes of package android.app:
//            ActivityThread, ContextImpl, ApplicationLoaders, Instrumentation, 
//            IntentReceiverLeaked, ActivityManagerNative, IActivityManager, ServiceConnectionLeaked, 
//            Application, IServiceConnection

public final class LoadedApk {
    static final class ServiceDispatcher {
        private final class DeathMonitor
            implements android.os.IBinder.DeathRecipient {

            public void binderDied() {
                death(mName, mService);
            }

            final ComponentName mName;
            final IBinder mService;
            final ServiceDispatcher this$0;

            DeathMonitor(ComponentName componentname, IBinder ibinder) {
                this$0 = ServiceDispatcher.this;
                super();
                mName = componentname;
                mService = ibinder;
            }
        }

        private final class RunConnection
            implements Runnable {

            public void run() {
                if(mCommand != 0) goto _L2; else goto _L1
_L1:
                doConnected(mName, mService);
_L4:
                return;
_L2:
                if(mCommand == 1)
                    doDeath(mName, mService);
                if(true) goto _L4; else goto _L3
_L3:
            }

            final int mCommand;
            final ComponentName mName;
            final IBinder mService;
            final ServiceDispatcher this$0;

            RunConnection(ComponentName componentname, IBinder ibinder, int i) {
                this$0 = ServiceDispatcher.this;
                super();
                mName = componentname;
                mService = ibinder;
                mCommand = i;
            }
        }

        private static class InnerConnection extends IServiceConnection.Stub {

            public void connected(ComponentName componentname, IBinder ibinder) throws RemoteException {
                ServiceDispatcher servicedispatcher = (ServiceDispatcher)mDispatcher.get();
                if(servicedispatcher != null)
                    servicedispatcher.connected(componentname, ibinder);
            }

            final WeakReference mDispatcher;

            InnerConnection(ServiceDispatcher servicedispatcher) {
                mDispatcher = new WeakReference(servicedispatcher);
            }
        }

        private static class ConnectionInfo {

            IBinder binder;
            android.os.IBinder.DeathRecipient deathMonitor;

            private ConnectionInfo() {
            }

        }


        public void connected(ComponentName componentname, IBinder ibinder) {
            if(mActivityThread != null)
                mActivityThread.post(new RunConnection(componentname, ibinder, 0));
            else
                doConnected(componentname, ibinder);
        }

        public void death(ComponentName componentname, IBinder ibinder) {
            this;
            JVM INSTR monitorenter ;
            ConnectionInfo connectioninfo;
            mDied = true;
            connectioninfo = (ConnectionInfo)mActiveConnections.remove(componentname);
            if(connectioninfo != null && connectioninfo.binder == ibinder)
                break MISSING_BLOCK_LABEL_39;
            this;
            JVM INSTR monitorexit ;
            break MISSING_BLOCK_LABEL_98;
            connectioninfo.binder.unlinkToDeath(connectioninfo.deathMonitor, 0);
            this;
            JVM INSTR monitorexit ;
            Exception exception;
            if(mActivityThread != null)
                mActivityThread.post(new RunConnection(componentname, ibinder, 1));
            else
                doDeath(componentname, ibinder);
            break MISSING_BLOCK_LABEL_98;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void doConnected(ComponentName componentname, IBinder ibinder) {
            this;
            JVM INSTR monitorenter ;
            if(!mForgotten) goto _L2; else goto _L1
_L2:
            ConnectionInfo connectioninfo = (ConnectionInfo)mActiveConnections.get(componentname);
            if(connectioninfo == null || connectioninfo.binder != ibinder) goto _L3; else goto _L1
            Exception exception;
            exception;
            throw exception;
_L3:
            if(ibinder == null) goto _L5; else goto _L4
_L4:
            ConnectionInfo connectioninfo1;
            mDied = false;
            connectioninfo1 = new ConnectionInfo();
            connectioninfo1.binder = ibinder;
            connectioninfo1.deathMonitor = new DeathMonitor(componentname, ibinder);
            ibinder.linkToDeath(connectioninfo1.deathMonitor, 0);
            mActiveConnections.put(componentname, connectioninfo1);
_L6:
            if(connectioninfo == null)
                break MISSING_BLOCK_LABEL_136;
            connectioninfo.binder.unlinkToDeath(connectioninfo.deathMonitor, 0);
            this;
            JVM INSTR monitorexit ;
            if(connectioninfo != null)
                mConnection.onServiceDisconnected(componentname);
            if(ibinder != null)
                mConnection.onServiceConnected(componentname, ibinder);
            break; /* Loop/switch isn't completed */
            RemoteException remoteexception;
            remoteexception;
            mActiveConnections.remove(componentname);
            this;
            JVM INSTR monitorexit ;
            break; /* Loop/switch isn't completed */
_L5:
            mActiveConnections.remove(componentname);
            if(true) goto _L6; else goto _L1
_L1:
        }

        public void doDeath(ComponentName componentname, IBinder ibinder) {
            mConnection.onServiceDisconnected(componentname);
        }

        void doForget() {
            this;
            JVM INSTR monitorenter ;
            ConnectionInfo connectioninfo;
            for(Iterator iterator = mActiveConnections.values().iterator(); iterator.hasNext(); connectioninfo.binder.unlinkToDeath(connectioninfo.deathMonitor, 0))
                connectioninfo = (ConnectionInfo)iterator.next();

            break MISSING_BLOCK_LABEL_57;
            Exception exception;
            exception;
            throw exception;
            mActiveConnections.clear();
            mForgotten = true;
            this;
            JVM INSTR monitorexit ;
        }

        int getFlags() {
            return mFlags;
        }

        IServiceConnection getIServiceConnection() {
            return mIServiceConnection;
        }

        ServiceConnectionLeaked getLocation() {
            return mLocation;
        }

        ServiceConnection getServiceConnection() {
            return mConnection;
        }

        RuntimeException getUnbindLocation() {
            return mUnbindLocation;
        }

        void setUnbindLocation(RuntimeException runtimeexception) {
            mUnbindLocation = runtimeexception;
        }

        void validate(Context context, Handler handler) {
            if(mContext != context)
                throw new RuntimeException((new StringBuilder()).append("ServiceConnection ").append(mConnection).append(" registered with differing Context (was ").append(mContext).append(" now ").append(context).append(")").toString());
            if(mActivityThread != handler)
                throw new RuntimeException((new StringBuilder()).append("ServiceConnection ").append(mConnection).append(" registered with differing handler (was ").append(mActivityThread).append(" now ").append(handler).append(")").toString());
            else
                return;
        }

        private final HashMap mActiveConnections = new HashMap();
        private final Handler mActivityThread;
        private final ServiceConnection mConnection;
        private final Context mContext;
        private boolean mDied;
        private final int mFlags;
        private boolean mForgotten;
        private final InnerConnection mIServiceConnection = new InnerConnection(this);
        private final ServiceConnectionLeaked mLocation = new ServiceConnectionLeaked(null);
        private RuntimeException mUnbindLocation;

        ServiceDispatcher(ServiceConnection serviceconnection, Context context, Handler handler, int i) {
            mConnection = serviceconnection;
            mContext = context;
            mActivityThread = handler;
            mLocation.fillInStackTrace();
            mFlags = i;
        }
    }

    static final class ReceiverDispatcher {
        final class Args extends android.content.BroadcastReceiver.PendingResult
            implements Runnable {

            public void run() {
                BroadcastReceiver broadcastreceiver;
                boolean flag;
                IActivityManager iactivitymanager;
                Intent intent;
                broadcastreceiver = mReceiver;
                flag = mOrdered;
                iactivitymanager = ActivityManagerNative.getDefault();
                intent = mCurIntent;
                mCurIntent = null;
                if(broadcastreceiver != null && !mForgotten) goto _L2; else goto _L1
_L1:
                if(mRegistered && flag)
                    sendFinished(iactivitymanager);
_L4:
                return;
_L2:
                Trace.traceBegin(64L, "broadcastReceiveReg");
                try {
                    ClassLoader classloader = mReceiver.getClass().getClassLoader();
                    intent.setExtrasClassLoader(classloader);
                    setExtrasClassLoader(classloader);
                    broadcastreceiver.setPendingResult(this);
                    broadcastreceiver.onReceive(mContext, intent);
                }
                catch(Exception exception) {
                    if(mRegistered && flag)
                        sendFinished(iactivitymanager);
                    if(mInstrumentation == null || !mInstrumentation.onException(mReceiver, exception)) {
                        Trace.traceEnd(64L);
                        throw new RuntimeException((new StringBuilder()).append("Error receiving broadcast ").append(intent).append(" in ").append(mReceiver).toString(), exception);
                    }
                }
                if(broadcastreceiver.getPendingResult() != null)
                    finish();
                Trace.traceEnd(64L);
                if(true) goto _L4; else goto _L3
_L3:
            }

            private Intent mCurIntent;
            private final boolean mOrdered;
            final ReceiverDispatcher this$0;

            public Args(Intent intent, int i, String s, Bundle bundle, boolean flag, boolean flag1) {
                this$0 = ReceiverDispatcher.this;
                int j;
                if(mRegistered)
                    j = 1;
                else
                    j = 2;
                super(i, s, bundle, j, flag, flag1, mIIntentReceiver.asBinder());
                mCurIntent = intent;
                mOrdered = flag;
            }
        }

        static final class InnerReceiver extends android.content.IIntentReceiver.Stub {

            public void performReceive(Intent intent, int i, String s, Bundle bundle, boolean flag, boolean flag1) {
                ReceiverDispatcher receiverdispatcher = (ReceiverDispatcher)mDispatcher.get();
                if(receiverdispatcher == null) goto _L2; else goto _L1
_L1:
                receiverdispatcher.performReceive(intent, i, s, bundle, flag, flag1);
_L4:
                return;
_L2:
                IActivityManager iactivitymanager;
                iactivitymanager = ActivityManagerNative.getDefault();
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_49;
                bundle.setAllowFds(false);
                iactivitymanager.finishReceiver(this, i, s, bundle, false);
                continue; /* Loop/switch isn't completed */
                RemoteException remoteexception;
                remoteexception;
                Slog.w("ActivityThread", "Couldn't finish broadcast to unregistered receiver");
                if(true) goto _L4; else goto _L3
_L3:
            }

            final WeakReference mDispatcher;
            final ReceiverDispatcher mStrongRef;

            InnerReceiver(ReceiverDispatcher receiverdispatcher, boolean flag) {
                mDispatcher = new WeakReference(receiverdispatcher);
                if(!flag)
                    receiverdispatcher = null;
                mStrongRef = receiverdispatcher;
            }
        }


        IIntentReceiver getIIntentReceiver() {
            return mIIntentReceiver;
        }

        BroadcastReceiver getIntentReceiver() {
            return mReceiver;
        }

        IntentReceiverLeaked getLocation() {
            return mLocation;
        }

        RuntimeException getUnregisterLocation() {
            return mUnregisterLocation;
        }

        public void performReceive(Intent intent, int i, String s, Bundle bundle, boolean flag, boolean flag1) {
            Args args = new Args(intent, i, s, bundle, flag, flag1);
            if(!mActivityThread.post(args) && mRegistered && flag)
                args.sendFinished(ActivityManagerNative.getDefault());
        }

        void setUnregisterLocation(RuntimeException runtimeexception) {
            mUnregisterLocation = runtimeexception;
        }

        void validate(Context context, Handler handler) {
            if(mContext != context)
                throw new IllegalStateException((new StringBuilder()).append("Receiver ").append(mReceiver).append(" registered with differing Context (was ").append(mContext).append(" now ").append(context).append(")").toString());
            if(mActivityThread != handler)
                throw new IllegalStateException((new StringBuilder()).append("Receiver ").append(mReceiver).append(" registered with differing handler (was ").append(mActivityThread).append(" now ").append(handler).append(")").toString());
            else
                return;
        }

        final Handler mActivityThread;
        final Context mContext;
        boolean mForgotten;
        final android.content.IIntentReceiver.Stub mIIntentReceiver;
        final Instrumentation mInstrumentation;
        final IntentReceiverLeaked mLocation = new IntentReceiverLeaked(null);
        final BroadcastReceiver mReceiver;
        final boolean mRegistered;
        RuntimeException mUnregisterLocation;

        ReceiverDispatcher(BroadcastReceiver broadcastreceiver, Context context, Handler handler, Instrumentation instrumentation, boolean flag) {
            if(handler == null)
                throw new NullPointerException("Handler must not be null");
            boolean flag1;
            if(!flag)
                flag1 = true;
            else
                flag1 = false;
            mIIntentReceiver = new InnerReceiver(this, flag1);
            mReceiver = broadcastreceiver;
            mContext = context;
            mActivityThread = handler;
            mInstrumentation = instrumentation;
            mRegistered = flag;
            mLocation.fillInStackTrace();
        }
    }

    private static class WarningContextClassLoader extends ClassLoader {

        private void warn(String s) {
            if(!warned) {
                warned = true;
                Thread.currentThread().setContextClassLoader(getParent());
                Slog.w("ActivityThread", (new StringBuilder()).append("ClassLoader.").append(s).append(": ").append("The class loader returned by ").append("Thread.getContextClassLoader() may fail for processes ").append("that host multiple applications. You should explicitly ").append("specify a context class loader. For example: ").append("Thread.setContextClassLoader(getClass().getClassLoader());").toString());
            }
        }

        public void clearAssertionStatus() {
            warn("clearAssertionStatus");
            getParent().clearAssertionStatus();
        }

        public URL getResource(String s) {
            warn("getResource");
            return getParent().getResource(s);
        }

        public InputStream getResourceAsStream(String s) {
            warn("getResourceAsStream");
            return getParent().getResourceAsStream(s);
        }

        public Enumeration getResources(String s) throws IOException {
            warn("getResources");
            return getParent().getResources(s);
        }

        public Class loadClass(String s) throws ClassNotFoundException {
            warn("loadClass");
            return getParent().loadClass(s);
        }

        public void setClassAssertionStatus(String s, boolean flag) {
            warn("setClassAssertionStatus");
            getParent().setClassAssertionStatus(s, flag);
        }

        public void setDefaultAssertionStatus(boolean flag) {
            warn("setDefaultAssertionStatus");
            getParent().setDefaultAssertionStatus(flag);
        }

        public void setPackageAssertionStatus(String s, boolean flag) {
            warn("setPackageAssertionStatus");
            getParent().setPackageAssertionStatus(s, flag);
        }

        private static boolean warned = false;


        private WarningContextClassLoader() {
        }

    }


    public LoadedApk(ActivityThread activitythread, ApplicationInfo applicationinfo, CompatibilityInfo compatibilityinfo, ActivityThread activitythread1, ClassLoader classloader, boolean flag, boolean flag1) {
        mCompatibilityInfo = new CompatibilityInfoHolder();
        mReceivers = new HashMap();
        mUnregisteredReceivers = new HashMap();
        mServices = new HashMap();
        mUnboundServices = new HashMap();
        mClientCount = 0;
        mActivityThread = activitythread;
        mApplicationInfo = applicationinfo;
        mPackageName = ((PackageItemInfo) (applicationinfo)).packageName;
        mAppDir = applicationinfo.sourceDir;
        int i = Process.myUid();
        String s;
        File file;
        if(applicationinfo.uid == i)
            s = applicationinfo.sourceDir;
        else
            s = applicationinfo.publicSourceDir;
        mResDir = s;
        if(!UserId.isSameUser(applicationinfo.uid, i) && !Process.isIsolated())
            applicationinfo.dataDir = PackageManager.getDataDirForUser(UserId.getUserId(i), mPackageName);
        mSharedLibraries = applicationinfo.sharedLibraryFiles;
        mDataDir = applicationinfo.dataDir;
        if(mDataDir != null)
            file = new File(mDataDir);
        else
            file = null;
        mDataDirFile = file;
        mLibDir = applicationinfo.nativeLibraryDir;
        mBaseClassLoader = classloader;
        mSecurityViolation = flag;
        mIncludeCode = flag1;
        mCompatibilityInfo.set(compatibilityinfo);
        if(mAppDir == null) {
            if(ActivityThread.mSystemContext == null) {
                ActivityThread.mSystemContext = ContextImpl.createSystemContext(activitythread1);
                ActivityThread.mSystemContext.getResources().updateConfiguration(activitythread1.getConfiguration(), activitythread1.getDisplayMetricsLocked(compatibilityinfo, false), compatibilityinfo);
            }
            mClassLoader = ActivityThread.mSystemContext.getClassLoader();
            mResources = ActivityThread.mSystemContext.getResources();
        }
    }

    public LoadedApk(ActivityThread activitythread, String s, Context context, ApplicationInfo applicationinfo, CompatibilityInfo compatibilityinfo) {
        mCompatibilityInfo = new CompatibilityInfoHolder();
        mReceivers = new HashMap();
        mUnregisteredReceivers = new HashMap();
        mServices = new HashMap();
        mUnboundServices = new HashMap();
        mClientCount = 0;
        mActivityThread = activitythread;
        if(applicationinfo == null)
            applicationinfo = new ApplicationInfo();
        mApplicationInfo = applicationinfo;
        mApplicationInfo.packageName = s;
        mPackageName = s;
        mAppDir = null;
        mResDir = null;
        mSharedLibraries = null;
        mDataDir = null;
        mDataDirFile = null;
        mLibDir = null;
        mBaseClassLoader = null;
        mSecurityViolation = false;
        mIncludeCode = true;
        mClassLoader = context.getClassLoader();
        mResources = context.getResources();
        mCompatibilityInfo.set(compatibilityinfo);
    }

    private static String combineLibs(String as[], String as1[]) {
        StringBuilder stringbuilder = new StringBuilder(300);
        boolean flag = true;
        if(as != null) {
            int k = as.length;
            int l = 0;
            while(l < k)  {
                String s1 = as[l];
                if(flag)
                    flag = false;
                else
                    stringbuilder.append(':');
                stringbuilder.append(s1);
                l++;
            }
        }
        boolean flag1;
        if(!flag)
            flag1 = true;
        else
            flag1 = false;
        if(as1 != null) {
            int i = as1.length;
            int j = 0;
            while(j < i)  {
                String s = as1[j];
                if(!flag1 || !ArrayUtils.contains(as, s)) {
                    if(flag)
                        flag = false;
                    else
                        stringbuilder.append(':');
                    stringbuilder.append(s);
                }
                j++;
            }
        }
        return stringbuilder.toString();
    }

    private static String[] getLibrariesFor(String s) {
        ApplicationInfo applicationinfo;
        String as[];
        try {
            applicationinfo = ActivityThread.getPackageManager().getApplicationInfo(s, 1024, UserId.myUserId());
        }
        catch(RemoteException remoteexception) {
            throw new AssertionError(remoteexception);
        }
        if(applicationinfo == null)
            as = null;
        else
            as = applicationinfo.sharedLibraryFiles;
        return as;
    }

    private void initializeJavaContextClassLoader() {
        IPackageManager ipackagemanager = ActivityThread.getPackageManager();
        PackageInfo packageinfo;
        boolean flag;
        boolean flag1;
        boolean flag2;
        Object obj;
        try {
            packageinfo = ipackagemanager.getPackageInfo(mPackageName, 0, UserId.myUserId());
        }
        catch(RemoteException remoteexception) {
            throw new AssertionError(remoteexception);
        }
        if(packageinfo.sharedUserId != null)
            flag = true;
        else
            flag = false;
        if(packageinfo.applicationInfo != null && !mPackageName.equals(packageinfo.applicationInfo.processName))
            flag1 = true;
        else
            flag1 = false;
        if(flag || flag1)
            flag2 = true;
        else
            flag2 = false;
        if(flag2)
            obj = new WarningContextClassLoader();
        else
            obj = mClassLoader;
        Thread.currentThread().setContextClassLoader(((ClassLoader) (obj)));
    }

    public IIntentReceiver forgetReceiverDispatcher(Context context, BroadcastReceiver broadcastreceiver) {
        HashMap hashmap = mReceivers;
        hashmap;
        JVM INSTR monitorenter ;
        HashMap hashmap1 = (HashMap)mReceivers.get(context);
        if(hashmap1 != null) {
            ReceiverDispatcher receiverdispatcher1 = (ReceiverDispatcher)hashmap1.get(broadcastreceiver);
            if(receiverdispatcher1 != null) {
                hashmap1.remove(broadcastreceiver);
                if(hashmap1.size() == 0)
                    mReceivers.remove(context);
                if(broadcastreceiver.getDebugUnregister()) {
                    HashMap hashmap3 = (HashMap)mUnregisteredReceivers.get(context);
                    if(hashmap3 == null) {
                        hashmap3 = new HashMap();
                        mUnregisteredReceivers.put(context, hashmap3);
                    }
                    IllegalArgumentException illegalargumentexception = new IllegalArgumentException("Originally unregistered here:");
                    illegalargumentexception.fillInStackTrace();
                    receiverdispatcher1.setUnregisterLocation(illegalargumentexception);
                    hashmap3.put(broadcastreceiver, receiverdispatcher1);
                }
                receiverdispatcher1.mForgotten = true;
                IIntentReceiver iintentreceiver = receiverdispatcher1.getIIntentReceiver();
                return iintentreceiver;
            }
        }
        HashMap hashmap2 = (HashMap)mUnregisteredReceivers.get(context);
        if(hashmap2 != null) {
            ReceiverDispatcher receiverdispatcher = (ReceiverDispatcher)hashmap2.get(broadcastreceiver);
            if(receiverdispatcher != null) {
                RuntimeException runtimeexception = receiverdispatcher.getUnregisterLocation();
                throw new IllegalArgumentException((new StringBuilder()).append("Unregistering Receiver ").append(broadcastreceiver).append(" that was already unregistered").toString(), runtimeexception);
            }
        }
        break MISSING_BLOCK_LABEL_246;
        Exception exception;
        exception;
        throw exception;
        if(context != null)
            break MISSING_BLOCK_LABEL_288;
        throw new IllegalStateException((new StringBuilder()).append("Unbinding Receiver ").append(broadcastreceiver).append(" from Context that is no longer in use: ").append(context).toString());
        throw new IllegalArgumentException((new StringBuilder()).append("Receiver not registered: ").append(broadcastreceiver).toString());
    }

    public final IServiceConnection forgetServiceDispatcher(Context context, ServiceConnection serviceconnection) {
        HashMap hashmap = mServices;
        hashmap;
        JVM INSTR monitorenter ;
        HashMap hashmap1 = (HashMap)mServices.get(context);
        if(hashmap1 != null) {
            ServiceDispatcher servicedispatcher1 = (ServiceDispatcher)hashmap1.get(serviceconnection);
            if(servicedispatcher1 != null) {
                hashmap1.remove(serviceconnection);
                servicedispatcher1.doForget();
                if(hashmap1.size() == 0)
                    mServices.remove(context);
                if((2 & servicedispatcher1.getFlags()) != 0) {
                    HashMap hashmap3 = (HashMap)mUnboundServices.get(context);
                    if(hashmap3 == null) {
                        hashmap3 = new HashMap();
                        mUnboundServices.put(context, hashmap3);
                    }
                    IllegalArgumentException illegalargumentexception = new IllegalArgumentException("Originally unbound here:");
                    illegalargumentexception.fillInStackTrace();
                    servicedispatcher1.setUnbindLocation(illegalargumentexception);
                    hashmap3.put(serviceconnection, servicedispatcher1);
                }
                IServiceConnection iserviceconnection = servicedispatcher1.getIServiceConnection();
                return iserviceconnection;
            }
        }
        HashMap hashmap2 = (HashMap)mUnboundServices.get(context);
        if(hashmap2 != null) {
            ServiceDispatcher servicedispatcher = (ServiceDispatcher)hashmap2.get(serviceconnection);
            if(servicedispatcher != null) {
                RuntimeException runtimeexception = servicedispatcher.getUnbindLocation();
                throw new IllegalArgumentException((new StringBuilder()).append("Unbinding Service ").append(serviceconnection).append(" that was already unbound").toString(), runtimeexception);
            }
        }
        break MISSING_BLOCK_LABEL_248;
        Exception exception;
        exception;
        throw exception;
        if(context != null)
            break MISSING_BLOCK_LABEL_290;
        throw new IllegalStateException((new StringBuilder()).append("Unbinding Service ").append(serviceconnection).append(" from Context that is no longer in use: ").append(context).toString());
        throw new IllegalArgumentException((new StringBuilder()).append("Service not registered: ").append(serviceconnection).toString());
    }

    public String getAppDir() {
        return mAppDir;
    }

    Application getApplication() {
        return mApplication;
    }

    public ApplicationInfo getApplicationInfo() {
        return mApplicationInfo;
    }

    public AssetManager getAssets(ActivityThread activitythread) {
        return getResources(activitythread).getAssets();
    }

    public ClassLoader getClassLoader() {
        this;
        JVM INSTR monitorenter ;
        if(mClassLoader == null) goto _L2; else goto _L1
_L1:
        ClassLoader classloader = mClassLoader;
          goto _L3
_L2:
        if(!mIncludeCode || mPackageName.equals("android")) goto _L5; else goto _L4
_L4:
        String s = mAppDir;
        String s1 = mLibDir;
        String s2 = mActivityThread.mInstrumentationAppDir;
        String s3 = mActivityThread.mInstrumentationAppLibraryDir;
        String s4 = mActivityThread.mInstrumentationAppPackage;
        String s5 = mActivityThread.mInstrumentedAppDir;
        String s6 = mActivityThread.mInstrumentedAppLibraryDir;
        String as[] = null;
        if(mAppDir.equals(s2) || mAppDir.equals(s5)) {
            s = (new StringBuilder()).append(s2).append(":").append(s5).toString();
            s1 = (new StringBuilder()).append(s3).append(":").append(s6).toString();
            if(!s5.equals(s2))
                as = getLibrariesFor(s4);
        }
        if(mSharedLibraries != null || as != null)
            s = (new StringBuilder()).append(combineLibs(mSharedLibraries, as)).append(':').append(s).toString();
        android.os.StrictMode.ThreadPolicy threadpolicy = StrictMode.allowThreadDiskReads();
        mClassLoader = ApplicationLoaders.getDefault().getClassLoader(s, s1, mBaseClassLoader);
        initializeJavaContextClassLoader();
        StrictMode.setThreadPolicy(threadpolicy);
_L6:
        classloader = mClassLoader;
        break; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        throw exception;
_L5:
        if(mBaseClassLoader == null)
            mClassLoader = ClassLoader.getSystemClassLoader();
        else
            mClassLoader = mBaseClassLoader;
        if(true) goto _L6; else goto _L3
_L3:
        return classloader;
    }

    public String getDataDir() {
        return mDataDir;
    }

    public File getDataDirFile() {
        return mDataDirFile;
    }

    public String getLibDir() {
        return mLibDir;
    }

    public String getPackageName() {
        return mPackageName;
    }

    public IIntentReceiver getReceiverDispatcher(BroadcastReceiver broadcastreceiver, Context context, Handler handler, Instrumentation instrumentation, boolean flag) {
        HashMap hashmap = mReceivers;
        hashmap;
        JVM INSTR monitorenter ;
        HashMap hashmap1 = null;
        if(!flag) goto _L2; else goto _L1
_L1:
        hashmap1 = (HashMap)mReceivers.get(context);
        if(hashmap1 == null) goto _L2; else goto _L3
_L3:
        ReceiverDispatcher receiverdispatcher2 = (ReceiverDispatcher)hashmap1.get(broadcastreceiver);
        HashMap hashmap2;
        ReceiverDispatcher receiverdispatcher;
        hashmap2 = hashmap1;
        receiverdispatcher = receiverdispatcher2;
_L12:
        if(receiverdispatcher != null) goto _L5; else goto _L4
_L4:
        ReceiverDispatcher receiverdispatcher1 = new ReceiverDispatcher(broadcastreceiver, context, handler, instrumentation, flag);
        if(!flag)
            break MISSING_BLOCK_LABEL_184;
        if(hashmap2 != null) goto _L7; else goto _L6
_L6:
        HashMap hashmap3 = new HashMap();
        mReceivers.put(context, hashmap3);
_L10:
        hashmap3.put(broadcastreceiver, receiverdispatcher1);
_L8:
        IIntentReceiver iintentreceiver;
        receiverdispatcher1.mForgotten = false;
        iintentreceiver = receiverdispatcher1.getIIntentReceiver();
        hashmap;
        JVM INSTR monitorexit ;
        return iintentreceiver;
_L5:
        receiverdispatcher.validate(context, handler);
        hashmap2;
        receiverdispatcher1 = receiverdispatcher;
          goto _L8
        Exception exception;
        exception;
_L9:
        hashmap;
        JVM INSTR monitorexit ;
        throw exception;
        exception;
        hashmap2;
        receiverdispatcher;
        continue; /* Loop/switch isn't completed */
        exception;
        hashmap2;
        if(true) goto _L9; else goto _L7
_L7:
        hashmap3 = hashmap2;
          goto _L10
        hashmap2;
          goto _L8
_L2:
        hashmap2 = hashmap1;
        receiverdispatcher = null;
        if(true) goto _L12; else goto _L11
_L11:
    }

    public String getResDir() {
        return mResDir;
    }

    public Resources getResources(ActivityThread activitythread) {
        if(mResources == null)
            mResources = activitythread.getTopLevelResources(mPackageName, mResDir, mCompatibilityInfo.get());
        return mResources;
    }

    public final IServiceConnection getServiceDispatcher(ServiceConnection serviceconnection, Context context, Handler handler, int i) {
        HashMap hashmap = mServices;
        hashmap;
        JVM INSTR monitorenter ;
        HashMap hashmap1 = (HashMap)mServices.get(context);
        if(hashmap1 == null) goto _L2; else goto _L1
_L1:
        ServiceDispatcher servicedispatcher2 = (ServiceDispatcher)hashmap1.get(serviceconnection);
        ServiceDispatcher servicedispatcher = servicedispatcher2;
_L8:
        if(servicedispatcher != null) goto _L4; else goto _L3
_L3:
        ServiceDispatcher servicedispatcher1 = new ServiceDispatcher(serviceconnection, context, handler, i);
        if(hashmap1 != null)
            break MISSING_BLOCK_LABEL_86;
        hashmap1 = new HashMap();
        mServices.put(context, hashmap1);
        hashmap1.put(serviceconnection, servicedispatcher1);
_L5:
        IServiceConnection iserviceconnection = servicedispatcher1.getIServiceConnection();
        hashmap;
        JVM INSTR monitorexit ;
        return iserviceconnection;
_L4:
        servicedispatcher.validate(context, handler);
        servicedispatcher1 = servicedispatcher;
          goto _L5
        Exception exception;
        exception;
_L6:
        hashmap;
        JVM INSTR monitorexit ;
        throw exception;
        exception;
        servicedispatcher;
        if(true) goto _L6; else goto _L2
_L2:
        servicedispatcher = null;
        if(true) goto _L8; else goto _L7
_L7:
    }

    public boolean isSecurityViolation() {
        return mSecurityViolation;
    }

    public Application makeApplication(boolean flag, Instrumentation instrumentation) {
        if(mApplication == null) goto _L2; else goto _L1
_L1:
        Application application = mApplication;
_L6:
        return application;
_L2:
        String s;
        application = null;
        s = mApplicationInfo.className;
        if(flag || s == null)
            s = "android.app.Application";
        ClassLoader classloader = getClassLoader();
        ContextImpl contextimpl = new ContextImpl();
        contextimpl.init(this, null, mActivityThread);
        application = mActivityThread.mInstrumentation.newApplication(classloader, s, contextimpl);
        contextimpl.setOuterContext(application);
_L4:
        mActivityThread.mAllApplications.add(application);
        mApplication = application;
        if(instrumentation != null)
            try {
                instrumentation.callApplicationOnCreate(application);
            }
            catch(Exception exception1) {
                if(!instrumentation.onException(application, exception1))
                    throw new RuntimeException((new StringBuilder()).append("Unable to create application ").append(application.getClass().getName()).append(": ").append(exception1.toString()).toString(), exception1);
            }
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        if(mActivityThread.mInstrumentation.onException(application, exception)) goto _L4; else goto _L3
_L3:
        throw new RuntimeException((new StringBuilder()).append("Unable to instantiate application ").append(s).append(": ").append(exception.toString()).toString(), exception);
        if(true) goto _L6; else goto _L5
_L5:
    }

    public void removeContextRegistrations(Context context, String s, String s1) {
        boolean flag = StrictMode.vmRegistrationLeaksEnabled();
        HashMap hashmap = (HashMap)mReceivers.remove(context);
        if(hashmap != null) {
            for(Iterator iterator1 = hashmap.values().iterator(); iterator1.hasNext();) {
                ReceiverDispatcher receiverdispatcher = (ReceiverDispatcher)iterator1.next();
                IntentReceiverLeaked intentreceiverleaked = new IntentReceiverLeaked((new StringBuilder()).append(s1).append(" ").append(s).append(" has leaked IntentReceiver ").append(receiverdispatcher.getIntentReceiver()).append(" that was ").append("originally registered here. Are you missing a ").append("call to unregisterReceiver()?").toString());
                intentreceiverleaked.setStackTrace(receiverdispatcher.getLocation().getStackTrace());
                Slog.e("ActivityThread", intentreceiverleaked.getMessage(), intentreceiverleaked);
                if(flag)
                    StrictMode.onIntentReceiverLeaked(intentreceiverleaked);
                try {
                    ActivityManagerNative.getDefault().unregisterReceiver(receiverdispatcher.getIIntentReceiver());
                }
                catch(RemoteException remoteexception1) { }
            }

        }
        mUnregisteredReceivers.remove(context);
        HashMap hashmap1 = (HashMap)mServices.remove(context);
        if(hashmap1 != null) {
            Iterator iterator = hashmap1.values().iterator();
            while(iterator.hasNext())  {
                ServiceDispatcher servicedispatcher = (ServiceDispatcher)iterator.next();
                ServiceConnectionLeaked serviceconnectionleaked = new ServiceConnectionLeaked((new StringBuilder()).append(s1).append(" ").append(s).append(" has leaked ServiceConnection ").append(servicedispatcher.getServiceConnection()).append(" that was originally bound here").toString());
                serviceconnectionleaked.setStackTrace(servicedispatcher.getLocation().getStackTrace());
                Slog.e("ActivityThread", serviceconnectionleaked.getMessage(), serviceconnectionleaked);
                if(flag)
                    StrictMode.onServiceConnectionLeaked(serviceconnectionleaked);
                try {
                    ActivityManagerNative.getDefault().unbindService(servicedispatcher.getIServiceConnection());
                }
                catch(RemoteException remoteexception) { }
                servicedispatcher.doForget();
            }
        }
        mUnboundServices.remove(context);
    }

    private static final String TAG = "LoadedApk";
    private final ActivityThread mActivityThread;
    private final String mAppDir;
    private Application mApplication;
    private final ApplicationInfo mApplicationInfo;
    private final ClassLoader mBaseClassLoader;
    private ClassLoader mClassLoader;
    int mClientCount;
    public final CompatibilityInfoHolder mCompatibilityInfo;
    private final String mDataDir;
    private final File mDataDirFile;
    private final boolean mIncludeCode;
    private final String mLibDir;
    final String mPackageName;
    private final HashMap mReceivers;
    private final String mResDir;
    Resources mResources;
    private final boolean mSecurityViolation;
    private final HashMap mServices;
    private final String mSharedLibraries[];
    private final HashMap mUnboundServices;
    private final HashMap mUnregisteredReceivers;
}

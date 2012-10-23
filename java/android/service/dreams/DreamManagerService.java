// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.service.dreams;

import android.content.*;
import android.content.res.Resources;
import android.os.*;
import android.util.Slog;
import android.view.IWindowManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;

// Referenced classes of package android.service.dreams:
//            IDreamService

public class DreamManagerService extends IDreamManager.Stub
    implements ServiceConnection {

    public DreamManagerService(Context context) {
        Slog.v("DreamManagerService", "DreamManagerService startup");
        mContext = context;
        mIWindowManager = android.view.IWindowManager.Stub.asInterface(ServiceManager.getService("window"));
    }

    private void checkPermission(String s) {
        if(mContext.checkCallingOrSelfPermission(s) != 0)
            throw new SecurityException((new StringBuilder()).append("Access denied to process: ").append(Binder.getCallingPid()).append(", must have permission ").append(s).toString());
        else
            return;
    }

    public void awaken() {
        Slog.v("DreamManagerService", "awaken()");
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        if(mCurrentDream != null)
            mContext.unbindService(this);
        return;
    }

    public void bindDreamComponentL(ComponentName componentname, boolean flag) {
        Slog.v("DreamManagerService", (new StringBuilder()).append("bindDreamComponent: componentName=").append(componentname).append(" pid=").append(Binder.getCallingPid()).append(", uid=").append(Binder.getCallingUid()).toString());
        Intent intent = (new Intent("android.intent.action.MAIN")).setComponent(componentname).addFlags(0x800000).putExtra("android.dreams.TEST", flag);
        if(!mContext.bindService(intent, this, 1)) {
            Slog.w("DreamManagerService", (new StringBuilder()).append("unable to bind service: ").append(componentname).toString());
        } else {
            mCurrentDreamComponent = componentname;
            mCurrentDreamToken = new Binder();
            try {
                Slog.v("DreamManagerService", (new StringBuilder()).append("Adding window token: ").append(mCurrentDreamToken).append(" for window type: ").append(2023).toString());
                mIWindowManager.addWindowToken(mCurrentDreamToken, 2023);
            }
            catch(RemoteException remoteexception) {
                Slog.w("DreamManagerService", "Unable to add window token. Proceed at your own risk.");
            }
        }
    }

    public void dream() {
        ComponentName componentname;
        componentname = getDreamComponent();
        if(componentname == null)
            break MISSING_BLOCK_LABEL_52;
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        long l = Binder.clearCallingIdentity();
        bindDreamComponentL(componentname, false);
        Binder.restoreCallingIdentity(l);
        obj;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_52;
        Exception exception1;
        exception1;
        Binder.restoreCallingIdentity(l);
        throw exception1;
        Exception exception;
        exception;
        throw exception;
    }

    protected void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        mContext.enforceCallingOrSelfPermission("android.permission.DUMP", "DreamManagerService");
        printwriter.println("Dreamland:");
        printwriter.print("  component=");
        printwriter.println(mCurrentDreamComponent);
        printwriter.print("  token=");
        printwriter.println(mCurrentDreamToken);
        printwriter.print("  dream=");
        printwriter.println(mCurrentDream);
    }

    public ComponentName getDreamComponent() {
        String s = android.provider.Settings.Secure.getString(mContext.getContentResolver(), "screensaver_component");
        if(s == null)
            s = mContext.getResources().getString(0x104002c);
        ComponentName componentname;
        if(s != null)
            componentname = ComponentName.unflattenFromString(s);
        else
            componentname = null;
        return componentname;
    }

    public void onServiceConnected(ComponentName componentname, IBinder ibinder) {
        Slog.v("DreamManagerService", (new StringBuilder()).append("connected to dream: ").append(componentname).append(" binder=").append(ibinder).append(" thread=").append(Thread.currentThread().getId()).toString());
        mCurrentDream = IDreamService.Stub.asInterface(ibinder);
        Slog.v("DreamManagerService", (new StringBuilder()).append("attaching with token:").append(mCurrentDreamToken).toString());
        mCurrentDream.attach(mCurrentDreamToken);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Slog.w("DreamManagerService", (new StringBuilder()).append("Unable to send window token to dream:").append(remoteexception).toString());
          goto _L1
    }

    public void onServiceDisconnected(ComponentName componentname) {
        Slog.v("DreamManagerService", (new StringBuilder()).append("disconnected: ").append(componentname).append(" service: ").append(mCurrentDream).toString());
        mCurrentDream = null;
        mCurrentDreamToken = null;
    }

    public void setDreamComponent(ComponentName componentname) {
        android.provider.Settings.Secure.putString(mContext.getContentResolver(), "screensaver_component", componentname.flattenToString());
    }

    public void systemReady() {
        Slog.v("DreamManagerService", "ready to dream!");
    }

    public void testDream(ComponentName componentname) {
        Slog.v("DreamManagerService", (new StringBuilder()).append("startDream name=").append(componentname).append(" pid=").append(Binder.getCallingPid()).append(", uid=").append(Binder.getCallingUid()).toString());
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        long l = Binder.clearCallingIdentity();
        bindDreamComponentL(componentname, true);
        Binder.restoreCallingIdentity(l);
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception1;
        exception1;
        Binder.restoreCallingIdentity(l);
        throw exception1;
        Exception exception;
        exception;
        throw exception;
    }

    private static final boolean DEBUG = true;
    private static final String TAG = "DreamManagerService";
    private Context mContext;
    private IDreamService mCurrentDream;
    private ComponentName mCurrentDreamComponent;
    private Binder mCurrentDreamToken;
    private IWindowManager mIWindowManager;
    final Object mLock = new Object[0];
}

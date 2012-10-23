// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.Context;
import android.os.*;
import android.util.Slog;
import com.android.internal.statusbar.IStatusBarService;

public class StatusBarManager {

    StatusBarManager(Context context) {
        mToken = new Binder();
        mContext = context;
    }

    /**
     * @deprecated Method getService is deprecated
     */

    private IStatusBarService getService() {
        this;
        JVM INSTR monitorenter ;
        IStatusBarService istatusbarservice;
        if(mService == null) {
            mService = com.android.internal.statusbar.IStatusBarService.Stub.asInterface(ServiceManager.getService("statusbar"));
            if(mService == null)
                Slog.w("StatusBarManager", "warning: no STATUS_BAR_SERVICE");
        }
        istatusbarservice = mService;
        this;
        JVM INSTR monitorexit ;
        return istatusbarservice;
        Exception exception;
        exception;
        throw exception;
    }

    public void collapse() {
        try {
            IStatusBarService istatusbarservice = getService();
            if(istatusbarservice != null)
                istatusbarservice.collapse();
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException(remoteexception);
        }
    }

    public void disable(int i) {
        try {
            IStatusBarService istatusbarservice = getService();
            if(istatusbarservice != null)
                istatusbarservice.disable(i, mToken, mContext.getPackageName());
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException(remoteexception);
        }
    }

    public void expand() {
        try {
            IStatusBarService istatusbarservice = getService();
            if(istatusbarservice != null)
                istatusbarservice.expand();
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException(remoteexception);
        }
    }

    public void removeIcon(String s) {
        try {
            IStatusBarService istatusbarservice = getService();
            if(istatusbarservice != null)
                istatusbarservice.removeIcon(s);
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException(remoteexception);
        }
    }

    public void setIcon(String s, int i, int j, String s1) {
        try {
            IStatusBarService istatusbarservice = getService();
            if(istatusbarservice != null)
                istatusbarservice.setIcon(s, mContext.getPackageName(), i, j, s1);
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException(remoteexception);
        }
    }

    public void setIconVisibility(String s, boolean flag) {
        try {
            IStatusBarService istatusbarservice = getService();
            if(istatusbarservice != null)
                istatusbarservice.setIconVisibility(s, flag);
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException(remoteexception);
        }
    }

    public static final int DISABLE_BACK = 0x400000;
    public static final int DISABLE_CLOCK = 0x800000;
    public static final int DISABLE_EXPAND = 0x10000;
    public static final int DISABLE_HOME = 0x200000;
    public static final int DISABLE_MASK = 0x1ff0000;
    public static final int DISABLE_NAVIGATION = 0x1200000;
    public static final int DISABLE_NONE = 0;
    public static final int DISABLE_NOTIFICATION_ALERTS = 0x40000;
    public static final int DISABLE_NOTIFICATION_ICONS = 0x20000;
    public static final int DISABLE_NOTIFICATION_TICKER = 0x80000;
    public static final int DISABLE_RECENT = 0x1000000;
    public static final int DISABLE_SYSTEM_INFO = 0x100000;
    public static final int NAVIGATION_HINT_BACK_ALT = 8;
    public static final int NAVIGATION_HINT_BACK_NOP = 1;
    public static final int NAVIGATION_HINT_HOME_NOP = 2;
    public static final int NAVIGATION_HINT_RECENT_NOP = 4;
    private Context mContext;
    private IStatusBarService mService;
    private IBinder mToken;
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.net;

import android.app.*;
import android.content.*;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.*;
import android.text.TextUtils;
import com.android.internal.telephony.ApnSetting;

// Referenced classes of package miui.net:
//            IFirewall

public class FirewallManager {

    private FirewallManager() {
        ensureService();
    }

    public static void checkAccessControl(Activity activity, ContentResolver contentresolver, String s, PackageManager packagemanager, IApplicationThread iapplicationthread, IBinder ibinder, String s1) {
_L2:
        return;
        if(activity != null || 1 != android.provider.Settings.Secure.getInt(contentresolver, "access_control_lock_enabled", 0)) goto _L2; else goto _L1
_L1:
        ApplicationInfo applicationinfo1 = packagemanager.getApplicationInfo(s, 0);
        ApplicationInfo applicationinfo = applicationinfo1;
_L4:
        if(applicationinfo != null && (0x80000000 & applicationinfo.flags) == 0x80000000 && !getInstance().checkAccessControlPass(s)) {
            Intent intent = new Intent("android.app.action.CONFIRM_ACCESS_CONTROL");
            intent.putExtra("android.intent.extra.shortcut.NAME", s);
            try {
                ActivityManagerNative.getDefault().startActivity(iapplicationthread, intent, intent.resolveTypeIfNeeded(contentresolver), ibinder, s1, -1, 0, null, null, null);
            }
            catch(RemoteException remoteexception) { }
        }
        if(true) goto _L2; else goto _L3
_L3:
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        applicationinfo = null;
          goto _L4
    }

    public static ApnSetting decodeApnSetting(String s) {
        ApnSetting apnsetting;
        if(TextUtils.isEmpty(s)) {
            apnsetting = null;
        } else {
            String as[] = s.split("\\s*,\\s*");
            if(as.length < 16)
                apnsetting = null;
            else
                apnsetting = new ApnSetting(Integer.parseInt(as[0]), as[1], as[2], as[3], as[4], as[5], as[6], as[7], as[8], as[9], as[10], Integer.parseInt(as[11]), as[12].split("\\s*\\|\\s*"), as[13], as[14], Boolean.parseBoolean(as[15]), Integer.parseInt(as[16]));
        }
        return apnsetting;
    }

    public static String encodeApnSetting(ApnSetting apnsetting) {
        String s;
        if(apnsetting == null)
            s = null;
        else
            s = (new StringBuilder()).append(apnsetting.id).append(',').append(apnsetting.numeric).append(',').append(apnsetting.carrier).append(',').append(apnsetting.apn).append(',').append(apnsetting.proxy).append(',').append(apnsetting.port).append(',').append(apnsetting.mmsc).append(',').append(apnsetting.mmsProxy).append(',').append(apnsetting.mmsPort).append(',').append(apnsetting.user).append(',').append(apnsetting.password).append(',').append(apnsetting.authType).append(',').append(TextUtils.join("|", apnsetting.types)).append(',').append(apnsetting.protocol).append(',').append(apnsetting.roamingProtocol).append(',').append(apnsetting.carrierEnabled).append(',').append(apnsetting.bearer).toString();
        return s;
    }

    private void ensureService() {
        if(mService != null)
            break MISSING_BLOCK_LABEL_34;
        miui/net/FirewallManager;
        JVM INSTR monitorenter ;
        mService = IFirewall.Stub.asInterface(ServiceManager.getService("miui.Firewall"));
    }

    public static FirewallManager getInstance() {
        return sInstance;
    }

    public static boolean isAccessControlProtected(Context context, String s) {
        boolean flag = false;
        ApplicationInfo applicationinfo = context.getPackageManager().getApplicationInfo(s, 0);
        if(applicationinfo != null && (0x80000000 & applicationinfo.flags) == 0x80000000)
            flag = true;
_L2:
        return flag;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void addAccessControlPass(String s) {
        ensureService();
        if(mService != null)
            mService.addAccessControlPass(s);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean checkAccessControlPass(String s) {
        boolean flag = false;
        boolean flag1;
        ensureService();
        if(mService == null)
            break MISSING_BLOCK_LABEL_28;
        flag1 = mService.checkAccessControlPass(s);
        flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean getAlarmBootCompleted() {
        ensureService();
        if(mService == null) goto _L2; else goto _L1
_L1:
        boolean flag1 = mService.getAlarmBootCompleted();
        boolean flag = flag1;
_L4:
        return flag;
        RemoteException remoteexception;
        remoteexception;
_L2:
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void onDataConnected(int i, String s, String s1) {
        if(!TextUtils.isEmpty(s)) {
            ensureService();
            if(mService != null)
                mService.onDataConnected(i, s, s1);
        }
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void onDataDisconnected(int i, String s) {
        if(!TextUtils.isEmpty(s)) {
            ensureService();
            if(mService != null)
                mService.onDataDisconnected(i, s);
        }
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void onStartUsingNetworkFeature(int i, int j, int k) {
        ensureService();
        if(mService != null)
            mService.onStartUsingNetworkFeature(i, j, k);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void onStopUsingNetworkFeature(int i, int j, int k) {
        ensureService();
        if(mService != null)
            mService.onStopUsingNetworkFeature(i, j, k);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void removeAccessControlPass(String s) {
        ensureService();
        if(mService != null)
            mService.removeAccessControlPass(s);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void setAlarmBootCompleted() {
        ensureService();
        mService.setAlarmBootCompleted();
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private static final boolean DEBUG = true;
    private static final String LOG_TAG = "FirewallService";
    public static final String SERVICE_NAME = "miui.Firewall";
    private static FirewallManager sInstance = new FirewallManager();
    private IFirewall mService;

}

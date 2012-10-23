// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app.admin;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Handler;
import android.os.RemoteCallback;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package android.app.admin:
//            IDevicePolicyManager, DeviceAdminInfo

public class DevicePolicyManager {

    private DevicePolicyManager(Context context, Handler handler) {
        mContext = context;
    }

    public static DevicePolicyManager create(Context context, Handler handler) {
        DevicePolicyManager devicepolicymanager = new DevicePolicyManager(context, handler);
        if(devicepolicymanager.mService == null)
            devicepolicymanager = null;
        return devicepolicymanager;
    }

    public List getActiveAdmins() {
        if(mService == null) goto _L2; else goto _L1
_L1:
        List list1 = mService.getActiveAdmins();
        List list = list1;
_L4:
        return list;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
_L2:
        list = null;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public DeviceAdminInfo getAdminInfo(ComponentName componentname) {
label0:
        {
            DeviceAdminInfo deviceadmininfo;
            android.content.pm.ActivityInfo activityinfo;
            ResolveInfo resolveinfo;
            try {
                activityinfo = mContext.getPackageManager().getReceiverInfo(componentname, 128);
            }
            catch(android.content.pm.PackageManager.NameNotFoundException namenotfoundexception) {
                Log.w(TAG, (new StringBuilder()).append("Unable to retrieve device policy ").append(componentname).toString(), namenotfoundexception);
                deviceadmininfo = null;
                if(false)
                    ;
                else
                    break label0;
            }
            resolveinfo = new ResolveInfo();
            resolveinfo.activityInfo = activityinfo;
            try {
                deviceadmininfo = new DeviceAdminInfo(mContext, resolveinfo);
            }
            catch(XmlPullParserException xmlpullparserexception) {
                Log.w(TAG, (new StringBuilder()).append("Unable to parse device policy ").append(componentname).toString(), xmlpullparserexception);
                deviceadmininfo = null;
            }
            catch(IOException ioexception) {
                Log.w(TAG, (new StringBuilder()).append("Unable to parse device policy ").append(componentname).toString(), ioexception);
                deviceadmininfo = null;
            }
        }
        return deviceadmininfo;
    }

    public boolean getCameraDisabled(ComponentName componentname) {
        if(mService == null) goto _L2; else goto _L1
_L1:
        boolean flag1 = mService.getCameraDisabled(componentname);
        boolean flag = flag1;
_L4:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
_L2:
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int getCurrentFailedPasswordAttempts() {
        if(mService == null) goto _L2; else goto _L1
_L1:
        int j = mService.getCurrentFailedPasswordAttempts();
        int i = j;
_L4:
        return i;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
_L2:
        i = -1;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public ComponentName getGlobalProxyAdmin() {
        if(mService == null) goto _L2; else goto _L1
_L1:
        ComponentName componentname1 = mService.getGlobalProxyAdmin();
        ComponentName componentname = componentname1;
_L4:
        return componentname;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
_L2:
        componentname = null;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int getMaximumFailedPasswordsForWipe(ComponentName componentname) {
        if(mService == null) goto _L2; else goto _L1
_L1:
        int j = mService.getMaximumFailedPasswordsForWipe(componentname);
        int i = j;
_L4:
        return i;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
_L2:
        i = 0;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public long getMaximumTimeToLock(ComponentName componentname) {
        if(mService == null) goto _L2; else goto _L1
_L1:
        long l1 = mService.getMaximumTimeToLock(componentname);
        long l = l1;
_L4:
        return l;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
_L2:
        l = 0L;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public long getPasswordExpiration(ComponentName componentname) {
        if(mService == null) goto _L2; else goto _L1
_L1:
        long l1 = mService.getPasswordExpiration(componentname);
        long l = l1;
_L4:
        return l;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
_L2:
        l = 0L;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public long getPasswordExpirationTimeout(ComponentName componentname) {
        if(mService == null) goto _L2; else goto _L1
_L1:
        long l1 = mService.getPasswordExpirationTimeout(componentname);
        long l = l1;
_L4:
        return l;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
_L2:
        l = 0L;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int getPasswordHistoryLength(ComponentName componentname) {
        if(mService == null) goto _L2; else goto _L1
_L1:
        int j = mService.getPasswordHistoryLength(componentname);
        int i = j;
_L4:
        return i;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
_L2:
        i = 0;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int getPasswordMaximumLength(int i) {
        return 16;
    }

    public int getPasswordMinimumLength(ComponentName componentname) {
        if(mService == null) goto _L2; else goto _L1
_L1:
        int j = mService.getPasswordMinimumLength(componentname);
        int i = j;
_L4:
        return i;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
_L2:
        i = 0;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int getPasswordMinimumLetters(ComponentName componentname) {
        if(mService == null) goto _L2; else goto _L1
_L1:
        int j = mService.getPasswordMinimumLetters(componentname);
        int i = j;
_L4:
        return i;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
_L2:
        i = 0;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int getPasswordMinimumLowerCase(ComponentName componentname) {
        if(mService == null) goto _L2; else goto _L1
_L1:
        int j = mService.getPasswordMinimumLowerCase(componentname);
        int i = j;
_L4:
        return i;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
_L2:
        i = 0;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int getPasswordMinimumNonLetter(ComponentName componentname) {
        if(mService == null) goto _L2; else goto _L1
_L1:
        int j = mService.getPasswordMinimumNonLetter(componentname);
        int i = j;
_L4:
        return i;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
_L2:
        i = 0;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int getPasswordMinimumNumeric(ComponentName componentname) {
        if(mService == null) goto _L2; else goto _L1
_L1:
        int j = mService.getPasswordMinimumNumeric(componentname);
        int i = j;
_L4:
        return i;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
_L2:
        i = 0;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int getPasswordMinimumSymbols(ComponentName componentname) {
        if(mService == null) goto _L2; else goto _L1
_L1:
        int j = mService.getPasswordMinimumSymbols(componentname);
        int i = j;
_L4:
        return i;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
_L2:
        i = 0;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int getPasswordMinimumUpperCase(ComponentName componentname) {
        if(mService == null) goto _L2; else goto _L1
_L1:
        int j = mService.getPasswordMinimumUpperCase(componentname);
        int i = j;
_L4:
        return i;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
_L2:
        i = 0;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int getPasswordQuality(ComponentName componentname) {
        if(mService == null) goto _L2; else goto _L1
_L1:
        int j = mService.getPasswordQuality(componentname);
        int i = j;
_L4:
        return i;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
_L2:
        i = 0;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void getRemoveWarning(ComponentName componentname, RemoteCallback remotecallback) {
        if(mService == null)
            break MISSING_BLOCK_LABEL_18;
        mService.getRemoveWarning(componentname, remotecallback);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
          goto _L1
    }

    public boolean getStorageEncryption(ComponentName componentname) {
        if(mService == null) goto _L2; else goto _L1
_L1:
        boolean flag1 = mService.getStorageEncryption(componentname);
        boolean flag = flag1;
_L4:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
_L2:
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int getStorageEncryptionStatus() {
        if(mService == null) goto _L2; else goto _L1
_L1:
        int j = mService.getStorageEncryptionStatus();
        int i = j;
_L4:
        return i;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
_L2:
        i = 0;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean hasGrantedPolicy(ComponentName componentname, int i) {
        if(mService == null) goto _L2; else goto _L1
_L1:
        boolean flag1 = mService.hasGrantedPolicy(componentname, i);
        boolean flag = flag1;
_L4:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
_L2:
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean isActivePasswordSufficient() {
        if(mService == null) goto _L2; else goto _L1
_L1:
        boolean flag1 = mService.isActivePasswordSufficient();
        boolean flag = flag1;
_L4:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
_L2:
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean isAdminActive(ComponentName componentname) {
        if(mService == null) goto _L2; else goto _L1
_L1:
        boolean flag1 = mService.isAdminActive(componentname);
        boolean flag = flag1;
_L4:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
_L2:
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void lockNow() {
        if(mService == null)
            break MISSING_BLOCK_LABEL_16;
        mService.lockNow();
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
          goto _L1
    }

    public boolean packageHasActiveAdmins(String s) {
        if(mService == null) goto _L2; else goto _L1
_L1:
        boolean flag1 = mService.packageHasActiveAdmins(s);
        boolean flag = flag1;
_L4:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
_L2:
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void removeActiveAdmin(ComponentName componentname) {
        if(mService == null)
            break MISSING_BLOCK_LABEL_17;
        mService.removeActiveAdmin(componentname);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
          goto _L1
    }

    public void reportFailedPasswordAttempt() {
        if(mService == null)
            break MISSING_BLOCK_LABEL_16;
        mService.reportFailedPasswordAttempt();
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
          goto _L1
    }

    public void reportSuccessfulPasswordAttempt() {
        if(mService == null)
            break MISSING_BLOCK_LABEL_16;
        mService.reportSuccessfulPasswordAttempt();
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
          goto _L1
    }

    public boolean resetPassword(String s, int i) {
        if(mService == null) goto _L2; else goto _L1
_L1:
        boolean flag1 = mService.resetPassword(s, i);
        boolean flag = flag1;
_L4:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
_L2:
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void setActiveAdmin(ComponentName componentname, boolean flag) {
        if(mService == null)
            break MISSING_BLOCK_LABEL_18;
        mService.setActiveAdmin(componentname, flag);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
          goto _L1
    }

    public void setActivePasswordState(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1) {
        if(mService == null)
            break MISSING_BLOCK_LABEL_29;
        mService.setActivePasswordState(i, j, k, l, i1, j1, k1, l1);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
          goto _L1
    }

    public void setCameraDisabled(ComponentName componentname, boolean flag) {
        if(mService == null)
            break MISSING_BLOCK_LABEL_18;
        mService.setCameraDisabled(componentname, flag);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
          goto _L1
    }

    public ComponentName setGlobalProxy(ComponentName componentname, Proxy proxy, List list) {
        if(proxy == null)
            throw new NullPointerException();
        if(mService == null) goto _L2; else goto _L1
_L1:
        if(!proxy.equals(Proxy.NO_PROXY)) goto _L4; else goto _L3
_L3:
        String s1;
        String s3;
        s1 = null;
        s3 = null;
_L9:
        ComponentName componentname1 = mService.setGlobalProxy(componentname, s1, s3);
          goto _L5
_L4:
        if(!proxy.type().equals(java.net.Proxy.Type.HTTP))
            throw new IllegalArgumentException();
          goto _L6
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
_L2:
        componentname1 = null;
          goto _L5
_L6:
        String s;
        int i;
        InetSocketAddress inetsocketaddress = (InetSocketAddress)proxy.address();
        s = inetsocketaddress.getHostName();
        i = inetsocketaddress.getPort();
        s1 = (new StringBuilder()).append(s).append(":").append(Integer.toString(i)).toString();
        if(list != null) goto _L8; else goto _L7
_L7:
        s3 = "";
_L12:
        android.net.Proxy.validate(s, Integer.toString(i), s3);
          goto _L9
_L8:
        StringBuilder stringbuilder;
        boolean flag;
        Iterator iterator;
        stringbuilder = new StringBuilder();
        flag = true;
        iterator = list.iterator();
_L11:
        String s4;
        if(!iterator.hasNext())
            break; /* Loop/switch isn't completed */
        s4 = (String)iterator.next();
        if(flag)
            break MISSING_BLOCK_LABEL_261;
        stringbuilder = stringbuilder.append(",");
_L13:
        stringbuilder = stringbuilder.append(s4.trim());
        if(true) goto _L11; else goto _L10
_L10:
        String s2 = stringbuilder.toString();
        s3 = s2;
          goto _L12
_L5:
        return componentname1;
        flag = false;
          goto _L13
    }

    public void setMaximumFailedPasswordsForWipe(ComponentName componentname, int i) {
        if(mService == null)
            break MISSING_BLOCK_LABEL_18;
        mService.setMaximumFailedPasswordsForWipe(componentname, i);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
          goto _L1
    }

    public void setMaximumTimeToLock(ComponentName componentname, long l) {
        if(mService == null)
            break MISSING_BLOCK_LABEL_18;
        mService.setMaximumTimeToLock(componentname, l);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
          goto _L1
    }

    public void setPasswordExpirationTimeout(ComponentName componentname, long l) {
        if(mService == null)
            break MISSING_BLOCK_LABEL_18;
        mService.setPasswordExpirationTimeout(componentname, l);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
          goto _L1
    }

    public void setPasswordHistoryLength(ComponentName componentname, int i) {
        if(mService == null)
            break MISSING_BLOCK_LABEL_18;
        mService.setPasswordHistoryLength(componentname, i);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
          goto _L1
    }

    public void setPasswordMinimumLength(ComponentName componentname, int i) {
        if(mService == null)
            break MISSING_BLOCK_LABEL_18;
        mService.setPasswordMinimumLength(componentname, i);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
          goto _L1
    }

    public void setPasswordMinimumLetters(ComponentName componentname, int i) {
        if(mService == null)
            break MISSING_BLOCK_LABEL_18;
        mService.setPasswordMinimumLetters(componentname, i);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
          goto _L1
    }

    public void setPasswordMinimumLowerCase(ComponentName componentname, int i) {
        if(mService == null)
            break MISSING_BLOCK_LABEL_18;
        mService.setPasswordMinimumLowerCase(componentname, i);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
          goto _L1
    }

    public void setPasswordMinimumNonLetter(ComponentName componentname, int i) {
        if(mService == null)
            break MISSING_BLOCK_LABEL_18;
        mService.setPasswordMinimumNonLetter(componentname, i);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
          goto _L1
    }

    public void setPasswordMinimumNumeric(ComponentName componentname, int i) {
        if(mService == null)
            break MISSING_BLOCK_LABEL_18;
        mService.setPasswordMinimumNumeric(componentname, i);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
          goto _L1
    }

    public void setPasswordMinimumSymbols(ComponentName componentname, int i) {
        if(mService == null)
            break MISSING_BLOCK_LABEL_18;
        mService.setPasswordMinimumSymbols(componentname, i);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
          goto _L1
    }

    public void setPasswordMinimumUpperCase(ComponentName componentname, int i) {
        if(mService == null)
            break MISSING_BLOCK_LABEL_18;
        mService.setPasswordMinimumUpperCase(componentname, i);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
          goto _L1
    }

    public void setPasswordQuality(ComponentName componentname, int i) {
        if(mService == null)
            break MISSING_BLOCK_LABEL_18;
        mService.setPasswordQuality(componentname, i);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
          goto _L1
    }

    public int setStorageEncryption(ComponentName componentname, boolean flag) {
        if(mService == null) goto _L2; else goto _L1
_L1:
        int j = mService.setStorageEncryption(componentname, flag);
        int i = j;
_L4:
        return i;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
_L2:
        i = 0;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void wipeData(int i) {
        if(mService == null)
            break MISSING_BLOCK_LABEL_17;
        mService.wipeData(i);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Failed talking with device policy service", remoteexception);
          goto _L1
    }

    public static final String ACTION_ADD_DEVICE_ADMIN = "android.app.action.ADD_DEVICE_ADMIN";
    public static final String ACTION_DEVICE_POLICY_MANAGER_STATE_CHANGED = "android.app.action.DEVICE_POLICY_MANAGER_STATE_CHANGED";
    public static final String ACTION_SET_NEW_PASSWORD = "android.app.action.SET_NEW_PASSWORD";
    public static final String ACTION_START_ENCRYPTION = "android.app.action.START_ENCRYPTION";
    public static final int ENCRYPTION_STATUS_ACTIVATING = 2;
    public static final int ENCRYPTION_STATUS_ACTIVE = 3;
    public static final int ENCRYPTION_STATUS_INACTIVE = 1;
    public static final int ENCRYPTION_STATUS_UNSUPPORTED = 0;
    public static final String EXTRA_ADD_EXPLANATION = "android.app.extra.ADD_EXPLANATION";
    public static final String EXTRA_DEVICE_ADMIN = "android.app.extra.DEVICE_ADMIN";
    public static final int PASSWORD_QUALITY_ALPHABETIC = 0x40000;
    public static final int PASSWORD_QUALITY_ALPHANUMERIC = 0x50000;
    public static final int PASSWORD_QUALITY_BIOMETRIC_WEAK = 32768;
    public static final int PASSWORD_QUALITY_COMPLEX = 0x60000;
    public static final int PASSWORD_QUALITY_NUMERIC = 0x20000;
    public static final int PASSWORD_QUALITY_SOMETHING = 0x10000;
    public static final int PASSWORD_QUALITY_UNSPECIFIED = 0;
    public static final int RESET_PASSWORD_REQUIRE_ENTRY = 1;
    private static String TAG = "DevicePolicyManager";
    public static final int WIPE_EXTERNAL_STORAGE = 1;
    private final Context mContext;
    private final IDevicePolicyManager mService = IDevicePolicyManager.Stub.asInterface(ServiceManager.getService("device_policy"));

}

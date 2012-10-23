// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.widget;

import android.app.admin.DevicePolicyManager;
import android.content.*;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.*;
import android.os.storage.IMountService;
import android.security.KeyStore;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import com.android.internal.telephony.ITelephony;
import com.google.android.collect.Lists;
import java.security.*;
import java.util.List;

// Referenced classes of package com.android.internal.widget:
//            ILockSettings

public class LockPatternUtils {

    public LockPatternUtils(Context context) {
        mCurrentUserId = 0;
        mContext = context;
        mContentResolver = context.getContentResolver();
    }

    public static int computePasswordQuality(String s) {
        boolean flag = false;
        boolean flag1 = false;
        int i = s.length();
        int j = 0;
        while(j < i)  {
            if(Character.isDigit(s.charAt(j)))
                flag = true;
            else
                flag1 = true;
            j++;
        }
        int k;
        if(flag1 && flag)
            k = 0x50000;
        else
        if(flag1)
            k = 0x40000;
        else
        if(flag)
            k = 0x20000;
        else
            k = 0;
        return k;
    }

    private void finishBiometricWeak() {
        setBoolean("lockscreen.biometricweakeverchosen", true);
        Intent intent = new Intent();
        intent.setClassName("com.android.facelock", "com.android.facelock.SetupEndScreen");
        mContext.startActivity(intent);
    }

    private boolean getBoolean(String s, boolean flag) {
        boolean flag1 = getLockSettings().getBoolean(s, flag, getCurrentOrCallingUserId());
        flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private int getCurrentOrCallingUserId() {
        int i = Binder.getCallingUid();
        int j;
        if(i == 1000)
            j = mCurrentUserId;
        else
            j = UserId.getUserId(i);
        return j;
    }

    private ILockSettings getLockSettings() {
        if(mLockSettingsService == null)
            mLockSettingsService = ILockSettings.Stub.asInterface(ServiceManager.getService("lock_settings"));
        return mLockSettingsService;
    }

    private long getLong(String s, long l) {
        long l1 = getLockSettings().getLong(s, l, getCurrentOrCallingUserId());
        l = l1;
_L2:
        return l;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private String getSalt() {
        long l = getLong("lockscreen.password_salt", 0L);
        if(l == 0L)
            try {
                l = SecureRandom.getInstance("SHA1PRNG").nextLong();
                setLong("lockscreen.password_salt", l);
                Log.v("LockPatternUtils", "Initialized lock password salt");
            }
            catch(NoSuchAlgorithmException nosuchalgorithmexception) {
                throw new IllegalStateException("Couldn't get SecureRandom number", nosuchalgorithmexception);
            }
        return Long.toHexString(l);
    }

    private String getString(String s) {
        String s1 = null;
        String s2 = getLockSettings().getString(s, null, getCurrentOrCallingUserId());
        s1 = s2;
_L2:
        return s1;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    protected static byte[] patternToHash(List list) {
        if(list != null) goto _L2; else goto _L1
_L1:
        byte abyte1[] = null;
_L4:
        return abyte1;
_L2:
        byte abyte0[];
        int i = list.size();
        abyte0 = new byte[i];
        for(int j = 0; j < i; j++) {
            LockPatternView.Cell cell = (LockPatternView.Cell)list.get(j);
            abyte0[j] = (byte)(3 * cell.getRow() + cell.getColumn());
        }

        byte abyte2[] = MessageDigest.getInstance("SHA-1").digest(abyte0);
        abyte1 = abyte2;
        continue; /* Loop/switch isn't completed */
        NoSuchAlgorithmException nosuchalgorithmexception;
        nosuchalgorithmexception;
        abyte1 = abyte0;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static String patternToString(List list) {
        String s;
        if(list == null) {
            s = "";
        } else {
            int i = list.size();
            byte abyte0[] = new byte[i];
            for(int j = 0; j < i; j++) {
                LockPatternView.Cell cell = (LockPatternView.Cell)list.get(j);
                abyte0[j] = (byte)(3 * cell.getRow() + cell.getColumn());
            }

            s = new String(abyte0);
        }
        return s;
    }

    private void setBoolean(String s, boolean flag) {
        getLockSettings().setBoolean(s, flag, getCurrentOrCallingUserId());
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("LockPatternUtils", (new StringBuilder()).append("Couldn't write boolean ").append(s).append(remoteexception).toString());
          goto _L1
    }

    private void setLong(String s, long l) {
        getLockSettings().setLong(s, l, getCurrentOrCallingUserId());
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("LockPatternUtils", (new StringBuilder()).append("Couldn't write long ").append(s).append(remoteexception).toString());
          goto _L1
    }

    private void setString(String s, String s1) {
        getLockSettings().setString(s, s1, getCurrentOrCallingUserId());
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("LockPatternUtils", (new StringBuilder()).append("Couldn't write string ").append(s).append(remoteexception).toString());
          goto _L1
    }

    public static List stringToPattern(String s) {
        java.util.ArrayList arraylist = Lists.newArrayList();
        byte abyte0[] = s.getBytes();
        for(int i = 0; i < abyte0.length; i++) {
            byte byte0 = abyte0[i];
            arraylist.add(LockPatternView.Cell.of(byte0 / 3, byte0 % 3));
        }

        return arraylist;
    }

    private static String toHex(byte abyte0[]) {
        String s = "";
        for(int i = 0; i < abyte0.length; i++) {
            String s1 = (new StringBuilder()).append(s).append("0123456789ABCDEF".charAt(0xf & abyte0[i] >> 4)).toString();
            s = (new StringBuilder()).append(s1).append("0123456789ABCDEF".charAt(0xf & abyte0[i])).toString();
        }

        return s;
    }

    private void updateEncryptionPassword(String s) {
        if(getDevicePolicyManager().getStorageEncryptionStatus() == 3) {
            android.os.IBinder ibinder = ServiceManager.getService("mount");
            if(ibinder == null) {
                Log.e("LockPatternUtils", "Could not find the mount service to update the encryption password");
            } else {
                IMountService imountservice = android.os.storage.IMountService.Stub.asInterface(ibinder);
                try {
                    imountservice.changeEncryptionPassword(s);
                }
                catch(RemoteException remoteexception) {
                    Log.e("LockPatternUtils", "Error changing encryption password", remoteexception);
                }
            }
        }
    }

    public boolean checkPassword(String s) {
        int i = getCurrentOrCallingUserId();
        boolean flag1 = getLockSettings().checkPassword(passwordToHash(s), i);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = true;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean checkPasswordHistory(String s) {
        boolean flag;
        String s1;
        String s2;
        flag = false;
        s1 = new String(passwordToHash(s));
        s2 = getString("lockscreen.passwordhistory");
        if(s2 != null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        int i = s1.length();
        int j = getRequestedPasswordHistoryLength();
        if(j != 0) {
            int k = -1 + (j + i * j);
            if(s2.length() > k)
                s2 = s2.substring(0, k);
            flag = s2.contains(s1);
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean checkPattern(List list) {
        int i = getCurrentOrCallingUserId();
        boolean flag1 = getLockSettings().checkPattern(patternToHash(list), i);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = true;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void clearLock(boolean flag) {
        if(!flag)
            deleteGallery();
        saveLockPassword(null, 0x10000);
        setLockPatternEnabled(false);
        saveLockPattern(null);
        setLong("lockscreen.password_type", 0L);
        setLong("lockscreen.password_type_alternate", 0L);
    }

    void deleteGallery() {
        if(usingBiometricWeak()) {
            Intent intent = (new Intent()).setAction("com.android.facelock.DELETE_GALLERY");
            intent.putExtra("deleteGallery", true);
            mContext.sendBroadcast(intent);
        }
    }

    public void deleteTempGallery() {
        Intent intent = (new Intent()).setAction("com.android.facelock.DELETE_GALLERY");
        intent.putExtra("deleteTempGallery", true);
        mContext.sendBroadcast(intent);
    }

    public int getActivePasswordQuality() {
        int i = 0;
        (int)getLong("lockscreen.password_type", 0x10000L);
        JVM INSTR lookupswitch 6: default 72
    //                   32768: 88
    //                   65536: 74
    //                   131072: 102
    //                   262144: 115
    //                   327680: 128
    //                   393216: 141;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        return i;
_L3:
        if(isLockPatternEnabled())
            i = 0x10000;
        continue; /* Loop/switch isn't completed */
_L2:
        if(isBiometricWeakInstalled())
            i = 32768;
        continue; /* Loop/switch isn't completed */
_L4:
        if(isLockPasswordEnabled())
            i = 0x20000;
        continue; /* Loop/switch isn't completed */
_L5:
        if(isLockPasswordEnabled())
            i = 0x40000;
        continue; /* Loop/switch isn't completed */
_L6:
        if(isLockPasswordEnabled())
            i = 0x50000;
        continue; /* Loop/switch isn't completed */
_L7:
        if(isLockPasswordEnabled())
            i = 0x60000;
        if(true) goto _L1; else goto _L8
_L8:
    }

    public int getCurrentUser() {
        if(Process.myUid() == 1000)
            return mCurrentUserId;
        else
            throw new SecurityException("Only the system process can get the current user");
    }

    public DevicePolicyManager getDevicePolicyManager() {
        if(mDevicePolicyManager == null) {
            mDevicePolicyManager = (DevicePolicyManager)mContext.getSystemService("device_policy");
            if(mDevicePolicyManager == null)
                Log.e("LockPatternUtils", "Can't get DevicePolicyManagerService: is it running?", new IllegalStateException("Stack trace:"));
        }
        return mDevicePolicyManager;
    }

    public int getKeyguardStoredPasswordQuality() {
        int i = (int)getLong("lockscreen.password_type", 0x10000L);
        if(i == 32768)
            i = (int)getLong("lockscreen.password_type_alternate", 0x10000L);
        return i;
    }

    public long getLockoutAttemptDeadline() {
        long l = getLong("lockscreen.lockoutattemptdeadline", 0L);
        long l1 = SystemClock.elapsedRealtime();
        if(l < l1 || l > 30000L + l1)
            l = 0L;
        return l;
    }

    public String getNextAlarm() {
        String s = android.provider.Settings.System.getString(mContentResolver, "next_alarm_formatted");
        if(s == null || TextUtils.isEmpty(s))
            s = null;
        return s;
    }

    public boolean getPowerButtonInstantlyLocks() {
        return getBoolean("lockscreen.power_button_instantly_locks", true);
    }

    public int getRequestedMinimumPasswordLength() {
        return getDevicePolicyManager().getPasswordMinimumLength(null);
    }

    public int getRequestedPasswordHistoryLength() {
        return getDevicePolicyManager().getPasswordHistoryLength(null);
    }

    public int getRequestedPasswordMinimumLetters() {
        return getDevicePolicyManager().getPasswordMinimumLetters(null);
    }

    public int getRequestedPasswordMinimumLowerCase() {
        return getDevicePolicyManager().getPasswordMinimumLowerCase(null);
    }

    public int getRequestedPasswordMinimumNonLetter() {
        return getDevicePolicyManager().getPasswordMinimumNonLetter(null);
    }

    public int getRequestedPasswordMinimumNumeric() {
        return getDevicePolicyManager().getPasswordMinimumNumeric(null);
    }

    public int getRequestedPasswordMinimumSymbols() {
        return getDevicePolicyManager().getPasswordMinimumSymbols(null);
    }

    public int getRequestedPasswordMinimumUpperCase() {
        return getDevicePolicyManager().getPasswordMinimumUpperCase(null);
    }

    public int getRequestedPasswordQuality() {
        return getDevicePolicyManager().getPasswordQuality(null);
    }

    public boolean isBiometricWeakEverChosen() {
        return getBoolean("lockscreen.biometricweakeverchosen", false);
    }

    public boolean isBiometricWeakInstalled() {
        boolean flag;
        PackageManager packagemanager;
        flag = false;
        packagemanager = mContext.getPackageManager();
        packagemanager.getPackageInfo("com.android.facelock", 1);
          goto _L1
_L2:
        return flag;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
          goto _L2
_L1:
        if(packagemanager.hasSystemFeature("android.hardware.camera.front") && !getDevicePolicyManager().getCameraDisabled(null))
            flag = true;
          goto _L2
    }

    public boolean isBiometricWeakLivelinessEnabled() {
        boolean flag;
        if((1L & getLong("lock_biometric_weak_flags", 0L)) != 0L)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isEmergencyCallCapable() {
        return mContext.getResources().getBoolean(0x1110028);
    }

    public boolean isEmergencyCallEnabledWhileSimLocked() {
        return mContext.getResources().getBoolean(0x1110022);
    }

    public boolean isLockPasswordEnabled() {
        boolean flag = true;
        long l = getLong("lockscreen.password_type", 0L);
        long l1 = getLong("lockscreen.password_type_alternate", 0L);
        boolean flag1;
        boolean flag2;
        if(l == 0x40000L || l == 0x20000L || l == 0x50000L || l == 0x60000L)
            flag1 = flag;
        else
            flag1 = false;
        if(l1 == 0x40000L || l1 == 0x20000L || l1 == 0x50000L || l1 == 0x60000L)
            flag2 = flag;
        else
            flag2 = false;
        if(!savedPasswordExists() || !flag1 && (!usingBiometricWeak() || !flag2))
            flag = false;
        return flag;
    }

    public boolean isLockPatternEnabled() {
        boolean flag = true;
        boolean flag1;
        if(getLong("lockscreen.password_type_alternate", 0x10000L) == 0x10000L)
            flag1 = flag;
        else
            flag1 = false;
        if(!getBoolean("lock_pattern_autolock", false) || getLong("lockscreen.password_type", 0x10000L) != 0x10000L && (!usingBiometricWeak() || !flag1))
            flag = false;
        return flag;
    }

    public boolean isLockScreenDisabled() {
        boolean flag;
        if(!isSecure() && getLong("lockscreen.disabled", 0L) != 0L)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isPatternEverChosen() {
        return getBoolean("lockscreen.patterneverchosen", false);
    }

    public boolean isPermanentlyLocked() {
        return getBoolean("lockscreen.lockedoutpermanently", false);
    }

    public boolean isPukUnlockScreenEnable() {
        return mContext.getResources().getBoolean(0x1110021);
    }

    public boolean isSecure() {
        boolean flag = true;
        long l = getKeyguardStoredPasswordQuality();
        boolean flag1;
        boolean flag2;
        if(l == 0x10000L)
            flag1 = flag;
        else
            flag1 = false;
        if(l == 0x20000L || l == 0x40000L || l == 0x50000L || l == 0x60000L)
            flag2 = flag;
        else
            flag2 = false;
        if((!flag1 || !isLockPatternEnabled() || !savedPatternExists()) && (!flag2 || !savedPasswordExists()))
            flag = false;
        return flag;
    }

    public boolean isTactileFeedbackEnabled() {
        return getBoolean("lock_pattern_tactile_feedback_enabled", false);
    }

    public boolean isVisiblePatternEnabled() {
        return getBoolean("lock_pattern_visible_pattern", false);
    }

    public byte[] passwordToHash(String s) {
        if(s != null) goto _L2; else goto _L1
_L1:
        byte abyte0[] = null;
_L4:
        return abyte0;
_L2:
        String s1;
        s1 = null;
        abyte0 = null;
        byte abyte4[];
        byte abyte1[] = (new StringBuilder()).append(s).append(getSalt()).toString().getBytes();
        s1 = "SHA-1";
        byte abyte2[] = MessageDigest.getInstance(s1).digest(abyte1);
        s1 = "MD5";
        byte abyte3[] = MessageDigest.getInstance(s1).digest(abyte1);
        abyte4 = (new StringBuilder()).append(toHex(abyte2)).append(toHex(abyte3)).toString().getBytes();
        abyte0 = abyte4;
        continue; /* Loop/switch isn't completed */
        NoSuchAlgorithmException nosuchalgorithmexception;
        nosuchalgorithmexception;
        Log.w("LockPatternUtils", (new StringBuilder()).append("Failed to encode string because of missing algorithm: ").append(s1).toString());
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void removeUser(int i) {
        if(Process.myUid() != 1000)
            break MISSING_BLOCK_LABEL_19;
        getLockSettings().removeUser(i);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("LockPatternUtils", (new StringBuilder()).append("Couldn't remove lock settings for user ").append(i).toString());
          goto _L1
    }

    public void reportFailedPasswordAttempt() {
        getDevicePolicyManager().reportFailedPasswordAttempt();
    }

    public void reportSuccessfulPasswordAttempt() {
        getDevicePolicyManager().reportSuccessfulPasswordAttempt();
    }

    public boolean resumeCall() {
        ITelephony itelephony = com.android.internal.telephony.ITelephony.Stub.asInterface(ServiceManager.checkService("phone"));
        if(itelephony == null) goto _L2; else goto _L1
_L1:
        boolean flag1 = itelephony.showCallScreen();
        if(!flag1) goto _L2; else goto _L3
_L3:
        boolean flag = true;
_L5:
        return flag;
        RemoteException remoteexception;
        remoteexception;
_L2:
        flag = false;
        if(true) goto _L5; else goto _L4
_L4:
    }

    public void saveLockPassword(String s, int i) {
        saveLockPassword(s, i, false);
    }

    public void saveLockPassword(String s, int i, boolean flag) {
        byte abyte0[] = passwordToHash(s);
        DevicePolicyManager devicepolicymanager;
        KeyStore keystore;
        getLockSettings().setLockPassword(abyte0, getCurrentOrCallingUserId());
        devicepolicymanager = getDevicePolicyManager();
        keystore = KeyStore.getInstance();
        if(s == null) goto _L2; else goto _L1
_L1:
        int j;
        updateEncryptionPassword(s);
        keystore.password(s);
        j = computePasswordQuality(s);
        if(flag) goto _L4; else goto _L3
_L3:
        deleteGallery();
        setLong("lockscreen.password_type", Math.max(i, j));
        if(j == 0) goto _L6; else goto _L5
_L5:
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        l = 0;
        i1 = 0;
        j1 = 0;
        k1 = 0;
        l1 = 0;
        i2 = 0;
        j2 = 0;
_L18:
        int k2 = s.length();
        if(j2 >= k2) goto _L8; else goto _L7
_L7:
        char c = s.charAt(j2);
        if(c < 'A' || c > 'Z') goto _L10; else goto _L9
_L9:
        l++;
        i1++;
          goto _L11
_L8:
        devicepolicymanager.setActivePasswordState(Math.max(i, j), s.length(), l, i1, j1, k1, l1, i2);
_L15:
        String s1;
        int k;
        s1 = getString("lockscreen.passwordhistory");
        if(s1 == null)
            s1 = new String();
        k = getRequestedPasswordHistoryLength();
        if(k != 0) goto _L13; else goto _L12
_L12:
        String s3 = "";
_L16:
        setString("lockscreen.passwordhistory", s3);
          goto _L14
_L6:
        devicepolicymanager.setActivePasswordState(0, 0, 0, 0, 0, 0, 0, 0);
          goto _L15
        RemoteException remoteexception;
        remoteexception;
        Log.e("LockPatternUtils", (new StringBuilder()).append("Unable to save lock password ").append(remoteexception).toString());
          goto _L14
_L4:
        setLong("lockscreen.password_type", 32768L);
        setLong("lockscreen.password_type_alternate", Math.max(i, j));
        finishBiometricWeak();
        devicepolicymanager.setActivePasswordState(32768, 0, 0, 0, 0, 0, 0, 0);
          goto _L15
_L13:
        String s2 = (new StringBuilder()).append(new String(abyte0)).append(",").append(s1).toString();
        s3 = s2.substring(0, Math.min(-1 + (k + k * abyte0.length), s2.length()));
          goto _L16
_L2:
        if(keystore.isEmpty())
            keystore.reset();
        devicepolicymanager.setActivePasswordState(0, 0, 0, 0, 0, 0, 0, 0);
          goto _L14
_L11:
        j2++;
        continue; /* Loop/switch isn't completed */
_L10:
        if(c >= 'a' && c <= 'z') {
            l++;
            j1++;
        } else
        if(c >= '0' && c <= '9') {
            k1++;
            i2++;
        } else {
            l1++;
            i2++;
        }
        if(true) goto _L11; else goto _L14
_L14:
        return;
        if(true) goto _L18; else goto _L17
_L17:
    }

    public void saveLockPattern(List list) {
        saveLockPattern(list, false);
    }

    public void saveLockPattern(List list, boolean flag) {
        DevicePolicyManager devicepolicymanager;
        KeyStore keystore;
        byte abyte0[] = patternToHash(list);
        try {
            getLockSettings().setLockPattern(abyte0, getCurrentOrCallingUserId());
            devicepolicymanager = getDevicePolicyManager();
            keystore = KeyStore.getInstance();
            if(list != null) {
                keystore.password(patternToString(list));
                setBoolean("lockscreen.patterneverchosen", true);
                if(!flag) {
                    deleteGallery();
                    setLong("lockscreen.password_type", 0x10000L);
                    devicepolicymanager.setActivePasswordState(0x10000, list.size(), 0, 0, 0, 0, 0, 0);
                } else {
                    setLong("lockscreen.password_type", 32768L);
                    setLong("lockscreen.password_type_alternate", 0x10000L);
                    finishBiometricWeak();
                    devicepolicymanager.setActivePasswordState(32768, 0, 0, 0, 0, 0, 0, 0);
                }
                break MISSING_BLOCK_LABEL_190;
            }
        }
        catch(RemoteException remoteexception) {
            Log.e("LockPatternUtils", (new StringBuilder()).append("Couldn't save lock pattern ").append(remoteexception).toString());
            break MISSING_BLOCK_LABEL_190;
        }
        if(keystore.isEmpty())
            keystore.reset();
        devicepolicymanager.setActivePasswordState(0, 0, 0, 0, 0, 0, 0, 0);
    }

    public boolean savedPasswordExists() {
        boolean flag1 = getLockSettings().havePassword(getCurrentOrCallingUserId());
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean savedPatternExists() {
        boolean flag1 = getLockSettings().havePattern(getCurrentOrCallingUserId());
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void setBiometricWeakLivelinessEnabled(boolean flag) {
        long l = getLong("lock_biometric_weak_flags", 0L);
        long l1;
        if(flag)
            l1 = l | 1L;
        else
            l1 = l & -2L;
        setLong("lock_biometric_weak_flags", l1);
    }

    public void setCurrentUser(int i) {
        if(Process.myUid() == 1000) {
            mCurrentUserId = i;
            return;
        } else {
            throw new SecurityException("Only the system process can set the current user");
        }
    }

    public void setLockPatternEnabled(boolean flag) {
        setBoolean("lock_pattern_autolock", flag);
    }

    public void setLockScreenDisabled(boolean flag) {
        long l;
        if(flag)
            l = 1L;
        else
            l = 0L;
        setLong("lockscreen.disabled", l);
    }

    public long setLockoutAttemptDeadline() {
        long l = 30000L + SystemClock.elapsedRealtime();
        setLong("lockscreen.lockoutattemptdeadline", l);
        return l;
    }

    public void setPermanentlyLocked(boolean flag) {
        setBoolean("lockscreen.lockedoutpermanently", flag);
    }

    public void setPowerButtonInstantlyLocks(boolean flag) {
        setBoolean("lockscreen.power_button_instantly_locks", flag);
    }

    public void setTactileFeedbackEnabled(boolean flag) {
        setBoolean("lock_pattern_tactile_feedback_enabled", flag);
    }

    public void setVisiblePatternEnabled(boolean flag) {
        setBoolean("lock_pattern_visible_pattern", flag);
    }

    public void updateEmergencyCallButtonState(Button button, int i, boolean flag) {
        if(isEmergencyCallCapable() && flag) {
            button.setVisibility(0);
            int j;
            if(i == 2) {
                j = 0x10402fc;
                button.setCompoundDrawablesWithIntrinsicBounds(0x1080084, 0, 0, 0);
            } else {
                j = 0x10402fb;
                button.setCompoundDrawablesWithIntrinsicBounds(0x10802cb, 0, 0, 0);
            }
            button.setText(j);
        } else {
            button.setVisibility(8);
        }
    }

    public boolean usingBiometricWeak() {
        boolean flag;
        if((int)getLong("lockscreen.password_type", 0x10000L) == 32768)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static final String BIOMETRIC_WEAK_EVER_CHOSEN_KEY = "lockscreen.biometricweakeverchosen";
    protected static final String DISABLE_LOCKSCREEN_KEY = "lockscreen.disabled";
    public static final int FAILED_ATTEMPTS_BEFORE_RESET = 20;
    public static final int FAILED_ATTEMPTS_BEFORE_TIMEOUT = 5;
    public static final int FAILED_ATTEMPTS_BEFORE_WIPE_GRACE = 5;
    public static final long FAILED_ATTEMPT_COUNTDOWN_INTERVAL_MS = 1000L;
    public static final long FAILED_ATTEMPT_TIMEOUT_MS = 30000L;
    public static final int FLAG_BIOMETRIC_WEAK_LIVELINESS = 1;
    protected static final String LOCKOUT_ATTEMPT_DEADLINE = "lockscreen.lockoutattemptdeadline";
    protected static final String LOCKOUT_PERMANENT_KEY = "lockscreen.lockedoutpermanently";
    public static final String LOCKSCREEN_BIOMETRIC_WEAK_FALLBACK = "lockscreen.biometric_weak_fallback";
    protected static final String LOCKSCREEN_OPTIONS = "lockscreen.options";
    public static final String LOCKSCREEN_POWER_BUTTON_INSTANTLY_LOCKS = "lockscreen.power_button_instantly_locks";
    protected static final String LOCK_PASSWORD_SALT_KEY = "lockscreen.password_salt";
    public static final int MIN_LOCK_PATTERN_SIZE = 4;
    public static final int MIN_PATTERN_REGISTER_FAIL = 4;
    private static final String OPTION_ENABLE_FACELOCK = "enable_facelock";
    protected static final String PASSWORD_HISTORY_KEY = "lockscreen.passwordhistory";
    public static final String PASSWORD_TYPE_ALTERNATE_KEY = "lockscreen.password_type_alternate";
    public static final String PASSWORD_TYPE_KEY = "lockscreen.password_type";
    protected static final String PATTERN_EVER_CHOSEN_KEY = "lockscreen.patterneverchosen";
    private static final String TAG = "LockPatternUtils";
    private final ContentResolver mContentResolver;
    private final Context mContext;
    private int mCurrentUserId;
    private DevicePolicyManager mDevicePolicyManager;
    private ILockSettings mLockSettingsService;
}

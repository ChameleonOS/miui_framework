// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.pm;

import android.content.*;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.util.AndroidException;
import android.util.DisplayMetrics;
import java.io.File;
import java.util.List;

// Referenced classes of package android.content.pm:
//            PackageParser, PermissionInfo, IPackageDataObserver, UserInfo, 
//            IPackageDeleteObserver, ActivityInfo, ApplicationInfo, InstrumentationInfo, 
//            PackageInfo, IPackageStatsObserver, PermissionGroupInfo, ProviderInfo, 
//            ServiceInfo, FeatureInfo, VerifierDeviceIdentity, IPackageInstallObserver, 
//            ManifestDigest, ContainerEncryptionParams, IPackageMoveObserver, ResolveInfo

public abstract class PackageManager {
    public static class NameNotFoundException extends AndroidException {

        public NameNotFoundException() {
        }

        public NameNotFoundException(String s) {
            super(s);
        }
    }


    public PackageManager() {
    }

    public static String getDataDirForUser(int i, String s) {
        return (new StringBuilder()).append(Environment.getDataDirectory().toString()).append("/user/").append(i).append("/").append(s).toString();
    }

    public abstract void addPackageToPreferred(String s);

    public abstract boolean addPermission(PermissionInfo permissioninfo);

    public abstract boolean addPermissionAsync(PermissionInfo permissioninfo);

    public abstract void addPreferredActivity(IntentFilter intentfilter, int i, ComponentName acomponentname[], ComponentName componentname);

    public abstract String[] canonicalToCurrentPackageNames(String as[]);

    public abstract int checkPermission(String s, String s1);

    public abstract int checkSignatures(int i, int j);

    public abstract int checkSignatures(String s, String s1);

    public abstract void clearApplicationUserData(String s, IPackageDataObserver ipackagedataobserver);

    public abstract void clearPackagePreferredActivities(String s);

    public abstract UserInfo createUser(String s, int i);

    public abstract String[] currentToCanonicalPackageNames(String as[]);

    public abstract void deleteApplicationCacheFiles(String s, IPackageDataObserver ipackagedataobserver);

    public abstract void deletePackage(String s, IPackageDeleteObserver ipackagedeleteobserver, int i);

    public abstract void freeStorage(long l, IntentSender intentsender);

    public abstract void freeStorageAndNotify(long l, IPackageDataObserver ipackagedataobserver);

    public abstract Drawable getActivityIcon(ComponentName componentname) throws NameNotFoundException;

    public abstract Drawable getActivityIcon(Intent intent) throws NameNotFoundException;

    public abstract ActivityInfo getActivityInfo(ComponentName componentname, int i) throws NameNotFoundException;

    public abstract Drawable getActivityLogo(ComponentName componentname) throws NameNotFoundException;

    public abstract Drawable getActivityLogo(Intent intent) throws NameNotFoundException;

    public abstract List getAllPermissionGroups(int i);

    public abstract int getApplicationEnabledSetting(String s);

    public abstract Drawable getApplicationIcon(ApplicationInfo applicationinfo);

    public abstract Drawable getApplicationIcon(String s) throws NameNotFoundException;

    public abstract ApplicationInfo getApplicationInfo(String s, int i) throws NameNotFoundException;

    public abstract CharSequence getApplicationLabel(ApplicationInfo applicationinfo);

    public abstract Drawable getApplicationLogo(ApplicationInfo applicationinfo);

    public abstract Drawable getApplicationLogo(String s) throws NameNotFoundException;

    public abstract int getComponentEnabledSetting(ComponentName componentname);

    public abstract Drawable getDefaultActivityIcon();

    public abstract Drawable getDrawable(String s, int i, ApplicationInfo applicationinfo);

    public abstract List getInstalledApplications(int i);

    public abstract List getInstalledPackages(int i);

    public abstract String getInstallerPackageName(String s);

    public abstract InstrumentationInfo getInstrumentationInfo(ComponentName componentname, int i) throws NameNotFoundException;

    public abstract Intent getLaunchIntentForPackage(String s);

    public abstract String getNameForUid(int i);

    public PackageInfo getPackageArchiveInfo(String s, int i) {
        PackageInfo packageinfo = null;
        PackageParser packageparser = new PackageParser(s);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        displaymetrics.setToDefaults();
        PackageParser.Package package1 = packageparser.parsePackage(new File(s), s, displaymetrics, 0);
        if(package1 != null) {
            if((i & 0x40) != 0)
                packageparser.collectCertificates(package1, 0);
            packageinfo = PackageParser.generatePackageInfo(package1, null, i, 0L, 0L, null, false, 0);
        }
        return packageinfo;
    }

    public abstract int[] getPackageGids(String s) throws NameNotFoundException;

    public abstract PackageInfo getPackageInfo(String s, int i) throws NameNotFoundException;

    public abstract void getPackageSizeInfo(String s, IPackageStatsObserver ipackagestatsobserver);

    public abstract String[] getPackagesForUid(int i);

    public abstract PermissionGroupInfo getPermissionGroupInfo(String s, int i) throws NameNotFoundException;

    public abstract PermissionInfo getPermissionInfo(String s, int i) throws NameNotFoundException;

    public abstract int getPreferredActivities(List list, List list1, String s);

    public abstract List getPreferredPackages(int i);

    public abstract ProviderInfo getProviderInfo(ComponentName componentname, int i) throws NameNotFoundException;

    public abstract ActivityInfo getReceiverInfo(ComponentName componentname, int i) throws NameNotFoundException;

    public abstract Resources getResourcesForActivity(ComponentName componentname) throws NameNotFoundException;

    public abstract Resources getResourcesForApplication(ApplicationInfo applicationinfo) throws NameNotFoundException;

    public abstract Resources getResourcesForApplication(String s) throws NameNotFoundException;

    public abstract ServiceInfo getServiceInfo(ComponentName componentname, int i) throws NameNotFoundException;

    public abstract FeatureInfo[] getSystemAvailableFeatures();

    public abstract String[] getSystemSharedLibraryNames();

    public abstract CharSequence getText(String s, int i, ApplicationInfo applicationinfo);

    public abstract int getUidForSharedUser(String s) throws NameNotFoundException;

    public abstract UserInfo getUser(int i);

    public abstract List getUsers();

    public abstract VerifierDeviceIdentity getVerifierDeviceIdentity();

    public abstract XmlResourceParser getXml(String s, int i, ApplicationInfo applicationinfo);

    public abstract void grantPermission(String s, String s1);

    public abstract boolean hasSystemFeature(String s);

    public abstract void installPackage(Uri uri, IPackageInstallObserver ipackageinstallobserver, int i, String s);

    public abstract void installPackageWithVerification(Uri uri, IPackageInstallObserver ipackageinstallobserver, int i, String s, Uri uri1, ManifestDigest manifestdigest, ContainerEncryptionParams containerencryptionparams);

    public abstract boolean isSafeMode();

    public abstract void movePackage(String s, IPackageMoveObserver ipackagemoveobserver, int i);

    public abstract List queryBroadcastReceivers(Intent intent, int i);

    public abstract List queryContentProviders(String s, int i, int j);

    public abstract List queryInstrumentation(String s, int i);

    public abstract List queryIntentActivities(Intent intent, int i);

    public abstract List queryIntentActivityOptions(ComponentName componentname, Intent aintent[], Intent intent, int i);

    public abstract List queryIntentServices(Intent intent, int i);

    public abstract List queryPermissionsByGroup(String s, int i) throws NameNotFoundException;

    public abstract void removePackageFromPreferred(String s);

    public abstract void removePermission(String s);

    public abstract boolean removeUser(int i);

    public abstract void replacePreferredActivity(IntentFilter intentfilter, int i, ComponentName acomponentname[], ComponentName componentname);

    public abstract ResolveInfo resolveActivity(Intent intent, int i);

    public abstract ProviderInfo resolveContentProvider(String s, int i);

    public abstract ResolveInfo resolveService(Intent intent, int i);

    public abstract void revokePermission(String s, String s1);

    public abstract void setApplicationEnabledSetting(String s, int i, int j);

    public abstract void setComponentEnabledSetting(ComponentName componentname, int i, int j);

    public abstract void setInstallerPackageName(String s, String s1);

    public abstract void updateUserFlags(int i, int j);

    public abstract void updateUserName(int i, String s);

    public abstract void verifyPendingInstall(int i, int j);

    public static final String ACTION_CLEAN_EXTERNAL_STORAGE = "android.content.pm.CLEAN_EXTERNAL_STORAGE";
    public static final int COMPONENT_ENABLED_STATE_ACCESS_CONTROL = 0x80000000;
    public static final int COMPONENT_ENABLED_STATE_DEFAULT = 0;
    public static final int COMPONENT_ENABLED_STATE_DISABLED = 2;
    public static final int COMPONENT_ENABLED_STATE_DISABLED_USER = 3;
    public static final int COMPONENT_ENABLED_STATE_ENABLED = 1;
    public static final int DELETE_FAILED_DEVICE_POLICY_MANAGER = -2;
    public static final int DELETE_FAILED_INTERNAL_ERROR = -1;
    public static final int DELETE_SUCCEEDED = 1;
    public static final int DONT_DELETE_DATA = 1;
    public static final int DONT_KILL_APP = 1;
    public static final String EXTRA_VERIFICATION_ID = "android.content.pm.extra.VERIFICATION_ID";
    public static final String EXTRA_VERIFICATION_INSTALLER_PACKAGE = "android.content.pm.extra.VERIFICATION_INSTALLER_PACKAGE";
    public static final String EXTRA_VERIFICATION_INSTALL_FLAGS = "android.content.pm.extra.VERIFICATION_INSTALL_FLAGS";
    public static final String EXTRA_VERIFICATION_URI = "android.content.pm.extra.VERIFICATION_URI";
    public static final String FEATURE_AUDIO_LOW_LATENCY = "android.hardware.audio.low_latency";
    public static final String FEATURE_BLUETOOTH = "android.hardware.bluetooth";
    public static final String FEATURE_CAMERA = "android.hardware.camera";
    public static final String FEATURE_CAMERA_AUTOFOCUS = "android.hardware.camera.autofocus";
    public static final String FEATURE_CAMERA_FLASH = "android.hardware.camera.flash";
    public static final String FEATURE_CAMERA_FRONT = "android.hardware.camera.front";
    public static final String FEATURE_FAKETOUCH = "android.hardware.faketouch";
    public static final String FEATURE_FAKETOUCH_MULTITOUCH_DISTINCT = "android.hardware.faketouch.multitouch.distinct";
    public static final String FEATURE_FAKETOUCH_MULTITOUCH_JAZZHAND = "android.hardware.faketouch.multitouch.jazzhand";
    public static final String FEATURE_LIVE_WALLPAPER = "android.software.live_wallpaper";
    public static final String FEATURE_LOCATION = "android.hardware.location";
    public static final String FEATURE_LOCATION_GPS = "android.hardware.location.gps";
    public static final String FEATURE_LOCATION_NETWORK = "android.hardware.location.network";
    public static final String FEATURE_MICROPHONE = "android.hardware.microphone";
    public static final String FEATURE_NFC = "android.hardware.nfc";
    public static final String FEATURE_SCREEN_LANDSCAPE = "android.hardware.screen.landscape";
    public static final String FEATURE_SCREEN_PORTRAIT = "android.hardware.screen.portrait";
    public static final String FEATURE_SENSOR_ACCELEROMETER = "android.hardware.sensor.accelerometer";
    public static final String FEATURE_SENSOR_BAROMETER = "android.hardware.sensor.barometer";
    public static final String FEATURE_SENSOR_COMPASS = "android.hardware.sensor.compass";
    public static final String FEATURE_SENSOR_GYROSCOPE = "android.hardware.sensor.gyroscope";
    public static final String FEATURE_SENSOR_LIGHT = "android.hardware.sensor.light";
    public static final String FEATURE_SENSOR_PROXIMITY = "android.hardware.sensor.proximity";
    public static final String FEATURE_SIP = "android.software.sip";
    public static final String FEATURE_SIP_VOIP = "android.software.sip.voip";
    public static final String FEATURE_TELEPHONY = "android.hardware.telephony";
    public static final String FEATURE_TELEPHONY_CDMA = "android.hardware.telephony.cdma";
    public static final String FEATURE_TELEPHONY_GSM = "android.hardware.telephony.gsm";
    public static final String FEATURE_TELEVISION = "android.hardware.type.television";
    public static final String FEATURE_TOUCHSCREEN = "android.hardware.touchscreen";
    public static final String FEATURE_TOUCHSCREEN_MULTITOUCH = "android.hardware.touchscreen.multitouch";
    public static final String FEATURE_TOUCHSCREEN_MULTITOUCH_DISTINCT = "android.hardware.touchscreen.multitouch.distinct";
    public static final String FEATURE_TOUCHSCREEN_MULTITOUCH_JAZZHAND = "android.hardware.touchscreen.multitouch.jazzhand";
    public static final String FEATURE_USB_ACCESSORY = "android.hardware.usb.accessory";
    public static final String FEATURE_USB_HOST = "android.hardware.usb.host";
    public static final String FEATURE_WIFI = "android.hardware.wifi";
    public static final String FEATURE_WIFI_DIRECT = "android.hardware.wifi.direct";
    public static final int GET_ACTIVITIES = 1;
    public static final int GET_CONFIGURATIONS = 16384;
    public static final int GET_DISABLED_COMPONENTS = 512;
    public static final int GET_GIDS = 256;
    public static final int GET_INSTRUMENTATION = 16;
    public static final int GET_INTENT_FILTERS = 32;
    public static final int GET_META_DATA = 128;
    public static final int GET_PERMISSIONS = 4096;
    public static final int GET_PROVIDERS = 8;
    public static final int GET_RECEIVERS = 2;
    public static final int GET_RESOLVED_FILTER = 64;
    public static final int GET_SERVICES = 4;
    public static final int GET_SHARED_LIBRARY_FILES = 1024;
    public static final int GET_SIGNATURES = 64;
    public static final int GET_UNINSTALLED_PACKAGES = 8192;
    public static final int GET_URI_PERMISSION_PATTERNS = 2048;
    public static final int HAS_ACTIVITY = 0x20000;
    public static final int HAS_ACTIVITY_OR_SERVICES = 0x40000;
    public static final int INSTALL_ALLOW_TEST = 4;
    public static final int INSTALL_EXTERNAL = 8;
    public static final int INSTALL_FAILED_ALREADY_EXISTS = -1;
    public static final int INSTALL_FAILED_CONFLICTING_PROVIDER = -13;
    public static final int INSTALL_FAILED_CONTAINER_ERROR = -18;
    public static final int INSTALL_FAILED_CPU_ABI_INCOMPATIBLE = -16;
    public static final int INSTALL_FAILED_DEXOPT = -11;
    public static final int INSTALL_FAILED_DUPLICATE_PACKAGE = -5;
    public static final int INSTALL_FAILED_INSUFFICIENT_STORAGE = -4;
    public static final int INSTALL_FAILED_INTERNAL_ERROR = -110;
    public static final int INSTALL_FAILED_INVALID_APK = -2;
    public static final int INSTALL_FAILED_INVALID_INSTALL_LOCATION = -19;
    public static final int INSTALL_FAILED_INVALID_URI = -3;
    public static final int INSTALL_FAILED_MEDIA_UNAVAILABLE = -20;
    public static final int INSTALL_FAILED_MISSING_FEATURE = -17;
    public static final int INSTALL_FAILED_MISSING_SHARED_LIBRARY = -9;
    public static final int INSTALL_FAILED_NEWER_SDK = -14;
    public static final int INSTALL_FAILED_NO_SHARED_USER = -6;
    public static final int INSTALL_FAILED_OLDER_SDK = -12;
    public static final int INSTALL_FAILED_PACKAGE_CHANGED = -23;
    public static final int INSTALL_FAILED_REPLACE_COULDNT_DELETE = -10;
    public static final int INSTALL_FAILED_SHARED_USER_INCOMPATIBLE = -8;
    public static final int INSTALL_FAILED_TEST_ONLY = -15;
    public static final int INSTALL_FAILED_UID_CHANGED = -24;
    public static final int INSTALL_FAILED_UPDATE_INCOMPATIBLE = -7;
    public static final int INSTALL_FAILED_VERIFICATION_FAILURE = -22;
    public static final int INSTALL_FAILED_VERIFICATION_TIMEOUT = -21;
    public static final int INSTALL_FORWARD_LOCK = 1;
    public static final int INSTALL_FROM_ADB = 32;
    public static final int INSTALL_INTERNAL = 16;
    public static final int INSTALL_PARSE_FAILED_BAD_MANIFEST = -101;
    public static final int INSTALL_PARSE_FAILED_BAD_PACKAGE_NAME = -106;
    public static final int INSTALL_PARSE_FAILED_BAD_SHARED_USER_ID = -107;
    public static final int INSTALL_PARSE_FAILED_CERTIFICATE_ENCODING = -105;
    public static final int INSTALL_PARSE_FAILED_INCONSISTENT_CERTIFICATES = -104;
    public static final int INSTALL_PARSE_FAILED_MANIFEST_EMPTY = -109;
    public static final int INSTALL_PARSE_FAILED_MANIFEST_MALFORMED = -108;
    public static final int INSTALL_PARSE_FAILED_NOT_APK = -100;
    public static final int INSTALL_PARSE_FAILED_NO_CERTIFICATES = -103;
    public static final int INSTALL_PARSE_FAILED_UNEXPECTED_EXCEPTION = -102;
    public static final int INSTALL_REPLACE_EXISTING = 2;
    public static final int INSTALL_SUCCEEDED = 1;
    public static final int MATCH_DEFAULT_ONLY = 0x10000;
    public static final int MOVE_EXTERNAL_MEDIA = 2;
    public static final int MOVE_FAILED_DOESNT_EXIST = -2;
    public static final int MOVE_FAILED_FORWARD_LOCKED = -4;
    public static final int MOVE_FAILED_INSUFFICIENT_STORAGE = -1;
    public static final int MOVE_FAILED_INTERNAL_ERROR = -6;
    public static final int MOVE_FAILED_INVALID_LOCATION = -5;
    public static final int MOVE_FAILED_OPERATION_PENDING = -7;
    public static final int MOVE_FAILED_SYSTEM_PACKAGE = -3;
    public static final int MOVE_INTERNAL = 1;
    public static final int MOVE_SUCCEEDED = 1;
    public static final int PERMISSION_DENIED = -1;
    public static final int PERMISSION_GRANTED = 0;
    public static final int SIGNATURE_FIRST_NOT_SIGNED = -1;
    public static final int SIGNATURE_MATCH = 0;
    public static final int SIGNATURE_NEITHER_SIGNED = 1;
    public static final int SIGNATURE_NO_MATCH = -3;
    public static final int SIGNATURE_SECOND_NOT_SIGNED = -2;
    public static final int SIGNATURE_UNKNOWN_PACKAGE = -4;
    public static final int VERIFICATION_ALLOW = 1;
    public static final int VERIFICATION_ALLOW_WITHOUT_SUFFICIENT = 2;
    public static final int VERIFICATION_REJECT = -1;
}

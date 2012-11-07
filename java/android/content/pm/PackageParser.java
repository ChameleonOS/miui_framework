// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.pm;

import android.content.ComponentName;
import android.content.IntentFilter;
import android.content.res.*;
import android.os.*;
import android.util.*;
import com.android.internal.util.XmlUtils;
import java.io.*;
import java.lang.ref.WeakReference;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;
import java.util.jar.*;
import miui.content.pm.ExtraPackageManager;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package android.content.pm:
//            ApplicationInfo, ActivityInfo, PackageManager, InstrumentationInfo, 
//            PackageInfo, ConfigurationInfo, FeatureInfo, ServiceInfo, 
//            ProviderInfo, PermissionInfo, Signature, PermissionGroupInfo, 
//            PackageItemInfo, PathPermission, VerifierInfo, ManifestDigest, 
//            ComponentInfo

public class PackageParser {
    public static final class ServiceIntentInfo extends IntentInfo {

        public String toString() {
            return (new StringBuilder()).append("ServiceIntentInfo{").append(Integer.toHexString(System.identityHashCode(this))).append(" ").append(((PackageItemInfo) (service.info)).name).append("}").toString();
        }

        public final Service service;

        public ServiceIntentInfo(Service service1) {
            service = service1;
        }
    }

    public static final class ActivityIntentInfo extends IntentInfo {

        public String toString() {
            return (new StringBuilder()).append("ActivityIntentInfo{").append(Integer.toHexString(System.identityHashCode(this))).append(" ").append(((PackageItemInfo) (activity.info)).name).append("}").toString();
        }

        public final Activity activity;

        public ActivityIntentInfo(Activity activity1) {
            activity = activity1;
        }
    }

    public static class IntentInfo extends IntentFilter {

        public boolean hasDefault;
        public int icon;
        public int labelRes;
        public int logo;
        public CharSequence nonLocalizedLabel;

        public IntentInfo() {
        }
    }

    public static final class Instrumentation extends Component {

        public void setPackageName(String s) {
            super.setPackageName(s);
            info.packageName = s;
        }

        public String toString() {
            return (new StringBuilder()).append("Instrumentation{").append(Integer.toHexString(System.identityHashCode(this))).append(" ").append(getComponentShortName()).append("}").toString();
        }

        public final InstrumentationInfo info;

        public Instrumentation(ParsePackageItemArgs parsepackageitemargs, InstrumentationInfo instrumentationinfo) {
            super(parsepackageitemargs, instrumentationinfo);
            info = instrumentationinfo;
        }
    }

    public static final class Provider extends Component {

        public void setPackageName(String s) {
            super.setPackageName(s);
            info.packageName = s;
        }

        public String toString() {
            return (new StringBuilder()).append("Provider{").append(Integer.toHexString(System.identityHashCode(this))).append(" ").append(((PackageItemInfo) (info)).name).append("}").toString();
        }

        public final ProviderInfo info;
        public boolean syncable;

        public Provider(ParseComponentArgs parsecomponentargs, ProviderInfo providerinfo) {
            super(parsecomponentargs, providerinfo);
            info = providerinfo;
            info.applicationInfo = ((ParsePackageItemArgs) (parsecomponentargs)).owner.applicationInfo;
            syncable = false;
        }

        public Provider(Provider provider) {
            super(provider);
            info = provider.info;
            syncable = provider.syncable;
        }
    }

    public static final class Service extends Component {

        public void setPackageName(String s) {
            super.setPackageName(s);
            info.packageName = s;
        }

        public String toString() {
            return (new StringBuilder()).append("Service{").append(Integer.toHexString(System.identityHashCode(this))).append(" ").append(getComponentShortName()).append("}").toString();
        }

        public final ServiceInfo info;

        public Service(ParseComponentArgs parsecomponentargs, ServiceInfo serviceinfo) {
            super(parsecomponentargs, serviceinfo);
            info = serviceinfo;
            info.applicationInfo = ((ParsePackageItemArgs) (parsecomponentargs)).owner.applicationInfo;
        }
    }

    public static final class Activity extends Component {

        public void setPackageName(String s) {
            super.setPackageName(s);
            info.packageName = s;
        }

        public String toString() {
            return (new StringBuilder()).append("Activity{").append(Integer.toHexString(System.identityHashCode(this))).append(" ").append(getComponentShortName()).append("}").toString();
        }

        public final ActivityInfo info;

        public Activity(ParseComponentArgs parsecomponentargs, ActivityInfo activityinfo) {
            super(parsecomponentargs, activityinfo);
            info = activityinfo;
            info.applicationInfo = ((ParsePackageItemArgs) (parsecomponentargs)).owner.applicationInfo;
        }
    }

    public static final class PermissionGroup extends Component {

        public void setPackageName(String s) {
            super.setPackageName(s);
            info.packageName = s;
        }

        public String toString() {
            return (new StringBuilder()).append("PermissionGroup{").append(Integer.toHexString(System.identityHashCode(this))).append(" ").append(((PackageItemInfo) (info)).name).append("}").toString();
        }

        public final PermissionGroupInfo info;

        public PermissionGroup(Package package1) {
            super(package1);
            info = new PermissionGroupInfo();
        }

        public PermissionGroup(Package package1, PermissionGroupInfo permissiongroupinfo) {
            super(package1);
            info = permissiongroupinfo;
        }
    }

    public static final class Permission extends Component {

        public void setPackageName(String s) {
            super.setPackageName(s);
            info.packageName = s;
        }

        public String toString() {
            return (new StringBuilder()).append("Permission{").append(Integer.toHexString(System.identityHashCode(this))).append(" ").append(((PackageItemInfo) (info)).name).append("}").toString();
        }

        public PermissionGroup group;
        public final PermissionInfo info;
        public boolean tree;

        public Permission(Package package1) {
            super(package1);
            info = new PermissionInfo();
        }

        public Permission(Package package1, PermissionInfo permissioninfo) {
            super(package1);
            info = permissioninfo;
        }
    }

    public static class Component {

        public ComponentName getComponentName() {
            ComponentName componentname;
            if(componentName != null) {
                componentname = componentName;
            } else {
                if(className != null)
                    componentName = new ComponentName(((PackageItemInfo) (owner.applicationInfo)).packageName, className);
                componentname = componentName;
            }
            return componentname;
        }

        public String getComponentShortName() {
            String s;
            if(componentShortName != null) {
                s = componentShortName;
            } else {
                ComponentName componentname = getComponentName();
                if(componentname != null)
                    componentShortName = componentname.flattenToShortString();
                s = componentShortName;
            }
            return s;
        }

        public void setPackageName(String s) {
            componentName = null;
            componentShortName = null;
        }

        public final String className;
        ComponentName componentName;
        String componentShortName;
        public final ArrayList intents;
        public Bundle metaData;
        public final Package owner;

        public Component(Component component) {
            owner = component.owner;
            intents = component.intents;
            className = component.className;
            componentName = component.componentName;
            componentShortName = component.componentShortName;
        }

        public Component(Package package1) {
            owner = package1;
            intents = null;
            className = null;
        }

        public Component(ParseComponentArgs parsecomponentargs, ComponentInfo componentinfo) {
            this(((ParsePackageItemArgs) (parsecomponentargs)), ((PackageItemInfo) (componentinfo)));
            if(((ParsePackageItemArgs) (parsecomponentargs)).outError[0] == null) {
                if(parsecomponentargs.processRes != 0) {
                    String s;
                    if(owner.applicationInfo.targetSdkVersion >= 8)
                        s = ((ParsePackageItemArgs) (parsecomponentargs)).sa.getNonConfigurationString(parsecomponentargs.processRes, 0);
                    else
                        s = ((ParsePackageItemArgs) (parsecomponentargs)).sa.getNonResourceString(parsecomponentargs.processRes);
                    componentinfo.processName = PackageParser.buildProcessName(((PackageItemInfo) (owner.applicationInfo)).packageName, owner.applicationInfo.processName, s, parsecomponentargs.flags, parsecomponentargs.sepProcesses, ((ParsePackageItemArgs) (parsecomponentargs)).outError);
                }
                if(parsecomponentargs.descriptionRes != 0)
                    componentinfo.descriptionRes = ((ParsePackageItemArgs) (parsecomponentargs)).sa.getResourceId(parsecomponentargs.descriptionRes, 0);
                componentinfo.enabled = ((ParsePackageItemArgs) (parsecomponentargs)).sa.getBoolean(parsecomponentargs.enabledRes, true);
            }
        }

        public Component(ParsePackageItemArgs parsepackageitemargs, PackageItemInfo packageiteminfo) {
            owner = parsepackageitemargs.owner;
            intents = new ArrayList(0);
            String s = parsepackageitemargs.sa.getNonConfigurationString(parsepackageitemargs.nameRes, 0);
            if(s == null) {
                className = null;
                parsepackageitemargs.outError[0] = (new StringBuilder()).append(parsepackageitemargs.tag).append(" does not specify android:name").toString();
            } else {
                packageiteminfo.name = PackageParser.buildClassName(((PackageItemInfo) (owner.applicationInfo)).packageName, s, parsepackageitemargs.outError);
                if(packageiteminfo.name == null) {
                    className = null;
                    parsepackageitemargs.outError[0] = (new StringBuilder()).append(parsepackageitemargs.tag).append(" does not have valid android:name").toString();
                } else {
                    className = packageiteminfo.name;
                    int i = parsepackageitemargs.sa.getResourceId(parsepackageitemargs.iconRes, 0);
                    if(i != 0) {
                        packageiteminfo.icon = i;
                        packageiteminfo.nonLocalizedLabel = null;
                    }
                    int j = parsepackageitemargs.sa.getResourceId(parsepackageitemargs.logoRes, 0);
                    if(j != 0)
                        packageiteminfo.logo = j;
                    TypedValue typedvalue = parsepackageitemargs.sa.peekValue(parsepackageitemargs.labelRes);
                    if(typedvalue != null) {
                        int k = typedvalue.resourceId;
                        packageiteminfo.labelRes = k;
                        if(k == 0)
                            packageiteminfo.nonLocalizedLabel = typedvalue.coerceToString();
                    }
                    packageiteminfo.packageName = owner.packageName;
                }
            }
        }
    }

    public static final class Package {

        public boolean hasComponentClassName(String s) {
            int i = -1 + activities.size();
_L5:
            if(i < 0) goto _L2; else goto _L1
_L1:
            if(!s.equals(((Component) ((Activity)activities.get(i))).className)) goto _L4; else goto _L3
_L3:
            boolean flag = true;
_L6:
            return flag;
_L4:
            i--;
              goto _L5
_L2:
            int j = -1 + receivers.size();
_L7:
label0:
            {
                if(j < 0)
                    break MISSING_BLOCK_LABEL_96;
                if(!s.equals(((Component) ((Activity)receivers.get(j))).className))
                    break label0;
                flag = true;
            }
              goto _L6
            j--;
              goto _L7
            int k = -1 + providers.size();
_L8:
label1:
            {
                if(k < 0)
                    break MISSING_BLOCK_LABEL_147;
                if(!s.equals(((Component) ((Provider)providers.get(k))).className))
                    break label1;
                flag = true;
            }
              goto _L6
            k--;
              goto _L8
            int l = -1 + services.size();
_L9:
label2:
            {
                if(l < 0)
                    break MISSING_BLOCK_LABEL_198;
                if(!s.equals(((Component) ((Service)services.get(l))).className))
                    break label2;
                flag = true;
            }
              goto _L6
            l--;
              goto _L9
            int i1 = -1 + instrumentation.size();
_L10:
label3:
            {
                if(i1 < 0)
                    break MISSING_BLOCK_LABEL_249;
                if(!s.equals(((Component) ((Instrumentation)instrumentation.get(i1))).className))
                    break label3;
                flag = true;
            }
              goto _L6
            i1--;
              goto _L10
            flag = false;
              goto _L6
        }

        public void setPackageName(String s) {
            packageName = s;
            applicationInfo.packageName = s;
            for(int i = -1 + permissions.size(); i >= 0; i--)
                ((Permission)permissions.get(i)).setPackageName(s);

            for(int j = -1 + permissionGroups.size(); j >= 0; j--)
                ((PermissionGroup)permissionGroups.get(j)).setPackageName(s);

            for(int k = -1 + activities.size(); k >= 0; k--)
                ((Activity)activities.get(k)).setPackageName(s);

            for(int l = -1 + receivers.size(); l >= 0; l--)
                ((Activity)receivers.get(l)).setPackageName(s);

            for(int i1 = -1 + providers.size(); i1 >= 0; i1--)
                ((Provider)providers.get(i1)).setPackageName(s);

            for(int j1 = -1 + services.size(); j1 >= 0; j1--)
                ((Service)services.get(j1)).setPackageName(s);

            for(int k1 = -1 + instrumentation.size(); k1 >= 0; k1--)
                ((Instrumentation)instrumentation.get(k1)).setPackageName(s);

        }

        public String toString() {
            return (new StringBuilder()).append("Package{").append(Integer.toHexString(System.identityHashCode(this))).append(" ").append(packageName).append("}").toString();
        }

        public final ArrayList activities = new ArrayList(0);
        public final ApplicationInfo applicationInfo = new ApplicationInfo();
        public final ArrayList configPreferences = new ArrayList();
        public int installLocation;
        public final ArrayList instrumentation = new ArrayList(0);
        public ArrayList mAdoptPermissions;
        public Bundle mAppMetaData;
        public boolean mDidDexOpt;
        public Object mExtras;
        public boolean mOperationPending;
        public ArrayList mOriginalPackages;
        public String mPath;
        public int mPreferredOrder;
        public String mRealPackage;
        public String mScanPath;
        public String mSharedUserId;
        public int mSharedUserLabel;
        public Signature mSignatures[];
        public int mVersionCode;
        public String mVersionName;
        public ManifestDigest manifestDigest;
        public String packageName;
        public final ArrayList permissionGroups = new ArrayList(0);
        public final ArrayList permissions = new ArrayList(0);
        public ArrayList protectedBroadcasts;
        public final ArrayList providers = new ArrayList(0);
        public final ArrayList receivers = new ArrayList(0);
        public ArrayList reqFeatures;
        public final ArrayList requestedPermissions = new ArrayList();
        public final ArrayList requestedPermissionsRequired = new ArrayList();
        public final ArrayList services = new ArrayList(0);
        public ArrayList usesLibraries;
        public String usesLibraryFiles[];
        public ArrayList usesOptionalLibraries;

        public Package(String s) {
            usesLibraries = null;
            usesOptionalLibraries = null;
            usesLibraryFiles = null;
            mOriginalPackages = null;
            mRealPackage = null;
            mAdoptPermissions = null;
            mAppMetaData = null;
            mPreferredOrder = 0;
            reqFeatures = null;
            packageName = s;
            applicationInfo.packageName = s;
            applicationInfo.uid = -1;
        }
    }

    public static class PackageLite {

        public final int installLocation;
        public final String packageName;
        public final VerifierInfo verifiers[];

        public PackageLite(String s, int i, List list) {
            packageName = s;
            installLocation = i;
            verifiers = (VerifierInfo[])list.toArray(new VerifierInfo[list.size()]);
        }
    }

    static class ParseComponentArgs extends ParsePackageItemArgs {

        final int descriptionRes;
        final int enabledRes;
        int flags;
        final int processRes;
        final String sepProcesses[];

        ParseComponentArgs(Package package1, String as[], int i, int j, int k, int l, String as1[], 
                int i1, int j1, int k1) {
            super(package1, as, i, j, k, l);
            sepProcesses = as1;
            processRes = i1;
            descriptionRes = j1;
            enabledRes = k1;
        }
    }

    static class ParsePackageItemArgs {

        final int iconRes;
        final int labelRes;
        final int logoRes;
        final int nameRes;
        final String outError[];
        final Package owner;
        TypedArray sa;
        String tag;

        ParsePackageItemArgs(Package package1, String as[], int i, int j, int k, int l) {
            owner = package1;
            outError = as;
            nameRes = i;
            labelRes = j;
            iconRes = k;
            logoRes = l;
        }
    }

    public static class SplitPermissionInfo {

        public final String newPerms[];
        public final String rootPerm;
        public final int targetSdk;

        public SplitPermissionInfo(String s, String as[], int i) {
            rootPerm = s;
            newPerms = as;
            targetSdk = i;
        }
    }

    public static class NewPermissionInfo {

        public final int fileVersion;
        public final String name;
        public final int sdkVersion;

        public NewPermissionInfo(String s, int i, int j) {
            name = s;
            sdkVersion = i;
            fileVersion = j;
        }
    }

    static class Injector {

        static int checkPriority(int i, int j) {
            if((i & 1) != 0) goto _L2; else goto _L1
_L1:
            if(j < 1000) goto _L4; else goto _L3
_L3:
            j = 999;
_L2:
            return j;
_L4:
            if(j <= -1000)
                j = -999;
            if(true) goto _L2; else goto _L5
_L5:
        }

        static String filterNameError(String s, String s1) {
            if("miui".equals(s))
                s1 = null;
            return s1;
        }

        Injector() {
        }
    }


    public PackageParser(String s) {
        mParseError = 1;
        mArchiveSourcePath = s;
    }

    private static String buildClassName(String s, CharSequence charsequence, String as[]) {
        String s1 = null;
        if(charsequence == null || charsequence.length() <= 0) {
            as[0] = (new StringBuilder()).append("Empty class name in package ").append(s).toString();
        } else {
            String s2 = charsequence.toString();
            char c = s2.charAt(0);
            if(c == '.')
                s1 = (new StringBuilder()).append(s).append(s2).toString().intern();
            else
            if(s2.indexOf('.') < 0) {
                StringBuilder stringbuilder = new StringBuilder(s);
                stringbuilder.append('.');
                stringbuilder.append(s2);
                s1 = stringbuilder.toString().intern();
            } else
            if(c >= 'a' && c <= 'z')
                s1 = s2.intern();
            else
                as[0] = (new StringBuilder()).append("Bad class name ").append(s2).append(" in package ").append(s).toString();
        }
        return s1;
    }

    private static String buildCompoundName(String s, CharSequence charsequence, String s1, String as[]) {
        String s2 = null;
        String s3 = charsequence.toString();
        char c = s3.charAt(0);
        if(s != null && c == ':') {
            if(s3.length() < 2) {
                as[0] = (new StringBuilder()).append("Bad ").append(s1).append(" name ").append(s3).append(" in package ").append(s).append(": must be at least two characters").toString();
            } else {
                String s5 = validateName(s3.substring(1), false);
                if(s5 != null)
                    as[0] = (new StringBuilder()).append("Invalid ").append(s1).append(" name ").append(s3).append(" in package ").append(s).append(": ").append(s5).toString();
                else
                    s2 = (new StringBuilder()).append(s).append(s3).toString().intern();
            }
        } else {
            String s4 = validateName(s3, true);
            if(s4 != null && !"system".equals(s3))
                as[0] = (new StringBuilder()).append("Invalid ").append(s1).append(" name ").append(s3).append(" in package ").append(s).append(": ").append(s4).toString();
            else
                s2 = s3.intern();
        }
        return s2;
    }

    private static String buildProcessName(String s, String s1, CharSequence charsequence, int i, String as[], String as1[]) {
        if((i & 8) == 0 || "system".equals(charsequence)) goto _L2; else goto _L1
_L1:
        if(s1 == null)
            s1 = s;
_L4:
        return s1;
_L2:
        if(as != null) {
            int j = -1 + as.length;
            do {
                if(j < 0)
                    break;
                String s2 = as[j];
                if(s2.equals(s) || s2.equals(s1) || s2.equals(charsequence)) {
                    s1 = s;
                    continue; /* Loop/switch isn't completed */
                }
                j--;
            } while(true);
        }
        if(charsequence != null && charsequence.length() > 0)
            s1 = buildCompoundName(s, charsequence, "process", as1);
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static String buildTaskAffinityName(String s, String s1, CharSequence charsequence, String as[]) {
        if(charsequence != null)
            if(charsequence.length() <= 0)
                s1 = null;
            else
                s1 = buildCompoundName(s, charsequence, "taskAffinity", as);
        return s1;
    }

    private static boolean copyNeeded(int i, Package package1, int j, Bundle bundle) {
        boolean flag = true;
        if(j == 0) goto _L2; else goto _L1
_L1:
        int k;
        if(j == flag)
            k = ((flag) ? 1 : 0);
        else
            k = 0;
        if(package1.applicationInfo.enabled == k) goto _L2; else goto _L3
_L3:
        return flag;
_L2:
        if(((i & 0x80) == 0 || bundle == null && package1.mAppMetaData == null) && ((i & 0x400) == 0 || package1.usesLibraryFiles == null))
            flag = false;
        if(true) goto _L3; else goto _L4
_L4:
    }

    public static final ActivityInfo generateActivityInfo(Activity activity, int i, boolean flag, int j, int k) {
        ActivityInfo activityinfo;
        if(activity == null)
            activityinfo = null;
        else
        if(!copyNeeded(i, activity.owner, j, activity.metaData) && k == 0) {
            activityinfo = activity.info;
        } else {
            activityinfo = new ActivityInfo(activity.info);
            activityinfo.metaData = activity.metaData;
            activityinfo.applicationInfo = generateApplicationInfo(activity.owner, i, flag, j, k);
        }
        return activityinfo;
    }

    public static ApplicationInfo generateApplicationInfo(Package package1, int i, boolean flag, int j) {
        return generateApplicationInfo(package1, i, flag, j, UserId.getCallingUserId());
    }

    public static ApplicationInfo generateApplicationInfo(Package package1, int i, boolean flag, int j, int k) {
        if(package1 != null) goto _L2; else goto _L1
_L1:
        ApplicationInfo applicationinfo = null;
_L9:
        return applicationinfo;
_L2:
        if(copyNeeded(i, package1, j, null) || k != 0) goto _L4; else goto _L3
_L3:
        if(!sCompatibilityModeEnabled)
            package1.applicationInfo.disableCompatibilityMode();
        if(flag) {
            ApplicationInfo applicationinfo2 = package1.applicationInfo;
            applicationinfo2.flags = 0x200000 | applicationinfo2.flags;
        } else {
            ApplicationInfo applicationinfo1 = package1.applicationInfo;
            applicationinfo1.flags = 0xffdfffff & applicationinfo1.flags;
        }
        if(j != 1) goto _L6; else goto _L5
_L5:
        package1.applicationInfo.enabled = true;
_L7:
        package1.applicationInfo.enabledSetting = j;
        applicationinfo = package1.applicationInfo;
        continue; /* Loop/switch isn't completed */
_L6:
        if(j == 2 || j == 3)
            package1.applicationInfo.enabled = false;
        if(true) goto _L7; else goto _L4
_L4:
        applicationinfo = new ApplicationInfo(package1.applicationInfo);
        if(k != 0) {
            applicationinfo.uid = UserId.getUid(k, applicationinfo.uid);
            applicationinfo.dataDir = PackageManager.getDataDirForUser(k, applicationinfo.packageName);
        }
        if((i & 0x80) != 0)
            applicationinfo.metaData = package1.mAppMetaData;
        if((i & 0x400) != 0)
            applicationinfo.sharedLibraryFiles = package1.usesLibraryFiles;
        if(!sCompatibilityModeEnabled)
            applicationinfo.disableCompatibilityMode();
        if(flag)
            applicationinfo.flags = 0x200000 | applicationinfo.flags;
        else
            applicationinfo.flags = 0xffdfffff & applicationinfo.flags;
        if(j != 1)
            break; /* Loop/switch isn't completed */
        applicationinfo.enabled = true;
_L11:
        applicationinfo.enabledSetting = j;
        if(true) goto _L9; else goto _L8
_L8:
        if(j != 2 && j != 3) goto _L11; else goto _L10
_L10:
        applicationinfo.enabled = false;
          goto _L11
    }

    public static final InstrumentationInfo generateInstrumentationInfo(Instrumentation instrumentation, int i) {
        InstrumentationInfo instrumentationinfo;
        if(instrumentation == null)
            instrumentationinfo = null;
        else
        if((i & 0x80) == 0) {
            instrumentationinfo = instrumentation.info;
        } else {
            instrumentationinfo = new InstrumentationInfo(instrumentation.info);
            instrumentationinfo.metaData = instrumentation.metaData;
        }
        return instrumentationinfo;
    }

    public static PackageInfo generatePackageInfo(Package package1, int ai[], int i, long l, long l1, HashSet hashset) {
        return generatePackageInfo(package1, ai, i, l, l1, hashset, false, 0, UserId.getCallingUserId());
    }

    public static PackageInfo generatePackageInfo(Package package1, int ai[], int i, long l, long l1, HashSet hashset, 
            boolean flag, int j) {
        return generatePackageInfo(package1, ai, i, l, l1, hashset, flag, j, UserId.getCallingUserId());
    }

    public static PackageInfo generatePackageInfo(Package package1, int ai[], int i, long l, long l1, HashSet hashset, 
            boolean flag, int j, int k) {
        PackageInfo packageinfo = new PackageInfo();
        packageinfo.packageName = package1.packageName;
        packageinfo.versionCode = package1.mVersionCode;
        packageinfo.versionName = package1.mVersionName;
        packageinfo.sharedUserId = package1.mSharedUserId;
        packageinfo.sharedUserLabel = package1.mSharedUserLabel;
        packageinfo.applicationInfo = generateApplicationInfo(package1, i, flag, j, k);
        packageinfo.installLocation = package1.installLocation;
        packageinfo.firstInstallTime = l;
        packageinfo.lastUpdateTime = l1;
        if((i & 0x100) != 0)
            packageinfo.gids = ai;
        if((i & 0x4000) != 0) {
            int i9 = package1.configPreferences.size();
            if(i9 > 0) {
                packageinfo.configPreferences = new ConfigurationInfo[i9];
                package1.configPreferences.toArray(packageinfo.configPreferences);
            }
            int j8;
            ActivityInfo aactivityinfo1[];
            int j9;
            if(package1.reqFeatures != null)
                j9 = package1.reqFeatures.size();
            else
                j9 = 0;
            if(j9 > 0) {
                packageinfo.reqFeatures = new FeatureInfo[j9];
                package1.reqFeatures.toArray(packageinfo.reqFeatures);
            }
        }
        if((i & 1) != 0) {
            int k7 = package1.activities.size();
            if(k7 > 0) {
                int k8;
                if((i & 0x200) != 0) {
                    packageinfo.activities = new ActivityInfo[k7];
                } else {
                    int l7 = 0;
                    for(int i8 = 0; i8 < k7; i8++)
                        if(((Activity)package1.activities.get(i8)).info.enabled)
                            l7++;

                    packageinfo.activities = new ActivityInfo[l7];
                }
                j8 = 0;
                k8 = 0;
                while(j8 < k7)  {
                    int i1;
                    int j1;
                    int k1;
                    int i2;
                    String s;
                    int ai1[];
                    int ai2[];
                    int j2;
                    int k2;
                    int l2;
                    int i3;
                    int j3;
                    int k3;
                    int l3;
                    int i4;
                    ProviderInfo aproviderinfo[];
                    int j4;
                    int k4;
                    int l4;
                    int i5;
                    int j5;
                    int k5;
                    ServiceInfo aserviceinfo[];
                    int l5;
                    int i6;
                    int j6;
                    int k6;
                    int l6;
                    int i7;
                    ActivityInfo aactivityinfo[];
                    int j7;
                    int l8;
                    if(((Activity)package1.activities.get(j8)).info.enabled || (i & 0x200) != 0) {
                        aactivityinfo1 = packageinfo.activities;
                        l8 = k8 + 1;
                        aactivityinfo1[k8] = generateActivityInfo((Activity)package1.activities.get(j8), i, flag, j, k);
                    } else {
                        l8 = k8;
                    }
                    j8++;
                    k8 = l8;
                }
            }
        }
        if((i & 2) != 0) {
            i6 = package1.receivers.size();
            if(i6 > 0) {
                if((i & 0x200) != 0) {
                    packageinfo.receivers = new ActivityInfo[i6];
                } else {
                    j6 = 0;
                    for(k6 = 0; k6 < i6; k6++)
                        if(((Activity)package1.receivers.get(k6)).info.enabled)
                            j6++;

                    packageinfo.receivers = new ActivityInfo[j6];
                }
                l6 = 0;
                i7 = 0;
                while(l6 < i6)  {
                    if(((Activity)package1.receivers.get(l6)).info.enabled || (i & 0x200) != 0) {
                        aactivityinfo = packageinfo.receivers;
                        j7 = i7 + 1;
                        aactivityinfo[i7] = generateActivityInfo((Activity)package1.receivers.get(l6), i, flag, j, k);
                    } else {
                        j7 = i7;
                    }
                    l6++;
                    i7 = j7;
                }
            }
        }
        if((i & 4) != 0) {
            k4 = package1.services.size();
            if(k4 > 0) {
                if((i & 0x200) != 0) {
                    packageinfo.services = new ServiceInfo[k4];
                } else {
                    l4 = 0;
                    for(i5 = 0; i5 < k4; i5++)
                        if(((Service)package1.services.get(i5)).info.enabled)
                            l4++;

                    packageinfo.services = new ServiceInfo[l4];
                }
                j5 = 0;
                k5 = 0;
                while(j5 < k4)  {
                    if(((Service)package1.services.get(j5)).info.enabled || (i & 0x200) != 0) {
                        aserviceinfo = packageinfo.services;
                        l5 = k5 + 1;
                        aserviceinfo[k5] = generateServiceInfo((Service)package1.services.get(j5), i, flag, j, k);
                    } else {
                        l5 = k5;
                    }
                    j5++;
                    k5 = l5;
                }
            }
        }
        if((i & 8) != 0) {
            i3 = package1.providers.size();
            if(i3 > 0) {
                if((i & 0x200) != 0) {
                    packageinfo.providers = new ProviderInfo[i3];
                } else {
                    j3 = 0;
                    for(k3 = 0; k3 < i3; k3++)
                        if(((Provider)package1.providers.get(k3)).info.enabled)
                            j3++;

                    packageinfo.providers = new ProviderInfo[j3];
                }
                l3 = 0;
                i4 = 0;
                while(l3 < i3)  {
                    if(((Provider)package1.providers.get(l3)).info.enabled || (i & 0x200) != 0) {
                        aproviderinfo = packageinfo.providers;
                        j4 = i4 + 1;
                        aproviderinfo[i4] = generateProviderInfo((Provider)package1.providers.get(l3), i, flag, j, k);
                    } else {
                        j4 = i4;
                    }
                    l3++;
                    i4 = j4;
                }
            }
        }
        if((i & 0x10) != 0) {
            k2 = package1.instrumentation.size();
            if(k2 > 0) {
                packageinfo.instrumentation = new InstrumentationInfo[k2];
                for(l2 = 0; l2 < k2; l2++)
                    packageinfo.instrumentation[l2] = generateInstrumentationInfo((Instrumentation)package1.instrumentation.get(l2), i);

            }
        }
        if((i & 0x1000) != 0) {
            j1 = package1.permissions.size();
            if(j1 > 0) {
                packageinfo.permissions = new PermissionInfo[j1];
                for(j2 = 0; j2 < j1; j2++)
                    packageinfo.permissions[j2] = generatePermissionInfo((Permission)package1.permissions.get(j2), i);

            }
            k1 = package1.requestedPermissions.size();
            if(k1 > 0) {
                packageinfo.requestedPermissions = new String[k1];
                packageinfo.requestedPermissionsFlags = new int[k1];
                for(i2 = 0; i2 < k1; i2++) {
                    s = (String)package1.requestedPermissions.get(i2);
                    packageinfo.requestedPermissions[i2] = s;
                    if(((Boolean)package1.requestedPermissionsRequired.get(i2)).booleanValue()) {
                        ai2 = packageinfo.requestedPermissionsFlags;
                        ai2[i2] = 1 | ai2[i2];
                    }
                    if(hashset != null && hashset.contains(s)) {
                        ai1 = packageinfo.requestedPermissionsFlags;
                        ai1[i2] = 2 | ai1[i2];
                    }
                }

            }
        }
        if((i & 0x40) != 0) {
            if(package1.mSignatures != null)
                i1 = package1.mSignatures.length;
            else
                i1 = 0;
            if(i1 > 0) {
                packageinfo.signatures = new Signature[i1];
                System.arraycopy(package1.mSignatures, 0, packageinfo.signatures, 0, i1);
            }
        }
        return packageinfo;
    }

    public static final PermissionGroupInfo generatePermissionGroupInfo(PermissionGroup permissiongroup, int i) {
        PermissionGroupInfo permissiongroupinfo;
        if(permissiongroup == null)
            permissiongroupinfo = null;
        else
        if((i & 0x80) == 0) {
            permissiongroupinfo = permissiongroup.info;
        } else {
            permissiongroupinfo = new PermissionGroupInfo(permissiongroup.info);
            permissiongroupinfo.metaData = permissiongroup.metaData;
        }
        return permissiongroupinfo;
    }

    public static final PermissionInfo generatePermissionInfo(Permission permission, int i) {
        PermissionInfo permissioninfo;
        if(permission == null)
            permissioninfo = null;
        else
        if((i & 0x80) == 0) {
            permissioninfo = permission.info;
        } else {
            permissioninfo = new PermissionInfo(permission.info);
            permissioninfo.metaData = permission.metaData;
        }
        return permissioninfo;
    }

    public static final ProviderInfo generateProviderInfo(Provider provider, int i, boolean flag, int j, int k) {
        ProviderInfo providerinfo;
        if(provider == null)
            providerinfo = null;
        else
        if(!copyNeeded(i, provider.owner, j, provider.metaData) && ((i & 0x800) != 0 || provider.info.uriPermissionPatterns == null) && k == 0) {
            providerinfo = provider.info;
        } else {
            providerinfo = new ProviderInfo(provider.info);
            providerinfo.metaData = provider.metaData;
            if((i & 0x800) == 0)
                providerinfo.uriPermissionPatterns = null;
            providerinfo.applicationInfo = generateApplicationInfo(provider.owner, i, flag, j, k);
        }
        return providerinfo;
    }

    public static final ServiceInfo generateServiceInfo(Service service, int i, boolean flag, int j, int k) {
        ServiceInfo serviceinfo;
        if(service == null)
            serviceinfo = null;
        else
        if(!copyNeeded(i, service.owner, j, service.metaData) && k == UserId.getUserId(service.info.applicationInfo.uid)) {
            serviceinfo = service.info;
        } else {
            serviceinfo = new ServiceInfo(service.info);
            serviceinfo.metaData = service.metaData;
            serviceinfo.applicationInfo = generateApplicationInfo(service.owner, i, flag, j, k);
        }
        return serviceinfo;
    }

    private static final boolean isPackageFilename(String s) {
        return s.endsWith(".apk");
    }

    private Certificate[] loadCertificates(JarFile jarfile, JarEntry jarentry, byte abyte0[]) {
        Certificate acertificate[] = null;
        Certificate acertificate1[];
        BufferedInputStream bufferedinputstream;
        for(bufferedinputstream = new BufferedInputStream(jarfile.getInputStream(jarentry)); bufferedinputstream.read(abyte0, 0, abyte0.length) != -1;);
        bufferedinputstream.close();
        if(jarentry == null)
            break MISSING_BLOCK_LABEL_50;
        acertificate1 = jarentry.getCertificates();
        acertificate = acertificate1;
_L2:
        return acertificate;
        IOException ioexception;
        ioexception;
        Slog.w("PackageParser", (new StringBuilder()).append("Exception reading ").append(jarentry.getName()).append(" in ").append(jarfile.getName()).toString(), ioexception);
        continue; /* Loop/switch isn't completed */
        RuntimeException runtimeexception;
        runtimeexception;
        Slog.w("PackageParser", (new StringBuilder()).append("Exception reading ").append(jarentry.getName()).append(" in ").append(jarfile.getName()).toString(), runtimeexception);
        if(true) goto _L2; else goto _L1
_L1:
    }

    private Activity parseActivity(Package package1, Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset, int i, String as[], boolean flag, 
            boolean flag1) throws XmlPullParserException, IOException {
        TypedArray typedarray;
        Activity activity;
        typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.AndroidManifestActivity);
        if(mParseActivityArgs == null)
            mParseActivityArgs = new ParseComponentArgs(package1, as, 3, 1, 2, 23, mSeparateProcesses, 7, 17, 5);
        ParseComponentArgs parsecomponentargs = mParseActivityArgs;
        String s;
        if(flag)
            s = "<receiver>";
        else
            s = "<activity>";
        parsecomponentargs.tag = s;
        mParseActivityArgs.sa = typedarray;
        mParseActivityArgs.flags = i;
        activity = new Activity(mParseActivityArgs, new ActivityInfo());
        if(as[0] == null) goto _L2; else goto _L1
_L1:
        typedarray.recycle();
        activity = null;
_L4:
        return activity;
_L2:
        boolean flag2 = typedarray.hasValue(6);
        if(flag2)
            activity.info.exported = typedarray.getBoolean(6, false);
        activity.info.theme = typedarray.getResourceId(0, 0);
        activity.info.uiOptions = typedarray.getInt(26, activity.info.applicationInfo.uiOptions);
        String s1 = typedarray.getNonConfigurationString(27, 0);
        String s2;
        boolean flag3;
        if(s1 != null) {
            String s5 = buildClassName(activity.info.packageName, s1, as);
            String s4;
            ActivityInfo activityinfo2;
            ActivityInfo activityinfo3;
            ActivityInfo activityinfo4;
            ActivityInfo activityinfo5;
            ActivityInfo activityinfo6;
            ActivityInfo activityinfo7;
            ActivityInfo activityinfo8;
            ActivityInfo activityinfo9;
            ActivityInfo activityinfo10;
            ActivityInfo activityinfo11;
            ActivityInfo activityinfo12;
            if(as[0] == null) {
                activity.info.parentActivityName = s5;
            } else {
                Log.e("PackageParser", (new StringBuilder()).append("Activity ").append(activity.info.name).append(" specified invalid parentActivityName ").append(s1).toString());
                as[0] = null;
            }
        }
        s2 = typedarray.getNonConfigurationString(4, 0);
        if(s2 == null) {
            activity.info.permission = package1.applicationInfo.permission;
        } else {
            ActivityInfo activityinfo = activity.info;
            String s3;
            if(s2.length() > 0)
                s3 = s2.toString().intern();
            else
                s3 = null;
            activityinfo.permission = s3;
        }
        s4 = typedarray.getNonConfigurationString(8, 0);
        activity.info.taskAffinity = buildTaskAffinityName(package1.applicationInfo.packageName, package1.applicationInfo.taskAffinity, s4, as);
        activity.info.flags = 0;
        if(typedarray.getBoolean(9, false)) {
            activityinfo12 = activity.info;
            activityinfo12.flags = 1 | activityinfo12.flags;
        }
        if(typedarray.getBoolean(10, false)) {
            activityinfo11 = activity.info;
            activityinfo11.flags = 2 | activityinfo11.flags;
        }
        if(typedarray.getBoolean(11, false)) {
            activityinfo10 = activity.info;
            activityinfo10.flags = 4 | activityinfo10.flags;
        }
        if(typedarray.getBoolean(21, false)) {
            activityinfo9 = activity.info;
            activityinfo9.flags = 0x80 | activityinfo9.flags;
        }
        if(typedarray.getBoolean(18, false)) {
            activityinfo8 = activity.info;
            activityinfo8.flags = 8 | activityinfo8.flags;
        }
        if(typedarray.getBoolean(12, false)) {
            activityinfo7 = activity.info;
            activityinfo7.flags = 0x10 | activityinfo7.flags;
        }
        if(typedarray.getBoolean(13, false)) {
            activityinfo6 = activity.info;
            activityinfo6.flags = 0x20 | activityinfo6.flags;
        }
        if((0x20 & package1.applicationInfo.flags) != 0)
            flag3 = true;
        else
            flag3 = false;
        if(typedarray.getBoolean(19, flag3)) {
            activityinfo5 = activity.info;
            activityinfo5.flags = 0x40 | activityinfo5.flags;
        }
        if(typedarray.getBoolean(22, false)) {
            activityinfo4 = activity.info;
            activityinfo4.flags = 0x100 | activityinfo4.flags;
        }
        if(typedarray.getBoolean(24, false)) {
            activityinfo3 = activity.info;
            activityinfo3.flags = 0x400 | activityinfo3.flags;
        }
        if(!flag) {
            if(typedarray.getBoolean(25, flag1)) {
                activityinfo2 = activity.info;
                activityinfo2.flags = 0x200 | activityinfo2.flags;
            }
            activity.info.launchMode = typedarray.getInt(14, 0);
            activity.info.screenOrientation = typedarray.getInt(15, -1);
            activity.info.configChanges = typedarray.getInt(16, 0);
            activity.info.softInputMode = typedarray.getInt(20, 0);
        } else {
            activity.info.launchMode = 0;
            activity.info.configChanges = 0;
        }
        typedarray.recycle();
        if(flag && (0x10000000 & package1.applicationInfo.flags) != 0 && activity.info.processName == package1.packageName)
            as[0] = "Heavy-weight applications can not have receivers in main process";
        if(as[0] != null) {
            activity = null;
            continue; /* Loop/switch isn't completed */
        }
        int j = xmlpullparser.getDepth();
        do {
            int k = xmlpullparser.next();
            if(k == 1 || k == 3 && xmlpullparser.getDepth() <= j)
                break;
            if(k == 3 || k == 4)
                continue;
            if(xmlpullparser.getName().equals("intent-filter")) {
                ActivityIntentInfo activityintentinfo = new ActivityIntentInfo(activity);
                boolean flag5;
                if(!flag)
                    flag5 = true;
                else
                    flag5 = false;
                if(!parseIntent(resources, xmlpullparser, attributeset, i, activityintentinfo, as, flag5)) {
                    activity = null;
                } else {
                    if(activityintentinfo.countActions() == 0)
                        Slog.w("PackageParser", (new StringBuilder()).append("No actions in intent filter at ").append(mArchiveSourcePath).append(" ").append(xmlpullparser.getPositionDescription()).toString());
                    else
                        activity.intents.add(activityintentinfo);
                    continue;
                }
                continue; /* Loop/switch isn't completed */
            }
            if(xmlpullparser.getName().equals("meta-data")) {
                Bundle bundle = parseMetaData(resources, xmlpullparser, attributeset, activity.metaData, as);
                activity.metaData = bundle;
                if(bundle != null)
                    continue;
                activity = null;
                continue; /* Loop/switch isn't completed */
            }
            Slog.w("PackageParser", (new StringBuilder()).append("Problem in package ").append(mArchiveSourcePath).append(":").toString());
            if(flag)
                Slog.w("PackageParser", (new StringBuilder()).append("Unknown element under <receiver>: ").append(xmlpullparser.getName()).append(" at ").append(mArchiveSourcePath).append(" ").append(xmlpullparser.getPositionDescription()).toString());
            else
                Slog.w("PackageParser", (new StringBuilder()).append("Unknown element under <activity>: ").append(xmlpullparser.getName()).append(" at ").append(mArchiveSourcePath).append(" ").append(xmlpullparser.getPositionDescription()).toString());
            XmlUtils.skipCurrentTag(xmlpullparser);
        } while(true);
        if(!flag2) {
            ActivityInfo activityinfo1 = activity.info;
            boolean flag4;
            if(activity.intents.size() > 0)
                flag4 = true;
            else
                flag4 = false;
            activityinfo1.exported = flag4;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private Activity parseActivityAlias(Package package1, Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset, int i, String as[]) throws XmlPullParserException, IOException {
        TypedArray typedarray;
        String s;
        typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.AndroidManifestActivityAlias);
        s = typedarray.getNonConfigurationString(7, 0);
        if(s != null) goto _L2; else goto _L1
_L1:
        Activity activity1;
        as[0] = "<activity-alias> does not specify android:targetActivity";
        typedarray.recycle();
        activity1 = null;
_L4:
        return activity1;
_L2:
        String s1 = buildClassName(package1.applicationInfo.packageName, s, as);
        if(s1 == null) {
            typedarray.recycle();
            activity1 = null;
            continue; /* Loop/switch isn't completed */
        }
        if(mParseActivityAliasArgs == null) {
            mParseActivityAliasArgs = new ParseComponentArgs(package1, as, 2, 0, 1, 8, mSeparateProcesses, 0, 6, 4);
            mParseActivityAliasArgs.tag = "<activity-alias>";
        }
        mParseActivityAliasArgs.sa = typedarray;
        mParseActivityAliasArgs.flags = i;
        Activity activity = null;
        int j = package1.activities.size();
        int k = 0;
label0:
        do {
label1:
            {
                if(k < j) {
                    Activity activity2 = (Activity)package1.activities.get(k);
                    if(!s1.equals(activity2.info.name))
                        break label1;
                    activity = activity2;
                }
                if(activity != null)
                    break label0;
                as[0] = (new StringBuilder()).append("<activity-alias> target activity ").append(s1).append(" not found in manifest").toString();
                typedarray.recycle();
                activity1 = null;
                continue; /* Loop/switch isn't completed */
            }
            k++;
        } while(true);
        ActivityInfo activityinfo = new ActivityInfo();
        activityinfo.targetActivity = s1;
        activityinfo.configChanges = activity.info.configChanges;
        activityinfo.flags = activity.info.flags;
        activityinfo.icon = activity.info.icon;
        activityinfo.logo = activity.info.logo;
        activityinfo.labelRes = activity.info.labelRes;
        activityinfo.nonLocalizedLabel = activity.info.nonLocalizedLabel;
        activityinfo.launchMode = activity.info.launchMode;
        activityinfo.processName = activity.info.processName;
        if(activityinfo.descriptionRes == 0)
            activityinfo.descriptionRes = activity.info.descriptionRes;
        activityinfo.screenOrientation = activity.info.screenOrientation;
        activityinfo.taskAffinity = activity.info.taskAffinity;
        activityinfo.theme = activity.info.theme;
        activityinfo.softInputMode = activity.info.softInputMode;
        activityinfo.uiOptions = activity.info.uiOptions;
        activityinfo.parentActivityName = activity.info.parentActivityName;
        activity1 = new Activity(mParseActivityAliasArgs, activityinfo);
        if(as[0] != null) {
            typedarray.recycle();
            activity1 = null;
            continue; /* Loop/switch isn't completed */
        }
        boolean flag = typedarray.hasValue(5);
        if(flag)
            activity1.info.exported = typedarray.getBoolean(5, false);
        String s2 = typedarray.getNonConfigurationString(3, 0);
        String s3;
        if(s2 != null) {
            ActivityInfo activityinfo2 = activity1.info;
            String s4;
            String s5;
            if(s2.length() > 0)
                s5 = s2.toString().intern();
            else
                s5 = null;
            activityinfo2.permission = s5;
        }
        s3 = typedarray.getNonConfigurationString(9, 0);
        if(s3 != null) {
            s4 = buildClassName(activity1.info.packageName, s3, as);
            if(as[0] == null) {
                activity1.info.parentActivityName = s4;
            } else {
                Log.e("PackageParser", (new StringBuilder()).append("Activity alias ").append(activity1.info.name).append(" specified invalid parentActivityName ").append(s3).toString());
                as[0] = null;
            }
        }
        typedarray.recycle();
        if(as[0] != null) {
            activity1 = null;
            continue; /* Loop/switch isn't completed */
        }
        int l = xmlpullparser.getDepth();
        do {
            int i1 = xmlpullparser.next();
            if(i1 == 1 || i1 == 3 && xmlpullparser.getDepth() <= l)
                break;
            if(i1 == 3 || i1 == 4)
                continue;
            if(xmlpullparser.getName().equals("intent-filter")) {
                ActivityIntentInfo activityintentinfo = new ActivityIntentInfo(activity1);
                if(!parseIntent(resources, xmlpullparser, attributeset, i, activityintentinfo, as, true)) {
                    activity1 = null;
                } else {
                    if(activityintentinfo.countActions() == 0)
                        Slog.w("PackageParser", (new StringBuilder()).append("No actions in intent filter at ").append(mArchiveSourcePath).append(" ").append(xmlpullparser.getPositionDescription()).toString());
                    else
                        activity1.intents.add(activityintentinfo);
                    continue;
                }
                continue; /* Loop/switch isn't completed */
            }
            if(xmlpullparser.getName().equals("meta-data")) {
                Bundle bundle = parseMetaData(resources, xmlpullparser, attributeset, activity1.metaData, as);
                activity1.metaData = bundle;
                if(bundle != null)
                    continue;
                activity1 = null;
                continue; /* Loop/switch isn't completed */
            }
            Slog.w("PackageParser", (new StringBuilder()).append("Unknown element under <activity-alias>: ").append(xmlpullparser.getName()).append(" at ").append(mArchiveSourcePath).append(" ").append(xmlpullparser.getPositionDescription()).toString());
            XmlUtils.skipCurrentTag(xmlpullparser);
        } while(true);
        if(!flag) {
            ActivityInfo activityinfo1 = activity1.info;
            boolean flag1;
            if(activity1.intents.size() > 0)
                flag1 = true;
            else
                flag1 = false;
            activityinfo1.exported = flag1;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private boolean parseAllMetaData(Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset, String s, Component component, String as[]) throws XmlPullParserException, IOException {
        int i = xmlpullparser.getDepth();
_L4:
        int j;
        do {
            j = xmlpullparser.next();
            if(j == 1 || j == 3 && xmlpullparser.getDepth() <= i)
                break MISSING_BLOCK_LABEL_176;
        } while(j == 3 || j == 4);
        if(!xmlpullparser.getName().equals("meta-data")) goto _L2; else goto _L1
_L1:
        Bundle bundle;
        bundle = parseMetaData(resources, xmlpullparser, attributeset, component.metaData, as);
        component.metaData = bundle;
        if(bundle != null) goto _L4; else goto _L3
_L3:
        boolean flag = false;
_L5:
        return flag;
_L2:
        Slog.w("PackageParser", (new StringBuilder()).append("Unknown element under ").append(s).append(": ").append(xmlpullparser.getName()).append(" at ").append(mArchiveSourcePath).append(" ").append(xmlpullparser.getPositionDescription()).toString());
        XmlUtils.skipCurrentTag(xmlpullparser);
          goto _L4
        flag = true;
          goto _L5
    }

    private boolean parseApplication(Package package1, Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset, int i, String as[]) throws XmlPullParserException, IOException {
        ApplicationInfo applicationinfo;
        String s;
        TypedArray typedarray;
        String s1;
        applicationinfo = package1.applicationInfo;
        s = package1.applicationInfo.packageName;
        typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.AndroidManifestApplication);
        s1 = typedarray.getNonConfigurationString(3, 0);
        if(s1 == null) goto _L2; else goto _L1
_L1:
        applicationinfo.className = buildClassName(s, s1, as);
        if(applicationinfo.className != null) goto _L2; else goto _L3
_L3:
        boolean flag2;
        typedarray.recycle();
        mParseError = -108;
        flag2 = false;
_L13:
        return flag2;
_L2:
        boolean flag1;
        int j;
        String s2 = typedarray.getNonConfigurationString(4, 0);
        if(s2 != null)
            applicationinfo.manageSpaceActivityName = buildClassName(s, s2, as);
        if(typedarray.getBoolean(17, true)) {
            applicationinfo.flags = 0x8000 | applicationinfo.flags;
            String s9 = typedarray.getNonConfigurationString(16, 0);
            if(s9 != null) {
                applicationinfo.backupAgentName = buildClassName(s, s9, as);
                if(typedarray.getBoolean(18, true))
                    applicationinfo.flags = 0x10000 | applicationinfo.flags;
                if(typedarray.getBoolean(21, false))
                    applicationinfo.flags = 0x20000 | applicationinfo.flags;
            }
        }
        TypedValue typedvalue = typedarray.peekValue(1);
        if(typedvalue != null) {
            int l = typedvalue.resourceId;
            applicationinfo.labelRes = l;
            if(l == 0)
                applicationinfo.nonLocalizedLabel = typedvalue.coerceToString();
        }
        applicationinfo.icon = typedarray.getResourceId(2, 0);
        applicationinfo.logo = typedarray.getResourceId(22, 0);
        applicationinfo.theme = typedarray.getResourceId(0, 0);
        applicationinfo.descriptionRes = typedarray.getResourceId(13, 0);
        if((i & 1) != 0 && typedarray.getBoolean(8, false))
            applicationinfo.flags = 8 | applicationinfo.flags;
        if(typedarray.getBoolean(10, false))
            applicationinfo.flags = 2 | applicationinfo.flags;
        if(typedarray.getBoolean(20, false))
            applicationinfo.flags = 0x4000 | applicationinfo.flags;
        boolean flag;
        String s3;
        String s4;
        String s5;
        if(package1.applicationInfo.targetSdkVersion >= 14)
            flag = true;
        else
            flag = false;
        flag1 = typedarray.getBoolean(23, flag);
        if(typedarray.getBoolean(7, true))
            applicationinfo.flags = 4 | applicationinfo.flags;
        if(typedarray.getBoolean(14, false))
            applicationinfo.flags = 0x20 | applicationinfo.flags;
        if(typedarray.getBoolean(5, true))
            applicationinfo.flags = 0x40 | applicationinfo.flags;
        if(typedarray.getBoolean(15, false))
            applicationinfo.flags = 0x100 | applicationinfo.flags;
        if(typedarray.getBoolean(24, false))
            applicationinfo.flags = 0x100000 | applicationinfo.flags;
        if(typedarray.getBoolean(28, false))
            applicationinfo.flags = 0x400000 | applicationinfo.flags;
        s3 = typedarray.getNonConfigurationString(6, 0);
        if(s3 != null && s3.length() > 0)
            s4 = s3.intern();
        else
            s4 = null;
        applicationinfo.permission = s4;
        if(package1.applicationInfo.targetSdkVersion >= 8)
            s5 = typedarray.getNonConfigurationString(12, 0);
        else
            s5 = typedarray.getNonResourceString(12);
        applicationinfo.taskAffinity = buildTaskAffinityName(applicationinfo.packageName, applicationinfo.packageName, s5, as);
        if(as[0] == null) {
            String s8;
            if(package1.applicationInfo.targetSdkVersion >= 8)
                s8 = typedarray.getNonConfigurationString(11, 0);
            else
                s8 = typedarray.getNonResourceString(11);
            applicationinfo.processName = buildProcessName(applicationinfo.packageName, null, s8, i, mSeparateProcesses, as);
            applicationinfo.enabled = typedarray.getBoolean(9, true);
        }
        applicationinfo.uiOptions = typedarray.getInt(25, 0);
        typedarray.recycle();
        if(as[0] != null) {
            mParseError = -108;
            flag2 = false;
            continue; /* Loop/switch isn't completed */
        }
        j = xmlpullparser.getDepth();
_L11:
        String s6;
        int k = xmlpullparser.next();
        if(k == 1 || k == 3 && xmlpullparser.getDepth() <= j)
            break; /* Loop/switch isn't completed */
        if(k == 3 || k == 4)
            continue; /* Loop/switch isn't completed */
        s6 = xmlpullparser.getName();
        if(s6.equals("activity")) {
            Activity activity2 = parseActivity(package1, resources, xmlpullparser, attributeset, i, as, false, flag1);
            if(activity2 == null) {
                mParseError = -108;
                flag2 = false;
            } else {
                package1.activities.add(activity2);
                continue; /* Loop/switch isn't completed */
            }
            continue; /* Loop/switch isn't completed */
        }
        if(s6.equals("receiver")) {
            Activity activity1 = parseActivity(package1, resources, xmlpullparser, attributeset, i, as, true, false);
            if(activity1 == null) {
                mParseError = -108;
                flag2 = false;
            } else {
                package1.receivers.add(activity1);
                continue; /* Loop/switch isn't completed */
            }
            continue; /* Loop/switch isn't completed */
        }
        if(s6.equals("service")) {
            Service service = parseService(package1, resources, xmlpullparser, attributeset, i, as);
            if(service == null) {
                mParseError = -108;
                flag2 = false;
            } else {
                package1.services.add(service);
                continue; /* Loop/switch isn't completed */
            }
            continue; /* Loop/switch isn't completed */
        }
        if(s6.equals("provider")) {
            Provider provider = parseProvider(package1, resources, xmlpullparser, attributeset, i, as);
            if(provider == null) {
                mParseError = -108;
                flag2 = false;
            } else {
                package1.providers.add(provider);
                continue; /* Loop/switch isn't completed */
            }
            continue; /* Loop/switch isn't completed */
        }
        if(s6.equals("activity-alias")) {
            Activity activity = parseActivityAlias(package1, resources, xmlpullparser, attributeset, i, as);
            if(activity == null) {
                mParseError = -108;
                flag2 = false;
            } else {
                package1.activities.add(activity);
                continue; /* Loop/switch isn't completed */
            }
            continue; /* Loop/switch isn't completed */
        }
        if(xmlpullparser.getName().equals("meta-data")) {
            Bundle bundle = parseMetaData(resources, xmlpullparser, attributeset, package1.mAppMetaData, as);
            package1.mAppMetaData = bundle;
            if(bundle != null)
                continue; /* Loop/switch isn't completed */
            mParseError = -108;
            flag2 = false;
            continue; /* Loop/switch isn't completed */
        }
        if(!s6.equals("uses-library")) goto _L5; else goto _L4
_L4:
        String s7;
        boolean flag3;
        TypedArray typedarray1 = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.AndroidManifestUsesLibrary);
        s7 = typedarray1.getNonResourceString(0);
        flag3 = typedarray1.getBoolean(1, true);
        typedarray1.recycle();
        if(s7 == null) goto _L7; else goto _L6
_L6:
        if(!flag3) goto _L9; else goto _L8
_L8:
        if(package1.usesLibraries == null)
            package1.usesLibraries = new ArrayList();
        if(!package1.usesLibraries.contains(s7))
            package1.usesLibraries.add(s7.intern());
_L7:
        XmlUtils.skipCurrentTag(xmlpullparser);
        continue; /* Loop/switch isn't completed */
_L9:
        if(package1.usesOptionalLibraries == null)
            package1.usesOptionalLibraries = new ArrayList();
        if(!package1.usesOptionalLibraries.contains(s7))
            package1.usesOptionalLibraries.add(s7.intern());
        if(true) goto _L7; else goto _L5
_L5:
        if(s6.equals("uses-package")) {
            XmlUtils.skipCurrentTag(xmlpullparser);
        } else {
            Slog.w("PackageParser", (new StringBuilder()).append("Unknown element under <application>: ").append(s6).append(" at ").append(mArchiveSourcePath).append(" ").append(xmlpullparser.getPositionDescription()).toString());
            XmlUtils.skipCurrentTag(xmlpullparser);
        }
        if(true) goto _L11; else goto _L10
_L10:
        flag2 = true;
        if(true) goto _L13; else goto _L12
_L12:
    }

    private Instrumentation parseInstrumentation(Package package1, Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset, String as[]) throws XmlPullParserException, IOException {
        TypedArray typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.AndroidManifestInstrumentation);
        if(mParseInstrumentationArgs == null) {
            mParseInstrumentationArgs = new ParsePackageItemArgs(package1, as, 2, 0, 1, 6);
            mParseInstrumentationArgs.tag = "<instrumentation>";
        }
        mParseInstrumentationArgs.sa = typedarray;
        Instrumentation instrumentation = new Instrumentation(mParseInstrumentationArgs, new InstrumentationInfo());
        if(as[0] != null) {
            typedarray.recycle();
            mParseError = -108;
            instrumentation = null;
        } else {
            String s = typedarray.getNonResourceString(3);
            InstrumentationInfo instrumentationinfo = instrumentation.info;
            String s1;
            if(s != null)
                s1 = s.intern();
            else
                s1 = null;
            instrumentationinfo.targetPackage = s1;
            instrumentation.info.handleProfiling = typedarray.getBoolean(4, false);
            instrumentation.info.functionalTest = typedarray.getBoolean(5, false);
            typedarray.recycle();
            if(instrumentation.info.targetPackage == null) {
                as[0] = "<instrumentation> does not specify targetPackage";
                mParseError = -108;
                instrumentation = null;
            } else
            if(!parseAllMetaData(resources, xmlpullparser, attributeset, "<instrumentation>", instrumentation, as)) {
                mParseError = -108;
                instrumentation = null;
            } else {
                package1.instrumentation.add(instrumentation);
            }
        }
        return instrumentation;
    }

    private boolean parseIntent(Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset, int i, IntentInfo intentinfo, String as[], boolean flag) throws XmlPullParserException, IOException {
        int j;
        TypedArray typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.AndroidManifestIntentFilter);
        intentinfo.setPriority(Injector.checkPriority(i, typedarray.getInt(2, 0)));
        TypedValue typedvalue = typedarray.peekValue(0);
        if(typedvalue != null) {
            int l = typedvalue.resourceId;
            intentinfo.labelRes = l;
            if(l == 0)
                intentinfo.nonLocalizedLabel = typedvalue.coerceToString();
        }
        intentinfo.icon = typedarray.getResourceId(1, 0);
        intentinfo.logo = typedarray.getResourceId(3, 0);
        typedarray.recycle();
        j = xmlpullparser.getDepth();
_L5:
        String s;
        int k;
        do {
            k = xmlpullparser.next();
            if(k == 1 || k == 3 && xmlpullparser.getDepth() <= j)
                break MISSING_BLOCK_LABEL_547;
        } while(k == 3 || k == 4);
        s = xmlpullparser.getName();
        if(!s.equals("action")) goto _L2; else goto _L1
_L1:
        String s9 = attributeset.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
        if(s9 != null && s9 != "") goto _L4; else goto _L3
_L3:
        boolean flag1;
        as[0] = "No value supplied for <android:name>";
        flag1 = false;
_L6:
        return flag1;
_L4:
        XmlUtils.skipCurrentTag(xmlpullparser);
        intentinfo.addAction(s9);
          goto _L5
_L2:
        String s8;
label0:
        {
            if(!s.equals("category"))
                break MISSING_BLOCK_LABEL_285;
            s8 = attributeset.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
            if(s8 != null && s8 != "")
                break label0;
            as[0] = "No value supplied for <android:name>";
            flag1 = false;
        }
          goto _L6
        XmlUtils.skipCurrentTag(xmlpullparser);
        intentinfo.addCategory(s8);
          goto _L5
        TypedArray typedarray1;
        String s1;
        if(!s.equals("data"))
            break MISSING_BLOCK_LABEL_481;
        typedarray1 = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.AndroidManifestData);
        s1 = typedarray1.getNonConfigurationString(0, 0);
        if(s1 == null)
            break MISSING_BLOCK_LABEL_327;
        intentinfo.addDataType(s1);
        String s2 = typedarray1.getNonConfigurationString(1, 0);
        if(s2 != null)
            intentinfo.addDataScheme(s2);
        String s3 = typedarray1.getNonConfigurationString(2, 0);
        String s4 = typedarray1.getNonConfigurationString(3, 0);
        if(s3 != null)
            intentinfo.addDataAuthority(s3, s4);
        String s5 = typedarray1.getNonConfigurationString(4, 0);
        if(s5 != null)
            intentinfo.addDataPath(s5, 0);
        String s6 = typedarray1.getNonConfigurationString(5, 0);
        if(s6 != null)
            intentinfo.addDataPath(s6, 1);
        String s7 = typedarray1.getNonConfigurationString(6, 0);
        if(s7 != null)
            intentinfo.addDataPath(s7, 2);
        typedarray1.recycle();
        XmlUtils.skipCurrentTag(xmlpullparser);
          goto _L5
        android.content.IntentFilter.MalformedMimeTypeException malformedmimetypeexception;
        malformedmimetypeexception;
        as[0] = malformedmimetypeexception.toString();
        typedarray1.recycle();
        flag1 = false;
          goto _L6
        Slog.w("PackageParser", (new StringBuilder()).append("Unknown element under <intent-filter>: ").append(xmlpullparser.getName()).append(" at ").append(mArchiveSourcePath).append(" ").append(xmlpullparser.getPositionDescription()).toString());
        XmlUtils.skipCurrentTag(xmlpullparser);
          goto _L5
        intentinfo.hasDefault = intentinfo.hasCategory("android.intent.category.DEFAULT");
        flag1 = true;
          goto _L6
    }

    private Bundle parseMetaData(Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset, Bundle bundle, String as[]) throws XmlPullParserException, IOException {
        Object obj;
        TypedArray typedarray;
        String s;
        obj = null;
        typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.AndroidManifestMetaData);
        if(bundle == null)
            bundle = new Bundle();
        s = typedarray.getNonConfigurationString(0, 0);
        if(s != null) goto _L2; else goto _L1
_L1:
        as[0] = "<meta-data> requires an android:name attribute";
        typedarray.recycle();
_L4:
        return ((Bundle) (obj));
_L2:
        String s1;
        s1 = s.intern();
        TypedValue typedvalue = typedarray.peekValue(2);
        if(typedvalue == null || typedvalue.resourceId == 0)
            break; /* Loop/switch isn't completed */
        bundle.putInt(s1, typedvalue.resourceId);
_L5:
        typedarray.recycle();
        XmlUtils.skipCurrentTag(xmlpullparser);
        obj = bundle;
        if(true) goto _L4; else goto _L3
_L3:
        TypedValue typedvalue1 = typedarray.peekValue(1);
        if(typedvalue1 != null) {
            if(typedvalue1.type == 3) {
                CharSequence charsequence = typedvalue1.coerceToString();
                if(charsequence != null)
                    obj = charsequence.toString().intern();
                bundle.putString(s1, ((String) (obj)));
            } else
            if(typedvalue1.type == 18) {
                boolean flag;
                if(typedvalue1.data != 0)
                    flag = true;
                else
                    flag = false;
                bundle.putBoolean(s1, flag);
            } else
            if(typedvalue1.type >= 16 && typedvalue1.type <= 31)
                bundle.putInt(s1, typedvalue1.data);
            else
            if(typedvalue1.type == 4)
                bundle.putFloat(s1, typedvalue1.getFloat());
            else
                Slog.w("PackageParser", (new StringBuilder()).append("<meta-data> only supports string, integer, float, color, boolean, and resource reference types: ").append(xmlpullparser.getName()).append(" at ").append(mArchiveSourcePath).append(" ").append(xmlpullparser.getPositionDescription()).toString());
        } else {
            as[0] = "<meta-data> requires an android:value or android:resource attribute";
            bundle = null;
        }
          goto _L5
        if(true) goto _L4; else goto _L6
_L6:
    }

    private Package parsePackage(Resources resources, XmlResourceParser xmlresourceparser, int i, String as[]) throws XmlPullParserException, IOException {
        String s;
        mParseInstrumentationArgs = null;
        mParseActivityArgs = null;
        mParseServiceArgs = null;
        mParseProviderArgs = null;
        s = parsePackageName(xmlresourceparser, xmlresourceparser, i, as);
        if(s != null) goto _L2; else goto _L1
_L1:
        Package package1;
        mParseError = -106;
        package1 = null;
_L21:
        return package1;
_L2:
        boolean flag;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        if(mOnlyCoreApps && !xmlresourceparser.getAttributeBooleanValue(null, "coreApp", false)) {
            mParseError = 1;
            package1 = null;
            continue; /* Loop/switch isn't completed */
        }
        package1 = new Package(s);
        flag = false;
        TypedArray typedarray = resources.obtainAttributes(xmlresourceparser, com.android.internal.R.styleable.AndroidManifest);
        package1.mVersionCode = typedarray.getInteger(1, 0);
        package1.mVersionName = typedarray.getNonConfigurationString(2, 0);
        if(package1.mVersionName != null)
            package1.mVersionName = package1.mVersionName.intern();
        String s1 = typedarray.getNonConfigurationString(0, 0);
        if(s1 != null && s1.length() > 0) {
            String s14 = Injector.filterNameError(s, validateName(s1, true));
            if(s14 != null && !"android".equals(s)) {
                as[0] = (new StringBuilder()).append("<manifest> specifies bad sharedUserId name \"").append(s1).append("\": ").append(s14).toString();
                mParseError = -107;
                package1 = null;
                continue; /* Loop/switch isn't completed */
            }
            package1.mSharedUserId = s1.intern();
            package1.mSharedUserLabel = typedarray.getResourceId(3, 0);
        }
        typedarray.recycle();
        package1.installLocation = typedarray.getInteger(4, -1);
        package1.applicationInfo.installLocation = package1.installLocation;
        if((i & 0x10) != 0) {
            ApplicationInfo applicationinfo7 = package1.applicationInfo;
            applicationinfo7.flags = 0x20000000 | applicationinfo7.flags;
        }
        if((i & 0x20) != 0) {
            ApplicationInfo applicationinfo6 = package1.applicationInfo;
            applicationinfo6.flags = 0x40000 | applicationinfo6.flags;
        }
        j = 1;
        k = 1;
        l = 1;
        i1 = 1;
        j1 = 1;
        k1 = 1;
        l1 = xmlresourceparser.getDepth();
_L10:
        String s5;
        int i2 = xmlresourceparser.next();
        if(i2 == 1 || i2 == 3 && xmlresourceparser.getDepth() <= l1)
            break; /* Loop/switch isn't completed */
        if(i2 == 3 || i2 == 4)
            continue; /* Loop/switch isn't completed */
        s5 = xmlresourceparser.getName();
        if(s5.equals("application")) {
            if(flag) {
                Slog.w("PackageParser", "<manifest> has more than one <application>");
                XmlUtils.skipCurrentTag(xmlresourceparser);
                continue; /* Loop/switch isn't completed */
            }
            flag = true;
            if(parseApplication(package1, resources, xmlresourceparser, xmlresourceparser, i, as))
                continue; /* Loop/switch isn't completed */
            package1 = null;
            continue; /* Loop/switch isn't completed */
        }
        if(s5.equals("permission-group")) {
            if(parsePermissionGroup(package1, i, resources, xmlresourceparser, xmlresourceparser, as) != null)
                continue; /* Loop/switch isn't completed */
            package1 = null;
            continue; /* Loop/switch isn't completed */
        }
        if(s5.equals("permission")) {
            if(parsePermission(package1, resources, xmlresourceparser, xmlresourceparser, as) != null)
                continue; /* Loop/switch isn't completed */
            package1 = null;
            continue; /* Loop/switch isn't completed */
        }
        if(s5.equals("permission-tree")) {
            if(parsePermissionTree(package1, resources, xmlresourceparser, xmlresourceparser, as) != null)
                continue; /* Loop/switch isn't completed */
            package1 = null;
            continue; /* Loop/switch isn't completed */
        }
        if(s5.equals("uses-permission")) {
            TypedArray typedarray8 = resources.obtainAttributes(xmlresourceparser, com.android.internal.R.styleable.AndroidManifestUsesPermission);
            String s13 = typedarray8.getNonResourceString(0);
            typedarray8.recycle();
            if(s13 != null && !package1.requestedPermissions.contains(s13)) {
                package1.requestedPermissions.add(s13.intern());
                package1.requestedPermissionsRequired.add(Boolean.TRUE);
            }
            XmlUtils.skipCurrentTag(xmlresourceparser);
            continue; /* Loop/switch isn't completed */
        }
        if(s5.equals("uses-configuration")) {
            ConfigurationInfo configurationinfo = new ConfigurationInfo();
            TypedArray typedarray1 = resources.obtainAttributes(xmlresourceparser, com.android.internal.R.styleable.AndroidManifestUsesConfiguration);
            configurationinfo.reqTouchScreen = typedarray1.getInt(0, 0);
            configurationinfo.reqKeyboardType = typedarray1.getInt(1, 0);
            if(typedarray1.getBoolean(2, false))
                configurationinfo.reqInputFeatures = 1 | configurationinfo.reqInputFeatures;
            configurationinfo.reqNavigation = typedarray1.getInt(3, 0);
            if(typedarray1.getBoolean(4, false))
                configurationinfo.reqInputFeatures = 2 | configurationinfo.reqInputFeatures;
            typedarray1.recycle();
            package1.configPreferences.add(configurationinfo);
            XmlUtils.skipCurrentTag(xmlresourceparser);
            continue; /* Loop/switch isn't completed */
        }
        if(s5.equals("uses-feature")) {
            FeatureInfo featureinfo = new FeatureInfo();
            TypedArray typedarray2 = resources.obtainAttributes(xmlresourceparser, com.android.internal.R.styleable.AndroidManifestUsesFeature);
            featureinfo.name = typedarray2.getNonResourceString(0);
            if(featureinfo.name == null)
                featureinfo.reqGlEsVersion = typedarray2.getInt(1, 0);
            if(typedarray2.getBoolean(2, true))
                featureinfo.flags = 1 | featureinfo.flags;
            typedarray2.recycle();
            if(package1.reqFeatures == null)
                package1.reqFeatures = new ArrayList();
            package1.reqFeatures.add(featureinfo);
            if(featureinfo.name == null) {
                ConfigurationInfo configurationinfo1 = new ConfigurationInfo();
                configurationinfo1.reqGlEsVersion = featureinfo.reqGlEsVersion;
                package1.configPreferences.add(configurationinfo1);
            }
            XmlUtils.skipCurrentTag(xmlresourceparser);
            continue; /* Loop/switch isn't completed */
        }
        if(!s5.equals("uses-sdk")) goto _L4; else goto _L3
_L3:
        if(SDK_VERSION <= 0) goto _L6; else goto _L5
_L5:
        int i4;
        String s10;
        TypedArray typedarray7 = resources.obtainAttributes(xmlresourceparser, com.android.internal.R.styleable.AndroidManifestUsesSdk);
        int l3 = 0;
        String s9 = null;
        i4 = 0;
        s10 = null;
        TypedValue typedvalue = typedarray7.peekValue(0);
        TypedValue typedvalue1;
        if(typedvalue != null)
            if(typedvalue.type == 3 && typedvalue.string != null) {
                s9 = typedvalue.string.toString();
                s10 = s9;
            } else {
                l3 = typedvalue.data;
                i4 = l3;
            }
        typedvalue1 = typedarray7.peekValue(1);
        if(typedvalue1 != null)
            if(typedvalue1.type == 3 && typedvalue1.string != null) {
                s9 = typedvalue1.string.toString();
                s10 = s9;
            } else {
                i4 = typedvalue1.data;
            }
        typedarray7.recycle();
        if(s9 != null) {
            String s12 = SDK_CODENAME;
            if(!s9.equals(s12)) {
                if(SDK_CODENAME != null)
                    as[0] = (new StringBuilder()).append("Requires development platform ").append(s9).append(" (current platform is ").append(SDK_CODENAME).append(")").toString();
                else
                    as[0] = (new StringBuilder()).append("Requires development platform ").append(s9).append(" but this is a release platform.").toString();
                mParseError = -12;
                package1 = null;
                continue; /* Loop/switch isn't completed */
            }
        } else {
            int j4 = SDK_VERSION;
            if(l3 > j4) {
                as[0] = (new StringBuilder()).append("Requires newer sdk version #").append(l3).append(" (current version is #").append(SDK_VERSION).append(")").toString();
                mParseError = -12;
                package1 = null;
                continue; /* Loop/switch isn't completed */
            }
        }
        if(s10 == null) goto _L8; else goto _L7
_L7:
        String s11 = SDK_CODENAME;
        if(!s10.equals(s11)) {
            if(SDK_CODENAME != null)
                as[0] = (new StringBuilder()).append("Requires development platform ").append(s10).append(" (current platform is ").append(SDK_CODENAME).append(")").toString();
            else
                as[0] = (new StringBuilder()).append("Requires development platform ").append(s10).append(" but this is a release platform.").toString();
            mParseError = -12;
            package1 = null;
            continue; /* Loop/switch isn't completed */
        }
        package1.applicationInfo.targetSdkVersion = 10000;
_L6:
        XmlUtils.skipCurrentTag(xmlresourceparser);
        continue; /* Loop/switch isn't completed */
_L8:
        package1.applicationInfo.targetSdkVersion = i4;
        if(true) goto _L6; else goto _L4
_L4:
        if(s5.equals("supports-screens")) {
            TypedArray typedarray6 = resources.obtainAttributes(xmlresourceparser, com.android.internal.R.styleable.AndroidManifestSupportsScreens);
            package1.applicationInfo.requiresSmallestWidthDp = typedarray6.getInteger(6, 0);
            package1.applicationInfo.compatibleWidthLimitDp = typedarray6.getInteger(7, 0);
            package1.applicationInfo.largestWidthLimitDp = typedarray6.getInteger(8, 0);
            j = typedarray6.getInteger(1, j);
            k = typedarray6.getInteger(2, k);
            l = typedarray6.getInteger(3, l);
            i1 = typedarray6.getInteger(5, i1);
            j1 = typedarray6.getInteger(4, j1);
            k1 = typedarray6.getInteger(0, k1);
            typedarray6.recycle();
            XmlUtils.skipCurrentTag(xmlresourceparser);
            continue; /* Loop/switch isn't completed */
        }
        if(s5.equals("protected-broadcast")) {
            TypedArray typedarray5 = resources.obtainAttributes(xmlresourceparser, com.android.internal.R.styleable.AndroidManifestProtectedBroadcast);
            String s8 = typedarray5.getNonResourceString(0);
            typedarray5.recycle();
            if(s8 != null && (i & 1) != 0) {
                if(package1.protectedBroadcasts == null)
                    package1.protectedBroadcasts = new ArrayList();
                if(!package1.protectedBroadcasts.contains(s8))
                    package1.protectedBroadcasts.add(s8.intern());
            }
            XmlUtils.skipCurrentTag(xmlresourceparser);
            continue; /* Loop/switch isn't completed */
        }
        if(s5.equals("instrumentation")) {
            if(parseInstrumentation(package1, resources, xmlresourceparser, xmlresourceparser, as) != null)
                continue; /* Loop/switch isn't completed */
            package1 = null;
            continue; /* Loop/switch isn't completed */
        }
        if(s5.equals("original-package")) {
            TypedArray typedarray4 = resources.obtainAttributes(xmlresourceparser, com.android.internal.R.styleable.AndroidManifestOriginalPackage);
            String s7 = typedarray4.getNonConfigurationString(0, 0);
            if(!package1.packageName.equals(s7)) {
                if(package1.mOriginalPackages == null) {
                    package1.mOriginalPackages = new ArrayList();
                    package1.mRealPackage = package1.packageName;
                }
                package1.mOriginalPackages.add(s7);
            }
            typedarray4.recycle();
            XmlUtils.skipCurrentTag(xmlresourceparser);
        } else
        if(s5.equals("adopt-permissions")) {
            TypedArray typedarray3 = resources.obtainAttributes(xmlresourceparser, com.android.internal.R.styleable.AndroidManifestOriginalPackage);
            String s6 = typedarray3.getNonConfigurationString(0, 0);
            typedarray3.recycle();
            if(s6 != null) {
                if(package1.mAdoptPermissions == null)
                    package1.mAdoptPermissions = new ArrayList();
                package1.mAdoptPermissions.add(s6);
            }
            XmlUtils.skipCurrentTag(xmlresourceparser);
        } else
        if(s5.equals("uses-gl-texture"))
            XmlUtils.skipCurrentTag(xmlresourceparser);
        else
        if(s5.equals("compatible-screens"))
            XmlUtils.skipCurrentTag(xmlresourceparser);
        else
        if(s5.equals("eat-comment")) {
            XmlUtils.skipCurrentTag(xmlresourceparser);
        } else {
            Slog.w("PackageParser", (new StringBuilder()).append("Unknown element under <manifest>: ").append(xmlresourceparser.getName()).append(" at ").append(mArchiveSourcePath).append(" ").append(xmlresourceparser.getPositionDescription()).toString());
            XmlUtils.skipCurrentTag(xmlresourceparser);
        }
        if(true) goto _L10; else goto _L9
_L9:
        int j2;
        StringBuilder stringbuilder;
        int k2;
        if(!flag && package1.instrumentation.size() == 0) {
            as[0] = "<manifest> does not contain an <application> or <instrumentation>";
            mParseError = -109;
        }
        j2 = NEW_PERMISSIONS.length;
        stringbuilder = null;
        k2 = 0;
_L16:
        if(k2 >= j2) goto _L12; else goto _L11
_L11:
        NewPermissionInfo newpermissioninfo = NEW_PERMISSIONS[k2];
        if(package1.applicationInfo.targetSdkVersion < newpermissioninfo.sdkVersion) goto _L13; else goto _L12
_L12:
        int l2;
        int i3;
        if(stringbuilder != null)
            Slog.i("PackageParser", stringbuilder.toString());
        l2 = SPLIT_PERMISSIONS.length;
        i3 = 0;
_L15:
        SplitPermissionInfo splitpermissioninfo;
        if(i3 >= l2)
            break MISSING_BLOCK_LABEL_2349;
        splitpermissioninfo = SPLIT_PERMISSIONS[i3];
        if(package1.applicationInfo.targetSdkVersion < splitpermissioninfo.targetSdk && package1.requestedPermissions.contains(splitpermissioninfo.rootPerm))
            break; /* Loop/switch isn't completed */
_L18:
        i3++;
        if(true) goto _L15; else goto _L14
_L13:
        if(!package1.requestedPermissions.contains(newpermissioninfo.name)) {
            String s4;
            if(stringbuilder == null) {
                stringbuilder = new StringBuilder(128);
                String s3 = package1.packageName;
                stringbuilder.append(s3);
                stringbuilder.append(": compat added ");
            } else {
                stringbuilder.append(' ');
            }
            s4 = newpermissioninfo.name;
            stringbuilder.append(s4);
            package1.requestedPermissions.add(newpermissioninfo.name);
            package1.requestedPermissionsRequired.add(Boolean.TRUE);
        }
        k2++;
          goto _L16
_L14:
        int j3 = 0;
_L19:
        int k3 = splitpermissioninfo.newPerms.length;
        if(j3 >= k3) goto _L18; else goto _L17
_L17:
        String s2 = splitpermissioninfo.newPerms[j3];
        if(!package1.requestedPermissions.contains(s2)) {
            package1.requestedPermissions.add(s2);
            package1.requestedPermissionsRequired.add(Boolean.TRUE);
        }
        j3++;
          goto _L19
          goto _L18
        if(j < 0 || j > 0 && package1.applicationInfo.targetSdkVersion >= 4) {
            ApplicationInfo applicationinfo = package1.applicationInfo;
            applicationinfo.flags = 0x200 | applicationinfo.flags;
        }
        if(k != 0) {
            ApplicationInfo applicationinfo5 = package1.applicationInfo;
            applicationinfo5.flags = 0x400 | applicationinfo5.flags;
        }
        if(l < 0 || l > 0 && package1.applicationInfo.targetSdkVersion >= 4) {
            ApplicationInfo applicationinfo1 = package1.applicationInfo;
            applicationinfo1.flags = 0x800 | applicationinfo1.flags;
        }
        if(i1 < 0 || i1 > 0 && package1.applicationInfo.targetSdkVersion >= 9) {
            ApplicationInfo applicationinfo2 = package1.applicationInfo;
            applicationinfo2.flags = 0x80000 | applicationinfo2.flags;
        }
        if(j1 < 0 || j1 > 0 && package1.applicationInfo.targetSdkVersion >= 4) {
            ApplicationInfo applicationinfo3 = package1.applicationInfo;
            applicationinfo3.flags = 0x1000 | applicationinfo3.flags;
        }
        if(k1 < 0 || k1 > 0 && package1.applicationInfo.targetSdkVersion >= 4) {
            ApplicationInfo applicationinfo4 = package1.applicationInfo;
            applicationinfo4.flags = 0x2000 | applicationinfo4.flags;
        }
        if(true) goto _L21; else goto _L20
_L20:
    }

    private boolean parsePackageItemInfo(Package package1, PackageItemInfo packageiteminfo, String as[], String s, TypedArray typedarray, int i, int j, 
            int k, int l) {
        String s1 = typedarray.getNonConfigurationString(i, 0);
        boolean flag;
        if(s1 == null) {
            as[0] = (new StringBuilder()).append(s).append(" does not specify android:name").toString();
            flag = false;
        } else {
            packageiteminfo.name = buildClassName(package1.applicationInfo.packageName, s1, as);
            if(packageiteminfo.name == null) {
                flag = false;
            } else {
                int i1 = typedarray.getResourceId(k, 0);
                if(i1 != 0) {
                    packageiteminfo.icon = i1;
                    packageiteminfo.nonLocalizedLabel = null;
                }
                int j1 = typedarray.getResourceId(l, 0);
                if(j1 != 0)
                    packageiteminfo.logo = j1;
                TypedValue typedvalue = typedarray.peekValue(j);
                if(typedvalue != null) {
                    int k1 = typedvalue.resourceId;
                    packageiteminfo.labelRes = k1;
                    if(k1 == 0)
                        packageiteminfo.nonLocalizedLabel = typedvalue.coerceToString();
                }
                packageiteminfo.packageName = package1.packageName;
                flag = true;
            }
        }
        return flag;
    }

    private static PackageLite parsePackageLite(Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset, int i, String as[]) throws IOException, XmlPullParserException {
        int j;
        do
            j = xmlpullparser.next();
        while(j != 2 && j != 1);
        if(j == 2) goto _L2; else goto _L1
_L1:
        PackageLite packagelite;
        as[0] = "No start tag found";
        packagelite = null;
_L4:
        return packagelite;
_L2:
        if(!xmlpullparser.getName().equals("manifest")) {
            as[0] = "No <manifest> tag";
            packagelite = null;
            continue; /* Loop/switch isn't completed */
        }
        String s = attributeset.getAttributeValue(null, "package");
        if(s == null || s.length() == 0) {
            as[0] = "<manifest> does not specify package";
            packagelite = null;
            continue; /* Loop/switch isn't completed */
        }
        String s1 = Injector.filterNameError(s, validateName(s, true));
        if(s1 != null && !"android".equals(s)) {
            as[0] = (new StringBuilder()).append("<manifest> specifies bad package name \"").append(s).append("\": ").append(s1).toString();
            packagelite = null;
            continue; /* Loop/switch isn't completed */
        }
        int k = -1;
        int l = 0;
        ArrayList arraylist;
label0:
        do {
label1:
            {
                if(l < attributeset.getAttributeCount()) {
                    if(!attributeset.getAttributeName(l).equals("installLocation"))
                        break label1;
                    k = attributeset.getAttributeIntValue(l, -1);
                }
                int i1 = 1 + xmlpullparser.getDepth();
                arraylist = new ArrayList();
                do {
                    int j1 = xmlpullparser.next();
                    if(j1 == 1 || j1 == 3 && xmlpullparser.getDepth() < i1)
                        break;
                    if(j1 != 3 && j1 != 4 && xmlpullparser.getDepth() == i1 && "package-verifier".equals(xmlpullparser.getName())) {
                        VerifierInfo verifierinfo = parseVerifier(resources, xmlpullparser, attributeset, i, as);
                        if(verifierinfo != null)
                            arraylist.add(verifierinfo);
                    }
                } while(true);
                break label0;
            }
            l++;
        } while(true);
        packagelite = new PackageLite(s.intern(), k, arraylist);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static PackageLite parsePackageLite(String s, int i) {
        AssetManager assetmanager = new AssetManager();
        int j;
        assetmanager.setConfiguration(0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, android.os.Build.VERSION.RESOURCES_SDK_INT);
        j = assetmanager.addAssetPath(s);
        if(j != 0) goto _L2; else goto _L1
_L1:
        PackageLite packagelite = null;
          goto _L3
_L2:
        Resources resources;
        XmlResourceParser xmlresourceparser;
        DisplayMetrics displaymetrics = new DisplayMetrics();
        displaymetrics.setToDefaults();
        resources = new Resources(assetmanager, displaymetrics, null);
        xmlresourceparser = assetmanager.openXmlResourceParser(j, "AndroidManifest.xml");
        String as[];
        as = new String[1];
        packagelite = null;
        PackageLite packagelite1 = parsePackageLite(resources, ((XmlPullParser) (xmlresourceparser)), ((AttributeSet) (xmlresourceparser)), i, as);
        packagelite = packagelite1;
        if(xmlresourceparser != null)
            xmlresourceparser.close();
        if(assetmanager != null)
            assetmanager.close();
_L6:
        if(packagelite == null) {
            Slog.e("PackageParser", (new StringBuilder()).append("parsePackageLite error: ").append(as[0]).toString());
            packagelite = null;
        }
          goto _L3
        Exception exception;
        exception;
        assetmanager = null;
_L4:
        if(assetmanager != null)
            assetmanager.close();
        Slog.w("PackageParser", (new StringBuilder()).append("Unable to read AndroidManifest.xml of ").append(s).toString(), exception);
        packagelite = null;
        break; /* Loop/switch isn't completed */
        IOException ioexception;
        ioexception;
        Slog.w("PackageParser", s, ioexception);
        if(xmlresourceparser != null)
            xmlresourceparser.close();
        if(assetmanager != null)
            assetmanager.close();
        continue; /* Loop/switch isn't completed */
        XmlPullParserException xmlpullparserexception;
        xmlpullparserexception;
        Slog.w("PackageParser", s, xmlpullparserexception);
        if(xmlresourceparser != null)
            xmlresourceparser.close();
        if(assetmanager != null)
            assetmanager.close();
        continue; /* Loop/switch isn't completed */
        Exception exception1;
        exception1;
        if(xmlresourceparser != null)
            xmlresourceparser.close();
        if(assetmanager != null)
            assetmanager.close();
        throw exception1;
        exception;
        if(true) goto _L4; else goto _L3
_L3:
        return packagelite;
        if(true) goto _L6; else goto _L5
_L5:
    }

    private static String parsePackageName(XmlPullParser xmlpullparser, AttributeSet attributeset, int i, String as[]) throws IOException, XmlPullParserException {
        String s = null;
        int j;
        do
            j = xmlpullparser.next();
        while(j != 2 && j != 1);
        if(j != 2)
            as[0] = "No start tag found";
        else
        if(!xmlpullparser.getName().equals("manifest")) {
            as[0] = "No <manifest> tag";
        } else {
            String s1 = attributeset.getAttributeValue(null, "package");
            if(s1 == null || s1.length() == 0) {
                as[0] = "<manifest> does not specify package";
            } else {
                String s2 = Injector.filterNameError(s1, validateName(s1, true));
                if(s2 != null && !"android".equals(s1))
                    as[0] = (new StringBuilder()).append("<manifest> specifies bad package name \"").append(s1).append("\": ").append(s2).toString();
                else
                    s = s1.intern();
            }
        }
        return s;
    }

    private Permission parsePermission(Package package1, Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset, String as[]) throws XmlPullParserException, IOException {
        Permission permission = new Permission(package1);
        TypedArray typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.AndroidManifestPermission);
        if(!parsePackageItemInfo(package1, permission.info, as, "<permission>", typedarray, 2, 0, 1, 6)) {
            typedarray.recycle();
            mParseError = -108;
            permission = null;
        } else {
            permission.info.group = typedarray.getNonResourceString(4);
            if(permission.info.group != null)
                permission.info.group = permission.info.group.intern();
            permission.info.descriptionRes = typedarray.getResourceId(5, 0);
            permission.info.protectionLevel = typedarray.getInt(3, 0);
            typedarray.recycle();
            if(permission.info.protectionLevel == -1) {
                as[0] = "<permission> does not specify protectionLevel";
                mParseError = -108;
                permission = null;
            } else {
                permission.info.protectionLevel = PermissionInfo.fixProtectionLevel(permission.info.protectionLevel);
                if((0xf0 & permission.info.protectionLevel) != 0 && (0xf & permission.info.protectionLevel) != 2) {
                    as[0] = "<permission>  protectionLevel specifies a flag but is not based on signature type";
                    mParseError = -108;
                    permission = null;
                } else
                if(!parseAllMetaData(resources, xmlpullparser, attributeset, "<permission>", permission, as)) {
                    mParseError = -108;
                    permission = null;
                } else {
                    package1.permissions.add(permission);
                }
            }
        }
        return permission;
    }

    private PermissionGroup parsePermissionGroup(Package package1, int i, Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset, String as[]) throws XmlPullParserException, IOException {
        PermissionGroup permissiongroup = new PermissionGroup(package1);
        TypedArray typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.AndroidManifestPermissionGroup);
        if(!parsePackageItemInfo(package1, permissiongroup.info, as, "<permission-group>", typedarray, 2, 0, 1, 5)) {
            typedarray.recycle();
            mParseError = -108;
            permissiongroup = null;
        } else {
            permissiongroup.info.descriptionRes = typedarray.getResourceId(4, 0);
            permissiongroup.info.flags = 0;
            permissiongroup.info.priority = typedarray.getInt(3, 0);
            if(permissiongroup.info.priority > 0 && (i & 1) == 0)
                permissiongroup.info.priority = 0;
            typedarray.recycle();
            if(!parseAllMetaData(resources, xmlpullparser, attributeset, "<permission-group>", permissiongroup, as)) {
                mParseError = -108;
                permissiongroup = null;
            } else {
                package1.permissionGroups.add(permissiongroup);
            }
        }
        return permissiongroup;
    }

    private Permission parsePermissionTree(Package package1, Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset, String as[]) throws XmlPullParserException, IOException {
        Permission permission = new Permission(package1);
        TypedArray typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.AndroidManifestPermissionTree);
        if(!parsePackageItemInfo(package1, permission.info, as, "<permission-tree>", typedarray, 2, 0, 1, 3)) {
            typedarray.recycle();
            mParseError = -108;
            permission = null;
        } else {
            typedarray.recycle();
            int i = permission.info.name.indexOf('.');
            if(i > 0)
                i = permission.info.name.indexOf('.', i + 1);
            if(i < 0) {
                as[0] = (new StringBuilder()).append("<permission-tree> name has less than three segments: ").append(permission.info.name).toString();
                mParseError = -108;
                permission = null;
            } else {
                permission.info.descriptionRes = 0;
                permission.info.protectionLevel = 0;
                permission.tree = true;
                if(!parseAllMetaData(resources, xmlpullparser, attributeset, "<permission-tree>", permission, as)) {
                    mParseError = -108;
                    permission = null;
                } else {
                    package1.permissions.add(permission);
                }
            }
        }
        return permission;
    }

    private Provider parseProvider(Package package1, Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset, int i, String as[]) throws XmlPullParserException, IOException {
        TypedArray typedarray;
        Provider provider;
        typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.AndroidManifestProvider);
        if(mParseProviderArgs == null) {
            mParseProviderArgs = new ParseComponentArgs(package1, as, 2, 0, 1, 15, mSeparateProcesses, 8, 14, 6);
            mParseProviderArgs.tag = "<provider>";
        }
        mParseProviderArgs.sa = typedarray;
        mParseProviderArgs.flags = i;
        provider = new Provider(mParseProviderArgs, new ProviderInfo());
        if(as[0] == null) goto _L2; else goto _L1
_L1:
        typedarray.recycle();
        provider = null;
_L4:
        return provider;
_L2:
        provider.info.exported = typedarray.getBoolean(7, true);
        String s = typedarray.getNonConfigurationString(10, 0);
        provider.info.isSyncable = typedarray.getBoolean(11, false);
        String s1 = typedarray.getNonConfigurationString(3, 0);
        String s2 = typedarray.getNonConfigurationString(4, 0);
        if(s2 == null)
            s2 = s1;
        String s4;
        if(s2 == null) {
            provider.info.readPermission = package1.applicationInfo.permission;
        } else {
            ProviderInfo providerinfo = provider.info;
            String s3;
            if(s2.length() > 0)
                s3 = s2.toString().intern();
            else
                s3 = null;
            providerinfo.readPermission = s3;
        }
        s4 = typedarray.getNonConfigurationString(5, 0);
        if(s4 == null)
            s4 = s1;
        if(s4 == null) {
            provider.info.writePermission = package1.applicationInfo.permission;
        } else {
            ProviderInfo providerinfo1 = provider.info;
            String s5;
            if(s4.length() > 0)
                s5 = s4.toString().intern();
            else
                s5 = null;
            providerinfo1.writePermission = s5;
        }
        provider.info.grantUriPermissions = typedarray.getBoolean(13, false);
        provider.info.multiprocess = typedarray.getBoolean(9, false);
        provider.info.initOrder = typedarray.getInt(12, 0);
        typedarray.recycle();
        if((0x10000000 & package1.applicationInfo.flags) != 0 && provider.info.processName == package1.packageName) {
            as[0] = "Heavy-weight applications can not have providers in main process";
            provider = null;
        } else
        if(s == null) {
            as[0] = "<provider> does not incude authorities attribute";
            provider = null;
        } else {
            provider.info.authority = s.intern();
            if(!parseProviderTags(resources, xmlpullparser, attributeset, provider, as))
                provider = null;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private boolean parseProviderTags(Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset, Provider provider, String as[]) throws XmlPullParserException, IOException {
        int i = xmlpullparser.getDepth();
_L4:
        int j;
        do {
            j = xmlpullparser.next();
            if(j == 1 || j == 3 && xmlpullparser.getDepth() <= i)
                break MISSING_BLOCK_LABEL_898;
        } while(j == 3 || j == 4);
        if(!xmlpullparser.getName().equals("meta-data")) goto _L2; else goto _L1
_L1:
        Bundle bundle;
        bundle = parseMetaData(resources, xmlpullparser, attributeset, provider.metaData, as);
        provider.metaData = bundle;
        if(bundle != null) goto _L4; else goto _L3
_L3:
        boolean flag = false;
_L5:
        return flag;
_L2:
        if(xmlpullparser.getName().equals("grant-uri-permission")) {
            TypedArray typedarray1 = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.AndroidManifestGrantUriPermission);
            PatternMatcher patternmatcher = null;
            String s6 = typedarray1.getNonConfigurationString(0, 0);
            if(s6 != null)
                patternmatcher = new PatternMatcher(s6, 0);
            String s7 = typedarray1.getNonConfigurationString(1, 0);
            if(s7 != null)
                patternmatcher = new PatternMatcher(s7, 1);
            String s8 = typedarray1.getNonConfigurationString(2, 0);
            if(s8 != null)
                patternmatcher = new PatternMatcher(s8, 2);
            typedarray1.recycle();
            if(patternmatcher != null) {
                if(provider.info.uriPermissionPatterns == null) {
                    provider.info.uriPermissionPatterns = new PatternMatcher[1];
                    provider.info.uriPermissionPatterns[0] = patternmatcher;
                } else {
                    int l = provider.info.uriPermissionPatterns.length;
                    PatternMatcher apatternmatcher[] = new PatternMatcher[l + 1];
                    System.arraycopy(provider.info.uriPermissionPatterns, 0, apatternmatcher, 0, l);
                    apatternmatcher[l] = patternmatcher;
                    provider.info.uriPermissionPatterns = apatternmatcher;
                }
                provider.info.grantUriPermissions = true;
                XmlUtils.skipCurrentTag(xmlpullparser);
            } else {
                Slog.w("PackageParser", (new StringBuilder()).append("Unknown element under <path-permission>: ").append(xmlpullparser.getName()).append(" at ").append(mArchiveSourcePath).append(" ").append(xmlpullparser.getPositionDescription()).toString());
                XmlUtils.skipCurrentTag(xmlpullparser);
            }
        } else
        if(xmlpullparser.getName().equals("path-permission")) {
            TypedArray typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.AndroidManifestPathPermission);
            PathPermission pathpermission = null;
            String s = typedarray.getNonConfigurationString(0, 0);
            String s1 = typedarray.getNonConfigurationString(1, 0);
            if(s1 == null)
                s1 = s;
            String s2 = typedarray.getNonConfigurationString(2, 0);
            if(s2 == null)
                s2 = s;
            boolean flag1 = false;
            if(s1 != null) {
                s1 = s1.intern();
                flag1 = true;
            }
            if(s2 != null) {
                s2 = s2.intern();
                flag1 = true;
            }
            if(!flag1) {
                Slog.w("PackageParser", (new StringBuilder()).append("No readPermission or writePermssion for <path-permission>: ").append(xmlpullparser.getName()).append(" at ").append(mArchiveSourcePath).append(" ").append(xmlpullparser.getPositionDescription()).toString());
                XmlUtils.skipCurrentTag(xmlpullparser);
            } else {
                String s3 = typedarray.getNonConfigurationString(3, 0);
                if(s3 != null)
                    pathpermission = new PathPermission(s3, 0, s1, s2);
                String s4 = typedarray.getNonConfigurationString(4, 0);
                if(s4 != null)
                    pathpermission = new PathPermission(s4, 1, s1, s2);
                String s5 = typedarray.getNonConfigurationString(5, 0);
                if(s5 != null)
                    pathpermission = new PathPermission(s5, 2, s1, s2);
                typedarray.recycle();
                if(pathpermission != null) {
                    if(provider.info.pathPermissions == null) {
                        provider.info.pathPermissions = new PathPermission[1];
                        provider.info.pathPermissions[0] = pathpermission;
                    } else {
                        int k = provider.info.pathPermissions.length;
                        PathPermission apathpermission[] = new PathPermission[k + 1];
                        System.arraycopy(provider.info.pathPermissions, 0, apathpermission, 0, k);
                        apathpermission[k] = pathpermission;
                        provider.info.pathPermissions = apathpermission;
                    }
                    XmlUtils.skipCurrentTag(xmlpullparser);
                } else {
                    Slog.w("PackageParser", (new StringBuilder()).append("No path, pathPrefix, or pathPattern for <path-permission>: ").append(xmlpullparser.getName()).append(" at ").append(mArchiveSourcePath).append(" ").append(xmlpullparser.getPositionDescription()).toString());
                    XmlUtils.skipCurrentTag(xmlpullparser);
                }
            }
        } else {
            Slog.w("PackageParser", (new StringBuilder()).append("Unknown element under <provider>: ").append(xmlpullparser.getName()).append(" at ").append(mArchiveSourcePath).append(" ").append(xmlpullparser.getPositionDescription()).toString());
            XmlUtils.skipCurrentTag(xmlpullparser);
        }
          goto _L4
        flag = true;
          goto _L5
    }

    private Service parseService(Package package1, Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset, int i, String as[]) throws XmlPullParserException, IOException {
        TypedArray typedarray;
        Service service;
        typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.AndroidManifestService);
        if(mParseServiceArgs == null) {
            mParseServiceArgs = new ParseComponentArgs(package1, as, 2, 0, 1, 8, mSeparateProcesses, 6, 7, 4);
            mParseServiceArgs.tag = "<service>";
        }
        mParseServiceArgs.sa = typedarray;
        mParseServiceArgs.flags = i;
        service = new Service(mParseServiceArgs, new ServiceInfo());
        if(as[0] == null) goto _L2; else goto _L1
_L1:
        typedarray.recycle();
        service = null;
_L4:
        return service;
_L2:
        boolean flag = typedarray.hasValue(5);
        if(flag)
            service.info.exported = typedarray.getBoolean(5, false);
        String s = typedarray.getNonConfigurationString(3, 0);
        if(s == null) {
            service.info.permission = package1.applicationInfo.permission;
        } else {
            ServiceInfo serviceinfo = service.info;
            String s1;
            if(s.length() > 0)
                s1 = s.toString().intern();
            else
                s1 = null;
            serviceinfo.permission = s1;
        }
        service.info.flags = 0;
        if(typedarray.getBoolean(9, false)) {
            ServiceInfo serviceinfo3 = service.info;
            serviceinfo3.flags = 1 | serviceinfo3.flags;
        }
        if(typedarray.getBoolean(10, false)) {
            ServiceInfo serviceinfo2 = service.info;
            serviceinfo2.flags = 2 | serviceinfo2.flags;
        }
        typedarray.recycle();
        if((0x10000000 & package1.applicationInfo.flags) != 0 && service.info.processName == package1.packageName) {
            as[0] = "Heavy-weight applications can not have services in main process";
            service = null;
            continue; /* Loop/switch isn't completed */
        }
        int j = xmlpullparser.getDepth();
        do {
            int k = xmlpullparser.next();
            if(k == 1 || k == 3 && xmlpullparser.getDepth() <= j)
                break;
            if(k == 3 || k == 4)
                continue;
            if(xmlpullparser.getName().equals("intent-filter")) {
                ServiceIntentInfo serviceintentinfo = new ServiceIntentInfo(service);
                if(!parseIntent(resources, xmlpullparser, attributeset, i, serviceintentinfo, as, false)) {
                    service = null;
                } else {
                    service.intents.add(serviceintentinfo);
                    continue;
                }
                continue; /* Loop/switch isn't completed */
            }
            if(xmlpullparser.getName().equals("meta-data")) {
                Bundle bundle = parseMetaData(resources, xmlpullparser, attributeset, service.metaData, as);
                service.metaData = bundle;
                if(bundle != null)
                    continue;
                service = null;
                continue; /* Loop/switch isn't completed */
            }
            Slog.w("PackageParser", (new StringBuilder()).append("Unknown element under <service>: ").append(xmlpullparser.getName()).append(" at ").append(mArchiveSourcePath).append(" ").append(xmlpullparser.getPositionDescription()).toString());
            XmlUtils.skipCurrentTag(xmlpullparser);
        } while(true);
        if(!flag) {
            ServiceInfo serviceinfo1 = service.info;
            boolean flag1;
            if(service.intents.size() > 0)
                flag1 = true;
            else
                flag1 = false;
            serviceinfo1.exported = flag1;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static VerifierInfo parseVerifier(Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset, int i, String as[]) throws XmlPullParserException, IOException {
        String s;
        String s1;
        TypedArray typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.AndroidManifestPackageVerifier);
        s = typedarray.getNonResourceString(0);
        s1 = typedarray.getNonResourceString(1);
        typedarray.recycle();
        if(s != null && s.length() != 0) goto _L2; else goto _L1
_L1:
        VerifierInfo verifierinfo;
        Slog.i("PackageParser", "verifier package name was null; skipping");
        verifierinfo = null;
_L4:
        return verifierinfo;
_L2:
        if(s1 == null)
            Slog.i("PackageParser", (new StringBuilder()).append("verifier ").append(s).append(" public key was null; skipping").toString());
        X509EncodedKeySpec x509encodedkeyspec = new X509EncodedKeySpec(Base64.decode(s1, 0));
        IllegalArgumentException illegalargumentexception;
        try {
            verifierinfo = new VerifierInfo(s, KeyFactory.getInstance("RSA").generatePublic(x509encodedkeyspec));
        }
        catch(NoSuchAlgorithmException nosuchalgorithmexception1) {
            Log.wtf("PackageParser", "Could not parse public key because RSA isn't included in build");
            verifierinfo = null;
        }
        catch(InvalidKeySpecException invalidkeyspecexception) {
            try {
                verifierinfo = new VerifierInfo(s, KeyFactory.getInstance("DSA").generatePublic(x509encodedkeyspec));
            }
            catch(NoSuchAlgorithmException nosuchalgorithmexception) {
                Log.wtf("PackageParser", "Could not parse public key because DSA isn't included in build");
                verifierinfo = null;
            }
            catch(InvalidKeySpecException invalidkeyspecexception1) {
                verifierinfo = null;
            }
        }
        continue; /* Loop/switch isn't completed */
        illegalargumentexception;
        Slog.i("PackageParser", (new StringBuilder()).append("Could not parse verifier ").append(s).append(" public key; invalid Base64").toString());
        verifierinfo = null;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static void setCompatibilityModeEnabled(boolean flag) {
        sCompatibilityModeEnabled = flag;
    }

    public static Signature stringToSignature(String s) {
        int i = s.length();
        byte abyte0[] = new byte[i];
        for(int j = 0; j < i; j++)
            abyte0[j] = (byte)s.charAt(j);

        return new Signature(abyte0);
    }

    private static String validateName(String s, boolean flag) {
        s1 = (new StringBuilder()).append("bad character '").append(c).append("'").toString();
_L2:
        return s1;
        int i = s.length();
        boolean flag1 = false;
        boolean flag2 = true;
        int j = 0;
        String s1;
        char c;
        while(j < i)  {
            c = s.charAt(j);
            if(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')
                flag2 = false;
            else
            if(flag2 || (c < '0' || c > '9') && c != '_') {
label0:
                {
                    if(c != '.')
                        break label0;
                    flag1 = true;
                    flag2 = true;
                }
            }
            j++;
        }
        if(flag1 || !flag)
            s1 = null;
        else
            s1 = "must have at least one '.' separator";
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean collectCertificates(Package package1, int i) {
        byte abyte0[];
        WeakReference weakreference;
        package1.mSignatures = null;
        abyte0 = null;
        synchronized(mSync) {
            weakreference = mReadBuffer;
            if(weakreference != null) {
                mReadBuffer = null;
                abyte0 = (byte[])weakreference.get();
            }
            if(abyte0 == null) {
                abyte0 = new byte[8192];
                weakreference = new WeakReference(abyte0);
            }
        }
        JarFile jarfile;
        Certificate acertificate[];
        jarfile = new JarFile(mArchiveSourcePath);
        acertificate = null;
        if((i & 1) == 0) goto _L2; else goto _L1
_L1:
        JarEntry jarentry1;
        jarentry1 = jarfile.getJarEntry("AndroidManifest.xml");
        acertificate = loadCertificates(jarfile, jarentry1, abyte0);
        if(acertificate != null) goto _L4; else goto _L3
_L3:
        Slog.e("PackageParser", (new StringBuilder()).append("Package ").append(package1.packageName).append(" has no certificates at entry ").append(jarentry1.getName()).append("; ignoring!").toString());
        jarfile.close();
        mParseError = -103;
        boolean flag = false;
_L12:
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        Enumeration enumeration;
        Manifest manifest;
        enumeration = jarfile.entries();
        manifest = jarfile.getManifest();
_L7:
        if(!enumeration.hasMoreElements()) goto _L4; else goto _L5
_L5:
        JarEntry jarentry = (JarEntry)enumeration.nextElement();
        if(jarentry.isDirectory()) goto _L7; else goto _L6
_L6:
        String s = jarentry.getName();
        if(s.startsWith("META-INF/")) goto _L7; else goto _L8
_L8:
        Certificate acertificate1[];
        if("AndroidManifest.xml".equals(s))
            package1.manifestDigest = ManifestDigest.fromAttributes(manifest.getAttributes(s));
        acertificate1 = loadCertificates(jarfile, jarentry, abyte0);
        if(acertificate1 != null) goto _L10; else goto _L9
_L9:
        if(ExtraPackageManager.isTrustedAppEntry(jarentry, package1.packageName)) goto _L7; else goto _L11
_L11:
        Slog.e("PackageParser", (new StringBuilder()).append("Package ").append(package1.packageName).append(" has no certificates at entry ").append(jarentry.getName()).append("; ignoring!").toString());
        jarfile.close();
        mParseError = -103;
        flag = false;
          goto _L12
_L20:
        int l;
        if(l >= acertificate.length) goto _L7; else goto _L13
_L13:
        boolean flag1;
        int i1;
        flag1 = false;
        i1 = 0;
_L21:
        if(i1 >= acertificate1.length) goto _L15; else goto _L14
_L14:
        if(acertificate[l] == null || !acertificate[l].equals(acertificate1[i1])) goto _L17; else goto _L16
_L16:
        flag1 = true;
_L15:
        if(flag1 && acertificate.length == acertificate1.length)
            break MISSING_BLOCK_LABEL_796;
        Slog.e("PackageParser", (new StringBuilder()).append("Package ").append(package1.packageName).append(" has mismatched certificates at entry ").append(jarentry.getName()).append("; ignoring!").toString());
        jarfile.close();
        mParseError = -104;
        flag = false;
          goto _L12
_L4:
        jarfile.close();
        synchronized(mSync) {
            mReadBuffer = weakreference;
        }
        if(acertificate == null)
            break MISSING_BLOCK_LABEL_629;
        int j;
        int k;
        if(acertificate.length <= 0)
            break MISSING_BLOCK_LABEL_629;
        j = acertificate.length;
        package1.mSignatures = new Signature[acertificate.length];
        k = 0;
_L18:
        if(k >= j)
            break MISSING_BLOCK_LABEL_766;
        package1.mSignatures[k] = new Signature(acertificate[k].getEncoded());
        k++;
          goto _L18
        exception1;
        obj1;
        JVM INSTR monitorexit ;
        try {
            throw exception1;
        }
        catch(CertificateEncodingException certificateencodingexception) {
            Slog.w("PackageParser", (new StringBuilder()).append("Exception reading ").append(mArchiveSourcePath).toString(), certificateencodingexception);
            mParseError = -105;
            flag = false;
        }
        catch(IOException ioexception) {
            Slog.w("PackageParser", (new StringBuilder()).append("Exception reading ").append(mArchiveSourcePath).toString(), ioexception);
            mParseError = -105;
            flag = false;
        }
        catch(RuntimeException runtimeexception) {
            Slog.w("PackageParser", (new StringBuilder()).append("Exception reading ").append(mArchiveSourcePath).toString(), runtimeexception);
            mParseError = -102;
            flag = false;
        }
          goto _L12
        Slog.e("PackageParser", (new StringBuilder()).append("Package ").append(package1.packageName).append(" has no certificates; ignoring!").toString());
        mParseError = -103;
        flag = false;
          goto _L12
        flag = true;
          goto _L12
_L10:
label0:
        {
            if(acertificate != null)
                break label0;
            acertificate = acertificate1;
        }
        if(true) goto _L7; else goto _L19
_L19:
        l = 0;
          goto _L20
_L17:
        i1++;
          goto _L21
        l++;
          goto _L20
    }

    public int getParseError() {
        return mParseError;
    }

    public Package parsePackage(File file, String s, DisplayMetrics displaymetrics, int i) {
        Package package1;
        mParseError = 1;
        mArchiveSourcePath = file.getPath();
        if(!file.isFile()) {
            Slog.w("PackageParser", (new StringBuilder()).append("Skipping dir: ").append(mArchiveSourcePath).toString());
            mParseError = -100;
            package1 = null;
        } else {
label0:
            {
                if(isPackageFilename(file.getName()) || (i & 4) == 0)
                    break label0;
                if((i & 1) == 0)
                    Slog.w("PackageParser", (new StringBuilder()).append("Skipping non-package file: ").append(mArchiveSourcePath).toString());
                mParseError = -100;
                package1 = null;
            }
        }
_L5:
        return package1;
        XmlResourceParser xmlresourceparser;
        MiuiResources miuiresources;
        boolean flag;
        xmlresourceparser = null;
        miuiresources = null;
        flag = true;
        AssetManager assetmanager = new AssetManager();
        int j = assetmanager.addAssetPath(mArchiveSourcePath);
        if(j == 0) goto _L2; else goto _L1
_L1:
        MiuiResources miuiresources1 = new MiuiResources(assetmanager, displaymetrics, null);
        XmlResourceParser xmlresourceparser1;
        assetmanager.setConfiguration(0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, android.os.Build.VERSION.RESOURCES_SDK_INT);
        xmlresourceparser1 = assetmanager.openXmlResourceParser(j, "AndroidManifest.xml");
        xmlresourceparser = xmlresourceparser1;
        flag = false;
        miuiresources = miuiresources1;
_L6:
        if(!flag) goto _L4; else goto _L3
_L3:
        if(assetmanager != null)
            assetmanager.close();
        mParseError = -101;
        package1 = null;
          goto _L5
_L2:
        Slog.w("PackageParser", (new StringBuilder()).append("Failed adding asset path:").append(mArchiveSourcePath).toString());
          goto _L6
        Exception exception;
        exception;
_L8:
        Slog.w("PackageParser", (new StringBuilder()).append("Unable to read AndroidManifest.xml of ").append(mArchiveSourcePath).toString(), exception);
          goto _L6
_L4:
        String as[];
        Object obj;
        as = new String[1];
        package1 = null;
        obj = null;
        Package package2 = parsePackage(((Resources) (miuiresources)), xmlresourceparser, i, as);
        package1 = package2;
_L7:
        if(package1 == null) {
            if(!mOnlyCoreApps || mParseError != 1) {
                Exception exception1;
                if(obj != null)
                    Slog.w("PackageParser", mArchiveSourcePath, ((Throwable) (obj)));
                else
                    Slog.w("PackageParser", (new StringBuilder()).append(mArchiveSourcePath).append(" (at ").append(xmlresourceparser.getPositionDescription()).append("): ").append(as[0]).toString());
                if(mParseError == 1)
                    mParseError = -108;
            }
            xmlresourceparser.close();
            assetmanager.close();
            package1 = null;
        } else {
            xmlresourceparser.close();
            assetmanager.close();
            package1.mPath = s;
            String s1 = mArchiveSourcePath;
            package1.mScanPath = s1;
            package1.mSignatures = null;
        }
          goto _L5
        exception1;
        obj = exception1;
        mParseError = -102;
          goto _L7
        exception;
        assetmanager = null;
          goto _L8
        exception;
        miuiresources = miuiresources1;
          goto _L8
    }

    public void setOnlyCoreApps(boolean flag) {
        mOnlyCoreApps = flag;
    }

    public void setSeparateProcesses(String as[]) {
        mSeparateProcesses = as;
    }

    private static final String ANDROID_MANIFEST_FILENAME = "AndroidManifest.xml";
    private static final String ANDROID_RESOURCES = "http://schemas.android.com/apk/res/android";
    private static final boolean DEBUG_BACKUP = false;
    private static final boolean DEBUG_JAR = false;
    private static final boolean DEBUG_PARSER = false;
    public static final NewPermissionInfo NEW_PERMISSIONS[];
    public static final int PARSE_CHATTY = 2;
    private static final int PARSE_DEFAULT_INSTALL_LOCATION = -1;
    public static final int PARSE_FORWARD_LOCK = 16;
    public static final int PARSE_IGNORE_PROCESSES = 8;
    public static final int PARSE_IS_SYSTEM = 1;
    public static final int PARSE_IS_SYSTEM_DIR = 64;
    public static final int PARSE_MUST_BE_APK = 4;
    public static final int PARSE_ON_SDCARD = 32;
    private static final boolean RIGID_PARSER = false;
    private static final String SDK_CODENAME;
    private static final int SDK_VERSION = 0;
    public static final SplitPermissionInfo SPLIT_PERMISSIONS[];
    private static final String TAG = "PackageParser";
    private static WeakReference mReadBuffer;
    private static final Object mSync = new Object();
    private static boolean sCompatibilityModeEnabled = true;
    private String mArchiveSourcePath;
    private boolean mOnlyCoreApps;
    private ParseComponentArgs mParseActivityAliasArgs;
    private ParseComponentArgs mParseActivityArgs;
    private int mParseError;
    private ParsePackageItemArgs mParseInstrumentationArgs;
    private ParseComponentArgs mParseProviderArgs;
    private ParseComponentArgs mParseServiceArgs;
    private String mSeparateProcesses[];

    static  {
        NewPermissionInfo anewpermissioninfo[] = new NewPermissionInfo[2];
        anewpermissioninfo[0] = new NewPermissionInfo("android.permission.WRITE_EXTERNAL_STORAGE", 4, 0);
        anewpermissioninfo[1] = new NewPermissionInfo("android.permission.READ_PHONE_STATE", 4, 0);
        NEW_PERMISSIONS = anewpermissioninfo;
        SplitPermissionInfo asplitpermissioninfo[] = new SplitPermissionInfo[3];
        String as[] = new String[1];
        as[0] = "android.permission.READ_EXTERNAL_STORAGE";
        asplitpermissioninfo[0] = new SplitPermissionInfo("android.permission.WRITE_EXTERNAL_STORAGE", as, 10001);
        String as1[] = new String[1];
        as1[0] = "android.permission.READ_CALL_LOG";
        asplitpermissioninfo[1] = new SplitPermissionInfo("android.permission.READ_CONTACTS", as1, 16);
        String as2[] = new String[1];
        as2[0] = "android.permission.WRITE_CALL_LOG";
        asplitpermissioninfo[2] = new SplitPermissionInfo("android.permission.WRITE_CONTACTS", as2, 16);
        SPLIT_PERMISSIONS = asplitpermissioninfo;
        SDK_VERSION = android.os.Build.VERSION.SDK_INT;
        String s;
        if("REL".equals(android.os.Build.VERSION.CODENAME))
            s = null;
        else
            s = android.os.Build.VERSION.CODENAME;
        SDK_CODENAME = s;
    }


}

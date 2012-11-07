// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.*;
import android.content.pm.*;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.*;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.*;

// Referenced classes of package android.app:
//            ActivityThread, ContextImpl

final class ApplicationPackageManager extends PackageManager {
    static final class ResourceName {

        public boolean equals(Object obj) {
            boolean flag = true;
            if(this != obj) goto _L2; else goto _L1
_L1:
            return flag;
_L2:
            if(obj == null || getClass() != obj.getClass()) {
                flag = false;
            } else {
                ResourceName resourcename = (ResourceName)obj;
                if(iconId != resourcename.iconId)
                    flag = false;
                else
                if(packageName == null ? resourcename.packageName != null : !packageName.equals(resourcename.packageName))
                    flag = false;
            }
            if(true) goto _L1; else goto _L3
_L3:
        }

        public int hashCode() {
            return 31 * packageName.hashCode() + iconId;
        }

        public String toString() {
            return (new StringBuilder()).append("{ResourceName ").append(packageName).append(" / ").append(iconId).append("}").toString();
        }

        final int iconId;
        final String packageName;

        ResourceName(ApplicationInfo applicationinfo, int i) {
            this(((PackageItemInfo) (applicationinfo)).packageName, i);
        }

        ResourceName(ComponentInfo componentinfo, int i) {
            this(((PackageItemInfo) (componentinfo.applicationInfo)).packageName, i);
        }

        ResourceName(ResolveInfo resolveinfo, int i) {
            this(((PackageItemInfo) (((ComponentInfo) (resolveinfo.activityInfo)).applicationInfo)).packageName, i);
        }

        ResourceName(String s, int i) {
            packageName = s;
            iconId = i;
        }
    }


    ApplicationPackageManager(ContextImpl contextimpl, IPackageManager ipackagemanager) {
        mCachedSafeMode = -1;
        mContext = contextimpl;
        mPM = ipackagemanager;
    }

    static void configurationChanged() {
        Object obj = sSync;
        obj;
        JVM INSTR monitorenter ;
        sIconCache.clear();
        sStringCache.clear();
        return;
    }

    static Drawable getCachedIcon(ResourceName resourcename) {
        Object obj = sSync;
        obj;
        JVM INSTR monitorenter ;
        Drawable drawable;
label0:
        {
            WeakReference weakreference = (WeakReference)sIconCache.get(resourcename);
            if(weakreference != null) {
                android.graphics.drawable.Drawable.ConstantState constantstate = (android.graphics.drawable.Drawable.ConstantState)weakreference.get();
                if(constantstate != null) {
                    drawable = constantstate.newDrawable();
                    break label0;
                }
                sIconCache.remove(resourcename);
            }
            drawable = null;
        }
        return drawable;
    }

    private CharSequence getCachedString(ResourceName resourcename) {
        Object obj = sSync;
        obj;
        JVM INSTR monitorenter ;
        CharSequence charsequence;
label0:
        {
            WeakReference weakreference = (WeakReference)sStringCache.get(resourcename);
            if(weakreference != null) {
                charsequence = (CharSequence)weakreference.get();
                if(charsequence != null)
                    break label0;
                sStringCache.remove(resourcename);
            }
            charsequence = null;
        }
        return charsequence;
    }

    static void handlePackageBroadcast(int i, String as[], boolean flag) {
        boolean flag1;
        boolean flag2;
        int j;
        int k;
        flag1 = false;
        if(i == 1)
            flag1 = true;
        if(as == null || as.length <= 0)
            break MISSING_BLOCK_LABEL_217;
        flag2 = false;
        j = as.length;
        k = 0;
_L2:
        String s;
        if(k >= j)
            break; /* Loop/switch isn't completed */
        s = as[k];
        Object obj = sSync;
        obj;
        JVM INSTR monitorenter ;
        if(sIconCache.size() > 0) {
            Iterator iterator1 = sIconCache.keySet().iterator();
            do {
                if(!iterator1.hasNext())
                    break;
                if(((ResourceName)iterator1.next()).packageName.equals(s)) {
                    iterator1.remove();
                    flag2 = true;
                }
            } while(true);
        }
        if(sStringCache.size() > 0) {
            Iterator iterator = sStringCache.keySet().iterator();
            do {
                if(!iterator.hasNext())
                    break;
                if(((ResourceName)iterator.next()).packageName.equals(s)) {
                    iterator.remove();
                    flag2 = true;
                }
            } while(true);
        }
        k++;
        if(true) goto _L2; else goto _L1
_L1:
        if(flag2 || flag)
            if(flag1)
                Runtime.getRuntime().gc();
            else
                ActivityThread.currentActivityThread().scheduleGcIdler();
    }

    static void putCachedIcon(ResourceName resourcename, Drawable drawable) {
        Object obj = sSync;
        obj;
        JVM INSTR monitorenter ;
        sIconCache.put(resourcename, new WeakReference(drawable.getConstantState()));
        return;
    }

    private void putCachedString(ResourceName resourcename, CharSequence charsequence) {
        Object obj = sSync;
        obj;
        JVM INSTR monitorenter ;
        sStringCache.put(resourcename, new WeakReference(charsequence));
        return;
    }

    public void addPackageToPreferred(String s) {
        mPM.addPackageToPreferred(s);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean addPermission(PermissionInfo permissioninfo) {
        boolean flag;
        try {
            flag = mPM.addPermission(permissioninfo);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("Package manager has died", remoteexception);
        }
        return flag;
    }

    public boolean addPermissionAsync(PermissionInfo permissioninfo) {
        boolean flag;
        try {
            flag = mPM.addPermissionAsync(permissioninfo);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("Package manager has died", remoteexception);
        }
        return flag;
    }

    public void addPreferredActivity(IntentFilter intentfilter, int i, ComponentName acomponentname[], ComponentName componentname) {
        mPM.addPreferredActivity(intentfilter, i, acomponentname, componentname);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String[] canonicalToCurrentPackageNames(String as[]) {
        String as1[];
        try {
            as1 = mPM.canonicalToCurrentPackageNames(as);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("Package manager has died", remoteexception);
        }
        return as1;
    }

    public int checkPermission(String s, String s1) {
        int i;
        try {
            i = mPM.checkPermission(s, s1);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("Package manager has died", remoteexception);
        }
        return i;
    }

    public int checkSignatures(int i, int j) {
        int k;
        try {
            k = mPM.checkUidSignatures(i, j);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("Package manager has died", remoteexception);
        }
        return k;
    }

    public int checkSignatures(String s, String s1) {
        int i;
        try {
            i = mPM.checkSignatures(s, s1);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("Package manager has died", remoteexception);
        }
        return i;
    }

    public void clearApplicationUserData(String s, IPackageDataObserver ipackagedataobserver) {
        mPM.clearApplicationUserData(s, ipackagedataobserver, UserId.myUserId());
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void clearPackagePreferredActivities(String s) {
        mPM.clearPackagePreferredActivities(s);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public UserInfo createUser(String s, int i) {
        UserInfo userinfo1 = mPM.createUser(s, i);
        UserInfo userinfo = userinfo1;
_L2:
        return userinfo;
        RemoteException remoteexception;
        remoteexception;
        userinfo = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String[] currentToCanonicalPackageNames(String as[]) {
        String as1[];
        try {
            as1 = mPM.currentToCanonicalPackageNames(as);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("Package manager has died", remoteexception);
        }
        return as1;
    }

    public void deleteApplicationCacheFiles(String s, IPackageDataObserver ipackagedataobserver) {
        mPM.deleteApplicationCacheFiles(s, ipackagedataobserver);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void deletePackage(String s, IPackageDeleteObserver ipackagedeleteobserver, int i) {
        mPM.deletePackage(s, ipackagedeleteobserver, i);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void freeStorage(long l, IntentSender intentsender) {
        mPM.freeStorage(l, intentsender);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void freeStorageAndNotify(long l, IPackageDataObserver ipackagedataobserver) {
        mPM.freeStorageAndNotify(l, ipackagedataobserver);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public Drawable getActivityIcon(ComponentName componentname) throws android.content.pm.PackageManager.NameNotFoundException {
        return getActivityInfo(componentname, 0).loadIcon(this);
    }

    public Drawable getActivityIcon(Intent intent) throws android.content.pm.PackageManager.NameNotFoundException {
        Drawable drawable;
        if(intent.getComponent() != null) {
            drawable = getActivityIcon(intent.getComponent());
        } else {
            ResolveInfo resolveinfo = resolveActivity(intent, 0x10000);
            if(resolveinfo != null)
                drawable = resolveinfo.activityInfo.loadIcon(this);
            else
                throw new android.content.pm.PackageManager.NameNotFoundException(intent.toUri(0));
        }
        return drawable;
    }

    public ActivityInfo getActivityInfo(ComponentName componentname, int i) throws android.content.pm.PackageManager.NameNotFoundException {
        ActivityInfo activityinfo;
        try {
            activityinfo = mPM.getActivityInfo(componentname, i, UserId.myUserId());
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("Package manager has died", remoteexception);
        }
        if(activityinfo != null)
            return activityinfo;
        else
            throw new android.content.pm.PackageManager.NameNotFoundException(componentname.toString());
    }

    public Drawable getActivityLogo(ComponentName componentname) throws android.content.pm.PackageManager.NameNotFoundException {
        return getActivityInfo(componentname, 0).loadLogo(this);
    }

    public Drawable getActivityLogo(Intent intent) throws android.content.pm.PackageManager.NameNotFoundException {
        Drawable drawable;
        if(intent.getComponent() != null) {
            drawable = getActivityLogo(intent.getComponent());
        } else {
            ResolveInfo resolveinfo = resolveActivity(intent, 0x10000);
            if(resolveinfo != null)
                drawable = resolveinfo.activityInfo.loadLogo(this);
            else
                throw new android.content.pm.PackageManager.NameNotFoundException(intent.toUri(0));
        }
        return drawable;
    }

    public List getAllPermissionGroups(int i) {
        List list;
        try {
            list = mPM.getAllPermissionGroups(i);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("Package manager has died", remoteexception);
        }
        return list;
    }

    public int getApplicationEnabledSetting(String s) {
        int j = mPM.getApplicationEnabledSetting(s, UserId.myUserId());
        int i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        i = 0;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public Drawable getApplicationIcon(ApplicationInfo applicationinfo) {
        return applicationinfo.loadIcon(this);
    }

    public Drawable getApplicationIcon(String s) throws android.content.pm.PackageManager.NameNotFoundException {
        return getApplicationIcon(getApplicationInfo(s, 0));
    }

    public ApplicationInfo getApplicationInfo(String s, int i) throws android.content.pm.PackageManager.NameNotFoundException {
        ApplicationInfo applicationinfo;
        try {
            applicationinfo = mPM.getApplicationInfo(s, i, UserId.myUserId());
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("Package manager has died", remoteexception);
        }
        if(applicationinfo != null)
            return applicationinfo;
        else
            throw new android.content.pm.PackageManager.NameNotFoundException(s);
    }

    public CharSequence getApplicationLabel(ApplicationInfo applicationinfo) {
        return applicationinfo.loadLabel(this);
    }

    public Drawable getApplicationLogo(ApplicationInfo applicationinfo) {
        return applicationinfo.loadLogo(this);
    }

    public Drawable getApplicationLogo(String s) throws android.content.pm.PackageManager.NameNotFoundException {
        return getApplicationLogo(getApplicationInfo(s, 0));
    }

    public int getComponentEnabledSetting(ComponentName componentname) {
        int j = mPM.getComponentEnabledSetting(componentname, UserId.myUserId());
        int i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        i = 0;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public Drawable getDefaultActivityIcon() {
        return Resources.getSystem().getDrawable(0x1080093);
    }

    public Drawable getDrawable(String s, int i, ApplicationInfo applicationinfo) {
        Drawable drawable;
        ResourceName resourcename;
        Drawable drawable1;
        drawable = null;
        resourcename = new ResourceName(s, i);
        drawable1 = getCachedIcon(resourcename);
        if(drawable1 == null) goto _L2; else goto _L1
_L1:
        drawable = drawable1;
_L4:
        return drawable;
_L2:
        if(applicationinfo == null) {
            Drawable drawable2;
            ApplicationInfo applicationinfo1;
            try {
                applicationinfo1 = getApplicationInfo(s, 0);
            }
            catch(android.content.pm.PackageManager.NameNotFoundException namenotfoundexception1) {
                continue; /* Loop/switch isn't completed */
            }
            applicationinfo = applicationinfo1;
        }
        drawable2 = getResourcesForApplication(applicationinfo).getDrawable(i);
        putCachedIcon(resourcename, drawable2);
        drawable = drawable2;
        continue; /* Loop/switch isn't completed */
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        Log.w("PackageManager", (new StringBuilder()).append("Failure retrieving resources for").append(((PackageItemInfo) (applicationinfo)).packageName).toString());
        continue; /* Loop/switch isn't completed */
        android.content.res.Resources.NotFoundException notfoundexception;
        notfoundexception;
        Log.w("PackageManager", (new StringBuilder()).append("Failure retrieving resources for").append(((PackageItemInfo) (applicationinfo)).packageName).append(": ").append(notfoundexception.getMessage()).toString());
        continue; /* Loop/switch isn't completed */
        RuntimeException runtimeexception;
        runtimeexception;
        Log.w("PackageManager", (new StringBuilder()).append("Failure retrieving icon 0x").append(Integer.toHexString(i)).append(" in package ").append(s).toString(), runtimeexception);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public List getInstalledApplications(int i) {
        int j = UserId.getUserId(Process.myUid());
        ArrayList arraylist;
        ApplicationInfo applicationinfo;
        arraylist = new ArrayList();
        applicationinfo = null;
_L3:
        if(applicationinfo == null) goto _L2; else goto _L1
_L1:
        String s = ((PackageItemInfo) (applicationinfo)).packageName;
_L4:
        boolean flag;
        ParceledListSlice parceledlistslice = mPM.getInstalledApplications(i, s, j);
        applicationinfo = (ApplicationInfo)parceledlistslice.populateList(arraylist, ApplicationInfo.CREATOR);
        flag = parceledlistslice.isLastSlice();
        if(flag)
            return arraylist;
          goto _L3
_L2:
        s = null;
          goto _L4
        RemoteException remoteexception;
        remoteexception;
        throw new RuntimeException("Package manager has died", remoteexception);
          goto _L3
    }

    public List getInstalledPackages(int i) {
        ArrayList arraylist;
        PackageInfo packageinfo;
        arraylist = new ArrayList();
        packageinfo = null;
_L3:
        if(packageinfo == null) goto _L2; else goto _L1
_L1:
        String s = packageinfo.packageName;
_L4:
        boolean flag;
        ParceledListSlice parceledlistslice = mPM.getInstalledPackages(i, s);
        packageinfo = (PackageInfo)parceledlistslice.populateList(arraylist, PackageInfo.CREATOR);
        flag = parceledlistslice.isLastSlice();
        if(flag)
            return arraylist;
          goto _L3
_L2:
        s = null;
          goto _L4
        RemoteException remoteexception;
        remoteexception;
        throw new RuntimeException("Package manager has died", remoteexception);
          goto _L3
    }

    public String getInstallerPackageName(String s) {
        String s2 = mPM.getInstallerPackageName(s);
        String s1 = s2;
_L2:
        return s1;
        RemoteException remoteexception;
        remoteexception;
        s1 = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public InstrumentationInfo getInstrumentationInfo(ComponentName componentname, int i) throws android.content.pm.PackageManager.NameNotFoundException {
        InstrumentationInfo instrumentationinfo;
        try {
            instrumentationinfo = mPM.getInstrumentationInfo(componentname, i);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("Package manager has died", remoteexception);
        }
        if(instrumentationinfo != null)
            return instrumentationinfo;
        else
            throw new android.content.pm.PackageManager.NameNotFoundException(componentname.toString());
    }

    public Intent getLaunchIntentForPackage(String s) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.INFO");
        intent.setPackage(s);
        List list = queryIntentActivities(intent, 0);
        if(list == null || list.size() <= 0) {
            intent.removeCategory("android.intent.category.INFO");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(s);
            list = queryIntentActivities(intent, 0);
        }
        Intent intent1;
        if(list == null || list.size() <= 0) {
            intent1 = null;
        } else {
            intent1 = new Intent(intent);
            intent1.setFlags(0x10000000);
            intent1.setClassName(((PackageItemInfo) (((ResolveInfo)list.get(0)).activityInfo)).packageName, ((PackageItemInfo) (((ResolveInfo)list.get(0)).activityInfo)).name);
        }
        return intent1;
    }

    public String getNameForUid(int i) {
        String s;
        try {
            s = mPM.getNameForUid(i);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("Package manager has died", remoteexception);
        }
        return s;
    }

    public int[] getPackageGids(String s) throws android.content.pm.PackageManager.NameNotFoundException {
label0:
        {
            int ai[];
            int i;
            try {
                ai = mPM.getPackageGids(s);
                if(ai == null)
                    break label0;
                i = ai.length;
            }
            catch(RemoteException remoteexception) {
                throw new RuntimeException("Package manager has died", remoteexception);
            }
            if(i <= 0)
                break MISSING_BLOCK_LABEL_38;
        }
        return ai;
        throw new android.content.pm.PackageManager.NameNotFoundException(s);
    }

    public PackageInfo getPackageInfo(String s, int i) throws android.content.pm.PackageManager.NameNotFoundException {
        PackageInfo packageinfo;
        try {
            packageinfo = mPM.getPackageInfo(s, i, UserId.myUserId());
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("Package manager has died", remoteexception);
        }
        if(packageinfo != null)
            return packageinfo;
        else
            throw new android.content.pm.PackageManager.NameNotFoundException(s);
    }

    public void getPackageSizeInfo(String s, IPackageStatsObserver ipackagestatsobserver) {
        mPM.getPackageSizeInfo(s, ipackagestatsobserver);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String[] getPackagesForUid(int i) {
        String as[];
        try {
            as = mPM.getPackagesForUid(i);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("Package manager has died", remoteexception);
        }
        return as;
    }

    public PermissionGroupInfo getPermissionGroupInfo(String s, int i) throws android.content.pm.PackageManager.NameNotFoundException {
        PermissionGroupInfo permissiongroupinfo;
        try {
            permissiongroupinfo = mPM.getPermissionGroupInfo(s, i);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("Package manager has died", remoteexception);
        }
        if(permissiongroupinfo != null)
            return permissiongroupinfo;
        else
            throw new android.content.pm.PackageManager.NameNotFoundException(s);
    }

    public PermissionInfo getPermissionInfo(String s, int i) throws android.content.pm.PackageManager.NameNotFoundException {
        PermissionInfo permissioninfo;
        try {
            permissioninfo = mPM.getPermissionInfo(s, i);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("Package manager has died", remoteexception);
        }
        if(permissioninfo != null)
            return permissioninfo;
        else
            throw new android.content.pm.PackageManager.NameNotFoundException(s);
    }

    public int getPreferredActivities(List list, List list1, String s) {
        int j = mPM.getPreferredActivities(list, list1, s);
        int i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        i = 0;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public List getPreferredPackages(int i) {
        List list = mPM.getPreferredPackages(i);
        Object obj = list;
_L2:
        return ((List) (obj));
        RemoteException remoteexception;
        remoteexception;
        obj = new ArrayList();
        if(true) goto _L2; else goto _L1
_L1:
    }

    public ProviderInfo getProviderInfo(ComponentName componentname, int i) throws android.content.pm.PackageManager.NameNotFoundException {
        ProviderInfo providerinfo;
        try {
            providerinfo = mPM.getProviderInfo(componentname, i, UserId.myUserId());
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("Package manager has died", remoteexception);
        }
        if(providerinfo != null)
            return providerinfo;
        else
            throw new android.content.pm.PackageManager.NameNotFoundException(componentname.toString());
    }

    public ActivityInfo getReceiverInfo(ComponentName componentname, int i) throws android.content.pm.PackageManager.NameNotFoundException {
        ActivityInfo activityinfo;
        try {
            activityinfo = mPM.getReceiverInfo(componentname, i, UserId.myUserId());
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("Package manager has died", remoteexception);
        }
        if(activityinfo != null)
            return activityinfo;
        else
            throw new android.content.pm.PackageManager.NameNotFoundException(componentname.toString());
    }

    public Resources getResourcesForActivity(ComponentName componentname) throws android.content.pm.PackageManager.NameNotFoundException {
        return getResourcesForApplication(((ComponentInfo) (getActivityInfo(componentname, 0))).applicationInfo);
    }

    public Resources getResourcesForApplication(ApplicationInfo applicationinfo) throws android.content.pm.PackageManager.NameNotFoundException {
        Resources resources;
        if(((PackageItemInfo) (applicationinfo)).packageName.equals("system")) {
            resources = mContext.mMainThread.getSystemContext().getResources();
        } else {
            ActivityThread activitythread = mContext.mMainThread;
            String s = ((PackageItemInfo) (applicationinfo)).packageName;
            String s1;
            if(applicationinfo.uid == Process.myUid())
                s1 = applicationinfo.sourceDir;
            else
                s1 = applicationinfo.publicSourceDir;
            resources = activitythread.getTopLevelResources(s, s1, mContext.mPackageInfo);
            if(resources == null)
                throw new android.content.pm.PackageManager.NameNotFoundException((new StringBuilder()).append("Unable to open ").append(applicationinfo.publicSourceDir).toString());
        }
        return resources;
    }

    public Resources getResourcesForApplication(String s) throws android.content.pm.PackageManager.NameNotFoundException {
        return getResourcesForApplication(getApplicationInfo(s, 0));
    }

    public ServiceInfo getServiceInfo(ComponentName componentname, int i) throws android.content.pm.PackageManager.NameNotFoundException {
        ServiceInfo serviceinfo;
        try {
            serviceinfo = mPM.getServiceInfo(componentname, i, UserId.myUserId());
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("Package manager has died", remoteexception);
        }
        if(serviceinfo != null)
            return serviceinfo;
        else
            throw new android.content.pm.PackageManager.NameNotFoundException(componentname.toString());
    }

    public FeatureInfo[] getSystemAvailableFeatures() {
        FeatureInfo afeatureinfo[];
        try {
            afeatureinfo = mPM.getSystemAvailableFeatures();
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("Package manager has died", remoteexception);
        }
        return afeatureinfo;
    }

    public String[] getSystemSharedLibraryNames() {
        String as[];
        try {
            as = mPM.getSystemSharedLibraryNames();
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("Package manager has died", remoteexception);
        }
        return as;
    }

    public CharSequence getText(String s, int i, ApplicationInfo applicationinfo) {
        CharSequence charsequence;
        ResourceName resourcename;
        CharSequence charsequence1;
        charsequence = null;
        resourcename = new ResourceName(s, i);
        charsequence1 = getCachedString(resourcename);
        if(charsequence1 == null) goto _L2; else goto _L1
_L1:
        charsequence = charsequence1;
_L4:
        return charsequence;
_L2:
        if(applicationinfo == null) {
            CharSequence charsequence2;
            ApplicationInfo applicationinfo1;
            try {
                applicationinfo1 = getApplicationInfo(s, 0);
            }
            catch(android.content.pm.PackageManager.NameNotFoundException namenotfoundexception1) {
                continue; /* Loop/switch isn't completed */
            }
            applicationinfo = applicationinfo1;
        }
        charsequence2 = getResourcesForApplication(applicationinfo).getText(i);
        putCachedString(resourcename, charsequence2);
        charsequence = charsequence2;
        continue; /* Loop/switch isn't completed */
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        Log.w("PackageManager", (new StringBuilder()).append("Failure retrieving resources for").append(((PackageItemInfo) (applicationinfo)).packageName).toString());
        continue; /* Loop/switch isn't completed */
        RuntimeException runtimeexception;
        runtimeexception;
        Log.w("PackageManager", (new StringBuilder()).append("Failure retrieving text 0x").append(Integer.toHexString(i)).append(" in package ").append(s).toString(), runtimeexception);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int getUidForSharedUser(String s) throws android.content.pm.PackageManager.NameNotFoundException {
        int i;
        try {
            i = mPM.getUidForSharedUser(s);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("Package manager has died", remoteexception);
        }
        if(i != -1)
            return i;
        else
            throw new android.content.pm.PackageManager.NameNotFoundException((new StringBuilder()).append("No shared userid for user:").append(s).toString());
    }

    public UserInfo getUser(int i) {
        UserInfo userinfo1 = mPM.getUser(i);
        UserInfo userinfo = userinfo1;
_L2:
        return userinfo;
        RemoteException remoteexception;
        remoteexception;
        userinfo = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public List getUsers() {
        List list = mPM.getUsers();
        Object obj = list;
_L2:
        return ((List) (obj));
        RemoteException remoteexception;
        remoteexception;
        obj = new ArrayList();
        ((ArrayList) (obj)).add(new UserInfo(0, "Root!", 3));
        if(true) goto _L2; else goto _L1
_L1:
    }

    public VerifierDeviceIdentity getVerifierDeviceIdentity() {
        VerifierDeviceIdentity verifierdeviceidentity1 = mPM.getVerifierDeviceIdentity();
        VerifierDeviceIdentity verifierdeviceidentity = verifierdeviceidentity1;
_L2:
        return verifierdeviceidentity;
        RemoteException remoteexception;
        remoteexception;
        verifierdeviceidentity = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public XmlResourceParser getXml(String s, int i, ApplicationInfo applicationinfo) {
        XmlResourceParser xmlresourceparser = null;
        if(applicationinfo == null) {
            XmlResourceParser xmlresourceparser1;
            ApplicationInfo applicationinfo1;
            try {
                applicationinfo1 = getApplicationInfo(s, 0);
            }
            catch(android.content.pm.PackageManager.NameNotFoundException namenotfoundexception1) {
                continue; /* Loop/switch isn't completed */
            }
            applicationinfo = applicationinfo1;
        }
        xmlresourceparser1 = getResourcesForApplication(applicationinfo).getXml(i);
        xmlresourceparser = xmlresourceparser1;
_L2:
        return xmlresourceparser;
        RuntimeException runtimeexception;
        runtimeexception;
        Log.w("PackageManager", (new StringBuilder()).append("Failure retrieving xml 0x").append(Integer.toHexString(i)).append(" in package ").append(s).toString(), runtimeexception);
        continue; /* Loop/switch isn't completed */
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        Log.w("PackageManager", (new StringBuilder()).append("Failure retrieving resources for ").append(((PackageItemInfo) (applicationinfo)).packageName).toString());
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void grantPermission(String s, String s1) {
        try {
            mPM.grantPermission(s, s1);
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("Package manager has died", remoteexception);
        }
    }

    public boolean hasSystemFeature(String s) {
        boolean flag;
        try {
            flag = mPM.hasSystemFeature(s);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("Package manager has died", remoteexception);
        }
        return flag;
    }

    public void installPackage(Uri uri, IPackageInstallObserver ipackageinstallobserver, int i, String s) {
        mPM.installPackage(uri, ipackageinstallobserver, i, s);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void installPackageWithVerification(Uri uri, IPackageInstallObserver ipackageinstallobserver, int i, String s, Uri uri1, ManifestDigest manifestdigest, ContainerEncryptionParams containerencryptionparams) {
        mPM.installPackageWithVerification(uri, ipackageinstallobserver, i, s, uri1, manifestdigest, containerencryptionparams);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean isSafeMode() {
        boolean flag = true;
        if(mCachedSafeMode >= 0) goto _L2; else goto _L1
_L1:
        int j;
        if(!mPM.isSafeMode())
            break MISSING_BLOCK_LABEL_41;
        j = ((flag) ? 1 : 0);
_L3:
        mCachedSafeMode = j;
_L2:
        int i = mCachedSafeMode;
        if(i == 0)
            flag = false;
        return flag;
        j = 0;
          goto _L3
        RemoteException remoteexception;
        remoteexception;
        throw new RuntimeException("Package manager has died", remoteexception);
    }

    public void movePackage(String s, IPackageMoveObserver ipackagemoveobserver, int i) {
        mPM.movePackage(s, ipackagemoveobserver, i);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public List queryBroadcastReceivers(Intent intent, int i) {
        List list;
        try {
            list = mPM.queryIntentReceivers(intent, intent.resolveTypeIfNeeded(mContext.getContentResolver()), i, UserId.myUserId());
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("Package manager has died", remoteexception);
        }
        return list;
    }

    public List queryContentProviders(String s, int i, int j) {
        List list;
        try {
            list = mPM.queryContentProviders(s, i, j);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("Package manager has died", remoteexception);
        }
        return list;
    }

    public List queryInstrumentation(String s, int i) {
        List list;
        try {
            list = mPM.queryInstrumentation(s, i);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("Package manager has died", remoteexception);
        }
        return list;
    }

    public List queryIntentActivities(Intent intent, int i) {
        List list;
        try {
            list = mPM.queryIntentActivities(intent, intent.resolveTypeIfNeeded(mContext.getContentResolver()), i, UserId.myUserId());
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("Package manager has died", remoteexception);
        }
        return list;
    }

    public List queryIntentActivityOptions(ComponentName componentname, Intent aintent[], Intent intent, int i) {
        android.content.ContentResolver contentresolver = mContext.getContentResolver();
        String as[] = null;
        if(aintent != null) {
            int j = aintent.length;
            for(int k = 0; k < j; k++) {
                Intent intent1 = aintent[k];
                if(intent1 == null)
                    continue;
                String s = intent1.resolveTypeIfNeeded(contentresolver);
                if(s == null)
                    continue;
                if(as == null)
                    as = new String[j];
                as[k] = s;
            }

        }
        List list;
        try {
            list = mPM.queryIntentActivityOptions(componentname, aintent, as, intent, intent.resolveTypeIfNeeded(contentresolver), i, UserId.myUserId());
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("Package manager has died", remoteexception);
        }
        return list;
    }

    public List queryIntentServices(Intent intent, int i) {
        List list;
        try {
            list = mPM.queryIntentServices(intent, intent.resolveTypeIfNeeded(mContext.getContentResolver()), i, UserId.myUserId());
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("Package manager has died", remoteexception);
        }
        return list;
    }

    public List queryPermissionsByGroup(String s, int i) throws android.content.pm.PackageManager.NameNotFoundException {
        List list;
        try {
            list = mPM.queryPermissionsByGroup(s, i);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("Package manager has died", remoteexception);
        }
        if(list != null)
            return list;
        else
            throw new android.content.pm.PackageManager.NameNotFoundException(s);
    }

    public void removePackageFromPreferred(String s) {
        mPM.removePackageFromPreferred(s);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void removePermission(String s) {
        try {
            mPM.removePermission(s);
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("Package manager has died", remoteexception);
        }
    }

    public boolean removeUser(int i) {
        boolean flag1 = mPM.removeUser(i);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void replacePreferredActivity(IntentFilter intentfilter, int i, ComponentName acomponentname[], ComponentName componentname) {
        mPM.replacePreferredActivity(intentfilter, i, acomponentname, componentname);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public ResolveInfo resolveActivity(Intent intent, int i) {
        ResolveInfo resolveinfo;
        try {
            resolveinfo = mPM.resolveIntent(intent, intent.resolveTypeIfNeeded(mContext.getContentResolver()), i, UserId.myUserId());
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("Package manager has died", remoteexception);
        }
        return resolveinfo;
    }

    public ProviderInfo resolveContentProvider(String s, int i) {
        ProviderInfo providerinfo;
        try {
            providerinfo = mPM.resolveContentProvider(s, i, UserId.myUserId());
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("Package manager has died", remoteexception);
        }
        return providerinfo;
    }

    public ResolveInfo resolveService(Intent intent, int i) {
        ResolveInfo resolveinfo;
        try {
            resolveinfo = mPM.resolveService(intent, intent.resolveTypeIfNeeded(mContext.getContentResolver()), i, UserId.myUserId());
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("Package manager has died", remoteexception);
        }
        return resolveinfo;
    }

    public void revokePermission(String s, String s1) {
        try {
            mPM.revokePermission(s, s1);
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("Package manager has died", remoteexception);
        }
    }

    public void setApplicationEnabledSetting(String s, int i, int j) {
        mPM.setApplicationEnabledSetting(s, i, j, UserId.myUserId());
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void setComponentEnabledSetting(ComponentName componentname, int i, int j) {
        mPM.setComponentEnabledSetting(componentname, i, j, UserId.myUserId());
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void setInstallerPackageName(String s, String s1) {
        mPM.setInstallerPackageName(s, s1);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void updateUserFlags(int i, int j) {
    }

    public void updateUserName(int i, String s) {
        mPM.updateUserName(i, s);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void verifyPendingInstall(int i, int j) {
        mPM.verifyPendingInstall(i, j);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private static final boolean DEBUG = false;
    private static final boolean DEBUG_ICONS = false;
    private static final String TAG = "ApplicationPackageManager";
    private static HashMap sIconCache = new HashMap();
    private static HashMap sStringCache = new HashMap();
    private static final Object sSync = new Object();
    int mCachedSafeMode;
    private final ContextImpl mContext;
    private final IPackageManager mPM;

}

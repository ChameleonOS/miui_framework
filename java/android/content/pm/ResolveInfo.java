// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.pm;

import android.app.MiuiThemeHelper;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Printer;
import java.text.Collator;
import java.util.Comparator;

// Referenced classes of package android.content.pm:
//            ActivityInfo, ServiceInfo, ComponentInfo, PackageItemInfo, 
//            PackageManager, ApplicationInfo

public class ResolveInfo
    implements Parcelable {
    public static class DisplayNameComparator
        implements Comparator {

        public final int compare(ResolveInfo resolveinfo, ResolveInfo resolveinfo1) {
            Object obj = resolveinfo.loadLabel(mPM);
            if(obj == null)
                obj = ((PackageItemInfo) (resolveinfo.activityInfo)).name;
            Object obj1 = resolveinfo1.loadLabel(mPM);
            if(obj1 == null)
                obj1 = ((PackageItemInfo) (resolveinfo1.activityInfo)).name;
            return sCollator.compare(obj.toString(), obj1.toString());
        }

        public volatile int compare(Object obj, Object obj1) {
            return compare((ResolveInfo)obj, (ResolveInfo)obj1);
        }

        private PackageManager mPM;
        private final Collator sCollator = Collator.getInstance();

        public DisplayNameComparator(PackageManager packagemanager) {
            mPM = packagemanager;
        }
    }


    public ResolveInfo() {
        specificIndex = -1;
    }

    private ResolveInfo(Parcel parcel) {
        specificIndex = -1;
        parcel.readInt();
        JVM INSTR tableswitch 1 2: default 36
    //                   1 156
    //                   2 180;
           goto _L1 _L2 _L3
_L3:
        break MISSING_BLOCK_LABEL_180;
_L1:
        activityInfo = null;
        serviceInfo = null;
_L4:
        if(parcel.readInt() != 0)
            filter = (IntentFilter)IntentFilter.CREATOR.createFromParcel(parcel);
        priority = parcel.readInt();
        preferredOrder = parcel.readInt();
        match = parcel.readInt();
        specificIndex = parcel.readInt();
        labelRes = parcel.readInt();
        nonLocalizedLabel = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        icon = parcel.readInt();
        resolvePackageName = parcel.readString();
        boolean flag;
        if(parcel.readInt() != 0)
            flag = true;
        else
            flag = false;
        system = flag;
        return;
_L2:
        activityInfo = (ActivityInfo)ActivityInfo.CREATOR.createFromParcel(parcel);
        serviceInfo = null;
          goto _L4
        serviceInfo = (ServiceInfo)ServiceInfo.CREATOR.createFromParcel(parcel);
        activityInfo = null;
          goto _L4
    }


    private Drawable loadDrawableFromTheme(PackageManager packagemanager, String s, ApplicationInfo applicationinfo) {
        Object obj;
        if(activityInfo != null)
            obj = activityInfo;
        else
            obj = serviceInfo;
        return MiuiThemeHelper.getDrawable(packagemanager, s, icon, applicationinfo, ((PackageItemInfo) (obj)), MiuiThemeHelper.isCustomizedIcon(filter));
    }

    public int describeContents() {
        return 0;
    }

    public void dump(Printer printer, String s) {
        if(filter != null) {
            printer.println((new StringBuilder()).append(s).append("Filter:").toString());
            filter.dump(printer, (new StringBuilder()).append(s).append("  ").toString());
        }
        printer.println((new StringBuilder()).append(s).append("priority=").append(priority).append(" preferredOrder=").append(preferredOrder).append(" match=0x").append(Integer.toHexString(match)).append(" specificIndex=").append(specificIndex).append(" isDefault=").append(isDefault).toString());
        if(resolvePackageName != null)
            printer.println((new StringBuilder()).append(s).append("resolvePackageName=").append(resolvePackageName).toString());
        if(labelRes != 0 || nonLocalizedLabel != null || icon != 0)
            printer.println((new StringBuilder()).append(s).append("labelRes=0x").append(Integer.toHexString(labelRes)).append(" nonLocalizedLabel=").append(nonLocalizedLabel).append(" icon=0x").append(Integer.toHexString(icon)).toString());
        if(activityInfo == null) goto _L2; else goto _L1
_L1:
        printer.println((new StringBuilder()).append(s).append("ActivityInfo:").toString());
        activityInfo.dump(printer, (new StringBuilder()).append(s).append("  ").toString());
_L4:
        return;
_L2:
        if(serviceInfo != null) {
            printer.println((new StringBuilder()).append(s).append("ServiceInfo:").toString());
            serviceInfo.dump(printer, (new StringBuilder()).append(s).append("  ").toString());
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public final int getIconResource() {
        int i;
        if(icon != 0)
            i = icon;
        else
        if(activityInfo != null)
            i = activityInfo.getIconResource();
        else
        if(serviceInfo != null)
            i = serviceInfo.getIconResource();
        else
            i = 0;
        return i;
    }

    public Drawable loadIcon(PackageManager packagemanager) {
        if(resolvePackageName == null || icon == 0) goto _L2; else goto _L1
_L1:
        Drawable drawable = loadDrawableFromTheme(packagemanager, resolvePackageName, null);
        if(drawable == null) goto _L2; else goto _L3
_L3:
        return drawable;
_L2:
        Object obj;
        ApplicationInfo applicationinfo;
        if(activityInfo != null)
            obj = activityInfo;
        else
            obj = serviceInfo;
        applicationinfo = ((ComponentInfo) (obj)).applicationInfo;
        if(icon != 0) {
            drawable = loadDrawableFromTheme(packagemanager, ((PackageItemInfo) (obj)).packageName, applicationinfo);
            if(drawable != null)
                continue; /* Loop/switch isn't completed */
        }
        drawable = ((ComponentInfo) (obj)).loadIcon(packagemanager);
        if(true) goto _L3; else goto _L4
_L4:
    }

    public CharSequence loadLabel(PackageManager packagemanager) {
        if(nonLocalizedLabel == null) goto _L2; else goto _L1
_L1:
        Object obj1 = nonLocalizedLabel;
_L4:
        return ((CharSequence) (obj1));
_L2:
        if(resolvePackageName != null && labelRes != 0) {
            CharSequence charsequence1 = packagemanager.getText(resolvePackageName, labelRes, null);
            if(charsequence1 != null) {
                obj1 = charsequence1.toString().trim();
                continue; /* Loop/switch isn't completed */
            }
        }
        Object obj;
        ApplicationInfo applicationinfo;
        if(activityInfo != null)
            obj = activityInfo;
        else
            obj = serviceInfo;
        applicationinfo = ((ComponentInfo) (obj)).applicationInfo;
        if(labelRes != 0) {
            CharSequence charsequence = packagemanager.getText(((PackageItemInfo) (obj)).packageName, labelRes, applicationinfo);
            if(charsequence != null) {
                obj1 = charsequence.toString().trim();
                continue; /* Loop/switch isn't completed */
            }
        }
        obj1 = ((ComponentInfo) (obj)).loadLabel(packagemanager);
        if(obj1 != null)
            obj1 = obj1.toString().trim();
        if(true) goto _L4; else goto _L3
_L3:
    }

    public String toString() {
        Object obj;
        if(activityInfo != null)
            obj = activityInfo;
        else
            obj = serviceInfo;
        return (new StringBuilder()).append("ResolveInfo{").append(Integer.toHexString(System.identityHashCode(this))).append(" ").append(((PackageItemInfo) (obj)).name).append(" p=").append(priority).append(" o=").append(preferredOrder).append(" m=0x").append(Integer.toHexString(match)).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int j = 1;
        if(activityInfo != null) {
            parcel.writeInt(j);
            activityInfo.writeToParcel(parcel, i);
        } else
        if(serviceInfo != null) {
            parcel.writeInt(2);
            serviceInfo.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
        if(filter != null) {
            parcel.writeInt(j);
            filter.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(priority);
        parcel.writeInt(preferredOrder);
        parcel.writeInt(match);
        parcel.writeInt(specificIndex);
        parcel.writeInt(labelRes);
        TextUtils.writeToParcel(nonLocalizedLabel, parcel, i);
        parcel.writeInt(icon);
        parcel.writeString(resolvePackageName);
        if(!system)
            j = 0;
        parcel.writeInt(j);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ResolveInfo createFromParcel(Parcel parcel) {
            return new ResolveInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public ResolveInfo[] newArray(int i) {
            return new ResolveInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public ActivityInfo activityInfo;
    public IntentFilter filter;
    public int icon;
    public boolean isDefault;
    public int labelRes;
    public int match;
    public CharSequence nonLocalizedLabel;
    public int preferredOrder;
    public int priority;
    public String resolvePackageName;
    public ServiceInfo serviceInfo;
    public int specificIndex;
    public boolean system;

}

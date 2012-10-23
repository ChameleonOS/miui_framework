// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.pm;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.util.Printer;

// Referenced classes of package android.content.pm:
//            PackageItemInfo, ApplicationInfo, PackageManager

public class ComponentInfo extends PackageItemInfo {

    public ComponentInfo() {
        enabled = true;
        exported = false;
    }

    public ComponentInfo(ComponentInfo componentinfo) {
        super(componentinfo);
        enabled = true;
        exported = false;
        applicationInfo = componentinfo.applicationInfo;
        processName = componentinfo.processName;
        descriptionRes = componentinfo.descriptionRes;
        enabled = componentinfo.enabled;
        exported = componentinfo.exported;
    }

    protected ComponentInfo(Parcel parcel) {
        boolean flag = true;
        super(parcel);
        enabled = flag;
        exported = false;
        applicationInfo = (ApplicationInfo)ApplicationInfo.CREATOR.createFromParcel(parcel);
        processName = parcel.readString();
        descriptionRes = parcel.readInt();
        boolean flag1;
        if(parcel.readInt() != 0)
            flag1 = flag;
        else
            flag1 = false;
        enabled = flag1;
        if(parcel.readInt() == 0)
            flag = false;
        exported = flag;
    }

    protected void dumpBack(Printer printer, String s) {
        if(applicationInfo != null) {
            printer.println((new StringBuilder()).append(s).append("ApplicationInfo:").toString());
            applicationInfo.dump(printer, (new StringBuilder()).append(s).append("  ").toString());
        } else {
            printer.println((new StringBuilder()).append(s).append("ApplicationInfo: null").toString());
        }
        super.dumpBack(printer, s);
    }

    protected void dumpFront(Printer printer, String s) {
        super.dumpFront(printer, s);
        printer.println((new StringBuilder()).append(s).append("enabled=").append(enabled).append(" exported=").append(exported).append(" processName=").append(processName).toString());
        if(descriptionRes != 0)
            printer.println((new StringBuilder()).append(s).append("description=").append(descriptionRes).toString());
    }

    protected ApplicationInfo getApplicationInfo() {
        return applicationInfo;
    }

    public final int getIconResource() {
        int i;
        if(super.icon != 0)
            i = super.icon;
        else
            i = ((PackageItemInfo) (applicationInfo)).icon;
        return i;
    }

    public boolean isEnabled() {
        boolean flag;
        if(enabled && applicationInfo.enabled)
            flag = true;
        else
            flag = false;
        return flag;
    }

    protected Drawable loadDefaultIcon(PackageManager packagemanager) {
        return applicationInfo.loadIcon(packagemanager);
    }

    protected Drawable loadDefaultLogo(PackageManager packagemanager) {
        return applicationInfo.loadLogo(packagemanager);
    }

    public CharSequence loadLabel(PackageManager packagemanager) {
        if(super.nonLocalizedLabel == null) goto _L2; else goto _L1
_L1:
        Object obj = super.nonLocalizedLabel;
_L4:
        return ((CharSequence) (obj));
_L2:
        ApplicationInfo applicationinfo = applicationInfo;
        if(super.labelRes != 0) {
            obj = packagemanager.getText(super.packageName, super.labelRes, applicationinfo);
            if(obj != null)
                continue; /* Loop/switch isn't completed */
        }
        if(((PackageItemInfo) (applicationinfo)).nonLocalizedLabel != null) {
            obj = ((PackageItemInfo) (applicationinfo)).nonLocalizedLabel;
            continue; /* Loop/switch isn't completed */
        }
        if(((PackageItemInfo) (applicationinfo)).labelRes != 0) {
            obj = packagemanager.getText(super.packageName, ((PackageItemInfo) (applicationinfo)).labelRes, applicationinfo);
            if(obj != null)
                continue; /* Loop/switch isn't completed */
        }
        obj = super.name;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void writeToParcel(Parcel parcel, int i) {
        int j = 1;
        super.writeToParcel(parcel, i);
        applicationInfo.writeToParcel(parcel, i);
        parcel.writeString(processName);
        parcel.writeInt(descriptionRes);
        int k;
        if(enabled)
            k = j;
        else
            k = 0;
        parcel.writeInt(k);
        if(!exported)
            j = 0;
        parcel.writeInt(j);
    }

    public ApplicationInfo applicationInfo;
    public int descriptionRes;
    public boolean enabled;
    public boolean exported;
    public String processName;
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.pm;

import android.app.MiuiThemeHelper;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Printer;
import java.text.Collator;
import java.util.Comparator;

// Referenced classes of package android.content.pm:
//            PackageManager, ApplicationInfo

public class PackageItemInfo {
    public static class DisplayNameComparator
        implements Comparator {

        public final int compare(PackageItemInfo packageiteminfo, PackageItemInfo packageiteminfo1) {
            Object obj = packageiteminfo.loadLabel(mPM);
            if(obj == null)
                obj = packageiteminfo.name;
            Object obj1 = packageiteminfo1.loadLabel(mPM);
            if(obj1 == null)
                obj1 = packageiteminfo1.name;
            return sCollator.compare(obj.toString(), obj1.toString());
        }

        public volatile int compare(Object obj, Object obj1) {
            return compare((PackageItemInfo)obj, (PackageItemInfo)obj1);
        }

        private PackageManager mPM;
        private final Collator sCollator = Collator.getInstance();

        public DisplayNameComparator(PackageManager packagemanager) {
            mPM = packagemanager;
        }
    }


    public PackageItemInfo() {
    }

    public PackageItemInfo(PackageItemInfo packageiteminfo) {
        name = packageiteminfo.name;
        if(name != null)
            name = name.trim();
        packageName = packageiteminfo.packageName;
        labelRes = packageiteminfo.labelRes;
        nonLocalizedLabel = packageiteminfo.nonLocalizedLabel;
        if(nonLocalizedLabel != null)
            nonLocalizedLabel = nonLocalizedLabel.toString().trim();
        icon = packageiteminfo.icon;
        logo = packageiteminfo.logo;
        metaData = packageiteminfo.metaData;
    }

    protected PackageItemInfo(Parcel parcel) {
        name = parcel.readString();
        packageName = parcel.readString();
        labelRes = parcel.readInt();
        nonLocalizedLabel = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        icon = parcel.readInt();
        logo = parcel.readInt();
        metaData = parcel.readBundle();
    }

    protected void dumpBack(Printer printer, String s) {
    }

    protected void dumpFront(Printer printer, String s) {
        if(name != null)
            printer.println((new StringBuilder()).append(s).append("name=").append(name).toString());
        printer.println((new StringBuilder()).append(s).append("packageName=").append(packageName).toString());
        if(labelRes != 0 || nonLocalizedLabel != null || icon != 0)
            printer.println((new StringBuilder()).append(s).append("labelRes=0x").append(Integer.toHexString(labelRes)).append(" nonLocalizedLabel=").append(nonLocalizedLabel).append(" icon=0x").append(Integer.toHexString(icon)).toString());
    }

    protected ApplicationInfo getApplicationInfo() {
        return null;
    }

    protected Drawable loadDefaultIcon(PackageManager packagemanager) {
        return packagemanager.getDefaultActivityIcon();
    }

    protected Drawable loadDefaultLogo(PackageManager packagemanager) {
        return null;
    }

    public Drawable loadIcon(PackageManager packagemanager) {
        if(icon == 0) goto _L2; else goto _L1
_L1:
        Drawable drawable = MiuiThemeHelper.getDrawable(packagemanager, packageName, icon, getApplicationInfo(), name);
        if(drawable == null) goto _L2; else goto _L3
_L3:
        return drawable;
_L2:
        drawable = loadDefaultIcon(packagemanager);
        if(true) goto _L3; else goto _L4
_L4:
    }

    public CharSequence loadLabel(PackageManager packagemanager) {
        if(nonLocalizedLabel == null) goto _L2; else goto _L1
_L1:
        Object obj = nonLocalizedLabel;
_L4:
        return ((CharSequence) (obj));
_L2:
        if(labelRes != 0) {
            CharSequence charsequence = packagemanager.getText(packageName, labelRes, getApplicationInfo());
            if(charsequence != null) {
                obj = charsequence.toString().trim();
                continue; /* Loop/switch isn't completed */
            }
        }
        if(name != null)
            obj = name;
        else
            obj = packageName;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public Drawable loadLogo(PackageManager packagemanager) {
        if(logo == 0) goto _L2; else goto _L1
_L1:
        Drawable drawable = packagemanager.getDrawable(packageName, logo, getApplicationInfo());
        if(drawable == null) goto _L2; else goto _L3
_L3:
        return drawable;
_L2:
        drawable = loadDefaultLogo(packagemanager);
        if(true) goto _L3; else goto _L4
_L4:
    }

    public XmlResourceParser loadXmlMetaData(PackageManager packagemanager, String s) {
        if(metaData == null) goto _L2; else goto _L1
_L1:
        int i = metaData.getInt(s);
        if(i == 0) goto _L2; else goto _L3
_L3:
        XmlResourceParser xmlresourceparser = packagemanager.getXml(packageName, i, getApplicationInfo());
_L5:
        return xmlresourceparser;
_L2:
        xmlresourceparser = null;
        if(true) goto _L5; else goto _L4
_L4:
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(packageName);
        parcel.writeInt(labelRes);
        TextUtils.writeToParcel(nonLocalizedLabel, parcel, i);
        parcel.writeInt(icon);
        parcel.writeInt(logo);
        parcel.writeBundle(metaData);
    }

    public int icon;
    public int labelRes;
    public int logo;
    public Bundle metaData;
    public String name;
    public CharSequence nonLocalizedLabel;
    public String packageName;
}

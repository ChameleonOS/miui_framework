// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.*;
import android.content.res.*;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Printer;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public final class WallpaperInfo
    implements Parcelable {

    public WallpaperInfo(Context context, ResolveInfo resolveinfo) throws XmlPullParserException, IOException {
        ServiceInfo serviceinfo;
        PackageManager packagemanager;
        XmlResourceParser xmlresourceparser;
label0:
        {
            mService = resolveinfo;
            serviceinfo = resolveinfo.serviceInfo;
            packagemanager = context.getPackageManager();
            xmlresourceparser = null;
            try {
                xmlresourceparser = serviceinfo.loadXmlMetaData(packagemanager, "android.service.wallpaper");
                if(xmlresourceparser == null)
                    throw new XmlPullParserException("No android.service.wallpaper meta-data");
                break label0;
            }
            catch(android.content.pm.PackageManager.NameNotFoundException namenotfoundexception) { }
            finally {
                if(xmlresourceparser != null)
                    xmlresourceparser.close();
                throw exception;
            }
        }
        throw new XmlPullParserException((new StringBuilder()).append("Unable to create context for: ").append(((PackageItemInfo) (serviceinfo)).packageName).toString());
        String s;
        int j;
        int k;
        int l;
        Resources resources = packagemanager.getResourcesForApplication(((ComponentInfo) (serviceinfo)).applicationInfo);
        android.util.AttributeSet attributeset = Xml.asAttributeSet(xmlresourceparser);
        int i;
        do
            i = xmlresourceparser.next();
        while(i != 1 && i != 2);
        if(!"wallpaper".equals(xmlresourceparser.getName()))
            throw new XmlPullParserException("Meta-data does not start with wallpaper tag");
        TypedArray typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.Wallpaper);
        s = typedarray.getString(1);
        j = typedarray.getResourceId(2, -1);
        k = typedarray.getResourceId(3, -1);
        l = typedarray.getResourceId(0, -1);
        typedarray.recycle();
        if(xmlresourceparser != null)
            xmlresourceparser.close();
        mSettingsActivityName = s;
        mThumbnailResource = j;
        mAuthorResource = k;
        mDescriptionResource = l;
        return;
    }

    WallpaperInfo(Parcel parcel) {
        mSettingsActivityName = parcel.readString();
        mThumbnailResource = parcel.readInt();
        mAuthorResource = parcel.readInt();
        mDescriptionResource = parcel.readInt();
        mService = (ResolveInfo)ResolveInfo.CREATOR.createFromParcel(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void dump(Printer printer, String s) {
        printer.println((new StringBuilder()).append(s).append("Service:").toString());
        mService.dump(printer, (new StringBuilder()).append(s).append("  ").toString());
        printer.println((new StringBuilder()).append(s).append("mSettingsActivityName=").append(mSettingsActivityName).toString());
    }

    public ComponentName getComponent() {
        return new ComponentName(((PackageItemInfo) (mService.serviceInfo)).packageName, ((PackageItemInfo) (mService.serviceInfo)).name);
    }

    public String getPackageName() {
        return ((PackageItemInfo) (mService.serviceInfo)).packageName;
    }

    public ServiceInfo getServiceInfo() {
        return mService.serviceInfo;
    }

    public String getServiceName() {
        return ((PackageItemInfo) (mService.serviceInfo)).name;
    }

    public String getSettingsActivity() {
        return mSettingsActivityName;
    }

    public CharSequence loadAuthor(PackageManager packagemanager) throws android.content.res.Resources.NotFoundException {
        if(mAuthorResource <= 0)
            throw new android.content.res.Resources.NotFoundException();
        String s = mService.resolvePackageName;
        android.content.pm.ApplicationInfo applicationinfo = null;
        if(s == null) {
            s = ((PackageItemInfo) (mService.serviceInfo)).packageName;
            applicationinfo = ((ComponentInfo) (mService.serviceInfo)).applicationInfo;
        }
        return packagemanager.getText(s, mAuthorResource, applicationinfo);
    }

    public CharSequence loadDescription(PackageManager packagemanager) throws android.content.res.Resources.NotFoundException {
        String s = mService.resolvePackageName;
        android.content.pm.ApplicationInfo applicationinfo = null;
        if(s == null) {
            s = ((PackageItemInfo) (mService.serviceInfo)).packageName;
            applicationinfo = ((ComponentInfo) (mService.serviceInfo)).applicationInfo;
        }
        CharSequence charsequence;
        if(((ComponentInfo) (mService.serviceInfo)).descriptionRes != 0) {
            charsequence = packagemanager.getText(s, ((ComponentInfo) (mService.serviceInfo)).descriptionRes, applicationinfo);
        } else {
            if(mDescriptionResource <= 0)
                throw new android.content.res.Resources.NotFoundException();
            charsequence = packagemanager.getText(s, mDescriptionResource, ((ComponentInfo) (mService.serviceInfo)).applicationInfo);
        }
        return charsequence;
    }

    public Drawable loadIcon(PackageManager packagemanager) {
        return mService.loadIcon(packagemanager);
    }

    public CharSequence loadLabel(PackageManager packagemanager) {
        return mService.loadLabel(packagemanager);
    }

    public Drawable loadThumbnail(PackageManager packagemanager) {
        Drawable drawable;
        if(mThumbnailResource < 0)
            drawable = null;
        else
            drawable = packagemanager.getDrawable(((PackageItemInfo) (mService.serviceInfo)).packageName, mThumbnailResource, ((ComponentInfo) (mService.serviceInfo)).applicationInfo);
        return drawable;
    }

    public String toString() {
        return (new StringBuilder()).append("WallpaperInfo{").append(((PackageItemInfo) (mService.serviceInfo)).name).append(", settings: ").append(mSettingsActivityName).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mSettingsActivityName);
        parcel.writeInt(mThumbnailResource);
        parcel.writeInt(mAuthorResource);
        parcel.writeInt(mDescriptionResource);
        mService.writeToParcel(parcel, i);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public WallpaperInfo createFromParcel(Parcel parcel) {
            return new WallpaperInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public WallpaperInfo[] newArray(int i) {
            return new WallpaperInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    static final String TAG = "WallpaperInfo";
    final int mAuthorResource;
    final int mDescriptionResource;
    final ResolveInfo mService;
    final String mSettingsActivityName;
    final int mThumbnailResource;

}

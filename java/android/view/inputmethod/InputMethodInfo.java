// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.inputmethod;

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
import java.util.*;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package android.view.inputmethod:
//            InputMethodSubtype

public final class InputMethodInfo
    implements Parcelable {

    public InputMethodInfo(Context context, ResolveInfo resolveinfo) throws XmlPullParserException, IOException {
        this(context, resolveinfo, null);
    }

    public InputMethodInfo(Context context, ResolveInfo resolveinfo, Map map) throws XmlPullParserException, IOException {
        ServiceInfo serviceinfo;
        PackageManager packagemanager;
        XmlResourceParser xmlresourceparser;
label0:
        {
            mSubtypes = new ArrayList();
            mService = resolveinfo;
            serviceinfo = resolveinfo.serviceInfo;
            mId = (new ComponentName(((PackageItemInfo) (serviceinfo)).packageName, ((PackageItemInfo) (serviceinfo)).name)).flattenToShortString();
            mIsAuxIme = true;
            packagemanager = context.getPackageManager();
            xmlresourceparser = null;
            try {
                xmlresourceparser = serviceinfo.loadXmlMetaData(packagemanager, "android.view.im");
                if(xmlresourceparser == null)
                    throw new XmlPullParserException("No android.view.im meta-data");
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
        Resources resources = packagemanager.getResourcesForApplication(((ComponentInfo) (serviceinfo)).applicationInfo);
        android.util.AttributeSet attributeset = Xml.asAttributeSet(xmlresourceparser);
        int i;
        do
            i = xmlresourceparser.next();
        while(i != 1 && i != 2);
        if(!"input-method".equals(xmlresourceparser.getName()))
            throw new XmlPullParserException("Meta-data does not start with input-method tag");
        TypedArray typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.InputMethod);
        String s = typedarray.getString(1);
        int j = typedarray.getResourceId(0, 0);
        typedarray.recycle();
        int k = xmlresourceparser.getDepth();
        do {
            int l = xmlresourceparser.next();
            if(l == 3 && xmlresourceparser.getDepth() <= k || l == 1)
                break;
            if(l == 2) {
                if(!"subtype".equals(xmlresourceparser.getName()))
                    throw new XmlPullParserException("Meta-data in input-method does not start with subtype tag");
                TypedArray typedarray1 = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.InputMethod_Subtype);
                InputMethodSubtype inputmethodsubtype1 = new InputMethodSubtype(typedarray1.getResourceId(0, 0), typedarray1.getResourceId(1, 0), typedarray1.getString(2), typedarray1.getString(3), typedarray1.getString(4), typedarray1.getBoolean(5, false), typedarray1.getBoolean(6, false));
                if(!inputmethodsubtype1.isAuxiliary())
                    mIsAuxIme = false;
                mSubtypes.add(inputmethodsubtype1);
            }
        } while(true);
        if(xmlresourceparser != null)
            xmlresourceparser.close();
        if(mSubtypes.size() == 0)
            mIsAuxIme = false;
        if(map != null && map.containsKey(mId)) {
            List list = (List)map.get(mId);
            int i1 = list.size();
            for(int j1 = 0; j1 < i1; j1++) {
                InputMethodSubtype inputmethodsubtype = (InputMethodSubtype)list.get(j1);
                if(!mSubtypes.contains(inputmethodsubtype))
                    mSubtypes.add(inputmethodsubtype);
            }

        }
        mSettingsActivityName = s;
        mIsDefaultResId = j;
        return;
    }

    InputMethodInfo(Parcel parcel) {
        boolean flag = true;
        super();
        mSubtypes = new ArrayList();
        mId = parcel.readString();
        mSettingsActivityName = parcel.readString();
        mIsDefaultResId = parcel.readInt();
        if(parcel.readInt() != flag)
            flag = false;
        mIsAuxIme = flag;
        mService = (ResolveInfo)ResolveInfo.CREATOR.createFromParcel(parcel);
        parcel.readTypedList(mSubtypes, InputMethodSubtype.CREATOR);
    }

    public InputMethodInfo(String s, String s1, CharSequence charsequence, String s2) {
        mSubtypes = new ArrayList();
        ResolveInfo resolveinfo = new ResolveInfo();
        ServiceInfo serviceinfo = new ServiceInfo();
        ApplicationInfo applicationinfo = new ApplicationInfo();
        applicationinfo.packageName = s;
        applicationinfo.enabled = true;
        serviceinfo.applicationInfo = applicationinfo;
        serviceinfo.enabled = true;
        serviceinfo.packageName = s;
        serviceinfo.name = s1;
        serviceinfo.exported = true;
        serviceinfo.nonLocalizedLabel = charsequence;
        resolveinfo.serviceInfo = serviceinfo;
        mService = resolveinfo;
        mId = (new ComponentName(((PackageItemInfo) (serviceinfo)).packageName, ((PackageItemInfo) (serviceinfo)).name)).flattenToShortString();
        mSettingsActivityName = s2;
        mIsDefaultResId = 0;
        mIsAuxIme = false;
    }

    public int describeContents() {
        return 0;
    }

    public void dump(Printer printer, String s) {
        printer.println((new StringBuilder()).append(s).append("mId=").append(mId).append(" mSettingsActivityName=").append(mSettingsActivityName).toString());
        printer.println((new StringBuilder()).append(s).append("mIsDefaultResId=0x").append(Integer.toHexString(mIsDefaultResId)).toString());
        printer.println((new StringBuilder()).append(s).append("Service:").toString());
        mService.dump(printer, (new StringBuilder()).append(s).append("  ").toString());
    }

    public boolean equals(Object obj) {
        boolean flag = false;
        if(obj != this) goto _L2; else goto _L1
_L1:
        flag = true;
_L4:
        return flag;
_L2:
        if(obj != null && (obj instanceof InputMethodInfo)) {
            InputMethodInfo inputmethodinfo = (InputMethodInfo)obj;
            flag = mId.equals(inputmethodinfo.mId);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public ComponentName getComponent() {
        return new ComponentName(((PackageItemInfo) (mService.serviceInfo)).packageName, ((PackageItemInfo) (mService.serviceInfo)).name);
    }

    public String getId() {
        return mId;
    }

    public int getIsDefaultResourceId() {
        return mIsDefaultResId;
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

    public InputMethodSubtype getSubtypeAt(int i) {
        return (InputMethodSubtype)mSubtypes.get(i);
    }

    public int getSubtypeCount() {
        return mSubtypes.size();
    }

    public int hashCode() {
        return mId.hashCode();
    }

    public boolean isAuxiliaryIme() {
        return mIsAuxIme;
    }

    public Drawable loadIcon(PackageManager packagemanager) {
        return mService.loadIcon(packagemanager);
    }

    public CharSequence loadLabel(PackageManager packagemanager) {
        return mService.loadLabel(packagemanager);
    }

    public String toString() {
        return (new StringBuilder()).append("InputMethodInfo{").append(mId).append(", settings: ").append(mSettingsActivityName).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mId);
        parcel.writeString(mSettingsActivityName);
        parcel.writeInt(mIsDefaultResId);
        int j;
        if(mIsAuxIme)
            j = 1;
        else
            j = 0;
        parcel.writeInt(j);
        mService.writeToParcel(parcel, i);
        parcel.writeTypedList(mSubtypes);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public InputMethodInfo createFromParcel(Parcel parcel) {
            return new InputMethodInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public InputMethodInfo[] newArray(int i) {
            return new InputMethodInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    static final String TAG = "InputMethodInfo";
    final String mId;
    private boolean mIsAuxIme;
    final int mIsDefaultResId;
    final ResolveInfo mService;
    final String mSettingsActivityName;
    private final ArrayList mSubtypes;

}

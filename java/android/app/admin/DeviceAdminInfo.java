// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app.admin;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.*;
import android.content.res.*;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.*;

public final class DeviceAdminInfo
    implements Parcelable {
    public static class PolicyInfo {

        public final int description;
        public final int ident;
        public final int label;
        public final String tag;

        public PolicyInfo(int i, String s, int j, int k) {
            ident = i;
            tag = s;
            label = j;
            description = k;
        }
    }


    public DeviceAdminInfo(Context context, ResolveInfo resolveinfo) throws XmlPullParserException, IOException {
        ActivityInfo activityinfo;
        PackageManager packagemanager;
        XmlResourceParser xmlresourceparser;
label0:
        {
            mReceiver = resolveinfo;
            activityinfo = resolveinfo.activityInfo;
            packagemanager = context.getPackageManager();
            xmlresourceparser = null;
            try {
                xmlresourceparser = activityinfo.loadXmlMetaData(packagemanager, "android.app.device_admin");
                if(xmlresourceparser == null)
                    throw new XmlPullParserException("No android.app.device_admin meta-data");
                break label0;
            }
            catch(android.content.pm.PackageManager.NameNotFoundException namenotfoundexception) { }
            finally {
                if(xmlresourceparser != null)
                    xmlresourceparser.close();
                throw exception;
            }
        }
        throw new XmlPullParserException((new StringBuilder()).append("Unable to create context for: ").append(((PackageItemInfo) (activityinfo)).packageName).toString());
label1:
        {
            Resources resources = packagemanager.getResourcesForApplication(((ComponentInfo) (activityinfo)).applicationInfo);
            android.util.AttributeSet attributeset = Xml.asAttributeSet(xmlresourceparser);
            int i;
            do
                i = xmlresourceparser.next();
            while(i != 1 && i != 2);
            if(!"device-admin".equals(xmlresourceparser.getName()))
                throw new XmlPullParserException("Meta-data does not start with device-admin tag");
            TypedArray typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.DeviceAdmin);
            mVisible = typedarray.getBoolean(0, true);
            typedarray.recycle();
            int j = xmlresourceparser.getDepth();
            do {
                int k;
                do {
                    k = xmlresourceparser.next();
                    if(k == 1 || k == 3 && xmlresourceparser.getDepth() <= j)
                        break label1;
                } while(k == 3 || k == 4 || !xmlresourceparser.getName().equals("uses-policies"));
                int l = xmlresourceparser.getDepth();
                do {
                    int i1 = xmlresourceparser.next();
                    if(i1 == 1 || i1 == 3 && xmlresourceparser.getDepth() <= l)
                        break;
                    if(i1 != 3 && i1 != 4) {
                        String s = xmlresourceparser.getName();
                        Integer integer = (Integer)sKnownPolicies.get(s);
                        if(integer != null)
                            mUsesPolicies = mUsesPolicies | 1 << integer.intValue();
                        else
                            Log.w("DeviceAdminInfo", (new StringBuilder()).append("Unknown tag under uses-policies of ").append(getComponent()).append(": ").append(s).toString());
                    }
                } while(true);
            } while(true);
        }
        if(xmlresourceparser != null)
            xmlresourceparser.close();
        return;
    }

    DeviceAdminInfo(Parcel parcel) {
        mReceiver = (ResolveInfo)ResolveInfo.CREATOR.createFromParcel(parcel);
        mUsesPolicies = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void dump(Printer printer, String s) {
        printer.println((new StringBuilder()).append(s).append("Receiver:").toString());
        mReceiver.dump(printer, (new StringBuilder()).append(s).append("  ").toString());
    }

    public ActivityInfo getActivityInfo() {
        return mReceiver.activityInfo;
    }

    public ComponentName getComponent() {
        return new ComponentName(((PackageItemInfo) (mReceiver.activityInfo)).packageName, ((PackageItemInfo) (mReceiver.activityInfo)).name);
    }

    public String getPackageName() {
        return ((PackageItemInfo) (mReceiver.activityInfo)).packageName;
    }

    public String getReceiverName() {
        return ((PackageItemInfo) (mReceiver.activityInfo)).name;
    }

    public String getTagForPolicy(int i) {
        return ((PolicyInfo)sRevKnownPolicies.get(i)).tag;
    }

    public ArrayList getUsedPolicies() {
        ArrayList arraylist = new ArrayList();
        for(int i = 0; i < sPoliciesDisplayOrder.size(); i++) {
            PolicyInfo policyinfo = (PolicyInfo)sPoliciesDisplayOrder.get(i);
            if(usesPolicy(policyinfo.ident))
                arraylist.add(policyinfo);
        }

        return arraylist;
    }

    public boolean isVisible() {
        return mVisible;
    }

    public CharSequence loadDescription(PackageManager packagemanager) throws android.content.res.Resources.NotFoundException {
        if(((ComponentInfo) (mReceiver.activityInfo)).descriptionRes != 0) {
            String s = mReceiver.resolvePackageName;
            android.content.pm.ApplicationInfo applicationinfo = null;
            if(s == null) {
                s = ((PackageItemInfo) (mReceiver.activityInfo)).packageName;
                applicationinfo = ((ComponentInfo) (mReceiver.activityInfo)).applicationInfo;
            }
            return packagemanager.getText(s, ((ComponentInfo) (mReceiver.activityInfo)).descriptionRes, applicationinfo);
        } else {
            throw new android.content.res.Resources.NotFoundException();
        }
    }

    public Drawable loadIcon(PackageManager packagemanager) {
        return mReceiver.loadIcon(packagemanager);
    }

    public CharSequence loadLabel(PackageManager packagemanager) {
        return mReceiver.loadLabel(packagemanager);
    }

    public void readPoliciesFromXml(XmlPullParser xmlpullparser) throws XmlPullParserException, IOException {
        mUsesPolicies = Integer.parseInt(xmlpullparser.getAttributeValue(null, "flags"));
    }

    public String toString() {
        return (new StringBuilder()).append("DeviceAdminInfo{").append(((PackageItemInfo) (mReceiver.activityInfo)).name).append("}").toString();
    }

    public boolean usesPolicy(int i) {
        boolean flag = true;
        if((mUsesPolicies & flag << i) == 0)
            flag = false;
        return flag;
    }

    public void writePoliciesToXml(XmlSerializer xmlserializer) throws IllegalArgumentException, IllegalStateException, IOException {
        xmlserializer.attribute(null, "flags", Integer.toString(mUsesPolicies));
    }

    public void writeToParcel(Parcel parcel, int i) {
        mReceiver.writeToParcel(parcel, i);
        parcel.writeInt(mUsesPolicies);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public DeviceAdminInfo createFromParcel(Parcel parcel) {
            return new DeviceAdminInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public DeviceAdminInfo[] newArray(int j) {
            return new DeviceAdminInfo[j];
        }

        public volatile Object[] newArray(int j) {
            return newArray(j);
        }

    };
    static final String TAG = "DeviceAdminInfo";
    public static final int USES_ENCRYPTED_STORAGE = 7;
    public static final int USES_POLICY_DISABLE_CAMERA = 8;
    public static final int USES_POLICY_EXPIRE_PASSWORD = 6;
    public static final int USES_POLICY_FORCE_LOCK = 3;
    public static final int USES_POLICY_LIMIT_PASSWORD = 0;
    public static final int USES_POLICY_RESET_PASSWORD = 2;
    public static final int USES_POLICY_SETS_GLOBAL_PROXY = 5;
    public static final int USES_POLICY_WATCH_LOGIN = 1;
    public static final int USES_POLICY_WIPE_DATA = 4;
    static HashMap sKnownPolicies;
    static ArrayList sPoliciesDisplayOrder;
    static SparseArray sRevKnownPolicies;
    final ResolveInfo mReceiver;
    int mUsesPolicies;
    boolean mVisible;

    static  {
        sPoliciesDisplayOrder = new ArrayList();
        sKnownPolicies = new HashMap();
        sRevKnownPolicies = new SparseArray();
        sPoliciesDisplayOrder.add(new PolicyInfo(4, "wipe-data", 0x104029c, 0x104029d));
        sPoliciesDisplayOrder.add(new PolicyInfo(2, "reset-password", 0x1040298, 0x1040299));
        sPoliciesDisplayOrder.add(new PolicyInfo(0, "limit-password", 0x1040294, 0x1040295));
        sPoliciesDisplayOrder.add(new PolicyInfo(1, "watch-login", 0x1040296, 0x1040297));
        sPoliciesDisplayOrder.add(new PolicyInfo(3, "force-lock", 0x104029a, 0x104029b));
        sPoliciesDisplayOrder.add(new PolicyInfo(5, "set-global-proxy", 0x104029e, 0x104029f));
        sPoliciesDisplayOrder.add(new PolicyInfo(6, "expire-password", 0x10402a0, 0x10402a1));
        sPoliciesDisplayOrder.add(new PolicyInfo(7, "encrypted-storage", 0x10402a2, 0x10402a3));
        sPoliciesDisplayOrder.add(new PolicyInfo(8, "disable-camera", 0x10402a4, 0x10402a5));
        for(int i = 0; i < sPoliciesDisplayOrder.size(); i++) {
            PolicyInfo policyinfo = (PolicyInfo)sPoliciesDisplayOrder.get(i);
            sRevKnownPolicies.put(policyinfo.ident, policyinfo);
            sKnownPolicies.put(policyinfo.tag, Integer.valueOf(policyinfo.ident));
        }

    }
}

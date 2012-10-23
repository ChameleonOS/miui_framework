// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.accessibilityservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.*;
import android.content.res.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.TypedValue;
import android.util.Xml;
import android.view.accessibility.AccessibilityEvent;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public class AccessibilityServiceInfo
    implements Parcelable {

    public AccessibilityServiceInfo() {
    }

    public AccessibilityServiceInfo(ResolveInfo resolveinfo, Context context) throws XmlPullParserException, IOException {
        ServiceInfo serviceinfo;
        XmlResourceParser xmlresourceparser;
        serviceinfo = resolveinfo.serviceInfo;
        mId = (new ComponentName(((PackageItemInfo) (serviceinfo)).packageName, ((PackageItemInfo) (serviceinfo)).name)).flattenToShortString();
        mResolveInfo = resolveinfo;
        xmlresourceparser = null;
        PackageManager packagemanager;
        XmlResourceParser xmlresourceparser1;
        packagemanager = context.getPackageManager();
        xmlresourceparser1 = serviceinfo.loadXmlMetaData(packagemanager, "android.accessibilityservice");
        xmlresourceparser = xmlresourceparser1;
        if(xmlresourceparser != null) goto _L2; else goto _L1
_L1:
        if(xmlresourceparser != null)
            xmlresourceparser.close();
_L5:
        return;
_L2:
        int i = 0;
_L3:
        if(i == 1 || i == 2)
            break MISSING_BLOCK_LABEL_104;
        i = xmlresourceparser.next();
          goto _L3
        if(!"accessibility-service".equals(xmlresourceparser.getName()))
            throw new XmlPullParserException("Meta-data does not start withaccessibility-service tag");
        break MISSING_BLOCK_LABEL_178;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        throw new XmlPullParserException((new StringBuilder()).append("Unable to create context for: ").append(((PackageItemInfo) (serviceinfo)).packageName).toString());
        Exception exception;
        exception;
        if(xmlresourceparser != null)
            xmlresourceparser.close();
        throw exception;
        android.util.AttributeSet attributeset = Xml.asAttributeSet(xmlresourceparser);
        TypedArray typedarray = packagemanager.getResourcesForApplication(((ComponentInfo) (serviceinfo)).applicationInfo).obtainAttributes(attributeset, com.android.internal.R.styleable.AccessibilityService);
        eventTypes = typedarray.getInt(2, 0);
        String s = typedarray.getString(3);
        if(s != null)
            packageNames = s.split("(\\s)*,(\\s)*");
        feedbackType = typedarray.getInt(4, 0);
        notificationTimeout = typedarray.getInt(5, 0);
        flags = typedarray.getInt(6, 0);
        mSettingsActivityName = typedarray.getString(1);
        mCanRetrieveWindowContent = typedarray.getBoolean(7, false);
        TypedValue typedvalue = typedarray.peekValue(0);
        if(typedvalue != null) {
            mDescriptionResId = typedvalue.resourceId;
            CharSequence charsequence = typedvalue.coerceToString();
            if(charsequence != null)
                mNonLocalizedDescription = charsequence.toString().trim();
        }
        typedarray.recycle();
        if(xmlresourceparser != null)
            xmlresourceparser.close();
        if(true) goto _L5; else goto _L4
_L4:
    }

    private static void appendEventTypes(StringBuilder stringbuilder, int i) {
        stringbuilder.append("eventTypes:");
        stringbuilder.append("[");
        do {
            if(i == 0)
                break;
            int j = 1 << Integer.numberOfTrailingZeros(i);
            stringbuilder.append(AccessibilityEvent.eventTypeToString(j));
            i &= ~j;
            if(i != 0)
                stringbuilder.append(", ");
        } while(true);
        stringbuilder.append("]");
    }

    private static void appendFeedbackTypes(StringBuilder stringbuilder, int i) {
        stringbuilder.append("feedbackTypes:");
        stringbuilder.append("[");
        do {
            if(i == 0)
                break;
            int j = 1 << Integer.numberOfTrailingZeros(i);
            stringbuilder.append(feedbackTypeToString(j));
            i &= ~j;
            if(i != 0)
                stringbuilder.append(", ");
        } while(true);
        stringbuilder.append("]");
    }

    private static void appendFlags(StringBuilder stringbuilder, int i) {
        stringbuilder.append("flags:");
        stringbuilder.append("[");
        do {
            if(i == 0)
                break;
            int j = 1 << Integer.numberOfTrailingZeros(i);
            stringbuilder.append(flagToString(j));
            i &= ~j;
            if(i != 0)
                stringbuilder.append(", ");
        } while(true);
        stringbuilder.append("]");
    }

    private static void appendPackageNames(StringBuilder stringbuilder, String as[]) {
        stringbuilder.append("packageNames:");
        stringbuilder.append("[");
        if(as != null) {
            int i = as.length;
            for(int j = 0; j < i; j++) {
                stringbuilder.append(as[j]);
                if(j < i - 1)
                    stringbuilder.append(", ");
            }

        }
        stringbuilder.append("]");
    }

    public static String feedbackTypeToString(int i) {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("[");
        do
            if(i != 0) {
                int j = 1 << Integer.numberOfTrailingZeros(i);
                i &= ~j;
                switch(j) {
                case 1: // '\001'
                    if(stringbuilder.length() > 1)
                        stringbuilder.append(", ");
                    stringbuilder.append("FEEDBACK_SPOKEN");
                    break;

                case 4: // '\004'
                    if(stringbuilder.length() > 1)
                        stringbuilder.append(", ");
                    stringbuilder.append("FEEDBACK_AUDIBLE");
                    break;

                case 2: // '\002'
                    if(stringbuilder.length() > 1)
                        stringbuilder.append(", ");
                    stringbuilder.append("FEEDBACK_HAPTIC");
                    break;

                case 16: // '\020'
                    if(stringbuilder.length() > 1)
                        stringbuilder.append(", ");
                    stringbuilder.append("FEEDBACK_GENERIC");
                    break;

                case 8: // '\b'
                    if(stringbuilder.length() > 1)
                        stringbuilder.append(", ");
                    stringbuilder.append("FEEDBACK_VISUAL");
                    break;
                }
            } else {
                stringbuilder.append("]");
                return stringbuilder.toString();
            }
        while(true);
    }

    public static String flagToString(int i) {
        i;
        JVM INSTR tableswitch 1 4: default 32
    //                   1 36
    //                   2 43
    //                   3 32
    //                   4 50;
           goto _L1 _L2 _L3 _L1 _L4
_L1:
        String s = null;
_L6:
        return s;
_L2:
        s = "DEFAULT";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "FLAG_INCLUDE_NOT_IMPORTANT_VIEWS";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "FLAG_REQUEST_TOUCH_EXPLORATION_MODE";
        if(true) goto _L6; else goto _L5
_L5:
    }

    private void initFromParcel(Parcel parcel) {
        eventTypes = parcel.readInt();
        packageNames = parcel.readStringArray();
        feedbackType = parcel.readInt();
        notificationTimeout = parcel.readLong();
        flags = parcel.readInt();
        mId = parcel.readString();
        mResolveInfo = (ResolveInfo)parcel.readParcelable(null);
        mSettingsActivityName = parcel.readString();
        boolean flag;
        if(parcel.readInt() == 1)
            flag = true;
        else
            flag = false;
        mCanRetrieveWindowContent = flag;
        mDescriptionResId = parcel.readInt();
        mNonLocalizedDescription = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean getCanRetrieveWindowContent() {
        return mCanRetrieveWindowContent;
    }

    public String getDescription() {
        return mNonLocalizedDescription;
    }

    public String getId() {
        return mId;
    }

    public ResolveInfo getResolveInfo() {
        return mResolveInfo;
    }

    public String getSettingsActivityName() {
        return mSettingsActivityName;
    }

    public String loadDescription(PackageManager packagemanager) {
        String s;
        if(mDescriptionResId == 0) {
            s = mNonLocalizedDescription;
        } else {
            ServiceInfo serviceinfo = mResolveInfo.serviceInfo;
            CharSequence charsequence = packagemanager.getText(((PackageItemInfo) (serviceinfo)).packageName, mDescriptionResId, ((ComponentInfo) (serviceinfo)).applicationInfo);
            if(charsequence != null)
                s = charsequence.toString().trim();
            else
                s = null;
        }
        return s;
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();
        appendEventTypes(stringbuilder, eventTypes);
        stringbuilder.append(", ");
        appendPackageNames(stringbuilder, packageNames);
        stringbuilder.append(", ");
        appendFeedbackTypes(stringbuilder, feedbackType);
        stringbuilder.append(", ");
        stringbuilder.append("notificationTimeout: ").append(notificationTimeout);
        stringbuilder.append(", ");
        appendFlags(stringbuilder, flags);
        stringbuilder.append(", ");
        stringbuilder.append("id: ").append(mId);
        stringbuilder.append(", ");
        stringbuilder.append("resolveInfo: ").append(mResolveInfo);
        stringbuilder.append(", ");
        stringbuilder.append("settingsActivityName: ").append(mSettingsActivityName);
        stringbuilder.append(", ");
        stringbuilder.append("retrieveScreenContent: ").append(mCanRetrieveWindowContent);
        return stringbuilder.toString();
    }

    public void updateDynamicallyConfigurableProperties(AccessibilityServiceInfo accessibilityserviceinfo) {
        eventTypes = accessibilityserviceinfo.eventTypes;
        packageNames = accessibilityserviceinfo.packageNames;
        feedbackType = accessibilityserviceinfo.feedbackType;
        notificationTimeout = accessibilityserviceinfo.notificationTimeout;
        flags = accessibilityserviceinfo.flags;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int j = 0;
        parcel.writeInt(eventTypes);
        parcel.writeStringArray(packageNames);
        parcel.writeInt(feedbackType);
        parcel.writeLong(notificationTimeout);
        parcel.writeInt(flags);
        parcel.writeString(mId);
        parcel.writeParcelable(mResolveInfo, 0);
        parcel.writeString(mSettingsActivityName);
        if(mCanRetrieveWindowContent)
            j = 1;
        parcel.writeInt(j);
        parcel.writeInt(mDescriptionResId);
        parcel.writeString(mNonLocalizedDescription);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public AccessibilityServiceInfo createFromParcel(Parcel parcel) {
            AccessibilityServiceInfo accessibilityserviceinfo = new AccessibilityServiceInfo();
            accessibilityserviceinfo.initFromParcel(parcel);
            return accessibilityserviceinfo;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public AccessibilityServiceInfo[] newArray(int i) {
            return new AccessibilityServiceInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int DEFAULT = 1;
    public static final int FEEDBACK_ALL_MASK = -1;
    public static final int FEEDBACK_AUDIBLE = 4;
    public static final int FEEDBACK_GENERIC = 16;
    public static final int FEEDBACK_HAPTIC = 2;
    public static final int FEEDBACK_SPOKEN = 1;
    public static final int FEEDBACK_VISUAL = 8;
    public static final int FLAG_INCLUDE_NOT_IMPORTANT_VIEWS = 2;
    public static final int FLAG_REQUEST_TOUCH_EXPLORATION_MODE = 4;
    private static final String TAG_ACCESSIBILITY_SERVICE = "accessibility-service";
    public int eventTypes;
    public int feedbackType;
    public int flags;
    private boolean mCanRetrieveWindowContent;
    private int mDescriptionResId;
    private String mId;
    private String mNonLocalizedDescription;
    private ResolveInfo mResolveInfo;
    private String mSettingsActivityName;
    public long notificationTimeout;
    public String packageNames[];


}

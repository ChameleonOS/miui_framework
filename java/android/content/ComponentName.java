// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package android.content:
//            Context

public final class ComponentName
    implements Parcelable, Cloneable, Comparable {

    public ComponentName(Context context, Class class1) {
        mPackage = context.getPackageName();
        mClass = class1.getName();
    }

    public ComponentName(Context context, String s) {
        if(s == null) {
            throw new NullPointerException("class name is null");
        } else {
            mPackage = context.getPackageName();
            mClass = s;
            return;
        }
    }

    public ComponentName(Parcel parcel) {
        mPackage = parcel.readString();
        if(mPackage == null)
            throw new NullPointerException("package name is null");
        mClass = parcel.readString();
        if(mClass == null)
            throw new NullPointerException("class name is null");
        else
            return;
    }

    private ComponentName(String s, Parcel parcel) {
        mPackage = s;
        mClass = parcel.readString();
    }

    public ComponentName(String s, String s1) {
        if(s == null)
            throw new NullPointerException("package name is null");
        if(s1 == null) {
            throw new NullPointerException("class name is null");
        } else {
            mPackage = s;
            mClass = s1;
            return;
        }
    }

    public static ComponentName readFromParcel(Parcel parcel) {
        String s = parcel.readString();
        ComponentName componentname;
        if(s != null)
            componentname = new ComponentName(s, parcel);
        else
            componentname = null;
        return componentname;
    }

    public static ComponentName unflattenFromString(String s) {
        int i = s.indexOf('/');
        ComponentName componentname;
        if(i < 0 || i + 1 >= s.length()) {
            componentname = null;
        } else {
            String s1 = s.substring(0, i);
            String s2 = s.substring(i + 1);
            if(s2.length() > 0 && s2.charAt(0) == '.')
                s2 = (new StringBuilder()).append(s1).append(s2).toString();
            componentname = new ComponentName(s1, s2);
        }
        return componentname;
    }

    public static void writeToParcel(ComponentName componentname, Parcel parcel) {
        if(componentname != null)
            componentname.writeToParcel(parcel, 0);
        else
            parcel.writeString(null);
    }

    public ComponentName clone() {
        return new ComponentName(mPackage, mClass);
    }

    public volatile Object clone() throws CloneNotSupportedException {
        return clone();
    }

    public int compareTo(ComponentName componentname) {
        int i = mPackage.compareTo(componentname.mPackage);
        if(i == 0)
            i = mClass.compareTo(componentname.mClass);
        return i;
    }

    public volatile int compareTo(Object obj) {
        return compareTo((ComponentName)obj);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean flag;
        flag = false;
        if(obj == null)
            break MISSING_BLOCK_LABEL_48;
        boolean flag1;
        ComponentName componentname = (ComponentName)obj;
        if(!mPackage.equals(componentname.mPackage))
            break MISSING_BLOCK_LABEL_48;
        flag1 = mClass.equals(componentname.mClass);
        if(flag1)
            flag = true;
_L2:
        return flag;
        ClassCastException classcastexception;
        classcastexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String flattenToShortString() {
        return (new StringBuilder()).append(mPackage).append("/").append(getShortClassName()).toString();
    }

    public String flattenToString() {
        return (new StringBuilder()).append(mPackage).append("/").append(mClass).toString();
    }

    public String getClassName() {
        return mClass;
    }

    public String getPackageName() {
        return mPackage;
    }

    public String getShortClassName() {
        if(!mClass.startsWith(mPackage)) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        i = mPackage.length();
        j = mClass.length();
        if(j <= i || mClass.charAt(i) != '.') goto _L2; else goto _L3
_L3:
        String s = mClass.substring(i, j);
_L5:
        return s;
_L2:
        s = mClass;
        if(true) goto _L5; else goto _L4
_L4:
    }

    public int hashCode() {
        return mPackage.hashCode() + mClass.hashCode();
    }

    public String toShortString() {
        return (new StringBuilder()).append("{").append(mPackage).append("/").append(mClass).append("}").toString();
    }

    public String toString() {
        return (new StringBuilder()).append("ComponentInfo{").append(mPackage).append("/").append(mClass).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mPackage);
        parcel.writeString(mClass);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ComponentName createFromParcel(Parcel parcel) {
            return new ComponentName(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public ComponentName[] newArray(int i) {
            return new ComponentName[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private final String mClass;
    private final String mPackage;

}

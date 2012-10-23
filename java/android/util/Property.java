// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;


// Referenced classes of package android.util:
//            ReflectiveProperty

public abstract class Property {

    public Property(Class class1, String s) {
        mName = s;
        mType = class1;
    }

    public static Property of(Class class1, Class class2, String s) {
        return new ReflectiveProperty(class1, class2, s);
    }

    public abstract Object get(Object obj);

    public String getName() {
        return mName;
    }

    public Class getType() {
        return mType;
    }

    public boolean isReadOnly() {
        return false;
    }

    public void set(Object obj, Object obj1) {
        throw new UnsupportedOperationException((new StringBuilder()).append("Property ").append(getName()).append(" is read-only").toString());
    }

    private final String mName;
    private final Class mType;
}

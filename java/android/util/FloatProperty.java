// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;


// Referenced classes of package android.util:
//            Property

public abstract class FloatProperty extends Property {

    public FloatProperty(String s) {
        super(java/lang/Float, s);
    }

    public final void set(Object obj, Float float1) {
        setValue(obj, float1.floatValue());
    }

    public volatile void set(Object obj, Object obj1) {
        set(obj, (Float)obj1);
    }

    public abstract void setValue(Object obj, float f);
}

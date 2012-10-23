// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;

import java.lang.reflect.*;

// Referenced classes of package android.util:
//            Property, NoSuchPropertyException

class ReflectiveProperty extends Property {

    public ReflectiveProperty(Class class1, Class class2, String s) {
        String s2;
        String s3;
        super(class2, s);
        char c = Character.toUpperCase(s.charAt(0));
        String s1 = s.substring(1);
        s2 = (new StringBuilder()).append(c).append(s1).toString();
        s3 = (new StringBuilder()).append("get").append(s2).toString();
        mGetter = class1.getMethod(s3, (Class[])null);
_L2:
        Class class4;
        class4 = mGetter.getReturnType();
        if(!typesMatch(class2, class4))
            throw new NoSuchPropertyException((new StringBuilder()).append("Underlying type (").append(class4).append(") ").append("does not match Property type (").append(class2).append(")").toString());
        break; /* Loop/switch isn't completed */
        NoSuchMethodException nosuchmethodexception;
        nosuchmethodexception;
        String s4 = (new StringBuilder()).append("is").append(s2).toString();
        try {
            mGetter = class1.getMethod(s4, (Class[])null);
        }
        catch(NoSuchMethodException nosuchmethodexception1) {
            try {
                mField = class1.getField(s);
                Class class3 = mField.getType();
                if(!typesMatch(class2, class3))
                    throw new NoSuchPropertyException((new StringBuilder()).append("Underlying type (").append(class3).append(") ").append("does not match Property type (").append(class2).append(")").toString());
            }
            catch(NoSuchFieldException nosuchfieldexception) {
                throw new NoSuchPropertyException((new StringBuilder()).append("No accessor method or field found for property with name ").append(s).toString());
            }
            break MISSING_BLOCK_LABEL_340;
        }
        if(true) goto _L2; else goto _L1
_L1:
        String s5 = (new StringBuilder()).append("set").append(s2).toString();
        Class aclass[] = new Class[1];
        aclass[0] = class4;
        mSetter = class1.getMethod(s5, aclass);
_L4:
        return;
        NoSuchMethodException nosuchmethodexception2;
        nosuchmethodexception2;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private boolean typesMatch(Class class1, Class class2) {
        boolean flag = false;
        if(class2 != class1) {
            if(class2.isPrimitive() && (class2 == Float.TYPE && class1 == java/lang/Float || class2 == Integer.TYPE && class1 == java/lang/Integer || class2 == Boolean.TYPE && class1 == java/lang/Boolean || class2 == Long.TYPE && class1 == java/lang/Long || class2 == Double.TYPE && class1 == java/lang/Double || class2 == Short.TYPE && class1 == java/lang/Short || class2 == Byte.TYPE && class1 == java/lang/Byte || class2 == Character.TYPE && class1 == java/lang/Character))
                flag = true;
        } else {
            flag = true;
        }
        return flag;
    }

    public Object get(Object obj) {
        Object obj2;
        if(mGetter != null) {
            Object obj3;
            try {
                obj3 = mGetter.invoke(obj, (Object[])null);
            }
            catch(IllegalAccessException illegalaccessexception1) {
                throw new AssertionError();
            }
            catch(InvocationTargetException invocationtargetexception) {
                throw new RuntimeException(invocationtargetexception.getCause());
            }
            obj2 = obj3;
        } else
        if(mField != null) {
            Object obj1;
            try {
                obj1 = mField.get(obj);
            }
            catch(IllegalAccessException illegalaccessexception) {
                throw new AssertionError();
            }
            obj2 = obj1;
        } else {
            throw new AssertionError();
        }
        return obj2;
    }

    public boolean isReadOnly() {
        boolean flag;
        if(mSetter == null && mField == null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void set(Object obj, Object obj1) {
        if(mSetter == null)
            break MISSING_BLOCK_LABEL_59;
        Method method = mSetter;
        Object aobj[] = new Object[1];
        aobj[0] = obj1;
        method.invoke(obj, aobj);
_L1:
        return;
        IllegalAccessException illegalaccessexception1;
        illegalaccessexception1;
        throw new AssertionError();
        InvocationTargetException invocationtargetexception;
        invocationtargetexception;
        throw new RuntimeException(invocationtargetexception.getCause());
        if(mField != null)
            try {
                mField.set(obj, obj1);
            }
            catch(IllegalAccessException illegalaccessexception) {
                throw new AssertionError();
            }
        else
            throw new UnsupportedOperationException((new StringBuilder()).append("Property ").append(getName()).append(" is read-only").toString());
          goto _L1
    }

    private static final String PREFIX_GET = "get";
    private static final String PREFIX_IS = "is";
    private static final String PREFIX_SET = "set";
    private Field mField;
    private Method mGetter;
    private Method mSetter;
}

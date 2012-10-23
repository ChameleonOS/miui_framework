// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.animation;

import android.util.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// Referenced classes of package android.animation:
//            IntEvaluator, FloatEvaluator, KeyframeSet, IntKeyframeSet, 
//            FloatKeyframeSet, Keyframe, TypeEvaluator

public class PropertyValuesHolder
    implements Cloneable {
    static class FloatPropertyValuesHolder extends PropertyValuesHolder {

        void calculateValue(float f) {
            mFloatAnimatedValue = mFloatKeyframeSet.getFloatValue(f);
        }

        public FloatPropertyValuesHolder clone() {
            FloatPropertyValuesHolder floatpropertyvaluesholder = (FloatPropertyValuesHolder)clone();
            floatpropertyvaluesholder.mFloatKeyframeSet = (FloatKeyframeSet)((PropertyValuesHolder) (floatpropertyvaluesholder)).mKeyframeSet;
            return floatpropertyvaluesholder;
        }

        public volatile PropertyValuesHolder clone() {
            return clone();
        }

        public volatile Object clone() throws CloneNotSupportedException {
            return clone();
        }

        Object getAnimatedValue() {
            return Float.valueOf(mFloatAnimatedValue);
        }

        void setAnimatedValue(Object obj) {
            if(mFloatProperty == null) goto _L2; else goto _L1
_L1:
            mFloatProperty.setValue(obj, mFloatAnimatedValue);
_L4:
            return;
_L2:
            if(mProperty != null)
                mProperty.set(obj, Float.valueOf(mFloatAnimatedValue));
            else
            if(mJniSetter != 0)
                PropertyValuesHolder.nCallFloatMethod(obj, mJniSetter, mFloatAnimatedValue);
            else
            if(mSetter != null)
                try {
                    mTmpValueArray[0] = Float.valueOf(mFloatAnimatedValue);
                    mSetter.invoke(obj, mTmpValueArray);
                }
                catch(InvocationTargetException invocationtargetexception) {
                    Log.e("PropertyValuesHolder", invocationtargetexception.toString());
                }
                catch(IllegalAccessException illegalaccessexception) {
                    Log.e("PropertyValuesHolder", illegalaccessexception.toString());
                }
            if(true) goto _L4; else goto _L3
_L3:
        }

        public transient void setFloatValues(float af[]) {
            setFloatValues(af);
            mFloatKeyframeSet = (FloatKeyframeSet)mKeyframeSet;
        }

        void setupSetter(Class class1) {
            if(mProperty == null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            mPropertyMapLock.writeLock().lock();
            HashMap hashmap = (HashMap)sJNISetterPropertyMap.get(class1);
            if(hashmap != null) {
                Integer integer = (Integer)hashmap.get(mPropertyName);
                if(integer != null)
                    mJniSetter = integer.intValue();
            }
            if(mJniSetter == 0) {
                mJniSetter = PropertyValuesHolder.nGetFloatMethod(class1, getMethodName("set", mPropertyName));
                if(mJniSetter != 0) {
                    if(hashmap == null) {
                        hashmap = new HashMap();
                        sJNISetterPropertyMap.put(class1, hashmap);
                    }
                    hashmap.put(mPropertyName, Integer.valueOf(mJniSetter));
                }
            }
            mPropertyMapLock.writeLock().unlock();
_L4:
            if(mJniSetter == 0)
                setupSetter(class1);
            continue; /* Loop/switch isn't completed */
            NoSuchMethodError nosuchmethoderror;
            nosuchmethoderror;
            mPropertyMapLock.writeLock().unlock();
            if(true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            mPropertyMapLock.writeLock().unlock();
            throw exception;
            if(true) goto _L1; else goto _L5
_L5:
        }

        private static final HashMap sJNISetterPropertyMap = new HashMap();
        float mFloatAnimatedValue;
        FloatKeyframeSet mFloatKeyframeSet;
        private FloatProperty mFloatProperty;
        int mJniSetter;


        public FloatPropertyValuesHolder(Property property, FloatKeyframeSet floatkeyframeset) {
            super(property, null);
            mValueType = Float.TYPE;
            mKeyframeSet = floatkeyframeset;
            mFloatKeyframeSet = (FloatKeyframeSet)mKeyframeSet;
            if(property instanceof FloatProperty)
                mFloatProperty = (FloatProperty)mProperty;
        }

        public transient FloatPropertyValuesHolder(Property property, float af[]) {
            super(property, null);
            setFloatValues(af);
            if(property instanceof FloatProperty)
                mFloatProperty = (FloatProperty)mProperty;
        }

        public FloatPropertyValuesHolder(String s, FloatKeyframeSet floatkeyframeset) {
            super(s, null);
            mValueType = Float.TYPE;
            mKeyframeSet = floatkeyframeset;
            mFloatKeyframeSet = (FloatKeyframeSet)mKeyframeSet;
        }

        public transient FloatPropertyValuesHolder(String s, float af[]) {
            super(s, null);
            setFloatValues(af);
        }
    }

    static class IntPropertyValuesHolder extends PropertyValuesHolder {

        void calculateValue(float f) {
            mIntAnimatedValue = mIntKeyframeSet.getIntValue(f);
        }

        public IntPropertyValuesHolder clone() {
            IntPropertyValuesHolder intpropertyvaluesholder = (IntPropertyValuesHolder)clone();
            intpropertyvaluesholder.mIntKeyframeSet = (IntKeyframeSet)((PropertyValuesHolder) (intpropertyvaluesholder)).mKeyframeSet;
            return intpropertyvaluesholder;
        }

        public volatile PropertyValuesHolder clone() {
            return clone();
        }

        public volatile Object clone() throws CloneNotSupportedException {
            return clone();
        }

        Object getAnimatedValue() {
            return Integer.valueOf(mIntAnimatedValue);
        }

        void setAnimatedValue(Object obj) {
            if(mIntProperty == null) goto _L2; else goto _L1
_L1:
            mIntProperty.setValue(obj, mIntAnimatedValue);
_L4:
            return;
_L2:
            if(mProperty != null)
                mProperty.set(obj, Integer.valueOf(mIntAnimatedValue));
            else
            if(mJniSetter != 0)
                PropertyValuesHolder.nCallIntMethod(obj, mJniSetter, mIntAnimatedValue);
            else
            if(mSetter != null)
                try {
                    mTmpValueArray[0] = Integer.valueOf(mIntAnimatedValue);
                    mSetter.invoke(obj, mTmpValueArray);
                }
                catch(InvocationTargetException invocationtargetexception) {
                    Log.e("PropertyValuesHolder", invocationtargetexception.toString());
                }
                catch(IllegalAccessException illegalaccessexception) {
                    Log.e("PropertyValuesHolder", illegalaccessexception.toString());
                }
            if(true) goto _L4; else goto _L3
_L3:
        }

        public transient void setIntValues(int ai[]) {
            setIntValues(ai);
            mIntKeyframeSet = (IntKeyframeSet)mKeyframeSet;
        }

        void setupSetter(Class class1) {
            if(mProperty == null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            mPropertyMapLock.writeLock().lock();
            HashMap hashmap = (HashMap)sJNISetterPropertyMap.get(class1);
            if(hashmap != null) {
                Integer integer = (Integer)hashmap.get(mPropertyName);
                if(integer != null)
                    mJniSetter = integer.intValue();
            }
            if(mJniSetter == 0) {
                mJniSetter = PropertyValuesHolder.nGetIntMethod(class1, getMethodName("set", mPropertyName));
                if(mJniSetter != 0) {
                    if(hashmap == null) {
                        hashmap = new HashMap();
                        sJNISetterPropertyMap.put(class1, hashmap);
                    }
                    hashmap.put(mPropertyName, Integer.valueOf(mJniSetter));
                }
            }
            mPropertyMapLock.writeLock().unlock();
_L4:
            if(mJniSetter == 0)
                setupSetter(class1);
            continue; /* Loop/switch isn't completed */
            NoSuchMethodError nosuchmethoderror;
            nosuchmethoderror;
            mPropertyMapLock.writeLock().unlock();
            if(true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            mPropertyMapLock.writeLock().unlock();
            throw exception;
            if(true) goto _L1; else goto _L5
_L5:
        }

        private static final HashMap sJNISetterPropertyMap = new HashMap();
        int mIntAnimatedValue;
        IntKeyframeSet mIntKeyframeSet;
        private IntProperty mIntProperty;
        int mJniSetter;


        public IntPropertyValuesHolder(Property property, IntKeyframeSet intkeyframeset) {
            super(property, null);
            mValueType = Integer.TYPE;
            mKeyframeSet = intkeyframeset;
            mIntKeyframeSet = (IntKeyframeSet)mKeyframeSet;
            if(property instanceof IntProperty)
                mIntProperty = (IntProperty)mProperty;
        }

        public transient IntPropertyValuesHolder(Property property, int ai[]) {
            super(property, null);
            setIntValues(ai);
            if(property instanceof IntProperty)
                mIntProperty = (IntProperty)mProperty;
        }

        public IntPropertyValuesHolder(String s, IntKeyframeSet intkeyframeset) {
            super(s, null);
            mValueType = Integer.TYPE;
            mKeyframeSet = intkeyframeset;
            mIntKeyframeSet = (IntKeyframeSet)mKeyframeSet;
        }

        public transient IntPropertyValuesHolder(String s, int ai[]) {
            super(s, null);
            setIntValues(ai);
        }
    }


    private PropertyValuesHolder(Property property) {
        mSetter = null;
        mGetter = null;
        mKeyframeSet = null;
        mPropertyMapLock = new ReentrantReadWriteLock();
        mTmpValueArray = new Object[1];
        mProperty = property;
        if(property != null)
            mPropertyName = property.getName();
    }


    private PropertyValuesHolder(String s) {
        mSetter = null;
        mGetter = null;
        mKeyframeSet = null;
        mPropertyMapLock = new ReentrantReadWriteLock();
        mTmpValueArray = new Object[1];
        mPropertyName = s;
    }


    static String getMethodName(String s, String s1) {
        if(s1 != null && s1.length() != 0) {
            char c = Character.toUpperCase(s1.charAt(0));
            String s2 = s1.substring(1);
            s = (new StringBuilder()).append(s).append(c).append(s2).toString();
        }
        return s;
    }

    private Method getPropertyFunction(Class class1, String s, Class class2) {
        Method method;
        String s1;
        method = null;
        s1 = getMethodName(s, mPropertyName);
        if(class2 != null) goto _L2; else goto _L1
_L1:
        Method method3 = class1.getMethod(s1, null);
        method = method3;
_L6:
        Method method2;
        if(method == null)
            Log.w("PropertyValuesHolder", (new StringBuilder()).append("Method ").append(getMethodName(s, mPropertyName)).append("() with type ").append(mValueType).append(" not found on target class ").append(class1).toString());
        method2 = method;
_L3:
        return method2;
_L2:
        int j;
        Class aclass[] = new Class[1];
        Method method1;
        Class aclass1[];
        Class aclass2[];
        int i;
        Class class3;
        if(mValueType.equals(java/lang/Float))
            aclass1 = FLOAT_VARIANTS;
        else
        if(mValueType.equals(java/lang/Integer))
            aclass1 = INTEGER_VARIANTS;
        else
        if(mValueType.equals(java/lang/Double)) {
            aclass1 = DOUBLE_VARIANTS;
        } else {
            aclass1 = new Class[1];
            aclass1[0] = mValueType;
        }
        aclass2 = aclass1;
        i = aclass2.length;
        j = 0;
_L4:
        if(j >= i)
            continue; /* Loop/switch isn't completed */
        class3 = aclass2[j];
        aclass[0] = class3;
        method1 = class1.getMethod(s1, aclass);
        mValueType = class3;
        method2 = method1;
          goto _L3
        NoSuchMethodException nosuchmethodexception;
        nosuchmethodexception;
        j++;
          goto _L4
        NoSuchMethodException nosuchmethodexception1;
        nosuchmethodexception1;
        if(true) goto _L6; else goto _L5
_L5:
    }

    private static native void nCallFloatMethod(Object obj, int i, float f);

    private static native void nCallIntMethod(Object obj, int i, int j);

    private static native int nGetFloatMethod(Class class1, String s);

    private static native int nGetIntMethod(Class class1, String s);

    public static transient PropertyValuesHolder ofFloat(Property property, float af[]) {
        return new FloatPropertyValuesHolder(property, af);
    }

    public static transient PropertyValuesHolder ofFloat(String s, float af[]) {
        return new FloatPropertyValuesHolder(s, af);
    }

    public static transient PropertyValuesHolder ofInt(Property property, int ai[]) {
        return new IntPropertyValuesHolder(property, ai);
    }

    public static transient PropertyValuesHolder ofInt(String s, int ai[]) {
        return new IntPropertyValuesHolder(s, ai);
    }

    public static transient PropertyValuesHolder ofKeyframe(Property property, Keyframe akeyframe[]) {
        KeyframeSet keyframeset = KeyframeSet.ofKeyframe(akeyframe);
        Object obj;
        if(keyframeset instanceof IntKeyframeSet)
            obj = new IntPropertyValuesHolder(property, (IntKeyframeSet)keyframeset);
        else
        if(keyframeset instanceof FloatKeyframeSet) {
            obj = new FloatPropertyValuesHolder(property, (FloatKeyframeSet)keyframeset);
        } else {
            obj = new PropertyValuesHolder(property);
            obj.mKeyframeSet = keyframeset;
            obj.mValueType = akeyframe[0].getType();
        }
        return ((PropertyValuesHolder) (obj));
    }

    public static transient PropertyValuesHolder ofKeyframe(String s, Keyframe akeyframe[]) {
        KeyframeSet keyframeset = KeyframeSet.ofKeyframe(akeyframe);
        Object obj;
        if(keyframeset instanceof IntKeyframeSet)
            obj = new IntPropertyValuesHolder(s, (IntKeyframeSet)keyframeset);
        else
        if(keyframeset instanceof FloatKeyframeSet) {
            obj = new FloatPropertyValuesHolder(s, (FloatKeyframeSet)keyframeset);
        } else {
            obj = new PropertyValuesHolder(s);
            obj.mKeyframeSet = keyframeset;
            obj.mValueType = akeyframe[0].getType();
        }
        return ((PropertyValuesHolder) (obj));
    }

    public static transient PropertyValuesHolder ofObject(Property property, TypeEvaluator typeevaluator, Object aobj[]) {
        PropertyValuesHolder propertyvaluesholder = new PropertyValuesHolder(property);
        propertyvaluesholder.setObjectValues(aobj);
        propertyvaluesholder.setEvaluator(typeevaluator);
        return propertyvaluesholder;
    }

    public static transient PropertyValuesHolder ofObject(String s, TypeEvaluator typeevaluator, Object aobj[]) {
        PropertyValuesHolder propertyvaluesholder = new PropertyValuesHolder(s);
        propertyvaluesholder.setObjectValues(aobj);
        propertyvaluesholder.setEvaluator(typeevaluator);
        return propertyvaluesholder;
    }

    private void setupGetter(Class class1) {
        mGetter = setupSetterOrGetter(class1, sGetterPropertyMap, "get", null);
    }

    private Method setupSetterOrGetter(Class class1, HashMap hashmap, String s, Class class2) {
        Method method = null;
        mPropertyMapLock.writeLock().lock();
        HashMap hashmap1 = (HashMap)hashmap.get(class1);
        if(hashmap1 != null)
            method = (Method)hashmap1.get(mPropertyName);
        if(method == null) {
            method = getPropertyFunction(class1, s, class2);
            if(hashmap1 == null) {
                hashmap1 = new HashMap();
                hashmap.put(class1, hashmap1);
            }
            hashmap1.put(mPropertyName, method);
        }
        mPropertyMapLock.writeLock().unlock();
        return method;
        Exception exception;
        exception;
        mPropertyMapLock.writeLock().unlock();
        throw exception;
    }

    private void setupValue(Object obj, Keyframe keyframe) {
label0:
        {
            if(mProperty != null)
                keyframe.setValue(mProperty.get(obj));
            try {
                if(mGetter == null) {
                    setupGetter(obj.getClass());
                    if(mGetter == null)
                        break label0;
                }
                keyframe.setValue(mGetter.invoke(obj, new Object[0]));
            }
            catch(InvocationTargetException invocationtargetexception) {
                Log.e("PropertyValuesHolder", invocationtargetexception.toString());
            }
            catch(IllegalAccessException illegalaccessexception) {
                Log.e("PropertyValuesHolder", illegalaccessexception.toString());
            }
        }
    }

    void calculateValue(float f) {
        mAnimatedValue = mKeyframeSet.getValue(f);
    }

    public PropertyValuesHolder clone() {
        PropertyValuesHolder propertyvaluesholder;
        try {
            propertyvaluesholder = (PropertyValuesHolder)super.clone();
            propertyvaluesholder.mPropertyName = mPropertyName;
            propertyvaluesholder.mProperty = mProperty;
            propertyvaluesholder.mKeyframeSet = mKeyframeSet.clone();
            propertyvaluesholder.mEvaluator = mEvaluator;
        }
        catch(CloneNotSupportedException clonenotsupportedexception) {
            propertyvaluesholder = null;
        }
        return propertyvaluesholder;
    }

    public volatile Object clone() throws CloneNotSupportedException {
        return clone();
    }

    Object getAnimatedValue() {
        return mAnimatedValue;
    }

    public String getPropertyName() {
        return mPropertyName;
    }

    void init() {
        if(mEvaluator == null) {
            TypeEvaluator typeevaluator;
            if(mValueType == java/lang/Integer)
                typeevaluator = sIntEvaluator;
            else
            if(mValueType == java/lang/Float)
                typeevaluator = sFloatEvaluator;
            else
                typeevaluator = null;
            mEvaluator = typeevaluator;
        }
        if(mEvaluator != null)
            mKeyframeSet.setEvaluator(mEvaluator);
    }

    void setAnimatedValue(Object obj) {
        if(mProperty != null)
            mProperty.set(obj, getAnimatedValue());
        if(mSetter == null)
            break MISSING_BLOCK_LABEL_49;
        mTmpValueArray[0] = getAnimatedValue();
        mSetter.invoke(obj, mTmpValueArray);
_L1:
        return;
        InvocationTargetException invocationtargetexception;
        invocationtargetexception;
        Log.e("PropertyValuesHolder", invocationtargetexception.toString());
          goto _L1
        IllegalAccessException illegalaccessexception;
        illegalaccessexception;
        Log.e("PropertyValuesHolder", illegalaccessexception.toString());
          goto _L1
    }

    public void setEvaluator(TypeEvaluator typeevaluator) {
        mEvaluator = typeevaluator;
        mKeyframeSet.setEvaluator(typeevaluator);
    }

    public transient void setFloatValues(float af[]) {
        mValueType = Float.TYPE;
        mKeyframeSet = KeyframeSet.ofFloat(af);
    }

    public transient void setIntValues(int ai[]) {
        mValueType = Integer.TYPE;
        mKeyframeSet = KeyframeSet.ofInt(ai);
    }

    public transient void setKeyframes(Keyframe akeyframe[]) {
        int i = akeyframe.length;
        Keyframe akeyframe1[] = new Keyframe[Math.max(i, 2)];
        mValueType = akeyframe[0].getType();
        for(int j = 0; j < i; j++)
            akeyframe1[j] = akeyframe[j];

        mKeyframeSet = new KeyframeSet(akeyframe1);
    }

    public transient void setObjectValues(Object aobj[]) {
        mValueType = aobj[0].getClass();
        mKeyframeSet = KeyframeSet.ofObject(aobj);
    }

    public void setProperty(Property property) {
        mProperty = property;
    }

    public void setPropertyName(String s) {
        mPropertyName = s;
    }

    void setupEndValue(Object obj) {
        setupValue(obj, (Keyframe)mKeyframeSet.mKeyframes.get(-1 + mKeyframeSet.mKeyframes.size()));
    }

    void setupSetter(Class class1) {
        mSetter = setupSetterOrGetter(class1, sSetterPropertyMap, "set", mValueType);
    }

    void setupSetterAndGetter(Object obj) {
        if(mProperty == null) goto _L2; else goto _L1
_L1:
        mProperty.get(obj);
        Iterator iterator1 = mKeyframeSet.mKeyframes.iterator();
        do {
            if(!iterator1.hasNext())
                break;
            Keyframe keyframe1 = (Keyframe)iterator1.next();
            if(!keyframe1.hasValue())
                keyframe1.setValue(mProperty.get(obj));
        } while(true);
          goto _L3
        ClassCastException classcastexception;
        classcastexception;
        Log.w("PropertyValuesHolder", (new StringBuilder()).append("No such property (").append(mProperty.getName()).append(") on target object ").append(obj).append(". Trying reflection instead").toString());
        mProperty = null;
_L2:
        Class class1;
        Iterator iterator;
        class1 = obj.getClass();
        if(mSetter == null)
            setupSetter(class1);
        iterator = mKeyframeSet.mKeyframes.iterator();
_L8:
        if(!iterator.hasNext()) goto _L3; else goto _L4
_L4:
        Keyframe keyframe;
        keyframe = (Keyframe)iterator.next();
        if(keyframe.hasValue())
            continue; /* Loop/switch isn't completed */
        if(mGetter != null) goto _L6; else goto _L5
_L5:
        setupGetter(class1);
        if(mGetter != null) goto _L6; else goto _L3
_L3:
        return;
_L6:
        try {
            keyframe.setValue(mGetter.invoke(obj, new Object[0]));
        }
        catch(InvocationTargetException invocationtargetexception) {
            Log.e("PropertyValuesHolder", invocationtargetexception.toString());
        }
        catch(IllegalAccessException illegalaccessexception) {
            Log.e("PropertyValuesHolder", illegalaccessexception.toString());
        }
        if(true) goto _L8; else goto _L7
_L7:
    }

    void setupStartValue(Object obj) {
        setupValue(obj, (Keyframe)mKeyframeSet.mKeyframes.get(0));
    }

    public String toString() {
        return (new StringBuilder()).append(mPropertyName).append(": ").append(mKeyframeSet.toString()).toString();
    }

    private static Class DOUBLE_VARIANTS[];
    private static Class FLOAT_VARIANTS[];
    private static Class INTEGER_VARIANTS[];
    private static final TypeEvaluator sFloatEvaluator = new FloatEvaluator();
    private static final HashMap sGetterPropertyMap = new HashMap();
    private static final TypeEvaluator sIntEvaluator = new IntEvaluator();
    private static final HashMap sSetterPropertyMap = new HashMap();
    private Object mAnimatedValue;
    private TypeEvaluator mEvaluator;
    private Method mGetter;
    KeyframeSet mKeyframeSet;
    protected Property mProperty;
    final ReentrantReadWriteLock mPropertyMapLock;
    String mPropertyName;
    Method mSetter;
    final Object mTmpValueArray[];
    Class mValueType;

    static  {
        Class aclass[] = new Class[6];
        aclass[0] = Float.TYPE;
        aclass[1] = java/lang/Float;
        aclass[2] = Double.TYPE;
        aclass[3] = Integer.TYPE;
        aclass[4] = java/lang/Double;
        aclass[5] = java/lang/Integer;
        FLOAT_VARIANTS = aclass;
        Class aclass1[] = new Class[6];
        aclass1[0] = Integer.TYPE;
        aclass1[1] = java/lang/Integer;
        aclass1[2] = Float.TYPE;
        aclass1[3] = Double.TYPE;
        aclass1[4] = java/lang/Float;
        aclass1[5] = java/lang/Double;
        INTEGER_VARIANTS = aclass1;
        Class aclass2[] = new Class[6];
        aclass2[0] = Double.TYPE;
        aclass2[1] = java/lang/Double;
        aclass2[2] = Float.TYPE;
        aclass2[3] = Integer.TYPE;
        aclass2[4] = java/lang/Float;
        aclass2[5] = java/lang/Integer;
        DOUBLE_VARIANTS = aclass2;
    }




}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.animation;

import android.util.Property;
import java.util.HashMap;

// Referenced classes of package android.animation:
//            ValueAnimator, PropertyValuesHolder, TypeEvaluator, Animator

public final class ObjectAnimator extends ValueAnimator {

    public ObjectAnimator() {
    }

    private ObjectAnimator(Object obj, Property property) {
        mTarget = obj;
        setProperty(property);
    }

    private ObjectAnimator(Object obj, String s) {
        mTarget = obj;
        setPropertyName(s);
    }

    public static transient ObjectAnimator ofFloat(Object obj, Property property, float af[]) {
        ObjectAnimator objectanimator = new ObjectAnimator(obj, property);
        objectanimator.setFloatValues(af);
        return objectanimator;
    }

    public static transient ObjectAnimator ofFloat(Object obj, String s, float af[]) {
        ObjectAnimator objectanimator = new ObjectAnimator(obj, s);
        objectanimator.setFloatValues(af);
        return objectanimator;
    }

    public static transient ObjectAnimator ofInt(Object obj, Property property, int ai[]) {
        ObjectAnimator objectanimator = new ObjectAnimator(obj, property);
        objectanimator.setIntValues(ai);
        return objectanimator;
    }

    public static transient ObjectAnimator ofInt(Object obj, String s, int ai[]) {
        ObjectAnimator objectanimator = new ObjectAnimator(obj, s);
        objectanimator.setIntValues(ai);
        return objectanimator;
    }

    public static transient ObjectAnimator ofObject(Object obj, Property property, TypeEvaluator typeevaluator, Object aobj[]) {
        ObjectAnimator objectanimator = new ObjectAnimator(obj, property);
        objectanimator.setObjectValues(aobj);
        objectanimator.setEvaluator(typeevaluator);
        return objectanimator;
    }

    public static transient ObjectAnimator ofObject(Object obj, String s, TypeEvaluator typeevaluator, Object aobj[]) {
        ObjectAnimator objectanimator = new ObjectAnimator(obj, s);
        objectanimator.setObjectValues(aobj);
        objectanimator.setEvaluator(typeevaluator);
        return objectanimator;
    }

    public static transient ObjectAnimator ofPropertyValuesHolder(Object obj, PropertyValuesHolder apropertyvaluesholder[]) {
        ObjectAnimator objectanimator = new ObjectAnimator();
        objectanimator.mTarget = obj;
        objectanimator.setValues(apropertyvaluesholder);
        return objectanimator;
    }

    void animateValue(float f) {
        super.animateValue(f);
        int i = super.mValues.length;
        for(int j = 0; j < i; j++)
            super.mValues[j].setAnimatedValue(mTarget);

    }

    public volatile Animator clone() {
        return clone();
    }

    public ObjectAnimator clone() {
        return (ObjectAnimator)super.clone();
    }

    public volatile ValueAnimator clone() {
        return clone();
    }

    public volatile Object clone() throws CloneNotSupportedException {
        return clone();
    }

    public String getPropertyName() {
        return mPropertyName;
    }

    public Object getTarget() {
        return mTarget;
    }

    void initAnimation() {
        if(!super.mInitialized) {
            int i = super.mValues.length;
            for(int j = 0; j < i; j++)
                super.mValues[j].setupSetterAndGetter(mTarget);

            super.initAnimation();
        }
    }

    public volatile Animator setDuration(long l) {
        return setDuration(l);
    }

    public ObjectAnimator setDuration(long l) {
        super.setDuration(l);
        return this;
    }

    public volatile ValueAnimator setDuration(long l) {
        return setDuration(l);
    }

    public transient void setFloatValues(float af[]) {
        if(super.mValues == null || super.mValues.length == 0) {
            if(mProperty != null) {
                PropertyValuesHolder apropertyvaluesholder1[] = new PropertyValuesHolder[1];
                apropertyvaluesholder1[0] = PropertyValuesHolder.ofFloat(mProperty, af);
                setValues(apropertyvaluesholder1);
            } else {
                PropertyValuesHolder apropertyvaluesholder[] = new PropertyValuesHolder[1];
                apropertyvaluesholder[0] = PropertyValuesHolder.ofFloat(mPropertyName, af);
                setValues(apropertyvaluesholder);
            }
        } else {
            super.setFloatValues(af);
        }
    }

    public transient void setIntValues(int ai[]) {
        if(super.mValues == null || super.mValues.length == 0) {
            if(mProperty != null) {
                PropertyValuesHolder apropertyvaluesholder1[] = new PropertyValuesHolder[1];
                apropertyvaluesholder1[0] = PropertyValuesHolder.ofInt(mProperty, ai);
                setValues(apropertyvaluesholder1);
            } else {
                PropertyValuesHolder apropertyvaluesholder[] = new PropertyValuesHolder[1];
                apropertyvaluesholder[0] = PropertyValuesHolder.ofInt(mPropertyName, ai);
                setValues(apropertyvaluesholder);
            }
        } else {
            super.setIntValues(ai);
        }
    }

    public transient void setObjectValues(Object aobj[]) {
        if(super.mValues == null || super.mValues.length == 0) {
            if(mProperty != null) {
                PropertyValuesHolder apropertyvaluesholder1[] = new PropertyValuesHolder[1];
                apropertyvaluesholder1[0] = PropertyValuesHolder.ofObject(mProperty, (TypeEvaluator)null, aobj);
                setValues(apropertyvaluesholder1);
            } else {
                PropertyValuesHolder apropertyvaluesholder[] = new PropertyValuesHolder[1];
                apropertyvaluesholder[0] = PropertyValuesHolder.ofObject(mPropertyName, (TypeEvaluator)null, aobj);
                setValues(apropertyvaluesholder);
            }
        } else {
            super.setObjectValues(aobj);
        }
    }

    public void setProperty(Property property) {
        if(super.mValues != null) {
            PropertyValuesHolder propertyvaluesholder = super.mValues[0];
            String s = propertyvaluesholder.getPropertyName();
            propertyvaluesholder.setProperty(property);
            super.mValuesMap.remove(s);
            super.mValuesMap.put(mPropertyName, propertyvaluesholder);
        }
        if(mProperty != null)
            mPropertyName = property.getName();
        mProperty = property;
        super.mInitialized = false;
    }

    public void setPropertyName(String s) {
        if(super.mValues != null) {
            PropertyValuesHolder propertyvaluesholder = super.mValues[0];
            String s1 = propertyvaluesholder.getPropertyName();
            propertyvaluesholder.setPropertyName(s);
            super.mValuesMap.remove(s1);
            super.mValuesMap.put(s, propertyvaluesholder);
        }
        mPropertyName = s;
        super.mInitialized = false;
    }

    public void setTarget(Object obj) {
        if(mTarget != obj) {
            Object obj1 = mTarget;
            mTarget = obj;
            if(obj1 == null || obj == null || obj1.getClass() != obj.getClass())
                super.mInitialized = false;
        }
    }

    public void setupEndValues() {
        initAnimation();
        int i = super.mValues.length;
        for(int j = 0; j < i; j++)
            super.mValues[j].setupEndValue(mTarget);

    }

    public void setupStartValues() {
        initAnimation();
        int i = super.mValues.length;
        for(int j = 0; j < i; j++)
            super.mValues[j].setupStartValue(mTarget);

    }

    public void start() {
        super.start();
    }

    public String toString() {
        String s = (new StringBuilder()).append("ObjectAnimator@").append(Integer.toHexString(hashCode())).append(", target ").append(mTarget).toString();
        if(super.mValues != null) {
            for(int i = 0; i < super.mValues.length; i++)
                s = (new StringBuilder()).append(s).append("\n    ").append(super.mValues[i].toString()).toString();

        }
        return s;
    }

    private static final boolean DBG;
    private Property mProperty;
    private String mPropertyName;
    private Object mTarget;
}

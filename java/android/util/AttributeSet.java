// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;


public interface AttributeSet {

    public abstract boolean getAttributeBooleanValue(int i, boolean flag);

    public abstract boolean getAttributeBooleanValue(String s, String s1, boolean flag);

    public abstract int getAttributeCount();

    public abstract float getAttributeFloatValue(int i, float f);

    public abstract float getAttributeFloatValue(String s, String s1, float f);

    public abstract int getAttributeIntValue(int i, int j);

    public abstract int getAttributeIntValue(String s, String s1, int i);

    public abstract int getAttributeListValue(int i, String as[], int j);

    public abstract int getAttributeListValue(String s, String s1, String as[], int i);

    public abstract String getAttributeName(int i);

    public abstract int getAttributeNameResource(int i);

    public abstract int getAttributeResourceValue(int i, int j);

    public abstract int getAttributeResourceValue(String s, String s1, int i);

    public abstract int getAttributeUnsignedIntValue(int i, int j);

    public abstract int getAttributeUnsignedIntValue(String s, String s1, int i);

    public abstract String getAttributeValue(int i);

    public abstract String getAttributeValue(String s, String s1);

    public abstract String getClassAttribute();

    public abstract String getIdAttribute();

    public abstract int getIdAttributeResourceValue(int i);

    public abstract String getPositionDescription();

    public abstract int getStyleAttribute();
}

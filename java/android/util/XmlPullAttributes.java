// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;

import com.android.internal.util.XmlUtils;
import org.xmlpull.v1.XmlPullParser;

// Referenced classes of package android.util:
//            AttributeSet

class XmlPullAttributes
    implements AttributeSet {

    public XmlPullAttributes(XmlPullParser xmlpullparser) {
        mParser = xmlpullparser;
    }

    public boolean getAttributeBooleanValue(int i, boolean flag) {
        return XmlUtils.convertValueToBoolean(getAttributeValue(i), flag);
    }

    public boolean getAttributeBooleanValue(String s, String s1, boolean flag) {
        return XmlUtils.convertValueToBoolean(getAttributeValue(s, s1), flag);
    }

    public int getAttributeCount() {
        return mParser.getAttributeCount();
    }

    public float getAttributeFloatValue(int i, float f) {
        String s = getAttributeValue(i);
        if(s != null)
            f = Float.parseFloat(s);
        return f;
    }

    public float getAttributeFloatValue(String s, String s1, float f) {
        String s2 = getAttributeValue(s, s1);
        if(s2 != null)
            f = Float.parseFloat(s2);
        return f;
    }

    public int getAttributeIntValue(int i, int j) {
        return XmlUtils.convertValueToInt(getAttributeValue(i), j);
    }

    public int getAttributeIntValue(String s, String s1, int i) {
        return XmlUtils.convertValueToInt(getAttributeValue(s, s1), i);
    }

    public int getAttributeListValue(int i, String as[], int j) {
        return XmlUtils.convertValueToList(getAttributeValue(i), as, j);
    }

    public int getAttributeListValue(String s, String s1, String as[], int i) {
        return XmlUtils.convertValueToList(getAttributeValue(s, s1), as, i);
    }

    public String getAttributeName(int i) {
        return mParser.getAttributeName(i);
    }

    public int getAttributeNameResource(int i) {
        return 0;
    }

    public int getAttributeResourceValue(int i, int j) {
        return XmlUtils.convertValueToInt(getAttributeValue(i), j);
    }

    public int getAttributeResourceValue(String s, String s1, int i) {
        return XmlUtils.convertValueToInt(getAttributeValue(s, s1), i);
    }

    public int getAttributeUnsignedIntValue(int i, int j) {
        return XmlUtils.convertValueToUnsignedInt(getAttributeValue(i), j);
    }

    public int getAttributeUnsignedIntValue(String s, String s1, int i) {
        return XmlUtils.convertValueToUnsignedInt(getAttributeValue(s, s1), i);
    }

    public String getAttributeValue(int i) {
        return mParser.getAttributeValue(i);
    }

    public String getAttributeValue(String s, String s1) {
        return mParser.getAttributeValue(s, s1);
    }

    public String getClassAttribute() {
        return getAttributeValue(null, "class");
    }

    public String getIdAttribute() {
        return getAttributeValue(null, "id");
    }

    public int getIdAttributeResourceValue(int i) {
        return getAttributeResourceValue(null, "id", i);
    }

    public String getPositionDescription() {
        return mParser.getPositionDescription();
    }

    public int getStyleAttribute() {
        return getAttributeResourceValue(null, "style", 0);
    }

    XmlPullParser mParser;
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.util;

import android.util.Xml;
import java.io.*;
import java.util.*;
import org.xmlpull.v1.*;

// Referenced classes of package com.android.internal.util:
//            FastXmlSerializer

public class XmlUtils {

    public XmlUtils() {
    }

    public static final void beginDocument(XmlPullParser xmlpullparser, String s) throws XmlPullParserException, IOException {
        int i;
        do
            i = xmlpullparser.next();
        while(i != 2 && i != 1);
        if(i != 2)
            throw new XmlPullParserException("No start tag found");
        if(!xmlpullparser.getName().equals(s))
            throw new XmlPullParserException((new StringBuilder()).append("Unexpected start tag: found ").append(xmlpullparser.getName()).append(", expected ").append(s).toString());
        else
            return;
    }

    public static final boolean convertValueToBoolean(CharSequence charsequence, boolean flag) {
        boolean flag1 = false;
        if(charsequence != null) {
            if(charsequence.equals("1") || charsequence.equals("true") || charsequence.equals("TRUE"))
                flag1 = true;
            flag = flag1;
        }
        return flag;
    }

    public static final int convertValueToInt(CharSequence charsequence, int i) {
        if(charsequence != null) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        String s;
        int j;
        byte byte1;
        s = charsequence.toString();
        byte byte0 = 1;
        j = 0;
        int k = s.length();
        byte1 = 10;
        if('-' == s.charAt(0)) {
            byte0 = -1;
            j = 0 + 1;
        }
        if('0' != s.charAt(j))
            break; /* Loop/switch isn't completed */
        if(j == k - 1) {
            i = 0;
            continue; /* Loop/switch isn't completed */
        }
        char c = s.charAt(j + 1);
        if('x' == c || 'X' == c) {
            j += 2;
            byte1 = 16;
        } else {
            j++;
            byte1 = 8;
        }
_L5:
        i = byte0 * Integer.parseInt(s.substring(j), byte1);
        if(true) goto _L1; else goto _L3
_L3:
        if('#' != s.charAt(j)) goto _L5; else goto _L4
_L4:
        j++;
        byte1 = 16;
          goto _L5
    }

    public static final int convertValueToList(CharSequence charsequence, String as[], int i) {
        int j;
        if(charsequence == null)
            break MISSING_BLOCK_LABEL_30;
        j = 0;
_L3:
        if(j >= as.length)
            break MISSING_BLOCK_LABEL_30;
        if(!charsequence.equals(as[j])) goto _L2; else goto _L1
_L1:
        return j;
_L2:
        j++;
          goto _L3
        j = i;
          goto _L1
    }

    public static final int convertValueToUnsignedInt(String s, int i) {
        if(s != null)
            i = parseUnsignedIntAttribute(s);
        return i;
    }

    public static final void nextElement(XmlPullParser xmlpullparser) throws XmlPullParserException, IOException {
        int i;
        do
            i = xmlpullparser.next();
        while(i != 2 && i != 1);
    }

    public static boolean nextElementWithin(XmlPullParser xmlpullparser, int i) throws IOException, XmlPullParserException {
        boolean flag = true;
_L4:
        int j = xmlpullparser.next();
        if(j != flag && (j != 3 || xmlpullparser.getDepth() != i)) goto _L2; else goto _L1
_L1:
        flag = false;
_L3:
        return flag;
_L2:
        if(j != 2 || xmlpullparser.getDepth() != i + 1) goto _L4; else goto _L3
    }

    public static final int parseUnsignedIntAttribute(CharSequence charsequence) {
        String s;
        int i;
        int j;
        byte byte0;
        s = charsequence.toString();
        i = 0;
        j = s.length();
        byte0 = 10;
        if('0' != s.charAt(0)) goto _L2; else goto _L1
_L1:
        if(j - 1 != 0) goto _L4; else goto _L3
_L3:
        int k = 0;
_L5:
        return k;
_L4:
        char c = s.charAt(1);
        if('x' == c || 'X' == c) {
            i = 0 + 2;
            byte0 = 16;
        } else {
            i = 0 + 1;
            byte0 = 8;
        }
_L6:
        k = (int)Long.parseLong(s.substring(i), byte0);
        if(true) goto _L5; else goto _L2
_L2:
        if('#' == s.charAt(0)) {
            i = 0 + 1;
            byte0 = 16;
        }
          goto _L6
    }

    public static final ArrayList readListXml(InputStream inputstream) throws XmlPullParserException, IOException {
        XmlPullParser xmlpullparser = Xml.newPullParser();
        xmlpullparser.setInput(inputstream, null);
        return (ArrayList)readValueXml(xmlpullparser, new String[1]);
    }

    public static final HashMap readMapXml(InputStream inputstream) throws XmlPullParserException, IOException {
        XmlPullParser xmlpullparser = Xml.newPullParser();
        xmlpullparser.setInput(inputstream, null);
        return (HashMap)readValueXml(xmlpullparser, new String[1]);
    }

    public static final HashSet readSetXml(InputStream inputstream) throws XmlPullParserException, IOException {
        XmlPullParser xmlpullparser = Xml.newPullParser();
        xmlpullparser.setInput(inputstream, null);
        return (HashSet)readValueXml(xmlpullparser, new String[1]);
    }

    public static final int[] readThisIntArrayXml(XmlPullParser xmlpullparser, String s, String as[]) throws XmlPullParserException, IOException {
        int ai[];
        int j;
        int k;
        int i;
        try {
            i = Integer.parseInt(xmlpullparser.getAttributeValue(null, "num"));
        }
        catch(NullPointerException nullpointerexception) {
            throw new XmlPullParserException("Need num attribute in byte-array");
        }
        catch(NumberFormatException numberformatexception) {
            throw new XmlPullParserException("Not a number in num attribute in byte-array");
        }
        ai = new int[i];
        j = 0;
        k = xmlpullparser.getEventType();
        if(k != 2)
            break MISSING_BLOCK_LABEL_193;
        if(!xmlpullparser.getName().equals("item"))
            break; /* Loop/switch isn't completed */
        try {
            ai[j] = Integer.parseInt(xmlpullparser.getAttributeValue(null, "value"));
        }
        catch(NullPointerException nullpointerexception1) {
            throw new XmlPullParserException("Need value attribute in item");
        }
        catch(NumberFormatException numberformatexception1) {
            throw new XmlPullParserException("Not a number in value attribute in item");
        }
_L4:
        k = xmlpullparser.next();
        if(k == 1)
            throw new XmlPullParserException((new StringBuilder()).append("Document ended before ").append(s).append(" end tag").toString());
        if(true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_31;
_L1:
        throw new XmlPullParserException((new StringBuilder()).append("Expected item tag at: ").append(xmlpullparser.getName()).toString());
        if(k == 3) {
            if(xmlpullparser.getName().equals(s))
                return ai;
            if(xmlpullparser.getName().equals("item"))
                j++;
            else
                throw new XmlPullParserException((new StringBuilder()).append("Expected ").append(s).append(" end tag at: ").append(xmlpullparser.getName()).toString());
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static final ArrayList readThisListXml(XmlPullParser xmlpullparser, String s, String as[]) throws XmlPullParserException, IOException {
        ArrayList arraylist = new ArrayList();
        int i = xmlpullparser.getEventType();
        do {
            if(i == 2)
                arraylist.add(readThisValueXml(xmlpullparser, as));
            else
            if(i == 3)
                if(xmlpullparser.getName().equals(s))
                    return arraylist;
                else
                    throw new XmlPullParserException((new StringBuilder()).append("Expected ").append(s).append(" end tag at: ").append(xmlpullparser.getName()).toString());
            i = xmlpullparser.next();
        } while(i != 1);
        throw new XmlPullParserException((new StringBuilder()).append("Document ended before ").append(s).append(" end tag").toString());
    }

    public static final HashMap readThisMapXml(XmlPullParser xmlpullparser, String s, String as[]) throws XmlPullParserException, IOException {
        HashMap hashmap;
        int i;
        hashmap = new HashMap();
        i = xmlpullparser.getEventType();
_L2:
        if(i != 2)
            break MISSING_BLOCK_LABEL_123;
        Object obj = readThisValueXml(xmlpullparser, as);
        if(as[0] == null)
            break; /* Loop/switch isn't completed */
        hashmap.put(as[0], obj);
_L3:
        i = xmlpullparser.next();
        if(i == 1)
            throw new XmlPullParserException((new StringBuilder()).append("Document ended before ").append(s).append(" end tag").toString());
        if(true) goto _L2; else goto _L1
_L1:
        throw new XmlPullParserException((new StringBuilder()).append("Map value without name attribute: ").append(xmlpullparser.getName()).toString());
        if(i == 3)
            if(xmlpullparser.getName().equals(s))
                return hashmap;
            else
                throw new XmlPullParserException((new StringBuilder()).append("Expected ").append(s).append(" end tag at: ").append(xmlpullparser.getName()).toString());
          goto _L3
    }

    public static final HashSet readThisSetXml(XmlPullParser xmlpullparser, String s, String as[]) throws XmlPullParserException, IOException {
        HashSet hashset = new HashSet();
        int i = xmlpullparser.getEventType();
        do {
            if(i == 2)
                hashset.add(readThisValueXml(xmlpullparser, as));
            else
            if(i == 3)
                if(xmlpullparser.getName().equals(s))
                    return hashset;
                else
                    throw new XmlPullParserException((new StringBuilder()).append("Expected ").append(s).append(" end tag at: ").append(xmlpullparser.getName()).toString());
            i = xmlpullparser.next();
        } while(i != 1);
        throw new XmlPullParserException((new StringBuilder()).append("Document ended before ").append(s).append(" end tag").toString());
    }

    private static final Object readThisValueXml(XmlPullParser xmlpullparser, String as[]) throws XmlPullParserException, IOException {
        String s;
        String s1;
        s = xmlpullparser.getAttributeValue(null, "name");
        s1 = xmlpullparser.getName();
        if(!s1.equals("null")) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L9:
        int i;
        i = xmlpullparser.next();
        if(i == 1)
            break; /* Loop/switch isn't completed */
        if(i != 3) goto _L4; else goto _L3
_L3:
        if(!xmlpullparser.getName().equals(s1)) goto _L6; else goto _L5
_L5:
        as[0] = s;
_L7:
        return obj;
_L2:
        if(s1.equals("string")) {
            String s2 = "";
label0:
            do
                do {
                    int j = xmlpullparser.next();
                    if(j != 1) {
                        if(j == 3) {
                            if(xmlpullparser.getName().equals("string")) {
                                as[0] = s;
                                obj = s2;
                            } else {
                                throw new XmlPullParserException((new StringBuilder()).append("Unexpected end tag in <string>: ").append(xmlpullparser.getName()).toString());
                            }
                            continue; /* Loop/switch isn't completed */
                        }
                        if(j != 4)
                            continue label0;
                        s2 = (new StringBuilder()).append(s2).append(xmlpullparser.getText()).toString();
                    } else {
                        throw new XmlPullParserException("Unexpected end of document in <string>");
                    }
                } while(true);
            while(j != 2);
            throw new XmlPullParserException((new StringBuilder()).append("Unexpected start tag in <string>: ").append(xmlpullparser.getName()).toString());
        }
        if(s1.equals("int")) {
            obj = Integer.valueOf(Integer.parseInt(xmlpullparser.getAttributeValue(null, "value")));
            continue; /* Loop/switch isn't completed */
        }
        if(s1.equals("long")) {
            obj = Long.valueOf(xmlpullparser.getAttributeValue(null, "value"));
            continue; /* Loop/switch isn't completed */
        }
        if(s1.equals("float")) {
            obj = new Float(xmlpullparser.getAttributeValue(null, "value"));
            continue; /* Loop/switch isn't completed */
        }
        if(s1.equals("double")) {
            obj = new Double(xmlpullparser.getAttributeValue(null, "value"));
            continue; /* Loop/switch isn't completed */
        }
        if(s1.equals("boolean")) {
            obj = Boolean.valueOf(xmlpullparser.getAttributeValue(null, "value"));
            continue; /* Loop/switch isn't completed */
        }
        if(s1.equals("int-array")) {
            xmlpullparser.next();
            obj = readThisIntArrayXml(xmlpullparser, "int-array", as);
            as[0] = s;
        } else
        if(s1.equals("map")) {
            xmlpullparser.next();
            obj = readThisMapXml(xmlpullparser, "map", as);
            as[0] = s;
        } else
        if(s1.equals("list")) {
            xmlpullparser.next();
            obj = readThisListXml(xmlpullparser, "list", as);
            as[0] = s;
        } else
        if(s1.equals("set")) {
            xmlpullparser.next();
            obj = readThisSetXml(xmlpullparser, "set", as);
            as[0] = s;
        } else {
            throw new XmlPullParserException((new StringBuilder()).append("Unknown tag: ").append(s1).toString());
        }
        if(true) goto _L7; else goto _L6
_L6:
        throw new XmlPullParserException((new StringBuilder()).append("Unexpected end tag in <").append(s1).append(">: ").append(xmlpullparser.getName()).toString());
_L4:
        if(i == 4)
            throw new XmlPullParserException((new StringBuilder()).append("Unexpected text in <").append(s1).append(">: ").append(xmlpullparser.getName()).toString());
        if(i == 2)
            throw new XmlPullParserException((new StringBuilder()).append("Unexpected start tag in <").append(s1).append(">: ").append(xmlpullparser.getName()).toString());
        if(true) goto _L9; else goto _L8
_L8:
        throw new XmlPullParserException((new StringBuilder()).append("Unexpected end of document in <").append(s1).append(">").toString());
    }

    public static final Object readValueXml(XmlPullParser xmlpullparser, String as[]) throws XmlPullParserException, IOException {
        int i = xmlpullparser.getEventType();
        do {
            if(i == 2)
                return readThisValueXml(xmlpullparser, as);
            if(i == 3)
                throw new XmlPullParserException((new StringBuilder()).append("Unexpected end tag at: ").append(xmlpullparser.getName()).toString());
            if(i == 4)
                throw new XmlPullParserException((new StringBuilder()).append("Unexpected text: ").append(xmlpullparser.getText()).toString());
            i = xmlpullparser.next();
        } while(i != 1);
        throw new XmlPullParserException("Unexpected end of document");
    }

    public static void skipCurrentTag(XmlPullParser xmlpullparser) throws XmlPullParserException, IOException {
        int i = xmlpullparser.getDepth();
        int j;
        do
            j = xmlpullparser.next();
        while(j != 1 && (j != 3 || xmlpullparser.getDepth() > i));
    }

    public static final void writeByteArrayXml(byte abyte0[], String s, XmlSerializer xmlserializer) throws XmlPullParserException, IOException {
        if(abyte0 == null) {
            xmlserializer.startTag(null, "null");
            xmlserializer.endTag(null, "null");
        } else {
            xmlserializer.startTag(null, "byte-array");
            if(s != null)
                xmlserializer.attribute(null, "name", s);
            int i = abyte0.length;
            xmlserializer.attribute(null, "num", Integer.toString(i));
            StringBuilder stringbuilder = new StringBuilder(2 * abyte0.length);
            int j = 0;
            while(j < i)  {
                byte byte0 = abyte0[j];
                int k = byte0 >> 4;
                int l;
                int i1;
                int j1;
                if(k >= 10)
                    l = -10 + (k + 97);
                else
                    l = k + 48;
                stringbuilder.append(l);
                i1 = byte0 & 0xff;
                if(i1 >= 10)
                    j1 = -10 + (i1 + 97);
                else
                    j1 = i1 + 48;
                stringbuilder.append(j1);
                j++;
            }
            xmlserializer.text(stringbuilder.toString());
            xmlserializer.endTag(null, "byte-array");
        }
    }

    public static final void writeIntArrayXml(int ai[], String s, XmlSerializer xmlserializer) throws XmlPullParserException, IOException {
        if(ai == null) {
            xmlserializer.startTag(null, "null");
            xmlserializer.endTag(null, "null");
        } else {
            xmlserializer.startTag(null, "int-array");
            if(s != null)
                xmlserializer.attribute(null, "name", s);
            int i = ai.length;
            xmlserializer.attribute(null, "num", Integer.toString(i));
            for(int j = 0; j < i; j++) {
                xmlserializer.startTag(null, "item");
                xmlserializer.attribute(null, "value", Integer.toString(ai[j]));
                xmlserializer.endTag(null, "item");
            }

            xmlserializer.endTag(null, "int-array");
        }
    }

    public static final void writeListXml(List list, OutputStream outputstream) throws XmlPullParserException, IOException {
        XmlSerializer xmlserializer = Xml.newSerializer();
        xmlserializer.setOutput(outputstream, "utf-8");
        xmlserializer.startDocument(null, Boolean.valueOf(true));
        xmlserializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        writeListXml(list, null, xmlserializer);
        xmlserializer.endDocument();
    }

    public static final void writeListXml(List list, String s, XmlSerializer xmlserializer) throws XmlPullParserException, IOException {
        if(list == null) {
            xmlserializer.startTag(null, "null");
            xmlserializer.endTag(null, "null");
        } else {
            xmlserializer.startTag(null, "list");
            if(s != null)
                xmlserializer.attribute(null, "name", s);
            int i = list.size();
            for(int j = 0; j < i; j++)
                writeValueXml(list.get(j), null, xmlserializer);

            xmlserializer.endTag(null, "list");
        }
    }

    public static final void writeMapXml(Map map, OutputStream outputstream) throws XmlPullParserException, IOException {
        FastXmlSerializer fastxmlserializer = new FastXmlSerializer();
        fastxmlserializer.setOutput(outputstream, "utf-8");
        fastxmlserializer.startDocument(null, Boolean.valueOf(true));
        fastxmlserializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        writeMapXml(map, null, ((XmlSerializer) (fastxmlserializer)));
        fastxmlserializer.endDocument();
    }

    public static final void writeMapXml(Map map, String s, XmlSerializer xmlserializer) throws XmlPullParserException, IOException {
        if(map == null) {
            xmlserializer.startTag(null, "null");
            xmlserializer.endTag(null, "null");
        } else {
            Iterator iterator = map.entrySet().iterator();
            xmlserializer.startTag(null, "map");
            if(s != null)
                xmlserializer.attribute(null, "name", s);
            java.util.Map.Entry entry;
            for(; iterator.hasNext(); writeValueXml(entry.getValue(), (String)entry.getKey(), xmlserializer))
                entry = (java.util.Map.Entry)iterator.next();

            xmlserializer.endTag(null, "map");
        }
    }

    public static final void writeSetXml(Set set, String s, XmlSerializer xmlserializer) throws XmlPullParserException, IOException {
        if(set == null) {
            xmlserializer.startTag(null, "null");
            xmlserializer.endTag(null, "null");
        } else {
            xmlserializer.startTag(null, "set");
            if(s != null)
                xmlserializer.attribute(null, "name", s);
            for(Iterator iterator = set.iterator(); iterator.hasNext(); writeValueXml(iterator.next(), null, xmlserializer));
            xmlserializer.endTag(null, "set");
        }
    }

    public static final void writeValueXml(Object obj, String s, XmlSerializer xmlserializer) throws XmlPullParserException, IOException {
        if(obj != null) goto _L2; else goto _L1
_L1:
        xmlserializer.startTag(null, "null");
        if(s != null)
            xmlserializer.attribute(null, "name", s);
        xmlserializer.endTag(null, "null");
_L8:
        return;
_L2:
        if(obj instanceof String) {
            xmlserializer.startTag(null, "string");
            if(s != null)
                xmlserializer.attribute(null, "name", s);
            xmlserializer.text(obj.toString());
            xmlserializer.endTag(null, "string");
            continue; /* Loop/switch isn't completed */
        }
        if(!(obj instanceof Integer)) goto _L4; else goto _L3
_L3:
        String s1 = "int";
_L6:
        xmlserializer.startTag(null, s1);
        if(s != null)
            xmlserializer.attribute(null, "name", s);
        xmlserializer.attribute(null, "value", obj.toString());
        xmlserializer.endTag(null, s1);
        continue; /* Loop/switch isn't completed */
_L4:
        if(obj instanceof Long) {
            s1 = "long";
            continue; /* Loop/switch isn't completed */
        }
        if(obj instanceof Float) {
            s1 = "float";
            continue; /* Loop/switch isn't completed */
        }
        if(obj instanceof Double) {
            s1 = "double";
            continue; /* Loop/switch isn't completed */
        }
        if(!(obj instanceof Boolean))
            break; /* Loop/switch isn't completed */
        s1 = "boolean";
        if(true) goto _L6; else goto _L5
_L5:
        if(obj instanceof byte[])
            writeByteArrayXml((byte[])(byte[])obj, s, xmlserializer);
        else
        if(obj instanceof int[])
            writeIntArrayXml((int[])(int[])obj, s, xmlserializer);
        else
        if(obj instanceof Map)
            writeMapXml((Map)obj, s, xmlserializer);
        else
        if(obj instanceof List)
            writeListXml((List)obj, s, xmlserializer);
        else
        if(obj instanceof Set)
            writeSetXml((Set)obj, s, xmlserializer);
        else
        if(obj instanceof CharSequence) {
            xmlserializer.startTag(null, "string");
            if(s != null)
                xmlserializer.attribute(null, "name", s);
            xmlserializer.text(obj.toString());
            xmlserializer.endTag(null, "string");
        } else {
            throw new RuntimeException((new StringBuilder()).append("writeValueXml: unable to write value ").append(obj).toString());
        }
        if(true) goto _L8; else goto _L7
_L7:
    }
}

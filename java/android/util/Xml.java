// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;

import java.io.*;
import org.apache.harmony.xml.ExpatReader;
import org.kxml2.io.KXmlParser;
import org.xml.sax.*;
import org.xmlpull.v1.*;

// Referenced classes of package android.util:
//            AttributeSet, XmlPullAttributes

public class Xml {
    public static final class Encoding extends Enum {

        public static Encoding valueOf(String s) {
            return (Encoding)Enum.valueOf(android/util/Xml$Encoding, s);
        }

        public static Encoding[] values() {
            return (Encoding[])$VALUES.clone();
        }

        private static final Encoding $VALUES[];
        public static final Encoding ISO_8859_1;
        public static final Encoding US_ASCII;
        public static final Encoding UTF_16;
        public static final Encoding UTF_8;
        final String expatName;

        static  {
            US_ASCII = new Encoding("US_ASCII", 0, "US-ASCII");
            UTF_8 = new Encoding("UTF_8", 1, "UTF-8");
            UTF_16 = new Encoding("UTF_16", 2, "UTF-16");
            ISO_8859_1 = new Encoding("ISO_8859_1", 3, "ISO-8859-1");
            Encoding aencoding[] = new Encoding[4];
            aencoding[0] = US_ASCII;
            aencoding[1] = UTF_8;
            aencoding[2] = UTF_16;
            aencoding[3] = ISO_8859_1;
            $VALUES = aencoding;
        }

        private Encoding(String s, int i, String s1) {
            super(s, i);
            expatName = s1;
        }
    }

    static class XmlSerializerFactory {

        static final String TYPE = "org.kxml2.io.KXmlParser,org.kxml2.io.KXmlSerializer";
        static final XmlPullParserFactory instance;

        static  {
            try {
                instance = XmlPullParserFactory.newInstance("org.kxml2.io.KXmlParser,org.kxml2.io.KXmlSerializer", null);
            }
            catch(XmlPullParserException xmlpullparserexception) {
                throw new AssertionError(xmlpullparserexception);
            }
        }

        XmlSerializerFactory() {
        }
    }


    public Xml() {
    }

    public static AttributeSet asAttributeSet(XmlPullParser xmlpullparser) {
        Object obj;
        if(xmlpullparser instanceof AttributeSet)
            obj = (AttributeSet)xmlpullparser;
        else
            obj = new XmlPullAttributes(xmlpullparser);
        return ((AttributeSet) (obj));
    }

    public static Encoding findEncodingByName(String s) throws UnsupportedEncodingException {
        if(s != null) goto _L2; else goto _L1
_L1:
        Encoding encoding = Encoding.UTF_8;
_L4:
        return encoding;
_L2:
        Encoding aencoding[] = Encoding.values();
        int i = aencoding.length;
        int j = 0;
label0:
        do {
label1:
            {
                if(j >= i)
                    break label1;
                encoding = aencoding[j];
                if(encoding.expatName.equalsIgnoreCase(s))
                    break label0;
                j++;
            }
        } while(true);
        if(true) goto _L4; else goto _L3
_L3:
        throw new UnsupportedEncodingException(s);
    }

    public static XmlPullParser newPullParser() {
        KXmlParser kxmlparser;
        try {
            kxmlparser = new KXmlParser();
            kxmlparser.setFeature("http://xmlpull.org/v1/doc/features.html#process-docdecl", true);
            kxmlparser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        }
        catch(XmlPullParserException xmlpullparserexception) {
            throw new AssertionError();
        }
        return kxmlparser;
    }

    public static XmlSerializer newSerializer() {
        XmlSerializer xmlserializer;
        try {
            xmlserializer = XmlSerializerFactory.instance.newSerializer();
        }
        catch(XmlPullParserException xmlpullparserexception) {
            throw new AssertionError(xmlpullparserexception);
        }
        return xmlserializer;
    }

    public static void parse(InputStream inputstream, Encoding encoding, ContentHandler contenthandler) throws IOException, SAXException {
        ExpatReader expatreader = new ExpatReader();
        expatreader.setContentHandler(contenthandler);
        InputSource inputsource = new InputSource(inputstream);
        inputsource.setEncoding(encoding.expatName);
        expatreader.parse(inputsource);
    }

    public static void parse(Reader reader, ContentHandler contenthandler) throws IOException, SAXException {
        ExpatReader expatreader = new ExpatReader();
        expatreader.setContentHandler(contenthandler);
        expatreader.parse(new InputSource(reader));
    }

    public static void parse(String s, ContentHandler contenthandler) throws SAXException {
        try {
            ExpatReader expatreader = new ExpatReader();
            expatreader.setContentHandler(contenthandler);
            expatreader.parse(new InputSource(new StringReader(s)));
            return;
        }
        catch(IOException ioexception) {
            throw new AssertionError(ioexception);
        }
    }

    public static String FEATURE_RELAXED = "http://xmlpull.org/v1/doc/features.html#relaxed";

}

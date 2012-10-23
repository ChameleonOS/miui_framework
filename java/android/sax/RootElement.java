// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.sax;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

// Referenced classes of package android.sax:
//            Element, EndElementListener, EndTextElementListener, StartElementListener, 
//            BadXmlException, Children

public class RootElement extends Element {
    class Handler extends DefaultHandler {

        public void characters(char ac[], int i, int j) throws SAXException {
            if(bodyBuilder != null)
                bodyBuilder.append(ac, i, j);
        }

        public void endElement(String s, String s1, String s2) throws SAXException {
            Element element = current;
            if(depth == element.depth) {
                element.checkRequiredChildren(locator);
                if(element.endElementListener != null)
                    element.endElementListener.end();
                if(bodyBuilder != null) {
                    String s3 = bodyBuilder.toString();
                    bodyBuilder = null;
                    element.endTextElementListener.end(s3);
                }
                current = element.parent;
            }
            depth = -1 + depth;
        }

        public void setDocumentLocator(Locator locator1) {
            locator = locator1;
        }

        void start(Element element, Attributes attributes) {
            current = element;
            if(element.startElementListener != null)
                element.startElementListener.start(attributes);
            if(element.endTextElementListener != null)
                bodyBuilder = new StringBuilder();
            element.resetRequiredChildren();
            element.visited = true;
        }

        public void startElement(String s, String s1, String s2, Attributes attributes) throws SAXException {
            int i;
            i = 1 + depth;
            depth = i;
            if(i != 0) goto _L2; else goto _L1
_L1:
            startRoot(s, s1, attributes);
_L4:
            return;
_L2:
            if(bodyBuilder != null)
                throw new BadXmlException((new StringBuilder()).append("Encountered mixed content within text element named ").append(current).append(".").toString(), locator);
            if(i == 1 + current.depth) {
                Children children = current.children;
                if(children != null) {
                    Element element = children.get(s, s1);
                    if(element != null)
                        start(element, attributes);
                }
            }
            if(true) goto _L4; else goto _L3
_L3:
        }

        void startRoot(String s, String s1, Attributes attributes) throws SAXException {
            RootElement rootelement = RootElement.this;
            if(((Element) (rootelement)).uri.compareTo(s) != 0 || ((Element) (rootelement)).localName.compareTo(s1) != 0) {
                throw new BadXmlException((new StringBuilder()).append("Root element name does not match. Expected: ").append(rootelement).append(", Got: ").append(Element.toString(s, s1)).toString(), locator);
            } else {
                start(rootelement, attributes);
                return;
            }
        }

        StringBuilder bodyBuilder;
        Element current;
        int depth;
        Locator locator;
        final RootElement this$0;

        Handler() {
            this$0 = RootElement.this;
            super();
            depth = -1;
            current = null;
            bodyBuilder = null;
        }
    }


    public RootElement(String s) {
        this("", s);
    }

    public RootElement(String s, String s1) {
        super(null, s, s1, 0);
        handler = new Handler();
    }

    public ContentHandler getContentHandler() {
        return handler;
    }

    final Handler handler;
}

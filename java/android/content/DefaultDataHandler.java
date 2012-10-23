// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.net.Uri;
import android.util.Xml;
import java.io.IOException;
import java.io.InputStream;
import java.util.Stack;
import org.xml.sax.*;

// Referenced classes of package android.content:
//            ContentInsertHandler, ContentResolver, ContentValues

public class DefaultDataHandler
    implements ContentInsertHandler {

    public DefaultDataHandler() {
        mUris = new Stack();
    }

    private Uri insertRow() {
        Uri uri = mContentResolver.insert((Uri)mUris.lastElement(), mValues);
        mValues = null;
        return uri;
    }

    private void parseRow(Attributes attributes) throws SAXException {
label0:
        {
            String s = attributes.getValue("uri");
            Uri uri;
            if(s != null) {
                uri = Uri.parse(s);
                if(uri == null)
                    throw new SAXException((new StringBuilder()).append("attribute ").append(attributes.getValue("uri")).append(" parsing failure").toString());
            } else {
                if(mUris.size() <= 0)
                    break label0;
                String s1 = attributes.getValue("postfix");
                if(s1 != null)
                    uri = Uri.withAppendedPath((Uri)mUris.lastElement(), s1);
                else
                    uri = (Uri)mUris.lastElement();
            }
            mUris.push(uri);
            return;
        }
        throw new SAXException("attribute parsing failure");
    }

    public void characters(char ac[], int i, int j) throws SAXException {
    }

    public void endDocument() throws SAXException {
    }

    public void endElement(String s, String s1, String s2) throws SAXException {
        if("row".equals(s1)) {
            if(mUris.empty())
                throw new SAXException("uri mismatch");
            if(mValues != null)
                insertRow();
            mUris.pop();
        }
    }

    public void endPrefixMapping(String s) throws SAXException {
    }

    public void ignorableWhitespace(char ac[], int i, int j) throws SAXException {
    }

    public void insert(ContentResolver contentresolver, InputStream inputstream) throws IOException, SAXException {
        mContentResolver = contentresolver;
        Xml.parse(inputstream, android.util.Xml.Encoding.UTF_8, this);
    }

    public void insert(ContentResolver contentresolver, String s) throws SAXException {
        mContentResolver = contentresolver;
        Xml.parse(s, this);
    }

    public void processingInstruction(String s, String s1) throws SAXException {
    }

    public void setDocumentLocator(Locator locator) {
    }

    public void skippedEntity(String s) throws SAXException {
    }

    public void startDocument() throws SAXException {
    }

    public void startElement(String s, String s1, String s2, Attributes attributes) throws SAXException {
        if("row".equals(s1)) {
            if(mValues != null) {
                if(mUris.empty())
                    throw new SAXException("uri is empty");
                Uri uri1 = insertRow();
                if(uri1 == null)
                    throw new SAXException((new StringBuilder()).append("insert to uri ").append(((Uri)mUris.lastElement()).toString()).append(" failure").toString());
                mUris.pop();
                mUris.push(uri1);
                parseRow(attributes);
            } else
            if(attributes.getLength() == 0)
                mUris.push(mUris.lastElement());
            else
                parseRow(attributes);
        } else
        if("col".equals(s1)) {
            int k = attributes.getLength();
            if(k != 2)
                throw new SAXException((new StringBuilder()).append("illegal attributes number ").append(k).toString());
            String s3 = attributes.getValue(0);
            String s4 = attributes.getValue(1);
            if(s3 != null && s3.length() > 0 && s4 != null && s4.length() > 0) {
                if(mValues == null)
                    mValues = new ContentValues();
                mValues.put(s3, s4);
            } else {
                throw new SAXException("illegal attributes value");
            }
        } else
        if("del".equals(s1)) {
            Uri uri = Uri.parse(attributes.getValue("uri"));
            if(uri == null)
                throw new SAXException((new StringBuilder()).append("attribute ").append(attributes.getValue("uri")).append(" parsing failure").toString());
            int i = -2 + attributes.getLength();
            if(i > 0) {
                String as[] = new String[i];
                for(int j = 0; j < i; j++)
                    as[j] = attributes.getValue(j + 2);

                mContentResolver.delete(uri, attributes.getValue(1), as);
            } else
            if(i == 0)
                mContentResolver.delete(uri, attributes.getValue(1), null);
            else
                mContentResolver.delete(uri, null, null);
        } else {
            throw new SAXException((new StringBuilder()).append("unknown element: ").append(s1).toString());
        }
    }

    public void startPrefixMapping(String s, String s1) throws SAXException {
    }

    private static final String ARG = "arg";
    private static final String COL = "col";
    private static final String DEL = "del";
    private static final String POSTFIX = "postfix";
    private static final String ROW = "row";
    private static final String SELECT = "select";
    private static final String URI_STR = "uri";
    private ContentResolver mContentResolver;
    private Stack mUris;
    private ContentValues mValues;
}

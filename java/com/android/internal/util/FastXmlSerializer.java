// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.util;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.*;
import org.xmlpull.v1.XmlSerializer;

public class FastXmlSerializer
    implements XmlSerializer {

    public FastXmlSerializer() {
        mBytes = ByteBuffer.allocate(8192);
    }

    private void append(char c) throws IOException {
        int i = mPos;
        if(i >= 8191) {
            flush();
            i = mPos;
        }
        mText[i] = c;
        mPos = i + 1;
    }

    private void append(String s) throws IOException {
        append(s, 0, s.length());
    }

    private void append(String s, int i, int j) throws IOException {
        if(j > 8192) {
            int l = i + j;
            while(i < l)  {
                int i1 = i + 8192;
                int j1;
                if(i1 < l)
                    j1 = 8192;
                else
                    j1 = l - i;
                append(s, i, j1);
                i = i1;
            }
        } else {
            int k = mPos;
            if(k + j > 8192) {
                flush();
                k = mPos;
            }
            s.getChars(i, i + j, mText, k);
            mPos = k + j;
        }
    }

    private void append(char ac[], int i, int j) throws IOException {
        if(j > 8192) {
            int l = i + j;
            while(i < l)  {
                int i1 = i + 8192;
                int j1;
                if(i1 < l)
                    j1 = 8192;
                else
                    j1 = l - i;
                append(ac, i, j1);
                i = i1;
            }
        } else {
            int k = mPos;
            if(k + j > 8192) {
                flush();
                k = mPos;
            }
            System.arraycopy(ac, i, mText, k, j);
            mPos = k + j;
        }
    }

    private void escapeAndAppendString(String s) throws IOException {
        int i = s.length();
        char c = (char)ESCAPE_TABLE.length;
        String as[] = ESCAPE_TABLE;
        int j = 0;
        int k = 0;
        while(k < i)  {
            char c1 = s.charAt(k);
            if(c1 < c) {
                String s1 = as[c1];
                if(s1 != null) {
                    if(j < k)
                        append(s, j, k - j);
                    j = k + 1;
                    append(s1);
                }
            }
            k++;
        }
        if(j < k)
            append(s, j, k - j);
    }

    private void escapeAndAppendString(char ac[], int i, int j) throws IOException {
        char c = (char)ESCAPE_TABLE.length;
        String as[] = ESCAPE_TABLE;
        int k = i + j;
        int l = i;
        int i1 = i;
        while(i1 < k)  {
            char c1 = ac[i1];
            if(c1 < c) {
                String s = as[c1];
                if(s != null) {
                    if(l < i1)
                        append(ac, l, i1 - l);
                    l = i1 + 1;
                    append(s);
                }
            }
            i1++;
        }
        if(l < i1)
            append(ac, l, i1 - l);
    }

    private void flushBytes() throws IOException {
        int i = mBytes.position();
        if(i > 0) {
            mBytes.flip();
            mOutputStream.write(mBytes.array(), 0, i);
            mBytes.clear();
        }
    }

    public XmlSerializer attribute(String s, String s1, String s2) throws IOException, IllegalArgumentException, IllegalStateException {
        append(' ');
        if(s != null) {
            append(s);
            append(':');
        }
        append(s1);
        append("=\"");
        escapeAndAppendString(s2);
        append('"');
        return this;
    }

    public void cdsect(String s) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void comment(String s) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void docdecl(String s) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void endDocument() throws IOException, IllegalArgumentException, IllegalStateException {
        flush();
    }

    public XmlSerializer endTag(String s, String s1) throws IOException, IllegalArgumentException, IllegalStateException {
        if(mInTag) {
            append(" />\n");
        } else {
            append("</");
            if(s != null) {
                append(s);
                append(':');
            }
            append(s1);
            append(">\n");
        }
        mInTag = false;
        return this;
    }

    public void entityRef(String s) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void flush() throws IOException {
        if(mPos > 0) {
            if(mOutputStream != null) {
                CharBuffer charbuffer = CharBuffer.wrap(mText, 0, mPos);
                CoderResult coderresult = mCharset.encode(charbuffer, mBytes, true);
                do {
                    if(coderresult.isError())
                        throw new IOException(coderresult.toString());
                    if(!coderresult.isOverflow())
                        break;
                    flushBytes();
                    coderresult = mCharset.encode(charbuffer, mBytes, true);
                } while(true);
                flushBytes();
                mOutputStream.flush();
            } else {
                mWriter.write(mText, 0, mPos);
                mWriter.flush();
            }
            mPos = 0;
        }
    }

    public int getDepth() {
        throw new UnsupportedOperationException();
    }

    public boolean getFeature(String s) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getNamespace() {
        throw new UnsupportedOperationException();
    }

    public String getPrefix(String s, boolean flag) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    public Object getProperty(String s) {
        throw new UnsupportedOperationException();
    }

    public void ignorableWhitespace(String s) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void processingInstruction(String s) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void setFeature(String s, boolean flag) throws IllegalArgumentException, IllegalStateException {
        if(s.equals("http://xmlpull.org/v1/doc/features.html#indent-output"))
            return;
        else
            throw new UnsupportedOperationException();
    }

    public void setOutput(OutputStream outputstream, String s) throws IOException, IllegalArgumentException, IllegalStateException {
        if(outputstream == null)
            throw new IllegalArgumentException();
        try {
            mCharset = Charset.forName(s).newEncoder();
        }
        catch(IllegalCharsetNameException illegalcharsetnameexception) {
            throw (UnsupportedEncodingException)(UnsupportedEncodingException)(new UnsupportedEncodingException(s)).initCause(illegalcharsetnameexception);
        }
        catch(UnsupportedCharsetException unsupportedcharsetexception) {
            throw (UnsupportedEncodingException)(UnsupportedEncodingException)(new UnsupportedEncodingException(s)).initCause(unsupportedcharsetexception);
        }
        mOutputStream = outputstream;
    }

    public void setOutput(Writer writer) throws IOException, IllegalArgumentException, IllegalStateException {
        mWriter = writer;
    }

    public void setPrefix(String s, String s1) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void setProperty(String s, Object obj) throws IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void startDocument(String s, Boolean boolean1) throws IOException, IllegalArgumentException, IllegalStateException {
        StringBuilder stringbuilder = (new StringBuilder()).append("<?xml version='1.0' encoding='utf-8' standalone='");
        String s1;
        if(boolean1.booleanValue())
            s1 = "yes";
        else
            s1 = "no";
        append(stringbuilder.append(s1).append("' ?>\n").toString());
    }

    public XmlSerializer startTag(String s, String s1) throws IOException, IllegalArgumentException, IllegalStateException {
        if(mInTag)
            append(">\n");
        append('<');
        if(s != null) {
            append(s);
            append(':');
        }
        append(s1);
        mInTag = true;
        return this;
    }

    public XmlSerializer text(String s) throws IOException, IllegalArgumentException, IllegalStateException {
        if(mInTag) {
            append(">");
            mInTag = false;
        }
        escapeAndAppendString(s);
        return this;
    }

    public XmlSerializer text(char ac[], int i, int j) throws IOException, IllegalArgumentException, IllegalStateException {
        if(mInTag) {
            append(">");
            mInTag = false;
        }
        escapeAndAppendString(ac, i, j);
        return this;
    }

    private static final int BUFFER_LEN = 8192;
    private static final String ESCAPE_TABLE[];
    private ByteBuffer mBytes;
    private CharsetEncoder mCharset;
    private boolean mInTag;
    private OutputStream mOutputStream;
    private int mPos;
    private final char mText[] = new char[8192];
    private Writer mWriter;

    static  {
        String as[] = new String[64];
        as[0] = null;
        as[1] = null;
        as[2] = null;
        as[3] = null;
        as[4] = null;
        as[5] = null;
        as[6] = null;
        as[7] = null;
        as[8] = null;
        as[9] = null;
        as[10] = null;
        as[11] = null;
        as[12] = null;
        as[13] = null;
        as[14] = null;
        as[15] = null;
        as[16] = null;
        as[17] = null;
        as[18] = null;
        as[19] = null;
        as[20] = null;
        as[21] = null;
        as[22] = null;
        as[23] = null;
        as[24] = null;
        as[25] = null;
        as[26] = null;
        as[27] = null;
        as[28] = null;
        as[29] = null;
        as[30] = null;
        as[31] = null;
        as[32] = null;
        as[33] = null;
        as[34] = "&quot;";
        as[35] = null;
        as[36] = null;
        as[37] = null;
        as[38] = "&amp;";
        as[39] = null;
        as[40] = null;
        as[41] = null;
        as[42] = null;
        as[43] = null;
        as[44] = null;
        as[45] = null;
        as[46] = null;
        as[47] = null;
        as[48] = null;
        as[49] = null;
        as[50] = null;
        as[51] = null;
        as[52] = null;
        as[53] = null;
        as[54] = null;
        as[55] = null;
        as[56] = null;
        as[57] = null;
        as[58] = null;
        as[59] = null;
        as[60] = "&lt;";
        as[61] = null;
        as[62] = "&gt;";
        as[63] = null;
        ESCAPE_TABLE = as;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.res;

import android.util.TypedValue;
import com.android.internal.util.XmlUtils;
import java.io.*;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package android.content.res:
//            StringBlock, AssetManager, XmlResourceParser

final class XmlBlock {
    final class Parser
        implements XmlResourceParser {

        public void close() {
            XmlBlock xmlblock = mBlock;
            xmlblock;
            JVM INSTR monitorenter ;
            if(mParseState != 0) {
                XmlBlock.nativeDestroyParseState(mParseState);
                mParseState = 0;
                mBlock.decOpenCountLocked();
            }
            return;
        }

        public void defineEntityReplacementText(String s, String s1) throws XmlPullParserException {
            throw new XmlPullParserException("defineEntityReplacementText() not supported");
        }

        protected void finalize() throws Throwable {
            close();
        }

        public boolean getAttributeBooleanValue(int i, boolean flag) {
            int j = XmlBlock.nativeGetAttributeDataType(mParseState, i);
            boolean flag1;
            if(j >= 16 && j <= 31) {
                if(XmlBlock.nativeGetAttributeData(mParseState, i) != 0)
                    flag1 = true;
                else
                    flag1 = false;
            } else {
                flag1 = flag;
            }
            return flag1;
        }

        public boolean getAttributeBooleanValue(String s, String s1, boolean flag) {
            int i = XmlBlock.nativeGetAttributeIndex(mParseState, s, s1);
            if(i >= 0)
                flag = getAttributeBooleanValue(i, flag);
            return flag;
        }

        public int getAttributeCount() {
            int i;
            if(mEventType == 2)
                i = XmlBlock.nativeGetAttributeCount(mParseState);
            else
                i = -1;
            return i;
        }

        public float getAttributeFloatValue(int i, float f) {
            if(XmlBlock.nativeGetAttributeDataType(mParseState, i) == 4)
                return Float.intBitsToFloat(XmlBlock.nativeGetAttributeData(mParseState, i));
            else
                throw new RuntimeException("not a float!");
        }

        public float getAttributeFloatValue(String s, String s1, float f) {
            int i = XmlBlock.nativeGetAttributeIndex(mParseState, s, s1);
            if(i >= 0)
                f = getAttributeFloatValue(i, f);
            return f;
        }

        public int getAttributeIntValue(int i, int j) {
            int k = XmlBlock.nativeGetAttributeDataType(mParseState, i);
            if(k >= 16 && k <= 31)
                j = XmlBlock.nativeGetAttributeData(mParseState, i);
            return j;
        }

        public int getAttributeIntValue(String s, String s1, int i) {
            int j = XmlBlock.nativeGetAttributeIndex(mParseState, s, s1);
            if(j >= 0)
                i = getAttributeIntValue(j, i);
            return i;
        }

        public int getAttributeListValue(int i, String as[], int j) {
            int k = XmlBlock.nativeGetAttributeDataType(mParseState, i);
            int l = XmlBlock.nativeGetAttributeData(mParseState, i);
            if(k == 3)
                l = XmlUtils.convertValueToList(mStrings.get(l), as, j);
            return l;
        }

        public int getAttributeListValue(String s, String s1, String as[], int i) {
            int j = XmlBlock.nativeGetAttributeIndex(mParseState, s, s1);
            if(j >= 0)
                i = getAttributeListValue(j, as, i);
            return i;
        }

        public String getAttributeName(int i) {
            int j = XmlBlock.nativeGetAttributeName(mParseState, i);
            if(j >= 0)
                return mStrings.get(j).toString();
            else
                throw new IndexOutOfBoundsException(String.valueOf(i));
        }

        public int getAttributeNameResource(int i) {
            return XmlBlock.nativeGetAttributeResource(mParseState, i);
        }

        public String getAttributeNamespace(int i) {
            int j = XmlBlock.nativeGetAttributeNamespace(mParseState, i);
            String s;
            if(j >= 0)
                s = mStrings.get(j).toString();
            else
            if(j == -1)
                s = "";
            else
                throw new IndexOutOfBoundsException(String.valueOf(i));
            return s;
        }

        public String getAttributePrefix(int i) {
            throw new RuntimeException("getAttributePrefix not supported");
        }

        public int getAttributeResourceValue(int i, int j) {
            if(XmlBlock.nativeGetAttributeDataType(mParseState, i) == 1)
                j = XmlBlock.nativeGetAttributeData(mParseState, i);
            return j;
        }

        public int getAttributeResourceValue(String s, String s1, int i) {
            int j = XmlBlock.nativeGetAttributeIndex(mParseState, s, s1);
            if(j >= 0)
                i = getAttributeResourceValue(j, i);
            return i;
        }

        public String getAttributeType(int i) {
            return "CDATA";
        }

        public int getAttributeUnsignedIntValue(int i, int j) {
            int k = XmlBlock.nativeGetAttributeDataType(mParseState, i);
            if(k >= 16 && k <= 31)
                j = XmlBlock.nativeGetAttributeData(mParseState, i);
            return j;
        }

        public int getAttributeUnsignedIntValue(String s, String s1, int i) {
            int j = XmlBlock.nativeGetAttributeIndex(mParseState, s, s1);
            if(j >= 0)
                i = getAttributeUnsignedIntValue(j, i);
            return i;
        }

        public String getAttributeValue(int i) {
            int j = XmlBlock.nativeGetAttributeStringValue(mParseState, i);
            String s;
            if(j >= 0) {
                s = mStrings.get(j).toString();
            } else {
                int k = XmlBlock.nativeGetAttributeDataType(mParseState, i);
                if(k == 0)
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                s = TypedValue.coerceToString(k, XmlBlock.nativeGetAttributeData(mParseState, i));
            }
            return s;
        }

        public String getAttributeValue(String s, String s1) {
            int i = XmlBlock.nativeGetAttributeIndex(mParseState, s, s1);
            String s2;
            if(i >= 0)
                s2 = getAttributeValue(i);
            else
                s2 = null;
            return s2;
        }

        public String getClassAttribute() {
            int i = XmlBlock.nativeGetClassAttribute(mParseState);
            String s;
            if(i >= 0)
                s = mStrings.get(i).toString();
            else
                s = null;
            return s;
        }

        public int getColumnNumber() {
            return -1;
        }

        public int getDepth() {
            return mDepth;
        }

        public int getEventType() throws XmlPullParserException {
            return mEventType;
        }

        public boolean getFeature(String s) {
            boolean flag;
            flag = true;
            break MISSING_BLOCK_LABEL_2;
            if(!"http://xmlpull.org/v1/doc/features.html#process-namespaces".equals(s) && !"http://xmlpull.org/v1/doc/features.html#report-namespace-prefixes".equals(s))
                flag = false;
            return flag;
        }

        public String getIdAttribute() {
            int i = XmlBlock.nativeGetIdAttribute(mParseState);
            String s;
            if(i >= 0)
                s = mStrings.get(i).toString();
            else
                s = null;
            return s;
        }

        public int getIdAttributeResourceValue(int i) {
            return getAttributeResourceValue(null, "id", i);
        }

        public String getInputEncoding() {
            return null;
        }

        public int getLineNumber() {
            return XmlBlock.nativeGetLineNumber(mParseState);
        }

        public String getName() {
            int i = XmlBlock.nativeGetName(mParseState);
            String s;
            if(i >= 0)
                s = mStrings.get(i).toString();
            else
                s = null;
            return s;
        }

        public String getNamespace() {
            int i = XmlBlock.nativeGetNamespace(mParseState);
            String s;
            if(i >= 0)
                s = mStrings.get(i).toString();
            else
                s = "";
            return s;
        }

        public String getNamespace(String s) {
            throw new RuntimeException("getNamespace() not supported");
        }

        public int getNamespaceCount(int i) throws XmlPullParserException {
            throw new XmlPullParserException("getNamespaceCount() not supported");
        }

        public String getNamespacePrefix(int i) throws XmlPullParserException {
            throw new XmlPullParserException("getNamespacePrefix() not supported");
        }

        public String getNamespaceUri(int i) throws XmlPullParserException {
            throw new XmlPullParserException("getNamespaceUri() not supported");
        }

        final CharSequence getPooledString(int i) {
            return mStrings.get(i);
        }

        public String getPositionDescription() {
            return (new StringBuilder()).append("Binary XML file line #").append(getLineNumber()).toString();
        }

        public String getPrefix() {
            throw new RuntimeException("getPrefix not supported");
        }

        public Object getProperty(String s) {
            return null;
        }

        public int getStyleAttribute() {
            return XmlBlock.nativeGetStyleAttribute(mParseState);
        }

        public String getText() {
            int i = XmlBlock.nativeGetText(mParseState);
            String s;
            if(i >= 0)
                s = mStrings.get(i).toString();
            else
                s = null;
            return s;
        }

        public char[] getTextCharacters(int ai[]) {
            String s = getText();
            char ac[] = null;
            if(s != null) {
                ai[0] = 0;
                ai[1] = s.length();
                ac = new char[s.length()];
                s.getChars(0, s.length(), ac, 0);
            }
            return ac;
        }

        public boolean isAttributeDefault(int i) {
            return false;
        }

        public boolean isEmptyElementTag() throws XmlPullParserException {
            return false;
        }

        public boolean isWhitespace() throws XmlPullParserException {
            return false;
        }

        public int next() throws XmlPullParserException, IOException {
            if(mStarted) goto _L2; else goto _L1
_L1:
            int i;
            mStarted = true;
            i = 0;
_L4:
            return i;
_L2:
            if(mParseState == 0) {
                i = 1;
                continue; /* Loop/switch isn't completed */
            }
            i = XmlBlock.nativeNext(mParseState);
            if(mDecNextDepth) {
                mDepth = -1 + mDepth;
                mDecNextDepth = false;
            }
            switch(i) {
            default:
                break;

            case 2: // '\002'
                break; /* Loop/switch isn't completed */

            case 3: // '\003'
                break;
            }
            break MISSING_BLOCK_LABEL_114;
_L5:
            mEventType = i;
            if(i == 1)
                close();
            if(true) goto _L4; else goto _L3
_L3:
            mDepth = 1 + mDepth;
              goto _L5
            mDecNextDepth = true;
              goto _L5
        }

        public int nextTag() throws XmlPullParserException, IOException {
            int i = next();
            if(i == 4 && isWhitespace())
                i = next();
            if(i != 2 && i != 3)
                throw new XmlPullParserException((new StringBuilder()).append(getPositionDescription()).append(": expected start or end tag").toString(), this, null);
            else
                return i;
        }

        public String nextText() throws XmlPullParserException, IOException {
label0:
            {
                if(getEventType() != 2)
                    throw new XmlPullParserException((new StringBuilder()).append(getPositionDescription()).append(": parser must be on START_TAG to read next text").toString(), this, null);
                int i = next();
                String s;
                if(i == 4) {
                    s = getText();
                    if(next() != 3)
                        throw new XmlPullParserException((new StringBuilder()).append(getPositionDescription()).append(": event TEXT it must be immediately followed by END_TAG").toString(), this, null);
                } else {
                    if(i != 3)
                        break label0;
                    s = "";
                }
                return s;
            }
            throw new XmlPullParserException((new StringBuilder()).append(getPositionDescription()).append(": parser must be on START_TAG or TEXT to read text").toString(), this, null);
        }

        public int nextToken() throws XmlPullParserException, IOException {
            return next();
        }

        public void require(int i, String s, String s1) throws XmlPullParserException, IOException {
            if(i != getEventType() || s != null && !s.equals(getNamespace()) || s1 != null && !s1.equals(getName()))
                throw new XmlPullParserException((new StringBuilder()).append("expected ").append(TYPES[i]).append(getPositionDescription()).toString());
            else
                return;
        }

        public void setFeature(String s, boolean flag) throws XmlPullParserException {
            while("http://xmlpull.org/v1/doc/features.html#process-namespaces".equals(s) && flag || "http://xmlpull.org/v1/doc/features.html#report-namespace-prefixes".equals(s) && flag) 
                return;
            throw new XmlPullParserException((new StringBuilder()).append("Unsupported feature: ").append(s).toString());
        }

        public void setInput(InputStream inputstream, String s) throws XmlPullParserException {
            throw new XmlPullParserException("setInput() not supported");
        }

        public void setInput(Reader reader) throws XmlPullParserException {
            throw new XmlPullParserException("setInput() not supported");
        }

        public void setProperty(String s, Object obj) throws XmlPullParserException {
            throw new XmlPullParserException("setProperty() not supported");
        }

        private final XmlBlock mBlock;
        private boolean mDecNextDepth;
        private int mDepth;
        private int mEventType;
        int mParseState;
        private boolean mStarted;
        final XmlBlock this$0;

        Parser(int i, XmlBlock xmlblock1) {
            this$0 = XmlBlock.this;
            super();
            mStarted = false;
            mDecNextDepth = false;
            mDepth = 0;
            mEventType = 0;
            mParseState = i;
            mBlock = xmlblock1;
            int i = ((Object) (this)).Object;
        }
    }


    XmlBlock(AssetManager assetmanager, int i) {
        mOpen = true;
        mOpenCount = 1;
        mAssets = assetmanager;
        mNative = i;
        mStrings = new StringBlock(nativeGetStringBlock(i), false);
    }

    public XmlBlock(byte abyte0[]) {
        mOpen = true;
        mOpenCount = 1;
        mAssets = null;
        mNative = nativeCreate(abyte0, 0, abyte0.length);
        mStrings = new StringBlock(nativeGetStringBlock(mNative), false);
    }

    public XmlBlock(byte abyte0[], int i, int j) {
        mOpen = true;
        mOpenCount = 1;
        mAssets = null;
        mNative = nativeCreate(abyte0, i, j);
        mStrings = new StringBlock(nativeGetStringBlock(mNative), false);
    }

    private void decOpenCountLocked() {
        mOpenCount = -1 + mOpenCount;
        if(mOpenCount == 0) {
            nativeDestroy(mNative);
            if(mAssets != null)
                mAssets.xmlBlockGone(hashCode());
        }
    }

    private static final native int nativeCreate(byte abyte0[], int i, int j);

    private static final native int nativeCreateParseState(int i);

    private static final native void nativeDestroy(int i);

    private static final native void nativeDestroyParseState(int i);

    private static final native int nativeGetAttributeCount(int i);

    private static final native int nativeGetAttributeData(int i, int j);

    private static final native int nativeGetAttributeDataType(int i, int j);

    private static final native int nativeGetAttributeIndex(int i, String s, String s1);

    private static final native int nativeGetAttributeName(int i, int j);

    private static final native int nativeGetAttributeNamespace(int i, int j);

    private static final native int nativeGetAttributeResource(int i, int j);

    private static final native int nativeGetAttributeStringValue(int i, int j);

    private static final native int nativeGetClassAttribute(int i);

    private static final native int nativeGetIdAttribute(int i);

    private static final native int nativeGetLineNumber(int i);

    static final native int nativeGetName(int i);

    private static final native int nativeGetNamespace(int i);

    private static final native int nativeGetStringBlock(int i);

    private static final native int nativeGetStyleAttribute(int i);

    private static final native int nativeGetText(int i);

    static final native int nativeNext(int i);

    public void close() {
        this;
        JVM INSTR monitorenter ;
        if(mOpen) {
            mOpen = false;
            decOpenCountLocked();
        }
        return;
    }

    protected void finalize() throws Throwable {
        close();
    }

    public XmlResourceParser newParser() {
        this;
        JVM INSTR monitorenter ;
        Parser parser;
        if(mNative != 0)
            parser = new Parser(nativeCreateParseState(mNative), this);
        else
            parser = null;
        return parser;
    }

    private static final boolean DEBUG;
    private final AssetManager mAssets;
    private final int mNative;
    private boolean mOpen;
    private int mOpenCount;
    final StringBlock mStrings;


/*
    static int access$008(XmlBlock xmlblock) {
        int i = xmlblock.mOpenCount;
        xmlblock.mOpenCount = i + 1;
        return i;
    }

*/
















}

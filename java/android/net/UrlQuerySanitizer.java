// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import java.util.*;

public class UrlQuerySanitizer {
    public static class IllegalCharacterValueSanitizer
        implements ValueSanitizer {

        private boolean characterIsLegal(char c) {
            boolean flag = true;
            c;
            JVM INSTR lookupswitch 13: default 116
        //                       0: 266
        //                       9: 160
        //                       10: 160
        //                       11: 160
        //                       12: 160
        //                       13: 160
        //                       32: 146
        //                       34: 174
        //                       37: 250
        //                       38: 234
        //                       39: 189
        //                       60: 204
        //                       62: 219;
               goto _L1 _L2 _L3 _L3 _L3 _L3 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
            if((c < ' ' || c >= '\177') && (c < '\200' || (4 & mFlags) == 0))
                flag = false;
_L12:
            return flag;
_L4:
            if((1 & mFlags) == 0)
                flag = false;
            continue; /* Loop/switch isn't completed */
_L3:
            if((2 & mFlags) == 0)
                flag = false;
            continue; /* Loop/switch isn't completed */
_L5:
            if((8 & mFlags) == 0)
                flag = false;
            continue; /* Loop/switch isn't completed */
_L8:
            if((0x10 & mFlags) == 0)
                flag = false;
            continue; /* Loop/switch isn't completed */
_L9:
            if((0x20 & mFlags) == 0)
                flag = false;
            continue; /* Loop/switch isn't completed */
_L10:
            if((0x40 & mFlags) == 0)
                flag = false;
            continue; /* Loop/switch isn't completed */
_L7:
            if((0x80 & mFlags) == 0)
                flag = false;
            continue; /* Loop/switch isn't completed */
_L6:
            if((0x100 & mFlags) == 0)
                flag = false;
            continue; /* Loop/switch isn't completed */
_L2:
            if((0x200 & mFlags) == 0)
                flag = false;
            if(true) goto _L12; else goto _L11
_L11:
        }

        private boolean isWhitespace(char c) {
            c;
            JVM INSTR lookupswitch 6: default 60
        //                       9: 64
        //                       10: 64
        //                       11: 64
        //                       12: 64
        //                       13: 64
        //                       32: 64;
               goto _L1 _L2 _L2 _L2 _L2 _L2 _L2
_L1:
            boolean flag = false;
_L4:
            return flag;
_L2:
            flag = true;
            if(true) goto _L4; else goto _L3
_L3:
        }

        private String trimWhitespace(String s) {
            int i = 0;
            int j = -1 + s.length();
            int k;
            for(k = j; i <= k && isWhitespace(s.charAt(i)); i++);
            for(; k >= i && isWhitespace(s.charAt(k)); k--);
            if(i != 0 || k != j)
                s = s.substring(i, k + 1);
            return s;
        }

        public String sanitize(String s) {
            if(s != null) goto _L2; else goto _L1
_L1:
            String s1 = null;
_L4:
            return s1;
_L2:
            int i = s.length();
            if((0x400 & mFlags) != 0 && i >= MIN_SCRIPT_PREFIX_LENGTH) {
                String s2 = s.toLowerCase();
                if(s2.startsWith("javascript:") || s2.startsWith("vbscript:")) {
                    s1 = "";
                    continue; /* Loop/switch isn't completed */
                }
            }
            if((3 & mFlags) == 0) {
                s = trimWhitespace(s);
                i = s.length();
            }
            StringBuilder stringbuilder = new StringBuilder(i);
            int j = 0;
            while(j < i)  {
                char c = s.charAt(j);
                if(!characterIsLegal(c))
                    if((1 & mFlags) != 0)
                        c = ' ';
                    else
                        c = '_';
                stringbuilder.append(c);
                j++;
            }
            s1 = stringbuilder.toString();
            if(true) goto _L4; else goto _L3
_L3:
        }

        public static final int ALL_BUT_NUL_AND_ANGLE_BRACKETS_LEGAL = 1439;
        public static final int ALL_BUT_NUL_LEGAL = 1535;
        public static final int ALL_BUT_WHITESPACE_LEGAL = 1532;
        public static final int ALL_ILLEGAL = 0;
        public static final int ALL_OK = 2047;
        public static final int ALL_WHITESPACE_OK = 3;
        public static final int AMP_AND_SPACE_LEGAL = 129;
        public static final int AMP_LEGAL = 128;
        public static final int AMP_OK = 128;
        public static final int DQUOTE_OK = 8;
        public static final int GT_OK = 64;
        private static final String JAVASCRIPT_PREFIX = "javascript:";
        public static final int LT_OK = 32;
        private static final int MIN_SCRIPT_PREFIX_LENGTH = 0;
        public static final int NON_7_BIT_ASCII_OK = 4;
        public static final int NUL_OK = 512;
        public static final int OTHER_WHITESPACE_OK = 2;
        public static final int PCT_OK = 256;
        public static final int SCRIPT_URL_OK = 1024;
        public static final int SPACE_LEGAL = 1;
        public static final int SPACE_OK = 1;
        public static final int SQUOTE_OK = 16;
        public static final int URL_AND_SPACE_LEGAL = 405;
        public static final int URL_LEGAL = 404;
        private static final String VBSCRIPT_PREFIX = "vbscript:";
        private int mFlags;

        static  {
            MIN_SCRIPT_PREFIX_LENGTH = Math.min("javascript:".length(), "vbscript:".length());
        }

        public IllegalCharacterValueSanitizer(int i) {
            mFlags = i;
        }
    }

    public static interface ValueSanitizer {

        public abstract String sanitize(String s);
    }

    public class ParameterValuePair {

        public String mParameter;
        public String mValue;
        final UrlQuerySanitizer this$0;

        public ParameterValuePair(String s, String s1) {
            this$0 = UrlQuerySanitizer.this;
            super();
            mParameter = s;
            mValue = s1;
        }
    }


    public UrlQuerySanitizer() {
        mSanitizers = new HashMap();
        mEntries = new HashMap();
        mEntriesList = new ArrayList();
        mUnregisteredParameterValueSanitizer = getAllIllegal();
    }

    public UrlQuerySanitizer(String s) {
        mSanitizers = new HashMap();
        mEntries = new HashMap();
        mEntriesList = new ArrayList();
        mUnregisteredParameterValueSanitizer = getAllIllegal();
        setAllowUnregisteredParamaters(true);
        parseUrl(s);
    }

    public static final ValueSanitizer getAllButNulAndAngleBracketsLegal() {
        return sAllButNulAndAngleBracketsLegal;
    }

    public static final ValueSanitizer getAllButNulLegal() {
        return sAllButNulLegal;
    }

    public static final ValueSanitizer getAllButWhitespaceLegal() {
        return sAllButWhitespaceLegal;
    }

    public static final ValueSanitizer getAllIllegal() {
        return sAllIllegal;
    }

    public static final ValueSanitizer getAmpAndSpaceLegal() {
        return sAmpAndSpaceLegal;
    }

    public static final ValueSanitizer getAmpLegal() {
        return sAmpLegal;
    }

    public static final ValueSanitizer getSpaceLegal() {
        return sSpaceLegal;
    }

    public static final ValueSanitizer getUrlAndSpaceLegal() {
        return sUrlAndSpaceLegal;
    }

    public static final ValueSanitizer getUrlLegal() {
        return sURLLegal;
    }

    protected void addSanitizedEntry(String s, String s1) {
        mEntriesList.add(new ParameterValuePair(s, s1));
        if(!mPreferFirstRepeatedParameter || !mEntries.containsKey(s))
            mEntries.put(s, s1);
    }

    protected void clear() {
        mEntries.clear();
        mEntriesList.clear();
    }

    protected int decodeHexDigit(char c) {
        int i;
        if(c >= '0' && c <= '9')
            i = c + -48;
        else
        if(c >= 'A' && c <= 'F')
            i = 10 + (c + -65);
        else
        if(c >= 'a' && c <= 'f')
            i = 10 + (c + -97);
        else
            i = -1;
        return i;
    }

    public boolean getAllowUnregisteredParamaters() {
        return mAllowUnregisteredParamaters;
    }

    public ValueSanitizer getEffectiveValueSanitizer(String s) {
        ValueSanitizer valuesanitizer = getValueSanitizer(s);
        if(valuesanitizer == null && mAllowUnregisteredParamaters)
            valuesanitizer = getUnregisteredParameterValueSanitizer();
        return valuesanitizer;
    }

    public List getParameterList() {
        return mEntriesList;
    }

    public Set getParameterSet() {
        return mEntries.keySet();
    }

    public boolean getPreferFirstRepeatedParameter() {
        return mPreferFirstRepeatedParameter;
    }

    public ValueSanitizer getUnregisteredParameterValueSanitizer() {
        return mUnregisteredParameterValueSanitizer;
    }

    public String getValue(String s) {
        return (String)mEntries.get(s);
    }

    public ValueSanitizer getValueSanitizer(String s) {
        return (ValueSanitizer)mSanitizers.get(s);
    }

    public boolean hasParameter(String s) {
        return mEntries.containsKey(s);
    }

    protected boolean isHexDigit(char c) {
        boolean flag;
        if(decodeHexDigit(c) >= 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    protected void parseEntry(String s, String s1) {
        String s2 = unescape(s);
        ValueSanitizer valuesanitizer = getEffectiveValueSanitizer(s2);
        if(valuesanitizer != null)
            addSanitizedEntry(s2, valuesanitizer.sanitize(unescape(s1)));
    }

    public void parseQuery(String s) {
        clear();
        StringTokenizer stringtokenizer = new StringTokenizer(s, "&");
        do {
            if(!stringtokenizer.hasMoreElements())
                break;
            String s1 = stringtokenizer.nextToken();
            if(s1.length() > 0) {
                int i = s1.indexOf('=');
                if(i < 0)
                    parseEntry(s1, "");
                else
                    parseEntry(s1.substring(0, i), s1.substring(i + 1));
            }
        } while(true);
    }

    public void parseUrl(String s) {
        int i = s.indexOf('?');
        String s1;
        if(i >= 0)
            s1 = s.substring(i + 1);
        else
            s1 = "";
        parseQuery(s1);
    }

    public void registerParameter(String s, ValueSanitizer valuesanitizer) {
        if(valuesanitizer == null)
            mSanitizers.remove(s);
        mSanitizers.put(s, valuesanitizer);
    }

    public void registerParameters(String as[], ValueSanitizer valuesanitizer) {
        int i = as.length;
        for(int j = 0; j < i; j++)
            mSanitizers.put(as[j], valuesanitizer);

    }

    public void setAllowUnregisteredParamaters(boolean flag) {
        mAllowUnregisteredParamaters = flag;
    }

    public void setPreferFirstRepeatedParameter(boolean flag) {
        mPreferFirstRepeatedParameter = flag;
    }

    public void setUnregisteredParameterValueSanitizer(ValueSanitizer valuesanitizer) {
        mUnregisteredParameterValueSanitizer = valuesanitizer;
    }

    public String unescape(String s) {
        int i = s.indexOf('%');
        if(i >= 0) goto _L2; else goto _L1
_L1:
        i = s.indexOf('+');
        if(i >= 0) goto _L2; else goto _L3
_L3:
        return s;
_L2:
        int j = s.length();
        StringBuilder stringbuilder = new StringBuilder(j);
        stringbuilder.append(s.substring(0, i));
        int k = i;
        while(k < j)  {
            char c = s.charAt(k);
            if(c == '+')
                c = ' ';
            else
            if(c == '%' && k + 2 < j) {
                char c1 = s.charAt(k + 1);
                char c2 = s.charAt(k + 2);
                if(isHexDigit(c1) && isHexDigit(c2)) {
                    c = (char)(16 * decodeHexDigit(c1) + decodeHexDigit(c2));
                    k += 2;
                }
            }
            stringbuilder.append(c);
            k++;
        }
        s = stringbuilder.toString();
        if(true) goto _L3; else goto _L4
_L4:
    }

    private static final ValueSanitizer sAllButNulAndAngleBracketsLegal = new IllegalCharacterValueSanitizer(1439);
    private static final ValueSanitizer sAllButNulLegal = new IllegalCharacterValueSanitizer(1535);
    private static final ValueSanitizer sAllButWhitespaceLegal = new IllegalCharacterValueSanitizer(1532);
    private static final ValueSanitizer sAllIllegal = new IllegalCharacterValueSanitizer(0);
    private static final ValueSanitizer sAmpAndSpaceLegal = new IllegalCharacterValueSanitizer(129);
    private static final ValueSanitizer sAmpLegal = new IllegalCharacterValueSanitizer(128);
    private static final ValueSanitizer sSpaceLegal = new IllegalCharacterValueSanitizer(1);
    private static final ValueSanitizer sURLLegal = new IllegalCharacterValueSanitizer(404);
    private static final ValueSanitizer sUrlAndSpaceLegal = new IllegalCharacterValueSanitizer(405);
    private boolean mAllowUnregisteredParamaters;
    private final HashMap mEntries;
    private final ArrayList mEntriesList;
    private boolean mPreferFirstRepeatedParameter;
    private final HashMap mSanitizers;
    private ValueSanitizer mUnregisteredParameterValueSanitizer;

}

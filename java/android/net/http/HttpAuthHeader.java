// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.http;


public class HttpAuthHeader {

    public HttpAuthHeader(String s) {
        if(s != null)
            parseHeader(s);
    }

    private void parseHeader(String s) {
        if(s != null) {
            String s1 = parseScheme(s);
            if(s1 != null && mScheme != 0)
                parseParameters(s1);
        }
    }

    private void parseParameter(String s) {
        if(s == null) goto _L2; else goto _L1
_L1:
        int i = s.indexOf('=');
        if(i < 0) goto _L2; else goto _L3
_L3:
        String s1;
        String s2;
        s1 = s.substring(0, i).trim();
        s2 = trimDoubleQuotesIfAny(s.substring(i + 1).trim());
        if(!s1.equalsIgnoreCase("realm")) goto _L5; else goto _L4
_L4:
        mRealm = s2;
_L2:
        return;
_L5:
        if(mScheme == 2)
            parseParameter(s1, s2);
        if(true) goto _L2; else goto _L6
_L6:
    }

    private void parseParameter(String s, String s1) {
        if(s == null || s1 == null) goto _L2; else goto _L1
_L1:
        if(!s.equalsIgnoreCase("nonce")) goto _L4; else goto _L3
_L3:
        mNonce = s1;
_L2:
        return;
_L4:
        if(s.equalsIgnoreCase("stale"))
            parseStale(s1);
        else
        if(s.equalsIgnoreCase("opaque"))
            mOpaque = s1;
        else
        if(s.equalsIgnoreCase("qop"))
            mQop = s1.toLowerCase();
        else
        if(s.equalsIgnoreCase("algorithm"))
            mAlgorithm = s1.toLowerCase();
        if(true) goto _L2; else goto _L5
_L5:
    }

    private void parseParameters(String s) {
        if(s != null)
            do {
                int i = s.indexOf(',');
                if(i < 0) {
                    parseParameter(s);
                } else {
                    parseParameter(s.substring(0, i));
                    s = s.substring(i + 1);
                }
            } while(i >= 0);
    }

    private String parseScheme(String s) {
        if(s == null) goto _L2; else goto _L1
_L1:
        int i = s.indexOf(' ');
        if(i < 0) goto _L2; else goto _L3
_L3:
        String s1;
        String s2 = s.substring(0, i).trim();
        if(s2.equalsIgnoreCase("Digest")) {
            mScheme = 2;
            mAlgorithm = "md5";
        } else
        if(s2.equalsIgnoreCase("Basic"))
            mScheme = 1;
        s1 = s.substring(i + 1);
_L5:
        return s1;
_L2:
        s1 = null;
        if(true) goto _L5; else goto _L4
_L4:
    }

    private void parseStale(String s) {
        if(s != null && s.equalsIgnoreCase("true"))
            mStale = true;
    }

    private static String trimDoubleQuotesIfAny(String s) {
        if(s != null) {
            int i = s.length();
            if(i > 2 && s.charAt(0) == '"' && s.charAt(i - 1) == '"')
                s = s.substring(1, i - 1);
        }
        return s;
    }

    public String getAlgorithm() {
        return mAlgorithm;
    }

    public String getNonce() {
        return mNonce;
    }

    public String getOpaque() {
        return mOpaque;
    }

    public String getPassword() {
        return mPassword;
    }

    public String getQop() {
        return mQop;
    }

    public String getRealm() {
        return mRealm;
    }

    public int getScheme() {
        return mScheme;
    }

    public boolean getStale() {
        return mStale;
    }

    public String getUsername() {
        return mUsername;
    }

    public boolean isBasic() {
        boolean flag = true;
        if(mScheme != flag)
            flag = false;
        return flag;
    }

    public boolean isDigest() {
        boolean flag;
        if(mScheme == 2)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isProxy() {
        return mIsProxy;
    }

    public boolean isSupportedScheme() {
        boolean flag = true;
        if(mRealm == null) goto _L2; else goto _L1
_L1:
        if(mScheme != flag) goto _L4; else goto _L3
_L3:
        return flag;
_L4:
        if(mScheme == 2) {
            if(!mAlgorithm.equals("md5") || mQop != null && !mQop.equals("auth"))
                flag = false;
            continue; /* Loop/switch isn't completed */
        }
_L2:
        flag = false;
        if(true) goto _L3; else goto _L5
_L5:
    }

    public void setPassword(String s) {
        mPassword = s;
    }

    public void setProxy() {
        mIsProxy = true;
    }

    public void setUsername(String s) {
        mUsername = s;
    }

    private static final String ALGORITHM_TOKEN = "algorithm";
    public static final int BASIC = 1;
    public static final String BASIC_TOKEN = "Basic";
    public static final int DIGEST = 2;
    public static final String DIGEST_TOKEN = "Digest";
    private static final String NONCE_TOKEN = "nonce";
    private static final String OPAQUE_TOKEN = "opaque";
    private static final String QOP_TOKEN = "qop";
    private static final String REALM_TOKEN = "realm";
    private static final String STALE_TOKEN = "stale";
    public static final int UNKNOWN;
    private String mAlgorithm;
    private boolean mIsProxy;
    private String mNonce;
    private String mOpaque;
    private String mPassword;
    private String mQop;
    private String mRealm;
    private int mScheme;
    private boolean mStale;
    private String mUsername;
}

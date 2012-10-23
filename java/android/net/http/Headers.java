// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.http;

import java.util.ArrayList;
import org.apache.http.HeaderElement;
import org.apache.http.message.BasicHeaderValueParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;

// Referenced classes of package android.net.http:
//            CharArrayBuffers

public final class Headers {
    public static interface HeaderCallback {

        public abstract void header(String s, String s1);
    }


    public Headers() {
        cookies = new ArrayList(2);
        mHeaders = new String[19];
        mExtraHeaderNames = new ArrayList(4);
        mExtraHeaderValues = new ArrayList(4);
        transferEncoding = 0L;
        contentLength = -1L;
        connectionType = 0;
    }

    private void setConnectionType(CharArrayBuffer chararraybuffer, int i) {
        if(!CharArrayBuffers.containsIgnoreCaseTrimmed(chararraybuffer, i, "Close")) goto _L2; else goto _L1
_L1:
        connectionType = 1;
_L4:
        return;
_L2:
        if(CharArrayBuffers.containsIgnoreCaseTrimmed(chararraybuffer, i, "Keep-Alive"))
            connectionType = 2;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public String getAcceptRanges() {
        return mHeaders[10];
    }

    public String getCacheControl() {
        return mHeaders[12];
    }

    public int getConnectionType() {
        return connectionType;
    }

    public String getContentDisposition() {
        return mHeaders[9];
    }

    public String getContentEncoding() {
        return mHeaders[3];
    }

    public long getContentLength() {
        return contentLength;
    }

    public String getContentType() {
        return mHeaders[2];
    }

    public String getEtag() {
        return mHeaders[14];
    }

    public String getExpires() {
        return mHeaders[11];
    }

    public void getHeaders(HeaderCallback headercallback) {
        for(int i = 0; i < 19; i++) {
            String s = mHeaders[i];
            if(s != null)
                headercallback.header(sHeaderNames[i], s);
        }

        int j = mExtraHeaderNames.size();
        for(int k = 0; k < j; k++)
            headercallback.header((String)mExtraHeaderNames.get(k), (String)mExtraHeaderValues.get(k));

    }

    public String getLastModified() {
        return mHeaders[13];
    }

    public String getLocation() {
        return mHeaders[5];
    }

    public String getPragma() {
        return mHeaders[16];
    }

    public String getProxyAuthenticate() {
        return mHeaders[8];
    }

    public String getRefresh() {
        return mHeaders[17];
    }

    public ArrayList getSetCookie() {
        return cookies;
    }

    public long getTransferEncoding() {
        return transferEncoding;
    }

    public String getWwwAuthenticate() {
        return mHeaders[7];
    }

    public String getXPermittedCrossDomainPolicies() {
        return mHeaders[18];
    }

    public void parseHeader(CharArrayBuffer chararraybuffer) {
        int i = CharArrayBuffers.setLowercaseIndexOf(chararraybuffer, 58);
        if(i != -1) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s = chararraybuffer.substringTrimmed(0, i);
        if(s.length() != 0) {
            int j = i + 1;
            String s1 = chararraybuffer.substringTrimmed(j, chararraybuffer.length());
            switch(s.hashCode()) {
            default:
                mExtraHeaderNames.add(s);
                mExtraHeaderValues.add(s1);
                break;

            case 1274458357: 
                if(s.equals("transfer-encoding")) {
                    mHeaders[0] = s1;
                    HeaderElement aheaderelement[] = BasicHeaderValueParser.DEFAULT.parseElements(chararraybuffer, new ParserCursor(j, chararraybuffer.length()));
                    int k = aheaderelement.length;
                    if("identity".equalsIgnoreCase(s1))
                        transferEncoding = -1L;
                    else
                    if(k > 0 && "chunked".equalsIgnoreCase(aheaderelement[k - 1].getName()))
                        transferEncoding = -2L;
                    else
                        transferEncoding = -1L;
                }
                break;

            case -1132779846: 
                if(s.equals("content-length")) {
                    mHeaders[1] = s1;
                    try {
                        contentLength = Long.parseLong(s1);
                    }
                    catch(NumberFormatException numberformatexception) { }
                }
                break;

            case 785670158: 
                if(s.equals("content-type"))
                    mHeaders[2] = s1;
                break;

            case 2095084583: 
                if(s.equals("content-encoding"))
                    mHeaders[3] = s1;
                break;

            case -775651618: 
                if(s.equals("connection")) {
                    mHeaders[4] = s1;
                    setConnectionType(chararraybuffer, j);
                }
                break;

            case 1901043637: 
                if(s.equals("location"))
                    mHeaders[5] = s1;
                break;

            case 285929373: 
                if(s.equals("proxy-connection")) {
                    mHeaders[6] = s1;
                    setConnectionType(chararraybuffer, j);
                }
                break;

            case -243037365: 
                if(s.equals("www-authenticate"))
                    mHeaders[7] = s1;
                break;

            case -301767724: 
                if(s.equals("proxy-authenticate"))
                    mHeaders[8] = s1;
                break;

            case -1267267485: 
                if(s.equals("content-disposition"))
                    mHeaders[9] = s1;
                break;

            case 1397189435: 
                if(s.equals("accept-ranges"))
                    mHeaders[10] = s1;
                break;

            case -1309235404: 
                if(s.equals("expires"))
                    mHeaders[11] = s1;
                break;

            case -208775662: 
                if(s.equals("cache-control"))
                    if(mHeaders[12] != null && mHeaders[12].length() > 0) {
                        StringBuilder stringbuilder = new StringBuilder();
                        String as[] = mHeaders;
                        as[12] = stringbuilder.append(as[12]).append(',').append(s1).toString();
                    } else {
                        mHeaders[12] = s1;
                    }
                break;

            case 150043680: 
                if(s.equals("last-modified"))
                    mHeaders[13] = s1;
                break;

            case 3123477: 
                if(s.equals("etag"))
                    mHeaders[14] = s1;
                break;

            case 1237214767: 
                if(s.equals("set-cookie")) {
                    mHeaders[15] = s1;
                    cookies.add(s1);
                }
                break;

            case -980228804: 
                if(s.equals("pragma"))
                    mHeaders[16] = s1;
                break;

            case 1085444827: 
                if(s.equals("refresh"))
                    mHeaders[17] = s1;
                break;

            case -1345594014: 
                if(s.equals("x-permitted-cross-domain-policies"))
                    mHeaders[18] = s1;
                break;
            }
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void setAcceptRanges(String s) {
        mHeaders[10] = s;
    }

    public void setCacheControl(String s) {
        mHeaders[12] = s;
    }

    public void setContentDisposition(String s) {
        mHeaders[9] = s;
    }

    public void setContentEncoding(String s) {
        mHeaders[3] = s;
    }

    public void setContentLength(long l) {
        contentLength = l;
    }

    public void setContentType(String s) {
        mHeaders[2] = s;
    }

    public void setEtag(String s) {
        mHeaders[14] = s;
    }

    public void setExpires(String s) {
        mHeaders[11] = s;
    }

    public void setLastModified(String s) {
        mHeaders[13] = s;
    }

    public void setLocation(String s) {
        mHeaders[5] = s;
    }

    public void setProxyAuthenticate(String s) {
        mHeaders[8] = s;
    }

    public void setWwwAuthenticate(String s) {
        mHeaders[7] = s;
    }

    public void setXPermittedCrossDomainPolicies(String s) {
        mHeaders[18] = s;
    }

    public static final String ACCEPT_RANGES = "accept-ranges";
    public static final String CACHE_CONTROL = "cache-control";
    public static final int CONN_CLOSE = 1;
    public static final String CONN_DIRECTIVE = "connection";
    public static final int CONN_KEEP_ALIVE = 2;
    public static final String CONTENT_DISPOSITION = "content-disposition";
    public static final String CONTENT_ENCODING = "content-encoding";
    public static final String CONTENT_LEN = "content-length";
    public static final String CONTENT_TYPE = "content-type";
    public static final String ETAG = "etag";
    public static final String EXPIRES = "expires";
    private static final int HASH_ACCEPT_RANGES = 0x53476b3b;
    private static final int HASH_CACHE_CONTROL = 0xf38e5612;
    private static final int HASH_CONN_DIRECTIVE = 0xd1c47ede;
    private static final int HASH_CONTENT_DISPOSITION = 0xb4770863;
    private static final int HASH_CONTENT_ENCODING = 0x7ce07427;
    private static final int HASH_CONTENT_LEN = 0xbc7b26ba;
    private static final int HASH_CONTENT_TYPE = 0x2ed4600e;
    private static final int HASH_ETAG = 0x2fa915;
    private static final int HASH_EXPIRES = 0xb1f6a734;
    private static final int HASH_LAST_MODIFIED = 0x8f17c20;
    private static final int HASH_LOCATION = 0x714f9fb5;
    private static final int HASH_PRAGMA = 0xc592e53c;
    private static final int HASH_PROXY_AUTHENTICATE = 0xee0363d4;
    private static final int HASH_PROXY_CONNECTION = 0x110aef9d;
    private static final int HASH_REFRESH = 0x40b292db;
    private static final int HASH_SET_COOKIE = 0x49be662f;
    private static final int HASH_TRANSFER_ENCODING = 0x4bf6b0f5;
    private static final int HASH_WWW_AUTHENTICATE = 0xf1838b4b;
    private static final int HASH_X_PERMITTED_CROSS_DOMAIN_POLICIES = 0xafcbdd62;
    private static final int HEADER_COUNT = 19;
    private static final int IDX_ACCEPT_RANGES = 10;
    private static final int IDX_CACHE_CONTROL = 12;
    private static final int IDX_CONN_DIRECTIVE = 4;
    private static final int IDX_CONTENT_DISPOSITION = 9;
    private static final int IDX_CONTENT_ENCODING = 3;
    private static final int IDX_CONTENT_LEN = 1;
    private static final int IDX_CONTENT_TYPE = 2;
    private static final int IDX_ETAG = 14;
    private static final int IDX_EXPIRES = 11;
    private static final int IDX_LAST_MODIFIED = 13;
    private static final int IDX_LOCATION = 5;
    private static final int IDX_PRAGMA = 16;
    private static final int IDX_PROXY_AUTHENTICATE = 8;
    private static final int IDX_PROXY_CONNECTION = 6;
    private static final int IDX_REFRESH = 17;
    private static final int IDX_SET_COOKIE = 15;
    private static final int IDX_TRANSFER_ENCODING = 0;
    private static final int IDX_WWW_AUTHENTICATE = 7;
    private static final int IDX_X_PERMITTED_CROSS_DOMAIN_POLICIES = 18;
    public static final String LAST_MODIFIED = "last-modified";
    public static final String LOCATION = "location";
    private static final String LOGTAG = "Http";
    public static final int NO_CONN_TYPE = 0;
    public static final long NO_CONTENT_LENGTH = -1L;
    public static final long NO_TRANSFER_ENCODING = 0L;
    public static final String PRAGMA = "pragma";
    public static final String PROXY_AUTHENTICATE = "proxy-authenticate";
    public static final String PROXY_CONNECTION = "proxy-connection";
    public static final String REFRESH = "refresh";
    public static final String SET_COOKIE = "set-cookie";
    public static final String TRANSFER_ENCODING = "transfer-encoding";
    public static final String WWW_AUTHENTICATE = "www-authenticate";
    public static final String X_PERMITTED_CROSS_DOMAIN_POLICIES = "x-permitted-cross-domain-policies";
    private static final String sHeaderNames[];
    private int connectionType;
    private long contentLength;
    private ArrayList cookies;
    private ArrayList mExtraHeaderNames;
    private ArrayList mExtraHeaderValues;
    private String mHeaders[];
    private long transferEncoding;

    static  {
        String as[] = new String[19];
        as[0] = "transfer-encoding";
        as[1] = "content-length";
        as[2] = "content-type";
        as[3] = "content-encoding";
        as[4] = "connection";
        as[5] = "location";
        as[6] = "proxy-connection";
        as[7] = "www-authenticate";
        as[8] = "proxy-authenticate";
        as[9] = "content-disposition";
        as[10] = "accept-ranges";
        as[11] = "expires";
        as[12] = "cache-control";
        as[13] = "last-modified";
        as[14] = "etag";
        as[15] = "set-cookie";
        as[16] = "pragma";
        as[17] = "refresh";
        as[18] = "x-permitted-cross-domain-policies";
        sHeaderNames = as;
    }
}

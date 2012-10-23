// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.http;

import android.net.ParseException;
import android.net.WebAddress;
import android.webkit.CookieManager;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import junit.framework.Assert;
import org.apache.commons.codec.binary.Base64;

// Referenced classes of package android.net.http:
//            Request, RequestQueue, Connection

public class RequestHandle {

    public RequestHandle(RequestQueue requestqueue, String s, WebAddress webaddress, String s1, Map map, InputStream inputstream, int i, 
            Request request) {
        mRedirectCount = 0;
        if(map == null)
            map = new HashMap();
        mHeaders = map;
        mBodyProvider = inputstream;
        mBodyLength = i;
        if(s1 == null)
            s1 = "GET";
        mMethod = s1;
        mUrl = s;
        mUri = webaddress;
        mRequestQueue = requestqueue;
        mRequest = request;
    }

    public RequestHandle(RequestQueue requestqueue, String s, WebAddress webaddress, String s1, Map map, InputStream inputstream, int i, 
            Request request, Connection connection) {
        this(requestqueue, s, webaddress, s1, map, inputstream, i, request);
        mConnection = connection;
    }

    private String H(String s) {
        if(s == null) goto _L2; else goto _L1
_L1:
        byte abyte0[] = MessageDigest.getInstance("MD5").digest(s.getBytes());
        if(abyte0 == null) goto _L2; else goto _L3
_L3:
        String s2 = bufferToHex(abyte0);
        String s1 = s2;
_L5:
        return s1;
        NoSuchAlgorithmException nosuchalgorithmexception;
        nosuchalgorithmexception;
        throw new RuntimeException(nosuchalgorithmexception);
_L2:
        s1 = null;
        if(true) goto _L5; else goto _L4
_L4:
    }

    private String KD(String s, String s1) {
        return H((new StringBuilder()).append(s).append(":").append(s1).toString());
    }

    public static String authorizationHeader(boolean flag) {
        String s;
        if(!flag)
            s = "Authorization";
        else
            s = "Proxy-Authorization";
        return s;
    }

    private String bufferToHex(byte abyte0[]) {
        char ac[] = new char[16];
        ac[0] = '0';
        ac[1] = '1';
        ac[2] = '2';
        ac[3] = '3';
        ac[4] = '4';
        ac[5] = '5';
        ac[6] = '6';
        ac[7] = '7';
        ac[8] = '8';
        ac[9] = '9';
        ac[10] = 'a';
        ac[11] = 'b';
        ac[12] = 'c';
        ac[13] = 'd';
        ac[14] = 'e';
        ac[15] = 'f';
        String s;
        if(abyte0 != null) {
            int i = abyte0.length;
            if(i > 0) {
                StringBuilder stringbuilder = new StringBuilder(i * 2);
                for(int j = 0; j < i; j++) {
                    byte byte0 = (byte)(0xf & abyte0[j]);
                    stringbuilder.append(ac[(byte)((0xf0 & abyte0[j]) >> 4)]);
                    stringbuilder.append(ac[byte0]);
                }

                s = stringbuilder.toString();
            } else {
                s = "";
            }
        } else {
            s = null;
        }
        return s;
    }

    public static String computeBasicAuthResponse(String s, String s1) {
        Assert.assertNotNull(s);
        Assert.assertNotNull(s1);
        return new String(Base64.encodeBase64((new StringBuilder()).append(s).append(':').append(s1).toString().getBytes()));
    }

    private String computeCnonce() {
        int i = (new Random()).nextInt();
        int j;
        if(i == 0x80000000)
            j = 0x7fffffff;
        else
            j = Math.abs(i);
        return Integer.toString(j, 16);
    }

    private String computeDigest(String s, String s1, String s2, String s3, String s4, String s5) {
        String s6;
        if(s3 == null)
            s6 = KD(H(s), (new StringBuilder()).append(s2).append(":").append(H(s1)).toString());
        else
        if(s3.equalsIgnoreCase("auth"))
            s6 = KD(H(s), (new StringBuilder()).append(s2).append(":").append(s4).append(":").append(s5).append(":").append(s3).append(":").append(H(s1)).toString());
        else
            s6 = null;
        return s6;
    }

    private String computeDigestAuthResponse(String s, String s1, String s2, String s3, String s4, String s5, String s6) {
        Assert.assertNotNull(s);
        Assert.assertNotNull(s1);
        Assert.assertNotNull(s2);
        String s7 = (new StringBuilder()).append(s).append(":").append(s2).append(":").append(s1).toString();
        String s8 = (new StringBuilder()).append(mMethod).append(":").append(mUrl).toString();
        String s9 = computeCnonce();
        String s10 = computeDigest(s7, s8, s3, s4, "00000001", s9);
        String s11 = (new StringBuilder()).append("").append("username=").append(doubleQuote(s)).append(", ").toString();
        String s12 = (new StringBuilder()).append(s11).append("realm=").append(doubleQuote(s2)).append(", ").toString();
        String s13 = (new StringBuilder()).append(s12).append("nonce=").append(doubleQuote(s3)).append(", ").toString();
        String s14 = (new StringBuilder()).append(s13).append("uri=").append(doubleQuote(mUrl)).append(", ").toString();
        String s15 = (new StringBuilder()).append(s14).append("response=").append(doubleQuote(s10)).toString();
        if(s6 != null)
            s15 = (new StringBuilder()).append(s15).append(", opaque=").append(doubleQuote(s6)).toString();
        if(s5 != null)
            s15 = (new StringBuilder()).append(s15).append(", algorithm=").append(s5).toString();
        if(s4 != null)
            s15 = (new StringBuilder()).append(s15).append(", qop=").append(s4).append(", nc=").append("00000001").append(", cnonce=").append(doubleQuote(s9)).toString();
        return s15;
    }

    private void createAndQueueNewRequest() {
        if(mConnection != null) {
            RequestHandle requesthandle = mRequestQueue.queueSynchronousRequest(mUrl, mUri, mMethod, mHeaders, mRequest.mEventHandler, mBodyProvider, mBodyLength);
            mRequest = requesthandle.mRequest;
            mConnection = requesthandle.mConnection;
            requesthandle.processRequest();
        } else {
            mRequest = mRequestQueue.queueRequest(mUrl, mUri, mMethod, mHeaders, mRequest.mEventHandler, mBodyProvider, mBodyLength).mRequest;
        }
    }

    private String doubleQuote(String s) {
        String s1;
        if(s != null)
            s1 = (new StringBuilder()).append("\"").append(s).append("\"").toString();
        else
            s1 = null;
        return s1;
    }

    private void setupAuthResponse() {
        try {
            if(mBodyProvider != null)
                mBodyProvider.reset();
        }
        catch(IOException ioexception) { }
        createAndQueueNewRequest();
    }

    public void cancel() {
        if(mRequest != null)
            mRequest.cancel();
    }

    public String getMethod() {
        return mMethod;
    }

    public int getRedirectCount() {
        return mRedirectCount;
    }

    public void handleSslErrorResponse(boolean flag) {
        if(mRequest != null)
            mRequest.handleSslErrorResponse(flag);
    }

    public boolean isRedirectMax() {
        boolean flag;
        if(mRedirectCount >= 16)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void pauseRequest(boolean flag) {
        if(mRequest != null)
            mRequest.setLoadingPaused(flag);
    }

    public void processRequest() {
        if(mConnection != null)
            mConnection.processRequests(mRequest);
    }

    public void setRedirectCount(int i) {
        mRedirectCount = i;
    }

    public void setupBasicAuthResponse(boolean flag, String s, String s1) {
        String s2 = computeBasicAuthResponse(s, s1);
        mHeaders.put(authorizationHeader(flag), (new StringBuilder()).append("Basic ").append(s2).toString());
        setupAuthResponse();
    }

    public void setupDigestAuthResponse(boolean flag, String s, String s1, String s2, String s3, String s4, String s5, 
            String s6) {
        String s7 = computeDigestAuthResponse(s, s1, s2, s3, s4, s5, s6);
        mHeaders.put(authorizationHeader(flag), (new StringBuilder()).append("Digest ").append(s7).toString());
        setupAuthResponse();
    }

    public boolean setupRedirect(String s, int i, Map map) {
        boolean flag;
        int j;
        flag = false;
        mHeaders.remove("Authorization");
        mHeaders.remove("Proxy-Authorization");
        j = 1 + mRedirectCount;
        mRedirectCount = j;
        if(j != 16) goto _L2; else goto _L1
_L1:
        mRequest.error(-9, 0x104011a);
_L3:
        return flag;
_L2:
        if(mUrl.startsWith("https:") && s.startsWith("http:"))
            mHeaders.remove("Referer");
        mUrl = s;
        String s1;
        try {
            mUri = new WebAddress(mUrl);
        }
        catch(ParseException parseexception) {
            parseexception.printStackTrace();
        }
        mHeaders.remove("Cookie");
        s1 = CookieManager.getInstance().getCookie(mUri);
        if(s1 != null && s1.length() > 0)
            mHeaders.put("Cookie", s1);
        if((i == 302 || i == 303) && mMethod.equals("POST"))
            mMethod = "GET";
        if(i != 307)
            break MISSING_BLOCK_LABEL_261;
        if(mBodyProvider != null)
            mBodyProvider.reset();
_L4:
        mHeaders.putAll(map);
        createAndQueueNewRequest();
        flag = true;
          goto _L3
        IOException ioexception;
        ioexception;
          goto _L3
        mHeaders.remove("Content-Type");
        mBodyProvider = null;
          goto _L4
    }

    public void waitUntilComplete() {
        mRequest.waitUntilComplete();
    }

    private static final String AUTHORIZATION_HEADER = "Authorization";
    public static final int MAX_REDIRECT_COUNT = 16;
    private static final String PROXY_AUTHORIZATION_HEADER = "Proxy-Authorization";
    private int mBodyLength;
    private InputStream mBodyProvider;
    private Connection mConnection;
    private Map mHeaders;
    private String mMethod;
    private int mRedirectCount;
    private Request mRequest;
    private RequestQueue mRequestQueue;
    private WebAddress mUri;
    private String mUrl;
}

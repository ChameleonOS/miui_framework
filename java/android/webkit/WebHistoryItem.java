// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.graphics.Bitmap;
import java.net.MalformedURLException;
import java.net.URL;

public class WebHistoryItem
    implements Cloneable {

    private WebHistoryItem(int i) {
        android/webkit/WebHistoryItem;
        JVM INSTR monitorenter ;
        int j = sNextId;
        sNextId = j + 1;
        mId = j;
        android/webkit/WebHistoryItem;
        JVM INSTR monitorexit ;
        mNativeBridge = i;
        nativeRef(mNativeBridge);
        return;
        Exception exception;
        exception;
        android/webkit/WebHistoryItem;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private WebHistoryItem(WebHistoryItem webhistoryitem) {
        mFlattenedData = webhistoryitem.mFlattenedData;
        mId = webhistoryitem.mId;
        mFavicon = webhistoryitem.mFavicon;
        mNativeBridge = webhistoryitem.mNativeBridge;
        if(mNativeBridge != 0)
            nativeRef(mNativeBridge);
    }

    WebHistoryItem(byte abyte0[]) {
        mFlattenedData = abyte0;
        android/webkit/WebHistoryItem;
        JVM INSTR monitorenter ;
        int i = sNextId;
        sNextId = i + 1;
        mId = i;
        return;
    }

    private native int inflate(int i, byte abyte0[]);

    private native Bitmap nativeGetFavicon(int i);

    private native byte[] nativeGetFlattenedData(int i);

    private native String nativeGetOriginalUrl(int i);

    private native String nativeGetTitle(int i);

    private native String nativeGetUrl(int i);

    private native void nativeRef(int i);

    private native void nativeUnref(int i);

    /**
     * @deprecated Method clone is deprecated
     */

    protected WebHistoryItem clone() {
        this;
        JVM INSTR monitorenter ;
        WebHistoryItem webhistoryitem = new WebHistoryItem(this);
        this;
        JVM INSTR monitorexit ;
        return webhistoryitem;
        Exception exception;
        exception;
        throw exception;
    }

    protected volatile Object clone() throws CloneNotSupportedException {
        return clone();
    }

    protected void finalize() throws Throwable {
        if(mNativeBridge != 0) {
            nativeUnref(mNativeBridge);
            mNativeBridge = 0;
        }
    }

    public Object getCustomData() {
        return mCustomData;
    }

    public Bitmap getFavicon() {
        if(mFavicon == null && mNativeBridge != 0)
            mFavicon = nativeGetFavicon(mNativeBridge);
        return mFavicon;
    }

    byte[] getFlattenedData() {
        byte abyte0[];
        if(mNativeBridge != 0)
            abyte0 = nativeGetFlattenedData(mNativeBridge);
        else
            abyte0 = mFlattenedData;
        return abyte0;
    }

    public int getId() {
        return mId;
    }

    public String getOriginalUrl() {
        String s;
        if(mNativeBridge == 0)
            s = null;
        else
            s = nativeGetOriginalUrl(mNativeBridge);
        return s;
    }

    public String getTitle() {
        String s;
        if(mNativeBridge == 0)
            s = null;
        else
            s = nativeGetTitle(mNativeBridge);
        return s;
    }

    public String getTouchIconUrl() {
        if(mTouchIconUrlFromLink == null) goto _L2; else goto _L1
_L1:
        String s = mTouchIconUrlFromLink;
_L4:
        return s;
_L2:
        if(mTouchIconUrlServerDefault != null) {
            s = mTouchIconUrlServerDefault;
            continue; /* Loop/switch isn't completed */
        }
        URL url = new URL(getOriginalUrl());
        mTouchIconUrlServerDefault = (new URL(url.getProtocol(), url.getHost(), url.getPort(), "/apple-touch-icon.png")).toString();
        s = mTouchIconUrlServerDefault;
        continue; /* Loop/switch isn't completed */
        MalformedURLException malformedurlexception;
        malformedurlexception;
        s = null;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public String getUrl() {
        String s;
        if(mNativeBridge == 0)
            s = null;
        else
            s = nativeGetUrl(mNativeBridge);
        return s;
    }

    void inflate(int i) {
        mNativeBridge = inflate(i, mFlattenedData);
        mFlattenedData = null;
    }

    public void setCustomData(Object obj) {
        mCustomData = obj;
    }

    void setFavicon(Bitmap bitmap) {
        mFavicon = bitmap;
    }

    void setTouchIconUrl(String s, boolean flag) {
        if(flag || mTouchIconUrlFromLink == null)
            mTouchIconUrlFromLink = s;
    }

    private static int sNextId = 0;
    private Object mCustomData;
    private Bitmap mFavicon;
    private byte mFlattenedData[];
    private final int mId;
    private int mNativeBridge;
    private String mTouchIconUrlFromLink;
    private String mTouchIconUrlServerDefault;

}

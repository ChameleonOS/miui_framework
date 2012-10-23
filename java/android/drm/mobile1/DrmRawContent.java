// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.drm.mobile1;

import java.io.*;

// Referenced classes of package android.drm.mobile1:
//            DrmException, DrmRights

public class DrmRawContent {
    class DrmInputStream extends InputStream {

        public int available() throws IOException {
            int i = nativeGetContentLength();
            if(-1 == i)
                throw new IOException();
            int j;
            if(-3 == i) {
                j = 0;
            } else {
                j = i - offset;
                if(j < 0)
                    throw new IOException();
            }
            return j;
        }

        public void close() {
            isClosed = true;
        }

        public void mark(int i) {
        }

        public boolean markSupported() {
            return false;
        }

        public int read() throws IOException {
            int i = -1;
            if(i != read(b, 0, 1))
                i = 0xff & b[0];
            return i;
        }

        public int read(byte abyte0[]) throws IOException {
            return read(abyte0, 0, abyte0.length);
        }

        public int read(byte abyte0[], int i, int j) throws IOException {
            int k;
            k = -1;
            if(abyte0 == null)
                throw new NullPointerException();
            if(i < 0 || j < 0 || i + j > abyte0.length)
                throw new IndexOutOfBoundsException();
            if(isClosed)
                throw new IOException();
            if(j != 0) goto _L2; else goto _L1
_L1:
            k = 0;
_L4:
            return k;
_L2:
            int l = nativeReadContent(abyte0, i, j, offset);
            if(k == l)
                throw new IOException();
            if(-2 != l) {
                offset = l + offset;
                k = l;
            }
            if(true) goto _L4; else goto _L3
_L3:
        }

        public void reset() throws IOException {
            throw new IOException();
        }

        public long skip(long l) throws IOException {
            return 0L;
        }

        private byte b[];
        private boolean isClosed;
        private int offset;
        final DrmRawContent this$0;

        public DrmInputStream(DrmRights drmrights) {
            this$0 = DrmRawContent.this;
            super();
            isClosed = false;
            offset = 0;
            b = new byte[1];
        }
    }


    public DrmRawContent(InputStream inputstream, int i, String s) throws DrmException, IOException {
        id = -1;
        inData = new BufferedInputStream(inputstream, 1024);
        inDataLen = i;
        byte byte0;
        if("application/vnd.oma.drm.message".equals(s))
            byte0 = 1;
        else
        if("application/vnd.oma.drm.content".equals(s))
            byte0 = 2;
        else
            throw new IllegalArgumentException("mimeType must be DRM_MIMETYPE_MESSAGE or DRM_MIMETYPE_CONTENT");
        if(i <= 0)
            throw new IllegalArgumentException("len must be > 0");
        id = nativeConstructDrmContent(inData, inDataLen, byte0);
        if(-1 == id)
            throw new DrmException("nativeConstructDrmContent() returned JNI_DRM_FAILURE");
        rightsIssuer = nativeGetRightsAddress();
        rawType = nativeGetDeliveryMethod();
        if(-1 == rawType)
            throw new DrmException("nativeGetDeliveryMethod() returned JNI_DRM_FAILURE");
        mediaType = nativeGetContentType();
        if(mediaType == null)
            throw new DrmException("nativeGetContentType() returned null");
        else
            return;
    }

    private native int nativeConstructDrmContent(InputStream inputstream, int i, int j);

    private native int nativeGetContentLength();

    private native String nativeGetContentType();

    private native int nativeGetDeliveryMethod();

    private native String nativeGetRightsAddress();

    private native int nativeReadContent(byte abyte0[], int i, int j, int k);

    protected native void finalize();

    public InputStream getContentInputStream(DrmRights drmrights) {
        if(drmrights == null)
            throw new NullPointerException();
        else
            return new DrmInputStream(drmrights);
    }

    public int getContentLength(DrmRights drmrights) throws DrmException {
        if(drmrights == null)
            throw new NullPointerException();
        int i = nativeGetContentLength();
        if(-1 == i)
            throw new DrmException("nativeGetContentLength() returned JNI_DRM_FAILURE");
        if(-3 == i)
            i = -1;
        return i;
    }

    public String getContentType() {
        return mediaType;
    }

    public int getRawType() {
        return rawType;
    }

    public String getRightsAddress() {
        return rightsIssuer;
    }

    public static final int DRM_COMBINED_DELIVERY = 2;
    public static final int DRM_FORWARD_LOCK = 1;
    private static final int DRM_MIMETYPE_CONTENT = 2;
    public static final String DRM_MIMETYPE_CONTENT_STRING = "application/vnd.oma.drm.content";
    private static final int DRM_MIMETYPE_MESSAGE = 1;
    public static final String DRM_MIMETYPE_MESSAGE_STRING = "application/vnd.oma.drm.message";
    public static final int DRM_SEPARATE_DELIVERY = 3;
    public static final int DRM_SEPARATE_DELIVERY_DM = 4;
    public static final int DRM_UNKNOWN_DATA_LEN = -1;
    private static final int JNI_DRM_EOF = -2;
    private static final int JNI_DRM_FAILURE = -1;
    private static final int JNI_DRM_SUCCESS = 0;
    private static final int JNI_DRM_UNKNOWN_DATA_LEN = -3;
    private int id;
    private BufferedInputStream inData;
    private int inDataLen;
    private String mediaType;
    private int rawType;
    private String rightsIssuer;

    static  {
        System.loadLibrary("drm1_jni");
_L1:
        return;
        UnsatisfiedLinkError unsatisfiedlinkerror;
        unsatisfiedlinkerror;
        System.err.println("WARNING: Could not load libdrm1_jni.so");
          goto _L1
    }


}

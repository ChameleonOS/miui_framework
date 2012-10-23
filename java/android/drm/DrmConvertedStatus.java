// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.drm;


public class DrmConvertedStatus {

    public DrmConvertedStatus(int i, byte abyte0[], int j) {
        if(!isValidStatusCode(i)) {
            throw new IllegalArgumentException((new StringBuilder()).append("Unsupported status code: ").append(i).toString());
        } else {
            statusCode = i;
            convertedData = abyte0;
            offset = j;
            return;
        }
    }

    private boolean isValidStatusCode(int i) {
        boolean flag = true;
        if(i != flag && i != 2 && i != 3)
            flag = false;
        return flag;
    }

    public static final int STATUS_ERROR = 3;
    public static final int STATUS_INPUTDATA_ERROR = 2;
    public static final int STATUS_OK = 1;
    public final byte convertedData[];
    public final int offset;
    public final int statusCode;
}

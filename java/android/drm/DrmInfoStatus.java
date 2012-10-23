// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.drm;


// Referenced classes of package android.drm:
//            DrmInfoRequest, ProcessedData

public class DrmInfoStatus {

    public DrmInfoStatus(int i, int j, ProcessedData processeddata, String s) {
        if(!DrmInfoRequest.isValidType(j))
            throw new IllegalArgumentException((new StringBuilder()).append("infoType: ").append(j).toString());
        if(!isValidStatusCode(i))
            throw new IllegalArgumentException((new StringBuilder()).append("Unsupported status code: ").append(i).toString());
        if(s == null || s == "") {
            throw new IllegalArgumentException("mimeType is null or an empty string");
        } else {
            statusCode = i;
            infoType = j;
            data = processeddata;
            mimeType = s;
            return;
        }
    }

    private boolean isValidStatusCode(int i) {
        boolean flag = true;
        if(i != flag && i != 2)
            flag = false;
        return flag;
    }

    public static final int STATUS_ERROR = 2;
    public static final int STATUS_OK = 1;
    public final ProcessedData data;
    public final int infoType;
    public final String mimeType;
    public final int statusCode;
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.drm;

import java.io.File;
import java.io.IOException;

// Referenced classes of package android.drm:
//            ProcessedData, DrmUtils

public class DrmRights {

    public DrmRights(ProcessedData processeddata, String s) {
        if(processeddata == null)
            throw new IllegalArgumentException("data is null");
        mData = processeddata.getData();
        mAccountId = processeddata.getAccountId();
        mSubscriptionId = processeddata.getSubscriptionId();
        mMimeType = s;
        if(!isValid())
            throw new IllegalArgumentException((new StringBuilder()).append("mimeType: ").append(mMimeType).append(",").append("data: ").append(mData).toString());
        else
            return;
    }

    public DrmRights(File file, String s) {
        instantiate(file, s);
    }

    public DrmRights(String s, String s1) {
        instantiate(new File(s), s1);
    }

    public DrmRights(String s, String s1, String s2) {
        this(s, s1);
        mAccountId = s2;
    }

    public DrmRights(String s, String s1, String s2, String s3) {
        this(s, s1);
        mAccountId = s2;
        mSubscriptionId = s3;
    }

    private void instantiate(File file, String s) {
        try {
            mData = DrmUtils.readBytes(file);
        }
        catch(IOException ioexception) {
            ioexception.printStackTrace();
        }
        mMimeType = s;
        if(!isValid())
            throw new IllegalArgumentException((new StringBuilder()).append("mimeType: ").append(mMimeType).append(",").append("data: ").append(mData).toString());
        else
            return;
    }

    public String getAccountId() {
        return mAccountId;
    }

    public byte[] getData() {
        return mData;
    }

    public String getMimeType() {
        return mMimeType;
    }

    public String getSubscriptionId() {
        return mSubscriptionId;
    }

    boolean isValid() {
        boolean flag;
        if(mMimeType != null && !mMimeType.equals("") && mData != null && mData.length > 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private String mAccountId;
    private byte mData[];
    private String mMimeType;
    private String mSubscriptionId;
}

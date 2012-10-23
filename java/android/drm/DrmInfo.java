// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.drm;

import java.io.IOException;
import java.util.*;

// Referenced classes of package android.drm:
//            DrmUtils, DrmInfoRequest

public class DrmInfo {

    public DrmInfo(int i, String s, String s1) {
        mAttributes = new HashMap();
        mInfoType = i;
        mMimeType = s1;
        try {
            mData = DrmUtils.readBytes(s);
        }
        catch(IOException ioexception) {
            mData = null;
        }
        if(!isValid()) {
            (new StringBuilder()).append("infoType: ").append(i).append(",").append("mimeType: ").append(s1).append(",").append("data: ").append(mData).toString();
            throw new IllegalArgumentException();
        } else {
            return;
        }
    }

    public DrmInfo(int i, byte abyte0[], String s) {
        mAttributes = new HashMap();
        mInfoType = i;
        mMimeType = s;
        mData = abyte0;
        if(!isValid())
            throw new IllegalArgumentException((new StringBuilder()).append("infoType: ").append(i).append(",").append("mimeType: ").append(s).append(",").append("data: ").append(abyte0).toString());
        else
            return;
    }

    public Object get(String s) {
        return mAttributes.get(s);
    }

    public byte[] getData() {
        return mData;
    }

    public int getInfoType() {
        return mInfoType;
    }

    public String getMimeType() {
        return mMimeType;
    }

    boolean isValid() {
        boolean flag;
        if(mMimeType != null && !mMimeType.equals("") && mData != null && mData.length > 0 && DrmInfoRequest.isValidType(mInfoType))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public Iterator iterator() {
        return mAttributes.values().iterator();
    }

    public Iterator keyIterator() {
        return mAttributes.keySet().iterator();
    }

    public void put(String s, Object obj) {
        mAttributes.put(s, obj);
    }

    private final HashMap mAttributes;
    private byte mData[];
    private final int mInfoType;
    private final String mMimeType;
}

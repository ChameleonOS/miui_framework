// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.drm;

import java.util.*;

public class DrmInfoRequest {

    public DrmInfoRequest(int i, String s) {
        mInfoType = i;
        mMimeType = s;
        if(!isValid())
            throw new IllegalArgumentException((new StringBuilder()).append("infoType: ").append(i).append(",").append("mimeType: ").append(s).toString());
        else
            return;
    }

    static boolean isValidType(int i) {
        boolean flag = false;
        i;
        JVM INSTR tableswitch 1 4: default 32
    //                   1 34
    //                   2 34
    //                   3 34
    //                   4 34;
           goto _L1 _L2 _L2 _L2 _L2
_L1:
        return flag;
_L2:
        flag = true;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public Object get(String s) {
        return mRequestInformation.get(s);
    }

    public int getInfoType() {
        return mInfoType;
    }

    public String getMimeType() {
        return mMimeType;
    }

    boolean isValid() {
        boolean flag;
        if(mMimeType != null && !mMimeType.equals("") && mRequestInformation != null && isValidType(mInfoType))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public Iterator iterator() {
        return mRequestInformation.values().iterator();
    }

    public Iterator keyIterator() {
        return mRequestInformation.keySet().iterator();
    }

    public void put(String s, Object obj) {
        mRequestInformation.put(s, obj);
    }

    public static final String ACCOUNT_ID = "account_id";
    public static final String SUBSCRIPTION_ID = "subscription_id";
    public static final int TYPE_REGISTRATION_INFO = 1;
    public static final int TYPE_RIGHTS_ACQUISITION_INFO = 3;
    public static final int TYPE_RIGHTS_ACQUISITION_PROGRESS_INFO = 4;
    public static final int TYPE_UNREGISTRATION_INFO = 2;
    private final int mInfoType;
    private final String mMimeType;
    private final HashMap mRequestInformation = new HashMap();
}

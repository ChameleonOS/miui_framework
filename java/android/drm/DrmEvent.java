// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.drm;

import java.util.HashMap;

public class DrmEvent {

    protected DrmEvent(int i, int j, String s) {
        mMessage = "";
        mAttributes = new HashMap();
        mUniqueId = i;
        mType = j;
        if(s != null)
            mMessage = s;
    }

    protected DrmEvent(int i, int j, String s, HashMap hashmap) {
        mMessage = "";
        mAttributes = new HashMap();
        mUniqueId = i;
        mType = j;
        if(s != null)
            mMessage = s;
        if(hashmap != null)
            mAttributes = hashmap;
    }

    public Object getAttribute(String s) {
        return mAttributes.get(s);
    }

    public String getMessage() {
        return mMessage;
    }

    public int getType() {
        return mType;
    }

    public int getUniqueId() {
        return mUniqueId;
    }

    public static final String DRM_INFO_OBJECT = "drm_info_object";
    public static final String DRM_INFO_STATUS_OBJECT = "drm_info_status_object";
    public static final int TYPE_ALL_RIGHTS_REMOVED = 1001;
    public static final int TYPE_DRM_INFO_PROCESSED = 1002;
    private HashMap mAttributes;
    private String mMessage;
    private final int mType;
    private final int mUniqueId;
}

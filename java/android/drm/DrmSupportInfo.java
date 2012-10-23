// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.drm;

import java.util.ArrayList;
import java.util.Iterator;

public class DrmSupportInfo {

    public DrmSupportInfo() {
        mDescription = "";
    }

    public void addFileSuffix(String s) {
        if(s == "") {
            throw new IllegalArgumentException("fileSuffix is an empty string");
        } else {
            mFileSuffixList.add(s);
            return;
        }
    }

    public void addMimeType(String s) {
        if(s == null)
            throw new IllegalArgumentException("mimeType is null");
        if(s == "") {
            throw new IllegalArgumentException("mimeType is an empty string");
        } else {
            mMimeTypeList.add(s);
            return;
        }
    }

    public boolean equals(Object obj) {
        boolean flag = false;
        if(obj instanceof DrmSupportInfo) {
            DrmSupportInfo drmsupportinfo = (DrmSupportInfo)obj;
            if(mFileSuffixList.equals(drmsupportinfo.mFileSuffixList) && mMimeTypeList.equals(drmsupportinfo.mMimeTypeList) && mDescription.equals(drmsupportinfo.mDescription))
                flag = true;
        }
        return flag;
    }

    public String getDescriprition() {
        return mDescription;
    }

    public String getDescription() {
        return mDescription;
    }

    public Iterator getFileSuffixIterator() {
        return mFileSuffixList.iterator();
    }

    public Iterator getMimeTypeIterator() {
        return mMimeTypeList.iterator();
    }

    public int hashCode() {
        return mFileSuffixList.hashCode() + mMimeTypeList.hashCode() + mDescription.hashCode();
    }

    boolean isSupportedFileSuffix(String s) {
        return mFileSuffixList.contains(s);
    }

    boolean isSupportedMimeType(String s) {
        int i;
        if(s == null || s.equals(""))
            break MISSING_BLOCK_LABEL_54;
        i = 0;
_L3:
        if(i >= mMimeTypeList.size())
            break MISSING_BLOCK_LABEL_54;
        if(!((String)mMimeTypeList.get(i)).startsWith(s)) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        i++;
          goto _L3
        flag = false;
          goto _L4
    }

    public void setDescription(String s) {
        if(s == null)
            throw new IllegalArgumentException("description is null");
        if(s == "") {
            throw new IllegalArgumentException("description is an empty string");
        } else {
            mDescription = s;
            return;
        }
    }

    private String mDescription;
    private final ArrayList mFileSuffixList = new ArrayList();
    private final ArrayList mMimeTypeList = new ArrayList();
}
